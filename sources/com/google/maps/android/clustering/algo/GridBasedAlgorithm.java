package com.google.maps.android.clustering.algo;

import androidx.collection.LongSparseArray;
import com.google.maps.android.clustering.Cluster;
import com.google.maps.android.clustering.ClusterItem;
import com.google.maps.android.projection.Point;
import com.google.maps.android.projection.SphericalMercatorProjection;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* loaded from: classes7.dex */
public class GridBasedAlgorithm<T extends ClusterItem> extends AbstractAlgorithm<T> {
    private static final int DEFAULT_GRID_SIZE = 100;
    private int mGridSize = 100;
    private final Set<T> mItems = Collections.synchronizedSet(new HashSet());

    @Override // com.google.maps.android.clustering.algo.Algorithm
    public boolean addItem(T t) {
        return this.mItems.add(t);
    }

    @Override // com.google.maps.android.clustering.algo.Algorithm
    public boolean addItems(Collection<T> collection) {
        return this.mItems.addAll(collection);
    }

    @Override // com.google.maps.android.clustering.algo.Algorithm
    public void clearItems() {
        this.mItems.clear();
    }

    @Override // com.google.maps.android.clustering.algo.Algorithm
    public boolean removeItem(T t) {
        return this.mItems.remove(t);
    }

    @Override // com.google.maps.android.clustering.algo.Algorithm
    public boolean removeItems(Collection<T> collection) {
        return this.mItems.removeAll(collection);
    }

    @Override // com.google.maps.android.clustering.algo.Algorithm
    public boolean updateItem(T t) {
        boolean removeItem;
        synchronized (this.mItems) {
            removeItem = removeItem(t);
            if (removeItem) {
                removeItem = addItem(t);
            }
        }
        return removeItem;
    }

    @Override // com.google.maps.android.clustering.algo.Algorithm
    public void setMaxDistanceBetweenClusteredItems(int i) {
        this.mGridSize = i;
    }

    @Override // com.google.maps.android.clustering.algo.Algorithm
    public int getMaxDistanceBetweenClusteredItems() {
        return this.mGridSize;
    }

    @Override // com.google.maps.android.clustering.algo.Algorithm
    public Set<? extends Cluster<T>> getClusters(float f) {
        long j;
        double pow = Math.pow(2.0d, f);
        double d = this.mGridSize;
        Double.isNaN(d);
        long ceil = (long) Math.ceil((pow * 256.0d) / d);
        SphericalMercatorProjection sphericalMercatorProjection = new SphericalMercatorProjection(ceil);
        HashSet hashSet = new HashSet();
        LongSparseArray longSparseArray = new LongSparseArray();
        synchronized (this.mItems) {
            for (T t : this.mItems) {
                Point point = sphericalMercatorProjection.toPoint(t.getPosition());
                long coord = getCoord(ceil, point.x, point.y);
                StaticCluster staticCluster = (StaticCluster) longSparseArray.MyBillsEntityDataFactory(coord, null);
                if (staticCluster == null) {
                    j = ceil;
                    staticCluster = new StaticCluster(sphericalMercatorProjection.toLatLng(new com.google.maps.android.geometry.Point(Math.floor(point.x) + 0.5d, Math.floor(point.y) + 0.5d)));
                    longSparseArray.getAuthRequestContext(coord, staticCluster);
                    hashSet.add(staticCluster);
                } else {
                    j = ceil;
                }
                staticCluster.add(t);
                ceil = j;
            }
        }
        return hashSet;
    }

    @Override // com.google.maps.android.clustering.algo.Algorithm
    public Collection<T> getItems() {
        return this.mItems;
    }

    private static long getCoord(long j, double d, double d2) {
        double d3 = j;
        double floor = Math.floor(d);
        Double.isNaN(d3);
        return (long) ((d3 * floor) + Math.floor(d2));
    }
}
