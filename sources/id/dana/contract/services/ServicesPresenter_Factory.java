package id.dana.contract.services;

import android.content.Context;
import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import id.dana.contract.services.ServicesContract;
import id.dana.domain.authcode.interactor.GetAuthCode;
import id.dana.domain.services.interactor.CheckFavoriteServicesFeature;
import id.dana.domain.services.interactor.GetDefaultServiceWithCategory;
import id.dana.domain.services.interactor.GetFavoriteServiceRemote;
import id.dana.domain.services.interactor.GetFavoriteServiceWithCacheFirst;
import id.dana.domain.services.interactor.GetFavoriteServices;
import id.dana.domain.services.interactor.GetRawServices;
import id.dana.domain.services.interactor.GetServiceHighlighted;
import id.dana.domain.services.interactor.GetServicesByKey;
import id.dana.domain.services.interactor.GetServicesByName;
import id.dana.domain.services.interactor.GetServicesWithCategory;
import id.dana.domain.services.interactor.UpdateServiceHighlighted;
import id.dana.domain.usereducation.interactor.IsNeedToShowToolTip;
import id.dana.domain.usereducation.interactor.SaveShowToolTip;
import id.dana.mapper.ThirdPartyServicesMapper;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class ServicesPresenter_Factory implements Factory<ServicesPresenter> {
    private final Provider<GetAuthCode> BuiltInFictitiousFunctionClassFactory;
    private final Provider<GetServicesWithCategory> DatabaseTableConfigUtil;
    private final Provider<ThirdPartyServicesMapper> GetContactSyncConfig;
    private final Provider<GetFavoriteServiceRemote> KClassImpl$Data$declaredNonStaticMembers$2;
    private final Provider<CheckFavoriteServicesFeature> MyBillsEntityDataFactory;
    private final Provider<GetFavoriteServiceWithCacheFirst> NetworkUserEntityData$$ExternalSyntheticLambda0;
    private final Provider<GetServicesByName> NetworkUserEntityData$$ExternalSyntheticLambda1;
    private final Provider<IsNeedToShowToolTip> NetworkUserEntityData$$ExternalSyntheticLambda2;
    private final Provider<ServicesContract.View> NetworkUserEntityData$$ExternalSyntheticLambda7;
    private final Provider<Context> PlaceComponentResult;
    private final Provider<GetDefaultServiceWithCategory> getAuthRequestContext;
    private final Provider<GetServiceHighlighted> getErrorConfigVersion;
    private final Provider<SaveShowToolTip> initRecordTimeStamp;
    private final Provider<UpdateServiceHighlighted> isLayoutRequested;
    private final Provider<GetRawServices> lookAheadTest;
    private final Provider<GetFavoriteServices> moveToNextValue;
    private final Provider<GetServicesByKey> scheduleImpl;

    private ServicesPresenter_Factory(Provider<Context> provider, Provider<ServicesContract.View> provider2, Provider<GetAuthCode> provider3, Provider<ThirdPartyServicesMapper> provider4, Provider<IsNeedToShowToolTip> provider5, Provider<SaveShowToolTip> provider6, Provider<GetServicesWithCategory> provider7, Provider<GetDefaultServiceWithCategory> provider8, Provider<GetFavoriteServiceRemote> provider9, Provider<GetServicesByName> provider10, Provider<GetServicesByKey> provider11, Provider<GetFavoriteServices> provider12, Provider<CheckFavoriteServicesFeature> provider13, Provider<GetRawServices> provider14, Provider<GetFavoriteServiceWithCacheFirst> provider15, Provider<GetServiceHighlighted> provider16, Provider<UpdateServiceHighlighted> provider17) {
        this.PlaceComponentResult = provider;
        this.NetworkUserEntityData$$ExternalSyntheticLambda7 = provider2;
        this.BuiltInFictitiousFunctionClassFactory = provider3;
        this.GetContactSyncConfig = provider4;
        this.NetworkUserEntityData$$ExternalSyntheticLambda2 = provider5;
        this.initRecordTimeStamp = provider6;
        this.DatabaseTableConfigUtil = provider7;
        this.getAuthRequestContext = provider8;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = provider9;
        this.NetworkUserEntityData$$ExternalSyntheticLambda1 = provider10;
        this.scheduleImpl = provider11;
        this.moveToNextValue = provider12;
        this.MyBillsEntityDataFactory = provider13;
        this.lookAheadTest = provider14;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = provider15;
        this.getErrorConfigVersion = provider16;
        this.isLayoutRequested = provider17;
    }

    public static ServicesPresenter_Factory PlaceComponentResult(Provider<Context> provider, Provider<ServicesContract.View> provider2, Provider<GetAuthCode> provider3, Provider<ThirdPartyServicesMapper> provider4, Provider<IsNeedToShowToolTip> provider5, Provider<SaveShowToolTip> provider6, Provider<GetServicesWithCategory> provider7, Provider<GetDefaultServiceWithCategory> provider8, Provider<GetFavoriteServiceRemote> provider9, Provider<GetServicesByName> provider10, Provider<GetServicesByKey> provider11, Provider<GetFavoriteServices> provider12, Provider<CheckFavoriteServicesFeature> provider13, Provider<GetRawServices> provider14, Provider<GetFavoriteServiceWithCacheFirst> provider15, Provider<GetServiceHighlighted> provider16, Provider<UpdateServiceHighlighted> provider17) {
        return new ServicesPresenter_Factory(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8, provider9, provider10, provider11, provider12, provider13, provider14, provider15, provider16, provider17);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new ServicesPresenter(this.PlaceComponentResult.get(), this.NetworkUserEntityData$$ExternalSyntheticLambda7.get(), DoubleCheck.MyBillsEntityDataFactory(this.BuiltInFictitiousFunctionClassFactory), DoubleCheck.MyBillsEntityDataFactory(this.GetContactSyncConfig), DoubleCheck.MyBillsEntityDataFactory(this.NetworkUserEntityData$$ExternalSyntheticLambda2), DoubleCheck.MyBillsEntityDataFactory(this.initRecordTimeStamp), DoubleCheck.MyBillsEntityDataFactory(this.DatabaseTableConfigUtil), DoubleCheck.MyBillsEntityDataFactory(this.getAuthRequestContext), DoubleCheck.MyBillsEntityDataFactory(this.KClassImpl$Data$declaredNonStaticMembers$2), DoubleCheck.MyBillsEntityDataFactory(this.NetworkUserEntityData$$ExternalSyntheticLambda1), DoubleCheck.MyBillsEntityDataFactory(this.scheduleImpl), DoubleCheck.MyBillsEntityDataFactory(this.moveToNextValue), DoubleCheck.MyBillsEntityDataFactory(this.MyBillsEntityDataFactory), DoubleCheck.MyBillsEntityDataFactory(this.lookAheadTest), DoubleCheck.MyBillsEntityDataFactory(this.NetworkUserEntityData$$ExternalSyntheticLambda0), DoubleCheck.MyBillsEntityDataFactory(this.getErrorConfigVersion), DoubleCheck.MyBillsEntityDataFactory(this.isLayoutRequested));
    }
}
