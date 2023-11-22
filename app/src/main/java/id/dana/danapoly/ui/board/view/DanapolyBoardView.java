package id.dana.danapoly.ui.board.view;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;
import androidx.core.content.ContextCompat;
import androidx.view.C0207ViewKt;
import androidx.view.LifecycleCoroutineScope;
import androidx.view.LifecycleOwner;
import androidx.view.LifecycleOwnerKt;
import com.airbnb.lottie.LottieAnimationView;
import com.alibaba.ariver.kernel.RVParams;
import com.alibaba.griver.api.common.monitor.GriverMonitorConstants;
import com.ap.zoloz.hummer.biz.HummerConstants;
import com.fullstory.instrumentation.InstrumentInjector;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import id.dana.component.utils.SizeUtil;
import id.dana.core.ui.BaseViewBindingRichView;
import id.dana.danapoly.R;
import id.dana.danapoly.databinding.ViewDanapolyBoardBinding;
import id.dana.danapoly.ui.board.view.DanapolyBoardView;
import id.dana.danapoly.ui.enums.RewardType;
import id.dana.danapoly.ui.model.BackgroundColorType;
import id.dana.danapoly.ui.model.BoardModel;
import id.dana.danapoly.ui.model.play.PlayModel;
import id.dana.data.account.repository.AccountEntityRepository;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;

