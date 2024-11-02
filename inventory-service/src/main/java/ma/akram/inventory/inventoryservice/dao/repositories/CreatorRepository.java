package ma.akram.inventory.inventoryservice.dao.repositories;

import ma.akram.inventory.inventoryservice.dao.entities.Creator;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CreatorRepository extends JpaRepository<Creator, Long> {
}
