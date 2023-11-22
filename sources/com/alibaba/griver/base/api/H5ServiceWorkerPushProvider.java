package com.alibaba.griver.base.api;

import java.util.HashMap;

/* loaded from: classes6.dex */
public interface H5ServiceWorkerPushProvider {
    void clearServiceWorker(String str);

    void clearServiceWorkerSync(String str, H5CallBack h5CallBack);

    void sendServiceWorkerPushMessage(HashMap<String, String> hashMap);

    void sendServiceWorkerPushMessage(HashMap<String, String> hashMap, H5CallBack h5CallBack);
}
