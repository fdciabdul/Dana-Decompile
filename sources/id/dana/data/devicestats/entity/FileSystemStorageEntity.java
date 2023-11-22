package id.dana.data.devicestats.entity;

import android.content.Context;
import id.dana.domain.devicestats.storage.model.FileDirectoriesModel;
import java.io.File;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\n¢\u0006\u0004\b\r\u0010\u000eJ%\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0002¢\u0006\u0004\b\b\u0010\tR\u0011\u0010\b\u001a\u00020\nX\u0007¢\u0006\u0006\n\u0004\b\u000b\u0010\f"}, d2 = {"Lid/dana/data/devicestats/entity/FileSystemStorageEntity;", "", "Ljava/io/File;", "p0", "", "Lid/dana/domain/devicestats/storage/model/FileDirectoriesModel;", "p1", "", "PlaceComponentResult", "(Ljava/io/File;Ljava/util/List;)J", "Landroid/content/Context;", "getAuthRequestContext", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class FileSystemStorageEntity {

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    public final Context PlaceComponentResult;

    @Inject
    public FileSystemStorageEntity(Context context) {
        Intrinsics.checkNotNullParameter(context, "");
        this.PlaceComponentResult = context;
    }

    public final long PlaceComponentResult(File p0, List<FileDirectoriesModel> p1) {
        long j;
        File[] listFiles = p0.listFiles();
        if (listFiles != null) {
            long j2 = 0;
            for (File file : listFiles) {
                if (file.isFile()) {
                    j = file.length();
                } else if (file.isDirectory()) {
                    Intrinsics.checkNotNullExpressionValue(file, "");
                    j = PlaceComponentResult(file, p1);
                } else {
                    j = 0;
                }
                String absolutePath = file.getAbsolutePath();
                Intrinsics.checkNotNullExpressionValue(absolutePath, "");
                p1.add(new FileDirectoriesModel(absolutePath, j, file.isFile()));
                j2 += j;
            }
            return j2;
        }
        return 0L;
    }
}
