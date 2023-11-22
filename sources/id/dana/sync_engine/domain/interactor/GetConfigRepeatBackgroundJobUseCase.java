package id.dana.sync_engine.domain.interactor;

import id.dana.domain.core.usecase.BaseUseCase;
import id.dana.domain.core.usecase.NoParams;
import id.dana.domain.synccontact.model.RepeatBackgroundJobs;
import id.dana.sync_engine.domain.ContactRepository;
import id.dana.sync_engine.domain.model.ConfigRepeatBackgroundJob;
import io.reactivex.Observable;
import io.reactivex.functions.Function;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0011\b\u0007\u0012\u0006\u0010\b\u001a\u00020\u0004¢\u0006\u0004\b\t\u0010\nR\u0014\u0010\u0007\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0006"}, d2 = {"Lid/dana/sync_engine/domain/interactor/GetConfigRepeatBackgroundJobUseCase;", "Lid/dana/domain/core/usecase/BaseUseCase;", "Lid/dana/sync_engine/domain/model/ConfigRepeatBackgroundJob;", "Lid/dana/domain/core/usecase/NoParams;", "Lid/dana/sync_engine/domain/ContactRepository;", "PlaceComponentResult", "Lid/dana/sync_engine/domain/ContactRepository;", "BuiltInFictitiousFunctionClassFactory", "p0", "<init>", "(Lid/dana/sync_engine/domain/ContactRepository;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class GetConfigRepeatBackgroundJobUseCase extends BaseUseCase<ConfigRepeatBackgroundJob, NoParams> {

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private final ContactRepository BuiltInFictitiousFunctionClassFactory;

    @Override // id.dana.domain.core.usecase.BaseUseCase
    public final /* synthetic */ Observable<ConfigRepeatBackgroundJob> buildUseCase(NoParams noParams) {
        Intrinsics.checkNotNullParameter(noParams, "");
        Observable map = this.BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory().map(new Function() { // from class: id.dana.sync_engine.domain.interactor.GetConfigRepeatBackgroundJobUseCase$$ExternalSyntheticLambda0
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return GetConfigRepeatBackgroundJobUseCase.MyBillsEntityDataFactory((Pair) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(map, "");
        return map;
    }

    @Inject
    public GetConfigRepeatBackgroundJobUseCase(ContactRepository contactRepository) {
        Intrinsics.checkNotNullParameter(contactRepository, "");
        this.BuiltInFictitiousFunctionClassFactory = contactRepository;
    }

    public static /* synthetic */ ConfigRepeatBackgroundJob MyBillsEntityDataFactory(Pair pair) {
        Intrinsics.checkNotNullParameter(pair, "");
        RepeatBackgroundJobs repeatBackgroundJobs = (RepeatBackgroundJobs) pair.component1();
        return new ConfigRepeatBackgroundJob(repeatBackgroundJobs.getEnable(), repeatBackgroundJobs.getIntervalTimeInMillis(), repeatBackgroundJobs.getRequiredCharging(), repeatBackgroundJobs.getRequiredDeviceIdle(), ((Boolean) pair.component2()).booleanValue());
    }
}
