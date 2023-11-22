package com.alibaba.ariver.app.ui;

import android.content.res.Configuration;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.animation.Animation;
import com.alibaba.ariver.app.PageNode;
import com.alibaba.ariver.app.api.App;
import com.alibaba.ariver.app.api.Page;
import com.alibaba.ariver.app.api.ParamUtils;
import com.alibaba.ariver.app.api.point.app.AppOnConfigurationChangedPoint;
import com.alibaba.ariver.app.api.point.page.PageExitPoint;
import com.alibaba.ariver.app.api.point.page.PageSwitchInterceptPoint;
import com.alibaba.ariver.app.api.point.page.prerender.PagePreRenderInitPoint;
import com.alibaba.ariver.app.api.ui.darkmode.ThemeUtils;
import com.alibaba.ariver.app.api.ui.fragment.IFragmentManager;
import com.alibaba.ariver.app.api.ui.fragment.RVFragment;
import com.alibaba.ariver.app.api.ui.tabbar.SwitchTabPoint;
import com.alibaba.ariver.app.api.ui.tabbar.TabBar;
import com.alibaba.ariver.app.api.ui.tabbar.model.TabBarItemModel;
import com.alibaba.ariver.app.api.ui.tabbar.model.TabBarModel;
import com.alibaba.ariver.app.proxy.RVPageFactory;
import com.alibaba.ariver.engine.api.EngineUtils;
import com.alibaba.ariver.engine.api.bridge.model.SendToRenderCallback;
import com.alibaba.ariver.kernel.RVConstants;
import com.alibaba.ariver.kernel.RVEvents;
import com.alibaba.ariver.kernel.RVParams;
import com.alibaba.ariver.kernel.RVStartParams;
import com.alibaba.ariver.kernel.api.extension.ExtensionManager;
import com.alibaba.ariver.kernel.api.extension.ExtensionPoint;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.log.AppLogContext;
import com.alibaba.ariver.kernel.common.log.AppLogUtils;
import com.alibaba.ariver.kernel.common.log.PageSource;
import com.alibaba.ariver.kernel.common.service.RVConfigService;
import com.alibaba.ariver.kernel.common.service.RVExtensionService;
import com.alibaba.ariver.kernel.common.utils.BundleUtils;
import com.alibaba.ariver.kernel.common.utils.ExecutorUtils;
import com.alibaba.ariver.kernel.common.utils.FileUtils;
import com.alibaba.ariver.kernel.common.utils.JSONUtils;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.ariver.kernel.common.utils.UrlUtils;
import com.alibaba.fastjson.JSONObject;
import io.opentelemetry.semconv.trace.attributes.SemanticAttributes;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* loaded from: classes6.dex */
public abstract class BaseTabBar implements TabBar {
    protected static final String TAG = "AriverInt:TabBar";
    private App mApp;
    private IFragmentManager mFragmentManager;
    private Page mSelectedPage;
    private TabBarModel mTabBarItemModel;
    private final Set<Page> mTabPages = new HashSet();
    private final SparseArray<Page> mPageIndexArray = new SparseArray<>();
    private boolean mAlphaBackground = false;
    private boolean mEnableTabClick = true;
    private boolean mIsCreating = false;
    private boolean mAlreadyCreated = false;
    private boolean mIsInReset = false;
    private boolean mIsShowing = false;
    private boolean mAutoShow = true;
    private int mCreateIndex = -1;
    private int mCurrentIndex = -1;
    private boolean mCurrentUsingDarkMode = false;

    protected boolean enableInterceptTabClick() {
        return false;
    }

    @Override // com.alibaba.ariver.app.api.ui.tabbar.TabBar
    public void showDefaultTab(int i) {
    }

    /* loaded from: classes6.dex */
    class TabBarManageExtension implements AppOnConfigurationChangedPoint, PageExitPoint {
        @Override // com.alibaba.ariver.kernel.api.extension.Extension
        public void onFinalized() {
        }

        @Override // com.alibaba.ariver.kernel.api.extension.Extension
        public void onInitialized() {
        }

        TabBarManageExtension() {
        }

