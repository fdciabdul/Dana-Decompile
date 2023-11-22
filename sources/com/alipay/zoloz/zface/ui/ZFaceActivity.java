package com.alipay.zoloz.zface.ui;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.ImageFormat;
import android.graphics.PointF;
import android.graphics.drawable.BitmapDrawable;
import android.media.AudioTrack;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Process;
import android.os.SystemClock;
import android.renderscript.Allocation;
import android.renderscript.Element;
import android.renderscript.RSRuntimeException;
import android.renderscript.RenderScript;
import android.renderscript.ScriptIntrinsicBlur;
import android.telephony.cdma.CdmaCellLocation;
import android.text.AndroidCharacter;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ExpandableListView;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.alibaba.wireless.security.SecExceptionCode;
import com.alipay.mobile.security.bio.api.BioDetector;
import com.alipay.mobile.security.bio.api.BioResponse;
import com.alipay.mobile.security.bio.service.BioUploadResult;
import com.alipay.mobile.security.bio.utils.RotateBitmapHelper;
import com.alipay.mobile.security.faceauth.model.DetectTimerTask;
import com.alipay.zoloz.hardware.camera.ICameraInterface;
import com.alipay.zoloz.hardware.camera.utils.AndroidCameraUtil;
import com.alipay.zoloz.hardware.camera.widget.CameraSurfaceView;
import com.alipay.zoloz.toyger.R2;
import com.alipay.zoloz.toyger.blob.BitmapHelper;
import com.alipay.zoloz.toyger.face.ToygerFaceAttr;
import com.alipay.zoloz.zface.beans.AlertData;
import com.alipay.zoloz.zface.beans.FaceRemoteConfig;
import com.alipay.zoloz.zface.beans.FrameStateData;
import com.alipay.zoloz.zface.beans.PreviewData;
import com.alipay.zoloz.zface.beans.UploadData;
import com.alipay.zoloz.zface.services.TimeRecord;
import com.alipay.zoloz.zface.services.ZFaceRecordService;
import com.alipay.zoloz.zface.ui.hot.reload.HotReloadDrawable;
import com.alipay.zoloz.zface.ui.util.AlertUtil;
import com.alipay.zoloz.zface.ui.util.FaceScanTipsUtil;
import com.alipay.zoloz.zface.ui.widget.AlgorithmScheduleProgressBar;
import com.alipay.zoloz.zface.ui.widget.ZfaceUploadLoadingView;
import com.alipay.zoloz.zface.utils.ObjectUtil;
import com.google.common.base.Ascii;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.google.zxing.pdf417.PDF417Common;
import id.dana.R;
import id.dana.onboarding.splash.LauncherActivity;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import o.SummaryVoucherView$$ExternalSyntheticLambda0;
import o.VerifyPinStateManager$executeRiskChallenge$2$1;
import zoloz.ap.com.toolkit.R2;
import zoloz.ap.com.toolkit.ui.CustomTextView;
import zoloz.ap.com.toolkit.ui.DialogHelper;
import zoloz.ap.com.toolkit.ui.TitleBar;

/* loaded from: classes7.dex */
public class ZFaceActivity extends BaseFaceActivity {
    private AlgorithmScheduleProgressBar mAlgorithmScheduleProgressBar;
    private ImageView mCameraPreviewImg;
    private CameraSurfaceView mCameraSurfaceView;
    private DetectTimerTask mDetectTimerTask;
    private FaceScanTipsUtil mFaceScanTipsUtil;
    private TitleBar mTitleBar;
    private CustomTextView mZfaceTopTips;
    private ZfaceUploadLoadingView mZfaceUploadLoadingView;
    public static final byte[] $$g = {107, -117, Ascii.NAK, -50, -51, TarHeader.LF_NORMAL, -46, -10, -7, -14, 39, -48, -13, 4, -18, -12, 46, -36, -26, 12, Ascii.DC4, -34, -9, -24, -2, -10, -14, -5, -22, 44, -59, -6, 5, 15, -26, -19, -11, 9, -21, -8, 42, -51, -6, -13, 8, -26, -3, 1, -48, 4, -25, -7, 35, -43, -10, -3, 65, -39, -36, -26, 12, TarHeader.LF_FIFO, -71, -8, -5, -16, 4, -24, 6, -6, 15, -40, -6, Ascii.DC4, -40, 12, -26, 4, -1, 15, -31, -15, 4, -10, -20, -8, 72, -21};
    public static final int $$h = 91;
    public static final byte[] scheduleImpl = {88, 72, 91, 85, 17, -6, 18, 1, -2, -1, -50, 57, 16, 3, 10, -11, 13, 10, -66, Ascii.EM, TarHeader.LF_NORMAL, 3, 10, -11, Ascii.ETB, 0, -1, 5, 13, 10, -7, 15, 9, -45, Ascii.GS, 22, -7, -33, TarHeader.LF_NORMAL, -7, 5, -5, Ascii.EM, -17, -47, 66, -7, 17, -3, -53, 41, 42, -2, 5, -11, 12, 2, 19, -47, TarHeader.LF_CHR, 4, 0, 1, -2, 2, Ascii.ETB, -7, 10, 3, -33, 41, -4, 13};
    public static final int getErrorConfigVersion = 242;
    private static int[] GetContactSyncConfig = {1423460401, -367008871, -2009155429, -1000624644, -2051609055, 846222696, -1549159298, -1637780772, 1398694150, -1456539445, 117776532, -1767225699, 1043464467, 848318780, -1472700430, 1733986758, -1999244739, 1248672289};
    private boolean mIsShowFrame = false;
    private FrameStateData mFrameStateData = null;
    private boolean isPause = false;
    private boolean mIsCheckFaced = false;
    private Bitmap mBestBitmap = null;

