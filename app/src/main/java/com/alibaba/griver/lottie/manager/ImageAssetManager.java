package com.alibaba.griver.lottie.manager;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.Base64;
import android.view.View;
import android.view.ViewConfiguration;
import com.alibaba.griver.lottie.ImageAssetDelegate;
import com.alibaba.griver.lottie.LottieImageAsset;
import com.alibaba.griver.lottie.utils.Logger;
import com.alibaba.griver.lottie.utils.Utils;
import com.alipay.zoloz.toyger.blob.BlobStatic;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import o.NetworkUserEntityData$$ExternalSyntheticLambda7;

/* loaded from: classes6.dex */
public class ImageAssetManager {
    private static int BuiltInFictitiousFunctionClassFactory = 0;
    private static int MyBillsEntityDataFactory = 1;
    private static final Object bitmapHashLock = new Object();
    private final Context context;
    private ImageAssetDelegate delegate;
    private final Map<String, LottieImageAsset> imageAssets;
    private String imagesFolder;

    public ImageAssetManager(Drawable.Callback callback, String str, ImageAssetDelegate imageAssetDelegate, Map<String, LottieImageAsset> map) {
        this.imagesFolder = str;
        if (!TextUtils.isEmpty(str)) {
            if (this.imagesFolder.charAt(r4.length() - 1) != '/') {
                StringBuilder sb = new StringBuilder();
                sb.append(this.imagesFolder);
                sb.append('/');
                this.imagesFolder = sb.toString();
            }
        }
        if (!(callback instanceof View)) {
            Logger.warning("LottieDrawable must be inside of a view for images to work.");
            this.imageAssets = new HashMap();
            this.context = null;
            return;
        }
        this.context = ((View) callback).getContext();
        this.imageAssets = map;
        setDelegate(imageAssetDelegate);
    }

    public void setDelegate(ImageAssetDelegate imageAssetDelegate) {
        this.delegate = imageAssetDelegate;
    }

    public Bitmap updateBitmap(String str, Bitmap bitmap) {
        if (bitmap == null) {
            LottieImageAsset lottieImageAsset = this.imageAssets.get(str);
            Bitmap bitmap2 = lottieImageAsset.getBitmap();
            lottieImageAsset.setBitmap(null);
            return bitmap2;
        }
        Bitmap bitmap3 = this.imageAssets.get(str).getBitmap();
        putBitmap(str, bitmap);
        return bitmap3;
    }

