package id.dana.feeds.data.notification;

import com.alipayplus.mobile.component.domain.model.result.BaseRpcResult;
import id.dana.data.holdlogin.v1.HoldLoginV1EntityRepository;
import id.dana.data.holdlogin.v1.HoldLoginV1Repository;
import id.dana.feeds.data.notification.source.FeedsNotificationDataFactory;
import id.dana.feeds.data.notification.source.network.NetworkFeedsNotificationEntityData;
import id.dana.feeds.data.notification.source.network.response.FetchFeedNotificationCountResponse;
import id.dana.feeds.domain.notification.FeedsNotificationRepository;
import io.reactivex.Observable;
import io.reactivex.functions.Function;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u0002B\u0019\b\u0007\u0012\u0006\u0010\t\u001a\u00020\r\u0012\u0006\u0010\u0013\u001a\u00020\u0010¢\u0006\u0004\b\u0014\u0010\u0015J\u0015\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J#\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\u00032\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u0016¢\u0006\u0004\b\u000b\u0010\fR\u0014\u0010\u000b\u001a\u00020\r8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0012\u001a\u00020\u00108\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\u0011"}, d2 = {"Lid/dana/feeds/data/notification/FeedsNotificationEntityRepository;", "Lid/dana/feeds/domain/notification/FeedsNotificationRepository;", "Lid/dana/data/holdlogin/v1/HoldLoginV1Repository;", "Lio/reactivex/Observable;", "", "KClassImpl$Data$declaredNonStaticMembers$2", "()Lio/reactivex/Observable;", "", "", "p0", "", "PlaceComponentResult", "(Ljava/util/List;)Lio/reactivex/Observable;", "Lid/dana/feeds/data/notification/source/FeedsNotificationDataFactory;", "getAuthRequestContext", "Lid/dana/feeds/data/notification/source/FeedsNotificationDataFactory;", "Lid/dana/data/holdlogin/v1/HoldLoginV1EntityRepository;", "Lid/dana/data/holdlogin/v1/HoldLoginV1EntityRepository;", "BuiltInFictitiousFunctionClassFactory", "p1", "<init>", "(Lid/dana/feeds/data/notification/source/FeedsNotificationDataFactory;Lid/dana/data/holdlogin/v1/HoldLoginV1EntityRepository;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class FeedsNotificationEntityRepository implements FeedsNotificationRepository, HoldLoginV1Repository {

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private final HoldLoginV1EntityRepository BuiltInFictitiousFunctionClassFactory;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    private final FeedsNotificationDataFactory PlaceComponentResult;

    @Inject
    public FeedsNotificationEntityRepository(FeedsNotificationDataFactory feedsNotificationDataFactory, HoldLoginV1EntityRepository holdLoginV1EntityRepository) {
        Intrinsics.checkNotNullParameter(feedsNotificationDataFactory, "");
        Intrinsics.checkNotNullParameter(holdLoginV1EntityRepository, "");
        this.PlaceComponentResult = feedsNotificationDataFactory;
        this.BuiltInFictitiousFunctionClassFactory = holdLoginV1EntityRepository;
    }

    public static /* synthetic */ Boolean getAuthRequestContext(BaseRpcResult baseRpcResult) {
        Intrinsics.checkNotNullParameter(baseRpcResult, "");
        return Boolean.valueOf(baseRpcResult.success);
    }

    public static /* synthetic */ Integer MyBillsEntityDataFactory(FetchFeedNotificationCountResponse fetchFeedNotificationCountResponse) {
        Intrinsics.checkNotNullParameter(fetchFeedNotificationCountResponse, "");
        return Integer.valueOf(fetchFeedNotificationCountResponse.getNotificationCount());
    }

    @Override // id.dana.feeds.domain.notification.FeedsNotificationRepository
    public final Observable<Integer> KClassImpl$Data$declaredNonStaticMembers$2() {
        FeedsNotificationDataFactory feedsNotificationDataFactory = this.PlaceComponentResult;
        Observable map = new NetworkFeedsNotificationEntityData(feedsNotificationDataFactory.getAuthRequestContext, feedsNotificationDataFactory.BuiltInFictitiousFunctionClassFactory, feedsNotificationDataFactory.PlaceComponentResult, feedsNotificationDataFactory.KClassImpl$Data$declaredNonStaticMembers$2).PlaceComponentResult().map(new Function() { // from class: id.dana.feeds.data.notification.FeedsNotificationEntityRepository$$ExternalSyntheticLambda0
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return FeedsNotificationEntityRepository.MyBillsEntityDataFactory((FetchFeedNotificationCountResponse) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(map, "");
        return map;
    }

    @Override // id.dana.feeds.domain.notification.FeedsNotificationRepository
    public final Observable<Boolean> PlaceComponentResult(List<String> p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        FeedsNotificationDataFactory feedsNotificationDataFactory = this.PlaceComponentResult;
        Observable map = new NetworkFeedsNotificationEntityData(feedsNotificationDataFactory.getAuthRequestContext, feedsNotificationDataFactory.BuiltInFictitiousFunctionClassFactory, feedsNotificationDataFactory.PlaceComponentResult, feedsNotificationDataFactory.KClassImpl$Data$declaredNonStaticMembers$2).MyBillsEntityDataFactory(p0).map(new Function() { // from class: id.dana.feeds.data.notification.FeedsNotificationEntityRepository$$ExternalSyntheticLambda1
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return FeedsNotificationEntityRepository.getAuthRequestContext((BaseRpcResult) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(map, "");
        return map;
    }
}
