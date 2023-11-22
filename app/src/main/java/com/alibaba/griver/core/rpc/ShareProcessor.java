package com.alibaba.griver.core.rpc;

import com.alibaba.ariver.kernel.common.service.executor.ExecutorType;
import com.alibaba.griver.base.common.executor.GriverExecutors;
import com.alibaba.griver.base.common.rpc.BaseGriverNetwork;
import com.alibaba.griver.base.common.rpc.OnRpcResultListener;
import com.alibaba.griver.core.model.share.ShareShortUrlRequest;
import com.alibaba.griver.core.model.share.ShareShortUrlResult;
import com.alipay.mobile.common.rpc.RpcException;

/* loaded from: classes6.dex */
public class ShareProcessor extends BaseGriverNetwork<MiniProgramFacade> {
    @Override // com.alibaba.griver.base.common.rpc.BaseGriverNetwork
    public Class<MiniProgramFacade> getFacadeClass() {
        return MiniProgramFacade.class;
    }

    public void getShareShortUrl(final ShareShortUrlRequest shareShortUrlRequest, final OnRpcResultListener<ShareShortUrlResult> onRpcResultListener) {
        GriverExecutors.getExecutor(ExecutorType.NETWORK).execute(new Runnable() { // from class: com.alibaba.griver.core.rpc.ShareProcessor.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    onRpcResultListener.onResultSuccess(((MiniProgramFacade) ShareProcessor.this.getFacade()).getShareShortUrl(shareShortUrlRequest));
                } catch (RpcException e) {
                    onRpcResultListener.onResultFailed(e.getCode(), e.getMessage());
                } catch (Throwable th) {
                    onRpcResultListener.onResultFailed(3, th.getMessage());
                }
            }
        });
    }
}
