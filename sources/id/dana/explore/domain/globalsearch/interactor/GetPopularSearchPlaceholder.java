package id.dana.explore.domain.globalsearch.interactor;

import id.dana.domain.core.usecase.BaseUseCase;
import id.dana.domain.core.usecase.NoParams;
import id.dana.explore.domain.globalsearch.GlobalSearchRepository;
import io.reactivex.Observable;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0007\u001a\u00020\u0004¢\u0006\u0004\b\b\u0010\tR\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0006"}, d2 = {"Lid/dana/explore/domain/globalsearch/interactor/GetPopularSearchPlaceholder;", "Lid/dana/domain/core/usecase/BaseUseCase;", "", "Lid/dana/domain/core/usecase/NoParams;", "Lid/dana/explore/domain/globalsearch/GlobalSearchRepository;", "getAuthRequestContext", "Lid/dana/explore/domain/globalsearch/GlobalSearchRepository;", "p0", "<init>", "(Lid/dana/explore/domain/globalsearch/GlobalSearchRepository;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class GetPopularSearchPlaceholder extends BaseUseCase<String, NoParams> {
    private final GlobalSearchRepository getAuthRequestContext;

    @Override // id.dana.domain.core.usecase.BaseUseCase
    public final /* synthetic */ Observable<String> buildUseCase(NoParams noParams) {
        Intrinsics.checkNotNullParameter(noParams, "");
        return this.getAuthRequestContext.getAuthRequestContext();
    }

    @Inject
    public GetPopularSearchPlaceholder(GlobalSearchRepository globalSearchRepository) {
        Intrinsics.checkNotNullParameter(globalSearchRepository, "");
        this.getAuthRequestContext = globalSearchRepository;
    }
}
