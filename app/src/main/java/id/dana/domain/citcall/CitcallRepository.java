package id.dana.domain.citcall;

import id.dana.domain.citcall.model.CitcallPermission;
import id.dana.domain.citcall.model.MiscallConsult;
import id.dana.domain.citcall.model.MiscallResponse;
import io.reactivex.Observable;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0006\u0010\u0007J\u0015\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0004H&¢\u0006\u0004\b\t\u0010\nø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/domain/citcall/CitcallRepository;", "", "Lid/dana/domain/citcall/model/MiscallConsult;", "miscallConsult", "Lio/reactivex/Observable;", "Lid/dana/domain/citcall/model/MiscallResponse;", "createToken", "(Lid/dana/domain/citcall/model/MiscallConsult;)Lio/reactivex/Observable;", "Lid/dana/domain/citcall/model/CitcallPermission;", "getCitcallPermission", "()Lio/reactivex/Observable;"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public interface CitcallRepository {
    Observable<MiscallResponse> createToken(MiscallConsult miscallConsult);

    Observable<CitcallPermission> getCitcallPermission();
}
