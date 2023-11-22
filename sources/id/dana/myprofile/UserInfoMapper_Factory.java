package id.dana.myprofile;

import dagger.internal.Factory;
import id.dana.sendmoney.mapper.CurrencyAmountModelMapper;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class UserInfoMapper_Factory implements Factory<UserInfoMapper> {
    private final Provider<CurrencyAmountModelMapper> PlaceComponentResult;

    private UserInfoMapper_Factory(Provider<CurrencyAmountModelMapper> provider) {
        this.PlaceComponentResult = provider;
    }

    public static UserInfoMapper_Factory PlaceComponentResult(Provider<CurrencyAmountModelMapper> provider) {
        return new UserInfoMapper_Factory(provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new UserInfoMapper(this.PlaceComponentResult.get());
    }
}
