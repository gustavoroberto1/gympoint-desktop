package DTO;

public class CriarAcademiaDTO {
    private final String nome;
    private final String telefone;
    private final String descricao;
    private final Double latitude;
    private final Double longitude;

    public CriarAcademiaDTO(String nome, String telefone, String descricao, Double latitude, Double longitude) {
        this.nome = nome;
        this.telefone = telefone;
        this.descricao = descricao;
        this.latitude = latitude;
        this.longitude = longitude;
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
    
    
}
