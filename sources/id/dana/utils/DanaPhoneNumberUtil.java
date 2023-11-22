package id.dana.utils;

import android.os.Build;
import android.telephony.PhoneNumberUtils;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0007\u0010\bJ#\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\t2\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\n\u0010\u000b"}, d2 = {"Lid/dana/utils/DanaPhoneNumberUtil;", "", "", "p0", "", "MyBillsEntityDataFactory", "(Ljava/lang/CharSequence;)Ljava/lang/String;", "KClassImpl$Data$declaredNonStaticMembers$2", "(Ljava/lang/String;)Ljava/lang/String;", "Lkotlin/Pair;", "BuiltInFictitiousFunctionClassFactory", "(Ljava/lang/CharSequence;)Lkotlin/Pair;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class DanaPhoneNumberUtil {
    public static final DanaPhoneNumberUtil INSTANCE = new DanaPhoneNumberUtil();

    private DanaPhoneNumberUtil() {
    }

    @JvmStatic
    public static final String KClassImpl$Data$declaredNonStaticMembers$2(String p0) {
        String formatNumber;
        Intrinsics.checkNotNullParameter(p0, "");
        if (Build.VERSION.SDK_INT >= 21) {
            formatNumber = PhoneNumberUtils.formatNumber(p0, "ID");
        } else {
            formatNumber = PhoneNumberUtils.formatNumber(p0);
        }
        return formatNumber == null ? "" : formatNumber;
    }

    @JvmStatic
    public static final String MyBillsEntityDataFactory(CharSequence p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        StringBuilder sb = new StringBuilder(p0);
        sb.insert(4, '-');
        if (p0.length() > 8) {
            sb.insert(9, '-');
        }
        String obj = sb.toString();
        Intrinsics.checkNotNullExpressionValue(obj, "");
        return obj;
    }

    @JvmStatic
    public static final Pair<String, String> BuiltInFictitiousFunctionClassFactory(CharSequence p0) {
        String replace;
        Intrinsics.checkNotNullParameter(p0, "");
        String MyBillsEntityDataFactory = MyBillsEntityDataFactory(p0);
        if (new Regex("^(\\+*62)*0*8").containsMatchIn(MyBillsEntityDataFactory)) {
            replace = new Regex("^(\\+*62)*0*8").replace(MyBillsEntityDataFactory, "8");
        } else {
            replace = new Regex("^(\\+*62)*0*2").replace(MyBillsEntityDataFactory, "2");
        }
        StringBuilder sb = new StringBuilder();
        sb.append(replace);
        sb.append('-');
        return TuplesKt.to("+62", sb.toString());
    }
}
