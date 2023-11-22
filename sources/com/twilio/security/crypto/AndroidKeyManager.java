package com.twilio.security.crypto;

import com.twilio.security.crypto.key.cipher.AESCipher;
import com.twilio.security.crypto.key.cipher.Cipher;
import com.twilio.security.crypto.key.template.AESGCMNoPaddingCipherTemplate;
import com.twilio.security.crypto.key.template.CipherTemplate;
import com.twilio.security.logger.Level;
import com.twilio.security.logger.Logger;
import java.security.Key;
import java.security.KeyPair;
import java.security.KeyStore;
import java.security.PrivateKey;
import java.security.cert.Certificate;
import java.util.concurrent.TimeUnit;
import javax.crypto.SecretKey;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u001e¢\u0006\u0004\b \u0010!J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0003\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0003\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u0012\u0010\u0013J7\u0010\u0005\u001a\u0004\u0018\u00018\u0000\"\u0004\b\u0000\u0010\u00142\u0006\u0010\u0003\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u00162\u000e\u0010\u0019\u001a\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u0018H\u0002¢\u0006\u0004\b\u0005\u0010\u001aJ\u0017\u0010\u000f\u001a\u00020\u001c2\u0006\u0010\u0003\u001a\u00020\u001bH\u0016¢\u0006\u0004\b\u000f\u0010\u001dR\u0014\u0010\f\u001a\u00020\u001e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\u001f"}, d2 = {"Lcom/twilio/security/crypto/AndroidKeyManager;", "Lcom/twilio/security/crypto/KeyManager;", "Lcom/twilio/security/crypto/key/template/CipherTemplate;", "p0", "Lcom/twilio/security/crypto/key/cipher/Cipher;", "BuiltInFictitiousFunctionClassFactory", "(Lcom/twilio/security/crypto/key/template/CipherTemplate;)Lcom/twilio/security/crypto/key/cipher/Cipher;", "", "", "KClassImpl$Data$declaredNonStaticMembers$2", "(Ljava/lang/String;)Z", "", "PlaceComponentResult", "(Ljava/lang/String;)V", "Ljavax/crypto/SecretKey;", "MyBillsEntityDataFactory", "(Ljava/lang/String;)Ljavax/crypto/SecretKey;", "Ljava/security/KeyPair;", "getAuthRequestContext", "(Ljava/lang/String;)Ljava/security/KeyPair;", "T", "", "", "p1", "Lkotlin/Function0;", "p2", "(Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "Lcom/twilio/security/crypto/key/template/SignerTemplate;", "Lcom/twilio/security/crypto/key/signer/Signer;", "(Lcom/twilio/security/crypto/key/template/SignerTemplate;)Lcom/twilio/security/crypto/key/signer/Signer;", "Lcom/twilio/security/crypto/AndroidKeyStore;", "Lcom/twilio/security/crypto/AndroidKeyStore;", "<init>", "(Lcom/twilio/security/crypto/AndroidKeyStore;)V"}, k = 1, mv = {1, 8, 0})
/* loaded from: classes3.dex */
public final class AndroidKeyManager implements KeyManager {

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    private final AndroidKeyStore PlaceComponentResult;

    public AndroidKeyManager(AndroidKeyStore androidKeyStore) {
        Intrinsics.checkParameterIsNotNull(androidKeyStore, "");
        this.PlaceComponentResult = androidKeyStore;
    }

    /* JADX WARN: Code restructure failed: missing block: B:49:0x009c, code lost:
    
        if (java.util.Arrays.equals(r1, r4) != true) goto L50;
     */
    @Override // com.twilio.security.crypto.KeyManager
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final com.twilio.security.crypto.key.signer.Signer MyBillsEntityDataFactory(com.twilio.security.crypto.key.template.SignerTemplate r6) throws com.twilio.security.crypto.KeyException {
        /*
            Method dump skipped, instructions count: 290
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.twilio.security.crypto.AndroidKeyManager.MyBillsEntityDataFactory(com.twilio.security.crypto.key.template.SignerTemplate):com.twilio.security.crypto.key.signer.Signer");
    }

    private final KeyPair getAuthRequestContext(final String p0) {
        Logger logger = Logger.PlaceComponentResult;
        Level level = Level.Info;
        StringBuilder sb = new StringBuilder();
        sb.append("Getting signer key pair for: ");
        sb.append(p0);
        Logger.MyBillsEntityDataFactory(level, sb.toString());
        if (!KClassImpl$Data$declaredNonStaticMembers$2(p0)) {
            throw new IllegalArgumentException("alias not found");
        }
        KeyPair keyPair = (KeyPair) BuiltInFictitiousFunctionClassFactory(new Function0<KeyPair>() { // from class: com.twilio.security.crypto.AndroidKeyManager$getSignerKeyPair$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final KeyPair invoke() {
                AndroidKeyStore androidKeyStore;
                androidKeyStore = AndroidKeyManager.this.PlaceComponentResult;
                String str = p0;
                Intrinsics.checkParameterIsNotNull(str, "");
                KeyPair keyPair2 = null;
                Key key = androidKeyStore.getAuthRequestContext.getKey(str, null);
                if (!(key instanceof PrivateKey)) {
                    key = null;
                }
                PrivateKey privateKey = (PrivateKey) key;
                if (privateKey == null) {
                    KeyStore.Entry entry = androidKeyStore.getAuthRequestContext.getEntry(str, null);
                    if (!(entry instanceof KeyStore.PrivateKeyEntry)) {
                        entry = null;
                    }
                    KeyStore.PrivateKeyEntry privateKeyEntry = (KeyStore.PrivateKeyEntry) entry;
                    privateKey = privateKeyEntry != null ? privateKeyEntry.getPrivateKey() : null;
                    Logger logger2 = Logger.PlaceComponentResult;
                    Level level2 = Level.Debug;
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("Get private key for ");
                    sb2.append(str);
                    Logger.MyBillsEntityDataFactory(level2, sb2.toString());
                }
                Certificate certificate = androidKeyStore.getAuthRequestContext.getCertificate(str);
                if (certificate == null) {
                    KeyStore.Entry entry2 = androidKeyStore.getAuthRequestContext.getEntry(str, null);
                    if (!(entry2 instanceof KeyStore.PrivateKeyEntry)) {
                        entry2 = null;
                    }
                    KeyStore.PrivateKeyEntry privateKeyEntry2 = (KeyStore.PrivateKeyEntry) entry2;
                    certificate = privateKeyEntry2 != null ? privateKeyEntry2.getCertificate() : null;
                    Logger logger3 = Logger.PlaceComponentResult;
                    Level level3 = Level.Debug;
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append("Get certificate for ");
                    sb3.append(str);
                    Logger.MyBillsEntityDataFactory(level3, sb3.toString());
                }
                if (privateKey != null && certificate != null) {
                    keyPair2 = new KeyPair(certificate.getPublicKey(), privateKey);
                } else {
                    Logger logger4 = Logger.PlaceComponentResult;
                    Level level4 = Level.Debug;
                    StringBuilder sb4 = new StringBuilder();
                    sb4.append("Private key ");
                    sb4.append(privateKey == null ? "is null" : "is not null");
                    sb4.append(" and ");
                    sb4.append("Certificate ");
                    sb4.append(certificate == null ? "is null" : "is not null");
                    Logger.MyBillsEntityDataFactory(level4, sb4.toString());
                }
                Logger logger5 = Logger.PlaceComponentResult;
                Level level5 = Level.Debug;
                StringBuilder sb5 = new StringBuilder();
                sb5.append("Return key pair for ");
                sb5.append(str);
                Logger.MyBillsEntityDataFactory(level5, sb5.toString());
                return keyPair2;
            }
        });
        if (keyPair != null) {
            return keyPair;
        }
        throw new IllegalArgumentException("Key pair not found");
    }

    @Override // com.twilio.security.crypto.KeyManager
    public final Cipher BuiltInFictitiousFunctionClassFactory(CipherTemplate p0) throws KeyException {
        SecretKey MyBillsEntityDataFactory;
        Intrinsics.checkParameterIsNotNull(p0, "");
        Logger logger = Logger.PlaceComponentResult;
        Level level = Level.Info;
        StringBuilder sb = new StringBuilder();
        sb.append("Getting cipher for alias: ");
        sb.append(p0.getGetAuthRequestContext());
        Logger.MyBillsEntityDataFactory(level, sb.toString());
        Logger logger2 = Logger.PlaceComponentResult;
        Level level2 = Level.Debug;
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Getting cipher for template: ");
        sb2.append(p0);
        Logger.MyBillsEntityDataFactory(level2, sb2.toString());
        try {
            if (!KClassImpl$Data$declaredNonStaticMembers$2(p0.getGetAuthRequestContext())) {
                if (p0.getMyBillsEntityDataFactory()) {
                    throw new IllegalStateException("The alias does not exist");
                }
                Logger logger3 = Logger.PlaceComponentResult;
                Level level3 = Level.Info;
                StringBuilder sb3 = new StringBuilder();
                sb3.append("Creating cipher key for: ");
                sb3.append(p0.getGetAuthRequestContext());
                Logger.MyBillsEntityDataFactory(level3, sb3.toString());
                Key MyBillsEntityDataFactory2 = this.PlaceComponentResult.MyBillsEntityDataFactory(p0.getKClassImpl$Data$declaredNonStaticMembers$2(), p0.getGetAuthRequestContext());
                MyBillsEntityDataFactory = MyBillsEntityDataFactory(p0.getGetAuthRequestContext());
                if (!(MyBillsEntityDataFactory2 != null && Intrinsics.areEqual(MyBillsEntityDataFactory2, MyBillsEntityDataFactory))) {
                    MyBillsEntityDataFactory = null;
                }
                if (MyBillsEntityDataFactory == null) {
                    throw new IllegalArgumentException("New secret key not found");
                }
            } else {
                MyBillsEntityDataFactory = MyBillsEntityDataFactory(p0.getGetAuthRequestContext());
            }
            if (p0 instanceof AESGCMNoPaddingCipherTemplate) {
                return new AESCipher(MyBillsEntityDataFactory, p0.getBuiltInFictitiousFunctionClassFactory(), this.PlaceComponentResult);
            }
            throw new NoWhenBranchMatchedException();
        } catch (Exception e) {
            Logger logger4 = Logger.PlaceComponentResult;
            Logger.KClassImpl$Data$declaredNonStaticMembers$2(Level.Error, e.toString(), e);
            throw new KeyException(e);
        }
    }

    @Override // com.twilio.security.crypto.KeyManager
    public final void PlaceComponentResult(String p0) throws KeyException {
        Intrinsics.checkParameterIsNotNull(p0, "");
        try {
            if (KClassImpl$Data$declaredNonStaticMembers$2(p0)) {
                this.PlaceComponentResult.KClassImpl$Data$declaredNonStaticMembers$2(p0);
            }
        } catch (Exception e) {
            Logger logger = Logger.PlaceComponentResult;
            Logger.KClassImpl$Data$declaredNonStaticMembers$2(Level.Error, e.toString(), e);
            throw new KeyException(e);
        }
    }

    @Override // com.twilio.security.crypto.KeyManager
    public final boolean KClassImpl$Data$declaredNonStaticMembers$2(String p0) {
        Intrinsics.checkParameterIsNotNull(p0, "");
        return this.PlaceComponentResult.BuiltInFictitiousFunctionClassFactory(p0);
    }

    private final SecretKey MyBillsEntityDataFactory(final String p0) {
        Logger logger = Logger.PlaceComponentResult;
        Level level = Level.Info;
        StringBuilder sb = new StringBuilder();
        sb.append("Getting cipher key for: ");
        sb.append(p0);
        Logger.MyBillsEntityDataFactory(level, sb.toString());
        SecretKey secretKey = (SecretKey) BuiltInFictitiousFunctionClassFactory(new Function0<SecretKey>() { // from class: com.twilio.security.crypto.AndroidKeyManager$getCipherKey$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final SecretKey invoke() {
                return AndroidKeyManager.KClassImpl$Data$declaredNonStaticMembers$2(AndroidKeyManager.this, p0);
            }
        });
        if (secretKey != null) {
            return secretKey;
        }
        throw new IllegalArgumentException("Secret key not found");
    }

    private static <T> T BuiltInFictitiousFunctionClassFactory(Function0<? extends T> function0) {
        T t;
        int i = 0;
        while (i < 2) {
            i++;
            long j = i;
            try {
                t = function0.invoke();
            } catch (Exception e) {
                Logger logger = Logger.PlaceComponentResult;
                Logger.KClassImpl$Data$declaredNonStaticMembers$2(Level.Error, e.toString(), e);
                t = null;
            }
            if (t == null) {
                Logger logger2 = Logger.PlaceComponentResult;
                Logger.MyBillsEntityDataFactory(Level.Debug, "AndroidKeyManager: Retrying operation");
                TimeUnit.MILLISECONDS.sleep(j * 100);
            } else {
                Logger logger3 = Logger.PlaceComponentResult;
                Logger.MyBillsEntityDataFactory(Level.Debug, "AndroidKeyManager: Successful operation");
                return t;
            }
        }
        T invoke = function0.invoke();
        Logger logger4 = Logger.PlaceComponentResult;
        Logger.MyBillsEntityDataFactory(Level.Debug, "AndroidKeyManager: Successful operation");
        return invoke;
    }

    public static final /* synthetic */ SecretKey KClassImpl$Data$declaredNonStaticMembers$2(AndroidKeyManager androidKeyManager, String str) {
        if (!androidKeyManager.KClassImpl$Data$declaredNonStaticMembers$2(str)) {
            throw new IllegalArgumentException("alias not found");
        }
        AndroidKeyStore androidKeyStore = androidKeyManager.PlaceComponentResult;
        Intrinsics.checkParameterIsNotNull(str, "");
        Key key = androidKeyStore.getAuthRequestContext.getKey(str, null);
        if (!(key instanceof SecretKey)) {
            key = null;
        }
        SecretKey secretKey = (SecretKey) key;
        if (secretKey != null) {
            return secretKey;
        }
        KeyStore.Entry entry = androidKeyStore.getAuthRequestContext.getEntry(str, null);
        if (!(entry instanceof KeyStore.SecretKeyEntry)) {
            throw new IllegalStateException("Entry is not a secret key entry");
        }
        SecretKey secretKey2 = ((KeyStore.SecretKeyEntry) entry).getSecretKey();
        Logger logger = Logger.PlaceComponentResult;
        Level level = Level.Debug;
        StringBuilder sb = new StringBuilder();
        sb.append("Return secret key for ");
        sb.append(str);
        Logger.MyBillsEntityDataFactory(level, sb.toString());
        return secretKey2;
    }
}
