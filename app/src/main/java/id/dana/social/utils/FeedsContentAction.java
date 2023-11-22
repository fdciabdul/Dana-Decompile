package id.dana.social.utils;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.huawei.hms.framework.common.ContainerUtils;
import dagger.Lazy;
import id.dana.analytics.tracker.TrackerKey;
import id.dana.cashier.CashierEventHandler;
import id.dana.contract.deeplink.DeepLinkContract;
import id.dana.contract.deeplink.DeepLinkObserver;
import id.dana.contract.deeplink.tracker.DeeplinkTracker;
import id.dana.contract.deeplink.util.SourceParamUtil;
import id.dana.danah5.DanaH5;
import id.dana.danah5.share.ShareToFeedBridge;
import id.dana.data.constant.DanaUrl;
import id.dana.data.dynamicurl.DynamicUrlWrapper;
import id.dana.domain.core.usecase.BaseUseCase;
import id.dana.domain.core.usecase.NoParams;
import id.dana.domain.deeplink.interactor.ReadDeepLinkProperties;
import id.dana.domain.featureconfig.interactor.GetDealsConfig;
import id.dana.domain.featureconfig.model.DealsConfig;
import id.dana.domain.paylater.interactor.GetUserLoanInfo;
import id.dana.domain.paylater.model.LoanInfo;
import id.dana.domain.paylater.model.UserLoanInfo;
import id.dana.lazada.LazadaGuideActivity;
import id.dana.mapper.DeepLinkPayloadModelMapper;
import id.dana.notification.RedirectType;
import id.dana.sendmoney.summary.SummaryActivity;
import id.dana.utils.UrlUtil;
import id.dana.utils.danah5.DanaH5Listener;
import java.util.Arrays;
import java.util.HashMap;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.StringsKt;
import net.sqlcipher.database.SQLiteDatabase;

