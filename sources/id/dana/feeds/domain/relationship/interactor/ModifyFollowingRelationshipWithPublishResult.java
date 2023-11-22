package id.dana.feeds.domain.relationship.interactor;

import id.dana.domain.core.usecase.BaseUseCase;
import id.dana.domain.social.ModifyRelationOperationType;
import id.dana.feeds.domain.relationship.FeedsRelationshipRepository;
import io.reactivex.Observable;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u001a\u0012\u0004\u0012\u00020\u0002\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u00030\u0001B\u0011\b\u0007\u0012\u0006\u0010\t\u001a\u00020\u0006¢\u0006\u0004\b\n\u0010\u000bR\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\b"}, d2 = {"Lid/dana/feeds/domain/relationship/interactor/ModifyFollowingRelationshipWithPublishResult;", "Lid/dana/domain/core/usecase/BaseUseCase;", "", "", "", "Lid/dana/domain/social/ModifyRelationOperationType;", "Lid/dana/feeds/domain/relationship/FeedsRelationshipRepository;", "PlaceComponentResult", "Lid/dana/feeds/domain/relationship/FeedsRelationshipRepository;", "p0", "<init>", "(Lid/dana/feeds/domain/relationship/FeedsRelationshipRepository;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ModifyFollowingRelationshipWithPublishResult extends BaseUseCase<Boolean, Map<String, ? extends ModifyRelationOperationType>> {
    private final FeedsRelationshipRepository PlaceComponentResult;

    @Override // id.dana.domain.core.usecase.BaseUseCase
    public final /* synthetic */ Observable<Boolean> buildUseCase(Map<String, ? extends ModifyRelationOperationType> map) {
        Map<String, ? extends ModifyRelationOperationType> map2 = map;
        Intrinsics.checkNotNullParameter(map2, "");
        if (map2.isEmpty()) {
            Observable<Boolean> error = Observable.error(new Exception("param must not be null"));
            Intrinsics.checkNotNullExpressionValue(error, "");
            return error;
        }
        Map.Entry entry = (Map.Entry) CollectionsKt.first(map2.entrySet());
        return this.PlaceComponentResult.BuiltInFictitiousFunctionClassFactory((String) entry.getKey(), ((ModifyRelationOperationType) entry.getValue()).getOperationType());
    }

    @Inject
    public ModifyFollowingRelationshipWithPublishResult(FeedsRelationshipRepository feedsRelationshipRepository) {
        Intrinsics.checkNotNullParameter(feedsRelationshipRepository, "");
        this.PlaceComponentResult = feedsRelationshipRepository;
    }
}
