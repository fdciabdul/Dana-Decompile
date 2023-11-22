package id.dana.mybills.data.repository.source.split;

import android.os.SystemClock;
import id.dana.data.toggle.SplitFacade;
import id.dana.data.toggle.constant.ConfigType;
import id.dana.data.toggle.exception.SplitException;
import id.dana.data.toggle.exception.SplitNull;
import id.dana.data.toggle.exception.UnexpectedTreatment;
import id.dana.data.toggle.traffictype.BaseTrafficType;
import id.dana.lib.toggle.ToggleCallback;
import id.dana.lib.toggle.ToggleManager;
import id.dana.mybills.data.model.request.CreateOrderRequest;
import id.dana.mybills.data.model.request.CreateSubscriptionRequestEntity;
import id.dana.mybills.data.model.request.CumulateDueDatePaylaterRequest;
import id.dana.mybills.data.model.request.DeleteSubscriptionRequest;
import id.dana.mybills.data.model.request.HighlightSubscriptionRequest;
import id.dana.mybills.data.model.request.HighlightTransactionPayRequestEntity;
import id.dana.mybills.data.model.request.InquiryBizDestinationRequest;
import id.dana.mybills.data.model.request.MonthlyAmountSubscriptionRequest;
import id.dana.mybills.data.model.request.ProductQueryRequestEntity;
import id.dana.mybills.data.model.request.QuerySubscriptionRequest;
import id.dana.mybills.data.model.request.UniqueValueRequest;
import id.dana.mybills.data.model.request.UpdateSubscriptionRequest;
import id.dana.mybills.data.model.response.ConfigInfoRangeDateResult;
import id.dana.mybills.data.model.response.ConfigInfoRangeDateResultKt;
import id.dana.mybills.data.model.response.CreateOrderResult;
import id.dana.mybills.data.model.response.CreateSubscriptionResult;
import id.dana.mybills.data.model.response.CumulateDueDatePaylaterResult;
import id.dana.mybills.data.model.response.DeleteSubscriptionResult;
import id.dana.mybills.data.model.response.GeneralProductResult;
import id.dana.mybills.data.model.response.HighlightSubscriptionResult;
import id.dana.mybills.data.model.response.HighlightTransactionPayResult;
import id.dana.mybills.data.model.response.InquiryBizDestinationResult;
import id.dana.mybills.data.model.response.MobileRechargeProductResult;
import id.dana.mybills.data.model.response.MonthlyAmountSubscriptionResult;
import id.dana.mybills.data.model.response.QuerySubscriptionResult;
import id.dana.mybills.data.model.response.QuickBuyResult;
import id.dana.mybills.data.model.response.UniqueValueResult;
import id.dana.mybills.data.model.response.UpdateSubscriptionResult;
import id.dana.mybills.data.repository.source.MyBillsEntityData;
import id.dana.mybills.di.scope.MyBillsScope;
import id.dana.mybills.domain.model.ProductQueryRequest;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.ObservableSource;
import io.reactivex.functions.Function;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Typography;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import o.BottomSheetCardBindingView$watcherCardNumberView$1;

