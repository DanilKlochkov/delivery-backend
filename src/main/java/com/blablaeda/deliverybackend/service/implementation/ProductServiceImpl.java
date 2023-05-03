package com.blablaeda.deliverybackend.service.implementation;

import com.blablaeda.deliverybackend.dto.ProductCreateDto;
import com.blablaeda.deliverybackend.postgres.entity.product.Product;
import com.blablaeda.deliverybackend.postgres.repository.product.ProductRepository;
import com.blablaeda.deliverybackend.service.product.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;

    @Override
    public Product create(ProductCreateDto productCreateDto) {
        return productRepository.save(
                Product.builder()
                        .name(productCreateDto.getName())
                        .description(productCreateDto.getDescription())
                        .price(productCreateDto.getPrice())
                        .proteins(productCreateDto.getProteins())
                        .fats(productCreateDto.getFats())
                        .carbohydrates(productCreateDto.getCarbohydrates())
                        .weight(productCreateDto.getWeight())
                        .producer(productCreateDto.getProducer())
                        .build()
        );
    }

    @Override
    public void delete(Long id) {
        productRepository.delete(findById(id));
    }

    @Override
    public Product findById(Long id) {
        return productRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }
}
