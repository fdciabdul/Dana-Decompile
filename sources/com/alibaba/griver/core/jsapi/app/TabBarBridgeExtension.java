package com.alibaba.griver.core.jsapi.app;

import android.text.TextUtils;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.TranslateAnimation;
import com.alibaba.ariver.app.api.App;
import com.alibaba.ariver.app.api.AppUIContext;
import com.alibaba.ariver.app.api.Page;
import com.alibaba.ariver.app.api.ui.darkmode.ColorSchemeDecider;
import com.alibaba.ariver.app.api.ui.tabbar.TabBar;
import com.alibaba.ariver.app.api.ui.tabbar.model.TabBarBadgeModel;
import com.alibaba.ariver.app.api.ui.tabbar.model.TabBarItemModel;
import com.alibaba.ariver.app.api.ui.tabbar.model.TabBarModel;
import com.alibaba.ariver.engine.api.bridge.extension.BridgeCallback;
import com.alibaba.ariver.engine.api.bridge.extension.BridgeResponse;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingCallback;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingNode;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingParam;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingRequest;
import com.alibaba.ariver.engine.api.resources.Resource;
import com.alibaba.ariver.kernel.RVConstants;
import com.alibaba.ariver.kernel.api.annotation.ActionFilter;
import com.alibaba.ariver.kernel.api.annotation.AutoCallback;
import com.alibaba.ariver.kernel.api.annotation.ThreadType;
import com.alibaba.ariver.kernel.api.extension.bridge.BridgeExtension;
import com.alibaba.ariver.kernel.api.security.Permission;
import com.alibaba.ariver.kernel.common.service.executor.ExecutorType;
import com.alibaba.ariver.kernel.common.utils.BundleUtils;
import com.alibaba.ariver.kernel.common.utils.ExecutorUtils;
import com.alibaba.ariver.kernel.common.utils.FileUtils;
import com.alibaba.ariver.kernel.common.utils.JSONUtils;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.ariver.kernel.common.utils.TypeUtils;
import com.alibaba.ariver.resource.api.ResourceContext;
import com.alibaba.ariver.resource.api.content.ResourceQuery;
import com.alibaba.ariver.resource.api.storage.TabBarDataStorage;
import com.alibaba.ariver.resource.content.ResourceUtils;
import com.alibaba.ariver.resource.runtime.ResourceContextManager;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.griver.api.common.config.GriverConfigConstants;
import com.alibaba.griver.beehive.lottie.player.DynamicLayerModel;
import com.iap.ac.android.region.cdp.util.CdpConstants;
import java.util.Iterator;

/* loaded from: classes2.dex */
public class TabBarBridgeExtension implements BridgeExtension {
    private static final String TAG = "AriverApp:TabBarBridgeExtension";
    private static final String TYPE_ANIM_ALPHA = "alpha";
    private static final String TYPE_ANIM_TRANSLATE = "translate";

    @Override // com.alibaba.ariver.kernel.api.extension.Extension
    public void onFinalized() {
    }

    @Override // com.alibaba.ariver.kernel.api.security.Guard
    public Permission permit() {
        return null;
    }

    @Override // com.alibaba.ariver.kernel.api.extension.Extension
    public void onInitialized() {
        RVLogger.d(TAG, "onInitialized");
    }

