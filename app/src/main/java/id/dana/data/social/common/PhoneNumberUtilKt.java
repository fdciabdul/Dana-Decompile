package id.dana.data.social.common;

import id.dana.cashier.view.InputCardNumberView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.Regex;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0010\u000e\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000e\u001a\u0019\u0010\u0003\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0003\u0010\u0004\u001a\u0011\u0010\u0006\u001a\u00020\u0005*\u00020\u0000¢\u0006\u0004\b\u0006\u0010\u0007\u001a\u0011\u0010\b\u001a\u00020\u0005*\u00020\u0000¢\u0006\u0004\b\b\u0010\u0007\u001a\u0011\u0010\t\u001a\u00020\u0000*\u00020\u0000¢\u0006\u0004\b\t\u0010\n\u001a\u0011\u0010\u000b\u001a\u00020\u0000*\u00020\u0000¢\u0006\u0004\b\u000b\u0010\n\u001a\u0011\u0010\f\u001a\u00020\u0000*\u00020\u0000¢\u0006\u0004\b\f\u0010\n\u001a\u0011\u0010\r\u001a\u00020\u0000*\u00020\u0000¢\u0006\u0004\b\r\u0010\n\u001a\u0011\u0010\u000e\u001a\u00020\u0000*\u00020\u0000¢\u0006\u0004\b\u000e\u0010\n\u001a\u0011\u0010\u000f\u001a\u00020\u0000*\u00020\u0000¢\u0006\u0004\b\u000f\u0010\n\u001a\u0011\u0010\u0010\u001a\u00020\u0000*\u00020\u0000¢\u0006\u0004\b\u0010\u0010\n\u001a\u0011\u0010\u0011\u001a\u00020\u0000*\u00020\u0000¢\u0006\u0004\b\u0011\u0010\n\u001a\u0011\u0010\u0012\u001a\u00020\u0000*\u00020\u0000¢\u0006\u0004\b\u0012\u0010\n\u001a\u0011\u0010\u0013\u001a\u00020\u0000*\u00020\u0000¢\u0006\u0004\b\u0013\u0010\n"}, d2 = {"", "", "maxLengthPerSection", "addWhiteSpaceBetweenSection", "(Ljava/lang/String;I)Ljava/lang/String;", "", "isDigitsOnly", "(Ljava/lang/String;)Z", "isValidPhoneNumber", "removeIndoPhonePrefix", "(Ljava/lang/String;)Ljava/lang/String;", "removeWhitespaceAndDash", "replaceIndoPhonePrefixWithRegionDash", "replaceIndoRegionDashWithPhonePrefix", "replaceIndoRegionDashWithPlusSixTwo", "replaceIndoRegionDashWithPlusSixTwoEight", "replaceIndoRegionDashWithSixTwo", "replacePhonePrefixWithIndoRegionDash", "replacePlusSixTwoEightWithIndoRegionDash", "replaceSixTwoWithIndoRegionDash"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class PhoneNumberUtilKt {
    public static final String removeWhitespaceAndDash(String str) {
        Intrinsics.checkNotNullParameter(str, "");
        return new Regex("[\\s-]+").replace(str, "");
    }

    public static final String replaceIndoPhonePrefixWithRegionDash(String str) {
        Intrinsics.checkNotNullParameter(str, "");
        return new Regex("^(\\+*62)*0*8").replace(str, "62-8");
    }

    public static final String removeIndoPhonePrefix(String str) {
        Intrinsics.checkNotNullParameter(str, "");
        return new Regex("^(\\+*62)*0*8").replace(str, "8");
    }

    public static final String replaceIndoRegionDashWithPhonePrefix(String str) {
        Intrinsics.checkNotNullParameter(str, "");
        return new Regex("^(62-8)").replace(str, "08");
    }

    public static final String replaceIndoRegionDashWithPlusSixTwoEight(String str) {
        Intrinsics.checkNotNullParameter(str, "");
        return new Regex("^(62-8)").replace(str, "+628");
    }

    public static final String replaceIndoRegionDashWithPlusSixTwo(String str) {
        Intrinsics.checkNotNullParameter(str, "");
        return new Regex("^(\\+62-)").replace(str, "+62");
    }

    public static final String replaceIndoRegionDashWithSixTwo(String str) {
        Intrinsics.checkNotNullParameter(str, "");
        return new Regex("^(62-8)").replace(str, "628");
    }

    public static final String replacePhonePrefixWithIndoRegionDash(String str) {
        Intrinsics.checkNotNullParameter(str, "");
        return new Regex("^(08)").replace(str, "62-8");
    }

    public static final String replacePlusSixTwoEightWithIndoRegionDash(String str) {
        Intrinsics.checkNotNullParameter(str, "");
        return new Regex("^(\\+628)").replace(str, "62-8");
    }

    public static final String replaceSixTwoWithIndoRegionDash(String str) {
        Intrinsics.checkNotNullParameter(str, "");
        return new Regex("^(628)").replace(str, "62-8");
    }

    public static final boolean isDigitsOnly(String str) {
        boolean z;
        Intrinsics.checkNotNullParameter(str, "");
        String str2 = str;
        int i = 0;
        while (true) {
            if (i >= str2.length()) {
                z = true;
                break;
            } else if (!Character.isDigit(str2.charAt(i))) {
                z = false;
                break;
            } else {
                i++;
            }
        }
        if (z) {
            return str2.length() > 0;
        }
        return false;
    }

    public static final String addWhiteSpaceBetweenSection(String str, int i) {
        int i2;
        String substring;
        Intrinsics.checkNotNullParameter(str, "");
        int length = str.length() - ((str.length() / i) * i);
        int i3 = 0;
        String str2 = "";
        while (i3 < str.length()) {
            if (i3 == 0 && length != 0) {
                i2 = i3 + length;
                substring = str.substring(i3, RangesKt.coerceAtMost(str.length(), i2));
                Intrinsics.checkNotNullExpressionValue(substring, "");
            } else {
                i2 = i3 + i;
                substring = str.substring(i3, RangesKt.coerceAtMost(str.length(), i2));
                Intrinsics.checkNotNullExpressionValue(substring, "");
            }
            StringBuilder sb = new StringBuilder();
            sb.append(str2);
            sb.append(substring);
            sb.append(InputCardNumberView.DIVIDER);
            str2 = sb.toString();
            i3 = i2;
        }
        return StringsKt.trim((CharSequence) str2).toString();
    }

    public static final boolean isValidPhoneNumber(String str) {
        Intrinsics.checkNotNullParameter(str, "");
        return new Regex("^(\\+62|62|0)8[0-9]{8,11}$").matches(str);
    }
}
