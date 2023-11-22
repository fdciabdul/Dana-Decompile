package id.dana.data.util;

import id.dana.data.constant.DanaUrl;
import java.util.Arrays;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u0019\u0010\u0004\u001a\u00020\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0007¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lid/dana/data/util/BankLogoUrlUtil;", "", "", "instId", "getBankLogoUrl", "(Ljava/lang/String;)Ljava/lang/String;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class BankLogoUrlUtil {
    public static final BankLogoUrlUtil INSTANCE = new BankLogoUrlUtil();

    private BankLogoUrlUtil() {
    }

    @JvmStatic
    public static final String getBankLogoUrl(String instId) {
        String str = instId;
        if (str == null || StringsKt.isBlank(str)) {
            return "";
        }
        Locale locale = Locale.ROOT;
        Intrinsics.checkNotNullExpressionValue(locale, "");
        String lowerCase = instId.toLowerCase(locale);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "");
        String format = String.format(DanaUrl.CHANNEL_OUTLET_CASHIER_URL, Arrays.copyOf(new Object[]{lowerCase}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "");
        return format;
    }
}
