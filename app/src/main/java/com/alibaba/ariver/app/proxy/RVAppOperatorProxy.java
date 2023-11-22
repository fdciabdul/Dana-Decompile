package com.alibaba.ariver.app.proxy;

import android.graphics.Bitmap;
import com.alibaba.ariver.kernel.api.annotation.DefaultImpl;
import com.alibaba.ariver.kernel.common.Proxiable;

@DefaultImpl("com.alibaba.ariver.integration.proxy.impl.DefaultAppOperatorImpl")
/* loaded from: classes6.dex */
public interface RVAppOperatorProxy extends Proxiable {
    void closePage(String str, String str2, String str3);

    boolean closeTopPage(String str);

    Bitmap getPageSnapshot(String str, String str2, String str3);

    Bitmap getTopPageSnapshot(String str);
}
