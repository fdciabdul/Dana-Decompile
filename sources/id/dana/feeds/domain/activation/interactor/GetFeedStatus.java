package id.dana.feeds.domain.activation.interactor;

import id.dana.domain.core.usecase.BaseUseCase;
import id.dana.domain.core.usecase.NoParams;
import id.dana.feeds.domain.activation.FeedInitRepository;
import io.reactivex.Observable;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0011\b\u0007\u0012\u0006\u0010\b\u001a\u00020\u0004¢\u0006\u0004\b\t\u0010\nR\u0014\u0010\u0007\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0006"}, d2 = {"Lid/dana/feeds/domain/activation/interactor/GetFeedStatus;", "Lid/dana/domain/core/usecase/BaseUseCase;", "", "Lid/dana/domain/core/usecase/NoParams;", "Lid/dana/feeds/domain/activation/FeedInitRepository;", "KClassImpl$Data$declaredNonStaticMembers$2", "Lid/dana/feeds/domain/activation/FeedInitRepository;", "PlaceComponentResult", "p0", "<init>", "(Lid/dana/feeds/domain/activation/FeedInitRepository;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class GetFeedStatus extends BaseUseCase<Boolean, NoParams> {

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    private final FeedInitRepository PlaceComponentResult;

    @Override // id.dana.domain.core.usecase.BaseUseCase
    public final /* synthetic */ Observable<Boolean> buildUseCase(NoParams noParams) {
        Intrinsics.checkNotNullParameter(noParams, "");
        Observable<Boolean> just = Observable.just(Boolean.valueOf(this.PlaceComponentResult.PlaceComponentResult()));
        Intrinsics.checkNotNullExpressionValue(just, "");
        return just;
    }

    @Inject
    public GetFeedStatus(FeedInitRepository feedInitRepository) {
        Intrinsics.checkNotNullParameter(feedInitRepository, "");
        this.PlaceComponentResult = feedInitRepository;
    }
}
