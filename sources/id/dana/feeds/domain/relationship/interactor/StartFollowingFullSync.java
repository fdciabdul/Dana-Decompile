package id.dana.feeds.domain.relationship.interactor;

import id.dana.domain.social.Result;
import id.dana.domain.social.core.SingleUseCase;
import id.dana.feeds.domain.relationship.FeedsRelationshipRepository;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.Boxing;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0011\b\u0007\u0012\u0006\u0010\n\u001a\u00020\u0006¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u0004\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u0014\u0010\t\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\b"}, d2 = {"Lid/dana/feeds/domain/relationship/interactor/StartFollowingFullSync;", "Lid/dana/domain/social/core/SingleUseCase;", "", "", "MyBillsEntityDataFactory", "()Z", "Lid/dana/feeds/domain/relationship/FeedsRelationshipRepository;", "BuiltInFictitiousFunctionClassFactory", "Lid/dana/feeds/domain/relationship/FeedsRelationshipRepository;", "PlaceComponentResult", "p0", "<init>", "(Lid/dana/feeds/domain/relationship/FeedsRelationshipRepository;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class StartFollowingFullSync extends SingleUseCase<Unit, Boolean> {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    private final FeedsRelationshipRepository PlaceComponentResult;

    @Override // id.dana.domain.social.core.BaseUseCase
    public final /* synthetic */ Object buildUseCase(Object obj, Continuation continuation) {
        Unit unit = (Unit) obj;
        if (MyBillsEntityDataFactory()) {
            FeedsRelationshipRepository feedsRelationshipRepository = this.PlaceComponentResult;
            int DatabaseTableConfigUtil = feedsRelationshipRepository.DatabaseTableConfigUtil();
            boolean z = false;
            while (!z) {
                DatabaseTableConfigUtil++;
                z = feedsRelationshipRepository.MyBillsEntityDataFactory(DatabaseTableConfigUtil).getPaginator().checkIfLastPage();
            }
            feedsRelationshipRepository.isLayoutRequested();
        } else {
            FeedsRelationshipRepository feedsRelationshipRepository2 = this.PlaceComponentResult;
            boolean scheduleImpl = feedsRelationshipRepository2.scheduleImpl();
            int moveToNextValue = feedsRelationshipRepository2.moveToNextValue();
            while (!scheduleImpl) {
                moveToNextValue++;
                scheduleImpl = feedsRelationshipRepository2.PlaceComponentResult(moveToNextValue).getPaginator().checkIfLastPage();
            }
            feedsRelationshipRepository2.NetworkUserEntityData$$ExternalSyntheticLambda8();
        }
        return new Result.Success(Boxing.boxBoolean(true));
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /* JADX WARN: Type inference failed for: r0v1, types: [kotlin.jvm.internal.DefaultConstructorMarker, kotlinx.coroutines.CoroutineDispatcher] */
    @javax.inject.Inject
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public StartFollowingFullSync(id.dana.feeds.domain.relationship.FeedsRelationshipRepository r3) {
        /*
            r2 = this;
            java.lang.String r0 = ""
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            r0 = 0
            r1 = 3
            r2.<init>(r0, r0, r1, r0)
            r2.PlaceComponentResult = r3
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.feeds.domain.relationship.interactor.StartFollowingFullSync.<init>(id.dana.feeds.domain.relationship.FeedsRelationshipRepository):void");
    }

    private final boolean MyBillsEntityDataFactory() {
        FeedsRelationshipRepository feedsRelationshipRepository = this.PlaceComponentResult;
        return feedsRelationshipRepository.scheduleImpl() && feedsRelationshipRepository.initRecordTimeStamp() > 0;
    }
}
