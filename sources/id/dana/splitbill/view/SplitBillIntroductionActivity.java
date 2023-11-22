package id.dana.splitbill.view;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.ImageFormat;
import android.graphics.PointF;
import android.media.AudioTrack;
import android.os.Bundle;
import android.os.Process;
import android.os.SystemClock;
import android.telephony.cdma.CdmaCellLocation;
import android.text.AndroidCharacter;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.Button;
import android.widget.ExpandableListView;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.OnClick;
import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.alibaba.wireless.security.SecExceptionCode;
import com.google.common.base.Ascii;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.google.zxing.pdf417.PDF417Common;
import dagger.internal.Preconditions;
import id.dana.R;
import id.dana.analytics.tracker.TrackerKey;
import id.dana.base.AbstractContractKt;
import id.dana.base.BaseActivity;
import id.dana.di.component.ApplicationComponent;
import id.dana.di.component.DaggerSplitBillIntroductionComponent;
import id.dana.di.component.SplitBillIntroductionComponent;
import id.dana.di.modules.BottomSheetOnBoardingModule;
import id.dana.di.modules.SplitBillIntroductionModule;
import id.dana.onboarding.splash.LauncherActivity;
import id.dana.requestmoney.model.RequestMoneyInfoModel;
import id.dana.showcase.AbstractOnShowcaseStateListener;
import id.dana.showcase.Content;
import id.dana.showcase.Showcase;
import id.dana.showcase.SimpleShowcaseBuilder;
import id.dana.showcase.shape.CircleShape;
import id.dana.showcase.target.Target;
import id.dana.showcase.target.TargetBuilder;
import id.dana.splitbill.SplitBillIntroductionContract;
import id.dana.splitbill.tracker.SplitBillAnalyticTracker;
import id.dana.splitbill.view.SplitBillHistoryView;
import id.dana.usereducation.BottomSheetHelpActivity;
import id.dana.usereducation.BottomSheetOnBoardingActivity;
import id.dana.usereducation.BottomSheetOnBoardingContract;
import id.dana.usereducation.constant.BottomSheetType;
import id.dana.usereducation.model.ContentOnBoardingModel;
import id.dana.usereducation.model.OnBoardingModel;
import id.dana.utils.RandomInteger;
import id.dana.utils.SizeUtil;
import id.dana.utils.foundation.logger.log.DanaLog;
import id.dana.utils.foundation.logger.log.DanaLogConstants;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import o.BottomSheetCardBindingView$watcherCardNumberView$1;
import o.SummaryVoucherView$$ExternalSyntheticLambda0;

/* loaded from: classes5.dex */
public class SplitBillIntroductionActivity extends BaseActivity implements SplitBillIntroductionContract.View {
    private static char[] DatabaseTableConfigUtil;
    private static boolean GetContactSyncConfig;
    private static boolean PrepareContext;
    public static final int SPOTLIGHT_SIZE;
    private static int initRecordTimeStamp;
    private static final int lookAheadTest;
    private List<ContentOnBoardingModel> NetworkUserEntityData$$ExternalSyntheticLambda0;
    private RequestMoneyInfoModel NetworkUserEntityData$$ExternalSyntheticLambda1;
    private Showcase NetworkUserEntityData$$ExternalSyntheticLambda2;
    @BindView(R.id.btn_split_bill_entry)
    Button btnSplitBillEntry;
    SplitBillIntroductionComponent component;
    private int getErrorConfigVersion;
    @Inject
    BottomSheetOnBoardingContract.Presenter onBoardingPresenter;
    @Inject
    SplitBillIntroductionContract.Presenter presenter;
    @BindView(R.id.right_button)
    TextView rightButton;
    @BindView(R.id.sbhv_bill_histories)
    SplitBillHistoryView sbhvBillHistories;
    private boolean scheduleImpl;
    @Inject
    SplitBillAnalyticTracker splitBillAnalyticTracker;
    public static final byte[] $$a = {Ascii.EM, 16, -94, Ascii.FS, -51, TarHeader.LF_NORMAL, -46, -10, -7, -14, 39, -48, -13, 4, -18, -12, 46, -36, -26, 12, Ascii.DC4, -34, -9, -24, -2, -10, -14, -5, -22, 44, -59, -6, 5, 15, -26, -19, -11, 9, -21, -8, 42, -51, -6, -13, 8, -26, -3, 1, -48, 4, -25, -7, 35, -43, -10, -3, 65, -39, -36, -26, 12, TarHeader.LF_FIFO, -71, -8, -5, -16, 4, -24, 6, -6, 15, -40, -6, Ascii.DC4, -40, 12, -26, 4, -1, 15, -31, -15, 4, -10, -20, -8, 72, -21};
    public static final int $$b = 234;
    public static final byte[] PlaceComponentResult = {75, -120, 119, 39, 17, -6, 18, 1, -2, -1, -50, 57, 16, 3, 10, -11, 13, 10, -66, Ascii.EM, TarHeader.LF_NORMAL, 3, 10, -11, Ascii.ETB, 0, -1, 5, 13, 10, -7, 15, 9, -45, Ascii.GS, 22, -7, -33, TarHeader.LF_NORMAL, -7, 5, -5, Ascii.EM, -17, -47, 66, -7, 17, -3, -53, 41, 42, -2, 5, -11, 12, 2, 19, -47, TarHeader.LF_CHR, 4, 0, 1, -2, 2, Ascii.ETB, -7, 10, 3, -33, 41, -4, 13};
    public static final int getAuthRequestContext = 232;

