package kotlin.jvm.internal;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;

/* loaded from: classes.dex */
public class SpreadBuilder {
    private final ArrayList<Object> list;

    public SpreadBuilder(int i) {
        this.list = new ArrayList<>(i);
    }

    public void addSpread(Object obj) {
        if (obj == null) {
            return;
        }
        if (obj instanceof Object[]) {
            Object[] objArr = (Object[]) obj;
            if (objArr.length > 0) {
                ArrayList<Object> arrayList = this.list;
                arrayList.ensureCapacity(arrayList.size() + objArr.length);
                Collections.addAll(this.list, objArr);
            }
        } else if (obj instanceof Collection) {
            this.list.addAll((Collection) obj);
        } else if (obj instanceof Iterable) {
            Iterator it = ((Iterable) obj).iterator();
            while (it.hasNext()) {
                this.list.add(it.next());
            }
        } else if (obj instanceof Iterator) {
            Iterator it2 = (Iterator) obj;
            while (it2.hasNext()) {
                this.list.add(it2.next());
            }
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append("Don't know how to spread ");
            sb.append(obj.getClass());
            throw new UnsupportedOperationException(sb.toString());
        }
    }

    public int size() {
        return this.list.size();
    }

    public void add(Object obj) {
        this.list.add(obj);
    }

    public Object[] toArray(Object[] objArr) {
        return this.list.toArray(objArr);
    }
}
