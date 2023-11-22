package id.dana.sendmoney.recipient.recent;

import dagger.internal.Factory;
import id.dana.domain.featureconfig.interactor.CheckSendMoneyPeerToCash;
import id.dana.domain.featureconfig.interactor.CheckTransferToLinkFeature;
import id.dana.domain.recentrecipient.interactor.GetIsRecentRecipientMigratedToRoom;
import id.dana.domain.recentrecipient.interactor.GetMaxRecentRecipient;
import id.dana.domain.recentrecipient.interactor.GetRecentContact;
import id.dana.domain.recentrecipient.interactor.GetRecentRecipient;
import id.dana.domain.recentrecipient.interactor.GetRecentTransaction;
import id.dana.domain.recentrecipient.interactor.MaskingRecentRecipient;
import id.dana.domain.sendmoney.interactor.GetRecentGroup;
import id.dana.sendmoney.mapper.RecentRecipientModelMapper;
import id.dana.sendmoney.recipient.recent.RecentRecipientContract;
import javax.inject.Provider;

/* loaded from: classes5.dex */
public final class RecentRecipientPresenter_Factory implements Factory<RecentRecipientPresenter> {
    private final Provider<GetMaxRecentRecipient> BuiltInFictitiousFunctionClassFactory;
    private final Provider<CheckSendMoneyPeerToCash> KClassImpl$Data$declaredNonStaticMembers$2;
    private final Provider<CheckTransferToLinkFeature> MyBillsEntityDataFactory;
    private final Provider<RecentRecipientModelMapper> NetworkUserEntityData$$ExternalSyntheticLambda0;
    private final Provider<RecentRecipientContract.View> NetworkUserEntityData$$ExternalSyntheticLambda2;
    private final Provider<GetRecentContact> PlaceComponentResult;
    private final Provider<GetIsRecentRecipientMigratedToRoom> getAuthRequestContext;
    private final Provider<MaskingRecentRecipient> getErrorConfigVersion;
    private final Provider<GetRecentGroup> lookAheadTest;
    private final Provider<GetRecentTransaction> moveToNextValue;
    private final Provider<GetRecentRecipient> scheduleImpl;

    private RecentRecipientPresenter_Factory(Provider<RecentRecipientContract.View> provider, Provider<GetRecentRecipient> provider2, Provider<RecentRecipientModelMapper> provider3, Provider<CheckTransferToLinkFeature> provider4, Provider<CheckSendMoneyPeerToCash> provider5, Provider<MaskingRecentRecipient> provider6, Provider<GetMaxRecentRecipient> provider7, Provider<GetRecentTransaction> provider8, Provider<GetRecentContact> provider9, Provider<GetRecentGroup> provider10, Provider<GetIsRecentRecipientMigratedToRoom> provider11) {
        this.NetworkUserEntityData$$ExternalSyntheticLambda2 = provider;
        this.scheduleImpl = provider2;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = provider3;
        this.MyBillsEntityDataFactory = provider4;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = provider5;
        this.getErrorConfigVersion = provider6;
        this.BuiltInFictitiousFunctionClassFactory = provider7;
        this.moveToNextValue = provider8;
        this.PlaceComponentResult = provider9;
        this.lookAheadTest = provider10;
        this.getAuthRequestContext = provider11;
    }

    public static RecentRecipientPresenter_Factory MyBillsEntityDataFactory(Provider<RecentRecipientContract.View> provider, Provider<GetRecentRecipient> provider2, Provider<RecentRecipientModelMapper> provider3, Provider<CheckTransferToLinkFeature> provider4, Provider<CheckSendMoneyPeerToCash> provider5, Provider<MaskingRecentRecipient> provider6, Provider<GetMaxRecentRecipient> provider7, Provider<GetRecentTransaction> provider8, Provider<GetRecentContact> provider9, Provider<GetRecentGroup> provider10, Provider<GetIsRecentRecipientMigratedToRoom> provider11) {
        return new RecentRecipientPresenter_Factory(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8, provider9, provider10, provider11);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new RecentRecipientPresenter(this.NetworkUserEntityData$$ExternalSyntheticLambda2.get(), this.scheduleImpl.get(), this.NetworkUserEntityData$$ExternalSyntheticLambda0.get(), this.MyBillsEntityDataFactory.get(), this.KClassImpl$Data$declaredNonStaticMembers$2.get(), this.getErrorConfigVersion.get(), this.BuiltInFictitiousFunctionClassFactory.get(), this.moveToNextValue.get(), this.PlaceComponentResult.get(), this.lookAheadTest.get(), this.getAuthRequestContext.get());
    }
}
