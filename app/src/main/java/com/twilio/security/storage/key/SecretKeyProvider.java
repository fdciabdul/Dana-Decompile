package com.twilio.security.storage.key;

import com.twilio.security.crypto.KeyException;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0012\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0006\u0010\u0005"}, d2 = {"Lcom/twilio/security/storage/key/SecretKeyProvider;", "", "", "p0", "PlaceComponentResult", "([B)[B", "getAuthRequestContext"}, k = 1, mv = {1, 8, 0})
/* loaded from: classes3.dex */
public interface SecretKeyProvider {
    byte[] PlaceComponentResult(byte[] p0) throws KeyException;

    byte[] getAuthRequestContext(byte[] p0) throws KeyException;
}
