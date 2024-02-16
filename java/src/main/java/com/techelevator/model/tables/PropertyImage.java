package com.techelevator.model.tables;

public class PropertyImage {

    private int imageId;
    private int propertyId;
    private String imageUrl;

    public PropertyImage() {}

    public PropertyImage(int imageId, int propertyId, String imageUrl) {
        this.imageId = imageId;
        this.propertyId = propertyId;
        this.imageUrl = imageUrl;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    public int getPropertyId() {
        return propertyId;
    }

    public void setPropertyId(int propertyId) {
        this.propertyId = propertyId;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    @Override
    public String toString() {
        return "PropertyImage{" +
                "imageId=" + imageId +
                ", propertyId=" + propertyId +
                ", imageUrl='" + imageUrl + '\'' +
                '}';
    }
}
