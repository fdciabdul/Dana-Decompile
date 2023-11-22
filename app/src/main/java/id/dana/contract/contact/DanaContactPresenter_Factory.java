package id.dana.contract.contact;

import android.content.Context;
import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import id.dana.contract.contact.DanaContactContract;
import id.dana.domain.featureconfig.interactor.CheckContactSyncFeature;
import id.dana.domain.featureconfig.interactor.GetContactInjectionConfig;
import id.dana.domain.recentcontact.interactor.GetDanaContact;
import id.dana.domain.synccontact.interactor.CheckSyncProcessCompleteState;
import id.dana.domain.synccontact.interactor.GetLastSyncedContact;
import id.dana.feeds.domain.share.interactor.SaveShareFeedConsent;
import id.dana.richview.contactselector.UserContactMapper;
import id.dana.sendmoney.contact.provider.ContactProvider;
import id.dana.sync_engine.domain.interactor.GetContactsUseCase;
import id.dana.synccontact.SyncContactUtil;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class DanaContactPresenter_Factory implements Factory<DanaContactPresenter> {
    private final Provider<ContactProvider> BuiltInFictitiousFunctionClassFactory;
    private final Provider<UserContactMapper> DatabaseTableConfigUtil;
    private final Provider<CheckContactSyncFeature> KClassImpl$Data$declaredNonStaticMembers$2;
    private final Provider<CheckSyncProcessCompleteState> MyBillsEntityDataFactory;
    private final Provider<GetContactsUseCase> NetworkUserEntityData$$ExternalSyntheticLambda0;
    private final Provider<DanaContactContract.View> NetworkUserEntityData$$ExternalSyntheticLambda2;
    private final Provider<Context> PlaceComponentResult;
    private final Provider<GetContactInjectionConfig> getAuthRequestContext;
    private final Provider<GetDanaContact> getErrorConfigVersion;
    private final Provider<GetLastSyncedContact> lookAheadTest;
    private final Provider<SyncContactUtil> moveToNextValue;
    private final Provider<SaveShareFeedConsent> scheduleImpl;

    private DanaContactPresenter_Factory(Provider<Context> provider, Provider<DanaContactContract.View> provider2, Provider<GetDanaContact> provider3, Provider<CheckSyncProcessCompleteState> provider4, Provider<GetLastSyncedContact> provider5, Provider<CheckContactSyncFeature> provider6, Provider<SyncContactUtil> provider7, Provider<SaveShareFeedConsent> provider8, Provider<ContactProvider> provider9, Provider<GetContactsUseCase> provider10, Provider<UserContactMapper> provider11, Provider<GetContactInjectionConfig> provider12) {
        this.PlaceComponentResult = provider;
        this.NetworkUserEntityData$$ExternalSyntheticLambda2 = provider2;
        this.getErrorConfigVersion = provider3;
        this.MyBillsEntityDataFactory = provider4;
        this.lookAheadTest = provider5;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = provider6;
        this.moveToNextValue = provider7;
        this.scheduleImpl = provider8;
        this.BuiltInFictitiousFunctionClassFactory = provider9;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = provider10;
        this.DatabaseTableConfigUtil = provider11;
        this.getAuthRequestContext = provider12;
    }

    public static DanaContactPresenter_Factory getAuthRequestContext(Provider<Context> provider, Provider<DanaContactContract.View> provider2, Provider<GetDanaContact> provider3, Provider<CheckSyncProcessCompleteState> provider4, Provider<GetLastSyncedContact> provider5, Provider<CheckContactSyncFeature> provider6, Provider<SyncContactUtil> provider7, Provider<SaveShareFeedConsent> provider8, Provider<ContactProvider> provider9, Provider<GetContactsUseCase> provider10, Provider<UserContactMapper> provider11, Provider<GetContactInjectionConfig> provider12) {
        return new DanaContactPresenter_Factory(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8, provider9, provider10, provider11, provider12);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new DanaContactPresenter(this.PlaceComponentResult.get(), DoubleCheck.MyBillsEntityDataFactory(this.NetworkUserEntityData$$ExternalSyntheticLambda2), DoubleCheck.MyBillsEntityDataFactory(this.getErrorConfigVersion), DoubleCheck.MyBillsEntityDataFactory(this.MyBillsEntityDataFactory), DoubleCheck.MyBillsEntityDataFactory(this.lookAheadTest), DoubleCheck.MyBillsEntityDataFactory(this.KClassImpl$Data$declaredNonStaticMembers$2), DoubleCheck.MyBillsEntityDataFactory(this.moveToNextValue), DoubleCheck.MyBillsEntityDataFactory(this.scheduleImpl), DoubleCheck.MyBillsEntityDataFactory(this.BuiltInFictitiousFunctionClassFactory), DoubleCheck.MyBillsEntityDataFactory(this.NetworkUserEntityData$$ExternalSyntheticLambda0), DoubleCheck.MyBillsEntityDataFactory(this.DatabaseTableConfigUtil), DoubleCheck.MyBillsEntityDataFactory(this.getAuthRequestContext));
    }
}
