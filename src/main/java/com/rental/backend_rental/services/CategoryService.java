package com.rental.backend_rental.services;

import com.rental.backend_rental.Repositories.CategoryRepository;
import com.rental.backend_rental.models.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    public void save(Category category)
    {
        categoryRepository.save(category);
    }

    public List<Category> showAllCategory()
    {
        return categoryRepository.findAll();
    }

    public Category selectOneCategory(int id)
    {
        return categoryRepository.findById(id).get();
    }

    public void deleteCategory(int id)
    {
        categoryRepository.deleteById(id);
    }
}