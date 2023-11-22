package id.dana.social.v2.viewholder;

import android.graphics.PorterDuff;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.core.content.ContextCompat;
import de.hdodenhof.circleimageview.CircleImageView;
import id.dana.R;
import id.dana.base.BaseRecyclerViewHolder;
import id.dana.core.ui.glide.GlideApp;
import id.dana.feeds.ui.model.FriendModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lid/dana/social/v2/viewholder/FriendViewHolder;", "Lid/dana/base/BaseRecyclerViewHolder;", "Lid/dana/feeds/ui/model/FriendModel;", "Landroid/view/ViewGroup;", "p0", "<init>", "(Landroid/view/ViewGroup;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class FriendViewHolder extends BaseRecyclerViewHolder<FriendModel> {
    @Override // id.dana.base.BaseRecyclerViewHolder
    public final /* synthetic */ void bindData(FriendModel friendModel) {
        FriendModel friendModel2 = friendModel;
        if (friendModel2 != null) {
            CircleImageView circleImageView = (CircleImageView) this.itemView.findViewById(R.id.res_0x7f0a0a5c_nearbyplaceentityrepository_externalsyntheticlambda0);
            if (circleImageView != null) {
                GlideApp.getAuthRequestContext(circleImageView.getContext()).MyBillsEntityDataFactory().BuiltInFictitiousFunctionClassFactory(friendModel2.getErrorConfigVersion).getErrorConfigVersion((int) R.drawable.ic_feed_default_user_avatar).PlaceComponentResult((int) R.drawable.ic_feed_default_user_avatar).MyBillsEntityDataFactory((ImageView) circleImageView);
            }
            if (friendModel2.getPlaceComponentResult()) {
                AppCompatImageView appCompatImageView = (AppCompatImageView) this.itemView.findViewById(R.id.ivOwnProfileIcon);
                if (appCompatImageView != null) {
                    appCompatImageView.setVisibility(0);
                }
                CircleImageView circleImageView2 = (CircleImageView) this.itemView.findViewById(R.id.res_0x7f0a0a5c_nearbyplaceentityrepository_externalsyntheticlambda0);
                if (circleImageView2 != null) {
                    CircleImageView circleImageView3 = circleImageView2;
                    circleImageView3.setColorFilter(ContextCompat.BuiltInFictitiousFunctionClassFactory(circleImageView3.getContext(), R.color.f22692131099709), PorterDuff.Mode.SRC_OVER);
                }
                CircleImageView circleImageView4 = (CircleImageView) this.itemView.findViewById(R.id.res_0x7f0a0a5c_nearbyplaceentityrepository_externalsyntheticlambda0);
                if (circleImageView4 != null) {
                    circleImageView4.setBorderColor(ContextCompat.BuiltInFictitiousFunctionClassFactory(getContext(), R.color.f23842131099944));
                    return;
                }
                return;
            }
            AppCompatImageView appCompatImageView2 = (AppCompatImageView) this.itemView.findViewById(R.id.ivOwnProfileIcon);
            if (appCompatImageView2 != null) {
                appCompatImageView2.setVisibility(8);
            }
            CircleImageView circleImageView5 = (CircleImageView) this.itemView.findViewById(R.id.res_0x7f0a0a5c_nearbyplaceentityrepository_externalsyntheticlambda0);
            if (circleImageView5 != null) {
                circleImageView5.clearColorFilter();
            }
            CircleImageView circleImageView6 = (CircleImageView) this.itemView.findViewById(R.id.res_0x7f0a0a5c_nearbyplaceentityrepository_externalsyntheticlambda0);
            if (circleImageView6 != null) {
                circleImageView6.setBorderColor(ContextCompat.BuiltInFictitiousFunctionClassFactory(getContext(), R.color.MyBillsEntityDataFactory_res_0x7f060157));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FriendViewHolder(ViewGroup viewGroup) {
        super(viewGroup.getContext(), R.layout.view_top_friend_item, viewGroup);
        Intrinsics.checkNotNullParameter(viewGroup, "");
    }
}
