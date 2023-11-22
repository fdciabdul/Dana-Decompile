package id.dana.userpersonalization.adapter;

import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.fullstory.instrumentation.InstrumentInjector;
import id.dana.R;
import id.dana.base.BaseRecyclerViewAdapter;
import id.dana.base.BaseRecyclerViewHolder;
import id.dana.core.ui.glide.GlideApp;
import id.dana.userpersonalization.model.UserPersonalizationWrapper;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u00002\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\nB\u0007¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"Lid/dana/userpersonalization/adapter/UserPersonalizationAdapter;", "Lid/dana/base/BaseRecyclerViewAdapter;", "Lid/dana/base/BaseRecyclerViewHolder;", "Lid/dana/userpersonalization/model/UserPersonalizationWrapper;", "", "p0", "getItemViewType", "(I)I", "<init>", "()V", "UserPersonalizationItemViewHolder"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class UserPersonalizationAdapter extends BaseRecyclerViewAdapter<BaseRecyclerViewHolder<UserPersonalizationWrapper>, UserPersonalizationWrapper> {
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final /* synthetic */ RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        UserPersonalizationLoadingViewHolder userPersonalizationLoadingViewHolder;
        Intrinsics.checkNotNullParameter(viewGroup, "");
        if (i == 0) {
            userPersonalizationLoadingViewHolder = new UserPersonalizationLoadingViewHolder(viewGroup);
        } else if (i == 1) {
            userPersonalizationLoadingViewHolder = new UserPersonalizationItemViewHolder(viewGroup);
        } else {
            userPersonalizationLoadingViewHolder = new UserPersonalizationLoadingViewHolder(viewGroup);
        }
        return userPersonalizationLoadingViewHolder;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemViewType(int p0) {
        return getItems().get(p0).PlaceComponentResult;
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lid/dana/userpersonalization/adapter/UserPersonalizationAdapter$UserPersonalizationItemViewHolder;", "Lid/dana/base/BaseRecyclerViewHolder;", "Lid/dana/userpersonalization/model/UserPersonalizationWrapper;", "Landroid/view/ViewGroup;", "p0", "<init>", "(Landroid/view/ViewGroup;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class UserPersonalizationItemViewHolder extends BaseRecyclerViewHolder<UserPersonalizationWrapper> {
        @Override // id.dana.base.BaseRecyclerViewHolder
        public final /* synthetic */ void bindData(UserPersonalizationWrapper userPersonalizationWrapper) {
            UserPersonalizationWrapper userPersonalizationWrapper2 = userPersonalizationWrapper;
            super.bindData(userPersonalizationWrapper2);
            if (userPersonalizationWrapper2 != null) {
                TextView textView = (TextView) this.itemView.findViewById(R.id.tvUserPersonalizationTitle);
                if (textView != null) {
                    textView.setText(userPersonalizationWrapper2.MyBillsEntityDataFactory.getDisplayName());
                }
                String iconUrl = userPersonalizationWrapper2.MyBillsEntityDataFactory.getIconUrl();
                if (iconUrl.length() > 0) {
                    GlideApp.getAuthRequestContext(getContext()).PlaceComponentResult(iconUrl).getErrorConfigVersion((int) R.drawable.ic_user_personalization_placeholder).PlaceComponentResult((int) R.drawable.ic_user_personalization_placeholder).MyBillsEntityDataFactory((ImageView) this.itemView.findViewById(R.id.res_0x7f0a0a5e_nearbyplaceentityrepository_externalsyntheticlambda1));
                    return;
                }
                ImageView imageView = (ImageView) this.itemView.findViewById(R.id.res_0x7f0a0a5e_nearbyplaceentityrepository_externalsyntheticlambda1);
                if (imageView != null) {
                    InstrumentInjector.Resources_setImageResource(imageView, R.drawable.ic_user_personalization_placeholder);
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public UserPersonalizationItemViewHolder(ViewGroup viewGroup) {
            super(viewGroup.getContext(), R.layout.item_user_personalization, viewGroup);
            Intrinsics.checkNotNullParameter(viewGroup, "");
        }
    }
}
