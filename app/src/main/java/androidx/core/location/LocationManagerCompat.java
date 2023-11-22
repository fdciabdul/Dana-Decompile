package androidx.core.location;

import android.location.GnssStatus;
import android.location.GpsStatus;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import androidx.collection.SimpleArrayMap;
import androidx.core.location.GnssStatusCompat;
import androidx.core.location.LocationManagerCompat;
import androidx.core.util.Consumer;
import androidx.core.util.ObjectsCompat;
import androidx.core.util.Preconditions;
import java.lang.ref.WeakReference;
import java.util.List;
import java.util.WeakHashMap;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;

/* loaded from: classes6.dex */
public final class LocationManagerCompat {
    static final WeakHashMap<LocationListenerKey, WeakReference<LocationListenerTransport>> KClassImpl$Data$declaredNonStaticMembers$2 = new WeakHashMap<>();

    /* loaded from: classes6.dex */
    static class GnssListenersHolder {
        static final SimpleArrayMap<Object, Object> KClassImpl$Data$declaredNonStaticMembers$2 = new SimpleArrayMap<>();

        private GnssListenersHolder() {
        }
    }

    private LocationManagerCompat() {
    }

    /* loaded from: classes6.dex */
    static class LocationListenerKey {
        final LocationListenerCompat BuiltInFictitiousFunctionClassFactory;
        final String PlaceComponentResult;

        public boolean equals(Object obj) {
            if (obj instanceof LocationListenerKey) {
                LocationListenerKey locationListenerKey = (LocationListenerKey) obj;
                return this.PlaceComponentResult.equals(locationListenerKey.PlaceComponentResult) && this.BuiltInFictitiousFunctionClassFactory.equals(locationListenerKey.BuiltInFictitiousFunctionClassFactory);
            }
            return false;
        }

