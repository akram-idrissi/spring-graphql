package ma.akram.inventory.inventoryservice.mapper;

import ma.akram.inventory.inventoryservice.dao.entities.Creator;
import ma.akram.inventory.inventoryservice.dto.CreatorRequest;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class CreatorMapper {
    ModelMapper mapper = new ModelMapper();


    public CreatorRequest fromCreatorToCreatorRequest(Creator creator){
        return mapper.map(creator, CreatorRequest.class);
    }

    public Creator fromCreatorRequestToCreator(CreatorRequest creatorRequest){
        return mapper.map(creatorRequest, Creator.class);
    }
}
