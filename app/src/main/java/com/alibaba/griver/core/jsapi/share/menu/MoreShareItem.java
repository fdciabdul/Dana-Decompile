package com.alibaba.griver.core.jsapi.share.menu;

import android.content.Intent;
import com.alibaba.griver.api.ui.share.ShareParam;
import com.alibaba.griver.api.ui.share.ShareResultListener;
import com.alibaba.griver.core.R;
import com.alibaba.griver.core.model.share.BaseOutShareItem;

/* loaded from: classes6.dex */
public class MoreShareItem extends BaseOutShareItem {
    private static final String CHANNEL_NAME = "More";
    private static final String TAG = "MoreShareItem";

    public MoreShareItem() {
        this.channelName = "More";
        this.iconDrawable = R.drawable.griver_core_share_more;
    }

    @Override // com.alibaba.griver.core.model.share.BaseOutShareItem
    public void doShare(ShareParam shareParam, ShareResultListener shareResultListener) {
        if (shareParam.activity == null) {
            return;
        }
        Intent intent = new Intent();
        intent.setAction("android.intent.action.SEND");
        intent.setType("text/plain");
        intent.putExtra("android.intent.extra.SUBJECT", shareParam.title);
        intent.putExtra("android.intent.extra.TEXT", shareParam.url);
        shareParam.activity.startActivity(Intent.createChooser(intent, "share"));
        shareResultListener.success("More");
    }
}
