package id.dana.cashier.data;

import android.net.Uri;
import id.dana.cashier.data.constant.CashierUrl;
import id.dana.data.ProductFlavor;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bJ\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0015\u0010\u0005\u001a\u0004\u0018\u00010\u0002*\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lid/dana/cashier/data/CashierUrlUtil;", "", "", "getGuideCdnUrl", "()Ljava/lang/String;", "replaceHostToBuildHost", "(Ljava/lang/String;)Ljava/lang/String;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class CashierUrlUtil {
    public static final CashierUrlUtil INSTANCE = new CashierUrlUtil();

    private CashierUrlUtil() {
    }

    public final String getGuideCdnUrl() {
        return (Intrinsics.areEqual("production", "production") || Intrinsics.areEqual(ProductFlavor.PREPROD, "production")) ? CashierUrl.GUIDE_CDN_URL_PROD : CashierUrl.GUIDE_CDN_URL_TEST;
    }

    public final String replaceHostToBuildHost(String str) {
        if (str != null) {
            String str2 = StringsKt.isBlank(str) ^ true ? str : null;
            if (str2 != null) {
                Uri parse = Uri.parse(str2);
                Intrinsics.checkNotNullExpressionValue(parse, "");
                if (parse.getHost() != null) {
                    Uri parse2 = Uri.parse("https://m.dana.id");
                    Intrinsics.checkNotNullExpressionValue(parse2, "");
                    String host = parse2.getHost();
                    Intrinsics.checkNotNull(host);
                    Uri parse3 = Uri.parse(str2);
                    Intrinsics.checkNotNullExpressionValue(parse3, "");
                    String host2 = parse3.getHost();
                    Intrinsics.checkNotNull(host2);
                    str2 = StringsKt.replace$default(str2, host2, host, false, 4, (Object) null);
                }
                return str2 != null ? str2 : str;
            }
            return str;
        }
        return str;
    }
}
