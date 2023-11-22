package id.dana.myprofile.mepagerevamp.securitysettings.viewholder;

import android.view.View;
import android.view.ViewGroup;
import id.dana.R;
import id.dana.base.BaseRecyclerViewHolder;
import id.dana.domain.profilemenu.model.SettingModel;
import id.dana.myprofile.mepagerevamp.securitysettings.view.NewSwitchFaceAuthenticationView;
import id.dana.richview.BlueSwitchView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001:\u0001\u0014B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0011¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J\u0019\u0010\b\u001a\u00020\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016¢\u0006\u0004\b\b\u0010\tR\u0018\u0010\r\u001a\u0004\u0018\u00010\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0014\u0010\u000b\u001a\u00020\u000e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010"}, d2 = {"Lid/dana/myprofile/mepagerevamp/securitysettings/viewholder/NewProfileMenuFaceAuthViewHolder;", "Lid/dana/base/BaseRecyclerViewHolder;", "Lid/dana/domain/profilemenu/model/SettingModel;", "", "dispose", "()V", "Lid/dana/base/BaseRecyclerViewHolder$OnItemClickListener;", "p0", "setOnItemClickListener", "(Lid/dana/base/BaseRecyclerViewHolder$OnItemClickListener;)V", "Lid/dana/myprofile/mepagerevamp/securitysettings/viewholder/NewProfileMenuFaceAuthViewHolder$CheckedListener;", "MyBillsEntityDataFactory", "Lid/dana/myprofile/mepagerevamp/securitysettings/viewholder/NewProfileMenuFaceAuthViewHolder$CheckedListener;", "KClassImpl$Data$declaredNonStaticMembers$2", "Lid/dana/myprofile/mepagerevamp/securitysettings/view/NewSwitchFaceAuthenticationView;", "PlaceComponentResult", "Lid/dana/myprofile/mepagerevamp/securitysettings/view/NewSwitchFaceAuthenticationView;", "Landroid/view/ViewGroup;", "<init>", "(Landroid/view/ViewGroup;)V", "CheckedListener"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class NewProfileMenuFaceAuthViewHolder extends BaseRecyclerViewHolder<SettingModel> {

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    public CheckedListener KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    public final NewSwitchFaceAuthenticationView MyBillsEntityDataFactory;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bæ\u0080\u0001\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/myprofile/mepagerevamp/securitysettings/viewholder/NewProfileMenuFaceAuthViewHolder$CheckedListener;", "", "", "p0", "", "MyBillsEntityDataFactory", "(Z)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public interface CheckedListener {
        void MyBillsEntityDataFactory(boolean p0);
    }

    @Override // id.dana.base.BaseRecyclerViewHolder
    public final /* synthetic */ void bindData(SettingModel settingModel) {
        this.MyBillsEntityDataFactory.onBind(settingModel);
        this.MyBillsEntityDataFactory.setAuthListener(new NewSwitchFaceAuthenticationView.AuthFaceListener() { // from class: id.dana.myprofile.mepagerevamp.securitysettings.viewholder.NewProfileMenuFaceAuthViewHolder$$ExternalSyntheticLambda1
            @Override // id.dana.myprofile.mepagerevamp.securitysettings.view.NewSwitchFaceAuthenticationView.AuthFaceListener
            public final void getAuthRequestContext() {
                NewProfileMenuFaceAuthViewHolder.PlaceComponentResult(NewProfileMenuFaceAuthViewHolder.this);
            }
        });
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NewProfileMenuFaceAuthViewHolder(ViewGroup viewGroup) {
        super(viewGroup.getContext(), R.layout.new_item_authentication_switchfaceauth, viewGroup);
        Intrinsics.checkNotNullParameter(viewGroup, "");
        NewSwitchFaceAuthenticationView newSwitchFaceAuthenticationView = (NewSwitchFaceAuthenticationView) this.itemView.findViewById(R.id.view_authentication_switch);
        Intrinsics.checkNotNullExpressionValue(newSwitchFaceAuthenticationView, "");
        this.MyBillsEntityDataFactory = newSwitchFaceAuthenticationView;
    }

    @Override // id.dana.base.BaseRecyclerViewHolder
    public final void setOnItemClickListener(final BaseRecyclerViewHolder.OnItemClickListener p0) {
        super.setOnItemClickListener(p0);
        ((BlueSwitchView) this.itemView.findViewById(R.id.sv_enable_face_auth)).setOnClickListener(new View.OnClickListener() { // from class: id.dana.myprofile.mepagerevamp.securitysettings.viewholder.NewProfileMenuFaceAuthViewHolder$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                NewProfileMenuFaceAuthViewHolder.BuiltInFictitiousFunctionClassFactory(BaseRecyclerViewHolder.OnItemClickListener.this, this);
            }
        });
    }

    @Override // id.dana.base.BaseRecyclerViewHolder
    public final void dispose() {
        super.dispose();
        this.MyBillsEntityDataFactory.disposePresenter();
    }

    public static /* synthetic */ void BuiltInFictitiousFunctionClassFactory(BaseRecyclerViewHolder.OnItemClickListener onItemClickListener, NewProfileMenuFaceAuthViewHolder newProfileMenuFaceAuthViewHolder) {
        Intrinsics.checkNotNullParameter(newProfileMenuFaceAuthViewHolder, "");
        if (onItemClickListener != null) {
            onItemClickListener.onItemClick(newProfileMenuFaceAuthViewHolder.getBindingAdapterPosition());
        }
    }

    public static /* synthetic */ void PlaceComponentResult(NewProfileMenuFaceAuthViewHolder newProfileMenuFaceAuthViewHolder) {
        Intrinsics.checkNotNullParameter(newProfileMenuFaceAuthViewHolder, "");
        CheckedListener checkedListener = newProfileMenuFaceAuthViewHolder.KClassImpl$Data$declaredNonStaticMembers$2;
        if (checkedListener != null) {
            checkedListener.MyBillsEntityDataFactory(true);
        }
    }
}
