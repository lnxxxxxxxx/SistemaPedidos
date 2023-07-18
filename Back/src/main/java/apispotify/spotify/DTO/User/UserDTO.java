package apispotify.spotify.DTO.User;

import apispotify.spotify.Model.EnumROL;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {

  private Long id;
  private String nombre;
  private String email;
  private String password;
  private EnumROL rol;
}
