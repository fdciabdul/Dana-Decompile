package id.dana.data.expresspurchase;

import android.text.TextUtils;
import com.alipay.iap.android.common.utils.MiscUtils;
import id.dana.cashier.data.repository.CashierEntityRepository$$ExternalSyntheticLambda10;
import id.dana.cashier.utils.CashierKeyParams;
import id.dana.data.account.repository.source.AccountEntityData;
import id.dana.data.account.repository.source.AccountEntityDataFactory;
import id.dana.data.config.DeviceInformationProvider;
import id.dana.data.config.model.PaylaterAgreementConfigResult;
import id.dana.data.config.source.ConfigEntityData;
import id.dana.data.config.source.ConfigEntityDataFactory;
import id.dana.data.constant.UrlParam;
import id.dana.data.content.mapper.SpaceResultMapper;
import id.dana.data.content.source.ContentDeliveryEntityData;
import id.dana.data.content.source.ContentDeliveryEntityDataFactory;
import id.dana.data.expresspurchase.mapper.DealsShopInfoMapperKt;
import id.dana.data.expresspurchase.mapper.ExpressPurchaseEntityRepositoryMapperKt;
import id.dana.data.expresspurchase.mapper.ExpressPurchasePaylaterConfigResultMapperKt;
import id.dana.data.expresspurchase.mapper.OrderQueryResultMapperKt;
import id.dana.data.expresspurchase.mapper.QuickBuyDealsResponseMapperKt;
import id.dana.data.expresspurchase.mapper.ValidateProductGoldMapperKt;
import id.dana.data.expresspurchase.model.ExpressPurchaseConfigResult;
import id.dana.data.expresspurchase.model.ExpressPurchasePaylaterConfigResult;
import id.dana.data.expresspurchase.model.ServiceEmasConfigResult;
import id.dana.data.expresspurchase.source.DealsExpressPurchaseData;
import id.dana.data.expresspurchase.source.DealsExpressPurchaseDataFactory;
import id.dana.data.expresspurchase.source.ExpressPurchaseEntityData;
import id.dana.data.expresspurchase.source.ExpressPurchaseEntityDataFactory;
import id.dana.data.expresspurchase.source.ExpressPurchaseOfferEntityData;
import id.dana.data.expresspurchase.source.ExpressPurchaseOfferEntityDataFactory;
import id.dana.data.expresspurchase.source.network.pojo.response.DealsQueryShopResponse;
import id.dana.data.expresspurchase.source.network.pojo.response.DealsShopInfoResponse;
import id.dana.data.expresspurchase.source.network.pojo.response.GetExpressPurchaseResponse;
import id.dana.data.expresspurchase.source.network.pojo.response.OrderQueryByConditionResponse;
import id.dana.data.expresspurchase.source.network.pojo.response.QuickBuyDealsResponse;
import id.dana.data.expresspurchase.source.network.pojo.response.QuickBuyResponse;
import id.dana.data.expresspurchase.source.network.pojo.response.ValidateProductQuickResponse;
import id.dana.data.expresspurchase.source.network.pojo.response.ValidateProductResponse;
import id.dana.data.paylater.mapper.PaylaterAgreementConfigResultMapperKt;
import id.dana.data.paylater.mapper.PaylaterHomeInfoResultMapperKt;
import id.dana.data.paylater.repository.PaylaterEntityData;
import id.dana.data.paylater.repository.PaylaterEntityDataFactory;
import id.dana.data.paylater.repository.source.network.result.PaylaterHomeInfoResult;
import id.dana.data.util.ConfigUtil;
import id.dana.domain.expresspurchase.interaction.model.AddonInfo;
import id.dana.domain.expresspurchase.interaction.model.DealsShopInfo;
import id.dana.domain.expresspurchase.interaction.model.ExpressPurchaseConfig;
import id.dana.domain.expresspurchase.interaction.model.ExpressPurchasePaylaterConfig;
import id.dana.domain.expresspurchase.interaction.model.GoldValidationInfo;
import id.dana.domain.expresspurchase.interaction.model.LatestExpressPurchaseAction;
import id.dana.domain.expresspurchase.interaction.model.OrderQueryResult;
import id.dana.domain.expresspurchase.interaction.model.QuickBuyDeals;
import id.dana.domain.expresspurchase.interaction.model.QuickBuyGold;
import id.dana.domain.expresspurchase.interaction.model.QuickBuyInsurance;
import id.dana.domain.expresspurchase.interaction.model.ServiceEmasConfig;
import id.dana.domain.expresspurchase.interaction.model.ValidateProduct;
import id.dana.domain.expresspurchase.repository.ExpressPurchaseRepository;
import id.dana.domain.paylater.model.PaylaterAgreementConfig;
import id.dana.domain.paylater.model.PaylaterHomeInfo;
import id.dana.domain.promotion.Space;
import id.dana.network.response.expresspurchase.ValidateProductGoldResponse;
import io.reactivex.Observable;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Function;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.ArrayIteratorKt;
import kotlin.jvm.internal.Intrinsics;

