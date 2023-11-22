package id.dana.data.requestmoney;

import id.dana.data.requestmoney.repository.RequestMoneyEntityData;
import id.dana.data.requestmoney.repository.RequestMoneyEntityDataFactory;
import id.dana.data.requestmoney.repository.RequestMoneyPreferenceEntityDataFactory;
import id.dana.data.requestmoney.repository.model.NameCheckConfigEntity;
import id.dana.data.requestmoney.repository.model.NameCheckConfigEntityKt;
import id.dana.data.requestmoney.repository.source.local.PreferenceRequestMoneyEntityData;
import id.dana.domain.requestmoney.RequestMoneyRepository;
import id.dana.domain.requestmoney.model.NameCheckConfig;
import io.reactivex.Observable;
import io.reactivex.functions.Function;
import java.util.List;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0019\b\u0007\u0012\u0006\u0010$\u001a\u00020#\u0012\u0006\u0010'\u001a\u00020&¢\u0006\u0004\b,\u0010-J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\b\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\b\u0010\u0004J\u0015\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u001b\u0010\u000f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r0\tH\u0016¢\u0006\u0004\b\u000f\u0010\fJ\u0017\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0015\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u0017\u0010\u0017\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0017\u0010\u0013R\u001b\u0010\u001d\u001a\u00020\u00188CX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u001b\u0010\"\u001a\u00020\u001e8CX\u0083\u0084\u0002¢\u0006\f\n\u0004\b\u001f\u0010\u001a\u001a\u0004\b \u0010!R\u0014\u0010$\u001a\u00020#8\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b$\u0010%R\u0014\u0010'\u001a\u00020&8\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b'\u0010(R\u001b\u0010+\u001a\u00020\u00188CX\u0083\u0084\u0002¢\u0006\f\n\u0004\b)\u0010\u001a\u001a\u0004\b*\u0010\u001c"}, d2 = {"Lid/dana/data/requestmoney/RequestMoneyEntityRepository;", "Lid/dana/domain/requestmoney/RequestMoneyRepository;", "", "getLastNameCheckTimestamp", "()J", "", "getNameCheckCount", "()I", "getNameCheckExpiredTime", "Lio/reactivex/Observable;", "Lid/dana/domain/requestmoney/model/NameCheckConfig;", "getNamecheckConfig", "()Lio/reactivex/Observable;", "", "", "getTopFeaturedBanks", "timestamp", "", "setLastNameCheckTimestamp", "(J)Z", "count", "setNameCheckCount", "(I)Z", "setNameCheckExpiredTime", "Lid/dana/data/requestmoney/repository/RequestMoneyEntityData;", "localRequestMoneyEntityData$delegate", "Lkotlin/Lazy;", "getLocalRequestMoneyEntityData", "()Lid/dana/data/requestmoney/repository/RequestMoneyEntityData;", "localRequestMoneyEntityData", "Lid/dana/data/requestmoney/repository/source/local/PreferenceRequestMoneyEntityData;", "preferenceRequestMoneyEntityData$delegate", "getPreferenceRequestMoneyEntityData", "()Lid/dana/data/requestmoney/repository/source/local/PreferenceRequestMoneyEntityData;", "preferenceRequestMoneyEntityData", "Lid/dana/data/requestmoney/repository/RequestMoneyEntityDataFactory;", "requestMoneyEntityDataFactory", "Lid/dana/data/requestmoney/repository/RequestMoneyEntityDataFactory;", "Lid/dana/data/requestmoney/repository/RequestMoneyPreferenceEntityDataFactory;", "requestMoneyPreferenceEntityDataFactory", "Lid/dana/data/requestmoney/repository/RequestMoneyPreferenceEntityDataFactory;", "splitRequestMoneyEntityData$delegate", "getSplitRequestMoneyEntityData", "splitRequestMoneyEntityData", "<init>", "(Lid/dana/data/requestmoney/repository/RequestMoneyEntityDataFactory;Lid/dana/data/requestmoney/repository/RequestMoneyPreferenceEntityDataFactory;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class RequestMoneyEntityRepository implements RequestMoneyRepository {

    /* renamed from: localRequestMoneyEntityData$delegate  reason: from kotlin metadata */
    private final Lazy localRequestMoneyEntityData;

    /* renamed from: preferenceRequestMoneyEntityData$delegate  reason: from kotlin metadata */
    private final Lazy preferenceRequestMoneyEntityData;
    private final RequestMoneyEntityDataFactory requestMoneyEntityDataFactory;
    private final RequestMoneyPreferenceEntityDataFactory requestMoneyPreferenceEntityDataFactory;

    /* renamed from: splitRequestMoneyEntityData$delegate  reason: from kotlin metadata */
    private final Lazy splitRequestMoneyEntityData;

    @Inject
    public RequestMoneyEntityRepository(RequestMoneyEntityDataFactory requestMoneyEntityDataFactory, RequestMoneyPreferenceEntityDataFactory requestMoneyPreferenceEntityDataFactory) {
        Intrinsics.checkNotNullParameter(requestMoneyEntityDataFactory, "");
        Intrinsics.checkNotNullParameter(requestMoneyPreferenceEntityDataFactory, "");
        this.requestMoneyEntityDataFactory = requestMoneyEntityDataFactory;
        this.requestMoneyPreferenceEntityDataFactory = requestMoneyPreferenceEntityDataFactory;
        this.localRequestMoneyEntityData = LazyKt.lazy(new Function0<RequestMoneyEntityData>() { // from class: id.dana.data.requestmoney.RequestMoneyEntityRepository$localRequestMoneyEntityData$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final RequestMoneyEntityData invoke() {
                RequestMoneyEntityDataFactory requestMoneyEntityDataFactory2;
                requestMoneyEntityDataFactory2 = RequestMoneyEntityRepository.this.requestMoneyEntityDataFactory;
                return requestMoneyEntityDataFactory2.createData2("local");
            }
        });
        this.preferenceRequestMoneyEntityData = LazyKt.lazy(new Function0<PreferenceRequestMoneyEntityData>() { // from class: id.dana.data.requestmoney.RequestMoneyEntityRepository$preferenceRequestMoneyEntityData$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final PreferenceRequestMoneyEntityData invoke() {
                RequestMoneyPreferenceEntityDataFactory requestMoneyPreferenceEntityDataFactory2;
                requestMoneyPreferenceEntityDataFactory2 = RequestMoneyEntityRepository.this.requestMoneyPreferenceEntityDataFactory;
                return requestMoneyPreferenceEntityDataFactory2.createData2("local");
            }
        });
        this.splitRequestMoneyEntityData = LazyKt.lazy(new Function0<RequestMoneyEntityData>() { // from class: id.dana.data.requestmoney.RequestMoneyEntityRepository$splitRequestMoneyEntityData$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final RequestMoneyEntityData invoke() {
                RequestMoneyEntityDataFactory requestMoneyEntityDataFactory2;
                requestMoneyEntityDataFactory2 = RequestMoneyEntityRepository.this.requestMoneyEntityDataFactory;
                return requestMoneyEntityDataFactory2.createData2("split");
            }
        });
    }

    @JvmName(name = "getLocalRequestMoneyEntityData")
    private final RequestMoneyEntityData getLocalRequestMoneyEntityData() {
        return (RequestMoneyEntityData) this.localRequestMoneyEntityData.getValue();
    }

    @JvmName(name = "getPreferenceRequestMoneyEntityData")
    private final PreferenceRequestMoneyEntityData getPreferenceRequestMoneyEntityData() {
        return (PreferenceRequestMoneyEntityData) this.preferenceRequestMoneyEntityData.getValue();
    }

    @JvmName(name = "getSplitRequestMoneyEntityData")
    private final RequestMoneyEntityData getSplitRequestMoneyEntityData() {
        return (RequestMoneyEntityData) this.splitRequestMoneyEntityData.getValue();
    }

    @Override // id.dana.domain.requestmoney.RequestMoneyRepository
    public final Observable<List<String>> getTopFeaturedBanks() {
        Observable<List<String>> onErrorResumeNext = getSplitRequestMoneyEntityData().getTopFeatureBanks().onErrorResumeNext(getLocalRequestMoneyEntityData().getTopFeatureBanks());
        Intrinsics.checkNotNullExpressionValue(onErrorResumeNext, "");
        return onErrorResumeNext;
    }

    @Override // id.dana.domain.requestmoney.RequestMoneyRepository
    public final Observable<NameCheckConfig> getNamecheckConfig() {
        Observable map = getSplitRequestMoneyEntityData().getNameCheckConfig().onErrorResumeNext(getLocalRequestMoneyEntityData().getNameCheckConfig()).map(new Function() { // from class: id.dana.data.requestmoney.RequestMoneyEntityRepository$$ExternalSyntheticLambda0
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                NameCheckConfig m1835getNamecheckConfig$lambda0;
                m1835getNamecheckConfig$lambda0 = RequestMoneyEntityRepository.m1835getNamecheckConfig$lambda0((NameCheckConfigEntity) obj);
                return m1835getNamecheckConfig$lambda0;
            }
        });
        Intrinsics.checkNotNullExpressionValue(map, "");
        return map;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: getNamecheckConfig$lambda-0  reason: not valid java name */
    public static final NameCheckConfig m1835getNamecheckConfig$lambda0(NameCheckConfigEntity nameCheckConfigEntity) {
        Intrinsics.checkNotNullParameter(nameCheckConfigEntity, "");
        return NameCheckConfigEntityKt.toNameCheckConfig(nameCheckConfigEntity);
    }

    @Override // id.dana.domain.requestmoney.RequestMoneyRepository
    public final int getNameCheckCount() {
        return getPreferenceRequestMoneyEntityData().getNameCheckCount();
    }

    @Override // id.dana.domain.requestmoney.RequestMoneyRepository
    public final boolean setNameCheckCount(int count) {
        return getPreferenceRequestMoneyEntityData().setNameCheckCount(count);
    }

    @Override // id.dana.domain.requestmoney.RequestMoneyRepository
    public final long getNameCheckExpiredTime() {
        return getPreferenceRequestMoneyEntityData().getNameCheckExpiredTime();
    }

    @Override // id.dana.domain.requestmoney.RequestMoneyRepository
    public final boolean setNameCheckExpiredTime(long timestamp) {
        return getPreferenceRequestMoneyEntityData().setNameCheckExpiredTime(timestamp);
    }

    @Override // id.dana.domain.requestmoney.RequestMoneyRepository
    public final boolean setLastNameCheckTimestamp(long timestamp) {
        return getPreferenceRequestMoneyEntityData().setLastNameCheckTimestamp(timestamp);
    }

    @Override // id.dana.domain.requestmoney.RequestMoneyRepository
    public final long getLastNameCheckTimestamp() {
        return getPreferenceRequestMoneyEntityData().getLastNameCheckTimestamp();
    }
}
