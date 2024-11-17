package ma.akram.inventory.inventoryservice.dto;

import lombok.*;
import ma.akram.inventory.inventoryservice.dao.entities.Creator;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class VideoRequest {
    private String name;

    private String url;

    private String description;

    private String datePublication;

    private Creator creator;
}
