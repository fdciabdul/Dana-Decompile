package id.dana.di.modules;

import dagger.Module;
import dagger.Provides;
import id.dana.nearbyme.merchantdetail.viewcomponent.MerchantDanaDealsContract;
import id.dana.nearbyme.merchantdetail.viewcomponent.MerchantDanaDealsPresenter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0007¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H\u0007¢\u0006\u0004\b\b\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0007X\u0007¢\u0006\u0006\n\u0004\b\n\u0010\u000b"}, d2 = {"Lid/dana/di/modules/MerchantDanaDealsModule;", "", "Lid/dana/nearbyme/merchantdetail/viewcomponent/MerchantDanaDealsPresenter;", "p0", "Lid/dana/nearbyme/merchantdetail/viewcomponent/MerchantDanaDealsContract$Presenter;", "PlaceComponentResult", "(Lid/dana/nearbyme/merchantdetail/viewcomponent/MerchantDanaDealsPresenter;)Lid/dana/nearbyme/merchantdetail/viewcomponent/MerchantDanaDealsContract$Presenter;", "Lid/dana/nearbyme/merchantdetail/viewcomponent/MerchantDanaDealsContract$View;", "MyBillsEntityDataFactory", "()Lid/dana/nearbyme/merchantdetail/viewcomponent/MerchantDanaDealsContract$View;", "KClassImpl$Data$declaredNonStaticMembers$2", "Lid/dana/nearbyme/merchantdetail/viewcomponent/MerchantDanaDealsContract$View;", "<init>", "(Lid/dana/nearbyme/merchantdetail/viewcomponent/MerchantDanaDealsContract$View;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Module
/* loaded from: classes4.dex */
public final class MerchantDanaDealsModule {

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    public final MerchantDanaDealsContract.View PlaceComponentResult;

    public MerchantDanaDealsModule(MerchantDanaDealsContract.View view) {
        Intrinsics.checkNotNullParameter(view, "");
        this.PlaceComponentResult = view;
    }

    @Provides
    public final MerchantDanaDealsContract.Presenter PlaceComponentResult(MerchantDanaDealsPresenter p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        return p0;
    }

    @Provides
    /* renamed from: MyBillsEntityDataFactory  reason: from getter */
    public final MerchantDanaDealsContract.View getPlaceComponentResult() {
        return this.PlaceComponentResult;
    }
}
