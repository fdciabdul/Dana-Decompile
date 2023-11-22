package com.alibaba.griver.base.common.utils;

import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.griver.api.jsapi.diagnostic.GriverAllRecordsExtension;
import com.alibaba.griver.api.jsapi.diagnostic.Record;
import java.util.Map;

/* loaded from: classes3.dex */
public class GriverAllRecordsUtils {
    public static void put(String str, Map<String, String> map) {
        GriverAllRecordsExtension griverAllRecordsExtension = (GriverAllRecordsExtension) RVProxy.get(GriverAllRecordsExtension.class);
        if (griverAllRecordsExtension != null) {
            griverAllRecordsExtension.addRecord(new Record.Builder(str).append(map).build());
        }
    }
}
