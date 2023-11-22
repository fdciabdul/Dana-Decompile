package com.google.maps.android.collections;

import android.view.View;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.AdvancedMarkerOptions;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.maps.android.collections.MapObjectManager;
import java.util.Iterator;

/* loaded from: classes7.dex */
public class MarkerManager extends MapObjectManager<Marker, Collection> implements GoogleMap.OnInfoWindowClickListener, GoogleMap.OnMarkerClickListener, GoogleMap.OnMarkerDragListener, GoogleMap.InfoWindowAdapter, GoogleMap.OnInfoWindowLongClickListener {
    /* JADX WARN: Type inference failed for: r1v1, types: [com.google.maps.android.collections.MapObjectManager$Collection, com.google.maps.android.collections.MarkerManager$Collection] */
    @Override // com.google.maps.android.collections.MapObjectManager
    public /* bridge */ /* synthetic */ Collection getCollection(String str) {
        return super.getCollection(str);
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [com.google.maps.android.collections.MapObjectManager$Collection, com.google.maps.android.collections.MarkerManager$Collection] */
    @Override // com.google.maps.android.collections.MapObjectManager
    public /* bridge */ /* synthetic */ Collection newCollection(String str) {
        return super.newCollection(str);
    }

    @Override // com.google.maps.android.collections.MapObjectManager
    public /* bridge */ /* synthetic */ boolean remove(Marker marker) {
        return super.remove(marker);
    }

    public MarkerManager(GoogleMap googleMap) {
        super(googleMap);
    }

    @Override // com.google.maps.android.collections.MapObjectManager
    void setListenersOnUiThread() {
        if (this.mMap != null) {
            this.mMap.setOnInfoWindowClickListener(this);
            this.mMap.setOnInfoWindowLongClickListener(this);
            this.mMap.setOnMarkerClickListener(this);
            this.mMap.setOnMarkerDragListener(this);
            this.mMap.setInfoWindowAdapter(this);
        }
    }

    @Override // com.google.maps.android.collections.MapObjectManager
    public Collection newCollection() {
        return new Collection();
    }

    @Override // com.google.android.gms.maps.GoogleMap.InfoWindowAdapter
    public View getInfoWindow(Marker marker) {
        Collection collection = (Collection) this.mAllObjects.get(marker);
        if (collection == null || collection.mInfoWindowAdapter == null) {
            return null;
        }
        return collection.mInfoWindowAdapter.getInfoWindow(marker);
    }

    @Override // com.google.android.gms.maps.GoogleMap.InfoWindowAdapter
    public View getInfoContents(Marker marker) {
        Collection collection = (Collection) this.mAllObjects.get(marker);
        if (collection == null || collection.mInfoWindowAdapter == null) {
            return null;
        }
        return collection.mInfoWindowAdapter.getInfoContents(marker);
    }

    @Override // com.google.android.gms.maps.GoogleMap.OnInfoWindowClickListener
    public void onInfoWindowClick(Marker marker) {
        Collection collection = (Collection) this.mAllObjects.get(marker);
        if (collection == null || collection.mInfoWindowClickListener == null) {
            return;
        }
        collection.mInfoWindowClickListener.onInfoWindowClick(marker);
    }

    @Override // com.google.android.gms.maps.GoogleMap.OnInfoWindowLongClickListener
    public void onInfoWindowLongClick(Marker marker) {
        Collection collection = (Collection) this.mAllObjects.get(marker);
        if (collection == null || collection.mInfoWindowLongClickListener == null) {
            return;
        }
        collection.mInfoWindowLongClickListener.onInfoWindowLongClick(marker);
    }

    @Override // com.google.android.gms.maps.GoogleMap.OnMarkerClickListener
    public boolean onMarkerClick(Marker marker) {
        Collection collection = (Collection) this.mAllObjects.get(marker);
        if (collection == null || collection.mMarkerClickListener == null) {
            return false;
        }
        return collection.mMarkerClickListener.onMarkerClick(marker);
    }

    @Override // com.google.android.gms.maps.GoogleMap.OnMarkerDragListener
    public void onMarkerDragStart(Marker marker) {
        Collection collection = (Collection) this.mAllObjects.get(marker);
        if (collection == null || collection.mMarkerDragListener == null) {
            return;
        }
        collection.mMarkerDragListener.onMarkerDragStart(marker);
    }

    @Override // com.google.android.gms.maps.GoogleMap.OnMarkerDragListener
    public void onMarkerDrag(Marker marker) {
        Collection collection = (Collection) this.mAllObjects.get(marker);
        if (collection == null || collection.mMarkerDragListener == null) {
            return;
        }
        collection.mMarkerDragListener.onMarkerDrag(marker);
    }

    @Override // com.google.android.gms.maps.GoogleMap.OnMarkerDragListener
    public void onMarkerDragEnd(Marker marker) {
        Collection collection = (Collection) this.mAllObjects.get(marker);
        if (collection == null || collection.mMarkerDragListener == null) {
            return;
        }
        collection.mMarkerDragListener.onMarkerDragEnd(marker);
    }

    @Override // com.google.maps.android.collections.MapObjectManager
    public void removeObjectFromMap(Marker marker) {
        marker.remove();
    }

    /* loaded from: classes7.dex */
    public class Collection extends MapObjectManager.Collection {
        private GoogleMap.InfoWindowAdapter mInfoWindowAdapter;
        private GoogleMap.OnInfoWindowClickListener mInfoWindowClickListener;
        private GoogleMap.OnInfoWindowLongClickListener mInfoWindowLongClickListener;
        private GoogleMap.OnMarkerClickListener mMarkerClickListener;
        private GoogleMap.OnMarkerDragListener mMarkerDragListener;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Collection() {
            super();
            MarkerManager.this = r1;
        }

        public Marker addMarker(MarkerOptions markerOptions) {
            Marker addMarker = MarkerManager.this.mMap.addMarker(markerOptions);
            super.add(addMarker);
            return addMarker;
        }

        public Marker addMarker(AdvancedMarkerOptions advancedMarkerOptions) {
            Marker addMarker = MarkerManager.this.mMap.addMarker(advancedMarkerOptions);
            super.add(addMarker);
            return addMarker;
        }

        public void addAll(java.util.Collection<MarkerOptions> collection) {
            Iterator<MarkerOptions> it = collection.iterator();
            while (it.hasNext()) {
                addMarker(it.next());
            }
        }

        public void addAll(java.util.Collection<MarkerOptions> collection, boolean z) {
            Iterator<MarkerOptions> it = collection.iterator();
            while (it.hasNext()) {
                addMarker(it.next()).setVisible(z);
            }
        }

        public void showAll() {
            Iterator<Marker> it = getMarkers().iterator();
            while (it.hasNext()) {
                it.next().setVisible(true);
            }
        }

        public void hideAll() {
            Iterator<Marker> it = getMarkers().iterator();
            while (it.hasNext()) {
                it.next().setVisible(false);
            }
        }

        public boolean remove(Marker marker) {
            return super.remove((Collection) marker);
        }

        public java.util.Collection<Marker> getMarkers() {
            return getObjects();
        }

        public void setOnInfoWindowClickListener(GoogleMap.OnInfoWindowClickListener onInfoWindowClickListener) {
            this.mInfoWindowClickListener = onInfoWindowClickListener;
        }

        public void setOnInfoWindowLongClickListener(GoogleMap.OnInfoWindowLongClickListener onInfoWindowLongClickListener) {
            this.mInfoWindowLongClickListener = onInfoWindowLongClickListener;
        }

        public void setOnMarkerClickListener(GoogleMap.OnMarkerClickListener onMarkerClickListener) {
            this.mMarkerClickListener = onMarkerClickListener;
        }

        public void setOnMarkerDragListener(GoogleMap.OnMarkerDragListener onMarkerDragListener) {
            this.mMarkerDragListener = onMarkerDragListener;
        }

        public void setInfoWindowAdapter(GoogleMap.InfoWindowAdapter infoWindowAdapter) {
            this.mInfoWindowAdapter = infoWindowAdapter;
        }
    }
}
