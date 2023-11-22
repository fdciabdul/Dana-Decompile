package com.alipay.mobile.security.bio.service.msgchannel.pb;

import android.os.Bundle;
import android.util.Base64;
import com.alipay.bis.common.service.facade.gw.pbmodel.upload.BisUploadGwRequest;
import com.alipay.bis.common.service.facade.gw.zim.ZimValidatePbGwRequestPB;
import com.alipay.mobile.security.bio.constants.CodeConstants;
import com.alipay.mobile.security.bio.service.BioUploadResult;
import com.alipay.mobile.security.bio.service.local.rpc.IRpcException;
import com.alipay.mobile.security.zim.msgchannel.ZimMessageChannel;
import okio.ByteString;

/* loaded from: classes7.dex */
public class BioUploadServiceCoreMessageChannel {
    private final String mZimId;
    private final ZimMessageChannel mZimMessageChannel;

    public BioUploadServiceCoreMessageChannel(String str, ZimMessageChannel zimMessageChannel) {
        this.mZimId = str;
        this.mZimMessageChannel = zimMessageChannel;
    }

    public BioUploadResult doUpload(BisUploadGwRequest bisUploadGwRequest) {
        int code;
        BioUploadResult bioUploadResult = new BioUploadResult();
        ZimValidatePbGwRequestPB zimValidatePbGwRequestPB = new ZimValidatePbGwRequestPB();
        zimValidatePbGwRequestPB.zimId = this.mZimId;
        zimValidatePbGwRequestPB.zimData = ByteString.of(bisUploadGwRequest.toByteArray());
        Bundle bundle = new Bundle();
        bundle.putString("requestData", Base64.encodeToString(zimValidatePbGwRequestPB.toByteArray(), 10));
        try {
            ZimMessageChannelCallbackImpl zimMessageChannelCallbackImpl = new ZimMessageChannelCallbackImpl();
            this.mZimMessageChannel.onAction(bundle, zimMessageChannelCallbackImpl);
            BioUploadResult bioUploadResult2 = zimMessageChannelCallbackImpl.getBioUploadResult();
            if (bioUploadResult2 == null) {
                bioUploadResult.validationRetCode = 1001;
                bioUploadResult.productRetCode = 3002;
                bioUploadResult.subCode = CodeConstants.SERVER_PARAM_ERROR;
                bioUploadResult.subMsg = CodeConstants.getMessage(CodeConstants.SERVER_PARAM_ERROR);
                return bioUploadResult;
            }
            return bioUploadResult2;
        } catch (Throwable th) {
            if ((th instanceof IRpcException) && ((code = th.getCode()) == 4001 || code == 5 || code == 16 || code == 2)) {
                bioUploadResult.validationRetCode = 3001;
                bioUploadResult.productRetCode = 3002;
                bioUploadResult.subCode = CodeConstants.NETWORK_ERROR;
                bioUploadResult.subMsg = CodeConstants.getMessage(CodeConstants.NETWORK_ERROR);
                return bioUploadResult;
            }
            bioUploadResult.validationRetCode = 1001;
            bioUploadResult.productRetCode = 3002;
            bioUploadResult.subCode = CodeConstants.SERVER_PARAM_ERROR;
            bioUploadResult.subMsg = CodeConstants.getMessage(CodeConstants.SERVER_PARAM_ERROR);
            return bioUploadResult;
        }
    }
}
