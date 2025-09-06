package it.vincenzogovernali.devilparser.rss.model;

import lombok.NonNull;


public interface Enclosure {
    @NonNull
    String getLink();


    Integer getLength();


    String getType();
}
