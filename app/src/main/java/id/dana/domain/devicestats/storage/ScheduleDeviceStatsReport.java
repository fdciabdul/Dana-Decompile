package id.dana.domain.devicestats.storage;

import id.dana.domain.core.usecase.CompletableUseCase;
import io.reactivex.Completable;
import java.util.concurrent.Callable;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\fB\u0011\b\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\b\u001a\u00020\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\t"}, d2 = {"Lid/dana/domain/devicestats/storage/ScheduleDeviceStatsReport;", "Lid/dana/domain/core/usecase/CompletableUseCase;", "Lid/dana/domain/devicestats/storage/ScheduleDeviceStatsReport$Param;", "param", "Lio/reactivex/Completable;", "buildUseCase", "(Lid/dana/domain/devicestats/storage/ScheduleDeviceStatsReport$Param;)Lio/reactivex/Completable;", "Lid/dana/domain/devicestats/storage/FileDirectorySizeReportScheduler;", "fileDirectorySizeReportScheduler", "Lid/dana/domain/devicestats/storage/FileDirectorySizeReportScheduler;", "<init>", "(Lid/dana/domain/devicestats/storage/FileDirectorySizeReportScheduler;)V", "Param"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class ScheduleDeviceStatsReport extends CompletableUseCase<Param> {
    private final FileDirectorySizeReportScheduler fileDirectorySizeReportScheduler;

    @Inject
    public ScheduleDeviceStatsReport(FileDirectorySizeReportScheduler fileDirectorySizeReportScheduler) {
        Intrinsics.checkNotNullParameter(fileDirectorySizeReportScheduler, "");
        this.fileDirectorySizeReportScheduler = fileDirectorySizeReportScheduler;
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B#\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\n\u0010\u000bR\u001d\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0007¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R \u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\u0005\u001a\u0004\b\t\u0010\u0007"}, d2 = {"Lid/dana/domain/devicestats/storage/ScheduleDeviceStatsReport$Param;", "", "Lkotlin/Function0;", "", "cancelWork", "Lkotlin/jvm/functions/Function0;", "getCancelWork", "()Lkotlin/jvm/functions/Function0;", "scheduleWork", "getScheduleWork", "<init>", "(Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class Param {
        private final Function0<Unit> cancelWork;
        private final Function0<Unit> scheduleWork;

        public Param(Function0<Unit> function0, Function0<Unit> function02) {
            Intrinsics.checkNotNullParameter(function0, "");
            Intrinsics.checkNotNullParameter(function02, "");
            this.scheduleWork = function0;
            this.cancelWork = function02;
        }

        @JvmName(name = "getScheduleWork")
        public final Function0<Unit> getScheduleWork() {
            return this.scheduleWork;
        }

        @JvmName(name = "getCancelWork")
        public final Function0<Unit> getCancelWork() {
            return this.cancelWork;
        }
    }

    @Override // id.dana.domain.core.usecase.CompletableUseCase
    public final Completable buildUseCase(final Param param) {
        Intrinsics.checkNotNullParameter(param, "");
        Completable KClassImpl$Data$declaredNonStaticMembers$2 = Completable.KClassImpl$Data$declaredNonStaticMembers$2(new Callable() { // from class: id.dana.domain.devicestats.storage.ScheduleDeviceStatsReport$$ExternalSyntheticLambda0
            @Override // java.util.concurrent.Callable
            public final Object call() {
                Object m2295buildUseCase$lambda0;
                m2295buildUseCase$lambda0 = ScheduleDeviceStatsReport.m2295buildUseCase$lambda0(ScheduleDeviceStatsReport.this, param);
                return m2295buildUseCase$lambda0;
            }
        });
        Intrinsics.checkNotNullExpressionValue(KClassImpl$Data$declaredNonStaticMembers$2, "");
        return KClassImpl$Data$declaredNonStaticMembers$2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: buildUseCase$lambda-0  reason: not valid java name */
    public static final Object m2295buildUseCase$lambda0(ScheduleDeviceStatsReport scheduleDeviceStatsReport, Param param) {
        Intrinsics.checkNotNullParameter(scheduleDeviceStatsReport, "");
        Intrinsics.checkNotNullParameter(param, "");
        return Boolean.valueOf(scheduleDeviceStatsReport.fileDirectorySizeReportScheduler.invoke(param.getScheduleWork(), param.getCancelWork()));
    }
}
