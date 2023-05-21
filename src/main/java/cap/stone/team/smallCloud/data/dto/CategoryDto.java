package cap.stone.team.smallCloud.data.dto;

import cap.stone.team.smallCloud.data.entity.Category;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
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
