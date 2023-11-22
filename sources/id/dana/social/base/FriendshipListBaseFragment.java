package id.dana.social.base;

import android.content.Context;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.alipay.iap.android.common.syncintegration.api.IAPSyncCommand;
import id.dana.R;
import id.dana.base.AbstractContract;
import id.dana.base.BaseFragment;
import id.dana.domain.social.ModifyRelationOperationType;
import id.dana.feeds.ui.model.RelationshipItemModel;
import id.dana.feeds.ui.tracker.FriendshipAnalyticTracker;
import id.dana.richview.LogoProgressView;
import id.dana.richview.SearchView;
import id.dana.social.adapter.FriendshipListAdapter;
import id.dana.social.adapter.FriendshipListInteraction;
import id.dana.social.contract.FriendshipContract;
import id.dana.social.di.component.SocialCommonComponent;
import id.dana.social.di.module.FriendshipModule;
import id.dana.social.view.activity.SocialProfileActivity;
import io.reactivex.subjects.PublishSubject;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b&\u0018\u0000 )2\u00020\u0001:\u0002)*B\u000f\u0012\u0006\u0010\u0003\u001a\u00020%¢\u0006\u0004\b'\u0010(J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0006H&¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u0007\u001a\u00020\u0002H&¢\u0006\u0004\b\u0007\u0010\u000bJ\u000f\u0010\f\u001a\u00020\u0002H&¢\u0006\u0004\b\f\u0010\u000bJ\u000f\u0010\r\u001a\u00020\u0002H&¢\u0006\u0004\b\r\u0010\u000bJ\u000f\u0010\u000e\u001a\u00020\u0002H&¢\u0006\u0004\b\u000e\u0010\u000bJ\u000f\u0010\u000f\u001a\u00020\u0002H&¢\u0006\u0004\b\u000f\u0010\u000bJ\u000f\u0010\u0011\u001a\u00020\u0010H\u0014¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0014\u001a\u00020\u0013H&¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0016\u001a\u00020\u0002H&¢\u0006\u0004\b\u0016\u0010\u000bJ\u000f\u0010\u0017\u001a\u00020\u0002H&¢\u0006\u0004\b\u0017\u0010\u000bJ\u000f\u0010\u0018\u001a\u00020\u0006H\u0014¢\u0006\u0004\b\u0018\u0010\nJ\u000f\u0010\u0019\u001a\u00020\u0006H&¢\u0006\u0004\b\u0019\u0010\nJ\u001f\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u001a\u0010\u001bJ\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0007\u0010\u001cR\u0012\u0010\u001e\u001a\u00020\u001dX\u0087\"¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0012\u0010\t\u001a\u00020 X\u0087\"¢\u0006\u0006\n\u0004\b\f\u0010!R\u0012\u0010#\u001a\u00020\"X\u0087\"¢\u0006\u0006\n\u0004\b#\u0010$R\u0014\u0010\r\u001a\u00020%8\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b\t\u0010&"}, d2 = {"Lid/dana/social/base/FriendshipListBaseFragment;", "Lid/dana/base/BaseFragment;", "", "p0", "Lid/dana/domain/social/ModifyRelationOperationType;", "p1", "", "getAuthRequestContext", "(Ljava/lang/String;Lid/dana/domain/social/ModifyRelationOperationType;)V", "MyBillsEntityDataFactory", "()V", "()Ljava/lang/String;", "KClassImpl$Data$declaredNonStaticMembers$2", "PlaceComponentResult", "getErrorConfigVersion", "NetworkUserEntityData$$ExternalSyntheticLambda0", "", "getLayout", "()I", "Landroid/view/View$OnClickListener;", "moveToNextValue", "()Landroid/view/View$OnClickListener;", "scheduleImpl", "lookAheadTest", IAPSyncCommand.COMMAND_INIT, "NetworkUserEntityData$$ExternalSyntheticLambda2", "BuiltInFictitiousFunctionClassFactory", "(Ljava/lang/String;Ljava/lang/String;)V", "(Ljava/lang/String;)V", "Lid/dana/feeds/ui/tracker/FriendshipAnalyticTracker;", "friendshipAnalyticTracker", "Lid/dana/feeds/ui/tracker/FriendshipAnalyticTracker;", "Lid/dana/social/adapter/FriendshipListAdapter;", "Lid/dana/social/adapter/FriendshipListAdapter;", "Lid/dana/social/contract/FriendshipContract$Presenter;", "friendshipPresenter", "Lid/dana/social/contract/FriendshipContract$Presenter;", "Lid/dana/social/base/FriendshipListBaseFragment$ShowSnackbarInterface;", "Lid/dana/social/base/FriendshipListBaseFragment$ShowSnackbarInterface;", "<init>", "(Lid/dana/social/base/FriendshipListBaseFragment$ShowSnackbarInterface;)V", "Companion", "ShowSnackbarInterface"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public abstract class FriendshipListBaseFragment extends BaseFragment {

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    public FriendshipListAdapter MyBillsEntityDataFactory;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private final ShowSnackbarInterface PlaceComponentResult;
    public Map<Integer, View> PlaceComponentResult;
    @Inject
    public FriendshipAnalyticTracker friendshipAnalyticTracker;
    @Inject
    public FriendshipContract.Presenter friendshipPresenter;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/social/base/FriendshipListBaseFragment$ShowSnackbarInterface;", "", "", "p0", "", "PlaceComponentResult", "(Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public interface ShowSnackbarInterface {
        void PlaceComponentResult(String p0);
    }

    public View BuiltInFictitiousFunctionClassFactory(int i) {
        View findViewById;
        Map<Integer, View> map = this.PlaceComponentResult;
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

    public void BuiltInFictitiousFunctionClassFactory() {
        this.PlaceComponentResult.clear();
    }

    public abstract String KClassImpl$Data$declaredNonStaticMembers$2();

    public abstract void MyBillsEntityDataFactory();

    public abstract String NetworkUserEntityData$$ExternalSyntheticLambda0();

    public abstract void NetworkUserEntityData$$ExternalSyntheticLambda2();

    public abstract String PlaceComponentResult();

    public abstract String getAuthRequestContext();

    public abstract void getAuthRequestContext(String p0);

    public abstract void getAuthRequestContext(String p0, ModifyRelationOperationType p1);

    public abstract String getErrorConfigVersion();

    @Override // id.dana.base.BaseFragment
    public int getLayout() {
        return R.layout.view_friendship;
    }

    public abstract String lookAheadTest();

    public abstract View.OnClickListener moveToNextValue();

    @Override // id.dana.base.BaseFragment, androidx.fragment.app.Fragment
    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        BuiltInFictitiousFunctionClassFactory();
    }

    public abstract String scheduleImpl();

    public FriendshipListBaseFragment(ShowSnackbarInterface showSnackbarInterface) {
        Intrinsics.checkNotNullParameter(showSnackbarInterface, "");
        this.PlaceComponentResult = new LinkedHashMap();
        this.PlaceComponentResult = showSnackbarInterface;
    }

    private final void BuiltInFictitiousFunctionClassFactory(String p0, String p1) {
        ShowSnackbarInterface showSnackbarInterface = this.PlaceComponentResult;
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String format = String.format(p0, Arrays.copyOf(new Object[]{p1}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "");
        showSnackbarInterface.PlaceComponentResult(format);
    }

    public static /* synthetic */ void PlaceComponentResult(FriendshipListBaseFragment friendshipListBaseFragment, boolean z) {
        Intrinsics.checkNotNullParameter(friendshipListBaseFragment, "");
        if (z) {
            LinearLayout linearLayout = (LinearLayout) friendshipListBaseFragment.BuiltInFictitiousFunctionClassFactory(R.id.ll_friendship);
            if (linearLayout != null) {
                linearLayout.setVisibility(0);
                return;
            }
            return;
        }
        LinearLayout linearLayout2 = (LinearLayout) friendshipListBaseFragment.BuiltInFictitiousFunctionClassFactory(R.id.ll_friendship);
        if (linearLayout2 != null) {
            linearLayout2.setVisibility(8);
        }
        Context context = friendshipListBaseFragment.getContext();
        Object systemService = context != null ? context.getSystemService("input_method") : null;
        if (systemService == null) {
            throw new NullPointerException("null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
        }
        InputMethodManager inputMethodManager = (InputMethodManager) systemService;
        View view = friendshipListBaseFragment.getView();
        if (view != null) {
            inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }

    public static final /* synthetic */ void getAuthRequestContext(FriendshipListBaseFragment friendshipListBaseFragment, List list) {
        LogoProgressView logoProgressView = (LogoProgressView) friendshipListBaseFragment.BuiltInFictitiousFunctionClassFactory(R.id.lpv_friendship);
        if (logoProgressView != null) {
            logoProgressView.stopRefresh();
        }
        LogoProgressView logoProgressView2 = (LogoProgressView) friendshipListBaseFragment.BuiltInFictitiousFunctionClassFactory(R.id.lpv_friendship);
        if (logoProgressView2 != null) {
            logoProgressView2.setVisibility(8);
        }
        RecyclerView recyclerView = (RecyclerView) friendshipListBaseFragment.BuiltInFictitiousFunctionClassFactory(R.id.res_0x7f0a1153_paymentsettingpresenter_getautorouteinitialstate_1);
        if (recyclerView != null) {
            recyclerView.setVisibility(0);
        }
        FriendshipListAdapter friendshipListAdapter = friendshipListBaseFragment.MyBillsEntityDataFactory;
        if (friendshipListAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            friendshipListAdapter = null;
        }
        friendshipListAdapter.setItems(list);
    }

    public static final /* synthetic */ void KClassImpl$Data$declaredNonStaticMembers$2(FriendshipListBaseFragment friendshipListBaseFragment, RelationshipItemModel relationshipItemModel) {
        String str = "ACTIVE";
        if (Intrinsics.areEqual(relationshipItemModel.getErrorConfigVersion, "ACTIVE")) {
            friendshipListBaseFragment.getAuthRequestContext(relationshipItemModel.GetContactSyncConfig, ModifyRelationOperationType.valueOf(friendshipListBaseFragment.getAuthRequestContext()));
            friendshipListBaseFragment.BuiltInFictitiousFunctionClassFactory(friendshipListBaseFragment.PlaceComponentResult(), relationshipItemModel.scheduleImpl);
            str = "INACTIVE";
        } else {
            friendshipListBaseFragment.getAuthRequestContext(relationshipItemModel.GetContactSyncConfig, ModifyRelationOperationType.valueOf(friendshipListBaseFragment.getErrorConfigVersion()));
            friendshipListBaseFragment.BuiltInFictitiousFunctionClassFactory(friendshipListBaseFragment.NetworkUserEntityData$$ExternalSyntheticLambda0(), relationshipItemModel.scheduleImpl);
        }
        Intrinsics.checkNotNullParameter(str, "");
        relationshipItemModel.getErrorConfigVersion = str;
        friendshipListBaseFragment.getAuthRequestContext(relationshipItemModel.getErrorConfigVersion);
    }

    public static final /* synthetic */ Unit getAuthRequestContext(FriendshipListBaseFragment friendshipListBaseFragment, RelationshipItemModel relationshipItemModel) {
        Context context = friendshipListBaseFragment.getContext();
        if (context != null) {
            if (!StringsKt.contains$default((CharSequence) relationshipItemModel.scheduleImpl, (CharSequence) "•", false, 2, (Object) null)) {
                SocialProfileActivity.Companion companion = SocialProfileActivity.INSTANCE;
                SocialProfileActivity.Companion.KClassImpl$Data$declaredNonStaticMembers$2(context, relationshipItemModel);
            }
            return Unit.INSTANCE;
        }
        return null;
    }

    @Override // id.dana.base.BaseFragment
    public void init() {
        SocialCommonComponent socialCommonComponent = getBaseActivity().getDanaApplication().getSocialCommonComponent();
        if (socialCommonComponent != null) {
            socialCommonComponent.BuiltInFictitiousFunctionClassFactory(new FriendshipModule(new FriendshipContract.View() { // from class: id.dana.social.base.FriendshipListBaseFragment$initComponent$1
                @Override // id.dana.base.AbstractContract.AbstractView
                public final void dismissProgress() {
                }

                @Override // id.dana.base.AbstractContract.AbstractView
                public final void onError(String p0) {
                }

                @Override // id.dana.base.AbstractContract.AbstractView
                public final void showProgress() {
                }

                @Override // id.dana.social.contract.FriendshipContract.View
                public final void KClassImpl$Data$declaredNonStaticMembers$2(List<RelationshipItemModel> p0) {
                    Intrinsics.checkNotNullParameter(p0, "");
                    FriendshipListAdapter friendshipListAdapter = FriendshipListBaseFragment.this.MyBillsEntityDataFactory;
                    if (friendshipListAdapter == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("");
                        friendshipListAdapter = null;
                    }
                    friendshipListAdapter.setItems(p0);
                }

                @Override // id.dana.social.contract.FriendshipContract.View
                public final void MyBillsEntityDataFactory(List<RelationshipItemModel> p0) {
                    Intrinsics.checkNotNullParameter(p0, "");
                    FriendshipListBaseFragment.getAuthRequestContext(FriendshipListBaseFragment.this, p0);
                }
            })).MyBillsEntityDataFactory(this);
        }
        AbstractContract.AbstractPresenter[] abstractPresenterArr = new AbstractContract.AbstractPresenter[1];
        FriendshipContract.Presenter presenter = this.friendshipPresenter;
        FriendshipContract.Presenter presenter2 = null;
        if (presenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            presenter = null;
        }
        abstractPresenterArr[0] = presenter;
        registerPresenter(abstractPresenterArr);
        FriendshipListAdapter friendshipListAdapter = new FriendshipListAdapter(new FriendshipListInteraction() { // from class: id.dana.social.base.FriendshipListBaseFragment$setupAdapter$1

            /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
            private final String KClassImpl$Data$declaredNonStaticMembers$2;

            /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
            private final String PlaceComponentResult;

            /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
            private final String BuiltInFictitiousFunctionClassFactory;

            @Override // id.dana.social.adapter.FriendshipListInteraction
            public final /* synthetic */ void MyBillsEntityDataFactory(int i, ModifyRelationOperationType modifyRelationOperationType) {
                FriendshipListInteraction.CC.BuiltInFictitiousFunctionClassFactory(modifyRelationOperationType);
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.KClassImpl$Data$declaredNonStaticMembers$2 = FriendshipListBaseFragment.this.getAuthRequestContext();
                this.BuiltInFictitiousFunctionClassFactory = FriendshipListBaseFragment.this.getErrorConfigVersion();
                this.PlaceComponentResult = FriendshipListBaseFragment.this.KClassImpl$Data$declaredNonStaticMembers$2();
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
            public final String getBuiltInFictitiousFunctionClassFactory() {
                return this.BuiltInFictitiousFunctionClassFactory;
            }

            @Override // id.dana.social.adapter.FriendshipListInteraction
            @JvmName(name = "PlaceComponentResult")
            /* renamed from: PlaceComponentResult  reason: from getter */
            public final String getPlaceComponentResult() {
                return this.PlaceComponentResult;
            }

            @Override // id.dana.social.adapter.FriendshipListInteraction
            public final void KClassImpl$Data$declaredNonStaticMembers$2(int p0) {
                FriendshipListAdapter friendshipListAdapter2 = FriendshipListBaseFragment.this.MyBillsEntityDataFactory;
                if (friendshipListAdapter2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                    friendshipListAdapter2 = null;
                }
                RelationshipItemModel item = friendshipListAdapter2.getItem(p0);
                if (item != null) {
                    FriendshipListBaseFragment.getAuthRequestContext(FriendshipListBaseFragment.this, item);
                }
            }

            @Override // id.dana.social.adapter.FriendshipListInteraction
            public final void MyBillsEntityDataFactory(int p0) {
                if (p0 == -1) {
                    return;
                }
                FriendshipListAdapter friendshipListAdapter2 = FriendshipListBaseFragment.this.MyBillsEntityDataFactory;
                if (friendshipListAdapter2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                    friendshipListAdapter2 = null;
                }
                FriendshipListBaseFragment friendshipListBaseFragment = FriendshipListBaseFragment.this;
                RelationshipItemModel item = friendshipListAdapter2.getItem(p0);
                if (item != null) {
                    Intrinsics.checkNotNullExpressionValue(item, "");
                    FriendshipListBaseFragment.KClassImpl$Data$declaredNonStaticMembers$2(friendshipListBaseFragment, item);
                }
                friendshipListAdapter2.removeItem(p0);
                friendshipListAdapter2.notifyItemChanged(p0);
            }
        });
        Intrinsics.checkNotNullParameter(friendshipListAdapter, "");
        this.MyBillsEntityDataFactory = friendshipListAdapter;
        RecyclerView recyclerView = (RecyclerView) BuiltInFictitiousFunctionClassFactory(R.id.res_0x7f0a1153_paymentsettingpresenter_getautorouteinitialstate_1);
        if (recyclerView != null) {
            recyclerView.setNestedScrollingEnabled(true);
        }
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), 1, false);
        RecyclerView recyclerView2 = (RecyclerView) BuiltInFictitiousFunctionClassFactory(R.id.res_0x7f0a1153_paymentsettingpresenter_getautorouteinitialstate_1);
        if (recyclerView2 != null) {
            recyclerView2.setLayoutManager(linearLayoutManager);
        }
        RecyclerView recyclerView3 = (RecyclerView) BuiltInFictitiousFunctionClassFactory(R.id.res_0x7f0a1153_paymentsettingpresenter_getautorouteinitialstate_1);
        if (recyclerView3 != null) {
            FriendshipListAdapter friendshipListAdapter2 = this.MyBillsEntityDataFactory;
            if (friendshipListAdapter2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
                friendshipListAdapter2 = null;
            }
            recyclerView3.setAdapter(friendshipListAdapter2);
        }
        NetworkUserEntityData$$ExternalSyntheticLambda2();
        LogoProgressView logoProgressView = (LogoProgressView) BuiltInFictitiousFunctionClassFactory(R.id.lpv_friendship);
        if (logoProgressView != null) {
            logoProgressView.startRefresh();
        }
        MyBillsEntityDataFactory();
        ((SearchView) BuiltInFictitiousFunctionClassFactory(R.id.sv_friendship_search)).setSearchHint(getString(R.string.search));
        FriendshipContract.Presenter presenter3 = this.friendshipPresenter;
        if (presenter3 != null) {
            presenter2 = presenter3;
        } else {
            Intrinsics.throwUninitializedPropertyAccessException("");
        }
        PublishSubject<String> keyword = ((SearchView) BuiltInFictitiousFunctionClassFactory(R.id.sv_friendship_search)).getKeyword();
        Intrinsics.checkNotNullExpressionValue(keyword, "");
        presenter2.BuiltInFictitiousFunctionClassFactory(keyword);
        ((SearchView) BuiltInFictitiousFunctionClassFactory(R.id.sv_friendship_search)).getEditText().setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: id.dana.social.base.FriendshipListBaseFragment$$ExternalSyntheticLambda0
            @Override // android.view.View.OnFocusChangeListener
            public final void onFocusChange(View view, boolean z) {
                FriendshipListBaseFragment.PlaceComponentResult(FriendshipListBaseFragment.this, z);
            }
        });
        ((TextView) BuiltInFictitiousFunctionClassFactory(R.id.res_0x7f0a18a6_citcallverifyfragment_setupcitcallprefix_1_1)).setText(lookAheadTest());
        ((TextView) BuiltInFictitiousFunctionClassFactory(R.id.res_0x7f0a18a6_citcallverifyfragment_setupcitcallprefix_1_1)).setContentDescription(scheduleImpl());
        ((LinearLayout) BuiltInFictitiousFunctionClassFactory(R.id.ll_restricted_contact_layout)).setOnClickListener(moveToNextValue());
    }
}
