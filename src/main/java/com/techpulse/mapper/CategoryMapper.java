package com.techpulse.mapper;

import com.techpulse.dto.CategoryDTO;
import com.techpulse.entity.Category;

public class CategoryMapper {

    private CategoryMapper() {
        // prevent instantiation
    }

    // Entity → DTO
    public static CategoryDTO toDto(Category category) {
        if (category == null) {
            return null;
        }

        CategoryDTO dto = new CategoryDTO();
        dto.setName(category.getName());

        return dto;
    }

    // DTO → Entity
    public static Category toEntity(CategoryDTO dto) {
        if (dto == null) {
            return null;
        }

        Category category = new Category();
        category.setName(dto.getName());

        // products are not mapped here intentionally
        return category;
    }
}
