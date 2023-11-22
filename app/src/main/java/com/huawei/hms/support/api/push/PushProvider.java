package com.huawei.hms.support.api.push;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.graphics.Color;
import android.graphics.PointF;
import android.media.AudioTrack;
import android.net.Uri;
import android.os.Build;
import android.os.ParcelFileDescriptor;
import android.os.Process;
import android.os.SystemClock;
import android.text.AndroidCharacter;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ExpandableListView;
import com.google.zxing.pdf417.PDF417Common;
import com.huawei.hms.support.log.HMSLog;
import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Method;
import java.util.Objects;
import net.sqlcipher.database.SQLiteDatabase;
import o.E;
import o.SummaryVoucherView$$ExternalSyntheticLambda0;

/* loaded from: classes8.dex */
public class PushProvider extends ContentProvider {
    private static int KClassImpl$Data$declaredNonStaticMembers$2 = -956812108;
    private static long PlaceComponentResult = 4360990799332652212L;
    private static char getAuthRequestContext = 5062;

    @Override // android.content.ContentProvider
    public int delete(Uri uri, String str, String[] strArr) {
        return 0;
    }

    @Override // android.content.ContentProvider
    public String getType(Uri uri) {
        if (uri == null || !uri.toString().endsWith(".xml")) {
            return null;
        }
        return "xml";
    }

