package com.alibaba.ariver.app.api.point.page;

import android.app.Activity;
import com.alibaba.ariver.app.api.Page;
import com.alibaba.ariver.engine.api.Render;
import com.alibaba.ariver.engine.api.bridge.model.CreateParams;
import com.alibaba.ariver.kernel.api.extension.Extension;

/* loaded from: classes3.dex */
public interface PageCreateRenderPoint extends Extension {
    Render createRender(Activity activity, Page page, CreateParams createParams);
}
