package com.bumptech.glide.load.data;

import android.content.ContentResolver;
import android.content.res.AssetFileDescriptor;
import android.net.Uri;
import id.dana.data.constant.BranchLinkConstant;
import java.io.FileNotFoundException;
import java.io.IOException;

/* loaded from: classes3.dex */
public final class AssetFileDescriptorLocalUriFetcher extends LocalUriFetcher<AssetFileDescriptor> {
    @Override // com.bumptech.glide.load.data.LocalUriFetcher
    protected final /* synthetic */ void MyBillsEntityDataFactory(AssetFileDescriptor assetFileDescriptor) throws IOException {
        assetFileDescriptor.close();
    }

    public AssetFileDescriptorLocalUriFetcher(ContentResolver contentResolver, Uri uri) {
        super(contentResolver, uri);
    }

    @Override // com.bumptech.glide.load.data.DataFetcher
    public final Class<AssetFileDescriptor> getAuthRequestContext() {
        return AssetFileDescriptor.class;
    }

    @Override // com.bumptech.glide.load.data.LocalUriFetcher
    protected final /* synthetic */ AssetFileDescriptor BuiltInFictitiousFunctionClassFactory(Uri uri, ContentResolver contentResolver) throws FileNotFoundException {
        AssetFileDescriptor openAssetFileDescriptor = contentResolver.openAssetFileDescriptor(uri, BranchLinkConstant.PayloadKey.REFERRAL);
        if (openAssetFileDescriptor != null) {
            return openAssetFileDescriptor;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("FileDescriptor is null for: ");
        sb.append(uri);
        throw new FileNotFoundException(sb.toString());
    }
}
