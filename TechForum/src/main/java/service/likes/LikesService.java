package service.likes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.ILikesRepo;

@Service
public class LikesService implements ILikesService{
    @Autowired
    private ILikesRepo likesRepo;
}
