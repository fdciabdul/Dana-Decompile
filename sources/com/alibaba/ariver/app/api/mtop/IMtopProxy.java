package com.alibaba.ariver.app.api.mtop;

import com.alibaba.ariver.app.api.Page;
import com.alibaba.ariver.kernel.api.annotation.DefaultImpl;
import com.alibaba.ariver.kernel.common.Proxiable;
import mtopsdk.mtop.intf.Mtop;

@DefaultImpl("com.alibaba.ariver.mtop.SendMtopProxyImpl")
/* loaded from: classes6.dex */
public interface IMtopProxy extends Proxiable {

    /* loaded from: classes6.dex */
    public interface Callback {
        void onResult(SendMtopResponse sendMtopResponse);
    }

    Mtop getMtopInstance(String str, SendMtopParams sendMtopParams);

    void requestAsync(Page page, SendMtopParams sendMtopParams, Callback callback);

    void requestInnerAsync(SendMtopParams sendMtopParams, Callback callback);

    SendMtopResponse requestInnerSync(SendMtopParams sendMtopParams);

    SendMtopResponse requestSync(Page page, SendMtopParams sendMtopParams);
}
