package com.alibaba.wireless.security.jaq;

import android.content.Context;
import com.alibaba.wireless.security.SecExceptionCode;
import com.alibaba.wireless.security.open.SecException;
import com.alibaba.wireless.security.open.SecurityGuardManager;
import com.alibaba.wireless.security.open.atlasencrypt.IAtlasEncryptComponent;

/* loaded from: classes6.dex */
public class SecurityCipher {

    /* renamed from: a  reason: collision with root package name */
    private Context f6805a;

    public SecurityCipher(Context context) {
        if (context != null) {
            this.f6805a = context.getApplicationContext();
        }
    }

    public String atlasEncryptString(String str) throws JAQException {
        try {
            IAtlasEncryptComponent atlasEncryptComp = SecurityGuardManager.getInstance(this.f6805a).getAtlasEncryptComp();
            if (atlasEncryptComp != null) {
                return atlasEncryptComp.atlasSafeEncrypt(str, "0335");
            }
            throw new SecException(SecExceptionCode.SEC_ERROR_ATLAS_UNSUPPORTED);
        } catch (SecException e) {
            throw new JAQException(e.getErrorCode());
        }
    }

    public byte[] decryptBinary(byte[] bArr, String str) throws JAQException {
        try {
            return SecurityGuardManager.getInstance(this.f6805a).getStaticDataEncryptComp().staticBinarySafeDecrypt(16, str, bArr, "0335");
        } catch (SecException e) {
            throw new JAQException(e.getErrorCode());
        }
    }

    public String decryptString(String str, String str2) throws JAQException {
        try {
            return SecurityGuardManager.getInstance(this.f6805a).getStaticDataEncryptComp().staticSafeDecrypt(16, str2, str, "0335");
        } catch (SecException e) {
            throw new JAQException(e.getErrorCode());
        }
    }

    public byte[] encryptBinary(byte[] bArr, String str) throws JAQException {
        try {
            return SecurityGuardManager.getInstance(this.f6805a).getStaticDataEncryptComp().staticBinarySafeEncrypt(16, str, bArr, "0335");
        } catch (SecException e) {
            throw new JAQException(e.getErrorCode());
        }
    }

    public String encryptString(String str, String str2) throws JAQException {
        try {
            return SecurityGuardManager.getInstance(this.f6805a).getStaticDataEncryptComp().staticSafeEncrypt(16, str2, str, "0335");
        } catch (SecException e) {
            throw new JAQException(e.getErrorCode());
        }
    }
}
