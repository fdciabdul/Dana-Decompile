package com.xiaomi.push;

import java.io.ByteArrayInputStream;
import java.io.InputStreamReader;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

/* loaded from: classes8.dex */
public class bn {
    private XmlPullParser getAuthRequestContext;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bn() {
        try {
            XmlPullParser newPullParser = XmlPullParserFactory.newInstance().newPullParser();
            this.getAuthRequestContext = newPullParser;
            newPullParser.setFeature("http://xmlpull.org/v1/doc/features.html#process-namespaces", true);
        } catch (XmlPullParserException unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final cj MyBillsEntityDataFactory(byte[] bArr, bt btVar) {
        String name;
        String str;
        this.getAuthRequestContext.setInput(new InputStreamReader(new ByteArrayInputStream(bArr)));
        this.getAuthRequestContext.next();
        int eventType = this.getAuthRequestContext.getEventType();
        String name2 = this.getAuthRequestContext.getName();
        if (eventType == 2) {
            if (name2.equals("message")) {
                return cr.KClassImpl$Data$declaredNonStaticMembers$2(this.getAuthRequestContext);
            }
            if (name2.equals("iq")) {
                return cr.getAuthRequestContext(this.getAuthRequestContext, btVar);
            }
            if (name2.equals("presence")) {
                return cr.BuiltInFictitiousFunctionClassFactory(this.getAuthRequestContext);
            }
            if (this.getAuthRequestContext.getName().equals("stream")) {
                return null;
            }
            if (this.getAuthRequestContext.getName().equals("error")) {
                throw new cd(cr.getAuthRequestContext(this.getAuthRequestContext));
            }
            if (this.getAuthRequestContext.getName().equals("warning")) {
                this.getAuthRequestContext.next();
                name = this.getAuthRequestContext.getName();
                str = "multi-login";
            } else {
                name = this.getAuthRequestContext.getName();
                str = "bind";
            }
            name.equals(str);
            return null;
        }
        return null;
    }
}
