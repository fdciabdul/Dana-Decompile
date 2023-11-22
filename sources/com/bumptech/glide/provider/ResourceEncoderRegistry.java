package com.bumptech.glide.provider;

import com.bumptech.glide.load.ResourceEncoder;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes3.dex */
public class ResourceEncoderRegistry {
    private final List<Entry<?>> PlaceComponentResult = new ArrayList();

    public final <Z> void PlaceComponentResult(Class<Z> cls, ResourceEncoder<Z> resourceEncoder) {
        synchronized (this) {
            this.PlaceComponentResult.add(new Entry<>(cls, resourceEncoder));
        }
    }

    public final <Z> ResourceEncoder<Z> KClassImpl$Data$declaredNonStaticMembers$2(Class<Z> cls) {
        synchronized (this) {
            int size = this.PlaceComponentResult.size();
            for (int i = 0; i < size; i++) {
                Entry<?> entry = this.PlaceComponentResult.get(i);
                if (entry.MyBillsEntityDataFactory(cls)) {
                    return (ResourceEncoder<Z>) entry.KClassImpl$Data$declaredNonStaticMembers$2;
                }
            }
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static final class Entry<T> {
        final ResourceEncoder<T> KClassImpl$Data$declaredNonStaticMembers$2;
        private final Class<T> PlaceComponentResult;

        Entry(Class<T> cls, ResourceEncoder<T> resourceEncoder) {
            this.PlaceComponentResult = cls;
            this.KClassImpl$Data$declaredNonStaticMembers$2 = resourceEncoder;
        }

        final boolean MyBillsEntityDataFactory(Class<?> cls) {
            return this.PlaceComponentResult.isAssignableFrom(cls);
        }
    }
}
