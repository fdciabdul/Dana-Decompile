package com.iap.ac.android.mpm.biz.gof;

import com.iap.ac.android.biz.common.ACManager;
import com.iap.ac.android.biz.common.constants.Constants;
import com.iap.ac.android.common.log.ACLog;
import com.iap.ac.android.mpm.base.interfaces.INodeCallback;
import com.iap.ac.android.mpm.base.model.oauth.result.PrepareCollectionCodeAuthResult;
import com.iap.ac.android.mpm.biz.base.BaseBizProcessor;
import com.iap.ac.android.mpm.biz.base.BaseRoute;
import com.iap.ac.android.mpm.node.base.NodeRequest;
import com.iap.ac.android.mpm.node.base.NodeType;
import com.iap.ac.android.mpm.node.decode.DecodeOrderNodeRequest;
import com.iap.ac.android.mpm.node.hook.CommonHookNodeRequest;
import com.iap.ac.android.mpm.node.oauth.GetAuthCodeNode;
import com.iap.ac.android.mpm.node.oauth.GetAuthCodeNodeRequest;
import com.iap.ac.android.mpm.node.oauth.GetAuthCodeNodeResponse;
import com.iap.ac.android.mpm.node.oauth.PrepareAuthNode;
import com.iap.ac.android.mpm.node.oauth.PrepareAuthNodeRequest;
import com.iap.ac.android.mpm.node.oauth.PrepareAuthNodeResponse;
import com.iap.ac.android.mpm.node.swap.SwapOrderNodeRequest;
import com.iap.ac.android.mpm.node.url.OpenUrlNodeRequest;

/* loaded from: classes3.dex */
public class GofCollectionCodeRoute extends BaseRoute<GofCollectionCodeBiz> {
    @Override // com.iap.ac.android.mpm.biz.base.BaseRoute
    public void navigate(GofCollectionCodeBiz gofCollectionCodeBiz, NodeRequest nodeRequest) {
        NodeType nodeType = nodeRequest.getNodeType();
        if (NodeType.OpenUrl.equals(nodeType)) {
            handleOpenUrlNodeRequest(gofCollectionCodeBiz, (OpenUrlNodeRequest) nodeRequest);
        } else if (NodeType.PrepareAuth.equals(nodeType)) {
            handlePrepareAuthNodeRequest(gofCollectionCodeBiz, (PrepareAuthNodeRequest) nodeRequest);
        } else if (NodeType.SwapOrder.equals(nodeType)) {
            handleSwapOrderNodeRequest(gofCollectionCodeBiz, (SwapOrderNodeRequest) nodeRequest);
        } else if (NodeType.CommonHook.equals(nodeType)) {
            handleCommonHookNodeRequest(gofCollectionCodeBiz, (CommonHookNodeRequest) nodeRequest);
        } else if (NodeType.DecodeOrder.equals(nodeType)) {
            handleDecodeOrderNodeRequest(gofCollectionCodeBiz, (DecodeOrderNodeRequest) nodeRequest);
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append("GofCollectionCodeRoute node type is illegal");
            sb.append(nodeType);
            ACLog.w(Constants.TAG, sb.toString());
        }
    }

    private void handlePrepareAuthNodeRequest(final BaseBizProcessor baseBizProcessor, final PrepareAuthNodeRequest prepareAuthNodeRequest) {
        baseBizProcessor.onNodeBegin(prepareAuthNodeRequest);
        new PrepareAuthNode().handleNode(prepareAuthNodeRequest, new INodeCallback<PrepareAuthNodeResponse>() { // from class: com.iap.ac.android.mpm.biz.gof.GofCollectionCodeRoute.1
            @Override // com.iap.ac.android.mpm.base.interfaces.INodeCallback
            public void onResult(PrepareAuthNodeResponse prepareAuthNodeResponse) {
                baseBizProcessor.onNodeEnd(prepareAuthNodeRequest, prepareAuthNodeResponse);
                if (prepareAuthNodeResponse.isSuccess()) {
                    String str = ACManager.getInstance().getOAuthConfig().clientId;
                    PrepareCollectionCodeAuthResult prepareCollectionCodeAuthResult = prepareAuthNodeResponse.authResult;
                    GofCollectionCodeRoute.this.handleAuthCodeNodeRequest(baseBizProcessor, new GetAuthCodeNodeRequest(str, prepareCollectionCodeAuthResult.authClientId, prepareCollectionCodeAuthResult.scopes));
                    return;
                }
                baseBizProcessor.onProcessFinish(prepareAuthNodeResponse);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleAuthCodeNodeRequest(final BaseBizProcessor baseBizProcessor, final GetAuthCodeNodeRequest getAuthCodeNodeRequest) {
        baseBizProcessor.onNodeBegin(getAuthCodeNodeRequest);
        new GetAuthCodeNode().handleNode(getAuthCodeNodeRequest, new INodeCallback<GetAuthCodeNodeResponse>() { // from class: com.iap.ac.android.mpm.biz.gof.GofCollectionCodeRoute.2
            @Override // com.iap.ac.android.mpm.base.interfaces.INodeCallback
            public void onResult(GetAuthCodeNodeResponse getAuthCodeNodeResponse) {
                baseBizProcessor.onNodeEnd(getAuthCodeNodeRequest, getAuthCodeNodeResponse);
                if (getAuthCodeNodeResponse.isSuccess()) {
                    baseBizProcessor.onProcessPause(getAuthCodeNodeResponse);
                } else {
                    baseBizProcessor.onProcessFinish(getAuthCodeNodeResponse);
                }
            }
        });
    }
}
