package id.dana.domain.util;

import android.content.Context;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import androidx.core.content.ContextCompat;
import com.ap.zoloz.hummer.biz.HummerConstants;
import id.dana.domain.globalsearch.model.LatLng;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0012\u0010\u0013J+\u0010\b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004H\u0002¢\u0006\u0004\b\b\u0010\tJ'\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\n\u001a\u0004\u0018\u00010\u0005H\u0007¢\u0006\u0004\b\r\u0010\u000eR\u0014\u0010\u0010\u001a\u00020\u000f8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011"}, d2 = {"Lid/dana/domain/util/SingleShotLocationProvider;", "", "Landroid/content/Context;", HummerConstants.CONTEXT, "Lkotlin/Function1;", "Landroid/location/Location;", "", "onNewLocationAvailable", "requestSingleUpdate", "(Landroid/content/Context;Lkotlin/jvm/functions/Function1;)V", "location", "Lio/reactivex/Observable;", "Lid/dana/domain/globalsearch/model/LatLng;", "requestSingleUpdateObservable", "(Landroid/content/Context;Landroid/location/Location;)Lio/reactivex/Observable;", "", "MAX_GET_LOCATION_TIME", "J", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class SingleShotLocationProvider {
    public static final SingleShotLocationProvider INSTANCE = new SingleShotLocationProvider();
    private static final long MAX_GET_LOCATION_TIME = 5000;

    private SingleShotLocationProvider() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void requestSingleUpdate(Context context, final Function1<? super Location, Unit> onNewLocationAvailable) {
        final Ref.BooleanRef booleanRef = new Ref.BooleanRef();
        booleanRef.element = true;
        Object systemService = context.getSystemService("location");
        if (systemService == null) {
            throw new NullPointerException("null cannot be cast to non-null type android.location.LocationManager");
        }
        final LocationManager locationManager = (LocationManager) systemService;
        final Handler handler = new Handler();
        final Runnable runnable = new Runnable() { // from class: id.dana.domain.util.SingleShotLocationProvider$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                SingleShotLocationProvider.m2507requestSingleUpdate$lambda0(Ref.BooleanRef.this, locationManager, onNewLocationAvailable);
            }
        };
        if (locationManager.isProviderEnabled("network")) {
            Criteria criteria = new Criteria();
            criteria.setAccuracy(2);
            locationManager.requestSingleUpdate(criteria, new LocationListener() { // from class: id.dana.domain.util.SingleShotLocationProvider$requestSingleUpdate$1
                @Override // android.location.LocationListener
                public final void onProviderDisabled(String provider) {
                    Intrinsics.checkNotNullParameter(provider, "");
                }

                @Override // android.location.LocationListener
                public final void onProviderEnabled(String provider) {
                    Intrinsics.checkNotNullParameter(provider, "");
                }

                @Override // android.location.LocationListener
                public final void onStatusChanged(String provider, int status, Bundle extras) {
                    Intrinsics.checkNotNullParameter(provider, "");
                    Intrinsics.checkNotNullParameter(extras, "");
                }

                @Override // android.location.LocationListener
                public final void onLocationChanged(Location location) {
                    Intrinsics.checkNotNullParameter(location, "");
                    if (Ref.BooleanRef.this.element) {
                        handler.removeCallbacks(runnable);
                        onNewLocationAvailable.invoke(location);
                        Ref.BooleanRef.this.element = false;
                    }
                }
            }, (Looper) null);
        } else if (locationManager.isProviderEnabled("gps")) {
            Criteria criteria2 = new Criteria();
            criteria2.setAccuracy(1);
            locationManager.requestSingleUpdate(criteria2, new LocationListener() { // from class: id.dana.domain.util.SingleShotLocationProvider$requestSingleUpdate$2
                @Override // android.location.LocationListener
                public final void onProviderDisabled(String provider) {
                    Intrinsics.checkNotNullParameter(provider, "");
                }

                @Override // android.location.LocationListener
                public final void onProviderEnabled(String provider) {
                    Intrinsics.checkNotNullParameter(provider, "");
                }

                @Override // android.location.LocationListener
                public final void onStatusChanged(String provider, int status, Bundle extras) {
                    Intrinsics.checkNotNullParameter(provider, "");
                    Intrinsics.checkNotNullParameter(extras, "");
                }

                @Override // android.location.LocationListener
                public final void onLocationChanged(Location location) {
                    Intrinsics.checkNotNullParameter(location, "");
                    if (Ref.BooleanRef.this.element) {
                        handler.removeCallbacks(runnable);
                        onNewLocationAvailable.invoke(location);
                        Ref.BooleanRef.this.element = false;
                    }
                }
            }, (Looper) null);
        } else {
            booleanRef.element = false;
            Location lastKnownLocation = locationManager.getLastKnownLocation("passive");
            if (lastKnownLocation == null) {
                lastKnownLocation = new Location("");
            }
            onNewLocationAvailable.invoke(lastKnownLocation);
            return;
        }
        handler.postDelayed(runnable, 5000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: requestSingleUpdate$lambda-0  reason: not valid java name */
    public static final void m2507requestSingleUpdate$lambda0(Ref.BooleanRef booleanRef, LocationManager locationManager, Function1 function1) {
        Intrinsics.checkNotNullParameter(booleanRef, "");
        Intrinsics.checkNotNullParameter(locationManager, "");
        Intrinsics.checkNotNullParameter(function1, "");
        if (booleanRef.element) {
            booleanRef.element = false;
            Location lastKnownLocation = locationManager.getLastKnownLocation("passive");
            if (lastKnownLocation == null) {
                lastKnownLocation = new Location("");
            }
            function1.invoke(lastKnownLocation);
        }
    }

    @JvmStatic
    public static final Observable<LatLng> requestSingleUpdateObservable(final Context context, final Location location) {
        Intrinsics.checkNotNullParameter(context, "");
        Observable<LatLng> create = Observable.create(new ObservableOnSubscribe() { // from class: id.dana.domain.util.SingleShotLocationProvider$$ExternalSyntheticLambda1
            @Override // io.reactivex.ObservableOnSubscribe
            public final void subscribe(ObservableEmitter observableEmitter) {
                SingleShotLocationProvider.m2508requestSingleUpdateObservable$lambda1(context, location, observableEmitter);
            }
        });
        Intrinsics.checkNotNullExpressionValue(create, "");
        return create;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: requestSingleUpdateObservable$lambda-1  reason: not valid java name */
    public static final void m2508requestSingleUpdateObservable$lambda1(Context context, Location location, ObservableEmitter observableEmitter) {
        Intrinsics.checkNotNullParameter(context, "");
        Intrinsics.checkNotNullParameter(observableEmitter, "");
        if (ContextCompat.KClassImpl$Data$declaredNonStaticMembers$2(context, "android.permission.ACCESS_FINE_LOCATION") == 0) {
            BuildersKt__Builders_commonKt.launch$default(GlobalScope.INSTANCE, Dispatchers.getMain(), null, new SingleShotLocationProvider$requestSingleUpdateObservable$1$1(location, context, observableEmitter, null), 2, null);
        } else {
            observableEmitter.onError(new SecurityException("Location permission is not granted"));
        }
    }
}
