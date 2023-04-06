package com.project.api;


import com.project.database.Entities.Product;
import com.project.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;
import org.springframework.web.bind.annotation.CrossOrigin;


@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping
    public List<Product>FindAll(){
        return productService.FindAll();
    }
    @GetMapping("/{id}")
    public Optional <Product>FindById(@PathVariable int id){
       return productService.FindById(id);
    }
    @PostMapping
    public void insert(@RequestBody Product product ){
        productService.Save(product);
    }


//    @PostMapping( consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
//    public Product insert(@RequestPart("product") Product product ,
//                       @RequestPart("imageFile")MultipartFile [] file){
//        try {
//            Set<Image> images = productService.UploadImage(file);
//            product.setProductImage(images);
//            return  productService.insert(product);
//        }catch (Exception e){
//            System.out.println( e.getMessage());
//            return  null;
//        }
//    }


    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id){
        productService.delete(id);
    }
    @GetMapping("/categoryWomen")
    public List<Product> getByCategoryWomen(){
    return productService.getByCategoryWomen();
    }

    @GetMapping("/categoryMen")
    public List<Product> getByCategoryMen(){
        return productService.getByCategoryMen();
    }

}
