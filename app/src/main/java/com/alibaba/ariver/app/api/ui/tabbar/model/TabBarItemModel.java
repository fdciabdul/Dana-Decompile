package com.alibaba.ariver.app.api.ui.tabbar.model;

import com.alibaba.ariver.app.api.ui.darkmode.ColorSchemeDecider;
import com.alibaba.ariver.app.api.ui.darkmode.ColorSchemeModelTemplate;
import com.alibaba.ariver.app.api.ui.darkmode.ThemeUtils;
import com.alibaba.ariver.kernel.RVConstants;
import com.alibaba.ariver.kernel.RVStartParams;
import com.alibaba.ariver.kernel.common.utils.JSONUtils;
import com.alibaba.ariver.kernel.common.utils.TypeUtils;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.annotation.JSONField;
import com.iap.ac.android.region.cdp.util.CdpConstants;

/* loaded from: classes2.dex */
public class TabBarItemModel {
    private ColorSchemeDecider colorSchemeDecider;
    private ColorSchemeModelTemplate<TabBarItemColorModel> colorSchemes;
    @JSONField
    private JSONObject launchParams;
    @JSONField
    private String launchParamsTag;
    @JSONField
    private String name;
    @JSONField
    private Integer selectedColor;
    @JSONField
    private String tag;
    @JSONField
    private Integer textColor;
    @JSONField
    private String url;

    public TabBarItemModel() {
        ColorSchemeModelTemplate<TabBarItemColorModel> colorSchemeModelTemplate = new ColorSchemeModelTemplate<>();
        this.colorSchemes = colorSchemeModelTemplate;
        colorSchemeModelTemplate.setDefault(new TabBarItemColorModel());
    }

    public TabBarItemModel(TabBarItemModel tabBarItemModel) {
        this.colorSchemes = tabBarItemModel.colorSchemes;
        this.name = tabBarItemModel.name;
        this.tag = tabBarItemModel.tag;
        this.url = tabBarItemModel.url;
        this.launchParamsTag = tabBarItemModel.launchParamsTag;
        this.launchParams = tabBarItemModel.launchParams;
        this.textColor = tabBarItemModel.textColor;
        this.selectedColor = tabBarItemModel.selectedColor;
        this.colorSchemeDecider = tabBarItemModel.colorSchemeDecider;
    }

    private static ColorSchemeModelTemplate<TabBarItemColorModel> generateTabBarItemColorScheme(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        ColorSchemeModelTemplate<TabBarItemColorModel> colorSchemeModelTemplate = new ColorSchemeModelTemplate<>();
        TabBarItemColorModel tabBarItemColorModel = getTabBarItemColorModel(jSONObject, null);
        colorSchemeModelTemplate.setDefault(tabBarItemColorModel);
        JSONObject jSONObject2 = jSONObject.getJSONObject(ThemeUtils.KEY_COLOR_SCHEME);
        if (jSONObject2 != null) {
            colorSchemeModelTemplate.setLight(getTabBarItemColorModel(jSONObject2.getJSONObject("light"), tabBarItemColorModel));
            colorSchemeModelTemplate.setDark(getTabBarItemColorModel(jSONObject2.getJSONObject("dark"), tabBarItemColorModel));
        }
        return colorSchemeModelTemplate;
    }

