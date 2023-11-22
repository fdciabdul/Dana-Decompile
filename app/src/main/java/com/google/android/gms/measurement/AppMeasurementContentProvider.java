package com.google.android.gms.measurement;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.pm.ProviderInfo;
import android.database.Cursor;
import android.graphics.Color;
import android.graphics.ImageFormat;
import android.graphics.PointF;
import android.graphics.drawable.Drawable;
import android.media.AudioTrack;
import android.net.Uri;
import android.telephony.cdma.CdmaCellLocation;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import android.widget.ExpandableListView;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.measurement.internal.zzfy;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.google.zxing.pdf417.PDF417Common;
import java.lang.reflect.Method;
import o.SummaryVoucherView$$ExternalSyntheticLambda0;
import o.whenAvailable;

@Deprecated
/* loaded from: classes7.dex */
public class AppMeasurementContentProvider extends ContentProvider {
    private static char[] KClassImpl$Data$declaredNonStaticMembers$2 = {62255, 11972, 18658, 27280, 33969, 42579, 49266, 57948, 7169, 15929, 22920, 31698, 38284, 47029, 53589, 62327, 11645, 20249, 33720, 24136, 14408, 6672, 62497, 62937, 10290, 19988, 27750, 33351, 41125, 50820, 58538, 6905, 14540, 24352, 32090, 37705, 45391, 55220, 62861, 11150, 18933, 28612, 33325, 41020, 50788, 58450, 6817, 14521, 24216, 47631, 26621, 470, 9138, 52633, 61302, 35136, 43793, 21820, 30488, 4328, 13001, 56511, 65177, 39008, 47705, 25667, 1574, 54290, 2466, 28635, 19889, 41861, 33077, 59204, 50465, 15154, 6468, 32430, 23695, 45808, 36995, 63084, 54351, 2644, 26672, 19995, 41896, 33169, 59378, 50654, 15215, 6433, 32594, 23861, 45901, 37095, 63125, 54524, 2780, 26780, 20087, 44127, 33328, 57427, 50664, 15301, 6569, 32690, 24007, 45945, 37215, 63351, 54530, 2795, 26780, 17937, 39841, 64910, 57272, 12678, 4925, 29976, 22388, 43316, 35607, 60577, 52873, 8356, 725, 25657, 17944, 38914, 64102, 56350, 12717, 5060, 30197, 22494, 43327, 35622, 60758, 53089, 8473, 696, 25792, 18170, 39134, 64147, 56432, 15884, 4196, 29187, 22503, 43416, 35839, 60901, 53188, 8573, 781, 25891, 18259, 39097, 64155, 56451, 16103, 4303, 29221, 21529, 46707, 34904, 60861, 53152, 8581, 955, 26014, 18225, 39196, 64300, 56671, 62332, 11931, 18659, 27264, 34023, 42509, 49188, 57926, 7254, 15986, 22942, 31667, 38351, 47081, 53510, 62245, 11631, 20239, 26994, 33990, 42668, 49304, 58039, 7169, 15897, 22636, 31327, 38010, 47064, 53756, 62401, 11697, 20473, 26958, 35636, 42330, 51004, 57997, 7328, 16074, 22742, 31404, 37911, 46646, 53318, 62058, 11735, 20464, 27112, 35795, 42405, 51015, 57644, 843, 15664, 22663, 31385, 38079, 46815, 53492, 62040, 11311, 20035, 26731, 20001, 37849, 62965, 55189, 14762, 6919, 32062, 24410, 41229, 33580, 58575, 50916, 10455, 2729, 27737, 20071, 36972, 61964, 54325, 14790, 7160, 32142, 24485, 41243, 33614, 58744, 50944, 10551, 2781, 27886, 20096, 37024, 62120, 54367, 13924, 6219, 31290, 24530, 41468, 33754, 58760, 51133, 10568, 2858, 27920, 20275, 37078, 62192, 54522, 13977, 6382, 31315, 23595, 48722, 32820, 58819, 51148, 10723, 2965, 28086, 62327, 11908, 18610, 27340, 34028, 42507};
    private static long getAuthRequestContext = -5117417894710858070L;

