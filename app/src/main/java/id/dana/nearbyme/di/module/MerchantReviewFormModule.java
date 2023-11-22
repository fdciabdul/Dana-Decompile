package id.dana.nearbyme.di.module;

import dagger.Module;
import dagger.Provides;
import id.dana.di.PerActivity;
import id.dana.nearbyme.merchantreview.MerchantReviewFormContract;
import id.dana.nearbyme.merchantreview.MerchantReviewFormPresenter;
import id.dana.nearbyme.merchantreview.tracker.MerchantReviewFormAnalyticTracker;
import id.dana.nearbyme.merchantreview.tracker.MerchantReviewFormMixpanelTracker;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u000b¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0007H\u0007¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\f\u001a\u00020\u000bH\u0007¢\u0006\u0004\b\f\u0010\rR\u0014\u0010\f\u001a\u00020\u000b8\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b\t\u0010\u000e"}, d2 = {"Lid/dana/nearbyme/di/module/MerchantReviewFormModule;", "", "Lid/dana/nearbyme/merchantreview/MerchantReviewFormPresenter;", "p0", "Lid/dana/nearbyme/merchantreview/MerchantReviewFormContract$Presenter;", "BuiltInFictitiousFunctionClassFactory", "(Lid/dana/nearbyme/merchantreview/MerchantReviewFormPresenter;)Lid/dana/nearbyme/merchantreview/MerchantReviewFormContract$Presenter;", "Lid/dana/nearbyme/merchantreview/tracker/MerchantReviewFormMixpanelTracker;", "Lid/dana/nearbyme/merchantreview/tracker/MerchantReviewFormAnalyticTracker;", "getAuthRequestContext", "(Lid/dana/nearbyme/merchantreview/tracker/MerchantReviewFormMixpanelTracker;)Lid/dana/nearbyme/merchantreview/tracker/MerchantReviewFormAnalyticTracker;", "Lid/dana/nearbyme/merchantreview/MerchantReviewFormContract$View;", "PlaceComponentResult", "()Lid/dana/nearbyme/merchantreview/MerchantReviewFormContract$View;", "Lid/dana/nearbyme/merchantreview/MerchantReviewFormContract$View;", "<init>", "(Lid/dana/nearbyme/merchantreview/MerchantReviewFormContract$View;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Module
/* loaded from: classes5.dex */
public final class MerchantReviewFormModule {

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    private final MerchantReviewFormContract.View PlaceComponentResult;

    public MerchantReviewFormModule(MerchantReviewFormContract.View view) {
        Intrinsics.checkNotNullParameter(view, "");
        this.PlaceComponentResult = view;
    }

    @Provides
    @PerActivity
    /* renamed from: PlaceComponentResult  reason: from getter */
    public final MerchantReviewFormContract.View getPlaceComponentResult() {
        return this.PlaceComponentResult;
    }

    @Provides
    @PerActivity
    public final MerchantReviewFormContract.Presenter BuiltInFictitiousFunctionClassFactory(MerchantReviewFormPresenter p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        return p0;
    }

    @Provides
    @PerActivity
    public final MerchantReviewFormAnalyticTracker getAuthRequestContext(MerchantReviewFormMixpanelTracker p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        return p0;
    }
}
