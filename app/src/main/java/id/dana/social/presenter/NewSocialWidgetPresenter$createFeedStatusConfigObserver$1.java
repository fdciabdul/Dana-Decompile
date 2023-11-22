package id.dana.social.presenter;

import id.dana.domain.DefaultObserver;
import id.dana.social.FeedUserConfigHelper;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001"}, d2 = {"Lid/dana/social/presenter/NewSocialWidgetPresenter$createFeedStatusConfigObserver$1;", "Lid/dana/domain/DefaultObserver;", "Lid/dana/social/FeedUserConfigHelper$FeedUserConfigFetchingState;"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class NewSocialWidgetPresenter$createFeedStatusConfigObserver$1 extends DefaultObserver<FeedUserConfigHelper.FeedUserConfigFetchingState> {
    final /* synthetic */ NewSocialWidgetPresenter PlaceComponentResult;

    /* JADX INFO: Access modifiers changed from: package-private */
    public NewSocialWidgetPresenter$createFeedStatusConfigObserver$1(NewSocialWidgetPresenter newSocialWidgetPresenter) {
        this.PlaceComponentResult = newSocialWidgetPresenter;
    }

    @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
    public final /* synthetic */ void onNext(Object obj) {
        FeedUserConfigHelper.FeedUserConfigFetchingState feedUserConfigFetchingState = (FeedUserConfigHelper.FeedUserConfigFetchingState) obj;
        Intrinsics.checkNotNullParameter(feedUserConfigFetchingState, "");
        NewSocialWidgetPresenter.PlaceComponentResult(this.PlaceComponentResult, feedUserConfigFetchingState);
    }
}
