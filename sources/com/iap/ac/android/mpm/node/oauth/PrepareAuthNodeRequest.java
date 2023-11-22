package com.iap.ac.android.mpm.node.oauth;

import com.iap.ac.android.mpm.node.base.NodeRequest;
import com.iap.ac.android.mpm.node.base.NodeType;

/* loaded from: classes3.dex */
public class PrepareAuthNodeRequest extends NodeRequest {
    public String acquireId;
    public String url;

    public PrepareAuthNodeRequest(String str) {
        super(NodeType.PrepareAuth);
        this.url = str;
    }
}
