package it.vincenzogovernali.devilparser.rss.model;

import it.vincenzogovernali.devilparser.rss.utils.Utils;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;
import java.net.URL;
import java.util.EnumMap;
import java.util.Map;

@Slf4j
public final class RSSTextInput {
    static final String XML_TAG = "textInput";
    private static final String TAG = "Earl.RSSTextInput";
    @NonNull
    public final String title;
    @NonNull
    public final String description;
    @NonNull
    public final String name;
    @NonNull
    public final URL link;

    public RSSTextInput(@NonNull String title, @NonNull String description, @NonNull String name,
                        @NonNull URL link) {
        this.title = title;
        this.description = description;
        this.name = name;
        this.link = link;
    }

    @NonNull
    static RSSTextInput read(@NonNull XmlPullParser parser)
            throws IOException, XmlPullParserException {
        final Map<ST, String> map = new EnumMap<>(ST.class);
        while (parser.nextTag() == XmlPullParser.START_TAG) {
            try {
                map.put(ST.valueOf(parser.getName()), parser.nextText());
            } catch (IllegalArgumentException ignored) {
                log.info(TAG, "Unknown RSS TextInput tag " + parser.getName());
                Utils.skipTag(parser);
            }
            Utils.finishTag(parser);
        }
        return new RSSTextInput(
                Utils.nonNullString(map.remove(ST.title)),
                Utils.nonNullString(map.remove(ST.description)),
                Utils.nonNullString(map.remove(ST.name)),
                Utils.nonNullUrl(map.remove(ST.link)));
    }

    private enum ST {title, description, name, link}
}
