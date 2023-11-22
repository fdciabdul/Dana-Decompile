package com.google.firebase.components;

import com.google.android.gms.fido.fido2.api.common.DevicePublicKeyStringDef;
import id.dana.passkey.Passkey;

/* loaded from: classes.dex */
public final class Dependency {
    private final Class<?> anInterface;
    private final int injection;
    private final int type;

    private Dependency(Class<?> cls, int i, int i2) {
        this.anInterface = (Class) Preconditions.checkNotNull(cls, "Null dependency anInterface.");
        this.type = i;
        this.injection = i2;
    }

    @Deprecated
    public static Dependency optional(Class<?> cls) {
        return new Dependency(cls, 0, 0);
    }

    public static Dependency deferred(Class<?> cls) {
        return new Dependency(cls, 0, 2);
    }

    public static Dependency required(Class<?> cls) {
        return new Dependency(cls, 1, 0);
    }

    public static Dependency setOf(Class<?> cls) {
        return new Dependency(cls, 2, 0);
    }

    public static Dependency optionalProvider(Class<?> cls) {
        return new Dependency(cls, 0, 1);
    }

    public static Dependency requiredProvider(Class<?> cls) {
        return new Dependency(cls, 1, 1);
    }

    public static Dependency setOfProvider(Class<?> cls) {
        return new Dependency(cls, 2, 1);
    }

    public final Class<?> getInterface() {
        return this.anInterface;
    }

    public final boolean isRequired() {
        return this.type == 1;
    }

    public final boolean isSet() {
        return this.type == 2;
    }

    public final boolean isDirectInjection() {
        return this.injection == 0;
    }

    public final boolean isDeferred() {
        return this.injection == 2;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof Dependency) {
            Dependency dependency = (Dependency) obj;
            return this.anInterface == dependency.anInterface && this.type == dependency.type && this.injection == dependency.injection;
        }
        return false;
    }

    public final int hashCode() {
        return ((((this.anInterface.hashCode() ^ 1000003) * 1000003) ^ this.type) * 1000003) ^ this.injection;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("Dependency{anInterface=");
        sb.append(this.anInterface);
        sb.append(", type=");
        int i = this.type;
        sb.append(i == 1 ? Passkey.REQUIRED : i == 0 ? "optional" : "set");
        sb.append(", injection=");
        sb.append(describeInjection(this.injection));
        sb.append("}");
        return sb.toString();
    }

    private static String describeInjection(int i) {
        if (i != 0) {
            if (i != 1) {
                if (i == 2) {
                    return "deferred";
                }
                StringBuilder sb = new StringBuilder();
                sb.append("Unsupported injection: ");
                sb.append(i);
                throw new AssertionError(sb.toString());
            }
            return "provider";
        }
        return DevicePublicKeyStringDef.DIRECT;
    }
}
