package id.dana.di.modules;

import dagger.Module;
import dagger.Provides;
import id.dana.di.PerActivity;
import id.dana.savings.contract.SavingTopUpHistoryContract;
import id.dana.savings.presenter.SavingTopUpHistoryPresenter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0007¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H\u0007¢\u0006\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\u00020\u00078\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000b"}, d2 = {"Lid/dana/di/modules/SavingTopUpHistoryModule;", "", "Lid/dana/savings/presenter/SavingTopUpHistoryPresenter;", "p0", "Lid/dana/savings/contract/SavingTopUpHistoryContract$Presenter;", "BuiltInFictitiousFunctionClassFactory", "(Lid/dana/savings/presenter/SavingTopUpHistoryPresenter;)Lid/dana/savings/contract/SavingTopUpHistoryContract$Presenter;", "Lid/dana/savings/contract/SavingTopUpHistoryContract$View;", "PlaceComponentResult", "()Lid/dana/savings/contract/SavingTopUpHistoryContract$View;", "MyBillsEntityDataFactory", "Lid/dana/savings/contract/SavingTopUpHistoryContract$View;", "<init>", "(Lid/dana/savings/contract/SavingTopUpHistoryContract$View;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Module
/* loaded from: classes8.dex */
public final class SavingTopUpHistoryModule {
    private final SavingTopUpHistoryContract.View MyBillsEntityDataFactory;

    public SavingTopUpHistoryModule(SavingTopUpHistoryContract.View view) {
        Intrinsics.checkNotNullParameter(view, "");
        this.MyBillsEntityDataFactory = view;
    }

    @Provides
    @PerActivity
    /* renamed from: PlaceComponentResult  reason: from getter */
    public final SavingTopUpHistoryContract.View getMyBillsEntityDataFactory() {
        return this.MyBillsEntityDataFactory;
    }

    @Provides
    @PerActivity
    public final SavingTopUpHistoryContract.Presenter BuiltInFictitiousFunctionClassFactory(SavingTopUpHistoryPresenter p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        return p0;
    }
}
