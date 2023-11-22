package id.dana.cardbinding.data.di;

import dagger.Module;
import dagger.Provides;
import id.dana.cardbinding.data.repository.source.network.CardBindingSecureApi;
import java.util.Objects;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.HttpUrl;
import retrofit2.Retrofit;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lid/dana/cardbinding/data/di/CardBindingApiModule;", "", "Lretrofit2/Retrofit$Builder;", "p0", "Lid/dana/cardbinding/data/repository/source/network/CardBindingSecureApi;", "getAuthRequestContext", "(Lretrofit2/Retrofit$Builder;)Lid/dana/cardbinding/data/repository/source/network/CardBindingSecureApi;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Module
/* loaded from: classes.dex */
public final class CardBindingApiModule {
    @Provides
    @Singleton
    public final CardBindingSecureApi getAuthRequestContext(Retrofit.Builder p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        Objects.requireNonNull("https://m.dana.id", "baseUrl == null");
        Object PlaceComponentResult = p0.BuiltInFictitiousFunctionClassFactory(HttpUrl.get("https://m.dana.id")).BuiltInFictitiousFunctionClassFactory().PlaceComponentResult(CardBindingSecureApi.class);
        Intrinsics.checkNotNullExpressionValue(PlaceComponentResult, "");
        return (CardBindingSecureApi) PlaceComponentResult;
    }
}
