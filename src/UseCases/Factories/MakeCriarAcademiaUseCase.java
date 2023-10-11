package UseCases.Factories;

import Repositories.AcademiaRepository;
import Repositories.Hibernate.HibernateAcademiaRepository;
import UseCases.CriarAcademiaUseCase;

public class MakeCriarAcademiaUseCase {
    public static CriarAcademiaUseCase make() {
        AcademiaRepository repo = new HibernateAcademiaRepository();
        return new CriarAcademiaUseCase(repo);
    }
}
