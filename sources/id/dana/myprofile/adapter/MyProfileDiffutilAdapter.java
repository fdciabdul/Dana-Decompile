package id.dana.myprofile.adapter;

import android.view.ViewGroup;
import androidx.recyclerview.widget.AsyncListDiffer;
import androidx.recyclerview.widget.RecyclerView;
import id.dana.base.BaseRecyclerViewHolder;
import id.dana.domain.profilemenu.model.SettingModel;
import id.dana.myprofile.mepagerevamp.GroupedSettingItemClickListener;
import id.dana.myprofile.model.SettingModelDiffUtil;
import id.dana.myprofile.viewholder.NewProfileCompletionViewHolder;
import id.dana.myprofile.viewholder.NewProfileMenuChatbotViewHolder;
import id.dana.myprofile.viewholder.NewProfileMenuReferralViewHolder;
import id.dana.myprofile.viewholder.NewProfileMenuUserServiceViewHolder;
import id.dana.myprofile.viewholder.NewProfileSettingChildViewHolder;
import id.dana.myprofile.viewholder.ProfileCompletionViewHolder;
import id.dana.myprofile.viewholder.ProfileMenuAppVersionViewHolder;
import id.dana.myprofile.viewholder.ProfileMenuAvatarViewHolder;
import id.dana.myprofile.viewholder.ProfileMenuFamilyAccountViewHolder;
import id.dana.myprofile.viewholder.ProfileMenuHeaderViewHolder;
import id.dana.myprofile.viewholder.ProfileMenuPaymentAuthViewHolder;
import id.dana.myprofile.viewholder.ProfileMenuSettingMoreViewHolder;
import id.dana.myprofile.viewholder.ProfileMenuSettingStatementViewHolder;
import id.dana.myprofile.viewholder.ProfileMenuUserKYBViewHolder;
import id.dana.myprofile.viewholder.ProfileMenuUserServiceViewHolder;
import id.dana.myprofile.viewholder.ProfileSettingGroupViewHolder;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
public class MyProfileDiffutilAdapter extends RecyclerView.Adapter<BaseRecyclerViewHolder<SettingModel>> {
    public RedDotListener KClassImpl$Data$declaredNonStaticMembers$2;
    public GroupedSettingItemClickListener PlaceComponentResult;
    public final AsyncListDiffer<SettingModel> getAuthRequestContext = new AsyncListDiffer<>(this, new SettingModelDiffUtil());

    /* loaded from: classes5.dex */
    public interface RedDotListener {
        boolean getAuthRequestContext(String str);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public /* synthetic */ void onBindViewHolder(BaseRecyclerViewHolder<SettingModel> baseRecyclerViewHolder, int i) {
        BaseRecyclerViewHolder<SettingModel> baseRecyclerViewHolder2 = baseRecyclerViewHolder;
        baseRecyclerViewHolder2.setIsRecyclable(baseRecyclerViewHolder2.getItemViewType() == 13 || baseRecyclerViewHolder2.getItemViewType() == 20 || baseRecyclerViewHolder2.getItemViewType() == 22);
        if (baseRecyclerViewHolder2.getItemViewType() == 21) {
            ((NewProfileSettingChildViewHolder) baseRecyclerViewHolder2).BuiltInFictitiousFunctionClassFactory = this.KClassImpl$Data$declaredNonStaticMembers$2;
        }
        if (baseRecyclerViewHolder2.getItemViewType() == 19) {
            ((ProfileSettingGroupViewHolder) baseRecyclerViewHolder2).BuiltInFictitiousFunctionClassFactory = this.KClassImpl$Data$declaredNonStaticMembers$2;
        }
        baseRecyclerViewHolder2.bindData(this.getAuthRequestContext.moveToNextValue.get(i));
        baseRecyclerViewHolder2.setOnItemClickListener(this.PlaceComponentResult);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.getAuthRequestContext.moveToNextValue.size();
    }

