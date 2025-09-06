package it.vincenzogovernali.devilparser.rss.model;

import lombok.NonNull;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;

public final class MediaHash {
    static final String XML_TAG = "hash";


    public final String algo;
    @NonNull
    public final String value;

    public MediaHash(String algo, @NonNull String value) {
        this.algo = algo;
        this.value = value;
    }

    @NonNull
    static MediaHash read(@NonNull XmlPullParser parser) throws XmlPullParserException, IOException {
        parser.require(XmlPullParser.START_TAG, null, XML_TAG);
        return new MediaHash(parser.getAttributeValue(XmlPullParser.NO_NAMESPACE, "algo"),
                parser.nextText());
    }
}
