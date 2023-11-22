package id.dana.social.contract.share;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.social.contract.share.ShareToFeedsContract;

/* loaded from: classes5.dex */
public final class ShareToFeedsModule_ProvideShareToFeedsViewFactory implements Factory<ShareToFeedsContract.View> {
    private final ShareToFeedsModule PlaceComponentResult;

    private ShareToFeedsModule_ProvideShareToFeedsViewFactory(ShareToFeedsModule shareToFeedsModule) {
        this.PlaceComponentResult = shareToFeedsModule;
    }

    public static ShareToFeedsModule_ProvideShareToFeedsViewFactory KClassImpl$Data$declaredNonStaticMembers$2(ShareToFeedsModule shareToFeedsModule) {
        return new ShareToFeedsModule_ProvideShareToFeedsViewFactory(shareToFeedsModule);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (ShareToFeedsContract.View) Preconditions.BuiltInFictitiousFunctionClassFactory(this.PlaceComponentResult.getGetAuthRequestContext());
    }
}
