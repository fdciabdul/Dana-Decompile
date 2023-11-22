package com.google.android.gms.location;

import android.content.Intent;
import android.location.Location;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes3.dex */
public final class LocationResult extends AbstractSafeParcelable implements ReflectedParcelable {
    private final List zzb;
    static final List zza = Collections.emptyList();
    public static final Parcelable.Creator<LocationResult> CREATOR = new zzbp();

    /* JADX INFO: Access modifiers changed from: package-private */
    public LocationResult(List list) {
        this.zzb = list;
    }

    public static LocationResult create(List<Location> list) {
        if (list == null) {
            list = zza;
        }
        return new LocationResult(list);
    }

    public static LocationResult extractResult(Intent intent) {
        if (hasResult(intent)) {
            return (LocationResult) intent.getParcelableExtra("com.google.android.gms.location.EXTRA_LOCATION_RESULT");
        }
        return null;
    }

    public static boolean hasResult(Intent intent) {
        if (intent == null) {
            return false;
        }
        return intent.hasExtra("com.google.android.gms.location.EXTRA_LOCATION_RESULT");
    }

    public final boolean equals(Object obj) {
        if (obj instanceof LocationResult) {
            LocationResult locationResult = (LocationResult) obj;
            if (Build.VERSION.SDK_INT >= 31) {
                return this.zzb.equals(locationResult.zzb);
            }
            if (this.zzb.size() != locationResult.zzb.size()) {
                return false;
            }
            Iterator it = locationResult.zzb.iterator();
            for (Location location : this.zzb) {
                Location location2 = (Location) it.next();
                if (Double.compare(location.getLatitude(), location2.getLatitude()) != 0 || Double.compare(location.getLongitude(), location2.getLongitude()) != 0 || location.getTime() != location2.getTime() || location.getElapsedRealtimeNanos() != location2.getElapsedRealtimeNanos() || !Objects.equal(location.getProvider(), location2.getProvider())) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    public final Location getLastLocation() {
        int size = this.zzb.size();
        if (size == 0) {
            return null;
        }
        return (Location) this.zzb.get(size - 1);
    }

    public final List<Location> getLocations() {
        return this.zzb;
    }

    public final int hashCode() {
        return Objects.hashCode(this.zzb);
    }

    public final String toString() {
        return "LocationResult".concat(String.valueOf(String.valueOf(this.zzb)));
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeTypedList(parcel, 1, getLocations(), false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
