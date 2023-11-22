package id.dana.sendmoney.external;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.ImageFormat;
import android.graphics.PointF;
import android.media.AudioTrack;
import android.os.Build;
import android.os.Process;
import android.os.SystemClock;
import android.text.AndroidCharacter;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.Group;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import androidx.view.OnBackPressedCallback;
import androidx.view.OnBackPressedDispatcher;
import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.alipay.iap.android.common.syncintegration.api.IAPSyncCommand;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.ethanhua.skeleton.Skeleton;
import com.ethanhua.skeleton.SkeletonScreen;
import com.ethanhua.skeleton.ViewSkeletonScreen;
import com.google.common.base.Ascii;
import com.google.zxing.pdf417.PDF417Common;
import dagger.internal.Preconditions;
import id.dana.R;
import id.dana.base.BaseActivity;
import id.dana.base.BaseRecyclerViewHolder;
import id.dana.component.dialogcomponent.CustomDialog;
import id.dana.component.extension.ViewExtKt;
import id.dana.core.ui.glide.GlideApp;
import id.dana.core.ui.glide.GlideRequests;
import id.dana.danah5.DanaH5;
import id.dana.data.constant.DanaUrl;
import id.dana.di.component.ApplicationComponent;
import id.dana.di.component.DaggerSendMoneyExternalComponent;
import id.dana.di.modules.SendMoneyExternalModule;
import id.dana.domain.sendmoney.model.QrisTcicoEntryPointInfo;
import id.dana.domain.sendmoney.model.TransferInit;
import id.dana.domain.sendmoney.model.WithdrawChannelInfoData;
import id.dana.onboarding.splash.LauncherActivity;
import id.dana.sendmoney.external.SendMoneyExternalContract;
import id.dana.sendmoney.external.SendMoneyOutletOptionBottomSheetDialog;
import id.dana.sendmoney.model.ExternalWithdrawChannelModel;
import id.dana.sendmoney_v2.landing.di.module.SendMoneyTrackerModule;
import id.dana.sendmoney_v2.tracker.SendMoneyAnalyticTracker;
import id.dana.sendmoney_v2.tracker.SendMoneyFeatureTime;
import id.dana.utils.ImageUtil;
import id.dana.utils.TagFormat;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import o.E;
import o.SummaryVoucherView$$ExternalSyntheticLambda0;
import o.getOnBoardingScenario;

