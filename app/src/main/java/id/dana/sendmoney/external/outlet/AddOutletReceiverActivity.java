package id.dana.sendmoney.external.outlet;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Color;
import android.graphics.ImageFormat;
import android.graphics.PointF;
import android.graphics.drawable.Drawable;
import android.media.AudioTrack;
import android.net.Uri;
import android.os.Bundle;
import android.os.Process;
import android.os.SystemClock;
import android.provider.ContactsContract;
import android.telephony.cdma.CdmaCellLocation;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.DatePicker;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.fragment.app.FragmentManager;
import androidx.loader.content.CursorLoader;
import androidx.view.ComponentActivity;
import androidx.view.OnBackPressedCallback;
import androidx.view.OnBackPressedDispatcher;
import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.alibaba.griver.core.jsapi.device.location.RequestPermission;
import com.alibaba.wireless.security.SecExceptionCode;
import com.alipay.iap.android.common.syncintegration.api.IAPSyncCommand;
import com.anggrayudi.storage.permission.ActivityPermissionRequest;
import com.anggrayudi.storage.permission.PermissionCallback;
import com.anggrayudi.storage.permission.PermissionReport;
import com.anggrayudi.storage.permission.PermissionRequest;
import com.anggrayudi.storage.permission.PermissionResult;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.google.common.base.Ascii;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.google.zxing.pdf417.PDF417Common;
import com.jakewharton.rxbinding2.widget.RxTextView;
import dagger.internal.Preconditions;
import id.dana.R;
import id.dana.base.AbstractContractKt;
import id.dana.base.BaseActivity;
import id.dana.component.buttoncomponent.DanaButtonPrimaryView;
import id.dana.core.ui.glide.GlideApp;
import id.dana.core.ui.glide.GlideRequests;
import id.dana.data.constant.DanaUrl;
import id.dana.data.util.NumberUtils;
import id.dana.di.component.ApplicationComponent;
import id.dana.di.component.DaggerAddOutletReceiverComponent;
import id.dana.di.modules.AddOutletReceiverModule;
import id.dana.domain.promotion.CdpContent;
import id.dana.onboarding.splash.LauncherActivity;
import id.dana.richview.CustomEditText;
import id.dana.richview.LogoListView;
import id.dana.sendmoney.TransactionType;
import id.dana.sendmoney.contact.provider.ContactProvider;
import id.dana.sendmoney.external.outlet.AddOutletReceiverContract;
import id.dana.sendmoney.model.ExternalWithdrawChannelModel;
import id.dana.sendmoney.model.RecipientModel;
import id.dana.sendmoney.model.RecipientSource;
import id.dana.sendmoney.model.WithdrawOTCModel;
import id.dana.sendmoney.recipient.RecipientType;
import id.dana.sendmoney.summary.SummaryActivity;
import id.dana.sendmoney_v2.landing.di.module.SendMoneyTrackerModule;
import id.dana.sendmoney_v2.recipient.view.ContactPermissionDialogFragment;
import id.dana.sendmoney_v2.tracker.SendMoneyAnalyticTracker;
import id.dana.sendmoney_v2.tracker.SendMoneyFeatureTime;
import id.dana.utils.DateTimeUtil;
import id.dana.utils.KeyboardHelper;
import id.dana.utils.LocaleUtil;
import id.dana.utils.permission.PermissionHelper;
import io.reactivex.Observable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.functions.Function3;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import o.BottomSheetCardBindingView$watcherCardNumberView$1;
import o.SummaryVoucherView$$ExternalSyntheticLambda0;

