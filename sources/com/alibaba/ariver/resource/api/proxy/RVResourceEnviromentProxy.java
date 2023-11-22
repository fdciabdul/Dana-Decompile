package com.alibaba.ariver.resource.api.proxy;

import com.alibaba.ariver.kernel.common.Proxiable;

/* loaded from: classes6.dex */
public interface RVResourceEnviromentProxy extends Proxiable {
    String getConfigVariable();

    String getLegacySignPublicKey(String str);

    String getNewSignPublicKey(String str);
}
