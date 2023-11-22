package id.dana.myprofile.settingconfig;

import android.content.Context;
import id.dana.data.profilemenu.MyProfileMenuAction;
import id.dana.data.profilemenu.MyProfileMenuCategories;
import id.dana.domain.profilemenu.model.SettingModel;
import id.dana.domain.profilemenu.settingconfig.RawSettingJsonMapper;
import id.dana.utils.ResourceUtils;
import id.dana.utils.VersionUtil;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes5.dex */
public class DefaultSettingMapper implements RawSettingJsonMapper {
    private Context getAuthRequestContext;

    public DefaultSettingMapper(Context context) {
        this.getAuthRequestContext = context;
    }

    @Override // id.dana.domain.profilemenu.settingconfig.RawSettingJsonMapper
    public List<SettingModel> apply(Map.Entry<String, LinkedHashMap<String, SettingModel>> entry) {
        Context context;
        ArrayList arrayList = new ArrayList();
        String key = entry.getKey();
        SettingModel settingModel = new SettingModel();
        settingModel.setTitle(ResourceUtils.PlaceComponentResult(this.getAuthRequestContext, key, key.replace(MyProfileMenuCategories.SETTING_CATEGORY, "").replace("_", " ")).toUpperCase());
        settingModel.setViewType(0);
        settingModel.setName(key);
        arrayList.add(settingModel);
        Iterator<Map.Entry<String, SettingModel>> it = entry.getValue().entrySet().iterator();
        while (it.hasNext()) {
            SettingModel value = it.next().getValue();
            if (value.isEnable()) {
                String key2 = entry.getKey();
                if (getAuthRequestContext(value.getName())) {
                    if (!PlaceComponentResult(key2)) {
                        if (key2.equals(MyProfileMenuCategories.PROFILE_FEATURES)) {
                            value.setCollection(MyProfileMenuCategories.PROFILE_FEATURES);
                        }
                    } else {
                        value.setCollection(MyProfileMenuCategories.PROFILE_USER_SERVICE);
                    }
                }
                if ("setting_kyb".equals(value.getName())) {
                    value.setViewType(3);
                } else if (MyProfileMenuAction.SETTING_APP_VERSION.equals(value.getName()) && (context = this.getAuthRequestContext) != null) {
                    value.setSubtitle(VersionUtil.BuiltInFictitiousFunctionClassFactory(context));
                    value.setViewType(4);
                } else if ("setting_more".equals(value.getName())) {
                    value.setViewType(10);
                } else if (MyProfileMenuAction.SETTING_STATEMENT.equals(value.getName())) {
                    value.setViewType(12);
                } else if ("setting_investment".equals(value.getName())) {
                    if (value.getUserInvestmentInfo() != null) {
                        value.setViewType(18);
                    } else {
                        value.setViewType(2);
                    }
                } else if ("setting_family_account".equals(value.getName())) {
                    value.setViewType(23);
                } else if ("setting_dana_plus".equals(value.getName())) {
                    if (value.getUserInvestmentInfo() != null) {
                        value.setViewType(26);
                    } else {
                        value.setViewType(2);
                    }
                } else if ("setting_chatbot".equals(value.getName())) {
                    value.setViewType(27);
                } else {
                    value.setViewType(2);
                }
                value.setTitle(ResourceUtils.BuiltInFictitiousFunctionClassFactory(this.getAuthRequestContext, value));
                value.setParent(key2);
                arrayList.add(value);
            }
        }
        return arrayList;
    }

    private static boolean PlaceComponentResult(String str) {
        return str.equals(MyProfileMenuCategories.PROFILE_USER_SERVICE);
    }

    private static boolean getAuthRequestContext(String str) {
        return str.equals("setting_investment");
    }
}
