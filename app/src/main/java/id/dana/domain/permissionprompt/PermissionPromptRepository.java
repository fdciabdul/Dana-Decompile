package id.dana.domain.permissionprompt;

import id.dana.domain.permissionprompt.model.NumberOfLocationPermissionPromptShown;
import id.dana.domain.permissionprompt.model.UserLocationPermissionPromptConfig;
import io.reactivex.Observable;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0006\u0010\u0007J\u0015\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0004H&¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\bH&¢\u0006\u0004\b\r\u0010\u000eø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/domain/permissionprompt/PermissionPromptRepository;", "", "", "isShouldUpdateFromSplit", "Lio/reactivex/Observable;", "Lid/dana/domain/permissionprompt/model/UserLocationPermissionPromptConfig;", "getLocationPermissionPromptConfig", "(Z)Lio/reactivex/Observable;", "Lid/dana/domain/permissionprompt/model/NumberOfLocationPermissionPromptShown;", "getNumberOfLocationPermissionPromptShown", "()Lio/reactivex/Observable;", "data", "", "saveNumberOfLocationPermissionPromptShown", "(Lid/dana/domain/permissionprompt/model/NumberOfLocationPermissionPromptShown;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public interface PermissionPromptRepository {
    Observable<UserLocationPermissionPromptConfig> getLocationPermissionPromptConfig(boolean isShouldUpdateFromSplit);

    Observable<NumberOfLocationPermissionPromptShown> getNumberOfLocationPermissionPromptShown();

    void saveNumberOfLocationPermissionPromptShown(NumberOfLocationPermissionPromptShown data);
}
