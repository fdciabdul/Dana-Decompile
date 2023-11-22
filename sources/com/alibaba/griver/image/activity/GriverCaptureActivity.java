package com.alibaba.griver.image.activity;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.ImageFormat;
import android.graphics.PointF;
import android.graphics.drawable.Drawable;
import android.hardware.Camera;
import android.media.AudioTrack;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import android.os.SystemClock;
import android.telephony.cdma.CdmaCellLocation;
import android.text.AndroidCharacter;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ExpandableListView;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.alibaba.ariver.app.api.ui.StatusBarUtils;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.alibaba.griver.base.common.env.GriverEnv;
import com.alibaba.griver.base.common.utils.DensityUtil;
import com.alibaba.griver.base.common.utils.ToastUtils;
import com.alibaba.griver.image.GriverImageService;
import com.alibaba.griver.image.R;
import com.alibaba.griver.image.capture.CaptureServiceImpl;
import com.alibaba.griver.image.capture.meta.APTakePictureOption;
import com.alibaba.griver.image.capture.meta.APVideoRecordRsp;
import com.alibaba.griver.image.capture.meta.CameraParams;
import com.alibaba.griver.image.capture.meta.CaptureParam;
import com.alibaba.griver.image.capture.meta.MediaInfo;
import com.alibaba.griver.image.capture.utils.CameraUtils;
import com.alibaba.griver.image.capture.widget.CaptureBtn;
import com.alibaba.griver.image.capture.widget.SightCameraView;
import com.alibaba.griver.image.capture.widget.SightCameraViewImpl;
import com.alibaba.griver.image.capture.widget.TitleBar;
import com.alibaba.griver.image.capture.widget.TouchInterceptFrameLayout;
import com.alibaba.griver.image.photo.PhotoContext;
import com.alibaba.griver.ui.ant.utils.ToolUtils;
import com.fullstory.instrumentation.InstrumentInjector;
import com.google.common.base.Ascii;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.google.zxing.pdf417.PDF417Common;
import id.dana.onboarding.splash.LauncherActivity;
import java.io.File;
import java.lang.ref.WeakReference;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import o.C;
import o.SummaryVoucherView$$ExternalSyntheticLambda0;

/* loaded from: classes6.dex */
public class GriverCaptureActivity extends GriverMediaBaseActivity implements View.OnClickListener, SightCameraView.OnScrollListener {
    private static char KClassImpl$Data$declaredNonStaticMembers$2 = 0;
    public static final int MODE_CHANGING = 2;
    public static final int MODE_PHOTO = 1;
    public static final int MODE_VIDEO = 0;
    private static char NetworkUserEntityData$$ExternalSyntheticLambda0 = 0;
    public static final String TAG = "GriverCaptureActivity";

    /* renamed from: a */
    private static int f6551a = 0;
    private static int b = 1;
    private static int c = 0;
    private static int d = 1;
    private static char getAuthRequestContext;
    private static char lookAheadTest;
    private Bundle A;
    private boolean B;
    private int C;
    private Handler D;
    private int E;
    private int G;
    private boolean H;
    private boolean I;
    protected ImageView btnFilter;
    protected CaptureBtn btnRecord;
    protected TouchInterceptFrameLayout cameraContainer;
    protected SightCameraView cameraView;
    protected TextView captureIndicator;
    protected RelativeLayout controlPanel;
    protected View coverView;
    private int e;
    private boolean f;
    private boolean g;
    private boolean h;
    private int i;
    protected ImageView ivPrepare;
    private int j;
    private boolean k;
    private boolean l;
    private String m;
    protected TitleBar mTitle;
    private boolean n;

    /* renamed from: o */
    private boolean f6552o;
    private ImageView p;
    private ImageView q;
    private ImageView r;
    private View s;
    private Camera t;
    protected TextView tipsText;
    protected TextView tipsText2;
    protected TextView topTips;
    protected TextView videoIndicator;
    private int w;
    private boolean x;
    private GriverImageService y;
    public static final byte[] $$a = {36, -25, -14, -85, TarHeader.LF_CHR, -48, 46, 10, 7, 14, -39, TarHeader.LF_NORMAL, 13, -4, 18, 12, -46, 36, Ascii.SUB, -12, -20, 34, 9, Ascii.CAN, 2, 10, 14, 5, 22, -44, 59, 6, -5, -15, Ascii.SUB, 19, 11, -9, Ascii.NAK, 8, -42, TarHeader.LF_CHR, 6, 13, -8, Ascii.SUB, 3, -1, TarHeader.LF_NORMAL, -4, Ascii.EM, 7, -35, 43, 10, 3, -65, 39, 36, Ascii.SUB, -12, -54, 71, 8, 5, 16, -4, Ascii.CAN, -6, 6, -15, 40, 6, -20, 40, -12, Ascii.SUB, -4, 1, -15, Ascii.US, 15, -4, 10, Ascii.DC4, 8, -72, Ascii.NAK};
    public static final int $$b = 71;
    public static final byte[] MyBillsEntityDataFactory = {104, -68, 0, 44, -17, 6, -18, -1, 2, 1, TarHeader.LF_SYMLINK, -57, -16, -3, -10, 11, -13, -10, 66, -25, -48, -3, -10, 11, -23, 0, 1, -5, -13, -10, 7, -15, -9, 45, -29, -22, 7, 33, -48, 7, -5, 5, -25, 17, 47, -66, 7, -17, 3, TarHeader.LF_DIR, -41, -42, 2, -5, 11, -12, -2, -19, 47, -51, -4, 0, -1, 2, -2, -23, 7, -10, -3, 33, -41, 4, -13};
    public static final int BuiltInFictitiousFunctionClassFactory = 211;
    View.OnTouchListener coverBlockTouch = new View.OnTouchListener() { // from class: com.alibaba.griver.image.activity.GriverCaptureActivity.1
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            return true;
        }

