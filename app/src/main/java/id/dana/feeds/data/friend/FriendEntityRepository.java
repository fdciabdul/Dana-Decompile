package id.dana.feeds.data.friend;

import com.alipayplus.mobile.component.domain.model.result.BaseRpcResult;
import id.dana.data.account.repository.source.AccountEntityData;
import id.dana.data.account.repository.source.AccountEntityDataFactory;
import id.dana.data.holdlogin.v1.HoldLoginV1EntityRepository;
import id.dana.data.holdlogin.v1.HoldLoginV1Repository;
import id.dana.feeds.data.friend.source.FriendEntityData;
import id.dana.feeds.data.friend.source.FriendEntityDataFactory;
import id.dana.feeds.data.friend.source.network.mapper.FriendResponseMapperKt;
import id.dana.feeds.data.friend.source.network.request.AddFriendRequest;
import id.dana.feeds.data.friend.source.network.request.CancelAddFriendRequest;
import id.dana.feeds.data.friend.source.network.request.FriendListRequest;
import id.dana.feeds.data.friend.source.network.request.IncomingFriendRequest;
import id.dana.feeds.data.friend.source.network.response.FriendListResponse;
import id.dana.feeds.data.friend.source.network.response.FriendResponse;
import id.dana.feeds.data.friend.source.network.response.IncomingFriendRequestResponse;
import id.dana.feeds.domain.friend.FriendRepository;
import id.dana.feeds.domain.friend.model.Friend;
import id.dana.feeds.domain.friend.model.FriendRequestList;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.functions.Function;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.NotImplementedError;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Singleton
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B!\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0015\u0012\u0006\u0010\u000b\u001a\u00020\u0013\u0012\u0006\u0010\u001d\u001a\u00020\u0018¢\u0006\u0004\b\u001e\u0010\u001fJ\u001d\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u001d\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\t\u0010\bJ%\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u00052\u0006\u0010\u0004\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\r\u0010\u000eJ+\u0010\u0011\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u000f0\u00052\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0011\u0010\u0012R\u0014\u0010\t\u001a\u00020\u00138\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\u0014R\u0014\u0010\u0017\u001a\u00020\u00158\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0016R\u0014\u0010\r\u001a\u00020\u00188\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\u0019R\u0017\u0010\u0011\u001a\u0006*\u00020\u001a0\u001aX\u0082\u0080\u0002¢\u0006\u0006\n\u0004\b\r\u0010\u001bR\u0013\u0010\u0007\u001a\u00020\u001cX\u0082\u0080\u0002¢\u0006\u0006\n\u0004\b\u0017\u0010\u001b"}, d2 = {"Lid/dana/feeds/data/friend/FriendEntityRepository;", "Lid/dana/feeds/domain/friend/FriendRepository;", "Lid/dana/data/holdlogin/v1/HoldLoginV1Repository;", "", "p0", "Lio/reactivex/Observable;", "", "getAuthRequestContext", "(Ljava/lang/String;)Lio/reactivex/Observable;", "BuiltInFictitiousFunctionClassFactory", "", "p1", "Lid/dana/feeds/domain/friend/model/FriendRequestList;", "KClassImpl$Data$declaredNonStaticMembers$2", "(ILjava/lang/String;)Lio/reactivex/Observable;", "", "Lid/dana/feeds/domain/friend/model/Friend;", "PlaceComponentResult", "(Ljava/lang/String;Z)Lio/reactivex/Observable;", "Lid/dana/data/account/repository/source/AccountEntityDataFactory;", "Lid/dana/data/account/repository/source/AccountEntityDataFactory;", "Lid/dana/feeds/data/friend/source/FriendEntityDataFactory;", "Lid/dana/feeds/data/friend/source/FriendEntityDataFactory;", "MyBillsEntityDataFactory", "Lid/dana/data/holdlogin/v1/HoldLoginV1EntityRepository;", "Lid/dana/data/holdlogin/v1/HoldLoginV1EntityRepository;", "Lid/dana/data/account/repository/source/AccountEntityData;", "Lkotlin/Lazy;", "Lid/dana/feeds/data/friend/source/FriendEntityData;", "p2", "<init>", "(Lid/dana/feeds/data/friend/source/FriendEntityDataFactory;Lid/dana/data/account/repository/source/AccountEntityDataFactory;Lid/dana/data/holdlogin/v1/HoldLoginV1EntityRepository;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class FriendEntityRepository implements FriendRepository, HoldLoginV1Repository {
    private final AccountEntityDataFactory BuiltInFictitiousFunctionClassFactory;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    private final Lazy PlaceComponentResult;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private final Lazy getAuthRequestContext;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private final FriendEntityDataFactory MyBillsEntityDataFactory;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    private final HoldLoginV1EntityRepository KClassImpl$Data$declaredNonStaticMembers$2;

    @Inject
    public FriendEntityRepository(FriendEntityDataFactory friendEntityDataFactory, AccountEntityDataFactory accountEntityDataFactory, HoldLoginV1EntityRepository holdLoginV1EntityRepository) {
        Intrinsics.checkNotNullParameter(friendEntityDataFactory, "");
        Intrinsics.checkNotNullParameter(accountEntityDataFactory, "");
        Intrinsics.checkNotNullParameter(holdLoginV1EntityRepository, "");
        this.MyBillsEntityDataFactory = friendEntityDataFactory;
        this.BuiltInFictitiousFunctionClassFactory = accountEntityDataFactory;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = holdLoginV1EntityRepository;
        this.getAuthRequestContext = LazyKt.lazy(new Function0<FriendEntityData>() { // from class: id.dana.feeds.data.friend.FriendEntityRepository$networkFriendEntityData$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            /* JADX WARN: Type inference failed for: r2v0, types: [kotlin.jvm.internal.DefaultConstructorMarker, java.lang.String] */
            @Override // kotlin.jvm.functions.Function0
            public final FriendEntityData invoke() {
                FriendEntityDataFactory friendEntityDataFactory2;
                friendEntityDataFactory2 = FriendEntityRepository.this.MyBillsEntityDataFactory;
                if (Intrinsics.areEqual("network", "network")) {
                    return friendEntityDataFactory2.getAuthRequestContext;
                }
                ?? r2 = 0;
                throw new NotImplementedError(r2, 1, r2);
            }
        });
        this.PlaceComponentResult = LazyKt.lazy(new Function0<AccountEntityData>() { // from class: id.dana.feeds.data.friend.FriendEntityRepository$localAccountEntityData$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final AccountEntityData invoke() {
                AccountEntityDataFactory accountEntityDataFactory2;
                accountEntityDataFactory2 = FriendEntityRepository.this.BuiltInFictitiousFunctionClassFactory;
                return accountEntityDataFactory2.createData2("local");
            }
        });
    }

    public static /* synthetic */ Boolean PlaceComponentResult(BaseRpcResult baseRpcResult) {
        Intrinsics.checkNotNullParameter(baseRpcResult, "");
        return Boolean.valueOf(baseRpcResult.success);
    }

    public static /* synthetic */ FriendRequestList KClassImpl$Data$declaredNonStaticMembers$2(IncomingFriendRequestResponse incomingFriendRequestResponse) {
        Intrinsics.checkNotNullParameter(incomingFriendRequestResponse, "");
        return FriendResponseMapperKt.PlaceComponentResult(incomingFriendRequestResponse);
    }

    public static /* synthetic */ ObservableSource MyBillsEntityDataFactory(FriendEntityRepository friendEntityRepository, String str, boolean z, final String str2) {
        Intrinsics.checkNotNullParameter(friendEntityRepository, "");
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str2, "");
        return ((FriendEntityData) friendEntityRepository.getAuthRequestContext.getValue()).getAuthRequestContext(new FriendListRequest(CollectionsKt.listOf(str), z)).map(new Function() { // from class: id.dana.feeds.data.friend.FriendEntityRepository$$ExternalSyntheticLambda2
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return FriendEntityRepository.MyBillsEntityDataFactory(str2, (FriendListResponse) obj);
            }
        });
    }

    public static /* synthetic */ Boolean BuiltInFictitiousFunctionClassFactory(BaseRpcResult baseRpcResult) {
        Intrinsics.checkNotNullParameter(baseRpcResult, "");
        return Boolean.valueOf(baseRpcResult.success);
    }

    public static /* synthetic */ List MyBillsEntityDataFactory(String str, FriendListResponse friendListResponse) {
        ArrayList arrayList;
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(friendListResponse, "");
        List<FriendResponse> friendList = friendListResponse.getFriendList();
        if (friendList != null) {
            List<FriendResponse> list = friendList;
            ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                arrayList2.add(FriendResponseMapperKt.getAuthRequestContext((FriendResponse) it.next(), str));
            }
            arrayList = arrayList2;
        } else {
            arrayList = null;
        }
        return arrayList == null ? CollectionsKt.emptyList() : arrayList;
    }

    @Override // id.dana.feeds.domain.friend.FriendRepository
    public final Observable<Boolean> getAuthRequestContext(String p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        Observable<BaseRpcResult> BuiltInFictitiousFunctionClassFactory = ((FriendEntityData) this.getAuthRequestContext.getValue()).BuiltInFictitiousFunctionClassFactory(new AddFriendRequest(p0));
        Intrinsics.checkNotNullParameter(BuiltInFictitiousFunctionClassFactory, "");
        Observable authenticatedRequest = this.KClassImpl$Data$declaredNonStaticMembers$2.authenticatedRequest(BuiltInFictitiousFunctionClassFactory);
        Intrinsics.checkNotNullExpressionValue(authenticatedRequest, "");
        Observable<Boolean> map = authenticatedRequest.map(new Function() { // from class: id.dana.feeds.data.friend.FriendEntityRepository$$ExternalSyntheticLambda0
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return FriendEntityRepository.BuiltInFictitiousFunctionClassFactory((BaseRpcResult) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(map, "");
        return map;
    }

    @Override // id.dana.feeds.domain.friend.FriendRepository
    public final Observable<Boolean> BuiltInFictitiousFunctionClassFactory(String p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        Observable<BaseRpcResult> KClassImpl$Data$declaredNonStaticMembers$2 = ((FriendEntityData) this.getAuthRequestContext.getValue()).KClassImpl$Data$declaredNonStaticMembers$2(new CancelAddFriendRequest(p0));
        Intrinsics.checkNotNullParameter(KClassImpl$Data$declaredNonStaticMembers$2, "");
        Observable authenticatedRequest = this.KClassImpl$Data$declaredNonStaticMembers$2.authenticatedRequest(KClassImpl$Data$declaredNonStaticMembers$2);
        Intrinsics.checkNotNullExpressionValue(authenticatedRequest, "");
        Observable<Boolean> map = authenticatedRequest.map(new Function() { // from class: id.dana.feeds.data.friend.FriendEntityRepository$$ExternalSyntheticLambda3
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return FriendEntityRepository.PlaceComponentResult((BaseRpcResult) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(map, "");
        return map;
    }

    @Override // id.dana.feeds.domain.friend.FriendRepository
    public final Observable<FriendRequestList> KClassImpl$Data$declaredNonStaticMembers$2(int p0, String p1) {
        Intrinsics.checkNotNullParameter(p1, "");
        Observable<IncomingFriendRequestResponse> PlaceComponentResult = ((FriendEntityData) this.getAuthRequestContext.getValue()).PlaceComponentResult(new IncomingFriendRequest(p0, p1));
        Intrinsics.checkNotNullParameter(PlaceComponentResult, "");
        Observable authenticatedRequest = this.KClassImpl$Data$declaredNonStaticMembers$2.authenticatedRequest(PlaceComponentResult);
        Intrinsics.checkNotNullExpressionValue(authenticatedRequest, "");
        Observable<FriendRequestList> map = authenticatedRequest.map(new Function() { // from class: id.dana.feeds.data.friend.FriendEntityRepository$$ExternalSyntheticLambda4
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return FriendEntityRepository.KClassImpl$Data$declaredNonStaticMembers$2((IncomingFriendRequestResponse) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(map, "");
        return map;
    }

    @Override // id.dana.feeds.domain.friend.FriendRepository
    public final Observable<List<Friend>> PlaceComponentResult(final String p0, final boolean p1) {
        Intrinsics.checkNotNullParameter(p0, "");
        ObservableSource flatMap = ((AccountEntityData) this.PlaceComponentResult.getValue()).getUserId().flatMap(new Function() { // from class: id.dana.feeds.data.friend.FriendEntityRepository$$ExternalSyntheticLambda1
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return FriendEntityRepository.MyBillsEntityDataFactory(FriendEntityRepository.this, p0, p1, (String) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(flatMap, "");
        Intrinsics.checkNotNullParameter(flatMap, "");
        Observable<List<Friend>> authenticatedRequest = this.KClassImpl$Data$declaredNonStaticMembers$2.authenticatedRequest(flatMap);
        Intrinsics.checkNotNullExpressionValue(authenticatedRequest, "");
        return authenticatedRequest;
    }
}
