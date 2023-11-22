package androidx.core.hardware.fingerprint;

import android.hardware.fingerprint.FingerprintManager;
import java.security.Signature;
import javax.crypto.Cipher;
import javax.crypto.Mac;

@Deprecated
/* loaded from: classes6.dex */
public class FingerprintManagerCompat {

    /* loaded from: classes6.dex */
    public static abstract class AuthenticationCallback {
        public void BuiltInFictitiousFunctionClassFactory(int i, CharSequence charSequence) {
        }

        public void KClassImpl$Data$declaredNonStaticMembers$2(int i, CharSequence charSequence) {
        }

        public void KClassImpl$Data$declaredNonStaticMembers$2(AuthenticationResult authenticationResult) {
        }

        public void MyBillsEntityDataFactory() {
        }
    }

    static CryptoObject PlaceComponentResult(FingerprintManager.CryptoObject cryptoObject) {
        return Api23Impl.BuiltInFictitiousFunctionClassFactory(cryptoObject);
    }

    /* renamed from: androidx.core.hardware.fingerprint.FingerprintManagerCompat$1  reason: invalid class name */
    /* loaded from: classes6.dex */
    class AnonymousClass1 extends FingerprintManager.AuthenticationCallback {
        final /* synthetic */ AuthenticationCallback PlaceComponentResult;

        @Override // android.hardware.fingerprint.FingerprintManager.AuthenticationCallback
        public void onAuthenticationError(int i, CharSequence charSequence) {
            this.PlaceComponentResult.KClassImpl$Data$declaredNonStaticMembers$2(i, charSequence);
        }

        @Override // android.hardware.fingerprint.FingerprintManager.AuthenticationCallback
        public void onAuthenticationHelp(int i, CharSequence charSequence) {
            this.PlaceComponentResult.BuiltInFictitiousFunctionClassFactory(i, charSequence);
        }

        @Override // android.hardware.fingerprint.FingerprintManager.AuthenticationCallback
        public void onAuthenticationSucceeded(FingerprintManager.AuthenticationResult authenticationResult) {
            this.PlaceComponentResult.KClassImpl$Data$declaredNonStaticMembers$2(new AuthenticationResult(FingerprintManagerCompat.PlaceComponentResult(Api23Impl.KClassImpl$Data$declaredNonStaticMembers$2(authenticationResult))));
        }

        @Override // android.hardware.fingerprint.FingerprintManager.AuthenticationCallback
        public void onAuthenticationFailed() {
            this.PlaceComponentResult.MyBillsEntityDataFactory();
        }
    }

    /* loaded from: classes6.dex */
    public static class CryptoObject {
        private final Mac KClassImpl$Data$declaredNonStaticMembers$2;
        private final Signature MyBillsEntityDataFactory;
        private final Cipher getAuthRequestContext;

        public CryptoObject(Signature signature) {
            this.MyBillsEntityDataFactory = signature;
            this.getAuthRequestContext = null;
            this.KClassImpl$Data$declaredNonStaticMembers$2 = null;
        }

        public CryptoObject(Cipher cipher) {
            this.getAuthRequestContext = cipher;
            this.MyBillsEntityDataFactory = null;
            this.KClassImpl$Data$declaredNonStaticMembers$2 = null;
        }

        public CryptoObject(Mac mac) {
            this.KClassImpl$Data$declaredNonStaticMembers$2 = mac;
            this.getAuthRequestContext = null;
            this.MyBillsEntityDataFactory = null;
        }
    }

    /* loaded from: classes6.dex */
    public static final class AuthenticationResult {
        private final CryptoObject PlaceComponentResult;

        public AuthenticationResult(CryptoObject cryptoObject) {
            this.PlaceComponentResult = cryptoObject;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public static class Api23Impl {
        private Api23Impl() {
        }

        static FingerprintManager.CryptoObject KClassImpl$Data$declaredNonStaticMembers$2(Object obj) {
            return ((FingerprintManager.AuthenticationResult) obj).getCryptoObject();
        }

        public static CryptoObject BuiltInFictitiousFunctionClassFactory(Object obj) {
            FingerprintManager.CryptoObject cryptoObject = (FingerprintManager.CryptoObject) obj;
            if (cryptoObject == null) {
                return null;
            }
            if (cryptoObject.getCipher() != null) {
                return new CryptoObject(cryptoObject.getCipher());
            }
            if (cryptoObject.getSignature() != null) {
                return new CryptoObject(cryptoObject.getSignature());
            }
            if (cryptoObject.getMac() != null) {
                return new CryptoObject(cryptoObject.getMac());
            }
            return null;
        }
    }
}
