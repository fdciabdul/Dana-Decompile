package com.alipay.mobile.zebra.data;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.View;
import com.alipay.mobile.zebra.ZebraLoader;
import com.alipay.mobile.zebra.core.ZebraOption;
import com.alipay.mobile.zebra.data.web.WebImage;
import com.alipay.mobile.zebra.layout.ImageLayout;

/* loaded from: classes7.dex */
public class ImageData extends ZebraData<ImageLayout> {
    public static final String ATTR_PLACEHOLDER = "placeholder";
    public static final String ATTR_SRC = "src";
    protected String mPlaceholder;
    protected String mSrc;

    public String getSrc() {
        return this.mSrc;
    }

    public void setSrc(String str) {
        this.mSrc = str;
    }

    public String getPlaceholder() {
        return this.mPlaceholder;
    }

    public void setPlaceholder(String str) {
        this.mPlaceholder = str;
    }

    @Override // com.alipay.mobile.zebra.data.ZebraData
    public void fromDSL(AttributeSet attributeSet, ZebraOption zebraOption) {
        super.fromDSL(attributeSet, zebraOption);
        this.mSrc = this.mAttributeMap.get("src");
        this.mPlaceholder = this.mAttributeMap.get("placeholder");
    }

    @Override // com.alipay.mobile.zebra.data.ZebraData
    public boolean canUpdate() {
        return this.mPlaceholder != null;
    }

    @Override // com.alipay.mobile.zebra.data.ZebraData
    public View render(Context context) {
        ImageLayout imageLayout = new ImageLayout();
        setLayoutContext(imageLayout);
        View render = imageLayout.render(context, this);
        if (render != null) {
            render.setTag(this);
        }
        imageLayout.onFinishRender();
        return render;
    }

    @Override // com.alipay.mobile.zebra.data.ZebraData
    public void loadResource(final ZebraLoader zebraLoader) {
        if (zebraLoader == null) {
            fireLoadedEvent();
            return;
        }
        String str = this.mPlaceholder;
        if (str != null) {
            zebraLoader.loadImage(str, new ZebraLoader.OnLoadImageCallback() { // from class: com.alipay.mobile.zebra.data.ImageData.1
                @Override // com.alipay.mobile.zebra.ZebraLoader.OnLoadImageCallback
                public void onComplete(Bitmap bitmap) {
                    if (bitmap != null && ImageData.this.mLayoutContext != 0) {
                        ((ImageLayout) ImageData.this.mLayoutContext).onReceiveResource("placeholder", ImageData.this.mPlaceholder, new WebImage(bitmap));
                    }
                    ImageData.this.fireLoadedEvent();
                    zebraLoader.loadImage(ImageData.this.mSrc, new ZebraLoader.OnLoadImageCallback() { // from class: com.alipay.mobile.zebra.data.ImageData.1.1
                        @Override // com.alipay.mobile.zebra.ZebraLoader.OnLoadImageCallback
                        public void onComplete(Bitmap bitmap2) {
                            if (bitmap2 != null && ImageData.this.mLayoutContext != 0) {
                                ImageData.this.mReady = ((ImageLayout) ImageData.this.mLayoutContext).onReceiveResource("src", ImageData.this.mSrc, new WebImage(bitmap2));
                            }
                            if (ImageData.this.mOnUpdateCallback != null) {
                                ImageData.this.mOnUpdateCallback.onUpdate(ImageData.this.getLayoutContext().getRenderContext(), ImageData.this, ImageData.this.getLayoutContext());
                            }
                        }
                    });
                }
            });
        } else {
            zebraLoader.loadImage(this.mSrc, new ZebraLoader.OnLoadImageCallback() { // from class: com.alipay.mobile.zebra.data.ImageData.2
                @Override // com.alipay.mobile.zebra.ZebraLoader.OnLoadImageCallback
                public void onComplete(Bitmap bitmap) {
                    if (bitmap != null && ImageData.this.mLayoutContext != 0) {
                        ImageData imageData = ImageData.this;
                        imageData.mReady = ((ImageLayout) imageData.mLayoutContext).onReceiveResource("src", ImageData.this.mSrc, new WebImage(bitmap));
                    }
                    ImageData.this.fireLoadedEvent();
                }
            });
        }
    }
}
