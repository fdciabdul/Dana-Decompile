package com.alibaba.griver.image.photo.meta;

import android.text.TextUtils;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.service.RVConfigService;
import id.dana.sendmoney.summary.SummaryActivity;

/* loaded from: classes6.dex */
public class CloudConfig {

    /* renamed from: a  reason: collision with root package name */
    private static boolean f6607a;
    private static boolean b;
    private static boolean c;

    public static boolean isConfigToDisableQCompact() {
        if (!f6607a) {
            a();
        }
        return b;
    }

    public static boolean isConfigToDisableImageObserver() {
        if (!f6607a) {
            a();
        }
        return c;
    }

    private static void a() {
        RVConfigService rVConfigService = (RVConfigService) RVProxy.get(RVConfigService.class);
        if (rVConfigService != null) {
            b = TextUtils.equals(rVConfigService.getConfig("disable_q_compact", "false"), SummaryActivity.CHECKED);
            c = TextUtils.equals(rVConfigService.getConfig("disable_bee_image_observer", "false"), SummaryActivity.CHECKED);
            f6607a = true;
        }
    }
}
