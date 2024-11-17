package ma.akram.inventory.inventoryservice.services.manager;

import ma.akram.inventory.inventoryservice.dao.entities.Creator;
import ma.akram.inventory.inventoryservice.dao.entities.Video;
import ma.akram.inventory.inventoryservice.dto.CreatorRequest;
import ma.akram.inventory.inventoryservice.dto.VideoRequest;

public interface CreatorManager {
    Creator addCreator(CreatorRequest creatorRequest);
}
