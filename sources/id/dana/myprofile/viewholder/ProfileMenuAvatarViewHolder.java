package id.dana.myprofile.viewholder;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import de.hdodenhof.circleimageview.CircleImageView;
import id.dana.R;
import id.dana.base.BaseRecyclerViewHolder;
import id.dana.core.ui.glide.GlideApp;
import id.dana.domain.profilemenu.model.SettingModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"Lid/dana/myprofile/viewholder/ProfileMenuAvatarViewHolder;", "Lid/dana/base/BaseRecyclerViewHolder;", "Lid/dana/domain/profilemenu/model/SettingModel;", "Lid/dana/base/BaseRecyclerViewHolder$OnItemClickListener;", "p0", "", "setOnItemClickListener", "(Lid/dana/base/BaseRecyclerViewHolder$OnItemClickListener;)V", "Landroid/view/ViewGroup;", "<init>", "(Landroid/view/ViewGroup;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ProfileMenuAvatarViewHolder extends BaseRecyclerViewHolder<SettingModel> {
    @Override // id.dana.base.BaseRecyclerViewHolder
    public final /* synthetic */ void bindData(SettingModel settingModel) {
        SettingModel settingModel2 = settingModel;
        if (settingModel2 != null) {
            TextView textView = (TextView) this.itemView.findViewById(R.id.setDrawValueAboveBar);
            if (textView != null) {
                textView.setText(settingModel2.getTitle());
            }
            GlideApp.getAuthRequestContext(getContext()).MyBillsEntityDataFactory().BuiltInFictitiousFunctionClassFactory(settingModel2.getAvatarUrl()).PlaceComponentResult((int) R.drawable.avatar_placeholder).MyBillsEntityDataFactory((ImageView) ((CircleImageView) this.itemView.findViewById(R.id.res_0x7f0a0fda_abstractbinaryclassannotationandconstantloader_loadannotationsandinitializers_1_annotationvisitorformethod)));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ProfileMenuAvatarViewHolder(ViewGroup viewGroup) {
        super(viewGroup.getContext(), R.layout.item_menu_avatar, viewGroup);
        Intrinsics.checkNotNullParameter(viewGroup, "");
    }

    @Override // id.dana.base.BaseRecyclerViewHolder
    public final void setOnItemClickListener(final BaseRecyclerViewHolder.OnItemClickListener p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        ConstraintLayout constraintLayout = (ConstraintLayout) this.itemView.findViewById(R.id.cl_change_profile_picture);
        if (constraintLayout != null) {
            constraintLayout.setOnClickListener(new View.OnClickListener() { // from class: id.dana.myprofile.viewholder.ProfileMenuAvatarViewHolder$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ProfileMenuAvatarViewHolder.getAuthRequestContext(BaseRecyclerViewHolder.OnItemClickListener.this, this);
                }
            });
        }
    }

    public static /* synthetic */ void getAuthRequestContext(BaseRecyclerViewHolder.OnItemClickListener onItemClickListener, ProfileMenuAvatarViewHolder profileMenuAvatarViewHolder) {
        Intrinsics.checkNotNullParameter(onItemClickListener, "");
        Intrinsics.checkNotNullParameter(profileMenuAvatarViewHolder, "");
        onItemClickListener.onItemClick(profileMenuAvatarViewHolder.getAdapterPosition());
    }
}
