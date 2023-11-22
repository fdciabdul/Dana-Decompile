package com.alipay.mobile.zebra.ant.layout;

import android.content.Context;
import android.view.View;
import android.webkit.WebResourceResponse;
import com.alipay.mobile.zebra.ant.data.LottieData;
import com.alipay.mobile.zebra.layout.ZebraLayout;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes7.dex */
public class LottieLayout extends ZebraLayout<LottieData> {

    /* renamed from: a  reason: collision with root package name */
    private AtomicBoolean f7313a = new AtomicBoolean(false);

    @Override // com.alipay.mobile.zebra.layout.ZebraLayout
    public boolean onReceiveResource(String str, String str2, WebResourceResponse webResourceResponse) {
        return false;
    }

    @Override // com.alipay.mobile.zebra.layout.ZebraLayout
    public View render(Context context, LottieData lottieData) {
        setDataContext(lottieData);
        return null;
    }
}
