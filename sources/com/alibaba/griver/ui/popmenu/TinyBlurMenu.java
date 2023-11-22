package com.alibaba.griver.ui.popmenu;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.alibaba.ariver.app.api.Page;
import com.alibaba.ariver.app.api.point.view.TitleBarCloseClickPoint;
import com.alibaba.ariver.app.api.point.view.TitleBarOptionClickPoint;
import com.alibaba.ariver.app.api.ui.StateListUtils;
import com.alibaba.ariver.app.api.ui.titlebar.TitleBar;
import com.alibaba.ariver.engine.api.EngineUtils;
import com.alibaba.ariver.kernel.api.extension.ExtensionPoint;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.service.RVEnvironmentService;
import com.alibaba.ariver.kernel.common.service.executor.ExecutorType;
import com.alibaba.ariver.kernel.common.service.executor.RVExecutorService;
import com.alibaba.ariver.kernel.common.utils.BundleUtils;
import com.alibaba.ariver.kernel.common.utils.DimensionUtil;
import com.alibaba.ariver.kernel.common.utils.ExecutorUtils;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.griver.api.common.menu.GRVBaseAppFavoriteMenuItem;
import com.alibaba.griver.api.common.menu.GRVMPMoreMenuItem;
import com.alibaba.griver.api.common.menu.GRVMPMoreMenuItemChangeListener;
import com.alibaba.griver.api.common.menu.GriverACMenuExtension;
import com.alibaba.griver.api.common.menu.GriverMenuExtension;
import com.alibaba.griver.api.common.menu.GriverMenuItem;
import com.alibaba.griver.api.constants.GriverLaunchParams;
import com.alibaba.griver.api.ui.titlebar.GriverBackHomeButtonStyleExtension;
import com.alibaba.griver.base.common.env.GriverEnv;
import com.alibaba.griver.base.common.logger.GriverLogger;
import com.alibaba.griver.base.common.utils.MapBuilder;
import com.alibaba.griver.base.common.utils.MonitorUtil;
import com.alibaba.griver.base.common.utils.TinyUtils;
import com.alibaba.griver.ui.R;
import com.alibaba.griver.ui.ant.utils.TypefaceCache;
import com.alibaba.griver.ui.popmenu.H5TinyPopMenu;
import com.alibaba.griver.ui.popmenu.ITinyMenuPopupWindow;
import com.alibaba.griver.ui.reddot.OnStateChangeListener;
import com.alibaba.griver.ui.reddot.RedDotManager;
import com.alibaba.griver.ui.titlebar.H5NavMenuItem;
import com.alibaba.griver.ui.titlebar.NebulaTitleView;
import com.alibaba.griver.ui.utils.ColorUtils;
import com.ap.zoloz.hummer.h5.ZolozEkycH5Handler;
import com.fullstory.instrumentation.InstrumentInjector;
import com.iap.ac.android.acs.operation.biz.region.bean.MenuExtraInfo;
import com.iap.ac.android.container.adapter.griver.extension.CustomMenuExtensionImpl;
import com.iap.ac.android.container.constant.ContainerKeys;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes6.dex */
public class TinyBlurMenu implements GRVMPMoreMenuItemChangeListener, IH5TinyPopMenu, OnStateChangeListener {
    public static final String ABOUT_ID = "1001";
    public static final String ABOUT_MENU_NAME = "About";
    public static final String ADD_TO_DESKTOP_ID = "1004";
    public static final String ADD_TO_DESKTOP_MENU_NAME = "Add to Desktop";
    public static final String ADD_TO_HOME_ID = "1017";
    public static final String ADD_TO_HOME_MENU_NAME = "Add to Home";
    public static final String BACK_TO_ALIPAY_HOME_ID = "1014";
    public static final String BACK_TO_ALIPAY_HOME_MENU_NAME = "Home";
    public static final String BACK_TO_HOME_ID = "BACK_TO_HOME";
    public static final String CANCEL_FAVORITE_ID = "1011";
    public static final String CLOSE_PERFORMANCE_ID = "CLOSE_PERFORMANCE_ID";
    public static final String CLOSE_PERFORMANCE_PANEL = "Close performance panel";
    public static final String CLOSE_VCONSOLE = "Close console";
    public static final String CLOSE_VCONSOLE_ID = "CLOSE_VCONSOLE_ID";
    public static final String FAVORITE_ID = "1005";
    public static final String FEEDBACK_ID = "1013";
    public static final String MESSAGE_ID = "1012";
    public static final String MY_FAVORITE_TINY_APP = "1016";
    public static final String OFFICIAL_FEEDBACK_ID = "1015";
    public static final String OPEN_PERFORMANCE_ID = "OPEN_PERFORMANCE_ID";
    public static final String OPEN_PERFORMANCE_PANEL = "Open performance panel";
    public static final String OPEN_VCONSOLE = "Open console";
    public static final String OPEN_VCONSOLE_ID = "OPEN_VCONSOLE_ID";
    public static final String SHARE_ID = "1002";
    public static final String TAG = "TinyBlurMenu";
    private static boolean b;
    private volatile String B;
    private volatile TinyMenuItemData C;
    private LocalBroadcastManager D;
    private TinyPopMenuReceiver E;

