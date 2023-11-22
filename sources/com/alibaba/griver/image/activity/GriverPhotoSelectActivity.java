package com.alibaba.griver.image.activity;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.ImageFormat;
import android.graphics.PointF;
import android.graphics.drawable.Drawable;
import android.media.AudioTrack;
import android.media.ExifInterface;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Process;
import android.os.SystemClock;
import android.provider.MediaStore;
import android.telephony.cdma.CdmaCellLocation;
import android.text.AndroidCharacter;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.animation.AnimationUtils;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ExpandableListView;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.app.ActivityCompat;
import androidx.core.content.FileProvider;
import androidx.core.content.PermissionChecker;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.alibaba.griver.base.common.utils.ToastUtils;
import com.alibaba.griver.image.framework.api.GriverImageLoadExtension;
import com.alibaba.griver.image.photo.PhotoContext;
import com.alibaba.griver.image.photo.PhotoResolver;
import com.alibaba.griver.image.photo.adapter.BucketAdapter;
import com.alibaba.griver.image.photo.adapter.GridAdapter;
import com.alibaba.griver.image.photo.meta.BucketInfo;
import com.alibaba.griver.image.photo.meta.PhotoGrid;
import com.alibaba.griver.image.photo.meta.PhotoItem;
import com.alibaba.griver.image.photo.meta.PhotoParam;
import com.alibaba.griver.image.photo.utils.AnimationUtil;
import com.alibaba.griver.image.photo.utils.CommonUtils;
import com.alibaba.griver.image.photo.utils.ImageHelper;
import com.alibaba.griver.image.photo.utils.PhotoUtil;
import com.alibaba.griver.image.photo.widget.PhotoGridView;
import com.alibaba.wireless.security.SecExceptionCode;
import com.alipay.mobile.security.faceauth.api.AntDetector;
import com.alipay.multimedia.adjuster.api.APMSandboxProcessor;
import com.alipay.multimedia.adjuster.api.data.APMInsertReq;
import com.google.common.base.Ascii;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.google.zxing.pdf417.PDF417Common;
import id.dana.R;
import id.dana.onboarding.splash.LauncherActivity;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import o.SummaryVoucherView$$ExternalSyntheticLambda0;
import o.whenAvailable;

/* loaded from: classes6.dex */
public class GriverPhotoSelectActivity extends GriverMediaBaseActivity implements View.OnClickListener, AbsListView.OnScrollListener, AdapterView.OnItemClickListener, GridAdapter.OnGridListener, PhotoGridView.OnOverScrolledListener {
    public static final String ACTION_PHOTO_ADAPTER_CHANGE = "com.alipay.mobile.beehive.photo.ACTION_PHOTO_ADAPTER_CHANGE";
    public static final int CODE_EDIT_VIDEO = 1001;
    public static final int GRID_WIDTH = 60;
    public static final int REQUEST_CAMERA = 701;
    public static final int REQUEST_PREVIEW = 702;
    public static final String TAG = "GriverPhotoSelectActivity";
    private static String[] af;
    public static boolean enableGifDynamicPreview;
    public static boolean selectGif;
    private LinearLayout A;
    private Button B;
    private boolean C;
    private TextView D;
    private TextView E;
    private boolean F;
    private boolean G;
    private ImageView H;
    private int I;
    private PhotoItem J;
    private int L;
    private FrameLayout M;
    private boolean N;
    private LinkedHashSet<String> O;
    private TextView P;
    private boolean Q;
    private float S;
    private TextView T;
    private boolean U;
    private boolean V;
    private LinearLayout W;
    private CheckBox X;
    private int Y;
    private int Z;

    /* renamed from: a */
    private PhotoGridView f6557a;
    private String aa;
    private boolean ab;
    private View ac;
    private boolean ad;
    private int ae;
    private String ah;
    private boolean ai;
    private ListView b;
    private Button c;
    private TextView d;
    private TextView e;
    private PhotoResolver f;
    private String g;
    private PhotoContext h;
    private LinearLayout i;
    private GridAdapter j;
    private BucketAdapter k;
    private File l;
    private List<PhotoItem> m;
    private String n;

    /* renamed from: o */
    private String f6558o;
    private boolean p;
    private int q;
    private boolean r;
    private int s;
    private boolean t;
    private String u;
    private String v;
    private String w;
    private View x;
    private String y;
    private RelativeLayout z;
    public static final byte[] $$a = {16, -117, -56, -112, TarHeader.LF_CHR, -48, 46, 10, 7, 14, -39, TarHeader.LF_NORMAL, 13, -4, 18, 12, -46, 36, Ascii.SUB, -12, -20, 34, 9, Ascii.CAN, 2, 10, 14, 5, 22, -44, 59, 6, -5, -15, Ascii.SUB, 19, 11, -9, Ascii.NAK, 8, -42, TarHeader.LF_CHR, 6, 13, -8, Ascii.SUB, 3, -1, TarHeader.LF_NORMAL, -4, Ascii.EM, 7, -35, 43, 10, 3, -65, 39, 36, Ascii.SUB, -12, -54, 71, 8, 5, 16, -4, Ascii.CAN, -6, 6, -15, 40, 6, -20, 40, -12, Ascii.SUB, -4, 1, -15, Ascii.US, 15, -4, 10, Ascii.DC4, 8, -72, Ascii.NAK};
    public static final int $$b = 176;
    public static final byte[] BuiltInFictitiousFunctionClassFactory = {105, Ascii.NAK, -43, 101, 17, -6, 18, 1, -2, -1, -50, 57, 16, 3, 10, -11, 13, 10, -66, Ascii.EM, TarHeader.LF_NORMAL, 3, 10, -11, Ascii.ETB, 0, -1, 5, 13, 10, -7, 15, 9, -45, Ascii.GS, 22, -7, -33, TarHeader.LF_NORMAL, -7, 5, -5, Ascii.EM, -17, -47, 66, -7, 17, -3, -53, 41, 42, -2, 5, -11, 12, 2, 19, -47, TarHeader.LF_CHR, 4, 0, 1, -2, 2, Ascii.ETB, -7, 10, 3, -33, 41, -4, 13};
    public static final int getAuthRequestContext = 9;
    private static char[] MyBillsEntityDataFactory = {62255, 42392, 24154, 63252, 43457, 17087, 64378, 44136, 18145, 65349, 36944, 19190, 58268, 38009, 19773, 59363, 39101, 12549, 12999, 25707, 40847, 14059, 26670, 7304, 19007, 45565, 6323, 18022, 44312, 5341, 17359, 43336, 4321, 32681, 42287, 3080, 31698, 41613, 2120, 30495, 57016, 1133, 29496, 56029, 409, 28491, 54788, 15816, 27509, 62253, 42371, 24140, 63252, 43467, 17080, 64362, 44039, 18174, 65350, 36882, 19151, 58253, 38007, 19754, 59375, 39073, 12568, 62329, 42389, 24072, 63326, 43422, 17074, 64295, 44158, 18105, 65363, 36893, 19136, 58251, 37924, 19823, 59312, 39167, 12615, 60296, 40071, 13642, 60981, 33021, 14832, 53866, 33925, 15814, 54850, 36700, 8690, 55999, 29539, 9335, 57024, 30476, 10335, 49864, 31727, 11302, 50550, 32697, 4176, 51530, 25488, 5260, 52517, 26216, 6371, 62255, 42435, 24072, 63234, 43464, 17135, 64302, 44158, 18154, 65365, 36935, 19091, 58250, 37927, 19823, 59314, 39164, 12612, 60376, 40151, 13642, 61031, 32936, 14837, 53816, 34004, 15815, 54851, 36694, 8690, 56044, 29492, 9261, 56978, 30474, 10334, 49869, 31669, 11310, 50549, 32699, 4102, 51483, 25495, 5261, 52513, 26223, 6321, 45565, 27205, 7305, 46559, 28183, 1889, 47534, 21239, 2878, 48519, 22173, 3908, 41055, 23214, 62394, 42037, 26682, 16001, 50461, 27714, 13009, 55719, 24682, 14132, 56816, 25672, 2816, 53713, 30873, 3939, 54824, 31991, 1001, 43605, 28876, 1988, 44634, 30066, 7097, 41651, 18815, 8086, 42625, 19800, 5198, 47798, 16815, 59427, 48959, 17876, 60490, 45848, 22922, 57511, 46958, 24120, 58608, 35606, 21001, 63700, 36752, 22112, 64889, 33698, 10990, 61705, 34715, 11973, 62810, 39969, 8894, 51637, 36991, 9925, 52609, 37974, 15182, 49637, 26797, 16249, 56955, 35039, 29463, 55883, 33920, 28593, 54892, 33076, 27575, 53770, 48461, 26522, 52893, 47423, 24683, 51881, 46582, 7242, 50839, 45528, 6162, 50040, 44471, 5301, 65332, 43422, 4290, 64265, 41559, 3256, 63474, 24110, 2418, 62425, 23046, 1301, 61328, 22244, 302, 59444, 21170, 15643, 58442, 20180, 14810, 57381, 19300, 13758, 40160, 18271, 12748, 39117, 17217, 10788, 38054, 32749, 9782, 36997, 31703, 8712, 62327, 42456, 24074, 63304, 43420, 17127};
    private static long KClassImpl$Data$declaredNonStaticMembers$2 = 4120417526850561526L;
    private Handler K = new Handler(Looper.getMainLooper());
    private boolean R = false;
    private boolean ag = false;
    private Runnable aj = new Runnable() { // from class: com.alibaba.griver.image.activity.GriverPhotoSelectActivity.9
        {
            GriverPhotoSelectActivity.this = this;
        }

        @Override // java.lang.Runnable
        public void run() {
            GriverPhotoSelectActivity.this.D.setVisibility(8);
        }
    };

