package com.alibaba.ariver.app.activity;

import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Process;
import android.os.RemoteException;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewConfiguration;
import androidx.fragment.app.FragmentActivity;
import com.alibaba.ariver.app.AppNode;
import com.alibaba.ariver.app.api.App;
import com.alibaba.ariver.app.api.AppContext;
import com.alibaba.ariver.app.api.AppManager;
import com.alibaba.ariver.app.api.AppUIContext;
import com.alibaba.ariver.app.api.EntryInfo;
import com.alibaba.ariver.app.api.Page;
import com.alibaba.ariver.app.api.activity.ActivityAnimBean;
import com.alibaba.ariver.app.api.activity.StartAction;
import com.alibaba.ariver.app.api.activity.StartClientBundle;
import com.alibaba.ariver.app.api.monitor.RVPerformanceTracker;
import com.alibaba.ariver.app.api.permission.RVNativePermissionRequestProxy;
import com.alibaba.ariver.app.api.point.activity.ActivityHelperOnCreateFinishedPoint;
import com.alibaba.ariver.app.api.point.activity.ActivityOnNewIntentPoint;
import com.alibaba.ariver.app.api.point.activity.ActivityOnPausePoint;
import com.alibaba.ariver.app.api.point.activity.ActivityResultPoint;
import com.alibaba.ariver.app.api.point.app.BackKeyDownPoint;
import com.alibaba.ariver.app.api.ui.StatusBarUtils;
import com.alibaba.ariver.app.api.ui.loading.SplashUtils;
import com.alibaba.ariver.app.ipc.ClientMsgReceiver;
import com.alibaba.ariver.kernel.RVConstants;
import com.alibaba.ariver.kernel.RVStartParams;
import com.alibaba.ariver.kernel.api.IIpcChannel;
import com.alibaba.ariver.kernel.api.extension.ExtensionPoint;
import com.alibaba.ariver.kernel.api.track.EventTracker;
import com.alibaba.ariver.kernel.api.track.TrackId;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.utils.BundleUtils;
import com.alibaba.ariver.kernel.common.utils.ExecutorUtils;
import com.alibaba.ariver.kernel.common.utils.ProcessUtils;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.ariver.kernel.common.utils.RVTraceKey;
import com.alibaba.ariver.kernel.common.utils.RVTraceUtils;
import com.alibaba.ariver.kernel.ipc.IpcChannelManager;
import com.alibaba.ariver.kernel.ipc.IpcMessage;
import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.alipay.iap.android.aplog.util.CrashCombineUtils;
import com.google.common.base.Ascii;
import id.dana.onboarding.splash.LauncherActivity;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import o.SummaryVoucherView$$ExternalSyntheticLambda0;

/* loaded from: classes3.dex */
public abstract class ActivityHelper {
    private static final String LOG_TAG = "AriverApp:ActivityHelper";
    private FragmentActivity mActivity;
    private ActivityAnimBean mActivityAnimBean;
    private boolean mAlreadyDoDestroyed = false;
    protected AppNode mApp;
    protected AppUIContext mAppContext;
    private boolean mCloseAllAnim;
    private boolean mOnCreateWithIllegalState;
    private StartClientBundle mStartClientBundle;
    private long mStartToken;
    public static final byte[] $$a = {111, 84, 114, 59, 1, -48, 4, -25, -7, 35, -43, -10, -3, 65, -39, -36, -26, 12, TarHeader.LF_FIFO, -71, -8, -5, -16, 4, -24, 6, -6, 15, -40, -6, Ascii.DC4, -40, 12, -26, 4, -1, 15, -31, -15, 4, -10, -20, -8, 72, -21};
    public static final int $$b = 29;
    public static final byte[] PlaceComponentResult = {96, 83, 72, -80, -7, -1, 7, 4, -13, 9, 3, -51, Ascii.ETB, 16, -13, -39, 42, -13, -1, -11, 19, -23, -53, 60, -13, 11, -9, -59, 35, 36, -8, -1, -17, 6};
    public static final int getAuthRequestContext = 30;

