package com.airbnb.lottie.manager;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.os.Process;
import android.text.TextUtils;
import android.util.Base64;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ExpandableListView;
import com.airbnb.lottie.ImageAssetDelegate;
import com.airbnb.lottie.LottieImageAsset;
import com.airbnb.lottie.utils.Logger;
import com.airbnb.lottie.utils.Utils;
import com.alipay.zoloz.toyger.blob.BlobStatic;
import id.dana.cashier.view.InputCardNumberView;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import o.NetworkUserEntityData$$ExternalSyntheticLambda7;

/* loaded from: classes3.dex */
public class ImageAssetManager {
    private static final Object getAuthRequestContext = new Object();
    private static int getErrorConfigVersion = 1;
    private static int scheduleImpl;
    private final String BuiltInFictitiousFunctionClassFactory;
    public ImageAssetDelegate KClassImpl$Data$declaredNonStaticMembers$2;
    private final Context MyBillsEntityDataFactory;
    public final Map<String, LottieImageAsset> PlaceComponentResult;

    public ImageAssetManager(Drawable.Callback callback, String str, ImageAssetDelegate imageAssetDelegate, Map<String, LottieImageAsset> map) {
        if (!TextUtils.isEmpty(str) && str.charAt(str.length() - 1) != '/') {
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            sb.append('/');
            this.BuiltInFictitiousFunctionClassFactory = sb.toString();
        } else {
            this.BuiltInFictitiousFunctionClassFactory = str;
        }
        if (!(callback instanceof View)) {
            Logger.getAuthRequestContext("LottieDrawable must be inside of a view for images to work.");
            this.PlaceComponentResult = new HashMap();
            this.MyBillsEntityDataFactory = null;
            return;
        }
        this.MyBillsEntityDataFactory = ((View) callback).getContext();
        this.PlaceComponentResult = map;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = imageAssetDelegate;
    }