@Metadata(d1 = {"\u0000¼\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0003\u001a\u000208¢\u0006\u0004\b:\u0010;J\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u001d\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\u00042\u0006\u0010\u0003\u001a\u00020\bH\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u001d\u0010\n\u001a\b\u0012\u0004\u0012\u00020\r0\u00042\u0006\u0010\u0003\u001a\u00020\fH\u0016¢\u0006\u0004\b\n\u0010\u000eJ\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00100\u00042\u0006\u0010\u0003\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0006\u0010\u0011J\u001d\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00130\u00042\u0006\u0010\u0003\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u001d\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00170\u00042\u0006\u0010\u0003\u001a\u00020\u0016H\u0016¢\u0006\u0004\b\u0014\u0010\u0018J\u001d\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00042\u0006\u0010\u0003\u001a\u00020\u0019H\u0016¢\u0006\u0004\b\n\u0010\u001bJ\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u001d0\u00042\u0006\u0010\u0003\u001a\u00020\u001cH\u0016¢\u0006\u0004\b\u0006\u0010\u001eJ\u001d\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020 0\u00042\u0006\u0010\u0003\u001a\u00020\u001fH\u0016¢\u0006\u0004\b\u0014\u0010!J\u001d\u0010$\u001a\b\u0012\u0004\u0012\u00020#0\u00042\u0006\u0010\u0003\u001a\u00020\"H\u0016¢\u0006\u0004\b$\u0010%J\u0015\u0010'\u001a\b\u0012\u0004\u0012\u00020&0\u0004H\u0016¢\u0006\u0004\b'\u0010(J#\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020+0\u00042\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020*0)H\u0016¢\u0006\u0004\b\u0014\u0010,J\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020-0\u00042\u0006\u0010\u0003\u001a\u00020*H\u0016¢\u0006\u0004\b\u0006\u0010.J\u001d\u0010\n\u001a\b\u0012\u0004\u0012\u0002000\u00042\u0006\u0010\u0003\u001a\u00020/H\u0016¢\u0006\u0004\b\n\u00101J\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u0002030\u00042\u0006\u0010\u0003\u001a\u000202H\u0016¢\u0006\u0004\b\u0006\u00104J\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u0002060\u00042\u0006\u0010\u0003\u001a\u000205H\u0016¢\u0006\u0004\b\u0006\u00107R\u0014\u0010\u0014\u001a\u0002088\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u00109"}, d2 = {"Lid/dana/mybills/data/repository/source/split/SplitMyBillsEntityData;", "Lid/dana/mybills/data/repository/source/MyBillsEntityData;", "Lid/dana/mybills/data/model/request/UniqueValueRequest;", "p0", "Lkotlinx/coroutines/flow/Flow;", "Lid/dana/mybills/data/model/response/UniqueValueResult;", "KClassImpl$Data$declaredNonStaticMembers$2", "(Lid/dana/mybills/data/model/request/UniqueValueRequest;)Lkotlinx/coroutines/flow/Flow;", "Lid/dana/mybills/data/model/request/HighlightTransactionPayRequestEntity;", "Lid/dana/mybills/data/model/response/HighlightTransactionPayResult;", "BuiltInFictitiousFunctionClassFactory", "(Lid/dana/mybills/data/model/request/HighlightTransactionPayRequestEntity;)Lkotlinx/coroutines/flow/Flow;", "Lid/dana/mybills/data/model/request/DeleteSubscriptionRequest;", "Lid/dana/mybills/data/model/response/DeleteSubscriptionResult;", "(Lid/dana/mybills/data/model/request/DeleteSubscriptionRequest;)Lkotlinx/coroutines/flow/Flow;", "Lid/dana/mybills/data/model/request/CreateOrderRequest;", "Lid/dana/mybills/data/model/response/CreateOrderResult;", "(Lid/dana/mybills/data/model/request/CreateOrderRequest;)Lkotlinx/coroutines/flow/Flow;", "Lid/dana/mybills/data/model/request/CumulateDueDatePaylaterRequest;", "Lid/dana/mybills/data/model/response/CumulateDueDatePaylaterResult;", "getAuthRequestContext", "(Lid/dana/mybills/data/model/request/CumulateDueDatePaylaterRequest;)Lkotlinx/coroutines/flow/Flow;", "Lid/dana/mybills/domain/model/ProductQueryRequest;", "Lid/dana/mybills/data/model/response/GeneralProductResult;", "(Lid/dana/mybills/domain/model/ProductQueryRequest;)Lkotlinx/coroutines/flow/Flow;", "Lid/dana/mybills/data/model/request/HighlightSubscriptionRequest;", "Lid/dana/mybills/data/model/response/HighlightSubscriptionResult;", "(Lid/dana/mybills/data/model/request/HighlightSubscriptionRequest;)Lkotlinx/coroutines/flow/Flow;", "Lid/dana/mybills/data/model/request/InquiryBizDestinationRequest;", "Lid/dana/mybills/data/model/response/InquiryBizDestinationResult;", "(Lid/dana/mybills/data/model/request/InquiryBizDestinationRequest;)Lkotlinx/coroutines/flow/Flow;", "Lid/dana/mybills/data/model/request/ProductQueryRequestEntity;", "Lid/dana/mybills/data/model/response/MobileRechargeProductResult;", "(Lid/dana/mybills/data/model/request/ProductQueryRequestEntity;)Lkotlinx/coroutines/flow/Flow;", "Lid/dana/mybills/data/model/request/MonthlyAmountSubscriptionRequest;", "Lid/dana/mybills/data/model/response/MonthlyAmountSubscriptionResult;", "MyBillsEntityDataFactory", "(Lid/dana/mybills/data/model/request/MonthlyAmountSubscriptionRequest;)Lkotlinx/coroutines/flow/Flow;", "Lid/dana/mybills/data/model/response/ConfigInfoRangeDateResult;", "PlaceComponentResult", "()Lkotlinx/coroutines/flow/Flow;", "", "", "Lid/dana/mybills/data/model/response/QuickBuyResult;", "(Ljava/util/List;)Lkotlinx/coroutines/flow/Flow;", "", "(Ljava/lang/String;)Lkotlinx/coroutines/flow/Flow;", "Lid/dana/mybills/data/model/request/CreateSubscriptionRequestEntity;", "Lid/dana/mybills/data/model/response/CreateSubscriptionResult;", "(Lid/dana/mybills/data/model/request/CreateSubscriptionRequestEntity;)Lkotlinx/coroutines/flow/Flow;", "Lid/dana/mybills/data/model/request/QuerySubscriptionRequest;", "Lid/dana/mybills/data/model/response/QuerySubscriptionResult;", "(Lid/dana/mybills/data/model/request/QuerySubscriptionRequest;)Lkotlinx/coroutines/flow/Flow;", "Lid/dana/mybills/data/model/request/UpdateSubscriptionRequest;", "Lid/dana/mybills/data/model/response/UpdateSubscriptionResult;", "(Lid/dana/mybills/data/model/request/UpdateSubscriptionRequest;)Lkotlinx/coroutines/flow/Flow;", "Lid/dana/data/toggle/SplitFacade;", "Lid/dana/data/toggle/SplitFacade;", "<init>", "(Lid/dana/data/toggle/SplitFacade;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
@MyBillsScope
/* loaded from: classes5.dex */
public final class SplitMyBillsEntityData implements MyBillsEntityData {
    private static int $10 = 0;
    private static int $11 = 1;
    private static int NetworkUserEntityData$$ExternalSyntheticLambda0 = 1;
    private static int lookAheadTest;
    private final SplitFacade getAuthRequestContext;
    private static char[] BuiltInFictitiousFunctionClassFactory = {39929, 39917, 39810, 39933, 39928, 39923, 39815, 39808, 39813, 39920, 39809, 39924, 39811, 39931, 39922, 39927, 39926, 39934, 39935};
    private static boolean PlaceComponentResult = true;
    private static boolean MyBillsEntityDataFactory = true;
    private static int KClassImpl$Data$declaredNonStaticMembers$2 = 909155172;

    public static /* synthetic */ ObservableSource getAuthRequestContext(BaseTrafficType baseTrafficType) {
        int i = NetworkUserEntityData$$ExternalSyntheticLambda0 + 95;
        lookAheadTest = i % 128;
        char c = i % 2 != 0 ? '/' : ',';
        ObservableSource BuiltInFictitiousFunctionClassFactory2 = BuiltInFictitiousFunctionClassFactory(baseTrafficType);
        if (c != ',') {
            Object[] objArr = null;
            int length = objArr.length;
        }
        int i2 = NetworkUserEntityData$$ExternalSyntheticLambda0 + 117;
        lookAheadTest = i2 % 128;
        int i3 = i2 % 2;
        return BuiltInFictitiousFunctionClassFactory2;
    }

    @Inject
    public SplitMyBillsEntityData(SplitFacade splitFacade) {
        Intrinsics.checkNotNullParameter(splitFacade, "");
        this.getAuthRequestContext = splitFacade;
    }

    public static final /* synthetic */ SplitFacade MyBillsEntityDataFactory(SplitMyBillsEntityData splitMyBillsEntityData) {
        int i = NetworkUserEntityData$$ExternalSyntheticLambda0 + 93;
        lookAheadTest = i % 128;
        int i2 = i % 2;
        SplitFacade splitFacade = splitMyBillsEntityData.getAuthRequestContext;
        int i3 = lookAheadTest + 121;
        NetworkUserEntityData$$ExternalSyntheticLambda0 = i3 % 128;
        if ((i3 % 2 == 0 ? 'Y' : ':') != 'Y') {
            return splitFacade;
        }
        int i4 = 39 / 0;
        return splitFacade;
    }

    @Override // id.dana.mybills.data.repository.source.MyBillsEntityData
    public final Flow<MonthlyAmountSubscriptionResult> MyBillsEntityDataFactory(MonthlyAmountSubscriptionRequest p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        throw new UnsupportedOperationException();
    }

    @Override // id.dana.mybills.data.repository.source.MyBillsEntityData
    public final Flow<HighlightSubscriptionResult> BuiltInFictitiousFunctionClassFactory(HighlightSubscriptionRequest p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        throw new UnsupportedOperationException();
    }

    @Override // id.dana.mybills.data.repository.source.MyBillsEntityData
    public final Flow<QuickBuyResult> getAuthRequestContext(List<String> p0) {
        try {
            Intrinsics.checkNotNullParameter(p0, "");
            throw new UnsupportedOperationException();
        } catch (Exception e) {
            throw e;
        }
    }

    @Override // id.dana.mybills.data.repository.source.MyBillsEntityData
    public final Flow<CreateOrderResult> KClassImpl$Data$declaredNonStaticMembers$2(CreateOrderRequest p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        throw new UnsupportedOperationException();
    }

    @Override // id.dana.mybills.data.repository.source.MyBillsEntityData
    public final Flow<HighlightTransactionPayResult> BuiltInFictitiousFunctionClassFactory(HighlightTransactionPayRequestEntity p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        throw new UnsupportedOperationException();
    }

    @Override // id.dana.mybills.data.repository.source.MyBillsEntityData
    public final Flow<InquiryBizDestinationResult> KClassImpl$Data$declaredNonStaticMembers$2(InquiryBizDestinationRequest p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        throw new UnsupportedOperationException();
    }

    @Override // id.dana.mybills.data.repository.source.MyBillsEntityData
    public final Flow<Boolean> KClassImpl$Data$declaredNonStaticMembers$2(String p0) {
        try {
            Intrinsics.checkNotNullParameter(p0, "");
            Object[] objArr = null;
            Flow<Boolean> flow = FlowKt.flow(new SplitMyBillsEntityData$isServiceEnable$1(this, p0, null));
            int i = lookAheadTest + 89;
            NetworkUserEntityData$$ExternalSyntheticLambda0 = i % 128;
            if (!(i % 2 == 0)) {
                return flow;
            }
            int length = objArr.length;
            return flow;
        } catch (Exception e) {
            throw e;
        }
    }

    @Override // id.dana.mybills.data.repository.source.MyBillsEntityData
    public final Flow<CreateSubscriptionResult> BuiltInFictitiousFunctionClassFactory(CreateSubscriptionRequestEntity p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        throw new UnsupportedOperationException();
    }

    @Override // id.dana.mybills.data.repository.source.MyBillsEntityData
    public final Flow<UniqueValueResult> KClassImpl$Data$declaredNonStaticMembers$2(UniqueValueRequest p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        throw new UnsupportedOperationException();
    }

    @Override // id.dana.mybills.data.repository.source.MyBillsEntityData
    public final Flow<MobileRechargeProductResult> getAuthRequestContext(ProductQueryRequestEntity p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        throw new UnsupportedOperationException();
    }

    @Override // id.dana.mybills.data.repository.source.MyBillsEntityData
    public final Flow<GeneralProductResult> getAuthRequestContext(ProductQueryRequest p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        throw new UnsupportedOperationException();
    }

    @Override // id.dana.mybills.data.repository.source.MyBillsEntityData
    public final Flow<UpdateSubscriptionResult> KClassImpl$Data$declaredNonStaticMembers$2(UpdateSubscriptionRequest p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        throw new UnsupportedOperationException();
    }

    @Override // id.dana.mybills.data.repository.source.MyBillsEntityData
    public final Flow<DeleteSubscriptionResult> BuiltInFictitiousFunctionClassFactory(DeleteSubscriptionRequest p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        throw new UnsupportedOperationException();
    }

    @Override // id.dana.mybills.data.repository.source.MyBillsEntityData
    public final Flow<QuerySubscriptionResult> KClassImpl$Data$declaredNonStaticMembers$2(QuerySubscriptionRequest p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        throw new UnsupportedOperationException();
    }

    @Override // id.dana.mybills.data.repository.source.MyBillsEntityData
    public final Flow<ConfigInfoRangeDateResult> PlaceComponentResult() {
        Flow<ConfigInfoRangeDateResult> flowOf = FlowKt.flowOf(this.getAuthRequestContext.KClassImpl$Data$declaredNonStaticMembers$2().flatMap(new Function() { // from class: id.dana.mybills.data.repository.source.split.SplitMyBillsEntityData$$ExternalSyntheticLambda0
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return SplitMyBillsEntityData.getAuthRequestContext((BaseTrafficType) obj);
            }
        }).blockingFirst());
        int i = NetworkUserEntityData$$ExternalSyntheticLambda0 + 123;
        lookAheadTest = i % 128;
        if ((i % 2 != 0 ? (char) 22 : 'Y') != 'Y') {
            Object[] objArr = null;
            int length = objArr.length;
            return flowOf;
        }
        return flowOf;
    }

    private static final ObservableSource BuiltInFictitiousFunctionClassFactory(final BaseTrafficType baseTrafficType) {
        Intrinsics.checkNotNullParameter(baseTrafficType, "");
        final ConfigInfoRangeDateResult configInfoRangeDateResult = new ConfigInfoRangeDateResult(ConfigInfoRangeDateResultKt.getConfigInfoList());
        Object[] objArr = new Object[1];
        a((SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)) + 126, new byte[]{-109, -124, -110, -111, -112, -115, -121, -113, -117, -114, -115, -124, -116, -121, -117, -118, -119, -120, -121, -122, -123, -123, -124, -125, -126, -127}, null, null, objArr);
        final String intern = ((String) objArr[0]).intern();
        Observable create = Observable.create(new ObservableOnSubscribe() { // from class: id.dana.mybills.data.repository.source.split.SplitMyBillsEntityData$getMyBillsDateRange$lambda-0$$inlined$getConfigOnceReady$default$1
            final /* synthetic */ boolean $PlaceComponentResult = false;

            /* JADX WARN: Multi-variable type inference failed */
            @Override // io.reactivex.ObservableOnSubscribe
            public final void subscribe(final ObservableEmitter<T> observableEmitter) {
                Intrinsics.checkNotNullParameter(observableEmitter, "");
                BaseTrafficType.this.KClassImpl$Data$declaredNonStaticMembers$2(intern);
                ToggleManager MyBillsEntityDataFactory2 = ToggleManager.MyBillsEntityDataFactory();
                String str = intern;
                String BuiltInFictitiousFunctionClassFactory2 = BaseTrafficType.this.BuiltInFictitiousFunctionClassFactory();
                Object obj = configInfoRangeDateResult;
                final boolean z = this.$PlaceComponentResult;
                final BaseTrafficType baseTrafficType2 = BaseTrafficType.this;
                final String str2 = intern;
                MyBillsEntityDataFactory2.getAuthRequestContext(str, BuiltInFictitiousFunctionClassFactory2, ConfigInfoRangeDateResult.class, obj, new ToggleCallback<T>() { // from class: id.dana.mybills.data.repository.source.split.SplitMyBillsEntityData$getMyBillsDateRange$lambda-0$$inlined$getConfigOnceReady$default$1.1
                    @Override // id.dana.lib.toggle.ToggleCallback
                    public final void onComplete(String p0, T p1) {
                        Unit unit;
                        Intrinsics.checkNotNullParameter(p0, "");
                        if (p1 != null) {
                            boolean z2 = z;
                            BaseTrafficType baseTrafficType3 = baseTrafficType2;
                            String str3 = str2;
                            ObservableEmitter observableEmitter2 = observableEmitter;
                            if (z2 && Intrinsics.areEqual(p0, "control")) {
                                baseTrafficType3.MyBillsEntityDataFactory(BaseTrafficType.getAuthRequestContext(p0), str3, "Not Received", ConfigType.ASYNC);
                                observableEmitter2.onError(new UnexpectedTreatment(str3));
                            } else {
                                baseTrafficType3.MyBillsEntityDataFactory(BaseTrafficType.getAuthRequestContext(p0), str3, "Received", ConfigType.ASYNC);
                                observableEmitter2.onNext(p1);
                                observableEmitter2.onComplete();
                            }
                            unit = Unit.INSTANCE;
                        } else {
                            unit = null;
                        }
                        if (unit == null) {
                            BaseTrafficType baseTrafficType4 = baseTrafficType2;
                            String str4 = str2;
                            ObservableEmitter observableEmitter3 = observableEmitter;
                            baseTrafficType4.MyBillsEntityDataFactory(BaseTrafficType.getAuthRequestContext(p0), str4, "Not Received", ConfigType.ASYNC);
                            observableEmitter3.onError(new SplitNull(str4));
                        }
                    }

                    @Override // id.dana.lib.toggle.ToggleCallback
                    public final void onError() {
                        baseTrafficType2.MyBillsEntityDataFactory("", str2, "Not Received", ConfigType.ASYNC);
                        observableEmitter.onError(new SplitException("Error when get toggle config"));
                    }
                }, BaseTrafficType.this.getAuthRequestContext);
            }
        });
        Intrinsics.checkNotNullExpressionValue(create, "");
        Observable observable = create;
        int i = NetworkUserEntityData$$ExternalSyntheticLambda0 + 105;
        lookAheadTest = i % 128;
        if ((i % 2 != 0 ? Typography.amp : 'b') != '&') {
            return observable;
        }
        int i2 = 12 / 0;
        return observable;
    }

    @Override // id.dana.mybills.data.repository.source.MyBillsEntityData
    public final Flow<CumulateDueDatePaylaterResult> getAuthRequestContext(CumulateDueDatePaylaterRequest p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        throw new UnsupportedOperationException();
    }

    private static void a(int i, byte[] bArr, char[] cArr, int[] iArr, Object[] objArr) {
        int i2;
        int i3;
        int i4;
        int length;
        char[] cArr2;
        BottomSheetCardBindingView$watcherCardNumberView$1 bottomSheetCardBindingView$watcherCardNumberView$1 = new BottomSheetCardBindingView$watcherCardNumberView$1();
        char[] cArr3 = BuiltInFictitiousFunctionClassFactory;
        if (cArr3 != null) {
            int i5 = $10 + 63;
            $11 = i5 % 128;
            if (!(i5 % 2 == 0)) {
                length = cArr3.length;
                cArr2 = new char[length];
            } else {
                length = cArr3.length;
                cArr2 = new char[length];
            }
            for (int i6 = 0; i6 < length; i6++) {
                int i7 = $11 + 33;
                $10 = i7 % 128;
                int i8 = i7 % 2;
                cArr2[i6] = (char) (cArr3[i6] ^ 4571606982258105150L);
            }
            cArr3 = cArr2;
        }
        int i9 = (int) (4571606982258105150L ^ KClassImpl$Data$declaredNonStaticMembers$2);
        boolean z = MyBillsEntityDataFactory;
        char c = Typography.less;
        if ((z ? (char) 25 : Typography.less) != '<') {
            bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult = bArr.length;
            char[] cArr4 = new char[bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult];
            bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory = 0;
            int i10 = $10 + 37;
            $11 = i10 % 128;
            int i11 = i10 % 2;
            while (bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory < bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult) {
                int i12 = $10 + 45;
                $11 = i12 % 128;
                if (i12 % 2 == 0) {
                    cArr4[bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory] = (char) (cArr3[bArr[(bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult * 1) >> bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory] - i] % i9);
                    i4 = bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory >> 0;
                } else {
                    cArr4[bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory] = (char) (cArr3[bArr[(bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult - 1) - bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory] + i] - i9);
                    i4 = bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory + 1;
                }
                bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory = i4;
            }
            objArr[0] = new String(cArr4);
            return;
        }
        if (!PlaceComponentResult) {
            c = '4';
        }
        if (c == '4') {
            try {
                bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult = iArr.length;
                char[] cArr5 = new char[bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult];
                bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory = 0;
                while (bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory < bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult) {
                    int i13 = $10 + 9;
                    $11 = i13 % 128;
                    if (i13 % 2 == 0) {
                        cArr5[bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory] = (char) (cArr3[iArr[(bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult % 0) << bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory] % i] - i9);
                        i2 = bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory >> 0;
                    } else {
                        cArr5[bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory] = (char) (cArr3[iArr[(bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult - 1) - bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory] - i] - i9);
                        i2 = bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory + 1;
                    }
                    bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory = i2;
                }
                objArr[0] = new String(cArr5);
                return;
            } catch (Exception e) {
                throw e;
            }
        }
        bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult = cArr.length;
        char[] cArr6 = new char[bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult];
        bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory = 0;
        while (true) {
            if (bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory >= bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult) {
                objArr[0] = new String(cArr6);
                return;
            }
            int i14 = $11 + 47;
            $10 = i14 % 128;
            if (!(i14 % 2 == 0)) {
                cArr6[bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory] = (char) (cArr3[cArr[(bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult << 0) << bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory] >>> i] >> i9);
                i3 = bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory >>> 1;
            } else {
                cArr6[bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory] = (char) (cArr3[cArr[(bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult - 1) - bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory] - i] - i9);
                i3 = bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory + 1;
            }
            bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory = i3;
        }
    }
}
