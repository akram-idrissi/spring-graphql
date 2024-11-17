package ma.akram.inventory.inventoryservice.services;

import ma.akram.inventory.inventoryservice.dao.entities.Video;
import ma.akram.inventory.inventoryservice.dao.repositories.VideoRepository;
import ma.akram.inventory.inventoryservice.dto.VideoRequest;
import ma.akram.inventory.inventoryservice.mapper.VideoMapper;
import ma.akram.inventory.inventoryservice.services.manager.VideoManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VideoService implements VideoManager {

    @Autowired
    private VideoRepository videoRepository;

    @Autowired
    private VideoMapper videoMapper;
    @Override
    public Video addVideo(VideoRequest videoRequest) {
        return videoRepository.save(videoMapper.fromVideoRequestToVideo(videoRequest));
    }

    @Override
    public Video findById(Long id) {
        return videoRepository.findVideoById(id);
    }

    @Override
    public void updateVideo(Video video) {
        Video existingVideo = this.findById(video.getId());

        existingVideo.setName(video.getName());
        existingVideo.setUrl(video.getUrl());
        existingVideo.setDescription(video.getDescription());
        existingVideo.setDatePublication(video.getDatePublication());
        existingVideo.setCreator(video.getCreator());

        videoRepository.save(existingVideo);
    }
}
