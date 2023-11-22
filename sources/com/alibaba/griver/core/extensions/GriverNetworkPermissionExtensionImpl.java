package com.alibaba.griver.core.extensions;

import com.alibaba.ariver.app.api.Page;
import com.alibaba.griver.base.common.bridge.GriverNetworkPermissionExtension;

/* loaded from: classes6.dex */
public class GriverNetworkPermissionExtensionImpl implements GriverNetworkPermissionExtension {
    @Override // com.alibaba.griver.base.common.bridge.GriverNetworkPermissionExtension
    public boolean shouldApplyPermission(Page page) {
        return true;
    }
}
