package com.iap.ac.android.container.adapter.appcontainer;

import android.os.Bundle;
import com.alipay.iap.android.webapp.sdk.app.WebAppListener;
import com.iap.ac.android.common.container.event.IContainerListener;

/* loaded from: classes3.dex */
public class AppContainerWebListener implements WebAppListener {
    private IContainerListener containerListener;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AppContainerWebListener(IContainerListener iContainerListener) {
        this.containerListener = iContainerListener;
    }

    public void onAppCreated(Bundle bundle) {
        IContainerListener iContainerListener = this.containerListener;
        if (iContainerListener != null) {
            iContainerListener.onContainerCreated(bundle);
        }
    }

    public void onAppDestroyed(Bundle bundle) {
        IContainerListener iContainerListener = this.containerListener;
        if (iContainerListener != null) {
            iContainerListener.onContainerDestroyed(bundle);
        }
    }
}
