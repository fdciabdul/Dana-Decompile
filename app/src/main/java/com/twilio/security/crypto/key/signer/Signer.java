package com.twilio.security.crypto.key.signer;

import com.twilio.security.crypto.KeyException;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0012\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0002H&¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"Lcom/twilio/security/crypto/key/signer/Signer;", "", "", "MyBillsEntityDataFactory", "()[B", "p0", "getAuthRequestContext", "([B)[B"}, k = 1, mv = {1, 8, 0})
/* loaded from: classes3.dex */
public interface Signer {
    byte[] MyBillsEntityDataFactory() throws KeyException;

    byte[] getAuthRequestContext(byte[] p0) throws KeyException;
}