    @Override // android.content.ContentProvider
    public void attachInfo(Context context, ProviderInfo providerInfo) {
        super.attachInfo(context, providerInfo);
        if ("com.google.android.gms.measurement.google_measurement_service".equals(providerInfo.authority)) {
            throw new IllegalStateException("Incorrect provider authority in manifest. Most likely due to a missing applicationId variable in application's build.gradle.");
        }
    }

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
        a((ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)) + 17, ViewConfiguration.getMinimumFlingVelocity() >> 16, (char) ExpandableListView.getPackedPositionType(0L), objArr);
        Class<?> cls = Class.forName((String) objArr[0]);
        Object[] objArr2 = new Object[1];
        a(Color.blue(0) + 5, 19 - (ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)), (char) (MotionEvent.axisFromString("") + 28828), objArr2);
        int intValue = ((Integer) cls.getDeclaredMethod((String) objArr2[0], new Class[0]).invoke(null, new Object[0])).intValue() % 100000;
        if (intValue < 99000 || intValue > 99999) {
            Object[] objArr3 = new Object[1];
            a(26 - (ViewConfiguration.getKeyRepeatDelay() >> 16), 24 - (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1)), (char) (Color.argb(0, 0, 0, 0) + 1782), objArr3);
            Class<?> cls2 = Class.forName((String) objArr3[0]);
            Object[] objArr4 = new Object[1];
            a(18 - (ViewConfiguration.getMaximumFlingVelocity() >> 16), 49 - Drawable.resolveOpacity(0, 0), (char) (ImageFormat.getBitsPerPixel(0) + 18723), objArr4);
            Context context = (Context) cls2.getMethod((String) objArr4[0], new Class[0]).invoke(null, null);
            if (context != null) {
                context = context.getApplicationContext();
            }
            if (context != null) {
                try {
                    Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                    if (obj == null) {
                        obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getScrollDefaultDelay() >> 16) + PDF417Common.NUMBER_OF_CODEWORDS, Drawable.resolveOpacity(0, 0) + 35, (char) (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                    }
                    Object invoke = ((Method) obj).invoke(null, null);
                    Object[] objArr5 = new Object[1];
                    a(48 - (CdmaCellLocation.convertQuartSecToDecDegrees(0) > FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 0 : -1)), (ViewConfiguration.getDoubleTapTimeout() >> 16) + 67, (char) ((AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)) + 10090), objArr5);
                    String str = (String) objArr5[0];
                    Object[] objArr6 = new Object[1];
                    a(TextUtils.lastIndexOf("", '0', 0, 0) + 65, (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1)) + 114, (char) (TextUtils.lastIndexOf("", '0', 0) + 46399), objArr6);
                    String str2 = (String) objArr6[0];
                    Object[] objArr7 = new Object[1];
                    a(TextUtils.lastIndexOf("", '0') + 65, 178 - TextUtils.lastIndexOf("", '0', 0), (char) (TextUtils.indexOf((CharSequence) "", '0') + 1), objArr7);
                    String str3 = (String) objArr7[0];
                    Object[] objArr8 = new Object[1];
                    a(TextUtils.indexOf("", "", 0, 0) + 60, (ViewConfiguration.getMaximumFlingVelocity() >> 16) + 243, (char) ((ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)) + 48392), objArr8);
                    String str4 = (String) objArr8[0];
                    Object[] objArr9 = new Object[1];
                    a(5 - TextUtils.lastIndexOf("", '0', 0, 0), 303 - (KeyEvent.getMaxKeyCode() >> 16), (char) (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)), objArr9);
                    try {
                        Object[] objArr10 = {context, str, str2, str3, str4, true, (String) objArr9[0], 995651014};
                        Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-1276397751);
                        if (obj2 == null) {
                            obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getKeyRepeatDelay() >> 16) + 911, 18 - (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)), (char) (ViewConfiguration.getScrollBarSize() >> 8))).getMethod("getAuthRequestContext", Context.class, String.class, String.class, String.class, String.class, Boolean.TYPE, String.class, Integer.TYPE);
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
        Context context2 = getContext();
        Preconditions.checkNotNull(context2);
        zzfy.zzp(context2, null, null);
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

    private static void a(int i, int i2, char c, Object[] objArr) {
        whenAvailable whenavailable = new whenAvailable();
        long[] jArr = new long[i];
        whenavailable.BuiltInFictitiousFunctionClassFactory = 0;
        while (whenavailable.BuiltInFictitiousFunctionClassFactory < i) {
            jArr[whenavailable.BuiltInFictitiousFunctionClassFactory] = (((char) (KClassImpl$Data$declaredNonStaticMembers$2[whenavailable.BuiltInFictitiousFunctionClassFactory + i2] ^ (-4773380863230414002L))) ^ (whenavailable.BuiltInFictitiousFunctionClassFactory * ((-4773380863230414002L) ^ getAuthRequestContext))) ^ c;
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
