package id.dana.data.holdlogin.v2;

import id.dana.data.config.source.sharedpreference.SharedPrefStartupConfig;
import id.dana.domain.account.LiteAccountRepository;
import id.dana.utils.holdlogin.v2.HoldLoginConfig;
import id.dana.utils.holdlogin.v2.model.FeatureHoldLoginConfig;
import java.util.concurrent.locks.ReentrantLock;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Singleton
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0019\b\u0007\u0012\u0006\u0010\u0012\u001a\u00020\u0010\u0012\u0006\u0010\u0013\u001a\u00020\t¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\b\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\b\u0010\u0007R\u0014\u0010\u0003\u001a\u00020\t8\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0018\u0010\n\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\fR\u0014\u0010\u0006\u001a\u00020\r8\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0014\u0010\u000e\u001a\u00020\u00108\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b\b\u0010\u0011"}, d2 = {"Lid/dana/data/holdlogin/v2/HoldLoginFeatureFlag;", "Lid/dana/utils/holdlogin/v2/HoldLoginConfig;", "Lid/dana/utils/holdlogin/v2/model/FeatureHoldLoginConfig;", "KClassImpl$Data$declaredNonStaticMembers$2", "()Lid/dana/utils/holdlogin/v2/model/FeatureHoldLoginConfig;", "", "getAuthRequestContext", "()Z", "BuiltInFictitiousFunctionClassFactory", "Lid/dana/domain/account/LiteAccountRepository;", "MyBillsEntityDataFactory", "Lid/dana/domain/account/LiteAccountRepository;", "Lid/dana/utils/holdlogin/v2/model/FeatureHoldLoginConfig;", "Ljava/util/concurrent/locks/ReentrantLock;", "PlaceComponentResult", "Ljava/util/concurrent/locks/ReentrantLock;", "Lid/dana/data/config/source/sharedpreference/SharedPrefStartupConfig;", "Lid/dana/data/config/source/sharedpreference/SharedPrefStartupConfig;", "p0", "p1", "<init>", "(Lid/dana/data/config/source/sharedpreference/SharedPrefStartupConfig;Lid/dana/domain/account/LiteAccountRepository;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class HoldLoginFeatureFlag implements HoldLoginConfig {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    private final SharedPrefStartupConfig PlaceComponentResult;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    private FeatureHoldLoginConfig MyBillsEntityDataFactory;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private final LiteAccountRepository KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private final ReentrantLock getAuthRequestContext;

    @Inject
    public HoldLoginFeatureFlag(SharedPrefStartupConfig sharedPrefStartupConfig, LiteAccountRepository liteAccountRepository) {
        Intrinsics.checkNotNullParameter(sharedPrefStartupConfig, "");
        Intrinsics.checkNotNullParameter(liteAccountRepository, "");
        this.PlaceComponentResult = sharedPrefStartupConfig;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = liteAccountRepository;
        this.getAuthRequestContext = new ReentrantLock();
    }

    @Override // id.dana.utils.holdlogin.v2.HoldLoginConfig
    public final boolean BuiltInFictitiousFunctionClassFactory() {
        ReentrantLock reentrantLock = this.getAuthRequestContext;
        reentrantLock.lock();
        try {
            return KClassImpl$Data$declaredNonStaticMembers$2().NetworkUserEntityData$$ExternalSyntheticLambda0 == 2;
        } finally {
            reentrantLock.unlock();
        }
    }

    @Override // id.dana.utils.holdlogin.v2.HoldLoginConfig
    public final boolean getAuthRequestContext() {
        boolean z;
        String blockingFirst;
        ReentrantLock reentrantLock = this.getAuthRequestContext;
        reentrantLock.lock();
        try {
            blockingFirst = this.KClassImpl$Data$declaredNonStaticMembers$2.getUserId().blockingFirst();
            Intrinsics.checkNotNullExpressionValue(blockingFirst, "");
        } catch (Exception unused) {
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
        if (blockingFirst.length() > 0) {
            z = true;
            reentrantLock.unlock();
            return z;
        }
        z = false;
        reentrantLock.unlock();
        return z;
    }

    @Override // id.dana.utils.holdlogin.v2.HoldLoginConfig
    public final FeatureHoldLoginConfig KClassImpl$Data$declaredNonStaticMembers$2() {
        ReentrantLock reentrantLock = this.getAuthRequestContext;
        reentrantLock.lock();
        try {
            FeatureHoldLoginConfig featureHoldLoginConfig = this.MyBillsEntityDataFactory;
            if (featureHoldLoginConfig == null) {
                FeatureHoldLoginConfig holdLoginConfig = this.PlaceComponentResult.getHoldLoginConfig();
                this.MyBillsEntityDataFactory = holdLoginConfig;
                return holdLoginConfig;
            }
            return featureHoldLoginConfig;
        } finally {
            reentrantLock.unlock();
        }
    }
}
