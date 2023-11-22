package com.twilio.verify.data;

import com.twilio.security.crypto.KeyManager;
import com.twilio.security.crypto.KeyManagerKt;
import com.twilio.security.crypto.key.signer.Signer;
import com.twilio.security.logger.Level;
import com.twilio.security.logger.Logger;
import com.twilio.verify.TwilioVerifyException;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u000f¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u001f\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u001f\u0010\r\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\r\u0010\u000eR\u0014\u0010\u000b\u001a\u00020\u000f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\u0010"}, d2 = {"Lcom/twilio/verify/data/KeyStoreAdapter;", "Lcom/twilio/verify/data/KeyStorage;", "", "p0", "KClassImpl$Data$declaredNonStaticMembers$2", "(Ljava/lang/String;)Ljava/lang/String;", "", "MyBillsEntityDataFactory", "(Ljava/lang/String;)V", "p1", "", "getAuthRequestContext", "(Ljava/lang/String;Ljava/lang/String;)[B", "BuiltInFictitiousFunctionClassFactory", "(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;", "Lcom/twilio/security/crypto/KeyManager;", "Lcom/twilio/security/crypto/KeyManager;", "<init>", "(Lcom/twilio/security/crypto/KeyManager;)V"}, k = 1, mv = {1, 8, 0})
/* loaded from: classes3.dex */
public final class KeyStoreAdapter implements KeyStorage {
    private final KeyManager getAuthRequestContext;

    /* JADX WARN: Illegal instructions before constructor call */
    /* JADX WARN: Type inference failed for: r0v0, types: [kotlin.jvm.internal.DefaultConstructorMarker, com.twilio.security.crypto.KeyManager] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public KeyStoreAdapter() {
        /*
            r2 = this;
            r0 = 0
            r1 = 1
            r2.<init>(r0, r1, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.twilio.verify.data.KeyStoreAdapter.<init>():void");
    }

    private KeyStoreAdapter(KeyManager keyManager) {
        Intrinsics.checkParameterIsNotNull(keyManager, "");
        this.getAuthRequestContext = keyManager;
    }

    public /* synthetic */ KeyStoreAdapter(KeyManager keyManager, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? KeyManagerKt.PlaceComponentResult() : keyManager);
    }

    @Override // com.twilio.verify.data.KeyStorage
    public final String KClassImpl$Data$declaredNonStaticMembers$2(String p0) {
        Intrinsics.checkParameterIsNotNull(p0, "");
        try {
            return Base64EncoderKt.PlaceComponentResult(this.getAuthRequestContext.MyBillsEntityDataFactory(KeyStoreAdapterKt.KClassImpl$Data$declaredNonStaticMembers$2(p0, false)).MyBillsEntityDataFactory(), 2);
        } catch (Exception e) {
            Logger logger = Logger.PlaceComponentResult;
            Level level = Level.Error;
            String obj = e.toString();
            Exception exc = e;
            Logger.KClassImpl$Data$declaredNonStaticMembers$2(level, obj, exc);
            throw new TwilioVerifyException(exc, TwilioVerifyException.ErrorCode.KeyStorageError);
        }
    }

    @Override // com.twilio.verify.data.KeyStorage
    public final byte[] getAuthRequestContext(String p0, String p1) {
        Intrinsics.checkParameterIsNotNull(p0, "");
        Intrinsics.checkParameterIsNotNull(p1, "");
        try {
            Signer MyBillsEntityDataFactory = this.getAuthRequestContext.MyBillsEntityDataFactory(KeyStoreAdapterKt.getAuthRequestContext(p0));
            byte[] bytes = p1.getBytes(Charsets.UTF_8);
            Intrinsics.checkExpressionValueIsNotNull(bytes, "");
            return MyBillsEntityDataFactory.getAuthRequestContext(bytes);
        } catch (Exception e) {
            Logger logger = Logger.PlaceComponentResult;
            Level level = Level.Error;
            String obj = e.toString();
            Exception exc = e;
            Logger.KClassImpl$Data$declaredNonStaticMembers$2(level, obj, exc);
            throw new TwilioVerifyException(exc, TwilioVerifyException.ErrorCode.KeyStorageError);
        }
    }

    @Override // com.twilio.verify.data.KeyStorage
    public final String BuiltInFictitiousFunctionClassFactory(String p0, String p1) {
        Intrinsics.checkParameterIsNotNull(p0, "");
        Intrinsics.checkParameterIsNotNull(p1, "");
        try {
            return Base64EncoderKt.PlaceComponentResult(getAuthRequestContext(p0, p1), 2);
        } catch (TwilioVerifyException e) {
            throw e;
        } catch (Exception e2) {
            Logger logger = Logger.PlaceComponentResult;
            Level level = Level.Error;
            String obj = e2.toString();
            Exception exc = e2;
            Logger.KClassImpl$Data$declaredNonStaticMembers$2(level, obj, exc);
            throw new TwilioVerifyException(exc, TwilioVerifyException.ErrorCode.KeyStorageError);
        }
    }

    @Override // com.twilio.verify.data.KeyStorage
    public final void MyBillsEntityDataFactory(String p0) {
        Intrinsics.checkParameterIsNotNull(p0, "");
        try {
            this.getAuthRequestContext.PlaceComponentResult(p0);
        } catch (Exception e) {
            Logger logger = Logger.PlaceComponentResult;
            Level level = Level.Error;
            String obj = e.toString();
            Exception exc = e;
            Logger.KClassImpl$Data$declaredNonStaticMembers$2(level, obj, exc);
            throw new TwilioVerifyException(exc, TwilioVerifyException.ErrorCode.KeyStorageError);
        }
    }
}
