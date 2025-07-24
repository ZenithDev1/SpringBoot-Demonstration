package com.bitsnbytes.product.mapper;

import com.bitsnbytes.product.dto.CategoryDTO;
import com.bitsnbytes.product.entity.Category;

public class CategoryMapper {

    public static CategoryDTO toCategoryEntity(CategoryDTO categoryDTO) {
        if (category == null) {
            return null;
        }
        Category category = new Category();

        categoryDTO.setId(category.getId());
        category.setName(categoryDTO.getName());
        categoryDTO.setProducts(category.getProducts().stream().map(ProductMapper::toProductDTO).toList());

        return category;
    }
    public static Category toCategoryEntity(CategoryDTO categoryDTO){
        Category category = new Category();
        category.setName(categoryDTO.getName());
        return category;
    }

}
