package id.dana.di.modules;

import dagger.Module;
import dagger.Provides;
import id.dana.paymentsetting.PaymentSettingContract;
import id.dana.paymentsetting.PaymentSettingPresenter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0007¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0001¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H\u0001¢\u0006\u0004\b\b\u0010\tR\u0014\u0010\u000b\u001a\u00020\u00078\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b\b\u0010\n"}, d2 = {"Lid/dana/di/modules/PaymentSettingModule;", "", "Lid/dana/paymentsetting/PaymentSettingPresenter;", "p0", "Lid/dana/paymentsetting/PaymentSettingContract$Presenter;", "MyBillsEntityDataFactory", "(Lid/dana/paymentsetting/PaymentSettingPresenter;)Lid/dana/paymentsetting/PaymentSettingContract$Presenter;", "Lid/dana/paymentsetting/PaymentSettingContract$View;", "PlaceComponentResult", "()Lid/dana/paymentsetting/PaymentSettingContract$View;", "Lid/dana/paymentsetting/PaymentSettingContract$View;", "BuiltInFictitiousFunctionClassFactory", "<init>", "(Lid/dana/paymentsetting/PaymentSettingContract$View;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Module
/* loaded from: classes2.dex */
public final class PaymentSettingModule {

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private final PaymentSettingContract.View BuiltInFictitiousFunctionClassFactory;

    public PaymentSettingModule(PaymentSettingContract.View view) {
        Intrinsics.checkNotNullParameter(view, "");
        this.BuiltInFictitiousFunctionClassFactory = view;
    }

    @Provides
    /* renamed from: PlaceComponentResult  reason: from getter */
    public final PaymentSettingContract.View getBuiltInFictitiousFunctionClassFactory() {
        return this.BuiltInFictitiousFunctionClassFactory;
    }

    @Provides
    public final PaymentSettingContract.Presenter MyBillsEntityDataFactory(PaymentSettingPresenter p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        return p0;
    }
}
