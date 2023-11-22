package com.alibaba.griver.base.common.proxy;

import android.text.TextUtils;
import androidx.collection.LruCache;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.griver.base.common.logger.GriverLogger;
import com.alibaba.griver.base.common.utils.MD5Util;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes6.dex */
public class LocalIdTool {
    public static final String PREFIX = "apml";

    /* renamed from: a  reason: collision with root package name */
    private static LocalIdTool f6300a;
    private Map<String, String> b = new HashMap();
    private LruCache<String, String> c = new LruCache<>(1000);
    private RVFileAbilityProxy d;

    private LocalIdTool() {
        long currentTimeMillis = System.currentTimeMillis();
        this.d = (RVFileAbilityProxy) RVProxy.get(RVFileAbilityProxy.class);
        StringBuilder sb = new StringBuilder();
        sb.append("LocalIdTool init time=");
        sb.append(System.currentTimeMillis() - currentTimeMillis);
        RVLogger.e("LocalIdTool", sb.toString());
    }

    public static LocalIdTool get() {
        LocalIdTool localIdTool;
        synchronized (LocalIdTool.class) {
            if (f6300a == null) {
                f6300a = new LocalIdTool();
            }
            localIdTool = f6300a;
        }
        return localIdTool;
    }

    public static boolean isLocalIdRes(String str) {
        return !TextUtils.isEmpty(str) && str.startsWith(PREFIX);
    }

    public String encodeToLocalId(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append("encodeToLocalId, path: ");
        sb.append(str);
        GriverLogger.d("LocalIdTool", sb.toString());
        if (str == null) {
            return null;
        }
        if (!TextUtils.isEmpty(str) && !str.startsWith(PREFIX)) {
            String str2 = this.c.get(str);
            if (str2 == null) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append(PREFIX);
                sb2.append(MD5Util.getMD5String(str));
                str2 = sb2.toString();
                this.b.put(str2, str);
                this.c.put(str, str2);
            }
            a(str2, str);
            str = str2;
        }
        StringBuilder sb3 = new StringBuilder();
        sb3.append("encodeToLocalId, localId: ");
        sb3.append(str);
        GriverLogger.d("LocalIdTool", sb3.toString());
        return str;
    }

    public String decodeToPath(String str) {
        if (str == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("decodeToPath>localId = ");
        sb.append(str);
        RVLogger.d("LocalIdTool", sb.toString());
        if (isLocalIdRes(str)) {
            String str2 = this.b.get(str);
            if (str2 != null) {
                a(str, str2);
            } else {
                str2 = a(str);
                if (TextUtils.isEmpty(str2)) {
                    return str;
                }
                this.b.put(str, str2);
            }
            return str2;
        }
        return str;
    }

    private void a(String str, String str2) {
        RVFileAbilityProxy rVFileAbilityProxy = this.d;
        if (rVFileAbilityProxy != null) {
            rVFileAbilityProxy.saveIdWithPath(str, str2);
        }
    }

    private String a(String str) {
        RVFileAbilityProxy rVFileAbilityProxy = this.d;
        return rVFileAbilityProxy != null ? rVFileAbilityProxy.queryPathByLocalId(str) : "";
    }
}
