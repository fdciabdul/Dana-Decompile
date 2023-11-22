package id.dana.myprofile.viewholder;

import android.view.View;
import android.view.ViewGroup;
import id.dana.R;
import id.dana.base.BaseRecyclerViewHolder;
import id.dana.base.viewbinding.ViewBindingRecyclerViewHolder;
import id.dana.databinding.ItemProfileSettingUserServiceBinding;
import id.dana.domain.profilemenu.model.SettingModel;

/* loaded from: classes5.dex */
public class ProfileMenuUserServiceViewHolder extends ViewBindingRecyclerViewHolder<SettingModel, ItemProfileSettingUserServiceBinding> {
    public ProfileMenuUserServiceViewHolder(ViewGroup viewGroup) {
        super(viewGroup.getContext(), R.layout.item_profile_setting_user_service, viewGroup);
    }

    @Override // id.dana.base.BaseRecyclerViewHolder
    public void setOnItemClickListener(final BaseRecyclerViewHolder.OnItemClickListener onItemClickListener) {
        getBinding().MyBillsEntityDataFactory.setOnClickListener(new View.OnClickListener() { // from class: id.dana.myprofile.viewholder.ProfileMenuUserServiceViewHolder$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                onItemClickListener.onItemClick(ProfileMenuUserServiceViewHolder.this.getAdapterPosition());
            }
        });
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x0087, code lost:
    
        if (r0.equals(id.dana.myprofile.ProfileUserServiceType.LOGOUT) != false) goto L39;
     */
    @Override // id.dana.base.BaseRecyclerViewHolder
    /* renamed from: MyBillsEntityDataFactory  reason: merged with bridge method [inline-methods] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void bindData(id.dana.domain.profilemenu.model.SettingModel r9) {
        /*
            Method dump skipped, instructions count: 420
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.myprofile.viewholder.ProfileMenuUserServiceViewHolder.bindData(id.dana.domain.profilemenu.model.SettingModel):void");
    }

    @Override // id.dana.base.viewbinding.ViewBindingRecyclerViewHolder
    public /* synthetic */ ItemProfileSettingUserServiceBinding initViewBinding(View view) {
        return ItemProfileSettingUserServiceBinding.MyBillsEntityDataFactory(view);
    }
}
