package id.dana.data.user.source.mock;

import id.dana.data.user.source.network.UserInfoRpcFacade;
import id.dana.data.user.source.network.result.UserInfoRpcResult;
import id.dana.network.base.ResultResponse;
import io.reactivex.Observable;
import kotlin.Metadata;
import retrofit2.http.GET;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u001b\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0002H'¢\u0006\u0004\b\u0005\u0010\u0006J\u001b\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0002H'¢\u0006\u0004\b\u0007\u0010\u0006ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/data/user/source/mock/MockUserEntityDataApi;", "", "Lio/reactivex/Observable;", "Lid/dana/network/base/ResultResponse;", "Lid/dana/data/user/source/network/result/UserInfoRpcResult;", "getBalance", "()Lio/reactivex/Observable;", "getUserInfo"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes8.dex */
public interface MockUserEntityDataApi {
    @GET(UserInfoRpcFacade.MOBILE_WALLET_USER_INFO_BALANCE)
    Observable<ResultResponse<UserInfoRpcResult>> getBalance();

    @GET("alipayplus.mobilewallet.wallet.user.info")
    Observable<ResultResponse<UserInfoRpcResult>> getUserInfo();
}
