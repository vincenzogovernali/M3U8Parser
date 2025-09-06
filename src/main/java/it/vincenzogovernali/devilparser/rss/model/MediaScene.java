package it.vincenzogovernali.devilparser.rss.model;

import it.vincenzogovernali.devilparser.rss.utils.Utils;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;

@Slf4j
public final class MediaScene {
    static final String XML_TAG = "scene";
    private static final String TAG = "Earl.MediaScene";


    public final String sceneTitle;


    public final String sceneDescription;


    public final Integer sceneStartTime;


    public final Integer sceneEndTime;

    public MediaScene(String sceneTitle, String sceneDescription,

                      Integer sceneStartTime, Integer sceneEndTime) {
        this.sceneTitle = sceneTitle;
        this.sceneDescription = sceneDescription;
        this.sceneStartTime = sceneStartTime;
        this.sceneEndTime = sceneEndTime;
    }

    @NonNull
    static MediaScene read(XmlPullParser parser) throws XmlPullParserException, IOException {
        parser.require(XmlPullParser.START_TAG, null, XML_TAG);
        String sceneTitle = null;
        String sceneDescription = null;
        Integer sceneStartTime = null;
        Integer sceneEndTime = null;

        while (parser.nextTag() == XmlPullParser.START_TAG) {
            switch (parser.getName()) {
                case "sceneTitle":
                    sceneTitle = parser.nextText();
                    break;
                case "sceneDescription":
                    sceneDescription = parser.nextText();
                    break;
                case "sceneStartTime":
                    sceneStartTime = Utils.parseMediaRssTime(parser.nextText());
                    break;
                case "sceneEndTime":
                    sceneEndTime = Utils.parseMediaRssTime(parser.nextText());
                    break;
                default:
                    log.info(TAG, "Unexpected tag inside media:scene: " + parser.getName());
                    Utils.skipTag(parser);
            }
            Utils.finishTag(parser);
        }

        return new MediaScene(sceneTitle, sceneDescription, sceneStartTime, sceneEndTime);
    }
}
