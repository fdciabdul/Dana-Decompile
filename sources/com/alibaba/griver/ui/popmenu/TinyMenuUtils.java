package com.alibaba.griver.ui.popmenu;

import android.text.TextUtils;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.service.RVConfigService;
import com.alibaba.fastjson.JSON;
import java.util.Iterator;

/* loaded from: classes6.dex */
public class TinyMenuUtils {
    public static boolean showActionIcon(String str) {
        if (TextUtils.isEmpty(str)) {
            return true;
        }
        String config = ((RVConfigService) RVProxy.get(RVConfigService.class)).getConfig("ta_hareware_notice_blacklist", "");
        if (!TextUtils.isEmpty(config) && !TextUtils.equals("none", config)) {
            if (TextUtils.equals("all", config)) {
                return false;
            }
            Iterator<Object> it = JSON.parseArray(config).iterator();
            while (it.hasNext()) {
                if (it.next() != null) {
                    return !TextUtils.equals(str, r2.toString());
                }
            }
        }
        return true;
    }
}
