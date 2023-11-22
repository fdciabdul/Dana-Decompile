package id.dana.social.contract.share;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.social.contract.share.ShareToFeedsContract;
import javax.inject.Provider;

/* loaded from: classes5.dex */
public final class ShareToFeedsModule_ProvideShareToFeedsPresenterFactory implements Factory<ShareToFeedsContract.Presenter> {
    private final Provider<ShareToFeedsPresenter> KClassImpl$Data$declaredNonStaticMembers$2;
    private final ShareToFeedsModule getAuthRequestContext;

    private ShareToFeedsModule_ProvideShareToFeedsPresenterFactory(ShareToFeedsModule shareToFeedsModule, Provider<ShareToFeedsPresenter> provider) {
        this.getAuthRequestContext = shareToFeedsModule;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = provider;
    }

    public static ShareToFeedsModule_ProvideShareToFeedsPresenterFactory getAuthRequestContext(ShareToFeedsModule shareToFeedsModule, Provider<ShareToFeedsPresenter> provider) {
        return new ShareToFeedsModule_ProvideShareToFeedsPresenterFactory(shareToFeedsModule, provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (ShareToFeedsContract.Presenter) Preconditions.BuiltInFictitiousFunctionClassFactory(this.getAuthRequestContext.KClassImpl$Data$declaredNonStaticMembers$2(this.KClassImpl$Data$declaredNonStaticMembers$2.get()));
    }
}
