package id.dana.bank;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.ImageFormat;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.media.AudioTrack;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.os.Process;
import android.os.SystemClock;
import android.telephony.cdma.CdmaCellLocation;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.EditText;
import android.widget.ExpandableListView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.alibaba.wireless.security.SecExceptionCode;
import com.alipay.iap.android.common.syncintegration.api.IAPSyncCommand;
import com.ethanhua.skeleton.RecyclerViewSkeletonScreen;
import com.ethanhua.skeleton.Skeleton;
import com.ethanhua.skeleton.SkeletonScreen;
import com.google.android.material.appbar.AppBarLayout;
import com.google.common.base.Ascii;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.google.zxing.pdf417.PDF417Common;
import com.jakewharton.rxbinding2.widget.RxTextView;
import dagger.internal.Preconditions;
import id.dana.DanaApplication;
import id.dana.R;
import id.dana.bank.adapter.BankListAdapter;
import id.dana.bank.adapter.FeaturedBankAdapter;
import id.dana.bank.contract.BankListContract;
import id.dana.base.AbstractContractKt;
import id.dana.core.ui.BaseViewBindingActivity;
import id.dana.core.ui.recyclerview.BaseRecyclerViewDiffUtilAdapter;
import id.dana.databinding.ActivityBottomSheetBankListBinding;
import id.dana.databinding.LayoutBankListBinding;
import id.dana.di.component.ApplicationComponent;
import id.dana.di.component.DaggerRequestMoneyBankListComponent;
import id.dana.di.modules.RequestMoneyBankListModule;
import id.dana.domain.sendmoney.model.TransferInit;
import id.dana.onboarding.splash.LauncherActivity;
import id.dana.richview.EmptyState;
import id.dana.richview.SearchView;
import id.dana.sendmoney.model.BankModel;
import id.dana.sendmoney_v2.landing.di.module.SendMoneyTrackerModule;
import id.dana.sendmoney_v2.tracker.SendMoneyAnalyticTracker;
import id.dana.sendmoney_v2.tracker.SendMoneyFeatureTime;
import id.dana.utils.DateTimeUtil;
import id.dana.utils.KeyboardHelper;
import id.dana.utils.OnSwipeListener;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import o.SummaryVoucherView$$ExternalSyntheticLambda0;
import o.VerifyPinStateManager$executeRiskChallenge$2$2;

