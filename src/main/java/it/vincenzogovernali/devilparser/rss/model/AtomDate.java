package it.vincenzogovernali.devilparser.rss.model;


import it.vincenzogovernali.devilparser.rss.utils.Utils;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;
import java.util.Date;

@Slf4j
public final class AtomDate extends AtomCommonAttributes {
    private static final String TAG = "Earl.AtomDate";

    @NonNull
    public final Date date;

    public AtomDate(AtomCommonAttributes source, @NonNull Date date) {
        super(source);
        this.date = date;
    }

    @NonNull
    static AtomDate read(XmlPullParser parser) throws XmlPullParserException, IOException {
        final AtomCommonAttributes atomCommonAttributes = new AtomCommonAttributes(parser);
        Date date = Utils.parseDate(parser.nextText());
        if (date == null) {
            log.info(TAG, "Replacing date with 0");
            date = new Date(0);
        }
        return new AtomDate(atomCommonAttributes, date);
    }
}
