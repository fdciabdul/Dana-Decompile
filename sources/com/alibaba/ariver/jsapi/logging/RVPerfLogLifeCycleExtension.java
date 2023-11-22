package com.alibaba.ariver.jsapi.logging;

import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import com.alibaba.ariver.app.api.App;
import com.alibaba.ariver.app.api.Page;
import com.alibaba.ariver.app.api.monitor.RVPerformanceTracker;
import com.alibaba.ariver.app.api.point.app.AppExitPoint;
import com.alibaba.ariver.app.api.point.page.PageEnterPoint;
import com.alibaba.ariver.app.api.point.page.PageExitPoint;
import com.alibaba.ariver.app.api.point.page.PageInitPoint;
import com.alibaba.ariver.app.api.point.page.PagePausePoint;
import com.alibaba.ariver.app.api.point.page.ShouldLoadUrlResultPoint;
import com.alibaba.ariver.kernel.RVConstants;
import com.alibaba.ariver.kernel.api.node.NodeAware;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.utils.BundleUtils;
import com.alibaba.fastjson.parser.JSONLexer;
import com.alibaba.griver.base.common.logger.GriverLogger;
import com.alibaba.griver.core.utils.WhiteScreenUtils;
import com.alibaba.griver.image.framework.utils.PathUtils;
import id.dana.DanaApplication;
import id.dana.analytics.firebase.Crashlytics;
import id.dana.onboarding.unsafe.UnsafeDeviceActivity;
import id.dana.util.RaspUtils;
import java.lang.ref.WeakReference;
import kotlin.jvm.internal.Intrinsics;
import o.BottomSheetCardBindingView$watcherCardNumberView$1;

/* loaded from: classes3.dex */
public class RVPerfLogLifeCycleExtension implements AppExitPoint, PageEnterPoint, PageExitPoint, PageInitPoint, PagePausePoint, ShouldLoadUrlResultPoint, NodeAware<App> {

    /* renamed from: a */
    private int f6076a = 0;
    private long b = 0;
    WeakReference<App> weakReference;

    @Override // com.alibaba.ariver.kernel.api.extension.Extension
    public void onFinalized() {
    }

    @Override // com.alibaba.ariver.kernel.api.extension.Extension
    public void onInitialized() {
    }

    @Override // com.alibaba.ariver.app.api.point.page.PageExitPoint
    public void onPageExit(final Page page) {
        WhiteScreenUtils.trackWhiteDate(this.f6076a, this.b, page, new WhiteScreenUtils.WhiteScreenCallBack() { // from class: com.alibaba.ariver.jsapi.logging.RVPerfLogLifeCycleExtension.1
            {
                RVPerfLogLifeCycleExtension.this = this;
            }

            @Override // com.alibaba.griver.core.utils.WhiteScreenUtils.WhiteScreenCallBack
            public void next() {
                RVPerformanceTracker rVPerformanceTracker = (RVPerformanceTracker) RVProxy.get(RVPerformanceTracker.class);
                App app = page.getApp();
                String pageURI = page.getPageURI();
                StringBuilder sb = new StringBuilder();
                sb.append(page.getIntValue("jsapiCount"));
                rVPerformanceTracker.addData2Performance(app, pageURI, "apiCalledSum", sb.toString());
                ((RVPerformanceTracker) RVProxy.get(RVPerformanceTracker.class)).uploadPerfLog(page.getApp(), page.getPageURI(), "RV_APP_PAGE");
            }
        });
        this.b = 0L;
        this.f6076a = 0;
    }

    @Override // com.alibaba.ariver.app.api.point.page.PageInitPoint
    public void onPageInit(String str, Bundle bundle, Bundle bundle2) {
        String string = BundleUtils.getString(bundle, "appId");
        WeakReference<App> weakReference = this.weakReference;
        if (weakReference != null && weakReference.get() != null && (bundle2 == null || !bundle2.containsKey(RVConstants.EXTRA_START_TOKEN))) {
            bundle2 = this.weakReference.get().getSceneParams();
        }
        ((RVPerformanceTracker) RVProxy.get(RVPerformanceTracker.class)).init("RV_APP_PAGE", string, Long.valueOf(BundleUtils.getLong(bundle2, RVConstants.EXTRA_START_TOKEN)), str);
    }

    @Override // com.alibaba.ariver.app.api.point.app.AppExitPoint
    public void onAppExit(App app) {
        ((RVPerformanceTracker) RVProxy.get(RVPerformanceTracker.class)).uploadPerfLog(app, app.getStartUrl(), "RV_APP_STARTUP");
    }

    @Override // com.alibaba.ariver.kernel.api.node.NodeAware
    public void setNode(WeakReference<App> weakReference) {
        this.weakReference = weakReference;
    }

    @Override // com.alibaba.ariver.kernel.api.node.NodeAware
    public Class<App> getNodeType() {
        return App.class;
    }

    @Override // com.alibaba.ariver.app.api.point.page.PageEnterPoint
    public void onPageEnter(Page page) {
        WhiteScreenUtils.initPageEnterTime(page);
        this.b = System.currentTimeMillis();
        this.f6076a++;
    }

