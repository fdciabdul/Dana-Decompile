package com.alibaba.griver.core.proxy;

import com.alibaba.ariver.app.api.EmbedType;
import com.alibaba.ariver.app.api.Page;
import com.alibaba.ariver.permission.api.proxy.EmbedWebViewJsApiPermissionProxy;
import com.alibaba.ariver.resource.api.models.AppModel;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.alibaba.fastjson.parser.Feature;
import java.util.List;

/* loaded from: classes6.dex */
public class GriverEmbedWebViewJsApiPermissionProxyImpl implements EmbedWebViewJsApiPermissionProxy {
    public static final String WHITE_LIST = "[\"postWebViewMessage\"]";

    @Override // com.alibaba.ariver.permission.api.proxy.EmbedWebViewJsApiPermissionProxy
    public boolean shouldInterceptJSApiCall(String str, Page page, String str2, String str3, JSONObject jSONObject) {
        AppModel appModel;
        if (page == null || page.getApp() == null || (appModel = (AppModel) page.getApp().getData(AppModel.class)) == null) {
            return false;
        }
        List list = (List) JSONObject.parseObject(WHITE_LIST, new TypeReference<List<String>>() { // from class: com.alibaba.griver.core.proxy.GriverEmbedWebViewJsApiPermissionProxyImpl.1
        }, new Feature[0]);
        if ((list == null || !list.contains(str)) && appModel.getPermissionModel() != null && appModel.getPermissionModel().getJsapiList() != null) {
            return !appModel.getPermissionModel().getJsapiList().contains(str);
        }
        return false;
    }

    public static boolean isPageHoistedEmbedWebView(Page page) {
        return page != null && page.getEmbedType() == EmbedType.FULL && Boolean.TRUE.equals(Boolean.valueOf(page.getBooleanValue("hoistEmbededWebViewOnCurrentPage")));
    }

    @Override // com.alibaba.ariver.permission.api.proxy.EmbedWebViewJsApiPermissionProxy
    public boolean callFromWebView(Page page) {
        if (isPageHoistedEmbedWebView(page)) {
            return true;
        }
        return page.getEmbedType().isEmbedPage();
    }
}
