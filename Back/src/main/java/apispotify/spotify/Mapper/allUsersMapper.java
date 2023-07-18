package apispotify.spotify.Mapper;


import apispotify.spotify.DTO.Admin.allUsersDTO;
import apispotify.spotify.Model.Users;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;


@Component
public class allUsersMapper {


    public allUsersDTO toDto(Users users) {
      allUsersDTO allusersDTO = new allUsersDTO();
      allusersDTO.setId(users.getId());
      allusersDTO.setNombre(users.getNombre());
      allusersDTO.setEmail(users.getEmail());
      allusersDTO.setRol(users.getRol());
      return allusersDTO;
    }

    public Users toModel(allUsersDTO allusersDTO) {
      Users users = new Users();
      users.setId(allusersDTO.getId());
      users.setNombre(allusersDTO.getNombre());
      users.setEmail(allusersDTO.getEmail());
      users.setRol(allusersDTO.getRol());
      return users;
    }




}
