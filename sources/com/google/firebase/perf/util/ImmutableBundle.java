package com.google.firebase.perf.util;

import android.os.Bundle;
import com.google.firebase.perf.logging.AndroidLogger;

/* loaded from: classes.dex */
public final class ImmutableBundle {
    private static final AndroidLogger logger = AndroidLogger.getInstance();
    private final Bundle bundle;

    public ImmutableBundle() {
        this(new Bundle());
    }

    public ImmutableBundle(Bundle bundle) {
        this.bundle = (Bundle) bundle.clone();
    }

    public final boolean containsKey(String str) {
        return str != null && this.bundle.containsKey(str);
    }

    public final Optional<Boolean> getBoolean(String str) {
        if (!containsKey(str)) {
            return Optional.absent();
        }
        try {
            return Optional.fromNullable((Boolean) this.bundle.get(str));
        } catch (ClassCastException e) {
            logger.debug("Metadata key %s contains type other than boolean: %s", str, e.getMessage());
            return Optional.absent();
        }
    }

    public final Optional<Float> getFloat(String str) {
        if (!containsKey(str)) {
            return Optional.absent();
        }
        try {
            return Optional.fromNullable((Float) this.bundle.get(str));
        } catch (ClassCastException e) {
            logger.debug("Metadata key %s contains type other than float: %s", str, e.getMessage());
            return Optional.absent();
        }
    }

    public final Optional<Long> getLong(String str) {
        if (getInt(str).isAvailable()) {
            return Optional.of(Long.valueOf(r3.get().intValue()));
        }
        return Optional.absent();
    }

    private Optional<Integer> getInt(String str) {
        if (!containsKey(str)) {
            return Optional.absent();
        }
        try {
            return Optional.fromNullable((Integer) this.bundle.get(str));
        } catch (ClassCastException e) {
            logger.debug("Metadata key %s contains type other than int: %s", str, e.getMessage());
            return Optional.absent();
        }
    }
}
