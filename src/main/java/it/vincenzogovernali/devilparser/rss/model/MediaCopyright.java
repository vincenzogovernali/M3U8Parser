package it.vincenzogovernali.devilparser.rss.model;

import it.vincenzogovernali.devilparser.rss.utils.Utils;
import lombok.NonNull;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;
import java.net.URL;

public final class MediaCopyright {
    static final String XML_TAG = "copyright";


    public final URL url;
    @NonNull
    public final String value;

    public MediaCopyright(URL url, @NonNull String value) {
        this.url = url;
        this.value = value;
    }

    @NonNull
    static MediaCopyright read(@NonNull XmlPullParser parser) throws XmlPullParserException, IOException {
        parser.require(XmlPullParser.START_TAG, null, XML_TAG);
        final String url = parser.getAttributeValue(XmlPullParser.NO_NAMESPACE, "url");
        return new MediaCopyright(url == null ? null : Utils.tryParseUrl(url), parser.nextText());
    }
}