@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 92\u00020\u0001:\u00019B\u0007¢\u0006\u0004\b8\u0010\u0004J\u000f\u0010\u0003\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\b\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\b\u0010\u0004J\u0019\u0010\u000b\u001a\u00020\u00022\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u0019\u0010\u000f\u001a\u00020\u00022\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J#\u0010\u0015\u001a\u00020\u0012*\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u0012H\u0002¢\u0006\u0004\b\u0015\u0010\u0016R\u0016\u0010\u0015\u001a\u00020\u00178\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001c\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0016\u0010\u001e\u001a\u00020\u00178\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u001d\u0010\u0019R\u0016\u0010!\u001a\u00020\u00118\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u001f\u0010 R\"\u0010#\u001a\u00020\"8\u0007@\u0007X\u0087.¢\u0006\u0012\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\"\u0010*\u001a\u00020)8\u0007@\u0007X\u0087.¢\u0006\u0012\n\u0004\b*\u0010+\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R\u0013\u00103\u001a\u000200X\u0083\u0080\u0002¢\u0006\u0006\n\u0004\b1\u00102R\u0016\u00107\u001a\u0002048\u0002@\u0002X\u0083.¢\u0006\u0006\n\u0004\b5\u00106"}, d2 = {"Lid/dana/sendmoney/external/SendMoneyExternalActivity;", "Lid/dana/base/BaseActivity;", "", "configToolbar", "()V", "", "getLayout", "()I", IAPSyncCommand.COMMAND_INIT, "Landroid/view/View;", "view", "onClickLeftMenuButton", "(Landroid/view/View;)V", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "(Landroid/os/Bundle;)V", "Lid/dana/sendmoney/model/ExternalWithdrawChannelModel;", "", "p0", "p1", "KClassImpl$Data$declaredNonStaticMembers$2", "(Lid/dana/sendmoney/model/ExternalWithdrawChannelModel;ZZ)Z", "Lid/dana/sendmoney/external/SendMoneyExternalOutletAdapter;", "NetworkUserEntityData$$ExternalSyntheticLambda0", "Lid/dana/sendmoney/external/SendMoneyExternalOutletAdapter;", "scheduleImpl", "Z", "PlaceComponentResult", "lookAheadTest", "BuiltInFictitiousFunctionClassFactory", "getErrorConfigVersion", "Lid/dana/sendmoney/model/ExternalWithdrawChannelModel;", "getAuthRequestContext", "Lid/dana/sendmoney_v2/tracker/SendMoneyAnalyticTracker;", "sendMoneyAnalyticTracker", "Lid/dana/sendmoney_v2/tracker/SendMoneyAnalyticTracker;", "getSendMoneyAnalyticTracker", "()Lid/dana/sendmoney_v2/tracker/SendMoneyAnalyticTracker;", "setSendMoneyAnalyticTracker", "(Lid/dana/sendmoney_v2/tracker/SendMoneyAnalyticTracker;)V", "Lid/dana/sendmoney/external/SendMoneyExternalContract$Presenter;", "sendMoneyExternalPresenter", "Lid/dana/sendmoney/external/SendMoneyExternalContract$Presenter;", "getSendMoneyExternalPresenter", "()Lid/dana/sendmoney/external/SendMoneyExternalContract$Presenter;", "setSendMoneyExternalPresenter", "(Lid/dana/sendmoney/external/SendMoneyExternalContract$Presenter;)V", "Lid/dana/sendmoney_v2/tracker/SendMoneyFeatureTime;", "DatabaseTableConfigUtil", "Lkotlin/Lazy;", "MyBillsEntityDataFactory", "Lcom/ethanhua/skeleton/SkeletonScreen;", "NetworkUserEntityData$$ExternalSyntheticLambda1", "Lcom/ethanhua/skeleton/SkeletonScreen;", "moveToNextValue", "<init>", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class SendMoneyExternalActivity extends BaseActivity {
    private static int GetContactSyncConfig;
    private static long NetworkUserEntityData$$ExternalSyntheticLambda2;
    private static char NetworkUserEntityData$$ExternalSyntheticLambda7;
    private static long initRecordTimeStamp;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda0  reason: from kotlin metadata */
    private SendMoneyExternalOutletAdapter KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda1  reason: from kotlin metadata */
    private SkeletonScreen moveToNextValue;

    /* renamed from: getErrorConfigVersion  reason: from kotlin metadata */
    private ExternalWithdrawChannelModel getAuthRequestContext;

    /* renamed from: lookAheadTest  reason: from kotlin metadata */
    private SendMoneyExternalOutletAdapter BuiltInFictitiousFunctionClassFactory;

    /* renamed from: scheduleImpl  reason: from kotlin metadata */
    private boolean PlaceComponentResult;
    @Inject
    public SendMoneyAnalyticTracker sendMoneyAnalyticTracker;
    @Inject
    public SendMoneyExternalContract.Presenter sendMoneyExternalPresenter;
    public static final byte[] $$g = {61, 16, -46, 32, 2, 63, -3, -52, 56, -1, 15, -11, -49, 72, -4, -9, 18, 4, -6, 2, -10, 19, 9, -73, 40, Ascii.FS, -9, -14, 36, -6, 2, -10, 19, 9, -54, 36, 19, -9, 15, -11, 13, 7, 22, -14, -27, Ascii.FS, 11, 4, 10, 1, -24, 14, 0, -61, TarHeader.LF_DIR, 13, -1, 9, -13, Ascii.SUB, -73, 65, 4, -11, 9, 5, -5, -53, 71, -12, 0, Ascii.DC4, -1, -7, 13, 7, -73, TarHeader.LF_FIFO, 9, 8, -63, 71, -12, 15, 6, -11, -4, 4, -53, 22, 41, 8, -26, 35, -3, 5, -11, -19, 19, 19, -15, 14, -6, 17, -13, 15};
    public static final int $$h = 60;
    public static final byte[] $$a = {Ascii.US, -80, -88, -103, 58, -5, 10, 15, -36, 44, -33, 42, 1, Ascii.CAN, -4, 18, -4, 13, 13, 5, -38, TarHeader.LF_FIFO, 0, -4, Ascii.CAN, -4, 13, 6, -36, TarHeader.LF_NORMAL, -4, Ascii.EM, 7, -38, 34, 9, Ascii.CAN, 2, 10, 14, TarHeader.LF_CHR, -48, 46, 10, 7, 14, -39, TarHeader.LF_NORMAL, 13, -4, 18, 12, -46, 36, Ascii.SUB, -12, -20, 34, 9, Ascii.CAN, 2, 10, 14, 5, 22, -44, 59, 6, -5, -15, Ascii.SUB, 19, 11, -9, Ascii.NAK, 8, -42, TarHeader.LF_CHR, 6, 13, -8, Ascii.SUB, 3, 35, -4, 9, 9, -27, TarHeader.LF_CHR, 5, 10, 6, 6, -2, 16, 13, -27, Ascii.SUB, Ascii.NAK, 9, -2, 15, -1, TarHeader.LF_NORMAL, -4, Ascii.EM, 7, -35, 43, 10, 3, -65, 39, 36, Ascii.SUB, -12, -54, 71, 8, 5, 16, -4, Ascii.CAN, -6, 6, -15, 40, 6, -20, 40, -12, Ascii.SUB, -4, 1, -15, Ascii.US, 15, -4, 10, Ascii.DC4, 8, -72, Ascii.NAK};
    public static final int $$b = 145;
    public static final byte[] PlaceComponentResult = {113, -101, 105, Ascii.SUB, -17, 6, -18, -1, 2, 1, TarHeader.LF_SYMLINK, -57, -16, -3, -10, 11, -13, -10, 66, -25, -48, -3, -10, 11, -23, 0, 1, -5, -13, -10, 7, -15, -9, 45, -29, -22, 7, 33, -48, 7, -5, 5, -25, 17, 47, -66, 7, -17, 3, TarHeader.LF_DIR, -41, -42, 2, -5, 11, -12, -2, -19, 47, -51, -4, 0, -1, 2, -2, -23, 7, -10, -3, 33, -41, 4, -13};
    public static final int getAuthRequestContext = 35;
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();

    /* renamed from: DatabaseTableConfigUtil  reason: from kotlin metadata */
    private final Lazy MyBillsEntityDataFactory = LazyKt.lazy(new Function0<SendMoneyFeatureTime>() { // from class: id.dana.sendmoney.external.SendMoneyExternalActivity$sendMoneyFeatureTime$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final SendMoneyFeatureTime invoke() {
            return SendMoneyFeatureTime.INSTANCE.MyBillsEntityDataFactory();
        }
    });

    static {
        BuiltInFictitiousFunctionClassFactory();
        INSTANCE = new Companion(null);
    }

    static void BuiltInFictitiousFunctionClassFactory() {
        initRecordTimeStamp = 6567511432012563813L;
        NetworkUserEntityData$$ExternalSyntheticLambda7 = (char) 50776;
        NetworkUserEntityData$$ExternalSyntheticLambda2 = 4360990799332652212L;
        GetContactSyncConfig = -956812108;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0026  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x001e  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0026 -> B:11:0x002c). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void c(byte r6, short r7, byte r8, java.lang.Object[] r9) {
        /*
            int r6 = 23 - r6
            int r8 = 106 - r8
            int r7 = r7 + 4
            byte[] r0 = id.dana.sendmoney.external.SendMoneyExternalActivity.PlaceComponentResult
            byte[] r1 = new byte[r6]
            int r6 = r6 + (-1)
            r2 = 0
            if (r0 != 0) goto L14
            r8 = r7
            r3 = r8
            r4 = 0
            r7 = r6
            goto L2c
        L14:
            r3 = 0
        L15:
            byte r4 = (byte) r8
            r1[r3] = r4
            int r7 = r7 + 1
            int r4 = r3 + 1
            if (r3 != r6) goto L26
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            r9[r2] = r6
            return
        L26:
            r3 = r0[r7]
            r5 = r7
            r7 = r6
            r6 = r8
            r8 = r5
        L2c:
            int r3 = -r3
            int r6 = r6 + r3
            int r6 = r6 + (-4)
            r3 = r4
            r5 = r8
            r8 = r6
            r6 = r7
            r7 = r5
            goto L15
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.sendmoney.external.SendMoneyExternalActivity.c(byte, short, byte, java.lang.Object[]):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0026  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x001e  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0026 -> B:11:0x0030). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void g(byte r6, byte r7, short r8, java.lang.Object[] r9) {
        /*
            int r8 = 42 - r8
            int r7 = 102 - r7
            int r6 = 103 - r6
            byte[] r0 = id.dana.sendmoney.external.SendMoneyExternalActivity.$$a
            byte[] r1 = new byte[r8]
            int r8 = r8 + (-1)
            r2 = 0
            if (r0 != 0) goto L16
            r6 = r7
            r3 = r1
            r4 = 0
            r1 = r0
            r0 = r9
            r9 = r8
            goto L30
        L16:
            r3 = 0
        L17:
            byte r4 = (byte) r6
            r1[r3] = r4
            int r4 = r3 + 1
            if (r3 != r8) goto L26
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            r9[r2] = r6
            return
        L26:
            r3 = r0[r7]
            r5 = r8
            r8 = r6
            r6 = r7
            r7 = r3
            r3 = r1
            r1 = r0
            r0 = r9
            r9 = r5
        L30:
            int r8 = r8 + r7
            int r7 = r8 + (-7)
            int r6 = r6 + 1
            r8 = r9
            r9 = r0
            r0 = r1
            r1 = r3
            r3 = r4
            r5 = r7
            r7 = r6
            r6 = r5
            goto L17
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.sendmoney.external.SendMoneyExternalActivity.g(byte, byte, short, java.lang.Object[]):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0023  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x001b  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0023 -> B:11:0x002e). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void h(byte r6, byte r7, int r8, java.lang.Object[] r9) {
        /*
            int r6 = 105 - r6
            int r8 = 56 - r8
            int r7 = 51 - r7
            byte[] r0 = id.dana.sendmoney.external.SendMoneyExternalActivity.$$g
            byte[] r1 = new byte[r8]
            int r8 = r8 + (-1)
            r2 = 0
            if (r0 != 0) goto L15
            r3 = r1
            r4 = 0
            r1 = r0
            r0 = r9
            r9 = r8
            goto L2e
        L15:
            r3 = 0
        L16:
            byte r4 = (byte) r6
            r1[r3] = r4
            if (r3 != r8) goto L23
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            r9[r2] = r6
            return
        L23:
            int r3 = r3 + 1
            r4 = r0[r7]
            r5 = r9
            r9 = r8
            r8 = r4
            r4 = r3
            r3 = r1
            r1 = r0
            r0 = r5
        L2e:
            int r6 = r6 + r8
            int r6 = r6 + (-2)
            int r7 = r7 + 1
            r8 = r9
            r9 = r0
            r0 = r1
            r1 = r3
            r3 = r4
            goto L16
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.sendmoney.external.SendMoneyExternalActivity.h(byte, byte, int, java.lang.Object[]):void");
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
        a(12781 - (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)), new char[]{54343, 58789, 47000, 16787, 5117, 11758, 65484, 35187, 23329, 5376, 10058, 61785, 33608, 23872, 28339, 14496, 51845, 34024}, objArr5);
        Class<?> cls = Class.forName((String) objArr5[0]);
        Object[] objArr6 = new Object[1];
        a(Color.green(0) + 37379, new char[]{54347, 18012, 61557, 25158, 40014}, objArr6);
        int intValue = ((Integer) cls.getDeclaredMethod((String) objArr6[0], new Class[0]).invoke(null, new Object[0])).intValue() % 100000;
        if (intValue < 99000 || intValue > 99999) {
            Context applicationContext = context != null ? context.getApplicationContext() : context;
            if (applicationContext != null) {
                try {
                    Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                    if (obj == null) {
                        obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(TextUtils.indexOf((CharSequence) "", '0', 0) + 930, (ViewConfiguration.getDoubleTapTimeout() >> 16) + 35, (char) (((byte) KeyEvent.getModifierMetaStateMask()) + 1))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                    }
                    Object invoke = ((Method) obj).invoke(null, null);
                    Object[] objArr7 = new Object[1];
                    b(new char[]{0, 0, 0, 0}, new char[]{12549, 53294, 44549, 32350, 60209, 7696, 5802, 22992, 29763, 44223, 38456, 39199, 61271, 47970, 4985, 39183, 273, 40794, 14800, 48648, 31406, 50606, 6248, 58160, 4047, 43775, 22039, 2386, 3185, 53270, 35754, 25008, 16125, 24798, 60280, 12365, 65300, 33435, 23176, 39010, 23328, 35435, 26343, 1849, 42815, 55374, 49695, 51888}, (char) (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)), (SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)) - 1, new char[]{43339, 55438, 39013, 1154}, objArr7);
                    String str = (String) objArr7[0];
                    Object[] objArr8 = new Object[1];
                    b(new char[]{0, 0, 0, 0}, new char[]{35259, 18306, 51653, 51777, 36301, 48172, 11645, 62437, 42412, 29489, 40614, 25799, 6345, 16882, 51969, 39101, 55271, 46592, 46163, 39051, 5803, 11596, 24689, 29874, 35003, 26422, 954, 60905, 48447, 65404, 52087, 30295, 44662, 29477, 5255, 20549, 23954, 53328, 41800, 58393, 57821, 25570, 22674, 35245, 1867, 22527, 39071, 15757, 48597, 7173, 51698, 7768, 51963, 50214, 51985, 45636, 42750, 39936, 61278, 10937, 49842, 5316, 6660, 50109}, (char) (ViewConfiguration.getPressedStateDuration() >> 16), KeyEvent.getMaxKeyCode() >> 16, new char[]{16574, 6062, 8467, 37699}, objArr8);
                    String str2 = (String) objArr8[0];
                    Object[] objArr9 = new Object[1];
                    a(62497 - View.MeasureSpec.makeMeasureSpec(0, 0), new char[]{54292, 8246, 15361, 2087, 1179, 4276, 27858, 30965, 29974, 16695, 23892, 43388, 42395, 45496, 36312, 39422, 38487, 57970, 65088, 51761, 50816, 54001, 11921, 15074, 14089, 889, 8005, 27493, 26588, 29693, 20431, 23482, 20529, 44035, 47222, 46237, 32992, 40148, 59638, 58649, 61750, 52489, 55677, 54681, 8626, 15835, 2473, 1611, 4720, 28238, 31287, 30416, 17056, 24258, 43702, 42756, 45865, 36682, 39781, 38795, 58364, 65486, 52205, 49152}, objArr9);
                    String str3 = (String) objArr9[0];
                    Object[] objArr10 = new Object[1];
                    a(View.resolveSize(0, 0) + 5051, new char[]{54350, 51177, 62244, 61287, 39609, 46779, 41579, 24084, 18842, 26068, 4358, 3406, 14540, 54317, 49268, 62369, 61427, 39724, 46964, 41636, 24283, 18946, 26176, 4549, 3529, 14608, 54457, 49389, 64566, 59514, 39869, 47094, 41767, 24399, 19093, 26265, 4617, 3662, 14729, 54644, 49535, 64677, 59617, 33888, 45163, 41879, 24539, 19222, 26437, 4761, 3727, 14865, 54760, 49598, 64817, 59773, 33963, 45291, 44044, 22604}, objArr10);
                    String str4 = (String) objArr10[0];
                    Object[] objArr11 = new Object[1];
                    a(16777 - AndroidCharacter.getMirror('0'), new char[]{54303, 38225, 22176, 4099, 53616, 37546}, objArr11);
                    try {
                        Object[] objArr12 = {applicationContext, str, str2, str3, str4, true, (String) objArr11[0], 995651014};
                        Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-1276397751);
                        if (obj2 == null) {
                            obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(Color.argb(0, 0, 0, 0) + 911, (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)) + 18, (char) (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)))).getMethod("getAuthRequestContext", Context.class, String.class, String.class, String.class, String.class, Boolean.TYPE, String.class, Integer.TYPE);
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
                c(PlaceComponentResult[30], (byte) (getAuthRequestContext + 1), PlaceComponentResult[25], objArr13);
                Class<?> cls2 = Class.forName((String) objArr13[0]);
                Object[] objArr14 = new Object[1];
                c(PlaceComponentResult[30], (short) 21, PlaceComponentResult[9], objArr14);
                try {
                    Object[] objArr15 = {applicationContext2, Integer.valueOf(((Integer) cls2.getMethod((String) objArr14[0], Object.class).invoke(null, this)).intValue())};
                    Object obj3 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1691739267);
                    if (obj3 == null) {
                        Class cls3 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(View.getDefaultSize(0, 0) + 55, Color.alpha(0) + 3, (char) ExpandableListView.getPackedPositionGroup(0L));
                        byte b = $$a[54];
                        Object[] objArr16 = new Object[1];
                        g(b, (byte) (b | 36), $$a[15], objArr16);
                        obj3 = cls3.getMethod((String) objArr16[0], Context.class, Integer.TYPE);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1691739267, obj3);
                    }
                    Object invoke2 = ((Method) obj3).invoke(null, objArr15);
                    try {
                        Object obj4 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(40157535);
                        if (obj4 == null) {
                            obj4 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(Color.argb(0, 0, 0, 0) + 800, ((Process.getThreadPriority(0) + 20) >> 6) + 15, (char) (ViewConfiguration.getWindowTouchSlop() >> 8))).getMethod("getAuthRequestContext", null);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(40157535, obj4);
                        }
                        int intValue2 = ((Integer) ((Method) obj4).invoke(invoke2, null)).intValue();
                        try {
                            Object obj5 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1621779126);
                            if (obj5 == null) {
                                obj5 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(800 - (ViewConfiguration.getScrollBarFadeDuration() >> 16), 14 - MotionEvent.axisFromString(""), (char) ((-1) - MotionEvent.axisFromString("")))).getMethod("PlaceComponentResult", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1621779126, obj5);
                            }
                            if (((Integer) ((Method) obj5).invoke(invoke2, null)).intValue() != intValue2) {
                                ArrayList arrayList = new ArrayList();
                                try {
                                    Object[] objArr17 = {invoke2};
                                    Object obj6 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(658700871);
                                    if (obj6 == null) {
                                        obj6 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(815 - (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)), View.resolveSize(0, 0) + 29, (char) (KeyEvent.getDeadChar(0, 0) + 57994))).getMethod("getAuthRequestContext", (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(800 - (ViewConfiguration.getScrollBarFadeDuration() >> 16), (ViewConfiguration.getPressedStateDuration() >> 16) + 15, (char) (ViewConfiguration.getKeyRepeatTimeout() >> 16)));
                                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(658700871, obj6);
                                    }
                                    arrayList.add(((Method) obj6).invoke(null, objArr17));
                                    long j = ((r4 ^ intValue2) & 4294967295L) | 60129542144L;
                                    try {
                                        Object obj7 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                                        if (obj7 != null) {
                                            objArr = null;
                                        } else {
                                            objArr = null;
                                            obj7 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)) + PDF417Common.MAX_CODEWORDS_IN_BARCODE, ImageFormat.getBitsPerPixel(0) + 36, (char) (ExpandableListView.getPackedPositionChild(0L) + 1))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj7);
                                        }
                                        Object invoke3 = ((Method) obj7).invoke(objArr, objArr);
                                        try {
                                            Object[] objArr18 = {1650045342, Long.valueOf(j), arrayList, LauncherActivity.getAuid()};
                                            Object obj8 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                            if (obj8 == null) {
                                                obj8 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)) + 911, 18 - View.MeasureSpec.getMode(0), (char) TextUtils.getCapsMode("", 0, 0))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                c(PlaceComponentResult[30], (byte) (getAuthRequestContext + 1), PlaceComponentResult[25], objArr19);
                Class<?> cls4 = Class.forName((String) objArr19[0]);
                Object[] objArr20 = new Object[1];
                c(PlaceComponentResult[30], (short) 21, PlaceComponentResult[9], objArr20);
                try {
                    Object[] objArr21 = {applicationContext3, Integer.valueOf(((Integer) cls4.getMethod((String) objArr20[0], Object.class).invoke(null, this)).intValue())};
                    Object obj9 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(345757441);
                    if (obj9 == null) {
                        Class cls5 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(62 - (ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)), (ViewConfiguration.getMinimumFlingVelocity() >> 16) + 46, (char) (ImageFormat.getBitsPerPixel(0) + 1));
                        Object[] objArr22 = new Object[1];
                        g($$a[22], $$a[112], $$a[74], objArr22);
                        obj9 = cls5.getMethod((String) objArr22[0], Context.class, Integer.TYPE);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(345757441, obj9);
                    }
                    Object[] objArr23 = (Object[]) ((Method) obj9).invoke(null, objArr21);
                    int i = ((int[]) objArr23[1])[0];
                    if (((int[]) objArr23[0])[0] != i) {
                        long j2 = ((r1 ^ i) & 4294967295L) | 17179869184L;
                        try {
                            Object obj10 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                            if (obj10 != null) {
                                objArr2 = null;
                            } else {
                                objArr2 = null;
                                obj10 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)) + PDF417Common.MAX_CODEWORDS_IN_BARCODE, 35 - (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)), (char) ((-16777216) - Color.rgb(0, 0, 0)))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj10);
                            }
                            Object invoke4 = ((Method) obj10).invoke(objArr2, objArr2);
                            try {
                                Object[] objArr24 = {1650045342, Long.valueOf(j2), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj11 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj11 == null) {
                                    obj11 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - KeyEvent.getDeadChar(0, 0), KeyEvent.keyCodeFromString("") + 18, (char) ExpandableListView.getPackedPositionGroup(0L))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                c(PlaceComponentResult[30], (byte) (getAuthRequestContext + 1), PlaceComponentResult[25], objArr25);
                Class<?> cls6 = Class.forName((String) objArr25[0]);
                Object[] objArr26 = new Object[1];
                c(PlaceComponentResult[30], (short) 21, PlaceComponentResult[9], objArr26);
                try {
                    Object[] objArr27 = {applicationContext4, Integer.valueOf(((Integer) cls6.getMethod((String) objArr26[0], Object.class).invoke(null, this)).intValue())};
                    Object obj12 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-697999596);
                    if (obj12 == null) {
                        Class cls7 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(119 - (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)), 3 - ExpandableListView.getPackedPositionType(0L), (char) (38968 - Color.alpha(0)));
                        Object[] objArr28 = new Object[1];
                        g($$a[22], $$a[112], $$a[74], objArr28);
                        obj12 = cls7.getMethod((String) objArr28[0], Context.class, Integer.TYPE);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(-697999596, obj12);
                    }
                    Object[] objArr29 = (Object[]) ((Method) obj12).invoke(null, objArr27);
                    int i2 = ((int[]) objArr29[1])[0];
                    if (((int[]) objArr29[0])[0] != i2) {
                        long j3 = ((r1 ^ i2) & 4294967295L) | 8589934592L;
                        try {
                            Object obj13 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                            if (obj13 != null) {
                                objArr3 = null;
                            } else {
                                objArr3 = null;
                                obj13 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - (KeyEvent.getMaxKeyCode() >> 16), Color.alpha(0) + 35, (char) Color.red(0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj13);
                            }
                            Object invoke5 = ((Method) obj13).invoke(objArr3, objArr3);
                            try {
                                Object[] objArr30 = {1650045342, Long.valueOf(j3), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj14 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj14 == null) {
                                    obj14 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - TextUtils.getCapsMode("", 0, 0), TextUtils.indexOf("", "") + 18, (char) (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                c(PlaceComponentResult[30], (byte) (getAuthRequestContext + 1), PlaceComponentResult[25], objArr31);
                Class<?> cls8 = Class.forName((String) objArr31[0]);
                Object[] objArr32 = new Object[1];
                c(PlaceComponentResult[30], (short) 21, PlaceComponentResult[9], objArr32);
                try {
                    Object[] objArr33 = {applicationContext5, Integer.valueOf(((Integer) cls8.getMethod((String) objArr32[0], Object.class).invoke(null, this)).intValue())};
                    Object obj15 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-16683571);
                    if (obj15 == null) {
                        Class cls9 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(View.resolveSize(0, 0) + 107, ExpandableListView.getPackedPositionChild(0L) + 4, (char) (ViewConfiguration.getMaximumFlingVelocity() >> 16));
                        byte b2 = $$a[22];
                        Object[] objArr34 = new Object[1];
                        g((byte) 28, b2, b2, objArr34);
                        obj15 = cls9.getMethod((String) objArr34[0], Context.class, Integer.TYPE);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(-16683571, obj15);
                    }
                    Object[] objArr35 = (Object[]) ((Method) obj15).invoke(null, objArr33);
                    int i3 = ((int[]) objArr35[1])[0];
                    if (((int[]) objArr35[0])[0] != i3) {
                        long j4 = ((r1 ^ i3) & 4294967295L) | 4294967296L;
                        try {
                            Object obj16 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                            if (obj16 != null) {
                                objArr4 = null;
                            } else {
                                objArr4 = null;
                                obj16 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getScrollBarFadeDuration() >> 16) + PDF417Common.NUMBER_OF_CODEWORDS, (Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1)) + 34, (char) (ViewConfiguration.getFadingEdgeLength() >> 16))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj16);
                            }
                            Object invoke6 = ((Method) obj16).invoke(objArr4, objArr4);
                            try {
                                Object[] objArr36 = {1650045342, Long.valueOf(j4), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj17 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj17 == null) {
                                    obj17 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(MotionEvent.axisFromString("") + 912, 18 - (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)), (char) (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
        return R.layout.activity_send_money_external;
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
            b(new char[]{0, 0, 0, 0}, new char[]{30887, 9702, 18759, 17307, 33253, 34506, 16998, 65462, 43406, 61930, 21180, 52717, 43464, 50607, 47247, 53597, 33866, 43162, 57250, 55611, 54893, 36373, 18510, 34260, 36129, 398}, (char) (super.getResources().getString(R.string.tnc_dialog_button_ok_text).substring(17, 18).length() + 46897), super.getResources().getString(R.string.installment_simulation_bill_amount_title).substring(3, 4).length() - 1, new char[]{38093, 53456, 13023, 28599}, objArr);
            Class<?> cls = Class.forName((String) objArr[0]);
            Object[] objArr2 = new Object[1];
            a(28056 - TextUtils.indexOf((CharSequence) "", '0'), new char[]{54341, 47562, 3942, 40095, 25127, 63413, 17860, 11080, 47262, 3639, 37808, 25052, 63337, 17538, 10764, 49080, 3545, 37729}, objArr2);
            baseContext = (Context) cls.getMethod((String) objArr2[0], new Class[0]).invoke(null, null);
        }
        if (baseContext != null) {
            baseContext = baseContext.getApplicationContext();
        }
        if (baseContext != null) {
            try {
                Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                if (obj == null) {
                    obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(Process.getGidForName("") + 930, 35 - ((Process.getThreadPriority(0) + 20) >> 6), (char) Color.blue(0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                }
                Object invoke = ((Method) obj).invoke(null, null);
                try {
                    Object[] objArr3 = {baseContext};
                    Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-549958681);
                    if (obj2 == null) {
                        obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((Process.myTid() >> 22) + 911, 18 - (ViewConfiguration.getMinimumFlingVelocity() >> 16), (char) View.resolveSize(0, 0))).getMethod("MyBillsEntityDataFactory", Context.class);
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

    @Override // id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onResume() {
        Context baseContext = getBaseContext();
        if (baseContext == null) {
            Object[] objArr = new Object[1];
            b(new char[]{0, 0, 0, 0}, new char[]{30887, 9702, 18759, 17307, 33253, 34506, 16998, 65462, 43406, 61930, 21180, 52717, 43464, 50607, 47247, 53597, 33866, 43162, 57250, 55611, 54893, 36373, 18510, 34260, 36129, 398}, (char) (super.getResources().getString(R.string.sendmoney_max_bank_dialog_description).substring(26, 27).length() + 46897), TextUtils.lastIndexOf("", '0', 0, 0) + 1, new char[]{38093, 53456, 13023, 28599}, objArr);
            Class<?> cls = Class.forName((String) objArr[0]);
            Object[] objArr2 = new Object[1];
            a(super.getResources().getString(R.string.family_account_text_title_intro_2).substring(11, 12).codePointAt(0) + 27960, new char[]{54341, 47562, 3942, 40095, 25127, 63413, 17860, 11080, 47262, 3639, 37808, 25052, 63337, 17538, 10764, 49080, 3545, 37729}, objArr2);
            baseContext = (Context) cls.getMethod((String) objArr2[0], new Class[0]).invoke(null, null);
        }
        if (baseContext != null) {
            baseContext = baseContext.getApplicationContext();
        }
        if (baseContext != null) {
            try {
                Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                if (obj == null) {
                    obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)) + PDF417Common.NUMBER_OF_CODEWORDS, 35 - View.MeasureSpec.getMode(0), (char) Color.alpha(0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                }
                Object invoke = ((Method) obj).invoke(null, null);
                try {
                    Object[] objArr3 = {baseContext};
                    Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(247288059);
                    if (obj2 == null) {
                        obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(910 - TextUtils.indexOf((CharSequence) "", '0'), View.MeasureSpec.getSize(0) + 18, (char) KeyEvent.normalizeMetaState(0))).getMethod("KClassImpl$Data$declaredNonStaticMembers$2", Context.class);
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

    @JvmName(name = "getSendMoneyExternalPresenter")
    public final SendMoneyExternalContract.Presenter getSendMoneyExternalPresenter() {
        SendMoneyExternalContract.Presenter presenter = this.sendMoneyExternalPresenter;
        if (presenter != null) {
            return presenter;
        }
        Intrinsics.throwUninitializedPropertyAccessException("");
        return null;
    }

    @JvmName(name = "setSendMoneyExternalPresenter")
    public final void setSendMoneyExternalPresenter(SendMoneyExternalContract.Presenter presenter) {
        Intrinsics.checkNotNullParameter(presenter, "");
        this.sendMoneyExternalPresenter = presenter;
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
        setCenterTitle(getString(R.string.sendmoney_send_and_withdraw_cash));
        setMenuLeftButton(R.drawable.btn_arrow_left);
    }

    private static boolean KClassImpl$Data$declaredNonStaticMembers$2(ExternalWithdrawChannelModel externalWithdrawChannelModel, boolean z, boolean z2) {
        return !z || externalWithdrawChannelModel.PlaceComponentResult() || z2;
    }

    @Override // id.dana.base.BaseActivity
    public final void onClickLeftMenuButton(View view) {
        onBackPressed();
    }

    public static /* synthetic */ void $r8$lambda$Qus0jQhYHvABaWWNgrJkWNCORp8(SendMoneyExternalOutletAdapter sendMoneyExternalOutletAdapter, SendMoneyExternalActivity sendMoneyExternalActivity, int i) {
        Intrinsics.checkNotNullParameter(sendMoneyExternalOutletAdapter, "");
        Intrinsics.checkNotNullParameter(sendMoneyExternalActivity, "");
        ExternalWithdrawChannelModel item = sendMoneyExternalOutletAdapter.getItem(i);
        if (item != null) {
            Boolean bool = item.BuiltInFictitiousFunctionClassFactory;
            boolean booleanValue = bool != null ? bool.booleanValue() : false;
            Boolean bool2 = item.MyBillsEntityDataFactory;
            if (bool2 != null) {
                boolean booleanValue2 = bool2.booleanValue();
                if (KClassImpl$Data$declaredNonStaticMembers$2(item, booleanValue, booleanValue2)) {
                    String str = item.getAuthRequestContext;
                    if (str == null || str.length() == 0) {
                        sendMoneyExternalActivity.getAuthRequestContext = item;
                        if (item == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("");
                            item = null;
                        }
                        SendMoneyOutletOptionBottomSheetDialog.Companion companion = SendMoneyOutletOptionBottomSheetDialog.INSTANCE;
                        SendMoneyOutletOptionBottomSheetDialog.Companion.getAuthRequestContext(item, booleanValue2, sendMoneyExternalActivity.PlaceComponentResult).show(sendMoneyExternalActivity.getSupportFragmentManager(), "SendMoneyOutletOptionBottomSheetDialog");
                    }
                }
            }
        }
    }

    public static /* synthetic */ void $r8$lambda$VXDKMnMVeLAjIdu1flZw__n0zek(SendMoneyExternalActivity sendMoneyExternalActivity, SendMoneyExternalOutletAdapter sendMoneyExternalOutletAdapter, int i) {
        Intrinsics.checkNotNullParameter(sendMoneyExternalActivity, "");
        Intrinsics.checkNotNullParameter(sendMoneyExternalOutletAdapter, "");
        ExternalWithdrawChannelModel item = sendMoneyExternalOutletAdapter.getItem(i);
        Intrinsics.checkNotNullExpressionValue(item, "");
        ExternalWithdrawChannelModel externalWithdrawChannelModel = item;
        Boolean bool = externalWithdrawChannelModel.MyBillsEntityDataFactory;
        if (bool == null || !bool.booleanValue()) {
            return;
        }
        String MyBillsEntityDataFactory = TagFormat.MyBillsEntityDataFactory("https://m.dana.id/m/cashout-atm?withdrawPayOption={withdrawPayOption}&withdrawInstId={withdrawInstId}&withdrawInstLocalName={withdrawInstLocalName}").MyBillsEntityDataFactory("withdrawPayOption", externalWithdrawChannelModel.NetworkUserEntityData$$ExternalSyntheticLambda1).MyBillsEntityDataFactory("withdrawInstId", externalWithdrawChannelModel.NetworkUserEntityData$$ExternalSyntheticLambda0).MyBillsEntityDataFactory("withdrawInstLocalName", externalWithdrawChannelModel.scheduleImpl).MyBillsEntityDataFactory();
        Intrinsics.checkNotNullExpressionValue(MyBillsEntityDataFactory, "");
        DanaH5.startContainerFullUrl(MyBillsEntityDataFactory);
        SendMoneyAnalyticTracker sendMoneyAnalyticTracker = sendMoneyExternalActivity.getSendMoneyAnalyticTracker();
        String str = externalWithdrawChannelModel.moveToNextValue;
        sendMoneyAnalyticTracker.BuiltInFictitiousFunctionClassFactory(str != null ? str : "");
    }

    public static final /* synthetic */ SendMoneyFeatureTime access$getSendMoneyFeatureTime(SendMoneyExternalActivity sendMoneyExternalActivity) {
        return (SendMoneyFeatureTime) sendMoneyExternalActivity.MyBillsEntityDataFactory.getValue();
    }

    public static final /* synthetic */ void access$hideShimmeringScreen(SendMoneyExternalActivity sendMoneyExternalActivity) {
        SkeletonScreen skeletonScreen = sendMoneyExternalActivity.moveToNextValue;
        if (skeletonScreen == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            skeletonScreen = null;
        }
        skeletonScreen.PlaceComponentResult();
    }

    public static final /* synthetic */ void access$hideViewQrisTcicoOutletSection(SendMoneyExternalActivity sendMoneyExternalActivity) {
        TextView textView = (TextView) sendMoneyExternalActivity._$_findCachedViewById(R.id.res_0x7f0a152b_viewcompat_api19impl);
        Intrinsics.checkNotNullExpressionValue(textView, "");
        textView.setVisibility(8);
        View _$_findCachedViewById = sendMoneyExternalActivity._$_findCachedViewById(R.id.resumeWithException);
        Intrinsics.checkNotNullExpressionValue(_$_findCachedViewById, "");
        _$_findCachedViewById.setVisibility(8);
    }

    public static final /* synthetic */ void access$setMaintenanceOnQrisTcicoOutlet(SendMoneyExternalActivity sendMoneyExternalActivity) {
        TextView textView = (TextView) sendMoneyExternalActivity._$_findCachedViewById(R.id.tv_maintenance_flag);
        if (textView != null) {
            textView.setVisibility(0);
        }
        ImageUtil imageUtil = ImageUtil.PlaceComponentResult;
        AppCompatImageView appCompatImageView = (AppCompatImageView) sendMoneyExternalActivity._$_findCachedViewById(R.id.BannerEntityDataFactory_Factory_res_0x7f0a0318);
        Intrinsics.checkNotNullExpressionValue(appCompatImageView, "");
        ImageUtil.BuiltInFictitiousFunctionClassFactory(appCompatImageView);
        View _$_findCachedViewById = sendMoneyExternalActivity._$_findCachedViewById(R.id.resumeWithException);
        if (_$_findCachedViewById != null) {
            _$_findCachedViewById.setClickable(false);
            _$_findCachedViewById.setFocusable(false);
            if (Build.VERSION.SDK_INT >= 23) {
                _$_findCachedViewById.setForeground(null);
            }
        }
    }

    public static final /* synthetic */ void access$setupLabelQrisTcicoOutlet(SendMoneyExternalActivity sendMoneyExternalActivity, WithdrawChannelInfoData withdrawChannelInfoData) {
        TextView textView = (TextView) sendMoneyExternalActivity._$_findCachedViewById(R.id.res_0x7f0a1401_nearbypromoadapter_viewholder_externalsyntheticlambda0);
        if (textView != null) {
            textView.setText(withdrawChannelInfoData.getLabel());
        }
        TextView textView2 = (TextView) sendMoneyExternalActivity._$_findCachedViewById(R.id.res_0x7f0a1401_nearbypromoadapter_viewholder_externalsyntheticlambda0);
        if (textView2 != null) {
            textView2.setVisibility(0);
        }
    }

    public static final /* synthetic */ void access$setupViewQrisTcicoOutletSection(SendMoneyExternalActivity sendMoneyExternalActivity, TransferInit transferInit) {
        QrisTcicoEntryPointInfo qrisTcicoEntryPointInfo = transferInit.getQrisTcicoEntryPointInfo();
        if (qrisTcicoEntryPointInfo != null) {
            TextView textView = (TextView) sendMoneyExternalActivity._$_findCachedViewById(R.id.res_0x7f0a152b_viewcompat_api19impl);
            if (textView != null) {
                textView.setVisibility(qrisTcicoEntryPointInfo.getVisibleStatus() ? 0 : 8);
            }
            View _$_findCachedViewById = sendMoneyExternalActivity._$_findCachedViewById(R.id.resumeWithException);
            if (_$_findCachedViewById != null) {
                _$_findCachedViewById.setVisibility(qrisTcicoEntryPointInfo.getVisibleStatus() ? 0 : 8);
                TextView textView2 = (TextView) _$_findCachedViewById.findViewById(R.id.onChipDrawableSizeChange);
                if (textView2 != null) {
                    textView2.setText(qrisTcicoEntryPointInfo.getInstName());
                }
                GlideRequests authRequestContext = GlideApp.getAuthRequestContext(_$_findCachedViewById.getContext());
                String lowerCase = qrisTcicoEntryPointInfo.getInstId().toLowerCase();
                Intrinsics.checkNotNullExpressionValue(lowerCase, "");
                String format = String.format(DanaUrl.CHANNEL_OUTLET_URL, Arrays.copyOf(new Object[]{lowerCase}, 1));
                Intrinsics.checkNotNullExpressionValue(format, "");
                authRequestContext.PlaceComponentResult(format).getErrorConfigVersion((int) R.drawable.ic_bank_placeholder).PlaceComponentResult((int) R.drawable.ic_bank_placeholder).MyBillsEntityDataFactory(DiskCacheStrategy.getAuthRequestContext).MyBillsEntityDataFactory((ImageView) ((AppCompatImageView) _$_findCachedViewById.findViewById(R.id.BannerEntityDataFactory_Factory_res_0x7f0a0318)));
            }
        }
    }

    public static final /* synthetic */ void access$showOnboardingDialog(final SendMoneyExternalActivity sendMoneyExternalActivity) {
        CustomDialog.Builder builder = new CustomDialog.Builder(sendMoneyExternalActivity);
        builder.SubSequence = sendMoneyExternalActivity.getString(R.string.sendmoney_external_onboardingdialog_title);
        builder.GetContactSyncConfig = sendMoneyExternalActivity.getString(R.string.sendmoney_external_onboardingdialog_body);
        builder.DatabaseTableConfigUtil = R.drawable.ic_sendmoney_external_onboarding_dialog;
        CustomDialog.Builder PlaceComponentResult2 = builder.KClassImpl$Data$declaredNonStaticMembers$2(false).PlaceComponentResult(false);
        PlaceComponentResult2.moveToNextValue = 0L;
        CustomDialog.Builder BuiltInFictitiousFunctionClassFactory = PlaceComponentResult2.BuiltInFictitiousFunctionClassFactory(sendMoneyExternalActivity.getString(R.string.sendmoney_external_onboardingdialog_button), new Function1<View, Unit>() { // from class: id.dana.sendmoney.external.SendMoneyExternalActivity$showOnboardingDialog$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(View view) {
                invoke2(view);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(View view) {
                Intrinsics.checkNotNullParameter(view, "");
                SendMoneyExternalActivity.this.getSendMoneyExternalPresenter().PlaceComponentResult(false);
            }
        });
        ViewExtKt.getAuthRequestContext(BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory(), BuiltInFictitiousFunctionClassFactory.moveToNextValue);
    }

    public static final /* synthetic */ void access$showShimmeringScreen(SendMoneyExternalActivity sendMoneyExternalActivity) {
        ViewSkeletonScreen.Builder BuiltInFictitiousFunctionClassFactory = Skeleton.BuiltInFictitiousFunctionClassFactory((Group) sendMoneyExternalActivity._$_findCachedViewById(R.id.groupAllSectionChannel));
        BuiltInFictitiousFunctionClassFactory.getAuthRequestContext = R.layout.view_skeleton_channel_outlet;
        BuiltInFictitiousFunctionClassFactory.PlaceComponentResult = 1500;
        BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2 = true;
        BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory = ContextCompat.BuiltInFictitiousFunctionClassFactory(BuiltInFictitiousFunctionClassFactory.lookAheadTest.getContext(), R.color.f27082131100491);
        BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory = 0;
        ViewSkeletonScreen viewSkeletonScreen = new ViewSkeletonScreen(BuiltInFictitiousFunctionClassFactory, (byte) 0);
        viewSkeletonScreen.MyBillsEntityDataFactory();
        Intrinsics.checkNotNullExpressionValue(viewSkeletonScreen, "");
        sendMoneyExternalActivity.moveToNextValue = viewSkeletonScreen;
    }

    @Override // id.dana.base.BaseActivity
    public final void init() {
        final SendMoneyExternalOutletAdapter sendMoneyExternalOutletAdapter = new SendMoneyExternalOutletAdapter();
        this.KClassImpl$Data$declaredNonStaticMembers$2 = sendMoneyExternalOutletAdapter;
        sendMoneyExternalOutletAdapter.setOnItemClickListener(new BaseRecyclerViewHolder.OnItemClickListener() { // from class: id.dana.sendmoney.external.SendMoneyExternalActivity$$ExternalSyntheticLambda1
            @Override // id.dana.base.BaseRecyclerViewHolder.OnItemClickListener
            public final void onItemClick(int i) {
                SendMoneyExternalActivity.$r8$lambda$VXDKMnMVeLAjIdu1flZw__n0zek(SendMoneyExternalActivity.this, sendMoneyExternalOutletAdapter, i);
            }
        });
        RecyclerView recyclerView = (RecyclerView) _$_findCachedViewById(R.id.res_0x7f0a112c_authenticationproxy_localpermissioncallback);
        SendMoneyExternalOutletAdapter sendMoneyExternalOutletAdapter2 = null;
        if (recyclerView != null) {
            SendMoneyExternalOutletAdapter sendMoneyExternalOutletAdapter3 = this.KClassImpl$Data$declaredNonStaticMembers$2;
            if (sendMoneyExternalOutletAdapter3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
                sendMoneyExternalOutletAdapter3 = null;
            }
            recyclerView.setAdapter(sendMoneyExternalOutletAdapter3);
        }
        final SendMoneyExternalOutletAdapter sendMoneyExternalOutletAdapter4 = new SendMoneyExternalOutletAdapter();
        this.BuiltInFictitiousFunctionClassFactory = sendMoneyExternalOutletAdapter4;
        sendMoneyExternalOutletAdapter4.setOnItemClickListener(new BaseRecyclerViewHolder.OnItemClickListener() { // from class: id.dana.sendmoney.external.SendMoneyExternalActivity$$ExternalSyntheticLambda0
            @Override // id.dana.base.BaseRecyclerViewHolder.OnItemClickListener
            public final void onItemClick(int i) {
                SendMoneyExternalActivity.$r8$lambda$Qus0jQhYHvABaWWNgrJkWNCORp8(SendMoneyExternalOutletAdapter.this, this, i);
            }
        });
        RecyclerView recyclerView2 = (RecyclerView) _$_findCachedViewById(R.id.res_0x7f0a112d_protoserializer_externalsyntheticlambda0);
        if (recyclerView2 != null) {
            SendMoneyExternalOutletAdapter sendMoneyExternalOutletAdapter5 = this.BuiltInFictitiousFunctionClassFactory;
            if (sendMoneyExternalOutletAdapter5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
            } else {
                sendMoneyExternalOutletAdapter2 = sendMoneyExternalOutletAdapter5;
            }
            recyclerView2.setAdapter(sendMoneyExternalOutletAdapter2);
        }
        DaggerSendMoneyExternalComponent.Builder PlaceComponentResult2 = DaggerSendMoneyExternalComponent.PlaceComponentResult();
        PlaceComponentResult2.BuiltInFictitiousFunctionClassFactory = (ApplicationComponent) Preconditions.getAuthRequestContext(getApplicationComponent());
        PlaceComponentResult2.getAuthRequestContext = (SendMoneyExternalModule) Preconditions.getAuthRequestContext(new SendMoneyExternalModule(new SendMoneyExternalActivity$injectComponent$1(this)));
        Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(PlaceComponentResult2.getAuthRequestContext, SendMoneyExternalModule.class);
        if (PlaceComponentResult2.KClassImpl$Data$declaredNonStaticMembers$2 == null) {
            PlaceComponentResult2.KClassImpl$Data$declaredNonStaticMembers$2 = new SendMoneyTrackerModule();
        }
        Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(PlaceComponentResult2.BuiltInFictitiousFunctionClassFactory, ApplicationComponent.class);
        new DaggerSendMoneyExternalComponent.SendMoneyExternalComponentImpl(PlaceComponentResult2.getAuthRequestContext, PlaceComponentResult2.KClassImpl$Data$declaredNonStaticMembers$2, PlaceComponentResult2.BuiltInFictitiousFunctionClassFactory, (byte) 0).PlaceComponentResult(this);
        registerPresenter(getSendMoneyExternalPresenter());
        getSendMoneyExternalPresenter().KClassImpl$Data$declaredNonStaticMembers$2();
        getSendMoneyExternalPresenter().getAuthRequestContext();
        OnBackPressedDispatcher onBackPressedDispatcher = getOnBackPressedDispatcher();
        OnBackPressedCallback onBackPressedCallback = new OnBackPressedCallback() { // from class: id.dana.sendmoney.external.SendMoneyExternalActivity$setOnBankListener$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(true);
            }

            @Override // androidx.view.OnBackPressedCallback
            public final void handleOnBackPressed() {
                SendMoneyFeatureTime access$getSendMoneyFeatureTime = SendMoneyExternalActivity.access$getSendMoneyFeatureTime(SendMoneyExternalActivity.this);
                Intrinsics.checkNotNullParameter("OPEN WITHDRAW LANDING PAGE", "");
                access$getSendMoneyFeatureTime.getAuthRequestContext.remove("OPEN WITHDRAW LANDING PAGE");
                SendMoneyExternalActivity.this.finish();
            }
        };
        onBackPressedDispatcher.KClassImpl$Data$declaredNonStaticMembers$2.add(onBackPressedCallback);
        onBackPressedCallback.addCancellable(new OnBackPressedDispatcher.OnBackPressedCancellable(onBackPressedCallback));
    }

    /* JADX WARN: Removed duplicated region for block: B:131:0x0bd0 A[Catch: Exception -> 0x146b, TRY_LEAVE, TryCatch #1 {Exception -> 0x146b, blocks: (B:129:0x0b83, B:131:0x0bd0, B:133:0x0d6e, B:136:0x0dc0, B:142:0x0e56, B:144:0x0e5c, B:145:0x0e5d, B:147:0x0e5f, B:149:0x0e66, B:150:0x0e67, B:135:0x0d73, B:132:0x0d22), top: B:260:0x0b83, inners: #21, #25 }] */
    /* JADX WARN: Removed duplicated region for block: B:153:0x0e6e  */
    /* JADX WARN: Removed duplicated region for block: B:155:0x0ee6  */
    /* JADX WARN: Removed duplicated region for block: B:177:0x12c8  */
    /* JADX WARN: Removed duplicated region for block: B:282:0x0eec A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:99:0x0a07  */
    @Override // id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void onCreate(android.os.Bundle r35) {
        /*
            Method dump skipped, instructions count: 5748
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.sendmoney.external.SendMoneyExternalActivity.onCreate(android.os.Bundle):void");
    }

    private static void a(int i, char[] cArr, Object[] objArr) {
        getOnBoardingScenario getonboardingscenario = new getOnBoardingScenario();
        getonboardingscenario.MyBillsEntityDataFactory = i;
        int length = cArr.length;
        long[] jArr = new long[length];
        getonboardingscenario.getAuthRequestContext = 0;
        while (getonboardingscenario.getAuthRequestContext < cArr.length) {
            jArr[getonboardingscenario.getAuthRequestContext] = (cArr[getonboardingscenario.getAuthRequestContext] ^ (getonboardingscenario.getAuthRequestContext * getonboardingscenario.MyBillsEntityDataFactory)) ^ (initRecordTimeStamp ^ 4796183387843776835L);
            getonboardingscenario.getAuthRequestContext++;
        }
        char[] cArr2 = new char[length];
        getonboardingscenario.getAuthRequestContext = 0;
        while (getonboardingscenario.getAuthRequestContext < cArr.length) {
            cArr2[getonboardingscenario.getAuthRequestContext] = (char) jArr[getonboardingscenario.getAuthRequestContext];
            getonboardingscenario.getAuthRequestContext++;
        }
        objArr[0] = new String(cArr2);
    }

    private static void b(char[] cArr, char[] cArr2, char c, int i, char[] cArr3, Object[] objArr) {
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
            cArr6[e.KClassImpl$Data$declaredNonStaticMembers$2] = (char) ((((cArr4[i3] ^ cArr2[e.KClassImpl$Data$declaredNonStaticMembers$2]) ^ (NetworkUserEntityData$$ExternalSyntheticLambda2 ^ 4360990799332652212L)) ^ ((int) (GetContactSyncConfig ^ 4360990799332652212L))) ^ ((char) (NetworkUserEntityData$$ExternalSyntheticLambda7 ^ 4360990799332652212L)));
            e.KClassImpl$Data$declaredNonStaticMembers$2++;
        }
        objArr[0] = new String(cArr6);
    }
}
