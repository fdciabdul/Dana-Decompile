package com.bumptech.glide.load.data;

import android.content.ContentResolver;
import android.content.res.AssetFileDescriptor;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import id.dana.data.constant.BranchLinkConstant;
import java.io.FileNotFoundException;
import java.io.IOException;

/* loaded from: classes3.dex */
public class FileDescriptorLocalUriFetcher extends LocalUriFetcher<ParcelFileDescriptor> {
    @Override // com.bumptech.glide.load.data.LocalUriFetcher
    protected final /* synthetic */ void MyBillsEntityDataFactory(ParcelFileDescriptor parcelFileDescriptor) throws IOException {
        parcelFileDescriptor.close();
    }

    public FileDescriptorLocalUriFetcher(ContentResolver contentResolver, Uri uri) {
        super(contentResolver, uri);
    }

    @Override // com.bumptech.glide.load.data.DataFetcher
    public final Class<ParcelFileDescriptor> getAuthRequestContext() {
        return ParcelFileDescriptor.class;
    }

    @Override // com.bumptech.glide.load.data.LocalUriFetcher
    protected final /* synthetic */ ParcelFileDescriptor BuiltInFictitiousFunctionClassFactory(Uri uri, ContentResolver contentResolver) throws FileNotFoundException {
        AssetFileDescriptor openAssetFileDescriptor = contentResolver.openAssetFileDescriptor(uri, BranchLinkConstant.PayloadKey.REFERRAL);
        if (openAssetFileDescriptor == null) {
            StringBuilder sb = new StringBuilder();
            sb.append("FileDescriptor is null for: ");
            sb.append(uri);
            throw new FileNotFoundException(sb.toString());
        }
        return openAssetFileDescriptor.getParcelFileDescriptor();
    }
}
