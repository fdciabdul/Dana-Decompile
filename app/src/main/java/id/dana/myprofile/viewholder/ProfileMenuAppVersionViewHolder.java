package id.dana.myprofile.viewholder;

import android.view.ViewGroup;
import android.widget.TextView;
import butterknife.BindView;
import id.dana.R;
import id.dana.base.BaseRecyclerViewHolder;
import id.dana.domain.profilemenu.model.SettingModel;

/* loaded from: classes5.dex */
public class ProfileMenuAppVersionViewHolder extends BaseRecyclerViewHolder<SettingModel> {
    @BindView(R.id.tv_title)
    TextView title;
    @BindView(R.id.tv_sub_menu)
    TextView tvSubMenu;

    @Override // id.dana.base.BaseRecyclerViewHolder
    public void setOnItemClickListener(BaseRecyclerViewHolder.OnItemClickListener onItemClickListener) {
    }

    @Override // id.dana.base.BaseRecyclerViewHolder
    public /* synthetic */ void bindData(SettingModel settingModel) {
        SettingModel settingModel2 = settingModel;
        if (settingModel2 != null) {
            this.title.setText(settingModel2.getTitle());
            this.itemView.setContentDescription(getContext().getString(R.string.lbl_app_version));
            this.tvSubMenu.setText(settingModel2.getSubtitle());
        }
    }

    public ProfileMenuAppVersionViewHolder(ViewGroup viewGroup) {
        super(viewGroup.getContext(), R.layout.item_menu_app_version, viewGroup);
    }
}
