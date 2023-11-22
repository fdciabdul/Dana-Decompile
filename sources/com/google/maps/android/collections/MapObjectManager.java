package com.google.maps.android.collections;

import android.os.Handler;
import android.os.Looper;
import com.google.android.gms.maps.GoogleMap;
import com.google.maps.android.collections.MapObjectManager.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

/* loaded from: classes7.dex */
public abstract class MapObjectManager<O, C extends Collection> {
    protected final GoogleMap mMap;
    private final Map<String, C> mNamedCollections = new HashMap();
    protected final Map<O, C> mAllObjects = new HashMap();

    public abstract C newCollection();

    protected abstract void removeObjectFromMap(O o2);

    abstract void setListenersOnUiThread();

    public MapObjectManager(GoogleMap googleMap) {
        this.mMap = googleMap;
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.google.maps.android.collections.MapObjectManager.1
            {
                MapObjectManager.this = this;
            }

            @Override // java.lang.Runnable
            public void run() {
                MapObjectManager.this.setListenersOnUiThread();
            }
        });
    }

    public C newCollection(String str) {
        if (this.mNamedCollections.get(str) != null) {
            StringBuilder sb = new StringBuilder();
            sb.append("collection id is not unique: ");
            sb.append(str);
            throw new IllegalArgumentException(sb.toString());
        }
        C newCollection = newCollection();
        this.mNamedCollections.put(str, newCollection);
        return newCollection;
    }

    public C getCollection(String str) {
        return this.mNamedCollections.get(str);
    }

    public boolean remove(O o2) {
        C c = this.mAllObjects.get(o2);
        return c != null && c.remove(o2);
    }

    /* loaded from: classes7.dex */
    public class Collection {
        private final Set<O> mObjects = new LinkedHashSet();

        public Collection() {
            MapObjectManager.this = r1;
        }

        public void add(O o2) {
            this.mObjects.add(o2);
            MapObjectManager.this.mAllObjects.put(o2, this);
        }

        public boolean remove(O o2) {
            if (this.mObjects.remove(o2)) {
                MapObjectManager.this.mAllObjects.remove(o2);
                MapObjectManager.this.removeObjectFromMap(o2);
                return true;
            }
            return false;
        }

        public void clear() {
            for (O o2 : this.mObjects) {
                MapObjectManager.this.removeObjectFromMap(o2);
                MapObjectManager.this.mAllObjects.remove(o2);
            }
            this.mObjects.clear();
        }

        public java.util.Collection<O> getObjects() {
            return Collections.unmodifiableCollection(this.mObjects);
        }
    }
}
