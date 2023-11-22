package fsimpl;

import java.io.File;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.SortedSet;
import java.util.TreeSet;

/* loaded from: classes.dex */
class dH implements Comparable {

    /* renamed from: a  reason: collision with root package name */
    final String f7916a;
    final File b;
    final long c;
    final SortedSet d = Collections.synchronizedSortedSet(new TreeSet());
    final Map e = Collections.synchronizedMap(new HashMap());

    /* JADX INFO: Access modifiers changed from: package-private */
    public dH(File file, long j) {
        this.b = file;
        this.f7916a = file.getName();
        this.c = j;
    }

    @Override // java.lang.Comparable
    /* renamed from: a  reason: merged with bridge method [inline-methods] */
    public int compareTo(dH dHVar) {
        if (dHVar != null) {
            return (this.c > dHVar.c ? 1 : (this.c == dHVar.c ? 0 : -1));
        }
        throw new IllegalArgumentException("Null comparable");
    }
}
