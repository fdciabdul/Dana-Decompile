package com.alipay.mobile.security.bio.service.impl;

import com.alipay.mobile.security.bio.service.BioServiceManager;
import com.alipay.mobile.security.bio.service.BioUploadCallBack;
import com.alipay.mobile.security.bio.service.BioUploadItem;
import com.alipay.mobile.security.bio.service.BioUploadService;

/* loaded from: classes7.dex */
public class BioUploadServiceImpl extends BioUploadService {
    private BioUploadWatchThread mBioUploadWatchThread;

    @Override // com.alipay.mobile.security.bio.service.BioUploadService
    public void addCallBack(BioUploadCallBack bioUploadCallBack) {
        BioUploadWatchThread bioUploadWatchThread = this.mBioUploadWatchThread;
        if (bioUploadWatchThread == null || bioUploadCallBack == null) {
            return;
        }
        bioUploadWatchThread.addBioUploadCallBack(bioUploadCallBack);
    }

    @Override // com.alipay.mobile.security.bio.service.BioUploadService
    public int upload(BioUploadItem bioUploadItem) {
        BioUploadWatchThread bioUploadWatchThread = this.mBioUploadWatchThread;
        if (bioUploadWatchThread != null) {
            bioUploadWatchThread.addBioUploadItem(bioUploadItem);
            return 0;
        }
        return 0;
    }

    @Override // com.alipay.mobile.security.bio.service.BioUploadService
    public boolean isFulled() {
        BioUploadWatchThread bioUploadWatchThread = this.mBioUploadWatchThread;
        if (bioUploadWatchThread != null) {
            return bioUploadWatchThread.isFulled();
        }
        return false;
    }

    @Override // com.alipay.mobile.security.bio.service.BioService
    public void onCreate(BioServiceManager bioServiceManager) {
        BioUploadWatchThread bioUploadWatchThread = new BioUploadWatchThread("BioUploadService", bioServiceManager);
        this.mBioUploadWatchThread = bioUploadWatchThread;
        bioUploadWatchThread.start();
    }

    @Override // com.alipay.mobile.security.bio.service.BioUploadService
    public void clearUp() {
        BioUploadWatchThread bioUploadWatchThread = this.mBioUploadWatchThread;
        if (bioUploadWatchThread == null || !bioUploadWatchThread.isEmpty()) {
            return;
        }
        this.mBioUploadWatchThread.clearUploadItems();
        this.mBioUploadWatchThread.clearBioUploadCallBacks();
    }

    @Override // com.alipay.mobile.security.bio.service.BioService
    public void onDestroy() {
        BioUploadWatchThread bioUploadWatchThread = this.mBioUploadWatchThread;
        if (bioUploadWatchThread != null) {
            if (bioUploadWatchThread.isEmpty()) {
                this.mBioUploadWatchThread.release();
                this.mBioUploadWatchThread = null;
                return;
            }
            this.mBioUploadWatchThread.quitLater();
        }
    }
}
