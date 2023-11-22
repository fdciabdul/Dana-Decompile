package id.dana.databinding;

import android.view.View;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import id.dana.R;
import id.dana.social.view.FeedsMeHeaderView;
import in.srain.cube.views.ptr.PtrClassicFrameLayout;

/* loaded from: classes4.dex */
public final class ViewSocialFriendsFeedBinding implements ViewBinding {
    public final PtrClassicFrameLayout BuiltInFictitiousFunctionClassFactory;
    public final AppCompatImageView KClassImpl$Data$declaredNonStaticMembers$2;
    public final CardView MyBillsEntityDataFactory;
    public final ConstraintLayout PlaceComponentResult;
    public final RecyclerView getAuthRequestContext;
    public final FeedsMeHeaderView lookAheadTest;
    public final AppCompatTextView scheduleImpl;

    private ViewSocialFriendsFeedBinding(ConstraintLayout constraintLayout, CardView cardView, AppCompatImageView appCompatImageView, PtrClassicFrameLayout ptrClassicFrameLayout, RecyclerView recyclerView, AppCompatTextView appCompatTextView, FeedsMeHeaderView feedsMeHeaderView) {
        this.PlaceComponentResult = constraintLayout;
        this.MyBillsEntityDataFactory = cardView;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = appCompatImageView;
        this.BuiltInFictitiousFunctionClassFactory = ptrClassicFrameLayout;
        this.getAuthRequestContext = recyclerView;
        this.scheduleImpl = appCompatTextView;
        this.lookAheadTest = feedsMeHeaderView;
    }

    public static ViewSocialFriendsFeedBinding BuiltInFictitiousFunctionClassFactory(View view) {
        int i = R.id.f3717ViewPayConfirmationAddOnBinding_res_0x7f0a0572;
        CardView cardView = (CardView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.f3717ViewPayConfirmationAddOnBinding_res_0x7f0a0572);
        if (cardView != null) {
            AppCompatImageView appCompatImageView = (AppCompatImageView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.iv_up);
            if (appCompatImageView != null) {
                PtrClassicFrameLayout ptrClassicFrameLayout = (PtrClassicFrameLayout) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.ptr_feeds);
                if (ptrClassicFrameLayout != null) {
                    RecyclerView recyclerView = (RecyclerView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.getMonitoredResourcesOrBuilder);
                    if (recyclerView != null) {
                        AppCompatTextView appCompatTextView = (AppCompatTextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.tv_back_to_top);
                        if (appCompatTextView != null) {
                            FeedsMeHeaderView feedsMeHeaderView = (FeedsMeHeaderView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.view_feeds_me_header);
                            if (feedsMeHeaderView != null) {
                                return new ViewSocialFriendsFeedBinding((ConstraintLayout) view, cardView, appCompatImageView, ptrClassicFrameLayout, recyclerView, appCompatTextView, feedsMeHeaderView);
                            }
                            i = R.id.view_feeds_me_header;
                        } else {
                            i = R.id.tv_back_to_top;
                        }
                    } else {
                        i = R.id.getMonitoredResourcesOrBuilder;
                    }
                } else {
                    i = R.id.ptr_feeds;
                }
            } else {
                i = R.id.iv_up;
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @Override // androidx.viewbinding.ViewBinding
    public final /* bridge */ /* synthetic */ View KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.PlaceComponentResult;
    }
}
