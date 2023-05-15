package cap.stone.team.smallCloud.data.entity;

import cap.stone.team.smallCloud.data.vo.type.Gender;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "companion")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Companion {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @Column
    private String name;
    @ManyToOne(fetch = FetchType.LAZY)
    private Kind kind;
    @Column
    private String NFC_code;
    @Column
    private String animal_reg_code;
    @ManyToMany(fetch = FetchType.LAZY)
    private List<User> owner; // 가족 구성원으로 등록하기 위해 하나의 동물을 여러명이 등록할 때
    @Column
    private Gender gender;
    @Column
    private int age;
    @Column
    private Double length;
    @Column
    private Double height;
    @Column
    private Double width;
    @Column
    private String color;
    @Column
    private String shape;
}
