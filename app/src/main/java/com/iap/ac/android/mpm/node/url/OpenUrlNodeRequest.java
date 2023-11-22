package com.iap.ac.android.mpm.node.url;

import android.content.Context;
import com.iap.ac.android.common.container.event.IContainerListener;
import com.iap.ac.android.mpm.base.model.route.ACDecodeConfig;
import com.iap.ac.android.mpm.node.base.NodeRequest;
import com.iap.ac.android.mpm.node.base.NodeType;

/* loaded from: classes3.dex */
public class OpenUrlNodeRequest extends NodeRequest {
    public ACDecodeConfig acDecodeConfig;
    public String bizKey;
    public Context context;
    public IContainerListener listener;
    public String openUrl;

    public OpenUrlNodeRequest() {
        super(NodeType.OpenUrl);
    }
}
