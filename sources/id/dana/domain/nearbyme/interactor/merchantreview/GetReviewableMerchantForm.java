package id.dana.domain.nearbyme.interactor.merchantreview;

import id.dana.contract.deeplink.path.FeatureParams;
import id.dana.domain.featureconfig.FeatureConfigRepository;
import id.dana.domain.featureconfig.model.UgcConfig;
import id.dana.domain.nearbyme.MerchantInfoRepository;
import id.dana.domain.nearbyme.MerchantReviewFormRepository;
import id.dana.domain.nearbyme.interactor.FeatureDisableException;
import id.dana.domain.nearbyme.interactor.MerchantReviewFormStillInCoolDown;
import id.dana.domain.nearbyme.model.MerchantConsult;
import id.dana.domain.nearbyme.model.Shop;
import id.dana.domain.social.Result;
import id.dana.domain.social.core.SingleUseCase;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 *2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0002*+B!\b\u0007\u0012\u0006\u0010#\u001a\u00020\"\u0012\u0006\u0010 \u001a\u00020\u001f\u0012\u0006\u0010\u001d\u001a\u00020\u001c¢\u0006\u0004\b(\u0010)J!\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u00052\u0006\u0010\u0004\u001a\u00020\u0002H\u0096@ø\u0001\u0000¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\u000b\u0010\fJ#\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\nH\u0082@ø\u0001\u0000¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0012\u001a\u00020\nH\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0014\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\rH\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u0017\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u000f\u001a\u00020\nH\u0002¢\u0006\u0004\b\u0017\u0010\u0018J\u001d\u0010\u001a\u001a\u0004\u0018\u00010\u0019*\u00020\u00032\u0006\u0010\u000f\u001a\u00020\nH\u0002¢\u0006\u0004\b\u001a\u0010\u001bR\u0014\u0010\u001d\u001a\u00020\u001c8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0014\u0010 \u001a\u00020\u001f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b \u0010!R\u0014\u0010#\u001a\u00020\"8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b#\u0010$R\u0018\u0010&\u001a\u0004\u0018\u00010%8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b&\u0010'\u0082\u0002\u0004\n\u0002\b\u0019"}, d2 = {"Lid/dana/domain/nearbyme/interactor/merchantreview/GetReviewableMerchantForm;", "Lid/dana/domain/social/core/SingleUseCase;", "Lid/dana/domain/nearbyme/interactor/merchantreview/GetReviewableMerchantForm$Param;", "Lid/dana/domain/nearbyme/model/MerchantConsult;", "params", "Lid/dana/domain/social/Result;", "buildUseCase", "(Lid/dana/domain/nearbyme/interactor/merchantreview/GetReviewableMerchantForm$Param;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "it", "", "firstTimeShown", "(J)Z", "", FeatureParams.SHOP_ID, "ignoreFormDismissCheck", "getReviewableMerchantConsult", "(Ljava/lang/String;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "isEligibleToConsultUgc", "()Z", "merchantNotDismissed", "(Ljava/lang/String;)Z", "", "preconditionCheck", "(Z)V", "Lid/dana/domain/nearbyme/model/Shop;", "getReviewableMerchant", "(Lid/dana/domain/nearbyme/model/MerchantConsult;Z)Lid/dana/domain/nearbyme/model/Shop;", "Lid/dana/domain/featureconfig/FeatureConfigRepository;", "featureConfigRepository", "Lid/dana/domain/featureconfig/FeatureConfigRepository;", "Lid/dana/domain/nearbyme/MerchantInfoRepository;", "merchantInfoRepository", "Lid/dana/domain/nearbyme/MerchantInfoRepository;", "Lid/dana/domain/nearbyme/MerchantReviewFormRepository;", "merchantReviewFormRepository", "Lid/dana/domain/nearbyme/MerchantReviewFormRepository;", "Lid/dana/domain/featureconfig/model/UgcConfig;", "ugcConfig", "Lid/dana/domain/featureconfig/model/UgcConfig;", "<init>", "(Lid/dana/domain/nearbyme/MerchantReviewFormRepository;Lid/dana/domain/nearbyme/MerchantInfoRepository;Lid/dana/domain/featureconfig/FeatureConfigRepository;)V", "Companion", "Param"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class GetReviewableMerchantForm extends SingleUseCase<Param, MerchantConsult> {
    public static final String REVIEW_MERCHANT_FEATURE_NAME = "reviewmerchant";
    public static final int SHOP_INFO_PAGE_SIZE = 30;
    private final FeatureConfigRepository featureConfigRepository;
    private final MerchantInfoRepository merchantInfoRepository;
    private final MerchantReviewFormRepository merchantReviewFormRepository;
    private UgcConfig ugcConfig;

    private final boolean firstTimeShown(long it) {
        return it == 0;
    }

    @Override // id.dana.domain.social.core.BaseUseCase
    public final /* bridge */ /* synthetic */ Object buildUseCase(Object obj, Continuation continuation) {
        return buildUseCase((Param) obj, (Continuation<? super Result<MerchantConsult>>) continuation);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /* JADX WARN: Type inference failed for: r0v1, types: [kotlin.jvm.internal.DefaultConstructorMarker, kotlinx.coroutines.CoroutineDispatcher] */
    @javax.inject.Inject
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public GetReviewableMerchantForm(id.dana.domain.nearbyme.MerchantReviewFormRepository r3, id.dana.domain.nearbyme.MerchantInfoRepository r4, id.dana.domain.featureconfig.FeatureConfigRepository r5) {
        /*
            r2 = this;
            java.lang.String r0 = ""
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
            r0 = 0
            r1 = 3
            r2.<init>(r0, r0, r1, r0)
            r2.merchantReviewFormRepository = r3
            r2.merchantInfoRepository = r4
            r2.featureConfigRepository = r5
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.domain.nearbyme.interactor.merchantreview.GetReviewableMerchantForm.<init>(id.dana.domain.nearbyme.MerchantReviewFormRepository, id.dana.domain.nearbyme.MerchantInfoRepository, id.dana.domain.featureconfig.FeatureConfigRepository):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0032  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object buildUseCase(id.dana.domain.nearbyme.interactor.merchantreview.GetReviewableMerchantForm.Param r5, kotlin.coroutines.Continuation<? super id.dana.domain.social.Result<id.dana.domain.nearbyme.model.MerchantConsult>> r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof id.dana.domain.nearbyme.interactor.merchantreview.GetReviewableMerchantForm$buildUseCase$1
            if (r0 == 0) goto L14
            r0 = r6
            id.dana.domain.nearbyme.interactor.merchantreview.GetReviewableMerchantForm$buildUseCase$1 r0 = (id.dana.domain.nearbyme.interactor.merchantreview.GetReviewableMerchantForm$buildUseCase$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r6 = r0.label
            int r6 = r6 + r2
            r0.label = r6
            goto L19
        L14:
            id.dana.domain.nearbyme.interactor.merchantreview.GetReviewableMerchantForm$buildUseCase$1 r0 = new id.dana.domain.nearbyme.interactor.merchantreview.GetReviewableMerchantForm$buildUseCase$1
            r0.<init>(r4, r6)
        L19:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L32
            if (r2 != r3) goto L2a
            kotlin.ResultKt.throwOnFailure(r6)
            goto L4d
        L2a:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L32:
            kotlin.ResultKt.throwOnFailure(r6)
            boolean r6 = r5.getIgnoreFormDismissCheck()
            r4.preconditionCheck(r6)
            java.lang.String r6 = r5.getShopId()
            boolean r5 = r5.getIgnoreFormDismissCheck()
            r0.label = r3
            java.lang.Object r6 = r4.getReviewableMerchantConsult(r6, r5, r0)
            if (r6 != r1) goto L4d
            return r1
        L4d:
            id.dana.domain.social.Result$Success r5 = new id.dana.domain.social.Result$Success
            r5.<init>(r6)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.domain.nearbyme.interactor.merchantreview.GetReviewableMerchantForm.buildUseCase(id.dana.domain.nearbyme.interactor.merchantreview.GetReviewableMerchantForm$Param, kotlin.coroutines.Continuation):java.lang.Object");
    }

    private final void preconditionCheck(boolean ignoreFormDismissCheck) {
        Unit unit;
        if (this.ugcConfig == null) {
            this.ugcConfig = this.featureConfigRepository.getUgcFeatureConfig().blockingFirst();
        }
        UgcConfig ugcConfig = this.ugcConfig;
        if (ugcConfig == null) {
            unit = null;
        } else if (!ugcConfig.getReviewEnable()) {
            throw new FeatureDisableException();
        } else {
            if (isEligibleToConsultUgc() || ignoreFormDismissCheck) {
                unit = Unit.INSTANCE;
            } else {
                throw new MerchantReviewFormStillInCoolDown();
            }
        }
        if (unit == null) {
            throw new FeatureDisableException();
        }
    }

    private final boolean merchantNotDismissed(String shopId) {
        return !this.merchantReviewFormRepository.getDismissedMerchantReview(shopId);
    }

    private final boolean isEligibleToConsultUgc() {
        long lastShownMerchantReviewShown = this.merchantReviewFormRepository.getLastShownMerchantReviewShown();
        if (!firstTimeShown(lastShownMerchantReviewShown)) {
            if (System.currentTimeMillis() - lastShownMerchantReviewShown <= (this.ugcConfig != null ? r4.getUgcInterval() : UgcConfig.DEFAULT_UGC_INTERVAL) * 1000) {
                return false;
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x004a  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0064  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0089  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x008d  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x009d  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:21:0x007d -> B:12:0x003e). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object getReviewableMerchantConsult(java.lang.String r10, boolean r11, kotlin.coroutines.Continuation<? super id.dana.domain.nearbyme.model.MerchantConsult> r12) {
        /*
            r9 = this;
            boolean r0 = r12 instanceof id.dana.domain.nearbyme.interactor.merchantreview.GetReviewableMerchantForm$getReviewableMerchantConsult$1
            if (r0 == 0) goto L14
            r0 = r12
            id.dana.domain.nearbyme.interactor.merchantreview.GetReviewableMerchantForm$getReviewableMerchantConsult$1 r0 = (id.dana.domain.nearbyme.interactor.merchantreview.GetReviewableMerchantForm$getReviewableMerchantConsult$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r12 = r0.label
            int r12 = r12 + r2
            r0.label = r12
            goto L19
        L14:
            id.dana.domain.nearbyme.interactor.merchantreview.GetReviewableMerchantForm$getReviewableMerchantConsult$1 r0 = new id.dana.domain.nearbyme.interactor.merchantreview.GetReviewableMerchantForm$getReviewableMerchantConsult$1
            r0.<init>(r9, r12)
        L19:
            java.lang.Object r12 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L4a
            if (r2 != r3) goto L42
            boolean r10 = r0.Z$0
            java.lang.Object r11 = r0.L$3
            kotlin.jvm.internal.Ref$IntRef r11 = (kotlin.jvm.internal.Ref.IntRef) r11
            java.lang.Object r2 = r0.L$2
            kotlin.jvm.internal.Ref$BooleanRef r2 = (kotlin.jvm.internal.Ref.BooleanRef) r2
            java.lang.Object r4 = r0.L$1
            java.lang.String r4 = (java.lang.String) r4
            java.lang.Object r5 = r0.L$0
            id.dana.domain.nearbyme.interactor.merchantreview.GetReviewableMerchantForm r5 = (id.dana.domain.nearbyme.interactor.merchantreview.GetReviewableMerchantForm) r5
            kotlin.ResultKt.throwOnFailure(r12)
            r8 = r0
            r0 = r10
            r10 = r4
        L3e:
            r4 = r2
            r2 = r1
            r1 = r8
            goto L81
        L42:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r11 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r11)
            throw r10
        L4a:
            kotlin.ResultKt.throwOnFailure(r12)
            kotlin.jvm.internal.Ref$BooleanRef r12 = new kotlin.jvm.internal.Ref$BooleanRef
            r12.<init>()
            r12.element = r3
            kotlin.jvm.internal.Ref$IntRef r2 = new kotlin.jvm.internal.Ref$IntRef
            r2.<init>()
            r2.element = r3
            r5 = r9
            r8 = r12
            r12 = r11
            r11 = r2
            r2 = r8
        L60:
            boolean r4 = r2.element
            if (r4 == 0) goto L9d
            id.dana.domain.nearbyme.MerchantInfoRepository r4 = r5.merchantInfoRepository
            int r6 = r11.element
            r0.L$0 = r5
            r0.L$1 = r10
            r0.L$2 = r2
            r0.L$3 = r11
            r0.Z$0 = r12
            r0.label = r3
            r7 = 30
            java.lang.Object r4 = r4.consultMerchantReview(r10, r7, r6, r0)
            if (r4 != r1) goto L7d
            return r1
        L7d:
            r8 = r0
            r0 = r12
            r12 = r4
            goto L3e
        L81:
            id.dana.domain.nearbyme.model.MerchantConsult r12 = (id.dana.domain.nearbyme.model.MerchantConsult) r12
            id.dana.domain.nearbyme.model.Shop r6 = r5.getReviewableMerchant(r12, r0)
            if (r6 == 0) goto L8d
            r12.setReviewableShop(r6)
            return r12
        L8d:
            boolean r12 = r12.getHasMore()
            r4.element = r12
            int r12 = r11.element
            int r12 = r12 + r3
            r11.element = r12
            r12 = r0
            r0 = r1
            r1 = r2
            r2 = r4
            goto L60
        L9d:
            id.dana.domain.nearbyme.interactor.ReviewableMerchantNotFound r10 = new id.dana.domain.nearbyme.interactor.ReviewableMerchantNotFound
            r10.<init>()
            goto La4
        La3:
            throw r10
        La4:
            goto La3
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.domain.nearbyme.interactor.merchantreview.GetReviewableMerchantForm.getReviewableMerchantConsult(java.lang.String, boolean, kotlin.coroutines.Continuation):java.lang.Object");
    }

    private final Shop getReviewableMerchant(MerchantConsult merchantConsult, boolean z) {
        Object obj;
        boolean merchantNotDismissed;
        Iterator<T> it = merchantConsult.getShopInfos().iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            Shop shop = (Shop) obj;
            if (z) {
                merchantNotDismissed = true;
            } else {
                String shopId = shop.getShopId();
                if (shopId == null) {
                    shopId = "";
                }
                merchantNotDismissed = merchantNotDismissed(shopId);
            }
            if (merchantNotDismissed) {
                break;
            }
        }
        return (Shop) obj;
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\u0006\u0010\t\u001a\u00020\u0005¢\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J$\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\b\u001a\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\u0005HÆ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\r\u001a\u00020\u00052\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0010\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0012\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0004R\u0017\u0010\t\u001a\u00020\u00058\u0007¢\u0006\f\n\u0004\b\t\u0010\u0013\u001a\u0004\b\u0014\u0010\u0007R\u001a\u0010\b\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\u0015\u001a\u0004\b\u0016\u0010\u0004"}, d2 = {"Lid/dana/domain/nearbyme/interactor/merchantreview/GetReviewableMerchantForm$Param;", "", "", "component1", "()Ljava/lang/String;", "", "component2", "()Z", FeatureParams.SHOP_ID, "ignoreFormDismissCheck", "copy", "(Ljava/lang/String;Z)Lid/dana/domain/nearbyme/interactor/merchantreview/GetReviewableMerchantForm$Param;", "other", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "Z", "getIgnoreFormDismissCheck", "Ljava/lang/String;", "getShopId", "<init>", "(Ljava/lang/String;Z)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final /* data */ class Param {
        private final boolean ignoreFormDismissCheck;
        private final String shopId;

        public static /* synthetic */ Param copy$default(Param param, String str, boolean z, int i, Object obj) {
            if ((i & 1) != 0) {
                str = param.shopId;
            }
            if ((i & 2) != 0) {
                z = param.ignoreFormDismissCheck;
            }
            return param.copy(str, z);
        }

        /* renamed from: component1  reason: from getter */
        public final String getShopId() {
            return this.shopId;
        }

        /* renamed from: component2  reason: from getter */
        public final boolean getIgnoreFormDismissCheck() {
            return this.ignoreFormDismissCheck;
        }

        public final Param copy(String shopId, boolean ignoreFormDismissCheck) {
            Intrinsics.checkNotNullParameter(shopId, "");
            return new Param(shopId, ignoreFormDismissCheck);
        }

        public final boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (other instanceof Param) {
                Param param = (Param) other;
                return Intrinsics.areEqual(this.shopId, param.shopId) && this.ignoreFormDismissCheck == param.ignoreFormDismissCheck;
            }
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final int hashCode() {
            int hashCode = this.shopId.hashCode();
            boolean z = this.ignoreFormDismissCheck;
            int i = z;
            if (z != 0) {
                i = 1;
            }
            return (hashCode * 31) + i;
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("Param(shopId=");
            sb.append(this.shopId);
            sb.append(", ignoreFormDismissCheck=");
            sb.append(this.ignoreFormDismissCheck);
            sb.append(')');
            return sb.toString();
        }

        public Param(String str, boolean z) {
            Intrinsics.checkNotNullParameter(str, "");
            this.shopId = str;
            this.ignoreFormDismissCheck = z;
        }

        @JvmName(name = "getShopId")
        public final String getShopId() {
            return this.shopId;
        }

        @JvmName(name = "getIgnoreFormDismissCheck")
        public final boolean getIgnoreFormDismissCheck() {
            return this.ignoreFormDismissCheck;
        }
    }
}
