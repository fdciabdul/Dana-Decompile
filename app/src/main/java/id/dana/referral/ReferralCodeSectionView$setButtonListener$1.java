package id.dana.referral;

import android.view.View;
import id.dana.base.BaseActivity;
import id.dana.base.SingleClickListener;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\b\n\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lid/dana/referral/ReferralCodeSectionView$setButtonListener$1;", "Lid/dana/base/SingleClickListener;", "Landroid/view/View;", "p0", "", "PlaceComponentResult", "(Landroid/view/View;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ReferralCodeSectionView$setButtonListener$1 extends SingleClickListener {
    final /* synthetic */ ReferralCodeSectionView BuiltInFictitiousFunctionClassFactory;
    final /* synthetic */ String PlaceComponentResult;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ReferralCodeSectionView$setButtonListener$1(ReferralCodeSectionView referralCodeSectionView, String str, BaseActivity baseActivity) {
        super(baseActivity);
        this.BuiltInFictitiousFunctionClassFactory = referralCodeSectionView;
        this.PlaceComponentResult = str;
    }

    @Override // id.dana.base.SingleClickListener
    public final void PlaceComponentResult(View p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        ReferralCodeSectionView.access$handleActionClicked(this.BuiltInFictitiousFunctionClassFactory, this.PlaceComponentResult);
    }
}
