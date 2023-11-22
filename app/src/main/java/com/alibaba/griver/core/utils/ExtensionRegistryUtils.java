package com.alibaba.griver.core.utils;

import android.text.TextUtils;
import com.alibaba.ariver.kernel.api.extension.registry.ExtensionMetaInfo;
import com.alibaba.griver.api.common.GriverEvent;
import com.alibaba.griver.base.common.logger.GriverLogger;
import com.alibaba.griver.base.common.utils.ReflectUtils;
import com.alibaba.griver.core.point.GriverEventManifest;
import java.util.ArrayList;

/* loaded from: classes3.dex */
public class ExtensionRegistryUtils {
    public static ExtensionMetaInfo convert(GriverEventManifest griverEventManifest) {
        if (griverEventManifest == null || !ReflectUtils.classExist(griverEventManifest.getHandlerClassName()) || griverEventManifest.getEventClassNames() == null || griverEventManifest.getEventClassNames().size() <= 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (String str : griverEventManifest.getEventClassNames()) {
            if (!TextUtils.isEmpty(str) && ReflectUtils.classExist(str)) {
                try {
                    if (GriverEvent.class.isAssignableFrom(Class.forName(str))) {
                        arrayList.add(str);
                    } else {
                        GriverLogger.w("GriverCore:ExtensionRegistryUtils", "filter not extends from GriverEvent, do not register");
                    }
                } catch (Throwable th) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("skip for ");
                    sb.append(str);
                    GriverLogger.e("GriverCore:ExtensionRegistryUtils", sb.toString(), th);
                }
            } else {
                GriverLogger.w("GriverCore:ExtensionRegistryUtils", "register point but filter is null");
            }
        }
        if (arrayList.size() > 0) {
            if (griverEventManifest.getScope() != null) {
                return new ExtensionMetaInfo("com-alibaba-griver", griverEventManifest.getHandlerClassName(), arrayList, griverEventManifest.getScope());
            }
            return new ExtensionMetaInfo("com-alibaba-griver", griverEventManifest.getHandlerClassName(), arrayList);
        }
        return null;
    }
}
