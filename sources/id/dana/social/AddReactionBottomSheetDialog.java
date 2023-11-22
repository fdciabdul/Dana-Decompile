package id.dana.social;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import androidx.core.content.ContextCompat;
import androidx.core.os.BundleKt;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.ethanhua.skeleton.RecyclerViewSkeletonScreen;
import com.ethanhua.skeleton.Skeleton;
import id.dana.DanaApplication;
import id.dana.R;
import id.dana.base.BaseActivity;
import id.dana.base.BaseBottomSheetDialogFragment;
import id.dana.common.DividerItemDecoration;
import id.dana.databinding.BottomSheetReactionListBinding;
import id.dana.feeds.domain.reactions.model.DeleteReactionResult;
import id.dana.feeds.ui.reaction.model.ReactionModel;
import id.dana.feeds.ui.tracker.FriendshipAnalyticTracker;
import id.dana.social.adapter.ReactionListAdapter;
import id.dana.social.contract.reaction.ReactionsContract;
import id.dana.social.di.component.SocialCommonComponent;
import id.dana.social.di.module.ReactionsModule;
import id.dana.social.model.FeedModel;
import id.dana.social.model.ReactionResultModel;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 -2\u00020\u00012\u00020\u0002:\u0001-B\u0007¢\u0006\u0004\b,\u0010\u0010J\u000f\u0010\u0004\u001a\u00020\u0003H\u0014¢\u0006\u0004\b\u0004\u0010\u0005J\u0013\u0010\b\u001a\u00060\u0006j\u0002`\u0007H\u0016¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\n\u0010\tJ\u000f\u0010\f\u001a\u00020\u000bH\u0014¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000f\u001a\u00020\u000eH\u0014¢\u0006\u0004\b\u000f\u0010\u0010J\u001d\u0010\u0014\u001a\u00020\u000e2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u001d\u0010\n\u001a\u00020\u000e2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011H\u0016¢\u0006\u0004\b\n\u0010\u0015J\u000f\u0010\u0016\u001a\u00020\u000eH\u0014¢\u0006\u0004\b\u0016\u0010\u0010R \u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u00190\u00178WX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001bR\u0015\u0010\u001f\u001a\u0004\u0018\u00010\u001cX\u0083\u0080\u0002¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0012\u0010!\u001a\u00020 X\u0087\"¢\u0006\u0006\n\u0004\b!\u0010\"R\u0012\u0010$\u001a\u00020#X\u0087\"¢\u0006\u0006\n\u0004\b$\u0010%R\u0016\u0010\u0014\u001a\u00020&8\u0002@\u0002X\u0083.¢\u0006\u0006\n\u0004\b'\u0010(R\u0015\u0010+\u001a\u0004\u0018\u00010)X\u0083\u0080\u0002¢\u0006\u0006\n\u0004\b*\u0010\u001e"}, d2 = {"Lid/dana/social/AddReactionBottomSheetDialog;", "Lid/dana/base/BaseBottomSheetDialogFragment;", "Lid/dana/social/contract/reaction/ReactionsContract$View;", "", "getDimAmount", "()F", "", "Lid/dana/utils/DisplayedErrorMessage;", "getShownErrorMessage", "()Ljava/lang/String;", "BuiltInFictitiousFunctionClassFactory", "", "isFullDialogHeightRequired", "()Z", "", "onDismiss", "()V", "", "Lid/dana/feeds/ui/reaction/model/ReactionModel;", "p0", "PlaceComponentResult", "(Ljava/util/List;)V", "onShow", "Lkotlin/Function1;", "Landroid/view/LayoutInflater;", "Lid/dana/databinding/BottomSheetReactionListBinding;", "getBindingInflater", "()Lkotlin/jvm/functions/Function1;", "Lid/dana/social/model/FeedModel;", "lookAheadTest", "Lkotlin/Lazy;", "KClassImpl$Data$declaredNonStaticMembers$2", "Lid/dana/feeds/ui/tracker/FriendshipAnalyticTracker;", "friendshipAnalyticTracker", "Lid/dana/feeds/ui/tracker/FriendshipAnalyticTracker;", "Lid/dana/social/contract/reaction/ReactionsContract$Presenter;", "presenter", "Lid/dana/social/contract/reaction/ReactionsContract$Presenter;", "Lid/dana/social/adapter/ReactionListAdapter;", "moveToNextValue", "Lid/dana/social/adapter/ReactionListAdapter;", "Lcom/ethanhua/skeleton/RecyclerViewSkeletonScreen;", "NetworkUserEntityData$$ExternalSyntheticLambda0", "MyBillsEntityDataFactory", "<init>", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class AddReactionBottomSheetDialog extends BaseBottomSheetDialogFragment implements ReactionsContract.View {

    /* renamed from: Companion  reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static Function1<? super ReactionResultModel, Unit> getErrorConfigVersion;
    @Inject
    public FriendshipAnalyticTracker friendshipAnalyticTracker;

    /* renamed from: moveToNextValue  reason: from kotlin metadata */
    private ReactionListAdapter PlaceComponentResult;
    @Inject
    public ReactionsContract.Presenter presenter;
    public Map<Integer, View> KClassImpl$Data$declaredNonStaticMembers$2 = new LinkedHashMap();

    /* renamed from: lookAheadTest  reason: from kotlin metadata */
    private final Lazy KClassImpl$Data$declaredNonStaticMembers$2 = LazyKt.lazy(new Function0<FeedModel>() { // from class: id.dana.social.AddReactionBottomSheetDialog$feedModel$2
        /* JADX INFO: Access modifiers changed from: package-private */
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final FeedModel invoke() {
            Bundle arguments = AddReactionBottomSheetDialog.this.getArguments();
            if (arguments != null) {
                return (FeedModel) arguments.getParcelable("ARG_FEED");
            }
            return null;
        }
    });

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda0  reason: from kotlin metadata */
    private final Lazy MyBillsEntityDataFactory = LazyKt.lazy(new Function0<RecyclerViewSkeletonScreen>() { // from class: id.dana.social.AddReactionBottomSheetDialog$skeletonShimmering$2
        /* JADX INFO: Access modifiers changed from: package-private */
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final RecyclerViewSkeletonScreen invoke() {
            RecyclerView recyclerView;
            ReactionListAdapter reactionListAdapter;
            ViewBinding viewBinding = AddReactionBottomSheetDialog.this.getViewBinding();
            ReactionListAdapter reactionListAdapter2 = null;
            BottomSheetReactionListBinding bottomSheetReactionListBinding = viewBinding instanceof BottomSheetReactionListBinding ? (BottomSheetReactionListBinding) viewBinding : null;
            if (bottomSheetReactionListBinding == null || (recyclerView = bottomSheetReactionListBinding.getAuthRequestContext) == null) {
                return null;
            }
            AddReactionBottomSheetDialog addReactionBottomSheetDialog = AddReactionBottomSheetDialog.this;
            RecyclerViewSkeletonScreen.Builder BuiltInFictitiousFunctionClassFactory = Skeleton.BuiltInFictitiousFunctionClassFactory(recyclerView);
            reactionListAdapter = addReactionBottomSheetDialog.PlaceComponentResult;
            if (reactionListAdapter == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
            } else {
                reactionListAdapter2 = reactionListAdapter;
            }
            BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2 = reactionListAdapter2;
            BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory = R.layout.viewholder_reaction_emoji_skeleton;
            BuiltInFictitiousFunctionClassFactory.NetworkUserEntityData$$ExternalSyntheticLambda0 = 2500;
            BuiltInFictitiousFunctionClassFactory.getAuthRequestContext = 30;
            BuiltInFictitiousFunctionClassFactory.PlaceComponentResult = true;
            BuiltInFictitiousFunctionClassFactory.getErrorConfigVersion = ContextCompat.BuiltInFictitiousFunctionClassFactory(BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory.getContext(), R.color.f27082131100491);
            BuiltInFictitiousFunctionClassFactory.lookAheadTest = 20;
            RecyclerViewSkeletonScreen recyclerViewSkeletonScreen = new RecyclerViewSkeletonScreen(BuiltInFictitiousFunctionClassFactory, (byte) 0);
            recyclerViewSkeletonScreen.MyBillsEntityDataFactory();
            return recyclerViewSkeletonScreen;
        }
    });

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

    @Override // id.dana.base.BaseBottomSheetDialogFragment
    /* renamed from: getBottomSheet */
    public final /* bridge */ /* synthetic */ View getPlaceComponentResult() {
        return null;
    }

    @Override // id.dana.base.BaseBottomSheetDialogFragment
    public final float getDimAmount() {
        return 0.5f;
    }

    @Override // id.dana.base.BaseBottomSheetDialogFragment
    public final boolean isFullDialogHeightRequired() {
        return false;
    }

    @Override // id.dana.base.BaseBottomSheetDialogFragment
    @JvmName(name = "getBindingInflater")
    public final Function1<LayoutInflater, BottomSheetReactionListBinding> getBindingInflater() {
        return new Function1<LayoutInflater, BottomSheetReactionListBinding>() { // from class: id.dana.social.AddReactionBottomSheetDialog$bindingInflater$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final BottomSheetReactionListBinding invoke(LayoutInflater layoutInflater) {
                Intrinsics.checkNotNullParameter(layoutInflater, "");
                BottomSheetReactionListBinding BuiltInFictitiousFunctionClassFactory = BottomSheetReactionListBinding.BuiltInFictitiousFunctionClassFactory(AddReactionBottomSheetDialog.this.getLayoutInflater());
                Intrinsics.checkNotNullExpressionValue(BuiltInFictitiousFunctionClassFactory, "");
                return BuiltInFictitiousFunctionClassFactory;
            }
        };
    }

    @Override // id.dana.base.BaseBottomSheetDialogFragment
    public final void onShow() {
        RecyclerView recyclerView;
        DanaApplication danaApplication;
        SocialCommonComponent socialCommonComponent;
        super.onShow();
        BaseActivity baseActivity = getBaseActivity();
        if (baseActivity != null && (danaApplication = baseActivity.getDanaApplication()) != null && (socialCommonComponent = danaApplication.getSocialCommonComponent()) != null) {
            socialCommonComponent.KClassImpl$Data$declaredNonStaticMembers$2(new ReactionsModule(this)).MyBillsEntityDataFactory(this);
        }
        this.PlaceComponentResult = new ReactionListAdapter(CollectionsKt.emptyList(), new Function1<ReactionModel, Unit>() { // from class: id.dana.social.AddReactionBottomSheetDialog$setupReactionListView$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(ReactionModel reactionModel) {
                invoke2(reactionModel);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(ReactionModel reactionModel) {
                Intrinsics.checkNotNullParameter(reactionModel, "");
                AddReactionBottomSheetDialog.BuiltInFictitiousFunctionClassFactory(AddReactionBottomSheetDialog.this, reactionModel);
            }
        });
        ViewBinding viewBinding = getViewBinding();
        ReactionsContract.Presenter presenter = null;
        BottomSheetReactionListBinding bottomSheetReactionListBinding = viewBinding instanceof BottomSheetReactionListBinding ? (BottomSheetReactionListBinding) viewBinding : null;
        if (bottomSheetReactionListBinding != null && (recyclerView = bottomSheetReactionListBinding.getAuthRequestContext) != null) {
            recyclerView.addItemDecoration(new DividerItemDecoration(requireContext(), (int) R.dimen.MyBillsEntityDataFactory_res_0x7f07005f, 80));
            recyclerView.setLayoutManager(new GridLayoutManager(requireContext(), 6));
            ReactionListAdapter reactionListAdapter = this.PlaceComponentResult;
            if (reactionListAdapter == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
                reactionListAdapter = null;
            }
            recyclerView.setAdapter(reactionListAdapter);
        }
        ReactionsContract.Presenter presenter2 = this.presenter;
        if (presenter2 != null) {
            presenter = presenter2;
        } else {
            Intrinsics.throwUninitializedPropertyAccessException("");
        }
        presenter.getAuthRequestContext();
        RecyclerViewSkeletonScreen recyclerViewSkeletonScreen = (RecyclerViewSkeletonScreen) this.MyBillsEntityDataFactory.getValue();
        if (recyclerViewSkeletonScreen != null) {
            recyclerViewSkeletonScreen.MyBillsEntityDataFactory();
        }
    }

    @Override // id.dana.base.BaseBottomSheetDialogFragment
    public final void onDismiss() {
        super.onDismiss();
        dismiss();
    }

    @Override // id.dana.social.contract.reaction.ReactionsContract.View
    public final void BuiltInFictitiousFunctionClassFactory(List<ReactionModel> p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        ReactionListAdapter reactionListAdapter = this.PlaceComponentResult;
        if (reactionListAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            reactionListAdapter = null;
        }
        reactionListAdapter.setItems(p0);
        RecyclerViewSkeletonScreen recyclerViewSkeletonScreen = (RecyclerViewSkeletonScreen) this.MyBillsEntityDataFactory.getValue();
        if (recyclerViewSkeletonScreen != null) {
            recyclerViewSkeletonScreen.MyBillsEntityDataFactory.setAdapter(recyclerViewSkeletonScreen.getAuthRequestContext);
        }
    }

    @Override // id.dana.social.contract.reaction.ReactionsContract.View
    public final void PlaceComponentResult(List<ReactionModel> p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        ReactionListAdapter reactionListAdapter = this.PlaceComponentResult;
        if (reactionListAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            reactionListAdapter = null;
        }
        reactionListAdapter.setItems(p0);
        RecyclerViewSkeletonScreen recyclerViewSkeletonScreen = (RecyclerViewSkeletonScreen) this.MyBillsEntityDataFactory.getValue();
        if (recyclerViewSkeletonScreen != null) {
            recyclerViewSkeletonScreen.MyBillsEntityDataFactory.setAdapter(recyclerViewSkeletonScreen.getAuthRequestContext);
        }
    }

    @Override // id.dana.base.BaseBottomSheetDialogFragment, id.dana.social.contract.reaction.ReactionsContract.View
    public final String getShownErrorMessage() {
        String shownErrorMessage = super.getShownErrorMessage();
        Intrinsics.checkNotNullExpressionValue(shownErrorMessage, "");
        return shownErrorMessage;
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0011\u0010\u0012J2\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0019\u0010\b\u001a\u0015\u0012\u000b\u0012\t\u0018\u00010\u0005¢\u0006\u0002\b\u0006\u0012\u0004\u0012\u00020\u00070\u0004H\u0007¢\u0006\u0004\b\n\u0010\u000bR3\u0010\u0010\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010\u0005¢\u0006\f\b\u0006\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u00070\u00048\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u000e\u0010\u000f"}, d2 = {"Lid/dana/social/AddReactionBottomSheetDialog$Companion;", "", "Lid/dana/social/model/FeedModel;", "p0", "Lkotlin/Function1;", "Lid/dana/social/model/ReactionResultModel;", "Lkotlin/ParameterName;", "", "p1", "Lid/dana/social/AddReactionBottomSheetDialog;", "KClassImpl$Data$declaredNonStaticMembers$2", "(Lid/dana/social/model/FeedModel;Lkotlin/jvm/functions/Function1;)Lid/dana/social/AddReactionBottomSheetDialog;", "name", "reactionResModel", "getErrorConfigVersion", "Lkotlin/jvm/functions/Function1;", "getAuthRequestContext", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public static AddReactionBottomSheetDialog KClassImpl$Data$declaredNonStaticMembers$2(FeedModel p0, Function1<? super ReactionResultModel, Unit> p1) {
            Intrinsics.checkNotNullParameter(p0, "");
            Intrinsics.checkNotNullParameter(p1, "");
            AddReactionBottomSheetDialog.getErrorConfigVersion = p1;
            AddReactionBottomSheetDialog addReactionBottomSheetDialog = new AddReactionBottomSheetDialog();
            addReactionBottomSheetDialog.setArguments(BundleKt.PlaceComponentResult(new Pair("ARG_FEED", p0)));
            return addReactionBottomSheetDialog;
        }
    }

    public static final /* synthetic */ void BuiltInFictitiousFunctionClassFactory(AddReactionBottomSheetDialog addReactionBottomSheetDialog, ReactionModel reactionModel) {
        FeedModel feedModel = (FeedModel) addReactionBottomSheetDialog.KClassImpl$Data$declaredNonStaticMembers$2.getValue();
        if (feedModel != null) {
            Function1<? super ReactionResultModel, Unit> function1 = getErrorConfigVersion;
            FriendshipAnalyticTracker friendshipAnalyticTracker = null;
            if (function1 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
                function1 = null;
            }
            function1.invoke(new ReactionResultModel(feedModel.NetworkUserEntityData$$ExternalSyntheticLambda1, reactionModel.BuiltInFictitiousFunctionClassFactory));
            ReactionsContract.Presenter presenter = addReactionBottomSheetDialog.presenter;
            if (presenter == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
                presenter = null;
            }
            String str = feedModel.BuiltInFictitiousFunctionClassFactory;
            if (str == null) {
                str = "";
            }
            presenter.MyBillsEntityDataFactory(str, reactionModel.BuiltInFictitiousFunctionClassFactory);
            FriendshipAnalyticTracker friendshipAnalyticTracker2 = addReactionBottomSheetDialog.friendshipAnalyticTracker;
            if (friendshipAnalyticTracker2 != null) {
                friendshipAnalyticTracker = friendshipAnalyticTracker2;
            } else {
                Intrinsics.throwUninitializedPropertyAccessException("");
            }
            String str2 = feedModel.PlaceComponentResult;
            friendshipAnalyticTracker.KClassImpl$Data$declaredNonStaticMembers$2(str2 != null ? str2 : "", reactionModel.KClassImpl$Data$declaredNonStaticMembers$2);
        }
        addReactionBottomSheetDialog.dismissAllowingStateLoss();
    }

    @Override // id.dana.base.BaseBottomSheetDialogFragment
    public final /* synthetic */ ViewBinding getBinding() {
        ViewBinding viewBinding = getViewBinding();
        return viewBinding instanceof BottomSheetReactionListBinding ? (BottomSheetReactionListBinding) viewBinding : null;
    }

    @Override // id.dana.base.BaseBottomSheetDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        this.KClassImpl$Data$declaredNonStaticMembers$2.clear();
    }
}
