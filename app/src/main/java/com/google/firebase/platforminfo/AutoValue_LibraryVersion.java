package com.google.firebase.platforminfo;

import javax.annotation.Nonnull;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class AutoValue_LibraryVersion extends LibraryVersion {
    private final String libraryName;
    private final String version;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AutoValue_LibraryVersion(String str, String str2) {
        if (str == null) {
            throw new NullPointerException("Null libraryName");
        }
        this.libraryName = str;
        if (str2 == null) {
            throw new NullPointerException("Null version");
        }
        this.version = str2;
    }

    @Override // com.google.firebase.platforminfo.LibraryVersion
    @Nonnull
    public final String getLibraryName() {
        return this.libraryName;
    }

    @Override // com.google.firebase.platforminfo.LibraryVersion
    @Nonnull
    public final String getVersion() {
        return this.version;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("LibraryVersion{libraryName=");
        sb.append(this.libraryName);
        sb.append(", version=");
        sb.append(this.version);
        sb.append("}");
        return sb.toString();
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof LibraryVersion) {
            LibraryVersion libraryVersion = (LibraryVersion) obj;
            return this.libraryName.equals(libraryVersion.getLibraryName()) && this.version.equals(libraryVersion.getVersion());
        }
        return false;
    }

    public final int hashCode() {
        return ((this.libraryName.hashCode() ^ 1000003) * 1000003) ^ this.version.hashCode();
    }
}
