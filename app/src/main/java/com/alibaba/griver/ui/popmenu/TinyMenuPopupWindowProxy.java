package com.alibaba.griver.ui.popmenu;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.view.View;
import com.alibaba.ariver.app.api.Page;
import com.alibaba.ariver.kernel.RVStartParams;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.griver.base.common.env.GriverEnv;
import com.alibaba.griver.ui.popmenu.ITinyMenuPopupWindow;
import java.util.List;

/* loaded from: classes6.dex */
public class TinyMenuPopupWindowProxy implements ITinyMenuPopupWindow {

    /* renamed from: a  reason: collision with root package name */
    private TinyMenuPopupWindow f6736a;
    private LandScapeTinyMenuPopupWindow b;

    public TinyMenuPopupWindowProxy(Context context) {
        this.f6736a = new TinyMenuPopupWindow(context);
        this.b = new LandScapeTinyMenuPopupWindow(context);
    }

    public static String getOrientation(Context context) {
        if (context == null) {
            return null;
        }
        String a2 = context instanceof Activity ? a((Activity) context) : null;
        return a2 == null ? a(context) : a2;
    }

    private static String a(Activity activity) {
        int requestedOrientation = activity.getRequestedOrientation();
        if (requestedOrientation != 0) {
            if (requestedOrientation != 1) {
                return null;
            }
            return "portrait";
        }
        return "landscape";
    }

    private static String a(Context context) {
        int i = context.getResources().getConfiguration().orientation;
        if (i != 1) {
            if (i != 2) {
                return null;
            }
            return "landscape";
        }
        return "portrait";
    }

    @Override // com.alibaba.griver.ui.popmenu.ITinyMenuPopupWindow
    public void setCurrentAppId(String str) {
        this.f6736a.setCurrentAppId(str);
        this.b.setCurrentAppId(str);
    }

    @Override // com.alibaba.griver.ui.popmenu.ITinyMenuPopupWindow
    public void setH5Page(Page page) {
        this.f6736a.setH5Page(page);
        this.b.setH5Page(page);
    }

    @Override // com.alibaba.griver.ui.popmenu.ITinyMenuPopupWindow
    public boolean isShowMenu() {
        return this.f6736a.isShowMenu() || this.b.isShowMenu();
    }

    @Override // com.alibaba.griver.ui.popmenu.ITinyMenuPopupWindow
    public boolean isShowing() {
        return this.f6736a.isShowing() || this.b.isShowing();
    }

    @Override // com.alibaba.griver.ui.popmenu.ITinyMenuPopupWindow
    public void showMenu(Context context) {
        String orientation = getOrientation(context);
        StringBuilder sb = new StringBuilder();
        sb.append("showMenu ");
        sb.append(orientation);
        RVLogger.d("TinyMenuPopupWindowProxy", sb.toString());
        if ("landscape".equals(orientation)) {
            RVLogger.d("TinyMenuPopupWindowProxy", "show Menu landscape");
            this.b.showMenu(context);
            return;
        }
        RVLogger.d("TinyMenuPopupWindowProxy", "show Menu normal");
        this.f6736a.showMenu(context);
    }

    @Override // com.alibaba.griver.ui.popmenu.ITinyMenuPopupWindow
    public void setMenuClickListener(View.OnClickListener onClickListener) {
        this.f6736a.setMenuClickListener(onClickListener);
        this.b.setMenuClickListener(onClickListener);
    }

    @Override // com.alibaba.griver.ui.popmenu.ITinyMenuPopupWindow
    public void setOnMenuWindowDismissListener(ITinyMenuPopupWindow.OnMenuWindowDismissListener onMenuWindowDismissListener) {
        this.f6736a.setOnMenuWindowDismissListener(onMenuWindowDismissListener);
        this.b.setOnMenuWindowDismissListener(onMenuWindowDismissListener);
    }

    @Override // com.alibaba.griver.ui.popmenu.ITinyMenuPopupWindow
    public void setMenus(List<TinyMenuItemData> list) {
        this.f6736a.setMenus(list);
        this.b.setMenus(list);
    }

    @Override // com.alibaba.griver.ui.popmenu.ITinyMenuPopupWindow
    public void setRecentUseTinyAppList(List<TinyMenuFunctionModel> list) {
        this.f6736a.setRecentUseTinyAppList(list);
        this.b.setRecentUseTinyAppList(list);
    }

    @Override // com.alibaba.griver.ui.popmenu.ITinyMenuPopupWindow
    public void isShowRecentUseTinyAppArea(boolean z) {
        this.f6736a.isShowRecentUseTinyAppArea(z);
        this.b.isShowRecentUseTinyAppArea(z);
    }

    @Override // com.alibaba.griver.ui.popmenu.ITinyMenuPopupWindow
    public void updateFavoriteMenuItem(boolean z, List<TinyMenuItemData> list) {
        this.f6736a.updateFavoriteMenuItem(z, list);
        this.b.updateFavoriteMenuItem(z, list);
    }

    @Override // com.alibaba.griver.ui.popmenu.ITinyMenuPopupWindow
    public void updateMessageMenuItem(List<TinyMenuItemData> list) {
        this.f6736a.updateMessageMenuItem(list);
        this.b.updateMessageMenuItem(list);
    }

    @Override // com.alibaba.griver.ui.popmenu.ITinyMenuPopupWindow
    public void setTinyAppDesc(String str) {
        this.f6736a.setTinyAppDesc(str);
        this.b.setTinyAppDesc(str);
    }

    @Override // com.alibaba.griver.ui.popmenu.ITinyMenuPopupWindow
    public void setMiniAbout(TinyMenuItemData tinyMenuItemData) {
        this.f6736a.setMiniAbout(tinyMenuItemData);
        this.b.setMiniAbout(tinyMenuItemData);
    }

    @Override // com.alibaba.griver.ui.popmenu.ITinyMenuPopupWindow
    public void updateCornerMarking(List<CornerMarkingData> list) {
        this.f6736a.updateCornerMarking(list);
        this.b.updateCornerMarking(list);
    }

    @Override // com.alibaba.griver.ui.popmenu.ITinyMenuPopupWindow
    public void doDismissWithAnimation(boolean z) {
        if (RVStartParams.KEY_LANDSCAPE_SHORT.equals(getOrientation(GriverEnv.getApplicationContext()))) {
            this.b.doDismissWithAnimation(z);
        } else {
            this.f6736a.doDismissWithAnimation(z);
        }
    }

    @Override // com.alibaba.griver.ui.popmenu.ITinyMenuPopupWindow
    public void setOnShowListener(DialogInterface.OnShowListener onShowListener) {
        this.f6736a.setOnShowListener(onShowListener);
        this.b.setOnShowListener(onShowListener);
    }
}
