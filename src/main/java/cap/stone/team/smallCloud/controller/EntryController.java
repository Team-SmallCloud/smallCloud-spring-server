package cap.stone.team.smallCloud.controller;

import cap.stone.team.smallCloud.data.dto.ImageFind;
import cap.stone.team.smallCloud.data.dto.ImageTestDto;
import cap.stone.team.smallCloud.service.ImageService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

@RequestMapping("/")
@Controller
@RequiredArgsConstructor
@Slf4j
public class EntryController {
    private final ImageService imageService;

    @Value("${file.path}")
    private String uploadPath;

    @GetMapping
    public String entry() {
        return "index.html";
    }

    @GetMapping("images")
    @ResponseBody
    public List<ImageFind> imageTestAll(ImageFind imageFind) {
        return imageService.imageAllData();
    }

    @GetMapping("images/detail/{id}")
    public String imageDetail(@PathVariable Long id) {
        return "redirect:/uploads/" + imageService.oneImageFind(id).getFileName();
    }

    @GetMapping("images/show")
    public String imageTestFind(ImageFind imageFind) {
        return "redirect:/uploads/" + imageService.findImage(imageFind).getFileName();
    }

    @ResponseBody
    @PostMapping("images")
    public String imageTest(ImageTestDto imageTestDto) {
        if (!imageTestDto.isFile()) {
            throw new IllegalArgumentException();
        }

        try {
            imageService.imageUpload(imageTestDto);
        } catch (Exception e) {
            e.printStackTrace();
            return "can't create image..";
        }
        return "upload complete";
    }

    @ResponseBody
    @DeleteMapping("images/clean")
    public String imageDeleteAll() {
        List<Path> files = imageService.imageAllData().stream().map(i -> Paths.get(uploadPath + i.getFileName())).collect(Collectors.toList());
        for (Path p : files) {
            try {
                Files.delete(p);
            } catch (Exception e) {
                log.error(String.valueOf(e));
            }
        }

        imageService.imageClean();
        return "complete delete all images..";
    }

    @ResponseBody
    @DeleteMapping("images/remove/{id}")
    public String imageDeleteAll(@PathVariable Long id) {
        log.info("{}", uploadPath);
        Path file = Paths.get(uploadPath + imageService.oneImageFind(id).getFileName());
        try {
            Files.delete(file);
        } catch (Exception e) {
             log.error(String.valueOf(e));
        }

        imageService.imageRemove(id);
        return "complete delete images..";
    }
}
