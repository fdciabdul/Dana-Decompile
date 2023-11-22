package com.bumptech.glide.load.data;

import android.content.res.AssetManager;
import android.os.ParcelFileDescriptor;
import java.io.IOException;

/* loaded from: classes3.dex */
public class FileDescriptorAssetPathFetcher extends AssetPathFetcher<ParcelFileDescriptor> {
    @Override // com.bumptech.glide.load.data.AssetPathFetcher
    protected final /* synthetic */ void KClassImpl$Data$declaredNonStaticMembers$2(ParcelFileDescriptor parcelFileDescriptor) throws IOException {
        parcelFileDescriptor.close();
    }

    public FileDescriptorAssetPathFetcher(AssetManager assetManager, String str) {
        super(assetManager, str);
    }

    @Override // com.bumptech.glide.load.data.DataFetcher
    public final Class<ParcelFileDescriptor> getAuthRequestContext() {
        return ParcelFileDescriptor.class;
    }

    @Override // com.bumptech.glide.load.data.AssetPathFetcher
    protected final /* synthetic */ ParcelFileDescriptor MyBillsEntityDataFactory(AssetManager assetManager, String str) throws IOException {
        return assetManager.openFd(str).getParcelFileDescriptor();
    }
}