        {
            GriverCaptureActivity.this = this;
        }
    };
    private int u = 0;
    private int v = 0;
    private boolean z = false;
    private APTakePictureOption F = new APTakePictureOption();
    private SightCameraView.TakePictureMPListener J = new SightCameraView.TakePictureMPListener() { // from class: com.alibaba.griver.image.activity.GriverCaptureActivity.2
        @Override // com.alibaba.griver.image.capture.widget.SightCameraView.TakePictureListener
        public void onPictureProcessStart() {
        }

        @Override // com.alibaba.griver.image.capture.widget.SightCameraView.TakePictureListener
        public void onPictureTaken(byte[] bArr, Camera camera) {
        }

        {
            GriverCaptureActivity.this = this;
        }

        @Override // com.alibaba.griver.image.capture.widget.SightCameraView.TakePictureListener
        public void onPictureTakenError(int i, Camera camera) {
            StringBuilder sb = new StringBuilder();
            sb.append("onPictureTakenError errorCode = ");
            sb.append(i);
            RVLogger.e(GriverCaptureActivity.TAG, sb.toString());
            GriverCaptureActivity griverCaptureActivity = GriverCaptureActivity.this;
            ToastUtils.showToast(griverCaptureActivity, griverCaptureActivity.getString(R.string.griver_image_tips_take_pic_error), 0);
            GriverCaptureActivity.this.x();
            GriverCaptureActivity.this.finish();
            GriverCaptureActivity.this.b(i);
        }

        @Override // com.alibaba.griver.image.capture.widget.SightCameraView.TakePictureListener
        public void onPictureProcessFinish(String str, int i, int i2, int i3) {
            GriverCaptureActivity.this.a(str, i, i2, i3, null);
        }

        @Override // com.alibaba.griver.image.capture.widget.SightCameraView.TakePictureMPListener
        public void onPictureProcessFinish(String str, int i, int i2, int i3, Bundle bundle) {
            GriverCaptureActivity.this.a(str, i, i2, i3, bundle);
        }

        @Override // com.alibaba.griver.image.capture.widget.SightCameraView.TakePictureListener
        public void onPictureProcessError(int i, byte[] bArr) {
            StringBuilder sb = new StringBuilder();
            sb.append("onPictureProcessError errorCode = ");
            sb.append(i);
            RVLogger.e(GriverCaptureActivity.TAG, sb.toString());
            GriverCaptureActivity griverCaptureActivity = GriverCaptureActivity.this;
            ToastUtils.showToast(griverCaptureActivity, griverCaptureActivity.getString(R.string.griver_image_tips_take_pic_error), 0);
            GriverCaptureActivity.this.x();
            GriverCaptureActivity.this.finish();
        }
    };
    View.OnClickListener captureClickListener = new View.OnClickListener() { // from class: com.alibaba.griver.image.activity.GriverCaptureActivity.3
        {
            GriverCaptureActivity.this = this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (GriverCaptureActivity.this.u == 2) {
                return;
            }
            GriverCaptureActivity.this.u = 2;
            StringBuilder sb = new StringBuilder();
            sb.append("Click to shoot time ");
            sb.append(System.currentTimeMillis());
            RVLogger.d(GriverCaptureActivity.TAG, sb.toString());
            GriverCaptureActivity.this.cameraView.takePicture(GriverCaptureActivity.this.J, Looper.getMainLooper(), GriverCaptureActivity.this.F);
        }
    };
    private View.OnClickListener K = new View.OnClickListener() { // from class: com.alibaba.griver.image.activity.GriverCaptureActivity.4
        {
            GriverCaptureActivity.this = this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            String string;
            if (GriverCaptureActivity.this.u == 2) {
                return;
            }
            GriverCaptureActivity.this.w = Math.abs(r3.w - 1);
            try {
                GriverCaptureActivity.this.n();
                GriverCaptureActivity griverCaptureActivity = GriverCaptureActivity.this;
                if (griverCaptureActivity.w == GriverCaptureActivity.b) {
                    string = GriverCaptureActivity.this.getString(R.string.griver_image_flashlight_opend);
                } else {
                    string = GriverCaptureActivity.this.getString(R.string.griver_image_flashlight_closed);
                }
                griverCaptureActivity.a(string);
            } catch (Exception unused) {
                GriverCaptureActivity.this.o();
            }
        }
    };
    private CameraUtils.CameraHelperListener L = new CameraUtils.CameraHelperListener() { // from class: com.alibaba.griver.image.activity.GriverCaptureActivity.5
        {
            GriverCaptureActivity.this = this;
        }

        @Override // com.alibaba.griver.image.capture.utils.CameraUtils.CameraHelperListener
        public void onCameraFacingChanged(Camera camera, int i, int i2) {
            GriverCaptureActivity.this.t = camera;
            GriverCaptureActivity.this.C = i;
            GriverCaptureActivity.this.u = i2;
            if (GriverCaptureActivity.this.u == 0) {
                GriverCaptureActivity.this.p();
            } else {
                GriverCaptureActivity.this.q();
            }
            GriverCaptureActivity.this.w = GriverCaptureActivity.f6551a;
            GriverCaptureActivity.this.n();
            if (GriverCaptureActivity.this.C == GriverCaptureActivity.c) {
                if (GriverCaptureActivity.this.B) {
                    GriverCaptureActivity.this.mTitle.ivFlash.setVisibility(0);
                    GriverCaptureActivity.this.mTitle.ivCamera.setContentDescription(GriverCaptureActivity.this.getString(R.string.griver_image_switch_to_front_camera));
                    return;
                }
                return;
            }
            GriverCaptureActivity.this.mTitle.ivFlash.setVisibility(8);
            if (!GriverCaptureActivity.this.z) {
                boolean unused = GriverCaptureActivity.this.f6552o;
            }
            GriverCaptureActivity.this.mTitle.ivCamera.setContentDescription(GriverCaptureActivity.this.getString(R.string.griver_image_switch_to_back_camera));
        }

        @Override // com.alibaba.griver.image.capture.utils.CameraUtils.CameraHelperListener
        public void onVideoModeReached(Camera camera) {
            RVLogger.d(GriverCaptureActivity.TAG, "onVideoModeReached-----------");
            GriverCaptureActivity.this.t = camera;
            GriverCaptureActivity.this.p();
        }

        @Override // com.alibaba.griver.image.capture.utils.CameraUtils.CameraHelperListener
        public void onCaptureModeReached(Camera camera) {
            RVLogger.d(GriverCaptureActivity.TAG, "onCaptureModeReached-----------");
            GriverCaptureActivity.this.t = camera;
            GriverCaptureActivity.this.q();
        }
    };
    SightCameraView.OnRecordListener onRecordListener = new SightCameraView.OnRecordListener() { // from class: com.alibaba.griver.image.activity.GriverCaptureActivity.6
        @Override // com.alibaba.griver.image.capture.widget.SightCameraView.OnRecordListener
        public void onInfo(int i, Bundle bundle) {
        }

        {
            GriverCaptureActivity.this = this;
        }

        @Override // com.alibaba.griver.image.capture.widget.SightCameraView.OnRecordListener
        public void onStart() {
            RVLogger.d(GriverCaptureActivity.TAG, "onRecordListener onStart");
        }

        @Override // com.alibaba.griver.image.capture.widget.SightCameraView.OnRecordListener
        public void onError(APVideoRecordRsp aPVideoRecordRsp) {
            String string;
            int i = aPVideoRecordRsp.mRspCode;
            if (i == 100) {
                string = GriverCaptureActivity.this.getString(R.string.griver_image_tips_camera_error);
            } else if (i == 200) {
                string = GriverCaptureActivity.this.getString(R.string.griver_image_tips_sdcard_error);
            } else if (i != 300) {
                switch (i) {
                    case 1:
                    case 2:
                    case 3:
                    case 4:
                    case 5:
                    case 6:
                        string = GriverCaptureActivity.this.getString(R.string.griver_image_tips_mic_error);
                        break;
                    default:
                        string = "Camera error";
                        break;
                }
            } else {
                string = GriverCaptureActivity.this.getString(R.string.griver_image_tips_sdcard_not_enough);
            }
            GriverCaptureActivity.this.a(aPVideoRecordRsp, string);
        }

        @Override // com.alibaba.griver.image.capture.widget.SightCameraView.OnRecordListener
        public void onFinish(APVideoRecordRsp aPVideoRecordRsp) {
            RVLogger.d(GriverCaptureActivity.TAG, "onRecordListener onFinish");
        }

        @Override // com.alibaba.griver.image.capture.widget.SightCameraView.OnRecordListener
        public void onCancel() {
            GriverCaptureActivity.this.resetState();
            RVLogger.d(GriverCaptureActivity.TAG, "onRecordListener onCancel");
        }

        @Override // com.alibaba.griver.image.capture.widget.SightCameraView.OnRecordListener
        public void onPrepared(APVideoRecordRsp aPVideoRecordRsp) {
            RVLogger.d(GriverCaptureActivity.TAG, "onRecordListener onPrepared");
            GriverCaptureActivity.access$2108(GriverCaptureActivity.this);
            if (GriverCaptureActivity.this.G <= 1) {
                GriverCaptureActivity.this.a(aPVideoRecordRsp);
                GriverCaptureActivity.this.D.post(new Runnable() { // from class: com.alibaba.griver.image.activity.GriverCaptureActivity.6.1
                    {
                        AnonymousClass6.this = this;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        GriverCaptureActivity.this.ivPrepare.setVisibility(8);
                    }
                });
                return;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("Prepared count = ");
            sb.append(GriverCaptureActivity.this.G);
            sb.append(",ignore it!");
            RVLogger.d(GriverCaptureActivity.TAG, sb.toString());
        }
    };
    private View.OnClickListener M = new View.OnClickListener() { // from class: com.alibaba.griver.image.activity.GriverCaptureActivity.7
        {
            GriverCaptureActivity.this = this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (GriverCaptureActivity.this.x || GriverCaptureActivity.this.u == 2) {
                return;
            }
            GriverCaptureActivity griverCaptureActivity = GriverCaptureActivity.this;
            griverCaptureActivity.a(griverCaptureActivity.u);
        }
    };

    static {
        BuiltInFictitiousFunctionClassFactory();
    }

    static void BuiltInFictitiousFunctionClassFactory() {
        getAuthRequestContext = (char) 34537;
        KClassImpl$Data$declaredNonStaticMembers$2 = (char) 926;
        lookAheadTest = (char) 54665;
        NetworkUserEntityData$$ExternalSyntheticLambda0 = (char) 42630;
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x001e  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0026  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:22:0x0026 -> B:23:0x0032). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void O(int r6, short r7, int r8, java.lang.Object[] r9) {
        /*
            int r6 = 106 - r6
            int r7 = 55 - r7
            int r8 = 23 - r8
            byte[] r0 = com.alibaba.griver.image.activity.GriverCaptureActivity.MyBillsEntityDataFactory
            byte[] r1 = new byte[r8]
            int r8 = r8 + (-1)
            r2 = 0
            if (r0 != 0) goto L16
            r3 = r1
            r4 = 0
            r1 = r0
            r0 = r9
            r9 = r8
            r8 = r7
            goto L32
        L16:
            r3 = 0
        L17:
            int r7 = r7 + 1
            byte r4 = (byte) r6
            r1[r3] = r4
            if (r3 != r8) goto L26
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            r9[r2] = r6
            return
        L26:
            int r3 = r3 + 1
            r4 = r0[r7]
            r5 = r8
            r8 = r7
            r7 = r4
            r4 = r3
            r3 = r1
            r1 = r0
            r0 = r9
            r9 = r5
        L32:
            int r7 = -r7
            int r6 = r6 + r7
            int r6 = r6 + (-4)
            r7 = r8
            r8 = r9
            r9 = r0
            r0 = r1
            r1 = r3
            r3 = r4
            goto L17
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.griver.image.activity.GriverCaptureActivity.O(int, short, int, java.lang.Object[]):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0021  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0029  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:22:0x0029 -> B:23:0x0034). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void P(int r6, short r7, byte r8, java.lang.Object[] r9) {
        /*
            byte[] r0 = com.alibaba.griver.image.activity.GriverCaptureActivity.$$a
            int r8 = r8 * 3
            int r8 = r8 + 21
            int r6 = r6 + 4
            int r7 = r7 * 2
            int r7 = 103 - r7
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
            byte r4 = (byte) r7
            r1[r3] = r4
            int r6 = r6 + 1
            if (r3 != r8) goto L29
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            r9[r2] = r6
            return
        L29:
            int r3 = r3 + 1
            r4 = r0[r6]
            r5 = r9
            r9 = r8
            r8 = r4
            r4 = r3
            r3 = r1
            r1 = r0
            r0 = r5
        L34:
            int r7 = r7 + r8
            int r7 = r7 + (-7)
            r8 = r9
            r9 = r0
            r0 = r1
            r1 = r3
            r3 = r4
            goto L1a
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.griver.image.activity.GriverCaptureActivity.P(int, short, byte, java.lang.Object[]):void");
    }

    public void a(APVideoRecordRsp aPVideoRecordRsp, String str) {
    }

    public void b(int i) {
    }

    public void l() {
    }

    public void p() {
    }

    private void v() {
    }

    @Override // com.alibaba.griver.image.activity.GriverMediaBaseActivity, android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper
    public void attachBaseContext(Context context) {
        Object[] objArr;
        Object[] objArr2;
        Object[] objArr3;
        Object[] objArr4;
        super.attachBaseContext(context);
        Object[] objArr5 = new Object[1];
        N((ViewConfiguration.getTouchSlop() >> 8) + 18, new char[]{10096, 60400, 10679, 50573, 13027, 55091, 44225, 42164, 11988, 28224, 19341, 29615, 62909, 40417, 58814, 52630, 37634, 51458}, objArr5);
        Class<?> cls = Class.forName((String) objArr5[0]);
        Object[] objArr6 = new Object[1];
        N(KeyEvent.normalizeMetaState(0) + 5, new char[]{41602, 17474, 11071, 31747, 13690, 48400}, objArr6);
        int intValue = ((Integer) cls.getDeclaredMethod((String) objArr6[0], new Class[0]).invoke(null, new Object[0])).intValue() % 100000;
        if (intValue < 99000 || intValue > 99999) {
            Context applicationContext = context != null ? context.getApplicationContext() : context;
            if (applicationContext != null) {
                try {
                    Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                    if (obj == null) {
                        obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)) + 930, 35 - (ViewConfiguration.getScrollBarSize() >> 8), (char) KeyEvent.normalizeMetaState(0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                    }
                    Object invoke = ((Method) obj).invoke(null, null);
                    Object[] objArr7 = new Object[1];
                    N((TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)) + 48, new char[]{18460, 46221, 60689, 11689, 41887, 1823, 51501, 56574, 6749, 486, 31641, 37714, 62485, 34872, 40505, 10812, 41503, 39638, 8497, 21077, 65471, 32402, 19775, 18393, 56233, 32967, 40684, 64821, 44510, 2584, 45105, 23929, 46311, 53989, 25650, 62183, 11264, 1313, 18669, 18290, 32739, 9361, 4759, 31091, 1056, 32610, 42342, 55171}, objArr7);
                    String str = (String) objArr7[0];
                    Object[] objArr8 = new Object[1];
                    N(AndroidCharacter.getMirror('0') + 16, new char[]{58048, 43118, 56086, 23646, 11264, 1313, 27662, 26630, 65471, 32402, 36830, 27046, 2218, 20723, 63290, 54084, 40155, 34073, 16411, 56847, 2218, 20723, 37176, 26034, 25333, 33668, 12749, 20632, 40684, 64821, 40155, 34073, 60477, 3491, 45882, 9465, 62508, 64817, 28742, 43061, 56228, 18187, 59214, 25968, 13711, 27036, 25991, 53907, 24863, 53240, 20216, 21132, 56630, 58753, 36590, 50010, 36590, 50010, 16532, 40170, 47107, 6047, 56233, 32967}, objArr8);
                    String str2 = (String) objArr8[0];
                    Object[] objArr9 = new Object[1];
                    N(65 - (Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1)), new char[]{51314, 13921, 64232, 17335, 56630, 58753, 38118, 53766, 40405, 2846, 37053, 2531, 40475, 5873, 16995, 56516, 45105, 23929, 56605, 40516, 9340, 39500, 28913, 15664, 32739, 9361, 51501, 56574, 60031, 10228, 18460, 46221, 41194, 838, 46731, 38328, 7911, 61371, 60689, 11689, 65192, 6293, 63290, 54084, 18669, 18290, 28772, 55450, 11264, 1313, 58814, 52630, 51314, 13921, 1797, 52931, 28657, 58989, 46311, 53989, 1797, 52931, 49625, 39838}, objArr9);
                    String str3 = (String) objArr9[0];
                    Object[] objArr10 = new Object[1];
                    N((ViewConfiguration.getMaximumFlingVelocity() >> 16) + 60, new char[]{11768, 47278, 7675, 31737, 52156, 42705, 20316, 36198, 37765, 49663, 38506, 11908, 26936, 2997, 56155, 62899, 41009, 48722, 41311, 9351, 33988, 50730, 11662, 38466, 11091, 14442, 39948, 47754, 23806, 53170, 44295, 4712, 39948, 47754, 64559, 35391, 11097, 35384, 42722, 30549, 19870, 32835, 26935, 60932, 3670, 40664, 43267, 14649, 459, 7299, 33445, 37765, 48116, 1298, 8870, 22739, 29006, 23848, 18601, 62374}, objArr10);
                    String str4 = (String) objArr10[0];
                    Object[] objArr11 = new Object[1];
                    N(Drawable.resolveOpacity(0, 0) + 6, new char[]{26141, 9205, 26312, 22395, 51314, 13921}, objArr11);
                    try {
                        Object[] objArr12 = {applicationContext, str, str2, str3, str4, true, (String) objArr11[0], 995651014};
                        Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-1276397751);
                        if (obj2 == null) {
                            obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(((Process.getThreadPriority(0) + 20) >> 6) + 911, 18 - (ViewConfiguration.getMaximumDrawingCacheSize() >> 24), (char) (AndroidCharacter.getMirror('0') - '0'))).getMethod("getAuthRequestContext", Context.class, String.class, String.class, String.class, String.class, Boolean.TYPE, String.class, Integer.TYPE);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(-1276397751, obj2);
                        }
                        ((Method) obj2).invoke(invoke, objArr12);
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
        }
        Context applicationContext2 = context != null ? context.getApplicationContext() : context;
        if (applicationContext2 != null) {
            try {
                Object[] objArr13 = new Object[1];
                O(MyBillsEntityDataFactory[2], (byte) (-MyBillsEntityDataFactory[31]), MyBillsEntityDataFactory[30], objArr13);
                Class<?> cls2 = Class.forName((String) objArr13[0]);
                Object[] objArr14 = new Object[1];
                O(MyBillsEntityDataFactory[9], (short) 30, MyBillsEntityDataFactory[30], objArr14);
                try {
                    Object[] objArr15 = {applicationContext2, Integer.valueOf(((Integer) cls2.getMethod((String) objArr14[0], Object.class).invoke(null, this)).intValue())};
                    Object obj3 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1691739267);
                    if (obj3 == null) {
                        Class cls3 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(Color.green(0) + 55, 3 - (ViewConfiguration.getScrollBarFadeDuration() >> 16), (char) (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)));
                        Object[] objArr16 = new Object[1];
                        P($$a[47], $$a[12], $$a[78], objArr16);
                        obj3 = cls3.getMethod((String) objArr16[0], Context.class, Integer.TYPE);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1691739267, obj3);
                    }
                    Object invoke2 = ((Method) obj3).invoke(null, objArr15);
                    try {
                        Object obj4 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(40157535);
                        if (obj4 == null) {
                            obj4 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(Color.red(0) + 800, (SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)) + 14, (char) ((ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)) + 1))).getMethod("getAuthRequestContext", null);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(40157535, obj4);
                        }
                        int intValue2 = ((Integer) ((Method) obj4).invoke(invoke2, null)).intValue();
                        try {
                            Object obj5 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1621779126);
                            if (obj5 == null) {
                                obj5 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(Color.red(0) + 800, Color.argb(0, 0, 0, 0) + 15, (char) TextUtils.getTrimmedLength(""))).getMethod("PlaceComponentResult", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1621779126, obj5);
                            }
                            if (((Integer) ((Method) obj5).invoke(invoke2, null)).intValue() != intValue2) {
                                ArrayList arrayList = new ArrayList();
                                try {
                                    Object[] objArr17 = {invoke2};
                                    Object obj6 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(658700871);
                                    if (obj6 == null) {
                                        obj6 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(View.MeasureSpec.makeMeasureSpec(0, 0) + 815, 29 - (CdmaCellLocation.convertQuartSecToDecDegrees(0) > FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 0 : -1)), (char) (57994 - Color.green(0)))).getMethod("getAuthRequestContext", (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(TextUtils.indexOf("", "") + 800, 15 - (ViewConfiguration.getLongPressTimeout() >> 16), (char) (ViewConfiguration.getScrollDefaultDelay() >> 16)));
                                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(658700871, obj6);
                                    }
                                    arrayList.add(((Method) obj6).invoke(null, objArr17));
                                    long j = ((r4 ^ intValue2) & 4294967295L) | 60129542144L;
                                    try {
                                        Object obj7 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                                        if (obj7 != null) {
                                            objArr = null;
                                        } else {
                                            objArr = null;
                                            obj7 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(ImageFormat.getBitsPerPixel(0) + 930, (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)) + 34, (char) (TextUtils.indexOf((CharSequence) "", '0') + 1))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj7);
                                        }
                                        Object invoke3 = ((Method) obj7).invoke(objArr, objArr);
                                        try {
                                            Object[] objArr18 = {1247881555, Long.valueOf(j), arrayList, LauncherActivity.getAuid()};
                                            Object obj8 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                            if (obj8 == null) {
                                                obj8 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(910 - TextUtils.indexOf((CharSequence) "", '0'), Color.rgb(0, 0, 0) + 16777234, (char) (1 - (SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1))))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
                                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1759031285, obj8);
                                            }
                                            ((Method) obj8).invoke(invoke3, objArr18);
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
                                } catch (Throwable th5) {
                                    Throwable cause5 = th5.getCause();
                                    if (cause5 == null) {
                                        throw th5;
                                    }
                                    throw cause5;
                                }
                            }
                        } catch (Throwable th6) {
                            Throwable cause6 = th6.getCause();
                            if (cause6 == null) {
                                throw th6;
                            }
                            throw cause6;
                        }
                    } catch (Throwable th7) {
                        Throwable cause7 = th7.getCause();
                        if (cause7 == null) {
                            throw th7;
                        }
                        throw cause7;
                    }
                } catch (Throwable th8) {
                    Throwable cause8 = th8.getCause();
                    if (cause8 == null) {
                        throw th8;
                    }
                    throw cause8;
                }
            } catch (Throwable th9) {
                Throwable cause9 = th9.getCause();
                if (cause9 == null) {
                    throw th9;
                }
                throw cause9;
            }
        }
        Context applicationContext3 = context != null ? context.getApplicationContext() : context;
        if (applicationContext3 != null) {
            try {
                Object[] objArr19 = new Object[1];
                O(MyBillsEntityDataFactory[2], (byte) (-MyBillsEntityDataFactory[31]), MyBillsEntityDataFactory[30], objArr19);
                Class<?> cls4 = Class.forName((String) objArr19[0]);
                Object[] objArr20 = new Object[1];
                O(MyBillsEntityDataFactory[9], (short) 30, MyBillsEntityDataFactory[30], objArr20);
                try {
                    Object[] objArr21 = {applicationContext3, Integer.valueOf(((Integer) cls4.getMethod((String) objArr20[0], Object.class).invoke(null, this)).intValue())};
                    Object obj9 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(345757441);
                    if (obj9 == null) {
                        Class cls5 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1)) + 60, 46 - View.MeasureSpec.makeMeasureSpec(0, 0), (char) View.combineMeasuredStates(0, 0));
                        byte b2 = $$a[28];
                        byte b3 = (byte) ($$a[78] - 1);
                        Object[] objArr22 = new Object[1];
                        P(b2, b3, b3, objArr22);
                        obj9 = cls5.getMethod((String) objArr22[0], Context.class, Integer.TYPE);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(345757441, obj9);
                    }
                    Object[] objArr23 = (Object[]) ((Method) obj9).invoke(null, objArr21);
                    int i = ((int[]) objArr23[1])[0];
                    if (((int[]) objArr23[0])[0] != i) {
                        long j2 = ((r2 ^ i) & 4294967295L) | 17179869184L;
                        try {
                            Object obj10 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                            if (obj10 != null) {
                                objArr4 = null;
                            } else {
                                objArr4 = null;
                                obj10 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getFadingEdgeLength() >> 16) + PDF417Common.NUMBER_OF_CODEWORDS, 35 - KeyEvent.normalizeMetaState(0), (char) Drawable.resolveOpacity(0, 0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj10);
                            }
                            Object invoke4 = ((Method) obj10).invoke(objArr4, objArr4);
                            try {
                                Object[] objArr24 = {1247881555, Long.valueOf(j2), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj11 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj11 == null) {
                                    obj11 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(910 - MotionEvent.axisFromString(""), Color.alpha(0) + 18, (char) (Process.getGidForName("") + 1))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
                                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1759031285, obj11);
                                }
                                ((Method) obj11).invoke(invoke4, objArr24);
                            } catch (Throwable th10) {
                                Throwable cause10 = th10.getCause();
                                if (cause10 == null) {
                                    throw th10;
                                }
                                throw cause10;
                            }
                        } catch (Throwable th11) {
                            Throwable cause11 = th11.getCause();
                            if (cause11 == null) {
                                throw th11;
                            }
                            throw cause11;
                        }
                    }
                } catch (Throwable th12) {
                    Throwable cause12 = th12.getCause();
                    if (cause12 == null) {
                        throw th12;
                    }
                    throw cause12;
                }
            } catch (Throwable th13) {
                Throwable cause13 = th13.getCause();
                if (cause13 == null) {
                    throw th13;
                }
                throw cause13;
            }
        }
        Context applicationContext4 = context != null ? context.getApplicationContext() : context;
        if (applicationContext4 != null) {
            try {
                Object[] objArr25 = new Object[1];
                O(MyBillsEntityDataFactory[2], (byte) (-MyBillsEntityDataFactory[31]), MyBillsEntityDataFactory[30], objArr25);
                Class<?> cls6 = Class.forName((String) objArr25[0]);
                Object[] objArr26 = new Object[1];
                O(MyBillsEntityDataFactory[9], (short) 30, MyBillsEntityDataFactory[30], objArr26);
                try {
                    Object[] objArr27 = {applicationContext4, Integer.valueOf(((Integer) cls6.getMethod((String) objArr26[0], Object.class).invoke(null, this)).intValue())};
                    Object obj12 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-697999596);
                    if (obj12 == null) {
                        Class cls7 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(119 - (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)), 4 - (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1)), (char) (38969 - (SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1))));
                        byte b4 = $$a[28];
                        byte b5 = (byte) ($$a[78] - 1);
                        Object[] objArr28 = new Object[1];
                        P(b4, b5, b5, objArr28);
                        obj12 = cls7.getMethod((String) objArr28[0], Context.class, Integer.TYPE);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(-697999596, obj12);
                    }
                    Object[] objArr29 = (Object[]) ((Method) obj12).invoke(null, objArr27);
                    int i2 = ((int[]) objArr29[1])[0];
                    if (((int[]) objArr29[0])[0] != i2) {
                        long j3 = ((r2 ^ i2) & 4294967295L) | 8589934592L;
                        try {
                            Object obj13 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                            if (obj13 != null) {
                                objArr3 = null;
                            } else {
                                objArr3 = null;
                                obj13 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - (KeyEvent.getMaxKeyCode() >> 16), 35 - View.MeasureSpec.getMode(0), (char) TextUtils.getCapsMode("", 0, 0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj13);
                            }
                            Object invoke5 = ((Method) obj13).invoke(objArr3, objArr3);
                            try {
                                Object[] objArr30 = {1247881555, Long.valueOf(j3), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj14 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj14 == null) {
                                    obj14 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(910 - ((byte) KeyEvent.getModifierMetaStateMask()), (ViewConfiguration.getMaximumFlingVelocity() >> 16) + 18, (char) (ViewConfiguration.getMaximumDrawingCacheSize() >> 24))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
                                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1759031285, obj14);
                                }
                                ((Method) obj14).invoke(invoke5, objArr30);
                            } catch (Throwable th14) {
                                Throwable cause14 = th14.getCause();
                                if (cause14 == null) {
                                    throw th14;
                                }
                                throw cause14;
                            }
                        } catch (Throwable th15) {
                            Throwable cause15 = th15.getCause();
                            if (cause15 == null) {
                                throw th15;
                            }
                            throw cause15;
                        }
                    }
                } catch (Throwable th16) {
                    Throwable cause16 = th16.getCause();
                    if (cause16 == null) {
                        throw th16;
                    }
                    throw cause16;
                }
            } catch (Throwable th17) {
                Throwable cause17 = th17.getCause();
                if (cause17 == null) {
                    throw th17;
                }
                throw cause17;
            }
        }
        Context applicationContext5 = context != null ? context.getApplicationContext() : context;
        if (applicationContext5 != null) {
            try {
                Object[] objArr31 = new Object[1];
                O(MyBillsEntityDataFactory[2], (byte) (-MyBillsEntityDataFactory[31]), MyBillsEntityDataFactory[30], objArr31);
                Class<?> cls8 = Class.forName((String) objArr31[0]);
                Object[] objArr32 = new Object[1];
                O(MyBillsEntityDataFactory[9], (short) 30, MyBillsEntityDataFactory[30], objArr32);
                try {
                    Object[] objArr33 = {applicationContext5, Integer.valueOf(((Integer) cls8.getMethod((String) objArr32[0], Object.class).invoke(null, this)).intValue())};
                    Object obj15 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-16683571);
                    if (obj15 == null) {
                        Class cls9 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(AndroidCharacter.getMirror('0') + ';', 3 - Color.green(0), (char) (Process.myTid() >> 22));
                        Object[] objArr34 = new Object[1];
                        P((byte) (-$$a[40]), $$a[9], $$a[8], objArr34);
                        obj15 = cls9.getMethod((String) objArr34[0], Context.class, Integer.TYPE);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(-16683571, obj15);
                    }
                    Object[] objArr35 = (Object[]) ((Method) obj15).invoke(null, objArr33);
                    int i3 = ((int[]) objArr35[1])[0];
                    if (((int[]) objArr35[0])[0] != i3) {
                        long j4 = ((r2 ^ i3) & 4294967295L) | 4294967296L;
                        try {
                            Object obj16 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                            if (obj16 != null) {
                                objArr2 = null;
                            } else {
                                objArr2 = null;
                                obj16 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - Color.blue(0), (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)) + 35, (char) (ViewConfiguration.getMaximumFlingVelocity() >> 16))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj16);
                            }
                            Object invoke6 = ((Method) obj16).invoke(objArr2, objArr2);
                            try {
                                Object[] objArr36 = {1247881555, Long.valueOf(j4), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj17 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj17 == null) {
                                    obj17 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getFadingEdgeLength() >> 16) + 911, 18 - KeyEvent.keyCodeFromString(""), (char) (ViewConfiguration.getDoubleTapTimeout() >> 16))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
                                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1759031285, obj17);
                                }
                                ((Method) obj17).invoke(invoke6, objArr36);
                            } catch (Throwable th18) {
                                Throwable cause18 = th18.getCause();
                                if (cause18 == null) {
                                    throw th18;
                                }
                                throw cause18;
                            }
                        } catch (Throwable th19) {
                            Throwable cause19 = th19.getCause();
                            if (cause19 == null) {
                                throw th19;
                            }
                            throw cause19;
                        }
                    }
                } catch (Throwable th20) {
                    Throwable cause20 = th20.getCause();
                    if (cause20 == null) {
                        throw th20;
                    }
                    throw cause20;
                }
            } catch (Throwable th21) {
                Throwable cause21 = th21.getCause();
                if (cause21 == null) {
                    throw th21;
                }
                throw cause21;
            }
        }
    }

    @Override // com.alibaba.griver.image.activity.GriverMediaBaseActivity, android.content.ContextWrapper, android.content.Context
    public Context getApplicationContext() {
        return super.getApplicationContext();
    }

    @Override // com.alibaba.griver.image.activity.GriverMediaBaseActivity, android.content.ContextWrapper
    public Context getBaseContext() {
        return super.getBaseContext();
    }

    @Override // com.alibaba.griver.image.activity.GriverMediaBaseActivity, android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public Resources getResources() {
        return super.getResources();
    }

    @Override // com.alibaba.griver.image.activity.GriverMediaBaseActivity, android.app.Activity
    public void onPause() {
        Context baseContext = getBaseContext();
        if (baseContext == null) {
            Object[] objArr = new Object[1];
            N(super.getResources().getString(id.dana.R.string.subtitle_saving_benefit_1).substring(9, 10).length() + 25, new char[]{10096, 60400, 10679, 50573, 13027, 55091, 44225, 42164, 19870, 32835, 29122, 18591, 6246, 8718, 14367, 41319, 20115, 30627, 24466, 12618, 42393, 40501, 39285, 29109, 12787, 38995}, objArr);
            Class<?> cls = Class.forName((String) objArr[0]);
            Object[] objArr2 = new Object[1];
            N((ViewConfiguration.getFadingEdgeLength() >> 16) + 18, new char[]{5608, 58668, 56738, 18896, 29006, 23848, 28046, 19968, 32152, 25871, 63523, 39217, 'O', 40930, 14367, 41319, 43848, 37305}, objArr2);
            baseContext = (Context) cls.getMethod((String) objArr2[0], new Class[0]).invoke(null, null);
        }
        if (baseContext != null) {
            baseContext = baseContext.getApplicationContext();
        }
        if (baseContext != null) {
            try {
                Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                if (obj == null) {
                    obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)) + 930, 35 - (ViewConfiguration.getKeyRepeatTimeout() >> 16), (char) (ViewConfiguration.getScrollBarSize() >> 8))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                }
                Object invoke = ((Method) obj).invoke(null, null);
                try {
                    Object[] objArr3 = {baseContext};
                    Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-549958681);
                    if (obj2 == null) {
                        obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(AndroidCharacter.getMirror('0') + 863, KeyEvent.keyCodeFromString("") + 18, (char) ((-1) - ExpandableListView.getPackedPositionChild(0L)))).getMethod("MyBillsEntityDataFactory", Context.class);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(-549958681, obj2);
                    }
                    ((Method) obj2).invoke(invoke, objArr3);
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
        super.onPause();
    }

    @Override // com.alibaba.griver.image.activity.GriverMediaBaseActivity, android.app.Activity
    public void onResume() {
        Context baseContext = getBaseContext();
        if (baseContext == null) {
            try {
                Object[] objArr = new Object[1];
                O((byte) (-MyBillsEntityDataFactory[32]), (byte) (BuiltInFictitiousFunctionClassFactory >>> 2), MyBillsEntityDataFactory[2], objArr);
                Class<?> cls = Class.forName((String) objArr[0]);
                O(MyBillsEntityDataFactory[48], MyBillsEntityDataFactory[2], MyBillsEntityDataFactory[41], new Object[1]);
                Object[] objArr2 = new Object[1];
                N(((ApplicationInfo) cls.getMethod((String) r8[0], null).invoke(this, null)).targetSdkVersion - 7, new char[]{10096, 60400, 10679, 50573, 13027, 55091, 44225, 42164, 19870, 32835, 29122, 18591, 6246, 8718, 14367, 41319, 20115, 30627, 24466, 12618, 42393, 40501, 39285, 29109, 12787, 38995}, objArr2);
                Class<?> cls2 = Class.forName((String) objArr2[0]);
                Object[] objArr3 = new Object[1];
                N(getPackageName().length() + 11, new char[]{5608, 58668, 56738, 18896, 29006, 23848, 28046, 19968, 32152, 25871, 63523, 39217, 'O', 40930, 14367, 41319, 43848, 37305}, objArr3);
                baseContext = (Context) cls2.getMethod((String) objArr3[0], new Class[0]).invoke(null, null);
            } catch (Throwable th) {
                Throwable cause = th.getCause();
                if (cause == null) {
                    throw th;
                }
                throw cause;
            }
        }
        if (baseContext != null) {
            baseContext = baseContext.getApplicationContext();
        }
        if (baseContext != null) {
            try {
                Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                if (obj == null) {
                    obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - TextUtils.getCapsMode("", 0, 0), 36 - (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)), (char) (ViewConfiguration.getPressedStateDuration() >> 16))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                }
                Object invoke = ((Method) obj).invoke(null, null);
                try {
                    Object[] objArr4 = {baseContext};
                    Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(247288059);
                    if (obj2 == null) {
                        obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(959 - AndroidCharacter.getMirror('0'), 19 - (SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)), (char) (ViewConfiguration.getPressedStateDuration() >> 16))).getMethod("KClassImpl$Data$declaredNonStaticMembers$2", Context.class);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(247288059, obj2);
                    }
                    ((Method) obj2).invoke(invoke, objArr4);
                } catch (Throwable th2) {
                    Throwable cause2 = th2.getCause();
                    if (cause2 == null) {
                        throw th2;
                    }
                    throw cause2;
                }
            } catch (Throwable th3) {
                Throwable cause3 = th3.getCause();
                if (cause3 == null) {
                    throw th3;
                }
                throw cause3;
            }
        }
        super.onResume();
    }

    @Override // com.alibaba.griver.image.capture.widget.SightCameraView.OnScrollListener
    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        return false;
    }

    static /* synthetic */ int access$2108(GriverCaptureActivity griverCaptureActivity) {
        int i = griverCaptureActivity.G;
        griverCaptureActivity.G = i + 1;
        return i;
    }

    private void a() {
        this.F.saveToPrivateDir = this.A.getBoolean(CaptureParam.SAVE_FILE_TO_PRIVATE_DIRECTORY, false);
        this.F.setQuality(this.A.getInt(CaptureParam.KEY_CAPTURE_QUALITY, 100));
        this.E = this.A.getInt(CaptureParam.KEY_MAX_DURATION, 6000);
        this.n = this.A.getBoolean(CaptureParam.ENABLE_SWITCH_CAMERA, true);
        this.k = this.A.getBoolean(CaptureParam.ENABLE_MULTI_TIME_RECORD, false);
        this.l = this.A.getBoolean(CaptureParam.ENABLE_SHOW_LATEST_RECORD_ENTRY, false);
        this.m = this.A.getString(CaptureParam.LATEST_RECORD_ENTRY_ICON_PATH);
        this.e = this.A.getInt(CaptureParam.CAPTURE_MODE, 3);
        this.j = this.A.getInt(CaptureParam.INIT_TYPE, 0);
        int i = this.A.getInt(CaptureParam.INIT_CAMERA_FACING, 0);
        this.i = i;
        if (i == 1 && !b()) {
            RVLogger.d(TAG, "Front camera is not exist,force set to back camera");
            this.i = 0;
        }
        this.C = this.i;
        this.f = this.A.getBoolean(CaptureParam.ENABLE_SET_WATER_MARK, true);
        this.h = this.A.getBoolean(CaptureParam.ENABLE_SET_FILTER, true);
        this.f6552o = this.A.getBoolean(CaptureParam.ENABLE_SET_BEAUTY, true);
        c();
        this.g = this.A.getBoolean(CaptureParam.FINISH_AFTER_CALLBACK, true);
        Object[] objArr = new Object[6];
        objArr[0] = Integer.valueOf(this.e);
        objArr[1] = this.j == 0 ? "video" : "photo";
        objArr[2] = Boolean.valueOf(this.f);
        objArr[3] = Boolean.valueOf(this.g);
        objArr[4] = this.i == 0 ? "back" : "front";
        objArr[5] = Boolean.valueOf(this.k);
        RVLogger.d(TAG, String.format("mCaptureMode = %d,initType = %s,mEnableWaterMark = %s,finishAfterCallback = %s,initCameraFacing = %s,EnableMultiTimeRecord = %s", objArr));
    }

    private boolean b() {
        try {
            int numberOfCameras = Camera.getNumberOfCameras();
            for (int i = 0; i < numberOfCameras; i++) {
                Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
                Camera.getCameraInfo(i, cameraInfo);
                if (cameraInfo.facing == 1) {
                    return true;
                }
            }
        } catch (Exception e) {
            StringBuilder sb = new StringBuilder();
            sb.append("Parse camera info exception :");
            sb.append(e.getMessage());
            RVLogger.w(TAG, sb.toString());
        }
        return false;
    }

    private void c() {
        this.f = false;
        this.h = false;
        this.f6552o = false;
        StringBuilder sb = new StringBuilder();
        sb.append("checkWhiteList: ");
        sb.append(" Enable waterMark =");
        sb.append(this.f);
        sb.append(",Enable filter = ");
        sb.append(this.h);
        sb.append(",Enable beauty = ");
        sb.append(this.f6552o);
        RVLogger.d(TAG, sb.toString());
    }

    @Override // com.alibaba.griver.image.activity.GriverMediaBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Object[] objArr;
        Object[] objArr2 = new Object[1];
        N(super.getResources().getString(id.dana.R.string.location).substring(0, 2).length() + 16, new char[]{10096, 60400, 10679, 50573, 13027, 55091, 44225, 42164, 11988, 28224, 19341, 29615, 62909, 40417, 58814, 52630, 37634, 51458}, objArr2);
        Class<?> cls = Class.forName((String) objArr2[0]);
        Object[] objArr3 = new Object[1];
        N(super.getResources().getString(id.dana.R.string.my_bills_label_service_goods_mobile_data).substring(2, 3).codePointAt(0) - 111, new char[]{41602, 17474, 11071, 31747, 13690, 48400}, objArr3);
        int intValue = ((Integer) cls.getDeclaredMethod((String) objArr3[0], new Class[0]).invoke(null, new Object[0])).intValue() % 100000;
        if (intValue < 99000 || intValue > 99999) {
            Context baseContext = getBaseContext();
            if (baseContext == null) {
                Object[] objArr4 = new Object[1];
                N(Color.argb(0, 0, 0, 0) + 26, new char[]{10096, 60400, 10679, 50573, 13027, 55091, 44225, 42164, 19870, 32835, 29122, 18591, 6246, 8718, 14367, 41319, 20115, 30627, 24466, 12618, 42393, 40501, 39285, 29109, 12787, 38995}, objArr4);
                Class<?> cls2 = Class.forName((String) objArr4[0]);
                Object[] objArr5 = new Object[1];
                N(super.getResources().getString(id.dana.R.string.pocket_header_voucher).substring(0, 7).codePointAt(1) - 93, new char[]{5608, 58668, 56738, 18896, 29006, 23848, 28046, 19968, 32152, 25871, 63523, 39217, 'O', 40930, 14367, 41319, 43848, 37305}, objArr5);
                baseContext = (Context) cls2.getMethod((String) objArr5[0], new Class[0]).invoke(null, null);
            }
            if (baseContext != null) {
                baseContext = baseContext.getApplicationContext();
            }
            if (baseContext != null) {
                try {
                    Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                    if (obj == null) {
                        obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(Drawable.resolveOpacity(0, 0) + PDF417Common.NUMBER_OF_CODEWORDS, 34 - TextUtils.indexOf((CharSequence) "", '0', 0, 0), (char) (ViewConfiguration.getMaximumFlingVelocity() >> 16))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                    }
                    Object invoke = ((Method) obj).invoke(null, null);
                    try {
                        Object[] objArr6 = new Object[1];
                        O((byte) (-MyBillsEntityDataFactory[32]), (byte) (BuiltInFictitiousFunctionClassFactory >>> 2), MyBillsEntityDataFactory[2], objArr6);
                        Class<?> cls3 = Class.forName((String) objArr6[0]);
                        Object[] objArr7 = new Object[1];
                        O(MyBillsEntityDataFactory[48], MyBillsEntityDataFactory[2], MyBillsEntityDataFactory[41], objArr7);
                        Object[] objArr8 = new Object[1];
                        N(((ApplicationInfo) cls3.getMethod((String) objArr7[0], null).invoke(this, null)).targetSdkVersion + 15, new char[]{18460, 46221, 60689, 11689, 41887, 1823, 51501, 56574, 6749, 486, 31641, 37714, 62485, 34872, 40505, 10812, 41503, 39638, 8497, 21077, 65471, 32402, 19775, 18393, 56233, 32967, 40684, 64821, 44510, 2584, 45105, 23929, 46311, 53989, 25650, 62183, 11264, 1313, 18669, 18290, 32739, 9361, 4759, 31091, 1056, 32610, 42342, 55171}, objArr8);
                        String str = (String) objArr8[0];
                        Object[] objArr9 = new Object[1];
                        N(ExpandableListView.getPackedPositionType(0L) + 64, new char[]{58048, 43118, 56086, 23646, 11264, 1313, 27662, 26630, 65471, 32402, 36830, 27046, 2218, 20723, 63290, 54084, 40155, 34073, 16411, 56847, 2218, 20723, 37176, 26034, 25333, 33668, 12749, 20632, 40684, 64821, 40155, 34073, 60477, 3491, 45882, 9465, 62508, 64817, 28742, 43061, 56228, 18187, 59214, 25968, 13711, 27036, 25991, 53907, 24863, 53240, 20216, 21132, 56630, 58753, 36590, 50010, 36590, 50010, 16532, 40170, 47107, 6047, 56233, 32967}, objArr9);
                        String str2 = (String) objArr9[0];
                        Object[] objArr10 = new Object[1];
                        N(64 - (ViewConfiguration.getMaximumFlingVelocity() >> 16), new char[]{51314, 13921, 64232, 17335, 56630, 58753, 38118, 53766, 40405, 2846, 37053, 2531, 40475, 5873, 16995, 56516, 45105, 23929, 56605, 40516, 9340, 39500, 28913, 15664, 32739, 9361, 51501, 56574, 60031, 10228, 18460, 46221, 41194, 838, 46731, 38328, 7911, 61371, 60689, 11689, 65192, 6293, 63290, 54084, 18669, 18290, 28772, 55450, 11264, 1313, 58814, 52630, 51314, 13921, 1797, 52931, 28657, 58989, 46311, 53989, 1797, 52931, 49625, 39838}, objArr10);
                        String str3 = (String) objArr10[0];
                        Object[] objArr11 = new Object[1];
                        N(60 - TextUtils.getCapsMode("", 0, 0), new char[]{11768, 47278, 7675, 31737, 52156, 42705, 20316, 36198, 37765, 49663, 38506, 11908, 26936, 2997, 56155, 62899, 41009, 48722, 41311, 9351, 33988, 50730, 11662, 38466, 11091, 14442, 39948, 47754, 23806, 53170, 44295, 4712, 39948, 47754, 64559, 35391, 11097, 35384, 42722, 30549, 19870, 32835, 26935, 60932, 3670, 40664, 43267, 14649, 459, 7299, 33445, 37765, 48116, 1298, 8870, 22739, 29006, 23848, 18601, 62374}, objArr11);
                        String str4 = (String) objArr11[0];
                        Object[] objArr12 = new Object[1];
                        N(TextUtils.indexOf((CharSequence) "", '0', 0) + 7, new char[]{26141, 9205, 26312, 22395, 51314, 13921}, objArr12);
                        try {
                            Object[] objArr13 = {baseContext, str, str2, str3, str4, true, (String) objArr12[0], 995651014};
                            Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-1276397751);
                            if (obj2 == null) {
                                obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1)) + 910, 'B' - AndroidCharacter.getMirror('0'), (char) TextUtils.indexOf("", ""))).getMethod("getAuthRequestContext", Context.class, String.class, String.class, String.class, String.class, Boolean.TYPE, String.class, Integer.TYPE);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(-1276397751, obj2);
                            }
                            ((Method) obj2).invoke(invoke, objArr13);
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
                } catch (Throwable th3) {
                    Throwable cause3 = th3.getCause();
                    if (cause3 == null) {
                        throw th3;
                    }
                    throw cause3;
                }
            }
        }
        try {
            Object[] objArr14 = new Object[1];
            O(MyBillsEntityDataFactory[2], (byte) (-MyBillsEntityDataFactory[31]), MyBillsEntityDataFactory[30], objArr14);
            Class<?> cls4 = Class.forName((String) objArr14[0]);
            Object[] objArr15 = new Object[1];
            O(MyBillsEntityDataFactory[9], (short) 30, MyBillsEntityDataFactory[30], objArr15);
            try {
                Object[] objArr16 = {Integer.valueOf(((Integer) cls4.getMethod((String) objArr15[0], Object.class).invoke(null, this)).intValue())};
                Object obj3 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(25207140);
                if (obj3 == null) {
                    Class cls5 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(494 - (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)), 4 - (ViewConfiguration.getJumpTapTimeout() >> 16), (char) Color.argb(0, 0, 0, 0));
                    Object[] objArr17 = new Object[1];
                    P((byte) (-$$a[40]), $$a[9], $$a[8], objArr17);
                    obj3 = cls5.getMethod((String) objArr17[0], Integer.TYPE);
                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(25207140, obj3);
                }
                Object[] objArr18 = (Object[]) ((Method) obj3).invoke(null, objArr16);
                int i = ((int[]) objArr18[1])[0];
                if (((int[]) objArr18[0])[0] != i) {
                    long j = ((r0 ^ i) & 4294967295L) | 42949672960L;
                    try {
                        Object obj4 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                        if (obj4 != null) {
                            objArr = null;
                        } else {
                            objArr = null;
                            obj4 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - TextUtils.getTrimmedLength(""), Color.argb(0, 0, 0, 0) + 35, (char) TextUtils.indexOf("", "", 0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj4);
                        }
                        Object invoke2 = ((Method) obj4).invoke(objArr, objArr);
                        try {
                            Object[] objArr19 = {502223528, Long.valueOf(j), new ArrayList(), LauncherActivity.getAuid()};
                            Object obj5 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                            if (obj5 == null) {
                                obj5 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(910 - TextUtils.lastIndexOf("", '0', 0), 17 - TextUtils.lastIndexOf("", '0', 0), (char) (1 - (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1))))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1759031285, obj5);
                            }
                            ((Method) obj5).invoke(invoke2, objArr19);
                        } catch (Throwable th4) {
                            Throwable cause4 = th4.getCause();
                            if (cause4 == null) {
                                throw th4;
                            }
                            throw cause4;
                        }
                    } catch (Throwable th5) {
                        Throwable cause5 = th5.getCause();
                        if (cause5 == null) {
                            throw th5;
                        }
                        throw cause5;
                    }
                }
                super.onCreate(bundle);
                d();
                setContentView(R.layout.griver_image_activity_capture);
                this.B = getPackageManager().hasSystemFeature("android.hardware.camera.flash");
                StringBuilder sb = new StringBuilder();
                sb.append("Device support flash ? ");
                sb.append(this.B);
                RVLogger.d(TAG, sb.toString());
                DensityUtil.dip2px(this, 125.0f);
                Bundle extras = getIntent().getExtras();
                this.A = extras;
                if (extras == null) {
                    this.A = new Bundle();
                    RVLogger.d(TAG, "Activity extras is null!");
                }
                a();
                f();
                e();
            } catch (Throwable th6) {
                Throwable cause6 = th6.getCause();
                if (cause6 == null) {
                    throw th6;
                }
                throw cause6;
            }
        } catch (Throwable th7) {
            Throwable cause7 = th7.getCause();
            if (cause7 == null) {
                throw th7;
            }
            throw cause7;
        }
    }

    private void d() {
        if (ToolUtils.isConcaveScreen(this)) {
            RVLogger.d(TAG, "concaveScreenCompact:full screen.");
            requestWindowFeature(1);
            getWindow().setFlags(1024, 1024);
        }
    }

    private void e() {
        if (ToolUtils.isConcaveScreen(this)) {
            RVLogger.d(TAG, "concaveScreenCompact:adjust top place holder height.");
            View findViewById = findViewById(R.id.v_full_screen_top_place_holder);
            findViewById.setVisibility(0);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) findViewById.getLayoutParams();
            layoutParams.height = StatusBarUtils.getStatusBarHeight(this);
            findViewById.setLayoutParams(layoutParams);
        }
    }

    private void f() {
        this.coverView = findViewById(R.id.coverView);
        this.cameraContainer = (TouchInterceptFrameLayout) findViewById(R.id.cameraContainer);
        this.topTips = (TextView) findViewById(R.id.top_tips);
        TextView textView = (TextView) findViewById(R.id.indicator_capture);
        this.captureIndicator = textView;
        textView.setVisibility(this.e == 1 ? 4 : 0);
        this.ivPrepare = (ImageView) findViewById(R.id.ivCameraPrepare);
        this.controlPanel = (RelativeLayout) findViewById(R.id.control_panel);
        this.tipsText = (TextView) findViewById(R.id.tips);
        TextView textView2 = (TextView) findViewById(R.id.indicator_video);
        this.videoIndicator = textView2;
        textView2.setVisibility(this.e != 2 ? 0 : 4);
        this.btnFilter = (ImageView) findViewById(R.id.btnFilter);
        ImageView imageView = (ImageView) findViewById(R.id.btnEffectSelect);
        this.p = imageView;
        imageView.setVisibility(this.f ? 0 : 8);
        ImageView imageView2 = (ImageView) findViewById(R.id.btnEffectSelect2);
        this.q = imageView2;
        imageView2.setOnClickListener(this);
        ImageView imageView3 = (ImageView) findViewById(R.id.bt_latest_record_entry);
        this.r = imageView3;
        imageView3.setOnClickListener(this);
        g();
        this.btnFilter.setOnClickListener(this);
        this.btnFilter.setVisibility(this.h ? 0 : 8);
        this.p.setOnClickListener(this);
        this.tipsText2 = (TextView) findViewById(R.id.tips_common);
        TitleBar titleBar = (TitleBar) findViewById(R.id.title);
        this.mTitle = titleBar;
        titleBar.ivFlash.setVisibility((this.i == 1 || !this.B) ? 8 : 0);
        this.btnRecord = (CaptureBtn) findViewById(R.id.btnRecord);
        this.s = findViewById(R.id.recordProgress);
        this.btnRecord.takePictureBtn.setOnClickListener(this.captureClickListener);
        this.mTitle.ivFlash.setOnClickListener(this.K);
        this.btnRecord.setViewType(h() ? CaptureBtn.Type.PICTURE : CaptureBtn.Type.VIDEO);
        this.mTitle.setTitleText(h() ? getString(R.string.griver_image_capture) : getString(R.string.griver_video_capture));
        i();
        j();
    }

    private void g() {
        if (this.l && !TextUtils.isEmpty(this.m)) {
            this.q.setVisibility(this.f ? 0 : 8);
            this.r.setVisibility(0);
            if (this.q.getVisibility() == 0) {
                this.p.setVisibility(8);
                return;
            }
            return;
        }
        this.p.setVisibility(this.f ? 0 : 8);
        this.q.setVisibility(8);
        this.r.setVisibility(8);
    }

    private boolean h() {
        int i = this.e;
        if (i != 2) {
            return i == 3 && this.j == 1;
        }
        return true;
    }

    private void i() {
        this.coverView.bringToFront();
        this.ivPrepare.bringToFront();
        this.ivPrepare.setOnTouchListener(new View.OnTouchListener() { // from class: com.alibaba.griver.image.activity.GriverCaptureActivity.8
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                return true;
            }

            {
                GriverCaptureActivity.this = this;
            }
        });
    }

    private void j() {
        InnerHandler innerHandler = new InnerHandler(this);
        this.D = innerHandler;
        innerHandler.postDelayed(new Runnable() { // from class: com.alibaba.griver.image.activity.GriverCaptureActivity.9
            @Override // java.lang.Runnable
            public void run() {
            }

            {
                GriverCaptureActivity.this = this;
            }
        }, 1500L);
        GriverImageService griverImageService = (GriverImageService) RVProxy.get(GriverImageService.class);
        this.y = griverImageService;
        if (griverImageService == null) {
            x();
            finish();
            return;
        }
        this.mTitle.ivBack.setOnClickListener(this);
        k();
    }

    private void k() {
        this.cameraContainer.setOnTapListener(new TouchInterceptFrameLayout.TapListener() { // from class: com.alibaba.griver.image.activity.GriverCaptureActivity.10
            {
                GriverCaptureActivity.this = this;
            }

            @Override // com.alibaba.griver.image.capture.widget.TouchInterceptFrameLayout.TapListener
            public void onTap(View view) {
                GriverCaptureActivity.this.l();
            }
        });
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        if (z) {
            this.D.post(new Runnable() { // from class: com.alibaba.griver.image.activity.GriverCaptureActivity.11
                {
                    GriverCaptureActivity.this = this;
                }

                @Override // java.lang.Runnable
                public void run() {
                    GriverCaptureActivity.this.m();
                }
            });
        }
    }

    public void m() {
        String string;
        if (this.cameraView != null) {
            return;
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        CameraParams cameraParams = new CameraParams();
        cameraParams.setDefaultCameraFront(this.i == 1);
        ImageView imageView = this.mTitle.ivCamera;
        if (this.i == 1) {
            string = getString(R.string.griver_image_switch_to_back_camera);
        } else {
            string = getString(R.string.griver_image_switch_to_front_camera);
        }
        imageView.setContentDescription(string);
        cameraParams.recordType = 2;
        cameraParams.enableBeauty(true);
        if (this.e == 2) {
            cameraParams.mMode = 1;
        }
        SightCameraViewImpl sightCameraViewImpl = new SightCameraViewImpl(this, cameraParams);
        this.cameraView = sightCameraViewImpl;
        sightCameraViewImpl.setLayoutParams(layoutParams);
        this.cameraView.setOnScrollListener(this);
        this.cameraView.setOnRecordListener(this.onRecordListener);
        this.cameraContainer.addView(this.cameraView);
    }

    public void a(APVideoRecordRsp aPVideoRecordRsp) {
        this.t = aPVideoRecordRsp.mCamera;
        this.captureIndicator.setOnClickListener(new View.OnClickListener() { // from class: com.alibaba.griver.image.activity.GriverCaptureActivity.12
            {
                GriverCaptureActivity.this = this;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (GriverCaptureActivity.this.u != 2 && GriverCaptureActivity.this.u == 0) {
                    GriverCaptureActivity.this.e(false);
                }
            }
        });
        this.videoIndicator.setOnClickListener(new View.OnClickListener() { // from class: com.alibaba.griver.image.activity.GriverCaptureActivity.13
            {
                GriverCaptureActivity.this = this;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (GriverCaptureActivity.this.u != 2 && GriverCaptureActivity.this.u == 1) {
                    GriverCaptureActivity.this.d(false);
                }
            }
        });
        this.btnRecord.setVisibility(0);
        if (h()) {
            e(true);
        } else {
            d(true);
        }
    }

    public void n() {
        if (this.C == d) {
            this.w = f6551a;
        } else if (this.w == f6551a) {
            try {
                Camera camera = this.t;
                if (camera != null) {
                    Camera.Parameters parameters = camera.getParameters();
                    parameters.setFlashMode("off");
                    this.t.setParameters(parameters);
                }
                InstrumentInjector.Resources_setImageResource(this.mTitle.ivFlash, R.drawable.griver_image_ic_flash_off);
                this.mTitle.ivFlash.setContentDescription(getString(R.string.griver_image_turn_on_flash));
            } catch (Exception e) {
                StringBuilder sb = new StringBuilder();
                sb.append("Shutdown flash error! camera.setParameters exception ,");
                sb.append(e.getMessage());
                RVLogger.w(TAG, sb.toString());
            }
        } else {
            a(this.t, this.u);
        }
    }

    private void a(Camera camera, int i) {
        if (camera == null) {
            o();
            return;
        }
        Camera.Parameters parameters = camera.getParameters();
        List<String> supportedFlashModes = parameters.getSupportedFlashModes();
        if (supportedFlashModes == null) {
            o();
            return;
        }
        if (i == 0) {
            if (supportedFlashModes.contains("torch")) {
                parameters.setFlashMode("torch");
            } else if (supportedFlashModes.contains(CameraParams.FLASH_MODE_ON)) {
                parameters.setFlashMode(CameraParams.FLASH_MODE_ON);
            } else {
                o();
                return;
            }
        } else if (i == 1) {
            if (supportedFlashModes.contains(CameraParams.FLASH_MODE_ON) && CameraUtils.isSupportCaptureFlush()) {
                parameters.setFlashMode(CameraParams.FLASH_MODE_ON);
            } else {
                o();
                return;
            }
        }
        try {
            camera.setParameters(parameters);
            InstrumentInjector.Resources_setImageResource(this.mTitle.ivFlash, R.drawable.griver_image_ic_flash_on);
            this.mTitle.ivFlash.setContentDescription(getString(R.string.griver_image_turn_off_flash));
        } catch (Exception e) {
            StringBuilder sb = new StringBuilder();
            sb.append("camera.setParameters exception,");
            sb.append(e.getMessage());
            RVLogger.w(TAG, sb.toString());
            o();
        }
    }

    public void o() {
        ToastUtils.showToast(this, getString(R.string.griver_image_tips_unable_to_flush), 0);
        this.w = f6551a;
        InstrumentInjector.Resources_setImageResource(this.mTitle.ivFlash, R.drawable.griver_image_ic_flash_off);
        this.mTitle.ivFlash.setContentDescription(getString(R.string.griver_image_turn_on_flash));
    }

    private void a(boolean z) {
        if (this.v == 0) {
            return;
        }
        float f = -((this.videoIndicator.getWidth() + this.captureIndicator.getWidth()) / 2);
        ObjectAnimator.ofFloat(this.videoIndicator, "translationX", f, 0.0f).setDuration(z ? 0L : 500L).start();
        ObjectAnimator.ofFloat(this.captureIndicator, "translationX", f, 0.0f).setDuration(z ? 0L : 500L).start();
        this.captureIndicator.setTextColor(getResources().getColor(R.color.griver_image_colorWhite));
        this.videoIndicator.setTextColor(getResources().getColor(R.color.griver_image_captureBlue));
        this.v = 0;
    }

    public void q() {
        r();
        this.u = 1;
        this.btnRecord.setViewType(CaptureBtn.Type.PICTURE);
        this.btnRecord.setVisibility(0);
        this.mTitle.setTitleText(getString(R.string.griver_image_capture));
        this.w = f6551a;
        n();
    }

    private void b(boolean z) {
        if (this.v == 1) {
            return;
        }
        float f = -((this.videoIndicator.getWidth() + this.captureIndicator.getWidth()) / 2);
        ObjectAnimator.ofFloat(this.videoIndicator, "translationX", 0.0f, f).setDuration(z ? 0L : 500L).start();
        ObjectAnimator.ofFloat(this.captureIndicator, "translationX", 0.0f, f).setDuration(z ? 0L : 500L).start();
        this.videoIndicator.setTextColor(getResources().getColor(R.color.griver_image_colorWhite));
        this.captureIndicator.setTextColor(getResources().getColor(R.color.griver_image_captureBlue));
        this.v = 1;
    }

    private void r() {
        this.mTitle.llOptions.setVisibility(0);
        if (Camera.getNumberOfCameras() >= 2 && this.n) {
            this.mTitle.ivCamera.setVisibility(0);
            this.mTitle.ivCamera.setOnClickListener(this.M);
            return;
        }
        this.mTitle.ivCamera.setVisibility(8);
    }

    public void a(int i) {
        this.u = 2;
        CameraUtils.switchCameraFacing(this.cameraView, this.C, this.L, i);
    }

    private void c(boolean z) {
        if (z) {
            this.controlPanel.setVisibility(0);
            this.btnRecord.setVisibility(0);
            return;
        }
        this.controlPanel.setVisibility(8);
        this.btnRecord.setVisibility(8);
    }

    private void s() {
        this.s.setVisibility(8);
        this.s.clearAnimation();
    }

    public void t() {
        this.x = false;
        s();
        this.controlPanel.setVisibility(0);
    }

    @Override // com.alibaba.griver.image.capture.widget.SightCameraView.OnScrollListener
    public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        if (this.e == 3 && Math.abs(motionEvent.getX() - motionEvent2.getX()) >= Math.abs(motionEvent.getY() - motionEvent2.getY())) {
            l();
            int i = this.u;
            if (i != 0) {
                if (i == 1 && motionEvent.getX() - motionEvent2.getX() < 0.0f) {
                    d(false);
                }
            } else if (motionEvent.getX() - motionEvent2.getX() > 0.0f) {
                e(false);
            }
            return true;
        }
        return true;
    }

    public void d(boolean z) {
        this.u = 2;
        RVLogger.d(TAG, "changeToVideoState------------------");
        a(z);
        CameraUtils.openRecordMode(this.t, this.L);
    }

    public void e(boolean z) {
        RVLogger.d(TAG, "changeToPhotoState------------------");
        this.u = 2;
        b(z);
        CameraUtils.openCaptureMode(this.t, this.L);
    }

    void publishImageAction(final MediaInfo mediaInfo) {
        runOnUiThread(new Runnable() { // from class: com.alibaba.griver.image.activity.GriverCaptureActivity.14
            {
                GriverCaptureActivity.this = this;
            }

            @Override // java.lang.Runnable
            public void run() {
                GriverCaptureActivity.this.a(mediaInfo);
                if (GriverCaptureActivity.this.g) {
                    GriverCaptureActivity.this.finish();
                }
            }
        });
    }

    public void a(MediaInfo mediaInfo) {
        this.H = true;
        Intent intent = new Intent(GriverEnv.getApplicationContext(), GriverCapturePreviewActivity.class);
        intent.putExtras(this.A);
        intent.putExtra(GriverCapturePreviewActivity.EXTRA_KEY_MEDIA_INFO, mediaInfo);
        intent.putExtra(CaptureParam.INIT_CAMERA_FACING, this.C);
        startActivity(intent);
        overridePendingTransition(17432576, 17432577);
    }

    @Override // android.app.Activity
    public void onStop() {
        super.onStop();
        this.D.removeCallbacksAndMessages(null);
        if (!this.I) {
            x();
        } else {
            RVLogger.d(TAG, "Notify called before,do nothing.");
        }
        RVLogger.d(TAG, "onStop reached,call finish to release recourse.");
        manuallyReleaseCamera(this.cameraView);
        finish();
    }

    public void manuallyReleaseCamera(SightCameraView sightCameraView) {
        if (sightCameraView != null) {
            RVLogger.d(TAG, "Manually release camera.");
            sightCameraView.releaseCamera();
            return;
        }
        RVLogger.d(TAG, "manuallyReleaseCamera:### cameraView null!");
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.mTitle.ivBack) {
            x();
            finish();
        } else if (view == this.btnFilter) {
            if (this.u == 2) {
                return;
            }
            c(false);
        } else if (view == this.p || view == this.q) {
            if (this.u == 2) {
                return;
            }
            c(false);
            u();
            v();
        } else if (view == this.r) {
            finish();
        }
    }

    private void u() {
        RVLogger.d(TAG, "changeToFrontCamera:");
        if (this.C == c) {
            RVLogger.d(TAG, "Perform changing");
            a(this.u);
            return;
        }
        RVLogger.d(TAG, "Now is front camera,no need to change.");
    }

    protected void resetState() {
        runOnUiThread(new Runnable() { // from class: com.alibaba.griver.image.activity.GriverCaptureActivity.15
            {
                GriverCaptureActivity.this = this;
            }

            @Override // java.lang.Runnable
            public void run() {
                GriverCaptureActivity.this.w();
                GriverCaptureActivity.this.t();
            }
        });
    }

    public void w() {
        this.D.removeMessages(1);
        this.D.removeMessages(2);
        this.tipsText2.setVisibility(8);
        this.D.sendEmptyMessageDelayed(1, 1000L);
    }

    public void a(String str, int i, int i2, int i3, Bundle bundle) {
        if (str.startsWith(File.separator)) {
            StringBuilder sb = new StringBuilder();
            sb.append(PhotoContext.FILE_SCHEME);
            sb.append(str);
            str = sb.toString();
        }
        MediaInfo mediaInfo = new MediaInfo(0, str, i, i2, i3, 0L);
        if (bundle != null) {
            mediaInfo.mediaFileSize = bundle.getLong("picSize");
        }
        mediaInfo.isTakenByFrontCamera = this.C == d;
        publishImageAction(mediaInfo);
    }

    public void a(String str) {
        this.D.removeMessages(3);
        this.topTips.setVisibility(0);
        this.topTips.setText(str);
        this.D.sendEmptyMessageDelayed(3, 3000L);
    }

    @Override // android.app.Activity
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        SightCameraView sightCameraView = this.cameraView;
        if (sightCameraView != null) {
            sightCameraView.onRequestPermissionsResult(i, strArr, iArr);
        }
    }

    public void x() {
        if (this.H) {
            RVLogger.d(TAG, "Need preview ,not notify at \"notifyFail\"");
            return;
        }
        this.I = true;
        CaptureServiceImpl.notifyAction(true, null, true);
    }

    /* loaded from: classes6.dex */
    public static class InnerHandler extends Handler {

        /* renamed from: a */
        private WeakReference<GriverCaptureActivity> f6553a;

        public InnerHandler(GriverCaptureActivity griverCaptureActivity) {
            this.f6553a = new WeakReference<>(griverCaptureActivity);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            GriverCaptureActivity griverCaptureActivity = this.f6553a.get();
            if (griverCaptureActivity != null) {
                if (message.what == 1) {
                    griverCaptureActivity.tipsText.setText((CharSequence) null);
                    griverCaptureActivity.tipsText.setVisibility(8);
                } else if (message.what == 2) {
                    griverCaptureActivity.tipsText2.setText((CharSequence) null);
                    griverCaptureActivity.tipsText2.setVisibility(8);
                } else if (message.what == 3) {
                    griverCaptureActivity.topTips.setText((CharSequence) null);
                }
            }
        }
    }

    private static void N(int i, char[] cArr, Object[] objArr) {
        C c2 = new C();
        char[] cArr2 = new char[cArr.length];
        c2.BuiltInFictitiousFunctionClassFactory = 0;
        char[] cArr3 = new char[2];
        while (c2.BuiltInFictitiousFunctionClassFactory < cArr.length) {
            cArr3[0] = cArr[c2.BuiltInFictitiousFunctionClassFactory];
            cArr3[1] = cArr[c2.BuiltInFictitiousFunctionClassFactory + 1];
            int i2 = 58224;
            for (int i3 = 0; i3 < 16; i3++) {
                cArr3[1] = (char) (cArr3[1] - (((cArr3[0] + i2) ^ ((cArr3[0] << 4) + ((char) (NetworkUserEntityData$$ExternalSyntheticLambda0 ^ 6353485791441662354L)))) ^ ((cArr3[0] >>> 5) + ((char) (lookAheadTest ^ 6353485791441662354L)))));
                cArr3[0] = (char) (cArr3[0] - (((cArr3[1] + i2) ^ ((cArr3[1] << 4) + ((char) (KClassImpl$Data$declaredNonStaticMembers$2 ^ 6353485791441662354L)))) ^ ((cArr3[1] >>> 5) + ((char) (getAuthRequestContext ^ 6353485791441662354L)))));
                i2 -= 40503;
            }
            cArr2[c2.BuiltInFictitiousFunctionClassFactory] = cArr3[0];
            cArr2[c2.BuiltInFictitiousFunctionClassFactory + 1] = cArr3[1];
            c2.BuiltInFictitiousFunctionClassFactory += 2;
        }
        objArr[0] = new String(cArr2, 0, i);
    }
}
