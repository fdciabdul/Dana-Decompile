package id.dana.di.modules;

import dagger.Module;
import dagger.Provides;
import id.dana.di.PerActivity;
import id.dana.nearbyme.merchantdetail.viewcomponent.MerchantAverageRatingContract;
import id.dana.nearbyme.merchantdetail.viewcomponent.MerchantAverageRatingPresenter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0007¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H\u0007¢\u0006\u0004\b\b\u0010\tR\u0014\u0010\f\u001a\u00020\u00078\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000b"}, d2 = {"Lid/dana/di/modules/MerchantAverageRatingModule;", "", "Lid/dana/nearbyme/merchantdetail/viewcomponent/MerchantAverageRatingPresenter;", "p0", "Lid/dana/nearbyme/merchantdetail/viewcomponent/MerchantAverageRatingContract$Presenter;", "getAuthRequestContext", "(Lid/dana/nearbyme/merchantdetail/viewcomponent/MerchantAverageRatingPresenter;)Lid/dana/nearbyme/merchantdetail/viewcomponent/MerchantAverageRatingContract$Presenter;", "Lid/dana/nearbyme/merchantdetail/viewcomponent/MerchantAverageRatingContract$View;", "BuiltInFictitiousFunctionClassFactory", "()Lid/dana/nearbyme/merchantdetail/viewcomponent/MerchantAverageRatingContract$View;", "KClassImpl$Data$declaredNonStaticMembers$2", "Lid/dana/nearbyme/merchantdetail/viewcomponent/MerchantAverageRatingContract$View;", "MyBillsEntityDataFactory", "<init>", "(Lid/dana/nearbyme/merchantdetail/viewcomponent/MerchantAverageRatingContract$View;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Module
/* loaded from: classes4.dex */
public final class MerchantAverageRatingModule {

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    private final MerchantAverageRatingContract.View MyBillsEntityDataFactory;

    public MerchantAverageRatingModule(MerchantAverageRatingContract.View view) {
        Intrinsics.checkNotNullParameter(view, "");
        this.MyBillsEntityDataFactory = view;
    }

    @Provides
    @PerActivity
    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from getter */
    public final MerchantAverageRatingContract.View getMyBillsEntityDataFactory() {
        return this.MyBillsEntityDataFactory;
    }

    @Provides
    @PerActivity
    public final MerchantAverageRatingContract.Presenter getAuthRequestContext(MerchantAverageRatingPresenter p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        return p0;
    }
}
