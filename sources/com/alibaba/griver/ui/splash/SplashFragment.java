package com.alibaba.griver.ui.splash;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;
import com.alibaba.ariver.app.api.ui.StatusBarUtils;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.griver.api.ui.splash.GriverSplashFragmentExtension;
import com.alibaba.griver.api.ui.splash.SplashEntryInfo;
import com.alibaba.griver.base.common.logger.GriverLogger;
import com.alibaba.griver.base.common.utils.ImageUtils;
import com.alibaba.griver.ui.R;
import com.alibaba.wireless.security.SecExceptionCode;
import com.google.common.base.Ascii;
import id.dana.onboarding.splash.LauncherActivity;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import o.SummaryVoucherView$$ExternalSyntheticLambda0;

/* loaded from: classes3.dex */
public class SplashFragment extends GriverSplashFragmentExtension.AbstractSplashFragment {
    public static final String FRAGMENT_TAG = "SplashViewImpl";

    /* renamed from: a */
    private ImageView f6754a;
    private LoadingView b;
    private LinearLayout c;
    private TextView d;
    private Button e;
    private JSONObject f;
    public OnLoadingViewInitListener loadingViewInitListener;
    public static final byte[] $$a = {10, Byte.MIN_VALUE, TarHeader.LF_LINK, 76, 1, -48, 4, -25, -7, 35, -43, -10, -3, 65, -39, -36, -26, 12, TarHeader.LF_FIFO, -71, -8, -5, -16, 4, -24, 6, -6, 15, -40, -6, Ascii.DC4, -40, 12, -26, 4, -1, 15, -31, -15, 4, -10, -20, -8, 72, -21};
    public static final int $$b = 4;
    public static final byte[] MyBillsEntityDataFactory = {116, -27, -60, 115, -7, -1, 7, 4, -13, 9, 3, -51, Ascii.ETB, 16, -13, -39, 42, -13, -1, -11, 19, -23, -53, 60, -13, 11, -9, -59, 35, 36, -8, -1, -17, 6};
    public static final int PlaceComponentResult = SecExceptionCode.SEC_ERROR_STA_STORE_LOW_VERSION_DATA_FILE;

    /* loaded from: classes3.dex */
    public interface OnLoadingViewInitListener {
        void onInited(LoadingView loadingView);
    }

