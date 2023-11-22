package id.dana.feeds.domain.friend.interactor;

import id.dana.domain.core.usecase.BaseUseCase;
import id.dana.feeds.domain.friend.FriendRepository;
import id.dana.feeds.domain.friend.model.FriendRequestList;
import io.reactivex.Observable;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u000bB\u0011\b\u0007\u0012\u0006\u0010\b\u001a\u00020\u0004¢\u0006\u0004\b\t\u0010\nR\u0014\u0010\u0007\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0006"}, d2 = {"Lid/dana/feeds/domain/friend/interactor/FetchFriendRequestList;", "Lid/dana/domain/core/usecase/BaseUseCase;", "Lid/dana/feeds/domain/friend/model/FriendRequestList;", "Lid/dana/feeds/domain/friend/interactor/FetchFriendRequestList$Params;", "Lid/dana/feeds/domain/friend/FriendRepository;", "PlaceComponentResult", "Lid/dana/feeds/domain/friend/FriendRepository;", "MyBillsEntityDataFactory", "p0", "<init>", "(Lid/dana/feeds/domain/friend/FriendRepository;)V", "Params"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class FetchFriendRequestList extends BaseUseCase<FriendRequestList, Params> {

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private final FriendRepository MyBillsEntityDataFactory;

    @Override // id.dana.domain.core.usecase.BaseUseCase
    public final /* synthetic */ Observable<FriendRequestList> buildUseCase(Params params) {
        Params params2 = params;
        Intrinsics.checkNotNullParameter(params2, "");
        return this.MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2(params2.BuiltInFictitiousFunctionClassFactory, params2.PlaceComponentResult);
    }

    @Inject
    public FetchFriendRequestList(FriendRepository friendRepository) {
        Intrinsics.checkNotNullParameter(friendRepository, "");
        this.MyBillsEntityDataFactory = friendRepository;
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\n\u001a\u00020\u0006\u0012\u0006\u0010\u000b\u001a\u00020\u0002¢\u0006\u0004\b\f\u0010\rR\u0011\u0010\u0005\u001a\u00020\u0002X\u0006¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0011\u0010\t\u001a\u00020\u0006X\u0006¢\u0006\u0006\n\u0004\b\u0007\u0010\b"}, d2 = {"Lid/dana/feeds/domain/friend/interactor/FetchFriendRequestList$Params;", "", "", "getAuthRequestContext", "Ljava/lang/String;", "PlaceComponentResult", "", "MyBillsEntityDataFactory", "I", "BuiltInFictitiousFunctionClassFactory", "p0", "p1", "<init>", "(ILjava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Params {

        /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
        final int BuiltInFictitiousFunctionClassFactory;

        /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
        final String PlaceComponentResult;

        public Params(int i, String str) {
            Intrinsics.checkNotNullParameter(str, "");
            this.BuiltInFictitiousFunctionClassFactory = i;
            this.PlaceComponentResult = str;
        }
    }
}
