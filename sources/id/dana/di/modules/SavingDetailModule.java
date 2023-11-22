package id.dana.di.modules;

import dagger.Module;
import dagger.Provides;
import id.dana.di.PerActivity;
import id.dana.savings.contract.SavingDetailContract;
import id.dana.savings.presenter.SavingDetailPresenter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0007¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H\u0007¢\u0006\u0004\b\b\u0010\tR\u0014\u0010\u000b\u001a\u00020\u00078\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b\b\u0010\n"}, d2 = {"Lid/dana/di/modules/SavingDetailModule;", "", "Lid/dana/savings/presenter/SavingDetailPresenter;", "p0", "Lid/dana/savings/contract/SavingDetailContract$Presenter;", "BuiltInFictitiousFunctionClassFactory", "(Lid/dana/savings/presenter/SavingDetailPresenter;)Lid/dana/savings/contract/SavingDetailContract$Presenter;", "Lid/dana/savings/contract/SavingDetailContract$View;", "PlaceComponentResult", "()Lid/dana/savings/contract/SavingDetailContract$View;", "Lid/dana/savings/contract/SavingDetailContract$View;", "getAuthRequestContext", "<init>", "(Lid/dana/savings/contract/SavingDetailContract$View;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Module
/* loaded from: classes4.dex */
public final class SavingDetailModule {

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private final SavingDetailContract.View getAuthRequestContext;

    public SavingDetailModule(SavingDetailContract.View view) {
        Intrinsics.checkNotNullParameter(view, "");
        this.getAuthRequestContext = view;
    }

    @Provides
    @PerActivity
    /* renamed from: PlaceComponentResult  reason: from getter */
    public final SavingDetailContract.View getGetAuthRequestContext() {
        return this.getAuthRequestContext;
    }

    @Provides
    @PerActivity
    public final SavingDetailContract.Presenter BuiltInFictitiousFunctionClassFactory(SavingDetailPresenter p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        return p0;
    }
}
