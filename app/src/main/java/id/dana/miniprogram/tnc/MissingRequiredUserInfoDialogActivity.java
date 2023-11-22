package id.dana.miniprogram.tnc;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.ImageFormat;
import android.graphics.PointF;
import android.graphics.drawable.Drawable;
import android.media.AudioTrack;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
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
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.alibaba.fastjson.parser.JSONLexer;
import com.alipay.iap.android.common.syncintegration.api.IAPSyncCommand;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.google.common.base.Ascii;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.google.zxing.pdf417.PDF417Common;
import dagger.internal.Preconditions;
import id.dana.R;
import id.dana.base.BaseActivity;
import id.dana.cashier.view.InputCardNumberView;
import id.dana.component.buttoncomponent.DanaButtonGhostView;
import id.dana.component.buttoncomponent.DanaButtonPrimaryView;
import id.dana.contract.deeplink.DeepLinkModule;
import id.dana.contract.deeplink.FeatureModule;
import id.dana.contract.deeplink.ReadLinkPropertiesContract;
import id.dana.contract.services.ServicesModule;
import id.dana.contract.shortener.RestoreUrlModule;
import id.dana.contract.staticqr.ScanQrModule;
import id.dana.core.ui.glide.GlideApp;
import id.dana.core.ui.glide.GlideRequests;
import id.dana.danah5.DanaH5;
import id.dana.danah5.showagreement.ShowAgreementBridge;
import id.dana.data.constant.DanaUrl;
import id.dana.di.component.ApplicationComponent;
import id.dana.di.modules.OauthModule;
import id.dana.miniprogram.adapter.MiniProgramAgreementsAdapter;
import id.dana.miniprogram.di.DaggerMissingRequiredUserInfoComponent;
import id.dana.onboarding.splash.LauncherActivity;
import id.dana.utils.UrlUtil;
import id.dana.utils.danah5.DanaH5Listener;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlin.text.Typography;
import o.SummaryVoucherView$$ExternalSyntheticLambda0;
import o.getCallingPid;
import org.greenrobot.eventbus.EventBus;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u001d2\u00020\u0001:\u0002\u001d\u001eB\u0007¢\u0006\u0004\b\u001c\u0010\u000bJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u001f\u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\u0006\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00060\u0005H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\f\u001a\u00020\tH\u0016¢\u0006\u0004\b\f\u0010\u000bJ\u0019\u0010\u000f\u001a\u00020\t2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016¢\u0006\u0004\b\u000f\u0010\u0010R\"\u0010\u0012\u001a\u00020\u00118\u0007@\u0007X\u0087.¢\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u0016\u0010\u001b\u001a\u00020\u00188\u0002@\u0002X\u0083.¢\u0006\u0006\n\u0004\b\u0019\u0010\u001a"}, d2 = {"Lid/dana/miniprogram/tnc/MissingRequiredUserInfoDialogActivity;", "Lid/dana/base/BaseActivity;", "", "getLayout", "()I", "Ljava/util/HashMap;", "", "getAuthRequestContext", "()Ljava/util/HashMap;", "", IAPSyncCommand.COMMAND_INIT, "()V", "onBackPressed", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "(Landroid/os/Bundle;)V", "Lid/dana/contract/deeplink/ReadLinkPropertiesContract$Presenter;", "readLinkPropertiesPresenter", "Lid/dana/contract/deeplink/ReadLinkPropertiesContract$Presenter;", "getReadLinkPropertiesPresenter", "()Lid/dana/contract/deeplink/ReadLinkPropertiesContract$Presenter;", "setReadLinkPropertiesPresenter", "(Lid/dana/contract/deeplink/ReadLinkPropertiesContract$Presenter;)V", "Lid/dana/miniprogram/tnc/MissingRequiredUserInfoDialogActivity$StartParams;", "lookAheadTest", "Lid/dana/miniprogram/tnc/MissingRequiredUserInfoDialogActivity$StartParams;", "KClassImpl$Data$declaredNonStaticMembers$2", "<init>", "Companion", "StartParams"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class MissingRequiredUserInfoDialogActivity extends BaseActivity {
    public static final String EXTRA_START_PARAMS = "startParams";
    private static char getErrorConfigVersion;
    private static char[] scheduleImpl;
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();

    /* renamed from: lookAheadTest  reason: from kotlin metadata */
    private StartParams KClassImpl$Data$declaredNonStaticMembers$2;
    @Inject
    public ReadLinkPropertiesContract.Presenter readLinkPropertiesPresenter;
    public static final byte[] $$a = {107, -117, Ascii.NAK, -50, -51, TarHeader.LF_NORMAL, -46, -10, -7, -14, 39, -48, -13, 4, -18, -12, 46, -36, -26, 12, Ascii.DC4, -34, -9, -24, -2, -10, -14, -5, -22, 44, -59, -6, 5, 15, -26, -19, -11, 9, -21, -8, 42, -51, -6, -13, 8, -26, -3, 1, -48, 4, -25, -7, 35, -43, -10, -3, 65, -39, -36, -26, 12, TarHeader.LF_FIFO, -71, -8, -5, -16, 4, -24, 6, -6, 15, -40, -6, Ascii.DC4, -40, 12, -26, 4, -1, 15, -31, -15, 4, -10, -20, -8, 72, -21};
    public static final int $$b = 222;
    public static final byte[] PlaceComponentResult = {45, -61, Ascii.ETB, 105, 17, -6, 18, 1, -2, -1, -50, 57, 16, 3, 10, -11, 13, 10, -66, Ascii.EM, TarHeader.LF_NORMAL, 3, 10, -11, Ascii.ETB, 0, -1, 5, 13, 10, -7, 15, 9, -45, Ascii.GS, 22, -7, -33, TarHeader.LF_NORMAL, -7, 5, -5, Ascii.EM, -17, -47, 66, -7, 17, -3, -53, 41, 42, -2, 5, -11, 12, 2, 19, -47, TarHeader.LF_CHR, 4, 0, 1, -2, 2, Ascii.ETB, -7, 10, 3, -33, 41, -4, 13};
    public static final int getAuthRequestContext = 130;

    static {
        KClassImpl$Data$declaredNonStaticMembers$2();
        INSTANCE = new Companion(null);
    }

    static void KClassImpl$Data$declaredNonStaticMembers$2() {
        getErrorConfigVersion = (char) 42066;
        scheduleImpl = new char[]{37275, 37248, 37369, 37371, 37287, 37344, 37261, 37306, 37254, 37302, 37252, 37291, 37281, 37370, 37255, 37280, 37279, 37366, 37375, 37286, 37260, 37263, 37251, 37289, 37310, 37305, 37365, 37294, 37311, 37290, 37274, 37249, 37309, 37308, 37373, 37372, 37288, 37367, 37345, 37282, 37368, 37253, 37292, 37374, 37293, 37307, 37262, 37283, 37250};
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0026  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x001e  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0026 -> B:11:0x0032). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void a(short r6, int r7, short r8, java.lang.Object[] r9) {
        /*
            byte[] r0 = id.dana.miniprogram.tnc.MissingRequiredUserInfoDialogActivity.PlaceComponentResult
            int r7 = r7 + 16
            int r8 = r8 + 4
            int r6 = 106 - r6
            byte[] r1 = new byte[r7]
            int r7 = r7 + (-1)
            r2 = 0
            if (r0 != 0) goto L16
            r3 = r1
            r4 = 0
            r1 = r0
            r0 = r9
            r9 = r8
            r8 = r7
            goto L32
        L16:
            r3 = 0
        L17:
            byte r4 = (byte) r6
            r1[r3] = r4
            int r8 = r8 + 1
            if (r3 != r7) goto L26
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            r9[r2] = r6
            return
        L26:
            int r3 = r3 + 1
            r4 = r0[r8]
            r5 = r8
            r8 = r7
            r7 = r4
            r4 = r3
            r3 = r1
            r1 = r0
            r0 = r9
            r9 = r5
        L32:
            int r6 = r6 + r7
            int r6 = r6 + (-4)
            r7 = r8
            r8 = r9
            r9 = r0
            r0 = r1
            r1 = r3
            r3 = r4
            goto L17
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.miniprogram.tnc.MissingRequiredUserInfoDialogActivity.a(short, int, short, java.lang.Object[]):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0029  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0021  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0029 -> B:11:0x0031). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void c(int r7, short r8, short r9, java.lang.Object[] r10) {
        /*
            byte[] r0 = id.dana.miniprogram.tnc.MissingRequiredUserInfoDialogActivity.$$a
            int r7 = r7 * 2
            int r7 = r7 + 75
            int r8 = r8 * 3
            int r8 = r8 + 21
            int r9 = r9 + 4
            byte[] r1 = new byte[r8]
            r2 = 0
            if (r0 != 0) goto L17
            r3 = r1
            r4 = 0
            r1 = r0
            r0 = r10
            r10 = r9
            goto L31
        L17:
            r3 = 0
        L18:
            int r9 = r9 + 1
            int r4 = r3 + 1
            byte r5 = (byte) r7
            r1[r3] = r5
            if (r4 != r8) goto L29
            java.lang.String r7 = new java.lang.String
            r7.<init>(r1, r2)
            r10[r2] = r7
            return
        L29:
            r3 = r0[r9]
            r6 = r10
            r10 = r9
            r9 = r3
            r3 = r1
            r1 = r0
            r0 = r6
        L31:
            int r9 = -r9
            int r7 = r7 + r9
            int r7 = r7 + (-7)
            r9 = r10
            r10 = r0
            r0 = r1
            r1 = r3
            r3 = r4
            goto L18
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.miniprogram.tnc.MissingRequiredUserInfoDialogActivity.c(int, short, short, java.lang.Object[]):void");
    }

    public final void _$_clearFindViewByIdCache() {
        this._$_findViewCache.clear();
    }

    public final View _$_findCachedViewById(int i) {
        Map<Integer, View> map = this._$_findViewCache;
        View view = map.get(Integer.valueOf(i));
        if (view == null) {
            View findViewById = findViewById(i);
            if (findViewById != null) {
                map.put(Integer.valueOf(i), findViewById);
                return findViewById;
            }
            return null;
        }
        return view;
    }

    @Override // id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper
    public final void attachBaseContext(Context context) {
        Object[] objArr;
        Object[] objArr2;
        Object[] objArr3;
        Object[] objArr4;
        Method method;
        super.attachBaseContext(context);
        Object[] objArr5 = new Object[1];
        b((byte) (43 - Drawable.resolveOpacity(0, 0)), new char[]{JSONLexer.EOI, '\r', 18, '\'', 16, 20, '\n', '\'', 19, 29, '%', 17, 29, 18, '+', 28, 13844, 13844}, 18 - TextUtils.getTrimmedLength(""), objArr5);
        Class<?> cls = Class.forName((String) objArr5[0]);
        Object[] objArr6 = new Object[1];
        b((byte) ((ViewConfiguration.getKeyRepeatDelay() >> 16) + 7), new char[]{'%', 11, '!', 16, 13829}, Process.getGidForName("") + 6, objArr6);
        int intValue = ((Integer) cls.getDeclaredMethod((String) objArr6[0], new Class[0]).invoke(null, new Object[0])).intValue() % 100000;
        if (intValue < 99000 || intValue > 99999) {
            Context applicationContext = context != null ? context.getApplicationContext() : context;
            if (applicationContext != null) {
                try {
                    Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                    if (obj == null) {
                        obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(View.MeasureSpec.getMode(0) + PDF417Common.NUMBER_OF_CODEWORDS, 35 - View.resolveSize(0, 0), (char) (ViewConfiguration.getScrollDefaultDelay() >> 16))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                    }
                    Object invoke = ((Method) obj).invoke(null, null);
                    Object[] objArr7 = new Object[1];
                    b((byte) (102 - TextUtils.indexOf("", "", 0)), new char[]{'#', '/', '\t', ',', 25, 18, 16, Typography.amp, Typography.dollar, '!', ',', 21, 30, 28, ',', 1, 13841, 13841, 6, 23, 7, '.', ',', 0, 7, '\'', '\'', '\t', InputCardNumberView.DIVIDER, '\r', 22, Typography.quote, 16, 3, 31, 20, 24, 16, '\'', 16, '%', JSONLexer.EOI, 4, 3, '*', '%', 1, 30}, ImageFormat.getBitsPerPixel(0) + 49, objArr7);
                    String str = (String) objArr7[0];
                    Object[] objArr8 = new Object[1];
                    b((byte) (20 - TextUtils.lastIndexOf("", '0')), new char[]{Typography.quote, 20, 4, '\t', 24, 16, 16, '\'', 7, '.', 20, '\n', '\b', '.', '-', 1, 13757, 13757, 22, ',', '\b', '.', 0, '%', '\t', 2, 15, 31, '\'', '\t', 13757, 13757, '.', 7, 2, Typography.amp, 13838, 13838, 14, '\'', 11, 20, Typography.dollar, 1, '/', '#', '/', Typography.dollar, 13758, 13758, Typography.amp, 19, 19, Typography.amp, 15, '.', 15, '.', '+', '-', ',', Typography.dollar, 7, '\''}, 64 - (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)), objArr8);
                    String str2 = (String) objArr8[0];
                    Object[] objArr9 = new Object[1];
                    b((byte) (KeyEvent.normalizeMetaState(0) + 77), new char[]{29, '0', 30, '+', 19, Typography.amp, 31, 6, 13807, 13807, Typography.dollar, ',', '*', Typography.dollar, 19, '\'', 22, Typography.quote, 4, '\n', 30, '0', 21, ')', '%', JSONLexer.EOI, 16, Typography.amp, 13897, 13897, '#', '/', '\'', '\f', 30, ')', '/', '%', '\t', ',', ',', 30, '-', 1, '\'', 16, 23, '0', 24, 16, '+', 28, 29, '0', 27, '\t', ')', '\f', 16, 3, 27, '\t', '\n', 20}, KeyEvent.normalizeMetaState(0) + 64, objArr9);
                    String str3 = (String) objArr9[0];
                    Object[] objArr10 = new Object[1];
                    b((byte) (109 - ImageFormat.getBitsPerPixel(0)), new char[]{3, '.', '*', 31, '(', '!', 13859, 13859, '\r', 25, '\r', JSONLexer.EOI, '-', 3, 11, '\'', Typography.quote, 22, '.', '+', JSONLexer.EOI, Typography.quote, 3, '-', '#', '\b', 25, Typography.quote, '\f', InputCardNumberView.DIVIDER, 21, '\n', 25, Typography.quote, 31, Typography.dollar, '+', 14, '(', 4, 21, Typography.quote, JSONLexer.EOI, '\f', JSONLexer.EOI, 19, '+', Typography.dollar, 31, '/', 4, JSONLexer.EOI, '!', 6, InputCardNumberView.DIVIDER, 22, '!', '\b', '/', 31}, 60 - Color.argb(0, 0, 0, 0), objArr10);
                    String str4 = (String) objArr10[0];
                    Object[] objArr11 = new Object[1];
                    b((byte) ((ViewConfiguration.getTapTimeout() >> 16) + 21), new char[]{24, '-', '\n', '-', 29, '0'}, 6 - Color.red(0), objArr11);
                    try {
                        Object[] objArr12 = {applicationContext, str, str2, str3, str4, true, (String) objArr11[0], 995651014};
                        Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-1276397751);
                        if (obj2 == null) {
                            obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(View.MeasureSpec.getSize(0) + 911, 17 - Process.getGidForName(""), (char) (ViewConfiguration.getJumpTapTimeout() >> 16))).getMethod("getAuthRequestContext", Context.class, String.class, String.class, String.class, String.class, Boolean.TYPE, String.class, Integer.TYPE);
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
                a(b, b2, (byte) (b2 | 36), objArr13);
                Class<?> cls2 = Class.forName((String) objArr13[0]);
                byte b3 = PlaceComponentResult[7];
                byte b4 = PlaceComponentResult[25];
                Object[] objArr14 = new Object[1];
                a(b3, b4, (byte) (b4 | Ascii.NAK), objArr14);
                try {
                    Object[] objArr15 = {applicationContext2, Integer.valueOf(((Integer) cls2.getMethod((String) objArr14[0], Object.class).invoke(null, this)).intValue())};
                    Object obj3 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1691739267);
                    if (obj3 == null) {
                        Class cls3 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(TextUtils.getOffsetAfter("", 0) + 55, 4 - (SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)), (char) (ViewConfiguration.getWindowTouchSlop() >> 8));
                        byte b5 = $$a[47];
                        Object[] objArr16 = new Object[1];
                        c(b5, b5, $$a[78], objArr16);
                        obj3 = cls3.getMethod((String) objArr16[0], Context.class, Integer.TYPE);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1691739267, obj3);
                    }
                    Object invoke2 = ((Method) obj3).invoke(null, objArr15);
                    try {
                        Object obj4 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(40157535);
                        if (obj4 == null) {
                            obj4 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getTouchSlop() >> 8) + 800, Gravity.getAbsoluteGravity(0, 0) + 15, (char) (Process.myPid() >> 22))).getMethod("getAuthRequestContext", null);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(40157535, obj4);
                        }
                        int intValue2 = ((Integer) ((Method) obj4).invoke(invoke2, null)).intValue();
                        try {
                            Object obj5 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1621779126);
                            if (obj5 == null) {
                                obj5 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(View.resolveSize(0, 0) + 800, (Process.myTid() >> 22) + 15, (char) Color.blue(0))).getMethod("PlaceComponentResult", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1621779126, obj5);
                            }
                            if (((Integer) ((Method) obj5).invoke(invoke2, null)).intValue() != intValue2) {
                                ArrayList arrayList = new ArrayList();
                                try {
                                    Object[] objArr17 = {invoke2};
                                    Object obj6 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(658700871);
                                    if (obj6 == null) {
                                        obj6 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)) + 814, 29 - TextUtils.indexOf("", ""), (char) (57994 - (ViewConfiguration.getScrollBarSize() >> 8)))).getMethod("getAuthRequestContext", (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(801 - (SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)), (ViewConfiguration.getEdgeSlop() >> 16) + 15, (char) (ImageFormat.getBitsPerPixel(0) + 1)));
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
                                            obj7 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(KeyEvent.normalizeMetaState(0) + PDF417Common.NUMBER_OF_CODEWORDS, ExpandableListView.getPackedPositionType(0L) + 35, (char) View.MeasureSpec.makeMeasureSpec(0, 0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj7);
                                        }
                                        Object invoke3 = ((Method) obj7).invoke(objArr, objArr);
                                        try {
                                            Object[] objArr18 = {1629208408, Long.valueOf(j), arrayList, LauncherActivity.getAuid()};
                                            Object obj8 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                            if (obj8 == null) {
                                                obj8 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - TextUtils.indexOf("", ""), (ViewConfiguration.getFadingEdgeLength() >> 16) + 18, (char) (ExpandableListView.getPackedPositionChild(0L) + 1))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                byte b6 = PlaceComponentResult[25];
                byte b7 = b6;
                Object[] objArr19 = new Object[1];
                a(b6, b7, (byte) (b7 | 36), objArr19);
                Class<?> cls4 = Class.forName((String) objArr19[0]);
                byte b8 = PlaceComponentResult[7];
                byte b9 = PlaceComponentResult[25];
                Object[] objArr20 = new Object[1];
                a(b8, b9, (byte) (b9 | Ascii.NAK), objArr20);
                try {
                    Object[] objArr21 = {applicationContext3, Integer.valueOf(((Integer) cls4.getMethod((String) objArr20[0], Object.class).invoke(null, this)).intValue())};
                    Object obj9 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(345757441);
                    if (obj9 == null) {
                        Class cls5 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(((byte) KeyEvent.getModifierMetaStateMask()) + 62, 46 - (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)), (char) (KeyEvent.getMaxKeyCode() >> 16));
                        Object[] objArr22 = new Object[1];
                        c((byte) (-$$a[9]), (byte) ($$a[47] - 1), (byte) (-$$a[28]), objArr22);
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
                                obj10 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getScrollBarFadeDuration() >> 16) + PDF417Common.NUMBER_OF_CODEWORDS, (ViewConfiguration.getEdgeSlop() >> 16) + 35, (char) (ViewConfiguration.getKeyRepeatDelay() >> 16))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj10);
                            }
                            Object invoke4 = ((Method) obj10).invoke(objArr2, objArr2);
                            try {
                                Object[] objArr24 = {1629208408, Long.valueOf(j2), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj11 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj11 == null) {
                                    obj11 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getScrollBarFadeDuration() >> 16) + 911, 17 - TextUtils.indexOf((CharSequence) "", '0'), (char) (ViewConfiguration.getPressedStateDuration() >> 16))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                byte b10 = PlaceComponentResult[25];
                byte b11 = b10;
                Object[] objArr25 = new Object[1];
                a(b10, b11, (byte) (b11 | 36), objArr25);
                Class<?> cls6 = Class.forName((String) objArr25[0]);
                byte b12 = PlaceComponentResult[7];
                byte b13 = PlaceComponentResult[25];
                Object[] objArr26 = new Object[1];
                a(b12, b13, (byte) (b13 | Ascii.NAK), objArr26);
                try {
                    Object[] objArr27 = {applicationContext4, Integer.valueOf(((Integer) cls6.getMethod((String) objArr26[0], Object.class).invoke(null, this)).intValue())};
                    Object obj12 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-697999596);
                    if (obj12 == null) {
                        Class cls7 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(MotionEvent.axisFromString("") + 119, 3 - (ViewConfiguration.getScrollBarSize() >> 8), (char) (Color.green(0) + 38968));
                        Object[] objArr28 = new Object[1];
                        c((byte) (-$$a[9]), (byte) ($$a[47] - 1), (byte) (-$$a[28]), objArr28);
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
                                obj13 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(930 - (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)), View.getDefaultSize(0, 0) + 35, (char) (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj13);
                            }
                            Object invoke5 = ((Method) obj13).invoke(objArr3, objArr3);
                            try {
                                Object[] objArr30 = {1629208408, Long.valueOf(j3), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj14 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj14 == null) {
                                    obj14 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - (CdmaCellLocation.convertQuartSecToDecDegrees(0) > FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 0 : -1)), 18 - (ViewConfiguration.getScrollBarSize() >> 8), (char) Color.red(0))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                byte b14 = PlaceComponentResult[25];
                byte b15 = b14;
                Object[] objArr31 = new Object[1];
                a(b14, b15, (byte) (b15 | 36), objArr31);
                Class<?> cls8 = Class.forName((String) objArr31[0]);
                byte b16 = PlaceComponentResult[7];
                byte b17 = PlaceComponentResult[25];
                Object[] objArr32 = new Object[1];
                a(b16, b17, (byte) (b17 | Ascii.NAK), objArr32);
                try {
                    Object[] objArr33 = {applicationContext5, Integer.valueOf(((Integer) cls8.getMethod((String) objArr32[0], Object.class).invoke(null, this)).intValue())};
                    Object obj15 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-16683571);
                    if (obj15 == null) {
                        Class cls9 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(TextUtils.indexOf((CharSequence) "", '0', 0, 0) + 108, (Process.myTid() >> 22) + 3, (char) ((-1) - TextUtils.lastIndexOf("", '0', 0)));
                        Object[] objArr34 = new Object[1];
                        c((byte) ($$a[47] - 1), (byte) (-$$a[8]), $$a[40], objArr34);
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
                                method = obj16;
                                objArr4 = null;
                            } else {
                                objArr4 = null;
                                method = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - (ViewConfiguration.getMaximumFlingVelocity() >> 16), 34 - TextUtils.indexOf((CharSequence) "", '0', 0, 0), (char) (CdmaCellLocation.convertQuartSecToDecDegrees(0) > FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 0 : -1)))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, method);
                            }
                            Object invoke6 = ((Method) method).invoke(objArr4, objArr4);
                            try {
                                Object[] objArr36 = {1629208408, Long.valueOf(j4), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj17 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj17 == null) {
                                    obj17 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - (ViewConfiguration.getWindowTouchSlop() >> 8), Color.blue(0) + 18, (char) (ViewConfiguration.getMaximumFlingVelocity() >> 16))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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

    @Override // id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.content.ContextWrapper, android.content.Context
    public final Context getApplicationContext() {
        return super.getApplicationContext();
    }

    @Override // id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.content.ContextWrapper
    public final Context getBaseContext() {
        return super.getBaseContext();
    }

    @Override // id.dana.base.BaseActivity
    public final int getLayout() {
        return R.layout.dialog_missing_required_user_info;
    }

    @Override // id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public final Resources getResources() {
        return super.getResources();
    }

    @Override // id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onPause() {
        Context baseContext = getBaseContext();
        if (baseContext == null) {
            try {
                Object[] objArr = new Object[1];
                a(PlaceComponentResult[32], (byte) (-PlaceComponentResult[30]), PlaceComponentResult[9], objArr);
                Class<?> cls = Class.forName((String) objArr[0]);
                Object[] objArr2 = new Object[1];
                a(PlaceComponentResult[13], PlaceComponentResult[56], PlaceComponentResult[59], objArr2);
                Object[] objArr3 = new Object[1];
                b((byte) (((ApplicationInfo) cls.getMethod((String) objArr2[0], null).invoke(this, null)).targetSdkVersion + 5), new char[]{JSONLexer.EOI, '\r', 18, '\'', 16, 20, '\n', '\'', 21, Typography.quote, 31, '#', '/', '+', '/', 17, JSONLexer.EOI, 18, ',', '\n', 1, 5, '!', 30, 25, '\r'}, getPackageName().length() + 19, objArr3);
                Class<?> cls2 = Class.forName((String) objArr3[0]);
                Object[] objArr4 = new Object[1];
                b((byte) ((ViewConfiguration.getKeyRepeatTimeout() >> 16) + 54), new char[]{0, 14, 13854, 13854, '!', '\b', '.', '/', 13856, 13856, 5, JSONLexer.EOI, '0', 21, '/', 17, 19, '\b'}, 18 - (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)), objArr4);
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
                    obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getJumpTapTimeout() >> 16) + PDF417Common.NUMBER_OF_CODEWORDS, 34 - ExpandableListView.getPackedPositionChild(0L), (char) ('0' - AndroidCharacter.getMirror('0')))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                }
                Object invoke = ((Method) obj).invoke(null, null);
                try {
                    Object[] objArr5 = {baseContext};
                    Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-549958681);
                    if (obj2 == null) {
                        obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - View.resolveSize(0, 0), 19 - (SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)), (char) ((-1) - ExpandableListView.getPackedPositionChild(0L)))).getMethod("MyBillsEntityDataFactory", Context.class);
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

    @Override // id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onResume() {
        Context baseContext = getBaseContext();
        if (baseContext == null) {
            try {
                Object[] objArr = new Object[1];
                a(PlaceComponentResult[32], (byte) (-PlaceComponentResult[30]), PlaceComponentResult[9], objArr);
                Class<?> cls = Class.forName((String) objArr[0]);
                Object[] objArr2 = new Object[1];
                a(PlaceComponentResult[13], PlaceComponentResult[56], PlaceComponentResult[59], objArr2);
                Object[] objArr3 = new Object[1];
                b((byte) (((ApplicationInfo) cls.getMethod((String) objArr2[0], null).invoke(this, null)).targetSdkVersion + 5), new char[]{JSONLexer.EOI, '\r', 18, '\'', 16, 20, '\n', '\'', 21, Typography.quote, 31, '#', '/', '+', '/', 17, JSONLexer.EOI, 18, ',', '\n', 1, 5, '!', 30, 25, '\r'}, 26 - (ViewConfiguration.getLongPressTimeout() >> 16), objArr3);
                Class<?> cls2 = Class.forName((String) objArr3[0]);
                Object[] objArr4 = new Object[1];
                b((byte) (super.getResources().getString(R.string.contact_not_found_message).substring(14, 15).length() + 53), new char[]{0, 14, 13854, 13854, '!', '\b', '.', '/', 13856, 13856, 5, JSONLexer.EOI, '0', 21, '/', 17, 19, '\b'}, super.getResources().getString(R.string.check_availability_voucher).substring(0, 1).length() + 17, objArr4);
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
                    obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(930 - (Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1)), 35 - (ViewConfiguration.getScrollDefaultDelay() >> 16), (char) (ViewConfiguration.getJumpTapTimeout() >> 16))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                }
                Object invoke = ((Method) obj).invoke(null, null);
                try {
                    Object[] objArr5 = {baseContext};
                    Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(247288059);
                    if (obj2 == null) {
                        obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getLongPressTimeout() >> 16) + 911, View.combineMeasuredStates(0, 0) + 18, (char) (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)))).getMethod("KClassImpl$Data$declaredNonStaticMembers$2", Context.class);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(247288059, obj2);
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
        super.onResume();
    }

    @JvmName(name = "getReadLinkPropertiesPresenter")
    public final ReadLinkPropertiesContract.Presenter getReadLinkPropertiesPresenter() {
        ReadLinkPropertiesContract.Presenter presenter = this.readLinkPropertiesPresenter;
        if (presenter != null) {
            return presenter;
        }
        Intrinsics.throwUninitializedPropertyAccessException("");
        return null;
    }

    @JvmName(name = "setReadLinkPropertiesPresenter")
    public final void setReadLinkPropertiesPresenter(ReadLinkPropertiesContract.Presenter presenter) {
        Intrinsics.checkNotNullParameter(presenter, "");
        this.readLinkPropertiesPresenter = presenter;
    }

    @Override // id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onCreate(Bundle savedInstanceState) {
        Object[] objArr;
        try {
            Object[] objArr2 = new Object[1];
            a(PlaceComponentResult[32], (byte) (-PlaceComponentResult[30]), PlaceComponentResult[9], objArr2);
            Class<?> cls = Class.forName((String) objArr2[0]);
            Object[] objArr3 = new Object[1];
            a(PlaceComponentResult[13], PlaceComponentResult[56], PlaceComponentResult[59], objArr3);
            Object[] objArr4 = new Object[1];
            b((byte) (((ApplicationInfo) cls.getMethod((String) objArr3[0], null).invoke(this, null)).targetSdkVersion + 10), new char[]{JSONLexer.EOI, '\r', 18, '\'', 16, 20, '\n', '\'', 19, 29, '%', 17, 29, 18, '+', 28, 13844, 13844}, super.getResources().getString(R.string.pushverify_list_login).substring(0, 6).codePointAt(4) - 92, objArr4);
            Class<?> cls2 = Class.forName((String) objArr4[0]);
            try {
                Object[] objArr5 = new Object[1];
                a(PlaceComponentResult[32], (byte) (-PlaceComponentResult[30]), PlaceComponentResult[9], objArr5);
                Class<?> cls3 = Class.forName((String) objArr5[0]);
                a(PlaceComponentResult[13], PlaceComponentResult[56], PlaceComponentResult[59], new Object[1]);
                byte b = (byte) (((ApplicationInfo) cls3.getMethod((String) r15[0], null).invoke(this, null)).targetSdkVersion - 26);
                char[] cArr = {'%', 11, '!', 16, 13829};
                try {
                    Object[] objArr6 = new Object[1];
                    a(PlaceComponentResult[32], (byte) (-PlaceComponentResult[30]), PlaceComponentResult[9], objArr6);
                    Class<?> cls4 = Class.forName((String) objArr6[0]);
                    a(PlaceComponentResult[13], PlaceComponentResult[56], PlaceComponentResult[59], new Object[1]);
                    Object[] objArr7 = new Object[1];
                    b(b, cArr, ((ApplicationInfo) cls4.getMethod((String) r12[0], null).invoke(this, null)).targetSdkVersion - 28, objArr7);
                    int intValue = ((Integer) cls2.getDeclaredMethod((String) objArr7[0], new Class[0]).invoke(null, new Object[0])).intValue() % 100000;
                    if (intValue < 99000 || intValue > 99999) {
                        Context baseContext = getBaseContext();
                        if (baseContext == null) {
                            Object[] objArr8 = new Object[1];
                            b((byte) (super.getResources().getString(R.string.telephone_description).substring(4, 5).length() + 37), new char[]{JSONLexer.EOI, '\r', 18, '\'', 16, 20, '\n', '\'', 21, Typography.quote, 31, '#', '/', '+', '/', 17, JSONLexer.EOI, 18, ',', '\n', 1, 5, '!', 30, 25, '\r'}, super.getResources().getString(R.string.mybills_tooltip_description_null_amount).substring(7, 8).length() + 25, objArr8);
                            Class<?> cls5 = Class.forName((String) objArr8[0]);
                            Object[] objArr9 = new Object[1];
                            b((byte) (getPackageName().length() + 47), new char[]{0, 14, 13854, 13854, '!', '\b', '.', '/', 13856, 13856, 5, JSONLexer.EOI, '0', 21, '/', 17, 19, '\b'}, (SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)) + 17, objArr9);
                            baseContext = (Context) cls5.getMethod((String) objArr9[0], new Class[0]).invoke(null, null);
                        }
                        if (baseContext != null) {
                            baseContext = baseContext.getApplicationContext();
                        }
                        if (baseContext != null) {
                            try {
                                Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                                if (obj == null) {
                                    obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)) + PDF417Common.MAX_CODEWORDS_IN_BARCODE, TextUtils.indexOf((CharSequence) "", '0') + 36, (char) (ViewConfiguration.getKeyRepeatDelay() >> 16))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                                }
                                Object invoke = ((Method) obj).invoke(null, null);
                                Object[] objArr10 = new Object[1];
                                b((byte) (super.getResources().getString(R.string.scanner).substring(4, 5).codePointAt(0) - 8), new char[]{'#', '/', '\t', ',', 25, 18, 16, Typography.amp, Typography.dollar, '!', ',', 21, 30, 28, ',', 1, 13841, 13841, 6, 23, 7, '.', ',', 0, 7, '\'', '\'', '\t', InputCardNumberView.DIVIDER, '\r', 22, Typography.quote, 16, 3, 31, 20, 24, 16, '\'', 16, '%', JSONLexer.EOI, 4, 3, '*', '%', 1, 30}, (ViewConfiguration.getMaximumDrawingCacheSize() >> 24) + 48, objArr10);
                                String str = (String) objArr10[0];
                                Object[] objArr11 = new Object[1];
                                b((byte) (21 - (ViewConfiguration.getScrollBarSize() >> 8)), new char[]{Typography.quote, 20, 4, '\t', 24, 16, 16, '\'', 7, '.', 20, '\n', '\b', '.', '-', 1, 13757, 13757, 22, ',', '\b', '.', 0, '%', '\t', 2, 15, 31, '\'', '\t', 13757, 13757, '.', 7, 2, Typography.amp, 13838, 13838, 14, '\'', 11, 20, Typography.dollar, 1, '/', '#', '/', Typography.dollar, 13758, 13758, Typography.amp, 19, 19, Typography.amp, 15, '.', 15, '.', '+', '-', ',', Typography.dollar, 7, '\''}, 64 - (ViewConfiguration.getMaximumFlingVelocity() >> 16), objArr11);
                                String str2 = (String) objArr11[0];
                                byte codePointAt = (byte) (getPackageName().codePointAt(4) - 20);
                                char[] cArr2 = {29, '0', 30, '+', 19, Typography.amp, 31, 6, 13807, 13807, Typography.dollar, ',', '*', Typography.dollar, 19, '\'', 22, Typography.quote, 4, '\n', 30, '0', 21, ')', '%', JSONLexer.EOI, 16, Typography.amp, 13897, 13897, '#', '/', '\'', '\f', 30, ')', '/', '%', '\t', ',', ',', 30, '-', 1, '\'', 16, 23, '0', 24, 16, '+', 28, 29, '0', 27, '\t', ')', '\f', 16, 3, 27, '\t', '\n', 20};
                                try {
                                    Object[] objArr12 = new Object[1];
                                    a(PlaceComponentResult[32], (byte) (-PlaceComponentResult[30]), PlaceComponentResult[9], objArr12);
                                    Class<?> cls6 = Class.forName((String) objArr12[0]);
                                    Object[] objArr13 = new Object[1];
                                    a(PlaceComponentResult[13], PlaceComponentResult[56], PlaceComponentResult[59], objArr13);
                                    Object[] objArr14 = new Object[1];
                                    b(codePointAt, cArr2, ((ApplicationInfo) cls6.getMethod((String) objArr13[0], null).invoke(this, null)).targetSdkVersion + 31, objArr14);
                                    String str3 = (String) objArr14[0];
                                    byte length = (byte) (super.getResources().getString(R.string.prompt_desc_suggest_to_logout).substring(18, 20).length() + 108);
                                    char[] cArr3 = {3, '.', '*', 31, '(', '!', 13859, 13859, '\r', 25, '\r', JSONLexer.EOI, '-', 3, 11, '\'', Typography.quote, 22, '.', '+', JSONLexer.EOI, Typography.quote, 3, '-', '#', '\b', 25, Typography.quote, '\f', InputCardNumberView.DIVIDER, 21, '\n', 25, Typography.quote, 31, Typography.dollar, '+', 14, '(', 4, 21, Typography.quote, JSONLexer.EOI, '\f', JSONLexer.EOI, 19, '+', Typography.dollar, 31, '/', 4, JSONLexer.EOI, '!', 6, InputCardNumberView.DIVIDER, 22, '!', '\b', '/', 31};
                                    try {
                                        Object[] objArr15 = new Object[1];
                                        a(PlaceComponentResult[32], (byte) (-PlaceComponentResult[30]), PlaceComponentResult[9], objArr15);
                                        Class<?> cls7 = Class.forName((String) objArr15[0]);
                                        Object[] objArr16 = new Object[1];
                                        a(PlaceComponentResult[13], PlaceComponentResult[56], PlaceComponentResult[59], objArr16);
                                        Object[] objArr17 = new Object[1];
                                        b(length, cArr3, ((ApplicationInfo) cls7.getMethod((String) objArr16[0], null).invoke(this, null)).targetSdkVersion + 27, objArr17);
                                        String str4 = (String) objArr17[0];
                                        try {
                                            Object[] objArr18 = new Object[1];
                                            a(PlaceComponentResult[32], (byte) (-PlaceComponentResult[30]), PlaceComponentResult[9], objArr18);
                                            Class<?> cls8 = Class.forName((String) objArr18[0]);
                                            a(PlaceComponentResult[13], PlaceComponentResult[56], PlaceComponentResult[59], new Object[1]);
                                            Object[] objArr19 = new Object[1];
                                            b((byte) (((ApplicationInfo) cls8.getMethod((String) r14[0], null).invoke(this, null)).targetSdkVersion - 12), new char[]{24, '-', '\n', '-', 29, '0'}, super.getResources().getString(R.string.saving_fashion).substring(0, 7).length() - 1, objArr19);
                                            try {
                                                Object[] objArr20 = {baseContext, str, str2, str3, str4, true, (String) objArr19[0], 995651014};
                                                Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-1276397751);
                                                if (obj2 == null) {
                                                    obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - View.MeasureSpec.makeMeasureSpec(0, 0), (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)) + 17, (char) (ViewConfiguration.getMaximumDrawingCacheSize() >> 24))).getMethod("getAuthRequestContext", Context.class, String.class, String.class, String.class, String.class, Boolean.TYPE, String.class, Integer.TYPE);
                                                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(-1276397751, obj2);
                                                }
                                                ((Method) obj2).invoke(invoke, objArr20);
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
                        byte b2 = PlaceComponentResult[25];
                        byte b3 = b2;
                        Object[] objArr21 = new Object[1];
                        a(b2, b3, (byte) (b3 | 36), objArr21);
                        Class<?> cls9 = Class.forName((String) objArr21[0]);
                        byte b4 = PlaceComponentResult[7];
                        byte b5 = PlaceComponentResult[25];
                        Object[] objArr22 = new Object[1];
                        a(b4, b5, (byte) (b5 | Ascii.NAK), objArr22);
                        try {
                            Object[] objArr23 = {Integer.valueOf(((Integer) cls9.getMethod((String) objArr22[0], Object.class).invoke(null, this)).intValue())};
                            Object obj3 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(25207140);
                            if (obj3 == null) {
                                Class cls10 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(494 - Drawable.resolveOpacity(0, 0), 4 - (ViewConfiguration.getFadingEdgeLength() >> 16), (char) TextUtils.getCapsMode("", 0, 0));
                                Object[] objArr24 = new Object[1];
                                c((byte) ($$a[47] - 1), (byte) (-$$a[8]), $$a[40], objArr24);
                                obj3 = cls10.getMethod((String) objArr24[0], Integer.TYPE);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(25207140, obj3);
                            }
                            Object[] objArr25 = (Object[]) ((Method) obj3).invoke(null, objArr23);
                            int i = ((int[]) objArr25[1])[0];
                            if (((int[]) objArr25[0])[0] != i) {
                                long j = ((r2 ^ i) & 4294967295L) | 42949672960L;
                                try {
                                    Object obj4 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                                    if (obj4 != null) {
                                        objArr = null;
                                    } else {
                                        objArr = null;
                                        obj4 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(Gravity.getAbsoluteGravity(0, 0) + PDF417Common.NUMBER_OF_CODEWORDS, View.resolveSize(0, 0) + 35, (char) (1 - (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1))))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj4);
                                    }
                                    Object invoke2 = ((Method) obj4).invoke(objArr, objArr);
                                    try {
                                        Object[] objArr26 = {907938457, Long.valueOf(j), new ArrayList(), LauncherActivity.getAuid()};
                                        Object obj5 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                        if (obj5 == null) {
                                            obj5 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - (ViewConfiguration.getLongPressTimeout() >> 16), 18 - View.MeasureSpec.getMode(0), (char) TextUtils.indexOf("", "", 0, 0))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                            overridePendingTransition(17432576, 17432577);
                            setRequestedOrientation(Build.VERSION.SDK_INT == 26 ? -1 : 1);
                            super.onCreate(savedInstanceState);
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

    @Override // androidx.view.ComponentActivity, android.app.Activity
    public final void onBackPressed() {
        finish();
        EventBus.getDefault().post(new ShowAgreementBridge.AgreementMessageEvent(false, "003"));
    }

    private final HashMap<String, ? extends String> getAuthRequestContext() {
        StartParams startParams = this.KClassImpl$Data$declaredNonStaticMembers$2;
        StartParams startParams2 = null;
        if (startParams == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            startParams = null;
        }
        if (startParams.getKClassImpl$Data$declaredNonStaticMembers$2()) {
            Pair[] pairArr = new Pair[4];
            StartParams startParams3 = this.KClassImpl$Data$declaredNonStaticMembers$2;
            if (startParams3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
                startParams3 = null;
            }
            pairArr[0] = TuplesKt.to("appId", startParams3.scheduleImpl);
            StartParams startParams4 = this.KClassImpl$Data$declaredNonStaticMembers$2;
            if (startParams4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
                startParams4 = null;
            }
            pairArr[1] = TuplesKt.to("authClientId", startParams4.PlaceComponentResult);
            StartParams startParams5 = this.KClassImpl$Data$declaredNonStaticMembers$2;
            if (startParams5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
                startParams5 = null;
            }
            pairArr[2] = TuplesKt.to("merchantId", startParams5.BuiltInFictitiousFunctionClassFactory);
            StartParams startParams6 = this.KClassImpl$Data$declaredNonStaticMembers$2;
            if (startParams6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
            } else {
                startParams2 = startParams6;
            }
            pairArr[3] = TuplesKt.to("scopes", StringsKt.replace$default(startParams2.MyBillsEntityDataFactory, ",", "%2C", false, 4, (Object) null));
            return MapsKt.hashMapOf(pairArr);
        }
        Pair[] pairArr2 = new Pair[2];
        StartParams startParams7 = this.KClassImpl$Data$declaredNonStaticMembers$2;
        if (startParams7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            startParams7 = null;
        }
        pairArr2[0] = TuplesKt.to(DanaH5.SERVICE_KEY, startParams7.scheduleImpl);
        StartParams startParams8 = this.KClassImpl$Data$declaredNonStaticMembers$2;
        if (startParams8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
        } else {
            startParams2 = startParams8;
        }
        pairArr2[1] = TuplesKt.to("scopes", StringsKt.replace$default(startParams2.MyBillsEntityDataFactory, ",", "%2C", false, 4, (Object) null));
        return MapsKt.hashMapOf(pairArr2);
    }

    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u000e\n\u0002\u0010 \n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001BW\u0012\u0006\u0010\u0006\u001a\u00020\u000b\u0012\u0006\u0010\u000f\u001a\u00020\u000b\u0012\b\u0010!\u001a\u0004\u0018\u00010\u000b\u0012\u0006\u0010\"\u001a\u00020\u000b\u0012\b\u0010#\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010$\u001a\u0004\u0018\u00010\u000b\u0012\u0006\u0010%\u001a\u00020\u0007\u0012\u0010\b\u0002\u0010&\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u001f¢\u0006\u0004\b'\u0010(J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÖ\u0003¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\n\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\n\u0010\u0004J\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ \u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0006\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012R\u0013\u0010\u0015\u001a\u0004\u0018\u00010\u000bX\u0006¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0013\u0010\u0017\u001a\u0004\u0018\u00010\u000bX\u0006¢\u0006\u0006\n\u0004\b\u0016\u0010\u0014R\u0017\u0010\u001a\u001a\u00020\u00078\u0007¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u0013\u0010\u0016\u001a\u0004\u0018\u00010\u000bX\u0007¢\u0006\u0006\n\u0004\b\u0017\u0010\u0014R\u0011\u0010\u0013\u001a\u00020\u000bX\u0007¢\u0006\u0006\n\u0004\b\u001a\u0010\u0014R\u0011\u0010\u001c\u001a\u00020\u000bX\u0007¢\u0006\u0006\n\u0004\b\u0015\u0010\u0014R\u0011\u0010\u001e\u001a\u00020\u000bX\u0007¢\u0006\u0006\n\u0004\b\u001d\u0010\u0014R\u0019\u0010\u001d\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u001fX\u0007¢\u0006\u0006\n\u0004\b\u001c\u0010 "}, d2 = {"Lid/dana/miniprogram/tnc/MissingRequiredUserInfoDialogActivity$StartParams;", "Landroid/os/Parcelable;", "", "describeContents", "()I", "", "p0", "", "equals", "(Ljava/lang/Object;)Z", "hashCode", "", "toString", "()Ljava/lang/String;", "Landroid/os/Parcel;", "p1", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "MyBillsEntityDataFactory", "Ljava/lang/String;", "PlaceComponentResult", "BuiltInFictitiousFunctionClassFactory", "getAuthRequestContext", "lookAheadTest", "Z", "KClassImpl$Data$declaredNonStaticMembers$2", "()Z", "scheduleImpl", "moveToNextValue", "getErrorConfigVersion", "", "Ljava/util/List;", "p2", "p3", "p4", "p5", "p6", "p7", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/util/List;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final /* data */ class StartParams implements Parcelable {
        public static final Parcelable.Creator<StartParams> CREATOR = new Creator();

        /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
        final String getAuthRequestContext;

        /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
        final String MyBillsEntityDataFactory;

        /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
        final String PlaceComponentResult;

        /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
        final String scheduleImpl;

        /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
        final String BuiltInFictitiousFunctionClassFactory;

        /* renamed from: lookAheadTest  reason: from kotlin metadata */
        private final boolean KClassImpl$Data$declaredNonStaticMembers$2;

        /* renamed from: moveToNextValue  reason: from kotlin metadata */
        final String getErrorConfigVersion;

        /* renamed from: scheduleImpl  reason: from kotlin metadata */
        final List<String> moveToNextValue;

        @Override // android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        public final boolean equals(Object p0) {
            if (this == p0) {
                return true;
            }
            if (p0 instanceof StartParams) {
                StartParams startParams = (StartParams) p0;
                return Intrinsics.areEqual(this.scheduleImpl, startParams.scheduleImpl) && Intrinsics.areEqual(this.getErrorConfigVersion, startParams.getErrorConfigVersion) && Intrinsics.areEqual(this.getAuthRequestContext, startParams.getAuthRequestContext) && Intrinsics.areEqual(this.MyBillsEntityDataFactory, startParams.MyBillsEntityDataFactory) && Intrinsics.areEqual(this.PlaceComponentResult, startParams.PlaceComponentResult) && Intrinsics.areEqual(this.BuiltInFictitiousFunctionClassFactory, startParams.BuiltInFictitiousFunctionClassFactory) && this.KClassImpl$Data$declaredNonStaticMembers$2 == startParams.KClassImpl$Data$declaredNonStaticMembers$2 && Intrinsics.areEqual(this.moveToNextValue, startParams.moveToNextValue);
            }
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final int hashCode() {
            int hashCode = this.scheduleImpl.hashCode();
            int hashCode2 = this.getErrorConfigVersion.hashCode();
            String str = this.getAuthRequestContext;
            int hashCode3 = str == null ? 0 : str.hashCode();
            int hashCode4 = this.MyBillsEntityDataFactory.hashCode();
            String str2 = this.PlaceComponentResult;
            int hashCode5 = str2 == null ? 0 : str2.hashCode();
            String str3 = this.BuiltInFictitiousFunctionClassFactory;
            int hashCode6 = str3 == null ? 0 : str3.hashCode();
            boolean z = this.KClassImpl$Data$declaredNonStaticMembers$2;
            int i = z;
            if (z != 0) {
                i = 1;
            }
            List<String> list = this.moveToNextValue;
            return (((((((((((((hashCode * 31) + hashCode2) * 31) + hashCode3) * 31) + hashCode4) * 31) + hashCode5) * 31) + hashCode6) * 31) + i) * 31) + (list != null ? list.hashCode() : 0);
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("StartParams(scheduleImpl=");
            sb.append(this.scheduleImpl);
            sb.append(", getErrorConfigVersion=");
            sb.append(this.getErrorConfigVersion);
            sb.append(", getAuthRequestContext=");
            sb.append(this.getAuthRequestContext);
            sb.append(", MyBillsEntityDataFactory=");
            sb.append(this.MyBillsEntityDataFactory);
            sb.append(", PlaceComponentResult=");
            sb.append(this.PlaceComponentResult);
            sb.append(", BuiltInFictitiousFunctionClassFactory=");
            sb.append(this.BuiltInFictitiousFunctionClassFactory);
            sb.append(", KClassImpl$Data$declaredNonStaticMembers$2=");
            sb.append(this.KClassImpl$Data$declaredNonStaticMembers$2);
            sb.append(", moveToNextValue=");
            sb.append(this.moveToNextValue);
            sb.append(')');
            return sb.toString();
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(Parcel p0, int p1) {
            Intrinsics.checkNotNullParameter(p0, "");
            p0.writeString(this.scheduleImpl);
            p0.writeString(this.getErrorConfigVersion);
            p0.writeString(this.getAuthRequestContext);
            p0.writeString(this.MyBillsEntityDataFactory);
            p0.writeString(this.PlaceComponentResult);
            p0.writeString(this.BuiltInFictitiousFunctionClassFactory);
            p0.writeInt(this.KClassImpl$Data$declaredNonStaticMembers$2 ? 1 : 0);
            p0.writeStringList(this.moveToNextValue);
        }

        public StartParams(String str, String str2, String str3, String str4, String str5, String str6, boolean z, List<String> list) {
            Intrinsics.checkNotNullParameter(str, "");
            Intrinsics.checkNotNullParameter(str2, "");
            Intrinsics.checkNotNullParameter(str4, "");
            this.scheduleImpl = str;
            this.getErrorConfigVersion = str2;
            this.getAuthRequestContext = str3;
            this.MyBillsEntityDataFactory = str4;
            this.PlaceComponentResult = str5;
            this.BuiltInFictitiousFunctionClassFactory = str6;
            this.KClassImpl$Data$declaredNonStaticMembers$2 = z;
            this.moveToNextValue = list;
        }

        public /* synthetic */ StartParams(String str, String str2, String str3, String str4, String str5, String str6, boolean z, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, str2, str3, str4, str5, str6, z, (i & 128) != 0 ? null : list);
        }

        @JvmName(name = "KClassImpl$Data$declaredNonStaticMembers$2")
        /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from getter */
        public final boolean getKClassImpl$Data$declaredNonStaticMembers$2() {
            return this.KClassImpl$Data$declaredNonStaticMembers$2;
        }

        @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
        /* loaded from: classes5.dex */
        public static final class Creator implements Parcelable.Creator<StartParams> {
            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ StartParams createFromParcel(Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "");
                return new StartParams(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readInt() != 0, parcel.createStringArrayList());
            }

            @Override // android.os.Parcelable.Creator
            public final /* bridge */ /* synthetic */ StartParams[] newArray(int i) {
                return new StartParams[i];
            }
        }
    }

    public static /* synthetic */ void $r8$lambda$f6R_JZs7NkdCdnLQB8u1SA9mSgA(MissingRequiredUserInfoDialogActivity missingRequiredUserInfoDialogActivity, View view) {
        Intrinsics.checkNotNullParameter(missingRequiredUserInfoDialogActivity, "");
        missingRequiredUserInfoDialogActivity.finish();
        EventBus.getDefault().post(new ShowAgreementBridge.AgreementMessageEvent(false, "003"));
    }

    public static /* synthetic */ void $r8$lambda$fm44luA89yww2BJRLstKMezaDhY(final MissingRequiredUserInfoDialogActivity missingRequiredUserInfoDialogActivity, View view) {
        String authRequestContext;
        Intrinsics.checkNotNullParameter(missingRequiredUserInfoDialogActivity, "");
        StartParams startParams = missingRequiredUserInfoDialogActivity.KClassImpl$Data$declaredNonStaticMembers$2;
        if (startParams == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            startParams = null;
        }
        List<String> list = startParams.moveToNextValue;
        boolean z = false;
        if (list != null && list.size() == 1) {
            z = true;
        }
        if (z) {
            StartParams startParams2 = missingRequiredUserInfoDialogActivity.KClassImpl$Data$declaredNonStaticMembers$2;
            if (startParams2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
                startParams2 = null;
            }
            List<String> list2 = startParams2.moveToNextValue;
            if (StringsKt.equals(list2 != null ? (String) CollectionsKt.first((List) list2) : null, "email", true)) {
                authRequestContext = UrlUtil.getAuthRequestContext("/m/portal/emailSettings", missingRequiredUserInfoDialogActivity.getAuthRequestContext());
                DanaH5.startContainerFullUrlWithSendCredentials$default(UrlUtil.getAuthRequestContext(authRequestContext), new DanaH5Listener() { // from class: id.dana.miniprogram.tnc.MissingRequiredUserInfoDialogActivity$redirectToH5ForFillData$1
                    @Override // id.dana.utils.danah5.DanaH5Listener
                    public final /* synthetic */ void onContainerCreated(Bundle bundle) {
                        DanaH5Listener.CC.getAuthRequestContext();
                    }

                    @Override // id.dana.utils.danah5.DanaH5Listener
                    public final void onContainerDestroyed(Bundle p0) {
                        if (ShowAgreementBridge.INSTANCE.getConfirmUserInfo_wasCalled()) {
                            MissingRequiredUserInfoDialogActivity.this.finish();
                        }
                        ShowAgreementBridge.INSTANCE.setConfirmUserInfo_wasCalled(false);
                    }
                }, null, null, 12, null);
            }
        }
        authRequestContext = UrlUtil.getAuthRequestContext(DanaUrl.FILL_DATA_PAGE, missingRequiredUserInfoDialogActivity.getAuthRequestContext());
        DanaH5.startContainerFullUrlWithSendCredentials$default(UrlUtil.getAuthRequestContext(authRequestContext), new DanaH5Listener() { // from class: id.dana.miniprogram.tnc.MissingRequiredUserInfoDialogActivity$redirectToH5ForFillData$1
            @Override // id.dana.utils.danah5.DanaH5Listener
            public final /* synthetic */ void onContainerCreated(Bundle bundle) {
                DanaH5Listener.CC.getAuthRequestContext();
            }

            @Override // id.dana.utils.danah5.DanaH5Listener
            public final void onContainerDestroyed(Bundle p0) {
                if (ShowAgreementBridge.INSTANCE.getConfirmUserInfo_wasCalled()) {
                    MissingRequiredUserInfoDialogActivity.this.finish();
                }
                ShowAgreementBridge.INSTANCE.setConfirmUserInfo_wasCalled(false);
            }
        }, null, null, 12, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v4, types: [id.dana.contract.services.ServicesContract$View, kotlin.jvm.internal.DefaultConstructorMarker] */
    /* JADX WARN: Type inference failed for: r3v5 */
    @Override // id.dana.base.BaseActivity
    public final void init() {
        DaggerMissingRequiredUserInfoComponent.Builder PlaceComponentResult2 = DaggerMissingRequiredUserInfoComponent.PlaceComponentResult();
        PlaceComponentResult2.PlaceComponentResult = (ApplicationComponent) Preconditions.getAuthRequestContext(getApplicationComponent());
        DeepLinkModule.Builder KClassImpl$Data$declaredNonStaticMembers$2 = DeepLinkModule.KClassImpl$Data$declaredNonStaticMembers$2();
        MissingRequiredUserInfoDialogActivity missingRequiredUserInfoDialogActivity = this;
        KClassImpl$Data$declaredNonStaticMembers$2.MyBillsEntityDataFactory = missingRequiredUserInfoDialogActivity;
        byte b = 0;
        PlaceComponentResult2.BuiltInFictitiousFunctionClassFactory = (DeepLinkModule) Preconditions.getAuthRequestContext(new DeepLinkModule(KClassImpl$Data$declaredNonStaticMembers$2, b));
        ScanQrModule.Builder authRequestContext = ScanQrModule.getAuthRequestContext();
        authRequestContext.MyBillsEntityDataFactory = missingRequiredUserInfoDialogActivity;
        PlaceComponentResult2.NetworkUserEntityData$$ExternalSyntheticLambda0 = (ScanQrModule) Preconditions.getAuthRequestContext(new ScanQrModule(authRequestContext, b));
        RestoreUrlModule.Builder KClassImpl$Data$declaredNonStaticMembers$22 = RestoreUrlModule.KClassImpl$Data$declaredNonStaticMembers$2();
        KClassImpl$Data$declaredNonStaticMembers$22.getAuthRequestContext = missingRequiredUserInfoDialogActivity;
        PlaceComponentResult2.KClassImpl$Data$declaredNonStaticMembers$2 = (RestoreUrlModule) Preconditions.getAuthRequestContext(new RestoreUrlModule(KClassImpl$Data$declaredNonStaticMembers$22, b));
        FeatureModule.Builder MyBillsEntityDataFactory = FeatureModule.MyBillsEntityDataFactory();
        MyBillsEntityDataFactory.BuiltInFictitiousFunctionClassFactory = missingRequiredUserInfoDialogActivity;
        PlaceComponentResult2.MyBillsEntityDataFactory = (FeatureModule) Preconditions.getAuthRequestContext(new FeatureModule(MyBillsEntityDataFactory, b));
        OauthModule.Builder BuiltInFictitiousFunctionClassFactory = OauthModule.BuiltInFictitiousFunctionClassFactory();
        BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory = missingRequiredUserInfoDialogActivity;
        PlaceComponentResult2.getAuthRequestContext = (OauthModule) Preconditions.getAuthRequestContext(new OauthModule(BuiltInFictitiousFunctionClassFactory, b));
        StartParams startParams = 0;
        PlaceComponentResult2.lookAheadTest = (ServicesModule) Preconditions.getAuthRequestContext(new ServicesModule(startParams, 1, startParams));
        Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(PlaceComponentResult2.BuiltInFictitiousFunctionClassFactory, DeepLinkModule.class);
        Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(PlaceComponentResult2.NetworkUserEntityData$$ExternalSyntheticLambda0, ScanQrModule.class);
        Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(PlaceComponentResult2.KClassImpl$Data$declaredNonStaticMembers$2, RestoreUrlModule.class);
        Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(PlaceComponentResult2.MyBillsEntityDataFactory, FeatureModule.class);
        Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(PlaceComponentResult2.getAuthRequestContext, OauthModule.class);
        if (PlaceComponentResult2.lookAheadTest == null) {
            PlaceComponentResult2.lookAheadTest = new ServicesModule();
        }
        Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(PlaceComponentResult2.PlaceComponentResult, ApplicationComponent.class);
        new DaggerMissingRequiredUserInfoComponent.MissingRequiredUserInfoComponentImpl(PlaceComponentResult2.BuiltInFictitiousFunctionClassFactory, PlaceComponentResult2.NetworkUserEntityData$$ExternalSyntheticLambda0, PlaceComponentResult2.KClassImpl$Data$declaredNonStaticMembers$2, PlaceComponentResult2.MyBillsEntityDataFactory, PlaceComponentResult2.getAuthRequestContext, PlaceComponentResult2.lookAheadTest, PlaceComponentResult2.PlaceComponentResult, (byte) 0).KClassImpl$Data$declaredNonStaticMembers$2(this);
        Parcelable parcelableExtra = getIntent().getParcelableExtra("startParams");
        Intrinsics.checkNotNull(parcelableExtra);
        this.KClassImpl$Data$declaredNonStaticMembers$2 = (StartParams) parcelableExtra;
        TextView textView = (TextView) _$_findCachedViewById(R.id.getRelativeLeft);
        Object[] objArr = new Object[1];
        StartParams startParams2 = this.KClassImpl$Data$declaredNonStaticMembers$2;
        if (startParams2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            startParams2 = null;
        }
        objArr[0] = startParams2.getErrorConfigVersion;
        textView.setText(getString(R.string.mp_please_complete_profile, objArr));
        TextView textView2 = (TextView) _$_findCachedViewById(R.id.getLogSourceName);
        StartParams startParams3 = this.KClassImpl$Data$declaredNonStaticMembers$2;
        if (startParams3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            startParams3 = null;
        }
        textView2.setText(startParams3.getErrorConfigVersion);
        StartParams startParams4 = this.KClassImpl$Data$declaredNonStaticMembers$2;
        if (startParams4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            startParams4 = null;
        }
        List<String> list = startParams4.moveToNextValue;
        if (list != null) {
            RecyclerView recyclerView = (RecyclerView) _$_findCachedViewById(R.id.res_0x7f0a1050_linkedtreemap_linkedtreemapiterator);
            recyclerView.setLayoutManager(new LinearLayoutManager(this));
            recyclerView.setAdapter(new MiniProgramAgreementsAdapter(list, 2, 2));
        }
        ((DanaButtonGhostView) _$_findCachedViewById(R.id.getSupportButtonTintMode)).setOnClickListener(new View.OnClickListener() { // from class: id.dana.miniprogram.tnc.MissingRequiredUserInfoDialogActivity$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MissingRequiredUserInfoDialogActivity.$r8$lambda$f6R_JZs7NkdCdnLQB8u1SA9mSgA(MissingRequiredUserInfoDialogActivity.this, view);
            }
        });
        ((DanaButtonPrimaryView) _$_findCachedViewById(R.id.btnOk)).setOnClickListener(new View.OnClickListener() { // from class: id.dana.miniprogram.tnc.MissingRequiredUserInfoDialogActivity$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MissingRequiredUserInfoDialogActivity.$r8$lambda$fm44luA89yww2BJRLstKMezaDhY(MissingRequiredUserInfoDialogActivity.this, view);
            }
        });
        GlideRequests PlaceComponentResult3 = GlideApp.PlaceComponentResult(this);
        StartParams startParams5 = this.KClassImpl$Data$declaredNonStaticMembers$2;
        if (startParams5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
        } else {
            startParams = startParams5;
        }
        PlaceComponentResult3.PlaceComponentResult(startParams.getAuthRequestContext).getErrorConfigVersion((int) R.drawable.res_0x7f080633_networkuserentitydata_externalsyntheticlambda2).PlaceComponentResult((int) R.drawable.res_0x7f080633_networkuserentitydata_externalsyntheticlambda2).MyBillsEntityDataFactory(DiskCacheStrategy.getAuthRequestContext).MyBillsEntityDataFactory((ImageView) ((AppCompatImageView) _$_findCachedViewById(R.id.res_0x7f0a09c7_call_errorhandler)));
    }

    private static void b(byte b, char[] cArr, int i, Object[] objArr) {
        int i2;
        getCallingPid getcallingpid = new getCallingPid();
        char[] cArr2 = scheduleImpl;
        if (cArr2 != null) {
            int length = cArr2.length;
            char[] cArr3 = new char[length];
            for (int i3 = 0; i3 < length; i3++) {
                cArr3[i3] = (char) (cArr2[i3] ^ (-1549216646985767851L));
            }
            cArr2 = cArr3;
        }
        char c = (char) ((-1549216646985767851L) ^ getErrorConfigVersion);
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