        @Override // com.alibaba.ariver.app.api.point.page.PageExitPoint
        public void onPageExit(Page page) {
            StringBuilder sb = new StringBuilder();
            sb.append("handle page exit! ");
            sb.append(page);
            sb.append(" isInReset: ");
            sb.append(BaseTabBar.this.mIsInReset);
            RVLogger.d(BaseTabBar.TAG, sb.toString());
            if (BaseTabBar.this.mIsInReset || page.getApp() == null || page.getApp().isExited()) {
                return;
            }
            int size = BaseTabBar.this.mPageIndexArray.size();
            for (int i = 0; i < size; i++) {
                int keyAt = BaseTabBar.this.mPageIndexArray.keyAt(i);
                if (BaseTabBar.this.mPageIndexArray.get(keyAt) == page) {
                    BaseTabBar.this.mPageIndexArray.delete(keyAt);
                }
            }
            if (BaseTabBar.this.mTabPages.remove(page) && BaseTabBar.this.mTabPages.size() == 0) {
                BaseTabBar.this.reset();
            }
            BaseTabBar.this.printArray();
        }

        @Override // com.alibaba.ariver.app.api.point.app.AppOnConfigurationChangedPoint
        public void onConfigurationChanged(App app, Configuration configuration, String str) {
            boolean isDarkMode;
            StringBuilder sb = new StringBuilder();
            sb.append("onConfigurationChanged colorScheme: ");
            sb.append(str);
            RVLogger.d(BaseTabBar.TAG, sb.toString());
            if (!ThemeUtils.isSupportDarkTheme(BaseTabBar.this.mApp) || BaseTabBar.this.mCurrentUsingDarkMode == (isDarkMode = ThemeUtils.isDarkMode(BaseTabBar.this.mApp.getAppContext().getContext()))) {
                return;
            }
            BaseTabBar.this.mCurrentUsingDarkMode = isDarkMode;
            BaseTabBar.this.onThemeChanged(isDarkMode);
        }
    }

    public BaseTabBar(App app, IFragmentManager iFragmentManager) {
        this.mApp = app;
        this.mFragmentManager = iFragmentManager;
        ExtensionManager extensionManager = ((RVExtensionService) RVProxy.get(RVExtensionService.class)).getExtensionManager();
        extensionManager.registerExtensionByPoint(this.mApp, PageExitPoint.class, new TabBarManageExtension());
        extensionManager.registerExtensionByPoint(this.mApp, AppOnConfigurationChangedPoint.class, new TabBarManageExtension());
    }

    @Override // com.alibaba.ariver.app.api.ui.tabbar.TabBar
    public boolean isAutoShow() {
        return this.mAutoShow;
    }

    @Override // com.alibaba.ariver.app.api.ui.tabbar.TabBar
    public void setAutoShow(boolean z) {
        this.mAutoShow = z;
    }

    @Override // com.alibaba.ariver.app.api.ui.tabbar.TabBar
    public Page getSelectedPage() {
        Page page;
        synchronized (this) {
            page = this.mSelectedPage;
        }
        return page;
    }

    @Override // com.alibaba.ariver.app.api.ui.tabbar.TabBar
    public void setSelectedPage(Page page) {
        synchronized (this) {
            this.mSelectedPage = page;
        }
    }

    protected Page getPageAt(int i) {
        return this.mPageIndexArray.get(i);
    }

    public Page createPage(TabBarItemModel tabBarItemModel, String str, Bundle bundle, Bundle bundle2) {
        PagePreRenderInitPoint.PagePreRenderHolder readyPreRenderHolderWithReset;
        RVPageFactory rVPageFactory = (RVPageFactory) RVProxy.get(RVPageFactory.class);
        Bundle clone = BundleUtils.clone(bundle);
        Bundle clone2 = BundleUtils.clone(bundle2);
        ParamUtils.filterCreatePageParams(clone);
        if (enableMergeTabParams() && tabBarItemModel.getLaunchParams() != null && !tabBarItemModel.getLaunchParams().isEmpty()) {
            ParamUtils.mergeParams(clone, tabBarItemModel.getLaunchParams());
        }
        clone.putString(RVStartParams.KEY_FRAGMENT_TYPE, RVStartParams.FRAGMENT_TYPE_SUB_TAB);
        PagePreRenderInitPoint pagePreRenderInitPoint = (PagePreRenderInitPoint) ExtensionPoint.as(PagePreRenderInitPoint.class).node(this.mApp).nullable().create();
        if (pagePreRenderInitPoint != null && (readyPreRenderHolderWithReset = pagePreRenderInitPoint.getReadyPreRenderHolderWithReset(this.mApp, clone, clone2, str, false)) != null && readyPreRenderHolderWithReset.preRenderPage != null) {
            ((PageNode) readyPreRenderHolderWithReset.preRenderPage).init(str, clone, clone2);
            StringBuilder sb = new StringBuilder();
            sb.append("PreRenderPage switchPage  use prerender  ");
            sb.append(readyPreRenderHolderWithReset);
            RVLogger.d(TAG, sb.toString());
            return readyPreRenderHolderWithReset.preRenderPage;
        }
        return rVPageFactory.createPage(this.mApp, str, clone, clone2);
    }

