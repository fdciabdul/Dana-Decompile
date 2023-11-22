package com.zoloz.android.phone.zdoc.upload;

import android.content.Context;
import com.alipay.mobile.security.bio.api.BioDetector;
import com.alipay.mobile.security.bio.service.BioAppDescription;
import com.alipay.mobile.security.bio.service.BioServiceManager;
import com.alipay.mobile.security.bio.utils.FileUtil;
import com.alipay.mobile.security.faceauth.UserVerifyInfo;
import com.alipay.mobile.security.zim.api.ZIMFacade;
import com.alipay.zoloz.toyger.upload.UploadContent;
import com.zoloz.android.phone.zdoc.module.ZdocRemoteConfig;
import java.lang.reflect.Constructor;

/* loaded from: classes8.dex */
public class UploadManager {
    private BioAppDescription mBioAppDescription;
    private int mBioType;
    private String mBisToken;
    private Context mContext;
    private UploadChannel mUploadChannel;
    private ZdocRemoteConfig mZdocRemoteConfig;
    private String mPublicKey = null;
    private UserVerifyInfo mUserVerfyInfo = null;
    private int mRetryTimes = 0;

    public void setRetryTimes(int i) {
        this.mRetryTimes = i;
    }

    public UploadManager(Context context, BioAppDescription bioAppDescription, ZdocRemoteConfig zdocRemoteConfig) {
        this.mContext = context;
        this.mBioAppDescription = bioAppDescription;
        this.mZdocRemoteConfig = zdocRemoteConfig;
    }

    public String getmPublicKey() {
        return this.mPublicKey;
    }

    public void upload(byte[] bArr, byte[] bArr2, boolean z) {
        this.mUploadChannel.uploadPaperInfo(new UploadContent(bArr, bArr2, z), this.mBisToken, this.mPublicKey);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v8, types: [java.lang.String] */
    public String getPublicKey() {
        String str;
        String env = this.mZdocRemoteConfig.getEnv();
        try {
            try {
                if (env == 0) {
                    String str2 = this.mBioAppDescription.getExtProperty().get(ZIMFacade.KEY_PUBLIC_KEY_PROD);
                    if (str2 != null) {
                        return str2;
                    }
                    str = new String(FileUtil.getAssetsData(this.mContext, "bid-log-key-public.key"));
                } else {
                    String str3 = this.mBioAppDescription.getExtProperty().get(ZIMFacade.KEY_PUBLIC_KEY_TEST);
                    if (str3 != null) {
                        return str3;
                    }
                    str = new String(FileUtil.getAssetsData(this.mContext, "bid-log-key-public_t.key"));
                }
                env = str;
                return env;
            } catch (IllegalArgumentException | IllegalStateException unused) {
                return "";
            }
        } catch (IllegalArgumentException | IllegalStateException unused2) {
            return env;
        }
    }

    public void init() {
        initUserVerifyInfo();
        this.mBisToken = this.mUserVerfyInfo.bistoken;
        this.mBioType = this.mBioAppDescription.getBioType();
        BioServiceManager currentInstance = BioServiceManager.getCurrentInstance();
        this.mPublicKey = getPublicKey();
        try {
            Constructor<?> constructor = Class.forName("com.zoloz.android.phone.zdoc.upload.UploadChannelByPB").getConstructor(BioServiceManager.class);
            constructor.setAccessible(true);
            this.mUploadChannel = (UploadChannel) constructor.newInstance(currentInstance);
        } catch (Throwable unused) {
        }
    }

    private void initUserVerifyInfo() {
        UserVerifyInfo userVerifyInfo = new UserVerifyInfo();
        this.mUserVerfyInfo = userVerifyInfo;
        userVerifyInfo.apdid = this.mBioAppDescription.getExtProperty().get("APDID") != null ? this.mBioAppDescription.getExtProperty().get("APDID") : "";
        this.mUserVerfyInfo.appid = this.mBioAppDescription.getExtProperty().get("appid") != null ? this.mBioAppDescription.getExtProperty().get("appid") : "";
        this.mUserVerfyInfo.behid = this.mBioAppDescription.getTag();
        this.mUserVerfyInfo.sceid = this.mBioAppDescription.getExtProperty().get("SCENE_ID") != null ? this.mBioAppDescription.getExtProperty().get("SCENE_ID") : "";
        this.mUserVerfyInfo.bistoken = this.mBioAppDescription.getBistoken();
        this.mUserVerfyInfo.userid = this.mBioAppDescription.getExtProperty().get("userid") != null ? this.mBioAppDescription.getExtProperty().get("userid") : "";
        this.mUserVerfyInfo.vtoken = this.mBioAppDescription.getExtProperty().get("TOKEN_ID") != null ? this.mBioAppDescription.getExtProperty().get("TOKEN_ID") : "";
        this.mUserVerfyInfo.verifyid = this.mBioAppDescription.getExtProperty().get(BioDetector.EXT_KEY_VERIFYID) != null ? this.mBioAppDescription.getExtProperty().get(BioDetector.EXT_KEY_VERIFYID) : "";
    }

    public void uploadNineShoot(byte[] bArr, byte[] bArr2, boolean z) {
        this.mUploadChannel.uploadNineShoot(new UploadContent(bArr, bArr2, z), this.mBisToken, this.mPublicKey);
    }
}
