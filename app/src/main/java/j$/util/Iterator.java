package j$.util;

import j$.util.function.Consumer;

/* loaded from: classes.dex */
public interface Iterator<E> {

    /* renamed from: j$.util.Iterator$-CC  reason: invalid class name */
    /* loaded from: classes.dex */
    public final /* synthetic */ class CC<E> {
        public static void getAuthRequestContext(java.util.Iterator it, Consumer consumer) {
            while (it.hasNext()) {
                consumer.accept(it.next());
            }
        }
    }

    void forEachRemaining(Consumer<? super E> consumer);
}
