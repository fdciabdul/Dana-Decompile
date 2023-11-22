package kotlin.collections;

import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\b\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00012\u00020\u0002B\u0017\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00028\u0000¢\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u0004\u001a\u00020\u0003HÆ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0006\u001a\u00028\u0000HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J*\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00028\u0000HÆ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\u000e\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\u0002HÖ\u0003¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0010\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0005J\u0010\u0010\u0012\u001a\u00020\u0011HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0013R\u0017\u0010\b\u001a\u00020\u00038\u0007¢\u0006\f\n\u0004\b\b\u0010\u0014\u001a\u0004\b\u0015\u0010\u0005R\u001a\u0010\t\u001a\u00028\u00008\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0016\u001a\u0004\b\u0017\u0010\u0007"}, d2 = {"Lkotlin/collections/IndexedValue;", "T", "", "", "component1", "()I", "component2", "()Ljava/lang/Object;", "index", "value", "copy", "(ILjava/lang/Object;)Lkotlin/collections/IndexedValue;", "other", "", "equals", "(Ljava/lang/Object;)Z", "hashCode", "", "toString", "()Ljava/lang/String;", "I", "getIndex", "Ljava/lang/Object;", "getValue", "<init>", "(ILjava/lang/Object;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes.dex */
public final /* data */ class IndexedValue<T> {
    private final int index;
    private final T value;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ IndexedValue copy$default(IndexedValue indexedValue, int i, Object obj, int i2, Object obj2) {
        if ((i2 & 1) != 0) {
            i = indexedValue.index;
        }
        if ((i2 & 2) != 0) {
            obj = indexedValue.value;
        }
        return indexedValue.copy(i, obj);
    }

    /* renamed from: component1  reason: from getter */
    public final int getIndex() {
        return this.index;
    }

    public final T component2() {
        return this.value;
    }

    public final IndexedValue<T> copy(int index, T value) {
        return new IndexedValue<>(index, value);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof IndexedValue) {
            IndexedValue indexedValue = (IndexedValue) other;
            return this.index == indexedValue.index && Intrinsics.areEqual(this.value, indexedValue.value);
        }
        return false;
    }

    public final int hashCode() {
        int i = this.index;
        T t = this.value;
        return (i * 31) + (t == null ? 0 : t.hashCode());
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("IndexedValue(index=");
        sb.append(this.index);
        sb.append(", value=");
        sb.append(this.value);
        sb.append(')');
        return sb.toString();
    }

    public IndexedValue(int i, T t) {
        this.index = i;
        this.value = t;
    }

    @JvmName(name = "getIndex")
    public final int getIndex() {
        return this.index;
    }

    @JvmName(name = "getValue")
    public final T getValue() {
        return this.value;
    }
}
