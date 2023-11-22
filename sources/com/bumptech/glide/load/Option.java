package com.bumptech.glide.load;

import com.bumptech.glide.util.Preconditions;
import java.security.MessageDigest;

/* loaded from: classes3.dex */
public final class Option<T> {
    private static final CacheKeyUpdater<Object> getAuthRequestContext = new CacheKeyUpdater<Object>() { // from class: com.bumptech.glide.load.Option.1
        @Override // com.bumptech.glide.load.Option.CacheKeyUpdater
        public final void KClassImpl$Data$declaredNonStaticMembers$2(byte[] bArr, Object obj, MessageDigest messageDigest) {
        }
    };
    private volatile byte[] BuiltInFictitiousFunctionClassFactory;
    final CacheKeyUpdater<T> KClassImpl$Data$declaredNonStaticMembers$2;
    private final String MyBillsEntityDataFactory;
    public final T PlaceComponentResult;

    /* loaded from: classes3.dex */
    public interface CacheKeyUpdater<T> {
        void KClassImpl$Data$declaredNonStaticMembers$2(byte[] bArr, T t, MessageDigest messageDigest);
    }

    public static <T> Option<T> MyBillsEntityDataFactory(String str) {
        return new Option<>(str, null, getAuthRequestContext);
    }

    public static <T> Option<T> PlaceComponentResult(String str, T t) {
        return new Option<>(str, t, getAuthRequestContext);
    }

    public static <T> Option<T> getAuthRequestContext(String str, T t, CacheKeyUpdater<T> cacheKeyUpdater) {
        return new Option<>(str, t, cacheKeyUpdater);
    }

    private Option(String str, T t, CacheKeyUpdater<T> cacheKeyUpdater) {
        this.MyBillsEntityDataFactory = Preconditions.getAuthRequestContext(str);
        this.PlaceComponentResult = t;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = (CacheKeyUpdater) Preconditions.PlaceComponentResult(cacheKeyUpdater);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final byte[] PlaceComponentResult() {
        if (this.BuiltInFictitiousFunctionClassFactory == null) {
            this.BuiltInFictitiousFunctionClassFactory = this.MyBillsEntityDataFactory.getBytes(Key.MyBillsEntityDataFactory);
        }
        return this.BuiltInFictitiousFunctionClassFactory;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof Option) {
            return this.MyBillsEntityDataFactory.equals(((Option) obj).MyBillsEntityDataFactory);
        }
        return false;
    }

    public final int hashCode() {
        return this.MyBillsEntityDataFactory.hashCode();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Option{key='");
        sb.append(this.MyBillsEntityDataFactory);
        sb.append('\'');
        sb.append('}');
        return sb.toString();
    }
}
