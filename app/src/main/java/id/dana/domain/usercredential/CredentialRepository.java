package id.dana.domain.usercredential;

import id.dana.domain.usercredential.model.PinRegularChangesConfig;
import id.dana.domain.usercredential.model.QueryCredentialInfoModel;
import io.reactivex.Observable;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0006\u0010\u0007J%\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00042\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\tH&¢\u0006\u0004\b\f\u0010\rø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/domain/usercredential/CredentialRepository;", "", "", "shouldUpdateFromSplit", "Lio/reactivex/Observable;", "Lid/dana/domain/usercredential/model/PinRegularChangesConfig;", "getFeaturePinRegularChangesConfig", "(Z)Lio/reactivex/Observable;", "shouldUpdateFromBackend", "", "pinExpiredInDays", "Lid/dana/domain/usercredential/model/QueryCredentialInfoModel;", "getPasswordLastModified", "(ZI)Lio/reactivex/Observable;"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public interface CredentialRepository {
    Observable<PinRegularChangesConfig> getFeaturePinRegularChangesConfig(boolean shouldUpdateFromSplit);

    Observable<QueryCredentialInfoModel> getPasswordLastModified(boolean shouldUpdateFromBackend, int pinExpiredInDays);
}
