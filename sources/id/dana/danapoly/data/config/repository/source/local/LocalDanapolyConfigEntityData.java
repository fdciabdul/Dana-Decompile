package id.dana.danapoly.data.config.repository.source.local;

import id.dana.danapoly.data.config.repository.source.DanapolyConfigData;
import id.dana.danapoly.di.DanapolyScope;
import id.dana.danapoly.ui.model.BackgroundColorType;
import id.dana.data.storage.PreferenceFacade;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;

@DanapolyScope
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0007\u001a\u00020\u000f¢\u0006\u0004\b\u0013\u0010\u0014J\u0015\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J\u001d\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJ\u001d\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\b0\u00022\u0006\u0010\u0007\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u000b\u001a\u00020\r2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u000b\u0010\u000eR\u0014\u0010\u0012\u001a\u00020\u000f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011"}, d2 = {"Lid/dana/danapoly/data/config/repository/source/local/LocalDanapolyConfigEntityData;", "Lid/dana/danapoly/data/config/repository/source/DanapolyConfigData;", "Lkotlinx/coroutines/flow/Flow;", "Lid/dana/danapoly/ui/model/BackgroundColorType;", "getAuthRequestContext", "()Lkotlinx/coroutines/flow/Flow;", "", "p0", "", "MyBillsEntityDataFactory", "(Ljava/lang/String;)Lkotlinx/coroutines/flow/Flow;", "KClassImpl$Data$declaredNonStaticMembers$2", "(Lid/dana/danapoly/ui/model/BackgroundColorType;)Lkotlinx/coroutines/flow/Flow;", "", "(Ljava/lang/String;)V", "Lid/dana/danapoly/data/config/repository/source/local/DanapolyPreference;", "PlaceComponentResult", "Lid/dana/danapoly/data/config/repository/source/local/DanapolyPreference;", "BuiltInFictitiousFunctionClassFactory", "<init>", "(Lid/dana/danapoly/data/config/repository/source/local/DanapolyPreference;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class LocalDanapolyConfigEntityData implements DanapolyConfigData {

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private final DanapolyPreference BuiltInFictitiousFunctionClassFactory;

    @Override // id.dana.danapoly.data.config.repository.source.DanapolyConfigData
    public final /* synthetic */ Flow BuiltInFictitiousFunctionClassFactory(String str) {
        return DanapolyConfigData.CC.PlaceComponentResult(str);
    }

    @Override // id.dana.danapoly.data.config.repository.source.DanapolyConfigData
    public final /* synthetic */ Flow PlaceComponentResult() {
        return DanapolyConfigData.CC.BuiltInFictitiousFunctionClassFactory();
    }

    @Override // id.dana.danapoly.data.config.repository.source.DanapolyConfigData
    public final /* synthetic */ Flow getAuthRequestContext(String str) {
        return DanapolyConfigData.CC.BuiltInFictitiousFunctionClassFactory(str);
    }

    @Inject
    public LocalDanapolyConfigEntityData(DanapolyPreference danapolyPreference) {
        Intrinsics.checkNotNullParameter(danapolyPreference, "");
        this.BuiltInFictitiousFunctionClassFactory = danapolyPreference;
    }

    @Override // id.dana.danapoly.data.config.repository.source.DanapolyConfigData
    public final Flow<Boolean> KClassImpl$Data$declaredNonStaticMembers$2(BackgroundColorType p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        return FlowKt.flowOf(Boolean.valueOf(this.BuiltInFictitiousFunctionClassFactory.PlaceComponentResult(p0)));
    }

    @Override // id.dana.danapoly.data.config.repository.source.DanapolyConfigData
    public final Flow<BackgroundColorType> getAuthRequestContext() {
        BackgroundColorType backgroundColorType = (BackgroundColorType) this.BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2.getObject("LastBackgroundColor", BackgroundColorType.class);
        if (backgroundColorType == null) {
            backgroundColorType = BackgroundColorType.BLUE;
        }
        return FlowKt.flowOf(backgroundColorType);
    }

    @Override // id.dana.danapoly.data.config.repository.source.DanapolyConfigData
    public final void KClassImpl$Data$declaredNonStaticMembers$2(String p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        DanapolyPreference danapolyPreference = this.BuiltInFictitiousFunctionClassFactory;
        Intrinsics.checkNotNullParameter(p0, "");
        PreferenceFacade preferenceFacade = danapolyPreference.KClassImpl$Data$declaredNonStaticMembers$2;
        StringBuilder sb = new StringBuilder();
        sb.append(p0);
        sb.append("ShownTutorial");
        preferenceFacade.saveData(sb.toString(), Boolean.TRUE);
    }

    @Override // id.dana.danapoly.data.config.repository.source.DanapolyConfigData
    public final Flow<Boolean> MyBillsEntityDataFactory(String p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        return FlowKt.flowOf(Boolean.valueOf(this.BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory(p0)));
    }
}
