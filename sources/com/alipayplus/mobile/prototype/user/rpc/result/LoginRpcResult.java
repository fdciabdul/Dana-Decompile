package com.alipayplus.mobile.prototype.user.rpc.result;

import com.alipayplus.mobile.component.domain.model.result.BaseRpcResult;
import com.alipayplus.mobile.component.domain.model.user.UserInfo;
import java.io.Serializable;
import java.util.List;

/* loaded from: classes7.dex */
public class LoginRpcResult extends BaseRpcResult implements Serializable {
    public String clientKey;
    public int failedCount;
    public int lockedExpireSeconds;
    public int maxFailedCount;
    public String securityId;
    public String sessionId;
    public String userId;
    public UserInfo userInfo;
    public boolean userInfoCompleted;
    public List<String> verificationMethods;
}
