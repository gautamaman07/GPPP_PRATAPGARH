package gppp.pratapgarh.gppp_pratapgarh.Modelclass;

import androidx.annotation.Keep;

@Keep
public class WallpaperItem {
    public String categoryId,imageLink;
    public WallpaperItem()
    {}

    public WallpaperItem(String categoryId, String imageLink) {
        this.categoryId = categoryId;
        this.imageLink = imageLink;
    }

    public String getCategoryId() {
        return categoryId;
     }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    public String getImageLink() {
        return imageLink;
    }

    public void setImageLink(String imageLink) {
        this.imageLink = imageLink;
    }
}
