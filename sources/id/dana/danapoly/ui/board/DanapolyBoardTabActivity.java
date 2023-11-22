package id.dana.danapoly.ui.board;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.PointF;
import android.graphics.drawable.ColorDrawable;
import android.media.AudioTrack;
import android.os.Bundle;
import android.os.Process;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ExpandableListView;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.Group;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.view.ComponentActivity;
import androidx.view.FlowExtKt;
import androidx.view.Lifecycle;
import androidx.view.LifecycleOwnerKt;
import androidx.view.ViewModelKt;
import androidx.view.ViewModelLazy;
import androidx.view.ViewModelProvider;
import androidx.view.ViewModelStore;
import androidx.view.viewmodel.CreationExtras;
import com.afollestad.materialdialogs.MaterialDialog;
import com.afollestad.materialdialogs.internal.main.DialogLayout;
import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.alibaba.wireless.security.SecExceptionCode;
import com.alipay.iap.android.common.syncintegration.api.IAPSyncCommand;
import com.fullstory.instrumentation.InstrumentInjector;
import com.google.android.material.imageview.ShapeableImageView;
import com.google.android.material.tabs.TabLayout;
import com.google.common.base.Ascii;
import com.google.zxing.pdf417.PDF417Common;
import id.dana.analytics.tracker.AnalyticsTracker;
import id.dana.component.dialogcomponent.CustomDialog;
import id.dana.component.dialogcomponent.CustomDialog$sam$android_view_View_OnClickListener$0;
import id.dana.core.ui.BaseViewBindingFragment;
import id.dana.core.ui.di.module.ViewModelFactory;
import id.dana.core.ui.richview.DefaultNavigationTabView;
import id.dana.core.ui.showcase.AbstractOnShowcaseStateListener;
import id.dana.core.ui.showcase.Content;
import id.dana.core.ui.showcase.Showcase;
import id.dana.core.ui.showcase.SimpleShowcaseBuilder;
import id.dana.core.ui.showcase.shape.CircleShape;
import id.dana.core.ui.showcase.target.Target;
import id.dana.core.ui.showcase.target.TargetBuilder;
import id.dana.core.ui.util.LocaleUtil;
import id.dana.danapoly.R;
import id.dana.danapoly.databinding.ActivityDanapolyBoardBinding;
import id.dana.danapoly.di.component.DanapolyComponent;
import id.dana.danapoly.di.provider.DanapolyComponentProvider;
import id.dana.danapoly.ui.board.DanapolyBoardTabActivity;
import id.dana.danapoly.ui.board.view.DanapolyLapCountView;
import id.dana.danapoly.ui.board.view.DanapolyNavTabView;
import id.dana.danapoly.ui.board.viewmodel.DanapolyBoardUiState;
import id.dana.danapoly.ui.board.viewmodel.DanapolyBoardViewModel;
import id.dana.danapoly.ui.cards.CardsListFragment;
import id.dana.danapoly.ui.leaderboard.LeaderboardFragment;
import id.dana.danapoly.ui.model.DanapolyDeeplinkModel;
import id.dana.danapoly.ui.model.PlayBoardModel;
import id.dana.danapoly.ui.splash.DanapolySplashActivity;
import id.dana.danapoly.ui.tracker.DanapolyEvents;
import id.dana.danapoly.ui.tracker.DanapolyMixpanelTracker;
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
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.StateFlow;
import o.SummaryVoucherView$$ExternalSyntheticLambda0;
import o.VerifyPinStateManager$executeRiskChallenge$2$2;

