package id.dana.richview;

import android.os.Handler;
import com.rd.PageIndicatorView;
import id.dana.R;
import id.dana.animation.banner.NewPromotionBannerAdapter;
import id.dana.model.CdpContentModel;
import id.dana.richview.CircularViewPager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\b\n\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u001f\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u0005\u0010\t"}, d2 = {"Lid/dana/richview/NewBannerView$initViewPager$1;", "Lid/dana/richview/CircularViewPager$IndicatorPageChangeListener;", "", "p0", "", "PlaceComponentResult", "(I)V", "", "p1", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class NewBannerView$initViewPager$1 implements CircularViewPager.IndicatorPageChangeListener {
    final /* synthetic */ NewBannerView BuiltInFictitiousFunctionClassFactory;

    /* JADX INFO: Access modifiers changed from: package-private */
    public NewBannerView$initViewPager$1(NewBannerView newBannerView) {
        this.BuiltInFictitiousFunctionClassFactory = newBannerView;
    }

    @Override // id.dana.richview.CircularViewPager.IndicatorPageChangeListener
    public final void PlaceComponentResult() {
        Handler handler;
        handler = this.BuiltInFictitiousFunctionClassFactory.NetworkUserEntityData$$ExternalSyntheticLambda1;
        final NewBannerView newBannerView = this.BuiltInFictitiousFunctionClassFactory;
        handler.postDelayed(new Runnable() { // from class: id.dana.richview.NewBannerView$initViewPager$1$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                NewBannerView$initViewPager$1.getAuthRequestContext(NewBannerView.this);
            }
        }, 1500L);
    }

    @Override // id.dana.richview.CircularViewPager.IndicatorPageChangeListener
    public final void PlaceComponentResult(int p0) {
        boolean authRequestContext;
        NewPromotionBannerAdapter newPromotionBannerAdapter;
        boolean z;
        PageIndicatorView pageIndicatorView = (PageIndicatorView) this.BuiltInFictitiousFunctionClassFactory._$_findCachedViewById(R.id.getDiscountType);
        if (pageIndicatorView != null) {
            pageIndicatorView.setSelection(p0);
        }
        authRequestContext = this.BuiltInFictitiousFunctionClassFactory.getAuthRequestContext();
        if (authRequestContext && this.BuiltInFictitiousFunctionClassFactory.isShown()) {
            newPromotionBannerAdapter = this.BuiltInFictitiousFunctionClassFactory.scheduleImpl;
            CdpContentModel cdpContentModel = null;
            if (newPromotionBannerAdapter != null && !newPromotionBannerAdapter.getAuthRequestContext(p0)) {
                cdpContentModel = newPromotionBannerAdapter.MyBillsEntityDataFactory().get(p0);
            }
            z = this.BuiltInFictitiousFunctionClassFactory.NetworkUserEntityData$$ExternalSyntheticLambda7;
            if (z && cdpContentModel != null) {
                NewBannerView.access$trackVisibleSlideItem(this.BuiltInFictitiousFunctionClassFactory, cdpContentModel);
            } else {
                this.BuiltInFictitiousFunctionClassFactory.hideIndicator();
            }
        }
    }

    public static /* synthetic */ void getAuthRequestContext(NewBannerView newBannerView) {
        Intrinsics.checkNotNullParameter(newBannerView, "");
        newBannerView.hideIndicator();
    }
}
