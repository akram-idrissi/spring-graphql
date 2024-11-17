package ma.akram.inventory.inventoryservice.services;

import lombok.AllArgsConstructor;
import ma.akram.inventory.inventoryservice.dao.entities.Creator;
import ma.akram.inventory.inventoryservice.dao.repositories.CreatorRepository;
import ma.akram.inventory.inventoryservice.dto.CreatorRequest;
import ma.akram.inventory.inventoryservice.mapper.CreatorMapper;
import ma.akram.inventory.inventoryservice.services.manager.CreatorManager;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CreatorService implements CreatorManager {

    private CreatorMapper creatorMapper;
    private CreatorRepository creatorRepository;

    @Override
    public Creator addCreator(CreatorRequest creatorRequest) {
        return creatorRepository.save(creatorMapper.fromCreatorRequestToCreator(creatorRequest));
    }
}
