package cap.stone.team.smallCloud.service;

import cap.stone.team.smallCloud.data.dto.ImageTestDto;
import cap.stone.team.smallCloud.data.entity.ImageTest;
import cap.stone.team.smallCloud.repository.ImageRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Base64;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Slf4j
public class ImageService {
    private final ImageRepository imageRepository;

    @Value("${file.path}")
    private String uploadPath;

    public void imageUpload(ImageTestDto imageTestDto) throws IOException {
        String imageFileName = fileNameGen(imageTestDto.fileOriginalName()).toString();
        log.info(uploadPath);
        Path imageFilePath = Paths.get(uploadPath + imageFileName);

        imageCreate(imageFilePath, imageTestDto.fileBytes());

        ImageTest imageTest = imageTestDto.toEntity(imageFileName);
        imageRepository.save(imageTest);
    }

    private StringBuffer fileNameGen(String name) {
        UUID uuid = UUID.randomUUID();
        StringBuffer nameBf = new StringBuffer();
        nameBf.append(uuid.toString().strip());
        nameBf.append("_");
        nameBf.append(illegalChange(name));
        return nameBf;
    }

    private String illegalChange(String val) {
        log.info(val);
        val = val.replaceAll("(?U)\\s+", "_");
        Base64.Encoder encoder = Base64.getEncoder();
        byte[] encoded = encoder.encode(val.getBytes());
        val = encoded.toString();
        log.info(val);
        return val;
    }

    private void imageCreate(Path path, byte[] bytes) {
        try {
            Files.write(path, bytes);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
