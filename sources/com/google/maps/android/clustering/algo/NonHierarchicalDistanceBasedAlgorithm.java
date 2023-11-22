package com.google.maps.android.clustering.algo;

import com.google.android.gms.maps.model.LatLng;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.google.maps.android.clustering.Cluster;
import com.google.maps.android.clustering.ClusterItem;
import com.google.maps.android.geometry.Bounds;
import com.google.maps.android.geometry.Point;
import com.google.maps.android.projection.SphericalMercatorProjection;
import com.google.maps.android.quadtree.PointQuadTree;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

/* loaded from: classes7.dex */
public class NonHierarchicalDistanceBasedAlgorithm<T extends ClusterItem> extends AbstractAlgorithm<T> {
    private static final int DEFAULT_MAX_DISTANCE_AT_ZOOM = 100;
    private static final SphericalMercatorProjection PROJECTION = new SphericalMercatorProjection(1.0d);
    private int mMaxDistance = 100;
    private final Collection<QuadItem<T>> mItems = new LinkedHashSet();
    private final PointQuadTree<QuadItem<T>> mQuadTree = new PointQuadTree<>(FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, 1.0d, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, 1.0d);

    @Override // com.google.maps.android.clustering.algo.Algorithm
    public boolean addItem(T t) {
        boolean add;
        QuadItem<T> quadItem = new QuadItem<>(t);
        synchronized (this.mQuadTree) {
            add = this.mItems.add(quadItem);
            if (add) {
                this.mQuadTree.add(quadItem);
            }
        }
        return add;
    }

    @Override // com.google.maps.android.clustering.algo.Algorithm
    public boolean addItems(Collection<T> collection) {
        Iterator<T> it = collection.iterator();
        boolean z = false;
        while (it.hasNext()) {
            if (addItem(it.next())) {
                z = true;
            }
        }
        return z;
    }

    @Override // com.google.maps.android.clustering.algo.Algorithm
    public void clearItems() {
        synchronized (this.mQuadTree) {
            this.mItems.clear();
            this.mQuadTree.clear();
        }
    }

    @Override // com.google.maps.android.clustering.algo.Algorithm
    public boolean removeItem(T t) {
        boolean remove;
        QuadItem<T> quadItem = new QuadItem<>(t);
        synchronized (this.mQuadTree) {
            remove = this.mItems.remove(quadItem);
            if (remove) {
                this.mQuadTree.remove(quadItem);
            }
        }
        return remove;
    }

    @Override // com.google.maps.android.clustering.algo.Algorithm
    public boolean removeItems(Collection<T> collection) {
        boolean z;
        synchronized (this.mQuadTree) {
            Iterator<T> it = collection.iterator();
            z = false;
            while (it.hasNext()) {
                QuadItem<T> quadItem = new QuadItem<>(it.next());
                if (this.mItems.remove(quadItem)) {
                    this.mQuadTree.remove(quadItem);
                    z = true;
                }
            }
        }
        return z;
    }

