package id.dana.feeds.domain.timeline.interactor;

import id.dana.domain.core.usecase.BaseUseCase;
import id.dana.domain.core.usecase.NoParams;
import id.dana.feeds.domain.timeline.FeedsTimelineRepository;
import id.dana.feeds.domain.timeline.model.SocialFeed;
import io.reactivex.Observable;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0007\u001a\u00020\u0004¢\u0006\u0004\b\b\u0010\tR\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0006"}, d2 = {"Lid/dana/feeds/domain/timeline/interactor/GetCachedFeedsForWidget;", "Lid/dana/domain/core/usecase/BaseUseCase;", "Lid/dana/feeds/domain/timeline/model/SocialFeed;", "Lid/dana/domain/core/usecase/NoParams;", "Lid/dana/feeds/domain/timeline/FeedsTimelineRepository;", "MyBillsEntityDataFactory", "Lid/dana/feeds/domain/timeline/FeedsTimelineRepository;", "p0", "<init>", "(Lid/dana/feeds/domain/timeline/FeedsTimelineRepository;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class GetCachedFeedsForWidget extends BaseUseCase<SocialFeed, NoParams> {
    private final FeedsTimelineRepository MyBillsEntityDataFactory;

    @Override // id.dana.domain.core.usecase.BaseUseCase
    public final /* synthetic */ Observable<SocialFeed> buildUseCase(NoParams noParams) {
        Intrinsics.checkNotNullParameter(noParams, "");
        return this.MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2();
    }

    @Inject
    public GetCachedFeedsForWidget(FeedsTimelineRepository feedsTimelineRepository) {
        Intrinsics.checkNotNullParameter(feedsTimelineRepository, "");
        this.MyBillsEntityDataFactory = feedsTimelineRepository;
    }
}
