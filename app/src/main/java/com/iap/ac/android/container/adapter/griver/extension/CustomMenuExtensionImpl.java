package com.iap.ac.android.container.adapter.griver.extension;

import android.os.Bundle;
import android.text.TextUtils;
import com.alibaba.ariver.app.api.Page;
import com.alibaba.ariver.app.api.PageContext;
import com.alibaba.ariver.resource.api.models.AppModel;
import com.alibaba.griver.api.common.menu.GRVMPMoreMenuItem;
import com.alibaba.griver.api.common.menu.GriverACMenuExtension;
import com.alibaba.griver.api.common.menu.GriverMenuItem;
import com.alibaba.griver.api.common.menu.OnMenuItemClickListener;
import com.alibaba.griver.base.common.utils.MonitorUtil;
import com.alibaba.griver.base.common.utils.ToastUtils;
import com.alibaba.griver.core.ui.menu.GRVAppFavoriteMenuItem;
import com.alibaba.griver.core.ui.menu.GRVNotificationBoxMenuItem;
import com.alibaba.griver.core.ui.menu.GRVSubscriptionMenuItem;
import com.iap.ac.android.common.container.event.IContainerListener;
import com.iap.ac.android.common.container.provider.ui.AppFavoriteStatus;
import com.iap.ac.android.common.container.provider.ui.ContainerMenuDataChangeListener;
import com.iap.ac.android.common.container.provider.ui.ContainerMoreMenuItemType;
import com.iap.ac.android.common.container.provider.ui.ContainerUIProvider;
import com.iap.ac.android.common.log.ACLog;
import com.iap.ac.android.container.adapter.griver.event.AppEventHandler;
import j$.util.concurrent.ConcurrentHashMap;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class CustomMenuExtensionImpl implements GriverACMenuExtension {
    public static final String TYPE_FAVORITE = "Favorite";
    public static final String TYPE_FEEDBACK = "Feedback";
    public static final String TYPE_NOTIFICATION = "Notification";
    public static final String TYPE_SUBSCRIPTION = "Subscription";

    /* renamed from: a  reason: collision with root package name */
    private static Map<String, GriverMenuItem> f7561a = new ConcurrentHashMap();
    private ContainerUIProvider b;

    public CustomMenuExtensionImpl(ContainerUIProvider containerUIProvider) {
        this.b = containerUIProvider;
        containerUIProvider.addMenuDataChangeListener(new ContainerMenuDataChangeListener() { // from class: com.iap.ac.android.container.adapter.griver.extension.CustomMenuExtensionImpl.1
            @Override // com.iap.ac.android.common.container.provider.ui.ContainerMenuDataChangeListener
            public void onMenuDataChange(String str, Bundle bundle, JSONObject jSONObject) {
                GriverMenuItem c;
                int i = AnonymousClass7.$SwitchMap$com$iap$ac$android$common$container$provider$ui$ContainerMoreMenuItemType[ContainerMoreMenuItemType.parseValue(bundle.getInt(ContainerUIProvider.KEY_MENU_TYPE)).ordinal()];
                if (i == 1) {
                    GriverMenuItem b = CustomMenuExtensionImpl.this.b(str);
                    if (b != null) {
                        GRVAppFavoriteMenuItem gRVAppFavoriteMenuItem = (GRVAppFavoriteMenuItem) b;
                        if (bundle.containsKey(ContainerUIProvider.KEY_FAVORITE_STATUS)) {
                            AppFavoriteStatus parseValue = AppFavoriteStatus.parseValue(bundle.getInt(ContainerUIProvider.KEY_FAVORITE_STATUS));
                            if (parseValue == AppFavoriteStatus.Unknow) {
                                gRVAppFavoriteMenuItem.status = GRVAppFavoriteMenuItem.Status.GRVAppFavoriteStatusUnKnow;
                            } else if (parseValue == AppFavoriteStatus.Collected) {
                                gRVAppFavoriteMenuItem.status = GRVAppFavoriteMenuItem.Status.GRVAppFavoriteStatusCollected;
                            } else if (parseValue == AppFavoriteStatus.Uncollected) {
                                gRVAppFavoriteMenuItem.status = GRVAppFavoriteMenuItem.Status.GRVAppFavoriteStatusUncollected;
                            }
                        }
                        if (jSONObject != null) {
                            try {
                                HashMap hashMap = new HashMap();
                                Iterator<String> keys = jSONObject.keys();
                                while (keys.hasNext()) {
                                    String next = keys.next();
                                    GRVMPMoreMenuItem.ItemInfo itemInfo = new GRVMPMoreMenuItem.ItemInfo();
                                    itemInfo.iconUrl = jSONObject.getJSONObject(next).getString("iconUrl");
                                    itemInfo.iconName = jSONObject.getJSONObject(next).getString("itemName");
                                    hashMap.put(next, itemInfo);
                                }
                                if (bundle.containsKey(ContainerUIProvider.KEY_SHOW)) {
                                    gRVAppFavoriteMenuItem.setItemInfos(hashMap);
                                }
                                if (bundle.containsKey(ContainerUIProvider.KEY_SHOW_TITLE)) {
                                    gRVAppFavoriteMenuItem.setTitleInfos(hashMap);
                                }
                            } catch (Exception unused) {
                                gRVAppFavoriteMenuItem.setItemInfos(null);
                            }
                        }
                        if (bundle.containsKey(ContainerUIProvider.KEY_SHOW)) {
                            gRVAppFavoriteMenuItem.show = bundle.getBoolean(ContainerUIProvider.KEY_SHOW, false);
                        }
                        if (bundle.containsKey(ContainerUIProvider.KEY_SHOW_TITLE)) {
                            gRVAppFavoriteMenuItem.showTitle = bundle.getBoolean(ContainerUIProvider.KEY_SHOW_TITLE, false);
                        }
                        gRVAppFavoriteMenuItem.notifyDataSetChanged();
                    }
                } else if (i == 2) {
                    GriverMenuItem a2 = CustomMenuExtensionImpl.this.a(str);
                    if (a2 != null) {
                        GRVNotificationBoxMenuItem gRVNotificationBoxMenuItem = (GRVNotificationBoxMenuItem) a2;
                        gRVNotificationBoxMenuItem.showBadge = bundle.getBoolean("redDot");
                        if (jSONObject != null) {
                            try {
                                gRVNotificationBoxMenuItem.iconUrl = jSONObject.getJSONObject("DEFAULT").getString("iconUrl");
                                gRVNotificationBoxMenuItem.name = jSONObject.getJSONObject("DEFAULT").getString("itemName");
                            } catch (Exception unused2) {
                                gRVNotificationBoxMenuItem.iconUrl = null;
                            }
                        }
                        if (bundle.containsKey(ContainerUIProvider.KEY_SHOW)) {
                            gRVNotificationBoxMenuItem.show = bundle.getBoolean(ContainerUIProvider.KEY_SHOW, false);
                            gRVNotificationBoxMenuItem.notifyDataSetChanged();
                        }
                        gRVNotificationBoxMenuItem.notifyDataSetChanged();
                    }
                } else if (i == 3) {
                    GriverMenuItem d = CustomMenuExtensionImpl.this.d(str);
                    if (d != null) {
                        if (bundle.containsKey(ContainerUIProvider.KEY_SHOW)) {
                            d.show = bundle.getBoolean(ContainerUIProvider.KEY_SHOW, false);
                        }
                        try {
                            d.iconUrl = jSONObject.getJSONObject("DEFAULT").getString("iconUrl");
                            d.name = jSONObject.getJSONObject("DEFAULT").getString("itemName");
                        } catch (Exception unused3) {
                            d.iconUrl = null;
                        }
                    }
                } else if (i != 4 || (c = CustomMenuExtensionImpl.this.c(str)) == null) {
                } else {
                    GRVSubscriptionMenuItem gRVSubscriptionMenuItem = (GRVSubscriptionMenuItem) c;
                    gRVSubscriptionMenuItem.showBadge = bundle.getBoolean("redDot");
                    if (bundle.containsKey(ContainerUIProvider.KEY_SHOW)) {
                        gRVSubscriptionMenuItem.show = bundle.getBoolean(ContainerUIProvider.KEY_SHOW, false);
                    }
                    try {
                        gRVSubscriptionMenuItem.iconUrl = jSONObject.getJSONObject("DEFAULT").getString("iconUrl");
                        gRVSubscriptionMenuItem.name = jSONObject.getJSONObject("DEFAULT").getString("itemName");
                    } catch (Exception unused4) {
                        gRVSubscriptionMenuItem.iconUrl = null;
                    }
                    gRVSubscriptionMenuItem.notifyDataSetChanged();
                }
            }
        });
        AppEventHandler.addContainerListener(new IContainerListener() { // from class: com.iap.ac.android.container.adapter.griver.extension.CustomMenuExtensionImpl.2
            @Override // com.iap.ac.android.common.container.event.IContainerListener
            public void onContainerCreated(Bundle bundle) {
            }

            @Override // com.iap.ac.android.common.container.event.IContainerListener
            public void onContainerDestroyed(Bundle bundle) {
                String string = bundle.getString("appId");
                if (TextUtils.isEmpty(string)) {
                    return;
                }
                Map map = CustomMenuExtensionImpl.f7561a;
                StringBuilder sb = new StringBuilder();
                sb.append(string);
                sb.append("Notification");
                map.remove(sb.toString());
                Map map2 = CustomMenuExtensionImpl.f7561a;
                StringBuilder sb2 = new StringBuilder();
                sb2.append(string);
                sb2.append(CustomMenuExtensionImpl.TYPE_FAVORITE);
                map2.remove(sb2.toString());
                Map map3 = CustomMenuExtensionImpl.f7561a;
                StringBuilder sb3 = new StringBuilder();
                sb3.append(string);
                sb3.append(CustomMenuExtensionImpl.TYPE_FEEDBACK);
                map3.remove(sb3.toString());
                Map map4 = CustomMenuExtensionImpl.f7561a;
                StringBuilder sb4 = new StringBuilder();
                sb4.append(string);
                sb4.append(CustomMenuExtensionImpl.TYPE_SUBSCRIPTION);
                map4.remove(sb4.toString());
            }
        });
    }

    /* renamed from: com.iap.ac.android.container.adapter.griver.extension.CustomMenuExtensionImpl$7  reason: invalid class name */
    /* loaded from: classes3.dex */
    static /* synthetic */ class AnonymousClass7 {
        static final /* synthetic */ int[] $SwitchMap$com$iap$ac$android$common$container$provider$ui$ContainerMoreMenuItemType;

        static {
            int[] iArr = new int[ContainerMoreMenuItemType.values().length];
            $SwitchMap$com$iap$ac$android$common$container$provider$ui$ContainerMoreMenuItemType = iArr;
            try {
                iArr[ContainerMoreMenuItemType.Favorite.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$iap$ac$android$common$container$provider$ui$ContainerMoreMenuItemType[ContainerMoreMenuItemType.Notification.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$iap$ac$android$common$container$provider$ui$ContainerMoreMenuItemType[ContainerMoreMenuItemType.Feedback.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$iap$ac$android$common$container$provider$ui$ContainerMoreMenuItemType[ContainerMoreMenuItemType.Subscription.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    @Override // com.alibaba.griver.api.common.menu.GriverACMenuExtension
    public List<GriverMenuItem> getMenuList(Page page) {
        String appId = page.getApp().getAppId();
        LinkedList linkedList = new LinkedList();
        GriverMenuItem b = b(appId);
        if (b != null) {
            linkedList.add(b);
        }
        GriverMenuItem a2 = a(appId);
        if (a2 != null) {
            linkedList.add(a2);
        }
        GriverMenuItem d = d(appId);
        if (d != null) {
            linkedList.add(d);
        }
        GriverMenuItem c = c(appId);
        if (c != null) {
            linkedList.add(c);
        }
        return linkedList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public GriverMenuItem a(String str) {
        ContainerUIProvider containerUIProvider = this.b;
        if (containerUIProvider == null) {
            ACLog.e("CustomMenuExtensionImpl", "ContainerUIProvider#getNotificationMenuItem is null.");
            return null;
        } else if (!containerUIProvider.itemShowFilter(str, ContainerMoreMenuItemType.Notification)) {
            ACLog.e("CustomMenuExtensionImpl", "ContainerUIProvider#getNotificationMenuItem Notification menu toggle is false.");
            return null;
        } else {
            Map<String, GriverMenuItem> map = f7561a;
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            sb.append("Notification");
            GriverMenuItem griverMenuItem = map.get(sb.toString());
            GRVNotificationBoxMenuItem gRVNotificationBoxMenuItem = griverMenuItem;
            if (griverMenuItem == null) {
                final GRVNotificationBoxMenuItem gRVNotificationBoxMenuItem2 = new GRVNotificationBoxMenuItem();
                if (this.b.itemShowRedDot(str, ContainerMoreMenuItemType.Notification)) {
                    gRVNotificationBoxMenuItem2.enableBadge(str);
                }
                gRVNotificationBoxMenuItem2.listener = new OnMenuItemClickListener() { // from class: com.iap.ac.android.container.adapter.griver.extension.CustomMenuExtensionImpl.3
                    @Override // com.alibaba.griver.api.common.menu.OnMenuItemClickListener
                    public void onItemClick(Page page, String str2) {
                        String appId = page.getApp().getAppId();
                        AppModel appModel = (AppModel) page.getApp().getData(AppModel.class);
                        CustomMenuExtensionImpl.this.b.onContainerNotificationMenuClick(appId, (appModel == null || appModel.getAppInfoModel() == null) ? "" : appModel.getAppInfoModel().getName(), new Bundle());
                        gRVNotificationBoxMenuItem2.notifyDataSetChanged();
                        MonitorUtil.trackMenuClick("Notification");
                    }
                };
                Map<String, GriverMenuItem> map2 = f7561a;
                StringBuilder sb2 = new StringBuilder();
                sb2.append(str);
                sb2.append("Notification");
                map2.put(sb2.toString(), gRVNotificationBoxMenuItem2);
                gRVNotificationBoxMenuItem = gRVNotificationBoxMenuItem2;
            }
            return gRVNotificationBoxMenuItem;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public GriverMenuItem b(String str) {
        ContainerUIProvider containerUIProvider = this.b;
        if (containerUIProvider == null) {
            ACLog.e("CustomMenuExtensionImpl", "ContainerUIProvider#getFavoriteMenuItem is null.");
            return null;
        } else if (!containerUIProvider.itemShowFilter(str, ContainerMoreMenuItemType.Favorite)) {
            ACLog.e("CustomMenuExtensionImpl", "ContainerUIProvider#getFavoriteMenuItem Favorite menu toggle is false.");
            return null;
        } else {
            Map<String, GriverMenuItem> map = f7561a;
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            sb.append(TYPE_FAVORITE);
            GriverMenuItem griverMenuItem = map.get(sb.toString());
            GRVAppFavoriteMenuItem gRVAppFavoriteMenuItem = griverMenuItem;
            if (griverMenuItem == null) {
                final GRVAppFavoriteMenuItem gRVAppFavoriteMenuItem2 = new GRVAppFavoriteMenuItem();
                if (this.b.itemShowRedDot(str, ContainerMoreMenuItemType.Favorite)) {
                    gRVAppFavoriteMenuItem2.enableBadge(str);
                }
                gRVAppFavoriteMenuItem2.listener = new OnMenuItemClickListener() { // from class: com.iap.ac.android.container.adapter.griver.extension.CustomMenuExtensionImpl.4
                    @Override // com.alibaba.griver.api.common.menu.OnMenuItemClickListener
                    public void onItemClick(Page page, String str2) {
                        AppFavoriteStatus appFavoriteStatus;
                        String appId = page.getApp().getAppId();
                        AppModel appModel = (AppModel) page.getApp().getData(AppModel.class);
                        String name = (appModel == null || appModel.getAppInfoModel() == null) ? "" : appModel.getAppInfoModel().getName();
                        GRVAppFavoriteMenuItem.Status status = gRVAppFavoriteMenuItem2.status;
                        if (status == GRVAppFavoriteMenuItem.Status.GRVAppFavoriteStatusCollected) {
                            appFavoriteStatus = AppFavoriteStatus.Collected;
                            PageContext pageContext = page.getPageContext();
                            if (pageContext != null && pageContext.getActivity() != null) {
                                ToastUtils.showToast(pageContext.getActivity(), "Removed from \nFavourite", "success", 0);
                            }
                        } else {
                            appFavoriteStatus = status == GRVAppFavoriteMenuItem.Status.GRVAppFavoriteStatusUncollected ? AppFavoriteStatus.Uncollected : AppFavoriteStatus.Unknow;
                        }
                        CustomMenuExtensionImpl.this.b.onContainerFavoriteMenuClick(appId, name, appFavoriteStatus, new Bundle());
                        gRVAppFavoriteMenuItem2.notifyDataSetChanged();
                    }
                };
                Map<String, GriverMenuItem> map2 = f7561a;
                StringBuilder sb2 = new StringBuilder();
                sb2.append(str);
                sb2.append(TYPE_FAVORITE);
                map2.put(sb2.toString(), gRVAppFavoriteMenuItem2);
                gRVAppFavoriteMenuItem = gRVAppFavoriteMenuItem2;
            }
            return gRVAppFavoriteMenuItem;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public GriverMenuItem c(String str) {
        ContainerUIProvider containerUIProvider = this.b;
        if (containerUIProvider == null) {
            ACLog.e("CustomMenuExtensionImpl", "ContainerUIProvider#getNotificationMenuItem is null.");
            return null;
        } else if (!containerUIProvider.itemShowFilter(str, ContainerMoreMenuItemType.Subscription)) {
            ACLog.e("CustomMenuExtensionImpl", "ContainerUIProvider#getNotificationMenuItem Notification menu toggle is false.");
            return null;
        } else {
            Map<String, GriverMenuItem> map = f7561a;
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            sb.append(TYPE_SUBSCRIPTION);
            GriverMenuItem griverMenuItem = map.get(sb.toString());
            if (griverMenuItem == null) {
                GRVSubscriptionMenuItem gRVSubscriptionMenuItem = new GRVSubscriptionMenuItem();
                gRVSubscriptionMenuItem.listener = new OnMenuItemClickListener() { // from class: com.iap.ac.android.container.adapter.griver.extension.CustomMenuExtensionImpl.5
                    @Override // com.alibaba.griver.api.common.menu.OnMenuItemClickListener
                    public void onItemClick(Page page, String str2) {
                        String appId = page.getApp().getAppId();
                        AppModel appModel = (AppModel) page.getApp().getData(AppModel.class);
                        CustomMenuExtensionImpl.this.b.onContainerSubscriptionMenuClick(appId, (appModel == null || appModel.getAppInfoModel() == null) ? "" : appModel.getAppInfoModel().getName(), new Bundle());
                        MonitorUtil.trackMenuClick(CustomMenuExtensionImpl.TYPE_SUBSCRIPTION);
                    }
                };
                Map<String, GriverMenuItem> map2 = f7561a;
                StringBuilder sb2 = new StringBuilder();
                sb2.append(str);
                sb2.append(TYPE_SUBSCRIPTION);
                map2.put(sb2.toString(), gRVSubscriptionMenuItem);
                return gRVSubscriptionMenuItem;
            }
            return griverMenuItem;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public GriverMenuItem d(String str) {
        ContainerUIProvider containerUIProvider = this.b;
        if (containerUIProvider == null) {
            ACLog.e("CustomMenuExtensionImpl", "ContainerUIProvider#getFeedbackMenuItem is null.");
            return null;
        } else if (!containerUIProvider.itemShowFilter(str, ContainerMoreMenuItemType.Feedback)) {
            ACLog.e("CustomMenuExtensionImpl", "ContainerUIProvider#getFeedbackMenuItem Feedback menu toggle is false.");
            return null;
        } else {
            Map<String, GriverMenuItem> map = f7561a;
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            sb.append(TYPE_FEEDBACK);
            GriverMenuItem griverMenuItem = map.get(sb.toString());
            if (griverMenuItem == null) {
                CustomFeedBackMenu customFeedBackMenu = new CustomFeedBackMenu();
                customFeedBackMenu.listener = new OnMenuItemClickListener() { // from class: com.iap.ac.android.container.adapter.griver.extension.CustomMenuExtensionImpl.6
                    @Override // com.alibaba.griver.api.common.menu.OnMenuItemClickListener
                    public void onItemClick(Page page, String str2) {
                        String appId = page.getApp().getAppId();
                        AppModel appModel = (AppModel) page.getApp().getData(AppModel.class);
                        CustomMenuExtensionImpl.this.b.onContainerFeedbackMenuClick(appId, (appModel == null || appModel.getAppInfoModel() == null) ? "" : appModel.getAppInfoModel().getName(), new Bundle());
                        MonitorUtil.trackMenuClick(CustomMenuExtensionImpl.TYPE_FEEDBACK);
                    }
                };
                Map<String, GriverMenuItem> map2 = f7561a;
                StringBuilder sb2 = new StringBuilder();
                sb2.append(str);
                sb2.append(TYPE_FEEDBACK);
                map2.put(sb2.toString(), customFeedBackMenu);
                return customFeedBackMenu;
            }
            return griverMenuItem;
        }
    }
}
