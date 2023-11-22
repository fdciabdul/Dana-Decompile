package id.dana.referral.view;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import id.dana.R;
import id.dana.core.ui.glide.ImageAttacher;
import id.dana.onboarding.view.BaseSimpleView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u0011\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\t\u0010\nR\u0016\u0010\u0003\u001a\u0004\u0018\u00010\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u000b"}, d2 = {"Lid/dana/referral/view/ReferralBannerView;", "Lid/dana/onboarding/view/BaseSimpleView;", "", "KClassImpl$Data$declaredNonStaticMembers$2", "()I", "", "getAuthRequestContext", "()Ljava/lang/String;", "", "BuiltInFictitiousFunctionClassFactory", "()V", "Ljava/lang/String;", "p0", "<init>", "(Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ReferralBannerView extends BaseSimpleView {

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    private final String KClassImpl$Data$declaredNonStaticMembers$2;

    @Override // id.dana.onboarding.view.BaseSimpleView
    public final int KClassImpl$Data$declaredNonStaticMembers$2() {
        return R.layout.view_referral_banner;
    }

    @Override // id.dana.onboarding.view.SimpleView
    /* renamed from: getAuthRequestContext */
    public final String getKClassImpl$Data$declaredNonStaticMembers$2() {
        return "";
    }

    public ReferralBannerView(String str) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = str;
    }

    @Override // id.dana.onboarding.view.SimpleView
    public final void BuiltInFictitiousFunctionClassFactory() {
        String str = this.KClassImpl$Data$declaredNonStaticMembers$2;
        if (str != null) {
            Context context = this.KClassImpl$Data$declaredNonStaticMembers$2;
            if (context == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
                context = null;
            }
            View findViewById = m_().findViewById(R.id.iv_referral_banner);
            Intrinsics.checkNotNullExpressionValue(findViewById, "");
            ImageAttacher.PlaceComponentResult(context, str, R.drawable.bg_skeleton_banner, (ImageView) findViewById);
        }
    }
}
