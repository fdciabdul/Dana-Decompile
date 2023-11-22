package com.alibaba.griver.core.ui.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.telephony.cdma.CdmaCellLocation;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.widget.ExpandableListView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.alibaba.ariver.app.AppNode;
import com.alibaba.ariver.app.activity.DefaultFragmentManager;
import com.alibaba.ariver.app.api.App;
import com.alibaba.ariver.app.api.AppContext;
import com.alibaba.ariver.app.api.point.app.BackKeyDownPoint;
import com.alibaba.ariver.app.api.ui.fragment.IFragmentManager;
import com.alibaba.ariver.app.ipc.ClientMsgReceiver;
import com.alibaba.ariver.app.ipc.IpcClientUtils;
import com.alibaba.ariver.kernel.api.extension.ExtensionPoint;
import com.alibaba.ariver.kernel.ipc.IpcMessageConstants;
import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.alibaba.griver.base.common.logger.GriverLogger;
import com.alibaba.griver.core.R;
import com.alibaba.griver.core.ui.NebulaAppContext;
import com.google.common.base.Ascii;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import id.dana.onboarding.splash.LauncherActivity;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import o.SummaryVoucherView$$ExternalSyntheticLambda0;

/* loaded from: classes6.dex */
public class GriverBaseFragment extends Fragment {
    protected FragmentHelper mActivityHelper;
    public static final byte[] $$a = {111, 16, 84, -34, 1, -48, 4, -25, -7, 35, -43, -10, -3, 65, -39, -36, -26, 12, TarHeader.LF_FIFO, -71, -8, -5, -16, 4, -24, 6, -6, 15, -40, -6, Ascii.DC4, -40, 12, -26, 4, -1, 15, -31, -15, 4, -10, -20, -8, 72, -21};
    public static final int $$b = 225;
    public static final byte[] PlaceComponentResult = {65, TarHeader.LF_CHR, -100, -34, 7, 1, -7, -4, 13, -9, -3, TarHeader.LF_CHR, -23, -16, 13, 39, -42, 13, 1, 11, -19, Ascii.ETB, TarHeader.LF_DIR, -60, 13, -11, 9, 59, -35, -36, 8, 1, 17, -6};
    public static final int MyBillsEntityDataFactory = 240;

