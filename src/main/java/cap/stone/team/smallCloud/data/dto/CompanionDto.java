package cap.stone.team.smallCloud.data.dto;

import cap.stone.team.smallCloud.data.entity.Category;
import cap.stone.team.smallCloud.data.entity.Companion;
import cap.stone.team.smallCloud.data.entity.Kind;
import cap.stone.team.smallCloud.data.entity.User;
import cap.stone.team.smallCloud.data.vo.type.Gender;
import lombok.*;

import java.util.List;
import java.util.stream.Collectors;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CompanionDto {
    private Long id;
    private String name;
    private Long kindId;
    private Long kindCategoryId;
    private String kindCategoryName;
    private String kindSpecies;
    private String NFC_code;
    private String animal_reg_code;
    private List<Long> ownerIds;
    private Gender gender;
    private int age;
    private Double length;
    private Double height;
    private Double width;
    private String color;
    private String shape;

    public Companion toEntity() {
        Category category = Category.builder()
                .id(kindCategoryId)
                .name(kindCategoryName)
                .build();

        Kind kind = Kind.builder()
                .id(kindId)
                .species(kindSpecies)
                .category(category)
                .build();

        return Companion.builder()
                .id(id)
                .name(name)
                .kind(kind)
                .NFC_code(NFC_code)
                .animal_reg_code(animal_reg_code)
                .owner(ownerIds.stream().map(o -> User.builder().id(o).build()).collect(Collectors.toList()))
                .gender(gender)
                .age(age)
                .length(length)
                .height(height)
                .width(width)
                .color(color)
                .shape(shape)
                .build();
    }
}
