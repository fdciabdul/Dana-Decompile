package com.alipay.mobile.zebra.layout;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.webkit.WebResourceResponse;
import android.widget.ImageView;
import com.alipay.mobile.zebra.data.ImageData;
import com.alipay.mobile.zebra.data.web.WebImage;
import com.alipay.mobile.zebra.graphics.ZebraColor;
import com.alipay.mobile.zebra.graphics.drawable.RoundImageDrawable;
import com.alipay.mobile.zebra.internal.ZebraLog;
import com.alipay.mobile.zebra.utils.ZebraUtils;

/* loaded from: classes7.dex */
public class ImageLayout extends ZebraLayout<ImageData> {
    @Override // com.alipay.mobile.zebra.layout.ZebraLayout
    public View render(Context context, ImageData imageData) {
        setDataContext(imageData);
        ImageView imageView = new ImageView(context);
        setRenderContext(imageView);
        onRenderLayoutParams(context);
        onRenderPadding(context);
        return imageView;
    }

    public boolean hasBorder() {
        return (this.mDataContext == 0 || (((ImageData) this.mDataContext).getBorderRadius() == -1.0f && ((ImageData) this.mDataContext).getBorderWidth() == -1.0f && ((ImageData) this.mDataContext).getBorderColor() == null)) ? false : true;
    }

    @Override // com.alipay.mobile.zebra.layout.ZebraLayout
    public boolean onReceiveResource(String str, String str2, WebResourceResponse webResourceResponse) {
        if (this.mRenderContext == null) {
            ZebraLog.w("ImageLayout", "render context is null on receive resource");
            return false;
        }
        if (webResourceResponse != null && (webResourceResponse instanceof WebImage)) {
            Bitmap bitmap = ((WebImage) webResourceResponse).image;
            if (bitmap != null && (this.mRenderContext instanceof ImageView)) {
                ImageView imageView = (ImageView) this.mRenderContext;
                if (hasBorder() || ((ImageData) this.mDataContext).getBackgroundColor() != null) {
                    Context context = this.mRenderContext.getContext();
                    RoundImageDrawable roundImageDrawable = new RoundImageDrawable(bitmap);
                    if (((ImageData) this.mDataContext).getBorderRadius() != -1.0f) {
                        roundImageDrawable.setBorderRadius(ZebraUtils.dp2px(context, ((ImageData) this.mDataContext).getBorderRadius()));
                    }
                    if (((ImageData) this.mDataContext).getBorderWidth() != -1.0f) {
                        roundImageDrawable.setBorderWidth(ZebraUtils.dp2px(context, ((ImageData) this.mDataContext).getBorderWidth()));
                    }
                    if (((ImageData) this.mDataContext).getBorderColor() != null) {
                        roundImageDrawable.setBorderColor(ZebraColor.parseColor(((ImageData) this.mDataContext).getBorderColor(), -1));
                    }
                    if (((ImageData) this.mDataContext).getBackgroundColor() != null) {
                        roundImageDrawable.setBackgroundColor(ZebraColor.parseColor(((ImageData) this.mDataContext).getBackgroundColor(), -1));
                    }
                    imageView.setImageDrawable(roundImageDrawable);
                    return true;
                }
                imageView.setImageBitmap(bitmap);
                return true;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("bitmap error: ");
            sb.append(str2);
            ZebraLog.e("ImageLayout", sb.toString());
        } else {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("response error: ");
            sb2.append(str2);
            ZebraLog.e("ImageLayout", sb2.toString());
        }
        return false;
    }
}
