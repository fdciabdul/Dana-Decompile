package id.dana.pay;

import androidx.viewpager2.widget.ViewPager2;
import id.dana.base.BaseFragment;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0005\b\n\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J'\u0010\n\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\f\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\f\u0010\u0006"}, d2 = {"Lid/dana/pay/PayFragment$onPageChangeListener$1;", "Landroidx/viewpager2/widget/ViewPager2$OnPageChangeCallback;", "", "p0", "", "onPageScrollStateChanged", "(I)V", "", "p1", "p2", "onPageScrolled", "(IFI)V", "onPageSelected"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class PayFragment$onPageChangeListener$1 extends ViewPager2.OnPageChangeCallback {
    final /* synthetic */ PayFragment BuiltInFictitiousFunctionClassFactory;

    @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
    public final void onPageScrollStateChanged(int p0) {
    }

    @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
    public final void onPageScrolled(int p0, float p1, int p2) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public PayFragment$onPageChangeListener$1(PayFragment payFragment) {
        this.BuiltInFictitiousFunctionClassFactory = payFragment;
    }

    @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
    public final void onPageSelected(int p0) {
        int i;
        BaseFragment authRequestContext;
        int i2;
        BaseFragment BuiltInFictitiousFunctionClassFactory;
        i = this.BuiltInFictitiousFunctionClassFactory.NetworkUserEntityData$$ExternalSyntheticLambda0;
        if (i >= 0) {
            PayFragment payFragment = this.BuiltInFictitiousFunctionClassFactory;
            i2 = payFragment.NetworkUserEntityData$$ExternalSyntheticLambda0;
            BuiltInFictitiousFunctionClassFactory = payFragment.BuiltInFictitiousFunctionClassFactory(i2);
            PaymentMethodListener paymentMethodListener = BuiltInFictitiousFunctionClassFactory instanceof PaymentMethodListener ? (PaymentMethodListener) BuiltInFictitiousFunctionClassFactory : null;
            if (paymentMethodListener != null) {
                paymentMethodListener.MyBillsEntityDataFactory();
            }
        }
        this.BuiltInFictitiousFunctionClassFactory.NetworkUserEntityData$$ExternalSyntheticLambda0 = p0;
        authRequestContext = this.BuiltInFictitiousFunctionClassFactory.getAuthRequestContext();
        PaymentMethodListener paymentMethodListener2 = authRequestContext instanceof PaymentMethodListener ? (PaymentMethodListener) authRequestContext : null;
        if (paymentMethodListener2 != null) {
            paymentMethodListener2.PlaceComponentResult();
        }
    }
}
