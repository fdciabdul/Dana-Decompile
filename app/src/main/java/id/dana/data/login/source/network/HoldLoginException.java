package id.dana.data.login.source.network;

import id.dana.network.base.BaseRpcResultAphome;
import id.dana.network.exception.NetworkException;
import id.dana.network.response.login.LoginRpcResult;

/* loaded from: classes2.dex */
public class HoldLoginException extends NetworkException {
    public HoldLoginException(LoginRpcResult loginRpcResult) {
        super((BaseRpcResultAphome) loginRpcResult);
    }
}
