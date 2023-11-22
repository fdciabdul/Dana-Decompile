package com.alibaba.ariver.app.ui.tabbar;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.alibaba.ariver.app.R;
import com.alibaba.ariver.app.api.App;
import com.alibaba.ariver.app.api.AppContext;
import com.alibaba.ariver.app.api.AppUIContext;
import com.alibaba.ariver.app.api.Page;
import com.alibaba.ariver.app.api.ui.ViewSpecProvider;
import com.alibaba.ariver.app.api.ui.fragment.IFragmentManager;
import com.alibaba.ariver.app.api.ui.tabbar.model.TabBarBadgeModel;
import com.alibaba.ariver.app.api.ui.tabbar.model.TabBarItemModel;
import com.alibaba.ariver.app.api.ui.tabbar.model.TabBarModel;
import com.alibaba.ariver.app.ui.BaseTabBar;
import com.alibaba.ariver.app.ui.tabbar.RVTabBarItem;
import com.alibaba.ariver.app.ui.tabbar.RVTabbarLayout;
import com.alibaba.ariver.engine.api.extensions.resources.model.ResourceLoadContext;
import com.alibaba.ariver.engine.api.resources.Resource;
import com.alibaba.ariver.engine.api.resources.ResourceLoadPoint;
import com.alibaba.ariver.kernel.RVEvents;
import com.alibaba.ariver.kernel.api.extension.ExtensionPoint;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.network.RVTransportService;
import com.alibaba.ariver.kernel.common.network.http.RVHttpRequest;
import com.alibaba.ariver.kernel.common.service.RVConfigService;
import com.alibaba.ariver.kernel.common.service.executor.ExecutorType;
import com.alibaba.ariver.kernel.common.utils.ExecutorUtils;
import com.alibaba.ariver.kernel.common.utils.FileUtils;
import com.alibaba.ariver.kernel.common.utils.ImageUtil;
import com.alibaba.ariver.kernel.common.utils.JSONUtils;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.ariver.resource.api.models.AppModel;
import com.alibaba.fastjson.JSONArray;
import io.opentelemetry.semconv.trace.attributes.SemanticAttributes;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes6.dex */
public class RVTabBarImpl extends BaseTabBar {

    /* renamed from: a  reason: collision with root package name */
    private final boolean f5984a;
    private long b;
    private Activity c;
    private RVTabbarLayout d;
    private LinearLayout e;
    public boolean enableTabClick;
    private View f;
    private boolean g;
    private Set<Integer> h;
    private RVTabbarLayout.Listener i;
    protected String mIconSize;

    /* loaded from: classes6.dex */
    public interface ImageListener {
        void onFailed(String str);

        void onLoad(Bitmap bitmap);
    }

    public RVTabBarImpl(App app, Activity activity, IFragmentManager iFragmentManager, ViewGroup viewGroup) {
        super(app, iFragmentManager);
        this.enableTabClick = true;
        this.b = 0L;
        this.h = new HashSet();
        this.i = new RVTabbarLayout.Listener() { // from class: com.alibaba.ariver.app.ui.tabbar.RVTabBarImpl.1
            @Override // com.alibaba.ariver.app.ui.tabbar.RVTabbarLayout.Listener
            public void onTabItemClicked(int i, View view) {
                if (RVTabBarImpl.this.enableTabClick) {
                    if (RVTabBarImpl.this.isFastClick() && RVTabBarImpl.this.getCurrentIndex() == i) {
                        return;
                    }
                    StringBuilder sb = new StringBuilder();
                    sb.append("tabClick index:");
                    sb.append(i);
                    RVLogger.d("AriverInt:SessionTabBar", sb.toString());
                    if (RVTabBarImpl.this.getApp().getActivePage() == null) {
                        return;
                    }
                    if ("yes".equalsIgnoreCase(((RVConfigService) RVProxy.get(RVConfigService.class)).getConfigWithProcessCache("ariver_tabBarBadgeClear", "no"))) {
                        RVTabBarImpl.this.clearBadge(i);
                    }
                    if (!RVTabBarImpl.this.enableInterceptTabClick()) {
                        RVTabBarImpl.this.setSelectedIndex(i);
                    }
                    RVTabBarImpl.this.switchTab(i, 2);
                }
            }
        };
        this.c = activity;
        LinearLayout linearLayout = new LinearLayout(activity);
        this.e = linearLayout;
        linearLayout.setOrientation(1);
        viewGroup.addView(this.e, new ViewGroup.LayoutParams(-1, getTabBarHeight(app, activity)));
        this.g = a(app.getAppId(), JSONUtils.getJSONArray(((RVConfigService) RVProxy.get(RVConfigService.class)).getConfigJSONObject("h5_eventThroughWorker"), RVEvents.TAB_CLICK, null));
        this.f5984a = ((RVConfigService) RVProxy.get(RVConfigService.class)).getConfigBoolean("ariver_useTabBarIconOpt", true);
    }

