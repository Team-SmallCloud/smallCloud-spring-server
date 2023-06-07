package cap.stone.team.smallCloud.data.vo.type;

import lombok.Getter;

@Getter
public enum Size {
    S("SMALL", "소형"),
    M("MIDDLE", "중형"),
    L("LARGE", "대형");

    Size(String code, String name) {
        code = code;
        name = name;
    }
}
