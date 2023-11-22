package com.alibaba.ariver.app.ui;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import com.alibaba.ariver.app.api.ui.StatusBarUtils;
import com.alibaba.ariver.app.api.ui.ViewSpecProvider;
import com.alibaba.ariver.kernel.common.utils.DimensionUtil;
import com.alibaba.ariver.kernel.common.utils.RVLogger;

/* loaded from: classes3.dex */
public class DefaultViewSpecProvider implements ViewSpecProvider {
    private static boolean ISGET = false;
    private static int SCREEN_WIDTH = 0;
    private static final int TAB_BAR_HEIGHT_DP = 54;
    private static final String TAG = "AriverApp:DefaultViewSpecProvider";
    private static final int TITLE_BAR_HEIGHT_DP = 48;
    private Activity mActivity;

    public DefaultViewSpecProvider(Activity activity) {
        this.mActivity = activity;
    }

    protected Activity getActivity() {
        return this.mActivity;
    }

    private static void initWidthAndHeight(Context context) {
        if (ISGET) {
            return;
        }
        int screenWidth = DimensionUtil.getScreenWidth(context);
        int screenHeight = DimensionUtil.getScreenHeight(context);
        if (screenWidth < screenHeight) {
            SCREEN_WIDTH = screenWidth;
        } else {
            SCREEN_WIDTH = screenHeight;
        }
        ISGET = true;
    }

    @Override // com.alibaba.ariver.app.api.ui.ViewSpecProvider
    public int getWidthSpec() {
        initWidthAndHeight(this.mActivity);
        StringBuilder sb = new StringBuilder();
        sb.append("fragmentOptEnabled getWidthSpec: ");
        sb.append(SCREEN_WIDTH);
        RVLogger.debug(TAG, sb.toString());
        return View.MeasureSpec.makeMeasureSpec(SCREEN_WIDTH, 1073741824);
    }

    @Override // com.alibaba.ariver.app.api.ui.ViewSpecProvider
    public int getHeightSpec() {
        RVLogger.debug(TAG, "fragmentOptEnabled not calculate for getHeightSpec");
        return View.MeasureSpec.makeMeasureSpec(0, Integer.MIN_VALUE);
    }

    @Override // com.alibaba.ariver.app.api.ui.ViewSpecProvider
    public int getTitleBarHeightSpec() {
        initWidthAndHeight(this.mActivity);
        int titleBarHeight = getTitleBarHeight();
        StringBuilder sb = new StringBuilder();
        sb.append("fragmentOptEnabled getTitleBarHeightSpec: ");
        sb.append(titleBarHeight);
        RVLogger.debug(TAG, sb.toString());
        return View.MeasureSpec.makeMeasureSpec(titleBarHeight, 1073741824);
    }

    @Override // com.alibaba.ariver.app.api.ui.ViewSpecProvider
    public int getTitleBarRawHeight() {
        return DimensionUtil.dip2px(getActivity(), 48.0f);
    }

    protected int getTitleBarHeight() {
        int titleBarRawHeight = getTitleBarRawHeight();
        return StatusBarUtils.isSupport() ? titleBarRawHeight + StatusBarUtils.getStatusBarHeight(getActivity()) : titleBarRawHeight;
    }

    protected int getTabBarHeight() {
        return DimensionUtil.dip2px(getActivity(), 54.0f);
    }

    @Override // com.alibaba.ariver.app.api.ui.ViewSpecProvider
    public int getPageHeightSpec(boolean z) {
        return View.MeasureSpec.makeMeasureSpec(0, Integer.MIN_VALUE);
    }

    @Override // com.alibaba.ariver.app.api.ui.ViewSpecProvider
    public int getTabBarHeightSpec() {
        initWidthAndHeight(this.mActivity);
        int tabBarHeight = getTabBarHeight();
        StringBuilder sb = new StringBuilder();
        sb.append("getTabBarHeightSpec: ");
        sb.append(tabBarHeight);
        RVLogger.debug(TAG, sb.toString());
        return View.MeasureSpec.makeMeasureSpec(tabBarHeight, 1073741824);
    }
}
