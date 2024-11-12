package repository;

import model.Likes;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface ILikesRepo extends CrudRepository<Likes, Integer> {
}
