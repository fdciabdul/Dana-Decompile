package id.dana.di.modules;

import android.content.Context;
import dagger.Module;
import dagger.Provides;
import id.dana.contract.promodiscovery.PromoDiscoveryContract;
import id.dana.contract.promodiscovery.PromoDiscoveryPresenter;
import id.dana.di.PerActivity;
import id.dana.promodiscovery.tracker.PromoDiscoveryAnalyticTracker;
import id.dana.promodiscovery.tracker.PromoDiscoveryMixpanelTracker;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\n¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\u0005\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0007H\u0007¢\u0006\u0004\b\u0005\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0007¢\u0006\u0004\b\u000b\u0010\fR\u0014\u0010\u000f\u001a\u00020\n8\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000e"}, d2 = {"Lid/dana/di/modules/PromoDiscoveryModule;", "", "Lid/dana/contract/promodiscovery/PromoDiscoveryPresenter;", "p0", "Lid/dana/contract/promodiscovery/PromoDiscoveryContract$Presenter;", "PlaceComponentResult", "(Lid/dana/contract/promodiscovery/PromoDiscoveryPresenter;)Lid/dana/contract/promodiscovery/PromoDiscoveryContract$Presenter;", "Landroid/content/Context;", "Lid/dana/promodiscovery/tracker/PromoDiscoveryAnalyticTracker;", "(Landroid/content/Context;)Lid/dana/promodiscovery/tracker/PromoDiscoveryAnalyticTracker;", "Lid/dana/contract/promodiscovery/PromoDiscoveryContract$View;", "MyBillsEntityDataFactory", "()Lid/dana/contract/promodiscovery/PromoDiscoveryContract$View;", "KClassImpl$Data$declaredNonStaticMembers$2", "Lid/dana/contract/promodiscovery/PromoDiscoveryContract$View;", "getAuthRequestContext", "<init>", "(Lid/dana/contract/promodiscovery/PromoDiscoveryContract$View;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Module
/* loaded from: classes4.dex */
public final class PromoDiscoveryModule {

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    private final PromoDiscoveryContract.View getAuthRequestContext;

    public PromoDiscoveryModule(PromoDiscoveryContract.View view) {
        Intrinsics.checkNotNullParameter(view, "");
        this.getAuthRequestContext = view;
    }

    @Provides
    @PerActivity
    /* renamed from: MyBillsEntityDataFactory  reason: from getter */
    public final PromoDiscoveryContract.View getGetAuthRequestContext() {
        return this.getAuthRequestContext;
    }

    @Provides
    @PerActivity
    public final PromoDiscoveryContract.Presenter PlaceComponentResult(PromoDiscoveryPresenter p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        return p0;
    }

    @Provides
    public final PromoDiscoveryAnalyticTracker PlaceComponentResult(Context p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        return new PromoDiscoveryMixpanelTracker(p0);
    }
}
