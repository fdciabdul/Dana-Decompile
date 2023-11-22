package com.alibaba.griver.ui.popmenu;

import android.content.Context;
import android.view.ViewGroup;
import com.alibaba.ariver.app.api.Page;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.griver.ui.titlebar.H5NavMenuItem;
import java.util.List;

/* loaded from: classes6.dex */
public class H5TinyPopMenu implements IH5TinyPopMenu {
    public static final String DEVELOPER_CUSTOM_MENU = "setCustomPopMenu";
    public static final String SHOW_BACK_TO_HOMEPAGE = "showBackToHomepage";
    public static final String SHOW_BACK_TO_HOME_POP_MENU = "showBackToHomeBackMenu";
    public static final String SHOW_BACK_TO_HOME_TITLE_BAR = "showBackToHomeTitleBar";
    public static final String SHOW_DESKTOP_POP_MENU = "showDesktopMenu";
    public static final String SHOW_FAVORITE_POP_MENU = "showFavoriteMenu";
    public static final String SHOW_SHARE_POP_MENU = "showShareMenu";
    public static final Object TAG_VIEW = new Object();

    /* renamed from: a  reason: collision with root package name */
    private IH5TinyPopMenu f6722a;
    private TitleBarTheme b;
    private boolean c = false;
    private boolean d = false;
    private List<H5NavMenuItem> e;

    /* loaded from: classes6.dex */
    public enum TitleBarTheme {
        TITLE_BAR_THEME_DARK,
        TITLE_BAR_THEME_LIGHT,
        TITLE_BAR_THEME_CUSTOM
    }

    @Override // com.alibaba.griver.ui.popmenu.IH5TinyPopMenu
    public void showMenu() {
        IH5TinyPopMenu iH5TinyPopMenu = this.f6722a;
        if (iH5TinyPopMenu != null) {
            iH5TinyPopMenu.showMenu();
        }
    }

    @Override // com.alibaba.griver.ui.popmenu.IH5TinyPopMenu
    public void onRelease() {
        IH5TinyPopMenu iH5TinyPopMenu = this.f6722a;
        if (iH5TinyPopMenu != null) {
            iH5TinyPopMenu.onRelease();
            this.f6722a = null;
        }
        this.b = null;
        this.d = false;
        this.c = false;
        this.e = null;
    }

    @Override // com.alibaba.griver.ui.popmenu.IH5TinyPopMenu
    public void init(Page page, String str, Context context, ViewGroup viewGroup) {
        a(viewGroup);
        if (this.f6722a == null) {
            this.f6722a = a();
        }
        IH5TinyPopMenu iH5TinyPopMenu = this.f6722a;
        if (iH5TinyPopMenu != null) {
            try {
                iH5TinyPopMenu.init(page, str, context, viewGroup);
            } catch (Throwable unused) {
                RVLogger.e("H5TinyPopMenu", "new tiny menu init failed");
            }
        }
    }

    private IH5TinyPopMenu a() {
        return new TinyBlurMenu();
    }

    @Override // com.alibaba.griver.ui.popmenu.IH5TinyPopMenu
    public void onSwitchToLightTheme() {
        this.b = TitleBarTheme.TITLE_BAR_THEME_LIGHT;
        IH5TinyPopMenu iH5TinyPopMenu = this.f6722a;
        if (iH5TinyPopMenu != null) {
            iH5TinyPopMenu.onSwitchToLightTheme();
        }
    }

    @Override // com.alibaba.griver.ui.popmenu.IH5TinyPopMenu
    public void onSwitchToDarkTheme() {
        this.b = TitleBarTheme.TITLE_BAR_THEME_DARK;
        IH5TinyPopMenu iH5TinyPopMenu = this.f6722a;
        if (iH5TinyPopMenu != null) {
            iH5TinyPopMenu.onSwitchToDarkTheme();
        }
    }

    @Override // com.alibaba.griver.ui.popmenu.IH5TinyPopMenu
    public void onSwitchToCustomTheme(int i) {
        this.b = TitleBarTheme.TITLE_BAR_THEME_CUSTOM;
        IH5TinyPopMenu iH5TinyPopMenu = this.f6722a;
        if (iH5TinyPopMenu != null) {
            iH5TinyPopMenu.onSwitchToCustomTheme(i);
        }
    }

    @Override // com.alibaba.griver.ui.popmenu.IH5TinyPopMenu
    public void setH5MenuList(List<H5NavMenuItem> list, boolean z) {
        this.e = list;
        IH5TinyPopMenu iH5TinyPopMenu = this.f6722a;
        if (iH5TinyPopMenu != null) {
            iH5TinyPopMenu.setH5MenuList(list, z);
        }
    }

    @Override // com.alibaba.griver.ui.popmenu.IH5TinyPopMenu
    public void setH5ShowOptionMenuFlag() {
        this.c = true;
        IH5TinyPopMenu iH5TinyPopMenu = this.f6722a;
        if (iH5TinyPopMenu != null) {
            iH5TinyPopMenu.setH5ShowOptionMenuFlag();
        }
    }

    @Override // com.alibaba.griver.ui.popmenu.IH5TinyPopMenu
    public void setH5OptionMenuTextFlag() {
        this.d = true;
        IH5TinyPopMenu iH5TinyPopMenu = this.f6722a;
        if (iH5TinyPopMenu != null) {
            iH5TinyPopMenu.setH5OptionMenuTextFlag();
        }
    }

    @Override // com.alibaba.griver.ui.popmenu.IH5TinyPopMenu
    public boolean containsFavoriteMenuItem() {
        IH5TinyPopMenu iH5TinyPopMenu = this.f6722a;
        if (iH5TinyPopMenu != null) {
            return iH5TinyPopMenu.containsFavoriteMenuItem();
        }
        return false;
    }

    private void a(ViewGroup viewGroup) {
        IH5TinyPopMenu iH5TinyPopMenu;
        IH5TinyPopMenu iH5TinyPopMenu2;
        IH5TinyPopMenu iH5TinyPopMenu3;
        IH5TinyPopMenu iH5TinyPopMenu4;
        try {
            if (this.b == TitleBarTheme.TITLE_BAR_THEME_LIGHT) {
                IH5TinyPopMenu iH5TinyPopMenu5 = this.f6722a;
                if (iH5TinyPopMenu5 != null) {
                    iH5TinyPopMenu5.onSwitchToLightTheme();
                }
            } else if (this.b == TitleBarTheme.TITLE_BAR_THEME_DARK && (iH5TinyPopMenu = this.f6722a) != null) {
                iH5TinyPopMenu.onSwitchToDarkTheme();
            }
            List<H5NavMenuItem> list = this.e;
            if (list != null && (iH5TinyPopMenu4 = this.f6722a) != null) {
                iH5TinyPopMenu4.setH5MenuList(list, false);
            }
            if (this.c && (iH5TinyPopMenu3 = this.f6722a) != null) {
                iH5TinyPopMenu3.setH5ShowOptionMenuFlag();
            }
            if (!this.d || (iH5TinyPopMenu2 = this.f6722a) == null) {
                return;
            }
            iH5TinyPopMenu2.setH5OptionMenuTextFlag();
        } catch (Throwable th) {
            RVLogger.e("H5TinyPopMenu", th);
        }
    }
}
