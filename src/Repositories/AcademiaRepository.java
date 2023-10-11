package Repositories;

import Entities.Academia;
import java.util.List;

public interface AcademiaRepository {
    public Academia create(Academia academia);
    public Academia buscarAcademiaPorNome(String nome);
    public List<Academia> buscarAcademias(String termo);
}
