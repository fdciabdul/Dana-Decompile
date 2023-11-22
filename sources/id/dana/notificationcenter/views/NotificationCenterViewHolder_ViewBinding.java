package id.dana.notificationcenter.views;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import id.dana.R;

/* loaded from: classes9.dex */
public class NotificationCenterViewHolder_ViewBinding implements Unbinder {
    private NotificationCenterViewHolder getAuthRequestContext;

    public NotificationCenterViewHolder_ViewBinding(NotificationCenterViewHolder notificationCenterViewHolder, View view) {
        this.getAuthRequestContext = notificationCenterViewHolder;
        notificationCenterViewHolder.content = (TextView) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, R.id.notification_content, "field 'content'", TextView.class);
        notificationCenterViewHolder.iconNotification = (ImageView) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, R.id.notification_icon, "field 'iconNotification'", ImageView.class);
        notificationCenterViewHolder.notificationBadge = (LinearLayout) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, R.id.notification_badge, "field 'notificationBadge'", LinearLayout.class);
        notificationCenterViewHolder.notificationWrapper = (RelativeLayout) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, R.id.notification_wrapper, "field 'notificationWrapper'", RelativeLayout.class);
        notificationCenterViewHolder.time = (TextView) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, R.id.notification_time, "field 'time'", TextView.class);
    }

    @Override // butterknife.Unbinder
    public final void getAuthRequestContext() {
        NotificationCenterViewHolder notificationCenterViewHolder = this.getAuthRequestContext;
        if (notificationCenterViewHolder == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.getAuthRequestContext = null;
        notificationCenterViewHolder.content = null;
        notificationCenterViewHolder.iconNotification = null;
        notificationCenterViewHolder.notificationBadge = null;
        notificationCenterViewHolder.notificationWrapper = null;
        notificationCenterViewHolder.time = null;
    }
}
