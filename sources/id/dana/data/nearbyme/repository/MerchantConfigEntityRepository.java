package id.dana.data.nearbyme.repository;

import id.dana.data.nearbyme.MerchantConfigEntityData;
import id.dana.data.nearbyme.model.MerchantConfigEntity;
import id.dana.data.nearbyme.repository.source.NearbyMeConfigDataFactory;
import id.dana.domain.nearbyme.MerchantConfigRepository;
import id.dana.domain.nearbyme.model.MerchantDetailConfig;
import java.util.Arrays;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Singleton
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u0000 \u001f2\u00020\u0001:\u0001\u001fB\u0011\b\u0007\u0012\u0006\u0010\u0018\u001a\u00020\u0017¢\u0006\u0004\b\u001d\u0010\u001eJ\u001b\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0096@ø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\u0006J!\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u0006\u0010\b\u001a\u00020\u0007H\u0082@ø\u0001\u0000¢\u0006\u0004\b\u000b\u0010\fJ\u0013\u0010\u000e\u001a\u00020\rH\u0096@ø\u0001\u0000¢\u0006\u0004\b\u000e\u0010\u000fJ!\u0010\u0010\u001a\u00020\u0004*\b\u0012\u0004\u0012\u00020\n0\t2\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0010\u0010\u0011R\u001b\u0010\u0016\u001a\u00020\u00078CX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0018\u001a\u00020\u00178\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u001b\u0010\u001c\u001a\u00020\u00078CX\u0083\u0084\u0002¢\u0006\f\n\u0004\b\u001a\u0010\u0013\u001a\u0004\b\u001b\u0010\u0015\u0082\u0002\u0004\n\u0002\b\u0019"}, d2 = {"Lid/dana/data/nearbyme/repository/MerchantConfigEntityRepository;", "Lid/dana/domain/nearbyme/MerchantConfigRepository;", "", "fromNearbyRevamp", "Lid/dana/domain/nearbyme/model/MerchantDetailConfig;", "getMerchantDetailActionConfig", "(ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lid/dana/data/nearbyme/MerchantConfigEntityData;", "configEntityData", "", "Lid/dana/data/nearbyme/model/MerchantConfigEntity;", "getMerchantDetailConfig", "(Lid/dana/data/nearbyme/MerchantConfigEntityData;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lid/dana/domain/nearbyme/model/MerchantDetailPromoConfig;", "getMerchantDetailPromoConfig", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "toMerchantDetailConfig", "(Ljava/util/List;Z)Lid/dana/domain/nearbyme/model/MerchantDetailConfig;", "defaultMerchantConfigEntityData$delegate", "Lkotlin/Lazy;", "getDefaultMerchantConfigEntityData", "()Lid/dana/data/nearbyme/MerchantConfigEntityData;", "defaultMerchantConfigEntityData", "Lid/dana/data/nearbyme/repository/source/NearbyMeConfigDataFactory;", "nearbyMeConfigDataFactory", "Lid/dana/data/nearbyme/repository/source/NearbyMeConfigDataFactory;", "splitMerchantConfigEntityData$delegate", "getSplitMerchantConfigEntityData", "splitMerchantConfigEntityData", "<init>", "(Lid/dana/data/nearbyme/repository/source/NearbyMeConfigDataFactory;)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class MerchantConfigEntityRepository implements MerchantConfigRepository {

    /* renamed from: defaultMerchantConfigEntityData$delegate  reason: from kotlin metadata */
    private final Lazy defaultMerchantConfigEntityData;
    private final NearbyMeConfigDataFactory nearbyMeConfigDataFactory;

    /* renamed from: splitMerchantConfigEntityData$delegate  reason: from kotlin metadata */
    private final Lazy splitMerchantConfigEntityData;

    /* renamed from: Companion  reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final List<String> ACTION_KEYS = CollectionsKt.listOf((Object[]) new String[]{"nearby_detail_reserve", "nearby_detail_pickup", "nearby_detail_call", "nearby_detail_direction", "nearby_detail_topup", "nearby_detail_home_shopping", "nearby_detail_share"});

    @Inject
    public MerchantConfigEntityRepository(NearbyMeConfigDataFactory nearbyMeConfigDataFactory) {
        Intrinsics.checkNotNullParameter(nearbyMeConfigDataFactory, "");
        this.nearbyMeConfigDataFactory = nearbyMeConfigDataFactory;
        this.splitMerchantConfigEntityData = LazyKt.lazy(new Function0<MerchantConfigEntityData>() { // from class: id.dana.data.nearbyme.repository.MerchantConfigEntityRepository$splitMerchantConfigEntityData$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final MerchantConfigEntityData invoke() {
                NearbyMeConfigDataFactory nearbyMeConfigDataFactory2;
                nearbyMeConfigDataFactory2 = MerchantConfigEntityRepository.this.nearbyMeConfigDataFactory;
                return nearbyMeConfigDataFactory2.createData2("split");
            }
        });
        this.defaultMerchantConfigEntityData = LazyKt.lazy(new Function0<MerchantConfigEntityData>() { // from class: id.dana.data.nearbyme.repository.MerchantConfigEntityRepository$defaultMerchantConfigEntityData$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final MerchantConfigEntityData invoke() {
                NearbyMeConfigDataFactory nearbyMeConfigDataFactory2;
                nearbyMeConfigDataFactory2 = MerchantConfigEntityRepository.this.nearbyMeConfigDataFactory;
                return nearbyMeConfigDataFactory2.createData2("local");
            }
        });
    }

    @JvmName(name = "getSplitMerchantConfigEntityData")
    private final MerchantConfigEntityData getSplitMerchantConfigEntityData() {
        return (MerchantConfigEntityData) this.splitMerchantConfigEntityData.getValue();
    }

    @JvmName(name = "getDefaultMerchantConfigEntityData")
    private final MerchantConfigEntityData getDefaultMerchantConfigEntityData() {
        return (MerchantConfigEntityData) this.defaultMerchantConfigEntityData.getValue();
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x004f  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0092 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0093  */
    @Override // id.dana.domain.nearbyme.MerchantConfigRepository
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object getMerchantDetailActionConfig(boolean r8, kotlin.coroutines.Continuation<? super id.dana.domain.nearbyme.model.MerchantDetailConfig> r9) {
        /*
            r7 = this;
            boolean r0 = r9 instanceof id.dana.data.nearbyme.repository.MerchantConfigEntityRepository$getMerchantDetailActionConfig$1
            if (r0 == 0) goto L14
            r0 = r9
            id.dana.data.nearbyme.repository.MerchantConfigEntityRepository$getMerchantDetailActionConfig$1 r0 = (id.dana.data.nearbyme.repository.MerchantConfigEntityRepository$getMerchantDetailActionConfig$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r9 = r0.label
            int r9 = r9 + r2
            r0.label = r9
            goto L19
        L14:
            id.dana.data.nearbyme.repository.MerchantConfigEntityRepository$getMerchantDetailActionConfig$1 r0 = new id.dana.data.nearbyme.repository.MerchantConfigEntityRepository$getMerchantDetailActionConfig$1
            r0.<init>(r7, r9)
        L19:
            java.lang.Object r9 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L4f
            if (r2 == r4) goto L3b
            if (r2 != r3) goto L33
            boolean r8 = r0.Z$0
            java.lang.Object r0 = r0.L$0
            id.dana.data.nearbyme.repository.MerchantConfigEntityRepository r0 = (id.dana.data.nearbyme.repository.MerchantConfigEntityRepository) r0
            kotlin.ResultKt.throwOnFailure(r9)
            goto L94
        L33:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L3b:
            boolean r8 = r0.Z$0
            java.lang.Object r2 = r0.L$2
            id.dana.data.nearbyme.repository.MerchantConfigEntityRepository r2 = (id.dana.data.nearbyme.repository.MerchantConfigEntityRepository) r2
            java.lang.Object r4 = r0.L$1
            id.dana.data.nearbyme.repository.MerchantConfigEntityRepository r4 = (id.dana.data.nearbyme.repository.MerchantConfigEntityRepository) r4
            java.lang.Object r5 = r0.L$0
            id.dana.data.nearbyme.repository.MerchantConfigEntityRepository r5 = (id.dana.data.nearbyme.repository.MerchantConfigEntityRepository) r5
            kotlin.ResultKt.throwOnFailure(r9)     // Catch: java.lang.Throwable -> L4d
            goto L6a
        L4d:
            r9 = move-exception
            goto L70
        L4f:
            kotlin.ResultKt.throwOnFailure(r9)
            id.dana.data.nearbyme.MerchantConfigEntityData r9 = r7.getSplitMerchantConfigEntityData()     // Catch: java.lang.Throwable -> L6d
            r0.L$0 = r7     // Catch: java.lang.Throwable -> L6d
            r0.L$1 = r7     // Catch: java.lang.Throwable -> L6d
            r0.L$2 = r7     // Catch: java.lang.Throwable -> L6d
            r0.Z$0 = r8     // Catch: java.lang.Throwable -> L6d
            r0.label = r4     // Catch: java.lang.Throwable -> L6d
            java.lang.Object r9 = r7.getMerchantDetailConfig(r9, r0)     // Catch: java.lang.Throwable -> L6d
            if (r9 != r1) goto L67
            return r1
        L67:
            r2 = r7
            r4 = r2
            r5 = r4
        L6a:
            java.util.List r9 = (java.util.List) r9     // Catch: java.lang.Throwable -> L4d
            goto L97
        L6d:
            r9 = move-exception
            r4 = r7
            r5 = r4
        L70:
            java.lang.Class r2 = r5.getClass()
            java.lang.String r2 = r2.getName()
            java.lang.String r6 = "NearbyMeMerchantDetail"
            id.dana.utils.foundation.logger.log.DanaLog.BuiltInFictitiousFunctionClassFactory(r6, r2, r9)
            id.dana.data.nearbyme.MerchantConfigEntityData r9 = r5.getDefaultMerchantConfigEntityData()
            r0.L$0 = r4
            r2 = 0
            r0.L$1 = r2
            r0.L$2 = r2
            r0.Z$0 = r8
            r0.label = r3
            java.lang.Object r9 = r5.getMerchantDetailConfig(r9, r0)
            if (r9 != r1) goto L93
            return r1
        L93:
            r0 = r4
        L94:
            java.util.List r9 = (java.util.List) r9
            r2 = r0
        L97:
            id.dana.domain.nearbyme.model.MerchantDetailConfig r8 = r2.toMerchantDetailConfig(r9, r8)
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.data.nearbyme.repository.MerchantConfigEntityRepository.getMerchantDetailActionConfig(boolean, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0032  */
    @Override // id.dana.domain.nearbyme.MerchantConfigRepository
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object getMerchantDetailPromoConfig(kotlin.coroutines.Continuation<? super id.dana.domain.nearbyme.model.MerchantDetailPromoConfig> r5) {
        /*
            r4 = this;
            boolean r0 = r5 instanceof id.dana.data.nearbyme.repository.MerchantConfigEntityRepository$getMerchantDetailPromoConfig$1
            if (r0 == 0) goto L14
            r0 = r5
            id.dana.data.nearbyme.repository.MerchantConfigEntityRepository$getMerchantDetailPromoConfig$1 r0 = (id.dana.data.nearbyme.repository.MerchantConfigEntityRepository$getMerchantDetailPromoConfig$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r5 = r0.label
            int r5 = r5 + r2
            r0.label = r5
            goto L19
        L14:
            id.dana.data.nearbyme.repository.MerchantConfigEntityRepository$getMerchantDetailPromoConfig$1 r0 = new id.dana.data.nearbyme.repository.MerchantConfigEntityRepository$getMerchantDetailPromoConfig$1
            r0.<init>(r4, r5)
        L19:
            java.lang.Object r5 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L32
            if (r2 != r3) goto L2a
            kotlin.ResultKt.throwOnFailure(r5)
            goto L42
        L2a:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r0)
            throw r5
        L32:
            kotlin.ResultKt.throwOnFailure(r5)
            id.dana.data.nearbyme.MerchantConfigEntityData r5 = r4.getSplitMerchantConfigEntityData()
            r0.label = r3
            java.lang.Object r5 = r5.getMerchantDetailPromoConfigEntity(r0)
            if (r5 != r1) goto L42
            return r1
        L42:
            id.dana.data.nearbyme.model.MerchantDetailPromoConfigEntity r5 = (id.dana.data.nearbyme.model.MerchantDetailPromoConfigEntity) r5
            id.dana.domain.nearbyme.model.MerchantDetailPromoConfig r5 = id.dana.data.nearbyme.mapper.MerchantDetailPromoConfigMapperKt.toMerchantDetailPromoConfig(r5)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.data.nearbyme.repository.MerchantConfigEntityRepository.getMerchantDetailPromoConfig(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object getMerchantDetailConfig(MerchantConfigEntityData merchantConfigEntityData, Continuation<? super List<MerchantConfigEntity>> continuation) {
        Object[] array = ACTION_KEYS.toArray(new String[0]);
        if (array != null) {
            String[] strArr = (String[]) array;
            return merchantConfigEntityData.getMerchantDetailConfig((String[]) Arrays.copyOf(strArr, strArr.length), false, continuation);
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
    }

    private final MerchantDetailConfig toMerchantDetailConfig(List<MerchantConfigEntity> list, boolean z) {
        if (list.isEmpty()) {
            return MerchantDetailConfig.INSTANCE.getDefaultValue(z);
        }
        return new MerchantDetailConfig(list.get(0).getEnable(), list.get(1).getEnable(), list.get(4).getEnable(), list.get(2).getEnable(), list.get(3).getEnable(), list.get(5).getEnable(), list.get(6).getEnable());
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\b\u0010\tR \u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007"}, d2 = {"Lid/dana/data/nearbyme/repository/MerchantConfigEntityRepository$Companion;", "", "", "", "ACTION_KEYS", "Ljava/util/List;", "getACTION_KEYS", "()Ljava/util/List;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmName(name = "getACTION_KEYS")
        public final List<String> getACTION_KEYS() {
            return MerchantConfigEntityRepository.ACTION_KEYS;
        }
    }
}