    /* JADX WARN: Removed duplicated region for block: B:10:0x002c  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x002c -> B:11:0x0034). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void a(byte r6, short r7, byte r8, java.lang.Object[] r9) {
        /*
            byte[] r0 = com.alibaba.griver.core.ui.fragment.GriverBaseFragment.PlaceComponentResult
            int r6 = r6 * 3
            int r6 = 16 - r6
            int r8 = r8 * 15
            int r8 = 19 - r8
            int r7 = 106 - r7
            byte[] r1 = new byte[r6]
            int r6 = r6 + (-1)
            r2 = 0
            if (r0 != 0) goto L19
            r3 = r1
            r4 = 0
            r1 = r0
            r0 = r9
            r9 = r8
            goto L34
        L19:
            r3 = 0
            r5 = r8
            r8 = r7
            r7 = r5
        L1d:
            byte r4 = (byte) r8
            r1[r3] = r4
            int r4 = r3 + 1
            if (r3 != r6) goto L2c
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            r9[r2] = r6
            return
        L2c:
            r3 = r0[r7]
            r5 = r9
            r9 = r7
            r7 = r3
            r3 = r1
            r1 = r0
            r0 = r5
        L34:
            int r7 = -r7
            int r8 = r8 + r7
            int r7 = r9 + 1
            int r8 = r8 + 2
            r9 = r0
            r0 = r1
            r1 = r3
            r3 = r4
            goto L1d
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.griver.core.ui.fragment.GriverBaseFragment.a(byte, short, byte, java.lang.Object[]):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0029  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0021  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0029 -> B:11:0x0034). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void b(short r6, short r7, short r8, java.lang.Object[] r9) {
        /*
            int r6 = r6 + 4
            byte[] r0 = com.alibaba.griver.core.ui.fragment.GriverBaseFragment.$$a
            int r7 = r7 * 3
            int r7 = 75 - r7
            int r8 = r8 * 2
            int r8 = r8 + 42
            byte[] r1 = new byte[r8]
            int r8 = r8 + (-1)
            r2 = 0
            if (r0 != 0) goto L19
            r3 = r1
            r4 = 0
            r1 = r0
            r0 = r9
            r9 = r8
            goto L34
        L19:
            r3 = 0
        L1a:
            int r6 = r6 + 1
            byte r4 = (byte) r7
            r1[r3] = r4
            if (r3 != r8) goto L29
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            r9[r2] = r6
            return
        L29:
            r4 = r0[r6]
            int r3 = r3 + 1
            r5 = r9
            r9 = r8
            r8 = r4
            r4 = r3
            r3 = r1
            r1 = r0
            r0 = r5
        L34:
            int r8 = -r8
            int r7 = r7 + r8
            int r7 = r7 + (-7)
            r8 = r9
            r9 = r0
            r0 = r1
            r1 = r3
            r3 = r4
            goto L1a
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.griver.core.ui.fragment.GriverBaseFragment.b(short, short, short, java.lang.Object[]):void");
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        try {
            byte b = (byte) (PlaceComponentResult[5] - 1);
            byte b2 = b;
            Object[] objArr = new Object[1];
            a(b, b2, b2, objArr);
            Class<?> cls = Class.forName((String) objArr[0]);
            byte b3 = (byte) (PlaceComponentResult[5] - 1);
            byte b4 = PlaceComponentResult[5];
            Object[] objArr2 = new Object[1];
            a(b3, b4, b4, objArr2);
            try {
                Object[] objArr3 = {Integer.valueOf(((Integer) cls.getMethod((String) objArr2[0], Object.class).invoke(null, this)).intValue())};
                Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(25207140);
                if (obj == null) {
                    Class cls2 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(494 - (ViewConfiguration.getJumpTapTimeout() >> 16), (ViewConfiguration.getTapTimeout() >> 16) + 4, (char) (ViewConfiguration.getJumpTapTimeout() >> 16));
                    byte b5 = $$a[35];
                    byte b6 = (byte) (b5 + 1);
                    Object[] objArr4 = new Object[1];
                    b(b5, b6, b6, objArr4);
                    obj = cls2.getMethod((String) objArr4[0], Integer.TYPE);
                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(25207140, obj);
                }
                Object[] objArr5 = (Object[]) ((Method) obj).invoke(null, objArr3);
                int i = ((int[]) objArr5[1])[0];
                if (((int[]) objArr5[0])[0] != i) {
                    long j = ((r2 ^ i) & 4294967295L) | 42949672960L;
                    try {
                        Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                        if (obj2 == null) {
                            obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - (ViewConfiguration.getKeyRepeatDelay() >> 16), 34 - ExpandableListView.getPackedPositionChild(0L), (char) (ViewConfiguration.getEdgeSlop() >> 16))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj2);
                        }
                        Object invoke = ((Method) obj2).invoke(null, null);
                        try {
                            Object[] objArr6 = {-1278589676, Long.valueOf(j), new ArrayList(), LauncherActivity.getAuid()};
                            Object obj3 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                            if (obj3 == null) {
                                obj3 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)), 18 - (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)), (char) (CdmaCellLocation.convertQuartSecToDecDegrees(0) > FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 0 : -1)))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                super.onCreate(bundle);
                StringBuilder sb = new StringBuilder();
                sb.append("fragment ");
                sb.append(hashCode());
                sb.append(" onCreate");
                GriverLogger.d("NebulaFragmentBase", sb.toString());
                if (bundle != null) {
                    return;
                }
                this.mActivityHelper = new FragmentHelper(getActivity()) { // from class: com.alibaba.griver.core.ui.fragment.GriverBaseFragment.1
                    @Override // com.alibaba.griver.core.ui.fragment.FragmentHelper
                    protected AppContext createAppContext(App app, FragmentActivity fragmentActivity) {
                        return GriverBaseFragment.this.createAppContext(app, R.id.fragment_container, R.id.tab_container);
                    }
                };
                Intent intent = new Intent();
                intent.putExtras(getArguments());
                this.mActivityHelper.setupParams(intent);
                this.mActivityHelper.onCreate();
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
        StringBuilder sb = new StringBuilder();
        sb.append("fragment ");
        sb.append(hashCode());
        sb.append(" onCreateView");
        GriverLogger.d("NebulaFragmentBase", sb.toString());
        return layoutInflater.inflate(R.layout.griver_layout_base_activity, viewGroup, false);
    }

    public AppContext createAppContext(App app, int i, int i2) {
        return new FragmentAppContext(app, i, i2);
    }

    /* loaded from: classes6.dex */
    public class FragmentAppContext extends NebulaAppContext {
        public FragmentAppContext(App app, int i, int i2) {
            super((AppNode) app, GriverBaseFragment.this.getActivity(), i, i2);
        }

        @Override // com.alibaba.griver.core.ui.NebulaAppContext, com.alibaba.ariver.app.BaseAppContext
        public IFragmentManager createFragmentManager(int i) {
            return new DefaultFragmentManager(getApp(), i, GriverBaseFragment.this);
        }

