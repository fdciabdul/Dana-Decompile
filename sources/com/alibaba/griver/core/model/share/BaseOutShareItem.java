package com.alibaba.griver.core.model.share;

import android.app.Activity;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.service.executor.ExecutorType;
import com.alibaba.griver.api.ui.share.BaseShareItem;
import com.alibaba.griver.api.ui.share.GriverShareURLCreatorExtension;
import com.alibaba.griver.api.ui.share.ShareParam;
import com.alibaba.griver.api.ui.share.ShareResultListener;
import com.alibaba.griver.base.common.executor.GriverExecutors;
import com.alibaba.griver.base.common.rpc.OnRpcResultListener;
import com.alibaba.griver.base.common.utils.ToastUtils;
import com.alibaba.griver.core.GriverParam;
import com.alibaba.griver.core.R;
import com.alibaba.griver.core.utils.ShareShortenUrlUtils;
import com.iap.ac.android.acs.plugin.interceptor.Interceptor4getAuthCode;

/* loaded from: classes6.dex */
public abstract class BaseOutShareItem extends BaseShareItem {
    public abstract void doShare(ShareParam shareParam, ShareResultListener shareResultListener);

    @Override // com.alibaba.griver.api.ui.share.BaseShareItem
    public void onShare(final ShareParam shareParam, final ShareResultListener shareResultListener) {
        GriverShareURLCreatorExtension griverShareURLCreatorExtension = (GriverShareURLCreatorExtension) RVProxy.get(GriverShareURLCreatorExtension.class, true);
        if (griverShareURLCreatorExtension != null) {
            shareParam.params.put(GriverParam.SUB_CHANNEL, this.channelName);
            shareParam.url = griverShareURLCreatorExtension.urlForParams(shareParam.params);
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append(shareParam.url);
            sb.append("&subChannel=");
            sb.append(this.channelName);
            shareParam.url = sb.toString();
        }
        ShareShortenUrlUtils.getShortenUrl(shareParam.url, new OnRpcResultListener<ShareShortUrlResult>() { // from class: com.alibaba.griver.core.model.share.BaseOutShareItem.1
            @Override // com.alibaba.griver.base.common.rpc.OnRpcResultListener
            public void onResultSuccess(ShareShortUrlResult shareShortUrlResult) {
                if (shareShortUrlResult == null) {
                    BaseOutShareItem.this.requestFailed(shareParam.activity, "3", Interceptor4getAuthCode.ERROR_UNKNOW_MESSAGE, shareResultListener);
                } else if (!shareShortUrlResult.success) {
                    BaseOutShareItem.this.requestFailed(shareParam.activity, shareShortUrlResult.errorCode, shareShortUrlResult.errorMessage, shareResultListener);
                } else {
                    shareParam.url = shareShortUrlResult.shortLink;
                    GriverExecutors.getExecutor(ExecutorType.UI).execute(new Runnable() { // from class: com.alibaba.griver.core.model.share.BaseOutShareItem.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            BaseOutShareItem.this.doShare(shareParam, shareResultListener);
                        }
                    });
                }
            }

            @Override // com.alibaba.griver.base.common.rpc.OnRpcResultListener
            public void onResultFailed(int i, String str) {
                BaseOutShareItem.this.requestFailed(shareParam.activity, String.valueOf(i), str, shareResultListener);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void requestFailed(final Activity activity, final String str, final String str2, final ShareResultListener shareResultListener) {
        GriverExecutors.getExecutor(ExecutorType.UI).execute(new Runnable() { // from class: com.alibaba.griver.core.model.share.BaseOutShareItem.2
            @Override // java.lang.Runnable
            public void run() {
                Activity activity2 = activity;
                if (activity2 != null) {
                    ToastUtils.showToast(activity2, activity2.getString(R.string.griver_core_share_request_fail), 0);
                }
                shareResultListener.fail(BaseOutShareItem.this.channelName, String.valueOf(str), str2);
            }
        });
    }
}
