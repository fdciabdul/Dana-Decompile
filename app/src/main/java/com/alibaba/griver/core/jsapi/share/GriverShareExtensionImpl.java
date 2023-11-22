package com.alibaba.griver.core.jsapi.share;

import android.content.DialogInterface;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.alibaba.griver.api.ui.share.BaseShareItem;
import com.alibaba.griver.api.ui.share.GriverShareExtension;
import com.alibaba.griver.api.ui.share.ShareParam;
import com.alibaba.griver.api.ui.share.ShareResultListener;
import com.alibaba.griver.base.common.logger.GriverLogger;
import com.alibaba.griver.base.common.utils.MapBuilder;
import com.alibaba.griver.base.common.utils.MonitorUtil;
import com.alibaba.griver.base.ui.widget.GriverBottomPopupDialog;
import com.alibaba.griver.core.R;
import com.alibaba.griver.core.jsapi.share.ui.ShareRecyclerAdapter;
import com.alibaba.griver.ui.ant.api.OnItemClickListener;
import java.util.List;

/* loaded from: classes6.dex */
public class GriverShareExtensionImpl implements GriverShareExtension {
    private static final String TAG = "CustomShareExtensionImpl";
    private RecyclerView channelRecyclerView;
    private ShareRecyclerAdapter shareRecyclerAdapter;

    @Override // com.alibaba.griver.api.ui.share.GriverShareExtension
    public void startShare(final ShareParam shareParam, final List<BaseShareItem> list, final ShareResultListener shareResultListener) {
        View inflate = LayoutInflater.from(shareParam.activity).inflate(R.layout.griver_core_window_share, (ViewGroup) null);
        this.channelRecyclerView = (RecyclerView) inflate.findViewById(R.id.recycler_view);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(shareParam.activity);
        linearLayoutManager.setOrientation(0);
        this.channelRecyclerView.setLayoutManager(linearLayoutManager);
        this.channelRecyclerView.setItemAnimator(new DefaultItemAnimator());
        final GriverBottomPopupDialog griverBottomPopupDialog = new GriverBottomPopupDialog(shareParam.activity, inflate);
        griverBottomPopupDialog.show();
        griverBottomPopupDialog.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.alibaba.griver.core.jsapi.share.GriverShareExtensionImpl.1
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                GriverLogger.d(GriverShareExtensionImpl.TAG, "share canceled");
                shareResultListener.cancel();
            }
        });
        inflate.findViewById(R.id.tv_cancel).setOnClickListener(new View.OnClickListener() { // from class: com.alibaba.griver.core.jsapi.share.GriverShareExtensionImpl.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                griverBottomPopupDialog.dismiss();
                shareResultListener.cancel();
            }
        });
        ShareRecyclerAdapter shareRecyclerAdapter = new ShareRecyclerAdapter(shareParam.activity, list);
        this.shareRecyclerAdapter = shareRecyclerAdapter;
        this.channelRecyclerView.setAdapter(shareRecyclerAdapter);
        this.shareRecyclerAdapter.setOnItemClickListener(new OnItemClickListener() { // from class: com.alibaba.griver.core.jsapi.share.GriverShareExtensionImpl.3
            @Override // com.alibaba.griver.ui.ant.api.OnItemClickListener
            public void onClick(View view, int i) {
                BaseShareItem baseShareItem = (BaseShareItem) list.get(i);
                MonitorUtil.trackMenuClick("ShareChannel", new MapBuilder.Builder().map("channelName", TextUtils.isEmpty(baseShareItem.channelName) ? "" : baseShareItem.channelName).build());
                griverBottomPopupDialog.dismiss();
                baseShareItem.onShare(shareParam, new ShareResultListener() { // from class: com.alibaba.griver.core.jsapi.share.GriverShareExtensionImpl.3.1
                    @Override // com.alibaba.griver.api.ui.share.ShareResultListener
                    public void success(String str) {
                        shareResultListener.success(str);
                    }

                    @Override // com.alibaba.griver.api.ui.share.ShareResultListener
                    public void cancel() {
                        shareResultListener.cancel();
                    }

                    @Override // com.alibaba.griver.api.ui.share.ShareResultListener
                    public void fail(String str, String str2, String str3) {
                        shareResultListener.fail(str, str2, str3);
                    }
                });
            }
        });
    }
}
