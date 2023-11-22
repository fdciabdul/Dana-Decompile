package com.mixpanel.android.util;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Base64;
import android.util.LruCache;
import com.alipay.mobile.verifyidentity.business.securitycommon.widget.ConvertUtils;
import com.mixpanel.android.mpmetrics.MPConfig;
import com.mixpanel.android.util.RemoteService;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* loaded from: classes.dex */
public class ImageStore {
    public static LruCache<String, Bitmap> BuiltInFictitiousFunctionClassFactory;
    private final File KClassImpl$Data$declaredNonStaticMembers$2;
    private final RemoteService MyBillsEntityDataFactory;
    private final MPConfig PlaceComponentResult;
    private final MessageDigest getAuthRequestContext;

    /* loaded from: classes.dex */
    public static class CantGetImageException extends Exception {
        public CantGetImageException(String str) {
            super(str);
        }

        public CantGetImageException(String str, Throwable th) {
            super(str, th);
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public ImageStore(android.content.Context r3, java.lang.String r4) {
        /*
            r2 = this;
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "MixpanelAPI.Images."
            r0.append(r1)
            r0.append(r4)
            java.lang.String r4 = r0.toString()
            com.mixpanel.android.util.HttpService r0 = new com.mixpanel.android.util.HttpService
            r0.<init>()
            r2.<init>(r3, r4, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mixpanel.android.util.ImageStore.<init>(android.content.Context, java.lang.String):void");
    }

    private ImageStore(Context context, String str, RemoteService remoteService) {
        MessageDigest messageDigest;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = context.getDir(str, 0);
        this.MyBillsEntityDataFactory = remoteService;
        this.PlaceComponentResult = MPConfig.getAuthRequestContext(context);
        try {
            messageDigest = MessageDigest.getInstance("SHA1");
        } catch (NoSuchAlgorithmException unused) {
            MPLog.BuiltInFictitiousFunctionClassFactory("MixpanelAPI.ImageStore", "Images won't be stored because this platform doesn't supply a SHA1 hash function");
            messageDigest = null;
        }
        this.getAuthRequestContext = messageDigest;
        if (BuiltInFictitiousFunctionClassFactory == null) {
            synchronized (ImageStore.class) {
                if (BuiltInFictitiousFunctionClassFactory == null) {
                    BuiltInFictitiousFunctionClassFactory = new LruCache<String, Bitmap>(((int) (Runtime.getRuntime().maxMemory() / ConvertUtils.KB)) / this.PlaceComponentResult.NetworkUserEntityData$$ExternalSyntheticLambda0) { // from class: com.mixpanel.android.util.ImageStore.1
                        @Override // android.util.LruCache
                        protected /* synthetic */ int sizeOf(String str2, Bitmap bitmap) {
                            Bitmap bitmap2 = bitmap;
                            return (bitmap2.getRowBytes() * bitmap2.getHeight()) / 1024;
                        }
                    };
                }
            }
        }
    }

    private File getAuthRequestContext(String str) throws CantGetImageException {
        FileOutputStream fileOutputStream;
        File PlaceComponentResult = PlaceComponentResult(str);
        if (PlaceComponentResult == null || !PlaceComponentResult.exists()) {
            try {
                byte[] BuiltInFictitiousFunctionClassFactory2 = this.MyBillsEntityDataFactory.BuiltInFictitiousFunctionClassFactory(str, null, this.PlaceComponentResult.initRecordTimeStamp());
                if (BuiltInFictitiousFunctionClassFactory2 != null && PlaceComponentResult != null) {
                    try {
                        if (BuiltInFictitiousFunctionClassFactory2.length < 10000000) {
                            try {
                                fileOutputStream = new FileOutputStream(PlaceComponentResult);
                                try {
                                    fileOutputStream.write(BuiltInFictitiousFunctionClassFactory2);
                                    try {
                                        fileOutputStream.close();
                                    } catch (IOException e) {
                                        MPLog.BuiltInFictitiousFunctionClassFactory("MixpanelAPI.ImageStore", "Problem closing output file", e);
                                    }
                                } catch (FileNotFoundException e2) {
                                    e = e2;
                                    throw new CantGetImageException("It appears that ImageStore is misconfigured, or disk storage is unavailable- can't write to bitmap directory", e);
                                } catch (IOException e3) {
                                    e = e3;
                                    throw new CantGetImageException("Can't store bitmap", e);
                                } catch (Throwable th) {
                                    th = th;
                                    if (fileOutputStream != null) {
                                        try {
                                            fileOutputStream.close();
                                        } catch (IOException e4) {
                                            MPLog.BuiltInFictitiousFunctionClassFactory("MixpanelAPI.ImageStore", "Problem closing output file", e4);
                                        }
                                    }
                                    throw th;
                                }
                            } catch (FileNotFoundException e5) {
                                e = e5;
                            } catch (IOException e6) {
                                e = e6;
                            }
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        fileOutputStream = null;
                    }
                }
            } catch (RemoteService.ServiceUnavailableException e7) {
                throw new CantGetImageException("Couldn't download image due to service availability", e7);
            } catch (IOException e8) {
                throw new CantGetImageException("Can't download bitmap", e8);
            }
        }
        return PlaceComponentResult;
    }

    public final Bitmap KClassImpl$Data$declaredNonStaticMembers$2(String str) throws CantGetImageException {
        Bitmap BuiltInFictitiousFunctionClassFactory2 = BuiltInFictitiousFunctionClassFactory(str);
        if (BuiltInFictitiousFunctionClassFactory2 == null) {
            File authRequestContext = getAuthRequestContext(str);
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeFile(authRequestContext.getAbsolutePath(), options);
            float f = options.outHeight * options.outWidth * 4.0f;
            Runtime runtime = Runtime.getRuntime();
            if (f > ((float) runtime.maxMemory()) - ((float) (runtime.totalMemory() - runtime.freeMemory()))) {
                throw new CantGetImageException("Do not have enough memory for the image");
            }
            Bitmap decodeFile = BitmapFactory.decodeFile(authRequestContext.getAbsolutePath());
            if (decodeFile == null) {
                authRequestContext.delete();
                throw new CantGetImageException("Bitmap on disk can't be opened or was corrupt");
            }
            if (BuiltInFictitiousFunctionClassFactory(str) == null) {
                synchronized (BuiltInFictitiousFunctionClassFactory) {
                    BuiltInFictitiousFunctionClassFactory.put(str, decodeFile);
                }
            }
            return decodeFile;
        }
        return BuiltInFictitiousFunctionClassFactory2;
    }

    public final File PlaceComponentResult(String str) {
        MessageDigest messageDigest = this.getAuthRequestContext;
        if (messageDigest == null) {
            return null;
        }
        byte[] digest = messageDigest.digest(str.getBytes());
        StringBuilder sb = new StringBuilder();
        sb.append("MP_IMG_");
        sb.append(Base64.encodeToString(digest, 10));
        return new File(this.KClassImpl$Data$declaredNonStaticMembers$2, sb.toString());
    }

    private static Bitmap BuiltInFictitiousFunctionClassFactory(String str) {
        Bitmap bitmap;
        synchronized (BuiltInFictitiousFunctionClassFactory) {
            bitmap = BuiltInFictitiousFunctionClassFactory.get(str);
        }
        return bitmap;
    }
}
