package com.twilio.security.crypto.key.signer;

import com.twilio.security.crypto.AndroidKeyStoreOperations;
import com.twilio.security.crypto.KeyException;
import com.twilio.security.logger.Level;
import com.twilio.security.logger.Logger;
import java.security.KeyPair;
import java.security.PrivateKey;
import java.security.PublicKey;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0005\u001a\u00020\u000b\u0012\u0006\u0010\u0010\u001a\u00020\u000e\u0012\u0006\u0010\u0011\u001a\u00020\b¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\n\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\tR\u0011\u0010\u0003\u001a\u00020\u000bX\u0000¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0014\u0010\f\u001a\u00020\u000e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u000f"}, d2 = {"Lcom/twilio/security/crypto/key/signer/ECSigner;", "Lcom/twilio/security/crypto/key/signer/Signer;", "", "MyBillsEntityDataFactory", "()[B", "p0", "getAuthRequestContext", "([B)[B", "Lcom/twilio/security/crypto/AndroidKeyStoreOperations;", "Lcom/twilio/security/crypto/AndroidKeyStoreOperations;", "BuiltInFictitiousFunctionClassFactory", "Ljava/security/KeyPair;", "PlaceComponentResult", "Ljava/security/KeyPair;", "", "Ljava/lang/String;", "p1", "p2", "<init>", "(Ljava/security/KeyPair;Ljava/lang/String;Lcom/twilio/security/crypto/AndroidKeyStoreOperations;)V"}, k = 1, mv = {1, 8, 0})
/* loaded from: classes3.dex */
public final class ECSigner implements Signer {

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private final String PlaceComponentResult;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    public final KeyPair MyBillsEntityDataFactory;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    private final AndroidKeyStoreOperations BuiltInFictitiousFunctionClassFactory;

    public ECSigner(KeyPair keyPair, String str, AndroidKeyStoreOperations androidKeyStoreOperations) {
        Intrinsics.checkParameterIsNotNull(keyPair, "");
        Intrinsics.checkParameterIsNotNull(str, "");
        Intrinsics.checkParameterIsNotNull(androidKeyStoreOperations, "");
        this.MyBillsEntityDataFactory = keyPair;
        this.PlaceComponentResult = str;
        this.BuiltInFictitiousFunctionClassFactory = androidKeyStoreOperations;
    }

    @Override // com.twilio.security.crypto.key.signer.Signer
    public final byte[] getAuthRequestContext(byte[] p0) throws KeyException {
        Intrinsics.checkParameterIsNotNull(p0, "");
        try {
            AndroidKeyStoreOperations androidKeyStoreOperations = this.BuiltInFictitiousFunctionClassFactory;
            String str = this.PlaceComponentResult;
            PrivateKey privateKey = this.MyBillsEntityDataFactory.getPrivate();
            Intrinsics.checkExpressionValueIsNotNull(privateKey, "");
            return androidKeyStoreOperations.MyBillsEntityDataFactory(p0, str, privateKey);
        } catch (Exception e) {
            Logger logger = Logger.PlaceComponentResult;
            Logger.KClassImpl$Data$declaredNonStaticMembers$2(Level.Error, e.toString(), e);
            throw new KeyException(e);
        }
    }

    @Override // com.twilio.security.crypto.key.signer.Signer
    public final byte[] MyBillsEntityDataFactory() throws KeyException {
        try {
            PublicKey publicKey = this.MyBillsEntityDataFactory.getPublic();
            Intrinsics.checkExpressionValueIsNotNull(publicKey, "");
            byte[] encoded = publicKey.getEncoded();
            Intrinsics.checkExpressionValueIsNotNull(encoded, "");
            return encoded;
        } catch (Exception e) {
            Logger logger = Logger.PlaceComponentResult;
            Logger.KClassImpl$Data$declaredNonStaticMembers$2(Level.Error, e.toString(), e);
            throw new KeyException(e);
        }
    }
}
