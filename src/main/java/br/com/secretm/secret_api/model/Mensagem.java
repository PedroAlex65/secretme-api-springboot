package br.com.secretm.secret_api.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

import java.time.LocalDateTime;


@Entity
@Table(name = "messages")
public class Mensagem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;



    @Column(name = "message", nullable = false)
    private String mensagem;


    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private Usuario recipient;


    @Column(name = "dataEnvio", nullable = false)
    private LocalDateTime dataEnvio;

    public Mensagem() {

    }

    public Mensagem(String mensagem) {
        this.mensagem = mensagem;
    }


    @PrePersist
    protected void onCreate() {
        this.dataEnvio = LocalDateTime.now();
    }

    //Getters
    public Long getId() {
        return this.id;
    }

    public String getMensagem() {
        return this.mensagem;
    }

    public Usuario getRecipient() {
        return this.recipient;
    }

    public LocalDateTime getDataEnvio() {
        return this.dataEnvio;
    }

    //Setters
    public void setId(Long id) {
        this.id = id;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public void setRecipient(Usuario userId) {
        this.recipient = userId;
    }

    public void setDataEnvio(LocalDateTime dataEnvio) {
        this.dataEnvio = dataEnvio;
    }

}
