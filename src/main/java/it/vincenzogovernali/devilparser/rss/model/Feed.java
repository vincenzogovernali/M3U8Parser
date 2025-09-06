package it.vincenzogovernali.devilparser.rss.model;

import lombok.NonNull;

import java.util.Date;
import java.util.List;

public interface Feed {


    String getLink();


    Date getPublicationDate();


    Date getUpdatedDate();

    @NonNull
    String getTitle();


    String getDescription();


    String getCopyright();


    String getImageLink();


    String getAuthor();

    @NonNull
    List<? extends Item> getItems();
}
