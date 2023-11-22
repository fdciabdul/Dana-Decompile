package com.airbnb.lottie.network;

/* loaded from: classes3.dex */
public enum FileExtension {
    JSON(".json"),
    ZIP(".zip");

    public final String extension;

    FileExtension(String str) {
        this.extension = str;
    }

    public final String tempExtension() {
        StringBuilder sb = new StringBuilder();
        sb.append(".temp");
        sb.append(this.extension);
        return sb.toString();
    }

    @Override // java.lang.Enum
    public final String toString() {
        return this.extension;
    }
}
