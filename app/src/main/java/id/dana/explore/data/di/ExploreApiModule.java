package id.dana.explore.data.di;

import dagger.Module;
import dagger.Provides;
import id.dana.data.constant.DanaUrl;
import id.dana.explore.data.sku.repository.source.network.ExploreDanaApi;
import id.dana.explore.data.sku.repository.source.network.ProductInfoFacade;
import java.util.Objects;
import javax.inject.Named;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.HttpUrl;
import retrofit2.Retrofit;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\u0019\u0010\b\u001a\u00020\u00072\b\b\u0001\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\b\u0010\t"}, d2 = {"Lid/dana/explore/data/di/ExploreApiModule;", "", "Lretrofit2/Retrofit$Builder;", "p0", "Lid/dana/explore/data/sku/repository/source/network/ExploreDanaApi;", "MyBillsEntityDataFactory", "(Lretrofit2/Retrofit$Builder;)Lid/dana/explore/data/sku/repository/source/network/ExploreDanaApi;", "Lid/dana/explore/data/sku/repository/source/network/ProductInfoFacade;", "KClassImpl$Data$declaredNonStaticMembers$2", "(Lretrofit2/Retrofit$Builder;)Lid/dana/explore/data/sku/repository/source/network/ProductInfoFacade;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Module
/* loaded from: classes.dex */
public final class ExploreApiModule {
    @Provides
    @Singleton
    public final ExploreDanaApi MyBillsEntityDataFactory(Retrofit.Builder p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        Objects.requireNonNull(DanaUrl.BASE_URL_JSON_RESOURCES, "baseUrl == null");
        Object PlaceComponentResult = p0.BuiltInFictitiousFunctionClassFactory(HttpUrl.get(DanaUrl.BASE_URL_JSON_RESOURCES)).BuiltInFictitiousFunctionClassFactory().PlaceComponentResult(ExploreDanaApi.class);
        Intrinsics.checkNotNullExpressionValue(PlaceComponentResult, "");
        return (ExploreDanaApi) PlaceComponentResult;
    }

    @Provides
    @Singleton
    public final ProductInfoFacade KClassImpl$Data$declaredNonStaticMembers$2(@Named("SECURED_RETROFIT") Retrofit.Builder p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        Objects.requireNonNull("https://m.dana.id", "baseUrl == null");
        Object PlaceComponentResult = p0.BuiltInFictitiousFunctionClassFactory(HttpUrl.get("https://m.dana.id")).BuiltInFictitiousFunctionClassFactory().PlaceComponentResult(ProductInfoFacade.class);
        Intrinsics.checkNotNullExpressionValue(PlaceComponentResult, "");
        return (ProductInfoFacade) PlaceComponentResult;
    }
}
