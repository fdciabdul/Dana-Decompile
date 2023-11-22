package id.dana.feeds.domain.config.interactor;

import dagger.Lazy;
import id.dana.domain.core.usecase.BaseUseCase;
import id.dana.domain.core.usecase.NoParams;
import id.dana.domain.social.model.FeedConfig;
import id.dana.feeds.domain.config.FeedsConfigRepository;
import io.reactivex.Observable;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0017\b\u0007\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\t\u0010\nR\u001a\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007"}, d2 = {"Lid/dana/feeds/domain/config/interactor/GetFeedConfig;", "Lid/dana/domain/core/usecase/BaseUseCase;", "Lid/dana/domain/social/model/FeedConfig;", "Lid/dana/domain/core/usecase/NoParams;", "Ldagger/Lazy;", "Lid/dana/feeds/domain/config/FeedsConfigRepository;", "BuiltInFictitiousFunctionClassFactory", "Ldagger/Lazy;", "p0", "<init>", "(Ldagger/Lazy;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class GetFeedConfig extends BaseUseCase<FeedConfig, NoParams> {
    private final Lazy<FeedsConfigRepository> BuiltInFictitiousFunctionClassFactory;

    @Override // id.dana.domain.core.usecase.BaseUseCase
    public final /* synthetic */ Observable<FeedConfig> buildUseCase(NoParams noParams) {
        Intrinsics.checkNotNullParameter(noParams, "");
        return this.BuiltInFictitiousFunctionClassFactory.get().PlaceComponentResult();
    }

    @Inject
    public GetFeedConfig(Lazy<FeedsConfigRepository> lazy) {
        Intrinsics.checkNotNullParameter(lazy, "");
        this.BuiltInFictitiousFunctionClassFactory = lazy;
    }
}
