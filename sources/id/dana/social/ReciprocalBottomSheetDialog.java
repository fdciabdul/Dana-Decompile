package id.dana.social;

import android.app.Dialog;
import android.content.Intent;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewbinding.ViewBinding;
import com.alipay.iap.android.common.syncintegration.api.IAPSyncCommand;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import id.dana.R;
import id.dana.base.BaseBottomSheetDialogFragment;
import id.dana.databinding.BottomSheetReciprocalBinding;
import id.dana.feeds.ui.model.FriendModel;
import id.dana.social.AddFriendListFragment;
import id.dana.social.ReciprocalBottomSheetDialog;
import id.dana.social.ReciprocalFriendListFragment;
import id.dana.social.adapter.FriendRequestAdapter;
import id.dana.social.adapter.FriendRequestListActivity;
import id.dana.social.adapter.ReciprocalFriendListAdapter;
import id.dana.social.contract.FriendRequestContract;
import id.dana.social.contract.RelationshipBottomSheetContract;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 (2\u00020\u0001:\u0002)(B\u0007¢\u0006\u0004\b'\u0010\nJ\u0011\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0014¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0014¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH\u0014¢\u0006\u0004\b\t\u0010\nJ\u001f\u0010\u000e\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000bH\u0014¢\u0006\u0004\b\u000e\u0010\u000fJ)\u0010\u0012\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000b2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0014\u001a\u00020\bH\u0014¢\u0006\u0004\b\u0014\u0010\nJ\u000f\u0010\u0015\u001a\u00020\bH\u0016¢\u0006\u0004\b\u0015\u0010\nR \u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00180\u00168WX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u001aR\u0013\u0010\u001f\u001a\u00020\u001cX\u0083\u0080\u0002¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0014\u0010#\u001a\u00020 8\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b!\u0010\"R\u0013\u0010&\u001a\u00020$X\u0083\u0080\u0002¢\u0006\u0006\n\u0004\b%\u0010\u001e"}, d2 = {"Lid/dana/social/ReciprocalBottomSheetDialog;", "Lid/dana/base/BaseBottomSheetDialogFragment;", "Landroid/view/View;", "getBottomSheet", "()Landroid/view/View;", "", "getDimAmount", "()F", "", IAPSyncCommand.COMMAND_INIT, "()V", "", "p0", "p1", "initBottomSheet", "(II)V", "Landroid/content/Intent;", "p2", "onActivityResult", "(IILandroid/content/Intent;)V", "onShow", "onStart", "Lkotlin/Function1;", "Landroid/view/LayoutInflater;", "Lid/dana/databinding/BottomSheetReciprocalBinding;", "getBindingInflater", "()Lkotlin/jvm/functions/Function1;", "BuiltInFictitiousFunctionClassFactory", "Lid/dana/social/AddFriendListFragment;", "getErrorConfigVersion", "Lkotlin/Lazy;", "PlaceComponentResult", "Lid/dana/social/ReciprocalBottomSheetDialog$BaseFriendListListener;", "NetworkUserEntityData$$ExternalSyntheticLambda0", "Lid/dana/social/ReciprocalBottomSheetDialog$BaseFriendListListener;", "getAuthRequestContext", "Lid/dana/social/ReciprocalFriendListFragment;", "scheduleImpl", "MyBillsEntityDataFactory", "<init>", "Companion", "BaseFriendListListener"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ReciprocalBottomSheetDialog extends BaseBottomSheetDialogFragment {
    public Map<Integer, View> KClassImpl$Data$declaredNonStaticMembers$2 = new LinkedHashMap();

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda0  reason: from kotlin metadata */
    private final BaseFriendListListener getAuthRequestContext = new BaseFriendListListener() { // from class: id.dana.social.ReciprocalBottomSheetDialog$getListener$1
        @Override // id.dana.social.ReciprocalBottomSheetDialog.BaseFriendListListener
        public final void BuiltInFictitiousFunctionClassFactory() {
            ReciprocalBottomSheetDialog.PlaceComponentResult(ReciprocalBottomSheetDialog.this);
        }

        @Override // id.dana.social.ReciprocalBottomSheetDialog.BaseFriendListListener
        public final void BuiltInFictitiousFunctionClassFactory(boolean p0) {
            if (ReciprocalBottomSheetDialog.this.getChildFragmentManager().findFragmentByTag("AddFriendListFragment") != null) {
                ReciprocalBottomSheetDialog.this.getChildFragmentManager().beginTransaction().PlaceComponentResult(ReciprocalBottomSheetDialog.getAuthRequestContext(ReciprocalBottomSheetDialog.this)).getAuthRequestContext();
            } else {
                ReciprocalBottomSheetDialog.this.getChildFragmentManager().popBackStack();
            }
            if (p0) {
                ReciprocalFriendListFragment BuiltInFictitiousFunctionClassFactory = ReciprocalBottomSheetDialog.BuiltInFictitiousFunctionClassFactory(ReciprocalBottomSheetDialog.this);
                ReciprocalFriendListAdapter reciprocalFriendListAdapter = BuiltInFictitiousFunctionClassFactory.scheduleImpl;
                FriendRequestContract.Presenter presenter = null;
                if (reciprocalFriendListAdapter == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                    reciprocalFriendListAdapter = null;
                }
                reciprocalFriendListAdapter.PlaceComponentResult();
                RelationshipBottomSheetContract.Presenter presenter2 = BuiltInFictitiousFunctionClassFactory.presenter;
                if (presenter2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                    presenter2 = null;
                }
                presenter2.BuiltInFictitiousFunctionClassFactory();
                if (BuiltInFictitiousFunctionClassFactory.getAuthRequestContext) {
                    FriendRequestAdapter friendRequestAdapter = BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory;
                    if (friendRequestAdapter == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("");
                        friendRequestAdapter = null;
                    }
                    friendRequestAdapter.getAuthRequestContext();
                    FriendRequestContract.Presenter presenter3 = BuiltInFictitiousFunctionClassFactory.friendRequestPresenter;
                    if (presenter3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("");
                        presenter3 = null;
                    }
                    presenter3.PlaceComponentResult();
                    FriendRequestContract.Presenter presenter4 = BuiltInFictitiousFunctionClassFactory.friendRequestPresenter;
                    if (presenter4 != null) {
                        presenter = presenter4;
                    } else {
                        Intrinsics.throwUninitializedPropertyAccessException("");
                    }
                    presenter.getAuthRequestContext(10);
                }
            }
        }

        @Override // id.dana.social.ReciprocalBottomSheetDialog.BaseFriendListListener
        public final void BuiltInFictitiousFunctionClassFactory(List<FriendModel> p0, boolean p1, String p2) {
            Intrinsics.checkNotNullParameter(p0, "");
            Intrinsics.checkNotNullParameter(p2, "");
            Intent intent = new Intent(ReciprocalBottomSheetDialog.this.getActivity(), FriendRequestListActivity.class);
            intent.putParcelableArrayListExtra(FriendRequestListActivity.FRIEND_REQUEST_LIST_BUNDLE, new ArrayList<>(p0));
            intent.putExtra(FriendRequestListActivity.FRIEND_REQUEST_HAS_MORE_BUNDLE, p1);
            intent.putExtra(FriendRequestListActivity.FRIEND_REQUEST_MIN_ID_BUNDLE, p2);
            ReciprocalBottomSheetDialog.this.startActivityForResult(intent, 999);
        }
    };

    /* renamed from: scheduleImpl  reason: from kotlin metadata */
    private final Lazy MyBillsEntityDataFactory = LazyKt.lazy(new Function0<ReciprocalFriendListFragment>() { // from class: id.dana.social.ReciprocalBottomSheetDialog$reciprocalListFragment$2
        /* JADX INFO: Access modifiers changed from: package-private */
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final ReciprocalFriendListFragment invoke() {
            ReciprocalBottomSheetDialog.BaseFriendListListener baseFriendListListener;
            ReciprocalFriendListFragment.Companion companion = ReciprocalFriendListFragment.INSTANCE;
            baseFriendListListener = ReciprocalBottomSheetDialog.this.getAuthRequestContext;
            return ReciprocalFriendListFragment.Companion.getAuthRequestContext(baseFriendListListener);
        }
    });

    /* renamed from: getErrorConfigVersion  reason: from kotlin metadata */
    private final Lazy PlaceComponentResult = LazyKt.lazy(new Function0<AddFriendListFragment>() { // from class: id.dana.social.ReciprocalBottomSheetDialog$findFriendListFragment$2
        /* JADX INFO: Access modifiers changed from: package-private */
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final AddFriendListFragment invoke() {
            ReciprocalBottomSheetDialog.BaseFriendListListener baseFriendListListener;
            AddFriendListFragment.Companion companion = AddFriendListFragment.INSTANCE;
            baseFriendListListener = ReciprocalBottomSheetDialog.this.getAuthRequestContext;
            return AddFriendListFragment.Companion.BuiltInFictitiousFunctionClassFactory(baseFriendListListener);
        }
    });

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005H\u0016J\b\u0010\u0006\u001a\u00020\u0003H\u0016J&\u0010\u0007\u001a\u00020\u00032\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u0006\u0010\u000b\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\rH\u0016ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u000eÀ\u0006\u0001"}, d2 = {"Lid/dana/social/ReciprocalBottomSheetDialog$BaseFriendListListener;", "", "onBackToPreviousPage", "", "isNeedToRefreshData", "", "onClickAddNewFriend", "onViewAllFriendRequest", "friendRequestList", "", "Lid/dana/feeds/ui/model/FriendModel;", "hasMore", "minId", "", "app_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public interface BaseFriendListListener {
        void BuiltInFictitiousFunctionClassFactory();

        void BuiltInFictitiousFunctionClassFactory(List<FriendModel> list, boolean z, String str);

        void BuiltInFictitiousFunctionClassFactory(boolean z);
    }

    @Override // id.dana.base.BaseBottomSheetDialogFragment
    public final float getDimAmount() {
        return 0.0f;
    }

    @Override // id.dana.base.BaseBottomSheetDialogFragment
    @JvmName(name = "getBindingInflater")
    public final Function1<LayoutInflater, BottomSheetReciprocalBinding> getBindingInflater() {
        return new Function1<LayoutInflater, BottomSheetReciprocalBinding>() { // from class: id.dana.social.ReciprocalBottomSheetDialog$bindingInflater$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final BottomSheetReciprocalBinding invoke(LayoutInflater layoutInflater) {
                Intrinsics.checkNotNullParameter(layoutInflater, "");
                BottomSheetReciprocalBinding authRequestContext = BottomSheetReciprocalBinding.getAuthRequestContext(ReciprocalBottomSheetDialog.this.getLayoutInflater());
                Intrinsics.checkNotNullExpressionValue(authRequestContext, "");
                return authRequestContext;
            }
        };
    }

    @Override // id.dana.base.BaseBottomSheetDialogFragment
    /* renamed from: getBottomSheet */
    public final View getPlaceComponentResult() {
        int i = R.id.cvFriendListContainer;
        Map<Integer, View> map = this.KClassImpl$Data$declaredNonStaticMembers$2;
        View view = map.get(Integer.valueOf(i));
        if (view == null) {
            View view2 = getView();
            if (view2 == null || (view = view2.findViewById(i)) == null) {
                view = null;
            } else {
                map.put(Integer.valueOf(i), view);
            }
        }
        return (FrameLayout) view;
    }

    @Override // id.dana.base.BaseBottomSheetDialogFragment
    public final void initBottomSheet(int p0, int p1) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        getBaseActivity().getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        super.initBottomSheet(displayMetrics.heightPixels, 3);
    }

    @Override // id.dana.base.BaseBottomSheetDialogFragment
    public final void onShow() {
        super.onShow();
        initBottomSheet(9999, 3);
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
            view.post(new Runnable() { // from class: id.dana.social.ReciprocalBottomSheetDialog$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    ReciprocalBottomSheetDialog.getAuthRequestContext(view, findViewById, this);
                }
            });
        }
    }

    @Override // id.dana.base.BaseBottomSheetDialogFragment
    public final void init() {
        FrameLayout frameLayout;
        FrameLayout frameLayout2;
        super.init();
        TypedValue typedValue = new TypedValue();
        getBaseActivity().getTheme().resolveAttribute(16843499, typedValue, true);
        int dimensionPixelSize = getResources().getDimensionPixelSize(typedValue.resourceId);
        DisplayMetrics displayMetrics = new DisplayMetrics();
        getBaseActivity().getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        int i = displayMetrics.heightPixels;
        ViewBinding viewBinding = getViewBinding();
        BottomSheetReciprocalBinding bottomSheetReciprocalBinding = viewBinding instanceof BottomSheetReciprocalBinding ? (BottomSheetReciprocalBinding) viewBinding : null;
        ViewGroup.LayoutParams layoutParams = (bottomSheetReciprocalBinding == null || (frameLayout2 = bottomSheetReciprocalBinding.PlaceComponentResult) == null) ? null : frameLayout2.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.height = i - dimensionPixelSize;
        }
        ViewBinding viewBinding2 = getViewBinding();
        BottomSheetReciprocalBinding bottomSheetReciprocalBinding2 = viewBinding2 instanceof BottomSheetReciprocalBinding ? (BottomSheetReciprocalBinding) viewBinding2 : null;
        if (bottomSheetReciprocalBinding2 != null && (frameLayout = bottomSheetReciprocalBinding2.PlaceComponentResult) != null) {
            frameLayout.requestLayout();
        }
        FragmentTransaction beginTransaction = getChildFragmentManager().beginTransaction();
        beginTransaction.KClassImpl$Data$declaredNonStaticMembers$2(R.id.f3710cvFriendListContainer, (ReciprocalFriendListFragment) this.MyBillsEntityDataFactory.getValue(), "ReciprocalFriendListFragment", 2);
        beginTransaction.getAuthRequestContext();
    }

    @Override // androidx.fragment.app.Fragment
    public final void onActivityResult(int p0, int p1, Intent p2) {
        super.onActivityResult(p0, p1, p2);
        if (p0 == 999 && p1 == -1) {
            FriendRequestContract.Presenter presenter = null;
            ArrayList parcelableArrayListExtra = p2 != null ? p2.getParcelableArrayListExtra(FriendRequestListActivity.FRIEND_REQUEST_LIST_BUNDLE) : null;
            if (parcelableArrayListExtra == null) {
                parcelableArrayListExtra = CollectionsKt.emptyList();
            }
            boolean booleanExtra = p2 != null ? p2.getBooleanExtra(FriendRequestListActivity.FRIEND_REQUEST_HAS_MORE_BUNDLE, false) : false;
            RelationshipBottomSheetContract.Presenter presenter2 = ((ReciprocalFriendListFragment) this.MyBillsEntityDataFactory.getValue()).presenter;
            if (presenter2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
                presenter2 = null;
            }
            presenter2.BuiltInFictitiousFunctionClassFactory();
            FriendRequestContract.Presenter presenter3 = ((ReciprocalFriendListFragment) this.MyBillsEntityDataFactory.getValue()).friendRequestPresenter;
            if (presenter3 != null) {
                presenter = presenter3;
            } else {
                Intrinsics.throwUninitializedPropertyAccessException("");
            }
            presenter.getAuthRequestContext(booleanExtra);
            ((ReciprocalFriendListFragment) this.MyBillsEntityDataFactory.getValue()).MyBillsEntityDataFactory(parcelableArrayListExtra);
        }
    }

    public static /* synthetic */ void getAuthRequestContext(View view, View view2, final ReciprocalBottomSheetDialog reciprocalBottomSheetDialog) {
        FrameLayout frameLayout;
        Intrinsics.checkNotNullParameter(view, "");
        Intrinsics.checkNotNullParameter(reciprocalBottomSheetDialog, "");
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
        ViewBinding viewBinding = reciprocalBottomSheetDialog.getViewBinding();
        BottomSheetReciprocalBinding bottomSheetReciprocalBinding = viewBinding instanceof BottomSheetReciprocalBinding ? (BottomSheetReciprocalBinding) viewBinding : null;
        if (bottomSheetReciprocalBinding == null || (frameLayout = bottomSheetReciprocalBinding.PlaceComponentResult) == null) {
            return;
        }
        frameLayout.setOnClickListener(new View.OnClickListener() { // from class: id.dana.social.ReciprocalBottomSheetDialog$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view3) {
                ReciprocalBottomSheetDialog.KClassImpl$Data$declaredNonStaticMembers$2(ReciprocalBottomSheetDialog.this);
            }
        });
    }

    public static /* synthetic */ void KClassImpl$Data$declaredNonStaticMembers$2(ReciprocalBottomSheetDialog reciprocalBottomSheetDialog) {
        Intrinsics.checkNotNullParameter(reciprocalBottomSheetDialog, "");
        reciprocalBottomSheetDialog.dismiss();
    }

    public static final /* synthetic */ AddFriendListFragment getAuthRequestContext(ReciprocalBottomSheetDialog reciprocalBottomSheetDialog) {
        return (AddFriendListFragment) reciprocalBottomSheetDialog.PlaceComponentResult.getValue();
    }

    public static final /* synthetic */ ReciprocalFriendListFragment BuiltInFictitiousFunctionClassFactory(ReciprocalBottomSheetDialog reciprocalBottomSheetDialog) {
        return (ReciprocalFriendListFragment) reciprocalBottomSheetDialog.MyBillsEntityDataFactory.getValue();
    }

    public static final /* synthetic */ void PlaceComponentResult(ReciprocalBottomSheetDialog reciprocalBottomSheetDialog) {
        FragmentTransaction beginTransaction = reciprocalBottomSheetDialog.getChildFragmentManager().beginTransaction();
        Intrinsics.checkNotNullExpressionValue(beginTransaction, "");
        if (reciprocalBottomSheetDialog.getChildFragmentManager().findFragmentByTag("AddFriendListFragment") != null) {
            beginTransaction.BuiltInFictitiousFunctionClassFactory((AddFriendListFragment) reciprocalBottomSheetDialog.PlaceComponentResult.getValue());
        } else {
            beginTransaction.KClassImpl$Data$declaredNonStaticMembers$2(R.id.f3710cvFriendListContainer, (AddFriendListFragment) reciprocalBottomSheetDialog.PlaceComponentResult.getValue(), "AddFriendListFragment", 1);
        }
        beginTransaction.getAuthRequestContext();
    }

    @Override // id.dana.base.BaseBottomSheetDialogFragment
    public final /* synthetic */ ViewBinding getBinding() {
        ViewBinding viewBinding = getViewBinding();
        return viewBinding instanceof BottomSheetReciprocalBinding ? (BottomSheetReciprocalBinding) viewBinding : null;
    }

    @Override // id.dana.base.BaseBottomSheetDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        this.KClassImpl$Data$declaredNonStaticMembers$2.clear();
    }
}
