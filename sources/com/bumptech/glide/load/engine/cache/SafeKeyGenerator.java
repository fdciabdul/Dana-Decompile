package com.bumptech.glide.load.engine.cache;

import androidx.core.util.Pools;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.util.LruCache;
import com.bumptech.glide.util.Preconditions;
import com.bumptech.glide.util.Util;
import com.bumptech.glide.util.pool.FactoryPools;
import com.bumptech.glide.util.pool.StateVerifier;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* loaded from: classes3.dex */
public class SafeKeyGenerator {
    private final LruCache<Key, String> PlaceComponentResult = new LruCache<>(1000);
    private final Pools.Pool<PoolableDigestContainer> MyBillsEntityDataFactory = FactoryPools.BuiltInFictitiousFunctionClassFactory(10, new FactoryPools.Factory<PoolableDigestContainer>() { // from class: com.bumptech.glide.load.engine.cache.SafeKeyGenerator.1
        @Override // com.bumptech.glide.util.pool.FactoryPools.Factory
        public final /* synthetic */ PoolableDigestContainer getAuthRequestContext() {
            return KClassImpl$Data$declaredNonStaticMembers$2();
        }

        private static PoolableDigestContainer KClassImpl$Data$declaredNonStaticMembers$2() {
            try {
                return new PoolableDigestContainer(MessageDigest.getInstance("SHA-256"));
            } catch (NoSuchAlgorithmException e) {
                throw new RuntimeException(e);
            }
        }
    });

    public final String MyBillsEntityDataFactory(Key key) {
        String MyBillsEntityDataFactory;
        synchronized (this.PlaceComponentResult) {
            MyBillsEntityDataFactory = this.PlaceComponentResult.MyBillsEntityDataFactory((LruCache<Key, String>) key);
        }
        if (MyBillsEntityDataFactory == null) {
            MyBillsEntityDataFactory = KClassImpl$Data$declaredNonStaticMembers$2(key);
        }
        synchronized (this.PlaceComponentResult) {
            this.PlaceComponentResult.getAuthRequestContext(key, MyBillsEntityDataFactory);
        }
        return MyBillsEntityDataFactory;
    }

    private String KClassImpl$Data$declaredNonStaticMembers$2(Key key) {
        PoolableDigestContainer poolableDigestContainer = (PoolableDigestContainer) Preconditions.PlaceComponentResult(this.MyBillsEntityDataFactory.BuiltInFictitiousFunctionClassFactory());
        try {
            key.getAuthRequestContext(poolableDigestContainer.MyBillsEntityDataFactory);
            return Util.PlaceComponentResult(poolableDigestContainer.MyBillsEntityDataFactory.digest());
        } finally {
            this.MyBillsEntityDataFactory.MyBillsEntityDataFactory(poolableDigestContainer);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static final class PoolableDigestContainer implements FactoryPools.Poolable {
        final MessageDigest MyBillsEntityDataFactory;
        private final StateVerifier getAuthRequestContext = StateVerifier.KClassImpl$Data$declaredNonStaticMembers$2();

        PoolableDigestContainer(MessageDigest messageDigest) {
            this.MyBillsEntityDataFactory = messageDigest;
        }

        @Override // com.bumptech.glide.util.pool.FactoryPools.Poolable
        public final StateVerifier d_() {
            return this.getAuthRequestContext;
        }
    }
}
