package br.aprendizado.projetotest.controller;

import br.aprendizado.projetotest.model.Usuario;
import br.aprendizado.projetotest.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/usuario")
    public Iterable <Usuario> findAll() {
        return usuarioService.findAll();
    }

    @PostMapping("/usuario")
    public ResponseEntity <Object> save(@RequestBody Usuario user) {
        try {
            Usuario usuario = usuarioService.save(user);
            return new ResponseEntity<>(usuario, HttpStatus.CREATED);
        } catch (DataIntegrityViolationException exception) {
            return new ResponseEntity<>(Map.of("mensagem", exception.getMessage()), HttpStatus.CONFLICT);
        }
    }

    @PutMapping("/usuario/{id}")
    public Usuario update(@PathVariable Long id, @RequestBody Usuario user) {
        user.setId(id);
        return usuarioService.save(user);
    }

    @DeleteMapping("/usuario/{id}")
    public void delete(@PathVariable Long id) {
        usuarioService.delete(id);
    }
}