    /* JADX WARN: Removed duplicated region for block: B:20:0x001d  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0025  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:22:0x0025 -> B:23:0x0030). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void an(byte r6, short r7, short r8, java.lang.Object[] r9) {
        /*
            int r7 = r7 + 97
            int r6 = 23 - r6
            byte[] r0 = com.alibaba.griver.image.activity.GriverPhotoSelectActivity.BuiltInFictitiousFunctionClassFactory
            int r8 = 55 - r8
            byte[] r1 = new byte[r6]
            int r6 = r6 + (-1)
            r2 = 0
            if (r0 != 0) goto L15
            r3 = r1
            r4 = 0
            r1 = r0
            r0 = r9
            r9 = r8
            goto L30
        L15:
            r3 = 0
        L16:
            byte r4 = (byte) r7
            r1[r3] = r4
            int r4 = r3 + 1
            if (r3 != r6) goto L25
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            r9[r2] = r6
            return
        L25:
            int r8 = r8 + 1
            r3 = r0[r8]
            r5 = r8
            r8 = r7
            r7 = r3
            r3 = r1
            r1 = r0
            r0 = r9
            r9 = r5
        L30:
            int r8 = r8 + r7
            int r7 = r8 + (-4)
            r8 = r9
            r9 = r0
            r0 = r1
            r1 = r3
            r3 = r4
            goto L16
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.griver.image.activity.GriverPhotoSelectActivity.an(byte, short, short, java.lang.Object[]):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0020  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0028  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:22:0x0028 -> B:23:0x0030). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void ap(int r6, short r7, short r8, java.lang.Object[] r9) {
        /*
            int r8 = r8 * 2
            int r8 = 103 - r8
            byte[] r0 = com.alibaba.griver.image.activity.GriverPhotoSelectActivity.$$a
            int r7 = r7 * 3
            int r7 = 42 - r7
            int r6 = r6 + 4
            byte[] r1 = new byte[r7]
            int r7 = r7 + (-1)
            r2 = 0
            if (r0 != 0) goto L18
            r4 = r8
            r3 = 0
            r8 = r7
            r7 = r6
            goto L30
        L18:
            r3 = 0
        L19:
            byte r4 = (byte) r8
            r1[r3] = r4
            int r6 = r6 + 1
            if (r3 != r7) goto L28
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            r9[r2] = r6
            return
        L28:
            int r3 = r3 + 1
            r4 = r0[r6]
            r5 = r7
            r7 = r6
            r6 = r8
            r8 = r5
        L30:
            int r6 = r6 + r4
            int r6 = r6 + (-7)
            r5 = r8
            r8 = r6
            r6 = r7
            r7 = r5
            goto L19
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.griver.image.activity.GriverPhotoSelectActivity.ap(int, short, short, java.lang.Object[]):void");
    }

    public void j() {
    }

    private void s() {
    }

    @Override // com.alibaba.griver.image.activity.GriverMediaBaseActivity, android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper
    public void attachBaseContext(Context context) {
        Object[] objArr;
        Object[] objArr2;
        Object[] objArr3;
        Object[] objArr4;
        super.attachBaseContext(context);
        Object[] objArr5 = new Object[1];
        ao(18 - TextUtils.indexOf("", "", 0, 0), (-1) - TextUtils.indexOf((CharSequence) "", '0', 0, 0), (char) (KeyEvent.getMaxKeyCode() >> 16), objArr5);
        Class<?> cls = Class.forName((String) objArr5[0]);
        Object[] objArr6 = new Object[1];
        ao(AndroidCharacter.getMirror('0') - '+', (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)) + 18, (char) (49635 - Process.getGidForName("")), objArr6);
        int intValue = ((Integer) cls.getDeclaredMethod((String) objArr6[0], new Class[0]).invoke(null, new Object[0])).intValue() % 100000;
        if (intValue < 99000 || intValue > 99999) {
            Context applicationContext = context != null ? context.getApplicationContext() : context;
            if (applicationContext != null) {
                try {
                    Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                    if (obj == null) {
                        obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)) + PDF417Common.MAX_CODEWORDS_IN_BARCODE, 35 - (ViewConfiguration.getWindowTouchSlop() >> 8), (char) (ViewConfiguration.getScrollDefaultDelay() >> 16))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                    }
                    Object invoke = ((Method) obj).invoke(null, null);
                    Object[] objArr7 = new Object[1];
                    ao(48 - (ViewConfiguration.getEdgeSlop() >> 16), 67 - (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)), (char) TextUtils.getCapsMode("", 0, 0), objArr7);
                    String str = (String) objArr7[0];
                    Object[] objArr8 = new Object[1];
                    ao((TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)) + 64, 115 - KeyEvent.keyCodeFromString(""), (char) (1 - (ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1))), objArr8);
                    String str2 = (String) objArr8[0];
                    Object[] objArr9 = new Object[1];
                    ao(Drawable.resolveOpacity(0, 0) + 64, (Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1)) + 178, (char) (Color.argb(0, 0, 0, 0) + 39750), objArr9);
                    String str3 = (String) objArr9[0];
                    Object[] objArr10 = new Object[1];
                    ao(60 - (ViewConfiguration.getTouchSlop() >> 8), 243 - (CdmaCellLocation.convertQuartSecToDecDegrees(0) > FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 0 : -1)), (char) (View.MeasureSpec.getSize(0) + 11613), objArr10);
                    String str4 = (String) objArr10[0];
                    Object[] objArr11 = new Object[1];
                    ao(6 - (ViewConfiguration.getMaximumDrawingCacheSize() >> 24), 303 - TextUtils.getCapsMode("", 0, 0), (char) ExpandableListView.getPackedPositionGroup(0L), objArr11);
                    try {
                        Object[] objArr12 = {applicationContext, str, str2, str3, str4, true, (String) objArr11[0], 995651014};
                        Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-1276397751);
                        if (obj2 == null) {
                            obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - ((Process.getThreadPriority(0) + 20) >> 6), 19 - (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)), (char) ('0' - AndroidCharacter.getMirror('0')))).getMethod("getAuthRequestContext", Context.class, String.class, String.class, String.class, String.class, Boolean.TYPE, String.class, Integer.TYPE);
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
                an((byte) (-BuiltInFictitiousFunctionClassFactory[30]), (byte) getAuthRequestContext, BuiltInFictitiousFunctionClassFactory[31], objArr13);
                Class<?> cls2 = Class.forName((String) objArr13[0]);
                byte b = (byte) (-BuiltInFictitiousFunctionClassFactory[30]);
                byte b2 = (byte) (b + 1);
                Object[] objArr14 = new Object[1];
                an(b, b2, (byte) (b2 | 22), objArr14);
                try {
                    Object[] objArr15 = {applicationContext2, Integer.valueOf(((Integer) cls2.getMethod((String) objArr14[0], Object.class).invoke(null, this)).intValue())};
                    Object obj3 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1691739267);
                    if (obj3 == null) {
                        Class cls3 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(KeyEvent.getDeadChar(0, 0) + 55, 3 - View.resolveSizeAndState(0, 0, 0), (char) (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)));
                        Object[] objArr16 = new Object[1];
                        ap($$a[47], $$a[31], $$a[12], objArr16);
                        obj3 = cls3.getMethod((String) objArr16[0], Context.class, Integer.TYPE);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1691739267, obj3);
                    }
                    Object invoke2 = ((Method) obj3).invoke(null, objArr15);
                    try {
                        Object obj4 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(40157535);
                        if (obj4 == null) {
                            obj4 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(AndroidCharacter.getMirror('0') + 752, 16 - (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1)), (char) (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)))).getMethod("getAuthRequestContext", null);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(40157535, obj4);
                        }
                        int intValue2 = ((Integer) ((Method) obj4).invoke(invoke2, null)).intValue();
                        try {
                            Object obj5 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1621779126);
                            if (obj5 == null) {
                                obj5 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)) + SecExceptionCode.SEC_ERROR_STA_KEY_ENC_UNKNOWN_ERROR, 16 - (ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)), (char) (ViewConfiguration.getMinimumFlingVelocity() >> 16))).getMethod("PlaceComponentResult", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1621779126, obj5);
                            }
                            if (((Integer) ((Method) obj5).invoke(invoke2, null)).intValue() != intValue2) {
                                ArrayList arrayList = new ArrayList();
                                try {
                                    Object[] objArr17 = {invoke2};
                                    Object obj6 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(658700871);
                                    if (obj6 == null) {
                                        obj6 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(815 - Color.alpha(0), 29 - (ViewConfiguration.getKeyRepeatDelay() >> 16), (char) (KeyEvent.getDeadChar(0, 0) + 57994))).getMethod("getAuthRequestContext", (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(799 - TextUtils.indexOf((CharSequence) "", '0', 0), 15 - (ViewConfiguration.getDoubleTapTimeout() >> 16), (char) (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1))));
                                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(658700871, obj6);
                                    }
                                    arrayList.add(((Method) obj6).invoke(null, objArr17));
                                    long j = ((r10 ^ intValue2) & 4294967295L) | 60129542144L;
                                    try {
                                        Object obj7 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                                        if (obj7 != null) {
                                            objArr = null;
                                        } else {
                                            objArr = null;
                                            obj7 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(MotionEvent.axisFromString("") + 930, View.MeasureSpec.getSize(0) + 35, (char) View.resolveSizeAndState(0, 0, 0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj7);
                                        }
                                        Object invoke3 = ((Method) obj7).invoke(objArr, objArr);
                                        try {
                                            Object[] objArr18 = {-1787801203, Long.valueOf(j), arrayList, LauncherActivity.getAuid()};
                                            Object obj8 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                            if (obj8 == null) {
                                                obj8 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(((byte) KeyEvent.getModifierMetaStateMask()) + 912, 18 - View.MeasureSpec.makeMeasureSpec(0, 0), (char) (ViewConfiguration.getLongPressTimeout() >> 16))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                an((byte) (-BuiltInFictitiousFunctionClassFactory[30]), (byte) getAuthRequestContext, BuiltInFictitiousFunctionClassFactory[31], objArr19);
                Class<?> cls4 = Class.forName((String) objArr19[0]);
                byte b3 = (byte) (-BuiltInFictitiousFunctionClassFactory[30]);
                byte b4 = (byte) (b3 + 1);
                Object[] objArr20 = new Object[1];
                an(b3, b4, (byte) (b4 | 22), objArr20);
                try {
                    Object[] objArr21 = {applicationContext3, Integer.valueOf(((Integer) cls4.getMethod((String) objArr20[0], Object.class).invoke(null, this)).intValue())};
                    Object obj9 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(345757441);
                    if (obj9 == null) {
                        Class cls5 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(61 - KeyEvent.keyCodeFromString(""), 46 - (ViewConfiguration.getTouchSlop() >> 8), (char) TextUtils.getCapsMode("", 0, 0));
                        Object[] objArr22 = new Object[1];
                        ap($$a[28], $$a[8], (byte) ($$a[78] - 1), objArr22);
                        obj9 = cls5.getMethod((String) objArr22[0], Context.class, Integer.TYPE);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(345757441, obj9);
                    }
                    Object[] objArr23 = (Object[]) ((Method) obj9).invoke(null, objArr21);
                    int i = ((int[]) objArr23[1])[0];
                    if (((int[]) objArr23[0])[0] != i) {
                        long j2 = ((r3 ^ i) & 4294967295L) | 17179869184L;
                        try {
                            Object obj10 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                            if (obj10 != null) {
                                objArr4 = null;
                            } else {
                                objArr4 = null;
                                obj10 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - (Process.myPid() >> 22), (ViewConfiguration.getWindowTouchSlop() >> 8) + 35, (char) (1 - (SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1))))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj10);
                            }
                            Object invoke4 = ((Method) obj10).invoke(objArr4, objArr4);
                            try {
                                Object[] objArr24 = {-1787801203, Long.valueOf(j2), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj11 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj11 == null) {
                                    obj11 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getKeyRepeatTimeout() >> 16) + 911, ExpandableListView.getPackedPositionGroup(0L) + 18, (char) (TextUtils.lastIndexOf("", '0', 0) + 1))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                an((byte) (-BuiltInFictitiousFunctionClassFactory[30]), (byte) getAuthRequestContext, BuiltInFictitiousFunctionClassFactory[31], objArr25);
                Class<?> cls6 = Class.forName((String) objArr25[0]);
                byte b5 = (byte) (-BuiltInFictitiousFunctionClassFactory[30]);
                byte b6 = (byte) (b5 + 1);
                Object[] objArr26 = new Object[1];
                an(b5, b6, (byte) (b6 | 22), objArr26);
                try {
                    Object[] objArr27 = {applicationContext4, Integer.valueOf(((Integer) cls6.getMethod((String) objArr26[0], Object.class).invoke(null, this)).intValue())};
                    Object obj12 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-697999596);
                    if (obj12 == null) {
                        Class cls7 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(118 - (KeyEvent.getMaxKeyCode() >> 16), Color.green(0) + 3, (char) (38967 - TextUtils.lastIndexOf("", '0')));
                        Object[] objArr28 = new Object[1];
                        ap($$a[28], $$a[8], (byte) ($$a[78] - 1), objArr28);
                        obj12 = cls7.getMethod((String) objArr28[0], Context.class, Integer.TYPE);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(-697999596, obj12);
                    }
                    Object[] objArr29 = (Object[]) ((Method) obj12).invoke(null, objArr27);
                    int i2 = ((int[]) objArr29[1])[0];
                    if (((int[]) objArr29[0])[0] != i2) {
                        long j3 = ((r3 ^ i2) & 4294967295L) | 8589934592L;
                        try {
                            Object obj13 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                            if (obj13 != null) {
                                objArr3 = null;
                            } else {
                                objArr3 = null;
                                obj13 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(TextUtils.indexOf((CharSequence) "", '0', 0, 0) + 930, 34 - TextUtils.indexOf((CharSequence) "", '0', 0, 0), (char) View.combineMeasuredStates(0, 0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj13);
                            }
                            Object invoke5 = ((Method) obj13).invoke(objArr3, objArr3);
                            try {
                                Object[] objArr30 = {-1787801203, Long.valueOf(j3), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj14 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj14 == null) {
                                    obj14 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - KeyEvent.getDeadChar(0, 0), ExpandableListView.getPackedPositionChild(0L) + 19, (char) (((byte) KeyEvent.getModifierMetaStateMask()) + 1))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                an((byte) (-BuiltInFictitiousFunctionClassFactory[30]), (byte) getAuthRequestContext, BuiltInFictitiousFunctionClassFactory[31], objArr31);
                Class<?> cls8 = Class.forName((String) objArr31[0]);
                byte b7 = (byte) (-BuiltInFictitiousFunctionClassFactory[30]);
                byte b8 = (byte) (b7 + 1);
                Object[] objArr32 = new Object[1];
                an(b7, b8, (byte) (b8 | 22), objArr32);
                try {
                    Object[] objArr33 = {applicationContext5, Integer.valueOf(((Integer) cls8.getMethod((String) objArr32[0], Object.class).invoke(null, this)).intValue())};
                    Object obj15 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-16683571);
                    if (obj15 == null) {
                        Class cls9 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)) + 107, TextUtils.indexOf("", "") + 3, (char) (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)));
                        Object[] objArr34 = new Object[1];
                        ap((byte) (-$$a[40]), (byte) ($$a[78] - 1), $$a[9], objArr34);
                        obj15 = cls9.getMethod((String) objArr34[0], Context.class, Integer.TYPE);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(-16683571, obj15);
                    }
                    Object[] objArr35 = (Object[]) ((Method) obj15).invoke(null, objArr33);
                    int i3 = ((int[]) objArr35[1])[0];
                    if (((int[]) objArr35[0])[0] != i3) {
                        long j4 = ((r3 ^ i3) & 4294967295L) | 4294967296L;
                        try {
                            Object obj16 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                            if (obj16 != null) {
                                objArr2 = null;
                            } else {
                                objArr2 = null;
                                obj16 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(928 - (ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)), (Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1)) + 34, (char) (ViewConfiguration.getMinimumFlingVelocity() >> 16))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj16);
                            }
                            Object invoke6 = ((Method) obj16).invoke(objArr2, objArr2);
                            try {
                                Object[] objArr36 = {-1787801203, Long.valueOf(j4), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj17 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj17 == null) {
                                    obj17 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - TextUtils.indexOf("", "", 0), 17 - ExpandableListView.getPackedPositionChild(0L), (char) TextUtils.getOffsetBefore("", 0))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
            ao(super.getResources().getString(R.string.tooltip_onboarding_mapview_desc_fourth).substring(39, 40).codePointAt(0) - 82, super.getResources().getString(R.string.insurance_description).substring(9, 10).length() + 22, (char) (super.getResources().getString(R.string.lbl_enter_phone_number_intro).substring(11, 13).codePointAt(1) + 61240), objArr);
            Class<?> cls = Class.forName((String) objArr[0]);
            Object[] objArr2 = new Object[1];
            ao(super.getResources().getString(R.string.share_feed_success_toast_msg).substring(17, 18).length() + 17, super.getResources().getString(R.string.voucher_available).substring(29, 30).length() + 48, (char) (super.getResources().getString(R.string.tooltip_dana_cicil_available_description).substring(0, 1).codePointAt(0) - 84), objArr2);
            baseContext = (Context) cls.getMethod((String) objArr2[0], new Class[0]).invoke(null, null);
        }
        if (baseContext != null) {
            baseContext = baseContext.getApplicationContext();
        }
        if (baseContext != null) {
            try {
                Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                if (obj == null) {
                    obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - (ViewConfiguration.getPressedStateDuration() >> 16), (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)) + 35, (char) ((-1) - TextUtils.lastIndexOf("", '0')))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                }
                Object invoke = ((Method) obj).invoke(null, null);
                try {
                    Object[] objArr3 = {baseContext};
                    Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-549958681);
                    if (obj2 == null) {
                        obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(View.combineMeasuredStates(0, 0) + 911, Color.red(0) + 18, (char) (ViewConfiguration.getLongPressTimeout() >> 16))).getMethod("MyBillsEntityDataFactory", Context.class);
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

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
    }

    @Override // com.alibaba.griver.image.activity.GriverMediaBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Bundle bundle2;
        Object[] objArr;
        try {
            byte b = BuiltInFictitiousFunctionClassFactory[25];
            byte b2 = b;
            Object[] objArr2 = new Object[1];
            an(b, b2, (byte) (b2 | TarHeader.LF_BLK), objArr2);
            Class<?> cls = Class.forName((String) objArr2[0]);
            an(BuiltInFictitiousFunctionClassFactory[27], (byte) (-BuiltInFictitiousFunctionClassFactory[5]), BuiltInFictitiousFunctionClassFactory[25], new Object[1]);
            Object[] objArr3 = new Object[1];
            ao(((ApplicationInfo) cls.getMethod((String) r10[0], null).invoke(this, null)).targetSdkVersion - 15, TextUtils.indexOf("", ""), (char) View.MeasureSpec.makeMeasureSpec(0, 0), objArr3);
            Class<?> cls2 = Class.forName((String) objArr3[0]);
            Object[] objArr4 = new Object[1];
            ao(5 - (Process.myTid() >> 22), super.getResources().getString(R.string.mybills_some_bills_paid).substring(13, 15).length() + 16, (char) (49636 - (ViewConfiguration.getTouchSlop() >> 8)), objArr4);
            int intValue = ((Integer) cls2.getDeclaredMethod((String) objArr4[0], new Class[0]).invoke(null, new Object[0])).intValue() % 100000;
            if (intValue < 99000 || intValue > 99999) {
                Context baseContext = getBaseContext();
                if (baseContext == null) {
                    Object[] objArr5 = new Object[1];
                    ao(getPackageName().codePointAt(1) - 74, super.getResources().getString(R.string.sending_gift).substring(9, 10).codePointAt(0) - 82, (char) (super.getResources().getString(R.string.text_tnc_gn).substring(8, 9).length() + 61350), objArr5);
                    Class<?> cls3 = Class.forName((String) objArr5[0]);
                    try {
                        byte b3 = BuiltInFictitiousFunctionClassFactory[25];
                        byte b4 = b3;
                        Object[] objArr6 = new Object[1];
                        an(b3, b4, (byte) (b4 | TarHeader.LF_BLK), objArr6);
                        Class<?> cls4 = Class.forName((String) objArr6[0]);
                        an(BuiltInFictitiousFunctionClassFactory[27], (byte) (-BuiltInFictitiousFunctionClassFactory[5]), BuiltInFictitiousFunctionClassFactory[25], new Object[1]);
                        Object[] objArr7 = new Object[1];
                        ao(((ApplicationInfo) cls4.getMethod((String) r11[0], null).invoke(this, null)).targetSdkVersion - 15, 49 - (CdmaCellLocation.convertQuartSecToDecDegrees(0) > FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 0 : -1)), (char) (ViewConfiguration.getFadingEdgeLength() >> 16), objArr7);
                        baseContext = (Context) cls3.getMethod((String) objArr7[0], new Class[0]).invoke(null, null);
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
                            obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)) + PDF417Common.MAX_CODEWORDS_IN_BARCODE, (Process.myTid() >> 22) + 35, (char) View.MeasureSpec.getMode(0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                        }
                        Object invoke = ((Method) obj).invoke(null, null);
                        Object[] objArr8 = new Object[1];
                        ao(TextUtils.indexOf((CharSequence) "", '0', 0, 0) + 49, 66 - ((byte) KeyEvent.getModifierMetaStateMask()), (char) (super.getResources().getString(R.string.share_feed_deleted_toast_msg).substring(17, 18).codePointAt(0) - 115), objArr8);
                        String str = (String) objArr8[0];
                        int packedPositionChild = ExpandableListView.getPackedPositionChild(0L) + 65;
                        int lastIndexOf = 114 - TextUtils.lastIndexOf("", '0', 0);
                        try {
                            byte b5 = BuiltInFictitiousFunctionClassFactory[25];
                            byte b6 = b5;
                            Object[] objArr9 = new Object[1];
                            an(b5, b6, (byte) (b6 | TarHeader.LF_BLK), objArr9);
                            Class<?> cls5 = Class.forName((String) objArr9[0]);
                            an(BuiltInFictitiousFunctionClassFactory[27], (byte) (-BuiltInFictitiousFunctionClassFactory[5]), BuiltInFictitiousFunctionClassFactory[25], new Object[1]);
                            Object[] objArr10 = new Object[1];
                            ao(packedPositionChild, lastIndexOf, (char) (((ApplicationInfo) cls5.getMethod((String) r8[0], null).invoke(this, null)).targetSdkVersion - 33), objArr10);
                            String str2 = (String) objArr10[0];
                            Object[] objArr11 = new Object[1];
                            ao(super.getResources().getString(R.string.text_below_3_character).substring(25, 28).codePointAt(2) - 33, getPackageName().length() + 172, (char) (getPackageName().length() + 39743), objArr11);
                            String str3 = (String) objArr11[0];
                            int codePointAt = getPackageName().codePointAt(6) - 37;
                            int combineMeasuredStates = 243 - View.combineMeasuredStates(0, 0);
                            try {
                                byte b7 = BuiltInFictitiousFunctionClassFactory[25];
                                byte b8 = b7;
                                Object[] objArr12 = new Object[1];
                                an(b7, b8, (byte) (b8 | TarHeader.LF_BLK), objArr12);
                                Class<?> cls6 = Class.forName((String) objArr12[0]);
                                Object[] objArr13 = new Object[1];
                                an(BuiltInFictitiousFunctionClassFactory[27], (byte) (-BuiltInFictitiousFunctionClassFactory[5]), BuiltInFictitiousFunctionClassFactory[25], objArr13);
                                Object[] objArr14 = new Object[1];
                                ao(codePointAt, combineMeasuredStates, (char) (((ApplicationInfo) cls6.getMethod((String) objArr13[0], null).invoke(this, null)).targetSdkVersion + 11580), objArr14);
                                String str4 = (String) objArr14[0];
                                try {
                                    byte b9 = BuiltInFictitiousFunctionClassFactory[25];
                                    byte b10 = b9;
                                    Object[] objArr15 = new Object[1];
                                    an(b9, b10, (byte) (b10 | TarHeader.LF_BLK), objArr15);
                                    Class<?> cls7 = Class.forName((String) objArr15[0]);
                                    an(BuiltInFictitiousFunctionClassFactory[27], (byte) (-BuiltInFictitiousFunctionClassFactory[5]), BuiltInFictitiousFunctionClassFactory[25], new Object[1]);
                                    Object[] objArr16 = new Object[1];
                                    ao(((ApplicationInfo) cls7.getMethod((String) r13[0], null).invoke(this, null)).targetSdkVersion - 27, super.getResources().getString(R.string.bank_card).substring(1, 2).codePointAt(0) + 206, (char) ((SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)) - 1), objArr16);
                                    try {
                                        Object[] objArr17 = {baseContext, str, str2, str3, str4, true, (String) objArr16[0], 995651014};
                                        Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-1276397751);
                                        if (obj2 == null) {
                                            obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(910 - ImageFormat.getBitsPerPixel(0), 18 - (ViewConfiguration.getLongPressTimeout() >> 16), (char) ExpandableListView.getPackedPositionType(0L))).getMethod("getAuthRequestContext", Context.class, String.class, String.class, String.class, String.class, Boolean.TYPE, String.class, Integer.TYPE);
                                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(-1276397751, obj2);
                                        }
                                        ((Method) obj2).invoke(invoke, objArr17);
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
                    } catch (Throwable th6) {
                        Throwable cause6 = th6.getCause();
                        if (cause6 == null) {
                            throw th6;
                        }
                        throw cause6;
                    }
                }
            }
            try {
                Object[] objArr18 = new Object[1];
                an((byte) (-BuiltInFictitiousFunctionClassFactory[30]), (byte) getAuthRequestContext, BuiltInFictitiousFunctionClassFactory[31], objArr18);
                Class<?> cls8 = Class.forName((String) objArr18[0]);
                byte b11 = (byte) (-BuiltInFictitiousFunctionClassFactory[30]);
                byte b12 = (byte) (b11 + 1);
                Object[] objArr19 = new Object[1];
                an(b11, b12, (byte) (b12 | 22), objArr19);
                try {
                    Object[] objArr20 = {Integer.valueOf(((Integer) cls8.getMethod((String) objArr19[0], Object.class).invoke(null, this)).intValue())};
                    Object obj3 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(25207140);
                    if (obj3 == null) {
                        Class cls9 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(494 - Color.alpha(0), 4 - Color.red(0), (char) (ViewConfiguration.getKeyRepeatTimeout() >> 16));
                        Object[] objArr21 = new Object[1];
                        ap((byte) (-$$a[40]), (byte) ($$a[78] - 1), $$a[9], objArr21);
                        obj3 = cls9.getMethod((String) objArr21[0], Integer.TYPE);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(25207140, obj3);
                    }
                    Object[] objArr22 = (Object[]) ((Method) obj3).invoke(null, objArr20);
                    int i = ((int[]) objArr22[1])[0];
                    if (((int[]) objArr22[0])[0] != i) {
                        long j = ((r2 ^ i) & 4294967295L) | 42949672960L;
                        try {
                            Object obj4 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                            if (obj4 != null) {
                                objArr = null;
                            } else {
                                objArr = null;
                                obj4 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(Color.red(0) + PDF417Common.NUMBER_OF_CODEWORDS, (Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1)) + 34, (char) ((-1) - ImageFormat.getBitsPerPixel(0)))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj4);
                            }
                            Object invoke2 = ((Method) obj4).invoke(objArr, objArr);
                            try {
                                Object[] objArr23 = {2022177306, Long.valueOf(j), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj5 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj5 == null) {
                                    obj5 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getPressedStateDuration() >> 16) + 911, 18 - (ViewConfiguration.getKeyRepeatTimeout() >> 16), (char) (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
                                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1759031285, obj5);
                                }
                                ((Method) obj5).invoke(invoke2, objArr23);
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
                    RVLogger.d("videoCompact", "version:6");
                    super.onCreate(bundle);
                    requestWindowFeature(1);
                    this.Q = false;
                    this.I = 0;
                    if (bundle == null) {
                        bundle2 = getIntent().getExtras();
                        if (bundle2 == null) {
                            finish();
                            return;
                        }
                    } else {
                        RVLogger.d(TAG, "initialize photo select with save instance.");
                        bundle2 = bundle;
                    }
                    setContentView(com.alibaba.griver.image.R.layout.griver_image_activity_photo_select);
                    f();
                    c(bundle2);
                    if (Build.VERSION.SDK_INT >= 33) {
                        if (this.ab) {
                            af = new String[]{"android.permission.READ_MEDIA_VIDEO"};
                        } else {
                            af = new String[]{"android.permission.READ_MEDIA_VIDEO", "android.permission.READ_MEDIA_IMAGES"};
                        }
                    } else {
                        af = new String[]{"android.permission.READ_EXTERNAL_STORAGE"};
                    }
                    a(bundle2);
                    b();
                    ((GriverImageLoadExtension) RVProxy.get(GriverImageLoadExtension.class)).init();
                } catch (Throwable th9) {
                    Throwable cause9 = th9.getCause();
                    if (cause9 == null) {
                        throw th9;
                    }
                    throw cause9;
                }
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

    private boolean a() {
        PackageManager packageManager = getPackageManager();
        for (String str : af) {
            if (packageManager.checkPermission(str, getPackageName()) != 0) {
                return false;
            }
        }
        return true;
    }

    private void b() {
        if (Build.VERSION.SDK_INT < 23 || a()) {
            return;
        }
        requestPermissions(af, 101);
    }

    private void a(Bundle bundle) {
        if (this.p) {
            PhotoItem photoItem = new PhotoItem();
            this.J = photoItem;
            photoItem.takePhoto = true;
        }
        if (TextUtils.isEmpty(this.f6558o)) {
            this.f6558o = getString(com.alibaba.griver.image.R.string.griver_image_preview);
        }
        if (TextUtils.isEmpty(this.u)) {
            this.u = getString(com.alibaba.griver.image.R.string.griver_image_max_message, Integer.valueOf(this.s));
        }
        if (TextUtils.isEmpty(this.n)) {
            this.n = getString(com.alibaba.griver.image.R.string.griver_image_send);
        }
        if (TextUtils.isEmpty(this.v)) {
            this.v = getString(com.alibaba.griver.image.R.string.griver_image_all_bucket);
            if (this.R) {
                this.v = getString(com.alibaba.griver.image.R.string.griver_image_all_bucket_with_video);
            }
        }
        this.E.setText(this.v);
        this.i.setVisibility(this.t ? 0 : 8);
        this.e.setText(this.f6558o);
        this.e.setVisibility((!this.r || this.s <= 1) ? 8 : 0);
        this.T.setVisibility(this.U ? 0 : 8);
        GridAdapter gridAdapter = new GridAdapter(this, null, this.F && this.s > 1);
        this.j = gridAdapter;
        gridAdapter.setGridListener(this);
        this.j.setEnableVideoEdit(this.V);
        this.f6557a.setAdapter((ListAdapter) this.j);
        this.z.setVisibility(this.F && this.s > 0 ? 0 : 8);
        this.c.setVisibility(this.F && this.s > 1 ? 0 : 8);
        this.h = PhotoContext.get(this.g);
        PhotoContext.remove(this.g);
        this.m = this.h.photoList;
        ArrayList<String> stringArrayList = bundle.getStringArrayList(PhotoParam.SELECTED_PHOTO_PATHS);
        if (stringArrayList != null && !stringArrayList.isEmpty()) {
            LinkedHashSet<String> linkedHashSet = new LinkedHashSet<>();
            this.O = linkedHashSet;
            linkedHashSet.addAll(stringArrayList);
        }
        this.w = getString(com.alibaba.griver.image.R.string.griver_image_all_bucket);
        if (this.R) {
            this.w = getString(com.alibaba.griver.image.R.string.griver_image_all_bucket_with_video);
        }
        this.d.setText(this.w);
        this.D.setVisibility(8);
        if (!this.F) {
            this.x.setVisibility(8);
        }
        this.B.setOnClickListener(this);
        this.B.setVisibility(this.G ? 0 : 8);
        ImageHelper.optimizeView(this.f6557a, null);
        this.f6557a.setOnOverScrolledListener(this);
        k();
        if (this.C) {
            p();
        }
        long currentTimeMillis = System.currentTimeMillis();
        RVLogger.d("PhotoDisplayLink", "updateViewsByConfig:###");
        c();
        h();
        StringBuilder sb = new StringBuilder();
        sb.append("initPhotoResolver cost time(ms) = ");
        sb.append(System.currentTimeMillis() - currentTimeMillis);
        RVLogger.d(TAG, sb.toString());
        b(bundle);
    }

    private void b(Bundle bundle) {
        this.W.setVisibility(this.ad ? 0 : 8);
        if (this.ad) {
            this.h.userOriginPhoto = bundle.getBoolean(PhotoParam.USE_ORIGIN_PHOTO, false);
            this.X.setChecked(this.h.userOriginPhoto);
            this.W.findViewById(com.alibaba.griver.image.R.id.tv_origin).setOnClickListener(new View.OnClickListener() { // from class: com.alibaba.griver.image.activity.GriverPhotoSelectActivity.1
                {
                    GriverPhotoSelectActivity.this = this;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    GriverPhotoSelectActivity.this.X.toggle();
                }
            });
        }
    }

    public static int readPictureDegree(String str) {
        int attributeInt;
        try {
            attributeInt = new ExifInterface(str).getAttributeInt("Orientation", 1);
        } catch (IOException unused) {
        }
        if (attributeInt != 3) {
            if (attributeInt != 6) {
                return attributeInt == 8 ? 270 : 0;
            }
            return 90;
        }
        return 180;
    }

    private void c() {
        RVLogger.d("PhotoDisplayLink", "initPhotoResolver:###");
        if (this.t && this.F && d()) {
            if (this.h.photoResolver == null) {
                i();
                e();
                this.i.setOnClickListener(this);
                return;
            }
            this.f = this.h.photoResolver;
            return;
        }
        this.t = false;
    }

    private boolean d() {
        List<PhotoItem> list = this.m;
        return list == null || list.isEmpty();
    }

    private void e() {
        RVLogger.d("PhotoDisplayLink", "callResolverToStartScan:###");
        this.ag = false;
        if (this.ab) {
            this.f.asyncScanPhotoAndVideo(false, true);
        } else {
            this.f.asyncScanPhotoAndVideo(true, this.R);
        }
        this.K.postDelayed(new Runnable() { // from class: com.alibaba.griver.image.activity.GriverPhotoSelectActivity.2
            {
                GriverPhotoSelectActivity.this = this;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (!GriverPhotoSelectActivity.this.ag && !GriverPhotoSelectActivity.this.isFinishing()) {
                    RVLogger.d(GriverPhotoSelectActivity.TAG, "Cost more than 1000ms ,display progressbar.");
                    GriverPhotoSelectActivity.this.ac.setVisibility(0);
                    return;
                }
                RVLogger.d(GriverPhotoSelectActivity.TAG, "Cost less than 1000ms.");
            }
        }, 1000L);
    }

    private void f() {
        this.W = (LinearLayout) findViewById(com.alibaba.griver.image.R.id.ll_select_original_photo);
        CheckBox checkBox = (CheckBox) findViewById(com.alibaba.griver.image.R.id.cb_origin);
        this.X = checkBox;
        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.alibaba.griver.image.activity.GriverPhotoSelectActivity.3
            {
                GriverPhotoSelectActivity.this = this;
            }

            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                if (GriverPhotoSelectActivity.this.h != null) {
                    GriverPhotoSelectActivity.this.h.userOriginPhoto = z;
                    GriverPhotoSelectActivity griverPhotoSelectActivity = GriverPhotoSelectActivity.this;
                    griverPhotoSelectActivity.N = griverPhotoSelectActivity.h.userOriginPhoto;
                }
            }
        });
        this.A = (LinearLayout) findViewById(com.alibaba.griver.image.R.id.ll_bottom_menu);
        this.D = (TextView) findViewById(com.alibaba.griver.image.R.id.tv_timetext);
        this.B = (Button) findViewById(com.alibaba.griver.image.R.id.bt_select);
        this.i = (LinearLayout) findViewById(com.alibaba.griver.image.R.id.ll_buckets);
        ImageView imageView = (ImageView) findViewById(com.alibaba.griver.image.R.id.bt_back);
        this.H = imageView;
        CommonUtils.setTitleBarBackDrawable(imageView);
        this.c = (Button) findViewById(com.alibaba.griver.image.R.id.bt_finish);
        this.d = (TextView) findViewById(com.alibaba.griver.image.R.id.tv_bucket);
        this.x = findViewById(com.alibaba.griver.image.R.id.iv_bucket);
        this.e = (TextView) findViewById(com.alibaba.griver.image.R.id.tv_preview);
        TextView textView = (TextView) findViewById(com.alibaba.griver.image.R.id.tv_edit);
        this.T = textView;
        textView.setOnClickListener(this);
        this.f6557a = (PhotoGridView) findViewById(com.alibaba.griver.image.R.id.gv_photo);
        this.z = (RelativeLayout) findViewById(com.alibaba.griver.image.R.id.rl_bottom_bar);
        this.b = (ListView) findViewById(com.alibaba.griver.image.R.id.lv_buckets);
        this.E = (TextView) findViewById(com.alibaba.griver.image.R.id.tv_title);
        this.ac = findViewById(com.alibaba.griver.image.R.id.pb_loading_data);
        FrameLayout frameLayout = (FrameLayout) findViewById(com.alibaba.griver.image.R.id.fl_buckets);
        this.M = frameLayout;
        frameLayout.setOnClickListener(this);
        this.b.setOnItemClickListener(this);
        this.P = (TextView) findViewById(com.alibaba.griver.image.R.id.empty_tips);
        this.H.setOnClickListener(this);
        this.c.setOnClickListener(this);
        this.e.setOnClickListener(this);
    }

    private void c(Bundle bundle) {
        this.ad = bundle.getBoolean(PhotoParam.ENABLE_SELECT_ORIGIN, true);
        String string = bundle.getString("businessId");
        this.aa = string;
        ImageHelper.updateBusinessId(string, TAG);
        this.R = bundle.getBoolean(PhotoParam.PHOTO_SELECT_CONTAIN_VIDEO, false);
        boolean z = bundle.getBoolean(PhotoParam.SELECT_VIDEO_ONLY, false);
        this.ab = z;
        this.R = z || this.R;
        this.S = bundle.getFloat(PhotoParam.BEAUTY_IMAGE_LEVEL, -1.0f);
        this.ae = bundle.getInt(PhotoParam.COMPRESS_IMAGE_QUALITY, -1);
        this.F = bundle.getBoolean(PhotoParam.PHOTO_SELECT, false);
        this.p = bundle.getBoolean(PhotoParam.ENABLE_CAMERA, true);
        this.r = bundle.getBoolean(PhotoParam.ENABLE_PREVIEW, true);
        this.U = bundle.getBoolean(PhotoParam.ENABLE_EDIT_PHOTO, false);
        this.t = bundle.getBoolean(PhotoParam.ENABLE_BUCKET, true);
        this.G = bundle.getBoolean(PhotoParam.ENABLE_GRID_OPTION, false);
        this.V = bundle.getBoolean(PhotoParam.ENABLE_VIDEO_CUT, false);
        this.f6558o = bundle.getString(PhotoParam.PREVIEW_BUTTON);
        this.s = bundle.getInt(PhotoParam.MAX_SELECT, 9);
        this.u = bundle.getString(PhotoParam.MAX_SELECT_MSG);
        this.n = bundle.getString(PhotoParam.FINISH_TEXT);
        this.g = bundle.getString(PhotoParam.CONTEXT_INDEX);
        StringBuilder sb = new StringBuilder();
        sb.append("PhotoSelect context index ");
        sb.append(this.g);
        RVLogger.d(TAG, sb.toString());
        this.v = bundle.getString(PhotoParam.BUCKET_NAME);
        int i = bundle.getInt(PhotoParam.FINISH_BTN_BG_COLOR, -1);
        if (i != -1) {
            this.c.setBackgroundColor(i);
        }
        this.C = bundle.getBoolean("optionActive", false);
        selectGif = bundle.getBoolean(PhotoParam.SELECT_GIF, false);
        enableGifDynamicPreview = bundle.getBoolean(PhotoParam.ENABLE_GIF_DYNAMIC_PREVIEW, true);
        this.L = bundle.getInt(PhotoParam.MIN_PHOTO_SIZE, 10240);
        this.Y = bundle.getInt(PhotoParam.KEY_MIN_PHOTO_WIDTH, 0);
        this.Z = bundle.getInt(PhotoParam.KEY_MIN_PHOTO_HEIGHT, 0);
        StringBuilder sb2 = new StringBuilder();
        sb2.append(this.g);
        sb2.append("_camera");
        this.y = sb2.toString();
    }

    private void g() {
        this.P.setVisibility(this.k.getData().isEmpty() ? 0 : 8);
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        StringBuilder sb = new StringBuilder();
        sb.append("onSaveInstanceState ");
        sb.append(this.g);
        RVLogger.d(TAG, sb.toString());
        this.Q = true;
        bundle.putAll(getIntent().getExtras());
        bundle.putInt(PhotoParam.PREVIEW_POSITION, this.f6557a.getFirstVisiblePosition());
        bundle.putString(PhotoParam.CONTEXT_INDEX, this.g);
        bundle.putBoolean("optionActive", this.C);
        PhotoContext.contextMap.put(this.g, this.h);
    }

    private void h() {
        if (this.t) {
            a(this.w, "onBucketReady");
            BucketAdapter bucketAdapter = new BucketAdapter(this, this.f.getBucketList());
            this.k = bucketAdapter;
            this.b.setAdapter((ListAdapter) bucketAdapter);
            g();
            this.q = 0;
            return;
        }
        if (d()) {
            ((TextView) findViewById(com.alibaba.griver.image.R.id.tv_no_photo)).setVisibility(0);
        } else {
            this.j.setData(this.m);
        }
        RVLogger.d(TAG, "disable bucket for user set photoList.");
        this.x.setVisibility(8);
    }

    private void i() {
        RVLogger.d("PhotoDisplayLink", "doInitPhotoResolver:###");
        PhotoResolver photoResolver = new PhotoResolver(this, new PhotoResolver.BucketUpdateListener() { // from class: com.alibaba.griver.image.activity.GriverPhotoSelectActivity.4
            {
                GriverPhotoSelectActivity.this = this;
            }

            @Override // com.alibaba.griver.image.photo.PhotoResolver.BucketUpdateListener
            public void onScanFinished() {
                GriverPhotoSelectActivity.this.ag = true;
                GriverPhotoSelectActivity.this.ac.setVisibility(8);
                GriverPhotoSelectActivity.this.w();
                GriverPhotoSelectActivity.this.C();
            }

            @Override // com.alibaba.griver.image.photo.PhotoResolver.BucketUpdateListener
            public void onScanStep() {
                if (GriverPhotoSelectActivity.this.isFinishing()) {
                    return;
                }
                GriverPhotoSelectActivity.this.j();
                GriverPhotoSelectActivity.this.b("onScanStep");
            }
        });
        this.f = photoResolver;
        LinkedHashSet<String> linkedHashSet = this.O;
        photoResolver.setEnableStepScan(linkedHashSet == null || linkedHashSet.isEmpty());
        this.f.setAllBucketName(this.w);
        this.f.setEnableGif(selectGif);
        this.f.setMinPhotoSize(this.L);
        this.f.setMinPhotoWidth(this.Y);
        this.f.setMinPhotoHeight(this.Z);
        this.f.setSelectedPhotoPaths(this.O);
        this.h.photoResolver = this.f;
    }

    @Override // android.app.Activity
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        PhotoContext.remove(this.g);
        final int intExtra = intent.getIntExtra(PhotoParam.PREVIEW_POSITION, -1);
        int firstVisiblePosition = this.f6557a.getFirstVisiblePosition();
        int lastVisiblePosition = this.f6557a.getLastVisiblePosition();
        if (intExtra != -1 && (intExtra > lastVisiblePosition || intExtra < firstVisiblePosition)) {
            this.f6557a.setSelection(intExtra);
        }
        if (intExtra == 0) {
            RVLogger.d(TAG, "no need to indicate current position.");
        } else {
            this.f6557a.postDelayed(new Runnable() { // from class: com.alibaba.griver.image.activity.GriverPhotoSelectActivity.5
                {
                    GriverPhotoSelectActivity.this = this;
                }

                @Override // java.lang.Runnable
                public void run() {
                    PhotoGrid photoGrid = (PhotoGrid) GriverPhotoSelectActivity.this.f6557a.getChildAt(intExtra - GriverPhotoSelectActivity.this.f6557a.getFirstVisiblePosition());
                    if (photoGrid != null) {
                        photoGrid.animateSelection();
                    }
                }
            }, 400L);
        }
    }

    @Override // com.alibaba.griver.image.activity.GriverMediaBaseActivity, android.app.Activity
    public void onResume() {
        Context baseContext = getBaseContext();
        if (baseContext == null) {
            Object[] objArr = new Object[1];
            ao(26 - TextUtils.getOffsetAfter("", 0), 23 - Color.red(0), (char) (61351 - Color.alpha(0)), objArr);
            Class<?> cls = Class.forName((String) objArr[0]);
            Object[] objArr2 = new Object[1];
            ao(17 - TextUtils.indexOf((CharSequence) "", '0', 0, 0), super.getResources().getString(R.string.dana_viz_prompt_dialog_success_verification_subtitle).substring(0, 9).length() + 40, (char) (ViewConfiguration.getWindowTouchSlop() >> 8), objArr2);
            baseContext = (Context) cls.getMethod((String) objArr2[0], new Class[0]).invoke(null, null);
        }
        if (baseContext != null) {
            baseContext = baseContext.getApplicationContext();
        }
        if (baseContext != null) {
            try {
                Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                if (obj == null) {
                    obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(((Process.getThreadPriority(0) + 20) >> 6) + PDF417Common.NUMBER_OF_CODEWORDS, 34 - ((byte) KeyEvent.getModifierMetaStateMask()), (char) (TextUtils.indexOf((CharSequence) "", '0', 0, 0) + 1))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                }
                Object invoke = ((Method) obj).invoke(null, null);
                try {
                    Object[] objArr3 = {baseContext};
                    Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(247288059);
                    if (obj2 == null) {
                        obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(TextUtils.getOffsetAfter("", 0) + 911, (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)) + 18, (char) (ViewConfiguration.getDoubleTapTimeout() >> 16))).getMethod("KClassImpl$Data$declaredNonStaticMembers$2", Context.class);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(247288059, obj2);
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
        try {
            super.onResume();
            q();
            r();
        } catch (Exception e) {
            StringBuilder sb = new StringBuilder();
            sb.append("OnResume exception :");
            sb.append(e.getMessage());
            RVLogger.e(TAG, sb.toString());
            finish();
        }
    }

    private void k() {
        this.A.setVisibility(8);
    }

    private void l() {
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(this.h.selectedList);
        ArrayList arrayList2 = new ArrayList();
        arrayList2.addAll(this.h.selectedList);
        this.h.photoList = arrayList;
        this.h.selectedList = arrayList2;
        a(0, true);
    }

    private void m() {
        this.h.sendSelectedPhoto(this, this.S, this.ae, new Runnable() { // from class: com.alibaba.griver.image.activity.GriverPhotoSelectActivity.6
            {
                GriverPhotoSelectActivity.this = this;
            }

            @Override // java.lang.Runnable
            public void run() {
                GriverPhotoSelectActivity.this.n();
            }
        }, this.X.isChecked());
    }

    public void n() {
        StringBuilder sb = new StringBuilder();
        sb.append("toggleFinish ");
        sb.append(this.g);
        RVLogger.d(TAG, sb.toString());
        finish();
    }

    private void o() {
        boolean z = !this.C;
        this.C = z;
        if (!z) {
            Iterator<PhotoItem> it = this.m.iterator();
            while (it.hasNext()) {
                it.next().setSelected(false);
            }
            this.h.selectedList.clear();
        }
        p();
    }

    private void p() {
        boolean z = false;
        if (!this.C) {
            this.B.setText(getString(com.alibaba.griver.image.R.string.griver_image_select));
            this.A.setVisibility(8);
        } else {
            this.B.setText(getString(com.alibaba.griver.image.R.string.griver_image_cancel));
            this.A.setVisibility(0);
        }
        if (this.C || (this.F && this.s > 1)) {
            z = true;
        }
        this.j.setCheckable(z);
        r();
        q();
    }

    private void q() {
        String str;
        String str2;
        PhotoContext photoContext;
        RVLogger.d(TAG, "updateContent:###");
        int size = this.h.selectedList != null ? this.h.selectedList.size() : 0;
        StringBuilder sb = new StringBuilder();
        sb.append("selectedCount =");
        sb.append(size);
        RVLogger.d(TAG, sb.toString());
        if (this.A.getVisibility() == 0) {
            int childCount = this.A.getChildCount();
            for (int i = 0; i < childCount; i++) {
                this.A.getChildAt(i).setEnabled(size > 0);
            }
        }
        this.c.setEnabled(size > 0);
        if (size > 0) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(this.f6558o);
            sb2.append("(");
            sb2.append(size);
            sb2.append(")");
            str = sb2.toString();
        } else {
            str = this.f6558o;
        }
        this.e.setText(str);
        this.e.setEnabled(size > 0);
        if (size == 1 && (photoContext = this.h) != null && photoContext.selectedList != null && !this.h.selectedList.isEmpty() && this.h.selectedList.get(0).getMediaType() == 0 && (!this.h.selectedList.get(0).isGif() || !enableGifDynamicPreview)) {
            this.T.setEnabled(true);
        } else {
            this.T.setEnabled(false);
        }
        if (size > 0) {
            StringBuilder sb3 = new StringBuilder();
            sb3.append(this.n);
            sb3.append("(");
            sb3.append(size);
            sb3.append("/");
            sb3.append(this.s);
            sb3.append(")");
            str2 = sb3.toString();
        } else {
            str2 = this.n;
        }
        this.c.setText(str2);
        if (this.G) {
            if (!this.C) {
                this.E.setText(this.v);
            } else {
                this.E.setText(getString(com.alibaba.griver.image.R.string.griver_image_select_photo_count, Integer.valueOf(size)));
            }
        }
    }

    @Override // android.app.Activity
    public void finish() {
        super.finish();
        AnimationUtil.fadeInFadeOut(this);
        PhotoContext photoContext = this.h;
        if (photoContext != null) {
            if (photoContext.selectSent || this.h.selectListener == null) {
                return;
            }
            this.h.selectListener.onSelectCanceled();
            return;
        }
        RVLogger.w(TAG, "finish called,photoContent happend to be Null!");
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.equals(this.c)) {
            m();
        } else if (view.equals(this.i)) {
            u();
        } else if (view.equals(this.e)) {
            l();
        } else if (view.equals(this.H)) {
            n();
        } else if (view.equals(this.B)) {
            o();
        } else if (view.equals(this.M)) {
            u();
        }
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 701 && i2 == -1) {
            t();
        } else if (i == 702 && i2 == -1) {
            this.h.selectSent = true;
            n();
        } else if (i != 702 || i2 != 0) {
            if (i == 1001 && i2 == -1) {
                n();
            }
        } else {
            if (intent != null) {
                this.N = intent.getBooleanExtra(PhotoParam.USE_ORIGIN_PHOTO, false);
                if (this.X.getVisibility() == 0) {
                    this.X.setChecked(this.N);
                }
            }
            this.h.photoList = this.m;
            if (PhotoContext.contextMap.containsKey(this.y)) {
                PhotoContext.contextMap.remove(this.y);
            }
        }
    }

    private void r() {
        int firstVisiblePosition = this.f6557a.getFirstVisiblePosition();
        int lastVisiblePosition = this.f6557a.getLastVisiblePosition();
        boolean z = true;
        if ((this.s <= 1 || !this.F) && !this.C) {
            z = false;
        }
        for (int i = firstVisiblePosition; i <= lastVisiblePosition; i++) {
            PhotoGrid photoGrid = (PhotoGrid) this.f6557a.getChildAt(i - firstVisiblePosition);
            photoGrid.setCheckable(z);
            photoGrid.updateGrid();
        }
    }

    private void a(int i, boolean z) {
        StringBuilder sb = new StringBuilder();
        sb.append("preview:### index = ");
        sb.append(i);
        RVLogger.w(TAG, sb.toString());
        PhotoContext.contextMap.put(this.g, this.h);
        Intent intent = new Intent(this, GriverPhotoPreviewActivity.class);
        intent.putExtras(getIntent().getExtras());
        if (this.V) {
            i = a(i);
        }
        intent.putExtra(PhotoParam.PREVIEW_POSITION, i);
        intent.putExtra(PhotoParam.PHOTO_SELECT, this.F);
        intent.addFlags(AntDetector.SCENE_ID_LOGIN_REGIST);
        intent.addFlags(16777216);
        intent.putExtra(PhotoParam.USE_ORIGIN_PHOTO, this.N);
        intent.putExtra(PhotoParam.SELECT_GRID, this.C);
        intent.setFlags(67108864);
        startActivityForResult(intent, 702);
        AnimationUtil.fadeInFadeOut(this);
    }

    private void t() {
        Uri fromFile;
        if (this.l == null) {
            RVLogger.e(TAG, "CameraPath empty!");
            return;
        }
        if (PhotoUtil.isQCompact()) {
            fromFile = FileProvider.getUriForFile(this, "com.alipay.mobile.camera.fileprovider", this.l);
        } else {
            fromFile = Uri.fromFile(this.l);
        }
        StringBuilder sb = new StringBuilder();
        sb.append(PhotoContext.FILE_SCHEME);
        sb.append(this.l.getAbsolutePath());
        String obj = sb.toString();
        if (!this.l.exists()) {
            RVLogger.d(TAG, "failed to get camera file");
            return;
        }
        if (PhotoUtil.isQCompact()) {
            APMSandboxProcessor.insertMediaFile(new APMInsertReq.Builder(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, fromFile, this.l.getName()).mimeType("image/jpeg").build());
        } else {
            Intent intent = new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE");
            intent.setData(fromFile);
            sendBroadcast(intent);
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("onTakePhoto from camera ");
        sb2.append(obj);
        RVLogger.d(TAG, sb2.toString());
        PhotoItem photoItem = new PhotoItem(obj, true);
        photoItem.setIsPicCurrentlyTaked(true);
        photoItem.setPhotoSize(this.l.length());
        photoItem.setPhotoOrientation(readPictureDegree(this.l.getAbsolutePath()));
        if (this.s == 1) {
            if (this.m == null) {
                this.m = new ArrayList();
            }
            this.m.add(photoItem);
            this.h.selectedList.add(photoItem);
            m();
            return;
        }
        PhotoContext photoContext = PhotoContext.get(this.y);
        photoContext.selectedList = new ArrayList();
        photoContext.photoList = new ArrayList();
        PhotoContext photoContext2 = this.h;
        if (photoContext2 != null && photoContext2.selectedList != null && this.h.selectedList.size() > 0) {
            photoContext.selectedList.addAll(this.h.selectedList);
            photoContext.photoList.addAll(this.h.selectedList);
        }
        photoContext.selectedList.add(photoItem);
        photoContext.photoList.add(photoItem);
        photoContext.selectListener = this.h.selectListener;
        Intent intent2 = new Intent(this, GriverPhotoPreviewActivity.class);
        intent2.putExtras(getIntent().getExtras());
        int size = photoContext.photoList.size() - 1;
        if (size < 0) {
            size = 0;
        }
        intent2.putExtra(PhotoParam.PREVIEW_POSITION, size);
        intent2.putExtra(PhotoParam.PHOTO_SELECT, this.F);
        intent2.putExtra(PhotoParam.MAX_SELECT, this.s);
        intent2.putExtra(PhotoParam.CONTEXT_INDEX, this.y);
        intent2.putExtra(PhotoParam.USE_ORIGIN_PHOTO, this.N);
        startActivityForResult(intent2, 702);
        AnimationUtil.fadeInFadeOut(this);
    }

    private int a(int i) {
        int i2;
        RVLogger.w(TAG, "getIndexAfterFilterVideo:###");
        try {
            List<PhotoItem> list = this.m;
            if (list != null && !list.isEmpty()) {
                PhotoItem photoItem = this.m.get(i);
                i2 = 0;
                for (int i3 = 0; i3 < this.m.size(); i3++) {
                    PhotoItem photoItem2 = this.m.get(i3);
                    if (!photoItem2.isVideo()) {
                        if (photoItem2 == photoItem) {
                            break;
                        }
                        i2++;
                    }
                }
            }
        } catch (Exception e) {
            StringBuilder sb = new StringBuilder();
            sb.append("getIndexAfterFilterVideo:Should not be here. ");
            sb.append(e.getMessage());
            RVLogger.w(TAG, sb.toString());
        }
        i2 = i;
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Before = ");
        sb2.append(i);
        sb2.append(" after = ");
        sb2.append(i2);
        RVLogger.w(TAG, sb2.toString());
        return i2;
    }

    private void u() {
        if (this.b.getVisibility() != 0) {
            this.M.setVisibility(0);
            this.M.startAnimation(AnimationUtils.loadAnimation(this, com.alibaba.griver.image.R.anim.griver_image_fade_in));
            this.b.setVisibility(0);
            this.b.startAnimation(AnimationUtils.loadAnimation(this, com.alibaba.griver.image.R.anim.griver_image_select_pop_up));
            return;
        }
        this.M.setVisibility(4);
        this.M.startAnimation(AnimationUtils.loadAnimation(this, com.alibaba.griver.image.R.anim.griver_image_fade_out));
        this.b.setVisibility(4);
        this.b.startAnimation(AnimationUtils.loadAnimation(this, com.alibaba.griver.image.R.anim.griver_image_effect_select_pop_down));
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        if (this.b.getVisibility() == 0) {
            u();
        } else if (this.G && this.C) {
            o();
        } else {
            super.onBackPressed();
        }
    }

    private void a(String str, String str2) {
        StringBuilder sb = new StringBuilder();
        sb.append("onBucketSelected: ");
        sb.append(str);
        sb.append(",caller -> ");
        sb.append(str2);
        RVLogger.d("PhotoDisplayLink", sb.toString());
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Selected album: ");
        sb2.append(str);
        RVLogger.d(TAG, sb2.toString());
        PhotoResolver photoResolver = this.f;
        if (photoResolver != null) {
            this.m = photoResolver.getBucketList(str);
            if (this.ag) {
                q();
            }
        }
        this.j.cameraItem = (this.p && this.q == 0) ? this.J : null;
        PhotoContext photoContext = this.h;
        if (photoContext == null) {
            RVLogger.w(TAG, "onBucketSelected photoContext null!");
            return;
        }
        photoContext.photoList = this.m;
        this.j.setData(this.m);
        if (!TextUtils.equals(this.ah, str)) {
            this.f6557a.post(new Runnable() { // from class: com.alibaba.griver.image.activity.GriverPhotoSelectActivity.7
                {
                    GriverPhotoSelectActivity.this = this;
                }

                @Override // java.lang.Runnable
                public void run() {
                    GriverPhotoSelectActivity.this.f6557a.setSelection(0);
                }
            });
        }
        this.ah = str;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        BucketInfo bucketInfo = (BucketInfo) adapterView.getItemAtPosition(i);
        for (int i2 = 0; i2 < adapterView.getCount(); i2++) {
            BucketInfo bucketInfo2 = (BucketInfo) adapterView.getItemAtPosition(i2);
            if (i2 == i) {
                bucketInfo2.setSelected(true);
            } else {
                bucketInfo2.setSelected(false);
            }
        }
        this.q = i;
        this.w = bucketInfo.getName();
        this.k.notifyDataSetChanged();
        this.d.setText(this.w);
        u();
        a(this.w, "onItemClick");
    }

    private void v() {
        LinkedHashSet<String> linkedHashSet = this.O;
        if (linkedHashSet == null || linkedHashSet.isEmpty()) {
            return;
        }
        Collections.sort(this.h.selectedList, new Comparator<PhotoItem>() { // from class: com.alibaba.griver.image.activity.GriverPhotoSelectActivity.8
            {
                GriverPhotoSelectActivity.this = this;
            }

            @Override // java.util.Comparator
            public int compare(PhotoItem photoItem, PhotoItem photoItem2) {
                return GriverPhotoSelectActivity.this.a(photoItem.getPhotoPath()) - GriverPhotoSelectActivity.this.a(photoItem2.getPhotoPath());
            }
        });
    }

    public int a(String str) {
        Iterator<String> it = this.O.iterator();
        int i = 0;
        while (it.hasNext()) {
            if (it.next().equals(str)) {
                return i;
            }
            i++;
        }
        return -1;
    }

    @Override // com.alibaba.griver.image.photo.adapter.GridAdapter.OnGridListener
    public void onGridClick(PhotoGrid photoGrid, int i) {
        if (this.q == 0 && i == -1 && this.p) {
            x();
        } else if (this.r) {
            c(i);
        } else if (this.s == 1) {
            b(i);
        }
    }

    private void b(int i) {
        List<PhotoItem> list = this.m;
        if (list == null || i >= list.size()) {
            RVLogger.w(TAG, "OnGridClick,but index invalid!");
            return;
        }
        PhotoItem photoItem = this.m.get(i);
        photoItem.setSelected(true);
        this.h.selectedList.add(photoItem);
        m();
    }

    private void c(int i) {
        List<PhotoItem> list = this.m;
        if (list == null || i >= list.size()) {
            RVLogger.w(TAG, "OnGridClick,but index invalid!");
            return;
        }
        this.h.photoList = this.m;
        a(i, false);
    }

    public void w() {
        RVLogger.d(TAG, "restorePreSelectedPhotos:###");
        List<PhotoItem> bucketList = this.f.getBucketList(this.w);
        if (this.h.selectedList == null || bucketList == null || bucketList.isEmpty()) {
            return;
        }
        try {
            for (PhotoItem photoItem : bucketList) {
                if (photoItem != null && photoItem.getSelected() && !this.h.selectedList.contains(photoItem)) {
                    this.h.selectedList.add(photoItem);
                }
            }
            v();
        } catch (Exception e) {
            StringBuilder sb = new StringBuilder();
            sb.append("restorePreSelectedPhotos Exception :");
            sb.append(e.getMessage());
            RVLogger.w(TAG, sb.toString());
        }
        q();
    }

    private void x() {
        PhotoContext photoContext = this.h;
        if (photoContext != null && photoContext.selectedList != null && this.h.selectedList.size() >= this.s) {
            ToastUtils.showToast(this, this.u, 0);
        } else {
            y();
        }
    }

    private void y() {
        if (z()) {
            s();
            return;
        }
        ActivityCompat.MyBillsEntityDataFactory(this, "android.permission.CAMERA");
        A();
    }

    private boolean z() {
        boolean z = Build.VERSION.SDK_INT < 23;
        try {
            return PermissionChecker.getAuthRequestContext(this, "android.permission.CAMERA") == 0;
        } catch (Exception e) {
            StringBuilder sb = new StringBuilder();
            sb.append("checkSelfPermission exception:");
            sb.append(e.getMessage());
            RVLogger.d(TAG, sb.toString());
            return z;
        }
    }

    private void A() {
        this.ai = ActivityCompat.MyBillsEntityDataFactory(this, "android.permission.CAMERA");
        ActivityCompat.BuiltInFictitiousFunctionClassFactory(this, new String[]{"android.permission.CAMERA"}, 1001);
    }

    @Override // android.app.Activity
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        if (i == 101) {
            if (iArr.length > 0 && iArr[0] == 0) {
                e();
                return;
            }
            RVLogger.d(TAG, "user denie the PERMISSION_CAMERA");
            boolean MyBillsEntityDataFactory2 = ActivityCompat.MyBillsEntityDataFactory(this, "android.permission.CAMERA");
            if (this.ai || MyBillsEntityDataFactory2) {
                return;
            }
            ToastUtils.showToast(this, getString(com.alibaba.griver.image.R.string.griver_image_permisson_rationale), 1);
        }
    }

    @Override // com.alibaba.griver.image.photo.adapter.GridAdapter.OnGridListener
    public void onGridChecked(PhotoGrid photoGrid, int i) {
        if (!CommonUtils.isIndexValidInList(this.m, i)) {
            StringBuilder sb = new StringBuilder();
            sb.append("onGridChecked:invalid index = ");
            sb.append(i);
            sb.append(",list size = ");
            List<PhotoItem> list = this.m;
            sb.append(list != null ? list.size() : 0);
            RVLogger.w(TAG, sb.toString());
            return;
        }
        PhotoItem photoItem = this.m.get(i);
        boolean selected = photoItem.getSelected();
        boolean isChecked = photoGrid.isChecked();
        if (isChecked && selected) {
            return;
        }
        if (selected || isChecked) {
            int size = this.h.selectedList.size();
            if (!isChecked || selected) {
                if (!isChecked && selected) {
                    photoItem.setSelected(false);
                    this.h.selectedList.remove(photoItem);
                }
            } else if (size >= this.s) {
                ToastUtils.showToast(this, this.u, 0);
                photoGrid.setChecked(false);
                return;
            } else {
                photoItem.setSelected(true);
                this.h.selectedList.add(photoItem);
            }
            q();
        }
    }

    @Override // com.alibaba.griver.image.activity.GriverMediaBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        PhotoResolver photoResolver = this.f;
        if (photoResolver != null) {
            photoResolver.setBucketListener(null);
        }
        this.f = null;
        this.aj = null;
        if (this.h != null && !this.Q) {
            PhotoContext.contextMap.clear();
        }
        this.h = null;
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        a(motionEvent);
        return super.dispatchTouchEvent(motionEvent);
    }

    private void a(MotionEvent motionEvent) {
        if (this.b.getVisibility() == 0) {
            return;
        }
        int action = motionEvent.getAction();
        if (action == 0) {
            this.D.removeCallbacks(this.aj);
        } else if (action == 1) {
            this.D.postDelayed(this.aj, 1000L);
        }
    }

    private void B() {
        String format;
        if (this.h.photoList == null) {
            return;
        }
        try {
            long modifiedTime = this.h.photoList.get(this.f6557a.getFirstVisiblePosition()).getModifiedTime();
            if (modifiedTime <= 0) {
                RVLogger.d(TAG, "photo modified time not set!");
                return;
            }
            if (modifiedTime >= PhotoUtil.getThisMonth()) {
                format = getString(com.alibaba.griver.image.R.string.griver_image_this_month);
            } else {
                format = new SimpleDateFormat(getString(com.alibaba.griver.image.R.string.griver_image_time_pattern)).format(new Date(modifiedTime));
            }
            this.D.setVisibility(0);
            this.D.setText(format);
        } catch (Exception e) {
            StringBuilder sb = new StringBuilder();
            sb.append("updateTime called when gvPhoto`s Adapter`s related data is not same as photoContext.photoList. Exception :");
            sb.append(e.getMessage());
            RVLogger.w(TAG, sb.toString());
        }
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        if (this.I == i) {
            return;
        }
        this.I = i;
        B();
    }

    @Override // com.alibaba.griver.image.photo.widget.PhotoGridView.OnOverScrolledListener
    public void onOverScrolled(int i, int i2) {
        if (this.D.getVisibility() == 0) {
            return;
        }
        B();
    }

    public void C() {
        if (this.k != null) {
            RVLogger.d("PhotoDisplayLink", "Update bucket.");
            b("onScanFinish");
            Intent intent = new Intent();
            intent.setAction(ACTION_PHOTO_ADAPTER_CHANGE);
            LocalBroadcastManager.getInstance(getApplicationContext()).sendBroadcast(intent);
        }
    }

    public void b(String str) {
        this.k.setData(this.f.getBucketList());
        this.k.notifyDataSetChanged();
        a(this.w, str);
        g();
    }

    private static void ao(int i, int i2, char c, Object[] objArr) {
        whenAvailable whenavailable = new whenAvailable();
        long[] jArr = new long[i];
        whenavailable.BuiltInFictitiousFunctionClassFactory = 0;
        while (whenavailable.BuiltInFictitiousFunctionClassFactory < i) {
            jArr[whenavailable.BuiltInFictitiousFunctionClassFactory] = (((char) (MyBillsEntityDataFactory[whenavailable.BuiltInFictitiousFunctionClassFactory + i2] ^ (-4773380863230414002L))) ^ (whenavailable.BuiltInFictitiousFunctionClassFactory * ((-4773380863230414002L) ^ KClassImpl$Data$declaredNonStaticMembers$2))) ^ c;
            whenavailable.BuiltInFictitiousFunctionClassFactory++;
        }
        char[] cArr = new char[i];
        whenavailable.BuiltInFictitiousFunctionClassFactory = 0;
        while (whenavailable.BuiltInFictitiousFunctionClassFactory < i) {
            cArr[whenavailable.BuiltInFictitiousFunctionClassFactory] = (char) jArr[whenavailable.BuiltInFictitiousFunctionClassFactory];
            whenavailable.BuiltInFictitiousFunctionClassFactory++;
        }
        objArr[0] = new String(cArr);
    }
}
