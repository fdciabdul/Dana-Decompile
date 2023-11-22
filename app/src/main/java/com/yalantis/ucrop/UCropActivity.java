package com.yalantis.ucrop;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.ImageFormat;
import android.graphics.PorterDuff;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.media.AudioTrack;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Process;
import android.os.SystemClock;
import android.telephony.cdma.CdmaCellLocation;
import android.text.AndroidCharacter;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.Window;
import android.view.animation.AccelerateInterpolator;
import android.widget.ExpandableListView;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.fullstory.instrumentation.InstrumentInjector;
import com.google.common.base.Ascii;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.google.zxing.pdf417.PDF417Common;
import com.yalantis.ucrop.callback.BitmapCropCallback;
import com.yalantis.ucrop.model.AspectRatio;
import com.yalantis.ucrop.util.SelectedStateListDrawable;
import com.yalantis.ucrop.view.GestureCropImageView;
import com.yalantis.ucrop.view.OverlayView;
import com.yalantis.ucrop.view.TransformImageView;
import com.yalantis.ucrop.view.UCropView;
import com.yalantis.ucrop.view.widget.AspectRatioTextView;
import com.yalantis.ucrop.view.widget.HorizontalProgressWheelView;
import id.dana.onboarding.splash.LauncherActivity;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.text.Typography;
import o.E;
import o.SummaryVoucherView$$ExternalSyntheticLambda0;

