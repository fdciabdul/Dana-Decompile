package com.alibaba.ariver.exthub.integration.imp;

import com.alibaba.ariver.app.api.App;
import com.alibaba.ariver.app.api.Page;
import com.alibaba.ariver.engine.api.bridge.model.NativeCallContext;
import com.alibaba.ariver.engine.api.proxy.RVBridgeCallContextHandleProxy;
import com.alibaba.ariver.engine.common.bridge.DefaultApiContext;
import com.alibaba.ariver.engine.common.extension.NativePermissionExtensionInvoker;
import com.alibaba.ariver.exthub.integration.R;
import com.alibaba.ariver.kernel.api.node.Node;
import com.alibaba.ariver.kernel.common.utils.LangResourceUtil;
import com.alibaba.ariver.kernel.common.utils.RVKernelUtils;

/* loaded from: classes6.dex */
public class RVBridgeCallContextHandleProxyImp implements RVBridgeCallContextHandleProxy {
    @Override // com.alibaba.ariver.engine.api.proxy.RVBridgeCallContextHandleProxy
    public Object handleEvent(String str, Node node, NativeCallContext nativeCallContext) {
        if (node != null && nativeCallContext != null) {
            if ("setPageJsApiCount".equals(str)) {
                if (node instanceof Page) {
                    Page page = (Page) node;
                    int intValue = page.getIntValue("jsapiCount");
                    if (intValue == 0) {
                        page.putIntValue("jsapiCount", 1);
                    } else {
                        page.putIntValue("jsapiCount", intValue + 1);
                    }
                }
            } else if ("getFailedSet".equals(str)) {
                App app = (App) node.bubbleFindNode(App.class);
                if (app == null) {
                    return null;
                }
                return app.getData(NativePermissionExtensionInvoker.FailedSet.class, true);
            } else if ("getAppId".equals(str)) {
                App app2 = (App) node.bubbleFindNode(App.class);
                return app2 == null ? "" : app2.getAppId();
            } else if ("getDefaultApiContext".equals(str)) {
                return new DefaultApiContext(node, nativeCallContext.getPluginId(), nativeCallContext.getSource());
            } else {
                if ("getActivity".equals(str) && (node instanceof Page)) {
                    Page page2 = (Page) node;
                    if (page2.getRender() != null) {
                        return page2.getRender().getActivity();
                    }
                }
            }
        }
        return null;
    }

    @Override // com.alibaba.ariver.engine.api.proxy.RVBridgeCallContextHandleProxy
    public String getResourceString(String str) {
        if ("api_error_no_storage_permission".equals(str)) {
            return RVKernelUtils.getResources().getString(R.string.api_error_no_storage_permission);
        }
        if ("ariver_engine_api_forbidden_error".equals(str)) {
            return LangResourceUtil.getString(R.string.ariver_engine_api_forbidden_error);
        }
        if ("ariver_engine_api_authorization_error".equals(str)) {
            return LangResourceUtil.getString(R.string.ariver_engine_api_authorization_error);
        }
        return "ariver_engine_api_user_not_grant".equals(str) ? LangResourceUtil.getString(R.string.ariver_engine_api_user_not_grant) : "";
    }
}
