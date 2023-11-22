package id.dana.explore.domain.globalsearch.interactor;

import id.dana.domain.core.usecase.NoParams;
import id.dana.domain.social.Result;
import id.dana.domain.social.core.SingleUseCase;
import id.dana.explore.domain.globalsearch.GlobalSearchRepository;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0011\b\u0007\u0012\u0006\u0010\b\u001a\u00020\u0004¢\u0006\u0004\b\t\u0010\nR\u0014\u0010\u0007\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0006"}, d2 = {"Lid/dana/explore/domain/globalsearch/interactor/IsFeatureGlobalSearchEnabled;", "Lid/dana/domain/social/core/SingleUseCase;", "Lid/dana/domain/core/usecase/NoParams;", "", "Lid/dana/explore/domain/globalsearch/GlobalSearchRepository;", "getAuthRequestContext", "Lid/dana/explore/domain/globalsearch/GlobalSearchRepository;", "MyBillsEntityDataFactory", "p0", "<init>", "(Lid/dana/explore/domain/globalsearch/GlobalSearchRepository;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class IsFeatureGlobalSearchEnabled extends SingleUseCase<NoParams, Boolean> {

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    private final GlobalSearchRepository MyBillsEntityDataFactory;

    @Override // id.dana.domain.social.core.BaseUseCase
    public final /* synthetic */ Object buildUseCase(Object obj, Continuation continuation) {
        NoParams noParams = (NoParams) obj;
        return new Result.Success(this.MyBillsEntityDataFactory.lookAheadTest().blockingFirst());
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /* JADX WARN: Type inference failed for: r0v1, types: [kotlin.jvm.internal.DefaultConstructorMarker, kotlinx.coroutines.CoroutineDispatcher] */
    @javax.inject.Inject
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public IsFeatureGlobalSearchEnabled(id.dana.explore.domain.globalsearch.GlobalSearchRepository r3) {
        /*
            r2 = this;
            java.lang.String r0 = ""
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            r0 = 0
            r1 = 3
            r2.<init>(r0, r0, r1, r0)
            r2.MyBillsEntityDataFactory = r3
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.explore.domain.globalsearch.interactor.IsFeatureGlobalSearchEnabled.<init>(id.dana.explore.domain.globalsearch.GlobalSearchRepository):void");
    }
}
