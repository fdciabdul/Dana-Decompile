package id.dana.cashier;

import dagger.Module;
import dagger.Provides;
import id.dana.cashier.CashierHighlightContract;
import id.dana.cashier.presenter.CashierHighlightPresenter;
import id.dana.di.PerActivity;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0007¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0005\u001a\u00020\u0007H\u0007¢\u0006\u0004\b\u0005\u0010\bR\u0011\u0010\n\u001a\u00020\u0007X\u0006¢\u0006\u0006\n\u0004\b\u0005\u0010\t"}, d2 = {"Lid/dana/cashier/CashierHighlightModule;", "", "Lid/dana/cashier/presenter/CashierHighlightPresenter;", "p0", "Lid/dana/cashier/CashierHighlightContract$Presenter;", "PlaceComponentResult", "(Lid/dana/cashier/presenter/CashierHighlightPresenter;)Lid/dana/cashier/CashierHighlightContract$Presenter;", "Lid/dana/cashier/CashierHighlightContract$View;", "()Lid/dana/cashier/CashierHighlightContract$View;", "Lid/dana/cashier/CashierHighlightContract$View;", "BuiltInFictitiousFunctionClassFactory", "<init>", "(Lid/dana/cashier/CashierHighlightContract$View;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Module
/* loaded from: classes4.dex */
public final class CashierHighlightModule {

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    public final CashierHighlightContract.View BuiltInFictitiousFunctionClassFactory;

    public CashierHighlightModule(CashierHighlightContract.View view) {
        Intrinsics.checkNotNullParameter(view, "");
        this.BuiltInFictitiousFunctionClassFactory = view;
    }

    @Provides
    @PerActivity
    /* renamed from: PlaceComponentResult  reason: from getter */
    public final CashierHighlightContract.View getBuiltInFictitiousFunctionClassFactory() {
        return this.BuiltInFictitiousFunctionClassFactory;
    }

    @Provides
    @PerActivity
    public final CashierHighlightContract.Presenter PlaceComponentResult(CashierHighlightPresenter p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        return p0;
    }
}
