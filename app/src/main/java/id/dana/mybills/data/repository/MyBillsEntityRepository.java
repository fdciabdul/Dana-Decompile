package id.dana.mybills.data.repository;

import id.dana.data.holdlogin.v1.HoldLoginV1EntityRepository;
import id.dana.data.holdlogin.v1.HoldLoginV1Repository;
import id.dana.data.user.source.UserEntityData;
import id.dana.data.user.source.UserInfoEntityDataFactory;
import id.dana.domain.user.CurrencyAmount;
import id.dana.mybills.data.mapper.BizProductOrderMapperKt;
import id.dana.mybills.data.mapper.HighlightTransactionPayRequestMapperKt;
import id.dana.mybills.data.model.request.BizDestinationParam;
import id.dana.mybills.data.model.request.DeleteSubscriptionRequest;
import id.dana.mybills.data.model.request.HighlightSubscriptionRequestKt;
import id.dana.mybills.data.model.request.InquiryBizDestinationRequest;
import id.dana.mybills.data.model.request.MonthlyAmountSubscriptionRequest;
import id.dana.mybills.data.model.request.QuerySubscriptionRequest;
import id.dana.mybills.data.model.request.UniqueValueRequest;
import id.dana.mybills.data.model.request.UpdateSubscriptionRequest;
import id.dana.mybills.data.model.response.ConfigInfoRangeDateResult;
import id.dana.mybills.data.model.response.CreateOrderResult;
import id.dana.mybills.data.model.response.CreateSubscriptionResult;
import id.dana.mybills.data.model.response.CumulateDueDatePaylaterResult;
import id.dana.mybills.data.model.response.DeleteSubscriptionResult;
import id.dana.mybills.data.model.response.GeneralProductResult;
import id.dana.mybills.data.model.response.HighlightSubscriptionResult;
import id.dana.mybills.data.model.response.HighlightTransactionPayResult;
import id.dana.mybills.data.model.response.InquiryBizDestinationResult;
import id.dana.mybills.data.model.response.QuerySubscriptionResult;
import id.dana.mybills.data.model.response.QuickBuyResult;
import id.dana.mybills.data.model.response.UniqueValueResult;
import id.dana.mybills.data.model.response.UpdateSubscriptionResult;
import id.dana.mybills.data.repository.source.MyBillsEntityData;
import id.dana.mybills.di.scope.MyBillsScope;
import id.dana.mybills.domain.MyBillsRepository;
import id.dana.mybills.domain.model.BizProduct;
import id.dana.mybills.domain.model.BizProductDestination;
import id.dana.mybills.domain.model.BizProductOrder;
import id.dana.mybills.domain.model.BizProductOrderRequest;
import id.dana.mybills.domain.model.CheckUniqueValue;
import id.dana.mybills.domain.model.ConfigInfoRangeDate;
import id.dana.mybills.domain.model.CreateSubscription;
import id.dana.mybills.domain.model.CreateSubscriptionRequest;
import id.dana.mybills.domain.model.CreateSubscriptionRequestKt;
import id.dana.mybills.domain.model.CumulateDueDateParamRequest;
import id.dana.mybills.domain.model.CumulateDueDateParamRequestKt;
import id.dana.mybills.domain.model.HighlightTransactionPay;
import id.dana.mybills.domain.model.HighlightTransactionPayRequest;
import id.dana.mybills.domain.model.MobileRechargeProduct;
import id.dana.mybills.domain.model.MyBillsHighlight;
import id.dana.mybills.domain.model.MyBillsHighlightRequestModel;
import id.dana.mybills.domain.model.MyBillsMonthlyAmount;
import id.dana.mybills.domain.model.ProductQueryRequest;
import id.dana.mybills.domain.model.ProductQueryRequestKt;
import java.util.List;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;

