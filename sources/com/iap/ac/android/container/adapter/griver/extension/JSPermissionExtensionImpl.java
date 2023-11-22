package com.iap.ac.android.container.adapter.griver.extension;

import com.alibaba.griver.api.h5.permission.GriverH5JSAPIPermissionExtension;
import com.iap.ac.android.common.container.provider.JsApiPermissionProvider;

/* loaded from: classes3.dex */
public class JSPermissionExtensionImpl implements GriverH5JSAPIPermissionExtension {

    /* renamed from: a  reason: collision with root package name */
    private JsApiPermissionProvider f7562a;

    public JSPermissionExtensionImpl(JsApiPermissionProvider jsApiPermissionProvider) {
        this.f7562a = jsApiPermissionProvider;
    }

    @Override // com.alibaba.griver.api.h5.permission.GriverH5JSAPIPermissionExtension
    public boolean hasPermission(String str, String str2) {
        JsApiPermissionProvider jsApiPermissionProvider = this.f7562a;
        if (jsApiPermissionProvider != null) {
            return jsApiPermissionProvider.hasDomainPermission(str, str2);
        }
        return true;
    }
}