@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 /2\u00020\u0001:\u0001/B\u0007¢\u0006\u0004\b.\u0010\u0004J\u000f\u0010\u0003\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\b\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\b\u0010\u0004J)\u0010\r\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u00052\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0014¢\u0006\u0004\b\r\u0010\u000eJ\u0019\u0010\u0011\u001a\u00020\u00022\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\u0013\u0010\u0004R\"\u0010\u0015\u001a\u00020\u00148\u0007@\u0007X\u0087.¢\u0006\u0012\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u0018\u0010\u001e\u001a\u0004\u0018\u00010\u001b8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0014\u0010\"\u001a\u00020\u001f8\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b \u0010!R\"\u0010$\u001a\u00020#8\u0007@\u0007X\u0087.¢\u0006\u0012\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\u0013\u0010-\u001a\u00020*X\u0083\u0080\u0002¢\u0006\u0006\n\u0004\b+\u0010,"}, d2 = {"Lid/dana/sendmoney/external/outlet/AddOutletReceiverActivity;", "Lid/dana/base/BaseActivity;", "", "configToolbar", "()V", "", "getLayout", "()I", IAPSyncCommand.COMMAND_INIT, RequestPermission.REQUEST_CODE, "resultCode", "Landroid/content/Intent;", "data", "onActivityResult", "(IILandroid/content/Intent;)V", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "(Landroid/os/Bundle;)V", "onResume", "Lid/dana/sendmoney/external/outlet/AddOutletReceiverContract$Presenter;", "addOutletReceiverPresenter", "Lid/dana/sendmoney/external/outlet/AddOutletReceiverContract$Presenter;", "getAddOutletReceiverPresenter", "()Lid/dana/sendmoney/external/outlet/AddOutletReceiverContract$Presenter;", "setAddOutletReceiverPresenter", "(Lid/dana/sendmoney/external/outlet/AddOutletReceiverContract$Presenter;)V", "Lid/dana/sendmoney/model/ExternalWithdrawChannelModel;", "getErrorConfigVersion", "Lid/dana/sendmoney/model/ExternalWithdrawChannelModel;", "MyBillsEntityDataFactory", "Lcom/anggrayudi/storage/permission/ActivityPermissionRequest;", "scheduleImpl", "Lcom/anggrayudi/storage/permission/ActivityPermissionRequest;", "KClassImpl$Data$declaredNonStaticMembers$2", "Lid/dana/sendmoney_v2/tracker/SendMoneyAnalyticTracker;", "sendMoneyAnalyticTracker", "Lid/dana/sendmoney_v2/tracker/SendMoneyAnalyticTracker;", "getSendMoneyAnalyticTracker", "()Lid/dana/sendmoney_v2/tracker/SendMoneyAnalyticTracker;", "setSendMoneyAnalyticTracker", "(Lid/dana/sendmoney_v2/tracker/SendMoneyAnalyticTracker;)V", "Lid/dana/sendmoney_v2/tracker/SendMoneyFeatureTime;", "NetworkUserEntityData$$ExternalSyntheticLambda0", "Lkotlin/Lazy;", "PlaceComponentResult", "<init>", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class AddOutletReceiverActivity extends BaseActivity {

    /* renamed from: Companion  reason: from kotlin metadata */
    public static final Companion INSTANCE;
    private static boolean DatabaseTableConfigUtil;
    private static boolean GetContactSyncConfig;
    private static int initRecordTimeStamp;
    private static char[] lookAheadTest;
    @Inject
    public AddOutletReceiverContract.Presenter addOutletReceiverPresenter;

    /* renamed from: getErrorConfigVersion  reason: from kotlin metadata */
    private ExternalWithdrawChannelModel MyBillsEntityDataFactory;

    /* renamed from: scheduleImpl  reason: from kotlin metadata */
    private final ActivityPermissionRequest KClassImpl$Data$declaredNonStaticMembers$2;
    @Inject
    public SendMoneyAnalyticTracker sendMoneyAnalyticTracker;
    public static final byte[] $$a = {Ascii.ESC, -74, -29, -66, TarHeader.LF_CHR, -48, 46, 10, 7, 14, -39, TarHeader.LF_NORMAL, 13, -4, 18, 12, -46, 36, Ascii.SUB, -12, -20, 34, 9, Ascii.CAN, 2, 10, 14, 5, 22, -44, 59, 6, -5, -15, Ascii.SUB, 19, 11, -9, Ascii.NAK, 8, -42, TarHeader.LF_CHR, 6, 13, -8, Ascii.SUB, 3, -1, TarHeader.LF_NORMAL, -4, Ascii.EM, 7, -35, 43, 10, 3, -65, 39, 36, Ascii.SUB, -12, -54, 71, 8, 5, 16, -4, Ascii.CAN, -6, 6, -15, 40, 6, -20, 40, -12, Ascii.SUB, -4, 1, -15, Ascii.US, 15, -4, 10, Ascii.DC4, 8, -72, Ascii.NAK};
    public static final int $$b = 35;
    public static final byte[] getAuthRequestContext = {90, -83, 93, -67, -17, 6, -18, -1, 2, 1, TarHeader.LF_SYMLINK, -57, -16, -3, -10, 11, -13, -10, 66, -25, -48, -3, -10, 11, -23, 0, 1, -5, -13, -10, 7, -15, -9, 45, -29, -22, 7, 33, -48, 7, -5, 5, -25, 17, 47, -66, 7, -17, 3, TarHeader.LF_DIR, -41, -42, 2, -5, 11, -12, -2, -19, 47, -51, -4, 0, -1, 2, -2, -23, 7, -10, -3, 33, -41, 4, -13};
    public static final int PlaceComponentResult = 105;
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda0  reason: from kotlin metadata */
    private final Lazy PlaceComponentResult = LazyKt.lazy(new Function0<SendMoneyFeatureTime>() { // from class: id.dana.sendmoney.external.outlet.AddOutletReceiverActivity$sendMoneyFeatureTime$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final SendMoneyFeatureTime invoke() {
            return SendMoneyFeatureTime.INSTANCE.MyBillsEntityDataFactory();
        }
    });

    static {
        getAuthRequestContext();
        INSTANCE = new Companion(null);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0027  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x001f  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0027 -> B:11:0x0031). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void b(short r7, int r8, byte r9, java.lang.Object[] r10) {
        /*
            int r8 = 55 - r8
            int r7 = r7 + 16
            int r9 = 106 - r9
            byte[] r0 = id.dana.sendmoney.external.outlet.AddOutletReceiverActivity.getAuthRequestContext
            byte[] r1 = new byte[r7]
            r2 = 0
            if (r0 != 0) goto L15
            r3 = r1
            r4 = 0
            r1 = r0
            r0 = r10
            r10 = r9
            r9 = r8
            r8 = r7
            goto L31
        L15:
            r3 = 0
        L16:
            int r4 = r3 + 1
            byte r5 = (byte) r9
            r1[r3] = r5
            int r8 = r8 + 1
            if (r4 != r7) goto L27
            java.lang.String r7 = new java.lang.String
            r7.<init>(r1, r2)
            r10[r2] = r7
            return
        L27:
            r3 = r0[r8]
            r6 = r8
            r8 = r7
            r7 = r3
            r3 = r1
            r1 = r0
            r0 = r10
            r10 = r9
            r9 = r6
        L31:
            int r7 = -r7
            int r10 = r10 + r7
            int r7 = r10 + (-4)
            r10 = r0
            r0 = r1
            r1 = r3
            r3 = r4
            r6 = r9
            r9 = r7
            r7 = r8
            r8 = r6
            goto L16
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.sendmoney.external.outlet.AddOutletReceiverActivity.b(short, int, byte, java.lang.Object[]):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0029  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0021  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0029 -> B:11:0x0037). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void c(byte r6, int r7, short r8, java.lang.Object[] r9) {
        /*
            byte[] r0 = id.dana.sendmoney.external.outlet.AddOutletReceiverActivity.$$a
            int r6 = r6 + 4
            int r7 = r7 * 3
            int r7 = r7 + 21
            int r8 = r8 * 2
            int r8 = r8 + 75
            byte[] r1 = new byte[r7]
            int r7 = r7 + (-1)
            r2 = 0
            if (r0 != 0) goto L1b
            r8 = r7
            r3 = r1
            r4 = 0
            r7 = r6
            r1 = r0
            r0 = r9
            r9 = r8
            goto L37
        L1b:
            r3 = 0
        L1c:
            byte r4 = (byte) r8
            r1[r3] = r4
            if (r3 != r7) goto L29
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            r9[r2] = r6
            return
        L29:
            int r3 = r3 + 1
            int r6 = r6 + 1
            r4 = r0[r6]
            r5 = r7
            r7 = r6
            r6 = r4
            r4 = r3
            r3 = r1
            r1 = r0
            r0 = r9
            r9 = r5
        L37:
            int r8 = r8 + r6
            int r8 = r8 + (-7)
            r6 = r7
            r7 = r9
            r9 = r0
            r0 = r1
            r1 = r3
            r3 = r4
            goto L1c
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.sendmoney.external.outlet.AddOutletReceiverActivity.c(byte, int, short, java.lang.Object[]):void");
    }

    static void getAuthRequestContext() {
        lookAheadTest = new char[]{39900, 39889, 39899, 39885, 39886, 39892, 39825, 39882, 39919, 39898, 39896, 39888, 39876, 39912, 39887, 39932, 39883, 39881, 39915, 39895, 39880, 39891, 39814, 39817, 39815, 39823, 39812, 39897, 39821, 39820, 39818, 39819, 39901, 39816, 39813, 39822, 39894, 39884};
        DatabaseTableConfigUtil = true;
        GetContactSyncConfig = true;
        initRecordTimeStamp = 909155263;
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
        super.attachBaseContext(context);
        Object[] objArr5 = new Object[1];
        a(null, (ViewConfiguration.getWindowTouchSlop() >> 8) + 127, new byte[]{-120, -120, -117, -118, -123, -124, -119, -121, -120, -123, -121, -125, -122, -123, -124, -125, -126, -127}, null, objArr5);
        Class<?> cls = Class.forName((String) objArr5[0]);
        Object[] objArr6 = new Object[1];
        a(null, 127 - Drawable.resolveOpacity(0, 0), new byte[]{-125, -122, -114, -115, -116}, null, objArr6);
        int intValue = ((Integer) cls.getDeclaredMethod((String) objArr6[0], new Class[0]).invoke(null, new Object[0])).intValue() % 100000;
        if (intValue < 99000 || intValue > 99999) {
            Context applicationContext = context != null ? context.getApplicationContext() : context;
            if (applicationContext != null) {
                try {
                    Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                    if (obj == null) {
                        obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(928 - TextUtils.lastIndexOf("", '0', 0, 0), 35 - (ViewConfiguration.getKeyRepeatTimeout() >> 16), (char) TextUtils.getCapsMode("", 0, 0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                    }
                    Object invoke = ((Method) obj).invoke(null, null);
                    Object[] objArr7 = new Object[1];
                    a(null, 127 - (KeyEvent.getMaxKeyCode() >> 16), new byte[]{-117, -104, -97, -95, -104, -96, -100, -105, -102, -103, -101, -100, -101, -99, -104, -101, -117, -127, -125, -99, -125, -103, -97, -125, -104, -118, -118, -125, -127, -104, -98, -98, -104, -98, -99, -117, -100, -118, -117, -105, -103, -101, -125, -102, -103, -104, -118, -105}, null, objArr7);
                    String str = (String) objArr7[0];
                    Object[] objArr8 = new Object[1];
                    a(null, 127 - View.getDefaultSize(0, 0), new byte[]{-97, -125, -103, -98, -95, -118, -98, -102, -98, -102, -105, -101, -101, -105, -97, -97, -105, -98, -105, -118, -98, -117, -102, -94, -97, -102, -118, -118, -103, -96, -125, -118, -99, -99, -125, -103, -117, -101, -95, -104, -97, -104, -98, -125, -98, -100, -99, -99, -96, -98, -98, -125, -94, -101, -118, -125, -103, -102, -101, -100, -125, -104, -94, -127}, null, objArr8);
                    String str2 = (String) objArr8[0];
                    Object[] objArr9 = new Object[1];
                    a(null, TextUtils.lastIndexOf("", '0', 0) + 128, new byte[]{-101, -94, -94, -100, -104, -101, -94, -105, -94, -100, -98, -99, -117, -118, -101, -100, -95, -127, -102, -103, -96, -98, -100, -103, -103, -104, -105, -95, -103, -99, -125, -105, -118, -105, -100, -100, -103, -101, -100, -105, -97, -127, -95, -99, -125, -96, -117, -127, -105, -102, -97, -98, -98, -103, -103, -103, -96, -99, -105, -101, -95, -117, -98, -99}, null, objArr9);
                    String str3 = (String) objArr9[0];
                    Object[] objArr10 = new Object[1];
                    a(null, (SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)) + 126, new byte[]{-120, -111, -126, -117, -110, -117, -92, -99, -110, -92, -111, -120, -117, -91, -126, -122, -92, -122, -113, -127, -92, -116, -123, -118, -121, -117, -124, -127, -107, -90, -120, -125, -124, -127, -107, -91, -121, -111, -120, -127, -118, -111, -127, -117, -124, -108, -111, -121, -127, -126, -127, -125, -92, -92, -93, -120, -113, -111, -111, -108}, null, objArr10);
                    String str4 = (String) objArr10[0];
                    Object[] objArr11 = new Object[1];
                    a(null, View.getDefaultSize(0, 0) + 127, new byte[]{-98, -99, -121, -96, -121, -101}, null, objArr11);
                    try {
                        Object[] objArr12 = {applicationContext, str, str2, str3, str4, true, (String) objArr11[0], 995651014};
                        Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-1276397751);
                        if (obj2 == null) {
                            obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getScrollBarSize() >> 8) + 911, 19 - (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)), (char) TextUtils.getOffsetBefore("", 0))).getMethod("getAuthRequestContext", Context.class, String.class, String.class, String.class, String.class, Boolean.TYPE, String.class, Integer.TYPE);
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
                b(getAuthRequestContext[25], (byte) (-getAuthRequestContext[31]), getAuthRequestContext[25], objArr13);
                Class<?> cls2 = Class.forName((String) objArr13[0]);
                byte b = getAuthRequestContext[25];
                Object[] objArr14 = new Object[1];
                b(b, (byte) (b | Ascii.RS), getAuthRequestContext[9], objArr14);
                try {
                    Object[] objArr15 = {applicationContext2, Integer.valueOf(((Integer) cls2.getMethod((String) objArr14[0], Object.class).invoke(null, this)).intValue())};
                    Object obj3 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1691739267);
                    if (obj3 == null) {
                        Class cls3 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(55 - (ViewConfiguration.getMinimumFlingVelocity() >> 16), 2 - TextUtils.lastIndexOf("", '0', 0), (char) View.MeasureSpec.getSize(0));
                        byte b2 = $$a[47];
                        byte b3 = $$a[78];
                        Object[] objArr16 = new Object[1];
                        c(b2, b3, b3, objArr16);
                        obj3 = cls3.getMethod((String) objArr16[0], Context.class, Integer.TYPE);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1691739267, obj3);
                    }
                    Object invoke2 = ((Method) obj3).invoke(null, objArr15);
                    try {
                        Object obj4 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(40157535);
                        if (obj4 == null) {
                            obj4 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(Color.alpha(0) + 800, (ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)) + 14, (char) ExpandableListView.getPackedPositionGroup(0L))).getMethod("getAuthRequestContext", null);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(40157535, obj4);
                        }
                        int intValue2 = ((Integer) ((Method) obj4).invoke(invoke2, null)).intValue();
                        try {
                            Object obj5 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1621779126);
                            if (obj5 == null) {
                                obj5 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)) + SecExceptionCode.SEC_ERROR_STA_KEY_ENC_UNKNOWN_ERROR, TextUtils.indexOf("", "", 0, 0) + 15, (char) View.getDefaultSize(0, 0))).getMethod("PlaceComponentResult", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1621779126, obj5);
                            }
                            if (((Integer) ((Method) obj5).invoke(invoke2, null)).intValue() != intValue2) {
                                ArrayList arrayList = new ArrayList();
                                try {
                                    Object[] objArr17 = {invoke2};
                                    Object obj6 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(658700871);
                                    if (obj6 == null) {
                                        obj6 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(Color.red(0) + 815, 30 - (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)), (char) (View.MeasureSpec.getMode(0) + 57994))).getMethod("getAuthRequestContext", (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(TextUtils.getOffsetBefore("", 0) + 800, 14 - TextUtils.lastIndexOf("", '0'), (char) (ViewConfiguration.getWindowTouchSlop() >> 8)));
                                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(658700871, obj6);
                                    }
                                    arrayList.add(((Method) obj6).invoke(null, objArr17));
                                    long j = ((r6 ^ intValue2) & 4294967295L) | 60129542144L;
                                    try {
                                        Object obj7 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                                        if (obj7 != null) {
                                            objArr = null;
                                        } else {
                                            objArr = null;
                                            obj7 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)) + 930, 36 - (SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)), (char) View.MeasureSpec.getMode(0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj7);
                                        }
                                        Object invoke3 = ((Method) obj7).invoke(objArr, objArr);
                                        try {
                                            Object[] objArr18 = {-1841382524, Long.valueOf(j), arrayList, LauncherActivity.getAuid()};
                                            Object obj8 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                            if (obj8 == null) {
                                                obj8 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(Process.getGidForName("") + 912, 18 - (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)), (char) (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                b(getAuthRequestContext[25], (byte) (-getAuthRequestContext[31]), getAuthRequestContext[25], objArr19);
                Class<?> cls4 = Class.forName((String) objArr19[0]);
                byte b4 = getAuthRequestContext[25];
                Object[] objArr20 = new Object[1];
                b(b4, (byte) (b4 | Ascii.RS), getAuthRequestContext[9], objArr20);
                try {
                    Object[] objArr21 = {applicationContext3, Integer.valueOf(((Integer) cls4.getMethod((String) objArr20[0], Object.class).invoke(null, this)).intValue())};
                    Object obj9 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(345757441);
                    if (obj9 == null) {
                        Class cls5 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(61 - (CdmaCellLocation.convertQuartSecToDecDegrees(0) > FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 0 : -1)), (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)) + 45, (char) (Color.rgb(0, 0, 0) + 16777216));
                        Object[] objArr22 = new Object[1];
                        c($$a[28], (byte) ($$a[78] - 1), $$a[9], objArr22);
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
                                objArr4 = null;
                            } else {
                                objArr4 = null;
                                obj10 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(928 - ((byte) KeyEvent.getModifierMetaStateMask()), 35 - (ViewConfiguration.getMinimumFlingVelocity() >> 16), (char) (ViewConfiguration.getFadingEdgeLength() >> 16))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj10);
                            }
                            Object invoke4 = ((Method) obj10).invoke(objArr4, objArr4);
                            try {
                                Object[] objArr24 = {-1841382524, Long.valueOf(j2), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj11 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj11 == null) {
                                    obj11 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)) + 911, 17 - TextUtils.lastIndexOf("", '0', 0), (char) (ViewConfiguration.getScrollDefaultDelay() >> 16))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                b(getAuthRequestContext[25], (byte) (-getAuthRequestContext[31]), getAuthRequestContext[25], objArr25);
                Class<?> cls6 = Class.forName((String) objArr25[0]);
                byte b5 = getAuthRequestContext[25];
                Object[] objArr26 = new Object[1];
                b(b5, (byte) (b5 | Ascii.RS), getAuthRequestContext[9], objArr26);
                try {
                    Object[] objArr27 = {applicationContext4, Integer.valueOf(((Integer) cls6.getMethod((String) objArr26[0], Object.class).invoke(null, this)).intValue())};
                    Object obj12 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-697999596);
                    if (obj12 == null) {
                        Class cls7 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)) + 118, 3 - (ViewConfiguration.getScrollDefaultDelay() >> 16), (char) (38968 - (ViewConfiguration.getScrollBarFadeDuration() >> 16)));
                        Object[] objArr28 = new Object[1];
                        c($$a[28], (byte) ($$a[78] - 1), $$a[9], objArr28);
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
                                obj13 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - ExpandableListView.getPackedPositionType(0L), (ViewConfiguration.getDoubleTapTimeout() >> 16) + 35, (char) Color.argb(0, 0, 0, 0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj13);
                            }
                            Object invoke5 = ((Method) obj13).invoke(objArr3, objArr3);
                            try {
                                Object[] objArr30 = {-1841382524, Long.valueOf(j3), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj14 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj14 == null) {
                                    obj14 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(910 - MotionEvent.axisFromString(""), 17 - MotionEvent.axisFromString(""), (char) (ViewConfiguration.getWindowTouchSlop() >> 8))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                b(getAuthRequestContext[25], (byte) (-getAuthRequestContext[31]), getAuthRequestContext[25], objArr31);
                Class<?> cls8 = Class.forName((String) objArr31[0]);
                byte b6 = getAuthRequestContext[25];
                Object[] objArr32 = new Object[1];
                b(b6, (byte) (b6 | Ascii.RS), getAuthRequestContext[9], objArr32);
                try {
                    Object[] objArr33 = {applicationContext5, Integer.valueOf(((Integer) cls8.getMethod((String) objArr32[0], Object.class).invoke(null, this)).intValue())};
                    Object obj15 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-16683571);
                    if (obj15 == null) {
                        Class cls9 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)) + 106, 2 - Process.getGidForName(""), (char) ((ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1)) - 1));
                        Object[] objArr34 = new Object[1];
                        c((byte) (-$$a[40]), $$a[8], (byte) ($$a[78] - 1), objArr34);
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
                                objArr2 = null;
                            } else {
                                objArr2 = null;
                                obj16 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - (Process.myPid() >> 22), Color.green(0) + 35, (char) (Process.myTid() >> 22))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj16);
                            }
                            Object invoke6 = ((Method) obj16).invoke(objArr2, objArr2);
                            try {
                                Object[] objArr36 = {-1841382524, Long.valueOf(j4), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj17 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj17 == null) {
                                    obj17 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)) + 910, 18 - (ViewConfiguration.getMinimumFlingVelocity() >> 16), (char) (ViewConfiguration.getMinimumFlingVelocity() >> 16))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
        return R.layout.activity_add_outlet_receiver;
    }

    @Override // id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public final Resources getResources() {
        return super.getResources();
    }

    @Override // id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onPause() {
        Context baseContext = getBaseContext();
        if (baseContext == null) {
            Object[] objArr = new Object[1];
            a(null, super.getResources().getString(R.string.location_permission_prompt_home_desc).substring(15, 17).codePointAt(1) + 11, new byte[]{-125, -127, -117, -124, -108, -109, -115, -111, -122, -110, -122, -111, -118, -112, -121, -113, -113, -127, -121, -125, -122, -123, -124, -125, -126, -127}, null, objArr);
            Class<?> cls = Class.forName((String) objArr[0]);
            Object[] objArr2 = new Object[1];
            a(null, getPackageName().length() + 120, new byte[]{-126, -123, -122, -111, -127, -118, -122, -106, -113, -113, -112, -111, -126, -117, -124, -124, -107, -118}, null, objArr2);
            baseContext = (Context) cls.getMethod((String) objArr2[0], new Class[0]).invoke(null, null);
        }
        if (baseContext != null) {
            baseContext = baseContext.getApplicationContext();
        }
        if (baseContext != null) {
            try {
                Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                if (obj == null) {
                    obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - (ViewConfiguration.getFadingEdgeLength() >> 16), ImageFormat.getBitsPerPixel(0) + 36, (char) (ViewConfiguration.getTouchSlop() >> 8))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                }
                Object invoke = ((Method) obj).invoke(null, null);
                try {
                    Object[] objArr3 = {baseContext};
                    Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-549958681);
                    if (obj2 == null) {
                        obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - Color.alpha(0), Drawable.resolveOpacity(0, 0) + 18, (char) (TextUtils.lastIndexOf("", '0', 0, 0) + 1))).getMethod("MyBillsEntityDataFactory", Context.class);
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

    public AddOutletReceiverActivity() {
        ActivityPermissionRequest.Builder builder = new ActivityPermissionRequest.Builder((ComponentActivity) this);
        String[] strArr = {"android.permission.READ_CONTACTS"};
        Intrinsics.checkNotNullParameter(strArr, "");
        builder.PlaceComponentResult = ArraysKt.toSet(strArr);
        PermissionCallback permissionCallback = new PermissionCallback() { // from class: id.dana.sendmoney.external.outlet.AddOutletReceiverActivity$readContactPermissionRequest$1
            @Override // com.anggrayudi.storage.permission.PermissionCallback
            public final void onPermissionsChecked(PermissionResult p0, boolean p1) {
                Intrinsics.checkNotNullParameter(p0, "");
                if (p0.MyBillsEntityDataFactory()) {
                    AddOutletReceiverActivity.this.startActivityForResult(new Intent("android.intent.action.PICK", ContactsContract.CommonDataKinds.Phone.CONTENT_URI), 200);
                }
            }

            @Override // com.anggrayudi.storage.permission.PermissionCallback
            public final void onShouldRedirectToSystemSettings(List<PermissionReport> p0) {
                Intrinsics.checkNotNullParameter(p0, "");
                PermissionHelper.MyBillsEntityDataFactory(AddOutletReceiverActivity.this);
            }

            @Override // com.anggrayudi.storage.permission.PermissionCallback
            public final void onDisplayConsentDialog(PermissionRequest p0) {
                Intrinsics.checkNotNullParameter(p0, "");
                AddOutletReceiverActivity.access$showRequestContactPermissionDialog(AddOutletReceiverActivity.this);
            }
        };
        Intrinsics.checkNotNullParameter(permissionCallback, "");
        builder.getAuthRequestContext = permissionCallback;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = builder.PlaceComponentResult();
    }

    @JvmName(name = "getAddOutletReceiverPresenter")
    public final AddOutletReceiverContract.Presenter getAddOutletReceiverPresenter() {
        AddOutletReceiverContract.Presenter presenter = this.addOutletReceiverPresenter;
        if (presenter != null) {
            return presenter;
        }
        Intrinsics.throwUninitializedPropertyAccessException("");
        return null;
    }

    @JvmName(name = "setAddOutletReceiverPresenter")
    public final void setAddOutletReceiverPresenter(AddOutletReceiverContract.Presenter presenter) {
        Intrinsics.checkNotNullParameter(presenter, "");
        this.addOutletReceiverPresenter = presenter;
    }

    @JvmName(name = "getSendMoneyAnalyticTracker")
    public final SendMoneyAnalyticTracker getSendMoneyAnalyticTracker() {
        SendMoneyAnalyticTracker sendMoneyAnalyticTracker = this.sendMoneyAnalyticTracker;
        if (sendMoneyAnalyticTracker != null) {
            return sendMoneyAnalyticTracker;
        }
        Intrinsics.throwUninitializedPropertyAccessException("");
        return null;
    }

    @JvmName(name = "setSendMoneyAnalyticTracker")
    public final void setSendMoneyAnalyticTracker(SendMoneyAnalyticTracker sendMoneyAnalyticTracker) {
        Intrinsics.checkNotNullParameter(sendMoneyAnalyticTracker, "");
        this.sendMoneyAnalyticTracker = sendMoneyAnalyticTracker;
    }

    @Override // id.dana.base.BaseActivity
    public final void configToolbar() {
        setCenterTitle(getString(R.string.sendmoney_summary_x2c_toolbar_title));
        setMenuLeftButton(R.drawable.btn_arrow_left);
    }

    @Override // id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onResume() {
        Context baseContext = getBaseContext();
        if (baseContext == null) {
            Object[] objArr = new Object[1];
            a(null, Color.green(0) + 127, new byte[]{-125, -127, -117, -124, -108, -109, -115, -111, -122, -110, -122, -111, -118, -112, -121, -113, -113, -127, -121, -125, -122, -123, -124, -125, -126, -127}, null, objArr);
            Class<?> cls = Class.forName((String) objArr[0]);
            Object[] objArr2 = new Object[1];
            a(null, getPackageName().codePointAt(5) + 17, new byte[]{-126, -123, -122, -111, -127, -118, -122, -106, -113, -113, -112, -111, -126, -117, -124, -124, -107, -118}, null, objArr2);
            baseContext = (Context) cls.getMethod((String) objArr2[0], new Class[0]).invoke(null, null);
        }
        if (baseContext != null) {
            baseContext = baseContext.getApplicationContext();
        }
        if (baseContext != null) {
            try {
                Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                if (obj == null) {
                    obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - View.MeasureSpec.getMode(0), 35 - (ViewConfiguration.getPressedStateDuration() >> 16), (char) (ViewConfiguration.getPressedStateDuration() >> 16))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                }
                Object invoke = ((Method) obj).invoke(null, null);
                try {
                    Object[] objArr3 = {baseContext};
                    Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(247288059);
                    if (obj2 == null) {
                        obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(TextUtils.getCapsMode("", 0, 0) + 911, TextUtils.getOffsetBefore("", 0) + 18, (char) (ViewConfiguration.getTapTimeout() >> 16))).getMethod("KClassImpl$Data$declaredNonStaticMembers$2", Context.class);
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
        SendMoneyFeatureTime sendMoneyFeatureTime = (SendMoneyFeatureTime) this.PlaceComponentResult.getValue();
        sendMoneyFeatureTime.moveToNextValue = DateTimeUtil.BuiltInFictitiousFunctionClassFactory();
        Intrinsics.checkNotNullParameter("OPEN WITHDRAW FORM PAGE", "");
        if (sendMoneyFeatureTime.getAuthRequestContext.get("OPEN WITHDRAW FORM PAGE") == null) {
            SendMoneyAnalyticTracker sendMoneyAnalyticTracker = getSendMoneyAnalyticTracker();
            ExternalWithdrawChannelModel externalWithdrawChannelModel = this.MyBillsEntityDataFactory;
            String str = externalWithdrawChannelModel != null ? externalWithdrawChannelModel.moveToNextValue : null;
            sendMoneyAnalyticTracker.getAuthRequestContext(str != null ? str : "");
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, android.app.Activity
    public final void onActivityResult(int requestCode, int resultCode, Intent data) {
        Uri data2;
        Cursor loadInBackground;
        CustomEditText customEditText;
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode != 200 || resultCode != -1 || data == null || (data2 = data.getData()) == null || (loadInBackground = new CursorLoader(this, data2).loadInBackground()) == null) {
            return;
        }
        Cursor cursor = loadInBackground;
        try {
            Cursor cursor2 = cursor;
            if (cursor2.moveToFirst() && (customEditText = (CustomEditText) _$_findCachedViewById(R.id.cetReceiverPhoneNumber)) != null) {
                customEditText.setText(NumberUtils.getIndoPhoneNumber(cursor2.getString(cursor2.getColumnIndex(ContactProvider.Column.PHONENUMBER))));
            }
            Unit unit = Unit.INSTANCE;
            CloseableKt.closeFinally(cursor, null);
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                CloseableKt.closeFinally(cursor, th);
                throw th2;
            }
        }
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000b\u0010\fJ'\u0010\t\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\n"}, d2 = {"Lid/dana/sendmoney/external/outlet/AddOutletReceiverActivity$Companion;", "", "Landroid/app/Activity;", "p0", "Lid/dana/sendmoney/model/ExternalWithdrawChannelModel;", "p1", "", "p2", "", "PlaceComponentResult", "(Landroid/app/Activity;Lid/dana/sendmoney/model/ExternalWithdrawChannelModel;Ljava/lang/String;)V", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public static void PlaceComponentResult(Activity p0, ExternalWithdrawChannelModel p1, String p2) {
            Intrinsics.checkNotNullParameter(p1, "");
            Intrinsics.checkNotNullParameter(p2, "");
            if (p0 != null) {
                Intent intent = new Intent(p0, AddOutletReceiverActivity.class);
                intent.putExtra("BUNDLE_WITHDRAW_CHANNEL", p1);
                intent.putExtra("source", p2);
                p0.startActivity(intent);
            }
        }
    }

    public static /* synthetic */ Boolean $r8$lambda$978HvDJtr0g4iaPYotlA7DLs168(CharSequence charSequence) {
        if (charSequence != null) {
            return Boolean.valueOf(charSequence.length() > 0);
        }
        return null;
    }

    /* renamed from: $r8$lambda$KMjtSR-k_Qg6_HmyqxrQmAiAvog  reason: not valid java name */
    public static /* synthetic */ void m2904$r8$lambda$KMjtSRk_Qg6_HmyqxrQmAiAvog(AddOutletReceiverActivity addOutletReceiverActivity, View view) {
        Intrinsics.checkNotNullParameter(addOutletReceiverActivity, "");
        addOutletReceiverActivity.KClassImpl$Data$declaredNonStaticMembers$2.check();
    }

    /* renamed from: $r8$lambda$THavNSAZ8gU_Vb_RF-2buU_-CeQ  reason: not valid java name */
    public static /* synthetic */ void m2905$r8$lambda$THavNSAZ8gU_Vb_RF2buU_CeQ(AddOutletReceiverActivity addOutletReceiverActivity, boolean z) {
        Intrinsics.checkNotNullParameter(addOutletReceiverActivity, "");
        DanaButtonPrimaryView danaButtonPrimaryView = (DanaButtonPrimaryView) addOutletReceiverActivity._$_findCachedViewById(R.id.res_0x7f0a0125_networkuserentitydata_externalsyntheticlambda3);
        if (danaButtonPrimaryView != null) {
            String string = addOutletReceiverActivity.getResources().getString(R.string.btn_continue);
            Intrinsics.checkNotNullExpressionValue(string, "");
            danaButtonPrimaryView.setClickable(z);
            danaButtonPrimaryView.setEnabled(z);
            danaButtonPrimaryView.setDanaButtonView(z ? 1 : 0, string, null, null);
        }
    }

    public static /* synthetic */ void $r8$lambda$bD6WJwKWkYCL9WSVAHibdlXlQ6U(CustomEditText customEditText, DatePicker datePicker, int i, int i2, int i3) {
        Intrinsics.checkNotNullParameter(customEditText, "");
        StringBuilder sb = new StringBuilder();
        sb.append(i3);
        sb.append("-");
        sb.append(i2 + 1);
        sb.append("-");
        sb.append(i);
        customEditText.setText(sb.toString());
    }

    /* renamed from: $r8$lambda$q9-Ej0DLU0oz_PB_AANiw5BFU70  reason: not valid java name */
    public static /* synthetic */ Boolean m2907$r8$lambda$q9Ej0DLU0oz_PB_AANiw5BFU70(CharSequence charSequence) {
        if (charSequence != null) {
            return Boolean.valueOf(!StringsKt.isBlank(charSequence));
        }
        return null;
    }

    public static /* synthetic */ void $r8$lambda$qGJQUmfDRSD9135qQdWWCMsStTI(AddOutletReceiverActivity addOutletReceiverActivity, final CustomEditText customEditText, View view) {
        Intrinsics.checkNotNullParameter(addOutletReceiverActivity, "");
        Intrinsics.checkNotNullParameter(customEditText, "");
        DateTimeUtil.getAuthRequestContext(addOutletReceiverActivity, new DatePickerDialog.OnDateSetListener() { // from class: id.dana.sendmoney.external.outlet.AddOutletReceiverActivity$$ExternalSyntheticLambda5
            @Override // android.app.DatePickerDialog.OnDateSetListener
            public final void onDateSet(DatePicker datePicker, int i, int i2, int i3) {
                AddOutletReceiverActivity.$r8$lambda$bD6WJwKWkYCL9WSVAHibdlXlQ6U(CustomEditText.this, datePicker, i, i2, i3);
            }
        }).show();
        KeyboardHelper.BuiltInFictitiousFunctionClassFactory(customEditText);
    }

    public static /* synthetic */ void $r8$lambda$zhV677ooA6TnSW4QclroHhsKQ0s(AddOutletReceiverActivity addOutletReceiverActivity, View view) {
        Intrinsics.checkNotNullParameter(addOutletReceiverActivity, "");
        Intent intentClassWithTracking = addOutletReceiverActivity.getIntentClassWithTracking(SummaryActivity.class);
        RecipientModel.Builder builder = new RecipientModel.Builder(RecipientType.OTC);
        builder.NetworkUserEntityData$$ExternalSyntheticLambda4 = TransactionType.SEND_MONEY_TO_CASHIER;
        CustomEditText customEditText = (CustomEditText) addOutletReceiverActivity._$_findCachedViewById(R.id.containsObjectForKey_res_0x7f0a02e4);
        builder.initRecordTimeStamp = customEditText != null ? customEditText.getText() : null;
        CustomEditText customEditText2 = (CustomEditText) addOutletReceiverActivity._$_findCachedViewById(R.id.cetReceiverPhoneNumber);
        builder.GetContactSyncConfig = customEditText2 != null ? customEditText2.getText() : null;
        Locale authRequestContext = LocaleUtil.getAuthRequestContext();
        CustomEditText customEditText3 = (CustomEditText) addOutletReceiverActivity._$_findCachedViewById(R.id.res_0x7f0a02e3_securitysettingsactivity_createpinlauncher_2_2);
        builder.MyBillsEntityDataFactory = DateTimeUtil.MyBillsEntityDataFactory("dd-MM-yyyy", "yyyy-MM-dd", authRequestContext, customEditText3 != null ? customEditText3.getText() : null);
        builder.NetworkUserEntityData$$ExternalSyntheticLambda6 = addOutletReceiverActivity.getSource();
        builder.newProxyInstance = ((CustomEditText) addOutletReceiverActivity._$_findCachedViewById(R.id.cetReceiverPhoneNumber)).isManualInput() ? "Manual Input" : RecipientSource.ALL_CONTACTS;
        intentClassWithTracking.putExtra("data", builder.KClassImpl$Data$declaredNonStaticMembers$2());
        WithdrawOTCModel withdrawOTCModel = new WithdrawOTCModel();
        ExternalWithdrawChannelModel externalWithdrawChannelModel = addOutletReceiverActivity.MyBillsEntityDataFactory;
        if (externalWithdrawChannelModel != null) {
            withdrawOTCModel.MyBillsEntityDataFactory = externalWithdrawChannelModel.NetworkUserEntityData$$ExternalSyntheticLambda0;
            withdrawOTCModel.PlaceComponentResult = externalWithdrawChannelModel.scheduleImpl;
            withdrawOTCModel.lookAheadTest = externalWithdrawChannelModel.moveToNextValue;
            withdrawOTCModel.getErrorConfigVersion = externalWithdrawChannelModel.lookAheadTest;
            withdrawOTCModel.scheduleImpl = externalWithdrawChannelModel.NetworkUserEntityData$$ExternalSyntheticLambda1;
        }
        intentClassWithTracking.putExtra("BUNDLE_WITHDRAW_CHANNEL", withdrawOTCModel);
        intentClassWithTracking.putExtra("transferScenario", addOutletReceiverActivity.getIntent().getStringExtra("transferScenario"));
        intentClassWithTracking.putExtra("source", addOutletReceiverActivity.getSource());
        addOutletReceiverActivity.startActivity(intentClassWithTracking);
    }

    public static final /* synthetic */ SendMoneyFeatureTime access$getSendMoneyFeatureTime(AddOutletReceiverActivity addOutletReceiverActivity) {
        return (SendMoneyFeatureTime) addOutletReceiverActivity.PlaceComponentResult.getValue();
    }

    public static final /* synthetic */ void access$showRequestContactPermissionDialog(final AddOutletReceiverActivity addOutletReceiverActivity) {
        if (addOutletReceiverActivity.isActivityAvailable()) {
            FragmentManager supportFragmentManager = addOutletReceiverActivity.getSupportFragmentManager();
            ContactPermissionDialogFragment contactPermissionDialogFragment = new ContactPermissionDialogFragment(new Function0<Unit>() { // from class: id.dana.sendmoney.external.outlet.AddOutletReceiverActivity$showRequestContactPermissionDialog$1$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                }

                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    ActivityPermissionRequest activityPermissionRequest;
                    activityPermissionRequest = AddOutletReceiverActivity.this.KClassImpl$Data$declaredNonStaticMembers$2;
                    activityPermissionRequest.continueToPermissionRequest();
                }

                @Override // kotlin.jvm.functions.Function0
                public final /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }
            }, null, null, 6, null);
            Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "");
            contactPermissionDialogFragment.MyBillsEntityDataFactory(supportFragmentManager);
        }
    }

    @Override // id.dana.base.BaseActivity
    public final void init() {
        String str;
        String str2;
        Bundle extras;
        Intent intent = getIntent();
        if (intent != null && (extras = intent.getExtras()) != null) {
            this.MyBillsEntityDataFactory = (ExternalWithdrawChannelModel) extras.getParcelable("BUNDLE_WITHDRAW_CHANNEL");
        }
        DaggerAddOutletReceiverComponent.Builder KClassImpl$Data$declaredNonStaticMembers$2 = DaggerAddOutletReceiverComponent.KClassImpl$Data$declaredNonStaticMembers$2();
        KClassImpl$Data$declaredNonStaticMembers$2.BuiltInFictitiousFunctionClassFactory = (ApplicationComponent) Preconditions.getAuthRequestContext(getApplicationComponent());
        KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext = (AddOutletReceiverModule) Preconditions.getAuthRequestContext(new AddOutletReceiverModule(new AddOutletReceiverContract.View() { // from class: id.dana.sendmoney.external.outlet.AddOutletReceiverActivity$addOutletReceiverModule$1
            @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
            public final /* synthetic */ void dismissProgress() {
                AbstractContractKt.AbstractView.CC.MyBillsEntityDataFactory();
            }

            @Override // id.dana.base.AbstractContractKt.AbstractView
            public final /* synthetic */ String getErrorSource() {
                return AbstractContractKt.AbstractView.CC.getAuthRequestContext();
            }

            @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
            public final /* synthetic */ void onError(String str3) {
                AbstractContractKt.AbstractView.CC.BuiltInFictitiousFunctionClassFactory();
            }

            @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
            public final /* synthetic */ void showProgress() {
                AbstractContractKt.AbstractView.CC.PlaceComponentResult();
            }

            @Override // id.dana.sendmoney.external.outlet.AddOutletReceiverContract.View
            public final void BuiltInFictitiousFunctionClassFactory(List<? extends CdpContent> p0) {
                Intrinsics.checkNotNullParameter(p0, "");
                ((LogoListView) AddOutletReceiverActivity.this._$_findCachedViewById(R.id.getSwipeDelegateListener)).setLogo(p0);
            }
        }));
        Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext, AddOutletReceiverModule.class);
        if (KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2 == null) {
            KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2 = new SendMoneyTrackerModule();
        }
        Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(KClassImpl$Data$declaredNonStaticMembers$2.BuiltInFictitiousFunctionClassFactory, ApplicationComponent.class);
        new DaggerAddOutletReceiverComponent.AddOutletReceiverComponentImpl(KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext, KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2, KClassImpl$Data$declaredNonStaticMembers$2.BuiltInFictitiousFunctionClassFactory, (byte) 0).getAuthRequestContext(this);
        registerPresenter(getAddOutletReceiverPresenter());
        getAddOutletReceiverPresenter().BuiltInFictitiousFunctionClassFactory();
        CustomEditText customEditText = (CustomEditText) _$_findCachedViewById(R.id.cetReceiverPhoneNumber);
        if (customEditText != null) {
            customEditText.setContentDescriptionOnEditText(getString(R.string.txtPhoneNumber));
            customEditText.setContentDescriptionOnImageView(getString(R.string.ivContactIcon));
            customEditText.setOnIconClickListener(new View.OnClickListener() { // from class: id.dana.sendmoney.external.outlet.AddOutletReceiverActivity$$ExternalSyntheticLambda2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    AddOutletReceiverActivity.m2904$r8$lambda$KMjtSRk_Qg6_HmyqxrQmAiAvog(AddOutletReceiverActivity.this, view);
                }
            });
        }
        CustomEditText customEditText2 = (CustomEditText) _$_findCachedViewById(R.id.containsObjectForKey_res_0x7f0a02e4);
        if (customEditText2 != null) {
            customEditText2.setContentDescriptionOnEditText(getString(R.string.txtFullName));
        }
        final CustomEditText customEditText3 = (CustomEditText) _$_findCachedViewById(R.id.res_0x7f0a02e3_securitysettingsactivity_createpinlauncher_2_2);
        if (customEditText3 != null) {
            customEditText3.setContentDescriptionOnEditText(getString(R.string.txtDateOfBirth));
            customEditText3.setOnEtCustomEditTextClicked(new View.OnClickListener() { // from class: id.dana.sendmoney.external.outlet.AddOutletReceiverActivity$$ExternalSyntheticLambda3
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    AddOutletReceiverActivity.$r8$lambda$qGJQUmfDRSD9135qQdWWCMsStTI(AddOutletReceiverActivity.this, customEditText3, view);
                }
            });
        }
        DanaButtonPrimaryView danaButtonPrimaryView = (DanaButtonPrimaryView) _$_findCachedViewById(R.id.res_0x7f0a0125_networkuserentitydata_externalsyntheticlambda3);
        if (danaButtonPrimaryView != null) {
            danaButtonPrimaryView.setOnClickListener(new View.OnClickListener() { // from class: id.dana.sendmoney.external.outlet.AddOutletReceiverActivity$$ExternalSyntheticLambda4
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    AddOutletReceiverActivity.$r8$lambda$zhV677ooA6TnSW4QclroHhsKQ0s(AddOutletReceiverActivity.this, view);
                }
            });
        }
        GlideRequests PlaceComponentResult2 = GlideApp.PlaceComponentResult(this);
        Object[] objArr = new Object[1];
        ExternalWithdrawChannelModel externalWithdrawChannelModel = this.MyBillsEntityDataFactory;
        if (externalWithdrawChannelModel == null || (str2 = externalWithdrawChannelModel.NetworkUserEntityData$$ExternalSyntheticLambda0) == null) {
            str = null;
        } else {
            str = str2.toLowerCase();
            Intrinsics.checkNotNullExpressionValue(str, "");
        }
        objArr[0] = str;
        String format = String.format(DanaUrl.CHANNEL_OUTLET_CASHIER_URL, Arrays.copyOf(objArr, 1));
        Intrinsics.checkNotNullExpressionValue(format, "");
        PlaceComponentResult2.PlaceComponentResult(format).MyBillsEntityDataFactory(DiskCacheStrategy.getAuthRequestContext).MyBillsEntityDataFactory((ImageView) ((AppCompatImageView) _$_findCachedViewById(R.id.onRefresh)));
        addDisposable(Observable.combineLatest(RxTextView.textChanges(((CustomEditText) _$_findCachedViewById(R.id.cetReceiverPhoneNumber)).getEtCustomEditText()).map(new Function() { // from class: id.dana.sendmoney.external.outlet.AddOutletReceiverActivity$$ExternalSyntheticLambda0
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                Boolean valueOf;
                valueOf = Boolean.valueOf(NumberUtils.isValidIndoPhoneNumberPrefix(String.valueOf((CharSequence) obj)));
                return valueOf;
            }
        }), RxTextView.textChanges(((CustomEditText) _$_findCachedViewById(R.id.containsObjectForKey_res_0x7f0a02e4)).getEtCustomEditText()).map(new Function() { // from class: id.dana.sendmoney.external.outlet.AddOutletReceiverActivity$$ExternalSyntheticLambda1
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return AddOutletReceiverActivity.m2907$r8$lambda$q9Ej0DLU0oz_PB_AANiw5BFU70((CharSequence) obj);
            }
        }), RxTextView.textChanges(((CustomEditText) _$_findCachedViewById(R.id.res_0x7f0a02e3_securitysettingsactivity_createpinlauncher_2_2)).getEtCustomEditText()).map(new Function() { // from class: id.dana.sendmoney.external.outlet.AddOutletReceiverActivity$$ExternalSyntheticLambda6
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return AddOutletReceiverActivity.$r8$lambda$978HvDJtr0g4iaPYotlA7DLs168((CharSequence) obj);
            }
        }), new Function3() { // from class: id.dana.sendmoney.external.outlet.AddOutletReceiverActivity$$ExternalSyntheticLambda7
            @Override // io.reactivex.functions.Function3
            public final Object apply(Object obj, Object obj2, Object obj3) {
                Boolean valueOf;
                ((Boolean) obj).booleanValue();
                ((Boolean) obj2).booleanValue();
                ((Boolean) obj3).booleanValue();
                valueOf = Boolean.valueOf(r0 && r1 && r2);
                return valueOf;
            }
        }).subscribe(new Consumer() { // from class: id.dana.sendmoney.external.outlet.AddOutletReceiverActivity$$ExternalSyntheticLambda8
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                AddOutletReceiverActivity.m2905$r8$lambda$THavNSAZ8gU_Vb_RF2buU_CeQ(AddOutletReceiverActivity.this, ((Boolean) obj).booleanValue());
            }
        }));
        OnBackPressedDispatcher onBackPressedDispatcher = getOnBackPressedDispatcher();
        OnBackPressedCallback onBackPressedCallback = new OnBackPressedCallback() { // from class: id.dana.sendmoney.external.outlet.AddOutletReceiverActivity$setOnBankListener$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(true);
            }

            @Override // androidx.view.OnBackPressedCallback
            public final void handleOnBackPressed() {
                SendMoneyFeatureTime access$getSendMoneyFeatureTime = AddOutletReceiverActivity.access$getSendMoneyFeatureTime(AddOutletReceiverActivity.this);
                Intrinsics.checkNotNullParameter("OPEN WITHDRAW FORM PAGE", "");
                access$getSendMoneyFeatureTime.getAuthRequestContext.remove("OPEN WITHDRAW FORM PAGE");
                AddOutletReceiverActivity.this.finish();
            }
        };
        onBackPressedDispatcher.KClassImpl$Data$declaredNonStaticMembers$2.add(onBackPressedCallback);
        onBackPressedCallback.addCancellable(new OnBackPressedDispatcher.OnBackPressedCancellable(onBackPressedCallback));
    }

    @Override // id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onCreate(Bundle savedInstanceState) {
        Object[] objArr = new Object[1];
        a(null, super.getResources().getString(R.string.ss_please_select_root_storage_primary).substring(16, 18).length() + 125, new byte[]{-120, -120, -117, -118, -123, -124, -119, -121, -120, -123, -121, -125, -122, -123, -124, -125, -126, -127}, null, objArr);
        Class<?> cls = Class.forName((String) objArr[0]);
        Object[] objArr2 = new Object[1];
        a(null, 126 - ((byte) KeyEvent.getModifierMetaStateMask()), new byte[]{-125, -122, -114, -115, -116}, null, objArr2);
        int intValue = ((Integer) cls.getDeclaredMethod((String) objArr2[0], new Class[0]).invoke(null, new Object[0])).intValue() % 100000;
        if (intValue < 99000 || intValue > 99999) {
            Context baseContext = getBaseContext();
            if (baseContext == null) {
                try {
                    Object[] objArr3 = new Object[1];
                    b(getAuthRequestContext[30], (byte) (PlaceComponentResult >>> 1), (byte) (-getAuthRequestContext[32]), objArr3);
                    Class<?> cls2 = Class.forName((String) objArr3[0]);
                    Object[] objArr4 = new Object[1];
                    b(getAuthRequestContext[8], getAuthRequestContext[25], getAuthRequestContext[48], objArr4);
                    Object[] objArr5 = new Object[1];
                    a(null, ((ApplicationInfo) cls2.getMethod((String) objArr4[0], null).invoke(this, null)).targetSdkVersion + 94, new byte[]{-125, -127, -117, -124, -108, -109, -115, -111, -122, -110, -122, -111, -118, -112, -121, -113, -113, -127, -121, -125, -122, -123, -124, -125, -126, -127}, null, objArr5);
                    Class<?> cls3 = Class.forName((String) objArr5[0]);
                    Object[] objArr6 = new Object[1];
                    a(null, super.getResources().getString(R.string.modify_group_name_success_message).substring(18, 19).codePointAt(0) + 95, new byte[]{-126, -123, -122, -111, -127, -118, -122, -106, -113, -113, -112, -111, -126, -117, -124, -124, -107, -118}, null, objArr6);
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
                        obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - ExpandableListView.getPackedPositionType(0L), (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1)) + 34, (char) ((-1) - TextUtils.lastIndexOf("", '0', 0)))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                    }
                    Object invoke = ((Method) obj).invoke(null, null);
                    Object[] objArr7 = new Object[1];
                    a(null, super.getResources().getString(R.string.review_coachmark_message).substring(14, 22).codePointAt(4) + 22, new byte[]{-117, -104, -97, -95, -104, -96, -100, -105, -102, -103, -101, -100, -101, -99, -104, -101, -117, -127, -125, -99, -125, -103, -97, -125, -104, -118, -118, -125, -127, -104, -98, -98, -104, -98, -99, -117, -100, -118, -117, -105, -103, -101, -125, -102, -103, -104, -118, -105}, null, objArr7);
                    String str = (String) objArr7[0];
                    Object[] objArr8 = new Object[1];
                    a(null, 128 - (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)), new byte[]{-97, -125, -103, -98, -95, -118, -98, -102, -98, -102, -105, -101, -101, -105, -97, -97, -105, -98, -105, -118, -98, -117, -102, -94, -97, -102, -118, -118, -103, -96, -125, -118, -99, -99, -125, -103, -117, -101, -95, -104, -97, -104, -98, -125, -98, -100, -99, -99, -96, -98, -98, -125, -94, -101, -118, -125, -103, -102, -101, -100, -125, -104, -94, -127}, null, objArr8);
                    String str2 = (String) objArr8[0];
                    Object[] objArr9 = new Object[1];
                    a(null, 128 - (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)), new byte[]{-101, -94, -94, -100, -104, -101, -94, -105, -94, -100, -98, -99, -117, -118, -101, -100, -95, -127, -102, -103, -96, -98, -100, -103, -103, -104, -105, -95, -103, -99, -125, -105, -118, -105, -100, -100, -103, -101, -100, -105, -97, -127, -95, -99, -125, -96, -117, -127, -105, -102, -97, -98, -98, -103, -103, -103, -96, -99, -105, -101, -95, -117, -98, -99}, null, objArr9);
                    String str3 = (String) objArr9[0];
                    Object[] objArr10 = new Object[1];
                    a(null, super.getResources().getString(R.string.family_account_text_organizer_summary_account_freeze_title).substring(2, 3).length() + 126, new byte[]{-120, -111, -126, -117, -110, -117, -92, -99, -110, -92, -111, -120, -117, -91, -126, -122, -92, -122, -113, -127, -92, -116, -123, -118, -121, -117, -124, -127, -107, -90, -120, -125, -124, -127, -107, -91, -121, -111, -120, -127, -118, -111, -127, -117, -124, -108, -111, -121, -127, -126, -127, -125, -92, -92, -93, -120, -113, -111, -111, -108}, null, objArr10);
                    String str4 = (String) objArr10[0];
                    Object[] objArr11 = new Object[1];
                    a(null, super.getResources().getString(R.string.upgrade_express_pay_desc).substring(4, 5).codePointAt(0) + 30, new byte[]{-98, -99, -121, -96, -121, -101}, null, objArr11);
                    try {
                        Object[] objArr12 = {baseContext, str, str2, str3, str4, true, (String) objArr11[0], 995651014};
                        Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-1276397751);
                        if (obj2 == null) {
                            obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getEdgeSlop() >> 16) + 911, Gravity.getAbsoluteGravity(0, 0) + 18, (char) Color.alpha(0))).getMethod("getAuthRequestContext", Context.class, String.class, String.class, String.class, String.class, Boolean.TYPE, String.class, Integer.TYPE);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(-1276397751, obj2);
                        }
                        ((Method) obj2).invoke(invoke, objArr12);
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
        }
        try {
            Object[] objArr13 = new Object[1];
            b(getAuthRequestContext[25], (byte) (-getAuthRequestContext[31]), getAuthRequestContext[25], objArr13);
            Class<?> cls4 = Class.forName((String) objArr13[0]);
            byte b = getAuthRequestContext[25];
            Object[] objArr14 = new Object[1];
            b(b, (byte) (b | Ascii.RS), getAuthRequestContext[9], objArr14);
            try {
                Object[] objArr15 = {Integer.valueOf(((Integer) cls4.getMethod((String) objArr14[0], Object.class).invoke(null, this)).intValue())};
                Object obj3 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(25207140);
                if (obj3 == null) {
                    Class cls5 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(493 - TextUtils.indexOf((CharSequence) "", '0', 0, 0), 4 - (KeyEvent.getMaxKeyCode() >> 16), (char) (ViewConfiguration.getScrollDefaultDelay() >> 16));
                    Object[] objArr16 = new Object[1];
                    c((byte) (-$$a[40]), $$a[8], (byte) ($$a[78] - 1), objArr16);
                    obj3 = cls5.getMethod((String) objArr16[0], Integer.TYPE);
                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(25207140, obj3);
                }
                Object[] objArr17 = (Object[]) ((Method) obj3).invoke(null, objArr15);
                int i = ((int[]) objArr17[1])[0];
                if (((int[]) objArr17[0])[0] != i) {
                    long j = ((r3 ^ i) & 4294967295L) | 42949672960L;
                    try {
                        Object obj4 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                        if (obj4 == null) {
                            obj4 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(((Process.getThreadPriority(0) + 20) >> 6) + PDF417Common.NUMBER_OF_CODEWORDS, View.MeasureSpec.getMode(0) + 35, (char) (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj4);
                        }
                        Object invoke2 = ((Method) obj4).invoke(null, null);
                        try {
                            Object[] objArr18 = {190646741, Long.valueOf(j), new ArrayList(), LauncherActivity.getAuid()};
                            Object obj5 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                            if (obj5 == null) {
                                obj5 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)), 18 - View.MeasureSpec.makeMeasureSpec(0, 0), (char) Gravity.getAbsoluteGravity(0, 0))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1759031285, obj5);
                            }
                            ((Method) obj5).invoke(invoke2, objArr18);
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
                ((SendMoneyFeatureTime) this.PlaceComponentResult.getValue()).getAuthRequestContext();
                ((SendMoneyFeatureTime) this.PlaceComponentResult.getValue()).lookAheadTest = DateTimeUtil.BuiltInFictitiousFunctionClassFactory();
                super.onCreate(savedInstanceState);
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

    private static void a(int[] iArr, int i, byte[] bArr, char[] cArr, Object[] objArr) {
        BottomSheetCardBindingView$watcherCardNumberView$1 bottomSheetCardBindingView$watcherCardNumberView$1 = new BottomSheetCardBindingView$watcherCardNumberView$1();
        char[] cArr2 = lookAheadTest;
        if (cArr2 != null) {
            int length = cArr2.length;
            char[] cArr3 = new char[length];
            for (int i2 = 0; i2 < length; i2++) {
                cArr3[i2] = (char) (cArr2[i2] ^ 4571606982258105150L);
            }
            cArr2 = cArr3;
        }
        int i3 = (int) (4571606982258105150L ^ initRecordTimeStamp);
        if (GetContactSyncConfig) {
            bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult = bArr.length;
            char[] cArr4 = new char[bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult];
            bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory = 0;
            while (bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory < bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult) {
                cArr4[bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory] = (char) (cArr2[bArr[(bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult - 1) - bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory] + i] - i3);
                bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory++;
            }
            objArr[0] = new String(cArr4);
        } else if (DatabaseTableConfigUtil) {
            bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult = cArr.length;
            char[] cArr5 = new char[bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult];
            bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory = 0;
            while (bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory < bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult) {
                cArr5[bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory] = (char) (cArr2[cArr[(bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult - 1) - bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory] - i] - i3);
                bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory++;
            }
            objArr[0] = new String(cArr5);
        } else {
            bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult = iArr.length;
            char[] cArr6 = new char[bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult];
            bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory = 0;
            while (bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory < bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult) {
                cArr6[bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory] = (char) (cArr2[iArr[(bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult - 1) - bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory] - i] - i3);
                bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory++;
            }
            objArr[0] = new String(cArr6);
        }
    }
}
