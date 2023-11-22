package id.dana.sendmoney_v2.landing.di.module;

import dagger.Module;
import dagger.Provides;
import id.dana.di.PerActivity;
import id.dana.sendmoney_v2.landing.contract.KycAndDebitPayOptionContract;
import id.dana.sendmoney_v2.landing.contract.SendMoneyHomePresenter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0007¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0005\u001a\u00020\u0007H\u0007¢\u0006\u0004\b\u0005\u0010\bR\u0014\u0010\u000b\u001a\u00020\u00078\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b\t\u0010\n"}, d2 = {"Lid/dana/sendmoney_v2/landing/di/module/SendMoneyLandingModule;", "", "Lid/dana/sendmoney_v2/landing/contract/SendMoneyHomePresenter;", "p0", "Lid/dana/sendmoney_v2/landing/contract/KycAndDebitPayOptionContract$Presenter;", "PlaceComponentResult", "(Lid/dana/sendmoney_v2/landing/contract/SendMoneyHomePresenter;)Lid/dana/sendmoney_v2/landing/contract/KycAndDebitPayOptionContract$Presenter;", "Lid/dana/sendmoney_v2/landing/contract/KycAndDebitPayOptionContract$View;", "()Lid/dana/sendmoney_v2/landing/contract/KycAndDebitPayOptionContract$View;", "KClassImpl$Data$declaredNonStaticMembers$2", "Lid/dana/sendmoney_v2/landing/contract/KycAndDebitPayOptionContract$View;", "MyBillsEntityDataFactory", "<init>", "(Lid/dana/sendmoney_v2/landing/contract/KycAndDebitPayOptionContract$View;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Module
/* loaded from: classes5.dex */
public final class SendMoneyLandingModule {

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    private final KycAndDebitPayOptionContract.View MyBillsEntityDataFactory;

    public SendMoneyLandingModule(KycAndDebitPayOptionContract.View view) {
        Intrinsics.checkNotNullParameter(view, "");
        this.MyBillsEntityDataFactory = view;
    }

    @Provides
    @PerActivity
    /* renamed from: PlaceComponentResult  reason: from getter */
    public final KycAndDebitPayOptionContract.View getMyBillsEntityDataFactory() {
        return this.MyBillsEntityDataFactory;
    }

    @Provides
    @PerActivity
    public final KycAndDebitPayOptionContract.Presenter PlaceComponentResult(SendMoneyHomePresenter p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        return p0;
    }
}
