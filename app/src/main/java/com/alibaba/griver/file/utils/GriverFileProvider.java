package com.alibaba.griver.file.utils;

import android.content.Context;
import android.media.AudioTrack;
import android.os.Process;
import android.os.SystemClock;
import android.telephony.cdma.CdmaCellLocation;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.ViewConfiguration;
import android.widget.ExpandableListView;
import androidx.core.content.FileProvider;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.lang.reflect.Method;
import o.D;
import o.SummaryVoucherView$$ExternalSyntheticLambda0;

/* loaded from: classes6.dex */
public class GriverFileProvider extends FileProvider {
    private static long MyBillsEntityDataFactory = 6863254948670232641L;

    @Override // androidx.core.content.FileProvider, android.content.ContentProvider
    public boolean onCreate() {
        Object[] objArr = new Object[1];
        a(1 - (ViewConfiguration.getKeyRepeatTimeout() >> 16), new char[]{8663, 8630, 29158, 25633, 17757, 28267, 60113, 43608, 30492, 2053, 61433, 15849, 36080, 42659, 46815, 17483, 8777, 32219, 16694, 61146, 31540, 5227}, objArr);
        Class<?> cls = Class.forName((String) objArr[0]);
        Object[] objArr2 = new Object[1];
        a((ViewConfiguration.getMaximumDrawingCacheSize() >> 24) + 1, new char[]{7070, 7155, 56388, 51604, 25628, 20251, 54700, 38206, 19806}, objArr2);
        int intValue = ((Integer) cls.getDeclaredMethod((String) objArr2[0], new Class[0]).invoke(null, new Object[0])).intValue() % 100000;
        if (intValue < 99000 || intValue > 99999) {
            Object[] objArr3 = new Object[1];
            a((ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)), new char[]{47481, 47384, 55649, 52390, 11821, 1307, 44680, 60929, 61362, 41090, 33929, 31152, 5200, 3623, 56817, 'l', 47828, 54608, 10833, 43663, 58271, 48374, 32909, 30195, 2073, 2579, 55791, 7243, 48832, 53571}, objArr3);
            Class<?> cls2 = Class.forName((String) objArr3[0]);
            Object[] objArr4 = new Object[1];
            a((AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)) + 1, new char[]{21563, 21592, 28134, 30778, 22762, 29642, 3744, 20009, 762, 5145, 62024, 55799, 63747, 47803, 43836, 40963, 22452, 25038, 23680, 2727, 3780, 2157}, objArr4);
            Context context = (Context) cls2.getMethod((String) objArr4[0], new Class[0]).invoke(null, null);
            if (context != null) {
                context = context.getApplicationContext();
            }
            if (context != null) {
                try {
                    Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                    if (obj == null) {
                        obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - TextUtils.indexOf("", "", 0), TextUtils.getTrimmedLength("") + 35, (char) ((-1) - (ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1))))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                    }
                    Object invoke = ((Method) obj).invoke(null, null);
                    Object[] objArr5 = new Object[1];
                    a(-TextUtils.indexOf((CharSequence) "", '0'), new char[]{13415, 13392, 43733, 48927, 13594, 7806, 36275, 52592, 25331, 54070, 40881, 23255, 39192, 32139, 50823, 9045, 14318, 42680, 12657, 35233, 28358, 53015, 39850, 22170, 34103, 31137, 49819, 16233, 13275, 41645, 11628, 34247, 27177, 52062, 38865, 21090, 33150, 30176, 65086, 15186, 16325, 40523, 10576, 33279, 22072, 51048, 37872, 28197, 36105, 29081, 64022, 14098}, objArr5);
                    String str = (String) objArr5[0];
                    Object[] objArr6 = new Object[1];
                    a(1 - (CdmaCellLocation.convertQuartSecToDecDegrees(0) > FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 0 : -1)), new char[]{31887, 31982, 54347, 49623, 17085, 27097, 8930, 25213, 10829, 44451, 59423, 62938, 53667, 837, 45434, 35851, 32519, 55411, 18134, 9902, 9773, 45532, 60509, 63943, 52703, 1851, 46441, 36961, 31585, 56372, 23242, 10955, 8907, 46486, 57381, 64824, 51660, 2938, 35231, 37982, 30504, 57561, 24319, 12017, 7890, 47606, 58374, 49455, 50656, 3925, 36278, 38989, 29452, 58557, 21228, 13039, 6882, 47645, 63567, 50435, 49223, 4935, 33264, 40940, 28450, 59562, 22355, 14041}, objArr6);
                    String str2 = (String) objArr6[0];
                    Object[] objArr7 = new Object[1];
                    a(1 - (ViewConfiguration.getPressedStateDuration() >> 16), new char[]{51237, 51223, 33963, 37171, 10327, 864, 31381, 14860, 40632, 64841, 33444, 44455, 25941, 21498, 56258, 54398, 52216, 34965, 11374, 32476, 37588, 57711, 34486, 41443, 31011, 22412, 57223, 51216, 53194, 36052, 12403, 29415, 38463, 58736, 35481, 42264, 32050, 23454, 58144, 52271, 50051, 45161, 13376, 30347, 43637, 59716, 36587, 39259, 28945, 24502, 59231, 49257, 51187, 46163, 14337, 27330, 44611, 60159, 37536, 40310, 29930, 17319, 60179, 51145, 56287, 47171, 15803, 28322}, objArr7);
                    String str3 = (String) objArr7[0];
                    Object[] objArr8 = new Object[1];
                    a(1 - KeyEvent.getDeadChar(0, 0), new char[]{41074, 40986, 2043, 4646, 45835, 38957, 28370, 11865, 63141, 32337, 6644, 47593, 3422, 53430, 16601, 49275, 41904, 3015, 46971, 27340, 64135, 25214, 7611, 46513, 4391, 54408, 17631, 56408, 42957, 4050, 43878, 26360, 65130, 26224, 4498, 45403, 5427, 55453, 30778, 55404, 43989, 13092, 44886, 25289, 49787, 27207, 5630, 36117, 6423, 56573, 31764, 54331, 44977, 14091, 41728, 32388, 50708, 27124, 2542, 35168, 7407, 49385, 28691, 54233}, objArr8);
                    String str4 = (String) objArr8[0];
                    Object[] objArr9 = new Object[1];
                    a((SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)), new char[]{12852, 12813, 30250, 25517, 13667, 7685, 2723, 19062, 25762, 4049}, objArr9);
                    try {
                        Object[] objArr10 = {context, str, str2, str3, str4, true, (String) objArr9[0], 995651014};
                        Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-1276397751);
                        if (obj2 == null) {
                            obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - (Process.myPid() >> 22), 18 - (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)), (char) ((-1) - TextUtils.lastIndexOf("", '0', 0, 0)))).getMethod("getAuthRequestContext", Context.class, String.class, String.class, String.class, String.class, Boolean.TYPE, String.class, Integer.TYPE);
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
        return super.onCreate();
    }

    private static void a(int i, char[] cArr, Object[] objArr) {
        D d = new D();
        char[] KClassImpl$Data$declaredNonStaticMembers$2 = D.KClassImpl$Data$declaredNonStaticMembers$2(MyBillsEntityDataFactory ^ 3919452569568103912L, cArr, i);
        d.MyBillsEntityDataFactory = 4;
        while (d.MyBillsEntityDataFactory < KClassImpl$Data$declaredNonStaticMembers$2.length) {
            d.PlaceComponentResult = d.MyBillsEntityDataFactory - 4;
            KClassImpl$Data$declaredNonStaticMembers$2[d.MyBillsEntityDataFactory] = (char) ((KClassImpl$Data$declaredNonStaticMembers$2[d.MyBillsEntityDataFactory] ^ KClassImpl$Data$declaredNonStaticMembers$2[d.MyBillsEntityDataFactory % 4]) ^ (d.PlaceComponentResult * (MyBillsEntityDataFactory ^ 3919452569568103912L)));
            d.MyBillsEntityDataFactory++;
        }
        objArr[0] = new String(KClassImpl$Data$declaredNonStaticMembers$2, 4, KClassImpl$Data$declaredNonStaticMembers$2.length - 4);
    }
}