    public RVTabBarItem getRVTabBarItemByIndex(int i) {
        RVTabbarLayout rVTabbarLayout = this.d;
        if (rVTabbarLayout == null) {
            return null;
        }
        return rVTabbarLayout.getTabBarItemAt(i);
    }

    protected int getTabBarHeight(App app, Activity activity) {
        ViewSpecProvider viewSpecProvider;
        AppContext appContext = app.getAppContext();
        if (appContext != null && (viewSpecProvider = ((AppUIContext) appContext).getViewSpecProvider()) != null) {
            return View.MeasureSpec.getSize(viewSpecProvider.getTabBarHeightSpec());
        }
        return activity.getResources().getDimensionPixelSize(R.dimen.ariver_tabbar_height);
    }

    private boolean a(String str, JSONArray jSONArray) {
        if (jSONArray == null) {
            return false;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("isAppIdInWhiteList, appId = ");
        sb.append(str);
        sb.append(", appIdWhiteList = ");
        sb.append(jSONArray);
        RVLogger.d("AriverInt:SessionTabBar", sb.toString());
        for (int i = 0; i < jSONArray.size(); i++) {
            String string = jSONArray.getString(i);
            if (TextUtils.equals(string, ".*") || TextUtils.equals(string, str)) {
                return true;
            }
        }
        return false;
    }

    @Override // com.alibaba.ariver.app.ui.BaseTabBar
    public void onSwitchTab(int i, int i2) {
        super.onSwitchTab(i, i2);
        setSelectedIndex(i);
    }

    void setSelectedIndex(int i) {
        RVTabbarLayout rVTabbarLayout = this.d;
        if (rVTabbarLayout != null) {
            rVTabbarLayout.selectTab(i);
        } else {
            RVLogger.e("AriverInt:SessionTabBar", "setSelectedIndex but tabHost not null!!!");
        }
    }

    public void clearBadge(int i) {
        RVTabBarItem tabBarItemAt = this.d.getTabBarItemAt(i);
        TextView badgeAreaView = tabBarItemAt.getBadgeAreaView();
        if (badgeAreaView != null) {
            badgeAreaView.setVisibility(8);
        }
        RVTabDotView smallDotView = tabBarItemAt.getSmallDotView();
        if (smallDotView != null) {
            smallDotView.setVisibility(8);
        }
    }

    @Override // com.alibaba.ariver.app.ui.BaseTabBar
    public boolean enableInterceptTabClick() {
        return this.g;
    }

    public boolean isFastClick() {
        boolean z;
        synchronized (this) {
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - this.b > 500) {
                z = false;
                this.b = currentTimeMillis;
            } else {
                z = true;
            }
        }
        return z;
    }

