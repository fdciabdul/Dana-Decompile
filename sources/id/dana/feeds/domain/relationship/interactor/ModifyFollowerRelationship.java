package id.dana.feeds.domain.relationship.interactor;

import id.dana.domain.core.usecase.BaseUseCaseWithAnalytics;
import id.dana.domain.social.ModifyRelationOperationType;
import id.dana.domain.tracker.MixpanelRepository;
import id.dana.feeds.domain.relationship.FeedsRelationshipRepository;
import io.reactivex.Observable;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u001a\u0012\u0004\u0012\u00020\u0002\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u00030\u0001B\u0019\b\u0007\u0012\u0006\u0010\u0010\u001a\u00020\f\u0012\u0006\u0010\u0011\u001a\u00020\b¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0006\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R\u0011\u0010\u000b\u001a\u00020\bX\u0006¢\u0006\u0006\n\u0004\b\t\u0010\nR\u0014\u0010\u000f\u001a\u00020\f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000e"}, d2 = {"Lid/dana/feeds/domain/relationship/interactor/ModifyFollowerRelationship;", "Lid/dana/domain/core/usecase/BaseUseCaseWithAnalytics;", "", "", "", "Lid/dana/domain/social/ModifyRelationOperationType;", "getOperationType", "()Ljava/lang/String;", "Lid/dana/domain/tracker/MixpanelRepository;", "BuiltInFictitiousFunctionClassFactory", "Lid/dana/domain/tracker/MixpanelRepository;", "KClassImpl$Data$declaredNonStaticMembers$2", "Lid/dana/feeds/domain/relationship/FeedsRelationshipRepository;", "getAuthRequestContext", "Lid/dana/feeds/domain/relationship/FeedsRelationshipRepository;", "PlaceComponentResult", "p0", "p1", "<init>", "(Lid/dana/feeds/domain/relationship/FeedsRelationshipRepository;Lid/dana/domain/tracker/MixpanelRepository;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ModifyFollowerRelationship extends BaseUseCaseWithAnalytics<Boolean, Map<String, ? extends ModifyRelationOperationType>> {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    public final MixpanelRepository KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    private final FeedsRelationshipRepository PlaceComponentResult;

    @Override // id.dana.domain.core.usecase.BaseUseCaseWithAnalytics
    public final String getOperationType() {
        return "alipayplus.mobilewallet.socialmedia.modifyRelation";
    }

    @Override // id.dana.domain.core.usecase.BaseUseCase
    public final /* synthetic */ Observable buildUseCase(Object obj) {
        Map map = (Map) obj;
        Intrinsics.checkNotNullParameter(map, "");
        if (map.isEmpty()) {
            Observable error = Observable.error(new Exception("param must not be null"));
            Intrinsics.checkNotNullExpressionValue(error, "");
            return error;
        }
        Map.Entry entry = (Map.Entry) CollectionsKt.first(map.entrySet());
        return this.PlaceComponentResult.MyBillsEntityDataFactory((String) entry.getKey(), ((ModifyRelationOperationType) entry.getValue()).getOperationType());
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @Inject
    public ModifyFollowerRelationship(FeedsRelationshipRepository feedsRelationshipRepository, MixpanelRepository mixpanelRepository) {
        super(mixpanelRepository);
        Intrinsics.checkNotNullParameter(feedsRelationshipRepository, "");
        Intrinsics.checkNotNullParameter(mixpanelRepository, "");
        this.PlaceComponentResult = feedsRelationshipRepository;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = mixpanelRepository;
    }
}
