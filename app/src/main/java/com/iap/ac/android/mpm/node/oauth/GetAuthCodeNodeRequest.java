package com.iap.ac.android.mpm.node.oauth;

import com.iap.ac.android.mpm.node.base.NodeRequest;
import com.iap.ac.android.mpm.node.base.NodeType;
import java.util.List;

/* loaded from: classes3.dex */
public class GetAuthCodeNodeRequest extends NodeRequest {
    public String authClientId;
    public String clientId;
    public List<String> scopes;

    public GetAuthCodeNodeRequest(String str, String str2, List<String> list) {
        super(NodeType.GetAuthCode);
        this.clientId = str;
        this.authClientId = str2;
        this.scopes = list;
    }
}
