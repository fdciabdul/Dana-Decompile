package com.alipayplus.mobile.prototype.user.rpc.request;

import com.alipayplus.mobile.component.domain.model.request.BaseRpcRequest;
import java.io.Serializable;

/* loaded from: classes7.dex */
public class LoginRpcRequest extends BaseRpcRequest implements Serializable {
    public String credentials;
    public String loginId;
    public String loginIdType;
    public String loginType;
    public String securityId;
    public String verifyAnswer;
    public String verifyMethod;
}
