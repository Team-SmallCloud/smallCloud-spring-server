package cap.stone.team.smallCloud.data.entity;

import cap.stone.team.smallCloud.data.dto.CategoryDto;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "category")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @Column
    private String name;

    public CategoryDto toDto() {
        return CategoryDto.builder()
                .id(id)
                .name(name)
                .build();
    }
}
