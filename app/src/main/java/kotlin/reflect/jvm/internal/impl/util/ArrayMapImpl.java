package kotlin.reflect.jvm.internal.impl.util;

import java.util.Arrays;
import java.util.Iterator;
import kotlin.collections.AbstractIterator;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
public final class ArrayMapImpl<T> extends ArrayMap<T> {
    public static final Companion Companion = new Companion(null);
    private Object[] data;
    private int size;

    /* loaded from: classes.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    private ArrayMapImpl(Object[] objArr, int i) {
        super(null);
        this.data = objArr;
        this.size = i;
    }

    public ArrayMapImpl() {
        this(new Object[20], 0);
    }

    @Override // kotlin.reflect.jvm.internal.impl.util.ArrayMap
    public final int getSize() {
        return this.size;
    }

    private final void ensureCapacity(int i) {
        Object[] objArr = this.data;
        if (objArr.length <= i) {
            Object[] copyOf = Arrays.copyOf(objArr, objArr.length * 2);
            Intrinsics.checkNotNullExpressionValue(copyOf, "");
            this.data = copyOf;
        }
    }

    @Override // kotlin.reflect.jvm.internal.impl.util.ArrayMap
    public final void set(int i, T t) {
        Intrinsics.checkNotNullParameter(t, "");
        ensureCapacity(i);
        if (this.data[i] == null) {
            this.size = getSize() + 1;
        }
        this.data[i] = t;
    }

    @Override // kotlin.reflect.jvm.internal.impl.util.ArrayMap
    public final T get(int i) {
        return (T) ArraysKt.getOrNull(this.data, i);
    }

    @Override // kotlin.reflect.jvm.internal.impl.util.ArrayMap, java.lang.Iterable
    public final Iterator<T> iterator() {
        return new AbstractIterator<T>(this) { // from class: kotlin.reflect.jvm.internal.impl.util.ArrayMapImpl$iterator$1
            private int index = -1;
            final /* synthetic */ ArrayMapImpl<T> this$0;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.this$0 = this;
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // kotlin.collections.AbstractIterator
            public final void computeNext() {
                Object[] objArr;
                Object[] objArr2;
                Object[] objArr3;
                Object[] objArr4;
                do {
                    int i = this.index + 1;
                    this.index = i;
                    objArr = ((ArrayMapImpl) this.this$0).data;
                    if (i >= objArr.length) {
                        break;
                    }
                    objArr4 = ((ArrayMapImpl) this.this$0).data;
                } while (objArr4[this.index] == null);
                int i2 = this.index;
                objArr2 = ((ArrayMapImpl) this.this$0).data;
                if (i2 < objArr2.length) {
                    objArr3 = ((ArrayMapImpl) this.this$0).data;
                    Object obj = objArr3[this.index];
                    Intrinsics.checkNotNull(obj);
                    setNext(obj);
                    return;
                }
                done();
            }
        };
    }
}
