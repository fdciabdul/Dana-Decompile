package id.dana.di.modules;

import android.content.Context;
import dagger.Module;
import dagger.Provides;
import id.dana.cashier.PayResultContract;
import id.dana.cashier.presenter.PayResultPresenter;
import id.dana.cashier.tracker.CashierAnalyticTracker;
import id.dana.cashier.tracker.CashierMixpanelTracker;
import id.dana.di.PerActivity;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0007¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H\u0007¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\b\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\nH\u0007¢\u0006\u0004\b\b\u0010\fR\u0014\u0010\b\u001a\u00020\u00078\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000e"}, d2 = {"Lid/dana/di/modules/PayResultModule;", "", "Landroid/content/Context;", "p0", "Lid/dana/cashier/tracker/CashierAnalyticTracker;", "BuiltInFictitiousFunctionClassFactory", "(Landroid/content/Context;)Lid/dana/cashier/tracker/CashierAnalyticTracker;", "Lid/dana/cashier/PayResultContract$View;", "getAuthRequestContext", "()Lid/dana/cashier/PayResultContract$View;", "Lid/dana/cashier/presenter/PayResultPresenter;", "Lid/dana/cashier/PayResultContract$Presenter;", "(Lid/dana/cashier/presenter/PayResultPresenter;)Lid/dana/cashier/PayResultContract$Presenter;", "MyBillsEntityDataFactory", "Lid/dana/cashier/PayResultContract$View;", "<init>", "(Lid/dana/cashier/PayResultContract$View;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Module
/* loaded from: classes2.dex */
public final class PayResultModule {

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private final PayResultContract.View getAuthRequestContext;

    public PayResultModule(PayResultContract.View view) {
        Intrinsics.checkNotNullParameter(view, "");
        this.getAuthRequestContext = view;
    }

    @Provides
    @PerActivity
    /* renamed from: getAuthRequestContext  reason: from getter */
    public final PayResultContract.View getGetAuthRequestContext() {
        return this.getAuthRequestContext;
    }

    @Provides
    @PerActivity
    public final PayResultContract.Presenter getAuthRequestContext(PayResultPresenter p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        return p0;
    }

    @Provides
    public final CashierAnalyticTracker BuiltInFictitiousFunctionClassFactory(Context p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        return new CashierMixpanelTracker(p0);
    }
}