@Singleton
@Metadata(d1 = {"\u0000¢\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001BW\b\u0007\u0012\u0006\u0010[\u001a\u00020Z\u0012\u0006\u0010L\u001a\u00020K\u0012\u0006\u0010X\u001a\u00020W\u0012\b\u0010\u0083\u0001\u001a\u00030\u0082\u0001\u0012\u0006\u0010O\u001a\u00020N\u0012\u0006\u0010R\u001a\u00020Q\u0012\b\u0010\u0089\u0001\u001a\u00030\u0088\u0001\u0012\u0006\u0010U\u001a\u00020T\u0012\u0006\u0010^\u001a\u00020]¢\u0006\u0006\b\u0093\u0001\u0010\u0094\u0001J1\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\b\u0010\tJ%\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u00062\u0006\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u001d\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u00062\u0006\u0010\u000f\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u0015\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00130\u0006H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u0015\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00130\u0006H\u0016¢\u0006\u0004\b\u0016\u0010\u0015J\u0015\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00170\u0006H\u0016¢\u0006\u0004\b\u0018\u0010\u0015J%\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00062\u0006\u0010\n\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u001b\u0010\u000eJ\u0015\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001c0\u0006H\u0016¢\u0006\u0004\b\u001d\u0010\u0015J\u001d\u0010!\u001a\b\u0012\u0004\u0012\u00020 0\u00062\u0006\u0010\u001f\u001a\u00020\u001eH\u0016¢\u0006\u0004\b!\u0010\"J5\u0010'\u001a\b\u0012\u0004\u0012\u00020&0\u00062\u0006\u0010#\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010$\u001a\u00020\u00022\u0006\u0010%\u001a\u00020\u0002H\u0016¢\u0006\u0004\b'\u0010(JY\u0010.\u001a\b\u0012\u0004\u0012\u00020-0\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010$\u001a\u00020\u00022\u0012\u0010*\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020)2\u0006\u0010\u000b\u001a\u00020\u00022\u0006\u0010#\u001a\u00020\u00022\u0006\u0010+\u001a\u00020\u00022\u0006\u0010,\u001a\u00020\u0002H\u0016¢\u0006\u0004\b.\u0010/J9\u00101\u001a\b\u0012\u0004\u0012\u0002000\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010$\u001a\u00020\u00022\u0012\u0010*\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020)H\u0016¢\u0006\u0004\b1\u00102J\u0015\u00104\u001a\b\u0012\u0004\u0012\u0002030\u0006H\u0016¢\u0006\u0004\b4\u0010\u0015J+\u00109\u001a\b\u0012\u0004\u0012\u0002080\u00062\u0006\u00105\u001a\u00020\u00022\f\u00107\u001a\b\u0012\u0004\u0012\u00020\u000206H\u0016¢\u0006\u0004\b9\u0010:J%\u0010;\u001a\b\u0012\u0004\u0012\u00020\u001e0\u00062\u0006\u0010\n\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u0002H\u0016¢\u0006\u0004\b;\u0010\u000eJ\u001d\u0010<\u001a\b\u0012\u0004\u0012\u00020\u001e0\u00062\u0006\u0010\n\u001a\u00020\u0002H\u0016¢\u0006\u0004\b<\u0010\u0012JK\u0010B\u001a\b\u0012\u0004\u0012\u00020A0\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010=\u001a\u0004\u0018\u00010\u00022\b\u0010$\u001a\u0004\u0018\u00010\u00022\b\u0010>\u001a\u0004\u0018\u00010\u00022\u0006\u0010?\u001a\u00020\u00022\u0006\u0010@\u001a\u00020\u0002H\u0016¢\u0006\u0004\bB\u0010CJ?\u0010H\u001a\b\u0012\u0004\u0012\u00020G0\u00062\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010D\u001a\b\u0012\u0004\u0012\u00020\u0002062\u0012\u0010F\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020E0)H\u0016¢\u0006\u0004\bH\u0010IJ%\u0010J\u001a\b\u0012\u0004\u0012\u00020A0\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010$\u001a\u00020\u0002H\u0016¢\u0006\u0004\bJ\u0010\u000eR\u0014\u0010L\u001a\u00020K8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bL\u0010MR\u0014\u0010O\u001a\u00020N8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bO\u0010PR\u0014\u0010R\u001a\u00020Q8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bR\u0010SR\u0014\u0010U\u001a\u00020T8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bU\u0010VR\u0014\u0010X\u001a\u00020W8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bX\u0010YR\u0014\u0010[\u001a\u00020Z8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b[\u0010\\R\u0014\u0010^\u001a\u00020]8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b^\u0010_R\u001f\u0010e\u001a\u0006*\u00020`0`8CX\u0082\u0084\u0002¢\u0006\f\n\u0004\ba\u0010b\u001a\u0004\bc\u0010dR\u001b\u0010j\u001a\u00020f8CX\u0083\u0084\u0002¢\u0006\f\n\u0004\bg\u0010b\u001a\u0004\bh\u0010iR\u001f\u0010o\u001a\u0006*\u00020k0k8CX\u0083\u0084\u0002¢\u0006\f\n\u0004\bl\u0010b\u001a\u0004\bm\u0010nR\u001b\u0010t\u001a\u00020p8CX\u0083\u0084\u0002¢\u0006\f\n\u0004\bq\u0010b\u001a\u0004\br\u0010sR\u001b\u0010w\u001a\u00020f8CX\u0083\u0084\u0002¢\u0006\f\n\u0004\bu\u0010b\u001a\u0004\bv\u0010iR\u001b\u0010|\u001a\u00020x8CX\u0083\u0084\u0002¢\u0006\f\n\u0004\by\u0010b\u001a\u0004\bz\u0010{R\u001d\u0010\u0081\u0001\u001a\u00020}8CX\u0083\u0084\u0002¢\u0006\r\n\u0004\b~\u0010b\u001a\u0005\b\u007f\u0010\u0080\u0001R\u0018\u0010\u0083\u0001\u001a\u00030\u0082\u00018\u0002X\u0083\u0004¢\u0006\b\n\u0006\b\u0083\u0001\u0010\u0084\u0001R\u0017\u0010\u0087\u0001\u001a\u00020\u00028CX\u0082\u0004¢\u0006\b\u001a\u0006\b\u0085\u0001\u0010\u0086\u0001R\u0018\u0010\u0089\u0001\u001a\u00030\u0088\u00018\u0002X\u0083\u0004¢\u0006\b\n\u0006\b\u0089\u0001\u0010\u008a\u0001R%\u0010\u008f\u0001\u001a\b*\u00030\u008b\u00010\u008b\u00018CX\u0083\u0084\u0002¢\u0006\u000f\n\u0005\b\u008c\u0001\u0010b\u001a\u0006\b\u008d\u0001\u0010\u008e\u0001R\u001e\u0010\u0092\u0001\u001a\u00020f8CX\u0083\u0084\u0002¢\u0006\u000e\n\u0005\b\u0090\u0001\u0010b\u001a\u0005\b\u0091\u0001\u0010i"}, d2 = {"Lid/dana/data/expresspurchase/ExpressPurchaseEntityRepository;", "Lid/dana/domain/expresspurchase/repository/ExpressPurchaseRepository;", "", "goodsId", "latitude", "longitude", "Lio/reactivex/Observable;", "Lid/dana/domain/expresspurchase/interaction/model/DealsShopInfo;", "dealsQueryShopLocation", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lio/reactivex/Observable;", "addonId", CashierKeyParams.CASHIER_ORDER_ID, "Lid/dana/domain/expresspurchase/interaction/model/AddonInfo;", "getCashierAddonInfo", "(Ljava/lang/String;Ljava/lang/String;)Lio/reactivex/Observable;", "spaceCode", "Lid/dana/domain/promotion/Space;", "getExpressPurchaseCdpContent", "(Ljava/lang/String;)Lio/reactivex/Observable;", "Lid/dana/domain/expresspurchase/interaction/model/ExpressPurchaseConfig;", "getExpressPurchaseConfig", "()Lio/reactivex/Observable;", "getExpressPurchaseGoldConfig", "Lid/dana/domain/expresspurchase/interaction/model/ExpressPurchasePaylaterConfig;", "getExpressPurchasePaylaterConfig", "type", "Lid/dana/domain/expresspurchase/interaction/model/LatestExpressPurchaseAction;", "getLastExpressPurchaseAction", "Lid/dana/domain/paylater/model/PaylaterAgreementConfig;", "getPaylaterAgreementConfig", "", "skipBillInfo", "Lid/dana/domain/paylater/model/PaylaterHomeInfo;", "getPaylaterHomeInfo", "(Z)Lio/reactivex/Observable;", "epTemplateType", "aggregatorGoodsId", UrlParam.REQUEST_ID, "Lid/dana/domain/expresspurchase/interaction/model/QuickBuyDeals;", "getQuickBuyDeals", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lio/reactivex/Observable;", "", "extendInfo", "thirdRefId", "authCode", "Lid/dana/domain/expresspurchase/interaction/model/QuickBuyGold;", "getQuickBuyGold", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lio/reactivex/Observable;", "Lid/dana/domain/expresspurchase/interaction/model/QuickBuyInsurance;", "getQuickBuyInsurance", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;)Lio/reactivex/Observable;", "Lid/dana/domain/expresspurchase/interaction/model/ServiceEmasConfig;", "getServiceEmasConfig", "acquirementId", "", "tableSet", "Lid/dana/domain/expresspurchase/interaction/model/OrderQueryResult;", "orderQueryByCondition", "(Ljava/lang/String;Ljava/util/List;)Lio/reactivex/Observable;", "saveLastOfferCancelTransaction", "saveLastOfferSucceedTransaction", "aggregatorId", "finType", "bizOrderId", "merchantTransId", "Lid/dana/domain/expresspurchase/interaction/model/ValidateProduct;", "validateBundleProduct", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lio/reactivex/Observable;", "validationTypes", "", "validationInfo", "Lid/dana/domain/expresspurchase/interaction/model/GoldValidationInfo;", "validateGoldProduct", "(Ljava/lang/String;Ljava/util/List;Ljava/util/Map;)Lio/reactivex/Observable;", "validateStandaloneProduct", "Lid/dana/data/account/repository/source/AccountEntityDataFactory;", "accountEntityDataFactory", "Lid/dana/data/account/repository/source/AccountEntityDataFactory;", "Lid/dana/data/config/source/ConfigEntityDataFactory;", "configEntityDataFactory", "Lid/dana/data/config/source/ConfigEntityDataFactory;", "Lid/dana/data/content/source/ContentDeliveryEntityDataFactory;", "contentDeliveryEntityDataFactory", "Lid/dana/data/content/source/ContentDeliveryEntityDataFactory;", "Lid/dana/data/expresspurchase/source/DealsExpressPurchaseDataFactory;", "dealsExpressPurchaseDataFactory", "Lid/dana/data/expresspurchase/source/DealsExpressPurchaseDataFactory;", "Lid/dana/data/config/DeviceInformationProvider;", "deviceInformationProvider", "Lid/dana/data/config/DeviceInformationProvider;", "Lid/dana/data/expresspurchase/source/ExpressPurchaseEntityDataFactory;", "expressPurchaseEntityDataFactory", "Lid/dana/data/expresspurchase/source/ExpressPurchaseEntityDataFactory;", "Lid/dana/data/expresspurchase/source/ExpressPurchaseOfferEntityDataFactory;", "expressPurchaseOfferEntityDataFactory", "Lid/dana/data/expresspurchase/source/ExpressPurchaseOfferEntityDataFactory;", "Lid/dana/data/account/repository/source/AccountEntityData;", "localAccountEntityData$delegate", "Lkotlin/Lazy;", "getLocalAccountEntityData", "()Lid/dana/data/account/repository/source/AccountEntityData;", "localAccountEntityData", "Lid/dana/data/expresspurchase/source/ExpressPurchaseEntityData;", "localExpressPurchaseEntityData$delegate", "getLocalExpressPurchaseEntityData", "()Lid/dana/data/expresspurchase/source/ExpressPurchaseEntityData;", "localExpressPurchaseEntityData", "Lid/dana/data/content/source/ContentDeliveryEntityData;", "networkCdpEntityData$delegate", "getNetworkCdpEntityData", "()Lid/dana/data/content/source/ContentDeliveryEntityData;", "networkCdpEntityData", "Lid/dana/data/expresspurchase/source/DealsExpressPurchaseData;", "networkDealsExpressPurchaseData$delegate", "getNetworkDealsExpressPurchaseData", "()Lid/dana/data/expresspurchase/source/DealsExpressPurchaseData;", "networkDealsExpressPurchaseData", "networkExpressPurchaseEntityData$delegate", "getNetworkExpressPurchaseEntityData", "networkExpressPurchaseEntityData", "Lid/dana/data/expresspurchase/source/ExpressPurchaseOfferEntityData;", "networkExpressPurchaseOfferEntityData$delegate", "getNetworkExpressPurchaseOfferEntityData", "()Lid/dana/data/expresspurchase/source/ExpressPurchaseOfferEntityData;", "networkExpressPurchaseOfferEntityData", "Lid/dana/data/paylater/repository/PaylaterEntityData;", "networkPaylaterEntityData$delegate", "getNetworkPaylaterEntityData", "()Lid/dana/data/paylater/repository/PaylaterEntityData;", "networkPaylaterEntityData", "Lid/dana/data/paylater/repository/PaylaterEntityDataFactory;", "paylaterEntityDataFactory", "Lid/dana/data/paylater/repository/PaylaterEntityDataFactory;", "getRefUserId", "()Ljava/lang/String;", "refUserId", "Lid/dana/data/content/mapper/SpaceResultMapper;", "spaceRpcResultMapper", "Lid/dana/data/content/mapper/SpaceResultMapper;", "Lid/dana/data/config/source/ConfigEntityData;", "splitConfigEntityData$delegate", "getSplitConfigEntityData", "()Lid/dana/data/config/source/ConfigEntityData;", "splitConfigEntityData", "splitExpressPurchaseConfigData$delegate", "getSplitExpressPurchaseConfigData", "splitExpressPurchaseConfigData", "<init>", "(Lid/dana/data/expresspurchase/source/ExpressPurchaseEntityDataFactory;Lid/dana/data/account/repository/source/AccountEntityDataFactory;Lid/dana/data/config/DeviceInformationProvider;Lid/dana/data/paylater/repository/PaylaterEntityDataFactory;Lid/dana/data/config/source/ConfigEntityDataFactory;Lid/dana/data/content/source/ContentDeliveryEntityDataFactory;Lid/dana/data/content/mapper/SpaceResultMapper;Lid/dana/data/expresspurchase/source/DealsExpressPurchaseDataFactory;Lid/dana/data/expresspurchase/source/ExpressPurchaseOfferEntityDataFactory;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class ExpressPurchaseEntityRepository implements ExpressPurchaseRepository {
    private final AccountEntityDataFactory accountEntityDataFactory;
    private final ConfigEntityDataFactory configEntityDataFactory;
    private final ContentDeliveryEntityDataFactory contentDeliveryEntityDataFactory;
    private final DealsExpressPurchaseDataFactory dealsExpressPurchaseDataFactory;
    private final DeviceInformationProvider deviceInformationProvider;
    private final ExpressPurchaseEntityDataFactory expressPurchaseEntityDataFactory;
    private final ExpressPurchaseOfferEntityDataFactory expressPurchaseOfferEntityDataFactory;

    /* renamed from: localAccountEntityData$delegate  reason: from kotlin metadata */
    private final Lazy localAccountEntityData;

    /* renamed from: localExpressPurchaseEntityData$delegate  reason: from kotlin metadata */
    private final Lazy localExpressPurchaseEntityData;

    /* renamed from: networkCdpEntityData$delegate  reason: from kotlin metadata */
    private final Lazy networkCdpEntityData;

    /* renamed from: networkDealsExpressPurchaseData$delegate  reason: from kotlin metadata */
    private final Lazy networkDealsExpressPurchaseData;

    /* renamed from: networkExpressPurchaseEntityData$delegate  reason: from kotlin metadata */
    private final Lazy networkExpressPurchaseEntityData;

    /* renamed from: networkExpressPurchaseOfferEntityData$delegate  reason: from kotlin metadata */
    private final Lazy networkExpressPurchaseOfferEntityData;

    /* renamed from: networkPaylaterEntityData$delegate  reason: from kotlin metadata */
    private final Lazy networkPaylaterEntityData;
    private final PaylaterEntityDataFactory paylaterEntityDataFactory;
    private final SpaceResultMapper spaceRpcResultMapper;

    /* renamed from: splitConfigEntityData$delegate  reason: from kotlin metadata */
    private final Lazy splitConfigEntityData;

    /* renamed from: splitExpressPurchaseConfigData$delegate  reason: from kotlin metadata */
    private final Lazy splitExpressPurchaseConfigData;

    @Inject
    public ExpressPurchaseEntityRepository(ExpressPurchaseEntityDataFactory expressPurchaseEntityDataFactory, AccountEntityDataFactory accountEntityDataFactory, DeviceInformationProvider deviceInformationProvider, PaylaterEntityDataFactory paylaterEntityDataFactory, ConfigEntityDataFactory configEntityDataFactory, ContentDeliveryEntityDataFactory contentDeliveryEntityDataFactory, SpaceResultMapper spaceResultMapper, DealsExpressPurchaseDataFactory dealsExpressPurchaseDataFactory, ExpressPurchaseOfferEntityDataFactory expressPurchaseOfferEntityDataFactory) {
        Intrinsics.checkNotNullParameter(expressPurchaseEntityDataFactory, "");
        Intrinsics.checkNotNullParameter(accountEntityDataFactory, "");
        Intrinsics.checkNotNullParameter(deviceInformationProvider, "");
        Intrinsics.checkNotNullParameter(paylaterEntityDataFactory, "");
        Intrinsics.checkNotNullParameter(configEntityDataFactory, "");
        Intrinsics.checkNotNullParameter(contentDeliveryEntityDataFactory, "");
        Intrinsics.checkNotNullParameter(spaceResultMapper, "");
        Intrinsics.checkNotNullParameter(dealsExpressPurchaseDataFactory, "");
        Intrinsics.checkNotNullParameter(expressPurchaseOfferEntityDataFactory, "");
        this.expressPurchaseEntityDataFactory = expressPurchaseEntityDataFactory;
        this.accountEntityDataFactory = accountEntityDataFactory;
        this.deviceInformationProvider = deviceInformationProvider;
        this.paylaterEntityDataFactory = paylaterEntityDataFactory;
        this.configEntityDataFactory = configEntityDataFactory;
        this.contentDeliveryEntityDataFactory = contentDeliveryEntityDataFactory;
        this.spaceRpcResultMapper = spaceResultMapper;
        this.dealsExpressPurchaseDataFactory = dealsExpressPurchaseDataFactory;
        this.expressPurchaseOfferEntityDataFactory = expressPurchaseOfferEntityDataFactory;
        this.splitExpressPurchaseConfigData = LazyKt.lazy(new Function0<ExpressPurchaseEntityData>() { // from class: id.dana.data.expresspurchase.ExpressPurchaseEntityRepository$splitExpressPurchaseConfigData$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ExpressPurchaseEntityData invoke() {
                ExpressPurchaseEntityDataFactory expressPurchaseEntityDataFactory2;
                expressPurchaseEntityDataFactory2 = ExpressPurchaseEntityRepository.this.expressPurchaseEntityDataFactory;
                return expressPurchaseEntityDataFactory2.createData2("split");
            }
        });
        this.localExpressPurchaseEntityData = LazyKt.lazy(new Function0<ExpressPurchaseEntityData>() { // from class: id.dana.data.expresspurchase.ExpressPurchaseEntityRepository$localExpressPurchaseEntityData$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ExpressPurchaseEntityData invoke() {
                ExpressPurchaseEntityDataFactory expressPurchaseEntityDataFactory2;
                expressPurchaseEntityDataFactory2 = ExpressPurchaseEntityRepository.this.expressPurchaseEntityDataFactory;
                return expressPurchaseEntityDataFactory2.createData2("local");
            }
        });
        this.networkExpressPurchaseEntityData = LazyKt.lazy(new Function0<ExpressPurchaseEntityData>() { // from class: id.dana.data.expresspurchase.ExpressPurchaseEntityRepository$networkExpressPurchaseEntityData$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ExpressPurchaseEntityData invoke() {
                ExpressPurchaseEntityDataFactory expressPurchaseEntityDataFactory2;
                expressPurchaseEntityDataFactory2 = ExpressPurchaseEntityRepository.this.expressPurchaseEntityDataFactory;
                return expressPurchaseEntityDataFactory2.createData2("network");
            }
        });
        this.localAccountEntityData = LazyKt.lazy(new Function0<AccountEntityData>() { // from class: id.dana.data.expresspurchase.ExpressPurchaseEntityRepository$localAccountEntityData$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final AccountEntityData invoke() {
                AccountEntityDataFactory accountEntityDataFactory2;
                accountEntityDataFactory2 = ExpressPurchaseEntityRepository.this.accountEntityDataFactory;
                return accountEntityDataFactory2.createData2("local");
            }
        });
        this.networkPaylaterEntityData = LazyKt.lazy(new Function0<PaylaterEntityData>() { // from class: id.dana.data.expresspurchase.ExpressPurchaseEntityRepository$networkPaylaterEntityData$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final PaylaterEntityData invoke() {
                PaylaterEntityDataFactory paylaterEntityDataFactory2;
                paylaterEntityDataFactory2 = ExpressPurchaseEntityRepository.this.paylaterEntityDataFactory;
                return paylaterEntityDataFactory2.createData2("network");
            }
        });
        this.splitConfigEntityData = LazyKt.lazy(new Function0<ConfigEntityData>() { // from class: id.dana.data.expresspurchase.ExpressPurchaseEntityRepository$splitConfigEntityData$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ConfigEntityData invoke() {
                ConfigEntityDataFactory configEntityDataFactory2;
                configEntityDataFactory2 = ExpressPurchaseEntityRepository.this.configEntityDataFactory;
                return configEntityDataFactory2.createData2("split");
            }
        });
        this.networkCdpEntityData = LazyKt.lazy(new Function0<ContentDeliveryEntityData>() { // from class: id.dana.data.expresspurchase.ExpressPurchaseEntityRepository$networkCdpEntityData$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ContentDeliveryEntityData invoke() {
                ContentDeliveryEntityDataFactory contentDeliveryEntityDataFactory2;
                contentDeliveryEntityDataFactory2 = ExpressPurchaseEntityRepository.this.contentDeliveryEntityDataFactory;
                return contentDeliveryEntityDataFactory2.createData2("network");
            }
        });
        this.networkDealsExpressPurchaseData = LazyKt.lazy(new Function0<DealsExpressPurchaseData>() { // from class: id.dana.data.expresspurchase.ExpressPurchaseEntityRepository$networkDealsExpressPurchaseData$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final DealsExpressPurchaseData invoke() {
                DealsExpressPurchaseDataFactory dealsExpressPurchaseDataFactory2;
                dealsExpressPurchaseDataFactory2 = ExpressPurchaseEntityRepository.this.dealsExpressPurchaseDataFactory;
                return dealsExpressPurchaseDataFactory2.createData2("network");
            }
        });
        this.networkExpressPurchaseOfferEntityData = LazyKt.lazy(new Function0<ExpressPurchaseOfferEntityData>() { // from class: id.dana.data.expresspurchase.ExpressPurchaseEntityRepository$networkExpressPurchaseOfferEntityData$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ExpressPurchaseOfferEntityData invoke() {
                ExpressPurchaseOfferEntityDataFactory expressPurchaseOfferEntityDataFactory2;
                expressPurchaseOfferEntityDataFactory2 = ExpressPurchaseEntityRepository.this.expressPurchaseOfferEntityDataFactory;
                return expressPurchaseOfferEntityDataFactory2.createData2("network");
            }
        });
    }

    @JvmName(name = "getSplitExpressPurchaseConfigData")
    private final ExpressPurchaseEntityData getSplitExpressPurchaseConfigData() {
        return (ExpressPurchaseEntityData) this.splitExpressPurchaseConfigData.getValue();
    }

    @JvmName(name = "getLocalExpressPurchaseEntityData")
    private final ExpressPurchaseEntityData getLocalExpressPurchaseEntityData() {
        return (ExpressPurchaseEntityData) this.localExpressPurchaseEntityData.getValue();
    }

    @JvmName(name = "getNetworkExpressPurchaseEntityData")
    private final ExpressPurchaseEntityData getNetworkExpressPurchaseEntityData() {
        return (ExpressPurchaseEntityData) this.networkExpressPurchaseEntityData.getValue();
    }

    @JvmName(name = "getLocalAccountEntityData")
    private final AccountEntityData getLocalAccountEntityData() {
        return (AccountEntityData) this.localAccountEntityData.getValue();
    }

    @JvmName(name = "getNetworkPaylaterEntityData")
    private final PaylaterEntityData getNetworkPaylaterEntityData() {
        return (PaylaterEntityData) this.networkPaylaterEntityData.getValue();
    }

    @JvmName(name = "getSplitConfigEntityData")
    private final ConfigEntityData getSplitConfigEntityData() {
        return (ConfigEntityData) this.splitConfigEntityData.getValue();
    }

    @JvmName(name = "getNetworkCdpEntityData")
    private final ContentDeliveryEntityData getNetworkCdpEntityData() {
        return (ContentDeliveryEntityData) this.networkCdpEntityData.getValue();
    }

    @JvmName(name = "getNetworkDealsExpressPurchaseData")
    private final DealsExpressPurchaseData getNetworkDealsExpressPurchaseData() {
        return (DealsExpressPurchaseData) this.networkDealsExpressPurchaseData.getValue();
    }

    @JvmName(name = "getNetworkExpressPurchaseOfferEntityData")
    private final ExpressPurchaseOfferEntityData getNetworkExpressPurchaseOfferEntityData() {
        return (ExpressPurchaseOfferEntityData) this.networkExpressPurchaseOfferEntityData.getValue();
    }

    @JvmName(name = "getRefUserId")
    private final String getRefUserId() {
        String md5;
        String blockingFirst = getLocalAccountEntityData().getUserId().blockingFirst();
        if (TextUtils.isEmpty(blockingFirst)) {
            md5 = getLocalAccountEntityData().getPhoneNumber().blockingFirst();
        } else {
            md5 = MiscUtils.md5(blockingFirst);
        }
        if (md5.length() < 16) {
            String blockingFirst2 = getLocalAccountEntityData().getPhoneNumber().blockingFirst();
            Intrinsics.checkNotNullExpressionValue(blockingFirst2, "");
            return blockingFirst2;
        }
        Intrinsics.checkNotNullExpressionValue(md5, "");
        String substring = md5.substring(0, 16);
        Intrinsics.checkNotNullExpressionValue(substring, "");
        return substring;
    }

    @Override // id.dana.domain.expresspurchase.repository.ExpressPurchaseRepository
    public final Observable<OrderQueryResult> orderQueryByCondition(String acquirementId, List<String> tableSet) {
        Intrinsics.checkNotNullParameter(acquirementId, "");
        Intrinsics.checkNotNullParameter(tableSet, "");
        Observable map = getNetworkExpressPurchaseEntityData().orderQueryByCondition(acquirementId, tableSet).map(new Function() { // from class: id.dana.data.expresspurchase.ExpressPurchaseEntityRepository$$ExternalSyntheticLambda7
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                OrderQueryResult m1234orderQueryByCondition$lambda0;
                m1234orderQueryByCondition$lambda0 = ExpressPurchaseEntityRepository.m1234orderQueryByCondition$lambda0((OrderQueryByConditionResponse) obj);
                return m1234orderQueryByCondition$lambda0;
            }
        });
        Intrinsics.checkNotNullExpressionValue(map, "");
        return map;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: orderQueryByCondition$lambda-0  reason: not valid java name */
    public static final OrderQueryResult m1234orderQueryByCondition$lambda0(OrderQueryByConditionResponse orderQueryByConditionResponse) {
        Intrinsics.checkNotNullParameter(orderQueryByConditionResponse, "");
        return OrderQueryResultMapperKt.toOrderQueryResult(orderQueryByConditionResponse);
    }

    @Override // id.dana.domain.expresspurchase.repository.ExpressPurchaseRepository
    public final Observable<ExpressPurchaseConfig> getExpressPurchaseConfig() {
        ConfigUtil configUtil = ConfigUtil.INSTANCE;
        ExpressPurchaseEntityData splitExpressPurchaseConfigData = getSplitExpressPurchaseConfigData();
        ExpressPurchaseEntityData[] expressPurchaseEntityDataArr = {getLocalExpressPurchaseEntityData()};
        ExpressPurchaseEntityRepository$getExpressPurchaseConfig$1 expressPurchaseEntityRepository$getExpressPurchaseConfig$1 = new Function1<ExpressPurchaseEntityData, Observable<ExpressPurchaseConfigResult>>() { // from class: id.dana.data.expresspurchase.ExpressPurchaseEntityRepository$getExpressPurchaseConfig$1
            @Override // kotlin.jvm.functions.Function1
            public final Observable<ExpressPurchaseConfigResult> invoke(ExpressPurchaseEntityData expressPurchaseEntityData) {
                Intrinsics.checkNotNullParameter(expressPurchaseEntityData, "");
                return expressPurchaseEntityData.getBottomSheetExpressPurchaseConfig();
            }
        };
        Observable<ExpressPurchaseConfig> map = configUtil.getConfigFromOtherEntityData(expressPurchaseEntityRepository$getExpressPurchaseConfig$1.invoke((ExpressPurchaseEntityRepository$getExpressPurchaseConfig$1) splitExpressPurchaseConfigData), ArrayIteratorKt.iterator(expressPurchaseEntityDataArr), expressPurchaseEntityRepository$getExpressPurchaseConfig$1).map(new Function() { // from class: id.dana.data.expresspurchase.ExpressPurchaseEntityRepository$$ExternalSyntheticLambda13
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                ExpressPurchaseConfig m1224getExpressPurchaseConfig$lambda1;
                m1224getExpressPurchaseConfig$lambda1 = ExpressPurchaseEntityRepository.m1224getExpressPurchaseConfig$lambda1((ExpressPurchaseConfigResult) obj);
                return m1224getExpressPurchaseConfig$lambda1;
            }
        });
        Intrinsics.checkNotNullExpressionValue(map, "");
        return map;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: getExpressPurchaseConfig$lambda-1  reason: not valid java name */
    public static final ExpressPurchaseConfig m1224getExpressPurchaseConfig$lambda1(ExpressPurchaseConfigResult expressPurchaseConfigResult) {
        Intrinsics.checkNotNullParameter(expressPurchaseConfigResult, "");
        return ExpressPurchaseEntityRepositoryMapperKt.toExpressPurchaseConfig(expressPurchaseConfigResult);
    }

    @Override // id.dana.domain.expresspurchase.repository.ExpressPurchaseRepository
    public final Observable<ExpressPurchaseConfig> getExpressPurchaseGoldConfig() {
        ConfigUtil configUtil = ConfigUtil.INSTANCE;
        ExpressPurchaseEntityData splitExpressPurchaseConfigData = getSplitExpressPurchaseConfigData();
        ExpressPurchaseEntityData[] expressPurchaseEntityDataArr = {getLocalExpressPurchaseEntityData()};
        ExpressPurchaseEntityRepository$getExpressPurchaseGoldConfig$1 expressPurchaseEntityRepository$getExpressPurchaseGoldConfig$1 = new Function1<ExpressPurchaseEntityData, Observable<ExpressPurchaseConfigResult>>() { // from class: id.dana.data.expresspurchase.ExpressPurchaseEntityRepository$getExpressPurchaseGoldConfig$1
            @Override // kotlin.jvm.functions.Function1
            public final Observable<ExpressPurchaseConfigResult> invoke(ExpressPurchaseEntityData expressPurchaseEntityData) {
                Intrinsics.checkNotNullParameter(expressPurchaseEntityData, "");
                return expressPurchaseEntityData.getBottomSheetExpressPurchaseGoldConfig();
            }
        };
        Observable<ExpressPurchaseConfig> map = configUtil.getConfigFromOtherEntityData(expressPurchaseEntityRepository$getExpressPurchaseGoldConfig$1.invoke((ExpressPurchaseEntityRepository$getExpressPurchaseGoldConfig$1) splitExpressPurchaseConfigData), ArrayIteratorKt.iterator(expressPurchaseEntityDataArr), expressPurchaseEntityRepository$getExpressPurchaseGoldConfig$1).map(new Function() { // from class: id.dana.data.expresspurchase.ExpressPurchaseEntityRepository$$ExternalSyntheticLambda0
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                ExpressPurchaseConfig m1225getExpressPurchaseGoldConfig$lambda2;
                m1225getExpressPurchaseGoldConfig$lambda2 = ExpressPurchaseEntityRepository.m1225getExpressPurchaseGoldConfig$lambda2((ExpressPurchaseConfigResult) obj);
                return m1225getExpressPurchaseGoldConfig$lambda2;
            }
        });
        Intrinsics.checkNotNullExpressionValue(map, "");
        return map;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: getExpressPurchaseGoldConfig$lambda-2  reason: not valid java name */
    public static final ExpressPurchaseConfig m1225getExpressPurchaseGoldConfig$lambda2(ExpressPurchaseConfigResult expressPurchaseConfigResult) {
        Intrinsics.checkNotNullParameter(expressPurchaseConfigResult, "");
        return ExpressPurchaseEntityRepositoryMapperKt.toExpressPurchaseConfig(expressPurchaseConfigResult);
    }

    @Override // id.dana.domain.expresspurchase.repository.ExpressPurchaseRepository
    public final Observable<ExpressPurchasePaylaterConfig> getExpressPurchasePaylaterConfig() {
        Observable map = getSplitExpressPurchaseConfigData().getBottomSheetExpressPurchasePaylaterConfig().map(new Function() { // from class: id.dana.data.expresspurchase.ExpressPurchaseEntityRepository$$ExternalSyntheticLambda2
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                ExpressPurchasePaylaterConfig m1226getExpressPurchasePaylaterConfig$lambda3;
                m1226getExpressPurchasePaylaterConfig$lambda3 = ExpressPurchaseEntityRepository.m1226getExpressPurchasePaylaterConfig$lambda3((ExpressPurchasePaylaterConfigResult) obj);
                return m1226getExpressPurchasePaylaterConfig$lambda3;
            }
        });
        Intrinsics.checkNotNullExpressionValue(map, "");
        return map;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: getExpressPurchasePaylaterConfig$lambda-3  reason: not valid java name */
    public static final ExpressPurchasePaylaterConfig m1226getExpressPurchasePaylaterConfig$lambda3(ExpressPurchasePaylaterConfigResult expressPurchasePaylaterConfigResult) {
        Intrinsics.checkNotNullParameter(expressPurchasePaylaterConfigResult, "");
        return ExpressPurchasePaylaterConfigResultMapperKt.toExpressPurchasePaylaterConfig(expressPurchasePaylaterConfigResult);
    }

    @Override // id.dana.domain.expresspurchase.repository.ExpressPurchaseRepository
    public final Observable<ServiceEmasConfig> getServiceEmasConfig() {
        ConfigUtil configUtil = ConfigUtil.INSTANCE;
        ExpressPurchaseEntityData splitExpressPurchaseConfigData = getSplitExpressPurchaseConfigData();
        ExpressPurchaseEntityData[] expressPurchaseEntityDataArr = {getLocalExpressPurchaseEntityData()};
        ExpressPurchaseEntityRepository$getServiceEmasConfig$1 expressPurchaseEntityRepository$getServiceEmasConfig$1 = new Function1<ExpressPurchaseEntityData, Observable<ServiceEmasConfigResult>>() { // from class: id.dana.data.expresspurchase.ExpressPurchaseEntityRepository$getServiceEmasConfig$1
            @Override // kotlin.jvm.functions.Function1
            public final Observable<ServiceEmasConfigResult> invoke(ExpressPurchaseEntityData expressPurchaseEntityData) {
                Intrinsics.checkNotNullParameter(expressPurchaseEntityData, "");
                return expressPurchaseEntityData.getServiceEmasConfig();
            }
        };
        Observable<ServiceEmasConfig> map = configUtil.getConfigFromOtherEntityData(expressPurchaseEntityRepository$getServiceEmasConfig$1.invoke((ExpressPurchaseEntityRepository$getServiceEmasConfig$1) splitExpressPurchaseConfigData), ArrayIteratorKt.iterator(expressPurchaseEntityDataArr), expressPurchaseEntityRepository$getServiceEmasConfig$1).map(new Function() { // from class: id.dana.data.expresspurchase.ExpressPurchaseEntityRepository$$ExternalSyntheticLambda14
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                ServiceEmasConfig m1233getServiceEmasConfig$lambda4;
                m1233getServiceEmasConfig$lambda4 = ExpressPurchaseEntityRepository.m1233getServiceEmasConfig$lambda4((ServiceEmasConfigResult) obj);
                return m1233getServiceEmasConfig$lambda4;
            }
        });
        Intrinsics.checkNotNullExpressionValue(map, "");
        return map;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: getServiceEmasConfig$lambda-4  reason: not valid java name */
    public static final ServiceEmasConfig m1233getServiceEmasConfig$lambda4(ServiceEmasConfigResult serviceEmasConfigResult) {
        Intrinsics.checkNotNullParameter(serviceEmasConfigResult, "");
        return ExpressPurchaseEntityRepositoryMapperKt.toServiceEmasConfig(serviceEmasConfigResult);
    }

    @Override // id.dana.domain.expresspurchase.repository.ExpressPurchaseRepository
    public final Observable<LatestExpressPurchaseAction> getLastExpressPurchaseAction(String addonId, String type) {
        Intrinsics.checkNotNullParameter(addonId, "");
        Intrinsics.checkNotNullParameter(type, "");
        Observable<LatestExpressPurchaseAction> combineLatest = Observable.combineLatest(getLocalExpressPurchaseEntityData().getLastOfferCancelAction(getRefUserId(), addonId, type), getLocalExpressPurchaseEntityData().getLastOfferSucceedAction(getRefUserId(), addonId), new BiFunction() { // from class: id.dana.data.expresspurchase.ExpressPurchaseEntityRepository$$ExternalSyntheticLambda10
            @Override // io.reactivex.functions.BiFunction
            public final Object apply(Object obj, Object obj2) {
                LatestExpressPurchaseAction m1227getLastExpressPurchaseAction$lambda5;
                m1227getLastExpressPurchaseAction$lambda5 = ExpressPurchaseEntityRepository.m1227getLastExpressPurchaseAction$lambda5((Long) obj, (Long) obj2);
                return m1227getLastExpressPurchaseAction$lambda5;
            }
        });
        Intrinsics.checkNotNullExpressionValue(combineLatest, "");
        return combineLatest;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: getLastExpressPurchaseAction$lambda-5  reason: not valid java name */
    public static final LatestExpressPurchaseAction m1227getLastExpressPurchaseAction$lambda5(Long l, Long l2) {
        Intrinsics.checkNotNullParameter(l, "");
        Intrinsics.checkNotNullParameter(l2, "");
        return new LatestExpressPurchaseAction(l.longValue(), l2.longValue());
    }

    @Override // id.dana.domain.expresspurchase.repository.ExpressPurchaseRepository
    public final Observable<AddonInfo> getCashierAddonInfo(String addonId, String cashierOrderId) {
        Intrinsics.checkNotNullParameter(addonId, "");
        Intrinsics.checkNotNullParameter(cashierOrderId, "");
        Observable map = getNetworkExpressPurchaseOfferEntityData().getExpressPurchase(addonId, cashierOrderId).map(new Function() { // from class: id.dana.data.expresspurchase.ExpressPurchaseEntityRepository$$ExternalSyntheticLambda12
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                AddonInfo m1223getCashierAddonInfo$lambda6;
                m1223getCashierAddonInfo$lambda6 = ExpressPurchaseEntityRepository.m1223getCashierAddonInfo$lambda6((GetExpressPurchaseResponse) obj);
                return m1223getCashierAddonInfo$lambda6;
            }
        });
        Intrinsics.checkNotNullExpressionValue(map, "");
        return map;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: getCashierAddonInfo$lambda-6  reason: not valid java name */
    public static final AddonInfo m1223getCashierAddonInfo$lambda6(GetExpressPurchaseResponse getExpressPurchaseResponse) {
        Intrinsics.checkNotNullParameter(getExpressPurchaseResponse, "");
        return ExpressPurchaseEntityRepositoryMapperKt.toAddonInfo(getExpressPurchaseResponse);
    }

    @Override // id.dana.domain.expresspurchase.repository.ExpressPurchaseRepository
    public final Observable<ValidateProduct> validateStandaloneProduct(String goodsId, String aggregatorGoodsId) {
        Intrinsics.checkNotNullParameter(goodsId, "");
        Intrinsics.checkNotNullParameter(aggregatorGoodsId, "");
        Observable map = getNetworkExpressPurchaseEntityData().validateStandaloneProduct(goodsId, aggregatorGoodsId).map(new Function() { // from class: id.dana.data.expresspurchase.ExpressPurchaseEntityRepository$$ExternalSyntheticLambda1
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                ValidateProduct m1237validateStandaloneProduct$lambda7;
                m1237validateStandaloneProduct$lambda7 = ExpressPurchaseEntityRepository.m1237validateStandaloneProduct$lambda7((ValidateProductQuickResponse) obj);
                return m1237validateStandaloneProduct$lambda7;
            }
        });
        Intrinsics.checkNotNullExpressionValue(map, "");
        return map;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: validateStandaloneProduct$lambda-7  reason: not valid java name */
    public static final ValidateProduct m1237validateStandaloneProduct$lambda7(ValidateProductQuickResponse validateProductQuickResponse) {
        Intrinsics.checkNotNullParameter(validateProductQuickResponse, "");
        return ExpressPurchaseEntityRepositoryMapperKt.toValidateProduct(validateProductQuickResponse);
    }

    @Override // id.dana.domain.expresspurchase.repository.ExpressPurchaseRepository
    public final Observable<ValidateProduct> validateBundleProduct(String goodsId, String aggregatorId, String aggregatorGoodsId, String finType, String bizOrderId, String merchantTransId) {
        Intrinsics.checkNotNullParameter(goodsId, "");
        Intrinsics.checkNotNullParameter(bizOrderId, "");
        Intrinsics.checkNotNullParameter(merchantTransId, "");
        Observable map = getNetworkExpressPurchaseEntityData().validateBundleProduct(goodsId, aggregatorId, aggregatorGoodsId, finType, bizOrderId, merchantTransId).map(new Function() { // from class: id.dana.data.expresspurchase.ExpressPurchaseEntityRepository$$ExternalSyntheticLambda6
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                ValidateProduct m1235validateBundleProduct$lambda8;
                m1235validateBundleProduct$lambda8 = ExpressPurchaseEntityRepository.m1235validateBundleProduct$lambda8((ValidateProductResponse) obj);
                return m1235validateBundleProduct$lambda8;
            }
        });
        Intrinsics.checkNotNullExpressionValue(map, "");
        return map;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: validateBundleProduct$lambda-8  reason: not valid java name */
    public static final ValidateProduct m1235validateBundleProduct$lambda8(ValidateProductResponse validateProductResponse) {
        Intrinsics.checkNotNullParameter(validateProductResponse, "");
        return ExpressPurchaseEntityRepositoryMapperKt.toValidateProduct(validateProductResponse);
    }

    @Override // id.dana.domain.expresspurchase.repository.ExpressPurchaseRepository
    public final Observable<Boolean> saveLastOfferSucceedTransaction(String addonId) {
        Intrinsics.checkNotNullParameter(addonId, "");
        return getLocalExpressPurchaseEntityData().saveLastOfferSucceedAction(getRefUserId(), addonId);
    }

    @Override // id.dana.domain.expresspurchase.repository.ExpressPurchaseRepository
    public final Observable<Boolean> saveLastOfferCancelTransaction(String addonId, String type) {
        Intrinsics.checkNotNullParameter(addonId, "");
        Intrinsics.checkNotNullParameter(type, "");
        return getLocalExpressPurchaseEntityData().saveLastOfferCancelAction(getRefUserId(), addonId, type);
    }

    @Override // id.dana.domain.expresspurchase.repository.ExpressPurchaseRepository
    public final Observable<QuickBuyInsurance> getQuickBuyInsurance(String goodsId, String aggregatorGoodsId, Map<String, String> extendInfo) {
        Intrinsics.checkNotNullParameter(goodsId, "");
        Intrinsics.checkNotNullParameter(aggregatorGoodsId, "");
        Intrinsics.checkNotNullParameter(extendInfo, "");
        ExpressPurchaseEntityData networkExpressPurchaseEntityData = getNetworkExpressPurchaseEntityData();
        String deviceUUID = this.deviceInformationProvider.getDeviceUUID();
        Intrinsics.checkNotNullExpressionValue(deviceUUID, "");
        Observable map = networkExpressPurchaseEntityData.getQuickBuyInsurance(goodsId, deviceUUID, aggregatorGoodsId, extendInfo).map(new Function() { // from class: id.dana.data.expresspurchase.ExpressPurchaseEntityRepository$$ExternalSyntheticLambda4
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                QuickBuyInsurance m1232getQuickBuyInsurance$lambda9;
                m1232getQuickBuyInsurance$lambda9 = ExpressPurchaseEntityRepository.m1232getQuickBuyInsurance$lambda9((QuickBuyResponse) obj);
                return m1232getQuickBuyInsurance$lambda9;
            }
        });
        Intrinsics.checkNotNullExpressionValue(map, "");
        return map;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: getQuickBuyInsurance$lambda-9  reason: not valid java name */
    public static final QuickBuyInsurance m1232getQuickBuyInsurance$lambda9(QuickBuyResponse quickBuyResponse) {
        Intrinsics.checkNotNullParameter(quickBuyResponse, "");
        return ExpressPurchaseEntityRepositoryMapperKt.toQuickBuyInsurance(quickBuyResponse);
    }

    @Override // id.dana.domain.expresspurchase.repository.ExpressPurchaseRepository
    public final Observable<QuickBuyGold> getQuickBuyGold(String goodsId, String aggregatorGoodsId, Map<String, String> extendInfo, String cashierOrderId, String epTemplateType, String thirdRefId, String authCode) {
        Intrinsics.checkNotNullParameter(goodsId, "");
        Intrinsics.checkNotNullParameter(aggregatorGoodsId, "");
        Intrinsics.checkNotNullParameter(extendInfo, "");
        Intrinsics.checkNotNullParameter(cashierOrderId, "");
        Intrinsics.checkNotNullParameter(epTemplateType, "");
        Intrinsics.checkNotNullParameter(thirdRefId, "");
        Intrinsics.checkNotNullParameter(authCode, "");
        ExpressPurchaseEntityData networkExpressPurchaseEntityData = getNetworkExpressPurchaseEntityData();
        String deviceUUID = this.deviceInformationProvider.getDeviceUUID();
        Intrinsics.checkNotNullExpressionValue(deviceUUID, "");
        Observable map = networkExpressPurchaseEntityData.getQuickBuyGold(goodsId, deviceUUID, aggregatorGoodsId, extendInfo, cashierOrderId, epTemplateType, thirdRefId, authCode).map(new Function() { // from class: id.dana.data.expresspurchase.ExpressPurchaseEntityRepository$$ExternalSyntheticLambda9
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                QuickBuyGold m1231getQuickBuyGold$lambda10;
                m1231getQuickBuyGold$lambda10 = ExpressPurchaseEntityRepository.m1231getQuickBuyGold$lambda10((QuickBuyResponse) obj);
                return m1231getQuickBuyGold$lambda10;
            }
        });
        Intrinsics.checkNotNullExpressionValue(map, "");
        return map;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: getQuickBuyGold$lambda-10  reason: not valid java name */
    public static final QuickBuyGold m1231getQuickBuyGold$lambda10(QuickBuyResponse quickBuyResponse) {
        Intrinsics.checkNotNullParameter(quickBuyResponse, "");
        return ExpressPurchaseEntityRepositoryMapperKt.toQuickBuyGold(quickBuyResponse);
    }

    @Override // id.dana.domain.expresspurchase.repository.ExpressPurchaseRepository
    public final Observable<GoldValidationInfo> validateGoldProduct(String goodsId, List<String> validationTypes, Map<String, ? extends Object> validationInfo) {
        Intrinsics.checkNotNullParameter(goodsId, "");
        Intrinsics.checkNotNullParameter(validationTypes, "");
        Intrinsics.checkNotNullParameter(validationInfo, "");
        Observable map = getNetworkExpressPurchaseEntityData().validateGoldProduct(goodsId, validationTypes, validationInfo).map(new Function() { // from class: id.dana.data.expresspurchase.ExpressPurchaseEntityRepository$$ExternalSyntheticLambda15
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                GoldValidationInfo m1236validateGoldProduct$lambda11;
                m1236validateGoldProduct$lambda11 = ExpressPurchaseEntityRepository.m1236validateGoldProduct$lambda11((ValidateProductGoldResponse) obj);
                return m1236validateGoldProduct$lambda11;
            }
        });
        Intrinsics.checkNotNullExpressionValue(map, "");
        return map;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: validateGoldProduct$lambda-11  reason: not valid java name */
    public static final GoldValidationInfo m1236validateGoldProduct$lambda11(ValidateProductGoldResponse validateProductGoldResponse) {
        Intrinsics.checkNotNullParameter(validateProductGoldResponse, "");
        return ValidateProductGoldMapperKt.toGoldValidationInfo(validateProductGoldResponse);
    }

    @Override // id.dana.domain.expresspurchase.repository.ExpressPurchaseRepository
    public final Observable<PaylaterHomeInfo> getPaylaterHomeInfo(boolean skipBillInfo) {
        Observable map = getNetworkPaylaterEntityData().getPaylaterHomeInfo(skipBillInfo).map(new Function() { // from class: id.dana.data.expresspurchase.ExpressPurchaseEntityRepository$$ExternalSyntheticLambda3
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                PaylaterHomeInfo m1229getPaylaterHomeInfo$lambda12;
                m1229getPaylaterHomeInfo$lambda12 = ExpressPurchaseEntityRepository.m1229getPaylaterHomeInfo$lambda12((PaylaterHomeInfoResult) obj);
                return m1229getPaylaterHomeInfo$lambda12;
            }
        });
        Intrinsics.checkNotNullExpressionValue(map, "");
        return map;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: getPaylaterHomeInfo$lambda-12  reason: not valid java name */
    public static final PaylaterHomeInfo m1229getPaylaterHomeInfo$lambda12(PaylaterHomeInfoResult paylaterHomeInfoResult) {
        Intrinsics.checkNotNullParameter(paylaterHomeInfoResult, "");
        return PaylaterHomeInfoResultMapperKt.toPaylaterHomeInfo(paylaterHomeInfoResult);
    }

    @Override // id.dana.domain.expresspurchase.repository.ExpressPurchaseRepository
    public final Observable<PaylaterAgreementConfig> getPaylaterAgreementConfig() {
        Observable map = getSplitConfigEntityData().getPaylaterAgreementConfig().map(new Function() { // from class: id.dana.data.expresspurchase.ExpressPurchaseEntityRepository$$ExternalSyntheticLambda8
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                PaylaterAgreementConfig m1228getPaylaterAgreementConfig$lambda13;
                m1228getPaylaterAgreementConfig$lambda13 = ExpressPurchaseEntityRepository.m1228getPaylaterAgreementConfig$lambda13((PaylaterAgreementConfigResult) obj);
                return m1228getPaylaterAgreementConfig$lambda13;
            }
        });
        Intrinsics.checkNotNullExpressionValue(map, "");
        return map;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: getPaylaterAgreementConfig$lambda-13  reason: not valid java name */
    public static final PaylaterAgreementConfig m1228getPaylaterAgreementConfig$lambda13(PaylaterAgreementConfigResult paylaterAgreementConfigResult) {
        Intrinsics.checkNotNullParameter(paylaterAgreementConfigResult, "");
        return PaylaterAgreementConfigResultMapperKt.toPaylaterAgreementConfig(paylaterAgreementConfigResult);
    }

    @Override // id.dana.domain.expresspurchase.repository.ExpressPurchaseRepository
    public final Observable<Space> getExpressPurchaseCdpContent(String spaceCode) {
        Intrinsics.checkNotNullParameter(spaceCode, "");
        Observable map = getNetworkCdpEntityData().get(spaceCode).map(new CashierEntityRepository$$ExternalSyntheticLambda10(this.spaceRpcResultMapper));
        Intrinsics.checkNotNullExpressionValue(map, "");
        return map;
    }

    @Override // id.dana.domain.expresspurchase.repository.ExpressPurchaseRepository
    public final Observable<QuickBuyDeals> getQuickBuyDeals(String epTemplateType, String goodsId, String aggregatorGoodsId, String requestId) {
        Intrinsics.checkNotNullParameter(epTemplateType, "");
        Intrinsics.checkNotNullParameter(goodsId, "");
        Intrinsics.checkNotNullParameter(aggregatorGoodsId, "");
        Intrinsics.checkNotNullParameter(requestId, "");
        Observable map = getNetworkExpressPurchaseEntityData().getQuickBuyDeals(epTemplateType, goodsId, requestId).map(new Function() { // from class: id.dana.data.expresspurchase.ExpressPurchaseEntityRepository$$ExternalSyntheticLambda5
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                QuickBuyDeals m1230getQuickBuyDeals$lambda14;
                m1230getQuickBuyDeals$lambda14 = ExpressPurchaseEntityRepository.m1230getQuickBuyDeals$lambda14((QuickBuyDealsResponse) obj);
                return m1230getQuickBuyDeals$lambda14;
            }
        });
        Intrinsics.checkNotNullExpressionValue(map, "");
        return map;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: getQuickBuyDeals$lambda-14  reason: not valid java name */
    public static final QuickBuyDeals m1230getQuickBuyDeals$lambda14(QuickBuyDealsResponse quickBuyDealsResponse) {
        Intrinsics.checkNotNullParameter(quickBuyDealsResponse, "");
        return QuickBuyDealsResponseMapperKt.toQuickBuyDeals(quickBuyDealsResponse);
    }

    @Override // id.dana.domain.expresspurchase.repository.ExpressPurchaseRepository
    public final Observable<DealsShopInfo> dealsQueryShopLocation(String goodsId, String latitude, String longitude) {
        Intrinsics.checkNotNullParameter(goodsId, "");
        Observable map = getNetworkDealsExpressPurchaseData().dealsQueryShopLocation(goodsId, latitude, longitude).map(new Function() { // from class: id.dana.data.expresspurchase.ExpressPurchaseEntityRepository$$ExternalSyntheticLambda11
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                DealsShopInfo m1222dealsQueryShopLocation$lambda15;
                m1222dealsQueryShopLocation$lambda15 = ExpressPurchaseEntityRepository.m1222dealsQueryShopLocation$lambda15((DealsQueryShopResponse) obj);
                return m1222dealsQueryShopLocation$lambda15;
            }
        });
        Intrinsics.checkNotNullExpressionValue(map, "");
        return map;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: dealsQueryShopLocation$lambda-15  reason: not valid java name */
    public static final DealsShopInfo m1222dealsQueryShopLocation$lambda15(DealsQueryShopResponse dealsQueryShopResponse) {
        DealsShopInfoResponse dealsShopInfoResponse;
        Intrinsics.checkNotNullParameter(dealsQueryShopResponse, "");
        List<DealsShopInfoResponse> shops = dealsQueryShopResponse.getShops();
        if (shops == null || (dealsShopInfoResponse = (DealsShopInfoResponse) CollectionsKt.first((List) shops)) == null) {
            return null;
        }
        return DealsShopInfoMapperKt.toDealsShopInfo(dealsShopInfoResponse);
    }
}
