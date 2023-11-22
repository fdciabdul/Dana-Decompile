package id.dana.domain.devicestats.storage;

import com.alibaba.ariver.kernel.api.extension.bridge.BridgeDSL;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\f\u0010\rJ,\u0010\u0007\u001a\u00020\u00062\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0086\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0014\u0010\n\u001a\u00020\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000b"}, d2 = {"Lid/dana/domain/devicestats/storage/FileDirectorySizeReportScheduler;", "", "Lkotlin/Function0;", "", "scheduleWork", "cancelWork", "", BridgeDSL.INVOKE, "(Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;)Z", "Lid/dana/domain/devicestats/storage/FileDirectoriesSizeRepository;", "fileDirectoriesSizeRepository", "Lid/dana/domain/devicestats/storage/FileDirectoriesSizeRepository;", "<init>", "(Lid/dana/domain/devicestats/storage/FileDirectoriesSizeRepository;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class FileDirectorySizeReportScheduler {
    private final FileDirectoriesSizeRepository fileDirectoriesSizeRepository;

    @Inject
    public FileDirectorySizeReportScheduler(FileDirectoriesSizeRepository fileDirectoriesSizeRepository) {
        Intrinsics.checkNotNullParameter(fileDirectoriesSizeRepository, "");
        this.fileDirectoriesSizeRepository = fileDirectoriesSizeRepository;
    }

    public final boolean invoke(Function0<Unit> scheduleWork, Function0<Unit> cancelWork) {
        Intrinsics.checkNotNullParameter(scheduleWork, "");
        Intrinsics.checkNotNullParameter(cancelWork, "");
        boolean isTrackingEnable = this.fileDirectoriesSizeRepository.isTrackingEnable();
        if (isTrackingEnable) {
            scheduleWork.invoke();
        } else {
            cancelWork.invoke();
        }
        return isTrackingEnable;
    }
}
