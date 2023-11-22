package com.iap.ac.android.mpm.node.pay;

import com.iap.ac.android.biz.common.model.acl.AclAPIContext;
import com.iap.ac.android.biz.common.spi.APIContextFactory;
import com.iap.ac.android.mpm.node.base.NodeRequest;
import com.iap.ac.android.mpm.node.base.NodeType;

/* loaded from: classes3.dex */
public class PayNodeRequest extends NodeRequest {
    public AclAPIContext aclAPIContext;
    public String paymentId;
    public String paymentRedirectUrl;
    public String paymentUrl;

    public PayNodeRequest() {
        super(NodeType.Pay);
        this.aclAPIContext = APIContextFactory.createACAPIContext();
    }
}
