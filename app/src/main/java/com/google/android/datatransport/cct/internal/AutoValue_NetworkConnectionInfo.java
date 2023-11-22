package com.google.android.datatransport.cct.internal;

import com.google.android.datatransport.cct.internal.NetworkConnectionInfo;

/* loaded from: classes7.dex */
final class AutoValue_NetworkConnectionInfo extends NetworkConnectionInfo {
    private final NetworkConnectionInfo.MobileSubtype mobileSubtype;
    private final NetworkConnectionInfo.NetworkType networkType;

    private AutoValue_NetworkConnectionInfo(NetworkConnectionInfo.NetworkType networkType, NetworkConnectionInfo.MobileSubtype mobileSubtype) {
        this.networkType = networkType;
        this.mobileSubtype = mobileSubtype;
    }

    @Override // com.google.android.datatransport.cct.internal.NetworkConnectionInfo
    public final NetworkConnectionInfo.NetworkType getNetworkType() {
        return this.networkType;
    }

    @Override // com.google.android.datatransport.cct.internal.NetworkConnectionInfo
    public final NetworkConnectionInfo.MobileSubtype getMobileSubtype() {
        return this.mobileSubtype;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("NetworkConnectionInfo{networkType=");
        sb.append(this.networkType);
        sb.append(", mobileSubtype=");
        sb.append(this.mobileSubtype);
        sb.append("}");
        return sb.toString();
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof NetworkConnectionInfo) {
            NetworkConnectionInfo networkConnectionInfo = (NetworkConnectionInfo) obj;
            NetworkConnectionInfo.NetworkType networkType = this.networkType;
            if (networkType != null ? networkType.equals(networkConnectionInfo.getNetworkType()) : networkConnectionInfo.getNetworkType() == null) {
                NetworkConnectionInfo.MobileSubtype mobileSubtype = this.mobileSubtype;
                if (mobileSubtype == null) {
                    if (networkConnectionInfo.getMobileSubtype() == null) {
                        return true;
                    }
                } else if (mobileSubtype.equals(networkConnectionInfo.getMobileSubtype())) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    public final int hashCode() {
        NetworkConnectionInfo.NetworkType networkType = this.networkType;
        int hashCode = networkType == null ? 0 : networkType.hashCode();
        NetworkConnectionInfo.MobileSubtype mobileSubtype = this.mobileSubtype;
        return ((hashCode ^ 1000003) * 1000003) ^ (mobileSubtype != null ? mobileSubtype.hashCode() : 0);
    }

    /* loaded from: classes7.dex */
    static final class Builder extends NetworkConnectionInfo.Builder {
        private NetworkConnectionInfo.MobileSubtype mobileSubtype;
        private NetworkConnectionInfo.NetworkType networkType;

        @Override // com.google.android.datatransport.cct.internal.NetworkConnectionInfo.Builder
        public final NetworkConnectionInfo.Builder setNetworkType(NetworkConnectionInfo.NetworkType networkType) {
            this.networkType = networkType;
            return this;
        }

        @Override // com.google.android.datatransport.cct.internal.NetworkConnectionInfo.Builder
        public final NetworkConnectionInfo.Builder setMobileSubtype(NetworkConnectionInfo.MobileSubtype mobileSubtype) {
            this.mobileSubtype = mobileSubtype;
            return this;
        }

        @Override // com.google.android.datatransport.cct.internal.NetworkConnectionInfo.Builder
        public final NetworkConnectionInfo build() {
            return new AutoValue_NetworkConnectionInfo(this.networkType, this.mobileSubtype);
        }
    }
}
