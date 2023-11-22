package id.dana.ipg;

import dagger.internal.Factory;
import id.dana.domain.ipg.interactor.GetIpgClickedAgree;
import id.dana.domain.ipg.interactor.GetIpgRegistrationUrl;
import id.dana.domain.ipg.interactor.SaveIpgClickedAgree;
import id.dana.ipg.IpgGuideContract;
import javax.inject.Provider;

/* loaded from: classes8.dex */
public final class IpgGuidePresenter_Factory implements Factory<IpgGuidePresenter> {
    private final Provider<IpgGuideContract.View> BuiltInFictitiousFunctionClassFactory;
    private final Provider<GetIpgRegistrationUrl> KClassImpl$Data$declaredNonStaticMembers$2;
    private final Provider<GetIpgClickedAgree> MyBillsEntityDataFactory;
    private final Provider<SaveIpgClickedAgree> getAuthRequestContext;

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new IpgGuidePresenter(this.BuiltInFictitiousFunctionClassFactory.get(), this.MyBillsEntityDataFactory.get(), this.getAuthRequestContext.get(), this.KClassImpl$Data$declaredNonStaticMembers$2.get());
    }
}
