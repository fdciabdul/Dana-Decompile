package id.dana.sendmoney_v2.landing.di.module;

import dagger.Module;
import dagger.Provides;
import id.dana.di.PerActivity;
import id.dana.sendmoney_v2.landing.contract.ManageAccountContract;
import id.dana.sendmoney_v2.landing.contract.ManageAccountPresenter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0007¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H\u0007¢\u0006\u0004\b\b\u0010\tR\u0014\u0010\f\u001a\u00020\u00078\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000b"}, d2 = {"Lid/dana/sendmoney_v2/landing/di/module/ManageAccountModule;", "", "Lid/dana/sendmoney_v2/landing/contract/ManageAccountPresenter;", "p0", "Lid/dana/sendmoney_v2/landing/contract/ManageAccountContract$Presenter;", "PlaceComponentResult", "(Lid/dana/sendmoney_v2/landing/contract/ManageAccountPresenter;)Lid/dana/sendmoney_v2/landing/contract/ManageAccountContract$Presenter;", "Lid/dana/sendmoney_v2/landing/contract/ManageAccountContract$View;", "getAuthRequestContext", "()Lid/dana/sendmoney_v2/landing/contract/ManageAccountContract$View;", "MyBillsEntityDataFactory", "Lid/dana/sendmoney_v2/landing/contract/ManageAccountContract$View;", "KClassImpl$Data$declaredNonStaticMembers$2", "<init>", "(Lid/dana/sendmoney_v2/landing/contract/ManageAccountContract$View;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Module
/* loaded from: classes5.dex */
public final class ManageAccountModule {

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private final ManageAccountContract.View KClassImpl$Data$declaredNonStaticMembers$2;

    public ManageAccountModule(ManageAccountContract.View view) {
        Intrinsics.checkNotNullParameter(view, "");
        this.KClassImpl$Data$declaredNonStaticMembers$2 = view;
    }

    @Provides
    @PerActivity
    /* renamed from: getAuthRequestContext  reason: from getter */
    public final ManageAccountContract.View getKClassImpl$Data$declaredNonStaticMembers$2() {
        return this.KClassImpl$Data$declaredNonStaticMembers$2;
    }

    @Provides
    @PerActivity
    public final ManageAccountContract.Presenter PlaceComponentResult(ManageAccountPresenter p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        return p0;
    }
}
