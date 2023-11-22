package id.dana.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import id.dana.R;
import in.srain.cube.views.ptr.PtrClassicFrameLayout;

/* loaded from: classes4.dex */
public final class ActivityFeedNotificationBinding implements ViewBinding {
    public final RecyclerView BuiltInFictitiousFunctionClassFactory;
    public final ConstraintLayout KClassImpl$Data$declaredNonStaticMembers$2;
    public final LayoutToolbarBinding MyBillsEntityDataFactory;
    public final PtrClassicFrameLayout PlaceComponentResult;
    public final ViewEmptyStateFeedNotificationBinding getAuthRequestContext;
    private final ConstraintLayout getErrorConfigVersion;

    private ActivityFeedNotificationBinding(ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2, ViewEmptyStateFeedNotificationBinding viewEmptyStateFeedNotificationBinding, PtrClassicFrameLayout ptrClassicFrameLayout, RecyclerView recyclerView, LayoutToolbarBinding layoutToolbarBinding) {
        this.getErrorConfigVersion = constraintLayout;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = constraintLayout2;
        this.getAuthRequestContext = viewEmptyStateFeedNotificationBinding;
        this.PlaceComponentResult = ptrClassicFrameLayout;
        this.BuiltInFictitiousFunctionClassFactory = recyclerView;
        this.MyBillsEntityDataFactory = layoutToolbarBinding;
    }

    public static ActivityFeedNotificationBinding MyBillsEntityDataFactory(LayoutInflater layoutInflater) {
        View inflate = layoutInflater.inflate(R.layout.activity_feed_notification, (ViewGroup) null, false);
        int i = R.id.f3661cl_feed_notification;
        ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.f3661cl_feed_notification);
        if (constraintLayout != null) {
            View BuiltInFictitiousFunctionClassFactory = ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.included_view_empty_state_view);
            if (BuiltInFictitiousFunctionClassFactory != null) {
                ViewEmptyStateFeedNotificationBinding BuiltInFictitiousFunctionClassFactory2 = ViewEmptyStateFeedNotificationBinding.BuiltInFictitiousFunctionClassFactory(BuiltInFictitiousFunctionClassFactory);
                PtrClassicFrameLayout ptrClassicFrameLayout = (PtrClassicFrameLayout) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.ptr_feed_notification);
                if (ptrClassicFrameLayout != null) {
                    RecyclerView recyclerView = (RecyclerView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.rv_feed_notification_list);
                    if (recyclerView != null) {
                        View BuiltInFictitiousFunctionClassFactory3 = ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.tb_feed_notification);
                        if (BuiltInFictitiousFunctionClassFactory3 != null) {
                            return new ActivityFeedNotificationBinding((ConstraintLayout) inflate, constraintLayout, BuiltInFictitiousFunctionClassFactory2, ptrClassicFrameLayout, recyclerView, LayoutToolbarBinding.MyBillsEntityDataFactory(BuiltInFictitiousFunctionClassFactory3));
                        }
                        i = R.id.tb_feed_notification;
                    } else {
                        i = R.id.rv_feed_notification_list;
                    }
                } else {
                    i = R.id.ptr_feed_notification;
                }
            } else {
                i = R.id.included_view_empty_state_view;
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(inflate.getResources().getResourceName(i)));
    }

    @Override // androidx.viewbinding.ViewBinding
    public final /* bridge */ /* synthetic */ View KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.getErrorConfigVersion;
    }
}
