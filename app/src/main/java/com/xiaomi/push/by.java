package com.xiaomi.push;

import android.os.Process;
import android.view.ViewConfiguration;
import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.google.common.base.Ascii;
import com.google.firebase.perf.network.FirebasePerfUrlConnection;
import java.io.InputStream;
import java.io.PrintStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Vector;
import kotlin.text.Typography;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

/* loaded from: classes8.dex */
public final class by {
    private static int $10 = 0;
    private static int $11 = 1;
    private static Vector<String> BuiltInFictitiousFunctionClassFactory = null;
    public static final int KClassImpl$Data$declaredNonStaticMembers$2;
    private static int MyBillsEntityDataFactory = 5000;
    private static char[] NetworkUserEntityData$$ExternalSyntheticLambda0 = null;
    private static int PlaceComponentResult = 330000;
    public static final byte[] getAuthRequestContext;
    private static int getErrorConfigVersion = 0;
    private static int lookAheadTest = 1;
    private static char moveToNextValue = 0;
    private static int scheduleImpl = 600000;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r9v1, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r9v2, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r9v4 */
    static {
        Enumeration<URL> resources;
        InputStream inputStream;
        MyBillsEntityDataFactory();
        getAuthRequestContext = new byte[]{4, -41, 37, 5, -16, 5, 2, 15, -7, -4, 34, -18, -8, 15, 6, -1, 11, -19, Ascii.ETB, TarHeader.LF_DIR, -60, 13, -11, 9, 59, -36, -18, -8, 15, 6, -1};
        KClassImpl$Data$declaredNonStaticMembers$2 = 85;
        BuiltInFictitiousFunctionClassFactory = new Vector<>();
        try {
            ClassLoader[] KClassImpl$Data$declaredNonStaticMembers$22 = KClassImpl$Data$declaredNonStaticMembers$2();
            int length = KClassImpl$Data$declaredNonStaticMembers$22.length;
            for (int i = 0; i < length; i++) {
                int i2 = lookAheadTest + 31;
                getErrorConfigVersion = i2 % 128;
                if (!(i2 % 2 != 0)) {
                    resources = KClassImpl$Data$declaredNonStaticMembers$22[i].getResources("META-INF/smack-config.xml");
                } else {
                    resources = KClassImpl$Data$declaredNonStaticMembers$22[i].getResources("META-INF/smack-config.xml");
                    int i3 = 98 / 0;
                }
                while (resources.hasMoreElements()) {
                    int i4 = getErrorConfigVersion + 11;
                    lookAheadTest = i4 % 128;
                    int i5 = i4 % 2;
                    ?? r9 = 0;
                    InputStream inputStream2 = null;
                    try {
                        inputStream = FirebasePerfUrlConnection.openStream(resources.nextElement());
                    } catch (Exception unused) {
                    } catch (Throwable th) {
                        th = th;
                    }
                    try {
                        XmlPullParser newPullParser = XmlPullParserFactory.newInstance().newPullParser();
                        newPullParser.setFeature("http://xmlpull.org/v1/doc/features.html#process-namespaces", true);
                        Object[] objArr = new Object[1];
                        a(new char[]{0, 5, 2, 7, 13820}, (byte) (90 - (ViewConfiguration.getFadingEdgeLength() >> 16)), 4 - Process.getGidForName(""), objArr);
                        newPullParser.setInput(inputStream, ((String) objArr[0]).intern());
                        int eventType = newPullParser.getEventType();
                        do {
                            if (eventType == 2) {
                                if (newPullParser.getName().equals("className")) {
                                    PlaceComponentResult(newPullParser);
                                } else if (newPullParser.getName().equals("packetReplyTimeout")) {
                                    int i6 = getErrorConfigVersion + 79;
                                    lookAheadTest = i6 % 128;
                                    if (i6 % 2 == 0) {
                                        MyBillsEntityDataFactory = PlaceComponentResult(newPullParser, MyBillsEntityDataFactory);
                                        int length2 = r9.length;
                                    } else {
                                        MyBillsEntityDataFactory = PlaceComponentResult(newPullParser, MyBillsEntityDataFactory);
                                    }
                                } else if (newPullParser.getName().equals("keepAliveInterval")) {
                                    PlaceComponentResult = PlaceComponentResult(newPullParser, PlaceComponentResult);
                                } else if (newPullParser.getName().equals("mechName")) {
                                    BuiltInFictitiousFunctionClassFactory.add(newPullParser.nextText());
                                }
                            }
                            eventType = newPullParser.next();
                        } while (!(eventType == 1));
                        int i7 = lookAheadTest + 99;
                        getErrorConfigVersion = i7 % 128;
                        if (i7 % 2 != 0) {
                            r9.hashCode();
                        }
                    } catch (Exception unused2) {
                        inputStream2 = inputStream;
                        inputStream = inputStream2;
                        inputStream.close();
                    } catch (Throwable th2) {
                        th = th2;
                        r9 = inputStream;
                        try {
                            r9.close();
                        } catch (Exception unused3) {
                        }
                        throw th;
                    }
                    try {
                        inputStream.close();
                    } catch (Exception unused4) {
                    }
                }
            }
        } catch (Exception unused5) {
        }
    }

