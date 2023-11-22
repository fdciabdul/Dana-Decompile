package io.michaelrocks.libphonenumber.android;

import android.content.res.AssetManager;
import android.graphics.Color;
import android.media.AudioTrack;
import android.text.TextUtils;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;
import o.NetworkUserEntityData$$ExternalSyntheticLambda7;

/* loaded from: classes6.dex */
public class AssetsMetadataLoader implements MetadataLoader {
    private static int KClassImpl$Data$declaredNonStaticMembers$2 = 1;
    private static int getAuthRequestContext;
    private final AssetManager assetManager;

    public AssetsMetadataLoader(AssetManager assetManager) {
        this.assetManager = assetManager;
    }

    @Override // io.michaelrocks.libphonenumber.android.MetadataLoader
    public InputStream loadMetadata(String str) {
        int i = getAuthRequestContext + 19;
        KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
        int i2 = i % 2;
        int i3 = getAuthRequestContext + 77;
        KClassImpl$Data$declaredNonStaticMembers$2 = i3 % 128;
        int i4 = i3 % 2;
        try {
            try {
                try {
                    Object[] objArr = {this.assetManager, (String) String.class.getMethod("substring", Integer.TYPE).invoke(str, 1)};
                    Object obj = NetworkUserEntityData$$ExternalSyntheticLambda7.isLayoutRequested.get(-906490705);
                    if (obj == null) {
                        obj = ((Class) NetworkUserEntityData$$ExternalSyntheticLambda7.PlaceComponentResult((char) (Color.red(0) + 58133), (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)) - 1, 49 - TextUtils.indexOf("", "", 0))).getMethod("getAuthRequestContext", AssetManager.class, String.class);
                        NetworkUserEntityData$$ExternalSyntheticLambda7.isLayoutRequested.put(-906490705, obj);
                    }
                    return (InputStream) ((Method) obj).invoke(null, objArr);
                } catch (Throwable th) {
                    Throwable cause = th.getCause();
                    if (cause != null) {
                        throw cause;
                    }
                    throw th;
                }
            } catch (IOException unused) {
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
}
