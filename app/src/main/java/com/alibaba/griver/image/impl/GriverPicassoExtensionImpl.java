package com.alibaba.griver.image.impl;

import android.text.TextUtils;
import com.alibaba.ariver.kernel.common.utils.DimensionUtil;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.griver.base.common.logger.GriverLogger;
import com.alibaba.griver.base.common.utils.ReflectUtils;
import com.alibaba.griver.image.framework.api.GriverImageLoadExtension;
import com.alibaba.griver.image.framework.mode.GriverImageLoadRequest;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

/* loaded from: classes6.dex */
public class GriverPicassoExtensionImpl implements GriverImageLoadExtension {
    public static final String PICASSO_CLASS_STR = "com.squareup.picasso.Picasso";
    public static final String PICASSO_GET_METHOD = "get";

    @Override // com.alibaba.griver.image.framework.api.GriverImageLoadExtension
    public void init() {
    }

    @Override // com.alibaba.griver.image.framework.api.GriverImageLoadExtension
    public void loadImage(final GriverImageLoadRequest griverImageLoadRequest) {
        if (!ReflectUtils.classExist(PICASSO_CLASS_STR)) {
            RVLogger.e("GriverPicassoServiceImpl", "Picasso lib is not exist");
        } else if (!ReflectUtils.methodExist(PICASSO_CLASS_STR, "get") || griverImageLoadRequest == null || griverImageLoadRequest.target == null || TextUtils.isEmpty(griverImageLoadRequest.path)) {
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append("loadImage == ");
            sb.append(griverImageLoadRequest.path);
            GriverLogger.d("GriverPicassoServiceImpl", sb.toString());
            try {
                if (griverImageLoadRequest.width > 0 && griverImageLoadRequest.height > 0) {
                    Picasso.get().load(griverImageLoadRequest.path).resize(griverImageLoadRequest.width, griverImageLoadRequest.height).placeholder(griverImageLoadRequest.defaultDrawable).into(griverImageLoadRequest.target, new Callback() { // from class: com.alibaba.griver.image.impl.GriverPicassoExtensionImpl.1
                        public void onSuccess() {
                            if (griverImageLoadRequest.callback != null) {
                                griverImageLoadRequest.callback.onSuccess();
                            }
                        }

                        public void onError(Exception exc) {
                            if (griverImageLoadRequest.callback != null) {
                                griverImageLoadRequest.callback.onError();
                            }
                        }
                    });
                    return;
                }
                Picasso.get().load(griverImageLoadRequest.path).placeholder(griverImageLoadRequest.defaultDrawable).resize(0, Math.min(DimensionUtil.getScreenHeight(griverImageLoadRequest.context), (5242880 / DimensionUtil.getScreenWidth(griverImageLoadRequest.context)) / 4)).onlyScaleDown().into(griverImageLoadRequest.target, new Callback() { // from class: com.alibaba.griver.image.impl.GriverPicassoExtensionImpl.2
                    public void onSuccess() {
                        if (griverImageLoadRequest.callback != null) {
                            griverImageLoadRequest.callback.onSuccess();
                        }
                    }

                    public void onError(Exception exc) {
                        if (griverImageLoadRequest.callback != null) {
                            griverImageLoadRequest.callback.onError();
                        }
                    }
                });
            } catch (Throwable th) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("load image error");
                sb2.append(th);
                GriverLogger.e("GriverPicassoServiceImpl", sb2.toString());
            }
        }
    }
}