@Metadata(d1 = {"\u0000Ð\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B!\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020:\u0012\u0006\u0010\u001e\u001a\u000208\u0012\u0006\u0010#\u001a\u00020?¢\u0006\u0004\bB\u0010CJ\u001d\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u001d\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\u00052\u0006\u0010\u0004\u001a\u00020\tH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u001d\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00052\u0006\u0010\u0004\u001a\u00020\rH\u0016¢\u0006\u0004\b\u0007\u0010\u000fJ\u001d\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00110\u00052\u0006\u0010\u0004\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u000b\u0010\u0012J\u001d\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00140\u00052\u0006\u0010\u0004\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u0007\u0010\u0015J\u001d\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00170\u00052\u0006\u0010\u0004\u001a\u00020\u0016H\u0016¢\u0006\u0004\b\u0007\u0010\u0018J\u001d\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00052\u0006\u0010\u0004\u001a\u00020\u0019H\u0016¢\u0006\u0004\b\u001b\u0010\u001cJ%\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001f0\u00052\u0006\u0010\u0004\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001dH\u0016¢\u0006\u0004\b\u001b\u0010 J\u001d\u0010\"\u001a\b\u0012\u0004\u0012\u00020!0\u00052\u0006\u0010\u0004\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\"\u0010\u0015J-\u0010%\u001a\b\u0012\u0004\u0012\u00020$0\u00052\u0006\u0010\u0004\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001d2\u0006\u0010#\u001a\u00020\u001dH\u0016¢\u0006\u0004\b%\u0010&J\u0015\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020'0\u0005H\u0016¢\u0006\u0004\b\u0007\u0010(J)\u0010\u001b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020*0)0\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u001d0)H\u0016¢\u0006\u0004\b\u001b\u0010+J\u0015\u0010%\u001a\b\u0012\u0004\u0012\u00020,0\u0005H\u0016¢\u0006\u0004\b%\u0010(J\u001d\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020-0\u00052\u0006\u0010\u0004\u001a\u00020\u001dH\u0016¢\u0006\u0004\b\u001b\u0010.J\u001d\u0010\u0007\u001a\b\u0012\u0004\u0012\u0002000\u00052\u0006\u0010\u0004\u001a\u00020/H\u0016¢\u0006\u0004\b\u0007\u00101J\u001d\u0010\u000b\u001a\b\u0012\u0004\u0012\u0002030\u00052\u0006\u0010\u0004\u001a\u000202H\u0016¢\u0006\u0004\b\u000b\u00104J\u001d\u0010\"\u001a\b\u0012\u0004\u0012\u0002060\u00052\u0006\u0010\u0004\u001a\u000205H\u0016¢\u0006\u0004\b\"\u00107R\u0014\u0010\u000b\u001a\u0002088\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b%\u00109R\u0014\u0010%\u001a\u00020:8\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b\"\u0010;R\u0013\u0010\u001b\u001a\u00020<X\u0083\u0080\u0002¢\u0006\u0006\n\u0004\b\u0007\u0010=R\u0017\u0010\u0007\u001a\u0006*\u00020>0>X\u0083\u0080\u0002¢\u0006\u0006\n\u0004\b\u001b\u0010=R\u0013\u0010\"\u001a\u00020<X\u0083\u0080\u0002¢\u0006\u0006\n\u0004\b\u000b\u0010=R\u0014\u0010@\u001a\u00020?8\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b@\u0010A"}, d2 = {"Lid/dana/mybills/data/repository/MyBillsEntityRepository;", "Lid/dana/mybills/domain/MyBillsRepository;", "Lid/dana/data/holdlogin/v1/HoldLoginV1Repository;", "Lid/dana/mybills/data/model/request/UniqueValueRequest;", "p0", "Lkotlinx/coroutines/flow/Flow;", "Lid/dana/mybills/domain/model/CheckUniqueValue;", "MyBillsEntityDataFactory", "(Lid/dana/mybills/data/model/request/UniqueValueRequest;)Lkotlinx/coroutines/flow/Flow;", "Lid/dana/mybills/data/model/request/DeleteSubscriptionRequest;", "Lid/dana/mybills/data/model/response/DeleteSubscriptionResult;", "BuiltInFictitiousFunctionClassFactory", "(Lid/dana/mybills/data/model/request/DeleteSubscriptionRequest;)Lkotlinx/coroutines/flow/Flow;", "Lid/dana/mybills/domain/model/BizProductOrderRequest;", "Lid/dana/mybills/domain/model/BizProductOrder;", "(Lid/dana/mybills/domain/model/BizProductOrderRequest;)Lkotlinx/coroutines/flow/Flow;", "Lid/dana/mybills/domain/model/CumulateDueDateParamRequest;", "Lid/dana/mybills/data/model/response/CumulateDueDatePaylaterResult;", "(Lid/dana/mybills/domain/model/CumulateDueDateParamRequest;)Lkotlinx/coroutines/flow/Flow;", "Lid/dana/mybills/domain/model/ProductQueryRequest;", "Lid/dana/mybills/data/model/response/GeneralProductResult;", "(Lid/dana/mybills/domain/model/ProductQueryRequest;)Lkotlinx/coroutines/flow/Flow;", "Lid/dana/mybills/domain/model/MyBillsHighlightRequestModel;", "Lid/dana/mybills/domain/model/MyBillsHighlight;", "(Lid/dana/mybills/domain/model/MyBillsHighlightRequestModel;)Lkotlinx/coroutines/flow/Flow;", "Lid/dana/mybills/domain/model/HighlightTransactionPayRequest;", "Lid/dana/mybills/domain/model/HighlightTransactionPay;", "PlaceComponentResult", "(Lid/dana/mybills/domain/model/HighlightTransactionPayRequest;)Lkotlinx/coroutines/flow/Flow;", "", "p1", "Lid/dana/mybills/domain/model/BizProductDestination;", "(Ljava/lang/String;Ljava/lang/String;)Lkotlinx/coroutines/flow/Flow;", "Lid/dana/mybills/domain/model/MobileRechargeProduct;", "getAuthRequestContext", "p2", "Lid/dana/mybills/domain/model/MyBillsMonthlyAmount;", "KClassImpl$Data$declaredNonStaticMembers$2", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lkotlinx/coroutines/flow/Flow;", "Lid/dana/mybills/domain/model/ConfigInfoRangeDate;", "()Lkotlinx/coroutines/flow/Flow;", "", "Lid/dana/mybills/domain/model/BizProduct;", "(Ljava/util/List;)Lkotlinx/coroutines/flow/Flow;", "Lid/dana/domain/user/CurrencyAmount;", "", "(Ljava/lang/String;)Lkotlinx/coroutines/flow/Flow;", "Lid/dana/mybills/domain/model/CreateSubscriptionRequest;", "Lid/dana/mybills/domain/model/CreateSubscription;", "(Lid/dana/mybills/domain/model/CreateSubscriptionRequest;)Lkotlinx/coroutines/flow/Flow;", "Lid/dana/mybills/data/model/request/QuerySubscriptionRequest;", "Lid/dana/mybills/data/model/response/QuerySubscriptionResult;", "(Lid/dana/mybills/data/model/request/QuerySubscriptionRequest;)Lkotlinx/coroutines/flow/Flow;", "Lid/dana/mybills/data/model/request/UpdateSubscriptionRequest;", "Lid/dana/mybills/data/model/response/UpdateSubscriptionResult;", "(Lid/dana/mybills/data/model/request/UpdateSubscriptionRequest;)Lkotlinx/coroutines/flow/Flow;", "Lid/dana/data/holdlogin/v1/HoldLoginV1EntityRepository;", "Lid/dana/data/holdlogin/v1/HoldLoginV1EntityRepository;", "Lid/dana/mybills/data/repository/MyBillsEntityDataFactory;", "Lid/dana/mybills/data/repository/MyBillsEntityDataFactory;", "Lid/dana/mybills/data/repository/source/MyBillsEntityData;", "Lkotlin/Lazy;", "Lid/dana/data/user/source/UserEntityData;", "Lid/dana/data/user/source/UserInfoEntityDataFactory;", "NetworkUserEntityData$$ExternalSyntheticLambda0", "Lid/dana/data/user/source/UserInfoEntityDataFactory;", "<init>", "(Lid/dana/mybills/data/repository/MyBillsEntityDataFactory;Lid/dana/data/holdlogin/v1/HoldLoginV1EntityRepository;Lid/dana/data/user/source/UserInfoEntityDataFactory;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
@MyBillsScope
/* loaded from: classes5.dex */
public final class MyBillsEntityRepository implements MyBillsRepository, HoldLoginV1Repository {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    private final Lazy getAuthRequestContext;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    private final HoldLoginV1EntityRepository BuiltInFictitiousFunctionClassFactory;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private final Lazy PlaceComponentResult;
    private final UserInfoEntityDataFactory NetworkUserEntityData$$ExternalSyntheticLambda0;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private final Lazy MyBillsEntityDataFactory;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    private final MyBillsEntityDataFactory KClassImpl$Data$declaredNonStaticMembers$2;

    @Inject
    public MyBillsEntityRepository(MyBillsEntityDataFactory myBillsEntityDataFactory, HoldLoginV1EntityRepository holdLoginV1EntityRepository, UserInfoEntityDataFactory userInfoEntityDataFactory) {
        Intrinsics.checkNotNullParameter(myBillsEntityDataFactory, "");
        Intrinsics.checkNotNullParameter(holdLoginV1EntityRepository, "");
        Intrinsics.checkNotNullParameter(userInfoEntityDataFactory, "");
        this.KClassImpl$Data$declaredNonStaticMembers$2 = myBillsEntityDataFactory;
        this.BuiltInFictitiousFunctionClassFactory = holdLoginV1EntityRepository;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = userInfoEntityDataFactory;
        this.getAuthRequestContext = LazyKt.lazy(new Function0<MyBillsEntityData>() { // from class: id.dana.mybills.data.repository.MyBillsEntityRepository$splitMyBillsEntityData$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final MyBillsEntityData invoke() {
                MyBillsEntityDataFactory myBillsEntityDataFactory2;
                myBillsEntityDataFactory2 = MyBillsEntityRepository.this.KClassImpl$Data$declaredNonStaticMembers$2;
                return myBillsEntityDataFactory2.createData2("split");
            }
        });
        this.PlaceComponentResult = LazyKt.lazy(new Function0<MyBillsEntityData>() { // from class: id.dana.mybills.data.repository.MyBillsEntityRepository$networkMyBillsEntityData$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final MyBillsEntityData invoke() {
                MyBillsEntityDataFactory myBillsEntityDataFactory2;
                myBillsEntityDataFactory2 = MyBillsEntityRepository.this.KClassImpl$Data$declaredNonStaticMembers$2;
                return myBillsEntityDataFactory2.createData2("network");
            }
        });
        this.MyBillsEntityDataFactory = LazyKt.lazy(new Function0<UserEntityData>() { // from class: id.dana.mybills.data.repository.MyBillsEntityRepository$networkUserInfo$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final UserEntityData invoke() {
                UserInfoEntityDataFactory userInfoEntityDataFactory2;
                userInfoEntityDataFactory2 = MyBillsEntityRepository.this.NetworkUserEntityData$$ExternalSyntheticLambda0;
                return userInfoEntityDataFactory2.createData2("network");
            }
        });
    }

    @Override // id.dana.mybills.domain.MyBillsRepository
    public final Flow<MyBillsMonthlyAmount> KClassImpl$Data$declaredNonStaticMembers$2(String p0, String p1, String p2) {
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p1, "");
        Intrinsics.checkNotNullParameter(p2, "");
        final Flow PlaceComponentResult = this.BuiltInFictitiousFunctionClassFactory.PlaceComponentResult(((MyBillsEntityData) this.PlaceComponentResult.getValue()).MyBillsEntityDataFactory(new MonthlyAmountSubscriptionRequest(p1, p0, p2)));
        return new Flow<MyBillsMonthlyAmount>() { // from class: id.dana.mybills.data.repository.MyBillsEntityRepository$getMonthlyAmountSubscription$$inlined$map$1
            @Override // kotlinx.coroutines.flow.Flow
            public final Object collect(FlowCollector<? super MyBillsMonthlyAmount> flowCollector, Continuation continuation) {
                Object collect = Flow.this.collect(new AnonymousClass2(flowCollector), continuation);
                return collect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? collect : Unit.INSTANCE;
            }

            @Metadata(d1 = {"\u0000\f\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0004\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u00012\u0006\u0010\u0002\u001a\u00028\u0000H\u008a@¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"T", "R", "p0", "", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;"}, k = 3, mv = {1, 6, 0}, xi = 48)
            /* renamed from: id.dana.mybills.data.repository.MyBillsEntityRepository$getMonthlyAmountSubscription$$inlined$map$1$2  reason: invalid class name */
            /* loaded from: classes5.dex */
            public static final class AnonymousClass2<T> implements FlowCollector {
                final /* synthetic */ FlowCollector $BuiltInFictitiousFunctionClassFactory;

                @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
                @DebugMetadata(c = "id.dana.mybills.data.repository.MyBillsEntityRepository$getMonthlyAmountSubscription$$inlined$map$1$2", f = "MyBillsEntityRepository.kt", i = {}, l = {224}, m = "emit", n = {}, s = {})
                /* renamed from: id.dana.mybills.data.repository.MyBillsEntityRepository$getMonthlyAmountSubscription$$inlined$map$1$2$1  reason: invalid class name */
                /* loaded from: classes5.dex */
                public static final class AnonymousClass1 extends ContinuationImpl {
                    Object L$0;
                    int label;
                    /* synthetic */ Object result;

                    public AnonymousClass1(Continuation continuation) {
                        super(continuation);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object obj) {
                        this.result = obj;
                        this.label |= Integer.MIN_VALUE;
                        return AnonymousClass2.this.emit(null, this);
                    }
                }

                public AnonymousClass2(FlowCollector flowCollector) {
                    this.$BuiltInFictitiousFunctionClassFactory = flowCollector;
                }

                /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
                /* JADX WARN: Removed duplicated region for block: B:14:0x0032  */
                @Override // kotlinx.coroutines.flow.FlowCollector
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct code enable 'Show inconsistent code' option in preferences
                */
                public final java.lang.Object emit(java.lang.Object r5, kotlin.coroutines.Continuation r6) {
                    /*
                        r4 = this;
                        boolean r0 = r6 instanceof id.dana.mybills.data.repository.MyBillsEntityRepository$getMonthlyAmountSubscription$$inlined$map$1.AnonymousClass2.AnonymousClass1
                        if (r0 == 0) goto L14
                        r0 = r6
                        id.dana.mybills.data.repository.MyBillsEntityRepository$getMonthlyAmountSubscription$$inlined$map$1$2$1 r0 = (id.dana.mybills.data.repository.MyBillsEntityRepository$getMonthlyAmountSubscription$$inlined$map$1.AnonymousClass2.AnonymousClass1) r0
                        int r1 = r0.label
                        r2 = -2147483648(0xffffffff80000000, float:-0.0)
                        r1 = r1 & r2
                        if (r1 == 0) goto L14
                        int r6 = r0.label
                        int r6 = r6 + r2
                        r0.label = r6
                        goto L19
                    L14:
                        id.dana.mybills.data.repository.MyBillsEntityRepository$getMonthlyAmountSubscription$$inlined$map$1$2$1 r0 = new id.dana.mybills.data.repository.MyBillsEntityRepository$getMonthlyAmountSubscription$$inlined$map$1$2$1
                        r0.<init>(r6)
                    L19:
                        java.lang.Object r6 = r0.result
                        java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                        int r2 = r0.label
                        r3 = 1
                        if (r2 == 0) goto L32
                        if (r2 != r3) goto L2a
                        kotlin.ResultKt.throwOnFailure(r6)
                        goto L49
                    L2a:
                        java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                        java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
                        r5.<init>(r6)
                        throw r5
                    L32:
                        kotlin.ResultKt.throwOnFailure(r6)
                        kotlinx.coroutines.flow.FlowCollector r6 = r4.$BuiltInFictitiousFunctionClassFactory
                        r2 = r0
                        kotlin.coroutines.Continuation r2 = (kotlin.coroutines.Continuation) r2
                        id.dana.mybills.data.model.response.MonthlyAmountSubscriptionResult r5 = (id.dana.mybills.data.model.response.MonthlyAmountSubscriptionResult) r5
                        id.dana.mybills.domain.model.MyBillsMonthlyAmount r5 = id.dana.mybills.data.model.response.MonthlyAmountSubscriptionResultKt.toMyBillsMonthlyAmount(r5)
                        r0.label = r3
                        java.lang.Object r5 = r6.emit(r5, r0)
                        if (r5 != r1) goto L49
                        return r1
                    L49:
                        kotlin.Unit r5 = kotlin.Unit.INSTANCE
                        return r5
                    */
                    throw new UnsupportedOperationException("Method not decompiled: id.dana.mybills.data.repository.MyBillsEntityRepository$getMonthlyAmountSubscription$$inlined$map$1.AnonymousClass2.emit(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
                }
            }
        };
    }

    @Override // id.dana.mybills.domain.MyBillsRepository
    public final Flow<MyBillsHighlight> MyBillsEntityDataFactory(MyBillsHighlightRequestModel p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        HoldLoginV1EntityRepository holdLoginV1EntityRepository = this.BuiltInFictitiousFunctionClassFactory;
        final Flow<HighlightSubscriptionResult> BuiltInFictitiousFunctionClassFactory = ((MyBillsEntityData) this.PlaceComponentResult.getValue()).BuiltInFictitiousFunctionClassFactory(HighlightSubscriptionRequestKt.toHighlightSubscriptionRequest(p0));
        return holdLoginV1EntityRepository.PlaceComponentResult(new Flow<MyBillsHighlight>() { // from class: id.dana.mybills.data.repository.MyBillsEntityRepository$getHighlightSubscription$$inlined$map$1
            @Override // kotlinx.coroutines.flow.Flow
            public final Object collect(FlowCollector<? super MyBillsHighlight> flowCollector, Continuation continuation) {
                Object collect = Flow.this.collect(new AnonymousClass2(flowCollector), continuation);
                return collect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? collect : Unit.INSTANCE;
            }

            @Metadata(d1 = {"\u0000\f\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0004\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u00012\u0006\u0010\u0002\u001a\u00028\u0000H\u008a@¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"T", "R", "p0", "", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;"}, k = 3, mv = {1, 6, 0}, xi = 48)
            /* renamed from: id.dana.mybills.data.repository.MyBillsEntityRepository$getHighlightSubscription$$inlined$map$1$2  reason: invalid class name */
            /* loaded from: classes5.dex */
            public static final class AnonymousClass2<T> implements FlowCollector {
                final /* synthetic */ FlowCollector $MyBillsEntityDataFactory;

                @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
                @DebugMetadata(c = "id.dana.mybills.data.repository.MyBillsEntityRepository$getHighlightSubscription$$inlined$map$1$2", f = "MyBillsEntityRepository.kt", i = {}, l = {224}, m = "emit", n = {}, s = {})
                /* renamed from: id.dana.mybills.data.repository.MyBillsEntityRepository$getHighlightSubscription$$inlined$map$1$2$1  reason: invalid class name */
                /* loaded from: classes5.dex */
                public static final class AnonymousClass1 extends ContinuationImpl {
                    Object L$0;
                    int label;
                    /* synthetic */ Object result;

                    public AnonymousClass1(Continuation continuation) {
                        super(continuation);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object obj) {
                        this.result = obj;
                        this.label |= Integer.MIN_VALUE;
                        return AnonymousClass2.this.emit(null, this);
                    }
                }

                public AnonymousClass2(FlowCollector flowCollector) {
                    this.$MyBillsEntityDataFactory = flowCollector;
                }

                /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
                /* JADX WARN: Removed duplicated region for block: B:14:0x0032  */
                @Override // kotlinx.coroutines.flow.FlowCollector
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct code enable 'Show inconsistent code' option in preferences
                */
                public final java.lang.Object emit(java.lang.Object r5, kotlin.coroutines.Continuation r6) {
                    /*
                        r4 = this;
                        boolean r0 = r6 instanceof id.dana.mybills.data.repository.MyBillsEntityRepository$getHighlightSubscription$$inlined$map$1.AnonymousClass2.AnonymousClass1
                        if (r0 == 0) goto L14
                        r0 = r6
                        id.dana.mybills.data.repository.MyBillsEntityRepository$getHighlightSubscription$$inlined$map$1$2$1 r0 = (id.dana.mybills.data.repository.MyBillsEntityRepository$getHighlightSubscription$$inlined$map$1.AnonymousClass2.AnonymousClass1) r0
                        int r1 = r0.label
                        r2 = -2147483648(0xffffffff80000000, float:-0.0)
                        r1 = r1 & r2
                        if (r1 == 0) goto L14
                        int r6 = r0.label
                        int r6 = r6 + r2
                        r0.label = r6
                        goto L19
                    L14:
                        id.dana.mybills.data.repository.MyBillsEntityRepository$getHighlightSubscription$$inlined$map$1$2$1 r0 = new id.dana.mybills.data.repository.MyBillsEntityRepository$getHighlightSubscription$$inlined$map$1$2$1
                        r0.<init>(r6)
                    L19:
                        java.lang.Object r6 = r0.result
                        java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                        int r2 = r0.label
                        r3 = 1
                        if (r2 == 0) goto L32
                        if (r2 != r3) goto L2a
                        kotlin.ResultKt.throwOnFailure(r6)
                        goto L49
                    L2a:
                        java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                        java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
                        r5.<init>(r6)
                        throw r5
                    L32:
                        kotlin.ResultKt.throwOnFailure(r6)
                        kotlinx.coroutines.flow.FlowCollector r6 = r4.$MyBillsEntityDataFactory
                        r2 = r0
                        kotlin.coroutines.Continuation r2 = (kotlin.coroutines.Continuation) r2
                        id.dana.mybills.data.model.response.HighlightSubscriptionResult r5 = (id.dana.mybills.data.model.response.HighlightSubscriptionResult) r5
                        id.dana.mybills.domain.model.MyBillsHighlight r5 = id.dana.mybills.data.model.response.HighlightSubscriptionResultKt.toMyBillsHighlight(r5)
                        r0.label = r3
                        java.lang.Object r5 = r6.emit(r5, r0)
                        if (r5 != r1) goto L49
                        return r1
                    L49:
                        kotlin.Unit r5 = kotlin.Unit.INSTANCE
                        return r5
                    */
                    throw new UnsupportedOperationException("Method not decompiled: id.dana.mybills.data.repository.MyBillsEntityRepository$getHighlightSubscription$$inlined$map$1.AnonymousClass2.emit(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
                }
            }
        });
    }

    @Override // id.dana.mybills.domain.MyBillsRepository
    public final Flow<List<BizProduct>> PlaceComponentResult(List<String> p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        HoldLoginV1EntityRepository holdLoginV1EntityRepository = this.BuiltInFictitiousFunctionClassFactory;
        final Flow<QuickBuyResult> authRequestContext = ((MyBillsEntityData) this.PlaceComponentResult.getValue()).getAuthRequestContext(p0);
        return holdLoginV1EntityRepository.PlaceComponentResult(new Flow<List<? extends BizProduct>>() { // from class: id.dana.mybills.data.repository.MyBillsEntityRepository$getQuickBuySubscription$$inlined$map$1
            @Override // kotlinx.coroutines.flow.Flow
            public final Object collect(FlowCollector<? super List<? extends BizProduct>> flowCollector, Continuation continuation) {
                Object collect = Flow.this.collect(new AnonymousClass2(flowCollector), continuation);
                return collect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? collect : Unit.INSTANCE;
            }

            @Metadata(d1 = {"\u0000\f\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0004\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u00012\u0006\u0010\u0002\u001a\u00028\u0000H\u008a@¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"T", "R", "p0", "", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;"}, k = 3, mv = {1, 6, 0}, xi = 48)
            /* renamed from: id.dana.mybills.data.repository.MyBillsEntityRepository$getQuickBuySubscription$$inlined$map$1$2  reason: invalid class name */
            /* loaded from: classes5.dex */
            public static final class AnonymousClass2<T> implements FlowCollector {
                final /* synthetic */ FlowCollector $getAuthRequestContext;

                @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
                @DebugMetadata(c = "id.dana.mybills.data.repository.MyBillsEntityRepository$getQuickBuySubscription$$inlined$map$1$2", f = "MyBillsEntityRepository.kt", i = {}, l = {224}, m = "emit", n = {}, s = {})
                /* renamed from: id.dana.mybills.data.repository.MyBillsEntityRepository$getQuickBuySubscription$$inlined$map$1$2$1  reason: invalid class name */
                /* loaded from: classes5.dex */
                public static final class AnonymousClass1 extends ContinuationImpl {
                    Object L$0;
                    int label;
                    /* synthetic */ Object result;

                    public AnonymousClass1(Continuation continuation) {
                        super(continuation);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object obj) {
                        this.result = obj;
                        this.label |= Integer.MIN_VALUE;
                        return AnonymousClass2.this.emit(null, this);
                    }
                }

                public AnonymousClass2(FlowCollector flowCollector) {
                    this.$getAuthRequestContext = flowCollector;
                }

                /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
                /* JADX WARN: Removed duplicated region for block: B:14:0x0032  */
                @Override // kotlinx.coroutines.flow.FlowCollector
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct code enable 'Show inconsistent code' option in preferences
                */
                public final java.lang.Object emit(java.lang.Object r5, kotlin.coroutines.Continuation r6) {
                    /*
                        r4 = this;
                        boolean r0 = r6 instanceof id.dana.mybills.data.repository.MyBillsEntityRepository$getQuickBuySubscription$$inlined$map$1.AnonymousClass2.AnonymousClass1
                        if (r0 == 0) goto L14
                        r0 = r6
                        id.dana.mybills.data.repository.MyBillsEntityRepository$getQuickBuySubscription$$inlined$map$1$2$1 r0 = (id.dana.mybills.data.repository.MyBillsEntityRepository$getQuickBuySubscription$$inlined$map$1.AnonymousClass2.AnonymousClass1) r0
                        int r1 = r0.label
                        r2 = -2147483648(0xffffffff80000000, float:-0.0)
                        r1 = r1 & r2
                        if (r1 == 0) goto L14
                        int r6 = r0.label
                        int r6 = r6 + r2
                        r0.label = r6
                        goto L19
                    L14:
                        id.dana.mybills.data.repository.MyBillsEntityRepository$getQuickBuySubscription$$inlined$map$1$2$1 r0 = new id.dana.mybills.data.repository.MyBillsEntityRepository$getQuickBuySubscription$$inlined$map$1$2$1
                        r0.<init>(r6)
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
                        kotlinx.coroutines.flow.FlowCollector r6 = r4.$getAuthRequestContext
                        r2 = r0
                        kotlin.coroutines.Continuation r2 = (kotlin.coroutines.Continuation) r2
                        id.dana.mybills.data.model.response.QuickBuyResult r5 = (id.dana.mybills.data.model.response.QuickBuyResult) r5
                        java.util.List r5 = r5.getBizIds()
                        java.util.List r5 = id.dana.mybills.data.mapper.BizProductMapperKt.BuiltInFictitiousFunctionClassFactory(r5)
                        r0.label = r3
                        java.lang.Object r5 = r6.emit(r5, r0)
                        if (r5 != r1) goto L4d
                        return r1
                    L4d:
                        kotlin.Unit r5 = kotlin.Unit.INSTANCE
                        return r5
                    */
                    throw new UnsupportedOperationException("Method not decompiled: id.dana.mybills.data.repository.MyBillsEntityRepository$getQuickBuySubscription$$inlined$map$1.AnonymousClass2.emit(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
                }
            }
        });
    }

    @Override // id.dana.mybills.domain.MyBillsRepository
    public final Flow<BizProductOrder> MyBillsEntityDataFactory(BizProductOrderRequest p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        HoldLoginV1EntityRepository holdLoginV1EntityRepository = this.BuiltInFictitiousFunctionClassFactory;
        final Flow<CreateOrderResult> KClassImpl$Data$declaredNonStaticMembers$2 = ((MyBillsEntityData) this.PlaceComponentResult.getValue()).KClassImpl$Data$declaredNonStaticMembers$2(BizProductOrderMapperKt.PlaceComponentResult(p0));
        return holdLoginV1EntityRepository.PlaceComponentResult(new Flow<BizProductOrder>() { // from class: id.dana.mybills.data.repository.MyBillsEntityRepository$getCreateBizProductOrder$$inlined$map$1
            @Override // kotlinx.coroutines.flow.Flow
            public final Object collect(FlowCollector<? super BizProductOrder> flowCollector, Continuation continuation) {
                Object collect = Flow.this.collect(new AnonymousClass2(flowCollector), continuation);
                return collect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? collect : Unit.INSTANCE;
            }

            @Metadata(d1 = {"\u0000\f\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0004\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u00012\u0006\u0010\u0002\u001a\u00028\u0000H\u008a@¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"T", "R", "p0", "", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;"}, k = 3, mv = {1, 6, 0}, xi = 48)
            /* renamed from: id.dana.mybills.data.repository.MyBillsEntityRepository$getCreateBizProductOrder$$inlined$map$1$2  reason: invalid class name */
            /* loaded from: classes5.dex */
            public static final class AnonymousClass2<T> implements FlowCollector {
                final /* synthetic */ FlowCollector $getAuthRequestContext;

                @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
                @DebugMetadata(c = "id.dana.mybills.data.repository.MyBillsEntityRepository$getCreateBizProductOrder$$inlined$map$1$2", f = "MyBillsEntityRepository.kt", i = {}, l = {224}, m = "emit", n = {}, s = {})
                /* renamed from: id.dana.mybills.data.repository.MyBillsEntityRepository$getCreateBizProductOrder$$inlined$map$1$2$1  reason: invalid class name */
                /* loaded from: classes5.dex */
                public static final class AnonymousClass1 extends ContinuationImpl {
                    Object L$0;
                    int label;
                    /* synthetic */ Object result;

                    public AnonymousClass1(Continuation continuation) {
                        super(continuation);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object obj) {
                        this.result = obj;
                        this.label |= Integer.MIN_VALUE;
                        return AnonymousClass2.this.emit(null, this);
                    }
                }

                public AnonymousClass2(FlowCollector flowCollector) {
                    this.$getAuthRequestContext = flowCollector;
                }

                /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
                /* JADX WARN: Removed duplicated region for block: B:14:0x0032  */
                @Override // kotlinx.coroutines.flow.FlowCollector
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct code enable 'Show inconsistent code' option in preferences
                */
                public final java.lang.Object emit(java.lang.Object r5, kotlin.coroutines.Continuation r6) {
                    /*
                        r4 = this;
                        boolean r0 = r6 instanceof id.dana.mybills.data.repository.MyBillsEntityRepository$getCreateBizProductOrder$$inlined$map$1.AnonymousClass2.AnonymousClass1
                        if (r0 == 0) goto L14
                        r0 = r6
                        id.dana.mybills.data.repository.MyBillsEntityRepository$getCreateBizProductOrder$$inlined$map$1$2$1 r0 = (id.dana.mybills.data.repository.MyBillsEntityRepository$getCreateBizProductOrder$$inlined$map$1.AnonymousClass2.AnonymousClass1) r0
                        int r1 = r0.label
                        r2 = -2147483648(0xffffffff80000000, float:-0.0)
                        r1 = r1 & r2
                        if (r1 == 0) goto L14
                        int r6 = r0.label
                        int r6 = r6 + r2
                        r0.label = r6
                        goto L19
                    L14:
                        id.dana.mybills.data.repository.MyBillsEntityRepository$getCreateBizProductOrder$$inlined$map$1$2$1 r0 = new id.dana.mybills.data.repository.MyBillsEntityRepository$getCreateBizProductOrder$$inlined$map$1$2$1
                        r0.<init>(r6)
                    L19:
                        java.lang.Object r6 = r0.result
                        java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                        int r2 = r0.label
                        r3 = 1
                        if (r2 == 0) goto L32
                        if (r2 != r3) goto L2a
                        kotlin.ResultKt.throwOnFailure(r6)
                        goto L49
                    L2a:
                        java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                        java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
                        r5.<init>(r6)
                        throw r5
                    L32:
                        kotlin.ResultKt.throwOnFailure(r6)
                        kotlinx.coroutines.flow.FlowCollector r6 = r4.$getAuthRequestContext
                        r2 = r0
                        kotlin.coroutines.Continuation r2 = (kotlin.coroutines.Continuation) r2
                        id.dana.mybills.data.model.response.CreateOrderResult r5 = (id.dana.mybills.data.model.response.CreateOrderResult) r5
                        id.dana.mybills.domain.model.BizProductOrder r5 = id.dana.mybills.data.mapper.BizProductOrderMapperKt.KClassImpl$Data$declaredNonStaticMembers$2(r5)
                        r0.label = r3
                        java.lang.Object r5 = r6.emit(r5, r0)
                        if (r5 != r1) goto L49
                        return r1
                    L49:
                        kotlin.Unit r5 = kotlin.Unit.INSTANCE
                        return r5
                    */
                    throw new UnsupportedOperationException("Method not decompiled: id.dana.mybills.data.repository.MyBillsEntityRepository$getCreateBizProductOrder$$inlined$map$1.AnonymousClass2.emit(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
                }
            }
        });
    }

    @Override // id.dana.mybills.domain.MyBillsRepository
    public final Flow<HighlightTransactionPay> PlaceComponentResult(HighlightTransactionPayRequest p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        HoldLoginV1EntityRepository holdLoginV1EntityRepository = this.BuiltInFictitiousFunctionClassFactory;
        final Flow<HighlightTransactionPayResult> BuiltInFictitiousFunctionClassFactory = ((MyBillsEntityData) this.PlaceComponentResult.getValue()).BuiltInFictitiousFunctionClassFactory(HighlightTransactionPayRequestMapperKt.getAuthRequestContext(p0));
        return holdLoginV1EntityRepository.PlaceComponentResult(new Flow<HighlightTransactionPay>() { // from class: id.dana.mybills.data.repository.MyBillsEntityRepository$getHighlightTransactionPay$$inlined$map$1
            @Override // kotlinx.coroutines.flow.Flow
            public final Object collect(FlowCollector<? super HighlightTransactionPay> flowCollector, Continuation continuation) {
                Object collect = Flow.this.collect(new AnonymousClass2(flowCollector), continuation);
                return collect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? collect : Unit.INSTANCE;
            }

            @Metadata(d1 = {"\u0000\f\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0004\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u00012\u0006\u0010\u0002\u001a\u00028\u0000H\u008a@¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"T", "R", "p0", "", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;"}, k = 3, mv = {1, 6, 0}, xi = 48)
            /* renamed from: id.dana.mybills.data.repository.MyBillsEntityRepository$getHighlightTransactionPay$$inlined$map$1$2  reason: invalid class name */
            /* loaded from: classes5.dex */
            public static final class AnonymousClass2<T> implements FlowCollector {
                final /* synthetic */ FlowCollector $PlaceComponentResult;

                @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
                @DebugMetadata(c = "id.dana.mybills.data.repository.MyBillsEntityRepository$getHighlightTransactionPay$$inlined$map$1$2", f = "MyBillsEntityRepository.kt", i = {}, l = {224}, m = "emit", n = {}, s = {})
                /* renamed from: id.dana.mybills.data.repository.MyBillsEntityRepository$getHighlightTransactionPay$$inlined$map$1$2$1  reason: invalid class name */
                /* loaded from: classes5.dex */
                public static final class AnonymousClass1 extends ContinuationImpl {
                    Object L$0;
                    int label;
                    /* synthetic */ Object result;

                    public AnonymousClass1(Continuation continuation) {
                        super(continuation);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object obj) {
                        this.result = obj;
                        this.label |= Integer.MIN_VALUE;
                        return AnonymousClass2.this.emit(null, this);
                    }
                }

                public AnonymousClass2(FlowCollector flowCollector) {
                    this.$PlaceComponentResult = flowCollector;
                }

                /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
                /* JADX WARN: Removed duplicated region for block: B:14:0x0032  */
                @Override // kotlinx.coroutines.flow.FlowCollector
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct code enable 'Show inconsistent code' option in preferences
                */
                public final java.lang.Object emit(java.lang.Object r5, kotlin.coroutines.Continuation r6) {
                    /*
                        r4 = this;
                        boolean r0 = r6 instanceof id.dana.mybills.data.repository.MyBillsEntityRepository$getHighlightTransactionPay$$inlined$map$1.AnonymousClass2.AnonymousClass1
                        if (r0 == 0) goto L14
                        r0 = r6
                        id.dana.mybills.data.repository.MyBillsEntityRepository$getHighlightTransactionPay$$inlined$map$1$2$1 r0 = (id.dana.mybills.data.repository.MyBillsEntityRepository$getHighlightTransactionPay$$inlined$map$1.AnonymousClass2.AnonymousClass1) r0
                        int r1 = r0.label
                        r2 = -2147483648(0xffffffff80000000, float:-0.0)
                        r1 = r1 & r2
                        if (r1 == 0) goto L14
                        int r6 = r0.label
                        int r6 = r6 + r2
                        r0.label = r6
                        goto L19
                    L14:
                        id.dana.mybills.data.repository.MyBillsEntityRepository$getHighlightTransactionPay$$inlined$map$1$2$1 r0 = new id.dana.mybills.data.repository.MyBillsEntityRepository$getHighlightTransactionPay$$inlined$map$1$2$1
                        r0.<init>(r6)
                    L19:
                        java.lang.Object r6 = r0.result
                        java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                        int r2 = r0.label
                        r3 = 1
                        if (r2 == 0) goto L32
                        if (r2 != r3) goto L2a
                        kotlin.ResultKt.throwOnFailure(r6)
                        goto L49
                    L2a:
                        java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                        java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
                        r5.<init>(r6)
                        throw r5
                    L32:
                        kotlin.ResultKt.throwOnFailure(r6)
                        kotlinx.coroutines.flow.FlowCollector r6 = r4.$PlaceComponentResult
                        r2 = r0
                        kotlin.coroutines.Continuation r2 = (kotlin.coroutines.Continuation) r2
                        id.dana.mybills.data.model.response.HighlightTransactionPayResult r5 = (id.dana.mybills.data.model.response.HighlightTransactionPayResult) r5
                        id.dana.mybills.domain.model.HighlightTransactionPay r5 = id.dana.mybills.data.mapper.HighlightTransactionPayResultMapperKt.MyBillsEntityDataFactory(r5)
                        r0.label = r3
                        java.lang.Object r5 = r6.emit(r5, r0)
                        if (r5 != r1) goto L49
                        return r1
                    L49:
                        kotlin.Unit r5 = kotlin.Unit.INSTANCE
                        return r5
                    */
                    throw new UnsupportedOperationException("Method not decompiled: id.dana.mybills.data.repository.MyBillsEntityRepository$getHighlightTransactionPay$$inlined$map$1.AnonymousClass2.emit(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
                }
            }
        });
    }

    @Override // id.dana.mybills.domain.MyBillsRepository
    public final Flow<CreateSubscription> MyBillsEntityDataFactory(CreateSubscriptionRequest p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        HoldLoginV1EntityRepository holdLoginV1EntityRepository = this.BuiltInFictitiousFunctionClassFactory;
        final Flow<CreateSubscriptionResult> BuiltInFictitiousFunctionClassFactory = ((MyBillsEntityData) this.PlaceComponentResult.getValue()).BuiltInFictitiousFunctionClassFactory(CreateSubscriptionRequestKt.toCreateSubscriptionRequestEntity(p0));
        return holdLoginV1EntityRepository.PlaceComponentResult(new Flow<CreateSubscription>() { // from class: id.dana.mybills.data.repository.MyBillsEntityRepository$saveSubscription$$inlined$map$1
            @Override // kotlinx.coroutines.flow.Flow
            public final Object collect(FlowCollector<? super CreateSubscription> flowCollector, Continuation continuation) {
                Object collect = Flow.this.collect(new AnonymousClass2(flowCollector), continuation);
                return collect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? collect : Unit.INSTANCE;
            }

            @Metadata(d1 = {"\u0000\f\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0004\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u00012\u0006\u0010\u0002\u001a\u00028\u0000H\u008a@¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"T", "R", "p0", "", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;"}, k = 3, mv = {1, 6, 0}, xi = 48)
            /* renamed from: id.dana.mybills.data.repository.MyBillsEntityRepository$saveSubscription$$inlined$map$1$2  reason: invalid class name */
            /* loaded from: classes5.dex */
            public static final class AnonymousClass2<T> implements FlowCollector {
                final /* synthetic */ FlowCollector $MyBillsEntityDataFactory;

                @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
                @DebugMetadata(c = "id.dana.mybills.data.repository.MyBillsEntityRepository$saveSubscription$$inlined$map$1$2", f = "MyBillsEntityRepository.kt", i = {}, l = {224}, m = "emit", n = {}, s = {})
                /* renamed from: id.dana.mybills.data.repository.MyBillsEntityRepository$saveSubscription$$inlined$map$1$2$1  reason: invalid class name */
                /* loaded from: classes5.dex */
                public static final class AnonymousClass1 extends ContinuationImpl {
                    Object L$0;
                    int label;
                    /* synthetic */ Object result;

                    public AnonymousClass1(Continuation continuation) {
                        super(continuation);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object obj) {
                        this.result = obj;
                        this.label |= Integer.MIN_VALUE;
                        return AnonymousClass2.this.emit(null, this);
                    }
                }

                public AnonymousClass2(FlowCollector flowCollector) {
                    this.$MyBillsEntityDataFactory = flowCollector;
                }

                /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
                /* JADX WARN: Removed duplicated region for block: B:14:0x0032  */
                @Override // kotlinx.coroutines.flow.FlowCollector
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct code enable 'Show inconsistent code' option in preferences
                */
                public final java.lang.Object emit(java.lang.Object r5, kotlin.coroutines.Continuation r6) {
                    /*
                        r4 = this;
                        boolean r0 = r6 instanceof id.dana.mybills.data.repository.MyBillsEntityRepository$saveSubscription$$inlined$map$1.AnonymousClass2.AnonymousClass1
                        if (r0 == 0) goto L14
                        r0 = r6
                        id.dana.mybills.data.repository.MyBillsEntityRepository$saveSubscription$$inlined$map$1$2$1 r0 = (id.dana.mybills.data.repository.MyBillsEntityRepository$saveSubscription$$inlined$map$1.AnonymousClass2.AnonymousClass1) r0
                        int r1 = r0.label
                        r2 = -2147483648(0xffffffff80000000, float:-0.0)
                        r1 = r1 & r2
                        if (r1 == 0) goto L14
                        int r6 = r0.label
                        int r6 = r6 + r2
                        r0.label = r6
                        goto L19
                    L14:
                        id.dana.mybills.data.repository.MyBillsEntityRepository$saveSubscription$$inlined$map$1$2$1 r0 = new id.dana.mybills.data.repository.MyBillsEntityRepository$saveSubscription$$inlined$map$1$2$1
                        r0.<init>(r6)
                    L19:
                        java.lang.Object r6 = r0.result
                        java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                        int r2 = r0.label
                        r3 = 1
                        if (r2 == 0) goto L32
                        if (r2 != r3) goto L2a
                        kotlin.ResultKt.throwOnFailure(r6)
                        goto L49
                    L2a:
                        java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                        java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
                        r5.<init>(r6)
                        throw r5
                    L32:
                        kotlin.ResultKt.throwOnFailure(r6)
                        kotlinx.coroutines.flow.FlowCollector r6 = r4.$MyBillsEntityDataFactory
                        r2 = r0
                        kotlin.coroutines.Continuation r2 = (kotlin.coroutines.Continuation) r2
                        id.dana.mybills.data.model.response.CreateSubscriptionResult r5 = (id.dana.mybills.data.model.response.CreateSubscriptionResult) r5
                        id.dana.mybills.domain.model.CreateSubscription r5 = id.dana.mybills.data.model.response.CreateSubscriptionResultKt.toCreateSubscription(r5)
                        r0.label = r3
                        java.lang.Object r5 = r6.emit(r5, r0)
                        if (r5 != r1) goto L49
                        return r1
                    L49:
                        kotlin.Unit r5 = kotlin.Unit.INSTANCE
                        return r5
                    */
                    throw new UnsupportedOperationException("Method not decompiled: id.dana.mybills.data.repository.MyBillsEntityRepository$saveSubscription$$inlined$map$1.AnonymousClass2.emit(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
                }
            }
        });
    }

    @Override // id.dana.mybills.domain.MyBillsRepository
    public final Flow<CheckUniqueValue> MyBillsEntityDataFactory(UniqueValueRequest p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        HoldLoginV1EntityRepository holdLoginV1EntityRepository = this.BuiltInFictitiousFunctionClassFactory;
        final Flow<UniqueValueResult> KClassImpl$Data$declaredNonStaticMembers$2 = ((MyBillsEntityData) this.PlaceComponentResult.getValue()).KClassImpl$Data$declaredNonStaticMembers$2(p0);
        return holdLoginV1EntityRepository.PlaceComponentResult(new Flow<CheckUniqueValue>() { // from class: id.dana.mybills.data.repository.MyBillsEntityRepository$checkUniqueValue$$inlined$map$1
            @Override // kotlinx.coroutines.flow.Flow
            public final Object collect(FlowCollector<? super CheckUniqueValue> flowCollector, Continuation continuation) {
                Object collect = Flow.this.collect(new AnonymousClass2(flowCollector), continuation);
                return collect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? collect : Unit.INSTANCE;
            }

            @Metadata(d1 = {"\u0000\f\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0004\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u00012\u0006\u0010\u0002\u001a\u00028\u0000H\u008a@¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"T", "R", "p0", "", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;"}, k = 3, mv = {1, 6, 0}, xi = 48)
            /* renamed from: id.dana.mybills.data.repository.MyBillsEntityRepository$checkUniqueValue$$inlined$map$1$2  reason: invalid class name */
            /* loaded from: classes5.dex */
            public static final class AnonymousClass2<T> implements FlowCollector {
                final /* synthetic */ FlowCollector $getAuthRequestContext;

                @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
                @DebugMetadata(c = "id.dana.mybills.data.repository.MyBillsEntityRepository$checkUniqueValue$$inlined$map$1$2", f = "MyBillsEntityRepository.kt", i = {}, l = {224}, m = "emit", n = {}, s = {})
                /* renamed from: id.dana.mybills.data.repository.MyBillsEntityRepository$checkUniqueValue$$inlined$map$1$2$1  reason: invalid class name */
                /* loaded from: classes5.dex */
                public static final class AnonymousClass1 extends ContinuationImpl {
                    Object L$0;
                    int label;
                    /* synthetic */ Object result;

                    public AnonymousClass1(Continuation continuation) {
                        super(continuation);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object obj) {
                        this.result = obj;
                        this.label |= Integer.MIN_VALUE;
                        return AnonymousClass2.this.emit(null, this);
                    }
                }

                public AnonymousClass2(FlowCollector flowCollector) {
                    this.$getAuthRequestContext = flowCollector;
                }

                /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
                /* JADX WARN: Removed duplicated region for block: B:14:0x0032  */
                @Override // kotlinx.coroutines.flow.FlowCollector
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct code enable 'Show inconsistent code' option in preferences
                */
                public final java.lang.Object emit(java.lang.Object r5, kotlin.coroutines.Continuation r6) {
                    /*
                        r4 = this;
                        boolean r0 = r6 instanceof id.dana.mybills.data.repository.MyBillsEntityRepository$checkUniqueValue$$inlined$map$1.AnonymousClass2.AnonymousClass1
                        if (r0 == 0) goto L14
                        r0 = r6
                        id.dana.mybills.data.repository.MyBillsEntityRepository$checkUniqueValue$$inlined$map$1$2$1 r0 = (id.dana.mybills.data.repository.MyBillsEntityRepository$checkUniqueValue$$inlined$map$1.AnonymousClass2.AnonymousClass1) r0
                        int r1 = r0.label
                        r2 = -2147483648(0xffffffff80000000, float:-0.0)
                        r1 = r1 & r2
                        if (r1 == 0) goto L14
                        int r6 = r0.label
                        int r6 = r6 + r2
                        r0.label = r6
                        goto L19
                    L14:
                        id.dana.mybills.data.repository.MyBillsEntityRepository$checkUniqueValue$$inlined$map$1$2$1 r0 = new id.dana.mybills.data.repository.MyBillsEntityRepository$checkUniqueValue$$inlined$map$1$2$1
                        r0.<init>(r6)
                    L19:
                        java.lang.Object r6 = r0.result
                        java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                        int r2 = r0.label
                        r3 = 1
                        if (r2 == 0) goto L32
                        if (r2 != r3) goto L2a
                        kotlin.ResultKt.throwOnFailure(r6)
                        goto L49
                    L2a:
                        java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                        java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
                        r5.<init>(r6)
                        throw r5
                    L32:
                        kotlin.ResultKt.throwOnFailure(r6)
                        kotlinx.coroutines.flow.FlowCollector r6 = r4.$getAuthRequestContext
                        r2 = r0
                        kotlin.coroutines.Continuation r2 = (kotlin.coroutines.Continuation) r2
                        id.dana.mybills.data.model.response.UniqueValueResult r5 = (id.dana.mybills.data.model.response.UniqueValueResult) r5
                        id.dana.mybills.domain.model.CheckUniqueValue r5 = id.dana.mybills.data.model.response.UniqueValueResultKt.toCheckUniqueValue(r5)
                        r0.label = r3
                        java.lang.Object r5 = r6.emit(r5, r0)
                        if (r5 != r1) goto L49
                        return r1
                    L49:
                        kotlin.Unit r5 = kotlin.Unit.INSTANCE
                        return r5
                    */
                    throw new UnsupportedOperationException("Method not decompiled: id.dana.mybills.data.repository.MyBillsEntityRepository$checkUniqueValue$$inlined$map$1.AnonymousClass2.emit(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
                }
            }
        });
    }

    @Override // id.dana.mybills.domain.MyBillsRepository
    public final Flow<MobileRechargeProduct> getAuthRequestContext(ProductQueryRequest p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        HoldLoginV1EntityRepository holdLoginV1EntityRepository = this.BuiltInFictitiousFunctionClassFactory;
        final Flow PlaceComponentResult = this.BuiltInFictitiousFunctionClassFactory.PlaceComponentResult(((MyBillsEntityData) this.PlaceComponentResult.getValue()).getAuthRequestContext(ProductQueryRequestKt.toProductQueryRequestEntity(p0)));
        return holdLoginV1EntityRepository.PlaceComponentResult(new Flow<MobileRechargeProduct>() { // from class: id.dana.mybills.data.repository.MyBillsEntityRepository$getMobileRechargeProduct$$inlined$map$1
            @Override // kotlinx.coroutines.flow.Flow
            public final Object collect(FlowCollector<? super MobileRechargeProduct> flowCollector, Continuation continuation) {
                Object collect = Flow.this.collect(new AnonymousClass2(flowCollector), continuation);
                return collect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? collect : Unit.INSTANCE;
            }

            @Metadata(d1 = {"\u0000\f\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0004\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u00012\u0006\u0010\u0002\u001a\u00028\u0000H\u008a@¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"T", "R", "p0", "", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;"}, k = 3, mv = {1, 6, 0}, xi = 48)
            /* renamed from: id.dana.mybills.data.repository.MyBillsEntityRepository$getMobileRechargeProduct$$inlined$map$1$2  reason: invalid class name */
            /* loaded from: classes5.dex */
            public static final class AnonymousClass2<T> implements FlowCollector {
                final /* synthetic */ FlowCollector $KClassImpl$Data$declaredNonStaticMembers$2;

                @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
                @DebugMetadata(c = "id.dana.mybills.data.repository.MyBillsEntityRepository$getMobileRechargeProduct$$inlined$map$1$2", f = "MyBillsEntityRepository.kt", i = {}, l = {224}, m = "emit", n = {}, s = {})
                /* renamed from: id.dana.mybills.data.repository.MyBillsEntityRepository$getMobileRechargeProduct$$inlined$map$1$2$1  reason: invalid class name */
                /* loaded from: classes5.dex */
                public static final class AnonymousClass1 extends ContinuationImpl {
                    Object L$0;
                    int label;
                    /* synthetic */ Object result;

                    public AnonymousClass1(Continuation continuation) {
                        super(continuation);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object obj) {
                        this.result = obj;
                        this.label |= Integer.MIN_VALUE;
                        return AnonymousClass2.this.emit(null, this);
                    }
                }

                public AnonymousClass2(FlowCollector flowCollector) {
                    this.$KClassImpl$Data$declaredNonStaticMembers$2 = flowCollector;
                }

                /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
                /* JADX WARN: Removed duplicated region for block: B:14:0x0032  */
                @Override // kotlinx.coroutines.flow.FlowCollector
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct code enable 'Show inconsistent code' option in preferences
                */
                public final java.lang.Object emit(java.lang.Object r5, kotlin.coroutines.Continuation r6) {
                    /*
                        r4 = this;
                        boolean r0 = r6 instanceof id.dana.mybills.data.repository.MyBillsEntityRepository$getMobileRechargeProduct$$inlined$map$1.AnonymousClass2.AnonymousClass1
                        if (r0 == 0) goto L14
                        r0 = r6
                        id.dana.mybills.data.repository.MyBillsEntityRepository$getMobileRechargeProduct$$inlined$map$1$2$1 r0 = (id.dana.mybills.data.repository.MyBillsEntityRepository$getMobileRechargeProduct$$inlined$map$1.AnonymousClass2.AnonymousClass1) r0
                        int r1 = r0.label
                        r2 = -2147483648(0xffffffff80000000, float:-0.0)
                        r1 = r1 & r2
                        if (r1 == 0) goto L14
                        int r6 = r0.label
                        int r6 = r6 + r2
                        r0.label = r6
                        goto L19
                    L14:
                        id.dana.mybills.data.repository.MyBillsEntityRepository$getMobileRechargeProduct$$inlined$map$1$2$1 r0 = new id.dana.mybills.data.repository.MyBillsEntityRepository$getMobileRechargeProduct$$inlined$map$1$2$1
                        r0.<init>(r6)
                    L19:
                        java.lang.Object r6 = r0.result
                        java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                        int r2 = r0.label
                        r3 = 1
                        if (r2 == 0) goto L32
                        if (r2 != r3) goto L2a
                        kotlin.ResultKt.throwOnFailure(r6)
                        goto L49
                    L2a:
                        java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                        java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
                        r5.<init>(r6)
                        throw r5
                    L32:
                        kotlin.ResultKt.throwOnFailure(r6)
                        kotlinx.coroutines.flow.FlowCollector r6 = r4.$KClassImpl$Data$declaredNonStaticMembers$2
                        r2 = r0
                        kotlin.coroutines.Continuation r2 = (kotlin.coroutines.Continuation) r2
                        id.dana.mybills.data.model.response.MobileRechargeProductResult r5 = (id.dana.mybills.data.model.response.MobileRechargeProductResult) r5
                        id.dana.mybills.domain.model.MobileRechargeProduct r5 = id.dana.mybills.data.model.response.MobileRechargeProductResultKt.toMobileRechargeProduct(r5)
                        r0.label = r3
                        java.lang.Object r5 = r6.emit(r5, r0)
                        if (r5 != r1) goto L49
                        return r1
                    L49:
                        kotlin.Unit r5 = kotlin.Unit.INSTANCE
                        return r5
                    */
                    throw new UnsupportedOperationException("Method not decompiled: id.dana.mybills.data.repository.MyBillsEntityRepository$getMobileRechargeProduct$$inlined$map$1.AnonymousClass2.emit(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
                }
            }
        });
    }

    @Override // id.dana.mybills.domain.MyBillsRepository
    public final Flow<CurrencyAmount> KClassImpl$Data$declaredNonStaticMembers$2() {
        final Flow flow = FlowKt.flow(new MyBillsEntityRepository$getUserCurrentBalance$1(this, null));
        return new Flow<CurrencyAmount>() { // from class: id.dana.mybills.data.repository.MyBillsEntityRepository$getUserCurrentBalance$$inlined$map$1
            @Override // kotlinx.coroutines.flow.Flow
            public final Object collect(FlowCollector<? super CurrencyAmount> flowCollector, Continuation continuation) {
                Object collect = Flow.this.collect(new AnonymousClass2(flowCollector), continuation);
                return collect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? collect : Unit.INSTANCE;
            }

            @Metadata(d1 = {"\u0000\f\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0004\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u00012\u0006\u0010\u0002\u001a\u00028\u0000H\u008a@¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"T", "R", "p0", "", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;"}, k = 3, mv = {1, 6, 0}, xi = 48)
            /* renamed from: id.dana.mybills.data.repository.MyBillsEntityRepository$getUserCurrentBalance$$inlined$map$1$2  reason: invalid class name */
            /* loaded from: classes5.dex */
            public static final class AnonymousClass2<T> implements FlowCollector {
                final /* synthetic */ FlowCollector $PlaceComponentResult;

                @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
                @DebugMetadata(c = "id.dana.mybills.data.repository.MyBillsEntityRepository$getUserCurrentBalance$$inlined$map$1$2", f = "MyBillsEntityRepository.kt", i = {}, l = {224}, m = "emit", n = {}, s = {})
                /* renamed from: id.dana.mybills.data.repository.MyBillsEntityRepository$getUserCurrentBalance$$inlined$map$1$2$1  reason: invalid class name */
                /* loaded from: classes5.dex */
                public static final class AnonymousClass1 extends ContinuationImpl {
                    Object L$0;
                    int label;
                    /* synthetic */ Object result;

                    public AnonymousClass1(Continuation continuation) {
                        super(continuation);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object obj) {
                        this.result = obj;
                        this.label |= Integer.MIN_VALUE;
                        return AnonymousClass2.this.emit(null, this);
                    }
                }

                public AnonymousClass2(FlowCollector flowCollector) {
                    this.$PlaceComponentResult = flowCollector;
                }

                /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
                /* JADX WARN: Removed duplicated region for block: B:14:0x0032  */
                @Override // kotlinx.coroutines.flow.FlowCollector
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct code enable 'Show inconsistent code' option in preferences
                */
                public final java.lang.Object emit(java.lang.Object r6, kotlin.coroutines.Continuation r7) {
                    /*
                        r5 = this;
                        boolean r0 = r7 instanceof id.dana.mybills.data.repository.MyBillsEntityRepository$getUserCurrentBalance$$inlined$map$1.AnonymousClass2.AnonymousClass1
                        if (r0 == 0) goto L14
                        r0 = r7
                        id.dana.mybills.data.repository.MyBillsEntityRepository$getUserCurrentBalance$$inlined$map$1$2$1 r0 = (id.dana.mybills.data.repository.MyBillsEntityRepository$getUserCurrentBalance$$inlined$map$1.AnonymousClass2.AnonymousClass1) r0
                        int r1 = r0.label
                        r2 = -2147483648(0xffffffff80000000, float:-0.0)
                        r1 = r1 & r2
                        if (r1 == 0) goto L14
                        int r7 = r0.label
                        int r7 = r7 + r2
                        r0.label = r7
                        goto L19
                    L14:
                        id.dana.mybills.data.repository.MyBillsEntityRepository$getUserCurrentBalance$$inlined$map$1$2$1 r0 = new id.dana.mybills.data.repository.MyBillsEntityRepository$getUserCurrentBalance$$inlined$map$1$2$1
                        r0.<init>(r7)
                    L19:
                        java.lang.Object r7 = r0.result
                        java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                        int r2 = r0.label
                        r3 = 1
                        if (r2 == 0) goto L32
                        if (r2 != r3) goto L2a
                        kotlin.ResultKt.throwOnFailure(r7)
                        goto L62
                    L2a:
                        java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
                        java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
                        r6.<init>(r7)
                        throw r6
                    L32:
                        kotlin.ResultKt.throwOnFailure(r7)
                        kotlinx.coroutines.flow.FlowCollector r7 = r5.$PlaceComponentResult
                        r2 = r0
                        kotlin.coroutines.Continuation r2 = (kotlin.coroutines.Continuation) r2
                        id.dana.data.user.source.network.result.UserInfoRpcResult r6 = (id.dana.data.user.source.network.result.UserInfoRpcResult) r6
                        id.dana.data.model.CurrencyAmountResult r6 = r6.getBalance()
                        if (r6 == 0) goto L47
                        id.dana.domain.user.CurrencyAmount r6 = r6.toCurrencyAmount()
                        goto L48
                    L47:
                        r6 = 0
                    L48:
                        if (r6 != 0) goto L54
                        id.dana.domain.user.CurrencyAmount r6 = new id.dana.domain.user.CurrencyAmount
                        java.lang.String r2 = "0"
                        java.lang.String r4 = "Rp."
                        r6.<init>(r2, r4)
                        goto L59
                    L54:
                        java.lang.String r2 = ""
                        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r6, r2)
                    L59:
                        r0.label = r3
                        java.lang.Object r6 = r7.emit(r6, r0)
                        if (r6 != r1) goto L62
                        return r1
                    L62:
                        kotlin.Unit r6 = kotlin.Unit.INSTANCE
                        return r6
                    */
                    throw new UnsupportedOperationException("Method not decompiled: id.dana.mybills.data.repository.MyBillsEntityRepository$getUserCurrentBalance$$inlined$map$1.AnonymousClass2.emit(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
                }
            }
        };
    }

    @Override // id.dana.mybills.domain.MyBillsRepository
    public final Flow<GeneralProductResult> MyBillsEntityDataFactory(ProductQueryRequest p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        return this.BuiltInFictitiousFunctionClassFactory.PlaceComponentResult(((MyBillsEntityData) this.PlaceComponentResult.getValue()).getAuthRequestContext(p0));
    }

    @Override // id.dana.mybills.domain.MyBillsRepository
    public final Flow<UpdateSubscriptionResult> getAuthRequestContext(UpdateSubscriptionRequest p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        return this.BuiltInFictitiousFunctionClassFactory.PlaceComponentResult(((MyBillsEntityData) this.PlaceComponentResult.getValue()).KClassImpl$Data$declaredNonStaticMembers$2(p0));
    }

    @Override // id.dana.mybills.domain.MyBillsRepository
    public final Flow<DeleteSubscriptionResult> BuiltInFictitiousFunctionClassFactory(DeleteSubscriptionRequest p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        return this.BuiltInFictitiousFunctionClassFactory.PlaceComponentResult(((MyBillsEntityData) this.PlaceComponentResult.getValue()).BuiltInFictitiousFunctionClassFactory(p0));
    }

    public static final /* synthetic */ UserEntityData KClassImpl$Data$declaredNonStaticMembers$2(MyBillsEntityRepository myBillsEntityRepository) {
        return (UserEntityData) myBillsEntityRepository.MyBillsEntityDataFactory.getValue();
    }

    @Override // id.dana.mybills.domain.MyBillsRepository
    public final Flow<CumulateDueDatePaylaterResult> BuiltInFictitiousFunctionClassFactory(CumulateDueDateParamRequest p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        return ((MyBillsEntityData) this.PlaceComponentResult.getValue()).getAuthRequestContext(CumulateDueDateParamRequestKt.toCumulateDueDatePaylaterRequest(p0));
    }

    @Override // id.dana.mybills.domain.MyBillsRepository
    public final Flow<BizProductDestination> PlaceComponentResult(String p0, String p1) {
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p1, "");
        final Flow<InquiryBizDestinationResult> KClassImpl$Data$declaredNonStaticMembers$2 = ((MyBillsEntityData) this.PlaceComponentResult.getValue()).KClassImpl$Data$declaredNonStaticMembers$2(new InquiryBizDestinationRequest(p0, CollectionsKt.listOf(new BizDestinationParam(p1))));
        return new Flow<BizProductDestination>() { // from class: id.dana.mybills.data.repository.MyBillsEntityRepository$getInquirySubscriptionDestination$$inlined$map$1
            @Override // kotlinx.coroutines.flow.Flow
            public final Object collect(FlowCollector<? super BizProductDestination> flowCollector, Continuation continuation) {
                Object collect = Flow.this.collect(new AnonymousClass2(flowCollector), continuation);
                return collect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? collect : Unit.INSTANCE;
            }

            @Metadata(d1 = {"\u0000\f\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0004\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u00012\u0006\u0010\u0002\u001a\u00028\u0000H\u008a@¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"T", "R", "p0", "", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;"}, k = 3, mv = {1, 6, 0}, xi = 48)
            /* renamed from: id.dana.mybills.data.repository.MyBillsEntityRepository$getInquirySubscriptionDestination$$inlined$map$1$2  reason: invalid class name */
            /* loaded from: classes5.dex */
            public static final class AnonymousClass2<T> implements FlowCollector {
                final /* synthetic */ FlowCollector $MyBillsEntityDataFactory;

                @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
                @DebugMetadata(c = "id.dana.mybills.data.repository.MyBillsEntityRepository$getInquirySubscriptionDestination$$inlined$map$1$2", f = "MyBillsEntityRepository.kt", i = {}, l = {224}, m = "emit", n = {}, s = {})
                /* renamed from: id.dana.mybills.data.repository.MyBillsEntityRepository$getInquirySubscriptionDestination$$inlined$map$1$2$1  reason: invalid class name */
                /* loaded from: classes5.dex */
                public static final class AnonymousClass1 extends ContinuationImpl {
                    Object L$0;
                    int label;
                    /* synthetic */ Object result;

                    public AnonymousClass1(Continuation continuation) {
                        super(continuation);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object obj) {
                        this.result = obj;
                        this.label |= Integer.MIN_VALUE;
                        return AnonymousClass2.this.emit(null, this);
                    }
                }

                public AnonymousClass2(FlowCollector flowCollector) {
                    this.$MyBillsEntityDataFactory = flowCollector;
                }

                /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
                /* JADX WARN: Removed duplicated region for block: B:14:0x0032  */
                @Override // kotlinx.coroutines.flow.FlowCollector
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct code enable 'Show inconsistent code' option in preferences
                */
                public final java.lang.Object emit(java.lang.Object r5, kotlin.coroutines.Continuation r6) {
                    /*
                        r4 = this;
                        boolean r0 = r6 instanceof id.dana.mybills.data.repository.MyBillsEntityRepository$getInquirySubscriptionDestination$$inlined$map$1.AnonymousClass2.AnonymousClass1
                        if (r0 == 0) goto L14
                        r0 = r6
                        id.dana.mybills.data.repository.MyBillsEntityRepository$getInquirySubscriptionDestination$$inlined$map$1$2$1 r0 = (id.dana.mybills.data.repository.MyBillsEntityRepository$getInquirySubscriptionDestination$$inlined$map$1.AnonymousClass2.AnonymousClass1) r0
                        int r1 = r0.label
                        r2 = -2147483648(0xffffffff80000000, float:-0.0)
                        r1 = r1 & r2
                        if (r1 == 0) goto L14
                        int r6 = r0.label
                        int r6 = r6 + r2
                        r0.label = r6
                        goto L19
                    L14:
                        id.dana.mybills.data.repository.MyBillsEntityRepository$getInquirySubscriptionDestination$$inlined$map$1$2$1 r0 = new id.dana.mybills.data.repository.MyBillsEntityRepository$getInquirySubscriptionDestination$$inlined$map$1$2$1
                        r0.<init>(r6)
                    L19:
                        java.lang.Object r6 = r0.result
                        java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                        int r2 = r0.label
                        r3 = 1
                        if (r2 == 0) goto L32
                        if (r2 != r3) goto L2a
                        kotlin.ResultKt.throwOnFailure(r6)
                        goto L49
                    L2a:
                        java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                        java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
                        r5.<init>(r6)
                        throw r5
                    L32:
                        kotlin.ResultKt.throwOnFailure(r6)
                        kotlinx.coroutines.flow.FlowCollector r6 = r4.$MyBillsEntityDataFactory
                        r2 = r0
                        kotlin.coroutines.Continuation r2 = (kotlin.coroutines.Continuation) r2
                        id.dana.mybills.data.model.response.InquiryBizDestinationResult r5 = (id.dana.mybills.data.model.response.InquiryBizDestinationResult) r5
                        id.dana.mybills.domain.model.BizProductDestination r5 = id.dana.mybills.data.mapper.BizProductDestinationMapperKt.BuiltInFictitiousFunctionClassFactory(r5)
                        r0.label = r3
                        java.lang.Object r5 = r6.emit(r5, r0)
                        if (r5 != r1) goto L49
                        return r1
                    L49:
                        kotlin.Unit r5 = kotlin.Unit.INSTANCE
                        return r5
                    */
                    throw new UnsupportedOperationException("Method not decompiled: id.dana.mybills.data.repository.MyBillsEntityRepository$getInquirySubscriptionDestination$$inlined$map$1.AnonymousClass2.emit(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
                }
            }
        };
    }

    @Override // id.dana.mybills.domain.MyBillsRepository
    public final Flow<ConfigInfoRangeDate> MyBillsEntityDataFactory() {
        final Flow<ConfigInfoRangeDateResult> PlaceComponentResult = ((MyBillsEntityData) this.getAuthRequestContext.getValue()).PlaceComponentResult();
        return new Flow<ConfigInfoRangeDate>() { // from class: id.dana.mybills.data.repository.MyBillsEntityRepository$getMyBillsDateRange$$inlined$map$1
            @Override // kotlinx.coroutines.flow.Flow
            public final Object collect(FlowCollector<? super ConfigInfoRangeDate> flowCollector, Continuation continuation) {
                Object collect = Flow.this.collect(new AnonymousClass2(flowCollector), continuation);
                return collect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? collect : Unit.INSTANCE;
            }

            @Metadata(d1 = {"\u0000\f\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0004\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u00012\u0006\u0010\u0002\u001a\u00028\u0000H\u008a@¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"T", "R", "p0", "", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;"}, k = 3, mv = {1, 6, 0}, xi = 48)
            /* renamed from: id.dana.mybills.data.repository.MyBillsEntityRepository$getMyBillsDateRange$$inlined$map$1$2  reason: invalid class name */
            /* loaded from: classes5.dex */
            public static final class AnonymousClass2<T> implements FlowCollector {
                final /* synthetic */ FlowCollector $MyBillsEntityDataFactory;

                @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
                @DebugMetadata(c = "id.dana.mybills.data.repository.MyBillsEntityRepository$getMyBillsDateRange$$inlined$map$1$2", f = "MyBillsEntityRepository.kt", i = {}, l = {224}, m = "emit", n = {}, s = {})
                /* renamed from: id.dana.mybills.data.repository.MyBillsEntityRepository$getMyBillsDateRange$$inlined$map$1$2$1  reason: invalid class name */
                /* loaded from: classes5.dex */
                public static final class AnonymousClass1 extends ContinuationImpl {
                    Object L$0;
                    int label;
                    /* synthetic */ Object result;

                    public AnonymousClass1(Continuation continuation) {
                        super(continuation);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object obj) {
                        this.result = obj;
                        this.label |= Integer.MIN_VALUE;
                        return AnonymousClass2.this.emit(null, this);
                    }
                }

                public AnonymousClass2(FlowCollector flowCollector) {
                    this.$MyBillsEntityDataFactory = flowCollector;
                }

                /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
                /* JADX WARN: Removed duplicated region for block: B:14:0x0032  */
                @Override // kotlinx.coroutines.flow.FlowCollector
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct code enable 'Show inconsistent code' option in preferences
                */
                public final java.lang.Object emit(java.lang.Object r5, kotlin.coroutines.Continuation r6) {
                    /*
                        r4 = this;
                        boolean r0 = r6 instanceof id.dana.mybills.data.repository.MyBillsEntityRepository$getMyBillsDateRange$$inlined$map$1.AnonymousClass2.AnonymousClass1
                        if (r0 == 0) goto L14
                        r0 = r6
                        id.dana.mybills.data.repository.MyBillsEntityRepository$getMyBillsDateRange$$inlined$map$1$2$1 r0 = (id.dana.mybills.data.repository.MyBillsEntityRepository$getMyBillsDateRange$$inlined$map$1.AnonymousClass2.AnonymousClass1) r0
                        int r1 = r0.label
                        r2 = -2147483648(0xffffffff80000000, float:-0.0)
                        r1 = r1 & r2
                        if (r1 == 0) goto L14
                        int r6 = r0.label
                        int r6 = r6 + r2
                        r0.label = r6
                        goto L19
                    L14:
                        id.dana.mybills.data.repository.MyBillsEntityRepository$getMyBillsDateRange$$inlined$map$1$2$1 r0 = new id.dana.mybills.data.repository.MyBillsEntityRepository$getMyBillsDateRange$$inlined$map$1$2$1
                        r0.<init>(r6)
                    L19:
                        java.lang.Object r6 = r0.result
                        java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                        int r2 = r0.label
                        r3 = 1
                        if (r2 == 0) goto L32
                        if (r2 != r3) goto L2a
                        kotlin.ResultKt.throwOnFailure(r6)
                        goto L49
                    L2a:
                        java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                        java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
                        r5.<init>(r6)
                        throw r5
                    L32:
                        kotlin.ResultKt.throwOnFailure(r6)
                        kotlinx.coroutines.flow.FlowCollector r6 = r4.$MyBillsEntityDataFactory
                        r2 = r0
                        kotlin.coroutines.Continuation r2 = (kotlin.coroutines.Continuation) r2
                        id.dana.mybills.data.model.response.ConfigInfoRangeDateResult r5 = (id.dana.mybills.data.model.response.ConfigInfoRangeDateResult) r5
                        id.dana.mybills.domain.model.ConfigInfoRangeDate r5 = id.dana.mybills.data.model.response.ConfigInfoRangeDateResultKt.toConfigInfoRangeDate(r5)
                        r0.label = r3
                        java.lang.Object r5 = r6.emit(r5, r0)
                        if (r5 != r1) goto L49
                        return r1
                    L49:
                        kotlin.Unit r5 = kotlin.Unit.INSTANCE
                        return r5
                    */
                    throw new UnsupportedOperationException("Method not decompiled: id.dana.mybills.data.repository.MyBillsEntityRepository$getMyBillsDateRange$$inlined$map$1.AnonymousClass2.emit(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
                }
            }
        };
    }

    @Override // id.dana.mybills.domain.MyBillsRepository
    public final Flow<Boolean> PlaceComponentResult(String p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        return ((MyBillsEntityData) this.getAuthRequestContext.getValue()).KClassImpl$Data$declaredNonStaticMembers$2(p0);
    }

    @Override // id.dana.mybills.domain.MyBillsRepository
    public final Flow<QuerySubscriptionResult> BuiltInFictitiousFunctionClassFactory(QuerySubscriptionRequest p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        return ((MyBillsEntityData) this.PlaceComponentResult.getValue()).KClassImpl$Data$declaredNonStaticMembers$2(p0);
    }
}
