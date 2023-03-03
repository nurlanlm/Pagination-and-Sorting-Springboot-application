package com.nurlan.springbootpagination.service;

import com.nurlan.springbootpagination.dto.ProductDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;


public interface ProductService {

    ProductDto addProduct(ProductDto productDto);

    Page<ProductDto> getProductsPage(Integer pageNumber, Integer pageSize, String sortBy, String sortDir);

    List<ProductDto> searchProducts(String query);

//    Page<ProductDto> getProductsPage2(Pageable pageable);

}
