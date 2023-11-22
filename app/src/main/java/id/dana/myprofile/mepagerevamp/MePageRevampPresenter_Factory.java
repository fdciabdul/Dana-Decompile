package id.dana.myprofile.mepagerevamp;

import android.content.Context;
import dagger.internal.Factory;
import id.dana.domain.account.interactor.GetAvatarUrl;
import id.dana.domain.profilemenu.interactor.GetSettingCollection;
import id.dana.myprofile.mepagerevamp.MePageRevampContract;
import id.dana.myprofile.settingconfig.FeedSharingConfigRunner;
import id.dana.myprofile.settingconfig.NicknameChangeConfigRunner;
import id.dana.myprofile.settingconfig.RestrictedContactConfigRunner;
import id.dana.myprofile.settingconfig.ShareFeedSettingConfigRunner;
import id.dana.myprofile.settingconfig.UsernameChangeConfigRunner;
import javax.inject.Provider;

/* loaded from: classes5.dex */
public final class MePageRevampPresenter_Factory implements Factory<MePageRevampPresenter> {
    private final Provider<GetAvatarUrl> BuiltInFictitiousFunctionClassFactory;
    private final Provider<GetSettingCollection> KClassImpl$Data$declaredNonStaticMembers$2;
    private final Provider<Context> MyBillsEntityDataFactory;
    private final Provider<UsernameChangeConfigRunner> NetworkUserEntityData$$ExternalSyntheticLambda0;
    private final Provider<FeedSharingConfigRunner> PlaceComponentResult;
    private final Provider<NicknameChangeConfigRunner> getAuthRequestContext;
    private final Provider<ShareFeedSettingConfigRunner> getErrorConfigVersion;
    private final Provider<RestrictedContactConfigRunner> moveToNextValue;
    private final Provider<MePageRevampContract.View> scheduleImpl;

    private MePageRevampPresenter_Factory(Provider<Context> provider, Provider<MePageRevampContract.View> provider2, Provider<GetSettingCollection> provider3, Provider<GetAvatarUrl> provider4, Provider<FeedSharingConfigRunner> provider5, Provider<ShareFeedSettingConfigRunner> provider6, Provider<RestrictedContactConfigRunner> provider7, Provider<NicknameChangeConfigRunner> provider8, Provider<UsernameChangeConfigRunner> provider9) {
        this.MyBillsEntityDataFactory = provider;
        this.scheduleImpl = provider2;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = provider3;
        this.BuiltInFictitiousFunctionClassFactory = provider4;
        this.PlaceComponentResult = provider5;
        this.getErrorConfigVersion = provider6;
        this.moveToNextValue = provider7;
        this.getAuthRequestContext = provider8;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = provider9;
    }

    public static MePageRevampPresenter_Factory MyBillsEntityDataFactory(Provider<Context> provider, Provider<MePageRevampContract.View> provider2, Provider<GetSettingCollection> provider3, Provider<GetAvatarUrl> provider4, Provider<FeedSharingConfigRunner> provider5, Provider<ShareFeedSettingConfigRunner> provider6, Provider<RestrictedContactConfigRunner> provider7, Provider<NicknameChangeConfigRunner> provider8, Provider<UsernameChangeConfigRunner> provider9) {
        return new MePageRevampPresenter_Factory(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8, provider9);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new MePageRevampPresenter(this.MyBillsEntityDataFactory.get(), this.scheduleImpl.get(), this.KClassImpl$Data$declaredNonStaticMembers$2.get(), this.BuiltInFictitiousFunctionClassFactory.get(), this.PlaceComponentResult.get(), this.getErrorConfigVersion.get(), this.moveToNextValue.get(), this.getAuthRequestContext.get(), this.NetworkUserEntityData$$ExternalSyntheticLambda0.get());
    }
}
