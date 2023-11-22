package id.dana.feeds.domain.share.interactor;

import id.dana.domain.core.usecase.CompletableUseCase;
import id.dana.feeds.domain.share.FeedsShareRepository;
import io.reactivex.Completable;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0004\b\u0007\u0010\bR\u0014\u0010\u0004\u001a\u00020\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005"}, d2 = {"Lid/dana/feeds/domain/share/interactor/DeleteLastShareFeedRequest;", "Lid/dana/domain/core/usecase/CompletableUseCase;", "", "Lid/dana/feeds/domain/share/FeedsShareRepository;", "MyBillsEntityDataFactory", "Lid/dana/feeds/domain/share/FeedsShareRepository;", "p0", "<init>", "(Lid/dana/feeds/domain/share/FeedsShareRepository;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class DeleteLastShareFeedRequest extends CompletableUseCase<String> {
    private final FeedsShareRepository MyBillsEntityDataFactory;

    @Override // id.dana.domain.core.usecase.CompletableUseCase
    public final /* synthetic */ Completable buildUseCase(String str) {
        String str2 = str;
        Intrinsics.checkNotNullParameter(str2, "");
        Completable ignoreElements = this.MyBillsEntityDataFactory.PlaceComponentResult(str2).ignoreElements();
        Intrinsics.checkNotNullExpressionValue(ignoreElements, "");
        return ignoreElements;
    }

    @Inject
    public DeleteLastShareFeedRequest(FeedsShareRepository feedsShareRepository) {
        Intrinsics.checkNotNullParameter(feedsShareRepository, "");
        this.MyBillsEntityDataFactory = feedsShareRepository;
    }
}
