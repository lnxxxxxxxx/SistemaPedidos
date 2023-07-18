package apispotify.spotify.Model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "pedidos")
public class Pedidos {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
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
