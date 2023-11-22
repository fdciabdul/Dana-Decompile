package com.alibaba.griver.base.resource.utils;

import com.alibaba.ariver.resource.api.models.AppModel;
import com.alibaba.griver.base.common.logger.GriverLogger;
import com.alibaba.griver.base.resource.appcenter.GriverAppCenter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes6.dex */
public class H5CommonResourceUtils {
    public static List<String> filterCommonResources(List<String> list) {
        if (list == null || list.size() == 0) {
            return new ArrayList();
        }
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            String next = it.next();
            List<AppModel> queryAppInfo = GriverAppCenter.queryAppInfo(next);
            if (queryAppInfo == null || queryAppInfo.size() == 0) {
                StringBuilder sb = new StringBuilder();
                sb.append("resource not installed yet: ");
                sb.append(next);
                GriverLogger.w("H5CommonResourceUtils", sb.toString());
                it.remove();
            }
        }
        return list;
    }
}