    @ThreadType(ExecutorType.UI)
    @ActionFilter
    @AutoCallback
    public BridgeResponse setTabBar(@BindingParam({"actionType"}) String str, @BindingParam({"tag"}) String str2, @BindingParam({"index"}) Integer num, @BindingRequest JSONObject jSONObject, @BindingNode(App.class) App app, @BindingNode(Page.class) Page page) {
        int indexByPage;
        TabBarItemModel tabBarItemModel;
        int parseColorInt;
        if (app.getAppContext() == null) {
            return BridgeResponse.UNKNOWN_ERROR;
        }
        TabBar tabBar = ((AppUIContext) app.getAppContext()).getTabBar();
        if (tabBar == null) {
            RVLogger.w(TAG, "setTabBar but no tabber!");
            return BridgeResponse.newError(11, "当前页面不在Tabbar上");
        } else if (TextUtils.equals(str, "enable")) {
            tabBar.setEnableTabClick(true);
            return BridgeResponse.SUCCESS;
        } else if (TextUtils.equals(str, GriverConfigConstants.KEY_PRESET_APP_CONFIG_DISABLE)) {
            tabBar.setEnableTabClick(false);
            return BridgeResponse.SUCCESS;
        } else if (TextUtils.equals(str, "showTabBar")) {
            showTabBar(jSONObject, tabBar, page);
            return BridgeResponse.SUCCESS;
        } else if (TextUtils.equals(str, "hideTabBar")) {
            hideTabBar(jSONObject, tabBar);
            return BridgeResponse.SUCCESS;
        } else if (TextUtils.equals(str, "setTabBarStyle")) {
            Integer colorInt = JSONUtils.getColorInt(jSONObject, "color");
            if (jSONObject.containsKey("color") && colorInt == null) {
                return BridgeResponse.newError(2, "color invalid!");
            }
            Integer colorInt2 = JSONUtils.getColorInt(jSONObject, "selectedColor");
            if (jSONObject.containsKey("selectedColor") && colorInt2 == null) {
                return BridgeResponse.newError(2, "selectedColor invalid!");
            }
            Long colorLong = JSONUtils.getColorLong(jSONObject, "backgroundColor");
            if (jSONObject.containsKey("backgroundColor") && colorLong == null) {
                return BridgeResponse.newError(2, "backgroundColor invalid!");
            }
            String string = JSONUtils.getString(jSONObject, "borderStyle");
            Integer num2 = null;
            if (!TextUtils.isEmpty(string)) {
                if (TextUtils.equals(string, "white")) {
                    parseColorInt = -1;
                } else if (TextUtils.equals(string, "black")) {
                    parseColorInt = -1710619;
                } else {
                    parseColorInt = TypeUtils.parseColorInt(string);
                }
                num2 = parseColorInt;
                if (num2 == null) {
                    return BridgeResponse.newError(2, "borderStyleColor invalid!");
                }
            }
            TabBarModel tabbarModel = tabBar.getTabbarModel();
            if (colorInt != null) {
                tabbarModel.setTextColor(colorInt.intValue());
            }
            if (colorInt2 != null) {
                tabbarModel.setSelectedColor(colorInt2.intValue());
            }
            if (colorLong != null) {
                tabbarModel.setBackgroundColor(colorLong.longValue());
            }
            tabBar.changeTabBarStyle(tabbarModel, num2);
            return BridgeResponse.SUCCESS;
        } else {
            if (num != null) {
                indexByPage = num.intValue();
            } else {
                indexByPage = tabBar.getIndexByPage(str2);
            }
            if (indexByPage < 0 || indexByPage > tabBar.getTabbarModel().getItems().size() - 1) {
                return new BridgeResponse.Error(2, "Invalid parameters");
            }
            if (TextUtils.equals(str, "redDot")) {
                TabBarBadgeModel tabBarBadgeModel = new TabBarBadgeModel();
                String string2 = JSONUtils.getString(jSONObject, "redDot");
                int i = JSONUtils.getInt(jSONObject, "redDotColor");
                int i2 = JSONUtils.getInt(jSONObject, "redDotSize");
                tabBarBadgeModel.setBadgeText(string2);
                tabBarBadgeModel.setBadgeColor(i);
                tabBarBadgeModel.setBadgeSize(i2);
                tabBar.setTabBarBadge(indexByPage, tabBarBadgeModel);
            } else {
                if (TextUtils.equals(str, CdpConstants.CONTENT_TEXT_COLOR)) {
                    tabBarItemModel = new TabBarItemModel(tabBar.getTabbarModel().getItems().get(indexByPage));
                    int i3 = JSONUtils.getInt(jSONObject, CdpConstants.CONTENT_TEXT_COLOR);
                    int i4 = JSONUtils.getInt(jSONObject, "selectedColor");
                    tabBarItemModel.setTextColor(Integer.valueOf(i3));
                    tabBarItemModel.setSelectedColor(Integer.valueOf(i4));
                } else if (TextUtils.equals(str, "icon")) {
                    tabBarItemModel = new TabBarItemModel(tabBar.getTabbarModel().getItems().get(indexByPage));
                    String string3 = JSONUtils.getString(jSONObject, "icon");
                    String string4 = JSONUtils.getString(jSONObject, "activeIcon");
                    tabBarItemModel.setIcon(string3);
                    tabBarItemModel.setActiveIcon(string4);
                } else if (TextUtils.equals(str, "setTabBarBadge")) {
                    TabBarBadgeModel tabBarBadgeModel2 = new TabBarBadgeModel();
                    String string5 = JSONUtils.getString(jSONObject, "text");
                    if (!TextUtils.isEmpty(string5)) {
                        tabBarBadgeModel2.setBadgeText(string5);
                        tabBar.setTabBarBadge(indexByPage, tabBarBadgeModel2);
                    } else {
                        return BridgeResponse.INVALID_PARAM;
                    }
                } else if ("removeTabBarBadge".equalsIgnoreCase(str)) {
                    tabBar.removeTabBarBadge(indexByPage);
                } else if ("showTabBarRedDot".equalsIgnoreCase(str)) {
                    tabBar.setTabBarBadge(indexByPage, new TabBarBadgeModel());
                } else if ("hideTabBarRedDot".equalsIgnoreCase(str)) {
                    tabBar.removeTabBarBadge(indexByPage);
                } else if (TextUtils.equals(str, "setTabBarItem")) {
                    tabBarItemModel = new TabBarItemModel(tabBar.getTabbarModel().getItems().get(indexByPage));
                    String string6 = JSONUtils.getString(jSONObject, "text");
                    if (jSONObject.containsKey("text") && TextUtils.isEmpty(string6)) {
                        return BridgeResponse.newError(2, "text invalid!");
                    }
                    String string7 = JSONUtils.getString(jSONObject, "iconPath");
                    if (jSONObject.containsKey("iconPath") && TextUtils.isEmpty(string7)) {
                        return BridgeResponse.newError(2, "iconPath invalid!");
                    }
                    String string8 = JSONUtils.getString(jSONObject, "selectedIconPath");
                    if (jSONObject.containsKey("selectedIconPath") && TextUtils.isEmpty(string8)) {
                        return BridgeResponse.newError(2, "selectedIconPath invalid!");
                    }
                    if (!TextUtils.isEmpty(string7)) {
                        tabBarItemModel.setIcon(string7);
                    }
                    if (!TextUtils.isEmpty(string8)) {
                        tabBarItemModel.setActiveIcon(string8);
                    }
                    if (!TextUtils.isEmpty(string6)) {
                        tabBarItemModel.setName(string6);
                    }
                }
                tabBar.setTabItem(indexByPage, tabBarItemModel);
            }
            return BridgeResponse.SUCCESS;
        }
    }

