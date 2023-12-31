package com.alibaba.ariver.app.api.ui.tabbar.model;

import com.alibaba.ariver.app.api.ui.darkmode.ColorSchemeDecider;
import com.alibaba.ariver.app.api.ui.darkmode.ColorSchemeModelTemplate;
import com.alibaba.ariver.app.api.ui.darkmode.ThemeUtils;
import com.alibaba.ariver.engine.api.resources.Resource;
import com.alibaba.ariver.kernel.common.utils.JSONUtils;
import com.alibaba.ariver.kernel.common.utils.TypeUtils;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.annotation.JSONField;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.messaging.Constants;
import com.iap.ac.android.region.cdp.util.CdpConstants;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
public class TabBarModel {
    private ColorSchemeModelTemplate<TabBarColorModel> colorSchemes;
    @JSONField
    private boolean disableOnInit;
    private boolean display = true;
    private List<TabBarItemModel> items;

    public static TabBarModel inflateFromResource(Resource resource, ColorSchemeDecider colorSchemeDecider) {
        JSONObject parseObject = JSONUtils.parseObject(resource.getBytes());
        if (parseObject != null) {
            TabBarModel tabBarModel = new TabBarModel();
            tabBarModel.setColorSchemeDecider(colorSchemeDecider);
            initColorModels(tabBarModel, parseObject);
            tabBarModel.setDisableOnInit(JSONUtils.getBoolean(parseObject, "disableOnInit", false));
            JSONArray jSONArray = JSONUtils.getJSONArray(parseObject, FirebaseAnalytics.Param.ITEMS, null);
            tabBarModel.setDisplay(JSONUtils.getBoolean(parseObject, Constants.ScionAnalytics.MessageType.DISPLAY_NOTIFICATION, true));
            if (jSONArray != null) {
                ArrayList arrayList = new ArrayList();
                int size = jSONArray.size();
                for (int i = 0; i < size; i++) {
                    arrayList.add(TabBarItemModel.inflateFromResource(jSONArray.getJSONObject(i), colorSchemeDecider));
                }
                tabBarModel.setItems(arrayList);
            }
            return tabBarModel;
        }
        return null;
    }

    private static void initColorModels(TabBarModel tabBarModel, JSONObject jSONObject) {
        TabBarColorModel generateTabBarColorModel = generateTabBarColorModel(jSONObject, null);
        tabBarModel.colorSchemes.setDefault(generateTabBarColorModel);
        JSONObject jSONObject2 = jSONObject.getJSONObject(ThemeUtils.KEY_COLOR_SCHEME);
        if (jSONObject2 != null) {
            for (String str : jSONObject2.keySet()) {
                JSONObject jSONObject3 = jSONObject2.getJSONObject(str);
                if ("light".equalsIgnoreCase(str)) {
                    tabBarModel.colorSchemes.setLight(generateTabBarColorModel(jSONObject3, generateTabBarColorModel));
                } else if ("dark".equalsIgnoreCase(str)) {
                    tabBarModel.colorSchemes.setDark(generateTabBarColorModel(jSONObject3, generateTabBarColorModel));
                }
            }
        }
    }

    private static TabBarColorModel generateTabBarColorModel(JSONObject jSONObject, TabBarColorModel tabBarColorModel) {
        if (jSONObject == null || jSONObject.isEmpty()) {
            return null;
        }
        TabBarColorModel tabBarColorModel2 = new TabBarColorModel();
        Integer parseColorInt = TypeUtils.parseColorInt(jSONObject.get(CdpConstants.CONTENT_TEXT_COLOR));
        if (parseColorInt != null) {
            tabBarColorModel2.setTextColor(parseColorInt);
        } else if (tabBarColorModel != null) {
            tabBarColorModel2.setTextColor(tabBarColorModel.getTextColor());
        }
        Long parseColorLong = TypeUtils.parseColorLong(jSONObject.get("backgroundColor"));
        if (parseColorLong != null) {
            if (parseColorLong.longValue() <= 16777215) {
                parseColorLong = Long.valueOf(parseColorLong.longValue() | (-16777216));
            }
            tabBarColorModel2.setBackgroundColor(parseColorLong.longValue());
        }
        Integer parseColorInt2 = TypeUtils.parseColorInt(jSONObject.get("selectedColor"));
        if (parseColorInt2 != null) {
            tabBarColorModel2.setSelectedColor(parseColorInt2);
        }
        return tabBarColorModel2;
    }

    public static TabBarModel inflateFromTemplate(JSONObject jSONObject, ColorSchemeDecider colorSchemeDecider) {
        TabBarModel tabBarModel = new TabBarModel();
        JSONArray jSONArray = JSONUtils.getJSONArray(jSONObject, FirebaseAnalytics.Param.ITEMS, null);
        if (jSONArray == null) {
            return null;
        }
        tabBarModel.setColorSchemeDecider(colorSchemeDecider);
        initColorModels(tabBarModel, jSONObject);
        try {
            int size = jSONArray.size();
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < size; i++) {
                arrayList.add(i, TabBarItemModel.inflateFromTemplate(jSONArray.getJSONObject(i), colorSchemeDecider));
            }
            tabBarModel.items = arrayList;
            return tabBarModel;
        } catch (Throwable unused) {
            return null;
        }
    }

    public TabBarModel() {
        ColorSchemeModelTemplate<TabBarColorModel> colorSchemeModelTemplate = new ColorSchemeModelTemplate<>();
        this.colorSchemes = colorSchemeModelTemplate;
        colorSchemeModelTemplate.setDefault(new TabBarColorModel());
    }

    public Integer getTextColor() {
        return this.colorSchemes.getTarget().getTextColor();
    }

    public void setTextColor(int i) {
        this.colorSchemes.getTarget().setTextColor(Integer.valueOf(i));
    }

    public Integer getSelectedColor() {
        return this.colorSchemes.getTarget().getSelectedColor();
    }

    public void setSelectedColor(int i) {
        this.colorSchemes.getTarget().setSelectedColor(Integer.valueOf(i));
    }

    public long getBackgroundColor() {
        return this.colorSchemes.getTarget().getBackgroundColor();
    }

    public void setBackgroundColor(long j) {
        if (j <= 16777215) {
            j |= -16777216;
        }
        this.colorSchemes.getTarget().setBackgroundColor(j);
    }

    public boolean isDisplay() {
        return this.display;
    }

    public void setDisplay(boolean z) {
        this.display = z;
    }

    public List<TabBarItemModel> getItems() {
        return this.items;
    }

    public void setItems(List<TabBarItemModel> list) {
        this.items = list;
    }

    public boolean isDisableOnInit() {
        return this.disableOnInit;
    }

    public void setDisableOnInit(boolean z) {
        this.disableOnInit = z;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("TabBarModel{, items=");
        sb.append(this.items);
        sb.append(", colorSchemes=");
        sb.append(this.colorSchemes);
        sb.append(", disableOnInit=");
        sb.append(this.disableOnInit);
        sb.append(", textColor=");
        sb.append(getTextColor());
        sb.append(", selectedColor=");
        sb.append(getSelectedColor());
        sb.append(", display=");
        sb.append(isDisplay());
        sb.append('}');
        return sb.toString();
    }

    public void setColorSchemeDecider(ColorSchemeDecider colorSchemeDecider) {
        this.colorSchemes.setColorSchemeDecider(colorSchemeDecider);
    }
}
