package com.alibaba.griver.ui.popmenu;

import android.content.Context;
import android.view.ViewGroup;
import com.alibaba.ariver.app.api.Page;
import com.alibaba.griver.ui.titlebar.H5NavMenuItem;
import java.util.List;

/* loaded from: classes6.dex */
public interface IH5TinyPopMenu {
    boolean containsFavoriteMenuItem();

    void init(Page page, String str, Context context, ViewGroup viewGroup);

    void onRelease();

    void onSwitchToCustomTheme(int i);

    void onSwitchToDarkTheme();

    void onSwitchToLightTheme();

    void setH5MenuList(List<H5NavMenuItem> list, boolean z);

    void setH5OptionMenuTextFlag();

    void setH5ShowOptionMenuFlag();

    void showMenu();
}
