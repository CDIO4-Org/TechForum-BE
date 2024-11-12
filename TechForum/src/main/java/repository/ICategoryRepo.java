package repository;

import model.Categories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface ICategoryRepo extends JpaRepository<Categories, Integer> {
}
