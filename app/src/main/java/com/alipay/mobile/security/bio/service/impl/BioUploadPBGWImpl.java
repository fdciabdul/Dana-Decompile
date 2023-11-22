package com.alipay.mobile.security.bio.service.impl;

import com.alipay.biometrics.common.proguard.INotProguard;
import com.alipay.bis.common.service.facade.gw.pbmodel.upload.BisUploadGwRequest;
import com.alipay.mobile.security.bio.service.BioServiceManager;
import com.alipay.mobile.security.bio.service.BioUploadItem;
import com.alipay.mobile.security.bio.service.BioUploadResult;
import okio.ByteString;

/* loaded from: classes7.dex */
public class BioUploadPBGWImpl extends BioUploadGW<BisUploadGwRequest> implements INotProguard {
    public BioUploadPBGWImpl(BioServiceManager bioServiceManager) {
        super(bioServiceManager);
    }

    @Override // com.alipay.mobile.security.bio.service.impl.BioUploadGW
    public BioUploadResult upload(BioUploadItem bioUploadItem) {
        BisUploadGwRequest bisUploadGwRequest = new BisUploadGwRequest();
        if (bioUploadItem.content == null) {
            return doUpload(bisUploadGwRequest, bioUploadItem.isNeedSendResponse);
        }
        bisUploadGwRequest.content = ByteString.of(bioUploadItem.content);
        if (bioUploadItem.contentSig == null) {
            bioUploadItem.contentSig = "".getBytes();
        }
        bisUploadGwRequest.contentSig = ByteString.of(bioUploadItem.contentSig);
        return doUpload(bisUploadGwRequest, bioUploadItem.isNeedSendResponse);
    }
}
