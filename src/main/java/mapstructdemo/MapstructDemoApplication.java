package mapstructdemo;

import mapstructdemo.dto.ProductDto;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MapstructDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(MapstructDemoApplication.class, args);

        ProductDto productDto = new ProductDto();

    }

}
