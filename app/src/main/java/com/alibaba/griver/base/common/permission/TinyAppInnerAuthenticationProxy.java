package com.alibaba.griver.base.common.permission;

import com.alibaba.ariver.app.api.App;
import com.alibaba.ariver.kernel.common.Proxiable;

/* loaded from: classes6.dex */
public interface TinyAppInnerAuthenticationProxy extends Proxiable {
    boolean isInnerAllow(App app, String str);
}
