package apispotify.spotify.DTO.Pedidos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PedidosDTO {
  private int idPedido;
  private String nombre;
  private String apellido;
  private int telefono;
  private String producto;
  private String lugarDeEntrega;
  private String provincia;
  private String localidad;
  private int codigoPostal;
  private String formaDePago;
  private Timestamp hora;
  private long usuarioID;
}
