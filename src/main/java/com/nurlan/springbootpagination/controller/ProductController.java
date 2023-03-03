package com.nurlan.springbootpagination.controller;

import com.nurlan.springbootpagination.dto.ProductDto;
import com.nurlan.springbootpagination.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping("/search")
    public ResponseEntity<List<ProductDto>> searchProducts(@RequestParam String query) {
        return ResponseEntity.ok(productService.searchProducts(query));
    }


    @GetMapping
    public ResponseEntity<Page<ProductDto>> getProductsPage(@RequestParam(defaultValue = "0") Integer pageNumber,
                                                            @RequestParam(defaultValue = "10") Integer pageSize,
                                                            @RequestParam(defaultValue = "name") String sortBy,
                                                            @RequestParam(defaultValue = "asc") String sortDir) {

        Page<ProductDto> productPage = productService.getProductsPage(pageNumber, pageSize, sortBy, sortDir);
        return ResponseEntity.ok(productPage);

    }

    @PostMapping("/add")
    public ResponseEntity<ProductDto> addProduct(@RequestBody ProductDto productDto) {
        return ResponseEntity.ok(productService.addProduct(productDto));
    }


//    @GetMapping("/p")
//    public ResponseEntity<Page<ProductDto>> getProductsPage2(Pageable pageable){
//        return ResponseEntity.ok(productService.getProductsPage2(pageable));
//    }


}