        public int hashCode() {
            return ObjectsCompat.PlaceComponentResult(this.PlaceComponentResult, this.BuiltInFictitiousFunctionClassFactory);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public static class LocationListenerTransport implements LocationListener {
        final Executor MyBillsEntityDataFactory;
        volatile LocationListenerKey PlaceComponentResult;

        @Override // android.location.LocationListener
        public void onLocationChanged(final Location location) {
            if (this.PlaceComponentResult == null) {
                return;
            }
            this.MyBillsEntityDataFactory.execute(new Runnable() { // from class: androidx.core.location.LocationManagerCompat$LocationListenerTransport$$ExternalSyntheticLambda4
                @Override // java.lang.Runnable
                public final void run() {
                    LocationManagerCompat.LocationListenerTransport.this.KClassImpl$Data$declaredNonStaticMembers$2(location);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public /* synthetic */ void KClassImpl$Data$declaredNonStaticMembers$2(Location location) {
            LocationListenerKey locationListenerKey = this.PlaceComponentResult;
            if (locationListenerKey == null) {
                return;
            }
            locationListenerKey.BuiltInFictitiousFunctionClassFactory.onLocationChanged(location);
        }

        @Override // android.location.LocationListener
        public void onLocationChanged(final List<Location> list) {
            if (this.PlaceComponentResult == null) {
                return;
            }
            this.MyBillsEntityDataFactory.execute(new Runnable() { // from class: androidx.core.location.LocationManagerCompat$LocationListenerTransport$$ExternalSyntheticLambda2
                @Override // java.lang.Runnable
                public final void run() {
                    LocationManagerCompat.LocationListenerTransport.this.PlaceComponentResult(list);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public /* synthetic */ void PlaceComponentResult(List list) {
            LocationListenerKey locationListenerKey = this.PlaceComponentResult;
            if (locationListenerKey == null) {
                return;
            }
            locationListenerKey.BuiltInFictitiousFunctionClassFactory.onLocationChanged(list);
        }

        @Override // android.location.LocationListener
        public void onFlushComplete(final int i) {
            if (this.PlaceComponentResult == null) {
                return;
            }
            this.MyBillsEntityDataFactory.execute(new Runnable() { // from class: androidx.core.location.LocationManagerCompat$LocationListenerTransport$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    LocationManagerCompat.LocationListenerTransport.this.BuiltInFictitiousFunctionClassFactory(i);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public /* synthetic */ void BuiltInFictitiousFunctionClassFactory(int i) {
            LocationListenerKey locationListenerKey = this.PlaceComponentResult;
            if (locationListenerKey == null) {
                return;
            }
            locationListenerKey.BuiltInFictitiousFunctionClassFactory.onFlushComplete(i);
        }

        @Override // android.location.LocationListener
        public void onStatusChanged(final String str, final int i, final Bundle bundle) {
            if (this.PlaceComponentResult == null) {
                return;
            }
            this.MyBillsEntityDataFactory.execute(new Runnable() { // from class: androidx.core.location.LocationManagerCompat$LocationListenerTransport$$ExternalSyntheticLambda5
                @Override // java.lang.Runnable
                public final void run() {
                    LocationManagerCompat.LocationListenerTransport.this.KClassImpl$Data$declaredNonStaticMembers$2(str, i, bundle);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public /* synthetic */ void KClassImpl$Data$declaredNonStaticMembers$2(String str, int i, Bundle bundle) {
            LocationListenerKey locationListenerKey = this.PlaceComponentResult;
            if (locationListenerKey == null) {
                return;
            }
            locationListenerKey.BuiltInFictitiousFunctionClassFactory.onStatusChanged(str, i, bundle);
        }

        @Override // android.location.LocationListener
        public void onProviderEnabled(final String str) {
            if (this.PlaceComponentResult == null) {
                return;
            }
            this.MyBillsEntityDataFactory.execute(new Runnable() { // from class: androidx.core.location.LocationManagerCompat$LocationListenerTransport$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    LocationManagerCompat.LocationListenerTransport.this.getAuthRequestContext(str);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public /* synthetic */ void getAuthRequestContext(String str) {
            LocationListenerKey locationListenerKey = this.PlaceComponentResult;
            if (locationListenerKey == null) {
                return;
            }
            locationListenerKey.BuiltInFictitiousFunctionClassFactory.onProviderEnabled(str);
        }

        @Override // android.location.LocationListener
        public void onProviderDisabled(final String str) {
            if (this.PlaceComponentResult == null) {
                return;
            }
            this.MyBillsEntityDataFactory.execute(new Runnable() { // from class: androidx.core.location.LocationManagerCompat$LocationListenerTransport$$ExternalSyntheticLambda3
                @Override // java.lang.Runnable
                public final void run() {
                    LocationManagerCompat.LocationListenerTransport.this.MyBillsEntityDataFactory(str);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public /* synthetic */ void MyBillsEntityDataFactory(String str) {
            LocationListenerKey locationListenerKey = this.PlaceComponentResult;
            if (locationListenerKey == null) {
                return;
            }
            locationListenerKey.BuiltInFictitiousFunctionClassFactory.onProviderDisabled(str);
        }
    }

    /* loaded from: classes6.dex */
    static class GnssStatusTransport extends GnssStatus.Callback {
        final GnssStatusCompat.Callback MyBillsEntityDataFactory;

        @Override // android.location.GnssStatus.Callback
        public void onStarted() {
            this.MyBillsEntityDataFactory.MyBillsEntityDataFactory();
        }

        @Override // android.location.GnssStatus.Callback
        public void onStopped() {
            this.MyBillsEntityDataFactory.BuiltInFictitiousFunctionClassFactory();
        }

        @Override // android.location.GnssStatus.Callback
        public void onFirstFix(int i) {
            this.MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2(i);
        }

        @Override // android.location.GnssStatus.Callback
        public void onSatelliteStatusChanged(GnssStatus gnssStatus) {
            this.MyBillsEntityDataFactory.PlaceComponentResult(GnssStatusCompat.BuiltInFictitiousFunctionClassFactory(gnssStatus));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public static class PreRGnssStatusTransport extends GnssStatus.Callback {
        final GnssStatusCompat.Callback MyBillsEntityDataFactory;
        volatile Executor PlaceComponentResult;

        @Override // android.location.GnssStatus.Callback
        public void onStarted() {
            final Executor executor = this.PlaceComponentResult;
            if (executor == null) {
                return;
            }
            executor.execute(new Runnable() { // from class: androidx.core.location.LocationManagerCompat$PreRGnssStatusTransport$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    LocationManagerCompat.PreRGnssStatusTransport.this.MyBillsEntityDataFactory(executor);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public /* synthetic */ void MyBillsEntityDataFactory(Executor executor) {
            if (this.PlaceComponentResult != executor) {
                return;
            }
            this.MyBillsEntityDataFactory.MyBillsEntityDataFactory();
        }

        @Override // android.location.GnssStatus.Callback
        public void onStopped() {
            final Executor executor = this.PlaceComponentResult;
            if (executor == null) {
                return;
            }
            executor.execute(new Runnable() { // from class: androidx.core.location.LocationManagerCompat$PreRGnssStatusTransport$$ExternalSyntheticLambda3
                @Override // java.lang.Runnable
                public final void run() {
                    LocationManagerCompat.PreRGnssStatusTransport.this.getAuthRequestContext(executor);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public /* synthetic */ void getAuthRequestContext(Executor executor) {
            if (this.PlaceComponentResult != executor) {
                return;
            }
            this.MyBillsEntityDataFactory.BuiltInFictitiousFunctionClassFactory();
        }

        @Override // android.location.GnssStatus.Callback
        public void onFirstFix(final int i) {
            final Executor executor = this.PlaceComponentResult;
            if (executor == null) {
                return;
            }
            executor.execute(new Runnable() { // from class: androidx.core.location.LocationManagerCompat$PreRGnssStatusTransport$$ExternalSyntheticLambda2
                @Override // java.lang.Runnable
                public final void run() {
                    LocationManagerCompat.PreRGnssStatusTransport.this.MyBillsEntityDataFactory(executor, i);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public /* synthetic */ void MyBillsEntityDataFactory(Executor executor, int i) {
            if (this.PlaceComponentResult != executor) {
                return;
            }
            this.MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2(i);
        }

        @Override // android.location.GnssStatus.Callback
        public void onSatelliteStatusChanged(final GnssStatus gnssStatus) {
            final Executor executor = this.PlaceComponentResult;
            if (executor == null) {
                return;
            }
            executor.execute(new Runnable() { // from class: androidx.core.location.LocationManagerCompat$PreRGnssStatusTransport$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    LocationManagerCompat.PreRGnssStatusTransport.this.getAuthRequestContext(executor, gnssStatus);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public /* synthetic */ void getAuthRequestContext(Executor executor, GnssStatus gnssStatus) {
            if (this.PlaceComponentResult != executor) {
                return;
            }
            this.MyBillsEntityDataFactory.PlaceComponentResult(GnssStatusCompat.BuiltInFictitiousFunctionClassFactory(gnssStatus));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public static class GpsStatusTransport implements GpsStatus.Listener {
        final GnssStatusCompat.Callback KClassImpl$Data$declaredNonStaticMembers$2;
        private final LocationManager PlaceComponentResult;
        volatile Executor getAuthRequestContext;

        @Override // android.location.GpsStatus.Listener
        public void onGpsStatusChanged(int i) {
            GpsStatus gpsStatus;
            final Executor executor = this.getAuthRequestContext;
            if (executor == null) {
                return;
            }
            if (i == 1) {
                executor.execute(new Runnable() { // from class: androidx.core.location.LocationManagerCompat$GpsStatusTransport$$ExternalSyntheticLambda0
                    @Override // java.lang.Runnable
                    public final void run() {
                        LocationManagerCompat.GpsStatusTransport.this.PlaceComponentResult(executor);
                    }
                });
            } else if (i == 2) {
                executor.execute(new Runnable() { // from class: androidx.core.location.LocationManagerCompat$GpsStatusTransport$$ExternalSyntheticLambda1
                    @Override // java.lang.Runnable
                    public final void run() {
                        LocationManagerCompat.GpsStatusTransport.this.BuiltInFictitiousFunctionClassFactory(executor);
                    }
                });
            } else if (i != 3) {
                if (i != 4 || (gpsStatus = this.PlaceComponentResult.getGpsStatus(null)) == null) {
                    return;
                }
                final GnssStatusCompat KClassImpl$Data$declaredNonStaticMembers$2 = GnssStatusCompat.KClassImpl$Data$declaredNonStaticMembers$2(gpsStatus);
                executor.execute(new Runnable() { // from class: androidx.core.location.LocationManagerCompat$GpsStatusTransport$$ExternalSyntheticLambda3
                    @Override // java.lang.Runnable
                    public final void run() {
                        LocationManagerCompat.GpsStatusTransport.this.MyBillsEntityDataFactory(executor, KClassImpl$Data$declaredNonStaticMembers$2);
                    }
                });
            } else {
                GpsStatus gpsStatus2 = this.PlaceComponentResult.getGpsStatus(null);
                if (gpsStatus2 != null) {
                    final int timeToFirstFix = gpsStatus2.getTimeToFirstFix();
                    executor.execute(new Runnable() { // from class: androidx.core.location.LocationManagerCompat$GpsStatusTransport$$ExternalSyntheticLambda2
                        @Override // java.lang.Runnable
                        public final void run() {
                            LocationManagerCompat.GpsStatusTransport.this.BuiltInFictitiousFunctionClassFactory(executor, timeToFirstFix);
                        }
                    });
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public /* synthetic */ void PlaceComponentResult(Executor executor) {
            if (this.getAuthRequestContext != executor) {
                return;
            }
            this.KClassImpl$Data$declaredNonStaticMembers$2.MyBillsEntityDataFactory();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public /* synthetic */ void BuiltInFictitiousFunctionClassFactory(Executor executor) {
            if (this.getAuthRequestContext != executor) {
                return;
            }
            this.KClassImpl$Data$declaredNonStaticMembers$2.BuiltInFictitiousFunctionClassFactory();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public /* synthetic */ void BuiltInFictitiousFunctionClassFactory(Executor executor, int i) {
            if (this.getAuthRequestContext != executor) {
                return;
            }
            this.KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2(i);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public /* synthetic */ void MyBillsEntityDataFactory(Executor executor, GnssStatusCompat gnssStatusCompat) {
            if (this.getAuthRequestContext != executor) {
                return;
            }
            this.KClassImpl$Data$declaredNonStaticMembers$2.PlaceComponentResult(gnssStatusCompat);
        }
    }

    /* loaded from: classes6.dex */
    static final class CancellableLocationListener implements LocationListener {
        private Consumer<Location> BuiltInFictitiousFunctionClassFactory;
        private final LocationManager KClassImpl$Data$declaredNonStaticMembers$2;
        private final Handler MyBillsEntityDataFactory;
        private final Executor PlaceComponentResult;
        Runnable getAuthRequestContext;
        private boolean lookAheadTest;

        @Override // android.location.LocationListener
        public final void onProviderEnabled(String str) {
        }

        @Override // android.location.LocationListener
        public final void onStatusChanged(String str, int i, Bundle bundle) {
        }

        public final void BuiltInFictitiousFunctionClassFactory() {
            synchronized (this) {
                if (this.lookAheadTest) {
                    return;
                }
                this.lookAheadTest = true;
                MyBillsEntityDataFactory();
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public final /* synthetic */ void PlaceComponentResult() {
            this.getAuthRequestContext = null;
            onLocationChanged((Location) null);
        }

        @Override // android.location.LocationListener
        public final void onProviderDisabled(String str) {
            onLocationChanged((Location) null);
        }

        @Override // android.location.LocationListener
        public final void onLocationChanged(final Location location) {
            synchronized (this) {
                if (this.lookAheadTest) {
                    return;
                }
                this.lookAheadTest = true;
                final Consumer<Location> consumer = this.BuiltInFictitiousFunctionClassFactory;
                this.PlaceComponentResult.execute(new Runnable() { // from class: androidx.core.location.LocationManagerCompat$CancellableLocationListener$$ExternalSyntheticLambda1
                    @Override // java.lang.Runnable
                    public final void run() {
                        Consumer.this.accept(location);
                    }
                });
                MyBillsEntityDataFactory();
            }
        }

        private void MyBillsEntityDataFactory() {
            this.BuiltInFictitiousFunctionClassFactory = null;
            this.KClassImpl$Data$declaredNonStaticMembers$2.removeUpdates(this);
            Runnable runnable = this.getAuthRequestContext;
            if (runnable != null) {
                this.MyBillsEntityDataFactory.removeCallbacks(runnable);
                this.getAuthRequestContext = null;
            }
        }
    }

    /* loaded from: classes6.dex */
    static final class InlineHandlerExecutor implements Executor {
        private final Handler getAuthRequestContext;

        @Override // java.util.concurrent.Executor
        public final void execute(Runnable runnable) {
            if (Looper.myLooper() == this.getAuthRequestContext.getLooper()) {
                runnable.run();
            } else if (this.getAuthRequestContext.post((Runnable) Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(runnable))) {
            } else {
                StringBuilder sb = new StringBuilder();
                sb.append(this.getAuthRequestContext);
                sb.append(" is shutting down");
                throw new RejectedExecutionException(sb.toString());
            }
        }
    }

    /* loaded from: classes6.dex */
    static class Api31Impl {
        private Api31Impl() {
        }
    }

    /* loaded from: classes6.dex */
    static class Api30Impl {
        private Api30Impl() {
        }
    }

    /* loaded from: classes6.dex */
    static class Api28Impl {
        private Api28Impl() {
        }
    }

    /* loaded from: classes6.dex */
    static class Api19Impl {
        private Api19Impl() {
        }
    }

    /* loaded from: classes6.dex */
    static class Api24Impl {
        private Api24Impl() {
        }
    }
}
