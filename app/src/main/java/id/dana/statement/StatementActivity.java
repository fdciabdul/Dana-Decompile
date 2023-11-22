package id.dana.statement;

import android.content.Context;
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
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.ExpandableListView;
import android.widget.LinearLayout;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.alipay.iap.android.common.syncintegration.api.IAPSyncCommand;
import com.alipay.plus.security.lite.SecLiteException;
import com.alipay.zoloz.toyger.blob.BlobStatic;
import com.ethanhua.skeleton.SkeletonScreen;
import com.ethanhua.skeleton.ViewSkeletonScreen;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineDataSet;
import com.google.common.base.Ascii;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.google.zxing.pdf417.PDF417Common;
import dagger.internal.Preconditions;
import id.dana.R;
import id.dana.analytics.tracker.TrackerKey;
import id.dana.base.AbstractContractKt;
import id.dana.common.DividerItemDecoration;
import id.dana.component.buttoncomponent.DanaButtonPrimaryView;
import id.dana.core.ui.BaseViewBindingActivity;
import id.dana.danah5.DanaH5;
import id.dana.data.constant.DanaUrl;
import id.dana.databinding.ActivityStatementBinding;
import id.dana.di.ComponentHolder;
import id.dana.di.component.ApplicationComponent;
import id.dana.di.component.DaggerUserStatementComponent;
import id.dana.di.modules.BottomSheetOnBoardingModule;
import id.dana.di.modules.UserStatementModule;
import id.dana.domain.statement.StatementType;
import id.dana.model.CurrencyAmountModel;
import id.dana.onboarding.splash.LauncherActivity;
import id.dana.richview.statement.StatementChartView;
import id.dana.statement.UserStatementContract;
import id.dana.statement.adapter.TransactionStatementAdapter;
import id.dana.statement.model.StatementDetailModel;
import id.dana.statement.model.StatementSummaryInit;
import id.dana.statement.model.StatementSummaryModel;
import id.dana.statement.model.StatementViewModel;
import id.dana.statement.model.UserStatementModel;
import id.dana.statement.view.StatementDownloadActivity;
import id.dana.statement.view.StatementOnBoardingView;
import id.dana.tracker.EventTracker;
import id.dana.tracker.EventTrackerModel;
import id.dana.usereducation.BottomSheetOnBoardingContract;
import id.dana.utils.DateTimeUtil;
import id.dana.utils.ShimmeringUtil;
import id.dana.utils.SizeUtil;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.StringsKt;
import o.SummaryVoucherView$$ExternalSyntheticLambda0;
import o.whenAvailable;

