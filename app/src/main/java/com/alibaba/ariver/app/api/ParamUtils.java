package com.alibaba.ariver.app.api;

import android.os.Bundle;
import android.text.TextUtils;
import com.alibaba.ariver.kernel.RVParams;
import com.alibaba.ariver.kernel.RVStartParams;
import com.alibaba.ariver.kernel.common.utils.BundleUtils;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.text.Typography;
import o.VerifyPinStateManager$executeRiskChallenge$2$1;

/* loaded from: classes2.dex */
public class ParamUtils {
    private static int $10 = 0;
    private static int $11 = 1;
    private static int KClassImpl$Data$declaredNonStaticMembers$2 = 0;
    private static int[] PlaceComponentResult = null;

    /* renamed from: a  reason: collision with root package name */
    private static Map<String, ParamImpl> f5965a = null;
    private static int getAuthRequestContext = 1;

    static void getAuthRequestContext() {
        PlaceComponentResult = new int[]{2144167753, -1917627164, -381698450, -1330982327, -26225008, -916108770, -507170179, 1515087343, -1065692199, 1530610043, 900545995, -420082650, -1143856803, 637742894, -1468573020, 395347006, -1383694450, 810275932};
    }

    static {
        try {
            getAuthRequestContext();
            f5965a = new HashMap<String, ParamImpl>() { // from class: com.alibaba.ariver.app.api.ParamUtils.1
                {
                    put("url", new ParamImpl("url", "u", RVParams.ParamType.STRING, ""));
                    put("defaultTitle", new ParamImpl("defaultTitle", RVParams.DEFAULT_TITLE, RVParams.ParamType.STRING, ""));
                    put("titleImage", new ParamImpl("titleImage", RVParams.TITLE_IMAGE, RVParams.ParamType.STRING, ""));
                    RVParams.ParamType paramType = RVParams.ParamType.BOOLEAN;
                    Boolean bool = Boolean.TRUE;
                    put("showTitleBar", new ParamImpl("showTitleBar", RVParams.SHOW_TITLEBAR, paramType, bool));
                    RVParams.ParamType paramType2 = RVParams.ParamType.BOOLEAN;
                    Boolean bool2 = Boolean.FALSE;
                    put(RVParams.LONG_SHOW_FAVORITES, new ParamImpl(RVParams.LONG_SHOW_FAVORITES, RVParams.SHOW_FAVORITES, paramType2, bool2));
                    put(RVParams.LONG_SHOW_REPORT_BTN, new ParamImpl(RVParams.LONG_SHOW_REPORT_BTN, RVParams.SHOW_REPORT_BTN, RVParams.ParamType.BOOLEAN, bool2));
                    put(RVParams.LONG_SHOW_TOOLBAR, new ParamImpl(RVParams.LONG_SHOW_TOOLBAR, RVParams.SHOW_TOOLBAR, RVParams.ParamType.BOOLEAN, bool2));
                    put("showLoading", new ParamImpl("showLoading", RVParams.SHOW_LOADING, RVParams.ParamType.BOOLEAN, bool2));
                    put(RVParams.LONG_CLOSE_BUTTON_TEXT, new ParamImpl(RVParams.LONG_CLOSE_BUTTON_TEXT, RVParams.CLOSE_BUTTON_TEXT, RVParams.ParamType.STRING, ""));
                    put(RVParams.LONG_SSO_LOGIN_ENABLE, new ParamImpl(RVParams.LONG_SSO_LOGIN_ENABLE, RVParams.SSO_LOGIN_ENABLE, RVParams.ParamType.BOOLEAN, bool));
                    put(RVParams.LONG_SAFEPAY_ENABLE, new ParamImpl(RVParams.LONG_SAFEPAY_ENABLE, RVParams.SAFEPAY_ENABLE, RVParams.ParamType.BOOLEAN, bool));
                    put(RVParams.LONG_SAFEPAY_CONTEXT, new ParamImpl(RVParams.LONG_SAFEPAY_CONTEXT, RVParams.SAFEPAY_CONTEXT, RVParams.ParamType.STRING, ""));
                    put(RVParams.LONG_READ_TITLE, new ParamImpl(RVParams.LONG_READ_TITLE, RVParams.READ_TITLE, RVParams.ParamType.BOOLEAN, bool));
                    put("bizScenario", new ParamImpl("bizScenario", RVParams.BIZ_SCENARIO, RVParams.ParamType.STRING, ""));
                    put(RVParams.LONG_ANTI_PHISHING, new ParamImpl(RVParams.LONG_ANTI_PHISHING, RVParams.ANTI_PHISHING, RVParams.ParamType.BOOLEAN, bool));
                    put(RVParams.LONG_TOOLBAR_MENU, new ParamImpl(RVParams.LONG_TOOLBAR_MENU, RVParams.TOOLBAR_MENU, RVParams.ParamType.STRING, ""));
                    put("pullRefresh", new ParamImpl("pullRefresh", RVParams.PULL_REFRESH, RVParams.ParamType.BOOLEAN, bool2));
                    put("showTitleLoading", new ParamImpl("showTitleLoading", RVParams.SHOW_TITLE_LOADING, RVParams.ParamType.BOOLEAN, bool2));
                    put("showProgress", new ParamImpl("showProgress", RVParams.SHOW_PROGRESS, RVParams.ParamType.BOOLEAN, bool2));
                    put(RVParams.LONG_SMART_TOOLBAR, new ParamImpl(RVParams.LONG_SMART_TOOLBAR, RVParams.SMART_TOOLBAR, RVParams.ParamType.BOOLEAN, bool2));
                    put(RVParams.LONG_ENABLE_PROXY, new ParamImpl(RVParams.LONG_ENABLE_PROXY, RVParams.ENABLE_PROXY, RVParams.ParamType.BOOLEAN, bool2));
                    put("canPullDown", new ParamImpl("canPullDown", RVParams.CAN_PULL_DOWN, RVParams.ParamType.BOOLEAN, bool));
                    put(RVParams.LONG_SHOW_DOMAIN, new ParamImpl(RVParams.LONG_SHOW_DOMAIN, RVParams.SHOW_DOMAIN, RVParams.ParamType.BOOLEAN, bool));
                    put(RVParams.LONG_PREFETCH_LOCATION, new ParamImpl(RVParams.LONG_PREFETCH_LOCATION, RVParams.PREFETCH_LOCATION, RVParams.ParamType.BOOLEAN, bool2));
                    put("showOptionMenu", new ParamImpl("showOptionMenu", RVParams.SHOW_OPTION_MENU, RVParams.ParamType.BOOLEAN, bool));
                    put("backgroundColor", new ParamImpl("backgroundColor", RVParams.BACKGROUND_COLOR, RVParams.ParamType.INT, -1));
                    put(RVParams.LONG_INTERCEPT_JUMP, new ParamImpl(RVParams.LONG_INTERCEPT_JUMP, RVParams.INTERCEPT_JUMP, RVParams.ParamType.BOOLEAN, bool));
                    put(RVParams.LONG_CLOSE_AFTER_PAY_FINISH, new ParamImpl(RVParams.LONG_CLOSE_AFTER_PAY_FINISH, RVParams.CLOSE_AFTER_PAY_FINISH, RVParams.ParamType.BOOLEAN, bool));
                    put(RVStartParams.KEY_TRANSPARENT, new ParamImpl(RVStartParams.KEY_TRANSPARENT, RVParams.TRANSPARENT, RVParams.ParamType.BOOLEAN, bool2));
                    put("fullscreen", new ParamImpl("fullscreen", RVStartParams.KEY_FULLSCREEN_SHORT, RVParams.ParamType.BOOLEAN, bool2));
                    put("landscape", new ParamImpl("landscape", RVStartParams.KEY_LANDSCAPE_SHORT, RVParams.ParamType.STRING, ""));
                    put(RVParams.LONG_ENABLE_SCROLLBAR, new ParamImpl(RVParams.LONG_ENABLE_SCROLLBAR, RVParams.ENABLE_SCROLLBAR, RVParams.ParamType.BOOLEAN, bool));
                    put(RVParams.LONG_DELAY_RENDER, new ParamImpl(RVParams.LONG_DELAY_RENDER, RVParams.DELAY_RENDER, RVParams.ParamType.BOOLEAN, bool2));
                    put(RVParams.LONG_CAN_DESTROY, new ParamImpl(RVParams.LONG_CAN_DESTROY, RVParams.CAN_DESTROY, RVParams.ParamType.BOOLEAN, bool2));
                    put("transparentTitle", new ParamImpl("transparentTitle", RVParams.TRANSPARENT_TITLE, RVParams.ParamType.STRING, ""));
                    put(RVParams.LONG_TITLE_SCROLLDISTANCE, new ParamImpl(RVParams.LONG_TITLE_SCROLLDISTANCE, RVParams.TITLE_SCROLLDISTANCE, RVParams.ParamType.INT, 255));
                    put(RVParams.LONG_BOUNCE_TOP_COLOR, new ParamImpl(RVParams.LONG_BOUNCE_TOP_COLOR, RVParams.BOUNCE_TOP_COLOR, true, RVParams.ParamType.INT, Integer.valueOf((int) RVParams.DEFAULT_LONG_BOUNCE_TOP_COLOR)));
                    put(RVParams.LONG_ALLOWS_BOUNCE_VERTICAL, new ParamImpl(RVParams.LONG_ALLOWS_BOUNCE_VERTICAL, RVParams.ALLOWS_BOUNCE_VERTICAL, RVParams.ParamType.STRING, ""));
                    put(RVStartParams.LONG_NB_UPDATE, new ParamImpl(RVStartParams.LONG_NB_UPDATE, RVParams.NB_UPDATE, RVParams.ParamType.STRING, "async"));
                    put(RVStartParams.LONG_NB_OFFLINE, new ParamImpl(RVStartParams.LONG_NB_OFFLINE, RVParams.NB_OFFLINE, RVParams.ParamType.STRING, "async"));
                    put(RVStartParams.LONG_NB_URL, new ParamImpl(RVStartParams.LONG_NB_URL, RVParams.NB_URL, RVParams.ParamType.STRING, ""));
                    put(RVParams.LONG_OB_VERSION, new ParamImpl(RVParams.LONG_OB_VERSION, RVParams.OB_VERSION, RVParams.ParamType.STRING, ""));
                    put(RVStartParams.LONG_NB_VERSION, new ParamImpl(RVStartParams.LONG_NB_VERSION, RVParams.NB_VERSION, RVParams.ParamType.STRING, ""));
                    put("navSearchBar_type", new ParamImpl("navSearchBar_type", RVParams.NAV_SEARCH_BAR_TYPE, RVParams.ParamType.STRING, ""));
                    put(RVParams.LONG_NAV_SEARCH_BAR_PLACEHOLDER, new ParamImpl(RVParams.LONG_NAV_SEARCH_BAR_PLACEHOLDER, RVParams.NAV_SEARCH_BAR_PLACEHOLDER, RVParams.ParamType.STRING, ""));
                    put(RVParams.LONG_NAV_SEARCH_BAR_VALUE, new ParamImpl(RVParams.LONG_NAV_SEARCH_BAR_VALUE, RVParams.NAV_SEARCH_BAR_VALUE, RVParams.ParamType.STRING, ""));
                    put(RVParams.LONG_NAV_SEARCH_BAR_MAX_LENGTH, new ParamImpl(RVParams.LONG_NAV_SEARCH_BAR_MAX_LENGTH, RVParams.NAV_SEARCH_BAR_MAX_LENGTH, RVParams.ParamType.INT, 0));
                    put(RVParams.LONG_NAV_SEARCH_BAR_SEARCH_PLACEHOLDER, new ParamImpl(RVParams.LONG_NAV_SEARCH_BAR_SEARCH_PLACEHOLDER, RVParams.NAV_SEARCH_BAR_SEARCH_PLACEHOLDER, RVParams.ParamType.BOOLEAN, bool2));
                    put("backBtnImage", new ParamImpl("backBtnImage", RVParams.BACKBTN_IMAGE, RVParams.ParamType.STRING, "default"));
                    put(RVParams.LONG_BACKBTN_TEXTCOLOR, new ParamImpl(RVParams.LONG_BACKBTN_TEXTCOLOR, RVParams.BACKBTN_TEXTCOLOR, RVParams.ParamType.INT, -16777216));
                    put("titleColor", new ParamImpl("titleColor", RVParams.TITLE_COLOR, RVParams.ParamType.INT, -16777216));
                    put(RVParams.LONG_TRANSPARENT_TITLE_TEXTAUTO, new ParamImpl(RVParams.LONG_TRANSPARENT_TITLE_TEXTAUTO, RVParams.TRANSPARENT_TITLE_TEXTAUTO, RVParams.ParamType.STRING, "NO"));
                    put(RVParams.LONG_PRESSO_LOGIN, new ParamImpl(RVParams.LONG_PRESSO_LOGIN, RVParams.PRESSO_LOGIN, RVParams.ParamType.STRING, "YES"));
                    put(RVParams.LONG_PRESSO_LOGIN_BINDINGPAGE, new ParamImpl(RVParams.LONG_PRESSO_LOGIN_BINDINGPAGE, RVParams.PRESSO_LOGIN_BINDINGPAGE, RVParams.ParamType.STRING, ""));
                    put(RVParams.LONG_PRESSO_LOGIN_URL, new ParamImpl(RVParams.LONG_PRESSO_LOGIN_URL, RVParams.PRESSO_LOGIN_URL, RVParams.ParamType.STRING, ""));
                    put("tabBarJson", new ParamImpl("tabBarJson", "tabBarJson", RVParams.ParamType.STRING, ""));
                    put("enableTabBar", new ParamImpl("enableTabBar", "enableTabBar", RVParams.ParamType.STRING, "default"));
                    put("tabItemCount", new ParamImpl("tabItemCount", "tabItemCount", RVParams.ParamType.INT, -1));
                    put("titleBarColor", new ParamImpl("titleBarColor", "titleBarColor", RVParams.ParamType.INT, null));
                    put("preventAutoLoginLoop", new ParamImpl("preventAutoLoginLoop", "preventAutoLoginLoop", RVParams.ParamType.BOOLEAN, bool2));
                    put(RVStartParams.KEY_TRANS_ANIMATE, new ParamImpl(RVStartParams.KEY_TRANS_ANIMATE, RVParams.TRANS_ANIMATE, RVParams.ParamType.BOOLEAN, bool2));
                    put(RVParams.LONG_NB_OFFMODE, new ParamImpl(RVParams.LONG_NB_OFFMODE, RVParams.NB_OFFMODE, RVParams.ParamType.STRING, "force"));
                    put("openUrlMethod", new ParamImpl("openUrlMethod", "openUrlMethod", RVParams.ParamType.STRING, "GET"));
                    put("openUrlPostParams", new ParamImpl("openUrlPostParams", "openUrlPostParams", RVParams.ParamType.STRING, ""));
                    put(RVParams.LONG_SHARETOKENPARAMS, new ParamImpl(RVParams.LONG_SHARETOKENPARAMS, RVParams.SHARETOKENPARAMS, RVParams.ParamType.STRING, ""));
                }
            };
            int i = getAuthRequestContext + 99;
            KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
            int i2 = i % 2;
        } catch (Exception e) {
            throw e;
        }
    }