    /* JADX WARN: Removed duplicated region for block: B:20:0x0021  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0029  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:22:0x0029 -> B:23:0x0035). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void a(int r6, int r7, byte r8, java.lang.Object[] r9) {
        /*
            int r6 = r6 * 15
            int r6 = 19 - r6
            int r8 = r8 + 105
            byte[] r0 = com.alibaba.ariver.app.activity.ActivityHelper.PlaceComponentResult
            int r7 = r7 * 3
            int r7 = 16 - r7
            byte[] r1 = new byte[r7]
            int r7 = r7 + (-1)
            r2 = 0
            if (r0 != 0) goto L1b
            r8 = r7
            r3 = r1
            r4 = 0
            r7 = r6
            r1 = r0
            r0 = r9
            r9 = r8
            goto L35
        L1b:
            r3 = 0
        L1c:
            byte r4 = (byte) r8
            r1[r3] = r4
            if (r3 != r7) goto L29
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            r9[r2] = r6
            return
        L29:
            int r3 = r3 + 1
            r4 = r0[r6]
            r5 = r7
            r7 = r6
            r6 = r4
            r4 = r3
            r3 = r1
            r1 = r0
            r0 = r9
            r9 = r5
        L35:
            int r8 = r8 + r6
            int r6 = r7 + 1
            int r8 = r8 + 2
            r7 = r9
            r9 = r0
            r0 = r1
            r1 = r3
            r3 = r4
            goto L1c
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.ariver.app.activity.ActivityHelper.a(int, int, byte, java.lang.Object[]):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0023  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x002b  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:22:0x002b -> B:23:0x0036). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void b(byte r6, int r7, int r8, java.lang.Object[] r9) {
        /*
            int r6 = r6 * 3
            int r6 = r6 + 75
            int r7 = r7 * 4
            int r7 = 42 - r7
            byte[] r0 = com.alibaba.ariver.app.activity.ActivityHelper.$$a
            int r8 = r8 * 4
            int r8 = 3 - r8
            byte[] r1 = new byte[r7]
            int r7 = r7 + (-1)
            r2 = 0
            if (r0 != 0) goto L1b
            r3 = r1
            r4 = 0
            r1 = r0
            r0 = r9
            r9 = r8
            goto L36
        L1b:
            r3 = 0
        L1c:
            byte r4 = (byte) r6
            r1[r3] = r4
            int r8 = r8 + 1
            if (r3 != r7) goto L2b
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            r9[r2] = r6
            return
        L2b:
            int r3 = r3 + 1
            r4 = r0[r8]
            r5 = r9
            r9 = r8
            r8 = r4
            r4 = r3
            r3 = r1
            r1 = r0
            r0 = r5
        L36:
            int r8 = -r8
            int r6 = r6 + r8
            int r6 = r6 + (-7)
            r8 = r9
            r9 = r0
            r0 = r1
            r1 = r3
            r3 = r4
            goto L1c
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.ariver.app.activity.ActivityHelper.b(byte, int, int, java.lang.Object[]):void");
    }

    protected abstract AppContext createAppContext(App app, FragmentActivity fragmentActivity);

    public boolean handleStartClientBundleNull() {
        return false;
    }

    public ActivityHelper(FragmentActivity fragmentActivity) {
        this.mActivity = fragmentActivity;
    }

    public void onCreate() {
        try {
            byte b = (byte) (PlaceComponentResult[5] + 1);
            Object[] objArr = new Object[1];
            a(b, b, (byte) (-PlaceComponentResult[5]), objArr);
            Class<?> cls = Class.forName((String) objArr[0]);
            byte b2 = (byte) (-PlaceComponentResult[5]);
            byte b3 = (byte) (b2 - 1);
            Object[] objArr2 = new Object[1];
            a(b2, b3, b3, objArr2);
            try {
                Object[] objArr3 = {Integer.valueOf(((Integer) cls.getMethod((String) objArr2[0], Object.class).invoke(null, this)).intValue())};
                Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(25207140);
                if (obj == null) {
                    Class cls2 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(View.MeasureSpec.getSize(0) + 494, 3 - TextUtils.indexOf((CharSequence) "", '0', 0), (char) (Color.rgb(0, 0, 0) + 16777216));
                    byte b4 = (byte) ($$a[4] - 1);
                    byte b5 = b4;
                    Object[] objArr4 = new Object[1];
                    b(b4, b5, b5, objArr4);
                    obj = cls2.getMethod((String) objArr4[0], Integer.TYPE);
                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(25207140, obj);
                }
                Object[] objArr5 = (Object[]) ((Method) obj).invoke(null, objArr3);
                int i = ((int[]) objArr5[1])[0];
                if (((int[]) objArr5[0])[0] != i) {
                    long j = ((r1 ^ i) & 4294967295L) | 42949672960L;
                    try {
                        Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                        if (obj2 == null) {
                            obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - Color.red(0), (ViewConfiguration.getTapTimeout() >> 16) + 35, (char) (Process.myTid() >> 22))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj2);
                        }
                        Object invoke = ((Method) obj2).invoke(null, null);
                        try {
                            Object[] objArr6 = {-1991281219, Long.valueOf(j), new ArrayList(), LauncherActivity.getAuid()};
                            Object obj3 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                            if (obj3 == null) {
                                obj3 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getLongPressTimeout() >> 16) + 911, TextUtils.indexOf((CharSequence) "", '0', 0, 0) + 19, (char) (TextUtils.lastIndexOf("", '0', 0, 0) + 1))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1759031285, obj3);
                            }
                            ((Method) obj3).invoke(invoke, objArr6);
                        } catch (Throwable th) {
                            Throwable cause = th.getCause();
                            if (cause == null) {
                                throw th;
                            }
                            throw cause;
                        }
                    } catch (Throwable th2) {
                        Throwable cause2 = th2.getCause();
                        if (cause2 == null) {
                            throw th2;
                        }
                        throw cause2;
                    }
                }
                if (this.mStartClientBundle == null) {
                    RVLogger.w(LOG_TAG, "onCreate but mStartClientBundle == null! do nothing!");
                    return;
                }
                RVTraceUtils.traceBeginSection(RVTraceKey.RV_ActivityHelper_onCreate);
                AppNode appNode = (AppNode) ((AppManager) RVProxy.get(AppManager.class)).findAppByToken(this.mStartToken);
                this.mApp = appNode;
                if (appNode != null && appNode.isInited()) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("onCreate find quickStarted app! ");
                    sb.append(this.mApp);
                    sb.append(" appId from Param: ");
                    sb.append(BundleUtils.getString(this.mApp.getStartParams(), "appId"));
                    RVLogger.d(LOG_TAG, sb.toString());
                } else {
                    this.mApp = (AppNode) ((AppManager) RVProxy.get(AppManager.class)).startApp(this.mStartClientBundle.appId, this.mStartClientBundle.startParams, this.mStartClientBundle.sceneParams);
                }
                this.mAppContext = (AppUIContext) createAppContext(this.mApp, this.mActivity);
                ((RVPerformanceTracker) RVProxy.get(RVPerformanceTracker.class)).init("RV_APP_STARTUP", this.mApp.getAppId(), Long.valueOf(this.mStartToken), this.mApp.getStartUrl());
                this.mApp.bindContext(this.mAppContext);
                EntryInfo entryInfo = (EntryInfo) BundleUtils.getParcelable(this.mApp.getSceneParams(), RVConstants.EXTRA_ENTRY_INFO);
                int i2 = AnonymousClass2.$SwitchMap$com$alibaba$ariver$app$api$activity$StartAction[this.mStartClientBundle.startAction.ordinal()];
                if (i2 != 1) {
                    if (i2 == 2) {
                        String string = BundleUtils.getString(this.mApp.getSceneParams(), RVConstants.EXTRA_PREPARE_EXCEPTION_CODE);
                        String string2 = BundleUtils.getString(this.mApp.getSceneParams(), RVConstants.EXTRA_PREPARE_EXCEPTION_MESSAGE);
                        if (this.mAppContext.getSplashView() != null) {
                            this.mAppContext.getSplashView().showError(string, string2, null);
                        }
                    } else if (i2 == 3) {
                        if (SplashUtils.useSuperSplash(this.mStartClientBundle.startParams)) {
                            RVLogger.d(LOG_TAG, " showLoading by superSplash!");
                            this.mAppContext.getSplashView().showLoading(entryInfo);
                        }
                        this.mApp.start();
                    }
                } else if (this.mAppContext.getSplashView() != null) {
                    this.mAppContext.getSplashView().showLoading(entryInfo);
                }
                if (ProcessUtils.isMainProcess()) {
                    IpcChannelManager.getInstance().registerClientChannel(getApp().getStartToken(), new IIpcChannel.Stub() { // from class: com.alibaba.ariver.app.activity.ActivityHelper.1
                        {
                            ActivityHelper.this = this;
                        }

                        @Override // com.alibaba.ariver.kernel.api.IIpcChannel
                        public void sendMessage(final IpcMessage ipcMessage) throws RemoteException {
                            ExecutorUtils.runOnMain(new Runnable() { // from class: com.alibaba.ariver.app.activity.ActivityHelper.1.1
                                {
                                    AnonymousClass1.this = this;
                                }

                                @Override // java.lang.Runnable
                                public void run() {
                                    ClientMsgReceiver.getInstance().handleMessage(ipcMessage);
                                }
                            });
                        }

                        @Override // com.alibaba.ariver.kernel.api.IIpcChannel
                        public boolean isFinishing() throws RemoteException {
                            return ActivityHelper.this.mAlreadyDoDestroyed || ActivityHelper.this.mApp == null || ActivityHelper.this.mApp.isExited() || ActivityHelper.this.mActivity.isFinishing();
                        }
                    });
                }
                ((ActivityHelperOnCreateFinishedPoint) ExtensionPoint.as(ActivityHelperOnCreateFinishedPoint.class).node(this.mApp).create()).onActivityHelperOnCreateFinished(this.mApp, this.mActivity, this.mStartClientBundle);
                RVTraceUtils.traceEndSection(RVTraceKey.RV_ActivityHelper_onCreate);
            } catch (Throwable th3) {
                Throwable cause3 = th3.getCause();
                if (cause3 == null) {
                    throw th3;
                }
                throw cause3;
            }
        } catch (Throwable th4) {
            Throwable cause4 = th4.getCause();
            if (cause4 == null) {
                throw th4;
            }
            throw cause4;
        }
    }

    /* renamed from: com.alibaba.ariver.app.activity.ActivityHelper$2 */
    /* loaded from: classes3.dex */
    public static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] $SwitchMap$com$alibaba$ariver$app$api$activity$StartAction;

        static {
            int[] iArr = new int[StartAction.values().length];
            $SwitchMap$com$alibaba$ariver$app$api$activity$StartAction = iArr;
            try {
                iArr[StartAction.SHOW_LOADING.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$alibaba$ariver$app$api$activity$StartAction[StartAction.SHOW_ERROR.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$alibaba$ariver$app$api$activity$StartAction[StartAction.DIRECT_START.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public void setupParams(Intent intent) {
        RVTraceUtils.traceBeginSection(RVTraceKey.RV_ActivityHelper_setupParams);
        if (intent != null) {
            try {
                if (intent.getExtras() != null) {
                    intent.getExtras().setClassLoader(ActivityHelper.class.getClassLoader());
                    this.mStartClientBundle = (StartClientBundle) BundleUtils.getParcelable(intent.getExtras(), RVConstants.EXTRA_ARIVER_START_BUNDLE);
                    this.mOnCreateWithIllegalState = (intent.getFlags() & CrashCombineUtils.DEFAULT_MAX_INFO_LEN) != 0;
                    StringBuilder sb = new StringBuilder();
                    sb.append("onCreate ");
                    sb.append(this.mActivity.getClass().getName());
                    sb.append(" with ");
                    sb.append(this.mStartClientBundle);
                    RVLogger.d(LOG_TAG, sb.toString());
                    StartClientBundle startClientBundle = this.mStartClientBundle;
                    if (startClientBundle == null) {
                        if (!handleStartClientBundleNull()) {
                            throw new IllegalStateException("onCreate start bundle null!!");
                        }
                        RVLogger.d(LOG_TAG, "onCreate mStartClientBundle == null, handle by handleStartClientBundleNull!");
                        return;
                    } else if ("yes".equals(BundleUtils.getString(startClientBundle.startParams, "CompletePreload", ""))) {
                        RVLogger.d(LOG_TAG, "setupParams is CompletePreload return, not do StatusBarUtils");
                        return;
                    } else {
                        if (StatusBarUtils.isSupport() && StatusBarUtils.isConfigSupport()) {
                            StatusBarUtils.setTransparentColor(this.mActivity, 855638016);
                        }
                        handleStartParams();
                        this.mStartToken = this.mStartClientBundle.startToken;
                        return;
                    }
                }
            } finally {
                RVTraceUtils.traceEndSection(RVTraceKey.RV_ActivityHelper_setupParams);
            }
        }
        throw new IllegalStateException("onCreate intent null!!");
    }

    public StartClientBundle getStartClientBundle() {
        return this.mStartClientBundle;
    }

    private void handleStartParams() {
        RVLogger.d(LOG_TAG, "NebulaActivity.onCreate handleStartParams start");
        try {
            this.mActivity.requestWindowFeature(1);
        } catch (Throwable th) {
            RVLogger.w(LOG_TAG, "requestWindowFeature error: ", th);
        }
        String string = BundleUtils.getString(this.mStartClientBundle.startParams, "snapshot");
        if ("NO".equalsIgnoreCase(string)) {
            StringBuilder sb = new StringBuilder();
            sb.append("not allowed to task snapshot ");
            sb.append(string);
            RVLogger.d(LOG_TAG, sb.toString());
            this.mActivity.getWindow().addFlags(8192);
        }
        if (BundleUtils.getBoolean(this.mStartClientBundle.startParams, "fullscreen", false)) {
            this.mActivity.getWindow().setFlags(1024, 1024);
        }
        String string2 = BundleUtils.getString(this.mStartClientBundle.startParams, "landscape");
        if (string2.equals("landscape")) {
            if (this.mActivity.getRequestedOrientation() != 0) {
                this.mActivity.setRequestedOrientation(0);
            }
        } else if (string2.equals("auto") && this.mActivity.getRequestedOrientation() != -1) {
            this.mActivity.setRequestedOrientation(-1);
        }
        boolean z = BundleUtils.getBoolean(this.mStartClientBundle.startParams, RVStartParams.KEY_RESTART, false);
        this.mCloseAllAnim = BundleUtils.getBoolean(this.mStartClientBundle.startParams, RVStartParams.KEY_CLOSE_ALL_ACTIVITY_ANIMATION, false);
        this.mActivityAnimBean = (ActivityAnimBean) BundleUtils.getParcelable(this.mStartClientBundle.sceneParams, RVConstants.EXTRA_ACTIVITY_ANIM_BEAN);
        StringBuilder sb2 = new StringBuilder();
        sb2.append("onCreate with animBean: ");
        sb2.append(this.mActivityAnimBean);
        RVLogger.d(LOG_TAG, sb2.toString());
        if (z) {
            RVLogger.d(LOG_TAG, "onCreate disable animBean fromRestart.");
            ActivityAnimBean activityAnimBean = this.mActivityAnimBean;
            if (activityAnimBean != null) {
                activityAnimBean.enter = 0;
            } else {
                this.mActivity.overridePendingTransition(0, 0);
            }
        }
        if (this.mCloseAllAnim || this.mOnCreateWithIllegalState) {
            this.mActivity.overridePendingTransition(0, 0);
        } else {
            ActivityAnimBean activityAnimBean2 = this.mActivityAnimBean;
            if (activityAnimBean2 != null) {
                this.mActivity.overridePendingTransition(activityAnimBean2.enter, this.mActivityAnimBean.exit);
            }
        }
        RVLogger.d(LOG_TAG, "onCreate handleStartParams done.");
    }

    public void onNewIntent(Intent intent) {
        ActivityAnimBean activityAnimBean;
        StringBuilder sb = new StringBuilder();
        sb.append("onNewIntent with intent: ");
        sb.append(intent);
        RVLogger.d(LOG_TAG, sb.toString());
        if (this.mApp == null) {
            return;
        }
        if (intent.getBooleanExtra(RVConstants.EXTRA_NEED_START_ANIM, true) && (activityAnimBean = this.mActivityAnimBean) != null && activityAnimBean.needRestartAnim) {
            this.mActivity.overridePendingTransition(this.mActivityAnimBean.enterFast, this.mActivityAnimBean.exitFast);
        }
        ((ActivityOnNewIntentPoint) ExtensionPoint.as(ActivityOnNewIntentPoint.class).node(this.mApp).create()).onNewIntent(this.mApp, this.mActivity, intent);
        Bundle extras = intent.getExtras();
        if (extras == null || intent.getBooleanExtra("IS_LITE_MOVE_TASK", false)) {
            return;
        }
        Bundle bundle = (Bundle) BundleUtils.getParcelable(extras, "startParams");
        Bundle bundle2 = (Bundle) BundleUtils.getParcelable(extras, RVConstants.EXTRA_SCENE_PARAMS);
        if (bundle != null) {
            this.mApp.restart(bundle, bundle2);
        }
    }

    public void onResume() {
        RVLogger.d(LOG_TAG, "onResume");
        AppNode appNode = this.mApp;
        if (appNode != null) {
            appNode.resume();
            ((EventTracker) RVProxy.get(EventTracker.class)).stub(this.mApp, TrackId.Stub_Activity_OnResume);
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        AppNode appNode = this.mApp;
        if (appNode == null) {
            RVLogger.d(LOG_TAG, "onActivityResult but mApp == null!");
            return;
        }
        Page activePage = appNode.getActivePage();
        Page page = appNode;
        if (activePage != null) {
            page = this.mApp.getActivePage();
        }
        ((ActivityResultPoint) ExtensionPoint.as(ActivityResultPoint.class).node(page).create()).onActivityResult(i, i2, intent);
    }

    public void onRequestPermissionResult(int i, String[] strArr, int[] iArr) {
        AppNode appNode = this.mApp;
        if (appNode != null && !appNode.isDestroyed()) {
            int childCount = this.mApp.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                Page pageByIndex = this.mApp.getPageByIndex(i2);
                if (pageByIndex.getPageContext() != null) {
                    pageByIndex.getPageContext().getEmbedViewManager().onRequestPermissionResult(i, strArr, iArr);
                }
            }
        }
        ((RVNativePermissionRequestProxy) RVProxy.get(RVNativePermissionRequestProxy.class)).onRequestPermissionResult(i, strArr, iArr);
    }

    public void moveTaskToBack() {
        if (this.mCloseAllAnim) {
            this.mActivity.overridePendingTransition(0, 0);
            return;
        }
        ActivityAnimBean activityAnimBean = this.mActivityAnimBean;
        if (activityAnimBean == null || !activityAnimBean.needPopAnim) {
            return;
        }
        this.mActivity.overridePendingTransition(this.mActivityAnimBean.popEnter, this.mActivityAnimBean.popExit);
    }

    public void finishAndRemoveTask() {
        doCommonDestroy();
    }

    public void finish() {
        doCommonDestroy();
    }

    public void onDestroy() {
        doCommonDestroy();
    }

    public void onStop() {
        RVLogger.d(LOG_TAG, "onStop");
        AppNode appNode = this.mApp;
        if (appNode != null) {
            appNode.pause();
        }
    }

    public void onPause() {
        RVLogger.d(LOG_TAG, "onPause");
        AppNode appNode = this.mApp;
        Page activePage = appNode.getActivePage();
        Page page = appNode;
        if (activePage != null) {
            page = this.mApp.getActivePage();
        }
        ((ActivityOnPausePoint) ExtensionPoint.as(ActivityOnPausePoint.class).node(page).create()).onPause();
    }

    public void onConfigurationChanged(Configuration configuration) {
        StringBuilder sb = new StringBuilder();
        sb.append("onConfigurationChanged: ");
        sb.append(configuration);
        RVLogger.d(LOG_TAG, sb.toString());
        AppNode appNode = this.mApp;
        if (appNode != null) {
            appNode.onConfigurationChanged(configuration);
        }
    }

    public void onUserInteraction() {
        AppNode appNode = this.mApp;
        if (appNode != null) {
            appNode.onUserInteraction();
        }
    }

    public void onUserLeaveHint() {
        AppNode appNode = this.mApp;
        if (appNode != null) {
            appNode.onUserLeaveHint();
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        StringBuilder sb = new StringBuilder();
        sb.append("onKeyDown ");
        sb.append(i);
        RVLogger.d(LOG_TAG, sb.toString());
        if (keyEvent.getKeyCode() == 4 && keyEvent.getRepeatCount() == 0) {
            if (this.mApp != null) {
                Boolean intercept = ((BackKeyDownPoint) ExtensionPoint.as(BackKeyDownPoint.class).node(this.mApp).defaultValue(Boolean.FALSE).create()).intercept(this.mApp);
                if (intercept == null || !intercept.booleanValue()) {
                    return this.mApp.backPressed();
                }
                return true;
            }
            FragmentActivity fragmentActivity = this.mActivity;
            if (fragmentActivity != null) {
                fragmentActivity.finish();
                return true;
            }
        }
        return false;
    }

    public void doCommonDestroy() {
        synchronized (this) {
            if (this.mAlreadyDoDestroyed) {
                return;
            }
            this.mAlreadyDoDestroyed = true;
            AppNode appNode = this.mApp;
            if (appNode == null) {
                RVLogger.w(LOG_TAG, "doCommonDestroy but mApp == null!");
                return;
            }
            if (BundleUtils.getBoolean(appNode.getSceneParams(), RVStartParams.KEY_CLOSE_ACTIVITY_WITH_CUSTOM_ANIMATION, false)) {
                this.mActivity.overridePendingTransition(0, 17432577);
            } else if (this.mCloseAllAnim) {
                this.mActivity.overridePendingTransition(0, 0);
            } else {
                ActivityAnimBean activityAnimBean = this.mActivityAnimBean;
                if (activityAnimBean != null && activityAnimBean.needPopAnim) {
                    this.mActivity.overridePendingTransition(this.mActivityAnimBean.popEnter, this.mActivityAnimBean.popExit);
                }
            }
            IpcChannelManager.getInstance().unRegisterClientChannel(this.mStartToken);
            AppNode appNode2 = this.mApp;
            if (appNode2 != null && !appNode2.isDestroyed()) {
                int childCount = this.mApp.getChildCount();
                StringBuilder sb = new StringBuilder();
                sb.append("doCommonDestroy force mApp.destroy with count: ");
                sb.append(childCount);
                RVLogger.w(LOG_TAG, sb.toString());
                if (childCount == 0) {
                    this.mApp.exit();
                }
            } else {
                this.mAppContext.destroy();
            }
        }
    }

    public App getApp() {
        return this.mApp;
    }
}
