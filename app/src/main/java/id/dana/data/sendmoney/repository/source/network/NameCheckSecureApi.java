package id.dana.data.sendmoney.repository.source.network;

import id.dana.data.sendmoney.repository.source.network.request.WithdrawNameCheckRequest;
import id.dana.data.sendmoney.repository.source.network.result.WithdrawNameCheckResult;
import id.dana.network.base.ResultResponse;
import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.POST;
import retrofit2.http.Query;

/* loaded from: classes2.dex */
public interface NameCheckSecureApi {
    @POST("/wallet/api/alipayplus.mobilewallet.withdraw.namecheck.json")
    Observable<ResultResponse<WithdrawNameCheckResult>> nameCheck(@Query("ctoken") String str, @Body WithdrawNameCheckRequest withdrawNameCheckRequest);
}
