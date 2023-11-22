package id.dana.utils;

import android.view.Gravity;
import android.view.ViewConfiguration;
import id.dana.utils.foundation.logger.log.DanaLog;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.text.Typography;
import o.whenAvailable;

/* loaded from: classes2.dex */
public class TagFormat {
    private static int $10 = 0;
    private static int $11 = 1;
    private static char[] KClassImpl$Data$declaredNonStaticMembers$2 = {62235, 26618, 56008, 19907, 41206};
    private static long MyBillsEntityDataFactory = -1247350412069935186L;
    private static final String getAuthRequestContext = "TagFormat";
    private static int lookAheadTest = 0;
    private static int scheduleImpl = 1;
    private final String BuiltInFictitiousFunctionClassFactory;
    private final Map<String, Object> PlaceComponentResult = new HashMap();

    private TagFormat(String str) {
        this.BuiltInFictitiousFunctionClassFactory = str;
    }

    public static TagFormat MyBillsEntityDataFactory(String str) {
        TagFormat tagFormat = new TagFormat(str);
        int i = scheduleImpl + 45;
        lookAheadTest = i % 128;
        if ((i % 2 != 0 ? Typography.amp : 'Q') != '&') {
            return tagFormat;
        }
        Object[] objArr = null;
        int length = objArr.length;
        return tagFormat;
    }

    public final TagFormat MyBillsEntityDataFactory(String str, Object obj) {
        try {
            Map<String, Object> map = this.PlaceComponentResult;
            StringBuilder sb = new StringBuilder();
            sb.append("\\{");
            sb.append(str);
            sb.append("\\}");
            String obj2 = sb.toString();
            if (!(obj != null)) {
                int i = lookAheadTest + 25;
                scheduleImpl = i % 128;
                if (i % 2 == 0) {
                    int i2 = 96 / 0;
                }
                int i3 = lookAheadTest + 53;
                scheduleImpl = i3 % 128;
                int i4 = i3 % 2;
                obj = "";
            }
            map.put(obj2, obj);
            return this;
        } catch (Exception e) {
            throw e;
        }
    }

    public final TagFormat PlaceComponentResult(String str, Object obj) {
        String str2;
        boolean z = true;
        int i = scheduleImpl + 1;
        lookAheadTest = i % 128;
        int i2 = i % 2;
        try {
            if (!(obj instanceof String)) {
                z = false;
            }
            if (z) {
                str2 = KClassImpl$Data$declaredNonStaticMembers$2((String) obj);
                int i3 = scheduleImpl + 69;
                lookAheadTest = i3 % 128;
                int i4 = i3 % 2;
            } else {
                str2 = "";
            }
            Map<String, Object> map = this.PlaceComponentResult;
            StringBuilder sb = new StringBuilder();
            sb.append("\\{");
            sb.append(str);
            sb.append("\\}");
            map.put(sb.toString(), str2);
            return this;
        } catch (Exception e) {
            throw e;
        }
    }

    private static String KClassImpl$Data$declaredNonStaticMembers$2(String str) {
        int i = lookAheadTest + 85;
        scheduleImpl = i % 128;
        int i2 = i % 2;
        try {
            Object[] objArr = new Object[1];
            a(Gravity.getAbsoluteGravity(0, 0), 5 - (ViewConfiguration.getFadingEdgeLength() >> 16), (char) (ViewConfiguration.getLongPressTimeout() >> 16), objArr);
            String encode = URLEncoder.encode(str, ((String) objArr[0]).intern());
            int i3 = scheduleImpl + 109;
            lookAheadTest = i3 % 128;
            int i4 = i3 % 2;
            return encode;
        } catch (UnsupportedEncodingException e) {
            DanaLog.BuiltInFictitiousFunctionClassFactory(getAuthRequestContext, e.getMessage());
            return "";
        }
    }

    public final String MyBillsEntityDataFactory() {
        String str = this.BuiltInFictitiousFunctionClassFactory;
        Iterator<Map.Entry<String, Object>> it = this.PlaceComponentResult.entrySet().iterator();
        int i = scheduleImpl + 79;
        lookAheadTest = i % 128;
        int i2 = i % 2;
        while (true) {
            if (!(it.hasNext())) {
                return str;
            }
            int i3 = lookAheadTest + 45;
            scheduleImpl = i3 % 128;
            int i4 = i3 % 2;
            Map.Entry<String, Object> next = it.next();
            str = str.replaceAll(next.getKey(), next.getValue().toString());
        }
    }

    private static void a(int i, int i2, char c, Object[] objArr) {
        whenAvailable whenavailable = new whenAvailable();
        long[] jArr = new long[i2];
        whenavailable.BuiltInFictitiousFunctionClassFactory = 0;
        while (true) {
            if ((whenavailable.BuiltInFictitiousFunctionClassFactory < i2 ? '%' : '8') != '%') {
                break;
            }
            int i3 = $11 + 81;
            $10 = i3 % 128;
            int i4 = i3 % 2;
            jArr[whenavailable.BuiltInFictitiousFunctionClassFactory] = (((char) (KClassImpl$Data$declaredNonStaticMembers$2[whenavailable.BuiltInFictitiousFunctionClassFactory + i] ^ (-4773380863230414002L))) ^ (whenavailable.BuiltInFictitiousFunctionClassFactory * ((-4773380863230414002L) ^ MyBillsEntityDataFactory))) ^ c;
            whenavailable.BuiltInFictitiousFunctionClassFactory++;
            int i5 = $10 + 93;
            $11 = i5 % 128;
            int i6 = i5 % 2;
        }
        char[] cArr = new char[i2];
        whenavailable.BuiltInFictitiousFunctionClassFactory = 0;
        while (true) {
            try {
                if (!(whenavailable.BuiltInFictitiousFunctionClassFactory >= i2)) {
                    try {
                        cArr[whenavailable.BuiltInFictitiousFunctionClassFactory] = (char) jArr[whenavailable.BuiltInFictitiousFunctionClassFactory];
                        whenavailable.BuiltInFictitiousFunctionClassFactory++;
                    } catch (Exception e) {
                        throw e;
                    }
                } else {
                    objArr[0] = new String(cArr);
                    return;
                }
            } catch (Exception e2) {
                throw e2;
            }
        }
    }
}
