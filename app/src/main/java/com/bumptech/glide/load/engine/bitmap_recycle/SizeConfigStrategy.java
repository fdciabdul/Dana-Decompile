package com.bumptech.glide.load.engine.bitmap_recycle;

import android.graphics.Bitmap;
import android.os.Build;
import com.bumptech.glide.util.Util;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;

/* loaded from: classes3.dex */
public class SizeConfigStrategy implements LruPoolStrategy {
    private static final Bitmap.Config[] BuiltInFictitiousFunctionClassFactory;
    private static final Bitmap.Config[] KClassImpl$Data$declaredNonStaticMembers$2;
    private static final Bitmap.Config[] MyBillsEntityDataFactory;
    private static final Bitmap.Config[] PlaceComponentResult;
    private static final Bitmap.Config[] getAuthRequestContext;
    private final KeyPool NetworkUserEntityData$$ExternalSyntheticLambda0 = new KeyPool();
    private final GroupedLinkedMap<Key, Bitmap> lookAheadTest = new GroupedLinkedMap<>();
    private final Map<Bitmap.Config, NavigableMap<Integer, Integer>> scheduleImpl = new HashMap();

    static {
        Bitmap.Config[] configArr = {Bitmap.Config.ARGB_8888, null};
        if (Build.VERSION.SDK_INT >= 26) {
            configArr = (Bitmap.Config[]) Arrays.copyOf(configArr, 3);
            configArr[configArr.length - 1] = Bitmap.Config.RGBA_F16;
        }
        PlaceComponentResult = configArr;
        getAuthRequestContext = configArr;
        MyBillsEntityDataFactory = new Bitmap.Config[]{Bitmap.Config.RGB_565};
        BuiltInFictitiousFunctionClassFactory = new Bitmap.Config[]{Bitmap.Config.ARGB_4444};
        KClassImpl$Data$declaredNonStaticMembers$2 = new Bitmap.Config[]{Bitmap.Config.ALPHA_8};
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.LruPoolStrategy
    public final void MyBillsEntityDataFactory(Bitmap bitmap) {
        int authRequestContext = Util.getAuthRequestContext(bitmap);
        KeyPool keyPool = this.NetworkUserEntityData$$ExternalSyntheticLambda0;
        Bitmap.Config config = bitmap.getConfig();
        Object obj = (Poolable) keyPool.PlaceComponentResult.poll();
        if (obj == null) {
            obj = keyPool.KClassImpl$Data$declaredNonStaticMembers$2();
        }
        Key key = (Key) obj;
        key.KClassImpl$Data$declaredNonStaticMembers$2 = authRequestContext;
        key.BuiltInFictitiousFunctionClassFactory = config;
        this.lookAheadTest.MyBillsEntityDataFactory(key, bitmap);
        NavigableMap<Integer, Integer> MyBillsEntityDataFactory2 = MyBillsEntityDataFactory(bitmap.getConfig());
        Integer num = (Integer) MyBillsEntityDataFactory2.get(Integer.valueOf(key.KClassImpl$Data$declaredNonStaticMembers$2));
        MyBillsEntityDataFactory2.put(Integer.valueOf(key.KClassImpl$Data$declaredNonStaticMembers$2), Integer.valueOf(num != null ? 1 + num.intValue() : 1));
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.LruPoolStrategy
    public final Bitmap getAuthRequestContext(int i, int i2, Bitmap.Config config) {
        Bitmap.Config[] configArr;
        int MyBillsEntityDataFactory2 = Util.MyBillsEntityDataFactory(i, i2, config);
        KeyPool keyPool = this.NetworkUserEntityData$$ExternalSyntheticLambda0;
        Object obj = (Poolable) keyPool.PlaceComponentResult.poll();
        if (obj == null) {
            obj = keyPool.KClassImpl$Data$declaredNonStaticMembers$2();
        }
        Key key = (Key) obj;
        key.KClassImpl$Data$declaredNonStaticMembers$2 = MyBillsEntityDataFactory2;
        key.BuiltInFictitiousFunctionClassFactory = config;
        int i3 = 0;
        if (Build.VERSION.SDK_INT >= 26 && Bitmap.Config.RGBA_F16.equals(config)) {
            configArr = getAuthRequestContext;
        } else {
            int i4 = AnonymousClass1.KClassImpl$Data$declaredNonStaticMembers$2[config.ordinal()];
            if (i4 == 1) {
                configArr = PlaceComponentResult;
            } else if (i4 == 2) {
                configArr = MyBillsEntityDataFactory;
            } else if (i4 == 3) {
                configArr = BuiltInFictitiousFunctionClassFactory;
            } else {
                configArr = i4 != 4 ? new Bitmap.Config[]{config} : KClassImpl$Data$declaredNonStaticMembers$2;
            }
        }
        int length = configArr.length;
        while (true) {
            if (i3 >= length) {
                break;
            }
            Bitmap.Config config2 = configArr[i3];
            Integer ceilingKey = MyBillsEntityDataFactory(config2).ceilingKey(Integer.valueOf(MyBillsEntityDataFactory2));
            if (ceilingKey == null || ceilingKey.intValue() > MyBillsEntityDataFactory2 * 8) {
                i3++;
            } else if (ceilingKey.intValue() != MyBillsEntityDataFactory2 || (config2 != null ? !config2.equals(config) : config != null)) {
                KeyPool keyPool2 = this.NetworkUserEntityData$$ExternalSyntheticLambda0;
                if (keyPool2.PlaceComponentResult.size() < 20) {
                    keyPool2.PlaceComponentResult.offer(key);
                }
                KeyPool keyPool3 = this.NetworkUserEntityData$$ExternalSyntheticLambda0;
                int intValue = ceilingKey.intValue();
                Object obj2 = (Poolable) keyPool3.PlaceComponentResult.poll();
                if (obj2 == null) {
                    obj2 = keyPool3.KClassImpl$Data$declaredNonStaticMembers$2();
                }
                key = (Key) obj2;
                key.KClassImpl$Data$declaredNonStaticMembers$2 = intValue;
                key.BuiltInFictitiousFunctionClassFactory = config2;
            }
        }
        Bitmap authRequestContext = this.lookAheadTest.getAuthRequestContext(key);
        if (authRequestContext != null) {
            MyBillsEntityDataFactory(Integer.valueOf(key.KClassImpl$Data$declaredNonStaticMembers$2), authRequestContext);
            authRequestContext.reconfigure(i, i2, config);
        }
        return authRequestContext;
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.LruPoolStrategy
    public final Bitmap KClassImpl$Data$declaredNonStaticMembers$2() {
        Bitmap PlaceComponentResult2 = this.lookAheadTest.PlaceComponentResult();
        if (PlaceComponentResult2 != null) {
            MyBillsEntityDataFactory(Integer.valueOf(Util.getAuthRequestContext(PlaceComponentResult2)), PlaceComponentResult2);
        }
        return PlaceComponentResult2;
    }

    private void MyBillsEntityDataFactory(Integer num, Bitmap bitmap) {
        NavigableMap<Integer, Integer> MyBillsEntityDataFactory2 = MyBillsEntityDataFactory(bitmap.getConfig());
        Integer num2 = (Integer) MyBillsEntityDataFactory2.get(num);
        if (num2 == null) {
            StringBuilder sb = new StringBuilder();
            sb.append("Tried to decrement empty size, size: ");
            sb.append(num);
            sb.append(", removed: ");
            sb.append(getAuthRequestContext(Util.getAuthRequestContext(bitmap), bitmap.getConfig()));
            sb.append(", this: ");
            sb.append(this);
            throw new NullPointerException(sb.toString());
        } else if (num2.intValue() == 1) {
            MyBillsEntityDataFactory2.remove(num);
        } else {
            MyBillsEntityDataFactory2.put(num, Integer.valueOf(num2.intValue() - 1));
        }
    }

    private NavigableMap<Integer, Integer> MyBillsEntityDataFactory(Bitmap.Config config) {
        NavigableMap<Integer, Integer> navigableMap = this.scheduleImpl.get(config);
        if (navigableMap == null) {
            TreeMap treeMap = new TreeMap();
            this.scheduleImpl.put(config, treeMap);
            return treeMap;
        }
        return navigableMap;
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.LruPoolStrategy
    public final String KClassImpl$Data$declaredNonStaticMembers$2(Bitmap bitmap) {
        return getAuthRequestContext(Util.getAuthRequestContext(bitmap), bitmap.getConfig());
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.LruPoolStrategy
    public final String BuiltInFictitiousFunctionClassFactory(int i, int i2, Bitmap.Config config) {
        return getAuthRequestContext(Util.MyBillsEntityDataFactory(i, i2, config), config);
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.LruPoolStrategy
    public final int PlaceComponentResult(Bitmap bitmap) {
        return Util.getAuthRequestContext(bitmap);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("SizeConfigStrategy{groupedMap=");
        sb.append(this.lookAheadTest);
        sb.append(", sortedSizes=(");
        for (Map.Entry<Bitmap.Config, NavigableMap<Integer, Integer>> entry : this.scheduleImpl.entrySet()) {
            sb.append(entry.getKey());
            sb.append('[');
            sb.append(entry.getValue());
            sb.append("], ");
        }
        if (!this.scheduleImpl.isEmpty()) {
            sb.replace(sb.length() - 2, sb.length(), "");
        }
        sb.append(")}");
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
    static final class Key implements Poolable {
        Bitmap.Config BuiltInFictitiousFunctionClassFactory;
        int KClassImpl$Data$declaredNonStaticMembers$2;
        private final KeyPool MyBillsEntityDataFactory;

        public Key(KeyPool keyPool) {
            this.MyBillsEntityDataFactory = keyPool;
        }

        @Override // com.bumptech.glide.load.engine.bitmap_recycle.Poolable
        public final void BuiltInFictitiousFunctionClassFactory() {
            KeyPool keyPool = this.MyBillsEntityDataFactory;
            if (keyPool.PlaceComponentResult.size() < 20) {
                keyPool.PlaceComponentResult.offer(this);
            }
        }

        public final String toString() {
            return SizeConfigStrategy.getAuthRequestContext(this.KClassImpl$Data$declaredNonStaticMembers$2, this.BuiltInFictitiousFunctionClassFactory);
        }

        public final boolean equals(Object obj) {
            if (obj instanceof Key) {
                Key key = (Key) obj;
                return this.KClassImpl$Data$declaredNonStaticMembers$2 == key.KClassImpl$Data$declaredNonStaticMembers$2 && Util.BuiltInFictitiousFunctionClassFactory(this.BuiltInFictitiousFunctionClassFactory, key.BuiltInFictitiousFunctionClassFactory);
            }
            return false;
        }

        public final int hashCode() {
            int i = this.KClassImpl$Data$declaredNonStaticMembers$2;
            Bitmap.Config config = this.BuiltInFictitiousFunctionClassFactory;
            return (i * 31) + (config != null ? config.hashCode() : 0);
        }
    }

    static String getAuthRequestContext(int i, Bitmap.Config config) {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        sb.append(i);
        sb.append("](");
        sb.append(config);
        sb.append(")");
        return sb.toString();
    }

    /* renamed from: com.bumptech.glide.load.engine.bitmap_recycle.SizeConfigStrategy$1  reason: invalid class name */
    /* loaded from: classes3.dex */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] KClassImpl$Data$declaredNonStaticMembers$2;

        static {
            int[] iArr = new int[Bitmap.Config.values().length];
            KClassImpl$Data$declaredNonStaticMembers$2 = iArr;
            try {
                iArr[Bitmap.Config.ARGB_8888.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                KClassImpl$Data$declaredNonStaticMembers$2[Bitmap.Config.RGB_565.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                KClassImpl$Data$declaredNonStaticMembers$2[Bitmap.Config.ARGB_4444.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                KClassImpl$Data$declaredNonStaticMembers$2[Bitmap.Config.ALPHA_8.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }
}
