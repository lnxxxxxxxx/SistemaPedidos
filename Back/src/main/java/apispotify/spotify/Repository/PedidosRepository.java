package apispotify.spotify.Repository;

import apispotify.spotify.Model.Pedidos;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface PedidosRepository extends JpaRepository<Pedidos, Long> {

  List<Pedidos> findAllByUsuarioID(Long usuarioID);

}
