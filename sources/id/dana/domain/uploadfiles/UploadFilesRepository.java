package id.dana.domain.uploadfiles;

import io.reactivex.Observable;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0000\bf\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u0006H&J\u000e\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H&J\u0014\u0010\b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\t0\u0003H&J\u000e\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0003H&J\u0016\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\r\u001a\u00020\u000bH&J\u0016\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u000f\u001a\u00020\u000bH&J,\u0010\u0010\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\t0\u00032\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\t2\b\b\u0002\u0010\u0011\u001a\u00020\u0012H&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0013À\u0006\u0001"}, d2 = {"Lid/dana/domain/uploadfiles/UploadFilesRepository;", "", "addSelectedFiles", "Lio/reactivex/Observable;", "", "selectedFile", "Lid/dana/domain/uploadfiles/UploadFilesEntity;", "clearFiles", "getSelectedFiles", "", "getTotalFilesSize", "", "removeSelectedFiles", "index", "setTotalFilesSize", "totalSize", "uploadFiles", "bizType", "", "domain_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public interface UploadFilesRepository {
    Observable<Boolean> addSelectedFiles(UploadFilesEntity selectedFile);

    Observable<Boolean> clearFiles();

    Observable<List<UploadFilesEntity>> getSelectedFiles();

    Observable<Integer> getTotalFilesSize();

    Observable<Boolean> removeSelectedFiles(int index);

    Observable<Boolean> setTotalFilesSize(int totalSize);

    Observable<List<UploadFilesEntity>> uploadFiles(List<UploadFilesEntity> selectedFile, String bizType);

    /* renamed from: id.dana.domain.uploadfiles.UploadFilesRepository$-CC  reason: invalid class name */
    /* loaded from: classes4.dex */
    public final /* synthetic */ class CC {
        public static /* synthetic */ Observable uploadFiles$default(UploadFilesRepository uploadFilesRepository, List list, String str, int i, Object obj) {
            if (obj == null) {
                if ((i & 2) != 0) {
                    str = "";
                }
                return uploadFilesRepository.uploadFiles(list, str);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: uploadFiles");
        }
    }
}
