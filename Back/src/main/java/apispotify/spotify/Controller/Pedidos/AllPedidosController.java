package apispotify.spotify.Controller.Pedidos;


import apispotify.spotify.DTO.Pedidos.PedidosDetalleDTO;
import apispotify.spotify.Service.iUsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/pedidos")
public class AllPedidosController {

  @Autowired
  private iUsersService userService;

  @GetMapping
  public ResponseEntity<List<PedidosDetalleDTO>> getPedidosByRole() {
    Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
    boolean isAdmin = authentication.getAuthorities().stream()
        .anyMatch(role -> role.getAuthority().equals("ROLE_ADMIN"));

    List<PedidosDetalleDTO> pedidosDetalleDTOList;
    if (isAdmin) {
      pedidosDetalleDTOList = userService.getAllPedidosWithEmailAndRol();
    } else {
      pedidosDetalleDTOList = userService.getAllPedidosByLoggedUser();
    }

    return ResponseEntity.ok(pedidosDetalleDTOList);
  }
}
