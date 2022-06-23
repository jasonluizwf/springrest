package br.aprendizado.projetotest.service;

import br.aprendizado.projetotest.model.Usuario;
import br.aprendizado.projetotest.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public Iterable <Usuario> findAll() {
        return usuarioRepository.findAll();
    }

    public Usuario save(Usuario user){
        return usuarioRepository.save(user);
    }

    public void delete(Long id) {
        usuarioRepository.deleteById(id);
    }
}
