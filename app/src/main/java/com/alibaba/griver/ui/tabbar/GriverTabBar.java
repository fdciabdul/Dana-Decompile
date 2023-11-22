package com.alibaba.griver.ui.tabbar;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.widget.RelativeLayout;
import com.alibaba.ariver.app.api.App;
import com.alibaba.ariver.app.api.Page;
import com.alibaba.ariver.app.api.ui.fragment.IFragmentManager;
import com.alibaba.ariver.app.api.ui.tabbar.model.TabBarBadgeModel;
import com.alibaba.ariver.app.api.ui.tabbar.model.TabBarItemModel;
import com.alibaba.ariver.app.api.ui.tabbar.model.TabBarModel;
import com.alibaba.ariver.app.ui.BaseTabBar;
import com.alibaba.ariver.kernel.common.service.executor.ExecutorType;
import com.alibaba.ariver.kernel.common.utils.BundleUtils;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.griver.api.ui.tabbar.GVTabBar;
import com.alibaba.griver.base.common.executor.GriverExecutors;
import com.alibaba.griver.ui.R;
import com.alibaba.griver.ui.tabbar.TabBarLayout;

/* loaded from: classes6.dex */
public class GriverTabBar extends BaseTabBar implements GVTabBar {

    /* renamed from: a  reason: collision with root package name */
    private long f6759a;
    private Activity b;
    private TabBarLayoutWrapper c;
    private TabBarLayout.H5TabListener d;
    public boolean enableTabClick;

    public void setHasShowTab(boolean z) {
    }

