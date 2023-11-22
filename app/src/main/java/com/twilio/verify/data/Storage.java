package com.twilio.verify.data;

import android.content.SharedPreferences;
import com.twilio.security.storage.EncryptedStorage;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0006\u001a\u00020\u0015\u0012\u0006\u0010\f\u001a\u00020\u000f\u0012\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00120\t¢\u0006\u0004\b\u001a\u0010\u001bJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u0019\u0010\u0007\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00050\tH\u0016¢\u0006\u0004\b\u0007\u0010\nJ\u0017\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0003\u0010\u000bJ\u001f\u0010\r\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\r\u0010\u000eR\u0014\u0010\u0011\u001a\u00020\u000f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\u0010R\u001a\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00120\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u0013R\u0014\u0010\r\u001a\u00020\u00158\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0016R\u0012\u0010\u0007\u001a\u00020\u0017X\u0096@¢\u0006\u0006\n\u0004\b\u0003\u0010\u0018"}, d2 = {"Lcom/twilio/verify/data/Storage;", "Lcom/twilio/verify/data/StorageProvider;", "", "KClassImpl$Data$declaredNonStaticMembers$2", "()V", "", "p0", "getAuthRequestContext", "(Ljava/lang/String;)Ljava/lang/String;", "", "()Ljava/util/List;", "(Ljava/lang/String;)V", "p1", "MyBillsEntityDataFactory", "(Ljava/lang/String;Ljava/lang/String;)V", "Lcom/twilio/security/storage/EncryptedStorage;", "Lcom/twilio/security/storage/EncryptedStorage;", "PlaceComponentResult", "Lcom/twilio/verify/data/Migration;", "Ljava/util/List;", "BuiltInFictitiousFunctionClassFactory", "Landroid/content/SharedPreferences;", "Landroid/content/SharedPreferences;", "", "I", "p2", "<init>", "(Landroid/content/SharedPreferences;Lcom/twilio/security/storage/EncryptedStorage;Ljava/util/List;)V"}, k = 1, mv = {1, 8, 0})
/* loaded from: classes.dex */
public final class Storage implements StorageProvider {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    private final SharedPreferences MyBillsEntityDataFactory;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    public final int getAuthRequestContext;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private final List<Migration> BuiltInFictitiousFunctionClassFactory;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    private final EncryptedStorage PlaceComponentResult;

    /* JADX WARN: Multi-variable type inference failed */
    public Storage(SharedPreferences sharedPreferences, EncryptedStorage encryptedStorage, List<? extends Migration> list) {
        Intrinsics.checkParameterIsNotNull(sharedPreferences, "");
        Intrinsics.checkParameterIsNotNull(encryptedStorage, "");
        Intrinsics.checkParameterIsNotNull(list, "");
        this.MyBillsEntityDataFactory = sharedPreferences;
        this.PlaceComponentResult = encryptedStorage;
        this.BuiltInFictitiousFunctionClassFactory = list;
        this.getAuthRequestContext = 2;
        int i = sharedPreferences.getInt("cv", 1);
        if (i != this.getAuthRequestContext) {
            for (Migration migration : this.BuiltInFictitiousFunctionClassFactory) {
                if (migration.KClassImpl$Data$declaredNonStaticMembers$2() >= i) {
                    for (Entry entry : migration.KClassImpl$Data$declaredNonStaticMembers$2(getAuthRequestContext())) {
                        String str = entry.BuiltInFictitiousFunctionClassFactory;
                        String str2 = entry.MyBillsEntityDataFactory;
                        Intrinsics.checkParameterIsNotNull(str, "");
                        Intrinsics.checkParameterIsNotNull(str2, "");
                        this.PlaceComponentResult.getAuthRequestContext(str, str2);
                    }
                    this.MyBillsEntityDataFactory.edit().putInt("cv", migration.BuiltInFictitiousFunctionClassFactory()).apply();
                    i = migration.BuiltInFictitiousFunctionClassFactory();
                    if (i == this.getAuthRequestContext) {
                        return;
                    }
                }
            }
        }
    }

    @Override // com.twilio.verify.data.StorageProvider
    public final void MyBillsEntityDataFactory(String p0, String p1) {
        Intrinsics.checkParameterIsNotNull(p0, "");
        Intrinsics.checkParameterIsNotNull(p1, "");
        this.PlaceComponentResult.getAuthRequestContext(p0, p1);
    }

    @Override // com.twilio.verify.data.StorageProvider
    public final String getAuthRequestContext(String p0) {
        Intrinsics.checkParameterIsNotNull(p0, "");
        try {
            return (String) this.PlaceComponentResult.KClassImpl$Data$declaredNonStaticMembers$2(p0, Reflection.getOrCreateKotlinClass(String.class));
        } catch (Exception unused) {
            return null;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:4:0x0015, code lost:
    
        if ((!r0.isEmpty()) != false) goto L7;
     */
    @Override // com.twilio.verify.data.StorageProvider
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.util.List<java.lang.String> getAuthRequestContext() {
        /*
            r2 = this;
            com.twilio.security.storage.EncryptedStorage r0 = r2.PlaceComponentResult     // Catch: java.lang.Exception -> L18
            java.lang.Class<java.lang.String> r1 = java.lang.String.class
            kotlin.reflect.KClass r1 = kotlin.jvm.internal.Reflection.getOrCreateKotlinClass(r1)     // Catch: java.lang.Exception -> L18
            java.util.List r0 = r0.getAuthRequestContext(r1)     // Catch: java.lang.Exception -> L18
            r1 = r0
            java.util.Collection r1 = (java.util.Collection) r1     // Catch: java.lang.Exception -> L18
            boolean r1 = r1.isEmpty()     // Catch: java.lang.Exception -> L18
            r1 = r1 ^ 1
            if (r1 == 0) goto L18
            goto L19
        L18:
            r0 = 0
        L19:
            if (r0 != 0) goto L1f
            java.util.List r0 = kotlin.collections.CollectionsKt.emptyList()
        L1f:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.twilio.verify.data.Storage.getAuthRequestContext():java.util.List");
    }

    @Override // com.twilio.verify.data.StorageProvider
    public final void KClassImpl$Data$declaredNonStaticMembers$2(String p0) {
        Intrinsics.checkParameterIsNotNull(p0, "");
        this.PlaceComponentResult.BuiltInFictitiousFunctionClassFactory(p0);
    }

    @Override // com.twilio.verify.data.StorageProvider
    public final void KClassImpl$Data$declaredNonStaticMembers$2() {
        this.PlaceComponentResult.BuiltInFictitiousFunctionClassFactory();
    }
}
