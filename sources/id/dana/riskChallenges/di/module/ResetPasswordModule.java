package id.dana.riskChallenges.di.module;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import id.dana.riskChallenges.data.forgetpassword.ResetPasswordEntityRepository;
import id.dana.riskChallenges.data.forgetpassword.source.network.ResetPasswordApi;
import id.dana.riskChallenges.di.RiskChallengesScope;
import id.dana.riskChallenges.domain.forgetpassword.ResetPasswordRepository;
import java.util.Objects;
import javax.inject.Named;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.HttpUrl;
import retrofit2.Retrofit;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001:\u0001\tB\u0007¢\u0006\u0004\b\u0007\u0010\bJ\u0019\u0010\u0005\u001a\u00020\u00042\b\b\u0001\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lid/dana/riskChallenges/di/module/ResetPasswordModule;", "", "Lretrofit2/Retrofit$Builder;", "p0", "Lid/dana/riskChallenges/data/forgetpassword/source/network/ResetPasswordApi;", "KClassImpl$Data$declaredNonStaticMembers$2", "(Lretrofit2/Retrofit$Builder;)Lid/dana/riskChallenges/data/forgetpassword/source/network/ResetPasswordApi;", "<init>", "()V", "BindsModule"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Module(includes = {BindsModule.class})
/* loaded from: classes5.dex */
public final class ResetPasswordModule {

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0005\u0010\u0006ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/riskChallenges/di/module/ResetPasswordModule$BindsModule;", "", "Lid/dana/riskChallenges/data/forgetpassword/ResetPasswordEntityRepository;", "p0", "Lid/dana/riskChallenges/domain/forgetpassword/ResetPasswordRepository;", "getAuthRequestContext", "(Lid/dana/riskChallenges/data/forgetpassword/ResetPasswordEntityRepository;)Lid/dana/riskChallenges/domain/forgetpassword/ResetPasswordRepository;"}, k = 1, mv = {1, 6, 0}, xi = 48)
    @Module
    /* loaded from: classes9.dex */
    public interface BindsModule {
        @RiskChallengesScope
        @Binds
        ResetPasswordRepository getAuthRequestContext(ResetPasswordEntityRepository p0);
    }

    @Provides
    @RiskChallengesScope
    @Named("RESET_PASSWORD_API")
    public final ResetPasswordApi KClassImpl$Data$declaredNonStaticMembers$2(@Named("RESET_PASSWORD_RETROFIT") Retrofit.Builder p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        Objects.requireNonNull("https://m.dana.id", "baseUrl == null");
        Object PlaceComponentResult = p0.BuiltInFictitiousFunctionClassFactory(HttpUrl.get("https://m.dana.id")).BuiltInFictitiousFunctionClassFactory().PlaceComponentResult(ResetPasswordApi.class);
        Intrinsics.checkNotNullExpressionValue(PlaceComponentResult, "");
        return (ResetPasswordApi) PlaceComponentResult;
    }
}