    public GriverTabBar(App app, Activity activity, IFragmentManager iFragmentManager, ViewGroup viewGroup) {
        super(app, iFragmentManager);
        this.enableTabClick = true;
        this.f6759a = 0L;
        this.d = new TabBarLayout.H5TabListener() { // from class: com.alibaba.griver.ui.tabbar.GriverTabBar.1
            @Override // com.alibaba.griver.ui.tabbar.TabBarLayout.H5TabListener
            public void onTabItemClicked(int i, View view) {
                if (GriverTabBar.this.enableTabClick && !GriverTabBar.this.isFastClick()) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("tabClick index:");
                    sb.append(i);
                    RVLogger.d("AriverInt:GriverTabBar", sb.toString());
                    if (GriverTabBar.this.getApp().getActivePage() == null) {
                        return;
                    }
                    GriverTabBar.this.c.clearBadge(i);
                    GriverTabBar.this.c.setSelectedIndex(i);
                    GriverTabBar.this.switchTab(i, 2);
                }
            }
        };
        this.b = activity;
        this.c = new TabBarLayoutWrapper(app, activity, viewGroup);
    }

    @Override // com.alibaba.ariver.app.ui.BaseTabBar
    public void onSwitchTab(int i, int i2) {
        super.onSwitchTab(i, i2);
        this.c.setSelectedIndex(i);
    }

    @Override // com.alibaba.ariver.app.ui.BaseTabBar
    public boolean enableInterceptTabClick() {
        Page activePage = getApp().getActivePage();
        if (activePage != null) {
            return BundleUtils.getBoolean(activePage.getStartParams(), "tabClick_h5EventThroughWorker", false);
        }
        return false;
    }

    @Override // com.alibaba.ariver.app.ui.BaseTabBar, com.alibaba.ariver.app.api.ui.tabbar.TabBar
    public void showDefaultTab(int i) {
        super.showDefaultTab(i);
        if (i >= 2) {
            TabBarLayoutWrapper tabBarLayoutWrapper = this.c;
            if (tabBarLayoutWrapper != null) {
                tabBarLayoutWrapper.createDefaultTabBar(i);
                this.c.getContent().setVisibility(0);
                return;
            }
            return;
        }
        RVLogger.w("AriverInt:GriverTabBar", "createDefaultSessionTab num < 2");
    }

    public boolean isFastClick() {
        boolean z;
        synchronized (this) {
            long currentTimeMillis = System.currentTimeMillis();
            z = currentTimeMillis - this.f6759a <= 500;
            this.f6759a = currentTimeMillis;
        }
        return z;
    }

    @Override // com.alibaba.ariver.app.ui.BaseTabBar, com.alibaba.ariver.app.api.ui.tabbar.TabBar
    public void init(TabBarModel tabBarModel) {
        super.init(tabBarModel);
        this.c.init(tabBarModel);
    }

    @Override // com.alibaba.ariver.app.ui.BaseTabBar, com.alibaba.ariver.app.api.ui.tabbar.TabBar
    public void create(Page page) {
        super.create(page);
        getApp().getStartParams().putInt("selectedIndex", getCurrentIndex());
        if (isAlphaBackground()) {
            View findViewById = this.b.findViewById(R.id.fragment_container);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) findViewById.getLayoutParams();
            layoutParams.addRule(2, 0);
            findViewById.setLayoutParams(layoutParams);
        }
        this.c.onInflateTab(getCurrentIndex(), this.d);
    }

    @Override // com.alibaba.ariver.app.ui.BaseTabBar, com.alibaba.ariver.app.api.ui.tabbar.TabBar
    public void addTabItem(int i, TabBarItemModel tabBarItemModel, boolean z) {
        super.addTabItem(i, tabBarItemModel, z);
        this.c.addTabItem(i, getTabbarModel(), tabBarItemModel);
    }

    @Override // com.alibaba.ariver.app.ui.BaseTabBar, com.alibaba.ariver.app.api.ui.tabbar.TabBar
    public void setTabItem(int i, TabBarItemModel tabBarItemModel) {
        super.setTabItem(i, tabBarItemModel);
        TabBarLayoutWrapper tabBarLayoutWrapper = this.c;
        if (tabBarLayoutWrapper != null) {
            tabBarLayoutWrapper.setTabBarItem(i, getTabbarModel(), tabBarItemModel);
        }
    }

    @Override // com.alibaba.ariver.app.ui.BaseTabBar, com.alibaba.ariver.app.api.ui.tabbar.TabBar
    public void reset() {
        super.reset();
        this.c.reset();
    }

    @Override // com.alibaba.ariver.app.ui.BaseTabBar, com.alibaba.ariver.app.api.ui.tabbar.TabBar
    public void show(Page page, Animation animation) {
        super.show(page, animation);
        TabBarLayoutWrapper tabBarLayoutWrapper = this.c;
        if (tabBarLayoutWrapper != null) {
            if (animation != null) {
                tabBarLayoutWrapper.getContent().clearAnimation();
                this.c.getContent().startAnimation(animation);
            }
            this.c.getContent().setVisibility(0);
        }
    }

    @Override // com.alibaba.ariver.app.ui.BaseTabBar, com.alibaba.ariver.app.api.ui.tabbar.TabBar
    public void hide(Animation animation) {
        super.hide(animation);
        TabBarLayoutWrapper tabBarLayoutWrapper = this.c;
        if (tabBarLayoutWrapper != null) {
            if (animation != null) {
                tabBarLayoutWrapper.getContent().clearAnimation();
                this.c.getContent().startAnimation(animation);
                animation.setAnimationListener(new Animation.AnimationListener() { // from class: com.alibaba.griver.ui.tabbar.GriverTabBar.2
                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationRepeat(Animation animation2) {
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationStart(Animation animation2) {
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationEnd(Animation animation2) {
                        GriverExecutors.getExecutor(ExecutorType.UI).execute(new Runnable() { // from class: com.alibaba.griver.ui.tabbar.GriverTabBar.2.1
                            @Override // java.lang.Runnable
                            public void run() {
                                if (GriverTabBar.this.c != null) {
                                    GriverTabBar.this.c.getContent().setVisibility(8);
                                }
                            }
                        });
                    }
                });
                return;
            }
            tabBarLayoutWrapper.getContent().setVisibility(8);
        }
    }

    @Override // com.alibaba.ariver.app.ui.BaseTabBar, com.alibaba.ariver.app.api.ui.tabbar.TabBar
    public void changeTabBarStyle(TabBarModel tabBarModel, Integer num) {
        super.changeTabBarStyle(tabBarModel, num);
        if (this.c != null) {
            if (tabBarModel.getTextColor() == null) {
                tabBarModel.setTextColor(getTabbarModel().getTextColor().intValue());
            }
            if (tabBarModel.getSelectedColor() == null) {
                tabBarModel.setSelectedColor(getTabbarModel().getSelectedColor().intValue());
            }
            this.c.changeTabBarStyle(tabBarModel, num);
        }
    }

    @Override // com.alibaba.ariver.app.api.ui.tabbar.TabBar
    public void setTabBarBadge(int i, TabBarBadgeModel tabBarBadgeModel) {
        TabBarLayoutWrapper tabBarLayoutWrapper = this.c;
        if (tabBarLayoutWrapper != null) {
            tabBarLayoutWrapper.setTabBadge(i, tabBarBadgeModel.getBadgeText(), tabBarBadgeModel.getBadgeSize(), tabBarBadgeModel.getBadgeColor());
        }
    }

    @Override // com.alibaba.ariver.app.api.ui.tabbar.TabBar
    public void removeTabBarBadge(int i) {
        TabBarLayoutWrapper tabBarLayoutWrapper = this.c;
        if (tabBarLayoutWrapper != null) {
            tabBarLayoutWrapper.removeTabBadge(i);
        }
    }
}
