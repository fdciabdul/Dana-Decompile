package com.splunk.rum;

import java.util.Objects;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public final class Carrier {
    final String BuiltInFictitiousFunctionClassFactory;
    final String KClassImpl$Data$declaredNonStaticMembers$2;
    final String MyBillsEntityDataFactory;
    private final int PlaceComponentResult;
    final String getAuthRequestContext;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Builder MyBillsEntityDataFactory() {
        return new Builder();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Carrier(Builder builder) {
        this.PlaceComponentResult = builder.MyBillsEntityDataFactory;
        this.getAuthRequestContext = builder.PlaceComponentResult;
        this.BuiltInFictitiousFunctionClassFactory = builder.KClassImpl$Data$declaredNonStaticMembers$2;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = builder.BuiltInFictitiousFunctionClassFactory;
        this.MyBillsEntityDataFactory = builder.getAuthRequestContext;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Carrier carrier = (Carrier) obj;
        return this.PlaceComponentResult == carrier.PlaceComponentResult && Objects.equals(this.getAuthRequestContext, carrier.getAuthRequestContext) && Objects.equals(this.BuiltInFictitiousFunctionClassFactory, carrier.BuiltInFictitiousFunctionClassFactory) && Objects.equals(this.KClassImpl$Data$declaredNonStaticMembers$2, carrier.KClassImpl$Data$declaredNonStaticMembers$2) && Objects.equals(this.MyBillsEntityDataFactory, carrier.MyBillsEntityDataFactory);
    }

    public final int hashCode() {
        return Objects.hash(Integer.valueOf(this.PlaceComponentResult), this.getAuthRequestContext, this.BuiltInFictitiousFunctionClassFactory, this.KClassImpl$Data$declaredNonStaticMembers$2, this.MyBillsEntityDataFactory);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Carrier{id=");
        sb.append(this.PlaceComponentResult);
        sb.append(", name='");
        sb.append(this.getAuthRequestContext);
        sb.append('\'');
        sb.append(", mobileCountryCode='");
        sb.append(this.BuiltInFictitiousFunctionClassFactory);
        sb.append('\'');
        sb.append(", mobileNetworkCode='");
        sb.append(this.KClassImpl$Data$declaredNonStaticMembers$2);
        sb.append('\'');
        sb.append(", isoCountryCode='");
        sb.append(this.MyBillsEntityDataFactory);
        sb.append('\'');
        sb.append('}');
        return sb.toString();
    }

    /* loaded from: classes3.dex */
    static class Builder {
        int MyBillsEntityDataFactory = -1;
        String PlaceComponentResult = null;
        String KClassImpl$Data$declaredNonStaticMembers$2 = null;
        String BuiltInFictitiousFunctionClassFactory = null;
        String getAuthRequestContext = null;

        Builder() {
        }
    }
}
