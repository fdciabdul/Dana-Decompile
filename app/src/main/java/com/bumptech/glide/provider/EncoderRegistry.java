package com.bumptech.glide.provider;

import com.bumptech.glide.load.Encoder;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes3.dex */
public class EncoderRegistry {
    private final List<Entry<?>> MyBillsEntityDataFactory = new ArrayList();

    public final <T> Encoder<T> KClassImpl$Data$declaredNonStaticMembers$2(Class<T> cls) {
        synchronized (this) {
            for (Entry<?> entry : this.MyBillsEntityDataFactory) {
                if (entry.BuiltInFictitiousFunctionClassFactory(cls)) {
                    return (Encoder<T>) entry.getAuthRequestContext;
                }
            }
            return null;
        }
    }

    public final <T> void getAuthRequestContext(Class<T> cls, Encoder<T> encoder) {
        synchronized (this) {
            this.MyBillsEntityDataFactory.add(new Entry<>(cls, encoder));
        }
    }

    /* loaded from: classes3.dex */
    static final class Entry<T> {
        private final Class<T> MyBillsEntityDataFactory;
        final Encoder<T> getAuthRequestContext;

        Entry(Class<T> cls, Encoder<T> encoder) {
            this.MyBillsEntityDataFactory = cls;
            this.getAuthRequestContext = encoder;
        }

        final boolean BuiltInFictitiousFunctionClassFactory(Class<?> cls) {
            return this.MyBillsEntityDataFactory.isAssignableFrom(cls);
        }
    }
}
