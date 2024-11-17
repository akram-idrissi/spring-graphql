package ma.akram.inventory.inventoryservice.web;

import ma.akram.inventory.inventoryservice.dao.entities.Creator;
import ma.akram.inventory.inventoryservice.dao.entities.Video;
import ma.akram.inventory.inventoryservice.dao.repositories.CreatorRepository;
import ma.akram.inventory.inventoryservice.dao.repositories.VideoRepository;
import ma.akram.inventory.inventoryservice.dto.CreatorRequest;
import ma.akram.inventory.inventoryservice.dto.VideoRequest;
import ma.akram.inventory.inventoryservice.services.CreatorService;
import ma.akram.inventory.inventoryservice.services.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SubscriptionMapping;
import org.springframework.stereotype.Controller;
import reactor.core.publisher.Flux;

import java.util.List;
import java.util.Random;
import java.util.stream.Stream;

@Controller
public class VideoGraphQlController {

    private final CreatorRepository creatorRepository;
    private final VideoRepository videoRepository;

    @Autowired
    private CreatorService creatorService;

    @Autowired
    private VideoService videoService;
    VideoGraphQlController(CreatorRepository creatorRepository, VideoRepository videoRepository){
        this.creatorRepository = creatorRepository;
        this.videoRepository = videoRepository;
    }
    @QueryMapping
    public List<Video> videoList(){
        return videoRepository.findAll();
    }

    @QueryMapping
    public List<Creator> creatorList(){
        return creatorRepository.findAll();
    }

    @QueryMapping
    public Creator creatorById(@Argument Long id) {
        return creatorRepository.findById(id)
                .orElseThrow(()->new RuntimeException(String.format("Creator %s not found",id)));
    }

    @MutationMapping
    public Creator saveCreator(@Argument CreatorRequest creator){
        return creatorService.addCreator(creator);
    }
    @MutationMapping
    public Video saveVideo(@Argument VideoRequest video){
        return videoService.addVideo(video);
    }

    @SubscriptionMapping
    public Flux<Video> notifyVideoChange() {
        return Flux.fromStream(
                Stream.generate(() -> {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    CreatorRequest creatorRequest = CreatorRequest.builder().name("x" +
                            new Random().nextInt()).email("x@gmail.com").build();
                    Creator creator = creatorService.addCreator(creatorRequest);
                    Video video = videoService.findById(1L);
                    video.setCreator(creator);
                    videoService.updateVideo(video);
                    return video;
                }));
    }
}
