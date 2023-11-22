package com.bumptech.glide.load.data;

import android.content.res.AssetManager;
import android.graphics.ImageFormat;
import android.os.Process;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.ViewConfiguration;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;
import o.NetworkUserEntityData$$ExternalSyntheticLambda7;

/* loaded from: classes3.dex */
public class StreamAssetPathFetcher extends AssetPathFetcher<InputStream> {
    private static int KClassImpl$Data$declaredNonStaticMembers$2 = 1;
    private static int MyBillsEntityDataFactory;

    @Override // com.bumptech.glide.load.data.AssetPathFetcher
    protected final /* synthetic */ void KClassImpl$Data$declaredNonStaticMembers$2(InputStream inputStream) throws IOException {
        inputStream.close();
    }

    @Override // com.bumptech.glide.load.data.AssetPathFetcher
    protected final /* synthetic */ InputStream MyBillsEntityDataFactory(AssetManager assetManager, String str) throws IOException {
        return KClassImpl$Data$declaredNonStaticMembers$2(assetManager, str);
    }

    public StreamAssetPathFetcher(AssetManager assetManager, String str) {
        super(assetManager, str);
    }

    private static InputStream KClassImpl$Data$declaredNonStaticMembers$2(AssetManager assetManager, String str) throws IOException {
        int i = MyBillsEntityDataFactory + 77;
        KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
        Object obj = null;
        if (!(i % 2 != 0)) {
            try {
                Object[] objArr = {assetManager, str};
                Object obj2 = NetworkUserEntityData$$ExternalSyntheticLambda7.isLayoutRequested.get(-906490705);
                if (obj2 == null) {
                    obj2 = ((Class) NetworkUserEntityData$$ExternalSyntheticLambda7.PlaceComponentResult((char) ((ViewConfiguration.getEdgeSlop() >> 16) + 58133), (-1) - ((byte) KeyEvent.getModifierMetaStateMask()), TextUtils.lastIndexOf("", '0', 0) + 50)).getMethod("getAuthRequestContext", AssetManager.class, String.class);
                    NetworkUserEntityData$$ExternalSyntheticLambda7.isLayoutRequested.put(-906490705, obj2);
                }
                InputStream inputStream = (InputStream) ((Method) obj2).invoke(null, objArr);
                obj.hashCode();
                return inputStream;
            } catch (Throwable th) {
                Throwable cause = th.getCause();
                if (cause != null) {
                    throw cause;
                }
                throw th;
            }
        }
        try {
            Object[] objArr2 = {assetManager, str};
            Object obj3 = NetworkUserEntityData$$ExternalSyntheticLambda7.isLayoutRequested.get(-906490705);
            if (obj3 == null) {
                obj3 = ((Class) NetworkUserEntityData$$ExternalSyntheticLambda7.PlaceComponentResult((char) ((Process.myTid() >> 22) + 58133), TextUtils.indexOf("", "", 0, 0), 48 - ImageFormat.getBitsPerPixel(0))).getMethod("getAuthRequestContext", AssetManager.class, String.class);
                NetworkUserEntityData$$ExternalSyntheticLambda7.isLayoutRequested.put(-906490705, obj3);
            }
            return (InputStream) ((Method) obj3).invoke(null, objArr2);
        } catch (Throwable th2) {
            try {
                Throwable cause2 = th2.getCause();
                if (cause2 != null) {
                    throw cause2;
                }
                throw th2;
            } catch (Exception e) {
                throw e;
            }
        }
    }

    @Override // com.bumptech.glide.load.data.DataFetcher
    public final Class<InputStream> getAuthRequestContext() {
        return InputStream.class;
    }
}
