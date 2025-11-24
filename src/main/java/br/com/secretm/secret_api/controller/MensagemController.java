package br.com.secretm.secret_api.controller;

import br.com.secretm.secret_api.dto.MensagemRequestDTO;
import br.com.secretm.secret_api.model.Mensagem;
import br.com.secretm.secret_api.service.MensagemService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
<<<<<<< HEAD
@CrossOrigin(origins = "https://secretme-frontend-react.vercel.app")
=======
@CrossOrigin(origins = "https://secretme-frontend-react-e9to.vercel.app")
>>>>>>> 462553d88fef2fae1bfcaef132afdc4eb9f4189a
@RestController
@RequestMapping("/api/mensagens")
@ResponseStatus(HttpStatus.CREATED)
public class MensagemController {

    private final MensagemService mensagemService;

    public MensagemController(MensagemService mensagemService) {
        this.mensagemService = mensagemService;
    }


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Mensagem enviarMensagem(@RequestParam(name = "token") String secretToken, @RequestBody @Valid MensagemRequestDTO request) {
        // O Controller deve chamar request.getMessage()
        return mensagemService.enviarMensagem(secretToken, request.getMessage());
    }

    @GetMapping("/recebidas")
    public List<Mensagem> getMensagens(@RequestParam(name = "token", required = true) String secretToken) {
        return mensagemService.verMensagens(secretToken);
    }
}
