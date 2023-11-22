package com.twilio.security.crypto.key.template;

import android.security.keystore.KeyGenParameterSpec;
import com.google.android.gms.stats.CodePackage;
import io.split.android.client.storage.cipher.provider.SecureKeyStorageProvider;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0003\u001a\u00020\f\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u0004¢\u0006\u0004\b\u001b\u0010\u001cJ\u001a\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÖ\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\b\u001a\u00020\u0007HÖ\u0001¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0001H\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eR\u001a\u0010\u0012\u001a\u00020\f8\u0017X\u0096D¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u000eR\u001a\u0010\u0011\u001a\u00020\f8\u0017X\u0097\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u0010\u001a\u0004\b\u0014\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\f8\u0011X\u0091D¢\u0006\f\n\u0004\b\u0014\u0010\u0010\u001a\u0004\b\u0012\u0010\u000eR\u001a\u0010\u0013\u001a\u00020\u00158\u0011X\u0091\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0016\u001a\u0004\b\u000f\u0010\u0017R\u001a\u0010\u0014\u001a\u00020\u00048\u0017X\u0097\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u0018\u001a\u0004\b\u0013\u0010\u0019"}, d2 = {"Lcom/twilio/security/crypto/key/template/AESGCMNoPaddingCipherTemplate;", "Lcom/twilio/security/crypto/key/template/CipherTemplate;", "", "p0", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "NetworkUserEntityData$$ExternalSyntheticLambda0", "()Lcom/twilio/security/crypto/key/template/CipherTemplate;", "", "toString", "()Ljava/lang/String;", "BuiltInFictitiousFunctionClassFactory", "Ljava/lang/String;", "KClassImpl$Data$declaredNonStaticMembers$2", "PlaceComponentResult", "getAuthRequestContext", "MyBillsEntityDataFactory", "Landroid/security/keystore/KeyGenParameterSpec;", "Landroid/security/keystore/KeyGenParameterSpec;", "()Landroid/security/keystore/KeyGenParameterSpec;", "Z", "()Z", "p1", "<init>", "(Ljava/lang/String;Z)V"}, k = 1, mv = {1, 8, 0})
/* loaded from: classes3.dex */
public final /* data */ class AESGCMNoPaddingCipherTemplate extends CipherTemplate {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    private final String PlaceComponentResult;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    private final KeyGenParameterSpec getAuthRequestContext;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private final String BuiltInFictitiousFunctionClassFactory;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private final boolean MyBillsEntityDataFactory;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    private final String KClassImpl$Data$declaredNonStaticMembers$2;

    @Override // com.twilio.security.crypto.key.template.Template
    @JvmName(name = "MyBillsEntityDataFactory")
    /* renamed from: MyBillsEntityDataFactory  reason: from getter */
    public final String getKClassImpl$Data$declaredNonStaticMembers$2() {
        return this.KClassImpl$Data$declaredNonStaticMembers$2;
    }

    public /* synthetic */ AESGCMNoPaddingCipherTemplate(String str, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i & 2) != 0 ? true : z);
    }

    @Override // com.twilio.security.crypto.key.template.Template
    @JvmName(name = "getAuthRequestContext")
    /* renamed from: getAuthRequestContext  reason: from getter */
    public final boolean getMyBillsEntityDataFactory() {
        return this.MyBillsEntityDataFactory;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    private AESGCMNoPaddingCipherTemplate(String str, boolean z) {
        super(null);
        Intrinsics.checkParameterIsNotNull(str, "");
        this.KClassImpl$Data$declaredNonStaticMembers$2 = str;
        this.MyBillsEntityDataFactory = z;
        this.PlaceComponentResult = SecureKeyStorageProvider.ALGORITHM;
        KeyGenParameterSpec build = new KeyGenParameterSpec.Builder(str, 3).setBlockModes(CodePackage.GCM).setEncryptionPaddings("NoPadding").setKeySize(256).build();
        Intrinsics.checkExpressionValueIsNotNull(build, "");
        this.getAuthRequestContext = build;
        this.BuiltInFictitiousFunctionClassFactory = "AES/GCM/NoPadding";
    }

    @Override // com.twilio.security.crypto.key.template.Template
    @JvmName(name = "KClassImpl$Data$declaredNonStaticMembers$2")
    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from getter */
    public final String getPlaceComponentResult() {
        return this.PlaceComponentResult;
    }

    @Override // com.twilio.security.crypto.key.template.CipherTemplate
    @JvmName(name = "BuiltInFictitiousFunctionClassFactory")
    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from getter */
    public final KeyGenParameterSpec getGetAuthRequestContext() {
        return this.getAuthRequestContext;
    }

    @Override // com.twilio.security.crypto.key.template.CipherTemplate
    @JvmName(name = "PlaceComponentResult")
    /* renamed from: PlaceComponentResult  reason: from getter */
    public final String getBuiltInFictitiousFunctionClassFactory() {
        return this.BuiltInFictitiousFunctionClassFactory;
    }

    public final boolean equals(Object p0) {
        if (this != p0) {
            if (p0 instanceof AESGCMNoPaddingCipherTemplate) {
                AESGCMNoPaddingCipherTemplate aESGCMNoPaddingCipherTemplate = (AESGCMNoPaddingCipherTemplate) p0;
                return Intrinsics.areEqual(this.KClassImpl$Data$declaredNonStaticMembers$2, aESGCMNoPaddingCipherTemplate.KClassImpl$Data$declaredNonStaticMembers$2) && getMyBillsEntityDataFactory() == aESGCMNoPaddingCipherTemplate.getMyBillsEntityDataFactory();
            }
            return false;
        }
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v3 */
    public final int hashCode() {
        String str = this.KClassImpl$Data$declaredNonStaticMembers$2;
        int hashCode = str != null ? str.hashCode() : 0;
        boolean myBillsEntityDataFactory = getMyBillsEntityDataFactory();
        ?? r1 = myBillsEntityDataFactory;
        if (myBillsEntityDataFactory) {
            r1 = 1;
        }
        return (hashCode * 31) + r1;
    }

    @Override // com.twilio.security.crypto.key.template.CipherTemplate
    public final CipherTemplate NetworkUserEntityData$$ExternalSyntheticLambda0() {
        String str = this.KClassImpl$Data$declaredNonStaticMembers$2;
        Intrinsics.checkParameterIsNotNull(str, "");
        return new AESGCMNoPaddingCipherTemplate(str, false);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("AESGCMNoPaddingCipherTemplate(KClassImpl$Data$declaredNonStaticMembers$2=");
        sb.append(this.KClassImpl$Data$declaredNonStaticMembers$2);
        sb.append(", MyBillsEntityDataFactory=");
        sb.append(getMyBillsEntityDataFactory());
        sb.append(")");
        return sb.toString();
    }
}
