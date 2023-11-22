package id.dana.sendmoney.util;

import androidx.core.util.PatternsCompat;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\r\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0011\u0010\u0007\u001a\u00020\u0004*\u00020\u0002¢\u0006\u0004\b\u0007\u0010\u0006J\u0011\u0010\b\u001a\u00020\u0004*\u00020\u0002¢\u0006\u0004\b\b\u0010\u0006J\u0013\u0010\u0007\u001a\u00020\u0004*\u0004\u0018\u00010\t¢\u0006\u0004\b\u0007\u0010\nJ\u0011\u0010\u000b\u001a\u00020\u0004*\u00020\u0002¢\u0006\u0004\b\u000b\u0010\u0006J\u0011\u0010\f\u001a\u00020\u0004*\u00020\u0002¢\u0006\u0004\b\f\u0010\u0006"}, d2 = {"Lid/dana/sendmoney/util/FormValidationUtil;", "", "", "p0", "", "PlaceComponentResult", "(Ljava/lang/String;)Z", "KClassImpl$Data$declaredNonStaticMembers$2", "MyBillsEntityDataFactory", "", "(Ljava/lang/CharSequence;)Z", "getAuthRequestContext", "BuiltInFictitiousFunctionClassFactory", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class FormValidationUtil {
    public static final FormValidationUtil INSTANCE = new FormValidationUtil();

    private FormValidationUtil() {
    }

    public static boolean getAuthRequestContext(String str) {
        Intrinsics.checkNotNullParameter(str, "");
        return new Regex("^[a-zA-Z]+(?: [a-zA-Z]+)*+$").matches(str);
    }

    public static boolean KClassImpl$Data$declaredNonStaticMembers$2(CharSequence charSequence) {
        return !(charSequence == null || charSequence.length() == 0) && PatternsCompat.KClassImpl$Data$declaredNonStaticMembers$2.matcher(charSequence).matches();
    }

    public static boolean KClassImpl$Data$declaredNonStaticMembers$2(String str) {
        Intrinsics.checkNotNullParameter(str, "");
        if (str.length() >= 15) {
            return PlaceComponentResult(str);
        }
        return false;
    }

    public static boolean MyBillsEntityDataFactory(String str) {
        Intrinsics.checkNotNullParameter(str, "");
        return str.length() <= 16;
    }

    public static boolean BuiltInFictitiousFunctionClassFactory(String str) {
        Intrinsics.checkNotNullParameter(str, "");
        return new Regex("^4[0-9]{12}(?:[0-9]{3})?$").matches(str);
    }

    private static boolean PlaceComponentResult(String p0) {
        int i = 0;
        boolean z = false;
        for (int length = p0.length() - 1; length >= 0; length--) {
            int charAt = p0.charAt(length) - '0';
            if (charAt >= 0 && charAt <= 9) {
                if (z && (charAt = charAt * 2) > 9) {
                    charAt -= 9;
                }
                i += charAt;
                z = !z;
            }
        }
        return i % 10 == 0;
    }
}
