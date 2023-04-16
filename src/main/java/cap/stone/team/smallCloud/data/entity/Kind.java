package cap.stone.team.smallCloud.data.entity;

import cap.stone.team.smallCloud.data.vo.type.Size;

import javax.persistence.*;

//@Entity
public class Kind {
    @Id
    private Long id;
    @ManyToOne
    private Category category;
    private String species;
    private Size size;
    private String shape;
}
