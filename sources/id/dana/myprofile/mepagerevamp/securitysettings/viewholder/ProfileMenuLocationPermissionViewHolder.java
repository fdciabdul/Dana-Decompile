package id.dana.myprofile.mepagerevamp.securitysettings.viewholder;

import android.view.View;
import id.dana.R;
import id.dana.base.BaseRecyclerViewHolder;
import id.dana.base.viewbinding.ViewBindingRecyclerViewHolder;
import id.dana.databinding.ItemSwitchLocationPermissionBinding;
import id.dana.domain.profilemenu.model.SettingModel;
import id.dana.myprofile.mepagerevamp.securitysettings.view.SwitchLocationPermissionView;
import id.dana.richview.BlueSwitchView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u000f\u0012\u0006\u0010\b\u001a\u00020\u000f¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0019\u0010\t\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016¢\u0006\u0004\b\t\u0010\nR\u0014\u0010\u000e\u001a\u00020\u000b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\r"}, d2 = {"Lid/dana/myprofile/mepagerevamp/securitysettings/viewholder/ProfileMenuLocationPermissionViewHolder;", "Lid/dana/base/viewbinding/ViewBindingRecyclerViewHolder;", "Lid/dana/domain/profilemenu/model/SettingModel;", "Lid/dana/databinding/ItemSwitchLocationPermissionBinding;", "", "dispose", "()V", "Lid/dana/base/BaseRecyclerViewHolder$OnItemClickListener;", "p0", "setOnItemClickListener", "(Lid/dana/base/BaseRecyclerViewHolder$OnItemClickListener;)V", "Lid/dana/myprofile/mepagerevamp/securitysettings/view/SwitchLocationPermissionView;", "KClassImpl$Data$declaredNonStaticMembers$2", "Lid/dana/myprofile/mepagerevamp/securitysettings/view/SwitchLocationPermissionView;", "MyBillsEntityDataFactory", "Landroid/view/ViewGroup;", "<init>", "(Landroid/view/ViewGroup;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ProfileMenuLocationPermissionViewHolder extends ViewBindingRecyclerViewHolder<SettingModel, ItemSwitchLocationPermissionBinding> {

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    public final SwitchLocationPermissionView MyBillsEntityDataFactory;

    @Override // id.dana.base.BaseRecyclerViewHolder
    public final /* synthetic */ void bindData(Object obj) {
        this.MyBillsEntityDataFactory.onBind((SettingModel) obj);
    }

    @Override // id.dana.base.viewbinding.ViewBindingRecyclerViewHolder
    public final /* synthetic */ ItemSwitchLocationPermissionBinding initViewBinding(View view) {
        Intrinsics.checkNotNullParameter(view, "");
        ItemSwitchLocationPermissionBinding PlaceComponentResult = ItemSwitchLocationPermissionBinding.PlaceComponentResult(view);
        Intrinsics.checkNotNullExpressionValue(PlaceComponentResult, "");
        return PlaceComponentResult;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public ProfileMenuLocationPermissionViewHolder(android.view.ViewGroup r4) {
        /*
            r3 = this;
            java.lang.String r0 = ""
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            android.content.Context r1 = r4.getContext()
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r0)
            r2 = 2131559279(0x7f0d036f, float:1.8743898E38)
            r3.<init>(r1, r2, r4)
            android.view.View r4 = r3.itemView
            int r1 = id.dana.R.id.res_0x7f0a1b60_com_alibaba_ariver_engine_api_extopt_8
            android.view.View r4 = r4.findViewById(r1)
            id.dana.myprofile.mepagerevamp.securitysettings.view.SwitchLocationPermissionView r4 = (id.dana.myprofile.mepagerevamp.securitysettings.view.SwitchLocationPermissionView) r4
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r0)
            r3.MyBillsEntityDataFactory = r4
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.myprofile.mepagerevamp.securitysettings.viewholder.ProfileMenuLocationPermissionViewHolder.<init>(android.view.ViewGroup):void");
    }

    @Override // id.dana.base.BaseRecyclerViewHolder
    public final void setOnItemClickListener(final BaseRecyclerViewHolder.OnItemClickListener p0) {
        super.setOnItemClickListener(p0);
        ((BlueSwitchView) this.itemView.findViewById(R.id.sv_enable_location_permission)).setOnClickListener(new View.OnClickListener() { // from class: id.dana.myprofile.mepagerevamp.securitysettings.viewholder.ProfileMenuLocationPermissionViewHolder$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ProfileMenuLocationPermissionViewHolder.PlaceComponentResult(BaseRecyclerViewHolder.OnItemClickListener.this, this);
            }
        });
    }

    @Override // id.dana.base.viewbinding.ViewBindingRecyclerViewHolder, id.dana.base.BaseRecyclerViewHolder
    public final void dispose() {
        super.dispose();
        this.MyBillsEntityDataFactory.disposePresenter();
    }

    public static /* synthetic */ void PlaceComponentResult(BaseRecyclerViewHolder.OnItemClickListener onItemClickListener, ProfileMenuLocationPermissionViewHolder profileMenuLocationPermissionViewHolder) {
        Intrinsics.checkNotNullParameter(profileMenuLocationPermissionViewHolder, "");
        if (onItemClickListener != null) {
            onItemClickListener.onItemClick(profileMenuLocationPermissionViewHolder.getBindingAdapterPosition());
        }
    }
}
