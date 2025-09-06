package it.vincenzogovernali.devilparser.rss;


import it.vincenzogovernali.devilparser.rss.model.AtomFeed;
import it.vincenzogovernali.devilparser.rss.model.Feed;
import it.vincenzogovernali.devilparser.rss.model.RSSFeed;
import lombok.NonNull;
import org.xmlpull.mxp1.MXParser;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;
import java.io.InputStream;
import java.util.zip.DataFormatException;


public final class RSSFeedParser {
    private RSSFeedParser() {
    }

    /**
     * @param inputStream - stream to read feed from
     * @param maxItems    - stop parsing after reading this much feed items
     * @return parsed RSSFeed or AtomFeed, depending on input stream or null if parsing fails
     */


    public static Feed parse(@NonNull InputStream inputStream, int maxItems) {
        try {
            return parseOrThrow(inputStream, maxItems);
        } catch (IOException | XmlPullParserException | DataFormatException ignored) {
            return null;
        }
    }

    /**
     * @param inputStream - stream to read feed from. Will be closed in this function
     * @param maxItems    - stop parsing after reading this much feed items
     * @return parsed RSSFeed or AtomFeed, depending on input stream
     */
    @NonNull
    public static Feed parseOrThrow(@NonNull InputStream inputStream, int maxItems)
            throws XmlPullParserException, IOException, DataFormatException {
        try {
            final XmlPullParser parser = new MXParser();
            parser.setFeature(XmlPullParser.FEATURE_PROCESS_NAMESPACES, true);
            parser.setInput(inputStream, null);
            while (parser.next() != XmlPullParser.END_DOCUMENT) {
                if (parser.getEventType() == XmlPullParser.START_TAG) {
                    switch (parser.getName()) {
                        case RSSFeed.XML_TAG:
                            return RSSFeed.read(parser, maxItems);
                        case AtomFeed.XML_TAG:
                            return AtomFeed.read(parser, maxItems);
                        default: // ignore other tags
                    }
                }
            }
        } finally {
            inputStream.close();
        }
        throw new DataFormatException("No syndication feeds found in given stream");
    }
}