@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 /2\u00020\u0001:\u0001/B\u0081\u0001\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0016\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020$0\u0012\u0012\f\u0010&\u001a\b\u0012\u0004\u0012\u00020%0\u0012\u0012\f\u0010'\u001a\b\u0012\u0004\u0012\u00020\u001b0\u0012\u0012\f\u0010(\u001a\b\u0012\u0004\u0012\u00020\u001d0\u0012\u0012\f\u0010)\u001a\b\u0012\u0004\u0012\u00020\u001f0\u0012\u0012\f\u0010*\u001a\b\u0012\u0004\u0012\u00020\"0\u0012\u0012\f\u0010+\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012\u0012\f\u0010,\u001a\b\u0012\u0004\u0012\u00020#0\u0012¢\u0006\u0004\b-\u0010.J\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u001d\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\b\u0010\tJ5\u0010\b\u001a\u00020\u00042&\u0010\u0003\u001a\"\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00020\nj\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u0002`\u000b¢\u0006\u0004\b\b\u0010\fJ\u0017\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\b\u0010\u0006J\u001f\u0010\r\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u001f\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0010\u0010\u0006R\u001a\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00130\u00128\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0014R\u0014\u0010\u0005\u001a\u00020\u00168\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\u0017R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00188\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u001a\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u001b0\u00128\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u0014R\u001a\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u001d0\u00128\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u0014R\u001a\u0010!\u001a\b\u0012\u0004\u0012\u00020\u001f0\u00128\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b \u0010\u0014R\u001a\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\"0\u00128\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0014R\u001a\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020#0\u00128\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b!\u0010\u0014R\u001a\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020$0\u00128\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0014R\u001a\u0010 \u001a\b\u0012\u0004\u0012\u00020%0\u00128\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u0014"}, d2 = {"Lid/dana/social/utils/FeedsContentAction;", "", "", "p0", "", "getAuthRequestContext", "(Ljava/lang/String;)V", "p1", "KClassImpl$Data$declaredNonStaticMembers$2", "(Ljava/lang/String;Ljava/lang/String;)V", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "(Ljava/util/HashMap;)V", "MyBillsEntityDataFactory", "(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;", "", "PlaceComponentResult", "(Ljava/lang/String;Ljava/lang/String;)Z", "Ldagger/Lazy;", "Lid/dana/cashier/CashierEventHandler;", "Ldagger/Lazy;", "BuiltInFictitiousFunctionClassFactory", "Landroid/content/Context;", "Landroid/content/Context;", "Lid/dana/domain/featureconfig/model/DealsConfig;", "NetworkUserEntityData$$ExternalSyntheticLambda0", "Lid/dana/domain/featureconfig/model/DealsConfig;", "Lid/dana/mapper/DeepLinkPayloadModelMapper;", "lookAheadTest", "Lid/dana/contract/deeplink/tracker/DeeplinkTracker;", "scheduleImpl", "Lid/dana/data/dynamicurl/DynamicUrlWrapper;", "moveToNextValue", "getErrorConfigVersion", "Lid/dana/domain/featureconfig/interactor/GetDealsConfig;", "Lid/dana/domain/paylater/interactor/GetUserLoanInfo;", "Lid/dana/domain/deeplink/interactor/ReadDeepLinkProperties;", "Lid/dana/contract/deeplink/DeepLinkContract$View;", "p2", "p3", "p4", "p5", "p6", "p7", "p8", "<init>", "(Landroid/content/Context;Ldagger/Lazy;Ldagger/Lazy;Ldagger/Lazy;Ldagger/Lazy;Ldagger/Lazy;Ldagger/Lazy;Ldagger/Lazy;Ldagger/Lazy;)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class FeedsContentAction {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    public final Lazy<GetDealsConfig> scheduleImpl;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    private final Context getAuthRequestContext;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    final Lazy<DeepLinkContract.View> moveToNextValue;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda0  reason: from kotlin metadata */
    private DealsConfig KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    public final Lazy<ReadDeepLinkProperties> NetworkUserEntityData$$ExternalSyntheticLambda0;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    private final Lazy<CashierEventHandler> BuiltInFictitiousFunctionClassFactory;

    /* renamed from: getErrorConfigVersion  reason: from kotlin metadata */
    private final Lazy<GetUserLoanInfo> lookAheadTest;

    /* renamed from: lookAheadTest  reason: from kotlin metadata */
    private final Lazy<DeepLinkPayloadModelMapper> MyBillsEntityDataFactory;

    /* renamed from: moveToNextValue  reason: from kotlin metadata */
    private final Lazy<DynamicUrlWrapper> getErrorConfigVersion;

    /* renamed from: scheduleImpl  reason: from kotlin metadata */
    private final Lazy<DeeplinkTracker> PlaceComponentResult;

    @Inject
    public FeedsContentAction(Context context, Lazy<ReadDeepLinkProperties> lazy, Lazy<DeepLinkContract.View> lazy2, Lazy<DeepLinkPayloadModelMapper> lazy3, Lazy<DeeplinkTracker> lazy4, Lazy<DynamicUrlWrapper> lazy5, Lazy<GetDealsConfig> lazy6, Lazy<CashierEventHandler> lazy7, Lazy<GetUserLoanInfo> lazy8) {
        Intrinsics.checkNotNullParameter(context, "");
        Intrinsics.checkNotNullParameter(lazy, "");
        Intrinsics.checkNotNullParameter(lazy2, "");
        Intrinsics.checkNotNullParameter(lazy3, "");
        Intrinsics.checkNotNullParameter(lazy4, "");
        Intrinsics.checkNotNullParameter(lazy5, "");
        Intrinsics.checkNotNullParameter(lazy6, "");
        Intrinsics.checkNotNullParameter(lazy7, "");
        Intrinsics.checkNotNullParameter(lazy8, "");
        this.getAuthRequestContext = context;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = lazy;
        this.moveToNextValue = lazy2;
        this.MyBillsEntityDataFactory = lazy3;
        this.PlaceComponentResult = lazy4;
        this.getErrorConfigVersion = lazy5;
        this.scheduleImpl = lazy6;
        this.BuiltInFictitiousFunctionClassFactory = lazy7;
        this.lookAheadTest = lazy8;
        GetDealsConfig getDealsConfig = lazy6.get();
        Intrinsics.checkNotNullExpressionValue(getDealsConfig, "");
        BaseUseCase.execute$default(getDealsConfig, NoParams.INSTANCE, new Function1<DealsConfig, Unit>() { // from class: id.dana.social.utils.FeedsContentAction$fetchDealsConfig$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(DealsConfig dealsConfig) {
                invoke2(dealsConfig);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(DealsConfig dealsConfig) {
                Intrinsics.checkNotNullParameter(dealsConfig, "");
                FeedsContentAction.this.KClassImpl$Data$declaredNonStaticMembers$2 = dealsConfig;
            }
        }, null, 4, null);
    }

    public final void KClassImpl$Data$declaredNonStaticMembers$2(String p0, String p1) {
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p1, "");
        String MyBillsEntityDataFactory = MyBillsEntityDataFactory(p0, p1);
        if (Intrinsics.areEqual(p0, "INNER_URL") && StringsKt.contains$default((CharSequence) MyBillsEntityDataFactory, (CharSequence) DanaUrl.DANA_CICIL, false, 2, (Object) null)) {
            KClassImpl$Data$declaredNonStaticMembers$2(MyBillsEntityDataFactory);
        } else {
            getAuthRequestContext(MyBillsEntityDataFactory);
        }
    }

    public final void getAuthRequestContext(String p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        this.moveToNextValue.get().showProgress();
        if (p0.length() == 0) {
            this.moveToNextValue.get().dismissProgress();
        } else if (UrlUtil.getErrorConfigVersion(p0)) {
            this.NetworkUserEntityData$$ExternalSyntheticLambda0.get().execute(new DeepLinkObserver(this.moveToNextValue.get(), false, this.moveToNextValue.get().KClassImpl$Data$declaredNonStaticMembers$2(), this.MyBillsEntityDataFactory.get(), this.PlaceComponentResult.get()), ReadDeepLinkProperties.Params.INSTANCE.forLinkRead(p0));
        } else {
            Boolean PlaceComponentResult = UrlUtil.PlaceComponentResult(p0);
            Intrinsics.checkNotNullExpressionValue(PlaceComponentResult, "");
            if (PlaceComponentResult.booleanValue()) {
                PlaceComponentResult(p0);
                return;
            }
            if (SourceParamUtil.MyBillsEntityDataFactory(p0)) {
                p0 = SourceParamUtil.getAuthRequestContext(p0, "Feed");
            }
            String authRequestContext = UrlUtil.getAuthRequestContext(p0);
            Intrinsics.checkNotNullExpressionValue(authRequestContext, "");
            DanaH5.startContainerFullUrl(authRequestContext, new DanaH5Listener() { // from class: id.dana.social.utils.FeedsContentAction$getH5AppListener$1
                @Override // id.dana.utils.danah5.DanaH5Listener
                public final void onContainerDestroyed(Bundle p02) {
                }

                @Override // id.dana.utils.danah5.DanaH5Listener
                public final void onContainerCreated(Bundle p02) {
                    FeedsContentAction.this.moveToNextValue.get().dismissProgress();
                }
            });
        }
    }

    public final void KClassImpl$Data$declaredNonStaticMembers$2(HashMap<String, String> p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        String str = p0.get("redirectType");
        if (str == null) {
            str = "";
        }
        Intrinsics.checkNotNullExpressionValue(str, "");
        String str2 = p0.get(ShareToFeedBridge.REDIRECT_VALUE);
        if (str2 == null) {
            str2 = "";
        }
        Intrinsics.checkNotNullExpressionValue(str2, "");
        if (!PlaceComponentResult(str, str2)) {
            String MyBillsEntityDataFactory = MyBillsEntityDataFactory(str, str2);
            if (Intrinsics.areEqual(str, "INNER_URL") && StringsKt.contains$default((CharSequence) MyBillsEntityDataFactory, (CharSequence) DanaUrl.DANA_CICIL, false, 2, (Object) null)) {
                KClassImpl$Data$declaredNonStaticMembers$2(MyBillsEntityDataFactory);
                return;
            } else {
                getAuthRequestContext(MyBillsEntityDataFactory);
                return;
            }
        }
        Context context = this.getAuthRequestContext;
        Intent createIntent = LazadaGuideActivity.createIntent(context);
        createIntent.setFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
        context.startActivity(createIntent);
    }

    private static boolean PlaceComponentResult(String p0, String p1) {
        return Intrinsics.areEqual(p0, "ipgRegistration") && Intrinsics.areEqual(p1, "lazada");
    }

    private final String MyBillsEntityDataFactory(String p0, String p1) {
        switch (p0.hashCode()) {
            case -2035039290:
                if (p0.equals("INNER_URL")) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("https://m.dana.id");
                    sb.append(p1);
                    return sb.toString();
                }
                return p1;
            case -805752590:
                if (p0.equals("TRANSACTION_DETAIL")) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("https://m.dana.id");
                    StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                    String format = String.format(DanaUrl.TRANSACTION_DETAIL, Arrays.copyOf(new Object[]{p1}, 1));
                    Intrinsics.checkNotNullExpressionValue(format, "");
                    sb2.append(format);
                    return sb2.toString();
                }
                return p1;
            case 66575:
                if (p0.equals("CDP")) {
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append("https://m.dana.id");
                    StringCompanionObject stringCompanionObject2 = StringCompanionObject.INSTANCE;
                    String format2 = String.format(DanaUrl.CDP_DETAIL, Arrays.copyOf(new Object[]{p1}, 1));
                    Intrinsics.checkNotNullExpressionValue(format2, "");
                    sb3.append(format2);
                    return sb3.toString();
                }
                return p1;
            case 64919911:
                if (p0.equals(RedirectType.DEALS)) {
                    DealsConfig dealsConfig = this.KClassImpl$Data$declaredNonStaticMembers$2;
                    String danaDealsUrl = dealsConfig != null ? dealsConfig.getDanaDealsUrl() : null;
                    if (danaDealsUrl == null || danaDealsUrl.length() == 0) {
                        return "";
                    }
                    StringBuilder sb4 = new StringBuilder();
                    sb4.append("https://m.dana.id");
                    sb4.append("/");
                    DealsConfig dealsConfig2 = this.KClassImpl$Data$declaredNonStaticMembers$2;
                    Intrinsics.checkNotNull(dealsConfig2);
                    sb4.append(dealsConfig2.getDanaDealsUrl());
                    sb4.append(DanaUrl.DANA_DEALS_VOUCHER_DETAIL_PATH);
                    String obj = sb4.toString();
                    Intrinsics.checkNotNullExpressionValue(obj, "");
                    String authRequestContext = UrlUtil.getAuthRequestContext(obj, MapsKt.mapOf(new Pair("voucherV2", SummaryActivity.CHECKED), new Pair("goodsId", p1), new Pair(DanaUrl.EXPRESS_PURCHASE_PARAM, SummaryActivity.CHECKED), new Pair("returnHome", "false")));
                    Intrinsics.checkNotNullExpressionValue(authRequestContext, "");
                    return authRequestContext;
                }
                return p1;
            case 191796002:
                if (p0.equals("VOUCHER_DETAIL")) {
                    StringCompanionObject stringCompanionObject3 = StringCompanionObject.INSTANCE;
                    String voucherDetail = this.getErrorConfigVersion.get().getVoucherDetail();
                    Intrinsics.checkNotNullExpressionValue(voucherDetail, "");
                    String format3 = String.format(voucherDetail, Arrays.copyOf(new Object[]{p1}, 1));
                    Intrinsics.checkNotNullExpressionValue(format3, "");
                    return format3;
                }
                return p1;
            case 1411860198:
                if (p0.equals("DEEPLINK")) {
                    String KClassImpl$Data$declaredNonStaticMembers$2 = UrlUtil.KClassImpl$Data$declaredNonStaticMembers$2(p1);
                    Intrinsics.checkNotNullExpressionValue(KClassImpl$Data$declaredNonStaticMembers$2, "");
                    return KClassImpl$Data$declaredNonStaticMembers$2;
                }
                return p1;
            default:
                return p1;
        }
    }

    private final void KClassImpl$Data$declaredNonStaticMembers$2(String p0) {
        String authRequestContext = UrlUtil.getAuthRequestContext(p0, "Inbox");
        Intrinsics.checkNotNullExpressionValue(authRequestContext, "");
        UserLoanInfo execute = this.lookAheadTest.get().execute(new GetUserLoanInfo.Params(LoanInfo.LOAN_PERSONAL));
        String KClassImpl$Data$declaredNonStaticMembers$2 = UrlUtil.KClassImpl$Data$declaredNonStaticMembers$2(execute, authRequestContext);
        Intrinsics.checkNotNullExpressionValue(KClassImpl$Data$declaredNonStaticMembers$2, "");
        String KClassImpl$Data$declaredNonStaticMembers$22 = UrlUtil.KClassImpl$Data$declaredNonStaticMembers$2(execute, KClassImpl$Data$declaredNonStaticMembers$2);
        Intrinsics.checkNotNullExpressionValue(KClassImpl$Data$declaredNonStaticMembers$22, "");
        getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$22);
    }

    private final void PlaceComponentResult(String p0) {
        CashierEventHandler cashierEventHandler = this.BuiltInFictitiousFunctionClassFactory.get();
        Context context = this.getAuthRequestContext;
        Intrinsics.checkNotNullParameter(context, "");
        Intrinsics.checkNotNullParameter(p0, "");
        cashierEventHandler.getAuthRequestContext = context;
        cashierEventHandler.MyBillsEntityDataFactory = StringsKt.replace$default(p0, "&amp;", ContainerUtils.FIELD_DELIMITER, false, 4, (Object) null);
        cashierEventHandler.KClassImpl$Data$declaredNonStaticMembers$2 = TrackerKey.SourceType.INBOX_PAGE;
        cashierEventHandler.PlaceComponentResult = false;
        cashierEventHandler.PlaceComponentResult();
        this.moveToNextValue.get().dismissProgress();
    }
}