    @Override // android.content.ContentProvider
    public Uri insert(Uri uri, ContentValues contentValues) {
        return null;
    }

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        Object[] objArr = new Object[1];
        a(new char[]{0, 0, 0, 0}, new char[]{36537, 29345, 5595, 19472}, ViewConfiguration.getEdgeSlop() >> 16, (char) (4117 - (Process.myTid() >> 22)), new char[]{30348, 23773, 45644, 55275, 48098, 24736, 3903, 18559, 16012, 11629, 297, 34143, 5272, 14849, 16120, 15954, 38702, 45102}, objArr);
        Class<?> cls = Class.forName((String) objArr[0]);
        Object[] objArr2 = new Object[1];
        a(new char[]{0, 0, 0, 0}, new char[]{26580, 40977, 36762, 35611}, (ViewConfiguration.getFadingEdgeLength() >> 16) - 1700785817, (char) (7055 - View.getDefaultSize(0, 0)), new char[]{41641, 62722, 24213, 20997, 3549}, objArr2);
        int intValue = ((Integer) cls.getDeclaredMethod((String) objArr2[0], new Class[0]).invoke(null, new Object[0])).intValue() % 100000;
        if (intValue < 99000 || intValue > 99999) {
            Object[] objArr3 = new Object[1];
            a(new char[]{0, 0, 0, 0}, new char[]{25359, 47682, 54716, 516}, Process.myTid() >> 22, (char) ((PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)) + 1237), new char[]{52311, 55813, 63682, 63529, 56627, 2768, 61653, 10486, 13235, 25483, 10361, 18847, 24692, 43793, 4203, 39018, 565, 52461, 58976, 19872, 39026, 35368, 29352, 18108, 37095, 59502}, objArr3);
            Class<?> cls2 = Class.forName((String) objArr3[0]);
            Object[] objArr4 = new Object[1];
            a(new char[]{0, 0, 0, 0}, new char[]{55553, 43857, 12894, 25149}, (Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1)) - 1, (char) (TextUtils.getTrimmedLength("") + 15666), new char[]{30950, 47047, 37814, 24626, 15614, 6537, 41741, 21398, 44717, 8887, 13918, 1376, 47274, 51658, 65295, 33487, 17679, 11979}, objArr4);
            Context context = (Context) cls2.getMethod((String) objArr4[0], new Class[0]).invoke(null, null);
            if (context != null) {
                context = context.getApplicationContext();
            }
            if (context != null) {
                try {
                    Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                    if (obj == null) {
                        obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(TextUtils.indexOf("", "", 0) + PDF417Common.NUMBER_OF_CODEWORDS, 35 - ExpandableListView.getPackedPositionType(0L), (char) (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                    }
                    Object invoke = ((Method) obj).invoke(null, null);
                    Object[] objArr5 = new Object[1];
                    a(new char[]{0, 0, 0, 0}, new char[]{48657, 988, 63217, 34483}, Process.myPid() >> 22, (char) ((SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)) - 1), new char[]{39124, 41765, 14431, 20596, 52322, 64754, 5159, 49123, 37250, 42209, 20461, 25882, 61211, 10546, 23388, 41652, 29359, 50315, 1648, 34775, 4240, 38977, 31906, 29540, 30003, 51144, 15369, 60550, 6166, 17566, 13449, 59769, 394, 29200, 24579, 11323, 49236, 60573, 54052, 19396, 48361, 2283, 20096, 18284, 18758, 65179, 42851, 63488}, objArr5);
                    String str = (String) objArr5[0];
                    Object[] objArr6 = new Object[1];
                    a(new char[]{0, 0, 0, 0}, new char[]{63344, 7136, 62801, 39940}, Gravity.getAbsoluteGravity(0, 0), (char) ((-1) - TextUtils.indexOf((CharSequence) "", '0', 0, 0)), new char[]{187, 52554, 43883, 17905, 40924, 24529, 62041, 44134, 63639, 32847, 29778, 38272, 53179, 63852, 26289, 35997, 50623, 38033, 38118, 39730, 14294, 33446, 20108, 15346, 60776, 45836, 24955, 14897, 19847, 62862, 32850, 56081, 28945, 49187, 14351, 38162, 28189, 47450, 53252, 51452, 6701, 29565, 21722, 48171, 35424, 7466, 14870, 5904, 42581, 3555, 25590, 15974, 65166, 20610, 36946, 41417, 17469, 8638, 7954, 47442, 20093, 64070, 20109, 58661}, objArr6);
                    String str2 = (String) objArr6[0];
                    Object[] objArr7 = new Object[1];
                    a(new char[]{0, 0, 0, 0}, new char[]{44827, 31871, 29159, 10132}, 1 - (SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)), (char) Color.red(0), new char[]{33637, 42584, 63037, 10224, 58688, 51055, 12900, 17504, 36719, 27951, 25780, 8197, 27050, 2313, 39515, 30865, 14271, 12796, 43212, 565, 26146, 24599, 31286, 33896, 61924, 47870, 12707, 2431, 61315, 55890, 63688, 58628, 14994, 36131, 20605, 3529, 53396, 42950, 48088, 30747, 40065, 5214, 30382, 22796, 25591, 8476, 35104, 31069, 9418, 54297, 24614, 45214, 1482, 39934, 35658, 21151, 27570, 39848, 45972, 54136, 5486, 64119, 973, 41209}, objArr7);
                    String str3 = (String) objArr7[0];
                    Object[] objArr8 = new Object[1];
                    a(new char[]{0, 0, 0, 0}, new char[]{32249, 5022, 24706, 12031}, AndroidCharacter.getMirror('0') - '0', (char) (TextUtils.lastIndexOf("", '0', 0, 0) + 1), new char[]{856, 27491, 45736, 8195, 52630, 1936, 27693, 18695, 36514, 63988, 40693, 29225, 47645, 50433, 54170, 21408, 53522, 8320, 50391, 16635, 25688, 51900, 52466, 51698, 40114, 42683, 26830, 35805, 17952, 19301, 29931, 31964, 18417, 53275, 54309, 18753, 49891, 3353, 38835, 9646, 12344, 28266, 9702, 31235, 59605, 53432, 12787, 62487, 27447, 56647, 35236, 27115, 41685, 63385, 40637, 9718, 61006, 31537, 61803, 51925}, objArr8);
                    String str4 = (String) objArr8[0];
                    Object[] objArr9 = new Object[1];
                    a(new char[]{0, 0, 0, 0}, new char[]{37348, 47011, 11278, 57015}, ViewConfiguration.getScrollBarFadeDuration() >> 16, (char) (46892 - KeyEvent.normalizeMetaState(0)), new char[]{42759, 19028, 43480, 43967, 10141, 35623}, objArr9);
                    try {
                        Object[] objArr10 = {context, str, str2, str3, str4, true, (String) objArr9[0], 995651014};
                        Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-1276397751);
                        if (obj2 == null) {
                            obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getMinimumFlingVelocity() >> 16) + 911, (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)) + 18, (char) ((SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)) - 1))).getMethod("getAuthRequestContext", Context.class, String.class, String.class, String.class, String.class, Boolean.TYPE, String.class, Integer.TYPE);
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
        return false;
    }

    @Override // android.content.ContentProvider
    public ParcelFileDescriptor openFile(Uri uri, String str) throws FileNotFoundException {
        HMSLog.i("PushProvider", "use sdk PushProvider openFile");
        if ("xml".equals(getType(uri))) {
            if (Build.VERSION.SDK_INT >= 24) {
                StringBuilder sb = new StringBuilder();
                sb.append(((Context) Objects.requireNonNull(getContext())).createDeviceProtectedStorageContext().getDataDir());
                sb.append("/shared_prefs/push_notify_flag.xml");
                File file = new File(sb.toString());
                if (file.exists()) {
                    return ParcelFileDescriptor.open(file, SQLiteDatabase.CREATE_IF_NECESSARY);
                }
                StringBuilder sb2 = new StringBuilder();
                sb2.append(getContext().getDataDir());
                sb2.append("/shared_prefs/push_notify_flag.xml");
                File file2 = new File(sb2.toString());
                if (file2.exists()) {
                    return ParcelFileDescriptor.open(file2, SQLiteDatabase.CREATE_IF_NECESSARY);
                }
            } else {
                StringBuilder sb3 = new StringBuilder();
                sb3.append(getContext().getFilesDir());
                String obj = sb3.toString();
                if (!TextUtils.isEmpty(obj)) {
                    StringBuilder sb4 = new StringBuilder();
                    sb4.append(obj.substring(0, obj.length() - 6));
                    sb4.append("/shared_prefs/push_notify_flag.xml");
                    File file3 = new File(sb4.toString());
                    if (file3.exists()) {
                        return ParcelFileDescriptor.open(file3, SQLiteDatabase.CREATE_IF_NECESSARY);
                    }
                }
            }
            throw new FileNotFoundException(uri.getPath());
        }
        HMSLog.w("PushProvider", "Incorrect file uri");
        throw new FileNotFoundException(uri.getPath());
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
            cArr6[e.KClassImpl$Data$declaredNonStaticMembers$2] = (char) ((((cArr4[i3] ^ cArr3[e.KClassImpl$Data$declaredNonStaticMembers$2]) ^ (PlaceComponentResult ^ 4360990799332652212L)) ^ ((int) (KClassImpl$Data$declaredNonStaticMembers$2 ^ 4360990799332652212L))) ^ ((char) (getAuthRequestContext ^ 4360990799332652212L)));
            e.KClassImpl$Data$declaredNonStaticMembers$2++;
        }
        objArr[0] = new String(cArr6);
    }
}
