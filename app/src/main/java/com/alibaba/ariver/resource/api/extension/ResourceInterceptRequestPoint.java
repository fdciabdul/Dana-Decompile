package com.alibaba.ariver.resource.api.extension;

import com.alibaba.ariver.app.api.Page;
import com.alibaba.ariver.kernel.api.extension.Extension;
import java.util.Map;

/* loaded from: classes6.dex */
public interface ResourceInterceptRequestPoint extends Extension {
    void shouldInterceptRequest(Page page, String str, String str2, Map<String, String> map, long j);
}
