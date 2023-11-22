package id.dana.myprofile.settingconfig;

import android.content.Context;
import dagger.internal.Factory;
import id.dana.domain.user.repository.UserRepository;
import id.dana.myprofile.UserInfoMapper;
import javax.inject.Provider;

/* loaded from: classes5.dex */
public final class KybSettingConfigRunner_Factory implements Factory<KybSettingConfigRunner> {
    private final Provider<UserInfoMapper> KClassImpl$Data$declaredNonStaticMembers$2;
    private final Provider<Context> PlaceComponentResult;
    private final Provider<UserRepository> getAuthRequestContext;

    private KybSettingConfigRunner_Factory(Provider<UserRepository> provider, Provider<Context> provider2, Provider<UserInfoMapper> provider3) {
        this.getAuthRequestContext = provider;
        this.PlaceComponentResult = provider2;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = provider3;
    }

    public static KybSettingConfigRunner_Factory getAuthRequestContext(Provider<UserRepository> provider, Provider<Context> provider2, Provider<UserInfoMapper> provider3) {
        return new KybSettingConfigRunner_Factory(provider, provider2, provider3);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new KybSettingConfigRunner(this.getAuthRequestContext.get(), this.PlaceComponentResult.get(), this.KClassImpl$Data$declaredNonStaticMembers$2.get());
    }
}
