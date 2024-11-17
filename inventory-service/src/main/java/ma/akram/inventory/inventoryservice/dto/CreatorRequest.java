package ma.akram.inventory.inventoryservice.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class CreatorRequest {
    private String name;

    private String email;
}
