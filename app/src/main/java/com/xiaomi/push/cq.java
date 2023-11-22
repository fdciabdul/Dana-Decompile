package com.xiaomi.push;

import android.text.AndroidCharacter;
import com.google.firebase.perf.network.FirebasePerfUrlConnection;
import com.j256.ormlite.stmt.query.SimpleComparison;
import j$.util.concurrent.ConcurrentHashMap;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Map;
import kotlin.text.Typography;
import o.D;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

/* loaded from: classes8.dex */
public class cq {
    private static int $10 = 0;
    private static int $11 = 1;
    public static final byte[] BuiltInFictitiousFunctionClassFactory;
    public static final int KClassImpl$Data$declaredNonStaticMembers$2;
    private static cq MyBillsEntityDataFactory = null;
    private static int NetworkUserEntityData$$ExternalSyntheticLambda0 = 0;
    private static int getErrorConfigVersion = 1;
    private static long moveToNextValue;
    private Map<String, Object> PlaceComponentResult;
    private Map<String, Object> getAuthRequestContext;

    static {
        PlaceComponentResult();
        BuiltInFictitiousFunctionClassFactory = new byte[]{90, -83, 93, -67, 16, -5, -2, -15, 7, 4, -34, 18, 8, -15, -6, 1, -11, 19, -23, -53, 60, -13, 11, -9, -59, 36, 18, 8, -15, -6, 1};
        KClassImpl$Data$declaredNonStaticMembers$2 = 28;
        int i = NetworkUserEntityData$$ExternalSyntheticLambda0 + 7;
        getErrorConfigVersion = i % 128;
        if (!(i % 2 != 0)) {
            Object[] objArr = null;
            int length = objArr.length;
        }
    }

