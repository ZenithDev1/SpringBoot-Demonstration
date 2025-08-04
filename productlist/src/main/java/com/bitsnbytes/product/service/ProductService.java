package com.bitsnbytes.product.service;

import com.bitsnbytes.product.dto.ProductDTO;
import com.bitsnbytes.product.entity.Category;
import com.bitsnbytes.product.entity.Product;
import com.bitsnbytes.product.exception.CategoryNotFoundException;
import com.bitsnbytes.product.mapper.ProductMapper;
import com.bitsnbytes.product.repository.CategoryRepository;
import com.bitsnbytes.product.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ProductService {

    private CategoryRepository categoryRepository;
    private ProductRepository productRepository;


    public ProductDTO createProduct(ProductDTO productDTO){

        Category category = categoryRepository.findById(productDTO.getCategory_id())
                .orElseThrow(()-> new CategoryNotFoundException("Category id "
                        + productDTO.getCategory_id()+" not found"));

        // DTO can not be saved so DTO ---> entity
        Product product = ProductMapper.toProductEntity(productDTO, category);
        product = productRepository.save(product);

        return ProductMapper.toProductDTO(product);
    }

    //Get all Product

    public List<ProductDTO> getAllProducts(){
        return productRepository.findAll().stream().map(ProductMapper::toProductDTO).toList();
    }

    // get product by Id
    public ProductDTO getProductById(Long id){
        Product product = productRepository.findById(id).
                orElseThrow(() -> new RuntimeException("Product not Found!"));
        return ProductMapper.toProductDTO(product);
    }

    // update product
    public ProductDTO updateProduct(Long id, ProductDTO productDTO){
        Product product = productRepository.findById(id).
                orElseThrow(() -> new RuntimeException("Product not Found!"));
        Category category = categoryRepository.findById(productDTO.getCategory_id())
                .orElseThrow(() -> new RuntimeException("Category not found"));

        product.setName(productDTO.getName());
        product.setDescription(productDTO.getDescription());
        product.setPrice(productDTO.getPrice());
        product.setCategory(category);
        productRepository.save(product);
        return ProductMapper.toProductDTO(product);
    }

    //delete product
    public String deleteProduct(Long id){
        productRepository.deleteById(id);
        return "Product "+id+"has been deleted!";
    }

}