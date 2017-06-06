package me.tanjay.chordx.models;

import android.graphics.drawable.Drawable;

import android.net.Uri;

/**
 * Created by tanushajayasinghe on 5/21/17.
 */

public class CategoryModel {

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getCategoryDescription() {
        return categoryDescription;
    }

    public void setCategoryDescription(String categoryDescription) {
        this.categoryDescription = categoryDescription;
    }

    int categoryId;
    String categoryName;
    String categoryDescription;

    public Uri getImageURI() {
        return ImageURI;
    }

    public void setImageURI(Uri imageURI) {
        ImageURI = imageURI;
    }

    Uri ImageURI;
}
