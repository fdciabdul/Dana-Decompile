package com.google.android.gms.common.api;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentSender;
import android.content.pm.ApplicationInfo;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.ImageFormat;
import android.graphics.PointF;
import android.graphics.drawable.Drawable;
import android.media.AudioTrack;
import android.os.Build;
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
import android.widget.ExpandableListView;
import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.alibaba.wireless.security.SecExceptionCode;
import com.fullstory.instrumentation.InstrumentInjector;
import com.google.android.gms.cloudmessaging.CloudMessagingReceiver;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.api.internal.GoogleApiManager;
import com.google.android.gms.common.internal.Preconditions;
import com.google.common.base.Ascii;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.google.zxing.pdf417.PDF417Common;
import com.huawei.hms.adapter.internal.CommonCode;
import id.dana.R;
import id.dana.analytics.tracker.TrackerKey;
import id.dana.data.constant.BranchLinkConstant;
import id.dana.onboarding.splash.LauncherActivity;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import o.B;
import o.SummaryVoucherView$$ExternalSyntheticLambda0;

/* loaded from: classes.dex */
public class GoogleApiActivity extends Activity implements DialogInterface.OnCancelListener {
    private static short[] scheduleImpl;
    protected int zaa = 0;
    public static final byte[] $$a = {104, -34, -42, -1, TarHeader.LF_CHR, -48, 46, 10, 7, 14, -39, TarHeader.LF_NORMAL, 13, -4, 18, 12, -46, 36, Ascii.SUB, -12, -20, 34, 9, Ascii.CAN, 2, 10, 14, 5, 22, -44, 59, 6, -5, -15, Ascii.SUB, 19, 11, -9, Ascii.NAK, 8, -42, TarHeader.LF_CHR, 6, 13, -8, Ascii.SUB, 3, -1, TarHeader.LF_NORMAL, -4, Ascii.EM, 7, -35, 43, 10, 3, -65, 39, 36, Ascii.SUB, -12, -54, 71, 8, 5, 16, -4, Ascii.CAN, -6, 6, -15, 40, 6, -20, 40, -12, Ascii.SUB, -4, 1, -15, Ascii.US, 15, -4, 10, Ascii.DC4, 8, -72, Ascii.NAK};
    public static final int $$b = 187;
    public static final byte[] MyBillsEntityDataFactory = {18, 119, 36, -59, 17, -6, 18, 1, -2, -1, -50, 57, 16, 3, 10, -11, 13, 10, -66, Ascii.EM, TarHeader.LF_NORMAL, 3, 10, -11, Ascii.ETB, 0, -1, 5, 13, 10, -7, 15, 9, -45, Ascii.GS, 22, -7, -33, TarHeader.LF_NORMAL, -7, 5, -5, Ascii.EM, -17, -47, 66, -7, 17, -3, -53, 41, 42, -2, 5, -11, 12, 2, 19, -47, TarHeader.LF_CHR, 4, 0, 1, -2, 2, Ascii.ETB, -7, 10, 3, -33, 41, -4, 13};
    public static final int getAuthRequestContext = 255;
    private static int BuiltInFictitiousFunctionClassFactory = 1257195679;
    private static int KClassImpl$Data$declaredNonStaticMembers$2 = -1814179452;
    private static byte[] lookAheadTest = {-115, 17, Ascii.US, 19, -27, -20, TarHeader.LF_CHR, TarHeader.LF_CHR, -86, Ascii.NAK, 80, -37, -22, -21, -20, Ascii.US, -25, Ascii.FS, -102, -52, 35, -21, 59, -123, 81, -82, -95, 88, 70, -119, 87, 89, -95, 95, -89, 67, 112, 65, -20, 82, 93, 97, -104, -87, -88, -81, 92, -92, 95, -115, -37, 34, -47, TarHeader.LF_CONTIG, -38, -34, -39, -40, 36, 11, -23, 34, 45, -41, 36, -39, TarHeader.LF_FIFO, -81, -1, -45, 1, -4, -46, Ascii.RS, -1, -41, 40, 47, 3, -3, -41, 44, 45, 4, -44, 45, -30, Ascii.RS, -4, -43, Ascii.US, -2, 3, -48, 47, -45, -5, -43, -48, 43, -43, 47, Ascii.GS, 47, -45, 46, -2, 47, 47, 5, -28, 40, -46, 3, -4, -33, -50, 45, 6, -50, -2, TarHeader.LF_CHR, 0, -2, 0, -8, -1, 1, 3, 5, 1, -3, 7, -5, -43, TarHeader.LF_CHR, -51, TarHeader.LF_BLK, -6, 3, 2, -52, 1, 42, 5, -47, 0, TarHeader.LF_NORMAL, 1, -49, 45, -46, 45, -42, 45, 2, -4, 4, -52, TarHeader.LF_SYMLINK, -54, TarHeader.LF_DIR, 1, -1, 2, 1, -52, 46, -3, -41, -2, 45, 9, -10, -46, 3, 47, 0, -43, -33, 5, 1, -50, TarHeader.LF_LINK, -4, 5, -1, 3, -50, TarHeader.LF_BLK, -2, -52, 3, 43, -46, 5, 0, TarHeader.LF_NORMAL, -7, 5, 2, -54, 47, 1, 3, -2, -44, 43, 7, -49, 44, -43, 45, -48, 1, 47, -2, -46, 46, 5, -45, -2, TarHeader.LF_LINK, -49, TarHeader.LF_LINK, -50, 5, 43, 6, -4, 3, 1, -8, 1, 1, 5, 3, -6, -1, -42, -4, TarHeader.LF_DIR, -2, -93, -81, 86, 89, -65, 65, 102, -83, -20, Ascii.ETB, -21, 81, 94, -82, -87, 85, 106, -106, -87, 95, 98, -110, -82, 92, 101, -103, -93, 65, -68, 84, -82, 95, -94, 65, -68, 94, 105, -22, 81, 66, -82, -65, 67, -84, -93, 90, -92, 22, -99, -93, 93, -83, 101, 80, -91, -105, 83, -84, 80, 92, -103, -3, 6, -8, 4, -9};
    private static int PlaceComponentResult = -99101416;