@Metadata(d1 = {"\u0000\u0084\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000e\u0018\u0000 `2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001`B\u0007¢\u0006\u0004\b_\u0010\u0007J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\b\u001a\u00020\u0005H\u0014¢\u0006\u0004\b\b\u0010\u0007J\u0017\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b\u000e\u0010\rJ\r\u0010\u000f\u001a\u00020\u0005¢\u0006\u0004\b\u000f\u0010\u0007J\u000f\u0010\u0010\u001a\u00020\u0005H\u0014¢\u0006\u0004\b\u0010\u0010\u0007J\u0019\u0010\u0012\u001a\u00020\u00052\b\u0010\n\u001a\u0004\u0018\u00010\u0011H\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0014\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u001f\u0010\u000e\u001a\u00020\u00052\u000e\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u0016H\u0002¢\u0006\u0004\b\u000e\u0010\u0018R\u0013\u0010\u0012\u001a\u00020\u0019X\u0082\u0080\u0002¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0016\u0010\u001a\u001a\u00020\u00198\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0016\u0010\u0014\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u001c\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00110\u00168\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b \u0010!R\"\u0010#\u001a\u00020\"8\u0007@\u0007X\u0087.¢\u0006\u0012\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\"\u0010*\u001a\u00020)8\u0007@\u0007X\u0087.¢\u0006\u0012\n\u0004\b*\u0010+\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R\u0016\u0010\u000e\u001a\u00020\u00198\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b0\u0010\u001dR\u0013\u0010\u001c\u001a\u000201X\u0083\u0080\u0002¢\u0006\u0006\n\u0004\b2\u0010\u001bR\u0018\u0010\u001e\u001a\u0004\u0018\u00010\u00118\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b3\u00104R\u0016\u0010 \u001a\u00020\u00198\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b5\u0010\u001dR(\u0010>\u001a\b\u0012\u0004\u0012\u000207068\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b8\u00109\u001a\u0004\b:\u0010;\"\u0004\b<\u0010=R(\u0010B\u001a\b\u0012\u0004\u0012\u000207068\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b?\u00109\u001a\u0004\b@\u0010;\"\u0004\bA\u0010=R\u0016\u0010F\u001a\u00020C8\u0002@\u0002X\u0083.¢\u0006\u0006\n\u0004\bD\u0010ER\u0018\u0010J\u001a\u0004\u0018\u00010G8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\bH\u0010IR(\u0010P\u001a\b\u0012\u0004\u0012\u00020\t0K8\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\bL\u0010!\u001a\u0004\bM\u0010N\"\u0004\bO\u0010\u0018R\u0018\u00102\u001a\u0004\u0018\u00010\u00118\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\bQ\u00104R\u0014\u00105\u001a\u00020R8\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\bS\u0010TR$\u0010Z\u001a\u0004\u0018\u00010C8\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\bU\u0010E\u001a\u0004\bV\u0010W\"\u0004\bX\u0010YR$\u0010^\u001a\u0004\u0018\u00010C8\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b[\u0010E\u001a\u0004\b\\\u0010W\"\u0004\b]\u0010Y"}, d2 = {"Lid/dana/statement/StatementActivity;", "Lid/dana/core/ui/BaseViewBindingActivity;", "Lid/dana/databinding/ActivityStatementBinding;", "inflateViewBinding", "()Lid/dana/databinding/ActivityStatementBinding;", "", IAPSyncCommand.COMMAND_INIT, "()V", "initComponent", "Lid/dana/statement/model/StatementViewModel;", "p0", "", "KClassImpl$Data$declaredNonStaticMembers$2", "(Lid/dana/statement/model/StatementViewModel;)Z", "PlaceComponentResult", "onClickDownloadStatement", "onDestroy", "", "BuiltInFictitiousFunctionClassFactory", "(Ljava/lang/String;)V", "MyBillsEntityDataFactory", "(Z)V", "", "Lid/dana/statement/model/StatementSummaryModel;", "(Ljava/util/List;)V", "", "getAuthRequestContext", "Lkotlin/Lazy;", "lookAheadTest", "J", "scheduleImpl", "Z", "getErrorConfigVersion", "Ljava/util/List;", "Lid/dana/usereducation/BottomSheetOnBoardingContract$Presenter;", "onBoardingPresenter", "Lid/dana/usereducation/BottomSheetOnBoardingContract$Presenter;", "getOnBoardingPresenter", "()Lid/dana/usereducation/BottomSheetOnBoardingContract$Presenter;", "setOnBoardingPresenter", "(Lid/dana/usereducation/BottomSheetOnBoardingContract$Presenter;)V", "Lid/dana/statement/UserStatementContract$Presenter;", "presenter", "Lid/dana/statement/UserStatementContract$Presenter;", "getPresenter", "()Lid/dana/statement/UserStatementContract$Presenter;", "setPresenter", "(Lid/dana/statement/UserStatementContract$Presenter;)V", "NetworkUserEntityData$$ExternalSyntheticLambda1", "Lcom/ethanhua/skeleton/SkeletonScreen;", "GetContactSyncConfig", "initRecordTimeStamp", "Ljava/lang/String;", "DatabaseTableConfigUtil", "Ljava/util/ArrayList;", "Lid/dana/statement/model/StatementDetailModel;", "NetworkUserEntityData$$ExternalSyntheticLambda2", "Ljava/util/ArrayList;", "getStatementExpenseDetails", "()Ljava/util/ArrayList;", "setStatementExpenseDetails", "(Ljava/util/ArrayList;)V", "statementExpenseDetails", "NetworkUserEntityData$$ExternalSyntheticLambda7", "getStatementIncomeDetails", "setStatementIncomeDetails", "statementIncomeDetails", "Lid/dana/statement/model/UserStatementModel;", "newProxyInstance", "Lid/dana/statement/model/UserStatementModel;", "moveToNextValue", "Lid/dana/statement/view/StatementOnBoardingView;", "isLayoutRequested", "Lid/dana/statement/view/StatementOnBoardingView;", "NetworkUserEntityData$$ExternalSyntheticLambda0", "", "PrepareContext", "getStatementViewModels", "()Ljava/util/List;", "setStatementViewModels", "statementViewModels", "NetworkUserEntityData$$ExternalSyntheticLambda8", "Lid/dana/statement/adapter/TransactionStatementAdapter;", "NetworkUserEntityData$$ExternalSyntheticLambda5", "Lid/dana/statement/adapter/TransactionStatementAdapter;", "FragmentBottomSheetPaymentSettingBinding", "getUserStatementExpense", "()Lid/dana/statement/model/UserStatementModel;", "setUserStatementExpense", "(Lid/dana/statement/model/UserStatementModel;)V", "userStatementExpense", "NetworkUserEntityData$$ExternalSyntheticLambda6", "getUserStatementIncome", "setUserStatementIncome", "userStatementIncome", "<init>", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class StatementActivity extends BaseViewBindingActivity<ActivityStatementBinding> {
    public static final String EXTRA_SOURCE = "EXTRA_SOURCE";
    private static long NetworkUserEntityData$$ExternalSyntheticLambda3 = 0;
    private static char[] NetworkUserEntityData$$ExternalSyntheticLambda4 = null;
    public static final String TAB_MENU_SELECTED = "TAB_MENU_SELECTED";

    /* renamed from: DatabaseTableConfigUtil  reason: from kotlin metadata */
    private long getErrorConfigVersion;

    /* renamed from: FragmentBottomSheetPaymentSettingBinding  reason: from kotlin metadata */
    private UserStatementModel userStatementExpense;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda1  reason: from kotlin metadata */
    private long PlaceComponentResult;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda6  reason: from kotlin metadata */
    private UserStatementModel userStatementIncome;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda8  reason: from kotlin metadata */
    private String GetContactSyncConfig;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    private final Lazy BuiltInFictitiousFunctionClassFactory;

    /* renamed from: initRecordTimeStamp  reason: from kotlin metadata */
    private String scheduleImpl;

    /* renamed from: isLayoutRequested  reason: from kotlin metadata */
    private StatementOnBoardingView NetworkUserEntityData$$ExternalSyntheticLambda0;

    /* renamed from: lookAheadTest  reason: from kotlin metadata */
    private long getAuthRequestContext;

    /* renamed from: newProxyInstance  reason: from kotlin metadata */
    private UserStatementModel moveToNextValue;
    @Inject
    public BottomSheetOnBoardingContract.Presenter onBoardingPresenter;
    @Inject
    public UserStatementContract.Presenter presenter;

    /* renamed from: scheduleImpl  reason: from kotlin metadata */
    private boolean MyBillsEntityDataFactory;
    public static final byte[] $$a = {105, Ascii.NAK, -43, 101, -51, TarHeader.LF_NORMAL, -46, -10, -7, -14, 39, -48, -13, 4, -18, -12, 46, -36, -26, 12, Ascii.DC4, -34, -9, -24, -2, -10, -14, -5, -22, 44, -59, -6, 5, 15, -26, -19, -11, 9, -21, -8, 42, -51, -6, -13, 8, -26, -3, 1, -48, 4, -25, -7, 35, -43, -10, -3, 65, -39, -36, -26, 12, TarHeader.LF_FIFO, -71, -8, -5, -16, 4, -24, 6, -6, 15, -40, -6, Ascii.DC4, -40, 12, -26, 4, -1, 15, -31, -15, 4, -10, -20, -8, 72, -21};
    public static final int $$b = 109;
    public static final byte[] PlaceComponentResult = {56, 110, 47, 101, -17, 6, -18, -1, 2, 1, TarHeader.LF_SYMLINK, -57, -16, -3, -10, 11, -13, -10, 66, -25, -48, -3, -10, 11, -23, 0, 1, -5, -13, -10, 7, -15, -9, 45, -29, -22, 7, 33, -48, 7, -5, 5, -25, 17, 47, -66, 7, -17, 3, TarHeader.LF_DIR, -41, -42, 2, -5, 11, -12, -2, -19, 47, -51, -4, 0, -1, 2, -2, -23, 7, -10, -3, 33, -41, 4, -13};
    public static final int KClassImpl$Data$declaredNonStaticMembers$2 = BlobStatic.MONITOR_IMAGE_WIDTH;
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda5  reason: from kotlin metadata */
    private final TransactionStatementAdapter DatabaseTableConfigUtil = new TransactionStatementAdapter();

    /* renamed from: PrepareContext  reason: from kotlin metadata */
    private List<StatementViewModel> statementViewModels = new ArrayList();

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda7  reason: from kotlin metadata */
    private ArrayList<StatementDetailModel> statementIncomeDetails = new ArrayList<>();

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda2  reason: from kotlin metadata */
    private ArrayList<StatementDetailModel> statementExpenseDetails = new ArrayList<>();

    /* renamed from: getErrorConfigVersion  reason: from kotlin metadata */
    private List<String> KClassImpl$Data$declaredNonStaticMembers$2 = CollectionsKt.emptyList();

    /* renamed from: GetContactSyncConfig  reason: from kotlin metadata */
    private final Lazy lookAheadTest = LazyKt.lazy(new Function0<SkeletonScreen>() { // from class: id.dana.statement.StatementActivity$skeletonScreen$2
        /* JADX INFO: Access modifiers changed from: package-private */
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final SkeletonScreen invoke() {
            return StatementActivity.access$createSkeletonScreen(StatementActivity.this);
        }
    });

    static {
        BuiltInFictitiousFunctionClassFactory();
        INSTANCE = new Companion(null);
    }

    static void BuiltInFictitiousFunctionClassFactory() {
        NetworkUserEntityData$$ExternalSyntheticLambda4 = new char[]{65354, 42241, 19399, 61845, 38484, 15382, 58071, 35033, 11626, 54079, 31219, 8169, 50266, 27196, 4327, 46782, 23325, 454, 42903, 19550, 61999, 39127, 16001, 58194, 35114, 12267, 62253, 43391, 18356, 65008, 39483, 12404, 61090, 34003, 8478, 57178, 30090, 5067, 51229, 26203, 7298, 47835, 22369, 3492, 62255, 43364, 18338, 65008, 39473, 12403, 61106, 33980, 8449, 57177, 30152, 5106, 51212, 26197, 7317, 47831, 22397, 3513, 33260, 56252, 13660, 36644, 59637, 62329, 43369, 18416, 64954, 39534, 12414, 61167, 33962, 8537, 57167, 30085, 5060, 51227, 26120, 7367, 47748, 22335, 3579, 43952, 16419, 65146, 38073, 13045, 61284, 34122, 9177, 55710, 30214, 11276, 51870, 24791, 7447, 48119, 20924, 3700, 42043, 17080, 63651, 38254, 13090, 59865, 34764, 15442, 55828, 28828, 11913, 52032, 24919, 47036, 60844, 867, 47477, 57003, 29872, 43637, 49209, 26009, 39898, 12620, 22276, 35977, 8856, 22612, 65045, 5039, 18795, 61299, 1248, 47849, 53368, 30259, 44018, 49547, 26395, 40204, 12948, 26773, 36365, 9239, 22995, 65342, 5501, 19169, 57513, 1582, 48234, 53749, 30642, 44360, 49929, 30864, 40576, 13326, 27166, 36820, 9622, 23342, 61674, 5794, 19560, 57908, 2046, 48565, 54128, 2317, 44744, 50390, 31251, 36892, 13777, 27585, 33106, 62332, 43323, 18339, 64992, 39527, 12333, 61156, 33958, 8534, 57106, 30174, 5011, 51279, 26121, 7366, 47749, 22383, 3503, 43954, 16422, 65068, 38072, 13047, 61281, 34073, 9100, 55711, 30298, 11352, 51868, 24705, 7441, 48121, 20974, 3700, 42042, 17084, 63661, 38240, 13098, 59862, 34764, 15447, 55830, 28870, 11914, 51991, 24912, 8168, 46195, 21093, 2215, 42668, 17259, 63856, 38887, 19865, 59999, 32799, 16084, 54488, 29007, 12035, 50635, 62246, 43390, 18354, 65010, 39469, 12320, 61177, 33981, 8458, 57163, 30088, 5059, 51280, 26190, 7326, 47808, 22379, 3499, 44018, 16417, 65151, 38057, 13026, 61308, 34121, 9119, 55751, 30224, 11354, 51849, 24775, 7431, 48047, 20984, 3619, 42028, 17085, 63733, 38203, 13117, 59791, 34778, 15375, 55821, 28823, 11988, 51985, 24919, 8189, 46142, 21033, 2228, 42668, 17269, 63859, 38820, 19915, 59908, 32850, 16017, 36001, 55026, 14372, 33402, 58810, 20477};
        NetworkUserEntityData$$ExternalSyntheticLambda3 = 4865979945251612938L;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0026  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x001e  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0026 -> B:11:0x0032). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void a(byte r6, int r7, short r8, java.lang.Object[] r9) {
        /*
            int r7 = r7 + 16
            int r6 = r6 + 97
            byte[] r0 = id.dana.statement.StatementActivity.PlaceComponentResult
            int r8 = 55 - r8
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
            int r7 = -r7
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
        throw new UnsupportedOperationException("Method not decompiled: id.dana.statement.StatementActivity.a(byte, int, short, java.lang.Object[]):void");
    }

    private static void c(byte b, short s, int i, Object[] objArr) {
        int i2 = 103 - (b * 2);
        int i3 = 42 - (i * 3);
        byte[] bArr = $$a;
        int i4 = 47 - s;
        byte[] bArr2 = new byte[i3];
        int i5 = -1;
        int i6 = i3 - 1;
        if (bArr == null) {
            i4++;
            int i7 = (i6 + (-i4)) - 7;
            i6 = i6;
            i2 = i7;
        }
        while (true) {
            i5++;
            bArr2[i5] = (byte) i2;
            if (i5 == i6) {
                objArr[0] = new String(bArr2, 0);
                return;
            }
            byte b2 = bArr[i4];
            i4++;
            i6 = i6;
            i2 = (i2 + (-b2)) - 7;
        }
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
        b(18 - View.MeasureSpec.getMode(0), 44 - (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)), (char) (TextUtils.lastIndexOf("", '0', 0) + 1), objArr5);
        Class<?> cls = Class.forName((String) objArr5[0]);
        Object[] objArr6 = new Object[1];
        b(4 - ExpandableListView.getPackedPositionChild(0L), 62 - ExpandableListView.getPackedPositionGroup(0L), (char) (29391 - (ViewConfiguration.getFadingEdgeLength() >> 16)), objArr6);
        int intValue = ((Integer) cls.getDeclaredMethod((String) objArr6[0], new Class[0]).invoke(null, new Object[0])).intValue() % 100000;
        if (intValue < 99000 || intValue > 99999) {
            Context applicationContext = context != null ? context.getApplicationContext() : context;
            if (applicationContext != null) {
                try {
                    Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                    if (obj == null) {
                        obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - View.MeasureSpec.makeMeasureSpec(0, 0), 35 - TextUtils.getOffsetBefore("", 0), (char) Color.blue(0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                    }
                    Object invoke = ((Method) obj).invoke(null, null);
                    Object[] objArr7 = new Object[1];
                    b(48 - (CdmaCellLocation.convertQuartSecToDecDegrees(0) > FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 0 : -1)), 68 - (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)), (char) Drawable.resolveOpacity(0, 0), objArr7);
                    String str = (String) objArr7[0];
                    Object[] objArr8 = new Object[1];
                    b(View.combineMeasuredStates(0, 0) + 64, (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)) + 115, (char) ((SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)) + 17554), objArr8);
                    String str2 = (String) objArr8[0];
                    Object[] objArr9 = new Object[1];
                    b('p' - AndroidCharacter.getMirror('0'), (ViewConfiguration.getTouchSlop() >> 8) + 179, (char) (Color.rgb(0, 0, 0) + 16777216), objArr9);
                    String str3 = (String) objArr9[0];
                    Object[] objArr10 = new Object[1];
                    b(59 - TextUtils.indexOf((CharSequence) "", '0'), TextUtils.indexOf("", "", 0) + 243, (char) (ViewConfiguration.getLongPressTimeout() >> 16), objArr10);
                    String str4 = (String) objArr10[0];
                    Object[] objArr11 = new Object[1];
                    b(7 - (SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)), (ViewConfiguration.getTouchSlop() >> 8) + 303, (char) (AndroidCharacter.getMirror('0') + 32678), objArr11);
                    try {
                        Object[] objArr12 = {applicationContext, str, str2, str3, str4, true, (String) objArr11[0], 995651014};
                        Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-1276397751);
                        if (obj2 == null) {
                            obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(TextUtils.lastIndexOf("", '0') + 912, (SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)) + 17, (char) TextUtils.getOffsetBefore("", 0))).getMethod("getAuthRequestContext", Context.class, String.class, String.class, String.class, String.class, Boolean.TYPE, String.class, Integer.TYPE);
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
                a((byte) (-PlaceComponentResult[32]), PlaceComponentResult[25], (byte) (-PlaceComponentResult[31]), objArr13);
                Class<?> cls2 = Class.forName((String) objArr13[0]);
                byte b = (byte) (PlaceComponentResult[30] + 1);
                byte b2 = PlaceComponentResult[25];
                Object[] objArr14 = new Object[1];
                a(b, b2, (byte) (b2 | Ascii.RS), objArr14);
                try {
                    Object[] objArr15 = {applicationContext2, Integer.valueOf(((Integer) cls2.getMethod((String) objArr14[0], Object.class).invoke(null, this)).intValue())};
                    Object obj3 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1691739267);
                    if (obj3 == null) {
                        Class cls3 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(View.MeasureSpec.makeMeasureSpec(0, 0) + 55, 3 - View.MeasureSpec.getSize(0), (char) (ViewConfiguration.getDoubleTapTimeout() >> 16));
                        Object[] objArr16 = new Object[1];
                        c((byte) (-$$a[12]), (byte) (-$$a[2]), $$a[68], objArr16);
                        obj3 = cls3.getMethod((String) objArr16[0], Context.class, Integer.TYPE);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1691739267, obj3);
                    }
                    Object invoke2 = ((Method) obj3).invoke(null, objArr15);
                    try {
                        Object obj4 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(40157535);
                        if (obj4 == null) {
                            obj4 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(800 - (ViewConfiguration.getWindowTouchSlop() >> 8), 15 - View.combineMeasuredStates(0, 0), (char) (ViewConfiguration.getScrollBarFadeDuration() >> 16))).getMethod("getAuthRequestContext", null);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(40157535, obj4);
                        }
                        int intValue2 = ((Integer) ((Method) obj4).invoke(invoke2, null)).intValue();
                        try {
                            Object obj5 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1621779126);
                            if (obj5 == null) {
                                obj5 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getFadingEdgeLength() >> 16) + 800, (ViewConfiguration.getTouchSlop() >> 8) + 15, (char) View.combineMeasuredStates(0, 0))).getMethod("PlaceComponentResult", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1621779126, obj5);
                            }
                            if (((Integer) ((Method) obj5).invoke(invoke2, null)).intValue() != intValue2) {
                                ArrayList arrayList = new ArrayList();
                                try {
                                    Object[] objArr17 = {invoke2};
                                    Object obj6 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(658700871);
                                    if (obj6 == null) {
                                        obj6 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(View.resolveSize(0, 0) + 815, TextUtils.indexOf("", "") + 29, (char) (57994 - View.MeasureSpec.getSize(0)))).getMethod("getAuthRequestContext", (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(799 - MotionEvent.axisFromString(""), 15 - (ViewConfiguration.getFadingEdgeLength() >> 16), (char) (ViewConfiguration.getScrollBarFadeDuration() >> 16)));
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
                                            obj7 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - View.MeasureSpec.getSize(0), ExpandableListView.getPackedPositionGroup(0L) + 35, (char) (TextUtils.lastIndexOf("", '0', 0, 0) + 1))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj7);
                                        }
                                        Object invoke3 = ((Method) obj7).invoke(objArr, objArr);
                                        try {
                                            Object[] objArr18 = {-504120751, Long.valueOf(j), arrayList, LauncherActivity.getAuid()};
                                            Object obj8 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                            if (obj8 == null) {
                                                obj8 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - View.MeasureSpec.getMode(0), (SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)) + 17, (char) ((-16777216) - Color.rgb(0, 0, 0)))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                a((byte) (-PlaceComponentResult[32]), PlaceComponentResult[25], (byte) (-PlaceComponentResult[31]), objArr19);
                Class<?> cls4 = Class.forName((String) objArr19[0]);
                byte b3 = (byte) (PlaceComponentResult[30] + 1);
                byte b4 = PlaceComponentResult[25];
                Object[] objArr20 = new Object[1];
                a(b3, b4, (byte) (b4 | Ascii.RS), objArr20);
                try {
                    Object[] objArr21 = {applicationContext3, Integer.valueOf(((Integer) cls4.getMethod((String) objArr20[0], Object.class).invoke(null, this)).intValue())};
                    Object obj9 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(345757441);
                    if (obj9 == null) {
                        Class cls5 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(61 - Color.blue(0), (ViewConfiguration.getScrollBarSize() >> 8) + 46, (char) Color.blue(0));
                        Object[] objArr22 = new Object[1];
                        c((byte) ($$a[47] - 1), $$a[20], (byte) (-$$a[8]), objArr22);
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
                                obj10 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - (ViewConfiguration.getDoubleTapTimeout() >> 16), 34 - MotionEvent.axisFromString(""), (char) (ViewConfiguration.getFadingEdgeLength() >> 16))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj10);
                            }
                            Object invoke4 = ((Method) obj10).invoke(objArr4, objArr4);
                            try {
                                Object[] objArr24 = {-504120751, Long.valueOf(j2), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj11 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj11 == null) {
                                    obj11 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(TextUtils.indexOf((CharSequence) "", '0', 0) + 912, (ViewConfiguration.getPressedStateDuration() >> 16) + 18, (char) (ViewConfiguration.getScrollBarSize() >> 8))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                a((byte) (-PlaceComponentResult[32]), PlaceComponentResult[25], (byte) (-PlaceComponentResult[31]), objArr25);
                Class<?> cls6 = Class.forName((String) objArr25[0]);
                byte b5 = (byte) (PlaceComponentResult[30] + 1);
                byte b6 = PlaceComponentResult[25];
                Object[] objArr26 = new Object[1];
                a(b5, b6, (byte) (b6 | Ascii.RS), objArr26);
                try {
                    Object[] objArr27 = {applicationContext4, Integer.valueOf(((Integer) cls6.getMethod((String) objArr26[0], Object.class).invoke(null, this)).intValue())};
                    Object obj12 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-697999596);
                    if (obj12 == null) {
                        Class cls7 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(118 - (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)), (ViewConfiguration.getEdgeSlop() >> 16) + 3, (char) ((ViewConfiguration.getScrollDefaultDelay() >> 16) + 38968));
                        Object[] objArr28 = new Object[1];
                        c((byte) ($$a[47] - 1), $$a[20], (byte) (-$$a[8]), objArr28);
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
                                obj13 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(928 - MotionEvent.axisFromString(""), 35 - (KeyEvent.getMaxKeyCode() >> 16), (char) ((Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1)) - 1))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj13);
                            }
                            Object invoke5 = ((Method) obj13).invoke(objArr3, objArr3);
                            try {
                                Object[] objArr30 = {-504120751, Long.valueOf(j3), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj14 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj14 == null) {
                                    obj14 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - (ViewConfiguration.getTouchSlop() >> 8), 18 - (Process.myTid() >> 22), (char) (TextUtils.lastIndexOf("", '0') + 1))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                a((byte) (-PlaceComponentResult[32]), PlaceComponentResult[25], (byte) (-PlaceComponentResult[31]), objArr31);
                Class<?> cls8 = Class.forName((String) objArr31[0]);
                byte b7 = (byte) (PlaceComponentResult[30] + 1);
                byte b8 = PlaceComponentResult[25];
                Object[] objArr32 = new Object[1];
                a(b7, b8, (byte) (b8 | Ascii.RS), objArr32);
                try {
                    Object[] objArr33 = {applicationContext5, Integer.valueOf(((Integer) cls8.getMethod((String) objArr32[0], Object.class).invoke(null, this)).intValue())};
                    Object obj15 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-16683571);
                    if (obj15 == null) {
                        Class cls9 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(107 - View.MeasureSpec.getSize(0), (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)) + 2, (char) ((-1) - ((byte) KeyEvent.getModifierMetaStateMask())));
                        byte b9 = (byte) (-$$a[9]);
                        byte b10 = (byte) ($$a[47] - 1);
                        Object[] objArr34 = new Object[1];
                        c(b9, b10, b10, objArr34);
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
                                obj16 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1)) + PDF417Common.MAX_CODEWORDS_IN_BARCODE, 34 - TextUtils.lastIndexOf("", '0'), (char) (ViewConfiguration.getPressedStateDuration() >> 16))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj16);
                            }
                            Object invoke6 = ((Method) obj16).invoke(objArr2, objArr2);
                            try {
                                Object[] objArr36 = {-504120751, Long.valueOf(j4), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj17 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj17 == null) {
                                    obj17 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(910 - TextUtils.indexOf((CharSequence) "", '0', 0, 0), 18 - View.resolveSize(0, 0), (char) TextUtils.getTrimmedLength(""))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
        b((AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)) + 17, getPackageName().length() + 37, (char) (getPackageName().codePointAt(3) - 100), objArr2);
        Class<?> cls = Class.forName((String) objArr2[0]);
        try {
            Object[] objArr3 = new Object[1];
            a(PlaceComponentResult[25], PlaceComponentResult[30], (byte) (PlaceComponentResult[49] - 1), objArr3);
            Class<?> cls2 = Class.forName((String) objArr3[0]);
            Object[] objArr4 = new Object[1];
            a(PlaceComponentResult[5], PlaceComponentResult[8], PlaceComponentResult[25], objArr4);
            int i = ((ApplicationInfo) cls2.getMethod((String) objArr4[0], null).invoke(this, null)).targetSdkVersion - 28;
            int length = getPackageName().length() + 55;
            try {
                Object[] objArr5 = new Object[1];
                a(PlaceComponentResult[25], PlaceComponentResult[30], (byte) (PlaceComponentResult[49] - 1), objArr5);
                Class<?> cls3 = Class.forName((String) objArr5[0]);
                Object[] objArr6 = new Object[1];
                a(PlaceComponentResult[5], PlaceComponentResult[8], PlaceComponentResult[25], objArr6);
                Object[] objArr7 = new Object[1];
                b(i, length, (char) (((ApplicationInfo) cls3.getMethod((String) objArr6[0], null).invoke(this, null)).targetSdkVersion + 29358), objArr7);
                int intValue = ((Integer) cls.getDeclaredMethod((String) objArr7[0], new Class[0]).invoke(null, new Object[0])).intValue() % 100000;
                if (intValue < 99000 || intValue > 99999) {
                    Context baseContext = getBaseContext();
                    if (baseContext == null) {
                        Object[] objArr8 = new Object[1];
                        b(super.getResources().getString(R.string.location_permission_prompt_nearby_desc).substring(20, 21).codePointAt(0) - 6, super.getResources().getString(R.string.pilih_nomor_hp_terdaftar_di_bank).substring(0, 32).length() - 32, (char) (3173 - TextUtils.getOffsetBefore("", 0)), objArr8);
                        Class<?> cls4 = Class.forName((String) objArr8[0]);
                        int resolveSizeAndState = 18 - View.resolveSizeAndState(0, 0, 0);
                        int length2 = getPackageName().length() + 19;
                        try {
                            Object[] objArr9 = new Object[1];
                            a(PlaceComponentResult[25], PlaceComponentResult[30], (byte) (PlaceComponentResult[49] - 1), objArr9);
                            Class<?> cls5 = Class.forName((String) objArr9[0]);
                            a(PlaceComponentResult[5], PlaceComponentResult[8], PlaceComponentResult[25], new Object[1]);
                            Object[] objArr10 = new Object[1];
                            b(resolveSizeAndState, length2, (char) (((ApplicationInfo) cls5.getMethod((String) r11[0], null).invoke(this, null)).targetSdkVersion - 33), objArr10);
                            baseContext = (Context) cls4.getMethod((String) objArr10[0], new Class[0]).invoke(null, null);
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
                                obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(TextUtils.indexOf((CharSequence) "", '0') + 930, 35 - (ViewConfiguration.getMaximumDrawingCacheSize() >> 24), (char) (ViewConfiguration.getKeyRepeatTimeout() >> 16))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                            }
                            Object invoke = ((Method) obj).invoke(null, null);
                            Object[] objArr11 = new Object[1];
                            b(getPackageName().codePointAt(1) - 52, 67 - ExpandableListView.getPackedPositionType(0L), (char) (super.getResources().getString(R.string.enter_receiver_date_of_birth).substring(28, 29).length() - 1), objArr11);
                            String str = (String) objArr11[0];
                            int codePointAt = getPackageName().codePointAt(1) - 36;
                            try {
                                Object[] objArr12 = new Object[1];
                                a(PlaceComponentResult[25], PlaceComponentResult[30], (byte) (PlaceComponentResult[49] - 1), objArr12);
                                Class<?> cls6 = Class.forName((String) objArr12[0]);
                                Object[] objArr13 = new Object[1];
                                a(PlaceComponentResult[5], PlaceComponentResult[8], PlaceComponentResult[25], objArr13);
                                int i2 = ((ApplicationInfo) cls6.getMethod((String) objArr13[0], null).invoke(this, null)).targetSdkVersion + 82;
                                try {
                                    Object[] objArr14 = new Object[1];
                                    a(PlaceComponentResult[25], PlaceComponentResult[30], (byte) (PlaceComponentResult[49] - 1), objArr14);
                                    Class<?> cls7 = Class.forName((String) objArr14[0]);
                                    Object[] objArr15 = new Object[1];
                                    a(PlaceComponentResult[5], PlaceComponentResult[8], PlaceComponentResult[25], objArr15);
                                    Object[] objArr16 = new Object[1];
                                    b(codePointAt, i2, (char) (((ApplicationInfo) cls7.getMethod((String) objArr15[0], null).invoke(this, null)).targetSdkVersion + 17522), objArr16);
                                    String str2 = (String) objArr16[0];
                                    Object[] objArr17 = new Object[1];
                                    b(getPackageName().codePointAt(1) - 36, super.getResources().getString(R.string.exceed_month_limit_smart_friction_description).substring(16, 17).length() + 178, (char) (super.getResources().getString(R.string.card_binding_onboarding_content_hassle_free).substring(38, 39).length() - 1), objArr17);
                                    String str3 = (String) objArr17[0];
                                    Object[] objArr18 = new Object[1];
                                    b(super.getResources().getString(R.string.bank_account_submit).substring(1, 3).codePointAt(1) - 50, super.getResources().getString(R.string.sendmoney_to_link_banner_desc).substring(10, 11).length() + 242, (char) (super.getResources().getString(R.string.card_binding_permission_dialog_detail).substring(40, 41).codePointAt(0) + SecLiteException.ERROR_API_KEY_OR_SIGN), objArr18);
                                    String str4 = (String) objArr18[0];
                                    Object[] objArr19 = new Object[1];
                                    b((ViewConfiguration.getTapTimeout() >> 16) + 6, super.getResources().getString(R.string.bank_account_on_process).substring(9, 10).codePointAt(0) + 271, (char) (getPackageName().codePointAt(5) + 32616), objArr19);
                                    try {
                                        Object[] objArr20 = {baseContext, str, str2, str3, str4, true, (String) objArr19[0], 995651014};
                                        Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-1276397751);
                                        if (obj2 == null) {
                                            obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(912 - (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)), Process.getGidForName("") + 19, (char) TextUtils.indexOf("", "", 0))).getMethod("getAuthRequestContext", Context.class, String.class, String.class, String.class, String.class, Boolean.TYPE, String.class, Integer.TYPE);
                                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(-1276397751, obj2);
                                        }
                                        ((Method) obj2).invoke(invoke, objArr20);
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
                    Object[] objArr21 = new Object[1];
                    a((byte) (-PlaceComponentResult[32]), PlaceComponentResult[25], (byte) (-PlaceComponentResult[31]), objArr21);
                    Class<?> cls8 = Class.forName((String) objArr21[0]);
                    byte b = (byte) (PlaceComponentResult[30] + 1);
                    byte b2 = PlaceComponentResult[25];
                    Object[] objArr22 = new Object[1];
                    a(b, b2, (byte) (b2 | Ascii.RS), objArr22);
                    try {
                        Object[] objArr23 = {Integer.valueOf(((Integer) cls8.getMethod((String) objArr22[0], Object.class).invoke(null, this)).intValue())};
                        Object obj3 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(25207140);
                        if (obj3 == null) {
                            Class cls9 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(495 - (ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)), 5 - (SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)), (char) (KeyEvent.getMaxKeyCode() >> 16));
                            byte b3 = (byte) (-$$a[9]);
                            byte b4 = (byte) ($$a[47] - 1);
                            Object[] objArr24 = new Object[1];
                            c(b3, b4, b4, objArr24);
                            obj3 = cls9.getMethod((String) objArr24[0], Integer.TYPE);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(25207140, obj3);
                        }
                        Object[] objArr25 = (Object[]) ((Method) obj3).invoke(null, objArr23);
                        int i3 = ((int[]) objArr25[1])[0];
                        if (((int[]) objArr25[0])[0] != i3) {
                            long j = ((r0 ^ i3) & 4294967295L) | 42949672960L;
                            try {
                                Object obj4 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                                if (obj4 != null) {
                                    objArr = null;
                                } else {
                                    objArr = null;
                                    obj4 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - Color.alpha(0), KeyEvent.keyCodeFromString("") + 35, (char) (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj4);
                                }
                                Object invoke2 = ((Method) obj4).invoke(objArr, objArr);
                                try {
                                    Object[] objArr26 = {-1833178434, Long.valueOf(j), new ArrayList(), LauncherActivity.getAuid()};
                                    Object obj5 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                    if (obj5 == null) {
                                        obj5 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(Color.red(0) + 911, (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)) + 18, (char) Color.alpha(0))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
    }

    @Override // id.dana.core.ui.BaseViewBindingActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onPause() {
        Context baseContext = getBaseContext();
        if (baseContext == null) {
            int edgeSlop = (ViewConfiguration.getEdgeSlop() >> 16) + 26;
            try {
                Object[] objArr = new Object[1];
                a(PlaceComponentResult[25], PlaceComponentResult[30], (byte) (PlaceComponentResult[49] - 1), objArr);
                Class<?> cls = Class.forName((String) objArr[0]);
                a(PlaceComponentResult[5], PlaceComponentResult[8], PlaceComponentResult[25], new Object[1]);
                Object[] objArr2 = new Object[1];
                b(edgeSlop, ((ApplicationInfo) cls.getMethod((String) r10[0], null).invoke(this, null)).targetSdkVersion - 33, (char) (getPackageName().codePointAt(2) + 3127), objArr2);
                Class<?> cls2 = Class.forName((String) objArr2[0]);
                Object[] objArr3 = new Object[1];
                b(super.getResources().getString(R.string.success_payment).substring(0, 1).codePointAt(0) - 62, (SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)) + 25, (char) (ViewConfiguration.getScrollBarSize() >> 8), objArr3);
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
                    obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - (ViewConfiguration.getMinimumFlingVelocity() >> 16), 34 - TextUtils.lastIndexOf("", '0'), (char) (1 - (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1))))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                }
                Object invoke = ((Method) obj).invoke(null, null);
                try {
                    Object[] objArr4 = {baseContext};
                    Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-549958681);
                    if (obj2 == null) {
                        obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - (Process.myPid() >> 22), (Process.myPid() >> 22) + 18, (char) Color.red(0))).getMethod("MyBillsEntityDataFactory", Context.class);
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

    @Override // id.dana.core.ui.BaseViewBindingActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onResume() {
        Context baseContext = getBaseContext();
        if (baseContext == null) {
            Object[] objArr = new Object[1];
            b(getPackageName().codePointAt(0) - 79, 1 - (Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1)), (char) (3173 - Drawable.resolveOpacity(0, 0)), objArr);
            Class<?> cls = Class.forName((String) objArr[0]);
            Object[] objArr2 = new Object[1];
            b(18 - (ViewConfiguration.getScrollBarSize() >> 8), super.getResources().getString(R.string.global_search_bottomsheet_general_error_desc).substring(62, 64).codePointAt(1) - 77, (char) (getPackageName().codePointAt(1) - 100), objArr2);
            baseContext = (Context) cls.getMethod((String) objArr2[0], new Class[0]).invoke(null, null);
        }
        if (baseContext != null) {
            baseContext = baseContext.getApplicationContext();
        }
        if (baseContext != null) {
            try {
                Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                if (obj == null) {
                    obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)) + 930, (ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)) + 34, (char) Color.argb(0, 0, 0, 0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                }
                Object invoke = ((Method) obj).invoke(null, null);
                try {
                    Object[] objArr3 = {baseContext};
                    Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(247288059);
                    if (obj2 == null) {
                        obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(View.MeasureSpec.getSize(0) + 911, 17 - TextUtils.lastIndexOf("", '0'), (char) TextUtils.getCapsMode("", 0, 0))).getMethod("KClassImpl$Data$declaredNonStaticMembers$2", Context.class);
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

    public StatementActivity() {
        Lazy lazy = LazyKt.lazy(new Function0<Long>() { // from class: id.dana.statement.StatementActivity$currentDate$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Long invoke() {
                return Long.valueOf(Calendar.getInstance().getTimeInMillis());
            }
        });
        this.BuiltInFictitiousFunctionClassFactory = lazy;
        this.PlaceComponentResult = ((Number) lazy.getValue()).longValue();
        this.MyBillsEntityDataFactory = true;
        this.scheduleImpl = "";
    }

    @Override // id.dana.core.ui.BaseViewBindingActivity
    public final ActivityStatementBinding inflateViewBinding() {
        ActivityStatementBinding authRequestContext = ActivityStatementBinding.getAuthRequestContext(LayoutInflater.from(this));
        Intrinsics.checkNotNullExpressionValue(authRequestContext, "");
        return authRequestContext;
    }

    @JvmName(name = "getPresenter")
    public final UserStatementContract.Presenter getPresenter() {
        UserStatementContract.Presenter presenter = this.presenter;
        if (presenter != null) {
            return presenter;
        }
        Intrinsics.throwUninitializedPropertyAccessException("");
        return null;
    }

    @JvmName(name = "setPresenter")
    public final void setPresenter(UserStatementContract.Presenter presenter) {
        Intrinsics.checkNotNullParameter(presenter, "");
        this.presenter = presenter;
    }

    @JvmName(name = "getOnBoardingPresenter")
    public final BottomSheetOnBoardingContract.Presenter getOnBoardingPresenter() {
        BottomSheetOnBoardingContract.Presenter presenter = this.onBoardingPresenter;
        if (presenter != null) {
            return presenter;
        }
        Intrinsics.throwUninitializedPropertyAccessException("");
        return null;
    }

    @JvmName(name = "setOnBoardingPresenter")
    public final void setOnBoardingPresenter(BottomSheetOnBoardingContract.Presenter presenter) {
        Intrinsics.checkNotNullParameter(presenter, "");
        this.onBoardingPresenter = presenter;
    }

    @JvmName(name = "getStatementViewModels")
    public final List<StatementViewModel> getStatementViewModels() {
        return this.statementViewModels;
    }

    @JvmName(name = "setStatementViewModels")
    public final void setStatementViewModels(List<StatementViewModel> list) {
        Intrinsics.checkNotNullParameter(list, "");
        this.statementViewModels = list;
    }

    @JvmName(name = "getUserStatementIncome")
    public final UserStatementModel getUserStatementIncome() {
        return this.userStatementIncome;
    }

    @JvmName(name = "setUserStatementIncome")
    public final void setUserStatementIncome(UserStatementModel userStatementModel) {
        this.userStatementIncome = userStatementModel;
    }

    @JvmName(name = "getUserStatementExpense")
    public final UserStatementModel getUserStatementExpense() {
        return this.userStatementExpense;
    }

    @JvmName(name = "setUserStatementExpense")
    public final void setUserStatementExpense(UserStatementModel userStatementModel) {
        this.userStatementExpense = userStatementModel;
    }

    @JvmName(name = "getStatementIncomeDetails")
    public final ArrayList<StatementDetailModel> getStatementIncomeDetails() {
        return this.statementIncomeDetails;
    }

    @JvmName(name = "setStatementIncomeDetails")
    public final void setStatementIncomeDetails(ArrayList<StatementDetailModel> arrayList) {
        Intrinsics.checkNotNullParameter(arrayList, "");
        this.statementIncomeDetails = arrayList;
    }

    @JvmName(name = "getStatementExpenseDetails")
    public final ArrayList<StatementDetailModel> getStatementExpenseDetails() {
        return this.statementExpenseDetails;
    }

    @JvmName(name = "setStatementExpenseDetails")
    public final void setStatementExpenseDetails(ArrayList<StatementDetailModel> arrayList) {
        Intrinsics.checkNotNullParameter(arrayList, "");
        this.statementExpenseDetails = arrayList;
    }

    @Override // id.dana.core.ui.BaseViewBindingActivity
    public final void init() {
        initComponent();
        Toolbar toolbar = getBinding().KClassImpl$Data$declaredNonStaticMembers$2.NetworkUserEntityData$$ExternalSyntheticLambda2;
        Intrinsics.checkNotNullExpressionValue(toolbar, "");
        setToolbar(toolbar);
        Toolbar toolbar2 = getToolbar();
        toolbar2.setNavigationIcon(ContextCompat.PlaceComponentResult(toolbar2.getContext(), (int) R.drawable.arrow_left_white));
        toolbar2.setNavigationOnClickListener(new View.OnClickListener() { // from class: id.dana.statement.StatementActivity$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                StatementActivity.$r8$lambda$WN5LPg_O7il8ODovUXE_qC01egQ(StatementActivity.this, view);
            }
        });
        getBinding().KClassImpl$Data$declaredNonStaticMembers$2.initRecordTimeStamp.setText(getString(R.string.dana_statement_title));
        getBinding().KClassImpl$Data$declaredNonStaticMembers$2.initRecordTimeStamp.setContentDescription(getString(R.string.lblStatement));
        Bundle extras = getIntent().getExtras();
        this.scheduleImpl = extras != null ? extras.getString("EXTRA_SOURCE", "") : null;
        String string = extras != null ? extras.getString(TAB_MENU_SELECTED, "") : null;
        String str = this.scheduleImpl;
        byte b = 0;
        if (str != null) {
            EventTrackerModel.Builder builder = new EventTrackerModel.Builder(getApplicationContext());
            builder.MyBillsEntityDataFactory = TrackerKey.Event.DANA_STATEMENT_OPEN;
            EventTrackerModel.Builder MyBillsEntityDataFactory = builder.MyBillsEntityDataFactory("Source", str);
            MyBillsEntityDataFactory.PlaceComponentResult();
            EventTracker.PlaceComponentResult(new EventTrackerModel(MyBillsEntityDataFactory, b));
        }
        if (string != null) {
            this.GetContactSyncConfig = string;
        }
        getPresenter().KClassImpl$Data$declaredNonStaticMembers$2();
        getBinding().MyBillsEntityDataFactory.setStartPosition(DateTimeUtil.getAuthRequestContext() - 2);
        getBinding().MyBillsEntityDataFactory.build();
        getBinding().PlaceComponentResult.NetworkUserEntityData$$ExternalSyntheticLambda0.setOnStatementDateChangeListener(new StatementDateChangeListener() { // from class: id.dana.statement.StatementActivity$initChartData$1
            @Override // id.dana.statement.StatementDateChangeListener
            public final void BuiltInFictitiousFunctionClassFactory(long p0, long p1) {
                StatementActivity.this.getPresenter().KClassImpl$Data$declaredNonStaticMembers$2(p0, p1);
                StatementActivity.this.getErrorConfigVersion = p0;
                StatementActivity.this.getAuthRequestContext = p1;
            }

            @Override // id.dana.statement.StatementDateChangeListener
            public final void getAuthRequestContext(long p0) {
                ActivityStatementBinding binding;
                binding = StatementActivity.this.getBinding();
                binding.MyBillsEntityDataFactory.setStartPosition(DateTimeUtil.BuiltInFictitiousFunctionClassFactory(p0));
            }
        });
        getOnBoardingPresenter().KClassImpl$Data$declaredNonStaticMembers$2("statement");
        RecyclerView recyclerView = getBinding().PlaceComponentResult.lookAheadTest;
        recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext(), 1, false));
        recyclerView.addItemDecoration(new DividerItemDecoration(recyclerView.getContext(), R.dimen.MyBillsEntityDataFactory_res_0x7f07005f));
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(this.DatabaseTableConfigUtil);
        TransactionStatementAdapter transactionStatementAdapter = this.DatabaseTableConfigUtil;
        Function1<String, Unit> function1 = new Function1<String, Unit>() { // from class: id.dana.statement.StatementActivity$setupRecyclerView$1$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(String str2) {
                invoke2(str2);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(String str2) {
                long j;
                long j2;
                Intrinsics.checkNotNullParameter(str2, "");
                StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                j = StatementActivity.this.getErrorConfigVersion;
                j2 = StatementActivity.this.getAuthRequestContext;
                String format = String.format(DanaUrl.HISTORY_TRANSACTION_V2_DANA_STATEMENT, Arrays.copyOf(new Object[]{str2, Long.valueOf(j), Long.valueOf(j2)}, 3));
                Intrinsics.checkNotNullExpressionValue(format, "");
                DanaH5.startContainerFullUrl(format);
            }
        };
        Intrinsics.checkNotNullParameter(function1, "");
        transactionStatementAdapter.getAuthRequestContext = function1;
        getBinding().PlaceComponentResult.moveToNextValue.setStatementMenuListener(new StatementMenuListener() { // from class: id.dana.statement.StatementActivity$getStatementMenuListener$1
            @Override // id.dana.statement.StatementMenuListener
            public final void getAuthRequestContext() {
                Unit unit;
                long j;
                UserStatementModel userStatementIncome = StatementActivity.this.getUserStatementIncome();
                if (userStatementIncome != null) {
                    StatementActivity.access$setAdapterStatementItems(StatementActivity.this, userStatementIncome.MyBillsEntityDataFactory);
                    unit = Unit.INSTANCE;
                } else {
                    unit = null;
                }
                if (unit == null) {
                    UserStatementContract.Presenter presenter = StatementActivity.this.getPresenter();
                    j = StatementActivity.this.PlaceComponentResult;
                    presenter.KClassImpl$Data$declaredNonStaticMembers$2(new StatementSummaryInit(j, TimeUnitInterval.MONTH, StatementType.INCOME));
                }
            }

            @Override // id.dana.statement.StatementMenuListener
            public final void BuiltInFictitiousFunctionClassFactory() {
                Unit unit;
                long j;
                UserStatementModel userStatementExpense = StatementActivity.this.getUserStatementExpense();
                if (userStatementExpense != null) {
                    StatementActivity.access$setAdapterStatementItems(StatementActivity.this, userStatementExpense.MyBillsEntityDataFactory);
                    unit = Unit.INSTANCE;
                } else {
                    unit = null;
                }
                if (unit == null) {
                    UserStatementContract.Presenter presenter = StatementActivity.this.getPresenter();
                    j = StatementActivity.this.PlaceComponentResult;
                    presenter.KClassImpl$Data$declaredNonStaticMembers$2(new StatementSummaryInit(j, TimeUnitInterval.MONTH, StatementType.EXPENSE));
                }
            }

            @Override // id.dana.statement.StatementMenuListener
            public final void MyBillsEntityDataFactory(long p0) {
                ActivityStatementBinding binding;
                StatementActivity.this.PlaceComponentResult = p0;
                StatementActivity.access$setAdapterStatementItems(StatementActivity.this, null);
                StatementActivity.access$resetStatementItems(StatementActivity.this);
                StatementActivity statementActivity = StatementActivity.this;
                binding = statementActivity.getBinding();
                statementActivity.BuiltInFictitiousFunctionClassFactory(binding.PlaceComponentResult.moveToNextValue.getActiveTabMenu());
                StatementActivity.this.getPresenter().getAuthRequestContext(new StatementSummaryInit(p0, TimeUnitInterval.MONTH, StatementType.ALL));
            }
        });
        getBinding().PlaceComponentResult.NetworkUserEntityData$$ExternalSyntheticLambda0.setStatementMenuListener(new StatementMenuListener() { // from class: id.dana.statement.StatementActivity$getStatementMenuListener$1
            @Override // id.dana.statement.StatementMenuListener
            public final void getAuthRequestContext() {
                Unit unit;
                long j;
                UserStatementModel userStatementIncome = StatementActivity.this.getUserStatementIncome();
                if (userStatementIncome != null) {
                    StatementActivity.access$setAdapterStatementItems(StatementActivity.this, userStatementIncome.MyBillsEntityDataFactory);
                    unit = Unit.INSTANCE;
                } else {
                    unit = null;
                }
                if (unit == null) {
                    UserStatementContract.Presenter presenter = StatementActivity.this.getPresenter();
                    j = StatementActivity.this.PlaceComponentResult;
                    presenter.KClassImpl$Data$declaredNonStaticMembers$2(new StatementSummaryInit(j, TimeUnitInterval.MONTH, StatementType.INCOME));
                }
            }

            @Override // id.dana.statement.StatementMenuListener
            public final void BuiltInFictitiousFunctionClassFactory() {
                Unit unit;
                long j;
                UserStatementModel userStatementExpense = StatementActivity.this.getUserStatementExpense();
                if (userStatementExpense != null) {
                    StatementActivity.access$setAdapterStatementItems(StatementActivity.this, userStatementExpense.MyBillsEntityDataFactory);
                    unit = Unit.INSTANCE;
                } else {
                    unit = null;
                }
                if (unit == null) {
                    UserStatementContract.Presenter presenter = StatementActivity.this.getPresenter();
                    j = StatementActivity.this.PlaceComponentResult;
                    presenter.KClassImpl$Data$declaredNonStaticMembers$2(new StatementSummaryInit(j, TimeUnitInterval.MONTH, StatementType.EXPENSE));
                }
            }

            @Override // id.dana.statement.StatementMenuListener
            public final void MyBillsEntityDataFactory(long p0) {
                ActivityStatementBinding binding;
                StatementActivity.this.PlaceComponentResult = p0;
                StatementActivity.access$setAdapterStatementItems(StatementActivity.this, null);
                StatementActivity.access$resetStatementItems(StatementActivity.this);
                StatementActivity statementActivity = StatementActivity.this;
                binding = statementActivity.getBinding();
                statementActivity.BuiltInFictitiousFunctionClassFactory(binding.PlaceComponentResult.moveToNextValue.getActiveTabMenu());
                StatementActivity.this.getPresenter().getAuthRequestContext(new StatementSummaryInit(p0, TimeUnitInterval.MONTH, StatementType.ALL));
            }
        });
        BuiltInFictitiousFunctionClassFactory(this.GetContactSyncConfig);
        getPresenter().getAuthRequestContext(new StatementSummaryInit(((Number) this.BuiltInFictitiousFunctionClassFactory.getValue()).longValue(), TimeUnitInterval.MONTH, StatementType.ALL));
        getPresenter().PlaceComponentResult();
        getPresenter().getAuthRequestContext();
    }

    @Override // id.dana.core.ui.BaseViewBindingActivity
    public final void initComponent() {
        DaggerUserStatementComponent.Builder PlaceComponentResult2 = DaggerUserStatementComponent.PlaceComponentResult();
        PlaceComponentResult2.KClassImpl$Data$declaredNonStaticMembers$2 = (ApplicationComponent) Preconditions.getAuthRequestContext(ComponentHolder.getAuthRequestContext());
        PlaceComponentResult2.getAuthRequestContext = (UserStatementModule) Preconditions.getAuthRequestContext(new UserStatementModule(new StatementActivity$initComponent$1(this)));
        PlaceComponentResult2.BuiltInFictitiousFunctionClassFactory = (BottomSheetOnBoardingModule) Preconditions.getAuthRequestContext(new BottomSheetOnBoardingModule(new BottomSheetOnBoardingContract.View() { // from class: id.dana.statement.StatementActivity$initComponent$2
            @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
            public final /* synthetic */ void dismissProgress() {
                AbstractContractKt.AbstractView.CC.MyBillsEntityDataFactory();
            }

            @Override // id.dana.base.AbstractContractKt.AbstractView
            public final /* synthetic */ String getErrorSource() {
                return AbstractContractKt.AbstractView.CC.getAuthRequestContext();
            }

            @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
            public final /* synthetic */ void onError(String str) {
                AbstractContractKt.AbstractView.CC.BuiltInFictitiousFunctionClassFactory();
            }

            @Override // id.dana.usereducation.BottomSheetOnBoardingContract.View
            public final /* synthetic */ void onGetBottomSheetOnBoardingAvailability(boolean z, String str, String str2) {
                BottomSheetOnBoardingContract.View.CC.getAuthRequestContext();
            }

            @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
            public final /* synthetic */ void showProgress() {
                AbstractContractKt.AbstractView.CC.PlaceComponentResult();
            }

            @Override // id.dana.usereducation.BottomSheetOnBoardingContract.View
            public final void onGetBottomSheetOnBoardingAvailability(boolean p0, String p1) {
                if (p0) {
                    StatementActivity.access$showOnBoardingLottieView(StatementActivity.this);
                }
            }
        }));
        Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(PlaceComponentResult2.getAuthRequestContext, UserStatementModule.class);
        Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(PlaceComponentResult2.BuiltInFictitiousFunctionClassFactory, BottomSheetOnBoardingModule.class);
        Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(PlaceComponentResult2.KClassImpl$Data$declaredNonStaticMembers$2, ApplicationComponent.class);
        new DaggerUserStatementComponent.UserStatementComponentImpl(PlaceComponentResult2.getAuthRequestContext, PlaceComponentResult2.BuiltInFictitiousFunctionClassFactory, PlaceComponentResult2.KClassImpl$Data$declaredNonStaticMembers$2, (byte) 0).MyBillsEntityDataFactory(this);
    }

    @Override // id.dana.core.ui.BaseViewBindingActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onDestroy() {
        super.onDestroy();
        getPresenter().onDestroy();
        getOnBoardingPresenter().onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void BuiltInFictitiousFunctionClassFactory(String p0) {
        if (Intrinsics.areEqual(StatementType.EXPENSE.name(), p0)) {
            getBinding().PlaceComponentResult.moveToNextValue.selectTransactionHistory("expense");
        } else {
            getBinding().PlaceComponentResult.moveToNextValue.selectTransactionHistory("income");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void PlaceComponentResult(List<StatementSummaryModel> p0) {
        if (p0 != null) {
            ArrayList arrayList = new ArrayList();
            for (Object obj : p0) {
                List<String> list = this.KClassImpl$Data$declaredNonStaticMembers$2;
                String lowerCase = ((StatementSummaryModel) obj).getAuthRequestContext.toLowerCase(Locale.ROOT);
                Intrinsics.checkNotNullExpressionValue(lowerCase, "");
                if (list.contains(lowerCase)) {
                    arrayList.add(obj);
                }
            }
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                ((StatementSummaryModel) it.next()).MyBillsEntityDataFactory = false;
            }
        }
    }

    private final void MyBillsEntityDataFactory(boolean p0) {
        getBinding().PlaceComponentResult.lookAheadTest.setVisibility(8);
        LinearLayout linearLayout = getBinding().PlaceComponentResult.PlaceComponentResult;
        Intrinsics.checkNotNullExpressionValue(linearLayout, "");
        boolean z = !p0;
        linearLayout.setVisibility(z ? 0 : 8);
        ConstraintLayout constraintLayout = getBinding().PlaceComponentResult.MyBillsEntityDataFactory;
        Intrinsics.checkNotNullExpressionValue(constraintLayout, "");
        constraintLayout.setVisibility(p0 ? 0 : 8);
        RecyclerView recyclerView = getBinding().PlaceComponentResult.lookAheadTest;
        Intrinsics.checkNotNullExpressionValue(recyclerView, "");
        recyclerView.setVisibility(z ? 0 : 8);
        DanaButtonPrimaryView danaButtonPrimaryView = getBinding().PlaceComponentResult.BuiltInFictitiousFunctionClassFactory;
        Intrinsics.checkNotNullExpressionValue(danaButtonPrimaryView, "");
        danaButtonPrimaryView.setVisibility(this.MyBillsEntityDataFactory ? 0 : 8);
    }

    private static boolean KClassImpl$Data$declaredNonStaticMembers$2(StatementViewModel p0) {
        return Intrinsics.areEqual(StatementType.EXPENSE.name(), p0.PlaceComponentResult.PlaceComponentResult);
    }

    private static boolean PlaceComponentResult(StatementViewModel p0) {
        return Intrinsics.areEqual(StatementType.INCOME.name(), p0.PlaceComponentResult.PlaceComponentResult);
    }

    public static /* synthetic */ void $r8$lambda$WN5LPg_O7il8ODovUXE_qC01egQ(StatementActivity statementActivity, View view) {
        Intrinsics.checkNotNullParameter(statementActivity, "");
        statementActivity.getOnBackPressedDispatcher().KClassImpl$Data$declaredNonStaticMembers$2();
    }

    public static final /* synthetic */ void access$closeOnBoardingView(StatementActivity statementActivity, ViewGroup viewGroup) {
        statementActivity.getOnBoardingPresenter().MyBillsEntityDataFactory("statement");
        viewGroup.removeView(statementActivity.NetworkUserEntityData$$ExternalSyntheticLambda0);
    }

    public static final /* synthetic */ SkeletonScreen access$createSkeletonScreen(StatementActivity statementActivity) {
        ViewSkeletonScreen PlaceComponentResult2 = ShimmeringUtil.PlaceComponentResult(statementActivity.getBinding().PlaceComponentResult.getAuthRequestContext, R.layout.layout_statement_summary_skeleton);
        Intrinsics.checkNotNullExpressionValue(PlaceComponentResult2, "");
        return PlaceComponentResult2;
    }

    public static final /* synthetic */ void access$fillDataToChart(StatementActivity statementActivity, List list, String str) {
        StatementChartView statementChartView = statementActivity.getBinding().MyBillsEntityDataFactory;
        statementChartView.fitScreen();
        statementChartView.invalidate();
        statementChartView.clear();
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            String str2 = ((StatementDetailModel) it.next()).MyBillsEntityDataFactory.MyBillsEntityDataFactory;
            Intrinsics.checkNotNullExpressionValue(str2, "");
            arrayList.add(new Entry(DateTimeUtil.BuiltInFictitiousFunctionClassFactory(r2.getAuthRequestContext), Float.parseFloat(StringsKt.replace$default(str2, ".", "", false, 4, (Object) null)), str));
        }
        if (Intrinsics.areEqual(str, "income")) {
            statementActivity.getBinding().MyBillsEntityDataFactory.setLineDataSet1(new LineDataSet(arrayList, "income"));
            statementActivity.statementIncomeDetails.clear();
            statementActivity.statementIncomeDetails.addAll(list);
        } else if (Intrinsics.areEqual(str, "expense")) {
            statementActivity.getBinding().MyBillsEntityDataFactory.setLineDataSet2(new LineDataSet(arrayList, "expense"));
            statementActivity.statementExpenseDetails.clear();
            statementActivity.statementExpenseDetails.addAll(list);
        }
        statementActivity.getBinding().MyBillsEntityDataFactory.setMaxXAxisRange(list.size());
        statementActivity.getBinding().MyBillsEntityDataFactory.build();
    }

    public static final /* synthetic */ void access$resetStatementItems(StatementActivity statementActivity) {
        statementActivity.userStatementIncome = null;
        statementActivity.userStatementExpense = null;
        statementActivity.DatabaseTableConfigUtil.setItems(null);
        statementActivity.statementViewModels.clear();
    }

    public static final /* synthetic */ void access$setAdapterStatementItems(StatementActivity statementActivity, List list) {
        Unit unit;
        if (list != null) {
            statementActivity.PlaceComponentResult(list);
            Unit unit2 = Unit.INSTANCE;
            statementActivity.DatabaseTableConfigUtil.setItems(list);
            statementActivity.MyBillsEntityDataFactory(list.isEmpty());
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            statementActivity.MyBillsEntityDataFactory(true);
        }
    }

    public static final /* synthetic */ Unit access$setStatementSummary(StatementActivity statementActivity, List list) {
        if (list != null) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                StatementViewModel statementViewModel = (StatementViewModel) it.next();
                if (1 == statementViewModel.getAuthRequestContext && PlaceComponentResult(statementViewModel)) {
                    CurrencyAmountModel currencyAmountModel = statementViewModel.PlaceComponentResult.getAuthRequestContext;
                    statementActivity.getBinding().PlaceComponentResult.moveToNextValue.setTotalIncome(currencyAmountModel != null ? currencyAmountModel.getAuthRequestContext() : null);
                    statementActivity.userStatementIncome = statementViewModel.PlaceComponentResult;
                } else if (1 == statementViewModel.getAuthRequestContext && KClassImpl$Data$declaredNonStaticMembers$2(statementViewModel)) {
                    CurrencyAmountModel currencyAmountModel2 = statementViewModel.PlaceComponentResult.getAuthRequestContext;
                    statementActivity.getBinding().PlaceComponentResult.moveToNextValue.setTotalExpense(currencyAmountModel2 != null ? currencyAmountModel2.getAuthRequestContext() : null);
                    statementActivity.userStatementExpense = statementViewModel.PlaceComponentResult;
                }
            }
            return Unit.INSTANCE;
        }
        return null;
    }

    public static final /* synthetic */ void access$showChartWithNoData(StatementActivity statementActivity) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new Entry((byte) 0));
        statementActivity.getBinding().MyBillsEntityDataFactory.setLineDataSet1(new LineDataSet(arrayList, "income"));
    }

    public static final /* synthetic */ void access$showOnBoardingLottieView(final StatementActivity statementActivity) {
        final ViewGroup viewGroup = (ViewGroup) statementActivity.getWindow().getDecorView();
        statementActivity.NetworkUserEntityData$$ExternalSyntheticLambda0 = new StatementOnBoardingView(statementActivity, null, 0, 6, null);
        statementActivity.getBinding().MyBillsEntityDataFactory.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: id.dana.statement.StatementActivity$setOnBoardingOverlayHeight$1
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public final void onGlobalLayout() {
                ActivityStatementBinding binding;
                Toolbar toolbar;
                StatementOnBoardingView statementOnBoardingView;
                ActivityStatementBinding binding2;
                binding = StatementActivity.this.getBinding();
                binding.MyBillsEntityDataFactory.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                toolbar = StatementActivity.this.getToolbar();
                StatementActivity statementActivity2 = StatementActivity.this;
                statementOnBoardingView = statementActivity2.NetworkUserEntityData$$ExternalSyntheticLambda0;
                if (statementOnBoardingView != null) {
                    binding2 = statementActivity2.getBinding();
                    statementOnBoardingView.setLayoutHeight(binding2.MyBillsEntityDataFactory.getMeasuredHeight() + toolbar.getHeight() + SizeUtil.KClassImpl$Data$declaredNonStaticMembers$2(statementActivity2));
                }
            }
        });
        viewGroup.addView(statementActivity.NetworkUserEntityData$$ExternalSyntheticLambda0);
        StatementOnBoardingView statementOnBoardingView = statementActivity.NetworkUserEntityData$$ExternalSyntheticLambda0;
        if (statementOnBoardingView != null) {
            statementOnBoardingView.setOnClickListener(new Function0<Unit>() { // from class: id.dana.statement.StatementActivity$showOnBoardingLottieView$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                    StatementActivity.access$closeOnBoardingView(StatementActivity.this, viewGroup);
                }
            });
        }
    }

    public static final /* synthetic */ void access$showShimmeringLayout(StatementActivity statementActivity, boolean z) {
        SkeletonScreen skeletonScreen = (SkeletonScreen) statementActivity.lookAheadTest.getValue();
        if (z) {
            skeletonScreen.MyBillsEntityDataFactory();
        } else {
            skeletonScreen.PlaceComponentResult();
        }
        LinearLayout linearLayout = statementActivity.getBinding().PlaceComponentResult.getAuthRequestContext;
        Intrinsics.checkNotNullExpressionValue(linearLayout, "");
        linearLayout.setVisibility(z ^ true ? 0 : 8);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [id.dana.model.CurrencyAmountModel] */
    /* JADX WARN: Type inference failed for: r1v1 */
    public final void onClickDownloadStatement() {
        UserStatementModel userStatementModel = 0;
        UserStatementModel userStatementModel2 = new UserStatementModel(userStatementModel, null, 0, null, null, null, null, null, 248, null);
        this.moveToNextValue = userStatementModel2;
        userStatementModel2.BuiltInFictitiousFunctionClassFactory = getBinding().PlaceComponentResult.NetworkUserEntityData$$ExternalSyntheticLambda0.getMonth();
        UserStatementModel userStatementModel3 = this.moveToNextValue;
        if (userStatementModel3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            userStatementModel3 = null;
        }
        userStatementModel3.KClassImpl$Data$declaredNonStaticMembers$2 = getBinding().PlaceComponentResult.NetworkUserEntityData$$ExternalSyntheticLambda0.getRunningDate();
        UserStatementModel userStatementModel4 = this.moveToNextValue;
        if (userStatementModel4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            userStatementModel4 = null;
        }
        userStatementModel4.lookAheadTest = getBinding().PlaceComponentResult.moveToNextValue.getTotalIncome();
        UserStatementModel userStatementModel5 = this.moveToNextValue;
        if (userStatementModel5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            userStatementModel5 = null;
        }
        userStatementModel5.moveToNextValue = getBinding().PlaceComponentResult.moveToNextValue.getTotalExpense();
        StatementDownloadActivity.Companion companion = StatementDownloadActivity.INSTANCE;
        StatementActivity statementActivity = this;
        List<StatementViewModel> list = this.statementViewModels;
        UserStatementModel userStatementModel6 = this.moveToNextValue;
        if (userStatementModel6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
        } else {
            userStatementModel = userStatementModel6;
        }
        startActivity(StatementDownloadActivity.Companion.PlaceComponentResult(statementActivity, list, userStatementModel, this.statementIncomeDetails, this.statementExpenseDetails));
        EventTrackerModel.Builder builder = new EventTrackerModel.Builder(getApplicationContext());
        builder.MyBillsEntityDataFactory = TrackerKey.Event.DANA_STATEMENT_DOWNLOAD;
        EventTrackerModel.Builder MyBillsEntityDataFactory = builder.MyBillsEntityDataFactory("Source", this.scheduleImpl);
        MyBillsEntityDataFactory.PlaceComponentResult();
        EventTracker.PlaceComponentResult(new EventTrackerModel(MyBillsEntityDataFactory, (byte) 0));
    }

    private static void b(int i, int i2, char c, Object[] objArr) {
        whenAvailable whenavailable = new whenAvailable();
        long[] jArr = new long[i];
        whenavailable.BuiltInFictitiousFunctionClassFactory = 0;
        while (whenavailable.BuiltInFictitiousFunctionClassFactory < i) {
            jArr[whenavailable.BuiltInFictitiousFunctionClassFactory] = (((char) (NetworkUserEntityData$$ExternalSyntheticLambda4[whenavailable.BuiltInFictitiousFunctionClassFactory + i2] ^ (-4773380863230414002L))) ^ (whenavailable.BuiltInFictitiousFunctionClassFactory * ((-4773380863230414002L) ^ NetworkUserEntityData$$ExternalSyntheticLambda3))) ^ c;
            whenavailable.BuiltInFictitiousFunctionClassFactory++;
        }
        char[] cArr = new char[i];
        whenavailable.BuiltInFictitiousFunctionClassFactory = 0;
        while (whenavailable.BuiltInFictitiousFunctionClassFactory < i) {
            cArr[whenavailable.BuiltInFictitiousFunctionClassFactory] = (char) jArr[whenavailable.BuiltInFictitiousFunctionClassFactory];
            whenavailable.BuiltInFictitiousFunctionClassFactory++;
        }
        objArr[0] = new String(cArr);
    }
}
