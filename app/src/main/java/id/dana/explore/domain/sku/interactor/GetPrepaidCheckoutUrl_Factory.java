package id.dana.explore.domain.sku.interactor;

import dagger.internal.Factory;
import id.dana.domain.PostExecutionThread;
import id.dana.explore.domain.sku.ProductInfoRepository;
import id.dana.utils.concurrent.ThreadExecutor;
import javax.inject.Provider;

/* loaded from: classes5.dex */
public final class GetPrepaidCheckoutUrl_Factory implements Factory<GetPrepaidCheckoutUrl> {
    private final Provider<ThreadExecutor> BuiltInFictitiousFunctionClassFactory;
    private final Provider<PostExecutionThread> MyBillsEntityDataFactory;
    private final Provider<ProductInfoRepository> getAuthRequestContext;

    private GetPrepaidCheckoutUrl_Factory(Provider<ThreadExecutor> provider, Provider<PostExecutionThread> provider2, Provider<ProductInfoRepository> provider3) {
        this.BuiltInFictitiousFunctionClassFactory = provider;
        this.MyBillsEntityDataFactory = provider2;
        this.getAuthRequestContext = provider3;
    }

    public static GetPrepaidCheckoutUrl_Factory KClassImpl$Data$declaredNonStaticMembers$2(Provider<ThreadExecutor> provider, Provider<PostExecutionThread> provider2, Provider<ProductInfoRepository> provider3) {
        return new GetPrepaidCheckoutUrl_Factory(provider, provider2, provider3);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new GetPrepaidCheckoutUrl(this.BuiltInFictitiousFunctionClassFactory.get(), this.MyBillsEntityDataFactory.get(), this.getAuthRequestContext.get());
    }
}
