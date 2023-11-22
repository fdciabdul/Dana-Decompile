package id.dana.news;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.ImageFormat;
import android.graphics.PointF;
import android.graphics.drawable.Drawable;
import android.media.AudioTrack;
import android.os.Bundle;
import android.os.Process;
import android.os.SystemClock;
import android.text.AndroidCharacter;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ExpandableListView;
import androidx.fragment.app.FragmentTransaction;
import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.alibaba.fastjson.parser.JSONLexer;
import com.alipay.iap.android.common.syncintegration.api.IAPSyncCommand;
import com.google.common.base.Ascii;
import com.google.zxing.pdf417.PDF417Common;
import id.dana.R;
import id.dana.base.BaseActivity;
import id.dana.onboarding.splash.LauncherActivity;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import o.SummaryVoucherView$$ExternalSyntheticLambda0;
import o.getOnBoardingScenario;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u0000 \t2\u00020\u0001:\u0001\tB\u0007¢\u0006\u0004\b\b\u0010\u0007J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"Lid/dana/news/NewsActivity;", "Lid/dana/base/BaseActivity;", "", "getLayout", "()I", "", IAPSyncCommand.COMMAND_INIT, "()V", "<init>", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class NewsActivity extends BaseActivity {

    /* renamed from: Companion  reason: from kotlin metadata */
    public static final Companion INSTANCE;
    private static long NetworkUserEntityData$$ExternalSyntheticLambda0;
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();
    public static final byte[] $$a = {TarHeader.LF_CHR, 112, -114, 9, TarHeader.LF_CHR, -48, 46, 10, 7, 14, -39, TarHeader.LF_NORMAL, 13, -4, 18, 12, -46, 36, Ascii.SUB, -12, -20, 34, 9, Ascii.CAN, 2, 10, 14, 5, 22, -44, 59, 6, -5, -15, Ascii.SUB, 19, 11, -9, Ascii.NAK, 8, -42, TarHeader.LF_CHR, 6, 13, -8, Ascii.SUB, 3, -1, TarHeader.LF_NORMAL, -4, Ascii.EM, 7, -35, 43, 10, 3, -65, 39, 36, Ascii.SUB, -12, -54, 71, 8, 5, 16, -4, Ascii.CAN, -6, 6, -15, 40, 6, -20, 40, -12, Ascii.SUB, -4, 1, -15, Ascii.US, 15, -4, 10, Ascii.DC4, 8, -72, Ascii.NAK};
    public static final int $$b = 157;
    public static final byte[] PlaceComponentResult = {1, 78, 11, -6, -17, 6, -18, -1, 2, 1, TarHeader.LF_SYMLINK, -57, -16, -3, -10, 11, -13, -10, 66, -25, -48, -3, -10, 11, -23, 0, 1, -5, -13, -10, 7, -15, -9, 45, -29, -22, 7, 33, -48, 7, -5, 5, -25, 17, 47, -66, 7, -17, 3, TarHeader.LF_DIR, -41, -42, 2, -5, 11, -12, -2, -19, 47, -51, -4, 0, -1, 2, -2, -23, 7, -10, -3, 33, -41, 4, -13};
    public static final int getAuthRequestContext = 247;

    static {
        BuiltInFictitiousFunctionClassFactory();
        INSTANCE = new Companion(null);
    }

    static void BuiltInFictitiousFunctionClassFactory() {
        NetworkUserEntityData$$ExternalSyntheticLambda0 = 7004231755919059L;
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x001d  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0025  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:22:0x0025 -> B:23:0x0032). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void a(short r6, short r7, short r8, java.lang.Object[] r9) {
        /*
            int r7 = 106 - r7
            int r8 = 56 - r8
            byte[] r0 = id.dana.news.NewsActivity.PlaceComponentResult
            int r6 = 23 - r6
            byte[] r1 = new byte[r6]
            int r6 = r6 + (-1)
            r2 = 0
            if (r0 != 0) goto L17
            r3 = r1
            r4 = 0
            r1 = r0
            r0 = r9
            r9 = r8
            r8 = r7
            r7 = r6
            goto L32
        L17:
            r3 = 0
        L18:
            byte r4 = (byte) r7
            r1[r3] = r4
            if (r3 != r6) goto L25
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            r9[r2] = r6
            return
        L25:
            r4 = r0[r8]
            int r3 = r3 + 1
            r5 = r7
            r7 = r6
            r6 = r4
            r4 = r3
            r3 = r1
            r1 = r0
            r0 = r9
            r9 = r8
            r8 = r5
        L32:
            int r6 = -r6
            int r8 = r8 + r6
            int r6 = r8 + (-4)
            int r8 = r9 + 1
            r9 = r0
            r0 = r1
            r1 = r3
            r3 = r4
            r5 = r7
            r7 = r6
            r6 = r5
            goto L18
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.news.NewsActivity.a(short, short, short, java.lang.Object[]):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0022  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x002a  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:22:0x002a -> B:23:0x0032). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void c(int r7, short r8, short r9, java.lang.Object[] r10) {
        /*
            int r8 = r8 * 3
            int r8 = 42 - r8
            int r9 = r9 * 2
            int r9 = r9 + 75
            byte[] r0 = id.dana.news.NewsActivity.$$a
            int r7 = r7 + 4
            byte[] r1 = new byte[r8]
            r2 = 0
            if (r0 != 0) goto L17
            r3 = r1
            r4 = 0
            r1 = r0
            r0 = r10
            r10 = r8
            goto L32
        L17:
            r3 = 0
            r6 = r9
            r9 = r8
            r8 = r6
        L1b:
            int r4 = r3 + 1
            byte r5 = (byte) r8
            r1[r3] = r5
            if (r4 != r9) goto L2a
            java.lang.String r7 = new java.lang.String
            r7.<init>(r1, r2)
            r10[r2] = r7
            return
        L2a:
            r3 = r0[r7]
            r6 = r10
            r10 = r9
            r9 = r3
            r3 = r1
            r1 = r0
            r0 = r6
        L32:
            int r7 = r7 + 1
            int r8 = r8 + r9
            int r8 = r8 + (-7)
            r9 = r10
            r10 = r0
            r0 = r1
            r1 = r3
            r3 = r4
            goto L1b
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.news.NewsActivity.c(int, short, short, java.lang.Object[]):void");
    }

    public final void _$_clearFindViewByIdCache() {
        this._$_findViewCache.clear();
    }

    public final View _$_findCachedViewById(int i) {
        Map<Integer, View> map = this._$_findViewCache;
        View view = map.get(Integer.valueOf(i));
        if (view == null) {
            View findViewById = findViewById(i);
            if (findViewById != null) {
                map.put(Integer.valueOf(i), findViewById);
                return findViewById;
            }
            return null;
        }
        return view;
    }

    @Override // id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper
    public final void attachBaseContext(Context context) {
        Object[] objArr;
        Object[] objArr2;
        Object[] objArr3;
        Object[] objArr4;
        super.attachBaseContext(context);
        Object[] objArr5 = new Object[1];
        b(30427 - (ViewConfiguration.getFadingEdgeLength() >> 16), new char[]{49137, 51493, 21058, 56179, 25747, 60862, 30422, 32835, 2343, 37456, 6960, 42153, 11686, 46816, 49161, 18720, 53843, 23400}, objArr5);
        Class<?> cls = Class.forName((String) objArr5[0]);
        Object[] objArr6 = new Object[1];
        b(45481 - (Process.myPid() >> 22), new char[]{49149, 3648, 56471, 43778, 31056}, objArr6);
        int intValue = ((Integer) cls.getDeclaredMethod((String) objArr6[0], new Class[0]).invoke(null, new Object[0])).intValue() % 100000;
        if (intValue < 99000 || intValue > 99999) {
            Context applicationContext = context != null ? context.getApplicationContext() : context;
            if (applicationContext != null) {
                try {
                    Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                    if (obj == null) {
                        obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(View.getDefaultSize(0, 0) + PDF417Common.NUMBER_OF_CODEWORDS, ImageFormat.getBitsPerPixel(0) + 36, (char) KeyEvent.getDeadChar(0, 0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                    }
                    Object invoke = ((Method) obj).invoke(null, null);
                    Object[] objArr7 = new Object[1];
                    b(TextUtils.lastIndexOf("", '0', 0, 0) + 28790, new char[]{49063, 53126, 24396, 61175, 32372, 36285, 7447, 44187, 15375, 19432, 56161, 27377, 64137, 2643, 39367, 10621, 47345, 51300, 22428, 59230, 30416, 34410, 5629, 42277, 13580, 17614, 54346, 25507, 62318, 693, 37447, 8670, 45321, 49331, 20520, 57430, 28546, 65344, 3830, 40563, 11759, 48459, 52374, 23553, 60398, 31538, 35488, 6798}, objArr7);
                    String str = (String) objArr7[0];
                    Object[] objArr8 = new Object[1];
                    b(58511 - (ViewConfiguration.getEdgeSlop() >> 16), new char[]{49137, 23338, 30392, 4697, 11722, 51554, 58618, 32833, 39820, 46836, 21055, 28032, 2368, 9442, 49267, 56261, 63314, 37597, 44536, 18748, 25816, JSONLexer.EOI, 7148, 14202, 53966, 60933, 35119, 42208, 16396, 23495, 30560, 4851, 11795, 51611, 58714, 32805, 39919, 46936, 21146, 28266, 2557, 9543, 49283, 56228, 63335, 37508, 44563, 18918, 25971, 252, 7241, 14292, 53925, 60988, 35210, 42264, 16616, 23670, 30613, 4871, 11813, 51643, 58710, 32914}, objArr8);
                    String str2 = (String) objArr8[0];
                    Object[] objArr9 = new Object[1];
                    b((ViewConfiguration.getMaximumDrawingCacheSize() >> 24) + 21059, new char[]{49058, 60898, 7027, 18747, 63141, 9448, 21040, 32881, 11696, 23539, 35126, 14144, 25733, 37572, 49162, 28234, 39873, 51590, 30482, 42253, 53918, 141, 44595, 56230, 2543, 46973, 58727, 4793, 16546, 61025, 7293, 18926, 63431, 9559, 21316, 32897, 11934, 23560, 35412, 14237, 26064, 37709, 49503, 28389, 39980, 51815, 30715, 42431, 54118, 378, 44773, 56492, 2622, 47230, 58836, 5056, 16655, 61262, 7303, 19159, 63554, 9810, 21407, 33236}, objArr9);
                    String str3 = (String) objArr9[0];
                    Object[] objArr10 = new Object[1];
                    b(((Process.getThreadPriority(0) + 20) >> 6) + 25847, new char[]{49144, 56083, 30218, 37125, 11327, 18297, 57973, 32126, 38988, 13150, 20056, 59756, 1066, 40815, 14970, 21915, 61573, 2966, 42682, 49574, 23741, 63392, 4830, 44431, 51423, 25594, 65255, 6639, 46320, 53272, 27411, 34316, 8465, 48181, 55099, 29307, 36175, 10316, 17239, 56862, 31081, 37999, 12159, 19138, 58765, 149, 39829, 13996, 20915, 60579, 1921, 41683, 15758, 22684, 62447, 3831, 43517, 50433, 24594, 64270}, objArr10);
                    String str4 = (String) objArr10[0];
                    Object[] objArr11 = new Object[1];
                    b((AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)) + 41299, new char[]{49065, 7917, 64770, 23623, 15086, 39230}, objArr11);
                    try {
                        Object[] objArr12 = {applicationContext, str, str2, str3, str4, true, (String) objArr11[0], 995651014};
                        Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-1276397751);
                        if (obj2 == null) {
                            obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(KeyEvent.keyCodeFromString("") + 911, (SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)) + 17, (char) (Color.rgb(0, 0, 0) + 16777216))).getMethod("getAuthRequestContext", Context.class, String.class, String.class, String.class, String.class, Boolean.TYPE, String.class, Integer.TYPE);
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
                a(PlaceComponentResult[30], PlaceComponentResult[25], (byte) (-PlaceComponentResult[31]), objArr13);
                Class<?> cls2 = Class.forName((String) objArr13[0]);
                Object[] objArr14 = new Object[1];
                a(PlaceComponentResult[30], PlaceComponentResult[0], (short) 30, objArr14);
                try {
                    Object[] objArr15 = {applicationContext2, Integer.valueOf(((Integer) cls2.getMethod((String) objArr14[0], Object.class).invoke(null, this)).intValue())};
                    Object obj3 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1691739267);
                    if (obj3 == null) {
                        Class cls3 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)) + 55, TextUtils.getCapsMode("", 0, 0) + 3, (char) ((-1) - TextUtils.indexOf((CharSequence) "", '0', 0, 0)));
                        Object[] objArr16 = new Object[1];
                        c((byte) ($$a[78] - 1), $$a[31], $$a[78], objArr16);
                        obj3 = cls3.getMethod((String) objArr16[0], Context.class, Integer.TYPE);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1691739267, obj3);
                    }
                    Object invoke2 = ((Method) obj3).invoke(null, objArr15);
                    try {
                        Object obj4 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(40157535);
                        if (obj4 == null) {
                            obj4 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(800 - (Process.myTid() >> 22), 15 - ExpandableListView.getPackedPositionType(0L), (char) ((ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)) - 1))).getMethod("getAuthRequestContext", null);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(40157535, obj4);
                        }
                        int intValue2 = ((Integer) ((Method) obj4).invoke(invoke2, null)).intValue();
                        try {
                            Object obj5 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1621779126);
                            if (obj5 == null) {
                                obj5 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(800 - (ViewConfiguration.getEdgeSlop() >> 16), MotionEvent.axisFromString("") + 16, (char) (1 - (SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1))))).getMethod("PlaceComponentResult", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1621779126, obj5);
                            }
                            if (((Integer) ((Method) obj5).invoke(invoke2, null)).intValue() != intValue2) {
                                ArrayList arrayList = new ArrayList();
                                try {
                                    Object[] objArr17 = {invoke2};
                                    Object obj6 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(658700871);
                                    if (obj6 == null) {
                                        obj6 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(815 - TextUtils.getOffsetBefore("", 0), AndroidCharacter.getMirror('0') - 19, (char) (57994 - (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1))))).getMethod("getAuthRequestContext", (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(800 - TextUtils.indexOf("", "", 0, 0), 15 - TextUtils.getCapsMode("", 0, 0), (char) Color.blue(0)));
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
                                            obj7 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getWindowTouchSlop() >> 8) + PDF417Common.NUMBER_OF_CODEWORDS, View.MeasureSpec.getMode(0) + 35, (char) ((-1) - ExpandableListView.getPackedPositionChild(0L)))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj7);
                                        }
                                        Object invoke3 = ((Method) obj7).invoke(objArr, objArr);
                                        try {
                                            Object[] objArr18 = {-307087727, Long.valueOf(j), arrayList, LauncherActivity.getAuid()};
                                            Object obj8 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                            if (obj8 == null) {
                                                obj8 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - (ViewConfiguration.getScrollBarSize() >> 8), 19 - (SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)), (char) TextUtils.indexOf("", "", 0, 0))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                a(PlaceComponentResult[30], PlaceComponentResult[25], (byte) (-PlaceComponentResult[31]), objArr19);
                Class<?> cls4 = Class.forName((String) objArr19[0]);
                Object[] objArr20 = new Object[1];
                a(PlaceComponentResult[30], PlaceComponentResult[0], (short) 30, objArr20);
                try {
                    Object[] objArr21 = {applicationContext3, Integer.valueOf(((Integer) cls4.getMethod((String) objArr20[0], Object.class).invoke(null, this)).intValue())};
                    Object obj9 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(345757441);
                    if (obj9 == null) {
                        Class cls5 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(TextUtils.lastIndexOf("", '0') + 62, Color.blue(0) + 46, (char) Drawable.resolveOpacity(0, 0));
                        Object[] objArr22 = new Object[1];
                        c((byte) ($$a[23] - 1), $$a[8], $$a[9], objArr22);
                        obj9 = cls5.getMethod((String) objArr22[0], Context.class, Integer.TYPE);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(345757441, obj9);
                    }
                    Object[] objArr23 = (Object[]) ((Method) obj9).invoke(null, objArr21);
                    int i = ((int[]) objArr23[1])[0];
                    if (((int[]) objArr23[0])[0] != i) {
                        long j2 = ((r1 ^ i) & 4294967295L) | 17179869184L;
                        try {
                            Object obj10 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                            if (obj10 != null) {
                                objArr2 = null;
                            } else {
                                objArr2 = null;
                                obj10 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - Color.argb(0, 0, 0, 0), 34 - TextUtils.lastIndexOf("", '0', 0), (char) Color.blue(0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj10);
                            }
                            Object invoke4 = ((Method) obj10).invoke(objArr2, objArr2);
                            try {
                                Object[] objArr24 = {-307087727, Long.valueOf(j2), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj11 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj11 == null) {
                                    obj11 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)) + 910, 18 - TextUtils.getOffsetAfter("", 0), (char) (TextUtils.indexOf((CharSequence) "", '0', 0) + 1))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                a(PlaceComponentResult[30], PlaceComponentResult[25], (byte) (-PlaceComponentResult[31]), objArr25);
                Class<?> cls6 = Class.forName((String) objArr25[0]);
                Object[] objArr26 = new Object[1];
                a(PlaceComponentResult[30], PlaceComponentResult[0], (short) 30, objArr26);
                try {
                    Object[] objArr27 = {applicationContext4, Integer.valueOf(((Integer) cls6.getMethod((String) objArr26[0], Object.class).invoke(null, this)).intValue())};
                    Object obj12 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-697999596);
                    if (obj12 == null) {
                        Class cls7 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(((byte) KeyEvent.getModifierMetaStateMask()) + 119, (ViewConfiguration.getMinimumFlingVelocity() >> 16) + 3, (char) (View.combineMeasuredStates(0, 0) + 38968));
                        Object[] objArr28 = new Object[1];
                        c((byte) ($$a[23] - 1), $$a[8], $$a[9], objArr28);
                        obj12 = cls7.getMethod((String) objArr28[0], Context.class, Integer.TYPE);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(-697999596, obj12);
                    }
                    Object[] objArr29 = (Object[]) ((Method) obj12).invoke(null, objArr27);
                    int i2 = ((int[]) objArr29[1])[0];
                    if (((int[]) objArr29[0])[0] != i2) {
                        long j3 = ((r1 ^ i2) & 4294967295L) | 8589934592L;
                        try {
                            Object obj13 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                            if (obj13 != null) {
                                objArr3 = null;
                            } else {
                                objArr3 = null;
                                obj13 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - (ViewConfiguration.getWindowTouchSlop() >> 8), MotionEvent.axisFromString("") + 36, (char) (ViewConfiguration.getEdgeSlop() >> 16))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj13);
                            }
                            Object invoke5 = ((Method) obj13).invoke(objArr3, objArr3);
                            try {
                                Object[] objArr30 = {-307087727, Long.valueOf(j3), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj14 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj14 == null) {
                                    obj14 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - ((Process.getThreadPriority(0) + 20) >> 6), 19 - (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)), (char) ((-1) - MotionEvent.axisFromString("")))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                a(PlaceComponentResult[30], PlaceComponentResult[25], (byte) (-PlaceComponentResult[31]), objArr31);
                Class<?> cls8 = Class.forName((String) objArr31[0]);
                Object[] objArr32 = new Object[1];
                a(PlaceComponentResult[30], PlaceComponentResult[0], (short) 30, objArr32);
                try {
                    Object[] objArr33 = {applicationContext5, Integer.valueOf(((Integer) cls8.getMethod((String) objArr32[0], Object.class).invoke(null, this)).intValue())};
                    Object obj15 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-16683571);
                    if (obj15 == null) {
                        Class cls9 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(108 - (ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)), (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)) + 3, (char) ((-1) - Process.getGidForName("")));
                        byte b = $$a[53];
                        byte b2 = (byte) ($$a[78] - 1);
                        Object[] objArr34 = new Object[1];
                        c(b, b2, b2, objArr34);
                        obj15 = cls9.getMethod((String) objArr34[0], Context.class, Integer.TYPE);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(-16683571, obj15);
                    }
                    Object[] objArr35 = (Object[]) ((Method) obj15).invoke(null, objArr33);
                    int i3 = ((int[]) objArr35[1])[0];
                    if (((int[]) objArr35[0])[0] != i3) {
                        long j4 = ((r1 ^ i3) & 4294967295L) | 4294967296L;
                        try {
                            Object obj16 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                            if (obj16 != null) {
                                objArr4 = null;
                            } else {
                                objArr4 = null;
                                obj16 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getMinimumFlingVelocity() >> 16) + PDF417Common.NUMBER_OF_CODEWORDS, (ViewConfiguration.getWindowTouchSlop() >> 8) + 35, (char) KeyEvent.normalizeMetaState(0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj16);
                            }
                            Object invoke6 = ((Method) obj16).invoke(objArr4, objArr4);
                            try {
                                Object[] objArr36 = {-307087727, Long.valueOf(j4), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj17 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj17 == null) {
                                    obj17 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - View.MeasureSpec.getSize(0), (ViewConfiguration.getFadingEdgeLength() >> 16) + 18, (char) KeyEvent.normalizeMetaState(0))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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

    @Override // id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.content.ContextWrapper, android.content.Context
    public final Context getApplicationContext() {
        return super.getApplicationContext();
    }

    @Override // id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.content.ContextWrapper
    public final Context getBaseContext() {
        return super.getBaseContext();
    }

    @Override // id.dana.base.BaseActivity
    public final int getLayout() {
        return R.layout.activity_latest_news;
    }

    @Override // id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public final Resources getResources() {
        return super.getResources();
    }

    @Override // id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onCreate(Bundle bundle) {
        Object[] objArr;
        Object[] objArr2 = new Object[1];
        b(super.getResources().getString(R.string.soon).substring(0, 1).codePointAt(0) + 30344, new char[]{49137, 51493, 21058, 56179, 25747, 60862, 30422, 32835, 2343, 37456, 6960, 42153, 11686, 46816, 49161, 18720, 53843, 23400}, objArr2);
        Class<?> cls = Class.forName((String) objArr2[0]);
        Object[] objArr3 = new Object[1];
        b(45481 - KeyEvent.keyCodeFromString(""), new char[]{49149, 3648, 56471, 43778, 31056}, objArr3);
        int intValue = ((Integer) cls.getDeclaredMethod((String) objArr3[0], new Class[0]).invoke(null, new Object[0])).intValue() % 100000;
        if (intValue < 99000 || intValue > 99999) {
            Context baseContext = getBaseContext();
            if (baseContext == null) {
                Object[] objArr4 = new Object[1];
                b(super.getResources().getString(R.string.new_account_freeze_dialog_title).substring(15, 16).codePointAt(0) + 44414, new char[]{49137, 4621, 58386, 46651, 2099, 55878, 44102, 32283, 53353, 41579, 29854, 50895, 39093, 27300, 15534, 36548, 24790, 13018, 34034, 22240, 10552, 64279, 19712, 7968, 61753, 17231}, objArr4);
                Class<?> cls2 = Class.forName((String) objArr4[0]);
                Object[] objArr5 = new Object[1];
                b(40063 - View.MeasureSpec.getMode(0), new char[]{49139, 9114, 34588, 27295, 52745, 45445, 5406, 63656, 23576, 16279, 41738, 1676, 59911, 19842, 12566, 38024, 30735, 56209}, objArr5);
                baseContext = (Context) cls2.getMethod((String) objArr5[0], new Class[0]).invoke(null, null);
            }
            if (baseContext != null) {
                baseContext = baseContext.getApplicationContext();
            }
            if (baseContext != null) {
                try {
                    Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                    if (obj == null) {
                        obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(928 - (ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)), View.resolveSize(0, 0) + 35, (char) (ViewConfiguration.getEdgeSlop() >> 16))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                    }
                    Object invoke = ((Method) obj).invoke(null, null);
                    Object[] objArr6 = new Object[1];
                    b(getPackageName().codePointAt(2) + 28743, new char[]{49063, 53126, 24396, 61175, 32372, 36285, 7447, 44187, 15375, 19432, 56161, 27377, 64137, 2643, 39367, 10621, 47345, 51300, 22428, 59230, 30416, 34410, 5629, 42277, 13580, 17614, 54346, 25507, 62318, 693, 37447, 8670, 45321, 49331, 20520, 57430, 28546, 65344, 3830, 40563, 11759, 48459, 52374, 23553, 60398, 31538, 35488, 6798}, objArr6);
                    String str = (String) objArr6[0];
                    Object[] objArr7 = new Object[1];
                    b(super.getResources().getString(R.string.offline_merchant_title).substring(1, 2).length() + 58510, new char[]{49137, 23338, 30392, 4697, 11722, 51554, 58618, 32833, 39820, 46836, 21055, 28032, 2368, 9442, 49267, 56261, 63314, 37597, 44536, 18748, 25816, JSONLexer.EOI, 7148, 14202, 53966, 60933, 35119, 42208, 16396, 23495, 30560, 4851, 11795, 51611, 58714, 32805, 39919, 46936, 21146, 28266, 2557, 9543, 49283, 56228, 63335, 37508, 44563, 18918, 25971, 252, 7241, 14292, 53925, 60988, 35210, 42264, 16616, 23670, 30613, 4871, 11813, 51643, 58710, 32914}, objArr7);
                    String str2 = (String) objArr7[0];
                    try {
                        Object[] objArr8 = new Object[1];
                        a(PlaceComponentResult[25], (byte) (-PlaceComponentResult[32]), (byte) (getAuthRequestContext & 60), objArr8);
                        Class<?> cls3 = Class.forName((String) objArr8[0]);
                        Object[] objArr9 = new Object[1];
                        a(PlaceComponentResult[41], PlaceComponentResult[48], PlaceComponentResult[25], objArr9);
                        Object[] objArr10 = new Object[1];
                        b(((ApplicationInfo) cls3.getMethod((String) objArr9[0], null).invoke(this, null)).targetSdkVersion + 21026, new char[]{49058, 60898, 7027, 18747, 63141, 9448, 21040, 32881, 11696, 23539, 35126, 14144, 25733, 37572, 49162, 28234, 39873, 51590, 30482, 42253, 53918, 141, 44595, 56230, 2543, 46973, 58727, 4793, 16546, 61025, 7293, 18926, 63431, 9559, 21316, 32897, 11934, 23560, 35412, 14237, 26064, 37709, 49503, 28389, 39980, 51815, 30715, 42431, 54118, 378, 44773, 56492, 2622, 47230, 58836, 5056, 16655, 61262, 7303, 19159, 63554, 9810, 21407, 33236}, objArr10);
                        String str3 = (String) objArr10[0];
                        Object[] objArr11 = new Object[1];
                        b(25848 - (SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)), new char[]{49144, 56083, 30218, 37125, 11327, 18297, 57973, 32126, 38988, 13150, 20056, 59756, 1066, 40815, 14970, 21915, 61573, 2966, 42682, 49574, 23741, 63392, 4830, 44431, 51423, 25594, 65255, 6639, 46320, 53272, 27411, 34316, 8465, 48181, 55099, 29307, 36175, 10316, 17239, 56862, 31081, 37999, 12159, 19138, 58765, 149, 39829, 13996, 20915, 60579, 1921, 41683, 15758, 22684, 62447, 3831, 43517, 50433, 24594, 64270}, objArr11);
                        String str4 = (String) objArr11[0];
                        Object[] objArr12 = new Object[1];
                        b(41299 - (ViewConfiguration.getScrollBarFadeDuration() >> 16), new char[]{49065, 7917, 64770, 23623, 15086, 39230}, objArr12);
                        try {
                            Object[] objArr13 = {baseContext, str, str2, str3, str4, true, (String) objArr12[0], 995651014};
                            Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-1276397751);
                            if (obj2 == null) {
                                obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getKeyRepeatDelay() >> 16) + 911, (SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)) + 17, (char) View.MeasureSpec.getMode(0))).getMethod("getAuthRequestContext", Context.class, String.class, String.class, String.class, String.class, Boolean.TYPE, String.class, Integer.TYPE);
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
            a(PlaceComponentResult[30], PlaceComponentResult[25], (byte) (-PlaceComponentResult[31]), objArr14);
            Class<?> cls4 = Class.forName((String) objArr14[0]);
            Object[] objArr15 = new Object[1];
            a(PlaceComponentResult[30], PlaceComponentResult[0], (short) 30, objArr15);
            try {
                Object[] objArr16 = {Integer.valueOf(((Integer) cls4.getMethod((String) objArr15[0], Object.class).invoke(null, this)).intValue())};
                Object obj3 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(25207140);
                if (obj3 == null) {
                    Class cls5 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getScrollBarFadeDuration() >> 16) + 494, Color.alpha(0) + 4, (char) (TextUtils.indexOf((CharSequence) "", '0', 0, 0) + 1));
                    byte b = $$a[53];
                    byte b2 = (byte) ($$a[78] - 1);
                    Object[] objArr17 = new Object[1];
                    c(b, b2, b2, objArr17);
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
                            obj4 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(928 - TextUtils.indexOf((CharSequence) "", '0', 0), 35 - (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)), (char) (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj4);
                        }
                        Object invoke2 = ((Method) obj4).invoke(objArr, objArr);
                        try {
                            Object[] objArr19 = {-181170946, Long.valueOf(j), new ArrayList(), LauncherActivity.getAuid()};
                            Object obj5 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                            if (obj5 == null) {
                                obj5 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(Color.green(0) + 911, TextUtils.indexOf("", "", 0, 0) + 18, (char) TextUtils.getOffsetBefore("", 0))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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

    @Override // id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onPause() {
        Context baseContext = getBaseContext();
        if (baseContext == null) {
            try {
                Object[] objArr = new Object[1];
                a(PlaceComponentResult[25], (byte) (-PlaceComponentResult[32]), (byte) (getAuthRequestContext & 60), objArr);
                Class<?> cls = Class.forName((String) objArr[0]);
                Object[] objArr2 = new Object[1];
                a(PlaceComponentResult[41], PlaceComponentResult[48], PlaceComponentResult[25], objArr2);
                Object[] objArr3 = new Object[1];
                b(((ApplicationInfo) cls.getMethod((String) objArr2[0], null).invoke(this, null)).targetSdkVersion + 44498, new char[]{49137, 4621, 58386, 46651, 2099, 55878, 44102, 32283, 53353, 41579, 29854, 50895, 39093, 27300, 15534, 36548, 24790, 13018, 34034, 22240, 10552, 64279, 19712, 7968, 61753, 17231}, objArr3);
                Class<?> cls2 = Class.forName((String) objArr3[0]);
                try {
                    Object[] objArr4 = new Object[1];
                    a(PlaceComponentResult[25], (byte) (-PlaceComponentResult[32]), (byte) (getAuthRequestContext & 60), objArr4);
                    Class<?> cls3 = Class.forName((String) objArr4[0]);
                    Object[] objArr5 = new Object[1];
                    a(PlaceComponentResult[41], PlaceComponentResult[48], PlaceComponentResult[25], objArr5);
                    Object[] objArr6 = new Object[1];
                    b(((ApplicationInfo) cls3.getMethod((String) objArr5[0], null).invoke(this, null)).targetSdkVersion + 40030, new char[]{49139, 9114, 34588, 27295, 52745, 45445, 5406, 63656, 23576, 16279, 41738, 1676, 59911, 19842, 12566, 38024, 30735, 56209}, objArr6);
                    baseContext = (Context) cls2.getMethod((String) objArr6[0], new Class[0]).invoke(null, null);
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
                    obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - ((Process.getThreadPriority(0) + 20) >> 6), 35 - Gravity.getAbsoluteGravity(0, 0), (char) (1 - (SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1))))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                }
                Object invoke = ((Method) obj).invoke(null, null);
                try {
                    Object[] objArr7 = {baseContext};
                    Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-549958681);
                    if (obj2 == null) {
                        obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - TextUtils.getTrimmedLength(""), 18 - (ViewConfiguration.getScrollBarFadeDuration() >> 16), (char) View.combineMeasuredStates(0, 0))).getMethod("MyBillsEntityDataFactory", Context.class);
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

    @Override // id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onResume() {
        Context baseContext = getBaseContext();
        if (baseContext == null) {
            Object[] objArr = new Object[1];
            b(super.getResources().getString(R.string.sub_total).substring(0, 8).codePointAt(1) + 44414, new char[]{49137, 4621, 58386, 46651, 2099, 55878, 44102, 32283, 53353, 41579, 29854, 50895, 39093, 27300, 15534, 36548, 24790, 13018, 34034, 22240, 10552, 64279, 19712, 7968, 61753, 17231}, objArr);
            Class<?> cls = Class.forName((String) objArr[0]);
            Object[] objArr2 = new Object[1];
            b(super.getResources().getString(R.string.qcb_title_jp).substring(0, 18).length() + 40045, new char[]{49139, 9114, 34588, 27295, 52745, 45445, 5406, 63656, 23576, 16279, 41738, 1676, 59911, 19842, 12566, 38024, 30735, 56209}, objArr2);
            baseContext = (Context) cls.getMethod((String) objArr2[0], new Class[0]).invoke(null, null);
        }
        if (baseContext != null) {
            baseContext = baseContext.getApplicationContext();
        }
        if (baseContext != null) {
            try {
                Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                if (obj == null) {
                    obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(View.MeasureSpec.getSize(0) + PDF417Common.NUMBER_OF_CODEWORDS, TextUtils.indexOf((CharSequence) "", '0') + 36, (char) TextUtils.getOffsetBefore("", 0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                }
                Object invoke = ((Method) obj).invoke(null, null);
                try {
                    Object[] objArr3 = {baseContext};
                    Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(247288059);
                    if (obj2 == null) {
                        obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(TextUtils.indexOf((CharSequence) "", '0', 0) + 912, 18 - ExpandableListView.getPackedPositionGroup(0L), (char) (ViewConfiguration.getScrollBarFadeDuration() >> 16))).getMethod("KClassImpl$Data$declaredNonStaticMembers$2", Context.class);
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

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lid/dana/news/NewsActivity$Companion;", "", "Landroid/content/Context;", "p0", "", "KClassImpl$Data$declaredNonStaticMembers$2", "(Landroid/content/Context;)V", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public static void KClassImpl$Data$declaredNonStaticMembers$2(Context p0) {
            Intrinsics.checkNotNullParameter(p0, "");
            p0.startActivity(new Intent(p0, NewsActivity.class));
        }
    }

    @Override // id.dana.base.BaseActivity
    public final void init() {
        setTitle(getResources().getString(R.string.dana_news_title));
        setMenuLeftButton(R.drawable.arrow_left_white);
        FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
        beginTransaction.KClassImpl$Data$declaredNonStaticMembers$2(R.id.fl_container, new LatestNewsFragment(), null, 2);
        beginTransaction.getAuthRequestContext();
    }

    private static void b(int i, char[] cArr, Object[] objArr) {
        getOnBoardingScenario getonboardingscenario = new getOnBoardingScenario();
        getonboardingscenario.MyBillsEntityDataFactory = i;
        int length = cArr.length;
        long[] jArr = new long[length];
        getonboardingscenario.getAuthRequestContext = 0;
        while (getonboardingscenario.getAuthRequestContext < cArr.length) {
            jArr[getonboardingscenario.getAuthRequestContext] = (cArr[getonboardingscenario.getAuthRequestContext] ^ (getonboardingscenario.getAuthRequestContext * getonboardingscenario.MyBillsEntityDataFactory)) ^ (NetworkUserEntityData$$ExternalSyntheticLambda0 ^ 4796183387843776835L);
            getonboardingscenario.getAuthRequestContext++;
        }
        char[] cArr2 = new char[length];
        getonboardingscenario.getAuthRequestContext = 0;
        while (getonboardingscenario.getAuthRequestContext < cArr.length) {
            cArr2[getonboardingscenario.getAuthRequestContext] = (char) jArr[getonboardingscenario.getAuthRequestContext];
            getonboardingscenario.getAuthRequestContext++;
        }
        objArr[0] = new String(cArr2);
    }
}
