package com.iap.ac.android.mpm.node.swap;

import com.iap.ac.android.mpm.node.base.NodeRequest;
import com.iap.ac.android.mpm.node.base.NodeType;
import java.util.Map;

/* loaded from: classes3.dex */
public class SwapOrderNodeRequest extends NodeRequest {
    public String acquireId;
    public final boolean isAcMiniProgram;
    public final Map<String, String> params;
    public final String tradeNO;

    public SwapOrderNodeRequest(Map<String, String> map, String str, boolean z) {
        super(NodeType.SwapOrder);
        this.params = map;
        this.tradeNO = str;
        this.isAcMiniProgram = z;
    }

    public SwapOrderNodeRequest(Map<String, String> map, String str, String str2, boolean z) {
        super(NodeType.SwapOrder);
        this.params = map;
        this.tradeNO = str;
        this.acquireId = str2;
        this.isAcMiniProgram = z;
    }
}
