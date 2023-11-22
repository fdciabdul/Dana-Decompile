package id.dana.requestmoney;

import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\u001a\u0019\u0010\u0002\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u0019\u0010\u0005\u001a\u00020\u0004*\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0005\u0010\u0006\u001a\u0019\u0010\u0007\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0007\u0010\u0003"}, d2 = {"", "p0", "MyBillsEntityDataFactory", "(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;", "", "PlaceComponentResult", "(Ljava/lang/String;Ljava/lang/String;)Z", "KClassImpl$Data$declaredNonStaticMembers$2"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class RequestMoneyTrackingHelperKt {
    public static final boolean PlaceComponentResult(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str2, "");
        String format = String.format("?params=[source=%s]", Arrays.copyOf(new Object[]{str2}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "");
        return StringsKt.contains$default((CharSequence) str, (CharSequence) format, false, 2, (Object) null);
    }

    public static final String MyBillsEntityDataFactory(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str2, "");
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        String format = String.format("?params=[source=%s]", Arrays.copyOf(new Object[]{str2}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "");
        sb.append(format);
        return sb.toString();
    }

    public static final String KClassImpl$Data$declaredNonStaticMembers$2(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str2, "");
        String format = String.format("?params=[source=%s]", Arrays.copyOf(new Object[]{str2}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "");
        return StringsKt.replace$default(str, format, "", false, 4, (Object) null);
    }
}
