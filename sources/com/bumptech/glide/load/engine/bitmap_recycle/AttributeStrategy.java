package com.bumptech.glide.load.engine.bitmap_recycle;

import android.graphics.Bitmap;
import com.bumptech.glide.util.Util;

/* loaded from: classes3.dex */
class AttributeStrategy implements LruPoolStrategy {
    private final KeyPool KClassImpl$Data$declaredNonStaticMembers$2 = new KeyPool();
    private final GroupedLinkedMap<Key, Bitmap> PlaceComponentResult = new GroupedLinkedMap<>();

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.LruPoolStrategy
    public final void MyBillsEntityDataFactory(Bitmap bitmap) {
        KeyPool keyPool = this.KClassImpl$Data$declaredNonStaticMembers$2;
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        Bitmap.Config config = bitmap.getConfig();
        Object obj = (Poolable) keyPool.PlaceComponentResult.poll();
        if (obj == null) {
            obj = keyPool.KClassImpl$Data$declaredNonStaticMembers$2();
        }
        Key key = (Key) obj;
        key.BuiltInFictitiousFunctionClassFactory = width;
        key.PlaceComponentResult = height;
        key.MyBillsEntityDataFactory = config;
        this.PlaceComponentResult.MyBillsEntityDataFactory(key, bitmap);
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.LruPoolStrategy
    public final Bitmap getAuthRequestContext(int i, int i2, Bitmap.Config config) {
        KeyPool keyPool = this.KClassImpl$Data$declaredNonStaticMembers$2;
        Object obj = (Poolable) keyPool.PlaceComponentResult.poll();
        if (obj == null) {
            obj = keyPool.KClassImpl$Data$declaredNonStaticMembers$2();
        }
        Key key = (Key) obj;
        key.BuiltInFictitiousFunctionClassFactory = i;
        key.PlaceComponentResult = i2;
        key.MyBillsEntityDataFactory = config;
        return this.PlaceComponentResult.getAuthRequestContext(key);
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.LruPoolStrategy
    public final Bitmap KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.PlaceComponentResult.PlaceComponentResult();
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.LruPoolStrategy
    public final String BuiltInFictitiousFunctionClassFactory(int i, int i2, Bitmap.Config config) {
        return MyBillsEntityDataFactory(i, i2, config);
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.LruPoolStrategy
    public final int PlaceComponentResult(Bitmap bitmap) {
        return Util.getAuthRequestContext(bitmap);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("AttributeStrategy:\n  ");
        sb.append(this.PlaceComponentResult);
        return sb.toString();
    }

    static String MyBillsEntityDataFactory(int i, int i2, Bitmap.Config config) {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        sb.append(i);
        sb.append("x");
        sb.append(i2);
        sb.append("], ");
        sb.append(config);
        return sb.toString();
    }

    /* loaded from: classes3.dex */
    static class KeyPool extends BaseKeyPool<Key> {
        KeyPool() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.bumptech.glide.load.engine.bitmap_recycle.BaseKeyPool
        public final /* synthetic */ Key KClassImpl$Data$declaredNonStaticMembers$2() {
            return new Key(this);
        }
    }

    /* loaded from: classes3.dex */
    static class Key implements Poolable {
        int BuiltInFictitiousFunctionClassFactory;
        Bitmap.Config MyBillsEntityDataFactory;
        int PlaceComponentResult;
        private final KeyPool getAuthRequestContext;

        public Key(KeyPool keyPool) {
            this.getAuthRequestContext = keyPool;
        }

        public boolean equals(Object obj) {
            if (obj instanceof Key) {
                Key key = (Key) obj;
                return this.BuiltInFictitiousFunctionClassFactory == key.BuiltInFictitiousFunctionClassFactory && this.PlaceComponentResult == key.PlaceComponentResult && this.MyBillsEntityDataFactory == key.MyBillsEntityDataFactory;
            }
            return false;
        }

        public int hashCode() {
            int i = this.BuiltInFictitiousFunctionClassFactory;
            int i2 = this.PlaceComponentResult;
            Bitmap.Config config = this.MyBillsEntityDataFactory;
            return (((i * 31) + i2) * 31) + (config != null ? config.hashCode() : 0);
        }

        public String toString() {
            return AttributeStrategy.MyBillsEntityDataFactory(this.BuiltInFictitiousFunctionClassFactory, this.PlaceComponentResult, this.MyBillsEntityDataFactory);
        }

        @Override // com.bumptech.glide.load.engine.bitmap_recycle.Poolable
        public final void BuiltInFictitiousFunctionClassFactory() {
            KeyPool keyPool = this.getAuthRequestContext;
            if (keyPool.PlaceComponentResult.size() < 20) {
                keyPool.PlaceComponentResult.offer(this);
            }
        }
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.LruPoolStrategy
    public final String KClassImpl$Data$declaredNonStaticMembers$2(Bitmap bitmap) {
        return MyBillsEntityDataFactory(bitmap.getWidth(), bitmap.getHeight(), bitmap.getConfig());
    }
}