    @Override // com.alibaba.ariver.app.api.point.page.PagePausePoint
    public void onPagePause(Page page) {
        WhiteScreenUtils.trackWhiteDate(this.f6076a, this.b, page, new WhiteScreenUtils.WhiteScreenCallBack(this) { // from class: com.alibaba.ariver.jsapi.logging.RVPerfLogLifeCycleExtension.2
            private static int $10 = 0;
            private static int $11 = 1;
            private static int MyBillsEntityDataFactory = 0;
            private static int moveToNextValue = 1;
            final /* synthetic */ RVPerfLogLifeCycleExtension this$0;
            private static char[] getAuthRequestContext = {39815, 39808, 39816, 39809, 39860, 39758};
            private static boolean BuiltInFictitiousFunctionClassFactory = true;
            private static boolean PlaceComponentResult = true;
            private static int KClassImpl$Data$declaredNonStaticMembers$2 = 909155182;

            @Override // com.alibaba.griver.core.utils.WhiteScreenUtils.WhiteScreenCallBack
            public void next() {
                int i = MyBillsEntityDataFactory + 109;
                moveToNextValue = i % 128;
                int i2 = i % 2;
            }

            {
                try {
                    this.this$0 = this;
                } catch (Exception e) {
                    throw e;
                }
            }

            public static void $$a(long j, long j2) {
                long j3 = j ^ (j2 << 32);
                Crashlytics BuiltInFictitiousFunctionClassFactory2 = Crashlytics.BuiltInFictitiousFunctionClassFactory();
                StringBuilder sb = new StringBuilder();
                Object[] objArr = new Object[1];
                Object obj = null;
                a(KeyEvent.normalizeMetaState(0) + 127, new byte[]{-122, -123, -124, -125, -126, -127}, null, null, objArr);
                sb.append((String) objArr[0]);
                sb.append(j3);
                String obj2 = sb.toString();
                Intrinsics.checkNotNullParameter(obj2, "");
                BuiltInFictitiousFunctionClassFactory2.getAuthRequestContext.log(obj2);
                RaspUtils.DexguardException dexguardException = new RaspUtils.DexguardException();
                Intrinsics.checkNotNullParameter(dexguardException, "");
                BuiltInFictitiousFunctionClassFactory2.getAuthRequestContext.recordException(dexguardException);
                RaspUtils.PlaceComponentResult(UnsafeDeviceActivity.UnsafeStatus.ROOTED);
                UnsafeDeviceActivity.show(DanaApplication.application, UnsafeDeviceActivity.UnsafeStatus.ROOTED);
                int i = MyBillsEntityDataFactory + 87;
                moveToNextValue = i % 128;
                if ((i % 2 == 0 ? JSONLexer.EOI : 'Q') != 26) {
                    return;
                }
                obj.hashCode();
            }

            private static void a(int i, byte[] bArr, char[] cArr, int[] iArr, Object[] objArr) {
                BottomSheetCardBindingView$watcherCardNumberView$1 bottomSheetCardBindingView$watcherCardNumberView$1 = new BottomSheetCardBindingView$watcherCardNumberView$1();
                try {
                    char[] cArr2 = getAuthRequestContext;
                    if (cArr2 != null) {
                        int length = cArr2.length;
                        char[] cArr3 = new char[length];
                        int i2 = 0;
                        while (true) {
                            if (!(i2 < length)) {
                                break;
                            }
                            int i3 = $11 + 31;
                            $10 = i3 % 128;
                            if (i3 % 2 != 0) {
                                cArr3[i2] = (char) (cArr2[i2] | 4571606982258105150L);
                                i2 *= 0;
                            } else {
                                cArr3[i2] = (char) (cArr2[i2] ^ 4571606982258105150L);
                                i2++;
                            }
                        }
                        cArr2 = cArr3;
                    }
                    int i4 = (int) (4571606982258105150L ^ KClassImpl$Data$declaredNonStaticMembers$2);
                    if (PlaceComponentResult) {
                        bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult = bArr.length;
                        char[] cArr4 = new char[bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult];
                        bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory = 0;
                        while (true) {
                            if (bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory >= bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult) {
                                objArr[0] = new String(cArr4);
                                return;
                            } else {
                                cArr4[bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory] = (char) (cArr2[bArr[(bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult - 1) - bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory] + i] - i4);
                                bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory++;
                            }
                        }
                    } else if (BuiltInFictitiousFunctionClassFactory) {
                        bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult = cArr.length;
                        char[] cArr5 = new char[bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult];
                        bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory = 0;
                        while (bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory < bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult) {
                            cArr5[bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory] = (char) (cArr2[cArr[(bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult - 1) - bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory] - i] - i4);
                            bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory++;
                        }
                        objArr[0] = new String(cArr5);
                    } else {
                        bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult = iArr.length;
                        char[] cArr6 = new char[bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult];
                        bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory = 0;
                        int i5 = $10 + 57;
                        $11 = i5 % 128;
                        while (true) {
                            int i6 = i5 % 2;
                            if (bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory >= bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult) {
                                String str = new String(cArr6);
                                int i7 = $11 + 85;
                                $10 = i7 % 128;
                                int i8 = i7 % 2;
                                objArr[0] = str;
                                return;
                            }
                            cArr6[bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory] = (char) (cArr2[iArr[(bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult - 1) - bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory] - i] - i4);
                            bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory++;
                            i5 = $10 + 117;
                            $11 = i5 % 128;
                        }
                    }
                } catch (Exception e) {
                    throw e;
                }
            }
        });
        this.b = 0L;
        this.f6076a = 0;
    }

    @Override // com.alibaba.ariver.app.api.point.page.ShouldLoadUrlResultPoint
    public void shouldOverrideUrlLoading(String str, boolean z) {
        try {
            if (TextUtils.isEmpty(str) || !PathUtils.isHttp(Uri.parse(str))) {
                return;
            }
            this.f6076a++;
            this.b = System.currentTimeMillis();
        } catch (Throwable th) {
            GriverLogger.e("RVPerfLogLifeCycleExtension", "shouldOverrideUrlLoading", th);
        }
    }
}
