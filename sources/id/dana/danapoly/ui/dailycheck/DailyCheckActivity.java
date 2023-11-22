package id.dana.danapoly.ui.dailycheck;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.res.Resources;
import android.graphics.Color;
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
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ExpandableListView;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.Group;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.view.ComponentActivity;
import androidx.view.FlowExtKt;
import androidx.view.Lifecycle;
import androidx.view.LifecycleOwnerKt;
import androidx.view.OnBackPressedCallback;
import androidx.view.OnBackPressedDispatcher;
import androidx.view.OnBackPressedDispatcherKt;
import androidx.view.ViewModelKt;
import androidx.view.ViewModelLazy;
import androidx.view.ViewModelProvider;
import androidx.view.ViewModelStore;
import androidx.view.viewmodel.CreationExtras;
import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.alipay.iap.android.common.syncintegration.api.IAPSyncCommand;
import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.google.zxing.pdf417.PDF417Common;
import id.dana.R;
import id.dana.cashier.view.InputCardNumberView;
import id.dana.component.customtoastcomponent.CustomToast;
import id.dana.core.ui.di.module.ViewModelFactory;
import id.dana.danapoly.databinding.ActivityDailyCheckBinding;
import id.dana.danapoly.di.component.DanapolyComponent;
import id.dana.danapoly.di.provider.DanapolyComponentProvider;
import id.dana.danapoly.domain.dailycheck.model.CheckInInfo;
import id.dana.danapoly.ui.board.BaseDanapolyAudioActivity;
import id.dana.danapoly.ui.board.view.DanapolyPromptInfoView;
import id.dana.danapoly.ui.dailycheck.adapter.DailyCheckAdapter;
import id.dana.danapoly.ui.dailycheck.viewmodel.DailyCheckUiState;
import id.dana.danapoly.ui.dailycheck.viewmodel.DailyCheckViewModel;
import id.dana.danapoly.ui.model.mapper.CheckInMapperKt;
import id.dana.domain.core.usecase.BaseFlowUseCase;
import id.dana.domain.core.usecase.NoParams;
import id.dana.onboarding.splash.LauncherActivity;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.Typography;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import o.SummaryVoucherView$$ExternalSyntheticLambda0;
import o.getCallingPid;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 &2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001&B\u0007¢\u0006\u0004\b%\u0010\u0005J\u000f\u0010\u0004\u001a\u00020\u0003H\u0014¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0006\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\b\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\b\u0010\u0005J\u000f\u0010\t\u001a\u00020\u0003H\u0014¢\u0006\u0004\b\t\u0010\u0005J\u000f\u0010\n\u001a\u00020\u0003H\u0014¢\u0006\u0004\b\n\u0010\u0005J\u0017\u0010\r\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\r\u0010\u000eR\u0014\u0010\r\u001a\u00020\u000f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0015\u001a\u00020\u00128\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0019\u001a\u00020\u00168\u0002X\u0082\u0006¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0013\u0010\u001d\u001a\u00020\u001aX\u0082\u0080\u0002¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\"\u0010\u001f\u001a\u00020\u001e8\u0007@\u0007X\u0087.¢\u0006\u0012\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$"}, d2 = {"Lid/dana/danapoly/ui/dailycheck/DailyCheckActivity;", "Lid/dana/danapoly/ui/board/BaseDanapolyAudioActivity;", "Lid/dana/danapoly/databinding/ActivityDailyCheckBinding;", "", "configToolbar", "()V", "inflateViewBinding", "()Lid/dana/danapoly/databinding/ActivityDailyCheckBinding;", IAPSyncCommand.COMMAND_INIT, "initComponent", "onResume", "", "p0", "PlaceComponentResult", "(Z)V", "Lid/dana/danapoly/ui/dailycheck/adapter/DailyCheckAdapter;", "scheduleImpl", "Lid/dana/danapoly/ui/dailycheck/adapter/DailyCheckAdapter;", "Lid/dana/danapoly/di/component/DanapolyComponent;", "getErrorConfigVersion", "Lid/dana/danapoly/di/component/DanapolyComponent;", "BuiltInFictitiousFunctionClassFactory", "", "NetworkUserEntityData$$ExternalSyntheticLambda1", "I", "MyBillsEntityDataFactory", "Lid/dana/danapoly/ui/dailycheck/viewmodel/DailyCheckViewModel;", "GetContactSyncConfig", "Lkotlin/Lazy;", "KClassImpl$Data$declaredNonStaticMembers$2", "Lid/dana/core/ui/di/module/ViewModelFactory;", "viewModelFactory", "Lid/dana/core/ui/di/module/ViewModelFactory;", "getViewModelFactory", "()Lid/dana/core/ui/di/module/ViewModelFactory;", "setViewModelFactory", "(Lid/dana/core/ui/di/module/ViewModelFactory;)V", "<init>", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class DailyCheckActivity extends BaseDanapolyAudioActivity<ActivityDailyCheckBinding> {
    public static final String BUNDLE_SHOULD_REFRESH_CHECK_IN = "bundle_should_refresh_check_in";

    /* renamed from: Companion  reason: from kotlin metadata */
    public static final Companion INSTANCE;
    private static char[] DatabaseTableConfigUtil;
    private static char NetworkUserEntityData$$ExternalSyntheticLambda2;

    /* renamed from: GetContactSyncConfig  reason: from kotlin metadata */
    private final Lazy KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda1  reason: from kotlin metadata */
    private int MyBillsEntityDataFactory;

    /* renamed from: getErrorConfigVersion  reason: from kotlin metadata */
    private DanapolyComponent BuiltInFictitiousFunctionClassFactory;

    /* renamed from: scheduleImpl  reason: from kotlin metadata */
    private final DailyCheckAdapter PlaceComponentResult = new DailyCheckAdapter();
    @Inject
    public ViewModelFactory viewModelFactory;
    public static final byte[] $$g = {Ascii.GS, SignedBytes.MAX_POWER_OF_TWO, 35, 67, TarHeader.LF_CHR, -48, 46, 10, 7, 14, -39, TarHeader.LF_NORMAL, 13, -4, 18, 12, -46, 36, Ascii.SUB, -12, -20, 34, 9, Ascii.CAN, 2, 10, 14, 5, 22, -44, 59, 6, -5, -15, Ascii.SUB, 19, 11, -9, Ascii.NAK, 8, -42, TarHeader.LF_CHR, 6, 13, -8, Ascii.SUB, 3, -1, TarHeader.LF_NORMAL, -4, Ascii.EM, 7, -35, 43, 10, 3, -65, 39, 36, Ascii.SUB, -12, -54, 71, 8, 5, 16, -4, Ascii.CAN, -6, 6, -15, 40, 6, -20, 40, -12, Ascii.SUB, -4, 1, -15, Ascii.US, 15, -4, 10, Ascii.DC4, 8, -72, Ascii.NAK};
    public static final int $$h = 81;
    public static final byte[] PlaceComponentResult = {116, 44, -28, -115, 17, -6, 18, 1, -2, -1, -50, 57, 16, 3, 10, -11, 13, 10, -66, Ascii.EM, TarHeader.LF_NORMAL, 3, 10, -11, Ascii.ETB, 0, -1, 5, 13, 10, -7, 15, 9, -45, Ascii.GS, 22, -7, -33, TarHeader.LF_NORMAL, -7, 5, -5, Ascii.EM, -17, -47, 66, -7, 17, -3, -53, 41, 42, -2, 5, -11, 12, 2, 19, -47, TarHeader.LF_CHR, 4, 0, 1, -2, 2, Ascii.ETB, -7, 10, 3, -33, 41, -4, 13};
    public static final int lookAheadTest = 156;

    static {
        MyBillsEntityDataFactory();
        INSTANCE = new Companion(null);
    }

    static void MyBillsEntityDataFactory() {
        NetworkUserEntityData$$ExternalSyntheticLambda2 = (char) 42066;
        DatabaseTableConfigUtil = new char[]{37344, 37292, 37286, 37287, 37352, 37307, 37262, 37309, 37291, 37375, 37281, 37345, 37280, 37306, 37366, 37289, 37368, 37310, 37269, 37274, 37302, 37275, 37293, 37355, 37283, 37358, 37367, 37354, 37371, 37365, 37356, 37372, 37369, 37288, 37359, 37373, 37346, 37347, 37290, 37353, 37311, 37294, 37305, 37374, 37357, 37282, 37279, 37370, 37308};
    }

    private static void h(int i, short s, byte b, Object[] objArr) {
        int i2 = i + 97;
        int i3 = 56 - s;
        byte[] bArr = PlaceComponentResult;
        int i4 = b + 16;
        byte[] bArr2 = new byte[i4];
        int i5 = -1;
        int i6 = i4 - 1;
        if (bArr == null) {
            i3++;
            i2 = (i3 + i2) - 4;
            i6 = i6;
            objArr = objArr;
            bArr = bArr;
            bArr2 = bArr2;
            i5 = -1;
        }
        while (true) {
            int i7 = i5 + 1;
            bArr2[i7] = (byte) i2;
            if (i7 == i6) {
                objArr[0] = new String(bArr2, 0);
                return;
            }
            byte b2 = bArr[i3];
            i3++;
            i2 = (i2 + b2) - 4;
            i6 = i6;
            objArr = objArr;
            bArr = bArr;
            bArr2 = bArr2;
            i5 = i7;
        }
    }

    private static void j(byte b, int i, int i2, Object[] objArr) {
        int i3 = (b * 2) + 75;
        int i4 = i + 4;
        int i5 = 42 - (i2 * 3);
        byte[] bArr = $$g;
        byte[] bArr2 = new byte[i5];
        int i6 = -1;
        int i7 = i5 - 1;
        if (bArr == null) {
            int i8 = (i4 + i7) - 7;
            i7 = i7;
            objArr = objArr;
            bArr = bArr;
            bArr2 = bArr2;
            i6 = -1;
            i4 = i4;
            i3 = i8;
        }
        while (true) {
            int i9 = i4 + 1;
            int i10 = i6 + 1;
            bArr2[i10] = (byte) i3;
            if (i10 == i7) {
                objArr[0] = new String(bArr2, 0);
                return;
            }
            i7 = i7;
            objArr = objArr;
            bArr = bArr;
            bArr2 = bArr2;
            i6 = i10;
            i4 = i9;
            i3 = (i3 + bArr[i9]) - 7;
        }
    }

    @Override // id.dana.danapoly.ui.board.BaseDanapolyAudioActivity, id.dana.core.ui.BaseViewBindingActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper
    public final void attachBaseContext(Context context) {
        Object[] objArr;
        Object[] objArr2;
        Object[] objArr3;
        Object[] objArr4;
        super.attachBaseContext(context);
        Object[] objArr5 = new Object[1];
        g(new char[]{Typography.amp, '\r', '\t', '\b', '\t', 5, '\t', '\f', '\r', '/', 18, 4, '\b', '\r', 3, Typography.dollar, 13911, 13911}, AndroidCharacter.getMirror('0') - 30, (byte) (110 - ExpandableListView.getPackedPositionType(0L)), objArr5);
        Class<?> cls = Class.forName((String) objArr5[0]);
        Object[] objArr6 = new Object[1];
        g(new char[]{'0', 17, 16, 5, 13861}, (ViewConfiguration.getFadingEdgeLength() >> 16) + 5, (byte) (38 - TextUtils.lastIndexOf("", '0', 0)), objArr6);
        int intValue = ((Integer) cls.getDeclaredMethod((String) objArr6[0], new Class[0]).invoke(null, new Object[0])).intValue() % 100000;
        if (intValue < 99000 || intValue > 99999) {
            Context applicationContext = context != null ? context.getApplicationContext() : context;
            if (applicationContext != null) {
                try {
                    Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                    if (obj == null) {
                        obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(930 - (SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)), 35 - (ViewConfiguration.getScrollBarSize() >> 8), (char) ((-1) - Process.getGidForName("")))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                    }
                    Object invoke = ((Method) obj).invoke(null, null);
                    Object[] objArr7 = new Object[1];
                    g(new char[]{15, 2, '!', 25, '\n', '\t', 19, 21, 17, '%', '\b', 22, '\'', Typography.dollar, '.', 29, 13799, 13799, Typography.quote, '\'', 15, '\b', 4, 29, '\n', 29, 22, '\f', Typography.dollar, 7, '#', '\'', 18, 28, '*', 21, 16, 15, 23, '\f', 17, 16, 29, '!', 24, 29, 31, '\''}, 48 - (ViewConfiguration.getJumpTapTimeout() >> 16), (byte) ((ViewConfiguration.getDoubleTapTimeout() >> 16) + 60), objArr7);
                    String str = (String) objArr7[0];
                    Object[] objArr8 = new Object[1];
                    g(new char[]{'(', '0', 29, 11, 16, 15, '\f', 23, 15, '\b', 19, '*', 15, 1, '*', 29, 13785, 13785, 22, 1, 15, 1, '!', InputCardNumberView.DIVIDER, 29, 25, 17, '#', 22, '\f', 13785, 13785, '\b', 15, '!', 21, 13866, 13866, '\n', 30, ',', '\f', Typography.dollar, '-', 2, 15, ',', 15, 13786, 13786, 17, 15, 15, 17, '\b', ',', '\b', ',', '\b', 29, '/', 22, '\n', 29}, 64 - View.resolveSize(0, 0), (byte) (50 - (SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1))), objArr8);
                    String str2 = (String) objArr8[0];
                    Object[] objArr9 = new Object[1];
                    g(new char[]{Typography.dollar, '*', Typography.dollar, 24, 15, 17, '*', '#', 13825, 13825, 22, '/', '-', 29, 16, 23, '#', '\'', 29, 7, Typography.dollar, 21, Typography.amp, Typography.quote, 17, 16, 19, 21, 13915, 13915, 15, 2, 15, '\t', '(', 21, 23, 15, '!', 25, 22, 19, '*', 29, 23, '\f', Typography.dollar, 27, 16, 15, 3, Typography.dollar, Typography.dollar, '*', 19, '+', 19, ',', 18, 28, 19, '+', '*', 19}, 65 - (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1)), (byte) (95 - TextUtils.indexOf("", "", 0)), objArr9);
                    String str3 = (String) objArr9[0];
                    Object[] objArr10 = new Object[1];
                    g(new char[]{4, 6, '\f', '/', '+', Typography.quote, 13771, 13771, '\r', Typography.dollar, '\r', Typography.amp, '\f', 4, 0, '\n', '\'', '#', 6, 2, '0', 6, 4, '\f', Typography.quote, '\f', '#', '\r', '\r', '+', 20, '\n', '#', '\r', '\'', '\n', 5, '\b', '*', 3, '#', ')', 3, 1, 3, '\t', 31, '(', '/', 6, 7, 0, '*', 7, '#', '-', '-', 17, 6, '/'}, TextUtils.indexOf("", "", 0) + 60, (byte) (22 - Drawable.resolveOpacity(0, 0)), objArr10);
                    String str4 = (String) objArr10[0];
                    Object[] objArr11 = new Object[1];
                    g(new char[]{18, 7, InputCardNumberView.DIVIDER, 7, Typography.dollar, '*'}, (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)) + 6, (byte) (Process.getGidForName("") + 40), objArr11);
                    try {
                        Object[] objArr12 = {applicationContext, str, str2, str3, str4, true, (String) objArr11[0], 995651014};
                        Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-1276397751);
                        if (obj2 == null) {
                            obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - View.getDefaultSize(0, 0), 18 - (Process.myPid() >> 22), (char) Color.blue(0))).getMethod("getAuthRequestContext", Context.class, String.class, String.class, String.class, String.class, Boolean.TYPE, String.class, Integer.TYPE);
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
                h(PlaceComponentResult[32], PlaceComponentResult[31], PlaceComponentResult[25], objArr13);
                Class<?> cls2 = Class.forName((String) objArr13[0]);
                byte b = (byte) (lookAheadTest & 42);
                Object[] objArr14 = new Object[1];
                h(b, (byte) (b | 22), PlaceComponentResult[25], objArr14);
                try {
                    Object[] objArr15 = {applicationContext2, Integer.valueOf(((Integer) cls2.getMethod((String) objArr14[0], Object.class).invoke(null, this)).intValue())};
                    Object obj3 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1691739267);
                    if (obj3 == null) {
                        Class cls3 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(55 - ExpandableListView.getPackedPositionType(0L), (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1)) + 2, (char) (ViewConfiguration.getKeyRepeatDelay() >> 16));
                        Object[] objArr16 = new Object[1];
                        j($$g[78], $$g[47], $$g[31], objArr16);
                        obj3 = cls3.getMethod((String) objArr16[0], Context.class, Integer.TYPE);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1691739267, obj3);
                    }
                    Object invoke2 = ((Method) obj3).invoke(null, objArr15);
                    try {
                        Object obj4 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(40157535);
                        if (obj4 == null) {
                            obj4 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(Color.rgb(0, 0, 0) + 16778016, 15 - Color.blue(0), (char) Color.green(0))).getMethod("getAuthRequestContext", null);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(40157535, obj4);
                        }
                        int intValue2 = ((Integer) ((Method) obj4).invoke(invoke2, null)).intValue();
                        try {
                            Object obj5 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1621779126);
                            if (obj5 == null) {
                                obj5 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(TextUtils.getOffsetAfter("", 0) + 800, (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)) + 15, (char) ((-1) - Process.getGidForName("")))).getMethod("PlaceComponentResult", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1621779126, obj5);
                            }
                            if (((Integer) ((Method) obj5).invoke(invoke2, null)).intValue() != intValue2) {
                                ArrayList arrayList = new ArrayList();
                                try {
                                    Object[] objArr17 = {invoke2};
                                    Object obj6 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(658700871);
                                    if (obj6 == null) {
                                        obj6 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(814 - Process.getGidForName(""), 30 - (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)), (char) (57994 - (ViewConfiguration.getTouchSlop() >> 8)))).getMethod("getAuthRequestContext", (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(View.getDefaultSize(0, 0) + 800, (ViewConfiguration.getFadingEdgeLength() >> 16) + 15, (char) (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1))));
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
                                            obj7 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)) + PDF417Common.NUMBER_OF_CODEWORDS, 35 - View.MeasureSpec.makeMeasureSpec(0, 0), (char) KeyEvent.normalizeMetaState(0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj7);
                                        }
                                        Object invoke3 = ((Method) obj7).invoke(objArr, objArr);
                                        try {
                                            Object[] objArr18 = {-895091235, Long.valueOf(j), arrayList, LauncherActivity.getAuid()};
                                            Object obj8 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                            if (obj8 == null) {
                                                obj8 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(((Process.getThreadPriority(0) + 20) >> 6) + 911, TextUtils.getOffsetBefore("", 0) + 18, (char) ((-1) - ((byte) KeyEvent.getModifierMetaStateMask())))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                h(PlaceComponentResult[32], PlaceComponentResult[31], PlaceComponentResult[25], objArr19);
                Class<?> cls4 = Class.forName((String) objArr19[0]);
                byte b2 = (byte) (lookAheadTest & 42);
                Object[] objArr20 = new Object[1];
                h(b2, (byte) (b2 | 22), PlaceComponentResult[25], objArr20);
                try {
                    Object[] objArr21 = {applicationContext3, Integer.valueOf(((Integer) cls4.getMethod((String) objArr20[0], Object.class).invoke(null, this)).intValue())};
                    Object obj9 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(345757441);
                    if (obj9 == null) {
                        Class cls5 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(60 - ((byte) KeyEvent.getModifierMetaStateMask()), 46 - (ViewConfiguration.getLongPressTimeout() >> 16), (char) ((ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)) + 1));
                        Object[] objArr22 = new Object[1];
                        j($$g[9], $$g[28], $$g[8], objArr22);
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
                                obj10 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getTapTimeout() >> 16) + PDF417Common.NUMBER_OF_CODEWORDS, 35 - (ViewConfiguration.getEdgeSlop() >> 16), (char) (Process.myTid() >> 22))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj10);
                            }
                            Object invoke4 = ((Method) obj10).invoke(objArr2, objArr2);
                            try {
                                Object[] objArr24 = {-895091235, Long.valueOf(j2), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj11 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj11 == null) {
                                    obj11 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getKeyRepeatDelay() >> 16) + 911, 19 - (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)), (char) ExpandableListView.getPackedPositionType(0L))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                h(PlaceComponentResult[32], PlaceComponentResult[31], PlaceComponentResult[25], objArr25);
                Class<?> cls6 = Class.forName((String) objArr25[0]);
                byte b3 = (byte) (lookAheadTest & 42);
                Object[] objArr26 = new Object[1];
                h(b3, (byte) (b3 | 22), PlaceComponentResult[25], objArr26);
                try {
                    Object[] objArr27 = {applicationContext4, Integer.valueOf(((Integer) cls6.getMethod((String) objArr26[0], Object.class).invoke(null, this)).intValue())};
                    Object obj12 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-697999596);
                    if (obj12 == null) {
                        Class cls7 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(118 - (ViewConfiguration.getScrollBarFadeDuration() >> 16), (-16777213) - Color.rgb(0, 0, 0), (char) (38969 - (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1))));
                        Object[] objArr28 = new Object[1];
                        j($$g[9], $$g[28], $$g[8], objArr28);
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
                                obj13 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - Color.green(0), (ViewConfiguration.getEdgeSlop() >> 16) + 35, (char) (1 - (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1))))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj13);
                            }
                            Object invoke5 = ((Method) obj13).invoke(objArr3, objArr3);
                            try {
                                Object[] objArr30 = {-895091235, Long.valueOf(j3), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj14 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj14 == null) {
                                    obj14 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(912 - (ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)), 18 - Color.red(0), (char) (ViewConfiguration.getDoubleTapTimeout() >> 16))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                h(PlaceComponentResult[32], PlaceComponentResult[31], PlaceComponentResult[25], objArr31);
                Class<?> cls8 = Class.forName((String) objArr31[0]);
                byte b4 = (byte) (lookAheadTest & 42);
                Object[] objArr32 = new Object[1];
                h(b4, (byte) (b4 | 22), PlaceComponentResult[25], objArr32);
                try {
                    Object[] objArr33 = {applicationContext5, Integer.valueOf(((Integer) cls8.getMethod((String) objArr32[0], Object.class).invoke(null, this)).intValue())};
                    Object obj15 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-16683571);
                    if (obj15 == null) {
                        Class cls9 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(107 - (ViewConfiguration.getScrollBarSize() >> 8), 3 - (ViewConfiguration.getPressedStateDuration() >> 16), (char) (CdmaCellLocation.convertQuartSecToDecDegrees(0) > FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 0 : -1)));
                        Object[] objArr34 = new Object[1];
                        j((byte) ($$g[78] - 1), (byte) (-$$g[40]), (byte) ($$g[78] - 1), objArr34);
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
                                obj16 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)) + PDF417Common.MAX_CODEWORDS_IN_BARCODE, 35 - View.resolveSize(0, 0), (char) (ViewConfiguration.getWindowTouchSlop() >> 8))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj16);
                            }
                            Object invoke6 = ((Method) obj16).invoke(objArr4, objArr4);
                            try {
                                Object[] objArr36 = {-895091235, Long.valueOf(j4), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj17 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj17 == null) {
                                    obj17 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(MotionEvent.axisFromString("") + 912, AndroidCharacter.getMirror('0') - 30, (char) (ViewConfiguration.getScrollDefaultDelay() >> 16))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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

    @Override // id.dana.danapoly.ui.board.BaseDanapolyAudioActivity, id.dana.core.ui.BaseViewBindingActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.content.ContextWrapper, android.content.Context
    public final Context getApplicationContext() {
        return super.getApplicationContext();
    }

    @Override // id.dana.danapoly.ui.board.BaseDanapolyAudioActivity, id.dana.core.ui.BaseViewBindingActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.content.ContextWrapper
    public final Context getBaseContext() {
        return super.getBaseContext();
    }

    @Override // id.dana.danapoly.ui.board.BaseDanapolyAudioActivity, id.dana.core.ui.BaseViewBindingActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public final Resources getResources() {
        return super.getResources();
    }

    @Override // id.dana.danapoly.ui.board.BaseDanapolyAudioActivity, id.dana.core.ui.BaseViewBindingActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onCreate(Bundle bundle) {
        Object[] objArr;
        char[] cArr = {Typography.amp, '\r', '\t', '\b', '\t', 5, '\t', '\f', '\r', '/', 18, 4, '\b', '\r', 3, Typography.dollar, 13911, 13911};
        int codePointAt = super.getResources().getString(R.string.profile_completion_task_phone_number).substring(5, 6).codePointAt(0) - 14;
        try {
            byte b = PlaceComponentResult[25];
            Object[] objArr2 = new Object[1];
            h(b, (byte) (b | TarHeader.LF_BLK), (byte) (-PlaceComponentResult[30]), objArr2);
            Class<?> cls = Class.forName((String) objArr2[0]);
            Object[] objArr3 = new Object[1];
            h((byte) (-PlaceComponentResult[5]), PlaceComponentResult[25], PlaceComponentResult[56], objArr3);
            Object[] objArr4 = new Object[1];
            g(cArr, codePointAt, (byte) (((ApplicationInfo) cls.getMethod((String) objArr3[0], null).invoke(this, null)).targetSdkVersion + 77), objArr4);
            Class<?> cls2 = Class.forName((String) objArr4[0]);
            char[] cArr2 = {'0', 17, 16, 5, 13861};
            int length = super.getResources().getString(R.string.no_space_available).substring(43, 45).length() + 3;
            try {
                byte b2 = PlaceComponentResult[25];
                Object[] objArr5 = new Object[1];
                h(b2, (byte) (b2 | TarHeader.LF_BLK), (byte) (-PlaceComponentResult[30]), objArr5);
                Class<?> cls3 = Class.forName((String) objArr5[0]);
                Object[] objArr6 = new Object[1];
                h((byte) (-PlaceComponentResult[5]), PlaceComponentResult[25], PlaceComponentResult[56], objArr6);
                Object[] objArr7 = new Object[1];
                g(cArr2, length, (byte) (((ApplicationInfo) cls3.getMethod((String) objArr6[0], null).invoke(this, null)).targetSdkVersion + 6), objArr7);
                int intValue = ((Integer) cls2.getDeclaredMethod((String) objArr7[0], new Class[0]).invoke(null, new Object[0])).intValue() % 100000;
                if (intValue < 99000 || intValue > 99999) {
                    Context baseContext = getBaseContext();
                    if (baseContext == null) {
                        Object[] objArr8 = new Object[1];
                        g(new char[]{Typography.amp, '\r', '\t', '\b', '\t', 5, '\t', '\f', '#', ')', '\'', '\f', 0, 2, 6, 3, ',', 0, 6, 19, 24, 0, '\n', '#', Typography.dollar, '\r'}, super.getResources().getString(R.string.referral_too_much_attempt_message).substring(9, 10).codePointAt(0) - 88, (byte) ((ViewConfiguration.getScrollBarFadeDuration() >> 16) + 95), objArr8);
                        Class<?> cls4 = Class.forName((String) objArr8[0]);
                        Object[] objArr9 = new Object[1];
                        g(new char[]{6, '\b', 13917, 13917, '-', 17, 6, 0, 13919, 13919, 23, 3, 6, Typography.dollar, 6, 3, '\r', 11}, super.getResources().getString(R.string.mybills_detail_label_subscription_id).substring(11, 12).codePointAt(0) - 92, (byte) (super.getResources().getString(R.string.system_error).substring(0, 7).length() + 110), objArr9);
                        baseContext = (Context) cls4.getMethod((String) objArr9[0], new Class[0]).invoke(null, null);
                    }
                    if (baseContext != null) {
                        baseContext = baseContext.getApplicationContext();
                    }
                    if (baseContext != null) {
                        try {
                            Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                            if (obj == null) {
                                obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - TextUtils.indexOf("", "", 0, 0), (ViewConfiguration.getScrollBarFadeDuration() >> 16) + 35, (char) TextUtils.getTrimmedLength(""))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                            }
                            Object invoke = ((Method) obj).invoke(null, null);
                            char[] cArr3 = {15, 2, '!', 25, '\n', '\t', 19, 21, 17, '%', '\b', 22, '\'', Typography.dollar, '.', 29, 13799, 13799, Typography.quote, '\'', 15, '\b', 4, 29, '\n', 29, 22, '\f', Typography.dollar, 7, '#', '\'', 18, 28, '*', 21, 16, 15, 23, '\f', 17, 16, 29, '!', 24, 29, 31, '\''};
                            int length2 = getPackageName().length() + 41;
                            try {
                                byte b3 = PlaceComponentResult[25];
                                Object[] objArr10 = new Object[1];
                                h(b3, (byte) (b3 | TarHeader.LF_BLK), (byte) (-PlaceComponentResult[30]), objArr10);
                                Class<?> cls5 = Class.forName((String) objArr10[0]);
                                Object[] objArr11 = new Object[1];
                                h((byte) (-PlaceComponentResult[5]), PlaceComponentResult[25], PlaceComponentResult[56], objArr11);
                                Object[] objArr12 = new Object[1];
                                g(cArr3, length2, (byte) (((ApplicationInfo) cls5.getMethod((String) objArr11[0], null).invoke(this, null)).targetSdkVersion + 27), objArr12);
                                String str = (String) objArr12[0];
                                char[] cArr4 = {'(', '0', 29, 11, 16, 15, '\f', 23, 15, '\b', 19, '*', 15, 1, '*', 29, 13785, 13785, 22, 1, 15, 1, '!', InputCardNumberView.DIVIDER, 29, 25, 17, '#', 22, '\f', 13785, 13785, '\b', 15, '!', 21, 13866, 13866, '\n', 30, ',', '\f', Typography.dollar, '-', 2, 15, ',', 15, 13786, 13786, 17, 15, 15, 17, '\b', ',', '\b', ',', '\b', 29, '/', 22, '\n', 29};
                                try {
                                    byte b4 = PlaceComponentResult[25];
                                    Object[] objArr13 = new Object[1];
                                    h(b4, (byte) (b4 | TarHeader.LF_BLK), (byte) (-PlaceComponentResult[30]), objArr13);
                                    Class<?> cls6 = Class.forName((String) objArr13[0]);
                                    Object[] objArr14 = new Object[1];
                                    h((byte) (-PlaceComponentResult[5]), PlaceComponentResult[25], PlaceComponentResult[56], objArr14);
                                    Object[] objArr15 = new Object[1];
                                    g(cArr4, ((ApplicationInfo) cls6.getMethod((String) objArr14[0], null).invoke(this, null)).targetSdkVersion + 31, (byte) (super.getResources().getString(R.string.googleplay_description).substring(0, 1).length() + 48), objArr15);
                                    String str2 = (String) objArr15[0];
                                    Object[] objArr16 = new Object[1];
                                    g(new char[]{Typography.dollar, '*', Typography.dollar, 24, 15, 17, '*', '#', 13825, 13825, 22, '/', '-', 29, 16, 23, '#', '\'', 29, 7, Typography.dollar, 21, Typography.amp, Typography.quote, 17, 16, 19, 21, 13915, 13915, 15, 2, 15, '\t', '(', 21, 23, 15, '!', 25, 22, 19, '*', 29, 23, '\f', Typography.dollar, 27, 16, 15, 3, Typography.dollar, Typography.dollar, '*', 19, '+', 19, ',', 18, 28, 19, '+', '*', 19}, super.getResources().getString(R.string.subscription_banner_more_indicator).substring(5, 6).codePointAt(0) + 32, (byte) (super.getResources().getString(R.string.social_feeds_empty).substring(12, 14).length() + 93), objArr16);
                                    String str3 = (String) objArr16[0];
                                    Object[] objArr17 = new Object[1];
                                    g(new char[]{4, 6, '\f', '/', '+', Typography.quote, 13771, 13771, '\r', Typography.dollar, '\r', Typography.amp, '\f', 4, 0, '\n', '\'', '#', 6, 2, '0', 6, 4, '\f', Typography.quote, '\f', '#', '\r', '\r', '+', 20, '\n', '#', '\r', '\'', '\n', 5, '\b', '*', 3, '#', ')', 3, 1, 3, '\t', 31, '(', '/', 6, 7, 0, '*', 7, '#', '-', '-', 17, 6, '/'}, KeyEvent.getDeadChar(0, 0) + 60, (byte) (22 - (Process.myTid() >> 22)), objArr17);
                                    String str4 = (String) objArr17[0];
                                    Object[] objArr18 = new Object[1];
                                    g(new char[]{18, 7, InputCardNumberView.DIVIDER, 7, Typography.dollar, '*'}, super.getResources().getString(R.string.setting_new_security_settings).substring(1, 2).codePointAt(0) - 95, (byte) (super.getResources().getString(R.string.zdoc_blur_msg).substring(1, 2).length() + 38), objArr18);
                                    try {
                                        Object[] objArr19 = {baseContext, str, str2, str3, str4, true, (String) objArr18[0], 995651014};
                                        Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-1276397751);
                                        if (obj2 == null) {
                                            obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - TextUtils.indexOf("", ""), Gravity.getAbsoluteGravity(0, 0) + 18, (char) Color.green(0))).getMethod("getAuthRequestContext", Context.class, String.class, String.class, String.class, String.class, Boolean.TYPE, String.class, Integer.TYPE);
                                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(-1276397751, obj2);
                                        }
                                        ((Method) obj2).invoke(invoke, objArr19);
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
                    Object[] objArr20 = new Object[1];
                    h(PlaceComponentResult[32], PlaceComponentResult[31], PlaceComponentResult[25], objArr20);
                    Class<?> cls7 = Class.forName((String) objArr20[0]);
                    byte b5 = (byte) (lookAheadTest & 42);
                    Object[] objArr21 = new Object[1];
                    h(b5, (byte) (b5 | 22), PlaceComponentResult[25], objArr21);
                    try {
                        Object[] objArr22 = {Integer.valueOf(((Integer) cls7.getMethod((String) objArr21[0], Object.class).invoke(null, this)).intValue())};
                        Object obj3 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(25207140);
                        if (obj3 == null) {
                            Class cls8 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(494 - KeyEvent.getDeadChar(0, 0), 4 - TextUtils.indexOf("", ""), (char) (CdmaCellLocation.convertQuartSecToDecDegrees(0) > FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 0 : -1)));
                            Object[] objArr23 = new Object[1];
                            j((byte) ($$g[78] - 1), (byte) (-$$g[40]), (byte) ($$g[78] - 1), objArr23);
                            obj3 = cls8.getMethod((String) objArr23[0], Integer.TYPE);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(25207140, obj3);
                        }
                        Object[] objArr24 = (Object[]) ((Method) obj3).invoke(null, objArr22);
                        int i = ((int[]) objArr24[1])[0];
                        if (((int[]) objArr24[0])[0] != i) {
                            long j = ((r0 ^ i) & 4294967295L) | 42949672960L;
                            try {
                                Object obj4 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                                if (obj4 != null) {
                                    objArr = null;
                                } else {
                                    objArr = null;
                                    obj4 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(((byte) KeyEvent.getModifierMetaStateMask()) + 930, 35 - (ViewConfiguration.getKeyRepeatDelay() >> 16), (char) TextUtils.getOffsetAfter("", 0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj4);
                                }
                                Object invoke2 = ((Method) obj4).invoke(objArr, objArr);
                                try {
                                    Object[] objArr25 = {-1123970390, Long.valueOf(j), new ArrayList(), LauncherActivity.getAuid()};
                                    Object obj5 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                    if (obj5 == null) {
                                        obj5 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getWindowTouchSlop() >> 8) + 911, 18 - Color.alpha(0), (char) (ViewConfiguration.getMaximumDrawingCacheSize() >> 24))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
                                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1759031285, obj5);
                                    }
                                    ((Method) obj5).invoke(invoke2, objArr25);
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
    }

    @Override // id.dana.danapoly.ui.board.BaseDanapolyAudioActivity, id.dana.core.ui.BaseViewBindingActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onPause() {
        Context baseContext = getBaseContext();
        if (baseContext == null) {
            char[] cArr = {Typography.amp, '\r', '\t', '\b', '\t', 5, '\t', '\f', '#', ')', '\'', '\f', 0, 2, 6, 3, ',', 0, 6, 19, 24, 0, '\n', '#', Typography.dollar, '\r'};
            int length = getPackageName().length() + 19;
            try {
                byte b = PlaceComponentResult[25];
                Object[] objArr = new Object[1];
                h(b, (byte) (b | TarHeader.LF_BLK), (byte) (-PlaceComponentResult[30]), objArr);
                Class<?> cls = Class.forName((String) objArr[0]);
                Object[] objArr2 = new Object[1];
                h((byte) (-PlaceComponentResult[5]), PlaceComponentResult[25], PlaceComponentResult[56], objArr2);
                Object[] objArr3 = new Object[1];
                g(cArr, length, (byte) (((ApplicationInfo) cls.getMethod((String) objArr2[0], null).invoke(this, null)).targetSdkVersion + 62), objArr3);
                Class<?> cls2 = Class.forName((String) objArr3[0]);
                Object[] objArr4 = new Object[1];
                g(new char[]{6, '\b', 13917, 13917, '-', 17, 6, 0, 13919, 13919, 23, 3, 6, Typography.dollar, 6, 3, '\r', 11}, super.getResources().getString(R.string.zface_bad_brightness).substring(0, 1).codePointAt(0) - 66, (byte) ((ViewConfiguration.getTouchSlop() >> 8) + 117), objArr4);
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
                    obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(Color.green(0) + PDF417Common.NUMBER_OF_CODEWORDS, 35 - KeyEvent.normalizeMetaState(0), (char) ((-1) - ExpandableListView.getPackedPositionChild(0L)))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                }
                Object invoke = ((Method) obj).invoke(null, null);
                try {
                    Object[] objArr5 = {baseContext};
                    Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-549958681);
                    if (obj2 == null) {
                        obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(((Process.getThreadPriority(0) + 20) >> 6) + 911, 19 - (Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1)), (char) (Color.rgb(0, 0, 0) + 16777216))).getMethod("MyBillsEntityDataFactory", Context.class);
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

    public DailyCheckActivity() {
        final DailyCheckActivity dailyCheckActivity = this;
        final Function0 function0 = null;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = new ViewModelLazy(Reflection.getOrCreateKotlinClass(DailyCheckViewModel.class), new Function0<ViewModelStore>() { // from class: id.dana.danapoly.ui.dailycheck.DailyCheckActivity$special$$inlined$viewModels$default$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                ViewModelStore viewModelStore = ComponentActivity.this.getViewModelStore();
                Intrinsics.checkNotNullExpressionValue(viewModelStore, "");
                return viewModelStore;
            }
        }, new Function0<ViewModelProvider.Factory>() { // from class: id.dana.danapoly.ui.dailycheck.DailyCheckActivity$viewModel$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return DailyCheckActivity.this.getViewModelFactory();
            }
        }, new Function0<CreationExtras>() { // from class: id.dana.danapoly.ui.dailycheck.DailyCheckActivity$special$$inlined$viewModels$default$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final CreationExtras invoke() {
                CreationExtras creationExtras;
                Function0 function02 = Function0.this;
                if (function02 == null || (creationExtras = (CreationExtras) function02.invoke()) == null) {
                    CreationExtras defaultViewModelCreationExtras = dailyCheckActivity.getDefaultViewModelCreationExtras();
                    Intrinsics.checkNotNullExpressionValue(defaultViewModelCreationExtras, "");
                    return defaultViewModelCreationExtras;
                }
                return creationExtras;
            }
        });
    }

    public static final /* synthetic */ ActivityDailyCheckBinding access$getBinding(DailyCheckActivity dailyCheckActivity) {
        return (ActivityDailyCheckBinding) dailyCheckActivity.getBinding();
    }

    @JvmName(name = "getViewModelFactory")
    public final ViewModelFactory getViewModelFactory() {
        ViewModelFactory viewModelFactory = this.viewModelFactory;
        if (viewModelFactory != null) {
            return viewModelFactory;
        }
        Intrinsics.throwUninitializedPropertyAccessException("");
        return null;
    }

    @JvmName(name = "setViewModelFactory")
    public final void setViewModelFactory(ViewModelFactory viewModelFactory) {
        Intrinsics.checkNotNullParameter(viewModelFactory, "");
        this.viewModelFactory = viewModelFactory;
    }

    @Override // id.dana.core.ui.BaseViewBindingActivity
    public final ActivityDailyCheckBinding inflateViewBinding() {
        ActivityDailyCheckBinding BuiltInFictitiousFunctionClassFactory = ActivityDailyCheckBinding.BuiltInFictitiousFunctionClassFactory(getLayoutInflater());
        Intrinsics.checkNotNullExpressionValue(BuiltInFictitiousFunctionClassFactory, "");
        return BuiltInFictitiousFunctionClassFactory;
    }

    @Override // id.dana.core.ui.BaseViewBindingActivity
    public final void configToolbar() {
        Toolbar toolbar = ((ActivityDailyCheckBinding) getBinding()).DatabaseTableConfigUtil.DatabaseTableConfigUtil;
        Intrinsics.checkNotNullExpressionValue(toolbar, "");
        setToolbar(toolbar);
        Toolbar toolbar2 = getToolbar();
        Drawable PlaceComponentResult2 = ContextCompat.PlaceComponentResult(toolbar2.getContext(), id.dana.danapoly.R.drawable.KClassImpl$Data$declaredNonStaticMembers$2);
        toolbar2.setContentDescription(getString(id.dana.danapoly.R.string.KClassImpl$Data$declaredNonStaticMembers$2));
        toolbar2.setNavigationIcon(PlaceComponentResult2);
        toolbar2.setNavigationOnClickListener(new View.OnClickListener() { // from class: id.dana.danapoly.ui.dailycheck.DailyCheckActivity$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DailyCheckActivity.m732$r8$lambda$QFtFvxo5IZOaNouWBryQxamM(DailyCheckActivity.this, view);
            }
        });
        OnBackPressedDispatcher onBackPressedDispatcher = getOnBackPressedDispatcher();
        Intrinsics.checkNotNullExpressionValue(onBackPressedDispatcher, "");
        OnBackPressedDispatcherKt.PlaceComponentResult(onBackPressedDispatcher, new Function1<OnBackPressedCallback, Unit>() { // from class: id.dana.danapoly.ui.dailycheck.DailyCheckActivity$configToolbar$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(OnBackPressedCallback onBackPressedCallback) {
                invoke2(onBackPressedCallback);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(OnBackPressedCallback onBackPressedCallback) {
                Intrinsics.checkNotNullParameter(onBackPressedCallback, "");
                DailyCheckActivity.this.setNeedStopMusicBackground(false);
                DailyCheckActivity.this.finish();
            }
        });
        ((ActivityDailyCheckBinding) getBinding()).DatabaseTableConfigUtil.NetworkUserEntityData$$ExternalSyntheticLambda2.setText(getString(id.dana.danapoly.R.string.daily_check_in_title));
    }

    @Override // id.dana.core.ui.BaseViewBindingActivity
    public final void initComponent() {
        Context applicationContext = getApplicationContext();
        if (applicationContext != null) {
            DanapolyComponent MyBillsEntityDataFactory = ((DanapolyComponentProvider) applicationContext).provideDanapolyComponent().MyBillsEntityDataFactory();
            this.BuiltInFictitiousFunctionClassFactory = MyBillsEntityDataFactory;
            MyBillsEntityDataFactory.BuiltInFictitiousFunctionClassFactory(this);
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type id.dana.danapoly.di.provider.DanapolyComponentProvider");
    }

    public final void PlaceComponentResult(boolean p0) {
        ((ActivityDailyCheckBinding) getBinding()).KClassImpl$Data$declaredNonStaticMembers$2.setEnabled(p0);
        if (p0) {
            ((ActivityDailyCheckBinding) getBinding()).KClassImpl$Data$declaredNonStaticMembers$2.setActiveButton(getString(id.dana.danapoly.R.string.DatabaseTableConfigUtil_res_0x7f1304aa), null);
        } else {
            ((ActivityDailyCheckBinding) getBinding()).KClassImpl$Data$declaredNonStaticMembers$2.setDisabled(getString(id.dana.danapoly.R.string.DatabaseTableConfigUtil_res_0x7f1304aa));
        }
    }

    @Override // id.dana.danapoly.ui.board.BaseDanapolyAudioActivity, id.dana.core.ui.BaseViewBindingActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onResume() {
        Context baseContext = getBaseContext();
        if (baseContext == null) {
            Object[] objArr = new Object[1];
            g(new char[]{Typography.amp, '\r', '\t', '\b', '\t', 5, '\t', '\f', '#', ')', '\'', '\f', 0, 2, 6, 3, ',', 0, 6, 19, 24, 0, '\n', '#', Typography.dollar, '\r'}, (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)) + 25, (byte) (95 - View.MeasureSpec.getSize(0)), objArr);
            Class<?> cls = Class.forName((String) objArr[0]);
            char[] cArr = {6, '\b', 13917, 13917, '-', 17, 6, 0, 13919, 13919, 23, 3, 6, Typography.dollar, 6, 3, '\r', 11};
            try {
                byte b = PlaceComponentResult[25];
                Object[] objArr2 = new Object[1];
                h(b, (byte) (b | TarHeader.LF_BLK), (byte) (-PlaceComponentResult[30]), objArr2);
                Class<?> cls2 = Class.forName((String) objArr2[0]);
                h((byte) (-PlaceComponentResult[5]), PlaceComponentResult[25], PlaceComponentResult[56], new Object[1]);
                Object[] objArr3 = new Object[1];
                g(cArr, ((ApplicationInfo) cls2.getMethod((String) r10[0], null).invoke(this, null)).targetSdkVersion - 15, (byte) (Color.rgb(0, 0, 0) + 16777333), objArr3);
                baseContext = (Context) cls.getMethod((String) objArr3[0], new Class[0]).invoke(null, null);
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
                    obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - (ViewConfiguration.getKeyRepeatDelay() >> 16), 35 - View.resolveSizeAndState(0, 0, 0), (char) ((Process.getThreadPriority(0) + 20) >> 6))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                }
                Object invoke = ((Method) obj).invoke(null, null);
                try {
                    Object[] objArr4 = {baseContext};
                    Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(247288059);
                    if (obj2 == null) {
                        obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(910 - TextUtils.indexOf((CharSequence) "", '0', 0), 18 - (ViewConfiguration.getScrollBarSize() >> 8), (char) (((byte) KeyEvent.getModifierMetaStateMask()) + 1))).getMethod("KClassImpl$Data$declaredNonStaticMembers$2", Context.class);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(247288059, obj2);
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
        setNeedStartMusicBackground(true);
        super.onResume();
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\f\u0010\rJ\u001d\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bR\u0014\u0010\n\u001a\u00020\t8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\n\u0010\u000b"}, d2 = {"Lid/dana/danapoly/ui/dailycheck/DailyCheckActivity$Companion;", "", "Landroid/content/Context;", "p0", "", "p1", "Landroid/content/Intent;", "BuiltInFictitiousFunctionClassFactory", "(Landroid/content/Context;I)Landroid/content/Intent;", "", "BUNDLE_SHOULD_REFRESH_CHECK_IN", "Ljava/lang/String;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public static Intent BuiltInFictitiousFunctionClassFactory(Context p0, int p1) {
            Intrinsics.checkNotNullParameter(p0, "");
            Intent intent = new Intent(p0, DailyCheckActivity.class);
            intent.putExtra("bundle_point", p1);
            return intent;
        }
    }

    public static /* synthetic */ void $r8$lambda$Ab_puPygryP6c2VcgPSBcIU80yA(DailyCheckActivity dailyCheckActivity, View view) {
        Intrinsics.checkNotNullParameter(dailyCheckActivity, "");
        final DailyCheckViewModel dailyCheckViewModel = (DailyCheckViewModel) dailyCheckActivity.KClassImpl$Data$declaredNonStaticMembers$2.getValue();
        BaseFlowUseCase.execute$default(dailyCheckViewModel.KClassImpl$Data$declaredNonStaticMembers$2, NoParams.INSTANCE, null, new Function1<Boolean, Unit>() { // from class: id.dana.danapoly.ui.dailycheck.viewmodel.DailyCheckViewModel$doCheckIn$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* synthetic */ Unit invoke(Boolean bool) {
                invoke(bool.booleanValue());
                return Unit.INSTANCE;
            }

            public final void invoke(boolean z) {
                MutableStateFlow mutableStateFlow;
                Object value;
                mutableStateFlow = DailyCheckViewModel.this.MyBillsEntityDataFactory;
                do {
                    value = mutableStateFlow.getValue();
                    DailyCheckUiState dailyCheckUiState = (DailyCheckUiState) value;
                } while (!mutableStateFlow.compareAndSet(value, new DailyCheckUiState.OnDoCheckInComplete(z)));
            }
        }, new Function1<Throwable, Unit>() { // from class: id.dana.danapoly.ui.dailycheck.viewmodel.DailyCheckViewModel$doCheckIn$2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                invoke2(th);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable th) {
                MutableStateFlow mutableStateFlow;
                Object value;
                Intrinsics.checkNotNullParameter(th, "");
                mutableStateFlow = DailyCheckViewModel.this.MyBillsEntityDataFactory;
                do {
                    value = mutableStateFlow.getValue();
                    DailyCheckUiState dailyCheckUiState = (DailyCheckUiState) value;
                } while (!mutableStateFlow.compareAndSet(value, new DailyCheckUiState.OnDoCheckInComplete(false)));
            }
        }, new Function0<Unit>() { // from class: id.dana.danapoly.ui.dailycheck.viewmodel.DailyCheckViewModel$doCheckIn$3
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2() {
                MutableStateFlow mutableStateFlow;
                Object value;
                mutableStateFlow = DailyCheckViewModel.this.MyBillsEntityDataFactory;
                do {
                    value = mutableStateFlow.getValue();
                    DailyCheckUiState dailyCheckUiState = (DailyCheckUiState) value;
                } while (!mutableStateFlow.compareAndSet(value, DailyCheckUiState.None.INSTANCE));
            }
        }, ViewModelKt.PlaceComponentResult(dailyCheckViewModel), 2, null);
        dailyCheckActivity.PlaceComponentResult(false);
    }

    /* renamed from: $r8$lambda$Q-FtFvxo5IZOa-NouWBryQx-amM */
    public static /* synthetic */ void m732$r8$lambda$QFtFvxo5IZOaNouWBryQxamM(DailyCheckActivity dailyCheckActivity, View view) {
        Intrinsics.checkNotNullParameter(dailyCheckActivity, "");
        dailyCheckActivity.getOnBackPressedDispatcher().KClassImpl$Data$declaredNonStaticMembers$2();
    }

    public static final /* synthetic */ void access$renderErrorState(DailyCheckActivity dailyCheckActivity, boolean z) {
        Group group = ((ActivityDailyCheckBinding) dailyCheckActivity.getBinding()).NetworkUserEntityData$$ExternalSyntheticLambda0;
        Intrinsics.checkNotNullExpressionValue(group, "");
        boolean z2 = !z;
        group.setVisibility(z2 ? 0 : 8);
        FrameLayout frameLayout = ((ActivityDailyCheckBinding) dailyCheckActivity.getBinding()).getAuthRequestContext;
        Intrinsics.checkNotNullExpressionValue(frameLayout, "");
        frameLayout.setVisibility(z2 ? 0 : 8);
        AppCompatImageView appCompatImageView = ((ActivityDailyCheckBinding) dailyCheckActivity.getBinding()).getErrorConfigVersion;
        Intrinsics.checkNotNullExpressionValue(appCompatImageView, "");
        appCompatImageView.setVisibility(z ? 0 : 8);
        TextView textView = ((ActivityDailyCheckBinding) dailyCheckActivity.getBinding()).GetContactSyncConfig;
        Intrinsics.checkNotNullExpressionValue(textView, "");
        textView.setVisibility(z ? 0 : 8);
        TextView textView2 = ((ActivityDailyCheckBinding) dailyCheckActivity.getBinding()).NetworkUserEntityData$$ExternalSyntheticLambda1;
        Intrinsics.checkNotNullExpressionValue(textView2, "");
        textView2.setVisibility(z ? 0 : 8);
    }

    public static final /* synthetic */ void access$setPoint(DailyCheckActivity dailyCheckActivity, int i) {
        dailyCheckActivity.MyBillsEntityDataFactory = i;
        ((ActivityDailyCheckBinding) dailyCheckActivity.getBinding()).initRecordTimeStamp.setText(String.valueOf(dailyCheckActivity.MyBillsEntityDataFactory));
    }

    public static final /* synthetic */ void access$showErrorToast(DailyCheckActivity dailyCheckActivity) {
        CustomToast customToast = CustomToast.MyBillsEntityDataFactory;
        DailyCheckActivity dailyCheckActivity2 = dailyCheckActivity;
        int i = id.dana.danapoly.R.drawable.M;
        int i2 = id.dana.danapoly.R.drawable.NetworkUserEntityData$$ExternalSyntheticLambda0;
        String string = dailyCheckActivity.getString(id.dana.danapoly.R.string.daily_check_error_text);
        Intrinsics.checkNotNullExpressionValue(string, "");
        CustomToast.MyBillsEntityDataFactory(dailyCheckActivity2, i, i2, string);
    }

    @Override // id.dana.core.ui.BaseViewBindingActivity
    public final void init() {
        Bundle extras;
        Intent intent = getIntent();
        if (intent != null && (extras = intent.getExtras()) != null) {
            this.MyBillsEntityDataFactory = extras.getInt("bundle_point");
            ((ActivityDailyCheckBinding) getBinding()).initRecordTimeStamp.setText(String.valueOf(this.MyBillsEntityDataFactory));
        }
        StateFlow<DailyCheckUiState> stateFlow = ((DailyCheckViewModel) this.KClassImpl$Data$declaredNonStaticMembers$2.getValue()).BuiltInFictitiousFunctionClassFactory;
        Lifecycle lifecycle = getLifecycle();
        Intrinsics.checkNotNullExpressionValue(lifecycle, "");
        FlowKt.launchIn(FlowKt.onEach(FlowKt.distinctUntilChanged(FlowExtKt.PlaceComponentResult(stateFlow, lifecycle)), new DailyCheckActivity$initViewModel$1(this, null)), LifecycleOwnerKt.PlaceComponentResult(this));
        RecyclerView recyclerView = ((ActivityDailyCheckBinding) getBinding()).moveToNextValue;
        recyclerView.setLayoutManager(new GridLayoutManager(recyclerView.getContext(), 5));
        recyclerView.setAdapter(this.PlaceComponentResult);
        ((ActivityDailyCheckBinding) getBinding()).KClassImpl$Data$declaredNonStaticMembers$2.setOnClickListener(new View.OnClickListener() { // from class: id.dana.danapoly.ui.dailycheck.DailyCheckActivity$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DailyCheckActivity.$r8$lambda$Ab_puPygryP6c2VcgPSBcIU80yA(DailyCheckActivity.this, view);
            }
        });
        ((ActivityDailyCheckBinding) getBinding()).BuiltInFictitiousFunctionClassFactory.setOnCloseIconClicked(new Function0<Unit>() { // from class: id.dana.danapoly.ui.dailycheck.DailyCheckActivity$initActionListener$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2() {
                DanapolyPromptInfoView danapolyPromptInfoView = DailyCheckActivity.access$getBinding(DailyCheckActivity.this).BuiltInFictitiousFunctionClassFactory;
                Intrinsics.checkNotNullExpressionValue(danapolyPromptInfoView, "");
                danapolyPromptInfoView.setVisibility(8);
            }
        });
        final DailyCheckViewModel dailyCheckViewModel = (DailyCheckViewModel) this.KClassImpl$Data$declaredNonStaticMembers$2.getValue();
        BaseFlowUseCase.execute$default(dailyCheckViewModel.PlaceComponentResult, NoParams.INSTANCE, null, new Function1<CheckInInfo, Unit>() { // from class: id.dana.danapoly.ui.dailycheck.viewmodel.DailyCheckViewModel$fetchCheckInHistory$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(CheckInInfo checkInInfo) {
                invoke2(checkInInfo);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(CheckInInfo checkInInfo) {
                MutableStateFlow mutableStateFlow;
                Object value;
                Intrinsics.checkNotNullParameter(checkInInfo, "");
                mutableStateFlow = DailyCheckViewModel.this.MyBillsEntityDataFactory;
                do {
                    value = mutableStateFlow.getValue();
                    DailyCheckUiState dailyCheckUiState = (DailyCheckUiState) value;
                } while (!mutableStateFlow.compareAndSet(value, new DailyCheckUiState.OnGetCheckInHistorySuccess(CheckInMapperKt.toDailyCheckItemModel(checkInInfo))));
            }
        }, new Function1<Throwable, Unit>() { // from class: id.dana.danapoly.ui.dailycheck.viewmodel.DailyCheckViewModel$fetchCheckInHistory$2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                invoke2(th);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable th) {
                MutableStateFlow mutableStateFlow;
                Object value;
                Intrinsics.checkNotNullParameter(th, "");
                mutableStateFlow = DailyCheckViewModel.this.MyBillsEntityDataFactory;
                do {
                    value = mutableStateFlow.getValue();
                    DailyCheckUiState dailyCheckUiState = (DailyCheckUiState) value;
                } while (!mutableStateFlow.compareAndSet(value, new DailyCheckUiState.OnGetCheckInHistoryError(th)));
            }
        }, new Function0<Unit>() { // from class: id.dana.danapoly.ui.dailycheck.viewmodel.DailyCheckViewModel$fetchCheckInHistory$3
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2() {
                MutableStateFlow mutableStateFlow;
                Object value;
                mutableStateFlow = DailyCheckViewModel.this.MyBillsEntityDataFactory;
                do {
                    value = mutableStateFlow.getValue();
                    DailyCheckUiState dailyCheckUiState = (DailyCheckUiState) value;
                } while (!mutableStateFlow.compareAndSet(value, DailyCheckUiState.None.INSTANCE));
            }
        }, ViewModelKt.PlaceComponentResult(dailyCheckViewModel), 2, null);
    }

    private static void g(char[] cArr, int i, byte b, Object[] objArr) {
        int i2;
        getCallingPid getcallingpid = new getCallingPid();
        char[] cArr2 = DatabaseTableConfigUtil;
        if (cArr2 != null) {
            int length = cArr2.length;
            char[] cArr3 = new char[length];
            for (int i3 = 0; i3 < length; i3++) {
                cArr3[i3] = (char) (cArr2[i3] ^ (-1549216646985767851L));
            }
            cArr2 = cArr3;
        }
        char c = (char) ((-1549216646985767851L) ^ NetworkUserEntityData$$ExternalSyntheticLambda2);
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