    public final boolean MyBillsEntityDataFactory(int i) {
        return i >= 0 && i < getItemCount();
    }

    public final SettingModel getAuthRequestContext(String str) {
        SettingModel empty;
        for (int i = 0; i < getItemCount(); i++) {
            if (MyBillsEntityDataFactory(i)) {
                empty = this.getAuthRequestContext.moveToNextValue.get(i);
            } else {
                empty = SettingModel.empty();
            }
            if (!empty.isNullObject() && str.equals(empty.getName())) {
                return empty;
            }
            List<SettingModel> settingChilds = empty.getSettingChilds();
            if (!settingChilds.isEmpty()) {
                for (SettingModel settingModel : settingChilds) {
                    if (!settingModel.isNullObject() && str.equals(settingModel.getName())) {
                        return settingModel;
                    }
                }
            }
        }
        return null;
    }

    public final int MyBillsEntityDataFactory(String str) {
        SettingModel empty;
        for (int i = 0; i < getItemCount(); i++) {
            if (MyBillsEntityDataFactory(i)) {
                empty = this.getAuthRequestContext.moveToNextValue.get(i);
            } else {
                empty = SettingModel.empty();
            }
            if (!empty.isNullObject() && str.equals(empty.getName())) {
                return i;
            }
        }
        return -1;
    }

    public final void getAuthRequestContext(SettingModel settingModel) {
        ArrayList arrayList = new ArrayList(this.getAuthRequestContext.moveToNextValue);
        arrayList.set(0, settingModel);
        this.getAuthRequestContext.KClassImpl$Data$declaredNonStaticMembers$2(null, null);
        this.getAuthRequestContext.KClassImpl$Data$declaredNonStaticMembers$2(arrayList, null);
    }

    public final boolean KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.getAuthRequestContext.moveToNextValue.isEmpty();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        SettingModel empty;
        if (MyBillsEntityDataFactory(i)) {
            empty = this.getAuthRequestContext.moveToNextValue.get(i);
        } else {
            empty = SettingModel.empty();
        }
        return empty.getViewType();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public /* synthetic */ BaseRecyclerViewHolder<SettingModel> onCreateViewHolder(ViewGroup viewGroup, int i) {
        if (i != 0) {
            if (i != 10) {
                if (i != 25) {
                    if (i != 27) {
                        if (i != 3) {
                            if (i != 4) {
                                if (i != 5) {
                                    if (i != 6) {
                                        if (i != 12) {
                                            if (i != 13) {
                                                switch (i) {
                                                    case 19:
                                                        return new ProfileSettingGroupViewHolder(viewGroup);
                                                    case 20:
                                                        return new NewProfileCompletionViewHolder(viewGroup);
                                                    case 21:
                                                        return new NewProfileSettingChildViewHolder(viewGroup);
                                                    case 22:
                                                        return new NewProfileMenuUserServiceViewHolder(viewGroup);
                                                    case 23:
                                                        return new ProfileMenuFamilyAccountViewHolder(viewGroup);
                                                    default:
                                                        return new ProfileMenuUserServiceViewHolder(viewGroup);
                                                }
                                            }
                                            return new ProfileCompletionViewHolder(viewGroup);
                                        }
                                        return new ProfileMenuSettingStatementViewHolder(viewGroup);
                                    }
                                    return new ProfileMenuPaymentAuthViewHolder(viewGroup);
                                }
                                return new ProfileMenuAvatarViewHolder(viewGroup);
                            }
                            return new ProfileMenuAppVersionViewHolder(viewGroup);
                        }
                        return new ProfileMenuUserKYBViewHolder(viewGroup);
                    }
                    return new NewProfileMenuChatbotViewHolder(viewGroup);
                }
                return new NewProfileMenuReferralViewHolder(viewGroup);
            }
            return new ProfileMenuSettingMoreViewHolder(viewGroup);
        }
        return new ProfileMenuHeaderViewHolder(viewGroup);
    }
}
