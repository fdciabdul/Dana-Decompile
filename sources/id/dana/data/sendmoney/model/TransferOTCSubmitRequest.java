package id.dana.data.sendmoney.model;

import id.dana.data.sendmoney.repository.source.network.request.TransferSubmitRequest;

/* loaded from: classes4.dex */
public class TransferOTCSubmitRequest extends TransferSubmitRequest {
    public String instId;
    public String payOption;
    public String withdrawInstId;
    public String withdrawInstLocalName;
    public String withdrawInstName;
    public String withdrawPayMethod;
    public String withdrawPayOption;
}
