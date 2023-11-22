package id.dana.utils;

import android.graphics.Color;
import android.net.Uri;
import android.text.TextUtils;
import android.view.ViewConfiguration;
import com.huawei.hms.framework.common.ContainerUtils;
import id.dana.animation.HomeTabActivity;
import id.dana.data.constant.DanaUrl;
import id.dana.domain.paylater.model.UserLoanInfo;
import id.dana.utils.foundation.logger.log.DanaLog;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import o.getOnBoardingScenario;

/* loaded from: classes3.dex */
public class UrlUtil {
    private static int $10 = 0;
    private static int $11 = 1;
    private static int BuiltInFictitiousFunctionClassFactory = 0;
    private static final List<String> KClassImpl$Data$declaredNonStaticMembers$2;
    private static int MyBillsEntityDataFactory = 1;
    private static long PlaceComponentResult;

    static void BuiltInFictitiousFunctionClassFactory() {
        PlaceComponentResult = 8786292040112492752L;
    }

    static {
        BuiltInFictitiousFunctionClassFactory();
        KClassImpl$Data$declaredNonStaticMembers$2 = Collections.unmodifiableList(Arrays.asList(HomeTabActivity.DEEPLINK_PAYMENT_PATH, "/bind", "/oauth", "/qrbinding", "/accashierpayment", DanaUrl.PUSH_VERIFY));
        int i = MyBillsEntityDataFactory + 63;
        BuiltInFictitiousFunctionClassFactory = i % 128;
        int i2 = i % 2;
    }

    private UrlUtil() {
    }

    public static String getAuthRequestContext(String str) {
        int i = BuiltInFictitiousFunctionClassFactory + 101;
        MyBillsEntityDataFactory = i % 128;
        if (i % 2 == 0) {
            try {
                int i2 = 94 / 0;
                if (!(!TextUtils.isEmpty(str))) {
                    return str;
                }
            } catch (Exception e) {
                throw e;
            }
        } else if (TextUtils.isEmpty(str)) {
            return str;
        }
        if (str.startsWith("https://") ? false : true) {
            int i3 = MyBillsEntityDataFactory + 91;
            BuiltInFictitiousFunctionClassFactory = i3 % 128;
            if (i3 % 2 != 0) {
                int i4 = 4 / 0;
                if (str.startsWith("http://")) {
                    return str;
                }
            } else if (str.startsWith("http://")) {
                return str;
            }
            try {
                if (str.startsWith("file:///")) {
                    int i5 = MyBillsEntityDataFactory + 67;
                    BuiltInFictitiousFunctionClassFactory = i5 % 128;
                    if (i5 % 2 != 0) {
                        Object obj = null;
                        obj.hashCode();
                        return str;
                    }
                    return str;
                }
                StringBuilder sb = new StringBuilder();
                sb.append("https://m.dana.id");
                sb.append(str);
                String obj2 = sb.toString();
                int i6 = BuiltInFictitiousFunctionClassFactory + 15;
                MyBillsEntityDataFactory = i6 % 128;
                int i7 = i6 % 2;
                return obj2;
            } catch (Exception e2) {
                throw e2;
            }
        }
        return str;
    }

    public static Boolean lookAheadTest(String str) {
        boolean z = true;
        if ((!str.startsWith("https://") ? (char) 3 : '+') == 3) {
            int i = MyBillsEntityDataFactory + 51;
            BuiltInFictitiousFunctionClassFactory = i % 128;
            int i2 = i % 2;
            if ((!str.startsWith("http://") ? (char) 28 : '(') != '(') {
                try {
                    int i3 = MyBillsEntityDataFactory + 115;
                    BuiltInFictitiousFunctionClassFactory = i3 % 128;
                    if (i3 % 2 == 0) {
                        z = false;
                    }
                } catch (Exception e) {
                    throw e;
                }
            }
        }
        return Boolean.valueOf(z);
    }

