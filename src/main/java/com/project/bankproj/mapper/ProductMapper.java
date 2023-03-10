package com.project.bankproj.mapper;

import com.project.bankproj.dto.ProductDto;
import com.project.bankproj.entity.Product;
import org.mapstruct.Mapper;
import java.util.List;


@Mapper(componentModel = "spring")
public interface ProductMapper {

    ProductDto toDto(Product product);

    Product toEntity(ProductDto productDto);

    List<ProductDto> productsToProductsDto(List<Product> products);
}
