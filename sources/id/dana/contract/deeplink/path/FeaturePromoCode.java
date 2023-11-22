package id.dana.contract.deeplink.path;

import android.app.Activity;
import android.content.Intent;
import id.dana.promocode.views.RedeemPromoCodeActivity;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\nJ!\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0007¢\u0006\u0004\b\u0007\u0010\b"}, d2 = {"Lid/dana/contract/deeplink/path/FeaturePromoCode;", "", "Landroid/app/Activity;", "p0", "", "p1", "", "getAuthRequestContext", "(Landroid/app/Activity;Ljava/lang/String;)V", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class FeaturePromoCode {
    public static final FeaturePromoCode INSTANCE = new FeaturePromoCode();

    private FeaturePromoCode() {
    }

    @JvmStatic
    public static final void getAuthRequestContext(Activity p0, String p1) {
        Intrinsics.checkNotNullParameter(p0, "");
        Intent intent = new Intent(p0, RedeemPromoCodeActivity.class);
        intent.putExtra("promoCode", p1);
        p0.startActivity(intent);
    }
}
