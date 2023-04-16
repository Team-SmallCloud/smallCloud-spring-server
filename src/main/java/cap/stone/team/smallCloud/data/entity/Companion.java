package cap.stone.team.smallCloud.data.entity;

import cap.stone.team.smallCloud.data.vo.type.Gender;

import javax.persistence.*;

//@Entity
public class Companion {
    @Id
    private Long id;
    private String name;
    @ManyToOne
    private Kind kind;
    private String NFC_code;
    private String animal_reg_code;
    @ManyToMany
    private User owner; // 가족 구성원으로 등록하기 위해 하나의 동물을 여러명이 등록할 때
    private Gender gender;
    private int age;
    private Double length;
    private Double height;
    private Double width;
    private String color;
    private String shape;
}