    @Override // com.alibaba.ariver.app.ui.BaseTabBar, com.alibaba.ariver.app.api.ui.tabbar.TabBar
    public void init(TabBarModel tabBarModel) {
        super.init(tabBarModel);
        this.e.removeAllViews();
        this.d = new RVTabbarLayout(this.c);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, 1);
        View view = new View(this.c);
        this.f = view;
        view.setBackgroundColor(-5526610);
        this.e.addView(this.f, layoutParams);
        this.e.addView(this.d, new LinearLayout.LayoutParams(-1, -1));
        this.mIconSize = "default";
        long backgroundColor = tabBarModel.getBackgroundColor();
        if (backgroundColor <= 16777215) {
            backgroundColor |= -16777216;
        }
        this.d.setBackgroundColor((int) backgroundColor);
    }

    @Override // com.alibaba.ariver.app.ui.BaseTabBar, com.alibaba.ariver.app.api.ui.tabbar.TabBar
    public void create(Page page) {
        super.create(page);
        getApp().getStartParams().putInt("selectedIndex", getCurrentIndex());
        if (isAlphaBackground()) {
            onBackgroundAlphaStatusChanged(true);
        }
        this.d.selectTab(getCurrentIndex());
        this.d.setTabListener(new RVTabbarLayout.Listener() { // from class: com.alibaba.ariver.app.ui.tabbar.RVTabBarImpl.2
            @Override // com.alibaba.ariver.app.ui.tabbar.RVTabbarLayout.Listener
            public void onTabItemClicked(int i, View view) {
                RVTabBarImpl.this.i.onTabItemClicked(i, view);
            }
        });
    }

    public RVTabBarItem createTabBarItem() {
        return new RVTabBarItem(this.c);
    }

    @Override // com.alibaba.ariver.app.ui.BaseTabBar, com.alibaba.ariver.app.api.ui.tabbar.TabBar
    public void addTabItem(final int i, TabBarItemModel tabBarItemModel, boolean z) {
        super.addTabItem(i, tabBarItemModel, z);
        TabBarModel tabbarModel = getTabbarModel();
        if (tabBarItemModel != null) {
            String name = tabBarItemModel.getName();
            String tag = tabBarItemModel.getTag();
            final String icon = tabBarItemModel.getIcon();
            final String activeIcon = tabBarItemModel.getActiveIcon();
            final RVTabBarItem createTabBarItem = createTabBarItem();
            createTabBarItem.setTag(tag);
            final TextView iconAreaView = createTabBarItem.getIconAreaView();
            iconAreaView.setText(name);
            Integer textColor = tabBarItemModel.getTextColor() == null ? tabbarModel.getTextColor() : tabBarItemModel.getTextColor();
            if (textColor == null) {
                textColor = -16777216;
            }
            Integer selectedColor = tabBarItemModel.getSelectedColor() == null ? tabbarModel.getSelectedColor() : tabBarItemModel.getSelectedColor();
            if (selectedColor == null) {
                selectedColor = -16777216;
            }
            iconAreaView.setTextColor(TabBarUtils.generateTextColor(textColor.intValue(), selectedColor.intValue()));
            final StateListDrawable generateEmptyTopDrawable = TabBarUtils.generateEmptyTopDrawable();
            final int iconSize = getIconSize();
            generateEmptyTopDrawable.setBounds(0, 0, iconSize, iconSize);
            if (this.f5984a) {
                final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
                if (z) {
                    a(activeIcon, iconAreaView, generateEmptyTopDrawable, this.c, iconSize, true);
                    createTabBarItem.setOnSelectedChangedListener(new RVTabBarItem.OnSelectedChangedListener() { // from class: com.alibaba.ariver.app.ui.tabbar.RVTabBarImpl.3
                        @Override // com.alibaba.ariver.app.ui.tabbar.RVTabBarItem.OnSelectedChangedListener
                        public void onChanged(boolean z2) {
                            if (RVTabBarImpl.this.h.contains(Integer.valueOf(i))) {
                                createTabBarItem.setOnSelectedChangedListener(null);
                            } else if (z2 || atomicBoolean.getAndSet(true)) {
                            } else {
                                RVTabBarImpl rVTabBarImpl = RVTabBarImpl.this;
                                rVTabBarImpl.a(icon, iconAreaView, generateEmptyTopDrawable, rVTabBarImpl.c, iconSize, false);
                                createTabBarItem.setOnSelectedChangedListener(null);
                            }
                        }
                    });
                } else {
                    a(icon, iconAreaView, generateEmptyTopDrawable, this.c, iconSize, false);
                    createTabBarItem.setOnSelectedChangedListener(new RVTabBarItem.OnSelectedChangedListener() { // from class: com.alibaba.ariver.app.ui.tabbar.RVTabBarImpl.4
                        @Override // com.alibaba.ariver.app.ui.tabbar.RVTabBarItem.OnSelectedChangedListener
                        public void onChanged(boolean z2) {
                            if (RVTabBarImpl.this.h.contains(Integer.valueOf(i))) {
                                createTabBarItem.setOnSelectedChangedListener(null);
                            } else if (!z2 || atomicBoolean.getAndSet(true)) {
                            } else {
                                RVTabBarImpl rVTabBarImpl = RVTabBarImpl.this;
                                rVTabBarImpl.a(activeIcon, iconAreaView, generateEmptyTopDrawable, rVTabBarImpl.c, iconSize, true);
                                createTabBarItem.setOnSelectedChangedListener(null);
                            }
                        }
                    });
                }
            } else {
                a(activeIcon, iconAreaView, generateEmptyTopDrawable, this.c, iconSize, true);
                a(icon, iconAreaView, generateEmptyTopDrawable, this.c, iconSize, false);
            }
            this.d.addTab(i, createTabBarItem);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, final TextView textView, final StateListDrawable stateListDrawable, final Context context, final int i, final boolean z) {
        String str2;
        boolean z2;
        Bitmap decodeStream;
        StringBuilder sb = new StringBuilder();
        sb.append("loadImageAsync: ");
        sb.append(str);
        RVLogger.d("AriverInt:SessionTabBar", sb.toString());
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (ImageUtil.isBase64Url(str)) {
            Bitmap base64ToBitmap = ImageUtil.base64ToBitmap(str);
            if (base64ToBitmap == null) {
                return;
            }
            BitmapDrawable bitmapDrawable = new BitmapDrawable(context.getResources(), base64ToBitmap);
            bitmapDrawable.setBounds(0, 0, i, i);
            if (z) {
                TabBarUtils.addCheckedState(stateListDrawable, bitmapDrawable);
            } else {
                TabBarUtils.addNormalState(stateListDrawable, bitmapDrawable);
            }
            ExecutorUtils.runOnMain(new Runnable() { // from class: com.alibaba.ariver.app.ui.tabbar.RVTabBarImpl.5
                @Override // java.lang.Runnable
                public void run() {
                    textView.setCompoundDrawables(null, stateListDrawable, null, null);
                }
            });
            return;
        }
        AppModel appModel = (AppModel) getApp().getData(AppModel.class);
        if (appModel != null) {
            String vhost = appModel.getAppInfoModel().getVhost();
            if (str.startsWith(SemanticAttributes.FaasTriggerValues.HTTP)) {
                z2 = str.startsWith(vhost);
                str2 = str;
            } else {
                str2 = FileUtils.combinePath(vhost, str);
                z2 = true;
            }
        } else {
            str2 = str;
            z2 = false;
        }
        if (!z2) {
            loadOnlineImage(str2, new ImageListener() { // from class: com.alibaba.ariver.app.ui.tabbar.RVTabBarImpl.6
                @Override // com.alibaba.ariver.app.ui.tabbar.RVTabBarImpl.ImageListener
                public void onLoad(Bitmap bitmap) {
                    if (bitmap != null) {
                        BitmapDrawable bitmapDrawable2 = new BitmapDrawable(context.getResources(), bitmap);
                        int i2 = i;
                        bitmapDrawable2.setBounds(0, 0, i2, i2);
                        if (z) {
                            TabBarUtils.addCheckedState(stateListDrawable, bitmapDrawable2);
                        } else {
                            TabBarUtils.addNormalState(stateListDrawable, bitmapDrawable2);
                        }
                        ExecutorUtils.runOnMain(new Runnable() { // from class: com.alibaba.ariver.app.ui.tabbar.RVTabBarImpl.6.1
                            @Override // java.lang.Runnable
                            public void run() {
                                textView.setCompoundDrawables(null, stateListDrawable, null, null);
                            }
                        });
                    }
                }

                @Override // com.alibaba.ariver.app.ui.tabbar.RVTabBarImpl.ImageListener
                public void onFailed(String str3) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("load onlineImage onFailed!");
                    sb2.append(str3);
                    RVLogger.d("AriverInt:SessionTabBar", sb2.toString());
                }
            });
            return;
        }
        Resource load = ((ResourceLoadPoint) ExtensionPoint.as(ResourceLoadPoint.class).node(getApp()).create()).load(ResourceLoadContext.newBuilder().originUrl(str2).canUseFallback(true).build());
        if (load == null || (decodeStream = BitmapFactory.decodeStream(load.getStream())) == null) {
            return;
        }
        final BitmapDrawable bitmapDrawable2 = new BitmapDrawable(context.getResources(), decodeStream);
        bitmapDrawable2.setBounds(0, 0, i, i);
        ExecutorUtils.runOnMain(new Runnable() { // from class: com.alibaba.ariver.app.ui.tabbar.RVTabBarImpl.7
            @Override // java.lang.Runnable
            public void run() {
                if (z) {
                    TabBarUtils.addCheckedState(stateListDrawable, bitmapDrawable2);
                } else {
                    TabBarUtils.addNormalState(stateListDrawable, bitmapDrawable2);
                }
                textView.setCompoundDrawables(null, stateListDrawable, null, null);
            }
        });
    }

    protected void loadOnlineImage(final String str, final ImageListener imageListener) {
        ExecutorUtils.execute(ExecutorType.NETWORK, new Runnable() { // from class: com.alibaba.ariver.app.ui.tabbar.RVTabBarImpl.8
            @Override // java.lang.Runnable
            public void run() {
                try {
                    imageListener.onLoad(BitmapFactory.decodeStream(((RVTransportService) RVProxy.get(RVTransportService.class)).httpRequest(RVHttpRequest.newBuilder().url(str).build()).getResStream()));
                } catch (Throwable th) {
                    imageListener.onFailed(th.getMessage());
                }
            }
        });
    }

    protected int getIconSize() {
        if (!TextUtils.isEmpty(this.mIconSize) && this.mIconSize.equalsIgnoreCase("large")) {
            return this.c.getResources().getDimensionPixelSize(R.dimen.ariver_tabbar_tab_large_icon);
        }
        return this.c.getResources().getDimensionPixelSize(R.dimen.ariver_tabbar_tab_icon);
    }

    private int a() {
        RVTabbarLayout rVTabbarLayout = this.d;
        if (rVTabbarLayout != null) {
            return rVTabbarLayout.getTabSize();
        }
        return 0;
    }

    private void a(int i, TabBarModel tabBarModel, TabBarItemModel tabBarItemModel) {
        final String absoluteUrl;
        StringBuilder sb = new StringBuilder();
        sb.append("setTabBarItem ");
        sb.append(i);
        RVLogger.d("AriverInt:SessionTabBar", sb.toString());
        this.h.add(Integer.valueOf(i));
        Bundle startParams = getApp().getStartParams();
        String icon = tabBarItemModel.getIcon();
        String activeIcon = tabBarItemModel.getActiveIcon();
        if (this.d != null) {
            try {
                if (ImageUtil.base64ToBitmap(icon) == null) {
                    icon = TabBarUtils.getAbsoluteUrl(icon, startParams);
                }
            } catch (Throwable unused) {
                icon = TabBarUtils.getAbsoluteUrl(icon, startParams);
            }
            final String str = icon;
            try {
                if (ImageUtil.base64ToBitmap(activeIcon) == null) {
                    activeIcon = TabBarUtils.getAbsoluteUrl(activeIcon, startParams);
                }
                absoluteUrl = activeIcon;
            } catch (Throwable unused2) {
                absoluteUrl = TabBarUtils.getAbsoluteUrl(activeIcon, startParams);
            }
            StringBuilder sb2 = new StringBuilder();
            sb2.append("setTabBarItem iconURL is ");
            sb2.append(str);
            sb2.append(", activeIconURL is ");
            sb2.append(absoluteUrl);
            RVLogger.d("AriverInt:SessionTabBar", sb2.toString());
            final TextView iconAreaView = this.d.getTabBarItemAt(i).getIconAreaView();
            if (iconAreaView != null) {
                iconAreaView.setText(tabBarItemModel.getName());
            }
            Integer textColor = tabBarItemModel.getTextColor() == null ? tabBarModel.getTextColor() : tabBarItemModel.getTextColor();
            if (textColor == null) {
                textColor = -16777216;
            }
            Integer selectedColor = tabBarItemModel.getSelectedColor() == null ? tabBarModel.getSelectedColor() : tabBarItemModel.getSelectedColor();
            if (selectedColor == null) {
                selectedColor = -16777216;
            }
            if (iconAreaView != null) {
                iconAreaView.setTextColor(TabBarUtils.generateTextColor(textColor.intValue(), selectedColor.intValue()));
            }
            final StateListDrawable generateEmptyTopDrawable = TabBarUtils.generateEmptyTopDrawable();
            final int iconSize = getIconSize();
            generateEmptyTopDrawable.setBounds(0, 0, iconSize, iconSize);
            ExecutorUtils.execute(ExecutorType.IO, new Runnable() { // from class: com.alibaba.ariver.app.ui.tabbar.RVTabBarImpl.9
                @Override // java.lang.Runnable
                public void run() {
                    RVTabBarImpl rVTabBarImpl = RVTabBarImpl.this;
                    rVTabBarImpl.a(absoluteUrl, iconAreaView, generateEmptyTopDrawable, rVTabBarImpl.c, iconSize, true);
                    RVTabBarImpl rVTabBarImpl2 = RVTabBarImpl.this;
                    rVTabBarImpl2.a(str, iconAreaView, generateEmptyTopDrawable, rVTabBarImpl2.c, iconSize, false);
                }
            });
        }
    }

    @Override // com.alibaba.ariver.app.ui.BaseTabBar
    public void onThemeChanged(boolean z) {
        super.onThemeChanged(z);
        int a2 = a();
        for (int i = 0; i < a2; i++) {
            a(i, getTabbarModel(), getTabbarModel().getItems().get(i));
        }
    }

    @Override // com.alibaba.ariver.app.ui.BaseTabBar, com.alibaba.ariver.app.api.ui.tabbar.TabBar
    public void removeTabItem(int i) {
        super.removeTabItem(i);
        RVTabbarLayout rVTabbarLayout = this.d;
        if (rVTabbarLayout != null) {
            rVTabbarLayout.removeTab(i);
        }
    }

    @Override // com.alibaba.ariver.app.ui.BaseTabBar, com.alibaba.ariver.app.api.ui.tabbar.TabBar
    public void setTabItem(int i, TabBarItemModel tabBarItemModel) {
        super.setTabItem(i, tabBarItemModel);
        if (this.d != null) {
            a(i, getTabbarModel(), tabBarItemModel);
        }
    }

    @Override // com.alibaba.ariver.app.ui.BaseTabBar, com.alibaba.ariver.app.api.ui.tabbar.TabBar
    public void reset() {
        super.reset();
        RVTabbarLayout rVTabbarLayout = this.d;
        if (rVTabbarLayout != null) {
            rVTabbarLayout.removeAllViews();
        } else {
            RVLogger.w("AriverInt:SessionTabBar", "reset but not init!");
        }
    }

    @Override // com.alibaba.ariver.app.ui.BaseTabBar, com.alibaba.ariver.app.api.ui.tabbar.TabBar
    public void show(Page page, Animation animation) {
        if (!getTabbarModel().isDisplay()) {
            setAutoShow(false);
            getTabbarModel().setDisplay(true);
            this.e.setVisibility(8);
            RVLogger.d("AriverInt:SessionTabBar", "tabBar json display false");
            return;
        }
        super.show(page, animation);
        LinearLayout linearLayout = this.e;
        if (linearLayout != null) {
            if (animation != null) {
                linearLayout.clearAnimation();
                this.e.startAnimation(animation);
            }
            this.e.setVisibility(0);
        }
    }

    @Override // com.alibaba.ariver.app.ui.BaseTabBar, com.alibaba.ariver.app.api.ui.tabbar.TabBar
    public void hide(Animation animation) {
        super.hide(animation);
        LinearLayout linearLayout = this.e;
        if (linearLayout != null) {
            if (animation != null) {
                linearLayout.clearAnimation();
                this.e.startAnimation(animation);
                animation.setAnimationListener(new Animation.AnimationListener() { // from class: com.alibaba.ariver.app.ui.tabbar.RVTabBarImpl.10
                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationRepeat(Animation animation2) {
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationStart(Animation animation2) {
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationEnd(Animation animation2) {
                        RVTabBarImpl.this.e.setVisibility(8);
                    }
                });
                return;
            }
            linearLayout.setVisibility(8);
        }
    }

    @Override // com.alibaba.ariver.app.ui.BaseTabBar, com.alibaba.ariver.app.api.ui.tabbar.TabBar
    public void changeTabBarStyle(TabBarModel tabBarModel, Integer num) {
        boolean isAlphaBackground = isAlphaBackground();
        super.changeTabBarStyle(tabBarModel, num);
        if (this.d != null) {
            long backgroundColor = tabBarModel.getBackgroundColor();
            if (backgroundColor <= 16777215) {
                backgroundColor |= -16777216;
            }
            this.d.setBackgroundColor((int) backgroundColor);
            if (tabBarModel.getTextColor() != null) {
                tabBarModel.setTextColor(getTabbarModel().getTextColor().intValue());
            }
            if (tabBarModel.getSelectedColor() != null) {
                tabBarModel.setSelectedColor(getTabbarModel().getSelectedColor().intValue());
            }
            if (num != null) {
                this.f.setBackgroundColor(num.intValue());
            }
            if (isAlphaBackground() != isAlphaBackground) {
                onBackgroundAlphaStatusChanged(isAlphaBackground());
            }
            int childCount = this.d.getChildCount();
            Integer textColor = tabBarModel.getTextColor();
            Integer selectedColor = tabBarModel.getSelectedColor();
            if (textColor == null || selectedColor == null) {
                RVLogger.d("AriverInt:SessionTabBar", "changeTabBarStyle textColor or selectedColor null.");
                return;
            }
            for (int i = 0; i < childCount; i++) {
                TextView iconAreaView = this.d.getTabBarItemAt(i).getIconAreaView();
                if (iconAreaView != null) {
                    iconAreaView.setTextColor(TabBarUtils.generateTextColor(textColor.intValue(), selectedColor.intValue()));
                }
            }
        }
    }

    protected void onBackgroundAlphaStatusChanged(boolean z) {
        StringBuilder sb = new StringBuilder();
        sb.append("onBackgroundAlphaStatusChanged alpha? ");
        sb.append(z);
        RVLogger.d("AriverInt:SessionTabBar", sb.toString());
    }

    @Override // com.alibaba.ariver.app.api.ui.tabbar.TabBar
    public void setTabBarBadge(int i, TabBarBadgeModel tabBarBadgeModel) {
        StringBuilder sb = new StringBuilder();
        sb.append("setTabBadge ");
        sb.append(i);
        RVLogger.d("AriverInt:SessionTabBar", sb.toString());
        String badgeText = tabBarBadgeModel.getBadgeText();
        int badgeSize = tabBarBadgeModel.getBadgeSize();
        int badgeColor = tabBarBadgeModel.getBadgeColor();
        if (TextUtils.isEmpty(badgeText)) {
            badgeText = "0";
        }
        if (this.d != null) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("setTabBadge value is ");
            sb2.append(badgeText);
            RVLogger.d("AriverInt:SessionTabBar", sb2.toString());
            RVTabBarItem tabBarItemAt = this.d.getTabBarItemAt(i);
            TextView badgeAreaView = tabBarItemAt.getBadgeAreaView();
            RVTabDotView smallDotView = tabBarItemAt.getSmallDotView();
            if (!TextUtils.isEmpty(badgeText)) {
                String trim = badgeText.trim();
                if (!TextUtils.equals("-1", trim)) {
                    if (TextUtils.equals("0", trim)) {
                        badgeAreaView.setVisibility(8);
                        smallDotView.setDotColor(badgeColor);
                        smallDotView.setDotWidth(badgeSize);
                        smallDotView.setVisibility(0);
                        return;
                    }
                    badgeAreaView.setText(formatStr(trim, 6));
                    badgeAreaView.setVisibility(0);
                    smallDotView.setVisibility(8);
                    return;
                }
            }
            badgeAreaView.setVisibility(8);
            smallDotView.setVisibility(8);
        }
    }

    @Override // com.alibaba.ariver.app.api.ui.tabbar.TabBar
    public void removeTabBarBadge(int i) {
        StringBuilder sb = new StringBuilder();
        sb.append("removeTabBadge ");
        sb.append(i);
        RVLogger.d("AriverInt:SessionTabBar", sb.toString());
        RVTabbarLayout rVTabbarLayout = this.d;
        if (rVTabbarLayout != null) {
            RVTabBarItem tabBarItemAt = rVTabbarLayout.getTabBarItemAt(i);
            TextView badgeAreaView = tabBarItemAt.getBadgeAreaView();
            if (badgeAreaView != null) {
                badgeAreaView.setVisibility(8);
            }
            RVTabDotView smallDotView = tabBarItemAt.getSmallDotView();
            if (smallDotView != null) {
                smallDotView.setVisibility(8);
            }
        }
    }

    public static String formatStr(String str, int i) {
        StringBuilder sb = new StringBuilder();
        int i2 = 0;
        int i3 = 0;
        while (i2 < str.length()) {
            int i4 = i2 + 1;
            String substring = str.substring(i2, i4);
            i3 = substring.matches("[Α-￥]") ? i3 + 2 : i3 + 1;
            if (i3 <= i) {
                sb.append(substring);
                i2 = i4;
            } else {
                sb.setLength(sb.length() - 1);
                StringBuilder sb2 = new StringBuilder();
                sb2.append(sb.toString());
                sb2.append("...");
                return sb2.toString();
            }
        }
        return sb.toString();
    }
}
