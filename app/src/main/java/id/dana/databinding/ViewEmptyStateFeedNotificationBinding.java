package id.dana.databinding;

import android.view.View;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import id.dana.R;

/* loaded from: classes4.dex */
public final class ViewEmptyStateFeedNotificationBinding implements ViewBinding {
    public final ConstraintLayout BuiltInFictitiousFunctionClassFactory;
    public final AppCompatImageView KClassImpl$Data$declaredNonStaticMembers$2;
    public final ConstraintLayout MyBillsEntityDataFactory;
    public final TextView PlaceComponentResult;
    public final TextView getAuthRequestContext;

    private ViewEmptyStateFeedNotificationBinding(ConstraintLayout constraintLayout, AppCompatImageView appCompatImageView, TextView textView, TextView textView2, ConstraintLayout constraintLayout2) {
        this.BuiltInFictitiousFunctionClassFactory = constraintLayout;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = appCompatImageView;
        this.getAuthRequestContext = textView;
        this.PlaceComponentResult = textView2;
        this.MyBillsEntityDataFactory = constraintLayout2;
    }

    public static ViewEmptyStateFeedNotificationBinding BuiltInFictitiousFunctionClassFactory(View view) {
        int i = R.id.iv_empty_feed_notification;
        AppCompatImageView appCompatImageView = (AppCompatImageView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.iv_empty_feed_notification);
        if (appCompatImageView != null) {
            TextView textView = (TextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.tv_empty_feed_notification_desc);
            if (textView != null) {
                TextView textView2 = (TextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.tv_empty_feed_notification_title);
                if (textView2 != null) {
                    ConstraintLayout constraintLayout = (ConstraintLayout) view;
                    return new ViewEmptyStateFeedNotificationBinding(constraintLayout, appCompatImageView, textView, textView2, constraintLayout);
                }
                i = R.id.tv_empty_feed_notification_title;
            } else {
                i = R.id.tv_empty_feed_notification_desc;
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @Override // androidx.viewbinding.ViewBinding
    public final /* bridge */ /* synthetic */ View KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.BuiltInFictitiousFunctionClassFactory;
    }
}
