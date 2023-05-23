package cap.stone.team.smallCloud.data.dto;

import cap.stone.team.smallCloud.data.entity.Category;
import cap.stone.team.smallCloud.data.entity.Kind;
import cap.stone.team.smallCloud.data.vo.type.Size;
import lombok.*;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class KindDto {
    private Long id;
    private Long categoryId;
    private String categoryName;
    private String species;
    private Size size;
    private String shape;

    public Kind toEntity() {
        return Kind.builder()
                .id(id)
                .category(Category.builder()
                        .id(categoryId)
                        .name(categoryName)
                        .build())
                .species(species)
                .size(size)
                .shape(shape)
                .build();
    }

    public Kind toEntity(CategoryDto categoryDto) {
        return Kind.builder()
                .id(id)
                .category(categoryDto.toEntity())
                .species(species)
                .size(size)
                .shape(shape)
                .build();
    }
}
