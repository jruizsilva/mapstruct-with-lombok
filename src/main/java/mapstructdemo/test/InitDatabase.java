package mapstructdemo.test;

import mapstructdemo.dto.ProductDto;
import mapstructdemo.entities.ProductEntity;
import mapstructdemo.mapper.IProductMapper;
import mapstructdemo.repository.IProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class InitDatabase {
    private final IProductRepository iProductRepository;
    private final IProductMapper iProductMapper;

    public InitDatabase(IProductRepository iProductRepository, IProductMapper iProductMapper) {
        this.iProductRepository = iProductRepository;
        this.iProductMapper = iProductMapper;
    }

    @Bean
    public CommandLineRunner testProductMapperCommand() {
        return args -> {
            List<ProductEntity> productEntityList = iProductRepository.findAll();
            System.out.println("Response");
            productEntityList.forEach(System.out::println);
            System.out.println("DTO");
            List<ProductDto> productDtoList = iProductMapper.toProductDtoList(productEntityList);
            productDtoList.forEach(System.out::println);

            System.out.println("Entity");
            List<ProductEntity> productEntityList1 = iProductMapper.toProductEntityList(productDtoList);
            productEntityList1.forEach(System.out::println);
        };
    }
}
