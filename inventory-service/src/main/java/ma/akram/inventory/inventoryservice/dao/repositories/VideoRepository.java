package ma.akram.inventory.inventoryservice.dao.repositories;

import ma.akram.inventory.inventoryservice.dao.entities.Video;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VideoRepository extends JpaRepository<Video, Long> {
}
