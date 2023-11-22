package id.dana.feeds.data.notification.source;

import com.alipayplus.mobile.component.domain.model.result.BaseRpcResult;
import id.dana.feeds.data.notification.source.network.response.FetchFeedNotificationCountResponse;
import io.reactivex.Observable;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0015\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H&¢\u0006\u0004\b\u0004\u0010\u0005J#\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\u00022\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H&¢\u0006\u0004\b\n\u0010\u000bø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/feeds/data/notification/source/FeedsNotificationData;", "", "Lio/reactivex/Observable;", "Lid/dana/feeds/data/notification/source/network/response/FetchFeedNotificationCountResponse;", "PlaceComponentResult", "()Lio/reactivex/Observable;", "", "", "p0", "Lcom/alipayplus/mobile/component/domain/model/result/BaseRpcResult;", "MyBillsEntityDataFactory", "(Ljava/util/List;)Lio/reactivex/Observable;"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public interface FeedsNotificationData {
    Observable<BaseRpcResult> MyBillsEntityDataFactory(List<String> p0);

    Observable<FetchFeedNotificationCountResponse> PlaceComponentResult();
}
