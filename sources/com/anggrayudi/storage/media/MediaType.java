package com.anggrayudi.storage.media;

import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.provider.MediaStore;
import com.anggrayudi.storage.file.PublicDirectory;
import com.iap.ac.android.region.cdp.model.CdpContentInfo;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmName;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u001d\b\u0002\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\r\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\r¢\u0006\u0004\b\u0014\u0010\u0015R\u001d\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028G¢\u0006\f\u0012\u0004\b\u0006\u0010\u0007\u001a\u0004\b\u0004\u0010\u0005R\u0011\u0010\f\u001a\u00020\t8G¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\u000e\u001a\u0004\u0018\u00010\r8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\r8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u000f\u001a\u0004\b\u0013\u0010\u0011j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019"}, d2 = {"Lcom/anggrayudi/storage/media/MediaType;", "", "", "Ljava/io/File;", "getDirectories", "()Ljava/util/List;", "getDirectories$annotations", "()V", "directories", "", "getMimeType", "()Ljava/lang/String;", "mimeType", "Landroid/net/Uri;", "readUri", "Landroid/net/Uri;", "getReadUri", "()Landroid/net/Uri;", "writeUri", "getWriteUri", "<init>", "(Ljava/lang/String;ILandroid/net/Uri;Landroid/net/Uri;)V", CdpContentInfo.CONTENT_TYPE_IMAGE, "AUDIO", "VIDEO", "DOWNLOADS"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
public enum MediaType {
    IMAGE(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, MediaStore.Images.Media.getContentUri(MediaStoreCompat.MyBillsEntityDataFactory())),
    AUDIO(MediaStore.Audio.Media.EXTERNAL_CONTENT_URI, MediaStore.Audio.Media.getContentUri(MediaStoreCompat.MyBillsEntityDataFactory())),
    VIDEO(MediaStore.Video.Media.EXTERNAL_CONTENT_URI, MediaStore.Video.Media.getContentUri(MediaStoreCompat.MyBillsEntityDataFactory())),
    DOWNLOADS(Build.VERSION.SDK_INT < 29 ? null : MediaStore.Downloads.EXTERNAL_CONTENT_URI, Build.VERSION.SDK_INT >= 29 ? MediaStore.Downloads.getContentUri(MediaStoreCompat.MyBillsEntityDataFactory()) : null);

    private final Uri readUri;
    private final Uri writeUri;

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    /* loaded from: classes3.dex */
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] getAuthRequestContext;

        static {
            int[] iArr = new int[MediaType.values().length];
            iArr[MediaType.IMAGE.ordinal()] = 1;
            iArr[MediaType.AUDIO.ordinal()] = 2;
            iArr[MediaType.VIDEO.ordinal()] = 3;
            iArr[MediaType.DOWNLOADS.ordinal()] = 4;
            getAuthRequestContext = iArr;
        }
    }

    public static /* synthetic */ void getDirectories$annotations() {
    }

    MediaType(Uri uri, Uri uri2) {
        this.readUri = uri;
        this.writeUri = uri2;
    }

    @JvmName(name = "getReadUri")
    public final Uri getReadUri() {
        return this.readUri;
    }

    @JvmName(name = "getWriteUri")
    public final Uri getWriteUri() {
        return this.writeUri;
    }

    @JvmName(name = "getDirectories")
    public final List<File> getDirectories() {
        int i = WhenMappings.getAuthRequestContext[ordinal()];
        int i2 = 0;
        if (i == 1) {
            ImageMediaDirectory[] values = ImageMediaDirectory.values();
            ArrayList arrayList = new ArrayList(values.length);
            int length = values.length;
            while (i2 < length) {
                arrayList.add(Environment.getExternalStoragePublicDirectory(values[i2].getFolderName()));
                i2++;
            }
            return arrayList;
        } else if (i == 2) {
            AudioMediaDirectory[] values2 = AudioMediaDirectory.values();
            ArrayList arrayList2 = new ArrayList(values2.length);
            int length2 = values2.length;
            while (i2 < length2) {
                arrayList2.add(Environment.getExternalStoragePublicDirectory(values2[i2].getFolderName()));
                i2++;
            }
            return arrayList2;
        } else if (i != 3) {
            if (i == 4) {
                return CollectionsKt.listOf(PublicDirectory.DOWNLOADS.getFile());
            }
            throw new NoWhenBranchMatchedException();
        } else {
            VideoMediaDirectory[] values3 = VideoMediaDirectory.values();
            ArrayList arrayList3 = new ArrayList(values3.length);
            int length3 = values3.length;
            while (i2 < length3) {
                arrayList3.add(Environment.getExternalStoragePublicDirectory(values3[i2].getFolderName()));
                i2++;
            }
            return arrayList3;
        }
    }

    @JvmName(name = "getMimeType")
    public final String getMimeType() {
        int i = WhenMappings.getAuthRequestContext[ordinal()];
        return i != 1 ? i != 2 ? i != 3 ? "*/*" : "video/*" : "audio/*" : "image/*";
    }
}
