package com.alipay.zoloz.hardware.camera.widget.permission;

import android.app.Fragment;
import android.graphics.Color;
import android.media.AudioTrack;
import android.os.Build;
import android.os.Bundle;
import android.os.Process;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.ViewConfiguration;
import android.widget.ExpandableListView;
import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.alipay.zoloz.hardware.camera.widget.PermissionCameraSurfaceView;
import com.google.common.base.Ascii;
import com.google.zxing.pdf417.PDF417Common;
import id.dana.onboarding.splash.LauncherActivity;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import o.SummaryVoucherView$$ExternalSyntheticLambda0;

/* loaded from: classes3.dex */
public class PermissionFragment extends Fragment {
    public static final byte[] $$a = {110, -41, 63, 58, -1, TarHeader.LF_NORMAL, -4, Ascii.EM, 7, -35, 43, 10, 3, -65, 39, 36, Ascii.SUB, -12, -54, 71, 8, 5, 16, -4, Ascii.CAN, -6, 6, -15, 40, 6, -20, 40, -12, Ascii.SUB, -4, 1, -15, Ascii.US, 15, -4, 10, Ascii.DC4, 8, -72, Ascii.NAK};
    public static final int $$b = 165;
    public static final byte[] KClassImpl$Data$declaredNonStaticMembers$2 = {8, -125, -40, -38, -7, -1, 7, 4, -13, 9, 3, -51, Ascii.ETB, 16, -13, -39, 42, -13, -1, -11, 19, -23, -53, 60, -13, 11, -9, -59, 35, 36, -8, -1, -17, 6};
    public static final int getAuthRequestContext = 171;
    private PermissionCameraSurfaceView mSurfaceView;
    private boolean mHasCameraPermission = true;
    private final int PERMISSIONS_REQUEST_CODE = 100;

