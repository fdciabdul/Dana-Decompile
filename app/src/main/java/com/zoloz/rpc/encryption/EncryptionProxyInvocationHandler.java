package com.zoloz.rpc.encryption;

import com.alibaba.fastjson.JSON;
import com.alipay.mobile.framework.service.annotation.OperationType;
import com.alipay.mobile.security.bio.security.AESEncrypt;
import com.alipay.mobile.security.bio.security.RSAEncrypt;
import com.alipay.mobile.security.bio.service.local.rpc.IRpcException;
import com.zoloz.rpc.ZolozRpcException;
import com.zoloz.wire.Message;
import com.zoloz.wire.Wire;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.security.SecureRandom;
import okio.ByteString;

/* loaded from: classes8.dex */
public class EncryptionProxyInvocationHandler implements InvocationHandler {
    public static final String SUCCESS_RET_CODE = "100";
    private Class<?> mOriginalClass;
    private EncryptionProxyManager mProxyManager = new EncryptionProxyManager();
    private EncryptionRPCService mService;

    public EncryptionProxyInvocationHandler(EncryptionRPCService encryptionRPCService, Class<?> cls) {
        this.mService = encryptionRPCService;
        this.mOriginalClass = cls;
    }

    @Override // java.lang.reflect.InvocationHandler
    public Object invoke(Object obj, Method method, Object[] objArr) {
        OperationType operationType = (OperationType) method.getAnnotation(OperationType.class);
        if (operationType == null) {
            throw new ZolozRpcException(Integer.valueOf((int) IRpcException.ErrorCode.PRC_OPERATIONTYPE_EMPTY), "operation type is null");
        }
        byte[] randomBytes = randomBytes(32);
        EncryptionRequest encryptRequest = encryptRequest(randomBytes, objArr[0]);
        encryptRequest.fillTagValue(3, this.mService.getMid());
        EncryptionResponse execute = ((BaseEncryptionFacade) this.mService.getEncryptionRpcProxy(this.mProxyManager.getFacade(this.mOriginalClass.getName(), method.getName(), operationType.value()))).execute(encryptRequest);
        if (SUCCESS_RET_CODE.equals(execute.retCode)) {
            return parseResultObj(AESEncrypt.decrypt(execute.content.toByteArray(), randomBytes), method.getReturnType());
        }
        StringBuilder sb = new StringBuilder();
        sb.append("SERVER ILLEGALARGUMENT, retCode:");
        sb.append(execute.retCode);
        throw new ZolozRpcException((Integer) 6005, sb.toString());
    }

    private byte[] randomBytes(int i) {
        byte[] bArr = new byte[i];
        new SecureRandom().nextBytes(bArr);
        return bArr;
    }

    private Object parseResultObj(byte[] bArr, Class cls) throws ZolozRpcException {
        if (Message.class.isAssignableFrom(cls)) {
            try {
                return new Wire(new Class[0]).parseFrom(bArr, cls);
            } catch (Exception unused) {
                throw new ZolozRpcException((Integer) 3002, "pb object is error");
            }
        }
        try {
            return JSON.parseObject(new String(bArr), cls);
        } catch (Exception unused2) {
            throw new ZolozRpcException((Integer) 3002, "json object is error.");
        }
    }

    private EncryptionRequest encryptRequest(byte[] bArr, Object obj) {
        byte[] encrypt;
        if (obj instanceof Message) {
            encrypt = AESEncrypt.encrypt(((Message) obj).toByteArray(), bArr);
        } else {
            encrypt = AESEncrypt.encrypt(JSON.toJSONString(obj).getBytes(), bArr);
        }
        byte[] bArr2 = new byte[0];
        try {
            bArr2 = RSAEncrypt.encrypt(RSAEncrypt.loadPublicKeyByStr(this.mService.getPublicKey()), bArr);
        } catch (Exception unused) {
        }
        EncryptionRequest encryptionRequest = new EncryptionRequest();
        encryptionRequest.fillTagValue(1, ByteString.of(encrypt));
        encryptionRequest.fillTagValue(2, ByteString.of(bArr2));
        return encryptionRequest;
    }
}
