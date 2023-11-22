package id.dana.social.fragment;

import android.content.Context;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.afollestad.materialdialogs.MaterialDialog;
import com.alipay.iap.android.common.syncintegration.api.IAPSyncCommand;
import id.dana.R;
import id.dana.base.AbstractContractKt;
import id.dana.base.BaseFragment;
import id.dana.component.dialogcomponent.CustomDialog;
import id.dana.component.extension.ViewExtKt;
import id.dana.domain.social.ModifyRelationOperationType;
import id.dana.feeds.ui.model.RelationshipItemModel;
import id.dana.feeds.ui.tracker.FeedsErrorSource;
import id.dana.richview.EmptyState;
import id.dana.social.RestrictedContactActivtyInteractor;
import id.dana.social.adapter.FriendshipListInteraction;
import id.dana.social.adapter.RestrictedContactAdapter;
import id.dana.social.contract.BlockedFragmentContract;
import id.dana.social.di.module.BlockedFragmentModule;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0012\u0010\u0007J\u000f\u0010\u0003\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0014¢\u0006\u0004\b\u0006\u0010\u0007R\u0016\u0010\t\u001a\u00020\b8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\t\u0010\nR\u0016\u0010\u000e\u001a\u00020\u000b8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0012\u0010\u0010\u001a\u00020\u000fX\u0087\"¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011"}, d2 = {"Lid/dana/social/fragment/BlockedFragment;", "Lid/dana/base/BaseFragment;", "", "getLayout", "()I", "", IAPSyncCommand.COMMAND_INIT, "()V", "Lid/dana/social/adapter/RestrictedContactAdapter;", "PlaceComponentResult", "Lid/dana/social/adapter/RestrictedContactAdapter;", "Lcom/afollestad/materialdialogs/MaterialDialog;", "KClassImpl$Data$declaredNonStaticMembers$2", "Lcom/afollestad/materialdialogs/MaterialDialog;", "getAuthRequestContext", "Lid/dana/social/contract/BlockedFragmentContract$Presenter;", "presenter", "Lid/dana/social/contract/BlockedFragmentContract$Presenter;", "<init>"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class BlockedFragment extends BaseFragment {

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    private MaterialDialog getAuthRequestContext;
    public Map<Integer, View> MyBillsEntityDataFactory = new LinkedHashMap();
    private RestrictedContactAdapter PlaceComponentResult;
    @Inject
    public BlockedFragmentContract.Presenter presenter;

    private View KClassImpl$Data$declaredNonStaticMembers$2(int i) {
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
        return R.layout.fragment_blocked_list;
    }

    public static final /* synthetic */ void MyBillsEntityDataFactory(BlockedFragment blockedFragment) {
        EmptyState emptyState = (EmptyState) blockedFragment.KClassImpl$Data$declaredNonStaticMembers$2(R.id.calcCaptureRect);
        if (emptyState != null) {
            emptyState.setVisibility(8);
        }
    }

    public static final /* synthetic */ Unit PlaceComponentResult(final BlockedFragment blockedFragment, final RelationshipItemModel relationshipItemModel) {
        Context context = blockedFragment.getContext();
        if (context != null) {
            CustomDialog.Builder builder = new CustomDialog.Builder(context);
            builder.SubSequence = context.getString(R.string.blocked_contacts_confirm_dialog_title);
            builder.GetContactSyncConfig = context.getString(R.string.blocked_contacts_confirm_dialog_body);
            CustomDialog.Builder BuiltInFictitiousFunctionClassFactory = builder.KClassImpl$Data$declaredNonStaticMembers$2(context.getString(R.string.confirm_dialog_negative), new Function1<View, Unit>() { // from class: id.dana.social.fragment.BlockedFragment$showConfirmationDialog$1$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final /* bridge */ /* synthetic */ Unit invoke(View view) {
                    invoke2(view);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2(View view) {
                    MaterialDialog materialDialog;
                    Intrinsics.checkNotNullParameter(view, "");
                    materialDialog = BlockedFragment.this.getAuthRequestContext;
                    if (materialDialog == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("");
                        materialDialog = null;
                    }
                    materialDialog.dismiss();
                }
            }).BuiltInFictitiousFunctionClassFactory(context.getString(R.string.confirm_dialog_positive), new Function1<View, Unit>() { // from class: id.dana.social.fragment.BlockedFragment$showConfirmationDialog$1$2
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final /* bridge */ /* synthetic */ Unit invoke(View view) {
                    invoke2(view);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2(View view) {
                    Intrinsics.checkNotNullParameter(view, "");
                    BlockedFragment.BuiltInFictitiousFunctionClassFactory(BlockedFragment.this, relationshipItemModel);
                }
            });
            BuiltInFictitiousFunctionClassFactory.moveToNextValue = 0L;
            MaterialDialog BuiltInFictitiousFunctionClassFactory2 = BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory();
            ViewExtKt.getAuthRequestContext(BuiltInFictitiousFunctionClassFactory2, BuiltInFictitiousFunctionClassFactory.moveToNextValue);
            blockedFragment.getAuthRequestContext = BuiltInFictitiousFunctionClassFactory2;
            return Unit.INSTANCE;
        }
        return null;
    }

    public static final /* synthetic */ void PlaceComponentResult(BlockedFragment blockedFragment) {
        EmptyState emptyState = (EmptyState) blockedFragment.KClassImpl$Data$declaredNonStaticMembers$2(R.id.calcCaptureRect);
        if (emptyState != null) {
            emptyState.setVisibility(0);
        }
    }

    public static final /* synthetic */ void getAuthRequestContext(BlockedFragment blockedFragment) {
        FragmentActivity activity = blockedFragment.getActivity();
        if (activity instanceof RestrictedContactActivtyInteractor) {
            ((RestrictedContactActivtyInteractor) activity).showErrorToast();
        }
    }

    public static final /* synthetic */ void getAuthRequestContext(BlockedFragment blockedFragment, String str) {
        FragmentActivity activity = blockedFragment.getActivity();
        if (activity instanceof RestrictedContactActivtyInteractor) {
            String string = blockedFragment.getResources().getString(R.string.friendship_unblock, str);
            Intrinsics.checkNotNullExpressionValue(string, "");
            ((RestrictedContactActivtyInteractor) activity).showDialogToast(string);
        }
    }

    public static final /* synthetic */ void BuiltInFictitiousFunctionClassFactory(BlockedFragment blockedFragment, RelationshipItemModel relationshipItemModel) {
        BlockedFragmentContract.Presenter presenter = blockedFragment.presenter;
        if (presenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            presenter = null;
        }
        presenter.MyBillsEntityDataFactory(relationshipItemModel);
    }

    @Override // id.dana.base.BaseFragment
    public final void init() {
        getBaseActivity().getDanaApplication().getRestrictedContactComponent().BuiltInFictitiousFunctionClassFactory(new BlockedFragmentModule(new BlockedFragmentContract.View() { // from class: id.dana.social.fragment.BlockedFragment$initComponent$1
            @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
            public final /* synthetic */ void dismissProgress() {
                AbstractContractKt.AbstractView.CC.MyBillsEntityDataFactory();
            }

            @Override // id.dana.base.AbstractContractKt.AbstractView
            public final String getErrorSource() {
                return FeedsErrorSource.FEED_PRIVACY;
            }

            @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
            public final /* synthetic */ void onError(String str) {
                AbstractContractKt.AbstractView.CC.BuiltInFictitiousFunctionClassFactory();
            }

            @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
            public final /* synthetic */ void showProgress() {
                AbstractContractKt.AbstractView.CC.PlaceComponentResult();
            }

            @Override // id.dana.social.contract.BlockedFragmentContract.View
            public final void BuiltInFictitiousFunctionClassFactory(List<RelationshipItemModel> p0) {
                RestrictedContactAdapter restrictedContactAdapter;
                Intrinsics.checkNotNullParameter(p0, "");
                restrictedContactAdapter = BlockedFragment.this.PlaceComponentResult;
                if (restrictedContactAdapter == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                    restrictedContactAdapter = null;
                }
                restrictedContactAdapter.setItems(p0);
            }

            @Override // id.dana.social.contract.BlockedFragmentContract.View
            public final void KClassImpl$Data$declaredNonStaticMembers$2() {
                BlockedFragment.PlaceComponentResult(BlockedFragment.this);
            }

            @Override // id.dana.social.contract.BlockedFragmentContract.View
            public final void KClassImpl$Data$declaredNonStaticMembers$2(RelationshipItemModel p0) {
                RestrictedContactAdapter restrictedContactAdapter;
                RestrictedContactAdapter restrictedContactAdapter2;
                Intrinsics.checkNotNullParameter(p0, "");
                restrictedContactAdapter = BlockedFragment.this.PlaceComponentResult;
                RestrictedContactAdapter restrictedContactAdapter3 = null;
                if (restrictedContactAdapter == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                    restrictedContactAdapter = null;
                }
                restrictedContactAdapter2 = BlockedFragment.this.PlaceComponentResult;
                if (restrictedContactAdapter2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                } else {
                    restrictedContactAdapter3 = restrictedContactAdapter2;
                }
                List<RelationshipItemModel> items = restrictedContactAdapter3.getItems();
                Intrinsics.checkNotNullExpressionValue(items, "");
                ArrayList arrayList = new ArrayList();
                for (Object obj : items) {
                    if (!Intrinsics.areEqual(((RelationshipItemModel) obj).GetContactSyncConfig, p0.GetContactSyncConfig)) {
                        arrayList.add(obj);
                    }
                }
                restrictedContactAdapter.setItems(arrayList);
                BlockedFragment.getAuthRequestContext(BlockedFragment.this, p0.scheduleImpl);
            }

            @Override // id.dana.social.contract.BlockedFragmentContract.View
            public final String MyBillsEntityDataFactory() {
                String str;
                BlockedFragment.getAuthRequestContext(BlockedFragment.this);
                FragmentActivity activity = BlockedFragment.this.getActivity();
                if (activity == null) {
                    str = null;
                } else if (activity instanceof RestrictedContactActivtyInteractor) {
                    return ((RestrictedContactActivtyInteractor) activity).getErrorToast();
                } else {
                    str = "";
                }
                return str == null ? "" : str;
            }
        })).BuiltInFictitiousFunctionClassFactory(this);
        BlockedFragmentContract.Presenter presenter = this.presenter;
        RestrictedContactAdapter restrictedContactAdapter = null;
        if (presenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            presenter = null;
        }
        presenter.PlaceComponentResult();
        RestrictedContactAdapter restrictedContactAdapter2 = new RestrictedContactAdapter(new FriendshipListInteraction() { // from class: id.dana.social.fragment.BlockedFragment$initAdapter$1

            /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
            private final String KClassImpl$Data$declaredNonStaticMembers$2;

            /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
            private final String BuiltInFictitiousFunctionClassFactory;

            /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
            private final String getAuthRequestContext;

            @Override // id.dana.social.adapter.FriendshipListInteraction
            public final /* synthetic */ void KClassImpl$Data$declaredNonStaticMembers$2(int i) {
                FriendshipListInteraction.CC.getAuthRequestContext();
            }

            @Override // id.dana.social.adapter.FriendshipListInteraction
            public final /* synthetic */ void MyBillsEntityDataFactory(int i, ModifyRelationOperationType modifyRelationOperationType) {
                FriendshipListInteraction.CC.BuiltInFictitiousFunctionClassFactory(modifyRelationOperationType);
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                String string = BlockedFragment.this.getResources().getString(R.string.unblock_button_label);
                Intrinsics.checkNotNullExpressionValue(string, "");
                this.BuiltInFictitiousFunctionClassFactory = string;
                this.KClassImpl$Data$declaredNonStaticMembers$2 = "";
                this.getAuthRequestContext = "";
            }

            @Override // id.dana.social.adapter.FriendshipListInteraction
            @JvmName(name = "BuiltInFictitiousFunctionClassFactory")
            /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from getter */
            public final String getBuiltInFictitiousFunctionClassFactory() {
                return this.BuiltInFictitiousFunctionClassFactory;
            }

            @Override // id.dana.social.adapter.FriendshipListInteraction
            @JvmName(name = "getAuthRequestContext")
            /* renamed from: getAuthRequestContext  reason: from getter */
            public final String getKClassImpl$Data$declaredNonStaticMembers$2() {
                return this.KClassImpl$Data$declaredNonStaticMembers$2;
            }

            @Override // id.dana.social.adapter.FriendshipListInteraction
            @JvmName(name = "PlaceComponentResult")
            /* renamed from: PlaceComponentResult  reason: from getter */
            public final String getGetAuthRequestContext() {
                return this.getAuthRequestContext;
            }

            @Override // id.dana.social.adapter.FriendshipListInteraction
            public final void MyBillsEntityDataFactory(int p0) {
                RestrictedContactAdapter restrictedContactAdapter3;
                restrictedContactAdapter3 = BlockedFragment.this.PlaceComponentResult;
                if (restrictedContactAdapter3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                    restrictedContactAdapter3 = null;
                }
                RelationshipItemModel item = restrictedContactAdapter3.getItem(p0);
                if (item != null) {
                    BlockedFragment.PlaceComponentResult(BlockedFragment.this, item);
                }
            }
        });
        this.PlaceComponentResult = restrictedContactAdapter2;
        restrictedContactAdapter2.registerAdapterDataObserver(new RecyclerView.AdapterDataObserver() { // from class: id.dana.social.fragment.BlockedFragment$initAdapter$2
            @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
            public final void onChanged() {
                RestrictedContactAdapter restrictedContactAdapter3;
                restrictedContactAdapter3 = BlockedFragment.this.PlaceComponentResult;
                if (restrictedContactAdapter3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                    restrictedContactAdapter3 = null;
                }
                if (restrictedContactAdapter3.getItemCount() > 0) {
                    BlockedFragment.MyBillsEntityDataFactory(BlockedFragment.this);
                } else {
                    BlockedFragment.PlaceComponentResult(BlockedFragment.this);
                }
            }
        });
        RecyclerView recyclerView = (RecyclerView) KClassImpl$Data$declaredNonStaticMembers$2(R.id.getMonitoredResourcesOrBuilder);
        if (recyclerView != null) {
            recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), 1, false));
        }
        RecyclerView recyclerView2 = (RecyclerView) KClassImpl$Data$declaredNonStaticMembers$2(R.id.getMonitoredResourcesOrBuilder);
        if (recyclerView2 != null) {
            RestrictedContactAdapter restrictedContactAdapter3 = this.PlaceComponentResult;
            if (restrictedContactAdapter3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
            } else {
                restrictedContactAdapter = restrictedContactAdapter3;
            }
            recyclerView2.setAdapter(restrictedContactAdapter);
        }
    }

    @Override // id.dana.base.BaseFragment, androidx.fragment.app.Fragment
    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        this.MyBillsEntityDataFactory.clear();
    }
}