    /* renamed from: a  reason: collision with root package name */
    private String f6728a;
    private Page c;
    private Context f;
    private String g;
    private ITinyMenuPopupWindow i;
    private String m;
    public TinyMenuItemData mFavoriteJsInvokeModel;
    private TitleBarRightButtonView u;
    private TextView v;
    private View w;
    private Typeface x;
    private List<H5NavMenuItem> y;
    private List<JSONObject> d = new ArrayList();
    private volatile boolean h = false;
    private List<CornerMarkingData> j = new ArrayList();
    private int k = -1;
    private boolean l = false;
    private boolean n = false;

    /* renamed from: o  reason: collision with root package name */
    private boolean f6729o = false;
    private volatile boolean p = false;
    private volatile boolean q = false;
    private boolean r = false;
    private boolean s = false;
    private boolean t = false;
    private boolean z = false;
    private boolean A = false;
    private View.OnClickListener G = new View.OnClickListener() { // from class: com.alibaba.griver.ui.popmenu.TinyBlurMenu.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (TinyBlurMenu.this.u != null) {
                TinyBlurMenu.this.u.dismissBadgeView();
            }
            if (view == null) {
                return;
            }
            Object tag = view.getTag();
            if (tag instanceof Integer) {
                int intValue = ((Integer) tag).intValue();
                TinyMenuItemData tinyMenuItemData = null;
                if (intValue >= 0) {
                    try {
                        if (intValue < TinyBlurMenu.this.e.size()) {
                            tinyMenuItemData = (TinyMenuItemData) TinyBlurMenu.this.e.get(intValue);
                        }
                    } catch (Throwable unused) {
                        RVLogger.e(TinyBlurMenu.TAG, "tiny menu click problem");
                        return;
                    }
                }
                if (tinyMenuItemData == null) {
                    RVLogger.e(TinyBlurMenu.TAG, "jsInvokeModel==null");
                } else if (tinyMenuItemData.listener != null) {
                    tinyMenuItemData.listener.onItemClick(TinyBlurMenu.this.c, tinyMenuItemData.mid);
                }
            }
        }
    };
    private List<TinyMenuItemData> e = new ArrayList();
    private H5TinyPopMenu.TitleBarTheme F = null;

    @Override // com.alibaba.griver.ui.reddot.OnStateChangeListener
    public void onStateChange(String str, boolean z) {
        TitleBarRightButtonView titleBarRightButtonView = this.u;
        if (titleBarRightButtonView != null) {
            titleBarRightButtonView.showOptionMenuRedDot(z);
        }
    }

    @Override // com.alibaba.griver.ui.popmenu.IH5TinyPopMenu
    public void showMenu() {
        ITinyMenuPopupWindow iTinyMenuPopupWindow = this.i;
        if (iTinyMenuPopupWindow == null || !iTinyMenuPopupWindow.isShowMenu()) {
            d();
        }
    }

    @Override // com.alibaba.griver.ui.popmenu.IH5TinyPopMenu
    public void onRelease() {
        TinyPopMenuReceiver tinyPopMenuReceiver;
        LocalBroadcastManager localBroadcastManager = this.D;
        if (localBroadcastManager != null && (tinyPopMenuReceiver = this.E) != null) {
            localBroadcastManager.unregisterReceiver(tinyPopMenuReceiver);
            this.E = null;
        }
        RedDotManager.getInstance().removeNode(getUniqueKey());
        ITinyMenuPopupWindow iTinyMenuPopupWindow = this.i;
        if (iTinyMenuPopupWindow != null && iTinyMenuPopupWindow.isShowing()) {
            this.i.doDismissWithAnimation(false);
        }
        this.q = true;
        this.i = null;
        this.c = null;
        this.u = null;
        this.f = null;
    }

    @Override // com.alibaba.griver.ui.popmenu.IH5TinyPopMenu
    public void init(Page page, String str, Context context, ViewGroup viewGroup) {
        GriverLogger.d(TAG, "init menu start");
        a(str);
        a(context);
        setPage(page);
        if (page != null && page.getStartParams() != null) {
            page.getStartParams();
            this.m = page.getApp().getAppId();
            StringBuilder sb = new StringBuilder();
            sb.append(this.m);
            sb.append(TAG);
            this.f6728a = sb.toString();
        }
        if (((RVEnvironmentService) RVProxy.get(RVEnvironmentService.class)).getApplicationContext() != null) {
            this.D = LocalBroadcastManager.getInstance(((RVEnvironmentService) RVProxy.get(RVEnvironmentService.class)).getApplicationContext());
            this.E = new TinyPopMenuReceiver(this, this.m, this.q, this.p, this.u, this.i);
            if (this.D != null) {
                this.D.registerReceiver(this.E, new IntentFilter("broadcast_tiny_app_favorite"));
                this.D.registerReceiver(this.E, new IntentFilter("hide_title_bar_back_to_home"));
                this.D.registerReceiver(this.E, new IntentFilter("show_title_bar_back_to_home"));
                this.D.registerReceiver(this.E, new IntentFilter("show_title_bar_menu"));
            }
        }
        ((RVExecutorService) RVProxy.get(RVExecutorService.class)).getExecutor(ExecutorType.NORMAL).execute(new AnonymousClass2(page, context, viewGroup));
    }

    /* renamed from: com.alibaba.griver.ui.popmenu.TinyBlurMenu$2  reason: invalid class name */
    /* loaded from: classes6.dex */
    class AnonymousClass2 implements Runnable {
        final /* synthetic */ Context val$context;
        final /* synthetic */ Page val$h5Page;
        final /* synthetic */ ViewGroup val$optionContainer;

        AnonymousClass2(Page page, Context context, ViewGroup viewGroup) {
            this.val$h5Page = page;
            this.val$context = context;
            this.val$optionContainer = viewGroup;
        }

        @Override // java.lang.Runnable
        public void run() {
            ExecutorUtils.runOnMain(new Runnable() { // from class: com.alibaba.griver.ui.popmenu.TinyBlurMenu.2.1
                @Override // java.lang.Runnable
                public void run() {
                    if (AnonymousClass2.this.val$h5Page != null && TinyBlurMenu.this.f != null) {
                        TinyBlurMenu.this.i = new TinyMenuPopupWindowProxy(TinyBlurMenu.this.f);
                        if (TinyBlurMenu.this.E != null) {
                            TinyBlurMenu.this.E.setMenuPanel(TinyBlurMenu.this.i);
                        }
                        TinyBlurMenu.this.a();
                        try {
                            TitleBar titleBar = AnonymousClass2.this.val$h5Page.getPageContext().getTitleBar();
                            if (titleBar != null && titleBar.getContent() != null) {
                                TinyBlurMenu.this.w = titleBar.getContent().findViewById(R.id.h5_nav_back_to_home);
                                TinyBlurMenu.this.v = (TextView) titleBar.getContent().findViewById(R.id.h5_tv_nav_back_to_home);
                                if (TinyBlurMenu.this.v != null) {
                                    try {
                                        if (TinyBlurMenu.this.x == null) {
                                            TinyBlurMenu.this.x = TypefaceCache.getTypeface(TinyBlurMenu.this.f, "tinyfont", "tinyfont/titlebar.ttf");
                                            if (TinyBlurMenu.this.x != null) {
                                                TinyBlurMenu.this.v.setTypeface(TinyBlurMenu.this.x);
                                            }
                                        }
                                    } catch (Throwable unused) {
                                        RVLogger.e(TinyBlurMenu.TAG, "iconfont failed");
                                    }
                                    Resources resources = TinyBlurMenu.this.f.getResources();
                                    if (resources != null) {
                                        TinyBlurMenu.this.v.setText(resources.getText(R.string.griver_bar_back_to_home));
                                    }
                                    GriverBackHomeButtonStyleExtension griverBackHomeButtonStyleExtension = (GriverBackHomeButtonStyleExtension) RVProxy.get(GriverBackHomeButtonStyleExtension.class);
                                    if (TextUtils.equals("text", griverBackHomeButtonStyleExtension.getType()) && griverBackHomeButtonStyleExtension.getContent() != null) {
                                        TinyBlurMenu.this.v.setText(griverBackHomeButtonStyleExtension.getContent());
                                    } else if (TextUtils.equals("icon", griverBackHomeButtonStyleExtension.getType())) {
                                        try {
                                            Drawable iconDrawable = griverBackHomeButtonStyleExtension.getIconDrawable();
                                            TinyBlurMenu.this.v.setText("");
                                            TinyBlurMenu.this.v.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, iconDrawable, (Drawable) null);
                                        } catch (Exception unused2) {
                                        }
                                    }
                                    if (TinyBlurMenu.this.s) {
                                        try {
                                            TinyBlurMenu.this.e();
                                        } catch (Throwable th) {
                                            RVLogger.e(TinyBlurMenu.TAG, th);
                                        }
                                    }
                                }
                            }
                        } catch (Throwable th2) {
                            RVLogger.e(TinyBlurMenu.TAG, th2);
                        }
                    }
                    TinyBlurMenu.this.a(AnonymousClass2.this.val$context, AnonymousClass2.this.val$optionContainer);
                    TinyBlurMenu.this.e = new ArrayList();
                    ArrayList<GriverMenuItem> arrayList = new ArrayList();
                    List<GriverMenuItem> menuList = ((GriverMenuExtension) RVProxy.get(GriverMenuExtension.class)).getMenuList(AnonymousClass2.this.val$h5Page);
                    List<GriverMenuItem> menuList2 = ((GriverACMenuExtension) RVProxy.get(GriverACMenuExtension.class)).getMenuList(AnonymousClass2.this.val$h5Page);
                    if (menuList != null && menuList.size() > 0) {
                        arrayList.addAll(menuList);
                    }
                    if (menuList2 != null && menuList2.size() > 0) {
                        arrayList.addAll(menuList2);
                    }
                    for (GriverMenuItem griverMenuItem : arrayList) {
                        if (griverMenuItem instanceof GRVMPMoreMenuItem) {
                            final GRVMPMoreMenuItem gRVMPMoreMenuItem = (GRVMPMoreMenuItem) griverMenuItem;
                            gRVMPMoreMenuItem.addDataChangeListener(TinyBlurMenu.this);
                            if (gRVMPMoreMenuItem instanceof GRVBaseAppFavoriteMenuItem) {
                                TinyBlurMenu.this.onMenuItemChange(gRVMPMoreMenuItem);
                                if (TinyBlurMenu.this.u != null) {
                                    TinyBlurMenu.this.u.setFavoriteButtonClickListener(new View.OnClickListener() { // from class: com.alibaba.griver.ui.popmenu.TinyBlurMenu.2.1.1
                                        @Override // android.view.View.OnClickListener
                                        public void onClick(View view) {
                                            MonitorUtil.trackMenuClick(CustomMenuExtensionImpl.TYPE_FAVORITE, new MapBuilder.Builder().map("action", ((GRVBaseAppFavoriteMenuItem) gRVMPMoreMenuItem).getAppFavoriteStatus() == 1 ? "remove" : ZolozEkycH5Handler.HUMMER_FOUNDATION_ADD).map("from", MenuExtraInfo.MENU_ID_TITLE_BAR_COLLECT).build());
                                            if (gRVMPMoreMenuItem.listener != null) {
                                                gRVMPMoreMenuItem.listener.onItemClick(AnonymousClass2.this.val$h5Page, gRVMPMoreMenuItem.identifier);
                                            }
                                        }
                                    });
                                }
                            }
                            if (gRVMPMoreMenuItem.isShowBadge()) {
                                RedDotManager.getInstance().registerNode(gRVMPMoreMenuItem.uniqueKey, TinyBlurMenu.this.getUniqueKey());
                                RedDotManager.getInstance().resetState(gRVMPMoreMenuItem.uniqueKey, gRVMPMoreMenuItem.showBadge);
                            }
                        }
                        if (griverMenuItem.canShow(AnonymousClass2.this.val$h5Page)) {
                            TinyMenuItemData tinyMenuItemData = new TinyMenuItemData(griverMenuItem.name, null, null, griverMenuItem.identifier);
                            tinyMenuItemData.menuName = griverMenuItem.name;
                            tinyMenuItemData.listener = griverMenuItem.listener;
                            tinyMenuItemData.iconUrl = griverMenuItem.iconUrl;
                            try {
                                if (griverMenuItem.iconDrawable != 0) {
                                    tinyMenuItemData.h5MenuIcon = InstrumentInjector.Resources_getDrawable(AnonymousClass2.this.val$context.getResources(), griverMenuItem.iconDrawable);
                                }
                            } catch (Exception e) {
                                GriverLogger.w(TinyBlurMenu.TAG, "get resource failed", e);
                            }
                            TinyBlurMenu.this.e.add(tinyMenuItemData);
                        }
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        if (this.i == null && this.u == null) {
            return;
        }
        ExecutorUtils.runOnMain(new Runnable() { // from class: com.alibaba.griver.ui.popmenu.TinyBlurMenu.3
            @Override // java.lang.Runnable
            public void run() {
                if (TinyBlurMenu.this.i != null) {
                    TinyBlurMenu.this.i.updateCornerMarking(TinyBlurMenu.this.j);
                }
                if (TinyBlurMenu.this.u != null) {
                    TinyBlurMenu.this.u.updateCornerMarking(TinyBlurMenu.this.j);
                }
            }
        });
    }

    @Override // com.alibaba.griver.ui.popmenu.IH5TinyPopMenu
    public void onSwitchToLightTheme() {
        this.F = H5TinyPopMenu.TitleBarTheme.TITLE_BAR_THEME_LIGHT;
        if (TinyUtils.isMain()) {
            TitleBarRightButtonView titleBarRightButtonView = this.u;
            if (titleBarRightButtonView != null) {
                titleBarRightButtonView.switchTheme(this.F, 0);
            }
            if (this.w != null) {
                this.v.setTextColor(ContextCompat.BuiltInFictitiousFunctionClassFactory(GriverEnv.getApplicationContext(), R.color.griver_ui_light_icon_color));
            }
        }
    }

    @Override // com.alibaba.griver.ui.popmenu.IH5TinyPopMenu
    public void onSwitchToDarkTheme() {
        this.F = H5TinyPopMenu.TitleBarTheme.TITLE_BAR_THEME_DARK;
        if (TinyUtils.isMain()) {
            TitleBarRightButtonView titleBarRightButtonView = this.u;
            if (titleBarRightButtonView != null) {
                titleBarRightButtonView.switchTheme(this.F, 0);
            }
            if (this.w != null) {
                this.v.setTextColor(ContextCompat.BuiltInFictitiousFunctionClassFactory(GriverEnv.getApplicationContext(), R.color.griver_ui_dark_icon_color));
            }
        }
    }

    @Override // com.alibaba.griver.ui.popmenu.IH5TinyPopMenu
    public void onSwitchToCustomTheme(int i) {
        this.F = H5TinyPopMenu.TitleBarTheme.TITLE_BAR_THEME_CUSTOM;
        if (TinyUtils.isMain()) {
            TitleBarRightButtonView titleBarRightButtonView = this.u;
            if (titleBarRightButtonView != null) {
                titleBarRightButtonView.switchTheme(this.F, i);
            }
            if (this.w != null) {
                this.v.setTextColor(i);
            }
        }
    }

    public void setPage(Page page) {
        this.c = page;
    }

    private void a(String str) {
        this.g = str;
    }

    private void a(Context context) {
        this.f = context;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Context context, ViewGroup viewGroup) {
        if (context == null || viewGroup == null || this.c == null) {
            return;
        }
        for (int i = 0; i < viewGroup.getChildCount(); i++) {
            View childAt = viewGroup.getChildAt(i);
            if (childAt != null) {
                childAt.setVisibility(8);
            }
        }
        b();
        StringBuilder sb = new StringBuilder();
        sb.append("init..optionContainer=");
        sb.append(viewGroup);
        RVLogger.d(TAG, sb.toString());
        TitleBarRightButtonView titleBarRightButtonView = new TitleBarRightButtonView(context, this.F, BundleUtils.getInt(this.c.getStartParams(), "optionMenuColor", 0));
        this.u = titleBarRightButtonView;
        TinyPopMenuReceiver tinyPopMenuReceiver = this.E;
        if (tinyPopMenuReceiver != null) {
            tinyPopMenuReceiver.setRightButtonView(titleBarRightButtonView);
        }
        this.u.setAppId(this.m);
        this.u.setH5Page(this.c);
        this.u.setOptionMenuOnClickListener(new View.OnClickListener() { // from class: com.alibaba.griver.ui.popmenu.TinyBlurMenu.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                RVLogger.d(TinyBlurMenu.TAG, "OptionMenuClick");
                if (TinyBlurMenu.this.c != null && TinyBlurMenu.this.c.getRender() != null) {
                    EngineUtils.sendToRender(TinyBlurMenu.this.c.getRender(), "titleMoreClick", null, null);
                }
                ((TitleBarOptionClickPoint) ExtensionPoint.as(TitleBarOptionClickPoint.class).node(TinyBlurMenu.this.c).create()).onOptionClick(0, true);
            }
        });
        this.u.setCloseButtonOnClickListener(new View.OnClickListener() { // from class: com.alibaba.griver.ui.popmenu.TinyBlurMenu.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ((TitleBarCloseClickPoint) ExtensionPoint.as(TitleBarCloseClickPoint.class).node(TinyBlurMenu.this.c).create()).onCloseClick();
            }
        });
        this.u.setCloseButtonOnLongClickListener(new View.OnLongClickListener() { // from class: com.alibaba.griver.ui.popmenu.TinyBlurMenu.6
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                return true;
            }
        });
        float density = DimensionUtil.getDensity(context);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -1);
        layoutParams.gravity = 16;
        layoutParams.leftMargin = (int) (12.0f * density);
        layoutParams.rightMargin = (int) (density * 2.0f);
        viewGroup.addView(this.u, layoutParams);
        this.u.setTag(H5TinyPopMenu.TAG_VIEW);
        RedDotManager.getInstance().registerNode(this.f6728a, null);
        RedDotManager.getInstance().addParentStateDidChangeHandler(this.f6728a, this);
        a();
    }

    public String getUniqueKey() {
        return this.f6728a;
    }

    private void b() {
        Page page = this.c;
        if (page != null && this.F == null) {
            if (ColorUtils.getTheme(BundleUtils.getInt(page.getStartParams(), "titleBarColor", -16777216) | (-16777216), NebulaTitleView.Theme.LIGHT) == NebulaTitleView.Theme.LIGHT) {
                this.F = H5TinyPopMenu.TitleBarTheme.TITLE_BAR_THEME_LIGHT;
            } else {
                this.F = H5TinyPopMenu.TitleBarTheme.TITLE_BAR_THEME_DARK;
            }
            if (BundleUtils.getInt(this.c.getStartParams(), "optionMenuColor", 0) != 0) {
                this.F = H5TinyPopMenu.TitleBarTheme.TITLE_BAR_THEME_CUSTOM;
            }
        }
    }

    @Override // com.alibaba.griver.ui.popmenu.IH5TinyPopMenu
    public void setH5MenuList(List<H5NavMenuItem> list, boolean z) {
        RVLogger.d(TAG, "setH5MenuList...");
        this.y = list;
        if (z) {
            c();
        }
    }

    @Override // com.alibaba.griver.ui.popmenu.IH5TinyPopMenu
    public void setH5ShowOptionMenuFlag() {
        RVLogger.d(TAG, "setH5ShowOptionMenuFlag");
        this.z = true;
    }

    @Override // com.alibaba.griver.ui.popmenu.IH5TinyPopMenu
    public void setH5OptionMenuTextFlag() {
        RVLogger.d(TAG, "setH5OptionMenuTextFlag");
        this.A = true;
    }

    @Override // com.alibaba.griver.ui.popmenu.IH5TinyPopMenu
    public boolean containsFavoriteMenuItem() {
        return this.mFavoriteJsInvokeModel != null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        if ((this.f instanceof Activity) && !this.t) {
            this.t = true;
            showMenu();
        }
    }

    private void d() {
        if (TinyUtils.isMain()) {
            a((List<TinyMenuFunctionModel>) null);
        } else {
            ExecutorUtils.runOnMain(new Runnable() { // from class: com.alibaba.griver.ui.popmenu.TinyBlurMenu.7
                @Override // java.lang.Runnable
                public void run() {
                    TinyBlurMenu.this.a((List<TinyMenuFunctionModel>) null);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(List<TinyMenuFunctionModel> list) {
        if (this.c != null && this.i != null && this.e != null && this.f != null && !TextUtils.isEmpty(this.m) && !this.q && !this.l) {
            if (list == null) {
                list = new ArrayList<>();
            }
            this.i.setCurrentAppId(this.m);
            this.i.setH5Page(this.c);
            this.i.setMenus(this.e);
            this.i.setTinyAppDesc(this.B);
            this.i.setMiniAbout(this.C);
            this.i.setRecentUseTinyAppList(list);
            this.i.setMenuClickListener(this.G);
            this.i.setOnShowListener(new DialogInterface.OnShowListener() { // from class: com.alibaba.griver.ui.popmenu.TinyBlurMenu.8
                @Override // android.content.DialogInterface.OnShowListener
                public void onShow(DialogInterface dialogInterface) {
                    if (TinyBlurMenu.this.u != null) {
                        TinyBlurMenu.this.u.isShowTitleBarFavorite();
                    }
                }
            });
            this.i.setOnMenuWindowDismissListener(new ITinyMenuPopupWindow.OnMenuWindowDismissListener() { // from class: com.alibaba.griver.ui.popmenu.TinyBlurMenu.9
                @Override // com.alibaba.griver.ui.popmenu.ITinyMenuPopupWindow.OnMenuWindowDismissListener
                public void onDismiss(ITinyMenuPopupWindow iTinyMenuPopupWindow) {
                    TinyBlurMenu.this.t = false;
                }
            });
            this.i.showMenu(this.f);
            return;
        }
        this.t = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        TitleBar titleBar;
        Resources resources;
        Context context;
        View content;
        if (this.q) {
            return;
        }
        Page page = this.c;
        if (page != null) {
            String string = BundleUtils.getString(page.getStartParams(), "leftTitlebarShow");
            StringBuilder sb = new StringBuilder();
            sb.append("leftTitlebarShow ");
            sb.append(string);
            RVLogger.debug(TAG, sb.toString());
            TitleBar titleBar2 = this.c.getPageContext().getTitleBar();
            View view = null;
            if (titleBar2 != null && (content = titleBar2.getContent()) != null) {
                view = content.findViewById(R.id.h5_nav_back);
            }
            if ("back".equalsIgnoreCase(string) && view != null) {
                view.setVisibility(0);
                a(0);
                f();
                return;
            } else if ("none".equalsIgnoreCase(string) && view != null) {
                view.setVisibility(8);
                f();
                return;
            } else if (!this.s) {
                f();
                return;
            }
        }
        Page page2 = this.c;
        if (page2 != null) {
            Object obj = page2.getStartParams().get(H5TinyPopMenu.SHOW_BACK_TO_HOME_TITLE_BAR);
            if ((obj instanceof Boolean) && !((Boolean) obj).booleanValue()) {
                f();
                return;
            }
        }
        Page page3 = this.c;
        if (page3 == null || this.v == null || this.w == null || (titleBar = page3.getPageContext().getTitleBar()) == null || titleBar.getContent() == null) {
            return;
        }
        View content2 = titleBar.getContent();
        View findViewById = content2.findViewById(R.id.h5_nav_back);
        View findViewById2 = content2.findViewById(R.id.h5_nav_close);
        boolean z = BundleUtils.getBoolean(this.c.getStartParams(), "redirectFromHomepage", false);
        if (findViewById != null && findViewById.getVisibility() != 0 && findViewById2 != null && findViewById2.getVisibility() != 0) {
            if (this.w.getVisibility() == 0) {
                return;
            }
            try {
                if (this.x == null && (context = this.f) != null) {
                    Typeface typeface = TypefaceCache.getTypeface(context, "tinyfont", "tinyfont/titlebar.ttf");
                    this.x = typeface;
                    if (typeface != null) {
                        this.v.setTypeface(typeface);
                    }
                }
            } catch (Throwable unused) {
                RVLogger.e(TAG, "iconfont failed");
            }
            if (BundleUtils.contains(this.c.getStartParams(), GriverLaunchParams.BACK_HOME_BUTTON_COLOR)) {
                try {
                    this.v.setTextColor(StateListUtils.getStateColor(BundleUtils.getInt(this.c.getStartParams(), GriverLaunchParams.BACK_HOME_BUTTON_COLOR) | (-16777216)));
                } catch (Exception e) {
                    GriverLogger.e(TAG, "set custom back home color failed", e);
                }
            }
            Context context2 = this.f;
            if (context2 != null && (resources = context2.getResources()) != null) {
                this.w.setContentDescription(resources.getString(R.string.griver_ui_tiny_back_to_home));
            }
            if (z) {
                this.w.setVisibility(8);
                return;
            }
            this.w.setVisibility(0);
            a(0);
            this.w.setOnClickListener(new View.OnClickListener() { // from class: com.alibaba.griver.ui.popmenu.TinyBlurMenu.10
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (TinyBlurMenu.this.c == null || TinyBlurMenu.this.c.getRender() == null) {
                        return;
                    }
                    EngineUtils.sendToRender(TinyBlurMenu.this.c.getRender(), "onBackHomeClick", null, null);
                }
            });
            return;
        }
        View view2 = this.w;
        if (view2 != null) {
            view2.setVisibility(8);
        }
    }

    private void f() {
        View view = this.w;
        if (view == null || this.c == null || view.getVisibility() != 0) {
            return;
        }
        this.w.setVisibility(8);
        a(16);
    }

    private void a(int i) {
        TitleBar titleBar;
        View content;
        RelativeLayout relativeLayout;
        RelativeLayout.LayoutParams layoutParams;
        Context context;
        Page page = this.c;
        if (page == null || (titleBar = page.getPageContext().getTitleBar()) == null || (content = titleBar.getContent()) == null || (relativeLayout = (RelativeLayout) content.findViewById(R.id.h5_rl_title)) == null || (layoutParams = (RelativeLayout.LayoutParams) relativeLayout.getLayoutParams()) == null || (context = this.f) == null) {
            return;
        }
        layoutParams.setMargins(DimensionUtil.dip2px(context, i), 0, 0, 0);
    }

    @Override // com.alibaba.griver.api.common.menu.GRVMPMoreMenuItemChangeListener
    public void onMenuItemChange(final GRVMPMoreMenuItem gRVMPMoreMenuItem) {
        ExecutorUtils.runOnMain(new Runnable() { // from class: com.alibaba.griver.ui.popmenu.TinyBlurMenu.11
            @Override // java.lang.Runnable
            public void run() {
                RedDotManager.getInstance().resetState(gRVMPMoreMenuItem.uniqueKey, gRVMPMoreMenuItem.showBadge);
                GRVMPMoreMenuItem gRVMPMoreMenuItem2 = gRVMPMoreMenuItem;
                if (gRVMPMoreMenuItem2 instanceof GRVBaseAppFavoriteMenuItem) {
                    GRVBaseAppFavoriteMenuItem gRVBaseAppFavoriteMenuItem = (GRVBaseAppFavoriteMenuItem) gRVMPMoreMenuItem2;
                    int appFavoriteStatus = gRVBaseAppFavoriteMenuItem.getAppFavoriteStatus();
                    if (appFavoriteStatus != -1) {
                        if (appFavoriteStatus != 0) {
                            if (appFavoriteStatus == 1 && TinyBlurMenu.this.u != null) {
                                if (!gRVBaseAppFavoriteMenuItem.canShowTitle()) {
                                    TinyBlurMenu.this.u.setFavoriteStatus(true, null);
                                } else {
                                    TinyBlurMenu.this.u.setFavoriteBtnVisibility(0);
                                    if (gRVBaseAppFavoriteMenuItem.titleInfos == null || !gRVBaseAppFavoriteMenuItem.titleInfos.containsKey("HIGHLIGHT")) {
                                        TinyBlurMenu.this.u.setFavoriteStatus(true, null);
                                    } else {
                                        TinyBlurMenu.this.u.setFavoriteStatus(true, gRVBaseAppFavoriteMenuItem.titleInfos.get("HIGHLIGHT").iconUrl);
                                    }
                                }
                            }
                        } else if (TinyBlurMenu.this.u != null) {
                            if (!gRVBaseAppFavoriteMenuItem.canShowTitle()) {
                                TinyBlurMenu.this.u.setFavoriteStatus(false, null);
                            } else {
                                TinyBlurMenu.this.u.setFavoriteBtnVisibility(0);
                                if (gRVBaseAppFavoriteMenuItem.titleInfos == null || !gRVBaseAppFavoriteMenuItem.titleInfos.containsKey("DEFAULT")) {
                                    TinyBlurMenu.this.u.setFavoriteStatus(false, null);
                                } else {
                                    TinyBlurMenu.this.u.setFavoriteStatus(false, gRVBaseAppFavoriteMenuItem.titleInfos.get("DEFAULT").iconUrl);
                                }
                            }
                        }
                    } else if (TinyBlurMenu.this.u != null) {
                        TinyBlurMenu.this.u.setFavoriteBtnVisibility(8);
                    }
                    if (TinyBlurMenu.this.c == null || gRVBaseAppFavoriteMenuItem.canShowTitle() || TinyBlurMenu.this.u == null) {
                        return;
                    }
                    TinyBlurMenu.this.u.setFavoriteBtnVisibility(8);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public static class TinyPopMenuReceiver extends BroadcastReceiver {

        /* renamed from: a  reason: collision with root package name */
        private String f6730a;
        private boolean b;
        private boolean c;
        private WeakReference<TinyBlurMenu> d;
        private WeakReference<TitleBarRightButtonView> e;
        private WeakReference<ITinyMenuPopupWindow> f;

        public TinyPopMenuReceiver(TinyBlurMenu tinyBlurMenu, String str, boolean z, boolean z2, TitleBarRightButtonView titleBarRightButtonView, ITinyMenuPopupWindow iTinyMenuPopupWindow) {
            this.f6730a = str;
            this.b = z;
            this.c = z2;
            this.d = new WeakReference<>(tinyBlurMenu);
            this.e = new WeakReference<>(titleBarRightButtonView);
            this.f = new WeakReference<>(iTinyMenuPopupWindow);
        }

        public void setFavorite(boolean z) {
            this.c = z;
        }

        public void setBlurMenu(TinyBlurMenu tinyBlurMenu) {
            this.d = new WeakReference<>(tinyBlurMenu);
        }

        public void setRightButtonView(TitleBarRightButtonView titleBarRightButtonView) {
            this.e = new WeakReference<>(titleBarRightButtonView);
        }

        public void setMenuPanel(ITinyMenuPopupWindow iTinyMenuPopupWindow) {
            this.f = new WeakReference<>(iTinyMenuPopupWindow);
        }

        public void setAppId(String str) {
            this.f6730a = str;
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            TinyBlurMenu tinyBlurMenu;
            TinyBlurMenu tinyBlurMenu2;
            if (intent != null) {
                try {
                    String action = intent.getAction();
                    if (TextUtils.equals("hide_title_bar_back_to_home", action)) {
                        if (TextUtils.equals(intent.getStringExtra("appId"), this.f6730a)) {
                            try {
                                WeakReference<TinyBlurMenu> weakReference = this.d;
                                if (weakReference == null || (tinyBlurMenu2 = weakReference.get()) == null) {
                                    return;
                                }
                                tinyBlurMenu2.s = false;
                                tinyBlurMenu2.e();
                                return;
                            } catch (Throwable th) {
                                RVLogger.e(TinyBlurMenu.TAG, th);
                                return;
                            }
                        }
                        return;
                    } else if (TextUtils.equals("show_title_bar_back_to_home", action)) {
                        if (TextUtils.equals(intent.getStringExtra("appId"), this.f6730a)) {
                            try {
                                WeakReference<TinyBlurMenu> weakReference2 = this.d;
                                if (weakReference2 == null || (tinyBlurMenu = weakReference2.get()) == null) {
                                    return;
                                }
                                tinyBlurMenu.s = true;
                                tinyBlurMenu.e();
                                return;
                            } catch (Throwable th2) {
                                RVLogger.e(TinyBlurMenu.TAG, th2);
                                return;
                            }
                        }
                        return;
                    } else if (TextUtils.equals("show_title_bar_menu", action) && TextUtils.equals(intent.getStringExtra("appId"), this.f6730a)) {
                        try {
                            WeakReference<TinyBlurMenu> weakReference3 = this.d;
                            if (weakReference3 != null) {
                                TinyBlurMenu tinyBlurMenu3 = weakReference3.get();
                                int intExtra = intent.getIntExtra(ContainerKeys.PARAM_PAGE_ID, 0);
                                if (tinyBlurMenu3 == null || tinyBlurMenu3.c == null || intExtra != tinyBlurMenu3.c.getPageId()) {
                                    return;
                                }
                                tinyBlurMenu3.c();
                                return;
                            }
                            return;
                        } catch (Throwable th3) {
                            RVLogger.e(TinyBlurMenu.TAG, th3);
                            return;
                        }
                    } else {
                        return;
                    }
                } catch (Throwable th4) {
                    RVLogger.e(TinyBlurMenu.TAG, th4);
                }
                RVLogger.e(TinyBlurMenu.TAG, th4);
            }
        }
    }
}
