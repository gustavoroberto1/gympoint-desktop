package UseCases.Factories;

import Repositories.AcademiaRepository;
import Repositories.Hibernate.HibernateAcademiaRepository;
import UseCases.BuscarAcademiasUseCase;

public class MakeBuscarAcademiasUseCase {
    public static BuscarAcademiasUseCase make() {
        AcademiaRepository repo = new HibernateAcademiaRepository();
        return new BuscarAcademiasUseCase(repo);
    }
}
