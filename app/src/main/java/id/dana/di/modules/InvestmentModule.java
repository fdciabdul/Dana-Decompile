package id.dana.di.modules;

import dagger.Module;
import dagger.Provides;
import id.dana.di.PerActivity;
import id.dana.investment.contract.InvestmentContract;
import id.dana.investment.presenter.DanaPlusInvestmentPresenter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0007¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H\u0007¢\u0006\u0004\b\b\u0010\tR\u0014\u0010\b\u001a\u00020\u00078\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000b"}, d2 = {"Lid/dana/di/modules/InvestmentModule;", "", "Lid/dana/investment/presenter/DanaPlusInvestmentPresenter;", "p0", "Lid/dana/investment/contract/InvestmentContract$Presenter;", "BuiltInFictitiousFunctionClassFactory", "(Lid/dana/investment/presenter/DanaPlusInvestmentPresenter;)Lid/dana/investment/contract/InvestmentContract$Presenter;", "Lid/dana/investment/contract/InvestmentContract$View;", "PlaceComponentResult", "()Lid/dana/investment/contract/InvestmentContract$View;", "MyBillsEntityDataFactory", "Lid/dana/investment/contract/InvestmentContract$View;", "<init>", "(Lid/dana/investment/contract/InvestmentContract$View;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Module
/* loaded from: classes2.dex */
public final class InvestmentModule {

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private final InvestmentContract.View PlaceComponentResult;

    public InvestmentModule(InvestmentContract.View view) {
        Intrinsics.checkNotNullParameter(view, "");
        this.PlaceComponentResult = view;
    }

    @Provides
    @PerActivity
    /* renamed from: PlaceComponentResult  reason: from getter */
    public final InvestmentContract.View getPlaceComponentResult() {
        return this.PlaceComponentResult;
    }

    @Provides
    @PerActivity
    public final InvestmentContract.Presenter BuiltInFictitiousFunctionClassFactory(DanaPlusInvestmentPresenter p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        return p0;
    }
}
