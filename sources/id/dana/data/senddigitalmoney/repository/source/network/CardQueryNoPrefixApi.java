package id.dana.data.senddigitalmoney.repository.source.network;

import id.dana.data.senddigitalmoney.repository.model.request.CardPrefixQueryRequest;
import id.dana.data.senddigitalmoney.repository.model.result.CardPrefixQueryResult;
import id.dana.network.base.ResultResponse;
import io.reactivex.Observable;
import kotlin.Metadata;
import retrofit2.http.Body;
import retrofit2.http.POST;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J%\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u00042\b\b\u0001\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0007\u0010\bø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/data/senddigitalmoney/repository/source/network/CardQueryNoPrefixApi;", "", "Lid/dana/data/senddigitalmoney/repository/model/request/CardPrefixQueryRequest;", "p0", "Lio/reactivex/Observable;", "Lid/dana/network/base/ResultResponse;", "Lid/dana/data/senddigitalmoney/repository/model/result/CardPrefixQueryResult;", "PlaceComponentResult", "(Lid/dana/data/senddigitalmoney/repository/model/request/CardPrefixQueryRequest;)Lio/reactivex/Observable;"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public interface CardQueryNoPrefixApi {
    @POST("/wallet/api/alipayplus.home.user.biztransfer.queryCardNoPrefix.json")
    Observable<ResultResponse<CardPrefixQueryResult>> PlaceComponentResult(@Body CardPrefixQueryRequest p0);
}
