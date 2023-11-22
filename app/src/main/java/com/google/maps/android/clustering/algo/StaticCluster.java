package com.google.maps.android.clustering.algo;

import com.google.android.gms.maps.model.LatLng;
import com.google.maps.android.clustering.Cluster;
import com.google.maps.android.clustering.ClusterItem;
import java.util.Collection;
import java.util.LinkedHashSet;

/* loaded from: classes7.dex */
public class StaticCluster<T extends ClusterItem> implements Cluster<T> {
    private final LatLng mCenter;
    private final Collection<T> mItems = new LinkedHashSet();

    public StaticCluster(LatLng latLng) {
        this.mCenter = latLng;
    }

    public boolean add(T t) {
        return this.mItems.add(t);
    }

    @Override // com.google.maps.android.clustering.Cluster
    public LatLng getPosition() {
        return this.mCenter;
    }

    public boolean remove(T t) {
        return this.mItems.remove(t);
    }

    @Override // com.google.maps.android.clustering.Cluster
    public Collection<T> getItems() {
        return this.mItems;
    }

    @Override // com.google.maps.android.clustering.Cluster
    public int getSize() {
        return this.mItems.size();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("StaticCluster{mCenter=");
        sb.append(this.mCenter);
        sb.append(", mItems.size=");
        sb.append(this.mItems.size());
        sb.append('}');
        return sb.toString();
    }

    public int hashCode() {
        return this.mCenter.hashCode() + this.mItems.hashCode();
    }

    public boolean equals(Object obj) {
        if (obj instanceof StaticCluster) {
            StaticCluster staticCluster = (StaticCluster) obj;
            return staticCluster.mCenter.equals(this.mCenter) && staticCluster.mItems.equals(this.mItems);
        }
        return false;
    }
}
