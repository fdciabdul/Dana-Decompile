package id.dana.domain.geocode.interactor;

import androidx.credentials.webauthn.Cbor$Arg$$ExternalSyntheticBackport0;
import id.dana.domain.core.usecase.BlockingUseCase;
import id.dana.domain.geocode.GeocodeRepository;
import id.dana.domain.geocode.model.LocationSubdisivision;
import io.reactivex.Scheduler;
import io.reactivex.Single;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.operators.single.SingleOnErrorReturn;
import io.reactivex.internal.operators.single.SingleTimeout;
import io.reactivex.plugins.RxJavaPlugins;
import io.reactivex.schedulers.Schedulers;
import java.util.concurrent.TimeUnit;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\rB\u0011\b\u0007\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\u000b\u0010\fJ\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\n"}, d2 = {"Lid/dana/domain/geocode/interactor/GetLatestSubdivision;", "Lid/dana/domain/core/usecase/BlockingUseCase;", "Lid/dana/domain/geocode/model/LocationSubdisivision;", "Lid/dana/domain/geocode/interactor/GetLatestSubdivision$Params;", "params", "Lio/reactivex/Single;", "buildUseCase", "(Lid/dana/domain/geocode/interactor/GetLatestSubdivision$Params;)Lio/reactivex/Single;", "Lid/dana/domain/geocode/GeocodeRepository;", "geocodeRepository", "Lid/dana/domain/geocode/GeocodeRepository;", "<init>", "(Lid/dana/domain/geocode/GeocodeRepository;)V", "Params"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class GetLatestSubdivision extends BlockingUseCase<LocationSubdisivision, Params> {
    private final GeocodeRepository geocodeRepository;

    @Inject
    public GetLatestSubdivision(GeocodeRepository geocodeRepository) {
        Intrinsics.checkNotNullParameter(geocodeRepository, "");
        this.geocodeRepository = geocodeRepository;
    }

    @Override // id.dana.domain.core.usecase.BlockingUseCase
    public final Single<LocationSubdisivision> buildUseCase(Params params) {
        Scheduler KClassImpl$Data$declaredNonStaticMembers$2;
        Intrinsics.checkNotNullParameter(params, "");
        Single<LocationSubdisivision> firstOrError = this.geocodeRepository.getLatestSubdivisions().firstOrError();
        LocationSubdisivision empty = LocationSubdisivision.INSTANCE.empty();
        ObjectHelper.PlaceComponentResult(empty, "value is null");
        Single BuiltInFictitiousFunctionClassFactory = RxJavaPlugins.BuiltInFictitiousFunctionClassFactory(new SingleOnErrorReturn(firstOrError, null, empty));
        long timeoutInSeconds = params.getTimeoutInSeconds();
        TimeUnit timeUnit = TimeUnit.SECONDS;
        KClassImpl$Data$declaredNonStaticMembers$2 = RxJavaPlugins.KClassImpl$Data$declaredNonStaticMembers$2(Schedulers.PlaceComponentResult);
        ObjectHelper.PlaceComponentResult(timeUnit, "unit is null");
        ObjectHelper.PlaceComponentResult(KClassImpl$Data$declaredNonStaticMembers$2, "scheduler is null");
        Single<LocationSubdisivision> BuiltInFictitiousFunctionClassFactory2 = RxJavaPlugins.BuiltInFictitiousFunctionClassFactory(new SingleTimeout(BuiltInFictitiousFunctionClassFactory, timeoutInSeconds, timeUnit, KClassImpl$Data$declaredNonStaticMembers$2));
        Intrinsics.checkNotNullExpressionValue(BuiltInFictitiousFunctionClassFactory2, "");
        return BuiltInFictitiousFunctionClassFactory2;
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0016\u0010\u0015J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0006\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0010\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011R\"\u0010\u0005\u001a\u00020\u00028\u0007@\u0007X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0005\u0010\u0012\u001a\u0004\b\u0013\u0010\u0004\"\u0004\b\u0014\u0010\u0015"}, d2 = {"Lid/dana/domain/geocode/interactor/GetLatestSubdivision$Params;", "", "", "component1", "()J", "timeoutInSeconds", "copy", "(J)Lid/dana/domain/geocode/interactor/GetLatestSubdivision$Params;", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "J", "getTimeoutInSeconds", "setTimeoutInSeconds", "(J)V", "<init>"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final /* data */ class Params {
        private long timeoutInSeconds;

        public static /* synthetic */ Params copy$default(Params params, long j, int i, Object obj) {
            if ((i & 1) != 0) {
                j = params.timeoutInSeconds;
            }
            return params.copy(j);
        }

        /* renamed from: component1  reason: from getter */
        public final long getTimeoutInSeconds() {
            return this.timeoutInSeconds;
        }

        public final Params copy(long timeoutInSeconds) {
            return new Params(timeoutInSeconds);
        }

        public final boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof Params) && this.timeoutInSeconds == ((Params) other).timeoutInSeconds;
        }

        public final int hashCode() {
            return Cbor$Arg$$ExternalSyntheticBackport0.m(this.timeoutInSeconds);
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("Params(timeoutInSeconds=");
            sb.append(this.timeoutInSeconds);
            sb.append(')');
            return sb.toString();
        }

        public Params(long j) {
            this.timeoutInSeconds = j;
        }

        @JvmName(name = "getTimeoutInSeconds")
        public final long getTimeoutInSeconds() {
            return this.timeoutInSeconds;
        }

        @JvmName(name = "setTimeoutInSeconds")
        public final void setTimeoutInSeconds(long j) {
            this.timeoutInSeconds = j;
        }
    }
}
