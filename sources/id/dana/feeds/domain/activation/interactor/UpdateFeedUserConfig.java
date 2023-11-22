package id.dana.feeds.domain.activation.interactor;

import id.dana.domain.core.usecase.CompletableUseCase;
import id.dana.domain.core.usecase.NoParams;
import id.dana.feeds.domain.activation.FeedInitRepository;
import io.reactivex.Completable;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0007\u001a\u00020\u0003¢\u0006\u0004\b\b\u0010\tR\u0014\u0010\u0006\u001a\u00020\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005"}, d2 = {"Lid/dana/feeds/domain/activation/interactor/UpdateFeedUserConfig;", "Lid/dana/domain/core/usecase/CompletableUseCase;", "Lid/dana/domain/core/usecase/NoParams;", "Lid/dana/feeds/domain/activation/FeedInitRepository;", "BuiltInFictitiousFunctionClassFactory", "Lid/dana/feeds/domain/activation/FeedInitRepository;", "getAuthRequestContext", "p0", "<init>", "(Lid/dana/feeds/domain/activation/FeedInitRepository;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class UpdateFeedUserConfig extends CompletableUseCase<NoParams> {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    private final FeedInitRepository getAuthRequestContext;

    @Override // id.dana.domain.core.usecase.CompletableUseCase
    public final /* synthetic */ Completable buildUseCase(NoParams noParams) {
        Intrinsics.checkNotNullParameter(noParams, "");
        Completable ignoreElements = this.getAuthRequestContext.scheduleImpl().ignoreElements();
        Intrinsics.checkNotNullExpressionValue(ignoreElements, "");
        return ignoreElements;
    }

    @Inject
    public UpdateFeedUserConfig(FeedInitRepository feedInitRepository) {
        Intrinsics.checkNotNullParameter(feedInitRepository, "");
        this.getAuthRequestContext = feedInitRepository;
    }
}
