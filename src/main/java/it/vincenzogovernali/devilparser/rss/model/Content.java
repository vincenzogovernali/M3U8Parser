package it.vincenzogovernali.devilparser.rss.model;

import it.vincenzogovernali.devilparser.rss.utils.Utils;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;

@Slf4j
public final class Content {
    private static final String TAG = "Earl.Content";
    @NonNull
    public final String encoded;

    public Content(@NonNull String encoded) {
        this.encoded = encoded;
    }

    static class ContentBuilder {
        // this is the only tag specified in latest standard draft, see
        // http://web.resource.org/rss/1.0/modules/content/
        private static final String ENCODED_TAG = "encoded";
        private String encodedValue;

        void parseTag(@NonNull XmlPullParser parser) throws IOException, XmlPullParserException {
            final String tagName = parser.getName();
            if (tagName.equals(ENCODED_TAG)) {
                encodedValue = parser.nextText();
            } else {
                log.info(TAG, "Unknown Content feed tag '" + tagName + "', skipping..");
                Utils.skipTag(parser);
            }
        }


        Content build() {
            return encodedValue == null ? null : new Content(encodedValue);
        }
    }
}
