package id.dana.danapoly.ui.board;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ApplicationInfo;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.ImageFormat;
import android.graphics.PointF;
import android.media.AudioTrack;
import android.media.MediaPlayer;
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
import androidx.viewbinding.ViewBinding;
import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.alibaba.fastjson.parser.JSONLexer;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.common.base.Ascii;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.google.zxing.pdf417.PDF417Common;
import id.dana.R;
import id.dana.cashier.view.InputCardNumberView;
import id.dana.core.ui.BaseViewBindingActivity;
import id.dana.danapoly.ui.sound.DanapolyAudioModel;
import id.dana.danapoly.ui.sound.DanapolyAudioPlayer;
import id.dana.danapoly.ui.sound.DanapolyAudioService;
import id.dana.danapoly.ui.sound.DanapolyAudioServiceHelper;
import id.dana.onboarding.splash.LauncherActivity;
import id.dana.utils.broadcastreceiver.AudioPlayerReceiver;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Typography;
import o.SummaryVoucherView$$ExternalSyntheticLambda0;
import o.getCallingPid;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0011\b&\u0018\u0000  *\b\b\u0000\u0010\u0002*\u00020\u00012\b\u0012\u0004\u0012\u00028\u00000\u0003:\u0002 !B\u0007¢\u0006\u0004\b\u001f\u0010\u0006J\u000f\u0010\u0005\u001a\u00020\u0004H\u0014¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H\u0014¢\u0006\u0004\b\u0007\u0010\u0006J\u0015\u0010\n\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000bJ\r\u0010\f\u001a\u00020\u0004¢\u0006\u0004\b\f\u0010\u0006R\u0013\u0010\u000e\u001a\u00020\rX\u0082\u0080\u0002¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\"\u0010\u0013\u001a\u00020\u00108\u0017@\u0017X\u0096\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\"\u0010\u0018\u001a\u00020\u00108\u0017@\u0017X\u0097\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010\u0012\u001a\u0004\b\u0018\u0010\u0014\"\u0004\b\u0019\u0010\u0016R\u0016\u0010\u001b\u001a\u00020\u00108\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b\u001a\u0010\u0012R\u0018\u0010\u001e\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b\u001c\u0010\u001d"}, d2 = {"Lid/dana/danapoly/ui/board/BaseDanapolyAudioActivity;", "Landroidx/viewbinding/ViewBinding;", "VB", "Lid/dana/core/ui/BaseViewBindingActivity;", "", "onResume", "()V", "onStop", "Lid/dana/danapoly/ui/board/BaseDanapolyAudioActivity$RingerModeListener;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setRingerModeListener", "(Lid/dana/danapoly/ui/board/BaseDanapolyAudioActivity$RingerModeListener;)V", "startBackgroundMusic", "Lid/dana/utils/broadcastreceiver/AudioPlayerReceiver;", "PlaceComponentResult", "Lkotlin/Lazy;", "", "scheduleImpl", "Z", "isNeedStartMusicBackground", "()Z", "setNeedStartMusicBackground", "(Z)V", "getErrorConfigVersion", "isNeedStopMusicBackground", "setNeedStopMusicBackground", "lookAheadTest", "MyBillsEntityDataFactory", "initRecordTimeStamp", "Lid/dana/danapoly/ui/board/BaseDanapolyAudioActivity$RingerModeListener;", "getAuthRequestContext", "<init>", "Companion", "RingerModeListener"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public abstract class BaseDanapolyAudioActivity<VB extends ViewBinding> extends BaseViewBindingActivity<VB> {
    private static char DatabaseTableConfigUtil = 0;
    private static char[] NetworkUserEntityData$$ExternalSyntheticLambda2 = null;
    public static final String TAG = "Danapoly Audio Player";

    /* renamed from: initRecordTimeStamp  reason: from kotlin metadata */
    private RingerModeListener getAuthRequestContext;

    /* renamed from: lookAheadTest  reason: from kotlin metadata */
    private boolean MyBillsEntityDataFactory;

    /* renamed from: scheduleImpl  reason: from kotlin metadata */
    private boolean isNeedStartMusicBackground;
    public static final byte[] $$a = {116, -27, -60, 115, TarHeader.LF_CHR, -48, 46, 10, 7, 14, -39, TarHeader.LF_NORMAL, 13, -4, 18, 12, -46, 36, Ascii.SUB, -12, -20, 34, 9, Ascii.CAN, 2, 10, 14, 5, 22, -44, 59, 6, -5, -15, Ascii.SUB, 19, 11, -9, Ascii.NAK, 8, -42, TarHeader.LF_CHR, 6, 13, -8, Ascii.SUB, 3, -1, TarHeader.LF_NORMAL, -4, Ascii.EM, 7, -35, 43, 10, 3, -65, 39, 36, Ascii.SUB, -12, -54, 71, 8, 5, 16, -4, Ascii.CAN, -6, 6, -15, 40, 6, -20, 40, -12, Ascii.SUB, -4, 1, -15, Ascii.US, 15, -4, 10, Ascii.DC4, 8, -72, Ascii.NAK};
    public static final int $$b = 203;
    public static final byte[] getAuthRequestContext = {95, 85, -94, TarHeader.LF_SYMLINK, 17, -6, 18, 1, -2, -1, -50, 57, 16, 3, 10, -11, 13, 10, -66, Ascii.EM, TarHeader.LF_NORMAL, 3, 10, -11, Ascii.ETB, 0, -1, 5, 13, 10, -7, 15, 9, -45, Ascii.GS, 22, -7, -33, TarHeader.LF_NORMAL, -7, 5, -5, Ascii.EM, -17, -47, 66, -7, 17, -3, -53, 41, 42, -2, 5, -11, 12, 2, 19, -47, TarHeader.LF_CHR, 4, 0, 1, -2, 2, Ascii.ETB, -7, 10, 3, -33, 41, -4, 13};
    public static final int KClassImpl$Data$declaredNonStaticMembers$2 = 22;

    /* renamed from: getErrorConfigVersion  reason: from kotlin metadata */
    private boolean isNeedStopMusicBackground = true;
    private final Lazy PlaceComponentResult = LazyKt.lazy(new Function0<AudioPlayerReceiver>() { // from class: id.dana.danapoly.ui.board.BaseDanapolyAudioActivity$audioPlayerReceiver$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final AudioPlayerReceiver invoke() {
            return new AudioPlayerReceiver();
        }
    });

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0004ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/danapoly/ui/board/BaseDanapolyAudioActivity$RingerModeListener;", "", "", "getAuthRequestContext", "()V", "KClassImpl$Data$declaredNonStaticMembers$2"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public interface RingerModeListener {
        void KClassImpl$Data$declaredNonStaticMembers$2();

        void getAuthRequestContext();
    }

    static {
        KClassImpl$Data$declaredNonStaticMembers$2();
        INSTANCE = new Companion(null);
    }

    static void KClassImpl$Data$declaredNonStaticMembers$2() {
        DatabaseTableConfigUtil = (char) 42066;
        NetworkUserEntityData$$ExternalSyntheticLambda2 = new char[]{37280, 37373, 37344, 37461, 37370, 37302, 37310, 37293, 37345, 37274, 37367, 37460, 37282, 37456, 37463, 37275, 37306, 37469, 37375, 37369, 37288, 37289, 37372, 37291, 37457, 37279, 37287, 37468, 37262, 37286, 37305, 37368, 37307, 37292, 37308, 37371, 37365, 37295, 37309, 37281, 37283, 37290, 37462, 37294, 37366, 37459, 37374, 37458, 37311};
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0026  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x001e  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0026 -> B:11:0x002f). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void a(short r7, int r8, short r9, java.lang.Object[] r10) {
        /*
            int r7 = 55 - r7
            int r9 = r9 + 97
            byte[] r0 = id.dana.danapoly.ui.board.BaseDanapolyAudioActivity.getAuthRequestContext
            int r8 = r8 + 16
            byte[] r1 = new byte[r8]
            r2 = 0
            if (r0 != 0) goto L14
            r3 = r1
            r5 = 0
            r1 = r0
            r0 = r10
            r10 = r9
            r9 = r8
            goto L2f
        L14:
            r3 = 0
        L15:
            int r7 = r7 + 1
            byte r4 = (byte) r9
            int r5 = r3 + 1
            r1[r3] = r4
            if (r5 != r8) goto L26
            java.lang.String r7 = new java.lang.String
            r7.<init>(r1, r2)
            r10[r2] = r7
            return
        L26:
            r3 = r0[r7]
            r6 = r9
            r9 = r8
            r8 = r3
            r3 = r1
            r1 = r0
            r0 = r10
            r10 = r6
        L2f:
            int r10 = r10 + r8
            int r8 = r10 + (-4)
            r10 = r0
            r0 = r1
            r1 = r3
            r3 = r5
            r6 = r9
            r9 = r8
            r8 = r6
            goto L15
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.danapoly.ui.board.BaseDanapolyAudioActivity.a(short, int, short, java.lang.Object[]):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0029  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0021  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0029 -> B:11:0x002e). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void c(byte r6, int r7, byte r8, java.lang.Object[] r9) {
        /*
            int r8 = r8 * 2
            int r8 = r8 + 75
            byte[] r0 = id.dana.danapoly.ui.board.BaseDanapolyAudioActivity.$$a
            int r6 = r6 * 3
            int r6 = r6 + 21
            int r7 = 46 - r7
            byte[] r1 = new byte[r6]
            int r6 = r6 + (-1)
            r2 = 0
            if (r0 != 0) goto L17
            r3 = r8
            r4 = 0
            r8 = r7
            goto L2e
        L17:
            r3 = 0
        L18:
            int r7 = r7 + 1
            byte r4 = (byte) r8
            r1[r3] = r4
            int r4 = r3 + 1
            if (r3 != r6) goto L29
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            r9[r2] = r6
            return
        L29:
            r3 = r0[r7]
            r5 = r8
            r8 = r7
            r7 = r5
        L2e:
            int r7 = r7 + r3
            int r7 = r7 + (-7)
            r3 = r4
            r5 = r8
            r8 = r7
            r7 = r5
            goto L18
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.danapoly.ui.board.BaseDanapolyAudioActivity.c(byte, int, byte, java.lang.Object[]):void");
    }

    @Override // id.dana.core.ui.BaseViewBindingActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper
    public void attachBaseContext(Context context) {
        Object[] objArr;
        Object[] objArr2;
        Object[] objArr3;
        Object[] objArr4;
        super.attachBaseContext(context);
        Object[] objArr5 = new Object[1];
        b((byte) (TextUtils.indexOf("", "", 0) + 60), new char[]{'.', Typography.dollar, 24, '%', 1, 28, 22, '\t', 6, 28, 11, 22, '#', 3, Typography.quote, '(', 13861, 13861}, 19 - (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)), objArr5);
        Class<?> cls = Class.forName((String) objArr5[0]);
        Object[] objArr6 = new Object[1];
        b((byte) (111 - Color.alpha(0)), new char[]{19, '\f', '\b', 30, 13933}, 5 - View.getDefaultSize(0, 0), objArr6);
        int intValue = ((Integer) cls.getDeclaredMethod((String) objArr6[0], new Class[0]).invoke(null, new Object[0])).intValue() % 100000;
        if (intValue < 99000 || intValue > 99999) {
            Context applicationContext = context != null ? context.getApplicationContext() : context;
            if (applicationContext != null) {
                try {
                    Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                    if (obj == null) {
                        obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)), 35 - (ViewConfiguration.getWindowTouchSlop() >> 8), (char) (ViewConfiguration.getFadingEdgeLength() >> 16))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                    }
                    Object invoke = ((Method) obj).invoke(null, null);
                    Object[] objArr7 = new Object[1];
                    b((byte) (TextUtils.indexOf((CharSequence) "", '0', 0) + 11), new char[]{InputCardNumberView.DIVIDER, Typography.quote, 17, '\f', 16, 25, '-', '\t', Typography.quote, Typography.amp, 28, JSONLexer.EOI, Typography.dollar, 6, '/', 18, 13749, 13749, 15, '/', JSONLexer.EOI, 30, '(', JSONLexer.EOI, 24, 23, '\t', 24, 2, 22, '0', Typography.dollar, '/', 16, 2, '+', 23, '*', 11, 17, 28, 24, '(', 14, '\b', 21, 20, '('}, 48 - Color.green(0), objArr7);
                    String str = (String) objArr7[0];
                    Object[] objArr8 = new Object[1];
                    b((byte) ((SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)) + 86), new char[]{'.', 1, 16, JSONLexer.EOI, 23, '*', 17, 11, JSONLexer.EOI, 30, '.', 2, 25, ',', '*', '\'', 13823, 13823, 25, '*', 25, ',', 15, JSONLexer.EOI, 14, '\f', '0', '%', '\t', 24, 13823, 13823, 30, JSONLexer.EOI, Typography.amp, 7, 13904, 13904, 15, 25, 11, 25, '\'', '0', Typography.quote, InputCardNumberView.DIVIDER, '-', InputCardNumberView.DIVIDER, 13824, 13824, 30, '-', '-', 30, 25, 4, 25, 4, 28, '\f', '-', 11, 24, 23}, 64 - ((Process.getThreadPriority(0) + 20) >> 6), objArr8);
                    String str2 = (String) objArr8[0];
                    Object[] objArr9 = new Object[1];
                    b((byte) (108 - (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1))), new char[]{4, '+', '#', '\r', '-', 30, 0, Typography.dollar, 13837, 13837, 11, '-', '+', 25, 17, InputCardNumberView.DIVIDER, '0', Typography.dollar, '%', 21, 0, '\b', 1, 29, 28, 24, '-', '\t', 13927, 13927, InputCardNumberView.DIVIDER, Typography.quote, 30, 24, 3, '\b', '\n', 28, 17, '\f', 7, 24, '*', '\'', 11, 17, '*', '\b', 23, '*', Typography.quote, '(', 4, '+', 25, 0, InputCardNumberView.DIVIDER, 3, '/', 16, 25, 0, 2, '.'}, (ViewConfiguration.getKeyRepeatTimeout() >> 16) + 64, objArr9);
                    String str3 = (String) objArr9[0];
                    Object[] objArr10 = new Object[1];
                    b((byte) (Color.argb(0, 0, 0, 0) + 41), new char[]{25, '!', Typography.quote, '.', 29, ')', 13790, 13790, 22, ',', Typography.dollar, '.', 11, 29, 24, '(', Typography.dollar, '0', '!', Typography.quote, '0', 29, 29, 11, 14, 17, '-', Typography.dollar, 27, 30, 2, 20, '-', Typography.dollar, Typography.dollar, '\r', 28, 5, '\t', 5, ',', '*', 30, 1, InputCardNumberView.DIVIDER, Typography.dollar, 27, '0', 28, '!', '\t', '%', 2, 3, '%', Typography.quote, '#', '(', '!', 28}, 61 - (Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1)), objArr10);
                    String str4 = (String) objArr10[0];
                    Object[] objArr11 = new Object[1];
                    b((byte) (75 - Color.alpha(0)), new char[]{'+', '\t', Typography.dollar, 7, 4, '+'}, (ViewConfiguration.getWindowTouchSlop() >> 8) + 6, objArr11);
                    try {
                        Object[] objArr12 = {applicationContext, str, str2, str3, str4, true, (String) objArr11[0], 995651014};
                        Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-1276397751);
                        if (obj2 == null) {
                            obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(910 - TextUtils.indexOf((CharSequence) "", '0'), 18 - ExpandableListView.getPackedPositionGroup(0L), (char) (ViewConfiguration.getEdgeSlop() >> 16))).getMethod("getAuthRequestContext", Context.class, String.class, String.class, String.class, String.class, Boolean.TYPE, String.class, Integer.TYPE);
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
                a(getAuthRequestContext[31], getAuthRequestContext[25], getAuthRequestContext[32], objArr13);
                Class<?> cls2 = Class.forName((String) objArr13[0]);
                byte b = (byte) (KClassImpl$Data$declaredNonStaticMembers$2 | 8);
                byte b2 = getAuthRequestContext[25];
                Object[] objArr14 = new Object[1];
                a(b, b2, (byte) (b2 | 8), objArr14);
                try {
                    Object[] objArr15 = {applicationContext2, Integer.valueOf(((Integer) cls2.getMethod((String) objArr14[0], Object.class).invoke(null, this)).intValue())};
                    Object obj3 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1691739267);
                    if (obj3 == null) {
                        Class cls3 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(ExpandableListView.getPackedPositionType(0L) + 55, Color.green(0) + 3, (char) ((AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)) - 1));
                        Object[] objArr16 = new Object[1];
                        c($$a[78], $$a[53], $$a[78], objArr16);
                        obj3 = cls3.getMethod((String) objArr16[0], Context.class, Integer.TYPE);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1691739267, obj3);
                    }
                    Object invoke2 = ((Method) obj3).invoke(null, objArr15);
                    try {
                        Object obj4 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(40157535);
                        if (obj4 == null) {
                            obj4 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(View.MeasureSpec.getSize(0) + 800, (SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)) + 14, (char) (Process.myTid() >> 22))).getMethod("getAuthRequestContext", null);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(40157535, obj4);
                        }
                        int intValue2 = ((Integer) ((Method) obj4).invoke(invoke2, null)).intValue();
                        try {
                            Object obj5 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1621779126);
                            if (obj5 == null) {
                                obj5 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(800 - (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)), View.getDefaultSize(0, 0) + 15, (char) (ViewConfiguration.getDoubleTapTimeout() >> 16))).getMethod("PlaceComponentResult", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1621779126, obj5);
                            }
                            if (((Integer) ((Method) obj5).invoke(invoke2, null)).intValue() != intValue2) {
                                ArrayList arrayList = new ArrayList();
                                try {
                                    Object[] objArr17 = {invoke2};
                                    Object obj6 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(658700871);
                                    if (obj6 == null) {
                                        obj6 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(TextUtils.indexOf("", "") + 815, View.MeasureSpec.getMode(0) + 29, (char) (57994 - TextUtils.indexOf("", "", 0)))).getMethod("getAuthRequestContext", (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(Color.rgb(0, 0, 0) + 16778016, Color.rgb(0, 0, 0) + 16777231, (char) (ViewConfiguration.getMaximumFlingVelocity() >> 16)));
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
                                            obj7 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(930 - (SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)), 35 - (Process.myPid() >> 22), (char) (ViewConfiguration.getMaximumDrawingCacheSize() >> 24))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj7);
                                        }
                                        Object invoke3 = ((Method) obj7).invoke(objArr, objArr);
                                        try {
                                            Object[] objArr18 = {-1217676830, Long.valueOf(j), arrayList, LauncherActivity.getAuid()};
                                            Object obj8 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                            if (obj8 == null) {
                                                obj8 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(910 - (ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)), 18 - Gravity.getAbsoluteGravity(0, 0), (char) (AndroidCharacter.getMirror('0') - '0'))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                a(getAuthRequestContext[31], getAuthRequestContext[25], getAuthRequestContext[32], objArr19);
                Class<?> cls4 = Class.forName((String) objArr19[0]);
                byte b3 = (byte) (KClassImpl$Data$declaredNonStaticMembers$2 | 8);
                byte b4 = getAuthRequestContext[25];
                Object[] objArr20 = new Object[1];
                a(b3, b4, (byte) (b4 | 8), objArr20);
                try {
                    Object[] objArr21 = {applicationContext3, Integer.valueOf(((Integer) cls4.getMethod((String) objArr20[0], Object.class).invoke(null, this)).intValue())};
                    Object obj9 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(345757441);
                    if (obj9 == null) {
                        Class cls5 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(61 - ExpandableListView.getPackedPositionGroup(0L), 46 - (ViewConfiguration.getTapTimeout() >> 16), (char) (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)));
                        Object[] objArr22 = new Object[1];
                        c((byte) ($$a[78] - 1), $$a[84], $$a[9], objArr22);
                        obj9 = cls5.getMethod((String) objArr22[0], Context.class, Integer.TYPE);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(345757441, obj9);
                    }
                    Object[] objArr23 = (Object[]) ((Method) obj9).invoke(null, objArr21);
                    int i = ((int[]) objArr23[1])[0];
                    if (((int[]) objArr23[0])[0] != i) {
                        long j2 = ((r3 ^ i) & 4294967295L) | 17179869184L;
                        try {
                            Object obj10 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                            if (obj10 != null) {
                                objArr2 = null;
                            } else {
                                objArr2 = null;
                                obj10 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1)) + PDF417Common.MAX_CODEWORDS_IN_BARCODE, (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)) + 35, (char) ((Process.getThreadPriority(0) + 20) >> 6))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj10);
                            }
                            Object invoke4 = ((Method) obj10).invoke(objArr2, objArr2);
                            try {
                                Object[] objArr24 = {-1217676830, Long.valueOf(j2), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj11 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj11 == null) {
                                    obj11 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(Color.green(0) + 911, (SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)) + 17, (char) TextUtils.getTrimmedLength(""))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                a(getAuthRequestContext[31], getAuthRequestContext[25], getAuthRequestContext[32], objArr25);
                Class<?> cls6 = Class.forName((String) objArr25[0]);
                byte b5 = (byte) (KClassImpl$Data$declaredNonStaticMembers$2 | 8);
                byte b6 = getAuthRequestContext[25];
                Object[] objArr26 = new Object[1];
                a(b5, b6, (byte) (b6 | 8), objArr26);
                try {
                    Object[] objArr27 = {applicationContext4, Integer.valueOf(((Integer) cls6.getMethod((String) objArr26[0], Object.class).invoke(null, this)).intValue())};
                    Object obj12 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-697999596);
                    if (obj12 == null) {
                        Class cls7 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(TextUtils.indexOf((CharSequence) "", '0', 0) + 119, 2 - ImageFormat.getBitsPerPixel(0), (char) (ExpandableListView.getPackedPositionGroup(0L) + 38968));
                        Object[] objArr28 = new Object[1];
                        c((byte) ($$a[78] - 1), $$a[84], $$a[9], objArr28);
                        obj12 = cls7.getMethod((String) objArr28[0], Context.class, Integer.TYPE);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(-697999596, obj12);
                    }
                    Object[] objArr29 = (Object[]) ((Method) obj12).invoke(null, objArr27);
                    int i2 = ((int[]) objArr29[1])[0];
                    if (((int[]) objArr29[0])[0] != i2) {
                        long j3 = ((r3 ^ i2) & 4294967295L) | 8589934592L;
                        try {
                            Object obj13 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                            if (obj13 != null) {
                                objArr3 = null;
                            } else {
                                objArr3 = null;
                                obj13 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1)) + PDF417Common.MAX_CODEWORDS_IN_BARCODE, ExpandableListView.getPackedPositionType(0L) + 35, (char) (ViewConfiguration.getMaximumDrawingCacheSize() >> 24))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj13);
                            }
                            Object invoke5 = ((Method) obj13).invoke(objArr3, objArr3);
                            try {
                                Object[] objArr30 = {-1217676830, Long.valueOf(j3), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj14 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj14 == null) {
                                    obj14 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(TextUtils.indexOf((CharSequence) "", '0', 0) + 912, View.getDefaultSize(0, 0) + 18, (char) (((byte) KeyEvent.getModifierMetaStateMask()) + 1))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                a(getAuthRequestContext[31], getAuthRequestContext[25], getAuthRequestContext[32], objArr31);
                Class<?> cls8 = Class.forName((String) objArr31[0]);
                byte b7 = (byte) (KClassImpl$Data$declaredNonStaticMembers$2 | 8);
                byte b8 = getAuthRequestContext[25];
                Object[] objArr32 = new Object[1];
                a(b7, b8, (byte) (b8 | 8), objArr32);
                try {
                    Object[] objArr33 = {applicationContext5, Integer.valueOf(((Integer) cls8.getMethod((String) objArr32[0], Object.class).invoke(null, this)).intValue())};
                    Object obj15 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-16683571);
                    if (obj15 == null) {
                        Class cls9 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(107 - ExpandableListView.getPackedPositionType(0L), (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)) + 3, (char) (TextUtils.lastIndexOf("", '0', 0, 0) + 1));
                        byte b9 = $$a[8];
                        byte b10 = (byte) ($$a[78] - 1);
                        Object[] objArr34 = new Object[1];
                        c(b9, b10, b10, objArr34);
                        obj15 = cls9.getMethod((String) objArr34[0], Context.class, Integer.TYPE);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(-16683571, obj15);
                    }
                    Object[] objArr35 = (Object[]) ((Method) obj15).invoke(null, objArr33);
                    int i3 = ((int[]) objArr35[1])[0];
                    if (((int[]) objArr35[0])[0] != i3) {
                        long j4 = ((r3 ^ i3) & 4294967295L) | 4294967296L;
                        try {
                            Object obj16 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                            if (obj16 != null) {
                                objArr4 = null;
                            } else {
                                objArr4 = null;
                                obj16 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - TextUtils.indexOf("", "", 0), 35 - (ViewConfiguration.getWindowTouchSlop() >> 8), (char) KeyEvent.getDeadChar(0, 0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj16);
                            }
                            Object invoke6 = ((Method) obj16).invoke(objArr4, objArr4);
                            try {
                                Object[] objArr36 = {-1217676830, Long.valueOf(j4), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj17 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj17 == null) {
                                    obj17 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(910 - (ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)), 18 - ExpandableListView.getPackedPositionGroup(0L), (char) TextUtils.getCapsMode("", 0, 0))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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

    @Override // id.dana.core.ui.BaseViewBindingActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.content.ContextWrapper, android.content.Context
    public Context getApplicationContext() {
        return super.getApplicationContext();
    }

    @Override // id.dana.core.ui.BaseViewBindingActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.content.ContextWrapper
    public Context getBaseContext() {
        return super.getBaseContext();
    }

    @Override // id.dana.core.ui.BaseViewBindingActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public Resources getResources() {
        return super.getResources();
    }

    @Override // id.dana.core.ui.BaseViewBindingActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Object[] objArr;
        Object[] objArr2 = new Object[1];
        b((byte) (60 - (ViewConfiguration.getLongPressTimeout() >> 16)), new char[]{'.', Typography.dollar, 24, '%', 1, 28, 22, '\t', 6, 28, 11, 22, '#', 3, Typography.quote, '(', 13861, 13861}, super.getResources().getString(R.string.text_family_account_balance).substring(1, 2).length() + 17, objArr2);
        Class<?> cls = Class.forName((String) objArr2[0]);
        Object[] objArr3 = new Object[1];
        b((byte) (super.getResources().getString(R.string.phone_number_invalid).substring(1, 2).codePointAt(0) + 0), new char[]{19, '\f', '\b', 30, 13933}, super.getResources().getString(R.string.split_bill_qr_desc_title).substring(14, 15).codePointAt(0) - 27, objArr3);
        int intValue = ((Integer) cls.getDeclaredMethod((String) objArr3[0], new Class[0]).invoke(null, new Object[0])).intValue() % 100000;
        if (intValue < 99000 || intValue > 99999) {
            Context baseContext = getBaseContext();
            if (baseContext == null) {
                Object[] objArr4 = new Object[1];
                b((byte) TextUtils.getCapsMode("", 0, 0), new char[]{'.', Typography.dollar, 24, '%', 1, 28, 22, '\t', ',', '*', '+', '\r', 29, Typography.quote, '!', 30, 31, 30, '!', 4, 19, 22, '\'', '#', ',', 22}, 26 - Color.blue(0), objArr4);
                Class<?> cls2 = Class.forName((String) objArr4[0]);
                Object[] objArr5 = new Object[1];
                b((byte) (125 - ((Process.getThreadPriority(0) + 20) >> 6)), new char[]{30, 19, 13925, 13925, '#', '(', '!', 29, 13927, 13927, Typography.dollar, '!', 29, '/', '!', 30, 4, '#'}, getPackageName().codePointAt(4) - 79, objArr5);
                baseContext = (Context) cls2.getMethod((String) objArr5[0], new Class[0]).invoke(null, null);
            }
            if (baseContext != null) {
                baseContext = baseContext.getApplicationContext();
            }
            if (baseContext != null) {
                try {
                    Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                    if (obj == null) {
                        obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - (ViewConfiguration.getJumpTapTimeout() >> 16), (ViewConfiguration.getScrollDefaultDelay() >> 16) + 35, (char) TextUtils.indexOf("", "", 0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                    }
                    Object invoke = ((Method) obj).invoke(null, null);
                    try {
                        Object[] objArr6 = new Object[1];
                        a((byte) (getAuthRequestContext[59] + 1), (byte) (-getAuthRequestContext[30]), getAuthRequestContext[25], objArr6);
                        Class<?> cls3 = Class.forName((String) objArr6[0]);
                        a(getAuthRequestContext[25], getAuthRequestContext[56], (byte) (-getAuthRequestContext[5]), new Object[1]);
                        Object[] objArr7 = new Object[1];
                        b((byte) (((ApplicationInfo) cls3.getMethod((String) r15[0], null).invoke(this, null)).targetSdkVersion - 23), new char[]{InputCardNumberView.DIVIDER, Typography.quote, 17, '\f', 16, 25, '-', '\t', Typography.quote, Typography.amp, 28, JSONLexer.EOI, Typography.dollar, 6, '/', 18, 13749, 13749, 15, '/', JSONLexer.EOI, 30, '(', JSONLexer.EOI, 24, 23, '\t', 24, 2, 22, '0', Typography.dollar, '/', 16, 2, '+', 23, '*', 11, 17, 28, 24, '(', 14, '\b', 21, 20, '('}, super.getResources().getString(R.string.saving_electronics).substring(4, 9).length() + 43, objArr7);
                        String str = (String) objArr7[0];
                        Object[] objArr8 = new Object[1];
                        b((byte) (super.getResources().getString(R.string.res_0x7f1310bf_verifypinstatemanager_executeriskchallenge_2_1).substring(1, 5).codePointAt(1) - 13), new char[]{'.', 1, 16, JSONLexer.EOI, 23, '*', 17, 11, JSONLexer.EOI, 30, '.', 2, 25, ',', '*', '\'', 13823, 13823, 25, '*', 25, ',', 15, JSONLexer.EOI, 14, '\f', '0', '%', '\t', 24, 13823, 13823, 30, JSONLexer.EOI, Typography.amp, 7, 13904, 13904, 15, 25, 11, 25, '\'', '0', Typography.quote, InputCardNumberView.DIVIDER, '-', InputCardNumberView.DIVIDER, 13824, 13824, 30, '-', '-', 30, 25, 4, 25, 4, 28, '\f', '-', 11, 24, 23}, getPackageName().length() + 57, objArr8);
                        String str2 = (String) objArr8[0];
                        Object[] objArr9 = new Object[1];
                        b((byte) (super.getResources().getString(R.string.twilio_ipg_deny_message).substring(4, 10).codePointAt(0) + 75), new char[]{4, '+', '#', '\r', '-', 30, 0, Typography.dollar, 13837, 13837, 11, '-', '+', 25, 17, InputCardNumberView.DIVIDER, '0', Typography.dollar, '%', 21, 0, '\b', 1, 29, 28, 24, '-', '\t', 13927, 13927, InputCardNumberView.DIVIDER, Typography.quote, 30, 24, 3, '\b', '\n', 28, 17, '\f', 7, 24, '*', '\'', 11, 17, '*', '\b', 23, '*', Typography.quote, '(', 4, '+', 25, 0, InputCardNumberView.DIVIDER, 3, '/', 16, 25, 0, 2, '.'}, super.getResources().getString(R.string.gn_description).substring(0, 21).codePointAt(8) - 35, objArr9);
                        String str3 = (String) objArr9[0];
                        try {
                            Object[] objArr10 = new Object[1];
                            a((byte) (getAuthRequestContext[59] + 1), (byte) (-getAuthRequestContext[30]), getAuthRequestContext[25], objArr10);
                            Class<?> cls4 = Class.forName((String) objArr10[0]);
                            Object[] objArr11 = new Object[1];
                            a(getAuthRequestContext[25], getAuthRequestContext[56], (byte) (-getAuthRequestContext[5]), objArr11);
                            Object[] objArr12 = new Object[1];
                            b((byte) (((ApplicationInfo) cls4.getMethod((String) objArr11[0], null).invoke(this, null)).targetSdkVersion + 8), new char[]{25, '!', Typography.quote, '.', 29, ')', 13790, 13790, 22, ',', Typography.dollar, '.', 11, 29, 24, '(', Typography.dollar, '0', '!', Typography.quote, '0', 29, 29, 11, 14, 17, '-', Typography.dollar, 27, 30, 2, 20, '-', Typography.dollar, Typography.dollar, '\r', 28, 5, '\t', 5, ',', '*', 30, 1, InputCardNumberView.DIVIDER, Typography.dollar, 27, '0', 28, '!', '\t', '%', 2, 3, '%', Typography.quote, '#', '(', '!', 28}, 61 - (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)), objArr12);
                            String str4 = (String) objArr12[0];
                            Object[] objArr13 = new Object[1];
                            b((byte) (getPackageName().length() + 68), new char[]{'+', '\t', Typography.dollar, 7, 4, '+'}, 7 - (SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)), objArr13);
                            try {
                                Object[] objArr14 = {baseContext, str, str2, str3, str4, true, (String) objArr13[0], 995651014};
                                Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-1276397751);
                                if (obj2 == null) {
                                    obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)) + 910, 18 - (ViewConfiguration.getScrollDefaultDelay() >> 16), (char) (ViewConfiguration.getMaximumFlingVelocity() >> 16))).getMethod("getAuthRequestContext", Context.class, String.class, String.class, String.class, String.class, Boolean.TYPE, String.class, Integer.TYPE);
                                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(-1276397751, obj2);
                                }
                                ((Method) obj2).invoke(invoke, objArr14);
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
            Object[] objArr15 = new Object[1];
            a(getAuthRequestContext[31], getAuthRequestContext[25], getAuthRequestContext[32], objArr15);
            Class<?> cls5 = Class.forName((String) objArr15[0]);
            byte b = (byte) (KClassImpl$Data$declaredNonStaticMembers$2 | 8);
            byte b2 = getAuthRequestContext[25];
            Object[] objArr16 = new Object[1];
            a(b, b2, (byte) (b2 | 8), objArr16);
            try {
                Object[] objArr17 = {Integer.valueOf(((Integer) cls5.getMethod((String) objArr16[0], Object.class).invoke(null, this)).intValue())};
                Object obj3 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(25207140);
                if (obj3 == null) {
                    Class cls6 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(KeyEvent.keyCodeFromString("") + 494, TextUtils.lastIndexOf("", '0', 0) + 5, (char) ExpandableListView.getPackedPositionType(0L));
                    byte b3 = $$a[8];
                    byte b4 = (byte) ($$a[78] - 1);
                    Object[] objArr18 = new Object[1];
                    c(b3, b4, b4, objArr18);
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
                            obj4 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - ExpandableListView.getPackedPositionType(0L), (SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)) + 34, (char) (CdmaCellLocation.convertQuartSecToDecDegrees(0) > FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 0 : -1)))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj4);
                        }
                        Object invoke2 = ((Method) obj4).invoke(objArr, objArr);
                        try {
                            Object[] objArr20 = {1402716827, Long.valueOf(j), new ArrayList(), LauncherActivity.getAuid()};
                            Object obj5 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                            if (obj5 == null) {
                                obj5 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)), 18 - View.getDefaultSize(0, 0), (char) TextUtils.getOffsetBefore("", 0))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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

    @Override // id.dana.core.ui.BaseViewBindingActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onPause() {
        Context baseContext = getBaseContext();
        if (baseContext == null) {
            try {
                Object[] objArr = new Object[1];
                a((byte) (getAuthRequestContext[59] + 1), (byte) (-getAuthRequestContext[30]), getAuthRequestContext[25], objArr);
                Class<?> cls = Class.forName((String) objArr[0]);
                a(getAuthRequestContext[25], getAuthRequestContext[56], (byte) (-getAuthRequestContext[5]), new Object[1]);
                Object[] objArr2 = new Object[1];
                b((byte) (((ApplicationInfo) cls.getMethod((String) r10[0], null).invoke(this, null)).targetSdkVersion - 33), new char[]{'.', Typography.dollar, 24, '%', 1, 28, 22, '\t', ',', '*', '+', '\r', 29, Typography.quote, '!', 30, 31, 30, '!', 4, 19, 22, '\'', '#', ',', 22}, TextUtils.indexOf((CharSequence) "", '0') + 27, objArr2);
                Class<?> cls2 = Class.forName((String) objArr2[0]);
                Object[] objArr3 = new Object[1];
                b((byte) (125 - (CdmaCellLocation.convertQuartSecToDecDegrees(0) > FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 0 : -1))), new char[]{30, 19, 13925, 13925, '#', '(', '!', 29, 13927, 13927, Typography.dollar, '!', 29, '/', '!', 30, 4, '#'}, getPackageName().length() + 11, objArr3);
                baseContext = (Context) cls2.getMethod((String) objArr3[0], new Class[0]).invoke(null, null);
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
                    obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(TextUtils.getOffsetBefore("", 0) + PDF417Common.NUMBER_OF_CODEWORDS, TextUtils.lastIndexOf("", '0', 0) + 36, (char) View.resolveSize(0, 0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                }
                Object invoke = ((Method) obj).invoke(null, null);
                try {
                    Object[] objArr4 = {baseContext};
                    Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-549958681);
                    if (obj2 == null) {
                        obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(View.combineMeasuredStates(0, 0) + 911, 18 - (ViewConfiguration.getLongPressTimeout() >> 16), (char) (MotionEvent.axisFromString("") + 1))).getMethod("MyBillsEntityDataFactory", Context.class);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(-549958681, obj2);
                    }
                    ((Method) obj2).invoke(invoke, objArr4);
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

    @JvmName(name = "isNeedStopMusicBackground")
    /* renamed from: isNeedStopMusicBackground  reason: from getter */
    public boolean getIsNeedStopMusicBackground() {
        return this.isNeedStopMusicBackground;
    }

    @JvmName(name = "setNeedStopMusicBackground")
    public void setNeedStopMusicBackground(boolean z) {
        this.isNeedStopMusicBackground = z;
    }

    @JvmName(name = "isNeedStartMusicBackground")
    /* renamed from: isNeedStartMusicBackground  reason: from getter */
    public boolean getIsNeedStartMusicBackground() {
        return this.isNeedStartMusicBackground;
    }

    @JvmName(name = "setNeedStartMusicBackground")
    public void setNeedStartMusicBackground(boolean z) {
        this.isNeedStartMusicBackground = z;
    }

    @Override // id.dana.core.ui.BaseViewBindingActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onResume() {
        Context baseContext = getBaseContext();
        if (baseContext == null) {
            try {
                Object[] objArr = new Object[1];
                a((byte) (getAuthRequestContext[59] + 1), (byte) (-getAuthRequestContext[30]), getAuthRequestContext[25], objArr);
                Class<?> cls = Class.forName((String) objArr[0]);
                a(getAuthRequestContext[25], getAuthRequestContext[56], (byte) (-getAuthRequestContext[5]), new Object[1]);
                byte b = (byte) (((ApplicationInfo) cls.getMethod((String) r14[0], null).invoke(this, null)).targetSdkVersion - 33);
                char[] cArr = {'.', Typography.dollar, 24, '%', 1, 28, 22, '\t', ',', '*', '+', '\r', 29, Typography.quote, '!', 30, 31, 30, '!', 4, 19, 22, '\'', '#', ',', 22};
                try {
                    Object[] objArr2 = new Object[1];
                    a((byte) (getAuthRequestContext[59] + 1), (byte) (-getAuthRequestContext[30]), getAuthRequestContext[25], objArr2);
                    Class<?> cls2 = Class.forName((String) objArr2[0]);
                    a(getAuthRequestContext[25], getAuthRequestContext[56], (byte) (-getAuthRequestContext[5]), new Object[1]);
                    Object[] objArr3 = new Object[1];
                    b(b, cArr, ((ApplicationInfo) cls2.getMethod((String) r13[0], null).invoke(this, null)).targetSdkVersion - 7, objArr3);
                    Class<?> cls3 = Class.forName((String) objArr3[0]);
                    byte codePointAt = (byte) (super.getResources().getString(R.string.no_recentnumber).substring(9, 10).codePointAt(0) + 93);
                    char[] cArr2 = {30, 19, 13925, 13925, '#', '(', '!', 29, 13927, 13927, Typography.dollar, '!', 29, '/', '!', 30, 4, '#'};
                    try {
                        Object[] objArr4 = new Object[1];
                        a((byte) (getAuthRequestContext[59] + 1), (byte) (-getAuthRequestContext[30]), getAuthRequestContext[25], objArr4);
                        Class<?> cls4 = Class.forName((String) objArr4[0]);
                        a(getAuthRequestContext[25], getAuthRequestContext[56], (byte) (-getAuthRequestContext[5]), new Object[1]);
                        Object[] objArr5 = new Object[1];
                        b(codePointAt, cArr2, ((ApplicationInfo) cls4.getMethod((String) r12[0], null).invoke(this, null)).targetSdkVersion - 15, objArr5);
                        baseContext = (Context) cls3.getMethod((String) objArr5[0], new Class[0]).invoke(null, null);
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
                    obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - View.MeasureSpec.makeMeasureSpec(0, 0), (ViewConfiguration.getMinimumFlingVelocity() >> 16) + 35, (char) (ViewConfiguration.getWindowTouchSlop() >> 8))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                }
                Object invoke = ((Method) obj).invoke(null, null);
                try {
                    Object[] objArr6 = {baseContext};
                    Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(247288059);
                    if (obj2 == null) {
                        obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)) + 912, 18 - ExpandableListView.getPackedPositionGroup(0L), (char) Gravity.getAbsoluteGravity(0, 0))).getMethod("KClassImpl$Data$declaredNonStaticMembers$2", Context.class);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(247288059, obj2);
                    }
                    ((Method) obj2).invoke(invoke, objArr6);
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
        super.onResume();
        if (!this.MyBillsEntityDataFactory) {
            ((AudioPlayerReceiver) this.PlaceComponentResult.getValue()).setRingerModeListener(new AudioPlayerReceiver.AudioPlayerReceiverListener() { // from class: id.dana.danapoly.ui.board.BaseDanapolyAudioActivity$$ExternalSyntheticLambda0
                @Override // id.dana.utils.broadcastreceiver.AudioPlayerReceiver.AudioPlayerReceiverListener
                public final void getAuthRequestContext(int i) {
                    BaseDanapolyAudioActivity.$r8$lambda$ihxLvlVZMLIkzbCBepSlK9k5EAk(BaseDanapolyAudioActivity.this, i);
                }
            });
            registerReceiver((AudioPlayerReceiver) this.PlaceComponentResult.getValue(), new IntentFilter(AudioPlayerReceiver.RINGER_MODE_CHANGED));
            this.MyBillsEntityDataFactory = true;
        }
        setNeedStopMusicBackground(true);
        if (getIsNeedStartMusicBackground()) {
            startBackgroundMusic();
        }
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (getIsNeedStopMusicBackground()) {
            if (this.MyBillsEntityDataFactory) {
                unregisterReceiver((AudioPlayerReceiver) this.PlaceComponentResult.getValue());
                this.MyBillsEntityDataFactory = false;
            }
            DanapolyAudioServiceHelper danapolyAudioServiceHelper = DanapolyAudioServiceHelper.INSTANCE;
            Context applicationContext = getApplicationContext();
            Intrinsics.checkNotNullExpressionValue(applicationContext, "");
            Intrinsics.checkNotNullParameter(applicationContext, "");
            if (DanapolyAudioServiceHelper.getAuthRequestContext(applicationContext) && DanapolyAudioServiceHelper.KClassImpl$Data$declaredNonStaticMembers$2 && DanapolyAudioServiceHelper.PlaceComponentResult != null) {
                applicationContext.unbindService(DanapolyAudioServiceHelper.getAuthRequestContext);
                DanapolyAudioServiceHelper.KClassImpl$Data$declaredNonStaticMembers$2 = false;
            }
        }
    }

    public final void startBackgroundMusic() {
        DanapolyAudioServiceHelper danapolyAudioServiceHelper = DanapolyAudioServiceHelper.INSTANCE;
        Context applicationContext = getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext, "");
        Intrinsics.checkNotNullParameter(applicationContext, "");
        if (DanapolyAudioServiceHelper.getAuthRequestContext(applicationContext)) {
            return;
        }
        DanapolyAudioModel danapolyAudioModel = new DanapolyAudioModel(id.dana.danapoly.R.raw.MyBillsEntityDataFactory_res_0x7f120001, DanapolyAudioServiceHelper.MyBillsEntityDataFactory(applicationContext), true, null, null, 24, null);
        Intent intent = new Intent(applicationContext, DanapolyAudioService.class);
        intent.putExtra(DanapolyAudioService.BUNDLE_SOUND, danapolyAudioModel);
        if (applicationContext.bindService(intent, DanapolyAudioServiceHelper.getAuthRequestContext, 1)) {
            DanapolyAudioServiceHelper.KClassImpl$Data$declaredNonStaticMembers$2 = true;
        }
        DanapolyAudioServiceHelper.PlaceComponentResult = intent;
    }

    public final void setRingerModeListener(RingerModeListener listener) {
        Intrinsics.checkNotNullParameter(listener, "");
        this.getAuthRequestContext = listener;
    }

    public static /* synthetic */ void $r8$lambda$ihxLvlVZMLIkzbCBepSlK9k5EAk(BaseDanapolyAudioActivity baseDanapolyAudioActivity, int i) {
        DanapolyAudioService this$0;
        DanapolyAudioPlayer myBillsEntityDataFactory;
        MediaPlayer mediaPlayer;
        DanapolyAudioService this$02;
        DanapolyAudioPlayer myBillsEntityDataFactory2;
        MediaPlayer mediaPlayer2;
        Intrinsics.checkNotNullParameter(baseDanapolyAudioActivity, "");
        if (i == 2) {
            RingerModeListener ringerModeListener = baseDanapolyAudioActivity.getAuthRequestContext;
            if (ringerModeListener != null) {
                ringerModeListener.getAuthRequestContext();
            }
            DanapolyAudioServiceHelper danapolyAudioServiceHelper = DanapolyAudioServiceHelper.INSTANCE;
            DanapolyAudioService.DanapolyAudioServiceBinder BuiltInFictitiousFunctionClassFactory = DanapolyAudioServiceHelper.BuiltInFictitiousFunctionClassFactory();
            if (BuiltInFictitiousFunctionClassFactory == null || (this$02 = BuiltInFictitiousFunctionClassFactory.getThis$0()) == null || (myBillsEntityDataFactory2 = this$02.getMyBillsEntityDataFactory()) == null || (mediaPlayer2 = myBillsEntityDataFactory2.KClassImpl$Data$declaredNonStaticMembers$2) == null) {
                return;
            }
            mediaPlayer2.setVolume(1.0f, 1.0f);
            return;
        }
        RingerModeListener ringerModeListener2 = baseDanapolyAudioActivity.getAuthRequestContext;
        if (ringerModeListener2 != null) {
            ringerModeListener2.KClassImpl$Data$declaredNonStaticMembers$2();
        }
        DanapolyAudioServiceHelper danapolyAudioServiceHelper2 = DanapolyAudioServiceHelper.INSTANCE;
        DanapolyAudioService.DanapolyAudioServiceBinder BuiltInFictitiousFunctionClassFactory2 = DanapolyAudioServiceHelper.BuiltInFictitiousFunctionClassFactory();
        if (BuiltInFictitiousFunctionClassFactory2 == null || (this$0 = BuiltInFictitiousFunctionClassFactory2.getThis$0()) == null || (myBillsEntityDataFactory = this$0.getMyBillsEntityDataFactory()) == null || (mediaPlayer = myBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2) == null) {
            return;
        }
        mediaPlayer.setVolume(0.0f, 0.0f);
    }

    private static void b(byte b, char[] cArr, int i, Object[] objArr) {
        int i2;
        getCallingPid getcallingpid = new getCallingPid();
        char[] cArr2 = NetworkUserEntityData$$ExternalSyntheticLambda2;
        if (cArr2 != null) {
            int length = cArr2.length;
            char[] cArr3 = new char[length];
            for (int i3 = 0; i3 < length; i3++) {
                cArr3[i3] = (char) (cArr2[i3] ^ (-1549216646985767851L));
            }
            cArr2 = cArr3;
        }
        char c = (char) ((-1549216646985767851L) ^ DatabaseTableConfigUtil);
        char[] cArr4 = new char[i];
        if (i % 2 != 0) {
            i2 = i - 1;
            cArr4[i2] = (char) (cArr[i2] - b);
        } else {
            i2 = i;
        }
        if (i2 > 1) {
            getcallingpid.getAuthRequestContext = 0;
            while (getcallingpid.getAuthRequestContext < i2) {
                getcallingpid.MyBillsEntityDataFactory = cArr[getcallingpid.getAuthRequestContext];
                getcallingpid.PlaceComponentResult = cArr[getcallingpid.getAuthRequestContext + 1];
                if (getcallingpid.MyBillsEntityDataFactory == getcallingpid.PlaceComponentResult) {
                    cArr4[getcallingpid.getAuthRequestContext] = (char) (getcallingpid.MyBillsEntityDataFactory - b);
                    cArr4[getcallingpid.getAuthRequestContext + 1] = (char) (getcallingpid.PlaceComponentResult - b);
                } else {
                    getcallingpid.BuiltInFictitiousFunctionClassFactory = getcallingpid.MyBillsEntityDataFactory / c;
                    getcallingpid.scheduleImpl = getcallingpid.MyBillsEntityDataFactory % c;
                    getcallingpid.KClassImpl$Data$declaredNonStaticMembers$2 = getcallingpid.PlaceComponentResult / c;
                    getcallingpid.lookAheadTest = getcallingpid.PlaceComponentResult % c;
                    if (getcallingpid.scheduleImpl == getcallingpid.lookAheadTest) {
                        getcallingpid.BuiltInFictitiousFunctionClassFactory = ((getcallingpid.BuiltInFictitiousFunctionClassFactory + c) - 1) % c;
                        getcallingpid.KClassImpl$Data$declaredNonStaticMembers$2 = ((getcallingpid.KClassImpl$Data$declaredNonStaticMembers$2 + c) - 1) % c;
                        int i4 = (getcallingpid.BuiltInFictitiousFunctionClassFactory * c) + getcallingpid.scheduleImpl;
                        int i5 = (getcallingpid.KClassImpl$Data$declaredNonStaticMembers$2 * c) + getcallingpid.lookAheadTest;
                        cArr4[getcallingpid.getAuthRequestContext] = cArr2[i4];
                        cArr4[getcallingpid.getAuthRequestContext + 1] = cArr2[i5];
                    } else if (getcallingpid.BuiltInFictitiousFunctionClassFactory == getcallingpid.KClassImpl$Data$declaredNonStaticMembers$2) {
                        getcallingpid.scheduleImpl = ((getcallingpid.scheduleImpl + c) - 1) % c;
                        getcallingpid.lookAheadTest = ((getcallingpid.lookAheadTest + c) - 1) % c;
                        int i6 = (getcallingpid.BuiltInFictitiousFunctionClassFactory * c) + getcallingpid.scheduleImpl;
                        int i7 = (getcallingpid.KClassImpl$Data$declaredNonStaticMembers$2 * c) + getcallingpid.lookAheadTest;
                        cArr4[getcallingpid.getAuthRequestContext] = cArr2[i6];
                        cArr4[getcallingpid.getAuthRequestContext + 1] = cArr2[i7];
                    } else {
                        int i8 = (getcallingpid.BuiltInFictitiousFunctionClassFactory * c) + getcallingpid.lookAheadTest;
                        int i9 = (getcallingpid.KClassImpl$Data$declaredNonStaticMembers$2 * c) + getcallingpid.scheduleImpl;
                        cArr4[getcallingpid.getAuthRequestContext] = cArr2[i8];
                        cArr4[getcallingpid.getAuthRequestContext + 1] = cArr2[i9];
                    }
                }
                getcallingpid.getAuthRequestContext += 2;
            }
        }
        for (int i10 = 0; i10 < i; i10++) {
            cArr4[i10] = (char) (cArr4[i10] ^ 13722);
        }
        objArr[0] = new String(cArr4);
    }
}