        @Override // com.alibaba.griver.core.ui.NebulaAppContext, com.alibaba.ariver.app.BaseAppContext
        public void onDestroy() {
            Bundle bundle = new Bundle();
            bundle.putString("appId", getApp().getAppId());
            bundle.putLong(IpcMessageConstants.EXTRA_NODE_ID, getApp().getNodeId());
            IpcClientUtils.sendMsgToServerByApp(getApp(), 2, bundle);
            IFragmentManager fragmentManager = getFragmentManager();
            if (fragmentManager != null) {
                fragmentManager.release();
            }
            ClientMsgReceiver.getInstance().unRegisterAppHandler(getApp().getStartToken());
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        StringBuilder sb = new StringBuilder();
        sb.append("fragment ");
        sb.append(hashCode());
        sb.append(" onDestroyView");
        GriverLogger.d("NebulaFragmentBase", sb.toString());
        super.onDestroyView();
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        StringBuilder sb = new StringBuilder();
        sb.append("fragment ");
        sb.append(hashCode());
        sb.append(" onDestroy");
        GriverLogger.d("NebulaFragmentBase", sb.toString());
        FragmentHelper fragmentHelper = this.mActivityHelper;
        if (fragmentHelper != null) {
            App app = fragmentHelper.getApp();
            this.mActivityHelper.doCommonDestroy();
            if (app != null && !app.isDestroyed()) {
                app.exit();
            }
            FragmentHelper fragmentHelper2 = this.mActivityHelper;
            if (fragmentHelper2 != null) {
                fragmentHelper2.onDestroy();
            }
            super.onDestroy();
            return;
        }
        super.onDestroy();
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        StringBuilder sb = new StringBuilder();
        sb.append("fragment ");
        sb.append(hashCode());
        sb.append(" onStop");
        GriverLogger.d("NebulaFragmentBase", sb.toString());
        super.onStop();
        FragmentHelper fragmentHelper = this.mActivityHelper;
        if (fragmentHelper != null) {
            fragmentHelper.onStop();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        StringBuilder sb = new StringBuilder();
        sb.append("fragment ");
        sb.append(hashCode());
        sb.append(" onPause");
        GriverLogger.d("NebulaFragmentBase", sb.toString());
        super.onPause();
        FragmentHelper fragmentHelper = this.mActivityHelper;
        if (fragmentHelper != null) {
            fragmentHelper.onPause();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        StringBuilder sb = new StringBuilder();
        sb.append("fragment ");
        sb.append(hashCode());
        sb.append(" onResume");
        GriverLogger.d("NebulaFragmentBase", sb.toString());
        super.onResume();
        FragmentHelper fragmentHelper = this.mActivityHelper;
        if (fragmentHelper != null) {
            fragmentHelper.onResume();
        }
    }

    public void onUserLeaveHint() {
        FragmentHelper fragmentHelper = this.mActivityHelper;
        if (fragmentHelper != null) {
            fragmentHelper.onUserLeaveHint();
        }
    }

    public void onUserInteraction() {
        FragmentHelper fragmentHelper = this.mActivityHelper;
        if (fragmentHelper != null) {
            fragmentHelper.onUserInteraction();
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        FragmentHelper fragmentHelper = this.mActivityHelper;
        if (fragmentHelper != null) {
            if (fragmentHelper.getApp() != null) {
                if (this.mActivityHelper.getApp().isFirstPage() || this.mActivityHelper.getApp().getAlivePageCount() <= 0) {
                    return false;
                }
                if (this.mActivityHelper.getApp().getActivePage() != null && this.mActivityHelper.getApp().getIndexOfChild(this.mActivityHelper.getApp().getActivePage()) <= 0) {
                    return false;
                }
            }
            return this.mActivityHelper.onKeyDown(i, keyEvent);
        }
        return false;
    }

    public boolean backPressed() {
        FragmentHelper fragmentHelper = this.mActivityHelper;
        if (fragmentHelper != null) {
            if (fragmentHelper.getApp() != null) {
                if (this.mActivityHelper.getApp().isFirstPage() || this.mActivityHelper.getApp().getAlivePageCount() <= 0) {
                    return false;
                }
                if (this.mActivityHelper.getApp().getActivePage() != null && this.mActivityHelper.getApp().getIndexOfChild(this.mActivityHelper.getApp().getActivePage()) <= 0) {
                    return false;
                }
            }
            if (this.mActivityHelper.getApp() != null) {
                Boolean intercept = ((BackKeyDownPoint) ExtensionPoint.as(BackKeyDownPoint.class).node(this.mActivityHelper.getApp()).defaultValue(Boolean.FALSE).create()).intercept(this.mActivityHelper.getApp());
                if (intercept == null || !intercept.booleanValue()) {
                    return this.mActivityHelper.getApp().backPressed();
                }
                return true;
            }
        }
        return false;
    }

    @Override // androidx.fragment.app.Fragment
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        FragmentHelper fragmentHelper = this.mActivityHelper;
        if (fragmentHelper != null) {
            fragmentHelper.onRequestPermissionResult(i, strArr, iArr);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        FragmentHelper fragmentHelper = this.mActivityHelper;
        if (fragmentHelper != null) {
            fragmentHelper.onActivityResult(i, i2, intent);
        }
    }
}
