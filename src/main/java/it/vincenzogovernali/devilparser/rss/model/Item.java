package it.vincenzogovernali.devilparser.rss.model;

import lombok.NonNull;

import java.util.Date;
import java.util.List;

public interface Item {


    String getLink();


    Date getPublicationDate();


    String getTitle();


    String getDescription();


    String getImageLink();


    String getAuthor();


    String getId();

    @NonNull
    List<? extends Enclosure> getEnclosures();
}
