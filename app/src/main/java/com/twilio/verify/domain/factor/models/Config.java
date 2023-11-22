package com.twilio.verify.domain.factor.models;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0080\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\t¢\u0006\u0004\b\u000f\u0010\u0010J\u001a\u0010\u0004\u001a\u00020\u00032\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0007\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bR\u0011\u0010\u000e\u001a\u00020\tX\u0000¢\u0006\u0006\n\u0004\b\f\u0010\r"}, d2 = {"Lcom/twilio/verify/domain/factor/models/Config;", "", "p0", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "getAuthRequestContext", "Ljava/lang/String;", "PlaceComponentResult", "<init>", "(Ljava/lang/String;)V"}, k = 1, mv = {1, 8, 0})
/* loaded from: classes3.dex */
public final /* data */ class Config {

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    public final String PlaceComponentResult;

    public final boolean equals(Object p0) {
        if (this != p0) {
            return (p0 instanceof Config) && Intrinsics.areEqual(this.PlaceComponentResult, ((Config) p0).PlaceComponentResult);
        }
        return true;
    }

    public final int hashCode() {
        String str = this.PlaceComponentResult;
        if (str != null) {
            return str.hashCode();
        }
        return 0;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Config(PlaceComponentResult=");
        sb.append(this.PlaceComponentResult);
        sb.append(")");
        return sb.toString();
    }

    public Config(String str) {
        Intrinsics.checkParameterIsNotNull(str, "");
        this.PlaceComponentResult = str;
    }
}
