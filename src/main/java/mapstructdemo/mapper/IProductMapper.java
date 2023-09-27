package mapstructdemo.mapper;

import mapstructdemo.dto.ProductDto;
import mapstructdemo.entities.ProductEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface IProductMapper {

    @Mapping(target = "creationDate", source = "creationDate", dateFormat = "dd-MM-yyyy")
    ProductDto toProductDto(ProductEntity productEntity);

    @InheritInverseConfiguration
    ProductEntity toProductEntity(ProductDto productDto);

    List<ProductDto> toProductDtoList(List<ProductEntity> productEntityList);

    List<ProductEntity> toProductEntityList(List<ProductDto> productDtoList);

}
