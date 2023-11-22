package id.dana.data.permissionprompt.repository.source.local;

import id.dana.data.permissionprompt.repository.PermissionPromptEntityData;
import id.dana.domain.permissionprompt.model.NumberOfLocationPermissionPromptShown;
import id.dana.domain.permissionprompt.model.UserLocationPermissionPromptConfig;
import io.reactivex.Observable;
import java.util.concurrent.Callable;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Singleton
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\t\u001a\u00020\u000f¢\u0006\u0004\b\u0011\u0010\u0012J\u0011\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u0015\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\r\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\r\u0010\u000eR\u0014\u0010\u0007\u001a\u00020\u000f8\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0010"}, d2 = {"Lid/dana/data/permissionprompt/repository/source/local/LocalPermissionPromptEntityData;", "Lid/dana/data/permissionprompt/repository/PermissionPromptEntityData;", "Lid/dana/domain/permissionprompt/model/UserLocationPermissionPromptConfig;", "BuiltInFictitiousFunctionClassFactory", "()Lid/dana/domain/permissionprompt/model/UserLocationPermissionPromptConfig;", "Lio/reactivex/Observable;", "Lid/dana/domain/permissionprompt/model/NumberOfLocationPermissionPromptShown;", "KClassImpl$Data$declaredNonStaticMembers$2", "()Lio/reactivex/Observable;", "p0", "", "getAuthRequestContext", "(Lid/dana/domain/permissionprompt/model/UserLocationPermissionPromptConfig;)V", "PlaceComponentResult", "(Lid/dana/domain/permissionprompt/model/NumberOfLocationPermissionPromptShown;)V", "Lid/dana/data/permissionprompt/repository/source/local/PermissionPromptPreference;", "Lid/dana/data/permissionprompt/repository/source/local/PermissionPromptPreference;", "<init>", "(Lid/dana/data/permissionprompt/repository/source/local/PermissionPromptPreference;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class LocalPermissionPromptEntityData implements PermissionPromptEntityData {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    private final PermissionPromptPreference KClassImpl$Data$declaredNonStaticMembers$2;

    @Inject
    public LocalPermissionPromptEntityData(PermissionPromptPreference permissionPromptPreference) {
        Intrinsics.checkNotNullParameter(permissionPromptPreference, "");
        this.KClassImpl$Data$declaredNonStaticMembers$2 = permissionPromptPreference;
    }

    @Override // id.dana.data.permissionprompt.repository.PermissionPromptEntityData
    public final UserLocationPermissionPromptConfig BuiltInFictitiousFunctionClassFactory() {
        PermissionPromptPreference permissionPromptPreference = this.KClassImpl$Data$declaredNonStaticMembers$2;
        String string = permissionPromptPreference.getAuthRequestContext.getString("LOCATION_PERMISSION_PROMPT_CONFIG");
        if (string != null) {
            return (UserLocationPermissionPromptConfig) permissionPromptPreference.MyBillsEntityDataFactory.fromJson(string, UserLocationPermissionPromptConfig.class);
        }
        return null;
    }

    @Override // id.dana.data.permissionprompt.repository.PermissionPromptEntityData
    public final void getAuthRequestContext(UserLocationPermissionPromptConfig p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        PermissionPromptPreference permissionPromptPreference = this.KClassImpl$Data$declaredNonStaticMembers$2;
        Intrinsics.checkNotNullParameter(p0, "");
        permissionPromptPreference.getAuthRequestContext.saveData("LOCATION_PERMISSION_PROMPT_CONFIG", permissionPromptPreference.MyBillsEntityDataFactory.toJson(p0));
    }

    @Override // id.dana.data.permissionprompt.repository.PermissionPromptEntityData
    public final Observable<NumberOfLocationPermissionPromptShown> KClassImpl$Data$declaredNonStaticMembers$2() {
        Observable<NumberOfLocationPermissionPromptShown> fromCallable = Observable.fromCallable(new Callable() { // from class: id.dana.data.permissionprompt.repository.source.local.LocalPermissionPromptEntityData$$ExternalSyntheticLambda0
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return LocalPermissionPromptEntityData.MyBillsEntityDataFactory(LocalPermissionPromptEntityData.this);
            }
        });
        Intrinsics.checkNotNullExpressionValue(fromCallable, "");
        return fromCallable;
    }

    @Override // id.dana.data.permissionprompt.repository.PermissionPromptEntityData
    public final void PlaceComponentResult(NumberOfLocationPermissionPromptShown p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        PermissionPromptPreference permissionPromptPreference = this.KClassImpl$Data$declaredNonStaticMembers$2;
        Intrinsics.checkNotNullParameter(p0, "");
        permissionPromptPreference.getAuthRequestContext.saveData("LOCATION_PERMISSION_PROMPT_SHOWN", permissionPromptPreference.MyBillsEntityDataFactory.toJson(p0));
    }

    public static /* synthetic */ NumberOfLocationPermissionPromptShown MyBillsEntityDataFactory(LocalPermissionPromptEntityData localPermissionPromptEntityData) {
        Intrinsics.checkNotNullParameter(localPermissionPromptEntityData, "");
        PermissionPromptPreference permissionPromptPreference = localPermissionPromptEntityData.KClassImpl$Data$declaredNonStaticMembers$2;
        String string = permissionPromptPreference.getAuthRequestContext.getString("LOCATION_PERMISSION_PROMPT_SHOWN");
        NumberOfLocationPermissionPromptShown numberOfLocationPermissionPromptShown = string != null ? (NumberOfLocationPermissionPromptShown) permissionPromptPreference.MyBillsEntityDataFactory.fromJson(string, NumberOfLocationPermissionPromptShown.class) : null;
        return numberOfLocationPermissionPromptShown == null ? new NumberOfLocationPermissionPromptShown(0, 0L, 3, null) : numberOfLocationPermissionPromptShown;
    }
}
