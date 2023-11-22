package id.dana.social.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import com.ap.zoloz.hummer.biz.HummerConstants;
import com.iap.ac.config.lite.delegate.ConfigMonitor;
import id.dana.R;
import id.dana.base.viewbinding.ViewBindingRichView;
import id.dana.component.dialogcomponent.CustomDialog;
import id.dana.databinding.ViewCommentListBinding;
import id.dana.domain.qrbarcode.DecodedScanBizInfoKey;
import id.dana.feeds.ui.model.AddActivityCommentModel;
import id.dana.feeds.ui.model.FeedCommentModel;
import id.dana.feeds.ui.model.RelationshipItemModel;
import id.dana.feeds.ui.state.FeedCommentModelState;
import id.dana.lib.gcontainer.app.bridge.logging.H5GetLogInfoBridge;
import id.dana.social.model.FeedCommentResultModel;
import id.dana.social.state.ViewHolderState;
import id.dana.social.utils.SocialScrollListener;
import id.dana.social.view.activity.detail.FeedCommentAdapter;
import id.dana.social.view.activity.detail.FeedCommentInteraction;
import id.dana.social.view.activity.detail.FeedCommentViewHolder;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010R\u001a\u00020Q¢\u0006\u0004\bS\u0010TB\u001b\b\u0016\u0012\u0006\u0010R\u001a\u00020Q\u0012\b\u0010V\u001a\u0004\u0018\u00010U¢\u0006\u0004\bS\u0010WJ\u001d\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\b\u0010\tJ\u0015\u0010\u000b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u0005¢\u0006\u0004\b\u000b\u0010\fJ\u001d\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\u0005¢\u0006\u0004\b\u000f\u0010\u0010J\r\u0010\u0011\u001a\u00020\u0003¢\u0006\u0004\b\u0011\u0010\u0012J\u0019\u0010\u0015\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0013\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0017\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u0017\u0010\u001b\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u0019H\u0014¢\u0006\u0004\b\u001b\u0010\u001cJ\u0015\u0010\u001e\u001a\u00020\u00072\u0006\u0010\u001d\u001a\u00020\r¢\u0006\u0004\b\u001e\u0010\u001fJ\u0015\u0010!\u001a\u00020\u00072\u0006\u0010 \u001a\u00020\r¢\u0006\u0004\b!\u0010\u001fJ\u000f\u0010#\u001a\u00020\"H\u0002¢\u0006\u0004\b#\u0010$J\r\u0010%\u001a\u00020\u0007¢\u0006\u0004\b%\u0010&J\u0015\u0010)\u001a\u00020\u00072\u0006\u0010(\u001a\u00020'¢\u0006\u0004\b)\u0010*J#\u0010-\u001a\u00020\u00072\f\u0010,\u001a\b\u0012\u0004\u0012\u00020\r0+2\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b-\u0010.J\u0015\u0010/\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u0005¢\u0006\u0004\b/\u0010\fJ\r\u00100\u001a\u00020\u0007¢\u0006\u0004\b0\u0010&J\r\u00101\u001a\u00020\u0007¢\u0006\u0004\b1\u0010&J\u000f\u00102\u001a\u00020\u0007H\u0002¢\u0006\u0004\b2\u0010&J\u0015\u00104\u001a\u00020\u00072\u0006\u00103\u001a\u00020\u0003¢\u0006\u0004\b4\u00105J\r\u00106\u001a\u00020\u0007¢\u0006\u0004\b6\u0010&J+\u0010:\u001a\u00020\u00072\u0006\u0010(\u001a\u00020\r2\n\b\u0002\u00108\u001a\u0004\u0018\u0001072\b\b\u0002\u00109\u001a\u00020\"¢\u0006\u0004\b:\u0010;R\"\u0010=\u001a\u00020<8\u0007@\u0007X\u0086.¢\u0006\u0012\n\u0004\b=\u0010>\u001a\u0004\b?\u0010@\"\u0004\bA\u0010BR$\u0010J\u001a\u0004\u0018\u00010C8\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\bD\u0010E\u001a\u0004\bF\u0010G\"\u0004\bH\u0010IR\"\u0010L\u001a\u00020\"8\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010K\u001a\u0004\bL\u0010$\"\u0004\bM\u0010NR\"\u0010O\u001a\u00020\"8\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b#\u0010K\u001a\u0004\bO\u0010$\"\u0004\bP\u0010N"}, d2 = {"Lid/dana/social/view/CommentListView;", "Lid/dana/base/viewbinding/ViewBindingRichView;", "Lid/dana/databinding/ViewCommentListBinding;", "", "parentCommentId", "", "numberOfReportedComments", "", "adjustReplyCount", "(Ljava/lang/String;I)V", "position", "deleteComment", "(I)V", "Lid/dana/feeds/ui/model/FeedCommentModel;", H5GetLogInfoBridge.RESULT_MODEL, "deleteReply", "(Lid/dana/feeds/ui/model/FeedCommentModel;I)V", "getErrorMessageWhenEmpty", "()Ljava/lang/String;", "p0", "Lid/dana/social/view/activity/detail/FeedCommentViewHolder;", "PlaceComponentResult", "(I)Lid/dana/social/view/activity/detail/FeedCommentViewHolder;", "getLayout", "()I", "Landroid/view/View;", "view", "initViewBinding", "(Landroid/view/View;)Lid/dana/databinding/ViewCommentListBinding;", DecodedScanBizInfoKey.COMMENT, "insertComment", "(Lid/dana/feeds/ui/model/FeedCommentModel;)V", "subComment", "insertReply", "", "KClassImpl$Data$declaredNonStaticMembers$2", "()Z", "onErrorGetFeedComment", "()V", "Lid/dana/social/model/FeedCommentResultModel;", "feedCommentModel", "onGetFeedComment", "(Lid/dana/social/model/FeedCommentResultModel;)V", "", "subComments", "onGetFeedSubComment", "(Ljava/util/List;I)V", "removeItem", "resetItems", "setupFeedCommentList", "getAuthRequestContext", "commentId", "showDim", "(Ljava/lang/String;)V", "showShimmer", "Lid/dana/feeds/ui/model/AddActivityCommentModel;", "addActivityCommentModel", ConfigMonitor.Keywords.KEY_WORD_IS_RETRY, "updateCommentState", "(Lid/dana/feeds/ui/model/FeedCommentModel;Lid/dana/feeds/ui/model/AddActivityCommentModel;Z)V", "Lid/dana/social/view/activity/detail/FeedCommentAdapter;", "adapter", "Lid/dana/social/view/activity/detail/FeedCommentAdapter;", "getAdapter", "()Lid/dana/social/view/activity/detail/FeedCommentAdapter;", "setAdapter", "(Lid/dana/social/view/activity/detail/FeedCommentAdapter;)V", "Lid/dana/social/view/CommentListInteraction;", "MyBillsEntityDataFactory", "Lid/dana/social/view/CommentListInteraction;", "getCommentListInteraction", "()Lid/dana/social/view/CommentListInteraction;", "setCommentListInteraction", "(Lid/dana/social/view/CommentListInteraction;)V", "commentListInteraction", "Z", "isFeedRevamp", "setFeedRevamp", "(Z)V", "isReplyCommentEnabled", "setReplyCommentEnabled", "Landroid/content/Context;", HummerConstants.CONTEXT, "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class CommentListView extends ViewBindingRichView<ViewCommentListBinding> {

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    private boolean isReplyCommentEnabled;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private CommentListInteraction commentListInteraction;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private boolean isFeedRevamp;
    public Map<Integer, View> _$_findViewCache;
    public FeedCommentAdapter adapter;

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
        return R.layout.view_comment_list;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CommentListView(Context context) {
        super(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "");
        this._$_findViewCache = new LinkedHashMap();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CommentListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "");
        this._$_findViewCache = new LinkedHashMap();
    }

    @JvmName(name = "getAdapter")
    public final FeedCommentAdapter getAdapter() {
        FeedCommentAdapter feedCommentAdapter = this.adapter;
        if (feedCommentAdapter != null) {
            return feedCommentAdapter;
        }
        Intrinsics.throwUninitializedPropertyAccessException("");
        return null;
    }

    @JvmName(name = "setAdapter")
    public final void setAdapter(FeedCommentAdapter feedCommentAdapter) {
        Intrinsics.checkNotNullParameter(feedCommentAdapter, "");
        this.adapter = feedCommentAdapter;
    }

    @JvmName(name = "isFeedRevamp")
    /* renamed from: isFeedRevamp  reason: from getter */
    public final boolean getIsFeedRevamp() {
        return this.isFeedRevamp;
    }

    @JvmName(name = "setFeedRevamp")
    public final void setFeedRevamp(boolean z) {
        this.isFeedRevamp = z;
    }

    @JvmName(name = "getCommentListInteraction")
    public final CommentListInteraction getCommentListInteraction() {
        return this.commentListInteraction;
    }

    @JvmName(name = "setCommentListInteraction")
    public final void setCommentListInteraction(CommentListInteraction commentListInteraction) {
        this.commentListInteraction = commentListInteraction;
    }

    @JvmName(name = "isReplyCommentEnabled")
    /* renamed from: isReplyCommentEnabled  reason: from getter */
    public final boolean getIsReplyCommentEnabled() {
        return this.isReplyCommentEnabled;
    }

    @JvmName(name = "setReplyCommentEnabled")
    public final void setReplyCommentEnabled(boolean z) {
        this.isReplyCommentEnabled = z;
    }

    @Override // id.dana.base.viewbinding.ViewBindingRichView
    public final ViewCommentListBinding initViewBinding(View view) {
        Intrinsics.checkNotNullParameter(view, "");
        ViewCommentListBinding BuiltInFictitiousFunctionClassFactory = ViewCommentListBinding.BuiltInFictitiousFunctionClassFactory(view);
        Intrinsics.checkNotNullExpressionValue(BuiltInFictitiousFunctionClassFactory, "");
        return BuiltInFictitiousFunctionClassFactory;
    }

    public final void setupFeedCommentList() {
        RecyclerView recyclerView = getBinding().getAuthRequestContext;
        final RecyclerView recyclerView2 = getBinding().getAuthRequestContext;
        recyclerView.addOnScrollListener(new SocialScrollListener(recyclerView2) { // from class: id.dana.social.view.CommentListView$setupFeedCommentList$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(recyclerView2);
                Intrinsics.checkNotNullExpressionValue(recyclerView2, "");
            }

            @Override // id.dana.social.utils.SocialScrollListener
            public final void MyBillsEntityDataFactory(boolean p0) {
                ViewCommentListBinding binding;
                binding = CommentListView.this.getBinding();
                CardView cardView = binding.KClassImpl$Data$declaredNonStaticMembers$2.BuiltInFictitiousFunctionClassFactory;
                Intrinsics.checkNotNullExpressionValue(cardView, "");
                cardView.setVisibility(p0 ? 0 : 8);
            }

            @Override // id.dana.social.utils.SocialScrollListener
            public final boolean getAuthRequestContext() {
                CommentListInteraction commentListInteraction = CommentListView.this.getCommentListInteraction();
                if (commentListInteraction != null) {
                    return commentListInteraction.MyBillsEntityDataFactory();
                }
                return false;
            }

            @Override // id.dana.social.utils.SocialScrollListener
            public final void KClassImpl$Data$declaredNonStaticMembers$2() {
                CommentListInteraction commentListInteraction;
                if (CommentListView.this.getAdapter().MyBillsEntityDataFactory() || (commentListInteraction = CommentListView.this.getCommentListInteraction()) == null) {
                    return;
                }
                commentListInteraction.KClassImpl$Data$declaredNonStaticMembers$2();
            }
        });
        setAdapter(new FeedCommentAdapter(KClassImpl$Data$declaredNonStaticMembers$2(), this.isFeedRevamp, this.isReplyCommentEnabled, new FeedCommentInteraction() { // from class: id.dana.social.view.CommentListView$setupFeedCommentList$2
            @Override // id.dana.social.view.activity.detail.FeedCommentInteraction
            public final boolean PlaceComponentResult() {
                CommentListInteraction commentListInteraction = CommentListView.this.getCommentListInteraction();
                if (commentListInteraction != null) {
                    return commentListInteraction.PlaceComponentResult();
                }
                return false;
            }

            @Override // id.dana.social.view.activity.detail.FeedCommentInteraction
            public final void BuiltInFictitiousFunctionClassFactory(int p0, FeedCommentModel p1) {
                Intrinsics.checkNotNullParameter(p1, "");
                CommentListInteraction commentListInteraction = CommentListView.this.getCommentListInteraction();
                if (commentListInteraction != null) {
                    commentListInteraction.MyBillsEntityDataFactory(p1, p0);
                }
            }

            @Override // id.dana.social.view.activity.detail.FeedCommentInteraction
            public final void getAuthRequestContext() {
                FeedCommentAdapter adapter = CommentListView.this.getAdapter();
                if (!adapter.PlaceComponentResult() && adapter.MyBillsEntityDataFactory()) {
                    adapter.removeItem(adapter.getPlaceComponentResult() - 1);
                }
                CommentListInteraction commentListInteraction = CommentListView.this.getCommentListInteraction();
                if (commentListInteraction != null) {
                    commentListInteraction.KClassImpl$Data$declaredNonStaticMembers$2();
                }
            }

            @Override // id.dana.social.view.activity.detail.FeedCommentInteraction
            public final void KClassImpl$Data$declaredNonStaticMembers$2(FeedCommentModel p0) {
                Intrinsics.checkNotNullParameter(p0, "");
                CommentListView.updateCommentState$default(CommentListView.this, p0, null, true, 2, null);
            }

            @Override // id.dana.social.view.activity.detail.FeedCommentInteraction
            public final void PlaceComponentResult(FeedCommentModel p0) {
                Intrinsics.checkNotNullParameter(p0, "");
                CommentListInteraction commentListInteraction = CommentListView.this.getCommentListInteraction();
                if (commentListInteraction != null) {
                    RelationshipItemModel.Companion companion = RelationshipItemModel.INSTANCE;
                    commentListInteraction.PlaceComponentResult(RelationshipItemModel.Companion.getAuthRequestContext(p0.NetworkUserEntityData$$ExternalSyntheticLambda2));
                }
            }

            @Override // id.dana.social.view.activity.detail.FeedCommentInteraction
            public final void getAuthRequestContext(FeedCommentModel p0) {
                Intrinsics.checkNotNullParameter(p0, "");
                CommentListInteraction commentListInteraction = CommentListView.this.getCommentListInteraction();
                if (commentListInteraction != null) {
                    commentListInteraction.getAuthRequestContext(p0);
                }
            }

            @Override // id.dana.social.view.activity.detail.FeedCommentInteraction
            public final void KClassImpl$Data$declaredNonStaticMembers$2(int p0, FeedCommentModel p1) {
                Intrinsics.checkNotNullParameter(p1, "");
                CommentListView.access$showPopUpConfirmationDeleteComment(CommentListView.this, p0, p1);
            }

            @Override // id.dana.social.view.activity.detail.FeedCommentInteraction
            public final void KClassImpl$Data$declaredNonStaticMembers$2(String p0) {
                Intrinsics.checkNotNullParameter(p0, "");
                CommentListInteraction commentListInteraction = CommentListView.this.getCommentListInteraction();
                if (commentListInteraction != null) {
                    commentListInteraction.getAuthRequestContext(p0);
                }
            }
        }));
        getBinding().getAuthRequestContext.setAdapter(getAdapter());
        getBinding().KClassImpl$Data$declaredNonStaticMembers$2.BuiltInFictitiousFunctionClassFactory.setOnClickListener(new View.OnClickListener() { // from class: id.dana.social.view.CommentListView$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CommentListView.$r8$lambda$7Q3YojrUkt_zq_PA5XPPj60_zyw(CommentListView.this, view);
            }
        });
    }

    private final boolean KClassImpl$Data$declaredNonStaticMembers$2() {
        CommentListInteraction commentListInteraction = this.commentListInteraction;
        if (commentListInteraction != null) {
            return commentListInteraction.PlaceComponentResult();
        }
        return false;
    }

    private final void getAuthRequestContext() {
        RecyclerView recyclerView = getBinding().getAuthRequestContext;
        Intrinsics.checkNotNullExpressionValue(recyclerView, "");
        recyclerView.setVisibility(0);
        getBinding().getAuthRequestContext.setNestedScrollingEnabled(true);
        CardView cardView = getBinding().KClassImpl$Data$declaredNonStaticMembers$2.BuiltInFictitiousFunctionClassFactory;
        Intrinsics.checkNotNullExpressionValue(cardView, "");
        cardView.setVisibility(0);
    }

    public final void insertComment(FeedCommentModel r3) {
        Intrinsics.checkNotNullParameter(r3, "");
        getAuthRequestContext();
        getAdapter().getAuthRequestContext(new ViewHolderState.Item(r3));
        getBinding().getAuthRequestContext.smoothScrollToPosition(0);
    }

    public final void insertReply(FeedCommentModel subComment) {
        Intrinsics.checkNotNullParameter(subComment, "");
        int BuiltInFictitiousFunctionClassFactory = getAdapter().BuiltInFictitiousFunctionClassFactory(subComment);
        ViewHolderState viewHolderState = (ViewHolderState) getAdapter().getItems().get(BuiltInFictitiousFunctionClassFactory);
        if (viewHolderState != null) {
            ViewHolderState.Item item = (ViewHolderState.Item) viewHolderState;
            ((FeedCommentModel) item.BuiltInFictitiousFunctionClassFactory).NetworkUserEntityData$$ExternalSyntheticLambda0++;
            ((FeedCommentModel) item.BuiltInFictitiousFunctionClassFactory).lookAheadTest.add(0, subComment);
            FeedCommentViewHolder PlaceComponentResult = PlaceComponentResult(BuiltInFictitiousFunctionClassFactory);
            if (PlaceComponentResult != null) {
                Intrinsics.checkNotNullParameter(subComment, "");
                FeedCommentView feedCommentView = (FeedCommentView) PlaceComponentResult.itemView.findViewById(R.id.feed_comment_view);
                if (feedCommentView != null) {
                    feedCommentView.prependNewReply(subComment);
                    return;
                }
                return;
            }
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type id.dana.social.state.ViewHolderState.Item<id.dana.feeds.ui.model.FeedCommentModel>");
    }

    public static /* synthetic */ void updateCommentState$default(CommentListView commentListView, FeedCommentModel feedCommentModel, AddActivityCommentModel addActivityCommentModel, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            addActivityCommentModel = null;
        }
        if ((i & 4) != 0) {
            z = false;
        }
        commentListView.updateCommentState(feedCommentModel, addActivityCommentModel, z);
    }

    public final void updateCommentState(FeedCommentModel feedCommentModel, AddActivityCommentModel addActivityCommentModel, boolean r11) {
        Object obj;
        FeedCommentModel feedCommentModel2;
        FeedCommentModelState feedCommentModelState;
        CommentListInteraction commentListInteraction;
        Object obj2;
        FeedCommentModel feedCommentModel3;
        Object obj3;
        FeedCommentModelState feedCommentModelState2;
        Intrinsics.checkNotNullParameter(feedCommentModel, "");
        getAuthRequestContext();
        int i = 0;
        FeedCommentModel feedCommentModel4 = null;
        if (!feedCommentModel.MyBillsEntityDataFactory()) {
            FeedCommentAdapter adapter = getAdapter();
            Intrinsics.checkNotNullParameter(feedCommentModel, "");
            Iterable items = adapter.getItems();
            Intrinsics.checkNotNullExpressionValue(items, "");
            Iterator it = items.iterator();
            while (true) {
                if (!it.hasNext()) {
                    obj = null;
                    break;
                }
                obj = it.next();
                if (Intrinsics.areEqual((ViewHolderState) obj, new ViewHolderState.Item(feedCommentModel))) {
                    break;
                }
            }
            ViewHolderState.Item item = obj instanceof ViewHolderState.Item ? (ViewHolderState.Item) obj : null;
            if (item != null && (feedCommentModel2 = (FeedCommentModel) item.BuiltInFictitiousFunctionClassFactory) != null) {
                i = adapter.getItems().indexOf(new ViewHolderState.Item(feedCommentModel2));
                if (addActivityCommentModel == null) {
                    if (r11) {
                        feedCommentModelState = FeedCommentModelState.SENDING;
                    } else {
                        feedCommentModelState = FeedCommentModelState.FAILED;
                    }
                    Intrinsics.checkNotNullParameter(feedCommentModelState, "");
                    feedCommentModel2.NetworkUserEntityData$$ExternalSyntheticLambda1 = feedCommentModelState;
                } else {
                    String str = addActivityCommentModel.PlaceComponentResult;
                    Intrinsics.checkNotNullParameter(str, "");
                    feedCommentModel2.BuiltInFictitiousFunctionClassFactory = str;
                    String str2 = addActivityCommentModel.KClassImpl$Data$declaredNonStaticMembers$2;
                    Intrinsics.checkNotNullParameter(str2, "");
                    feedCommentModel2.KClassImpl$Data$declaredNonStaticMembers$2 = str2;
                    FeedCommentModelState feedCommentModelState3 = FeedCommentModelState.SUCCESS;
                    Intrinsics.checkNotNullParameter(feedCommentModelState3, "");
                    feedCommentModel2.NetworkUserEntityData$$ExternalSyntheticLambda1 = feedCommentModelState3;
                }
                feedCommentModel4 = feedCommentModel2;
            }
            adapter.notifyItemChanged(i, feedCommentModel4);
        } else {
            FeedCommentAdapter adapter2 = getAdapter();
            Intrinsics.checkNotNullParameter(feedCommentModel, "");
            Iterable items2 = adapter2.getItems();
            Intrinsics.checkNotNullExpressionValue(items2, "");
            ArrayList arrayList = new ArrayList();
            for (Object obj4 : items2) {
                if (obj4 instanceof ViewHolderState.Item) {
                    arrayList.add(obj4);
                }
            }
            Iterator it2 = arrayList.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    obj2 = null;
                    break;
                }
                obj2 = it2.next();
                if (Intrinsics.areEqual(((FeedCommentModel) ((ViewHolderState.Item) obj2).BuiltInFictitiousFunctionClassFactory).BuiltInFictitiousFunctionClassFactory, feedCommentModel.moveToNextValue)) {
                    break;
                }
            }
            ViewHolderState.Item item2 = (ViewHolderState.Item) obj2;
            if (item2 != null && (feedCommentModel3 = (FeedCommentModel) item2.BuiltInFictitiousFunctionClassFactory) != null) {
                i = adapter2.getItems().indexOf(new ViewHolderState.Item(feedCommentModel3));
                Iterator<T> it3 = feedCommentModel3.lookAheadTest.iterator();
                while (true) {
                    if (!it3.hasNext()) {
                        obj3 = null;
                        break;
                    }
                    obj3 = it3.next();
                    if (Intrinsics.areEqual(((FeedCommentModel) obj3).BuiltInFictitiousFunctionClassFactory, feedCommentModel.BuiltInFictitiousFunctionClassFactory)) {
                        break;
                    }
                }
                FeedCommentModel feedCommentModel5 = (FeedCommentModel) obj3;
                if (feedCommentModel5 != null) {
                    if (addActivityCommentModel == null) {
                        if (r11) {
                            feedCommentModelState2 = FeedCommentModelState.SENDING;
                        } else {
                            feedCommentModelState2 = FeedCommentModelState.FAILED;
                        }
                        Intrinsics.checkNotNullParameter(feedCommentModelState2, "");
                        feedCommentModel5.NetworkUserEntityData$$ExternalSyntheticLambda1 = feedCommentModelState2;
                    } else {
                        String str3 = addActivityCommentModel.PlaceComponentResult;
                        Intrinsics.checkNotNullParameter(str3, "");
                        feedCommentModel5.BuiltInFictitiousFunctionClassFactory = str3;
                        String str4 = addActivityCommentModel.KClassImpl$Data$declaredNonStaticMembers$2;
                        Intrinsics.checkNotNullParameter(str4, "");
                        feedCommentModel5.KClassImpl$Data$declaredNonStaticMembers$2 = str4;
                        FeedCommentModelState feedCommentModelState4 = FeedCommentModelState.SUCCESS;
                        Intrinsics.checkNotNullParameter(feedCommentModelState4, "");
                        feedCommentModel5.NetworkUserEntityData$$ExternalSyntheticLambda1 = feedCommentModelState4;
                    }
                    feedCommentModel4 = feedCommentModel5;
                }
            }
            adapter2.notifyItemChanged(i, feedCommentModel4);
        }
        if (!r11 || feedCommentModel4 == null || (commentListInteraction = this.commentListInteraction) == null) {
            return;
        }
        commentListInteraction.PlaceComponentResult(feedCommentModel4);
    }

    public final void onGetFeedComment(FeedCommentResultModel feedCommentModel) {
        Intrinsics.checkNotNullParameter(feedCommentModel, "");
        getAuthRequestContext();
        if (feedCommentModel.PlaceComponentResult.isEmpty()) {
            getAdapter().KClassImpl$Data$declaredNonStaticMembers$2();
            RecyclerView recyclerView = getBinding().getAuthRequestContext;
            Intrinsics.checkNotNullExpressionValue(recyclerView, "");
            recyclerView.setVisibility(0);
            getBinding().getAuthRequestContext.setNestedScrollingEnabled(false);
            CardView cardView = getBinding().KClassImpl$Data$declaredNonStaticMembers$2.BuiltInFictitiousFunctionClassFactory;
            Intrinsics.checkNotNullExpressionValue(cardView, "");
            cardView.setVisibility(8);
            return;
        }
        List<ViewHolderState.Item<FeedCommentModel>> list = feedCommentModel.PlaceComponentResult;
        getAuthRequestContext();
        getAdapter().appendItems(list);
    }

    public final void onErrorGetFeedComment() {
        getAuthRequestContext();
        if (getAdapter().NetworkUserEntityData$$ExternalSyntheticLambda0() || getAdapter().moveToNextValue()) {
            getAdapter().KClassImpl$Data$declaredNonStaticMembers$2();
        } else {
            getAdapter().getAuthRequestContext();
        }
    }

    public final void onGetFeedSubComment(final List<FeedCommentModel> subComments, final int numberOfReportedComments) {
        Intrinsics.checkNotNullParameter(subComments, "");
        FeedCommentAdapter adapter = getAdapter();
        Intrinsics.checkNotNullParameter(subComments, "");
        adapter.MyBillsEntityDataFactory(((FeedCommentModel) CollectionsKt.first((List) subComments)).moveToNextValue, new Function1<FeedCommentModel, Unit>() { // from class: id.dana.social.view.activity.detail.FeedCommentAdapter$insertRepliesToComment$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(FeedCommentModel feedCommentModel) {
                invoke2(feedCommentModel);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(FeedCommentModel feedCommentModel) {
                Intrinsics.checkNotNullParameter(feedCommentModel, "");
                feedCommentModel.lookAheadTest.addAll(subComments);
                List<FeedCommentModel> list = feedCommentModel.lookAheadTest;
                HashSet hashSet = new HashSet();
                ArrayList arrayList = new ArrayList();
                for (Object obj : list) {
                    if (hashSet.add(((FeedCommentModel) obj).BuiltInFictitiousFunctionClassFactory)) {
                        arrayList.add(obj);
                    }
                }
                List<FeedCommentModel> mutableList = CollectionsKt.toMutableList((Collection) arrayList);
                Intrinsics.checkNotNullParameter(mutableList, "");
                feedCommentModel.lookAheadTest = mutableList;
                feedCommentModel.NetworkUserEntityData$$ExternalSyntheticLambda0 -= numberOfReportedComments;
            }
        });
    }

    public final void adjustReplyCount(String parentCommentId, final int numberOfReportedComments) {
        Intrinsics.checkNotNullParameter(parentCommentId, "");
        FeedCommentAdapter adapter = getAdapter();
        Intrinsics.checkNotNullParameter(parentCommentId, "");
        adapter.MyBillsEntityDataFactory(parentCommentId, new Function1<FeedCommentModel, Unit>() { // from class: id.dana.social.view.activity.detail.FeedCommentAdapter$adjustReplyCounts$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(FeedCommentModel feedCommentModel) {
                invoke2(feedCommentModel);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(FeedCommentModel feedCommentModel) {
                Intrinsics.checkNotNullParameter(feedCommentModel, "");
                feedCommentModel.NetworkUserEntityData$$ExternalSyntheticLambda0 -= numberOfReportedComments;
                feedCommentModel.scheduleImpl -= numberOfReportedComments;
            }
        });
    }

    public final void resetItems() {
        getAuthRequestContext();
        getAdapter().setItems(new ArrayList());
    }

    public final void showShimmer() {
        getAdapter().getErrorConfigVersion();
    }

    public final void removeItem(int position) {
        getAdapter().removeItem(position);
    }

    public final void showDim(String commentId) {
        Object obj;
        FeedCommentModel feedCommentModel;
        Intrinsics.checkNotNullParameter(commentId, "");
        int i = 0;
        if (commentId.length() > 0) {
            FeedCommentAdapter adapter = getAdapter();
            Intrinsics.checkNotNullParameter(commentId, "");
            if (adapter.BuiltInFictitiousFunctionClassFactory()) {
                Iterable items = adapter.getItems();
                Intrinsics.checkNotNullExpressionValue(items, "");
                ArrayList arrayList = new ArrayList();
                for (Object obj2 : items) {
                    if (obj2 instanceof ViewHolderState.Item) {
                        arrayList.add(obj2);
                    }
                }
                Iterator it = arrayList.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        obj = null;
                        break;
                    }
                    obj = it.next();
                    if (Intrinsics.areEqual(((FeedCommentModel) ((ViewHolderState.Item) obj).BuiltInFictitiousFunctionClassFactory).BuiltInFictitiousFunctionClassFactory, commentId)) {
                        break;
                    }
                }
                ViewHolderState.Item item = (ViewHolderState.Item) obj;
                if (item != null && (feedCommentModel = (FeedCommentModel) item.BuiltInFictitiousFunctionClassFactory) != null) {
                    i = adapter.getItems().indexOf(new ViewHolderState.Item(feedCommentModel));
                    FeedCommentModelState feedCommentModelState = FeedCommentModelState.DIM;
                    Intrinsics.checkNotNullParameter(feedCommentModelState, "");
                    feedCommentModel.NetworkUserEntityData$$ExternalSyntheticLambda1 = feedCommentModelState;
                    adapter.notifyItemChanged(i, feedCommentModel);
                }
            }
            getBinding().getAuthRequestContext.smoothScrollToPosition(i);
        }
    }

    public final void deleteComment(int position) {
        if (position != -1) {
            getAdapter().removeItem(position);
        }
    }

    public final void deleteReply(FeedCommentModel r3, int position) {
        Intrinsics.checkNotNullParameter(r3, "");
        FeedCommentViewHolder PlaceComponentResult = PlaceComponentResult(getAdapter().BuiltInFictitiousFunctionClassFactory(r3));
        if (PlaceComponentResult != null) {
            String str = r3.BuiltInFictitiousFunctionClassFactory;
            Intrinsics.checkNotNullParameter(str, "");
            FeedCommentView feedCommentView = (FeedCommentView) PlaceComponentResult.itemView.findViewById(R.id.feed_comment_view);
            if (feedCommentView != null) {
                feedCommentView.deleteReply(position, str);
            }
        }
    }

    private final FeedCommentViewHolder PlaceComponentResult(int p0) {
        if (p0 != -1) {
            RecyclerView.ViewHolder findViewHolderForAdapterPosition = getBinding().getAuthRequestContext.findViewHolderForAdapterPosition(p0);
            if (findViewHolderForAdapterPosition instanceof FeedCommentViewHolder) {
                return (FeedCommentViewHolder) findViewHolderForAdapterPosition;
            }
            return null;
        }
        return null;
    }

    public final String getErrorMessageWhenEmpty() {
        String string = getContext().getString(R.string.empty_state_desc_first_comment);
        Intrinsics.checkNotNullExpressionValue(string, "");
        return string;
    }

    public static /* synthetic */ void $r8$lambda$7Q3YojrUkt_zq_PA5XPPj60_zyw(CommentListView commentListView, View view) {
        RecyclerView.LayoutManager layoutManager;
        Intrinsics.checkNotNullParameter(commentListView, "");
        if (commentListView.getAdapter().getPlaceComponentResult() != 0 && (layoutManager = commentListView.getBinding().getAuthRequestContext.getLayoutManager()) != null) {
            layoutManager.smoothScrollToPosition(commentListView.getBinding().getAuthRequestContext, new RecyclerView.State(), 0);
        }
        CardView cardView = commentListView.getBinding().KClassImpl$Data$declaredNonStaticMembers$2.BuiltInFictitiousFunctionClassFactory;
        Intrinsics.checkNotNullExpressionValue(cardView, "");
        cardView.setVisibility(8);
    }

    public static final /* synthetic */ void access$showPopUpConfirmationDeleteComment(final CommentListView commentListView, final int i, final FeedCommentModel feedCommentModel) {
        Context context = commentListView.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "");
        CustomDialog.Builder builder = new CustomDialog.Builder(context);
        builder.SubSequence = commentListView.getContext().getString(R.string.feed_popup_title_delete_comment);
        builder.GetContactSyncConfig = commentListView.getContext().getString(R.string.feed_popup_desc_delete_comment);
        String string = commentListView.getContext().getString(R.string.button_delete);
        Intrinsics.checkNotNullExpressionValue(string, "");
        String upperCase = string.toUpperCase();
        Intrinsics.checkNotNullExpressionValue(upperCase, "");
        CustomDialog.Builder BuiltInFictitiousFunctionClassFactory = builder.BuiltInFictitiousFunctionClassFactory(upperCase, new Function1<View, Unit>() { // from class: id.dana.social.view.CommentListView$showPopUpConfirmationDeleteComment$1
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
                CommentListInteraction commentListInteraction = CommentListView.this.getCommentListInteraction();
                if (commentListInteraction != null) {
                    commentListInteraction.KClassImpl$Data$declaredNonStaticMembers$2(feedCommentModel);
                }
                if (feedCommentModel.MyBillsEntityDataFactory()) {
                    CommentListView.this.deleteReply(feedCommentModel, i);
                } else {
                    CommentListView.this.deleteComment(i);
                }
            }
        });
        String string2 = commentListView.getContext().getString(R.string.option_cancel);
        Intrinsics.checkNotNullExpressionValue(string2, "");
        String upperCase2 = string2.toUpperCase();
        Intrinsics.checkNotNullExpressionValue(upperCase2, "");
        BuiltInFictitiousFunctionClassFactory.NetworkUserEntityData$$ExternalSyntheticLambda7 = upperCase2;
        BuiltInFictitiousFunctionClassFactory.NetworkUserEntityData$$ExternalSyntheticLambda8 = null;
        BuiltInFictitiousFunctionClassFactory.PlaceComponentResult(true).BuiltInFictitiousFunctionClassFactory().show();
    }
}
