package com.techpulse.service;

import com.techpulse.dto.CategoryDTO;
import com.techpulse.entity.Category;
import com.techpulse.mapper.CategoryMapper;
import com.techpulse.repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public Category createCategory(CategoryDTO dto) {
        Category category = CategoryMapper.toEntity(dto);
        return categoryRepository.save(category);
    }

    public List<Category> GetAllCategories() {
        return categoryRepository.findAll();
    }

    public Category GetAllCategories(Long id) {
        Optional<Category> category = categoryRepository.findById(id);
        if(category.isPresent()) {
            return category.get();
        } else {
            throw new RuntimeException("Category not found with id: " + id);
        }
    }
}
