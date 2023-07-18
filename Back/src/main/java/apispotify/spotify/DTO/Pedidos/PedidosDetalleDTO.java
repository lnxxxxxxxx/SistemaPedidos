package apispotify.spotify.DTO.Pedidos;


import apispotify.spotify.Model.EnumROL;
import lombok.Data;

@Data
public class PedidosDetalleDTO extends PedidosDTO {
  private String email;
  private EnumROL rol;
}