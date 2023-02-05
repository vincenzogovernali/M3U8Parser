package service;

import model.GenericModel;

import java.util.List;

public interface M3U8Parser {


    List<GenericModel> parse(String m3u8);

    List<GenericModel> parse(String m3u8, String imageDefault);

}
