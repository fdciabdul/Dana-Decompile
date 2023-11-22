package id.dana.social;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.ConcatAdapter;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.alipay.iap.android.common.syncintegration.api.IAPSyncCommand;
import id.dana.R;
import id.dana.base.AbstractContract;
import id.dana.base.AbstractContractKt;
import id.dana.base.BaseActivity;
import id.dana.base.viewbinding.ViewBindingFragment;
import id.dana.component.buttoncomponent.DanaButtonPrimaryView;
import id.dana.component.customsnackbarcomponent.CustomSnackbar;
import id.dana.component.customsnackbarcomponent.SnackbarPosition;
import id.dana.component.customsnackbarcomponent.SnackbarState;
import id.dana.component.customtoastcomponent.CustomToast;
import id.dana.contract.deeplink.DeepLinkModule;
import id.dana.contract.services.ServicesContract;
import id.dana.contract.services.ServicesModule;
import id.dana.data.profilemenu.MyProfileMenuAction;
import id.dana.databinding.FragmentReciprocalFriendListBinding;
import id.dana.domain.DefaultObserver;
import id.dana.domain.profilemenu.model.SettingModel;
import id.dana.domain.social.ModifyRelationOperationType;
import id.dana.domain.social.model.FeedConfig;
import id.dana.feeds.ui.enums.FriendshipStatus;
import id.dana.feeds.ui.model.FriendModel;
import id.dana.feeds.ui.model.RelationshipItemModel;
import id.dana.feeds.ui.tracker.FeedsErrorSource;
import id.dana.feeds.ui.tracker.FeedsSourceType;
import id.dana.feeds.ui.tracker.FriendshipAnalyticTracker;
import id.dana.model.DataReady;
import id.dana.model.ThirdPartyService;
import id.dana.richview.SearchView;
import id.dana.social.ReciprocalBottomSheetDialog;
import id.dana.social.adapter.FriendRequestAdapter;
import id.dana.social.adapter.FriendshipListInteraction;
import id.dana.social.adapter.ReciprocalFriendListAdapter;
import id.dana.social.contract.FriendRequestContract;
import id.dana.social.contract.RelationshipBottomSheetContract;
import id.dana.social.di.component.SocialCommonComponent;
import id.dana.social.di.module.FriendRequestListModule;
import id.dana.social.di.module.RelationshipBottomSheetModule;
import id.dana.social.view.activity.SocialProfileActivity;
import id.dana.utils.ErrorUtil;
import id.dana.utils.KeyboardHelper;
import id.dana.utils.SizeUtil;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subjects.PublishSubject;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 22\b\u0012\u0004\u0012\u00020\u00020\u0001:\u00012B\u0007¢\u0006\u0004\b1\u0010\bJ\u000f\u0010\u0004\u001a\u00020\u0003H\u0014¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H\u0014¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\t\u0010\bJ\u001b\u0010\r\u001a\u00020\u00062\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\n¢\u0006\u0004\b\r\u0010\u000eR\u0016\u0010\r\u001a\u00020\u000f8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00130\u00128\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0016\u0010\u0019\u001a\u00020\u00178\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\t\u0010\u0018R\u0012\u0010\u001b\u001a\u00020\u001aX\u0087\"¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0012\u0010\u001e\u001a\u00020\u001dX\u0087\"¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0016\u0010\"\u001a\u00020 8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b\r\u0010!R\u0016\u0010\t\u001a\u00020 8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b#\u0010!R\u0016\u0010#\u001a\u00020 8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b$\u0010!R\u0018\u0010\u0014\u001a\u0004\u0018\u00010%8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b&\u0010'R\u0012\u0010)\u001a\u00020(X\u0087\"¢\u0006\u0006\n\u0004\b)\u0010*R\u0016\u0010$\u001a\u00020+8\u0002@\u0002X\u0083.¢\u0006\u0006\n\u0004\b,\u0010-R\u0016\u0010,\u001a\u00020.8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b/\u00100"}, d2 = {"Lid/dana/social/ReciprocalFriendListFragment;", "Lid/dana/base/viewbinding/ViewBindingFragment;", "Lid/dana/databinding/FragmentReciprocalFriendListBinding;", "", "getLayout", "()I", "", IAPSyncCommand.COMMAND_INIT, "()V", "PlaceComponentResult", "", "Lid/dana/feeds/ui/model/FriendModel;", "p0", "MyBillsEntityDataFactory", "(Ljava/util/List;)V", "Landroidx/recyclerview/widget/ConcatAdapter;", "lookAheadTest", "Landroidx/recyclerview/widget/ConcatAdapter;", "Lio/reactivex/subjects/PublishSubject;", "Lid/dana/model/DataReady;", "getErrorConfigVersion", "Lio/reactivex/subjects/PublishSubject;", "KClassImpl$Data$declaredNonStaticMembers$2", "Lid/dana/social/adapter/FriendRequestAdapter;", "Lid/dana/social/adapter/FriendRequestAdapter;", "BuiltInFictitiousFunctionClassFactory", "Lid/dana/social/contract/FriendRequestContract$Presenter;", "friendRequestPresenter", "Lid/dana/social/contract/FriendRequestContract$Presenter;", "Lid/dana/feeds/ui/tracker/FriendshipAnalyticTracker;", "friendshipAnalyticTracker", "Lid/dana/feeds/ui/tracker/FriendshipAnalyticTracker;", "", "Z", "getAuthRequestContext", "NetworkUserEntityData$$ExternalSyntheticLambda0", "scheduleImpl", "Lid/dana/social/ReciprocalBottomSheetDialog$BaseFriendListListener;", "DatabaseTableConfigUtil", "Lid/dana/social/ReciprocalBottomSheetDialog$BaseFriendListListener;", "Lid/dana/social/contract/RelationshipBottomSheetContract$Presenter;", "presenter", "Lid/dana/social/contract/RelationshipBottomSheetContract$Presenter;", "Lid/dana/social/adapter/ReciprocalFriendListAdapter;", "moveToNextValue", "Lid/dana/social/adapter/ReciprocalFriendListAdapter;", "Lid/dana/feeds/ui/model/RelationshipItemModel;", "NetworkUserEntityData$$ExternalSyntheticLambda1", "Lid/dana/feeds/ui/model/RelationshipItemModel;", "<init>", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ReciprocalFriendListFragment extends ViewBindingFragment<FragmentReciprocalFriendListBinding> {

    /* renamed from: Companion  reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: DatabaseTableConfigUtil  reason: from kotlin metadata */
    private ReciprocalBottomSheetDialog.BaseFriendListListener getErrorConfigVersion;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    boolean getAuthRequestContext;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda0  reason: from kotlin metadata */
    private boolean PlaceComponentResult;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    FriendRequestAdapter BuiltInFictitiousFunctionClassFactory;
    @Inject
    public FriendRequestContract.Presenter friendRequestPresenter;
    @Inject
    public FriendshipAnalyticTracker friendshipAnalyticTracker;

    /* renamed from: getErrorConfigVersion  reason: from kotlin metadata */
    private final PublishSubject<DataReady> KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: lookAheadTest  reason: from kotlin metadata */
    private ConcatAdapter MyBillsEntityDataFactory;

    /* renamed from: moveToNextValue  reason: from kotlin metadata */
    ReciprocalFriendListAdapter scheduleImpl;
    @Inject
    public RelationshipBottomSheetContract.Presenter presenter;

    /* renamed from: scheduleImpl  reason: from kotlin metadata */
    private boolean NetworkUserEntityData$$ExternalSyntheticLambda0;
    public Map<Integer, View> KClassImpl$Data$declaredNonStaticMembers$2 = new LinkedHashMap();

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda1  reason: from kotlin metadata */
    private RelationshipItemModel moveToNextValue = new RelationshipItemModel(null, null, null, null, null, null, false, 0, null, false, 0, false, false, 8191, null);

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] KClassImpl$Data$declaredNonStaticMembers$2;

        static {
            int[] iArr = new int[ModifyRelationOperationType.values().length];
            iArr[ModifyRelationOperationType.BLOCK.ordinal()] = 1;
            iArr[ModifyRelationOperationType.MUTE.ordinal()] = 2;
            KClassImpl$Data$declaredNonStaticMembers$2 = iArr;
        }
    }

    @Override // id.dana.base.viewbinding.ViewBindingFragment
    public final void _$_clearFindViewByIdCache() {
        this.KClassImpl$Data$declaredNonStaticMembers$2.clear();
    }

    @Override // id.dana.base.viewbinding.ViewBindingFragment
    public final View _$_findCachedViewById(int i) {
        View findViewById;
        Map<Integer, View> map = this.KClassImpl$Data$declaredNonStaticMembers$2;
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
        return R.layout.fragment_reciprocal_friend_list;
    }

    @Override // id.dana.base.viewbinding.ViewBindingFragment, id.dana.base.BaseFragment, androidx.fragment.app.Fragment
    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        _$_clearFindViewByIdCache();
    }

    public ReciprocalFriendListFragment() {
        PublishSubject<DataReady> PlaceComponentResult = PublishSubject.PlaceComponentResult();
        Intrinsics.checkNotNullExpressionValue(PlaceComponentResult, "");
        this.KClassImpl$Data$declaredNonStaticMembers$2 = PlaceComponentResult;
    }

    @Override // id.dana.base.viewbinding.ViewBindingFragment
    public final /* synthetic */ FragmentReciprocalFriendListBinding initViewBinding(View view) {
        Intrinsics.checkNotNullParameter(view, "");
        FragmentReciprocalFriendListBinding PlaceComponentResult = FragmentReciprocalFriendListBinding.PlaceComponentResult(view);
        Intrinsics.checkNotNullExpressionValue(PlaceComponentResult, "");
        return PlaceComponentResult;
    }

    public final void MyBillsEntityDataFactory(List<FriendModel> p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        FriendRequestAdapter friendRequestAdapter = null;
        if (p0.isEmpty()) {
            FriendRequestAdapter friendRequestAdapter2 = this.BuiltInFictitiousFunctionClassFactory;
            if (friendRequestAdapter2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
            } else {
                friendRequestAdapter = friendRequestAdapter2;
            }
            friendRequestAdapter.setItems(new ArrayList());
            PlaceComponentResult();
            return;
        }
        FriendRequestAdapter friendRequestAdapter3 = this.BuiltInFictitiousFunctionClassFactory;
        if (friendRequestAdapter3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
        } else {
            friendRequestAdapter = friendRequestAdapter3;
        }
        ArrayList arrayList = new ArrayList();
        FriendModel.Companion companion = FriendModel.INSTANCE;
        arrayList.add(FriendModel.Companion.MyBillsEntityDataFactory());
        arrayList.addAll(CollectionsKt.take(p0, 3));
        if (p0.size() > 3) {
            FriendModel.Companion companion2 = FriendModel.INSTANCE;
            arrayList.add(FriendModel.Companion.PlaceComponentResult());
        }
        friendRequestAdapter.setItems(arrayList);
    }

    private final void PlaceComponentResult() {
        ReciprocalFriendListAdapter reciprocalFriendListAdapter = this.scheduleImpl;
        ReciprocalFriendListAdapter reciprocalFriendListAdapter2 = null;
        if (reciprocalFriendListAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            reciprocalFriendListAdapter = null;
        }
        if (reciprocalFriendListAdapter.BuiltInFictitiousFunctionClassFactory()) {
            ReciprocalFriendListAdapter reciprocalFriendListAdapter3 = this.scheduleImpl;
            if (reciprocalFriendListAdapter3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
            } else {
                reciprocalFriendListAdapter2 = reciprocalFriendListAdapter3;
            }
            reciprocalFriendListAdapter2.removeItem(0);
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lid/dana/social/ReciprocalFriendListFragment$Companion;", "", "Lid/dana/social/ReciprocalBottomSheetDialog$BaseFriendListListener;", "p0", "Lid/dana/social/ReciprocalFriendListFragment;", "getAuthRequestContext", "(Lid/dana/social/ReciprocalBottomSheetDialog$BaseFriendListListener;)Lid/dana/social/ReciprocalFriendListFragment;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public static ReciprocalFriendListFragment getAuthRequestContext(ReciprocalBottomSheetDialog.BaseFriendListListener p0) {
            Intrinsics.checkNotNullParameter(p0, "");
            ReciprocalFriendListFragment reciprocalFriendListFragment = new ReciprocalFriendListFragment();
            reciprocalFriendListFragment.getErrorConfigVersion = p0;
            return reciprocalFriendListFragment;
        }
    }

    public static /* synthetic */ void PlaceComponentResult(ReciprocalFriendListFragment reciprocalFriendListFragment) {
        Intrinsics.checkNotNullParameter(reciprocalFriendListFragment, "");
        RelationshipBottomSheetContract.Presenter presenter = reciprocalFriendListFragment.presenter;
        if (presenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            presenter = null;
        }
        presenter.KClassImpl$Data$declaredNonStaticMembers$2(MyProfileMenuAction.SETTING_RESTRICTED_CONTACT);
    }

    public static /* synthetic */ void PlaceComponentResult(ReciprocalFriendListFragment reciprocalFriendListFragment, boolean z) {
        LinearLayout linearLayout;
        Intrinsics.checkNotNullParameter(reciprocalFriendListFragment, "");
        if (z) {
            FragmentReciprocalFriendListBinding binding = reciprocalFriendListFragment.getBinding();
            linearLayout = binding != null ? binding.getErrorConfigVersion : null;
            if (linearLayout != null) {
                linearLayout.setVisibility(0);
                return;
            }
            return;
        }
        FragmentReciprocalFriendListBinding binding2 = reciprocalFriendListFragment.getBinding();
        linearLayout = binding2 != null ? binding2.getErrorConfigVersion : null;
        if (linearLayout != null) {
            linearLayout.setVisibility(8);
        }
        KeyboardHelper.MyBillsEntityDataFactory(reciprocalFriendListFragment.getBaseActivity());
    }

    public static /* synthetic */ void MyBillsEntityDataFactory(ReciprocalFriendListFragment reciprocalFriendListFragment) {
        Intrinsics.checkNotNullParameter(reciprocalFriendListFragment, "");
        ReciprocalBottomSheetDialog.BaseFriendListListener baseFriendListListener = reciprocalFriendListFragment.getErrorConfigVersion;
        if (baseFriendListListener != null) {
            baseFriendListListener.BuiltInFictitiousFunctionClassFactory();
        }
    }

    public static final /* synthetic */ void getAuthRequestContext(ReciprocalFriendListFragment reciprocalFriendListFragment) {
        if (!reciprocalFriendListFragment.getAuthRequestContext) {
            reciprocalFriendListFragment.NetworkUserEntityData$$ExternalSyntheticLambda0 = true;
        }
        reciprocalFriendListFragment.KClassImpl$Data$declaredNonStaticMembers$2.onNext(new DataReady(reciprocalFriendListFragment.PlaceComponentResult, reciprocalFriendListFragment.NetworkUserEntityData$$ExternalSyntheticLambda0));
    }

    public static final /* synthetic */ void lookAheadTest(ReciprocalFriendListFragment reciprocalFriendListFragment) {
        Context context = reciprocalFriendListFragment.getContext();
        if (context != null) {
            reciprocalFriendListFragment.startActivity(new Intent(context, RestrictedContactActivity.class));
        }
    }

    public static final /* synthetic */ void MyBillsEntityDataFactory(ReciprocalFriendListFragment reciprocalFriendListFragment, RelationshipItemModel relationshipItemModel, ModifyRelationOperationType modifyRelationOperationType) {
        RelationshipBottomSheetContract.Presenter presenter = null;
        if (modifyRelationOperationType != ModifyRelationOperationType.MUTE) {
            if (modifyRelationOperationType == ModifyRelationOperationType.UNMUTE) {
                ReciprocalFriendListAdapter reciprocalFriendListAdapter = reciprocalFriendListFragment.scheduleImpl;
                if (reciprocalFriendListAdapter == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                    reciprocalFriendListAdapter = null;
                }
                reciprocalFriendListAdapter.MyBillsEntityDataFactory(relationshipItemModel, "ACTIVE");
            }
        } else {
            ReciprocalFriendListAdapter reciprocalFriendListAdapter2 = reciprocalFriendListFragment.scheduleImpl;
            if (reciprocalFriendListAdapter2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
                reciprocalFriendListAdapter2 = null;
            }
            reciprocalFriendListAdapter2.MyBillsEntityDataFactory(relationshipItemModel, "MUTE");
        }
        RelationshipBottomSheetContract.Presenter presenter2 = reciprocalFriendListFragment.presenter;
        if (presenter2 != null) {
            presenter = presenter2;
        } else {
            Intrinsics.throwUninitializedPropertyAccessException("");
        }
        presenter.PlaceComponentResult(relationshipItemModel.GetContactSyncConfig, modifyRelationOperationType);
    }

    public static final /* synthetic */ void PlaceComponentResult(ReciprocalFriendListFragment reciprocalFriendListFragment, ModifyRelationOperationType modifyRelationOperationType) {
        int i = WhenMappings.KClassImpl$Data$declaredNonStaticMembers$2[modifyRelationOperationType.ordinal()];
        FriendshipAnalyticTracker friendshipAnalyticTracker = null;
        if (i == 1) {
            String string = reciprocalFriendListFragment.getString(R.string.friendship_block, reciprocalFriendListFragment.moveToNextValue.scheduleImpl);
            Intrinsics.checkNotNullExpressionValue(string, "");
            CustomToast customToast = CustomToast.MyBillsEntityDataFactory;
            BaseActivity baseActivity = reciprocalFriendListFragment.getBaseActivity();
            Intrinsics.checkNotNullExpressionValue(baseActivity, "");
            CustomToast.MyBillsEntityDataFactory(baseActivity, R.drawable.ic_warning_24_yellow50, R.drawable.bg_rounded_border_yellow_50, string);
            RelationshipItemModel relationshipItemModel = reciprocalFriendListFragment.moveToNextValue;
            ReciprocalFriendListAdapter reciprocalFriendListAdapter = reciprocalFriendListFragment.scheduleImpl;
            if (reciprocalFriendListAdapter == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
                reciprocalFriendListAdapter = null;
            }
            reciprocalFriendListAdapter.MyBillsEntityDataFactory(relationshipItemModel, "BLOCKING");
            FriendshipAnalyticTracker friendshipAnalyticTracker2 = reciprocalFriendListFragment.friendshipAnalyticTracker;
            if (friendshipAnalyticTracker2 != null) {
                friendshipAnalyticTracker = friendshipAnalyticTracker2;
            } else {
                Intrinsics.throwUninitializedPropertyAccessException("");
            }
            friendshipAnalyticTracker.moveToNextValue("INACTIVE");
        } else if (i != 2) {
            FriendshipAnalyticTracker friendshipAnalyticTracker3 = reciprocalFriendListFragment.friendshipAnalyticTracker;
            if (friendshipAnalyticTracker3 != null) {
                friendshipAnalyticTracker = friendshipAnalyticTracker3;
            } else {
                Intrinsics.throwUninitializedPropertyAccessException("");
            }
            friendshipAnalyticTracker.getErrorConfigVersion("ACTIVE");
            String string2 = reciprocalFriendListFragment.getString(R.string.friendship_unmute, reciprocalFriendListFragment.moveToNextValue.scheduleImpl);
            Intrinsics.checkNotNullExpressionValue(string2, "");
            CustomToast customToast2 = CustomToast.MyBillsEntityDataFactory;
            BaseActivity baseActivity2 = reciprocalFriendListFragment.getBaseActivity();
            Intrinsics.checkNotNullExpressionValue(baseActivity2, "");
            CustomToast.MyBillsEntityDataFactory(baseActivity2, R.drawable.ic_check_24_green50_filled_circle, R.drawable.bg_rounded_border_green_50, string2);
        } else {
            FriendshipAnalyticTracker friendshipAnalyticTracker4 = reciprocalFriendListFragment.friendshipAnalyticTracker;
            if (friendshipAnalyticTracker4 != null) {
                friendshipAnalyticTracker = friendshipAnalyticTracker4;
            } else {
                Intrinsics.throwUninitializedPropertyAccessException("");
            }
            friendshipAnalyticTracker.getErrorConfigVersion("INACTIVE");
            String string3 = reciprocalFriendListFragment.getString(R.string.friendship_mute, reciprocalFriendListFragment.moveToNextValue.scheduleImpl);
            Intrinsics.checkNotNullExpressionValue(string3, "");
            CustomToast customToast3 = CustomToast.MyBillsEntityDataFactory;
            BaseActivity baseActivity3 = reciprocalFriendListFragment.getBaseActivity();
            Intrinsics.checkNotNullExpressionValue(baseActivity3, "");
            CustomToast.MyBillsEntityDataFactory(baseActivity3, R.drawable.ic_warning_24_yellow50, R.drawable.bg_rounded_border_yellow_50, string3);
        }
    }

    public static final /* synthetic */ Unit getAuthRequestContext(ReciprocalFriendListFragment reciprocalFriendListFragment, RelationshipItemModel relationshipItemModel) {
        Context context = reciprocalFriendListFragment.getContext();
        if (context != null) {
            SocialProfileActivity.Companion companion = SocialProfileActivity.INSTANCE;
            SocialProfileActivity.Companion.KClassImpl$Data$declaredNonStaticMembers$2(context, relationshipItemModel);
            return Unit.INSTANCE;
        }
        return null;
    }

    public static final /* synthetic */ void NetworkUserEntityData$$ExternalSyntheticLambda0(ReciprocalFriendListFragment reciprocalFriendListFragment) {
        FragmentReciprocalFriendListBinding binding = reciprocalFriendListFragment.getBinding();
        FriendRequestContract.Presenter presenter = null;
        DanaButtonPrimaryView danaButtonPrimaryView = binding != null ? binding.PlaceComponentResult : null;
        if (danaButtonPrimaryView != null) {
            danaButtonPrimaryView.setVisibility(reciprocalFriendListFragment.getAuthRequestContext ? 0 : 8);
        }
        RelationshipBottomSheetContract.Presenter presenter2 = reciprocalFriendListFragment.presenter;
        if (presenter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            presenter2 = null;
        }
        List<RelationshipItemModel> authRequestContext = presenter2.getAuthRequestContext();
        List<RelationshipItemModel> list = authRequestContext;
        if ((!list.isEmpty()) != false) {
            FragmentReciprocalFriendListBinding binding2 = reciprocalFriendListFragment.getBinding();
            RecyclerView recyclerView = binding2 != null ? binding2.scheduleImpl : null;
            if (recyclerView != null) {
                recyclerView.setVisibility(0);
            }
            FragmentReciprocalFriendListBinding binding3 = reciprocalFriendListFragment.getBinding();
            SearchView searchView = binding3 != null ? binding3.moveToNextValue : null;
            if (searchView != null) {
                searchView.setVisibility(0);
            }
            ReciprocalFriendListAdapter reciprocalFriendListAdapter = reciprocalFriendListFragment.scheduleImpl;
            if (reciprocalFriendListAdapter == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
                reciprocalFriendListAdapter = null;
            }
            ArrayList arrayList = new ArrayList();
            FriendRequestAdapter friendRequestAdapter = reciprocalFriendListFragment.BuiltInFictitiousFunctionClassFactory;
            if (friendRequestAdapter == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
                friendRequestAdapter = null;
            }
            Intrinsics.checkNotNullExpressionValue(friendRequestAdapter.getItems(), "");
            if ((!r7.isEmpty()) != false) {
                RelationshipItemModel.Companion companion = RelationshipItemModel.INSTANCE;
                arrayList.add(RelationshipItemModel.Companion.BuiltInFictitiousFunctionClassFactory());
            }
            ((RelationshipItemModel) CollectionsKt.last((List) authRequestContext)).lookAheadTest = false;
            arrayList.addAll(list);
            reciprocalFriendListAdapter.setItems(arrayList);
        } else {
            FragmentReciprocalFriendListBinding binding4 = reciprocalFriendListFragment.getBinding();
            SearchView searchView2 = binding4 != null ? binding4.moveToNextValue : null;
            if (searchView2 != null) {
                searchView2.setVisibility(8);
            }
            ReciprocalFriendListAdapter reciprocalFriendListAdapter2 = reciprocalFriendListFragment.scheduleImpl;
            if (reciprocalFriendListAdapter2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
                reciprocalFriendListAdapter2 = null;
            }
            reciprocalFriendListAdapter2.PlaceComponentResult(false);
        }
        FriendRequestContract.Presenter presenter3 = reciprocalFriendListFragment.friendRequestPresenter;
        if (presenter3 != null) {
            presenter = presenter3;
        } else {
            Intrinsics.throwUninitializedPropertyAccessException("");
        }
        reciprocalFriendListFragment.MyBillsEntityDataFactory(presenter.getAuthRequestContext());
    }

    public static final /* synthetic */ void KClassImpl$Data$declaredNonStaticMembers$2(final ReciprocalFriendListFragment reciprocalFriendListFragment, boolean z) {
        DanaButtonPrimaryView danaButtonPrimaryView;
        FriendRequestContract.Presenter presenter = null;
        if (!z) {
            FriendRequestAdapter friendRequestAdapter = reciprocalFriendListFragment.BuiltInFictitiousFunctionClassFactory;
            if (friendRequestAdapter == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
                friendRequestAdapter = null;
            }
            friendRequestAdapter.setItems(new ArrayList());
            FragmentReciprocalFriendListBinding binding = reciprocalFriendListFragment.getBinding();
            DanaButtonPrimaryView danaButtonPrimaryView2 = binding != null ? binding.PlaceComponentResult : null;
            if (danaButtonPrimaryView2 != null) {
                danaButtonPrimaryView2.setVisibility(8);
                return;
            }
            return;
        }
        FragmentReciprocalFriendListBinding binding2 = reciprocalFriendListFragment.getBinding();
        if (binding2 != null && (danaButtonPrimaryView = binding2.PlaceComponentResult) != null) {
            danaButtonPrimaryView.setOnClickListener(new View.OnClickListener() { // from class: id.dana.social.ReciprocalFriendListFragment$$ExternalSyntheticLambda1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ReciprocalFriendListFragment.MyBillsEntityDataFactory(ReciprocalFriendListFragment.this);
                }
            });
        }
        FriendRequestAdapter friendRequestAdapter2 = reciprocalFriendListFragment.BuiltInFictitiousFunctionClassFactory;
        if (friendRequestAdapter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            friendRequestAdapter2 = null;
        }
        friendRequestAdapter2.getAuthRequestContext();
        FriendRequestContract.Presenter presenter2 = reciprocalFriendListFragment.friendRequestPresenter;
        if (presenter2 != null) {
            presenter = presenter2;
        } else {
            Intrinsics.throwUninitializedPropertyAccessException("");
        }
        presenter.getAuthRequestContext(10);
    }

    public static final /* synthetic */ void BuiltInFictitiousFunctionClassFactory(ReciprocalFriendListFragment reciprocalFriendListFragment, String str) {
        CustomToast customToast = CustomToast.MyBillsEntityDataFactory;
        BaseActivity baseActivity = reciprocalFriendListFragment.getBaseActivity();
        Intrinsics.checkNotNullExpressionValue(baseActivity, "");
        CustomToast.MyBillsEntityDataFactory(baseActivity, R.drawable.ic_close_red, R.drawable.bg_rounded_border_red_50, str);
    }

    public static final /* synthetic */ void MyBillsEntityDataFactory(ReciprocalFriendListFragment reciprocalFriendListFragment, String str) {
        FragmentReciprocalFriendListBinding binding = reciprocalFriendListFragment.getBinding();
        if (binding != null) {
            ConstraintLayout constraintLayout = binding.MyBillsEntityDataFactory;
            Intrinsics.checkNotNullExpressionValue(constraintLayout, "");
            CustomSnackbar.Builder builder = new CustomSnackbar.Builder(constraintLayout);
            builder.NetworkUserEntityData$$ExternalSyntheticLambda1 = SizeUtil.getAuthRequestContext(28);
            CustomSnackbar.Builder MyBillsEntityDataFactory = builder.MyBillsEntityDataFactory(SnackbarState.SUCCESS);
            MyBillsEntityDataFactory.NetworkUserEntityData$$ExternalSyntheticLambda0 = R.drawable.ic_success;
            MyBillsEntityDataFactory.moveToNextValue = 1000;
            MyBillsEntityDataFactory.initRecordTimeStamp = reciprocalFriendListFragment.getString(R.string.approve_friend_request_success_message, str);
            SnackbarPosition snackbarPosition = SnackbarPosition.TOP;
            Intrinsics.checkNotNullParameter(snackbarPosition, "");
            MyBillsEntityDataFactory.GetContactSyncConfig = snackbarPosition;
            MyBillsEntityDataFactory.BuiltInFictitiousFunctionClassFactory().show();
        }
    }

    public static final /* synthetic */ void KClassImpl$Data$declaredNonStaticMembers$2(ReciprocalFriendListFragment reciprocalFriendListFragment, List list) {
        ReciprocalFriendListAdapter reciprocalFriendListAdapter = reciprocalFriendListFragment.scheduleImpl;
        FriendRequestAdapter friendRequestAdapter = null;
        if (reciprocalFriendListAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            reciprocalFriendListAdapter = null;
        }
        ArrayList arrayList = new ArrayList();
        FriendRequestAdapter friendRequestAdapter2 = reciprocalFriendListFragment.BuiltInFictitiousFunctionClassFactory;
        if (friendRequestAdapter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
        } else {
            friendRequestAdapter = friendRequestAdapter2;
        }
        Intrinsics.checkNotNullExpressionValue(friendRequestAdapter.getItems(), "");
        if ((!r4.isEmpty()) != false) {
            RelationshipItemModel.Companion companion = RelationshipItemModel.INSTANCE;
            arrayList.add(RelationshipItemModel.Companion.BuiltInFictitiousFunctionClassFactory());
        }
        List list2 = list;
        if ((!list2.isEmpty()) != false) {
            ((RelationshipItemModel) CollectionsKt.last(list)).lookAheadTest = false;
            arrayList.addAll(list2);
        }
        reciprocalFriendListAdapter.setItems(arrayList);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v0, types: [id.dana.social.adapter.FriendRequestAdapter$FriendRequestSectionFontType, kotlin.jvm.internal.DefaultConstructorMarker] */
    /* JADX WARN: Type inference failed for: r6v1, types: [id.dana.social.contract.RelationshipBottomSheetContract$Presenter] */
    /* JADX WARN: Type inference failed for: r6v2 */
    @Override // id.dana.base.BaseFragment
    public final void init() {
        SearchView searchView;
        SearchView searchView2;
        RecyclerView recyclerView;
        TextView textView;
        SocialCommonComponent socialCommonComponent = getBaseActivity().getDanaApplication().getSocialCommonComponent();
        byte b = 0;
        if (socialCommonComponent != null) {
            RelationshipBottomSheetModule relationshipBottomSheetModule = new RelationshipBottomSheetModule(new RelationshipBottomSheetContract.View() { // from class: id.dana.social.ReciprocalFriendListFragment$initInjection$1
                @Override // id.dana.social.contract.RelationshipBottomSheetContract.View
                public final /* synthetic */ void MyBillsEntityDataFactory(boolean z) {
                    RelationshipBottomSheetContract.View.CC.KClassImpl$Data$declaredNonStaticMembers$2();
                }

                @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
                public final /* synthetic */ void dismissProgress() {
                    AbstractContractKt.AbstractView.CC.MyBillsEntityDataFactory();
                }

                @Override // id.dana.base.AbstractContractKt.AbstractView
                public final String getErrorSource() {
                    return FeedsErrorSource.FRIEND_LIST;
                }

                @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
                public final /* synthetic */ void onError(String str) {
                    AbstractContractKt.AbstractView.CC.BuiltInFictitiousFunctionClassFactory();
                }

                @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
                public final /* synthetic */ void showProgress() {
                    AbstractContractKt.AbstractView.CC.PlaceComponentResult();
                }

                @Override // id.dana.social.contract.RelationshipBottomSheetContract.View
                public final void BuiltInFictitiousFunctionClassFactory(SettingModel p0) {
                    Intrinsics.checkNotNullParameter(p0, "");
                    ReciprocalFriendListFragment.lookAheadTest(ReciprocalFriendListFragment.this);
                }

                @Override // id.dana.social.contract.RelationshipBottomSheetContract.View
                public final void MyBillsEntityDataFactory() {
                    Toast.makeText(ReciprocalFriendListFragment.this.getActivity(), ErrorUtil.BuiltInFictitiousFunctionClassFactory(ReciprocalFriendListFragment.this.getBaseActivity()), 0).show();
                }

                @Override // id.dana.social.contract.RelationshipBottomSheetContract.View
                public final void getAuthRequestContext(List<RelationshipItemModel> p0) {
                    Intrinsics.checkNotNullParameter(p0, "");
                    ReciprocalFriendListFragment.this.PlaceComponentResult = true;
                    ReciprocalFriendListFragment.getAuthRequestContext(ReciprocalFriendListFragment.this);
                }

                @Override // id.dana.social.contract.RelationshipBottomSheetContract.View
                public final void PlaceComponentResult(List<RelationshipItemModel> p0) {
                    ReciprocalFriendListAdapter reciprocalFriendListAdapter;
                    Intrinsics.checkNotNullParameter(p0, "");
                    if (p0.isEmpty()) {
                        reciprocalFriendListAdapter = ReciprocalFriendListFragment.this.scheduleImpl;
                        FriendRequestContract.Presenter presenter = null;
                        if (reciprocalFriendListAdapter == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("");
                            reciprocalFriendListAdapter = null;
                        }
                        FriendRequestContract.Presenter presenter2 = ReciprocalFriendListFragment.this.friendRequestPresenter;
                        if (presenter2 != null) {
                            presenter = presenter2;
                        } else {
                            Intrinsics.throwUninitializedPropertyAccessException("");
                        }
                        reciprocalFriendListAdapter.PlaceComponentResult(!presenter.getAuthRequestContext().isEmpty());
                        return;
                    }
                    ReciprocalFriendListFragment.KClassImpl$Data$declaredNonStaticMembers$2(ReciprocalFriendListFragment.this, p0);
                }

                @Override // id.dana.social.contract.RelationshipBottomSheetContract.View
                public final void getAuthRequestContext(ModifyRelationOperationType p0) {
                    Intrinsics.checkNotNullParameter(p0, "");
                    ReciprocalFriendListFragment.PlaceComponentResult(ReciprocalFriendListFragment.this, p0);
                }

                @Override // id.dana.social.contract.RelationshipBottomSheetContract.View
                public final String BuiltInFictitiousFunctionClassFactory() {
                    String string = ReciprocalFriendListFragment.this.getString(R.string.modify_relationship_error);
                    Intrinsics.checkNotNullExpressionValue(string, "");
                    ReciprocalFriendListFragment.BuiltInFictitiousFunctionClassFactory(ReciprocalFriendListFragment.this, string);
                    return string;
                }

                @Override // id.dana.social.contract.RelationshipBottomSheetContract.View
                public final void MyBillsEntityDataFactory(FeedConfig p0) {
                    boolean z;
                    Intrinsics.checkNotNullParameter(p0, "");
                    ReciprocalFriendListFragment.this.getAuthRequestContext = p0.isAddFriendEnabled();
                    ReciprocalFriendListFragment reciprocalFriendListFragment = ReciprocalFriendListFragment.this;
                    z = reciprocalFriendListFragment.getAuthRequestContext;
                    ReciprocalFriendListFragment.KClassImpl$Data$declaredNonStaticMembers$2(reciprocalFriendListFragment, z);
                }

                @Override // id.dana.social.contract.RelationshipBottomSheetContract.View
                public final void PlaceComponentResult() {
                    ReciprocalFriendListFragment.KClassImpl$Data$declaredNonStaticMembers$2(ReciprocalFriendListFragment.this, false);
                }
            });
            DeepLinkModule.Builder KClassImpl$Data$declaredNonStaticMembers$2 = DeepLinkModule.KClassImpl$Data$declaredNonStaticMembers$2();
            KClassImpl$Data$declaredNonStaticMembers$2.MyBillsEntityDataFactory = getActivity();
            DeepLinkModule deepLinkModule = new DeepLinkModule(KClassImpl$Data$declaredNonStaticMembers$2, b);
            Intrinsics.checkNotNullExpressionValue(deepLinkModule, "");
            socialCommonComponent.getAuthRequestContext(relationshipBottomSheetModule, deepLinkModule, new ServicesModule(new ServicesContract.View() { // from class: id.dana.social.ReciprocalFriendListFragment$initInjection$2
                @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
                public final /* synthetic */ void dismissProgress() {
                    AbstractContractKt.AbstractView.CC.MyBillsEntityDataFactory();
                }

                @Override // id.dana.base.AbstractContractKt.AbstractView
                public final /* synthetic */ String getErrorSource() {
                    return AbstractContractKt.AbstractView.CC.getAuthRequestContext();
                }

                @Override // id.dana.contract.services.ServicesContract.View
                public final /* synthetic */ void onActionFailed(String str) {
                    ServicesContract.View.CC.MyBillsEntityDataFactory();
                }

                @Override // id.dana.contract.services.ServicesContract.View
                public final /* synthetic */ void onActionGet(ThirdPartyService thirdPartyService) {
                    ServicesContract.View.CC.MyBillsEntityDataFactory(thirdPartyService);
                }

                @Override // id.dana.contract.services.ServicesContract.View
                public final /* synthetic */ void onActionMiniApp(ThirdPartyService thirdPartyService) {
                    ServicesContract.View.CC.PlaceComponentResult(thirdPartyService);
                }

                @Override // id.dana.contract.services.ServicesContract.View
                public final /* synthetic */ void onActionPost(ThirdPartyService thirdPartyService, String str) {
                    ServicesContract.View.CC.getAuthRequestContext(thirdPartyService);
                }

                @Override // id.dana.contract.services.ServicesContract.View
                public final /* synthetic */ void onCheckFavoriteServicesFeature(boolean z) {
                    ServicesContract.View.CC.PlaceComponentResult();
                }

                @Override // id.dana.contract.services.ServicesContract.View
                public final /* synthetic */ void onDirectOpen(ThirdPartyService thirdPartyService, Map map) {
                    Intrinsics.checkNotNullParameter(thirdPartyService, "");
                }

                @Override // id.dana.contract.services.ServicesContract.View
                public final /* synthetic */ void onEmptySearchService() {
                    ServicesContract.View.CC.BuiltInFictitiousFunctionClassFactory();
                }

                @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
                public final /* synthetic */ void onError(String str) {
                    AbstractContractKt.AbstractView.CC.BuiltInFictitiousFunctionClassFactory();
                }

                @Override // id.dana.contract.services.ServicesContract.View
                public final /* synthetic */ void onFeatureServices(List list) {
                    ServicesContract.View.CC.PlaceComponentResult(list);
                }

                @Override // id.dana.contract.services.ServicesContract.View
                public final /* synthetic */ void onGetFilteredThirdPartyServices(List list) {
                    ServicesContract.View.CC.MyBillsEntityDataFactory(list);
                }

                @Override // id.dana.contract.services.ServicesContract.View
                public final /* synthetic */ void onGetInitThirdPartyServices(List list) {
                    Intrinsics.checkNotNullParameter(list, "");
                }

                @Override // id.dana.contract.services.ServicesContract.View
                public final /* synthetic */ void onGetThirdPartyServices(List list) {
                    ServicesContract.View.CC.getAuthRequestContext(list);
                }

                @Override // id.dana.contract.services.ServicesContract.View
                public final /* synthetic */ void onMaintenanceAction(ThirdPartyService thirdPartyService) {
                    ServicesContract.View.CC.BuiltInFictitiousFunctionClassFactory(thirdPartyService);
                }

                @Override // id.dana.contract.services.ServicesContract.View
                public final /* synthetic */ void onShowTooltip(boolean z) {
                    ServicesContract.View.CC.KClassImpl$Data$declaredNonStaticMembers$2();
                }

                @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
                public final /* synthetic */ void showProgress() {
                    AbstractContractKt.AbstractView.CC.PlaceComponentResult();
                }
            }), new FriendRequestListModule(new FriendRequestContract.View() { // from class: id.dana.social.ReciprocalFriendListFragment$initInjection$3
                @Override // id.dana.social.contract.FriendRequestContract.View
                public final /* synthetic */ void MyBillsEntityDataFactory(Throwable th, String str, String str2) {
                    FriendRequestContract.View.CC.PlaceComponentResult(th, str, str2);
                }

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

                @Override // id.dana.social.contract.FriendRequestContract.View
                public final void PlaceComponentResult(List<FriendModel> p0, boolean p1) {
                    Intrinsics.checkNotNullParameter(p0, "");
                    ReciprocalFriendListFragment.this.NetworkUserEntityData$$ExternalSyntheticLambda0 = true;
                    ReciprocalFriendListFragment.getAuthRequestContext(ReciprocalFriendListFragment.this);
                }

                @Override // id.dana.social.contract.FriendRequestContract.View
                public final void getAuthRequestContext() {
                    ReciprocalFriendListFragment.this.NetworkUserEntityData$$ExternalSyntheticLambda0 = true;
                    ReciprocalFriendListFragment.getAuthRequestContext(ReciprocalFriendListFragment.this);
                }

                @Override // id.dana.social.contract.FriendRequestContract.View
                public final void MyBillsEntityDataFactory(FriendModel p0) {
                    FriendRequestAdapter friendRequestAdapter;
                    Intrinsics.checkNotNullParameter(p0, "");
                    FriendshipAnalyticTracker friendshipAnalyticTracker = ReciprocalFriendListFragment.this.friendshipAnalyticTracker;
                    FriendRequestContract.Presenter presenter = null;
                    if (friendshipAnalyticTracker == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("");
                        friendshipAnalyticTracker = null;
                    }
                    friendshipAnalyticTracker.PlaceComponentResult(FeedsSourceType.FRIEND_LIST_PAGE);
                    friendRequestAdapter = ReciprocalFriendListFragment.this.BuiltInFictitiousFunctionClassFactory;
                    if (friendRequestAdapter == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("");
                        friendRequestAdapter = null;
                    }
                    friendRequestAdapter.KClassImpl$Data$declaredNonStaticMembers$2(p0.NetworkUserEntityData$$ExternalSyntheticLambda0);
                    ReciprocalFriendListFragment.MyBillsEntityDataFactory(ReciprocalFriendListFragment.this, p0.lookAheadTest);
                    RelationshipBottomSheetContract.Presenter presenter2 = ReciprocalFriendListFragment.this.presenter;
                    if (presenter2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("");
                        presenter2 = null;
                    }
                    presenter2.BuiltInFictitiousFunctionClassFactory();
                    FriendRequestContract.Presenter presenter3 = ReciprocalFriendListFragment.this.friendRequestPresenter;
                    if (presenter3 != null) {
                        presenter = presenter3;
                    } else {
                        Intrinsics.throwUninitializedPropertyAccessException("");
                    }
                    presenter.BuiltInFictitiousFunctionClassFactory();
                }

                @Override // id.dana.social.contract.FriendRequestContract.View
                public final void getAuthRequestContext(FriendModel p0) {
                    FriendRequestAdapter friendRequestAdapter;
                    Intrinsics.checkNotNullParameter(p0, "");
                    friendRequestAdapter = ReciprocalFriendListFragment.this.BuiltInFictitiousFunctionClassFactory;
                    if (friendRequestAdapter == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("");
                        friendRequestAdapter = null;
                    }
                    friendRequestAdapter.getAuthRequestContext(p0.NetworkUserEntityData$$ExternalSyntheticLambda0, FriendshipStatus.PENDING);
                }

                @Override // id.dana.social.contract.FriendRequestContract.View
                public final void KClassImpl$Data$declaredNonStaticMembers$2(FriendModel p0) {
                    FriendRequestAdapter friendRequestAdapter;
                    Intrinsics.checkNotNullParameter(p0, "");
                    FriendshipAnalyticTracker friendshipAnalyticTracker = ReciprocalFriendListFragment.this.friendshipAnalyticTracker;
                    FriendRequestContract.Presenter presenter = null;
                    if (friendshipAnalyticTracker == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("");
                        friendshipAnalyticTracker = null;
                    }
                    friendshipAnalyticTracker.getAuthRequestContext(FeedsSourceType.FRIEND_LIST_PAGE);
                    friendRequestAdapter = ReciprocalFriendListFragment.this.BuiltInFictitiousFunctionClassFactory;
                    if (friendRequestAdapter == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("");
                        friendRequestAdapter = null;
                    }
                    friendRequestAdapter.KClassImpl$Data$declaredNonStaticMembers$2(p0.NetworkUserEntityData$$ExternalSyntheticLambda0);
                    FriendRequestContract.Presenter presenter2 = ReciprocalFriendListFragment.this.friendRequestPresenter;
                    if (presenter2 != null) {
                        presenter = presenter2;
                    } else {
                        Intrinsics.throwUninitializedPropertyAccessException("");
                    }
                    presenter.BuiltInFictitiousFunctionClassFactory();
                }

                @Override // id.dana.social.contract.FriendRequestContract.View
                public final void PlaceComponentResult(FriendModel p0) {
                    FriendRequestAdapter friendRequestAdapter;
                    Intrinsics.checkNotNullParameter(p0, "");
                    friendRequestAdapter = ReciprocalFriendListFragment.this.BuiltInFictitiousFunctionClassFactory;
                    if (friendRequestAdapter == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("");
                        friendRequestAdapter = null;
                    }
                    friendRequestAdapter.getAuthRequestContext(p0.NetworkUserEntityData$$ExternalSyntheticLambda0, FriendshipStatus.PENDING);
                }
            })).BuiltInFictitiousFunctionClassFactory(this);
        }
        BaseActivity baseActivity = getBaseActivity();
        AbstractContract.AbstractPresenter[] abstractPresenterArr = new AbstractContract.AbstractPresenter[2];
        RelationshipBottomSheetContract.Presenter presenter = this.presenter;
        ?? r6 = 0;
        if (presenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            presenter = null;
        }
        abstractPresenterArr[0] = presenter;
        FriendRequestContract.Presenter presenter2 = this.friendRequestPresenter;
        if (presenter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            presenter2 = null;
        }
        int i = 1;
        abstractPresenterArr[1] = presenter2;
        baseActivity.registerPresenter(abstractPresenterArr);
        FragmentReciprocalFriendListBinding binding = getBinding();
        if (binding != null && (textView = binding.NetworkUserEntityData$$ExternalSyntheticLambda0) != null) {
            textView.setOnClickListener(new View.OnClickListener() { // from class: id.dana.social.ReciprocalFriendListFragment$$ExternalSyntheticLambda2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ReciprocalFriendListFragment.PlaceComponentResult(ReciprocalFriendListFragment.this);
                }
            });
        }
        this.BuiltInFictitiousFunctionClassFactory = new FriendRequestAdapter(r6, new FriendRequestAdapter.FriendRequestListener() { // from class: id.dana.social.ReciprocalFriendListFragment$setupAdapter$1
            @Override // id.dana.social.adapter.FriendRequestAdapter.FriendRequestListener
            public final void BuiltInFictitiousFunctionClassFactory(FriendModel p0) {
                FriendRequestAdapter friendRequestAdapter;
                Intrinsics.checkNotNullParameter(p0, "");
                friendRequestAdapter = ReciprocalFriendListFragment.this.BuiltInFictitiousFunctionClassFactory;
                FriendRequestContract.Presenter presenter3 = null;
                if (friendRequestAdapter == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                    friendRequestAdapter = null;
                }
                friendRequestAdapter.getAuthRequestContext(p0.NetworkUserEntityData$$ExternalSyntheticLambda0, FriendshipStatus.PROCESSING);
                FriendRequestContract.Presenter presenter4 = ReciprocalFriendListFragment.this.friendRequestPresenter;
                if (presenter4 != null) {
                    presenter3 = presenter4;
                } else {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                }
                presenter3.BuiltInFictitiousFunctionClassFactory(p0);
            }

            @Override // id.dana.social.adapter.FriendRequestAdapter.FriendRequestListener
            public final void getAuthRequestContext(FriendModel p0) {
                FriendRequestAdapter friendRequestAdapter;
                Intrinsics.checkNotNullParameter(p0, "");
                friendRequestAdapter = ReciprocalFriendListFragment.this.BuiltInFictitiousFunctionClassFactory;
                FriendRequestContract.Presenter presenter3 = null;
                if (friendRequestAdapter == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                    friendRequestAdapter = null;
                }
                friendRequestAdapter.getAuthRequestContext(p0.NetworkUserEntityData$$ExternalSyntheticLambda0, FriendshipStatus.PROCESSING);
                FriendRequestContract.Presenter presenter4 = ReciprocalFriendListFragment.this.friendRequestPresenter;
                if (presenter4 != null) {
                    presenter3 = presenter4;
                } else {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                }
                presenter3.getAuthRequestContext(p0);
            }

            @Override // id.dana.social.adapter.FriendRequestAdapter.FriendRequestListener
            public final void PlaceComponentResult() {
                ReciprocalBottomSheetDialog.BaseFriendListListener baseFriendListListener;
                baseFriendListListener = ReciprocalFriendListFragment.this.getErrorConfigVersion;
                if (baseFriendListListener != null) {
                    FriendRequestContract.Presenter presenter3 = ReciprocalFriendListFragment.this.friendRequestPresenter;
                    FriendRequestContract.Presenter presenter4 = null;
                    if (presenter3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("");
                        presenter3 = null;
                    }
                    List<FriendModel> authRequestContext = presenter3.getAuthRequestContext();
                    FriendRequestContract.Presenter presenter5 = ReciprocalFriendListFragment.this.friendRequestPresenter;
                    if (presenter5 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("");
                        presenter5 = null;
                    }
                    boolean scheduleImpl = presenter5.getScheduleImpl();
                    FriendRequestContract.Presenter presenter6 = ReciprocalFriendListFragment.this.friendRequestPresenter;
                    if (presenter6 != null) {
                        presenter4 = presenter6;
                    } else {
                        Intrinsics.throwUninitializedPropertyAccessException("");
                    }
                    baseFriendListListener.BuiltInFictitiousFunctionClassFactory(authRequestContext, scheduleImpl, presenter4.getLookAheadTest());
                }
            }
        }, i, r6);
        this.scheduleImpl = new ReciprocalFriendListAdapter(new FriendshipListInteraction() { // from class: id.dana.social.ReciprocalFriendListFragment$setupAdapter$2

            /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
            private final String KClassImpl$Data$declaredNonStaticMembers$2 = "";

            /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
            private final String getAuthRequestContext = "";
            private final String PlaceComponentResult = "";

            @Override // id.dana.social.adapter.FriendshipListInteraction
            public final /* synthetic */ void MyBillsEntityDataFactory(int i2) {
                FriendshipListInteraction.CC.KClassImpl$Data$declaredNonStaticMembers$2();
            }

            @Override // id.dana.social.adapter.FriendshipListInteraction
            @JvmName(name = "BuiltInFictitiousFunctionClassFactory")
            /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from getter */
            public final String getKClassImpl$Data$declaredNonStaticMembers$2() {
                return this.KClassImpl$Data$declaredNonStaticMembers$2;
            }

            @Override // id.dana.social.adapter.FriendshipListInteraction
            @JvmName(name = "getAuthRequestContext")
            /* renamed from: getAuthRequestContext  reason: from getter */
            public final String getGetAuthRequestContext() {
                return this.getAuthRequestContext;
            }

            @Override // id.dana.social.adapter.FriendshipListInteraction
            @JvmName(name = "PlaceComponentResult")
            /* renamed from: PlaceComponentResult  reason: from getter */
            public final String getPlaceComponentResult() {
                return this.PlaceComponentResult;
            }

            @Override // id.dana.social.adapter.FriendshipListInteraction
            public final void KClassImpl$Data$declaredNonStaticMembers$2(int p0) {
                ReciprocalFriendListAdapter reciprocalFriendListAdapter;
                reciprocalFriendListAdapter = ReciprocalFriendListFragment.this.scheduleImpl;
                if (reciprocalFriendListAdapter == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                    reciprocalFriendListAdapter = null;
                }
                RelationshipItemModel item = reciprocalFriendListAdapter.getItem(p0);
                if (item != null) {
                    ReciprocalFriendListFragment.getAuthRequestContext(ReciprocalFriendListFragment.this, item);
                }
            }

            @Override // id.dana.social.adapter.FriendshipListInteraction
            public final void MyBillsEntityDataFactory(int p0, ModifyRelationOperationType p1) {
                ReciprocalFriendListAdapter reciprocalFriendListAdapter;
                Intrinsics.checkNotNullParameter(p1, "");
                reciprocalFriendListAdapter = ReciprocalFriendListFragment.this.scheduleImpl;
                if (reciprocalFriendListAdapter == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                    reciprocalFriendListAdapter = null;
                }
                RelationshipItemModel item = reciprocalFriendListAdapter.getItem(p0);
                ReciprocalFriendListFragment reciprocalFriendListFragment = ReciprocalFriendListFragment.this;
                Intrinsics.checkNotNullExpressionValue(item, "");
                reciprocalFriendListFragment.moveToNextValue = item;
                ReciprocalFriendListFragment.MyBillsEntityDataFactory(ReciprocalFriendListFragment.this, item, p1);
            }
        });
        RecyclerView.Adapter[] adapterArr = new RecyclerView.Adapter[2];
        FriendRequestAdapter friendRequestAdapter = this.BuiltInFictitiousFunctionClassFactory;
        if (friendRequestAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            friendRequestAdapter = null;
        }
        adapterArr[0] = friendRequestAdapter;
        ReciprocalFriendListAdapter reciprocalFriendListAdapter = this.scheduleImpl;
        if (reciprocalFriendListAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            reciprocalFriendListAdapter = null;
        }
        adapterArr[1] = reciprocalFriendListAdapter;
        this.MyBillsEntityDataFactory = new ConcatAdapter(adapterArr);
        FragmentReciprocalFriendListBinding binding2 = getBinding();
        if (binding2 != null && (recyclerView = binding2.scheduleImpl) != null) {
            recyclerView.setNestedScrollingEnabled(true);
            recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext(), 1, false));
            ConcatAdapter concatAdapter = this.MyBillsEntityDataFactory;
            if (concatAdapter == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
                concatAdapter = null;
            }
            recyclerView.setAdapter(concatAdapter);
        }
        FragmentReciprocalFriendListBinding binding3 = getBinding();
        RecyclerView recyclerView2 = binding3 != null ? binding3.scheduleImpl : null;
        if (recyclerView2 != null) {
            recyclerView2.setVisibility(0);
        }
        FragmentReciprocalFriendListBinding binding4 = getBinding();
        SearchView searchView3 = binding4 != null ? binding4.moveToNextValue : null;
        if (searchView3 != null) {
            searchView3.setVisibility(8);
        }
        ReciprocalFriendListAdapter reciprocalFriendListAdapter2 = this.scheduleImpl;
        if (reciprocalFriendListAdapter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            reciprocalFriendListAdapter2 = null;
        }
        reciprocalFriendListAdapter2.PlaceComponentResult();
        RelationshipBottomSheetContract.Presenter presenter3 = this.presenter;
        if (presenter3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            presenter3 = null;
        }
        presenter3.BuiltInFictitiousFunctionClassFactory();
        FragmentReciprocalFriendListBinding binding5 = getBinding();
        if (binding5 != null && (searchView2 = binding5.moveToNextValue) != null) {
            searchView2.setSearchHint(getString(R.string.search_reciprocal));
            RelationshipBottomSheetContract.Presenter presenter4 = this.presenter;
            if (presenter4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
                presenter4 = null;
            }
            PublishSubject<String> keyword = searchView2.getKeyword();
            Intrinsics.checkNotNullExpressionValue(keyword, "");
            presenter4.PlaceComponentResult(keyword);
        }
        FragmentReciprocalFriendListBinding binding6 = getBinding();
        EditText editText = (binding6 == null || (searchView = binding6.moveToNextValue) == null) ? null : searchView.getEditText();
        if (editText != null) {
            editText.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: id.dana.social.ReciprocalFriendListFragment$$ExternalSyntheticLambda0
                @Override // android.view.View.OnFocusChangeListener
                public final void onFocusChange(View view, boolean z) {
                    ReciprocalFriendListFragment.PlaceComponentResult(ReciprocalFriendListFragment.this, z);
                }
            });
        }
        if (!this.KClassImpl$Data$declaredNonStaticMembers$2.BuiltInFictitiousFunctionClassFactory()) {
            this.KClassImpl$Data$declaredNonStaticMembers$2.observeOn(AndroidSchedulers.PlaceComponentResult()).subscribeOn(Schedulers.MyBillsEntityDataFactory()).subscribe(new DefaultObserver<DataReady>() { // from class: id.dana.social.ReciprocalFriendListFragment$observeDataReady$1
                @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
                public final /* synthetic */ void onNext(Object obj) {
                    DataReady dataReady = (DataReady) obj;
                    Intrinsics.checkNotNullParameter(dataReady, "");
                    if (dataReady.getMyBillsEntityDataFactory() && dataReady.getGetAuthRequestContext()) {
                        ReciprocalFriendListFragment.NetworkUserEntityData$$ExternalSyntheticLambda0(ReciprocalFriendListFragment.this);
                    }
                }
            });
        }
        RelationshipBottomSheetContract.Presenter presenter5 = this.presenter;
        if (presenter5 != null) {
            r6 = presenter5;
        } else {
            Intrinsics.throwUninitializedPropertyAccessException("");
        }
        r6.MyBillsEntityDataFactory();
    }
}
