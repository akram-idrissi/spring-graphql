package ma.akram.inventory.inventoryservice.services.manager;

import ma.akram.inventory.inventoryservice.dao.entities.Video;
import ma.akram.inventory.inventoryservice.dto.VideoRequest;

public interface VideoManager {
    Video addVideo(VideoRequest videoRequest);
    Video findById(Long id);
    void updateVideo(Video video);
}
