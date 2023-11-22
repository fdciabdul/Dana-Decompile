package id.dana.data.permissionprompt.repository.source;

import id.dana.data.AbstractEntityDataFactory;
import id.dana.data.permissionprompt.repository.PermissionPromptEntityData;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Singleton
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0006\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0014\u0010\u0005\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004"}, d2 = {"Lid/dana/data/permissionprompt/repository/source/PermissionPromptEntityDataFactory;", "Lid/dana/data/AbstractEntityDataFactory;", "Lid/dana/data/permissionprompt/repository/PermissionPromptEntityData;", "getAuthRequestContext", "Lid/dana/data/permissionprompt/repository/PermissionPromptEntityData;", "PlaceComponentResult", "p0", "<init>", "(Lid/dana/data/permissionprompt/repository/PermissionPromptEntityData;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class PermissionPromptEntityDataFactory extends AbstractEntityDataFactory<PermissionPromptEntityData> {

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    public final PermissionPromptEntityData PlaceComponentResult;

    @Inject
    public PermissionPromptEntityDataFactory(PermissionPromptEntityData permissionPromptEntityData) {
        Intrinsics.checkNotNullParameter(permissionPromptEntityData, "");
        this.PlaceComponentResult = permissionPromptEntityData;
    }

    @Override // id.dana.data.AbstractEntityDataFactory
    public final /* bridge */ /* synthetic */ PermissionPromptEntityData createData(String str) {
        return this.PlaceComponentResult;
    }
}
