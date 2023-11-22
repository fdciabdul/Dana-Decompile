package com.alibaba.griver.base.common.permission;

import android.text.TextUtils;
import com.alibaba.ariver.app.api.App;
import com.alibaba.griver.api.common.config.GriverConfigConstants;
import com.alibaba.griver.base.common.config.GriverInnerConfig;
import com.alibaba.griver.base.common.innerapp.GriverInnerAppUtil;

/* loaded from: classes6.dex */
public class GriverTinyAppInnerAuthenticationProxyImpl implements TinyAppInnerAuthenticationProxy {
    @Override // com.alibaba.griver.base.common.permission.TinyAppInnerAuthenticationProxy
    public boolean isInnerAllow(App app, String str) {
        if (app == null || TextUtils.isEmpty(str) || !GriverInnerConfig.getConfigBoolean(GriverConfigConstants.KEY_INNER_PERMISSION_ENABLE, true)) {
            return true;
        }
        return GriverInnerAppUtil.hasPermission(app, str);
    }
}
