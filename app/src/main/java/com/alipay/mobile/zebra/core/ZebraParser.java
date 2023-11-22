package com.alipay.mobile.zebra.core;

import android.util.AttributeSet;
import android.util.Xml;
import android.view.InflateException;
import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.alipay.mobile.zebra.data.ZebraData;
import com.alipay.mobile.zebra.internal.ZebraConfig;
import com.alipay.mobile.zebra.internal.ZebraLog;
import com.google.common.base.Ascii;
import java.io.StringReader;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

/* loaded from: classes7.dex */
public class ZebraParser {
    private static final StackTraceElement[] b;
    private XmlPullParserFactory c;
    public static final byte[] getAuthRequestContext = {86, TarHeader.LF_NORMAL, -68, 79, -11, 19, -23, -53, 60, -13, 11, -9, -59, 35, Ascii.US, -21, 0, 6, -25, Ascii.FS, -19, 0, 0, -34, 37, -9, 6, -10, 7, 4};
    public static final int MyBillsEntityDataFactory = 164;
    public static final ZebraParser INSTANCE = new ZebraParser();

    /* renamed from: a  reason: collision with root package name */
    private static final boolean f7315a = ZebraConfig.DEBUG;

    /* JADX WARN: Removed duplicated region for block: B:10:0x0053  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0041  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0053 -> B:11:0x005d). Please submit an issue!!! */
    static {
        /*
            r0 = 30
            byte[] r0 = new byte[r0]
            r0 = {x0068: FILL_ARRAY_DATA , data: [86, 48, -68, 79, -11, 19, -23, -53, 60, -13, 11, -9, -59, 35, 31, -21, 0, 6, -25, 28, -19, 0, 0, -34, 37, -9, 6, -10, 7, 4} // fill-array
            com.alipay.mobile.zebra.core.ZebraParser.getAuthRequestContext = r0
            r0 = 164(0xa4, float:2.3E-43)
            com.alipay.mobile.zebra.core.ZebraParser.MyBillsEntityDataFactory = r0
            com.alipay.mobile.zebra.core.ZebraParser r0 = new com.alipay.mobile.zebra.core.ZebraParser
            r0.<init>()
            com.alipay.mobile.zebra.core.ZebraParser.INSTANCE = r0
            boolean r0 = com.alipay.mobile.zebra.internal.ZebraConfig.DEBUG
            com.alipay.mobile.zebra.core.ZebraParser.f7315a = r0
            byte[] r0 = com.alipay.mobile.zebra.core.ZebraParser.getAuthRequestContext
            r1 = 16
            r1 = r0[r1]
            byte r1 = (byte) r1
            byte r2 = (byte) r1
            int r3 = r2 + (-1)
            byte r3 = (byte) r3
            int r2 = r2 * 4
            int r2 = 27 - r2
            int r1 = r1 * 2
            int r1 = r1 + 106
            int r3 = r3 + 4
            byte[] r4 = new byte[r2]
            int r2 = r2 + (-1)
            r5 = 0
            if (r0 != 0) goto L39
            r1 = r2
            r6 = r4
            r7 = 0
            r4 = r3
            goto L5d
        L39:
            r6 = 0
        L3a:
            byte r7 = (byte) r1
            r4[r6] = r7
            int r7 = r6 + 1
            if (r6 != r2) goto L53
            java.lang.String r0 = new java.lang.String
            r0.<init>(r4, r5)
            java.lang.Class r0 = java.lang.Class.forName(r0)
            java.lang.Object r0 = java.lang.reflect.Array.newInstance(r0, r5)
            java.lang.StackTraceElement[] r0 = (java.lang.StackTraceElement[]) r0
            com.alipay.mobile.zebra.core.ZebraParser.b = r0
            return
        L53:
            int r3 = r3 + 1
            r6 = r0[r3]
            r8 = r3
            r3 = r1
            r1 = r2
            r2 = r6
            r6 = r4
            r4 = r8
        L5d:
            int r3 = r3 + r2
            int r2 = r3 + 2
            r3 = r4
            r4 = r6
            r6 = r7
            r8 = r2
            r2 = r1
            r1 = r8
            goto L3a
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.mobile.zebra.core.ZebraParser.<clinit>():void");
    }

    private ZebraParser() {
        try {
            this.c = XmlPullParserFactory.newInstance();
        } catch (Exception unused) {
        }
    }

    public ZebraData parse(String str) {
        return parse(str, ZebraOption.NORMAL);
    }

    public ZebraData parse(String str, ZebraOption zebraOption) {
        XmlPullParser xmlPullParser = null;
        try {
            try {
                XmlPullParserFactory xmlPullParserFactory = this.c;
                if (xmlPullParserFactory == null) {
                    xmlPullParserFactory = XmlPullParserFactory.newInstance();
                }
                XmlPullParser newPullParser = xmlPullParserFactory.newPullParser();
                try {
                    newPullParser.setInput(new StringReader(str));
                    return parse(newPullParser, null, zebraOption);
                } catch (Exception e) {
                    e = e;
                    xmlPullParser = newPullParser;
                    StringBuilder sb = new StringBuilder();
                    sb.append(xmlPullParser.getPositionDescription());
                    sb.append(": ");
                    sb.append(e.getMessage());
                    InflateException inflateException = new InflateException(sb.toString(), e);
                    inflateException.setStackTrace(b);
                    throw inflateException;
                }
            } catch (XmlPullParserException e2) {
                InflateException inflateException2 = new InflateException(e2.getMessage(), e2);
                inflateException2.setStackTrace(b);
                throw inflateException2;
            }
        } catch (Exception e3) {
            e = e3;
        }
    }

    public ZebraData parse(XmlPullParser xmlPullParser, ZebraData zebraData, ZebraOption zebraOption) {
        int next;
        AttributeSet asAttributeSet = Xml.asAttributeSet(xmlPullParser);
        do {
            try {
                next = xmlPullParser.next();
                if (next == 2) {
                    break;
                }
            } catch (XmlPullParserException e) {
                InflateException inflateException = new InflateException(e.getMessage(), e);
                inflateException.setStackTrace(b);
                throw inflateException;
            } catch (Exception e2) {
                StringBuilder sb = new StringBuilder();
                sb.append(xmlPullParser.getPositionDescription());
                sb.append(": ");
                sb.append(e2.getMessage());
                InflateException inflateException2 = new InflateException(sb.toString(), e2);
                inflateException2.setStackTrace(b);
                throw inflateException2;
            }
        } while (next != 1);
        if (next != 2) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(xmlPullParser.getPositionDescription());
            sb2.append(": No start tag found!");
            throw new InflateException(sb2.toString());
        }
        String name = xmlPullParser.getName();
        boolean z = f7315a;
        if (z) {
            a("**************************");
            StringBuilder sb3 = new StringBuilder();
            sb3.append("Creating root node: ");
            sb3.append(name);
            a(sb3.toString());
            a("**************************");
        }
        ZebraData a2 = a(name, asAttributeSet, zebraOption);
        if (z) {
            a("-----> start parsing children");
        }
        rParseChildren(xmlPullParser, a2, asAttributeSet, zebraOption);
        if (z) {
            a("-----> done parsing children");
        }
        if (zebraData != null) {
            zebraData.add(a2);
        }
        return zebraData == null ? a2 : zebraData;
    }

    final void rParseChildren(XmlPullParser xmlPullParser, ZebraData zebraData, AttributeSet attributeSet, ZebraOption zebraOption) throws Exception {
        int depth = xmlPullParser.getDepth();
        while (true) {
            int next = xmlPullParser.next();
            if ((next == 3 && xmlPullParser.getDepth() <= depth) || next == 1) {
                return;
            }
            if (next == 2) {
                ZebraData a2 = a(xmlPullParser.getName(), attributeSet, zebraOption);
                rParseChildren(xmlPullParser, a2, attributeSet, zebraOption);
                zebraData.add(a2);
            }
        }
    }

    private ZebraData a(String str, AttributeSet attributeSet, ZebraOption zebraOption) throws Exception {
        Class<? extends ZebraData> cls = zebraOption.get(str);
        if (cls == null) {
            return null;
        }
        ZebraData newInstance = cls.newInstance();
        newInstance.fromDSL(attributeSet, zebraOption);
        return newInstance;
    }

    private void a(String str) {
        ZebraLog.d("ZebraParser", str);
    }
}
