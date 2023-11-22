package com.iap.ac.android.acs.operation.biz.region.bean;

import java.util.Map;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class MenuExtraInfo {
    public static final String CUSTOM_DATA_COLLECTED_REACHED_LIMIT = "hasReachedFavoriteLimit";
    public static final String CUSTOM_DATA_COLLECTED_STATUS = "collectedStatus";
    public static final String MENU_ID_COLLECT = "IAPMenuIdCollect";
    public static final String MENU_ID_FEEDBACK = "IAPMenuIdFeedback";
    public static final String MENU_ID_NOTIFICATION = "IAPMenuIdNotificationBox";
    public static final String MENU_ID_PANEL_COLLECT = "IAPMenuIdPanelCollect";
    public static final String MENU_ID_SUBSCRIPTION = "IAPMenuIdSubscription";
    public static final String MENU_ID_TITLE_BAR_COLLECT = "IAPMenuIdTitleBarCollect";
    public String appId;
    public Map<String, Object> customData;
    public JSONObject itemInfos;
    public String itemStatus;
    public String menuId;
    public boolean showMenuItem;
    public boolean showRedDot;
}
