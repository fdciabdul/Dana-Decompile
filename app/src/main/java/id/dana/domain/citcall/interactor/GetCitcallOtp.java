package id.dana.domain.citcall.interactor;

import id.dana.domain.citcall.CitcallRepository;
import id.dana.domain.citcall.model.MiscallConsult;
import id.dana.domain.citcall.model.MiscallResponse;
import id.dana.domain.core.usecase.BaseUseCase;
import io.reactivex.Observable;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\rB\u0011\b\u0007\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\u000b\u0010\fJ\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\n"}, d2 = {"Lid/dana/domain/citcall/interactor/GetCitcallOtp;", "Lid/dana/domain/core/usecase/BaseUseCase;", "Lid/dana/domain/citcall/model/MiscallResponse;", "Lid/dana/domain/citcall/interactor/GetCitcallOtp$Param;", "params", "Lio/reactivex/Observable;", "buildUseCase", "(Lid/dana/domain/citcall/interactor/GetCitcallOtp$Param;)Lio/reactivex/Observable;", "Lid/dana/domain/citcall/CitcallRepository;", "citcallRepository", "Lid/dana/domain/citcall/CitcallRepository;", "<init>", "(Lid/dana/domain/citcall/CitcallRepository;)V", "Param"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class GetCitcallOtp extends BaseUseCase<MiscallResponse, Param> {
    private final CitcallRepository citcallRepository;

    @Inject
    public GetCitcallOtp(CitcallRepository citcallRepository) {
        Intrinsics.checkNotNullParameter(citcallRepository, "");
        this.citcallRepository = citcallRepository;
    }

    @Override // id.dana.domain.core.usecase.BaseUseCase
    public final Observable<MiscallResponse> buildUseCase(Param params) {
        Intrinsics.checkNotNullParameter(params, "");
        return this.citcallRepository.createToken(params.getMiscallConsult());
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0006\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0010\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0005\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\u0005\u0010\u0012\u001a\u0004\b\u0013\u0010\u0004"}, d2 = {"Lid/dana/domain/citcall/interactor/GetCitcallOtp$Param;", "", "Lid/dana/domain/citcall/model/MiscallConsult;", "component1", "()Lid/dana/domain/citcall/model/MiscallConsult;", "miscallConsult", "copy", "(Lid/dana/domain/citcall/model/MiscallConsult;)Lid/dana/domain/citcall/interactor/GetCitcallOtp$Param;", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "Lid/dana/domain/citcall/model/MiscallConsult;", "getMiscallConsult", "<init>", "(Lid/dana/domain/citcall/model/MiscallConsult;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final /* data */ class Param {
        private final MiscallConsult miscallConsult;

        public static /* synthetic */ Param copy$default(Param param, MiscallConsult miscallConsult, int i, Object obj) {
            if ((i & 1) != 0) {
                miscallConsult = param.miscallConsult;
            }
            return param.copy(miscallConsult);
        }

        /* renamed from: component1  reason: from getter */
        public final MiscallConsult getMiscallConsult() {
            return this.miscallConsult;
        }

        public final Param copy(MiscallConsult miscallConsult) {
            Intrinsics.checkNotNullParameter(miscallConsult, "");
            return new Param(miscallConsult);
        }

        public final boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof Param) && Intrinsics.areEqual(this.miscallConsult, ((Param) other).miscallConsult);
        }

        public final int hashCode() {
            return this.miscallConsult.hashCode();
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("Param(miscallConsult=");
            sb.append(this.miscallConsult);
            sb.append(')');
            return sb.toString();
        }

        public Param(MiscallConsult miscallConsult) {
            Intrinsics.checkNotNullParameter(miscallConsult, "");
            this.miscallConsult = miscallConsult;
        }

        @JvmName(name = "getMiscallConsult")
        public final MiscallConsult getMiscallConsult() {
            return this.miscallConsult;
        }
    }
}