@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 N2\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0002NOB\u0007¢\u0006\u0004\bM\u0010\u0006J\u000f\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\r\u0010\u0007\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\u0006J\u0017\u0010\n\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\f\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\f\u0010\u000bJ\u000f\u0010\r\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u000f\u0010\u0006J\u000f\u0010\u0010\u001a\u00020\u0004H\u0014¢\u0006\u0004\b\u0010\u0010\u0006J\u000f\u0010\u0011\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0011\u0010\u0006J\u000f\u0010\u0012\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0012\u0010\u0006J\u0017\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\bH\u0002¢\u0006\u0004\b\u0014\u0010\u000bJ\u0015\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\b¢\u0006\u0004\b\u0016\u0010\u000bJ#\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u00172\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00040\u0019¢\u0006\u0004\b\u001b\u0010\u001cJ'\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u001d2\u000e\u0010 \u001a\n\u0012\u0006\b\u0001\u0012\u00020\u001f0\u001eH\u0002¢\u0006\u0004\b\u0014\u0010!R\u0016\u0010$\u001a\u00020\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\"\u0010#R\"\u0010)\u001a\u00020\b8\u0017@\u0017X\u0096\u000e¢\u0006\u0012\n\u0004\b%\u0010#\u001a\u0004\b&\u0010'\"\u0004\b(\u0010\u000bR\u0018\u0010\u0005\u001a\u0004\u0018\u00010*8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b+\u0010,R\u0016\u0010\u0014\u001a\u00020\u001d8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b-\u0010.R\"\u00100\u001a\u00020/8\u0007@\u0007X\u0087.¢\u0006\u0012\n\u0004\b0\u00101\u001a\u0004\b2\u00103\"\u0004\b4\u00105R\u0016\u00107\u001a\u00020\b8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b6\u0010#R\u0018\u0010;\u001a\u0004\u0018\u0001088\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b9\u0010:R\"\u0010=\u001a\u00020<8\u0007@\u0007X\u0087.¢\u0006\u0012\n\u0004\b=\u0010>\u001a\u0004\b?\u0010@\"\u0004\bA\u0010BR\u0013\u0010\"\u001a\u00020CX\u0083\u0080\u0002¢\u0006\u0006\n\u0004\bD\u0010ER\"\u0010G\u001a\u00020F8\u0007@\u0007X\u0087.¢\u0006\u0012\n\u0004\bG\u0010H\u001a\u0004\bI\u0010J\"\u0004\bK\u0010L"}, d2 = {"Lid/dana/danapoly/ui/board/DanapolyBoardTabActivity;", "Lid/dana/danapoly/ui/board/BaseDanapolyAudioActivity;", "Lid/dana/danapoly/databinding/ActivityDanapolyBoardBinding;", "Lid/dana/danapoly/ui/board/DanapolyBoardListener;", "", "MyBillsEntityDataFactory", "()V", "checkExtraForDareNotification", "", "enable", "enableBoardInteraction", "(Z)V", "enableDice", "inflateViewBinding", "()Lid/dana/danapoly/databinding/ActivityDanapolyBoardBinding;", IAPSyncCommand.COMMAND_INIT, "initComponent", "onBackToBoardPage", "onClickRollDicePopupAction", "p0", "BuiltInFictitiousFunctionClassFactory", "isVisible", "renderTabLayout", "", "lapCount", "Lkotlin/Function0;", "onAnimationEnd", "showLapCount", "(ILkotlin/jvm/functions/Function0;)V", "Lid/dana/danapoly/ui/board/DanapolyBoardTabActivity$DanapolyTabs;", "Ljava/lang/Class;", "Landroidx/fragment/app/Fragment;", "p1", "(Lid/dana/danapoly/ui/board/DanapolyBoardTabActivity$DanapolyTabs;Ljava/lang/Class;)V", "getErrorConfigVersion", "Z", "KClassImpl$Data$declaredNonStaticMembers$2", "scheduleImpl", "getCardPromptShown", "()Z", "setCardPromptShown", "cardPromptShown", "Lcom/afollestad/materialdialogs/MaterialDialog;", "initRecordTimeStamp", "Lcom/afollestad/materialdialogs/MaterialDialog;", "NetworkUserEntityData$$ExternalSyntheticLambda1", "Lid/dana/danapoly/ui/board/DanapolyBoardTabActivity$DanapolyTabs;", "Lid/dana/danapoly/di/component/DanapolyComponent;", "danapolyComponent", "Lid/dana/danapoly/di/component/DanapolyComponent;", "getDanapolyComponent", "()Lid/dana/danapoly/di/component/DanapolyComponent;", "setDanapolyComponent", "(Lid/dana/danapoly/di/component/DanapolyComponent;)V", "GetContactSyncConfig", "getAuthRequestContext", "Lid/dana/core/ui/showcase/Showcase;", "DatabaseTableConfigUtil", "Lid/dana/core/ui/showcase/Showcase;", "PlaceComponentResult", "Lid/dana/danapoly/ui/tracker/DanapolyMixpanelTracker;", "tracker", "Lid/dana/danapoly/ui/tracker/DanapolyMixpanelTracker;", "getTracker", "()Lid/dana/danapoly/ui/tracker/DanapolyMixpanelTracker;", "setTracker", "(Lid/dana/danapoly/ui/tracker/DanapolyMixpanelTracker;)V", "Lid/dana/danapoly/ui/board/viewmodel/DanapolyBoardViewModel;", "NetworkUserEntityData$$ExternalSyntheticLambda2", "Lkotlin/Lazy;", "Lid/dana/core/ui/di/module/ViewModelFactory;", "viewModelFactory", "Lid/dana/core/ui/di/module/ViewModelFactory;", "getViewModelFactory", "()Lid/dana/core/ui/di/module/ViewModelFactory;", "setViewModelFactory", "(Lid/dana/core/ui/di/module/ViewModelFactory;)V", "<init>", "Companion", "DanapolyTabs"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class DanapolyBoardTabActivity extends BaseDanapolyAudioActivity<ActivityDanapolyBoardBinding> implements DanapolyBoardListener {
    public static final String BUNDLE_PLAY_BOARD = "bundle_play_board";
    public static final String BUNDLE_TO_LEADERBOARD = "bundle_to_leaderboard";

    /* renamed from: Companion  reason: from kotlin metadata */
    public static final Companion INSTANCE;
    private static char[] NetworkUserEntityData$$ExternalSyntheticLambda8;

    /* renamed from: DatabaseTableConfigUtil  reason: from kotlin metadata */
    private Showcase PlaceComponentResult;

    /* renamed from: GetContactSyncConfig  reason: from kotlin metadata */
    private boolean getAuthRequestContext;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda2  reason: from kotlin metadata */
    private final Lazy getErrorConfigVersion;
    public DanapolyComponent danapolyComponent;

    /* renamed from: getErrorConfigVersion  reason: from kotlin metadata */
    private boolean KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: initRecordTimeStamp  reason: from kotlin metadata */
    private MaterialDialog MyBillsEntityDataFactory;
    @Inject
    public DanapolyMixpanelTracker tracker;
    @Inject
    public ViewModelFactory viewModelFactory;
    public static final byte[] $$g = {71, Ascii.US, 113, 39, -51, TarHeader.LF_NORMAL, -46, -10, -7, -14, 39, -48, -13, 4, -18, -12, 46, -36, -26, 12, Ascii.DC4, -34, -9, -24, -2, -10, -14, -5, -22, 44, -59, -6, 5, 15, -26, -19, -11, 9, -21, -8, 42, -51, -6, -13, 8, -26, -3, 1, -48, 4, -25, -7, 35, -43, -10, -3, 65, -39, -36, -26, 12, TarHeader.LF_FIFO, -71, -8, -5, -16, 4, -24, 6, -6, 15, -40, -6, Ascii.DC4, -40, 12, -26, 4, -1, 15, -31, -15, 4, -10, -20, -8, 72, -21};
    public static final int $$h = 147;
    public static final byte[] PlaceComponentResult = {Ascii.EM, 16, -94, Ascii.FS, -7, -1, 7, 4, -13, 9, 3, -51, Ascii.ETB, 16, -13, -39, 42, -13, -1, -11, 19, -23, -53, 60, -13, 11, -9, -59, 35, 36, -8, -1, -17, 6};
    public static final int lookAheadTest = 65;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda1  reason: from kotlin metadata */
    private DanapolyTabs BuiltInFictitiousFunctionClassFactory = DanapolyTabs.PLAY;

    /* renamed from: scheduleImpl  reason: from kotlin metadata */
    private boolean cardPromptShown = true;

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] KClassImpl$Data$declaredNonStaticMembers$2;

        static {
            int[] iArr = new int[DanapolyTabs.values().length];
            iArr[DanapolyTabs.PLAY.ordinal()] = 1;
            KClassImpl$Data$declaredNonStaticMembers$2 = iArr;
        }
    }

    static {
        BuiltInFictitiousFunctionClassFactory();
        INSTANCE = new Companion(null);
    }

    static void BuiltInFictitiousFunctionClassFactory() {
        NetworkUserEntityData$$ExternalSyntheticLambda8 = new char[]{35553, 35726, 35767, 35762, 35763, 35763, 35762, 35754, 35770, 35714, 35765, 35767, 35775, 35774, 35774, 35771, 35769, 35767, 35760, 35764, 35770, 35737, 35739, 35768, 35760, 35731, 35497, 35568, 35570, 35568, 35572, 35580, 35576, 35572, 35568, 35566, 35526, 35524, 35567, 35575, 35573, 35564, 35565, 35570, 35502, 35577, 35575, 35573, 35566, 35570, 35576, 35543, 35536, 35567, 35534, 35489, 35583, 35566, 35575, 35578, 35570, 35565, 35552, 35729, 35717, 35726, 35728, 35503, 35538, 35497, 35498, 35540, 35536, 35494, 35497, 35536, 35578, 35578, 35579, 35541, 35503, 35501, 35501, 35503, 35501, 35541, 35580, 35581, 35581, 35538, 35539, 35541, 35499, 35536, 35541, 35541, 35580, 35581, 35537, 35497, 35498, 35499, 35537, 35537, 35494, 35498, 35501, 35536, 35539, 35499, 35538, 35540, 35498, 35539, 35536, 35463, 35541, 35536, 35498, 35543, 35580, 35540, 35502, 35502, 35502, 35501, 35494, 35495, 35494, 35499, 35501, 35499, 35498, 35498, 35539, 35540, 35541, 35540, 35500, 35498, 35503, 35543, 35581, 35539, 35496, 35538, 35581, 35540, 35500, 35541, 35536, 35536, 35537, 35539, 35538, 35498, 35498, 35501, 35540, 35540, 35541, 35538, 35500, 35501, 35500, 35503, 35540, 35538, 35497, 35536, 35581, 35536, 35498, 35498, 35537, 35579, 35539, 35499, 35541, 35529, 35378, 35380, 35420, 35421, 35378, 35378, 35381, 35381, 35420, 35422, 35384, 35422, 35399, 35421, 35418, 35399, 35400, 35363, 35383, 35381, 35385, 35422, 35418, 35379, 35378, 35381, 35423, 35420, 35380, 35422, 35420, 35420, 35420, 35421, 35397, 35418, 35379, 35418, 35421, 35380, 35361, 35400, 35361, 35422, 35423, 35423, 35398, 35423, 35382, 35384, 35385, 35384, 35383, 35379, 35379, 35381, 35382, 35383, 35379, 35420, 35398, 35422, 35384, 35495, 35565, 35567, 35575, 35571, 35571, 35540, 35502, 35530, 35532, 35535, 35565, 35570, 35576, 35572, 35573, 35538, 35538, 35570, 35574, 35542, 35536, 35568, 35575, 35542, 35543, 35573, 35575, 35573, 35565, 35564, 35573, 35573, 35575, 35573, 35568, 35540, 35535, 35565, 35572, 35580, 35573, 35572, 35581, 35573, 35571, 35568, 35535, 35545, 35577, 35577, 35580, 35543, 35505, 35498, 35528, 35567, 35564, 35562, 35568, 35458, 35501, 35503, 35503, 35502, 35503};
    }

    public static void __fsTypeCheck_c52aa2dbefd88c9ae00028cadc29fb43(AppCompatImageView appCompatImageView, int i) {
        if (appCompatImageView instanceof ImageView) {
            InstrumentInjector.Resources_setImageResource(appCompatImageView, i);
        } else {
            appCompatImageView.setImageResource(i);
        }
    }

    private static void h(byte b, byte b2, int i, Object[] objArr) {
        int i2 = (b * 15) + 4;
        int i3 = 106 - i;
        byte[] bArr = PlaceComponentResult;
        int i4 = (b2 * 3) + 16;
        byte[] bArr2 = new byte[i4];
        int i5 = 0;
        if (bArr == null) {
            i2++;
            i3 = i3 + i2 + 2;
        }
        while (true) {
            bArr2[i5] = (byte) i3;
            i5++;
            if (i5 == i4) {
                objArr[0] = new String(bArr2, 0);
                return;
            }
            byte b3 = bArr[i2];
            i2++;
            i3 = i3 + b3 + 2;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:44:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x002d  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:46:0x002d -> B:47:0x0037). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void j(short r7, short r8, short r9, java.lang.Object[] r10) {
        /*
            byte[] r0 = id.dana.danapoly.ui.board.DanapolyBoardTabActivity.$$g
            int r9 = r9 + 4
            int r8 = r8 * 3
            int r8 = 42 - r8
            int r7 = r7 * 2
            int r7 = r7 + 75
            byte[] r1 = new byte[r8]
            r2 = 0
            if (r0 != 0) goto L18
            r3 = r1
            r4 = 0
            r1 = r0
            r0 = r10
            r10 = r9
            r9 = r8
            goto L37
        L18:
            r3 = 0
        L19:
            r6 = r8
            r8 = r7
            r7 = r6
            int r9 = r9 + 1
            int r4 = r3 + 1
            byte r5 = (byte) r8
            r1[r3] = r5
            if (r4 != r7) goto L2d
            java.lang.String r7 = new java.lang.String
            r7.<init>(r1, r2)
            r10[r2] = r7
            return
        L2d:
            r3 = r0[r9]
            r6 = r8
            r8 = r7
            r7 = r3
            r3 = r1
            r1 = r0
            r0 = r10
            r10 = r9
            r9 = r6
        L37:
            int r7 = -r7
            int r9 = r9 + r7
            int r7 = r9 + (-7)
            r9 = r10
            r10 = r0
            r0 = r1
            r1 = r3
            r3 = r4
            goto L19
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.danapoly.ui.board.DanapolyBoardTabActivity.j(short, short, short, java.lang.Object[]):void");
    }

    @JvmStatic
    public static final void openActivity(Context context, PlayBoardModel playBoardModel, DanapolyDeeplinkModel danapolyDeeplinkModel) {
        Companion.BuiltInFictitiousFunctionClassFactory(context, playBoardModel, danapolyDeeplinkModel);
    }

    @Override // id.dana.danapoly.ui.board.BaseDanapolyAudioActivity, id.dana.core.ui.BaseViewBindingActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper
    public final void attachBaseContext(Context context) {
        Object[] objArr;
        Object[] objArr2;
        Object[] objArr3;
        Object[] objArr4;
        super.attachBaseContext(context);
        Object[] objArr5 = new Object[1];
        g(new int[]{44, 18, 0, 0}, new byte[]{1, 1, 0, 0, 1, 0, 1, 0, 1, 0, 1, 0, 0, 1, 0, 0, 0, 0}, false, objArr5);
        Class<?> cls = Class.forName((String) objArr5[0]);
        Object[] objArr6 = new Object[1];
        g(new int[]{62, 5, 168, 3}, new byte[]{1, 0, 0, 1, 1}, true, objArr6);
        int intValue = ((Integer) cls.getDeclaredMethod((String) objArr6[0], new Class[0]).invoke(null, new Object[0])).intValue() % 100000;
        if (intValue < 99000 || intValue > 99999) {
            Context applicationContext = context != null ? context.getApplicationContext() : context;
            if (applicationContext != null) {
                try {
                    Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                    if (obj == null) {
                        obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - (ViewConfiguration.getPressedStateDuration() >> 16), ((Process.getThreadPriority(0) + 20) >> 6) + 35, (char) ((Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1)) - 1))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                    }
                    Object invoke = ((Method) obj).invoke(null, null);
                    Object[] objArr7 = new Object[1];
                    g(new int[]{67, 48, 0, 47}, new byte[]{1, 1, 0, 0, 0, 1, 1, 1, 0, 0, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 0, 1, 0, 1, 1, 0, 0, 0, 1, 0, 0, 1, 0, 1, 1, 1, 1, 0, 1, 1, 0, 0, 0, 1, 1, 1, 0}, false, objArr7);
                    String str = (String) objArr7[0];
                    Object[] objArr8 = new Object[1];
                    g(new int[]{115, 64, 0, 0}, new byte[]{1, 1, 0, 1, 1, 1, 0, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 1, 1, 0, 1, 0, 0, 1, 1, 0, 0, 0, 1, 0, 1, 0, 1, 1, 1, 1, 1, 1, 0, 0, 0, 1, 0, 1, 1, 0, 0, 1, 0, 0, 1, 1, 0, 0, 1, 0}, true, objArr8);
                    String str2 = (String) objArr8[0];
                    Object[] objArr9 = new Object[1];
                    g(new int[]{179, 64, 117, 0}, new byte[]{0, 0, 0, 1, 0, 1, 0, 0, 0, 1, 1, 1, 1, 0, 0, 1, 0, 1, 1, 0, 0, 1, 1, 0, 0, 0, 1, 1, 0, 0, 0, 1, 0, 0, 1, 0, 0, 1, 1, 1, 0, 0, 1, 0, 0, 0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 0, 0, 0, 1, 0, 1, 1, 0, 1}, true, objArr9);
                    String str3 = (String) objArr9[0];
                    Object[] objArr10 = new Object[1];
                    g(new int[]{243, 60, 0, 0}, new byte[]{1, 1, 0, 1, 1, 1, 0, 1, 0, 1, 1, 1, 0, 0, 1, 1, 0, 0, 1, 1, 0, 0, 0, 0, 1, 1, 1, 1, 0, 0, 0, 1, 0, 1, 0, 0, 1, 0, 1, 0, 0, 1, 1, 0, 1, 0, 0, 0, 1, 1, 1, 1, 1, 0, 1, 1, 1, 0, 0, 0}, true, objArr10);
                    String str4 = (String) objArr10[0];
                    Object[] objArr11 = new Object[1];
                    g(new int[]{303, 6, 0, 0}, new byte[]{1, 1, 0, 0, 0, 1}, false, objArr11);
                    try {
                        Object[] objArr12 = {applicationContext, str, str2, str3, str4, true, (String) objArr11[0], 995651014};
                        Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-1276397751);
                        if (obj2 == null) {
                            obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(Color.blue(0) + 911, (ViewConfiguration.getKeyRepeatDelay() >> 16) + 18, (char) (1 - (SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1))))).getMethod("getAuthRequestContext", Context.class, String.class, String.class, String.class, String.class, Boolean.TYPE, String.class, Integer.TYPE);
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
                byte b = (byte) (-PlaceComponentResult[5]);
                byte b2 = (byte) (b - 1);
                Object[] objArr13 = new Object[1];
                h(b, b2, b2, objArr13);
                Class<?> cls2 = Class.forName((String) objArr13[0]);
                byte b3 = (byte) (PlaceComponentResult[5] + 1);
                Object[] objArr14 = new Object[1];
                h(b3, b3, (byte) (-PlaceComponentResult[5]), objArr14);
                try {
                    Object[] objArr15 = {applicationContext2, Integer.valueOf(((Integer) cls2.getMethod((String) objArr14[0], Object.class).invoke(null, this)).intValue())};
                    Object obj3 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1691739267);
                    if (obj3 == null) {
                        Class cls3 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(56 - (SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)), 4 - (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)), (char) ((ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)) - 1));
                        Object[] objArr16 = new Object[1];
                        j($$g[47], $$g[68], $$g[78], objArr16);
                        obj3 = cls3.getMethod((String) objArr16[0], Context.class, Integer.TYPE);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1691739267, obj3);
                    }
                    Object invoke2 = ((Method) obj3).invoke(null, objArr15);
                    try {
                        Object obj4 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(40157535);
                        if (obj4 == null) {
                            obj4 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(800 - Gravity.getAbsoluteGravity(0, 0), MotionEvent.axisFromString("") + 16, (char) ExpandableListView.getPackedPositionGroup(0L))).getMethod("getAuthRequestContext", null);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(40157535, obj4);
                        }
                        int intValue2 = ((Integer) ((Method) obj4).invoke(invoke2, null)).intValue();
                        try {
                            Object obj5 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1621779126);
                            if (obj5 == null) {
                                obj5 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(800 - ExpandableListView.getPackedPositionGroup(0L), (ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)) + 16, (char) View.MeasureSpec.getMode(0))).getMethod("PlaceComponentResult", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1621779126, obj5);
                            }
                            if (((Integer) ((Method) obj5).invoke(invoke2, null)).intValue() != intValue2) {
                                ArrayList arrayList = new ArrayList();
                                try {
                                    Object[] objArr17 = {invoke2};
                                    Object obj6 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(658700871);
                                    if (obj6 == null) {
                                        obj6 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)) + 815, (ViewConfiguration.getKeyRepeatTimeout() >> 16) + 29, (char) ((ViewConfiguration.getKeyRepeatDelay() >> 16) + 57994))).getMethod("getAuthRequestContext", (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(TextUtils.lastIndexOf("", '0') + SecExceptionCode.SEC_ERROR_PKG_VALID_INVALID_PARAM, ExpandableListView.getPackedPositionChild(0L) + 16, (char) (((byte) KeyEvent.getModifierMetaStateMask()) + 1)));
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
                                            obj7 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - View.MeasureSpec.getSize(0), Color.red(0) + 35, (char) (1 - (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1))))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj7);
                                        }
                                        Object invoke3 = ((Method) obj7).invoke(objArr, objArr);
                                        try {
                                            Object[] objArr18 = {391939030, Long.valueOf(j), arrayList, LauncherActivity.getAuid()};
                                            Object obj8 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                            if (obj8 == null) {
                                                obj8 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - (ViewConfiguration.getFadingEdgeLength() >> 16), 18 - (ViewConfiguration.getWindowTouchSlop() >> 8), (char) Color.alpha(0))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                byte b4 = (byte) (-PlaceComponentResult[5]);
                byte b5 = (byte) (b4 - 1);
                Object[] objArr19 = new Object[1];
                h(b4, b5, b5, objArr19);
                Class<?> cls4 = Class.forName((String) objArr19[0]);
                byte b6 = (byte) (PlaceComponentResult[5] + 1);
                Object[] objArr20 = new Object[1];
                h(b6, b6, (byte) (-PlaceComponentResult[5]), objArr20);
                try {
                    Object[] objArr21 = {applicationContext3, Integer.valueOf(((Integer) cls4.getMethod((String) objArr20[0], Object.class).invoke(null, this)).intValue())};
                    Object obj9 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(345757441);
                    if (obj9 == null) {
                        Class cls5 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(TextUtils.lastIndexOf("", '0', 0) + 62, 46 - (ViewConfiguration.getMinimumFlingVelocity() >> 16), (char) View.resolveSizeAndState(0, 0, 0));
                        Object[] objArr22 = new Object[1];
                        j((byte) (-$$g[9]), (byte) (-$$g[8]), (byte) (-$$g[28]), objArr22);
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
                                obj10 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(Gravity.getAbsoluteGravity(0, 0) + PDF417Common.NUMBER_OF_CODEWORDS, Color.green(0) + 35, (char) ((-1) - (ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1))))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj10);
                            }
                            Object invoke4 = ((Method) obj10).invoke(objArr2, objArr2);
                            try {
                                Object[] objArr24 = {391939030, Long.valueOf(j2), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj11 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj11 == null) {
                                    obj11 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(Gravity.getAbsoluteGravity(0, 0) + 911, 18 - (ViewConfiguration.getMaximumDrawingCacheSize() >> 24), (char) (ViewConfiguration.getMaximumDrawingCacheSize() >> 24))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                byte b7 = (byte) (-PlaceComponentResult[5]);
                byte b8 = (byte) (b7 - 1);
                Object[] objArr25 = new Object[1];
                h(b7, b8, b8, objArr25);
                Class<?> cls6 = Class.forName((String) objArr25[0]);
                byte b9 = (byte) (PlaceComponentResult[5] + 1);
                Object[] objArr26 = new Object[1];
                h(b9, b9, (byte) (-PlaceComponentResult[5]), objArr26);
                try {
                    Object[] objArr27 = {applicationContext4, Integer.valueOf(((Integer) cls6.getMethod((String) objArr26[0], Object.class).invoke(null, this)).intValue())};
                    Object obj12 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-697999596);
                    if (obj12 == null) {
                        Class cls7 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(118 - TextUtils.indexOf("", "", 0, 0), TextUtils.indexOf((CharSequence) "", '0', 0) + 4, (char) (38968 - TextUtils.getTrimmedLength("")));
                        Object[] objArr28 = new Object[1];
                        j((byte) (-$$g[9]), (byte) (-$$g[8]), (byte) (-$$g[28]), objArr28);
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
                                obj13 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(Color.rgb(0, 0, 0) + 16778145, KeyEvent.getDeadChar(0, 0) + 35, (char) (TextUtils.lastIndexOf("", '0', 0) + 1))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj13);
                            }
                            Object invoke5 = ((Method) obj13).invoke(objArr3, objArr3);
                            try {
                                Object[] objArr30 = {391939030, Long.valueOf(j3), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj14 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj14 == null) {
                                    obj14 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(912 - (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)), 18 - ExpandableListView.getPackedPositionGroup(0L), (char) (ViewConfiguration.getLongPressTimeout() >> 16))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                byte b10 = (byte) (-PlaceComponentResult[5]);
                byte b11 = (byte) (b10 - 1);
                Object[] objArr31 = new Object[1];
                h(b10, b11, b11, objArr31);
                Class<?> cls8 = Class.forName((String) objArr31[0]);
                byte b12 = (byte) (PlaceComponentResult[5] + 1);
                Object[] objArr32 = new Object[1];
                h(b12, b12, (byte) (-PlaceComponentResult[5]), objArr32);
                try {
                    Object[] objArr33 = {applicationContext5, Integer.valueOf(((Integer) cls8.getMethod((String) objArr32[0], Object.class).invoke(null, this)).intValue())};
                    Object obj15 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-16683571);
                    if (obj15 == null) {
                        Class cls9 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getTouchSlop() >> 8) + 107, 3 - TextUtils.getOffsetBefore("", 0), (char) Gravity.getAbsoluteGravity(0, 0));
                        byte b13 = (byte) ($$g[47] - 1);
                        Object[] objArr34 = new Object[1];
                        j(b13, b13, $$g[40], objArr34);
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
                                obj16 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getScrollBarFadeDuration() >> 16) + PDF417Common.NUMBER_OF_CODEWORDS, TextUtils.indexOf("", "") + 35, (char) Color.green(0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj16);
                            }
                            Object invoke6 = ((Method) obj16).invoke(objArr4, objArr4);
                            try {
                                Object[] objArr36 = {391939030, Long.valueOf(j4), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj17 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj17 == null) {
                                    obj17 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(912 - (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)), ((byte) KeyEvent.getModifierMetaStateMask()) + 19, (char) ((Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1)) - 1))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
        Object[] objArr2 = new Object[1];
        g(new int[]{44, 18, 0, 0}, new byte[]{1, 1, 0, 0, 1, 0, 1, 0, 1, 0, 1, 0, 0, 1, 0, 0, 0, 0}, false, objArr2);
        Class<?> cls = Class.forName((String) objArr2[0]);
        Object[] objArr3 = new Object[1];
        g(new int[]{62, 5, 168, 3}, new byte[]{1, 0, 0, 1, 1}, true, objArr3);
        int intValue = ((Integer) cls.getDeclaredMethod((String) objArr3[0], new Class[0]).invoke(null, new Object[0])).intValue() % 100000;
        if (intValue < 99000 || intValue > 99999) {
            Context baseContext = getBaseContext();
            if (baseContext == null) {
                Object[] objArr4 = new Object[1];
                g(new int[]{0, 26, 190, 14}, new byte[]{1, 0, 1, 1, 1, 1, 1, 1, 1, 0, 0, 1, 0, 1, 1, 1, 0, 0, 1, 0, 1, 0, 1, 1, 0, 0}, false, objArr4);
                Class<?> cls2 = Class.forName((String) objArr4[0]);
                Object[] objArr5 = new Object[1];
                g(new int[]{26, 18, 0, 0}, new byte[]{0, 1, 0, 1, 1, 0, 0, 1, 0, 0, 1, 1, 0, 1, 1, 0, 1, 0}, true, objArr5);
                baseContext = (Context) cls2.getMethod((String) objArr5[0], new Class[0]).invoke(null, null);
            }
            if (baseContext != null) {
                baseContext = baseContext.getApplicationContext();
            }
            if (baseContext != null) {
                try {
                    Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                    if (obj == null) {
                        obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - (ViewConfiguration.getMinimumFlingVelocity() >> 16), (ViewConfiguration.getJumpTapTimeout() >> 16) + 35, (char) (ViewConfiguration.getPressedStateDuration() >> 16))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                    }
                    Object invoke = ((Method) obj).invoke(null, null);
                    Object[] objArr6 = new Object[1];
                    g(new int[]{67, 48, 0, 47}, new byte[]{1, 1, 0, 0, 0, 1, 1, 1, 0, 0, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 0, 1, 0, 1, 1, 0, 0, 0, 1, 0, 0, 1, 0, 1, 1, 1, 1, 0, 1, 1, 0, 0, 0, 1, 1, 1, 0}, false, objArr6);
                    String str = (String) objArr6[0];
                    Object[] objArr7 = new Object[1];
                    g(new int[]{115, 64, 0, 0}, new byte[]{1, 1, 0, 1, 1, 1, 0, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 1, 1, 0, 1, 0, 0, 1, 1, 0, 0, 0, 1, 0, 1, 0, 1, 1, 1, 1, 1, 1, 0, 0, 0, 1, 0, 1, 1, 0, 0, 1, 0, 0, 1, 1, 0, 0, 1, 0}, true, objArr7);
                    String str2 = (String) objArr7[0];
                    Object[] objArr8 = new Object[1];
                    g(new int[]{179, 64, 117, 0}, new byte[]{0, 0, 0, 1, 0, 1, 0, 0, 0, 1, 1, 1, 1, 0, 0, 1, 0, 1, 1, 0, 0, 1, 1, 0, 0, 0, 1, 1, 0, 0, 0, 1, 0, 0, 1, 0, 0, 1, 1, 1, 0, 0, 1, 0, 0, 0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 0, 0, 0, 1, 0, 1, 1, 0, 1}, true, objArr8);
                    String str3 = (String) objArr8[0];
                    Object[] objArr9 = new Object[1];
                    g(new int[]{243, 60, 0, 0}, new byte[]{1, 1, 0, 1, 1, 1, 0, 1, 0, 1, 1, 1, 0, 0, 1, 1, 0, 0, 1, 1, 0, 0, 0, 0, 1, 1, 1, 1, 0, 0, 0, 1, 0, 1, 0, 0, 1, 0, 1, 0, 0, 1, 1, 0, 1, 0, 0, 0, 1, 1, 1, 1, 1, 0, 1, 1, 1, 0, 0, 0}, true, objArr9);
                    String str4 = (String) objArr9[0];
                    Object[] objArr10 = new Object[1];
                    g(new int[]{303, 6, 0, 0}, new byte[]{1, 1, 0, 0, 0, 1}, false, objArr10);
                    try {
                        Object[] objArr11 = {baseContext, str, str2, str3, str4, true, (String) objArr10[0], 995651014};
                        Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-1276397751);
                        if (obj2 == null) {
                            obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - (ViewConfiguration.getScrollBarSize() >> 8), (Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1)) + 17, (char) (TextUtils.indexOf((CharSequence) "", '0', 0, 0) + 1))).getMethod("getAuthRequestContext", Context.class, String.class, String.class, String.class, String.class, Boolean.TYPE, String.class, Integer.TYPE);
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
            byte b = (byte) (-PlaceComponentResult[5]);
            byte b2 = (byte) (b - 1);
            Object[] objArr12 = new Object[1];
            h(b, b2, b2, objArr12);
            Class<?> cls3 = Class.forName((String) objArr12[0]);
            byte b3 = (byte) (PlaceComponentResult[5] + 1);
            Object[] objArr13 = new Object[1];
            h(b3, b3, (byte) (-PlaceComponentResult[5]), objArr13);
            try {
                Object[] objArr14 = {Integer.valueOf(((Integer) cls3.getMethod((String) objArr13[0], Object.class).invoke(null, this)).intValue())};
                Object obj3 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(25207140);
                if (obj3 == null) {
                    Class cls4 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(View.MeasureSpec.getSize(0) + 494, TextUtils.indexOf((CharSequence) "", '0') + 5, (char) (ViewConfiguration.getMaximumDrawingCacheSize() >> 24));
                    byte b4 = (byte) ($$g[47] - 1);
                    Object[] objArr15 = new Object[1];
                    j(b4, b4, $$g[40], objArr15);
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
                            obj4 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - Gravity.getAbsoluteGravity(0, 0), 35 - (ViewConfiguration.getTouchSlop() >> 8), (char) (ViewConfiguration.getTouchSlop() >> 8))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj4);
                        }
                        Object invoke2 = ((Method) obj4).invoke(objArr, objArr);
                        try {
                            Object[] objArr17 = {-1660398321, Long.valueOf(j), new ArrayList(), LauncherActivity.getAuid()};
                            Object obj5 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                            if (obj5 == null) {
                                obj5 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(TextUtils.indexOf("", "") + 911, (ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)) + 19, (char) (ViewConfiguration.getKeyRepeatTimeout() >> 16))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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

    @Override // id.dana.danapoly.ui.board.BaseDanapolyAudioActivity, id.dana.core.ui.BaseViewBindingActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onPause() {
        Context baseContext = getBaseContext();
        if (baseContext == null) {
            Object[] objArr = new Object[1];
            g(new int[]{0, 26, 190, 14}, new byte[]{1, 0, 1, 1, 1, 1, 1, 1, 1, 0, 0, 1, 0, 1, 1, 1, 0, 0, 1, 0, 1, 0, 1, 1, 0, 0}, false, objArr);
            Class<?> cls = Class.forName((String) objArr[0]);
            Object[] objArr2 = new Object[1];
            g(new int[]{26, 18, 0, 0}, new byte[]{0, 1, 0, 1, 1, 0, 0, 1, 0, 0, 1, 1, 0, 1, 1, 0, 1, 0}, true, objArr2);
            baseContext = (Context) cls.getMethod((String) objArr2[0], new Class[0]).invoke(null, null);
        }
        if (baseContext != null) {
            baseContext = baseContext.getApplicationContext();
        }
        if (baseContext != null) {
            try {
                Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                if (obj == null) {
                    obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - (ViewConfiguration.getKeyRepeatDelay() >> 16), (Process.myPid() >> 22) + 35, (char) (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                }
                Object invoke = ((Method) obj).invoke(null, null);
                try {
                    Object[] objArr3 = {baseContext};
                    Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-549958681);
                    if (obj2 == null) {
                        obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)), 18 - TextUtils.getOffsetBefore("", 0), (char) TextUtils.getTrimmedLength(""))).getMethod("MyBillsEntityDataFactory", Context.class);
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

    @Override // id.dana.danapoly.ui.board.BaseDanapolyAudioActivity, id.dana.core.ui.BaseViewBindingActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onResume() {
        Context baseContext = getBaseContext();
        if (baseContext == null) {
            Object[] objArr = new Object[1];
            g(new int[]{0, 26, 190, 14}, new byte[]{1, 0, 1, 1, 1, 1, 1, 1, 1, 0, 0, 1, 0, 1, 1, 1, 0, 0, 1, 0, 1, 0, 1, 1, 0, 0}, false, objArr);
            Class<?> cls = Class.forName((String) objArr[0]);
            Object[] objArr2 = new Object[1];
            g(new int[]{26, 18, 0, 0}, new byte[]{0, 1, 0, 1, 1, 0, 0, 1, 0, 0, 1, 1, 0, 1, 1, 0, 1, 0}, true, objArr2);
            baseContext = (Context) cls.getMethod((String) objArr2[0], new Class[0]).invoke(null, null);
        }
        if (baseContext != null) {
            baseContext = baseContext.getApplicationContext();
        }
        if (baseContext != null) {
            try {
                Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                if (obj == null) {
                    obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getMaximumFlingVelocity() >> 16) + PDF417Common.NUMBER_OF_CODEWORDS, ExpandableListView.getPackedPositionChild(0L) + 36, (char) Gravity.getAbsoluteGravity(0, 0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                }
                Object invoke = ((Method) obj).invoke(null, null);
                try {
                    Object[] objArr3 = {baseContext};
                    Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(247288059);
                    if (obj2 == null) {
                        obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - (ViewConfiguration.getKeyRepeatDelay() >> 16), 19 - (SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)), (char) ExpandableListView.getPackedPositionType(0L))).getMethod("KClassImpl$Data$declaredNonStaticMembers$2", Context.class);
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

    public DanapolyBoardTabActivity() {
        final DanapolyBoardTabActivity danapolyBoardTabActivity = this;
        final Function0 function0 = null;
        this.getErrorConfigVersion = new ViewModelLazy(Reflection.getOrCreateKotlinClass(DanapolyBoardViewModel.class), new Function0<ViewModelStore>() { // from class: id.dana.danapoly.ui.board.DanapolyBoardTabActivity$special$$inlined$viewModels$default$2
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: id.dana.danapoly.ui.board.DanapolyBoardTabActivity$viewModel$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return DanapolyBoardTabActivity.this.getViewModelFactory();
            }
        }, new Function0<CreationExtras>() { // from class: id.dana.danapoly.ui.board.DanapolyBoardTabActivity$special$$inlined$viewModels$default$3
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
                    CreationExtras defaultViewModelCreationExtras = danapolyBoardTabActivity.getDefaultViewModelCreationExtras();
                    Intrinsics.checkNotNullExpressionValue(defaultViewModelCreationExtras, "");
                    return defaultViewModelCreationExtras;
                }
                return creationExtras;
            }
        });
    }

    public static final /* synthetic */ ActivityDanapolyBoardBinding access$getBinding(DanapolyBoardTabActivity danapolyBoardTabActivity) {
        return (ActivityDanapolyBoardBinding) danapolyBoardTabActivity.getBinding();
    }

    @JvmName(name = "getTracker")
    public final DanapolyMixpanelTracker getTracker() {
        DanapolyMixpanelTracker danapolyMixpanelTracker = this.tracker;
        if (danapolyMixpanelTracker != null) {
            return danapolyMixpanelTracker;
        }
        Intrinsics.throwUninitializedPropertyAccessException("");
        return null;
    }

    @JvmName(name = "setTracker")
    public final void setTracker(DanapolyMixpanelTracker danapolyMixpanelTracker) {
        Intrinsics.checkNotNullParameter(danapolyMixpanelTracker, "");
        this.tracker = danapolyMixpanelTracker;
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

    @JvmName(name = "getDanapolyComponent")
    public final DanapolyComponent getDanapolyComponent() {
        DanapolyComponent danapolyComponent = this.danapolyComponent;
        if (danapolyComponent != null) {
            return danapolyComponent;
        }
        Intrinsics.throwUninitializedPropertyAccessException("");
        return null;
    }

    @JvmName(name = "setDanapolyComponent")
    public final void setDanapolyComponent(DanapolyComponent danapolyComponent) {
        Intrinsics.checkNotNullParameter(danapolyComponent, "");
        this.danapolyComponent = danapolyComponent;
    }

    @JvmName(name = "getCardPromptShown")
    public final boolean getCardPromptShown() {
        return this.cardPromptShown;
    }

    @JvmName(name = "setCardPromptShown")
    public final void setCardPromptShown(boolean z) {
        this.cardPromptShown = z;
    }

    @Override // id.dana.core.ui.BaseViewBindingActivity
    public final ActivityDanapolyBoardBinding inflateViewBinding() {
        ActivityDanapolyBoardBinding MyBillsEntityDataFactory = ActivityDanapolyBoardBinding.MyBillsEntityDataFactory(getLayoutInflater());
        Intrinsics.checkNotNullExpressionValue(MyBillsEntityDataFactory, "");
        return MyBillsEntityDataFactory;
    }

    @Override // id.dana.core.ui.BaseViewBindingActivity
    public final void init() {
        overridePendingTransition(R.anim.PlaceComponentResult_res_0x7f01002d, R.anim.getAuthRequestContext_res_0x7f01002f);
        TabLayout tabLayout = ((ActivityDanapolyBoardBinding) getBinding()).PlaceComponentResult;
        TabLayout.Tab newTab = tabLayout.newTab();
        DanapolyNavTabView.Companion companion = DanapolyNavTabView.INSTANCE;
        Context context = tabLayout.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "");
        tabLayout.addTab(newTab.setCustomView(DanapolyNavTabView.Companion.getAuthRequestContext(context)));
        TabLayout.Tab newTab2 = tabLayout.newTab();
        DefaultNavigationTabView.Companion companion2 = DefaultNavigationTabView.INSTANCE;
        Context context2 = tabLayout.getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "");
        tabLayout.addTab(newTab2.setCustomView(DefaultNavigationTabView.Companion.MyBillsEntityDataFactory(context2)));
        TabLayout.Tab newTab3 = tabLayout.newTab();
        DanapolyNavTabView.Companion companion3 = DanapolyNavTabView.INSTANCE;
        Context context3 = tabLayout.getContext();
        Intrinsics.checkNotNullExpressionValue(context3, "");
        tabLayout.addTab(newTab3.setCustomView(DanapolyNavTabView.Companion.KClassImpl$Data$declaredNonStaticMembers$2(context3)));
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() { // from class: id.dana.danapoly.ui.board.DanapolyBoardTabActivity$setupTabLayout$1$1
            @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
            public final void onTabUnselected(TabLayout.Tab p0) {
            }

            @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
            public final void onTabSelected(TabLayout.Tab p0) {
                boolean z;
                DanapolyBoardTabActivity.DanapolyTabs danapolyTabs;
                if (p0 != null) {
                    z = DanapolyBoardTabActivity.this.KClassImpl$Data$declaredNonStaticMembers$2;
                    if (z) {
                        int position = p0.getPosition();
                        danapolyTabs = DanapolyBoardTabActivity.this.BuiltInFictitiousFunctionClassFactory;
                        if (position != danapolyTabs.getPosition()) {
                            int position2 = p0.getPosition();
                            if (position2 == DanapolyBoardTabActivity.DanapolyTabs.PLAY.getPosition()) {
                                DanapolyBoardTabActivity.this.BuiltInFictitiousFunctionClassFactory(DanapolyBoardTabActivity.DanapolyTabs.PLAY, DanapolyBoardFragment.class);
                            } else if (position2 == DanapolyBoardTabActivity.DanapolyTabs.LEADERBOARD.getPosition()) {
                                ((AnalyticsTracker) DanapolyBoardTabActivity.this.getTracker().MyBillsEntityDataFactory.getValue()).KClassImpl$Data$declaredNonStaticMembers$2(DanapolyEvents.LEADERBOARD_OPEN, null);
                                DanapolyBoardTabActivity.this.BuiltInFictitiousFunctionClassFactory(DanapolyBoardTabActivity.DanapolyTabs.LEADERBOARD, LeaderboardFragment.class);
                            } else if (position2 == DanapolyBoardTabActivity.DanapolyTabs.CARDS.getPosition()) {
                                ((AnalyticsTracker) DanapolyBoardTabActivity.this.getTracker().MyBillsEntityDataFactory.getValue()).KClassImpl$Data$declaredNonStaticMembers$2(DanapolyEvents.CARDS_LIST_OPEN, null);
                                DanapolyBoardTabActivity.this.BuiltInFictitiousFunctionClassFactory(DanapolyBoardTabActivity.DanapolyTabs.CARDS, CardsListFragment.class);
                            }
                        }
                    }
                }
            }

            @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
            public final void onTabReselected(TabLayout.Tab p0) {
                onTabSelected(p0);
            }
        });
        ((ActivityDanapolyBoardBinding) getBinding()).PlaceComponentResult.selectTab(((ActivityDanapolyBoardBinding) getBinding()).PlaceComponentResult.getTabAt(DanapolyTabs.PLAY.getPosition()));
        StateFlow<DanapolyBoardUiState> stateFlow = ((DanapolyBoardViewModel) this.getErrorConfigVersion.getValue()).NetworkUserEntityData$$ExternalSyntheticLambda2;
        Lifecycle lifecycle = getLifecycle();
        Intrinsics.checkNotNullExpressionValue(lifecycle, "");
        Unit unit = null;
        FlowKt.launchIn(FlowKt.onEach(FlowExtKt.PlaceComponentResult(stateFlow, lifecycle), new DanapolyBoardTabActivity$initViewModel$1(this, null)), LifecycleOwnerKt.PlaceComponentResult(this));
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            if (extras.getBoolean(BUNDLE_TO_LEADERBOARD)) {
                renderTabLayout(false);
                BuiltInFictitiousFunctionClassFactory(DanapolyTabs.LEADERBOARD, LeaderboardFragment.class);
            } else {
                ((DanapolyBoardViewModel) this.getErrorConfigVersion.getValue()).MyBillsEntityDataFactory((PlayBoardModel) extras.getParcelable(BUNDLE_PLAY_BOARD), false);
                DanapolyDeeplinkModel danapolyDeeplinkModel = (DanapolyDeeplinkModel) extras.getParcelable(DanapolySplashActivity.BUNDLE_POP_UP);
                if (danapolyDeeplinkModel != null) {
                    if (danapolyDeeplinkModel.isWinnerNotification()) {
                        renderTabLayout(false);
                        BuiltInFictitiousFunctionClassFactory(DanapolyTabs.LEADERBOARD, LeaderboardFragment.class);
                    } else {
                        BuiltInFictitiousFunctionClassFactory(DanapolyTabs.PLAY, DanapolyBoardFragment.class);
                    }
                    unit = Unit.INSTANCE;
                }
                if (unit == null) {
                    BuiltInFictitiousFunctionClassFactory(DanapolyTabs.PLAY, DanapolyBoardFragment.class);
                }
            }
        }
        AppCompatImageView appCompatImageView = ((ActivityDanapolyBoardBinding) getBinding()).getAuthRequestContext;
        BuiltInFictitiousFunctionClassFactory(this.getAuthRequestContext);
        appCompatImageView.setOnClickListener(new DanapolyBoardTabActivity$$ExternalSyntheticLambda1(this));
    }

    @Override // id.dana.core.ui.BaseViewBindingActivity
    public final void initComponent() {
        Context applicationContext = getApplicationContext();
        if (applicationContext != null) {
            setDanapolyComponent(((DanapolyComponentProvider) applicationContext).provideDanapolyComponent().MyBillsEntityDataFactory());
            getDanapolyComponent().KClassImpl$Data$declaredNonStaticMembers$2(this);
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type id.dana.danapoly.di.provider.DanapolyComponentProvider");
    }

    public final void BuiltInFictitiousFunctionClassFactory(DanapolyTabs p0, Class<? extends Fragment> p1) {
        if (WhenMappings.KClassImpl$Data$declaredNonStaticMembers$2[p0.ordinal()] != 1) {
            MyBillsEntityDataFactory();
        } else {
            AppCompatImageView appCompatImageView = ((ActivityDanapolyBoardBinding) getBinding()).getAuthRequestContext;
            BuiltInFictitiousFunctionClassFactory(this.getAuthRequestContext);
            appCompatImageView.setOnClickListener(new DanapolyBoardTabActivity$$ExternalSyntheticLambda1(this));
        }
        Fragment findFragmentByTag = getSupportFragmentManager().findFragmentByTag(this.BuiltInFictitiousFunctionClassFactory.getTag());
        Fragment findFragmentByTag2 = getSupportFragmentManager().findFragmentByTag(p0.getTag());
        if (findFragmentByTag != null) {
            if (findFragmentByTag2 == null) {
                FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
                beginTransaction.isLayoutRequested = true;
                FragmentTransaction MyBillsEntityDataFactory = beginTransaction.PlaceComponentResult(findFragmentByTag).MyBillsEntityDataFactory(R.id.fragment_container_view, p1, null, p0.getTag());
                String tag = this.BuiltInFictitiousFunctionClassFactory.getTag();
                if (!MyBillsEntityDataFactory.NetworkUserEntityData$$ExternalSyntheticLambda0) {
                    throw new IllegalStateException("This FragmentTransaction is not allowed to be added to the back stack.");
                }
                MyBillsEntityDataFactory.scheduleImpl = true;
                MyBillsEntityDataFactory.NetworkUserEntityData$$ExternalSyntheticLambda8 = tag;
                MyBillsEntityDataFactory.getAuthRequestContext();
            } else {
                FragmentTransaction beginTransaction2 = getSupportFragmentManager().beginTransaction();
                beginTransaction2.isLayoutRequested = true;
                beginTransaction2.PlaceComponentResult(findFragmentByTag).BuiltInFictitiousFunctionClassFactory(findFragmentByTag2).getAuthRequestContext();
            }
            this.BuiltInFictitiousFunctionClassFactory = p0;
            if (findFragmentByTag2 == null || !(findFragmentByTag2 instanceof BaseViewBindingFragment)) {
                return;
            }
            ((BaseViewBindingFragment) findFragmentByTag2).getOnBoardingScenario();
            return;
        }
        FragmentTransaction beginTransaction3 = getSupportFragmentManager().beginTransaction();
        beginTransaction3.isLayoutRequested = true;
        beginTransaction3.MyBillsEntityDataFactory(R.id.fragment_container_view, p1, null, p0.getTag()).getAuthRequestContext();
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0019\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\f\u0010\rR\u0017\u0010\u0003\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\b\u001a\u00020\u00078\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010"}, d2 = {"Lid/dana/danapoly/ui/board/DanapolyBoardTabActivity$DanapolyTabs;", "", "", "position", "I", "getPosition", "()I", "", "tag", "Ljava/lang/String;", "getTag", "()Ljava/lang/String;", "<init>", "(Ljava/lang/String;IILjava/lang/String;)V", "PLAY", "CARDS", "LEADERBOARD"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public enum DanapolyTabs {
        PLAY(1, "DanapolyBoardFragment"),
        CARDS(0, "CardsListFragment"),
        LEADERBOARD(2, "LeaderboardFragment");

        private final int position;
        private final String tag;

        DanapolyTabs(int i, String str) {
            this.position = i;
            this.tag = str;
        }

        @JvmName(name = "getPosition")
        public final int getPosition() {
            return this.position;
        }

        @JvmName(name = "getTag")
        public final String getTag() {
            return this.tag;
        }
    }

    @Override // id.dana.danapoly.ui.board.DanapolyBoardListener
    public final void enableDice(boolean enable) {
        int i;
        this.getAuthRequestContext = enable;
        AppCompatImageView appCompatImageView = ((ActivityDanapolyBoardBinding) getBinding()).getAuthRequestContext;
        if (enable) {
            i = R.drawable.ic_button_dice;
        } else {
            i = R.drawable.FragmentBottomSheetPaymentSettingBinding_res_0x7f0807ed;
        }
        __fsTypeCheck_c52aa2dbefd88c9ae00028cadc29fb43(appCompatImageView, i);
    }

    @Override // id.dana.danapoly.ui.board.DanapolyBoardListener
    public final void enableBoardInteraction(boolean enable) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = enable;
    }

    public final void BuiltInFictitiousFunctionClassFactory(boolean p0) {
        AppCompatImageView appCompatImageView = ((ActivityDanapolyBoardBinding) getBinding()).getAuthRequestContext;
        appCompatImageView.setEnabled(p0);
        if (p0) {
            __fsTypeCheck_c52aa2dbefd88c9ae00028cadc29fb43(appCompatImageView, R.drawable.ic_button_dice);
        } else {
            __fsTypeCheck_c52aa2dbefd88c9ae00028cadc29fb43(appCompatImageView, R.drawable.FragmentBottomSheetPaymentSettingBinding_res_0x7f0807ed);
        }
    }

    private final void MyBillsEntityDataFactory() {
        AppCompatImageView appCompatImageView = ((ActivityDanapolyBoardBinding) getBinding()).getAuthRequestContext;
        appCompatImageView.setEnabled(true);
        __fsTypeCheck_c52aa2dbefd88c9ae00028cadc29fb43(appCompatImageView, R.drawable.ic_button_board);
        appCompatImageView.setOnClickListener(new View.OnClickListener() { // from class: id.dana.danapoly.ui.board.DanapolyBoardTabActivity$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DanapolyBoardTabActivity.m728$r8$lambda$g4605Lp4pqAq99Plp3RMiLNeWE(DanapolyBoardTabActivity.this, view);
            }
        });
    }

    public final void renderTabLayout(boolean isVisible) {
        Group group = ((ActivityDanapolyBoardBinding) getBinding()).BuiltInFictitiousFunctionClassFactory;
        Intrinsics.checkNotNullExpressionValue(group, "");
        group.setVisibility(isVisible ? 0 : 8);
    }

    public final void checkExtraForDareNotification() {
        DanapolyDeeplinkModel danapolyDeeplinkModel;
        DialogLayout view;
        Window window;
        MaterialDialog materialDialog;
        Bundle extras = getIntent().getExtras();
        if (extras == null || (danapolyDeeplinkModel = (DanapolyDeeplinkModel) extras.getParcelable(DanapolySplashActivity.BUNDLE_POP_UP)) == null || !danapolyDeeplinkModel.isDareNotification()) {
            return;
        }
        Intrinsics.checkNotNullExpressionValue(danapolyDeeplinkModel, "");
        MaterialDialog materialDialog2 = this.MyBillsEntityDataFactory;
        if ((materialDialog2 != null && materialDialog2.isShowing()) && (materialDialog = this.MyBillsEntityDataFactory) != null) {
            materialDialog.dismiss();
        }
        LocaleUtil localeUtil = LocaleUtil.INSTANCE;
        String prizeId = LocaleUtil.PlaceComponentResult() ? danapolyDeeplinkModel.getPrizeId() : danapolyDeeplinkModel.getPrizeEn();
        LocaleUtil localeUtil2 = LocaleUtil.INSTANCE;
        String typeId = LocaleUtil.PlaceComponentResult() ? danapolyDeeplinkModel.getTypeId() : danapolyDeeplinkModel.getTypeEn();
        CustomDialog.Builder builder = new CustomDialog.Builder(this);
        builder.getCallingPid = R.layout.view_custom_dare_notification;
        builder.SubSequence = getString(R.string.danapoly_banner_got_a_point_title);
        builder.GetContactSyncConfig = getString(R.string.danapoly_banner_got_a_point_message, prizeId, typeId);
        builder.DatabaseTableConfigUtil = R.drawable.ic_dare_reward;
        String string = getString(R.string.res_0x7f13059c_networkuserentitydata_externalsyntheticlambda7);
        Function1<View, Unit> function1 = new Function1<View, Unit>() { // from class: id.dana.danapoly.ui.board.DanapolyBoardTabActivity$showDareCompletedPopup$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(View view2) {
                invoke2(view2);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(View view2) {
                MaterialDialog materialDialog3;
                Intrinsics.checkNotNullParameter(view2, "");
                materialDialog3 = DanapolyBoardTabActivity.this.MyBillsEntityDataFactory;
                if (materialDialog3 != null) {
                    materialDialog3.dismiss();
                }
            }
        };
        Intrinsics.checkNotNullParameter(function1, "");
        CustomDialog$sam$android_view_View_OnClickListener$0 customDialog$sam$android_view_View_OnClickListener$0 = new CustomDialog$sam$android_view_View_OnClickListener$0(function1);
        builder.getAuthRequestContext = string;
        builder.readMicros = customDialog$sam$android_view_View_OnClickListener$0;
        MaterialDialog BuiltInFictitiousFunctionClassFactory = builder.BuiltInFictitiousFunctionClassFactory();
        this.MyBillsEntityDataFactory = BuiltInFictitiousFunctionClassFactory;
        if (BuiltInFictitiousFunctionClassFactory != null && (window = BuiltInFictitiousFunctionClassFactory.getWindow()) != null) {
            window.setBackgroundDrawable(new ColorDrawable(0));
        }
        MaterialDialog materialDialog3 = this.MyBillsEntityDataFactory;
        if (materialDialog3 != null && (view = materialDialog3.getView()) != null) {
            view.setBackgroundColor(0);
        }
        MaterialDialog materialDialog4 = this.MyBillsEntityDataFactory;
        if (materialDialog4 != null) {
            materialDialog4.show();
        }
    }

    public final void onBackToBoardPage() {
        if (getSupportFragmentManager().getBackStackEntryCount() > 0) {
            getSupportFragmentManager().popBackStack("DanapolyBoardFragment", 1);
            this.BuiltInFictitiousFunctionClassFactory = DanapolyTabs.PLAY;
            ((ActivityDanapolyBoardBinding) getBinding()).PlaceComponentResult.selectTab(((ActivityDanapolyBoardBinding) getBinding()).PlaceComponentResult.getTabAt(DanapolyTabs.PLAY.getPosition()));
            AppCompatImageView appCompatImageView = ((ActivityDanapolyBoardBinding) getBinding()).getAuthRequestContext;
            BuiltInFictitiousFunctionClassFactory(this.getAuthRequestContext);
            appCompatImageView.setOnClickListener(new DanapolyBoardTabActivity$$ExternalSyntheticLambda1(this));
            renderTabLayout(true);
            return;
        }
        finish();
    }

    public final void showLapCount(int lapCount, final Function0<Unit> onAnimationEnd) {
        Intrinsics.checkNotNullParameter(onAnimationEnd, "");
        DanapolyLapCountView danapolyLapCountView = ((ActivityDanapolyBoardBinding) getBinding()).getErrorConfigVersion;
        Intrinsics.checkNotNullExpressionValue(danapolyLapCountView, "");
        danapolyLapCountView.setVisibility(0);
        ((ActivityDanapolyBoardBinding) getBinding()).getErrorConfigVersion.show(lapCount, new Function0<Unit>() { // from class: id.dana.danapoly.ui.board.DanapolyBoardTabActivity$showLapCount$1
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
                DanapolyLapCountView danapolyLapCountView2 = DanapolyBoardTabActivity.access$getBinding(DanapolyBoardTabActivity.this).getErrorConfigVersion;
                Intrinsics.checkNotNullExpressionValue(danapolyLapCountView2, "");
                danapolyLapCountView2.setVisibility(8);
                onAnimationEnd.invoke();
            }
        });
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0011\u0010\u0012J+\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0007¢\u0006\u0004\b\t\u0010\nJ\u001f\u0010\f\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\f\u0010\rR\u0014\u0010\u000e\u001a\u00020\u000b8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0010\u001a\u00020\u000b8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0010\u0010\u000f"}, d2 = {"Lid/dana/danapoly/ui/board/DanapolyBoardTabActivity$Companion;", "", "Landroid/content/Context;", "p0", "Lid/dana/danapoly/ui/model/PlayBoardModel;", "p1", "Lid/dana/danapoly/ui/model/DanapolyDeeplinkModel;", "p2", "", "BuiltInFictitiousFunctionClassFactory", "(Landroid/content/Context;Lid/dana/danapoly/ui/model/PlayBoardModel;Lid/dana/danapoly/ui/model/DanapolyDeeplinkModel;)V", "", "MyBillsEntityDataFactory", "(Landroid/content/Context;Ljava/lang/String;)V", "BUNDLE_PLAY_BOARD", "Ljava/lang/String;", "BUNDLE_TO_LEADERBOARD", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public static void BuiltInFictitiousFunctionClassFactory(Context p0, PlayBoardModel p1, DanapolyDeeplinkModel p2) {
            Intrinsics.checkNotNullParameter(p0, "");
            Intent intent = new Intent(p0, DanapolyBoardTabActivity.class);
            intent.putExtra(DanapolyBoardTabActivity.BUNDLE_PLAY_BOARD, p1);
            if (p2 != null) {
                intent.putExtra(DanapolySplashActivity.BUNDLE_POP_UP, p2);
            }
            p0.startActivity(intent);
        }

        public static void MyBillsEntityDataFactory(Context p0, String p1) {
            Intrinsics.checkNotNullParameter(p0, "");
            Intent intent = new Intent(p0, DanapolyBoardTabActivity.class);
            intent.putExtra(DanapolyBoardTabActivity.BUNDLE_TO_LEADERBOARD, true);
            if (p1 != null) {
                intent.putExtra("last_event_id", p1);
            }
            p0.startActivity(intent);
        }
    }

    /* renamed from: $r8$lambda$g4605Lp4pqAq99Pl-p3RMiLNeWE */
    public static /* synthetic */ void m728$r8$lambda$g4605Lp4pqAq99Plp3RMiLNeWE(DanapolyBoardTabActivity danapolyBoardTabActivity, View view) {
        Intrinsics.checkNotNullParameter(danapolyBoardTabActivity, "");
        ((ActivityDanapolyBoardBinding) danapolyBoardTabActivity.getBinding()).PlaceComponentResult.selectTab(((ActivityDanapolyBoardBinding) danapolyBoardTabActivity.getBinding()).PlaceComponentResult.getTabAt(DanapolyTabs.PLAY.getPosition()));
        danapolyBoardTabActivity.BuiltInFictitiousFunctionClassFactory(DanapolyTabs.PLAY, DanapolyBoardFragment.class);
    }

    public static /* synthetic */ void $r8$lambda$j2SqUCVIpM3PjOxEOMCCkZx0tsc(DanapolyBoardTabActivity danapolyBoardTabActivity, View view) {
        Intrinsics.checkNotNullParameter(danapolyBoardTabActivity, "");
        Showcase showcase = danapolyBoardTabActivity.PlaceComponentResult;
        if (showcase != null) {
            showcase.MyBillsEntityDataFactory();
        }
        ((DanapolyBoardViewModel) danapolyBoardTabActivity.getErrorConfigVersion.getValue()).BuiltInFictitiousFunctionClassFactory();
    }

    public static /* synthetic */ void $r8$lambda$qduC3OyorA0uRsa_G1GM00hMras(DanapolyBoardTabActivity danapolyBoardTabActivity, View view) {
        Intrinsics.checkNotNullParameter(danapolyBoardTabActivity, "");
        if (danapolyBoardTabActivity.BuiltInFictitiousFunctionClassFactory == DanapolyTabs.PLAY && danapolyBoardTabActivity.getAuthRequestContext && danapolyBoardTabActivity.KClassImpl$Data$declaredNonStaticMembers$2) {
            ((AnalyticsTracker) danapolyBoardTabActivity.getTracker().MyBillsEntityDataFactory.getValue()).KClassImpl$Data$declaredNonStaticMembers$2(DanapolyEvents.ROLL_DICE_START, null);
            Showcase showcase = danapolyBoardTabActivity.PlaceComponentResult;
            if (showcase != null) {
                showcase.MyBillsEntityDataFactory();
            }
            ((DanapolyBoardViewModel) danapolyBoardTabActivity.getErrorConfigVersion.getValue()).BuiltInFictitiousFunctionClassFactory();
        } else if (danapolyBoardTabActivity.KClassImpl$Data$declaredNonStaticMembers$2) {
            ((ActivityDanapolyBoardBinding) danapolyBoardTabActivity.getBinding()).PlaceComponentResult.selectTab(((ActivityDanapolyBoardBinding) danapolyBoardTabActivity.getBinding()).PlaceComponentResult.getTabAt(DanapolyTabs.PLAY.getPosition()));
            danapolyBoardTabActivity.BuiltInFictitiousFunctionClassFactory(DanapolyTabs.PLAY, DanapolyBoardFragment.class);
        }
    }

    public static final /* synthetic */ DanapolyBoardViewModel access$getViewModel(DanapolyBoardTabActivity danapolyBoardTabActivity) {
        return (DanapolyBoardViewModel) danapolyBoardTabActivity.getErrorConfigVersion.getValue();
    }

    public static final /* synthetic */ void access$showFirstTimeTutorial(DanapolyBoardTabActivity danapolyBoardTabActivity) {
        if (danapolyBoardTabActivity.PlaceComponentResult == null) {
            DanapolyBoardTabActivity danapolyBoardTabActivity2 = danapolyBoardTabActivity;
            SimpleShowcaseBuilder simpleShowcaseBuilder = new SimpleShowcaseBuilder(danapolyBoardTabActivity2);
            AppCompatImageView appCompatImageView = ((ActivityDanapolyBoardBinding) danapolyBoardTabActivity.getBinding()).getAuthRequestContext;
            Intrinsics.checkNotNullExpressionValue(appCompatImageView, "");
            AppCompatImageView appCompatImageView2 = appCompatImageView;
            String string = danapolyBoardTabActivity.getString(R.string.first_time_open_title);
            Intrinsics.checkNotNullExpressionValue(string, "");
            String string2 = danapolyBoardTabActivity.getString(R.string.res_0x7f130895_networkuserentitydata_externalsyntheticlambda6);
            Intrinsics.checkNotNullExpressionValue(string2, "");
            Target MyBillsEntityDataFactory = new TargetBuilder(danapolyBoardTabActivity2).MyBillsEntityDataFactory(appCompatImageView2).MyBillsEntityDataFactory(new CircleShape(appCompatImageView2.getWidth() / 2.0f)).KClassImpl$Data$declaredNonStaticMembers$2(new Content(string, string2)).getAuthRequestContext(R.layout.view_overlay_circle).MyBillsEntityDataFactory();
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
            double d = MyBillsEntityDataFactory.scheduleImpl.x;
            double authRequestContext = MyBillsEntityDataFactory.moveToNextValue.getAuthRequestContext();
            Double.isNaN(authRequestContext);
            Double.isNaN(d);
            double d2 = MyBillsEntityDataFactory.scheduleImpl.y;
            double PlaceComponentResult2 = MyBillsEntityDataFactory.moveToNextValue.PlaceComponentResult();
            Double.isNaN(PlaceComponentResult2);
            Double.isNaN(d2);
            layoutParams.setMargins((int) (d - (authRequestContext * 0.65d)), (int) (d2 - (PlaceComponentResult2 * 0.5d)), 0, 0);
            MyBillsEntityDataFactory.PlaceComponentResult.setLayoutParams(layoutParams);
            ShapeableImageView shapeableImageView = (ShapeableImageView) MyBillsEntityDataFactory.PlaceComponentResult.findViewById(R.id.AppCompatEmojiTextHelper_res_0x7f0a0304);
            shapeableImageView.setLayoutParams(new ViewGroup.LayoutParams(appCompatImageView2.getWidth(), appCompatImageView2.getHeight()));
            shapeableImageView.setOnClickListener(new View.OnClickListener() { // from class: id.dana.danapoly.ui.board.DanapolyBoardTabActivity$$ExternalSyntheticLambda2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    DanapolyBoardTabActivity.$r8$lambda$j2SqUCVIpM3PjOxEOMCCkZx0tsc(DanapolyBoardTabActivity.this, view);
                }
            });
            Intrinsics.checkNotNullExpressionValue(MyBillsEntityDataFactory, "");
            simpleShowcaseBuilder.GetContactSyncConfig = MyBillsEntityDataFactory;
            SimpleShowcaseBuilder simpleShowcaseBuilder2 = (SimpleShowcaseBuilder) simpleShowcaseBuilder.KClassImpl$Data$declaredNonStaticMembers$2(false);
            simpleShowcaseBuilder2.DatabaseTableConfigUtil = false;
            danapolyBoardTabActivity.PlaceComponentResult = ((SimpleShowcaseBuilder) simpleShowcaseBuilder2.getAuthRequestContext(new AbstractOnShowcaseStateListener() { // from class: id.dana.danapoly.ui.board.DanapolyBoardTabActivity$showFirstTimeTutorial$1
                @Override // id.dana.core.ui.showcase.AbstractOnShowcaseStateListener, id.dana.core.ui.showcase.OnShowcaseStateListener
                public final void PlaceComponentResult() {
                    DanapolyBoardTabActivity.this.PlaceComponentResult = null;
                    DanapolyBoardViewModel access$getViewModel = DanapolyBoardTabActivity.access$getViewModel(DanapolyBoardTabActivity.this);
                    BaseFlowUseCase.execute$default(access$getViewModel.getErrorConfigVersion, NoParams.INSTANCE, null, null, null, null, ViewModelKt.PlaceComponentResult(access$getViewModel), 30, null);
                }
            })).BuiltInFictitiousFunctionClassFactory();
        }
    }

    @Override // id.dana.danapoly.ui.board.DanapolyBoardListener
    public final void onClickRollDicePopupAction() {
        Showcase showcase = this.PlaceComponentResult;
        if (showcase != null) {
            showcase.MyBillsEntityDataFactory();
        }
        ((DanapolyBoardViewModel) this.getErrorConfigVersion.getValue()).BuiltInFictitiousFunctionClassFactory();
    }

    private static void g(int[] iArr, byte[] bArr, boolean z, Object[] objArr) {
        VerifyPinStateManager$executeRiskChallenge$2$2 verifyPinStateManager$executeRiskChallenge$2$2 = new VerifyPinStateManager$executeRiskChallenge$2$2();
        int i = iArr[0];
        int i2 = iArr[1];
        int i3 = iArr[2];
        int i4 = iArr[3];
        char[] cArr = NetworkUserEntityData$$ExternalSyntheticLambda8;
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
