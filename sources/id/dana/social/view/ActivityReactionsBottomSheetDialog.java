package id.dana.social.view;

import android.app.Dialog;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.emoji.widget.EmojiAppCompatTextView;
import androidx.fragment.app.FragmentManager;
import androidx.viewbinding.ViewBinding;
import androidx.viewpager.widget.ViewPager;
import com.alipay.iap.android.common.syncintegration.api.IAPSyncCommand;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.tabs.TabLayout;
import id.dana.DanaApplication;
import id.dana.R;
import id.dana.base.BaseActivity;
import id.dana.base.BaseBottomSheetDialogFragment;
import id.dana.databinding.BottomSheetActivityReactionsBinding;
import id.dana.databinding.BottomSheetActivityReactionsCoordinatorBinding;
import id.dana.feeds.domain.reactions.model.DeleteReactionResult;
import id.dana.feeds.ui.reaction.model.ReactionModel;
import id.dana.social.adapter.ActivityReactionsViewPagerAdapter;
import id.dana.social.contract.reaction.ReactionsContract;
import id.dana.social.di.component.SocialCommonComponent;
import id.dana.social.di.module.ReactionsModule;
import id.dana.social.model.FeedModel;
import id.dana.social.model.ReactionCountModel;
import id.dana.social.model.ReactionResultModel;
import id.dana.social.utils.EmojiUtil;
import id.dana.social.view.fragment.ActivityReactionsListFragment;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 /2\u00020\u0001:\u0001/B\u0017\u0012\u0006\u0010\t\u001a\u00020\u001a\u0012\u0006\u0010\n\u001a\u00020&¢\u0006\u0004\b-\u0010.J\u000f\u0010\u0003\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0014¢\u0006\u0004\b\u0006\u0010\u0007J\u001f\u0010\u000b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\bH\u0014¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\u0005H\u0014¢\u0006\u0004\b\r\u0010\u0007J\u000f\u0010\u000e\u001a\u00020\u0005H\u0014¢\u0006\u0004\b\u000e\u0010\u0007J\u000f\u0010\u000f\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u000f\u0010\u0007R\u0016\u0010\u0013\u001a\u00020\u00108\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R \u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00160\u00148WX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018R\u0014\u0010\u001d\u001a\u00020\u001a8\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0012\u0010\u001f\u001a\u00020\u001eX\u0087\"¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u001a\u0010%\u001a\b\u0012\u0004\u0012\u00020\"0!8\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b#\u0010$R\u0016\u0010)\u001a\u00020&8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b'\u0010(R\u0018\u0010#\u001a\b\u0012\u0004\u0012\u00020+0*X\u0087\"¢\u0006\u0006\n\u0004\b,\u0010$"}, d2 = {"Lid/dana/social/view/ActivityReactionsBottomSheetDialog;", "Lid/dana/base/BaseBottomSheetDialogFragment;", "", "getDimAmount", "()F", "", IAPSyncCommand.COMMAND_INIT, "()V", "", "p0", "p1", "initBottomSheet", "(II)V", "onDismiss", "onShow", "onStart", "Lid/dana/social/adapter/ActivityReactionsViewPagerAdapter;", "scheduleImpl", "Lid/dana/social/adapter/ActivityReactionsViewPagerAdapter;", "BuiltInFictitiousFunctionClassFactory", "Lkotlin/Function1;", "Landroid/view/LayoutInflater;", "Lid/dana/databinding/BottomSheetActivityReactionsCoordinatorBinding;", "getBindingInflater", "()Lkotlin/jvm/functions/Function1;", "MyBillsEntityDataFactory", "Lid/dana/social/model/FeedModel;", "getErrorConfigVersion", "Lid/dana/social/model/FeedModel;", "PlaceComponentResult", "Lid/dana/social/contract/reaction/ReactionsContract$Presenter;", "presenter", "Lid/dana/social/contract/reaction/ReactionsContract$Presenter;", "", "Lid/dana/feeds/ui/reaction/model/ReactionModel;", "NetworkUserEntityData$$ExternalSyntheticLambda0", "Ljava/util/List;", "getAuthRequestContext", "", "lookAheadTest", "Ljava/lang/String;", "KClassImpl$Data$declaredNonStaticMembers$2", "", "Lid/dana/social/model/ReactionCountModel;", "moveToNextValue", "<init>", "(Lid/dana/social/model/FeedModel;Ljava/lang/String;)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ActivityReactionsBottomSheetDialog extends BaseBottomSheetDialogFragment {
    public Map<Integer, View> KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda0  reason: from kotlin metadata */
    private final List<ReactionModel> getAuthRequestContext;

    /* renamed from: getErrorConfigVersion  reason: from kotlin metadata */
    private final FeedModel PlaceComponentResult;

    /* renamed from: lookAheadTest  reason: from kotlin metadata */
    private String KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: moveToNextValue  reason: from kotlin metadata */
    public List<ReactionCountModel> NetworkUserEntityData$$ExternalSyntheticLambda0;
    @Inject
    public ReactionsContract.Presenter presenter;

    /* renamed from: scheduleImpl  reason: from kotlin metadata */
    private ActivityReactionsViewPagerAdapter BuiltInFictitiousFunctionClassFactory;

    @Override // id.dana.base.BaseBottomSheetDialogFragment
    public final float getDimAmount() {
        return 0.0f;
    }

    public ActivityReactionsBottomSheetDialog(FeedModel feedModel, String str) {
        Intrinsics.checkNotNullParameter(feedModel, "");
        Intrinsics.checkNotNullParameter(str, "");
        this.KClassImpl$Data$declaredNonStaticMembers$2 = new LinkedHashMap();
        this.PlaceComponentResult = feedModel;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = str;
        this.getAuthRequestContext = new ArrayList();
    }

    @Override // id.dana.base.BaseBottomSheetDialogFragment
    @JvmName(name = "getBindingInflater")
    public final Function1<LayoutInflater, BottomSheetActivityReactionsCoordinatorBinding> getBindingInflater() {
        return new Function1<LayoutInflater, BottomSheetActivityReactionsCoordinatorBinding>() { // from class: id.dana.social.view.ActivityReactionsBottomSheetDialog$bindingInflater$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final BottomSheetActivityReactionsCoordinatorBinding invoke(LayoutInflater layoutInflater) {
                Intrinsics.checkNotNullParameter(layoutInflater, "");
                BottomSheetActivityReactionsCoordinatorBinding authRequestContext = BottomSheetActivityReactionsCoordinatorBinding.getAuthRequestContext(LayoutInflater.from(ActivityReactionsBottomSheetDialog.this.getContext()));
                Intrinsics.checkNotNullExpressionValue(authRequestContext, "");
                return authRequestContext;
            }
        };
    }

    @Override // id.dana.base.BaseBottomSheetDialogFragment
    public final void initBottomSheet(int p0, int p1) {
        WindowManager windowManager;
        Display defaultDisplay;
        DisplayMetrics displayMetrics = new DisplayMetrics();
        BaseActivity baseActivity = getBaseActivity();
        if (baseActivity != null && (windowManager = baseActivity.getWindowManager()) != null && (defaultDisplay = windowManager.getDefaultDisplay()) != null) {
            defaultDisplay.getMetrics(displayMetrics);
        }
        super.initBottomSheet(displayMetrics.heightPixels, 3);
    }

    @Override // id.dana.base.BaseBottomSheetDialogFragment
    public final void onShow() {
        DanaApplication danaApplication;
        SocialCommonComponent socialCommonComponent;
        super.onShow();
        BaseActivity baseActivity = getBaseActivity();
        if (baseActivity != null && (danaApplication = baseActivity.getDanaApplication()) != null && (socialCommonComponent = danaApplication.getSocialCommonComponent()) != null) {
            socialCommonComponent.KClassImpl$Data$declaredNonStaticMembers$2(new ReactionsModule(new ReactionsContract.View() { // from class: id.dana.social.view.ActivityReactionsBottomSheetDialog$getReactionModuleView$1
                @Override // id.dana.social.contract.reaction.ReactionsContract.View
                public final String BuiltInFictitiousFunctionClassFactory() {
                    return "Reaction";
                }

                @Override // id.dana.social.contract.reaction.ReactionsContract.View
                public final /* synthetic */ void BuiltInFictitiousFunctionClassFactory(DeleteReactionResult deleteReactionResult) {
                    Intrinsics.checkNotNullParameter(deleteReactionResult, "");
                }

                @Override // id.dana.social.contract.reaction.ReactionsContract.View
                public final /* synthetic */ void MyBillsEntityDataFactory() {
                    ReactionsContract.View.CC.getAuthRequestContext();
                }

                @Override // id.dana.social.contract.reaction.ReactionsContract.View
                public final /* synthetic */ void PlaceComponentResult() {
                    ReactionsContract.View.CC.KClassImpl$Data$declaredNonStaticMembers$2();
                }

                @Override // id.dana.social.contract.reaction.ReactionsContract.View
                public final /* synthetic */ void getAuthRequestContext(ReactionResultModel reactionResultModel) {
                    ReactionsContract.View.CC.getAuthRequestContext(reactionResultModel);
                }

                @Override // id.dana.social.contract.reaction.ReactionsContract.View
                public final void BuiltInFictitiousFunctionClassFactory(List<ReactionModel> p0) {
                    List list;
                    Intrinsics.checkNotNullParameter(p0, "");
                    list = ActivityReactionsBottomSheetDialog.this.getAuthRequestContext;
                    list.addAll(CollectionsKt.toMutableList((Collection) p0));
                    ActivityReactionsBottomSheetDialog.KClassImpl$Data$declaredNonStaticMembers$2(ActivityReactionsBottomSheetDialog.this);
                }

                @Override // id.dana.social.contract.reaction.ReactionsContract.View
                public final void PlaceComponentResult(List<ReactionModel> p0) {
                    List list;
                    Intrinsics.checkNotNullParameter(p0, "");
                    list = ActivityReactionsBottomSheetDialog.this.getAuthRequestContext;
                    list.addAll(CollectionsKt.toMutableList((Collection) p0));
                    ActivityReactionsBottomSheetDialog.KClassImpl$Data$declaredNonStaticMembers$2(ActivityReactionsBottomSheetDialog.this);
                }

                @Override // id.dana.social.contract.reaction.ReactionsContract.View
                public final String getShownErrorMessage() {
                    String shownErrorMessage;
                    shownErrorMessage = ActivityReactionsBottomSheetDialog.this.getShownErrorMessage();
                    Intrinsics.checkNotNullExpressionValue(shownErrorMessage, "");
                    return shownErrorMessage;
                }
            })).MyBillsEntityDataFactory(this);
        }
        ReactionsContract.Presenter presenter = this.presenter;
        if (presenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            presenter = null;
        }
        presenter.getAuthRequestContext();
        initBottomSheet(9999, 3);
        List<ReactionCountModel> sortedWith = CollectionsKt.sortedWith(this.PlaceComponentResult.NetworkUserEntityData$$ExternalSyntheticLambda8, new Comparator() { // from class: id.dana.social.view.ActivityReactionsBottomSheetDialog$sortReactionCounts$$inlined$sortedByDescending$1
            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                return ComparisonsKt.compareValues(Integer.valueOf(((ReactionCountModel) t2).getAuthRequestContext), Integer.valueOf(((ReactionCountModel) t).getAuthRequestContext));
            }
        });
        Intrinsics.checkNotNullParameter(sortedWith, "");
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = sortedWith;
    }

    @Override // id.dana.base.BaseBottomSheetDialogFragment
    public final void init() {
        BottomSheetActivityReactionsBinding bottomSheetActivityReactionsBinding;
        FrameLayout frameLayout;
        BottomSheetActivityReactionsBinding bottomSheetActivityReactionsBinding2;
        FrameLayout frameLayout2;
        WindowManager windowManager;
        Display defaultDisplay;
        Resources.Theme theme;
        super.init();
        TypedValue typedValue = new TypedValue();
        BaseActivity baseActivity = getBaseActivity();
        if (baseActivity != null && (theme = baseActivity.getTheme()) != null) {
            theme.resolveAttribute(16843499, typedValue, true);
        }
        int dimensionPixelSize = getResources().getDimensionPixelSize(typedValue.resourceId);
        DisplayMetrics displayMetrics = new DisplayMetrics();
        BaseActivity baseActivity2 = getBaseActivity();
        if (baseActivity2 != null && (windowManager = baseActivity2.getWindowManager()) != null && (defaultDisplay = windowManager.getDefaultDisplay()) != null) {
            defaultDisplay.getMetrics(displayMetrics);
        }
        int i = displayMetrics.heightPixels;
        ViewBinding viewBinding = getViewBinding();
        BottomSheetActivityReactionsCoordinatorBinding bottomSheetActivityReactionsCoordinatorBinding = viewBinding instanceof BottomSheetActivityReactionsCoordinatorBinding ? (BottomSheetActivityReactionsCoordinatorBinding) viewBinding : null;
        ViewGroup.LayoutParams layoutParams = (bottomSheetActivityReactionsCoordinatorBinding == null || (bottomSheetActivityReactionsBinding2 = bottomSheetActivityReactionsCoordinatorBinding.BuiltInFictitiousFunctionClassFactory) == null || (frameLayout2 = bottomSheetActivityReactionsBinding2.BuiltInFictitiousFunctionClassFactory) == null) ? null : frameLayout2.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.height = i - dimensionPixelSize;
        }
        ViewBinding viewBinding2 = getViewBinding();
        BottomSheetActivityReactionsCoordinatorBinding bottomSheetActivityReactionsCoordinatorBinding2 = viewBinding2 instanceof BottomSheetActivityReactionsCoordinatorBinding ? (BottomSheetActivityReactionsCoordinatorBinding) viewBinding2 : null;
        if (bottomSheetActivityReactionsCoordinatorBinding2 == null || (bottomSheetActivityReactionsBinding = bottomSheetActivityReactionsCoordinatorBinding2.BuiltInFictitiousFunctionClassFactory) == null || (frameLayout = bottomSheetActivityReactionsBinding.BuiltInFictitiousFunctionClassFactory) == null) {
            return;
        }
        frameLayout.requestLayout();
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onStart() {
        super.onStart();
        Dialog dialog = getDialog();
        final View findViewById = dialog != null ? dialog.findViewById(R.id.design_bottom_sheet) : null;
        ViewGroup.LayoutParams layoutParams = findViewById != null ? findViewById.getLayoutParams() : null;
        if (layoutParams != null) {
            layoutParams.height = -1;
        }
        final View view = getView();
        if (view != null) {
            view.post(new Runnable() { // from class: id.dana.social.view.ActivityReactionsBottomSheetDialog$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    ActivityReactionsBottomSheetDialog.MyBillsEntityDataFactory(view, findViewById, this);
                }
            });
        }
    }

    @Override // id.dana.base.BaseBottomSheetDialogFragment
    public final void onDismiss() {
        super.onDismiss();
        dismiss();
    }

    public static /* synthetic */ void PlaceComponentResult(ActivityReactionsBottomSheetDialog activityReactionsBottomSheetDialog) {
        Intrinsics.checkNotNullParameter(activityReactionsBottomSheetDialog, "");
        activityReactionsBottomSheetDialog.dismiss();
    }

    public static /* synthetic */ void MyBillsEntityDataFactory(View view, View view2, final ActivityReactionsBottomSheetDialog activityReactionsBottomSheetDialog) {
        CoordinatorLayout coordinatorLayout;
        Intrinsics.checkNotNullParameter(view, "");
        Intrinsics.checkNotNullParameter(activityReactionsBottomSheetDialog, "");
        ViewParent parent = view.getParent();
        if (parent == null) {
            throw new NullPointerException("null cannot be cast to non-null type android.view.View");
        }
        ViewGroup.LayoutParams layoutParams = ((View) parent).getLayoutParams();
        if (layoutParams == null) {
            throw new NullPointerException("null cannot be cast to non-null type androidx.coordinatorlayout.widget.CoordinatorLayout.LayoutParams");
        }
        CoordinatorLayout.Behavior behavior = ((CoordinatorLayout.LayoutParams) layoutParams).lookAheadTest;
        if (behavior == null) {
            throw new NullPointerException("null cannot be cast to non-null type com.google.android.material.bottomsheet.BottomSheetBehavior<@[FlexibleNullability] android.view.View?>");
        }
        ((BottomSheetBehavior) behavior).setPeekHeight(view.getMeasuredHeight());
        ViewParent parent2 = view2 != null ? view2.getParent() : null;
        if (parent2 == null) {
            throw new NullPointerException("null cannot be cast to non-null type android.view.View");
        }
        ((View) parent2).setBackgroundColor(0);
        ViewBinding viewBinding = activityReactionsBottomSheetDialog.getViewBinding();
        BottomSheetActivityReactionsCoordinatorBinding bottomSheetActivityReactionsCoordinatorBinding = viewBinding instanceof BottomSheetActivityReactionsCoordinatorBinding ? (BottomSheetActivityReactionsCoordinatorBinding) viewBinding : null;
        if (bottomSheetActivityReactionsCoordinatorBinding == null || (coordinatorLayout = bottomSheetActivityReactionsCoordinatorBinding.MyBillsEntityDataFactory) == null) {
            return;
        }
        coordinatorLayout.setOnClickListener(new View.OnClickListener() { // from class: id.dana.social.view.ActivityReactionsBottomSheetDialog$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view3) {
                ActivityReactionsBottomSheetDialog.PlaceComponentResult(ActivityReactionsBottomSheetDialog.this);
            }
        });
    }

    public static final /* synthetic */ void KClassImpl$Data$declaredNonStaticMembers$2(ActivityReactionsBottomSheetDialog activityReactionsBottomSheetDialog) {
        int i;
        BottomSheetActivityReactionsBinding bottomSheetActivityReactionsBinding;
        TabLayout tabLayout;
        TabLayout.Tab tabAt;
        BottomSheetActivityReactionsBinding bottomSheetActivityReactionsBinding2;
        TabLayout tabLayout2;
        int tabCount;
        BottomSheetActivityReactionsBinding bottomSheetActivityReactionsBinding3;
        TabLayout tabLayout3;
        BottomSheetActivityReactionsBinding bottomSheetActivityReactionsBinding4;
        BottomSheetActivityReactionsBinding bottomSheetActivityReactionsBinding5;
        FragmentManager childFragmentManager = activityReactionsBottomSheetDialog.getChildFragmentManager();
        Intrinsics.checkNotNullExpressionValue(childFragmentManager, "");
        activityReactionsBottomSheetDialog.BuiltInFictitiousFunctionClassFactory = new ActivityReactionsViewPagerAdapter(childFragmentManager, activityReactionsBottomSheetDialog.getContext());
        List<ReactionCountModel> list = activityReactionsBottomSheetDialog.NetworkUserEntityData$$ExternalSyntheticLambda0;
        if (list == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            list = null;
        }
        int size = list.size();
        int i2 = 0;
        int i3 = 0;
        while (true) {
            i = -1;
            if (i3 >= size) {
                break;
            }
            ActivityReactionsViewPagerAdapter activityReactionsViewPagerAdapter = activityReactionsBottomSheetDialog.BuiltInFictitiousFunctionClassFactory;
            if (activityReactionsViewPagerAdapter == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
                activityReactionsViewPagerAdapter = null;
            }
            String str = activityReactionsBottomSheetDialog.PlaceComponentResult.NetworkUserEntityData$$ExternalSyntheticLambda1;
            List<ReactionCountModel> list2 = activityReactionsBottomSheetDialog.NetworkUserEntityData$$ExternalSyntheticLambda0;
            if (list2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
                list2 = null;
            }
            ReactionCountModel reactionCountModel = list2.get(i3);
            List<ReactionCountModel> list3 = activityReactionsBottomSheetDialog.NetworkUserEntityData$$ExternalSyntheticLambda0;
            if (list3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
                list3 = null;
            }
            String str2 = list3.get(i3).PlaceComponentResult;
            if (true ^ activityReactionsBottomSheetDialog.getAuthRequestContext.isEmpty()) {
                Iterator<ReactionModel> it = activityReactionsBottomSheetDialog.getAuthRequestContext.iterator();
                int i4 = 0;
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    } else if (Intrinsics.areEqual(it.next().BuiltInFictitiousFunctionClassFactory, str2)) {
                        i = i4;
                        break;
                    } else {
                        i4++;
                    }
                }
                if (i >= 0) {
                    str2 = activityReactionsBottomSheetDialog.getAuthRequestContext.get(i).KClassImpl$Data$declaredNonStaticMembers$2;
                }
            }
            ActivityReactionsViewPagerAdapter.Params params = new ActivityReactionsViewPagerAdapter.Params(str, reactionCountModel, str2);
            Intrinsics.checkNotNullParameter(params, "");
            activityReactionsViewPagerAdapter.PlaceComponentResult.add(new ActivityReactionsListFragment(params.KClassImpl$Data$declaredNonStaticMembers$2, params.MyBillsEntityDataFactory, params.getAuthRequestContext));
            activityReactionsViewPagerAdapter.getAuthRequestContext.add(params.MyBillsEntityDataFactory);
            i3++;
        }
        ViewBinding viewBinding = activityReactionsBottomSheetDialog.getViewBinding();
        BottomSheetActivityReactionsCoordinatorBinding bottomSheetActivityReactionsCoordinatorBinding = viewBinding instanceof BottomSheetActivityReactionsCoordinatorBinding ? (BottomSheetActivityReactionsCoordinatorBinding) viewBinding : null;
        ViewPager viewPager = (bottomSheetActivityReactionsCoordinatorBinding == null || (bottomSheetActivityReactionsBinding5 = bottomSheetActivityReactionsCoordinatorBinding.BuiltInFictitiousFunctionClassFactory) == null) ? null : bottomSheetActivityReactionsBinding5.getAuthRequestContext;
        if (viewPager != null) {
            ActivityReactionsViewPagerAdapter activityReactionsViewPagerAdapter2 = activityReactionsBottomSheetDialog.BuiltInFictitiousFunctionClassFactory;
            if (activityReactionsViewPagerAdapter2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
                activityReactionsViewPagerAdapter2 = null;
            }
            viewPager.setAdapter(activityReactionsViewPagerAdapter2);
        }
        ViewBinding viewBinding2 = activityReactionsBottomSheetDialog.getViewBinding();
        BottomSheetActivityReactionsCoordinatorBinding bottomSheetActivityReactionsCoordinatorBinding2 = viewBinding2 instanceof BottomSheetActivityReactionsCoordinatorBinding ? (BottomSheetActivityReactionsCoordinatorBinding) viewBinding2 : null;
        if (bottomSheetActivityReactionsCoordinatorBinding2 != null && (bottomSheetActivityReactionsBinding3 = bottomSheetActivityReactionsCoordinatorBinding2.BuiltInFictitiousFunctionClassFactory) != null && (tabLayout3 = bottomSheetActivityReactionsBinding3.MyBillsEntityDataFactory) != null) {
            tabLayout3.setTabMode(0);
            ViewBinding viewBinding3 = activityReactionsBottomSheetDialog.getViewBinding();
            BottomSheetActivityReactionsCoordinatorBinding bottomSheetActivityReactionsCoordinatorBinding3 = viewBinding3 instanceof BottomSheetActivityReactionsCoordinatorBinding ? (BottomSheetActivityReactionsCoordinatorBinding) viewBinding3 : null;
            tabLayout3.setupWithViewPager((bottomSheetActivityReactionsCoordinatorBinding3 == null || (bottomSheetActivityReactionsBinding4 = bottomSheetActivityReactionsCoordinatorBinding3.BuiltInFictitiousFunctionClassFactory) == null) ? null : bottomSheetActivityReactionsBinding4.getAuthRequestContext);
        }
        ViewBinding viewBinding4 = activityReactionsBottomSheetDialog.getViewBinding();
        BottomSheetActivityReactionsCoordinatorBinding bottomSheetActivityReactionsCoordinatorBinding4 = viewBinding4 instanceof BottomSheetActivityReactionsCoordinatorBinding ? (BottomSheetActivityReactionsCoordinatorBinding) viewBinding4 : null;
        if (bottomSheetActivityReactionsCoordinatorBinding4 != null && (bottomSheetActivityReactionsBinding2 = bottomSheetActivityReactionsCoordinatorBinding4.BuiltInFictitiousFunctionClassFactory) != null && (tabLayout2 = bottomSheetActivityReactionsBinding2.MyBillsEntityDataFactory) != null && (tabCount = tabLayout2.getTabCount()) >= 0) {
            int i5 = 0;
            while (true) {
                TabLayout.Tab tabAt2 = tabLayout2.getTabAt(i5);
                if (tabAt2 != null) {
                    ActivityReactionsViewPagerAdapter activityReactionsViewPagerAdapter3 = activityReactionsBottomSheetDialog.BuiltInFictitiousFunctionClassFactory;
                    if (activityReactionsViewPagerAdapter3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("");
                        activityReactionsViewPagerAdapter3 = null;
                    }
                    ReactionCountModel reactionCountModel2 = activityReactionsViewPagerAdapter3.getAuthRequestContext.get(i5);
                    View inflate = LayoutInflater.from(activityReactionsViewPagerAdapter3.BuiltInFictitiousFunctionClassFactory).inflate(R.layout.activity_reactions_custom_tab_layout, (ViewGroup) null);
                    Intrinsics.checkNotNullExpressionValue(inflate, "");
                    EmojiAppCompatTextView emojiAppCompatTextView = (EmojiAppCompatTextView) inflate.findViewById(R.id.tv_feed_reaction_emoji);
                    if (emojiAppCompatTextView != null) {
                        EmojiUtil emojiUtil = EmojiUtil.INSTANCE;
                        emojiAppCompatTextView.setText(EmojiUtil.getAuthRequestContext(reactionCountModel2.PlaceComponentResult));
                    }
                    TextView textView = (TextView) inflate.findViewById(R.id.tv_feed_reaction_counter);
                    if (textView != null) {
                        String valueOf = !(reactionCountModel2.getAuthRequestContext > 99) ? String.valueOf(reactionCountModel2.getAuthRequestContext) : null;
                        if (valueOf == null) {
                            valueOf = "99+";
                        }
                        textView.setText(valueOf);
                    }
                    tabAt2.setCustomView(inflate);
                }
                if (i5 == tabCount) {
                    break;
                }
                i5++;
            }
        }
        if (Intrinsics.areEqual(activityReactionsBottomSheetDialog.KClassImpl$Data$declaredNonStaticMembers$2, "")) {
            return;
        }
        List<ReactionCountModel> list4 = activityReactionsBottomSheetDialog.NetworkUserEntityData$$ExternalSyntheticLambda0;
        if (list4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            list4 = null;
        }
        Iterator<ReactionCountModel> it2 = list4.iterator();
        while (true) {
            if (!it2.hasNext()) {
                break;
            } else if (Intrinsics.areEqual(it2.next().PlaceComponentResult, activityReactionsBottomSheetDialog.KClassImpl$Data$declaredNonStaticMembers$2)) {
                i = i2;
                break;
            } else {
                i2++;
            }
        }
        if (i >= 0) {
            ViewBinding viewBinding5 = activityReactionsBottomSheetDialog.getViewBinding();
            BottomSheetActivityReactionsCoordinatorBinding bottomSheetActivityReactionsCoordinatorBinding5 = viewBinding5 instanceof BottomSheetActivityReactionsCoordinatorBinding ? (BottomSheetActivityReactionsCoordinatorBinding) viewBinding5 : null;
            if (bottomSheetActivityReactionsCoordinatorBinding5 == null || (bottomSheetActivityReactionsBinding = bottomSheetActivityReactionsCoordinatorBinding5.BuiltInFictitiousFunctionClassFactory) == null || (tabLayout = bottomSheetActivityReactionsBinding.MyBillsEntityDataFactory) == null || (tabAt = tabLayout.getTabAt(i)) == null) {
                return;
            }
            tabAt.select();
        }
    }

    @Override // id.dana.base.BaseBottomSheetDialogFragment
    public final /* synthetic */ ViewBinding getBinding() {
        ViewBinding viewBinding = getViewBinding();
        return viewBinding instanceof BottomSheetActivityReactionsCoordinatorBinding ? (BottomSheetActivityReactionsCoordinatorBinding) viewBinding : null;
    }

    @Override // id.dana.base.BaseBottomSheetDialogFragment
    /* renamed from: getBottomSheet */
    public final /* synthetic */ View getPlaceComponentResult() {
        BottomSheetActivityReactionsBinding bottomSheetActivityReactionsBinding;
        ViewBinding viewBinding = getViewBinding();
        FrameLayout frameLayout = null;
        BottomSheetActivityReactionsCoordinatorBinding bottomSheetActivityReactionsCoordinatorBinding = viewBinding instanceof BottomSheetActivityReactionsCoordinatorBinding ? (BottomSheetActivityReactionsCoordinatorBinding) viewBinding : null;
        if (bottomSheetActivityReactionsCoordinatorBinding != null && (bottomSheetActivityReactionsBinding = bottomSheetActivityReactionsCoordinatorBinding.BuiltInFictitiousFunctionClassFactory) != null) {
            frameLayout = bottomSheetActivityReactionsBinding.BuiltInFictitiousFunctionClassFactory;
        }
        return frameLayout;
    }

    @Override // id.dana.base.BaseBottomSheetDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        this.KClassImpl$Data$declaredNonStaticMembers$2.clear();
    }
}
