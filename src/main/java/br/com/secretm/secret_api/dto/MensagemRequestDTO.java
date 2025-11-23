package br.com.secretm.secret_api.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class MensagemRequestDTO {

    @NotBlank(message = "A mensagem é obrigatória.")
    @Size(max = 500, message = "A mensagem não pode passar de 500 Caracteres")
    private String message;

    public MensagemRequestDTO() {
    }

    //Get
    public String getMessage() {
        return this.message;
    }
    //Set
    public  void setMessage(String message){
        this.message = message;
    }
}
