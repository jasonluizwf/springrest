package br.aprendizado.projetotest.repository;

import br.aprendizado.projetotest.model.Usuario;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends CrudRepository <Usuario, Long> {
}
