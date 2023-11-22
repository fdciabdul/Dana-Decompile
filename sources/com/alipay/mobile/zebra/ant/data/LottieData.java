package com.alipay.mobile.zebra.ant.data;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.alipay.mobile.zebra.ZebraLoader;
import com.alipay.mobile.zebra.ant.layout.LottieLayout;
import com.alipay.mobile.zebra.core.ZebraOption;
import com.alipay.mobile.zebra.data.ZebraData;
import com.alipay.mobile.zebra.data.web.WebText;

/* loaded from: classes7.dex */
public class LottieData extends ZebraData<LottieLayout> {
    public static final String ATTR_SRC = "src";
    protected String mSrc;

    public String getSrc() {
        return this.mSrc;
    }

    public void setSrc(String str) {
        this.mSrc = str;
    }

    @Override // com.alipay.mobile.zebra.data.ZebraData
    public void fromDSL(AttributeSet attributeSet, ZebraOption zebraOption) {
        super.fromDSL(attributeSet, zebraOption);
        this.mSrc = this.mAttributeMap.get("src");
    }

    @Override // com.alipay.mobile.zebra.data.ZebraData
    public View render(Context context) {
        LottieLayout lottieLayout = new LottieLayout();
        setLayoutContext(lottieLayout);
        View render = lottieLayout.render(context, this);
        if (render != null) {
            render.setTag(this);
        }
        lottieLayout.onFinishRender();
        return render;
    }

    @Override // com.alipay.mobile.zebra.data.ZebraData
    public void loadResource(ZebraLoader zebraLoader) {
        if (zebraLoader == null) {
            fireLoadedEvent();
        } else {
            zebraLoader.loadText(this.mSrc, new ZebraLoader.OnLoadTextCallback() { // from class: com.alipay.mobile.zebra.ant.data.LottieData.1
                @Override // com.alipay.mobile.zebra.ZebraLoader.OnLoadTextCallback
                public void onComplete(String str) {
                    if (str != null && LottieData.this.mLayoutContext != null) {
                        LottieData lottieData = LottieData.this;
                        lottieData.mReady = ((LottieLayout) lottieData.mLayoutContext).onReceiveResource("src", LottieData.this.mSrc, new WebText(str));
                    }
                    LottieData.this.fireLoadedEvent();
                }
            });
        }
    }
}