    private by() {
    }

    public static String BuiltInFictitiousFunctionClassFactory() {
        int i = getErrorConfigVersion + 25;
        lookAheadTest = i % 128;
        if (!(i % 2 != 0)) {
            int i2 = 23 / 0;
            return com.github.mikephil.charting.BuildConfig.VERSION_NAME;
        }
        return com.github.mikephil.charting.BuildConfig.VERSION_NAME;
    }

    private static ClassLoader[] KClassImpl$Data$declaredNonStaticMembers$2() {
        ClassLoader[] classLoaderArr = new ClassLoader[2];
        classLoaderArr[0] = by.class.getClassLoader();
        try {
            Object[] objArr = new Object[1];
            b((byte) (getAuthRequestContext[15] + 1), getAuthRequestContext[16], (byte) (-getAuthRequestContext[15]), objArr);
            Class<?> cls = Class.forName((String) objArr[0]);
            byte b = (byte) (-getAuthRequestContext[15]);
            byte b2 = getAuthRequestContext[15];
            Object[] objArr2 = new Object[1];
            b(b, b2, (byte) (b2 + 1), objArr2);
            Object obj = null;
            classLoaderArr[1] = ((Thread) cls.getMethod((String) objArr2[0], null).invoke(null, null)).getContextClassLoader();
            ArrayList arrayList = new ArrayList();
            int i = 0;
            while (true) {
                if (i >= 2) {
                    break;
                }
                ClassLoader classLoader = classLoaderArr[i];
                if (classLoader != null) {
                    int i2 = lookAheadTest + 117;
                    getErrorConfigVersion = i2 % 128;
                    int i3 = i2 % 2;
                    arrayList.add(classLoader);
                }
                i++;
            }
            ClassLoader[] classLoaderArr2 = (ClassLoader[]) arrayList.toArray(new ClassLoader[arrayList.size()]);
            try {
                int i4 = lookAheadTest + 23;
                getErrorConfigVersion = i4 % 128;
                if ((i4 % 2 != 0 ? '\'' : '\n') != '\'') {
                    return classLoaderArr2;
                }
                obj.hashCode();
                return classLoaderArr2;
            } catch (Exception e) {
                throw e;
            }
        } catch (Throwable th) {
            Throwable cause = th.getCause();
            if (cause != null) {
                throw cause;
            }
            throw th;
        }
    }

    static void MyBillsEntityDataFactory() {
        moveToNextValue = (char) 42070;
        NetworkUserEntityData$$ExternalSyntheticLambda0 = new char[]{42065, 37257, 37274, 37275, 42071, 42070, 37367, 42068, 37346};
    }

