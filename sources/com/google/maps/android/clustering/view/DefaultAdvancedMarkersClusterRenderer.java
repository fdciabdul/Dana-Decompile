package com.google.maps.android.clustering.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.MessageQueue;
import android.util.SparseArray;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.Projection;
import com.google.android.gms.maps.model.AdvancedMarker;
import com.google.android.gms.maps.model.AdvancedMarkerOptions;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.Marker;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.google.maps.android.R;
import com.google.maps.android.clustering.Cluster;
import com.google.maps.android.clustering.ClusterItem;
import com.google.maps.android.clustering.ClusterManager;
import com.google.maps.android.clustering.view.DefaultAdvancedMarkersClusterRenderer;
import com.google.maps.android.collections.MarkerManager;
import com.google.maps.android.geometry.Point;
import com.google.maps.android.projection.SphericalMercatorProjection;
import com.google.maps.android.ui.IconGenerator;
import com.google.maps.android.ui.SquareTextView;
import j$.util.concurrent.ConcurrentHashMap;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* loaded from: classes7.dex */
public class DefaultAdvancedMarkersClusterRenderer<T extends ClusterItem> implements ClusterRenderer<T> {
    private ClusterManager.OnClusterClickListener<T> mClickListener;
    private final ClusterManager<T> mClusterManager;
    private MarkerCache<Cluster<T>> mClusterMarkerCache;
    private Set<? extends Cluster<T>> mClusters;
    private ShapeDrawable mColoredCircleBackground;
    private final float mDensity;
    private final IconGenerator mIconGenerator;
    private ClusterManager.OnClusterInfoWindowClickListener<T> mInfoWindowClickListener;
    private ClusterManager.OnClusterInfoWindowLongClickListener<T> mInfoWindowLongClickListener;
    private ClusterManager.OnClusterItemClickListener<T> mItemClickListener;
    private ClusterManager.OnClusterItemInfoWindowClickListener<T> mItemInfoWindowClickListener;
    private ClusterManager.OnClusterItemInfoWindowLongClickListener<T> mItemInfoWindowLongClickListener;
    private final GoogleMap mMap;
    private MarkerCache<T> mMarkerCache;
    private final DefaultAdvancedMarkersClusterRenderer<T>.ViewModifier mViewModifier;
    private float mZoom;
    private static final int[] BUCKETS = {10, 20, 50, 100, 200, 500, 1000};
    private static final TimeInterpolator ANIMATION_INTERP = new DecelerateInterpolator();
    private final Executor mExecutor = Executors.newSingleThreadExecutor();
    private Set<MarkerWithPosition> mMarkers = Collections.newSetFromMap(new ConcurrentHashMap());
    private SparseArray<BitmapDescriptor> mIcons = new SparseArray<>();
    private int mMinClusterSize = 4;
    private boolean mAnimate = true;
    private long mAnimationDurationMs = 300;

    protected void onClusterItemRendered(T t, Marker marker) {
    }

    protected void onClusterRendered(Cluster<T> cluster, Marker marker) {
    }

    public DefaultAdvancedMarkersClusterRenderer(Context context, GoogleMap googleMap, ClusterManager<T> clusterManager) {
        this.mMarkerCache = new MarkerCache<>();
        this.mClusterMarkerCache = new MarkerCache<>();
        this.mViewModifier = new ViewModifier();
        this.mMap = googleMap;
        this.mDensity = context.getResources().getDisplayMetrics().density;
        IconGenerator iconGenerator = new IconGenerator(context);
        this.mIconGenerator = iconGenerator;
        iconGenerator.setContentView(makeSquareTextView(context));
        iconGenerator.setTextAppearance(R.style.amu_ClusterIcon_TextAppearance);
        iconGenerator.setBackground(makeClusterBackground());
        this.mClusterManager = clusterManager;
    }

