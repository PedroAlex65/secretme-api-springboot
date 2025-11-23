package br.com.secretm.secret_api.service;

import br.com.secretm.secret_api.model.Mensagem;
import br.com.secretm.secret_api.model.Usuario;
import br.com.secretm.secret_api.repository.MensagemRepository;
import br.com.secretm.secret_api.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class MensagemService {

    private final UsuarioRepository usuarioRepository;
    private final MensagemRepository mensagemRepository;

    public MensagemService(UsuarioRepository usuarioRepository, MensagemRepository mensagemRepository) {
        this.mensagemRepository = mensagemRepository;
        this.usuarioRepository = usuarioRepository;

    }


    public Mensagem enviarMensagem(String secretToken, String content) {
        Optional<Usuario> destinatario = usuarioRepository.findBySecretToken(secretToken);

        if (destinatario.isPresent()) {
            //1. Apenas atribui o valor a ela
            Usuario pegandoUsuario = destinatario.get();

            //2. Lógica de criar e salvar a mensagem
            Mensagem novaMensagem = new Mensagem();
            novaMensagem.setMensagem(content);
            novaMensagem.setRecipient(pegandoUsuario);

            return mensagemRepository.save(novaMensagem);
        } else {
            throw new RuntimeException("Destinatário não encontrado ou token inválido.");
        }
    }

    public List<Mensagem> verMensagens(String secretToken) {

        Optional<Usuario> usuarioEncontrado = usuarioRepository.findBySecretToken(secretToken);

        if (usuarioEncontrado.isPresent()) {

            Usuario pegandoUsuario = usuarioEncontrado.get();

            List<Mensagem> mensagens = mensagemRepository.findByRecipient(pegandoUsuario);

            return mensagens;
        } else {
            throw new RuntimeException("Usuario não encontrado");
        }
    }
}
