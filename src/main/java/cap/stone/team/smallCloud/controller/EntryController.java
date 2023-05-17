package cap.stone.team.smallCloud.controller;

import cap.stone.team.smallCloud.data.dto.ImageFind;
import cap.stone.team.smallCloud.data.dto.ImageTestDto;
import cap.stone.team.smallCloud.service.ImageService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/")
@Controller
@RequiredArgsConstructor
@Slf4j
public class EntryController {
    private final ImageService imageService;

    @Value("${file.path}")
    private static String uploadPath;

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
        return "redirect:/images/" + imageService.oneImageFind(id).getFileName();
    }

    @GetMapping("images/show")
    public String imageTestFind(ImageFind imageFind) {
        return "redirect:/images/" + imageService.findImage(imageFind).getFileName();
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
}
