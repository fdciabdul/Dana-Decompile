package com.alibaba.ariver.resource.api.extension;

import com.alibaba.ariver.app.api.Page;
import com.alibaba.ariver.kernel.api.extension.Extension;
import java.util.List;
import java.util.Map;

/* loaded from: classes6.dex */
public interface ReceivedHeaderPoint extends Extension {
    void onReceivedResponseHeader(Page page, String str, Map<String, List<String>> map);
}
