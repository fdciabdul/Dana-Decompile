package id.dana.data.connectionbar.repository;

import id.dana.data.config.source.ConfigEntityData;
import id.dana.data.config.source.ConfigEntityDataFactory;
import id.dana.domain.connectionbar.ConnectionBarRepository;
import io.reactivex.Observable;
import io.reactivex.functions.Consumer;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0010\u001a\u00020\u0006¢\u0006\u0004\b\u0011\u0010\u0012J\u0015\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016¢\u0006\u0004\b\u0004\u0010\u0005R\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0014\u0010\f\u001a\u0004\u0018\u00010\tX\u0086\u0002¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0017\u0010\u000f\u001a\u0006*\u00020\r0\rX\u0082\u0080\u0002¢\u0006\u0006\n\u0004\b\f\u0010\u000e"}, d2 = {"Lid/dana/data/connectionbar/repository/ConnectionBarEntityRepository;", "Lid/dana/domain/connectionbar/ConnectionBarRepository;", "Lio/reactivex/Observable;", "", "getIsFeatureConnectionBarWithSignalOn", "()Lio/reactivex/Observable;", "Lid/dana/data/config/source/ConfigEntityDataFactory;", "BuiltInFictitiousFunctionClassFactory", "Lid/dana/data/config/source/ConfigEntityDataFactory;", "Ljava/util/concurrent/atomic/AtomicBoolean;", "MyBillsEntityDataFactory", "Ljava/util/concurrent/atomic/AtomicBoolean;", "getAuthRequestContext", "Lid/dana/data/config/source/ConfigEntityData;", "Lkotlin/Lazy;", "KClassImpl$Data$declaredNonStaticMembers$2", "p0", "<init>", "(Lid/dana/data/config/source/ConfigEntityDataFactory;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class ConnectionBarEntityRepository implements ConnectionBarRepository {
    private final ConfigEntityDataFactory BuiltInFictitiousFunctionClassFactory;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    public AtomicBoolean getAuthRequestContext;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    private final Lazy KClassImpl$Data$declaredNonStaticMembers$2;

    @Inject
    public ConnectionBarEntityRepository(ConfigEntityDataFactory configEntityDataFactory) {
        Intrinsics.checkNotNullParameter(configEntityDataFactory, "");
        this.BuiltInFictitiousFunctionClassFactory = configEntityDataFactory;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = LazyKt.lazy(new Function0<ConfigEntityData>() { // from class: id.dana.data.connectionbar.repository.ConnectionBarEntityRepository$splitConfigEntityData$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ConfigEntityData invoke() {
                ConfigEntityDataFactory configEntityDataFactory2;
                configEntityDataFactory2 = ConnectionBarEntityRepository.this.BuiltInFictitiousFunctionClassFactory;
                return configEntityDataFactory2.createData2("network");
            }
        });
    }

    @Override // id.dana.domain.connectionbar.ConnectionBarRepository
    public final Observable<Boolean> getIsFeatureConnectionBarWithSignalOn() {
        AtomicBoolean atomicBoolean = this.getAuthRequestContext;
        if (atomicBoolean != null) {
            Observable<Boolean> just = Observable.just(atomicBoolean != null ? Boolean.valueOf(atomicBoolean.get()) : null);
            Intrinsics.checkNotNullExpressionValue(just, "");
            return just;
        }
        Observable<Boolean> doOnNext = ((ConfigEntityData) this.KClassImpl$Data$declaredNonStaticMembers$2.getValue()).getIsFeatureConnectionBarWithSignalOn().doOnNext(new Consumer() { // from class: id.dana.data.connectionbar.repository.ConnectionBarEntityRepository$$ExternalSyntheticLambda0
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                ConnectionBarEntityRepository.PlaceComponentResult(ConnectionBarEntityRepository.this, (Boolean) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(doOnNext, "");
        return doOnNext;
    }

    public static /* synthetic */ void PlaceComponentResult(ConnectionBarEntityRepository connectionBarEntityRepository, Boolean bool) {
        Intrinsics.checkNotNullParameter(connectionBarEntityRepository, "");
        Intrinsics.checkNotNullExpressionValue(bool, "");
        connectionBarEntityRepository.getAuthRequestContext = new AtomicBoolean(bool.booleanValue());
    }
}
