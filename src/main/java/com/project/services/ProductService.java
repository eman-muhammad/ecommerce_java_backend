package com.project.services;


import com.project.database.Repository.ProductRepository;
import com.project.database.Entities.Image;
import com.project.database.Entities.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepo;

    public List<Product>FindAll(){
        return productRepo.findAll();
    }

    public Optional<Product> FindById(int id){
     return productRepo.findById(id);
    }

    public Product Save(Product product){
        return productRepo.save(product);
    }


    public void delete(int id){
        productRepo.deleteById(id);
    }

//    public Set<Image> UploadImage(MultipartFile[] multipartFiles)throws IOException {
//        Set<Image> images = new HashSet<>();
//        for (MultipartFile file : multipartFiles){
//            Image image = new Image(
//                    file.getOriginalFilename(),
//                    file.getBytes()
//            );
//            images.add(image);
//        }
//        return images;
//    }

        public List<Product> getByCategoryWomen(){
           return productRepo.FindProductByCategoryWomen();
    }

    public List<Product> getByCategoryMen(){
        return productRepo.FindProductByCategoryMen();
    }
}
