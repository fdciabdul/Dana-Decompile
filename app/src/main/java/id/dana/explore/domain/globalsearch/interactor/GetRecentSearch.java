package id.dana.explore.domain.globalsearch.interactor;

import id.dana.domain.core.usecase.BaseUseCase;
import id.dana.domain.core.usecase.NoParams;
import id.dana.explore.domain.globalsearch.GlobalSearchRepository;
import io.reactivex.Observable;
import java.util.HashMap;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002*\u0012 \u0012\u001e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002j\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004`\u0005\u0012\u0004\u0012\u00020\u00060\u0001B\u0011\b\u0007\u0012\u0006\u0010\u000b\u001a\u00020\u0007¢\u0006\u0004\b\f\u0010\rR\u0014\u0010\n\u001a\u00020\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\t"}, d2 = {"Lid/dana/explore/domain/globalsearch/interactor/GetRecentSearch;", "Lid/dana/domain/core/usecase/BaseUseCase;", "Ljava/util/HashMap;", "", "", "Lkotlin/collections/HashMap;", "Lid/dana/domain/core/usecase/NoParams;", "Lid/dana/explore/domain/globalsearch/GlobalSearchRepository;", "BuiltInFictitiousFunctionClassFactory", "Lid/dana/explore/domain/globalsearch/GlobalSearchRepository;", "PlaceComponentResult", "p0", "<init>", "(Lid/dana/explore/domain/globalsearch/GlobalSearchRepository;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class GetRecentSearch extends BaseUseCase<HashMap<String, Long>, NoParams> {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    private final GlobalSearchRepository PlaceComponentResult;

    @Override // id.dana.domain.core.usecase.BaseUseCase
    public final /* synthetic */ Observable<HashMap<String, Long>> buildUseCase(NoParams noParams) {
        Intrinsics.checkNotNullParameter(noParams, "");
        return this.PlaceComponentResult.KClassImpl$Data$declaredNonStaticMembers$2();
    }

    @Inject
    public GetRecentSearch(GlobalSearchRepository globalSearchRepository) {
        Intrinsics.checkNotNullParameter(globalSearchRepository, "");
        this.PlaceComponentResult = globalSearchRepository;
    }
}
