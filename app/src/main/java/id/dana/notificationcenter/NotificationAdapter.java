package id.dana.notificationcenter;

import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import id.dana.base.BaseRecyclerViewAdapter;
import id.dana.base.BaseRecyclerViewHolder;
import id.dana.data.dynamicurl.DynamicUrlWrapper;
import id.dana.notificationcenter.model.NotificationDTO;
import id.dana.notificationcenter.views.NotificationCenterEmptyViewHolder;
import id.dana.notificationcenter.views.NotificationCenterFooterViewHolder;
import id.dana.notificationcenter.views.NotificationCenterViewHolder;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* loaded from: classes5.dex */
public class NotificationAdapter extends BaseRecyclerViewAdapter<BaseRecyclerViewHolder<NotificationDTO>, NotificationDTO> {
    public boolean KClassImpl$Data$declaredNonStaticMembers$2;
    private final DynamicUrlWrapper PlaceComponentResult;

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes3.dex */
    public @interface ViewType {
        public static final int EMPTY = 0;
        public static final int FOOTER = 2;
        public static final int NORMAL = 1;
    }

    public NotificationAdapter(DynamicUrlWrapper dynamicUrlWrapper) {
        this.PlaceComponentResult = dynamicUrlWrapper;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        if (getItems() == null || getItems().isEmpty()) {
            return 0;
        }
        return (this.KClassImpl$Data$declaredNonStaticMembers$2 && i == getPlaceComponentResult() - 1) ? 2 : 1;
    }

    @Override // id.dana.base.BaseRecyclerViewAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: getItemCount */
    public int getPlaceComponentResult() {
        if (getItems() == null || getItems().isEmpty()) {
            return 1;
        }
        return super.getPlaceComponentResult() + (this.KClassImpl$Data$declaredNonStaticMembers$2 ? 1 : 0);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public /* synthetic */ RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        if (i != 1) {
            if (i == 2) {
                return new NotificationCenterFooterViewHolder(viewGroup.getContext(), viewGroup);
            }
            return new NotificationCenterEmptyViewHolder(viewGroup.getContext(), viewGroup);
        }
        return new NotificationCenterViewHolder(viewGroup.getContext(), viewGroup, this.PlaceComponentResult);
    }
}
