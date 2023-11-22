package id.dana.di.modules;

import dagger.Module;
import dagger.Provides;
import id.dana.di.PerActivity;
import id.dana.savings.contract.SavingTopUpContract;
import id.dana.savings.presenter.SavingTopUpPresenter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0007¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0005\u001a\u00020\u0007H\u0007¢\u0006\u0004\b\u0005\u0010\bR\u0014\u0010\u000b\u001a\u00020\u00078\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b\t\u0010\n"}, d2 = {"Lid/dana/di/modules/SavingTopUpModule;", "", "Lid/dana/savings/presenter/SavingTopUpPresenter;", "p0", "Lid/dana/savings/contract/SavingTopUpContract$Presenter;", "KClassImpl$Data$declaredNonStaticMembers$2", "(Lid/dana/savings/presenter/SavingTopUpPresenter;)Lid/dana/savings/contract/SavingTopUpContract$Presenter;", "Lid/dana/savings/contract/SavingTopUpContract$View;", "()Lid/dana/savings/contract/SavingTopUpContract$View;", "BuiltInFictitiousFunctionClassFactory", "Lid/dana/savings/contract/SavingTopUpContract$View;", "MyBillsEntityDataFactory", "<init>", "(Lid/dana/savings/contract/SavingTopUpContract$View;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Module
/* loaded from: classes4.dex */
public final class SavingTopUpModule {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    private final SavingTopUpContract.View MyBillsEntityDataFactory;

    public SavingTopUpModule(SavingTopUpContract.View view) {
        Intrinsics.checkNotNullParameter(view, "");
        this.MyBillsEntityDataFactory = view;
    }

    @Provides
    @PerActivity
    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from getter */
    public final SavingTopUpContract.View getMyBillsEntityDataFactory() {
        return this.MyBillsEntityDataFactory;
    }

    @Provides
    @PerActivity
    public final SavingTopUpContract.Presenter KClassImpl$Data$declaredNonStaticMembers$2(SavingTopUpPresenter p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        return p0;
    }
}
