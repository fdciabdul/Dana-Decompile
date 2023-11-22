package id.dana.feeds.domain.friend.interactor;

import id.dana.domain.core.usecase.BaseUseCaseWithAnalytics;
import id.dana.domain.tracker.MixpanelRepository;
import id.dana.feeds.domain.friend.FriendRepository;
import id.dana.feeds.domain.friend.model.Friend;
import io.reactivex.Observable;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u0004\u0012\u00020\u00040\u0001:\u0001\u0013B\u0019\b\u0007\u0012\u0006\u0010\u000f\u001a\u00020\b\u0012\u0006\u0010\u0010\u001a\u00020\u000b¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\nR\u0014\u0010\u000e\u001a\u00020\u000b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\r"}, d2 = {"Lid/dana/feeds/domain/friend/interactor/FindFriends;", "Lid/dana/domain/core/usecase/BaseUseCaseWithAnalytics;", "", "Lid/dana/feeds/domain/friend/model/Friend;", "Lid/dana/feeds/domain/friend/interactor/FindFriends$Params;", "", "getOperationType", "()Ljava/lang/String;", "Lid/dana/feeds/domain/friend/FriendRepository;", "MyBillsEntityDataFactory", "Lid/dana/feeds/domain/friend/FriendRepository;", "Lid/dana/domain/tracker/MixpanelRepository;", "KClassImpl$Data$declaredNonStaticMembers$2", "Lid/dana/domain/tracker/MixpanelRepository;", "BuiltInFictitiousFunctionClassFactory", "p0", "p1", "<init>", "(Lid/dana/feeds/domain/friend/FriendRepository;Lid/dana/domain/tracker/MixpanelRepository;)V", "Params"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class FindFriends extends BaseUseCaseWithAnalytics<List<? extends Friend>, Params> {

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    private final MixpanelRepository BuiltInFictitiousFunctionClassFactory;
    private final FriendRepository MyBillsEntityDataFactory;

    @Override // id.dana.domain.core.usecase.BaseUseCaseWithAnalytics
    public final String getOperationType() {
        return "id.dana.feedengine.friendship.findFriends";
    }

    @Override // id.dana.domain.core.usecase.BaseUseCase
    public final /* synthetic */ Observable buildUseCase(Object obj) {
        Params params = (Params) obj;
        Intrinsics.checkNotNullParameter(params, "");
        return this.MyBillsEntityDataFactory.PlaceComponentResult(params.MyBillsEntityDataFactory, params.getPlaceComponentResult());
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @Inject
    public FindFriends(FriendRepository friendRepository, MixpanelRepository mixpanelRepository) {
        super(mixpanelRepository);
        Intrinsics.checkNotNullParameter(friendRepository, "");
        Intrinsics.checkNotNullParameter(mixpanelRepository, "");
        this.MyBillsEntityDataFactory = friendRepository;
        this.BuiltInFictitiousFunctionClassFactory = mixpanelRepository;
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\n\u001a\u00020\b\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0002¢\u0006\u0004\b\f\u0010\rR\u0017\u0010\u0007\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0005\u001a\u00020\bX\u0007¢\u0006\u0006\n\u0004\b\u0007\u0010\t"}, d2 = {"Lid/dana/feeds/domain/friend/interactor/FindFriends$Params;", "", "", "BuiltInFictitiousFunctionClassFactory", "Z", "MyBillsEntityDataFactory", "()Z", "PlaceComponentResult", "", "Ljava/lang/String;", "p0", "p1", "<init>", "(Ljava/lang/String;Z)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Params {

        /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
        private final boolean PlaceComponentResult;

        /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
        final String MyBillsEntityDataFactory;

        public Params(String str, boolean z) {
            Intrinsics.checkNotNullParameter(str, "");
            this.MyBillsEntityDataFactory = str;
            this.PlaceComponentResult = z;
        }

        @JvmName(name = "MyBillsEntityDataFactory")
        /* renamed from: MyBillsEntityDataFactory  reason: from getter */
        public final boolean getPlaceComponentResult() {
            return this.PlaceComponentResult;
        }
    }
}
