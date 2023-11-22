package com.iap.ac.android.region.cdp.ui;

import com.iap.ac.android.region.cdp.delegate.ClickService;
import com.iap.ac.android.region.cdp.delegate.ImageService;
import com.iap.ac.android.region.cdp.delegate.defaults.DefaultImageService;

/* loaded from: classes8.dex */
public class CdpUiDelegateHost {
    public static final CdpUiDelegateHost INSTANCE = new CdpUiDelegateHost();
    public ClickService mClickService;
    public ImageService mImageService;

    public static CdpUiDelegateHost getInstance() {
        return INSTANCE;
    }

    public ClickService getClickService() {
        return this.mClickService;
    }

    public ImageService getImageService() {
        ImageService imageService = this.mImageService;
        return imageService != null ? imageService : DefaultImageService.getInstance();
    }

    public void setClickService(ClickService clickService) {
        this.mClickService = clickService;
    }

    public void setImageService(ImageService imageService) {
        this.mImageService = imageService;
    }
}
