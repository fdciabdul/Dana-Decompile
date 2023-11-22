package id.dana.myprofile.viewholder;

import android.view.View;
import android.view.ViewGroup;
import id.dana.R;
import id.dana.base.BaseRecyclerViewHolder;
import id.dana.domain.profilemenu.model.SettingModel;
import id.dana.myprofile.ProfileUserServiceType;
import id.dana.myprofile.adapter.MyProfileDiffutilAdapter;
import id.dana.richview.profile.NewProfileSettingChildView;
import id.dana.utils.extension.LanguageExtKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u000f2\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001:\u0001\u000fB\u000f\u0012\u0006\u0010\u0004\u001a\u00020\f¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R\u0018\u0010\u000b\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\t\u0010\n"}, d2 = {"Lid/dana/myprofile/viewholder/NewProfileSettingChildViewHolder;", "Lid/dana/base/BaseRecyclerViewHolder;", "Lid/dana/domain/profilemenu/model/SettingModel;", "Lid/dana/base/BaseRecyclerViewHolder$OnItemClickListener;", "p0", "", "setOnItemClickListener", "(Lid/dana/base/BaseRecyclerViewHolder$OnItemClickListener;)V", "Lid/dana/myprofile/adapter/MyProfileDiffutilAdapter$RedDotListener;", "KClassImpl$Data$declaredNonStaticMembers$2", "Lid/dana/myprofile/adapter/MyProfileDiffutilAdapter$RedDotListener;", "BuiltInFictitiousFunctionClassFactory", "Landroid/view/ViewGroup;", "<init>", "(Landroid/view/ViewGroup;)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class NewProfileSettingChildViewHolder extends BaseRecyclerViewHolder<SettingModel> {

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    public MyProfileDiffutilAdapter.RedDotListener BuiltInFictitiousFunctionClassFactory;

    @Override // id.dana.base.BaseRecyclerViewHolder
    public final /* synthetic */ void bindData(SettingModel settingModel) {
        NewProfileSettingChildView newProfileSettingChildView;
        String string;
        String titleEn;
        String title;
        String title2;
        String title3;
        String title4;
        String title5;
        String title6;
        SettingModel settingModel2 = settingModel;
        boolean z = false;
        this.itemView.setVisibility(0);
        if (settingModel2 != null) {
            this.itemView.setVisibility(settingModel2.isEnable() ? 0 : 8);
            NewProfileSettingChildView newProfileSettingChildView2 = (NewProfileSettingChildView) this.itemView.findViewById(R.id.view_new_profile_setting_child);
            if (newProfileSettingChildView2 != null) {
                newProfileSettingChildView2.setParentViewVisibility(settingModel2.isEnable() ? 0 : 8);
            }
            String name = settingModel2.getName();
            if (Intrinsics.areEqual(name, ProfileUserServiceType.PROMO_CODE)) {
                NewProfileSettingChildView newProfileSettingChildView3 = (NewProfileSettingChildView) this.itemView.findViewById(R.id.view_new_profile_setting_child);
                if (newProfileSettingChildView3 != null) {
                    newProfileSettingChildView3.setContentDescription(getContext().getString(R.string.btn_promo_code));
                }
            } else if (Intrinsics.areEqual(name, "setting_referral") && (newProfileSettingChildView = (NewProfileSettingChildView) this.itemView.findViewById(R.id.view_new_profile_setting_child)) != null) {
                newProfileSettingChildView.setContentDescription(getContext().getString(R.string.btn_referral));
            }
            MyProfileDiffutilAdapter.RedDotListener redDotListener = this.BuiltInFictitiousFunctionClassFactory;
            boolean z2 = (redDotListener != null && redDotListener.getAuthRequestContext(settingModel2.getName())) && settingModel2.isHasReddot();
            String subtitle = LanguageExtKt.getAuthRequestContext() ? settingModel2.getSubtitle() : settingModel2.getSubtitleEn();
            NewProfileSettingChildView newProfileSettingChildView4 = (NewProfileSettingChildView) this.itemView.findViewById(R.id.view_new_profile_setting_child);
            if (newProfileSettingChildView4 != null) {
                String str = null;
                if ((settingModel2 == null || (title6 = settingModel2.getTitle()) == null || !StringsKt.contains$default((CharSequence) title6, (CharSequence) "Profile Settings", false, 2, (Object) null)) ? false : true) {
                    string = getContext().getString(R.string.setting_more);
                    Intrinsics.checkNotNullExpressionValue(string, "");
                } else {
                    if ((settingModel2 == null || (title5 = settingModel2.getTitle()) == null || !StringsKt.contains$default((CharSequence) title5, (CharSequence) "Security Settings", false, 2, (Object) null)) ? false : true) {
                        string = getContext().getString(R.string.setting_new_security_settings);
                        Intrinsics.checkNotNullExpressionValue(string, "");
                    } else {
                        if (!((settingModel2 == null || (title4 = settingModel2.getTitle()) == null || !StringsKt.contains$default((CharSequence) title4, (CharSequence) "Linked Account", false, 2, (Object) null)) ? false : true)) {
                            if (!((settingModel2 == null || (title3 = settingModel2.getTitle()) == null || !StringsKt.contains$default((CharSequence) title3, (CharSequence) "Linked Merchants", false, 2, (Object) null)) ? false : true)) {
                                if ((settingModel2 == null || (title2 = settingModel2.getTitle()) == null || !StringsKt.contains$default((CharSequence) title2, (CharSequence) "Verification", false, 2, (Object) null)) ? false : true) {
                                    string = getContext().getString(R.string.setting_verification_list);
                                    Intrinsics.checkNotNullExpressionValue(string, "");
                                } else {
                                    if (!((settingModel2 == null || (title = settingModel2.getTitle()) == null || !StringsKt.contains$default((CharSequence) title, (CharSequence) "Enter Promo Code", false, 2, (Object) null)) ? false : true)) {
                                        if (settingModel2 != null && (titleEn = settingModel2.getTitleEn()) != null) {
                                            if (titleEn.length() > 0) {
                                                z = true;
                                            }
                                        }
                                        if (z && !LanguageExtKt.getAuthRequestContext()) {
                                            str = settingModel2.getTitleEn();
                                        } else if (settingModel2 != null) {
                                            str = settingModel2.getTitle();
                                        }
                                        if (str == null) {
                                            str = "";
                                        }
                                        String name2 = settingModel2.getName();
                                        String iconUrl = settingModel2.getIconUrl();
                                        boolean isShowNewBadge = settingModel2.isShowNewBadge();
                                        Boolean subtitleIsBelow = settingModel2.getSubtitleIsBelow();
                                        Intrinsics.checkNotNullExpressionValue(subtitleIsBelow, "");
                                        newProfileSettingChildView4.setView(str, subtitle, name2, iconUrl, Boolean.valueOf(z2), isShowNewBadge, subtitleIsBelow.booleanValue());
                                    }
                                    string = getContext().getString(R.string.setting_promo_code);
                                    Intrinsics.checkNotNullExpressionValue(string, "");
                                }
                            }
                        }
                        string = getContext().getString(R.string.setting_merchant_management);
                        Intrinsics.checkNotNullExpressionValue(string, "");
                    }
                }
                str = string;
                String name22 = settingModel2.getName();
                String iconUrl2 = settingModel2.getIconUrl();
                boolean isShowNewBadge2 = settingModel2.isShowNewBadge();
                Boolean subtitleIsBelow2 = settingModel2.getSubtitleIsBelow();
                Intrinsics.checkNotNullExpressionValue(subtitleIsBelow2, "");
                newProfileSettingChildView4.setView(str, subtitle, name22, iconUrl2, Boolean.valueOf(z2), isShowNewBadge2, subtitleIsBelow2.booleanValue());
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NewProfileSettingChildViewHolder(ViewGroup viewGroup) {
        super(viewGroup.getContext(), R.layout.item_new_profile_setting_child, viewGroup);
        Intrinsics.checkNotNullParameter(viewGroup, "");
    }

    @Override // id.dana.base.BaseRecyclerViewHolder
    public final void setOnItemClickListener(final BaseRecyclerViewHolder.OnItemClickListener p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        NewProfileSettingChildView newProfileSettingChildView = (NewProfileSettingChildView) this.itemView.findViewById(R.id.view_new_profile_setting_child);
        if (newProfileSettingChildView != null) {
            newProfileSettingChildView.setOnClickListener(new View.OnClickListener() { // from class: id.dana.myprofile.viewholder.NewProfileSettingChildViewHolder$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    NewProfileSettingChildViewHolder.BuiltInFictitiousFunctionClassFactory(BaseRecyclerViewHolder.OnItemClickListener.this, this);
                }
            });
        }
    }

    public static /* synthetic */ void BuiltInFictitiousFunctionClassFactory(BaseRecyclerViewHolder.OnItemClickListener onItemClickListener, NewProfileSettingChildViewHolder newProfileSettingChildViewHolder) {
        Intrinsics.checkNotNullParameter(onItemClickListener, "");
        Intrinsics.checkNotNullParameter(newProfileSettingChildViewHolder, "");
        onItemClickListener.onItemClick(newProfileSettingChildViewHolder.getBindingAdapterPosition());
        ((NewProfileSettingChildView) newProfileSettingChildViewHolder.itemView.findViewById(R.id.view_new_profile_setting_child)).hideReddot();
    }
}
