package Repositories.InMemory;

import Entities.Academia;
import Repositories.AcademiaRepository;
import java.util.ArrayList;

public class InMemoryAcademiaRepository implements AcademiaRepository {
    private final ArrayList<Academia> academias = new ArrayList<>();
    
    @Override
    public Academia create(Academia academia) {
        academias.add(academia);
        return academia;
    }

    @Override
    public Academia buscarAcademiaPorNome(String nome) {
        for (Academia academia : academias) {
            if(academia.getNome().equals(nome)){
                return academia;
            }
        }
        return null;
    }
    
}
