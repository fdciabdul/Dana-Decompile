package id.dana.feeds.domain.config.interactor;

import dagger.Lazy;
import id.dana.domain.core.usecase.BaseUseCase;
import id.dana.feeds.domain.relationship.FeedsRelationshipRepository;
import io.reactivex.Observable;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\fB\u0017\b\u0007\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\n\u0010\u000bR\u001a\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007"}, d2 = {"Lid/dana/feeds/domain/config/interactor/ApproveFriendRequest;", "Lid/dana/domain/core/usecase/BaseUseCase;", "", "Lid/dana/feeds/domain/config/interactor/ApproveFriendRequest$Params;", "Ldagger/Lazy;", "Lid/dana/feeds/domain/relationship/FeedsRelationshipRepository;", "PlaceComponentResult", "Ldagger/Lazy;", "getAuthRequestContext", "p0", "<init>", "(Ldagger/Lazy;)V", "Params"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ApproveFriendRequest extends BaseUseCase<Boolean, Params> {

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private final Lazy<FeedsRelationshipRepository> getAuthRequestContext;

    @Override // id.dana.domain.core.usecase.BaseUseCase
    public final /* synthetic */ Observable<Boolean> buildUseCase(Params params) {
        Params params2 = params;
        Intrinsics.checkNotNullParameter(params2, "");
        return this.getAuthRequestContext.get().PlaceComponentResult(params2.KClassImpl$Data$declaredNonStaticMembers$2);
    }

    @Inject
    public ApproveFriendRequest(Lazy<FeedsRelationshipRepository> lazy) {
        Intrinsics.checkNotNullParameter(lazy, "");
        this.getAuthRequestContext = lazy;
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0006\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0011\u0010\u0005\u001a\u00020\u0002X\u0006¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004"}, d2 = {"Lid/dana/feeds/domain/config/interactor/ApproveFriendRequest$Params;", "", "", "BuiltInFictitiousFunctionClassFactory", "Ljava/lang/String;", "KClassImpl$Data$declaredNonStaticMembers$2", "p0", "<init>", "(Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Params {

        /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
        final String KClassImpl$Data$declaredNonStaticMembers$2;

        public Params(String str) {
            Intrinsics.checkNotNullParameter(str, "");
            this.KClassImpl$Data$declaredNonStaticMembers$2 = str;
        }
    }
}
