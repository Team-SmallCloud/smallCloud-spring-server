package cap.stone.team.smallCloud.data.entity;

import cap.stone.team.smallCloud.data.dto.CategoryDto;
import cap.stone.team.smallCloud.data.dto.KindDto;
import cap.stone.team.smallCloud.data.vo.type.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "kind")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Kind {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY)
    private Category category;
    @Column
    private String species;
    @Column
    private Size size;
    @Column
    private String shape;

    public KindDto toDto() {
        CategoryDto cd = category.toDto();

        return KindDto.builder()
                .id(id)
                .categoryId(cd.getId())
                .categoryName(cd.getName())
                .species(species)
                .shape(shape)
                .size(size)
                .build();
    }
}
