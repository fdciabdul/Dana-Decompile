package id.dana.expresspurchase.di;

import dagger.Module;
import dagger.Provides;
import id.dana.di.PerActivity;
import id.dana.expresspurchase.presenter.ExpressPurchaseContract;
import id.dana.expresspurchase.presenter.ExpressPurchasePresenter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0007¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H\u0007¢\u0006\u0004\b\b\u0010\tR\u0014\u0010\u0005\u001a\u00020\u00078\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b\b\u0010\n"}, d2 = {"Lid/dana/expresspurchase/di/ExpressPurchaseModule;", "", "Lid/dana/expresspurchase/presenter/ExpressPurchasePresenter;", "p0", "Lid/dana/expresspurchase/presenter/ExpressPurchaseContract$Presenter;", "KClassImpl$Data$declaredNonStaticMembers$2", "(Lid/dana/expresspurchase/presenter/ExpressPurchasePresenter;)Lid/dana/expresspurchase/presenter/ExpressPurchaseContract$Presenter;", "Lid/dana/expresspurchase/presenter/ExpressPurchaseContract$View;", "PlaceComponentResult", "()Lid/dana/expresspurchase/presenter/ExpressPurchaseContract$View;", "Lid/dana/expresspurchase/presenter/ExpressPurchaseContract$View;", "<init>", "(Lid/dana/expresspurchase/presenter/ExpressPurchaseContract$View;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Module
/* loaded from: classes2.dex */
public final class ExpressPurchaseModule {

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private final ExpressPurchaseContract.View KClassImpl$Data$declaredNonStaticMembers$2;

    public ExpressPurchaseModule(ExpressPurchaseContract.View view) {
        Intrinsics.checkNotNullParameter(view, "");
        this.KClassImpl$Data$declaredNonStaticMembers$2 = view;
    }

    @Provides
    @PerActivity
    /* renamed from: PlaceComponentResult  reason: from getter */
    public final ExpressPurchaseContract.View getKClassImpl$Data$declaredNonStaticMembers$2() {
        return this.KClassImpl$Data$declaredNonStaticMembers$2;
    }

    @Provides
    @PerActivity
    public final ExpressPurchaseContract.Presenter KClassImpl$Data$declaredNonStaticMembers$2(ExpressPurchasePresenter p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        return p0;
    }
}
