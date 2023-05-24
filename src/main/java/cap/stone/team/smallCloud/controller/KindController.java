package cap.stone.team.smallCloud.controller;

import cap.stone.team.smallCloud.data.dto.CategoryDto;
import cap.stone.team.smallCloud.data.dto.KindDto;
import cap.stone.team.smallCloud.data.entity.Category;
import cap.stone.team.smallCloud.data.entity.Kind;
import cap.stone.team.smallCloud.repository.CategoryRepository;
import cap.stone.team.smallCloud.service.KindService;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RequestMapping("/kinds")
@RestController
@RequiredArgsConstructor
public class KindController {
    private final CategoryRepository categoryRepository;
    private final KindService kindService;

    @GetMapping
    public List<KindDto> showKinds(KindDto kindDto) {
        return kindService.searchKind(kindDto);
    }

    @GetMapping("{id}")
    public KindDto detailKind(@PathVariable Long id) {
        return kindService.searchId(id);
    }

    @PostMapping("add")
    public KindDto addKinds(KindDto kindDto) {
        return kindService.createKind(kindDto);
    }

    @DeleteMapping("remove")
    public String deleteKind(KindDto kindDto) {
        kindService.deleteKind(kindDto);

        return "delete well";
    }

    @GetMapping("categories")
    public List<CategoryDto> showCategories() {
        return categoryRepository.findAll().stream().map(Category::toDto).collect(Collectors.toList());
    }

    @Transactional
    @PostMapping("categories/add")
    public CategoryDto addCategories(String name) {
        return categoryRepository.save(CategoryDto.builder().name(name).build().toEntity()).toDto();
    }

    @GetMapping("categories/search")
    public List<CategoryDto> findCategories(String name) {
        return categoryRepository.findByNameLike(name).stream().map(Category::toDto).collect(Collectors.toList());
    }

    @GetMapping("categories/search/same")
    public CategoryDto findCategory(String name) {
        return categoryRepository.findByNameEquals(name).toDto();
    }

    @DeleteMapping("categories/remove")
    public String deleteCategory(String name) {
        categoryRepository.deleteByNameEquals(name);

        return "delete well";
    }
}
