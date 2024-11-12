package service.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.IUserRepo;

@Service
public class UserService implements IUserService{
    @Autowired
    private IUserRepo userRepo;
}
