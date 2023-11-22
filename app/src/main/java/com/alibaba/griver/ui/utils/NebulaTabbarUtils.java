package com.alibaba.griver.ui.utils;

import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.service.RVConfigService;
import com.alibaba.ariver.kernel.common.utils.BundleUtils;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.griver.base.common.utils.TinyUtils;
import com.alibaba.griver.ui.tabbar.TabStateListDrawable;

/* loaded from: classes6.dex */
public class NebulaTabbarUtils {
    private static final String TAG = "H5TabbarUtils";

    public static String getAbsoluteUrl(String str, Bundle bundle) {
        int indexOf;
        String string = BundleUtils.getString(bundle, "url");
        StringBuilder sb = new StringBuilder();
        sb.append("getAbsoluteUrl useNew ");
        sb.append(true);
        RVLogger.d(TAG, sb.toString());
        String absoluteUrlWithURLLib = !TextUtils.isEmpty(string) ? TinyUtils.getAbsoluteUrlWithURLLib(string, str) : null;
        if (TextUtils.isEmpty(string) || TextUtils.isEmpty(absoluteUrlWithURLLib) || string.startsWith(absoluteUrlWithURLLib) || !neverAddHashQuery()) {
            Uri parse = Uri.parse(string);
            if (parse != null) {
                String encodedFragment = parse.getEncodedFragment();
                if (!TextUtils.isEmpty(encodedFragment) && (indexOf = encodedFragment.indexOf("?")) != -1) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(absoluteUrlWithURLLib);
                    sb2.append(encodedFragment.substring(indexOf));
                    absoluteUrlWithURLLib = sb2.toString();
                }
            }
            StringBuilder sb3 = new StringBuilder();
            sb3.append("addHashQuery : ");
            sb3.append(absoluteUrlWithURLLib);
            RVLogger.d(TAG, sb3.toString());
            return absoluteUrlWithURLLib;
        }
        return absoluteUrlWithURLLib;
    }

    private static boolean neverAddHashQuery() {
        RVConfigService rVConfigService = (RVConfigService) RVProxy.get(RVConfigService.class);
        return rVConfigService == null || !"no".equalsIgnoreCase(rVConfigService.getConfigWithProcessCache("h5_neverAddHashQuery", ""));
    }

    public static StateListDrawable generateEmptyTopDrawable() {
        return new TabStateListDrawable();
    }

    public static ColorStateList generateTextColor(int i, int i2) {
        int i3 = i2 | (-16777216);
        return new ColorStateList(new int[][]{new int[]{16842919}, new int[]{16842913}, new int[0]}, new int[]{i3, i3, i | (-16777216)});
    }

    public static void addCheckedState(StateListDrawable stateListDrawable, Drawable drawable) {
        if (!(stateListDrawable instanceof TabStateListDrawable)) {
            RVLogger.e(TAG, "tab addCheckedState invalid StateListDrawable");
        } else {
            ((TabStateListDrawable) stateListDrawable).addCheckedState(drawable);
        }
    }

    public static void addNormalState(StateListDrawable stateListDrawable, Drawable drawable) {
        if (!(stateListDrawable instanceof TabStateListDrawable)) {
            RVLogger.e(TAG, "tab addCheckedState invalid StateListDrawable");
        } else {
            ((TabStateListDrawable) stateListDrawable).addNormalState(drawable);
        }
    }
}
