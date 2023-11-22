package com.iap.ac.android.acs.plugin.downgrade.ui;

import android.app.Activity;
import android.app.Application;
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
import android.telephony.cdma.CdmaCellLocation;
import android.text.AndroidCharacter;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.Button;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.google.common.base.Ascii;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.google.zxing.pdf417.PDF417Common;
import com.iap.ac.android.acs.plugin.downgrade.utils.ApiDowngradeUtils;
import com.iap.ac.android.acs.plugin.downgrade.utils.ImageLoader;
import com.iap.ac.android.acs.transition.R;
import com.iap.ac.android.common.log.ACLog;
import id.dana.onboarding.splash.LauncherActivity;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import net.sqlcipher.database.SQLiteDatabase;
import o.C;
import o.SummaryVoucherView$$ExternalSyntheticLambda0;

/* loaded from: classes3.dex */
public class ErrorPageActivity extends Activity {
    private static char BuiltInFictitiousFunctionClassFactory = 0;
    public static final String KEY_BUTTON_TEXT = "buttonText";
    public static final String KEY_ICON_URL = "iconUrl";
    public static final String KEY_MESSAGE = "message";
    public static final String KEY_PAGE_FINISH_TYPE = "pageFinishType";
    public static final String KEY_TITLE = "title";
    private static char MyBillsEntityDataFactory = 0;
    public static final String PAGE_FINISH_WITH_ACTION = "pageFinishTypeOfAction";
    public static final String PAGE_FINISH_WITH_BACK = "pageFinishTypeOfBack";
    public static final String TAG;
    private static char getAuthRequestContext;
    private static char scheduleImpl;
    public static final byte[] $$a = {104, -68, 0, 44, TarHeader.LF_CHR, -48, 46, 10, 7, 14, -39, TarHeader.LF_NORMAL, 13, -4, 18, 12, -46, 36, Ascii.SUB, -12, -20, 34, 9, Ascii.CAN, 2, 10, 14, 5, 22, -44, 59, 6, -5, -15, Ascii.SUB, 19, 11, -9, Ascii.NAK, 8, -42, TarHeader.LF_CHR, 6, 13, -8, Ascii.SUB, 3, -1, TarHeader.LF_NORMAL, -4, Ascii.EM, 7, -35, 43, 10, 3, -65, 39, 36, Ascii.SUB, -12, -54, 71, 8, 5, 16, -4, Ascii.CAN, -6, 6, -15, 40, 6, -20, 40, -12, Ascii.SUB, -4, 1, -15, Ascii.US, 15, -4, 10, Ascii.DC4, 8, -72, Ascii.NAK};
    public static final int $$b = 23;
    public static final byte[] PlaceComponentResult = {113, 46, 115, -60, -17, 6, -18, -1, 2, 1, TarHeader.LF_SYMLINK, -57, -16, -3, -10, 11, -13, -10, 66, -25, -48, -3, -10, 11, -23, 0, 1, -5, -13, -10, 7, -15, -9, 45, -29, -22, 7, 33, -48, 7, -5, 5, -25, 17, 47, -66, 7, -17, 3, TarHeader.LF_DIR, -41, -42, 2, -5, 11, -12, -2, -19, 47, -51, -4, 0, -1, 2, -2, -23, 7, -10, -3, 33, -41, 4, -13};
    public static final int KClassImpl$Data$declaredNonStaticMembers$2 = 10;

    static {
        MyBillsEntityDataFactory();
        TAG = ApiDowngradeUtils.logTag("ErrorPageActivity");
    }