    private cq() {
        try {
            this.PlaceComponentResult = new ConcurrentHashMap();
            try {
                this.getAuthRequestContext = new ConcurrentHashMap();
                BuiltInFictitiousFunctionClassFactory();
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    private void BuiltInFictitiousFunctionClassFactory() {
        InputStream openStream;
        Map<String, Object> map;
        Object obj;
        Map<String, Object> map2;
        Object obj2;
        int i = getErrorConfigVersion + 67;
        NetworkUserEntityData$$ExternalSyntheticLambda0 = i % 128;
        int i2 = i % 2;
        try {
            char c = 0;
            for (ClassLoader classLoader : MyBillsEntityDataFactory()) {
                Enumeration<URL> resources = classLoader.getResources("META-INF/smack.providers");
                while (true) {
                    if ((resources.hasMoreElements() ? '-' : '\r') != '-') {
                        break;
                    }
                    int i3 = NetworkUserEntityData$$ExternalSyntheticLambda0 + 71;
                    getErrorConfigVersion = i3 % 128;
                    int i4 = i3 % 2;
                    InputStream inputStream = null;
                    try {
                        openStream = FirebasePerfUrlConnection.openStream(resources.nextElement());
                    } catch (Throwable th) {
                        th = th;
                    }
                    try {
                        XmlPullParser newPullParser = XmlPullParserFactory.newInstance().newPullParser();
                        newPullParser.setFeature("http://xmlpull.org/v1/doc/features.html#process-namespaces", true);
                        int mirror = AndroidCharacter.getMirror('0') - '0';
                        char[] cArr = new char[9];
                        cArr[c] = 42027;
                        cArr[1] = 42110;
                        cArr[2] = 59942;
                        cArr[3] = 24513;
                        cArr[4] = 7072;
                        int i5 = 5;
                        cArr[5] = 16772;
                        cArr[6] = 48163;
                        cArr[7] = 38111;
                        cArr[8] = 25435;
                        Object[] objArr = new Object[1];
                        b(mirror, cArr, objArr);
                        newPullParser.setInput(openStream, ((String) objArr[c]).intern());
                        int eventType = newPullParser.getEventType();
                        while (true) {
                            if (eventType == 2) {
                                if (!(!newPullParser.getName().equals("iqProvider"))) {
                                    int i6 = getErrorConfigVersion + 23;
                                    NetworkUserEntityData$$ExternalSyntheticLambda0 = i6 % 128;
                                    int i7 = i6 % 2;
                                    newPullParser.next();
                                    newPullParser.next();
                                    String nextText = newPullParser.nextText();
                                    newPullParser.next();
                                    newPullParser.next();
                                    String nextText2 = newPullParser.nextText();
                                    newPullParser.next();
                                    newPullParser.next();
                                    String nextText3 = newPullParser.nextText();
                                    String KClassImpl$Data$declaredNonStaticMembers$22 = KClassImpl$Data$declaredNonStaticMembers$2(nextText, nextText2);
                                    if ((!this.getAuthRequestContext.containsKey(KClassImpl$Data$declaredNonStaticMembers$22) ? Typography.amp : Typography.dollar) == '&') {
                                        Class<?> cls = Class.forName(nextText3);
                                        if (!(!co.class.isAssignableFrom(cls))) {
                                            map = this.getAuthRequestContext;
                                            Object newInstance = cls.newInstance();
                                            int i8 = NetworkUserEntityData$$ExternalSyntheticLambda0 + 11;
                                            getErrorConfigVersion = i8 % 128;
                                            int i9 = i8 % 2;
                                            obj = newInstance;
                                        } else if (ch.class.isAssignableFrom(cls)) {
                                            map = this.getAuthRequestContext;
                                            obj = cls;
                                        }
                                        map.put(KClassImpl$Data$declaredNonStaticMembers$22, obj);
                                    }
                                } else if (newPullParser.getName().equals("extensionProvider")) {
                                    int i10 = NetworkUserEntityData$$ExternalSyntheticLambda0 + 49;
                                    getErrorConfigVersion = i10 % 128;
                                    int i11 = i10 % 2;
                                    newPullParser.next();
                                    newPullParser.next();
                                    String nextText4 = newPullParser.nextText();
                                    newPullParser.next();
                                    newPullParser.next();
                                    String nextText5 = newPullParser.nextText();
                                    newPullParser.next();
                                    newPullParser.next();
                                    String nextText6 = newPullParser.nextText();
                                    String KClassImpl$Data$declaredNonStaticMembers$23 = KClassImpl$Data$declaredNonStaticMembers$2(nextText4, nextText5);
                                    if ((!this.PlaceComponentResult.containsKey(KClassImpl$Data$declaredNonStaticMembers$23) ? '`' : (char) 18) != 18) {
                                        try {
                                            Class<?> cls2 = Class.forName(nextText6);
                                            if (cp.class.isAssignableFrom(cls2)) {
                                                int i12 = getErrorConfigVersion + i5;
                                                NetworkUserEntityData$$ExternalSyntheticLambda0 = i12 % 128;
                                                int i13 = i12 % 2;
                                                map2 = this.PlaceComponentResult;
                                                Object newInstance2 = cls2.newInstance();
                                                int i14 = getErrorConfigVersion + 119;
                                                NetworkUserEntityData$$ExternalSyntheticLambda0 = i14 % 128;
                                                int i15 = i14 % 2;
                                                obj2 = newInstance2;
                                            } else if ((ck.class.isAssignableFrom(cls2) ? 'H' : 'N') == 'H') {
                                                int i16 = getErrorConfigVersion + 113;
                                                NetworkUserEntityData$$ExternalSyntheticLambda0 = i16 % 128;
                                                int i17 = i16 % 2;
                                                map2 = this.PlaceComponentResult;
                                                obj2 = cls2;
                                            }
                                            map2.put(KClassImpl$Data$declaredNonStaticMembers$23, obj2);
                                        } catch (ClassNotFoundException unused) {
                                        }
                                    }
                                }
                            }
                            eventType = newPullParser.next();
                            if (eventType == 1) {
                                break;
                            }
                            i5 = 5;
                        }
                        int i18 = getErrorConfigVersion + 109;
                        NetworkUserEntityData$$ExternalSyntheticLambda0 = i18 % 128;
                        if ((i18 % 2 != 0 ? '7' : '\t') != '\t') {
                            try {
                                openStream.close();
                                inputStream.hashCode();
                            } catch (Exception unused2) {
                            }
                        } else {
                            openStream.close();
                        }
                        c = 0;
                    } catch (Throwable th2) {
                        th = th2;
                        inputStream = openStream;
                        try {
                            inputStream.close();
                        } catch (Exception unused3) {
                        }
                        throw th;
                    }
                }
            }
        } catch (Exception unused4) {
        }
    }

    public static cq KClassImpl$Data$declaredNonStaticMembers$2() {
        cq cqVar;
        synchronized (cq.class) {
            if (MyBillsEntityDataFactory == null) {
                MyBillsEntityDataFactory = new cq();
            }
            cqVar = MyBillsEntityDataFactory;
        }
        return cqVar;
    }

    private static String KClassImpl$Data$declaredNonStaticMembers$2(String str, String str2) {
        StringBuilder sb = new StringBuilder();
        sb.append(SimpleComparison.LESS_THAN_OPERATION);
        sb.append(str);
        sb.append("/>");
        if ((str != null ? 'V' : 'I') == 'V') {
            int i = NetworkUserEntityData$$ExternalSyntheticLambda0 + 35;
            getErrorConfigVersion = i % 128;
            int i2 = i % 2;
            sb.append(SimpleComparison.LESS_THAN_OPERATION);
            sb.append(str2);
            sb.append("/>");
        }
        String obj = sb.toString();
        int i3 = getErrorConfigVersion + 85;
        NetworkUserEntityData$$ExternalSyntheticLambda0 = i3 % 128;
        int i4 = i3 % 2;
        return obj;
    }

    private static ClassLoader[] MyBillsEntityDataFactory() {
        int i = NetworkUserEntityData$$ExternalSyntheticLambda0 + 35;
        getErrorConfigVersion = i % 128;
        int i2 = i % 2;
        ClassLoader[] classLoaderArr = new ClassLoader[2];
        classLoaderArr[0] = cq.class.getClassLoader();
        try {
            byte b = BuiltInFictitiousFunctionClassFactory[15];
            Object[] objArr = new Object[1];
            a(b, (byte) (b - 1), BuiltInFictitiousFunctionClassFactory[15], objArr);
            Class<?> cls = Class.forName((String) objArr[0]);
            byte b2 = (byte) (BuiltInFictitiousFunctionClassFactory[15] - 1);
            byte b3 = BuiltInFictitiousFunctionClassFactory[15];
            Object[] objArr2 = new Object[1];
            a(b2, b3, (byte) (b3 - 1), objArr2);
            classLoaderArr[1] = ((Thread) cls.getMethod((String) objArr2[0], null).invoke(null, null)).getContextClassLoader();
            ArrayList arrayList = new ArrayList();
            int i3 = 0;
            while (true) {
                if ((i3 < 2 ? (char) 20 : '=') != 20) {
                    return (ClassLoader[]) arrayList.toArray(new ClassLoader[arrayList.size()]);
                }
                int i4 = getErrorConfigVersion + 27;
                NetworkUserEntityData$$ExternalSyntheticLambda0 = i4 % 128;
                int i5 = i4 % 2;
                ClassLoader classLoader = classLoaderArr[i3];
                if (!(classLoader == null)) {
                    try {
                        arrayList.add(classLoader);
                        int i6 = NetworkUserEntityData$$ExternalSyntheticLambda0 + 23;
                        getErrorConfigVersion = i6 % 128;
                        int i7 = i6 % 2;
                    } catch (Exception e) {
                        throw e;
                    }
                }
                i3++;
            }
        } catch (Throwable th) {
            Throwable cause = th.getCause();
            if (cause != null) {
                throw cause;
            }
            throw th;
        }
    }

    static void PlaceComponentResult() {
        moveToNextValue = 3550700597586279482L;
    }

    /* JADX WARN: Removed duplicated region for block: B:37:0x003f  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0052  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:34:0x0035 -> B:35:0x0038). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void a(short r5, int r6, int r7, java.lang.Object[] r8) {
        /*
            int r5 = r5 * 3
            int r5 = r5 + 13
            int r7 = r7 * 7
            int r7 = r7 + 99
            int r6 = r6 * 12
            int r6 = 15 - r6
            byte[] r0 = com.xiaomi.push.cq.BuiltInFictitiousFunctionClassFactory     // Catch: java.lang.Exception -> L57
            byte[] r1 = new byte[r5]     // Catch: java.lang.Exception -> L57
            r2 = -1
            int r5 = r5 + r2
            r3 = 17
            if (r0 != 0) goto L19
            r4 = 17
            goto L1b
        L19:
            r4 = 45
        L1b:
            if (r4 == r3) goto L24
            r2 = r1
            r3 = -1
            r1 = r0
            r0 = r8
            r8 = r6
            r6 = r5
            goto L38
        L24:
            int r7 = com.xiaomi.push.cq.NetworkUserEntityData$$ExternalSyntheticLambda0     // Catch: java.lang.Exception -> L57
            int r7 = r7 + 125
            int r3 = r7 % 128
            com.xiaomi.push.cq.getErrorConfigVersion = r3     // Catch: java.lang.Exception -> L57
            int r7 = r7 % 2
            r7 = r6
            r2 = r1
            r3 = -1
            r6 = r5
            r1 = r0
            r0 = r8
            r8 = r7
        L35:
            int r7 = r7 + r5
            int r7 = r7 + 2
        L38:
            int r3 = r3 + 1
            byte r5 = (byte) r7
            r2[r3] = r5
            if (r3 != r6) goto L52
            java.lang.String r5 = new java.lang.String
            r6 = 0
            r5.<init>(r2, r6)
            int r7 = com.xiaomi.push.cq.NetworkUserEntityData$$ExternalSyntheticLambda0
            int r7 = r7 + 23
            int r8 = r7 % 128
            com.xiaomi.push.cq.getErrorConfigVersion = r8
            int r7 = r7 % 2
            r0[r6] = r5
            return
        L52:
            int r8 = r8 + 1
            r5 = r1[r8]
            goto L35
        L57:
            r5 = move-exception
            goto L5a
        L59:
            throw r5
        L5a:
            goto L59
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.cq.a(short, int, int, java.lang.Object[]):void");
    }

    public final void BuiltInFictitiousFunctionClassFactory(String str, String str2, Object obj) {
        int i = getErrorConfigVersion + 81;
        NetworkUserEntityData$$ExternalSyntheticLambda0 = i % 128;
        int i2 = i % 2;
        this.PlaceComponentResult.put(KClassImpl$Data$declaredNonStaticMembers$2(str, str2), obj);
        int i3 = getErrorConfigVersion + 21;
        NetworkUserEntityData$$ExternalSyntheticLambda0 = i3 % 128;
        if ((i3 % 2 != 0 ? (char) 3 : (char) 20) != 20) {
            int i4 = 30 / 0;
        }
    }

    public final Object MyBillsEntityDataFactory(String str, String str2) {
        int i = NetworkUserEntityData$$ExternalSyntheticLambda0 + 27;
        getErrorConfigVersion = i % 128;
        boolean z = i % 2 != 0;
        Object obj = this.PlaceComponentResult.get(KClassImpl$Data$declaredNonStaticMembers$2(str, str2));
        if (!z) {
            Object obj2 = null;
            obj2.hashCode();
        }
        return obj;
    }

    private static void b(int i, char[] cArr, Object[] objArr) {
        D d = new D();
        char[] KClassImpl$Data$declaredNonStaticMembers$22 = D.KClassImpl$Data$declaredNonStaticMembers$2(moveToNextValue ^ 3919452569568103912L, cArr, i);
        d.MyBillsEntityDataFactory = 4;
        int i2 = $11 + 63;
        $10 = i2 % 128;
        int i3 = i2 % 2;
        while (true) {
            if ((d.MyBillsEntityDataFactory < KClassImpl$Data$declaredNonStaticMembers$22.length ? (char) 6 : ':') != ':') {
                d.PlaceComponentResult = d.MyBillsEntityDataFactory - 4;
                KClassImpl$Data$declaredNonStaticMembers$22[d.MyBillsEntityDataFactory] = (char) ((KClassImpl$Data$declaredNonStaticMembers$22[d.MyBillsEntityDataFactory] ^ KClassImpl$Data$declaredNonStaticMembers$22[d.MyBillsEntityDataFactory % 4]) ^ (d.PlaceComponentResult * (moveToNextValue ^ 3919452569568103912L)));
                d.MyBillsEntityDataFactory++;
            } else {
                String str = new String(KClassImpl$Data$declaredNonStaticMembers$22, 4, KClassImpl$Data$declaredNonStaticMembers$22.length - 4);
                try {
                    int i4 = $10 + 69;
                    try {
                        $11 = i4 % 128;
                        int i5 = i4 % 2;
                        objArr[0] = str;
                        return;
                    } catch (Exception e) {
                        throw e;
                    }
                } catch (Exception e2) {
                    throw e2;
                }
            }
        }
    }
}
