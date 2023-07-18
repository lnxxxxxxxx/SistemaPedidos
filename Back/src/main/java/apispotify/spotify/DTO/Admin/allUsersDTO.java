package apispotify.spotify.DTO.Admin;


import apispotify.spotify.Model.EnumROL;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class allUsersDTO {

  private Long id;
  private String nombre;
  private String email;
  private EnumROL rol;

}
