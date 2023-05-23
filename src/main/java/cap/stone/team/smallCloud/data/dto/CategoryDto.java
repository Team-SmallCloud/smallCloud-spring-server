package cap.stone.team.smallCloud.data.dto;

import cap.stone.team.smallCloud.data.entity.Category;
import lombok.*;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CategoryDto {
    private Long id;
    private String name;

    public Category toEntity() {
        return Category.builder()
                .id(id)
                .name(name)
                .build();
    }
}
