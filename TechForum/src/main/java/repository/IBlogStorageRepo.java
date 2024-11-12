package repository;

import model.BlogStorage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface IBlogStorageRepo extends JpaRepository<BlogStorage, Integer> {
}
