package id.dana.social;

import android.text.Editable;
import android.text.InputFilter;
import android.text.Spanned;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.alipay.iap.android.common.syncintegration.api.IAPSyncCommand;
import id.dana.R;
import id.dana.base.AbstractContractKt;
import id.dana.base.BaseActivity;
import id.dana.base.viewbinding.ViewBindingFragment;
import id.dana.component.buttoncomponent.DanaButtonSecondaryView;
import id.dana.component.customsnackbarcomponent.CustomSnackbar;
import id.dana.component.customsnackbarcomponent.SnackbarPosition;
import id.dana.component.customsnackbarcomponent.SnackbarState;
import id.dana.databinding.FragmentAddFriendBinding;
import id.dana.extension.view.InputExtKt;
import id.dana.feeds.ui.enums.FriendshipStatus;
import id.dana.feeds.ui.model.FriendModel;
import id.dana.feeds.ui.model.RelationshipItemModel;
import id.dana.feeds.ui.tracker.FeedsErrorSource;
import id.dana.feeds.ui.tracker.FeedsSourceType;
import id.dana.feeds.ui.tracker.FriendshipAnalyticTracker;
import id.dana.richview.SearchView;
import id.dana.social.AddFriendListFragment;
import id.dana.social.ReciprocalBottomSheetDialog;
import id.dana.social.adapter.FindFriendAdapter;
import id.dana.social.contract.FriendListContract;
import id.dana.social.contract.FriendRequestContract;
import id.dana.social.di.module.FriendListModule;
import id.dana.social.di.module.FriendRequestListModule;
import id.dana.social.view.activity.SocialProfileActivity;
import id.dana.utils.KeyboardHelper;
import id.dana.utils.SizeUtil;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 !2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002!\"B\u0007¢\u0006\u0004\b \u0010\bJ\u000f\u0010\u0004\u001a\u00020\u0003H\u0014¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H\u0014¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\f\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\f\u0010\bJ\u000f\u0010\r\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\r\u0010\bR\u0014\u0010\u0011\u001a\u00020\u000e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0012\u0010\u0013\u001a\u00020\u0012X\u0087\"¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0012\u0010\u0016\u001a\u00020\u0015X\u0087\"¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0016\u0010\r\u001a\u00020\t8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0018\u0010\u000f\u001a\u0004\u0018\u00010\u001a8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0012\u0010\u001e\u001a\u00020\u001dX\u0087\"¢\u0006\u0006\n\u0004\b\u001e\u0010\u001f"}, d2 = {"Lid/dana/social/AddFriendListFragment;", "Lid/dana/base/viewbinding/ViewBindingFragment;", "Lid/dana/databinding/FragmentAddFriendBinding;", "", "getLayout", "()I", "", IAPSyncCommand.COMMAND_INIT, "()V", "", "onBackPressed", "()Z", "onStart", "MyBillsEntityDataFactory", "Lid/dana/social/adapter/FindFriendAdapter;", "KClassImpl$Data$declaredNonStaticMembers$2", "Lid/dana/social/adapter/FindFriendAdapter;", "getAuthRequestContext", "Lid/dana/social/contract/FriendRequestContract$Presenter;", "friendRequestPresenter", "Lid/dana/social/contract/FriendRequestContract$Presenter;", "Lid/dana/feeds/ui/tracker/FriendshipAnalyticTracker;", "friendshipAnalyticTracker", "Lid/dana/feeds/ui/tracker/FriendshipAnalyticTracker;", "PlaceComponentResult", "Z", "Lid/dana/social/ReciprocalBottomSheetDialog$BaseFriendListListener;", "scheduleImpl", "Lid/dana/social/ReciprocalBottomSheetDialog$BaseFriendListListener;", "Lid/dana/social/contract/FriendListContract$Presenter;", "presenter", "Lid/dana/social/contract/FriendListContract$Presenter;", "<init>", "Companion", "ErrorState"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class AddFriendListFragment extends ViewBindingFragment<FragmentAddFriendBinding> {

    /* renamed from: Companion  reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private boolean MyBillsEntityDataFactory;
    @Inject
    public FriendRequestContract.Presenter friendRequestPresenter;
    @Inject
    public FriendshipAnalyticTracker friendshipAnalyticTracker;
    @Inject
    public FriendListContract.Presenter presenter;

    /* renamed from: scheduleImpl  reason: from kotlin metadata */
    private ReciprocalBottomSheetDialog.BaseFriendListListener KClassImpl$Data$declaredNonStaticMembers$2;
    public Map<Integer, View> MyBillsEntityDataFactory = new LinkedHashMap();

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    private final FindFriendAdapter getAuthRequestContext = new FindFriendAdapter();

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005"}, d2 = {"Lid/dana/social/AddFriendListFragment$ErrorState;", "", "<init>", "(Ljava/lang/String;I)V", "NETWORK_ERROR", "EMPTY_RESULT"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public enum ErrorState {
        NETWORK_ERROR,
        EMPTY_RESULT
    }

    @Override // id.dana.base.viewbinding.ViewBindingFragment
    public final void _$_clearFindViewByIdCache() {
        this.MyBillsEntityDataFactory.clear();
    }

    @Override // id.dana.base.viewbinding.ViewBindingFragment
    public final View _$_findCachedViewById(int i) {
        View findViewById;
        Map<Integer, View> map = this.MyBillsEntityDataFactory;
        View view = map.get(Integer.valueOf(i));
        if (view == null) {
            View view2 = getView();
            if (view2 == null || (findViewById = view2.findViewById(i)) == null) {
                return null;
            }
            map.put(Integer.valueOf(i), findViewById);
            return findViewById;
        }
        return view;
    }

    @Override // id.dana.base.BaseFragment
    public final int getLayout() {
        return R.layout.fragment_add_friend;
    }

    @Override // id.dana.base.viewbinding.ViewBindingFragment, id.dana.base.BaseFragment, androidx.fragment.app.Fragment
    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        _$_clearFindViewByIdCache();
    }

    @Override // id.dana.base.viewbinding.ViewBindingFragment
    public final /* synthetic */ FragmentAddFriendBinding initViewBinding(View view) {
        Intrinsics.checkNotNullParameter(view, "");
        FragmentAddFriendBinding BuiltInFictitiousFunctionClassFactory = FragmentAddFriendBinding.BuiltInFictitiousFunctionClassFactory(view);
        Intrinsics.checkNotNullExpressionValue(BuiltInFictitiousFunctionClassFactory, "");
        return BuiltInFictitiousFunctionClassFactory;
    }

    @Override // androidx.fragment.app.Fragment
    public final void onStart() {
        SearchView searchView;
        EditText editText;
        super.onStart();
        FragmentAddFriendBinding binding = getBinding();
        if (binding == null || (searchView = binding.lookAheadTest) == null || (editText = searchView.getEditText()) == null) {
            return;
        }
        editText.setImeOptions(3);
        editText.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: id.dana.social.AddFriendListFragment$$ExternalSyntheticLambda0
            @Override // android.widget.TextView.OnEditorActionListener
            public final boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                boolean authRequestContext;
                authRequestContext = AddFriendListFragment.getAuthRequestContext(AddFriendListFragment.this, textView, i);
                return authRequestContext;
            }
        });
        editText.setFilters(new InputFilter[]{new InputFilter() { // from class: id.dana.social.AddFriendListFragment$$ExternalSyntheticLambda1
            @Override // android.text.InputFilter
            public final CharSequence filter(CharSequence charSequence, int i, int i2, Spanned spanned, int i3, int i4) {
                return AddFriendListFragment.KClassImpl$Data$declaredNonStaticMembers$2(charSequence, i, i2);
            }
        }});
        InputExtKt.PlaceComponentResult(editText, 20);
        editText.setOnClickListener(new View.OnClickListener() { // from class: id.dana.social.AddFriendListFragment$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AddFriendListFragment.MyBillsEntityDataFactory(AddFriendListFragment.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean MyBillsEntityDataFactory(AddFriendListFragment addFriendListFragment, int i) {
        Intrinsics.checkNotNullParameter(addFriendListFragment, "");
        if (i == 4) {
            return addFriendListFragment.onBackPressed();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean getAuthRequestContext(AddFriendListFragment addFriendListFragment, TextView textView, int i) {
        Intrinsics.checkNotNullParameter(addFriendListFragment, "");
        if (i == 3) {
            Intrinsics.checkNotNullExpressionValue(textView, "");
            if (InputExtKt.KClassImpl$Data$declaredNonStaticMembers$2(textView)) {
                FragmentAddFriendBinding binding = addFriendListFragment.getBinding();
                FriendListContract.Presenter presenter = null;
                KeyboardHelper.BuiltInFictitiousFunctionClassFactory(binding != null ? binding.lookAheadTest : null);
                addFriendListFragment.MyBillsEntityDataFactory();
                addFriendListFragment.getAuthRequestContext.KClassImpl$Data$declaredNonStaticMembers$2();
                FriendListContract.Presenter presenter2 = addFriendListFragment.presenter;
                if (presenter2 != null) {
                    presenter = presenter2;
                } else {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                }
                presenter.BuiltInFictitiousFunctionClassFactory(textView.getText().toString());
                return false;
            }
            return false;
        }
        return false;
    }

    @Override // id.dana.base.BaseFragment
    public final boolean onBackPressed() {
        ReciprocalBottomSheetDialog.BaseFriendListListener baseFriendListListener = this.KClassImpl$Data$declaredNonStaticMembers$2;
        if (baseFriendListListener != null) {
            baseFriendListListener.BuiltInFictitiousFunctionClassFactory(this.MyBillsEntityDataFactory);
        }
        this.MyBillsEntityDataFactory = false;
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void MyBillsEntityDataFactory() {
        FragmentAddFriendBinding binding = getBinding();
        if (binding != null) {
            Group group = binding.getAuthRequestContext;
            Intrinsics.checkNotNullExpressionValue(group, "");
            group.setVisibility(8);
            TextView textView = binding.NetworkUserEntityData$$ExternalSyntheticLambda2;
            Intrinsics.checkNotNullExpressionValue(textView, "");
            textView.setVisibility(8);
            RecyclerView recyclerView = binding.NetworkUserEntityData$$ExternalSyntheticLambda0;
            Intrinsics.checkNotNullExpressionValue(recyclerView, "");
            recyclerView.setVisibility(0);
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lid/dana/social/AddFriendListFragment$Companion;", "", "Lid/dana/social/ReciprocalBottomSheetDialog$BaseFriendListListener;", "p0", "Lid/dana/social/AddFriendListFragment;", "BuiltInFictitiousFunctionClassFactory", "(Lid/dana/social/ReciprocalBottomSheetDialog$BaseFriendListListener;)Lid/dana/social/AddFriendListFragment;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public static AddFriendListFragment BuiltInFictitiousFunctionClassFactory(ReciprocalBottomSheetDialog.BaseFriendListListener p0) {
            Intrinsics.checkNotNullParameter(p0, "");
            AddFriendListFragment addFriendListFragment = new AddFriendListFragment();
            addFriendListFragment.KClassImpl$Data$declaredNonStaticMembers$2 = p0;
            return addFriendListFragment;
        }
    }

    public static /* synthetic */ void getAuthRequestContext(AddFriendListFragment addFriendListFragment) {
        SearchView searchView;
        EditText editText;
        Intrinsics.checkNotNullParameter(addFriendListFragment, "");
        FragmentAddFriendBinding binding = addFriendListFragment.getBinding();
        FriendListContract.Presenter presenter = null;
        Editable text = (binding == null || (searchView = binding.lookAheadTest) == null || (editText = searchView.getEditText()) == null) ? null : editText.getText();
        Editable editable = text;
        if (editable == null || editable.length() == 0) {
            return;
        }
        addFriendListFragment.MyBillsEntityDataFactory();
        addFriendListFragment.getAuthRequestContext.KClassImpl$Data$declaredNonStaticMembers$2();
        FriendListContract.Presenter presenter2 = addFriendListFragment.presenter;
        if (presenter2 != null) {
            presenter = presenter2;
        } else {
            Intrinsics.throwUninitializedPropertyAccessException("");
        }
        presenter.BuiltInFictitiousFunctionClassFactory(text.toString());
    }

    public static /* synthetic */ void PlaceComponentResult(AddFriendListFragment addFriendListFragment) {
        Intrinsics.checkNotNullParameter(addFriendListFragment, "");
        addFriendListFragment.onBackPressed();
    }

    public static /* synthetic */ CharSequence KClassImpl$Data$declaredNonStaticMembers$2(CharSequence charSequence, int i, int i2) {
        CharSequence subSequence;
        return (charSequence == null || (subSequence = charSequence.subSequence(i, i2)) == null) ? null : new Regex("[^A-Za-z0-9.]").replace(subSequence, "");
    }

    public static /* synthetic */ void MyBillsEntityDataFactory(AddFriendListFragment addFriendListFragment) {
        Intrinsics.checkNotNullParameter(addFriendListFragment, "");
        FriendshipAnalyticTracker friendshipAnalyticTracker = addFriendListFragment.friendshipAnalyticTracker;
        if (friendshipAnalyticTracker == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            friendshipAnalyticTracker = null;
        }
        friendshipAnalyticTracker.BuiltInFictitiousFunctionClassFactory();
    }

    public static final /* synthetic */ void BuiltInFictitiousFunctionClassFactory(AddFriendListFragment addFriendListFragment, ErrorState errorState) {
        FragmentAddFriendBinding binding = addFriendListFragment.getBinding();
        if (binding != null) {
            RecyclerView recyclerView = binding.NetworkUserEntityData$$ExternalSyntheticLambda0;
            Intrinsics.checkNotNullExpressionValue(recyclerView, "");
            recyclerView.setVisibility(8);
            Group group = binding.getAuthRequestContext;
            Intrinsics.checkNotNullExpressionValue(group, "");
            group.setVisibility(errorState == ErrorState.NETWORK_ERROR ? 0 : 8);
            TextView textView = binding.NetworkUserEntityData$$ExternalSyntheticLambda2;
            Intrinsics.checkNotNullExpressionValue(textView, "");
            textView.setVisibility(errorState == ErrorState.EMPTY_RESULT ? 0 : 8);
        }
    }

    public static final /* synthetic */ void KClassImpl$Data$declaredNonStaticMembers$2(AddFriendListFragment addFriendListFragment, String str) {
        FragmentAddFriendBinding binding = addFriendListFragment.getBinding();
        if (binding != null) {
            ConstraintLayout constraintLayout = binding.KClassImpl$Data$declaredNonStaticMembers$2;
            Intrinsics.checkNotNullExpressionValue(constraintLayout, "");
            CustomSnackbar.Builder builder = new CustomSnackbar.Builder(constraintLayout);
            builder.NetworkUserEntityData$$ExternalSyntheticLambda1 = SizeUtil.getAuthRequestContext(28);
            CustomSnackbar.Builder MyBillsEntityDataFactory = builder.MyBillsEntityDataFactory(SnackbarState.SUCCESS);
            MyBillsEntityDataFactory.NetworkUserEntityData$$ExternalSyntheticLambda0 = R.drawable.ic_success;
            MyBillsEntityDataFactory.moveToNextValue = 1000;
            MyBillsEntityDataFactory.initRecordTimeStamp = addFriendListFragment.getString(R.string.approve_friend_request_success_message, str);
            SnackbarPosition snackbarPosition = SnackbarPosition.TOP;
            Intrinsics.checkNotNullParameter(snackbarPosition, "");
            MyBillsEntityDataFactory.GetContactSyncConfig = snackbarPosition;
            MyBillsEntityDataFactory.BuiltInFictitiousFunctionClassFactory().show();
        }
    }

    @Override // id.dana.base.BaseFragment
    public final void init() {
        AppCompatImageView appCompatImageView;
        RecyclerView recyclerView;
        FindFriendAdapter findFriendAdapter = this.getAuthRequestContext;
        FindFriendAdapter.FriendItemListener friendItemListener = new FindFriendAdapter.FriendItemListener() { // from class: id.dana.social.AddFriendListFragment$getFriendItemListener$1
            @Override // id.dana.social.adapter.FindFriendAdapter.FriendItemListener
            public final void getAuthRequestContext(FriendModel p0) {
                FindFriendAdapter findFriendAdapter2;
                Intrinsics.checkNotNullParameter(p0, "");
                findFriendAdapter2 = AddFriendListFragment.this.getAuthRequestContext;
                findFriendAdapter2.KClassImpl$Data$declaredNonStaticMembers$2(p0.NetworkUserEntityData$$ExternalSyntheticLambda0, FriendshipStatus.PROCESSING);
                FriendshipAnalyticTracker friendshipAnalyticTracker = AddFriendListFragment.this.friendshipAnalyticTracker;
                FriendListContract.Presenter presenter = null;
                if (friendshipAnalyticTracker == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                    friendshipAnalyticTracker = null;
                }
                friendshipAnalyticTracker.lookAheadTest(FeedsSourceType.FIND_AND_ADD_BOTTOM_SHEET);
                FriendListContract.Presenter presenter2 = AddFriendListFragment.this.presenter;
                if (presenter2 != null) {
                    presenter = presenter2;
                } else {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                }
                presenter.MyBillsEntityDataFactory(p0.NetworkUserEntityData$$ExternalSyntheticLambda0);
            }

            @Override // id.dana.social.adapter.FindFriendAdapter.FriendItemListener
            public final void PlaceComponentResult(FriendModel p0) {
                FindFriendAdapter findFriendAdapter2;
                Intrinsics.checkNotNullParameter(p0, "");
                findFriendAdapter2 = AddFriendListFragment.this.getAuthRequestContext;
                findFriendAdapter2.KClassImpl$Data$declaredNonStaticMembers$2(p0.NetworkUserEntityData$$ExternalSyntheticLambda0, FriendshipStatus.PROCESSING);
                FriendListContract.Presenter presenter = AddFriendListFragment.this.presenter;
                if (presenter == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                    presenter = null;
                }
                presenter.KClassImpl$Data$declaredNonStaticMembers$2(p0.NetworkUserEntityData$$ExternalSyntheticLambda0);
            }

            @Override // id.dana.social.adapter.FindFriendAdapter.FriendItemListener
            public final void BuiltInFictitiousFunctionClassFactory(FriendModel p0) {
                FindFriendAdapter findFriendAdapter2;
                Intrinsics.checkNotNullParameter(p0, "");
                findFriendAdapter2 = AddFriendListFragment.this.getAuthRequestContext;
                findFriendAdapter2.KClassImpl$Data$declaredNonStaticMembers$2(p0.NetworkUserEntityData$$ExternalSyntheticLambda0, FriendshipStatus.PROCESSING);
                FriendRequestContract.Presenter presenter = AddFriendListFragment.this.friendRequestPresenter;
                if (presenter == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                    presenter = null;
                }
                presenter.BuiltInFictitiousFunctionClassFactory(p0);
            }

            @Override // id.dana.social.adapter.FindFriendAdapter.FriendItemListener
            public final void MyBillsEntityDataFactory(FriendModel p0) {
                FindFriendAdapter findFriendAdapter2;
                Intrinsics.checkNotNullParameter(p0, "");
                findFriendAdapter2 = AddFriendListFragment.this.getAuthRequestContext;
                findFriendAdapter2.KClassImpl$Data$declaredNonStaticMembers$2(p0.NetworkUserEntityData$$ExternalSyntheticLambda0, FriendshipStatus.PROCESSING);
                FriendRequestContract.Presenter presenter = AddFriendListFragment.this.friendRequestPresenter;
                if (presenter == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                    presenter = null;
                }
                presenter.getAuthRequestContext(p0);
            }

            @Override // id.dana.social.adapter.FindFriendAdapter.FriendItemListener
            public final void KClassImpl$Data$declaredNonStaticMembers$2(FriendModel p0) {
                Intrinsics.checkNotNullParameter(p0, "");
                String str = p0.NetworkUserEntityData$$ExternalSyntheticLambda0;
                String str2 = p0.BuiltInFictitiousFunctionClassFactory;
                if (str2.length() == 0) {
                    str2 = p0.KClassImpl$Data$declaredNonStaticMembers$2;
                }
                RelationshipItemModel relationshipItemModel = new RelationshipItemModel(str, null, str2, null, p0.getErrorConfigVersion, p0.lookAheadTest, false, 0, null, p0.getMyBillsEntityDataFactory(), 0, false, false, 7626, null);
                SocialProfileActivity.Companion companion = SocialProfileActivity.INSTANCE;
                BaseActivity baseActivity = AddFriendListFragment.this.getBaseActivity();
                Intrinsics.checkNotNullExpressionValue(baseActivity, "");
                SocialProfileActivity.Companion.KClassImpl$Data$declaredNonStaticMembers$2(baseActivity, relationshipItemModel);
            }
        };
        Intrinsics.checkNotNullParameter(friendItemListener, "");
        findFriendAdapter.getAuthRequestContext = friendItemListener;
        FragmentAddFriendBinding binding = getBinding();
        if (binding != null && (recyclerView = binding.NetworkUserEntityData$$ExternalSyntheticLambda0) != null) {
            recyclerView.setNestedScrollingEnabled(true);
            recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext(), 1, false));
            recyclerView.setAdapter(this.getAuthRequestContext);
        }
        View view = getView();
        if (view != null) {
            view.setFocusableInTouchMode(true);
        }
        View view2 = getView();
        if (view2 != null) {
            view2.requestFocus();
        }
        View view3 = getView();
        if (view3 != null) {
            view3.setOnKeyListener(new View.OnKeyListener() { // from class: id.dana.social.AddFriendListFragment$$ExternalSyntheticLambda4
                @Override // android.view.View.OnKeyListener
                public final boolean onKey(View view4, int i, KeyEvent keyEvent) {
                    boolean MyBillsEntityDataFactory;
                    MyBillsEntityDataFactory = AddFriendListFragment.MyBillsEntityDataFactory(AddFriendListFragment.this, i);
                    return MyBillsEntityDataFactory;
                }
            });
        }
        FragmentAddFriendBinding binding2 = getBinding();
        if (binding2 != null && (appCompatImageView = binding2.scheduleImpl) != null) {
            appCompatImageView.setOnClickListener(new View.OnClickListener() { // from class: id.dana.social.AddFriendListFragment$$ExternalSyntheticLambda5
                @Override // android.view.View.OnClickListener
                public final void onClick(View view4) {
                    AddFriendListFragment.PlaceComponentResult(AddFriendListFragment.this);
                }
            });
        }
        DanaButtonSecondaryView danaButtonSecondaryView = (DanaButtonSecondaryView) _$_findCachedViewById(R.id.QrExpiredActivity);
        if (danaButtonSecondaryView != null) {
            danaButtonSecondaryView.setOnClickListener(new View.OnClickListener() { // from class: id.dana.social.AddFriendListFragment$$ExternalSyntheticLambda3
                @Override // android.view.View.OnClickListener
                public final void onClick(View view4) {
                    AddFriendListFragment.getAuthRequestContext(AddFriendListFragment.this);
                }
            });
        }
        getBaseActivity().getDanaApplication().getSocialCommonComponent().getAuthRequestContext(new FriendListModule(new FriendListContract.View() { // from class: id.dana.social.AddFriendListFragment$getFriendListView$1
            @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
            public final /* synthetic */ void dismissProgress() {
                AbstractContractKt.AbstractView.CC.MyBillsEntityDataFactory();
            }

            @Override // id.dana.base.AbstractContractKt.AbstractView
            public final String getErrorSource() {
                return FeedsErrorSource.ADD_FRIEND;
            }

            @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
            public final /* synthetic */ void onError(String str) {
                AbstractContractKt.AbstractView.CC.BuiltInFictitiousFunctionClassFactory();
            }

            @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
            public final /* synthetic */ void showProgress() {
                AbstractContractKt.AbstractView.CC.PlaceComponentResult();
            }

            @Override // id.dana.social.contract.FriendListContract.View
            public final void getAuthRequestContext(FriendModel p0) {
                Intrinsics.checkNotNullParameter(p0, "");
                AddFriendListFragment.this.MyBillsEntityDataFactory();
                AddFriendListFragment.this.getAuthRequestContext.setItems(CollectionsKt.mutableListOf(p0));
            }

            @Override // id.dana.social.contract.FriendListContract.View
            public final String KClassImpl$Data$declaredNonStaticMembers$2(String p0) {
                FragmentAddFriendBinding binding3;
                TextView textView;
                CharSequence text;
                String obj;
                Intrinsics.checkNotNullParameter(p0, "");
                AddFriendListFragment.BuiltInFictitiousFunctionClassFactory(AddFriendListFragment.this, AddFriendListFragment.ErrorState.EMPTY_RESULT);
                binding3 = AddFriendListFragment.this.getBinding();
                return (binding3 == null || (textView = binding3.NetworkUserEntityData$$ExternalSyntheticLambda2) == null || (text = textView.getText()) == null || (obj = text.toString()) == null) ? "" : obj;
            }

            @Override // id.dana.social.contract.FriendListContract.View
            public final String KClassImpl$Data$declaredNonStaticMembers$2() {
                FragmentAddFriendBinding binding3;
                TextView textView;
                CharSequence text;
                String obj;
                AddFriendListFragment.BuiltInFictitiousFunctionClassFactory(AddFriendListFragment.this, AddFriendListFragment.ErrorState.NETWORK_ERROR);
                binding3 = AddFriendListFragment.this.getBinding();
                return (binding3 == null || (textView = binding3.GetContactSyncConfig) == null || (text = textView.getText()) == null || (obj = text.toString()) == null) ? "" : obj;
            }

            @Override // id.dana.social.contract.FriendListContract.View
            public final void MyBillsEntityDataFactory(String p0) {
                FindFriendAdapter findFriendAdapter2;
                Intrinsics.checkNotNullParameter(p0, "");
                findFriendAdapter2 = AddFriendListFragment.this.getAuthRequestContext;
                findFriendAdapter2.KClassImpl$Data$declaredNonStaticMembers$2(p0, FriendshipStatus.PENDING);
            }

            @Override // id.dana.social.contract.FriendListContract.View
            public final void BuiltInFictitiousFunctionClassFactory(String p0) {
                FindFriendAdapter findFriendAdapter2;
                Intrinsics.checkNotNullParameter(p0, "");
                findFriendAdapter2 = AddFriendListFragment.this.getAuthRequestContext;
                findFriendAdapter2.KClassImpl$Data$declaredNonStaticMembers$2(p0, FriendshipStatus.NOT_AFFILIATED);
            }

            @Override // id.dana.social.contract.FriendListContract.View
            public final void getAuthRequestContext(String p0) {
                FindFriendAdapter findFriendAdapter2;
                Intrinsics.checkNotNullParameter(p0, "");
                findFriendAdapter2 = AddFriendListFragment.this.getAuthRequestContext;
                findFriendAdapter2.KClassImpl$Data$declaredNonStaticMembers$2(p0, FriendshipStatus.NOT_AFFILIATED);
            }

            @Override // id.dana.social.contract.FriendListContract.View
            public final void PlaceComponentResult(String p0) {
                FindFriendAdapter findFriendAdapter2;
                Intrinsics.checkNotNullParameter(p0, "");
                findFriendAdapter2 = AddFriendListFragment.this.getAuthRequestContext;
                findFriendAdapter2.KClassImpl$Data$declaredNonStaticMembers$2(p0, FriendshipStatus.PENDING);
            }

            @Override // id.dana.social.contract.FriendListContract.View
            public final String getAuthRequestContext() {
                String shownErrorMessage;
                shownErrorMessage = AddFriendListFragment.this.getShownErrorMessage();
                return shownErrorMessage == null ? "" : shownErrorMessage;
            }
        }), new FriendRequestListModule(new FriendRequestContract.View() { // from class: id.dana.social.AddFriendListFragment$getFriendRequestView$1
            @Override // id.dana.social.contract.FriendRequestContract.View
            public final /* synthetic */ void MyBillsEntityDataFactory(Throwable th, String str, String str2) {
                FriendRequestContract.View.CC.PlaceComponentResult(th, str, str2);
            }

            @Override // id.dana.social.contract.FriendRequestContract.View
            public final /* synthetic */ void PlaceComponentResult(List list, boolean z) {
                FriendRequestContract.View.CC.BuiltInFictitiousFunctionClassFactory(list);
            }

            @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
            public final /* synthetic */ void dismissProgress() {
                AbstractContractKt.AbstractView.CC.MyBillsEntityDataFactory();
            }

            @Override // id.dana.social.contract.FriendRequestContract.View
            public final /* synthetic */ void getAuthRequestContext() {
                FriendRequestContract.View.CC.PlaceComponentResult();
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

            @Override // id.dana.social.contract.FriendRequestContract.View
            public final void MyBillsEntityDataFactory(FriendModel p0) {
                FindFriendAdapter findFriendAdapter2;
                Intrinsics.checkNotNullParameter(p0, "");
                AddFriendListFragment.this.MyBillsEntityDataFactory = true;
                FriendshipAnalyticTracker friendshipAnalyticTracker = AddFriendListFragment.this.friendshipAnalyticTracker;
                if (friendshipAnalyticTracker == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                    friendshipAnalyticTracker = null;
                }
                friendshipAnalyticTracker.PlaceComponentResult(FeedsSourceType.FIND_FRIEND_PAGE);
                findFriendAdapter2 = AddFriendListFragment.this.getAuthRequestContext;
                findFriendAdapter2.KClassImpl$Data$declaredNonStaticMembers$2(p0.NetworkUserEntityData$$ExternalSyntheticLambda0, FriendshipStatus.APPROVED);
                AddFriendListFragment.KClassImpl$Data$declaredNonStaticMembers$2(AddFriendListFragment.this, p0.lookAheadTest);
            }

            @Override // id.dana.social.contract.FriendRequestContract.View
            public final void getAuthRequestContext(FriendModel p0) {
                FindFriendAdapter findFriendAdapter2;
                Intrinsics.checkNotNullParameter(p0, "");
                findFriendAdapter2 = AddFriendListFragment.this.getAuthRequestContext;
                findFriendAdapter2.KClassImpl$Data$declaredNonStaticMembers$2(p0.NetworkUserEntityData$$ExternalSyntheticLambda0, FriendshipStatus.PENDING);
            }

            @Override // id.dana.social.contract.FriendRequestContract.View
            public final void KClassImpl$Data$declaredNonStaticMembers$2(FriendModel p0) {
                FindFriendAdapter findFriendAdapter2;
                Intrinsics.checkNotNullParameter(p0, "");
                AddFriendListFragment.this.MyBillsEntityDataFactory = true;
                FriendshipAnalyticTracker friendshipAnalyticTracker = AddFriendListFragment.this.friendshipAnalyticTracker;
                if (friendshipAnalyticTracker == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                    friendshipAnalyticTracker = null;
                }
                friendshipAnalyticTracker.PlaceComponentResult(FeedsSourceType.FIND_FRIEND_PAGE);
                findFriendAdapter2 = AddFriendListFragment.this.getAuthRequestContext;
                findFriendAdapter2.KClassImpl$Data$declaredNonStaticMembers$2(p0.NetworkUserEntityData$$ExternalSyntheticLambda0, FriendshipStatus.REJECTED);
            }

            @Override // id.dana.social.contract.FriendRequestContract.View
            public final void PlaceComponentResult(FriendModel p0) {
                FindFriendAdapter findFriendAdapter2;
                Intrinsics.checkNotNullParameter(p0, "");
                findFriendAdapter2 = AddFriendListFragment.this.getAuthRequestContext;
                findFriendAdapter2.KClassImpl$Data$declaredNonStaticMembers$2(p0.NetworkUserEntityData$$ExternalSyntheticLambda0, FriendshipStatus.PENDING);
            }
        })).getAuthRequestContext(this);
    }
}
