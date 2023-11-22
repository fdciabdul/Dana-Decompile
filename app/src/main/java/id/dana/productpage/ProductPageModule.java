package id.dana.productpage;

import dagger.Module;
import dagger.Provides;
import id.dana.lib.bio.productpage.DefaultProductPageManager;
import id.dana.lib.bio.productpage.ProductPageManager;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lid/dana/productpage/ProductPageModule;", "", "Lid/dana/lib/bio/productpage/ProductPageManager;", "MyBillsEntityDataFactory", "()Lid/dana/lib/bio/productpage/ProductPageManager;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Module
/* loaded from: classes.dex */
public final class ProductPageModule {
    @Provides
    public final ProductPageManager MyBillsEntityDataFactory() {
        DefaultProductPageManager.Companion companion = DefaultProductPageManager.INSTANCE;
        return DefaultProductPageManager.Companion.KClassImpl$Data$declaredNonStaticMembers$2();
    }
}