    private static TabBarItemColorModel getTabBarItemColorModel(JSONObject jSONObject, TabBarItemColorModel tabBarItemColorModel) {
        if (jSONObject == null || jSONObject.isEmpty()) {
            return null;
        }
        TabBarItemColorModel tabBarItemColorModel2 = new TabBarItemColorModel();
        if (jSONObject.containsKey("icon")) {
            tabBarItemColorModel2.setIcon(JSONUtils.getString(jSONObject, "icon"));
        } else if (tabBarItemColorModel != null) {
            tabBarItemColorModel2.setIcon(tabBarItemColorModel.getIcon());
        }
        if (jSONObject.containsKey("activeIcon")) {
            tabBarItemColorModel2.setActiveIcon(JSONUtils.getString(jSONObject, "activeIcon"));
        } else if (tabBarItemColorModel != null) {
            tabBarItemColorModel2.setActiveIcon(tabBarItemColorModel.getActiveIcon());
        }
        return tabBarItemColorModel2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static TabBarItemModel inflateFromTemplate(JSONObject jSONObject, ColorSchemeDecider colorSchemeDecider) {
        TabBarItemModel tabBarItemModel = new TabBarItemModel();
        tabBarItemModel.colorSchemes = generateTabBarItemColorScheme(jSONObject);
        tabBarItemModel.setName(JSONUtils.getString(jSONObject, "name"));
        String string = JSONUtils.getString(jSONObject, "pagePath");
        StringBuilder sb = new StringBuilder();
        sb.append("index.html#");
        sb.append(string);
        tabBarItemModel.setUrl(sb.toString());
        tabBarItemModel.setTag(string);
        tabBarItemModel.setLaunchParamsTag(string);
        tabBarItemModel.setLaunchParams(JSONUtils.getJSONObject(jSONObject, RVConstants.EXTRA_RES_LAUNCH_PARAMS, null));
        tabBarItemModel.setColorSchemeDecider(colorSchemeDecider);
        return tabBarItemModel;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static TabBarItemModel inflateFromResource(JSONObject jSONObject, ColorSchemeDecider colorSchemeDecider) {
        TabBarItemModel tabBarItemModel = new TabBarItemModel();
        tabBarItemModel.colorSchemes = generateTabBarItemColorScheme(jSONObject);
        tabBarItemModel.setSelectedColor(TypeUtils.parseColorInt(jSONObject.get("selectedColor")));
        tabBarItemModel.setTextColor(TypeUtils.parseColorInt(jSONObject.get(CdpConstants.CONTENT_TEXT_COLOR)));
        tabBarItemModel.setName(JSONUtils.getString(jSONObject, "name"));
        tabBarItemModel.setLaunchParams(JSONUtils.getJSONObject(jSONObject, RVConstants.EXTRA_RES_LAUNCH_PARAMS, null));
        if (jSONObject.containsKey("pagePath")) {
            String string = JSONUtils.getString(jSONObject, "pagePath");
            tabBarItemModel.setTag(string);
            StringBuilder sb = new StringBuilder();
            sb.append("index.html#");
            sb.append(string);
            tabBarItemModel.setUrl(sb.toString());
            tabBarItemModel.setLaunchParamsTag(string);
        } else {
            tabBarItemModel.setTag(JSONUtils.getString(jSONObject, "tag"));
            tabBarItemModel.setUrl(JSONUtils.getString(jSONObject, "url"));
            tabBarItemModel.setLaunchParamsTag(JSONUtils.getString(jSONObject, RVStartParams.KEY_LAUNCH_PARAMS_TAG));
        }
        tabBarItemModel.setColorSchemeDecider(colorSchemeDecider);
        return tabBarItemModel;
    }

    public String getIcon() {
        return this.colorSchemes.getTarget().getIcon();
    }

    public void setIcon(String str) {
        this.colorSchemes.getTarget().setIcon(str);
    }

    public String getActiveIcon() {
        return this.colorSchemes.getTarget().getActiveIcon();
    }

    public void setActiveIcon(String str) {
        this.colorSchemes.getTarget().setActiveIcon(str);
    }

    public String getName() {
        return this.name;
    }

    public void setName(String str) {
        this.name = str;
    }

    public String getTag() {
        return this.tag;
    }

    public void setTag(String str) {
        this.tag = str;
    }

    public String getUrl() {
        return this.url;
    }

    public void setUrl(String str) {
        this.url = str;
    }

    public String getLaunchParamsTag() {
        return this.launchParamsTag;
    }

    public void setLaunchParamsTag(String str) {
        this.launchParamsTag = str;
    }

    public Integer getTextColor() {
        return this.textColor;
    }

    public void setTextColor(Integer num) {
        this.textColor = num;
    }

    public Integer getSelectedColor() {
        return this.selectedColor;
    }

    public void setSelectedColor(Integer num) {
        this.selectedColor = num;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Item{name='");
        sb.append(this.name);
        sb.append('\'');
        sb.append(", url='");
        sb.append(this.url);
        sb.append('\'');
        sb.append(", textColor='");
        sb.append(this.textColor);
        sb.append('\'');
        sb.append(", selectedColor='");
        sb.append(this.selectedColor);
        sb.append('\'');
        sb.append(", launchParams='");
        sb.append(this.launchParams);
        sb.append('\'');
        sb.append(", launchParamsTag='");
        sb.append(this.launchParamsTag);
        sb.append('\'');
        sb.append('}');
        return sb.toString();
    }

    private void setColorSchemeDecider(ColorSchemeDecider colorSchemeDecider) {
        this.colorSchemeDecider = colorSchemeDecider;
        this.colorSchemes.setColorSchemeDecider(colorSchemeDecider);
    }

    public JSONObject getLaunchParams() {
        return this.launchParams;
    }

    public void setLaunchParams(JSONObject jSONObject) {
        this.launchParams = jSONObject;
    }
}
