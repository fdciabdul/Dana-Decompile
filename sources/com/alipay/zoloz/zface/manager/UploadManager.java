package com.alipay.zoloz.zface.manager;

import android.content.Context;
import com.alipay.mobile.security.bio.service.BioAppDescription;
import com.alipay.mobile.security.bio.service.BioServiceManager;
import com.alipay.mobile.security.zim.api.ZIMFacade;
import com.alipay.zoloz.toyger.face.ToygerFaceService;
import com.alipay.zoloz.toyger.upload.UploadContent;
import com.alipay.zoloz.zface.beans.FaceRemoteConfig;

/* loaded from: classes7.dex */
public class UploadManager {
    private BioAppDescription mBioAppDescription;
    private Context mContext;
    ToygerFaceService mToygerFaceService;
    private UploadChannel mUploadChannel;
    private String publicKey;

    public UploadManager(BioServiceManager bioServiceManager, ToygerFaceService toygerFaceService, FaceRemoteConfig faceRemoteConfig, BioAppDescription bioAppDescription) {
        Context bioApplicationContext = bioServiceManager.getBioApplicationContext();
        this.mContext = bioApplicationContext;
        this.mToygerFaceService = toygerFaceService;
        this.mBioAppDescription = bioAppDescription;
        this.publicKey = getPublicKey(bioApplicationContext, bioAppDescription, faceRemoteConfig.getEnv());
        this.mUploadChannel = new UploadChannelImpl(bioServiceManager);
    }

    public void uploadFaceInfo(UploadContent uploadContent) {
        if (this.mUploadChannel != null) {
            this.mUploadChannel.uploadFaceInfo(uploadContent, this.mBioAppDescription.getBistoken(), this.publicKey);
        }
    }

    public void uploadOtherFaceInfo(UploadContent uploadContent) {
        if (this.mUploadChannel != null) {
            this.mUploadChannel.uploadOtherFaceInfo(uploadContent, this.mBioAppDescription.getBistoken(), this.publicKey);
        }
    }

    public static String getPublicKey(Context context, BioAppDescription bioAppDescription, int i) {
        String str;
        try {
            if (i == 0) {
                str = bioAppDescription.getExtProperty().get(ZIMFacade.KEY_PUBLIC_KEY_PROD);
            } else {
                str = bioAppDescription.getExtProperty().get(ZIMFacade.KEY_PUBLIC_KEY_TEST);
            }
            return str;
        } catch (IllegalArgumentException | IllegalStateException unused) {
            return "";
        }
    }

    public void uploadNineShoot(UploadContent uploadContent) {
        if (this.mUploadChannel == null || uploadContent == null) {
            return;
        }
        this.mUploadChannel.uploadNineShoot(uploadContent, this.mBioAppDescription.getBistoken(), this.publicKey);
    }

    public void destroy() {
        this.mToygerFaceService = null;
    }
}
