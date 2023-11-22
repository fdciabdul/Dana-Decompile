package com.huawei.agconnect.core.provider;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.graphics.ImageFormat;
import android.graphics.PointF;
import android.net.Uri;
import android.os.Process;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewConfiguration;
import com.fullstory.instrumentation.InstrumentInjector;
import com.huawei.agconnect.AGConnectInstance;
import java.lang.reflect.Method;
import o.SummaryVoucherView$$ExternalSyntheticLambda0;
import o.getOnBoardingScenario;

/* loaded from: classes7.dex */
public class AGConnectInitializeProvider extends ContentProvider {
    private static long MyBillsEntityDataFactory = 1565833348478714546L;

    @Override // android.content.ContentProvider
    public int delete(Uri uri, String str, String[] strArr) {
        return 0;
    }

    @Override // android.content.ContentProvider
    public String getType(Uri uri) {
        return null;
    }

    @Override // android.content.ContentProvider
    public Uri insert(Uri uri, ContentValues contentValues) {
        return null;
    }

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        Object[] objArr = new Object[1];
        a(TextUtils.indexOf((CharSequence) "", '0', 0) + 24890, new char[]{5008, 29350, 53735, 12328, 38778, 62853, 21699, 47952, 6742, 30851, 57317, 16082, 40239, 64635, 17036, 41411, 18, 26443}, objArr);
        Class<?> cls = Class.forName((String) objArr[0]);
        Object[] objArr2 = new Object[1];
        a(38069 - View.MeasureSpec.getSize(0), new char[]{5020, 34621, 15054, 44423, 16705}, objArr2);
        int intValue = ((Integer) cls.getDeclaredMethod((String) objArr2[0], new Class[0]).invoke(null, new Object[0])).intValue() % 100000;
        if (intValue < 99000 || intValue > 99999) {
            Object[] objArr3 = new Object[1];
            a(42443 - (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)), new char[]{5008, 46676, 22531, 58082, 33970, 12143, 61783, 39762, 15816, 51106, 27247, 3174, 54836, 30941, 671, 42365, 20279, 4579, 48067, 23961, 57465, 35390, 11505, 63145, 39064, 9030}, objArr3);
            Class<?> cls2 = Class.forName((String) objArr3[0]);
            Object[] objArr4 = new Object[1];
            a(31721 - (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)), new char[]{5010, 26733, 58449, 24632, 64560, 30738, 62707, 28911, 52425, 18608, 50311, 16539, 56702, 22853, 54587, 20799, 44302, 10726}, objArr4);
            Context context = (Context) cls2.getMethod((String) objArr4[0], new Class[0]).invoke(null, null);
            if (context != null) {
                context = context.getApplicationContext();
            }
            if (context != null) {
                try {
                    Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                    if (obj == null) {
                        obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - (ViewConfiguration.getMaximumFlingVelocity() >> 16), 35 - (ViewConfiguration.getScrollBarSize() >> 8), (char) (Process.getGidForName("") + 1))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                    }
                    Object invoke = ((Method) obj).invoke(null, null);
                    Object[] objArr5 = new Object[1];
                    a(View.combineMeasuredStates(0, 0) + 62417, new char[]{5062, 57411, 62565, 51386, 56453, 53376, 42286, 47486, 36174, 33229, 38328, 27244, 32344, 29278, 18094, 23288, 11984, 8993, 14197, 2835, 8129, 5047, 57444, 62464, 51213, 56491, 53491, 42142, 47391, 36152, 33262, 38363, 27112, 32310, 29185, 18011, 23283, 12029, 8911, 14102, 2926, 8174, 5007, 59356, 62591, 51327, 56393, 53451}, objArr5);
                    String str = (String) objArr5[0];
                    Object[] objArr6 = new Object[1];
                    a(58536 - Process.getGidForName(""), new char[]{5008, 63341, 55957, 48750, 33075, 25733, 18487, 21334, 14045, 6755, 64850, 49287, 42105, 36693, 37630, 30242, 22867, 15610, 'u', 60235, 52897, 53789, 46401, 39149, 31775, 18194, 10978, 3655, 4533, 62640, 55309, 41908, 34482, 27228, 19895, 20690, 13398, 8191, 58071, 50813, 43436, 36048, 36910, 31651, 24222, 8819, 1438, 59585, 52338, 55195, 47812, 40547, 24988, 17723, 10343, 13199, 5945, 64097, 56792, 41312, 33884, 28556, 29563, 22101}, objArr6);
                    String str2 = (String) objArr6[0];
                    Object[] objArr7 = new Object[1];
                    a(11897 - (ViewConfiguration.getJumpTapTimeout() >> 16), new char[]{5059, 15801, 20326, 39160, 43564, 64411, 1301, 22154, 24577, 45448, 50035, 60659, 15980, 20455, 39263, 43729, 62464, 1437, 22343, 24942, 45751, 56446, 60918, 16157, 18590, 39494, 43906, 62730, 1707, 20514, 25064, 45877, 56550, 60940, 16337, 18754, 39575, 42171, 63025, 1958, 20769, 25334, 35866, 56726, 61189, 14468, 18990, 39844, 42279, 63201, '0', 20879, 25431, 36045, 56849, 59451, 14782, 19253, 38050, 42532, 63435, 273, 21130, 31759}, objArr7);
                    String str3 = (String) objArr7[0];
                    Object[] objArr8 = new Object[1];
                    a(31956 - TextUtils.indexOf((CharSequence) "", '0', 0, 0), new char[]{5017, 28496, 59951, 26110, 57558, 25570, 65312, 31245, 62781, 28909, 62413, 20151, 51747, 17748, 49215, 17400, 57028, 22965, 54655, 20573, 54068, 12027, 43467, 9468, 41070, 9033, 48690, 14836, 46297, 14243, 45942, 3663, 35120, 1270, 34782, 704, 40550, 6487, 37890, 6061, 37592, 60828, 26986, 58393, 26372, 58094, 32208, 63631, 29810, 63296, 29252, 52712, 18567, 52167, 18298, 49732, 23820, 55538, 23495, 54933}, objArr8);
                    String str4 = (String) objArr8[0];
                    Object[] objArr9 = new Object[1];
                    a(14387 - (ViewConfiguration.getScrollDefaultDelay() >> 16), new char[]{5064, 11244, 25507, 47942, 62223, 2879}, objArr9);
                    try {
                        Object[] objArr10 = {context, str, str2, str3, str4, true, (String) objArr9[0], 995651014};
                        Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-1276397751);
                        if (obj2 == null) {
                            obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(ImageFormat.getBitsPerPixel(0) + 912, View.resolveSizeAndState(0, 0, 0) + 18, (char) (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)))).getMethod("getAuthRequestContext", Context.class, String.class, String.class, String.class, String.class, Boolean.TYPE, String.class, Integer.TYPE);
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
        InstrumentInjector.log_i("AGConnectProvider", "AGConnectInitializeProvider#onCreate");
        AGConnectInstance.MyBillsEntityDataFactory(getContext());
        return false;
    }

    @Override // android.content.ContentProvider
    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        return null;
    }

    @Override // android.content.ContentProvider
    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        return 0;
    }

    private static void a(int i, char[] cArr, Object[] objArr) {
        getOnBoardingScenario getonboardingscenario = new getOnBoardingScenario();
        getonboardingscenario.MyBillsEntityDataFactory = i;
        int length = cArr.length;
        long[] jArr = new long[length];
        getonboardingscenario.getAuthRequestContext = 0;
        while (getonboardingscenario.getAuthRequestContext < cArr.length) {
            jArr[getonboardingscenario.getAuthRequestContext] = (cArr[getonboardingscenario.getAuthRequestContext] ^ (getonboardingscenario.getAuthRequestContext * getonboardingscenario.MyBillsEntityDataFactory)) ^ (MyBillsEntityDataFactory ^ 4796183387843776835L);
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
