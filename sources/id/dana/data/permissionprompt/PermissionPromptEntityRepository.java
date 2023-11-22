package id.dana.data.permissionprompt;

import id.dana.data.config.source.ConfigEntityData;
import id.dana.data.config.source.ConfigEntityDataFactory;
import id.dana.data.permissionprompt.repository.PermissionPromptEntityData;
import id.dana.data.permissionprompt.repository.source.PermissionPromptEntityDataFactory;
import id.dana.domain.permissionprompt.PermissionPromptRepository;
import id.dana.domain.permissionprompt.model.NumberOfLocationPermissionPromptShown;
import id.dana.domain.permissionprompt.model.UserLocationPermissionPromptConfig;
import io.reactivex.Observable;
import io.reactivex.functions.Consumer;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Singleton
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u0019\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u000e\u0012\u0006\u0010\u0019\u001a\u00020\u0014¢\u0006\u0004\b\u001a\u0010\u001bJ\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u0015\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0004H\u0016¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\bH\u0016¢\u0006\u0004\b\f\u0010\rR\u0014\u0010\u000f\u001a\u00020\u000e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0013\u0010\u0012\u001a\u00020\u0011X\u0082\u0080\u0002¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0015\u001a\u00020\u00148\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0017\u0010\u0018\u001a\u0006*\u00020\u00170\u0017X\u0082\u0080\u0002¢\u0006\u0006\n\u0004\b\u0018\u0010\u0013"}, d2 = {"Lid/dana/data/permissionprompt/PermissionPromptEntityRepository;", "Lid/dana/domain/permissionprompt/PermissionPromptRepository;", "", "p0", "Lio/reactivex/Observable;", "Lid/dana/domain/permissionprompt/model/UserLocationPermissionPromptConfig;", "getLocationPermissionPromptConfig", "(Z)Lio/reactivex/Observable;", "Lid/dana/domain/permissionprompt/model/NumberOfLocationPermissionPromptShown;", "getNumberOfLocationPermissionPromptShown", "()Lio/reactivex/Observable;", "", "saveNumberOfLocationPermissionPromptShown", "(Lid/dana/domain/permissionprompt/model/NumberOfLocationPermissionPromptShown;)V", "Lid/dana/data/config/source/ConfigEntityDataFactory;", "PlaceComponentResult", "Lid/dana/data/config/source/ConfigEntityDataFactory;", "Lid/dana/data/permissionprompt/repository/PermissionPromptEntityData;", "MyBillsEntityDataFactory", "Lkotlin/Lazy;", "Lid/dana/data/permissionprompt/repository/source/PermissionPromptEntityDataFactory;", "KClassImpl$Data$declaredNonStaticMembers$2", "Lid/dana/data/permissionprompt/repository/source/PermissionPromptEntityDataFactory;", "Lid/dana/data/config/source/ConfigEntityData;", "BuiltInFictitiousFunctionClassFactory", "p1", "<init>", "(Lid/dana/data/config/source/ConfigEntityDataFactory;Lid/dana/data/permissionprompt/repository/source/PermissionPromptEntityDataFactory;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class PermissionPromptEntityRepository implements PermissionPromptRepository {
    private final Lazy BuiltInFictitiousFunctionClassFactory;
    private final PermissionPromptEntityDataFactory KClassImpl$Data$declaredNonStaticMembers$2;
    private final Lazy MyBillsEntityDataFactory;
    private final ConfigEntityDataFactory PlaceComponentResult;

    @Inject
    public PermissionPromptEntityRepository(ConfigEntityDataFactory configEntityDataFactory, PermissionPromptEntityDataFactory permissionPromptEntityDataFactory) {
        Intrinsics.checkNotNullParameter(configEntityDataFactory, "");
        Intrinsics.checkNotNullParameter(permissionPromptEntityDataFactory, "");
        this.PlaceComponentResult = configEntityDataFactory;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = permissionPromptEntityDataFactory;
        this.BuiltInFictitiousFunctionClassFactory = LazyKt.lazy(new Function0<ConfigEntityData>() { // from class: id.dana.data.permissionprompt.PermissionPromptEntityRepository$splitConfigEntityData$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ConfigEntityData invoke() {
                ConfigEntityDataFactory configEntityDataFactory2;
                configEntityDataFactory2 = PermissionPromptEntityRepository.this.PlaceComponentResult;
                return configEntityDataFactory2.createData2("split");
            }
        });
        this.MyBillsEntityDataFactory = LazyKt.lazy(new Function0<PermissionPromptEntityData>() { // from class: id.dana.data.permissionprompt.PermissionPromptEntityRepository$localPermissionPromptEntityData$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final PermissionPromptEntityData invoke() {
                PermissionPromptEntityDataFactory permissionPromptEntityDataFactory2;
                permissionPromptEntityDataFactory2 = PermissionPromptEntityRepository.this.KClassImpl$Data$declaredNonStaticMembers$2;
                return permissionPromptEntityDataFactory2.PlaceComponentResult;
            }
        });
    }

    public static /* synthetic */ void BuiltInFictitiousFunctionClassFactory(PermissionPromptEntityRepository permissionPromptEntityRepository, UserLocationPermissionPromptConfig userLocationPermissionPromptConfig) {
        Intrinsics.checkNotNullParameter(permissionPromptEntityRepository, "");
        PermissionPromptEntityData permissionPromptEntityData = (PermissionPromptEntityData) permissionPromptEntityRepository.MyBillsEntityDataFactory.getValue();
        Intrinsics.checkNotNullExpressionValue(userLocationPermissionPromptConfig, "");
        permissionPromptEntityData.getAuthRequestContext(userLocationPermissionPromptConfig);
    }

    @Override // id.dana.domain.permissionprompt.PermissionPromptRepository
    public final Observable<UserLocationPermissionPromptConfig> getLocationPermissionPromptConfig(boolean p0) {
        UserLocationPermissionPromptConfig BuiltInFictitiousFunctionClassFactory = ((PermissionPromptEntityData) this.MyBillsEntityDataFactory.getValue()).BuiltInFictitiousFunctionClassFactory();
        if (BuiltInFictitiousFunctionClassFactory == null || p0) {
            Observable<UserLocationPermissionPromptConfig> doOnNext = ((ConfigEntityData) this.BuiltInFictitiousFunctionClassFactory.getValue()).getUserLocationPromptConfig().doOnNext(new Consumer() { // from class: id.dana.data.permissionprompt.PermissionPromptEntityRepository$$ExternalSyntheticLambda0
                @Override // io.reactivex.functions.Consumer
                public final void accept(Object obj) {
                    PermissionPromptEntityRepository.BuiltInFictitiousFunctionClassFactory(PermissionPromptEntityRepository.this, (UserLocationPermissionPromptConfig) obj);
                }
            });
            Intrinsics.checkNotNullExpressionValue(doOnNext, "");
            return doOnNext;
        }
        Observable<UserLocationPermissionPromptConfig> just = Observable.just(BuiltInFictitiousFunctionClassFactory);
        Intrinsics.checkNotNullExpressionValue(just, "");
        return just;
    }

    @Override // id.dana.domain.permissionprompt.PermissionPromptRepository
    public final Observable<NumberOfLocationPermissionPromptShown> getNumberOfLocationPermissionPromptShown() {
        return ((PermissionPromptEntityData) this.MyBillsEntityDataFactory.getValue()).KClassImpl$Data$declaredNonStaticMembers$2();
    }

    @Override // id.dana.domain.permissionprompt.PermissionPromptRepository
    public final void saveNumberOfLocationPermissionPromptShown(NumberOfLocationPermissionPromptShown p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        ((PermissionPromptEntityData) this.MyBillsEntityDataFactory.getValue()).PlaceComponentResult(p0);
    }
}
