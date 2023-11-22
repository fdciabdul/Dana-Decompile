package id.dana.cashier.data.di;

import dagger.Module;
import dagger.Provides;
import id.dana.cashier.data.repository.source.network.CashierSecureApi;
import java.util.Objects;
import javax.inject.Named;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.HttpUrl;
import retrofit2.Retrofit;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\b\u0010\tJ\u0019\u0010\u0005\u001a\u00020\u00042\b\b\u0001\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\u0019\u0010\u0007\u001a\u00020\u00042\b\b\u0001\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0007\u0010\u0006"}, d2 = {"Lid/dana/cashier/data/di/CashierApiModule;", "", "Lretrofit2/Retrofit$Builder;", "builder", "Lid/dana/cashier/data/repository/source/network/CashierSecureApi;", "provideCashierApi", "(Lretrofit2/Retrofit$Builder;)Lid/dana/cashier/data/repository/source/network/CashierSecureApi;", "provideSecureCashierApi", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Module
/* loaded from: classes.dex */
public final class CashierApiModule {
    @Provides
    @Singleton
    @Named("SECURED_CASHIER_API")
    public final CashierSecureApi provideSecureCashierApi(@Named("SECURED_CASHIER_RETROFIT") Retrofit.Builder builder) {
        Intrinsics.checkNotNullParameter(builder, "");
        Intrinsics.areEqual("production", "production");
        Objects.requireNonNull("https://m.dana.id", "baseUrl == null");
        Object PlaceComponentResult = builder.BuiltInFictitiousFunctionClassFactory(HttpUrl.get("https://m.dana.id")).BuiltInFictitiousFunctionClassFactory().PlaceComponentResult(CashierSecureApi.class);
        Intrinsics.checkNotNullExpressionValue(PlaceComponentResult, "");
        return (CashierSecureApi) PlaceComponentResult;
    }

    @Provides
    @Singleton
    @Named("CASHIER_API")
    public final CashierSecureApi provideCashierApi(@Named("CASHIER_RETROFIT") Retrofit.Builder builder) {
        Intrinsics.checkNotNullParameter(builder, "");
        Objects.requireNonNull("https://m.dana.id", "baseUrl == null");
        Object PlaceComponentResult = builder.BuiltInFictitiousFunctionClassFactory(HttpUrl.get("https://m.dana.id")).BuiltInFictitiousFunctionClassFactory().PlaceComponentResult(CashierSecureApi.class);
        Intrinsics.checkNotNullExpressionValue(PlaceComponentResult, "");
        return (CashierSecureApi) PlaceComponentResult;
    }
}
