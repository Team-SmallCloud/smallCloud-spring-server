package cap.stone.team.smallCloud.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/")
@Controller
public class EntryController {

    @GetMapping
    public String entry() {
        return "index.html";
    }
}
