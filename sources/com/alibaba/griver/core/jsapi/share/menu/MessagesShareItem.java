package com.alibaba.griver.core.jsapi.share.menu;

import android.content.Intent;
import android.net.Uri;
import com.alibaba.griver.api.ui.share.ShareParam;
import com.alibaba.griver.api.ui.share.ShareResultListener;
import com.alibaba.griver.core.R;
import com.alibaba.griver.core.model.share.BaseOutShareItem;

/* loaded from: classes6.dex */
public class MessagesShareItem extends BaseOutShareItem {
    private static final String CHANNEL_NAME = "Messages";
    private static final String TAG = "MessagesShareItem";

    public MessagesShareItem() {
        this.channelName = "Messages";
        this.iconDrawable = R.drawable.griver_core_share_messages;
    }

    @Override // com.alibaba.griver.core.model.share.BaseOutShareItem
    public void doShare(ShareParam shareParam, ShareResultListener shareResultListener) {
        if (shareParam.activity == null) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(shareParam.title);
        sb.append(":");
        sb.append(shareParam.url);
        String obj = sb.toString();
        Intent intent = new Intent("android.intent.action.SENDTO", Uri.parse("smsto:"));
        intent.putExtra("sms_body", obj);
        shareParam.activity.startActivity(intent);
        shareResultListener.success("Messages");
    }
}
