package com.alibaba.ariver.permission.api.extension;

import com.alibaba.ariver.kernel.api.extension.Extension;

/* loaded from: classes6.dex */
public interface LocalAuthPermissionPoint extends Extension {
    boolean hasUserPermission(String str, String str2);

    boolean isSkipLocalAuth(String str, String str2);
}
