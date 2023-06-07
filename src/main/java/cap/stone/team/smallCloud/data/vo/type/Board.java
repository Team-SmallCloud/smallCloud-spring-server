package cap.stone.team.smallCloud.data.vo.type;

import lombok.Getter;

@Getter
public enum Board {
    W("wanted"),
    F("found");

    Board(String title) {
        title = title;
    }
}
