package service.blogstorage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.IBlogStorageRepo;

@Service
public class BlogStorageService implements IBlogStorageService {
    @Autowired
    private IBlogStorageRepo blogStorageRepo;
}