@Metadata(d1 = {"\u0000\u0082\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 G2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001GB\u0007¢\u0006\u0004\bF\u0010\nJ\u0019\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\bH\u0016¢\u0006\u0004\b\r\u0010\nJ\u000f\u0010\u000e\u001a\u00020\bH\u0014¢\u0006\u0004\b\u000e\u0010\nJ\u000f\u0010\u000f\u001a\u00020\bH\u0014¢\u0006\u0004\b\u000f\u0010\nJ\u000f\u0010\u0010\u001a\u00020\bH\u0014¢\u0006\u0004\b\u0010\u0010\nJ\u000f\u0010\u0011\u001a\u00020\bH\u0014¢\u0006\u0004\b\u0011\u0010\nJ\u0017\u0010\u0013\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0013\u0010\u0014J5\u0010\u001c\u001a\u0004\u0018\u00018\u0000\"\n\b\u0000\u0010\u0016*\u0004\u0018\u00010\u0015*\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u00182\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00028\u00000\u001a¢\u0006\u0004\b\u001c\u0010\u001dR\u0016\u0010 \u001a\u00020\u001e8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\t\u0010\u001fR$\u0010\u0013\u001a\u0012\u0012\u0004\u0012\u00020\"0!j\b\u0012\u0004\u0012\u00020\"`#8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b$\u0010%R\u0016\u0010\t\u001a\u00020&8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b'\u0010(R\"\u0010*\u001a\u00020)8\u0007@\u0007X\u0087.¢\u0006\u0012\n\u0004\b*\u0010+\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R\u0016\u00103\u001a\u0002008\u0002@\u0002X\u0083.¢\u0006\u0006\n\u0004\b1\u00102R\u0016\u00106\u001a\u00020\u00058\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b4\u00105R\"\u00108\u001a\u0002078\u0007@\u0007X\u0087.¢\u0006\u0012\n\u0004\b8\u00109\u001a\u0004\b:\u0010;\"\u0004\b<\u0010=R\u0013\u0010A\u001a\u00020>X\u0083\u0080\u0002¢\u0006\u0006\n\u0004\b?\u0010@R\u0016\u0010$\u001a\u00020\u001e8\u0002@\u0002X\u0083.¢\u0006\u0006\n\u0004\bB\u0010\u001fR\u0018\u00101\u001a\u0004\u0018\u00010C8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\bD\u0010E"}, d2 = {"Lid/dana/bank/BottomSheetBankListActivity;", "Lid/dana/core/ui/BaseViewBindingActivity;", "Lid/dana/databinding/ActivityBottomSheetBankListBinding;", "Landroid/view/MotionEvent;", "ev", "", "dispatchTouchEvent", "(Landroid/view/MotionEvent;)Z", "", "PlaceComponentResult", "()V", "inflateViewBinding", "()Lid/dana/databinding/ActivityBottomSheetBankListBinding;", IAPSyncCommand.COMMAND_INIT, "onDestroy", "onPause", "onResume", "onStart", "p0", "BuiltInFictitiousFunctionClassFactory", "(Z)V", "Landroid/os/Parcelable;", "T", "Landroid/content/Intent;", "", "key", "Ljava/lang/Class;", "m_class", "getParcelable", "(Landroid/content/Intent;Ljava/lang/String;Ljava/lang/Class;)Landroid/os/Parcelable;", "Lcom/ethanhua/skeleton/SkeletonScreen;", "Lcom/ethanhua/skeleton/SkeletonScreen;", "getAuthRequestContext", "Ljava/util/ArrayList;", "Lid/dana/sendmoney/model/BankModel;", "Lkotlin/collections/ArrayList;", "scheduleImpl", "Ljava/util/ArrayList;", "Lid/dana/bank/adapter/BankListAdapter;", "getErrorConfigVersion", "Lid/dana/bank/adapter/BankListAdapter;", "Lid/dana/bank/contract/BankListContract$Presenter;", "bankListPresenter", "Lid/dana/bank/contract/BankListContract$Presenter;", "getBankListPresenter", "()Lid/dana/bank/contract/BankListContract$Presenter;", "setBankListPresenter", "(Lid/dana/bank/contract/BankListContract$Presenter;)V", "Lid/dana/bank/adapter/FeaturedBankAdapter;", "lookAheadTest", "Lid/dana/bank/adapter/FeaturedBankAdapter;", "KClassImpl$Data$declaredNonStaticMembers$2", "initRecordTimeStamp", "Z", "MyBillsEntityDataFactory", "Lid/dana/sendmoney_v2/tracker/SendMoneyAnalyticTracker;", "sendMoneyAnalyticalTracker", "Lid/dana/sendmoney_v2/tracker/SendMoneyAnalyticTracker;", "getSendMoneyAnalyticalTracker", "()Lid/dana/sendmoney_v2/tracker/SendMoneyAnalyticTracker;", "setSendMoneyAnalyticalTracker", "(Lid/dana/sendmoney_v2/tracker/SendMoneyAnalyticTracker;)V", "Lid/dana/sendmoney_v2/tracker/SendMoneyFeatureTime;", "NetworkUserEntityData$$ExternalSyntheticLambda1", "Lkotlin/Lazy;", "NetworkUserEntityData$$ExternalSyntheticLambda0", "NetworkUserEntityData$$ExternalSyntheticLambda2", "Lid/dana/domain/sendmoney/model/TransferInit;", "GetContactSyncConfig", "Lid/dana/domain/sendmoney/model/TransferInit;", "<init>", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class BottomSheetBankListActivity extends BaseViewBindingActivity<ActivityBottomSheetBankListBinding> {
    private static char[] DatabaseTableConfigUtil = null;
    public static final String TRANSFER_INIT = "TransferInit";

    /* renamed from: GetContactSyncConfig  reason: from kotlin metadata */
    private TransferInit lookAheadTest;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda2  reason: from kotlin metadata */
    private SkeletonScreen scheduleImpl;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private SkeletonScreen getAuthRequestContext;
    @Inject
    public BankListContract.Presenter bankListPresenter;

    /* renamed from: getErrorConfigVersion  reason: from kotlin metadata */
    private BankListAdapter PlaceComponentResult;

    /* renamed from: initRecordTimeStamp  reason: from kotlin metadata */
    private boolean MyBillsEntityDataFactory;

    /* renamed from: lookAheadTest  reason: from kotlin metadata */
    private FeaturedBankAdapter KClassImpl$Data$declaredNonStaticMembers$2;
    @Inject
    public SendMoneyAnalyticTracker sendMoneyAnalyticalTracker;
    public static final byte[] $$a = {Ascii.FS, 71, 97, TarHeader.LF_DIR, -51, TarHeader.LF_NORMAL, -46, -10, -7, -14, 39, -48, -13, 4, -18, -12, 46, -36, -26, 12, Ascii.DC4, -34, -9, -24, -2, -10, -14, -5, -22, 44, -59, -6, 5, 15, -26, -19, -11, 9, -21, -8, 42, -51, -6, -13, 8, -26, -3, 1, -48, 4, -25, -7, 35, -43, -10, -3, 65, -39, -36, -26, 12, TarHeader.LF_FIFO, -71, -8, -5, -16, 4, -24, 6, -6, 15, -40, -6, Ascii.DC4, -40, 12, -26, 4, -1, 15, -31, -15, 4, -10, -20, -8, 72, -21};
    public static final int $$b = SecExceptionCode.SEC_ERROR_INIT_UNKNOWN_ERROR;
    public static final byte[] getAuthRequestContext = {112, 91, -28, 61, 7, 1, -7, -4, 13, -9, -3, TarHeader.LF_CHR, -23, -16, 13, 39, -42, 13, 1, 11, -19, Ascii.ETB, TarHeader.LF_DIR, -60, 13, -11, 9, 59, -35, -36, 8, 1, 17, -6};
    public static final int KClassImpl$Data$declaredNonStaticMembers$2 = 241;
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();

    /* renamed from: scheduleImpl  reason: from kotlin metadata */
    private final ArrayList<BankModel> BuiltInFictitiousFunctionClassFactory = new ArrayList<>();

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda1  reason: from kotlin metadata */
    private final Lazy NetworkUserEntityData$$ExternalSyntheticLambda0 = LazyKt.lazy(new Function0<SendMoneyFeatureTime>() { // from class: id.dana.bank.BottomSheetBankListActivity$sendMoneyFeatureTime$2
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
        DatabaseTableConfigUtil = new char[]{35342, 35712, 35713, 35769, 35767, 35716, 35772, 35756, 35764, 35765, 35765, 35764, 35769, 35728, 35437, 35733, 35762, 35770, 35741, 35739, 35772, 35766, 35762, 35769, 35771, 35773, 35492, 35570, 35574, 35568, 35570, 35568, 35572, 35580, 35576, 35572, 35568, 35566, 35526, 35524, 35567, 35575, 35573, 35564, 35347, 35716, 35713, 35768, 35721, 35435, 35736, 35769, 35738, 35425, 35714, 35772, 35768, 35775, 35713, 35715, 35774, 35767, 35500, 35576, 35521, 35577, 35565, 35562, 35424, 35427, 35446, 35451, 35429, 35425, 35447, 35446, 35425, 35723, 35723, 35720, 35426, 35452, 35450, 35450, 35452, 35450, 35426, 35725, 35722, 35722, 35427, 35424, 35426, 35448, 35425, 35426, 35426, 35725, 35722, 35742, 35446, 35451, 35448, 35742, 35742, 35447, 35451, 35450, 35425, 35424, 35448, 35427, 35429, 35451, 35424, 35499, 35530, 35488, 35528, 35568, 35526, 35491, 35491, 35529, 35570, 35529, 35550, 35531, 35533, 35492, 35493, 35490, 35493, 35531, 35530, 35533, 35533, 35490, 35491, 35491, 35531, 35528, 35526, 35529, 35529, 35530, 35493, 35533, 35570, 35531, 35489, 35528, 35570, 35532, 35492, 35491, 35493, 35533, 35530, 35533, 35528, 35491, 35491, 35488, 35490, 35488, 35551, 35548, 35551, 35490, 35495, 35495, 35495, 35533, 35573, 35532, 35491, 35529, 35530, 35458, 35537, 35576, 35536, 35539, 35539, 35539, 35541, 35499, 35539, 35538, 35496, 35497, 35494, 35537, 35541, 35500, 35496, 35498, 35542, 35583, 35578, 35537, 35536, 35578, 35541, 35503, 35541, 35539, 35496, 35496, 35497, 35497, 35536, 35539, 35499, 35497, 35499, 35503, 35541, 35581, 35539, 35494, 35498, 35501, 35496, 35494, 35494, 35498, 35503, 35500, 35503, 35501, 35538, 35581, 35538, 35538, 35541, 35540, 35583, 35540, 35499, 35536, 35537, 35495, 35575, 35573, 35565, 35564, 35573, 35573, 35575, 35573, 35568, 35540, 35535, 35565, 35572, 35580, 35573, 35572, 35581, 35573, 35571, 35568, 35535, 35545, 35577, 35577, 35580, 35543, 35505, 35498, 35528, 35567, 35564, 35562, 35568, 35571, 35565, 35567, 35575, 35571, 35571, 35540, 35502, 35530, 35532, 35535, 35565, 35570, 35576, 35572, 35573, 35538, 35538, 35570, 35574, 35542, 35536, 35568, 35575, 35542, 35543, 35567, 35394, 35396, 35396, 35399, 35396};
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x002d  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x002d -> B:11:0x0037). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void b(short r6, byte r7, short r8, java.lang.Object[] r9) {
        /*
            int r6 = r6 * 15
            int r6 = 18 - r6
            byte[] r0 = id.dana.bank.BottomSheetBankListActivity.getAuthRequestContext
            int r7 = 106 - r7
            int r8 = r8 * 3
            int r8 = 16 - r8
            byte[] r1 = new byte[r8]
            int r8 = r8 + (-1)
            r2 = 0
            if (r0 != 0) goto L1b
            r3 = r1
            r4 = 0
            r1 = r0
            r0 = r9
            r9 = r8
            r8 = r7
            r7 = r6
            goto L37
        L1b:
            r3 = 0
        L1c:
            byte r4 = (byte) r7
            int r6 = r6 + 1
            r1[r3] = r4
            int r4 = r3 + 1
            if (r3 != r8) goto L2d
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            r9[r2] = r6
            return
        L2d:
            r3 = r0[r6]
            r5 = r7
            r7 = r6
            r6 = r3
            r3 = r1
            r1 = r0
            r0 = r9
            r9 = r8
            r8 = r5
        L37:
            int r6 = -r6
            int r8 = r8 + r6
            int r6 = r8 + 2
            r8 = r9
            r9 = r0
            r0 = r1
            r1 = r3
            r3 = r4
            r5 = r7
            r7 = r6
            r6 = r5
            goto L1c
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.bank.BottomSheetBankListActivity.b(short, byte, short, java.lang.Object[]):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0028  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0020  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0028 -> B:11:0x0032). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void c(short r7, int r8, byte r9, java.lang.Object[] r10) {
        /*
            int r7 = r7 * 2
            int r7 = r7 + 75
            byte[] r0 = id.dana.bank.BottomSheetBankListActivity.$$a
            int r8 = 47 - r8
            int r9 = r9 * 3
            int r9 = 42 - r9
            byte[] r1 = new byte[r9]
            r2 = 0
            if (r0 != 0) goto L18
            r7 = r8
            r3 = r1
            r4 = 0
            r1 = r0
            r0 = r10
            r10 = r9
            goto L32
        L18:
            r3 = 0
        L19:
            int r4 = r3 + 1
            byte r5 = (byte) r7
            r1[r3] = r5
            if (r4 != r9) goto L28
            java.lang.String r7 = new java.lang.String
            r7.<init>(r1, r2)
            r10[r2] = r7
            return
        L28:
            r3 = r0[r8]
            r6 = r9
            r9 = r7
            r7 = r8
            r8 = r3
            r3 = r1
            r1 = r0
            r0 = r10
            r10 = r6
        L32:
            int r8 = -r8
            int r7 = r7 + 1
            int r9 = r9 + r8
            int r8 = r9 + (-7)
            r9 = r10
            r10 = r0
            r0 = r1
            r1 = r3
            r3 = r4
            r6 = r8
            r8 = r7
            r7 = r6
            goto L19
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.bank.BottomSheetBankListActivity.c(short, int, byte, java.lang.Object[]):void");
    }

    @Override // id.dana.core.ui.BaseViewBindingActivity
    public final void _$_clearFindViewByIdCache() {
        this._$_findViewCache.clear();
    }

    @Override // id.dana.core.ui.BaseViewBindingActivity
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

    @Override // id.dana.core.ui.BaseViewBindingActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper
    public final void attachBaseContext(Context context) {
        Object[] objArr;
        Object[] objArr2;
        Object[] objArr3;
        Object[] objArr4;
        super.attachBaseContext(context);
        Object[] objArr5 = new Object[1];
        a(true, new int[]{44, 18, 182, 16}, new byte[]{1, 0, 0, 1, 0, 0, 1, 0, 1, 0, 1, 0, 1, 0, 0, 1, 0, 0}, objArr5);
        Class<?> cls = Class.forName((String) objArr5[0]);
        Object[] objArr6 = new Object[1];
        a(true, new int[]{62, 5, 0, 5}, new byte[]{0, 1, 0, 0, 0}, objArr6);
        int intValue = ((Integer) cls.getDeclaredMethod((String) objArr6[0], new Class[0]).invoke(null, new Object[0])).intValue() % 100000;
        if (intValue < 99000 || intValue > 99999) {
            Context applicationContext = context != null ? context.getApplicationContext() : context;
            if (applicationContext != null) {
                try {
                    Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                    if (obj == null) {
                        obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(View.resolveSizeAndState(0, 0, 0) + PDF417Common.NUMBER_OF_CODEWORDS, 35 - (ViewConfiguration.getJumpTapTimeout() >> 16), (char) (TextUtils.indexOf((CharSequence) "", '0', 0) + 1))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                    }
                    Object invoke = ((Method) obj).invoke(null, null);
                    Object[] objArr7 = new Object[1];
                    a(false, new int[]{67, 48, 177, 0}, new byte[]{0, 0, 1, 0, 0, 0, 1, 1, 1, 0, 0, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 0, 1, 0, 1, 1, 0, 0, 0, 1, 0, 0, 1, 0, 1, 1, 1, 1, 0, 1, 1, 0, 0, 0, 1, 1, 1}, objArr7);
                    String str = (String) objArr7[0];
                    Object[] objArr8 = new Object[1];
                    a(false, new int[]{115, 64, 9, 0}, new byte[]{0, 0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 0, 1, 1, 0, 1, 0, 0, 0, 1, 1, 1, 1, 1, 1, 0, 1, 0, 1, 0, 0, 0, 1, 1, 0, 0, 1, 0, 1, 1, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 0, 1, 1, 1, 0, 1}, objArr8);
                    String str2 = (String) objArr8[0];
                    Object[] objArr9 = new Object[1];
                    a(false, new int[]{179, 64, 0, 37}, new byte[]{0, 0, 0, 1, 0, 0, 1, 0, 0, 0, 1, 1, 0, 0, 0, 1, 1, 0, 0, 1, 1, 0, 1, 0, 0, 1, 1, 1, 1, 0, 0, 0, 1, 0, 1, 0, 0, 1, 1, 0, 1, 1, 0, 1, 0, 0, 0, 0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 0, 0, 1, 0, 0, 1, 1}, objArr9);
                    String str3 = (String) objArr9[0];
                    Object[] objArr10 = new Object[1];
                    a(true, new int[]{243, 60, 0, 34}, new byte[]{0, 1, 0, 0, 0, 1, 0, 1, 0, 0, 1, 0, 1, 0, 0, 1, 1, 0, 1, 0, 0, 0, 1, 1, 1, 1, 1, 0, 1, 1, 1, 0, 0, 0, 1, 1, 0, 1, 1, 1, 0, 1, 0, 1, 1, 1, 0, 0, 1, 1, 0, 0, 1, 1, 0, 0, 0, 0, 1, 1}, objArr10);
                    String str4 = (String) objArr10[0];
                    Object[] objArr11 = new Object[1];
                    a(false, new int[]{303, 6, 169, 0}, new byte[]{0, 1, 0, 0, 0, 1}, objArr11);
                    try {
                        Object[] objArr12 = {applicationContext, str, str2, str3, str4, true, (String) objArr11[0], 995651014};
                        Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-1276397751);
                        if (obj2 == null) {
                            obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(910 - TextUtils.lastIndexOf("", '0'), TextUtils.getCapsMode("", 0, 0) + 18, (char) ((Process.getThreadPriority(0) + 20) >> 6))).getMethod("getAuthRequestContext", Context.class, String.class, String.class, String.class, String.class, Boolean.TYPE, String.class, Integer.TYPE);
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
                byte b = (byte) (getAuthRequestContext[5] - 1);
                byte b2 = b;
                Object[] objArr13 = new Object[1];
                b(b, b2, b2, objArr13);
                Class<?> cls2 = Class.forName((String) objArr13[0]);
                byte b3 = getAuthRequestContext[5];
                byte b4 = b3;
                Object[] objArr14 = new Object[1];
                b(b3, b4, (byte) (b4 - 1), objArr14);
                try {
                    Object[] objArr15 = {applicationContext2, Integer.valueOf(((Integer) cls2.getMethod((String) objArr14[0], Object.class).invoke(null, this)).intValue())};
                    Object obj3 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1691739267);
                    if (obj3 == null) {
                        Class cls3 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(55 - TextUtils.getCapsMode("", 0, 0), 3 - ExpandableListView.getPackedPositionType(0L), (char) View.combineMeasuredStates(0, 0));
                        Object[] objArr16 = new Object[1];
                        c($$a[47], (byte) (-$$a[53]), $$a[68], objArr16);
                        obj3 = cls3.getMethod((String) objArr16[0], Context.class, Integer.TYPE);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1691739267, obj3);
                    }
                    Object invoke2 = ((Method) obj3).invoke(null, objArr15);
                    try {
                        Object obj4 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(40157535);
                        if (obj4 == null) {
                            obj4 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getScrollDefaultDelay() >> 16) + 800, 15 - (ViewConfiguration.getPressedStateDuration() >> 16), (char) Color.argb(0, 0, 0, 0))).getMethod("getAuthRequestContext", null);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(40157535, obj4);
                        }
                        int intValue2 = ((Integer) ((Method) obj4).invoke(invoke2, null)).intValue();
                        try {
                            Object obj5 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1621779126);
                            if (obj5 == null) {
                                obj5 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(Color.green(0) + 800, 15 - TextUtils.indexOf("", "", 0, 0), (char) KeyEvent.keyCodeFromString(""))).getMethod("PlaceComponentResult", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1621779126, obj5);
                            }
                            if (((Integer) ((Method) obj5).invoke(invoke2, null)).intValue() != intValue2) {
                                ArrayList arrayList = new ArrayList();
                                try {
                                    Object[] objArr17 = {invoke2};
                                    Object obj6 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(658700871);
                                    if (obj6 == null) {
                                        obj6 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(Drawable.resolveOpacity(0, 0) + 815, ExpandableListView.getPackedPositionGroup(0L) + 29, (char) (View.resolveSizeAndState(0, 0, 0) + 57994))).getMethod("getAuthRequestContext", (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(800 - View.resolveSize(0, 0), (ViewConfiguration.getWindowTouchSlop() >> 8) + 15, (char) (TextUtils.indexOf((CharSequence) "", '0') + 1)));
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
                                            obj7 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - (ViewConfiguration.getScrollBarSize() >> 8), 35 - Color.red(0), (char) ((-1) - (ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1))))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj7);
                                        }
                                        Object invoke3 = ((Method) obj7).invoke(objArr, objArr);
                                        try {
                                            Object[] objArr18 = {2021693179, Long.valueOf(j), arrayList, LauncherActivity.getAuid()};
                                            Object obj8 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                            if (obj8 == null) {
                                                obj8 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(912 - (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)), 18 - (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)), (char) (ViewConfiguration.getEdgeSlop() >> 16))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                byte b5 = (byte) (getAuthRequestContext[5] - 1);
                byte b6 = b5;
                Object[] objArr19 = new Object[1];
                b(b5, b6, b6, objArr19);
                Class<?> cls4 = Class.forName((String) objArr19[0]);
                byte b7 = getAuthRequestContext[5];
                byte b8 = b7;
                Object[] objArr20 = new Object[1];
                b(b7, b8, (byte) (b8 - 1), objArr20);
                try {
                    Object[] objArr21 = {applicationContext3, Integer.valueOf(((Integer) cls4.getMethod((String) objArr20[0], Object.class).invoke(null, this)).intValue())};
                    Object obj9 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(345757441);
                    if (obj9 == null) {
                        Class cls5 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(61 - (ViewConfiguration.getTapTimeout() >> 16), 46 - (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)), (char) (ViewConfiguration.getFadingEdgeLength() >> 16));
                        Object[] objArr22 = new Object[1];
                        c((byte) (-$$a[9]), $$a[20], (byte) (-$$a[8]), objArr22);
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
                                obj10 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - Color.blue(0), 35 - (ViewConfiguration.getPressedStateDuration() >> 16), (char) (KeyEvent.getMaxKeyCode() >> 16))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj10);
                            }
                            Object invoke4 = ((Method) obj10).invoke(objArr2, objArr2);
                            try {
                                Object[] objArr24 = {2021693179, Long.valueOf(j2), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj11 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj11 == null) {
                                    obj11 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(912 - (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)), (ViewConfiguration.getKeyRepeatDelay() >> 16) + 18, (char) (TextUtils.lastIndexOf("", '0', 0) + 1))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                byte b9 = (byte) (getAuthRequestContext[5] - 1);
                byte b10 = b9;
                Object[] objArr25 = new Object[1];
                b(b9, b10, b10, objArr25);
                Class<?> cls6 = Class.forName((String) objArr25[0]);
                byte b11 = getAuthRequestContext[5];
                byte b12 = b11;
                Object[] objArr26 = new Object[1];
                b(b11, b12, (byte) (b12 - 1), objArr26);
                try {
                    Object[] objArr27 = {applicationContext4, Integer.valueOf(((Integer) cls6.getMethod((String) objArr26[0], Object.class).invoke(null, this)).intValue())};
                    Object obj12 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-697999596);
                    if (obj12 == null) {
                        Class cls7 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(Process.getGidForName("") + 119, 3 - (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)), (char) (38968 - TextUtils.getOffsetAfter("", 0)));
                        Object[] objArr28 = new Object[1];
                        c((byte) (-$$a[9]), $$a[20], (byte) (-$$a[8]), objArr28);
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
                                obj13 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)) + PDF417Common.MAX_CODEWORDS_IN_BARCODE, 35 - KeyEvent.keyCodeFromString(""), (char) (CdmaCellLocation.convertQuartSecToDecDegrees(0) > FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 0 : -1)))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj13);
                            }
                            Object invoke5 = ((Method) obj13).invoke(objArr3, objArr3);
                            try {
                                Object[] objArr30 = {2021693179, Long.valueOf(j3), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj14 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj14 == null) {
                                    obj14 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)) + 910, ExpandableListView.getPackedPositionChild(0L) + 19, (char) (ViewConfiguration.getMaximumDrawingCacheSize() >> 24))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                byte b13 = (byte) (getAuthRequestContext[5] - 1);
                byte b14 = b13;
                Object[] objArr31 = new Object[1];
                b(b13, b14, b14, objArr31);
                Class<?> cls8 = Class.forName((String) objArr31[0]);
                byte b15 = getAuthRequestContext[5];
                byte b16 = b15;
                Object[] objArr32 = new Object[1];
                b(b15, b16, (byte) (b16 - 1), objArr32);
                try {
                    Object[] objArr33 = {applicationContext5, Integer.valueOf(((Integer) cls8.getMethod((String) objArr32[0], Object.class).invoke(null, this)).intValue())};
                    Object obj15 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-16683571);
                    if (obj15 == null) {
                        Class cls9 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(TextUtils.indexOf((CharSequence) "", '0') + 108, MotionEvent.axisFromString("") + 4, (char) (1 - (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1))));
                        byte b17 = (byte) ($$a[47] - 1);
                        byte b18 = b17;
                        Object[] objArr34 = new Object[1];
                        c(b17, b18, b18, objArr34);
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
                                obj16 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - View.MeasureSpec.makeMeasureSpec(0, 0), (ViewConfiguration.getScrollDefaultDelay() >> 16) + 35, (char) (ViewConfiguration.getMaximumDrawingCacheSize() >> 24))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj16);
                            }
                            Object invoke6 = ((Method) obj16).invoke(objArr4, objArr4);
                            try {
                                Object[] objArr36 = {2021693179, Long.valueOf(j4), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj17 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj17 == null) {
                                    obj17 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - (ViewConfiguration.getScrollBarFadeDuration() >> 16), TextUtils.indexOf("", "", 0, 0) + 18, (char) (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
    public final Context getApplicationContext() {
        return super.getApplicationContext();
    }

    @Override // id.dana.core.ui.BaseViewBindingActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.content.ContextWrapper
    public final Context getBaseContext() {
        return super.getBaseContext();
    }

    @Override // id.dana.core.ui.BaseViewBindingActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public final Resources getResources() {
        return super.getResources();
    }

    @Override // id.dana.core.ui.BaseViewBindingActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onCreate(Bundle bundle) {
        Object[] objArr;
        Object[] objArr2 = new Object[1];
        a(true, new int[]{44, 18, 182, 16}, new byte[]{1, 0, 0, 1, 0, 0, 1, 0, 1, 0, 1, 0, 1, 0, 0, 1, 0, 0}, objArr2);
        Class<?> cls = Class.forName((String) objArr2[0]);
        Object[] objArr3 = new Object[1];
        a(true, new int[]{62, 5, 0, 5}, new byte[]{0, 1, 0, 0, 0}, objArr3);
        int intValue = ((Integer) cls.getDeclaredMethod((String) objArr3[0], new Class[0]).invoke(null, new Object[0])).intValue() % 100000;
        if (intValue < 99000 || intValue > 99999) {
            Context baseContext = getBaseContext();
            if (baseContext == null) {
                Object[] objArr4 = new Object[1];
                a(true, new int[]{0, 26, 188, 0}, new byte[]{0, 1, 0, 1, 0, 0, 1, 1, 1, 1, 1, 1, 1, 0, 1, 0, 0, 1, 1, 0, 1, 0, 1, 0, 0, 1}, objArr4);
                Class<?> cls2 = Class.forName((String) objArr4[0]);
                Object[] objArr5 = new Object[1];
                a(true, new int[]{26, 18, 0, 2}, new byte[]{1, 0, 1, 1, 0, 1, 1, 0, 0, 1, 0, 0, 1, 1, 0, 1, 1, 0}, objArr5);
                baseContext = (Context) cls2.getMethod((String) objArr5[0], new Class[0]).invoke(null, null);
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
                    Object[] objArr6 = new Object[1];
                    a(false, new int[]{67, 48, 177, 0}, new byte[]{0, 0, 1, 0, 0, 0, 1, 1, 1, 0, 0, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 0, 1, 0, 1, 1, 0, 0, 0, 1, 0, 0, 1, 0, 1, 1, 1, 1, 0, 1, 1, 0, 0, 0, 1, 1, 1}, objArr6);
                    String str = (String) objArr6[0];
                    Object[] objArr7 = new Object[1];
                    a(false, new int[]{115, 64, 9, 0}, new byte[]{0, 0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 0, 1, 1, 0, 1, 0, 0, 0, 1, 1, 1, 1, 1, 1, 0, 1, 0, 1, 0, 0, 0, 1, 1, 0, 0, 1, 0, 1, 1, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 0, 1, 1, 1, 0, 1}, objArr7);
                    String str2 = (String) objArr7[0];
                    Object[] objArr8 = new Object[1];
                    a(false, new int[]{179, 64, 0, 37}, new byte[]{0, 0, 0, 1, 0, 0, 1, 0, 0, 0, 1, 1, 0, 0, 0, 1, 1, 0, 0, 1, 1, 0, 1, 0, 0, 1, 1, 1, 1, 0, 0, 0, 1, 0, 1, 0, 0, 1, 1, 0, 1, 1, 0, 1, 0, 0, 0, 0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 0, 0, 1, 0, 0, 1, 1}, objArr8);
                    String str3 = (String) objArr8[0];
                    Object[] objArr9 = new Object[1];
                    a(true, new int[]{243, 60, 0, 34}, new byte[]{0, 1, 0, 0, 0, 1, 0, 1, 0, 0, 1, 0, 1, 0, 0, 1, 1, 0, 1, 0, 0, 0, 1, 1, 1, 1, 1, 0, 1, 1, 1, 0, 0, 0, 1, 1, 0, 1, 1, 1, 0, 1, 0, 1, 1, 1, 0, 0, 1, 1, 0, 0, 1, 1, 0, 0, 0, 0, 1, 1}, objArr9);
                    String str4 = (String) objArr9[0];
                    Object[] objArr10 = new Object[1];
                    a(false, new int[]{303, 6, 169, 0}, new byte[]{0, 1, 0, 0, 0, 1}, objArr10);
                    try {
                        Object[] objArr11 = {baseContext, str, str2, str3, str4, true, (String) objArr10[0], 995651014};
                        Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-1276397751);
                        if (obj2 == null) {
                            obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - View.resolveSize(0, 0), 18 - (ViewConfiguration.getMaximumFlingVelocity() >> 16), (char) (1 - (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1))))).getMethod("getAuthRequestContext", Context.class, String.class, String.class, String.class, String.class, Boolean.TYPE, String.class, Integer.TYPE);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(-1276397751, obj2);
                        }
                        ((Method) obj2).invoke(invoke, objArr11);
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
        try {
            byte b = (byte) (getAuthRequestContext[5] - 1);
            byte b2 = b;
            Object[] objArr12 = new Object[1];
            b(b, b2, b2, objArr12);
            Class<?> cls3 = Class.forName((String) objArr12[0]);
            byte b3 = getAuthRequestContext[5];
            byte b4 = b3;
            Object[] objArr13 = new Object[1];
            b(b3, b4, (byte) (b4 - 1), objArr13);
            try {
                Object[] objArr14 = {Integer.valueOf(((Integer) cls3.getMethod((String) objArr13[0], Object.class).invoke(null, this)).intValue())};
                Object obj3 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(25207140);
                if (obj3 == null) {
                    Class cls4 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(494 - (ViewConfiguration.getKeyRepeatTimeout() >> 16), 4 - (ViewConfiguration.getPressedStateDuration() >> 16), (char) TextUtils.indexOf("", ""));
                    byte b5 = (byte) ($$a[47] - 1);
                    byte b6 = b5;
                    Object[] objArr15 = new Object[1];
                    c(b5, b6, b6, objArr15);
                    obj3 = cls4.getMethod((String) objArr15[0], Integer.TYPE);
                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(25207140, obj3);
                }
                Object[] objArr16 = (Object[]) ((Method) obj3).invoke(null, objArr14);
                int i = ((int[]) objArr16[1])[0];
                if (((int[]) objArr16[0])[0] != i) {
                    long j = ((r0 ^ i) & 4294967295L) | 42949672960L;
                    try {
                        Object obj4 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                        if (obj4 != null) {
                            objArr = null;
                        } else {
                            objArr = null;
                            obj4 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(928 - ImageFormat.getBitsPerPixel(0), (ViewConfiguration.getMinimumFlingVelocity() >> 16) + 35, (char) (ViewConfiguration.getTouchSlop() >> 8))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj4);
                        }
                        Object invoke2 = ((Method) obj4).invoke(objArr, objArr);
                        try {
                            Object[] objArr17 = {1757759120, Long.valueOf(j), new ArrayList(), LauncherActivity.getAuid()};
                            Object obj5 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                            if (obj5 == null) {
                                obj5 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(912 - (SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)), 18 - TextUtils.indexOf("", ""), (char) View.MeasureSpec.getSize(0))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1759031285, obj5);
                            }
                            ((Method) obj5).invoke(invoke2, objArr17);
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
                super.onCreate(bundle);
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

    @JvmName(name = "getBankListPresenter")
    public final BankListContract.Presenter getBankListPresenter() {
        BankListContract.Presenter presenter = this.bankListPresenter;
        if (presenter != null) {
            return presenter;
        }
        Intrinsics.throwUninitializedPropertyAccessException("");
        return null;
    }

    @JvmName(name = "setBankListPresenter")
    public final void setBankListPresenter(BankListContract.Presenter presenter) {
        Intrinsics.checkNotNullParameter(presenter, "");
        this.bankListPresenter = presenter;
    }

    @JvmName(name = "getSendMoneyAnalyticalTracker")
    public final SendMoneyAnalyticTracker getSendMoneyAnalyticalTracker() {
        SendMoneyAnalyticTracker sendMoneyAnalyticTracker = this.sendMoneyAnalyticalTracker;
        if (sendMoneyAnalyticTracker != null) {
            return sendMoneyAnalyticTracker;
        }
        Intrinsics.throwUninitializedPropertyAccessException("");
        return null;
    }

    @JvmName(name = "setSendMoneyAnalyticalTracker")
    public final void setSendMoneyAnalyticalTracker(SendMoneyAnalyticTracker sendMoneyAnalyticTracker) {
        Intrinsics.checkNotNullParameter(sendMoneyAnalyticTracker, "");
        this.sendMoneyAnalyticalTracker = sendMoneyAnalyticTracker;
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onStart() {
        super.onStart();
        overridePendingTransition(R.anim.f5052130772056, R.anim.f5092130772063);
    }

    @Override // id.dana.core.ui.BaseViewBindingActivity
    public final ActivityBottomSheetBankListBinding inflateViewBinding() {
        ActivityBottomSheetBankListBinding BuiltInFictitiousFunctionClassFactory = ActivityBottomSheetBankListBinding.BuiltInFictitiousFunctionClassFactory(getLayoutInflater());
        Intrinsics.checkNotNullExpressionValue(BuiltInFictitiousFunctionClassFactory, "");
        return BuiltInFictitiousFunctionClassFactory;
    }

    @Override // id.dana.core.ui.BaseViewBindingActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onResume() {
        Context baseContext = getBaseContext();
        if (baseContext == null) {
            Object[] objArr = new Object[1];
            a(true, new int[]{0, 26, 188, 0}, new byte[]{0, 1, 0, 1, 0, 0, 1, 1, 1, 1, 1, 1, 1, 0, 1, 0, 0, 1, 1, 0, 1, 0, 1, 0, 0, 1}, objArr);
            Class<?> cls = Class.forName((String) objArr[0]);
            Object[] objArr2 = new Object[1];
            a(true, new int[]{26, 18, 0, 2}, new byte[]{1, 0, 1, 1, 0, 1, 1, 0, 0, 1, 0, 0, 1, 1, 0, 1, 1, 0}, objArr2);
            baseContext = (Context) cls.getMethod((String) objArr2[0], new Class[0]).invoke(null, null);
        }
        if (baseContext != null) {
            baseContext = baseContext.getApplicationContext();
        }
        if (baseContext != null) {
            try {
                Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                if (obj == null) {
                    obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(TextUtils.getCapsMode("", 0, 0) + PDF417Common.NUMBER_OF_CODEWORDS, 34 - (ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)), (char) (Process.getGidForName("") + 1))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                }
                Object invoke = ((Method) obj).invoke(null, null);
                try {
                    Object[] objArr3 = {baseContext};
                    Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(247288059);
                    if (obj2 == null) {
                        obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - View.MeasureSpec.makeMeasureSpec(0, 0), 17 - MotionEvent.axisFromString(""), (char) (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)))).getMethod("KClassImpl$Data$declaredNonStaticMembers$2", Context.class);
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
        ((SendMoneyFeatureTime) this.NetworkUserEntityData$$ExternalSyntheticLambda0.getValue()).moveToNextValue = DateTimeUtil.BuiltInFictitiousFunctionClassFactory();
        getSendMoneyAnalyticalTracker().PlaceComponentResult();
    }

    private final void PlaceComponentResult() {
        Unit unit;
        TransferInit transferInit = this.lookAheadTest;
        if (transferInit != null) {
            getBankListPresenter().BuiltInFictitiousFunctionClassFactory(transferInit);
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            getBankListPresenter().MyBillsEntityDataFactory();
        }
    }

    @Override // id.dana.core.ui.BaseViewBindingActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onPause() {
        Context baseContext = getBaseContext();
        if (baseContext == null) {
            Object[] objArr = new Object[1];
            a(true, new int[]{0, 26, 188, 0}, new byte[]{0, 1, 0, 1, 0, 0, 1, 1, 1, 1, 1, 1, 1, 0, 1, 0, 0, 1, 1, 0, 1, 0, 1, 0, 0, 1}, objArr);
            Class<?> cls = Class.forName((String) objArr[0]);
            Object[] objArr2 = new Object[1];
            a(true, new int[]{26, 18, 0, 2}, new byte[]{1, 0, 1, 1, 0, 1, 1, 0, 0, 1, 0, 0, 1, 1, 0, 1, 1, 0}, objArr2);
            baseContext = (Context) cls.getMethod((String) objArr2[0], new Class[0]).invoke(null, null);
        }
        if (baseContext != null) {
            baseContext = baseContext.getApplicationContext();
        }
        if (baseContext != null) {
            try {
                Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                if (obj == null) {
                    obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - (ViewConfiguration.getScrollBarFadeDuration() >> 16), (ViewConfiguration.getMaximumDrawingCacheSize() >> 24) + 35, (char) (ViewConfiguration.getTapTimeout() >> 16))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                }
                Object invoke = ((Method) obj).invoke(null, null);
                try {
                    Object[] objArr3 = {baseContext};
                    Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-549958681);
                    if (obj2 == null) {
                        obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - TextUtils.getCapsMode("", 0, 0), 18 - (ViewConfiguration.getMaximumFlingVelocity() >> 16), (char) (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)))).getMethod("MyBillsEntityDataFactory", Context.class);
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
        if (isFinishing()) {
            overridePendingTransition(R.anim.f5032130772052, R.anim.f5082130772059);
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public final boolean dispatchTouchEvent(MotionEvent ev) {
        if (ev != null && ev.getAction() == 0 && this.MyBillsEntityDataFactory) {
            View currentFocus = getCurrentFocus();
            EditText editText = currentFocus instanceof EditText ? (EditText) currentFocus : null;
            if (editText != null) {
                Rect rect = new Rect();
                editText.getGlobalVisibleRect(rect);
                if (!rect.contains((int) ev.getRawX(), (int) ev.getRawY())) {
                    KeyboardHelper.MyBillsEntityDataFactory(this);
                    editText.clearFocus();
                }
            }
        }
        return super.dispatchTouchEvent(ev);
    }

    public final <T extends Parcelable> T getParcelable(Intent intent, String str, Class<T> cls) {
        Intrinsics.checkNotNullParameter(intent, "");
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(cls, "");
        if (Build.VERSION.SDK_INT >= 33) {
            return (T) intent.getParcelableExtra(str, cls);
        }
        return (T) intent.getParcelableExtra(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void BuiltInFictitiousFunctionClassFactory(boolean p0) {
        LayoutBankListBinding layoutBankListBinding = getBinding().PlaceComponentResult;
        EmptyState emptyState = layoutBankListBinding.BuiltInFictitiousFunctionClassFactory;
        Intrinsics.checkNotNullExpressionValue(emptyState, "");
        emptyState.setVisibility(p0 ? 0 : 8);
        RecyclerView recyclerView = layoutBankListBinding.MyBillsEntityDataFactory;
        Intrinsics.checkNotNullExpressionValue(recyclerView, "");
        boolean z = !p0;
        recyclerView.setVisibility(z ? 0 : 8);
        TextView textView = layoutBankListBinding.NetworkUserEntityData$$ExternalSyntheticLambda0;
        Intrinsics.checkNotNullExpressionValue(textView, "");
        textView.setVisibility(z ? 0 : 8);
    }

    @Override // id.dana.core.ui.BaseViewBindingActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onDestroy() {
        super.onDestroy();
        getBankListPresenter().onDestroy();
    }

    public static /* synthetic */ void $r8$lambda$BLfH9lB76yUoEUhTmPjl2BK1Ieo(BottomSheetBankListActivity bottomSheetBankListActivity, View view) {
        Intrinsics.checkNotNullParameter(bottomSheetBankListActivity, "");
        bottomSheetBankListActivity.finish();
    }

    public static /* synthetic */ void $r8$lambda$NrGVQnm1j1osXnITWUMeqjBYBII(BottomSheetBankListActivity bottomSheetBankListActivity, String str) {
        if (str.length() > 2) {
            bottomSheetBankListActivity.getBankListPresenter().BuiltInFictitiousFunctionClassFactory(str);
        }
        if (str.length() == 0) {
            BankListAdapter bankListAdapter = bottomSheetBankListActivity.PlaceComponentResult;
            if (bankListAdapter == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
                bankListAdapter = null;
            }
            BaseRecyclerViewDiffUtilAdapter.getAuthRequestContext(bankListAdapter, bottomSheetBankListActivity.BuiltInFictitiousFunctionClassFactory);
            bottomSheetBankListActivity.BuiltInFictitiousFunctionClassFactory(false);
        }
    }

    /* renamed from: $r8$lambda$TWw0m0uGpphusnfYPNm-gGNGSn8  reason: not valid java name */
    public static /* synthetic */ void m423$r8$lambda$TWw0m0uGpphusnfYPNmgGNGSn8(BottomSheetBankListActivity bottomSheetBankListActivity, boolean z) {
        Intrinsics.checkNotNullParameter(bottomSheetBankListActivity, "");
        if (z) {
            bottomSheetBankListActivity.getBinding().PlaceComponentResult.KClassImpl$Data$declaredNonStaticMembers$2.setExpanded(false);
        }
    }

    public static /* synthetic */ String $r8$lambda$brX93ot1C4pufwU0HWRErcZBpX8(CharSequence charSequence) {
        Intrinsics.checkNotNullParameter(charSequence, "");
        return charSequence.toString();
    }

    public static /* synthetic */ void $r8$lambda$vcGlRrNgKLQDDWO4X4JpKFLlyoA(BottomSheetBankListActivity bottomSheetBankListActivity, View view) {
        Intrinsics.checkNotNullParameter(bottomSheetBankListActivity, "");
        bottomSheetBankListActivity.PlaceComponentResult();
    }

    public static final /* synthetic */ void access$hideSkeletonLoading(BottomSheetBankListActivity bottomSheetBankListActivity) {
        SkeletonScreen skeletonScreen = bottomSheetBankListActivity.scheduleImpl;
        SkeletonScreen skeletonScreen2 = null;
        if (skeletonScreen == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            skeletonScreen = null;
        }
        skeletonScreen.PlaceComponentResult();
        SkeletonScreen skeletonScreen3 = bottomSheetBankListActivity.getAuthRequestContext;
        if (skeletonScreen3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
        } else {
            skeletonScreen2 = skeletonScreen3;
        }
        skeletonScreen2.PlaceComponentResult();
    }

    public static final /* synthetic */ void access$onBankSelectedThenFinish(BottomSheetBankListActivity bottomSheetBankListActivity, BankModel bankModel) {
        bottomSheetBankListActivity.setResult(-1, new Intent().putExtra("data", bankModel));
        bottomSheetBankListActivity.finish();
    }

    public static final /* synthetic */ void access$showBankSearchResult(BottomSheetBankListActivity bottomSheetBankListActivity, List list) {
        if (list != null) {
            if ((!list.isEmpty()) != false) {
                bottomSheetBankListActivity.BuiltInFictitiousFunctionClassFactory(false);
                BankListAdapter bankListAdapter = bottomSheetBankListActivity.PlaceComponentResult;
                if (bankListAdapter == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                    bankListAdapter = null;
                }
                BaseRecyclerViewDiffUtilAdapter.getAuthRequestContext(bankListAdapter, list);
                return;
            }
            bottomSheetBankListActivity.BuiltInFictitiousFunctionClassFactory(true);
        }
    }

    public static final /* synthetic */ void access$showSkeletonLoading(BottomSheetBankListActivity bottomSheetBankListActivity) {
        RecyclerViewSkeletonScreen.Builder BuiltInFictitiousFunctionClassFactory = Skeleton.BuiltInFictitiousFunctionClassFactory(bottomSheetBankListActivity.getBinding().PlaceComponentResult.lookAheadTest);
        BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory = R.layout.view_skeleton_top_bank_list;
        FeaturedBankAdapter featuredBankAdapter = bottomSheetBankListActivity.KClassImpl$Data$declaredNonStaticMembers$2;
        BankListAdapter bankListAdapter = null;
        if (featuredBankAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            featuredBankAdapter = null;
        }
        BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2 = featuredBankAdapter;
        BuiltInFictitiousFunctionClassFactory.NetworkUserEntityData$$ExternalSyntheticLambda0 = 1500;
        BuiltInFictitiousFunctionClassFactory.PlaceComponentResult = true;
        BuiltInFictitiousFunctionClassFactory.getErrorConfigVersion = ContextCompat.BuiltInFictitiousFunctionClassFactory(BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory.getContext(), R.color.f27082131100491);
        BuiltInFictitiousFunctionClassFactory.lookAheadTest = 20;
        BuiltInFictitiousFunctionClassFactory.getAuthRequestContext = 6;
        byte b = 0;
        RecyclerViewSkeletonScreen recyclerViewSkeletonScreen = new RecyclerViewSkeletonScreen(BuiltInFictitiousFunctionClassFactory, b);
        recyclerViewSkeletonScreen.MyBillsEntityDataFactory();
        Intrinsics.checkNotNullExpressionValue(recyclerViewSkeletonScreen, "");
        bottomSheetBankListActivity.scheduleImpl = recyclerViewSkeletonScreen;
        RecyclerViewSkeletonScreen.Builder BuiltInFictitiousFunctionClassFactory2 = Skeleton.BuiltInFictitiousFunctionClassFactory(bottomSheetBankListActivity.getBinding().PlaceComponentResult.MyBillsEntityDataFactory);
        BuiltInFictitiousFunctionClassFactory2.BuiltInFictitiousFunctionClassFactory = R.layout.view_skeleton_all_bank_list;
        BankListAdapter bankListAdapter2 = bottomSheetBankListActivity.PlaceComponentResult;
        if (bankListAdapter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
        } else {
            bankListAdapter = bankListAdapter2;
        }
        BuiltInFictitiousFunctionClassFactory2.KClassImpl$Data$declaredNonStaticMembers$2 = bankListAdapter;
        BuiltInFictitiousFunctionClassFactory2.NetworkUserEntityData$$ExternalSyntheticLambda0 = 1500;
        BuiltInFictitiousFunctionClassFactory2.PlaceComponentResult = true;
        BuiltInFictitiousFunctionClassFactory2.getErrorConfigVersion = ContextCompat.BuiltInFictitiousFunctionClassFactory(BuiltInFictitiousFunctionClassFactory2.MyBillsEntityDataFactory.getContext(), R.color.f27082131100491);
        BuiltInFictitiousFunctionClassFactory2.lookAheadTest = 20;
        RecyclerViewSkeletonScreen recyclerViewSkeletonScreen2 = new RecyclerViewSkeletonScreen(BuiltInFictitiousFunctionClassFactory2, b);
        recyclerViewSkeletonScreen2.MyBillsEntityDataFactory();
        Intrinsics.checkNotNullExpressionValue(recyclerViewSkeletonScreen2, "");
        bottomSheetBankListActivity.getAuthRequestContext = recyclerViewSkeletonScreen2;
    }

    public static final /* synthetic */ void access$toggleBankListEmptyState(BottomSheetBankListActivity bottomSheetBankListActivity, boolean z) {
        LayoutBankListBinding layoutBankListBinding = bottomSheetBankListActivity.getBinding().PlaceComponentResult;
        AppBarLayout appBarLayout = layoutBankListBinding.KClassImpl$Data$declaredNonStaticMembers$2;
        Intrinsics.checkNotNullExpressionValue(appBarLayout, "");
        boolean z2 = !z;
        appBarLayout.setVisibility(z2 ? 0 : 8);
        ConstraintLayout constraintLayout = layoutBankListBinding.PlaceComponentResult;
        Intrinsics.checkNotNullExpressionValue(constraintLayout, "");
        constraintLayout.setVisibility(z2 ? 0 : 8);
        ConstraintLayout constraintLayout2 = bottomSheetBankListActivity.getBinding().BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2;
        Intrinsics.checkNotNullExpressionValue(constraintLayout2, "");
        constraintLayout2.setVisibility(z ? 0 : 8);
    }

    @Override // id.dana.core.ui.BaseViewBindingActivity
    public final void init() {
        final FeaturedBankAdapter featuredBankAdapter = new FeaturedBankAdapter();
        Function2<BankModel, Integer, Unit> function2 = new Function2<BankModel, Integer, Unit>() { // from class: id.dana.bank.BottomSheetBankListActivity$initTopBankAdapter$1$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final /* synthetic */ Unit invoke(BankModel bankModel, Integer num) {
                invoke(bankModel, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(BankModel bankModel, int i) {
                Intrinsics.checkNotNullParameter(bankModel, "");
                BankModel authRequestContext = FeaturedBankAdapter.this.getAuthRequestContext(i);
                if (authRequestContext != null) {
                    BottomSheetBankListActivity.access$onBankSelectedThenFinish(this, authRequestContext);
                }
            }
        };
        Intrinsics.checkNotNullParameter(function2, "");
        featuredBankAdapter.BuiltInFictitiousFunctionClassFactory = function2;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = featuredBankAdapter;
        RecyclerView recyclerView = getBinding().PlaceComponentResult.lookAheadTest;
        FeaturedBankAdapter featuredBankAdapter2 = this.KClassImpl$Data$declaredNonStaticMembers$2;
        BankListAdapter bankListAdapter = null;
        if (featuredBankAdapter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            featuredBankAdapter2 = null;
        }
        recyclerView.setAdapter(featuredBankAdapter2);
        recyclerView.setNestedScrollingEnabled(true);
        final BankListAdapter bankListAdapter2 = new BankListAdapter();
        Function2<BankModel, Integer, Unit> function22 = new Function2<BankModel, Integer, Unit>() { // from class: id.dana.bank.BottomSheetBankListActivity$initAllBankAdapter$1$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final /* synthetic */ Unit invoke(BankModel bankModel, Integer num) {
                invoke(bankModel, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(BankModel bankModel, int i) {
                Intrinsics.checkNotNullParameter(bankModel, "");
                BankModel authRequestContext = BankListAdapter.this.getAuthRequestContext(i);
                if (authRequestContext != null) {
                    BottomSheetBankListActivity.access$onBankSelectedThenFinish(this, authRequestContext);
                }
            }
        };
        Intrinsics.checkNotNullParameter(function22, "");
        bankListAdapter2.BuiltInFictitiousFunctionClassFactory = function22;
        this.PlaceComponentResult = bankListAdapter2;
        RecyclerView recyclerView2 = getBinding().PlaceComponentResult.MyBillsEntityDataFactory;
        BankListAdapter bankListAdapter3 = this.PlaceComponentResult;
        if (bankListAdapter3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
        } else {
            bankListAdapter = bankListAdapter3;
        }
        recyclerView2.setAdapter(bankListAdapter);
        byte b = 0;
        recyclerView2.setLayoutManager(new LinearLayoutManager(recyclerView2.getContext(), 1, false));
        recyclerView2.setNestedScrollingEnabled(true);
        KeyboardHelper.PlaceComponentResult(getWindow().getDecorView(), new KeyboardHelper.KeyboardVisibilityListener() { // from class: id.dana.bank.BottomSheetBankListActivity$setupKeyboardListener$1
            @Override // id.dana.utils.KeyboardHelper.KeyboardVisibilityListener
            public final void KClassImpl$Data$declaredNonStaticMembers$2() {
                BottomSheetBankListActivity.this.MyBillsEntityDataFactory = true;
            }

            @Override // id.dana.utils.KeyboardHelper.KeyboardVisibilityListener
            public final void MyBillsEntityDataFactory() {
                BottomSheetBankListActivity.this.MyBillsEntityDataFactory = false;
            }
        });
        getBinding().KClassImpl$Data$declaredNonStaticMembers$2.setOnTouchListener(new OnSwipeListener() { // from class: id.dana.bank.BottomSheetBankListActivity$setupSwipeListener$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(BottomSheetBankListActivity.this);
            }

            @Override // id.dana.utils.OnSwipeListener
            public final void getAuthRequestContext() {
                BottomSheetBankListActivity.this.finish();
            }
        });
        SearchView searchView = getBinding().PlaceComponentResult.getErrorConfigVersion;
        String string = getString(R.string.request_money_bank_search_hint);
        Intrinsics.checkNotNullExpressionValue(string, "");
        searchView.setSearchHint(string);
        EditText editText = searchView.getEditText();
        searchView.getResources();
        editText.setTextColor(-13553359);
        searchView.addDisposable(searchView.getOnSearchClickedEvent().subscribe(new Consumer() { // from class: id.dana.bank.BottomSheetBankListActivity$$ExternalSyntheticLambda3
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                BottomSheetBankListActivity.m423$r8$lambda$TWw0m0uGpphusnfYPNmgGNGSn8(BottomSheetBankListActivity.this, ((Boolean) obj).booleanValue());
            }
        }));
        EditText editText2 = searchView.getEditText();
        Intrinsics.checkNotNullExpressionValue(editText2, "");
        searchView.addDisposable(RxTextView.textChanges(editText2).skipInitialValue().debounce(500L, TimeUnit.MILLISECONDS).subscribeOn(Schedulers.MyBillsEntityDataFactory()).observeOn(AndroidSchedulers.PlaceComponentResult()).map(new Function() { // from class: id.dana.bank.BottomSheetBankListActivity$$ExternalSyntheticLambda0
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return BottomSheetBankListActivity.$r8$lambda$brX93ot1C4pufwU0HWRErcZBpX8((CharSequence) obj);
            }
        }).subscribe(new Consumer() { // from class: id.dana.bank.BottomSheetBankListActivity$$ExternalSyntheticLambda4
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                BottomSheetBankListActivity.$r8$lambda$NrGVQnm1j1osXnITWUMeqjBYBII(BottomSheetBankListActivity.this, (String) obj);
            }
        }));
        getBinding().BuiltInFictitiousFunctionClassFactory.PlaceComponentResult.setOnClickListener(new View.OnClickListener() { // from class: id.dana.bank.BottomSheetBankListActivity$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                BottomSheetBankListActivity.$r8$lambda$vcGlRrNgKLQDDWO4X4JpKFLlyoA(BottomSheetBankListActivity.this, view);
            }
        });
        DaggerRequestMoneyBankListComponent.Builder BuiltInFictitiousFunctionClassFactory = DaggerRequestMoneyBankListComponent.BuiltInFictitiousFunctionClassFactory();
        Application application = getApplication();
        if (application == null) {
            throw new NullPointerException("null cannot be cast to non-null type id.dana.DanaApplication");
        }
        BuiltInFictitiousFunctionClassFactory.PlaceComponentResult = (ApplicationComponent) Preconditions.getAuthRequestContext(((DanaApplication) application).getApplicationComponent());
        BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory = (RequestMoneyBankListModule) Preconditions.getAuthRequestContext(new RequestMoneyBankListModule(new BankListContract.View() { // from class: id.dana.bank.BottomSheetBankListActivity$injectComponent$1
            @Override // id.dana.base.AbstractContractKt.AbstractView
            public final /* synthetic */ String getErrorSource() {
                return AbstractContractKt.AbstractView.CC.getAuthRequestContext();
            }

            @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
            public final /* synthetic */ void onError(String str) {
                AbstractContractKt.AbstractView.CC.BuiltInFictitiousFunctionClassFactory();
            }

            @Override // id.dana.bank.contract.BankListContract.View
            public final void BuiltInFictitiousFunctionClassFactory(List<? extends BankModel> p0) {
                FeaturedBankAdapter featuredBankAdapter3;
                Intrinsics.checkNotNullParameter(p0, "");
                featuredBankAdapter3 = BottomSheetBankListActivity.this.KClassImpl$Data$declaredNonStaticMembers$2;
                if (featuredBankAdapter3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                    featuredBankAdapter3 = null;
                }
                BaseRecyclerViewDiffUtilAdapter.getAuthRequestContext(featuredBankAdapter3, p0);
                BottomSheetBankListActivity.access$toggleBankListEmptyState(BottomSheetBankListActivity.this, false);
            }

            @Override // id.dana.bank.contract.BankListContract.View
            public final void MyBillsEntityDataFactory(List<? extends BankModel> p0) {
                BankListAdapter bankListAdapter4;
                ArrayList arrayList;
                Intrinsics.checkNotNullParameter(p0, "");
                bankListAdapter4 = BottomSheetBankListActivity.this.PlaceComponentResult;
                if (bankListAdapter4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                    bankListAdapter4 = null;
                }
                BaseRecyclerViewDiffUtilAdapter.getAuthRequestContext(bankListAdapter4, p0);
                arrayList = BottomSheetBankListActivity.this.BuiltInFictitiousFunctionClassFactory;
                arrayList.addAll(p0);
                BottomSheetBankListActivity.this.BuiltInFictitiousFunctionClassFactory(false);
            }

            @Override // id.dana.bank.contract.BankListContract.View
            public final void KClassImpl$Data$declaredNonStaticMembers$2(String p0) {
                Intrinsics.checkNotNullParameter(p0, "");
                BottomSheetBankListActivity.access$toggleBankListEmptyState(BottomSheetBankListActivity.this, true);
            }

            @Override // id.dana.bank.contract.BankListContract.View
            public final void PlaceComponentResult(List<? extends BankModel> p0) {
                Intrinsics.checkNotNullParameter(p0, "");
                BottomSheetBankListActivity.access$showBankSearchResult(BottomSheetBankListActivity.this, p0);
            }

            @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
            public final void showProgress() {
                BottomSheetBankListActivity.access$toggleBankListEmptyState(BottomSheetBankListActivity.this, false);
                BottomSheetBankListActivity.access$showSkeletonLoading(BottomSheetBankListActivity.this);
            }

            @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
            public final void dismissProgress() {
                BottomSheetBankListActivity.access$hideSkeletonLoading(BottomSheetBankListActivity.this);
            }
        }));
        Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory, RequestMoneyBankListModule.class);
        if (BuiltInFictitiousFunctionClassFactory.getAuthRequestContext == null) {
            BuiltInFictitiousFunctionClassFactory.getAuthRequestContext = new SendMoneyTrackerModule();
        }
        Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(BuiltInFictitiousFunctionClassFactory.PlaceComponentResult, ApplicationComponent.class);
        new DaggerRequestMoneyBankListComponent.RequestMoneyBankListComponentImpl(BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory, BuiltInFictitiousFunctionClassFactory.getAuthRequestContext, BuiltInFictitiousFunctionClassFactory.PlaceComponentResult, b).MyBillsEntityDataFactory(this);
        Intent intent = getIntent();
        Intrinsics.checkNotNullExpressionValue(intent, "");
        this.lookAheadTest = (TransferInit) getParcelable(intent, TRANSFER_INIT, TransferInit.class);
        PlaceComponentResult();
        getBinding().MyBillsEntityDataFactory.setOnClickListener(new View.OnClickListener() { // from class: id.dana.bank.BottomSheetBankListActivity$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                BottomSheetBankListActivity.$r8$lambda$BLfH9lB76yUoEUhTmPjl2BK1Ieo(BottomSheetBankListActivity.this, view);
            }
        });
    }

    private static void a(boolean z, int[] iArr, byte[] bArr, Object[] objArr) {
        VerifyPinStateManager$executeRiskChallenge$2$2 verifyPinStateManager$executeRiskChallenge$2$2 = new VerifyPinStateManager$executeRiskChallenge$2$2();
        int i = iArr[0];
        int i2 = iArr[1];
        int i3 = iArr[2];
        int i4 = iArr[3];
        char[] cArr = DatabaseTableConfigUtil;
        if (cArr != null) {
            int length = cArr.length;
            char[] cArr2 = new char[length];
            for (int i5 = 0; i5 < length; i5++) {
                cArr2[i5] = (char) (cArr[i5] ^ 5097613533456403102L);
            }
            cArr = cArr2;
        }
        char[] cArr3 = new char[i2];
        System.arraycopy(cArr, i, cArr3, 0, i2);
        if (bArr != null) {
            char[] cArr4 = new char[i2];
            verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory = 0;
            char c = 0;
            while (verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory < i2) {
                if (bArr[verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory] == 1) {
                    cArr4[verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory] = (char) (((cArr3[verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory] * 2) + 1) - c);
                } else {
                    cArr4[verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory] = (char) ((cArr3[verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory] * 2) - c);
                }
                c = cArr4[verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory];
                verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory++;
            }
            cArr3 = cArr4;
        }
        if (i4 > 0) {
            char[] cArr5 = new char[i2];
            System.arraycopy(cArr3, 0, cArr5, 0, i2);
            int i6 = i2 - i4;
            System.arraycopy(cArr5, 0, cArr3, i6, i4);
            System.arraycopy(cArr5, i4, cArr3, 0, i6);
        }
        if (z) {
            char[] cArr6 = new char[i2];
            verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory = 0;
            while (verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory < i2) {
                cArr6[verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory] = cArr3[(i2 - verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory) - 1];
                verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory++;
            }
            cArr3 = cArr6;
        }
        if (i3 > 0) {
            verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory = 0;
            while (verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory < i2) {
                cArr3[verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory] = (char) (cArr3[verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory] - iArr[2]);
                verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory++;
            }
        }
        objArr[0] = new String(cArr3);
    }
}
