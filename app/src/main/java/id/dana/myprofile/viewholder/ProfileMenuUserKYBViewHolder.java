package id.dana.myprofile.viewholder;

import android.view.View;
import android.view.ViewGroup;
import butterknife.BindView;
import id.dana.R;
import id.dana.base.BaseRecyclerViewHolder;
import id.dana.domain.profilemenu.model.SettingModel;
import id.dana.richview.KybCardView;

/* loaded from: classes5.dex */
public class ProfileMenuUserKYBViewHolder extends BaseRecyclerViewHolder<SettingModel> {
    @BindView(R.id.cardview_kyb)
    KybCardView kybCardView;

    @Override // id.dana.base.BaseRecyclerViewHolder
    public /* synthetic */ void bindData(SettingModel settingModel) {
        SettingModel settingModel2 = settingModel;
        if (settingModel2 != null) {
            this.kybCardView.setCircleMarkVisibility(KClassImpl$Data$declaredNonStaticMembers$2(settingModel2));
            this.kybCardView.setKybHeaderText(settingModel2.getTitle());
            this.kybCardView.setKybBodyText(settingModel2.getSubtitle());
            this.kybCardView.setKybSubtitleColor(settingModel2.getSubtitleColor());
            this.kybCardView.setContentDescription(getContext().getString(R.string.btn_kyb));
        }
    }

    public ProfileMenuUserKYBViewHolder(ViewGroup viewGroup) {
        super(viewGroup.getContext(), R.layout.item_profile_setting_user_kyb, viewGroup);
    }

    @Override // id.dana.base.BaseRecyclerViewHolder
    public void setOnItemClickListener(final BaseRecyclerViewHolder.OnItemClickListener onItemClickListener) {
        this.kybCardView.setOnClickListener(new View.OnClickListener() { // from class: id.dana.myprofile.viewholder.ProfileMenuUserKYBViewHolder$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                onItemClickListener.onItemClick(ProfileMenuUserKYBViewHolder.this.getAdapterPosition());
            }
        });
    }

    private static boolean KClassImpl$Data$declaredNonStaticMembers$2(SettingModel settingModel) {
        return settingModel.isKycRevoked() || settingModel.isKybRevoked();
    }
}
