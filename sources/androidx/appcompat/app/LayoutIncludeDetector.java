package androidx.appcompat.app;

import android.util.AttributeSet;
import java.lang.ref.WeakReference;
import java.util.ArrayDeque;
import java.util.Deque;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: classes.dex */
class LayoutIncludeDetector {
    private final Deque<WeakReference<XmlPullParser>> BuiltInFictitiousFunctionClassFactory = new ArrayDeque();

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean BuiltInFictitiousFunctionClassFactory(AttributeSet attributeSet) {
        XmlPullParser xmlPullParser;
        if (attributeSet instanceof XmlPullParser) {
            XmlPullParser xmlPullParser2 = (XmlPullParser) attributeSet;
            if (xmlPullParser2.getDepth() == 1) {
                Deque<WeakReference<XmlPullParser>> deque = this.BuiltInFictitiousFunctionClassFactory;
                while (true) {
                    if (!deque.isEmpty()) {
                        xmlPullParser = deque.peek().get();
                        if (!PlaceComponentResult(xmlPullParser)) {
                            break;
                        }
                        deque.pop();
                    } else {
                        xmlPullParser = null;
                        break;
                    }
                }
                this.BuiltInFictitiousFunctionClassFactory.push(new WeakReference<>(xmlPullParser2));
                return PlaceComponentResult(xmlPullParser2, xmlPullParser);
            }
            return false;
        }
        return false;
    }

    private static boolean PlaceComponentResult(XmlPullParser xmlPullParser, XmlPullParser xmlPullParser2) {
        if (xmlPullParser2 == null || xmlPullParser == xmlPullParser2) {
            return false;
        }
        try {
            if (xmlPullParser2.getEventType() == 2) {
                return "include".equals(xmlPullParser2.getName());
            }
            return false;
        } catch (XmlPullParserException unused) {
            return false;
        }
    }

    private static boolean PlaceComponentResult(XmlPullParser xmlPullParser) {
        if (xmlPullParser != null) {
            try {
                if (xmlPullParser.getEventType() != 3) {
                    return xmlPullParser.getEventType() == 1;
                }
                return true;
            } catch (XmlPullParserException unused) {
                return true;
            }
        }
        return true;
    }
}
