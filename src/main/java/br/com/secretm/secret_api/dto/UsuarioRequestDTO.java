package br.com.secretm.secret_api.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class UsuarioRequestDTO {

    @NotBlank(message = "O apelido do Instagram é Obrigatório.")
    @Size(min = 3, max = 50, message = "O apelido deve  ter entre 3 a 50 caracteres.")
    private String nick;

    //Construtor, getters e setters
    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }


}
