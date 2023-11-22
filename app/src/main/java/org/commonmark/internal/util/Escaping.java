package org.commonmark.internal.util;

import android.os.Process;
import com.alibaba.fastjson.parser.JSONLexer;
import com.huawei.hms.framework.common.ContainerUtils;
import com.j256.ormlite.stmt.query.SimpleComparison;
import java.nio.charset.Charset;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import o.C;

/* loaded from: classes6.dex */
public class Escaping {
    private static final Pattern KClassImpl$Data$declaredNonStaticMembers$2 = Pattern.compile("[\\\\&]");
    private static final Pattern BuiltInFictitiousFunctionClassFactory = Pattern.compile("\\\\[!\"#$%&'()*+,./:;<=>?@\\[\\\\\\]^_`{|}~-]|&(?:#x[a-f0-9]{1,8}|#[0-9]{1,8}|[a-z][a-z0-9]{1,31});", 2);
    private static final Pattern lookAheadTest = Pattern.compile("[&<>\"]");
    private static final Pattern moveToNextValue = Pattern.compile("&(?:#x[a-f0-9]{1,8}|#[0-9]{1,8}|[a-z][a-z0-9]{1,31});|[&<>\"]", 2);
    private static final Pattern PlaceComponentResult = Pattern.compile("(%[a-fA-F0-9]{0,2}|[^:/?#@!$&'()*+,;=a-zA-Z0-9\\-._~])");
    private static final char[] MyBillsEntityDataFactory = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
    private static final Pattern NetworkUserEntityData$$ExternalSyntheticLambda0 = Pattern.compile("[ \t\r\n]+");
    private static final Replacer getErrorConfigVersion = new Replacer() { // from class: org.commonmark.internal.util.Escaping.1
        @Override // org.commonmark.internal.util.Escaping.Replacer
        public final void getAuthRequestContext(String str, StringBuilder sb) {
            char c;
            str.hashCode();
            int hashCode = str.hashCode();
            if (hashCode == 34) {
                if (str.equals("\"")) {
                    c = 0;
                }
                c = 65535;
            } else if (hashCode == 38) {
                if (str.equals(ContainerUtils.FIELD_DELIMITER)) {
                    c = 1;
                }
                c = 65535;
            } else if (hashCode != 60) {
                if (hashCode == 62 && str.equals(SimpleComparison.GREATER_THAN_OPERATION)) {
                    c = 3;
                }
                c = 65535;
            } else {
                if (str.equals(SimpleComparison.LESS_THAN_OPERATION)) {
                    c = 2;
                }
                c = 65535;
            }
            if (c == 0) {
                sb.append("&quot;");
            } else if (c == 1) {
                sb.append("&amp;");
            } else if (c == 2) {
                sb.append("&lt;");
            } else if (c == 3) {
                sb.append("&gt;");
            } else {
                sb.append(str);
            }
        }
    };
    private static final Replacer getAuthRequestContext = new Replacer() { // from class: org.commonmark.internal.util.Escaping.2
        @Override // org.commonmark.internal.util.Escaping.Replacer
        public final void getAuthRequestContext(String str, StringBuilder sb) {
            if (str.charAt(0) == '\\') {
                sb.append((CharSequence) str, 1, str.length());
            } else {
                sb.append(Html5Entities.getAuthRequestContext(str));
            }
        }
    };
    private static final Replacer scheduleImpl = new Replacer() { // from class: org.commonmark.internal.util.Escaping.3
        private static int $10 = 0;
        private static int $11 = 1;
        private static char BuiltInFictitiousFunctionClassFactory = 8795;
        private static char KClassImpl$Data$declaredNonStaticMembers$2 = 5914;
        private static char MyBillsEntityDataFactory = 58704;
        private static char PlaceComponentResult = '3';
        private static int getAuthRequestContext = 0;
        private static int scheduleImpl = 1;

        @Override // org.commonmark.internal.util.Escaping.Replacer
        public final void getAuthRequestContext(String str, StringBuilder sb) {
            char c;
            int i = getAuthRequestContext + 63;
            scheduleImpl = i % 128;
            int i2 = i % 2;
            if (!(!str.startsWith("%"))) {
                if ((str.length() == 3 ? JSONLexer.EOI : '?') == 26) {
                    sb.append(str);
                    return;
                }
                sb.append("%25");
                sb.append((CharSequence) str, 1, str.length());
                return;
            }
            Object[] objArr = new Object[1];
            a(5 - ((Process.getThreadPriority(0) + 20) >> 6), new char[]{38766, 15692, 48248, 58463, 32189, 48951}, objArr);
            byte[] bytes = str.getBytes(Charset.forName(((String) objArr[0]).intern()));
            int length = bytes.length;
            for (int i3 = 0; i3 < length; i3++) {
                int i4 = scheduleImpl + 17;
                getAuthRequestContext = i4 % 128;
                if (!(i4 % 2 != 0)) {
                    byte b = bytes[i3];
                    sb.append('%');
                    sb.append(Escaping.MyBillsEntityDataFactory[(b >> 4) & 15]);
                    c = Escaping.MyBillsEntityDataFactory[b & 15];
                } else {
                    byte b2 = bytes[i3];
                    sb.append((char) 6);
                    sb.append(Escaping.MyBillsEntityDataFactory[(b2 << 3) & 51]);
                    c = Escaping.MyBillsEntityDataFactory[b2 ^ 43];
                }
                sb.append(c);
            }
            int i5 = scheduleImpl + 83;
            getAuthRequestContext = i5 % 128;
            if (i5 % 2 != 0) {
                Object obj = null;
                obj.hashCode();
            }
        }

        private static void a(int i, char[] cArr, Object[] objArr) {
            int i2;
            C c = new C();
            char[] cArr2 = new char[cArr.length];
            c.BuiltInFictitiousFunctionClassFactory = 0;
            char[] cArr3 = new char[2];
            while (c.BuiltInFictitiousFunctionClassFactory < cArr.length) {
                int i3 = $10 + 47;
                $11 = i3 % 128;
                if (!(i3 % 2 == 0)) {
                    cArr3[0] = cArr[c.BuiltInFictitiousFunctionClassFactory];
                    cArr3[1] = cArr[c.BuiltInFictitiousFunctionClassFactory + 1];
                    i2 = 0;
                } else {
                    cArr3[0] = cArr[c.BuiltInFictitiousFunctionClassFactory];
                    cArr3[0] = cArr[c.BuiltInFictitiousFunctionClassFactory - 0];
                    i2 = 1;
                }
                int i4 = 58224;
                int i5 = $11 + 99;
                $10 = i5 % 128;
                int i6 = i5 % 2;
                while (true) {
                    if ((i2 < 16 ? '9' : '[') != '9') {
                        break;
                    }
                    int i7 = $10 + 23;
                    $11 = i7 % 128;
                    int i8 = i7 % 2;
                    cArr3[1] = (char) (cArr3[1] - (((cArr3[0] + i4) ^ ((cArr3[0] << 4) + ((char) (KClassImpl$Data$declaredNonStaticMembers$2 ^ 6353485791441662354L)))) ^ ((cArr3[0] >>> 5) + ((char) (MyBillsEntityDataFactory ^ 6353485791441662354L)))));
                    cArr3[0] = (char) (cArr3[0] - (((cArr3[1] + i4) ^ ((cArr3[1] << 4) + ((char) (BuiltInFictitiousFunctionClassFactory ^ 6353485791441662354L)))) ^ ((cArr3[1] >>> 5) + ((char) (PlaceComponentResult ^ 6353485791441662354L)))));
                    i4 -= 40503;
                    i2++;
                }
                cArr2[c.BuiltInFictitiousFunctionClassFactory] = cArr3[0];
                cArr2[c.BuiltInFictitiousFunctionClassFactory + 1] = cArr3[1];
                c.BuiltInFictitiousFunctionClassFactory += 2;
            }
            objArr[0] = new String(cArr2, 0, i);
        }
    };

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public interface Replacer {
        void getAuthRequestContext(String str, StringBuilder sb);
    }

    public static String MyBillsEntityDataFactory(String str, boolean z) {
        return PlaceComponentResult(z ? moveToNextValue : lookAheadTest, str, getErrorConfigVersion);
    }

    public static String MyBillsEntityDataFactory(String str) {
        return KClassImpl$Data$declaredNonStaticMembers$2.matcher(str).find() ? PlaceComponentResult(BuiltInFictitiousFunctionClassFactory, str, getAuthRequestContext) : str;
    }

    public static String PlaceComponentResult(String str) {
        return NetworkUserEntityData$$ExternalSyntheticLambda0.matcher(str.substring(1, str.length() - 1).trim().toLowerCase(Locale.ROOT)).replaceAll(" ");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String PlaceComponentResult(Pattern pattern, String str, Replacer replacer) {
        Matcher matcher = pattern.matcher(str);
        if (matcher.find()) {
            StringBuilder sb = new StringBuilder(str.length() + 16);
            int i = 0;
            do {
                sb.append((CharSequence) str, i, matcher.start());
                replacer.getAuthRequestContext(matcher.group(), sb);
                i = matcher.end();
            } while (matcher.find());
            if (i != str.length()) {
                sb.append((CharSequence) str, i, str.length());
            }
            return sb.toString();
        }
        return str;
    }
}
