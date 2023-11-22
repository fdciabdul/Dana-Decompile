package com.alibaba.griver.core.jsapi.share.menu;

import android.content.ClipData;
import android.content.ClipboardManager;
import com.alibaba.griver.api.ui.share.ShareParam;
import com.alibaba.griver.api.ui.share.ShareResultListener;
import com.alibaba.griver.base.common.utils.ToastUtils;
import com.alibaba.griver.core.R;
import com.alibaba.griver.core.model.share.BaseOutShareItem;

/* loaded from: classes6.dex */
public class CopyUrlShareItem extends BaseOutShareItem {
    private static final String CHANNEL_NAME = "Copy Link";
    private static final String TAG = "CopyUrlShareItem";

    public CopyUrlShareItem() {
        this.iconDrawable = R.drawable.griver_core_share_copy_link;
        this.channelName = "Copy Link";
    }

    @Override // com.alibaba.griver.core.model.share.BaseOutShareItem
    public void doShare(ShareParam shareParam, ShareResultListener shareResultListener) {
        if (shareParam.activity == null) {
            return;
        }
        ((ClipboardManager) shareParam.activity.getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText("text", shareParam.url));
        ToastUtils.showToast(shareParam.activity, "Link has been copied", 0);
        shareResultListener.success("Copy Link");
    }
}
