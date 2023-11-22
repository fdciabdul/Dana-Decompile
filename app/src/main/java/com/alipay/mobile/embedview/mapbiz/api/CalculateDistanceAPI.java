package com.alipay.mobile.embedview.mapbiz.api;

import com.alibaba.ariver.kernel.common.service.executor.ExecutorType;
import com.alibaba.ariver.kernel.common.utils.ExecutorUtils;
import com.alibaba.ariver.kernel.common.utils.JSONUtils;
import com.alibaba.fastjson.JSONObject;
import com.alipay.mobile.embedview.callback.H5JsCallback;
import com.alipay.mobile.embedview.mapbiz.ui.H5MapContainer;

/* loaded from: classes6.dex */
public class CalculateDistanceAPI extends H5MapAPI {
    @Override // com.alipay.mobile.embedview.mapbiz.api.H5MapAPI
    public void call(final H5MapContainer h5MapContainer, final JSONObject jSONObject, final H5JsCallback h5JsCallback) {
        boolean z = JSONUtils.getBoolean(jSONObject, "async", true);
        Runnable runnable = new Runnable() { // from class: com.alipay.mobile.embedview.mapbiz.api.CalculateDistanceAPI.1
            /* JADX WARN: Removed duplicated region for block: B:12:0x0037 A[Catch: all -> 0x02ab, TryCatch #2 {all -> 0x02ab, blocks: (B:3:0x0004, B:5:0x0018, B:8:0x0021, B:10:0x002c, B:12:0x0037, B:13:0x0044, B:15:0x004f, B:20:0x0059, B:22:0x005d, B:23:0x0064, B:25:0x006f, B:27:0x007d, B:29:0x0089, B:34:0x009b, B:101:0x02a1, B:28:0x0084, B:9:0x0024), top: B:114:0x0004 }] */
            /* JADX WARN: Removed duplicated region for block: B:15:0x004f A[Catch: all -> 0x02ab, TRY_LEAVE, TryCatch #2 {all -> 0x02ab, blocks: (B:3:0x0004, B:5:0x0018, B:8:0x0021, B:10:0x002c, B:12:0x0037, B:13:0x0044, B:15:0x004f, B:20:0x0059, B:22:0x005d, B:23:0x0064, B:25:0x006f, B:27:0x007d, B:29:0x0089, B:34:0x009b, B:101:0x02a1, B:28:0x0084, B:9:0x0024), top: B:114:0x0004 }] */
            /* JADX WARN: Removed duplicated region for block: B:17:0x0054  */
            /* JADX WARN: Removed duplicated region for block: B:20:0x0059 A[Catch: all -> 0x02ab, TRY_ENTER, TryCatch #2 {all -> 0x02ab, blocks: (B:3:0x0004, B:5:0x0018, B:8:0x0021, B:10:0x002c, B:12:0x0037, B:13:0x0044, B:15:0x004f, B:20:0x0059, B:22:0x005d, B:23:0x0064, B:25:0x006f, B:27:0x007d, B:29:0x0089, B:34:0x009b, B:101:0x02a1, B:28:0x0084, B:9:0x0024), top: B:114:0x0004 }] */
            /* JADX WARN: Removed duplicated region for block: B:25:0x006f A[Catch: all -> 0x02ab, TryCatch #2 {all -> 0x02ab, blocks: (B:3:0x0004, B:5:0x0018, B:8:0x0021, B:10:0x002c, B:12:0x0037, B:13:0x0044, B:15:0x004f, B:20:0x0059, B:22:0x005d, B:23:0x0064, B:25:0x006f, B:27:0x007d, B:29:0x0089, B:34:0x009b, B:101:0x02a1, B:28:0x0084, B:9:0x0024), top: B:114:0x0004 }] */
            @Override // java.lang.Runnable
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public void run() {
                /*
                    Method dump skipped, instructions count: 711
                    To view this dump change 'Code comments level' option to 'DEBUG'
                */
                throw new UnsupportedOperationException("Method not decompiled: com.alipay.mobile.embedview.mapbiz.api.CalculateDistanceAPI.AnonymousClass1.run():void");
            }
        };
        if (z) {
            ExecutorUtils.runNotOnMain(ExecutorType.URGENT, runnable);
        } else {
            runnable.run();
        }
    }
}