    private static void a(Bundle bundle) {
        int i = KClassImpl$Data$declaredNonStaticMembers$2 + 113;
        getAuthRequestContext = i % 128;
        int i2 = i % 2;
        String string = BundleUtils.getString(bundle, RVParams.TRANSPARENT);
        if ((TextUtils.isEmpty(string) ? 'W' : 'E') == 'W') {
            string = BundleUtils.getString(bundle, RVStartParams.KEY_TRANSPARENT);
            int i3 = getAuthRequestContext + 45;
            KClassImpl$Data$declaredNonStaticMembers$2 = i3 % 128;
            int i4 = i3 % 2;
        }
        if (!(!TextUtils.isEmpty(string)) && (BundleUtils.getBoolean(bundle, RVStartParams.KEY_TRANSPARENT, false) || BundleUtils.getBoolean(bundle, RVParams.TRANSPARENT, false))) {
            string = "YES";
        }
        if ((!"YES".equalsIgnoreCase(string) ? ':' : (char) 5) == 5 || "TRUE".equalsIgnoreCase(string)) {
            bundle.remove(RVParams.SHOW_TITLEBAR);
            bundle.remove("showTitleBar");
            bundle.remove(RVParams.SHOW_TOOLBAR);
            bundle.remove(RVParams.LONG_SHOW_TOOLBAR);
            bundle.remove(RVParams.SHOW_PROGRESS);
            bundle.remove("showProgress");
            bundle.remove(RVParams.SHOW_DOMAIN);
            bundle.remove(RVParams.LONG_SHOW_DOMAIN);
            bundle.remove(RVParams.CAN_PULL_DOWN);
            bundle.remove("canPullDown");
            bundle.remove(RVParams.ALLOWS_BOUNCE_VERTICAL);
            bundle.remove(RVParams.LONG_ALLOWS_BOUNCE_VERTICAL);
            bundle.putString(RVParams.SHOW_TITLEBAR, "NO");
            bundle.putString("showTitleBar", "NO");
            bundle.putString(RVParams.SHOW_TOOLBAR, "NO");
            bundle.putString(RVParams.LONG_SHOW_TOOLBAR, "NO");
            bundle.putString(RVParams.SHOW_PROGRESS, "NO");
            bundle.putString("showProgress", "NO");
            bundle.putString(RVParams.SHOW_DOMAIN, "NO");
            bundle.putString(RVParams.LONG_SHOW_DOMAIN, "NO");
            bundle.putString(RVParams.CAN_PULL_DOWN, "NO");
            bundle.putString("canPullDown", "NO");
            bundle.putString(RVParams.ALLOWS_BOUNCE_VERTICAL, "NO");
            bundle.putString(RVParams.LONG_ALLOWS_BOUNCE_VERTICAL, "NO");
            if (bundle.containsKey("backgroundColor")) {
                return;
            }
            if (bundle.containsKey(RVParams.BACKGROUND_COLOR)) {
                return;
            }
            String string2 = BundleUtils.getString(bundle, "fullscreen");
            if (BundleUtils.getBoolean(bundle, "fullscreen", false)) {
                return;
            }
            if ((!TextUtils.isEmpty(string2) ? 'L' : '*') == 'L') {
                if (!(string2.equals("YES") ? false : true)) {
                    return;
                }
            }
            String string3 = BundleUtils.getString(bundle, RVStartParams.KEY_TRANS_ANIMATE);
            boolean z = BundleUtils.getBoolean(bundle, RVStartParams.KEY_TRANS_ANIMATE, false);
            if ((!TextUtils.isEmpty(string3) && "YES".equals(string3)) || z) {
                bundle.putInt(RVParams.BACKGROUND_COLOR, -1291845632);
                bundle.putInt("backgroundColor", -1291845632);
                return;
            }
            bundle.putInt(RVParams.BACKGROUND_COLOR, 855638016);
            bundle.putInt("backgroundColor", 855638016);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0024, code lost:
    
        if ((r0 ? false : true) != false) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0034, code lost:
    
        if ((com.alibaba.ariver.app.api.ParamUtils.f5965a.containsKey(r6) ? false : true) != true) goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0042, code lost:
    
        return com.alibaba.ariver.app.api.ParamUtils.f5965a.get(r6).unify(r5, r7);
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0044, code lost:
    
        r6 = com.alibaba.ariver.app.api.ParamUtils.getAuthRequestContext + 85;
        com.alibaba.ariver.app.api.ParamUtils.KClassImpl$Data$declaredNonStaticMembers$2 = r6 % 128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x004e, code lost:
    
        if ((r6 % 2) == 0) goto L31;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0050, code lost:
    
        r6 = r3.length;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0051, code lost:
    
        return r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0054, code lost:
    
        return r5;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static android.os.Bundle unify(android.os.Bundle r5, java.lang.String r6, boolean r7) {
        /*
            int r0 = com.alibaba.ariver.app.api.ParamUtils.getAuthRequestContext
            int r0 = r0 + 27
            int r1 = r0 % 128
            com.alibaba.ariver.app.api.ParamUtils.KClassImpl$Data$declaredNonStaticMembers$2 = r1
            int r0 = r0 % 2
            r1 = 52
            if (r0 == 0) goto L11
            r0 = 30
            goto L13
        L11:
            r0 = 52
        L13:
            r2 = 0
            r3 = 0
            r4 = 1
            if (r0 == r1) goto L2b
            java.util.Map<java.lang.String, com.alibaba.ariver.app.api.ParamImpl> r0 = com.alibaba.ariver.app.api.ParamUtils.f5965a     // Catch: java.lang.Exception -> L29
            boolean r0 = r0.containsKey(r6)     // Catch: java.lang.Exception -> L29
            r3.hashCode()     // Catch: java.lang.Throwable -> L27
            if (r0 != 0) goto L24
            r2 = 1
        L24:
            if (r2 == 0) goto L36
            goto L44
        L27:
            r5 = move-exception
            throw r5
        L29:
            r5 = move-exception
            goto L43
        L2b:
            java.util.Map<java.lang.String, com.alibaba.ariver.app.api.ParamImpl> r0 = com.alibaba.ariver.app.api.ParamUtils.f5965a
            boolean r0 = r0.containsKey(r6)
            if (r0 != 0) goto L34
            r2 = 1
        L34:
            if (r2 == r4) goto L44
        L36:
            java.util.Map<java.lang.String, com.alibaba.ariver.app.api.ParamImpl> r0 = com.alibaba.ariver.app.api.ParamUtils.f5965a     // Catch: java.lang.Exception -> L29
            java.lang.Object r6 = r0.get(r6)     // Catch: java.lang.Exception -> L29
            com.alibaba.ariver.app.api.ParamImpl r6 = (com.alibaba.ariver.app.api.ParamImpl) r6     // Catch: java.lang.Exception -> L29
            android.os.Bundle r5 = r6.unify(r5, r7)     // Catch: java.lang.Exception -> L29
            return r5
        L43:
            throw r5
        L44:
            int r6 = com.alibaba.ariver.app.api.ParamUtils.getAuthRequestContext
            int r6 = r6 + 85
            int r7 = r6 % 128
            com.alibaba.ariver.app.api.ParamUtils.KClassImpl$Data$declaredNonStaticMembers$2 = r7
            int r6 = r6 % 2
            if (r6 == 0) goto L54
            int r6 = r3.length     // Catch: java.lang.Throwable -> L52
            return r5
        L52:
            r5 = move-exception
            throw r5
        L54:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.ariver.app.api.ParamUtils.unify(android.os.Bundle, java.lang.String, boolean):android.os.Bundle");
    }

    public static Bundle unifyAll(Bundle bundle, boolean z) {
        int i = KClassImpl$Data$declaredNonStaticMembers$2 + 99;
        getAuthRequestContext = i % 128;
        int i2 = i % 2;
        Object obj = null;
        if (bundle == null) {
            return null;
        }
        a(bundle);
        f5965a.get("showProgress").setDefaultValue(Boolean.valueOf("20000067".equals(BundleUtils.getString(bundle, "appId"))));
        if (z) {
            int i3 = getAuthRequestContext + 57;
            KClassImpl$Data$declaredNonStaticMembers$2 = i3 % 128;
            if (i3 % 2 != 0) {
                b(bundle);
                obj.hashCode();
            } else {
                b(bundle);
            }
        }
        try {
            Iterator<String> it = f5965a.keySet().iterator();
            while (it.hasNext()) {
                bundle = f5965a.get(it.next()).unify(bundle, z);
            }
            try {
                String string = BundleUtils.getString(bundle, RVParams.LONG_ALLOWS_BOUNCE_VERTICAL, "");
                StringBuilder sb = new StringBuilder();
                sb.append("merge LONG_ALLOWS_BOUNCE_VERTICAL & LONG_CAN_PULL_DOWN ");
                sb.append(string);
                RVLogger.d("AriverApp.ParamUtils", sb.toString());
                if (!TextUtils.isEmpty(string)) {
                    if (("YES".equals(string) ? ']' : (char) 28) != 28) {
                        bundle.putBoolean("canPullDown", true);
                    } else if ("NO".equals(string)) {
                        bundle.putBoolean("canPullDown", false);
                    }
                }
                int i4 = BundleUtils.getInt(bundle, "tabItemCount", -1);
                String string2 = BundleUtils.getString(bundle, "enableTabBar", "default");
                StringBuilder sb2 = new StringBuilder();
                sb2.append("tabItemCount ");
                sb2.append(i4);
                sb2.append(", enableTabBar ");
                sb2.append(string2);
                RVLogger.d("AriverApp.ParamUtils", sb2.toString());
                if (TextUtils.equals("default", string2)) {
                    if ((i4 != -1 ? Typography.quote : 'C') != 'C') {
                        bundle.putString("enableTabBar", "YES");
                    }
                } else {
                    if ((TextUtils.equals("YES", string2)) && i4 == -1) {
                        int i5 = KClassImpl$Data$declaredNonStaticMembers$2 + 121;
                        getAuthRequestContext = i5 % 128;
                        int i6 = i5 % 2;
                        bundle.putInt("tabItemCount", 4);
                    }
                }
                if ((bundle.containsKey(RVParams.LONG_SHOW_THIRDDISCLAIMER) ? Typography.greater : 'a') != 'a') {
                    RVLogger.d("AriverApp.ParamUtils", "parse contains LONG_SHOW_THIRDDISCLAIMER force set true");
                    bundle.remove(RVParams.LONG_SHOW_THIRDDISCLAIMER);
                    bundle.putBoolean(RVParams.LONG_SHOW_THIRDDISCLAIMER, true);
                }
                return bundle;
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    private static void b(Bundle bundle) {
        int i = getAuthRequestContext + 17;
        KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
        int i2 = i % 2;
        if (!(bundle.containsKey("showOptionMenu"))) {
            try {
                int i3 = getAuthRequestContext + 77;
                KClassImpl$Data$declaredNonStaticMembers$2 = i3 % 128;
                if ((i3 % 2 != 0 ? '/' : 'C') != 'C') {
                    boolean containsKey = bundle.containsKey(RVParams.SHOW_OPTION_MENU);
                    Object[] objArr = null;
                    int length = objArr.length;
                    if (containsKey) {
                        return;
                    }
                } else if (bundle.containsKey(RVParams.SHOW_OPTION_MENU)) {
                    return;
                }
                boolean z = BundleUtils.getBoolean(bundle, RVParams.isH5App, false);
                StringBuilder sb = new StringBuilder();
                sb.append("pre-fill set showOptionMenu as ");
                boolean z2 = !z;
                sb.append(z2);
                RVLogger.d("AriverApp.ParamUtils", sb.toString());
                bundle.putBoolean("showOptionMenu", z2);
            } catch (Exception e) {
                throw e;
            }
        }
    }

    public static void filterCreatePageParams(Bundle bundle) {
        try {
            int i = KClassImpl$Data$declaredNonStaticMembers$2 + 21;
            getAuthRequestContext = i % 128;
            int i2 = i % 2;
            bundle.remove("url");
            bundle.remove("MINI-PROGRAM-WEB-VIEW-TAG");
            RVLogger.d("AriverApp.ParamUtils", "in H5SessionPlugin delete preRpc startparam");
            bundle.remove("preRpc");
            bundle.remove("navSearchBar_type");
            bundle.remove(RVStartParams.KEY_FRAGMENT_TYPE);
            bundle.remove(RVStartParams.KEY_FROM_RELAUNCH);
            bundle.remove("backgroundColor");
            bundle.remove("transparentTitle");
            bundle.remove(RVParams.LONG_TRANSPARENT_TITLE_TEXTAUTO);
            RVLogger.d("AriverApp.ParamUtils", "in H5SessionPlugin delete titleImage startparam");
            bundle.remove("titleImage");
            bundle.remove(RVParams.LONG_BOUNCE_TOP_COLOR);
            bundle.remove("closeAllWindow");
            bundle.remove(RVParams.DISABLE_PAGE_ROUTE);
            try {
                int i3 = KClassImpl$Data$declaredNonStaticMembers$2 + 99;
                getAuthRequestContext = i3 % 128;
                if (i3 % 2 == 0) {
                    Object obj = null;
                    obj.hashCode();
                }
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    public static void processTransparent(Bundle bundle) {
        if (!(BundleUtils.getBoolean(bundle, RVStartParams.KEY_TRANSPARENT, false))) {
            int i = BundleUtils.getInt(bundle, "backgroundColor", -16777216);
            if (!(i != -16777216)) {
                return;
            }
            int i2 = getAuthRequestContext + 73;
            KClassImpl$Data$declaredNonStaticMembers$2 = i2 % 128;
            bundle.putInt("backgroundColor", i2 % 2 != 0 ? i ^ (-16777216) : i | (-16777216));
            int i3 = KClassImpl$Data$declaredNonStaticMembers$2 + 103;
            getAuthRequestContext = i3 % 128;
            int i4 = i3 % 2;
        }
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Unreachable block: B:27:0x0046
        	at jadx.core.dex.visitors.blocks.BlockProcessor.checkForUnreachableBlocks(BlockProcessor.java:86)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:52)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:44)
        */
    public static boolean isShowTransAnimate(android.os.Bundle r3) {
        /*
            r0 = 0
            java.lang.String r1 = "transparent"
            boolean r1 = com.alibaba.ariver.kernel.common.utils.BundleUtils.getBoolean(r3, r1, r0)
            r2 = 92
            if (r1 == 0) goto Le
            r1 = 92
            goto L10
        Le:
            r1 = 42
        L10:
            if (r1 == r2) goto L13
            goto L24
        L13:
            java.lang.String r1 = "transAnimate"
            boolean r3 = com.alibaba.ariver.kernel.common.utils.BundleUtils.getBoolean(r3, r1, r0)     // Catch: java.lang.Exception -> L44
            r1 = 67
            if (r3 == 0) goto L20
            r3 = 67
            goto L22
        L20:
            r3 = 44
        L22:
            if (r3 == r1) goto L38
        L24:
            int r3 = com.alibaba.ariver.app.api.ParamUtils.KClassImpl$Data$declaredNonStaticMembers$2
            int r3 = r3 + 99
            int r1 = r3 % 128
            com.alibaba.ariver.app.api.ParamUtils.getAuthRequestContext = r1
            int r3 = r3 % 2
            if (r3 != 0) goto L37
            r3 = 0
            r3.hashCode()     // Catch: java.lang.Throwable -> L35
            return r0
        L35:
            r3 = move-exception
            throw r3
        L37:
            return r0
        L38:
            int r3 = com.alibaba.ariver.app.api.ParamUtils.KClassImpl$Data$declaredNonStaticMembers$2
            int r3 = r3 + 25
            int r0 = r3 % 128
            com.alibaba.ariver.app.api.ParamUtils.getAuthRequestContext = r0
            int r3 = r3 % 2
            r3 = 1
            return r3
        L44:
            r3 = move-exception
            throw r3
        L46:
            r3 = move-exception
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.ariver.app.api.ParamUtils.isShowTransAnimate(android.os.Bundle):boolean");
    }

    public static boolean transparentBackground(Bundle bundle) {
        int i = getAuthRequestContext + 47;
        KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
        int i2 = i % 2;
        boolean z = !TextUtils.isEmpty(BundleUtils.getString(bundle, RVStartParams.KEY_BACKGROUND_IMAGE_URL));
        int i3 = getAuthRequestContext + 5;
        KClassImpl$Data$declaredNonStaticMembers$2 = i3 % 128;
        if (i3 % 2 != 0) {
            Object[] objArr = null;
            int length = objArr.length;
            return z;
        }
        return z;
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0026, code lost:
    
        if ((android.text.TextUtils.isEmpty(r7) ? 'Z' : 21) != 21) goto L15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0028, code lost:
    
        return null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0029, code lost:
    
        r0 = com.alibaba.ariver.app.api.ParamUtils.f5965a.get(r7);
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0032, code lost:
    
        if (r0 == null) goto L26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0034, code lost:
    
        r7 = com.alibaba.ariver.app.api.ParamUtils.KClassImpl$Data$declaredNonStaticMembers$2 + 87;
        com.alibaba.ariver.app.api.ParamUtils.getAuthRequestContext = r7 % 128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x003e, code lost:
    
        if ((r7 % 2) != 0) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0042, code lost:
    
        r7 = 62 / 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0046, code lost:
    
        return r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0047, code lost:
    
        r0 = com.alibaba.ariver.app.api.ParamUtils.f5965a.keySet().iterator();
        r3 = com.alibaba.ariver.app.api.ParamUtils.KClassImpl$Data$declaredNonStaticMembers$2 + 7;
        com.alibaba.ariver.app.api.ParamUtils.getAuthRequestContext = r3 % 128;
        r3 = r3 % 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x005b, code lost:
    
        r4 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0060, code lost:
    
        if (r0.hasNext() == false) goto L30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0062, code lost:
    
        r3 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0064, code lost:
    
        r3 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0065, code lost:
    
        if (r3 == false) goto L66;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0067, code lost:
    
        r3 = com.alibaba.ariver.app.api.ParamUtils.KClassImpl$Data$declaredNonStaticMembers$2 + 59;
        com.alibaba.ariver.app.api.ParamUtils.getAuthRequestContext = r3 % 128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0071, code lost:
    
        if ((r3 % 2) != 0) goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0073, code lost:
    
        r3 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0075, code lost:
    
        r3 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x0076, code lost:
    
        if (r3 == true) goto L64;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x0078, code lost:
    
        r3 = com.alibaba.ariver.app.api.ParamUtils.f5965a.get(r0.next());
        r5 = r3.getLongName();
        r6 = r3.getShortName();
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x0092, code lost:
    
        if (r7.equals(r5) != false) goto L40;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x0094, code lost:
    
        r4 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x0095, code lost:
    
        if (r4 == false) goto L46;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x009c, code lost:
    
        r3 = com.alibaba.ariver.app.api.ParamUtils.f5965a.get(r0.next());
        r4 = r3.getLongName();
        r6 = r3.getShortName();
        r4 = r7.equals(r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x00b2, code lost:
    
        r1.hashCode();
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x00b5, code lost:
    
        if (r4 != false) goto L68;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x00bb, code lost:
    
        if (r7.equals(r6) == false) goto L70;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x00bd, code lost:
    
        return r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x00c0, code lost:
    
        r7 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x00c1, code lost:
    
        throw r7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x00c2, code lost:
    
        r7 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x00c3, code lost:
    
        throw r7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x00c4, code lost:
    
        return null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:6:0x0014, code lost:
    
        if (r0 != false) goto L15;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static com.alibaba.ariver.app.api.ParamImpl a(java.lang.String r7) {
        /*
            int r0 = com.alibaba.ariver.app.api.ParamUtils.KClassImpl$Data$declaredNonStaticMembers$2
            int r0 = r0 + 29
            int r1 = r0 % 128
            com.alibaba.ariver.app.api.ParamUtils.getAuthRequestContext = r1
            int r0 = r0 % 2
            r1 = 0
            if (r0 != 0) goto L19
            boolean r0 = android.text.TextUtils.isEmpty(r7)
            r1.hashCode()     // Catch: java.lang.Throwable -> L17
            if (r0 == 0) goto L29
            goto L28
        L17:
            r7 = move-exception
            throw r7
        L19:
            boolean r0 = android.text.TextUtils.isEmpty(r7)
            r2 = 21
            if (r0 == 0) goto L24
            r0 = 90
            goto L26
        L24:
            r0 = 21
        L26:
            if (r0 == r2) goto L29
        L28:
            return r1
        L29:
            java.util.Map<java.lang.String, com.alibaba.ariver.app.api.ParamImpl> r0 = com.alibaba.ariver.app.api.ParamUtils.f5965a
            java.lang.Object r0 = r0.get(r7)
            com.alibaba.ariver.app.api.ParamImpl r0 = (com.alibaba.ariver.app.api.ParamImpl) r0
            r2 = 0
            if (r0 == 0) goto L47
            int r7 = com.alibaba.ariver.app.api.ParamUtils.KClassImpl$Data$declaredNonStaticMembers$2
            int r7 = r7 + 87
            int r1 = r7 % 128
            com.alibaba.ariver.app.api.ParamUtils.getAuthRequestContext = r1
            int r7 = r7 % 2
            if (r7 != 0) goto L46
            r7 = 62
            int r7 = r7 / r2
            goto L46
        L44:
            r7 = move-exception
            throw r7
        L46:
            return r0
        L47:
            java.util.Map<java.lang.String, com.alibaba.ariver.app.api.ParamImpl> r0 = com.alibaba.ariver.app.api.ParamUtils.f5965a
            java.util.Set r0 = r0.keySet()
            java.util.Iterator r0 = r0.iterator()
            int r3 = com.alibaba.ariver.app.api.ParamUtils.KClassImpl$Data$declaredNonStaticMembers$2
            int r3 = r3 + 7
            int r4 = r3 % 128
            com.alibaba.ariver.app.api.ParamUtils.getAuthRequestContext = r4
            int r3 = r3 % 2
        L5b:
            boolean r3 = r0.hasNext()
            r4 = 1
            if (r3 == 0) goto L64
            r3 = 1
            goto L65
        L64:
            r3 = 0
        L65:
            if (r3 == 0) goto Lc4
            int r3 = com.alibaba.ariver.app.api.ParamUtils.KClassImpl$Data$declaredNonStaticMembers$2
            int r3 = r3 + 59
            int r5 = r3 % 128
            com.alibaba.ariver.app.api.ParamUtils.getAuthRequestContext = r5
            int r3 = r3 % 2
            if (r3 != 0) goto L75
            r3 = 1
            goto L76
        L75:
            r3 = 0
        L76:
            if (r3 == r4) goto L98
            java.lang.Object r3 = r0.next()
            java.lang.String r3 = (java.lang.String) r3
            java.util.Map<java.lang.String, com.alibaba.ariver.app.api.ParamImpl> r5 = com.alibaba.ariver.app.api.ParamUtils.f5965a
            java.lang.Object r3 = r5.get(r3)
            com.alibaba.ariver.app.api.ParamImpl r3 = (com.alibaba.ariver.app.api.ParamImpl) r3
            java.lang.String r5 = r3.getLongName()
            java.lang.String r6 = r3.getShortName()
            boolean r5 = r7.equals(r5)
            if (r5 != 0) goto L95
            r4 = 0
        L95:
            if (r4 == 0) goto Lb7
            goto Lbd
        L98:
            java.lang.Object r3 = r0.next()     // Catch: java.lang.Exception -> Lc2
            java.lang.String r3 = (java.lang.String) r3     // Catch: java.lang.Exception -> Lc0
            java.util.Map<java.lang.String, com.alibaba.ariver.app.api.ParamImpl> r4 = com.alibaba.ariver.app.api.ParamUtils.f5965a     // Catch: java.lang.Exception -> Lc0
            java.lang.Object r3 = r4.get(r3)     // Catch: java.lang.Exception -> Lc0
            com.alibaba.ariver.app.api.ParamImpl r3 = (com.alibaba.ariver.app.api.ParamImpl) r3     // Catch: java.lang.Exception -> Lc0
            java.lang.String r4 = r3.getLongName()     // Catch: java.lang.Exception -> Lc0
            java.lang.String r6 = r3.getShortName()     // Catch: java.lang.Exception -> Lc0
            boolean r4 = r7.equals(r4)     // Catch: java.lang.Exception -> Lc0
            r1.hashCode()     // Catch: java.lang.Throwable -> Lbe
            if (r4 != 0) goto Lbd
        Lb7:
            boolean r4 = r7.equals(r6)
            if (r4 == 0) goto L5b
        Lbd:
            return r3
        Lbe:
            r7 = move-exception
            throw r7
        Lc0:
            r7 = move-exception
            throw r7
        Lc2:
            r7 = move-exception
            throw r7
        Lc4:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.ariver.app.api.ParamUtils.a(java.lang.String):com.alibaba.ariver.app.api.ParamImpl");
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x001d, code lost:
    
        if (r0 == false) goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x002b, code lost:
    
        if ((!android.text.TextUtils.isEmpty(r4)) != true) goto L34;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x002e, code lost:
    
        r4 = a(r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0032, code lost:
    
        if (r4 == null) goto L34;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0034, code lost:
    
        r0 = com.alibaba.ariver.app.api.ParamUtils.KClassImpl$Data$declaredNonStaticMembers$2 + 13;
        com.alibaba.ariver.app.api.ParamUtils.getAuthRequestContext = r0 % 128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x003e, code lost:
    
        if ((r0 % 2) != 0) goto L31;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0040, code lost:
    
        r3.remove(r4.getLongName());
        r3.remove(r4.getShortName());
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x004e, code lost:
    
        r3 = r2.length;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0052, code lost:
    
        r3.remove(r4.getLongName());
        r3.remove(r4.getShortName());
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void remove(android.os.Bundle r3, java.lang.String r4) {
        /*
            r0 = 75
            r1 = 1
            if (r3 == 0) goto L7
            r2 = 1
            goto L9
        L7:
            r2 = 75
        L9:
            if (r2 == r0) goto L63
            int r0 = com.alibaba.ariver.app.api.ParamUtils.getAuthRequestContext     // Catch: java.lang.Exception -> L61
            int r0 = r0 + 33
            int r2 = r0 % 128
            com.alibaba.ariver.app.api.ParamUtils.KClassImpl$Data$declaredNonStaticMembers$2 = r2     // Catch: java.lang.Exception -> L61
            int r0 = r0 % 2
            r2 = 0
            if (r0 == 0) goto L22
            boolean r0 = android.text.TextUtils.isEmpty(r4)
            int r1 = r2.length     // Catch: java.lang.Throwable -> L20
            if (r0 != 0) goto L63
            goto L2e
        L20:
            r3 = move-exception
            throw r3
        L22:
            boolean r0 = android.text.TextUtils.isEmpty(r4)
            if (r0 != 0) goto L2a
            r0 = 1
            goto L2b
        L2a:
            r0 = 0
        L2b:
            if (r0 == r1) goto L2e
            goto L63
        L2e:
            com.alibaba.ariver.app.api.ParamImpl r4 = a(r4)
            if (r4 == 0) goto L63
            int r0 = com.alibaba.ariver.app.api.ParamUtils.KClassImpl$Data$declaredNonStaticMembers$2
            int r0 = r0 + 13
            int r1 = r0 % 128
            com.alibaba.ariver.app.api.ParamUtils.getAuthRequestContext = r1
            int r0 = r0 % 2
            if (r0 != 0) goto L52
            java.lang.String r0 = r4.getLongName()     // Catch: java.lang.Exception -> L61
            r3.remove(r0)     // Catch: java.lang.Exception -> L61
            java.lang.String r4 = r4.getShortName()     // Catch: java.lang.Exception -> L61
            r3.remove(r4)     // Catch: java.lang.Exception -> L61
            int r3 = r2.length     // Catch: java.lang.Throwable -> L50
            goto L63
        L50:
            r3 = move-exception
            throw r3
        L52:
            java.lang.String r0 = r4.getLongName()
            r3.remove(r0)
            java.lang.String r4 = r4.getShortName()
            r3.remove(r4)
            goto L63
        L61:
            r3 = move-exception
            throw r3
        L63:
            int r3 = com.alibaba.ariver.app.api.ParamUtils.KClassImpl$Data$declaredNonStaticMembers$2
            int r3 = r3 + 21
            int r4 = r3 % 128
            com.alibaba.ariver.app.api.ParamUtils.getAuthRequestContext = r4
            int r3 = r3 % 2
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.ariver.app.api.ParamUtils.remove(android.os.Bundle, java.lang.String):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0020, code lost:
    
        if (android.text.TextUtils.isEmpty(r18) != false) goto L13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0022, code lost:
    
        r0 = com.alibaba.ariver.app.api.ParamUtils.KClassImpl$Data$declaredNonStaticMembers$2 + 23;
        com.alibaba.ariver.app.api.ParamUtils.getAuthRequestContext = r0 % 128;
        r0 = r0 % 2;
        com.alibaba.ariver.kernel.common.utils.RVLogger.w("AriverApp.ParamUtils", "no url found in magic parameter");
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0030, code lost:
    
        return null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0031, code lost:
    
        r0 = com.alibaba.ariver.kernel.common.utils.UrlUtils.getParam(com.alibaba.ariver.kernel.common.utils.UrlUtils.parseUrl(r18), "__webview_options__", null);
        r5 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0041, code lost:
    
        if (android.text.TextUtils.isEmpty(r0) == false) goto L31;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0043, code lost:
    
        r0 = com.alibaba.ariver.app.api.ParamUtils.KClassImpl$Data$declaredNonStaticMembers$2 + 107;
        com.alibaba.ariver.app.api.ParamUtils.getAuthRequestContext = r0 % 128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x004c, code lost:
    
        if ((r0 % 2) != 0) goto L20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x004f, code lost:
    
        r5 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0052, code lost:
    
        if (r5 == false) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0054, code lost:
    
        com.alibaba.ariver.kernel.common.utils.RVLogger.w("AriverApp.ParamUtils", "no magic options found");
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0057, code lost:
    
        r0 = r3.length;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0058, code lost:
    
        return null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x005c, code lost:
    
        com.alibaba.ariver.kernel.common.utils.RVLogger.w("AriverApp.ParamUtils", "no magic options found");
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x005f, code lost:
    
        return null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0060, code lost:
    
        r4 = new java.lang.StringBuilder();
        r4.append("found magic options ");
        r4.append(r0);
        com.alibaba.ariver.kernel.common.utils.RVLogger.d("AriverApp.ParamUtils", r4.toString());
        r7 = 3;
        r8 = -2044450913;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0082, code lost:
    
        r14 = new java.lang.Object[1];
        c((android.util.TypedValue.complexToFloat(0) > 0.0f ? 1 : (android.util.TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)) + 5, new int[]{-624038771, -1370486124, -2044450913, -1081295018}, r14);
        r0 = java.net.URLDecoder.decode(r0, ((java.lang.String) r14[0]).intern());
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x00a7, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x00a8, code lost:
    
        com.alibaba.ariver.kernel.common.utils.RVLogger.e("AriverApp.ParamUtils", "magic options decode exp ", r0);
        r0 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:6:0x0016, code lost:
    
        if (r0 != false) goto L13;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.util.Map<java.lang.String, java.lang.String> parseMagicOptions(java.lang.String r18, boolean r19) {
        /*
            Method dump skipped, instructions count: 504
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.ariver.app.api.ParamUtils.parseMagicOptions(java.lang.String, boolean):java.util.Map");
    }

    /* JADX WARN: Removed duplicated region for block: B:71:0x00b0 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:78:0x004f A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void parseMagicOptions(android.os.Bundle r8, java.lang.String r9) {
        /*
            Method dump skipped, instructions count: 282
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.ariver.app.api.ParamUtils.parseMagicOptions(android.os.Bundle, java.lang.String):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:108:0x00fd A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:111:0x00bf A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00ba  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00bc  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void mergeParams(android.os.Bundle r9, com.alibaba.fastjson.JSONObject r10) {
        /*
            Method dump skipped, instructions count: 401
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.ariver.app.api.ParamUtils.mergeParams(android.os.Bundle, com.alibaba.fastjson.JSONObject):void");
    }

    private static void c(int i, int[] iArr, Object[] objArr) {
        int i2;
        int i3;
        VerifyPinStateManager$executeRiskChallenge$2$1 verifyPinStateManager$executeRiskChallenge$2$1 = new VerifyPinStateManager$executeRiskChallenge$2$1();
        char[] cArr = new char[4];
        int i4 = 2;
        char[] cArr2 = new char[iArr.length * 2];
        int[] iArr2 = PlaceComponentResult;
        if (!(iArr2 == null)) {
            int length = iArr2.length;
            int[] iArr3 = new int[length];
            for (int i5 = 0; i5 < length; i5++) {
                iArr3[i5] = (int) (iArr2[i5] ^ (-3152031022165484798L));
            }
            iArr2 = iArr3;
        }
        int length2 = iArr2.length;
        int[] iArr4 = new int[length2];
        int[] iArr5 = PlaceComponentResult;
        if (iArr5 != null) {
            int length3 = iArr5.length;
            int[] iArr6 = new int[length3];
            int i6 = 0;
            while (i6 < length3) {
                int i7 = $10 + 45;
                $11 = i7 % 128;
                if (i7 % i4 == 0) {
                    i3 = length2;
                    iArr6[i6] = (int) (iArr5[i6] - 3152031022165484798L);
                    i6 >>= 1;
                } else {
                    i3 = length2;
                    iArr6[i6] = (int) (iArr5[i6] ^ (-3152031022165484798L));
                    i6++;
                }
                length2 = i3;
                i4 = 2;
            }
            iArr5 = iArr6;
            i2 = length2;
        } else {
            i2 = length2;
        }
        System.arraycopy(iArr5, 0, iArr4, 0, i2);
        verifyPinStateManager$executeRiskChallenge$2$1.BuiltInFictitiousFunctionClassFactory = 0;
        int i8 = $10 + 37;
        $11 = i8 % 128;
        int i9 = i8 % 2;
        while (verifyPinStateManager$executeRiskChallenge$2$1.BuiltInFictitiousFunctionClassFactory < iArr.length) {
            try {
                int i10 = $11 + 77;
                try {
                    $10 = i10 % 128;
                    int i11 = i10 % 2;
                    cArr[0] = (char) (iArr[verifyPinStateManager$executeRiskChallenge$2$1.BuiltInFictitiousFunctionClassFactory] >> 16);
                    cArr[1] = (char) iArr[verifyPinStateManager$executeRiskChallenge$2$1.BuiltInFictitiousFunctionClassFactory];
                    cArr[2] = (char) (iArr[verifyPinStateManager$executeRiskChallenge$2$1.BuiltInFictitiousFunctionClassFactory + 1] >> 16);
                    cArr[3] = (char) iArr[verifyPinStateManager$executeRiskChallenge$2$1.BuiltInFictitiousFunctionClassFactory + 1];
                    verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext = (cArr[0] << 16) + cArr[1];
                    verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult = (cArr[2] << 16) + cArr[3];
                    VerifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult(iArr4);
                    int i12 = 0;
                    while (true) {
                        if (!(i12 >= 16)) {
                            verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext ^= iArr4[i12];
                            verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult = VerifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext(verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext) ^ verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult;
                            int i13 = verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext;
                            verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext = verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult;
                            verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult = i13;
                            i12++;
                        }
                    }
                    int i14 = verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext;
                    verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext = verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult;
                    verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult = i14;
                    verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult ^= iArr4[16];
                    verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext ^= iArr4[17];
                    int i15 = verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext;
                    int i16 = verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult;
                    cArr[0] = (char) (verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext >>> 16);
                    cArr[1] = (char) verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext;
                    cArr[2] = (char) (verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult >>> 16);
                    cArr[3] = (char) verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult;
                    VerifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult(iArr4);
                    cArr2[verifyPinStateManager$executeRiskChallenge$2$1.BuiltInFictitiousFunctionClassFactory * 2] = cArr[0];
                    cArr2[(verifyPinStateManager$executeRiskChallenge$2$1.BuiltInFictitiousFunctionClassFactory * 2) + 1] = cArr[1];
                    cArr2[(verifyPinStateManager$executeRiskChallenge$2$1.BuiltInFictitiousFunctionClassFactory * 2) + 2] = cArr[2];
                    cArr2[(verifyPinStateManager$executeRiskChallenge$2$1.BuiltInFictitiousFunctionClassFactory * 2) + 3] = cArr[3];
                    verifyPinStateManager$executeRiskChallenge$2$1.BuiltInFictitiousFunctionClassFactory += 2;
                } catch (Exception e) {
                    throw e;
                }
            } catch (Exception e2) {
                throw e2;
            }
        }
        objArr[0] = new String(cArr2, 0, i);
    }
}
