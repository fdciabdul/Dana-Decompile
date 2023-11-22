package com.twilio.security.storage;

import android.content.SharedPreferences;
import android.util.Base64;
import com.twilio.security.logger.Level;
import com.twilio.security.logger.Logger;
import com.twilio.security.storage.key.SecretKeyProvider;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\b\u001a\u00020\u0016\u0012\u0006\u0010\n\u001a\u00020\u0014\u0012\u0006\u0010\u001c\u001a\u00020\u0019¢\u0006\u0004\b\u001d\u0010\u001eJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J/\u0010\u000b\u001a\u00028\u0000\"\b\b\u0000\u0010\u0006*\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\f\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\tH\u0016¢\u0006\u0004\b\u000b\u0010\fJ-\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00000\r\"\b\b\u0000\u0010\u0006*\u00020\u00052\f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\tH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ1\u0010\u000e\u001a\u0004\u0018\u00018\u0000\"\b\b\u0000\u0010\u0006*\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\f\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\tH\u0002¢\u0006\u0004\b\u000e\u0010\fJ)\u0010\u000e\u001a\u00020\u0002\"\b\b\u0000\u0010\u0006*\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00028\u0000H\u0016¢\u0006\u0004\b\u000e\u0010\u0010J\u0017\u0010\u0003\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u0003\u0010\u0011J!\u0010\u000b\u001a\u00020\u0012\"\b\b\u0000\u0010\u0006*\u00020\u00052\u0006\u0010\b\u001a\u00028\u0000H\u0002¢\u0006\u0004\b\u000b\u0010\u0013R\u0014\u0010\u000b\u001a\u00020\u00148\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\u0015R\u0011\u0010\u0017\u001a\u00020\u0016X\u0016¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0011\u0010\u001b\u001a\u00020\u0019X\u0016¢\u0006\u0006\n\u0004\b\u0003\u0010\u001a"}, d2 = {"Lcom/twilio/security/storage/EncryptedPreferences;", "Lcom/twilio/security/storage/EncryptedStorage;", "", "BuiltInFictitiousFunctionClassFactory", "()V", "", "T", "", "p0", "Lkotlin/reflect/KClass;", "p1", "KClassImpl$Data$declaredNonStaticMembers$2", "(Ljava/lang/String;Lkotlin/reflect/KClass;)Ljava/lang/Object;", "", "getAuthRequestContext", "(Lkotlin/reflect/KClass;)Ljava/util/List;", "(Ljava/lang/String;Ljava/lang/Object;)V", "(Ljava/lang/String;)V", "", "(Ljava/lang/Object;)[B", "Landroid/content/SharedPreferences;", "Landroid/content/SharedPreferences;", "Lcom/twilio/security/storage/key/SecretKeyProvider;", "PlaceComponentResult", "Lcom/twilio/security/storage/key/SecretKeyProvider;", "Lcom/twilio/security/storage/Serializer;", "Lcom/twilio/security/storage/Serializer;", "MyBillsEntityDataFactory", "p2", "<init>", "(Lcom/twilio/security/storage/key/SecretKeyProvider;Landroid/content/SharedPreferences;Lcom/twilio/security/storage/Serializer;)V"}, k = 1, mv = {1, 8, 0})
/* loaded from: classes3.dex */
public final class EncryptedPreferences implements EncryptedStorage {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    public final Serializer MyBillsEntityDataFactory;
    private final SharedPreferences KClassImpl$Data$declaredNonStaticMembers$2;
    public final SecretKeyProvider PlaceComponentResult;

    public EncryptedPreferences(SecretKeyProvider secretKeyProvider, SharedPreferences sharedPreferences, Serializer serializer) {
        Intrinsics.checkParameterIsNotNull(secretKeyProvider, "");
        Intrinsics.checkParameterIsNotNull(sharedPreferences, "");
        Intrinsics.checkParameterIsNotNull(serializer, "");
        this.PlaceComponentResult = secretKeyProvider;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = sharedPreferences;
        this.MyBillsEntityDataFactory = serializer;
    }

