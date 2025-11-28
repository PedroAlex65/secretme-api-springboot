package br.com.secretm.secret_api.controller;

import br.com.secretm.secret_api.dto.UsuarioRequestDTO;
import br.com.secretm.secret_api.model.Usuario;
import br.com.secretm.secret_api.service.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;
@CrossOrigin(origins = {
    "https://secretme-frontend-react.vercel.app", 
    "https://secretme-frontend-react-k2wwv5zvf-pedroalex65s-projects.vercel.app" 
})
@RestController
@RequestMapping("/usuario")
public class UsuarioController {
    //1. Injeção de Dependencia
    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    //2. Métdodo Posting
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Usuario postUsuario(@RequestBody @Valid UsuarioRequestDTO request) {
        return this.usuarioService.criarUsuario(request.getNick());
    }

     // 2. Método getNick completo
    @GetMapping("/usuario/nick")
    public String getNick(@RequestParam("token") String token) {

        return usuarioService.buscarUsuario(token)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "Token de usuário inválido."
                ))
                .getNick();
    }
}
