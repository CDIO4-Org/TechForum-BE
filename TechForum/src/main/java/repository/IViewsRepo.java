package repository;

import model.Views;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface IViewsRepo extends JpaRepository<Views, Integer> {
}
