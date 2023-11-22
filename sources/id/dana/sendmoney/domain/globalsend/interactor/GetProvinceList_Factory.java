package id.dana.sendmoney.domain.globalsend.interactor;

import dagger.internal.Factory;
import id.dana.sendmoney.domain.globalsend.GlobalSendRepository;
import javax.inject.Provider;

/* loaded from: classes5.dex */
public final class GetProvinceList_Factory implements Factory<GetProvinceList> {
    private final Provider<GlobalSendRepository> KClassImpl$Data$declaredNonStaticMembers$2;

    private GetProvinceList_Factory(Provider<GlobalSendRepository> provider) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = provider;
    }

    public static GetProvinceList_Factory getAuthRequestContext(Provider<GlobalSendRepository> provider) {
        return new GetProvinceList_Factory(provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new GetProvinceList(this.KClassImpl$Data$declaredNonStaticMembers$2.get());
    }
}
