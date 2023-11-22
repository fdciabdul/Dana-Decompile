package id.dana.feeds.domain.share.interactor;

import id.dana.domain.core.usecase.CompletableUseCase;
import id.dana.feeds.domain.share.FeedsShareRepository;
import io.reactivex.Completable;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\nB\u0011\b\u0007\u0012\u0006\u0010\u0007\u001a\u00020\u0003¢\u0006\u0004\b\b\u0010\tR\u0014\u0010\u0006\u001a\u00020\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005"}, d2 = {"Lid/dana/feeds/domain/share/interactor/DeleteFeedActivity;", "Lid/dana/domain/core/usecase/CompletableUseCase;", "Lid/dana/feeds/domain/share/interactor/DeleteFeedActivity$Params;", "Lid/dana/feeds/domain/share/FeedsShareRepository;", "BuiltInFictitiousFunctionClassFactory", "Lid/dana/feeds/domain/share/FeedsShareRepository;", "getAuthRequestContext", "p0", "<init>", "(Lid/dana/feeds/domain/share/FeedsShareRepository;)V", "Params"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class DeleteFeedActivity extends CompletableUseCase<Params> {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    private final FeedsShareRepository getAuthRequestContext;

    @Override // id.dana.domain.core.usecase.CompletableUseCase
    public final /* synthetic */ Completable buildUseCase(Params params) {
        Params params2 = params;
        Intrinsics.checkNotNullParameter(params2, "");
        Completable ignoreElements = this.getAuthRequestContext.MyBillsEntityDataFactory(params2.getAuthRequestContext).ignoreElements();
        Intrinsics.checkNotNullExpressionValue(ignoreElements, "");
        return ignoreElements;
    }

    @Inject
    public DeleteFeedActivity(FeedsShareRepository feedsShareRepository) {
        Intrinsics.checkNotNullParameter(feedsShareRepository, "");
        this.getAuthRequestContext = feedsShareRepository;
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0006\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0011\u0010\u0005\u001a\u00020\u0002X\u0006¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004"}, d2 = {"Lid/dana/feeds/domain/share/interactor/DeleteFeedActivity$Params;", "", "", "BuiltInFictitiousFunctionClassFactory", "Ljava/lang/String;", "getAuthRequestContext", "p0", "<init>", "(Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Params {

        /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
        final String getAuthRequestContext;

        public Params(String str) {
            Intrinsics.checkNotNullParameter(str, "");
            this.getAuthRequestContext = str;
        }
    }
}
