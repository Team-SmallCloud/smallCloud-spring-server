package cap.stone.team.smallCloud.data.vo.type;

import lombok.Getter;

@Getter
public enum Board {
    WANTED("wanted"),
    FOUND("found");

    Board(String title) {
        title = title;
    }
}
