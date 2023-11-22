package butterknife.internal;

import java.util.AbstractList;
import java.util.RandomAccess;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public final class ImmutableList<T> extends AbstractList<T> implements RandomAccess {
    private final T[] BuiltInFictitiousFunctionClassFactory;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ImmutableList(T[] tArr) {
        this.BuiltInFictitiousFunctionClassFactory = tArr;
    }

    @Override // java.util.AbstractList, java.util.List
    public final T get(int i) {
        return this.BuiltInFictitiousFunctionClassFactory[i];
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.BuiltInFictitiousFunctionClassFactory.length;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean contains(Object obj) {
        for (T t : this.BuiltInFictitiousFunctionClassFactory) {
            if (t == obj) {
                return true;
            }
        }
        return false;
    }
}
