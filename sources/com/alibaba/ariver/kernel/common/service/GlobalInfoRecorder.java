package com.alibaba.ariver.kernel.common.service;

import com.alibaba.ariver.kernel.common.Proxiable;
import com.alibaba.ariver.kernel.common.RVProxy;

/* loaded from: classes6.dex */
public interface GlobalInfoRecorder extends Proxiable {
    void addInfo(String str, String str2);

    /* loaded from: classes6.dex */
    public static class Utils {
        public static void addInfo(String str, String str2) {
            GlobalInfoRecorder globalInfoRecorder = (GlobalInfoRecorder) RVProxy.get(GlobalInfoRecorder.class);
            if (globalInfoRecorder != null) {
                globalInfoRecorder.addInfo(str, str2);
            }
        }
    }
}
