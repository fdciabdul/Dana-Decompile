package id.dana.data.login.source.network;

import id.dana.data.foundation.DanaErrorCode;
import id.dana.data.foundation.RpcException;
import id.dana.network.base.ExceptionParser;
import id.dana.network.response.login.LoginRpcResult;
import io.reactivex.Observable;
import java.util.List;

/* loaded from: classes4.dex */
public class HoldLoginExceptionParser extends ExceptionParser<LoginRpcResult> {
    private List<String> errorCodes;

    public HoldLoginExceptionParser(List<String> list) {
        this.errorCodes = list;
    }

    @Override // id.dana.network.base.ExceptionParser, io.reactivex.functions.Function
    public Observable<LoginRpcResult> apply(LoginRpcResult loginRpcResult) throws Exception {
        if (isErrorCodeShouldBypassForceLogout(loginRpcResult.errorCode).booleanValue()) {
            return Observable.just(loginRpcResult);
        }
        if (!loginRpcResult.success) {
            if (DanaErrorCode.isHoldLoginError(loginRpcResult)) {
                return Observable.error(new HoldLoginException(loginRpcResult));
            }
            return Observable.error(new RpcException(loginRpcResult.errorCode, loginRpcResult.errorMessage));
        }
        return super.apply((HoldLoginExceptionParser) loginRpcResult);
    }

    private Boolean isErrorCodeShouldBypassForceLogout(String str) {
        return Boolean.valueOf((str == null || str.isEmpty() || this.errorCodes.contains(str)) ? false : true);
    }
}