/* loaded from: classes8.dex */
public class UCropActivity extends AppCompatActivity {
    private static int A = 0;
    public static final int ALL = 3;
    private static long C = 0;
    private static char D = 0;
    public static final Bitmap.CompressFormat DEFAULT_COMPRESS_FORMAT;
    public static final int DEFAULT_COMPRESS_QUALITY = 90;
    public static final int NONE = 0;
    public static final int ROTATE = 2;
    public static final int SCALE = 1;
    private ViewGroup B;
    private ViewGroup BottomSheetCardBindingView$watcherCardNumberView$1;
    private ViewGroup DatabaseTableConfigUtil;
    private int FragmentBottomSheetPaymentSettingBinding;
    private GestureCropImageView GetContactSyncConfig;
    private ViewGroup NetworkUserEntityData$$ExternalSyntheticLambda2;
    private TextView NetworkUserEntityData$$ExternalSyntheticLambda4;
    private int NetworkUserEntityData$$ExternalSyntheticLambda5;
    private TextView NetworkUserEntityData$$ExternalSyntheticLambda6;
    private OverlayView NetworkUserEntityData$$ExternalSyntheticLambda8;
    private int PlaceComponentResult;
    private boolean PrepareContext;
    private int SubSequence;
    private ViewGroup VerifyPinStateManager$executeRiskChallenge$2$1;
    private String getCallingPid;
    private UCropView getSupportButtonTintMode;
    private ViewGroup initRecordTimeStamp;
    private int isLayoutRequested;
    private View lookAheadTest;
    private int newProxyInstance;
    private int readMicros;
    private int whenAvailable;
    public static final byte[] $$a = {10, Byte.MIN_VALUE, TarHeader.LF_LINK, 76, -51, TarHeader.LF_NORMAL, -46, -10, -7, -14, 39, -48, -13, 4, -18, -12, 46, -36, -26, 12, Ascii.DC4, -34, -9, -24, -2, -10, -14, -5, -22, 44, -59, -6, 5, 15, -26, -19, -11, 9, -21, -8, 42, -51, -6, -13, 8, -26, -3, 1, -48, 4, -25, -7, 35, -43, -10, -3, 65, -39, -36, -26, 12, TarHeader.LF_FIFO, -71, -8, -5, -16, 4, -24, 6, -6, 15, -40, -6, Ascii.DC4, -40, 12, -26, 4, -1, 15, -31, -15, 4, -10, -20, -8, 72, -21};
    public static final int $$b = 3;
    public static final byte[] KClassImpl$Data$declaredNonStaticMembers$2 = {56, -119, 46, TarHeader.LF_CONTIG, 17, -6, 18, 1, -2, -1, -50, 57, 16, 3, 10, -11, 13, 10, -66, Ascii.EM, TarHeader.LF_NORMAL, 3, 10, -11, Ascii.ETB, 0, -1, 5, 13, 10, -7, 15, 9, -45, Ascii.GS, 22, -7, -33, TarHeader.LF_NORMAL, -7, 5, -5, Ascii.EM, -17, -47, 66, -7, 17, -3, -53, 41, 42, -2, 5, -11, 12, 2, 19, -47, TarHeader.LF_CHR, 4, 0, 1, -2, 2, Ascii.ETB, -7, 10, 3, -33, 41, -4, 13};
    public static final int getAuthRequestContext = 208;
    private boolean NetworkUserEntityData$$ExternalSyntheticLambda7 = true;
    private List<ViewGroup> scheduleImpl = new ArrayList();
    private Bitmap.CompressFormat getErrorConfigVersion = DEFAULT_COMPRESS_FORMAT;
    private int moveToNextValue = 90;
    private int[] NetworkUserEntityData$$ExternalSyntheticLambda0 = {1, 2, 3};
    private TransformImageView.TransformImageListener NetworkUserEntityData$$ExternalSyntheticLambda1 = new TransformImageView.TransformImageListener() { // from class: com.yalantis.ucrop.UCropActivity.1
        @Override // com.yalantis.ucrop.view.TransformImageView.TransformImageListener
        public final void MyBillsEntityDataFactory(float f) {
            UCropActivity.access$000(UCropActivity.this, f);
        }

        @Override // com.yalantis.ucrop.view.TransformImageView.TransformImageListener
        public final void BuiltInFictitiousFunctionClassFactory(float f) {
            UCropActivity.access$100(UCropActivity.this, f);
        }

        @Override // com.yalantis.ucrop.view.TransformImageView.TransformImageListener
        public final void BuiltInFictitiousFunctionClassFactory() {
            UCropActivity.this.getSupportButtonTintMode.animate().alpha(1.0f).setDuration(300L).setInterpolator(new AccelerateInterpolator());
            UCropActivity.this.lookAheadTest.setClickable(false);
            UCropActivity.this.NetworkUserEntityData$$ExternalSyntheticLambda7 = false;
            UCropActivity.this.supportInvalidateOptionsMenu();
        }

        @Override // com.yalantis.ucrop.view.TransformImageView.TransformImageListener
        public final void BuiltInFictitiousFunctionClassFactory(Exception exc) {
            UCropActivity.this.setResultError(exc);
            UCropActivity.this.finish();
        }
    };
    private final View.OnClickListener NetworkUserEntityData$$ExternalSyntheticLambda3 = new View.OnClickListener() { // from class: com.yalantis.ucrop.UCropActivity.7
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.isSelected()) {
                return;
            }
            UCropActivity.this.MyBillsEntityDataFactory(view.getId());
        }
    };

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes3.dex */
    public @interface GestureTypes {
    }

    static void MyBillsEntityDataFactory() {
        D = (char) 13492;
        C = 4360990799332652212L;
        A = 132417778;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0026  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x001e  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0026 -> B:11:0x0032). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void a(int r6, byte r7, short r8, java.lang.Object[] r9) {
        /*
            int r6 = r6 + 4
            int r8 = r8 + 97
            byte[] r0 = com.yalantis.ucrop.UCropActivity.KClassImpl$Data$declaredNonStaticMembers$2
            int r7 = 23 - r7
            byte[] r1 = new byte[r7]
            int r7 = r7 + (-1)
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
            int r6 = r6 + 1
            byte r4 = (byte) r8
            r1[r3] = r4
            if (r3 != r7) goto L26
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            r9[r2] = r6
            return
        L26:
            r4 = r0[r6]
            int r3 = r3 + 1
            r5 = r8
            r8 = r7
            r7 = r4
            r4 = r3
            r3 = r1
            r1 = r0
            r0 = r9
            r9 = r5
        L32:
            int r9 = r9 + r7
            int r7 = r9 + (-4)
            r9 = r0
            r0 = r1
            r1 = r3
            r3 = r4
            r5 = r8
            r8 = r7
            r7 = r5
            goto L17
        */
        throw new UnsupportedOperationException("Method not decompiled: com.yalantis.ucrop.UCropActivity.a(int, byte, short, java.lang.Object[]):void");
    }

    private static void c(short s, int i, byte b, Object[] objArr) {
        int i2 = (i * 3) + 21;
        int i3 = 103 - (s * 2);
        byte[] bArr = $$a;
        int i4 = 46 - b;
        byte[] bArr2 = new byte[i2];
        int i5 = -1;
        int i6 = i2 - 1;
        if (bArr == null) {
            i3 = (i3 + (-i6)) - 7;
            i6 = i6;
            i4 = i4;
            objArr = objArr;
            bArr = bArr;
            bArr2 = bArr2;
            i5 = -1;
        }
        while (true) {
            int i7 = i5 + 1;
            int i8 = i4 + 1;
            bArr2[i7] = (byte) i3;
            if (i7 == i6) {
                objArr[0] = new String(bArr2, 0);
                return;
            }
            i3 = (i3 + (-bArr[i8])) - 7;
            i6 = i6;
            i4 = i8;
            objArr = objArr;
            bArr = bArr;
            bArr2 = bArr2;
            i5 = i7;
        }
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper
    public void attachBaseContext(Context context) {
        Object[] objArr;
        Object[] objArr2;
        Object[] objArr3;
        Object[] objArr4;
        super.attachBaseContext(context);
        Object[] objArr5 = new Object[1];
        b(new char[]{0, 0, 0, 0}, new char[]{989, 49725, 22398, 30461}, ViewConfiguration.getScrollBarSize() >> 8, (char) (ImageFormat.getBitsPerPixel(0) + 64856), new char[]{29752, 36958, 10244, 37600, 12029, 605, 46089, 22963, 63512, 35022, 53607, 59547, 2074, 14246, 64826, 58185, 4545, 65116}, objArr5);
        Class<?> cls = Class.forName((String) objArr5[0]);
        Object[] objArr6 = new Object[1];
        b(new char[]{0, 0, 0, 0}, new char[]{17869, 3907, 57963, 4605}, 1796162373 - Color.argb(0, 0, 0, 0), (char) (TextUtils.indexOf((CharSequence) "", '0', 0) + 64995), new char[]{39456, 10684, 43012, 36953, 46138}, objArr6);
        int intValue = ((Integer) cls.getDeclaredMethod((String) objArr6[0], new Class[0]).invoke(null, new Object[0])).intValue() % 100000;
        if (intValue < 99000 || intValue > 99999) {
            Context applicationContext = context != null ? context.getApplicationContext() : context;
            if (applicationContext != null) {
                try {
                    Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                    if (obj == null) {
                        obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(930 - (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)), (SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)) + 34, (char) (ViewConfiguration.getScrollBarSize() >> 8))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                    }
                    Object invoke = ((Method) obj).invoke(null, null);
                    Object[] objArr7 = new Object[1];
                    b(new char[]{0, 0, 0, 0}, new char[]{11955, 58550, 15924, 60696}, (-1) - TextUtils.lastIndexOf("", '0', 0), (char) View.resolveSizeAndState(0, 0, 0), new char[]{50219, 33060, 44102, 37070, 28454, 42371, 50716, 38792, 7641, 33632, 12436, 18141, 58962, 8235, 43790, 62754, 31910, 40778, 40152, 65294, 26725, 46052, 10552, 14361, 10640, 43191, 20747, 58443, 33504, 23628, 52697, 57537, 31437, 43259, 50738, 28968, 2394, 750, 27064, 39335, 45351, 47240, 13121, 27366, 36928, 27226, 14424, 3645}, objArr7);
                    String str = (String) objArr7[0];
                    Object[] objArr8 = new Object[1];
                    b(new char[]{0, 0, 0, 0}, new char[]{57943, 3734, 28324, 1319}, (-16777216) - Color.rgb(0, 0, 0), (char) (ViewConfiguration.getKeyRepeatTimeout() >> 16), new char[]{Typography.amp, 36093, 45124, 37072, 28573, 48563, 56095, 10396, 351, 22262, 35689, 45987, 56952, 3001, 56054, 43892, 49432, 25440, 21557, 20165, 21718, 25111, 15797, 54518, 50463, 24760, 1507, 63896, 14246, 58608, 52761, 60991, 18950, 6533, 32437, 40274, 7439, 60775, 21724, 35829, 58959, 61215, 53605, 48394, 50930, 47007, 58255, 18834, 3651, 4793, 17966, 1578, 4689, 54043, 29638, 29327, 28039, 37426, 36518, 62282, 18564, 38924, 1894, 32894}, objArr8);
                    String str2 = (String) objArr8[0];
                    Object[] objArr9 = new Object[1];
                    b(new char[]{0, 0, 0, 0}, new char[]{22217, 54853, 20369, 62422}, (CdmaCellLocation.convertQuartSecToDecDegrees(0) > FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 0 : -1)), (char) TextUtils.getCapsMode("", 0, 0), new char[]{1125, 14157, 62616, 61352, 34712, 30687, 41364, 45931, 31510, 60268, 17960, 15440, 36106, 18382, 24482, 55092, 44805, 46888, 33714, 645, 11935, 2500, 5172, 35635, 34890, 62892, 5830, 1544, 24279, 11020, 43699, 20073, 40329, 46826, 52716, 50591, 57197, 42378, 18487, 14971, 2741, 51591, 7825, 7650, 49014, 26591, 16738, 1890, 60273, 13317, 35672, 40980, 17849, 19607, 62298, 61971, 50918, 41699, 60637, 20243, 33379, 6563, 49949, 8767}, objArr9);
                    String str3 = (String) objArr9[0];
                    Object[] objArr10 = new Object[1];
                    b(new char[]{0, 0, 0, 0}, new char[]{64345, 8296, 10569, 58485}, View.MeasureSpec.getSize(0), (char) TextUtils.getOffsetBefore("", 0), new char[]{23095, 37342, 48613, 44570, 36676, 11185, 12046, 13038, 37619, 42240, 32955, 3, 22128, 23764, 5981, 26207, 23915, 29222, 2142, 31269, 43925, 12614, 41345, 31051, 13603, 29058, 5140, 11490, 41128, 33372, 55556, 29559, 2770, 16634, 46969, 61035, 14673, 38215, 40633, 35786, 39427, 12136, 28336, 3373, 8403, 25866, 48875, 45676, 57462, 30845, 38007, 5741, 11715, 53331, 19655, 56120, 56290, 2130, 62938, 21608}, objArr10);
                    String str4 = (String) objArr10[0];
                    Object[] objArr11 = new Object[1];
                    b(new char[]{0, 0, 0, 0}, new char[]{42568, 3257, 12643, 47373}, Color.argb(0, 0, 0, 0), (char) (3377 - (ViewConfiguration.getScrollDefaultDelay() >> 16)), new char[]{60294, 56050, 62623, 16331, 64952, 11902}, objArr11);
                    try {
                        Object[] objArr12 = {applicationContext, str, str2, str3, str4, true, (String) objArr11[0], 995651014};
                        Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-1276397751);
                        if (obj2 == null) {
                            obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(Color.red(0) + 911, 18 - ExpandableListView.getPackedPositionType(0L), (char) ((-1) - TextUtils.lastIndexOf("", '0', 0)))).getMethod("getAuthRequestContext", Context.class, String.class, String.class, String.class, String.class, Boolean.TYPE, String.class, Integer.TYPE);
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
                a(36, (byte) (-KClassImpl$Data$declaredNonStaticMembers$2[30]), KClassImpl$Data$declaredNonStaticMembers$2[32], objArr13);
                Class<?> cls2 = Class.forName((String) objArr13[0]);
                byte b = (byte) (KClassImpl$Data$declaredNonStaticMembers$2[35] - 1);
                byte b2 = (byte) (-KClassImpl$Data$declaredNonStaticMembers$2[30]);
                Object[] objArr14 = new Object[1];
                a(b, b2, (byte) (b2 + 1), objArr14);
                try {
                    Object[] objArr15 = {applicationContext2, Integer.valueOf(((Integer) cls2.getMethod((String) objArr14[0], Object.class).invoke(null, this)).intValue())};
                    Object obj3 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1691739267);
                    if (obj3 == null) {
                        Class cls3 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(View.combineMeasuredStates(0, 0) + 55, (ViewConfiguration.getTapTimeout() >> 16) + 3, (char) View.MeasureSpec.makeMeasureSpec(0, 0));
                        Object[] objArr16 = new Object[1];
                        c((byte) (-$$a[12]), $$a[47], (byte) (-$$a[53]), objArr16);
                        obj3 = cls3.getMethod((String) objArr16[0], Context.class, Integer.TYPE);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1691739267, obj3);
                    }
                    Object invoke2 = ((Method) obj3).invoke(null, objArr15);
                    try {
                        Object obj4 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(40157535);
                        if (obj4 == null) {
                            obj4 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(800 - View.combineMeasuredStates(0, 0), 14 - MotionEvent.axisFromString(""), (char) (ViewConfiguration.getJumpTapTimeout() >> 16))).getMethod("getAuthRequestContext", null);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(40157535, obj4);
                        }
                        int intValue2 = ((Integer) ((Method) obj4).invoke(invoke2, null)).intValue();
                        try {
                            Object obj5 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1621779126);
                            if (obj5 == null) {
                                obj5 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(800 - Drawable.resolveOpacity(0, 0), 15 - (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)), (char) ExpandableListView.getPackedPositionType(0L))).getMethod("PlaceComponentResult", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1621779126, obj5);
                            }
                            if (((Integer) ((Method) obj5).invoke(invoke2, null)).intValue() != intValue2) {
                                ArrayList arrayList = new ArrayList();
                                try {
                                    Object[] objArr17 = {invoke2};
                                    Object obj6 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(658700871);
                                    if (obj6 == null) {
                                        obj6 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)) + 814, 29 - Drawable.resolveOpacity(0, 0), (char) ((ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)) + 57994))).getMethod("getAuthRequestContext", (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(800 - TextUtils.getOffsetAfter("", 0), (ViewConfiguration.getScrollBarSize() >> 8) + 15, (char) View.resolveSizeAndState(0, 0, 0)));
                                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(658700871, obj6);
                                    }
                                    arrayList.add(((Method) obj6).invoke(null, objArr17));
                                    long j = ((r6 ^ intValue2) & 4294967295L) | 60129542144L;
                                    try {
                                        Object obj7 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                                        if (obj7 != null) {
                                            objArr = null;
                                        } else {
                                            objArr = null;
                                            obj7 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(View.MeasureSpec.getMode(0) + PDF417Common.NUMBER_OF_CODEWORDS, ImageFormat.getBitsPerPixel(0) + 36, (char) ExpandableListView.getPackedPositionType(0L))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj7);
                                        }
                                        Object invoke3 = ((Method) obj7).invoke(objArr, objArr);
                                        try {
                                            Object[] objArr18 = {1626924680, Long.valueOf(j), arrayList, LauncherActivity.getAuid()};
                                            Object obj8 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                            if (obj8 == null) {
                                                obj8 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(Color.blue(0) + 911, 18 - (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)), (char) (ViewConfiguration.getScrollDefaultDelay() >> 16))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                Object[] objArr19 = {this};
                Object[] objArr20 = new Object[1];
                a(36, (byte) (-KClassImpl$Data$declaredNonStaticMembers$2[30]), KClassImpl$Data$declaredNonStaticMembers$2[32], objArr20);
                Class<?> cls4 = Class.forName((String) objArr20[0]);
                byte b3 = (byte) (KClassImpl$Data$declaredNonStaticMembers$2[35] - 1);
                byte b4 = (byte) (-KClassImpl$Data$declaredNonStaticMembers$2[30]);
                Object[] objArr21 = new Object[1];
                a(b3, b4, (byte) (b4 + 1), objArr21);
                try {
                    Object[] objArr22 = {applicationContext3, Integer.valueOf(((Integer) cls4.getMethod((String) objArr21[0], Object.class).invoke(null, objArr19)).intValue())};
                    Object obj9 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(345757441);
                    if (obj9 == null) {
                        Class cls5 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getPressedStateDuration() >> 16) + 61, (ViewConfiguration.getScrollDefaultDelay() >> 16) + 46, (char) (TextUtils.lastIndexOf("", '0') + 1));
                        byte b5 = (byte) ($$b - 3);
                        Object[] objArr23 = new Object[1];
                        c(b5, b5, $$a[20], objArr23);
                        obj9 = cls5.getMethod((String) objArr23[0], Context.class, Integer.TYPE);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(345757441, obj9);
                    }
                    Object[] objArr24 = (Object[]) ((Method) obj9).invoke(null, objArr22);
                    int i = ((int[]) objArr24[1])[0];
                    if (((int[]) objArr24[0])[0] != i) {
                        long j2 = ((r1 ^ i) & 4294967295L) | 17179869184L;
                        try {
                            Object obj10 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                            if (obj10 != null) {
                                objArr4 = null;
                            } else {
                                objArr4 = null;
                                obj10 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getTouchSlop() >> 8) + PDF417Common.NUMBER_OF_CODEWORDS, 35 - (ViewConfiguration.getWindowTouchSlop() >> 8), (char) Color.alpha(0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj10);
                            }
                            Object invoke4 = ((Method) obj10).invoke(objArr4, objArr4);
                            try {
                                Object[] objArr25 = {1626924680, Long.valueOf(j2), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj11 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj11 == null) {
                                    obj11 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(ExpandableListView.getPackedPositionGroup(0L) + 911, AndroidCharacter.getMirror('0') - 30, (char) (ViewConfiguration.getTapTimeout() >> 16))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
                                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1759031285, obj11);
                                }
                                ((Method) obj11).invoke(invoke4, objArr25);
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
                Object[] objArr26 = {this};
                Object[] objArr27 = new Object[1];
                a(36, (byte) (-KClassImpl$Data$declaredNonStaticMembers$2[30]), KClassImpl$Data$declaredNonStaticMembers$2[32], objArr27);
                Class<?> cls6 = Class.forName((String) objArr27[0]);
                byte b6 = (byte) (KClassImpl$Data$declaredNonStaticMembers$2[35] - 1);
                byte b7 = (byte) (-KClassImpl$Data$declaredNonStaticMembers$2[30]);
                Object[] objArr28 = new Object[1];
                a(b6, b7, (byte) (b7 + 1), objArr28);
                try {
                    Object[] objArr29 = {applicationContext4, Integer.valueOf(((Integer) cls6.getMethod((String) objArr28[0], Object.class).invoke(null, objArr26)).intValue())};
                    Object obj12 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-697999596);
                    if (obj12 == null) {
                        Class cls7 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getPressedStateDuration() >> 16) + 118, ExpandableListView.getPackedPositionType(0L) + 3, (char) (38968 - (ViewConfiguration.getKeyRepeatDelay() >> 16)));
                        byte b8 = (byte) ($$b - 3);
                        Object[] objArr30 = new Object[1];
                        c(b8, b8, $$a[20], objArr30);
                        obj12 = cls7.getMethod((String) objArr30[0], Context.class, Integer.TYPE);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(-697999596, obj12);
                    }
                    Object[] objArr31 = (Object[]) ((Method) obj12).invoke(null, objArr29);
                    int i2 = ((int[]) objArr31[1])[0];
                    if (((int[]) objArr31[0])[0] != i2) {
                        long j3 = ((r1 ^ i2) & 4294967295L) | 8589934592L;
                        try {
                            Object obj13 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                            if (obj13 != null) {
                                objArr3 = null;
                            } else {
                                objArr3 = null;
                                obj13 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - (ViewConfiguration.getScrollDefaultDelay() >> 16), 'S' - AndroidCharacter.getMirror('0'), (char) (TextUtils.lastIndexOf("", '0', 0, 0) + 1))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj13);
                            }
                            Object invoke5 = ((Method) obj13).invoke(objArr3, objArr3);
                            try {
                                Object[] objArr32 = {1626924680, Long.valueOf(j3), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj14 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj14 == null) {
                                    obj14 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(AndroidCharacter.getMirror('0') + 863, 18 - Color.argb(0, 0, 0, 0), (char) TextUtils.getOffsetBefore("", 0))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
                                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1759031285, obj14);
                                }
                                ((Method) obj14).invoke(invoke5, objArr32);
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
                Object[] objArr33 = {this};
                Object[] objArr34 = new Object[1];
                a(36, (byte) (-KClassImpl$Data$declaredNonStaticMembers$2[30]), KClassImpl$Data$declaredNonStaticMembers$2[32], objArr34);
                Class<?> cls8 = Class.forName((String) objArr34[0]);
                byte b9 = (byte) (KClassImpl$Data$declaredNonStaticMembers$2[35] - 1);
                byte b10 = (byte) (-KClassImpl$Data$declaredNonStaticMembers$2[30]);
                Object[] objArr35 = new Object[1];
                a(b9, b10, (byte) (b10 + 1), objArr35);
                try {
                    Object[] objArr36 = {applicationContext5, Integer.valueOf(((Integer) cls8.getMethod((String) objArr35[0], Object.class).invoke(null, objArr33)).intValue())};
                    Object obj15 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-16683571);
                    if (obj15 == null) {
                        Class cls9 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(ExpandableListView.getPackedPositionChild(0L) + 108, View.resolveSize(0, 0) + 3, (char) Color.argb(0, 0, 0, 0));
                        Object[] objArr37 = new Object[1];
                        c((byte) (-$$a[9]), (byte) (-$$a[8]), (byte) ($$b - 3), objArr37);
                        obj15 = cls9.getMethod((String) objArr37[0], Context.class, Integer.TYPE);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(-16683571, obj15);
                    }
                    Object[] objArr38 = (Object[]) ((Method) obj15).invoke(null, objArr36);
                    int i3 = ((int[]) objArr38[1])[0];
                    if (((int[]) objArr38[0])[0] != i3) {
                        long j4 = ((r1 ^ i3) & 4294967295L) | 4294967296L;
                        try {
                            Object obj16 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                            if (obj16 != null) {
                                objArr2 = null;
                            } else {
                                objArr2 = null;
                                obj16 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getFadingEdgeLength() >> 16) + PDF417Common.NUMBER_OF_CODEWORDS, 34 - Process.getGidForName(""), (char) View.MeasureSpec.getMode(0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj16);
                            }
                            Object invoke6 = ((Method) obj16).invoke(objArr2, objArr2);
                            try {
                                Object[] objArr39 = {1626924680, Long.valueOf(j4), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj17 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj17 == null) {
                                    obj17 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(((byte) KeyEvent.getModifierMetaStateMask()) + 912, View.MeasureSpec.getMode(0) + 18, (char) (ViewConfiguration.getDoubleTapTimeout() >> 16))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
                                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1759031285, obj17);
                                }
                                ((Method) obj17).invoke(invoke6, objArr39);
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

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.content.ContextWrapper, android.content.Context
    public Context getApplicationContext() {
        return super.getApplicationContext();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.content.ContextWrapper
    public Context getBaseContext() {
        return super.getBaseContext();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public Resources getResources() {
        return super.getResources();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onPause() {
        Context baseContext = getBaseContext();
        if (baseContext == null) {
            char[] cArr = {0, 0, 0, 0};
            char[] cArr2 = {62270, 4355, 12531, 12687};
            try {
                byte b = KClassImpl$Data$declaredNonStaticMembers$2[9];
                byte b2 = KClassImpl$Data$declaredNonStaticMembers$2[25];
                Object[] objArr = new Object[1];
                a(b, b2, b2, objArr);
                Class<?> cls = Class.forName((String) objArr[0]);
                Object[] objArr2 = new Object[1];
                a(KClassImpl$Data$declaredNonStaticMembers$2[59], KClassImpl$Data$declaredNonStaticMembers$2[27], (byte) (-KClassImpl$Data$declaredNonStaticMembers$2[5]), objArr2);
                int i = ((ApplicationInfo) cls.getMethod((String) objArr2[0], null).invoke(this, null)).targetSdkVersion - 33;
                try {
                    byte b3 = KClassImpl$Data$declaredNonStaticMembers$2[9];
                    byte b4 = KClassImpl$Data$declaredNonStaticMembers$2[25];
                    Object[] objArr3 = new Object[1];
                    a(b3, b4, b4, objArr3);
                    Class<?> cls2 = Class.forName((String) objArr3[0]);
                    Object[] objArr4 = new Object[1];
                    a(KClassImpl$Data$declaredNonStaticMembers$2[59], KClassImpl$Data$declaredNonStaticMembers$2[27], (byte) (-KClassImpl$Data$declaredNonStaticMembers$2[5]), objArr4);
                    Object[] objArr5 = new Object[1];
                    b(cArr, cArr2, i, (char) (((ApplicationInfo) cls2.getMethod((String) objArr4[0], null).invoke(this, null)).targetSdkVersion + 36623), new char[]{48916, 62093, 64203, 22036, 57168, 30547, 24007, 56069, 41062, 49024, 23000, 50776, 51191, 9292, 56648, 51173, 63653, 55449, 57410, 53746, 30874, 65197, 52026, 37271, 26184, 57584}, objArr5);
                    Class<?> cls3 = Class.forName((String) objArr5[0]);
                    Object[] objArr6 = new Object[1];
                    b(new char[]{0, 0, 0, 0}, new char[]{44796, 33621, 10455, 34352}, (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)), (char) (super.getResources().getString(id.dana.R.string.deals_online_category_lifestyle_and_other).substring(2, 3).codePointAt(0) + 12220), new char[]{62918, 57798, 21892, 50218, 54610, 18693, 18737, 11579, 61347, 59478, 55579, 27869, 19396, 42122, 32537, 30844, 40689, 33506}, objArr6);
                    baseContext = (Context) cls3.getMethod((String) objArr6[0], new Class[0]).invoke(null, null);
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
        if (baseContext != null) {
            baseContext = baseContext.getApplicationContext();
        }
        if (baseContext != null) {
            try {
                Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                if (obj == null) {
                    obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - (ViewConfiguration.getLongPressTimeout() >> 16), TextUtils.getOffsetBefore("", 0) + 35, (char) ((-1) - TextUtils.lastIndexOf("", '0', 0, 0)))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                }
                Object invoke = ((Method) obj).invoke(null, null);
                try {
                    Object[] objArr7 = {baseContext};
                    Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-549958681);
                    if (obj2 == null) {
                        obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - (ViewConfiguration.getLongPressTimeout() >> 16), 18 - KeyEvent.getDeadChar(0, 0), (char) Drawable.resolveOpacity(0, 0))).getMethod("MyBillsEntityDataFactory", Context.class);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(-549958681, obj2);
                    }
                    ((Method) obj2).invoke(invoke, objArr7);
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
        super.onPause();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onResume() {
        Context baseContext = getBaseContext();
        if (baseContext == null) {
            Object[] objArr = new Object[1];
            b(new char[]{0, 0, 0, 0}, new char[]{62270, 4355, 12531, 12687}, super.getResources().getString(id.dana.R.string.muted_contacts_confirm_dialog_body).substring(59, 64).length() - 5, (char) (36656 - TextUtils.getOffsetAfter("", 0)), new char[]{48916, 62093, 64203, 22036, 57168, 30547, 24007, 56069, 41062, 49024, 23000, 50776, 51191, 9292, 56648, 51173, 63653, 55449, 57410, 53746, 30874, 65197, 52026, 37271, 26184, 57584}, objArr);
            Class<?> cls = Class.forName((String) objArr[0]);
            Object[] objArr2 = new Object[1];
            b(new char[]{0, 0, 0, 0}, new char[]{44796, 33621, 10455, 34352}, ImageFormat.getBitsPerPixel(0) + 1, (char) (MotionEvent.axisFromString("") + 12329), new char[]{62918, 57798, 21892, 50218, 54610, 18693, 18737, 11579, 61347, 59478, 55579, 27869, 19396, 42122, 32537, 30844, 40689, 33506}, objArr2);
            baseContext = (Context) cls.getMethod((String) objArr2[0], new Class[0]).invoke(null, null);
        }
        if (baseContext != null) {
            baseContext = baseContext.getApplicationContext();
        }
        if (baseContext != null) {
            try {
                Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                if (obj == null) {
                    obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)) + PDF417Common.MAX_CODEWORDS_IN_BARCODE, (-16777181) - Color.rgb(0, 0, 0), (char) (ViewConfiguration.getDoubleTapTimeout() >> 16))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                }
                Object invoke = ((Method) obj).invoke(null, null);
                try {
                    Object[] objArr3 = {baseContext};
                    Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(247288059);
                    if (obj2 == null) {
                        obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(910 - TextUtils.indexOf((CharSequence) "", '0', 0, 0), (ViewConfiguration.getScrollBarFadeDuration() >> 16) + 18, (char) (ViewConfiguration.getFadingEdgeLength() >> 16))).getMethod("KClassImpl$Data$declaredNonStaticMembers$2", Context.class);
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
        super.onResume();
    }

    static {
        MyBillsEntityDataFactory();
        DEFAULT_COMPRESS_FORMAT = Bitmap.CompressFormat.JPEG;
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Bitmap.CompressFormat compressFormat;
        Window window;
        Object[] objArr;
        char[] cArr = {0, 0, 0, 0};
        char[] cArr2 = {989, 49725, 22398, 30461};
        int i = 1 - (SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1));
        try {
            byte b = KClassImpl$Data$declaredNonStaticMembers$2[9];
            byte b2 = KClassImpl$Data$declaredNonStaticMembers$2[25];
            Object[] objArr2 = new Object[1];
            a(b, b2, b2, objArr2);
            Class<?> cls = Class.forName((String) objArr2[0]);
            Object[] objArr3 = new Object[1];
            a(KClassImpl$Data$declaredNonStaticMembers$2[59], KClassImpl$Data$declaredNonStaticMembers$2[27], (byte) (-KClassImpl$Data$declaredNonStaticMembers$2[5]), objArr3);
            Object[] objArr4 = new Object[1];
            b(cArr, cArr2, i, (char) (((ApplicationInfo) cls.getMethod((String) objArr3[0], null).invoke(this, null)).targetSdkVersion + 64822), new char[]{29752, 36958, 10244, 37600, 12029, 605, 46089, 22963, 63512, 35022, 53607, 59547, 2074, 14246, 64826, 58185, 4545, 65116}, objArr4);
            Class<?> cls2 = Class.forName((String) objArr4[0]);
            Object[] objArr5 = new Object[1];
            b(new char[]{0, 0, 0, 0}, new char[]{17869, 3907, 57963, 4605}, getPackageName().length() + 1796162366, (char) (super.getResources().getString(id.dana.R.string.soon).substring(0, 1).length() + 64993), new char[]{39456, 10684, 43012, 36953, 46138}, objArr5);
            int intValue = ((Integer) cls2.getDeclaredMethod((String) objArr5[0], new Class[0]).invoke(null, new Object[0])).intValue() % 100000;
            if (intValue < 99000 || intValue > 99999) {
                Context baseContext = getBaseContext();
                if (baseContext == null) {
                    Object[] objArr6 = new Object[1];
                    b(new char[]{0, 0, 0, 0}, new char[]{62270, 4355, 12531, 12687}, (-1) - TextUtils.indexOf((CharSequence) "", '0', 0), (char) ((ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)) + 36655), new char[]{48916, 62093, 64203, 22036, 57168, 30547, 24007, 56069, 41062, 49024, 23000, 50776, 51191, 9292, 56648, 51173, 63653, 55449, 57410, 53746, 30874, 65197, 52026, 37271, 26184, 57584}, objArr6);
                    Class<?> cls3 = Class.forName((String) objArr6[0]);
                    Object[] objArr7 = new Object[1];
                    b(new char[]{0, 0, 0, 0}, new char[]{44796, 33621, 10455, 34352}, TextUtils.lastIndexOf("", '0') + 1, (char) (12328 - KeyEvent.keyCodeFromString("")), new char[]{62918, 57798, 21892, 50218, 54610, 18693, 18737, 11579, 61347, 59478, 55579, 27869, 19396, 42122, 32537, 30844, 40689, 33506}, objArr7);
                    baseContext = (Context) cls3.getMethod((String) objArr7[0], new Class[0]).invoke(null, null);
                }
                if (baseContext != null) {
                    baseContext = baseContext.getApplicationContext();
                }
                if (baseContext != null) {
                    try {
                        Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                        if (obj == null) {
                            obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - TextUtils.getOffsetBefore("", 0), View.combineMeasuredStates(0, 0) + 35, (char) (ViewConfiguration.getPressedStateDuration() >> 16))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                        }
                        Object invoke = ((Method) obj).invoke(null, null);
                        Object[] objArr8 = new Object[1];
                        b(new char[]{0, 0, 0, 0}, new char[]{11955, 58550, 15924, 60696}, super.getResources().getString(id.dana.R.string.ep_paylater_activation_tnc_remark).substring(39, 40).codePointAt(0) - 32, (char) (super.getResources().getString(id.dana.R.string.pop_up_description_saving_limit_about_info).substring(14, 15).codePointAt(0) - 32), new char[]{50219, 33060, 44102, 37070, 28454, 42371, 50716, 38792, 7641, 33632, 12436, 18141, 58962, 8235, 43790, 62754, 31910, 40778, 40152, 65294, 26725, 46052, 10552, 14361, 10640, 43191, 20747, 58443, 33504, 23628, 52697, 57537, 31437, 43259, 50738, 28968, 2394, 750, 27064, 39335, 45351, 47240, 13121, 27366, 36928, 27226, 14424, 3645}, objArr8);
                        String str = (String) objArr8[0];
                        char[] cArr3 = {0, 0, 0, 0};
                        char[] cArr4 = {57943, 3734, 28324, 1319};
                        try {
                            byte b3 = KClassImpl$Data$declaredNonStaticMembers$2[9];
                            byte b4 = KClassImpl$Data$declaredNonStaticMembers$2[25];
                            Object[] objArr9 = new Object[1];
                            a(b3, b4, b4, objArr9);
                            Class<?> cls4 = Class.forName((String) objArr9[0]);
                            a(KClassImpl$Data$declaredNonStaticMembers$2[59], KClassImpl$Data$declaredNonStaticMembers$2[27], (byte) (-KClassImpl$Data$declaredNonStaticMembers$2[5]), new Object[1]);
                            Object[] objArr10 = new Object[1];
                            b(cArr3, cArr4, ((ApplicationInfo) cls4.getMethod((String) r9[0], null).invoke(this, null)).targetSdkVersion - 33, (char) (getPackageName().codePointAt(5) - 110), new char[]{Typography.amp, 36093, 45124, 37072, 28573, 48563, 56095, 10396, 351, 22262, 35689, 45987, 56952, 3001, 56054, 43892, 49432, 25440, 21557, 20165, 21718, 25111, 15797, 54518, 50463, 24760, 1507, 63896, 14246, 58608, 52761, 60991, 18950, 6533, 32437, 40274, 7439, 60775, 21724, 35829, 58959, 61215, 53605, 48394, 50930, 47007, 58255, 18834, 3651, 4793, 17966, 1578, 4689, 54043, 29638, 29327, 28039, 37426, 36518, 62282, 18564, 38924, 1894, 32894}, objArr10);
                            String str2 = (String) objArr10[0];
                            char[] cArr5 = {0, 0, 0, 0};
                            char[] cArr6 = {22217, 54853, 20369, 62422};
                            int codePointAt = getPackageName().codePointAt(5) - 110;
                            try {
                                byte b5 = KClassImpl$Data$declaredNonStaticMembers$2[9];
                                byte b6 = KClassImpl$Data$declaredNonStaticMembers$2[25];
                                Object[] objArr11 = new Object[1];
                                a(b5, b6, b6, objArr11);
                                Class<?> cls5 = Class.forName((String) objArr11[0]);
                                a(KClassImpl$Data$declaredNonStaticMembers$2[59], KClassImpl$Data$declaredNonStaticMembers$2[27], (byte) (-KClassImpl$Data$declaredNonStaticMembers$2[5]), new Object[1]);
                                Object[] objArr12 = new Object[1];
                                b(cArr5, cArr6, codePointAt, (char) (((ApplicationInfo) cls5.getMethod((String) r0[0], null).invoke(this, null)).targetSdkVersion - 33), new char[]{1125, 14157, 62616, 61352, 34712, 30687, 41364, 45931, 31510, 60268, 17960, 15440, 36106, 18382, 24482, 55092, 44805, 46888, 33714, 645, 11935, 2500, 5172, 35635, 34890, 62892, 5830, 1544, 24279, 11020, 43699, 20073, 40329, 46826, 52716, 50591, 57197, 42378, 18487, 14971, 2741, 51591, 7825, 7650, 49014, 26591, 16738, 1890, 60273, 13317, 35672, 40980, 17849, 19607, 62298, 61971, 50918, 41699, 60637, 20243, 33379, 6563, 49949, 8767}, objArr12);
                                String str3 = (String) objArr12[0];
                                char[] cArr7 = {0, 0, 0, 0};
                                char[] cArr8 = {64345, 8296, 10569, 58485};
                                try {
                                    byte b7 = KClassImpl$Data$declaredNonStaticMembers$2[9];
                                    byte b8 = KClassImpl$Data$declaredNonStaticMembers$2[25];
                                    Object[] objArr13 = new Object[1];
                                    a(b7, b8, b8, objArr13);
                                    Class<?> cls6 = Class.forName((String) objArr13[0]);
                                    a(KClassImpl$Data$declaredNonStaticMembers$2[59], KClassImpl$Data$declaredNonStaticMembers$2[27], (byte) (-KClassImpl$Data$declaredNonStaticMembers$2[5]), new Object[1]);
                                    Object[] objArr14 = new Object[1];
                                    b(cArr7, cArr8, ((ApplicationInfo) cls6.getMethod((String) r13[0], null).invoke(this, null)).targetSdkVersion - 33, (char) ((Process.getThreadPriority(0) + 20) >> 6), new char[]{23095, 37342, 48613, 44570, 36676, 11185, 12046, 13038, 37619, 42240, 32955, 3, 22128, 23764, 5981, 26207, 23915, 29222, 2142, 31269, 43925, 12614, 41345, 31051, 13603, 29058, 5140, 11490, 41128, 33372, 55556, 29559, 2770, 16634, 46969, 61035, 14673, 38215, 40633, 35786, 39427, 12136, 28336, 3373, 8403, 25866, 48875, 45676, 57462, 30845, 38007, 5741, 11715, 53331, 19655, 56120, 56290, 2130, 62938, 21608}, objArr14);
                                    String str4 = (String) objArr14[0];
                                    Object[] objArr15 = new Object[1];
                                    b(new char[]{0, 0, 0, 0}, new char[]{42568, 3257, 12643, 47373}, KeyEvent.getMaxKeyCode() >> 16, (char) (Drawable.resolveOpacity(0, 0) + 3377), new char[]{60294, 56050, 62623, 16331, 64952, 11902}, objArr15);
                                    try {
                                        Object[] objArr16 = {baseContext, str, str2, str3, str4, true, (String) objArr15[0], 995651014};
                                        Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-1276397751);
                                        if (obj2 == null) {
                                            obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getMaximumDrawingCacheSize() >> 24) + 911, 18 - KeyEvent.getDeadChar(0, 0), (char) (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)))).getMethod("getAuthRequestContext", Context.class, String.class, String.class, String.class, String.class, Boolean.TYPE, String.class, Integer.TYPE);
                                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(-1276397751, obj2);
                                        }
                                        ((Method) obj2).invoke(invoke, objArr16);
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
            }
            try {
                Object[] objArr17 = new Object[1];
                a(36, (byte) (-KClassImpl$Data$declaredNonStaticMembers$2[30]), KClassImpl$Data$declaredNonStaticMembers$2[32], objArr17);
                Class<?> cls7 = Class.forName((String) objArr17[0]);
                byte b9 = (byte) (KClassImpl$Data$declaredNonStaticMembers$2[35] - 1);
                byte b10 = (byte) (-KClassImpl$Data$declaredNonStaticMembers$2[30]);
                Object[] objArr18 = new Object[1];
                a(b9, b10, (byte) (b10 + 1), objArr18);
                try {
                    Object[] objArr19 = {Integer.valueOf(((Integer) cls7.getMethod((String) objArr18[0], Object.class).invoke(null, this)).intValue())};
                    Object obj3 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(25207140);
                    if (obj3 == null) {
                        Class cls8 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(View.MeasureSpec.getSize(0) + 494, (ViewConfiguration.getKeyRepeatTimeout() >> 16) + 4, (char) (CdmaCellLocation.convertQuartSecToDecDegrees(0) > FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 0 : -1)));
                        Object[] objArr20 = new Object[1];
                        c((byte) (-$$a[9]), (byte) (-$$a[8]), (byte) ($$b - 3), objArr20);
                        obj3 = cls8.getMethod((String) objArr20[0], Integer.TYPE);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(25207140, obj3);
                    }
                    Object[] objArr21 = (Object[]) ((Method) obj3).invoke(null, objArr19);
                    int i2 = ((int[]) objArr21[1])[0];
                    if (((int[]) objArr21[0])[0] != i2) {
                        long j = ((r0 ^ i2) & 4294967295L) | 42949672960L;
                        try {
                            Object obj4 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                            if (obj4 != null) {
                                objArr = null;
                            } else {
                                objArr = null;
                                obj4 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - KeyEvent.getDeadChar(0, 0), TextUtils.getOffsetBefore("", 0) + 35, (char) (1 - (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1))))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj4);
                            }
                            Object invoke2 = ((Method) obj4).invoke(objArr, objArr);
                            try {
                                Object[] objArr22 = {1422509577, Long.valueOf(j), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj5 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj5 == null) {
                                    obj5 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getEdgeSlop() >> 16) + 911, (ViewConfiguration.getEdgeSlop() >> 16) + 18, (char) (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
                                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1759031285, obj5);
                                }
                                ((Method) obj5).invoke(invoke2, objArr22);
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
                    super.onCreate(bundle);
                    setContentView(R.layout.ucrop_activity_photobox);
                    Intent intent = getIntent();
                    this.FragmentBottomSheetPaymentSettingBinding = intent.getIntExtra("com.yalantis.ucrop.StatusBarColor", ContextCompat.BuiltInFictitiousFunctionClassFactory(this, R.color.getErrorConfigVersion_res_0x7f06032e));
                    this.SubSequence = intent.getIntExtra("com.yalantis.ucrop.ToolbarColor", ContextCompat.BuiltInFictitiousFunctionClassFactory(this, R.color.lookAheadTest_res_0x7f06032f));
                    this.PlaceComponentResult = intent.getIntExtra("com.yalantis.ucrop.UcropColorWidgetActive", ContextCompat.BuiltInFictitiousFunctionClassFactory(this, R.color.initRecordTimeStamp));
                    this.whenAvailable = intent.getIntExtra("com.yalantis.ucrop.UcropToolbarWidgetColor", ContextCompat.BuiltInFictitiousFunctionClassFactory(this, R.color.moveToNextValue_res_0x7f060330));
                    this.NetworkUserEntityData$$ExternalSyntheticLambda5 = intent.getIntExtra("com.yalantis.ucrop.UcropToolbarCancelDrawable", R.drawable.ucrop_ic_cross);
                    this.readMicros = intent.getIntExtra("com.yalantis.ucrop.UcropToolbarCropDrawable", R.drawable.res_0x7f080dca_kclassimpl_data_declarednonstaticmembers_2);
                    String stringExtra = intent.getStringExtra("com.yalantis.ucrop.UcropToolbarTitleText");
                    this.getCallingPid = stringExtra;
                    if (stringExtra == null) {
                        stringExtra = getResources().getString(R.string.ucrop_label_edit_photo);
                    }
                    this.getCallingPid = stringExtra;
                    this.newProxyInstance = intent.getIntExtra("com.yalantis.ucrop.UcropLogoColor", ContextCompat.BuiltInFictitiousFunctionClassFactory(this, R.color.getAuthRequestContext_res_0x7f06032c));
                    this.PrepareContext = !intent.getBooleanExtra("com.yalantis.ucrop.HideBottomControls", false);
                    this.isLayoutRequested = intent.getIntExtra("com.yalantis.ucrop.UcropRootViewBackgroundColor", ContextCompat.BuiltInFictitiousFunctionClassFactory(this, R.color.BuiltInFictitiousFunctionClassFactory_res_0x7f060328));
                    int i3 = this.FragmentBottomSheetPaymentSettingBinding;
                    if (Build.VERSION.SDK_INT >= 21 && (window = getWindow()) != null) {
                        window.addFlags(Integer.MIN_VALUE);
                        window.setStatusBarColor(i3);
                    }
                    Toolbar toolbar = (Toolbar) findViewById(R.id.PrepareContext);
                    toolbar.setBackgroundColor(this.SubSequence);
                    toolbar.setTitleTextColor(this.whenAvailable);
                    TextView textView = (TextView) toolbar.findViewById(R.id.newProxyInstance);
                    textView.setTextColor(this.whenAvailable);
                    textView.setText(this.getCallingPid);
                    Drawable mutate = ContextCompat.PlaceComponentResult(this, this.NetworkUserEntityData$$ExternalSyntheticLambda5).mutate();
                    mutate.setColorFilter(this.whenAvailable, PorterDuff.Mode.SRC_ATOP);
                    toolbar.setNavigationIcon(mutate);
                    setSupportActionBar(toolbar);
                    ActionBar supportActionBar = getSupportActionBar();
                    if (supportActionBar != null) {
                        supportActionBar.getErrorConfigVersion();
                    }
                    UCropView uCropView = (UCropView) findViewById(R.id.res_0x7f0a1989_networkuserentitydata_externalsyntheticlambda7);
                    this.getSupportButtonTintMode = uCropView;
                    this.GetContactSyncConfig = uCropView.getCropImageView();
                    this.NetworkUserEntityData$$ExternalSyntheticLambda8 = this.getSupportButtonTintMode.getOverlayView();
                    this.GetContactSyncConfig.setTransformImageListener(this.NetworkUserEntityData$$ExternalSyntheticLambda1);
                    ((ImageView) findViewById(R.id.image_view_logo)).setColorFilter(this.newProxyInstance, PorterDuff.Mode.SRC_ATOP);
                    findViewById(R.id.FragmentBottomSheetPaymentSettingBinding_res_0x7f0a198a).setBackgroundColor(this.isLayoutRequested);
                    if (this.PrepareContext) {
                        View.inflate(this, R.layout.res_0x7f0d0461_kclassimpl_data_declarednonstaticmembers_2, (ViewGroup) findViewById(R.id.res_0x7f0a198b_networkuserentitydata_externalsyntheticlambda5));
                        ViewGroup viewGroup = (ViewGroup) findViewById(R.id.state_aspect_ratio);
                        this.B = viewGroup;
                        viewGroup.setOnClickListener(this.NetworkUserEntityData$$ExternalSyntheticLambda3);
                        ViewGroup viewGroup2 = (ViewGroup) findViewById(R.id.initRecordTimeStamp_res_0x7f0a1271);
                        this.BottomSheetCardBindingView$watcherCardNumberView$1 = viewGroup2;
                        viewGroup2.setOnClickListener(this.NetworkUserEntityData$$ExternalSyntheticLambda3);
                        ViewGroup viewGroup3 = (ViewGroup) findViewById(R.id.res_0x7f0a1272_networkuserentitydata_externalsyntheticlambda2);
                        this.VerifyPinStateManager$executeRiskChallenge$2$1 = viewGroup3;
                        viewGroup3.setOnClickListener(this.NetworkUserEntityData$$ExternalSyntheticLambda3);
                        this.NetworkUserEntityData$$ExternalSyntheticLambda2 = (ViewGroup) findViewById(R.id.layout_aspect_ratio);
                        this.initRecordTimeStamp = (ViewGroup) findViewById(R.id.layout_rotate_wheel);
                        this.DatabaseTableConfigUtil = (ViewGroup) findViewById(R.id.layout_scale_wheel);
                        int intExtra = intent.getIntExtra("com.yalantis.ucrop.AspectRatioSelectedByDefault", 0);
                        ArrayList parcelableArrayListExtra = intent.getParcelableArrayListExtra("com.yalantis.ucrop.AspectRatioOptions");
                        if (parcelableArrayListExtra == null || parcelableArrayListExtra.isEmpty()) {
                            parcelableArrayListExtra = new ArrayList();
                            parcelableArrayListExtra.add(new AspectRatio(null, 1.0f, 1.0f));
                            parcelableArrayListExtra.add(new AspectRatio(null, 3.0f, 4.0f));
                            parcelableArrayListExtra.add(new AspectRatio(getString(R.string.res_0x7f131846_kclassimpl_data_declarednonstaticmembers_2).toUpperCase(), 0.0f, 0.0f));
                            parcelableArrayListExtra.add(new AspectRatio(null, 3.0f, 2.0f));
                            parcelableArrayListExtra.add(new AspectRatio(null, 16.0f, 9.0f));
                            intExtra = 2;
                        }
                        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.layout_aspect_ratio);
                        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -1);
                        layoutParams.weight = 1.0f;
                        Iterator it = parcelableArrayListExtra.iterator();
                        while (it.hasNext()) {
                            AspectRatio aspectRatio = (AspectRatio) it.next();
                            FrameLayout frameLayout = (FrameLayout) getLayoutInflater().inflate(R.layout.ucrop_aspect_ratio, (ViewGroup) null);
                            frameLayout.setLayoutParams(layoutParams);
                            AspectRatioTextView aspectRatioTextView = (AspectRatioTextView) frameLayout.getChildAt(0);
                            aspectRatioTextView.setActiveColor(this.PlaceComponentResult);
                            aspectRatioTextView.setAspectRatio(aspectRatio);
                            linearLayout.addView(frameLayout);
                            this.scheduleImpl.add(frameLayout);
                        }
                        compressFormat = null;
                        this.scheduleImpl.get(intExtra).setSelected(true);
                        Iterator<ViewGroup> it2 = this.scheduleImpl.iterator();
                        while (it2.hasNext()) {
                            it2.next().setOnClickListener(new View.OnClickListener() { // from class: com.yalantis.ucrop.UCropActivity.2
                                @Override // android.view.View.OnClickListener
                                public void onClick(View view) {
                                    UCropActivity.this.GetContactSyncConfig.setTargetAspectRatio(((AspectRatioTextView) ((ViewGroup) view).getChildAt(0)).getAspectRatio(view.isSelected()));
                                    UCropActivity.this.GetContactSyncConfig.setImageToWrapCropBounds();
                                    if (view.isSelected()) {
                                        return;
                                    }
                                    for (ViewGroup viewGroup4 : UCropActivity.this.scheduleImpl) {
                                        viewGroup4.setSelected(viewGroup4 == view);
                                    }
                                }
                            });
                        }
                        this.NetworkUserEntityData$$ExternalSyntheticLambda6 = (TextView) findViewById(R.id.res_0x7f0a1305_networkuserentitydata_externalsyntheticlambda8);
                        ((HorizontalProgressWheelView) findViewById(R.id.res_0x7f0a10cd_networkuserentitydata_externalsyntheticlambda1)).setScrollingListener(new HorizontalProgressWheelView.ScrollingListener() { // from class: com.yalantis.ucrop.UCropActivity.3
                            @Override // com.yalantis.ucrop.view.widget.HorizontalProgressWheelView.ScrollingListener
                            public final void MyBillsEntityDataFactory(float f) {
                                UCropActivity.this.GetContactSyncConfig.postRotate(f / 42.0f);
                            }

                            @Override // com.yalantis.ucrop.view.widget.HorizontalProgressWheelView.ScrollingListener
                            public final void MyBillsEntityDataFactory() {
                                UCropActivity.this.GetContactSyncConfig.setImageToWrapCropBounds();
                            }

                            @Override // com.yalantis.ucrop.view.widget.HorizontalProgressWheelView.ScrollingListener
                            public final void KClassImpl$Data$declaredNonStaticMembers$2() {
                                UCropActivity.this.GetContactSyncConfig.cancelAllAnimations();
                            }
                        });
                        ((HorizontalProgressWheelView) findViewById(R.id.res_0x7f0a10cd_networkuserentitydata_externalsyntheticlambda1)).setMiddleLineColor(this.PlaceComponentResult);
                        findViewById(R.id.res_0x7f0a1bf2_networkuserentitydata_externalsyntheticlambda4).setOnClickListener(new View.OnClickListener() { // from class: com.yalantis.ucrop.UCropActivity.4
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view) {
                                UCropActivity.access$700(UCropActivity.this);
                            }
                        });
                        findViewById(R.id.res_0x7f0a1bf3_networkuserentitydata_externalsyntheticlambda3).setOnClickListener(new View.OnClickListener() { // from class: com.yalantis.ucrop.UCropActivity.5
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view) {
                                UCropActivity.access$800(UCropActivity.this, 90);
                            }
                        });
                        this.NetworkUserEntityData$$ExternalSyntheticLambda4 = (TextView) findViewById(R.id.text_view_scale);
                        ((HorizontalProgressWheelView) findViewById(R.id.scale_scroll_wheel)).setScrollingListener(new HorizontalProgressWheelView.ScrollingListener() { // from class: com.yalantis.ucrop.UCropActivity.6
                            @Override // com.yalantis.ucrop.view.widget.HorizontalProgressWheelView.ScrollingListener
                            public final void MyBillsEntityDataFactory(float f) {
                                if (f > 0.0f) {
                                    UCropActivity.this.GetContactSyncConfig.zoomInImage(UCropActivity.this.GetContactSyncConfig.getCurrentScale() + (f * ((UCropActivity.this.GetContactSyncConfig.getMaxScale() - UCropActivity.this.GetContactSyncConfig.getMinScale()) / 15000.0f)));
                                } else {
                                    UCropActivity.this.GetContactSyncConfig.zoomOutImage(UCropActivity.this.GetContactSyncConfig.getCurrentScale() + (f * ((UCropActivity.this.GetContactSyncConfig.getMaxScale() - UCropActivity.this.GetContactSyncConfig.getMinScale()) / 15000.0f)));
                                }
                            }

                            @Override // com.yalantis.ucrop.view.widget.HorizontalProgressWheelView.ScrollingListener
                            public final void MyBillsEntityDataFactory() {
                                UCropActivity.this.GetContactSyncConfig.setImageToWrapCropBounds();
                            }

                            @Override // com.yalantis.ucrop.view.widget.HorizontalProgressWheelView.ScrollingListener
                            public final void KClassImpl$Data$declaredNonStaticMembers$2() {
                                UCropActivity.this.GetContactSyncConfig.cancelAllAnimations();
                            }
                        });
                        ((HorizontalProgressWheelView) findViewById(R.id.scale_scroll_wheel)).setMiddleLineColor(this.PlaceComponentResult);
                        ImageView imageView = (ImageView) findViewById(R.id.image_view_state_scale);
                        ImageView imageView2 = (ImageView) findViewById(R.id.res_0x7f0a08db_kclassimpl_data_declarednonstaticmembers_2);
                        ImageView imageView3 = (ImageView) findViewById(R.id.image_view_state_aspect_ratio);
                        imageView.setImageDrawable(new SelectedStateListDrawable(imageView.getDrawable(), this.PlaceComponentResult));
                        imageView2.setImageDrawable(new SelectedStateListDrawable(imageView2.getDrawable(), this.PlaceComponentResult));
                        imageView3.setImageDrawable(new SelectedStateListDrawable(imageView3.getDrawable(), this.PlaceComponentResult));
                    } else {
                        compressFormat = null;
                    }
                    Uri uri = (Uri) intent.getParcelableExtra("com.yalantis.ucrop.InputUri");
                    Uri uri2 = (Uri) intent.getParcelableExtra("com.yalantis.ucrop.OutputUri");
                    String stringExtra2 = intent.getStringExtra("com.yalantis.ucrop.CompressionFormatName");
                    Bitmap.CompressFormat valueOf = !TextUtils.isEmpty(stringExtra2) ? Bitmap.CompressFormat.valueOf(stringExtra2) : compressFormat;
                    if (valueOf == null) {
                        valueOf = DEFAULT_COMPRESS_FORMAT;
                    }
                    this.getErrorConfigVersion = valueOf;
                    this.moveToNextValue = intent.getIntExtra("com.yalantis.ucrop.CompressionQuality", 90);
                    int[] intArrayExtra = intent.getIntArrayExtra("com.yalantis.ucrop.AllowedGestures");
                    if (intArrayExtra != null && intArrayExtra.length == 3) {
                        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = intArrayExtra;
                    }
                    this.GetContactSyncConfig.setMaxBitmapSize(intent.getIntExtra("com.yalantis.ucrop.MaxBitmapSize", 0));
                    this.GetContactSyncConfig.setMaxScaleMultiplier(intent.getFloatExtra("com.yalantis.ucrop.MaxScaleMultiplier", 10.0f));
                    this.GetContactSyncConfig.setImageToWrapCropBoundsAnimDuration(intent.getIntExtra("com.yalantis.ucrop.ImageToCropBoundsAnimDuration", 500));
                    this.NetworkUserEntityData$$ExternalSyntheticLambda8.setFreestyleCropEnabled(intent.getBooleanExtra("com.yalantis.ucrop.FreeStyleCrop", false));
                    this.NetworkUserEntityData$$ExternalSyntheticLambda8.setDimmedColor(intent.getIntExtra("com.yalantis.ucrop.DimmedLayerColor", getResources().getColor(R.color.MyBillsEntityDataFactory_res_0x7f06032b)));
                    this.NetworkUserEntityData$$ExternalSyntheticLambda8.setCircleDimmedLayer(intent.getBooleanExtra("com.yalantis.ucrop.CircleDimmedLayer", false));
                    this.NetworkUserEntityData$$ExternalSyntheticLambda8.setShowCropFrame(intent.getBooleanExtra("com.yalantis.ucrop.ShowCropFrame", true));
                    this.NetworkUserEntityData$$ExternalSyntheticLambda8.setCropFrameColor(intent.getIntExtra("com.yalantis.ucrop.CropFrameColor", getResources().getColor(R.color.PlaceComponentResult_res_0x7f060329)));
                    this.NetworkUserEntityData$$ExternalSyntheticLambda8.setCropFrameStrokeWidth(intent.getIntExtra("com.yalantis.ucrop.CropFrameStrokeWidth", getResources().getDimensionPixelSize(R.dimen.getAuthRequestContext_res_0x7f0703d4)));
                    this.NetworkUserEntityData$$ExternalSyntheticLambda8.setShowCropGrid(intent.getBooleanExtra("com.yalantis.ucrop.ShowCropGrid", true));
                    this.NetworkUserEntityData$$ExternalSyntheticLambda8.setCropGridRowCount(intent.getIntExtra("com.yalantis.ucrop.CropGridRowCount", 2));
                    this.NetworkUserEntityData$$ExternalSyntheticLambda8.setCropGridColumnCount(intent.getIntExtra("com.yalantis.ucrop.CropGridColumnCount", 2));
                    this.NetworkUserEntityData$$ExternalSyntheticLambda8.setCropGridColor(intent.getIntExtra("com.yalantis.ucrop.CropGridColor", getResources().getColor(R.color.res_0x7f06032a_kclassimpl_data_declarednonstaticmembers_2)));
                    this.NetworkUserEntityData$$ExternalSyntheticLambda8.setCropGridStrokeWidth(intent.getIntExtra("com.yalantis.ucrop.CropGridStrokeWidth", getResources().getDimensionPixelSize(R.dimen.res_0x7f0703d5_kclassimpl_data_declarednonstaticmembers_2)));
                    float floatExtra = intent.getFloatExtra("com.yalantis.ucrop.AspectRatioX", 0.0f);
                    float floatExtra2 = intent.getFloatExtra("com.yalantis.ucrop.AspectRatioY", 0.0f);
                    int intExtra2 = intent.getIntExtra("com.yalantis.ucrop.AspectRatioSelectedByDefault", 0);
                    ArrayList parcelableArrayListExtra2 = intent.getParcelableArrayListExtra("com.yalantis.ucrop.AspectRatioOptions");
                    if (floatExtra > 0.0f && floatExtra2 > 0.0f) {
                        ViewGroup viewGroup4 = this.B;
                        if (viewGroup4 != null) {
                            viewGroup4.setVisibility(8);
                        }
                        this.GetContactSyncConfig.setTargetAspectRatio(floatExtra / floatExtra2);
                    } else if (parcelableArrayListExtra2 != null && intExtra2 < parcelableArrayListExtra2.size()) {
                        this.GetContactSyncConfig.setTargetAspectRatio(((AspectRatio) parcelableArrayListExtra2.get(intExtra2)).BuiltInFictitiousFunctionClassFactory / ((AspectRatio) parcelableArrayListExtra2.get(intExtra2)).KClassImpl$Data$declaredNonStaticMembers$2);
                    } else {
                        this.GetContactSyncConfig.setTargetAspectRatio(0.0f);
                    }
                    int intExtra3 = intent.getIntExtra("com.yalantis.ucrop.MaxSizeX", 0);
                    int intExtra4 = intent.getIntExtra("com.yalantis.ucrop.MaxSizeY", 0);
                    if (intExtra3 > 0 && intExtra4 > 0) {
                        this.GetContactSyncConfig.setMaxResultImageSizeX(intExtra3);
                        this.GetContactSyncConfig.setMaxResultImageSizeY(intExtra4);
                    }
                    if (uri != null && uri2 != null) {
                        try {
                            this.GetContactSyncConfig.setImageUri(uri, uri2);
                        } catch (Exception e) {
                            setResultError(e);
                            finish();
                        }
                    } else {
                        setResultError(new NullPointerException(getString(R.string.ucrop_error_input_data_is_absent)));
                        finish();
                    }
                    if (this.PrepareContext) {
                        if (this.B.getVisibility() == 0) {
                            MyBillsEntityDataFactory(R.id.state_aspect_ratio);
                        } else {
                            MyBillsEntityDataFactory(R.id.res_0x7f0a1272_networkuserentitydata_externalsyntheticlambda2);
                        }
                    } else {
                        PlaceComponentResult(0);
                    }
                    if (this.lookAheadTest == null) {
                        this.lookAheadTest = new View(this);
                        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -1);
                        layoutParams2.addRule(3, R.id.PrepareContext);
                        this.lookAheadTest.setLayoutParams(layoutParams2);
                        this.lookAheadTest.setClickable(true);
                    }
                    ((RelativeLayout) findViewById(R.id.res_0x7f0a198b_networkuserentitydata_externalsyntheticlambda5)).addView(this.lookAheadTest);
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
        } catch (Throwable th10) {
            Throwable cause10 = th10.getCause();
            if (cause10 == null) {
                throw th10;
            }
            throw cause10;
        }
    }

    @Override // android.app.Activity
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.res_0x7f0e0008_kclassimpl_data_declarednonstaticmembers_2, menu);
        MenuItem findItem = menu.findItem(R.id.menu_loader);
        Drawable icon = findItem.getIcon();
        if (icon != null) {
            try {
                icon.mutate();
                icon.setColorFilter(this.whenAvailable, PorterDuff.Mode.SRC_ATOP);
                findItem.setIcon(icon);
            } catch (IllegalStateException e) {
                InstrumentInjector.log_i("UCropActivity", String.format("%s - %s", e.getMessage(), getString(R.string.ucrop_mutate_exception_hint)));
            }
            ((Animatable) findItem.getIcon()).start();
        }
        MenuItem findItem2 = menu.findItem(R.id.res_0x7f0a0e95_networkuserentitydata_externalsyntheticlambda0);
        Drawable PlaceComponentResult = ContextCompat.PlaceComponentResult(this, this.readMicros);
        if (PlaceComponentResult != null) {
            PlaceComponentResult.mutate();
            PlaceComponentResult.setColorFilter(this.whenAvailable, PorterDuff.Mode.SRC_ATOP);
            findItem2.setIcon(PlaceComponentResult);
        }
        return true;
    }

    @Override // android.app.Activity
    public boolean onPrepareOptionsMenu(Menu menu) {
        menu.findItem(R.id.res_0x7f0a0e95_networkuserentitydata_externalsyntheticlambda0).setVisible(!this.NetworkUserEntityData$$ExternalSyntheticLambda7);
        menu.findItem(R.id.menu_loader).setVisible(this.NetworkUserEntityData$$ExternalSyntheticLambda7);
        return super.onPrepareOptionsMenu(menu);
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() == R.id.res_0x7f0a0e95_networkuserentitydata_externalsyntheticlambda0) {
            cropAndSaveImage();
        } else if (menuItem.getItemId() == 16908332) {
            onBackPressed();
        }
        return super.onOptionsItemSelected(menuItem);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        GestureCropImageView gestureCropImageView = this.GetContactSyncConfig;
        if (gestureCropImageView != null) {
            gestureCropImageView.cancelAllAnimations();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void MyBillsEntityDataFactory(int i) {
        if (this.PrepareContext) {
            this.B.setSelected(i == R.id.state_aspect_ratio);
            this.BottomSheetCardBindingView$watcherCardNumberView$1.setSelected(i == R.id.initRecordTimeStamp_res_0x7f0a1271);
            this.VerifyPinStateManager$executeRiskChallenge$2$1.setSelected(i == R.id.res_0x7f0a1272_networkuserentitydata_externalsyntheticlambda2);
            this.NetworkUserEntityData$$ExternalSyntheticLambda2.setVisibility(i == R.id.state_aspect_ratio ? 0 : 8);
            this.initRecordTimeStamp.setVisibility(i == R.id.initRecordTimeStamp_res_0x7f0a1271 ? 0 : 8);
            this.DatabaseTableConfigUtil.setVisibility(i == R.id.res_0x7f0a1272_networkuserentitydata_externalsyntheticlambda2 ? 0 : 8);
            if (i == R.id.res_0x7f0a1272_networkuserentitydata_externalsyntheticlambda2) {
                PlaceComponentResult(0);
            } else if (i == R.id.initRecordTimeStamp_res_0x7f0a1271) {
                PlaceComponentResult(1);
            } else {
                PlaceComponentResult(2);
            }
        }
    }

    private void PlaceComponentResult(int i) {
        GestureCropImageView gestureCropImageView = this.GetContactSyncConfig;
        int i2 = this.NetworkUserEntityData$$ExternalSyntheticLambda0[i];
        gestureCropImageView.setScaleEnabled(i2 == 3 || i2 == 1);
        GestureCropImageView gestureCropImageView2 = this.GetContactSyncConfig;
        int i3 = this.NetworkUserEntityData$$ExternalSyntheticLambda0[i];
        gestureCropImageView2.setRotateEnabled(i3 == 3 || i3 == 2);
    }

    protected void cropAndSaveImage() {
        this.lookAheadTest.setClickable(true);
        this.NetworkUserEntityData$$ExternalSyntheticLambda7 = true;
        supportInvalidateOptionsMenu();
        this.GetContactSyncConfig.cropAndSaveImage(this.getErrorConfigVersion, this.moveToNextValue, new BitmapCropCallback() { // from class: com.yalantis.ucrop.UCropActivity.8
            @Override // com.yalantis.ucrop.callback.BitmapCropCallback
            public final void BuiltInFictitiousFunctionClassFactory(Uri uri, int i, int i2, int i3, int i4) {
                UCropActivity uCropActivity = UCropActivity.this;
                uCropActivity.setResultUri(uri, uCropActivity.GetContactSyncConfig.getTargetAspectRatio(), i, i2, i3, i4);
                UCropActivity.this.finish();
            }

            @Override // com.yalantis.ucrop.callback.BitmapCropCallback
            public final void PlaceComponentResult(Throwable th) {
                UCropActivity.this.setResultError(th);
                UCropActivity.this.finish();
            }
        });
    }

    protected void setResultUri(Uri uri, float f, int i, int i2, int i3, int i4) {
        setResult(-1, new Intent().putExtra("com.yalantis.ucrop.OutputUri", uri).putExtra("com.yalantis.ucrop.CropAspectRatio", f).putExtra("com.yalantis.ucrop.ImageWidth", i3).putExtra("com.yalantis.ucrop.ImageHeight", i4).putExtra("com.yalantis.ucrop.OffsetX", i).putExtra("com.yalantis.ucrop.OffsetY", i2));
    }

    protected void setResultError(Throwable th) {
        setResult(96, new Intent().putExtra("com.yalantis.ucrop.Error", th));
    }

    static /* synthetic */ void access$000(UCropActivity uCropActivity, float f) {
        TextView textView = uCropActivity.NetworkUserEntityData$$ExternalSyntheticLambda6;
        if (textView != null) {
            textView.setText(String.format(Locale.getDefault(), "%.1f°", Float.valueOf(f)));
        }
    }

    static /* synthetic */ void access$100(UCropActivity uCropActivity, float f) {
        TextView textView = uCropActivity.NetworkUserEntityData$$ExternalSyntheticLambda4;
        if (textView != null) {
            textView.setText(String.format(Locale.getDefault(), "%d%%", Integer.valueOf((int) (f * 100.0f))));
        }
    }

    static /* synthetic */ void access$700(UCropActivity uCropActivity) {
        GestureCropImageView gestureCropImageView = uCropActivity.GetContactSyncConfig;
        gestureCropImageView.postRotate(-gestureCropImageView.getCurrentAngle());
        uCropActivity.GetContactSyncConfig.setImageToWrapCropBounds();
    }

    static /* synthetic */ void access$800(UCropActivity uCropActivity, int i) {
        uCropActivity.GetContactSyncConfig.postRotate(i);
        uCropActivity.GetContactSyncConfig.setImageToWrapCropBounds();
    }

    private static void b(char[] cArr, char[] cArr2, int i, char c, char[] cArr3, Object[] objArr) {
        E e = new E();
        int length = cArr2.length;
        char[] cArr4 = new char[length];
        int length2 = cArr.length;
        char[] cArr5 = new char[length2];
        System.arraycopy(cArr2, 0, cArr4, 0, length);
        System.arraycopy(cArr, 0, cArr5, 0, length2);
        cArr4[0] = (char) (cArr4[0] ^ c);
        cArr5[2] = (char) (cArr5[2] + ((char) i));
        int length3 = cArr3.length;
        char[] cArr6 = new char[length3];
        e.KClassImpl$Data$declaredNonStaticMembers$2 = 0;
        while (e.KClassImpl$Data$declaredNonStaticMembers$2 < length3) {
            int i2 = (e.KClassImpl$Data$declaredNonStaticMembers$2 + 2) % 4;
            int i3 = (e.KClassImpl$Data$declaredNonStaticMembers$2 + 3) % 4;
            e.MyBillsEntityDataFactory = (char) (((cArr4[e.KClassImpl$Data$declaredNonStaticMembers$2 % 4] * 32718) + cArr5[i2]) % 65535);
            cArr5[i3] = (char) (((cArr4[i3] * 32718) + cArr5[i2]) / 65535);
            cArr4[i3] = e.MyBillsEntityDataFactory;
            cArr6[e.KClassImpl$Data$declaredNonStaticMembers$2] = (char) ((((cArr4[i3] ^ cArr3[e.KClassImpl$Data$declaredNonStaticMembers$2]) ^ (C ^ 4360990799332652212L)) ^ ((int) (A ^ 4360990799332652212L))) ^ ((char) (D ^ 4360990799332652212L)));
            e.KClassImpl$Data$declaredNonStaticMembers$2++;
        }
        objArr[0] = new String(cArr6);
    }
}
