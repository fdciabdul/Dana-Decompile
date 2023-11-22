package id.dana.feeds.data.share.source;

import com.alipayplus.mobile.component.domain.model.result.BaseRpcResult;
import id.dana.feeds.data.share.source.network.request.CreateActivityRequest;
import id.dana.feeds.data.share.source.network.request.FetchShareableActivitiesRequest;
import id.dana.feeds.data.share.source.network.response.FetchShareableActivitiesResponse;
import id.dana.feeds.data.share.source.network.response.PreviewActivityResult;
import io.reactivex.Observable;
import java.util.Map;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010$\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0006\u0010\u0007J\u001d\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\u00042\u0006\u0010\u0003\u001a\u00020\bH&¢\u0006\u0004\b\n\u0010\u000bJS\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00140\u00042\u0006\u0010\u0003\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\f2\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00010\u000f2\u0006\u0010\u0012\u001a\u00020\u00112\b\u0010\u0013\u001a\u0004\u0018\u00010\fH&¢\u0006\u0004\b\u0015\u0010\u0016ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/feeds/data/share/source/FeedsShareData;", "", "Lid/dana/feeds/data/share/source/network/request/CreateActivityRequest;", "p0", "Lio/reactivex/Observable;", "Lcom/alipayplus/mobile/component/domain/model/result/BaseRpcResult;", "PlaceComponentResult", "(Lid/dana/feeds/data/share/source/network/request/CreateActivityRequest;)Lio/reactivex/Observable;", "Lid/dana/feeds/data/share/source/network/request/FetchShareableActivitiesRequest;", "Lid/dana/feeds/data/share/source/network/response/FetchShareableActivitiesResponse;", "BuiltInFictitiousFunctionClassFactory", "(Lid/dana/feeds/data/share/source/network/request/FetchShareableActivitiesRequest;)Lio/reactivex/Observable;", "", "p1", "p2", "", "p3", "", "p4", "p5", "Lid/dana/feeds/data/share/source/network/response/PreviewActivityResult;", "KClassImpl$Data$declaredNonStaticMembers$2", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;ILjava/lang/String;)Lio/reactivex/Observable;"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public interface FeedsShareData {
    Observable<FetchShareableActivitiesResponse> BuiltInFictitiousFunctionClassFactory(FetchShareableActivitiesRequest p0);

    Observable<PreviewActivityResult> KClassImpl$Data$declaredNonStaticMembers$2(String p0, String p1, String p2, Map<String, ? extends Object> p3, int p4, String p5);

    Observable<BaseRpcResult> PlaceComponentResult(CreateActivityRequest p0);
}
