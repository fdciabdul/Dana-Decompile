package com.xiaomi.mipush.sdk.help;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.graphics.Color;
import android.net.Uri;
import android.os.Process;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ExpandableListView;
import com.google.zxing.pdf417.PDF417Common;
import com.xiaomi.mipush.sdk.m;
import java.lang.reflect.Method;
import kotlin.text.Typography;
import o.E;
import o.SummaryVoucherView$$ExternalSyntheticLambda0;

/* loaded from: classes8.dex */
public class HelpContentProvider extends ContentProvider {
    private static long KClassImpl$Data$declaredNonStaticMembers$2 = 4360990799332652212L;
    private static int PlaceComponentResult = -956812108;
    private static char getAuthRequestContext = 56808;

    @Override // android.content.ContentProvider
    public int delete(Uri uri, String str, String[] strArr) {
        return 0;
    }

    @Override // android.content.ContentProvider
    public String getType(Uri uri) {
        getContext();
        m.BuiltInFictitiousFunctionClassFactory();
        return "success";
    }

    @Override // android.content.ContentProvider
    public Uri insert(Uri uri, ContentValues contentValues) {
        return null;
    }

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        Object[] objArr = new Object[1];
        a(new char[]{0, 0, 0, 0}, new char[]{18952, 40485, 58795, 59686}, (-1) - ((byte) KeyEvent.getModifierMetaStateMask()), (char) (9957 - (ViewConfiguration.getMaximumDrawingCacheSize() >> 24)), new char[]{39210, 35117, 42140, 52034, 46507, 56708, 24876, 54847, 35288, 14190, 46508, 61280, 19699, 53840, 55341, 30008, 61099, 15590}, objArr);
        Class<?> cls = Class.forName((String) objArr[0]);
        Object[] objArr2 = new Object[1];
        a(new char[]{0, 0, 0, 0}, new char[]{13616, 52486, 59587, 34123}, (-1009973707) - (ViewConfiguration.getKeyRepeatTimeout() >> 16), (char) (19432 - (ViewConfiguration.getFadingEdgeLength() >> 16)), new char[]{38505, 29855, 21624, 12171, 7590}, objArr2);
        int intValue = ((Integer) cls.getDeclaredMethod((String) objArr2[0], new Class[0]).invoke(null, new Object[0])).intValue() % 100000;
        if (intValue < 99000 || intValue > 99999) {
            Object[] objArr3 = new Object[1];
            a(new char[]{0, 0, 0, 0}, new char[]{63766, 11941, 39564, 37635}, ViewConfiguration.getScrollDefaultDelay() >> 16, (char) (Color.argb(0, 0, 0, 0) + 922), new char[]{25728, 11590, 29661, 50700, 47527, 14952, 44480, 20948, 20958, 15124, 23652, 2836, 24367, 42880, 19238, 63110, 24099, 60439, 28421, 34211, 63671, Typography.section, 61372, 48563, 25897, 10919}, objArr3);
            Class<?> cls2 = Class.forName((String) objArr3[0]);
            Object[] objArr4 = new Object[1];
            a(new char[]{0, 0, 0, 0}, new char[]{54641, 52294, 5426, 40258}, (SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)) - 1, (char) ((ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1)) + 16916), new char[]{21299, 10232, 56136, 34219, 25658, 30509, 603, 48612, 51772, 54864, 35211, 17624, 2778, 13432, 5907, 30307, 58592, Typography.lowDoubleQuote}, objArr4);
            Context context = (Context) cls2.getMethod((String) objArr4[0], new Class[0]).invoke(null, null);
            if (context != null) {
                context = context.getApplicationContext();
            }
            if (context != null) {
                try {
                    Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                    if (obj == null) {
                        obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(ExpandableListView.getPackedPositionGroup(0L) + PDF417Common.NUMBER_OF_CODEWORDS, KeyEvent.keyCodeFromString("") + 35, (char) TextUtils.getOffsetBefore("", 0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                    }
                    Object invoke = ((Method) obj).invoke(null, null);
                    Object[] objArr5 = new Object[1];
                    a(new char[]{0, 0, 0, 0}, new char[]{57505, 63944, 29589, 39647}, ViewConfiguration.getTapTimeout() >> 16, (char) Color.alpha(0), new char[]{63960, 59850, 32725, 11120, 25400, 35698, 36883, 25229, 46825, 8607, 19030, 11735, 37024, 65455, 14687, 42754, 37527, 5004, 2906, 34364, 52555, 26702, 28486, 3522, 18112, 30941, 57491, 54708, 44879, 941, 31394, 7344, 43864, 65218, 37790, 5055, 3758, 45815, 25363, 40825, 8452, 50362, 12792, 60137, 34708, 28001, 395, 61203}, objArr5);
                    String str = (String) objArr5[0];
                    Object[] objArr6 = new Object[1];
                    a(new char[]{0, 0, 0, 0}, new char[]{50289, 49447, 51669, 37383}, View.getDefaultSize(0, 0), (char) ((ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)) - 1), new char[]{27965, 34526, 12881, 13164, 41969, 46262, 59698, 40512, 8601, 64021, 52271, 23951, 28655, 51006, 59288, 38552, 3156, 14208, 45861, 24062, 52631, 27661, 60887, 31823, 26262, 20221, 34220, 49726, 45946, 22487, 26800, Typography.lowDoubleQuote, 17184, 63823, 34155, 13010, 23732, 7035, 25904, 29191, 31794, 57297, 34048, 3504, 53567, 13342, 45825, 34967, 63127, 18798, 38185, 6092, 10751, 57456, 31598, 59760, 54533, 52676, 38863, 62389, 32820, 31683, 39263, 35322}, objArr6);
                    String str2 = (String) objArr6[0];
                    Object[] objArr7 = new Object[1];
                    a(new char[]{0, 0, 0, 0}, new char[]{22590, 47175, 56931, 55179}, (SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)) - 1, (char) KeyEvent.keyCodeFromString(""), new char[]{1695, 41168, 17031, 40838, 17801, 43783, 55627, 3217, 35378, 28231, 49203, 3001, 14364, 23122, 36385, 64586, 41453, 1569, 11006, 63092, 9815, 48012, 33560, 9880, 64334, 34818, 39867, 56247, 29270, 14897, 13785, 49895, 9214, 18490, 1633, 11091, 6878, 17125, 44016, 42558, 56708, 29143, 5314, 3725, 64712, 26033, 7257, 42206, 24533, 32425, 56907, 29201, 9663, 19254, 41557, 59511, 33237, 47445, 61604, 3517, 38366, 20506, 33062, 4041}, objArr7);
                    String str3 = (String) objArr7[0];
                    Object[] objArr8 = new Object[1];
                    a(new char[]{0, 0, 0, 0}, new char[]{60415, 4389, 4460, 24788}, ViewConfiguration.getScrollDefaultDelay() >> 16, (char) (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)), new char[]{14135, 46724, 65093, 29667, 25074, 36440, 10733, 64943, 49024, 60575, 50127, 29369, 6887, 45695, 6559, 37593, 52601, 39265, 23575, 40191, 27966, 28520, 39497, 47804, 10959, 39865, 59289, 48360, 60369, 25652, 19061, 7785, 35011, 33534, 40539, 47022, 19356, 62033, 14087, 41349, 2783, 45242, 6969, 47074, 14575, 19830, 35493, 3134, 33503, 52364, 24968, 48021, 49780, 53299, 31730, 2041, 65117, 55829, 34738, 10817}, objArr8);
                    String str4 = (String) objArr8[0];
                    Object[] objArr9 = new Object[1];
                    a(new char[]{0, 0, 0, 0}, new char[]{28872, 30782, 58835, 45308}, (Process.getThreadPriority(0) + 20) >> 6, (char) (Gravity.getAbsoluteGravity(0, 0) + 64741), new char[]{35924, 61749, 48362, 50057, 43408, 16572}, objArr9);
                    try {
                        Object[] objArr10 = {context, str, str2, str3, str4, true, (String) objArr9[0], 995651014};
                        Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-1276397751);
                        if (obj2 == null) {
                            obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getScrollBarFadeDuration() >> 16) + 911, (ViewConfiguration.getWindowTouchSlop() >> 8) + 18, (char) View.MeasureSpec.getMode(0))).getMethod("getAuthRequestContext", Context.class, String.class, String.class, String.class, String.class, Boolean.TYPE, String.class, Integer.TYPE);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(-1276397751, obj2);
                        }
                        ((Method) obj2).invoke(invoke, objArr10);
                    } catch (Throwable th) {
                        Throwable cause = th.getCause();
                        if (cause != null) {
                            throw cause;
                        }
                        throw th;
                    }
                } catch (Throwable th2) {
                    Throwable cause2 = th2.getCause();
                    if (cause2 != null) {
                        throw cause2;
                    }
                    throw th2;
                }
            }
        }
        return true;
    }

    @Override // android.content.ContentProvider
    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        return null;
    }

    @Override // android.content.ContentProvider
    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        return 0;
    }

    private static void a(char[] cArr, char[] cArr2, int i, char c, char[] cArr3, Object[] objArr) {
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
            cArr6[e.KClassImpl$Data$declaredNonStaticMembers$2] = (char) ((((cArr4[i3] ^ cArr3[e.KClassImpl$Data$declaredNonStaticMembers$2]) ^ (KClassImpl$Data$declaredNonStaticMembers$2 ^ 4360990799332652212L)) ^ ((int) (PlaceComponentResult ^ 4360990799332652212L))) ^ ((char) (getAuthRequestContext ^ 4360990799332652212L)));
            e.KClassImpl$Data$declaredNonStaticMembers$2++;
        }
        objArr[0] = new String(cArr6);
    }
}
