package com.github.franckyi.ibeeditor.impl.client.mvc.controller;

import com.github.franckyi.gamehooks.util.common.Text;
import com.github.franckyi.gamehooks.util.common.TextFormatting;
import com.github.franckyi.ibeeditor.api.client.mvc.controller.CategoryController;
import com.github.franckyi.ibeeditor.api.client.mvc.model.CategoryModel;
import com.github.franckyi.ibeeditor.api.client.mvc.view.CategoryView;

public class CategoryControllerImpl implements CategoryController {
    public static final CategoryController INSTANCE = new CategoryControllerImpl();

    @Override
    public void init(CategoryModel model, CategoryView view) {
        model.selectedProperty().addListener(() -> updateLabel(model, view));
        model.nameProperty().addListener(() -> updateLabel(model, view));
        updateLabel(model, view);
    }

    private void updateLabel(CategoryModel model, CategoryView view) {
        TextFormatting[] format = model.isSelected() ? new TextFormatting[] {TextFormatting.YELLOW, TextFormatting.BOLD} : new TextFormatting[] {};
        view.getRoot().setLabel(Text.translated(model.getName(), format));
    }
}
