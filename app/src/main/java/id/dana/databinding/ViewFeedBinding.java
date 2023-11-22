package id.dana.databinding;

import android.view.View;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import de.hdodenhof.circleimageview.CircleImageView;
import id.dana.R;
import id.dana.social.view.BubbleFeedView;

/* loaded from: classes4.dex */
public final class ViewFeedBinding implements ViewBinding {
    public final ImageView BuiltInFictitiousFunctionClassFactory;
    public final ImageView KClassImpl$Data$declaredNonStaticMembers$2;
    public final BubbleFeedView MyBillsEntityDataFactory;
    public final View NetworkUserEntityData$$ExternalSyntheticLambda0;
    public final CircleImageView PlaceComponentResult;
    public final CircleImageView getAuthRequestContext;
    private final ConstraintLayout getErrorConfigVersion;

    private ViewFeedBinding(ConstraintLayout constraintLayout, CircleImageView circleImageView, CircleImageView circleImageView2, ImageView imageView, ImageView imageView2, BubbleFeedView bubbleFeedView, View view) {
        this.getErrorConfigVersion = constraintLayout;
        this.PlaceComponentResult = circleImageView;
        this.getAuthRequestContext = circleImageView2;
        this.BuiltInFictitiousFunctionClassFactory = imageView;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = imageView2;
        this.MyBillsEntityDataFactory = bubbleFeedView;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = view;
    }

    public static ViewFeedBinding KClassImpl$Data$declaredNonStaticMembers$2(View view) {
        int i = R.id.f3577civ_profile_avatar;
        CircleImageView circleImageView = (CircleImageView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.f3577civ_profile_avatar);
        if (circleImageView != null) {
            CircleImageView circleImageView2 = (CircleImageView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.f3581civ_view_feed_notif_badge);
            if (circleImageView2 != null) {
                ImageView imageView = (ImageView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.ivUnreadBadge);
                if (imageView != null) {
                    ImageView imageView2 = (ImageView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.iv_view_feed_unread_notification_badge);
                    if (imageView2 != null) {
                        BubbleFeedView bubbleFeedView = (BubbleFeedView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.f4576view_bubble_feed);
                        if (bubbleFeedView != null) {
                            View BuiltInFictitiousFunctionClassFactory = ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.view_feed_view_notif_badge_positioner);
                            if (BuiltInFictitiousFunctionClassFactory != null) {
                                return new ViewFeedBinding((ConstraintLayout) view, circleImageView, circleImageView2, imageView, imageView2, bubbleFeedView, BuiltInFictitiousFunctionClassFactory);
                            }
                            i = R.id.view_feed_view_notif_badge_positioner;
                        } else {
                            i = R.id.f4576view_bubble_feed;
                        }
                    } else {
                        i = R.id.iv_view_feed_unread_notification_badge;
                    }
                } else {
                    i = R.id.ivUnreadBadge;
                }
            } else {
                i = R.id.f3581civ_view_feed_notif_badge;
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @Override // androidx.viewbinding.ViewBinding
    public final /* bridge */ /* synthetic */ View KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.getErrorConfigVersion;
    }
}
