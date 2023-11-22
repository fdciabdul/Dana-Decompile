package id.dana.myprofile.viewholder;

import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import id.dana.R;
import id.dana.base.BaseRecyclerViewHolder;
import id.dana.domain.profilemenu.model.SettingModel;
import id.dana.myprofile.adapter.MyProfileDiffutilAdapter;
import id.dana.myprofile.mepagerevamp.GroupedSettingItemClickListener;
import id.dana.utils.CustomLinearLayoutManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0013¢\u0006\u0004\b\u0014\u0010\u0015J\u0019\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R\u0018\u0010\u000b\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\t\u0010\nR\u0018\u0010\u000f\u001a\u0004\u0018\u00010\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000f\u0010\u0011"}, d2 = {"Lid/dana/myprofile/viewholder/ProfileSettingGroupViewHolder;", "Lid/dana/base/BaseRecyclerViewHolder;", "Lid/dana/domain/profilemenu/model/SettingModel;", "Lid/dana/base/BaseRecyclerViewHolder$OnItemClickListener;", "p0", "", "setOnItemClickListener", "(Lid/dana/base/BaseRecyclerViewHolder$OnItemClickListener;)V", "Lid/dana/myprofile/adapter/MyProfileDiffutilAdapter;", "getAuthRequestContext", "Lid/dana/myprofile/adapter/MyProfileDiffutilAdapter;", "PlaceComponentResult", "Lid/dana/myprofile/mepagerevamp/GroupedSettingItemClickListener;", "MyBillsEntityDataFactory", "Lid/dana/myprofile/mepagerevamp/GroupedSettingItemClickListener;", "KClassImpl$Data$declaredNonStaticMembers$2", "Lid/dana/myprofile/adapter/MyProfileDiffutilAdapter$RedDotListener;", "Lid/dana/myprofile/adapter/MyProfileDiffutilAdapter$RedDotListener;", "BuiltInFictitiousFunctionClassFactory", "Landroid/view/ViewGroup;", "<init>", "(Landroid/view/ViewGroup;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ProfileSettingGroupViewHolder extends BaseRecyclerViewHolder<SettingModel> {

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    public MyProfileDiffutilAdapter.RedDotListener BuiltInFictitiousFunctionClassFactory;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private GroupedSettingItemClickListener KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    private MyProfileDiffutilAdapter PlaceComponentResult;

    @Override // id.dana.base.BaseRecyclerViewHolder
    public final /* synthetic */ void bindData(SettingModel settingModel) {
        final SettingModel settingModel2 = settingModel;
        if (settingModel2 == null || settingModel2.getSettingChilds().isEmpty()) {
            return;
        }
        MyProfileDiffutilAdapter myProfileDiffutilAdapter = new MyProfileDiffutilAdapter();
        this.PlaceComponentResult = myProfileDiffutilAdapter;
        myProfileDiffutilAdapter.PlaceComponentResult = new GroupedSettingItemClickListener() { // from class: id.dana.myprofile.viewholder.ProfileSettingGroupViewHolder$bindData$1
            @Override // id.dana.base.BaseRecyclerViewHolder.OnItemClickListener
            public final void onItemClick(int p0) {
                GroupedSettingItemClickListener groupedSettingItemClickListener;
                SettingModel settingModel3 = SettingModel.this.getSettingChilds().get(p0);
                groupedSettingItemClickListener = this.KClassImpl$Data$declaredNonStaticMembers$2;
                if (groupedSettingItemClickListener != null) {
                    groupedSettingItemClickListener.getAuthRequestContext(settingModel3);
                }
            }

            @Override // id.dana.myprofile.mepagerevamp.GroupedSettingItemClickListener
            public final void getAuthRequestContext(SettingModel p0) {
                GroupedSettingItemClickListener groupedSettingItemClickListener;
                groupedSettingItemClickListener = this.KClassImpl$Data$declaredNonStaticMembers$2;
                if (groupedSettingItemClickListener != null) {
                    groupedSettingItemClickListener.getAuthRequestContext(p0);
                }
            }
        };
        MyProfileDiffutilAdapter myProfileDiffutilAdapter2 = this.PlaceComponentResult;
        if (myProfileDiffutilAdapter2 != null) {
            myProfileDiffutilAdapter2.KClassImpl$Data$declaredNonStaticMembers$2 = this.BuiltInFictitiousFunctionClassFactory;
        }
        RecyclerView recyclerView = (RecyclerView) this.itemView.findViewById(R.id.res_0x7f0a1194_danapolycardsviewmodel_getallrewardlist_2);
        if (recyclerView != null) {
            recyclerView.setLayoutManager(new CustomLinearLayoutManager(recyclerView.getContext()));
            recyclerView.setNestedScrollingEnabled(false);
            recyclerView.setAdapter(this.PlaceComponentResult);
        }
        MyProfileDiffutilAdapter myProfileDiffutilAdapter3 = this.PlaceComponentResult;
        if (myProfileDiffutilAdapter3 != null) {
            myProfileDiffutilAdapter3.getAuthRequestContext.KClassImpl$Data$declaredNonStaticMembers$2(settingModel2.getSettingChilds(), null);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ProfileSettingGroupViewHolder(ViewGroup viewGroup) {
        super(viewGroup.getContext(), R.layout.view_profile_setting_group, viewGroup);
        Intrinsics.checkNotNullParameter(viewGroup, "");
    }

    @Override // id.dana.base.BaseRecyclerViewHolder
    public final void setOnItemClickListener(BaseRecyclerViewHolder.OnItemClickListener p0) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = p0 instanceof GroupedSettingItemClickListener ? (GroupedSettingItemClickListener) p0 : null;
    }
}
