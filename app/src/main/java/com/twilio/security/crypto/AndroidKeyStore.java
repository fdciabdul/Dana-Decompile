package com.twilio.security.crypto;

import android.security.keystore.KeyGenParameterSpec;
import com.twilio.security.crypto.key.cipher.AlgorithmParametersSpec;
import com.twilio.security.crypto.key.cipher.EncryptedData;
import com.twilio.security.logger.Level;
import com.twilio.security.logger.Logger;
import java.security.AlgorithmParameters;
import java.security.Key;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.KeyStore;
import java.security.PrivateKey;
import java.security.Provider;
import java.security.Signature;
import java.util.Locale;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0019¢\u0006\u0004\b\u001c\u0010\u001dJ\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u001f\u0010\n\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\n\u0010\u000bJ\u001f\u0010\u0005\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\u0005\u0010\rJ'\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0003\u001a\u00020\u000e2\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\tH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u0015\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0014\u0010\u0015J'\u0010\u0014\u001a\u00020\u000e2\u0006\u0010\u0003\u001a\u00020\u00102\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\tH\u0016¢\u0006\u0004\b\u0014\u0010\u0016J'\u0010\n\u001a\u00020\u00102\u0006\u0010\u0003\u001a\u00020\u00102\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u0017H\u0016¢\u0006\u0004\b\n\u0010\u0018R\u0014\u0010\u001b\u001a\u00020\u00198\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u001a"}, d2 = {"Lcom/twilio/security/crypto/AndroidKeyStore;", "Lcom/twilio/security/crypto/AndroidKeyStoreOperations;", "", "p0", "", "BuiltInFictitiousFunctionClassFactory", "(Ljava/lang/String;)Z", "Landroid/security/keystore/KeyGenParameterSpec;", "p1", "Ljava/security/Key;", "MyBillsEntityDataFactory", "(Ljava/lang/String;Landroid/security/keystore/KeyGenParameterSpec;)Ljava/security/Key;", "Ljava/security/KeyPair;", "(Ljava/lang/String;Landroid/security/keystore/KeyGenParameterSpec;)Ljava/security/KeyPair;", "Lcom/twilio/security/crypto/key/cipher/EncryptedData;", "p2", "", "PlaceComponentResult", "(Lcom/twilio/security/crypto/key/cipher/EncryptedData;Ljava/lang/String;Ljava/security/Key;)[B", "", "KClassImpl$Data$declaredNonStaticMembers$2", "(Ljava/lang/String;)V", "([BLjava/lang/String;Ljava/security/Key;)Lcom/twilio/security/crypto/key/cipher/EncryptedData;", "Ljava/security/PrivateKey;", "([BLjava/lang/String;Ljava/security/PrivateKey;)[B", "Ljava/security/KeyStore;", "Ljava/security/KeyStore;", "getAuthRequestContext", "<init>", "(Ljava/security/KeyStore;)V"}, k = 1, mv = {1, 8, 0})
/* loaded from: classes3.dex */
public final class AndroidKeyStore implements AndroidKeyStoreOperations {

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    final KeyStore getAuthRequestContext;

    public AndroidKeyStore(KeyStore keyStore) {
        Intrinsics.checkParameterIsNotNull(keyStore, "");
        this.getAuthRequestContext = keyStore;
    }

    public final boolean BuiltInFictitiousFunctionClassFactory(String p0) {
        Intrinsics.checkParameterIsNotNull(p0, "");
        return this.getAuthRequestContext.containsAlias(p0);
    }

    public final void KClassImpl$Data$declaredNonStaticMembers$2(String p0) {
        synchronized (this) {
            Intrinsics.checkParameterIsNotNull(p0, "");
            this.getAuthRequestContext.deleteEntry(p0);
            Unit unit = Unit.INSTANCE;
            Logger logger = Logger.PlaceComponentResult;
            Level level = Level.Debug;
            StringBuilder sb = new StringBuilder();
            sb.append("Deleted entry for ");
            sb.append(p0);
            Logger.MyBillsEntityDataFactory(level, sb.toString());
        }
    }

    public final KeyPair BuiltInFictitiousFunctionClassFactory(String p0, KeyGenParameterSpec p1) {
        KeyPair generateKeyPair;
        synchronized (this) {
            Intrinsics.checkParameterIsNotNull(p0, "");
            Intrinsics.checkParameterIsNotNull(p1, "");
            Provider provider = this.getAuthRequestContext.getProvider();
            Intrinsics.checkExpressionValueIsNotNull(provider, "");
            KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance(p0, provider.getName());
            keyPairGenerator.initialize(p1);
            Locale locale = Locale.getDefault();
            try {
                Locale.setDefault(Locale.US);
                generateKeyPair = keyPairGenerator.generateKeyPair();
                Logger logger = Logger.PlaceComponentResult;
                Level level = Level.Debug;
                StringBuilder sb = new StringBuilder();
                sb.append("Generated key pair type ");
                sb.append(p0);
                Logger.MyBillsEntityDataFactory(level, sb.toString());
            } finally {
                Locale.setDefault(locale);
            }
        }
        return generateKeyPair;
    }

