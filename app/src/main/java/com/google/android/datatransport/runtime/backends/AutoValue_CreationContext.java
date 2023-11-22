package com.google.android.datatransport.runtime.backends;

import android.content.Context;
import com.google.android.datatransport.runtime.time.Clock;

/* loaded from: classes7.dex */
final class AutoValue_CreationContext extends CreationContext {
    private final Context applicationContext;
    private final String backendName;
    private final Clock monotonicClock;
    private final Clock wallClock;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AutoValue_CreationContext(Context context, Clock clock, Clock clock2, String str) {
        if (context == null) {
            throw new NullPointerException("Null applicationContext");
        }
        this.applicationContext = context;
        if (clock == null) {
            throw new NullPointerException("Null wallClock");
        }
        this.wallClock = clock;
        if (clock2 == null) {
            throw new NullPointerException("Null monotonicClock");
        }
        this.monotonicClock = clock2;
        if (str == null) {
            throw new NullPointerException("Null backendName");
        }
        this.backendName = str;
    }

    @Override // com.google.android.datatransport.runtime.backends.CreationContext
    public final Context getApplicationContext() {
        return this.applicationContext;
    }

    @Override // com.google.android.datatransport.runtime.backends.CreationContext
    public final Clock getWallClock() {
        return this.wallClock;
    }

    @Override // com.google.android.datatransport.runtime.backends.CreationContext
    public final Clock getMonotonicClock() {
        return this.monotonicClock;
    }

    @Override // com.google.android.datatransport.runtime.backends.CreationContext
    public final String getBackendName() {
        return this.backendName;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("CreationContext{applicationContext=");
        sb.append(this.applicationContext);
        sb.append(", wallClock=");
        sb.append(this.wallClock);
        sb.append(", monotonicClock=");
        sb.append(this.monotonicClock);
        sb.append(", backendName=");
        sb.append(this.backendName);
        sb.append("}");
        return sb.toString();
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof CreationContext) {
            CreationContext creationContext = (CreationContext) obj;
            return this.applicationContext.equals(creationContext.getApplicationContext()) && this.wallClock.equals(creationContext.getWallClock()) && this.monotonicClock.equals(creationContext.getMonotonicClock()) && this.backendName.equals(creationContext.getBackendName());
        }
        return false;
    }

    public final int hashCode() {
        int hashCode = this.applicationContext.hashCode();
        return ((((((hashCode ^ 1000003) * 1000003) ^ this.wallClock.hashCode()) * 1000003) ^ this.monotonicClock.hashCode()) * 1000003) ^ this.backendName.hashCode();
    }
}
