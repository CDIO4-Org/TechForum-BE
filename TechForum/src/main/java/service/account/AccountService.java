package service.account;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.IAccountRepo;

@Service
public class AccountService implements IAccountService {
    @Autowired
    private IAccountRepo accountRepo;
}
