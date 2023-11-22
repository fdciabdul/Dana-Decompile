package com.alibaba.griver.base.common;

import android.text.TextUtils;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.griver.api.jsapi.diagnostic.GriverAllRecordsExtension;
import com.alibaba.griver.api.jsapi.diagnostic.Record;

/* loaded from: classes6.dex */
public class GRVDiagnosticToolHelper {
    private GRVDiagnosticToolHelper() {
    }

    /* loaded from: classes6.dex */
    static final class InstanceHolder {
        static final GRVDiagnosticToolHelper instance = new GRVDiagnosticToolHelper();

        private InstanceHolder() {
        }
    }

    public static GRVDiagnosticToolHelper getInstance() {
        return InstanceHolder.instance;
    }

    public void recordErrorWithErrorNum(long j, String str, String str2) {
        GriverAllRecordsExtension griverAllRecordsExtension;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || (griverAllRecordsExtension = (GriverAllRecordsExtension) RVProxy.get(GriverAllRecordsExtension.class)) == null) {
            return;
        }
        griverAllRecordsExtension.addRecord(new Record.Builder(Long.toString(j)).append(str, str2).build());
    }
}
