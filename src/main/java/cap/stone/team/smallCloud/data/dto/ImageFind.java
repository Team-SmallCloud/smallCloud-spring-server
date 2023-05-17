package cap.stone.team.smallCloud.data.dto;

import lombok.*;

@NoArgsConstructor
@Getter
@Setter
public class ImageFind {
    private Long id;
    private String fileName;
    private String imageInfo;

    public ImageFind(String fileName, String imageInfo) {
        this.fileName = fileName;
        this.imageInfo = imageInfo;
    }

    @Builder
    public ImageFind(Long id, String fileName, String imageInfo) {
        this.id = id;
        this.fileName = fileName;
        this.imageInfo = imageInfo;
    }
}
