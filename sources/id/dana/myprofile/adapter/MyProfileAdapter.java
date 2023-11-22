package id.dana.myprofile.adapter;

import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import id.dana.base.BaseRecyclerViewAdapter;
import id.dana.base.BaseRecyclerViewHolder;
import id.dana.domain.profilemenu.model.SettingModel;
import id.dana.myprofile.viewholder.NewProfileMenuChatbotViewHolder;
import id.dana.myprofile.viewholder.ProfileMenuAppVersionViewHolder;
import id.dana.myprofile.viewholder.ProfileMenuAutoSwitchViewHolder;
import id.dana.myprofile.viewholder.ProfileMenuAvatarViewHolder;
import id.dana.myprofile.viewholder.ProfileMenuDefferedViewHolder;
import id.dana.myprofile.viewholder.ProfileMenuFaceAuthViewHolder;
import id.dana.myprofile.viewholder.ProfileMenuFeedSharingViewHolder;
import id.dana.myprofile.viewholder.ProfileMenuHeaderViewHolder;
import id.dana.myprofile.viewholder.ProfileMenuMerchantManagementViewHolder;
import id.dana.myprofile.viewholder.ProfileMenuPaymentAuthViewHolder;
import id.dana.myprofile.viewholder.ProfileMenuShareFeedViewHolder;
import id.dana.myprofile.viewholder.ProfileMenuUserKYBViewHolder;
import id.dana.myprofile.viewholder.ProfileMenuUserServiceViewHolder;
import id.dana.myprofile.viewholder.ProfileMenuUsernameViewHolder;

/* loaded from: classes5.dex */
public class MyProfileAdapter extends BaseRecyclerViewAdapter<BaseRecyclerViewHolder<SettingModel>, SettingModel> {
    @Override // id.dana.base.BaseRecyclerViewAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    public /* bridge */ /* synthetic */ void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        onBindViewHolder((MyProfileAdapter) ((BaseRecyclerViewHolder) viewHolder), i);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        return getItem(i).getViewType();
    }

    public final boolean PlaceComponentResult(int i) {
        return i == -1 || i >= getItems().size();
    }

    @Override // id.dana.base.BaseRecyclerViewAdapter
    public void onBindViewHolder(BaseRecyclerViewHolder<SettingModel> baseRecyclerViewHolder, int i) {
        baseRecyclerViewHolder.setIsRecyclable(false);
        super.onBindViewHolder((MyProfileAdapter) baseRecyclerViewHolder, i);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public /* synthetic */ RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        if (i != 0) {
            if (i != 11) {
                if (i != 27) {
                    switch (i) {
                        case 3:
                            return new ProfileMenuUserKYBViewHolder(viewGroup);
                        case 4:
                            return new ProfileMenuAppVersionViewHolder(viewGroup);
                        case 5:
                            return new ProfileMenuAvatarViewHolder(viewGroup);
                        case 6:
                            return new ProfileMenuPaymentAuthViewHolder(viewGroup);
                        case 7:
                            return new ProfileMenuDefferedViewHolder(viewGroup);
                        case 8:
                            return new ProfileMenuShareFeedViewHolder(viewGroup);
                        case 9:
                            return new ProfileMenuFaceAuthViewHolder(viewGroup);
                        default:
                            switch (i) {
                                case 14:
                                    return new ProfileMenuFeedSharingViewHolder(viewGroup);
                                case 15:
                                    return new ProfileMenuAutoSwitchViewHolder(viewGroup);
                                case 16:
                                    return new ProfileMenuUsernameViewHolder(viewGroup);
                                default:
                                    return new ProfileMenuUserServiceViewHolder(viewGroup);
                            }
                    }
                }
                return new NewProfileMenuChatbotViewHolder(viewGroup);
            }
            return new ProfileMenuMerchantManagementViewHolder(viewGroup);
        }
        return new ProfileMenuHeaderViewHolder(viewGroup);
    }
}
