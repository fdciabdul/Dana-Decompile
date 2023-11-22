package id.dana.feeds.domain.share.interactor;

import id.dana.domain.core.usecase.CompletableUseCase;
import id.dana.feeds.domain.share.FeedsShareRepository;
import io.reactivex.Completable;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0007\u001a\u00020\u0003¢\u0006\u0004\b\b\u0010\tR\u0014\u0010\u0006\u001a\u00020\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005"}, d2 = {"Lid/dana/feeds/domain/share/interactor/SetLastShareFeedRequest;", "Lid/dana/domain/core/usecase/CompletableUseCase;", "", "Lid/dana/feeds/domain/share/FeedsShareRepository;", "PlaceComponentResult", "Lid/dana/feeds/domain/share/FeedsShareRepository;", "getAuthRequestContext", "p0", "<init>", "(Lid/dana/feeds/domain/share/FeedsShareRepository;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class SetLastShareFeedRequest extends CompletableUseCase<String> {

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private final FeedsShareRepository getAuthRequestContext;

    @Override // id.dana.domain.core.usecase.CompletableUseCase
    public final /* synthetic */ Completable buildUseCase(String str) {
        String str2 = str;
        Intrinsics.checkNotNullParameter(str2, "");
        Completable ignoreElements = this.getAuthRequestContext.KClassImpl$Data$declaredNonStaticMembers$2(str2).ignoreElements();
        Intrinsics.checkNotNullExpressionValue(ignoreElements, "");
        return ignoreElements;
    }

    @Inject
    public SetLastShareFeedRequest(FeedsShareRepository feedsShareRepository) {
        Intrinsics.checkNotNullParameter(feedsShareRepository, "");
        this.getAuthRequestContext = feedsShareRepository;
    }
}