    static void PlaceComponentResult() {
        DatabaseTableConfigUtil = new char[]{39812, 39929, 39811, 39925, 39926, 39932, 39865, 39927, 39844, 39810, 39923, 39921, 39916, 39827, 39935, 39808, 39920, 39931, 39922, 39831, 39928, 39824, 39854, 39857, 39855, 39863, 39852, 39809, 39861, 39860, 39858, 39859, 39813, 39856, 39853, 39862, 39934, 39924};
        GetContactSyncConfig = true;
        PrepareContext = true;
        initRecordTimeStamp = 909155175;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0026  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x001e  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0026 -> B:11:0x0032). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void b(byte r6, short r7, short r8, java.lang.Object[] r9) {
        /*
            int r6 = r6 + 97
            int r7 = 23 - r7
            byte[] r0 = id.dana.splitbill.view.SplitBillIntroductionActivity.PlaceComponentResult
            int r8 = 55 - r8
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
            int r8 = r8 + 1
            byte r4 = (byte) r6
            r1[r3] = r4
            if (r3 != r7) goto L26
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            r9[r2] = r6
            return
        L26:
            int r3 = r3 + 1
            r4 = r0[r8]
            r5 = r8
            r8 = r7
            r7 = r4
            r4 = r3
            r3 = r1
            r1 = r0
            r0 = r9
            r9 = r5
        L32:
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
        throw new UnsupportedOperationException("Method not decompiled: id.dana.splitbill.view.SplitBillIntroductionActivity.b(byte, short, short, java.lang.Object[]):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0029  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0021  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0029 -> B:11:0x0036). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void c(int r6, int r7, int r8, java.lang.Object[] r9) {
        /*
            int r7 = r7 + 4
            byte[] r0 = id.dana.splitbill.view.SplitBillIntroductionActivity.$$a
            int r6 = r6 * 3
            int r6 = 42 - r6
            int r8 = r8 * 2
            int r8 = r8 + 75
            byte[] r1 = new byte[r6]
            int r6 = r6 + (-1)
            r2 = 0
            if (r0 != 0) goto L1b
            r3 = r1
            r4 = 0
            r1 = r0
            r0 = r9
            r9 = r8
            r8 = r7
            r7 = r6
            goto L36
        L1b:
            r3 = 0
        L1c:
            byte r4 = (byte) r8
            r1[r3] = r4
            if (r3 != r6) goto L29
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            r9[r2] = r6
            return
        L29:
            int r3 = r3 + 1
            r4 = r0[r7]
            r5 = r7
            r7 = r6
            r6 = r4
            r4 = r3
            r3 = r1
            r1 = r0
            r0 = r9
            r9 = r8
            r8 = r5
        L36:
            int r6 = -r6
            int r9 = r9 + r6
            int r6 = r9 + (-7)
            int r8 = r8 + 1
            r9 = r0
            r0 = r1
            r1 = r3
            r3 = r4
            r5 = r8
            r8 = r6
            r6 = r7
            r7 = r5
            goto L1c
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.splitbill.view.SplitBillIntroductionActivity.c(int, int, int, java.lang.Object[]):void");
    }

    @Override // id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper
    public void attachBaseContext(Context context) {
        Object[] objArr;
        Object[] objArr2;
        Object[] objArr3;
        Object[] objArr4;
        super.attachBaseContext(context);
        Object[] objArr5 = new Object[1];
        a(null, Color.blue(0) + 127, new byte[]{-109, -109, -112, -118, -123, -124, -108, -121, -109, -123, -121, -125, -122, -123, -124, -125, -126, -127}, null, objArr5);
        Class<?> cls = Class.forName((String) objArr5[0]);
        Object[] objArr6 = new Object[1];
        a(null, 126 - (ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)), new byte[]{-125, -122, -106, -115, -107}, null, objArr6);
        int intValue = ((Integer) cls.getDeclaredMethod((String) objArr6[0], new Class[0]).invoke(null, new Object[0])).intValue() % 100000;
        if (intValue < 99000 || intValue > 99999) {
            Context applicationContext = context != null ? context.getApplicationContext() : context;
            if (applicationContext != null) {
                try {
                    Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                    if (obj == null) {
                        obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(TextUtils.indexOf("", "") + PDF417Common.NUMBER_OF_CODEWORDS, 35 - ((Process.getThreadPriority(0) + 20) >> 6), (char) ((Process.getThreadPriority(0) + 20) >> 6))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                    }
                    Object invoke = ((Method) obj).invoke(null, null);
                    Object[] objArr7 = new Object[1];
                    a(null, 127 - (Process.myTid() >> 22), new byte[]{-112, -104, -97, -95, -104, -96, -100, -105, -102, -103, -101, -100, -101, -99, -104, -101, -112, -127, -125, -99, -125, -103, -97, -125, -104, -118, -118, -125, -127, -104, -98, -98, -104, -98, -99, -112, -100, -118, -112, -105, -103, -101, -125, -102, -103, -104, -118, -105}, null, objArr7);
                    String str = (String) objArr7[0];
                    Object[] objArr8 = new Object[1];
                    a(null, (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)) + 127, new byte[]{-97, -125, -103, -98, -95, -118, -98, -102, -98, -102, -105, -101, -101, -105, -97, -97, -105, -98, -105, -118, -98, -112, -102, -94, -97, -102, -118, -118, -103, -96, -125, -118, -99, -99, -125, -103, -112, -101, -95, -104, -97, -104, -98, -125, -98, -100, -99, -99, -96, -98, -98, -125, -94, -101, -118, -125, -103, -102, -101, -100, -125, -104, -94, -127}, null, objArr8);
                    String str2 = (String) objArr8[0];
                    Object[] objArr9 = new Object[1];
                    a(null, (SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)) + 126, new byte[]{-101, -94, -94, -100, -104, -101, -94, -105, -94, -100, -98, -99, -112, -118, -101, -100, -95, -127, -102, -103, -96, -98, -100, -103, -103, -104, -105, -95, -103, -99, -125, -105, -118, -105, -100, -100, -103, -101, -100, -105, -97, -127, -95, -99, -125, -96, -112, -127, -105, -102, -97, -98, -98, -103, -103, -103, -96, -99, -105, -101, -95, -112, -98, -99}, null, objArr9);
                    String str3 = (String) objArr9[0];
                    Object[] objArr10 = new Object[1];
                    a(null, 126 - TextUtils.lastIndexOf("", '0', 0, 0), new byte[]{-109, -117, -126, -112, -116, -112, -92, -99, -116, -92, -117, -109, -112, -91, -126, -122, -92, -122, -120, -127, -92, -107, -123, -118, -121, -112, -124, -127, -111, -90, -109, -125, -124, -127, -111, -91, -121, -117, -109, -127, -118, -117, -127, -112, -124, -113, -117, -121, -127, -126, -127, -125, -92, -92, -93, -109, -120, -117, -117, -113}, null, objArr10);
                    String str4 = (String) objArr10[0];
                    Object[] objArr11 = new Object[1];
                    a(null, (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)) + 127, new byte[]{-98, -99, -121, -96, -121, -101}, null, objArr11);
                    try {
                        Object[] objArr12 = {applicationContext, str, str2, str3, str4, true, (String) objArr11[0], 995651014};
                        Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-1276397751);
                        if (obj2 == null) {
                            obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(910 - Process.getGidForName(""), TextUtils.getOffsetAfter("", 0) + 18, (char) View.getDefaultSize(0, 0))).getMethod("getAuthRequestContext", Context.class, String.class, String.class, String.class, String.class, Boolean.TYPE, String.class, Integer.TYPE);
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
                b(PlaceComponentResult[32], (byte) (-PlaceComponentResult[30]), PlaceComponentResult[31], objArr13);
                Class<?> cls2 = Class.forName((String) objArr13[0]);
                Object[] objArr14 = new Object[1];
                b((byte) (getAuthRequestContext & 30), (byte) (-PlaceComponentResult[30]), (byte) (PlaceComponentResult[34] + 1), objArr14);
                try {
                    Object[] objArr15 = {applicationContext2, Integer.valueOf(((Integer) cls2.getMethod((String) objArr14[0], Object.class).invoke(null, this)).intValue())};
                    Object obj3 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1691739267);
                    if (obj3 == null) {
                        Class cls3 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)) + 55, (ViewConfiguration.getKeyRepeatTimeout() >> 16) + 3, (char) (ViewConfiguration.getScrollBarFadeDuration() >> 16));
                        Object[] objArr16 = new Object[1];
                        c($$a[68], (byte) ($$a[47] - 1), $$a[47], objArr16);
                        obj3 = cls3.getMethod((String) objArr16[0], Context.class, Integer.TYPE);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1691739267, obj3);
                    }
                    Object invoke2 = ((Method) obj3).invoke(null, objArr15);
                    try {
                        Object obj4 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(40157535);
                        if (obj4 == null) {
                            obj4 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1)) + SecExceptionCode.SEC_ERROR_STA_KEY_ENC_UNKNOWN_ERROR, 15 - View.getDefaultSize(0, 0), (char) (TextUtils.indexOf((CharSequence) "", '0', 0, 0) + 1))).getMethod("getAuthRequestContext", null);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(40157535, obj4);
                        }
                        int intValue2 = ((Integer) ((Method) obj4).invoke(invoke2, null)).intValue();
                        try {
                            Object obj5 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1621779126);
                            if (obj5 == null) {
                                obj5 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getFadingEdgeLength() >> 16) + 800, 15 - View.MeasureSpec.makeMeasureSpec(0, 0), (char) (ViewConfiguration.getScrollBarFadeDuration() >> 16))).getMethod("PlaceComponentResult", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1621779126, obj5);
                            }
                            if (((Integer) ((Method) obj5).invoke(invoke2, null)).intValue() != intValue2) {
                                ArrayList arrayList = new ArrayList();
                                try {
                                    Object[] objArr17 = {invoke2};
                                    Object obj6 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(658700871);
                                    if (obj6 == null) {
                                        obj6 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getPressedStateDuration() >> 16) + 815, ExpandableListView.getPackedPositionType(0L) + 29, (char) (57994 - TextUtils.getTrimmedLength("")))).getMethod("getAuthRequestContext", (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getKeyRepeatTimeout() >> 16) + 800, 14 - ImageFormat.getBitsPerPixel(0), (char) (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1))));
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
                                            obj7 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getKeyRepeatTimeout() >> 16) + PDF417Common.NUMBER_OF_CODEWORDS, (KeyEvent.getMaxKeyCode() >> 16) + 35, (char) (CdmaCellLocation.convertQuartSecToDecDegrees(0) > FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 0 : -1)))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj7);
                                        }
                                        Object invoke3 = ((Method) obj7).invoke(objArr, objArr);
                                        try {
                                            Object[] objArr18 = {-285163653, Long.valueOf(j), arrayList, LauncherActivity.getAuid()};
                                            Object obj8 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                            if (obj8 == null) {
                                                obj8 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(Color.argb(0, 0, 0, 0) + 911, ((Process.getThreadPriority(0) + 20) >> 6) + 18, (char) ((-1) - TextUtils.indexOf((CharSequence) "", '0', 0)))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                b(PlaceComponentResult[32], (byte) (-PlaceComponentResult[30]), PlaceComponentResult[31], objArr19);
                Class<?> cls4 = Class.forName((String) objArr19[0]);
                Object[] objArr20 = new Object[1];
                b((byte) (getAuthRequestContext & 30), (byte) (-PlaceComponentResult[30]), (byte) (PlaceComponentResult[34] + 1), objArr20);
                try {
                    Object[] objArr21 = {applicationContext3, Integer.valueOf(((Integer) cls4.getMethod((String) objArr20[0], Object.class).invoke(null, this)).intValue())};
                    Object obj9 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(345757441);
                    if (obj9 == null) {
                        Class cls5 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(61 - (ViewConfiguration.getEdgeSlop() >> 16), Color.argb(0, 0, 0, 0) + 46, (char) (ViewConfiguration.getFadingEdgeLength() >> 16));
                        byte b = (byte) (-$$a[8]);
                        Object[] objArr22 = new Object[1];
                        c(b, (byte) (b | 16), (byte) (-$$a[9]), objArr22);
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
                                obj10 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)), View.getDefaultSize(0, 0) + 35, (char) View.resolveSize(0, 0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj10);
                            }
                            Object invoke4 = ((Method) obj10).invoke(objArr4, objArr4);
                            try {
                                Object[] objArr24 = {-285163653, Long.valueOf(j2), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj11 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj11 == null) {
                                    obj11 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getJumpTapTimeout() >> 16) + 911, (SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)) + 17, (char) (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                b(PlaceComponentResult[32], (byte) (-PlaceComponentResult[30]), PlaceComponentResult[31], objArr25);
                Class<?> cls6 = Class.forName((String) objArr25[0]);
                Object[] objArr26 = new Object[1];
                b((byte) (getAuthRequestContext & 30), (byte) (-PlaceComponentResult[30]), (byte) (PlaceComponentResult[34] + 1), objArr26);
                try {
                    Object[] objArr27 = {applicationContext4, Integer.valueOf(((Integer) cls6.getMethod((String) objArr26[0], Object.class).invoke(null, this)).intValue())};
                    Object obj12 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-697999596);
                    if (obj12 == null) {
                        Class cls7 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(119 - (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)), TextUtils.indexOf((CharSequence) "", '0', 0) + 4, (char) (38969 - (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1))));
                        byte b2 = (byte) (-$$a[8]);
                        Object[] objArr28 = new Object[1];
                        c(b2, (byte) (b2 | 16), (byte) (-$$a[9]), objArr28);
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
                                obj13 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(TextUtils.getOffsetBefore("", 0) + PDF417Common.NUMBER_OF_CODEWORDS, MotionEvent.axisFromString("") + 36, (char) (ViewConfiguration.getScrollBarFadeDuration() >> 16))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj13);
                            }
                            Object invoke5 = ((Method) obj13).invoke(objArr3, objArr3);
                            try {
                                Object[] objArr30 = {-285163653, Long.valueOf(j3), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj14 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj14 == null) {
                                    obj14 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getPressedStateDuration() >> 16) + 911, (ViewConfiguration.getMaximumDrawingCacheSize() >> 24) + 18, (char) ExpandableListView.getPackedPositionType(0L))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                b(PlaceComponentResult[32], (byte) (-PlaceComponentResult[30]), PlaceComponentResult[31], objArr31);
                Class<?> cls8 = Class.forName((String) objArr31[0]);
                Object[] objArr32 = new Object[1];
                b((byte) (getAuthRequestContext & 30), (byte) (-PlaceComponentResult[30]), (byte) (PlaceComponentResult[34] + 1), objArr32);
                try {
                    Object[] objArr33 = {applicationContext5, Integer.valueOf(((Integer) cls8.getMethod((String) objArr32[0], Object.class).invoke(null, this)).intValue())};
                    Object obj15 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-16683571);
                    if (obj15 == null) {
                        Class cls9 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(TextUtils.indexOf((CharSequence) "", '0', 0, 0) + 108, (CdmaCellLocation.convertQuartSecToDecDegrees(0) > FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 0 : -1)) + 3, (char) (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)));
                        Object[] objArr34 = new Object[1];
                        c((byte) ($$a[47] - 1), (byte) (-$$a[53]), (byte) ($$a[47] - 1), objArr34);
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
                                obj16 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)) + PDF417Common.MAX_CODEWORDS_IN_BARCODE, (ViewConfiguration.getPressedStateDuration() >> 16) + 35, (char) KeyEvent.normalizeMetaState(0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj16);
                            }
                            Object invoke6 = ((Method) obj16).invoke(objArr2, objArr2);
                            try {
                                Object[] objArr36 = {-285163653, Long.valueOf(j4), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj17 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj17 == null) {
                                    obj17 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)), Color.argb(0, 0, 0, 0) + 18, (char) Gravity.getAbsoluteGravity(0, 0))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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

    @Override // id.dana.base.AbstractContract.AbstractView
    public void dismissProgress() {
    }

    @Override // id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.content.ContextWrapper, android.content.Context
    public Context getApplicationContext() {
        return super.getApplicationContext();
    }

    @Override // id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.content.ContextWrapper
    public Context getBaseContext() {
        return super.getBaseContext();
    }

    @Override // id.dana.base.BaseActivity
    public int getLayout() {
        return R.layout.activity_split_bill_introduction;
    }

    @Override // id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public Resources getResources() {
        return super.getResources();
    }

    @Override // id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Object[] objArr;
        Object[] objArr2 = new Object[1];
        a(null, super.getResources().getString(R.string.invalid_phone_number).substring(14, 15).length() + 126, new byte[]{-109, -109, -112, -118, -123, -124, -108, -121, -109, -123, -121, -125, -122, -123, -124, -125, -126, -127}, null, objArr2);
        Class<?> cls = Class.forName((String) objArr2[0]);
        Object[] objArr3 = new Object[1];
        a(null, getPackageName().codePointAt(1) + 27, new byte[]{-125, -122, -106, -115, -107}, null, objArr3);
        int intValue = ((Integer) cls.getDeclaredMethod((String) objArr3[0], new Class[0]).invoke(null, new Object[0])).intValue() % 100000;
        if (intValue < 99000 || intValue > 99999) {
            Context baseContext = getBaseContext();
            if (baseContext == null) {
                try {
                    byte b = PlaceComponentResult[25];
                    byte b2 = b;
                    Object[] objArr4 = new Object[1];
                    b(b, b2, (byte) (b2 | TarHeader.LF_BLK), objArr4);
                    Class<?> cls2 = Class.forName((String) objArr4[0]);
                    Object[] objArr5 = new Object[1];
                    b((byte) (-PlaceComponentResult[5]), PlaceComponentResult[27], PlaceComponentResult[25], objArr5);
                    Object[] objArr6 = new Object[1];
                    a(null, ((ApplicationInfo) cls2.getMethod((String) objArr5[0], null).invoke(this, null)).targetSdkVersion + 94, new byte[]{-125, -127, -112, -124, -113, -114, -115, -117, -122, -116, -122, -117, -118, -119, -121, -120, -120, -127, -121, -125, -122, -123, -124, -125, -126, -127}, null, objArr6);
                    Class<?> cls3 = Class.forName((String) objArr6[0]);
                    Object[] objArr7 = new Object[1];
                    a(null, (SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)) + 126, new byte[]{-126, -123, -122, -117, -127, -118, -122, -110, -120, -120, -119, -117, -126, -112, -124, -124, -111, -118}, null, objArr7);
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
                        obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - (ViewConfiguration.getJumpTapTimeout() >> 16), (ViewConfiguration.getEdgeSlop() >> 16) + 35, (char) ((Process.getThreadPriority(0) + 20) >> 6))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                    }
                    Object invoke = ((Method) obj).invoke(null, null);
                    Object[] objArr8 = new Object[1];
                    a(null, 126 - TextUtils.indexOf((CharSequence) "", '0', 0, 0), new byte[]{-112, -104, -97, -95, -104, -96, -100, -105, -102, -103, -101, -100, -101, -99, -104, -101, -112, -127, -125, -99, -125, -103, -97, -125, -104, -118, -118, -125, -127, -104, -98, -98, -104, -98, -99, -112, -100, -118, -112, -105, -103, -101, -125, -102, -103, -104, -118, -105}, null, objArr8);
                    String str = (String) objArr8[0];
                    Object[] objArr9 = new Object[1];
                    a(null, super.getResources().getString(R.string.feed_notification_read_all_visible_success).substring(5, 6).codePointAt(0) + 12, new byte[]{-97, -125, -103, -98, -95, -118, -98, -102, -98, -102, -105, -101, -101, -105, -97, -97, -105, -98, -105, -118, -98, -112, -102, -94, -97, -102, -118, -118, -103, -96, -125, -118, -99, -99, -125, -103, -112, -101, -95, -104, -97, -104, -98, -125, -98, -100, -99, -99, -96, -98, -98, -125, -94, -101, -118, -125, -103, -102, -101, -100, -125, -104, -94, -127}, null, objArr9);
                    String str2 = (String) objArr9[0];
                    Object[] objArr10 = new Object[1];
                    a(null, super.getResources().getString(R.string.intro_3_title).substring(0, 1).length() + 126, new byte[]{-101, -94, -94, -100, -104, -101, -94, -105, -94, -100, -98, -99, -112, -118, -101, -100, -95, -127, -102, -103, -96, -98, -100, -103, -103, -104, -105, -95, -103, -99, -125, -105, -118, -105, -100, -100, -103, -101, -100, -105, -97, -127, -95, -99, -125, -96, -112, -127, -105, -102, -97, -98, -98, -103, -103, -103, -96, -99, -105, -101, -95, -112, -98, -99}, null, objArr10);
                    String str3 = (String) objArr10[0];
                    Object[] objArr11 = new Object[1];
                    a(null, 127 - TextUtils.getOffsetAfter("", 0), new byte[]{-109, -117, -126, -112, -116, -112, -92, -99, -116, -92, -117, -109, -112, -91, -126, -122, -92, -122, -120, -127, -92, -107, -123, -118, -121, -112, -124, -127, -111, -90, -109, -125, -124, -127, -111, -91, -121, -117, -109, -127, -118, -117, -127, -112, -124, -113, -117, -121, -127, -126, -127, -125, -92, -92, -93, -109, -120, -117, -117, -113}, null, objArr11);
                    String str4 = (String) objArr11[0];
                    Object[] objArr12 = new Object[1];
                    a(null, super.getResources().getString(R.string.i_agree_check_box_desc).substring(6, 7).length() + 126, new byte[]{-98, -99, -121, -96, -121, -101}, null, objArr12);
                    try {
                        Object[] objArr13 = {baseContext, str, str2, str3, str4, true, (String) objArr12[0], 995651014};
                        Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-1276397751);
                        if (obj2 == null) {
                            obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)) + 910, Color.rgb(0, 0, 0) + 16777234, (char) (ViewConfiguration.getMaximumFlingVelocity() >> 16))).getMethod("getAuthRequestContext", Context.class, String.class, String.class, String.class, String.class, Boolean.TYPE, String.class, Integer.TYPE);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(-1276397751, obj2);
                        }
                        ((Method) obj2).invoke(invoke, objArr13);
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
            b(PlaceComponentResult[32], (byte) (-PlaceComponentResult[30]), PlaceComponentResult[31], objArr14);
            Class<?> cls4 = Class.forName((String) objArr14[0]);
            Object[] objArr15 = new Object[1];
            b((byte) (getAuthRequestContext & 30), (byte) (-PlaceComponentResult[30]), (byte) (PlaceComponentResult[34] + 1), objArr15);
            try {
                Object[] objArr16 = {Integer.valueOf(((Integer) cls4.getMethod((String) objArr15[0], Object.class).invoke(null, this)).intValue())};
                Object obj3 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(25207140);
                if (obj3 == null) {
                    Class cls5 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(TextUtils.indexOf("", "", 0, 0) + 494, TextUtils.indexOf((CharSequence) "", '0', 0) + 5, (char) ExpandableListView.getPackedPositionType(0L));
                    Object[] objArr17 = new Object[1];
                    c((byte) ($$a[47] - 1), (byte) (-$$a[53]), (byte) ($$a[47] - 1), objArr17);
                    obj3 = cls5.getMethod((String) objArr17[0], Integer.TYPE);
                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(25207140, obj3);
                }
                Object[] objArr18 = (Object[]) ((Method) obj3).invoke(null, objArr16);
                int i = ((int[]) objArr18[1])[0];
                if (((int[]) objArr18[0])[0] != i) {
                    long j = ((r2 ^ i) & 4294967295L) | 42949672960L;
                    try {
                        Object obj4 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                        if (obj4 != null) {
                            objArr = null;
                        } else {
                            objArr = null;
                            obj4 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getLongPressTimeout() >> 16) + PDF417Common.NUMBER_OF_CODEWORDS, AndroidCharacter.getMirror('0') - '\r', (char) (ViewConfiguration.getScrollDefaultDelay() >> 16))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj4);
                        }
                        Object invoke2 = ((Method) obj4).invoke(objArr, objArr);
                        try {
                            Object[] objArr19 = {694790160, Long.valueOf(j), new ArrayList(), LauncherActivity.getAuid()};
                            Object obj5 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                            if (obj5 == null) {
                                obj5 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getTouchSlop() >> 8) + 911, ImageFormat.getBitsPerPixel(0) + 19, (char) TextUtils.getCapsMode("", 0, 0))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
    }

    @Override // id.dana.base.AbstractContract.AbstractView
    public void onError(String str) {
    }

    @Override // id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onPause() {
        Context baseContext = getBaseContext();
        if (baseContext == null) {
            Object[] objArr = new Object[1];
            a(null, super.getResources().getString(R.string.label_distance).substring(0, 8).codePointAt(2) + 12, new byte[]{-125, -127, -112, -124, -113, -114, -115, -117, -122, -116, -122, -117, -118, -119, -121, -120, -120, -127, -121, -125, -122, -123, -124, -125, -126, -127}, null, objArr);
            Class<?> cls = Class.forName((String) objArr[0]);
            Object[] objArr2 = new Object[1];
            a(null, 127 - (ViewConfiguration.getScrollBarFadeDuration() >> 16), new byte[]{-126, -123, -122, -117, -127, -118, -122, -110, -120, -120, -119, -117, -126, -112, -124, -124, -111, -118}, null, objArr2);
            baseContext = (Context) cls.getMethod((String) objArr2[0], new Class[0]).invoke(null, null);
        }
        if (baseContext != null) {
            baseContext = baseContext.getApplicationContext();
        }
        if (baseContext != null) {
            try {
                Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                if (obj == null) {
                    obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getEdgeSlop() >> 16) + PDF417Common.NUMBER_OF_CODEWORDS, (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)) + 35, (char) (Process.getGidForName("") + 1))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                }
                Object invoke = ((Method) obj).invoke(null, null);
                try {
                    Object[] objArr3 = {baseContext};
                    Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-549958681);
                    if (obj2 == null) {
                        obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(910 - TextUtils.lastIndexOf("", '0', 0), (ViewConfiguration.getKeyRepeatTimeout() >> 16) + 18, (char) (ViewConfiguration.getTapTimeout() >> 16))).getMethod("MyBillsEntityDataFactory", Context.class);
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

    @Override // id.dana.base.AbstractContract.AbstractView
    public void showProgress() {
    }

    static {
        PlaceComponentResult();
        SPOTLIGHT_SIZE = SizeUtil.getAuthRequestContext(20);
        lookAheadTest = RandomInteger.BuiltInFictitiousFunctionClassFactory();
    }

    @Override // id.dana.base.BaseActivity
    public void configToolbar() {
        setCenterTitle(getString(R.string.split_bill_title));
        setMenuLeftButton(R.drawable.arrow_left_white);
        setMenuRightButton(R.drawable.ic_tooltip_help);
    }

    @Override // id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onResume() {
        Context baseContext = getBaseContext();
        if (baseContext == null) {
            Object[] objArr = new Object[1];
            a(null, getPackageName().length() + 120, new byte[]{-125, -127, -112, -124, -113, -114, -115, -117, -122, -116, -122, -117, -118, -119, -121, -120, -120, -127, -121, -125, -122, -123, -124, -125, -126, -127}, null, objArr);
            Class<?> cls = Class.forName((String) objArr[0]);
            Object[] objArr2 = new Object[1];
            a(null, super.getResources().getString(R.string.feed_comment_delete_success).substring(1, 2).codePointAt(0) + 16, new byte[]{-126, -123, -122, -117, -127, -118, -122, -110, -120, -120, -119, -117, -126, -112, -124, -124, -111, -118}, null, objArr2);
            baseContext = (Context) cls.getMethod((String) objArr2[0], new Class[0]).invoke(null, null);
        }
        if (baseContext != null) {
            baseContext = baseContext.getApplicationContext();
        }
        if (baseContext != null) {
            try {
                Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                if (obj == null) {
                    obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(View.MeasureSpec.getMode(0) + PDF417Common.NUMBER_OF_CODEWORDS, TextUtils.indexOf((CharSequence) "", '0', 0) + 36, (char) Color.blue(0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                }
                Object invoke = ((Method) obj).invoke(null, null);
                try {
                    Object[] objArr3 = {baseContext};
                    Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(247288059);
                    if (obj2 == null) {
                        obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getScrollBarFadeDuration() >> 16) + 911, 18 - Color.alpha(0), (char) View.MeasureSpec.getMode(0))).getMethod("KClassImpl$Data$declaredNonStaticMembers$2", Context.class);
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
        this.sbhvBillHistories.getSplitBillHistories();
    }

    @Override // id.dana.splitbill.SplitBillIntroductionContract.View
    public void onFinishGetSplitBillConfig(int i, RequestMoneyInfoModel requestMoneyInfoModel) {
        this.getErrorConfigVersion = i;
        this.NetworkUserEntityData$$ExternalSyntheticLambda1 = requestMoneyInfoModel;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @OnClick({R.id.btn_split_bill_entry})
    public void onSplitBillEntryButtonClick() {
        startActivity(SplitBillActivity.createSplitBillIntent(this, this.NetworkUserEntityData$$ExternalSyntheticLambda1, 0L, "", this.getErrorConfigVersion, TrackerKey.SourceType.SPLIT_BILL_LANDING_PAGE));
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        if (lookAheadTest == i && -1 == i2 && this.scheduleImpl) {
            Target tooltipTarget = getTooltipTarget();
            if (tooltipTarget != null && this.NetworkUserEntityData$$ExternalSyntheticLambda2 == null) {
                SimpleShowcaseBuilder simpleShowcaseBuilder = new SimpleShowcaseBuilder(this);
                simpleShowcaseBuilder.NetworkUserEntityData$$ExternalSyntheticLambda2 = tooltipTarget;
                this.NetworkUserEntityData$$ExternalSyntheticLambda2 = simpleShowcaseBuilder.BuiltInFictitiousFunctionClassFactory(false).BuiltInFictitiousFunctionClassFactory(getResources().getString(R.string.btnQuestionOnboarding)).BuiltInFictitiousFunctionClassFactory(new AbstractOnShowcaseStateListener() { // from class: id.dana.splitbill.view.SplitBillIntroductionActivity.3
                    @Override // id.dana.showcase.AbstractOnShowcaseStateListener, id.dana.showcase.OnShowcaseStateListener
                    public void onFinished(int i3) {
                        SplitBillIntroductionActivity.this.NetworkUserEntityData$$ExternalSyntheticLambda2 = null;
                    }
                }).PlaceComponentResult();
            }
            this.scheduleImpl = false;
        }
        super.onActivityResult(i, i2, intent);
    }

    public Target getTooltipTarget() {
        return new TargetBuilder(this).getAuthRequestContext(this.rightButton).BuiltInFictitiousFunctionClassFactory(new CircleShape(SPOTLIGHT_SIZE)).getAuthRequestContext(new Content(getResources().getString(R.string.tooltip_split_bill_title), getResources().getString(R.string.tooltip_split_bill_desc))).KClassImpl$Data$declaredNonStaticMembers$2();
    }

    static /* synthetic */ void access$100(SplitBillIntroductionActivity splitBillIntroductionActivity) {
        ArrayList arrayList = new ArrayList();
        splitBillIntroductionActivity.NetworkUserEntityData$$ExternalSyntheticLambda0 = arrayList;
        splitBillIntroductionActivity.PlaceComponentResult(arrayList);
        splitBillIntroductionActivity.startActivityForResult(BottomSheetOnBoardingActivity.createOnBoardingIntent(splitBillIntroductionActivity, new OnBoardingModel(splitBillIntroductionActivity.getString(R.string.bottom_on_boarding_title_split_bill), BottomSheetType.VIEW_PAGER, splitBillIntroductionActivity.NetworkUserEntityData$$ExternalSyntheticLambda0, "split_bill")), lookAheadTest);
    }

    private void PlaceComponentResult(List<ContentOnBoardingModel> list) {
        list.add(new ContentOnBoardingModel((int) R.drawable.split_bill_on_boarding_split_bill, getString(R.string.bottom_on_boarding_subtitle_split_bill_first), getString(R.string.bottom_on_boarding_body_text_split_bill_first)));
        list.add(new ContentOnBoardingModel((int) R.drawable.split_bill_on_boarding_input_amount, getString(R.string.bottom_on_boarding_subtitle_split_bill_second), getString(R.string.bottom_on_boarding_body_text_split_bill_second)));
        list.add(new ContentOnBoardingModel((int) R.drawable.split_bill_on_boarding_notes, getString(R.string.bottom_on_boarding_subtitle_split_bill_third), getString(R.string.bottom_on_boarding_body_text_split_bill_third)));
        list.add(new ContentOnBoardingModel((int) R.drawable.split_bill_on_boarding_check_status, getString(R.string.bottom_on_boarding_subtitle_split_bill_fourth), getString(R.string.bottom_on_boarding_body_text_split_bill_fourth)));
    }

    @Override // id.dana.base.BaseActivity
    public void init() {
        byte b = 0;
        if (this.component == null) {
            DaggerSplitBillIntroductionComponent.Builder KClassImpl$Data$declaredNonStaticMembers$2 = DaggerSplitBillIntroductionComponent.KClassImpl$Data$declaredNonStaticMembers$2();
            KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2 = (ApplicationComponent) Preconditions.getAuthRequestContext(getApplicationComponent());
            KClassImpl$Data$declaredNonStaticMembers$2.MyBillsEntityDataFactory = (BottomSheetOnBoardingModule) Preconditions.getAuthRequestContext(new BottomSheetOnBoardingModule(new BottomSheetOnBoardingContract.View() { // from class: id.dana.splitbill.view.SplitBillIntroductionActivity.2
                @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
                public void dismissProgress() {
                }

                @Override // id.dana.base.AbstractContractKt.AbstractView
                public /* synthetic */ String getErrorSource() {
                    return AbstractContractKt.AbstractView.CC.getAuthRequestContext();
                }

                @Override // id.dana.usereducation.BottomSheetOnBoardingContract.View
                public /* synthetic */ void onGetBottomSheetOnBoardingAvailability(boolean z, String str, String str2) {
                    BottomSheetOnBoardingContract.View.CC.getAuthRequestContext();
                }

                @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
                public void showProgress() {
                }

                @Override // id.dana.usereducation.BottomSheetOnBoardingContract.View
                public void onGetBottomSheetOnBoardingAvailability(boolean z, String str) {
                    SplitBillIntroductionActivity.this.scheduleImpl = z;
                    if (z) {
                        SplitBillIntroductionActivity.access$100(SplitBillIntroductionActivity.this);
                    }
                }

                @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
                public void onError(String str) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(getClass().getName());
                    sb.append("on Error: ");
                    sb.append(str);
                    DanaLog.BuiltInFictitiousFunctionClassFactory(DanaLogConstants.TAG.USER_EDUCATION_TAG, sb.toString());
                }
            }));
            KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext = (SplitBillIntroductionModule) Preconditions.getAuthRequestContext(new SplitBillIntroductionModule(this));
            Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext, SplitBillIntroductionModule.class);
            Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(KClassImpl$Data$declaredNonStaticMembers$2.MyBillsEntityDataFactory, BottomSheetOnBoardingModule.class);
            Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2, ApplicationComponent.class);
            this.component = new DaggerSplitBillIntroductionComponent.SplitBillIntroductionComponentImpl(KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext, KClassImpl$Data$declaredNonStaticMembers$2.MyBillsEntityDataFactory, KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2, b);
        }
        this.component.getAuthRequestContext(this);
        registerPresenter(this.presenter, this.onBoardingPresenter);
        this.presenter.BuiltInFictitiousFunctionClassFactory();
        this.onBoardingPresenter.KClassImpl$Data$declaredNonStaticMembers$2("split_bill");
        this.sbhvBillHistories.setListener(new SplitBillHistoryView.Listener() { // from class: id.dana.splitbill.view.SplitBillIntroductionActivity.1
            @Override // id.dana.splitbill.view.SplitBillHistoryView.Listener
            public final void getAuthRequestContext(boolean z) {
            }

            @Override // id.dana.splitbill.view.SplitBillHistoryView.Listener
            public final void PlaceComponentResult() {
                SplitBillIntroductionActivity.this.splitBillAnalyticTracker.getAuthRequestContext(SplitBillIntroductionActivity.this.getSource(), SplitBillIntroductionActivity.this.sbhvBillHistories.getSuccessSplitBillCount().longValue(), SplitBillIntroductionActivity.this.sbhvBillHistories.getInProgressSplitBillCount().longValue(), SplitBillIntroductionActivity.this.sbhvBillHistories.getExpiredSplitBillCount().longValue());
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @OnClick({R.id.right_button})
    public void onHelpClick() {
        ArrayList arrayList = new ArrayList();
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = arrayList;
        PlaceComponentResult(arrayList);
        startActivity(BottomSheetHelpActivity.createBottomSheetHelpIntent(this, new OnBoardingModel(getString(R.string.bottom_on_boarding_title_split_bill), "list", this.NetworkUserEntityData$$ExternalSyntheticLambda0, "split_bill")));
    }

    private static void a(int[] iArr, int i, byte[] bArr, char[] cArr, Object[] objArr) {
        BottomSheetCardBindingView$watcherCardNumberView$1 bottomSheetCardBindingView$watcherCardNumberView$1 = new BottomSheetCardBindingView$watcherCardNumberView$1();
        char[] cArr2 = DatabaseTableConfigUtil;
        if (cArr2 != null) {
            int length = cArr2.length;
            char[] cArr3 = new char[length];
            for (int i2 = 0; i2 < length; i2++) {
                cArr3[i2] = (char) (cArr2[i2] ^ 4571606982258105150L);
            }
            cArr2 = cArr3;
        }
        int i3 = (int) (4571606982258105150L ^ initRecordTimeStamp);
        if (PrepareContext) {
            bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult = bArr.length;
            char[] cArr4 = new char[bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult];
            bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory = 0;
            while (bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory < bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult) {
                cArr4[bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory] = (char) (cArr2[bArr[(bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult - 1) - bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory] + i] - i3);
                bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory++;
            }
            objArr[0] = new String(cArr4);
        } else if (GetContactSyncConfig) {
            bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult = cArr.length;
            char[] cArr5 = new char[bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult];
            bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory = 0;
            while (bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory < bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult) {
                cArr5[bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory] = (char) (cArr2[cArr[(bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult - 1) - bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory] - i] - i3);
                bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory++;
            }
            objArr[0] = new String(cArr5);
        } else {
            bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult = iArr.length;
            char[] cArr6 = new char[bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult];
            bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory = 0;
            while (bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory < bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult) {
                cArr6[bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory] = (char) (cArr2[iArr[(bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult - 1) - bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory] - i] - i3);
                bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory++;
            }
            objArr[0] = new String(cArr6);
        }
    }
}
