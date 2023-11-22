package com.iap.ac.android.mpm.node.decode;

import com.iap.ac.android.mpm.node.base.NodeRequest;
import com.iap.ac.android.mpm.node.base.NodeType;

/* loaded from: classes3.dex */
public class DecodeOrderNodeRequest extends NodeRequest {
    public final String codeValue;
    public final boolean isAcMiniProgram;

    public DecodeOrderNodeRequest(String str, boolean z) {
        super(NodeType.DecodeOrder);
        this.codeValue = str;
        this.isAcMiniProgram = z;
    }
}