    public final Bitmap BuiltInFictitiousFunctionClassFactory(String str) {
        int intValue;
        LottieImageAsset lottieImageAsset = this.PlaceComponentResult.get(str);
        Object obj = null;
        if (lottieImageAsset != null) {
            try {
                Bitmap bitmap = lottieImageAsset.MyBillsEntityDataFactory;
                if (bitmap != null) {
                    int i = getErrorConfigVersion + 37;
                    scheduleImpl = i % 128;
                    if (i % 2 != 0) {
                        obj.hashCode();
                        return bitmap;
                    }
                    return bitmap;
                }
                try {
                    ImageAssetDelegate imageAssetDelegate = this.KClassImpl$Data$declaredNonStaticMembers$2;
                    if (imageAssetDelegate != null) {
                        Bitmap MyBillsEntityDataFactory = imageAssetDelegate.MyBillsEntityDataFactory();
                        if (!(MyBillsEntityDataFactory == null)) {
                            int i2 = scheduleImpl + 67;
                            getErrorConfigVersion = i2 % 128;
                            int i3 = i2 % 2;
                            KClassImpl$Data$declaredNonStaticMembers$2(str, MyBillsEntityDataFactory);
                        }
                        return MyBillsEntityDataFactory;
                    }
                    String str2 = lottieImageAsset.PlaceComponentResult;
                    BitmapFactory.Options options = new BitmapFactory.Options();
                    options.inScaled = true;
                    options.inDensity = BlobStatic.MONITOR_IMAGE_WIDTH;
                    int i4 = scheduleImpl + 43;
                    getErrorConfigVersion = i4 % 128;
                    int i5 = i4 % 2;
                    try {
                        if (((Boolean) String.class.getMethod("startsWith", String.class).invoke(str2, "data:")).booleanValue()) {
                            try {
                                if ((((Integer) String.class.getMethod("indexOf", String.class).invoke(str2, "base64,")).intValue() > 0 ? InputCardNumberView.DIVIDER : (char) 21) == ' ') {
                                    int i6 = getErrorConfigVersion + 23;
                                    scheduleImpl = i6 % 128;
                                    int i7 = i6 % 2;
                                    int i8 = getErrorConfigVersion + 113;
                                    scheduleImpl = i8 % 128;
                                    try {
                                        try {
                                            if (i8 % 2 != 0) {
                                                Object[] objArr = new Object[1];
                                                objArr[1] = 44;
                                                Class[] clsArr = new Class[0];
                                                clsArr[0] = Integer.TYPE;
                                                intValue = ((Integer) String.class.getMethod("indexOf", clsArr).invoke(str2, objArr)).intValue() - 0;
                                            } else {
                                                intValue = ((Integer) String.class.getMethod("indexOf", Integer.TYPE).invoke(str2, 44)).intValue() + 1;
                                            }
                                            try {
                                                byte[] decode = Base64.decode((String) String.class.getMethod("substring", Integer.TYPE).invoke(str2, Integer.valueOf(intValue)), 0);
                                                return KClassImpl$Data$declaredNonStaticMembers$2(str, BitmapFactory.decodeByteArray(decode, 0, decode.length, options));
                                            } catch (Throwable th) {
                                                Throwable cause = th.getCause();
                                                if (cause != null) {
                                                    throw cause;
                                                }
                                                throw th;
                                            }
                                        } catch (IllegalArgumentException e) {
                                            Logger.getAuthRequestContext("data URL did not have correct base64 format.", e);
                                            return null;
                                        }
                                    } catch (Throwable th2) {
                                        Throwable cause2 = th2.getCause();
                                        if (cause2 != null) {
                                            throw cause2;
                                        }
                                        throw th2;
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
                            if (TextUtils.isEmpty(this.BuiltInFictitiousFunctionClassFactory)) {
                                throw new IllegalStateException("You must set an images folder before loading an image. Set it with LottieComposition#setImagesFolder or LottieDrawable#setImagesFolder");
                            }
                            AssetManager assets = this.MyBillsEntityDataFactory.getAssets();
                            StringBuilder sb = new StringBuilder();
                            sb.append(this.BuiltInFictitiousFunctionClassFactory);
                            sb.append(str2);
                            try {
                                Object[] objArr2 = {assets, sb.toString()};
                                Object obj2 = NetworkUserEntityData$$ExternalSyntheticLambda7.isLayoutRequested.get(-906490705);
                                if (obj2 == null) {
                                    obj2 = ((Class) NetworkUserEntityData$$ExternalSyntheticLambda7.PlaceComponentResult((char) ((Process.myTid() >> 22) + 58133), 1 - (ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)), 49 - (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)))).getMethod("getAuthRequestContext", AssetManager.class, String.class);
                                    NetworkUserEntityData$$ExternalSyntheticLambda7.isLayoutRequested.put(-906490705, obj2);
                                }
                                try {
                                    return KClassImpl$Data$declaredNonStaticMembers$2(str, Utils.KClassImpl$Data$declaredNonStaticMembers$2(BitmapFactory.decodeStream((InputStream) ((Method) obj2).invoke(null, objArr2), null, options), lottieImageAsset.KClassImpl$Data$declaredNonStaticMembers$2, lottieImageAsset.BuiltInFictitiousFunctionClassFactory));
                                } catch (IllegalArgumentException e2) {
                                    Logger.getAuthRequestContext("Unable to decode image.", e2);
                                    return null;
                                }
                            } catch (Throwable th4) {
                                Throwable cause4 = th4.getCause();
                                if (cause4 != null) {
                                    throw cause4;
                                }
                                throw th4;
                            }
                        } catch (IOException e3) {
                            Logger.getAuthRequestContext("Unable to open asset.", e3);
                            return null;
                        }
                    } catch (Throwable th5) {
                        Throwable cause5 = th5.getCause();
                        if (cause5 != null) {
                            throw cause5;
                        }
                        throw th5;
                    }
                } catch (Exception e4) {
                    throw e4;
                }
            } catch (Exception e5) {
                throw e5;
            }
        }
        return null;
    }

    public final boolean getAuthRequestContext(Context context) {
        return (context == null && this.MyBillsEntityDataFactory == null) || this.MyBillsEntityDataFactory.equals(context);
    }

    public final Bitmap KClassImpl$Data$declaredNonStaticMembers$2(String str, Bitmap bitmap) {
        synchronized (getAuthRequestContext) {
            this.PlaceComponentResult.get(str).MyBillsEntityDataFactory = bitmap;
        }
        return bitmap;
    }
}
