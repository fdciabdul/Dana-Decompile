package id.dana.myprofile.viewholder;

import android.view.View;
import android.view.ViewGroup;
import butterknife.BindView;
import id.dana.R;
import id.dana.base.BaseRecyclerViewHolder;
import id.dana.domain.profilemenu.model.SettingModel;
import id.dana.richview.profile.ProfileSettingUserServiceView;

/* loaded from: classes5.dex */
public class ProfileMenuDefferedViewHolder extends BaseRecyclerViewHolder<SettingModel> {
    @BindView(R.id.view_profile_setting_user_service)
    ProfileSettingUserServiceView viewProfileSetting;

    @Override // id.dana.base.BaseRecyclerViewHolder
    public /* synthetic */ void bindData(SettingModel settingModel) {
        SettingModel settingModel2 = settingModel;
        this.itemView.setVisibility((settingModel2.isNeedToShow() && settingModel2.isEnable()) ? 0 : 8);
        this.viewProfileSetting.setParentViewVisibility((settingModel2.isNeedToShow() && settingModel2.isEnable()) ? 0 : 8);
        this.viewProfileSetting.setView(settingModel2.getTitle(), settingModel2.getSubtitle(), settingModel2.getName(), settingModel2.getIconUrl(), settingModel2.getSubtitleIsBelow(), settingModel2.getSubtitleColor());
    }

    public ProfileMenuDefferedViewHolder(ViewGroup viewGroup) {
        super(viewGroup.getContext(), R.layout.item_profile_setting_user_service, viewGroup);
    }

    @Override // id.dana.base.BaseRecyclerViewHolder
    public void setOnItemClickListener(final BaseRecyclerViewHolder.OnItemClickListener onItemClickListener) {
        this.viewProfileSetting.setOnClickListener(new View.OnClickListener() { // from class: id.dana.myprofile.viewholder.ProfileMenuDefferedViewHolder$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                onItemClickListener.onItemClick(ProfileMenuDefferedViewHolder.this.getAdapterPosition());
            }
        });
    }
}