    @Override // com.google.maps.android.clustering.view.ClusterRenderer
    public void onAdd() {
        this.mClusterManager.getMarkerCollection().setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() { // from class: com.google.maps.android.clustering.view.DefaultAdvancedMarkersClusterRenderer.1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.google.android.gms.maps.GoogleMap.OnMarkerClickListener
            public boolean onMarkerClick(Marker marker) {
                return DefaultAdvancedMarkersClusterRenderer.this.mItemClickListener != null && DefaultAdvancedMarkersClusterRenderer.this.mItemClickListener.onClusterItemClick((ClusterItem) DefaultAdvancedMarkersClusterRenderer.this.mMarkerCache.get(marker));
            }
        });
        this.mClusterManager.getMarkerCollection().setOnInfoWindowClickListener(new GoogleMap.OnInfoWindowClickListener() { // from class: com.google.maps.android.clustering.view.DefaultAdvancedMarkersClusterRenderer.2
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.google.android.gms.maps.GoogleMap.OnInfoWindowClickListener
            public void onInfoWindowClick(Marker marker) {
                if (DefaultAdvancedMarkersClusterRenderer.this.mItemInfoWindowClickListener != null) {
                    DefaultAdvancedMarkersClusterRenderer.this.mItemInfoWindowClickListener.onClusterItemInfoWindowClick((ClusterItem) DefaultAdvancedMarkersClusterRenderer.this.mMarkerCache.get(marker));
                }
            }
        });
        this.mClusterManager.getMarkerCollection().setOnInfoWindowLongClickListener(new GoogleMap.OnInfoWindowLongClickListener() { // from class: com.google.maps.android.clustering.view.DefaultAdvancedMarkersClusterRenderer$$ExternalSyntheticLambda0
            @Override // com.google.android.gms.maps.GoogleMap.OnInfoWindowLongClickListener
            public final void onInfoWindowLongClick(Marker marker) {
                DefaultAdvancedMarkersClusterRenderer.this.m210xfde6dfc5(marker);
            }
        });
        this.mClusterManager.getClusterMarkerCollection().setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() { // from class: com.google.maps.android.clustering.view.DefaultAdvancedMarkersClusterRenderer$$ExternalSyntheticLambda1
            @Override // com.google.android.gms.maps.GoogleMap.OnMarkerClickListener
            public final boolean onMarkerClick(Marker marker) {
                return DefaultAdvancedMarkersClusterRenderer.this.m211x50fc206(marker);
            }
        });
        this.mClusterManager.getClusterMarkerCollection().setOnInfoWindowClickListener(new GoogleMap.OnInfoWindowClickListener() { // from class: com.google.maps.android.clustering.view.DefaultAdvancedMarkersClusterRenderer$$ExternalSyntheticLambda2
            @Override // com.google.android.gms.maps.GoogleMap.OnInfoWindowClickListener
            public final void onInfoWindowClick(Marker marker) {
                DefaultAdvancedMarkersClusterRenderer.this.m212xc38a447(marker);
            }
        });
        this.mClusterManager.getClusterMarkerCollection().setOnInfoWindowLongClickListener(new GoogleMap.OnInfoWindowLongClickListener() { // from class: com.google.maps.android.clustering.view.DefaultAdvancedMarkersClusterRenderer$$ExternalSyntheticLambda3
            @Override // com.google.android.gms.maps.GoogleMap.OnInfoWindowLongClickListener
            public final void onInfoWindowLongClick(Marker marker) {
                DefaultAdvancedMarkersClusterRenderer.this.m213x13618688(marker);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$onAdd$0$com-google-maps-android-clustering-view-DefaultAdvancedMarkersClusterRenderer  reason: not valid java name */
    public /* synthetic */ void m210xfde6dfc5(Marker marker) {
        ClusterManager.OnClusterItemInfoWindowLongClickListener<T> onClusterItemInfoWindowLongClickListener = this.mItemInfoWindowLongClickListener;
        if (onClusterItemInfoWindowLongClickListener != null) {
            onClusterItemInfoWindowLongClickListener.onClusterItemInfoWindowLongClick(this.mMarkerCache.get(marker));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$onAdd$1$com-google-maps-android-clustering-view-DefaultAdvancedMarkersClusterRenderer  reason: not valid java name */
    public /* synthetic */ boolean m211x50fc206(Marker marker) {
        ClusterManager.OnClusterClickListener<T> onClusterClickListener = this.mClickListener;
        return onClusterClickListener != null && onClusterClickListener.onClusterClick(this.mClusterMarkerCache.get(marker));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$onAdd$2$com-google-maps-android-clustering-view-DefaultAdvancedMarkersClusterRenderer  reason: not valid java name */
    public /* synthetic */ void m212xc38a447(Marker marker) {
        ClusterManager.OnClusterInfoWindowClickListener<T> onClusterInfoWindowClickListener = this.mInfoWindowClickListener;
        if (onClusterInfoWindowClickListener != null) {
            onClusterInfoWindowClickListener.onClusterInfoWindowClick(this.mClusterMarkerCache.get(marker));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$onAdd$3$com-google-maps-android-clustering-view-DefaultAdvancedMarkersClusterRenderer  reason: not valid java name */
    public /* synthetic */ void m213x13618688(Marker marker) {
        ClusterManager.OnClusterInfoWindowLongClickListener<T> onClusterInfoWindowLongClickListener = this.mInfoWindowLongClickListener;
        if (onClusterInfoWindowLongClickListener != null) {
            onClusterInfoWindowLongClickListener.onClusterInfoWindowLongClick(this.mClusterMarkerCache.get(marker));
        }
    }

    @Override // com.google.maps.android.clustering.view.ClusterRenderer
    public void onRemove() {
        this.mClusterManager.getMarkerCollection().setOnMarkerClickListener(null);
        this.mClusterManager.getMarkerCollection().setOnInfoWindowClickListener(null);
        this.mClusterManager.getMarkerCollection().setOnInfoWindowLongClickListener(null);
        this.mClusterManager.getClusterMarkerCollection().setOnMarkerClickListener(null);
        this.mClusterManager.getClusterMarkerCollection().setOnInfoWindowClickListener(null);
        this.mClusterManager.getClusterMarkerCollection().setOnInfoWindowLongClickListener(null);
    }

    private LayerDrawable makeClusterBackground() {
        this.mColoredCircleBackground = new ShapeDrawable(new OvalShape());
        ShapeDrawable shapeDrawable = new ShapeDrawable(new OvalShape());
        shapeDrawable.getPaint().setColor(-2130706433);
        LayerDrawable layerDrawable = new LayerDrawable(new Drawable[]{shapeDrawable, this.mColoredCircleBackground});
        int i = (int) (this.mDensity * 3.0f);
        layerDrawable.setLayerInset(1, i, i, i, i);
        return layerDrawable;
    }

    private SquareTextView makeSquareTextView(Context context) {
        SquareTextView squareTextView = new SquareTextView(context);
        squareTextView.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
        squareTextView.setId(R.id.amu_text);
        int i = (int) (this.mDensity * 12.0f);
        squareTextView.setPadding(i, i, i, i);
        return squareTextView;
    }

    @Override // com.google.maps.android.clustering.view.ClusterRenderer
    public int getColor(int i) {
        float min = 300.0f - Math.min(i, 300.0f);
        return Color.HSVToColor(new float[]{((min * min) / 90000.0f) * 220.0f, 1.0f, 0.6f});
    }

    @Override // com.google.maps.android.clustering.view.ClusterRenderer
    public int getClusterTextAppearance(int i) {
        return R.style.amu_ClusterIcon_TextAppearance;
    }

    protected String getClusterText(int i) {
        if (i < BUCKETS[0]) {
            return String.valueOf(i);
        }
        StringBuilder sb = new StringBuilder();
        sb.append(i);
        sb.append("+");
        return sb.toString();
    }

    protected int getBucket(Cluster<T> cluster) {
        int size = cluster.getSize();
        int i = 0;
        if (size <= BUCKETS[0]) {
            return size;
        }
        while (true) {
            int[] iArr = BUCKETS;
            if (i < iArr.length - 1) {
                int i2 = i + 1;
                if (size < iArr[i2]) {
                    return iArr[i];
                }
                i = i2;
            } else {
                return iArr[iArr.length - 1];
            }
        }
    }

    public int getMinClusterSize() {
        return this.mMinClusterSize;
    }

    public void setMinClusterSize(int i) {
        this.mMinClusterSize = i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes7.dex */
    public class ViewModifier extends Handler {
        private static final int RUN_TASK = 0;
        private static final int TASK_FINISHED = 1;
        private DefaultAdvancedMarkersClusterRenderer<T>.RenderTask mNextClusters;
        private boolean mViewModificationInProgress;

        private ViewModifier() {
            this.mViewModificationInProgress = false;
            this.mNextClusters = null;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            DefaultAdvancedMarkersClusterRenderer<T>.RenderTask renderTask;
            if (message.what == 1) {
                this.mViewModificationInProgress = false;
                if (this.mNextClusters != null) {
                    sendEmptyMessage(0);
                    return;
                }
                return;
            }
            removeMessages(0);
            if (this.mViewModificationInProgress || this.mNextClusters == null) {
                return;
            }
            Projection projection = DefaultAdvancedMarkersClusterRenderer.this.mMap.getProjection();
            synchronized (this) {
                renderTask = this.mNextClusters;
                this.mNextClusters = null;
                this.mViewModificationInProgress = true;
            }
            renderTask.setCallback(new Runnable() { // from class: com.google.maps.android.clustering.view.DefaultAdvancedMarkersClusterRenderer$ViewModifier$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    DefaultAdvancedMarkersClusterRenderer.ViewModifier.this.m214x1c4a00de();
                }
            });
            renderTask.setProjection(projection);
            renderTask.setMapZoom(DefaultAdvancedMarkersClusterRenderer.this.mMap.getCameraPosition().zoom);
            DefaultAdvancedMarkersClusterRenderer.this.mExecutor.execute(renderTask);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: lambda$handleMessage$0$com-google-maps-android-clustering-view-DefaultAdvancedMarkersClusterRenderer$ViewModifier  reason: not valid java name */
        public /* synthetic */ void m214x1c4a00de() {
            sendEmptyMessage(1);
        }

        public void queue(Set<? extends Cluster<T>> set) {
            synchronized (this) {
                this.mNextClusters = new RenderTask(set);
            }
            sendEmptyMessage(0);
        }
    }

    protected boolean shouldRenderAsCluster(Cluster<T> cluster) {
        return cluster.getSize() >= this.mMinClusterSize;
    }

    protected boolean shouldRender(Set<? extends Cluster<T>> set, Set<? extends Cluster<T>> set2) {
        return !set2.equals(set);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes7.dex */
    public class RenderTask implements Runnable {
        final Set<? extends Cluster<T>> clusters;
        private Runnable mCallback;
        private float mMapZoom;
        private Projection mProjection;
        private SphericalMercatorProjection mSphericalMercatorProjection;

        private RenderTask(Set<? extends Cluster<T>> set) {
            this.clusters = set;
        }

        public void setCallback(Runnable runnable) {
            this.mCallback = runnable;
        }

        public void setProjection(Projection projection) {
            this.mProjection = projection;
        }

        public void setMapZoom(float f) {
            this.mMapZoom = f;
            this.mSphericalMercatorProjection = new SphericalMercatorProjection(Math.pow(2.0d, Math.min(f, DefaultAdvancedMarkersClusterRenderer.this.mZoom)) * 256.0d);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r2v2, types: [com.google.maps.android.clustering.view.DefaultAdvancedMarkersClusterRenderer$1] */
        /* JADX WARN: Type inference failed for: r2v3, types: [java.util.List] */
        /* JADX WARN: Type inference failed for: r2v5, types: [java.util.List, java.util.ArrayList] */
        @Override // java.lang.Runnable
        public void run() {
            LatLngBounds build;
            ArrayList arrayList;
            DefaultAdvancedMarkersClusterRenderer defaultAdvancedMarkersClusterRenderer = DefaultAdvancedMarkersClusterRenderer.this;
            if (!defaultAdvancedMarkersClusterRenderer.shouldRender(defaultAdvancedMarkersClusterRenderer.immutableOf(defaultAdvancedMarkersClusterRenderer.mClusters), DefaultAdvancedMarkersClusterRenderer.this.immutableOf(this.clusters))) {
                this.mCallback.run();
                return;
            }
            ?? r2 = 0;
            MarkerModifier markerModifier = new MarkerModifier();
            float f = this.mMapZoom;
            boolean z = f > DefaultAdvancedMarkersClusterRenderer.this.mZoom;
            float f2 = DefaultAdvancedMarkersClusterRenderer.this.mZoom;
            Set<MarkerWithPosition> set = DefaultAdvancedMarkersClusterRenderer.this.mMarkers;
            try {
                build = this.mProjection.getVisibleRegion().latLngBounds;
            } catch (Exception unused) {
                build = LatLngBounds.builder().include(new LatLng(FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE)).build();
            }
            if (DefaultAdvancedMarkersClusterRenderer.this.mClusters == null || !DefaultAdvancedMarkersClusterRenderer.this.mAnimate) {
                arrayList = null;
            } else {
                arrayList = new ArrayList();
                for (Cluster<T> cluster : DefaultAdvancedMarkersClusterRenderer.this.mClusters) {
                    if (DefaultAdvancedMarkersClusterRenderer.this.shouldRenderAsCluster(cluster) && build.contains(cluster.getPosition())) {
                        arrayList.add(this.mSphericalMercatorProjection.toPoint(cluster.getPosition()));
                    }
                }
            }
            Set newSetFromMap = Collections.newSetFromMap(new ConcurrentHashMap());
            for (Cluster<T> cluster2 : this.clusters) {
                boolean contains = build.contains(cluster2.getPosition());
                if (z && contains && DefaultAdvancedMarkersClusterRenderer.this.mAnimate) {
                    Point findClosestCluster = DefaultAdvancedMarkersClusterRenderer.this.findClosestCluster(arrayList, this.mSphericalMercatorProjection.toPoint(cluster2.getPosition()));
                    if (findClosestCluster != null) {
                        markerModifier.add(true, new CreateMarkerTask(cluster2, newSetFromMap, this.mSphericalMercatorProjection.toLatLng(findClosestCluster)));
                    } else {
                        markerModifier.add(true, new CreateMarkerTask(cluster2, newSetFromMap, null));
                    }
                } else {
                    markerModifier.add(contains, new CreateMarkerTask(cluster2, newSetFromMap, null));
                }
            }
            markerModifier.waitUntilFree();
            set.removeAll(newSetFromMap);
            if (DefaultAdvancedMarkersClusterRenderer.this.mAnimate) {
                r2 = new ArrayList();
                for (Cluster<T> cluster3 : this.clusters) {
                    if (DefaultAdvancedMarkersClusterRenderer.this.shouldRenderAsCluster(cluster3) && build.contains(cluster3.getPosition())) {
                        r2.add(this.mSphericalMercatorProjection.toPoint(cluster3.getPosition()));
                    }
                }
            }
            for (MarkerWithPosition markerWithPosition : set) {
                boolean contains2 = build.contains(markerWithPosition.position);
                if (!z && f - f2 > -3.0f && contains2 && DefaultAdvancedMarkersClusterRenderer.this.mAnimate) {
                    Point findClosestCluster2 = DefaultAdvancedMarkersClusterRenderer.this.findClosestCluster(r2, this.mSphericalMercatorProjection.toPoint(markerWithPosition.position));
                    if (findClosestCluster2 != null) {
                        markerModifier.animateThenRemove(markerWithPosition, markerWithPosition.position, this.mSphericalMercatorProjection.toLatLng(findClosestCluster2));
                    } else {
                        markerModifier.remove(true, markerWithPosition.marker);
                    }
                } else {
                    markerModifier.remove(contains2, markerWithPosition.marker);
                }
            }
            markerModifier.waitUntilFree();
            DefaultAdvancedMarkersClusterRenderer.this.mMarkers = newSetFromMap;
            DefaultAdvancedMarkersClusterRenderer.this.mClusters = this.clusters;
            DefaultAdvancedMarkersClusterRenderer.this.mZoom = f;
            this.mCallback.run();
        }
    }

    @Override // com.google.maps.android.clustering.view.ClusterRenderer
    public void onClustersChanged(Set<? extends Cluster<T>> set) {
        this.mViewModifier.queue(set);
    }

    @Override // com.google.maps.android.clustering.view.ClusterRenderer
    public void setOnClusterClickListener(ClusterManager.OnClusterClickListener<T> onClusterClickListener) {
        this.mClickListener = onClusterClickListener;
    }

    @Override // com.google.maps.android.clustering.view.ClusterRenderer
    public void setOnClusterInfoWindowClickListener(ClusterManager.OnClusterInfoWindowClickListener<T> onClusterInfoWindowClickListener) {
        this.mInfoWindowClickListener = onClusterInfoWindowClickListener;
    }

    @Override // com.google.maps.android.clustering.view.ClusterRenderer
    public void setOnClusterInfoWindowLongClickListener(ClusterManager.OnClusterInfoWindowLongClickListener<T> onClusterInfoWindowLongClickListener) {
        this.mInfoWindowLongClickListener = onClusterInfoWindowLongClickListener;
    }

    @Override // com.google.maps.android.clustering.view.ClusterRenderer
    public void setOnClusterItemClickListener(ClusterManager.OnClusterItemClickListener<T> onClusterItemClickListener) {
        this.mItemClickListener = onClusterItemClickListener;
    }

    @Override // com.google.maps.android.clustering.view.ClusterRenderer
    public void setOnClusterItemInfoWindowClickListener(ClusterManager.OnClusterItemInfoWindowClickListener<T> onClusterItemInfoWindowClickListener) {
        this.mItemInfoWindowClickListener = onClusterItemInfoWindowClickListener;
    }

    @Override // com.google.maps.android.clustering.view.ClusterRenderer
    public void setOnClusterItemInfoWindowLongClickListener(ClusterManager.OnClusterItemInfoWindowLongClickListener<T> onClusterItemInfoWindowLongClickListener) {
        this.mItemInfoWindowLongClickListener = onClusterItemInfoWindowLongClickListener;
    }

    @Override // com.google.maps.android.clustering.view.ClusterRenderer
    public void setAnimation(boolean z) {
        this.mAnimate = z;
    }

    @Override // com.google.maps.android.clustering.view.ClusterRenderer
    public void setAnimationDuration(long j) {
        this.mAnimationDurationMs = j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Set<? extends Cluster<T>> immutableOf(Set<? extends Cluster<T>> set) {
        return set != null ? Collections.unmodifiableSet(set) : Collections.emptySet();
    }

    private static double distanceSquared(Point point, Point point2) {
        return ((point.x - point2.x) * (point.x - point2.x)) + ((point.y - point2.y) * (point.y - point2.y));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Point findClosestCluster(List<Point> list, Point point) {
        Point point2 = null;
        if (list != null && !list.isEmpty()) {
            int maxDistanceBetweenClusteredItems = this.mClusterManager.getAlgorithm().getMaxDistanceBetweenClusteredItems();
            double d = maxDistanceBetweenClusteredItems * maxDistanceBetweenClusteredItems;
            for (Point point3 : list) {
                double distanceSquared = distanceSquared(point3, point);
                if (distanceSquared < d) {
                    point2 = point3;
                    d = distanceSquared;
                }
            }
        }
        return point2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes7.dex */
    public class MarkerModifier extends Handler implements MessageQueue.IdleHandler {
        private static final int BLANK = 0;
        private final Condition busyCondition;
        private final Lock lock;
        private Queue<DefaultAdvancedMarkersClusterRenderer<T>.AnimationTask> mAnimationTasks;
        private Queue<DefaultAdvancedMarkersClusterRenderer<T>.CreateMarkerTask> mCreateMarkerTasks;
        private boolean mListenerAdded;
        private Queue<DefaultAdvancedMarkersClusterRenderer<T>.CreateMarkerTask> mOnScreenCreateMarkerTasks;
        private Queue<Marker> mOnScreenRemoveMarkerTasks;
        private Queue<Marker> mRemoveMarkerTasks;

        private MarkerModifier() {
            super(Looper.getMainLooper());
            ReentrantLock reentrantLock = new ReentrantLock();
            this.lock = reentrantLock;
            this.busyCondition = reentrantLock.newCondition();
            this.mCreateMarkerTasks = new LinkedList();
            this.mOnScreenCreateMarkerTasks = new LinkedList();
            this.mRemoveMarkerTasks = new LinkedList();
            this.mOnScreenRemoveMarkerTasks = new LinkedList();
            this.mAnimationTasks = new LinkedList();
        }

        public void add(boolean z, DefaultAdvancedMarkersClusterRenderer<T>.CreateMarkerTask createMarkerTask) {
            this.lock.lock();
            sendEmptyMessage(0);
            if (z) {
                this.mOnScreenCreateMarkerTasks.add(createMarkerTask);
            } else {
                this.mCreateMarkerTasks.add(createMarkerTask);
            }
            this.lock.unlock();
        }

        public void remove(boolean z, Marker marker) {
            this.lock.lock();
            sendEmptyMessage(0);
            if (z) {
                this.mOnScreenRemoveMarkerTasks.add(marker);
            } else {
                this.mRemoveMarkerTasks.add(marker);
            }
            this.lock.unlock();
        }

        public void animate(MarkerWithPosition markerWithPosition, LatLng latLng, LatLng latLng2) {
            this.lock.lock();
            this.mAnimationTasks.add(new AnimationTask(markerWithPosition, latLng, latLng2));
            this.lock.unlock();
        }

        public void animateThenRemove(MarkerWithPosition markerWithPosition, LatLng latLng, LatLng latLng2) {
            this.lock.lock();
            DefaultAdvancedMarkersClusterRenderer<T>.AnimationTask animationTask = new AnimationTask(markerWithPosition, latLng, latLng2);
            animationTask.removeOnAnimationComplete(DefaultAdvancedMarkersClusterRenderer.this.mClusterManager.getMarkerManager());
            this.mAnimationTasks.add(animationTask);
            this.lock.unlock();
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (!this.mListenerAdded) {
                Looper.myQueue().addIdleHandler(this);
                this.mListenerAdded = true;
            }
            removeMessages(0);
            this.lock.lock();
            for (int i = 0; i < 10; i++) {
                try {
                    performNextTask();
                } finally {
                    this.lock.unlock();
                }
            }
            if (!isBusy()) {
                this.mListenerAdded = false;
                Looper.myQueue().removeIdleHandler(this);
                this.busyCondition.signalAll();
            } else {
                sendEmptyMessageDelayed(0, 10L);
            }
        }

        private void performNextTask() {
            if (!this.mOnScreenRemoveMarkerTasks.isEmpty()) {
                removeMarker(this.mOnScreenRemoveMarkerTasks.poll());
            } else if (!this.mAnimationTasks.isEmpty()) {
                this.mAnimationTasks.poll().perform();
            } else if (this.mOnScreenCreateMarkerTasks.isEmpty()) {
                if (this.mCreateMarkerTasks.isEmpty()) {
                    if (this.mRemoveMarkerTasks.isEmpty()) {
                        return;
                    }
                    removeMarker(this.mRemoveMarkerTasks.poll());
                    return;
                }
                this.mCreateMarkerTasks.poll().perform(this);
            } else {
                this.mOnScreenCreateMarkerTasks.poll().perform(this);
            }
        }

        private void removeMarker(Marker marker) {
            DefaultAdvancedMarkersClusterRenderer.this.mMarkerCache.remove(marker);
            DefaultAdvancedMarkersClusterRenderer.this.mClusterMarkerCache.remove(marker);
            DefaultAdvancedMarkersClusterRenderer.this.mClusterManager.getMarkerManager().remove(marker);
        }

        public boolean isBusy() {
            boolean z;
            try {
                this.lock.lock();
                if (this.mCreateMarkerTasks.isEmpty() && this.mOnScreenCreateMarkerTasks.isEmpty() && this.mOnScreenRemoveMarkerTasks.isEmpty() && this.mRemoveMarkerTasks.isEmpty()) {
                    if (this.mAnimationTasks.isEmpty()) {
                        z = false;
                        return z;
                    }
                }
                z = true;
                return z;
            } finally {
                this.lock.unlock();
            }
        }

        public void waitUntilFree() {
            while (isBusy()) {
                sendEmptyMessage(0);
                this.lock.lock();
                try {
                    try {
                        if (isBusy()) {
                            this.busyCondition.await();
                        }
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                } finally {
                    this.lock.unlock();
                }
            }
        }

        @Override // android.os.MessageQueue.IdleHandler
        public boolean queueIdle() {
            sendEmptyMessage(0);
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes7.dex */
    public static class MarkerCache<T> {
        private Map<T, Marker> mCache;
        private Map<Marker, T> mCacheReverse;

        private MarkerCache() {
            this.mCache = new HashMap();
            this.mCacheReverse = new HashMap();
        }

        public Marker get(T t) {
            return this.mCache.get(t);
        }

        public T get(Marker marker) {
            return this.mCacheReverse.get(marker);
        }

        public void put(T t, Marker marker) {
            this.mCache.put(t, marker);
            this.mCacheReverse.put(marker, t);
        }

        public void remove(Marker marker) {
            T t = this.mCacheReverse.get(marker);
            this.mCacheReverse.remove(marker);
            this.mCache.remove(t);
        }
    }

    protected void onBeforeClusterItemRendered(T t, AdvancedMarkerOptions advancedMarkerOptions) {
        if (t.getTitle() != null && t.getSnippet() != null) {
            advancedMarkerOptions.title(t.getTitle());
            advancedMarkerOptions.snippet(t.getSnippet());
        } else if (t.getTitle() != null) {
            advancedMarkerOptions.title(t.getTitle());
        } else if (t.getSnippet() != null) {
            advancedMarkerOptions.title(t.getSnippet());
        }
    }

    protected void onClusterItemUpdated(T t, Marker marker) {
        boolean z = false;
        boolean z2 = true;
        if (t.getTitle() != null && t.getSnippet() != null) {
            if (!t.getTitle().equals(marker.getTitle())) {
                marker.setTitle(t.getTitle());
                z = true;
            }
            if (!t.getSnippet().equals(marker.getSnippet())) {
                marker.setSnippet(t.getSnippet());
                z = true;
            }
        } else {
            if (t.getSnippet() != null && !t.getSnippet().equals(marker.getTitle())) {
                marker.setTitle(t.getSnippet());
            } else if (t.getTitle() != null && !t.getTitle().equals(marker.getTitle())) {
                marker.setTitle(t.getTitle());
            }
            z = true;
        }
        if (marker.getPosition().equals(t.getPosition())) {
            z2 = z;
        } else {
            marker.setPosition(t.getPosition());
            if (t.getZIndex() != null) {
                marker.setZIndex(t.getZIndex().floatValue());
            }
        }
        if (z2 && marker.isInfoWindowShown()) {
            marker.showInfoWindow();
        }
    }

    protected void onBeforeClusterRendered(Cluster<T> cluster, AdvancedMarkerOptions advancedMarkerOptions) {
        advancedMarkerOptions.icon(getDescriptorForCluster(cluster));
    }

    protected BitmapDescriptor getDescriptorForCluster(Cluster<T> cluster) {
        int bucket = getBucket(cluster);
        BitmapDescriptor bitmapDescriptor = this.mIcons.get(bucket);
        if (bitmapDescriptor == null) {
            this.mColoredCircleBackground.getPaint().setColor(getColor(bucket));
            this.mIconGenerator.setTextAppearance(getClusterTextAppearance(bucket));
            BitmapDescriptor fromBitmap = BitmapDescriptorFactory.fromBitmap(this.mIconGenerator.makeIcon(getClusterText(bucket)));
            this.mIcons.put(bucket, fromBitmap);
            return fromBitmap;
        }
        return bitmapDescriptor;
    }

    protected void onClusterUpdated(Cluster<T> cluster, AdvancedMarker advancedMarker) {
        advancedMarker.setIcon(getDescriptorForCluster(cluster));
    }

    public Marker getMarker(T t) {
        return this.mMarkerCache.get((MarkerCache<T>) t);
    }

    public T getClusterItem(Marker marker) {
        return this.mMarkerCache.get(marker);
    }

    public Marker getMarker(Cluster<T> cluster) {
        return this.mClusterMarkerCache.get((MarkerCache<Cluster<T>>) cluster);
    }

    public Cluster<T> getCluster(Marker marker) {
        return this.mClusterMarkerCache.get(marker);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes7.dex */
    public class CreateMarkerTask {
        private final LatLng animateFrom;
        private final Cluster<T> cluster;
        private final Set<MarkerWithPosition> newMarkers;

        public CreateMarkerTask(Cluster<T> cluster, Set<MarkerWithPosition> set, LatLng latLng) {
            this.cluster = cluster;
            this.newMarkers = set;
            this.animateFrom = latLng;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void perform(DefaultAdvancedMarkersClusterRenderer<T>.MarkerModifier markerModifier) {
            MarkerWithPosition markerWithPosition;
            MarkerWithPosition markerWithPosition2;
            if (DefaultAdvancedMarkersClusterRenderer.this.shouldRenderAsCluster(this.cluster)) {
                AdvancedMarker advancedMarker = (AdvancedMarker) DefaultAdvancedMarkersClusterRenderer.this.mClusterMarkerCache.get((MarkerCache) this.cluster);
                if (advancedMarker == null) {
                    AdvancedMarkerOptions advancedMarkerOptions = new AdvancedMarkerOptions();
                    LatLng latLng = this.animateFrom;
                    if (latLng == null) {
                        latLng = this.cluster.getPosition();
                    }
                    AdvancedMarkerOptions position = advancedMarkerOptions.position(latLng);
                    DefaultAdvancedMarkersClusterRenderer.this.onBeforeClusterRendered(this.cluster, position);
                    advancedMarker = (AdvancedMarker) DefaultAdvancedMarkersClusterRenderer.this.mClusterManager.getClusterMarkerCollection().addMarker(position);
                    DefaultAdvancedMarkersClusterRenderer.this.mClusterMarkerCache.put(this.cluster, advancedMarker);
                    markerWithPosition = new MarkerWithPosition(advancedMarker);
                    LatLng latLng2 = this.animateFrom;
                    if (latLng2 != null) {
                        markerModifier.animate(markerWithPosition, latLng2, this.cluster.getPosition());
                    }
                } else {
                    markerWithPosition = new MarkerWithPosition(advancedMarker);
                    DefaultAdvancedMarkersClusterRenderer.this.onClusterUpdated(this.cluster, advancedMarker);
                }
                DefaultAdvancedMarkersClusterRenderer.this.onClusterRendered(this.cluster, advancedMarker);
                this.newMarkers.add(markerWithPosition);
                return;
            }
            for (T t : this.cluster.getItems()) {
                AdvancedMarker advancedMarker2 = (AdvancedMarker) DefaultAdvancedMarkersClusterRenderer.this.mMarkerCache.get((MarkerCache) t);
                if (advancedMarker2 == null) {
                    AdvancedMarkerOptions advancedMarkerOptions2 = new AdvancedMarkerOptions();
                    LatLng latLng3 = this.animateFrom;
                    if (latLng3 != null) {
                        advancedMarkerOptions2.position(latLng3);
                    } else {
                        advancedMarkerOptions2.position(t.getPosition());
                        if (t.getZIndex() != null) {
                            advancedMarkerOptions2.zIndex(t.getZIndex().floatValue());
                        }
                    }
                    DefaultAdvancedMarkersClusterRenderer.this.onBeforeClusterItemRendered(t, advancedMarkerOptions2);
                    advancedMarker2 = (AdvancedMarker) DefaultAdvancedMarkersClusterRenderer.this.mClusterManager.getMarkerCollection().addMarker(advancedMarkerOptions2);
                    markerWithPosition2 = new MarkerWithPosition(advancedMarker2);
                    DefaultAdvancedMarkersClusterRenderer.this.mMarkerCache.put(t, advancedMarker2);
                    LatLng latLng4 = this.animateFrom;
                    if (latLng4 != null) {
                        markerModifier.animate(markerWithPosition2, latLng4, t.getPosition());
                    }
                } else {
                    markerWithPosition2 = new MarkerWithPosition(advancedMarker2);
                    DefaultAdvancedMarkersClusterRenderer.this.onClusterItemUpdated(t, advancedMarker2);
                }
                DefaultAdvancedMarkersClusterRenderer.this.onClusterItemRendered(t, advancedMarker2);
                this.newMarkers.add(markerWithPosition2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes7.dex */
    public static class MarkerWithPosition {
        private final Marker marker;
        private LatLng position;

        private MarkerWithPosition(Marker marker) {
            this.marker = marker;
            this.position = marker.getPosition();
        }

        public boolean equals(Object obj) {
            if (obj instanceof MarkerWithPosition) {
                return this.marker.equals(((MarkerWithPosition) obj).marker);
            }
            return false;
        }

        public int hashCode() {
            return this.marker.hashCode();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes7.dex */
    public class AnimationTask extends AnimatorListenerAdapter implements ValueAnimator.AnimatorUpdateListener {
        private final LatLng from;
        private MarkerManager mMarkerManager;
        private boolean mRemoveOnComplete;
        private final Marker marker;
        private final MarkerWithPosition markerWithPosition;
        private final LatLng to;

        private AnimationTask(MarkerWithPosition markerWithPosition, LatLng latLng, LatLng latLng2) {
            this.markerWithPosition = markerWithPosition;
            this.marker = markerWithPosition.marker;
            this.from = latLng;
            this.to = latLng2;
        }

        public void perform() {
            ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
            ofFloat.setInterpolator(DefaultAdvancedMarkersClusterRenderer.ANIMATION_INTERP);
            ofFloat.setDuration(DefaultAdvancedMarkersClusterRenderer.this.mAnimationDurationMs);
            ofFloat.addUpdateListener(this);
            ofFloat.addListener(this);
            ofFloat.start();
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (this.mRemoveOnComplete) {
                DefaultAdvancedMarkersClusterRenderer.this.mMarkerCache.remove(this.marker);
                DefaultAdvancedMarkersClusterRenderer.this.mClusterMarkerCache.remove(this.marker);
                this.mMarkerManager.remove(this.marker);
            }
            this.markerWithPosition.position = this.to;
        }

        public void removeOnAnimationComplete(MarkerManager markerManager) {
            this.mMarkerManager = markerManager;
            this.mRemoveOnComplete = true;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            float animatedFraction = valueAnimator.getAnimatedFraction();
            double d = this.to.latitude;
            double d2 = this.from.latitude;
            double d3 = animatedFraction;
            double d4 = this.from.latitude;
            double d5 = this.to.longitude - this.from.longitude;
            if (Math.abs(d5) > 180.0d) {
                d5 -= Math.signum(d5) * 360.0d;
            }
            double d6 = this.from.longitude;
            Double.isNaN(d3);
            Double.isNaN(d3);
            this.marker.setPosition(new LatLng(((d - d2) * d3) + d4, (d5 * d3) + d6));
        }
    }
}