    public void onThemeChanged(boolean z) {
        setAlphaBackground(getTabbarModel().getBackgroundColor());
        StringBuilder sb = new StringBuilder();
        sb.append("onThemeChanged! useDarkMode: ");
        sb.append(z);
        RVLogger.d(TAG, sb.toString());
    }

    @Override // com.alibaba.ariver.app.api.ui.tabbar.TabBar
    public void init(TabBarModel tabBarModel) {
        if (tabBarModel == null || this.mApp.getAppContext() == null) {
            return;
        }
        this.mTabBarItemModel = tabBarModel;
        this.mCurrentUsingDarkMode = ThemeUtils.isDarkMode(this.mApp.getAppContext().getContext());
        setAlphaBackground(getTabbarModel().getBackgroundColor());
        boolean isDisableOnInit = this.mTabBarItemModel.isDisableOnInit();
        StringBuilder sb = new StringBuilder();
        sb.append("TabBar.init usingDarkMode: ");
        sb.append(this.mCurrentUsingDarkMode);
        sb.append(" disableOnInit ");
        sb.append(isDisableOnInit);
        RVLogger.d(TAG, sb.toString());
        if (isDisableOnInit) {
            this.mEnableTabClick = false;
        }
    }

    private void setAlphaBackground(long j) {
        if (j <= 16777215) {
            j |= -16777216;
        }
        if (Color.alpha((int) j) != 255) {
            this.mAlphaBackground = true;
        }
    }

    @Override // com.alibaba.ariver.app.api.ui.tabbar.TabBar
    public int getCreateIndex() {
        return this.mCreateIndex;
    }

    @Override // com.alibaba.ariver.app.api.ui.tabbar.TabBar
    public void create(Page page) {
        String pagePurifyUrlForH5;
        String purifyUrl;
        this.mAlreadyCreated = true;
        this.mIsCreating = true;
        this.mSelectedPage = page;
        TabBarModel tabBarModel = this.mTabBarItemModel;
        if (tabBarModel != null) {
            List<TabBarItemModel> items = tabBarModel.getItems();
            boolean isTinyApp = this.mApp.isTinyApp();
            if (isTinyApp) {
                pagePurifyUrlForH5 = UrlUtils.getHash(page.getPageURI());
            } else {
                pagePurifyUrlForH5 = getPagePurifyUrlForH5(page);
            }
            int i = -1;
            if (items != null && !items.isEmpty()) {
                int size = items.size();
                if ("yes".equalsIgnoreCase(((RVConfigService) RVProxy.get(RVConfigService.class)).getConfigWithProcessCache("h5_deleteTabBarItem", "yes")) && size > 5) {
                    RVLogger.d(TAG, "delete tabBar item");
                    items = items.subList(0, 5);
                    TabBarModel tabBarModel2 = this.mTabBarItemModel;
                    tabBarModel2.setItems(tabBarModel2.getItems().subList(0, 5));
                    size = 5;
                }
                int i2 = 0;
                while (i2 < size && i2 < 5) {
                    TabBarItemModel tabBarItemModel = items.get(i2);
                    if (isTinyApp) {
                        purifyUrl = tabBarItemModel.getLaunchParamsTag();
                    } else {
                        purifyUrl = UrlUtils.purifyUrl(tabBarItemModel.getUrl());
                    }
                    if (TextUtils.equals(pagePurifyUrlForH5, purifyUrl)) {
                        if (enableMergeTabParams() && tabBarItemModel.getLaunchParams() != null && !tabBarItemModel.getLaunchParams().isEmpty()) {
                            ParamUtils.mergeParams(page.getStartParams(), tabBarItemModel.getLaunchParams());
                        }
                        i = i2;
                    }
                    addTabItem(i2, tabBarItemModel, i2 == i);
                    i2++;
                }
            }
            this.mCreateIndex = i;
            this.mCurrentIndex = i;
            this.mTabPages.add(page);
            this.mPageIndexArray.put(i, page);
        }
        this.mIsCreating = false;
    }

