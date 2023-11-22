package com.google.common.base;

import java.io.Serializable;
import java.util.Iterator;
import javax.annotation.CheckForNull;

@ElementTypesAreNonnullByDefault
/* loaded from: classes7.dex */
final class PairwiseEquivalence<E, T extends E> extends Equivalence<Iterable<T>> implements Serializable {
    private static final long serialVersionUID = 1;
    final Equivalence<E> elementEquivalence;

    @Override // com.google.common.base.Equivalence
    protected final /* bridge */ /* synthetic */ boolean doEquivalent(Object obj, Object obj2) {
        return doEquivalent((Iterable) ((Iterable) obj), (Iterable) ((Iterable) obj2));
    }

    @Override // com.google.common.base.Equivalence
    protected final /* bridge */ /* synthetic */ int doHash(Object obj) {
        return doHash((Iterable) ((Iterable) obj));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public PairwiseEquivalence(Equivalence<E> equivalence) {
        this.elementEquivalence = (Equivalence) Preconditions.checkNotNull(equivalence);
    }

    protected final boolean doEquivalent(Iterable<T> iterable, Iterable<T> iterable2) {
        Iterator<T> it = iterable.iterator();
        Iterator<T> it2 = iterable2.iterator();
        while (it.hasNext() && it2.hasNext()) {
            if (!this.elementEquivalence.equivalent(it.next(), it2.next())) {
                return false;
            }
        }
        return (it.hasNext() || it2.hasNext()) ? false : true;
    }

    protected final int doHash(Iterable<T> iterable) {
        Iterator<T> it = iterable.iterator();
        int i = 78721;
        while (it.hasNext()) {
            i = (i * 24943) + this.elementEquivalence.hash(it.next());
        }
        return i;
    }

    public final boolean equals(@CheckForNull Object obj) {
        if (obj instanceof PairwiseEquivalence) {
            return this.elementEquivalence.equals(((PairwiseEquivalence) obj).elementEquivalence);
        }
        return false;
    }

    public final int hashCode() {
        return this.elementEquivalence.hashCode() ^ 1185147655;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.elementEquivalence);
        sb.append(".pairwise()");
        return sb.toString();
    }
}
