package com.alibaba.griver.ui.tabbar;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.alibaba.ariver.app.api.App;
import com.alibaba.ariver.app.api.ui.tabbar.model.TabBarItemModel;
import com.alibaba.ariver.app.api.ui.tabbar.model.TabBarModel;
import com.alibaba.ariver.engine.api.extensions.resources.model.ResourceLoadContext;
import com.alibaba.ariver.engine.api.resources.Resource;
import com.alibaba.ariver.engine.api.resources.ResourceLoadPoint;
import com.alibaba.ariver.kernel.api.extension.ExtensionPoint;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.service.RVEnvironmentService;
import com.alibaba.ariver.kernel.common.service.executor.ExecutorType;
import com.alibaba.ariver.kernel.common.utils.ExecutorUtils;
import com.alibaba.ariver.kernel.common.utils.FileUtils;
import com.alibaba.ariver.kernel.common.utils.ImageUtil;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.ariver.resource.api.models.AppModel;
import com.alibaba.griver.base.common.adapter.ImageListener;
import com.alibaba.griver.base.common.utils.DensityUtil;
import com.alibaba.griver.base.common.utils.ImageUtils;
import com.alibaba.griver.ui.R;
import com.alibaba.griver.ui.tabbar.TabBarLayout;
import com.alibaba.griver.ui.utils.NebulaTabbarUtils;
import com.fullstory.instrumentation.InstrumentInjector;
import io.opentelemetry.semconv.trace.attributes.SemanticAttributes;

/* loaded from: classes6.dex */
public class TabBarLayoutWrapper {
    public static final String TAG = "TabBarLayoutWrapper";

    /* renamed from: a  reason: collision with root package name */
    private TabBarLayout f6762a;
    private LinearLayout b;
    private String c;
    private App d;
    private View e;
    private Activity f;

