package id.dana.toggle;

import android.content.Context;
import dagger.internal.Factory;
import id.dana.data.toggle.SplitFacade;
import id.dana.domain.account.interactor.GetLatestTransaction;
import id.dana.domain.geocode.interactor.GetIndoSubdivisionsByLocation;
import id.dana.domain.user.interactor.GetUserInfo;
import id.dana.myprofile.UserInfoMapper;
import id.dana.toggle.locationpermission.LocationPermissionObserver;
import id.dana.toggle.userloginlogout.LoginLogoutObserver;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class SplitObservant_Factory implements Factory<SplitObservant> {
    private final Provider<Context> BuiltInFictitiousFunctionClassFactory;
    private final Provider<GetUserInfo> KClassImpl$Data$declaredNonStaticMembers$2;
    private final Provider<GetIndoSubdivisionsByLocation> MyBillsEntityDataFactory;
    private final Provider<GetLatestTransaction> PlaceComponentResult;
    private final Provider<LocationPermissionObserver> getAuthRequestContext;
    private final Provider<UserInfoMapper> getErrorConfigVersion;
    private final Provider<SplitFacade> lookAheadTest;
    private final Provider<LoginLogoutObserver> moveToNextValue;

    private SplitObservant_Factory(Provider<Context> provider, Provider<LocationPermissionObserver> provider2, Provider<LoginLogoutObserver> provider3, Provider<SplitFacade> provider4, Provider<GetIndoSubdivisionsByLocation> provider5, Provider<GetLatestTransaction> provider6, Provider<GetUserInfo> provider7, Provider<UserInfoMapper> provider8) {
        this.BuiltInFictitiousFunctionClassFactory = provider;
        this.getAuthRequestContext = provider2;
        this.moveToNextValue = provider3;
        this.lookAheadTest = provider4;
        this.MyBillsEntityDataFactory = provider5;
        this.PlaceComponentResult = provider6;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = provider7;
        this.getErrorConfigVersion = provider8;
    }

    public static SplitObservant_Factory MyBillsEntityDataFactory(Provider<Context> provider, Provider<LocationPermissionObserver> provider2, Provider<LoginLogoutObserver> provider3, Provider<SplitFacade> provider4, Provider<GetIndoSubdivisionsByLocation> provider5, Provider<GetLatestTransaction> provider6, Provider<GetUserInfo> provider7, Provider<UserInfoMapper> provider8) {
        return new SplitObservant_Factory(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new SplitObservant(this.BuiltInFictitiousFunctionClassFactory.get(), this.getAuthRequestContext.get(), this.moveToNextValue.get(), this.lookAheadTest.get(), this.MyBillsEntityDataFactory.get(), this.PlaceComponentResult.get(), this.KClassImpl$Data$declaredNonStaticMembers$2.get(), this.getErrorConfigVersion.get());
    }
}
