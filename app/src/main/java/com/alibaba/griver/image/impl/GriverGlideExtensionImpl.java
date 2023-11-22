package com.alibaba.griver.image.impl;

import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.griver.base.common.env.GriverEnv;
import com.alibaba.griver.base.common.logger.GriverLogger;
import com.alibaba.griver.base.common.utils.ReflectUtils;
import com.alibaba.griver.image.framework.api.GriverImageLoadExtension;
import com.alibaba.griver.image.framework.mode.GriverImageLoadRequest;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.BaseRequestOptions;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.Target;

/* loaded from: classes6.dex */
public class GriverGlideExtensionImpl implements GriverImageLoadExtension {
    public static final String GLIDE_CLASS_STR = "com.bumptech.glide.Glide";

    @Override // com.alibaba.griver.image.framework.api.GriverImageLoadExtension
    public void init() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v12, types: [com.bumptech.glide.RequestBuilder] */
    /* JADX WARN: Type inference failed for: r0v7, types: [com.bumptech.glide.request.RequestOptions, com.bumptech.glide.request.BaseRequestOptions] */
    /* JADX WARN: Type inference failed for: r0v8 */
    /* JADX WARN: Type inference failed for: r6v1 */
    /* JADX WARN: Type inference failed for: r6v6, types: [android.widget.ImageView] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:20:0x0058 -> B:26:0x0070). Please submit an issue!!! */
    @Override // com.alibaba.griver.image.framework.api.GriverImageLoadExtension
    public void loadImage(GriverImageLoadRequest griverImageLoadRequest) {
        final GriverImageLoadRequest griverImageLoadRequest2;
        BaseRequestOptions<?> baseRequestOptions;
        if (!ReflectUtils.classExist(GLIDE_CLASS_STR)) {
            RVLogger.e("GriverGlideService", "Glide lib is not exist");
        } else if (griverImageLoadRequest == 0 || griverImageLoadRequest.target == null || TextUtils.isEmpty(griverImageLoadRequest.path)) {
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append("loadImage == ");
            sb.append(griverImageLoadRequest.path);
            GriverLogger.d("GriverGlideService", sb.toString());
            ?? requestOptions = new RequestOptions();
            try {
                if (griverImageLoadRequest.width > 0 && griverImageLoadRequest.height > 0) {
                    ((RequestOptions) requestOptions.KClassImpl$Data$declaredNonStaticMembers$2(griverImageLoadRequest.defaultDrawable)).PlaceComponentResult(griverImageLoadRequest.width, griverImageLoadRequest.height);
                    baseRequestOptions = requestOptions;
                    griverImageLoadRequest2 = griverImageLoadRequest;
                } else {
                    requestOptions.KClassImpl$Data$declaredNonStaticMembers$2(griverImageLoadRequest.defaultDrawable);
                    baseRequestOptions = requestOptions;
                    griverImageLoadRequest2 = griverImageLoadRequest;
                }
            } catch (Throwable th) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("RequestOptions version error ");
                sb2.append(th.getMessage());
                GriverLogger.e("GriverGlideService", sb2.toString());
                baseRequestOptions = requestOptions;
                griverImageLoadRequest2 = griverImageLoadRequest;
            }
            try {
                requestOptions = Glide.KClassImpl$Data$declaredNonStaticMembers$2(GriverEnv.getApplicationContext()).getAuthRequestContext(griverImageLoadRequest2.path).MyBillsEntityDataFactory(baseRequestOptions).getAuthRequestContext(new RequestListener<Drawable>() { // from class: com.alibaba.griver.image.impl.GriverGlideExtensionImpl.1
                    @Override // com.bumptech.glide.request.RequestListener
                    public boolean onLoadFailed(GlideException glideException, Object obj, Target<Drawable> target, boolean z) {
                        if (griverImageLoadRequest2.callback != null) {
                            griverImageLoadRequest2.callback.onError();
                            return false;
                        }
                        return false;
                    }

                    @Override // com.bumptech.glide.request.RequestListener
                    public boolean onResourceReady(Drawable drawable, Object obj, Target<Drawable> target, DataSource dataSource, boolean z) {
                        if (griverImageLoadRequest2.callback != null) {
                            griverImageLoadRequest2.callback.onSuccess();
                            return false;
                        }
                        return false;
                    }
                });
                griverImageLoadRequest = griverImageLoadRequest2.target;
                requestOptions.MyBillsEntityDataFactory(griverImageLoadRequest);
            } catch (Throwable th2) {
                StringBuilder sb3 = new StringBuilder();
                sb3.append("Glide with error");
                sb3.append(th2.getMessage());
                GriverLogger.e("GriverGlideService", sb3.toString());
            }
        }
    }
}
