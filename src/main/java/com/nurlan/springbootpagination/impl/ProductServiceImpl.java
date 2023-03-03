package com.nurlan.springbootpagination.impl;

import com.nurlan.springbootpagination.dto.ProductDto;
import com.nurlan.springbootpagination.entity.Product;
import com.nurlan.springbootpagination.repository.ProductRepository;
import com.nurlan.springbootpagination.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final ModelMapper modelMapper;


    @Override
    public List<ProductDto> searchProducts(String query) {

        return productRepository.searchProducts(query).stream()
                .map(product -> modelMapper.map(product, ProductDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public ProductDto addProduct(ProductDto productDto) {
        Product product = productRepository.save(modelMapper.map(productDto, Product.class));
        return modelMapper.map(product, ProductDto.class);
    }


    @Override
    public Page<ProductDto> getProductsPage(Integer pageNumber, Integer pageSize, String sortBy, String sortDir) {

        Sort sort = Sort.by(sortBy);
        if (sortDir.equals("desc")) sort = sort.descending();

        Pageable pageable = PageRequest.of(pageNumber, pageSize, sort);
        return productRepository.findAll(pageable).map(product -> modelMapper.map(product, ProductDto.class));
    }

//    @Override
//    public Page<ProductDto> getProductsPage2(Pageable pageable) {
//        return productRepository.findAll(pageable)
//                .map(product -> modelMapper.map(product, ProductDto.class));
//    }


}
