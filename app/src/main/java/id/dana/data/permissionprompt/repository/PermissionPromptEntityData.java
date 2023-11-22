package id.dana.data.permissionprompt.repository;

import id.dana.domain.permissionprompt.model.NumberOfLocationPermissionPromptShown;
import id.dana.domain.permissionprompt.model.UserLocationPermissionPromptConfig;
import io.reactivex.Observable;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0011\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u0015\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H&¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\u0002H&¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\r\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\u0006H&¢\u0006\u0004\b\r\u0010\u000eø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/data/permissionprompt/repository/PermissionPromptEntityData;", "", "Lid/dana/domain/permissionprompt/model/UserLocationPermissionPromptConfig;", "BuiltInFictitiousFunctionClassFactory", "()Lid/dana/domain/permissionprompt/model/UserLocationPermissionPromptConfig;", "Lio/reactivex/Observable;", "Lid/dana/domain/permissionprompt/model/NumberOfLocationPermissionPromptShown;", "KClassImpl$Data$declaredNonStaticMembers$2", "()Lio/reactivex/Observable;", "p0", "", "getAuthRequestContext", "(Lid/dana/domain/permissionprompt/model/UserLocationPermissionPromptConfig;)V", "PlaceComponentResult", "(Lid/dana/domain/permissionprompt/model/NumberOfLocationPermissionPromptShown;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public interface PermissionPromptEntityData {
    UserLocationPermissionPromptConfig BuiltInFictitiousFunctionClassFactory();

    Observable<NumberOfLocationPermissionPromptShown> KClassImpl$Data$declaredNonStaticMembers$2();

    void PlaceComponentResult(NumberOfLocationPermissionPromptShown p0);

    void getAuthRequestContext(UserLocationPermissionPromptConfig p0);
}
