package com.alipay.mobile.security.bio.transfer.diagdata;

import com.alipay.mobile.security.bio.service.local.transfer.ProgressCallback;
import com.alipay.mobile.security.bio.service.local.transfer.TransferService;

/* loaded from: classes7.dex */
public abstract class DiagDataUploadService extends TransferService<IDiagDataReq, Object, IDiagDataRsp> {
    public abstract void uploadAsync(IDiagDataReq iDiagDataReq, ProgressCallback<IDiagDataReq, IDiagDataRsp> progressCallback);

    public abstract void uploadSync(IDiagDataReq iDiagDataReq, ProgressCallback<IDiagDataReq, IDiagDataRsp> progressCallback);

    @Override // com.alipay.mobile.security.bio.service.local.transfer.TransferService
    @Deprecated
    public final void transfer(IDiagDataReq iDiagDataReq, Object obj, boolean z, ProgressCallback<IDiagDataReq, IDiagDataRsp> progressCallback) {
        if (z) {
            uploadSync(iDiagDataReq, progressCallback);
        } else {
            uploadAsync(iDiagDataReq, progressCallback);
        }
    }
}