@Metadata(d1 = {"\u0000\u009c\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010!\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 m2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0004nmopB/\u0012\u0006\u0010f\u001a\u00020e\u0012\n\b\u0002\u0010h\u001a\u0004\u0018\u00010g\u0012\b\b\u0002\u0010i\u001a\u00020\u000e\u0012\b\b\u0002\u0010j\u001a\u00020\u000e¢\u0006\u0004\bk\u0010lJ\u0017\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0015\u0010\n\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\r\u001a\u00020\u00052\b\b\u0002\u0010\f\u001a\u00020\u0003¢\u0006\u0004\b\r\u0010\u0007J\u001f\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\r\u0010\u0015\u001a\u00020\u0005¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0017\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\r\u0010\u0019\u001a\u00020\u0003¢\u0006\u0004\b\u0019\u0010\u001aJ\r\u0010\u001b\u001a\u00020\u0003¢\u0006\u0004\b\u001b\u0010\u001aJ\u001b\u0010\u001f\u001a\u00020\u00052\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001c¢\u0006\u0004\b\u001f\u0010 J\u0015\u0010#\u001a\u00020\u00052\u0006\u0010\"\u001a\u00020!¢\u0006\u0004\b#\u0010$J\u001f\u0010%\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u0010H\u0002¢\u0006\u0004\b%\u0010&J\u0017\u0010'\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u0003H\u0002¢\u0006\u0004\b'\u0010\u0007J\u001f\u0010+\u001a\u00020\u00052\u0006\u0010(\u001a\u00020\u00032\b\b\u0002\u0010*\u001a\u00020)¢\u0006\u0004\b+\u0010,J\u0015\u0010.\u001a\u00020\u00052\u0006\u0010-\u001a\u00020\u000e¢\u0006\u0004\b.\u0010/J\u0015\u00102\u001a\u00020\u00052\u0006\u00101\u001a\u000200¢\u0006\u0004\b2\u00103J\u001b\u00106\u001a\u00020\u00052\f\u00105\u001a\b\u0012\u0004\u0012\u0002040\u001c¢\u0006\u0004\b6\u0010 J\u000f\u00107\u001a\u00020\u0005H\u0016¢\u0006\u0004\b7\u0010\u0016J\r\u00108\u001a\u00020\u0005¢\u0006\u0004\b8\u0010\u0016J\r\u00109\u001a\u00020\u0005¢\u0006\u0004\b9\u0010\u0016J\u0017\u0010:\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u0003H\u0002¢\u0006\u0004\b:\u0010\u0007R5\u0010C\u001a\u0015\u0012\u000b\u0012\t\u0018\u00010)¢\u0006\u0002\b<\u0012\u0004\u0012\u00020\u00050;8\u0007@\u0007X\u0086\u000e¢\u0006\u0012\n\u0004\b=\u0010>\u001a\u0004\b?\u0010@\"\u0004\bA\u0010BR\u001c\u0010'\u001a\b\u0012\u0004\u0012\u00020\u00120D8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b'\u0010ER\u0016\u0010:\u001a\u00020\u000e8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b%\u0010FR\u0016\u0010%\u001a\u00020)8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b:\u0010GR\u0016\u0010=\u001a\u00020\u000e8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b\u0013\u0010FR\u0016\u0010\u0013\u001a\u00020\u000e8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\bH\u0010FR\u0018\u0010K\u001a\u0004\u0018\u0001048\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\bI\u0010JR\u0016\u0010N\u001a\u00020\u00038\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\bL\u0010MR(\u0010U\u001a\b\u0012\u0004\u0012\u00020\u00050O8\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\bK\u0010P\u001a\u0004\bQ\u0010R\"\u0004\bS\u0010TR(\u0010X\u001a\b\u0012\u0004\u0012\u00020\u00050O8\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\bN\u0010P\u001a\u0004\bV\u0010R\"\u0004\bW\u0010TR5\u0010\\\u001a\u0015\u0012\u000b\u0012\t\u0018\u000104¢\u0006\u0002\b<\u0012\u0004\u0012\u00020\u00050;8\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\bY\u0010>\u001a\u0004\bZ\u0010@\"\u0004\b[\u0010BR\u0018\u0010L\u001a\u0004\u0018\u0001008\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b]\u0010^R\u001c\u0010I\u001a\b\u0012\u0004\u0012\u0002040_8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b`\u0010aR\u0019\u0010H\u001a\b\u0012\u0004\u0012\u00020b0\u001cX\u0083\u0080\u0002¢\u0006\u0006\n\u0004\bc\u0010d"}, d2 = {"Lid/dana/danapoly/ui/board/view/DanapolyBoardView;", "Lid/dana/core/ui/BaseViewBindingRichView;", "Lid/dana/danapoly/databinding/ViewDanapolyBoardBinding;", "", GriverMonitorConstants.KEY_IS_LOADING, "", "animateRollDice", "(Z)V", "Lid/dana/danapoly/ui/model/BackgroundColorType;", RVParams.AROME_BG_COLOR, "changeColor", "(Lid/dana/danapoly/ui/model/BackgroundColorType;)V", "initialMovement", "checkAndStartPawnMovement", "", "p0", "Lid/dana/danapoly/ui/board/view/DanapolyBoardView$PawnMovementType;", "p1", "Landroid/animation/ObjectAnimator;", "getAuthRequestContext", "(ILid/dana/danapoly/ui/board/view/DanapolyBoardView$PawnMovementType;)Landroid/animation/ObjectAnimator;", "hidePawn", "()V", "inflateViewBinding", "()Lid/dana/danapoly/databinding/ViewDanapolyBoardBinding;", "isErrorStateShown", "()Z", "isMovementQueueEmpty", "", "Lid/dana/danapoly/ui/model/BoardModel;", "boardModels", "loadBoard", "(Ljava/util/List;)V", "", AccountEntityRepository.UpdateType.AVATAR, "loadPawn", "(Ljava/lang/String;)V", "PlaceComponentResult", "(ILid/dana/danapoly/ui/board/view/DanapolyBoardView$PawnMovementType;)V", "MyBillsEntityDataFactory", "isError", "Lid/dana/danapoly/ui/board/view/DanapolyBoardView$BoardState;", "boardState", "renderErrorState", "(ZLid/dana/danapoly/ui/board/view/DanapolyBoardView$BoardState;)V", "position", "setInitialPosition", "(I)V", "Lid/dana/danapoly/ui/board/view/DanapolyBoardView$OnRollDiceShowListener;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setOnShowRollDiceResult", "(Lid/dana/danapoly/ui/board/view/DanapolyBoardView$OnRollDiceShowListener;)V", "Lid/dana/danapoly/ui/model/play/PlayModel;", "results", "setPawnPlayModels", "setup", "showBoard", "showPawn", "BuiltInFictitiousFunctionClassFactory", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "KClassImpl$Data$declaredNonStaticMembers$2", "Lkotlin/jvm/functions/Function1;", "getActionTryAgain", "()Lkotlin/jvm/functions/Function1;", "setActionTryAgain", "(Lkotlin/jvm/functions/Function1;)V", "actionTryAgain", "", "Ljava/util/List;", "I", "Lid/dana/danapoly/ui/board/view/DanapolyBoardView$BoardState;", "moveToNextValue", "NetworkUserEntityData$$ExternalSyntheticLambda0", "Lid/dana/danapoly/ui/model/play/PlayModel;", "getErrorConfigVersion", "scheduleImpl", "Z", "lookAheadTest", "Lkotlin/Function0;", "Lkotlin/jvm/functions/Function0;", "getOnAllDiceMovementDone", "()Lkotlin/jvm/functions/Function0;", "setOnAllDiceMovementDone", "(Lkotlin/jvm/functions/Function0;)V", "onAllDiceMovementDone", "getOnBoardAnimationFinished", "setOnBoardAnimationFinished", "onBoardAnimationFinished", "NetworkUserEntityData$$ExternalSyntheticLambda1", "getOnPawnStopMoving", "setOnPawnStopMoving", "onPawnStopMoving", "initRecordTimeStamp", "Lid/dana/danapoly/ui/board/view/DanapolyBoardView$OnRollDiceShowListener;", "Ljava/util/Queue;", "GetContactSyncConfig", "Ljava/util/Queue;", "Lid/dana/danapoly/ui/board/view/DanapolyBoardCardView;", "NetworkUserEntityData$$ExternalSyntheticLambda2", "Lkotlin/Lazy;", "Landroid/content/Context;", HummerConstants.CONTEXT, "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "defStyleRes", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "Companion", "BoardState", "OnRollDiceShowListener", "PawnMovementType"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class DanapolyBoardView extends BaseViewBindingRichView<ViewDanapolyBoardBinding> {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    private BoardState PlaceComponentResult;

    /* renamed from: GetContactSyncConfig  reason: from kotlin metadata */
    private Queue<PlayModel> NetworkUserEntityData$$ExternalSyntheticLambda0;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    private Function1<? super BoardState, Unit> actionTryAgain;
    private List<ObjectAnimator> MyBillsEntityDataFactory;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda0  reason: from kotlin metadata */
    private PlayModel getErrorConfigVersion;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda1  reason: from kotlin metadata */
    private Function1<? super PlayModel, Unit> onPawnStopMoving;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda2  reason: from kotlin metadata */
    private final Lazy moveToNextValue;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private int BuiltInFictitiousFunctionClassFactory;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    private int KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: getErrorConfigVersion  reason: from kotlin metadata */
    private Function0<Unit> onAllDiceMovementDone;

    /* renamed from: initRecordTimeStamp  reason: from kotlin metadata */
    private OnRollDiceShowListener scheduleImpl;

    /* renamed from: lookAheadTest  reason: from kotlin metadata */
    private Function0<Unit> onBoardAnimationFinished;

    /* renamed from: moveToNextValue  reason: from kotlin metadata */
    private int getAuthRequestContext;

    /* renamed from: scheduleImpl  reason: from kotlin metadata */
    private boolean lookAheadTest;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006"}, d2 = {"Lid/dana/danapoly/ui/board/view/DanapolyBoardView$BoardState;", "", "<init>", "(Ljava/lang/String;I)V", "DEFAULT", "ERROR_BOARD", "ERROR_ROLL_DICE"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public enum BoardState {
        DEFAULT,
        ERROR_BOARD,
        ERROR_ROLL_DICE
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bæ\u0080\u0001\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/danapoly/ui/board/view/DanapolyBoardView$OnRollDiceShowListener;", "", "", "KClassImpl$Data$declaredNonStaticMembers$2", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public interface OnRollDiceShowListener {
        void KClassImpl$Data$declaredNonStaticMembers$2();
    }

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] PlaceComponentResult;

        static {
            int[] iArr = new int[BackgroundColorType.values().length];
            iArr[BackgroundColorType.BLUE.ordinal()] = 1;
            iArr[BackgroundColorType.GREEN.ordinal()] = 2;
            iArr[BackgroundColorType.PURPLE.ordinal()] = 3;
            iArr[BackgroundColorType.ORANGE.ordinal()] = 4;
            iArr[BackgroundColorType.PINK.ordinal()] = 5;
            PlaceComponentResult = iArr;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public DanapolyBoardView(Context context) {
        this(context, null, 0, 0, 14, null);
        Intrinsics.checkNotNullParameter(context, "");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public DanapolyBoardView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 0, 12, null);
        Intrinsics.checkNotNullParameter(context, "");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public DanapolyBoardView(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, 0, 8, null);
        Intrinsics.checkNotNullParameter(context, "");
    }

    public static void __fsTypeCheck_c52aa2dbefd88c9ae00028cadc29fb43(AppCompatImageView appCompatImageView, int i) {
        if (appCompatImageView instanceof ImageView) {
            InstrumentInjector.Resources_setImageResource(appCompatImageView, i);
        } else {
            appCompatImageView.setImageResource(i);
        }
    }

    public /* synthetic */ DanapolyBoardView(Context context, AttributeSet attributeSet, int i, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i3 & 2) != 0 ? null : attributeSet, (i3 & 4) != 0 ? 0 : i, (i3 & 8) != 0 ? 0 : i2);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DanapolyBoardView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        Intrinsics.checkNotNullParameter(context, "");
        this.moveToNextValue = LazyKt.lazy(new Function0<List<? extends DanapolyBoardCardView>>() { // from class: id.dana.danapoly.ui.board.view.DanapolyBoardView$sortedCardViewList$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final List<? extends DanapolyBoardCardView> invoke() {
                ViewDanapolyBoardBinding binding;
                ViewDanapolyBoardBinding binding2;
                ViewDanapolyBoardBinding binding3;
                ViewDanapolyBoardBinding binding4;
                ViewDanapolyBoardBinding binding5;
                ViewDanapolyBoardBinding binding6;
                ViewDanapolyBoardBinding binding7;
                ViewDanapolyBoardBinding binding8;
                ViewDanapolyBoardBinding binding9;
                ViewDanapolyBoardBinding binding10;
                ViewDanapolyBoardBinding binding11;
                ViewDanapolyBoardBinding binding12;
                ViewDanapolyBoardBinding binding13;
                ViewDanapolyBoardBinding binding14;
                ViewDanapolyBoardBinding binding15;
                ViewDanapolyBoardBinding binding16;
                binding = DanapolyBoardView.this.getBinding();
                binding2 = DanapolyBoardView.this.getBinding();
                binding3 = DanapolyBoardView.this.getBinding();
                binding4 = DanapolyBoardView.this.getBinding();
                binding5 = DanapolyBoardView.this.getBinding();
                binding6 = DanapolyBoardView.this.getBinding();
                binding7 = DanapolyBoardView.this.getBinding();
                binding8 = DanapolyBoardView.this.getBinding();
                binding9 = DanapolyBoardView.this.getBinding();
                binding10 = DanapolyBoardView.this.getBinding();
                binding11 = DanapolyBoardView.this.getBinding();
                binding12 = DanapolyBoardView.this.getBinding();
                binding13 = DanapolyBoardView.this.getBinding();
                binding14 = DanapolyBoardView.this.getBinding();
                binding15 = DanapolyBoardView.this.getBinding();
                binding16 = DanapolyBoardView.this.getBinding();
                return CollectionsKt.listOf((Object[]) new DanapolyBoardCardView[]{binding.PlaceComponentResult, binding2.KClassImpl$Data$declaredNonStaticMembers$2, binding3.getErrorConfigVersion, binding4.moveToNextValue, binding5.DatabaseTableConfigUtil, binding6.initRecordTimeStamp, binding7.GetContactSyncConfig, binding8.NetworkUserEntityData$$ExternalSyntheticLambda2, binding9.NetworkUserEntityData$$ExternalSyntheticLambda1, binding10.NetworkUserEntityData$$ExternalSyntheticLambda8, binding11.getAuthRequestContext, binding12.MyBillsEntityDataFactory, binding13.BuiltInFictitiousFunctionClassFactory, binding14.lookAheadTest, binding15.scheduleImpl, binding16.NetworkUserEntityData$$ExternalSyntheticLambda0});
            }
        });
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = new LinkedList();
        this.PlaceComponentResult = BoardState.DEFAULT;
        this.BuiltInFictitiousFunctionClassFactory = R.color.BuiltInFictitiousFunctionClassFactory_res_0x7f0600c3;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = R.color.lookAheadTest_res_0x7f0600c8;
        this.actionTryAgain = new Function1<BoardState, Unit>() { // from class: id.dana.danapoly.ui.board.view.DanapolyBoardView$actionTryAgain$1
            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(DanapolyBoardView.BoardState boardState) {
                Intrinsics.checkNotNullParameter(boardState, "");
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(DanapolyBoardView.BoardState boardState) {
                invoke2(boardState);
                return Unit.INSTANCE;
            }
        };
        this.MyBillsEntityDataFactory = new ArrayList();
        this.onPawnStopMoving = new Function1<PlayModel, Unit>() { // from class: id.dana.danapoly.ui.board.view.DanapolyBoardView$onPawnStopMoving$1
            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(PlayModel playModel) {
                Intrinsics.checkNotNullParameter(playModel, "");
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(PlayModel playModel) {
                invoke2(playModel);
                return Unit.INSTANCE;
            }
        };
        this.onAllDiceMovementDone = new Function0<Unit>() { // from class: id.dana.danapoly.ui.board.view.DanapolyBoardView$onAllDiceMovementDone$1
            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2() {
            }

            @Override // kotlin.jvm.functions.Function0
            public final /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }
        };
        this.onBoardAnimationFinished = new Function0<Unit>() { // from class: id.dana.danapoly.ui.board.view.DanapolyBoardView$onBoardAnimationFinished$1
            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2() {
            }

            @Override // kotlin.jvm.functions.Function0
            public final /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }
        };
    }

    @JvmName(name = "getActionTryAgain")
    public final Function1<BoardState, Unit> getActionTryAgain() {
        return this.actionTryAgain;
    }

    @JvmName(name = "setActionTryAgain")
    public final void setActionTryAgain(Function1<? super BoardState, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "");
        this.actionTryAgain = function1;
    }

    @JvmName(name = "getOnPawnStopMoving")
    public final Function1<PlayModel, Unit> getOnPawnStopMoving() {
        return this.onPawnStopMoving;
    }

    @JvmName(name = "setOnPawnStopMoving")
    public final void setOnPawnStopMoving(Function1<? super PlayModel, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "");
        this.onPawnStopMoving = function1;
    }

    @JvmName(name = "getOnAllDiceMovementDone")
    public final Function0<Unit> getOnAllDiceMovementDone() {
        return this.onAllDiceMovementDone;
    }

    @JvmName(name = "setOnAllDiceMovementDone")
    public final void setOnAllDiceMovementDone(Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, "");
        this.onAllDiceMovementDone = function0;
    }

    @JvmName(name = "getOnBoardAnimationFinished")
    public final Function0<Unit> getOnBoardAnimationFinished() {
        return this.onBoardAnimationFinished;
    }

    @JvmName(name = "setOnBoardAnimationFinished")
    public final void setOnBoardAnimationFinished(Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, "");
        this.onBoardAnimationFinished = function0;
    }

    @Override // id.dana.core.ui.BaseViewBindingRichView
    public final ViewDanapolyBoardBinding inflateViewBinding() {
        ViewDanapolyBoardBinding PlaceComponentResult = ViewDanapolyBoardBinding.PlaceComponentResult(LayoutInflater.from(getContext()));
        Intrinsics.checkNotNullExpressionValue(PlaceComponentResult, "");
        return PlaceComponentResult;
    }

    public final void loadBoard(List<BoardModel> boardModels) {
        Intrinsics.checkNotNullParameter(boardModels, "");
        for (BoardModel boardModel : boardModels) {
            Object obj = ((List) this.moveToNextValue.getValue()).get(boardModel.getPosition());
            Intrinsics.checkNotNullExpressionValue(obj, "");
            DanapolyBoardCardView danapolyBoardCardView = (DanapolyBoardCardView) obj;
            danapolyBoardCardView.loadBoardCard(boardModel);
            List<ObjectAnimator> list = this.MyBillsEntityDataFactory;
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(danapolyBoardCardView, "alpha", 0.0f, 1.0f);
            Intrinsics.checkNotNullExpressionValue(ofFloat, "");
            list.add(ofFloat);
        }
    }

    public final void showBoard() {
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.setDuration(500L);
        animatorSet.playTogether(CollectionsKt.toList(this.MyBillsEntityDataFactory));
        animatorSet.addListener(new Animator.AnimatorListener() { // from class: id.dana.danapoly.ui.board.view.DanapolyBoardView$showBoard$1
            @Override // android.animation.Animator.AnimatorListener
            public final void onAnimationCancel(Animator p0) {
                Intrinsics.checkNotNullParameter(p0, "");
            }

            @Override // android.animation.Animator.AnimatorListener
            public final void onAnimationRepeat(Animator p0) {
                Intrinsics.checkNotNullParameter(p0, "");
            }

            @Override // android.animation.Animator.AnimatorListener
            public final void onAnimationStart(Animator p0) {
                Intrinsics.checkNotNullParameter(p0, "");
            }

            @Override // android.animation.Animator.AnimatorListener
            public final void onAnimationEnd(Animator p0) {
                Intrinsics.checkNotNullParameter(p0, "");
                DanapolyBoardView.this.getOnBoardAnimationFinished().invoke();
            }
        });
        animatorSet.start();
    }

    public final void showPawn() {
        if (isErrorStateShown()) {
            return;
        }
        DanapolyPawnView danapolyPawnView = getBinding().readMicros;
        Intrinsics.checkNotNullExpressionValue(danapolyPawnView, "");
        danapolyPawnView.setVisibility(0);
    }

    public final void hidePawn() {
        DanapolyPawnView danapolyPawnView = getBinding().readMicros;
        Intrinsics.checkNotNullExpressionValue(danapolyPawnView, "");
        danapolyPawnView.setVisibility(8);
    }

    public final void loadPawn(String r2) {
        Intrinsics.checkNotNullParameter(r2, "");
        getBinding().readMicros.loadAvatar(r2);
    }

    public final void MyBillsEntityDataFactory(boolean p0) {
        ViewDanapolyBoardBinding binding = getBinding();
        Group group = binding.newProxyInstance;
        Intrinsics.checkNotNullExpressionValue(group, "");
        boolean z = !p0;
        group.setVisibility(z ? 4 : 0);
        ConstraintLayout constraintLayout = binding.isLayoutRequested;
        Intrinsics.checkNotNullExpressionValue(constraintLayout, "");
        constraintLayout.setVisibility(z ? 4 : 0);
    }

    public final void BuiltInFictitiousFunctionClassFactory(boolean p0) {
        DanapolyPawnView danapolyPawnView = getBinding().readMicros;
        Intrinsics.checkNotNullExpressionValue(danapolyPawnView, "");
        danapolyPawnView.setVisibility(p0 ? 0 : 8);
    }

    public static /* synthetic */ void checkAndStartPawnMovement$default(DanapolyBoardView danapolyBoardView, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        danapolyBoardView.checkAndStartPawnMovement(z);
    }

    public final void checkAndStartPawnMovement(boolean initialMovement) {
        LifecycleCoroutineScope PlaceComponentResult;
        PlayModel poll = this.NetworkUserEntityData$$ExternalSyntheticLambda0.poll();
        Unit unit = null;
        if (poll != null) {
            this.getErrorConfigVersion = poll;
            if (this.lookAheadTest && !initialMovement) {
                MyBillsEntityDataFactory(true);
                BuiltInFictitiousFunctionClassFactory(true);
                PlaceComponentResult(Integer.parseInt(poll.getRandomResult()), poll.getPosition().getMovementType());
            } else {
                int parseInt = Integer.parseInt(poll.getRandomResult());
                PawnMovementType movementType = poll.getPosition().getMovementType();
                LifecycleOwner PlaceComponentResult2 = C0207ViewKt.PlaceComponentResult(this);
                if (PlaceComponentResult2 != null && (PlaceComponentResult = LifecycleOwnerKt.PlaceComponentResult(PlaceComponentResult2)) != null) {
                    BuildersKt__Builders_commonKt.launch$default(PlaceComponentResult, null, null, new DanapolyBoardView$showDiceResult$1(this, parseInt, movementType, null), 3, null);
                }
            }
            unit = Unit.INSTANCE;
        }
        if (unit == null) {
            this.lookAheadTest = false;
            this.onAllDiceMovementDone.invoke();
        }
    }

    public static /* synthetic */ void animateRollDice$default(DanapolyBoardView danapolyBoardView, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        danapolyBoardView.animateRollDice(z);
    }

    public final void animateRollDice(boolean r3) {
        if (isErrorStateShown()) {
            return;
        }
        boolean z = !r3;
        BuiltInFictitiousFunctionClassFactory(z);
        MyBillsEntityDataFactory(z);
        LottieAnimationView lottieAnimationView = getBinding().SubSequence;
        Intrinsics.checkNotNullExpressionValue(lottieAnimationView, "");
        lottieAnimationView.setVisibility(r3 ? 0 : 8);
        lottieAnimationView.setAnimation("json/lottie/danapoly_dice_roll.lottie");
        lottieAnimationView.playAnimation();
    }

    public final void setInitialPosition(int position) {
        Integer valueOf = Integer.valueOf(position);
        int intValue = valueOf.intValue();
        if (!(intValue != -1 && intValue < ((List) this.moveToNextValue.getValue()).size())) {
            valueOf = null;
        }
        Object obj = ((List) this.moveToNextValue.getValue()).get(valueOf != null ? valueOf.intValue() : 0);
        Intrinsics.checkNotNullExpressionValue(obj, "");
        DanapolyBoardCardView danapolyBoardCardView = (DanapolyBoardCardView) obj;
        getBinding().readMicros.setY(danapolyBoardCardView.getY() - SizeUtil.MyBillsEntityDataFactory());
        getBinding().readMicros.setX((danapolyBoardCardView.getX() + (danapolyBoardCardView.getWidth() / 2)) - (getBinding().readMicros.getWidth() / 2));
        this.getAuthRequestContext = position;
        showPawn();
    }

    public final void PlaceComponentResult(int p0, PawnMovementType p1) {
        ArrayList arrayList = new ArrayList();
        final Ref.IntRef intRef = new Ref.IntRef();
        intRef.element = this.getAuthRequestContext;
        if (p0 > 0) {
            int i = 1;
            while (true) {
                if (p1 == PawnMovementType.BACKWARD) {
                    intRef.element = this.getAuthRequestContext - (i % 16);
                    if (intRef.element < 0) {
                        intRef.element += 16;
                    }
                } else {
                    intRef.element = this.getAuthRequestContext + (i % 16);
                    if (intRef.element >= 16) {
                        intRef.element -= 16;
                    }
                }
                ObjectAnimator authRequestContext = getAuthRequestContext(intRef.element, p1);
                authRequestContext.setDuration(500L);
                authRequestContext.setStartDelay(200L);
                arrayList.add(authRequestContext);
                if (i == p0) {
                    break;
                }
                i++;
            }
        }
        final AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playSequentially(CollectionsKt.toList(arrayList));
        animatorSet.addListener(new Animator.AnimatorListener() { // from class: id.dana.danapoly.ui.board.view.DanapolyBoardView$movePawn$2
            @Override // android.animation.Animator.AnimatorListener
            public final void onAnimationCancel(Animator p02) {
                Intrinsics.checkNotNullParameter(p02, "");
            }

            @Override // android.animation.Animator.AnimatorListener
            public final void onAnimationRepeat(Animator p02) {
                Intrinsics.checkNotNullParameter(p02, "");
            }

            @Override // android.animation.Animator.AnimatorListener
            public final void onAnimationStart(Animator p02) {
                Intrinsics.checkNotNullParameter(p02, "");
            }

            @Override // android.animation.Animator.AnimatorListener
            public final void onAnimationEnd(Animator p02) {
                PlayModel playModel;
                Intrinsics.checkNotNullParameter(p02, "");
                animatorSet.removeListener(this);
                this.getAuthRequestContext = intRef.element;
                playModel = this.getErrorConfigVersion;
                if (playModel != null) {
                    this.getOnPawnStopMoving().invoke(playModel);
                }
            }
        });
        animatorSet.start();
    }

    private final ObjectAnimator getAuthRequestContext(int p0, PawnMovementType p1) {
        DanapolyBoardCardView danapolyBoardCardView;
        if (p1 == PawnMovementType.FORWARD) {
            if (p0 == 0) {
                danapolyBoardCardView = (DanapolyBoardCardView) ((List) this.moveToNextValue.getValue()).get(15);
            } else {
                danapolyBoardCardView = (DanapolyBoardCardView) ((List) this.moveToNextValue.getValue()).get(p0 - 1);
            }
        } else if (p0 == 15) {
            danapolyBoardCardView = (DanapolyBoardCardView) ((List) this.moveToNextValue.getValue()).get(0);
        } else {
            danapolyBoardCardView = (DanapolyBoardCardView) ((List) this.moveToNextValue.getValue()).get(p0 + 1);
        }
        Intrinsics.checkNotNullExpressionValue(danapolyBoardCardView, "");
        if (((DanapolyBoardCardView) ((List) this.moveToNextValue.getValue()).get(p0)).getY() == danapolyBoardCardView.getY()) {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(getBinding().readMicros, "x", (((DanapolyBoardCardView) ((List) this.moveToNextValue.getValue()).get(p0)).getX() + (((DanapolyBoardCardView) ((List) this.moveToNextValue.getValue()).get(p0)).getWidth() / 2)) - (getBinding().readMicros.getWidth() / 2));
            Intrinsics.checkNotNullExpressionValue(ofFloat, "");
            return ofFloat;
        }
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(getBinding().readMicros, "y", ((DanapolyBoardCardView) ((List) this.moveToNextValue.getValue()).get(p0)).getY() - SizeUtil.MyBillsEntityDataFactory());
        Intrinsics.checkNotNullExpressionValue(ofFloat2, "");
        return ofFloat2;
    }

    public final void setPawnPlayModels(List<PlayModel> results) {
        Intrinsics.checkNotNullParameter(results, "");
        this.lookAheadTest = Intrinsics.areEqual(((PlayModel) CollectionsKt.first((List) results)).getRewardType(), RewardType.TRICK.name());
        this.NetworkUserEntityData$$ExternalSyntheticLambda0.addAll(results);
    }

    public static /* synthetic */ void renderErrorState$default(DanapolyBoardView danapolyBoardView, boolean z, BoardState boardState, int i, Object obj) {
        if ((i & 2) != 0) {
            boardState = BoardState.DEFAULT;
        }
        danapolyBoardView.renderErrorState(z, boardState);
    }

    public final void renderErrorState(boolean isError, BoardState boardState) {
        Intrinsics.checkNotNullParameter(boardState, "");
        if (this.PlaceComponentResult == boardState) {
            return;
        }
        this.PlaceComponentResult = boardState;
        if (!isError) {
            MyBillsEntityDataFactory(true);
        } else {
            Group group = getBinding().newProxyInstance;
            Intrinsics.checkNotNullExpressionValue(group, "");
            group.setVisibility(4);
            ConstraintLayout constraintLayout = getBinding().isLayoutRequested;
            Intrinsics.checkNotNullExpressionValue(constraintLayout, "");
            constraintLayout.setVisibility(4);
        }
        AppCompatImageView appCompatImageView = getBinding().NetworkUserEntityData$$ExternalSyntheticLambda4;
        Intrinsics.checkNotNullExpressionValue(appCompatImageView, "");
        appCompatImageView.setVisibility(0);
        ConstraintLayout constraintLayout2 = getBinding().whenAvailable.KClassImpl$Data$declaredNonStaticMembers$2;
        Intrinsics.checkNotNullExpressionValue(constraintLayout2, "");
        constraintLayout2.setVisibility(isError ? 0 : 8);
    }

    public final boolean isErrorStateShown() {
        ConstraintLayout constraintLayout = getBinding().whenAvailable.KClassImpl$Data$declaredNonStaticMembers$2;
        Intrinsics.checkNotNullExpressionValue(constraintLayout, "");
        return constraintLayout.getVisibility() == 0;
    }

    public final void setOnShowRollDiceResult(OnRollDiceShowListener r2) {
        Intrinsics.checkNotNullParameter(r2, "");
        this.scheduleImpl = r2;
    }

    public final boolean isMovementQueueEmpty() {
        return this.NetworkUserEntityData$$ExternalSyntheticLambda0.isEmpty();
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0017\u0010\u0003\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\tj\u0002\b\n"}, d2 = {"Lid/dana/danapoly/ui/board/view/DanapolyBoardView$PawnMovementType;", "", "", "movement", "Ljava/lang/String;", "getMovement", "()Ljava/lang/String;", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "FORWARD", "BACKWARD"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public enum PawnMovementType {
        FORWARD("FORWARD"),
        BACKWARD("BACKWARD");

        private final String movement;

        PawnMovementType(String str) {
            this.movement = str;
        }

        @JvmName(name = "getMovement")
        public final String getMovement() {
            return this.movement;
        }
    }

    public static /* synthetic */ void $r8$lambda$SJfEKRnv4eNEmI6NOng6VxzBXhw(DanapolyBoardView danapolyBoardView, View view) {
        Intrinsics.checkNotNullParameter(danapolyBoardView, "");
        danapolyBoardView.actionTryAgain.invoke(danapolyBoardView.PlaceComponentResult);
    }

    public static final /* synthetic */ void access$setAndShowRollDiceResult(DanapolyBoardView danapolyBoardView, int i, PawnMovementType pawnMovementType) {
        int i2;
        TextView textView = danapolyBoardView.getBinding().getSupportButtonTintMode;
        Intrinsics.checkNotNullExpressionValue(textView, "");
        textView.setVisibility(0);
        AppCompatImageView appCompatImageView = danapolyBoardView.getBinding().NetworkUserEntityData$$ExternalSyntheticLambda5;
        Intrinsics.checkNotNullExpressionValue(appCompatImageView, "");
        appCompatImageView.setVisibility(0);
        danapolyBoardView.getBinding().SubSequence.cancelAnimation();
        LottieAnimationView lottieAnimationView = danapolyBoardView.getBinding().SubSequence;
        Intrinsics.checkNotNullExpressionValue(lottieAnimationView, "");
        lottieAnimationView.setVisibility(8);
        AppCompatImageView appCompatImageView2 = danapolyBoardView.getBinding().NetworkUserEntityData$$ExternalSyntheticLambda5;
        if (i == 1) {
            i2 = R.drawable.dice_result_1;
        } else if (i == 2) {
            i2 = R.drawable.res_0x7f080646_networkuserentitydata_externalsyntheticlambda2;
        } else if (i == 3) {
            i2 = R.drawable.res_0x7f080647_networkuserentitydata_externalsyntheticlambda1;
        } else if (i == 4) {
            i2 = R.drawable.res_0x7f080648_networkuserentitydata_externalsyntheticlambda8;
        } else if (i == 5) {
            i2 = R.drawable.res_0x7f080649_networkuserentitydata_externalsyntheticlambda7;
        } else {
            i2 = R.drawable.dice_result_6;
        }
        __fsTypeCheck_c52aa2dbefd88c9ae00028cadc29fb43(appCompatImageView2, i2);
        if (pawnMovementType == PawnMovementType.FORWARD) {
            danapolyBoardView.getBinding().getSupportButtonTintMode.setText(danapolyBoardView.getContext().getString(R.string.roll_dice_result_forward, Integer.valueOf(i)));
        }
    }

    public final void changeColor(BackgroundColorType r3) {
        Intrinsics.checkNotNullParameter(r3, "");
        int i = WhenMappings.PlaceComponentResult[r3.ordinal()];
        if (i == 1) {
            this.BuiltInFictitiousFunctionClassFactory = R.color.BuiltInFictitiousFunctionClassFactory_res_0x7f0600c3;
            this.KClassImpl$Data$declaredNonStaticMembers$2 = R.color.lookAheadTest_res_0x7f0600c8;
        } else if (i == 2) {
            this.BuiltInFictitiousFunctionClassFactory = R.color.MyBillsEntityDataFactory_res_0x7f0600c4;
            this.KClassImpl$Data$declaredNonStaticMembers$2 = R.color.res_0x7f0600ca_networkuserentitydata_externalsyntheticlambda0;
        } else if (i == 3) {
            this.BuiltInFictitiousFunctionClassFactory = R.color.scheduleImpl_res_0x7f0600c7;
            this.KClassImpl$Data$declaredNonStaticMembers$2 = R.color.GetContactSyncConfig_res_0x7f0600cd;
        } else if (i == 4) {
            this.BuiltInFictitiousFunctionClassFactory = R.color.PlaceComponentResult_res_0x7f0600c5;
            this.KClassImpl$Data$declaredNonStaticMembers$2 = R.color.getErrorConfigVersion_res_0x7f0600cb;
        } else if (i == 5) {
            this.BuiltInFictitiousFunctionClassFactory = R.color.res_0x7f0600c6_kclassimpl_data_declarednonstaticmembers_2;
            this.KClassImpl$Data$declaredNonStaticMembers$2 = R.color.DatabaseTableConfigUtil;
        }
        Drawable drawable = getBinding().FragmentBottomSheetPaymentSettingBinding.getDrawable();
        GradientDrawable gradientDrawable = drawable instanceof GradientDrawable ? (GradientDrawable) drawable : null;
        if (gradientDrawable != null) {
            gradientDrawable.setColor(ContextCompat.BuiltInFictitiousFunctionClassFactory(getContext(), this.BuiltInFictitiousFunctionClassFactory));
        }
        Iterator it = ((List) this.moveToNextValue.getValue()).iterator();
        while (it.hasNext()) {
            ((DanapolyBoardCardView) it.next()).setBoardColor(this.KClassImpl$Data$declaredNonStaticMembers$2);
        }
    }

    @Override // id.dana.core.ui.BaseViewBindingRichView
    public final void setup() {
        getBinding().whenAvailable.MyBillsEntityDataFactory.setOnClickListener(new View.OnClickListener() { // from class: id.dana.danapoly.ui.board.view.DanapolyBoardView$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DanapolyBoardView.$r8$lambda$SJfEKRnv4eNEmI6NOng6VxzBXhw(DanapolyBoardView.this, view);
            }
        });
    }
}
