package com.alibaba.ariver.kernel.common.service;

import com.alibaba.ariver.kernel.common.Proxiable;

/* loaded from: classes2.dex */
public interface RVAccountService extends Proxiable {
    String getNick();

    String getUserAvatar();

    String getUserId();

    boolean isLogin();
}
