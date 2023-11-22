package id.dana.userconfig;

import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import id.dana.domain.recentrecipient.interactor.MigrateRecentRecipientConfigToRoom;
import id.dana.domain.user.interactor.GetUserPan;
import id.dana.userconfig.UserConfigContract;
import javax.inject.Provider;

/* loaded from: classes5.dex */
public final class UserConfigPresenter_Factory implements Factory<UserConfigPresenter> {
    private final Provider<MigrateRecentRecipientConfigToRoom> BuiltInFictitiousFunctionClassFactory;
    private final Provider<GetUserPan> KClassImpl$Data$declaredNonStaticMembers$2;
    private final Provider<UserConfigContract.View> getAuthRequestContext;

    private UserConfigPresenter_Factory(Provider<MigrateRecentRecipientConfigToRoom> provider, Provider<GetUserPan> provider2, Provider<UserConfigContract.View> provider3) {
        this.BuiltInFictitiousFunctionClassFactory = provider;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = provider2;
        this.getAuthRequestContext = provider3;
    }

    public static UserConfigPresenter_Factory getAuthRequestContext(Provider<MigrateRecentRecipientConfigToRoom> provider, Provider<GetUserPan> provider2, Provider<UserConfigContract.View> provider3) {
        return new UserConfigPresenter_Factory(provider, provider2, provider3);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new UserConfigPresenter(DoubleCheck.MyBillsEntityDataFactory(this.BuiltInFictitiousFunctionClassFactory), DoubleCheck.MyBillsEntityDataFactory(this.KClassImpl$Data$declaredNonStaticMembers$2), DoubleCheck.MyBillsEntityDataFactory(this.getAuthRequestContext));
    }
}
