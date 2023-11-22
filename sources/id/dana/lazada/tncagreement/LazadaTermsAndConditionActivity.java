package id.dana.lazada.tncagreement;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.PointF;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Process;
import android.os.SystemClock;
import android.telephony.cdma.CdmaCellLocation;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.Button;
import android.widget.ExpandableListView;
import butterknife.BindView;
import butterknife.OnClick;
import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.google.common.base.Ascii;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.google.zxing.pdf417.PDF417Common;
import id.dana.R;
import id.dana.base.BaseWebViewActivity;
import id.dana.data.constant.DanaUrl;
import id.dana.onboarding.splash.LauncherActivity;
import id.dana.richview.WebProgressView;
import id.dana.utils.UrlUtil;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import o.E;
import o.SummaryVoucherView$$ExternalSyntheticLambda0;

/* loaded from: classes5.dex */
public class LazadaTermsAndConditionActivity extends BaseWebViewActivity {
    public static final String LAZADA_TNC_ACTION_RESULT = "LAZADA_TNC_ACTION_RESULT";
    @BindView(R.id.btn_lazada_agree)
    Button btnAgree;
    @BindView(R.id.view_web_progress)
    WebProgressView viewWebProgress;
    public static final byte[] $$g = {104, -68, 0, 44, TarHeader.LF_CHR, -48, 46, 10, 7, 14, -39, TarHeader.LF_NORMAL, 13, -4, 18, 12, -46, 36, Ascii.SUB, -12, -20, 34, 9, Ascii.CAN, 2, 10, 14, 5, 22, -44, 59, 6, -5, -15, Ascii.SUB, 19, 11, -9, Ascii.NAK, 8, -42, TarHeader.LF_CHR, 6, 13, -8, Ascii.SUB, 3, -1, TarHeader.LF_NORMAL, -4, Ascii.EM, 7, -35, 43, 10, 3, -65, 39, 36, Ascii.SUB, -12, -54, 71, 8, 5, 16, -4, Ascii.CAN, -6, 6, -15, 40, 6, -20, 40, -12, Ascii.SUB, -4, 1, -15, Ascii.US, 15, -4, 10, Ascii.DC4, 8, -72, Ascii.NAK};
    public static final int $$h = 121;
    public static final byte[] NetworkUserEntityData$$ExternalSyntheticLambda0 = {Ascii.ESC, 47, Ascii.SUB, Ascii.GS, -17, 6, -18, -1, 2, 1, TarHeader.LF_SYMLINK, -57, -16, -3, -10, 11, -13, -10, 66, -25, -48, -3, -10, 11, -23, 0, 1, -5, -13, -10, 7, -15, -9, 45, -29, -22, 7, 33, -48, 7, -5, 5, -25, 17, 47, -66, 7, -17, 3, TarHeader.LF_DIR, -41, -42, 2, -5, 11, -12, -2, -19, 47, -51, -4, 0, -1, 2, -2, -23, 7, -10, -3, 33, -41, 4, -13};
    public static final int getErrorConfigVersion = 129;
    private static char NetworkUserEntityData$$ExternalSyntheticLambda1 = 13492;
    private static long lookAheadTest = -2498120675902059684L;
    private static int scheduleImpl = -956812108;