    /* JADX WARN: Removed duplicated region for block: B:10:0x0026  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x001e  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0026 -> B:11:0x0032). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void g(short r6, short r7, byte r8, java.lang.Object[] r9) {
        /*
            int r7 = 23 - r7
            int r6 = 106 - r6
            int r8 = 55 - r8
            byte[] r0 = com.alipay.zoloz.zface.ui.ZFaceActivity.scheduleImpl
            byte[] r1 = new byte[r7]
            int r7 = r7 + (-1)
            r2 = 0
            if (r0 != 0) goto L16
            r6 = r7
            r3 = r1
            r4 = 0
            r1 = r0
            r0 = r9
            r9 = r8
            goto L32
        L16:
            r3 = 0
        L17:
            byte r4 = (byte) r6
            r1[r3] = r4
            int r4 = r3 + 1
            if (r3 != r7) goto L26
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            r9[r2] = r6
            return
        L26:
            int r8 = r8 + 1
            r3 = r0[r8]
            r5 = r8
            r8 = r6
            r6 = r7
            r7 = r3
            r3 = r1
            r1 = r0
            r0 = r9
            r9 = r5
        L32:
            int r8 = r8 + r7
            int r7 = r8 + (-4)
            r8 = r9
            r9 = r0
            r0 = r1
            r1 = r3
            r3 = r4
            r5 = r7
            r7 = r6
            r6 = r5
            goto L17
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.zoloz.zface.ui.ZFaceActivity.g(short, short, byte, java.lang.Object[]):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0026  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x001e  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0026 -> B:11:0x002c). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void j(byte r7, byte r8, byte r9, java.lang.Object[] r10) {
        /*
            int r9 = r9 * 2
            int r9 = r9 + 75
            int r7 = r7 * 3
            int r7 = r7 + 21
            int r8 = 47 - r8
            byte[] r0 = com.alipay.zoloz.zface.ui.ZFaceActivity.$$g
            byte[] r1 = new byte[r7]
            r2 = 0
            if (r0 != 0) goto L16
            r9 = r8
            r3 = r9
            r5 = 0
            r8 = r7
            goto L2c
        L16:
            r3 = 0
        L17:
            byte r4 = (byte) r9
            int r5 = r3 + 1
            r1[r3] = r4
            if (r5 != r7) goto L26
            java.lang.String r7 = new java.lang.String
            r7.<init>(r1, r2)
            r10[r2] = r7
            return
        L26:
            r3 = r0[r8]
            r6 = r8
            r8 = r7
            r7 = r9
            r9 = r6
        L2c:
            int r3 = -r3
            int r7 = r7 + r3
            int r9 = r9 + 1
            int r7 = r7 + (-7)
            r3 = r5
            r6 = r9
            r9 = r7
            r7 = r8
            r8 = r6
            goto L17
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.zoloz.zface.ui.ZFaceActivity.j(byte, byte, byte, java.lang.Object[]):void");
    }

    @Override // com.alipay.zoloz.zface.ui.BaseFaceActivity, com.alipay.zoloz.zface.ui.activity.BaseCameraPermissionActivity, com.alipay.mobile.security.bio.workspace.BioFragmentContainer, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper
    public void attachBaseContext(Context context) {
        Object[] objArr;
        Object[] objArr2;
        Object[] objArr3;
        Object[] objArr4;
        super.attachBaseContext(context);
        Object[] objArr5 = new Object[1];
        h((Process.myPid() >> 22) + 18, new int[]{-875292914, 160860904, 2094356210, -84424135, -1866862892, -843064822, 284842022, -796518265, -507641607, 1050992027}, objArr5);
        Class<?> cls = Class.forName((String) objArr5[0]);
        Object[] objArr6 = new Object[1];
        h(4 - TextUtils.indexOf((CharSequence) "", '0', 0, 0), new int[]{1726751475, -1821631328, -1366803796, 1899331101}, objArr6);
        int intValue = ((Integer) cls.getDeclaredMethod((String) objArr6[0], new Class[0]).invoke(null, new Object[0])).intValue() % 100000;
        if (intValue < 99000 || intValue > 99999) {
            Context applicationContext = context != null ? context.getApplicationContext() : context;
            if (applicationContext != null) {
                try {
                    Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                    if (obj == null) {
                        obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(977 - AndroidCharacter.getMirror('0'), TextUtils.indexOf("", "", 0) + 35, (char) TextUtils.getTrimmedLength(""))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                    }
                    Object invoke = ((Method) obj).invoke(null, null);
                    Object[] objArr7 = new Object[1];
                    h((ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)) + 47, new int[]{-415432106, 1631454933, -1059415741, -2132227440, -1787554067, -1208729127, 1307980038, -62820229, -2040237541, -1298739299, -1433659714, -403797280, 1904115761, 699065491, -790652313, 1375060066, -403339669, 1259316533, -707395327, -913397075, -1656552534, -1532251168, -1347646864, 1312053750}, objArr7);
                    String str = (String) objArr7[0];
                    Object[] objArr8 = new Object[1];
                    h(64 - Color.red(0), new int[]{-1616859879, -1239482464, 177606891, 1819497457, -1253215081, 250993511, 1788926167, 591972615, -1464453682, 760373717, -1508754474, 1749400248, -877854058, -1118192022, -1445023808, 1655548085, -1853357909, -1457157128, 1353230859, 1575310618, 1415223075, 683605279, 802813321, -158974585, 359388369, 2107071132, -1765732957, -1262467052, -1434456119, 1182467551, -655743287, -649320202}, objArr8);
                    String str2 = (String) objArr8[0];
                    Object[] objArr9 = new Object[1];
                    h(KeyEvent.getDeadChar(0, 0) + 64, new int[]{892160850, 612045157, -1116179497, 784520038, -1642731300, -1489567732, -1066141448, -1652910906, -1377834031, 337365119, 1789618898, -295433155, -957402045, 1222882077, 902677288, -2070100858, -776967397, -395555975, 633653519, 743911543, -572109780, 1291230761, -1198931913, 1882101074, -445049788, 633838422, 1063831776, -1657885219, 119351429, -1751901339, 105373726, -365511266}, objArr9);
                    String str3 = (String) objArr9[0];
                    Object[] objArr10 = new Object[1];
                    h(TextUtils.indexOf("", "") + 60, new int[]{-969071955, 775962663, -1899349615, 1643968595, -1332430941, 1329870651, 676590314, -535345266, 1457546168, -301787569, 373844351, -245366700, 1869791725, -1971316015, 1040001971, -1275014735, -856200565, -276374144, -1337502001, -1457771707, -800139196, -245602406, 301280873, -366960367, -1113342204, -1929662534, 290698966, -50100522, 538438649, 885419868}, objArr10);
                    String str4 = (String) objArr10[0];
                    Object[] objArr11 = new Object[1];
                    h(Gravity.getAbsoluteGravity(0, 0) + 6, new int[]{1333478308, -1566930380, 15186434, 1646474947}, objArr11);
                    try {
                        Object[] objArr12 = {applicationContext, str, str2, str3, str4, true, (String) objArr11[0], 995651014};
                        Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-1276397751);
                        if (obj2 == null) {
                            obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getMinimumFlingVelocity() >> 16) + 911, TextUtils.indexOf((CharSequence) "", '0') + 19, (char) (1 - (SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1))))).getMethod("getAuthRequestContext", Context.class, String.class, String.class, String.class, String.class, Boolean.TYPE, String.class, Integer.TYPE);
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
                Object[] objArr13 = {this};
                Object[] objArr14 = new Object[1];
                g(scheduleImpl[25], (byte) (-scheduleImpl[30]), scheduleImpl[31], objArr14);
                Class<?> cls2 = Class.forName((String) objArr14[0]);
                Object[] objArr15 = new Object[1];
                g(scheduleImpl[7], (byte) (-scheduleImpl[30]), (byte) (scheduleImpl[34] + 1), objArr15);
                try {
                    Object[] objArr16 = {applicationContext2, Integer.valueOf(((Integer) cls2.getMethod((String) objArr15[0], Object.class).invoke(null, objArr13)).intValue())};
                    Object obj3 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1691739267);
                    if (obj3 == null) {
                        Class cls3 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)) + 55, 3 - View.MeasureSpec.getSize(0), (char) ((-1) - (ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1))));
                        Object[] objArr17 = new Object[1];
                        j($$g[47], (byte) (-$$g[53]), $$g[47], objArr17);
                        obj3 = cls3.getMethod((String) objArr17[0], Context.class, Integer.TYPE);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1691739267, obj3);
                    }
                    Object invoke2 = ((Method) obj3).invoke(null, objArr16);
                    try {
                        Object obj4 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(40157535);
                        if (obj4 == null) {
                            obj4 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((CdmaCellLocation.convertQuartSecToDecDegrees(0) > FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 0 : -1)) + 800, TextUtils.lastIndexOf("", '0', 0, 0) + 16, (char) Color.argb(0, 0, 0, 0))).getMethod("getAuthRequestContext", null);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(40157535, obj4);
                        }
                        int intValue2 = ((Integer) ((Method) obj4).invoke(invoke2, null)).intValue();
                        try {
                            Object obj5 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1621779126);
                            if (obj5 == null) {
                                obj5 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(View.resolveSize(0, 0) + 800, TextUtils.lastIndexOf("", '0', 0, 0) + 16, (char) KeyEvent.getDeadChar(0, 0))).getMethod("PlaceComponentResult", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1621779126, obj5);
                            }
                            if (((Integer) ((Method) obj5).invoke(invoke2, null)).intValue() != intValue2) {
                                ArrayList arrayList = new ArrayList();
                                try {
                                    Object[] objArr18 = {invoke2};
                                    Object obj6 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(658700871);
                                    if (obj6 == null) {
                                        obj6 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(Process.getGidForName("") + 816, (ViewConfiguration.getTapTimeout() >> 16) + 29, (char) (57994 - (Process.myTid() >> 22)))).getMethod("getAuthRequestContext", (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(TextUtils.lastIndexOf("", '0') + SecExceptionCode.SEC_ERROR_PKG_VALID_INVALID_PARAM, 16 - (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)), (char) (ViewConfiguration.getMinimumFlingVelocity() >> 16)));
                                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(658700871, obj6);
                                    }
                                    arrayList.add(((Method) obj6).invoke(null, objArr18));
                                    long j = ((r10 ^ intValue2) & 4294967295L) | 60129542144L;
                                    try {
                                        Object obj7 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                                        if (obj7 != null) {
                                            objArr = null;
                                        } else {
                                            objArr = null;
                                            obj7 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(930 - (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)), 35 - (Process.myTid() >> 22), (char) ((-1) - TextUtils.lastIndexOf("", '0')))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj7);
                                        }
                                        Object invoke3 = ((Method) obj7).invoke(objArr, objArr);
                                        try {
                                            Object[] objArr19 = {-1524768889, Long.valueOf(j), arrayList, LauncherActivity.getAuid()};
                                            Object obj8 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                            if (obj8 == null) {
                                                obj8 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((Process.myPid() >> 22) + 911, Gravity.getAbsoluteGravity(0, 0) + 18, (char) Gravity.getAbsoluteGravity(0, 0))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
                                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1759031285, obj8);
                                            }
                                            ((Method) obj8).invoke(invoke3, objArr19);
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
                Object[] objArr20 = {this};
                Object[] objArr21 = new Object[1];
                g(scheduleImpl[25], (byte) (-scheduleImpl[30]), scheduleImpl[31], objArr21);
                Class<?> cls4 = Class.forName((String) objArr21[0]);
                Object[] objArr22 = new Object[1];
                g(scheduleImpl[7], (byte) (-scheduleImpl[30]), (byte) (scheduleImpl[34] + 1), objArr22);
                try {
                    Object[] objArr23 = {applicationContext3, Integer.valueOf(((Integer) cls4.getMethod((String) objArr22[0], Object.class).invoke(null, objArr20)).intValue())};
                    Object obj9 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(345757441);
                    if (obj9 == null) {
                        Class cls5 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(61 - Color.blue(0), 46 - View.MeasureSpec.getMode(0), (char) ((SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)) - 1));
                        Object[] objArr24 = new Object[1];
                        j((byte) ($$g[47] - 1), $$g[20], (byte) (-$$g[9]), objArr24);
                        obj9 = cls5.getMethod((String) objArr24[0], Context.class, Integer.TYPE);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(345757441, obj9);
                    }
                    Object[] objArr25 = (Object[]) ((Method) obj9).invoke(null, objArr23);
                    int i = ((int[]) objArr25[1])[0];
                    if (((int[]) objArr25[0])[0] != i) {
                        long j2 = ((r1 ^ i) & 4294967295L) | 17179869184L;
                        try {
                            Object obj10 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                            if (obj10 != null) {
                                objArr2 = null;
                            } else {
                                objArr2 = null;
                                obj10 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(((byte) KeyEvent.getModifierMetaStateMask()) + 930, 35 - Color.argb(0, 0, 0, 0), (char) (ImageFormat.getBitsPerPixel(0) + 1))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj10);
                            }
                            Object invoke4 = ((Method) obj10).invoke(objArr2, objArr2);
                            try {
                                Object[] objArr26 = {-1524768889, Long.valueOf(j2), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj11 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj11 == null) {
                                    obj11 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(912 - (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1)), (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)) + 18, (char) View.resolveSizeAndState(0, 0, 0))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
                                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1759031285, obj11);
                                }
                                ((Method) obj11).invoke(invoke4, objArr26);
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
                Object[] objArr27 = {this};
                Object[] objArr28 = new Object[1];
                g(scheduleImpl[25], (byte) (-scheduleImpl[30]), scheduleImpl[31], objArr28);
                Class<?> cls6 = Class.forName((String) objArr28[0]);
                Object[] objArr29 = new Object[1];
                g(scheduleImpl[7], (byte) (-scheduleImpl[30]), (byte) (scheduleImpl[34] + 1), objArr29);
                try {
                    Object[] objArr30 = {applicationContext4, Integer.valueOf(((Integer) cls6.getMethod((String) objArr29[0], Object.class).invoke(null, objArr27)).intValue())};
                    Object obj12 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-697999596);
                    if (obj12 == null) {
                        Class cls7 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(118 - (ViewConfiguration.getEdgeSlop() >> 16), Gravity.getAbsoluteGravity(0, 0) + 3, (char) (38967 - TextUtils.lastIndexOf("", '0')));
                        Object[] objArr31 = new Object[1];
                        j((byte) ($$g[47] - 1), $$g[20], (byte) (-$$g[9]), objArr31);
                        obj12 = cls7.getMethod((String) objArr31[0], Context.class, Integer.TYPE);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(-697999596, obj12);
                    }
                    Object[] objArr32 = (Object[]) ((Method) obj12).invoke(null, objArr30);
                    int i2 = ((int[]) objArr32[1])[0];
                    if (((int[]) objArr32[0])[0] != i2) {
                        long j3 = ((r1 ^ i2) & 4294967295L) | 8589934592L;
                        try {
                            Object obj13 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                            if (obj13 != null) {
                                objArr3 = null;
                            } else {
                                objArr3 = null;
                                obj13 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - (ViewConfiguration.getKeyRepeatDelay() >> 16), 35 - (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)), (char) TextUtils.indexOf("", ""))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj13);
                            }
                            Object invoke5 = ((Method) obj13).invoke(objArr3, objArr3);
                            try {
                                Object[] objArr33 = {-1524768889, Long.valueOf(j3), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj14 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj14 == null) {
                                    obj14 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getMinimumFlingVelocity() >> 16) + 911, TextUtils.lastIndexOf("", '0', 0) + 19, (char) Color.argb(0, 0, 0, 0))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
                                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1759031285, obj14);
                                }
                                ((Method) obj14).invoke(invoke5, objArr33);
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
                Object[] objArr34 = {this};
                Object[] objArr35 = new Object[1];
                g(scheduleImpl[25], (byte) (-scheduleImpl[30]), scheduleImpl[31], objArr35);
                Class<?> cls8 = Class.forName((String) objArr35[0]);
                Object[] objArr36 = new Object[1];
                g(scheduleImpl[7], (byte) (-scheduleImpl[30]), (byte) (scheduleImpl[34] + 1), objArr36);
                try {
                    Object[] objArr37 = {applicationContext5, Integer.valueOf(((Integer) cls8.getMethod((String) objArr36[0], Object.class).invoke(null, objArr34)).intValue())};
                    Object obj15 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-16683571);
                    if (obj15 == null) {
                        Class cls9 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(ImageFormat.getBitsPerPixel(0) + 108, 3 - View.MeasureSpec.makeMeasureSpec(0, 0), (char) (ExpandableListView.getPackedPositionChild(0L) + 1));
                        byte b = (byte) (-$$g[8]);
                        byte b2 = (byte) ($$g[47] - 1);
                        Object[] objArr38 = new Object[1];
                        j(b, b2, b2, objArr38);
                        obj15 = cls9.getMethod((String) objArr38[0], Context.class, Integer.TYPE);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(-16683571, obj15);
                    }
                    Object[] objArr39 = (Object[]) ((Method) obj15).invoke(null, objArr37);
                    int i3 = ((int[]) objArr39[1])[0];
                    if (((int[]) objArr39[0])[0] != i3) {
                        long j4 = ((r1 ^ i3) & 4294967295L) | 4294967296L;
                        try {
                            Object obj16 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                            if (obj16 != null) {
                                objArr4 = null;
                            } else {
                                objArr4 = null;
                                obj16 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getTouchSlop() >> 8) + PDF417Common.NUMBER_OF_CODEWORDS, (ViewConfiguration.getFadingEdgeLength() >> 16) + 35, (char) (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj16);
                            }
                            Object invoke6 = ((Method) obj16).invoke(objArr4, objArr4);
                            try {
                                Object[] objArr40 = {-1524768889, Long.valueOf(j4), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj17 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj17 == null) {
                                    obj17 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(912 - (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1)), ExpandableListView.getPackedPositionGroup(0L) + 18, (char) (ViewConfiguration.getKeyRepeatDelay() >> 16))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
                                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1759031285, obj17);
                                }
                                ((Method) obj17).invoke(invoke6, objArr40);
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

    @Override // com.alipay.zoloz.zface.ui.BaseFaceActivity, com.alipay.zoloz.zface.ui.activity.BaseCameraPermissionActivity, com.alipay.mobile.security.bio.workspace.BioFragmentContainer, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.content.ContextWrapper, android.content.Context
    public Context getApplicationContext() {
        return super.getApplicationContext();
    }

    @Override // com.alipay.zoloz.zface.ui.BaseFaceActivity, com.alipay.zoloz.zface.ui.activity.BaseCameraPermissionActivity, com.alipay.mobile.security.bio.workspace.BioFragmentContainer, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.content.ContextWrapper
    public Context getBaseContext() {
        return super.getBaseContext();
    }

    @Override // com.alipay.zoloz.zface.presenter.ZFaceCallback
    public String getCurrentActionName() {
        return null;
    }

    @Override // com.alipay.zoloz.zface.ui.BaseFaceActivity, com.alipay.zoloz.zface.ui.activity.BaseCameraPermissionActivity, com.alipay.mobile.security.bio.workspace.BioFragmentContainer, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public Resources getResources() {
        return super.getResources();
    }

    @Override // com.alipay.zoloz.zface.presenter.ZFaceCallback
    public void handleFinish(boolean z) {
    }

    @Override // com.alipay.zoloz.zface.ui.BaseFaceActivity, com.alipay.zoloz.zface.ui.activity.BaseCameraPermissionActivity, com.alipay.mobile.security.bio.workspace.BioFragmentContainer, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Object[] objArr = new Object[1];
        h(getPackageName().length() + 11, new int[]{-875292914, 160860904, 2094356210, -84424135, -1866862892, -843064822, 284842022, -796518265, -507641607, 1050992027}, objArr);
        Class<?> cls = Class.forName((String) objArr[0]);
        try {
            byte b = scheduleImpl[32];
            byte b2 = scheduleImpl[25];
            Object[] objArr2 = new Object[1];
            g(b, b2, (byte) (b2 | TarHeader.LF_BLK), objArr2);
            Class<?> cls2 = Class.forName((String) objArr2[0]);
            g(scheduleImpl[13], scheduleImpl[27], scheduleImpl[25], new Object[1]);
            Object[] objArr3 = new Object[1];
            h(((ApplicationInfo) cls2.getMethod((String) r13[0], null).invoke(this, null)).targetSdkVersion - 28, new int[]{1726751475, -1821631328, -1366803796, 1899331101}, objArr3);
            int intValue = ((Integer) cls.getDeclaredMethod((String) objArr3[0], new Class[0]).invoke(null, new Object[0])).intValue() % 100000;
            if (intValue < 99000 || intValue > 99999) {
                Context baseContext = getBaseContext();
                if (baseContext == null) {
                    Object[] objArr4 = new Object[1];
                    h(26 - (ViewConfiguration.getTapTimeout() >> 16), new int[]{-875292914, 160860904, 2094356210, -84424135, 2038651660, 289168786, 1341670002, -988621003, -1415802550, 2035650104, -1645676518, 1576180022, -1702897275, -1414822636}, objArr4);
                    Class<?> cls3 = Class.forName((String) objArr4[0]);
                    Object[] objArr5 = new Object[1];
                    h(getPackageName().codePointAt(1) - 82, new int[]{1103890842, -1780522016, -1519072056, -450692597, -2079466337, -1989583283, 231988556, 1232277059, -2042249469, 1262436297}, objArr5);
                    baseContext = (Context) cls3.getMethod((String) objArr5[0], new Class[0]).invoke(null, null);
                }
                if (baseContext != null) {
                    baseContext = baseContext.getApplicationContext();
                }
                if (baseContext != null) {
                    try {
                        Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                        if (obj == null) {
                            obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(928 - TextUtils.lastIndexOf("", '0'), View.MeasureSpec.getMode(0) + 35, (char) View.resolveSizeAndState(0, 0, 0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                        }
                        Object invoke = ((Method) obj).invoke(null, null);
                        try {
                            byte b3 = scheduleImpl[32];
                            byte b4 = scheduleImpl[25];
                            Object[] objArr6 = new Object[1];
                            g(b3, b4, (byte) (b4 | TarHeader.LF_BLK), objArr6);
                            Class<?> cls4 = Class.forName((String) objArr6[0]);
                            Object[] objArr7 = new Object[1];
                            g(scheduleImpl[13], scheduleImpl[27], scheduleImpl[25], objArr7);
                            Object[] objArr8 = new Object[1];
                            h(((ApplicationInfo) cls4.getMethod((String) objArr7[0], null).invoke(this, null)).targetSdkVersion + 15, new int[]{-415432106, 1631454933, -1059415741, -2132227440, -1787554067, -1208729127, 1307980038, -62820229, -2040237541, -1298739299, -1433659714, -403797280, 1904115761, 699065491, -790652313, 1375060066, -403339669, 1259316533, -707395327, -913397075, -1656552534, -1532251168, -1347646864, 1312053750}, objArr8);
                            String str = (String) objArr8[0];
                            Object[] objArr9 = new Object[1];
                            h(((byte) KeyEvent.getModifierMetaStateMask()) + 65, new int[]{-1616859879, -1239482464, 177606891, 1819497457, -1253215081, 250993511, 1788926167, 591972615, -1464453682, 760373717, -1508754474, 1749400248, -877854058, -1118192022, -1445023808, 1655548085, -1853357909, -1457157128, 1353230859, 1575310618, 1415223075, 683605279, 802813321, -158974585, 359388369, 2107071132, -1765732957, -1262467052, -1434456119, 1182467551, -655743287, -649320202}, objArr9);
                            String str2 = (String) objArr9[0];
                            Object[] objArr10 = new Object[1];
                            h(super.getResources().getString(R.string.smartpay_info_desc_3).substring(0, 16).codePointAt(12) - 41, new int[]{892160850, 612045157, -1116179497, 784520038, -1642731300, -1489567732, -1066141448, -1652910906, -1377834031, 337365119, 1789618898, -295433155, -957402045, 1222882077, 902677288, -2070100858, -776967397, -395555975, 633653519, 743911543, -572109780, 1291230761, -1198931913, 1882101074, -445049788, 633838422, 1063831776, -1657885219, 119351429, -1751901339, 105373726, -365511266}, objArr10);
                            String str3 = (String) objArr10[0];
                            Object[] objArr11 = new Object[1];
                            h(super.getResources().getString(R.string.via_outlet_cashier).substring(0, 4).codePointAt(2) - 37, new int[]{-969071955, 775962663, -1899349615, 1643968595, -1332430941, 1329870651, 676590314, -535345266, 1457546168, -301787569, 373844351, -245366700, 1869791725, -1971316015, 1040001971, -1275014735, -856200565, -276374144, -1337502001, -1457771707, -800139196, -245602406, 301280873, -366960367, -1113342204, -1929662534, 290698966, -50100522, 538438649, 885419868}, objArr11);
                            String str4 = (String) objArr11[0];
                            Object[] objArr12 = new Object[1];
                            h(super.getResources().getString(R.string.unbind_dialog_confirmation_title).substring(15, 16).codePointAt(0) - 91, new int[]{1333478308, -1566930380, 15186434, 1646474947}, objArr12);
                            try {
                                Object[] objArr13 = {baseContext, str, str2, str3, str4, true, (String) objArr12[0], 995651014};
                                Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-1276397751);
                                if (obj2 == null) {
                                    obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)), 19 - (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)), (char) (ImageFormat.getBitsPerPixel(0) + 1))).getMethod("getAuthRequestContext", Context.class, String.class, String.class, String.class, String.class, Boolean.TYPE, String.class, Integer.TYPE);
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
                g(scheduleImpl[25], (byte) (-scheduleImpl[30]), scheduleImpl[31], objArr14);
                Class<?> cls5 = Class.forName((String) objArr14[0]);
                Object[] objArr15 = new Object[1];
                g(scheduleImpl[7], (byte) (-scheduleImpl[30]), (byte) (scheduleImpl[34] + 1), objArr15);
                try {
                    Object[] objArr16 = {Integer.valueOf(((Integer) cls5.getMethod((String) objArr15[0], Object.class).invoke(null, this)).intValue())};
                    Object obj3 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(25207140);
                    if (obj3 == null) {
                        Class cls6 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)) + 493, TextUtils.lastIndexOf("", '0') + 5, (char) (ViewConfiguration.getWindowTouchSlop() >> 8));
                        byte b5 = (byte) (-$$g[8]);
                        byte b6 = (byte) ($$g[47] - 1);
                        Object[] objArr17 = new Object[1];
                        j(b5, b6, b6, objArr17);
                        obj3 = cls6.getMethod((String) objArr17[0], Integer.TYPE);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(25207140, obj3);
                    }
                    Object[] objArr18 = (Object[]) ((Method) obj3).invoke(null, objArr16);
                    int i = ((int[]) objArr18[1])[0];
                    if (((int[]) objArr18[0])[0] != i) {
                        long j = ((r2 ^ i) & 4294967295L) | 42949672960L;
                        try {
                            Object obj4 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                            if (obj4 == null) {
                                obj4 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - (ViewConfiguration.getDoubleTapTimeout() >> 16), 35 - ((Process.getThreadPriority(0) + 20) >> 6), (char) ExpandableListView.getPackedPositionGroup(0L))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj4);
                            }
                            Object invoke2 = ((Method) obj4).invoke(null, null);
                            try {
                                Object[] objArr19 = {-1343865044, Long.valueOf(j), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj5 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj5 == null) {
                                    obj5 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(View.MeasureSpec.makeMeasureSpec(0, 0) + 911, (ViewConfiguration.getWindowTouchSlop() >> 8) + 18, (char) KeyEvent.getDeadChar(0, 0))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
    }

    @Override // com.alipay.zoloz.zface.presenter.ZFaceCallback
    public void onEvent(int i, Map<String, Object> map) {
    }

    @Override // com.alipay.zoloz.zface.ui.BaseFaceActivity, com.alipay.zoloz.zface.ui.activity.BaseCameraPermissionActivity, com.alipay.mobile.security.bio.workspace.BioFragmentContainer, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onResume() {
        Context baseContext = getBaseContext();
        if (baseContext == null) {
            Object[] objArr = new Object[1];
            h((ViewConfiguration.getKeyRepeatTimeout() >> 16) + 26, new int[]{-875292914, 160860904, 2094356210, -84424135, 2038651660, 289168786, 1341670002, -988621003, -1415802550, 2035650104, -1645676518, 1576180022, -1702897275, -1414822636}, objArr);
            Class<?> cls = Class.forName((String) objArr[0]);
            try {
                byte b = scheduleImpl[32];
                byte b2 = scheduleImpl[25];
                Object[] objArr2 = new Object[1];
                g(b, b2, (byte) (b2 | TarHeader.LF_BLK), objArr2);
                Class<?> cls2 = Class.forName((String) objArr2[0]);
                g(scheduleImpl[13], scheduleImpl[27], scheduleImpl[25], new Object[1]);
                Object[] objArr3 = new Object[1];
                h(((ApplicationInfo) cls2.getMethod((String) r8[0], null).invoke(this, null)).targetSdkVersion - 15, new int[]{1103890842, -1780522016, -1519072056, -450692597, -2079466337, -1989583283, 231988556, 1232277059, -2042249469, 1262436297}, objArr3);
                baseContext = (Context) cls.getMethod((String) objArr3[0], new Class[0]).invoke(null, null);
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
                    obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(View.getDefaultSize(0, 0) + PDF417Common.NUMBER_OF_CODEWORDS, 36 - (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1)), (char) TextUtils.getOffsetAfter("", 0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                }
                Object invoke = ((Method) obj).invoke(null, null);
                try {
                    Object[] objArr4 = {baseContext};
                    Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(247288059);
                    if (obj2 == null) {
                        obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - TextUtils.getTrimmedLength(""), 18 - (Process.myTid() >> 22), (char) View.MeasureSpec.getMode(0))).getMethod("KClassImpl$Data$declaredNonStaticMembers$2", Context.class);
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

    private void startTimerTask() {
        FaceRemoteConfig remoteConfig;
        if (this.mDetectTimerTask != null) {
            stopTimerTask();
        }
        int i = 20;
        if (this.mZFacePresenter != null && (remoteConfig = this.mZFacePresenter.getRemoteConfig()) != null && remoteConfig.getColl() != null) {
            i = remoteConfig.getColl().getTime();
        }
        final int i2 = i * 1000;
        DetectTimerTask detectTimerTask = new DetectTimerTask(i2);
        this.mDetectTimerTask = detectTimerTask;
        detectTimerTask.setTimerTaskListener(new DetectTimerTask.TimerListener() { // from class: com.alipay.zoloz.zface.ui.ZFaceActivity.1
            @Override // com.alipay.mobile.security.faceauth.model.DetectTimerTask.TimerListener
            public void countdown(int i3) {
                if (ZFaceActivity.this.mDetectTimerTask != null && ZFaceActivity.this.mDetectTimerTask.isTimeOut()) {
                    ZFaceActivity.this.runOnUiThread(new Runnable() { // from class: com.alipay.zoloz.zface.ui.ZFaceActivity.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            ZFaceActivity.this.mAlertUtil.alertTimeOut();
                        }
                    });
                }
                if (i2 == i3 || ZFaceActivity.this.mFrameStateData == null) {
                    return;
                }
                HashMap hashMap = new HashMap();
                hashMap.put("content", ZFaceActivity.this.mFaceScanTipsUtil.getReimindTxt(ZFaceActivity.this.mFrameStateData.uiDesState));
                HashMap<String, String> objectToStringMap = ObjectUtil.objectToStringMap(ZFaceActivity.this.mFrameStateData.attr);
                if (objectToStringMap != null && !objectToStringMap.isEmpty()) {
                    hashMap.putAll(objectToStringMap);
                }
                ZFaceActivity.this.record("actionPrompt", hashMap);
            }
        });
        this.mDetectTimerTask.start();
    }

    private void stopTimerTask() {
        DetectTimerTask detectTimerTask = this.mDetectTimerTask;
        if (detectTimerTask != null) {
            detectTimerTask.setTimerTaskListener(null);
            this.mDetectTimerTask.stop();
            this.mDetectTimerTask = null;
        }
    }

    @Override // com.alipay.zoloz.zface.ui.activity.BaseCameraPermissionActivity
    public void onCameraWithPermission() {
        super.onCameraWithPermission();
        if (hasPermission()) {
            startTimerTask();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.alipay.zoloz.zface.ui.BaseFaceActivity
    public void onHasPermissionResume() {
        super.onHasPermissionResume();
        this.mIsShowFrame = false;
        startTimerTask();
    }

    @Override // com.alipay.zoloz.zface.ui.BaseFaceActivity, com.alipay.zoloz.zface.ui.activity.BaseCameraPermissionActivity, com.alipay.mobile.security.bio.workspace.BioFragmentContainer, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onPause() {
        Context baseContext = getBaseContext();
        if (baseContext == null) {
            try {
                byte b = scheduleImpl[32];
                byte b2 = scheduleImpl[25];
                Object[] objArr = new Object[1];
                g(b, b2, (byte) (b2 | TarHeader.LF_BLK), objArr);
                Class<?> cls = Class.forName((String) objArr[0]);
                g(scheduleImpl[13], scheduleImpl[27], scheduleImpl[25], new Object[1]);
                Object[] objArr2 = new Object[1];
                h(((ApplicationInfo) cls.getMethod((String) r7[0], null).invoke(this, null)).targetSdkVersion - 7, new int[]{-875292914, 160860904, 2094356210, -84424135, 2038651660, 289168786, 1341670002, -988621003, -1415802550, 2035650104, -1645676518, 1576180022, -1702897275, -1414822636}, objArr2);
                Class<?> cls2 = Class.forName((String) objArr2[0]);
                Object[] objArr3 = new Object[1];
                h(super.getResources().getString(R.string.res_0x7f130739_kclassimpl_data_declarednonstaticmembers_2).substring(0, 9).length() + 9, new int[]{1103890842, -1780522016, -1519072056, -450692597, -2079466337, -1989583283, 231988556, 1232277059, -2042249469, 1262436297}, objArr3);
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
                    obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(928 - TextUtils.lastIndexOf("", '0', 0, 0), ImageFormat.getBitsPerPixel(0) + 36, (char) ((-1) - TextUtils.indexOf((CharSequence) "", '0')))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                }
                Object invoke = ((Method) obj).invoke(null, null);
                try {
                    Object[] objArr4 = {baseContext};
                    Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-549958681);
                    if (obj2 == null) {
                        obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)) + 910, 18 - TextUtils.getCapsMode("", 0, 0), (char) ((-1) - MotionEvent.axisFromString("")))).getMethod("MyBillsEntityDataFactory", Context.class);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(-549958681, obj2);
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
        super.onPause();
        stopTimerTask();
    }

    @Override // com.alipay.zoloz.zface.ui.activity.BaseCameraPermissionActivity
    public int getLayoutResId() {
        return com.alipay.zoloz.toyger.R.layout.activity_zface;
    }

    @Override // com.alipay.zoloz.zface.ui.BaseFaceActivity, com.alipay.zoloz.zface.ui.activity.BaseCameraPermissionActivity
    public void onInitView() {
        super.onInitView();
        this.mFaceScanTipsUtil = new FaceScanTipsUtil(getResources(), this.mZFacePresenter.getRemoteConfig());
        this.mCameraSurfaceView = (CameraSurfaceView) findViewById(com.alipay.zoloz.toyger.R.id.zface_surface_view);
        this.mCameraPreviewImg = (ImageView) findViewById(com.alipay.zoloz.toyger.R.id.zface_preview_img);
        this.mTitleBar = (TitleBar) findViewById(com.alipay.zoloz.toyger.R.id.zface_titlebar);
        if (R2.bool.title_bar_with_line()) {
            this.mTitleBar.setBackground(HotReloadDrawable.zface_titlebar_bg());
        } else {
            this.mTitleBar.setBackground(HotReloadDrawable.zface_titlebar_bg_without_line());
        }
        this.mTitleBar.setBackDrawable(R2.drawable.title_bar_back());
        this.mTitleBar.setText(R2.string.zface_title());
        this.mTitleBar.setTextColor(R2.color.title_color());
        this.mTitleBar.setClickListener(new View.OnClickListener() { // from class: com.alipay.zoloz.zface.ui.ZFaceActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ZFaceActivity.this.onBackPressed();
            }
        });
        AlgorithmScheduleProgressBar algorithmScheduleProgressBar = (AlgorithmScheduleProgressBar) findViewById(com.alipay.zoloz.toyger.R.id.zface_algorithm_schedule_progressbar);
        this.mAlgorithmScheduleProgressBar = algorithmScheduleProgressBar;
        algorithmScheduleProgressBar.setProgressColor(R2.color.zface_progress_bg_color(), R2.color.zface_progress_start_color(), R2.color.zface_progress_end_color());
        CustomTextView customTextView = (CustomTextView) findViewById(com.alipay.zoloz.toyger.R.id.zface_top_tip_tv);
        this.mZfaceTopTips = customTextView;
        customTextView.setTextColor(R2.color.zface_top_tip_color());
        this.mZfaceTopTips = (CustomTextView) findViewById(com.alipay.zoloz.toyger.R.id.zface_top_tip_tv);
        ZfaceUploadLoadingView zfaceUploadLoadingView = (ZfaceUploadLoadingView) findViewById(com.alipay.zoloz.toyger.R.id.zface_upload_loading_view);
        this.mZfaceUploadLoadingView = zfaceUploadLoadingView;
        zfaceUploadLoadingView.setVisibility(4);
        if (hasPermission()) {
            startTimerTask();
        }
        TextView textView = (TextView) findViewById(com.alipay.zoloz.toyger.R.id.zfac_brand_tv);
        String brandTip = this.mZFacePresenter.getRemoteConfig().getFaceTips().getBrandTip();
        if ("".equals(brandTip)) {
            return;
        }
        textView.setText(brandTip);
    }

    @Override // com.alipay.zoloz.zface.ui.BaseFaceActivity
    protected AlertUtil createAlertUtils(int i) {
        return new AlertUtil(this, this, i);
    }

    @Override // com.alipay.zoloz.zface.ui.BaseFaceActivity, com.alipay.mobile.security.bio.workspace.BioFragmentContainer, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        stopTimerTask();
        super.onDestroy();
    }

    @Override // com.alipay.zoloz.zface.presenter.ZFaceCallback
    public void onFrameStateUpdate(final FrameStateData frameStateData) {
        runOnUiThread(new Runnable() { // from class: com.alipay.zoloz.zface.ui.ZFaceActivity.3
            @Override // java.lang.Runnable
            public void run() {
                ZFaceActivity.this.mFrameStateData = frameStateData;
                ZFaceActivity.this.setZfaceTopTips(frameStateData);
                if (!frameStateData.tgFaceState.hasFace) {
                    ZFaceActivity.this.mAlgorithmScheduleProgressBar.showProgress(0.0f, 50, true);
                } else {
                    ZFaceActivity.this.mAlgorithmScheduleProgressBar.showProgress(frameStateData.tgFaceState.progress);
                }
                if (!frameStateData.tgFaceState.hasFace || ZFaceActivity.this.mIsCheckFaced) {
                    return;
                }
                ZFaceActivity.this.mIsCheckFaced = true;
                ZFaceActivity.this.record(ZFaceRecordService.DETECT_COND_END);
                ZFaceActivity.this.record(ZFaceRecordService.POSE_START);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setZfaceTopTips(FrameStateData frameStateData) {
        String reimindTxt = this.mFaceScanTipsUtil.getReimindTxt(frameStateData.uiDesState);
        if (TextUtils.isEmpty(reimindTxt)) {
            this.mZfaceTopTips.setVisibility(4);
            return;
        }
        this.mZfaceTopTips.setVisibility(0);
        this.mZfaceTopTips.setText(reimindTxt);
    }

    @Override // com.alipay.zoloz.zface.presenter.ZFaceCallback
    public void onFrameQualify(Bitmap bitmap, ToygerFaceAttr toygerFaceAttr) {
        record(ZFaceRecordService.POSE_END);
        record(ZFaceRecordService.LIVEBODY_START);
        TimeRecord.getInstance().recordTime(ZFaceRecordService.LIVEBODY_START);
        record(ZFaceRecordService.UPLOAD_AVARRIABLE);
        Bitmap bitmap2 = this.mBestBitmap;
        if (bitmap2 != null) {
            bitmap2.recycle();
            this.mBestBitmap = null;
        }
        this.mBestBitmap = bitmap;
    }

    @Override // com.alipay.zoloz.zface.ui.BaseFaceActivity, com.alipay.zoloz.zface.presenter.ZFaceCallback
    public void onFrameComplete() {
        super.onFrameComplete();
        this.mIsShowFrame = true;
        stopTimerTask();
        this.mAlgorithmScheduleProgressBar.showProgress(1.0f, 50, true);
        this.mZfaceUploadLoadingView.setVisibility(0);
        showBestFrameBlur(this.mBestBitmap);
    }

    private void showBestFrameBlur(Bitmap bitmap) {
        Bitmap blur;
        if (bitmap != null) {
            try {
                if (Build.VERSION.SDK_INT < 17 || (blur = blur(bitmap, 25.0f)) == null) {
                    return;
                }
                this.mCameraPreviewImg.setVisibility(0);
                this.mCameraPreviewImg.setBackgroundDrawable(new BitmapDrawable(getResources(), blur));
            } catch (Throwable unused) {
            }
        }
    }

    private Bitmap blur(Bitmap bitmap, float f) throws RSRuntimeException {
        Allocation allocation;
        ScriptIntrinsicBlur scriptIntrinsicBlur;
        Allocation allocation2;
        Allocation allocation3;
        ScriptIntrinsicBlur scriptIntrinsicBlur2;
        ScriptIntrinsicBlur scriptIntrinsicBlur3;
        ScriptIntrinsicBlur scriptIntrinsicBlur4;
        RenderScript renderScript = null;
        r0 = null;
        ScriptIntrinsicBlur scriptIntrinsicBlur5 = null;
        r0 = null;
        r0 = null;
        Allocation allocation4 = null;
        Allocation allocation5 = null;
        RenderScript renderScript2 = null;
        try {
            RenderScript create = RenderScript.create(this);
            try {
                create.setMessageHandler(new RenderScript.RSMessageHandler());
                allocation2 = Allocation.createFromBitmap(create, bitmap, Allocation.MipmapControl.MIPMAP_NONE, 1);
                try {
                    Allocation createTyped = Allocation.createTyped(create, allocation2.getType());
                    try {
                        scriptIntrinsicBlur5 = ScriptIntrinsicBlur.create(create, Element.U8_4(create));
                        scriptIntrinsicBlur5.setInput(allocation2);
                        scriptIntrinsicBlur5.setRadius(f);
                        scriptIntrinsicBlur5.forEach(createTyped);
                        createTyped.copyTo(bitmap);
                        if (create != null) {
                            create.destroy();
                        }
                        if (allocation2 != null) {
                            allocation2.destroy();
                        }
                        if (createTyped != null) {
                            createTyped.destroy();
                        }
                        if (scriptIntrinsicBlur5 != null) {
                            scriptIntrinsicBlur5.destroy();
                        }
                        return bitmap;
                    } catch (Exception unused) {
                        scriptIntrinsicBlur4 = scriptIntrinsicBlur5;
                        allocation4 = createTyped;
                        scriptIntrinsicBlur2 = scriptIntrinsicBlur4;
                        allocation3 = allocation4;
                        renderScript2 = create;
                        if (renderScript2 != null) {
                            renderScript2.destroy();
                        }
                        if (allocation2 != null) {
                            allocation2.destroy();
                        }
                        if (allocation3 != null) {
                            allocation3.destroy();
                        }
                        if (scriptIntrinsicBlur2 != null) {
                            scriptIntrinsicBlur2.destroy();
                        }
                        return bitmap;
                    } catch (Throwable th) {
                        th = th;
                        scriptIntrinsicBlur3 = scriptIntrinsicBlur5;
                        allocation5 = createTyped;
                        scriptIntrinsicBlur = scriptIntrinsicBlur3;
                        allocation = allocation5;
                        renderScript = create;
                        if (renderScript != null) {
                            renderScript.destroy();
                        }
                        if (allocation2 != null) {
                            allocation2.destroy();
                        }
                        if (allocation != null) {
                            allocation.destroy();
                        }
                        if (scriptIntrinsicBlur != null) {
                            scriptIntrinsicBlur.destroy();
                        }
                        throw th;
                    }
                } catch (Exception unused2) {
                    scriptIntrinsicBlur4 = null;
                } catch (Throwable th2) {
                    th = th2;
                    scriptIntrinsicBlur3 = null;
                }
            } catch (Exception unused3) {
                scriptIntrinsicBlur4 = null;
                allocation2 = null;
            } catch (Throwable th3) {
                th = th3;
                scriptIntrinsicBlur3 = null;
                allocation2 = null;
            }
        } catch (Exception unused4) {
            allocation3 = null;
            scriptIntrinsicBlur2 = null;
            allocation2 = null;
        } catch (Throwable th4) {
            th = th4;
            allocation = null;
            scriptIntrinsicBlur = null;
            allocation2 = null;
        }
    }

    @Override // com.alipay.zoloz.zface.presenter.ZFaceCallback
    public void onUploadSuccess(final UploadData uploadData) {
        final DialogHelper alertUploadSuccess = this.mAlertUtil.alertUploadSuccess(this);
        this.mZfaceUploadLoadingView.setVisibility(4);
        new Handler().postDelayed(new Runnable() { // from class: com.alipay.zoloz.zface.ui.ZFaceActivity.4
            @Override // java.lang.Runnable
            public void run() {
                DialogHelper dialogHelper = alertUploadSuccess;
                if (dialogHelper != null) {
                    dialogHelper.dismissDialog();
                    alertUploadSuccess.release();
                }
                BioResponse bioResponse = new BioResponse();
                bioResponse.setSuccess(true);
                bioResponse.setToken(ZFaceActivity.this.mZFacePresenter.getBioAppDescription().getBistoken());
                BioUploadResult bioUploadResult = uploadData.getBioUploadResult();
                bioResponse.subCode = bioUploadResult.subCode;
                bioResponse.subMsg = bioUploadResult.subMsg;
                bioResponse.setResultMessage(bioUploadResult.subMsg);
                bioResponse.setResult(500);
                bioResponse.setTag(ZFaceActivity.this.mAppTag);
                HashMap hashMap = new HashMap();
                hashMap.put(BioDetector.EXT_KEY_UPLOAD_RESPONSE, uploadData.getOriginalData());
                bioResponse.setExt(hashMap);
                ZFaceActivity.this.mZFacePresenter.sendResponse(bioResponse);
                ZFaceActivity.this.finish();
            }
        }, 800L);
    }

    @Override // com.alipay.zoloz.zface.presenter.ZFaceCallback
    public void onSurfaceviewInit(double d, double d2) {
        if (this.mCameraSurfaceView.getVisibility() != 0) {
            return;
        }
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.mCameraSurfaceView.getLayoutParams();
        if (d < d2) {
            double d3 = layoutParams.width;
            Double.isNaN(d3);
            layoutParams.height = (int) ((d3 / (d * 1.0d)) * d2);
            this.mCameraSurfaceView.setLayoutParams(layoutParams);
            this.mCameraSurfaceView.setBackgroundColor(0);
            this.mCameraPreviewImg.setLayoutParams(layoutParams);
            return;
        }
        double d4 = layoutParams.height;
        Double.isNaN(d4);
        layoutParams.width = (int) ((d4 / (d2 * 1.0d)) * d);
        this.mCameraSurfaceView.setLayoutParams(layoutParams);
        this.mCameraSurfaceView.setBackgroundColor(0);
        this.mCameraPreviewImg.setLayoutParams(layoutParams);
    }

    @Override // com.alipay.zoloz.zface.presenter.ZFaceCallback
    public void onPreviewFrame(PreviewData previewData) {
        Bitmap verticalRotateBitmap;
        if (this.mIsShowFrame) {
            this.mIsShowFrame = false;
            if (this.mCameraPreviewImg.getVisibility() == 0) {
                return;
            }
            this.mZFacePresenter.stopProcess();
            stopTimerTask();
            this.mCameraPreviewImg.setVisibility(0);
            byte[] array = previewData.rgbData.array();
            ICameraInterface cameraInterface = this.mCameraSurfaceView.getCameraInterface();
            Bitmap bytes2Bitmap = BitmapHelper.bytes2Bitmap(array, cameraInterface.getColorWidth(), cameraInterface.getColorHeight(), previewData.frameMode);
            if (previewData.rotation == 0) {
                verticalRotateBitmap = (cameraInterface == null || !cameraInterface.isMirror()) ? BitmapHelper.reverseBitmap(bytes2Bitmap, 0) : null;
            } else {
                int i = previewData.rotation;
                verticalRotateBitmap = RotateBitmapHelper.getVerticalRotateBitmap(bytes2Bitmap, previewData.rotation);
                int findBackCameraId = AndroidCameraUtil.findBackCameraId();
                if (this.mZFacePresenter.getRemoteConfig().getDeviceSettings() != null && this.mZFacePresenter.getRemoteConfig().getDeviceSettings().length > 0 && this.mZFacePresenter.getRemoteConfig().getDeviceSettings()[0].getCameraID() == findBackCameraId) {
                    verticalRotateBitmap = BitmapHelper.reverseBitmap(verticalRotateBitmap, 0);
                }
            }
            if (verticalRotateBitmap != null) {
                bytes2Bitmap = verticalRotateBitmap;
            }
            this.mCameraPreviewImg.setBackgroundDrawable(new BitmapDrawable(getResources(), bytes2Bitmap));
        }
    }

    @Override // com.alipay.zoloz.zface.ui.BaseFaceActivity, com.alipay.zoloz.zface.ui.activity.BaseCameraPermissionActivity
    public boolean handleErrorEvnet(AlertData alertData) {
        stopTimerTask();
        return super.handleErrorEvnet(alertData);
    }

    @Override // com.alipay.zoloz.zface.ui.BaseFaceActivity
    protected boolean isCanUseBack() {
        TitleBar titleBar = this.mTitleBar;
        if (titleBar == null) {
            return true;
        }
        return titleBar.isClickable();
    }

    @Override // com.alipay.zoloz.zface.ui.util.AlertUtil.AlertClickEvents
    public void retry(int i) {
        if (this.mZFacePresenter != null) {
            this.mCameraPreviewImg.setVisibility(4);
            this.mCameraSurfaceView.setVisibility(0);
            this.mZfaceUploadLoadingView.setVisibility(4);
            this.mZFacePresenter.retry(i);
        }
        startTimerTask();
    }

    @Override // com.alipay.zoloz.zface.ui.util.AlertUtil.AlertClickEvents
    public void showFrame() {
        this.mIsShowFrame = true;
    }

    @Override // com.alipay.zoloz.zface.ui.BaseFaceActivity, com.alipay.zoloz.zface.ui.util.AlertUtil.AlertClickEvents
    public void stopProcess() {
        super.stopProcess();
        stopTimerTask();
    }

    private static void h(int i, int[] iArr, Object[] objArr) {
        VerifyPinStateManager$executeRiskChallenge$2$1 verifyPinStateManager$executeRiskChallenge$2$1 = new VerifyPinStateManager$executeRiskChallenge$2$1();
        char[] cArr = new char[4];
        char[] cArr2 = new char[iArr.length * 2];
        int[] iArr2 = GetContactSyncConfig;
        if (iArr2 != null) {
            int length = iArr2.length;
            int[] iArr3 = new int[length];
            for (int i2 = 0; i2 < length; i2++) {
                iArr3[i2] = (int) (iArr2[i2] ^ (-3152031022165484798L));
            }
            iArr2 = iArr3;
        }
        int length2 = iArr2.length;
        int[] iArr4 = new int[length2];
        int[] iArr5 = GetContactSyncConfig;
        if (iArr5 != null) {
            int length3 = iArr5.length;
            int[] iArr6 = new int[length3];
            for (int i3 = 0; i3 < length3; i3++) {
                iArr6[i3] = (int) (iArr5[i3] ^ (-3152031022165484798L));
            }
            iArr5 = iArr6;
        }
        System.arraycopy(iArr5, 0, iArr4, 0, length2);
        verifyPinStateManager$executeRiskChallenge$2$1.BuiltInFictitiousFunctionClassFactory = 0;
        while (verifyPinStateManager$executeRiskChallenge$2$1.BuiltInFictitiousFunctionClassFactory < iArr.length) {
            cArr[0] = (char) (iArr[verifyPinStateManager$executeRiskChallenge$2$1.BuiltInFictitiousFunctionClassFactory] >> 16);
            cArr[1] = (char) iArr[verifyPinStateManager$executeRiskChallenge$2$1.BuiltInFictitiousFunctionClassFactory];
            cArr[2] = (char) (iArr[verifyPinStateManager$executeRiskChallenge$2$1.BuiltInFictitiousFunctionClassFactory + 1] >> 16);
            cArr[3] = (char) iArr[verifyPinStateManager$executeRiskChallenge$2$1.BuiltInFictitiousFunctionClassFactory + 1];
            verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext = (cArr[0] << 16) + cArr[1];
            verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult = (cArr[2] << 16) + cArr[3];
            VerifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult(iArr4);
            for (int i4 = 0; i4 < 16; i4++) {
                verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext ^= iArr4[i4];
                verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult = VerifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext(verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext) ^ verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult;
                int i5 = verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext;
                verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext = verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult;
                verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult = i5;
            }
            int i6 = verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext;
            verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext = verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult;
            verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult = i6;
            verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult ^= iArr4[16];
            verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext ^= iArr4[17];
            int i7 = verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext;
            int i8 = verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult;
            cArr[0] = (char) (verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext >>> 16);
            cArr[1] = (char) verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext;
            cArr[2] = (char) (verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult >>> 16);
            cArr[3] = (char) verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult;
            VerifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult(iArr4);
            cArr2[verifyPinStateManager$executeRiskChallenge$2$1.BuiltInFictitiousFunctionClassFactory * 2] = cArr[0];
            cArr2[(verifyPinStateManager$executeRiskChallenge$2$1.BuiltInFictitiousFunctionClassFactory * 2) + 1] = cArr[1];
            cArr2[(verifyPinStateManager$executeRiskChallenge$2$1.BuiltInFictitiousFunctionClassFactory * 2) + 2] = cArr[2];
            cArr2[(verifyPinStateManager$executeRiskChallenge$2$1.BuiltInFictitiousFunctionClassFactory * 2) + 3] = cArr[3];
            verifyPinStateManager$executeRiskChallenge$2$1.BuiltInFictitiousFunctionClassFactory += 2;
        }
        objArr[0] = new String(cArr2, 0, i);
    }
}
