package com.alipay.iap.android.lbs.a.a;

import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import com.alipay.iap.android.common.log.LoggerWrapper;
import com.alipay.iap.android.lbs.LBSLocation;
import com.alipay.iap.android.lbs.LBSLocationErrorCode;
import com.alipay.iap.android.lbs.LBSLocationListener;
import com.alipay.iap.android.lbs.LBSLocationRequest;
import id.dana.utils.permission.ManifestPermission;

/* loaded from: classes3.dex */
public class b implements LocationListener, com.alipay.iap.android.lbs.b.b {

    /* renamed from: a  reason: collision with root package name */
    private final Context f6997a;
    private a b;
    private String c;
    private LBSLocationListener d;
    private LocationManager e;
    private LBSLocationRequest f;
    private boolean i;
    private boolean g = false;
    private Handler h = new Handler(Looper.getMainLooper());
    private com.alipay.iap.android.lbs.c.a j = null;
    private boolean k = false;
    private long l = 0;

    public b(Context context, a aVar, LBSLocationRequest lBSLocationRequest, LBSLocationListener lBSLocationListener, boolean z) {
        this.f6997a = context;
        this.b = aVar;
        this.f = lBSLocationRequest;
        if (lBSLocationRequest == null) {
            this.f = new LBSLocationRequest();
        }
        this.d = lBSLocationListener;
        this.i = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(LBSLocationErrorCode lBSLocationErrorCode) {
        LBSLocationListener lBSLocationListener = this.d;
        if (lBSLocationListener != null) {
            lBSLocationListener.onLocationError(lBSLocationErrorCode);
        }
        e();
    }

    private void d() {
        if (this.g) {
            this.h.post(new Runnable() { // from class: com.alipay.iap.android.lbs.a.a.b.2
                @Override // java.lang.Runnable
                public void run() {
                    b.this.e.removeUpdates(b.this);
                }
            });
            c();
            this.g = false;
        }
    }

    private void e() {
        this.b.a(this.d);
        d();
    }

    public void a() {
        if (this.g) {
            LoggerWrapper.e("LBSLocationModuleNative", "LBSLocationModuleNative:startLocation repeatedly");
        } else {
            this.h.post(new Runnable() { // from class: com.alipay.iap.android.lbs.a.a.b.1
                @Override // java.lang.Runnable
                public void run() {
                    String str;
                    b bVar = b.this;
                    bVar.c = com.alipay.iap.android.lbs.c.b.a(bVar.f6997a, b.this.f);
                    if (b.this.c == null) {
                        if (com.alipay.iap.android.lbs.c.b.b(b.this.f6997a, "android.permission.ACCESS_FINE_LOCATION") || com.alipay.iap.android.lbs.c.b.b(b.this.f6997a, ManifestPermission.ACCESS_COARSE_LOCATION)) {
                            b.this.b(LBSLocationErrorCode.LocationErrorPositionDisabled);
                            str = "LBSLocationModuleNative:startLocation with GPS&Network disabled";
                        } else {
                            b.this.b(LBSLocationErrorCode.LocationErrorNoAuthorization);
                            str = "LBSLocationModuleNative::startLocation without GPS&Network authentication";
                        }
                        LoggerWrapper.e("LBSLocationModuleNative", str);
                        return;
                    }
                    try {
                        b bVar2 = b.this;
                        bVar2.e = (LocationManager) bVar2.f6997a.getSystemService("location");
                        if (b.this.i) {
                            b.this.f.updateInterval = 0L;
                            b.this.f.minDistance = 0.0f;
                        }
                        b.this.e.requestLocationUpdates(b.this.c, b.this.f.updateInterval, b.this.f.minDistance, b.this);
                        b.this.l = System.currentTimeMillis();
                        b bVar3 = b.this;
                        bVar3.a(bVar3.f.timeOut);
                        b.this.g = true;
                    } catch (Exception e) {
                        if (b.this.d != null) {
                            b.this.d.onLocationError(LBSLocationErrorCode.LocationErrorSystem);
                        }
                        StringBuilder sb = new StringBuilder();
                        sb.append("requestLocationUpdateInternal isOnceLocation=");
                        sb.append(b.this.i);
                        sb.append(",error=");
                        sb.append(e.getMessage());
                        LoggerWrapper.e("LBSLocationModuleNative", sb.toString());
                    }
                }
            });
        }
    }

    public void a(long j) {
        if (j <= 0) {
            return;
        }
        if (this.j == null) {
            this.j = new com.alipay.iap.android.lbs.c.a(j, this);
        }
        this.j.a();
    }

    @Override // com.alipay.iap.android.lbs.b.b
    public void a(LBSLocationErrorCode lBSLocationErrorCode) {
        if (lBSLocationErrorCode == LBSLocationErrorCode.LocationErrorTimeout && this.k) {
            return;
        }
        b(lBSLocationErrorCode);
    }

    public void b() {
        LBSLocationListener lBSLocationListener;
        d();
        if (this.k || (lBSLocationListener = this.d) == null) {
            return;
        }
        lBSLocationListener.onLocationError(LBSLocationErrorCode.LocationErrorCancelled);
    }

    public void c() {
        com.alipay.iap.android.lbs.c.a aVar = this.j;
        if (aVar == null) {
            return;
        }
        aVar.b();
    }

    @Override // android.location.LocationListener
    public void onLocationChanged(Location location) {
        if (location != null) {
            this.k = true;
            LBSLocation lBSLocation = new LBSLocation(location);
            lBSLocation.setTimeCost(System.currentTimeMillis() - this.l);
            this.d.onLocationUpdate(lBSLocation);
            this.l = System.currentTimeMillis();
            c();
        } else {
            this.d.onLocationError(LBSLocationErrorCode.LocationErrorNullLocation);
        }
        if (this.i && this.k) {
            d();
        }
    }

    @Override // android.location.LocationListener
    public void onProviderDisabled(String str) {
        b(LBSLocationErrorCode.LocationErrorPositionDisabled);
    }

    @Override // android.location.LocationListener
    public void onProviderEnabled(String str) {
    }

    @Override // android.location.LocationListener
    public void onStatusChanged(String str, int i, Bundle bundle) {
    }
}
