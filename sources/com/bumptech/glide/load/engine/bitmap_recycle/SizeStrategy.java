package com.bumptech.glide.load.engine.bitmap_recycle;

import android.graphics.Bitmap;
import com.bumptech.glide.util.Util;
import java.util.NavigableMap;

/* loaded from: classes7.dex */
final class SizeStrategy implements LruPoolStrategy {
    private final KeyPool BuiltInFictitiousFunctionClassFactory = new KeyPool();
    private final GroupedLinkedMap<Key, Bitmap> getAuthRequestContext = new GroupedLinkedMap<>();
    private final NavigableMap<Integer, Integer> MyBillsEntityDataFactory = new PrettyPrintTreeMap();

    SizeStrategy() {
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.LruPoolStrategy
    public final void MyBillsEntityDataFactory(Bitmap bitmap) {
        Key authRequestContext = this.BuiltInFictitiousFunctionClassFactory.getAuthRequestContext(Util.getAuthRequestContext(bitmap));
        this.getAuthRequestContext.MyBillsEntityDataFactory(authRequestContext, bitmap);
        Integer num = (Integer) this.MyBillsEntityDataFactory.get(Integer.valueOf(authRequestContext.getAuthRequestContext));
        this.MyBillsEntityDataFactory.put(Integer.valueOf(authRequestContext.getAuthRequestContext), Integer.valueOf(num != null ? 1 + num.intValue() : 1));
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.LruPoolStrategy
    public final Bitmap getAuthRequestContext(int i, int i2, Bitmap.Config config) {
        int MyBillsEntityDataFactory = Util.MyBillsEntityDataFactory(i, i2, config);
        Key authRequestContext = this.BuiltInFictitiousFunctionClassFactory.getAuthRequestContext(MyBillsEntityDataFactory);
        Integer ceilingKey = this.MyBillsEntityDataFactory.ceilingKey(Integer.valueOf(MyBillsEntityDataFactory));
        if (ceilingKey != null && ceilingKey.intValue() != MyBillsEntityDataFactory && ceilingKey.intValue() <= MyBillsEntityDataFactory * 8) {
            KeyPool keyPool = this.BuiltInFictitiousFunctionClassFactory;
            if (keyPool.PlaceComponentResult.size() < 20) {
                keyPool.PlaceComponentResult.offer(authRequestContext);
            }
            authRequestContext = this.BuiltInFictitiousFunctionClassFactory.getAuthRequestContext(ceilingKey.intValue());
        }
        Bitmap authRequestContext2 = this.getAuthRequestContext.getAuthRequestContext(authRequestContext);
        if (authRequestContext2 != null) {
            authRequestContext2.reconfigure(i, i2, config);
            BuiltInFictitiousFunctionClassFactory(ceilingKey);
        }
        return authRequestContext2;
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.LruPoolStrategy
    public final Bitmap KClassImpl$Data$declaredNonStaticMembers$2() {
        Bitmap PlaceComponentResult = this.getAuthRequestContext.PlaceComponentResult();
        if (PlaceComponentResult != null) {
            BuiltInFictitiousFunctionClassFactory(Integer.valueOf(Util.getAuthRequestContext(PlaceComponentResult)));
        }
        return PlaceComponentResult;
    }

    private void BuiltInFictitiousFunctionClassFactory(Integer num) {
        Integer num2 = (Integer) this.MyBillsEntityDataFactory.get(num);
        if (num2.intValue() == 1) {
            this.MyBillsEntityDataFactory.remove(num);
        } else {
            this.MyBillsEntityDataFactory.put(num, Integer.valueOf(num2.intValue() - 1));
        }
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.LruPoolStrategy
    public final String BuiltInFictitiousFunctionClassFactory(int i, int i2, Bitmap.Config config) {
        return MyBillsEntityDataFactory(Util.MyBillsEntityDataFactory(i, i2, config));
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.LruPoolStrategy
    public final int PlaceComponentResult(Bitmap bitmap) {
        return Util.getAuthRequestContext(bitmap);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("SizeStrategy:\n  ");
        sb.append(this.getAuthRequestContext);
        sb.append("\n  SortedSizes");
        sb.append(this.MyBillsEntityDataFactory);
        return sb.toString();
    }

    static String MyBillsEntityDataFactory(int i) {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        sb.append(i);
        sb.append("]");
        return sb.toString();
    }

    /* loaded from: classes7.dex */
    static class KeyPool extends BaseKeyPool<Key> {
        KeyPool() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.bumptech.glide.load.engine.bitmap_recycle.BaseKeyPool
        public final /* synthetic */ Key KClassImpl$Data$declaredNonStaticMembers$2() {
            return new Key(this);
        }

        public final Key getAuthRequestContext(int i) {
            Object obj = (Poolable) this.PlaceComponentResult.poll();
            if (obj == null) {
                obj = KClassImpl$Data$declaredNonStaticMembers$2();
            }
            Key key = (Key) obj;
            key.getAuthRequestContext = i;
            return key;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes7.dex */
    public static final class Key implements Poolable {
        private final KeyPool PlaceComponentResult;
        int getAuthRequestContext;

        Key(KeyPool keyPool) {
            this.PlaceComponentResult = keyPool;
        }

        public final boolean equals(Object obj) {
            return (obj instanceof Key) && this.getAuthRequestContext == ((Key) obj).getAuthRequestContext;
        }

        public final int hashCode() {
            return this.getAuthRequestContext;
        }

        public final String toString() {
            return SizeStrategy.MyBillsEntityDataFactory(this.getAuthRequestContext);
        }

        @Override // com.bumptech.glide.load.engine.bitmap_recycle.Poolable
        public final void BuiltInFictitiousFunctionClassFactory() {
            KeyPool keyPool = this.PlaceComponentResult;
            if (keyPool.PlaceComponentResult.size() < 20) {
                keyPool.PlaceComponentResult.offer(this);
            }
        }
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.LruPoolStrategy
    public final String KClassImpl$Data$declaredNonStaticMembers$2(Bitmap bitmap) {
        return MyBillsEntityDataFactory(Util.getAuthRequestContext(bitmap));
    }
}
