package id.dana.feeds.data.detail.source;

import com.alipayplus.mobile.component.domain.model.result.BaseRpcResult;
import id.dana.feeds.data.detail.source.network.response.AddActivityCommentResponse;
import id.dana.feeds.data.detail.source.network.response.FetchActivityCommentsResponse;
import io.reactivex.Observable;
import kotlin.Metadata;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J7\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0002H&¢\u0006\u0004\b\t\u0010\nJ\u001d\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00072\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\f\u0010\rJ7\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u000eH&¢\u0006\u0004\b\u0010\u0010\u0011J%\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H&¢\u0006\u0004\b\u0012\u0010\u0013ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/feeds/data/detail/source/FeedsDetailData;", "", "", "p0", "p1", "p2", "p3", "Lio/reactivex/Observable;", "Lid/dana/feeds/data/detail/source/network/response/AddActivityCommentResponse;", "MyBillsEntityDataFactory", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lio/reactivex/Observable;", "Lcom/alipayplus/mobile/component/domain/model/result/BaseRpcResult;", "KClassImpl$Data$declaredNonStaticMembers$2", "(Ljava/lang/String;)Lio/reactivex/Observable;", "", "Lid/dana/feeds/data/detail/source/network/response/FetchActivityCommentsResponse;", "getAuthRequestContext", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)Lio/reactivex/Observable;", "PlaceComponentResult", "(Ljava/lang/String;Ljava/lang/String;)Lio/reactivex/Observable;"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public interface FeedsDetailData {
    Observable<BaseRpcResult> KClassImpl$Data$declaredNonStaticMembers$2(String p0);

    Observable<AddActivityCommentResponse> MyBillsEntityDataFactory(String p0, String p1, String p2, String p3);

    Observable<BaseRpcResult> PlaceComponentResult(String p0, String p1);

    Observable<FetchActivityCommentsResponse> getAuthRequestContext(String p0, String p1, String p2, Integer p3);
}
