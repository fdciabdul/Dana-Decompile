package id.dana.myprofile.model;

import android.text.TextUtils;
import androidx.recyclerview.widget.DiffUtil;
import id.dana.domain.profilemenu.model.SettingModel;

/* loaded from: classes5.dex */
public class SettingModelDiffUtil extends DiffUtil.ItemCallback<SettingModel> {
    @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
    public final /* synthetic */ boolean KClassImpl$Data$declaredNonStaticMembers$2(SettingModel settingModel, SettingModel settingModel2) {
        return BuiltInFictitiousFunctionClassFactory(settingModel, settingModel2);
    }

    @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
    public final /* synthetic */ boolean getAuthRequestContext(SettingModel settingModel, SettingModel settingModel2) {
        return MyBillsEntityDataFactory(settingModel, settingModel2);
    }

    private static boolean MyBillsEntityDataFactory(SettingModel settingModel, SettingModel settingModel2) {
        return TextUtils.equals(settingModel.getName(), settingModel2.getName());
    }

    private static boolean BuiltInFictitiousFunctionClassFactory(SettingModel settingModel, SettingModel settingModel2) {
        return TextUtils.equals(settingModel.getTitle(), settingModel2.getTitle()) && TextUtils.equals(settingModel.getSubtitle(), settingModel2.getSubtitle()) && TextUtils.equals(settingModel.getSubtitleType(), settingModel2.getSubtitleType()) && settingModel.isNeedToShow() == settingModel2.isNeedToShow() && settingModel.isEnable() == settingModel2.isEnable() && settingModel.getViewType() == settingModel2.getViewType() && TextUtils.equals(settingModel.getBalance(), settingModel2.getBalance());
    }
}
