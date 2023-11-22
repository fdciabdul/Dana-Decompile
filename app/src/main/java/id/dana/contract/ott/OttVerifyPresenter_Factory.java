package id.dana.contract.ott;

import android.content.Context;
import dagger.internal.Factory;
import id.dana.contract.ott.OttVerifyContract;
import id.dana.domain.account.interactor.GetPhoneNumber;
import id.dana.domain.ott.interactor.GetOttVerify;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class OttVerifyPresenter_Factory implements Factory<OttVerifyPresenter> {
    private final Provider<GetOttVerify> KClassImpl$Data$declaredNonStaticMembers$2;
    private final Provider<GetPhoneNumber> MyBillsEntityDataFactory;
    private final Provider<Context> PlaceComponentResult;
    private final Provider<OttVerifyContract.View> getAuthRequestContext;

    private OttVerifyPresenter_Factory(Provider<Context> provider, Provider<OttVerifyContract.View> provider2, Provider<GetOttVerify> provider3, Provider<GetPhoneNumber> provider4) {
        this.PlaceComponentResult = provider;
        this.getAuthRequestContext = provider2;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = provider3;
        this.MyBillsEntityDataFactory = provider4;
    }

    public static OttVerifyPresenter_Factory PlaceComponentResult(Provider<Context> provider, Provider<OttVerifyContract.View> provider2, Provider<GetOttVerify> provider3, Provider<GetPhoneNumber> provider4) {
        return new OttVerifyPresenter_Factory(provider, provider2, provider3, provider4);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new OttVerifyPresenter(this.PlaceComponentResult.get(), this.getAuthRequestContext.get(), this.KClassImpl$Data$declaredNonStaticMembers$2.get(), this.MyBillsEntityDataFactory.get());
    }
}
