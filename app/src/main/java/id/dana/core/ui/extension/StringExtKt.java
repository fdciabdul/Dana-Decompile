package id.dana.core.ui.extension;

import android.text.TextUtils;
import java.text.NumberFormat;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000\u001a\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\u001a\u001e\u0010\u0000\u001a\u0002H\u0001\"\u0006\b\u0000\u0010\u0001\u0018\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0086\b¢\u0006\u0002\u0010\u0004\u001a\u001e\u0010\u0005\u001a\u00020\u0003\"\u0006\b\u0000\u0010\u0001\u0018\u00012\u0006\u0010\u0006\u001a\u0002H\u0001H\u0086\b¢\u0006\u0002\u0010\u0007\u001a\n\u0010\b\u001a\u00020\u0003*\u00020\u0003\u001a\n\u0010\t\u001a\u00020\u0003*\u00020\u0003\u001a\n\u0010\n\u001a\u00020\u0003*\u00020\u0003\u001a\f\u0010\u000b\u001a\u00020\f*\u0004\u0018\u00010\u0003\u001a\n\u0010\r\u001a\u00020\u000e*\u00020\u0003\u001a\u001e\u0010\u000f\u001a\u00020\u0003*\u00020\u00032\b\b\u0002\u0010\u0010\u001a\u00020\u00032\b\b\u0002\u0010\u0011\u001a\u00020\u0003¨\u0006\u0012"}, d2 = {"getArgByJson", "T", "json", "", "(Ljava/lang/String;)Ljava/lang/Object;", "sendArgByGson", "input", "(Ljava/lang/Object;)Ljava/lang/String;", "getCleanAll", "getCleanComma", "getCleanDot", "isSymbol", "", "toCleanLong", "", "toRupiah", "moneyLogo", "defaultOutput", "core-ui_productionRelease"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class StringExtKt {
    public static /* synthetic */ String PlaceComponentResult(String str) {
        return PlaceComponentResult(str, "Rp", "0");
    }

    public static String PlaceComponentResult(String str, String str2, String str3) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str2, "");
        Intrinsics.checkNotNullParameter(str3, "");
        if (!TextUtils.isEmpty(str)) {
            try {
                StringBuilder sb = new StringBuilder();
                sb.append(str2);
                sb.append(NumberFormat.getNumberInstance(new Locale("in", "ID")).format(BuiltInFictitiousFunctionClassFactory(str)));
                return sb.toString();
            } catch (Exception unused) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append(str2);
                sb2.append(str3);
                return sb2.toString();
            }
        }
        StringBuilder sb3 = new StringBuilder();
        sb3.append(str2);
        sb3.append(str3);
        return sb3.toString();
    }

    public static final long BuiltInFictitiousFunctionClassFactory(String str) {
        Intrinsics.checkNotNullParameter(str, "");
        try {
            if (TextUtils.isEmpty(str)) {
                return 0L;
            }
            Intrinsics.checkNotNullParameter(str, "");
            Intrinsics.checkNotNullParameter(str, "");
            String replace$default = StringsKt.replace$default(str, ".", "", false, 4, (Object) null);
            Intrinsics.checkNotNullParameter(replace$default, "");
            return Long.parseLong(StringsKt.replace$default(replace$default, ",", "", false, 4, (Object) null));
        } catch (Exception unused) {
            return 0L;
        }
    }

    public static final String KClassImpl$Data$declaredNonStaticMembers$2(String str) {
        Intrinsics.checkNotNullParameter(str, "");
        return StringsKt.replace$default(str, ".", "", false, 4, (Object) null);
    }

    public static final String getAuthRequestContext(String str) {
        Intrinsics.checkNotNullParameter(str, "");
        return StringsKt.replace$default(str, ",", "", false, 4, (Object) null);
    }

    public static final boolean MyBillsEntityDataFactory(String str) {
        if (str != null) {
            return !new Regex("[a-zA-Z0-9]+").matches(str);
        }
        return false;
    }
}
