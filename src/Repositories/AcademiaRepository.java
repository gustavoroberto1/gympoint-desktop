package Repositories;

import Entities.Academia;

public interface AcademiaRepository {
    public Academia create(Academia academia);
    public Academia buscarAcademiaPorNome(String nome);
}
