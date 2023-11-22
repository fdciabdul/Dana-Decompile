package com.splunk.rum;

import android.os.Build;
import java.util.Objects;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public final class CurrentNetwork {
    final String KClassImpl$Data$declaredNonStaticMembers$2;
    final NetworkState PlaceComponentResult;
    final Carrier getAuthRequestContext;

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ CurrentNetwork(Builder builder, byte b) {
        this(builder);
    }

    private CurrentNetwork(Builder builder) {
        this.getAuthRequestContext = builder.BuiltInFictitiousFunctionClassFactory;
        this.PlaceComponentResult = builder.MyBillsEntityDataFactory;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = builder.KClassImpl$Data$declaredNonStaticMembers$2;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("CurrentNetwork{carrier=");
        sb.append(this.getAuthRequestContext);
        sb.append(", state=");
        sb.append(this.PlaceComponentResult);
        sb.append(", subType='");
        sb.append(this.KClassImpl$Data$declaredNonStaticMembers$2);
        sb.append('\'');
        sb.append('}');
        return sb.toString();
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        CurrentNetwork currentNetwork = (CurrentNetwork) obj;
        return Objects.equals(this.getAuthRequestContext, currentNetwork.getAuthRequestContext) && this.PlaceComponentResult == currentNetwork.PlaceComponentResult && Objects.equals(this.KClassImpl$Data$declaredNonStaticMembers$2, currentNetwork.KClassImpl$Data$declaredNonStaticMembers$2);
    }

    public final int hashCode() {
        return Objects.hash(this.getAuthRequestContext, this.PlaceComponentResult, this.KClassImpl$Data$declaredNonStaticMembers$2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean BuiltInFictitiousFunctionClassFactory() {
        return Build.VERSION.SDK_INT >= 28 && this.getAuthRequestContext != null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Builder getAuthRequestContext(NetworkState networkState) {
        return new Builder(networkState);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static class Builder {
        Carrier BuiltInFictitiousFunctionClassFactory;
        String KClassImpl$Data$declaredNonStaticMembers$2;
        private final NetworkState MyBillsEntityDataFactory;

        public Builder(NetworkState networkState) {
            this.MyBillsEntityDataFactory = networkState;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean PlaceComponentResult() {
        return this.PlaceComponentResult != NetworkState.NO_NETWORK_AVAILABLE;
    }
}