    /* JADX WARN: Removed duplicated region for block: B:10:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x001d  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0025 -> B:11:0x002f). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void h(int r6, byte r7, short r8, java.lang.Object[] r9) {
        /*
            byte[] r0 = id.dana.lazada.tncagreement.LazadaTermsAndConditionActivity.NetworkUserEntityData$$ExternalSyntheticLambda0
            int r6 = 106 - r6
            int r8 = 23 - r8
            int r7 = 55 - r7
            byte[] r1 = new byte[r8]
            int r8 = r8 + (-1)
            r2 = 0
            if (r0 != 0) goto L15
            r3 = r1
            r4 = 0
            r1 = r0
            r0 = r9
            r9 = r8
            goto L2f
        L15:
            r3 = 0
        L16:
            byte r4 = (byte) r6
            r1[r3] = r4
            int r4 = r3 + 1
            if (r3 != r8) goto L25
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            r9[r2] = r6
            return
        L25:
            int r7 = r7 + 1
            r3 = r0[r7]
            r5 = r9
            r9 = r8
            r8 = r3
            r3 = r1
            r1 = r0
            r0 = r5
        L2f:
            int r8 = -r8
            int r6 = r6 + r8
            int r6 = r6 + (-4)
            r8 = r9
            r9 = r0
            r0 = r1
            r1 = r3
            r3 = r4
            goto L16
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.lazada.tncagreement.LazadaTermsAndConditionActivity.h(int, byte, short, java.lang.Object[]):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x002f  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0027  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x002f -> B:11:0x0039). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void j(byte r6, int r7, short r8, java.lang.Object[] r9) {
        /*
            int r8 = r8 + 4
            int r7 = r7 * 2
            int r7 = 103 - r7
            int r6 = r6 * 3
            int r6 = r6 + 21
            byte[] r0 = id.dana.lazada.tncagreement.LazadaTermsAndConditionActivity.$$g
            byte[] r1 = new byte[r6]
            int r6 = r6 + (-1)
            r2 = 0
            if (r0 != 0) goto L1a
            r7 = r6
            r3 = r1
            r4 = 0
            r1 = r0
            r0 = r9
            r9 = r8
            goto L39
        L1a:
            r3 = 0
            r5 = r8
            r8 = r7
        L1d:
            r7 = r5
            byte r4 = (byte) r8
            r1[r3] = r4
            int r7 = r7 + 1
            int r4 = r3 + 1
            if (r3 != r6) goto L2f
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            r9[r2] = r6
            return
        L2f:
            r3 = r0[r7]
            r5 = r7
            r7 = r6
            r6 = r3
            r3 = r1
            r1 = r0
            r0 = r9
            r9 = r8
            r8 = r5
        L39:
            int r9 = r9 + r6
            int r6 = r9 + (-7)
            r9 = r0
            r0 = r1
            r1 = r3
            r3 = r4
            r5 = r8
            r8 = r6
            r6 = r7
            goto L1d
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.lazada.tncagreement.LazadaTermsAndConditionActivity.j(byte, int, short, java.lang.Object[]):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:111:0x0576  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x057b  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x057f  */
    /* JADX WARN: Removed duplicated region for block: B:157:0x0751  */
    /* JADX WARN: Removed duplicated region for block: B:158:0x0756  */
    /* JADX WARN: Removed duplicated region for block: B:160:0x075a  */
    /* JADX WARN: Removed duplicated region for block: B:203:0x092f  */
    /* JADX WARN: Removed duplicated region for block: B:204:0x0934  */
    /* JADX WARN: Removed duplicated region for block: B:206:0x0938  */
    /* JADX WARN: Removed duplicated region for block: B:248:0x0b04 A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:263:0x0295 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0284  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0289  */
    @Override // id.dana.base.BaseWebViewActivity, id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void attachBaseContext(android.content.Context r30) {
        /*
            Method dump skipped, instructions count: 3228
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.lazada.tncagreement.LazadaTermsAndConditionActivity.attachBaseContext(android.content.Context):void");
    }

    @Override // id.dana.base.BaseWebViewActivity, id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.content.ContextWrapper, android.content.Context
    public Context getApplicationContext() {
        return super.getApplicationContext();
    }

    @Override // id.dana.base.BaseWebViewActivity, id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.content.ContextWrapper
    public Context getBaseContext() {
        return super.getBaseContext();
    }

    @Override // id.dana.base.BaseWebViewActivity, id.dana.base.BaseActivity
    public int getLayout() {
        return R.layout.activity_tnc_lazada_agreement;
    }

    @Override // id.dana.base.BaseWebViewActivity, id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public Resources getResources() {
        return super.getResources();
    }

    @Override // id.dana.base.BaseWebViewActivity, id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Object[] objArr;
        Object[] objArr2 = new Object[1];
        g(new char[]{49128, 56372, 48765, 57809}, new char[]{44639, 14354, 48357, 26984, 26988, 24473, 3126, 19679, 43271, 5417, 20890, 16461, 51275, 19396, 59564, 29810, 31550, 24110}, (char) (getPackageName().codePointAt(0) + 12979), super.getResources().getString(R.string.success_hide_dana_balance_msg).substring(19, 20).codePointAt(0) - 32, new char[]{51366, 37864, 7252, 16947}, objArr2);
        Class<?> cls = Class.forName((String) objArr2[0]);
        char[] cArr = {49128, 56372, 48765, 57809};
        char[] cArr2 = {51923, 8636, 26671, 53880, 56548};
        try {
            Object[] objArr3 = new Object[1];
            h((byte) (-NetworkUserEntityData$$ExternalSyntheticLambda0[32]), (byte) (NetworkUserEntityData$$ExternalSyntheticLambda0[49] - 1), NetworkUserEntityData$$ExternalSyntheticLambda0[25], objArr3);
            Class<?> cls2 = Class.forName((String) objArr3[0]);
            Object[] objArr4 = new Object[1];
            h(NetworkUserEntityData$$ExternalSyntheticLambda0[48], NetworkUserEntityData$$ExternalSyntheticLambda0[25], NetworkUserEntityData$$ExternalSyntheticLambda0[41], objArr4);
            char c = (char) (((ApplicationInfo) cls2.getMethod((String) objArr4[0], null).invoke(this, null)).targetSdkVersion + 57041);
            try {
                Object[] objArr5 = new Object[1];
                h((byte) (-NetworkUserEntityData$$ExternalSyntheticLambda0[32]), (byte) (NetworkUserEntityData$$ExternalSyntheticLambda0[49] - 1), NetworkUserEntityData$$ExternalSyntheticLambda0[25], objArr5);
                Class<?> cls3 = Class.forName((String) objArr5[0]);
                h(NetworkUserEntityData$$ExternalSyntheticLambda0[48], NetworkUserEntityData$$ExternalSyntheticLambda0[25], NetworkUserEntityData$$ExternalSyntheticLambda0[41], new Object[1]);
                Object[] objArr6 = new Object[1];
                g(cArr, cArr2, c, ((ApplicationInfo) cls3.getMethod((String) r15[0], null).invoke(this, null)).targetSdkVersion - 751011288, new char[]{18853, 15482, 62163, 40926}, objArr6);
                int intValue = ((Integer) cls.getDeclaredMethod((String) objArr6[0], new Class[0]).invoke(null, new Object[0])).intValue() % 100000;
                if (intValue < 99000 || intValue > 99999) {
                    Context baseContext = getBaseContext();
                    if (baseContext == null) {
                        Object[] objArr7 = new Object[1];
                        g(new char[]{49128, 56372, 48765, 57809}, new char[]{19076, 26519, 141, 55860, 43227, 46080, 32042, 25802, 50886, 55282, 5465, 54153, 33632, 1942, 32089, 43991, 41933, 19099, 53978, 55482, 6860, 21125, 47331, 34507, 24914, 57149}, (char) (51645 - (ViewConfiguration.getDoubleTapTimeout() >> 16)), KeyEvent.getMaxKeyCode() >> 16, new char[]{9948, 36857, 48616, 24009}, objArr7);
                        Class<?> cls4 = Class.forName((String) objArr7[0]);
                        char[] cArr3 = {49128, 56372, 48765, 57809};
                        char[] cArr4 = {41921, 14690, 44640, 8737, 7674, 11202, 64514, 41342, 7396, 33178, 27880, 15017, 44669, 53146, 57347, 20473, 43327, 46112};
                        char c2 = (char) ((ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)) + 29816);
                        try {
                            Object[] objArr8 = new Object[1];
                            h((byte) (-NetworkUserEntityData$$ExternalSyntheticLambda0[32]), (byte) (NetworkUserEntityData$$ExternalSyntheticLambda0[49] - 1), NetworkUserEntityData$$ExternalSyntheticLambda0[25], objArr8);
                            Class<?> cls5 = Class.forName((String) objArr8[0]);
                            h(NetworkUserEntityData$$ExternalSyntheticLambda0[48], NetworkUserEntityData$$ExternalSyntheticLambda0[25], NetworkUserEntityData$$ExternalSyntheticLambda0[41], new Object[1]);
                            Object[] objArr9 = new Object[1];
                            g(cArr3, cArr4, c2, ((ApplicationInfo) cls5.getMethod((String) r15[0], null).invoke(this, null)).targetSdkVersion - 33, new char[]{16343, 11314, 31215, 9588}, objArr9);
                            baseContext = (Context) cls4.getMethod((String) objArr9[0], new Class[0]).invoke(null, null);
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
                                obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(Color.argb(0, 0, 0, 0) + PDF417Common.NUMBER_OF_CODEWORDS, (ViewConfiguration.getFadingEdgeLength() >> 16) + 35, (char) Drawable.resolveOpacity(0, 0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                            }
                            Object invoke = ((Method) obj).invoke(null, null);
                            Object[] objArr10 = new Object[1];
                            g(new char[]{49128, 56372, 48765, 57809}, new char[]{4855, 50121, 44789, 4860, 51014, 15123, 32308, 2621, 36419, 33222, 11060, 30359, 28875, 27234, 837, 35279, 44785, 20725, 51585, 45923, 25665, 6801, 18350, 34069, 42567, 19903, 52209, 16528, 33039, 42980, 39777, 11315, 30954, 17316, 50447, 45964, 51316, 40161, 9694, 46525, 34690, 52636, 12507, 22844, 18708, 19447, 11213, 10278}, (char) (ViewConfiguration.getMaximumFlingVelocity() >> 16), (ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)) + 1, new char[]{57681, 20788, 65366, 24549}, objArr10);
                            String str = (String) objArr10[0];
                            char[] cArr5 = {49128, 56372, 48765, 57809};
                            char[] cArr6 = {10552, 56244, 16706, 10677, 59652, 45105, 6694, 31884, 34464, 44540, 65196, 64268, 61454, 19723, 34072, 32546, 37195, 62606, 39030, 9115, 28672, 58138, 20839, 19938, 25061, 288, 26571, 16663, 9530, 6734, 39906, 51292, 52850, 62448, 35229, 14217, 52777, 33985, 63239, 40438, 29418, 7766, 48722, 18895, 27760, 13835, 1262, 15458, 27545, 2390, 62581, 60762, 51855, 30549, 23274, 52187, 56711, 22169, 18991, 21361, 40967, 3686, 40497, 61172};
                            char length = (char) (super.getResources().getString(R.string.more_for_you_description).substring(1, 2).length() - 1);
                            try {
                                Object[] objArr11 = new Object[1];
                                h((byte) (-NetworkUserEntityData$$ExternalSyntheticLambda0[32]), (byte) (NetworkUserEntityData$$ExternalSyntheticLambda0[49] - 1), NetworkUserEntityData$$ExternalSyntheticLambda0[25], objArr11);
                                Class<?> cls6 = Class.forName((String) objArr11[0]);
                                h(NetworkUserEntityData$$ExternalSyntheticLambda0[48], NetworkUserEntityData$$ExternalSyntheticLambda0[25], NetworkUserEntityData$$ExternalSyntheticLambda0[41], new Object[1]);
                                Object[] objArr12 = new Object[1];
                                g(cArr5, cArr6, length, ((ApplicationInfo) cls6.getMethod((String) r4[0], null).invoke(this, null)).targetSdkVersion - 33, new char[]{18079, 29517, 33288, 24554}, objArr12);
                                String str2 = (String) objArr12[0];
                                Object[] objArr13 = new Object[1];
                                g(new char[]{49128, 56372, 48765, 57809}, new char[]{15243, 9149, 22338, 54847, 36770, 516, 57946, 10792, 16664, 48142, 57389, 21769, 13494, 53358, 9552, 1542, 58412, 56255, 30711, 43809, 17107, 18115, 3332, 18852, 59739, 51299, 60775, 8541, 29995, 37758, 44194, 50615, 8552, 40944, 52327, 26344, 19087, 53700, 45156, 59121, 7668, 53335, 50396, 4632, 46116, 47291, 8646, 21043, 54932, 22083, 13239, 17377, 62236, 43293, 6663, 53878, 43204, 7147, 59750, 58681, 51617, 30920, 33250, 28364}, (char) (getPackageName().length() - 7), super.getResources().getString(R.string.share).substring(10, 11).length() - 1, new char[]{62526, 65363, 56356, 63138}, objArr13);
                                String str3 = (String) objArr13[0];
                                char[] cArr7 = {49128, 56372, 48765, 57809};
                                char[] cArr8 = {57182, 37299, 63505, 11057, 31444, 25944, 26500, 49932, 47058, 44778, 29764, 29248, 56931, 8606, 424, 48037, 26294, 54358, 17198, 25175, 6626, 12364, 61498, 28561, 41242, 21489, 49500, 631, 3967, 46951, 33545, 14254, 7583, 7657, 37128, 31005, 58664, 28077, 57886, 44900, 'v', 11309, 3813, 12544, 18224, 44388, 37287, 32168, 7946, 12543, 16600, 13692, 39159, 50366, 54085, 54205, 23253, 46408, 27478, 25093};
                                try {
                                    Object[] objArr14 = new Object[1];
                                    h((byte) (-NetworkUserEntityData$$ExternalSyntheticLambda0[32]), (byte) (NetworkUserEntityData$$ExternalSyntheticLambda0[49] - 1), NetworkUserEntityData$$ExternalSyntheticLambda0[25], objArr14);
                                    Class<?> cls7 = Class.forName((String) objArr14[0]);
                                    h(NetworkUserEntityData$$ExternalSyntheticLambda0[48], NetworkUserEntityData$$ExternalSyntheticLambda0[25], NetworkUserEntityData$$ExternalSyntheticLambda0[41], new Object[1]);
                                    Object[] objArr15 = new Object[1];
                                    g(cArr7, cArr8, (char) (((ApplicationInfo) cls7.getMethod((String) r0[0], null).invoke(this, null)).targetSdkVersion - 33), KeyEvent.getMaxKeyCode() >> 16, new char[]{26301, 40848, 26374, 4434}, objArr15);
                                    String str4 = (String) objArr15[0];
                                    char[] cArr9 = {49128, 56372, 48765, 57809};
                                    char[] cArr10 = {27482, 53117, 30322, 6838, 16787, 54537};
                                    char length2 = (char) (super.getResources().getString(R.string.lbl_dialog_incorrect_pin_or_otp_last_try).substring(2, 3).length() + 4244);
                                    try {
                                        Object[] objArr16 = new Object[1];
                                        h((byte) (-NetworkUserEntityData$$ExternalSyntheticLambda0[32]), (byte) (NetworkUserEntityData$$ExternalSyntheticLambda0[49] - 1), NetworkUserEntityData$$ExternalSyntheticLambda0[25], objArr16);
                                        Class<?> cls8 = Class.forName((String) objArr16[0]);
                                        h(NetworkUserEntityData$$ExternalSyntheticLambda0[48], NetworkUserEntityData$$ExternalSyntheticLambda0[25], NetworkUserEntityData$$ExternalSyntheticLambda0[41], new Object[1]);
                                        Object[] objArr17 = new Object[1];
                                        g(cArr9, cArr10, length2, ((ApplicationInfo) cls8.getMethod((String) r9[0], null).invoke(this, null)).targetSdkVersion - 33, new char[]{24354, 32037, 38219, 18192}, objArr17);
                                        try {
                                            Object[] objArr18 = {baseContext, str, str2, str3, str4, true, (String) objArr17[0], 995651014};
                                            Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-1276397751);
                                            if (obj2 == null) {
                                                obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - (KeyEvent.getMaxKeyCode() >> 16), KeyEvent.normalizeMetaState(0) + 18, (char) ((ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)) + 1))).getMethod("getAuthRequestContext", Context.class, String.class, String.class, String.class, String.class, Boolean.TYPE, String.class, Integer.TYPE);
                                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(-1276397751, obj2);
                                            }
                                            ((Method) obj2).invoke(invoke, objArr18);
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
                    Object[] objArr19 = new Object[1];
                    h(NetworkUserEntityData$$ExternalSyntheticLambda0[25], (byte) (-NetworkUserEntityData$$ExternalSyntheticLambda0[31]), NetworkUserEntityData$$ExternalSyntheticLambda0[30], objArr19);
                    Class<?> cls9 = Class.forName((String) objArr19[0]);
                    Object[] objArr20 = new Object[1];
                    h(NetworkUserEntityData$$ExternalSyntheticLambda0[9], (byte) (NetworkUserEntityData$$ExternalSyntheticLambda0[3] + 1), NetworkUserEntityData$$ExternalSyntheticLambda0[30], objArr20);
                    try {
                        Object[] objArr21 = {Integer.valueOf(((Integer) cls9.getMethod((String) objArr20[0], Object.class).invoke(null, this)).intValue())};
                        Object obj3 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(25207140);
                        if (obj3 == null) {
                            Class cls10 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(KeyEvent.keyCodeFromString("") + 494, 3 - MotionEvent.axisFromString(""), (char) (ViewConfiguration.getScrollDefaultDelay() >> 16));
                            Object[] objArr22 = new Object[1];
                            j($$g[8], $$g[9], (byte) (-$$g[40]), objArr22);
                            obj3 = cls10.getMethod((String) objArr22[0], Integer.TYPE);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(25207140, obj3);
                        }
                        Object[] objArr23 = (Object[]) ((Method) obj3).invoke(null, objArr21);
                        int i = ((int[]) objArr23[1])[0];
                        if (((int[]) objArr23[0])[0] != i) {
                            long j = ((r0 ^ i) & 4294967295L) | 42949672960L;
                            try {
                                Object obj4 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                                if (obj4 != null) {
                                    objArr = null;
                                } else {
                                    objArr = null;
                                    obj4 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - View.MeasureSpec.makeMeasureSpec(0, 0), KeyEvent.normalizeMetaState(0) + 35, (char) ((SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)) - 1))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj4);
                                }
                                Object invoke2 = ((Method) obj4).invoke(objArr, objArr);
                                try {
                                    Object[] objArr24 = {373349567, Long.valueOf(j), new ArrayList(), LauncherActivity.getAuid()};
                                    Object obj5 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                    if (obj5 == null) {
                                        obj5 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1)) + 910, 18 - Color.green(0), (char) (ViewConfiguration.getMinimumFlingVelocity() >> 16))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
                                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1759031285, obj5);
                                    }
                                    ((Method) obj5).invoke(invoke2, objArr24);
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
                        super.onCreate(bundle);
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
        } catch (Throwable th12) {
            Throwable cause12 = th12.getCause();
            if (cause12 == null) {
                throw th12;
            }
            throw cause12;
        }
    }

    @Override // id.dana.base.BaseWebViewActivity, id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onPause() {
        Context baseContext = getBaseContext();
        if (baseContext == null) {
            Object[] objArr = new Object[1];
            g(new char[]{49128, 56372, 48765, 57809}, new char[]{19076, 26519, 141, 55860, 43227, 46080, 32042, 25802, 50886, 55282, 5465, 54153, 33632, 1942, 32089, 43991, 41933, 19099, 53978, 55482, 6860, 21125, 47331, 34507, 24914, 57149}, (char) (getPackageName().length() + 51638), super.getResources().getString(R.string.cscanb_blacklist_warning_dialog).substring(0, 5).codePointAt(3) - 65, new char[]{9948, 36857, 48616, 24009}, objArr);
            Class<?> cls = Class.forName((String) objArr[0]);
            Object[] objArr2 = new Object[1];
            g(new char[]{49128, 56372, 48765, 57809}, new char[]{41921, 14690, 44640, 8737, 7674, 11202, 64514, 41342, 7396, 33178, 27880, 15017, 44669, 53146, 57347, 20473, 43327, 46112}, (char) (super.getResources().getString(R.string.hint_form_last_name).substring(12, 13).codePointAt(0) + 29720), ExpandableListView.getPackedPositionGroup(0L), new char[]{16343, 11314, 31215, 9588}, objArr2);
            baseContext = (Context) cls.getMethod((String) objArr2[0], new Class[0]).invoke(null, null);
        }
        if (baseContext != null) {
            baseContext = baseContext.getApplicationContext();
        }
        if (baseContext != null) {
            try {
                Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                if (obj == null) {
                    obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1)) + PDF417Common.MAX_CODEWORDS_IN_BARCODE, TextUtils.getOffsetBefore("", 0) + 35, (char) (ViewConfiguration.getEdgeSlop() >> 16))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                }
                Object invoke = ((Method) obj).invoke(null, null);
                try {
                    Object[] objArr3 = {baseContext};
                    Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-549958681);
                    if (obj2 == null) {
                        obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - ExpandableListView.getPackedPositionType(0L), 18 - KeyEvent.keyCodeFromString(""), (char) (CdmaCellLocation.convertQuartSecToDecDegrees(0) > FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 0 : -1)))).getMethod("MyBillsEntityDataFactory", Context.class);
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

    @Override // id.dana.base.BaseWebViewActivity, id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onResume() {
        Class<?> cls;
        Context baseContext = getBaseContext();
        if (baseContext == null) {
            char[] cArr = {49128, 56372, 48765, 57809};
            char[] cArr2 = {19076, 26519, 141, 55860, 43227, 46080, 32042, 25802, 50886, 55282, 5465, 54153, 33632, 1942, 32089, 43991, 41933, 19099, 53978, 55482, 6860, 21125, 47331, 34507, 24914, 57149};
            char codePointAt = (char) (getPackageName().codePointAt(3) + 51545);
            try {
                Object[] objArr = new Object[1];
                h((byte) (-NetworkUserEntityData$$ExternalSyntheticLambda0[32]), (byte) (NetworkUserEntityData$$ExternalSyntheticLambda0[49] - 1), NetworkUserEntityData$$ExternalSyntheticLambda0[25], objArr);
                cls = Class.forName((String) objArr[0]);
                h(NetworkUserEntityData$$ExternalSyntheticLambda0[48], NetworkUserEntityData$$ExternalSyntheticLambda0[25], NetworkUserEntityData$$ExternalSyntheticLambda0[41], new Object[1]);
            } catch (Throwable th) {
                th = th;
            }
            try {
                Object[] objArr2 = new Object[1];
                g(cArr, cArr2, codePointAt, ((ApplicationInfo) cls.getMethod((String) r13[0], null).invoke(this, null)).targetSdkVersion - 33, new char[]{9948, 36857, 48616, 24009}, objArr2);
                Class<?> cls2 = Class.forName((String) objArr2[0]);
                Object[] objArr3 = new Object[1];
                g(new char[]{49128, 56372, 48765, 57809}, new char[]{41921, 14690, 44640, 8737, 7674, 11202, 64514, 41342, 7396, 33178, 27880, 15017, 44669, 53146, 57347, 20473, 43327, 46112}, (char) (super.getResources().getString(R.string.res_0x7f130456_networkuserentitydata_externalsyntheticlambda1).substring(1, 3).codePointAt(1) + 29703), super.getResources().getString(R.string.choose_your_promo_here).substring(7, 9).length() - 2, new char[]{16343, 11314, 31215, 9588}, objArr3);
                baseContext = (Context) cls2.getMethod((String) objArr3[0], new Class[0]).invoke(null, null);
            } catch (Throwable th2) {
                th = th2;
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
                    obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)) + PDF417Common.NUMBER_OF_CODEWORDS, 35 - (ViewConfiguration.getMaximumFlingVelocity() >> 16), (char) (MotionEvent.axisFromString("") + 1))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                }
                Object invoke = ((Method) obj).invoke(null, null);
                try {
                    Object[] objArr4 = {baseContext};
                    Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(247288059);
                    if (obj2 == null) {
                        obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)) + 910, 18 - (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)), (char) View.combineMeasuredStates(0, 0))).getMethod("KClassImpl$Data$declaredNonStaticMembers$2", Context.class);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(247288059, obj2);
                    }
                    ((Method) obj2).invoke(invoke, objArr4);
                } catch (Throwable th3) {
                    Throwable cause2 = th3.getCause();
                    if (cause2 == null) {
                        throw th3;
                    }
                    throw cause2;
                }
            } catch (Throwable th4) {
                Throwable cause3 = th4.getCause();
                if (cause3 == null) {
                    throw th4;
                }
                throw cause3;
            }
        }
        super.onResume();
    }

    @Override // id.dana.base.BaseActivity
    public void configToolbar() {
        setTitle(getString(R.string.lazada_terms_and_conditions));
    }

    @Override // id.dana.base.BaseActivity
    public void init() {
        setMenuLeftButton(R.drawable.btn_arrow_left);
        load(UrlUtil.getAuthRequestContext(DanaUrl.LAZADA_TERMS_AND_CONDITION));
    }

    public static Intent returnAgreeToTncResult(Context context) {
        return new Intent(context, LazadaTermsAndConditionActivity.class);
    }

    @OnClick({R.id.btn_lazada_agree})
    public void onAgreeCliecked() {
        Intent intent = new Intent();
        intent.putExtra(LAZADA_TNC_ACTION_RESULT, true);
        setResult(-1, intent);
        finish();
    }

    private static void g(char[] cArr, char[] cArr2, char c, int i, char[] cArr3, Object[] objArr) {
        E e = new E();
        int length = cArr3.length;
        char[] cArr4 = new char[length];
        int length2 = cArr.length;
        char[] cArr5 = new char[length2];
        System.arraycopy(cArr3, 0, cArr4, 0, length);
        System.arraycopy(cArr, 0, cArr5, 0, length2);
        cArr4[0] = (char) (cArr4[0] ^ c);
        cArr5[2] = (char) (cArr5[2] + ((char) i));
        int length3 = cArr2.length;
        char[] cArr6 = new char[length3];
        e.KClassImpl$Data$declaredNonStaticMembers$2 = 0;
        while (e.KClassImpl$Data$declaredNonStaticMembers$2 < length3) {
            int i2 = (e.KClassImpl$Data$declaredNonStaticMembers$2 + 2) % 4;
            int i3 = (e.KClassImpl$Data$declaredNonStaticMembers$2 + 3) % 4;
            e.MyBillsEntityDataFactory = (char) (((cArr4[e.KClassImpl$Data$declaredNonStaticMembers$2 % 4] * 32718) + cArr5[i2]) % 65535);
            cArr5[i3] = (char) (((cArr4[i3] * 32718) + cArr5[i2]) / 65535);
            cArr4[i3] = e.MyBillsEntityDataFactory;
            cArr6[e.KClassImpl$Data$declaredNonStaticMembers$2] = (char) ((((cArr4[i3] ^ cArr2[e.KClassImpl$Data$declaredNonStaticMembers$2]) ^ (lookAheadTest ^ 4360990799332652212L)) ^ ((int) (scheduleImpl ^ 4360990799332652212L))) ^ ((char) (NetworkUserEntityData$$ExternalSyntheticLambda1 ^ 4360990799332652212L)));
            e.KClassImpl$Data$declaredNonStaticMembers$2++;
        }
        objArr[0] = new String(cArr6);
    }
}
