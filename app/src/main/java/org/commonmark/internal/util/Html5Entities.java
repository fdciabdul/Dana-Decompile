package org.commonmark.internal.util;

import android.media.AudioTrack;
import android.view.ViewConfiguration;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import o.getCallingPid;

/* loaded from: classes6.dex */
public class Html5Entities {
    private static int $10 = 0;
    private static int $11 = 1;
    private static char[] BuiltInFictitiousFunctionClassFactory = null;
    private static char KClassImpl$Data$declaredNonStaticMembers$2 = 0;
    private static final Pattern MyBillsEntityDataFactory;
    private static int NetworkUserEntityData$$ExternalSyntheticLambda0 = 1;
    private static int PlaceComponentResult;
    public static final Map<String, String> getAuthRequestContext;

    static void BuiltInFictitiousFunctionClassFactory() {
        KClassImpl$Data$declaredNonStaticMembers$2 = (char) 42070;
        BuiltInFictitiousFunctionClassFactory = new char[]{42068, 42065, 37257, 37367, 37274, 42071, 37275, 42070, 37346};
    }

    static {
        BuiltInFictitiousFunctionClassFactory();
        getAuthRequestContext = KClassImpl$Data$declaredNonStaticMembers$2();
        MyBillsEntityDataFactory = Pattern.compile("^&#[Xx]?");
        int i = NetworkUserEntityData$$ExternalSyntheticLambda0 + 65;
        PlaceComponentResult = i % 128;
        int i2 = i % 2;
    }

    public static String getAuthRequestContext(String str) {
        int i;
        int parseInt;
        Matcher matcher = MyBillsEntityDataFactory.matcher(str);
        if ((matcher.find() ? ':' : '2') == ':') {
            try {
                int i2 = PlaceComponentResult + 29;
                try {
                    NetworkUserEntityData$$ExternalSyntheticLambda0 = i2 % 128;
                    int i3 = i2 % 2;
                    if (matcher.end() == 2) {
                        int i4 = NetworkUserEntityData$$ExternalSyntheticLambda0 + 27;
                        PlaceComponentResult = i4 % 128;
                        i = (i4 % 2 != 0 ? (char) 3 : 'H') != 3 ? 10 : 90;
                    } else {
                        i = 16;
                    }
                    try {
                        parseInt = Integer.parseInt(str.substring(matcher.end(), str.length() - 1), i);
                    } catch (IllegalArgumentException unused) {
                    }
                    if (parseInt == 0) {
                        int i5 = PlaceComponentResult + 33;
                        NetworkUserEntityData$$ExternalSyntheticLambda0 = i5 % 128;
                        if (i5 % 2 == 0) {
                            Object obj = null;
                            obj.hashCode();
                            return "�";
                        }
                        return "�";
                    }
                    return new String(Character.toChars(parseInt));
                } catch (Exception e) {
                    throw e;
                }
            } catch (Exception e2) {
                throw e2;
            }
        }
        String str2 = getAuthRequestContext.get(str.substring(1, str.length() - 1));
        return str2 == null ? str : str2;
    }

