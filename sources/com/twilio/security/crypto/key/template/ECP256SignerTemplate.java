package com.twilio.security.crypto.key.template;

import android.security.keystore.KeyGenParameterSpec;
import java.security.spec.ECGenParameterSpec;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0003\u001a\u00020\n\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0004¢\u0006\u0004\b\u0019\u0010\u001aJ\u001a\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÖ\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\b\u001a\u00020\u0007HÖ\u0001¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u000b\u001a\u00020\nHÖ\u0001¢\u0006\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\u00020\n8\u0017X\u0096D¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\r\u0010\fR\u001a\u0010\u000f\u001a\u00020\n8\u0017X\u0097\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u000e\u001a\u0004\b\u0010\u0010\fR\u001a\u0010\u0015\u001a\u00020\u00118\u0011X\u0091\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0010\u001a\u00020\u00048\u0017X\u0097\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u0016\u001a\u0004\b\u000f\u0010\u0017R\u001a\u0010\u0013\u001a\u00020\n8\u0011X\u0091D¢\u0006\f\n\u0004\b\u0015\u0010\u000e\u001a\u0004\b\u0015\u0010\f"}, d2 = {"Lcom/twilio/security/crypto/key/template/ECP256SignerTemplate;", "Lcom/twilio/security/crypto/key/template/SignerTemplate;", "", "p0", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "KClassImpl$Data$declaredNonStaticMembers$2", "Ljava/lang/String;", "getAuthRequestContext", "MyBillsEntityDataFactory", "Landroid/security/keystore/KeyGenParameterSpec;", "Landroid/security/keystore/KeyGenParameterSpec;", "PlaceComponentResult", "()Landroid/security/keystore/KeyGenParameterSpec;", "BuiltInFictitiousFunctionClassFactory", "Z", "()Z", "p1", "<init>", "(Ljava/lang/String;Z)V"}, k = 1, mv = {1, 8, 0})
/* loaded from: classes3.dex */
public final /* data */ class ECP256SignerTemplate extends SignerTemplate {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    private final String PlaceComponentResult;
    private final String KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private final KeyGenParameterSpec BuiltInFictitiousFunctionClassFactory;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private final boolean MyBillsEntityDataFactory;
    private final String getAuthRequestContext;

    @Override // com.twilio.security.crypto.key.template.Template
    @JvmName(name = "MyBillsEntityDataFactory")
    /* renamed from: MyBillsEntityDataFactory  reason: from getter */
    public final String getGetAuthRequestContext() {
        return this.getAuthRequestContext;
    }

    @Override // com.twilio.security.crypto.key.template.Template
    @JvmName(name = "getAuthRequestContext")
    /* renamed from: getAuthRequestContext  reason: from getter */
    public final boolean getMyBillsEntityDataFactory() {
        return this.MyBillsEntityDataFactory;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ECP256SignerTemplate(String str, boolean z) {
        super(null);
        Intrinsics.checkParameterIsNotNull(str, "");
        this.getAuthRequestContext = str;
        this.MyBillsEntityDataFactory = z;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = "EC";
        KeyGenParameterSpec build = new KeyGenParameterSpec.Builder(this.getAuthRequestContext, 4).setAlgorithmParameterSpec(new ECGenParameterSpec("secp256r1")).setDigests("SHA-256").build();
        Intrinsics.checkExpressionValueIsNotNull(build, "");
        this.BuiltInFictitiousFunctionClassFactory = build;
        this.PlaceComponentResult = "SHA256withECDSA";
    }

    @Override // com.twilio.security.crypto.key.template.Template
    @JvmName(name = "KClassImpl$Data$declaredNonStaticMembers$2")
    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from getter */
    public final String getKClassImpl$Data$declaredNonStaticMembers$2() {
        return this.KClassImpl$Data$declaredNonStaticMembers$2;
    }

    @Override // com.twilio.security.crypto.key.template.SignerTemplate
    @JvmName(name = "PlaceComponentResult")
    /* renamed from: PlaceComponentResult  reason: from getter */
    public final KeyGenParameterSpec getBuiltInFictitiousFunctionClassFactory() {
        return this.BuiltInFictitiousFunctionClassFactory;
    }

    @Override // com.twilio.security.crypto.key.template.SignerTemplate
    @JvmName(name = "BuiltInFictitiousFunctionClassFactory")
    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from getter */
    public final String getPlaceComponentResult() {
        return this.PlaceComponentResult;
    }

    public final boolean equals(Object p0) {
        if (this != p0) {
            if (p0 instanceof ECP256SignerTemplate) {
                ECP256SignerTemplate eCP256SignerTemplate = (ECP256SignerTemplate) p0;
                return Intrinsics.areEqual(this.getAuthRequestContext, eCP256SignerTemplate.getAuthRequestContext) && getMyBillsEntityDataFactory() == eCP256SignerTemplate.getMyBillsEntityDataFactory();
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
        String str = this.getAuthRequestContext;
        int hashCode = str != null ? str.hashCode() : 0;
        boolean myBillsEntityDataFactory = getMyBillsEntityDataFactory();
        ?? r1 = myBillsEntityDataFactory;
        if (myBillsEntityDataFactory) {
            r1 = 1;
        }
        return (hashCode * 31) + r1;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ECP256SignerTemplate(getAuthRequestContext=");
        sb.append(this.getAuthRequestContext);
        sb.append(", MyBillsEntityDataFactory=");
        sb.append(getMyBillsEntityDataFactory());
        sb.append(")");
        return sb.toString();
    }
}
