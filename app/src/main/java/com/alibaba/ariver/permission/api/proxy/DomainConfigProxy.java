package com.alibaba.ariver.permission.api.proxy;

import com.alibaba.ariver.kernel.common.Proxiable;

/* loaded from: classes6.dex */
public interface DomainConfigProxy extends Proxiable {
    boolean isAliDomains(String str);

    boolean isAlipayDomains(String str);

    boolean isPartnerDomains(String str);

    boolean isRpcDomains(String str);

    boolean isSeriousAliDomains(String str);
}
