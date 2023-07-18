package apispotify.spotify.Controller.Admin;



import apispotify.spotify.DTO.Admin.allUsersDTO;
import apispotify.spotify.DTO.Registro.RegisterDTO;
import apispotify.spotify.Service.iUsersService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {

  @Autowired
  private static final Logger logger = LoggerFactory.getLogger(apispotify.spotify.Controller.User.UsersController.class);

  @Autowired
  private iUsersService userService;

  @GetMapping
  public ResponseEntity<List<allUsersDTO>> getUsers() {
    logger.info("Obteniendo el mensaje");

    var auth =  SecurityContextHolder.getContext().getAuthentication();
    logger.info("Datos del Usuario: {}", auth.getPrincipal());
    logger.info("Datos de los Roles {}", auth.getAuthorities());
    logger.info("Esta autenticado {}", auth.isAuthenticated());

    List<allUsersDTO> usersDtoList = userService.getUsers();
    return new ResponseEntity<>(usersDtoList, HttpStatus.OK);
  }


}
