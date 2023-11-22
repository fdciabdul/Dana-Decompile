package kotlin.reflect.jvm.internal.impl.types.model;

import java.util.ArrayList;

/* loaded from: classes.dex */
public final class ArgumentList extends ArrayList<TypeArgumentMarker> implements TypeArgumentListMarker {
    public ArgumentList(int i) {
        super(i);
    }

    @Override // java.util.ArrayList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ boolean contains(Object obj) {
        if (obj instanceof TypeArgumentMarker) {
            return contains((TypeArgumentMarker) obj);
        }
        return false;
    }

    public final /* bridge */ boolean contains(TypeArgumentMarker typeArgumentMarker) {
        return super.contains((Object) typeArgumentMarker);
    }

    public final int getSize() {
        return super.size();
    }

    @Override // java.util.ArrayList, java.util.AbstractList, java.util.List
    public final /* bridge */ int indexOf(Object obj) {
        if (obj instanceof TypeArgumentMarker) {
            return indexOf((TypeArgumentMarker) obj);
        }
        return -1;
    }

    public final /* bridge */ int indexOf(TypeArgumentMarker typeArgumentMarker) {
        return super.indexOf((Object) typeArgumentMarker);
    }

    @Override // java.util.ArrayList, java.util.AbstractList, java.util.List
    public final /* bridge */ int lastIndexOf(Object obj) {
        if (obj instanceof TypeArgumentMarker) {
            return lastIndexOf((TypeArgumentMarker) obj);
        }
        return -1;
    }

    public final /* bridge */ int lastIndexOf(TypeArgumentMarker typeArgumentMarker) {
        return super.lastIndexOf((Object) typeArgumentMarker);
    }

    @Override // java.util.ArrayList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ boolean remove(Object obj) {
        if (obj instanceof TypeArgumentMarker) {
            return remove((TypeArgumentMarker) obj);
        }
        return false;
    }

    public final /* bridge */ boolean remove(TypeArgumentMarker typeArgumentMarker) {
        return super.remove((Object) typeArgumentMarker);
    }

    @Override // java.util.ArrayList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return getSize();
    }
}
