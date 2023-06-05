package cap.stone.team.smallCloud.controller;

import cap.stone.team.smallCloud.data.dto.CategoryDto;
import cap.stone.team.smallCloud.data.dto.KindDto;
import cap.stone.team.smallCloud.data.entity.Category;
import cap.stone.team.smallCloud.repository.CategoryRepository;
import cap.stone.team.smallCloud.service.KindService;
import cap.stone.team.smallCloud.utils.exception.EntityNotFoundException;
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
    public List<KindDto> showAllKinds() {
        return kindService.allKind();
    }

    @GetMapping("search")
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

    @PutMapping("edit")
    public KindDto editKinds(KindDto kindDto) {
        if (categoryRepository.existsById(kindDto.getCategoryId())) {
            return kindService.updateKind(kindDto);
        }
        throw new EntityNotFoundException("해당하는 카테고리가 없습니다.");
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
        return categoryRepository.save(new CategoryDto(name).toEntity()).toDto();
    }

    @Transactional
    @PutMapping("categories/edit")
    public CategoryDto editCategories(Long id, String name) {
        if (categoryRepository.existsById(id)) {
            return categoryRepository.save(new CategoryDto(id, name).toEntity()).toDto();
        }
        throw new EntityNotFoundException("해당하는 카테고리가 없습니다.");
    }

    @GetMapping("categories/search")
    public List<CategoryDto> findCategories(String name) {
        return categoryRepository.findByNameContains(name).stream().map(Category::toDto).collect(Collectors.toList());
    }

    @GetMapping("categories/search/same")
    public CategoryDto findCategory(String name) {
        return categoryRepository.findByNameEquals(name).toDto();
    }

    @DeleteMapping("categories/remove")
    public String deleteCategory(String name) {
        Category named = categoryRepository.findByNameEquals(name);
        categoryRepository.delete(named);
        kindService.categoryDeleted(named.toDto());

        return "delete well";
    }
}