    private static Map<String, String> KClassImpl$Data$declaredNonStaticMembers$2() {
        HashMap hashMap = new HashMap();
        InputStream resourceAsStream = Html5Entities.class.getResourceAsStream("/org/commonmark/internal/util/entities.properties");
        Object[] objArr = new Object[1];
        a(new char[]{3, 7, 5, 2, 13756}, (byte) (27 - (ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1))), 5 - (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)), objArr);
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(resourceAsStream, Charset.forName(((String) objArr[0]).intern())));
            while (true) {
                try {
                    String readLine = bufferedReader.readLine();
                    if ((readLine != null ? 'Y' : 'T') == 'T') {
                        break;
                    }
                    int i = PlaceComponentResult + 31;
                    NetworkUserEntityData$$ExternalSyntheticLambda0 = i % 128;
                    int i2 = i % 2;
                    if (readLine.length() != 0) {
                        int indexOf = readLine.indexOf("=");
                        hashMap.put(readLine.substring(0, indexOf), readLine.substring(indexOf + 1));
                    }
                } finally {
                }
            }
            bufferedReader.close();
            hashMap.put("NewLine", "\n");
            int i3 = NetworkUserEntityData$$ExternalSyntheticLambda0 + 119;
            PlaceComponentResult = i3 % 128;
            if ((i3 % 2 != 0 ? 'D' : 'L') != 'D') {
                return hashMap;
            }
            int i4 = 36 / 0;
            return hashMap;
        } catch (IOException e) {
            throw new IllegalStateException("Failed reading data for HTML named character references", e);
        }
    }

    private static void a(char[] cArr, byte b, int i, Object[] objArr) {
        int i2;
        getCallingPid getcallingpid = new getCallingPid();
        char[] cArr2 = BuiltInFictitiousFunctionClassFactory;
        if (cArr2 != null) {
            int length = cArr2.length;
            char[] cArr3 = new char[length];
            int i3 = $10 + 87;
            $11 = i3 % 128;
            int i4 = i3 % 2;
            for (int i5 = 0; i5 < length; i5++) {
                cArr3[i5] = (char) (cArr2[i5] ^ (-1549216646985767851L));
            }
            cArr2 = cArr3;
        }
        char c = (char) ((-1549216646985767851L) ^ KClassImpl$Data$declaredNonStaticMembers$2);
        char[] cArr4 = new char[i];
        if (i % 2 != 0) {
            i2 = i - 1;
            cArr4[i2] = (char) (cArr[i2] - b);
        } else {
            i2 = i;
        }
        if (i2 > 1) {
            try {
                getcallingpid.getAuthRequestContext = 0;
                while (getcallingpid.getAuthRequestContext < i2) {
                    getcallingpid.MyBillsEntityDataFactory = cArr[getcallingpid.getAuthRequestContext];
                    getcallingpid.PlaceComponentResult = cArr[getcallingpid.getAuthRequestContext + 1];
                    if ((getcallingpid.MyBillsEntityDataFactory == getcallingpid.PlaceComponentResult ? '/' : (char) 7) != 7) {
                        int i6 = $10 + 121;
                        $11 = i6 % 128;
                        int i7 = i6 % 2;
                        cArr4[getcallingpid.getAuthRequestContext] = (char) (getcallingpid.MyBillsEntityDataFactory - b);
                        cArr4[getcallingpid.getAuthRequestContext + 1] = (char) (getcallingpid.PlaceComponentResult - b);
                    } else {
                        getcallingpid.BuiltInFictitiousFunctionClassFactory = getcallingpid.MyBillsEntityDataFactory / c;
                        getcallingpid.scheduleImpl = getcallingpid.MyBillsEntityDataFactory % c;
                        getcallingpid.KClassImpl$Data$declaredNonStaticMembers$2 = getcallingpid.PlaceComponentResult / c;
                        getcallingpid.lookAheadTest = getcallingpid.PlaceComponentResult % c;
                        if (getcallingpid.scheduleImpl == getcallingpid.lookAheadTest) {
                            getcallingpid.BuiltInFictitiousFunctionClassFactory = ((getcallingpid.BuiltInFictitiousFunctionClassFactory + c) - 1) % c;
                            getcallingpid.KClassImpl$Data$declaredNonStaticMembers$2 = ((getcallingpid.KClassImpl$Data$declaredNonStaticMembers$2 + c) - 1) % c;
                            int i8 = (getcallingpid.BuiltInFictitiousFunctionClassFactory * c) + getcallingpid.scheduleImpl;
                            int i9 = (getcallingpid.KClassImpl$Data$declaredNonStaticMembers$2 * c) + getcallingpid.lookAheadTest;
                            cArr4[getcallingpid.getAuthRequestContext] = cArr2[i8];
                            cArr4[getcallingpid.getAuthRequestContext + 1] = cArr2[i9];
                        } else if (getcallingpid.BuiltInFictitiousFunctionClassFactory == getcallingpid.KClassImpl$Data$declaredNonStaticMembers$2) {
                            try {
                                int i10 = $10 + 91;
                                $11 = i10 % 128;
                                int i11 = i10 % 2;
                                getcallingpid.scheduleImpl = ((getcallingpid.scheduleImpl + c) - 1) % c;
                                getcallingpid.lookAheadTest = ((getcallingpid.lookAheadTest + c) - 1) % c;
                                int i12 = (getcallingpid.BuiltInFictitiousFunctionClassFactory * c) + getcallingpid.scheduleImpl;
                                int i13 = (getcallingpid.KClassImpl$Data$declaredNonStaticMembers$2 * c) + getcallingpid.lookAheadTest;
                                cArr4[getcallingpid.getAuthRequestContext] = cArr2[i12];
                                cArr4[getcallingpid.getAuthRequestContext + 1] = cArr2[i13];
                            } catch (Exception e) {
                                throw e;
                            }
                        } else {
                            int i14 = (getcallingpid.BuiltInFictitiousFunctionClassFactory * c) + getcallingpid.lookAheadTest;
                            int i15 = (getcallingpid.KClassImpl$Data$declaredNonStaticMembers$2 * c) + getcallingpid.scheduleImpl;
                            cArr4[getcallingpid.getAuthRequestContext] = cArr2[i14];
                            cArr4[getcallingpid.getAuthRequestContext + 1] = cArr2[i15];
                        }
                    }
                    getcallingpid.getAuthRequestContext += 2;
                }
            } catch (Exception e2) {
                throw e2;
            }
        }
        int i16 = 0;
        while (true) {
            if ((i16 < i ? '\n' : 'D') != 'D') {
                int i17 = $11 + 11;
                $10 = i17 % 128;
                int i18 = i17 % 2;
                cArr4[i16] = (char) (cArr4[i16] ^ 13722);
                i16++;
            } else {
                objArr[0] = new String(cArr4);
                return;
            }
        }
    }
}
