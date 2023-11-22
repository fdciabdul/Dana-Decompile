package id.dana.feeds.domain.relationship.interactor;

import id.dana.domain.core.usecase.BaseUseCase;
import id.dana.feeds.domain.relationship.FeedsRelationshipRepository;
import id.dana.feeds.domain.relationship.model.RelationshipItem;
import io.reactivex.Observable;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0011\b\u0007\u0012\u0006\u0010\b\u001a\u00020\u0004¢\u0006\u0004\b\t\u0010\nR\u0014\u0010\u0007\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0006"}, d2 = {"Lid/dana/feeds/domain/relationship/interactor/ObserveProfileMuteUnmuteStatus;", "Lid/dana/domain/core/usecase/BaseUseCase;", "Lid/dana/feeds/domain/relationship/model/RelationshipItem;", "", "Lid/dana/feeds/domain/relationship/FeedsRelationshipRepository;", "PlaceComponentResult", "Lid/dana/feeds/domain/relationship/FeedsRelationshipRepository;", "KClassImpl$Data$declaredNonStaticMembers$2", "p0", "<init>", "(Lid/dana/feeds/domain/relationship/FeedsRelationshipRepository;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ObserveProfileMuteUnmuteStatus extends BaseUseCase<RelationshipItem, String> {

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private final FeedsRelationshipRepository KClassImpl$Data$declaredNonStaticMembers$2;

    @Override // id.dana.domain.core.usecase.BaseUseCase
    public final /* synthetic */ Observable<RelationshipItem> buildUseCase(String str) {
        Observable<RelationshipItem> KClassImpl$Data$declaredNonStaticMembers$2;
        String str2 = str;
        Intrinsics.checkNotNullParameter(str2, "");
        KClassImpl$Data$declaredNonStaticMembers$2 = this.KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2(str2, true);
        return KClassImpl$Data$declaredNonStaticMembers$2;
    }

    @Inject
    public ObserveProfileMuteUnmuteStatus(FeedsRelationshipRepository feedsRelationshipRepository) {
        Intrinsics.checkNotNullParameter(feedsRelationshipRepository, "");
        this.KClassImpl$Data$declaredNonStaticMembers$2 = feedsRelationshipRepository;
    }
}
