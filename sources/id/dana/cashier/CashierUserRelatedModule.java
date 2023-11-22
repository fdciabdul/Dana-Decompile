package id.dana.cashier;

import dagger.Module;
import dagger.Provides;
import id.dana.cashier.CashierUserRelatedContract;
import id.dana.cashier.presenter.CashierUserRelatedPresenter;
import id.dana.di.PerActivity;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0007¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0005\u001a\u00020\u0007H\u0007¢\u0006\u0004\b\u0005\u0010\bR\u0014\u0010\u000b\u001a\u00020\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\n"}, d2 = {"Lid/dana/cashier/CashierUserRelatedModule;", "", "Lid/dana/cashier/presenter/CashierUserRelatedPresenter;", "p0", "Lid/dana/cashier/CashierUserRelatedContract$Presenter;", "MyBillsEntityDataFactory", "(Lid/dana/cashier/presenter/CashierUserRelatedPresenter;)Lid/dana/cashier/CashierUserRelatedContract$Presenter;", "Lid/dana/cashier/CashierUserRelatedContract$View;", "()Lid/dana/cashier/CashierUserRelatedContract$View;", "KClassImpl$Data$declaredNonStaticMembers$2", "Lid/dana/cashier/CashierUserRelatedContract$View;", "getAuthRequestContext", "<init>", "(Lid/dana/cashier/CashierUserRelatedContract$View;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Module
/* loaded from: classes.dex */
public final class CashierUserRelatedModule {

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    private final CashierUserRelatedContract.View getAuthRequestContext;

    public CashierUserRelatedModule(CashierUserRelatedContract.View view) {
        Intrinsics.checkNotNullParameter(view, "");
        this.getAuthRequestContext = view;
    }

    @Provides
    @PerActivity
    /* renamed from: MyBillsEntityDataFactory  reason: from getter */
    public final CashierUserRelatedContract.View getGetAuthRequestContext() {
        return this.getAuthRequestContext;
    }

    @Provides
    @PerActivity
    public final CashierUserRelatedContract.Presenter MyBillsEntityDataFactory(CashierUserRelatedPresenter p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        return p0;
    }
}
