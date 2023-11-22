package id.dana.di.modules;

import dagger.Module;
import dagger.Provides;
import id.dana.di.PerActivity;
import id.dana.nearbyme.merchantdetail.tracker.MerchantDetailAnalyticTracker;
import id.dana.nearbyme.merchantdetail.tracker.MerchantDetailMixpanelTrackers;
import id.dana.nearbyme.merchantdetail.viewcomponent.MerchantDetailReviewContract;
import id.dana.nearbyme.merchantdetail.viewcomponent.MerchantDetailReviewPresenter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0007¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H\u0007¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\nH\u0007¢\u0006\u0004\b\f\u0010\rR\u0014\u0010\f\u001a\u00020\u00078\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b\b\u0010\u000e"}, d2 = {"Lid/dana/di/modules/MerchantDetailReviewModule;", "", "Lid/dana/nearbyme/merchantdetail/tracker/MerchantDetailMixpanelTrackers;", "p0", "Lid/dana/nearbyme/merchantdetail/tracker/MerchantDetailAnalyticTracker;", "getAuthRequestContext", "(Lid/dana/nearbyme/merchantdetail/tracker/MerchantDetailMixpanelTrackers;)Lid/dana/nearbyme/merchantdetail/tracker/MerchantDetailAnalyticTracker;", "Lid/dana/nearbyme/merchantdetail/viewcomponent/MerchantDetailReviewContract$View;", "MyBillsEntityDataFactory", "()Lid/dana/nearbyme/merchantdetail/viewcomponent/MerchantDetailReviewContract$View;", "Lid/dana/nearbyme/merchantdetail/viewcomponent/MerchantDetailReviewPresenter;", "Lid/dana/nearbyme/merchantdetail/viewcomponent/MerchantDetailReviewContract$Presenter;", "BuiltInFictitiousFunctionClassFactory", "(Lid/dana/nearbyme/merchantdetail/viewcomponent/MerchantDetailReviewPresenter;)Lid/dana/nearbyme/merchantdetail/viewcomponent/MerchantDetailReviewContract$Presenter;", "Lid/dana/nearbyme/merchantdetail/viewcomponent/MerchantDetailReviewContract$View;", "<init>", "(Lid/dana/nearbyme/merchantdetail/viewcomponent/MerchantDetailReviewContract$View;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Module
/* loaded from: classes4.dex */
public final class MerchantDetailReviewModule {

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private final MerchantDetailReviewContract.View BuiltInFictitiousFunctionClassFactory;

    public MerchantDetailReviewModule(MerchantDetailReviewContract.View view) {
        Intrinsics.checkNotNullParameter(view, "");
        this.BuiltInFictitiousFunctionClassFactory = view;
    }

    @Provides
    @PerActivity
    /* renamed from: MyBillsEntityDataFactory  reason: from getter */
    public final MerchantDetailReviewContract.View getBuiltInFictitiousFunctionClassFactory() {
        return this.BuiltInFictitiousFunctionClassFactory;
    }

    @Provides
    @PerActivity
    public final MerchantDetailReviewContract.Presenter BuiltInFictitiousFunctionClassFactory(MerchantDetailReviewPresenter p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        return p0;
    }

    @Provides
    @PerActivity
    public final MerchantDetailAnalyticTracker getAuthRequestContext(MerchantDetailMixpanelTrackers p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        return p0;
    }
}