    private void hideTabBar(@BindingRequest JSONObject jSONObject, final TabBar tabBar) {
        final boolean z = JSONUtils.getBoolean(jSONObject, DynamicLayerModel.FOR_ANIMATION, false);
        final String string = JSONUtils.getString(jSONObject, "animationType");
        ExecutorUtils.runOnMain(new Runnable() { // from class: com.alibaba.griver.core.jsapi.app.TabBarBridgeExtension.1
            @Override // java.lang.Runnable
            public void run() {
                if (tabBar.isShowing()) {
                    tabBar.setAutoShow(false);
                    if (z) {
                        AnimationSet animationSet = new AnimationSet(true);
                        animationSet.setInterpolator(new AccelerateInterpolator());
                        animationSet.setStartTime(AnimationUtils.currentAnimationTimeMillis());
                        animationSet.setDuration(300L);
                        if (TabBarBridgeExtension.TYPE_ANIM_ALPHA.equals(string)) {
                            animationSet.addAnimation(new AlphaAnimation(1.0f, 0.0f));
                        } else if (TabBarBridgeExtension.TYPE_ANIM_TRANSLATE.equals(string)) {
                            animationSet.addAnimation(new TranslateAnimation(2, 0.0f, 2, 0.0f, 2, 0.0f, 2, 1.0f));
                        } else {
                            TranslateAnimation translateAnimation = new TranslateAnimation(2, 0.0f, 2, 0.0f, 2, 0.0f, 2, 1.0f);
                            AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
                            animationSet.addAnimation(translateAnimation);
                            animationSet.addAnimation(alphaAnimation);
                        }
                        tabBar.hide(animationSet);
                        return;
                    }
                    tabBar.hide(null);
                }
            }
        });
    }

