package br.com.secretm.secret_api.service;

import br.com.secretm.secret_api.model.Usuario;
import br.com.secretm.secret_api.repository.UsuarioRepository;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UsuarioService {
    private final UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    private String gerarTokenSecreto() {
        return UUID.randomUUID().toString().replace("-", "").substring(0, 10);
    }

    //Criar Usuário
    public Usuario criarUsuario(String instagramHandle) {
        Usuario novoUsuario = new Usuario();
        novoUsuario.setNick(instagramHandle);

        novoUsuario.setSecretToken(gerarTokenSecreto());
        return this.usuarioRepository.save(novoUsuario);
    }
}
