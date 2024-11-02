package ma.akram.inventory.inventoryservice;

import ma.akram.inventory.inventoryservice.dao.entities.Creator;
import ma.akram.inventory.inventoryservice.dao.entities.Video;
import ma.akram.inventory.inventoryservice.dao.repositories.CreatorRepository;
import ma.akram.inventory.inventoryservice.dao.repositories.VideoRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class InventoryServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(InventoryServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner initDatabase(CreatorRepository creatorRepository, VideoRepository videoRepository) {
        return args -> {
            Creator creator = new Creator();
            creator.setName("John Doe");
            creator.setEmail("john.doe@example.com");

            Video video1 = new Video();
            video1.setName("Introduction to Java");
            video1.setUrl("http://example.com/video1");
            video1.setDescription("A basic introduction to Java programming.");
            video1.setDatePublication("2024-01-01");
            video1.setCreator(creator);

            Video video2 = new Video();
            video2.setName("Spring Boot Tutorial");
            video2.setUrl("http://example.com/video2");
            video2.setDescription("A tutorial on how to build applications with Spring Boot.");
            video2.setDatePublication("2024-01-15");
            video2.setCreator(creator);

            creator.setVideos(List.of(video1, video2));

            creatorRepository.save(creator);
        };
    }
}
