package apispotify.spotify.Service.impl;



import apispotify.spotify.DTO.Admin.allUsersDTO;
import apispotify.spotify.DTO.Pedidos.PedidosDTO;
import apispotify.spotify.DTO.Pedidos.PedidosDetalleDTO;
import apispotify.spotify.DTO.Registro.RegisterDTO;
import apispotify.spotify.Mapper.PedidosDetalleMapper;
import apispotify.spotify.Mapper.PedidosMapper;
import apispotify.spotify.Mapper.RegisterMapper;
import apispotify.spotify.Mapper.allUsersMapper;
import apispotify.spotify.Model.Pedidos;
import apispotify.spotify.Model.Users;
import apispotify.spotify.Repository.PedidosRepository;
import apispotify.spotify.Repository.UsersRepository;
import apispotify.spotify.Service.iUsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UsersService implements iUsersService {

  @Autowired
  private UsersRepository usersRepository;

  @Autowired
  private PedidosRepository pedidosRepository;

  private RegisterMapper registerMapper;

  private PedidosDetalleMapper pedidosDetalleMapper;

  @Autowired
  public UsersService(RegisterMapper registerMapper, allUsersMapper allusersMapper, PedidosMapper pedidosMapper, PedidosDetalleMapper pedidosDetalleMapper) {
    this.registerMapper = registerMapper;
    this.allusersMapper = allusersMapper;
    this.pedidosMapper = pedidosMapper;
    this.pedidosDetalleMapper = pedidosDetalleMapper;
  }
  private PedidosMapper pedidosMapper;


  @Autowired
  private allUsersMapper allusersMapper;

  public RegisterDTO create(RegisterDTO usersDTO) {
    Optional<Users> existing_user = usersRepository.findByEmail(usersDTO.getEmail());
    if (existing_user.isPresent()) {
      throw new RuntimeException("Ya existe un usuario con el mismo email");
    }

    Users users = registerMapper.toModel(usersDTO);
    users = usersRepository.save(users);
    return registerMapper.toDto(users);
  }

  public PedidosDTO create(PedidosDTO pedidosDTO) {
    Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
    String userEmail = authentication.getName();

    // Buscar al usuario por email en el repositorio
    Optional<Users> optionalUser = usersRepository.findByEmail(userEmail);
    if (!optionalUser.isPresent()) {
      throw new RuntimeException("No se encontró al usuario autenticado");
    }
    Users user = optionalUser.get();
    Long userID = user.getId();


    // Asignar el UsuarioID del objeto Pedidos al ID del usuario autenticado
    pedidosDTO.setUsuarioID(userID);

    Pedidos pedidos = pedidosMapper.toModel(pedidosDTO);
    pedidos = pedidosRepository.save(pedidos);
    return pedidosMapper.toDto(pedidos);
  }

  public List<PedidosDetalleDTO> getAllPedidosWithEmailAndRol() {
    List<Pedidos> pedidos = pedidosRepository.findAll();
    List<Users> usersList = usersRepository.findAll();

    List<PedidosDetalleDTO> pedidosDetalleDTOList = new ArrayList<>();

    for (Pedidos pedido : pedidos) {
      Users user = getUserForPedido(pedido, usersList);
      PedidosDetalleDTO pedidoDetalleDTO = pedidosDetalleMapper.toDto(pedido, user);
      pedidosDetalleDTOList.add(pedidoDetalleDTO);
    }

    return pedidosDetalleDTOList;
  }

  private Users getUserForPedido(Pedidos pedido, List<Users> usersList) {
    for (Users user : usersList) {
      if (user.getId().equals(pedido.getUsuarioID())) {
        return user;
      }
    }
    return null;
  }

  public List<PedidosDetalleDTO> getAllPedidosByLoggedUser() {
    Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
    String userEmail = authentication.getName();

    Optional<Users> optionalUser = usersRepository.findByEmail(userEmail);
    if (!optionalUser.isPresent()) {
      throw new RuntimeException("No se encontró al usuario autenticado");
    }
    Users user = optionalUser.get();
    Long userId = user.getId();

    List<Pedidos> pedidos = pedidosRepository.findAllByUsuarioID(userId);

    return pedidos.stream()
        .map(pedido -> pedidosDetalleMapper.toDto(pedido, user))
        .collect(Collectors.toList());
  }



  public List<allUsersDTO> getUsers() {
    // Verificar autorización
    Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
    if (!authentication.getAuthorities().contains(new SimpleGrantedAuthority("ROLE_ADMIN"))) {
      throw new AccessDeniedException("Access is denied");
    }

    // Resto del código para obtener la lista de usuarios
    List<Users> usersList = usersRepository.findAll();
    List<allUsersDTO> usersDtoList = new ArrayList<>();

    for (Users users : usersList) {
      allUsersDTO usersDTO = allusersMapper.toDto(users);
      usersDtoList.add(usersDTO);
    }

    return usersDtoList;
  }

  public List<RegisterDTO> myUser() {
    // Obtener el email del usuario autenticado
    Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
    String userEmail = authentication.getName();

    // Buscar al usuario por email en el repositorio
    Optional<Users> optionalUser = usersRepository.findByEmail(userEmail);
    if (!optionalUser.isPresent()) {
      throw new RuntimeException("No se encontró al usuario autenticado");
    }

    // Convertir el usuario encontrado a DTO y devolverlo en una lista
    Users user = optionalUser.get();
    RegisterDTO userDTO = registerMapper.toDto(user);
    List<RegisterDTO> usersDtoList = new ArrayList<>();
    usersDtoList.add(userDTO);

    return usersDtoList;
  }

}
