package com.alipay.mobile.zebra.ant;

import com.alibaba.griver.beehive.lottie.constants.LottieConstants;
import com.alipay.mobile.zebra.ant.data.LottieData;
import com.alipay.mobile.zebra.core.ZebraOption;

/* loaded from: classes7.dex */
public class AntOption extends ZebraOption {
    public static final ZebraOption ANT_OPTION = new AntOption();

    public AntOption() {
        put(LottieConstants.RENDER_TYPE_LOTTIE, LottieData.class);
    }
}
