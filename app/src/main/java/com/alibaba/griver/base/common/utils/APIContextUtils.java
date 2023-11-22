package com.alibaba.griver.base.common.utils;

import android.os.Process;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.ViewConfiguration;
import android.widget.ExpandableListView;
import com.alibaba.ariver.app.api.Page;
import com.alibaba.ariver.resource.api.models.AppInfoModel;
import com.alibaba.ariver.resource.api.models.AppModel;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.griver.api.model.APIContext;
import com.alibaba.griver.api.model.MiniProgramMetaData;
import com.alibaba.griver.base.common.innerapp.GriverInnerAppUtil;
import com.alibaba.griver.base.common.logger.GriverLogger;
import java.util.HashMap;
import java.util.Iterator;
import kotlin.text.Typography;
import o.whenAvailable;
import org.json.JSONException;

/* loaded from: classes6.dex */
public class APIContextUtils {
    private static int $10 = 0;
    private static int $11 = 1;
    private static int KClassImpl$Data$declaredNonStaticMembers$2 = 1;
    private static int getAuthRequestContext;
    private static char[] PlaceComponentResult = {58807, 43345, 31760, 981, 54946, 39490, 10521, 64723, 33688, 22345, 6659};
    private static long BuiltInFictitiousFunctionClassFactory = 4931744259002515340L;

    public static APIContext createApiContext(Page page) {
        int i = KClassImpl$Data$declaredNonStaticMembers$2 + 1;
        getAuthRequestContext = i % 128;
        int i2 = i % 2;
        if (page == null) {
            Object[] objArr = new Object[1];
            a((-1) - TextUtils.lastIndexOf("", '0', 0), (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)) + 11, (char) (5812 - (ViewConfiguration.getMaximumDrawingCacheSize() >> 24)), objArr);
            return new APIContext(((String) objArr[0]).intern(), new MiniProgramMetaData(""), null);
        }
        APIContext createApiContext = createApiContext((AppModel) page.getApp().getData(AppModel.class));
        try {
            int i3 = KClassImpl$Data$declaredNonStaticMembers$2 + 27;
            getAuthRequestContext = i3 % 128;
            int i4 = i3 % 2;
            return createApiContext;
        } catch (Exception e) {
            throw e;
        }
    }

    public static APIContext createApiContext(AppModel appModel) {
        int i = getAuthRequestContext + 89;
        KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
        int i2 = i % 2;
        if (appModel == null) {
            Object[] objArr = new Object[1];
            a(ViewConfiguration.getScrollDefaultDelay() >> 16, (ViewConfiguration.getScrollBarSize() >> 8) + 11, (char) ((ViewConfiguration.getLongPressTimeout() >> 16) + 5812), objArr);
            return new APIContext(((String) objArr[0]).intern(), new MiniProgramMetaData(""), null);
        }
        String appId = appModel.getAppId();
        JSONObject extendInfos = appModel.getExtendInfos();
        MiniProgramMetaData miniProgramMetaData = new MiniProgramMetaData(appId, extendInfos == null ? "" : extendInfos.getString("merchantId"));
        AppInfoModel appInfoModel = appModel.getAppInfoModel();
        if ((appInfoModel != null ? 'T' : Typography.less) == 'T') {
            int i3 = getAuthRequestContext + 91;
            KClassImpl$Data$declaredNonStaticMembers$2 = i3 % 128;
            int i4 = i3 % 2;
            miniProgramMetaData.setName(appInfoModel.getName());
            miniProgramMetaData.setLogo(appInfoModel.getLogo());
            miniProgramMetaData.setDesc(appInfoModel.getDesc());
            miniProgramMetaData.setDeployVersion(appInfoModel.getVersion());
            miniProgramMetaData.setDeveloperVersion(appInfoModel.getDeveloperVersion());
        }
        if (extendInfos != null) {
            try {
                miniProgramMetaData.setAppType(2);
                try {
                    if (extendInfos.getJSONObject(GriverInnerAppUtil.KEY_CLIENT_PARAM) != null) {
                        miniProgramMetaData.setClientParams(new org.json.JSONObject(JSON.toJSONString(extendInfos.getJSONObject(GriverInnerAppUtil.KEY_CLIENT_PARAM))));
                    }
                    if (extendInfos.getJSONObject("languages") != null) {
                        miniProgramMetaData.setLanguages(new org.json.JSONObject(JSON.toJSONString(extendInfos.getJSONObject("languages"))));
                    }
                    JSONObject jSONObject = extendInfos.getJSONObject("acParams");
                    if (jSONObject != null && !jSONObject.isEmpty()) {
                        HashMap hashMap = new HashMap();
                        Iterator<String> it = jSONObject.keySet().iterator();
                        int i5 = getAuthRequestContext + 123;
                        KClassImpl$Data$declaredNonStaticMembers$2 = i5 % 128;
                        int i6 = i5 % 2;
                        while (true) {
                            if ((it.hasNext() ? Typography.dollar : 'c') != '$') {
                                break;
                            }
                            String next = it.next();
                            hashMap.put(next, jSONObject.getString(next));
                        }
                        miniProgramMetaData.setAcParams(hashMap);
                    }
                } catch (JSONException e) {
                    GriverLogger.e("APIContextUtils", "parse mini program meta data error, just print", e);
                }
                miniProgramMetaData.setAcquirerId(extendInfos.getString("acquirerId"));
                miniProgramMetaData.setPublishStatus(extendInfos.getString("publishingStatus"));
                miniProgramMetaData.setClientId(extendInfos.getString("authClientId"));
            } catch (Exception e2) {
                throw e2;
            }
        }
        Object[] objArr2 = new Object[1];
        a(Process.myPid() >> 22, 12 - (SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)), (char) (5812 - ExpandableListView.getPackedPositionType(0L)), objArr2);
        return new APIContext(((String) objArr2[0]).intern(), miniProgramMetaData, null);
    }

    private static void a(int i, int i2, char c, Object[] objArr) {
        whenAvailable whenavailable = new whenAvailable();
        long[] jArr = new long[i2];
        whenavailable.BuiltInFictitiousFunctionClassFactory = 0;
        try {
            int i3 = $10 + 117;
            try {
                $11 = i3 % 128;
                int i4 = i3 % 2;
                while (whenavailable.BuiltInFictitiousFunctionClassFactory < i2) {
                    jArr[whenavailable.BuiltInFictitiousFunctionClassFactory] = (((char) (PlaceComponentResult[whenavailable.BuiltInFictitiousFunctionClassFactory + i] ^ (-4773380863230414002L))) ^ (whenavailable.BuiltInFictitiousFunctionClassFactory * ((-4773380863230414002L) ^ BuiltInFictitiousFunctionClassFactory))) ^ c;
                    whenavailable.BuiltInFictitiousFunctionClassFactory++;
                }
                char[] cArr = new char[i2];
                whenavailable.BuiltInFictitiousFunctionClassFactory = 0;
                while (true) {
                    if ((whenavailable.BuiltInFictitiousFunctionClassFactory < i2 ? ']' : 'D') == 'D') {
                        objArr[0] = new String(cArr);
                        return;
                    }
                    int i5 = $11 + 95;
                    $10 = i5 % 128;
                    int i6 = i5 % 2;
                    cArr[whenavailable.BuiltInFictitiousFunctionClassFactory] = (char) jArr[whenavailable.BuiltInFictitiousFunctionClassFactory];
                    whenavailable.BuiltInFictitiousFunctionClassFactory++;
                }
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }
}
