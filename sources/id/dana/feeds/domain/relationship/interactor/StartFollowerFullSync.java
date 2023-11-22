package id.dana.feeds.domain.relationship.interactor;

import id.dana.domain.social.Result;
import id.dana.domain.social.core.SingleUseCase;
import id.dana.feeds.domain.relationship.FeedsRelationshipRepository;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.Boxing;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0011\b\u0007\u0012\u0006\u0010\t\u001a\u00020\u0006¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\u0004\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\b"}, d2 = {"Lid/dana/feeds/domain/relationship/interactor/StartFollowerFullSync;", "Lid/dana/domain/social/core/SingleUseCase;", "", "", "KClassImpl$Data$declaredNonStaticMembers$2", "()Z", "Lid/dana/feeds/domain/relationship/FeedsRelationshipRepository;", "PlaceComponentResult", "Lid/dana/feeds/domain/relationship/FeedsRelationshipRepository;", "p0", "<init>", "(Lid/dana/feeds/domain/relationship/FeedsRelationshipRepository;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class StartFollowerFullSync extends SingleUseCase<Unit, Boolean> {
    private final FeedsRelationshipRepository PlaceComponentResult;

    @Override // id.dana.domain.social.core.BaseUseCase
    public final /* synthetic */ Object buildUseCase(Object obj, Continuation continuation) {
        Unit unit = (Unit) obj;
        if (KClassImpl$Data$declaredNonStaticMembers$2()) {
            FeedsRelationshipRepository feedsRelationshipRepository = this.PlaceComponentResult;
            int NetworkUserEntityData$$ExternalSyntheticLambda0 = feedsRelationshipRepository.NetworkUserEntityData$$ExternalSyntheticLambda0();
            boolean z = false;
            while (!z) {
                NetworkUserEntityData$$ExternalSyntheticLambda0++;
                z = feedsRelationshipRepository.getAuthRequestContext(NetworkUserEntityData$$ExternalSyntheticLambda0).getPaginator().checkIfLastPage();
            }
            feedsRelationshipRepository.NetworkUserEntityData$$ExternalSyntheticLambda7();
        } else {
            FeedsRelationshipRepository feedsRelationshipRepository2 = this.PlaceComponentResult;
            boolean PlaceComponentResult = feedsRelationshipRepository2.PlaceComponentResult();
            int MyBillsEntityDataFactory = feedsRelationshipRepository2.MyBillsEntityDataFactory();
            while (!PlaceComponentResult) {
                MyBillsEntityDataFactory++;
                PlaceComponentResult = feedsRelationshipRepository2.BuiltInFictitiousFunctionClassFactory(MyBillsEntityDataFactory).getPaginator().checkIfLastPage();
            }
            feedsRelationshipRepository2.NetworkUserEntityData$$ExternalSyntheticLambda1();
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
    public StartFollowerFullSync(id.dana.feeds.domain.relationship.FeedsRelationshipRepository r3) {
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
        throw new UnsupportedOperationException("Method not decompiled: id.dana.feeds.domain.relationship.interactor.StartFollowerFullSync.<init>(id.dana.feeds.domain.relationship.FeedsRelationshipRepository):void");
    }

    private final boolean KClassImpl$Data$declaredNonStaticMembers$2() {
        FeedsRelationshipRepository feedsRelationshipRepository = this.PlaceComponentResult;
        return feedsRelationshipRepository.PlaceComponentResult() && feedsRelationshipRepository.getErrorConfigVersion() > 0;
    }
}
