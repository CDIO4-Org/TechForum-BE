package service.image;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.IImageRepo;

@Service
public class ImageService implements IImageService{
    @Autowired
    private IImageRepo iImageRepo;
}
