package com.alibaba.ariver.app.ipc;

import android.os.Bundle;
import com.alibaba.ariver.app.api.App;
import com.alibaba.ariver.kernel.RVConstants;
import com.alibaba.ariver.kernel.ipc.IpcClientKernelUtils;
import com.alibaba.ariver.kernel.ipc.IpcMessageConstants;

/* loaded from: classes2.dex */
public class IpcClientUtils {
    public static final String LOG_TAG = "AriverInt:IpcClient";

    public static void sendMsgToServerByApp(App app, int i, Bundle bundle) {
        Bundle bundle2;
        if (bundle != null) {
            bundle2 = new Bundle(bundle);
        } else {
            bundle2 = new Bundle();
        }
        bundle2.putLong(RVConstants.EXTRA_START_TOKEN, app.getStartToken());
        bundle2.putString("appId", app.getAppId());
        IpcClientKernelUtils.sendMsgToServer(IpcMessageConstants.BIZ_APP, i, bundle2);
    }
}
