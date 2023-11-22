package com.j256.ormlite.dao;

import j$.util.concurrent.ConcurrentHashMap;
import java.lang.ref.Reference;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.Map;

/* loaded from: classes8.dex */
public class ReferenceObjectCache implements ObjectCache {
    private final ConcurrentHashMap<Class<?>, Map<Object, Reference<Object>>> classMaps = new ConcurrentHashMap<>();
    private final boolean useWeak;

    public ReferenceObjectCache(boolean z) {
        this.useWeak = z;
    }

    public static ReferenceObjectCache makeWeakCache() {
        return new ReferenceObjectCache(true);
    }

    public static ReferenceObjectCache makeSoftCache() {
        return new ReferenceObjectCache(false);
    }

    @Override // com.j256.ormlite.dao.ObjectCache
    public <T> void registerClass(Class<T> cls) {
        synchronized (this) {
            if (this.classMaps.get(cls) == null) {
                this.classMaps.put(cls, new ConcurrentHashMap());
            }
        }
    }

    @Override // com.j256.ormlite.dao.ObjectCache
    public <T, ID> T get(Class<T> cls, ID id2) {
        Reference<Object> reference;
        Map<Object, Reference<Object>> mapForClass = getMapForClass(cls);
        if (mapForClass == null || (reference = mapForClass.get(id2)) == null) {
            return null;
        }
        T t = (T) reference.get();
        if (t == null) {
            mapForClass.remove(id2);
            return null;
        }
        return t;
    }

    @Override // com.j256.ormlite.dao.ObjectCache
    public <T, ID> void put(Class<T> cls, ID id2, T t) {
        Map<Object, Reference<Object>> mapForClass = getMapForClass(cls);
        if (mapForClass != null) {
            if (this.useWeak) {
                mapForClass.put(id2, new WeakReference(t));
            } else {
                mapForClass.put(id2, new SoftReference(t));
            }
        }
    }

    @Override // com.j256.ormlite.dao.ObjectCache
    public <T> void clear(Class<T> cls) {
        Map<Object, Reference<Object>> mapForClass = getMapForClass(cls);
        if (mapForClass != null) {
            mapForClass.clear();
        }
    }

    @Override // com.j256.ormlite.dao.ObjectCache
    public void clearAll() {
        Iterator<Map<Object, Reference<Object>>> it = this.classMaps.values().iterator();
        while (it.hasNext()) {
            it.next().clear();
        }
    }

    @Override // com.j256.ormlite.dao.ObjectCache
    public <T, ID> void remove(Class<T> cls, ID id2) {
        Map<Object, Reference<Object>> mapForClass = getMapForClass(cls);
        if (mapForClass != null) {
            mapForClass.remove(id2);
        }
    }

    @Override // com.j256.ormlite.dao.ObjectCache
    public <T, ID> T updateId(Class<T> cls, ID id2, ID id3) {
        Reference<Object> remove;
        Map<Object, Reference<Object>> mapForClass = getMapForClass(cls);
        if (mapForClass == null || (remove = mapForClass.remove(id2)) == null) {
            return null;
        }
        mapForClass.put(id3, remove);
        return (T) remove.get();
    }

    @Override // com.j256.ormlite.dao.ObjectCache
    public <T> int size(Class<T> cls) {
        Map<Object, Reference<Object>> mapForClass = getMapForClass(cls);
        if (mapForClass == null) {
            return 0;
        }
        return mapForClass.size();
    }

    @Override // com.j256.ormlite.dao.ObjectCache
    public int sizeAll() {
        Iterator<Map<Object, Reference<Object>>> it = this.classMaps.values().iterator();
        int i = 0;
        while (it.hasNext()) {
            i += it.next().size();
        }
        return i;
    }

    public <T> void cleanNullReferences(Class<T> cls) {
        Map<Object, Reference<Object>> mapForClass = getMapForClass(cls);
        if (mapForClass != null) {
            cleanMap(mapForClass);
        }
    }

    public <T> void cleanNullReferencesAll() {
        Iterator<Map<Object, Reference<Object>>> it = this.classMaps.values().iterator();
        while (it.hasNext()) {
            cleanMap(it.next());
        }
    }

    private void cleanMap(Map<Object, Reference<Object>> map) {
        Iterator<Map.Entry<Object, Reference<Object>>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            if (it.next().getValue().get() == null) {
                it.remove();
            }
        }
    }

    private Map<Object, Reference<Object>> getMapForClass(Class<?> cls) {
        Map<Object, Reference<Object>> map = this.classMaps.get(cls);
        if (map == null) {
            return null;
        }
        return map;
    }
}
