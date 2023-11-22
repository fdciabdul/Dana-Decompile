package id.dana.animation.danaprotection;

import android.content.Context;
import android.text.Spanned;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.core.text.HtmlCompat;
import com.ap.zoloz.hummer.biz.HummerConstants;
import com.ethanhua.skeleton.Skeleton;
import com.ethanhua.skeleton.SkeletonScreen;
import com.ethanhua.skeleton.ViewSkeletonScreen;
import dagger.internal.Preconditions;
import id.dana.R;
import id.dana.analytics.tracker.TrackerKey;
import id.dana.animation.danaprotection.DanaProtectionContract;
import id.dana.animation.danaprotection.tracker.DanaProtectionTrackerImpl;
import id.dana.base.AbstractContractKt;
import id.dana.base.BaseActivity;
import id.dana.base.viewbinding.ViewBindingRichView;
import id.dana.component.buttoncomponent.DanaButtonSecondaryView;
import id.dana.danah5.DanaH5;
import id.dana.databinding.ViewHomeWidgetDanaProtectionBinding;
import id.dana.databinding.ViewNewDanaProtectionContentBinding;
import id.dana.di.component.ApplicationComponent;
import id.dana.di.component.DaggerDanaProtectionWidgetComponent;
import id.dana.di.modules.DanaProtectionModule;
import id.dana.domain.danaprotection.model.DanaProtectionInfoModel;
import id.dana.tracker.constant.TrackerType;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B'\b\u0016\u0012\u0006\u0010)\u001a\u00020(\u0012\n\b\u0002\u0010+\u001a\u0004\u0018\u00010*\u0012\b\b\u0002\u0010,\u001a\u00020\u0003¢\u0006\u0004\b-\u0010.B+\b\u0016\u0012\u0006\u0010)\u001a\u00020(\u0012\b\u0010/\u001a\u0004\u0018\u00010*\u0012\u0006\u0010,\u001a\u00020\u0003\u0012\u0006\u00100\u001a\u00020\u0003¢\u0006\u0004\b-\u00101J\u000f\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0014¢\u0006\u0004\b\b\u0010\tJ\u0019\u0010\r\u001a\u00020\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\fH\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\r\u0010\u0011\u001a\u00020\f¢\u0006\u0004\b\u0011\u0010\u0010J\u0017\u0010\u0013\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0015\u001a\u00020\fH\u0016¢\u0006\u0004\b\u0015\u0010\u0010J\u000f\u0010\u0016\u001a\u00020\fH\u0002¢\u0006\u0004\b\u0016\u0010\u0010R(\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00180\u00178\u0007@\u0007X\u0087.¢\u0006\u0012\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u0013\u0010!\u001a\u00020\u001fX\u0083\u0080\u0002¢\u0006\u0006\n\u0004\b\u0013\u0010 R(\u0010#\u001a\b\u0012\u0004\u0012\u00020\"0\u00178\u0007@\u0007X\u0087.¢\u0006\u0012\n\u0004\b#\u0010\u001a\u001a\u0004\b$\u0010\u001c\"\u0004\b%\u0010\u001eR\u0018\u0010\u000f\u001a\u0004\u0018\u00010&8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b\u0016\u0010'"}, d2 = {"Lid/dana/home/danaprotection/DanaProtectionHomeView;", "Lid/dana/base/viewbinding/ViewBindingRichView;", "Lid/dana/databinding/ViewHomeWidgetDanaProtectionBinding;", "", "getLayout", "()I", "Landroid/view/View;", "view", "initViewBinding", "(Landroid/view/View;)Lid/dana/databinding/ViewHomeWidgetDanaProtectionBinding;", "Lid/dana/di/component/ApplicationComponent;", "applicationComponent", "", "injectComponent", "(Lid/dana/di/component/ApplicationComponent;)V", "MyBillsEntityDataFactory", "()V", "onFinishCheckSession", "p0", "PlaceComponentResult", "(I)V", "setup", "KClassImpl$Data$declaredNonStaticMembers$2", "Ldagger/Lazy;", "Lid/dana/home/danaprotection/DanaProtectionContract$Presenter;", "danaProtectionPresenter", "Ldagger/Lazy;", "getDanaProtectionPresenter", "()Ldagger/Lazy;", "setDanaProtectionPresenter", "(Ldagger/Lazy;)V", "Lid/dana/home/danaprotection/DanaProtectionRecommendationManager;", "Lkotlin/Lazy;", "BuiltInFictitiousFunctionClassFactory", "Lid/dana/home/danaprotection/tracker/DanaProtectionTrackerImpl;", "danaProtectionTracker", "getDanaProtectionTracker", "setDanaProtectionTracker", "Lcom/ethanhua/skeleton/SkeletonScreen;", "Lcom/ethanhua/skeleton/SkeletonScreen;", "Landroid/content/Context;", HummerConstants.CONTEXT, "Landroid/util/AttributeSet;", "attributeSet", "defStyleArr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "attrs", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class DanaProtectionHomeView extends ViewBindingRichView<ViewHomeWidgetDanaProtectionBinding> {

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    private SkeletonScreen MyBillsEntityDataFactory;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private final Lazy BuiltInFictitiousFunctionClassFactory;
    public Map<Integer, View> _$_findViewCache;
    @Inject
    public dagger.Lazy<DanaProtectionContract.Presenter> danaProtectionPresenter;
    @Inject
    public dagger.Lazy<DanaProtectionTrackerImpl> danaProtectionTracker;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public DanaProtectionHomeView(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public DanaProtectionHomeView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "");
    }

    @Override // id.dana.base.viewbinding.ViewBindingRichView
    public final void _$_clearFindViewByIdCache() {
        this._$_findViewCache.clear();
    }

    @Override // id.dana.base.viewbinding.ViewBindingRichView
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

    @Override // id.dana.base.BaseRichView
    public final int getLayout() {
        return R.layout.view_home_widget_dana_protection;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DanaProtectionHomeView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "");
        this._$_findViewCache = new LinkedHashMap();
        this.BuiltInFictitiousFunctionClassFactory = LazyKt.lazy(DanaProtectionHomeView$danaProtectionRecommendationManager$2.INSTANCE);
    }

    public /* synthetic */ DanaProtectionHomeView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DanaProtectionHomeView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        Intrinsics.checkNotNullParameter(context, "");
        this._$_findViewCache = new LinkedHashMap();
        this.BuiltInFictitiousFunctionClassFactory = LazyKt.lazy(DanaProtectionHomeView$danaProtectionRecommendationManager$2.INSTANCE);
    }

    @JvmName(name = "getDanaProtectionPresenter")
    public final dagger.Lazy<DanaProtectionContract.Presenter> getDanaProtectionPresenter() {
        dagger.Lazy<DanaProtectionContract.Presenter> lazy = this.danaProtectionPresenter;
        if (lazy != null) {
            return lazy;
        }
        Intrinsics.throwUninitializedPropertyAccessException("");
        return null;
    }

    @JvmName(name = "setDanaProtectionPresenter")
    public final void setDanaProtectionPresenter(dagger.Lazy<DanaProtectionContract.Presenter> lazy) {
        Intrinsics.checkNotNullParameter(lazy, "");
        this.danaProtectionPresenter = lazy;
    }

    @JvmName(name = "getDanaProtectionTracker")
    public final dagger.Lazy<DanaProtectionTrackerImpl> getDanaProtectionTracker() {
        dagger.Lazy<DanaProtectionTrackerImpl> lazy = this.danaProtectionTracker;
        if (lazy != null) {
            return lazy;
        }
        Intrinsics.throwUninitializedPropertyAccessException("");
        return null;
    }

    @JvmName(name = "setDanaProtectionTracker")
    public final void setDanaProtectionTracker(dagger.Lazy<DanaProtectionTrackerImpl> lazy) {
        Intrinsics.checkNotNullParameter(lazy, "");
        this.danaProtectionTracker = lazy;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // id.dana.base.viewbinding.ViewBindingRichView
    public final ViewHomeWidgetDanaProtectionBinding initViewBinding(View view) {
        Intrinsics.checkNotNullParameter(view, "");
        ViewHomeWidgetDanaProtectionBinding BuiltInFictitiousFunctionClassFactory = ViewHomeWidgetDanaProtectionBinding.BuiltInFictitiousFunctionClassFactory(view);
        Intrinsics.checkNotNullExpressionValue(BuiltInFictitiousFunctionClassFactory, "");
        return BuiltInFictitiousFunctionClassFactory;
    }

    public final void onFinishCheckSession() {
        getDanaProtectionPresenter().get().PlaceComponentResult();
    }

    private final void MyBillsEntityDataFactory() {
        KClassImpl$Data$declaredNonStaticMembers$2();
        getDanaProtectionPresenter().get().getAuthRequestContext();
        getDanaProtectionPresenter().get().KClassImpl$Data$declaredNonStaticMembers$2();
    }

    @Override // id.dana.base.BaseRichView
    public final void injectComponent(ApplicationComponent applicationComponent) {
        DaggerDanaProtectionWidgetComponent.Builder MyBillsEntityDataFactory = DaggerDanaProtectionWidgetComponent.MyBillsEntityDataFactory();
        MyBillsEntityDataFactory.PlaceComponentResult = (ApplicationComponent) Preconditions.getAuthRequestContext(applicationComponent);
        MyBillsEntityDataFactory.MyBillsEntityDataFactory = (DanaProtectionModule) Preconditions.getAuthRequestContext(new DanaProtectionModule(new DanaProtectionContract.View() { // from class: id.dana.home.danaprotection.DanaProtectionHomeView$getDanaProtectionModule$1
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

            @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
            public final /* synthetic */ void showProgress() {
                AbstractContractKt.AbstractView.CC.PlaceComponentResult();
            }

            @Override // id.dana.home.danaprotection.DanaProtectionContract.View
            public final void PlaceComponentResult(DanaProtectionInfoModel p0, int p1) {
                DanaProtectionHomeView.access$getDanaProtectionRecommendationManager(DanaProtectionHomeView.this);
                BaseActivity baseActivity = DanaProtectionHomeView.this.getBaseActivity();
                Intrinsics.checkNotNullExpressionValue(baseActivity, "");
                if (!DanaProtectionRecommendationManager.getAuthRequestContext(baseActivity)) {
                    p1++;
                }
                DanaProtectionHomeView.access$hideShimmer(DanaProtectionHomeView.this);
                DanaProtectionHomeView.access$showDanaProtectionSummary(DanaProtectionHomeView.this, p0, p1);
            }

            @Override // id.dana.home.danaprotection.DanaProtectionContract.View
            public final void BuiltInFictitiousFunctionClassFactory() {
                DanaProtectionHomeView.access$hideShimmer(DanaProtectionHomeView.this);
                DanaProtectionHomeView.access$showFailedState(DanaProtectionHomeView.this);
            }

            @Override // id.dana.home.danaprotection.DanaProtectionContract.View
            public final void KClassImpl$Data$declaredNonStaticMembers$2(boolean z) {
                ViewHomeWidgetDanaProtectionBinding binding;
                ViewHomeWidgetDanaProtectionBinding binding2;
                ViewHomeWidgetDanaProtectionBinding binding3;
                ViewHomeWidgetDanaProtectionBinding binding4;
                ViewHomeWidgetDanaProtectionBinding binding5;
                binding = DanaProtectionHomeView.this.getBinding();
                LinearLayout linearLayout = binding.NetworkUserEntityData$$ExternalSyntheticLambda0.PlaceComponentResult;
                Intrinsics.checkNotNullExpressionValue(linearLayout, "");
                boolean z2 = !z;
                linearLayout.setVisibility(z2 ? 0 : 8);
                binding2 = DanaProtectionHomeView.this.getBinding();
                DanaButtonSecondaryView danaButtonSecondaryView = binding2.BuiltInFictitiousFunctionClassFactory;
                Intrinsics.checkNotNullExpressionValue(danaButtonSecondaryView, "");
                danaButtonSecondaryView.setVisibility(z2 ? 0 : 8);
                if (!z) {
                    DanaProtectionHomeView.access$hideShimmer(DanaProtectionHomeView.this);
                    binding4 = DanaProtectionHomeView.this.getBinding();
                    DanaButtonSecondaryView danaButtonSecondaryView2 = binding4.MyBillsEntityDataFactory;
                    Intrinsics.checkNotNullExpressionValue(danaButtonSecondaryView2, "");
                    danaButtonSecondaryView2.setVisibility(z ? 0 : 8);
                    binding5 = DanaProtectionHomeView.this.getBinding();
                    AppCompatTextView appCompatTextView = binding5.getErrorConfigVersion;
                    Intrinsics.checkNotNullExpressionValue(appCompatTextView, "");
                    appCompatTextView.setVisibility(z ? 0 : 8);
                }
                binding3 = DanaProtectionHomeView.this.getBinding();
                ConstraintLayout constraintLayout = binding3.moveToNextValue.MyBillsEntityDataFactory;
                Intrinsics.checkNotNullExpressionValue(constraintLayout, "");
                constraintLayout.setVisibility(z ? 0 : 8);
            }
        }));
        Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(MyBillsEntityDataFactory.MyBillsEntityDataFactory, DanaProtectionModule.class);
        Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(MyBillsEntityDataFactory.PlaceComponentResult, ApplicationComponent.class);
        new DaggerDanaProtectionWidgetComponent.DanaProtectionWidgetComponentImpl(MyBillsEntityDataFactory.MyBillsEntityDataFactory, MyBillsEntityDataFactory.PlaceComponentResult, (byte) 0).PlaceComponentResult(this);
    }

    private final void KClassImpl$Data$declaredNonStaticMembers$2() {
        PlaceComponentResult(8);
        ViewHomeWidgetDanaProtectionBinding binding = getBinding();
        binding.MyBillsEntityDataFactory.setVisibility(8);
        binding.GetContactSyncConfig.getAuthRequestContext.setVisibility(8);
        FrameLayout frameLayout = binding.KClassImpl$Data$declaredNonStaticMembers$2;
        byte b = 0;
        frameLayout.setVisibility(0);
        SkeletonScreen skeletonScreen = this.MyBillsEntityDataFactory;
        if (skeletonScreen != null) {
            skeletonScreen.MyBillsEntityDataFactory();
            return;
        }
        ViewSkeletonScreen.Builder BuiltInFictitiousFunctionClassFactory = Skeleton.BuiltInFictitiousFunctionClassFactory(getBinding().KClassImpl$Data$declaredNonStaticMembers$2);
        BuiltInFictitiousFunctionClassFactory.getAuthRequestContext = R.layout.view_home_widget_dana_protection_skeleton;
        BuiltInFictitiousFunctionClassFactory.PlaceComponentResult = 1500;
        BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2 = true;
        BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory = ContextCompat.BuiltInFictitiousFunctionClassFactory(BuiltInFictitiousFunctionClassFactory.lookAheadTest.getContext(), R.color.f27082131100491);
        ViewSkeletonScreen viewSkeletonScreen = new ViewSkeletonScreen(BuiltInFictitiousFunctionClassFactory, b);
        viewSkeletonScreen.MyBillsEntityDataFactory();
        this.MyBillsEntityDataFactory = viewSkeletonScreen;
    }

    private final void PlaceComponentResult(int p0) {
        ViewHomeWidgetDanaProtectionBinding binding = getBinding();
        ViewNewDanaProtectionContentBinding viewNewDanaProtectionContentBinding = binding.moveToNextValue;
        viewNewDanaProtectionContentBinding.PlaceComponentResult.setVisibility(p0);
        viewNewDanaProtectionContentBinding.moveToNextValue.setVisibility(p0);
        viewNewDanaProtectionContentBinding.getAuthRequestContext.setVisibility(p0);
        viewNewDanaProtectionContentBinding.lookAheadTest.setVisibility(p0);
        viewNewDanaProtectionContentBinding.BuiltInFictitiousFunctionClassFactory.setVisibility(p0);
        binding.getErrorConfigVersion.setVisibility(p0);
    }

    /* renamed from: $r8$lambda$6NzD-BLHmzN84XpGamj9f1YUWaE  reason: not valid java name */
    public static /* synthetic */ void m2623$r8$lambda$6NzDBLHmzN84XpGamj9f1YUWaE(DanaProtectionHomeView danaProtectionHomeView, View view) {
        Intrinsics.checkNotNullParameter(danaProtectionHomeView, "");
        danaProtectionHomeView.MyBillsEntityDataFactory();
    }

    /* renamed from: $r8$lambda$HLqDojyZCdLOsfvHXWzx2Y-vjE4  reason: not valid java name */
    public static /* synthetic */ void m2624$r8$lambda$HLqDojyZCdLOsfvHXWzx2YvjE4(DanaProtectionHomeView danaProtectionHomeView, View view) {
        Intrinsics.checkNotNullParameter(danaProtectionHomeView, "");
        danaProtectionHomeView.getDanaProtectionTracker().get().PlaceComponentResult.get().KClassImpl$Data$declaredNonStaticMembers$2(TrackerType.MIXPANEL).KClassImpl$Data$declaredNonStaticMembers$2(TrackerKey.Event.DANA_PROTECTION_WIDGET_CTA, null);
        DanaH5.startContainerFullUrl("https://m.dana.id/i/dana-info/protection-mini-program/landing-page");
    }

    public static /* synthetic */ void $r8$lambda$tPQTo5Sy2bp8vP8wke0d1WdsZrM(DanaProtectionHomeView danaProtectionHomeView, View view) {
        Intrinsics.checkNotNullParameter(danaProtectionHomeView, "");
        danaProtectionHomeView.getDanaProtectionTracker().get().PlaceComponentResult.get().KClassImpl$Data$declaredNonStaticMembers$2(TrackerType.MIXPANEL).KClassImpl$Data$declaredNonStaticMembers$2(TrackerKey.Event.DANA_PROTECTION_WIDGET_CTA, null);
        DanaH5.startContainerFullUrl("https://m.dana.id/m/standalone/protection");
    }

    public static final /* synthetic */ DanaProtectionRecommendationManager access$getDanaProtectionRecommendationManager(DanaProtectionHomeView danaProtectionHomeView) {
        return (DanaProtectionRecommendationManager) danaProtectionHomeView.BuiltInFictitiousFunctionClassFactory.getValue();
    }

    public static final /* synthetic */ void access$hideOldWidget(DanaProtectionHomeView danaProtectionHomeView) {
        LinearLayout linearLayout = danaProtectionHomeView.getBinding().NetworkUserEntityData$$ExternalSyntheticLambda0.PlaceComponentResult;
        Intrinsics.checkNotNullExpressionValue(linearLayout, "");
        linearLayout.setVisibility(8);
        DanaButtonSecondaryView danaButtonSecondaryView = danaProtectionHomeView.getBinding().BuiltInFictitiousFunctionClassFactory;
        Intrinsics.checkNotNullExpressionValue(danaButtonSecondaryView, "");
        danaButtonSecondaryView.setVisibility(8);
    }

    public static final /* synthetic */ void access$hideShimmer(DanaProtectionHomeView danaProtectionHomeView) {
        SkeletonScreen skeletonScreen = danaProtectionHomeView.MyBillsEntityDataFactory;
        if (skeletonScreen != null) {
            skeletonScreen.PlaceComponentResult();
        }
    }

    public static final /* synthetic */ void access$showDanaProtectionSummary(DanaProtectionHomeView danaProtectionHomeView, DanaProtectionInfoModel danaProtectionInfoModel, int i) {
        danaProtectionHomeView.PlaceComponentResult(0);
        danaProtectionHomeView.getBinding().MyBillsEntityDataFactory.setVisibility(0);
        danaProtectionHomeView.getBinding().GetContactSyncConfig.getAuthRequestContext.setVisibility(8);
        int suspiciousActivity = danaProtectionInfoModel != null ? danaProtectionInfoModel.getSuspiciousActivity() : 0;
        if (suspiciousActivity > 0) {
            ViewNewDanaProtectionContentBinding viewNewDanaProtectionContentBinding = danaProtectionHomeView.getBinding().moveToNextValue;
            viewNewDanaProtectionContentBinding.PlaceComponentResult.setVisibility(0);
            viewNewDanaProtectionContentBinding.GetContactSyncConfig.setText(String.valueOf(suspiciousActivity));
            viewNewDanaProtectionContentBinding.GetContactSyncConfig.setVisibility(0);
            viewNewDanaProtectionContentBinding.lookAheadTest.setVisibility(0);
        } else {
            ViewNewDanaProtectionContentBinding viewNewDanaProtectionContentBinding2 = danaProtectionHomeView.getBinding().moveToNextValue;
            viewNewDanaProtectionContentBinding2.PlaceComponentResult.setVisibility(8);
            viewNewDanaProtectionContentBinding2.lookAheadTest.setVisibility(8);
        }
        int protectedActivity = danaProtectionInfoModel != null ? danaProtectionInfoModel.getProtectedActivity() : 0;
        danaProtectionHomeView.getBinding().moveToNextValue.getAuthRequestContext.setVisibility(0);
        if (protectedActivity > 0) {
            ViewNewDanaProtectionContentBinding viewNewDanaProtectionContentBinding3 = danaProtectionHomeView.getBinding().moveToNextValue;
            viewNewDanaProtectionContentBinding3.NetworkUserEntityData$$ExternalSyntheticLambda1.setText(String.valueOf(protectedActivity));
            viewNewDanaProtectionContentBinding3.NetworkUserEntityData$$ExternalSyntheticLambda1.setVisibility(0);
        } else {
            ViewNewDanaProtectionContentBinding viewNewDanaProtectionContentBinding4 = danaProtectionHomeView.getBinding().moveToNextValue;
            viewNewDanaProtectionContentBinding4.KClassImpl$Data$declaredNonStaticMembers$2.setImageDrawable(ContextCompat.PlaceComponentResult(danaProtectionHomeView.getContext(), (int) R.drawable.ic_blue_shied_verified));
            viewNewDanaProtectionContentBinding4.NetworkUserEntityData$$ExternalSyntheticLambda1.setVisibility(4);
        }
        ViewNewDanaProtectionContentBinding viewNewDanaProtectionContentBinding5 = danaProtectionHomeView.getBinding().moveToNextValue;
        viewNewDanaProtectionContentBinding5.BuiltInFictitiousFunctionClassFactory.setVisibility(0);
        if (i > 0) {
            viewNewDanaProtectionContentBinding5.DatabaseTableConfigUtil.setText(String.valueOf(i));
            viewNewDanaProtectionContentBinding5.DatabaseTableConfigUtil.setVisibility(0);
            viewNewDanaProtectionContentBinding5.NetworkUserEntityData$$ExternalSyntheticLambda0.setImageDrawable(ContextCompat.PlaceComponentResult(danaProtectionHomeView.getContext(), (int) R.drawable.ic_yellow_lightbulb));
            viewNewDanaProtectionContentBinding5.NetworkUserEntityData$$ExternalSyntheticLambda2.setText(danaProtectionHomeView.getContext().getString(R.string.dana_protection_security_suggestion_title));
        } else {
            viewNewDanaProtectionContentBinding5.DatabaseTableConfigUtil.setVisibility(4);
            viewNewDanaProtectionContentBinding5.NetworkUserEntityData$$ExternalSyntheticLambda0.setImageDrawable(ContextCompat.PlaceComponentResult(danaProtectionHomeView.getContext(), (int) R.drawable.ic_green_shield_verified));
            viewNewDanaProtectionContentBinding5.NetworkUserEntityData$$ExternalSyntheticLambda2.setText(danaProtectionHomeView.getContext().getString(R.string.dana_protection_account_secured_title));
        }
        if (danaProtectionInfoModel != null) {
            int timeRange = danaProtectionInfoModel.getTimeRange();
            AppCompatTextView appCompatTextView = danaProtectionHomeView.getBinding().getErrorConfigVersion;
            Spanned PlaceComponentResult = HtmlCompat.PlaceComponentResult(danaProtectionHomeView.getContext().getString(R.string.dana_protection_widget_desc, Integer.valueOf(timeRange)), 0);
            Intrinsics.checkNotNullExpressionValue(PlaceComponentResult, "");
            appCompatTextView.setText(PlaceComponentResult);
        }
    }

    public static final /* synthetic */ void access$showFailedState(final DanaProtectionHomeView danaProtectionHomeView) {
        danaProtectionHomeView.PlaceComponentResult(8);
        ViewHomeWidgetDanaProtectionBinding binding = danaProtectionHomeView.getBinding();
        binding.MyBillsEntityDataFactory.setVisibility(8);
        binding.GetContactSyncConfig.getAuthRequestContext.setVisibility(0);
        binding.GetContactSyncConfig.PlaceComponentResult.setOnClickListener(new View.OnClickListener() { // from class: id.dana.home.danaprotection.DanaProtectionHomeView$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DanaProtectionHomeView.m2623$r8$lambda$6NzDBLHmzN84XpGamj9f1YUWaE(DanaProtectionHomeView.this, view);
            }
        });
    }

    @Override // id.dana.base.BaseRichView
    public final void setup() {
        getBinding().MyBillsEntityDataFactory.setOnClickListener(new View.OnClickListener() { // from class: id.dana.home.danaprotection.DanaProtectionHomeView$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DanaProtectionHomeView.m2624$r8$lambda$HLqDojyZCdLOsfvHXWzx2YvjE4(DanaProtectionHomeView.this, view);
            }
        });
        getBinding().BuiltInFictitiousFunctionClassFactory.setOnClickListener(new View.OnClickListener() { // from class: id.dana.home.danaprotection.DanaProtectionHomeView$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DanaProtectionHomeView.$r8$lambda$tPQTo5Sy2bp8vP8wke0d1WdsZrM(DanaProtectionHomeView.this, view);
            }
        });
        getDanaProtectionPresenter().get().BuiltInFictitiousFunctionClassFactory();
        MyBillsEntityDataFactory();
    }
}
