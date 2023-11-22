package id.dana.sendmoney_v2.landing.view;

import android.animation.TimeInterpolator;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.animation.DecelerateInterpolator;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.transition.AutoTransition;
import androidx.transition.TransitionManager;
import com.ap.zoloz.hummer.biz.HummerConstants;
import com.ethanhua.skeleton.RecyclerViewSkeletonScreen;
import com.ethanhua.skeleton.Skeleton;
import com.ethanhua.skeleton.SkeletonScreen;
import dagger.internal.Preconditions;
import id.dana.R;
import id.dana.base.BaseActivity;
import id.dana.base.ThrottledOnItemClickListener;
import id.dana.contract.sendmoney.v2.BillerX2BContract;
import id.dana.core.ui.BaseViewBindingRichView;
import id.dana.databinding.ViewTransactionRecentBinding;
import id.dana.di.ComponentHolder;
import id.dana.di.component.ApplicationComponent;
import id.dana.di.modules.BillerX2BModule;
import id.dana.di.modules.UserConfigModule;
import id.dana.dialog.BillerX2BDialog;
import id.dana.sendmoney.bank.AddReceiverDialogFragment;
import id.dana.sendmoney.model.RecentRecipientModel;
import id.dana.sendmoney.model.RecipientModel;
import id.dana.sendmoney.recipient.RecipientIdType;
import id.dana.sendmoney.recipient.recent.RecentRecipientContract;
import id.dana.sendmoney.recipient.recent.RecentRecipientModule;
import id.dana.sendmoney.ui.groupsend.summary.activity.GroupSendSummaryActivity;
import id.dana.sendmoney.ui.groupsend.summary.model.GroupSendIntentModel;
import id.dana.sendmoney_v2.landing.SendMoneyActivity;
import id.dana.sendmoney_v2.landing.adapter.RecentTransactionAdapter;
import id.dana.sendmoney_v2.landing.di.component.DaggerRecentTransactionComponent;
import id.dana.sendmoney_v2.landing.di.module.SendMoneyTrackerModule;
import id.dana.sendmoney_v2.landing.view.RecentTransactionView;
import id.dana.sendmoney_v2.landing.viewholder.recent.TransactionViewHolder;
import id.dana.sendmoney_v2.model.BillerX2BModel;
import id.dana.sendmoney_v2.recipient.activity.SearchRecipientActivity;
import id.dana.sendmoney_v2.tracker.SendMoneyAnalyticTracker;
import id.dana.showcase.AbstractOnShowcaseStateListener;
import id.dana.showcase.Showcase;
import id.dana.showcase.SkipShowCaseBuilder;
import id.dana.showcase.shape.RectangleShape;
import id.dana.showcase.target.Target;
import id.dana.showcase.target.TargetBuilder;
import id.dana.userconfig.UserConfigContract;
import id.dana.utils.SizeUtil;
import io.reactivex.disposables.Disposable;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000¨\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\u0018\u0000 s2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0003stuB'\b\u0016\u0012\u0006\u0010\u001e\u001a\u00020\u001d\u0012\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u001f\u0012\b\b\u0002\u0010n\u001a\u00020\u000b¢\u0006\u0004\bo\u0010pB+\b\u0016\u0012\u0006\u0010\u001e\u001a\u00020\u001d\u0012\b\u0010 \u001a\u0004\u0018\u00010\u001f\u0012\u0006\u0010n\u001a\u00020\u000b\u0012\u0006\u0010q\u001a\u00020\u000b¢\u0006\u0004\bo\u0010rJ+\u0010\t\u001a\u0006*\u00020\b0\b2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\f\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0015\u001a\u00020\u00142\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0017\u001a\u00020\u0014H\u0014¢\u0006\u0004\b\u0017\u0010\u0018J\u0015\u0010\u001a\u001a\u00020\u00142\u0006\u0010\u0019\u001a\u00020\u0005¢\u0006\u0004\b\u001a\u0010\u001bJ\r\u0010\u001c\u001a\u00020\u0014¢\u0006\u0004\b\u001c\u0010\u0018J#\u0010!\u001a\u00020\u00142\b\u0010\u001e\u001a\u0004\u0018\u00010\u001d2\b\u0010 \u001a\u0004\u0018\u00010\u001fH\u0014¢\u0006\u0004\b!\u0010\"J\u0015\u0010%\u001a\u00020\u00142\u0006\u0010$\u001a\u00020#¢\u0006\u0004\b%\u0010&J\u0015\u0010)\u001a\u00020\u00142\u0006\u0010(\u001a\u00020'¢\u0006\u0004\b)\u0010*J\u000f\u0010+\u001a\u00020\u0014H\u0016¢\u0006\u0004\b+\u0010\u0018J\r\u0010,\u001a\u00020\u0014¢\u0006\u0004\b,\u0010\u0018J\u0017\u0010\t\u001a\u00020\u00142\u0006\u0010\u0004\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\t\u0010-J\r\u0010.\u001a\u00020\u0014¢\u0006\u0004\b.\u0010\u0018R\"\u00100\u001a\u00020/8\u0007@\u0007X\u0087.¢\u0006\u0012\n\u0004\b0\u00101\u001a\u0004\b2\u00103\"\u0004\b4\u00105R\u0018\u00109\u001a\u0004\u0018\u0001068\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b7\u00108R\u0016\u0010\t\u001a\u00020#8\u0002@\u0002X\u0083.¢\u0006\u0006\n\u0004\b9\u0010:R\"\u0010>\u001a\u00020;8\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b<\u0010=\u001a\u0004\b>\u0010?\"\u0004\b@\u0010AR5\u0010J\u001a\u0015\u0012\u000b\u0012\t\u0018\u00010\b¢\u0006\u0002\bC\u0012\u0004\u0012\u00020\u00140B8\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\bD\u0010E\u001a\u0004\bF\u0010G\"\u0004\bH\u0010IR\u0016\u00107\u001a\u00020K8\u0002@\u0002X\u0083.¢\u0006\u0006\n\u0004\b\t\u0010LR\"\u0010N\u001a\u00020M8\u0007@\u0007X\u0087.¢\u0006\u0012\n\u0004\bN\u0010O\u001a\u0004\bP\u0010Q\"\u0004\bR\u0010SR\u0018\u0010D\u001a\u0004\u0018\u00010T8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\bU\u0010VR\u0016\u0010<\u001a\u00020'8\u0002@\u0002X\u0083.¢\u0006\u0006\n\u0004\bW\u0010XR\u0016\u0010Y\u001a\u00020\u000b8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\bY\u0010ZR\u0016\u0010[\u001a\u00020\u00058\u0002@\u0002X\u0083.¢\u0006\u0006\n\u0004\b[\u0010\\R\"\u0010^\u001a\u00020]8\u0007@\u0007X\u0087.¢\u0006\u0012\n\u0004\b^\u0010_\u001a\u0004\b`\u0010a\"\u0004\bb\u0010cR\u0018\u0010e\u001a\u0004\u0018\u00010d8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\be\u0010fR\"\u0010h\u001a\u00020g8\u0007@\u0007X\u0087.¢\u0006\u0012\n\u0004\bh\u0010i\u001a\u0004\bj\u0010k\"\u0004\bl\u0010m"}, d2 = {"Lid/dana/sendmoney_v2/landing/view/RecentTransactionView;", "Lid/dana/core/ui/BaseViewBindingRichView;", "Lid/dana/databinding/ViewTransactionRecentBinding;", "", "p0", "Lid/dana/sendmoney/model/RecentRecipientModel;", "p1", "p2", "Lid/dana/sendmoney/model/RecipientModel;", "KClassImpl$Data$declaredNonStaticMembers$2", "(Ljava/lang/String;Lid/dana/sendmoney/model/RecentRecipientModel;Ljava/lang/String;)Lid/dana/sendmoney/model/RecipientModel;", "", "getCurrentFavoriteAccountCount", "()Ljava/lang/Integer;", "getLeastTransactionFavoriteAccount", "()Lid/dana/sendmoney/model/RecentRecipientModel;", "inflateViewBinding", "()Lid/dana/databinding/ViewTransactionRecentBinding;", "Lid/dana/di/component/ApplicationComponent;", "applicationComponent", "", "injectComponent", "(Lid/dana/di/component/ApplicationComponent;)V", "onDetachedFromWindow", "()V", "recentRecipientModel", "onItemClicked", "(Lid/dana/sendmoney/model/RecentRecipientModel;)V", "openSearchRecipient", "Landroid/content/Context;", HummerConstants.CONTEXT, "Landroid/util/AttributeSet;", "attrs", "parseAttrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "Lid/dana/sendmoney_v2/landing/view/RecentTransactionView$GestureHoldClickListener;", "gestureHoldClickListener", "setOnGestureHoldLongClickListener", "(Lid/dana/sendmoney_v2/landing/view/RecentTransactionView$GestureHoldClickListener;)V", "Lid/dana/sendmoney_v2/landing/view/RecentTransactionView$RecentTransactionClickListener;", "recentTransactionClickListener", "setRecentTransactionClickListener", "(Lid/dana/sendmoney_v2/landing/view/RecentTransactionView$RecentTransactionClickListener;)V", "setup", "showTooltip", "(Ljava/lang/String;)V", "updateRecentTransaction", "Lid/dana/contract/sendmoney/v2/BillerX2BContract$Presenter;", "billerX2BPresenter", "Lid/dana/contract/sendmoney/v2/BillerX2BContract$Presenter;", "getBillerX2BPresenter", "()Lid/dana/contract/sendmoney/v2/BillerX2BContract$Presenter;", "setBillerX2BPresenter", "(Lid/dana/contract/sendmoney/v2/BillerX2BContract$Presenter;)V", "Lio/reactivex/disposables/Disposable;", "PlaceComponentResult", "Lio/reactivex/disposables/Disposable;", "BuiltInFictitiousFunctionClassFactory", "Lid/dana/sendmoney_v2/landing/view/RecentTransactionView$GestureHoldClickListener;", "", "getAuthRequestContext", "Z", "isRecentTransactionEmpty", "()Z", "setRecentTransactionEmpty", "(Z)V", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "MyBillsEntityDataFactory", "Lkotlin/jvm/functions/Function1;", "getOnRecipientSelected", "()Lkotlin/jvm/functions/Function1;", "setOnRecipientSelected", "(Lkotlin/jvm/functions/Function1;)V", "onRecipientSelected", "Lcom/ethanhua/skeleton/SkeletonScreen;", "Lcom/ethanhua/skeleton/SkeletonScreen;", "Lid/dana/sendmoney/recipient/recent/RecentRecipientContract$Presenter;", "recentRecipientPresenter", "Lid/dana/sendmoney/recipient/recent/RecentRecipientContract$Presenter;", "getRecentRecipientPresenter", "()Lid/dana/sendmoney/recipient/recent/RecentRecipientContract$Presenter;", "setRecentRecipientPresenter", "(Lid/dana/sendmoney/recipient/recent/RecentRecipientContract$Presenter;)V", "Lid/dana/sendmoney_v2/landing/adapter/RecentTransactionAdapter;", "lookAheadTest", "Lid/dana/sendmoney_v2/landing/adapter/RecentTransactionAdapter;", "NetworkUserEntityData$$ExternalSyntheticLambda0", "Lid/dana/sendmoney_v2/landing/view/RecentTransactionView$RecentTransactionClickListener;", "scheduleImpl", "I", "moveToNextValue", "Lid/dana/sendmoney/model/RecentRecipientModel;", "Lid/dana/sendmoney_v2/tracker/SendMoneyAnalyticTracker;", "sendMoneyAnalyticTracker", "Lid/dana/sendmoney_v2/tracker/SendMoneyAnalyticTracker;", "getSendMoneyAnalyticTracker", "()Lid/dana/sendmoney_v2/tracker/SendMoneyAnalyticTracker;", "setSendMoneyAnalyticTracker", "(Lid/dana/sendmoney_v2/tracker/SendMoneyAnalyticTracker;)V", "Lid/dana/showcase/Showcase;", "getErrorConfigVersion", "Lid/dana/showcase/Showcase;", "Lid/dana/userconfig/UserConfigContract$Presenter;", "userConfigPresenter", "Lid/dana/userconfig/UserConfigContract$Presenter;", "getUserConfigPresenter", "()Lid/dana/userconfig/UserConfigContract$Presenter;", "setUserConfigPresenter", "(Lid/dana/userconfig/UserConfigContract$Presenter;)V", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "Companion", "GestureHoldClickListener", "RecentTransactionClickListener"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class RecentTransactionView extends BaseViewBindingRichView<ViewTransactionRecentBinding> {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    private GestureHoldClickListener KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    private SkeletonScreen PlaceComponentResult;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private Function1<? super RecipientModel, Unit> onRecipientSelected;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda0  reason: from kotlin metadata */
    private RecentTransactionClickListener getAuthRequestContext;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private Disposable BuiltInFictitiousFunctionClassFactory;
    public Map<Integer, View> _$_findViewCache;
    @Inject
    public BillerX2BContract.Presenter billerX2BPresenter;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    private boolean isRecentTransactionEmpty;
    private Showcase getErrorConfigVersion;

    /* renamed from: lookAheadTest  reason: from kotlin metadata */
    private RecentTransactionAdapter MyBillsEntityDataFactory;
    private RecentRecipientModel moveToNextValue;
    @Inject
    public RecentRecipientContract.Presenter recentRecipientPresenter;
    private int scheduleImpl;
    @Inject
    public SendMoneyAnalyticTracker sendMoneyAnalyticTracker;
    @Inject
    public UserConfigContract.Presenter userConfigPresenter;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/sendmoney_v2/landing/view/RecentTransactionView$GestureHoldClickListener;", "", "Lid/dana/sendmoney/model/RecentRecipientModel;", "p0", "", "BuiltInFictitiousFunctionClassFactory", "(Lid/dana/sendmoney/model/RecentRecipientModel;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public interface GestureHoldClickListener {
        void BuiltInFictitiousFunctionClassFactory(RecentRecipientModel p0);
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H&¢\u0006\u0004\b\u0007\u0010\bø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/sendmoney_v2/landing/view/RecentTransactionView$RecentTransactionClickListener;", "", "Lid/dana/sendmoney/model/RecentRecipientModel;", "p0", "", "BuiltInFictitiousFunctionClassFactory", "(Lid/dana/sendmoney/model/RecentRecipientModel;)V", "getAuthRequestContext", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public interface RecentTransactionClickListener {
        void BuiltInFictitiousFunctionClassFactory(RecentRecipientModel p0);

        void getAuthRequestContext();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public RecentTransactionView(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public RecentTransactionView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "");
    }

    @Override // id.dana.core.ui.BaseViewBindingRichView
    public final void _$_clearFindViewByIdCache() {
        this._$_findViewCache.clear();
    }

    @Override // id.dana.core.ui.BaseViewBindingRichView
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

    @Override // id.dana.core.ui.BaseViewBindingRichView
    public final ViewTransactionRecentBinding inflateViewBinding() {
        ViewTransactionRecentBinding authRequestContext = ViewTransactionRecentBinding.getAuthRequestContext(LayoutInflater.from(getContext()));
        Intrinsics.checkNotNullExpressionValue(authRequestContext, "");
        return authRequestContext;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RecentTransactionView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "");
        this._$_findViewCache = new LinkedHashMap();
        this.scheduleImpl = 3;
        this.isRecentTransactionEmpty = true;
        this.onRecipientSelected = RecentTransactionView$onRecipientSelected$1.INSTANCE;
    }

    public /* synthetic */ RecentTransactionView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RecentTransactionView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        Intrinsics.checkNotNullParameter(context, "");
        this._$_findViewCache = new LinkedHashMap();
        this.scheduleImpl = 3;
        this.isRecentTransactionEmpty = true;
        this.onRecipientSelected = RecentTransactionView$onRecipientSelected$1.INSTANCE;
    }

    @JvmName(name = "getRecentRecipientPresenter")
    public final RecentRecipientContract.Presenter getRecentRecipientPresenter() {
        RecentRecipientContract.Presenter presenter = this.recentRecipientPresenter;
        if (presenter != null) {
            return presenter;
        }
        Intrinsics.throwUninitializedPropertyAccessException("");
        return null;
    }

    @JvmName(name = "setRecentRecipientPresenter")
    public final void setRecentRecipientPresenter(RecentRecipientContract.Presenter presenter) {
        Intrinsics.checkNotNullParameter(presenter, "");
        this.recentRecipientPresenter = presenter;
    }

    @JvmName(name = "getBillerX2BPresenter")
    public final BillerX2BContract.Presenter getBillerX2BPresenter() {
        BillerX2BContract.Presenter presenter = this.billerX2BPresenter;
        if (presenter != null) {
            return presenter;
        }
        Intrinsics.throwUninitializedPropertyAccessException("");
        return null;
    }

    @JvmName(name = "setBillerX2BPresenter")
    public final void setBillerX2BPresenter(BillerX2BContract.Presenter presenter) {
        Intrinsics.checkNotNullParameter(presenter, "");
        this.billerX2BPresenter = presenter;
    }

    @JvmName(name = "getUserConfigPresenter")
    public final UserConfigContract.Presenter getUserConfigPresenter() {
        UserConfigContract.Presenter presenter = this.userConfigPresenter;
        if (presenter != null) {
            return presenter;
        }
        Intrinsics.throwUninitializedPropertyAccessException("");
        return null;
    }

    @JvmName(name = "setUserConfigPresenter")
    public final void setUserConfigPresenter(UserConfigContract.Presenter presenter) {
        Intrinsics.checkNotNullParameter(presenter, "");
        this.userConfigPresenter = presenter;
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

    @JvmName(name = "isRecentTransactionEmpty")
    /* renamed from: isRecentTransactionEmpty  reason: from getter */
    public final boolean getIsRecentTransactionEmpty() {
        return this.isRecentTransactionEmpty;
    }

    @JvmName(name = "setRecentTransactionEmpty")
    public final void setRecentTransactionEmpty(boolean z) {
        this.isRecentTransactionEmpty = z;
    }

    @JvmName(name = "getOnRecipientSelected")
    public final Function1<RecipientModel, Unit> getOnRecipientSelected() {
        return this.onRecipientSelected;
    }

    @JvmName(name = "setOnRecipientSelected")
    public final void setOnRecipientSelected(Function1<? super RecipientModel, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "");
        this.onRecipientSelected = function1;
    }

    @Override // id.dana.core.ui.BaseViewBindingRichView
    public final void parseAttrs(Context context, AttributeSet attrs) {
        if (attrs != null) {
            TypedArray obtainStyledAttributes = context != null ? context.obtainStyledAttributes(attrs, R.styleable.DaggerDanaProtectionWidgetComponent$DanaProtectionWidgetComponentImpl$ProvideEventTrackerQueueProvider) : null;
            try {
                TypedValue typedValue = new TypedValue();
                if (obtainStyledAttributes != null) {
                    obtainStyledAttributes.getValue(0, typedValue);
                }
                this.scheduleImpl = typedValue.data;
            } finally {
                if (obtainStyledAttributes != null) {
                    obtainStyledAttributes.recycle();
                }
            }
        }
    }

    public final void injectComponent(ApplicationComponent applicationComponent) {
        DaggerRecentTransactionComponent.Builder MyBillsEntityDataFactory = DaggerRecentTransactionComponent.MyBillsEntityDataFactory();
        MyBillsEntityDataFactory.MyBillsEntityDataFactory = (ApplicationComponent) Preconditions.getAuthRequestContext(applicationComponent);
        MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2 = (RecentRecipientModule) Preconditions.getAuthRequestContext(new RecentRecipientModule(new RecentRecipientContract.View() { // from class: id.dana.sendmoney_v2.landing.view.RecentTransactionView$recentRecipientModule$1
            @Override // id.dana.sendmoney.recipient.recent.RecentRecipientContract.View
            public final void MyBillsEntityDataFactory(List<RecentRecipientModel> p0) {
            }

            @Override // id.dana.sendmoney.recipient.recent.RecentRecipientContract.View
            public final void getAuthRequestContext(List<RecentRecipientModel> p0) {
            }

            @Override // id.dana.sendmoney.recipient.recent.RecentRecipientContract.View
            public final void KClassImpl$Data$declaredNonStaticMembers$2(List<RecentRecipientModel> p0) {
                RecentTransactionAdapter recentTransactionAdapter;
                recentTransactionAdapter = RecentTransactionView.this.MyBillsEntityDataFactory;
                if (recentTransactionAdapter != null) {
                    recentTransactionAdapter.setItems(p0 == null ? CollectionsKt.emptyList() : p0);
                }
                RecentTransactionView.access$updateShowMoreView(RecentTransactionView.this);
                if (p0 != null && p0.size() > 0) {
                    RecentTransactionView.this.setRecentTransactionEmpty(false);
                }
                RecentTransactionView.access$hideSendMoneyQuickSendShimmer(RecentTransactionView.this);
            }

            @Override // id.dana.sendmoney.recipient.recent.RecentRecipientContract.View
            public final void PlaceComponentResult(boolean p0) {
                if (p0) {
                    RecentTransactionView.this.getRecentRecipientPresenter().getAuthRequestContext("");
                } else {
                    RecentTransactionView.this.getUserConfigPresenter().KClassImpl$Data$declaredNonStaticMembers$2();
                }
            }
        }));
        MyBillsEntityDataFactory.getAuthRequestContext = (BillerX2BModule) Preconditions.getAuthRequestContext(new BillerX2BModule(new RecentTransactionView$billerX2BModule$1(this)));
        MyBillsEntityDataFactory.BuiltInFictitiousFunctionClassFactory = (UserConfigModule) Preconditions.getAuthRequestContext(new UserConfigModule(new UserConfigContract.View() { // from class: id.dana.sendmoney_v2.landing.view.RecentTransactionView$userConfigModule$1
            @Override // id.dana.base.AbstractContract.AbstractView
            public final void dismissProgress() {
            }

            @Override // id.dana.base.AbstractContract.AbstractView
            public final void onError(String p0) {
            }

            @Override // id.dana.base.AbstractContract.AbstractView
            public final void showProgress() {
            }

            @Override // id.dana.userconfig.UserConfigContract.View
            public final void KClassImpl$Data$declaredNonStaticMembers$2() {
                RecentTransactionView.this.getRecentRecipientPresenter().getAuthRequestContext("");
            }
        }));
        Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2, RecentRecipientModule.class);
        Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(MyBillsEntityDataFactory.getAuthRequestContext, BillerX2BModule.class);
        if (MyBillsEntityDataFactory.PlaceComponentResult == null) {
            MyBillsEntityDataFactory.PlaceComponentResult = new SendMoneyTrackerModule();
        }
        Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(MyBillsEntityDataFactory.BuiltInFictitiousFunctionClassFactory, UserConfigModule.class);
        Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(MyBillsEntityDataFactory.MyBillsEntityDataFactory, ApplicationComponent.class);
        new DaggerRecentTransactionComponent.RecentTransactionComponentImpl(MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2, MyBillsEntityDataFactory.getAuthRequestContext, MyBillsEntityDataFactory.PlaceComponentResult, MyBillsEntityDataFactory.BuiltInFictitiousFunctionClassFactory, MyBillsEntityDataFactory.MyBillsEntityDataFactory, (byte) 0).PlaceComponentResult(this);
    }

    @Override // id.dana.core.ui.BaseViewBindingRichView
    public final void setup() {
        injectComponent(ComponentHolder.getAuthRequestContext());
        RecyclerView recyclerView = getBinding().PlaceComponentResult;
        boolean z = false;
        final RecentTransactionAdapter recentTransactionAdapter = new RecentTransactionAdapter(4, z, 2, null);
        final RecentTransactionAdapter recentTransactionAdapter2 = recentTransactionAdapter;
        final GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 4);
        gridLayoutManager.moveToNextValue = new GridLayoutManager.SpanSizeLookup() { // from class: id.dana.sendmoney_v2.landing.view.RecentTransactionView$getGridLayoutManager$1$1
            @Override // androidx.recyclerview.widget.GridLayoutManager.SpanSizeLookup
            public final int PlaceComponentResult(int p0) {
                int itemViewType = recentTransactionAdapter2.getItemViewType(p0);
                if (itemViewType == -2 || itemViewType == -1 || itemViewType == 1) {
                    return gridLayoutManager.getErrorConfigVersion;
                }
                return 1;
            }
        };
        recyclerView.setLayoutManager(gridLayoutManager);
        this.MyBillsEntityDataFactory = recentTransactionAdapter;
        recyclerView.setAdapter(recentTransactionAdapter2);
        recentTransactionAdapter.setOnItemClickListener(new ThrottledOnItemClickListener(0L, new Function1<Integer, Unit>() { // from class: id.dana.sendmoney_v2.landing.view.RecentTransactionView$setupRecyclerView$1$1$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* synthetic */ Unit invoke(Integer num) {
                invoke(num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(int i) {
                RecentTransactionView.RecentTransactionClickListener recentTransactionClickListener;
                RecentRecipientModel item = RecentTransactionAdapter.this.getItem(i);
                if (item != null) {
                    recentTransactionClickListener = this.getAuthRequestContext;
                    if (recentTransactionClickListener == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("");
                        recentTransactionClickListener = null;
                    }
                    recentTransactionClickListener.BuiltInFictitiousFunctionClassFactory(item);
                }
            }
        }, 1, null));
        RecentTransactionView$setupRecyclerView$1$1$2 recentTransactionView$setupRecyclerView$1$1$2 = new RecentTransactionView$setupRecyclerView$1$1$2(this);
        Intrinsics.checkNotNullParameter(recentTransactionView$setupRecyclerView$1$1$2, "");
        recentTransactionAdapter.getAuthRequestContext = recentTransactionView$setupRecyclerView$1$1$2;
        recentTransactionAdapter.KClassImpl$Data$declaredNonStaticMembers$2 = new RecipientHoldClickActionListener() { // from class: id.dana.sendmoney_v2.landing.view.RecentTransactionView$getRecipientHoldClickActionListener$1
            @Override // id.dana.sendmoney_v2.landing.view.RecipientHoldClickActionListener
            public final void PlaceComponentResult(RecentRecipientModel p0) {
                Intrinsics.checkNotNullParameter(p0, "");
                Context context = RecentTransactionView.this.getContext();
                if (context == null) {
                    throw new NullPointerException("null cannot be cast to non-null type id.dana.sendmoney_v2.landing.SendMoneyActivity");
                }
                ((SendMoneyActivity) context).showManageAccountBottomSheet(p0);
            }
        };
        getBinding().KClassImpl$Data$declaredNonStaticMembers$2.setOnClickListener(new View.OnClickListener() { // from class: id.dana.sendmoney_v2.landing.view.RecentTransactionView$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                RecentTransactionView.$r8$lambda$dEhc6F5uzy2EN9aYKLVKTxscXbU(RecentTransactionView.this, view);
            }
        });
        RecyclerViewSkeletonScreen.Builder BuiltInFictitiousFunctionClassFactory = Skeleton.BuiltInFictitiousFunctionClassFactory(getBinding().PlaceComponentResult);
        BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory = R.layout.view_skeleton_x2x_quick_send;
        BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2 = this.MyBillsEntityDataFactory;
        BuiltInFictitiousFunctionClassFactory.NetworkUserEntityData$$ExternalSyntheticLambda0 = 1500;
        BuiltInFictitiousFunctionClassFactory.PlaceComponentResult = true;
        BuiltInFictitiousFunctionClassFactory.getErrorConfigVersion = ContextCompat.BuiltInFictitiousFunctionClassFactory(BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory.getContext(), R.color.f27082131100491);
        BuiltInFictitiousFunctionClassFactory.lookAheadTest = 20;
        BuiltInFictitiousFunctionClassFactory.getAuthRequestContext = 1;
        RecyclerViewSkeletonScreen recyclerViewSkeletonScreen = new RecyclerViewSkeletonScreen(BuiltInFictitiousFunctionClassFactory, z ? (byte) 1 : (byte) 0);
        recyclerViewSkeletonScreen.MyBillsEntityDataFactory();
        Intrinsics.checkNotNullExpressionValue(recyclerViewSkeletonScreen, "");
        this.PlaceComponentResult = recyclerViewSkeletonScreen;
        getRecentRecipientPresenter().KClassImpl$Data$declaredNonStaticMembers$2();
        AppCompatTextView appCompatTextView = getBinding().MyBillsEntityDataFactory;
        Intrinsics.checkNotNullExpressionValue(appCompatTextView, "");
        appCompatTextView.setOnClickListener(new View.OnClickListener() { // from class: id.dana.sendmoney_v2.landing.view.RecentTransactionView$$ExternalSyntheticLambda4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                RecentTransactionView.$r8$lambda$qfObVMeCY7ox3cwgfcDpFRlRsZ0(RecentTransactionView.this, view);
            }
        });
    }

    public final void openSearchRecipient() {
        getContext().startActivity(new Intent(getContext(), SearchRecipientActivity.class));
    }

    public final void setRecentTransactionClickListener(RecentTransactionClickListener recentTransactionClickListener) {
        Intrinsics.checkNotNullParameter(recentTransactionClickListener, "");
        this.getAuthRequestContext = recentTransactionClickListener;
    }

    public final void onItemClicked(RecentRecipientModel recentRecipientModel) {
        Intrinsics.checkNotNullParameter(recentRecipientModel, "");
        this.moveToNextValue = recentRecipientModel;
        int i = recentRecipientModel.isLayoutRequested;
        if (i == 2) {
            RecipientModel KClassImpl$Data$declaredNonStaticMembers$2 = KClassImpl$Data$declaredNonStaticMembers$2("contact", recentRecipientModel, "userid");
            Function1<? super RecipientModel, Unit> function1 = this.onRecipientSelected;
            Intrinsics.checkNotNullExpressionValue(KClassImpl$Data$declaredNonStaticMembers$2, "");
            function1.invoke(KClassImpl$Data$declaredNonStaticMembers$2);
            KClassImpl$Data$declaredNonStaticMembers$2("phonenumber");
        } else if (i == 7) {
            String KClassImpl$Data$declaredNonStaticMembers$22 = recentRecipientModel.KClassImpl$Data$declaredNonStaticMembers$2();
            Intrinsics.checkNotNullExpressionValue(KClassImpl$Data$declaredNonStaticMembers$22, "");
            String name = SendMoneyActivity.class.getName();
            Intrinsics.checkNotNullExpressionValue(name, "");
            GroupSendIntentModel groupSendIntentModel = new GroupSendIntentModel(name, null, null, KClassImpl$Data$declaredNonStaticMembers$22, null, null, null, false, 246, null);
            Context context = getContext();
            GroupSendSummaryActivity.Companion companion = GroupSendSummaryActivity.INSTANCE;
            context.startActivity(GroupSendSummaryActivity.Companion.getAuthRequestContext(groupSendIntentModel, "Quick Send", getContext()));
            KClassImpl$Data$declaredNonStaticMembers$2("group");
        } else if (i == 4) {
            RecipientModel KClassImpl$Data$declaredNonStaticMembers$23 = KClassImpl$Data$declaredNonStaticMembers$2("bank", recentRecipientModel, RecipientIdType.INSTITUTION);
            Function1<? super RecipientModel, Unit> function12 = this.onRecipientSelected;
            Intrinsics.checkNotNullExpressionValue(KClassImpl$Data$declaredNonStaticMembers$23, "");
            function12.invoke(KClassImpl$Data$declaredNonStaticMembers$23);
            KClassImpl$Data$declaredNonStaticMembers$2("bank");
        } else if (i == 5) {
            Context context2 = getContext();
            if (context2 == null) {
                throw new NullPointerException("null cannot be cast to non-null type id.dana.base.BaseActivity");
            }
            AddReceiverDialogFragment addReceiverDialogFragment = new AddReceiverDialogFragment();
            addReceiverDialogFragment.scheduleImpl = new AddReceiverDialogFragment.OnAddReceiverInformation() { // from class: id.dana.sendmoney_v2.landing.view.RecentTransactionView$$ExternalSyntheticLambda0
                @Override // id.dana.sendmoney.bank.AddReceiverDialogFragment.OnAddReceiverInformation
                public final void KClassImpl$Data$declaredNonStaticMembers$2(RecipientModel recipientModel) {
                    RecentTransactionView.$r8$lambda$FsOhFK4U1VrTQXTnuAazwEU3sBY(RecentTransactionView.this, recipientModel);
                }
            };
            addReceiverDialogFragment.show(((BaseActivity) context2).getSupportFragmentManager(), "Custom Bottom Sheet");
        }
    }

    private static RecipientModel KClassImpl$Data$declaredNonStaticMembers$2(String p0, RecentRecipientModel p1, String p2) {
        RecipientModel.Builder builder = new RecipientModel.Builder(p0);
        builder.PlaceComponentResult = p1.getAuthRequestContext;
        builder.PrepareContext = p2;
        builder.scheduleImpl = p1.KClassImpl$Data$declaredNonStaticMembers$2();
        builder.initRecordTimeStamp = p1.PlaceComponentResult();
        builder.GetContactSyncConfig = p1.getErrorConfigVersion;
        String BuiltInFictitiousFunctionClassFactory = p1.BuiltInFictitiousFunctionClassFactory();
        if (BuiltInFictitiousFunctionClassFactory == null) {
            BuiltInFictitiousFunctionClassFactory = "";
        }
        builder.getErrorConfigVersion = BuiltInFictitiousFunctionClassFactory;
        builder.NetworkUserEntityData$$ExternalSyntheticLambda3 = p1.initRecordTimeStamp;
        builder.lookAheadTest = p1.BuiltInFictitiousFunctionClassFactory;
        builder.NetworkUserEntityData$$ExternalSyntheticLambda1 = p1.NetworkUserEntityData$$ExternalSyntheticLambda2;
        builder.DatabaseTableConfigUtil = p1.DatabaseTableConfigUtil;
        builder.getAuthRequestContext = p1.getAuthRequestContext();
        builder.FragmentBottomSheetPaymentSettingBinding = p1.NetworkUserEntityData$$ExternalSyntheticLambda1;
        builder.moveToNextValue = p1.getErrorConfigVersion();
        builder.isLayoutRequested = p1.NetworkUserEntityData$$ExternalSyntheticLambda0();
        builder.newProxyInstance = "Quick Send";
        builder.NetworkUserEntityData$$ExternalSyntheticLambda2 = p1.MyBillsEntityDataFactory();
        return builder.KClassImpl$Data$declaredNonStaticMembers$2();
    }

    private final void KClassImpl$Data$declaredNonStaticMembers$2(String p0) {
        SendMoneyAnalyticTracker sendMoneyAnalyticTracker = getSendMoneyAnalyticTracker();
        RecentRecipientModel recentRecipientModel = this.moveToNextValue;
        if (recentRecipientModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            recentRecipientModel = null;
        }
        sendMoneyAnalyticTracker.KClassImpl$Data$declaredNonStaticMembers$2(p0, true, Boolean.valueOf(recentRecipientModel.getErrorConfigVersion()));
    }

    public final void showTooltip() {
        View findViewById;
        if (this.isRecentTransactionEmpty) {
            return;
        }
        RecyclerView.ViewHolder findViewHolderForLayoutPosition = getBinding().PlaceComponentResult.findViewHolderForLayoutPosition(0);
        if (findViewHolderForLayoutPosition != null) {
            TransactionViewHolder transactionViewHolder = (TransactionViewHolder) findViewHolderForLayoutPosition;
            if (transactionViewHolder == null || (findViewById = transactionViewHolder.itemView.findViewById(R.id.clRecenTransactionViewHolder)) == null) {
                findViewById = null;
            }
            if (findViewById == null || this.getErrorConfigVersion != null) {
                return;
            }
            Context context = getContext();
            if (context == null) {
                throw new NullPointerException("null cannot be cast to non-null type id.dana.base.BaseActivity");
            }
            SkipShowCaseBuilder skipShowCaseBuilder = new SkipShowCaseBuilder((BaseActivity) context);
            Context context2 = getContext();
            if (context2 == null) {
                throw new NullPointerException("null cannot be cast to non-null type id.dana.base.BaseActivity");
            }
            Target KClassImpl$Data$declaredNonStaticMembers$2 = new TargetBuilder((BaseActivity) context2).BuiltInFictitiousFunctionClassFactory(new RectangleShape(findViewById, SizeUtil.getAuthRequestContext(4), SizeUtil.getAuthRequestContext(4), SizeUtil.getAuthRequestContext(2), SizeUtil.getAuthRequestContext(2), SizeUtil.getAuthRequestContext(2), SizeUtil.getAuthRequestContext(2))).BuiltInFictitiousFunctionClassFactory().BuiltInFictitiousFunctionClassFactory(findViewById).KClassImpl$Data$declaredNonStaticMembers$2();
            ViewGroup.MarginLayoutParams marginLayoutParams = new ViewGroup.MarginLayoutParams(-1, -2);
            double d = KClassImpl$Data$declaredNonStaticMembers$2.lookAheadTest.x;
            double PlaceComponentResult = KClassImpl$Data$declaredNonStaticMembers$2.NetworkUserEntityData$$ExternalSyntheticLambda0.PlaceComponentResult();
            Double.isNaN(PlaceComponentResult);
            Double.isNaN(d);
            double d2 = KClassImpl$Data$declaredNonStaticMembers$2.lookAheadTest.y;
            double KClassImpl$Data$declaredNonStaticMembers$22 = KClassImpl$Data$declaredNonStaticMembers$2.NetworkUserEntityData$$ExternalSyntheticLambda0.KClassImpl$Data$declaredNonStaticMembers$2();
            Double.isNaN(KClassImpl$Data$declaredNonStaticMembers$22);
            Double.isNaN(d2);
            marginLayoutParams.setMargins((int) (d - (PlaceComponentResult * 0.5d)), (int) (d2 - (KClassImpl$Data$declaredNonStaticMembers$22 * 0.3d)), 0, 0);
            KClassImpl$Data$declaredNonStaticMembers$2.scheduleImpl.setLayoutParams(marginLayoutParams);
            KClassImpl$Data$declaredNonStaticMembers$2.scheduleImpl.setOnLongClickListener(new View.OnLongClickListener() { // from class: id.dana.sendmoney_v2.landing.view.RecentTransactionView$$ExternalSyntheticLambda2
                @Override // android.view.View.OnLongClickListener
                public final boolean onLongClick(View view) {
                    boolean PlaceComponentResult2;
                    PlaceComponentResult2 = RecentTransactionView.PlaceComponentResult(RecentTransactionView.this);
                    return PlaceComponentResult2;
                }
            });
            skipShowCaseBuilder.NetworkUserEntityData$$ExternalSyntheticLambda2 = KClassImpl$Data$declaredNonStaticMembers$2;
            this.getErrorConfigVersion = skipShowCaseBuilder.BuiltInFictitiousFunctionClassFactory(false).getAuthRequestContext((TimeInterpolator) null).BuiltInFictitiousFunctionClassFactory(new AbstractOnShowcaseStateListener() { // from class: id.dana.sendmoney_v2.landing.view.RecentTransactionView$showTooltip$1
                @Override // id.dana.showcase.AbstractOnShowcaseStateListener, id.dana.showcase.OnShowcaseStateListener
                public final void onFinished(int p0) {
                    RecentTransactionView.this.getErrorConfigVersion = null;
                }
            }).PlaceComponentResult();
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type id.dana.sendmoney_v2.landing.viewholder.recent.TransactionViewHolder");
    }

    public final void updateRecentTransaction() {
        getRecentRecipientPresenter().getAuthRequestContext("");
        RecentTransactionAdapter recentTransactionAdapter = this.MyBillsEntityDataFactory;
        if (recentTransactionAdapter != null) {
            recentTransactionAdapter.notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean PlaceComponentResult(RecentTransactionView recentTransactionView) {
        Intrinsics.checkNotNullParameter(recentTransactionView, "");
        Showcase showcase = recentTransactionView.getErrorConfigVersion;
        if (showcase != null) {
            showcase.PlaceComponentResult();
        }
        GestureHoldClickListener gestureHoldClickListener = recentTransactionView.KClassImpl$Data$declaredNonStaticMembers$2;
        if (gestureHoldClickListener == null || recentTransactionView.MyBillsEntityDataFactory == null) {
            return true;
        }
        if (gestureHoldClickListener == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            gestureHoldClickListener = null;
        }
        RecentTransactionAdapter recentTransactionAdapter = recentTransactionView.MyBillsEntityDataFactory;
        Intrinsics.checkNotNull(recentTransactionAdapter);
        RecentRecipientModel item = recentTransactionAdapter.getItem(0);
        Intrinsics.checkNotNullExpressionValue(item, "");
        gestureHoldClickListener.BuiltInFictitiousFunctionClassFactory(item);
        return true;
    }

    public final void setOnGestureHoldLongClickListener(GestureHoldClickListener gestureHoldClickListener) {
        Intrinsics.checkNotNullParameter(gestureHoldClickListener, "");
        this.KClassImpl$Data$declaredNonStaticMembers$2 = gestureHoldClickListener;
    }

    public final Integer getCurrentFavoriteAccountCount() {
        RecentTransactionAdapter recentTransactionAdapter = this.MyBillsEntityDataFactory;
        if (recentTransactionAdapter != null) {
            List<RecentRecipientModel> items = recentTransactionAdapter.getItems();
            Intrinsics.checkNotNullExpressionValue(items, "");
            ArrayList arrayList = new ArrayList();
            for (Object obj : items) {
                if (((RecentRecipientModel) obj).getErrorConfigVersion()) {
                    arrayList.add(obj);
                }
            }
            return Integer.valueOf(arrayList.size());
        }
        return null;
    }

    public final RecentRecipientModel getLeastTransactionFavoriteAccount() {
        RecentTransactionAdapter recentTransactionAdapter = this.MyBillsEntityDataFactory;
        if (recentTransactionAdapter != null) {
            List<RecentRecipientModel> items = recentTransactionAdapter.getItems();
            Intrinsics.checkNotNullExpressionValue(items, "");
            ArrayList arrayList = new ArrayList();
            for (Object obj : items) {
                if (((RecentRecipientModel) obj).getErrorConfigVersion()) {
                    arrayList.add(obj);
                }
            }
            final Comparator comparator = new Comparator() { // from class: id.dana.sendmoney_v2.landing.adapter.RecentTransactionAdapter$getLeastTransactionFavoriteAccount$$inlined$compareBy$1
                @Override // java.util.Comparator
                public final int compare(T t, T t2) {
                    return ComparisonsKt.compareValues(Integer.valueOf(((RecentRecipientModel) t).NetworkUserEntityData$$ExternalSyntheticLambda1), Integer.valueOf(((RecentRecipientModel) t2).NetworkUserEntityData$$ExternalSyntheticLambda1));
                }
            };
            Object obj2 = CollectionsKt.sortedWith(arrayList, new Comparator() { // from class: id.dana.sendmoney_v2.landing.adapter.RecentTransactionAdapter$getLeastTransactionFavoriteAccount$$inlined$thenBy$1
                @Override // java.util.Comparator
                public final int compare(T t, T t2) {
                    int compare = comparator.compare(t, t2);
                    return compare == 0 ? ComparisonsKt.compareValues(Long.valueOf(((RecentRecipientModel) t).NetworkUserEntityData$$ExternalSyntheticLambda0), Long.valueOf(((RecentRecipientModel) t2).NetworkUserEntityData$$ExternalSyntheticLambda0)) : compare;
                }
            }).get(0);
            Intrinsics.checkNotNullExpressionValue(obj2, "");
            return (RecentRecipientModel) obj2;
        }
        return null;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        getRecentRecipientPresenter().onDestroy();
        getUserConfigPresenter().onDestroy();
        getBillerX2BPresenter().onDestroy();
        Disposable disposable = this.BuiltInFictitiousFunctionClassFactory;
        if (disposable != null) {
            disposable.dispose();
        }
    }

    public static /* synthetic */ void $r8$lambda$FsOhFK4U1VrTQXTnuAazwEU3sBY(RecentTransactionView recentTransactionView, RecipientModel recipientModel) {
        Intrinsics.checkNotNullParameter(recentTransactionView, "");
        Function1<? super RecipientModel, Unit> function1 = recentTransactionView.onRecipientSelected;
        Intrinsics.checkNotNullExpressionValue(recipientModel, "");
        function1.invoke(recipientModel);
    }

    public static /* synthetic */ void $r8$lambda$dEhc6F5uzy2EN9aYKLVKTxscXbU(RecentTransactionView recentTransactionView, View view) {
        Intrinsics.checkNotNullParameter(recentTransactionView, "");
        RecentTransactionAdapter recentTransactionAdapter = recentTransactionView.MyBillsEntityDataFactory;
        if (recentTransactionAdapter != null) {
            recentTransactionAdapter.getAuthRequestContext();
        }
    }

    public static /* synthetic */ void $r8$lambda$j39cm5YGDtR7bIppVeRQBEszzSM(RecentTransactionView recentTransactionView, BillerX2BModel billerX2BModel, DialogInterface dialogInterface, int i) {
        Intrinsics.checkNotNullParameter(recentTransactionView, "");
        Intrinsics.checkNotNullParameter(billerX2BModel, "");
        if (-1 == i) {
            recentTransactionView.getBillerX2BPresenter().KClassImpl$Data$declaredNonStaticMembers$2(billerX2BModel);
            dialogInterface.dismiss();
        }
    }

    public static /* synthetic */ void $r8$lambda$qfObVMeCY7ox3cwgfcDpFRlRsZ0(RecentTransactionView recentTransactionView, View view) {
        Intrinsics.checkNotNullParameter(recentTransactionView, "");
        RecentTransactionClickListener recentTransactionClickListener = recentTransactionView.getAuthRequestContext;
        if (recentTransactionClickListener == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            recentTransactionClickListener = null;
        }
        recentTransactionClickListener.getAuthRequestContext();
    }

    public static final /* synthetic */ void access$handleClickedRecipientType(RecentTransactionView recentTransactionView, RecentRecipientModel recentRecipientModel, String str, String str2) {
        RecipientModel KClassImpl$Data$declaredNonStaticMembers$2 = KClassImpl$Data$declaredNonStaticMembers$2(str, recentRecipientModel, str2);
        Function1<? super RecipientModel, Unit> function1 = recentTransactionView.onRecipientSelected;
        Intrinsics.checkNotNullExpressionValue(KClassImpl$Data$declaredNonStaticMembers$2, "");
        function1.invoke(KClassImpl$Data$declaredNonStaticMembers$2);
    }

    public static final /* synthetic */ void access$hideSendMoneyQuickSendShimmer(RecentTransactionView recentTransactionView) {
        SkeletonScreen skeletonScreen = recentTransactionView.PlaceComponentResult;
        if (skeletonScreen == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            skeletonScreen = null;
        }
        skeletonScreen.PlaceComponentResult();
    }

    public static final /* synthetic */ void access$onRecyclerViewExpanded(RecentTransactionView recentTransactionView, boolean z) {
        ViewParent parent = recentTransactionView.getParent();
        ViewGroup viewGroup = parent instanceof ViewGroup ? (ViewGroup) parent : null;
        if (viewGroup != null) {
            AutoTransition autoTransition = new AutoTransition();
            autoTransition.setInterpolator(new DecelerateInterpolator());
            TransitionManager.getAuthRequestContext(viewGroup, autoTransition);
        }
        recentTransactionView.getBinding().KClassImpl$Data$declaredNonStaticMembers$2.setExpanded(z);
    }

    public static final /* synthetic */ void access$showBillerX2BDialog(final RecentTransactionView recentTransactionView, final BillerX2BModel billerX2BModel) {
        Context context = recentTransactionView.getContext();
        if (context == null) {
            throw new NullPointerException("null cannot be cast to non-null type id.dana.base.BaseActivity");
        }
        new BillerX2BDialog((BaseActivity) context, new DialogInterface.OnClickListener() { // from class: id.dana.sendmoney_v2.landing.view.RecentTransactionView$$ExternalSyntheticLambda1
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                RecentTransactionView.$r8$lambda$j39cm5YGDtR7bIppVeRQBEszzSM(RecentTransactionView.this, billerX2BModel, dialogInterface, i);
            }
        }).KClassImpl$Data$declaredNonStaticMembers$2();
    }

    public static final /* synthetic */ void access$updateShowMoreView(RecentTransactionView recentTransactionView) {
        ShowMoreView showMoreView = recentTransactionView.getBinding().KClassImpl$Data$declaredNonStaticMembers$2;
        Intrinsics.checkNotNullExpressionValue(showMoreView, "");
        ShowMoreView showMoreView2 = showMoreView;
        RecentTransactionAdapter recentTransactionAdapter = recentTransactionView.MyBillsEntityDataFactory;
        boolean z = false;
        showMoreView2.setVisibility(recentTransactionAdapter != null && recentTransactionAdapter.BuiltInFictitiousFunctionClassFactory() ? 0 : 8);
        RecentTransactionAdapter recentTransactionAdapter2 = recentTransactionView.MyBillsEntityDataFactory;
        if (recentTransactionAdapter2 != null && recentTransactionAdapter2.getMyBillsEntityDataFactory()) {
            z = true;
        }
        showMoreView.setExpanded(z);
    }
}
