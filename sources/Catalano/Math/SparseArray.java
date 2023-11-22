package Catalano.Math;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes6.dex */
public class SparseArray implements Iterable<Entry> {
    private List<Entry> BuiltInFictitiousFunctionClassFactory;

    /* loaded from: classes6.dex */
    public class Entry {
    }

    public SparseArray() {
        this((byte) 0);
    }

    private SparseArray(byte b) {
        this.BuiltInFictitiousFunctionClassFactory = new ArrayList(10);
    }

    @Override // java.lang.Iterable
    public Iterator<Entry> iterator() {
        return this.BuiltInFictitiousFunctionClassFactory.iterator();
    }
}
