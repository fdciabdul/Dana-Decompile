package com.google.android.datatransport;

/* loaded from: classes.dex */
public final class Encoding {
    private final String name;

    public static Encoding of(String str) {
        return new Encoding(str);
    }

    public final String getName() {
        return this.name;
    }

    private Encoding(String str) {
        if (str == null) {
            throw new NullPointerException("name is null");
        }
        this.name = str;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Encoding) {
            return this.name.equals(((Encoding) obj).name);
        }
        return false;
    }

    public final int hashCode() {
        return this.name.hashCode() ^ 1000003;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Encoding{name=\"");
        sb.append(this.name);
        sb.append("\"}");
        return sb.toString();
    }
}
