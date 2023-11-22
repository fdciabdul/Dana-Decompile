package id.dana.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import id.dana.R;
import id.dana.social.v2.view.ActivityFeedView;
import id.dana.social.view.CommentListView;
import id.dana.social.view.FeedInputCommentView;
import id.dana.social.view.FeedsView;
import id.dana.social.view.ReactionSectionView;
import in.srain.cube.views.ptr.PtrClassicFrameLayout;

/* loaded from: classes4.dex */
public final class ActivityCommentDetailBinding implements ViewBinding {
    public final AppBarLayout BuiltInFictitiousFunctionClassFactory;
    public final CollapsingToolbarLayout KClassImpl$Data$declaredNonStaticMembers$2;
    public final CommentListView MyBillsEntityDataFactory;
    public final ActivityFeedView NetworkUserEntityData$$ExternalSyntheticLambda0;
    private final ConstraintLayout NetworkUserEntityData$$ExternalSyntheticLambda2;
    public final FeedInputCommentView PlaceComponentResult;
    public final ConstraintLayout getAuthRequestContext;
    public final ReactionSectionView getErrorConfigVersion;
    public final FeedsView lookAheadTest;
    public final LayoutToolbarBinding moveToNextValue;
    public final PtrClassicFrameLayout scheduleImpl;

    private ActivityCommentDetailBinding(ConstraintLayout constraintLayout, AppBarLayout appBarLayout, ConstraintLayout constraintLayout2, CollapsingToolbarLayout collapsingToolbarLayout, CommentListView commentListView, FeedInputCommentView feedInputCommentView, FeedsView feedsView, ActivityFeedView activityFeedView, PtrClassicFrameLayout ptrClassicFrameLayout, ReactionSectionView reactionSectionView, LayoutToolbarBinding layoutToolbarBinding) {
        this.NetworkUserEntityData$$ExternalSyntheticLambda2 = constraintLayout;
        this.BuiltInFictitiousFunctionClassFactory = appBarLayout;
        this.getAuthRequestContext = constraintLayout2;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = collapsingToolbarLayout;
        this.MyBillsEntityDataFactory = commentListView;
        this.PlaceComponentResult = feedInputCommentView;
        this.lookAheadTest = feedsView;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = activityFeedView;
        this.scheduleImpl = ptrClassicFrameLayout;
        this.getErrorConfigVersion = reactionSectionView;
        this.moveToNextValue = layoutToolbarBinding;
    }

    public static ActivityCommentDetailBinding BuiltInFictitiousFunctionClassFactory(LayoutInflater layoutInflater) {
        View inflate = layoutInflater.inflate(R.layout.activity_comment_detail, (ViewGroup) null, false);
        int i = R.id.f3440app_bar_activity_detail_layout;
        AppBarLayout appBarLayout = (AppBarLayout) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.f3440app_bar_activity_detail_layout);
        if (appBarLayout != null) {
            ConstraintLayout constraintLayout = (ConstraintLayout) inflate;
            CollapsingToolbarLayout collapsingToolbarLayout = (CollapsingToolbarLayout) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.f3698collapsing_toolbar);
            if (collapsingToolbarLayout != null) {
                CommentListView commentListView = (CommentListView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.commentlistview);
                if (commentListView != null) {
                    FeedInputCommentView feedInputCommentView = (FeedInputCommentView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.feed_input_comment_view);
                    if (feedInputCommentView != null) {
                        FeedsView feedsView = (FeedsView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.f3770feed_view_detail);
                        if (feedsView != null) {
                            ActivityFeedView activityFeedView = (ActivityFeedView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.f4056newFeedViewDetail);
                            if (activityFeedView != null) {
                                PtrClassicFrameLayout ptrClassicFrameLayout = (PtrClassicFrameLayout) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.ptr_activity_detail);
                                if (ptrClassicFrameLayout != null) {
                                    ReactionSectionView reactionSectionView = (ReactionSectionView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.f4095reaction_section_view_detail);
                                    if (reactionSectionView != null) {
                                        View BuiltInFictitiousFunctionClassFactory = ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.tb_social_detail);
                                        if (BuiltInFictitiousFunctionClassFactory != null) {
                                            return new ActivityCommentDetailBinding(constraintLayout, appBarLayout, constraintLayout, collapsingToolbarLayout, commentListView, feedInputCommentView, feedsView, activityFeedView, ptrClassicFrameLayout, reactionSectionView, LayoutToolbarBinding.MyBillsEntityDataFactory(BuiltInFictitiousFunctionClassFactory));
                                        }
                                        i = R.id.tb_social_detail;
                                    } else {
                                        i = R.id.f4095reaction_section_view_detail;
                                    }
                                } else {
                                    i = R.id.ptr_activity_detail;
                                }
                            } else {
                                i = R.id.f4056newFeedViewDetail;
                            }
                        } else {
                            i = R.id.f3770feed_view_detail;
                        }
                    } else {
                        i = R.id.feed_input_comment_view;
                    }
                } else {
                    i = R.id.commentlistview;
                }
            } else {
                i = R.id.f3698collapsing_toolbar;
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(inflate.getResources().getResourceName(i)));
    }

    @Override // androidx.viewbinding.ViewBinding
    public final /* bridge */ /* synthetic */ View KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.NetworkUserEntityData$$ExternalSyntheticLambda2;
    }
}
