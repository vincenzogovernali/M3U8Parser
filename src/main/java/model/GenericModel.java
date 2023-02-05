package model;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class GenericModel {

    private String id;
    private String title;
    private String imageUrl;
    private String url;

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
