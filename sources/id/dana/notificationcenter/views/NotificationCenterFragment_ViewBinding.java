package id.dana.notificationcenter.views;

import android.view.View;
import android.widget.ProgressBar;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import butterknife.internal.Utils;
import id.dana.R;
import id.dana.base.BaseWithToolbarFragment_ViewBinding;

/* loaded from: classes9.dex */
public class NotificationCenterFragment_ViewBinding extends BaseWithToolbarFragment_ViewBinding {
    private NotificationCenterFragment BuiltInFictitiousFunctionClassFactory;

    public NotificationCenterFragment_ViewBinding(NotificationCenterFragment notificationCenterFragment, View view) {
        super(notificationCenterFragment, view);
        this.BuiltInFictitiousFunctionClassFactory = notificationCenterFragment;
        notificationCenterFragment.progressBar = (ProgressBar) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, R.id.f4080progress_bar, "field 'progressBar'", ProgressBar.class);
        notificationCenterFragment.rcNotifications = (RecyclerView) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, R.id.notication_center_rcview, "field 'rcNotifications'", RecyclerView.class);
        notificationCenterFragment.refreshNotification = (SwipeRefreshLayout) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, R.id.refresh_notification, "field 'refreshNotification'", SwipeRefreshLayout.class);
    }

    @Override // id.dana.base.BaseWithToolbarFragment_ViewBinding, butterknife.Unbinder
    public final void getAuthRequestContext() {
        NotificationCenterFragment notificationCenterFragment = this.BuiltInFictitiousFunctionClassFactory;
        if (notificationCenterFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.BuiltInFictitiousFunctionClassFactory = null;
        notificationCenterFragment.progressBar = null;
        notificationCenterFragment.rcNotifications = null;
        notificationCenterFragment.refreshNotification = null;
        super.getAuthRequestContext();
    }
}
