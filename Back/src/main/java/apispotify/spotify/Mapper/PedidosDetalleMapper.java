package apispotify.spotify.Mapper;


import apispotify.spotify.DTO.Pedidos.PedidosDetalleDTO;
import apispotify.spotify.Model.Pedidos;
import apispotify.spotify.Model.Users;
import org.springframework.stereotype.Component;

@Component
public class PedidosDetalleMapper {



  public PedidosDetalleDTO toDto(Pedidos pedidos, Users users) {
    PedidosDetalleDTO pedidosDetalleDTO = new PedidosDetalleDTO();
    pedidosDetalleDTO.setIdPedido(pedidos.getIdPedido());
    pedidosDetalleDTO.setNombre(pedidos.getNombre());
    pedidosDetalleDTO.setApellido(pedidos.getApellido());
    pedidosDetalleDTO.setTelefono(pedidos.getTelefono());
    pedidosDetalleDTO.setProducto(pedidos.getProducto());
    pedidosDetalleDTO.setLugarDeEntrega(pedidos.getLugarDeEntrega());
    pedidosDetalleDTO.setProvincia(pedidos.getProvincia());
    pedidosDetalleDTO.setLocalidad(pedidos.getLocalidad());
    pedidosDetalleDTO.setCodigoPostal(pedidos.getCodigoPostal());
    pedidosDetalleDTO.setFormaDePago(pedidos.getFormaDePago());
    pedidosDetalleDTO.setHora(pedidos.getHora());
    pedidosDetalleDTO.setUsuarioID(pedidos.getUsuarioID());
    pedidosDetalleDTO.setEmail(users.getEmail());
    pedidosDetalleDTO.setRol(users.getRol());
    return pedidosDetalleDTO;
  }

}
