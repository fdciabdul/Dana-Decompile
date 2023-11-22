package com.alibaba.griver.base.common.account;

import com.alibaba.ariver.kernel.common.service.RVAccountService;

/* loaded from: classes6.dex */
public class GriverRVAccountServiceImpl implements RVAccountService {
    @Override // com.alibaba.ariver.kernel.common.service.RVAccountService
    public String getNick() {
        return null;
    }

    @Override // com.alibaba.ariver.kernel.common.service.RVAccountService
    public String getUserAvatar() {
        return null;
    }

    @Override // com.alibaba.ariver.kernel.common.service.RVAccountService
    public boolean isLogin() {
        return false;
    }

    @Override // com.alibaba.ariver.kernel.common.service.RVAccountService
    public String getUserId() {
        return GriverAccount.getUserId();
    }
}
