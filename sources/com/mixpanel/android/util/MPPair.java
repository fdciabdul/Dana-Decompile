package com.mixpanel.android.util;

import android.os.Build;
import android.util.Pair;

/* loaded from: classes.dex */
public class MPPair<F, S> extends Pair<F, S> {
    public MPPair(F f, S s) {
        super(f, s);
    }

    @Override // android.util.Pair
    public boolean equals(Object obj) {
        if (Build.VERSION.SDK_INT > 16) {
            return super.equals(obj);
        }
        if (obj instanceof Pair) {
            Pair pair = (Pair) obj;
            if (pair.first == this.first || (pair.first != null && pair.first.equals(this.first))) {
                return pair.second == this.second || (pair.second != null && pair.second.equals(this.second));
            }
            return false;
        }
        return false;
    }

    @Override // android.util.Pair
    public int hashCode() {
        if (Build.VERSION.SDK_INT > 16) {
            return super.hashCode();
        }
        return (this.first == null ? 0 : this.first.hashCode()) ^ (this.second != null ? this.second.hashCode() : 0);
    }
}
