package id.dana.di.modules;

import dagger.Module;
import dagger.Provides;
import id.dana.cashier.CashierContract;
import id.dana.cashier.presenter.CashierPresenter;
import id.dana.di.PerActivity;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0007¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0005\u001a\u00020\u0007H\u0007¢\u0006\u0004\b\u0005\u0010\bR\u0014\u0010\u000b\u001a\u00020\u00078\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b\t\u0010\n"}, d2 = {"Lid/dana/di/modules/CashierModule;", "", "Lid/dana/cashier/presenter/CashierPresenter;", "p0", "Lid/dana/cashier/CashierContract$Presenter;", "PlaceComponentResult", "(Lid/dana/cashier/presenter/CashierPresenter;)Lid/dana/cashier/CashierContract$Presenter;", "Lid/dana/cashier/CashierContract$View;", "()Lid/dana/cashier/CashierContract$View;", "BuiltInFictitiousFunctionClassFactory", "Lid/dana/cashier/CashierContract$View;", "KClassImpl$Data$declaredNonStaticMembers$2", "<init>", "(Lid/dana/cashier/CashierContract$View;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Module
/* loaded from: classes4.dex */
public final class CashierModule {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    private final CashierContract.View KClassImpl$Data$declaredNonStaticMembers$2;

    public CashierModule(CashierContract.View view) {
        Intrinsics.checkNotNullParameter(view, "");
        this.KClassImpl$Data$declaredNonStaticMembers$2 = view;
    }

    @Provides
    @PerActivity
    /* renamed from: PlaceComponentResult  reason: from getter */
    public final CashierContract.View getKClassImpl$Data$declaredNonStaticMembers$2() {
        return this.KClassImpl$Data$declaredNonStaticMembers$2;
    }

    @Provides
    @PerActivity
    public final CashierContract.Presenter PlaceComponentResult(CashierPresenter p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        return p0;
    }
}
