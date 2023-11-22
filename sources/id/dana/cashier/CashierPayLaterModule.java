package id.dana.cashier;

import dagger.Module;
import dagger.Provides;
import id.dana.cashier.CashierPayLaterContract;
import id.dana.cashier.presenter.CashierPayLaterPresenter;
import id.dana.di.PerActivity;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0007¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H\u0007¢\u0006\u0004\b\b\u0010\tR\u0014\u0010\b\u001a\u00020\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\n"}, d2 = {"Lid/dana/cashier/CashierPayLaterModule;", "", "Lid/dana/cashier/presenter/CashierPayLaterPresenter;", "p0", "Lid/dana/cashier/CashierPayLaterContract$Presenter;", "PlaceComponentResult", "(Lid/dana/cashier/presenter/CashierPayLaterPresenter;)Lid/dana/cashier/CashierPayLaterContract$Presenter;", "Lid/dana/cashier/CashierPayLaterContract$View;", "getAuthRequestContext", "()Lid/dana/cashier/CashierPayLaterContract$View;", "Lid/dana/cashier/CashierPayLaterContract$View;", "<init>", "(Lid/dana/cashier/CashierPayLaterContract$View;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Module
/* loaded from: classes.dex */
public final class CashierPayLaterModule {
    private final CashierPayLaterContract.View getAuthRequestContext;

    public CashierPayLaterModule(CashierPayLaterContract.View view) {
        Intrinsics.checkNotNullParameter(view, "");
        this.getAuthRequestContext = view;
    }

    @Provides
    @PerActivity
    /* renamed from: getAuthRequestContext  reason: from getter */
    public final CashierPayLaterContract.View getGetAuthRequestContext() {
        return this.getAuthRequestContext;
    }

    @Provides
    @PerActivity
    public final CashierPayLaterContract.Presenter PlaceComponentResult(CashierPayLaterPresenter p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        return p0;
    }
}
