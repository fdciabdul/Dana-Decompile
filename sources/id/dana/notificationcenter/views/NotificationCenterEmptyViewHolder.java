package id.dana.notificationcenter.views;

import android.content.Context;
import android.view.ViewGroup;
import id.dana.R;
import id.dana.base.BaseRecyclerViewHolder;
import id.dana.notificationcenter.model.NotificationDTO;

/* loaded from: classes5.dex */
public class NotificationCenterEmptyViewHolder extends BaseRecyclerViewHolder<NotificationDTO> {
    @Override // id.dana.base.BaseRecyclerViewHolder
    public /* bridge */ /* synthetic */ void bindData(NotificationDTO notificationDTO) {
    }

    public NotificationCenterEmptyViewHolder(Context context, ViewGroup viewGroup) {
        super(context, R.layout.placeholder_empty_notification, viewGroup);
    }
}
