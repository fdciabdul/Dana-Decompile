package kotlin.reflect.jvm.internal.impl.util.capitalizeDecapitalize;

import java.util.Iterator;
import java.util.Locale;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* loaded from: classes.dex */
public final class CapitalizeDecapitalizeKt {
    public static final String decapitalizeSmartForCompiler(String str, boolean z) {
        Integer num;
        Intrinsics.checkNotNullParameter(str, "");
        String str2 = str;
        if ((str2.length() == 0) || !isUpperCaseCharAt(str, 0, z)) {
            return str;
        }
        if (str.length() == 1 || !isUpperCaseCharAt(str, 1, z)) {
            if (z) {
                return decapitalizeAsciiOnly(str);
            }
            if (str2.length() > 0) {
                char lowerCase = Character.toLowerCase(str.charAt(0));
                String substring = str.substring(1);
                Intrinsics.checkNotNullExpressionValue(substring, "");
                StringBuilder sb = new StringBuilder();
                sb.append(lowerCase);
                sb.append(substring);
                return sb.toString();
            }
            return str;
        }
        Iterator<Integer> it = StringsKt.getIndices(str2).iterator();
        while (true) {
            if (!it.hasNext()) {
                num = null;
                break;
            }
            num = it.next();
            if ((!isUpperCaseCharAt(str, num.intValue(), z)) != false) {
                break;
            }
        }
        Integer num2 = num;
        if (num2 == null) {
            return toLowerCase(str, z);
        }
        int intValue = num2.intValue() - 1;
        StringBuilder sb2 = new StringBuilder();
        String substring2 = str.substring(0, intValue);
        Intrinsics.checkNotNullExpressionValue(substring2, "");
        sb2.append(toLowerCase(substring2, z));
        String substring3 = str.substring(intValue);
        Intrinsics.checkNotNullExpressionValue(substring3, "");
        sb2.append(substring3);
        return sb2.toString();
    }

    private static final boolean isUpperCaseCharAt(String str, int i, boolean z) {
        char charAt = str.charAt(i);
        if (z) {
            return 'A' <= charAt && charAt < '[';
        }
        return Character.isUpperCase(charAt);
    }

    private static final String toLowerCase(String str, boolean z) {
        if (z) {
            return toLowerCaseAsciiOnly(str);
        }
        String lowerCase = str.toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "");
        return lowerCase;
    }

    public static final String capitalizeAsciiOnly(String str) {
        Intrinsics.checkNotNullParameter(str, "");
        boolean z = false;
        if (str.length() == 0) {
            return str;
        }
        char charAt = str.charAt(0);
        if ('a' <= charAt && charAt < '{') {
            z = true;
        }
        if (z) {
            char upperCase = Character.toUpperCase(charAt);
            String substring = str.substring(1);
            Intrinsics.checkNotNullExpressionValue(substring, "");
            StringBuilder sb = new StringBuilder();
            sb.append(upperCase);
            sb.append(substring);
            return sb.toString();
        }
        return str;
    }

    public static final String decapitalizeAsciiOnly(String str) {
        Intrinsics.checkNotNullParameter(str, "");
        boolean z = false;
        if (str.length() == 0) {
            return str;
        }
        char charAt = str.charAt(0);
        if ('A' <= charAt && charAt < '[') {
            z = true;
        }
        if (z) {
            char lowerCase = Character.toLowerCase(charAt);
            String substring = str.substring(1);
            Intrinsics.checkNotNullExpressionValue(substring, "");
            StringBuilder sb = new StringBuilder();
            sb.append(lowerCase);
            sb.append(substring);
            return sb.toString();
        }
        return str;
    }

    public static final String toLowerCaseAsciiOnly(String str) {
        Intrinsics.checkNotNullParameter(str, "");
        StringBuilder sb = new StringBuilder(str.length());
        int length = str.length();
        for (int i = 0; i < length; i++) {
            char charAt = str.charAt(i);
            if ('A' <= charAt && charAt < '[') {
                charAt = Character.toLowerCase(charAt);
            }
            sb.append(charAt);
        }
        String obj = sb.toString();
        Intrinsics.checkNotNullExpressionValue(obj, "");
        return obj;
    }
}
