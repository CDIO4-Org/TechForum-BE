package service.views;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.IViewsRepo;

@Service
public class ViewsService implements IViewsService{
    @Autowired
    private IViewsRepo viewsRepo;
}
