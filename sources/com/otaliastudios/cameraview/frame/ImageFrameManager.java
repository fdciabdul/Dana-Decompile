package com.otaliastudios.cameraview.frame;

import android.media.Image;

/* loaded from: classes8.dex */
public class ImageFrameManager extends FrameManager<Image> {
    @Override // com.otaliastudios.cameraview.frame.FrameManager
    protected final /* synthetic */ void BuiltInFictitiousFunctionClassFactory(Image image, boolean z) {
        try {
            image.close();
        } catch (Exception unused) {
        }
    }

    public ImageFrameManager(int i) {
        super(i, Image.class);
    }
}
