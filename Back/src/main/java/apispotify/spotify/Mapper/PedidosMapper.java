package apispotify.spotify.Mapper;


import apispotify.spotify.DTO.Pedidos.PedidosDTO;
import apispotify.spotify.Model.Pedidos;
import org.springframework.stereotype.Component;

@Component
public class PedidosMapper {
  public PedidosDTO toDto(Pedidos pedidos) {
    PedidosDTO pedidosDTO = new PedidosDTO();
    pedidosDTO.setIdPedido(pedidos.getIdPedido());
    pedidosDTO.setNombre(pedidos.getNombre());
    pedidosDTO.setApellido(pedidos.getApellido());
    pedidosDTO.setTelefono(pedidos.getTelefono());
    pedidosDTO.setProducto(pedidos.getProducto());
    pedidosDTO.setLugarDeEntrega(pedidos.getLugarDeEntrega());
    pedidosDTO.setProvincia(pedidos.getProvincia());
    pedidosDTO.setLocalidad(pedidos.getLocalidad());
    pedidosDTO.setCodigoPostal(pedidos.getCodigoPostal());
    pedidosDTO.setFormaDePago(pedidos.getFormaDePago());
    pedidosDTO.setHora(pedidos.getHora());
    pedidosDTO.setUsuarioID(pedidos.getUsuarioID());
    return pedidosDTO;
  }

  public Pedidos toModel(PedidosDTO pedidosDTO) {
    Pedidos pedidos = new Pedidos();
    pedidos.setIdPedido(pedidosDTO.getIdPedido());
    pedidos.setNombre(pedidosDTO.getNombre());
    pedidos.setApellido(pedidosDTO.getApellido());
    pedidos.setTelefono(pedidosDTO.getTelefono());
    pedidos.setProducto(pedidosDTO.getProducto());
    pedidos.setLugarDeEntrega(pedidosDTO.getLugarDeEntrega());
    pedidos.setProvincia(pedidosDTO.getProvincia());
    pedidos.setLocalidad(pedidosDTO.getLocalidad());
    pedidos.setCodigoPostal(pedidosDTO.getCodigoPostal());
    pedidos.setFormaDePago(pedidosDTO.getFormaDePago());
    pedidos.setHora(pedidosDTO.getHora());
    pedidos.setUsuarioID(pedidosDTO.getUsuarioID());
    return pedidos;
  }
}