    private static void g(short s, short s2, byte b, Object[] objArr) {
        int i = (s2 * 3) + 16;
        int i2 = 106 - b;
        int i3 = 19 - (s * 15);
        byte[] bArr = MyBillsEntityDataFactory;
        byte[] bArr2 = new byte[i];
        int i4 = -1;
        int i5 = i - 1;
        if (bArr == null) {
            i3++;
            i2 = i3 + i2 + 2;
        }
        while (true) {
            i4++;
            bArr2[i4] = (byte) i2;
            if (i4 == i5) {
                objArr[0] = new String(bArr2, 0);
                return;
            }
            byte b2 = bArr[i3];
            i3++;
            i2 = i2 + b2 + 2;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0021  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0029  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:22:0x0029 -> B:23:0x002e). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void h(int r6, int r7, int r8, java.lang.Object[] r9) {
        /*
            int r8 = r8 * 4
            int r8 = 4 - r8
            int r6 = r6 * 4
            int r6 = r6 + 42
            int r7 = r7 * 2
            int r7 = 75 - r7
            byte[] r0 = com.alibaba.griver.ui.splash.SplashFragment.$$a
            byte[] r1 = new byte[r6]
            int r6 = r6 + (-1)
            r2 = 0
            if (r0 != 0) goto L19
            r3 = r7
            r4 = 0
            r7 = r6
            goto L2e
        L19:
            r3 = 0
        L1a:
            byte r4 = (byte) r7
            r1[r3] = r4
            int r4 = r3 + 1
            if (r3 != r6) goto L29
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            r9[r2] = r6
            return
        L29:
            r3 = r0[r8]
            r5 = r7
            r7 = r6
            r6 = r5
        L2e:
            int r3 = -r3
            int r8 = r8 + 1
            int r6 = r6 + r3
            int r6 = r6 + (-7)
            r3 = r4
            r5 = r7
            r7 = r6
            r6 = r5
            goto L1a
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.griver.ui.splash.SplashFragment.h(int, int, int, java.lang.Object[]):void");
    }

    @Override // com.alibaba.griver.api.ui.splash.GriverSplashFragmentExtension.AbstractSplashFragment
    public void exit() {
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        try {
            byte b = (byte) (MyBillsEntityDataFactory[5] + 1);
            byte b2 = b;
            Object[] objArr = new Object[1];
            g(b, b2, b2, objArr);
            Class<?> cls = Class.forName((String) objArr[0]);
            byte b3 = (byte) (-MyBillsEntityDataFactory[5]);
            Object[] objArr2 = new Object[1];
            g(b3, (byte) (b3 - 1), (byte) (-MyBillsEntityDataFactory[5]), objArr2);
            try {
                Object[] objArr3 = {Integer.valueOf(((Integer) cls.getMethod((String) objArr2[0], Object.class).invoke(null, this)).intValue())};
                Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(25207140);
                if (obj == null) {
                    Class cls2 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(494 - KeyEvent.keyCodeFromString(""), 4 - View.resolveSizeAndState(0, 0, 0), (char) View.resolveSizeAndState(0, 0, 0));
                    byte b4 = (byte) ($$b - 4);
                    byte b5 = b4;
                    Object[] objArr4 = new Object[1];
                    h(b4, b5, b5, objArr4);
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
                            obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(928 - TextUtils.indexOf((CharSequence) "", '0', 0, 0), 35 - Color.green(0), (char) (ViewConfiguration.getMaximumFlingVelocity() >> 16))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj2);
                        }
                        Object invoke = ((Method) obj2).invoke(null, null);
                        try {
                            Object[] objArr6 = {-548402394, Long.valueOf(j), new ArrayList(), LauncherActivity.getAuid()};
                            Object obj3 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                            if (obj3 == null) {
                                obj3 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(Color.alpha(0) + 911, View.MeasureSpec.makeMeasureSpec(0, 0) + 18, (char) (TextUtils.lastIndexOf("", '0', 0) + 1))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                RVLogger.d("SplashFragment", "SplashFragment.onCreate");
                super.onCreate(bundle);
                if (getArguments() != null) {
                    getArguments().setClassLoader(SplashFragment.class.getClassLoader());
                }
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

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        RVLogger.d("SplashFragment", "SplashFragment.onCreateLoadingView");
        View inflate = layoutInflater.inflate(R.layout.griver_ui_fragment_splash, viewGroup, false);
        this.b = (LoadingView) inflate.findViewById(R.id.view_splash_loading);
        this.c = (LinearLayout) inflate.findViewById(R.id.view_splash_error);
        this.b.setHostActivity(getActivity());
        OnLoadingViewInitListener onLoadingViewInitListener = this.loadingViewInitListener;
        if (onLoadingViewInitListener != null) {
            onLoadingViewInitListener.onInited(this.b);
        }
        ImageView imageView = (ImageView) inflate.findViewById(R.id.tv_back_button);
        this.f6754a = imageView;
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.alibaba.griver.ui.splash.SplashFragment.1
            {
                SplashFragment.this = this;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                FragmentActivity activity = SplashFragment.this.getActivity();
                if (SplashFragment.this.b != null) {
                    SplashFragment.this.b.cancel();
                }
                if (activity != null) {
                    activity.finish();
                }
            }
        });
        Button button = (Button) inflate.findViewById(R.id.btn_reload);
        this.e = button;
        button.setOnClickListener(new View.OnClickListener() { // from class: com.alibaba.griver.ui.splash.SplashFragment.2
            {
                SplashFragment.this = this;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                SplashFragment.this.reload();
            }
        });
        this.d = (TextView) inflate.findViewById(R.id.tv_error);
        if (StatusBarUtils.isSupport() && StatusBarUtils.isConfigSupport()) {
            inflate.setPadding(0, StatusBarUtils.getStatusBarHeight(getActivity()), 0, 0);
        }
        return inflate;
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        RVLogger.d("SplashFragment", "SplashFragment.onResume");
        super.onResume();
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        LoadingView loadingView = this.b;
        if (loadingView != null) {
            loadingView.start();
        }
        super.onStart();
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        RVLogger.d("SplashFragment", "SplashFragment.onStop");
        LoadingView loadingView = this.b;
        if (loadingView != null) {
            loadingView.stop();
        }
        super.onStop();
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        RVLogger.d("SplashFragment", "SplashFragment.onDestroy");
        LoadingView loadingView = this.b;
        if (loadingView != null) {
            loadingView.stop();
        }
        super.onDestroy();
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
    }

    @Override // com.alibaba.griver.api.ui.splash.GriverSplashFragmentExtension.AbstractSplashFragment
    public void showError(String str, String str2) {
        LoadingView loadingView = this.b;
        if (loadingView != null) {
            loadingView.onStop();
            this.d.setText(String.format(getString(R.string.griver_prepare_app_failed_error_code), str));
            this.b.setVisibility(8);
            this.c.setVisibility(0);
        }
    }

    @Override // com.alibaba.griver.api.ui.splash.GriverSplashFragmentExtension.AbstractSplashFragment
    public void updateLoadingInfo(SplashEntryInfo splashEntryInfo) {
        if (this.b == null || splashEntryInfo == null) {
            return;
        }
        a(splashEntryInfo.appId);
        this.b.setVisibility(0);
        this.c.setVisibility(8);
        this.b.onStart();
        StringBuilder sb = new StringBuilder();
        sb.append("update loading info: ");
        sb.append(splashEntryInfo.toString());
        GriverLogger.d("SplashFragment", sb.toString());
        HashMap hashMap = new HashMap();
        hashMap.put(SplashLoadingView.DATA_UPDATE_APPEARANCE_LOADING_TEXT, !TextUtils.isEmpty(splashEntryInfo.appName) ? splashEntryInfo.appName : getString(R.string.griver_prepare_app_name_default));
        hashMap.put(SplashLoadingView.DATA_UPDATE_APPEARANCE_LOADING_BOTTOM_TIP, splashEntryInfo.slogan);
        this.b.sendMessage(SplashLoadingView.MSG_UPDATE_APPEARANCE, hashMap);
        if (TextUtils.isEmpty(splashEntryInfo.iconUrl) || this.b.getIconImageView() == null || getContext() == null) {
            return;
        }
        ImageUtils.loadImage(this.b.getIconImageView(), ContextCompat.PlaceComponentResult(getContext(), R.drawable.griver_ui_default_loading_icon), splashEntryInfo.iconUrl);
    }

    /* JADX WARN: Code restructure failed: missing block: B:35:0x0036, code lost:
    
        if (r1.contains(r4) != false) goto L36;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void a(java.lang.String r4) {
        /*
            r3 = this;
            boolean r0 = android.text.TextUtils.isEmpty(r4)
            if (r0 == 0) goto L7
            return
        L7:
            com.alibaba.fastjson.JSONObject r0 = r3.f     // Catch: java.lang.Exception -> L3f
            if (r0 != 0) goto L17
            java.lang.String r0 = "defaultSplashViewLoadingStyle"
            java.lang.String r0 = com.alibaba.griver.base.common.config.GriverInnerConfig.getConfig(r0)     // Catch: java.lang.Exception -> L3f
            com.alibaba.fastjson.JSONObject r0 = com.alibaba.fastjson.JSON.parseObject(r0)     // Catch: java.lang.Exception -> L3f
            r3.f = r0     // Catch: java.lang.Exception -> L3f
        L17:
            com.alibaba.fastjson.JSONObject r0 = r3.f     // Catch: java.lang.Exception -> L3f
            java.lang.String r1 = "allUseProgressStyle"
            java.lang.Boolean r0 = r0.getBoolean(r1)     // Catch: java.lang.Exception -> L3f
            boolean r0 = r0.booleanValue()     // Catch: java.lang.Exception -> L3f
            com.alibaba.fastjson.JSONObject r1 = r3.f     // Catch: java.lang.Exception -> L3f
            java.lang.String r2 = "specificAppIds"
            com.alibaba.fastjson.JSONArray r1 = r1.getJSONArray(r2)     // Catch: java.lang.Exception -> L3f
            r2 = 0
            if (r0 == 0) goto L30
            goto L38
        L30:
            if (r1 == 0) goto L39
            boolean r4 = r1.contains(r4)     // Catch: java.lang.Exception -> L3f
            if (r4 == 0) goto L39
        L38:
            r2 = 1
        L39:
            com.alibaba.griver.ui.splash.LoadingView r4 = r3.b     // Catch: java.lang.Exception -> L3f
            r4.setProgressType(r2)     // Catch: java.lang.Exception -> L3f
            return
        L3f:
            r4 = move-exception
            java.lang.String r4 = java.lang.String.valueOf(r4)
            java.lang.String r0 = "SplashFragment"
            com.alibaba.griver.base.common.logger.GriverLogger.w(r0, r4)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.griver.ui.splash.SplashFragment.a(java.lang.String):void");
    }

    @Override // com.alibaba.griver.api.ui.splash.GriverSplashFragmentExtension.AbstractSplashFragment
    public void updateProgress(SplashEntryInfo splashEntryInfo) {
        LoadingView loadingView = this.b;
        if (loadingView == null || splashEntryInfo == null) {
            return;
        }
        loadingView.setVisibility(0);
        this.c.setVisibility(8);
        StringBuilder sb = new StringBuilder();
        sb.append("update loading info: ");
        sb.append(splashEntryInfo);
        GriverLogger.d("SplashFragment", sb.toString());
        HashMap hashMap = new HashMap();
        hashMap.put(SplashLoadingView.DATA_UPDATE_APPEARANCE_LOADING_PROGRESS, Integer.valueOf(splashEntryInfo.progress));
        this.b.sendMessage(SplashLoadingView.MSG_UPDATE_APPEARANCE, hashMap);
    }

    public void setBackButtonVisibility(int i) {
        ImageView imageView = this.f6754a;
        if (imageView == null) {
            return;
        }
        final Context context = imageView.getContext();
        if (i == 4 || i == 8) {
            this.f6754a.setVisibility(i);
            return;
        }
        this.f6754a.setVisibility(0);
        this.f6754a.setOnClickListener(new View.OnClickListener() { // from class: com.alibaba.griver.ui.splash.SplashFragment.3
            {
                SplashFragment.this = this;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (SplashFragment.this.b != null) {
                    SplashFragment.this.b.cancel();
                }
                Context context2 = context;
                if (context2 == null || !(context2 instanceof Activity)) {
                    return;
                }
                ((Activity) context2).finish();
            }
        });
    }
}