    static void MyBillsEntityDataFactory() {
        MyBillsEntityDataFactory = (char) 40693;
        BuiltInFictitiousFunctionClassFactory = (char) 57514;
        scheduleImpl = (char) 5505;
        getAuthRequestContext = (char) 65375;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x001d  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0025 -> B:11:0x002f). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void b(short r6, byte r7, short r8, java.lang.Object[] r9) {
        /*
            int r8 = r8 + 4
            int r7 = r7 + 16
            int r6 = 106 - r6
            byte[] r0 = com.iap.ac.android.acs.plugin.downgrade.ui.ErrorPageActivity.PlaceComponentResult
            byte[] r1 = new byte[r7]
            int r7 = r7 + (-1)
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
            if (r3 != r7) goto L25
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            r9[r2] = r6
            return
        L25:
            int r8 = r8 + 1
            r3 = r0[r8]
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
        throw new UnsupportedOperationException("Method not decompiled: com.iap.ac.android.acs.plugin.downgrade.ui.ErrorPageActivity.b(short, byte, short, java.lang.Object[]):void");
    }

    private static void c(short s, int i, int i2, Object[] objArr) {
        int i3 = s + 4;
        int i4 = (i2 * 3) + 21;
        int i5 = (i * 2) + 75;
        byte[] bArr = $$a;
        byte[] bArr2 = new byte[i4];
        int i6 = -1;
        int i7 = i4 - 1;
        if (bArr == null) {
            int i8 = (i3 + i7) - 7;
            i7 = i7;
            objArr = objArr;
            bArr = bArr;
            bArr2 = bArr2;
            i6 = -1;
            i5 = i8;
            i3 = i3;
        }
        while (true) {
            int i9 = i6 + 1;
            int i10 = i3 + 1;
            bArr2[i9] = (byte) i5;
            if (i9 == i7) {
                objArr[0] = new String(bArr2, 0);
                return;
            }
            i7 = i7;
            objArr = objArr;
            bArr = bArr;
            bArr2 = bArr2;
            i6 = i9;
            i5 = (i5 + bArr[i10]) - 7;
            i3 = i10;
        }
    }

    private void init() {
        ImageView imageView = (ImageView) findViewById(R.id.iv_back);
        TextView textView = (TextView) findViewById(R.id.tv_title);
        ImageView imageView2 = (ImageView) findViewById(R.id.iv_icon);
        TextView textView2 = (TextView) findViewById(R.id.tv_message);
        Button button = (Button) findViewById(R.id.btn_action);
        String stringExtra = getIntent().getStringExtra("title");
        String stringExtra2 = getIntent().getStringExtra("iconUrl");
        String stringExtra3 = getIntent().getStringExtra("message");
        String stringExtra4 = getIntent().getStringExtra(KEY_BUTTON_TEXT);
        textView.setText(stringExtra);
        ImageLoader.loadImage(imageView2, stringExtra2, ContextCompat.PlaceComponentResult(this, R.drawable.acplugin_error_icon));
        textView2.setText(stringExtra3);
        button.setText(stringExtra4);
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.iap.ac.android.acs.plugin.downgrade.ui.ErrorPageActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ErrorPageActivity.this.onBackPressed();
            }
        });
        button.setOnClickListener(new View.OnClickListener() { // from class: com.iap.ac.android.acs.plugin.downgrade.ui.ErrorPageActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ErrorPageActivity.this.finishWithType(ErrorPageActivity.PAGE_FINISH_WITH_ACTION);
            }
        });
    }

    public static void startPage(Context context, String str, String str2, String str3, String str4) {
        Intent intent = new Intent(context, ErrorPageActivity.class);
        if (context instanceof Application) {
            intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
        }
        intent.putExtra("title", str);
        intent.putExtra("iconUrl", str2);
        intent.putExtra("message", str3);
        intent.putExtra(KEY_BUTTON_TEXT, str4);
        context.startActivity(intent);
    }

    @Override // android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper
    public void attachBaseContext(Context context) {
        Object[] objArr;
        Object[] objArr2;
        Object[] objArr3;
        Object[] objArr4;
        super.attachBaseContext(context);
        Object[] objArr5 = new Object[1];
        a(18 - (CdmaCellLocation.convertQuartSecToDecDegrees(0) > FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 0 : -1)), new char[]{3053, 4279, 5661, 2574, 21610, 27630, 19165, 15726, 53040, 40790, 39375, 40251, 20703, 2617, 43672, 52209, 48277, 14505}, objArr5);
        Class<?> cls = Class.forName((String) objArr5[0]);
        Object[] objArr6 = new Object[1];
        a(4 - TextUtils.indexOf((CharSequence) "", '0', 0), new char[]{24076, 20907, 56416, 15338, 29979, 33279}, objArr6);
        int intValue = ((Integer) cls.getDeclaredMethod((String) objArr6[0], new Class[0]).invoke(null, new Object[0])).intValue() % 100000;
        if (intValue < 99000 || intValue > 99999) {
            Context applicationContext = context != null ? context.getApplicationContext() : context;
            if (applicationContext != null) {
                try {
                    Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                    if (obj == null) {
                        obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(AndroidCharacter.getMirror('0') + 881, (Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1)) + 34, (char) ((-1) - ((byte) KeyEvent.getModifierMetaStateMask())))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                    }
                    Object invoke = ((Method) obj).invoke(null, null);
                    Object[] objArr7 = new Object[1];
                    a(48 - (ViewConfiguration.getJumpTapTimeout() >> 16), new char[]{47340, 23480, 17674, 29187, 42657, 41238, 37407, 25159, 14236, 13356, 8913, 4946, 35598, 49702, 60285, 62659, 39222, 29160, 43460, 2654, 52877, 24886, 31486, 38012, 26580, 55462, 17602, 56444, 56960, 19275, 16023, 44824, 50985, 33473, 14817, 52161, 1145, 20425, 10805, 21022, 40142, 29025, 45360, 35087, 57829, 61889, 33308, 26453}, objArr7);
                    String str = (String) objArr7[0];
                    Object[] objArr8 = new Object[1];
                    a(64 - (ViewConfiguration.getJumpTapTimeout() >> 16), new char[]{16747, 51539, 37505, 18682, 1145, 20425, 27131, 48325, 52877, 24886, 53100, 57735, 53773, 28239, 31307, 14757, 55484, 65394, 32700, 53159, 53773, 28239, 51642, 45519, 50891, 17848, 44585, 12683, 17602, 56444, 55484, 65394, 42354, 53701, 21583, 44342, 32966, 60806, 22068, 43022, 35727, 22586, 60774, 14930, 41411, 35130, 64497, 21159, 54911, 38593, 51627, 56723, 35926, 16939, 22418, 29843, 22418, 29843, 55902, 17352, 21232, 53191, 26580, 55462}, objArr8);
                    String str2 = (String) objArr8[0];
                    Object[] objArr9 = new Object[1];
                    a((ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)) + 65, new char[]{51673, 4089, 27673, 15256, 35926, 16939, 19695, 29420, 62581, 65308, 245, 57252, 58421, 59807, 13720, 33567, 16023, 44824, 49189, 6096, 41236, 32603, 63291, 57579, 40142, 29025, 37407, 25159, 17544, 32562, 47340, 23480, 9372, 49290, 12201, 1177, 44465, 49839, 17674, 29187, 54360, 30808, 31307, 14757, 10805, 21022, 44101, 26344, 1145, 20425, 43672, 52209, 51673, 4089, 42086, 39075, 63127, 46649, 50985, 33473, 42086, 39075, 33268, 15482}, objArr9);
                    String str3 = (String) objArr9[0];
                    Object[] objArr10 = new Object[1];
                    a(60 - View.resolveSize(0, 0), new char[]{64087, 43762, 38448, 3910, 9636, 56331, 60675, 34895, 8647, 7580, 26321, 63116, 6352, 58961, 56331, 3464, 32419, 28299, 31536, 28102, 34165, 15005, 41583, 44369, 25718, 34878, 44689, 44946, 48425, 11134, 25458, 16155, 44689, 44946, 8991, 41913, 58528, 20252, 16937, 42249, 18515, 1049, 18546, 54432, 11795, 32309, 55236, 12929, 39433, 32115, 61166, 58334, 57738, 15072, 39525, 33014, 54538, 3608, 41639, 56970}, objArr10);
                    String str4 = (String) objArr10[0];
                    Object[] objArr11 = new Object[1];
                    a(Color.alpha(0) + 6, new char[]{30481, 16197, 16815, 20458, 51673, 4089}, objArr11);
                    try {
                        Object[] objArr12 = {applicationContext, str, str2, str3, str4, true, (String) objArr11[0], 995651014};
                        Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-1276397751);
                        if (obj2 == null) {
                            obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(Process.getGidForName("") + 912, 19 - (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)), (char) (ViewConfiguration.getKeyRepeatTimeout() >> 16))).getMethod("getAuthRequestContext", Context.class, String.class, String.class, String.class, String.class, Boolean.TYPE, String.class, Integer.TYPE);
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
                byte b = PlaceComponentResult[25];
                byte b2 = b;
                Object[] objArr13 = new Object[1];
                b(b, b2, (byte) (b2 | 36), objArr13);
                Class<?> cls2 = Class.forName((String) objArr13[0]);
                byte b3 = PlaceComponentResult[9];
                byte b4 = PlaceComponentResult[25];
                Object[] objArr14 = new Object[1];
                b(b3, b4, (byte) (b4 | Ascii.NAK), objArr14);
                try {
                    Object[] objArr15 = {applicationContext2, Integer.valueOf(((Integer) cls2.getMethod((String) objArr14[0], Object.class).invoke(null, this)).intValue())};
                    Object obj3 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1691739267);
                    if (obj3 == null) {
                        Class cls3 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)) + 54, 3 - Gravity.getAbsoluteGravity(0, 0), (char) ((AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)) - 1));
                        byte b5 = $$a[47];
                        byte b6 = $$a[78];
                        Object[] objArr16 = new Object[1];
                        c(b5, b6, b6, objArr16);
                        obj3 = cls3.getMethod((String) objArr16[0], Context.class, Integer.TYPE);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1691739267, obj3);
                    }
                    Object invoke2 = ((Method) obj3).invoke(null, objArr15);
                    try {
                        Object obj4 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(40157535);
                        if (obj4 == null) {
                            obj4 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(799 - TextUtils.lastIndexOf("", '0'), 16 - (SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)), (char) TextUtils.indexOf("", ""))).getMethod("getAuthRequestContext", null);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(40157535, obj4);
                        }
                        int intValue2 = ((Integer) ((Method) obj4).invoke(invoke2, null)).intValue();
                        try {
                            Object obj5 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1621779126);
                            if (obj5 == null) {
                                obj5 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(Drawable.resolveOpacity(0, 0) + 800, TextUtils.getCapsMode("", 0, 0) + 15, (char) (KeyEvent.getMaxKeyCode() >> 16))).getMethod("PlaceComponentResult", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1621779126, obj5);
                            }
                            if (((Integer) ((Method) obj5).invoke(invoke2, null)).intValue() != intValue2) {
                                ArrayList arrayList = new ArrayList();
                                try {
                                    Object[] objArr17 = {invoke2};
                                    Object obj6 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(658700871);
                                    if (obj6 == null) {
                                        obj6 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(816 - (SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)), 29 - TextUtils.getOffsetAfter("", 0), (char) (57994 - ((Process.getThreadPriority(0) + 20) >> 6)))).getMethod("getAuthRequestContext", (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(800 - (ViewConfiguration.getPressedStateDuration() >> 16), 15 - View.MeasureSpec.getSize(0), (char) (ViewConfiguration.getKeyRepeatDelay() >> 16)));
                                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(658700871, obj6);
                                    }
                                    arrayList.add(((Method) obj6).invoke(null, objArr17));
                                    long j = ((r7 ^ intValue2) & 4294967295L) | 60129542144L;
                                    try {
                                        Object obj7 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                                        if (obj7 != null) {
                                            objArr = null;
                                        } else {
                                            objArr = null;
                                            obj7 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - (ViewConfiguration.getTouchSlop() >> 8), 36 - (ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)), (char) View.MeasureSpec.getMode(0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj7);
                                        }
                                        Object invoke3 = ((Method) obj7).invoke(objArr, objArr);
                                        try {
                                            Object[] objArr18 = {-1964331077, Long.valueOf(j), arrayList, LauncherActivity.getAuid()};
                                            Object obj8 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                            if (obj8 == null) {
                                                obj8 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getKeyRepeatTimeout() >> 16) + 911, 18 - View.MeasureSpec.getSize(0), (char) Color.argb(0, 0, 0, 0))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                byte b7 = PlaceComponentResult[25];
                byte b8 = b7;
                Object[] objArr20 = new Object[1];
                b(b7, b8, (byte) (b8 | 36), objArr20);
                Class<?> cls4 = Class.forName((String) objArr20[0]);
                byte b9 = PlaceComponentResult[9];
                byte b10 = PlaceComponentResult[25];
                Object[] objArr21 = new Object[1];
                b(b9, b10, (byte) (b10 | Ascii.NAK), objArr21);
                try {
                    Object[] objArr22 = {applicationContext3, Integer.valueOf(((Integer) cls4.getMethod((String) objArr21[0], Object.class).invoke(null, objArr19)).intValue())};
                    Object obj9 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(345757441);
                    if (obj9 == null) {
                        Class cls5 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(61 - View.resolveSizeAndState(0, 0, 0), (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)) + 45, (char) (ViewConfiguration.getTouchSlop() >> 8));
                        Object[] objArr23 = new Object[1];
                        c($$a[28], $$a[9], $$a[2], objArr23);
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
                                obj10 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)), 35 - (ViewConfiguration.getFadingEdgeLength() >> 16), (char) (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj10);
                            }
                            Object invoke4 = ((Method) obj10).invoke(objArr4, objArr4);
                            try {
                                Object[] objArr25 = {-1964331077, Long.valueOf(j2), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj11 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj11 == null) {
                                    obj11 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(Color.alpha(0) + 911, 18 - TextUtils.getTrimmedLength(""), (char) (ViewConfiguration.getKeyRepeatTimeout() >> 16))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                byte b11 = PlaceComponentResult[25];
                byte b12 = b11;
                Object[] objArr27 = new Object[1];
                b(b11, b12, (byte) (b12 | 36), objArr27);
                Class<?> cls6 = Class.forName((String) objArr27[0]);
                byte b13 = PlaceComponentResult[9];
                byte b14 = PlaceComponentResult[25];
                Object[] objArr28 = new Object[1];
                b(b13, b14, (byte) (b14 | Ascii.NAK), objArr28);
                try {
                    Object[] objArr29 = {applicationContext4, Integer.valueOf(((Integer) cls6.getMethod((String) objArr28[0], Object.class).invoke(null, objArr26)).intValue())};
                    Object obj12 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-697999596);
                    if (obj12 == null) {
                        Class cls7 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(Gravity.getAbsoluteGravity(0, 0) + 118, 3 - TextUtils.indexOf("", ""), (char) (Color.red(0) + 38968));
                        Object[] objArr30 = new Object[1];
                        c($$a[28], $$a[9], $$a[2], objArr30);
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
                                obj13 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - (Process.myTid() >> 22), TextUtils.indexOf("", "", 0) + 35, (char) ExpandableListView.getPackedPositionType(0L))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj13);
                            }
                            Object invoke5 = ((Method) obj13).invoke(objArr3, objArr3);
                            try {
                                Object[] objArr32 = {-1964331077, Long.valueOf(j3), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj14 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj14 == null) {
                                    obj14 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - View.resolveSize(0, 0), (ViewConfiguration.getMinimumFlingVelocity() >> 16) + 18, (char) View.MeasureSpec.makeMeasureSpec(0, 0))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                byte b15 = PlaceComponentResult[25];
                byte b16 = b15;
                Object[] objArr34 = new Object[1];
                b(b15, b16, (byte) (b16 | 36), objArr34);
                Class<?> cls8 = Class.forName((String) objArr34[0]);
                byte b17 = PlaceComponentResult[9];
                byte b18 = PlaceComponentResult[25];
                Object[] objArr35 = new Object[1];
                b(b17, b18, (byte) (b18 | Ascii.NAK), objArr35);
                try {
                    Object[] objArr36 = {applicationContext5, Integer.valueOf(((Integer) cls8.getMethod((String) objArr35[0], Object.class).invoke(null, objArr33)).intValue())};
                    Object obj15 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-16683571);
                    if (obj15 == null) {
                        Class cls9 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getWindowTouchSlop() >> 8) + 107, 3 - (CdmaCellLocation.convertQuartSecToDecDegrees(0) > FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 0 : -1)), (char) ((-1) - ImageFormat.getBitsPerPixel(0)));
                        Object[] objArr37 = new Object[1];
                        c((byte) (-$$a[40]), $$a[2], $$a[8], objArr37);
                        obj15 = cls9.getMethod((String) objArr37[0], Context.class, Integer.TYPE);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(-16683571, obj15);
                    }
                    Object[] objArr38 = (Object[]) ((Method) obj15).invoke(null, objArr36);
                    int i3 = ((int[]) objArr38[1])[0];
                    if (((int[]) objArr38[0])[0] != i3) {
                        long j4 = (4294967295L & (r1 ^ i3)) | 4294967296L;
                        try {
                            Object obj16 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                            if (obj16 != null) {
                                objArr2 = null;
                            } else {
                                objArr2 = null;
                                obj16 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - (ViewConfiguration.getKeyRepeatDelay() >> 16), ExpandableListView.getPackedPositionGroup(0L) + 35, (char) (ViewConfiguration.getWindowTouchSlop() >> 8))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj16);
                            }
                            Object invoke6 = ((Method) obj16).invoke(objArr2, objArr2);
                            try {
                                Object[] objArr39 = {-1964331077, Long.valueOf(j4), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj17 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj17 == null) {
                                    obj17 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)) + 910, 18 - Color.alpha(0), (char) Color.argb(0, 0, 0, 0))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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

    public void finishWithType(String str) {
        String str2 = TAG;
        StringBuilder sb = new StringBuilder();
        sb.append("finishWithType() finishType is ");
        sb.append(str);
        ACLog.d(str2, sb.toString());
        getIntent().putExtra(KEY_PAGE_FINISH_TYPE, str);
        finish();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Context getApplicationContext() {
        return super.getApplicationContext();
    }

    @Override // android.content.ContextWrapper
    public Context getBaseContext() {
        return super.getBaseContext();
    }

    @Override // android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public Resources getResources() {
        return super.getResources();
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        finishWithType(PAGE_FINISH_WITH_BACK);
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        Object[] objArr;
        Object[] objArr2 = new Object[1];
        a(super.getResources().getString(id.dana.R.string.feed_onboarding_title_1).substring(11, 13).length() + 16, new char[]{3053, 4279, 5661, 2574, 21610, 27630, 19165, 15726, 53040, 40790, 39375, 40251, 20703, 2617, 43672, 52209, 48277, 14505}, objArr2);
        Class<?> cls = Class.forName((String) objArr2[0]);
        Object[] objArr3 = new Object[1];
        a(5 - (CdmaCellLocation.convertQuartSecToDecDegrees(0) > FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 0 : -1)), new char[]{24076, 20907, 56416, 15338, 29979, 33279}, objArr3);
        int intValue = ((Integer) cls.getDeclaredMethod((String) objArr3[0], new Class[0]).invoke(null, new Object[0])).intValue() % 100000;
        if (intValue < 99000 || intValue > 99999) {
            Context baseContext = getBaseContext();
            if (baseContext == null) {
                try {
                    Object[] objArr4 = new Object[1];
                    b((byte) (-PlaceComponentResult[32]), PlaceComponentResult[30], PlaceComponentResult[7], objArr4);
                    Class<?> cls2 = Class.forName((String) objArr4[0]);
                    b(PlaceComponentResult[48], PlaceComponentResult[8], (byte) (-PlaceComponentResult[59]), new Object[1]);
                    Object[] objArr5 = new Object[1];
                    a(((ApplicationInfo) cls2.getMethod((String) r12[0], null).invoke(this, null)).targetSdkVersion - 7, new char[]{3053, 4279, 5661, 2574, 21610, 27630, 19165, 15726, 18515, 1049, 16604, 21617, 41470, 53961, 53554, 49546, 61348, 24504, 33538, 3381, 10652, 64040, 44296, 18063, 27555, 35498}, objArr5);
                    Class<?> cls3 = Class.forName((String) objArr5[0]);
                    Object[] objArr6 = new Object[1];
                    a(super.getResources().getString(id.dana.R.string.referral_tracker_dana_kaget).substring(4, 15).length() + 7, new char[]{18522, 35309, 65441, 42296, 54538, 3608, 60408, 45153, 14528, 21895, 9878, 1624, 22829, 46740, 53554, 49546, 9446, 63379}, objArr6);
                    baseContext = (Context) cls3.getMethod((String) objArr6[0], new Class[0]).invoke(null, null);
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
                        obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getTapTimeout() >> 16) + PDF417Common.NUMBER_OF_CODEWORDS, 34 - TextUtils.indexOf((CharSequence) "", '0'), (char) (ViewConfiguration.getEdgeSlop() >> 16))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                    }
                    Object invoke = ((Method) obj).invoke(null, null);
                    try {
                        Object[] objArr7 = new Object[1];
                        b((byte) (-PlaceComponentResult[32]), PlaceComponentResult[30], PlaceComponentResult[7], objArr7);
                        Class<?> cls4 = Class.forName((String) objArr7[0]);
                        Object[] objArr8 = new Object[1];
                        b(PlaceComponentResult[48], PlaceComponentResult[8], (byte) (-PlaceComponentResult[59]), objArr8);
                        Object[] objArr9 = new Object[1];
                        a(((ApplicationInfo) cls4.getMethod((String) objArr8[0], null).invoke(this, null)).targetSdkVersion + 15, new char[]{47340, 23480, 17674, 29187, 42657, 41238, 37407, 25159, 14236, 13356, 8913, 4946, 35598, 49702, 60285, 62659, 39222, 29160, 43460, 2654, 52877, 24886, 31486, 38012, 26580, 55462, 17602, 56444, 56960, 19275, 16023, 44824, 50985, 33473, 14817, 52161, 1145, 20425, 10805, 21022, 40142, 29025, 45360, 35087, 57829, 61889, 33308, 26453}, objArr9);
                        String str = (String) objArr9[0];
                        Object[] objArr10 = new Object[1];
                        a(getPackageName().codePointAt(6) - 33, new char[]{16747, 51539, 37505, 18682, 1145, 20425, 27131, 48325, 52877, 24886, 53100, 57735, 53773, 28239, 31307, 14757, 55484, 65394, 32700, 53159, 53773, 28239, 51642, 45519, 50891, 17848, 44585, 12683, 17602, 56444, 55484, 65394, 42354, 53701, 21583, 44342, 32966, 60806, 22068, 43022, 35727, 22586, 60774, 14930, 41411, 35130, 64497, 21159, 54911, 38593, 51627, 56723, 35926, 16939, 22418, 29843, 22418, 29843, 55902, 17352, 21232, 53191, 26580, 55462}, objArr10);
                        String str2 = (String) objArr10[0];
                        Object[] objArr11 = new Object[1];
                        a(super.getResources().getString(id.dana.R.string.family_account_setting_subtitle).substring(11, 12).codePointAt(0) + 32, new char[]{51673, 4089, 27673, 15256, 35926, 16939, 19695, 29420, 62581, 65308, 245, 57252, 58421, 59807, 13720, 33567, 16023, 44824, 49189, 6096, 41236, 32603, 63291, 57579, 40142, 29025, 37407, 25159, 17544, 32562, 47340, 23480, 9372, 49290, 12201, 1177, 44465, 49839, 17674, 29187, 54360, 30808, 31307, 14757, 10805, 21022, 44101, 26344, 1145, 20425, 43672, 52209, 51673, 4089, 42086, 39075, 63127, 46649, 50985, 33473, 42086, 39075, 33268, 15482}, objArr11);
                        String str3 = (String) objArr11[0];
                        Object[] objArr12 = new Object[1];
                        a(super.getResources().getString(id.dana.R.string.share_to_feed_message_success).substring(4, 6).length() + 58, new char[]{64087, 43762, 38448, 3910, 9636, 56331, 60675, 34895, 8647, 7580, 26321, 63116, 6352, 58961, 56331, 3464, 32419, 28299, 31536, 28102, 34165, 15005, 41583, 44369, 25718, 34878, 44689, 44946, 48425, 11134, 25458, 16155, 44689, 44946, 8991, 41913, 58528, 20252, 16937, 42249, 18515, 1049, 18546, 54432, 11795, 32309, 55236, 12929, 39433, 32115, 61166, 58334, 57738, 15072, 39525, 33014, 54538, 3608, 41639, 56970}, objArr12);
                        String str4 = (String) objArr12[0];
                        Object[] objArr13 = new Object[1];
                        a(View.MeasureSpec.getMode(0) + 6, new char[]{30481, 16197, 16815, 20458, 51673, 4089}, objArr13);
                        try {
                            Object[] objArr14 = {baseContext, str, str2, str3, str4, true, (String) objArr13[0], 995651014};
                            Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-1276397751);
                            if (obj2 == null) {
                                obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(TextUtils.indexOf((CharSequence) "", '0', 0) + 912, ExpandableListView.getPackedPositionChild(0L) + 19, (char) TextUtils.indexOf("", ""))).getMethod("getAuthRequestContext", Context.class, String.class, String.class, String.class, String.class, Boolean.TYPE, String.class, Integer.TYPE);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(-1276397751, obj2);
                            }
                            ((Method) obj2).invoke(invoke, objArr14);
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
            }
        }
        try {
            byte b = PlaceComponentResult[25];
            byte b2 = b;
            Object[] objArr15 = new Object[1];
            b(b, b2, (byte) (b2 | 36), objArr15);
            Class<?> cls5 = Class.forName((String) objArr15[0]);
            byte b3 = PlaceComponentResult[9];
            byte b4 = PlaceComponentResult[25];
            Object[] objArr16 = new Object[1];
            b(b3, b4, (byte) (b4 | Ascii.NAK), objArr16);
            try {
                Object[] objArr17 = {Integer.valueOf(((Integer) cls5.getMethod((String) objArr16[0], Object.class).invoke(null, this)).intValue())};
                Object obj3 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(25207140);
                if (obj3 == null) {
                    Class cls6 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(View.MeasureSpec.makeMeasureSpec(0, 0) + 494, 5 - (ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)), (char) (ViewConfiguration.getKeyRepeatTimeout() >> 16));
                    Object[] objArr18 = new Object[1];
                    c((byte) (-$$a[40]), $$a[2], $$a[8], objArr18);
                    obj3 = cls6.getMethod((String) objArr18[0], Integer.TYPE);
                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(25207140, obj3);
                }
                Object[] objArr19 = (Object[]) ((Method) obj3).invoke(null, objArr17);
                int i = ((int[]) objArr19[1])[0];
                if (((int[]) objArr19[0])[0] != i) {
                    long j = ((r2 ^ i) & 4294967295L) | 42949672960L;
                    try {
                        Object obj4 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                        if (obj4 != null) {
                            objArr = null;
                        } else {
                            objArr = null;
                            obj4 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - Color.argb(0, 0, 0, 0), ((byte) KeyEvent.getModifierMetaStateMask()) + 36, (char) (TextUtils.indexOf((CharSequence) "", '0', 0) + 1))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj4);
                        }
                        Object invoke2 = ((Method) obj4).invoke(objArr, objArr);
                        try {
                            Object[] objArr20 = {-1241385904, Long.valueOf(j), new ArrayList(), LauncherActivity.getAuid()};
                            Object obj5 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                            if (obj5 == null) {
                                obj5 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - (ViewConfiguration.getJumpTapTimeout() >> 16), 18 - (ViewConfiguration.getMinimumFlingVelocity() >> 16), (char) (((byte) KeyEvent.getModifierMetaStateMask()) + 1))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1759031285, obj5);
                            }
                            ((Method) obj5).invoke(invoke2, objArr20);
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
                super.onCreate(bundle);
                setContentView(R.layout.acplugin_activity_error_page);
                ACLog.d(TAG, "onCreate()");
                init();
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

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // android.app.Activity
    protected void onPause() {
        Context baseContext = getBaseContext();
        if (baseContext == null) {
            Object[] objArr = new Object[1];
            a(super.getResources().getString(id.dana.R.string.intro_3_title).substring(0, 1).length() + 25, new char[]{3053, 4279, 5661, 2574, 21610, 27630, 19165, 15726, 18515, 1049, 16604, 21617, 41470, 53961, 53554, 49546, 61348, 24504, 33538, 3381, 10652, 64040, 44296, 18063, 27555, 35498}, objArr);
            Class<?> cls = Class.forName((String) objArr[0]);
            Object[] objArr2 = new Object[1];
            a(super.getResources().getString(id.dana.R.string.title_error_failed_beneficiary_list).substring(9, 10).length() + 17, new char[]{18522, 35309, 65441, 42296, 54538, 3608, 60408, 45153, 14528, 21895, 9878, 1624, 22829, 46740, 53554, 49546, 9446, 63379}, objArr2);
            baseContext = (Context) cls.getMethod((String) objArr2[0], new Class[0]).invoke(null, null);
        }
        if (baseContext != null) {
            baseContext = baseContext.getApplicationContext();
        }
        if (baseContext != null) {
            try {
                Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                if (obj == null) {
                    obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((-16776287) - Color.rgb(0, 0, 0), 35 - Color.blue(0), (char) Color.blue(0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                }
                Object invoke = ((Method) obj).invoke(null, null);
                try {
                    Object[] objArr3 = {baseContext};
                    Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-549958681);
                    if (obj2 == null) {
                        obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(View.resolveSize(0, 0) + 911, 19 - (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)), (char) (ViewConfiguration.getJumpTapTimeout() >> 16))).getMethod("MyBillsEntityDataFactory", Context.class);
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

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // android.app.Activity
    protected void onResume() {
        Context baseContext = getBaseContext();
        if (baseContext == null) {
            try {
                Object[] objArr = new Object[1];
                b((byte) (-PlaceComponentResult[32]), PlaceComponentResult[30], PlaceComponentResult[7], objArr);
                Class<?> cls = Class.forName((String) objArr[0]);
                b(PlaceComponentResult[48], PlaceComponentResult[8], (byte) (-PlaceComponentResult[59]), new Object[1]);
                Object[] objArr2 = new Object[1];
                a(((ApplicationInfo) cls.getMethod((String) r13[0], null).invoke(this, null)).targetSdkVersion - 7, new char[]{3053, 4279, 5661, 2574, 21610, 27630, 19165, 15726, 18515, 1049, 16604, 21617, 41470, 53961, 53554, 49546, 61348, 24504, 33538, 3381, 10652, 64040, 44296, 18063, 27555, 35498}, objArr2);
                Class<?> cls2 = Class.forName((String) objArr2[0]);
                try {
                    Object[] objArr3 = new Object[1];
                    b((byte) (-PlaceComponentResult[32]), PlaceComponentResult[30], PlaceComponentResult[7], objArr3);
                    Class<?> cls3 = Class.forName((String) objArr3[0]);
                    b(PlaceComponentResult[48], PlaceComponentResult[8], (byte) (-PlaceComponentResult[59]), new Object[1]);
                    Object[] objArr4 = new Object[1];
                    a(((ApplicationInfo) cls3.getMethod((String) r9[0], null).invoke(this, null)).targetSdkVersion - 15, new char[]{18522, 35309, 65441, 42296, 54538, 3608, 60408, 45153, 14528, 21895, 9878, 1624, 22829, 46740, 53554, 49546, 9446, 63379}, objArr4);
                    baseContext = (Context) cls2.getMethod((String) objArr4[0], new Class[0]).invoke(null, null);
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
                    obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getTapTimeout() >> 16) + PDF417Common.NUMBER_OF_CODEWORDS, ((byte) KeyEvent.getModifierMetaStateMask()) + 36, (char) (1 - (SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1))))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                }
                Object invoke = ((Method) obj).invoke(null, null);
                try {
                    Object[] objArr5 = {baseContext};
                    Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(247288059);
                    if (obj2 == null) {
                        obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(959 - AndroidCharacter.getMirror('0'), 17 - TextUtils.indexOf((CharSequence) "", '0'), (char) (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)))).getMethod("KClassImpl$Data$declaredNonStaticMembers$2", Context.class);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(247288059, obj2);
                    }
                    ((Method) obj2).invoke(invoke, objArr5);
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
        super.onResume();
    }

    private static void a(int i, char[] cArr, Object[] objArr) {
        C c = new C();
        char[] cArr2 = new char[cArr.length];
        c.BuiltInFictitiousFunctionClassFactory = 0;
        char[] cArr3 = new char[2];
        while (c.BuiltInFictitiousFunctionClassFactory < cArr.length) {
            cArr3[0] = cArr[c.BuiltInFictitiousFunctionClassFactory];
            cArr3[1] = cArr[c.BuiltInFictitiousFunctionClassFactory + 1];
            int i2 = 58224;
            for (int i3 = 0; i3 < 16; i3++) {
                cArr3[1] = (char) (cArr3[1] - (((cArr3[0] + i2) ^ ((cArr3[0] << 4) + ((char) (getAuthRequestContext ^ 6353485791441662354L)))) ^ ((cArr3[0] >>> 5) + ((char) (scheduleImpl ^ 6353485791441662354L)))));
                cArr3[0] = (char) (cArr3[0] - (((cArr3[1] + i2) ^ ((cArr3[1] << 4) + ((char) (BuiltInFictitiousFunctionClassFactory ^ 6353485791441662354L)))) ^ ((cArr3[1] >>> 5) + ((char) (MyBillsEntityDataFactory ^ 6353485791441662354L)))));
                i2 -= 40503;
            }
            cArr2[c.BuiltInFictitiousFunctionClassFactory] = cArr3[0];
            cArr2[c.BuiltInFictitiousFunctionClassFactory + 1] = cArr3[1];
            c.BuiltInFictitiousFunctionClassFactory += 2;
        }
        objArr[0] = new String(cArr2, 0, i);
    }
}
