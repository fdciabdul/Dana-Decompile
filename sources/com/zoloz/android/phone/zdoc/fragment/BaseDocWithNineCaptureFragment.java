package com.zoloz.android.phone.zdoc.fragment;

import android.graphics.Color;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.KeyEvent;
import android.view.ViewConfiguration;
import android.widget.ExpandableListView;
import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.alipay.mobile.security.bio.service.BioUploadResult;
import com.alipay.zoloz.hardware.camera.CameraData;
import com.google.common.base.Ascii;
import com.zoloz.android.phone.zdoc.service.DocMonitorFrameManager;
import com.zoloz.android.phone.zdoc.service.IMonitorCallback;
import id.dana.onboarding.splash.LauncherActivity;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import o.SummaryVoucherView$$ExternalSyntheticLambda0;

/* loaded from: classes8.dex */
public class BaseDocWithNineCaptureFragment extends BaseDocFragment {
    public static final byte[] $$d = {38, -105, 32, Ascii.RS, -1, TarHeader.LF_NORMAL, -4, Ascii.EM, 7, -35, 43, 10, 3, -65, 39, 36, Ascii.SUB, -12, -54, 71, 8, 5, 16, -4, Ascii.CAN, -6, 6, -15, 40, 6, -20, 40, -12, Ascii.SUB, -4, 1, -15, Ascii.US, 15, -4, 10, Ascii.DC4, 8, -72, Ascii.NAK};
    public static final int $$e = 254;
    public static final byte[] MyBillsEntityDataFactory = {104, -34, -42, -1, -7, -1, 7, 4, -13, 9, 3, -51, Ascii.ETB, 16, -13, -39, 42, -13, -1, -11, 19, -23, -53, 60, -13, 11, -9, -59, 35, 36, -8, -1, -17, 6};
    public static final int NetworkUserEntityData$$ExternalSyntheticLambda0 = 176;
    private DocMonitorFrameManager mDocMonitorFrameManager;
    private boolean isGettingPreviewImg = false;
    private boolean isCameraCanUsed = false;