    private void showTabBar(@BindingRequest JSONObject jSONObject, final TabBar tabBar, final Page page) {
        final boolean z = JSONUtils.getBoolean(jSONObject, DynamicLayerModel.FOR_ANIMATION, false);
        final String string = JSONUtils.getString(jSONObject, "animationType");
        ExecutorUtils.runOnMain(new Runnable() { // from class: com.alibaba.griver.core.jsapi.app.TabBarBridgeExtension.2
            @Override // java.lang.Runnable
            public void run() {
                if (tabBar.isShowing()) {
                    return;
                }
                tabBar.setAutoShow(true);
                if (z) {
                    AnimationSet animationSet = new AnimationSet(true);
                    animationSet.setInterpolator(new DecelerateInterpolator());
                    animationSet.setStartTime(AnimationUtils.currentAnimationTimeMillis());
                    animationSet.setDuration(300L);
                    if (TabBarBridgeExtension.TYPE_ANIM_ALPHA.equals(string)) {
                        animationSet.addAnimation(new AlphaAnimation(0.0f, 1.0f));
                    } else if (TabBarBridgeExtension.TYPE_ANIM_TRANSLATE.equals(string)) {
                        animationSet.addAnimation(new TranslateAnimation(2, 0.0f, 2, 0.0f, 2, 1.0f, 2, 0.0f));
                    } else {
                        TranslateAnimation translateAnimation = new TranslateAnimation(2, 0.0f, 2, 0.0f, 2, 1.0f, 2, 0.0f);
                        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
                        animationSet.addAnimation(translateAnimation);
                        animationSet.addAnimation(alphaAnimation);
                    }
                    if (tabBar.isTabPage(page)) {
                        tabBar.show(page, animationSet);
                    } else {
                        tabBar.show(null, animationSet);
                    }
                } else if (tabBar.isTabPage(page)) {
                    tabBar.show(page, null);
                } else {
                    tabBar.show(null, null);
                }
            }
        });
    }

    @ThreadType(ExecutorType.UI)
    @ActionFilter
    @AutoCallback
    public BridgeResponse addTabBarItem(@BindingParam({"text"}) String str, @BindingParam({"icon"}) String str2, @BindingParam({"activeIcon"}) String str3, @BindingParam({"tag"}) String str4, @BindingParam({"url"}) String str5, @BindingParam({"index"}) int i, @BindingNode(Page.class) Page page) {
        if (page.getApp() == null || page.getApp().getAppContext() == null) {
            return BridgeResponse.UNKNOWN_ERROR;
        }
        if (TextUtils.isEmpty(str)) {
            return BridgeResponse.newError(2, "empty \"text\" is not allowed!");
        }
        TabBar tabBar = ((AppUIContext) page.getApp().getAppContext()).getTabBar();
        if (tabBar == null || tabBar.getTabbarModel() == null || tabBar.getTabbarModel().getItems() == null || tabBar.getTabbarModel().getItems().size() == 0) {
            return BridgeResponse.newError(11, "当前页面不在Tabbar上");
        }
        if (i < 0 || i >= 5) {
            return BridgeResponse.newError(14, "index must between [0, 5)");
        }
        TabBarModel tabbarModel = tabBar.getTabbarModel();
        if (tabbarModel.getItems().size() >= 5) {
            return BridgeResponse.newError(2, "already have 5 items!");
        }
        if (i >= tabbarModel.getItems().size()) {
            RVLogger.d(TAG, "addTabBarItem index too large, modify it to last one.");
            i = tabbarModel.getItems().size();
        }
        Iterator<TabBarItemModel> it = tabBar.getTabbarModel().getItems().iterator();
        while (it.hasNext()) {
            if (TextUtils.equals(it.next().getTag(), str4)) {
                return BridgeResponse.newError(13, "页面已存在");
            }
        }
        TabBarItemModel tabBarItemModel = new TabBarItemModel();
        tabBarItemModel.setName(str);
        tabBarItemModel.setIcon(str2);
        tabBarItemModel.setActiveIcon(str3);
        tabBarItemModel.setTag(str4);
        tabBarItemModel.setLaunchParamsTag(str4);
        if (TextUtils.isEmpty(str5)) {
            StringBuilder sb = new StringBuilder();
            sb.append("index.html#");
            sb.append(str4);
            tabBarItemModel.setUrl(sb.toString());
        } else {
            tabBarItemModel.setUrl(str5);
        }
        tabbarModel.getItems().add(i, tabBarItemModel);
        tabBar.addTabItem(i, tabBarItemModel, false);
        return BridgeResponse.SUCCESS;
    }

