package id.dana.utils;

import android.content.Intent;
import android.provider.MediaStore;

/* loaded from: classes9.dex */
public class ImagePicker {
    private ImagePicker() {
    }

    public static Intent getAuthRequestContext() {
        return new Intent("android.intent.action.PICK", MediaStore.Images.Media.EXTERNAL_CONTENT_URI).setType("image/*");
    }
}
