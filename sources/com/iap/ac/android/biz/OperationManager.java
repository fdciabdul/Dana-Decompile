package com.iap.ac.android.biz;

import android.content.Context;
import android.graphics.Point;
import android.view.View;
import com.iap.ac.android.acs.plugin.biz.region.stageinfo.FetchLaunchableGroupsCallback;
import com.iap.ac.android.acs.plugin.biz.region.stageinfo.repository.outter.LaunchableGroup;
import com.iap.ac.android.biz.b.d;
import com.iap.ac.android.biz.common.constants.Constants;
import com.iap.ac.android.biz.common.utils.Utils;
import com.iap.ac.android.region.cdp.WalletCdpKit;
import com.iap.ac.android.region.cdp.component.callback.AddFatigueActionCallback;
import com.iap.ac.android.region.cdp.component.callback.GetSpaceInfoCallback;
import com.iap.ac.android.region.cdp.ui.badge.BadgeView;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes8.dex */
public class OperationManager {
    public static void addFatigueAction(Context context, String str, String str2, String str3, AddFatigueActionCallback addFatigueActionCallback) {
        if (Utils.checkClassExist(Constants.PACKAGE_NAME_REGION_CDP)) {
            WalletCdpKit.getInstance().addFatigueAction(context, str, str2, str3, addFatigueActionCallback);
        }
    }

    public static String appendSourceInfoForUrlBySpaceCode(String str, String str2) {
        return Utils.checkClassExist(Constants.PACKAGE_NAME_REGION_CDP) ? WalletCdpKit.getInstance().appendSourceInfoForUrlBySpaceCode(str, str2) : str;
    }

    public static void attachBadgeToRightTop(View view, String str) {
        attachBadgeToRightTop(view, str, true, new Point());
    }

    public static Map<String, BadgeView> fetchBadgeViewWithCodes(Context context, List<String> list) {
        synchronized (OperationManager.class) {
            if (Utils.checkClassExist(Constants.PACKAGE_NAME_REGION_CDP)) {
                return WalletCdpKit.getInstance().fetchBadgeViewWithCodes(context, list);
            }
            return new HashMap();
        }
    }

    public static void fetchLaunchableGroupsWithCodes(List<String> list, FetchLaunchableGroupsCallback<Map<String, LaunchableGroup>> fetchLaunchableGroupsCallback) {
        d.a().fetchLaunchableGroupsWithCodes(list, fetchLaunchableGroupsCallback);
    }

    public static void getSpaceInfo(Context context, List<String> list, GetSpaceInfoCallback getSpaceInfoCallback) {
        if (Utils.checkClassExist(Constants.PACKAGE_NAME_REGION_CDP)) {
            WalletCdpKit.getInstance().getSpaceInfoMap(context, list, getSpaceInfoCallback);
        }
    }

    public static String getTrackingCodeQueryPairBySpaceCode(String str) {
        if (Utils.checkClassExist(Constants.PACKAGE_NAME_REGION_CDP)) {
            return WalletCdpKit.getInstance().getTrackingCodeQueryPairBySpaceCode(str);
        }
        return null;
    }

    public static void removeContainerWithBadgeView(View view) {
        if (Utils.checkClassExist(Constants.PACKAGE_NAME_REGION_CDP)) {
            WalletCdpKit.getInstance().removeContainerWithBadgeView(view);
        }
    }

    public static void reportClickAction(String str) {
        if (Utils.checkClassExist(Constants.PACKAGE_NAME_REGION_CDP)) {
            WalletCdpKit.getInstance().reportClickAction(str);
        }
    }

    public static void attachBadgeToRightTop(View view, String str, boolean z, Point point) {
        if (Utils.checkClassExist(Constants.PACKAGE_NAME_REGION_CDP)) {
            WalletCdpKit.getInstance().attachContainerToBadge(view, str, z, point);
        }
    }
}
