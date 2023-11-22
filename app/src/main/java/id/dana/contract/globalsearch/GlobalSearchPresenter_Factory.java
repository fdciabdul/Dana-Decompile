package id.dana.contract.globalsearch;

import android.content.Context;
import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import id.dana.contract.globalsearch.GlobalSearchContract;
import id.dana.domain.account.interactor.GetUserId;
import id.dana.domain.authcode.interactor.GetAuthCode;
import id.dana.domain.merchant.interactor.GetMerchantSubcategories;
import id.dana.domain.services.interactor.GetRawServices;
import id.dana.explore.domain.globalsearch.interactor.CheckShouldSuggestLocationPermissionDialog;
import id.dana.explore.domain.globalsearch.interactor.GetAutoCompleteByKeyword;
import id.dana.explore.domain.globalsearch.interactor.GetGlobalSearchConfig;
import id.dana.explore.domain.globalsearch.interactor.GetHintSwipeVisibilityState;
import id.dana.explore.domain.globalsearch.interactor.GetHomeSearchBarVisibility;
import id.dana.explore.domain.globalsearch.interactor.GetOnlineMerchant;
import id.dana.explore.domain.globalsearch.interactor.GetPopularSearch;
import id.dana.explore.domain.globalsearch.interactor.GetPopularSearchPlaceholder;
import id.dana.explore.domain.globalsearch.interactor.GetRecentSearch;
import id.dana.explore.domain.globalsearch.interactor.GetSearchByKeyword;
import id.dana.explore.domain.globalsearch.interactor.IsFeatureGlobalSearchEnabled;
import id.dana.explore.domain.globalsearch.interactor.SaveLocationPermissionSuggestionState;
import id.dana.explore.domain.globalsearch.interactor.SaveRecentSearch;
import id.dana.explore.domain.globalsearch.interactor.SetHintSwipeVisibilityState;
import id.dana.explore.domain.sku.interactor.GetPrepaidCheckoutUrl;
import id.dana.explore.domain.sku.interactor.GetSkuExplore;
import id.dana.explore.domain.userpersonalization.interactor.CheckShouldShowUserPersonalization;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class GlobalSearchPresenter_Factory implements Factory<GlobalSearchPresenter> {
    private final Provider<CheckShouldSuggestLocationPermissionDialog> BuiltInFictitiousFunctionClassFactory;
    private final Provider<GetRecentSearch> DatabaseTableConfigUtil;
    private final Provider<GetPrepaidCheckoutUrl> GetContactSyncConfig;
    private final Provider<GetAutoCompleteByKeyword> KClassImpl$Data$declaredNonStaticMembers$2;
    private final Provider<Context> MyBillsEntityDataFactory;
    private final Provider<GetHintSwipeVisibilityState> NetworkUserEntityData$$ExternalSyntheticLambda0;
    private final Provider<GetPopularSearchPlaceholder> NetworkUserEntityData$$ExternalSyntheticLambda1;
    private final Provider<GetRawServices> NetworkUserEntityData$$ExternalSyntheticLambda2;
    private final Provider<GlobalSearchContract.View> NetworkUserEntityData$$ExternalSyntheticLambda3;
    private final Provider<SetHintSwipeVisibilityState> NetworkUserEntityData$$ExternalSyntheticLambda5;
    private final Provider<SaveRecentSearch> NetworkUserEntityData$$ExternalSyntheticLambda6;
    private final Provider<GetSearchByKeyword> NetworkUserEntityData$$ExternalSyntheticLambda7;
    private final Provider<GetUserId> NetworkUserEntityData$$ExternalSyntheticLambda8;
    private final Provider<GetAuthCode> PlaceComponentResult;
    private final Provider<IsFeatureGlobalSearchEnabled> PrepareContext;
    private final Provider<CheckShouldShowUserPersonalization> getAuthRequestContext;
    private final Provider<GetHomeSearchBarVisibility> getErrorConfigVersion;
    private final Provider<GetPopularSearch> initRecordTimeStamp;
    private final Provider<GetSkuExplore> isLayoutRequested;
    private final Provider<GetMerchantSubcategories> lookAheadTest;
    private final Provider<GetGlobalSearchConfig> moveToNextValue;
    private final Provider<SaveLocationPermissionSuggestionState> newProxyInstance;
    private final Provider<GetOnlineMerchant> scheduleImpl;

    private GlobalSearchPresenter_Factory(Provider<Context> provider, Provider<GetSearchByKeyword> provider2, Provider<GetAutoCompleteByKeyword> provider3, Provider<IsFeatureGlobalSearchEnabled> provider4, Provider<GetMerchantSubcategories> provider5, Provider<GetRawServices> provider6, Provider<GetHintSwipeVisibilityState> provider7, Provider<SetHintSwipeVisibilityState> provider8, Provider<GetPopularSearch> provider9, Provider<GetAuthCode> provider10, Provider<SaveLocationPermissionSuggestionState> provider11, Provider<CheckShouldSuggestLocationPermissionDialog> provider12, Provider<GlobalSearchContract.View> provider13, Provider<GetRecentSearch> provider14, Provider<SaveRecentSearch> provider15, Provider<GetPopularSearchPlaceholder> provider16, Provider<GetGlobalSearchConfig> provider17, Provider<GetHomeSearchBarVisibility> provider18, Provider<GetSkuExplore> provider19, Provider<GetPrepaidCheckoutUrl> provider20, Provider<GetOnlineMerchant> provider21, Provider<GetUserId> provider22, Provider<CheckShouldShowUserPersonalization> provider23) {
        this.MyBillsEntityDataFactory = provider;
        this.NetworkUserEntityData$$ExternalSyntheticLambda7 = provider2;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = provider3;
        this.PrepareContext = provider4;
        this.lookAheadTest = provider5;
        this.NetworkUserEntityData$$ExternalSyntheticLambda2 = provider6;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = provider7;
        this.NetworkUserEntityData$$ExternalSyntheticLambda5 = provider8;
        this.initRecordTimeStamp = provider9;
        this.PlaceComponentResult = provider10;
        this.newProxyInstance = provider11;
        this.BuiltInFictitiousFunctionClassFactory = provider12;
        this.NetworkUserEntityData$$ExternalSyntheticLambda3 = provider13;
        this.DatabaseTableConfigUtil = provider14;
        this.NetworkUserEntityData$$ExternalSyntheticLambda6 = provider15;
        this.NetworkUserEntityData$$ExternalSyntheticLambda1 = provider16;
        this.moveToNextValue = provider17;
        this.getErrorConfigVersion = provider18;
        this.isLayoutRequested = provider19;
        this.GetContactSyncConfig = provider20;
        this.scheduleImpl = provider21;
        this.NetworkUserEntityData$$ExternalSyntheticLambda8 = provider22;
        this.getAuthRequestContext = provider23;
    }

    public static GlobalSearchPresenter_Factory BuiltInFictitiousFunctionClassFactory(Provider<Context> provider, Provider<GetSearchByKeyword> provider2, Provider<GetAutoCompleteByKeyword> provider3, Provider<IsFeatureGlobalSearchEnabled> provider4, Provider<GetMerchantSubcategories> provider5, Provider<GetRawServices> provider6, Provider<GetHintSwipeVisibilityState> provider7, Provider<SetHintSwipeVisibilityState> provider8, Provider<GetPopularSearch> provider9, Provider<GetAuthCode> provider10, Provider<SaveLocationPermissionSuggestionState> provider11, Provider<CheckShouldSuggestLocationPermissionDialog> provider12, Provider<GlobalSearchContract.View> provider13, Provider<GetRecentSearch> provider14, Provider<SaveRecentSearch> provider15, Provider<GetPopularSearchPlaceholder> provider16, Provider<GetGlobalSearchConfig> provider17, Provider<GetHomeSearchBarVisibility> provider18, Provider<GetSkuExplore> provider19, Provider<GetPrepaidCheckoutUrl> provider20, Provider<GetOnlineMerchant> provider21, Provider<GetUserId> provider22, Provider<CheckShouldShowUserPersonalization> provider23) {
        return new GlobalSearchPresenter_Factory(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8, provider9, provider10, provider11, provider12, provider13, provider14, provider15, provider16, provider17, provider18, provider19, provider20, provider21, provider22, provider23);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new GlobalSearchPresenter(this.MyBillsEntityDataFactory.get(), DoubleCheck.MyBillsEntityDataFactory(this.NetworkUserEntityData$$ExternalSyntheticLambda7), DoubleCheck.MyBillsEntityDataFactory(this.KClassImpl$Data$declaredNonStaticMembers$2), DoubleCheck.MyBillsEntityDataFactory(this.PrepareContext), DoubleCheck.MyBillsEntityDataFactory(this.lookAheadTest), DoubleCheck.MyBillsEntityDataFactory(this.NetworkUserEntityData$$ExternalSyntheticLambda2), DoubleCheck.MyBillsEntityDataFactory(this.NetworkUserEntityData$$ExternalSyntheticLambda0), DoubleCheck.MyBillsEntityDataFactory(this.NetworkUserEntityData$$ExternalSyntheticLambda5), DoubleCheck.MyBillsEntityDataFactory(this.initRecordTimeStamp), DoubleCheck.MyBillsEntityDataFactory(this.PlaceComponentResult), DoubleCheck.MyBillsEntityDataFactory(this.newProxyInstance), DoubleCheck.MyBillsEntityDataFactory(this.BuiltInFictitiousFunctionClassFactory), DoubleCheck.MyBillsEntityDataFactory(this.NetworkUserEntityData$$ExternalSyntheticLambda3), DoubleCheck.MyBillsEntityDataFactory(this.DatabaseTableConfigUtil), DoubleCheck.MyBillsEntityDataFactory(this.NetworkUserEntityData$$ExternalSyntheticLambda6), DoubleCheck.MyBillsEntityDataFactory(this.NetworkUserEntityData$$ExternalSyntheticLambda1), DoubleCheck.MyBillsEntityDataFactory(this.moveToNextValue), DoubleCheck.MyBillsEntityDataFactory(this.getErrorConfigVersion), DoubleCheck.MyBillsEntityDataFactory(this.isLayoutRequested), DoubleCheck.MyBillsEntityDataFactory(this.GetContactSyncConfig), DoubleCheck.MyBillsEntityDataFactory(this.scheduleImpl), DoubleCheck.MyBillsEntityDataFactory(this.NetworkUserEntityData$$ExternalSyntheticLambda8), DoubleCheck.MyBillsEntityDataFactory(this.getAuthRequestContext));
    }
}
