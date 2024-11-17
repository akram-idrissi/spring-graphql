package ma.akram.inventory.inventoryservice.mapper;

import ma.akram.inventory.inventoryservice.dao.entities.Video;
import ma.akram.inventory.inventoryservice.dto.VideoRequest;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class VideoMapper {
    ModelMapper mapper = new ModelMapper();


    public VideoRequest fromVideoToVideoRequest(Video Video){
        return mapper.map(Video, VideoRequest.class);
    }

    public Video fromVideoRequestToVideo(VideoRequest VideoRequest){
        return mapper.map(VideoRequest, Video.class);
    }
}
