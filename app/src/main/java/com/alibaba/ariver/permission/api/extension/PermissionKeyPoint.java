package com.alibaba.ariver.permission.api.extension;

import com.alibaba.ariver.app.api.App;
import com.alibaba.ariver.kernel.api.extension.Extension;

/* loaded from: classes6.dex */
public interface PermissionKeyPoint extends Extension {
    String buildLocalPermissionKey(App app, String str, String str2);
}