    public final Key MyBillsEntityDataFactory(String p0, KeyGenParameterSpec p1) {
        SecretKey secretKey;
        synchronized (this) {
            Intrinsics.checkParameterIsNotNull(p0, "");
            Intrinsics.checkParameterIsNotNull(p1, "");
            Provider provider = this.getAuthRequestContext.getProvider();
            Intrinsics.checkExpressionValueIsNotNull(provider, "");
            KeyGenerator keyGenerator = KeyGenerator.getInstance(p0, provider.getName());
            keyGenerator.init(p1);
            SecretKey generateKey = keyGenerator.generateKey();
            Logger logger = Logger.PlaceComponentResult;
            Level level = Level.Debug;
            StringBuilder sb = new StringBuilder();
            sb.append("Generated key type ");
            sb.append(p0);
            Logger.MyBillsEntityDataFactory(level, sb.toString());
            secretKey = generateKey;
        }
        return secretKey;
    }

    @Override // com.twilio.security.crypto.AndroidKeyStoreOperations
    public final byte[] MyBillsEntityDataFactory(byte[] p0, String p1, PrivateKey p2) {
        byte[] sign;
        synchronized (this) {
            Intrinsics.checkParameterIsNotNull(p0, "");
            Intrinsics.checkParameterIsNotNull(p1, "");
            Intrinsics.checkParameterIsNotNull(p2, "");
            Signature signature = Signature.getInstance(p1);
            signature.initSign(p2);
            signature.update(p0);
            sign = signature.sign();
            Logger logger = Logger.PlaceComponentResult;
            Level level = Level.Debug;
            StringBuilder sb = new StringBuilder();
            sb.append("Sign data with ");
            sb.append(p1);
            Logger.MyBillsEntityDataFactory(level, sb.toString());
            Intrinsics.checkExpressionValueIsNotNull(sign, "");
        }
        return sign;
    }

    @Override // com.twilio.security.crypto.AndroidKeyStoreOperations
    public final EncryptedData KClassImpl$Data$declaredNonStaticMembers$2(byte[] p0, String p1, Key p2) {
        EncryptedData encryptedData;
        synchronized (this) {
            Intrinsics.checkParameterIsNotNull(p0, "");
            Intrinsics.checkParameterIsNotNull(p1, "");
            Intrinsics.checkParameterIsNotNull(p2, "");
            Cipher cipher = Cipher.getInstance(p1);
            cipher.init(1, p2);
            AlgorithmParameters parameters = cipher.getParameters();
            Intrinsics.checkExpressionValueIsNotNull(parameters, "");
            byte[] encoded = parameters.getEncoded();
            Intrinsics.checkExpressionValueIsNotNull(encoded, "");
            AlgorithmParameters parameters2 = cipher.getParameters();
            Intrinsics.checkExpressionValueIsNotNull(parameters2, "");
            Provider provider = parameters2.getProvider();
            Intrinsics.checkExpressionValueIsNotNull(provider, "");
            String name = provider.getName();
            Intrinsics.checkExpressionValueIsNotNull(name, "");
            AlgorithmParameters parameters3 = cipher.getParameters();
            Intrinsics.checkExpressionValueIsNotNull(parameters3, "");
            String algorithm = parameters3.getAlgorithm();
            Intrinsics.checkExpressionValueIsNotNull(algorithm, "");
            AlgorithmParametersSpec algorithmParametersSpec = new AlgorithmParametersSpec(encoded, name, algorithm);
            byte[] doFinal = cipher.doFinal(p0);
            Intrinsics.checkExpressionValueIsNotNull(doFinal, "");
            encryptedData = new EncryptedData(algorithmParametersSpec, doFinal);
            Logger logger = Logger.PlaceComponentResult;
            Level level = Level.Debug;
            StringBuilder sb = new StringBuilder();
            sb.append("Encrypt data with ");
            sb.append(p1);
            sb.append(" and result: ");
            sb.append(encryptedData);
            Logger.MyBillsEntityDataFactory(level, sb.toString());
        }
        return encryptedData;
    }

    @Override // com.twilio.security.crypto.AndroidKeyStoreOperations
    public final byte[] PlaceComponentResult(EncryptedData p0, String p1, Key p2) {
        byte[] doFinal;
        synchronized (this) {
            Intrinsics.checkParameterIsNotNull(p0, "");
            Intrinsics.checkParameterIsNotNull(p1, "");
            Intrinsics.checkParameterIsNotNull(p2, "");
            Cipher cipher = Cipher.getInstance(p1);
            AlgorithmParameters algorithmParameters = AlgorithmParameters.getInstance(p0.KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext, p0.KClassImpl$Data$declaredNonStaticMembers$2.PlaceComponentResult);
            algorithmParameters.init(p0.KClassImpl$Data$declaredNonStaticMembers$2.getBuiltInFictitiousFunctionClassFactory());
            cipher.init(2, p2, algorithmParameters);
            doFinal = cipher.doFinal(p0.getPlaceComponentResult());
            Logger logger = Logger.PlaceComponentResult;
            Level level = Level.Debug;
            StringBuilder sb = new StringBuilder();
            sb.append("Decrypt encrypt data ");
            sb.append(p0);
            sb.append(" with ");
            sb.append(p1);
            Logger.MyBillsEntityDataFactory(level, sb.toString());
            Intrinsics.checkExpressionValueIsNotNull(doFinal, "");
        }
        return doFinal;
    }
}