    /* JADX WARN: Removed duplicated region for block: B:20:0x001b  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0023  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:22:0x0023 -> B:23:0x002b). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void a(byte r7, short r8, int r9, java.lang.Object[] r10) {
        /*
            int r8 = 106 - r8
            byte[] r0 = com.google.android.gms.common.api.GoogleApiActivity.MyBillsEntityDataFactory
            int r9 = 23 - r9
            int r7 = r7 + 4
            byte[] r1 = new byte[r9]
            r2 = 0
            if (r0 != 0) goto L13
            r3 = r1
            r4 = 0
            r1 = r0
            r0 = r10
            r10 = r9
            goto L2b
        L13:
            r3 = 0
        L14:
            int r4 = r3 + 1
            byte r5 = (byte) r8
            r1[r3] = r5
            if (r4 != r9) goto L23
            java.lang.String r7 = new java.lang.String
            r7.<init>(r1, r2)
            r10[r2] = r7
            return
        L23:
            r3 = r0[r7]
            r6 = r10
            r10 = r9
            r9 = r3
            r3 = r1
            r1 = r0
            r0 = r6
        L2b:
            int r8 = r8 + r9
            int r8 = r8 + (-4)
            int r7 = r7 + 1
            r9 = r10
            r10 = r0
            r0 = r1
            r1 = r3
            r3 = r4
            goto L14
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.api.GoogleApiActivity.a(byte, short, int, java.lang.Object[]):void");
    }

    private static void c(short s, short s2, short s3, Object[] objArr) {
        byte[] bArr = $$a;
        int i = (s3 * 2) + 75;
        int i2 = (s2 * 3) + 21;
        int i3 = 47 - s;
        byte[] bArr2 = new byte[i2];
        int i4 = -1;
        int i5 = i2 - 1;
        if (bArr == null) {
            i = (i3 + i) - 7;
            i3++;
            i5 = i5;
        }
        while (true) {
            i4++;
            bArr2[i4] = (byte) i;
            if (i4 == i5) {
                objArr[0] = new String(bArr2, 0);
                return;
            }
            int i6 = i5;
            int i7 = i3;
            i = (i + bArr[i3]) - 7;
            i3 = i7 + 1;
            i5 = i6;
        }
    }

    public static Intent zaa(Context context, PendingIntent pendingIntent, int i, boolean z) {
        Intent intent = new Intent(context, GoogleApiActivity.class);
        intent.putExtra(CloudMessagingReceiver.IntentKeys.PENDING_INTENT, pendingIntent);
        intent.putExtra("failing_client_id", i);
        intent.putExtra("notify_manager", z);
        return intent;
    }

    private final void zab() {
        Bundle extras = getIntent().getExtras();
        if (extras == null) {
            InstrumentInjector.log_e("GoogleApiActivity", "Activity started without extras");
            finish();
            return;
        }
        PendingIntent pendingIntent = (PendingIntent) extras.get(CloudMessagingReceiver.IntentKeys.PENDING_INTENT);
        Integer num = (Integer) extras.get(TrackerKey.Property.ERROR_CODE_FIREBASE);
        if (pendingIntent == null && num == null) {
            InstrumentInjector.log_e("GoogleApiActivity", "Activity started without resolution");
            finish();
        } else if (pendingIntent != null) {
            try {
                startIntentSenderForResult(pendingIntent.getIntentSender(), 1, null, 0, 0, 0);
                this.zaa = 1;
            } catch (ActivityNotFoundException e) {
                if (!extras.getBoolean("notify_manager", true)) {
                    String obj = pendingIntent.toString();
                    StringBuilder sb = new StringBuilder(obj.length() + 36);
                    sb.append("Activity not found while launching ");
                    sb.append(obj);
                    sb.append(".");
                    String obj2 = sb.toString();
                    if (Build.FINGERPRINT.contains("generic")) {
                        obj2 = obj2.concat(" This may occur when resolving Google Play services connection issues on emulators with Google APIs but not Google Play Store.");
                    }
                    InstrumentInjector.log_e("GoogleApiActivity", obj2, e);
                } else {
                    GoogleApiManager.zam(this).zaz(new ConnectionResult(22, null), getIntent().getIntExtra("failing_client_id", -1));
                }
                this.zaa = 1;
                finish();
            } catch (IntentSender.SendIntentException e2) {
                InstrumentInjector.log_e("GoogleApiActivity", "Failed to launch pendingIntent", e2);
                finish();
            }
        } else {
            GoogleApiAvailability.getInstance().showErrorDialogFragment(this, ((Integer) Preconditions.checkNotNull(num)).intValue(), 2, this);
            this.zaa = 1;
        }
    }

    @Override // android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper
    public void attachBaseContext(Context context) {
        Object[] objArr;
        Object[] objArr2;
        Object[] objArr3;
        Object[] objArr4;
        super.attachBaseContext(context);
        Object[] objArr5 = new Object[1];
        b((ViewConfiguration.getTouchSlop() >> 8) + 650995526, TextUtils.getTrimmedLength("") - 1, (byte) ((-114) - Drawable.resolveOpacity(0, 0)), (short) (ViewConfiguration.getKeyRepeatDelay() >> 16), KeyEvent.getDeadChar(0, 0) + 1325884025, objArr5);
        Class<?> cls = Class.forName((String) objArr5[0]);
        Object[] objArr6 = new Object[1];
        b(650995538 - KeyEvent.normalizeMetaState(0), Color.blue(0) - 1, (byte) ((-88) - ((Process.getThreadPriority(0) + 20) >> 6)), (short) Gravity.getAbsoluteGravity(0, 0), 1325884043 - TextUtils.getOffsetBefore("", 0), objArr6);
        int intValue = ((Integer) cls.getDeclaredMethod((String) objArr6[0], new Class[0]).invoke(null, new Object[0])).intValue() % 100000;
        if (intValue < 99000 || intValue > 99999) {
            Context applicationContext = context != null ? context.getApplicationContext() : context;
            if (applicationContext != null) {
                try {
                    Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                    if (obj == null) {
                        obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((Process.myPid() >> 22) + PDF417Common.NUMBER_OF_CODEWORDS, (ViewConfiguration.getKeyRepeatTimeout() >> 16) + 35, (char) Color.argb(0, 0, 0, 0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                    }
                    Object invoke = ((Method) obj).invoke(null, null);
                    Object[] objArr7 = new Object[1];
                    b((AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)) + 650995483, (-1) - Color.alpha(0), (byte) (80 - (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1))), (short) (ViewConfiguration.getMinimumFlingVelocity() >> 16), View.MeasureSpec.getMode(0) + 1325884092, objArr7);
                    String str = (String) objArr7[0];
                    Object[] objArr8 = new Object[1];
                    b(650995526 - (Process.myPid() >> 22), (-1) - (KeyEvent.getMaxKeyCode() >> 16), (byte) ((ViewConfiguration.getDoubleTapTimeout() >> 16) - 98), (short) View.MeasureSpec.getSize(0), 1325884140 - (ViewConfiguration.getTapTimeout() >> 16), objArr8);
                    String str2 = (String) objArr8[0];
                    Object[] objArr9 = new Object[1];
                    b(TextUtils.getOffsetAfter("", 0) + 650995479, (-1) - (ViewConfiguration.getWindowTouchSlop() >> 8), (byte) (KeyEvent.normalizeMetaState(0) - 98), (short) (Color.rgb(0, 0, 0) + 16777216), 1325884204 - ExpandableListView.getPackedPositionGroup(0L), objArr9);
                    String str3 = (String) objArr9[0];
                    Object[] objArr10 = new Object[1];
                    b(650995532 - Process.getGidForName(""), MotionEvent.axisFromString(""), (byte) ((Process.myPid() >> 22) - 49), (short) View.resolveSize(0, 0), 1325884267 - TextUtils.indexOf((CharSequence) "", '0', 0, 0), objArr10);
                    String str4 = (String) objArr10[0];
                    Object[] objArr11 = new Object[1];
                    b(650995485 - TextUtils.lastIndexOf("", '0'), (-1) - (ViewConfiguration.getJumpTapTimeout() >> 16), (byte) ((-100) - Process.getGidForName("")), (short) ((Process.getThreadPriority(0) + 20) >> 6), 1325884328 - View.resolveSize(0, 0), objArr11);
                    try {
                        Object[] objArr12 = {applicationContext, str, str2, str3, str4, true, (String) objArr11[0], 995651014};
                        Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-1276397751);
                        if (obj2 == null) {
                            obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - (ViewConfiguration.getMinimumFlingVelocity() >> 16), (ViewConfiguration.getLongPressTimeout() >> 16) + 18, (char) (Process.myPid() >> 22))).getMethod("getAuthRequestContext", Context.class, String.class, String.class, String.class, String.class, Boolean.TYPE, String.class, Integer.TYPE);
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
                a((byte) (getAuthRequestContext & 37), MyBillsEntityDataFactory[25], (byte) (-MyBillsEntityDataFactory[30]), objArr13);
                Class<?> cls2 = Class.forName((String) objArr13[0]);
                Object[] objArr14 = new Object[1];
                a(MyBillsEntityDataFactory[35], MyBillsEntityDataFactory[7], (byte) (-MyBillsEntityDataFactory[30]), objArr14);
                try {
                    Object[] objArr15 = {applicationContext2, Integer.valueOf(((Integer) cls2.getMethod((String) objArr14[0], Object.class).invoke(null, this)).intValue())};
                    Object obj3 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1691739267);
                    if (obj3 == null) {
                        Class cls3 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getMinimumFlingVelocity() >> 16) + 55, 3 - Drawable.resolveOpacity(0, 0), (char) View.resolveSizeAndState(0, 0, 0));
                        byte b = $$a[53];
                        byte b2 = $$a[78];
                        Object[] objArr16 = new Object[1];
                        c(b, b2, b2, objArr16);
                        obj3 = cls3.getMethod((String) objArr16[0], Context.class, Integer.TYPE);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1691739267, obj3);
                    }
                    Object invoke2 = ((Method) obj3).invoke(null, objArr15);
                    try {
                        Object obj4 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(40157535);
                        if (obj4 == null) {
                            obj4 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(TextUtils.indexOf((CharSequence) "", '0') + SecExceptionCode.SEC_ERROR_PKG_VALID_INVALID_PARAM, 15 - (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)), (char) (KeyEvent.getMaxKeyCode() >> 16))).getMethod("getAuthRequestContext", null);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(40157535, obj4);
                        }
                        int intValue2 = ((Integer) ((Method) obj4).invoke(invoke2, null)).intValue();
                        try {
                            Object obj5 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1621779126);
                            if (obj5 == null) {
                                obj5 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(((byte) KeyEvent.getModifierMetaStateMask()) + 801, 15 - (ViewConfiguration.getMinimumFlingVelocity() >> 16), (char) (ViewConfiguration.getScrollBarFadeDuration() >> 16))).getMethod("PlaceComponentResult", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1621779126, obj5);
                            }
                            if (((Integer) ((Method) obj5).invoke(invoke2, null)).intValue() != intValue2) {
                                ArrayList arrayList = new ArrayList();
                                try {
                                    Object[] objArr17 = {invoke2};
                                    Object obj6 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(658700871);
                                    if (obj6 == null) {
                                        obj6 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(View.resolveSize(0, 0) + 815, 'M' - AndroidCharacter.getMirror('0'), (char) (TextUtils.lastIndexOf("", '0', 0) + 57995))).getMethod("getAuthRequestContext", (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(799 - TextUtils.indexOf((CharSequence) "", '0', 0), View.resolveSizeAndState(0, 0, 0) + 15, (char) (TextUtils.lastIndexOf("", '0', 0) + 1)));
                                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(658700871, obj6);
                                    }
                                    arrayList.add(((Method) obj6).invoke(null, objArr17));
                                    long j = ((r9 ^ intValue2) & 4294967295L) | 60129542144L;
                                    try {
                                        Object obj7 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                                        if (obj7 != null) {
                                            objArr = null;
                                        } else {
                                            objArr = null;
                                            obj7 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)) + 930, 35 - (Process.myTid() >> 22), (char) (Process.myPid() >> 22))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj7);
                                        }
                                        Object invoke3 = ((Method) obj7).invoke(objArr, objArr);
                                        try {
                                            Object[] objArr18 = {-404338547, Long.valueOf(j), arrayList, LauncherActivity.getAuid()};
                                            Object obj8 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                            if (obj8 == null) {
                                                obj8 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(910 - ((byte) KeyEvent.getModifierMetaStateMask()), (ViewConfiguration.getJumpTapTimeout() >> 16) + 18, (char) (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                a((byte) (getAuthRequestContext & 37), MyBillsEntityDataFactory[25], (byte) (-MyBillsEntityDataFactory[30]), objArr19);
                Class<?> cls4 = Class.forName((String) objArr19[0]);
                Object[] objArr20 = new Object[1];
                a(MyBillsEntityDataFactory[35], MyBillsEntityDataFactory[7], (byte) (-MyBillsEntityDataFactory[30]), objArr20);
                try {
                    Object[] objArr21 = {applicationContext3, Integer.valueOf(((Integer) cls4.getMethod((String) objArr20[0], Object.class).invoke(null, this)).intValue())};
                    Object obj9 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(345757441);
                    if (obj9 == null) {
                        Class cls5 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(61 - (ViewConfiguration.getMaximumFlingVelocity() >> 16), (ViewConfiguration.getWindowTouchSlop() >> 8) + 46, (char) ((SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)) - 1));
                        Object[] objArr22 = new Object[1];
                        c($$a[84], (byte) ($$a[78] - 1), $$a[9], objArr22);
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
                                objArr2 = null;
                            } else {
                                objArr2 = null;
                                obj10 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)), 35 - Color.red(0), (char) (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj10);
                            }
                            Object invoke4 = ((Method) obj10).invoke(objArr2, objArr2);
                            try {
                                Object[] objArr24 = {-404338547, Long.valueOf(j2), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj11 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj11 == null) {
                                    obj11 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(912 - (Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1)), TextUtils.lastIndexOf("", '0') + 19, (char) (ViewConfiguration.getMaximumFlingVelocity() >> 16))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                a((byte) (getAuthRequestContext & 37), MyBillsEntityDataFactory[25], (byte) (-MyBillsEntityDataFactory[30]), objArr25);
                Class<?> cls6 = Class.forName((String) objArr25[0]);
                Object[] objArr26 = new Object[1];
                a(MyBillsEntityDataFactory[35], MyBillsEntityDataFactory[7], (byte) (-MyBillsEntityDataFactory[30]), objArr26);
                try {
                    Object[] objArr27 = {applicationContext4, Integer.valueOf(((Integer) cls6.getMethod((String) objArr26[0], Object.class).invoke(null, this)).intValue())};
                    Object obj12 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-697999596);
                    if (obj12 == null) {
                        Class cls7 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(118 - (CdmaCellLocation.convertQuartSecToDecDegrees(0) > FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 0 : -1)), (ViewConfiguration.getFadingEdgeLength() >> 16) + 3, (char) (38968 - TextUtils.indexOf("", "", 0)));
                        Object[] objArr28 = new Object[1];
                        c($$a[84], (byte) ($$a[78] - 1), $$a[9], objArr28);
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
                                obj13 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(View.combineMeasuredStates(0, 0) + PDF417Common.NUMBER_OF_CODEWORDS, (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)) + 35, (char) (ViewConfiguration.getPressedStateDuration() >> 16))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj13);
                            }
                            Object invoke5 = ((Method) obj13).invoke(objArr3, objArr3);
                            try {
                                Object[] objArr30 = {-404338547, Long.valueOf(j3), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj14 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj14 == null) {
                                    obj14 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - (ViewConfiguration.getPressedStateDuration() >> 16), (KeyEvent.getMaxKeyCode() >> 16) + 18, (char) ('0' - AndroidCharacter.getMirror('0')))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                a((byte) (getAuthRequestContext & 37), MyBillsEntityDataFactory[25], (byte) (-MyBillsEntityDataFactory[30]), objArr31);
                Class<?> cls8 = Class.forName((String) objArr31[0]);
                Object[] objArr32 = new Object[1];
                a(MyBillsEntityDataFactory[35], MyBillsEntityDataFactory[7], (byte) (-MyBillsEntityDataFactory[30]), objArr32);
                try {
                    Object[] objArr33 = {applicationContext5, Integer.valueOf(((Integer) cls8.getMethod((String) objArr32[0], Object.class).invoke(null, this)).intValue())};
                    Object obj15 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-16683571);
                    if (obj15 == null) {
                        Class cls9 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(107 - TextUtils.indexOf("", "", 0, 0), (ViewConfiguration.getEdgeSlop() >> 16) + 3, (char) (ViewConfiguration.getPressedStateDuration() >> 16));
                        Object[] objArr34 = new Object[1];
                        c((byte) ($$a[78] - 1), $$a[8], (byte) ($$a[78] - 1), objArr34);
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
                                objArr4 = null;
                            } else {
                                objArr4 = null;
                                obj16 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getMinimumFlingVelocity() >> 16) + PDF417Common.NUMBER_OF_CODEWORDS, TextUtils.indexOf((CharSequence) "", '0') + 36, (char) (ExpandableListView.getPackedPositionChild(0L) + 1))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj16);
                            }
                            Object invoke6 = ((Method) obj16).invoke(objArr4, objArr4);
                            try {
                                Object[] objArr36 = {-404338547, Long.valueOf(j4), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj17 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj17 == null) {
                                    obj17 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(TextUtils.indexOf((CharSequence) "", '0') + 912, 18 - (ViewConfiguration.getEdgeSlop() >> 16), (char) (ViewConfiguration.getTouchSlop() >> 8))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
    protected final void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 1) {
            boolean booleanExtra = getIntent().getBooleanExtra("notify_manager", true);
            this.zaa = 0;
            setResult(i2, intent);
            if (booleanExtra) {
                GoogleApiManager zam = GoogleApiManager.zam(this);
                if (i2 == -1) {
                    zam.zaA();
                } else if (i2 == 0) {
                    zam.zaz(new ConnectionResult(13, null), getIntent().getIntExtra("failing_client_id", -1));
                }
            }
        } else if (i == 2) {
            this.zaa = 0;
            setResult(i2, intent);
        }
        finish();
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public final void onCancel(DialogInterface dialogInterface) {
        this.zaa = 0;
        setResult(0);
        finish();
    }

    @Override // android.app.Activity
    protected final void onCreate(Bundle bundle) {
        Object[] objArr;
        int codePointAt = super.getResources().getString(R.string.mybills_manage_bills_automatic_payment).substring(16, 17).codePointAt(0) + 650995410;
        int i = (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)) - 1;
        try {
            Object[] objArr2 = new Object[1];
            a(MyBillsEntityDataFactory[25], MyBillsEntityDataFactory[32], MyBillsEntityDataFactory[25], objArr2);
            Class<?> cls = Class.forName((String) objArr2[0]);
            a((byte) (getAuthRequestContext & 52), MyBillsEntityDataFactory[13], MyBillsEntityDataFactory[27], new Object[1]);
            byte b = (byte) (((ApplicationInfo) cls.getMethod((String) r4[0], null).invoke(this, null)).targetSdkVersion - 147);
            try {
                Object[] objArr3 = new Object[1];
                a(MyBillsEntityDataFactory[25], MyBillsEntityDataFactory[32], MyBillsEntityDataFactory[25], objArr3);
                Class<?> cls2 = Class.forName((String) objArr3[0]);
                a((byte) (getAuthRequestContext & 52), MyBillsEntityDataFactory[13], MyBillsEntityDataFactory[27], new Object[1]);
                Object[] objArr4 = new Object[1];
                b(codePointAt, i, b, (short) (((ApplicationInfo) cls2.getMethod((String) r12[0], null).invoke(this, null)).targetSdkVersion - 33), super.getResources().getString(R.string.event_countdown).substring(0, 6).length() + 1325884019, objArr4);
                Class<?> cls3 = Class.forName((String) objArr4[0]);
                try {
                    Object[] objArr5 = new Object[1];
                    a(MyBillsEntityDataFactory[25], MyBillsEntityDataFactory[32], MyBillsEntityDataFactory[25], objArr5);
                    Class<?> cls4 = Class.forName((String) objArr5[0]);
                    Object[] objArr6 = new Object[1];
                    a((byte) (getAuthRequestContext & 52), MyBillsEntityDataFactory[13], MyBillsEntityDataFactory[27], objArr6);
                    Object[] objArr7 = new Object[1];
                    b(((ApplicationInfo) cls4.getMethod((String) objArr6[0], null).invoke(this, null)).targetSdkVersion + 650995505, super.getResources().getString(R.string.onboarding_permission_location_title).substring(4, 5).length() - 2, (byte) (getPackageName().codePointAt(6) - 185), (short) (ImageFormat.getBitsPerPixel(0) + 1), (ViewConfiguration.getTouchSlop() >> 8) + 1325884043, objArr7);
                    int intValue = ((Integer) cls3.getDeclaredMethod((String) objArr7[0], new Class[0]).invoke(null, new Object[0])).intValue() % 100000;
                    if (intValue < 99000 || intValue > 99999) {
                        Context baseContext = getBaseContext();
                        if (baseContext == null) {
                            int indexOf = TextUtils.indexOf((CharSequence) "", '0') + 650995527;
                            int length = super.getResources().getString(R.string.family_what_is_your_relation).substring(2, 3).length() - 2;
                            byte codePointAt2 = (byte) (super.getResources().getString(R.string.share_activity_cancel_dialog_title).substring(1, 2).codePointAt(0) - 148);
                            short s = (short) (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1));
                            try {
                                Object[] objArr8 = new Object[1];
                                a(MyBillsEntityDataFactory[25], MyBillsEntityDataFactory[32], MyBillsEntityDataFactory[25], objArr8);
                                Class<?> cls5 = Class.forName((String) objArr8[0]);
                                Object[] objArr9 = new Object[1];
                                a((byte) (getAuthRequestContext & 52), MyBillsEntityDataFactory[13], MyBillsEntityDataFactory[27], objArr9);
                                int i2 = ((ApplicationInfo) cls5.getMethod((String) objArr9[0], null).invoke(this, null)).targetSdkVersion + 1325884015;
                                Object[] objArr10 = new Object[1];
                                b(indexOf, length, codePointAt2, s, i2, objArr10);
                                Class<?> cls6 = Class.forName((String) objArr10[0]);
                                try {
                                    Object[] objArr11 = new Object[1];
                                    a(MyBillsEntityDataFactory[25], MyBillsEntityDataFactory[32], MyBillsEntityDataFactory[25], objArr11);
                                    Class<?> cls7 = Class.forName((String) objArr11[0]);
                                    Object[] objArr12 = new Object[1];
                                    a((byte) (getAuthRequestContext & 52), MyBillsEntityDataFactory[13], MyBillsEntityDataFactory[27], objArr12);
                                    int i3 = ((ApplicationInfo) cls7.getMethod((String) objArr12[0], null).invoke(this, null)).targetSdkVersion + 650995495;
                                    try {
                                        Object[] objArr13 = new Object[1];
                                        a(MyBillsEntityDataFactory[25], MyBillsEntityDataFactory[32], MyBillsEntityDataFactory[25], objArr13);
                                        Class<?> cls8 = Class.forName((String) objArr13[0]);
                                        a((byte) (getAuthRequestContext & 52), MyBillsEntityDataFactory[13], MyBillsEntityDataFactory[27], new Object[1]);
                                        Object[] objArr14 = new Object[1];
                                        b(i3, ((ApplicationInfo) cls8.getMethod((String) r10[0], null).invoke(this, null)).targetSdkVersion - 34, (byte) (getPackageName().length() - 76), (short) (ViewConfiguration.getPressedStateDuration() >> 16), 1325884074 - (ViewConfiguration.getJumpTapTimeout() >> 16), objArr14);
                                        baseContext = (Context) cls6.getMethod((String) objArr14[0], new Class[0]).invoke(null, null);
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
                        if (baseContext != null) {
                            baseContext = baseContext.getApplicationContext();
                        }
                        if (baseContext != null) {
                            try {
                                Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                                if (obj == null) {
                                    obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(Color.green(0) + PDF417Common.NUMBER_OF_CODEWORDS, TextUtils.indexOf((CharSequence) "", '0', 0) + 36, (char) (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                                }
                                Object invoke = ((Method) obj).invoke(null, null);
                                Object[] objArr15 = new Object[1];
                                b(super.getResources().getString(R.string.label_see_detail).substring(0, 11).length() + 650995473, (ViewConfiguration.getMinimumFlingVelocity() >> 16) - 1, (byte) (getPackageName().length() + 72), (short) (super.getResources().getString(R.string.send_money_rename_saved_bank_account).substring(12, 13).codePointAt(0) - 97), 1325884092 - View.MeasureSpec.getMode(0), objArr15);
                                String str = (String) objArr15[0];
                                Object[] objArr16 = new Object[1];
                                b(getPackageName().length() + 650995519, super.getResources().getString(R.string.social_feed_error_message).substring(14, 15).codePointAt(0) - 102, (byte) (super.getResources().getString(R.string.setting_more_deeplink_error_msg).substring(31, 33).codePointAt(0) - 214), (short) (ViewConfiguration.getKeyRepeatTimeout() >> 16), getPackageName().codePointAt(3) + 1325884040, objArr16);
                                String str2 = (String) objArr16[0];
                                Object[] objArr17 = new Object[1];
                                b(super.getResources().getString(R.string.family_member_deleted_title).substring(36, 37).length() + 650995478, super.getResources().getString(R.string.card_binding_permission_dialog_title).substring(0, 18).length() - 19, (byte) (getPackageName().length() + BranchLinkConstant.DeepLinkErrorCode.SAME_ALIAS), (short) (ViewConfiguration.getScrollBarSize() >> 8), 1325884204 - TextUtils.getCapsMode("", 0, 0), objArr17);
                                String str3 = (String) objArr17[0];
                                Object[] objArr18 = new Object[1];
                                b(650995533 - (ViewConfiguration.getMinimumFlingVelocity() >> 16), super.getResources().getString(R.string.max_send_amount_error_message).substring(25, 27).codePointAt(1) - 116, (byte) (ImageFormat.getBitsPerPixel(0) - 48), (short) KeyEvent.getDeadChar(0, 0), super.getResources().getString(R.string.no_contact).substring(0, 1).length() + 1325884267, objArr18);
                                String str4 = (String) objArr18[0];
                                Object[] objArr19 = new Object[1];
                                b(650995487 - (ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)), super.getResources().getString(R.string.email_unverify).substring(51, 53).codePointAt(0) - 103, (byte) ((-99) - View.resolveSizeAndState(0, 0, 0)), (short) (getPackageName().length() - 7), getPackageName().codePointAt(6) + 1325884231, objArr19);
                                try {
                                    Object[] objArr20 = {baseContext, str, str2, str3, str4, true, (String) objArr19[0], 995651014};
                                    Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-1276397751);
                                    if (obj2 == null) {
                                        obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)) + 910, (ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)) + 17, (char) (ViewConfiguration.getMinimumFlingVelocity() >> 16))).getMethod("getAuthRequestContext", Context.class, String.class, String.class, String.class, String.class, Boolean.TYPE, String.class, Integer.TYPE);
                                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(-1276397751, obj2);
                                    }
                                    ((Method) obj2).invoke(invoke, objArr20);
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
                        Object[] objArr21 = new Object[1];
                        a((byte) (getAuthRequestContext & 37), MyBillsEntityDataFactory[25], (byte) (-MyBillsEntityDataFactory[30]), objArr21);
                        Class<?> cls9 = Class.forName((String) objArr21[0]);
                        Object[] objArr22 = new Object[1];
                        a(MyBillsEntityDataFactory[35], MyBillsEntityDataFactory[7], (byte) (-MyBillsEntityDataFactory[30]), objArr22);
                        try {
                            Object[] objArr23 = {Integer.valueOf(((Integer) cls9.getMethod((String) objArr22[0], Object.class).invoke(null, this)).intValue())};
                            Object obj3 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(25207140);
                            if (obj3 == null) {
                                Class cls10 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(493 - (ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)), 4 - KeyEvent.normalizeMetaState(0), (char) ((ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)) + 1));
                                Object[] objArr24 = new Object[1];
                                c((byte) ($$a[78] - 1), $$a[8], (byte) ($$a[78] - 1), objArr24);
                                obj3 = cls10.getMethod((String) objArr24[0], Integer.TYPE);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(25207140, obj3);
                            }
                            Object[] objArr25 = (Object[]) ((Method) obj3).invoke(null, objArr23);
                            int i4 = ((int[]) objArr25[1])[0];
                            if (((int[]) objArr25[0])[0] != i4) {
                                long j = ((r2 ^ i4) & 4294967295L) | 42949672960L;
                                try {
                                    Object obj4 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                                    if (obj4 != null) {
                                        objArr = null;
                                    } else {
                                        objArr = null;
                                        obj4 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(KeyEvent.normalizeMetaState(0) + PDF417Common.NUMBER_OF_CODEWORDS, 35 - Gravity.getAbsoluteGravity(0, 0), (char) ((-1) - ExpandableListView.getPackedPositionChild(0L)))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj4);
                                    }
                                    Object invoke2 = ((Method) obj4).invoke(objArr, objArr);
                                    try {
                                        Object[] objArr26 = {1147965210, Long.valueOf(j), new ArrayList(), LauncherActivity.getAuid()};
                                        Object obj5 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                        if (obj5 == null) {
                                            obj5 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1)) + 910, TextUtils.getCapsMode("", 0, 0) + 18, (char) Color.argb(0, 0, 0, 0))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
                                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1759031285, obj5);
                                        }
                                        ((Method) obj5).invoke(invoke2, objArr26);
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
                            if (bundle != null) {
                                this.zaa = bundle.getInt(CommonCode.MapKey.HAS_RESOLUTION);
                            }
                            if (this.zaa != 1) {
                                zab();
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

    @Override // android.app.Activity
    protected void onPause() {
        Context baseContext = getBaseContext();
        if (baseContext == null) {
            try {
                Object[] objArr = new Object[1];
                a(MyBillsEntityDataFactory[25], MyBillsEntityDataFactory[32], MyBillsEntityDataFactory[25], objArr);
                Class<?> cls = Class.forName((String) objArr[0]);
                Object[] objArr2 = new Object[1];
                a((byte) (getAuthRequestContext & 52), MyBillsEntityDataFactory[13], MyBillsEntityDataFactory[27], objArr2);
                Object[] objArr3 = new Object[1];
                b(((ApplicationInfo) cls.getMethod((String) objArr2[0], null).invoke(this, null)).targetSdkVersion + 650995493, super.getResources().getString(R.string.uh_oh_no_internet_connection).substring(0, 1).codePointAt(0) - 86, (byte) ((CdmaCellLocation.convertQuartSecToDecDegrees(0) > FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 0 : -1)) - 51), (short) (getPackageName().length() - 7), 1325884048 - (ViewConfiguration.getFadingEdgeLength() >> 16), objArr3);
                Class<?> cls2 = Class.forName((String) objArr3[0]);
                Object[] objArr4 = new Object[1];
                b(getPackageName().length() + 650995521, super.getResources().getString(R.string.card_binding_disclaimer_express_pay).substring(4, 5).codePointAt(0) - 98, (byte) (getPackageName().length() - 76), (short) (ViewConfiguration.getKeyRepeatDelay() >> 16), 1325884074 - TextUtils.getOffsetBefore("", 0), objArr4);
                baseContext = (Context) cls2.getMethod((String) objArr4[0], new Class[0]).invoke(null, null);
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
                    obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - KeyEvent.normalizeMetaState(0), 35 - (ViewConfiguration.getTapTimeout() >> 16), (char) ((ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1)) - 1))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                }
                Object invoke = ((Method) obj).invoke(null, null);
                try {
                    Object[] objArr5 = {baseContext};
                    Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-549958681);
                    if (obj2 == null) {
                        obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - View.MeasureSpec.makeMeasureSpec(0, 0), 17 - TextUtils.indexOf((CharSequence) "", '0', 0), (char) (ViewConfiguration.getScrollBarFadeDuration() >> 16))).getMethod("MyBillsEntityDataFactory", Context.class);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(-549958681, obj2);
                    }
                    ((Method) obj2).invoke(invoke, objArr5);
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
        super.onPause();
    }

    @Override // android.app.Activity
    protected void onResume() {
        Context baseContext = getBaseContext();
        if (baseContext == null) {
            Object[] objArr = new Object[1];
            b(super.getResources().getString(R.string.bill_empty_state_description).substring(10, 11).length() + 650995525, super.getResources().getString(R.string.select_transaction_purpose_title).substring(2, 3).length() - 2, (byte) ((ViewConfiguration.getMaximumFlingVelocity() >> 16) - 51), (short) (super.getResources().getString(R.string.notification_center).substring(0, 6).length() - 6), getPackageName().length() + 1325884041, objArr);
            Class<?> cls = Class.forName((String) objArr[0]);
            Object[] objArr2 = new Object[1];
            b(getPackageName().length() + 650995521, (-1) - View.MeasureSpec.getSize(0), (byte) (super.getResources().getString(R.string.group_send_empty_state_title).substring(5, 6).length() - 70), (short) (super.getResources().getString(R.string.error_message_max_limit).substring(12, 13).codePointAt(0) - 32), super.getResources().getString(R.string.view_less).substring(1, 2).length() + 1325884073, objArr2);
            baseContext = (Context) cls.getMethod((String) objArr2[0], new Class[0]).invoke(null, null);
        }
        if (baseContext != null) {
            baseContext = baseContext.getApplicationContext();
        }
        if (baseContext != null) {
            try {
                Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                if (obj == null) {
                    obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((-16776287) - Color.rgb(0, 0, 0), (ViewConfiguration.getKeyRepeatTimeout() >> 16) + 35, (char) (ViewConfiguration.getLongPressTimeout() >> 16))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                }
                Object invoke = ((Method) obj).invoke(null, null);
                try {
                    Object[] objArr3 = {baseContext};
                    Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(247288059);
                    if (obj2 == null) {
                        obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getEdgeSlop() >> 16) + 911, 17 - MotionEvent.axisFromString(""), (char) (ViewConfiguration.getTapTimeout() >> 16))).getMethod("KClassImpl$Data$declaredNonStaticMembers$2", Context.class);
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

    @Override // android.app.Activity
    protected final void onSaveInstanceState(Bundle bundle) {
        bundle.putInt(CommonCode.MapKey.HAS_RESOLUTION, this.zaa);
        super.onSaveInstanceState(bundle);
    }

    private static void b(int i, int i2, byte b, short s, int i3, Object[] objArr) {
        B b2 = new B();
        StringBuilder sb = new StringBuilder();
        int i4 = i2 + ((int) (BuiltInFictitiousFunctionClassFactory ^ 3097486228508854431L));
        int i5 = i4 == -1 ? 1 : 0;
        if (i5 != 0) {
            byte[] bArr = lookAheadTest;
            if (bArr != null) {
                int length = bArr.length;
                byte[] bArr2 = new byte[length];
                for (int i6 = 0; i6 < length; i6++) {
                    bArr2[i6] = (byte) (bArr[i6] ^ 3097486228508854431L);
                }
                bArr = bArr2;
            }
            if (bArr != null) {
                i4 = (byte) (((byte) (lookAheadTest[i3 + ((int) (PlaceComponentResult ^ 3097486228508854431L))] ^ 3097486228508854431L)) + ((int) (BuiltInFictitiousFunctionClassFactory ^ 3097486228508854431L)));
            } else {
                i4 = (short) (((short) (scheduleImpl[i3 + ((int) (PlaceComponentResult ^ 3097486228508854431L))] ^ 3097486228508854431L)) + ((int) (BuiltInFictitiousFunctionClassFactory ^ 3097486228508854431L)));
            }
        }
        if (i4 > 0) {
            b2.getAuthRequestContext = ((i3 + i4) - 2) + ((int) (PlaceComponentResult ^ 3097486228508854431L)) + i5;
            b2.MyBillsEntityDataFactory = (char) (i + ((int) (KClassImpl$Data$declaredNonStaticMembers$2 ^ 3097486228508854431L)));
            sb.append(b2.MyBillsEntityDataFactory);
            b2.PlaceComponentResult = b2.MyBillsEntityDataFactory;
            byte[] bArr3 = lookAheadTest;
            if (bArr3 != null) {
                int length2 = bArr3.length;
                byte[] bArr4 = new byte[length2];
                for (int i7 = 0; i7 < length2; i7++) {
                    bArr4[i7] = (byte) (bArr3[i7] ^ 3097486228508854431L);
                }
                bArr3 = bArr4;
            }
            boolean z = bArr3 != null;
            b2.KClassImpl$Data$declaredNonStaticMembers$2 = 1;
            while (b2.KClassImpl$Data$declaredNonStaticMembers$2 < i4) {
                if (z) {
                    byte[] bArr5 = lookAheadTest;
                    b2.getAuthRequestContext = b2.getAuthRequestContext - 1;
                    b2.MyBillsEntityDataFactory = (char) (b2.PlaceComponentResult + (((byte) (((byte) (bArr5[r9] ^ 3097486228508854431L)) + s)) ^ b));
                } else {
                    short[] sArr = scheduleImpl;
                    b2.getAuthRequestContext = b2.getAuthRequestContext - 1;
                    b2.MyBillsEntityDataFactory = (char) (b2.PlaceComponentResult + (((short) (((short) (sArr[r9] ^ 3097486228508854431L)) + s)) ^ b));
                }
                sb.append(b2.MyBillsEntityDataFactory);
                b2.PlaceComponentResult = b2.MyBillsEntityDataFactory;
                b2.KClassImpl$Data$declaredNonStaticMembers$2++;
            }
        }
        objArr[0] = sb.toString();
    }
}
