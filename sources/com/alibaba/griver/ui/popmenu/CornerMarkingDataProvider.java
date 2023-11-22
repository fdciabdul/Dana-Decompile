package com.alibaba.griver.ui.popmenu;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.service.RVEnvironmentService;
import com.alibaba.ariver.kernel.common.service.executor.ExecutorType;
import com.alibaba.ariver.kernel.common.utils.ExecutorUtils;
import com.alibaba.ariver.kernel.common.utils.JSONUtils;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.griver.base.common.account.GriverAccount;
import com.alipay.mobile.verifyidentity.business.securitycommon.bean.SecurityConstants;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes6.dex */
public class CornerMarkingDataProvider {
    public void getData(final String str, final JSONObject jSONObject, final Callback<List<CornerMarkingData>> callback) {
        final String userId = GriverAccount.getUserId();
        if (TextUtils.isEmpty(userId) || TextUtils.isEmpty(str)) {
            callback.callback(null);
        } else {
            ExecutorUtils.runNotOnMain(ExecutorType.IO, new Runnable() { // from class: com.alibaba.griver.ui.popmenu.CornerMarkingDataProvider.1
                @Override // java.lang.Runnable
                public void run() {
                    StringBuilder sb = new StringBuilder();
                    sb.append(userId);
                    sb.append("_");
                    sb.append(str);
                    sb.append("_corner");
                    SharedPreferences a2 = CornerMarkingDataProvider.this.a(((RVEnvironmentService) RVProxy.get(RVEnvironmentService.class)).getApplicationContext(), sb.toString());
                    if (a2 == null) {
                        callback.callback(null);
                        return;
                    }
                    try {
                        if (!JSONUtils.getBoolean(jSONObject, "success", false)) {
                            callback.callback(null);
                            return;
                        }
                        JSONObject jSONObject2 = jSONObject.getJSONObject("result");
                        if (jSONObject2 == null) {
                            callback.callback(null);
                            return;
                        }
                        JSONArray jSONArray = jSONObject2.getJSONArray("menus");
                        if (jSONArray != null) {
                            callback.callback(CornerMarkingDataProvider.this.a(jSONArray, a2));
                        } else {
                            callback.callback(null);
                        }
                    } catch (Exception unused) {
                        callback.callback(null);
                    }
                }
            });
        }
    }

    public void click(final String str, final String str2) {
        final String userId = GriverAccount.getUserId();
        if (TextUtils.isEmpty(userId) || TextUtils.isEmpty(str)) {
            return;
        }
        ExecutorUtils.runNotOnMain(ExecutorType.IO, new Runnable() { // from class: com.alibaba.griver.ui.popmenu.CornerMarkingDataProvider.2
            @Override // java.lang.Runnable
            public void run() {
                StringBuilder sb = new StringBuilder();
                sb.append(userId);
                sb.append("_");
                sb.append(str);
                sb.append("_corner");
                SharedPreferences a2 = CornerMarkingDataProvider.this.a(((RVEnvironmentService) RVProxy.get(RVEnvironmentService.class)).getApplicationContext(), sb.toString());
                if (a2 == null) {
                    RVLogger.e("CornerMarkingDataProvider", "APSharedPreferences is null");
                    return;
                }
                SharedPreferences.Editor edit = a2.edit();
                StringBuilder sb2 = new StringBuilder();
                sb2.append("click_");
                sb2.append(str2);
                edit.putString(sb2.toString(), "1");
                edit.apply();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<CornerMarkingData> a(JSONArray jSONArray, SharedPreferences sharedPreferences) {
        boolean z;
        if (jSONArray == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        int size = jSONArray.size();
        for (int i = 0; i < size; i++) {
            JSONObject jSONObject = jSONArray.getJSONObject(i);
            CornerMarkingData cornerMarkingData = new CornerMarkingData();
            cornerMarkingData.superscript = jSONObject.getString("superscript");
            if (!TextUtils.isEmpty(cornerMarkingData.superscript)) {
                cornerMarkingData.noticeId = jSONObject.getString("noticeId");
                if (sharedPreferences != null) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("click_");
                    sb.append(cornerMarkingData.noticeId);
                    if ("1".equals(sharedPreferences.getString(sb.toString(), "0"))) {
                    }
                }
                if (sharedPreferences != null) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("expose_");
                    sb2.append(cornerMarkingData.noticeId);
                    if ("1".equals(sharedPreferences.getString(sb2.toString(), "0"))) {
                        z = true;
                        cornerMarkingData.exposed = z;
                        cornerMarkingData.action = jSONObject.getString("action");
                        cornerMarkingData.callback = jSONObject.getString("callback");
                        cornerMarkingData.icon = jSONObject.getString("icon");
                        cornerMarkingData.menuIconUrl = jSONObject.getString("menuIconUrl");
                        cornerMarkingData.mid = jSONObject.getString("mid");
                        cornerMarkingData.name = jSONObject.getString("name");
                        cornerMarkingData.options = jSONObject.getString(SecurityConstants.KEY_OPTIONS);
                        arrayList.add(cornerMarkingData);
                    }
                }
                z = false;
                cornerMarkingData.exposed = z;
                cornerMarkingData.action = jSONObject.getString("action");
                cornerMarkingData.callback = jSONObject.getString("callback");
                cornerMarkingData.icon = jSONObject.getString("icon");
                cornerMarkingData.menuIconUrl = jSONObject.getString("menuIconUrl");
                cornerMarkingData.mid = jSONObject.getString("mid");
                cornerMarkingData.name = jSONObject.getString("name");
                cornerMarkingData.options = jSONObject.getString(SecurityConstants.KEY_OPTIONS);
                arrayList.add(cornerMarkingData);
            }
        }
        return arrayList;
    }

    public void expose(final String str, final List<CornerMarkingData> list) {
        final String userId = GriverAccount.getUserId();
        if (TextUtils.isEmpty(userId) || TextUtils.isEmpty(str) || list == null || list.size() == 0) {
            return;
        }
        boolean z = false;
        for (CornerMarkingData cornerMarkingData : list) {
            if (!cornerMarkingData.exposed) {
                cornerMarkingData.exposed = true;
                z = true;
            }
        }
        if (z) {
            ExecutorUtils.runNotOnMain(ExecutorType.IO, new Runnable() { // from class: com.alibaba.griver.ui.popmenu.CornerMarkingDataProvider.3
                @Override // java.lang.Runnable
                public void run() {
                    StringBuilder sb = new StringBuilder();
                    sb.append(userId);
                    sb.append("_");
                    sb.append(str);
                    sb.append("_corner");
                    SharedPreferences a2 = CornerMarkingDataProvider.this.a(((RVEnvironmentService) RVProxy.get(RVEnvironmentService.class)).getApplicationContext(), sb.toString());
                    if (a2 == null) {
                        RVLogger.e("CornerMarkingDataProvider", "APSharedPreferences is null");
                        return;
                    }
                    SharedPreferences.Editor edit = a2.edit();
                    for (CornerMarkingData cornerMarkingData2 : list) {
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("expose_");
                        sb2.append(cornerMarkingData2.noticeId);
                        edit.putString(sb2.toString(), "1");
                    }
                    edit.apply();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public SharedPreferences a(Context context, String str) {
        if (context != null) {
            return context.getSharedPreferences(str, 0);
        }
        return null;
    }
}
