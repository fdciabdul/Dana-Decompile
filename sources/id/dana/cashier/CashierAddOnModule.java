package id.dana.cashier;

import dagger.Module;
import dagger.Provides;
import id.dana.cashier.CashierAddOnContract;
import id.dana.cashier.presenter.CashierAddOnPresenter;
import id.dana.di.PerActivity;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0007¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H\u0007¢\u0006\u0004\b\b\u0010\tR\u0011\u0010\u000b\u001a\u00020\u0007X\u0006¢\u0006\u0006\n\u0004\b\b\u0010\n"}, d2 = {"Lid/dana/cashier/CashierAddOnModule;", "", "Lid/dana/cashier/presenter/CashierAddOnPresenter;", "p0", "Lid/dana/cashier/CashierAddOnContract$Presenter;", "MyBillsEntityDataFactory", "(Lid/dana/cashier/presenter/CashierAddOnPresenter;)Lid/dana/cashier/CashierAddOnContract$Presenter;", "Lid/dana/cashier/CashierAddOnContract$View;", "BuiltInFictitiousFunctionClassFactory", "()Lid/dana/cashier/CashierAddOnContract$View;", "Lid/dana/cashier/CashierAddOnContract$View;", "getAuthRequestContext", "<init>", "(Lid/dana/cashier/CashierAddOnContract$View;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Module
/* loaded from: classes4.dex */
public final class CashierAddOnModule {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    public final CashierAddOnContract.View getAuthRequestContext;

    public CashierAddOnModule(CashierAddOnContract.View view) {
        Intrinsics.checkNotNullParameter(view, "");
        this.getAuthRequestContext = view;
    }

    @Provides
    @PerActivity
    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from getter */
    public final CashierAddOnContract.View getGetAuthRequestContext() {
        return this.getAuthRequestContext;
    }

    @Provides
    @PerActivity
    public final CashierAddOnContract.Presenter MyBillsEntityDataFactory(CashierAddOnPresenter p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        return p0;
    }
}