    public Bitmap bitmapForId(String str) {
        InputStream inputStream;
        LottieImageAsset lottieImageAsset = this.imageAssets.get(str);
        if (lottieImageAsset == null) {
            return null;
        }
        Bitmap bitmap = lottieImageAsset.getBitmap();
        if ((bitmap != null ? '3' : '8') != '8') {
            return bitmap;
        }
        ImageAssetDelegate imageAssetDelegate = this.delegate;
        if ((imageAssetDelegate != null ? 'W' : (char) 15) != 15) {
            Bitmap fetchBitmap = imageAssetDelegate.fetchBitmap(lottieImageAsset);
            if (fetchBitmap != null) {
                int i = MyBillsEntityDataFactory + 115;
                BuiltInFictitiousFunctionClassFactory = i % 128;
                int i2 = i % 2;
                putBitmap(str, fetchBitmap);
            }
            return fetchBitmap;
        }
        try {
            String fileName = lottieImageAsset.getFileName();
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inScaled = true;
            options.inDensity = BlobStatic.MONITOR_IMAGE_WIDTH;
            int i3 = MyBillsEntityDataFactory + 45;
            BuiltInFictitiousFunctionClassFactory = i3 % 128;
            int i4 = i3 % 2;
            try {
                if (((Boolean) String.class.getMethod("startsWith", String.class).invoke(fileName, "data:")).booleanValue()) {
                    try {
                        if (((Integer) String.class.getMethod("indexOf", String.class).invoke(fileName, "base64,")).intValue() > 0) {
                            int i5 = BuiltInFictitiousFunctionClassFactory + 19;
                            MyBillsEntityDataFactory = i5 % 128;
                            try {
                                try {
                                    int intValue = ((Integer) String.class.getMethod("indexOf", Integer.TYPE).invoke(fileName, Integer.valueOf(i5 % 2 != 0 ? 44 : 18))).intValue() + 1;
                                    int i6 = MyBillsEntityDataFactory + 69;
                                    BuiltInFictitiousFunctionClassFactory = i6 % 128;
                                    int i7 = i6 % 2;
                                    try {
                                        byte[] decode = Base64.decode((String) String.class.getMethod("substring", Integer.TYPE).invoke(fileName, Integer.valueOf(intValue)), 0);
                                        Bitmap putBitmap = putBitmap(str, BitmapFactory.decodeByteArray(decode, 0, decode.length, options));
                                        int i8 = BuiltInFictitiousFunctionClassFactory + 53;
                                        MyBillsEntityDataFactory = i8 % 128;
                                        int i9 = i8 % 2;
                                        return putBitmap;
                                    } catch (Throwable th) {
                                        Throwable cause = th.getCause();
                                        if (cause != null) {
                                            throw cause;
                                        }
                                        throw th;
                                    }
                                } catch (Throwable th2) {
                                    Throwable cause2 = th2.getCause();
                                    if (cause2 != null) {
                                        throw cause2;
                                    }
                                    throw th2;
                                }
                            } catch (IllegalArgumentException e) {
                                Logger.warning("data URL did not have correct base64 format.", e);
                                return null;
                            }
                        }
                    } catch (Throwable th3) {
                        Throwable cause3 = th3.getCause();
                        if (cause3 != null) {
                            throw cause3;
                        }
                        throw th3;
                    }
                }
                try {
                    if (TextUtils.isEmpty(this.imagesFolder)) {
                        throw new IllegalStateException("You must set an images folder before loading an image. Set it with LottieComposition#setImagesFolder or LottieDrawable#setImagesFolder");
                    }
                    String str2 = this.imagesFolder;
                    int i10 = BuiltInFictitiousFunctionClassFactory + 23;
                    MyBillsEntityDataFactory = i10 % 128;
                    int i11 = i10 % 2;
                    try {
                        if (((Boolean) String.class.getMethod("startsWith", String.class).invoke(str2, "/")).booleanValue()) {
                            StringBuilder sb = new StringBuilder();
                            sb.append(this.imagesFolder);
                            sb.append(fileName);
                            inputStream = new FileInputStream(sb.toString());
                        } else {
                            AssetManager assets = this.context.getAssets();
                            StringBuilder sb2 = new StringBuilder();
                            sb2.append(this.imagesFolder);
                            sb2.append(fileName);
                            try {
                                Object[] objArr = {assets, sb2.toString()};
                                Object obj = NetworkUserEntityData$$ExternalSyntheticLambda7.isLayoutRequested.get(-906490705);
                                if (obj == null) {
                                    obj = ((Class) NetworkUserEntityData$$ExternalSyntheticLambda7.PlaceComponentResult((char) (58133 - (ViewConfiguration.getMinimumFlingVelocity() >> 16)), TextUtils.getTrimmedLength(""), 49 - (ViewConfiguration.getTapTimeout() >> 16))).getMethod("getAuthRequestContext", AssetManager.class, String.class);
                                    NetworkUserEntityData$$ExternalSyntheticLambda7.isLayoutRequested.put(-906490705, obj);
                                }
                                inputStream = (InputStream) ((Method) obj).invoke(null, objArr);
                            } catch (Throwable th4) {
                                Throwable cause4 = th4.getCause();
                                if (cause4 != null) {
                                    throw cause4;
                                }
                                throw th4;
                            }
                        }
                        return putBitmap(str, Utils.resizeBitmapIfNeeded(BitmapFactory.decodeStream(inputStream, null, options), lottieImageAsset.getWidth(), lottieImageAsset.getHeight()));
                    } catch (Throwable th5) {
                        Throwable cause5 = th5.getCause();
                        if (cause5 != null) {
                            throw cause5;
                        }
                        throw th5;
                    }
                } catch (IOException e2) {
                    Logger.warning("Unable to open asset.", e2);
                    return null;
                }
            } catch (Throwable th6) {
                Throwable cause6 = th6.getCause();
                if (cause6 != null) {
                    throw cause6;
                }
                throw th6;
            }
        } catch (Exception e3) {
            throw e3;
        }
    }

    public boolean hasSameContext(Context context) {
        return (context == null && this.context == null) || this.context.equals(context);
    }

    private Bitmap putBitmap(String str, Bitmap bitmap) {
        synchronized (bitmapHashLock) {
            this.imageAssets.get(str).setBitmap(bitmap);
        }
        return bitmap;
    }
}
