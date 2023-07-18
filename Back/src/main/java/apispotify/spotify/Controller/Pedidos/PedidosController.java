package apispotify.spotify.Controller.Pedidos;



import apispotify.spotify.DTO.Pedidos.PedidosDTO;
import apispotify.spotify.Service.iUsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pedido")
public class PedidosController {
  @Autowired
  private iUsersService userService;

  @PostMapping
  public ResponseEntity<PedidosDTO> create(@RequestBody PedidosDTO pedidosDTO) {
    try {
      System.out.println("Pedido recibido en el controlador: " + pedidosDTO);
      PedidosDTO pedidoCreate = userService.create(pedidosDTO);
      System.out.println("Pedido guardado en la base de datos: " + pedidoCreate);
      return ResponseEntity.status(HttpStatus.CREATED).body(pedidoCreate);
    } catch (RuntimeException ex) {
      return ResponseEntity.badRequest().build();
    }
  }
}
