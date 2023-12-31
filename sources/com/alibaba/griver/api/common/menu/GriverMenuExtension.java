package com.alibaba.griver.api.common.menu;

import com.alibaba.ariver.app.api.Page;
import com.alibaba.griver.api.common.GriverExtension;
import java.util.List;

/* loaded from: classes6.dex */
public interface GriverMenuExtension extends GriverExtension {
    List<GriverMenuItem> getAppendMenuList(Page page);

    List<GriverMenuItem> getMenuList(Page page);
}
