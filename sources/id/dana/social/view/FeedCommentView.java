package id.dana.social.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.TransitionDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.core.content.res.ResourcesCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.ap.zoloz.hummer.biz.HummerConstants;
import de.hdodenhof.circleimageview.CircleImageView;
import id.dana.R;
import id.dana.base.viewbinding.ViewBindingRichView;
import id.dana.databinding.ViewFeedCommentBinding;
import id.dana.databinding.ViewSeeMoreFeedCommentBinding;
import id.dana.feeds.ui.model.FeedCommentModel;
import id.dana.social.extension.SocialFeedExtKt;
import id.dana.social.state.ViewHolderState;
import id.dana.social.utils.FeedUtils;
import id.dana.social.view.activity.detail.FeedCommentAdapter;
import id.dana.social.view.activity.detail.FeedCommentInteraction;
import id.dana.utils.SizeUtil;
import java.util.ArrayList;
import java.util.Date;
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
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 H2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001HB\u0011\b\u0016\u0012\u0006\u0010B\u001a\u00020A¢\u0006\u0004\bC\u0010DB\u001b\b\u0016\u0012\u0006\u0010B\u001a\u00020A\u0012\b\u0010F\u001a\u0004\u0018\u00010E¢\u0006\u0004\bC\u0010GJ\u0015\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u001d\u0010\f\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\bH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u0012H\u0014¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0016\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0016\u0010\u000fJ\u0015\u0010\u0018\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\u0003¢\u0006\u0004\b\u0018\u0010\u0007J\r\u0010\u0019\u001a\u00020\u0005¢\u0006\u0004\b\u0019\u0010\u000fJ\u0015\u0010\u001c\u001a\u00020\u00052\u0006\u0010\u001b\u001a\u00020\u001a¢\u0006\u0004\b\u001c\u0010\u001dJ\r\u0010\u001e\u001a\u00020\u0005¢\u0006\u0004\b\u001e\u0010\u000fJ\u0015\u0010\u001f\u001a\u00020\u00052\u0006\u0010\u001b\u001a\u00020\u001a¢\u0006\u0004\b\u001f\u0010\u001dJ\r\u0010 \u001a\u00020\u0005¢\u0006\u0004\b \u0010\u000fJ!\u0010#\u001a\u00020\u00052\u0012\u0010\"\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00050!¢\u0006\u0004\b#\u0010$J!\u0010'\u001a\u00020\u00052\u0006\u0010%\u001a\u00020\n2\b\b\u0002\u0010&\u001a\u00020\u001aH\u0002¢\u0006\u0004\b'\u0010(J\r\u0010)\u001a\u00020\u0005¢\u0006\u0004\b)\u0010\u000fJ\u000f\u0010*\u001a\u00020\u0005H\u0002¢\u0006\u0004\b*\u0010\u000fJ\u0017\u0010+\u001a\u00020\u00052\u0006\u0010%\u001a\u00020\u001aH\u0002¢\u0006\u0004\b+\u0010\u001dJ\u000f\u0010+\u001a\u00020\u0005H\u0002¢\u0006\u0004\b+\u0010\u000fR$\u00102\u001a\u0004\u0018\u00010,8\u0007@\u0007X\u0086\u000e¢\u0006\u0012\n\u0004\b*\u0010-\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R\u0018\u0010\u0016\u001a\u0004\u0018\u00010\u00038\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b'\u00103R\u0014\u0010*\u001a\u0002048\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b+\u00105R\"\u00107\u001a\u00020\u001a8\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0016\u00106\u001a\u0004\b7\u00108\"\u0004\b9\u0010\u001dR\"\u0010:\u001a\u00020\u001a8\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000e\u00106\u001a\u0004\b:\u00108\"\u0004\b;\u0010\u001dR$\u0010'\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0005\u0018\u00010!8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b<\u0010=R\u0016\u0010\u000e\u001a\u00020>8\u0002@\u0002X\u0083.¢\u0006\u0006\n\u0004\b?\u0010@"}, d2 = {"Lid/dana/social/view/FeedCommentView;", "Lid/dana/base/viewbinding/ViewBindingRichView;", "Lid/dana/databinding/ViewFeedCommentBinding;", "Lid/dana/feeds/ui/model/FeedCommentModel;", "feedCommentModel", "", "bind", "(Lid/dana/feeds/ui/model/FeedCommentModel;)V", "", "replyPositionToDelete", "", "replyCommentIdToDelete", "deleteReply", "(ILjava/lang/String;)V", "KClassImpl$Data$declaredNonStaticMembers$2", "()V", "getLayout", "()I", "Landroid/view/View;", "view", "initViewBinding", "(Landroid/view/View;)Lid/dana/databinding/ViewFeedCommentBinding;", "PlaceComponentResult", "replyComment", "prependNewReply", "renderDefaultComment", "", "isSubComment", "renderFailedSubmitComment", "(Z)V", "renderReplyButton", "renderSendingSubmitComment", "renderSuccessSubmitComment", "Lkotlin/Function1;", "onClickReply", "setOnClickReply", "(Lkotlin/jvm/functions/Function1;)V", "p0", "p1", "MyBillsEntityDataFactory", "(Ljava/lang/String;Z)V", "showDim", "getAuthRequestContext", "BuiltInFictitiousFunctionClassFactory", "Lid/dana/social/view/activity/detail/FeedCommentInteraction;", "Lid/dana/social/view/activity/detail/FeedCommentInteraction;", "getFeedCommentInteraction", "()Lid/dana/social/view/activity/detail/FeedCommentInteraction;", "setFeedCommentInteraction", "(Lid/dana/social/view/activity/detail/FeedCommentInteraction;)V", "feedCommentInteraction", "Lid/dana/feeds/ui/model/FeedCommentModel;", "Lid/dana/social/utils/FeedUtils;", "Lid/dana/social/utils/FeedUtils;", "Z", "isFeedRevamp", "()Z", "setFeedRevamp", "isReplyCommentEnabled", "setReplyCommentEnabled", "lookAheadTest", "Lkotlin/jvm/functions/Function1;", "Lid/dana/social/view/activity/detail/FeedCommentAdapter;", "scheduleImpl", "Lid/dana/social/view/activity/detail/FeedCommentAdapter;", "Landroid/content/Context;", HummerConstants.CONTEXT, "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class FeedCommentView extends ViewBindingRichView<ViewFeedCommentBinding> {

    /* renamed from: Companion  reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int DIM_DURATION = 500;

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    private final FeedUtils getAuthRequestContext;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    private boolean isReplyCommentEnabled;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private FeedCommentModel PlaceComponentResult;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private boolean isFeedRevamp;
    public Map<Integer, View> _$_findViewCache;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    private FeedCommentInteraction feedCommentInteraction;

    /* renamed from: lookAheadTest  reason: from kotlin metadata */
    private Function1<? super FeedCommentModel, Unit> MyBillsEntityDataFactory;

    /* renamed from: scheduleImpl  reason: from kotlin metadata */
    private FeedCommentAdapter KClassImpl$Data$declaredNonStaticMembers$2;

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
        return R.layout.view_feed_comment;
    }

    @JvmName(name = "getFeedCommentInteraction")
    public final FeedCommentInteraction getFeedCommentInteraction() {
        return this.feedCommentInteraction;
    }

    @JvmName(name = "setFeedCommentInteraction")
    public final void setFeedCommentInteraction(FeedCommentInteraction feedCommentInteraction) {
        this.feedCommentInteraction = feedCommentInteraction;
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

    @JvmName(name = "isFeedRevamp")
    /* renamed from: isFeedRevamp  reason: from getter */
    public final boolean getIsFeedRevamp() {
        return this.isFeedRevamp;
    }

    @JvmName(name = "setFeedRevamp")
    public final void setFeedRevamp(boolean z) {
        this.isFeedRevamp = z;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FeedCommentView(Context context) {
        super(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "");
        this._$_findViewCache = new LinkedHashMap();
        Context context2 = getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "");
        this.getAuthRequestContext = new FeedUtils(context2);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FeedCommentView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "");
        this._$_findViewCache = new LinkedHashMap();
        Context context2 = getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "");
        this.getAuthRequestContext = new FeedUtils(context2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // id.dana.base.viewbinding.ViewBindingRichView
    public final ViewFeedCommentBinding initViewBinding(View view) {
        Intrinsics.checkNotNullParameter(view, "");
        ViewFeedCommentBinding KClassImpl$Data$declaredNonStaticMembers$2 = ViewFeedCommentBinding.KClassImpl$Data$declaredNonStaticMembers$2(view);
        Intrinsics.checkNotNullExpressionValue(KClassImpl$Data$declaredNonStaticMembers$2, "");
        return KClassImpl$Data$declaredNonStaticMembers$2;
    }

    public final void bind(final FeedCommentModel feedCommentModel) {
        int authRequestContext;
        Intrinsics.checkNotNullParameter(feedCommentModel, "");
        this.PlaceComponentResult = feedCommentModel;
        getBinding().initRecordTimeStamp.setText(feedCommentModel.PlaceComponentResult);
        if (feedCommentModel.KClassImpl$Data$declaredNonStaticMembers$2.length() > 0) {
            getBinding().isLayoutRequested.setText(this.getAuthRequestContext.KClassImpl$Data$declaredNonStaticMembers$2(new Date(Long.parseLong(feedCommentModel.KClassImpl$Data$declaredNonStaticMembers$2)).getTime(), this.isFeedRevamp));
        }
        CircleImageView circleImageView = getBinding().BuiltInFictitiousFunctionClassFactory;
        Intrinsics.checkNotNullExpressionValue(circleImageView, "");
        CircleImageView circleImageView2 = circleImageView;
        String str = feedCommentModel.NetworkUserEntityData$$ExternalSyntheticLambda2.NetworkUserEntityData$$ExternalSyntheticLambda0;
        if (str == null) {
            str = "";
        }
        SocialFeedExtKt.BuiltInFictitiousFunctionClassFactory(circleImageView2, str, R.drawable.avatar_placeholder);
        if (feedCommentModel.getGetErrorConfigVersion()) {
            feedCommentModel.NetworkUserEntityData$$ExternalSyntheticLambda2.BuiltInFictitiousFunctionClassFactory = getResources().getString(R.string.lookAheadTest);
        }
        getBinding().NetworkUserEntityData$$ExternalSyntheticLambda2.setText(feedCommentModel.NetworkUserEntityData$$ExternalSyntheticLambda2.BuiltInFictitiousFunctionClassFactory);
        getBinding().PlaceComponentResult.setOnClickListener(new View.OnClickListener() { // from class: id.dana.social.view.FeedCommentView$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FeedCommentView.$r8$lambda$ssJcJ9jgkOnyYOx8exxPPnXBQ5s(FeedCommentView.this, feedCommentModel, view);
            }
        });
        RecyclerView recyclerView = getBinding().GetContactSyncConfig;
        recyclerView.setNestedScrollingEnabled(false);
        recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext()));
        FeedCommentInteraction feedCommentInteraction = this.feedCommentInteraction;
        FeedCommentAdapter feedCommentAdapter = new FeedCommentAdapter(feedCommentInteraction != null ? feedCommentInteraction.PlaceComponentResult() : false, true, true, new FeedCommentInteraction() { // from class: id.dana.social.view.FeedCommentView$setupReplyCommentAdapter$1$1
            @Override // id.dana.social.view.activity.detail.FeedCommentInteraction
            public final boolean PlaceComponentResult() {
                return false;
            }

            @Override // id.dana.social.view.activity.detail.FeedCommentInteraction
            public final void getAuthRequestContext() {
            }

            @Override // id.dana.social.view.activity.detail.FeedCommentInteraction
            public final void BuiltInFictitiousFunctionClassFactory(int p0, FeedCommentModel p1) {
                Intrinsics.checkNotNullParameter(p1, "");
                FeedCommentInteraction feedCommentInteraction2 = FeedCommentView.this.getFeedCommentInteraction();
                if (feedCommentInteraction2 != null) {
                    feedCommentInteraction2.BuiltInFictitiousFunctionClassFactory(p0, p1);
                }
            }

            @Override // id.dana.social.view.activity.detail.FeedCommentInteraction
            public final void KClassImpl$Data$declaredNonStaticMembers$2(FeedCommentModel p0) {
                Intrinsics.checkNotNullParameter(p0, "");
                FeedCommentInteraction feedCommentInteraction2 = FeedCommentView.this.getFeedCommentInteraction();
                if (feedCommentInteraction2 != null) {
                    feedCommentInteraction2.KClassImpl$Data$declaredNonStaticMembers$2(p0);
                }
            }

            @Override // id.dana.social.view.activity.detail.FeedCommentInteraction
            public final void PlaceComponentResult(FeedCommentModel p0) {
                Intrinsics.checkNotNullParameter(p0, "");
                FeedCommentInteraction feedCommentInteraction2 = FeedCommentView.this.getFeedCommentInteraction();
                if (feedCommentInteraction2 != null) {
                    feedCommentInteraction2.PlaceComponentResult(p0);
                }
            }

            @Override // id.dana.social.view.activity.detail.FeedCommentInteraction
            public final void getAuthRequestContext(FeedCommentModel p0) {
                Function1 function1;
                Intrinsics.checkNotNullParameter(p0, "");
                function1 = FeedCommentView.this.MyBillsEntityDataFactory;
                if (function1 != null) {
                    function1.invoke(p0);
                }
            }

            @Override // id.dana.social.view.activity.detail.FeedCommentInteraction
            public final void KClassImpl$Data$declaredNonStaticMembers$2(int p0, FeedCommentModel p1) {
                Intrinsics.checkNotNullParameter(p1, "");
                FeedCommentInteraction feedCommentInteraction2 = FeedCommentView.this.getFeedCommentInteraction();
                if (feedCommentInteraction2 != null) {
                    feedCommentInteraction2.KClassImpl$Data$declaredNonStaticMembers$2(p0, p1);
                }
            }

            @Override // id.dana.social.view.activity.detail.FeedCommentInteraction
            public final void KClassImpl$Data$declaredNonStaticMembers$2(String p0) {
                Intrinsics.checkNotNullParameter(p0, "");
                FeedCommentView.access$loadReplies(FeedCommentView.this);
            }
        });
        this.KClassImpl$Data$declaredNonStaticMembers$2 = feedCommentAdapter;
        recyclerView.setAdapter(feedCommentAdapter);
        getBinding().NetworkUserEntityData$$ExternalSyntheticLambda8.KClassImpl$Data$declaredNonStaticMembers$2.setOnClickListener(new View.OnClickListener() { // from class: id.dana.social.view.FeedCommentView$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FeedCommentView.$r8$lambda$RTUxaEeajPyG1vxlz8__Tx8Fnbo(FeedCommentView.this, view);
            }
        });
        getBinding().NetworkUserEntityData$$ExternalSyntheticLambda8.PlaceComponentResult.setOnClickListener(new View.OnClickListener() { // from class: id.dana.social.view.FeedCommentView$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FeedCommentView.m2959$r8$lambda$EzDcZ6g8ZYeCVdh8QsY6ZasKvE(FeedCommentView.this, view);
            }
        });
        if (this.isReplyCommentEnabled) {
            ViewGroup.LayoutParams layoutParams = getBinding().BuiltInFictitiousFunctionClassFactory.getLayoutParams();
            if (layoutParams == null) {
                throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
            }
            ConstraintLayout.LayoutParams layoutParams2 = (ConstraintLayout.LayoutParams) layoutParams;
            int PlaceComponentResult = SizeUtil.PlaceComponentResult(layoutParams2.width);
            FeedCommentModel feedCommentModel2 = this.PlaceComponentResult;
            if (feedCommentModel2 != null && feedCommentModel2.MyBillsEntityDataFactory()) {
                authRequestContext = SizeUtil.getAuthRequestContext(PlaceComponentResult - 8);
            } else {
                authRequestContext = SizeUtil.getAuthRequestContext(PlaceComponentResult);
            }
            layoutParams2.width = authRequestContext;
            layoutParams2.height = authRequestContext;
            getBinding().BuiltInFictitiousFunctionClassFactory.setLayoutParams(layoutParams2);
            ConstraintSet constraintSet = new ConstraintSet();
            constraintSet.getAuthRequestContext(getBinding().KClassImpl$Data$declaredNonStaticMembers$2);
            FeedCommentModel feedCommentModel3 = this.PlaceComponentResult;
            if (feedCommentModel3 != null && feedCommentModel3.MyBillsEntityDataFactory()) {
                constraintSet.BuiltInFictitiousFunctionClassFactory(getBinding().BuiltInFictitiousFunctionClassFactory.getId(), 6, getBinding().scheduleImpl.getId(), 7);
            } else {
                constraintSet.BuiltInFictitiousFunctionClassFactory(getBinding().BuiltInFictitiousFunctionClassFactory.getId(), 6, getBinding().getAuthRequestContext.getId(), 7);
            }
            constraintSet.KClassImpl$Data$declaredNonStaticMembers$2(getBinding().KClassImpl$Data$declaredNonStaticMembers$2);
            FeedCommentModel feedCommentModel4 = this.PlaceComponentResult;
            if (feedCommentModel4 != null) {
                ImageView imageView = getBinding().DatabaseTableConfigUtil;
                Intrinsics.checkNotNullExpressionValue(imageView, "");
                imageView.setVisibility(!feedCommentModel4.MyBillsEntityDataFactory() && feedCommentModel4.KClassImpl$Data$declaredNonStaticMembers$2() ? 0 : 8);
                View view = getBinding().NetworkUserEntityData$$ExternalSyntheticLambda1;
                Intrinsics.checkNotNullExpressionValue(view, "");
                view.setVisibility(feedCommentModel4.MyBillsEntityDataFactory() ? 0 : 8);
                if (!feedCommentModel4.MyBillsEntityDataFactory() && feedCommentModel4.KClassImpl$Data$declaredNonStaticMembers$2()) {
                    PlaceComponentResult();
                    BuiltInFictitiousFunctionClassFactory();
                    return;
                } else if (!feedCommentModel4.MyBillsEntityDataFactory() && !feedCommentModel4.KClassImpl$Data$declaredNonStaticMembers$2()) {
                    ConstraintLayout constraintLayout = getBinding().NetworkUserEntityData$$ExternalSyntheticLambda8.getAuthRequestContext;
                    Intrinsics.checkNotNullExpressionValue(constraintLayout, "");
                    constraintLayout.setVisibility(8);
                    return;
                } else {
                    RecyclerView recyclerView2 = getBinding().GetContactSyncConfig;
                    Intrinsics.checkNotNullExpressionValue(recyclerView2, "");
                    recyclerView2.setVisibility(8);
                    return;
                }
            }
            return;
        }
        ImageView imageView2 = getBinding().DatabaseTableConfigUtil;
        Intrinsics.checkNotNullExpressionValue(imageView2, "");
        imageView2.setVisibility(8);
        ConstraintLayout constraintLayout2 = getBinding().NetworkUserEntityData$$ExternalSyntheticLambda8.getAuthRequestContext;
        Intrinsics.checkNotNullExpressionValue(constraintLayout2, "");
        constraintLayout2.setVisibility(8);
        getBinding().lookAheadTest.setGuidelineBegin(0);
    }

    static /* synthetic */ void MyBillsEntityDataFactory$default(FeedCommentView feedCommentView, String str, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        feedCommentView.MyBillsEntityDataFactory(str, z);
    }

    private final void MyBillsEntityDataFactory(String p0, boolean p1) {
        int i;
        TextView textView = getBinding().PrepareContext;
        textView.setText(p0);
        if (p1) {
            textView.getResources();
            i = -41643;
        } else {
            textView.getResources();
            i = -9276814;
        }
        textView.setTextColor(i);
    }

    private final void BuiltInFictitiousFunctionClassFactory() {
        FeedCommentModel feedCommentModel = this.PlaceComponentResult;
        if (feedCommentModel != null) {
            feedCommentModel.scheduleImpl = feedCommentModel.NetworkUserEntityData$$ExternalSyntheticLambda0 - feedCommentModel.getAuthRequestContext.size();
            if (!feedCommentModel.MyBillsEntityDataFactory() && feedCommentModel.KClassImpl$Data$declaredNonStaticMembers$2()) {
                ViewSeeMoreFeedCommentBinding viewSeeMoreFeedCommentBinding = getBinding().NetworkUserEntityData$$ExternalSyntheticLambda8;
                ConstraintLayout constraintLayout = viewSeeMoreFeedCommentBinding.getAuthRequestContext;
                Intrinsics.checkNotNullExpressionValue(constraintLayout, "");
                constraintLayout.setVisibility(0);
                AppCompatTextView appCompatTextView = viewSeeMoreFeedCommentBinding.KClassImpl$Data$declaredNonStaticMembers$2;
                Intrinsics.checkNotNullExpressionValue(appCompatTextView, "");
                appCompatTextView.setVisibility(feedCommentModel.getAuthRequestContext() ? 0 : 8);
                AppCompatTextView appCompatTextView2 = viewSeeMoreFeedCommentBinding.PlaceComponentResult;
                Intrinsics.checkNotNullExpressionValue(appCompatTextView2, "");
                appCompatTextView2.setVisibility(feedCommentModel.getAuthRequestContext() ^ true ? 0 : 8);
                AppCompatImageView appCompatImageView = viewSeeMoreFeedCommentBinding.BuiltInFictitiousFunctionClassFactory;
                Intrinsics.checkNotNullExpressionValue(appCompatImageView, "");
                appCompatImageView.setVisibility(feedCommentModel.getAuthRequestContext() ^ true ? 4 : 0);
                ProgressBar progressBar = viewSeeMoreFeedCommentBinding.MyBillsEntityDataFactory;
                Intrinsics.checkNotNullExpressionValue(progressBar, "");
                progressBar.setVisibility(8);
                if (feedCommentModel.getAuthRequestContext()) {
                    viewSeeMoreFeedCommentBinding.KClassImpl$Data$declaredNonStaticMembers$2.setText(getContext().getString(R.string.feed_see_more_reply_comment, Integer.valueOf(feedCommentModel.scheduleImpl)));
                    return;
                }
                return;
            }
            ConstraintLayout constraintLayout2 = getBinding().NetworkUserEntityData$$ExternalSyntheticLambda8.getAuthRequestContext;
            Intrinsics.checkNotNullExpressionValue(constraintLayout2, "");
            constraintLayout2.setVisibility(8);
        }
    }

    private final void getAuthRequestContext() {
        ViewSeeMoreFeedCommentBinding viewSeeMoreFeedCommentBinding = getBinding().NetworkUserEntityData$$ExternalSyntheticLambda8;
        AppCompatTextView appCompatTextView = viewSeeMoreFeedCommentBinding.KClassImpl$Data$declaredNonStaticMembers$2;
        Intrinsics.checkNotNullExpressionValue(appCompatTextView, "");
        appCompatTextView.setVisibility(8);
        AppCompatTextView appCompatTextView2 = viewSeeMoreFeedCommentBinding.PlaceComponentResult;
        Intrinsics.checkNotNullExpressionValue(appCompatTextView2, "");
        appCompatTextView2.setVisibility(8);
        AppCompatImageView appCompatImageView = viewSeeMoreFeedCommentBinding.BuiltInFictitiousFunctionClassFactory;
        Intrinsics.checkNotNullExpressionValue(appCompatImageView, "");
        appCompatImageView.setVisibility(0);
        ProgressBar progressBar = viewSeeMoreFeedCommentBinding.MyBillsEntityDataFactory;
        Intrinsics.checkNotNullExpressionValue(progressBar, "");
        progressBar.setVisibility(0);
    }

    private final void PlaceComponentResult() {
        List<FeedCommentModel> list;
        FeedCommentAdapter feedCommentAdapter = this.KClassImpl$Data$declaredNonStaticMembers$2;
        if (feedCommentAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            feedCommentAdapter = null;
        }
        ArrayList arrayList = new ArrayList();
        FeedCommentModel feedCommentModel = this.PlaceComponentResult;
        if (feedCommentModel != null && (list = feedCommentModel.lookAheadTest) != null) {
            List<FeedCommentModel> list2 = list.isEmpty() ^ true ? list : null;
            if (list2 != null) {
                List<FeedCommentModel> list3 = list2;
                ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list3, 10));
                Iterator<T> it = list3.iterator();
                while (it.hasNext()) {
                    arrayList2.add(new ViewHolderState.Item((FeedCommentModel) it.next()));
                }
                HashSet hashSet = new HashSet();
                ArrayList arrayList3 = new ArrayList();
                for (Object obj : arrayList2) {
                    if (hashSet.add(((FeedCommentModel) ((ViewHolderState.Item) obj).BuiltInFictitiousFunctionClassFactory).BuiltInFictitiousFunctionClassFactory)) {
                        arrayList3.add(obj);
                    }
                }
                arrayList.addAll(arrayList3);
                RecyclerView recyclerView = getBinding().GetContactSyncConfig;
                Intrinsics.checkNotNullExpressionValue(recyclerView, "");
                recyclerView.setVisibility(0);
                FeedCommentModel feedCommentModel2 = this.PlaceComponentResult;
                if (feedCommentModel2 != null) {
                    Intrinsics.checkNotNullParameter(list2, "");
                    feedCommentModel2.getAuthRequestContext = list2;
                }
            }
        }
        feedCommentAdapter.setItems(arrayList);
    }

    public final void renderSuccessSubmitComment() {
        showDim();
        BuiltInFictitiousFunctionClassFactory(false);
        renderReplyButton();
    }

    public final void renderSendingSubmitComment(boolean isSubComment) {
        String string;
        BuiltInFictitiousFunctionClassFactory(true);
        if (isSubComment) {
            string = getResources().getString(R.string.feed_sub_comment_sending);
        } else {
            string = getResources().getString(R.string.feed_comment_sending);
        }
        Intrinsics.checkNotNullExpressionValue(string, "");
        MyBillsEntityDataFactory$default(this, string, false, 2, null);
    }

    public final void renderFailedSubmitComment(boolean isSubComment) {
        showDim();
        AppCompatImageView appCompatImageView = getBinding().getErrorConfigVersion;
        Intrinsics.checkNotNullExpressionValue(appCompatImageView, "");
        appCompatImageView.setVisibility(0);
        ProgressBar progressBar = getBinding().NetworkUserEntityData$$ExternalSyntheticLambda0;
        Intrinsics.checkNotNullExpressionValue(progressBar, "");
        progressBar.setVisibility(8);
        TextView textView = getBinding().PrepareContext;
        Intrinsics.checkNotNullExpressionValue(textView, "");
        textView.setVisibility(0);
        AppCompatImageView appCompatImageView2 = getBinding().moveToNextValue;
        Intrinsics.checkNotNullExpressionValue(appCompatImageView2, "");
        appCompatImageView2.setVisibility(0);
        View view = getBinding().NetworkUserEntityData$$ExternalSyntheticLambda1;
        Intrinsics.checkNotNullExpressionValue(view, "");
        view.setVisibility(4);
        LinearLayout linearLayout = getBinding().PlaceComponentResult;
        Intrinsics.checkNotNullExpressionValue(linearLayout, "");
        linearLayout.setVisibility(8);
        String string = getResources().getString(Companion.BuiltInFictitiousFunctionClassFactory(isSubComment));
        Intrinsics.checkNotNullExpressionValue(string, "");
        MyBillsEntityDataFactory(string, true);
    }

    public final void showDim() {
        getBinding().KClassImpl$Data$declaredNonStaticMembers$2.setBackground(ResourcesCompat.BuiltInFictitiousFunctionClassFactory(getResources(), R.drawable.bg_feed_comment_dim, null));
        Drawable background = getBinding().KClassImpl$Data$declaredNonStaticMembers$2.getBackground();
        if (background == null) {
            throw new NullPointerException("null cannot be cast to non-null type android.graphics.drawable.TransitionDrawable");
        }
        ((TransitionDrawable) background).startTransition(500);
    }

    public final void renderDefaultComment() {
        BuiltInFictitiousFunctionClassFactory(false);
        getBinding().KClassImpl$Data$declaredNonStaticMembers$2.setBackground(ResourcesCompat.BuiltInFictitiousFunctionClassFactory(getResources(), R.color.colorWhite, null));
    }

    private final void BuiltInFictitiousFunctionClassFactory(boolean p0) {
        AppCompatImageView appCompatImageView = getBinding().getErrorConfigVersion;
        Intrinsics.checkNotNullExpressionValue(appCompatImageView, "");
        boolean z = !p0;
        appCompatImageView.setVisibility(z ? 0 : 8);
        TextView textView = getBinding().isLayoutRequested;
        Intrinsics.checkNotNullExpressionValue(textView, "");
        textView.setVisibility(z ? 0 : 8);
        ProgressBar progressBar = getBinding().NetworkUserEntityData$$ExternalSyntheticLambda0;
        Intrinsics.checkNotNullExpressionValue(progressBar, "");
        progressBar.setVisibility(p0 ? 0 : 8);
        TextView textView2 = getBinding().PrepareContext;
        Intrinsics.checkNotNullExpressionValue(textView2, "");
        textView2.setVisibility(p0 ? 0 : 8);
        AppCompatImageView appCompatImageView2 = getBinding().moveToNextValue;
        Intrinsics.checkNotNullExpressionValue(appCompatImageView2, "");
        appCompatImageView2.setVisibility(8);
        FeedCommentModel feedCommentModel = this.PlaceComponentResult;
        if (feedCommentModel != null && feedCommentModel.MyBillsEntityDataFactory()) {
            View view = getBinding().NetworkUserEntityData$$ExternalSyntheticLambda1;
            Intrinsics.checkNotNullExpressionValue(view, "");
            view.setVisibility(z ? 0 : 8);
            return;
        }
        View view2 = getBinding().NetworkUserEntityData$$ExternalSyntheticLambda1;
        Intrinsics.checkNotNullExpressionValue(view2, "");
        view2.setVisibility(8);
    }

    public final void prependNewReply(FeedCommentModel replyComment) {
        Intrinsics.checkNotNullParameter(replyComment, "");
        FeedCommentModel feedCommentModel = this.PlaceComponentResult;
        if (feedCommentModel != null) {
            RecyclerView recyclerView = getBinding().GetContactSyncConfig;
            Intrinsics.checkNotNullExpressionValue(recyclerView, "");
            FeedCommentAdapter feedCommentAdapter = null;
            if (recyclerView.getVisibility() == 8) {
                RecyclerView recyclerView2 = getBinding().GetContactSyncConfig;
                Intrinsics.checkNotNullExpressionValue(recyclerView2, "");
                recyclerView2.setVisibility(0);
                FeedCommentAdapter feedCommentAdapter2 = this.KClassImpl$Data$declaredNonStaticMembers$2;
                if (feedCommentAdapter2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                } else {
                    feedCommentAdapter = feedCommentAdapter2;
                }
                ArrayList arrayList = new ArrayList();
                arrayList.add(new ViewHolderState.Item(replyComment));
                feedCommentAdapter.setItems(arrayList);
            } else {
                FeedCommentAdapter feedCommentAdapter3 = this.KClassImpl$Data$declaredNonStaticMembers$2;
                if (feedCommentAdapter3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                } else {
                    feedCommentAdapter = feedCommentAdapter3;
                }
                feedCommentAdapter.getAuthRequestContext(new ViewHolderState.Item(replyComment));
            }
            if (feedCommentModel.NetworkUserEntityData$$ExternalSyntheticLambda0 == 0) {
                FeedCommentModel feedCommentModel2 = this.PlaceComponentResult;
                if (!(feedCommentModel2 != null && feedCommentModel2.MyBillsEntityDataFactory())) {
                    ConstraintLayout constraintLayout = getBinding().NetworkUserEntityData$$ExternalSyntheticLambda8.getAuthRequestContext;
                    Intrinsics.checkNotNullExpressionValue(constraintLayout, "");
                    constraintLayout.setVisibility(0);
                    ((AppCompatTextView) constraintLayout.findViewById(R.id.tvHideReplies)).setText(constraintLayout.getContext().getString(R.string.feed_hide_replies));
                    AppCompatTextView appCompatTextView = (AppCompatTextView) constraintLayout.findViewById(R.id.res_0x7f0a155b_longcounterbuilder_cc);
                    Intrinsics.checkNotNullExpressionValue(appCompatTextView, "");
                    appCompatTextView.setVisibility(8);
                    AppCompatTextView appCompatTextView2 = (AppCompatTextView) constraintLayout.findViewById(R.id.tvHideReplies);
                    Intrinsics.checkNotNullExpressionValue(appCompatTextView2, "");
                    appCompatTextView2.setVisibility(0);
                    AppCompatImageView appCompatImageView = (AppCompatImageView) constraintLayout.findViewById(R.id.ProductInfoEntityData);
                    Intrinsics.checkNotNullExpressionValue(appCompatImageView, "");
                    appCompatImageView.setVisibility(4);
                }
            }
            ImageView imageView = getBinding().DatabaseTableConfigUtil;
            Intrinsics.checkNotNullExpressionValue(imageView, "");
            if (imageView.getVisibility() == 8) {
                ImageView imageView2 = getBinding().DatabaseTableConfigUtil;
                Intrinsics.checkNotNullExpressionValue(imageView2, "");
                imageView2.setVisibility(0);
            }
        }
    }

    public final void renderReplyButton() {
        LinearLayout linearLayout = getBinding().PlaceComponentResult;
        Intrinsics.checkNotNullExpressionValue(linearLayout, "");
        linearLayout.setVisibility(this.isReplyCommentEnabled ? 0 : 8);
    }

    public final void setOnClickReply(Function1<? super FeedCommentModel, Unit> onClickReply) {
        Intrinsics.checkNotNullParameter(onClickReply, "");
        this.MyBillsEntityDataFactory = onClickReply;
    }

    public final void deleteReply(int replyPositionToDelete, String replyCommentIdToDelete) {
        Intrinsics.checkNotNullParameter(replyCommentIdToDelete, "");
        if (replyPositionToDelete != -1) {
            FeedCommentAdapter feedCommentAdapter = this.KClassImpl$Data$declaredNonStaticMembers$2;
            if (feedCommentAdapter == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
                feedCommentAdapter = null;
            }
            feedCommentAdapter.removeItem(replyPositionToDelete);
        }
        FeedCommentModel feedCommentModel = this.PlaceComponentResult;
        if (feedCommentModel != null) {
            Iterator<FeedCommentModel> it = feedCommentModel.lookAheadTest.iterator();
            int i = 0;
            while (true) {
                if (!it.hasNext()) {
                    i = -1;
                    break;
                } else if (Intrinsics.areEqual(it.next().BuiltInFictitiousFunctionClassFactory, replyCommentIdToDelete)) {
                    break;
                } else {
                    i++;
                }
            }
            Integer valueOf = Integer.valueOf(i);
            Integer num = valueOf.intValue() != -1 ? valueOf : null;
            if (num != null) {
                feedCommentModel.lookAheadTest.remove(num.intValue());
                feedCommentModel.NetworkUserEntityData$$ExternalSyntheticLambda0--;
                if (feedCommentModel.NetworkUserEntityData$$ExternalSyntheticLambda0 == 0) {
                    ImageView imageView = getBinding().DatabaseTableConfigUtil;
                    Intrinsics.checkNotNullExpressionValue(imageView, "");
                    imageView.setVisibility(8);
                }
                BuiltInFictitiousFunctionClassFactory();
            }
        }
    }

    private final void KClassImpl$Data$declaredNonStaticMembers$2() {
        FeedCommentInteraction feedCommentInteraction = this.feedCommentInteraction;
        if (feedCommentInteraction != null) {
            FeedCommentModel feedCommentModel = this.PlaceComponentResult;
            String str = feedCommentModel != null ? feedCommentModel.BuiltInFictitiousFunctionClassFactory : null;
            if (str == null) {
                str = "";
            }
            feedCommentInteraction.KClassImpl$Data$declaredNonStaticMembers$2(str);
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\nJ\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0007\u0010\b"}, d2 = {"Lid/dana/social/view/FeedCommentView$Companion;", "", "", "p0", "", "BuiltInFictitiousFunctionClassFactory", "(Z)I", "DIM_DURATION", "I", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static int BuiltInFictitiousFunctionClassFactory(boolean p0) {
            return p0 ? R.string.feed_sub_comment_sending_failed : R.string.feed_comment_sending_failed;
        }

        private Companion() {
        }
    }

    /* renamed from: $r8$lambda$EzDcZ6g8ZYeCV-dh8QsY6ZasKvE  reason: not valid java name */
    public static /* synthetic */ void m2959$r8$lambda$EzDcZ6g8ZYeCVdh8QsY6ZasKvE(FeedCommentView feedCommentView, View view) {
        Intrinsics.checkNotNullParameter(feedCommentView, "");
        if (Intrinsics.areEqual(feedCommentView.getBinding().NetworkUserEntityData$$ExternalSyntheticLambda8.PlaceComponentResult.getText(), feedCommentView.getContext().getString(R.string.feed_hide_replies))) {
            feedCommentView.getBinding().NetworkUserEntityData$$ExternalSyntheticLambda8.PlaceComponentResult.setText(feedCommentView.getContext().getString(R.string.feed_show_all_replies));
            RecyclerView recyclerView = feedCommentView.getBinding().GetContactSyncConfig;
            Intrinsics.checkNotNullExpressionValue(recyclerView, "");
            recyclerView.setVisibility(8);
            AppCompatImageView appCompatImageView = feedCommentView.getBinding().NetworkUserEntityData$$ExternalSyntheticLambda8.BuiltInFictitiousFunctionClassFactory;
            Intrinsics.checkNotNullExpressionValue(appCompatImageView, "");
            appCompatImageView.setVisibility(0);
            return;
        }
        RecyclerView recyclerView2 = feedCommentView.getBinding().GetContactSyncConfig;
        Intrinsics.checkNotNullExpressionValue(recyclerView2, "");
        if (recyclerView2.getVisibility() == 0) {
            feedCommentView.PlaceComponentResult();
        } else {
            RecyclerView recyclerView3 = feedCommentView.getBinding().GetContactSyncConfig;
            Intrinsics.checkNotNullExpressionValue(recyclerView3, "");
            recyclerView3.setVisibility(0);
        }
        feedCommentView.getBinding().NetworkUserEntityData$$ExternalSyntheticLambda8.PlaceComponentResult.setText(feedCommentView.getContext().getString(R.string.feed_hide_replies));
        AppCompatImageView appCompatImageView2 = feedCommentView.getBinding().NetworkUserEntityData$$ExternalSyntheticLambda8.BuiltInFictitiousFunctionClassFactory;
        Intrinsics.checkNotNullExpressionValue(appCompatImageView2, "");
        appCompatImageView2.setVisibility(4);
    }

    public static /* synthetic */ void $r8$lambda$RTUxaEeajPyG1vxlz8__Tx8Fnbo(FeedCommentView feedCommentView, View view) {
        Intrinsics.checkNotNullParameter(feedCommentView, "");
        RecyclerView recyclerView = feedCommentView.getBinding().GetContactSyncConfig;
        Intrinsics.checkNotNullExpressionValue(recyclerView, "");
        if (!(recyclerView.getVisibility() == 0)) {
            RecyclerView recyclerView2 = feedCommentView.getBinding().GetContactSyncConfig;
            Intrinsics.checkNotNullExpressionValue(recyclerView2, "");
            recyclerView2.setVisibility(0);
        }
        feedCommentView.KClassImpl$Data$declaredNonStaticMembers$2();
        feedCommentView.getAuthRequestContext();
    }

    public static /* synthetic */ void $r8$lambda$ssJcJ9jgkOnyYOx8exxPPnXBQ5s(FeedCommentView feedCommentView, FeedCommentModel feedCommentModel, View view) {
        Intrinsics.checkNotNullParameter(feedCommentView, "");
        Intrinsics.checkNotNullParameter(feedCommentModel, "");
        Function1<? super FeedCommentModel, Unit> function1 = feedCommentView.MyBillsEntityDataFactory;
        if (function1 != null) {
            function1.invoke(feedCommentModel);
        }
    }

    public static final /* synthetic */ void access$loadReplies(FeedCommentView feedCommentView) {
        feedCommentView.KClassImpl$Data$declaredNonStaticMembers$2();
        feedCommentView.getAuthRequestContext();
    }
}