    public static int PlaceComponentResult() {
        int i;
        try {
            int i2 = lookAheadTest + 47;
            getErrorConfigVersion = i2 % 128;
            if ((i2 % 2 != 0 ? Typography.amp : (char) 28) != 28) {
                i = scheduleImpl;
                int i3 = 51 / 0;
            } else {
                i = scheduleImpl;
            }
            int i4 = lookAheadTest + 65;
            getErrorConfigVersion = i4 % 128;
            int i5 = i4 % 2;
            return i;
        } catch (Exception e) {
            throw e;
        }
    }

    private static int PlaceComponentResult(XmlPullParser xmlPullParser, int i) {
        int i2 = lookAheadTest + 33;
        getErrorConfigVersion = i2 % 128;
        try {
            if (i2 % 2 == 0) {
                return Integer.parseInt(xmlPullParser.nextText());
            }
            int parseInt = Integer.parseInt(xmlPullParser.nextText());
            Object[] objArr = null;
            int length = objArr.length;
            return parseInt;
        } catch (NumberFormatException unused) {
            return i;
        }
    }

    private static void PlaceComponentResult(XmlPullParser xmlPullParser) {
        int i = lookAheadTest + 3;
        getErrorConfigVersion = i % 128;
        int i2 = i % 2;
        String nextText = xmlPullParser.nextText();
        try {
            Class.forName(nextText);
            int i3 = lookAheadTest + 73;
            getErrorConfigVersion = i3 % 128;
            int i4 = i3 % 2;
        } catch (ClassNotFoundException unused) {
            PrintStream printStream = System.err;
            StringBuilder sb = new StringBuilder();
            sb.append("Error! A startup class specified in smack-config.xml could not be loaded: ");
            sb.append(nextText);
            printStream.println(sb.toString());
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0039  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0041  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:22:0x0049 -> B:17:0x0032). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void b(byte r8, int r9, short r10, java.lang.Object[] r11) {
        /*
            int r9 = r9 + 4
            int r10 = r10 * 7
            int r10 = r10 + 99
            int r8 = r8 * 3
            int r8 = 16 - r8
            byte[] r0 = com.xiaomi.push.by.getAuthRequestContext
            byte[] r1 = new byte[r8]
            int r8 = r8 + (-1)
            r2 = 83
            r3 = 96
            if (r0 != 0) goto L19
            r4 = 83
            goto L1b
        L19:
            r4 = 96
        L1b:
            r5 = 0
            if (r4 == r3) goto L31
            int r3 = com.xiaomi.push.by.lookAheadTest     // Catch: java.lang.Exception -> L2f
            int r3 = r3 + 1
            int r4 = r3 % 128
            com.xiaomi.push.by.getErrorConfigVersion = r4     // Catch: java.lang.Exception -> L2d
            int r3 = r3 % 2
            r4 = r10
            r3 = 0
            r10 = r9
            r9 = r8
            goto L49
        L2d:
            r8 = move-exception
            throw r8
        L2f:
            r8 = move-exception
            throw r8
        L31:
            r3 = 0
        L32:
            byte r4 = (byte) r10
            r1[r3] = r4
            int r9 = r9 + 1
            if (r3 != r8) goto L41
            java.lang.String r8 = new java.lang.String
            r8.<init>(r1, r5)
            r11[r5] = r8
            return
        L41:
            r4 = r0[r9]
            int r3 = r3 + 1
            r7 = r9
            r9 = r8
            r8 = r10
            r10 = r7
        L49:
            int r4 = -r4
            int r8 = r8 + r4
            int r8 = r8 + 2
            int r4 = com.xiaomi.push.by.getErrorConfigVersion
            int r4 = r4 + r2
            int r6 = r4 % 128
            com.xiaomi.push.by.lookAheadTest = r6
            int r4 = r4 % 2
            r7 = r10
            r10 = r8
            r8 = r9
            r9 = r7
            goto L32
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.by.b(byte, int, short, java.lang.Object[]):void");
    }

    public static int getAuthRequestContext() {
        try {
            int i = lookAheadTest + 111;
            getErrorConfigVersion = i % 128;
            int i2 = i % 2;
            int i3 = PlaceComponentResult;
            int i4 = lookAheadTest + 119;
            getErrorConfigVersion = i4 % 128;
            int i5 = i4 % 2;
            return i3;
        } catch (Exception e) {
            throw e;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:25:0x0070, code lost:
    
        if (r0.MyBillsEntityDataFactory == r0.PlaceComponentResult) goto L32;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x008d, code lost:
    
        if ((r0.MyBillsEntityDataFactory == r0.PlaceComponentResult ? 31 : kotlin.text.Typography.amp) != '&') goto L32;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x008f, code lost:
    
        r3[r0.getAuthRequestContext] = (char) (r0.MyBillsEntityDataFactory - r11);
        r3[r0.getAuthRequestContext + 1] = (char) (r0.PlaceComponentResult - r11);
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x00a2, code lost:
    
        r0.BuiltInFictitiousFunctionClassFactory = r0.MyBillsEntityDataFactory / r2;
        r0.scheduleImpl = r0.MyBillsEntityDataFactory % r2;
        r0.KClassImpl$Data$declaredNonStaticMembers$2 = r0.PlaceComponentResult / r2;
        r0.lookAheadTest = r0.PlaceComponentResult % r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x00bc, code lost:
    
        if (r0.scheduleImpl != r0.lookAheadTest) goto L36;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x00be, code lost:
    
        r7 = '\\';
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x00c1, code lost:
    
        r7 = '^';
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x00c3, code lost:
    
        if (r7 == '^') goto L39;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x00c5, code lost:
    
        r0.BuiltInFictitiousFunctionClassFactory = ((r0.BuiltInFictitiousFunctionClassFactory + r2) - 1) % r2;
        r0.KClassImpl$Data$declaredNonStaticMembers$2 = ((r0.KClassImpl$Data$declaredNonStaticMembers$2 + r2) - 1) % r2;
        r7 = (r0.BuiltInFictitiousFunctionClassFactory * r2) + r0.scheduleImpl;
        r8 = (r0.KClassImpl$Data$declaredNonStaticMembers$2 * r2) + r0.lookAheadTest;
        r3[r0.getAuthRequestContext] = r1[r7];
        r3[r0.getAuthRequestContext + 1] = r1[r8];
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x00f3, code lost:
    
        if (r0.BuiltInFictitiousFunctionClassFactory != r0.KClassImpl$Data$declaredNonStaticMembers$2) goto L46;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x00f5, code lost:
    
        r7 = com.xiaomi.push.by.$11 + 111;
        com.xiaomi.push.by.$10 = r7 % 128;
        r7 = r7 % 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x00ff, code lost:
    
        r0.scheduleImpl = ((r0.scheduleImpl + r2) - 1) % r2;
        r0.lookAheadTest = ((r0.lookAheadTest + r2) - 1) % r2;
        r7 = (r0.BuiltInFictitiousFunctionClassFactory * r2) + r0.scheduleImpl;
        r8 = (r0.KClassImpl$Data$declaredNonStaticMembers$2 * r2) + r0.lookAheadTest;
        r3[r0.getAuthRequestContext] = r1[r7];
        r3[r0.getAuthRequestContext + 1] = r1[r8];
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x0129, code lost:
    
        r10 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x012a, code lost:
    
        throw r10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x012b, code lost:
    
        r7 = (r0.BuiltInFictitiousFunctionClassFactory * r2) + r0.lookAheadTest;
        r8 = (r0.KClassImpl$Data$declaredNonStaticMembers$2 * r2) + r0.scheduleImpl;
        r3[r0.getAuthRequestContext] = r1[r7];
        r3[r0.getAuthRequestContext + 1] = r1[r8];
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void a(char[] r10, byte r11, int r12, java.lang.Object[] r13) {
        /*
            Method dump skipped, instructions count: 369
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.by.a(char[], byte, int, java.lang.Object[]):void");
    }
}
