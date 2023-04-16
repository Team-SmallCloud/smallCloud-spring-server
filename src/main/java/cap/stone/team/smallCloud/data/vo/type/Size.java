package cap.stone.team.smallCloud.data.vo.type;

import lombok.Getter;

@Getter
public enum Size {
    SMALL("S", "소형"),
    MIDDLE("M", "중형"),
    LARGE("L", "대형");

    Size(String code, String name) {
        code = code;
        name = name;
    }
}
