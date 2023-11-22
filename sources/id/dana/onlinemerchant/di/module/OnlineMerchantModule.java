package id.dana.onlinemerchant.di.module;

import dagger.Module;
import dagger.Provides;
import id.dana.contract.onlinemerchant.OnlineMerchantContract;
import id.dana.contract.onlinemerchant.OnlineMerchantPresenter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0007¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0001¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H\u0001¢\u0006\u0004\b\b\u0010\tR\u0014\u0010\b\u001a\u00020\u00078\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b\b\u0010\n"}, d2 = {"Lid/dana/onlinemerchant/di/module/OnlineMerchantModule;", "", "Lid/dana/contract/onlinemerchant/OnlineMerchantPresenter;", "p0", "Lid/dana/contract/onlinemerchant/OnlineMerchantContract$Presenter;", "KClassImpl$Data$declaredNonStaticMembers$2", "(Lid/dana/contract/onlinemerchant/OnlineMerchantPresenter;)Lid/dana/contract/onlinemerchant/OnlineMerchantContract$Presenter;", "Lid/dana/contract/onlinemerchant/OnlineMerchantContract$View;", "PlaceComponentResult", "()Lid/dana/contract/onlinemerchant/OnlineMerchantContract$View;", "Lid/dana/contract/onlinemerchant/OnlineMerchantContract$View;", "<init>", "(Lid/dana/contract/onlinemerchant/OnlineMerchantContract$View;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Module
/* loaded from: classes5.dex */
public final class OnlineMerchantModule {
    private final OnlineMerchantContract.View PlaceComponentResult;

    public OnlineMerchantModule(OnlineMerchantContract.View view) {
        Intrinsics.checkNotNullParameter(view, "");
        this.PlaceComponentResult = view;
    }

    @Provides
    /* renamed from: PlaceComponentResult  reason: from getter */
    public final OnlineMerchantContract.View getPlaceComponentResult() {
        return this.PlaceComponentResult;
    }

    @Provides
    public final OnlineMerchantContract.Presenter KClassImpl$Data$declaredNonStaticMembers$2(OnlineMerchantPresenter p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        return p0;
    }
}
