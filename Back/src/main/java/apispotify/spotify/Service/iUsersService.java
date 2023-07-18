package apispotify.spotify.Service;


import apispotify.spotify.DTO.Admin.allUsersDTO;
import apispotify.spotify.DTO.Pedidos.PedidosDTO;
import apispotify.spotify.DTO.Pedidos.PedidosDetalleDTO;
import apispotify.spotify.DTO.Registro.RegisterDTO;

import java.util.List;

public interface iUsersService {

  RegisterDTO create(RegisterDTO usersDTO);
  PedidosDTO create(PedidosDTO pedidosDTO);
  List<allUsersDTO> getUsers();
  List<PedidosDetalleDTO> getAllPedidosWithEmailAndRol();
  List<RegisterDTO> myUser();
  List<PedidosDetalleDTO> getAllPedidosByLoggedUser();



}
