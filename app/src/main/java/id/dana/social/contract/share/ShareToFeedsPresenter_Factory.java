package id.dana.social.contract.share;

import dagger.internal.Factory;
import id.dana.feeds.domain.activation.interactor.GetFeedStatus;
import id.dana.feeds.domain.share.interactor.GetFeedsSharingLastCheckedState;
import id.dana.feeds.domain.share.interactor.GetShareFeedConsent;
import id.dana.feeds.domain.share.interactor.SaveFeedsSharingLastCheckedState;
import id.dana.feeds.domain.share.interactor.SaveShareFeedConsent;
import id.dana.social.contract.share.ShareToFeedsContract;
import javax.inject.Provider;

/* loaded from: classes5.dex */
public final class ShareToFeedsPresenter_Factory implements Factory<ShareToFeedsPresenter> {
    private final Provider<SaveShareFeedConsent> BuiltInFictitiousFunctionClassFactory;
    private final Provider<GetFeedsSharingLastCheckedState> KClassImpl$Data$declaredNonStaticMembers$2;
    private final Provider<SaveFeedsSharingLastCheckedState> MyBillsEntityDataFactory;
    private final Provider<ShareToFeedsContract.View> NetworkUserEntityData$$ExternalSyntheticLambda0;
    private final Provider<GetFeedStatus> PlaceComponentResult;
    private final Provider<GetShareFeedConsent> getAuthRequestContext;

    private ShareToFeedsPresenter_Factory(Provider<GetShareFeedConsent> provider, Provider<SaveShareFeedConsent> provider2, Provider<GetFeedsSharingLastCheckedState> provider3, Provider<SaveFeedsSharingLastCheckedState> provider4, Provider<ShareToFeedsContract.View> provider5, Provider<GetFeedStatus> provider6) {
        this.getAuthRequestContext = provider;
        this.BuiltInFictitiousFunctionClassFactory = provider2;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = provider3;
        this.MyBillsEntityDataFactory = provider4;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = provider5;
        this.PlaceComponentResult = provider6;
    }

    public static ShareToFeedsPresenter_Factory PlaceComponentResult(Provider<GetShareFeedConsent> provider, Provider<SaveShareFeedConsent> provider2, Provider<GetFeedsSharingLastCheckedState> provider3, Provider<SaveFeedsSharingLastCheckedState> provider4, Provider<ShareToFeedsContract.View> provider5, Provider<GetFeedStatus> provider6) {
        return new ShareToFeedsPresenter_Factory(provider, provider2, provider3, provider4, provider5, provider6);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new ShareToFeedsPresenter(this.getAuthRequestContext.get(), this.BuiltInFictitiousFunctionClassFactory.get(), this.KClassImpl$Data$declaredNonStaticMembers$2.get(), this.MyBillsEntityDataFactory.get(), this.NetworkUserEntityData$$ExternalSyntheticLambda0.get(), this.PlaceComponentResult.get());
    }
}
