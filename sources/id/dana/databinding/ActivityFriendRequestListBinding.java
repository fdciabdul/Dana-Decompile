package id.dana.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import id.dana.R;
import id.dana.component.buttoncomponent.DanaButtonSecondaryView;
import id.dana.social.v2.view.FeedPullToRefreshView;

/* loaded from: classes4.dex */
public final class ActivityFriendRequestListBinding implements ViewBinding {
    public final LinearLayout BuiltInFictitiousFunctionClassFactory;
    public final DanaButtonSecondaryView KClassImpl$Data$declaredNonStaticMembers$2;
    public final Group MyBillsEntityDataFactory;
    public final FeedPullToRefreshView NetworkUserEntityData$$ExternalSyntheticLambda0;
    private final LinearLayout NetworkUserEntityData$$ExternalSyntheticLambda1;
    public final AppCompatImageView PlaceComponentResult;
    public final ConstraintLayout getAuthRequestContext;
    public final TextView getErrorConfigVersion;
    public final LayoutToolbarBinding lookAheadTest;
    public final TextView moveToNextValue;
    public final RecyclerView scheduleImpl;

    private ActivityFriendRequestListBinding(LinearLayout linearLayout, DanaButtonSecondaryView danaButtonSecondaryView, ConstraintLayout constraintLayout, Group group, AppCompatImageView appCompatImageView, LinearLayout linearLayout2, FeedPullToRefreshView feedPullToRefreshView, RecyclerView recyclerView, LayoutToolbarBinding layoutToolbarBinding, TextView textView, TextView textView2) {
        this.NetworkUserEntityData$$ExternalSyntheticLambda1 = linearLayout;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = danaButtonSecondaryView;
        this.getAuthRequestContext = constraintLayout;
        this.MyBillsEntityDataFactory = group;
        this.PlaceComponentResult = appCompatImageView;
        this.BuiltInFictitiousFunctionClassFactory = linearLayout2;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = feedPullToRefreshView;
        this.scheduleImpl = recyclerView;
        this.lookAheadTest = layoutToolbarBinding;
        this.getErrorConfigVersion = textView;
        this.moveToNextValue = textView2;
    }

    public static ActivityFriendRequestListBinding PlaceComponentResult(LayoutInflater layoutInflater) {
        View inflate = layoutInflater.inflate(R.layout.activity_friend_request_list, (ViewGroup) null, false);
        int i = R.id.btnTryAgain;
        DanaButtonSecondaryView danaButtonSecondaryView = (DanaButtonSecondaryView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.btnTryAgain);
        if (danaButtonSecondaryView != null) {
            ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.f3589onTooManyRedirects_res_0x7f0a0352);
            if (constraintLayout != null) {
                Group group = (Group) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.groupErrorState);
                if (group != null) {
                    AppCompatImageView appCompatImageView = (AppCompatImageView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.ivErrorState);
                    if (appCompatImageView != null) {
                        LinearLayout linearLayout = (LinearLayout) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.llErrorState);
                        if (linearLayout != null) {
                            FeedPullToRefreshView feedPullToRefreshView = (FeedPullToRefreshView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.ptrFriendRequest);
                            if (feedPullToRefreshView != null) {
                                RecyclerView recyclerView = (RecyclerView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.rvFriendRequests);
                                if (recyclerView != null) {
                                    View BuiltInFictitiousFunctionClassFactory = ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.toolbarFeeds);
                                    if (BuiltInFictitiousFunctionClassFactory != null) {
                                        LayoutToolbarBinding MyBillsEntityDataFactory = LayoutToolbarBinding.MyBillsEntityDataFactory(BuiltInFictitiousFunctionClassFactory);
                                        TextView textView = (TextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.MerchantReviewFormAnalyticTracker);
                                        if (textView != null) {
                                            TextView textView2 = (TextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.tvErrorTitle);
                                            if (textView2 != null) {
                                                return new ActivityFriendRequestListBinding((LinearLayout) inflate, danaButtonSecondaryView, constraintLayout, group, appCompatImageView, linearLayout, feedPullToRefreshView, recyclerView, MyBillsEntityDataFactory, textView, textView2);
                                            }
                                            i = R.id.tvErrorTitle;
                                        } else {
                                            i = R.id.MerchantReviewFormAnalyticTracker;
                                        }
                                    } else {
                                        i = R.id.toolbarFeeds;
                                    }
                                } else {
                                    i = R.id.rvFriendRequests;
                                }
                            } else {
                                i = R.id.ptrFriendRequest;
                            }
                        } else {
                            i = R.id.llErrorState;
                        }
                    } else {
                        i = R.id.ivErrorState;
                    }
                } else {
                    i = R.id.groupErrorState;
                }
            } else {
                i = R.id.f3589onTooManyRedirects_res_0x7f0a0352;
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(inflate.getResources().getResourceName(i)));
    }

    @Override // androidx.viewbinding.ViewBinding
    public final /* bridge */ /* synthetic */ View KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.NetworkUserEntityData$$ExternalSyntheticLambda1;
    }
}
