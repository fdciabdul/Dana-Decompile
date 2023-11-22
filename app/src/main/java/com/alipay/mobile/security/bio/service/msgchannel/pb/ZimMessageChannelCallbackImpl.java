package com.alipay.mobile.security.bio.service.msgchannel.pb;

import android.os.Bundle;
import android.util.Base64;
import com.alipay.bis.common.service.facade.gw.zim.EntryStringString;
import com.alipay.bis.common.service.facade.gw.zim.MapStringString;
import com.alipay.bis.common.service.facade.gw.zim.ZimValidateGwResponsePB;
import com.alipay.mobile.security.bio.constants.CodeConstants;
import com.alipay.mobile.security.bio.service.BioUploadResult;
import com.alipay.mobile.security.zim.msgchannel.ZimMessageChannel;
import com.alipay.mobile.security.zim.msgchannel.ZimMessageChannelCallback;
import com.zoloz.wire.Wire;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/* loaded from: classes7.dex */
public class ZimMessageChannelCallbackImpl implements ZimMessageChannelCallback {
    public static final String TAG = "ZimMessageChannel";
    private final CountDownLatch mCountDownLatch = new CountDownLatch(1);
    private BioUploadResult mUploadResult;

    public BioUploadResult getBioUploadResult() {
        try {
            this.mCountDownLatch.await(65L, TimeUnit.SECONDS);
        } catch (InterruptedException unused) {
        }
        return this.mUploadResult;
    }

    @Override // com.alipay.mobile.security.zim.msgchannel.ZimMessageChannelCallback
    public void onResult(Bundle bundle) {
        this.mUploadResult = new BioUploadResult();
        int i = bundle.getInt(ZimMessageChannel.K_RPC_RES_CODE);
        ZimValidateGwResponsePB zimValidateGwResponsePB = null;
        if (i == 1000) {
            try {
                zimValidateGwResponsePB = (ZimValidateGwResponsePB) new Wire(new Class[0]).parseFrom(Base64.decode(bundle.getString(ZimMessageChannel.K_RPC_RES), 10), ZimValidateGwResponsePB.class);
            } catch (Throwable unused) {
            }
            if (zimValidateGwResponsePB != null) {
                if (zimValidateGwResponsePB.extParams != null && zimValidateGwResponsePB.extParams.entries != null && !zimValidateGwResponsePB.extParams.entries.isEmpty()) {
                    List<EntryStringString> list = zimValidateGwResponsePB.extParams.entries;
                    this.mUploadResult.extParams = new HashMap(list.size());
                    for (EntryStringString entryStringString : list) {
                        this.mUploadResult.extParams.put(entryStringString.key, entryStringString.value);
                    }
                }
                this.mUploadResult.subCode = zimValidateGwResponsePB.retCodeSub;
                this.mUploadResult.subMsg = zimValidateGwResponsePB.retMessageSub;
            }
            this.mUploadResult.validationRetCode = 1000;
            this.mUploadResult.productRetCode = 1001;
        } else if (i == 2006) {
            this.mUploadResult.validationRetCode = 2006;
            this.mUploadResult.productRetCode = 2001;
            try {
                zimValidateGwResponsePB = (ZimValidateGwResponsePB) new Wire(new Class[0]).parseFrom(Base64.decode(bundle.getString(ZimMessageChannel.K_RPC_RES), 10), ZimValidateGwResponsePB.class);
            } catch (Throwable unused2) {
            }
            if (zimValidateGwResponsePB != null) {
                if (zimValidateGwResponsePB.extParams != null) {
                    MapStringString mapStringString = zimValidateGwResponsePB.extParams;
                    if (mapStringString.entries != null) {
                        this.mUploadResult.extParams = new HashMap();
                        for (EntryStringString entryStringString2 : mapStringString.entries) {
                            this.mUploadResult.extParams.put(entryStringString2.key, entryStringString2.value);
                        }
                    }
                }
                this.mUploadResult.subCode = zimValidateGwResponsePB.retCodeSub;
                this.mUploadResult.subMsg = zimValidateGwResponsePB.retMessageSub;
            }
        } else if (i == 3000) {
            try {
                zimValidateGwResponsePB = (ZimValidateGwResponsePB) new Wire(new Class[0]).parseFrom(Base64.decode(bundle.getString(ZimMessageChannel.K_RPC_RES), 10), ZimValidateGwResponsePB.class);
            } catch (Throwable unused3) {
            }
            if (zimValidateGwResponsePB == null) {
                this.mUploadResult.validationRetCode = 1001;
                this.mUploadResult.productRetCode = 3002;
                this.mUploadResult.subCode = CodeConstants.SERVER_PARAM_ERROR;
                this.mUploadResult.subMsg = CodeConstants.getMessage(CodeConstants.SERVER_PARAM_ERROR);
            } else {
                this.mUploadResult.productRetCode = zimValidateGwResponsePB.productRetCode.intValue();
                this.mUploadResult.validationRetCode = zimValidateGwResponsePB.validationRetCode.intValue();
                this.mUploadResult.hasNext = zimValidateGwResponsePB.hasNext.booleanValue();
                this.mUploadResult.nextProtocol = zimValidateGwResponsePB.nextProtocol;
                this.mUploadResult.subCode = zimValidateGwResponsePB.retCodeSub;
                this.mUploadResult.subMsg = zimValidateGwResponsePB.retMessageSub;
                if (zimValidateGwResponsePB.extParams != null && zimValidateGwResponsePB.extParams.entries != null && !zimValidateGwResponsePB.extParams.entries.isEmpty()) {
                    List<EntryStringString> list2 = zimValidateGwResponsePB.extParams.entries;
                    this.mUploadResult.extParams = new HashMap(list2.size());
                    for (EntryStringString entryStringString3 : list2) {
                        this.mUploadResult.extParams.put(entryStringString3.key, entryStringString3.value);
                    }
                }
            }
        } else {
            this.mUploadResult.validationRetCode = 2006;
            this.mUploadResult.productRetCode = 2001;
            this.mUploadResult.subCode = CodeConstants.SERVER_PARAM_ERROR;
            this.mUploadResult.subMsg = CodeConstants.getMessage(CodeConstants.SERVER_PARAM_ERROR);
        }
        this.mCountDownLatch.countDown();
    }
}
