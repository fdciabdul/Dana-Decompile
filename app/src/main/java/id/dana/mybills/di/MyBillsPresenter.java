package id.dana.mybills.di;

import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.ViewConfiguration;
import dagger.Lazy;
import id.dana.data.config.DeviceInformationProvider;
import id.dana.domain.core.usecase.BaseUseCase;
import id.dana.domain.mybills.interactor.CheckSplitService;
import id.dana.domain.mybills.interactor.GetBizProductOrder;
import id.dana.domain.mybills.interactor.GetHighlightPayTransaction;
import id.dana.domain.mybills.interactor.GetInquirySubscriptionPaylaterWithDestination;
import id.dana.domain.mybills.interactor.GetListHighlightMyBills;
import id.dana.domain.mybills.interactor.GetMonthlyAmountMyBills;
import id.dana.domain.mybills.interactor.GetMonthlyWithConsultView;
import id.dana.domain.mybills.interactor.GetQuickBuyMyBills;
import id.dana.domain.mybills.model.BizProduct;
import id.dana.domain.mybills.model.BizProductDestination;
import id.dana.domain.mybills.model.BizProductDestinationKt;
import id.dana.domain.mybills.model.BizProductOrder;
import id.dana.domain.mybills.model.HighlightTransactionPay;
import id.dana.domain.mybills.model.MonthlyAmountAndHighlightRequest;
import id.dana.domain.mybills.model.MonthlyAmountWithConsultView;
import id.dana.domain.mybills.model.MyBillsMonthlyAmount;
import id.dana.domain.user.CurrencyAmount;
import id.dana.domain.user.interactor.GetSingleBalance;
import id.dana.model.CurrencyAmountModel;
import id.dana.mybills.di.MyBillsContract;
import id.dana.mybills.mapper.BizProductModelMapperKt;
import id.dana.mybills.mapper.BizProductOrderModelMapperKt;
import id.dana.mybills.mapper.BizProductOrderRequestMapperKt;
import id.dana.mybills.model.BillSubscriptionHighlightModel;
import id.dana.mybills.model.BizProductModel;
import id.dana.mybills.model.HighlightTransactionPayModelKt;
import id.dana.mybills.model.HighlightTransactionPayRequestModel;
import id.dana.mybills.model.HighlightTransactionPayRequestModelKt;
import id.dana.mybills.model.MonthlyHighlightBillModelKt;
import id.dana.nearbyme.merchantdetail.model.MoneyViewModel;
import id.dana.sendmoney.mapper.CurrencyAmountModelMapper;
import id.dana.statement.view.StatementDateView;
import id.dana.utils.DateTimeUtil;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0082\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\u0018\u0000 ;2\u00020\u0001:\u0001;B¥\u0001\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020-\u0012\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u001d0\u0018\u0012\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020&0\u0018\u0012\f\u00100\u001a\b\u0012\u0004\u0012\u00020\u001f0\u0018\u0012\f\u00101\u001a\b\u0012\u0004\u0012\u00020)0\u0018\u0012\f\u00102\u001a\b\u0012\u0004\u0012\u00020\u00190\u0018\u0012\f\u00103\u001a\b\u0012\u0004\u0012\u00020\u001e0\u0018\u0012\f\u00104\u001a\b\u0012\u0004\u0012\u00020 0\u0018\u0012\f\u00105\u001a\b\u0012\u0004\u0012\u00020*0\u0018\u0012\u0006\u00106\u001a\u00020\u001b\u0012\f\u00107\u001a\b\u0012\u0004\u0012\u00020'0\u0018\u0012\f\u00108\u001a\b\u0012\u0004\u0012\u00020#0\u0018¢\u0006\u0004\b9\u0010:J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\b\u0010\tJ\u001d\u0010\u0005\u001a\u00020\u00042\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0016¢\u0006\u0004\b\u0005\u0010\fJ'\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\rH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\b\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\b\u0010\u0015J\u000f\u0010\u0013\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0013\u0010\u0015J\u000f\u0010\u0016\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0016\u0010\u0015J\u000f\u0010\u0017\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0017\u0010\u0015R\u001a\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00190\u00188\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u001aR\u0014\u0010\u0013\u001a\u00020\u001b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u001cR\u001a\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u001d0\u00188\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u001aR\u001a\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u001e0\u00188\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\u001aR\u001a\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u001f0\u00188\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u001aR\u001a\u0010\"\u001a\b\u0012\u0004\u0012\u00020 0\u00188\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b!\u0010\u001aR\u001a\u0010%\u001a\b\u0012\u0004\u0012\u00020#0\u00188\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b$\u0010\u001aR\u001a\u0010!\u001a\b\u0012\u0004\u0012\u00020&0\u00188\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b%\u0010\u001aR\u001a\u0010(\u001a\b\u0012\u0004\u0012\u00020'0\u00188\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\"\u0010\u001aR\u001a\u0010$\u001a\b\u0012\u0004\u0012\u00020)0\u00188\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b(\u0010\u001aR\u001a\u0010,\u001a\b\u0012\u0004\u0012\u00020*0\u00188\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b+\u0010\u001aR\u0014\u0010/\u001a\u00020-8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b,\u0010."}, d2 = {"Lid/dana/mybills/di/MyBillsPresenter;", "Lid/dana/mybills/di/MyBillsContract$Presenter;", "Lid/dana/mybills/model/BizProductModel;", "p0", "", "PlaceComponentResult", "(Lid/dana/mybills/model/BizProductModel;)V", "Lid/dana/mybills/model/HighlightTransactionPayRequestModel;", "MyBillsEntityDataFactory", "(Lid/dana/mybills/model/HighlightTransactionPayRequestModel;)V", "", "Lid/dana/mybills/model/BillSubscriptionHighlightModel;", "(Ljava/util/List;)V", "", "p1", "p2", "KClassImpl$Data$declaredNonStaticMembers$2", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "Lid/dana/domain/mybills/model/MonthlyAmountAndHighlightRequest;", "getAuthRequestContext", "(Lid/dana/domain/mybills/model/MonthlyAmountAndHighlightRequest;)V", "()V", "BuiltInFictitiousFunctionClassFactory", "onDestroy", "Ldagger/Lazy;", "Lid/dana/domain/mybills/interactor/CheckSplitService;", "Ldagger/Lazy;", "Lid/dana/sendmoney/mapper/CurrencyAmountModelMapper;", "Lid/dana/sendmoney/mapper/CurrencyAmountModelMapper;", "Lid/dana/data/config/DeviceInformationProvider;", "Lid/dana/domain/mybills/interactor/GetBizProductOrder;", "Lid/dana/domain/mybills/interactor/GetListHighlightMyBills;", "Lid/dana/domain/mybills/interactor/GetHighlightPayTransaction;", "lookAheadTest", "getErrorConfigVersion", "Lid/dana/domain/mybills/interactor/GetInquirySubscriptionPaylaterWithDestination;", "moveToNextValue", "scheduleImpl", "Lid/dana/domain/mybills/interactor/GetMonthlyAmountMyBills;", "Lid/dana/domain/mybills/interactor/GetMonthlyWithConsultView;", "NetworkUserEntityData$$ExternalSyntheticLambda0", "Lid/dana/domain/mybills/interactor/GetQuickBuyMyBills;", "Lid/dana/domain/user/interactor/GetSingleBalance;", "NetworkUserEntityData$$ExternalSyntheticLambda1", "GetContactSyncConfig", "Lid/dana/mybills/di/MyBillsContract$View;", "Lid/dana/mybills/di/MyBillsContract$View;", "DatabaseTableConfigUtil", "p3", "p4", "p5", "p6", "p7", "p8", "p9", "p10", "p11", "<init>", "(Lid/dana/mybills/di/MyBillsContract$View;Ldagger/Lazy;Ldagger/Lazy;Ldagger/Lazy;Ldagger/Lazy;Ldagger/Lazy;Ldagger/Lazy;Ldagger/Lazy;Ldagger/Lazy;Lid/dana/sendmoney/mapper/CurrencyAmountModelMapper;Ldagger/Lazy;Ldagger/Lazy;)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class MyBillsPresenter implements MyBillsContract.Presenter {
    private static int $10 = 0;
    private static int $11 = 1;
    private static int DatabaseTableConfigUtil = 0;
    private static int NetworkUserEntityData$$ExternalSyntheticLambda2 = 0;
    private static byte[] NetworkUserEntityData$$ExternalSyntheticLambda7 = null;
    private static short[] NetworkUserEntityData$$ExternalSyntheticLambda8 = null;
    private static int PrepareContext = 1;
    private static int initRecordTimeStamp;
    private static int newProxyInstance;

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    private final CurrencyAmountModelMapper getAuthRequestContext;

    /* renamed from: GetContactSyncConfig  reason: from kotlin metadata */
    private final MyBillsContract.View DatabaseTableConfigUtil;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    private final Lazy<CheckSplitService> MyBillsEntityDataFactory;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private final Lazy<GetBizProductOrder> KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda0  reason: from kotlin metadata */
    private final Lazy<GetQuickBuyMyBills> moveToNextValue;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda1  reason: from kotlin metadata */
    private final Lazy<GetSingleBalance> GetContactSyncConfig;
    private final Lazy<GetListHighlightMyBills> PlaceComponentResult;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    private final Lazy<DeviceInformationProvider> BuiltInFictitiousFunctionClassFactory;

    /* renamed from: getErrorConfigVersion  reason: from kotlin metadata */
    private final Lazy<GetMonthlyWithConsultView> NetworkUserEntityData$$ExternalSyntheticLambda0;

    /* renamed from: lookAheadTest  reason: from kotlin metadata */
    private final Lazy<GetHighlightPayTransaction> getErrorConfigVersion;

    /* renamed from: moveToNextValue  reason: from kotlin metadata */
    private final Lazy<GetInquirySubscriptionPaylaterWithDestination> scheduleImpl;

    /* renamed from: scheduleImpl  reason: from kotlin metadata */
    private final Lazy<GetMonthlyAmountMyBills> lookAheadTest;

    static {
        KClassImpl$Data$declaredNonStaticMembers$2();
        DefaultConstructorMarker defaultConstructorMarker = null;
        INSTANCE = new Companion(defaultConstructorMarker);
        int i = PrepareContext + 93;
        newProxyInstance = i % 128;
        if (!(i % 2 != 0)) {
            return;
        }
        defaultConstructorMarker.hashCode();
    }

    static void KClassImpl$Data$declaredNonStaticMembers$2() {
        NetworkUserEntityData$$ExternalSyntheticLambda2 = 1257195707;
        initRecordTimeStamp = 100742704;
        NetworkUserEntityData$$ExternalSyntheticLambda7 = new byte[]{109, 65, 74, 110, 70, 122, 65, 76, 114, 70, 124, 120, 76, 125, 113, 69, 125, 69, 76, 123, 114, 77};
        DatabaseTableConfigUtil = -377213486;
    }

    @Inject
    public MyBillsPresenter(MyBillsContract.View view, Lazy<DeviceInformationProvider> lazy, Lazy<GetMonthlyAmountMyBills> lazy2, Lazy<GetListHighlightMyBills> lazy3, Lazy<GetQuickBuyMyBills> lazy4, Lazy<CheckSplitService> lazy5, Lazy<GetBizProductOrder> lazy6, Lazy<GetHighlightPayTransaction> lazy7, Lazy<GetSingleBalance> lazy8, CurrencyAmountModelMapper currencyAmountModelMapper, Lazy<GetMonthlyWithConsultView> lazy9, Lazy<GetInquirySubscriptionPaylaterWithDestination> lazy10) {
        try {
            Intrinsics.checkNotNullParameter(view, "");
            try {
                Intrinsics.checkNotNullParameter(lazy, "");
                Intrinsics.checkNotNullParameter(lazy2, "");
                Intrinsics.checkNotNullParameter(lazy3, "");
                Intrinsics.checkNotNullParameter(lazy4, "");
                Intrinsics.checkNotNullParameter(lazy5, "");
                Intrinsics.checkNotNullParameter(lazy6, "");
                Intrinsics.checkNotNullParameter(lazy7, "");
                Intrinsics.checkNotNullParameter(lazy8, "");
                Intrinsics.checkNotNullParameter(currencyAmountModelMapper, "");
                Intrinsics.checkNotNullParameter(lazy9, "");
                Intrinsics.checkNotNullParameter(lazy10, "");
                this.DatabaseTableConfigUtil = view;
                this.BuiltInFictitiousFunctionClassFactory = lazy;
                this.lookAheadTest = lazy2;
                this.PlaceComponentResult = lazy3;
                this.moveToNextValue = lazy4;
                this.MyBillsEntityDataFactory = lazy5;
                this.KClassImpl$Data$declaredNonStaticMembers$2 = lazy6;
                this.getErrorConfigVersion = lazy7;
                this.GetContactSyncConfig = lazy8;
                this.getAuthRequestContext = currencyAmountModelMapper;
                this.NetworkUserEntityData$$ExternalSyntheticLambda0 = lazy9;
                this.scheduleImpl = lazy10;
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    public static final /* synthetic */ CurrencyAmountModelMapper BuiltInFictitiousFunctionClassFactory(MyBillsPresenter myBillsPresenter) {
        try {
            int i = PrepareContext + 55;
            newProxyInstance = i % 128;
            int i2 = i % 2;
            CurrencyAmountModelMapper currencyAmountModelMapper = myBillsPresenter.getAuthRequestContext;
            int i3 = newProxyInstance + 111;
            PrepareContext = i3 % 128;
            int i4 = i3 % 2;
            return currencyAmountModelMapper;
        } catch (Exception e) {
            throw e;
        }
    }

    public static final /* synthetic */ MyBillsContract.View MyBillsEntityDataFactory(MyBillsPresenter myBillsPresenter) {
        int i = PrepareContext + 9;
        newProxyInstance = i % 128;
        boolean z = i % 2 == 0;
        MyBillsContract.View view = myBillsPresenter.DatabaseTableConfigUtil;
        if (!z) {
            Object[] objArr = null;
            int length = objArr.length;
        }
        int i2 = newProxyInstance + 97;
        PrepareContext = i2 % 128;
        int i3 = i2 % 2;
        return view;
    }

    public static final /* synthetic */ Lazy getAuthRequestContext(MyBillsPresenter myBillsPresenter) {
        Lazy<GetQuickBuyMyBills> lazy;
        try {
            int i = newProxyInstance + 47;
            PrepareContext = i % 128;
            if (!(i % 2 == 0)) {
                lazy = myBillsPresenter.moveToNextValue;
            } else {
                lazy = myBillsPresenter.moveToNextValue;
                Object obj = null;
                obj.hashCode();
            }
            int i2 = newProxyInstance + 9;
            PrepareContext = i2 % 128;
            if (!(i2 % 2 != 0)) {
                int i3 = 2 / 0;
                return lazy;
            }
            return lazy;
        } catch (Exception e) {
            throw e;
        }
    }

    @Override // id.dana.mybills.di.MyBillsContract.Presenter
    public final void KClassImpl$Data$declaredNonStaticMembers$2(String p0, String p1, String p2) {
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p1, "");
        Intrinsics.checkNotNullParameter(p2, "");
        this.DatabaseTableConfigUtil.showProgress();
        this.lookAheadTest.get().execute(new GetMonthlyAmountMyBills.Params(p0, p1, p2), new Function1<MyBillsMonthlyAmount, Unit>() { // from class: id.dana.mybills.di.MyBillsPresenter$getMonthlyAmountMyBills$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(MyBillsMonthlyAmount myBillsMonthlyAmount) {
                invoke2(myBillsMonthlyAmount);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(MyBillsMonthlyAmount myBillsMonthlyAmount) {
                Intrinsics.checkNotNullParameter(myBillsMonthlyAmount, "");
                MyBillsPresenter.MyBillsEntityDataFactory(MyBillsPresenter.this).dismissProgress();
                MyBillsPresenter.MyBillsEntityDataFactory(MyBillsPresenter.this).BuiltInFictitiousFunctionClassFactory(myBillsMonthlyAmount);
            }
        }, new Function1<Throwable, Unit>() { // from class: id.dana.mybills.di.MyBillsPresenter$getMonthlyAmountMyBills$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                invoke2(th);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable th) {
                Intrinsics.checkNotNullParameter(th, "");
                MyBillsPresenter.MyBillsEntityDataFactory(MyBillsPresenter.this).dismissProgress();
                MyBillsPresenter.MyBillsEntityDataFactory(MyBillsPresenter.this).onError(th.getMessage());
            }
        });
        int i = newProxyInstance + 31;
        PrepareContext = i % 128;
        int i2 = i % 2;
    }

    @Override // id.dana.mybills.di.MyBillsContract.Presenter
    public final void MyBillsEntityDataFactory() {
        this.DatabaseTableConfigUtil.showProgress();
        CheckSplitService checkSplitService = this.MyBillsEntityDataFactory.get();
        Object[] objArr = new Object[1];
        a(TextUtils.indexOf((CharSequence) "", '0', 0) + 1553242804, (-36) - (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)), (short) (33 - (ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1))), Drawable.resolveOpacity(0, 0) - 1290698300, (byte) (ViewConfiguration.getPressedStateDuration() >> 16), objArr);
        checkSplitService.execute(((String) objArr[0]).intern(), new Function1<Boolean, Unit>() { // from class: id.dana.mybills.di.MyBillsPresenter$getQuickBuySubscription$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* synthetic */ Unit invoke(Boolean bool) {
                invoke(bool.booleanValue());
                return Unit.INSTANCE;
            }

            public final void invoke(boolean z) {
                if (z) {
                    MyBillsPresenter.MyBillsEntityDataFactory(MyBillsPresenter.this).KClassImpl$Data$declaredNonStaticMembers$2();
                    GetQuickBuyMyBills getQuickBuyMyBills = (GetQuickBuyMyBills) MyBillsPresenter.getAuthRequestContext(MyBillsPresenter.this).get();
                    GetQuickBuyMyBills.Params params = new GetQuickBuyMyBills.Params(CollectionsKt.listOf("MOBILE_RECHARGE_PHONE_NUMBER_LIST"));
                    final MyBillsPresenter myBillsPresenter = MyBillsPresenter.this;
                    Function1<List<? extends BizProduct>, Unit> function1 = new Function1<List<? extends BizProduct>, Unit>() { // from class: id.dana.mybills.di.MyBillsPresenter$getQuickBuySubscription$1.1
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public final /* bridge */ /* synthetic */ Unit invoke(List<? extends BizProduct> list) {
                            invoke2((List<BizProduct>) list);
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke  reason: avoid collision after fix types in other method */
                        public final void invoke2(List<BizProduct> list) {
                            Intrinsics.checkNotNullParameter(list, "");
                            MyBillsPresenter.MyBillsEntityDataFactory(MyBillsPresenter.this).dismissProgress();
                            MyBillsPresenter.MyBillsEntityDataFactory(MyBillsPresenter.this).PlaceComponentResult(BizProductModelMapperKt.BuiltInFictitiousFunctionClassFactory(list));
                        }
                    };
                    final MyBillsPresenter myBillsPresenter2 = MyBillsPresenter.this;
                    getQuickBuyMyBills.execute(params, function1, new Function1<Throwable, Unit>() { // from class: id.dana.mybills.di.MyBillsPresenter$getQuickBuySubscription$1.2
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public final /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                            invoke2(th);
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke  reason: avoid collision after fix types in other method */
                        public final void invoke2(Throwable th) {
                            Intrinsics.checkNotNullParameter(th, "");
                            MyBillsPresenter.MyBillsEntityDataFactory(MyBillsPresenter.this).dismissProgress();
                            MyBillsPresenter.MyBillsEntityDataFactory(MyBillsPresenter.this).onError(th.getMessage());
                        }
                    });
                    return;
                }
                MyBillsPresenter.MyBillsEntityDataFactory(MyBillsPresenter.this).dismissProgress();
                MyBillsPresenter.MyBillsEntityDataFactory(MyBillsPresenter.this).BuiltInFictitiousFunctionClassFactory();
            }
        }, new Function1<Throwable, Unit>() { // from class: id.dana.mybills.di.MyBillsPresenter$getQuickBuySubscription$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                invoke2(th);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable th) {
                Intrinsics.checkNotNullParameter(th, "");
                MyBillsPresenter.MyBillsEntityDataFactory(MyBillsPresenter.this).dismissProgress();
                MyBillsPresenter.MyBillsEntityDataFactory(MyBillsPresenter.this).onError(th.getMessage());
            }
        });
        int i = PrepareContext + 59;
        newProxyInstance = i % 128;
        int i2 = i % 2;
    }

    @Override // id.dana.mybills.di.MyBillsContract.Presenter
    public final void PlaceComponentResult(BizProductModel p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        this.DatabaseTableConfigUtil.showProgress();
        GetBizProductOrder getBizProductOrder = this.KClassImpl$Data$declaredNonStaticMembers$2.get();
        String deviceUUID = this.BuiltInFictitiousFunctionClassFactory.get().getDeviceUUID();
        Intrinsics.checkNotNullExpressionValue(deviceUUID, "");
        getBizProductOrder.execute(new GetBizProductOrder.Params(BizProductOrderRequestMapperKt.getAuthRequestContext(p0, "PULSA_PREPAID", deviceUUID)), new Function1<BizProductOrder, Unit>() { // from class: id.dana.mybills.di.MyBillsPresenter$getBizProductOrder$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(BizProductOrder bizProductOrder) {
                invoke2(bizProductOrder);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(BizProductOrder bizProductOrder) {
                Intrinsics.checkNotNullParameter(bizProductOrder, "");
                MyBillsPresenter.MyBillsEntityDataFactory(MyBillsPresenter.this).dismissProgress();
                MyBillsPresenter.MyBillsEntityDataFactory(MyBillsPresenter.this).MyBillsEntityDataFactory(BizProductOrderModelMapperKt.KClassImpl$Data$declaredNonStaticMembers$2(bizProductOrder));
            }
        }, new Function1<Throwable, Unit>() { // from class: id.dana.mybills.di.MyBillsPresenter$getBizProductOrder$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                invoke2(th);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable th) {
                Intrinsics.checkNotNullParameter(th, "");
                MyBillsPresenter.MyBillsEntityDataFactory(MyBillsPresenter.this).dismissProgress();
                MyBillsPresenter.MyBillsEntityDataFactory(MyBillsPresenter.this).onError(th.getMessage());
            }
        });
        try {
            int i = PrepareContext + 5;
            newProxyInstance = i % 128;
            int i2 = i % 2;
        } catch (Exception e) {
            throw e;
        }
    }

    @Override // id.dana.mybills.di.MyBillsContract.Presenter
    public final void MyBillsEntityDataFactory(HighlightTransactionPayRequestModel p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        this.DatabaseTableConfigUtil.showProgress();
        this.getErrorConfigVersion.get().execute(new GetHighlightPayTransaction.Params(HighlightTransactionPayRequestModelKt.BuiltInFictitiousFunctionClassFactory(p0)), new Function1<HighlightTransactionPay, Unit>() { // from class: id.dana.mybills.di.MyBillsPresenter$getHighlightTransactionPay$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(HighlightTransactionPay highlightTransactionPay) {
                invoke2(highlightTransactionPay);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(HighlightTransactionPay highlightTransactionPay) {
                Intrinsics.checkNotNullParameter(highlightTransactionPay, "");
                MyBillsPresenter.MyBillsEntityDataFactory(MyBillsPresenter.this).dismissProgress();
                MyBillsPresenter.MyBillsEntityDataFactory(MyBillsPresenter.this).BuiltInFictitiousFunctionClassFactory(HighlightTransactionPayModelKt.BuiltInFictitiousFunctionClassFactory(highlightTransactionPay));
            }
        }, new Function1<Throwable, Unit>() { // from class: id.dana.mybills.di.MyBillsPresenter$getHighlightTransactionPay$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                invoke2(th);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable th) {
                Intrinsics.checkNotNullParameter(th, "");
                MyBillsPresenter.MyBillsEntityDataFactory(MyBillsPresenter.this).dismissProgress();
                MyBillsPresenter.MyBillsEntityDataFactory(MyBillsPresenter.this).onError(th.getMessage());
            }
        });
        try {
            int i = PrepareContext + 33;
            try {
                newProxyInstance = i % 128;
                if (!(i % 2 == 0)) {
                    int i2 = 20 / 0;
                }
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    @Override // id.dana.mybills.di.MyBillsContract.Presenter
    public final void getAuthRequestContext(MonthlyAmountAndHighlightRequest p0) {
        try {
            Intrinsics.checkNotNullParameter(p0, "");
            try {
                this.DatabaseTableConfigUtil.showProgress();
                this.NetworkUserEntityData$$ExternalSyntheticLambda0.get().execute(p0, new Function1<MonthlyAmountWithConsultView, Unit>() { // from class: id.dana.mybills.di.MyBillsPresenter$getMonthlyWithConsultView$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final /* bridge */ /* synthetic */ Unit invoke(MonthlyAmountWithConsultView monthlyAmountWithConsultView) {
                        invoke2(monthlyAmountWithConsultView);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke  reason: avoid collision after fix types in other method */
                    public final void invoke2(MonthlyAmountWithConsultView monthlyAmountWithConsultView) {
                        Intrinsics.checkNotNullParameter(monthlyAmountWithConsultView, "");
                        MyBillsPresenter.MyBillsEntityDataFactory(MyBillsPresenter.this).dismissProgress();
                        MyBillsPresenter.MyBillsEntityDataFactory(MyBillsPresenter.this).KClassImpl$Data$declaredNonStaticMembers$2(monthlyAmountWithConsultView.getMyBillsMonthlyAmount(), MonthlyHighlightBillModelKt.KClassImpl$Data$declaredNonStaticMembers$2(monthlyAmountWithConsultView.getMyBillsHighlight()));
                    }
                }, new Function1<Throwable, Unit>() { // from class: id.dana.mybills.di.MyBillsPresenter$getMonthlyWithConsultView$2
                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                        invoke2(th);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke  reason: avoid collision after fix types in other method */
                    public final void invoke2(Throwable th) {
                        Intrinsics.checkNotNullParameter(th, "");
                        MyBillsPresenter.MyBillsEntityDataFactory(MyBillsPresenter.this).dismissProgress();
                        MyBillsPresenter.MyBillsEntityDataFactory(MyBillsPresenter.this).PlaceComponentResult(String.valueOf(th.getMessage()));
                    }
                });
                int i = PrepareContext + 49;
                newProxyInstance = i % 128;
                int i2 = i % 2;
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    @Override // id.dana.mybills.di.MyBillsContract.Presenter
    public final void BuiltInFictitiousFunctionClassFactory() {
        this.GetContactSyncConfig.get().execute(new GetSingleBalance.Param(true), new Function1<CurrencyAmount, Unit>() { // from class: id.dana.mybills.di.MyBillsPresenter$getUserBalance$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(CurrencyAmount currencyAmount) {
                invoke2(currencyAmount);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(CurrencyAmount currencyAmount) {
                Intrinsics.checkNotNullParameter(currencyAmount, "");
                CurrencyAmountModel apply = MyBillsPresenter.BuiltInFictitiousFunctionClassFactory(MyBillsPresenter.this).apply(currencyAmount);
                MyBillsContract.View MyBillsEntityDataFactory = MyBillsPresenter.MyBillsEntityDataFactory(MyBillsPresenter.this);
                Intrinsics.checkNotNullExpressionValue(apply, "");
                MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2(apply);
            }
        }, new Function1<Throwable, Unit>() { // from class: id.dana.mybills.di.MyBillsPresenter$getUserBalance$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                invoke2(th);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable th) {
                Intrinsics.checkNotNullParameter(th, "");
                MyBillsPresenter.MyBillsEntityDataFactory(MyBillsPresenter.this).onError(th.getMessage());
            }
        });
        try {
            int i = PrepareContext + 41;
            newProxyInstance = i % 128;
            if (i % 2 == 0) {
                return;
            }
            Object obj = null;
            obj.hashCode();
        } catch (Exception e) {
            throw e;
        }
    }

    @Override // id.dana.mybills.di.MyBillsContract.Presenter
    public final void getAuthRequestContext() {
        int i;
        int i2;
        String PlaceComponentResult = DateTimeUtil.PlaceComponentResult(StatementDateView.FULL_MONTH);
        i = Calendar.getInstance().get(2);
        Date MyBillsEntityDataFactory = DateTimeUtil.MyBillsEntityDataFactory(DateTimeUtil.BuiltInFictitiousFunctionClassFactory(i + 1, DateTimeUtil.moveToNextValue()));
        i2 = Calendar.getInstance().get(2);
        Date MyBillsEntityDataFactory2 = DateTimeUtil.MyBillsEntityDataFactory(DateTimeUtil.KClassImpl$Data$declaredNonStaticMembers$2(i2 + 1, DateTimeUtil.moveToNextValue()));
        StringBuilder sb = new StringBuilder();
        sb.append(DateTimeUtil.MyBillsEntityDataFactory(MyBillsEntityDataFactory, "dd MMM", Locale.getDefault()));
        sb.append(" - ");
        sb.append(DateTimeUtil.MyBillsEntityDataFactory(MyBillsEntityDataFactory2, "d MMM yyyy", Locale.getDefault()));
        String obj = sb.toString();
        MyBillsContract.View view = this.DatabaseTableConfigUtil;
        Intrinsics.checkNotNullExpressionValue(PlaceComponentResult, "");
        view.getAuthRequestContext(PlaceComponentResult, obj);
        int i3 = PrepareContext + 35;
        newProxyInstance = i3 % 128;
        int i4 = i3 % 2;
    }

    @Override // id.dana.mybills.di.MyBillsContract.Presenter
    public final void PlaceComponentResult(final List<BillSubscriptionHighlightModel> p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        GetInquirySubscriptionPaylaterWithDestination getInquirySubscriptionPaylaterWithDestination = this.scheduleImpl.get();
        Intrinsics.checkNotNullExpressionValue(getInquirySubscriptionPaylaterWithDestination, "");
        GetInquirySubscriptionPaylaterWithDestination getInquirySubscriptionPaylaterWithDestination2 = getInquirySubscriptionPaylaterWithDestination;
        List<BillSubscriptionHighlightModel> list = p0;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        Iterator<T> it = list.iterator();
        while (true) {
            if ((it.hasNext() ? 'W' : '6') == '6') {
                BaseUseCase.execute$default(getInquirySubscriptionPaylaterWithDestination2, arrayList, new Function1<List<? extends BizProductDestination>, Unit>() { // from class: id.dana.mybills.di.MyBillsPresenter$getInquirySubscriptionPaylaterWithDestination$2
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final /* bridge */ /* synthetic */ Unit invoke(List<? extends BizProductDestination> list2) {
                        invoke2((List<BizProductDestination>) list2);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke  reason: avoid collision after fix types in other method */
                    public final void invoke2(List<BizProductDestination> list2) {
                        Intrinsics.checkNotNullParameter(list2, "");
                        List<BillSubscriptionHighlightModel> list3 = p0;
                        ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list3, 10));
                        for (BillSubscriptionHighlightModel billSubscriptionHighlightModel : list3) {
                            arrayList2.add(BillSubscriptionHighlightModel.PlaceComponentResult(billSubscriptionHighlightModel, MoneyViewModel.BuiltInFictitiousFunctionClassFactory(billSubscriptionHighlightModel.GetContactSyncConfig, BizProductDestinationKt.findItemAndReturnAmount(list2, billSubscriptionHighlightModel.BuiltInFictitiousFunctionClassFactory, billSubscriptionHighlightModel.GetContactSyncConfig.PlaceComponentResult))));
                        }
                        MyBillsPresenter.MyBillsEntityDataFactory(this).MyBillsEntityDataFactory(arrayList2);
                    }
                }, null, 4, null);
                int i = PrepareContext + 19;
                newProxyInstance = i % 128;
                int i2 = i % 2;
                return;
            }
            int i3 = PrepareContext + 69;
            newProxyInstance = i3 % 128;
            int i4 = i3 % 2;
            BillSubscriptionHighlightModel billSubscriptionHighlightModel = (BillSubscriptionHighlightModel) it.next();
            String str = billSubscriptionHighlightModel.MyBillsEntityDataFactory;
            if (str == null) {
                str = "";
            }
            String str2 = billSubscriptionHighlightModel.BuiltInFictitiousFunctionClassFactory;
            if (!(str2 != null)) {
                str2 = "";
            }
            String str3 = billSubscriptionHighlightModel.NetworkUserEntityData$$ExternalSyntheticLambda0;
            if (!(str3 != null)) {
                str3 = "";
            } else {
                try {
                    int i5 = newProxyInstance + 31;
                    PrepareContext = i5 % 128;
                    if ((i5 % 2 == 0 ? '\'' : (char) 15) != 15) {
                        Object[] objArr = null;
                        int length = objArr.length;
                    } else {
                        continue;
                    }
                } catch (Exception e) {
                    throw e;
                }
            }
            arrayList.add(new GetInquirySubscriptionPaylaterWithDestination.Params(str, str2, str3, billSubscriptionHighlightModel.getPlaceComponentResult()));
        }
    }

    @Override // id.dana.base.AbstractContractKt.AbstractPresenter, id.dana.base.AbstractContract.AbstractPresenter
    public final void onDestroy() {
        int i = PrepareContext + 73;
        newProxyInstance = i % 128;
        int i2 = i % 2;
        this.lookAheadTest.get().dispose();
        this.PlaceComponentResult.get().dispose();
        this.moveToNextValue.get().dispose();
        this.MyBillsEntityDataFactory.get().dispose();
        this.KClassImpl$Data$declaredNonStaticMembers$2.get().dispose();
        this.getErrorConfigVersion.get().dispose();
        this.GetContactSyncConfig.get().dispose();
        this.NetworkUserEntityData$$ExternalSyntheticLambda0.get().dispose();
        this.scheduleImpl.get().dispose();
        try {
            int i3 = newProxyInstance + 55;
            PrepareContext = i3 % 128;
            int i4 = i3 % 2;
        } catch (Exception e) {
            throw e;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x003a, code lost:
    
        if (r2 != null) goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0042, code lost:
    
        if (r2 != null) goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0044, code lost:
    
        r10 = r2.length;
        r11 = new byte[r10];
        r2 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x004b, code lost:
    
        if (r2 >= r10) goto L26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x004d, code lost:
    
        r13 = '\r';
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0050, code lost:
    
        r13 = 31;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0052, code lost:
    
        if (r13 == '\r') goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0054, code lost:
    
        r2 = r11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0056, code lost:
    
        r11[r2] = (byte) (r9[r2] ^ 3097486228508854431L);
        r2 = r2 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0061, code lost:
    
        if (r2 == null) goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0074, code lost:
    
        r2 = (byte) (((byte) (id.dana.mybills.di.MyBillsPresenter.NetworkUserEntityData$$ExternalSyntheticLambda7[r14 + ((int) (id.dana.mybills.di.MyBillsPresenter.DatabaseTableConfigUtil ^ 3097486228508854431L))] ^ 3097486228508854431L)) + ((int) (id.dana.mybills.di.MyBillsPresenter.NetworkUserEntityData$$ExternalSyntheticLambda2 ^ 3097486228508854431L)));
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x007a, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x007b, code lost:
    
        throw r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x007c, code lost:
    
        r2 = (short) (((short) (id.dana.mybills.di.MyBillsPresenter.NetworkUserEntityData$$ExternalSyntheticLambda8[r14 + ((int) (id.dana.mybills.di.MyBillsPresenter.DatabaseTableConfigUtil ^ 3097486228508854431L))] ^ 3097486228508854431L)) + ((int) (id.dana.mybills.di.MyBillsPresenter.NetworkUserEntityData$$ExternalSyntheticLambda2 ^ 3097486228508854431L)));
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void a(int r14, int r15, short r16, int r17, byte r18, java.lang.Object[] r19) {
        /*
            Method dump skipped, instructions count: 394
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.mybills.di.MyBillsPresenter.a(int, int, short, int, byte, java.lang.Object[]):void");
    }
}
