package com.hyeonjin.corespring.controller;

import com.hyeonjin.corespring.service.ProductService;
import com.hyeonjin.corespring.dto.ProductMypriceRequestDto;
import com.hyeonjin.corespring.dto.ProductRequestDto;
import com.hyeonjin.corespring.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.sql.SQLException;
import java.util.List;

@RestController // JSON으로 데이터를 주고받음을 선언합니다.
public class ProductController {
    // 멤버 변수 선언
    private final ProductService productService;

    // 생성자: ProductController() 가 생성될 때 호출됨
    @Autowired // ProductController가 생성될 때, productService의 내용을 스프링 IoC에 있는 객체를 DI 받는다.
    public ProductController(ProductService productService) {
        // 멤버 변수 생성
        this.productService = productService;
    }

    // 등록된 전체 상품 목록 조회
    @GetMapping("/api/products")
    public List<Product> getProducts(){
        List<Product> products = productService.getProducts();
        // 응답 보내기
        return products;
    }

    // 신규 상품 등록
    @PostMapping("/api/products")
    public Product createProduct(@RequestBody ProductRequestDto requestDto) {
      Product product = productService.createProduct(requestDto);
        // 응답 보내기
        return product;
    }

    // 설정 가격 변경
    @PutMapping("/api/products/{id}")
    public Long updateProduct(@PathVariable Long id, @RequestBody ProductMypriceRequestDto requestDto) throws SQLException {
        Product product = productService.updateProduct(id, requestDto);
        return product.getId();
    }
}