    @ThreadType(ExecutorType.UI)
    @ActionFilter
    @AutoCallback
    public BridgeResponse removeTabBarItem(@BindingParam(required = true, value = {"index"}) int i, @BindingNode(Page.class) Page page) {
        if (page.getApp() == null || page.getApp().getAppContext() == null) {
            return BridgeResponse.UNKNOWN_ERROR;
        }
        TabBar tabBar = ((AppUIContext) page.getApp().getAppContext()).getTabBar();
        if (tabBar == null || tabBar.getTabbarModel() == null || tabBar.getTabbarModel().getItems() == null || tabBar.getTabbarModel().getItems().size() == 0) {
            return BridgeResponse.newError(11, "当前页面不在Tabbar上");
        }
        if (i == tabBar.getCurrentIndex()) {
            return BridgeResponse.newError(13, "cannot delete current item!");
        }
        int size = tabBar.getTabbarModel().getItems().size();
        if (size == 1) {
            StringBuilder sb = new StringBuilder();
            sb.append("item ");
            sb.append(i);
            sb.append(" cannot deleted!");
            return BridgeResponse.newError(16, sb.toString());
        } else if (i >= 5 || i < 0) {
            return BridgeResponse.newError(14, "index must between [0, 5)");
        } else {
            if (i >= size) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("too large index ");
                sb2.append(i);
                sb2.append("(current: ");
                sb2.append(size);
                sb2.append(")");
                return BridgeResponse.newError(15, sb2.toString());
            }
            TabBarItemModel tabBarItemModel = tabBar.getTabbarModel().getItems().get(i);
            tabBar.removeTabItem(i);
            return BridgeResponse.newValue("pagePath", tabBarItemModel.getTag());
        }
    }

    @ThreadType(ExecutorType.UI)
    @ActionFilter
    @AutoCallback
    public BridgeResponse switchTab(@BindingParam({"tag"}) String str, @BindingParam({"recreate"}) boolean z, @BindingNode(Page.class) Page page) {
        if (page.getApp().getAppContext() == null) {
            return BridgeResponse.UNKNOWN_ERROR;
        }
        TabBar tabBar = ((AppUIContext) page.getApp().getAppContext()).getTabBar();
        if (tabBar == null) {
            page.getApp().getAppContext().createTabBar(page);
            ResourceContext resourceContext = ResourceContextManager.getInstance().get(page.getApp().getAppId(), page.getApp().getStartToken());
            ResourceQuery resourceQuery = new ResourceQuery(FileUtils.combinePath(resourceContext.getMainPackageInfo().getAppInfoModel().getVhost(), RVConstants.FILE_TABBAR));
            resourceQuery.setCanUseFallback(true);
            resourceQuery.setNeedAutoCompleteHost();
            resourceQuery.setMainDoc(false);
            if (!page.getApp().isTinyApp()) {
                resourceQuery.setForceNet(true);
            }
            Resource content = resourceContext.getContentProvider().getContent(resourceQuery);
            if (content != null) {
                resourceContext.tabBarDataStorage.onGetData(TabBarModel.inflateFromResource(content, (ColorSchemeDecider) page.getApp().getData(ColorSchemeDecider.class)));
            }
            tabBar = ((AppUIContext) page.getApp().getAppContext()).getTabBar();
            tabBar.show(page, null);
        }
        tabBar.setEnableTabClick(true);
        if (z) {
            tabBar.recreate(str);
        } else {
            int indexByTag = tabBar.getIndexByTag(str);
            if (indexByTag < 0) {
                return BridgeResponse.INVALID_PARAM;
            }
            tabBar.switchTab(indexByTag, 1);
        }
        return BridgeResponse.SUCCESS;
    }

    @ActionFilter
    public void getTabBarStatus(@BindingNode(Page.class) final Page page, @BindingCallback final BridgeCallback bridgeCallback) {
        if (page.getApp().getAppContext() != null) {
            App app = page.getApp();
            String string = BundleUtils.getString(page.getStartParams(), "enableTabBar");
            boolean enableTabBarByAppId = ResourceUtils.enableTabBarByAppId(app.getAppId());
            if (!TextUtils.equals("YES", string) && !enableTabBarByAppId) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("enableTabBar", (Object) Boolean.FALSE);
                bridgeCallback.sendBridgeResponse(new BridgeResponse(jSONObject));
                return;
            }
            ResourceContext resourceContext = ResourceContextManager.getInstance().get(app.getAppId(), app.getStartToken());
            if (resourceContext != null) {
                resourceContext.tabBarDataStorage.retrieveData(new TabBarDataStorage.Listener() { // from class: com.alibaba.griver.core.jsapi.app.TabBarBridgeExtension.3
                    /* JADX WARN: Code restructure failed: missing block: B:14:0x0076, code lost:
                    
                        if (r7.isEmpty() != false) goto L17;
                     */
                    @Override // com.alibaba.ariver.resource.api.storage.TabBarDataStorage.Listener
                    /*
                        Code decompiled incorrectly, please refer to instructions dump.
                        To view partially-correct code enable 'Show inconsistent code' option in preferences
                    */
                    public void onGetData(com.alibaba.ariver.app.api.ui.tabbar.model.TabBarModel r11) {
                        /*
                            r10 = this;
                            java.lang.String r0 = "textColor"
                            java.lang.String r1 = "backgroundColor"
                            java.lang.String r2 = "selectedColor"
                            java.lang.String r3 = "display"
                            com.alibaba.fastjson.JSONObject r4 = new com.alibaba.fastjson.JSONObject
                            r4.<init>()
                            com.alibaba.ariver.app.api.Page r5 = r2
                            com.alibaba.ariver.app.api.App r5 = r5.getApp()
                            com.alibaba.ariver.app.api.AppContext r5 = r5.getAppContext()
                            com.alibaba.ariver.app.api.AppUIContext r5 = (com.alibaba.ariver.app.api.AppUIContext) r5
                            com.alibaba.ariver.app.api.ui.tabbar.TabBar r5 = r5.getTabBar()
                            r6 = 0
                            if (r5 == 0) goto L39
                            com.alibaba.ariver.app.api.ui.tabbar.model.TabBarModel r7 = r5.getTabbarModel()     // Catch: java.lang.Throwable -> L37
                            java.lang.Object r7 = com.alibaba.fastjson.JSONObject.toJSON(r7)     // Catch: java.lang.Throwable -> L37
                            com.alibaba.fastjson.JSONObject r7 = (com.alibaba.fastjson.JSONObject) r7     // Catch: java.lang.Throwable -> L37
                            com.alibaba.ariver.app.api.Page r8 = r2     // Catch: java.lang.Throwable -> L37
                            com.alibaba.ariver.app.api.App r8 = r8.getApp()     // Catch: java.lang.Throwable -> L37
                            java.lang.String r9 = "Json_tabBar"
                            com.alibaba.fastjson.JSONObject r8 = r8.getJsonValue(r9)     // Catch: java.lang.Throwable -> L37
                            goto L3b
                        L37:
                            r0 = move-exception
                            goto L79
                        L39:
                            r7 = r6
                            r8 = r7
                        L3b:
                            if (r7 == 0) goto L70
                            boolean r9 = r7.isEmpty()     // Catch: java.lang.Throwable -> L37
                            if (r9 != 0) goto L70
                            r9 = 1
                            boolean r9 = com.alibaba.ariver.kernel.common.utils.JSONUtils.getBoolean(r8, r3, r9)     // Catch: java.lang.Throwable -> L37
                            java.lang.Boolean r9 = java.lang.Boolean.valueOf(r9)     // Catch: java.lang.Throwable -> L37
                            r7.put(r3, r9)     // Catch: java.lang.Throwable -> L37
                            int r3 = com.alibaba.ariver.kernel.common.utils.JSONUtils.getInt(r8, r2)     // Catch: java.lang.Throwable -> L37
                            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch: java.lang.Throwable -> L37
                            r7.put(r2, r3)     // Catch: java.lang.Throwable -> L37
                            long r2 = com.alibaba.ariver.kernel.common.utils.JSONUtils.getLong(r8, r1)     // Catch: java.lang.Throwable -> L37
                            java.lang.Long r2 = java.lang.Long.valueOf(r2)     // Catch: java.lang.Throwable -> L37
                            r7.put(r1, r2)     // Catch: java.lang.Throwable -> L37
                            long r1 = com.alibaba.ariver.kernel.common.utils.JSONUtils.getLong(r8, r0)     // Catch: java.lang.Throwable -> L37
                            java.lang.Long r1 = java.lang.Long.valueOf(r1)     // Catch: java.lang.Throwable -> L37
                            r7.put(r0, r1)     // Catch: java.lang.Throwable -> L37
                        L70:
                            if (r7 == 0) goto L82
                            boolean r0 = r7.isEmpty()     // Catch: java.lang.Throwable -> L37
                            if (r0 == 0) goto L83
                            goto L82
                        L79:
                            java.lang.String r1 = "AriverApp:TabBarBridgeExtension"
                            java.lang.String r2 = "parse tabBar json "
                            com.alibaba.ariver.kernel.common.utils.RVLogger.e(r1, r2, r0)
                            r7 = r6
                            goto L83
                        L82:
                            r7 = r8
                        L83:
                            java.lang.String r0 = "currentIndex"
                            java.lang.String r1 = "tabBarJSON"
                            java.lang.String r2 = "enableTabBar"
                            java.lang.String r3 = "isShow"
                            if (r11 == 0) goto Lbc
                            if (r7 == 0) goto Lbc
                            boolean r11 = r7.isEmpty()
                            if (r11 != 0) goto Lbc
                            java.lang.Boolean r11 = java.lang.Boolean.TRUE
                            r4.put(r2, r11)
                            r4.put(r1, r7)
                            if (r5 == 0) goto Ld1
                            boolean r11 = r5.isShowing()
                            if (r11 == 0) goto Lab
                            java.lang.Boolean r11 = java.lang.Boolean.TRUE
                            r4.put(r3, r11)
                            goto Lb0
                        Lab:
                            java.lang.Boolean r11 = java.lang.Boolean.FALSE
                            r4.put(r3, r11)
                        Lb0:
                            int r11 = r5.getCurrentIndex()
                            java.lang.Integer r11 = java.lang.Integer.valueOf(r11)
                            r4.put(r0, r11)
                            goto Ld1
                        Lbc:
                            java.lang.Boolean r11 = java.lang.Boolean.TRUE
                            r4.put(r2, r11)
                            r4.put(r1, r6)
                            java.lang.Boolean r11 = java.lang.Boolean.FALSE
                            r4.put(r3, r11)
                            r11 = -1
                            java.lang.Integer r11 = java.lang.Integer.valueOf(r11)
                            r4.put(r0, r11)
                        Ld1:
                            com.alibaba.ariver.engine.api.bridge.extension.BridgeCallback r11 = r3
                            com.alibaba.ariver.engine.api.bridge.extension.BridgeResponse r0 = new com.alibaba.ariver.engine.api.bridge.extension.BridgeResponse
                            r0.<init>(r4)
                            r11.sendBridgeResponse(r0)
                            return
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.griver.core.jsapi.app.TabBarBridgeExtension.AnonymousClass3.onGetData(com.alibaba.ariver.app.api.ui.tabbar.model.TabBarModel):void");
                    }
                });
                return;
            }
            return;
        }
        bridgeCallback.sendBridgeResponse(BridgeResponse.UNKNOWN_ERROR);
    }
}
