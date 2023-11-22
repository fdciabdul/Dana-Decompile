package com.alibaba.ariver.permission.api.extension;

import com.alibaba.ariver.kernel.api.extension.Extension;

/* loaded from: classes6.dex */
public interface OfficialAppPoint extends Extension {
    boolean ignorePermission(String str);

    boolean isOfficial(String str);
}
