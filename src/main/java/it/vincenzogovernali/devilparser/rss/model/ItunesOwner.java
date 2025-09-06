package it.vincenzogovernali.devilparser.rss.model;

import it.vincenzogovernali.devilparser.rss.utils.Utils;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;

@Slf4j
public final class ItunesOwner {
    static final String XML_TAG = "owner";
    private static final String TAG = "Earl.ItunesOwner";


    public final String name;


    public final String eMail;

    public ItunesOwner(String name, String eMail) {
        this.name = name;
        this.eMail = eMail;
    }

    @NonNull
    static ItunesOwner read(@NonNull XmlPullParser parser)
            throws IOException, XmlPullParserException {
        parser.require(XmlPullParser.START_TAG, null, XML_TAG);
        String name = null;
        String eMail = null;
        while (parser.nextTag() == XmlPullParser.START_TAG) {
            switch (parser.getName()) {
                case "name":
                    name = parser.nextText();
                    break;
                case "email":
                    eMail = parser.nextText();
                    break;
                default:
                    log.info(TAG, "Unexpected owner tag " + parser.getName());
            }
            Utils.finishTag(parser);
        }
        return new ItunesOwner(name, eMail);
    }
}
