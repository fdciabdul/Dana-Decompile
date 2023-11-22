package com.alibaba.griver.beehive.lottie.player;

import android.text.TextUtils;
import com.alibaba.griver.beehive.lottie.adapter.impl.ResourcesReplaceUtilAdapter;
import com.alibaba.griver.beehive.lottie.adapter.impl.SwitchConfigUtilsAdapter;
import com.alibaba.griver.beehive.lottie.constants.LottieConstants;

/* loaded from: classes6.dex */
public class GrayHelper {
    private static final String TAG = "LottiePlayer:GrayHelper";

    public static String getGrayRenderType(String str) {
        String configValue = SwitchConfigUtilsAdapter.getConfigValue("BeeLottiePlayer_Skottie");
        if ((configValue == null || TextUtils.isEmpty(str) || !configValue.contains(str)) && !"*".equals(configValue)) {
            return null;
        }
        return LottieConstants.RENDER_TYPE_SKOTTIE;
    }

    public static String getReplaceDjangoId(String str) {
        String lottieId = ResourcesReplaceUtilAdapter.getLottieId(str);
        return !TextUtils.isEmpty(lottieId) ? lottieId : str;
    }
}
