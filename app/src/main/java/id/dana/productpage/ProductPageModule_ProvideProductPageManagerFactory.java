package id.dana.productpage;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.lib.bio.productpage.ProductPageManager;

/* loaded from: classes2.dex */
public final class ProductPageModule_ProvideProductPageManagerFactory implements Factory<ProductPageManager> {
    private final ProductPageModule getAuthRequestContext;

    private ProductPageModule_ProvideProductPageManagerFactory(ProductPageModule productPageModule) {
        this.getAuthRequestContext = productPageModule;
    }

    public static ProductPageModule_ProvideProductPageManagerFactory KClassImpl$Data$declaredNonStaticMembers$2(ProductPageModule productPageModule) {
        return new ProductPageModule_ProvideProductPageManagerFactory(productPageModule);
    }

    public static ProductPageManager MyBillsEntityDataFactory(ProductPageModule productPageModule) {
        return (ProductPageManager) Preconditions.BuiltInFictitiousFunctionClassFactory(productPageModule.MyBillsEntityDataFactory());
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (ProductPageManager) Preconditions.BuiltInFictitiousFunctionClassFactory(this.getAuthRequestContext.MyBillsEntityDataFactory());
    }
}
