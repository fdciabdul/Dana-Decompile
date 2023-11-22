package com.huawei.secure.android.common.webview;

import android.webkit.WebView;
import java.util.concurrent.CountDownLatch;

/* loaded from: classes8.dex */
public class SafeGetUrl {
    String BuiltInFictitiousFunctionClassFactory;
    private WebView MyBillsEntityDataFactory;

    /* loaded from: classes8.dex */
    class a implements Runnable {
        final /* synthetic */ CountDownLatch KClassImpl$Data$declaredNonStaticMembers$2;
        final /* synthetic */ SafeGetUrl PlaceComponentResult;

        @Override // java.lang.Runnable
        public void run() {
            SafeGetUrl safeGetUrl = this.PlaceComponentResult;
            safeGetUrl.BuiltInFictitiousFunctionClassFactory = safeGetUrl.MyBillsEntityDataFactory.getUrl();
            this.KClassImpl$Data$declaredNonStaticMembers$2.countDown();
        }
    }
}
