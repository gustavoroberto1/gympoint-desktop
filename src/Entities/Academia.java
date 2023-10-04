package Entities;

import java.util.Date;
import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "academia")
public class Academia {
    
    @Id
    @Column(name = "id", columnDefinition = "UUID")
    private UUID id;
    
    @Column(name = "nome", unique = true)
    private String nome;
    
    @Column(name = "telefone", unique = true)
    private String telefone;
    
    @Column(name = "descricao")
    private String descricao;
    
    @Column(name = "latitude")
    private Double latitude;

    @Column(name = "longitude")
    private Double longitude;
    
    @Column(name = "data_criacao")
    @Temporal(TemporalType.TIMESTAMP)
    private Date data_criacao;

    public Academia() {}

    public Academia(String nome, String telefone, String descricao, Double latitude, Double longitude) {
        this.id = UUID.randomUUID();
        this.nome = nome;
        this.telefone = telefone;
        this.descricao = descricao;
        this.latitude = latitude;
        this.longitude = longitude;
        this.data_criacao = new Date();
    }

    public UUID getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getDescricao() {
        return descricao;
    }

    public Double getLatitude() {
        return latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public Date getData_criacao() {
        return data_criacao;
    }
}
