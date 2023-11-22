package com.alipayplus.mobile.prototype.user.rpc.login;

import com.alipay.mobile.framework.service.annotation.OperationType;
import com.alipay.mobile.framework.service.annotation.SignCheck;
import com.alipayplus.mobile.prototype.user.rpc.request.LoginRpcRequest;
import com.alipayplus.mobile.prototype.user.rpc.request.LogoutRpcRequest;
import com.alipayplus.mobile.prototype.user.rpc.result.LoginRpcResult;
import com.alipayplus.mobile.prototype.user.rpc.result.LogoutRpcResult;

/* loaded from: classes7.dex */
public interface LoginRpcFacade {
    @OperationType("alipayplus.mobilewallet.user.login")
    @SignCheck
    LoginRpcResult login(LoginRpcRequest loginRpcRequest);

    @OperationType("alipayplus.mobilewallet.user.logout")
    @SignCheck
    LogoutRpcResult logout(LogoutRpcRequest logoutRpcRequest);
}
