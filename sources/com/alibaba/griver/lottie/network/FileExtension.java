package com.alibaba.griver.lottie.network;

import com.alibaba.griver.lottie.utils.Logger;

/* loaded from: classes6.dex */
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

    public static FileExtension forFile(String str) {
        for (FileExtension fileExtension : values()) {
            if (str.endsWith(fileExtension.extension)) {
                return fileExtension;
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Unable to find correct extension for ");
        sb.append(str);
        Logger.warning(sb.toString());
        return JSON;
    }
}
