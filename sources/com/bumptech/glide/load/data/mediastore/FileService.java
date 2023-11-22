package com.bumptech.glide.load.data.mediastore;

import java.io.File;

/* loaded from: classes3.dex */
class FileService {
    public static boolean PlaceComponentResult(File file) {
        return file.exists();
    }

    public static File getAuthRequestContext(String str) {
        return new File(str);
    }
}
