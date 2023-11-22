package id.dana.databinding;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import de.hdodenhof.circleimageview.CircleImageView;
import id.dana.R;
import id.dana.social.view.BubbleFeedView;

/* loaded from: classes4.dex */
public final class ViewGroupedFeedBinding implements ViewBinding {
    public final CircleImageView BuiltInFictitiousFunctionClassFactory;
    public final FrameLayout KClassImpl$Data$declaredNonStaticMembers$2;
    public final CircleImageView MyBillsEntityDataFactory;
    public final ImageView NetworkUserEntityData$$ExternalSyntheticLambda0;
    public final CircleImageView PlaceComponentResult;
    public final ImageView getAuthRequestContext;
    public final View lookAheadTest;
    private final ConstraintLayout moveToNextValue;
    public final BubbleFeedView scheduleImpl;

    private ViewGroupedFeedBinding(ConstraintLayout constraintLayout, CircleImageView circleImageView, CircleImageView circleImageView2, CircleImageView circleImageView3, FrameLayout frameLayout, ImageView imageView, ImageView imageView2, BubbleFeedView bubbleFeedView, View view) {
        this.moveToNextValue = constraintLayout;
        this.BuiltInFictitiousFunctionClassFactory = circleImageView;
        this.PlaceComponentResult = circleImageView2;
        this.MyBillsEntityDataFactory = circleImageView3;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = frameLayout;
        this.getAuthRequestContext = imageView;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = imageView2;
        this.scheduleImpl = bubbleFeedView;
        this.lookAheadTest = view;
    }

    public static ViewGroupedFeedBinding PlaceComponentResult(View view) {
        int i = R.id.f3575civ_multiple_avatar_image_1;
        CircleImageView circleImageView = (CircleImageView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.f3575civ_multiple_avatar_image_1);
        if (circleImageView != null) {
            CircleImageView circleImageView2 = (CircleImageView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.f3576civ_multiple_avatar_image_2);
            if (circleImageView2 != null) {
                CircleImageView circleImageView3 = (CircleImageView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.f3581civ_view_feed_notif_badge);
                if (circleImageView3 != null) {
                    FrameLayout frameLayout = (FrameLayout) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.fl_multiple_avatar_image);
                    if (frameLayout != null) {
                        ImageView imageView = (ImageView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.ivUnreadBadge);
                        if (imageView != null) {
                            ImageView imageView2 = (ImageView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.iv_view_feed_unread_notification_badge);
                            if (imageView2 != null) {
                                BubbleFeedView bubbleFeedView = (BubbleFeedView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.f4576view_bubble_feed);
                                if (bubbleFeedView != null) {
                                    View BuiltInFictitiousFunctionClassFactory = ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.view_feed_view_notif_badge_positioner);
                                    if (BuiltInFictitiousFunctionClassFactory != null) {
                                        return new ViewGroupedFeedBinding((ConstraintLayout) view, circleImageView, circleImageView2, circleImageView3, frameLayout, imageView, imageView2, bubbleFeedView, BuiltInFictitiousFunctionClassFactory);
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
                        i = R.id.fl_multiple_avatar_image;
                    }
                } else {
                    i = R.id.f3581civ_view_feed_notif_badge;
                }
            } else {
                i = R.id.f3576civ_multiple_avatar_image_2;
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @Override // androidx.viewbinding.ViewBinding
    public final /* bridge */ /* synthetic */ View KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.moveToNextValue;
    }
}
