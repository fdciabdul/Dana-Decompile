package id.dana.cashier;

import dagger.Module;
import dagger.Provides;
import id.dana.cashier.CashierBannerContract;
import id.dana.cashier.presenter.CashierBannerPresenter;
import id.dana.di.PerActivity;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0007¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H\u0007¢\u0006\u0004\b\b\u0010\tR\u0014\u0010\u0005\u001a\u00020\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\n"}, d2 = {"Lid/dana/cashier/CashierBannerModule;", "", "Lid/dana/cashier/presenter/CashierBannerPresenter;", "p0", "Lid/dana/cashier/CashierBannerContract$Presenter;", "KClassImpl$Data$declaredNonStaticMembers$2", "(Lid/dana/cashier/presenter/CashierBannerPresenter;)Lid/dana/cashier/CashierBannerContract$Presenter;", "Lid/dana/cashier/CashierBannerContract$View;", "PlaceComponentResult", "()Lid/dana/cashier/CashierBannerContract$View;", "Lid/dana/cashier/CashierBannerContract$View;", "<init>", "(Lid/dana/cashier/CashierBannerContract$View;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Module
/* loaded from: classes.dex */
public final class CashierBannerModule {

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private final CashierBannerContract.View KClassImpl$Data$declaredNonStaticMembers$2;

    public CashierBannerModule(CashierBannerContract.View view) {
        Intrinsics.checkNotNullParameter(view, "");
        this.KClassImpl$Data$declaredNonStaticMembers$2 = view;
    }

    @Provides
    @PerActivity
    /* renamed from: PlaceComponentResult  reason: from getter */
    public final CashierBannerContract.View getKClassImpl$Data$declaredNonStaticMembers$2() {
        return this.KClassImpl$Data$declaredNonStaticMembers$2;
    }

    @Provides
    @PerActivity
    public final CashierBannerContract.Presenter KClassImpl$Data$declaredNonStaticMembers$2(CashierBannerPresenter p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        return p0;
    }
}