    /* JADX WARN: Code restructure failed: missing block: B:42:0x0018, code lost:
    
        if (r0.getBooleanQueryParameter("entryPoint", true) != false) goto L70;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x0028, code lost:
    
        if ((!r0.getBooleanQueryParameter("entryPoint", false)) != false) goto L49;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x003a, code lost:
    
        return r0.buildUpon().appendQueryParameter("entryPoint", r6).build().toString();
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x003d, code lost:
    
        r6 = id.dana.utils.UrlUtil.MyBillsEntityDataFactory + 61;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x0041, code lost:
    
        id.dana.utils.UrlUtil.BuiltInFictitiousFunctionClassFactory = r6 % 128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x0045, code lost:
    
        if ((r6 % 2) == 0) goto L56;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x0048, code lost:
    
        r1 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x0049, code lost:
    
        if (r1 == false) goto L63;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x004d, code lost:
    
        r6 = 95 / 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x0051, code lost:
    
        return r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x0052, code lost:
    
        r5 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x0053, code lost:
    
        throw r5;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String getAuthRequestContext(java.lang.String r5, java.lang.String r6) {
        /*
            int r0 = id.dana.utils.UrlUtil.MyBillsEntityDataFactory
            int r0 = r0 + 115
            int r1 = r0 % 128
            id.dana.utils.UrlUtil.BuiltInFictitiousFunctionClassFactory = r1
            int r0 = r0 % 2
            r1 = 1
            java.lang.String r2 = "entryPoint"
            r3 = 0
            if (r0 == 0) goto L1b
            android.net.Uri r0 = android.net.Uri.parse(r5)
            boolean r4 = r0.getBooleanQueryParameter(r2, r1)
            if (r4 == 0) goto L2a
            goto L3b
        L1b:
            android.net.Uri r0 = android.net.Uri.parse(r5)     // Catch: java.lang.Exception -> L54
            boolean r4 = r0.getBooleanQueryParameter(r2, r3)     // Catch: java.lang.Exception -> L54
            if (r4 == 0) goto L27
            r4 = 0
            goto L28
        L27:
            r4 = 1
        L28:
            if (r4 == 0) goto L3b
        L2a:
            android.net.Uri$Builder r5 = r0.buildUpon()
            android.net.Uri$Builder r5 = r5.appendQueryParameter(r2, r6)
            android.net.Uri r5 = r5.build()
            java.lang.String r5 = r5.toString()
            return r5
        L3b:
            int r6 = id.dana.utils.UrlUtil.MyBillsEntityDataFactory     // Catch: java.lang.Exception -> L52
            int r6 = r6 + 61
            int r0 = r6 % 128
            id.dana.utils.UrlUtil.BuiltInFictitiousFunctionClassFactory = r0     // Catch: java.lang.Exception -> L52
            int r6 = r6 % 2
            if (r6 == 0) goto L48
            goto L49
        L48:
            r1 = 0
        L49:
            if (r1 == 0) goto L51
            r6 = 95
            int r6 = r6 / r3
            goto L51
        L4f:
            r5 = move-exception
            throw r5
        L51:
            return r5
        L52:
            r5 = move-exception
            throw r5
        L54:
            r5 = move-exception
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.utils.UrlUtil.getAuthRequestContext(java.lang.String, java.lang.String):java.lang.String");
    }

    public static String BuiltInFictitiousFunctionClassFactory(String str, String str2) {
        Object[] objArr = new Object[1];
        a(26479 - (ViewConfiguration.getDoubleTapTimeout() >> 16), new char[]{33255, 59027, 20285, 47019, 7263}, objArr);
        Object obj = null;
        if ((str.contains(((String) objArr[0]).intern()) ? ',' : '2') == ',') {
            int i = BuiltInFictitiousFunctionClassFactory + 17;
            MyBillsEntityDataFactory = i % 128;
            if ((i % 2 == 0 ? '3' : 'M') != '3') {
                str = initRecordTimeStamp(str2);
            } else {
                str = initRecordTimeStamp(str2);
                obj.hashCode();
            }
            int i2 = MyBillsEntityDataFactory + 25;
            BuiltInFictitiousFunctionClassFactory = i2 % 128;
            int i3 = i2 % 2;
        }
        String authRequestContext = getAuthRequestContext(str);
        int i4 = BuiltInFictitiousFunctionClassFactory + 53;
        MyBillsEntityDataFactory = i4 % 128;
        if (i4 % 2 != 0) {
            return authRequestContext;
        }
        obj.hashCode();
        return authRequestContext;
    }

    private static String initRecordTimeStamp(String str) {
        int i = MyBillsEntityDataFactory + 87;
        BuiltInFictitiousFunctionClassFactory = i % 128;
        int i2 = i % 2;
        String MyBillsEntityDataFactory2 = TagFormat.MyBillsEntityDataFactory(DanaUrl.TOPUP).MyBillsEntityDataFactory("entryPoint", str).MyBillsEntityDataFactory();
        int i3 = BuiltInFictitiousFunctionClassFactory + 3;
        MyBillsEntityDataFactory = i3 % 128;
        if ((i3 % 2 == 0 ? '/' : (char) 22) != 22) {
            Object obj = null;
            obj.hashCode();
            return MyBillsEntityDataFactory2;
        }
        return MyBillsEntityDataFactory2;
    }

    public static String NetworkUserEntityData$$ExternalSyntheticLambda0(String str) {
        int indexOf;
        int i = BuiltInFictitiousFunctionClassFactory + 117;
        MyBillsEntityDataFactory = i % 128;
        int i2 = i % 2;
        int indexOf2 = str.indexOf(35);
        if ((indexOf2 != -1 ? 'A' : '\n') != '\n') {
            int i3 = MyBillsEntityDataFactory + 65;
            BuiltInFictitiousFunctionClassFactory = i3 % 128;
            if (i3 % 2 != 0) {
                try {
                    str = str.substring(1, indexOf2);
                } catch (Exception e) {
                    throw e;
                }
            } else {
                str = str.substring(0, indexOf2);
            }
        }
        return ((!str.contains("??")) && (indexOf = str.indexOf(63)) != -1) ? str.substring(0, indexOf) : str;
    }

    public static boolean getErrorConfigVersion(String str) {
        int i = BuiltInFictitiousFunctionClassFactory + 103;
        MyBillsEntityDataFactory = i % 128;
        int i2 = i % 2;
        if ((!TextUtils.isEmpty(str) ? 'B' : 'a') != 'a') {
            try {
                int i3 = BuiltInFictitiousFunctionClassFactory + 115;
                MyBillsEntityDataFactory = i3 % 128;
                if (i3 % 2 == 0) {
                    int i4 = 40 / 0;
                    if ((str.trim().contains(DanaUrl.DEEPLINK_URL) ? 'J' : '\r') != 'J') {
                        return false;
                    }
                } else if (!str.trim().contains(DanaUrl.DEEPLINK_URL)) {
                    return false;
                }
                int i5 = MyBillsEntityDataFactory + 23;
                BuiltInFictitiousFunctionClassFactory = i5 % 128;
                return (i5 % 2 != 0 ? 'W' : '\'') == '\'';
            } catch (Exception e) {
                throw e;
            }
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:48:0x0048  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x004b A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:51:0x004c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean BuiltInFictitiousFunctionClassFactory(java.lang.String r4) {
        /*
            boolean r0 = android.text.TextUtils.isEmpty(r4)
            r1 = 0
            r2 = 1
            if (r0 != 0) goto L30
            int r0 = id.dana.utils.UrlUtil.MyBillsEntityDataFactory
            int r0 = r0 + 109
            int r3 = r0 % 128
            id.dana.utils.UrlUtil.BuiltInFictitiousFunctionClassFactory = r3
            int r0 = r0 % 2
            java.lang.String r4 = r4.trim()     // Catch: java.lang.Exception -> L53
            java.lang.String r0 = "https://danaindonesia-alternate.app.link/"
            boolean r4 = r4.contains(r0)     // Catch: java.lang.Exception -> L53
            if (r4 == 0) goto L20
            r4 = 1
            goto L21
        L20:
            r4 = 0
        L21:
            if (r4 == r2) goto L24
            goto L30
        L24:
            int r4 = id.dana.utils.UrlUtil.MyBillsEntityDataFactory
            int r4 = r4 + 37
            int r0 = r4 % 128
            id.dana.utils.UrlUtil.BuiltInFictitiousFunctionClassFactory = r0
            int r4 = r4 % 2
            r4 = 1
            goto L3b
        L30:
            int r4 = id.dana.utils.UrlUtil.BuiltInFictitiousFunctionClassFactory     // Catch: java.lang.Exception -> L53
            int r4 = r4 + 69
            int r0 = r4 % 128
            id.dana.utils.UrlUtil.MyBillsEntityDataFactory = r0     // Catch: java.lang.Exception -> L53
            int r4 = r4 % 2
            r4 = 0
        L3b:
            int r0 = id.dana.utils.UrlUtil.MyBillsEntityDataFactory
            int r0 = r0 + 9
            int r3 = r0 % 128
            id.dana.utils.UrlUtil.BuiltInFictitiousFunctionClassFactory = r3
            int r0 = r0 % 2
            if (r0 == 0) goto L48
            goto L49
        L48:
            r1 = 1
        L49:
            if (r1 == 0) goto L4c
            return r4
        L4c:
            r0 = 0
            r0.hashCode()     // Catch: java.lang.Throwable -> L51
            return r4
        L51:
            r4 = move-exception
            throw r4
        L53:
            r4 = move-exception
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.utils.UrlUtil.BuiltInFictitiousFunctionClassFactory(java.lang.String):boolean");
    }

    /* JADX WARN: Code restructure failed: missing block: B:55:0x0016, code lost:
    
        if ((r4 == null) != true) goto L84;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x001b, code lost:
    
        if (r4 == null) goto L86;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x001d, code lost:
    
        r4 = id.dana.utils.UrlUtil.BuiltInFictitiousFunctionClassFactory + 47;
        id.dana.utils.UrlUtil.MyBillsEntityDataFactory = r4 % 128;
        r4 = r4 % 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x0027, code lost:
    
        return false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x0028, code lost:
    
        r4 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x0030, code lost:
    
        if (r4.contains("dana") == false) goto L80;
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x0032, code lost:
    
        r0 = id.dana.utils.UrlUtil.MyBillsEntityDataFactory + 57;
        id.dana.utils.UrlUtil.BuiltInFictitiousFunctionClassFactory = r0 % 128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x003c, code lost:
    
        if ((r0 % 2) == 0) goto L69;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x003e, code lost:
    
        r0 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x0040, code lost:
    
        r0 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x0043, code lost:
    
        if (r0 == false) goto L73;
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x0045, code lost:
    
        r4.contains("open?_branch_referrer");
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x004e, code lost:
    
        if (r4.contains("open?_branch_referrer") == false) goto L76;
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x0050, code lost:
    
        r4 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x0052, code lost:
    
        r4 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:77:0x0053, code lost:
    
        if (r4 == true) goto L91;
     */
    /* JADX WARN: Code restructure failed: missing block: B:79:0x0056, code lost:
    
        throw r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:80:0x0057, code lost:
    
        return false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:82:0x0059, code lost:
    
        r4 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:83:0x005a, code lost:
    
        throw r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:90:?, code lost:
    
        return true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:91:?, code lost:
    
        return true;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean moveToNextValue(java.lang.String r4) {
        /*
            int r0 = id.dana.utils.UrlUtil.BuiltInFictitiousFunctionClassFactory
            int r0 = r0 + 111
            int r1 = r0 % 128
            id.dana.utils.UrlUtil.MyBillsEntityDataFactory = r1
            int r0 = r0 % 2
            r1 = 1
            r2 = 0
            if (r0 != 0) goto L1b
            r0 = 28
            int r0 = r0 / r2
            if (r4 != 0) goto L15
            r0 = 1
            goto L16
        L15:
            r0 = 0
        L16:
            if (r0 == r1) goto L1d
            goto L2a
        L19:
            r4 = move-exception
            throw r4
        L1b:
            if (r4 != 0) goto L2a
        L1d:
            int r4 = id.dana.utils.UrlUtil.BuiltInFictitiousFunctionClassFactory     // Catch: java.lang.Exception -> L28
            int r4 = r4 + 47
            int r0 = r4 % 128
            id.dana.utils.UrlUtil.MyBillsEntityDataFactory = r0     // Catch: java.lang.Exception -> L28
            int r4 = r4 % 2
            return r2
        L28:
            r4 = move-exception
            goto L56
        L2a:
            java.lang.String r0 = "dana"
            boolean r0 = r4.contains(r0)     // Catch: java.lang.Exception -> L59
            if (r0 == 0) goto L57
            int r0 = id.dana.utils.UrlUtil.MyBillsEntityDataFactory
            int r0 = r0 + 57
            int r3 = r0 % 128
            id.dana.utils.UrlUtil.BuiltInFictitiousFunctionClassFactory = r3
            int r0 = r0 % 2
            if (r0 == 0) goto L40
            r0 = 1
            goto L41
        L40:
            r0 = 0
        L41:
            java.lang.String r3 = "open?_branch_referrer"
            if (r0 == 0) goto L4a
            boolean r4 = r4.contains(r3)
            goto L58
        L4a:
            boolean r4 = r4.contains(r3)
            if (r4 == 0) goto L52
            r4 = 1
            goto L53
        L52:
            r4 = 0
        L53:
            if (r4 == r1) goto L58
            goto L57
        L56:
            throw r4
        L57:
            r1 = 0
        L58:
            return r1
        L59:
            r4 = move-exception
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.utils.UrlUtil.moveToNextValue(java.lang.String):boolean");
    }

    /* JADX WARN: Code restructure failed: missing block: B:49:0x0021, code lost:
    
        if ((r4.startsWith(id.dana.data.constant.DanaUrl.DEEPLINK_URL_NO_SEPARATOR) ? 'V' : '\t') != 'V') goto L61;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x0029, code lost:
    
        if (r0 != false) goto L54;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x002b, code lost:
    
        r0 = id.dana.utils.UrlUtil.BuiltInFictitiousFunctionClassFactory + 109;
        id.dana.utils.UrlUtil.MyBillsEntityDataFactory = r0 % 128;
        r0 = r0 % 2;
        r0 = id.dana.utils.UrlUtil.BuiltInFictitiousFunctionClassFactory + 35;
        id.dana.utils.UrlUtil.MyBillsEntityDataFactory = r0 % 128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x003f, code lost:
    
        if ((r0 % 2) != 0) goto L60;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x0041, code lost:
    
        r1.hashCode();
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x0044, code lost:
    
        return r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x0047, code lost:
    
        return r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x0048, code lost:
    
        r0 = new java.lang.StringBuilder();
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x004d, code lost:
    
        r0.append(id.dana.data.constant.DanaUrl.DEEPLINK_URL_NO_SEPARATOR);
        r0.append(r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x0057, code lost:
    
        return r0.toString();
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x0058, code lost:
    
        r4 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x0059, code lost:
    
        throw r4;
     */
    @kotlin.jvm.JvmStatic
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String KClassImpl$Data$declaredNonStaticMembers$2(java.lang.String r4) {
        /*
            int r0 = id.dana.utils.UrlUtil.MyBillsEntityDataFactory
            int r0 = r0 + 109
            int r1 = r0 % 128
            id.dana.utils.UrlUtil.BuiltInFictitiousFunctionClassFactory = r1
            int r0 = r0 % 2
            if (r0 == 0) goto Le
            r0 = 0
            goto Lf
        Le:
            r0 = 1
        Lf:
            r1 = 0
            java.lang.String r2 = "https://link.dana.id"
            if (r0 == 0) goto L24
            boolean r0 = r4.startsWith(r2)
            r3 = 86
            if (r0 == 0) goto L1f
            r0 = 86
            goto L21
        L1f:
            r0 = 9
        L21:
            if (r0 == r3) goto L2b
            goto L48
        L24:
            boolean r0 = r4.startsWith(r2)
            int r3 = r1.length     // Catch: java.lang.Throwable -> L5a
            if (r0 == 0) goto L48
        L2b:
            int r0 = id.dana.utils.UrlUtil.BuiltInFictitiousFunctionClassFactory
            int r0 = r0 + 109
            int r2 = r0 % 128
            id.dana.utils.UrlUtil.MyBillsEntityDataFactory = r2
            int r0 = r0 % 2
            int r0 = id.dana.utils.UrlUtil.BuiltInFictitiousFunctionClassFactory
            int r0 = r0 + 35
            int r2 = r0 % 128
            id.dana.utils.UrlUtil.MyBillsEntityDataFactory = r2
            int r0 = r0 % 2
            if (r0 != 0) goto L47
            r1.hashCode()     // Catch: java.lang.Throwable -> L45
            return r4
        L45:
            r4 = move-exception
            throw r4
        L47:
            return r4
        L48:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r0.append(r2)     // Catch: java.lang.Exception -> L58
            r0.append(r4)     // Catch: java.lang.Exception -> L58
            java.lang.String r4 = r0.toString()     // Catch: java.lang.Exception -> L58
            return r4
        L58:
            r4 = move-exception
            throw r4
        L5a:
            r4 = move-exception
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.utils.UrlUtil.KClassImpl$Data$declaredNonStaticMembers$2(java.lang.String):java.lang.String");
    }

    /* JADX WARN: Code restructure failed: missing block: B:47:0x001c, code lost:
    
        if ((android.text.TextUtils.isEmpty(r5)) != true) goto L53;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x0026, code lost:
    
        if (android.text.TextUtils.isEmpty(r5) != false) goto L52;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x0028, code lost:
    
        r5 = "";
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x002d, code lost:
    
        if (android.text.TextUtils.isEmpty(r6) == false) goto L56;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x002f, code lost:
    
        r6 = "";
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x0036, code lost:
    
        if (r5.contains("?") == false) goto L63;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x0038, code lost:
    
        r0 = new java.lang.StringBuilder();
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x003d, code lost:
    
        r0.append(r5);
        r0.append(com.huawei.hms.framework.common.ContainerUtils.FIELD_DELIMITER);
        r0.append(r6);
        r5 = r0.toString();
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x004c, code lost:
    
        r6 = id.dana.utils.UrlUtil.MyBillsEntityDataFactory + 1;
        id.dana.utils.UrlUtil.BuiltInFictitiousFunctionClassFactory = r6 % 128;
        r6 = r6 % 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x0056, code lost:
    
        r5 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x0057, code lost:
    
        throw r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x0058, code lost:
    
        r1 = new java.lang.StringBuilder();
        r1.append(r5);
        r1.append("?");
        r1.append(r6);
        r5 = r1.toString();
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x006a, code lost:
    
        r6 = id.dana.utils.UrlUtil.BuiltInFictitiousFunctionClassFactory + 81;
        id.dana.utils.UrlUtil.MyBillsEntityDataFactory = r6 % 128;
        r6 = r6 % 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x0074, code lost:
    
        return r5;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String PlaceComponentResult(java.lang.String r5, java.lang.String r6) {
        /*
            int r0 = id.dana.utils.UrlUtil.MyBillsEntityDataFactory
            int r0 = r0 + 97
            int r1 = r0 % 128
            id.dana.utils.UrlUtil.BuiltInFictitiousFunctionClassFactory = r1
            int r0 = r0 % 2
            r1 = 0
            r2 = 1
            if (r0 == 0) goto L10
            r0 = 0
            goto L11
        L10:
            r0 = 1
        L11:
            java.lang.String r3 = ""
            if (r0 == 0) goto L1f
            boolean r0 = android.text.TextUtils.isEmpty(r5)
            if (r0 == 0) goto L1c
            r1 = 1
        L1c:
            if (r1 == r2) goto L28
            goto L29
        L1f:
            boolean r0 = android.text.TextUtils.isEmpty(r5)
            r4 = 78
            int r4 = r4 / r1
            if (r0 == 0) goto L29
        L28:
            r5 = r3
        L29:
            boolean r0 = android.text.TextUtils.isEmpty(r6)
            if (r0 == 0) goto L30
            r6 = r3
        L30:
            java.lang.String r0 = "?"
            boolean r1 = r5.contains(r0)
            if (r1 == 0) goto L58
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r0.append(r5)     // Catch: java.lang.Exception -> L56
            java.lang.String r5 = "&"
            r0.append(r5)     // Catch: java.lang.Exception -> L56
            r0.append(r6)     // Catch: java.lang.Exception -> L56
            java.lang.String r5 = r0.toString()     // Catch: java.lang.Exception -> L56
            int r6 = id.dana.utils.UrlUtil.MyBillsEntityDataFactory
            int r6 = r6 + r2
            int r0 = r6 % 128
            id.dana.utils.UrlUtil.BuiltInFictitiousFunctionClassFactory = r0
            int r6 = r6 % 2
            goto L6a
        L56:
            r5 = move-exception
            throw r5
        L58:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r5)
            r1.append(r0)
            r1.append(r6)
            java.lang.String r5 = r1.toString()
        L6a:
            int r6 = id.dana.utils.UrlUtil.BuiltInFictitiousFunctionClassFactory
            int r6 = r6 + 81
            int r0 = r6 % 128
            id.dana.utils.UrlUtil.MyBillsEntityDataFactory = r0
            int r6 = r6 % 2
            return r5
        L75:
            r5 = move-exception
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.utils.UrlUtil.PlaceComponentResult(java.lang.String, java.lang.String):java.lang.String");
    }

    public static String getAuthRequestContext(String str, Map<String, String> map) {
        Iterator<Map.Entry<String, String>> it;
        if (TextUtils.isEmpty(str)) {
            int i = BuiltInFictitiousFunctionClassFactory + 35;
            MyBillsEntityDataFactory = i % 128;
            if (i % 2 == 0) {
                int i2 = 49 / 0;
                return "";
            }
            return "";
        }
        if ((!map.isEmpty() ? '3' : '6') != '6') {
            int i3 = MyBillsEntityDataFactory + 61;
            BuiltInFictitiousFunctionClassFactory = i3 % 128;
            if (i3 % 2 != 0) {
                it = map.entrySet().iterator();
                Object[] objArr = null;
                int length = objArr.length;
            } else {
                it = map.entrySet().iterator();
            }
            int i4 = MyBillsEntityDataFactory + 81;
            BuiltInFictitiousFunctionClassFactory = i4 % 128;
            int i5 = i4 % 2;
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Map.Entry<String, String> next = it.next();
                if (!next.getKey().equals("referring_link")) {
                    try {
                        if (!next.getKey().equals("android_url") && next.getValue() != null) {
                            StringBuilder sb = new StringBuilder();
                            sb.append(next.getKey());
                            sb.append("=");
                            sb.append(next.getValue());
                            str = PlaceComponentResult(str, sb.toString());
                        }
                    } catch (Exception e) {
                        throw e;
                    }
                }
            }
        }
        return str;
    }

    public static Map<String, List<String>> PlaceComponentResult(URL url) {
        int i = MyBillsEntityDataFactory + 19;
        BuiltInFictitiousFunctionClassFactory = i % 128;
        try {
            if ((i % 2 != 0 ? (char) 22 : (char) 6) == 6) {
                return NetworkUserEntityData$$ExternalSyntheticLambda7(url.getQuery());
            }
            int i2 = 17 / 0;
            return NetworkUserEntityData$$ExternalSyntheticLambda7(url.getQuery());
        } catch (UnsupportedEncodingException e) {
            DanaLog.BuiltInFictitiousFunctionClassFactory("UrlUtil", e.getMessage());
            return null;
        }
    }

    private static Map<String, List<String>> NetworkUserEntityData$$ExternalSyntheticLambda7(String str) throws UnsupportedEncodingException {
        String str2;
        int indexOf;
        String str3;
        int i;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        String[] split = str.split(ContainerUtils.FIELD_DELIMITER);
        int length = split.length;
        for (int i2 = 0; i2 < length; i2++) {
            int i3 = BuiltInFictitiousFunctionClassFactory + 57;
            MyBillsEntityDataFactory = i3 % 128;
            String decode = ((i3 % 2 == 0) ? (indexOf = (str2 = split[i2]).indexOf(55)) <= 0 : (indexOf = (str2 = split[i2]).indexOf(61)) <= 0) ? str2 : URLDecoder.decode(str2.substring(0, indexOf), StandardCharsets.UTF_8.name());
            if (!linkedHashMap.containsKey(decode)) {
                linkedHashMap.put(decode, new LinkedList());
            }
            if ((indexOf > 0 ? (char) 31 : 'I') == 'I' || str2.length() <= (i = indexOf + 1)) {
                str3 = null;
            } else {
                int i4 = MyBillsEntityDataFactory + 21;
                BuiltInFictitiousFunctionClassFactory = i4 % 128;
                int i5 = i4 % 2;
                str3 = URLDecoder.decode(str2.substring(i), StandardCharsets.UTF_8.name());
            }
            try {
                ((List) linkedHashMap.get(decode)).add(GetContactSyncConfig(str3));
            } catch (Exception e) {
                throw e;
            }
        }
        return linkedHashMap;
    }

    private static String GetContactSyncConfig(String str) {
        int i = BuiltInFictitiousFunctionClassFactory + 97;
        MyBillsEntityDataFactory = i % 128;
        int i2 = i % 2;
        if (str != null) {
            if ((str.charAt(0) == '[' ? (char) 18 : (char) 1) != 1) {
                int i3 = BuiltInFictitiousFunctionClassFactory + 7;
                MyBillsEntityDataFactory = i3 % 128;
                int i4 = i3 % 2;
                str = str.replaceFirst("\\[", "");
                int i5 = MyBillsEntityDataFactory + 39;
                BuiltInFictitiousFunctionClassFactory = i5 % 128;
                int i6 = i5 % 2;
            }
            return (str.charAt(str.length() - 1) == ']' ? '\f' : (char) 29) != 29 ? str.substring(0, str.length() - 1) : str;
        }
        return str;
    }

    public static Map<String, List<String>> NetworkUserEntityData$$ExternalSyntheticLambda1(String str) throws UnsupportedEncodingException {
        String str2;
        String str3;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (String str4 : str.split(ContainerUtils.FIELD_DELIMITER)) {
            try {
                int indexOf = str4.indexOf(61);
                if (indexOf > 0) {
                    int i = BuiltInFictitiousFunctionClassFactory + 17;
                    MyBillsEntityDataFactory = i % 128;
                    int i2 = i % 2;
                    str2 = URLDecoder.decode(str4.substring(0, indexOf), StandardCharsets.UTF_8.name());
                } else {
                    str2 = str4;
                }
                if (!linkedHashMap.containsKey(str2)) {
                    try {
                        linkedHashMap.put(str2, new LinkedList());
                    } catch (Exception e) {
                        throw e;
                    }
                }
                if ((indexOf > 0 ? (char) 21 : (char) 27) == 21) {
                    int i3 = BuiltInFictitiousFunctionClassFactory + 97;
                    MyBillsEntityDataFactory = i3 % 128;
                    int i4 = i3 % 2;
                    int i5 = indexOf + 1;
                    if ((str4.length() > i5 ? '!' : (char) 11) == '!') {
                        str3 = URLDecoder.decode(str4.substring(i5), StandardCharsets.UTF_8.name());
                        ((List) linkedHashMap.get(str2)).addAll(PrepareContext(GetContactSyncConfig(str3)));
                    }
                }
                str3 = null;
                ((List) linkedHashMap.get(str2)).addAll(PrepareContext(GetContactSyncConfig(str3)));
            } catch (Exception e2) {
                throw e2;
            }
        }
        return linkedHashMap;
    }

    private static List<String> PrepareContext(String str) {
        int i = MyBillsEntityDataFactory + 85;
        BuiltInFictitiousFunctionClassFactory = i % 128;
        int i2 = i % 2;
        if (str != null) {
            try {
                String[] split = str.split(",");
                ArrayList arrayList = new ArrayList();
                int length = split.length;
                int i3 = 0;
                while (true) {
                    if (!(i3 < length)) {
                        return arrayList;
                    }
                    String str2 = split[i3];
                    if (!(TextUtils.isEmpty(str2))) {
                        int i4 = BuiltInFictitiousFunctionClassFactory + 99;
                        MyBillsEntityDataFactory = i4 % 128;
                        int i5 = i4 % 2;
                        try {
                            arrayList.add(str2);
                        } catch (Exception e) {
                            throw e;
                        }
                    }
                    i3++;
                }
            } catch (Exception e2) {
                throw e2;
            }
        } else {
            return Collections.emptyList();
        }
    }

    public static String MyBillsEntityDataFactory(String str) {
        String str2;
        int i = BuiltInFictitiousFunctionClassFactory + 93;
        MyBillsEntityDataFactory = i % 128;
        try {
            if ((i % 2 == 0 ? 'N' : '%') != '%') {
                Object[] objArr = new Object[1];
                a(10606 >>> Color.green(0), new char[]{33222, 55968, 14107, 37771, 60471}, objArr);
                str2 = (String) objArr[0];
            } else {
                Object[] objArr2 = new Object[1];
                a(Color.green(0) + 23399, new char[]{33222, 55968, 14107, 37771, 60471}, objArr2);
                str2 = (String) objArr2[0];
            }
            String encode = URLEncoder.encode(str, str2.intern());
            int i2 = BuiltInFictitiousFunctionClassFactory + 121;
            MyBillsEntityDataFactory = i2 % 128;
            int i3 = i2 % 2;
            return encode;
        } catch (Exception unused) {
            return null;
        }
    }

    public static Map<String, String> DatabaseTableConfigUtil(String str) {
        Uri parse = Uri.parse(str);
        Set<String> queryParameterNames = parse.getQueryParameterNames();
        HashMap hashMap = new HashMap();
        Object obj = null;
        if (queryParameterNames != null) {
            try {
                int i = MyBillsEntityDataFactory + 43;
                BuiltInFictitiousFunctionClassFactory = i % 128;
                boolean z = i % 2 == 0;
                if (!z) {
                    obj.hashCode();
                }
                for (String str2 : queryParameterNames) {
                    int i2 = MyBillsEntityDataFactory + 27;
                    BuiltInFictitiousFunctionClassFactory = i2 % 128;
                    int i3 = i2 % 2;
                    hashMap.put(str2, parse.getQueryParameter(str2));
                }
            } catch (Exception e) {
                throw e;
            }
        }
        try {
            int i4 = MyBillsEntityDataFactory + 89;
            BuiltInFictitiousFunctionClassFactory = i4 % 128;
            if (!(i4 % 2 == 0)) {
                obj.hashCode();
                return hashMap;
            }
            return hashMap;
        } catch (Exception e2) {
            throw e2;
        }
    }

    public static Boolean PlaceComponentResult(String str) {
        int i = MyBillsEntityDataFactory + 85;
        BuiltInFictitiousFunctionClassFactory = i % 128;
        int i2 = i % 2;
        try {
            Boolean valueOf = Boolean.valueOf(str.startsWith("https://m.dana.id/m/portal/cashier"));
            int i3 = MyBillsEntityDataFactory + 17;
            BuiltInFictitiousFunctionClassFactory = i3 % 128;
            if (i3 % 2 == 0) {
                return valueOf;
            }
            int i4 = 70 / 0;
            return valueOf;
        } catch (Exception e) {
            throw e;
        }
    }

    public static String NetworkUserEntityData$$ExternalSyntheticLambda2(String str) {
        if ((!PlaceComponentResult(str).booleanValue() ? '%' : '\n') == '%') {
            int i = BuiltInFictitiousFunctionClassFactory + 25;
            MyBillsEntityDataFactory = i % 128;
            int i2 = i % 2;
            try {
                if (str.startsWith(DanaUrl.CASHIER)) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("https://m.dana.id");
                    sb.append(str);
                    str = sb.toString();
                }
            } catch (Exception e) {
                throw e;
            }
        }
        int i3 = BuiltInFictitiousFunctionClassFactory + 47;
        MyBillsEntityDataFactory = i3 % 128;
        int i4 = i3 % 2;
        return str;
    }

    /* JADX WARN: Code restructure failed: missing block: B:54:0x001e, code lost:
    
        if ((r2 != null ? '\'' : 31) != '\'') goto L68;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x0025, code lost:
    
        if (r2 != null) goto L80;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x002b, code lost:
    
        if (r2.isEmpty() != false) goto L68;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x002d, code lost:
    
        r2 = new java.net.URL(r2).getPath();
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x0037, code lost:
    
        r2 = "";
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x004e, code lost:
    
        r2 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x004f, code lost:
    
        throw r2;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.Boolean scheduleImpl(java.lang.String r2) {
        /*
            int r0 = id.dana.utils.UrlUtil.BuiltInFictitiousFunctionClassFactory
            int r0 = r0 + 33
            int r1 = r0 % 128
            id.dana.utils.UrlUtil.MyBillsEntityDataFactory = r1
            int r0 = r0 % 2
            r1 = 55
            if (r0 != 0) goto L11
            r0 = 55
            goto L13
        L11:
            r0 = 74
        L13:
            if (r0 == r1) goto L21
            r0 = 39
            if (r2 == 0) goto L1c
            r1 = 39
            goto L1e
        L1c:
            r1 = 31
        L1e:
            if (r1 == r0) goto L27
            goto L50
        L21:
            r0 = 59
            int r0 = r0 / 0
            if (r2 == 0) goto L50
        L27:
            boolean r0 = r2.isEmpty()     // Catch: java.lang.Exception -> L4e
            if (r0 != 0) goto L50
            java.net.URL r0 = new java.net.URL     // Catch: java.net.MalformedURLException -> L37
            r0.<init>(r2)     // Catch: java.net.MalformedURLException -> L37
            java.lang.String r2 = r0.getPath()     // Catch: java.net.MalformedURLException -> L37
            goto L39
        L37:
            java.lang.String r2 = ""
        L39:
            java.util.List<java.lang.String> r0 = id.dana.utils.UrlUtil.KClassImpl$Data$declaredNonStaticMembers$2
            boolean r2 = r0.contains(r2)
            java.lang.Boolean r2 = java.lang.Boolean.valueOf(r2)
            int r0 = id.dana.utils.UrlUtil.MyBillsEntityDataFactory
            int r0 = r0 + 51
            int r1 = r0 % 128
            id.dana.utils.UrlUtil.BuiltInFictitiousFunctionClassFactory = r1
            int r0 = r0 % 2
            return r2
        L4e:
            r2 = move-exception
            throw r2
        L50:
            java.lang.Boolean r2 = java.lang.Boolean.FALSE
            int r0 = id.dana.utils.UrlUtil.MyBillsEntityDataFactory
            int r0 = r0 + 103
            int r1 = r0 % 128
            id.dana.utils.UrlUtil.BuiltInFictitiousFunctionClassFactory = r1
            int r0 = r0 % 2
            if (r0 == 0) goto L63
            r0 = 0
            int r0 = r0.length     // Catch: java.lang.Throwable -> L61
            return r2
        L61:
            r2 = move-exception
            throw r2
        L63:
            return r2
        L64:
            r2 = move-exception
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.utils.UrlUtil.scheduleImpl(java.lang.String):java.lang.Boolean");
    }

    /* JADX WARN: Code restructure failed: missing block: B:55:0x000e, code lost:
    
        if (r3 != null) goto L64;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x001c, code lost:
    
        if ((r3 != null ? '7' : '9') != '9') goto L64;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x0022, code lost:
    
        if (r3.getIsWhitelisted() == null) goto L81;
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x0024, code lost:
    
        r0 = id.dana.utils.UrlUtil.MyBillsEntityDataFactory + 119;
        id.dana.utils.UrlUtil.BuiltInFictitiousFunctionClassFactory = r0 % 128;
        r0 = r0 % 2;
        r0 = true;
        r3 = PlaceComponentResult(r4, java.lang.String.format(id.dana.data.constant.DanaUrl.WLCICIL, r3.getIsWhitelisted()));
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x0045, code lost:
    
        r4 = id.dana.utils.UrlUtil.BuiltInFictitiousFunctionClassFactory + 29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x0049, code lost:
    
        id.dana.utils.UrlUtil.MyBillsEntityDataFactory = r4 % 128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x004d, code lost:
    
        if ((r4 % 2) != 0) goto L72;
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x004f, code lost:
    
        r0 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x0050, code lost:
    
        if (r0 == false) goto L74;
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x0052, code lost:
    
        return r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x0055, code lost:
    
        r4 = 85 / 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x0056, code lost:
    
        return r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:79:0x0059, code lost:
    
        r3 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:80:0x005a, code lost:
    
        throw r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:81:0x005b, code lost:
    
        return r4;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String BuiltInFictitiousFunctionClassFactory(id.dana.domain.paylater.model.UserLoanInfo r3, java.lang.String r4) {
        /*
            int r0 = id.dana.utils.UrlUtil.MyBillsEntityDataFactory     // Catch: java.lang.Exception -> L5c
            int r0 = r0 + 79
            int r1 = r0 % 128
            id.dana.utils.UrlUtil.BuiltInFictitiousFunctionClassFactory = r1     // Catch: java.lang.Exception -> L5c
            int r0 = r0 % 2
            if (r0 == 0) goto L13
            r0 = 0
            int r0 = r0.length     // Catch: java.lang.Throwable -> L11
            if (r3 == 0) goto L5b
            goto L1e
        L11:
            r3 = move-exception
            throw r3
        L13:
            r0 = 57
            if (r3 == 0) goto L1a
            r1 = 55
            goto L1c
        L1a:
            r1 = 57
        L1c:
            if (r1 == r0) goto L5b
        L1e:
            java.lang.Boolean r0 = r3.getIsWhitelisted()
            if (r0 == 0) goto L5b
            int r0 = id.dana.utils.UrlUtil.MyBillsEntityDataFactory
            int r0 = r0 + 119
            int r1 = r0 % 128
            id.dana.utils.UrlUtil.BuiltInFictitiousFunctionClassFactory = r1
            int r0 = r0 % 2
            r0 = 1
            java.lang.Object[] r1 = new java.lang.Object[r0]
            java.lang.Boolean r3 = r3.getIsWhitelisted()
            r2 = 0
            r1[r2] = r3
            java.lang.String r3 = "wlcicil=%s"
            java.lang.String r3 = java.lang.String.format(r3, r1)
            java.lang.String r3 = PlaceComponentResult(r4, r3)
            int r4 = id.dana.utils.UrlUtil.BuiltInFictitiousFunctionClassFactory     // Catch: java.lang.Exception -> L5c
            int r4 = r4 + 29
            int r1 = r4 % 128
            id.dana.utils.UrlUtil.MyBillsEntityDataFactory = r1     // Catch: java.lang.Exception -> L59
            int r4 = r4 % 2
            if (r4 != 0) goto L50
            r0 = 0
        L50:
            if (r0 == 0) goto L53
            return r3
        L53:
            r4 = 85
            int r4 = r4 / r2
            return r3
        L57:
            r3 = move-exception
            throw r3
        L59:
            r3 = move-exception
            throw r3
        L5b:
            return r4
        L5c:
            r3 = move-exception
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.utils.UrlUtil.BuiltInFictitiousFunctionClassFactory(id.dana.domain.paylater.model.UserLoanInfo, java.lang.String):java.lang.String");
    }

    public static String KClassImpl$Data$declaredNonStaticMembers$2(UserLoanInfo userLoanInfo, String str) {
        try {
            if (str.contains(DanaUrl.DANA_CICIL)) {
                if ((userLoanInfo != null ? (char) 28 : 'D') != 'D') {
                    int i = BuiltInFictitiousFunctionClassFactory + 67;
                    MyBillsEntityDataFactory = i % 128;
                    int i2 = i % 2;
                    if (userLoanInfo.getIsRegistered() != null) {
                        String PlaceComponentResult2 = PlaceComponentResult(str, String.format(DanaUrl.REGISTERED, userLoanInfo.getIsRegistered()));
                        int i3 = BuiltInFictitiousFunctionClassFactory + 59;
                        MyBillsEntityDataFactory = i3 % 128;
                        int i4 = i3 % 2;
                        return PlaceComponentResult2;
                    }
                }
            }
            int i5 = BuiltInFictitiousFunctionClassFactory + 79;
            MyBillsEntityDataFactory = i5 % 128;
            int i6 = i5 % 2;
            return str;
        } catch (Exception e) {
            throw e;
        }
    }

    private static void a(int i, char[] cArr, Object[] objArr) {
        getOnBoardingScenario getonboardingscenario = new getOnBoardingScenario();
        getonboardingscenario.MyBillsEntityDataFactory = i;
        int length = cArr.length;
        long[] jArr = new long[length];
        getonboardingscenario.getAuthRequestContext = 0;
        while (true) {
            try {
                if (getonboardingscenario.getAuthRequestContext >= cArr.length) {
                    break;
                }
                int i2 = $11 + 79;
                $10 = i2 % 128;
                int i3 = i2 % 2;
                jArr[getonboardingscenario.getAuthRequestContext] = (cArr[getonboardingscenario.getAuthRequestContext] ^ (getonboardingscenario.getAuthRequestContext * getonboardingscenario.MyBillsEntityDataFactory)) ^ (PlaceComponentResult ^ 4796183387843776835L);
                getonboardingscenario.getAuthRequestContext++;
                int i4 = $11 + 81;
                $10 = i4 % 128;
                int i5 = i4 % 2;
            } catch (Exception e) {
                throw e;
            }
        }
        char[] cArr2 = new char[length];
        getonboardingscenario.getAuthRequestContext = 0;
        while (getonboardingscenario.getAuthRequestContext < cArr.length) {
            int i6 = $11 + 89;
            $10 = i6 % 128;
            if ((i6 % 2 != 0 ? (char) 6 : 'a') != 'a') {
                cArr2[getonboardingscenario.getAuthRequestContext] = (char) jArr[getonboardingscenario.getAuthRequestContext];
            } else {
                cArr2[getonboardingscenario.getAuthRequestContext] = (char) jArr[getonboardingscenario.getAuthRequestContext];
            }
            getonboardingscenario.getAuthRequestContext++;
        }
        objArr[0] = new String(cArr2);
    }
}