    /* JADX WARN: Removed duplicated region for block: B:10:0x0028  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0020  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0028 -> B:11:0x0036). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void a(short r7, short r8, byte r9, java.lang.Object[] r10) {
        /*
            int r8 = r8 + 105
            int r7 = r7 * 15
            int r7 = 19 - r7
            int r9 = r9 * 3
            int r9 = r9 + 16
            byte[] r0 = com.alipay.zoloz.hardware.camera.widget.permission.PermissionFragment.KClassImpl$Data$declaredNonStaticMembers$2
            byte[] r1 = new byte[r9]
            int r9 = r9 + (-1)
            r2 = 0
            if (r0 != 0) goto L1a
            r8 = r7
            r3 = r1
            r4 = 0
            r1 = r0
            r0 = r10
            r10 = r9
            goto L36
        L1a:
            r3 = 0
        L1b:
            byte r4 = (byte) r8
            r1[r3] = r4
            if (r3 != r9) goto L28
            java.lang.String r7 = new java.lang.String
            r7.<init>(r1, r2)
            r10[r2] = r7
            return
        L28:
            int r3 = r3 + 1
            r4 = r0[r7]
            r5 = r8
            r8 = r7
            r7 = r5
            r6 = r10
            r10 = r9
            r9 = r4
            r4 = r3
            r3 = r1
            r1 = r0
            r0 = r6
        L36:
            int r7 = r7 + r9
            int r7 = r7 + 2
            int r8 = r8 + 1
            r9 = r10
            r10 = r0
            r0 = r1
            r1 = r3
            r3 = r4
            r5 = r8
            r8 = r7
            r7 = r5
            goto L1b
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.zoloz.hardware.camera.widget.permission.PermissionFragment.a(short, short, byte, java.lang.Object[]):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x002b  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x002b -> B:11:0x0035). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void b(short r7, byte r8, short r9, java.lang.Object[] r10) {
        /*
            byte[] r0 = com.alipay.zoloz.hardware.camera.widget.permission.PermissionFragment.$$a
            int r7 = r7 * 3
            int r7 = 42 - r7
            int r9 = r9 * 3
            int r9 = 75 - r9
            int r8 = r8 * 2
            int r8 = 4 - r8
            byte[] r1 = new byte[r7]
            r2 = 0
            if (r0 != 0) goto L1b
            r3 = r1
            r5 = 0
            r1 = r0
            r0 = r10
            r10 = r9
            r9 = r8
            r8 = r7
            goto L35
        L1b:
            r3 = 0
        L1c:
            byte r4 = (byte) r9
            int r5 = r3 + 1
            r1[r3] = r4
            if (r5 != r7) goto L2b
            java.lang.String r7 = new java.lang.String
            r7.<init>(r1, r2)
            r10[r2] = r7
            return
        L2b:
            r3 = r0[r8]
            r6 = r8
            r8 = r7
            r7 = r3
            r3 = r1
            r1 = r0
            r0 = r10
            r10 = r9
            r9 = r6
        L35:
            int r9 = r9 + 1
            int r10 = r10 + r7
            int r7 = r10 + (-7)
            r10 = r0
            r0 = r1
            r1 = r3
            r3 = r5
            r6 = r9
            r9 = r7
            r7 = r8
            r8 = r6
            goto L1c
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.zoloz.hardware.camera.widget.permission.PermissionFragment.b(short, byte, short, java.lang.Object[]):void");
    }

    @Override // android.app.Fragment
    public void onCreate(Bundle bundle) {
        try {
            byte b = (byte) (KClassImpl$Data$declaredNonStaticMembers$2[5] + 1);
            byte b2 = (byte) (-KClassImpl$Data$declaredNonStaticMembers$2[5]);
            Object[] objArr = new Object[1];
            a(b, b2, (byte) (b2 - 1), objArr);
            Class<?> cls = Class.forName((String) objArr[0]);
            byte b3 = (byte) (-KClassImpl$Data$declaredNonStaticMembers$2[5]);
            byte b4 = (byte) (b3 - 1);
            Object[] objArr2 = new Object[1];
            a(b3, b4, b4, objArr2);
            try {
                Object[] objArr3 = {Integer.valueOf(((Integer) cls.getMethod((String) objArr2[0], Object.class).invoke(null, this)).intValue())};
                Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(25207140);
                if (obj == null) {
                    Class cls2 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)) + 493, Color.green(0) + 4, (char) (ViewConfiguration.getLongPressTimeout() >> 16));
                    byte b5 = (byte) ($$a[35] - 1);
                    byte b6 = b5;
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
                            obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(TextUtils.indexOf("", "") + PDF417Common.NUMBER_OF_CODEWORDS, (Process.myTid() >> 22) + 35, (char) ExpandableListView.getPackedPositionGroup(0L))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj2);
                        }
                        Object invoke = ((Method) obj2).invoke(null, null);
                        try {
                            Object[] objArr6 = {-31049640, Long.valueOf(j), new ArrayList(), LauncherActivity.getAuid()};
                            Object obj3 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                            if (obj3 == null) {
                                obj3 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - ExpandableListView.getPackedPositionType(0L), (SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)) + 17, (char) (ViewConfiguration.getPressedStateDuration() >> 16))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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

    public void init(PermissionCameraSurfaceView permissionCameraSurfaceView) {
        this.mSurfaceView = permissionCameraSurfaceView;
        checkCameraPermission();
    }

    private void checkCameraPermission() {
        if (isMarshmallow()) {
            this.mHasCameraPermission = isGranted("android.permission.CAMERA");
        }
    }

    public boolean hasCameraPermission() {
        return this.mHasCameraPermission;
    }

    @Override // android.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.mHasCameraPermission) {
            return;
        }
        checkCameraPermission();
        this.mSurfaceView.setVisibility(0);
    }

    @Override // android.app.Fragment
    public void onPause() {
        super.onPause();
        if (this.mHasCameraPermission) {
            return;
        }
        this.mSurfaceView.setVisibility(4);
    }

    @Override // android.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.mSurfaceView.release();
    }

    boolean isGranted(String str) {
        return getActivity().checkSelfPermission(str) == 0;
    }

    private boolean isMarshmallow() {
        return Build.VERSION.SDK_INT >= 23;
    }

    public void requestPermission() {
        if (isMarshmallow()) {
            this.mSurfaceView.setVisibility(4);
            requestPermissions(new String[]{"android.permission.CAMERA"}, 100);
        }
    }

    @Override // android.app.Fragment
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        super.onRequestPermissionsResult(i, strArr, iArr);
        if (100 != i) {
            return;
        }
        if (iArr[0] == 0) {
            this.mHasCameraPermission = true;
        }
        this.mSurfaceView.setVisibility(0);
    }
}