    @Override // com.google.maps.android.clustering.algo.Algorithm
    public boolean updateItem(T t) {
        boolean removeItem;
        synchronized (this.mQuadTree) {
            removeItem = removeItem(t);
            if (removeItem) {
                removeItem = addItem(t);
            }
        }
        return removeItem;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.maps.android.clustering.algo.Algorithm
    public Set<? extends Cluster<T>> getClusters(float f) {
        double d = this.mMaxDistance;
        double pow = Math.pow(2.0d, (int) f);
        Double.isNaN(d);
        double d2 = (d / pow) / 256.0d;
        HashSet hashSet = new HashSet();
        HashSet hashSet2 = new HashSet();
        HashMap hashMap = new HashMap();
        HashMap hashMap2 = new HashMap();
        synchronized (this.mQuadTree) {
            Iterator<QuadItem<T>> it = getClusteringItems(this.mQuadTree, f).iterator();
            while (it.hasNext()) {
                QuadItem<T> next = it.next();
                if (!hashSet.contains(next)) {
                    Collection<QuadItem<T>> search = this.mQuadTree.search(createBoundsFromSpan(next.getPoint(), d2));
                    if (search.size() == 1) {
                        hashSet2.add(next);
                        hashSet.add(next);
                        hashMap.put(next, Double.valueOf((double) FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE));
                    } else {
                        StaticCluster staticCluster = new StaticCluster(((QuadItem) next).mClusterItem.getPosition());
                        hashSet2.add(staticCluster);
                        for (QuadItem<T> quadItem : search) {
                            Double d3 = (Double) hashMap.get(quadItem);
                            Iterator<QuadItem<T>> it2 = it;
                            double distanceSquared = distanceSquared(quadItem.getPoint(), next.getPoint());
                            if (d3 != null) {
                                if (d3.doubleValue() < distanceSquared) {
                                    it = it2;
                                } else {
                                    ((StaticCluster) hashMap2.get(quadItem)).remove(((QuadItem) quadItem).mClusterItem);
                                }
                            }
                            hashMap.put(quadItem, Double.valueOf(distanceSquared));
                            staticCluster.add(((QuadItem) quadItem).mClusterItem);
                            hashMap2.put(quadItem, staticCluster);
                            it = it2;
                        }
                        Iterator<QuadItem<T>> it3 = it;
                        hashSet.addAll(search);
                        it = it3;
                    }
                }
            }
        }
        return hashSet2;
    }

    protected Collection<QuadItem<T>> getClusteringItems(PointQuadTree<QuadItem<T>> pointQuadTree, float f) {
        return this.mItems;
    }

    @Override // com.google.maps.android.clustering.algo.Algorithm
    public Collection<T> getItems() {
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        synchronized (this.mQuadTree) {
            Iterator<QuadItem<T>> it = this.mItems.iterator();
            while (it.hasNext()) {
                linkedHashSet.add(((QuadItem) it.next()).mClusterItem);
            }
        }
        return linkedHashSet;
    }

    @Override // com.google.maps.android.clustering.algo.Algorithm
    public void setMaxDistanceBetweenClusteredItems(int i) {
        this.mMaxDistance = i;
    }

    @Override // com.google.maps.android.clustering.algo.Algorithm
    public int getMaxDistanceBetweenClusteredItems() {
        return this.mMaxDistance;
    }

    private double distanceSquared(Point point, Point point2) {
        return ((point.x - point2.x) * (point.x - point2.x)) + ((point.y - point2.y) * (point.y - point2.y));
    }

    private Bounds createBoundsFromSpan(Point point, double d) {
        double d2 = d / 2.0d;
        return new Bounds(point.x - d2, point.x + d2, point.y - d2, point.y + d2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes7.dex */
    public static class QuadItem<T extends ClusterItem> implements PointQuadTree.Item, Cluster<T> {
        private final T mClusterItem;
        private final Point mPoint;
        private final LatLng mPosition;
        private Set<T> singletonSet;

        @Override // com.google.maps.android.clustering.Cluster
        public int getSize() {
            return 1;
        }

        private QuadItem(T t) {
            this.mClusterItem = t;
            LatLng position = t.getPosition();
            this.mPosition = position;
            this.mPoint = NonHierarchicalDistanceBasedAlgorithm.PROJECTION.toPoint(position);
            this.singletonSet = Collections.singleton(t);
        }

        @Override // com.google.maps.android.quadtree.PointQuadTree.Item
        public Point getPoint() {
            return this.mPoint;
        }

        @Override // com.google.maps.android.clustering.Cluster
        public LatLng getPosition() {
            return this.mPosition;
        }

        @Override // com.google.maps.android.clustering.Cluster
        public Set<T> getItems() {
            return this.singletonSet;
        }

        public int hashCode() {
            return this.mClusterItem.hashCode();
        }

        public boolean equals(Object obj) {
            if (obj instanceof QuadItem) {
                return ((QuadItem) obj).mClusterItem.equals(this.mClusterItem);
            }
            return false;
        }
    }
}