    public TabBarLayoutWrapper(App app, Activity activity, ViewGroup viewGroup) {
        this.d = app;
        this.f = activity;
        LinearLayout linearLayout = new LinearLayout(activity);
        this.b = linearLayout;
        linearLayout.setId(R.id.griver_tabrootview);
        this.b.setOrientation(1);
        viewGroup.addView(this.b, new ViewGroup.LayoutParams(-1, activity.getResources().getDimensionPixelSize(R.dimen.griver_tabbar_height)));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setSelectedIndex(int i) {
        TabBarLayout tabBarLayout = this.f6762a;
        if (tabBarLayout != null) {
            tabBarLayout.selectTab(i);
        } else {
            RVLogger.e(TAG, "setSelectedIndex but tabHost not null!!!");
        }
    }

    void clearAllTabs() {
        this.f6762a.removeAllViews();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void init(TabBarModel tabBarModel) {
        this.b.removeAllViews();
        TabBarLayout tabBarLayout = new TabBarLayout(this.f);
        this.f6762a = tabBarLayout;
        tabBarLayout.setId(R.id.griver_tabhost);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, 1);
        View view = new View(this.f);
        this.e = view;
        view.setBackgroundColor(-5526610);
        this.b.addView(this.e, layoutParams);
        this.b.addView(this.f6762a, new LinearLayout.LayoutParams(-1, -1));
        this.c = "default";
        long backgroundColor = tabBarModel.getBackgroundColor();
        if (backgroundColor <= 16777215) {
            backgroundColor |= -16777216;
        }
        this.f6762a.setBackgroundColor((int) backgroundColor);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void changeTabBarStyle(TabBarModel tabBarModel, Integer num) {
        if (num != null) {
            this.e.setBackgroundColor(num.intValue());
        }
        if (tabBarModel != null) {
            this.f6762a.setBackgroundColor((int) tabBarModel.getBackgroundColor());
            int childCount = this.f6762a.getChildCount();
            for (int i = 0; i < childCount; i++) {
                ((TextView) this.f6762a.getChildAt(i).findViewById(R.id.h5_tabbaritem_txticon)).setTextColor(NebulaTabbarUtils.generateTextColor(tabBarModel.getTextColor().intValue(), tabBarModel.getSelectedColor().intValue()));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void onInflateTab(int i, final TabBarLayout.H5TabListener h5TabListener) {
        this.f6762a.selectTab(i);
        this.f6762a.setTabListener(new TabBarLayout.H5TabListener() { // from class: com.alibaba.griver.ui.tabbar.TabBarLayoutWrapper.1
            @Override // com.alibaba.griver.ui.tabbar.TabBarLayout.H5TabListener
            public void onTabItemClicked(int i2, View view) {
                h5TabListener.onTabItemClicked(i2, view);
            }
        });
    }

    public ViewGroup getContent() {
        return this.b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void createDefaultTabBar(int i) {
        LinearLayout linearLayout = new LinearLayout(this.f);
        linearLayout.setOrientation(1);
        TabBarLayout tabBarLayout = new TabBarLayout(this.f);
        for (int i2 = 0; i2 < i && i2 < 5; i2++) {
            TabBarItem tabBarItem = new TabBarItem(this.f);
            TextView textView = (TextView) tabBarItem.getIconAreaView();
            textView.setText("");
            Drawable Resources_getDrawable = InstrumentInjector.Resources_getDrawable(((RVEnvironmentService) RVProxy.get(RVEnvironmentService.class)).getResources(null), R.drawable.griver_ui_sessiontab_defaultitem);
            int iconSize = getIconSize();
            Resources_getDrawable.setBounds(0, 0, iconSize, iconSize);
            textView.setCompoundDrawables(null, Resources_getDrawable, null, null);
            tabBarLayout.addTab(tabBarItem.getRootView());
        }
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, 1);
        View view = new View(this.f);
        view.setBackgroundColor(-5526610);
        linearLayout.addView(view, layoutParams);
        tabBarLayout.setBackgroundColor(-460551);
        linearLayout.addView(tabBarLayout, new LinearLayout.LayoutParams(-1, -1));
        this.b.addView(linearLayout, new RelativeLayout.LayoutParams(-1, -1));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void addTabItem(int i, TabBarModel tabBarModel, TabBarItemModel tabBarItemModel) {
        if (tabBarItemModel != null) {
            String name = tabBarItemModel.getName();
            String tag = tabBarItemModel.getTag();
            String icon = tabBarItemModel.getIcon();
            String activeIcon = tabBarItemModel.getActiveIcon();
            TabBarItem tabBarItem = new TabBarItem(this.f);
            tabBarItem.setTag(tag);
            TextView textView = (TextView) tabBarItem.getIconAreaView();
            textView.setText(name);
            Integer textColor = tabBarItemModel.getTextColor() == null ? tabBarModel.getTextColor() : tabBarItemModel.getTextColor();
            if (textColor == null) {
                textColor = -16777216;
            }
            Integer selectedColor = tabBarItemModel.getSelectedColor() == null ? tabBarModel.getSelectedColor() : tabBarItemModel.getSelectedColor();
            if (selectedColor == null) {
                selectedColor = -16777216;
            }
            textView.setTextColor(NebulaTabbarUtils.generateTextColor(textColor.intValue(), selectedColor.intValue()));
            StateListDrawable generateEmptyTopDrawable = NebulaTabbarUtils.generateEmptyTopDrawable();
            int iconSize = getIconSize();
            generateEmptyTopDrawable.setBounds(0, 0, iconSize, iconSize);
            a(activeIcon, textView, generateEmptyTopDrawable, this.f, iconSize, true);
            a(icon, textView, generateEmptyTopDrawable, this.f, iconSize, false);
            this.f6762a.addTab(i, tabBarItem.getRootView());
        }
    }

    public void reset() {
        TabBarLayout tabBarLayout = this.f6762a;
        if (tabBarLayout != null) {
            tabBarLayout.removeAllViews();
        } else {
            RVLogger.w(TAG, "reset but mTabHost == null!!");
        }
    }

    public void clearBadge(int i) {
        View childAt = this.f6762a.getChildAt(i);
        TextView textView = (TextView) childAt.findViewById(R.id.h5_tabbaritem_badge);
        if (textView != null) {
            textView.setVisibility(8);
        }
        DotView dotView = (DotView) childAt.findViewById(R.id.h5_tabbaritem_dotView);
        if (dotView != null) {
            dotView.setVisibility(8);
        }
    }

    public void setTabBadge(int i, String str, int i2, int i3) {
        RVLogger.d(TAG, "setTabBadge ");
        if (TextUtils.isEmpty(str)) {
            str = "0";
        }
        if (this.f6762a != null) {
            StringBuilder sb = new StringBuilder();
            sb.append("setTabBadge value is ");
            sb.append(str);
            RVLogger.d(TAG, sb.toString());
            View childAt = this.f6762a.getChildAt(i);
            final TextView textView = (TextView) childAt.findViewById(R.id.h5_tabbaritem_badge);
            DotView dotView = (DotView) childAt.findViewById(R.id.h5_tabbaritem_dotView);
            if (!TextUtils.isEmpty(str)) {
                String trim = str.trim();
                if (!TextUtils.equals("-1", trim)) {
                    if (TextUtils.equals("0", trim)) {
                        textView.setVisibility(8);
                        dotView.setDotColor(i3);
                        dotView.setDotWidth(i2);
                        dotView.setVisibility(0);
                        return;
                    }
                    if (trim.length() > 3) {
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append(trim.substring(0, 2));
                        sb2.append("...");
                        trim = sb2.toString();
                    }
                    textView.setText(trim);
                    textView.setVisibility(0);
                    dotView.setVisibility(8);
                    textView.post(new Runnable() { // from class: com.alibaba.griver.ui.tabbar.TabBarLayoutWrapper.2
                        @Override // java.lang.Runnable
                        public void run() {
                            int measuredWidth = textView.getMeasuredWidth();
                            if (measuredWidth < DensityUtil.dip2px(TabBarLayoutWrapper.this.f, 20.0f)) {
                                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) textView.getLayoutParams();
                                layoutParams.height = measuredWidth;
                                textView.setLayoutParams(layoutParams);
                            }
                        }
                    });
                    return;
                }
            }
            textView.setVisibility(8);
            dotView.setVisibility(8);
        }
    }

    public void removeTabBadge(int i) {
        RVLogger.d(TAG, "removeTabBadge ");
        TabBarLayout tabBarLayout = this.f6762a;
        if (tabBarLayout != null) {
            View childAt = tabBarLayout.getChildAt(i);
            TextView textView = (TextView) childAt.findViewById(R.id.h5_tabbaritem_badge);
            DotView dotView = (DotView) childAt.findViewById(R.id.h5_tabbaritem_dotView);
            textView.setVisibility(8);
            dotView.setVisibility(8);
        }
    }

    public void setTabBarItem(int i, TabBarModel tabBarModel, TabBarItemModel tabBarItemModel) {
        String absoluteUrl;
        RVLogger.d(TAG, "setTabBarItem ");
        Bundle startParams = this.d.getStartParams();
        String icon = tabBarItemModel.getIcon();
        String activeIcon = tabBarItemModel.getActiveIcon();
        if (this.f6762a != null) {
            try {
                if (ImageUtil.base64ToBitmap(icon) == null) {
                    icon = NebulaTabbarUtils.getAbsoluteUrl(icon, startParams);
                }
            } catch (Throwable unused) {
                icon = NebulaTabbarUtils.getAbsoluteUrl(icon, startParams);
            }
            String str = icon;
            try {
                if (ImageUtil.base64ToBitmap(activeIcon) == null) {
                    activeIcon = NebulaTabbarUtils.getAbsoluteUrl(activeIcon, startParams);
                }
                absoluteUrl = activeIcon;
            } catch (Throwable unused2) {
                absoluteUrl = NebulaTabbarUtils.getAbsoluteUrl(activeIcon, startParams);
            }
            StringBuilder sb = new StringBuilder();
            sb.append("setTabBarItem iconURL is ");
            sb.append(str);
            sb.append(", activeIconURL is ");
            sb.append(absoluteUrl);
            RVLogger.d(TAG, sb.toString());
            TextView textView = (TextView) this.f6762a.getChildAt(i).findViewById(R.id.h5_tabbaritem_txticon);
            textView.setText(tabBarItemModel.getName());
            Integer textColor = tabBarItemModel.getTextColor() == null ? tabBarModel.getTextColor() : tabBarItemModel.getTextColor();
            if (textColor == null) {
                textColor = -16777216;
            }
            Integer selectedColor = tabBarItemModel.getSelectedColor() == null ? tabBarModel.getSelectedColor() : tabBarItemModel.getSelectedColor();
            if (selectedColor == null) {
                selectedColor = -16777216;
            }
            textView.setTextColor(NebulaTabbarUtils.generateTextColor(textColor.intValue(), selectedColor.intValue()));
            StateListDrawable generateEmptyTopDrawable = NebulaTabbarUtils.generateEmptyTopDrawable();
            int iconSize = getIconSize();
            generateEmptyTopDrawable.setBounds(0, 0, iconSize, iconSize);
            a(absoluteUrl, textView, generateEmptyTopDrawable, this.f, iconSize, true);
            a(str, textView, generateEmptyTopDrawable, this.f, iconSize, false);
        }
    }

    private void a(String str, final TextView textView, final StateListDrawable stateListDrawable, final Context context, final int i, final boolean z) {
        String str2 = str;
        StringBuilder sb = new StringBuilder();
        sb.append("loadImageAsync: ");
        sb.append(str);
        RVLogger.d(TAG, sb.toString());
        if (TextUtils.isEmpty(str)) {
            return;
        }
        boolean z2 = false;
        if (ImageUtil.isBase64Url(str)) {
            Bitmap base64ToBitmap = ImageUtil.base64ToBitmap(str);
            if (base64ToBitmap == null) {
                return;
            }
            BitmapDrawable bitmapDrawable = new BitmapDrawable(context.getResources(), base64ToBitmap);
            bitmapDrawable.setBounds(0, 0, i, i);
            if (z) {
                NebulaTabbarUtils.addCheckedState(stateListDrawable, bitmapDrawable);
            } else {
                NebulaTabbarUtils.addNormalState(stateListDrawable, bitmapDrawable);
            }
            textView.setCompoundDrawables(null, stateListDrawable, null, null);
            return;
        }
        AppModel appModel = (AppModel) this.d.getData(AppModel.class);
        if (appModel != null) {
            String vhost = appModel.getAppInfoModel().getVhost();
            if (str.startsWith(SemanticAttributes.FaasTriggerValues.HTTP)) {
                z2 = str.startsWith(vhost);
            } else {
                str2 = FileUtils.combinePath(vhost, str);
                z2 = true;
            }
        }
        final String str3 = str2;
        if (!z2) {
            ImageUtils.loadImage(str3, new ImageListener() { // from class: com.alibaba.griver.ui.tabbar.TabBarLayoutWrapper.3
                @Override // com.alibaba.griver.base.common.adapter.ImageListener
                public void onImage(Bitmap bitmap) {
                    if (bitmap != null) {
                        BitmapDrawable bitmapDrawable2 = new BitmapDrawable(context.getResources(), bitmap);
                        int i2 = i;
                        bitmapDrawable2.setBounds(0, 0, i2, i2);
                        if (z) {
                            NebulaTabbarUtils.addCheckedState(stateListDrawable, bitmapDrawable2);
                        } else {
                            NebulaTabbarUtils.addNormalState(stateListDrawable, bitmapDrawable2);
                        }
                        ExecutorUtils.runOnMain(new Runnable() { // from class: com.alibaba.griver.ui.tabbar.TabBarLayoutWrapper.3.1
                            @Override // java.lang.Runnable
                            public void run() {
                                textView.setCompoundDrawables(null, stateListDrawable, null, null);
                            }
                        });
                    }
                }
            });
        } else {
            ExecutorUtils.execute(ExecutorType.IO, new Runnable() { // from class: com.alibaba.griver.ui.tabbar.TabBarLayoutWrapper.4
                @Override // java.lang.Runnable
                public void run() {
                    Bitmap decodeStream;
                    Resource load = ((ResourceLoadPoint) ExtensionPoint.as(ResourceLoadPoint.class).node(TabBarLayoutWrapper.this.d).create()).load(ResourceLoadContext.newBuilder().originUrl(str3).canUseFallback(true).build());
                    if (load == null || (decodeStream = BitmapFactory.decodeStream(load.getStream())) == null) {
                        return;
                    }
                    final BitmapDrawable bitmapDrawable2 = new BitmapDrawable(context.getResources(), decodeStream);
                    int i2 = i;
                    bitmapDrawable2.setBounds(0, 0, i2, i2);
                    ExecutorUtils.runOnMain(new Runnable() { // from class: com.alibaba.griver.ui.tabbar.TabBarLayoutWrapper.4.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (z) {
                                NebulaTabbarUtils.addCheckedState(stateListDrawable, bitmapDrawable2);
                            } else {
                                NebulaTabbarUtils.addNormalState(stateListDrawable, bitmapDrawable2);
                            }
                            textView.setCompoundDrawables(null, stateListDrawable, null, null);
                        }
                    });
                }
            });
        }
    }

    protected int getIconSize() {
        if (!TextUtils.isEmpty(this.c) && this.c.equalsIgnoreCase("large")) {
            return ((RVEnvironmentService) RVProxy.get(RVEnvironmentService.class)).getResources(null).getDimensionPixelSize(R.dimen.griver_bottom_height_tab_large_icon);
        }
        return ((RVEnvironmentService) RVProxy.get(RVEnvironmentService.class)).getResources(null).getDimensionPixelSize(R.dimen.griver_bottom_height_tab_icon);
    }
}
