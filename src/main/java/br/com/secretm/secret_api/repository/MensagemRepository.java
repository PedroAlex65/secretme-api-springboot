package br.com.secretm.secret_api.repository;

import br.com.secretm.secret_api.model.Mensagem;
import br.com.secretm.secret_api.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MensagemRepository extends JpaRepository<Mensagem, Long> {
    List<Mensagem> findByRecipient(Usuario recipient);
}