    private static void c(short s, int i, byte b, Object[] objArr) {
        int i2 = b + 105;
        int i3 = 16 - (i * 3);
        int i4 = 19 - (s * 15);
        byte[] bArr = MyBillsEntityDataFactory;
        byte[] bArr2 = new byte[i3];
        int i5 = i3 - 1;
        int i6 = 0;
        if (bArr == null) {
            i4++;
            i2 = i5 + i4 + 2;
            i5 = i5;
        }
        while (true) {
            bArr2[i6] = (byte) i2;
            if (i6 == i5) {
                objArr[0] = new String(bArr2, 0);
                return;
            }
            byte b2 = bArr[i4];
            i6++;
            i4++;
            i2 = i2 + b2 + 2;
            i5 = i5;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x002e  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0026  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x002e -> B:11:0x0037). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void d(byte r6, short r7, short r8, java.lang.Object[] r9) {
        /*
            int r7 = r7 * 2
            int r7 = 3 - r7
            int r6 = r6 * 3
            int r6 = 42 - r6
            int r8 = r8 * 3
            int r8 = r8 + 75
            byte[] r0 = com.zoloz.android.phone.zdoc.fragment.BaseDocWithNineCaptureFragment.$$d
            byte[] r1 = new byte[r6]
            int r6 = r6 + (-1)
            r2 = 0
            if (r0 != 0) goto L1c
            r3 = r1
            r4 = 0
            r1 = r0
            r0 = r9
            r9 = r8
            r8 = r7
            goto L37
        L1c:
            r3 = 0
        L1d:
            byte r4 = (byte) r8
            r1[r3] = r4
            int r4 = r3 + 1
            int r7 = r7 + 1
            if (r3 != r6) goto L2e
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            r9[r2] = r6
            return
        L2e:
            r3 = r0[r7]
            r5 = r8
            r8 = r7
            r7 = r3
            r3 = r1
            r1 = r0
            r0 = r9
            r9 = r5
        L37:
            int r9 = r9 + r7
            int r7 = r9 + (-7)
            r9 = r0
            r0 = r1
            r1 = r3
            r3 = r4
            r5 = r8
            r8 = r7
            r7 = r5
            goto L1d
        */
        throw new UnsupportedOperationException("Method not decompiled: com.zoloz.android.phone.zdoc.fragment.BaseDocWithNineCaptureFragment.d(byte, short, short, java.lang.Object[]):void");
    }

    @Override // com.zoloz.android.phone.zdoc.fragment.BaseDocFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        try {
            byte b = (byte) (MyBillsEntityDataFactory[3] + 1);
            Object[] objArr = new Object[1];
            c(b, b, (byte) (-MyBillsEntityDataFactory[3]), objArr);
            Class<?> cls = Class.forName((String) objArr[0]);
            byte b2 = (byte) (-MyBillsEntityDataFactory[3]);
            byte b3 = (byte) (b2 - 1);
            Object[] objArr2 = new Object[1];
            c(b2, b3, b3, objArr2);
            try {
                Object[] objArr3 = {Integer.valueOf(((Integer) cls.getMethod((String) objArr2[0], Object.class).invoke(null, this)).intValue())};
                Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(25207140);
                if (obj == null) {
                    Class cls2 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getScrollBarSize() >> 8) + 494, 4 - Color.argb(0, 0, 0, 0), (char) ((-1) - ExpandableListView.getPackedPositionChild(0L)));
                    byte b4 = (byte) ($$d[35] - 1);
                    byte b5 = b4;
                    Object[] objArr4 = new Object[1];
                    d(b4, b5, b5, objArr4);
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
                            obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - (ViewConfiguration.getFadingEdgeLength() >> 16), 35 - (ViewConfiguration.getJumpTapTimeout() >> 16), (char) ((ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1)) - 1))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj2);
                        }
                        Object invoke = ((Method) obj2).invoke(null, null);
                        try {
                            Object[] objArr6 = {964653220, Long.valueOf(j), new ArrayList(), LauncherActivity.getAuid()};
                            Object obj3 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                            if (obj3 == null) {
                                obj3 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(Color.rgb(0, 0, 0) + 16778127, 18 - (KeyEvent.getMaxKeyCode() >> 16), (char) ((SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)) - 1))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                if (this.mUploadManager == null) {
                    getActivity().finish();
                }
                if (this.mZdocRemoteConfig == null || this.mZdocRemoteConfig.getUploadMonitorPic() != 1) {
                    return;
                }
                initDocMonitorManager();
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

    private void initDocMonitorManager() {
        if (this.mDocMonitorFrameManager == null) {
            DocMonitorFrameManager docMonitorFrameManager = new DocMonitorFrameManager(this.mZdocRemoteConfig, this.mUploadManager.getPublicKey(), this.mBisToken);
            this.mDocMonitorFrameManager = docMonitorFrameManager;
            docMonitorFrameManager.setTimerTask(new IMonitorCallback() { // from class: com.zoloz.android.phone.zdoc.fragment.BaseDocWithNineCaptureFragment.1
                @Override // com.zoloz.android.phone.zdoc.service.IMonitorCallback
                public void onTimeout() {
                    if (BaseDocWithNineCaptureFragment.this.isGettingPreviewImg) {
                        return;
                    }
                    BaseDocWithNineCaptureFragment.this.isGettingPreviewImg = true;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.zoloz.android.phone.zdoc.fragment.BaseDocFragment
    public void upLoadImage() {
        super.upLoadImage();
        uploadMonitorFrame();
    }

    @Override // com.zoloz.android.phone.zdoc.fragment.BaseDocFragment
    public void responseWithCode(int i, BioUploadResult bioUploadResult) {
        uploadMonitorFrame();
        super.responseWithCode(i, bioUploadResult);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.zoloz.android.phone.zdoc.fragment.BaseDocFragment
    public void handleSuccContinue() {
        super.handleSuccContinue();
        DocMonitorFrameManager docMonitorFrameManager = this.mDocMonitorFrameManager;
        if (docMonitorFrameManager != null) {
            docMonitorFrameManager.setTimerTask(new IMonitorCallback() { // from class: com.zoloz.android.phone.zdoc.fragment.BaseDocWithNineCaptureFragment.2
                @Override // com.zoloz.android.phone.zdoc.service.IMonitorCallback
                public void onTimeout() {
                    if (BaseDocWithNineCaptureFragment.this.isGettingPreviewImg) {
                        return;
                    }
                    BaseDocWithNineCaptureFragment.this.isGettingPreviewImg = true;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.zoloz.android.phone.zdoc.fragment.BaseDocFragment
    public void handleUploading() {
        DocMonitorFrameManager docMonitorFrameManager = this.mDocMonitorFrameManager;
        if (docMonitorFrameManager != null) {
            docMonitorFrameManager.resetCurrentFrameNummer();
        }
        super.handleUploading();
    }

    private void uploadMonitorFrame() {
        DocMonitorFrameManager docMonitorFrameManager = this.mDocMonitorFrameManager;
        if (docMonitorFrameManager != null) {
            byte[] monitorBlob = docMonitorFrameManager.getMonitorBlob();
            byte[] key = this.mDocMonitorFrameManager.getKey();
            boolean isUTF8 = this.mDocMonitorFrameManager.isUTF8();
            if (monitorBlob != null) {
                this.mDocMonitorFrameManager.cancelTimer();
                this.isGettingPreviewImg = false;
                this.mUploadManager.uploadNineShoot(monitorBlob, key, isUTF8);
            }
        }
    }

    @Override // com.zoloz.android.phone.zdoc.fragment.BaseDocFragment, com.alipay.zoloz.hardware.camera.ICameraCallback
    public void onPreviewFrame(CameraData cameraData) {
        super.onPreviewFrame(cameraData);
        if (this.isGettingPreviewImg) {
            this.mDocMonitorFrameManager.addMonitorFrame(createTGFrame(cameraData));
            this.mDocMonitorFrameManager.updateCurrentFrameNumber();
            this.isGettingPreviewImg = false;
        }
    }

    @Override // com.zoloz.android.phone.zdoc.fragment.BaseDocFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        DocMonitorFrameManager docMonitorFrameManager = this.mDocMonitorFrameManager;
        if (docMonitorFrameManager != null) {
            docMonitorFrameManager.destroy();
            this.mDocMonitorFrameManager = null;
        }
    }
}
