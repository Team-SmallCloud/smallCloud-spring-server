package cap.stone.team.smallCloud.data.dto;

import cap.stone.team.smallCloud.data.entity.ImageTest;
import lombok.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Setter
public class ImageTestDto {
    private MultipartFile file;
    private String imageInfo;

    // 파일 경로의 경우 mac은 한글 경로를 정준 분해하고 만다.
    // window는 정준 분해 후 결합하여 둘의 방식이 다르기 때문에 유의해야 한다.
    // MultiPartFile의 이름을 Normalizer.normalize() 를 활용하면 된다.

    public ImageTest toEntity(String imageUrl) {
        return ImageTest.builder()
                .imageInfo(imageInfo)
                .imageUrl(imageUrl)
                .build();
    }

    public Boolean isFile() {
        return !file.isEmpty();
    }

    public String fileOriginalName() {
        return file.getOriginalFilename();
    }
    public byte[] fileBytes() throws IOException {
        return file.getBytes();
    }
}
