package id.dana.domain.uploadfiles;

import id.dana.domain.core.usecase.BaseUseCase;
import id.dana.domain.uploadfiles.UploadFilesRepository;
import io.reactivex.Observable;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\u000b\u0010\fJ)\u0010\u0006\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\n"}, d2 = {"Lid/dana/domain/uploadfiles/UploadFile;", "Lid/dana/domain/core/usecase/BaseUseCase;", "", "Lid/dana/domain/uploadfiles/UploadFilesEntity;", "params", "Lio/reactivex/Observable;", "buildUseCase", "(Ljava/util/List;)Lio/reactivex/Observable;", "Lid/dana/domain/uploadfiles/UploadFilesRepository;", "uploadFilesRepository", "Lid/dana/domain/uploadfiles/UploadFilesRepository;", "<init>", "(Lid/dana/domain/uploadfiles/UploadFilesRepository;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class UploadFile extends BaseUseCase<List<? extends UploadFilesEntity>, List<? extends UploadFilesEntity>> {
    private final UploadFilesRepository uploadFilesRepository;

    @Override // id.dana.domain.core.usecase.BaseUseCase
    public final /* bridge */ /* synthetic */ Observable<List<? extends UploadFilesEntity>> buildUseCase(List<? extends UploadFilesEntity> list) {
        return buildUseCase2((List<UploadFilesEntity>) list);
    }

    @Inject
    public UploadFile(UploadFilesRepository uploadFilesRepository) {
        Intrinsics.checkNotNullParameter(uploadFilesRepository, "");
        this.uploadFilesRepository = uploadFilesRepository;
    }

    /* renamed from: buildUseCase  reason: avoid collision after fix types in other method */
    public final Observable<List<UploadFilesEntity>> buildUseCase2(List<UploadFilesEntity> params) {
        Intrinsics.checkNotNullParameter(params, "");
        return UploadFilesRepository.CC.uploadFiles$default(this.uploadFilesRepository, params, null, 2, null);
    }
}
