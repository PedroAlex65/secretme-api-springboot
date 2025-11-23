package br.com.secretm.secret_api.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;

@Entity
@Table(name = "users")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nick;


    @Column(name = "create_at", updatable = false)
    private LocalDateTime createAt;

    @Column(nullable = false)
    private String secretToken;

    public Usuario() {
    }

    public Usuario(String nick) {
        this.nick = nick;

    }

    @PrePersist
    protected void onCreate() {
        this.createAt = LocalDateTime.now();
    }

    //GETTERS
    public Long getId() {
        return this.id;
    }

    public String getNick() {
        return this.nick;
    }

    public LocalDateTime getCreateAt() {
        return this.createAt;
    }

    public String getSecretToken() {
        return this.secretToken;
    }

    //SETTERS
    public void setId(Long id) {
        this.id = id;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public void setCreateAt(LocalDateTime createAt) {
        this.createAt = createAt;
    }

    public void setSecretToken(String secretToken) {
        this.secretToken = secretToken;
    }
}
