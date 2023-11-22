package id.dana.mybills.danah5;

import android.net.Uri;
import com.google.firebase.analytics.FirebaseAnalytics;
import id.dana.mybills.danah5.BillerPortalBridge;
import id.dana.sendmoney.summary.SummaryActivity;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u001f\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0004\u001a\u00020\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\u00028\u0002X\u0082T¢\u0006\u0006\n\u0004\b\b\u0010\t"}, d2 = {"Lid/dana/mybills/danah5/DanaUriProvider;", "", "", "event", "gameType", "Landroid/net/Uri;", "getUri", "(Ljava/lang/String;Ljava/lang/String;)Landroid/net/Uri;", "DIGITAL_VOUCHER_URL", "Ljava/lang/String;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes9.dex */
public final class DanaUriProvider {
    private static final String DIGITAL_VOUCHER_URL = "https://m.dana.id/i/biller-app/voucher";
    public static final DanaUriProvider INSTANCE = new DanaUriProvider();

    private DanaUriProvider() {
    }

    public static /* synthetic */ Uri getUri$default(DanaUriProvider danaUriProvider, String str, String str2, int i, Object obj) {
        if ((i & 2) != 0) {
            str2 = "";
        }
        return danaUriProvider.getUri(str, str2);
    }

    public final Uri getUri(String event, String gameType) {
        Intrinsics.checkNotNullParameter(event, "");
        Intrinsics.checkNotNullParameter(gameType, "");
        Uri.Builder buildUpon = Uri.parse(DIGITAL_VOUCHER_URL).buildUpon();
        if (Intrinsics.areEqual(event, BillerPortalBridge.Event.BILL_ADD)) {
            gameType = FirebaseAnalytics.Param.ITEMS;
        } else if (!Intrinsics.areEqual(event, BillerPortalBridge.Event.BILL_EDIT)) {
            gameType = "";
        }
        buildUpon.appendPath(gameType);
        buildUpon.appendQueryParameter("isFromMyBillsNative", SummaryActivity.CHECKED);
        buildUpon.appendQueryParameter("event", event);
        Uri build = buildUpon.build();
        Intrinsics.checkNotNullExpressionValue(build, "");
        return build;
    }
}