    @Override // com.twilio.security.storage.EncryptedStorage
    public final <T> void getAuthRequestContext(String p0, T p1) throws StorageException {
        synchronized (this) {
            Intrinsics.checkParameterIsNotNull(p0, "");
            Intrinsics.checkParameterIsNotNull(p1, "");
            try {
                Logger logger = Logger.PlaceComponentResult;
                Level level = Level.Info;
                StringBuilder sb = new StringBuilder();
                sb.append("Saving ");
                sb.append(p0);
                Logger.MyBillsEntityDataFactory(level, sb.toString());
                byte[] authRequestContext = this.PlaceComponentResult.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2(p1));
                String authRequestContext2 = EncryptedPreferencesKt.getAuthRequestContext(p0);
                Logger logger2 = Logger.PlaceComponentResult;
                Level level2 = Level.Debug;
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Saving ");
                sb2.append(authRequestContext2);
                Logger.MyBillsEntityDataFactory(level2, sb2.toString());
                this.KClassImpl$Data$declaredNonStaticMembers$2.edit().putString(authRequestContext2, Base64.encodeToString(authRequestContext, 0)).apply();
                Logger logger3 = Logger.PlaceComponentResult;
                Level level3 = Level.Debug;
                StringBuilder sb3 = new StringBuilder();
                sb3.append("Saved ");
                sb3.append(authRequestContext2);
                Logger.MyBillsEntityDataFactory(level3, sb3.toString());
            } catch (Exception e) {
                Logger logger4 = Logger.PlaceComponentResult;
                Logger.KClassImpl$Data$declaredNonStaticMembers$2(Level.Error, e.toString(), e);
                throw new StorageException(e);
            }
        }
    }

    @Override // com.twilio.security.storage.EncryptedStorage
    public final <T> T KClassImpl$Data$declaredNonStaticMembers$2(String p0, KClass<T> p1) throws StorageException {
        Intrinsics.checkParameterIsNotNull(p0, "");
        Intrinsics.checkParameterIsNotNull(p1, "");
        try {
            Logger logger = Logger.PlaceComponentResult;
            Level level = Level.Info;
            StringBuilder sb = new StringBuilder();
            sb.append("Getting ");
            sb.append(p0);
            Logger.MyBillsEntityDataFactory(level, sb.toString());
            T t = (T) getAuthRequestContext(EncryptedPreferencesKt.getAuthRequestContext(p0), (KClass) p1);
            if (t != null) {
                return t;
            }
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Illegal decrypted data");
            Logger logger2 = Logger.PlaceComponentResult;
            Level level2 = Level.Debug;
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Return value ");
            sb2.append(illegalArgumentException);
            sb2.append(" for ");
            sb2.append(p0);
            Logger.MyBillsEntityDataFactory(level2, sb2.toString());
            throw illegalArgumentException;
        } catch (Exception e) {
            Logger logger3 = Logger.PlaceComponentResult;
            Logger.KClassImpl$Data$declaredNonStaticMembers$2(Level.Error, e.toString(), e);
            throw new StorageException(e);
        }
    }

    @Override // com.twilio.security.storage.EncryptedStorage
    public final <T> List<T> getAuthRequestContext(KClass<T> p0) throws StorageException {
        Object obj;
        Intrinsics.checkParameterIsNotNull(p0, "");
        try {
            Logger logger = Logger.PlaceComponentResult;
            Logger.MyBillsEntityDataFactory(Level.Info, "Getting all values");
            Map<String, ?> all = this.KClassImpl$Data$declaredNonStaticMembers$2.getAll();
            Intrinsics.checkExpressionValueIsNotNull(all, "");
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            for (Map.Entry<String, ?> entry : all.entrySet()) {
                if (entry.getValue() instanceof String) {
                    linkedHashMap.put(entry.getKey(), entry.getValue());
                }
            }
            ArrayList arrayList = new ArrayList();
            for (Map.Entry entry2 : linkedHashMap.entrySet()) {
                try {
                    Object key = entry2.getKey();
                    Intrinsics.checkExpressionValueIsNotNull(key, "");
                    obj = getAuthRequestContext((String) key, (KClass<Object>) p0);
                    Logger logger2 = Logger.PlaceComponentResult;
                    Level level = Level.Debug;
                    StringBuilder sb = new StringBuilder();
                    sb.append("Return value ");
                    sb.append(obj);
                    sb.append(" for key ");
                    sb.append((String) entry2.getKey());
                    Logger.MyBillsEntityDataFactory(level, sb.toString());
                } catch (Exception e) {
                    Logger logger3 = Logger.PlaceComponentResult;
                    Logger.KClassImpl$Data$declaredNonStaticMembers$2(Level.Error, e.toString(), e);
                    obj = null;
                }
                if (obj != null) {
                    arrayList.add(obj);
                }
            }
            ArrayList arrayList2 = arrayList;
            Logger logger4 = Logger.PlaceComponentResult;
            Logger.MyBillsEntityDataFactory(Level.Info, "Return all values");
            return arrayList2;
        } catch (Exception e2) {
            Logger logger5 = Logger.PlaceComponentResult;
            Logger.KClassImpl$Data$declaredNonStaticMembers$2(Level.Error, e2.toString(), e2);
            throw new StorageException(e2);
        }
    }

    @Override // com.twilio.security.storage.EncryptedStorage
    public final void BuiltInFictitiousFunctionClassFactory(String p0) {
        synchronized (this) {
            Intrinsics.checkParameterIsNotNull(p0, "");
            Logger logger = Logger.PlaceComponentResult;
            Level level = Level.Info;
            StringBuilder sb = new StringBuilder();
            sb.append("Removing ");
            sb.append(p0);
            Logger.MyBillsEntityDataFactory(level, sb.toString());
            this.KClassImpl$Data$declaredNonStaticMembers$2.edit().remove(EncryptedPreferencesKt.getAuthRequestContext(p0)).apply();
        }
    }

    @Override // com.twilio.security.storage.EncryptedStorage
    public final void BuiltInFictitiousFunctionClassFactory() {
        synchronized (this) {
            Logger logger = Logger.PlaceComponentResult;
            Logger.MyBillsEntityDataFactory(Level.Info, "Clearing storage");
            this.KClassImpl$Data$declaredNonStaticMembers$2.edit().clear().apply();
        }
    }

    private final <T> T getAuthRequestContext(String p0, KClass<T> p1) {
        Logger logger = Logger.PlaceComponentResult;
        Level level = Level.Debug;
        StringBuilder sb = new StringBuilder();
        sb.append("Getting value for ");
        sb.append(p0);
        Logger.MyBillsEntityDataFactory(level, sb.toString());
        String string = this.KClassImpl$Data$declaredNonStaticMembers$2.getString(p0, null);
        if (string == null) {
            throw new IllegalArgumentException("key not found");
        }
        Intrinsics.checkExpressionValueIsNotNull(string, "");
        SecretKeyProvider secretKeyProvider = this.PlaceComponentResult;
        byte[] decode = Base64.decode(string, 0);
        Intrinsics.checkExpressionValueIsNotNull(decode, "");
        T t = (T) this.MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2(secretKeyProvider.PlaceComponentResult(decode), p1);
        Logger logger2 = Logger.PlaceComponentResult;
        Level level2 = Level.Debug;
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Return value ");
        sb2.append(t);
        sb2.append(" for key ");
        sb2.append(p0);
        Logger.MyBillsEntityDataFactory(level2, sb2.toString());
        return t;
    }

    private final <T> byte[] KClassImpl$Data$declaredNonStaticMembers$2(T p0) {
        return this.MyBillsEntityDataFactory.MyBillsEntityDataFactory(p0);
    }
}
