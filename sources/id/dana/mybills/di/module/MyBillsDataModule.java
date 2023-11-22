package id.dana.mybills.di.module;

import dagger.Module;
import dagger.Provides;
import id.dana.mybills.data.repository.source.network.MyBillsRestFacade;
import id.dana.mybills.di.scope.MyBillsScope;
import java.util.Objects;
import javax.inject.Named;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.HttpUrl;
import retrofit2.Retrofit;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0007\u0010\bJ\u0019\u0010\u0005\u001a\u00020\u00042\b\b\u0001\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lid/dana/mybills/di/module/MyBillsDataModule;", "", "Lretrofit2/Retrofit$Builder;", "p0", "Lid/dana/mybills/data/repository/source/network/MyBillsRestFacade;", "getAuthRequestContext", "(Lretrofit2/Retrofit$Builder;)Lid/dana/mybills/data/repository/source/network/MyBillsRestFacade;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Module
/* loaded from: classes5.dex */
public final class MyBillsDataModule {
    @Provides
    @MyBillsScope
    public final MyBillsRestFacade getAuthRequestContext(@Named("SECURED_RETROFIT") Retrofit.Builder p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        Objects.requireNonNull("https://m.dana.id", "baseUrl == null");
        Object PlaceComponentResult = p0.BuiltInFictitiousFunctionClassFactory(HttpUrl.get("https://m.dana.id")).BuiltInFictitiousFunctionClassFactory().PlaceComponentResult(MyBillsRestFacade.class);
        Intrinsics.checkNotNullExpressionValue(PlaceComponentResult, "");
        return (MyBillsRestFacade) PlaceComponentResult;
    }
}
