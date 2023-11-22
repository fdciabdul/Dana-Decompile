package com.alibaba.griver.lottie.model;

import androidx.core.util.Pair;

/* loaded from: classes6.dex */
public class MutablePair<T> {
    T first;
    T second;

    public void set(T t, T t2) {
        this.first = t;
        this.second = t2;
    }

    public boolean equals(Object obj) {
        if (obj instanceof Pair) {
            Pair pair = (Pair) obj;
            return objectsEqual(pair.getAuthRequestContext, this.first) && objectsEqual(pair.PlaceComponentResult, this.second);
        }
        return false;
    }

    private static boolean objectsEqual(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    public int hashCode() {
        T t = this.first;
        int hashCode = t == null ? 0 : t.hashCode();
        T t2 = this.second;
        return hashCode ^ (t2 != null ? t2.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Pair{");
        sb.append(String.valueOf(this.first));
        sb.append(" ");
        sb.append(String.valueOf(this.second));
        sb.append("}");
        return sb.toString();
    }
}