    private static boolean enableMergeTabParams() {
        return "yes".equalsIgnoreCase(((RVConfigService) RVProxy.get(RVConfigService.class)).getConfigWithProcessCache("h5_enableMergeTabLaunchParams", "yes"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void printArray() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        int size = this.mPageIndexArray.size();
        for (int i = 0; i < size; i++) {
            if (i > 0) {
                sb.append(",");
            }
            int keyAt = this.mPageIndexArray.keyAt(i);
            Page page = this.mPageIndexArray.get(keyAt);
            sb.append("(");
            sb.append(keyAt);
            sb.append(", ");
            sb.append(page);
            sb.append(")");
        }
        sb.append("]");
        StringBuilder sb2 = new StringBuilder();
        sb2.append("printArray: ");
        sb2.append((Object) sb);
        RVLogger.d(TAG, sb2.toString());
    }

    @Override // com.alibaba.ariver.app.api.ui.tabbar.TabBar
    public void addTabItem(int i, TabBarItemModel tabBarItemModel, boolean z) {
        StringBuilder sb = new StringBuilder();
        sb.append("addTabItem with model, index: ");
        sb.append(i);
        sb.append(" model: ");
        sb.append(tabBarItemModel);
        RVLogger.d(TAG, sb.toString());
        if (!this.mIsCreating) {
            int size = this.mTabBarItemModel.getItems().size();
            if (!"yes".equalsIgnoreCase(((RVConfigService) RVProxy.get(RVConfigService.class)).getConfigWithProcessCache("h5_enableKeepNullPageItem", "yes"))) {
                while (true) {
                    size--;
                    if (size < i) {
                        break;
                    }
                    Page page = this.mPageIndexArray.get(size);
                    if (page != null) {
                        this.mPageIndexArray.remove(size);
                        this.mPageIndexArray.put(size + 1, page);
                    }
                }
            } else if (this.mPageIndexArray.get(i) != null) {
                while (true) {
                    size--;
                    if (size < i) {
                        break;
                    }
                    Page page2 = this.mPageIndexArray.get(size);
                    if (page2 != null) {
                        this.mPageIndexArray.remove(size);
                        this.mPageIndexArray.put(size + 1, page2);
                    }
                }
            }
            int i2 = this.mCurrentIndex;
            if (i <= i2) {
                this.mCurrentIndex = i2 + 1;
            }
        }
        printArray();
    }

    @Override // com.alibaba.ariver.app.api.ui.tabbar.TabBar
    public void removeTabItem(int i) {
        Page pageAt = getPageAt(i);
        StringBuilder sb = new StringBuilder();
        sb.append("removeTabItem: ");
        sb.append(i);
        sb.append(", page: ");
        sb.append(pageAt);
        RVLogger.d(TAG, sb.toString());
        if ("yes".equalsIgnoreCase(((RVConfigService) RVProxy.get(RVConfigService.class)).getConfigWithProcessCache("h5_useNewremoveTabItem", "yes"))) {
            this.mTabBarItemModel.getItems().remove(i);
            int i2 = this.mCurrentIndex;
            if (i <= i2) {
                this.mCurrentIndex = i2 - 1;
            }
            this.mPageIndexArray.remove(i);
            int size = this.mTabBarItemModel.getItems().size();
            while (i < size) {
                int i3 = i + 1;
                Page page = this.mPageIndexArray.get(i3);
                if (page != null) {
                    this.mPageIndexArray.remove(i3);
                    this.mPageIndexArray.put(i, page);
                }
                i = i3;
            }
            if (pageAt != null) {
                this.mTabPages.remove(pageAt);
                pageAt.exit(false);
            }
        } else if (pageAt == null) {
            return;
        } else {
            this.mPageIndexArray.remove(i);
            int size2 = this.mTabBarItemModel.getItems().size();
            int i4 = i;
            while (i4 < size2 - 1) {
                int i5 = i4 + 1;
                Page page2 = this.mPageIndexArray.get(i5);
                if (page2 != null) {
                    this.mPageIndexArray.remove(i5);
                    this.mPageIndexArray.put(i4, page2);
                }
                i4 = i5;
            }
            if (pageAt != null) {
                this.mTabPages.remove(pageAt);
                pageAt.exit(false);
            }
            this.mTabBarItemModel.getItems().remove(i);
            int i6 = this.mCurrentIndex;
            if (i <= i6) {
                this.mCurrentIndex = i6 - 1;
            }
        }
        printArray();
    }

    @Override // com.alibaba.ariver.app.api.ui.tabbar.TabBar
    public void changeTabBarStyle(TabBarModel tabBarModel, Integer num) {
        setAlphaBackground(tabBarModel.getBackgroundColor());
    }

    @Override // com.alibaba.ariver.app.api.ui.tabbar.TabBar
    public void show(Page page, Animation animation) {
        RVLogger.d(TAG, "tabbar show!");
        this.mIsShowing = true;
        if (page != null) {
            if (!this.mAlreadyCreated) {
                create(page);
            } else {
                handleSwitchTab(page, false, 0);
            }
        }
    }

    @Override // com.alibaba.ariver.app.api.ui.tabbar.TabBar
    public void hide(Animation animation) {
        RVLogger.d(TAG, "tabbar hide!");
        this.mIsShowing = false;
    }

    @Override // com.alibaba.ariver.app.api.ui.tabbar.TabBar
    public boolean isShowing() {
        return this.mIsShowing;
    }

    @Override // com.alibaba.ariver.app.api.ui.tabbar.TabBar
    public boolean isCreated() {
        return this.mAlreadyCreated;
    }

    @Override // com.alibaba.ariver.app.api.ui.tabbar.TabBar
    public void setEnableTabClick(boolean z) {
        this.mEnableTabClick = z;
    }

    @Override // com.alibaba.ariver.app.api.ui.tabbar.TabBar
    public boolean isEnableTabClick() {
        return this.mEnableTabClick;
    }

    public boolean isAlphaBackground() {
        return this.mAlphaBackground;
    }

    public App getApp() {
        return this.mApp;
    }

    @Override // com.alibaba.ariver.app.api.ui.tabbar.TabBar
    public int getPageCount() {
        return this.mTabPages.size();
    }

    @Override // com.alibaba.ariver.app.api.ui.tabbar.TabBar
    public int getCurrentIndex() {
        return this.mCurrentIndex;
    }

    @Override // com.alibaba.ariver.app.api.ui.tabbar.TabBar
    public boolean isTabPage(Page page) {
        String pagePurifyUrlForH5;
        String url;
        if (this.mTabPages.contains(page)) {
            return true;
        }
        if (BundleUtils.getBoolean(page.getStartParams(), RVStartParams.KEY_NEW_PAGE_FROM_PUSH_WINDOW, false)) {
            return false;
        }
        boolean isTinyApp = this.mApp.isTinyApp();
        if (isTinyApp) {
            pagePurifyUrlForH5 = UrlUtils.getHash(page.getPageURI());
        } else {
            pagePurifyUrlForH5 = getPagePurifyUrlForH5(page);
        }
        TabBarModel tabBarModel = this.mTabBarItemModel;
        if (tabBarModel != null && tabBarModel.getItems() != null) {
            for (TabBarItemModel tabBarItemModel : this.mTabBarItemModel.getItems()) {
                if (isTinyApp) {
                    url = tabBarItemModel.getLaunchParamsTag();
                } else {
                    url = tabBarItemModel.getUrl();
                }
                if (TextUtils.equals(url, UrlUtils.purifyUrl(pagePurifyUrlForH5))) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override // com.alibaba.ariver.app.api.ui.tabbar.TabBar
    public int getIndexByTag(String str) {
        List<TabBarItemModel> items;
        TabBarModel tabBarModel = this.mTabBarItemModel;
        if (tabBarModel != null && (items = tabBarModel.getItems()) != null && items.size() != 0) {
            int size = items.size();
            for (int i = 0; i < size; i++) {
                if (TextUtils.equals(str, items.get(i).getLaunchParamsTag())) {
                    return i;
                }
            }
        }
        return -1;
    }

    @Override // com.alibaba.ariver.app.api.ui.tabbar.TabBar
    public int getIndexByPage(String str) {
        List<TabBarItemModel> items;
        String purifyUrl;
        TabBarModel tabBarModel = this.mTabBarItemModel;
        if (tabBarModel != null && (items = tabBarModel.getItems()) != null && items.size() != 0) {
            int size = items.size();
            for (int i = 0; i < size; i++) {
                TabBarItemModel tabBarItemModel = items.get(i);
                if (this.mApp.isTinyApp()) {
                    purifyUrl = tabBarItemModel.getLaunchParamsTag();
                } else {
                    purifyUrl = UrlUtils.purifyUrl(tabBarItemModel.getUrl());
                }
                if (TextUtils.equals(str, purifyUrl)) {
                    return i;
                }
            }
        }
        return -1;
    }

    @Override // com.alibaba.ariver.app.api.ui.tabbar.TabBar
    public int getIndexByPage(Page page) {
        String pagePurifyUrlForH5;
        if (this.mApp.isTinyApp()) {
            pagePurifyUrlForH5 = UrlUtils.getHash(page.getPageURI());
        } else {
            pagePurifyUrlForH5 = getPagePurifyUrlForH5(page);
        }
        return getIndexByPage(pagePurifyUrlForH5);
    }

    @Override // com.alibaba.ariver.app.api.ui.tabbar.TabBar
    public void recreate(String str) {
        String pageURI;
        int indexOf;
        if (this.mApp.getActivePage() == null || (indexOf = (pageURI = this.mApp.getActivePage().getPageURI()).indexOf(35)) == -1) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(pageURI.substring(0, indexOf + 1));
        sb.append(str);
        String obj = sb.toString();
        Bundle clone = BundleUtils.clone(this.mApp.getStartParams());
        clone.putString(RVStartParams.KEY_FROM_TYPE, RVStartParams.FROM_TYPE_PUSH_RELAUNCH);
        this.mApp.relaunchToUrl(obj, clone, BundleUtils.clone(this.mApp.getSceneParams()));
    }

    @Override // com.alibaba.ariver.app.api.ui.tabbar.TabBar
    public boolean switchTab(int i, int i2) {
        StringBuilder sb = new StringBuilder();
        sb.append("switchTab to index: ");
        sb.append(i);
        sb.append(" fromType: ");
        sb.append(i2);
        RVLogger.d(TAG, sb.toString());
        if (i2 != 2 || isEnableTabClick()) {
            if (i2 == 1) {
                setEnableTabClick(true);
            }
            if (this.mAlreadyCreated) {
                ArrayList<Page> arrayList = new ArrayList();
                for (int alivePageCount = this.mApp.getAlivePageCount() - 1; alivePageCount >= 0; alivePageCount--) {
                    Page pageByIndex = this.mApp.getPageByIndex(alivePageCount);
                    if (!pageByIndex.isUseForEmbed() && !this.mTabPages.contains(pageByIndex)) {
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("switchTab exit nonTabBar Page: ");
                        sb2.append(pageByIndex);
                        RVLogger.d(TAG, sb2.toString());
                        arrayList.add(pageByIndex);
                    }
                }
                for (Page page : arrayList) {
                    ((Page.AnimStore) page.getData(Page.AnimStore.class, true)).disableExit = true;
                    page.exit(false);
                }
            }
            int i3 = this.mCurrentIndex;
            if (i == i3) {
                RVLogger.d(TAG, "switchTab already in this index!!!");
                return sendTabClickToRender(i, i3, i2);
            }
            this.mCurrentIndex = i;
            if (this.mTabBarItemModel == null) {
                RVLogger.e(TAG, "switchTab but not inflate yet!!!");
            }
            if (sendTabClickToRender(i, i3, i2)) {
                RVLogger.d(TAG, "switchTab sendTabClickToRender intercept !");
                return true;
            }
            RVLogger.d(TAG, "switchTabDirect!");
            onSwitchTab(i, i2);
            return true;
        }
        return false;
    }

    private boolean sendTabClickToRender(final int i, final int i2, final int i3) {
        boolean z = i3 == 2;
        boolean z2 = i3 == 1;
        boolean equalsIgnoreCase = "yes".equalsIgnoreCase(((RVConfigService) RVProxy.get(RVConfigService.class)).getConfigWithProcessCache("ariver_sendTabClickByJSAPI", "yes"));
        boolean z3 = i == i2;
        if (z || (equalsIgnoreCase && z2)) {
            TabBarItemModel tabBarItemModel = getTabbarModel().getItems().get(i);
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("tag", (Object) tabBarItemModel.getTag());
            jSONObject.put("index", (Object) Integer.valueOf(i));
            jSONObject.put("pagePath", (Object) tabBarItemModel.getTag());
            jSONObject.put("text", (Object) getTabbarModel().getItems().get(i).getName());
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("data", (Object) jSONObject);
            String str = z3 ? RVEvents.SELECTED_TAB_CLICK : RVEvents.TAB_CLICK;
            Page activePage = getApp().getActivePage();
            if (activePage != null && activePage.getRender() != null) {
                StringBuilder sb = new StringBuilder();
                sb.append("switchTab with tabClick on selected : ");
                sb.append(z3);
                RVLogger.d(TAG, sb.toString());
                final boolean enableInterceptTabClick = enableInterceptTabClick();
                EngineUtils.sendToRender(activePage.getRender(), str, jSONObject2, z3 ? null : new SendToRenderCallback() { // from class: com.alibaba.ariver.app.ui.BaseTabBar.1
                    @Override // com.alibaba.ariver.engine.api.bridge.model.SendToRenderCallback
                    public void onCallBack(JSONObject jSONObject3) {
                        if (enableInterceptTabClick) {
                            if (JSONUtils.getBoolean(jSONObject3, RVConstants.EXTRA_PREVENTED, false)) {
                                StringBuilder sb2 = new StringBuilder();
                                sb2.append("sendTabClickEventToWeb prevented change current to origin: ");
                                sb2.append(i2);
                                RVLogger.d(BaseTabBar.TAG, sb2.toString());
                                BaseTabBar.this.mCurrentIndex = i2;
                                return;
                            }
                            ExecutorUtils.runOnMain(new Runnable() { // from class: com.alibaba.ariver.app.ui.BaseTabBar.1.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    if (BaseTabBar.this.getApp() == null || BaseTabBar.this.getApp().isExited()) {
                                        return;
                                    }
                                    BaseTabBar.this.onSwitchTab(i, i3);
                                }
                            });
                        }
                    }
                });
                if (!enableInterceptTabClick && !z3) {
                    RVLogger.d(TAG, "onSwitchTab");
                    onSwitchTab(i, i3);
                    return true;
                }
            }
            return true;
        }
        return false;
    }

    public void onSwitchTab(int i, int i2) {
        TabBarItemModel tabBarItemModel = this.mTabBarItemModel.getItems().get(i);
        Page pageAt = getPageAt(i);
        if (pageAt != null) {
            handleSwitchTab(pageAt, false, i2);
        } else {
            Bundle startParams = this.mApp.getStartParams();
            String string = BundleUtils.getString(startParams, "onlineHost");
            String url = tabBarItemModel.getUrl();
            if (!url.startsWith(SemanticAttributes.FaasTriggerValues.HTTP)) {
                url = FileUtils.combinePath(string, tabBarItemModel.getUrl());
            }
            PageSwitchInterceptPoint pageSwitchInterceptPoint = (PageSwitchInterceptPoint) ExtensionPoint.as(PageSwitchInterceptPoint.class).node(this.mApp).nullable().create();
            if (pageSwitchInterceptPoint != null) {
                url = pageSwitchInterceptPoint.interceptSwitchPage(this.mApp, url, startParams);
            }
            Page createPage = createPage(tabBarItemModel, url, startParams, this.mApp.getSceneParams());
            this.mPageIndexArray.put(i, createPage);
            handleSwitchTab(createPage, true, i2);
        }
        ((SwitchTabPoint) ExtensionPoint.as(SwitchTabPoint.class).node(this.mApp).create()).onSwitchTab(this.mApp, i);
    }

    private void handleSwitchTab(Page page, boolean z, int i) {
        boolean z2;
        PagePreRenderInitPoint pagePreRenderInitPoint;
        PagePreRenderInitPoint.PagePreRenderHolder readyPreRenderHolderWithReset;
        synchronized (this) {
            if (isCreated()) {
                z2 = false;
            } else {
                StringBuilder sb = new StringBuilder();
                sb.append("handleSwitchTab but not created! createTabBar for ");
                sb.append(page);
                RVLogger.d(TAG, sb.toString());
                create(page);
                z2 = true;
            }
            if (z2 || page != this.mSelectedPage) {
                deviceLogSwitchTab(page, i);
                StringBuilder sb2 = new StringBuilder();
                sb2.append("handleSwitchTab newPage: ");
                sb2.append(page);
                sb2.append(" selectedPage: ");
                sb2.append(this.mSelectedPage);
                RVLogger.d(TAG, sb2.toString());
                this.mSelectedPage = page;
                setPageToTop(page);
                if (z) {
                    this.mTabPages.add(page);
                } else {
                    page.show(null);
                }
                RVFragment findFragmentForPage = this.mFragmentManager.findFragmentForPage(page);
                if (findFragmentForPage == null) {
                    if (page.getBooleanValue(RVParams.IS_PAGE_PRERENDER) && (pagePreRenderInitPoint = (PagePreRenderInitPoint) ExtensionPoint.as(PagePreRenderInitPoint.class).node(this.mApp).nullable().create()) != null && (readyPreRenderHolderWithReset = pagePreRenderInitPoint.getReadyPreRenderHolderWithReset(this.mApp, page.getStartParams(), page.getSceneParams(), page.getPageURI(), true)) != null && readyPreRenderHolderWithReset.preRenderFragment != null) {
                        findFragmentForPage = readyPreRenderHolderWithReset.preRenderFragment;
                        StringBuilder sb3 = new StringBuilder();
                        sb3.append("PreRenderPage switchTag use prerender Fragment  ");
                        sb3.append(findFragmentForPage);
                        RVLogger.d(TAG, sb3.toString());
                    }
                    if (findFragmentForPage == null) {
                        findFragmentForPage = this.mFragmentManager.createFragment();
                    }
                    Bundle bundle = new Bundle();
                    bundle.putLong(RVConstants.EXTRA_APP_INSTANCE_ID, this.mApp.getNodeId());
                    bundle.putLong(RVConstants.EXTRA_PAGE_INSTANCE_ID, page.getNodeId());
                    findFragmentForPage.setArguments(bundle);
                    this.mFragmentManager.pushPage(page, findFragmentForPage, false);
                } else {
                    this.mFragmentManager.attachFragment(findFragmentForPage, false);
                }
                this.mFragmentManager.resetFragmentToTop(findFragmentForPage);
                if (this.mApp.getEngineProxy() != null && this.mApp.getEngineProxy().getEngineRouter() != null && page.getRender() != null) {
                    this.mApp.getEngineProxy().getEngineRouter().resetRenderToTop(page.getRender());
                }
                Set<RVFragment> fragments = this.mFragmentManager.getFragments();
                if (fragments != null) {
                    for (RVFragment rVFragment : fragments) {
                        if (rVFragment != findFragmentForPage) {
                            this.mFragmentManager.detachFragment(rVFragment, false);
                        }
                    }
                }
            }
        }
    }

    protected void setPageToTop(Page page) {
        while (this.mApp.peekChild() != null) {
            Page page2 = (Page) this.mApp.peekChild();
            page2.hide();
            if (!isTabPage(page2)) {
                StringBuilder sb = new StringBuilder();
                sb.append("handleSwitchTab exit notTabPage ");
                sb.append(page2);
                RVLogger.d(TAG, sb.toString());
                page2.exit(false);
            }
            this.mApp.removeChild(page2);
        }
        this.mApp.pushChild(page);
    }

    @Override // com.alibaba.ariver.app.api.ui.tabbar.TabBar
    public TabBarModel getTabbarModel() {
        return this.mTabBarItemModel;
    }

    @Override // com.alibaba.ariver.app.api.ui.tabbar.TabBar
    public void setTabItem(int i, TabBarItemModel tabBarItemModel) {
        TabBarModel tabBarModel;
        if (i < 0 || tabBarItemModel == null || (tabBarModel = this.mTabBarItemModel) == null) {
            return;
        }
        tabBarModel.getItems().set(i, tabBarItemModel);
    }

    @Override // com.alibaba.ariver.app.api.ui.tabbar.TabBar
    public void reset() {
        RVLogger.w(TAG, "reset in stack: ", new Throwable("Just Print Stack"));
        this.mIsInReset = true;
        try {
            this.mCurrentIndex = -1;
            this.mAlreadyCreated = false;
            for (Page page : this.mTabPages) {
                ((Page.AnimStore) page.getData(Page.AnimStore.class, true)).disableExit = true;
                page.exit(this.mApp.isExited());
            }
            this.mTabPages.clear();
            this.mPageIndexArray.clear();
        } finally {
            this.mIsInReset = false;
        }
    }

    @Override // com.alibaba.ariver.app.api.ui.tabbar.TabBar
    public Set<Page> getTabPages() {
        return this.mTabPages;
    }

    @Override // com.alibaba.ariver.app.api.ui.tabbar.TabBar
    public void onDestroy() {
        reset();
    }

    private void deviceLogSwitchTab(Page page, int i) {
        Page page2;
        if (page == null || (page2 = this.mSelectedPage) == null) {
            return;
        }
        String parentId = AppLogUtils.getParentId(page2);
        PageSource pageSource = ((AppLogContext) page.getData(AppLogContext.class, true)).getPageSource();
        pageSource.sourcePageAppLogToken = parentId;
        PageSource.SourceType sourceType = PageSource.SourceType.UNKNOWN;
        if (i == 0) {
            sourceType = PageSource.SourceType.TAB_INIT;
        } else if (i == 1) {
            sourceType = PageSource.SourceType.SWITCH_TAB;
        } else if (i == 2) {
            sourceType = PageSource.SourceType.TAB_CLICK;
        } else if (i == 3) {
            sourceType = PageSource.SourceType.TAB_PUSH;
        }
        pageSource.sourceType = sourceType;
        Page page3 = this.mSelectedPage;
        if (page3 != null) {
            pageSource.sourceDesc = page3.getPageURI();
        }
    }

    private String getPagePurifyUrlForH5(Page page) {
        String purifyUrl = UrlUtils.purifyUrl(page.getPageURI());
        String string = BundleUtils.getString(this.mApp.getStartParams(), "onlineHost");
        return purifyUrl.startsWith(string) ? purifyUrl.substring(string.length()) : purifyUrl;
    }
}
