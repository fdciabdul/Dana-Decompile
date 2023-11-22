package id.dana.social.contract.friendsfeeds;

import id.dana.domain.DefaultObserver;
import id.dana.social.FeedUserConfigHelper;
import id.dana.social.contract.friendsfeeds.FriendFeedsContract;
import id.dana.social.contract.friendsfeeds.FriendsFeedsPresenter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001"}, d2 = {"Lid/dana/social/contract/friendsfeeds/FriendsFeedsPresenter$createFeedUserConfigObserver$1;", "Lid/dana/domain/DefaultObserver;", "Lid/dana/social/FeedUserConfigHelper$FeedUserConfigFetchingState;"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class FriendsFeedsPresenter$createFeedUserConfigObserver$1 extends DefaultObserver<FeedUserConfigHelper.FeedUserConfigFetchingState> {
    final /* synthetic */ FriendsFeedsPresenter getAuthRequestContext;

    /* JADX INFO: Access modifiers changed from: package-private */
    public FriendsFeedsPresenter$createFeedUserConfigObserver$1(FriendsFeedsPresenter friendsFeedsPresenter) {
        this.getAuthRequestContext = friendsFeedsPresenter;
    }

    @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
    public final /* synthetic */ void onNext(Object obj) {
        FeedUserConfigHelper.FeedUserConfigFetchingState feedUserConfigFetchingState = (FeedUserConfigHelper.FeedUserConfigFetchingState) obj;
        Intrinsics.checkNotNullParameter(feedUserConfigFetchingState, "");
        FriendsFeedsPresenter friendsFeedsPresenter = this.getAuthRequestContext;
        Intrinsics.checkNotNullParameter(feedUserConfigFetchingState, "");
        int i = FriendsFeedsPresenter.WhenMappings.getAuthRequestContext[feedUserConfigFetchingState.ordinal()];
        if (i == 1 || i == 2) {
            friendsFeedsPresenter.id.dana.sendmoney.summary.SummaryActivity.DAYS java.lang.String.get().BuiltInFictitiousFunctionClassFactory(FriendFeedsContract.State.FinishFetchUserConfig.INSTANCE);
        } else if (i == 3) {
            friendsFeedsPresenter.id.dana.sendmoney.summary.SummaryActivity.DAYS java.lang.String.get().BuiltInFictitiousFunctionClassFactory(FriendFeedsContract.State.ErrorFetchUserConfig.INSTANCE);
        } else if (i == 4) {
            friendsFeedsPresenter.id.dana.sendmoney.summary.SummaryActivity.DAYS java.lang.String.get().BuiltInFictitiousFunctionClassFactory(FriendFeedsContract.State.LoadingFetchUserConfig.INSTANCE);
        }
    }
}
