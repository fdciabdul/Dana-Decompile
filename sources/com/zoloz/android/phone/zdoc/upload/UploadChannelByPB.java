package com.zoloz.android.phone.zdoc.upload;

import com.alipay.biometrics.common.proguard.INotProguard;
import com.alipay.mobile.security.bio.service.BioServiceManager;
import com.alipay.mobile.security.bio.service.BioUploadItem;
import com.alipay.mobile.security.bio.service.BioUploadService;
import com.alipay.zoloz.toyger.upload.UploadContent;

/* loaded from: classes8.dex */
public class UploadChannelByPB extends UploadChannel implements INotProguard {
    private BioUploadService mBioUploadService;

    public UploadChannelByPB(BioServiceManager bioServiceManager) {
        this.mBioUploadService = (BioUploadService) bioServiceManager.getBioService(BioUploadService.class);
    }

    @Override // com.zoloz.android.phone.zdoc.upload.UploadChannel
    public void uploadPaperInfo(UploadContent uploadContent, String str, String str2) {
        if (uploadContent != null) {
            BioUploadItem bioUploadItem = new BioUploadItem();
            bioUploadItem.content = uploadContent.content;
            bioUploadItem.bisToken = str;
            bioUploadItem.contentSig = uploadContent.contentSig;
            bioUploadItem.isNeedSendResponse = true;
            this.mBioUploadService.upload(bioUploadItem);
        }
    }

    @Override // com.zoloz.android.phone.zdoc.upload.UploadChannel
    public void uploadNineShoot(UploadContent uploadContent, String str, String str2) {
        if (uploadContent != null) {
            BioUploadItem bioUploadItem = new BioUploadItem();
            bioUploadItem.content = uploadContent.content;
            bioUploadItem.bisToken = str;
            bioUploadItem.isNeedSendResponse = false;
            bioUploadItem.contentSig = uploadContent.contentSig;
            this.mBioUploadService.upload(bioUploadItem);
        }
    }
}
