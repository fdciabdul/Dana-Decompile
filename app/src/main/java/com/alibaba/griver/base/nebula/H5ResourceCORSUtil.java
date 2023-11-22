package com.alibaba.griver.base.nebula;

import android.net.Uri;
import android.text.TextUtils;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.service.RVConfigService;
import com.alibaba.ariver.kernel.common.utils.JSONUtils;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.griver.base.common.utils.H5UrlHelper;
import id.dana.sendmoney.summary.SummaryActivity;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

/* loaded from: classes6.dex */
public class H5ResourceCORSUtil {

    /* renamed from: a  reason: collision with root package name */
    private static final List<Pattern> f6324a = new ArrayList();

    static {
        a();
    }

    private static void a() {
        a(((RVConfigService) RVProxy.get(RVConfigService.class)).getConfig("h5_CORSWhiteList", "", new RVConfigService.OnConfigChangeListener() { // from class: com.alibaba.griver.base.nebula.H5ResourceCORSUtil.1
            @Override // com.alibaba.ariver.kernel.common.service.RVConfigService.OnConfigChangeListener
            public final void onChange(String str) {
                H5ResourceCORSUtil.a(str);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void a(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            JSONArray parseArray = JSONUtils.parseArray(str);
            if (parseArray == null || parseArray.size() <= 0) {
                return;
            }
            List<Pattern> list = f6324a;
            synchronized (list) {
                list.clear();
                int size = parseArray.size();
                for (int i = 0; i < size; i++) {
                    try {
                        Pattern compile = H5PatternHelper.compile(parseArray.getString(i));
                        if (compile != null) {
                            f6324a.add(compile);
                        }
                    } catch (PatternSyntaxException e) {
                        RVLogger.e("H5ResourceCORSUtil", "pattern error", e);
                    }
                }
            }
        } catch (Throwable th) {
            RVLogger.e("H5ResourceCORSUtil", "parse config error", th);
        }
    }

    public static boolean needAddHeader(String str) {
        String host;
        try {
            List<Pattern> list = f6324a;
            synchronized (list) {
                if (list.size() == 0) {
                    return false;
                }
                Uri parseUrl = H5UrlHelper.parseUrl(str);
                if (parseUrl != null && (host = parseUrl.getHost()) != null) {
                    Iterator<Pattern> it = list.iterator();
                    while (it.hasNext()) {
                        if (it.next().matcher(host).find()) {
                            return true;
                        }
                    }
                }
                return false;
            }
        } catch (Throwable unused) {
            return false;
        }
    }

    public static String getCORSUrl(String str) {
        try {
            Uri parseUrl = H5UrlHelper.parseUrl(str);
            StringBuilder sb = new StringBuilder();
            sb.append(parseUrl.getScheme());
            sb.append("://");
            sb.append(parseUrl.getHost());
            String obj = sb.toString();
            RVConfigService rVConfigService = (RVConfigService) RVProxy.get(RVConfigService.class);
            if ((rVConfigService == null || !SummaryActivity.CHECKED.equalsIgnoreCase(rVConfigService.getConfigWithProcessCache("h5_getCORSUrlWithoutPort", ""))) && parseUrl.getPort() != -1) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append(obj);
                sb2.append(":");
                sb2.append(parseUrl.getPort());
                return sb2.toString();
            }
            return obj;
        } catch (Throwable unused) {
            return null;
        }
    }
}
