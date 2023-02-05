package model;

import lombok.Getter;

import java.util.UUID;

@Getter
public class GenericModel {

    private final String id;
    private final String title;
    private final String imageUrl;
    private final String url;

    public GenericModel(String title, String imageUrl, String defaultImage, String url) {
        this.title = title;
        if (imageUrl != null && !imageUrl.isEmpty()) {
            this.imageUrl = imageUrl;
        } else {
            this.imageUrl = defaultImage;
        }
        this.url = url;
        this.id = UUID.randomUUID().toString();
    }

}
