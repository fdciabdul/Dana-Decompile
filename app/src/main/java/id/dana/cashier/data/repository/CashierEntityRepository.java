package id.dana.cashier.data.repository;

import android.os.Process;
import android.view.MotionEvent;
import android.view.View;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.parser.JSONLexer;
import com.alibaba.griver.api.jsapi.diagnostic.RecordError;
import id.dana.cashier.data.mapper.CashierAddOnModalTooltipRequestMapper;
import id.dana.cashier.data.mapper.CashierAddOnModalTooltipResultMapper;
import id.dana.cashier.data.mapper.CashierEKtpAgreementRequestMapper;
import id.dana.cashier.data.mapper.CashierEKtpAgreementResultMapper;
import id.dana.cashier.data.mapper.CashierPayInfoRequestMapper;
import id.dana.cashier.data.mapper.CashierPayInfoResultMapper;
import id.dana.cashier.data.mapper.CreateOrderInfoRequestMapper;
import id.dana.cashier.data.mapper.CreateOrderInfoResultMapper;
import id.dana.cashier.data.mapper.FetchBannerInfoResultMapperKt;
import id.dana.cashier.data.mapper.FetchNpsSurveyInfoRequestMapperKt;
import id.dana.cashier.data.mapper.FetchNpsSurveyResultMapperKt;
import id.dana.cashier.data.mapper.GetCashierKybProductInfoMapperKt;
import id.dana.cashier.data.mapper.LoanRegisterMapper;
import id.dana.cashier.data.mapper.QueryCardPolicyInfoResultMapperKt;
import id.dana.cashier.data.mapper.QueryCardPolicyRequestMapperKt;
import id.dana.cashier.data.mapper.QueryPayOptionRequestMapperKt;
import id.dana.cashier.data.mapper.QueryPromotionInfoResultMapper;
import id.dana.cashier.data.mapper.SubmitNpsSurveyInfoRequestMapperKt;
import id.dana.cashier.data.mapper.TopUpConsultResultMapper;
import id.dana.cashier.data.mapper.TopUpPayResultMapper;
import id.dana.cashier.data.repository.source.CashierBannerManagementEntityData;
import id.dana.cashier.data.repository.source.CashierBannerManagementEntityDataFactory;
import id.dana.cashier.data.repository.source.CashierEntityData;
import id.dana.cashier.data.repository.source.CashierEntityDataFactory;
import id.dana.cashier.data.repository.source.CdpGuideCacheEntityDataFactory;
import id.dana.cashier.data.repository.source.network.request.AddAssetCardForUserEntityRequestKt;
import id.dana.cashier.data.repository.source.network.request.AdditionalPaylaterCashierPayRequest;
import id.dana.cashier.data.repository.source.network.request.AdditionalPaylaterCashierPayRequestKt;
import id.dana.cashier.data.repository.source.network.request.CashierUpdateOrderEntityRequestKt;
import id.dana.cashier.data.repository.source.network.request.CreateOrderEntityRequest;
import id.dana.cashier.data.repository.source.network.request.QueryInstallmentEntityRequestKt;
import id.dana.cashier.data.repository.source.network.request.TopUpConsultEntityRequestKt;
import id.dana.cashier.data.repository.source.network.request.TopUpSubmitEntityRequestKt;
import id.dana.cashier.data.repository.source.network.request.TopUpVerifyEntityRequestKt;
import id.dana.cashier.data.repository.source.network.result.CashierAddOnCdnTooltipResult;
import id.dana.cashier.data.repository.source.network.result.CashierAddOnModalCategoryResult;
import id.dana.cashier.data.repository.source.network.result.CashierAddOnModalContentResult;
import id.dana.cashier.data.repository.source.network.result.CashierBannerEntityResponse;
import id.dana.cashier.data.repository.source.network.result.CashierCurrencyFromCdnResult;
import id.dana.cashier.data.repository.source.network.result.CashierHighlightConfigResult;
import id.dana.cashier.data.repository.source.network.result.CashierHighlightConfigResultKt;
import id.dana.cashier.data.repository.source.network.result.CashierKybProductInfoResult;
import id.dana.cashier.data.repository.source.network.result.CreateOrderInfoResult;
import id.dana.cashier.data.repository.source.network.result.FetchBannerInfoResult;
import id.dana.cashier.data.repository.source.network.result.QueryCardPolicyInfoResult;
import id.dana.cashier.data.repository.source.network.result.QueryInstallmentResult;
import id.dana.cashier.data.repository.source.network.result.QueryInstallmentResultKt;
import id.dana.cashier.data.repository.source.network.result.QueryOneklikRedirectUrlResult;
import id.dana.cashier.data.repository.source.network.result.TimedSpaceRpcResult;
import id.dana.cashier.data.repository.source.network.result.npssurvey.NpsSurveyInfoResult;
import id.dana.cashier.data.repository.source.network.result.npssurvey.NpsSurveySubmitEntityResult;
import id.dana.cashier.domain.CashierRepository;
import id.dana.cashier.domain.model.AddAssetCardForUserRequest;
import id.dana.cashier.domain.model.CashierAddOnCdnTooltip;
import id.dana.cashier.domain.model.CashierAddOnCdnTooltipKt;
import id.dana.cashier.domain.model.CashierAddOnModalContent;
import id.dana.cashier.domain.model.CashierAddOnModalContentKt;
import id.dana.cashier.domain.model.CashierCurrencyFromCdn;
import id.dana.cashier.domain.model.CashierCurrencyFromCdnKt;
import id.dana.cashier.domain.model.CashierHighlightConfig;
import id.dana.cashier.domain.model.CashierKybProductInfo;
import id.dana.cashier.domain.model.CashierPay;
import id.dana.cashier.domain.model.CashierPayRequest;
import id.dana.cashier.domain.model.CashierUpdateOrderRequest;
import id.dana.cashier.domain.model.CreateOrderRequest;
import id.dana.cashier.domain.model.FetchBannerInfo;
import id.dana.cashier.domain.model.FetchBannerRequest;
import id.dana.cashier.domain.model.GetCashierKybProductRequest;
import id.dana.cashier.domain.model.NpsSurveyConsultInfo;
import id.dana.cashier.domain.model.NpsSurveyConsultRequest;
import id.dana.cashier.domain.model.NpsSurveySubmitRequest;
import id.dana.cashier.domain.model.QueryCardPolicy;
import id.dana.cashier.domain.model.QueryCardPolicyInfo;
import id.dana.cashier.domain.model.QueryPayOptionInfoRequest;
import id.dana.cashier.domain.model.TopUpConsult;
import id.dana.cashier.domain.model.TopUpConsultRequest;
import id.dana.cashier.domain.model.TopUpPay;
import id.dana.cashier.domain.model.TopUpSubmitRequest;
import id.dana.cashier.domain.model.TopUpVerifyRequest;
import id.dana.cashier.domain.model.paylater.LoanRegisterResultInfo;
import id.dana.cashier.domain.model.paylater.PaylaterCashierPayRequest;
import id.dana.cashier.domain.model.paylater.QueryInstallment;
import id.dana.cashier.domain.model.paylater.QueryInstallmentRequest;
import id.dana.data.account.repository.source.AccountEntityData;
import id.dana.data.account.repository.source.AccountEntityDataFactory;
import id.dana.data.cache.CacheEntityData;
import id.dana.data.cache.CacheKey;
import id.dana.data.card.repository.CardCredentialEntityRepository;
import id.dana.data.config.model.PayLaterMethodConfig;
import id.dana.data.config.model.PaylaterAgreementConfigResult;
import id.dana.data.config.source.amcs.result.BannerConfigResult;
import id.dana.data.config.source.split.SplitConfigEntityData;
import id.dana.data.content.mapper.SpaceResultMapper;
import id.dana.data.content.source.ContentDeliveryEntityData;
import id.dana.data.content.source.ContentDeliveryEntityDataFactory;
import id.dana.data.content.source.network.result.SpaceRpcResult;
import id.dana.data.errorconfig.ErrorConfigEntityData;
import id.dana.data.foundation.utils.CommonUtil;
import id.dana.data.geocode.repository.GeocodeEntityRepository;
import id.dana.data.holdlogin.v1.HoldLoginV1EntityRepository;
import id.dana.data.holdlogin.v1.HoldLoginV1Repository;
import id.dana.data.login.source.LoginEntityData;
import id.dana.data.model.DefaultInfoResult;
import id.dana.data.model.DefaultInfoResultKt;
import id.dana.data.paylater.mapper.PaylaterAgreementConfigResultMapperKt;
import id.dana.data.paylater.repository.PaylaterEntityData;
import id.dana.data.paylater.repository.PaylaterEntityDataFactory;
import id.dana.data.paylater.repository.mapper.PaylaterCicilMethodConfigResultMapperKt;
import id.dana.data.paylater.repository.source.network.result.LoanRegisterResult;
import id.dana.data.paylater.repository.source.network.result.PaylaterCicilMethodConfigResult;
import id.dana.data.security.source.SecurityEntityData;
import id.dana.data.security.source.SecurityEntityDataFactory;
import id.dana.data.util.FeatureSwitch;
import id.dana.domain.card.repository.CardCredentialRepository;
import id.dana.domain.geocode.model.LocationSubdisivision;
import id.dana.domain.paylater.model.PaylaterAgreementConfig;
import id.dana.domain.paylater.model.PaylaterCicilMethodConfig;
import id.dana.domain.promotion.Space;
import id.dana.utils.rpc.response.DefaultResponse;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Single;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.functions.Function4;
import io.reactivex.functions.Predicate;
import io.reactivex.internal.functions.Functions;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.fuseable.FuseToObservable;
import io.reactivex.internal.operators.single.SingleDoOnSuccess;
import io.reactivex.internal.operators.single.SingleResumeNext;
import io.reactivex.internal.operators.single.SingleToObservable;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Typography;
import kotlinx.coroutines.flow.Flow;
import o.E;

@Singleton
@Metadata(d1 = {"\u0000\u0092\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010!\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000 ·\u00022\u00020\u00012\u00020\u00022\u00020\u0003:\u0002·\u0002B\u0082\u0002\b\u0007\u0012\b\u0010æ\u0001\u001a\u00030å\u0001\u0012\b\u0010\u0099\u0002\u001a\u00030\u0098\u0002\u0012\b\u0010\u009f\u0002\u001a\u00030\u009e\u0002\u0012\u000f\u0010ú\u0001\u001a\n\u0012\u0005\u0012\u00030Â\u00010ù\u0001\u0012\b\u0010ý\u0001\u001a\u00030ü\u0001\u0012\b\u0010Ï\u0001\u001a\u00030Î\u0001\u0012\b\u0010Æ\u0001\u001a\u00030Å\u0001\u0012\b\u0010à\u0001\u001a\u00030ß\u0001\u0012\b\u0010ã\u0001\u001a\u00030â\u0001\u0012\b\u0010ô\u0001\u001a\u00030ó\u0001\u0012\b\u0010ñ\u0001\u001a\u00030ð\u0001\u0012\b\u0010\u0080\u0002\u001a\u00030ÿ\u0001\u0012\b\u0010\u0083\u0002\u001a\u00030\u0082\u0002\u0012\b\u0010\u009c\u0002\u001a\u00030\u009b\u0002\u0012\b\u0010Ú\u0001\u001a\u00030Ù\u0001\u0012\b\u0010Ý\u0001\u001a\u00030Ü\u0001\u0012\b\u0010°\u0002\u001a\u00030¯\u0002\u0012\b\u0010§\u0002\u001a\u00030¦\u0002\u0012\b\u0010³\u0002\u001a\u00030²\u0002\u0012\b\u0010\u008c\u0002\u001a\u00030\u008b\u0002\u0012\b\u0010ª\u0002\u001a\u00030©\u0002\u0012\b\u0010\u0086\u0002\u001a\u00030\u0085\u0002\u0012\b\u0010\u0089\u0002\u001a\u00030\u0088\u0002\u0012\b\u0010×\u0001\u001a\u00030Ö\u0001¢\u0006\u0006\bµ\u0002\u0010¶\u0002J\u001d\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\b\u0010\tJ*\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006\"\u0004\b\u0000\u0010\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006H\u0096\u0001¢\u0006\u0004\b\f\u0010\rJ*\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\u000e\"\u0004\b\u0000\u0010\n2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u000eH\u0096\u0001¢\u0006\u0004\b\f\u0010\u0010J\u0010\u0010\u0012\u001a\u00020\u0011H\u0096\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0014\u001a\u00020\u0011H\u0002¢\u0006\u0004\b\u0014\u0010\u0013J\u001d\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00170\u00062\u0006\u0010\u0016\u001a\u00020\u0015H\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u001b\u001a\u00020\u001aH\u0096\u0001¢\u0006\u0004\b\u001b\u0010\u001cJ\u0010\u0010\u001d\u001a\u00020\u001aH\u0096\u0001¢\u0006\u0004\b\u001d\u0010\u001cJ\u0010\u0010\u001f\u001a\u00020\u001eH\u0096\u0001¢\u0006\u0004\b\u001f\u0010 J\u001d\u0010$\u001a\b\u0012\u0004\u0012\u00020#0\u00062\u0006\u0010\"\u001a\u00020!H\u0016¢\u0006\u0004\b$\u0010%J*\u0010)\u001a\b\u0012\u0004\u0012\u00020'0\u00062\u0012\u0010(\u001a\u000e\u0012\u0004\u0012\u00020'\u0012\u0004\u0012\u00020'0&H\u0096\u0001¢\u0006\u0004\b)\u0010*J*\u0010+\u001a\b\u0012\u0004\u0012\u00020'0\u000e2\u0012\u0010(\u001a\u000e\u0012\u0004\u0012\u00020'\u0012\u0004\u0012\u00020'0&H\u0096\u0001¢\u0006\u0004\b+\u0010,J\u001d\u00100\u001a\b\u0012\u0004\u0012\u00020/0\u00062\u0006\u0010.\u001a\u00020-H\u0016¢\u0006\u0004\b0\u00101J\u001d\u00105\u001a\b\u0012\u0004\u0012\u0002040\u00062\u0006\u00103\u001a\u000202H\u0016¢\u0006\u0004\b5\u00106J\u0015\u00108\u001a\b\u0012\u0004\u0012\u0002070\u0006H\u0002¢\u0006\u0004\b8\u00109J\u0015\u0010:\u001a\b\u0012\u0004\u0012\u00020'0\u0006H\u0002¢\u0006\u0004\b:\u00109J\u0016\u0010;\u001a\b\u0012\u0004\u0012\u00020'0\u0006H\u0096\u0001¢\u0006\u0004\b;\u00109J\u001b\u0010=\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020'0<0\u0006H\u0016¢\u0006\u0004\b=\u00109J\u0015\u0010?\u001a\b\u0012\u0004\u0012\u00020>0\u0006H\u0016¢\u0006\u0004\b?\u00109J\u001d\u0010C\u001a\b\u0012\u0004\u0012\u00020B0\u00062\u0006\u0010A\u001a\u00020@H\u0016¢\u0006\u0004\bC\u0010DJ)\u0010I\u001a\f\u0012\b\u0012\u0006*\u00020H0H0G2\u0006\u0010E\u001a\u00020'2\u0006\u0010F\u001a\u00020'H\u0002¢\u0006\u0004\bI\u0010JJ\u001d\u0010L\u001a\b\u0012\u0004\u0012\u00020K0\u00062\u0006\u0010E\u001a\u00020'H\u0016¢\u0006\u0004\bL\u0010MJ\u001d\u0010N\u001a\b\u0012\u0004\u0012\u00020K0\u00062\u0006\u0010E\u001a\u00020'H\u0016¢\u0006\u0004\bN\u0010MJ'\u0010P\u001a\u001a\u0012\b\u0012\u0006*\u00020O0O*\f\u0012\b\u0012\u0006*\u00020O0O0\u00060\u0006H\u0002¢\u0006\u0004\bP\u00109J!\u0010R\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020'\u0012\u0004\u0012\u00020Q0&0\u0006H\u0016¢\u0006\u0004\bR\u00109J\u0015\u0010S\u001a\b\u0012\u0004\u0012\u00020'0\u0006H\u0016¢\u0006\u0004\bS\u00109J%\u0010W\u001a\b\u0012\u0004\u0012\u00020V0\u00062\u0006\u0010T\u001a\u00020'2\u0006\u0010U\u001a\u00020'H\u0016¢\u0006\u0004\bW\u0010XJ\u001d\u0010Z\u001a\b\u0012\u0004\u0012\u00020Y0\u00062\u0006\u0010U\u001a\u00020'H\u0016¢\u0006\u0004\bZ\u0010MJ\u0015\u0010[\u001a\b\u0012\u0004\u0012\u00020V0\u0006H\u0016¢\u0006\u0004\b[\u00109J\u001d\u0010^\u001a\b\u0012\u0004\u0012\u00020]0\u00062\u0006\u0010\\\u001a\u00020'H\u0016¢\u0006\u0004\b^\u0010MJ\u001b\u0010`\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020'0_0\u0006H\u0016¢\u0006\u0004\b`\u00109J\u0015\u0010b\u001a\b\u0012\u0004\u0012\u00020a0\u0006H\u0016¢\u0006\u0004\bb\u00109J/\u0010c\u001a\u001a\u0012\b\u0012\u0006*\u00020H0H*\f\u0012\b\u0012\u0006*\u00020H0H0\u00060\u00062\u0006\u0010F\u001a\u00020'H\u0002¢\u0006\u0004\bc\u0010MJ%\u0010f\u001a\b\u0012\u0004\u0012\u00020'0\u00062\u0006\u0010d\u001a\u00020'2\u0006\u0010e\u001a\u00020'H\u0016¢\u0006\u0004\bf\u0010XJ\u0015\u0010h\u001a\b\u0012\u0004\u0012\u00020g0\u0006H\u0002¢\u0006\u0004\bh\u00109J\u0015\u0010j\u001a\b\u0012\u0004\u0012\u00020i0\u0006H\u0016¢\u0006\u0004\bj\u00109J\u0015\u0010l\u001a\b\u0012\u0004\u0012\u00020k0\u0006H\u0002¢\u0006\u0004\bl\u00109J\u0015\u0010m\u001a\b\u0012\u0004\u0012\u00020Y0\u0006H\u0016¢\u0006\u0004\bm\u00109J\u0015\u0010n\u001a\b\u0012\u0004\u0012\u00020V0\u0006H\u0016¢\u0006\u0004\bn\u00109J\u0015\u0010o\u001a\b\u0012\u0004\u0012\u00020'0\u0006H\u0002¢\u0006\u0004\bo\u00109J\u001d\u0010s\u001a\b\u0012\u0004\u0012\u00020r0\u00062\u0006\u0010q\u001a\u00020pH\u0016¢\u0006\u0004\bs\u0010tJ\u001d\u0010x\u001a\b\u0012\u0004\u0012\u00020w0\u00062\u0006\u0010v\u001a\u00020uH\u0016¢\u0006\u0004\bx\u0010yJ\u001d\u0010}\u001a\b\u0012\u0004\u0012\u00020|0\u00062\u0006\u0010{\u001a\u00020zH\u0016¢\u0006\u0004\b}\u0010~J\"\u0010\u0082\u0001\u001a\t\u0012\u0005\u0012\u00030\u0081\u00010\u00062\u0007\u0010\u0080\u0001\u001a\u00020\u007fH\u0016¢\u0006\u0006\b\u0082\u0001\u0010\u0083\u0001J#\u0010\u0087\u0001\u001a\t\u0012\u0005\u0012\u00030\u0086\u00010\u00062\b\u0010\u0085\u0001\u001a\u00030\u0084\u0001H\u0016¢\u0006\u0006\b\u0087\u0001\u0010\u0088\u0001J!\u0010\u008b\u0001\u001a\t\u0012\u0005\u0012\u00030\u008a\u00010\u00062\u0007\u0010\u0089\u0001\u001a\u00020'H\u0016¢\u0006\u0005\b\u008b\u0001\u0010MJ#\u0010\u008f\u0001\u001a\t\u0012\u0005\u0012\u00030\u008e\u00010\u00062\b\u0010\u008d\u0001\u001a\u00030\u008c\u0001H\u0016¢\u0006\u0006\b\u008f\u0001\u0010\u0090\u0001J#\u0010\u0091\u0001\u001a\t\u0012\u0005\u0012\u00030\u008e\u00010\u00062\b\u0010\u008d\u0001\u001a\u00030\u008c\u0001H\u0016¢\u0006\u0006\b\u0091\u0001\u0010\u0090\u0001J7\u0010\u0097\u0001\u001a\b\u0012\u0004\u0012\u00020|0\u00062\b\u0010\u0093\u0001\u001a\u00030\u0092\u00012\u0007\u0010\u0094\u0001\u001a\u00020O2\n\u0010\u0096\u0001\u001a\u0005\u0018\u00010\u0095\u0001H\u0016¢\u0006\u0006\b\u0097\u0001\u0010\u0098\u0001Ja\u0010 \u0001\u001a\f\u0012\b\u0012\u0006*\u00020|0|0\u00062\b\u0010\u0093\u0001\u001a\u00030\u0092\u00012\n\u0010\u009a\u0001\u001a\u0005\u0018\u00010\u0099\u00012\u0007\u0010\u009b\u0001\u001a\u00020'2\u0007\u0010\u009c\u0001\u001a\u00020O2\t\u0010\u009d\u0001\u001a\u0004\u0018\u00010'2\u0007\u0010\u009e\u0001\u001a\u00020g2\u0007\u0010\u009f\u0001\u001a\u00020kH\u0002¢\u0006\u0006\b \u0001\u0010¡\u0001J\u001f\u0010¢\u0001\u001a\b\u0012\u0004\u0012\u00020O0\u00062\u0006\u0010U\u001a\u00020'H\u0016¢\u0006\u0005\b¢\u0001\u0010MJ'\u0010£\u0001\u001a\b\u0012\u0004\u0012\u00020O0\u00062\u0006\u0010T\u001a\u00020'2\u0006\u0010U\u001a\u00020'H\u0016¢\u0006\u0005\b£\u0001\u0010XJ)\u0010¥\u0001\u001a\b\u0012\u0004\u0012\u00020O0\u00062\u0006\u0010U\u001a\u00020'2\u0007\u0010¤\u0001\u001a\u00020YH\u0016¢\u0006\u0006\b¥\u0001\u0010¦\u0001J!\u0010¨\u0001\u001a\b\u0012\u0004\u0012\u00020O0\u00062\u0007\u0010§\u0001\u001a\u00020YH\u0016¢\u0006\u0006\b¨\u0001\u0010©\u0001J!\u0010«\u0001\u001a\b\u0012\u0004\u0012\u00020O0\u00062\u0007\u0010ª\u0001\u001a\u00020VH\u0016¢\u0006\u0006\b«\u0001\u0010¬\u0001J!\u0010®\u0001\u001a\b\u0012\u0004\u0012\u00020O0\u00062\u0007\u0010\u00ad\u0001\u001a\u00020VH\u0016¢\u0006\u0006\b®\u0001\u0010¬\u0001J\"\u0010±\u0001\u001a\b\u0012\u0004\u0012\u00020O0\u00062\b\u0010°\u0001\u001a\u00030¯\u0001H\u0016¢\u0006\u0006\b±\u0001\u0010²\u0001J#\u0010¶\u0001\u001a\t\u0012\u0005\u0012\u00030µ\u00010\u00062\b\u0010´\u0001\u001a\u00030³\u0001H\u0016¢\u0006\u0006\b¶\u0001\u0010·\u0001J#\u0010º\u0001\u001a\t\u0012\u0005\u0012\u00030µ\u00010\u00062\b\u0010¹\u0001\u001a\u00030¸\u0001H\u0016¢\u0006\u0006\bº\u0001\u0010»\u0001J\"\u0010¾\u0001\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\b\u0010½\u0001\u001a\u00030¼\u0001H\u0016¢\u0006\u0006\b¾\u0001\u0010¿\u0001J\u0016\u0010À\u0001\u001a\u00020O*\u00020HH\u0002¢\u0006\u0006\bÀ\u0001\u0010Á\u0001J\u0017\u0010Ã\u0001\u001a\u00020O*\u00030Â\u0001H\u0002¢\u0006\u0006\bÃ\u0001\u0010Ä\u0001R\u0018\u0010Æ\u0001\u001a\u00030Å\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\bÆ\u0001\u0010Ç\u0001R!\u0010Í\u0001\u001a\u00030È\u00018CX\u0082\u0084\u0002¢\u0006\u0010\n\u0006\bÉ\u0001\u0010Ê\u0001\u001a\u0006\bË\u0001\u0010Ì\u0001R\u0018\u0010Ï\u0001\u001a\u00030Î\u00018\u0002X\u0083\u0004¢\u0006\b\n\u0006\bÏ\u0001\u0010Ð\u0001R(\u0010Õ\u0001\u001a\n\u0012\u0005\u0012\u00030Â\u00010Ñ\u00018CX\u0083\u0084\u0002¢\u0006\u0010\n\u0006\bÒ\u0001\u0010Ê\u0001\u001a\u0006\bÓ\u0001\u0010Ô\u0001R\u0018\u0010×\u0001\u001a\u00030Ö\u00018\u0002X\u0083\u0004¢\u0006\b\n\u0006\b×\u0001\u0010Ø\u0001R\u0018\u0010Ú\u0001\u001a\u00030Ù\u00018\u0002X\u0083\u0004¢\u0006\b\n\u0006\bÚ\u0001\u0010Û\u0001R\u0018\u0010Ý\u0001\u001a\u00030Ü\u00018\u0002X\u0083\u0004¢\u0006\b\n\u0006\bÝ\u0001\u0010Þ\u0001R\u0018\u0010à\u0001\u001a\u00030ß\u00018\u0002X\u0083\u0004¢\u0006\b\n\u0006\bà\u0001\u0010á\u0001R\u0018\u0010ã\u0001\u001a\u00030â\u00018\u0002X\u0083\u0004¢\u0006\b\n\u0006\bã\u0001\u0010ä\u0001R\u0018\u0010æ\u0001\u001a\u00030å\u00018\u0002X\u0083\u0004¢\u0006\b\n\u0006\bæ\u0001\u0010ç\u0001R!\u0010ì\u0001\u001a\u00030è\u00018CX\u0083\u0084\u0002¢\u0006\u0010\n\u0006\bé\u0001\u0010Ê\u0001\u001a\u0006\bê\u0001\u0010ë\u0001R!\u0010ï\u0001\u001a\u00030è\u00018CX\u0083\u0084\u0002¢\u0006\u0010\n\u0006\bí\u0001\u0010Ê\u0001\u001a\u0006\bî\u0001\u0010ë\u0001R\u0018\u0010ñ\u0001\u001a\u00030ð\u00018\u0002X\u0083\u0004¢\u0006\b\n\u0006\bñ\u0001\u0010ò\u0001R\u0018\u0010ô\u0001\u001a\u00030ó\u00018\u0002X\u0083\u0004¢\u0006\b\n\u0006\bô\u0001\u0010õ\u0001R!\u0010ø\u0001\u001a\u00030è\u00018CX\u0083\u0084\u0002¢\u0006\u0010\n\u0006\bö\u0001\u0010Ê\u0001\u001a\u0006\b÷\u0001\u0010ë\u0001R\u001f\u0010ú\u0001\u001a\n\u0012\u0005\u0012\u00030Â\u00010ù\u00018\u0002X\u0083\u0004¢\u0006\b\n\u0006\bú\u0001\u0010û\u0001R\u0018\u0010ý\u0001\u001a\u00030ü\u00018\u0002X\u0083\u0004¢\u0006\b\n\u0006\bý\u0001\u0010þ\u0001R\u0018\u0010\u0080\u0002\u001a\u00030ÿ\u00018\u0002X\u0083\u0004¢\u0006\b\n\u0006\b\u0080\u0002\u0010\u0081\u0002R\u0018\u0010\u0083\u0002\u001a\u00030\u0082\u00028\u0002X\u0083\u0004¢\u0006\b\n\u0006\b\u0083\u0002\u0010\u0084\u0002R\u0018\u0010\u0086\u0002\u001a\u00030\u0085\u00028\u0002X\u0083\u0004¢\u0006\b\n\u0006\b\u0086\u0002\u0010\u0087\u0002R\u0018\u0010\u0089\u0002\u001a\u00030\u0088\u00028\u0002X\u0083\u0004¢\u0006\b\n\u0006\b\u0089\u0002\u0010\u008a\u0002R\u0018\u0010\u008c\u0002\u001a\u00030\u008b\u00028\u0002X\u0083\u0004¢\u0006\b\n\u0006\b\u008c\u0002\u0010\u008d\u0002R&\u0010\u0092\u0002\u001a\b*\u00030\u008e\u00020\u008e\u00028CX\u0083\u0084\u0002¢\u0006\u0010\n\u0006\b\u008f\u0002\u0010Ê\u0001\u001a\u0006\b\u0090\u0002\u0010\u0091\u0002R!\u0010\u0097\u0002\u001a\u00030\u0093\u00028CX\u0083\u0084\u0002¢\u0006\u0010\n\u0006\b\u0094\u0002\u0010Ê\u0001\u001a\u0006\b\u0095\u0002\u0010\u0096\u0002R\u0018\u0010\u0099\u0002\u001a\u00030\u0098\u00028\u0002X\u0083\u0004¢\u0006\b\n\u0006\b\u0099\u0002\u0010\u009a\u0002R\u0018\u0010\u009c\u0002\u001a\u00030\u009b\u00028\u0002X\u0083\u0004¢\u0006\b\n\u0006\b\u009c\u0002\u0010\u009d\u0002R\u0018\u0010\u009f\u0002\u001a\u00030\u009e\u00028\u0002X\u0083\u0004¢\u0006\b\n\u0006\b\u009f\u0002\u0010 \u0002R&\u0010¥\u0002\u001a\b*\u00030¡\u00020¡\u00028CX\u0083\u0084\u0002¢\u0006\u0010\n\u0006\b¢\u0002\u0010Ê\u0001\u001a\u0006\b£\u0002\u0010¤\u0002R\u0018\u0010§\u0002\u001a\u00030¦\u00028\u0002X\u0083\u0004¢\u0006\b\n\u0006\b§\u0002\u0010¨\u0002R\u0018\u0010ª\u0002\u001a\u00030©\u00028\u0002X\u0083\u0004¢\u0006\b\n\u0006\bª\u0002\u0010«\u0002R!\u0010®\u0002\u001a\u00030\u0093\u00028CX\u0083\u0084\u0002¢\u0006\u0010\n\u0006\b¬\u0002\u0010Ê\u0001\u001a\u0006\b\u00ad\u0002\u0010\u0096\u0002R\u0018\u0010°\u0002\u001a\u00030¯\u00028\u0002X\u0083\u0004¢\u0006\b\n\u0006\b°\u0002\u0010±\u0002R\u0018\u0010³\u0002\u001a\u00030²\u00028\u0002X\u0083\u0004¢\u0006\b\n\u0006\b³\u0002\u0010´\u0002"}, d2 = {"Lid/dana/cashier/data/repository/CashierEntityRepository;", "Lid/dana/cashier/domain/CashierRepository;", "Lid/dana/data/holdlogin/v1/HoldLoginV1Repository;", "Lid/dana/domain/card/repository/CardCredentialRepository;", "Lid/dana/cashier/domain/model/AddAssetCardForUserRequest;", "addAssetCardForUserRequest", "Lio/reactivex/Observable;", "Lid/dana/utils/rpc/response/DefaultResponse;", "addAssetCardForUser", "(Lid/dana/cashier/domain/model/AddAssetCardForUserRequest;)Lio/reactivex/Observable;", "T", "observable", "authenticatedRequest", "(Lio/reactivex/Observable;)Lio/reactivex/Observable;", "Lkotlinx/coroutines/flow/Flow;", "flow", "(Lkotlinx/coroutines/flow/Flow;)Lkotlinx/coroutines/flow/Flow;", "Lid/dana/data/account/repository/source/AccountEntityData;", "createAccountData", "()Lid/dana/data/account/repository/source/AccountEntityData;", "createAccountLocalEntityData", "Lid/dana/cashier/domain/model/CashierAgreementRequest;", "cashierAgreementRequest", "Lid/dana/cashier/domain/model/CashierAgreementResponse;", "createCashierAgreement", "(Lid/dana/cashier/domain/model/CashierAgreementRequest;)Lio/reactivex/Observable;", "Lid/dana/data/errorconfig/ErrorConfigEntityData;", "createLocalErrorConfigData", "()Lid/dana/data/errorconfig/ErrorConfigEntityData;", "createNetworkErrorConfigData", "Lid/dana/data/login/source/LoginEntityData;", "createNetworkLogin", "()Lid/dana/data/login/source/LoginEntityData;", "Lid/dana/cashier/domain/model/CreateOrderRequest;", "createOrderRequest", "Lid/dana/cashier/domain/model/CreateOrderInfo;", "createOrder", "(Lid/dana/cashier/domain/model/CreateOrderRequest;)Lio/reactivex/Observable;", "", "", "cardCredentials", "encryptCardCredentials", "(Ljava/util/Map;)Lio/reactivex/Observable;", "encryptCardCredentialsFlow", "(Ljava/util/Map;)Lkotlinx/coroutines/flow/Flow;", "Lid/dana/cashier/domain/model/FetchBannerRequest;", "fetchBannerRequest", "Lid/dana/cashier/domain/model/FetchBannerInfo;", "fetchBanner", "(Lid/dana/cashier/domain/model/FetchBannerRequest;)Lio/reactivex/Observable;", "Lid/dana/cashier/domain/model/NpsSurveyConsultRequest;", "npsSurveyConsultRequest", "Lid/dana/cashier/domain/model/NpsSurveyConsultInfo;", "fetchNpsSurvey", "(Lid/dana/cashier/domain/model/NpsSurveyConsultRequest;)Lio/reactivex/Observable;", "Lid/dana/data/config/source/amcs/result/BannerConfigResult;", "getBannerConfig", "()Lio/reactivex/Observable;", "getCardCredentialKey", "getCardCredentialPublicKey", "", "getCashierEntryPoints", "Lid/dana/cashier/domain/model/CashierHighlightConfig;", "getCashierHighlightConfig", "Lid/dana/cashier/domain/model/GetCashierKybProductRequest;", "cashierKybProductRequest", "Lid/dana/cashier/domain/model/CashierKybProductInfo;", "getCashierKybProduct", "(Lid/dana/cashier/domain/model/GetCashierKybProductRequest;)Lio/reactivex/Observable;", "spaceCode", "cacheKey", "Lio/reactivex/Single;", "Lid/dana/data/content/source/network/result/SpaceRpcResult;", "getCdpFromNetworkAndSave", "(Ljava/lang/String;Ljava/lang/String;)Lio/reactivex/Single;", "Lid/dana/domain/promotion/Space;", "getCdpGuide", "(Ljava/lang/String;)Lio/reactivex/Observable;", "getCdpPaylaterCicilOnboardingContent", "", "getConfigCardInfo", "Lid/dana/cashier/domain/model/CashierCurrencyFromCdn;", "getCurrencyFromCdn", "getHighlightNewInstId", "mode", "instId", "", "getHighlightTimeShown", "(Ljava/lang/String;Ljava/lang/String;)Lio/reactivex/Observable;", "", "getHighlightVersion", "getLastTimeSmartPayActivationShow", "agreementKey", "Lid/dana/cashier/domain/model/paylater/LoanRegisterResultInfo;", "getLoanRegisterInfo", "", "getModalCategory", "Lid/dana/cashier/domain/model/CashierAddOnModalContent;", "getModalContent", "getNonEmptyCachedCdp", "scenario", "deviceId", "getOneklikRedirectUrl", "Lid/dana/data/config/model/PayLaterMethodConfig;", "getPayLaterConfig", "Lid/dana/domain/paylater/model/PaylaterAgreementConfig;", "getPaylaterAgreementConfig", "Lid/dana/domain/paylater/model/PaylaterCicilMethodConfig;", "getPaylaterCicilMethodConfig", "getPaylaterCicilRegistrationCacheCooldownCount", "getPaylaterCicilRegistrationCacheCooldownDelay", "getPhoneNumber", "Lid/dana/cashier/domain/model/QueryCardPolicy;", "queryCardPolicy", "Lid/dana/cashier/domain/model/QueryCardPolicyInfo;", "getQueryCardPolicyByCardNo", "(Lid/dana/cashier/domain/model/QueryCardPolicy;)Lio/reactivex/Observable;", "Lid/dana/cashier/domain/model/paylater/QueryInstallmentRequest;", "queryInstallmentRequest", "Lid/dana/cashier/domain/model/paylater/QueryInstallment;", "getQueryInstallment", "(Lid/dana/cashier/domain/model/paylater/QueryInstallmentRequest;)Lio/reactivex/Observable;", "Lid/dana/cashier/domain/model/QueryPayOptionInfoRequest;", "queryPayOptionInfoRequest", "Lid/dana/cashier/domain/model/CashierPay;", "getQueryPayOption", "(Lid/dana/cashier/domain/model/QueryPayOptionInfoRequest;)Lio/reactivex/Observable;", "Lid/dana/cashier/domain/model/QueryPromotionRequest;", "queryPromotionRequest", "Lid/dana/cashier/domain/model/QueryPromotionInfo;", "getQueryPromotion", "(Lid/dana/cashier/domain/model/QueryPromotionRequest;)Lio/reactivex/Observable;", "Lid/dana/cashier/domain/model/CashierAddOnModalTooltipRequest;", "cashierAddOnModalTooltipRequest", "Lid/dana/cashier/domain/model/CashierAddOnModalTooltip;", "getTooltipContent", "(Lid/dana/cashier/domain/model/CashierAddOnModalTooltipRequest;)Lio/reactivex/Observable;", "tooltip", "Lid/dana/cashier/domain/model/CashierAddOnCdnTooltip;", "getTooltipFromCdn", "Lid/dana/cashier/domain/model/TopUpConsultRequest;", "topUpConsultRequest", "Lid/dana/cashier/domain/model/TopUpConsult;", "getTopUpAgent", "(Lid/dana/cashier/domain/model/TopUpConsultRequest;)Lio/reactivex/Observable;", "getTopUpConsult", "Lid/dana/cashier/domain/model/CashierPayRequest;", "cashierPayRequest", "isGpsActive", "Lid/dana/cashier/domain/model/paylater/PaylaterCashierPayRequest;", "paylaterCashierPayRequest", "payCashier", "(Lid/dana/cashier/domain/model/CashierPayRequest;ZLid/dana/cashier/domain/model/paylater/PaylaterCashierPayRequest;)Lio/reactivex/Observable;", "Lid/dana/cashier/data/repository/source/network/request/AdditionalPaylaterCashierPayRequest;", "additionalPaylaterCashierPayRequest", RecordError.KEY_PUB_KEY, "isEnable", "cityName", "payLaterMethodConfig", "paylaterCicilMethodConfig", "payCashierWithCredential", "(Lid/dana/cashier/domain/model/CashierPayRequest;Lid/dana/cashier/data/repository/source/network/request/AdditionalPaylaterCashierPayRequest;Ljava/lang/String;ZLjava/lang/String;Lid/dana/data/config/model/PayLaterMethodConfig;Lid/dana/domain/paylater/model/PaylaterCicilMethodConfig;)Lio/reactivex/Observable;", "saveHighlightNewInstId", "saveHighlightTimeShown", "version", "saveHighlightVersion", "(Ljava/lang/String;I)Lio/reactivex/Observable;", "cacheCooldownCount", "savePaylaterCicilRegistrationCacheCooldownCount", "(I)Lio/reactivex/Observable;", "cacheCooldownDelayStartTime", "savePaylaterCicilRegistrationCacheCooldownDelay", "(J)Lio/reactivex/Observable;", "lastTime", "setLastSmartPayActivationShow", "Lid/dana/cashier/domain/model/NpsSurveySubmitRequest;", "npsSurveySubmitRequest", "submitNpsSurvey", "(Lid/dana/cashier/domain/model/NpsSurveySubmitRequest;)Lio/reactivex/Observable;", "Lid/dana/cashier/domain/model/TopUpSubmitRequest;", "topUpSubmitRequest", "Lid/dana/cashier/domain/model/TopUpPay;", "topUpSubmit", "(Lid/dana/cashier/domain/model/TopUpSubmitRequest;)Lio/reactivex/Observable;", "Lid/dana/cashier/domain/model/TopUpVerifyRequest;", "topUpVerifyRequest", "topUpVerify", "(Lid/dana/cashier/domain/model/TopUpVerifyRequest;)Lio/reactivex/Observable;", "Lid/dana/cashier/domain/model/CashierUpdateOrderRequest;", "cashierUpdateOrderRequest", "updateOrder", "(Lid/dana/cashier/domain/model/CashierUpdateOrderRequest;)Lio/reactivex/Observable;", "cdpContentIsEmpty", "(Lid/dana/data/content/source/network/result/SpaceRpcResult;)Z", "Lid/dana/cashier/data/repository/source/network/result/TimedSpaceRpcResult;", "isStale", "(Lid/dana/cashier/data/repository/source/network/result/TimedSpaceRpcResult;)Z", "Lid/dana/data/account/repository/source/AccountEntityDataFactory;", "accountEntityDataFactory", "Lid/dana/data/account/repository/source/AccountEntityDataFactory;", "Lid/dana/cashier/data/repository/source/CashierBannerManagementEntityData;", "bannerManagementEntityData$delegate", "Lkotlin/Lazy;", "getBannerManagementEntityData", "()Lid/dana/cashier/data/repository/source/CashierBannerManagementEntityData;", "bannerManagementEntityData", "Lid/dana/cashier/data/repository/source/CashierBannerManagementEntityDataFactory;", "bannerManagementEntityDataFactory", "Lid/dana/cashier/data/repository/source/CashierBannerManagementEntityDataFactory;", "Lid/dana/data/cache/CacheEntityData;", "cacheCdpGuideEntityData$delegate", "getCacheCdpGuideEntityData", "()Lid/dana/data/cache/CacheEntityData;", "cacheCdpGuideEntityData", "Lid/dana/data/card/repository/CardCredentialEntityRepository;", "cardCredentialEntityRepository", "Lid/dana/data/card/repository/CardCredentialEntityRepository;", "Lid/dana/cashier/data/mapper/CashierAddOnModalTooltipRequestMapper;", "cashierAddOnModalTooltipRequestMapper", "Lid/dana/cashier/data/mapper/CashierAddOnModalTooltipRequestMapper;", "Lid/dana/cashier/data/mapper/CashierAddOnModalTooltipResultMapper;", "cashierAddOnModalTooltipResultMapper", "Lid/dana/cashier/data/mapper/CashierAddOnModalTooltipResultMapper;", "Lid/dana/cashier/data/mapper/CashierEKtpAgreementRequestMapper;", "cashierEKtpAgreementRequestMapper", "Lid/dana/cashier/data/mapper/CashierEKtpAgreementRequestMapper;", "Lid/dana/cashier/data/mapper/CashierEKtpAgreementResultMapper;", "cashierEKtpAgreementResultMapper", "Lid/dana/cashier/data/mapper/CashierEKtpAgreementResultMapper;", "Lid/dana/cashier/data/repository/source/CashierEntityDataFactory;", "cashierEntityDataFactory", "Lid/dana/cashier/data/repository/source/CashierEntityDataFactory;", "Lid/dana/cashier/data/repository/source/CashierEntityData;", "cashierLocalEntityData$delegate", "getCashierLocalEntityData", "()Lid/dana/cashier/data/repository/source/CashierEntityData;", "cashierLocalEntityData", "cashierNetworkEntityData$delegate", "getCashierNetworkEntityData", "cashierNetworkEntityData", "Lid/dana/cashier/data/mapper/CashierPayInfoRequestMapper;", "cashierPayInfoRequestMapper", "Lid/dana/cashier/data/mapper/CashierPayInfoRequestMapper;", "Lid/dana/cashier/data/mapper/CashierPayInfoResultMapper;", "cashierPayInfoResultMapper", "Lid/dana/cashier/data/mapper/CashierPayInfoResultMapper;", "cashierSplitEntityData$delegate", "getCashierSplitEntityData", "cashierSplitEntityData", "Lid/dana/cashier/data/repository/source/CdpGuideCacheEntityDataFactory;", "contentDeliveryCacheEntityDataFactory", "Lid/dana/cashier/data/repository/source/CdpGuideCacheEntityDataFactory;", "Lid/dana/data/content/source/ContentDeliveryEntityDataFactory;", "contentDeliveryEntityDataFactory", "Lid/dana/data/content/source/ContentDeliveryEntityDataFactory;", "Lid/dana/cashier/data/mapper/CreateOrderInfoRequestMapper;", "createOrderInfoRequestMapper", "Lid/dana/cashier/data/mapper/CreateOrderInfoRequestMapper;", "Lid/dana/cashier/data/mapper/CreateOrderInfoResultMapper;", "createOrderInfoResultMapper", "Lid/dana/cashier/data/mapper/CreateOrderInfoResultMapper;", "Lid/dana/data/geocode/repository/GeocodeEntityRepository;", "geocodeEntityRepository", "Lid/dana/data/geocode/repository/GeocodeEntityRepository;", "Lid/dana/data/holdlogin/v1/HoldLoginV1EntityRepository;", "holdLoginV1EntityRepository", "Lid/dana/data/holdlogin/v1/HoldLoginV1EntityRepository;", "Lid/dana/cashier/data/mapper/LoanRegisterMapper;", "loanRegisterMapper", "Lid/dana/cashier/data/mapper/LoanRegisterMapper;", "Lid/dana/data/content/source/ContentDeliveryEntityData;", "networkCdpGuideEntityData$delegate", "getNetworkCdpGuideEntityData", "()Lid/dana/data/content/source/ContentDeliveryEntityData;", "networkCdpGuideEntityData", "Lid/dana/data/paylater/repository/PaylaterEntityData;", "networkPaylaterEntityData$delegate", "getNetworkPaylaterEntityData", "()Lid/dana/data/paylater/repository/PaylaterEntityData;", "networkPaylaterEntityData", "Lid/dana/data/paylater/repository/PaylaterEntityDataFactory;", "paylaterEntityDataFactory", "Lid/dana/data/paylater/repository/PaylaterEntityDataFactory;", "Lid/dana/cashier/data/mapper/QueryPromotionInfoResultMapper;", "queryPromotionInfoResultMapper", "Lid/dana/cashier/data/mapper/QueryPromotionInfoResultMapper;", "Lid/dana/data/security/source/SecurityEntityDataFactory;", "securityEntityDataFactory", "Lid/dana/data/security/source/SecurityEntityDataFactory;", "Lid/dana/data/security/source/SecurityEntityData;", "securityNetworkEntityData$delegate", "getSecurityNetworkEntityData", "()Lid/dana/data/security/source/SecurityEntityData;", "securityNetworkEntityData", "Lid/dana/data/content/mapper/SpaceResultMapper;", "spaceResultMapper", "Lid/dana/data/content/mapper/SpaceResultMapper;", "Lid/dana/data/config/source/split/SplitConfigEntityData;", "splitConfigEntityData", "Lid/dana/data/config/source/split/SplitConfigEntityData;", "splitPaylaterEntityData$delegate", "getSplitPaylaterEntityData", "splitPaylaterEntityData", "Lid/dana/cashier/data/mapper/TopUpConsultResultMapper;", "topUpConsultResultMapper", "Lid/dana/cashier/data/mapper/TopUpConsultResultMapper;", "Lid/dana/cashier/data/mapper/TopUpPayResultMapper;", "topUpPayResultMapper", "Lid/dana/cashier/data/mapper/TopUpPayResultMapper;", "<init>", "(Lid/dana/cashier/data/repository/source/CashierEntityDataFactory;Lid/dana/data/paylater/repository/PaylaterEntityDataFactory;Lid/dana/data/security/source/SecurityEntityDataFactory;Lid/dana/cashier/data/repository/source/CdpGuideCacheEntityDataFactory;Lid/dana/data/content/source/ContentDeliveryEntityDataFactory;Lid/dana/cashier/data/repository/source/CashierBannerManagementEntityDataFactory;Lid/dana/data/account/repository/source/AccountEntityDataFactory;Lid/dana/cashier/data/mapper/CashierEKtpAgreementRequestMapper;Lid/dana/cashier/data/mapper/CashierEKtpAgreementResultMapper;Lid/dana/cashier/data/mapper/CashierPayInfoResultMapper;Lid/dana/cashier/data/mapper/CashierPayInfoRequestMapper;Lid/dana/cashier/data/mapper/CreateOrderInfoRequestMapper;Lid/dana/cashier/data/mapper/CreateOrderInfoResultMapper;Lid/dana/cashier/data/mapper/QueryPromotionInfoResultMapper;Lid/dana/cashier/data/mapper/CashierAddOnModalTooltipRequestMapper;Lid/dana/cashier/data/mapper/CashierAddOnModalTooltipResultMapper;Lid/dana/cashier/data/mapper/TopUpConsultResultMapper;Lid/dana/data/content/mapper/SpaceResultMapper;Lid/dana/cashier/data/mapper/TopUpPayResultMapper;Lid/dana/cashier/data/mapper/LoanRegisterMapper;Lid/dana/data/config/source/split/SplitConfigEntityData;Lid/dana/data/geocode/repository/GeocodeEntityRepository;Lid/dana/data/holdlogin/v1/HoldLoginV1EntityRepository;Lid/dana/data/card/repository/CardCredentialEntityRepository;)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes.dex */
public final class CashierEntityRepository implements CashierRepository, HoldLoginV1Repository, CardCredentialRepository {
    private static int $10 = 0;
    private static int $11 = 1;
    private static long BuiltInFictitiousFunctionClassFactory = 0;
    public static final String CONFIG_CARD_INFO = "CONFIG_CARD_INFO";
    private static int KClassImpl$Data$declaredNonStaticMembers$2 = 0;
    private static char MyBillsEntityDataFactory = 0;
    private static int PlaceComponentResult = 0;
    private static int getAuthRequestContext = 1;
    private final AccountEntityDataFactory accountEntityDataFactory;

    /* renamed from: bannerManagementEntityData$delegate  reason: from kotlin metadata */
    private final Lazy bannerManagementEntityData;
    private final CashierBannerManagementEntityDataFactory bannerManagementEntityDataFactory;

    /* renamed from: cacheCdpGuideEntityData$delegate  reason: from kotlin metadata */
    private final Lazy cacheCdpGuideEntityData;
    private final CardCredentialEntityRepository cardCredentialEntityRepository;
    private final CashierAddOnModalTooltipRequestMapper cashierAddOnModalTooltipRequestMapper;
    private final CashierAddOnModalTooltipResultMapper cashierAddOnModalTooltipResultMapper;
    private final CashierEKtpAgreementRequestMapper cashierEKtpAgreementRequestMapper;
    private final CashierEKtpAgreementResultMapper cashierEKtpAgreementResultMapper;
    private final CashierEntityDataFactory cashierEntityDataFactory;

    /* renamed from: cashierLocalEntityData$delegate  reason: from kotlin metadata */
    private final Lazy cashierLocalEntityData;

    /* renamed from: cashierNetworkEntityData$delegate  reason: from kotlin metadata */
    private final Lazy cashierNetworkEntityData;
    private final CashierPayInfoRequestMapper cashierPayInfoRequestMapper;
    private final CashierPayInfoResultMapper cashierPayInfoResultMapper;

    /* renamed from: cashierSplitEntityData$delegate  reason: from kotlin metadata */
    private final Lazy cashierSplitEntityData;
    private final CdpGuideCacheEntityDataFactory<TimedSpaceRpcResult> contentDeliveryCacheEntityDataFactory;
    private final ContentDeliveryEntityDataFactory contentDeliveryEntityDataFactory;
    private final CreateOrderInfoRequestMapper createOrderInfoRequestMapper;
    private final CreateOrderInfoResultMapper createOrderInfoResultMapper;
    private final GeocodeEntityRepository geocodeEntityRepository;
    private final HoldLoginV1EntityRepository holdLoginV1EntityRepository;
    private final LoanRegisterMapper loanRegisterMapper;

    /* renamed from: networkCdpGuideEntityData$delegate  reason: from kotlin metadata */
    private final Lazy networkCdpGuideEntityData;

    /* renamed from: networkPaylaterEntityData$delegate  reason: from kotlin metadata */
    private final Lazy networkPaylaterEntityData;
    private final PaylaterEntityDataFactory paylaterEntityDataFactory;
    private final QueryPromotionInfoResultMapper queryPromotionInfoResultMapper;
    private final SecurityEntityDataFactory securityEntityDataFactory;

    /* renamed from: securityNetworkEntityData$delegate  reason: from kotlin metadata */
    private final Lazy securityNetworkEntityData;
    private final SpaceResultMapper spaceResultMapper;
    private final SplitConfigEntityData splitConfigEntityData;

    /* renamed from: splitPaylaterEntityData$delegate  reason: from kotlin metadata */
    private final Lazy splitPaylaterEntityData;
    private final TopUpConsultResultMapper topUpConsultResultMapper;
    private final TopUpPayResultMapper topUpPayResultMapper;

    /* renamed from: $r8$lambda$-ytvdSgRFOZ8v-76Ho54parbi7I */
    public static /* synthetic */ CashierPay m485$r8$lambda$ytvdSgRFOZ8v76Ho54parbi7I(PaylaterCicilMethodConfig paylaterCicilMethodConfig, PayLaterMethodConfig payLaterMethodConfig, CashierPay cashierPay) {
        CashierPay m528payCashierWithCredential$lambda4;
        int i = getAuthRequestContext + 113;
        PlaceComponentResult = i % 128;
        if ((i % 2 != 0 ? (char) 28 : '2') != '2') {
            m528payCashierWithCredential$lambda4 = m528payCashierWithCredential$lambda4(paylaterCicilMethodConfig, payLaterMethodConfig, cashierPay);
            int i2 = 86 / 0;
        } else {
            try {
                m528payCashierWithCredential$lambda4 = m528payCashierWithCredential$lambda4(paylaterCicilMethodConfig, payLaterMethodConfig, cashierPay);
            } catch (Exception e) {
                throw e;
            }
        }
        int i3 = getAuthRequestContext + 63;
        PlaceComponentResult = i3 % 128;
        int i4 = i3 % 2;
        return m528payCashierWithCredential$lambda4;
    }

    public static /* synthetic */ ObservableSource $r8$lambda$0PGF7pHdXwwHHE49RoPCcUiOz1Y(CashierEntityRepository cashierEntityRepository, String str) {
        int i = getAuthRequestContext + 123;
        PlaceComponentResult = i % 128;
        int i2 = i % 2;
        ObservableSource m521getPaylaterCicilRegistrationCacheCooldownCount$lambda30 = m521getPaylaterCicilRegistrationCacheCooldownCount$lambda30(cashierEntityRepository, str);
        try {
            int i3 = PlaceComponentResult + 101;
            try {
                getAuthRequestContext = i3 % 128;
                int i4 = i3 % 2;
                return m521getPaylaterCicilRegistrationCacheCooldownCount$lambda30;
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    public static /* synthetic */ ObservableSource $r8$lambda$1g8eRgVMqmiYrUbq7v6tUiQnS84(CashierEntityRepository cashierEntityRepository, String str, String str2) {
        int i = getAuthRequestContext + 83;
        PlaceComponentResult = i % 128;
        int i2 = i % 2;
        ObservableSource m529saveHighlightNewInstId$lambda26 = m529saveHighlightNewInstId$lambda26(cashierEntityRepository, str, str2);
        try {
            int i3 = PlaceComponentResult + 115;
            getAuthRequestContext = i3 % 128;
            if (!(i3 % 2 == 0)) {
                return m529saveHighlightNewInstId$lambda26;
            }
            int i4 = 7 / 0;
            return m529saveHighlightNewInstId$lambda26;
        } catch (Exception e) {
            throw e;
        }
    }

    public static /* synthetic */ ObservableSource $r8$lambda$2IPbT0EftH6xHGYw2L7RHjRn1e4(PaylaterCashierPayRequest paylaterCashierPayRequest, CashierEntityRepository cashierEntityRepository, CashierPayRequest cashierPayRequest, String str, Boolean bool, PayLaterMethodConfig payLaterMethodConfig, PaylaterCicilMethodConfig paylaterCicilMethodConfig, LocationSubdisivision locationSubdisivision) {
        int i = getAuthRequestContext + 69;
        PlaceComponentResult = i % 128;
        if (i % 2 == 0) {
            try {
                return m527payCashier$lambda1$lambda0(paylaterCashierPayRequest, cashierEntityRepository, cashierPayRequest, str, bool, payLaterMethodConfig, paylaterCicilMethodConfig, locationSubdisivision);
            } catch (Exception e) {
                throw e;
            }
        }
        ObservableSource m527payCashier$lambda1$lambda0 = m527payCashier$lambda1$lambda0(paylaterCashierPayRequest, cashierEntityRepository, cashierPayRequest, str, bool, payLaterMethodConfig, paylaterCicilMethodConfig, locationSubdisivision);
        Object obj = null;
        obj.hashCode();
        return m527payCashier$lambda1$lambda0;
    }

    public static /* synthetic */ ObservableSource $r8$lambda$44E2Z0H7UgniCsFRsgs8V0iC2Po(CashierEntityRepository cashierEntityRepository, TopUpSubmitRequest topUpSubmitRequest, String str) {
        try {
            int i = PlaceComponentResult + 3;
            getAuthRequestContext = i % 128;
            int i2 = i % 2;
            ObservableSource m536topUpSubmit$lambda19 = m536topUpSubmit$lambda19(cashierEntityRepository, topUpSubmitRequest, str);
            int i3 = getAuthRequestContext + 47;
            PlaceComponentResult = i3 % 128;
            int i4 = i3 % 2;
            return m536topUpSubmit$lambda19;
        } catch (Exception e) {
            throw e;
        }
    }

    public static /* synthetic */ ObservableSource $r8$lambda$4ujjMMmdpYIQVOkZgLXHubwWQq0(CashierEntityRepository cashierEntityRepository, long j, String str) {
        int i = getAuthRequestContext + 37;
        PlaceComponentResult = i % 128;
        char c = i % 2 != 0 ? 'c' : ':';
        ObservableSource m534setLastSmartPayActivationShow$lambda41 = m534setLastSmartPayActivationShow$lambda41(cashierEntityRepository, j, str);
        if (c == 'c') {
            Object[] objArr = null;
            int length = objArr.length;
        }
        return m534setLastSmartPayActivationShow$lambda41;
    }

    public static /* synthetic */ CashierAddOnCdnTooltip $r8$lambda$7RihpAki25fuwfNUCkgEJB1eHrE(CashierAddOnCdnTooltipResult cashierAddOnCdnTooltipResult) {
        int i = getAuthRequestContext + 71;
        PlaceComponentResult = i % 128;
        if (!(i % 2 != 0)) {
            return m525getTooltipFromCdn$lambda18(cashierAddOnCdnTooltipResult);
        }
        try {
            int i2 = 67 / 0;
            return m525getTooltipFromCdn$lambda18(cashierAddOnCdnTooltipResult);
        } catch (Exception e) {
            throw e;
        }
    }

    /* renamed from: $r8$lambda$8QVj14coOl-BVNFgFB-MbtKnNXg */
    public static /* synthetic */ ObservableSource m486$r8$lambda$8QVj14coOlBVNFgFBMbtKnNXg(CashierEntityRepository cashierEntityRepository, FetchBannerRequest fetchBannerRequest, BannerConfigResult bannerConfigResult) {
        try {
            int i = getAuthRequestContext + 23;
            PlaceComponentResult = i % 128;
            int i2 = i % 2;
            ObservableSource m499fetchBanner$lambda10 = m499fetchBanner$lambda10(cashierEntityRepository, fetchBannerRequest, bannerConfigResult);
            int i3 = getAuthRequestContext + 105;
            PlaceComponentResult = i3 % 128;
            if (i3 % 2 == 0) {
                return m499fetchBanner$lambda10;
            }
            Object[] objArr = null;
            int length = objArr.length;
            return m499fetchBanner$lambda10;
        } catch (Exception e) {
            throw e;
        }
    }

    public static /* synthetic */ DefaultResponse $r8$lambda$CWs5noJ84QRM7TJq9fuW4jYrpRo(DefaultInfoResult defaultInfoResult) {
        try {
            int i = getAuthRequestContext + 17;
            PlaceComponentResult = i % 128;
            int i2 = i % 2;
            DefaultResponse m537updateOrder$lambda17 = m537updateOrder$lambda17(defaultInfoResult);
            int i3 = getAuthRequestContext + 31;
            PlaceComponentResult = i3 % 128;
            int i4 = i3 % 2;
            return m537updateOrder$lambda17;
        } catch (Exception e) {
            throw e;
        }
    }

    public static /* synthetic */ ObservableSource $r8$lambda$DWdn1XvWOO2rs2D2wBPytp4bNYw(CashierEntityRepository cashierEntityRepository, String str, String str2, String str3) {
        int i = PlaceComponentResult + 45;
        getAuthRequestContext = i % 128;
        int i2 = i % 2;
        ObservableSource m530saveHighlightTimeShown$lambda28 = m530saveHighlightTimeShown$lambda28(cashierEntityRepository, str, str2, str3);
        int i3 = PlaceComponentResult + 99;
        getAuthRequestContext = i3 % 128;
        if ((i3 % 2 == 0 ? '(' : 'N') != '(') {
            return m530saveHighlightTimeShown$lambda28;
        }
        Object obj = null;
        obj.hashCode();
        return m530saveHighlightTimeShown$lambda28;
    }

    public static /* synthetic */ CashierHighlightConfig $r8$lambda$EKBOxQBbPCqYiW7tpKFC_atGcps(CashierHighlightConfigResult cashierHighlightConfigResult) {
        CashierHighlightConfig m503getCashierHighlightConfig$lambda23;
        try {
            int i = PlaceComponentResult + 85;
            getAuthRequestContext = i % 128;
            Object obj = null;
            if ((i % 2 == 0 ? 'F' : (char) 27) != 27) {
                try {
                    m503getCashierHighlightConfig$lambda23 = m503getCashierHighlightConfig$lambda23(cashierHighlightConfigResult);
                    obj.hashCode();
                } catch (Exception e) {
                    throw e;
                }
            } else {
                m503getCashierHighlightConfig$lambda23 = m503getCashierHighlightConfig$lambda23(cashierHighlightConfigResult);
            }
            int i2 = getAuthRequestContext + 53;
            PlaceComponentResult = i2 % 128;
            if (i2 % 2 != 0) {
                obj.hashCode();
                return m503getCashierHighlightConfig$lambda23;
            }
            return m503getCashierHighlightConfig$lambda23;
        } catch (Exception e2) {
            throw e2;
        }
    }

    /* renamed from: $r8$lambda$G4NjXbKYDTEJ5E_Vs-Sjzn_LWJY */
    public static /* synthetic */ Boolean m487$r8$lambda$G4NjXbKYDTEJ5E_VsSjzn_LWJY(NpsSurveySubmitEntityResult npsSurveySubmitEntityResult) {
        try {
            int i = PlaceComponentResult + 93;
            try {
                getAuthRequestContext = i % 128;
                int i2 = i % 2;
                Boolean m535submitNpsSurvey$lambda13 = m535submitNpsSurvey$lambda13(npsSurveySubmitEntityResult);
                int i3 = getAuthRequestContext + 121;
                PlaceComponentResult = i3 % 128;
                int i4 = i3 % 2;
                return m535submitNpsSurvey$lambda13;
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    public static /* synthetic */ boolean $r8$lambda$HN3VOoxr61MHqFHioAIfFwj_M8U(CashierEntityRepository cashierEntityRepository, TimedSpaceRpcResult timedSpaceRpcResult) {
        int i = getAuthRequestContext + 111;
        PlaceComponentResult = i % 128;
        int i2 = i % 2;
        boolean m516getNonEmptyCachedCdp$lambda34 = m516getNonEmptyCachedCdp$lambda34(cashierEntityRepository, timedSpaceRpcResult);
        int i3 = getAuthRequestContext + 31;
        PlaceComponentResult = i3 % 128;
        if ((i3 % 2 != 0 ? '*' : 'b') != 'b') {
            Object[] objArr = null;
            int length = objArr.length;
            return m516getNonEmptyCachedCdp$lambda34;
        }
        return m516getNonEmptyCachedCdp$lambda34;
    }

    public static /* synthetic */ ObservableSource $r8$lambda$IyYC0cLZCCEKmYU8u3_5U0FsRaQ(CashierEntityRepository cashierEntityRepository, long j, String str) {
        int i = getAuthRequestContext + 45;
        PlaceComponentResult = i % 128;
        int i2 = i % 2;
        try {
            ObservableSource m533savePaylaterCicilRegistrationCacheCooldownDelay$lambda33 = m533savePaylaterCicilRegistrationCacheCooldownDelay$lambda33(cashierEntityRepository, j, str);
            int i3 = getAuthRequestContext + 47;
            PlaceComponentResult = i3 % 128;
            int i4 = i3 % 2;
            return m533savePaylaterCicilRegistrationCacheCooldownDelay$lambda33;
        } catch (Exception e) {
            throw e;
        }
    }

    /* renamed from: $r8$lambda$LkfrUVCr9m30hIQ0-28BtGTRHBU */
    public static /* synthetic */ SpaceRpcResult m488$r8$lambda$LkfrUVCr9m30hIQ028BtGTRHBU(TimedSpaceRpcResult timedSpaceRpcResult) {
        int i = getAuthRequestContext + 87;
        PlaceComponentResult = i % 128;
        int i2 = i % 2;
        SpaceRpcResult m517getNonEmptyCachedCdp$lambda35 = m517getNonEmptyCachedCdp$lambda35(timedSpaceRpcResult);
        try {
            int i3 = getAuthRequestContext + 23;
            try {
                PlaceComponentResult = i3 % 128;
                if ((i3 % 2 != 0 ? '@' : 'A') != 'A') {
                    Object obj = null;
                    obj.hashCode();
                    return m517getNonEmptyCachedCdp$lambda35;
                }
                return m517getNonEmptyCachedCdp$lambda35;
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    public static /* synthetic */ ObservableSource $r8$lambda$My9TgUAOcS60AXMsbLiqWasr7s4(CashierEntityRepository cashierEntityRepository, String str, String str2, String str3) {
        int i = PlaceComponentResult + 121;
        getAuthRequestContext = i % 128;
        if (!(i % 2 == 0)) {
            try {
                return m510getHighlightTimeShown$lambda29(cashierEntityRepository, str, str2, str3);
            } catch (Exception e) {
                throw e;
            }
        }
        try {
            ObservableSource m510getHighlightTimeShown$lambda29 = m510getHighlightTimeShown$lambda29(cashierEntityRepository, str, str2, str3);
            Object obj = null;
            obj.hashCode();
            return m510getHighlightTimeShown$lambda29;
        } catch (Exception e2) {
            throw e2;
        }
    }

    public static /* synthetic */ CashierKybProductInfo $r8$lambda$VsA2gtvHVf74GKybtEsoFjlrcCk(CashierKybProductInfoResult cashierKybProductInfoResult) {
        int i = getAuthRequestContext + 73;
        PlaceComponentResult = i % 128;
        int i2 = i % 2;
        CashierKybProductInfo m504getCashierKybProduct$lambda14 = m504getCashierKybProduct$lambda14(cashierKybProductInfoResult);
        int i3 = getAuthRequestContext + 111;
        PlaceComponentResult = i3 % 128;
        int i4 = i3 % 2;
        return m504getCashierKybProduct$lambda14;
    }

    /* renamed from: $r8$lambda$Ya-KtVYywausn8shXFKbHkMJC1A */
    public static /* synthetic */ ObservableSource m489$r8$lambda$YaKtVYywausn8shXFKbHkMJC1A(CashierEntityRepository cashierEntityRepository, String str, int i, String str2) {
        try {
            int i2 = PlaceComponentResult + 47;
            getAuthRequestContext = i2 % 128;
            boolean z = i2 % 2 != 0;
            ObservableSource m531saveHighlightVersion$lambda24 = m531saveHighlightVersion$lambda24(cashierEntityRepository, str, i, str2);
            if (!z) {
                Object[] objArr = null;
                int length = objArr.length;
            }
            int i3 = PlaceComponentResult + 75;
            getAuthRequestContext = i3 % 128;
            int i4 = i3 % 2;
            return m531saveHighlightVersion$lambda24;
        } catch (Exception e) {
            throw e;
        }
    }

    public static /* synthetic */ ObservableSource $r8$lambda$_UFq1pQpdx9F6KBlT3IVm7T2TNA(CreateOrderRequest createOrderRequest, CashierEntityRepository cashierEntityRepository, String str) {
        int i = getAuthRequestContext + 71;
        PlaceComponentResult = i % 128;
        int i2 = i % 2;
        ObservableSource m498createOrder$lambda6 = m498createOrder$lambda6(createOrderRequest, cashierEntityRepository, str);
        int i3 = PlaceComponentResult + 35;
        getAuthRequestContext = i3 % 128;
        int i4 = i3 % 2;
        return m498createOrder$lambda6;
    }

    public static /* synthetic */ ObservableSource $r8$lambda$a_dQPcX4jhezblbFSWgoBENGBoU(CashierEntityRepository cashierEntityRepository, String str) {
        int i = PlaceComponentResult + 35;
        getAuthRequestContext = i % 128;
        int i2 = i % 2;
        ObservableSource m512getLastTimeSmartPayActivationShow$lambda40 = m512getLastTimeSmartPayActivationShow$lambda40(cashierEntityRepository, str);
        try {
            int i3 = PlaceComponentResult + 7;
            try {
                getAuthRequestContext = i3 % 128;
                if (i3 % 2 != 0) {
                    return m512getLastTimeSmartPayActivationShow$lambda40;
                }
                Object obj = null;
                obj.hashCode();
                return m512getLastTimeSmartPayActivationShow$lambda40;
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    /* renamed from: $r8$lambda$aun7q7oCD4UOYjQH14p-mwXaZNU */
    public static /* synthetic */ QueryCardPolicyInfo m490$r8$lambda$aun7q7oCD4UOYjQH14pmwXaZNU(QueryCardPolicyInfoResult queryCardPolicyInfoResult) {
        int i = PlaceComponentResult + 39;
        getAuthRequestContext = i % 128;
        int i2 = i % 2;
        try {
            QueryCardPolicyInfo m523getQueryCardPolicyByCardNo$lambda7 = m523getQueryCardPolicyByCardNo$lambda7(queryCardPolicyInfoResult);
            int i3 = getAuthRequestContext + 33;
            PlaceComponentResult = i3 % 128;
            if ((i3 % 2 != 0 ? '\t' : (char) 1) != '\t') {
                return m523getQueryCardPolicyByCardNo$lambda7;
            }
            int i4 = 75 / 0;
            return m523getQueryCardPolicyByCardNo$lambda7;
        } catch (Exception e) {
            throw e;
        }
    }

    public static /* synthetic */ NpsSurveyConsultInfo $r8$lambda$c8rz8NjhlYniHJAtkjLGiv3L5Yc(NpsSurveyInfoResult npsSurveyInfoResult) {
        int i = PlaceComponentResult + 47;
        getAuthRequestContext = i % 128;
        char c = i % 2 == 0 ? Typography.quote : Typography.amp;
        NpsSurveyConsultInfo m502fetchNpsSurvey$lambda12 = m502fetchNpsSurvey$lambda12(npsSurveyInfoResult);
        if (c == '\"') {
            Object[] objArr = null;
            int length = objArr.length;
        }
        return m502fetchNpsSurvey$lambda12;
    }

    public static /* synthetic */ PaylaterCicilMethodConfig $r8$lambda$caZW2Uprpn3SbEoypweLuXDDXUI(PaylaterCicilMethodConfigResult paylaterCicilMethodConfigResult) {
        int i = getAuthRequestContext + 107;
        PlaceComponentResult = i % 128;
        int i2 = i % 2;
        PaylaterCicilMethodConfig m520getPaylaterCicilMethodConfig$lambda39 = m520getPaylaterCicilMethodConfig$lambda39(paylaterCicilMethodConfigResult);
        try {
            int i3 = PlaceComponentResult + 15;
            getAuthRequestContext = i3 % 128;
            int i4 = i3 % 2;
            return m520getPaylaterCicilMethodConfig$lambda39;
        } catch (Exception e) {
            throw e;
        }
    }

    public static /* synthetic */ ObservableSource $r8$lambda$ckxgzibtquIV1FcEnYEXEzmPbOU(CashierEntityRepository cashierEntityRepository, String str) {
        int i = getAuthRequestContext + 29;
        PlaceComponentResult = i % 128;
        char c = i % 2 != 0 ? 'H' : '_';
        ObservableSource m509getHighlightNewInstId$lambda27 = m509getHighlightNewInstId$lambda27(cashierEntityRepository, str);
        if (c != '_') {
            int i2 = 37 / 0;
        }
        int i3 = PlaceComponentResult + 67;
        getAuthRequestContext = i3 % 128;
        if ((i3 % 2 == 0 ? (char) 31 : 'B') != 31) {
            return m509getHighlightNewInstId$lambda27;
        }
        int i4 = 51 / 0;
        return m509getHighlightNewInstId$lambda27;
    }

    public static /* synthetic */ FetchBannerInfo $r8$lambda$fnAufzgkIN7alRItLUMR9qJs7pA(FetchBannerInfoResult fetchBannerInfoResult) {
        int i = PlaceComponentResult + 79;
        getAuthRequestContext = i % 128;
        int i2 = i % 2;
        FetchBannerInfo m501fetchBanner$lambda10$lambda9 = m501fetchBanner$lambda10$lambda9(fetchBannerInfoResult);
        int i3 = PlaceComponentResult + 9;
        getAuthRequestContext = i3 % 128;
        int i4 = i3 % 2;
        return m501fetchBanner$lambda10$lambda9;
    }

    public static /* synthetic */ boolean $r8$lambda$jpQ5TK8aN6D9bjbf3dU9Qa6BbxE(CashierEntityRepository cashierEntityRepository, SpaceRpcResult spaceRpcResult) {
        int i = PlaceComponentResult + 37;
        getAuthRequestContext = i % 128;
        int i2 = i % 2;
        try {
            boolean m505getCdpFromNetworkAndSave$lambda36 = m505getCdpFromNetworkAndSave$lambda36(cashierEntityRepository, spaceRpcResult);
            int i3 = getAuthRequestContext + 97;
            PlaceComponentResult = i3 % 128;
            if ((i3 % 2 != 0 ? ']' : '?') != '?') {
                Object[] objArr = null;
                int length = objArr.length;
                return m505getCdpFromNetworkAndSave$lambda36;
            }
            return m505getCdpFromNetworkAndSave$lambda36;
        } catch (Exception e) {
            throw e;
        }
    }

    public static /* synthetic */ Boolean $r8$lambda$mS5A15DmwVP__klhCgp6AL6tffY(JSONObject jSONObject) {
        try {
            int i = PlaceComponentResult + 111;
            getAuthRequestContext = i % 128;
            char c = i % 2 == 0 ? (char) 30 : 'X';
            Boolean m507getConfigCardInfo$lambda2 = m507getConfigCardInfo$lambda2(jSONObject);
            if (c != 'X') {
                Object obj = null;
                obj.hashCode();
            }
            return m507getConfigCardInfo$lambda2;
        } catch (Exception e) {
            throw e;
        }
    }

    public static /* synthetic */ QueryInstallment $r8$lambda$o7yeStlNPHVjSwGMf5ZkyDtYUjk(QueryInstallmentResult queryInstallmentResult) {
        int i = getAuthRequestContext + 101;
        PlaceComponentResult = i % 128;
        boolean z = i % 2 == 0;
        QueryInstallment m524getQueryInstallment$lambda21 = m524getQueryInstallment$lambda21(queryInstallmentResult);
        if (!z) {
            int i2 = 94 / 0;
        }
        int i3 = getAuthRequestContext + 107;
        PlaceComponentResult = i3 % 128;
        int i4 = i3 % 2;
        return m524getQueryInstallment$lambda21;
    }

    /* renamed from: $r8$lambda$o8qrp04gE8E9gnq2w7PUe0U-naE */
    public static /* synthetic */ PaylaterAgreementConfig m491$r8$lambda$o8qrp04gE8E9gnq2w7PUe0UnaE(PaylaterAgreementConfigResult paylaterAgreementConfigResult) {
        int i = getAuthRequestContext + 31;
        PlaceComponentResult = i % 128;
        int i2 = i % 2;
        PaylaterAgreementConfig m519getPaylaterAgreementConfig$lambda22 = m519getPaylaterAgreementConfig$lambda22(paylaterAgreementConfigResult);
        int i3 = getAuthRequestContext + 15;
        PlaceComponentResult = i3 % 128;
        if (i3 % 2 != 0) {
            Object[] objArr = null;
            int length = objArr.length;
            return m519getPaylaterAgreementConfig$lambda22;
        }
        return m519getPaylaterAgreementConfig$lambda22;
    }

    public static /* synthetic */ ObservableSource $r8$lambda$oPoMzMdjUGSR52QkWEWlPnsSLJk(CashierEntityRepository cashierEntityRepository, String str, String str2) {
        ObservableSource m511getHighlightVersion$lambda25;
        int i = PlaceComponentResult + 33;
        getAuthRequestContext = i % 128;
        Object[] objArr = null;
        if (!(i % 2 == 0)) {
            m511getHighlightVersion$lambda25 = m511getHighlightVersion$lambda25(cashierEntityRepository, str, str2);
        } else {
            try {
                m511getHighlightVersion$lambda25 = m511getHighlightVersion$lambda25(cashierEntityRepository, str, str2);
                int length = objArr.length;
            } catch (Exception e) {
                throw e;
            }
        }
        int i2 = PlaceComponentResult + 105;
        getAuthRequestContext = i2 % 128;
        if ((i2 % 2 == 0 ? '4' : (char) 31) != '4') {
            return m511getHighlightVersion$lambda25;
        }
        objArr.hashCode();
        return m511getHighlightVersion$lambda25;
    }

    public static /* synthetic */ ObservableSource $r8$lambda$q1BYwqOThCLeD3IxCYohwng5agY(CashierEntityRepository cashierEntityRepository, int i, String str) {
        ObservableSource m532savePaylaterCicilRegistrationCacheCooldownCount$lambda31;
        try {
            int i2 = getAuthRequestContext + 113;
            try {
                PlaceComponentResult = i2 % 128;
                if ((i2 % 2 != 0 ? 'E' : (char) 1) != 1) {
                    m532savePaylaterCicilRegistrationCacheCooldownCount$lambda31 = m532savePaylaterCicilRegistrationCacheCooldownCount$lambda31(cashierEntityRepository, i, str);
                    Object obj = null;
                    obj.hashCode();
                } else {
                    m532savePaylaterCicilRegistrationCacheCooldownCount$lambda31 = m532savePaylaterCicilRegistrationCacheCooldownCount$lambda31(cashierEntityRepository, i, str);
                }
                int i3 = getAuthRequestContext + 109;
                PlaceComponentResult = i3 % 128;
                int i4 = i3 % 2;
                return m532savePaylaterCicilRegistrationCacheCooldownCount$lambda31;
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    public static /* synthetic */ FetchBannerInfo $r8$lambda$rcMdMq5bQwBXB6a809D1BbEr8bA(CashierBannerEntityResponse cashierBannerEntityResponse) {
        int i = getAuthRequestContext + 19;
        PlaceComponentResult = i % 128;
        int i2 = i % 2;
        FetchBannerInfo m500fetchBanner$lambda10$lambda8 = m500fetchBanner$lambda10$lambda8(cashierBannerEntityResponse);
        int i3 = getAuthRequestContext + 3;
        PlaceComponentResult = i3 % 128;
        int i4 = i3 % 2;
        return m500fetchBanner$lambda10$lambda8;
    }

    /* renamed from: $r8$lambda$rsvnDY19BZIsqkRZGS-KLT5F8YU */
    public static /* synthetic */ DefaultResponse m492$r8$lambda$rsvnDY19BZIsqkRZGSKLT5F8YU(DefaultInfoResult defaultInfoResult) {
        DefaultResponse m497addAssetCardForUser$lambda20;
        try {
            int i = PlaceComponentResult + 113;
            try {
                getAuthRequestContext = i % 128;
                if ((i % 2 == 0 ? (char) 25 : 'Z') != 'Z') {
                    m497addAssetCardForUser$lambda20 = m497addAssetCardForUser$lambda20(defaultInfoResult);
                    int i2 = 29 / 0;
                } else {
                    m497addAssetCardForUser$lambda20 = m497addAssetCardForUser$lambda20(defaultInfoResult);
                }
                int i3 = PlaceComponentResult + 91;
                getAuthRequestContext = i3 % 128;
                if ((i3 % 2 == 0 ? (char) 25 : 'Z') != 25) {
                    return m497addAssetCardForUser$lambda20;
                }
                Object obj = null;
                obj.hashCode();
                return m497addAssetCardForUser$lambda20;
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    /* renamed from: $r8$lambda$szKeLxk3D9kpwKSto1mrC-yyfVI */
    public static /* synthetic */ void m493$r8$lambda$szKeLxk3D9kpwKSto1mrCyyfVI(CashierEntityRepository cashierEntityRepository, String str, SpaceRpcResult spaceRpcResult) {
        int i = getAuthRequestContext + 123;
        PlaceComponentResult = i % 128;
        char c = i % 2 != 0 ? (char) 14 : (char) 18;
        m506getCdpFromNetworkAndSave$lambda37(cashierEntityRepository, str, spaceRpcResult);
        if (c != 14) {
            return;
        }
        int i2 = 44 / 0;
    }

    public static /* synthetic */ Map $r8$lambda$tyyI1lA80LE01el3kuRxnD620o8(Map map) {
        int i = getAuthRequestContext + 75;
        PlaceComponentResult = i % 128;
        boolean z = i % 2 != 0;
        Map m508getCurrencyFromCdn$lambda43 = m508getCurrencyFromCdn$lambda43(map);
        if (z) {
            Object[] objArr = null;
            int length = objArr.length;
        }
        return m508getCurrencyFromCdn$lambda43;
    }

    public static /* synthetic */ String $r8$lambda$w76TgvjDXU3MSDxwsq35efSZh4c(QueryOneklikRedirectUrlResult queryOneklikRedirectUrlResult) {
        try {
            int i = getAuthRequestContext + 13;
            PlaceComponentResult = i % 128;
            if ((i % 2 != 0 ? 'G' : (char) 22) != 'G') {
                return m518getOneklikRedirectUrl$lambda11(queryOneklikRedirectUrlResult);
            }
            String m518getOneklikRedirectUrl$lambda11 = m518getOneklikRedirectUrl$lambda11(queryOneklikRedirectUrlResult);
            Object obj = null;
            obj.hashCode();
            return m518getOneklikRedirectUrl$lambda11;
        } catch (Exception e) {
            throw e;
        }
    }

    public static /* synthetic */ CashierPay $r8$lambda$wJzLUTYN_3zjnU5GyoevzR9k0L4(boolean z, CashierEntityRepository cashierEntityRepository, PaylaterCashierPayRequest paylaterCashierPayRequest, CashierPayRequest cashierPayRequest, String str, Boolean bool, PayLaterMethodConfig payLaterMethodConfig, PaylaterCicilMethodConfig paylaterCicilMethodConfig) {
        CashierPay m526payCashier$lambda1;
        int i = PlaceComponentResult + 121;
        getAuthRequestContext = i % 128;
        Object[] objArr = null;
        if (i % 2 != 0) {
            m526payCashier$lambda1 = m526payCashier$lambda1(z, cashierEntityRepository, paylaterCashierPayRequest, cashierPayRequest, str, bool, payLaterMethodConfig, paylaterCicilMethodConfig);
        } else {
            try {
                m526payCashier$lambda1 = m526payCashier$lambda1(z, cashierEntityRepository, paylaterCashierPayRequest, cashierPayRequest, str, bool, payLaterMethodConfig, paylaterCicilMethodConfig);
                int length = objArr.length;
            } catch (Exception e) {
                throw e;
            }
        }
        int i2 = PlaceComponentResult + 71;
        getAuthRequestContext = i2 % 128;
        if (i2 % 2 != 0) {
            return m526payCashier$lambda1;
        }
        objArr.hashCode();
        return m526payCashier$lambda1;
    }

    /* renamed from: $r8$lambda$x2XbS44X7AjUsblz_XPIx-CFGsQ */
    public static /* synthetic */ LoanRegisterResultInfo m494$r8$lambda$x2XbS44X7AjUsblz_XPIxCFGsQ(CashierEntityRepository cashierEntityRepository, LoanRegisterResult loanRegisterResult) {
        try {
            int i = PlaceComponentResult + 77;
            getAuthRequestContext = i % 128;
            int i2 = i % 2;
            LoanRegisterResultInfo m513getLoanRegisterInfo$lambda38 = m513getLoanRegisterInfo$lambda38(cashierEntityRepository, loanRegisterResult);
            int i3 = PlaceComponentResult + 71;
            getAuthRequestContext = i3 % 128;
            int i4 = i3 % 2;
            return m513getLoanRegisterInfo$lambda38;
        } catch (Exception e) {
            throw e;
        }
    }

    /* renamed from: $r8$lambda$xMFaa1zcUUFeKX_2L-CfHU4ratA */
    public static /* synthetic */ CashierAddOnModalContent m495$r8$lambda$xMFaa1zcUUFeKX_2LCfHU4ratA(CashierAddOnModalContentResult cashierAddOnModalContentResult) {
        int i = PlaceComponentResult + 5;
        getAuthRequestContext = i % 128;
        int i2 = i % 2;
        CashierAddOnModalContent m515getModalContent$lambda16 = m515getModalContent$lambda16(cashierAddOnModalContentResult);
        int i3 = getAuthRequestContext + 57;
        PlaceComponentResult = i3 % 128;
        int i4 = i3 % 2;
        return m515getModalContent$lambda16;
    }

    public static /* synthetic */ ObservableSource $r8$lambda$y44LhzbbkgWx6Ktgj8nSuvMHtNI(CashierEntityRepository cashierEntityRepository, String str) {
        try {
            int i = PlaceComponentResult + 7;
            getAuthRequestContext = i % 128;
            char c = i % 2 == 0 ? '-' : (char) 16;
            ObservableSource m522getPaylaterCicilRegistrationCacheCooldownDelay$lambda32 = m522getPaylaterCicilRegistrationCacheCooldownDelay$lambda32(cashierEntityRepository, str);
            if (c == '-') {
                Object[] objArr = null;
                int length = objArr.length;
            }
            return m522getPaylaterCicilRegistrationCacheCooldownDelay$lambda32;
        } catch (Exception e) {
            throw e;
        }
    }

    /* renamed from: $r8$lambda$yLMLDidb-gfmVNIHzVzXdpTumkI */
    public static /* synthetic */ List m496$r8$lambda$yLMLDidbgfmVNIHzVzXdpTumkI(CashierAddOnModalCategoryResult cashierAddOnModalCategoryResult) {
        try {
            int i = getAuthRequestContext + 105;
            PlaceComponentResult = i % 128;
            int i2 = i % 2;
            List m514getModalCategory$lambda15 = m514getModalCategory$lambda15(cashierAddOnModalCategoryResult);
            int i3 = PlaceComponentResult + 79;
            getAuthRequestContext = i3 % 128;
            int i4 = i3 % 2;
            return m514getModalCategory$lambda15;
        } catch (Exception e) {
            throw e;
        }
    }

    static {
        BuiltInFictitiousFunctionClassFactory();
        INSTANCE = new Companion(null);
        int i = PlaceComponentResult + 121;
        getAuthRequestContext = i % 128;
        if (i % 2 != 0) {
            return;
        }
        int i2 = 2 / 0;
    }

    static void BuiltInFictitiousFunctionClassFactory() {
        MyBillsEntityDataFactory = (char) 26545;
        BuiltInFictitiousFunctionClassFactory = 4360990799332652212L;
        KClassImpl$Data$declaredNonStaticMembers$2 = -956812108;
    }

    public final <T> Observable<T> authenticatedRequest(Observable<T> observable) {
        int i = getAuthRequestContext + 43;
        PlaceComponentResult = i % 128;
        int i2 = i % 2;
        Intrinsics.checkNotNullParameter(observable, "");
        Observable<T> authenticatedRequest = this.holdLoginV1EntityRepository.authenticatedRequest(observable);
        Intrinsics.checkNotNullExpressionValue(authenticatedRequest, "");
        int i3 = getAuthRequestContext + 97;
        PlaceComponentResult = i3 % 128;
        if (!(i3 % 2 != 0)) {
            return authenticatedRequest;
        }
        int i4 = 67 / 0;
        return authenticatedRequest;
    }

    public final <T> Flow<T> authenticatedRequest(Flow<? extends T> flow) {
        int i = getAuthRequestContext + 5;
        PlaceComponentResult = i % 128;
        int i2 = i % 2;
        Intrinsics.checkNotNullParameter(flow, "");
        Flow<T> PlaceComponentResult2 = this.holdLoginV1EntityRepository.PlaceComponentResult(flow);
        int i3 = PlaceComponentResult + 11;
        getAuthRequestContext = i3 % 128;
        int i4 = i3 % 2;
        return PlaceComponentResult2;
    }

    public final AccountEntityData createAccountData() {
        int i = PlaceComponentResult + 71;
        getAuthRequestContext = i % 128;
        int i2 = i % 2;
        AccountEntityData createAccountData = this.holdLoginV1EntityRepository.createAccountData();
        Intrinsics.checkNotNullExpressionValue(createAccountData, "");
        int i3 = PlaceComponentResult + 17;
        getAuthRequestContext = i3 % 128;
        int i4 = i3 % 2;
        return createAccountData;
    }

    public final ErrorConfigEntityData createLocalErrorConfigData() {
        ErrorConfigEntityData createLocalErrorConfigData;
        int i = PlaceComponentResult + 25;
        getAuthRequestContext = i % 128;
        if ((i % 2 == 0 ? '3' : '`') != '3') {
            createLocalErrorConfigData = this.holdLoginV1EntityRepository.createLocalErrorConfigData();
            Intrinsics.checkNotNullExpressionValue(createLocalErrorConfigData, "");
        } else {
            createLocalErrorConfigData = this.holdLoginV1EntityRepository.createLocalErrorConfigData();
            Intrinsics.checkNotNullExpressionValue(createLocalErrorConfigData, "");
            Object[] objArr = null;
            int length = objArr.length;
        }
        int i2 = getAuthRequestContext + 11;
        PlaceComponentResult = i2 % 128;
        int i3 = i2 % 2;
        return createLocalErrorConfigData;
    }

    public final ErrorConfigEntityData createNetworkErrorConfigData() {
        ErrorConfigEntityData createNetworkErrorConfigData;
        int i = PlaceComponentResult + 67;
        getAuthRequestContext = i % 128;
        if (!(i % 2 == 0)) {
            createNetworkErrorConfigData = this.holdLoginV1EntityRepository.createNetworkErrorConfigData();
            Intrinsics.checkNotNullExpressionValue(createNetworkErrorConfigData, "");
        } else {
            try {
                createNetworkErrorConfigData = this.holdLoginV1EntityRepository.createNetworkErrorConfigData();
                Intrinsics.checkNotNullExpressionValue(createNetworkErrorConfigData, "");
                Object obj = null;
                obj.hashCode();
            } catch (Exception e) {
                throw e;
            }
        }
        int i2 = PlaceComponentResult + 121;
        getAuthRequestContext = i2 % 128;
        int i3 = i2 % 2;
        return createNetworkErrorConfigData;
    }

    public final LoginEntityData createNetworkLogin() {
        int i = PlaceComponentResult + 27;
        getAuthRequestContext = i % 128;
        int i2 = i % 2;
        LoginEntityData createNetworkLogin = this.holdLoginV1EntityRepository.createNetworkLogin();
        Intrinsics.checkNotNullExpressionValue(createNetworkLogin, "");
        int i3 = PlaceComponentResult + 3;
        getAuthRequestContext = i3 % 128;
        int i4 = i3 % 2;
        return createNetworkLogin;
    }

    @Override // id.dana.domain.card.repository.CardCredentialRepository
    public final Observable<String> encryptCardCredentials(Map<String, String> cardCredentials) {
        int i = getAuthRequestContext + 35;
        PlaceComponentResult = i % 128;
        if (i % 2 == 0) {
            Intrinsics.checkNotNullParameter(cardCredentials, "");
            return this.cardCredentialEntityRepository.encryptCardCredentials(cardCredentials);
        }
        try {
            Intrinsics.checkNotNullParameter(cardCredentials, "");
            Observable<String> encryptCardCredentials = this.cardCredentialEntityRepository.encryptCardCredentials(cardCredentials);
            Object obj = null;
            obj.hashCode();
            return encryptCardCredentials;
        } catch (Exception e) {
            throw e;
        }
    }

    @Override // id.dana.domain.card.repository.CardCredentialRepository
    public final Flow<String> encryptCardCredentialsFlow(Map<String, String> cardCredentials) {
        int i = getAuthRequestContext + 107;
        PlaceComponentResult = i % 128;
        if ((i % 2 != 0 ? '6' : (char) 17) == '6') {
            Intrinsics.checkNotNullParameter(cardCredentials, "");
            int i2 = 30 / 0;
            return this.cardCredentialEntityRepository.encryptCardCredentialsFlow(cardCredentials);
        }
        try {
            Intrinsics.checkNotNullParameter(cardCredentials, "");
            return this.cardCredentialEntityRepository.encryptCardCredentialsFlow(cardCredentials);
        } catch (Exception e) {
            throw e;
        }
    }

    @Override // id.dana.domain.card.repository.CardCredentialRepository
    public final Observable<String> getCardCredentialPublicKey() {
        int i = getAuthRequestContext + 31;
        PlaceComponentResult = i % 128;
        int i2 = i % 2;
        Observable<String> cardCredentialPublicKey = this.cardCredentialEntityRepository.getCardCredentialPublicKey();
        int i3 = getAuthRequestContext + 1;
        PlaceComponentResult = i3 % 128;
        if (i3 % 2 == 0) {
            return cardCredentialPublicKey;
        }
        Object obj = null;
        obj.hashCode();
        return cardCredentialPublicKey;
    }

    @Inject
    public CashierEntityRepository(CashierEntityDataFactory cashierEntityDataFactory, PaylaterEntityDataFactory paylaterEntityDataFactory, SecurityEntityDataFactory securityEntityDataFactory, CdpGuideCacheEntityDataFactory<TimedSpaceRpcResult> cdpGuideCacheEntityDataFactory, ContentDeliveryEntityDataFactory contentDeliveryEntityDataFactory, CashierBannerManagementEntityDataFactory cashierBannerManagementEntityDataFactory, AccountEntityDataFactory accountEntityDataFactory, CashierEKtpAgreementRequestMapper cashierEKtpAgreementRequestMapper, CashierEKtpAgreementResultMapper cashierEKtpAgreementResultMapper, CashierPayInfoResultMapper cashierPayInfoResultMapper, CashierPayInfoRequestMapper cashierPayInfoRequestMapper, CreateOrderInfoRequestMapper createOrderInfoRequestMapper, CreateOrderInfoResultMapper createOrderInfoResultMapper, QueryPromotionInfoResultMapper queryPromotionInfoResultMapper, CashierAddOnModalTooltipRequestMapper cashierAddOnModalTooltipRequestMapper, CashierAddOnModalTooltipResultMapper cashierAddOnModalTooltipResultMapper, TopUpConsultResultMapper topUpConsultResultMapper, SpaceResultMapper spaceResultMapper, TopUpPayResultMapper topUpPayResultMapper, LoanRegisterMapper loanRegisterMapper, SplitConfigEntityData splitConfigEntityData, GeocodeEntityRepository geocodeEntityRepository, HoldLoginV1EntityRepository holdLoginV1EntityRepository, CardCredentialEntityRepository cardCredentialEntityRepository) {
        Intrinsics.checkNotNullParameter(cashierEntityDataFactory, "");
        Intrinsics.checkNotNullParameter(paylaterEntityDataFactory, "");
        Intrinsics.checkNotNullParameter(securityEntityDataFactory, "");
        Intrinsics.checkNotNullParameter(cdpGuideCacheEntityDataFactory, "");
        Intrinsics.checkNotNullParameter(contentDeliveryEntityDataFactory, "");
        Intrinsics.checkNotNullParameter(cashierBannerManagementEntityDataFactory, "");
        Intrinsics.checkNotNullParameter(accountEntityDataFactory, "");
        Intrinsics.checkNotNullParameter(cashierEKtpAgreementRequestMapper, "");
        Intrinsics.checkNotNullParameter(cashierEKtpAgreementResultMapper, "");
        Intrinsics.checkNotNullParameter(cashierPayInfoResultMapper, "");
        Intrinsics.checkNotNullParameter(cashierPayInfoRequestMapper, "");
        Intrinsics.checkNotNullParameter(createOrderInfoRequestMapper, "");
        Intrinsics.checkNotNullParameter(createOrderInfoResultMapper, "");
        Intrinsics.checkNotNullParameter(queryPromotionInfoResultMapper, "");
        Intrinsics.checkNotNullParameter(cashierAddOnModalTooltipRequestMapper, "");
        Intrinsics.checkNotNullParameter(cashierAddOnModalTooltipResultMapper, "");
        Intrinsics.checkNotNullParameter(topUpConsultResultMapper, "");
        Intrinsics.checkNotNullParameter(spaceResultMapper, "");
        Intrinsics.checkNotNullParameter(topUpPayResultMapper, "");
        Intrinsics.checkNotNullParameter(loanRegisterMapper, "");
        Intrinsics.checkNotNullParameter(splitConfigEntityData, "");
        Intrinsics.checkNotNullParameter(geocodeEntityRepository, "");
        Intrinsics.checkNotNullParameter(holdLoginV1EntityRepository, "");
        Intrinsics.checkNotNullParameter(cardCredentialEntityRepository, "");
        this.cashierEntityDataFactory = cashierEntityDataFactory;
        this.paylaterEntityDataFactory = paylaterEntityDataFactory;
        this.securityEntityDataFactory = securityEntityDataFactory;
        this.contentDeliveryCacheEntityDataFactory = cdpGuideCacheEntityDataFactory;
        this.contentDeliveryEntityDataFactory = contentDeliveryEntityDataFactory;
        this.bannerManagementEntityDataFactory = cashierBannerManagementEntityDataFactory;
        this.accountEntityDataFactory = accountEntityDataFactory;
        this.cashierEKtpAgreementRequestMapper = cashierEKtpAgreementRequestMapper;
        this.cashierEKtpAgreementResultMapper = cashierEKtpAgreementResultMapper;
        this.cashierPayInfoResultMapper = cashierPayInfoResultMapper;
        this.cashierPayInfoRequestMapper = cashierPayInfoRequestMapper;
        this.createOrderInfoRequestMapper = createOrderInfoRequestMapper;
        this.createOrderInfoResultMapper = createOrderInfoResultMapper;
        this.queryPromotionInfoResultMapper = queryPromotionInfoResultMapper;
        this.cashierAddOnModalTooltipRequestMapper = cashierAddOnModalTooltipRequestMapper;
        this.cashierAddOnModalTooltipResultMapper = cashierAddOnModalTooltipResultMapper;
        this.topUpConsultResultMapper = topUpConsultResultMapper;
        this.spaceResultMapper = spaceResultMapper;
        this.topUpPayResultMapper = topUpPayResultMapper;
        this.loanRegisterMapper = loanRegisterMapper;
        this.splitConfigEntityData = splitConfigEntityData;
        this.geocodeEntityRepository = geocodeEntityRepository;
        this.holdLoginV1EntityRepository = holdLoginV1EntityRepository;
        this.cardCredentialEntityRepository = cardCredentialEntityRepository;
        this.cashierNetworkEntityData = LazyKt.lazy(new Function0<CashierEntityData>() { // from class: id.dana.cashier.data.repository.CashierEntityRepository$cashierNetworkEntityData$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                CashierEntityRepository.this = this;
            }

            @Override // kotlin.jvm.functions.Function0
            public final CashierEntityData invoke() {
                return CashierEntityRepository.access$getCashierEntityDataFactory$p(CashierEntityRepository.this).createData2("network");
            }
        });
        this.cashierLocalEntityData = LazyKt.lazy(new Function0<CashierEntityData>() { // from class: id.dana.cashier.data.repository.CashierEntityRepository$cashierLocalEntityData$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                CashierEntityRepository.this = this;
            }

            @Override // kotlin.jvm.functions.Function0
            public final CashierEntityData invoke() {
                return CashierEntityRepository.access$getCashierEntityDataFactory$p(CashierEntityRepository.this).createData2("local");
            }
        });
        this.cashierSplitEntityData = LazyKt.lazy(new Function0<CashierEntityData>() { // from class: id.dana.cashier.data.repository.CashierEntityRepository$cashierSplitEntityData$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                CashierEntityRepository.this = this;
            }

            @Override // kotlin.jvm.functions.Function0
            public final CashierEntityData invoke() {
                return CashierEntityRepository.access$getCashierEntityDataFactory$p(CashierEntityRepository.this).createData2("split");
            }
        });
        this.securityNetworkEntityData = LazyKt.lazy(new Function0<SecurityEntityData>() { // from class: id.dana.cashier.data.repository.CashierEntityRepository$securityNetworkEntityData$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                CashierEntityRepository.this = this;
            }

            @Override // kotlin.jvm.functions.Function0
            public final SecurityEntityData invoke() {
                return CashierEntityRepository.access$getSecurityEntityDataFactory$p(CashierEntityRepository.this).createData2("network");
            }
        });
        this.networkCdpGuideEntityData = LazyKt.lazy(new Function0<ContentDeliveryEntityData>() { // from class: id.dana.cashier.data.repository.CashierEntityRepository$networkCdpGuideEntityData$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                CashierEntityRepository.this = this;
            }

            @Override // kotlin.jvm.functions.Function0
            public final ContentDeliveryEntityData invoke() {
                return CashierEntityRepository.access$getContentDeliveryEntityDataFactory$p(CashierEntityRepository.this).createData2("network");
            }
        });
        this.cacheCdpGuideEntityData = LazyKt.lazy(new Function0<CacheEntityData<TimedSpaceRpcResult>>() { // from class: id.dana.cashier.data.repository.CashierEntityRepository$cacheCdpGuideEntityData$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                CashierEntityRepository.this = this;
            }

            @Override // kotlin.jvm.functions.Function0
            public final CacheEntityData<TimedSpaceRpcResult> invoke() {
                return CashierEntityRepository.access$getContentDeliveryCacheEntityDataFactory$p(CashierEntityRepository.this).createData2("local");
            }
        });
        this.networkPaylaterEntityData = LazyKt.lazy(new Function0<PaylaterEntityData>() { // from class: id.dana.cashier.data.repository.CashierEntityRepository$networkPaylaterEntityData$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                CashierEntityRepository.this = this;
            }

            @Override // kotlin.jvm.functions.Function0
            public final PaylaterEntityData invoke() {
                return CashierEntityRepository.access$getPaylaterEntityDataFactory$p(CashierEntityRepository.this).createData2("network");
            }
        });
        this.splitPaylaterEntityData = LazyKt.lazy(new Function0<PaylaterEntityData>() { // from class: id.dana.cashier.data.repository.CashierEntityRepository$splitPaylaterEntityData$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                CashierEntityRepository.this = this;
            }

            @Override // kotlin.jvm.functions.Function0
            public final PaylaterEntityData invoke() {
                return CashierEntityRepository.access$getPaylaterEntityDataFactory$p(CashierEntityRepository.this).createData2("split");
            }
        });
        this.bannerManagementEntityData = LazyKt.lazy(new Function0<CashierBannerManagementEntityData>() { // from class: id.dana.cashier.data.repository.CashierEntityRepository$bannerManagementEntityData$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                CashierEntityRepository.this = this;
            }

            @Override // kotlin.jvm.functions.Function0
            public final CashierBannerManagementEntityData invoke() {
                return CashierEntityRepository.access$getBannerManagementEntityDataFactory$p(CashierEntityRepository.this).createData2("network");
            }
        });
    }

    public static final /* synthetic */ CashierBannerManagementEntityDataFactory access$getBannerManagementEntityDataFactory$p(CashierEntityRepository cashierEntityRepository) {
        try {
            int i = getAuthRequestContext + 27;
            PlaceComponentResult = i % 128;
            int i2 = i % 2;
            CashierBannerManagementEntityDataFactory cashierBannerManagementEntityDataFactory = cashierEntityRepository.bannerManagementEntityDataFactory;
            int i3 = getAuthRequestContext + 37;
            PlaceComponentResult = i3 % 128;
            int i4 = i3 % 2;
            return cashierBannerManagementEntityDataFactory;
        } catch (Exception e) {
            throw e;
        }
    }

    public static final /* synthetic */ CashierEntityDataFactory access$getCashierEntityDataFactory$p(CashierEntityRepository cashierEntityRepository) {
        int i = PlaceComponentResult + 15;
        getAuthRequestContext = i % 128;
        if (i % 2 != 0) {
            try {
                return cashierEntityRepository.cashierEntityDataFactory;
            } catch (Exception e) {
                throw e;
            }
        }
        try {
            CashierEntityDataFactory cashierEntityDataFactory = cashierEntityRepository.cashierEntityDataFactory;
            Object obj = null;
            obj.hashCode();
            return cashierEntityDataFactory;
        } catch (Exception e2) {
            throw e2;
        }
    }

    public static final /* synthetic */ CdpGuideCacheEntityDataFactory access$getContentDeliveryCacheEntityDataFactory$p(CashierEntityRepository cashierEntityRepository) {
        try {
            int i = getAuthRequestContext + 25;
            PlaceComponentResult = i % 128;
            int i2 = i % 2;
            CdpGuideCacheEntityDataFactory<TimedSpaceRpcResult> cdpGuideCacheEntityDataFactory = cashierEntityRepository.contentDeliveryCacheEntityDataFactory;
            int i3 = getAuthRequestContext + 45;
            PlaceComponentResult = i3 % 128;
            if (!(i3 % 2 == 0)) {
                Object obj = null;
                obj.hashCode();
                return cdpGuideCacheEntityDataFactory;
            }
            return cdpGuideCacheEntityDataFactory;
        } catch (Exception e) {
            throw e;
        }
    }

    public static final /* synthetic */ ContentDeliveryEntityDataFactory access$getContentDeliveryEntityDataFactory$p(CashierEntityRepository cashierEntityRepository) {
        int i = PlaceComponentResult + 37;
        getAuthRequestContext = i % 128;
        int i2 = i % 2;
        try {
            ContentDeliveryEntityDataFactory contentDeliveryEntityDataFactory = cashierEntityRepository.contentDeliveryEntityDataFactory;
            int i3 = PlaceComponentResult + 15;
            getAuthRequestContext = i3 % 128;
            int i4 = i3 % 2;
            return contentDeliveryEntityDataFactory;
        } catch (Exception e) {
            throw e;
        }
    }

    public static final /* synthetic */ PaylaterEntityDataFactory access$getPaylaterEntityDataFactory$p(CashierEntityRepository cashierEntityRepository) {
        int i = PlaceComponentResult + 13;
        getAuthRequestContext = i % 128;
        boolean z = i % 2 != 0;
        PaylaterEntityDataFactory paylaterEntityDataFactory = cashierEntityRepository.paylaterEntityDataFactory;
        if (!z) {
            int i2 = 95 / 0;
        }
        try {
            int i3 = getAuthRequestContext + 13;
            PlaceComponentResult = i3 % 128;
            if ((i3 % 2 != 0 ? 'J' : '#') != '#') {
                Object obj = null;
                obj.hashCode();
                return paylaterEntityDataFactory;
            }
            return paylaterEntityDataFactory;
        } catch (Exception e) {
            throw e;
        }
    }

    public static final /* synthetic */ SecurityEntityDataFactory access$getSecurityEntityDataFactory$p(CashierEntityRepository cashierEntityRepository) {
        int i = getAuthRequestContext + 27;
        PlaceComponentResult = i % 128;
        int i2 = i % 2;
        SecurityEntityDataFactory securityEntityDataFactory = cashierEntityRepository.securityEntityDataFactory;
        int i3 = PlaceComponentResult + 103;
        getAuthRequestContext = i3 % 128;
        if ((i3 % 2 == 0 ? (char) 20 : 'V') != 'V') {
            int i4 = 84 / 0;
            return securityEntityDataFactory;
        }
        return securityEntityDataFactory;
    }

    @JvmName(name = "getCashierNetworkEntityData")
    private final CashierEntityData getCashierNetworkEntityData() {
        int i = PlaceComponentResult + 103;
        getAuthRequestContext = i % 128;
        if ((i % 2 == 0 ? 'a' : 'H') != 'a') {
            return (CashierEntityData) this.cashierNetworkEntityData.getValue();
        }
        CashierEntityData cashierEntityData = (CashierEntityData) this.cashierNetworkEntityData.getValue();
        Object[] objArr = null;
        int length = objArr.length;
        return cashierEntityData;
    }

    @JvmName(name = "getCashierLocalEntityData")
    private final CashierEntityData getCashierLocalEntityData() {
        CashierEntityData cashierEntityData;
        int i = getAuthRequestContext + 39;
        PlaceComponentResult = i % 128;
        if ((i % 2 != 0 ? '`' : 'B') != '`') {
            try {
                try {
                    cashierEntityData = (CashierEntityData) this.cashierLocalEntityData.getValue();
                } catch (Exception e) {
                    throw e;
                }
            } catch (Exception e2) {
                throw e2;
            }
        } else {
            cashierEntityData = (CashierEntityData) this.cashierLocalEntityData.getValue();
            int i2 = 78 / 0;
        }
        int i3 = PlaceComponentResult + 75;
        getAuthRequestContext = i3 % 128;
        if (i3 % 2 != 0) {
            return cashierEntityData;
        }
        Object obj = null;
        obj.hashCode();
        return cashierEntityData;
    }

    @JvmName(name = "getCashierSplitEntityData")
    private final CashierEntityData getCashierSplitEntityData() {
        int i = PlaceComponentResult + 107;
        getAuthRequestContext = i % 128;
        int i2 = i % 2;
        CashierEntityData cashierEntityData = (CashierEntityData) this.cashierSplitEntityData.getValue();
        int i3 = getAuthRequestContext + 115;
        PlaceComponentResult = i3 % 128;
        if ((i3 % 2 != 0 ? '6' : (char) 31) != '6') {
            return cashierEntityData;
        }
        int i4 = 63 / 0;
        return cashierEntityData;
    }

    @JvmName(name = "getSecurityNetworkEntityData")
    private final SecurityEntityData getSecurityNetworkEntityData() {
        try {
            int i = PlaceComponentResult + 25;
            getAuthRequestContext = i % 128;
            if (i % 2 != 0) {
                return (SecurityEntityData) this.securityNetworkEntityData.getValue();
            }
            SecurityEntityData securityEntityData = (SecurityEntityData) this.securityNetworkEntityData.getValue();
            Object obj = null;
            obj.hashCode();
            return securityEntityData;
        } catch (Exception e) {
            throw e;
        }
    }

    @JvmName(name = "getNetworkCdpGuideEntityData")
    private final ContentDeliveryEntityData getNetworkCdpGuideEntityData() {
        ContentDeliveryEntityData contentDeliveryEntityData;
        int i = getAuthRequestContext + 63;
        PlaceComponentResult = i % 128;
        if (!(i % 2 == 0)) {
            contentDeliveryEntityData = (ContentDeliveryEntityData) this.networkCdpGuideEntityData.getValue();
            Object[] objArr = null;
            int length = objArr.length;
        } else {
            contentDeliveryEntityData = (ContentDeliveryEntityData) this.networkCdpGuideEntityData.getValue();
        }
        try {
            int i2 = getAuthRequestContext + 83;
            PlaceComponentResult = i2 % 128;
            int i3 = i2 % 2;
            return contentDeliveryEntityData;
        } catch (Exception e) {
            throw e;
        }
    }

    @JvmName(name = "getCacheCdpGuideEntityData")
    private final CacheEntityData<TimedSpaceRpcResult> getCacheCdpGuideEntityData() {
        int i = getAuthRequestContext + 69;
        PlaceComponentResult = i % 128;
        int i2 = i % 2;
        try {
            CacheEntityData<TimedSpaceRpcResult> cacheEntityData = (CacheEntityData) this.cacheCdpGuideEntityData.getValue();
            int i3 = getAuthRequestContext + 109;
            PlaceComponentResult = i3 % 128;
            if (!(i3 % 2 == 0)) {
                int i4 = 98 / 0;
                return cacheEntityData;
            }
            return cacheEntityData;
        } catch (Exception e) {
            throw e;
        }
    }

    @JvmName(name = "getNetworkPaylaterEntityData")
    private final PaylaterEntityData getNetworkPaylaterEntityData() {
        int i = getAuthRequestContext + 105;
        PlaceComponentResult = i % 128;
        int i2 = i % 2;
        PaylaterEntityData paylaterEntityData = (PaylaterEntityData) this.networkPaylaterEntityData.getValue();
        try {
            int i3 = getAuthRequestContext + 21;
            try {
                PlaceComponentResult = i3 % 128;
                if (i3 % 2 == 0) {
                    return paylaterEntityData;
                }
                Object[] objArr = null;
                int length = objArr.length;
                return paylaterEntityData;
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    @JvmName(name = "getSplitPaylaterEntityData")
    private final PaylaterEntityData getSplitPaylaterEntityData() {
        int i = PlaceComponentResult + 77;
        getAuthRequestContext = i % 128;
        if (i % 2 == 0) {
            int i2 = 3 / 0;
            return (PaylaterEntityData) this.splitPaylaterEntityData.getValue();
        }
        return (PaylaterEntityData) this.splitPaylaterEntityData.getValue();
    }

    @JvmName(name = "getBannerManagementEntityData")
    private final CashierBannerManagementEntityData getBannerManagementEntityData() {
        int i = getAuthRequestContext + 109;
        PlaceComponentResult = i % 128;
        if (i % 2 != 0) {
            CashierBannerManagementEntityData cashierBannerManagementEntityData = (CashierBannerManagementEntityData) this.bannerManagementEntityData.getValue();
            Object obj = null;
            obj.hashCode();
            return cashierBannerManagementEntityData;
        }
        return (CashierBannerManagementEntityData) this.bannerManagementEntityData.getValue();
    }

    @Override // id.dana.cashier.domain.CashierRepository
    public final Observable<CashierPay> payCashier(final CashierPayRequest cashierPayRequest, final boolean isGpsActive, final PaylaterCashierPayRequest paylaterCashierPayRequest) {
        Intrinsics.checkNotNullParameter(cashierPayRequest, "");
        Observable zip = Observable.zip(getCardCredentialKey(), getConfigCardInfo(), getPayLaterConfig(), getPaylaterCicilMethodConfig(), new Function4() { // from class: id.dana.cashier.data.repository.CashierEntityRepository$$ExternalSyntheticLambda20
            @Override // io.reactivex.functions.Function4
            public final Object apply(Object obj, Object obj2, Object obj3, Object obj4) {
                return CashierEntityRepository.$r8$lambda$wJzLUTYN_3zjnU5GyoevzR9k0L4(isGpsActive, this, paylaterCashierPayRequest, cashierPayRequest, (String) obj, (Boolean) obj2, (PayLaterMethodConfig) obj3, (PaylaterCicilMethodConfig) obj4);
            }
        });
        Intrinsics.checkNotNullExpressionValue(zip, "");
        Observable<CashierPay> authenticatedRequest = authenticatedRequest(zip);
        try {
            int i = getAuthRequestContext + 71;
            PlaceComponentResult = i % 128;
            int i2 = i % 2;
            return authenticatedRequest;
        } catch (Exception e) {
            throw e;
        }
    }

    /* renamed from: payCashier$lambda-1$lambda-0 */
    private static final ObservableSource m527payCashier$lambda1$lambda0(PaylaterCashierPayRequest paylaterCashierPayRequest, CashierEntityRepository cashierEntityRepository, CashierPayRequest cashierPayRequest, String str, Boolean bool, PayLaterMethodConfig payLaterMethodConfig, PaylaterCicilMethodConfig paylaterCicilMethodConfig, LocationSubdisivision locationSubdisivision) {
        AdditionalPaylaterCashierPayRequest additionalPaylaterCashierPayRequest;
        AdditionalPaylaterCashierPayRequest additionalPaylaterCashierPayRequest2;
        int i = getAuthRequestContext + 59;
        PlaceComponentResult = i % 128;
        int i2 = i % 2;
        try {
            Intrinsics.checkNotNullParameter(cashierEntityRepository, "");
            Intrinsics.checkNotNullParameter(cashierPayRequest, "");
            Intrinsics.checkNotNullParameter(str, "");
            Intrinsics.checkNotNullParameter(bool, "");
            Intrinsics.checkNotNullParameter(payLaterMethodConfig, "");
            Intrinsics.checkNotNullParameter(paylaterCicilMethodConfig, "");
            Intrinsics.checkNotNullParameter(locationSubdisivision, "");
            String cityName = locationSubdisivision.getIndoSubdivisions().getCityName();
            Object obj = null;
            if ((paylaterCashierPayRequest != null ? 'V' : (char) 17) != 17) {
                int i3 = PlaceComponentResult + 59;
                getAuthRequestContext = i3 % 128;
                if ((i3 % 2 == 0 ? '+' : '\'') != '+') {
                    additionalPaylaterCashierPayRequest2 = AdditionalPaylaterCashierPayRequestKt.toAdditionalPaylaterCashierPayRequest(paylaterCashierPayRequest);
                } else {
                    try {
                        additionalPaylaterCashierPayRequest2 = AdditionalPaylaterCashierPayRequestKt.toAdditionalPaylaterCashierPayRequest(paylaterCashierPayRequest);
                        obj.hashCode();
                    } catch (Exception e) {
                        throw e;
                    }
                }
                additionalPaylaterCashierPayRequest = additionalPaylaterCashierPayRequest2;
            } else {
                int i4 = getAuthRequestContext + 71;
                PlaceComponentResult = i4 % 128;
                int i5 = i4 % 2;
                additionalPaylaterCashierPayRequest = null;
            }
            return cashierEntityRepository.payCashierWithCredential(cashierPayRequest, additionalPaylaterCashierPayRequest, str, bool.booleanValue(), cityName, payLaterMethodConfig, paylaterCicilMethodConfig);
        } catch (Exception e2) {
            throw e2;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v2 */
    /* renamed from: payCashier$lambda-1 */
    private static final CashierPay m526payCashier$lambda1(boolean z, final CashierEntityRepository cashierEntityRepository, final PaylaterCashierPayRequest paylaterCashierPayRequest, final CashierPayRequest cashierPayRequest, final String str, final Boolean bool, final PayLaterMethodConfig payLaterMethodConfig, final PaylaterCicilMethodConfig paylaterCicilMethodConfig) {
        AdditionalPaylaterCashierPayRequest additionalPaylaterCashierPayRequest;
        int i = PlaceComponentResult + 33;
        getAuthRequestContext = i % 128;
        int i2 = i % 2;
        Intrinsics.checkNotNullParameter(cashierEntityRepository, "");
        Intrinsics.checkNotNullParameter(cashierPayRequest, "");
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(bool, "");
        Intrinsics.checkNotNullParameter(payLaterMethodConfig, "");
        Intrinsics.checkNotNullParameter(paylaterCicilMethodConfig, "");
        if (z) {
            return (CashierPay) cashierEntityRepository.geocodeEntityRepository.getLatestSubdivisions().flatMap(new Function() { // from class: id.dana.cashier.data.repository.CashierEntityRepository$$ExternalSyntheticLambda14
                @Override // io.reactivex.functions.Function
                public final Object apply(Object obj) {
                    return CashierEntityRepository.$r8$lambda$2IPbT0EftH6xHGYw2L7RHjRn1e4(paylaterCashierPayRequest, cashierEntityRepository, cashierPayRequest, str, bool, payLaterMethodConfig, paylaterCicilMethodConfig, (LocationSubdisivision) obj);
                }
            }).blockingFirst();
        }
        AdditionalPaylaterCashierPayRequest additionalPaylaterCashierPayRequest2 = 0;
        if (!(paylaterCashierPayRequest == null)) {
            int i3 = getAuthRequestContext + 101;
            PlaceComponentResult = i3 % 128;
            if ((i3 % 2 != 0 ? 'R' : (char) 1) != 'R') {
                additionalPaylaterCashierPayRequest = AdditionalPaylaterCashierPayRequestKt.toAdditionalPaylaterCashierPayRequest(paylaterCashierPayRequest);
            } else {
                additionalPaylaterCashierPayRequest = AdditionalPaylaterCashierPayRequestKt.toAdditionalPaylaterCashierPayRequest(paylaterCashierPayRequest);
                int length = additionalPaylaterCashierPayRequest2.length;
            }
            additionalPaylaterCashierPayRequest2 = additionalPaylaterCashierPayRequest;
        }
        try {
            return cashierEntityRepository.payCashierWithCredential(cashierPayRequest, additionalPaylaterCashierPayRequest2, str, bool.booleanValue(), null, payLaterMethodConfig, paylaterCicilMethodConfig).blockingFirst();
        } catch (Exception e) {
            throw e;
        }
    }

    private final Observable<Boolean> getConfigCardInfo() {
        SplitConfigEntityData splitConfigEntityData = this.splitConfigEntityData;
        Object[] objArr = new Object[1];
        a(new char[]{13982, 40083, 23910, 46100, 65251, 12018, 31485, 42421, 64856, 39412, 44057, 46594, 5456, 10296, 22874, 47175, 19072}, new char[]{32237, 16354, 50878, 21637}, (char) (34246 - (Process.myPid() >> 22)), new char[]{0, 0, 0, 0}, (-1103109507) - View.getDefaultSize(0, 0), objArr);
        Observable<JSONObject> jSONObject = splitConfigEntityData.getJSONObject(((String) objArr[0]).intern());
        JSONObject jSONObject2 = new JSONObject();
        Object[] objArr2 = new Object[1];
        a(new char[]{13982, 40083, 23910, 46100, 65251, 12018, 31485, 42421, 64856, 39412, 44057, 46594, 5456, 10296, 22874, 47175, 19072}, new char[]{32237, 16354, 50878, 21637}, (char) (34247 - (Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1))), new char[]{0, 0, 0, 0}, MotionEvent.axisFromString("") - 1103109506, objArr2);
        Observable<Boolean> onErrorReturnItem = jSONObject.onErrorResumeNext(FeatureSwitch.getFeatureSwitch(((String) objArr2[0]).intern(), jSONObject2)).map(new Function() { // from class: id.dana.cashier.data.repository.CashierEntityRepository$$ExternalSyntheticLambda3
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return CashierEntityRepository.$r8$lambda$mS5A15DmwVP__klhCgp6AL6tffY((JSONObject) obj);
            }
        }).onErrorReturnItem(Boolean.FALSE);
        int i = getAuthRequestContext + 59;
        PlaceComponentResult = i % 128;
        int i2 = i % 2;
        return onErrorReturnItem;
    }

    /* renamed from: getConfigCardInfo$lambda-2 */
    private static final Boolean m507getConfigCardInfo$lambda2(JSONObject jSONObject) {
        int i = getAuthRequestContext + 97;
        PlaceComponentResult = i % 128;
        int i2 = i % 2;
        Intrinsics.checkNotNullParameter(jSONObject, "");
        Boolean bool = jSONObject.getBoolean(CONFIG_CARD_INFO);
        int i3 = getAuthRequestContext + 97;
        PlaceComponentResult = i3 % 128;
        int i4 = i3 % 2;
        return bool;
    }

    private final Observable<PayLaterMethodConfig> getPayLaterConfig() {
        int i = getAuthRequestContext + 107;
        PlaceComponentResult = i % 128;
        int i2 = i % 2;
        try {
            try {
                Observable<PayLaterMethodConfig> payLaterMethodConfig = this.splitConfigEntityData.getPayLaterMethodConfig();
                int i3 = PlaceComponentResult + 87;
                getAuthRequestContext = i3 % 128;
                if ((i3 % 2 == 0 ? '4' : 'S') != '4') {
                    return payLaterMethodConfig;
                }
                int i4 = 59 / 0;
                return payLaterMethodConfig;
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    private final Observable<CashierPay> payCashierWithCredential(CashierPayRequest cashierPayRequest, AdditionalPaylaterCashierPayRequest additionalPaylaterCashierPayRequest, String r5, boolean isEnable, String cityName, final PayLaterMethodConfig payLaterMethodConfig, final PaylaterCicilMethodConfig paylaterCicilMethodConfig) {
        Observable map = getCashierNetworkEntityData().doCashierPay(this.cashierPayInfoRequestMapper.map(cashierPayRequest, r5, isEnable, cityName), additionalPaylaterCashierPayRequest).map(new CashierEntityRepository$$ExternalSyntheticLambda45(this.cashierPayInfoResultMapper)).map(new Function() { // from class: id.dana.cashier.data.repository.CashierEntityRepository$$ExternalSyntheticLambda46
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return CashierEntityRepository.m485$r8$lambda$ytvdSgRFOZ8v76Ho54parbi7I(paylaterCicilMethodConfig, payLaterMethodConfig, (CashierPay) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(map, "");
        Observable<CashierPay> authenticatedRequest = authenticatedRequest(map);
        try {
            int i = getAuthRequestContext + 91;
            PlaceComponentResult = i % 128;
            if (!(i % 2 != 0)) {
                return authenticatedRequest;
            }
            Object[] objArr = null;
            int length = objArr.length;
            return authenticatedRequest;
        } catch (Exception e) {
            throw e;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:101:0x00b5, code lost:
    
        r6 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:102:0x00b6, code lost:
    
        throw r6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x001f, code lost:
    
        if (r0 != null) goto L73;
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x0035, code lost:
    
        if ((r0 == null) != false) goto L103;
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x0039, code lost:
    
        r0 = r0.getPayChannels();
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x003d, code lost:
    
        if (r0 == null) goto L103;
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x003f, code lost:
    
        r0 = r0;
        r1 = new java.util.ArrayList(kotlin.collections.CollectionsKt.collectionSizeOrDefault(r0, 10));
        r0 = r0.iterator();
     */
    /* JADX WARN: Code restructure failed: missing block: B:78:0x0058, code lost:
    
        if (r0.hasNext() == false) goto L80;
     */
    /* JADX WARN: Code restructure failed: missing block: B:79:0x005a, code lost:
    
        r2 = '_';
     */
    /* JADX WARN: Code restructure failed: missing block: B:80:0x005d, code lost:
    
        r2 = '2';
     */
    /* JADX WARN: Code restructure failed: missing block: B:81:0x005f, code lost:
    
        if (r2 == '2') goto L111;
     */
    /* JADX WARN: Code restructure failed: missing block: B:82:0x0061, code lost:
    
        r2 = (id.dana.cashier.domain.model.CashierPayChannelInfo) r0.next();
     */
    /* JADX WARN: Code restructure failed: missing block: B:83:0x0073, code lost:
    
        if (kotlin.jvm.internal.Intrinsics.areEqual(r2.getPayMethod(), "ONLINE_CREDIT") == false) goto L85;
     */
    /* JADX WARN: Code restructure failed: missing block: B:84:0x0075, code lost:
    
        r3 = 5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:85:0x0077, code lost:
    
        r3 = 'c';
     */
    /* JADX WARN: Code restructure failed: missing block: B:86:0x0079, code lost:
    
        r5 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:87:0x007a, code lost:
    
        if (r3 == 'c') goto L89;
     */
    /* JADX WARN: Code restructure failed: missing block: B:88:0x007c, code lost:
    
        r3 = r7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:89:0x007e, code lost:
    
        r3 = id.dana.cashier.data.repository.CashierEntityRepository.PlaceComponentResult + 57;
        id.dana.cashier.data.repository.CashierEntityRepository.getAuthRequestContext = r3 % 128;
        r3 = r3 % 2;
        r3 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:90:0x0089, code lost:
    
        r2.setPayLaterMethodConfig(r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:91:0x0096, code lost:
    
        if (kotlin.jvm.internal.Intrinsics.areEqual(r2.getPayMethod(), id.dana.domain.payasset.model.PayMethod.LOAN_CREDIT) == false) goto L113;
     */
    /* JADX WARN: Code restructure failed: missing block: B:92:0x0098, code lost:
    
        r3 = id.dana.cashier.data.repository.CashierEntityRepository.PlaceComponentResult + 57;
        id.dana.cashier.data.repository.CashierEntityRepository.getAuthRequestContext = r3 % 128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:93:0x00a2, code lost:
    
        if ((r3 % 2) != 0) goto L98;
     */
    /* JADX WARN: Code restructure failed: missing block: B:94:0x00a4, code lost:
    
        r3 = r5.length;
     */
    /* JADX WARN: Code restructure failed: missing block: B:98:0x00a8, code lost:
    
        r5 = r6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:99:0x00a9, code lost:
    
        r2.setPayLaterCicilMethodConfig(r5);
        r1.add(kotlin.Unit.INSTANCE);
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v0 */
    /* JADX WARN: Type inference failed for: r5v2 */
    /* renamed from: payCashierWithCredential$lambda-4 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static final id.dana.cashier.domain.model.CashierPay m528payCashierWithCredential$lambda4(id.dana.domain.paylater.model.PaylaterCicilMethodConfig r6, id.dana.data.config.model.PayLaterMethodConfig r7, id.dana.cashier.domain.model.CashierPay r8) {
        /*
            int r0 = id.dana.cashier.data.repository.CashierEntityRepository.PlaceComponentResult
            int r0 = r0 + 91
            int r1 = r0 % 128
            id.dana.cashier.data.repository.CashierEntityRepository.getAuthRequestContext = r1
            int r0 = r0 % 2
            r1 = 0
            java.lang.String r2 = ""
            if (r0 != 0) goto L24
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r2)
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r2)
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r2)
            id.dana.cashier.domain.model.Attribute r0 = r8.getAttributes()
            r2 = 65
            int r2 = r2 / r1
            if (r0 == 0) goto Lb7
            goto L39
        L22:
            r6 = move-exception
            throw r6
        L24:
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r2)
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r2)
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r2)
            id.dana.cashier.domain.model.Attribute r0 = r8.getAttributes()
            if (r0 == 0) goto L34
            goto L35
        L34:
            r1 = 1
        L35:
            if (r1 == 0) goto L39
            goto Lb7
        L39:
            java.util.List r0 = r0.getPayChannels()
            if (r0 == 0) goto Lb7
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            java.util.ArrayList r1 = new java.util.ArrayList
            r2 = 10
            int r2 = kotlin.collections.CollectionsKt.collectionSizeOrDefault(r0, r2)
            r1.<init>(r2)
            java.util.Collection r1 = (java.util.Collection) r1
            java.util.Iterator r0 = r0.iterator()
        L52:
            boolean r2 = r0.hasNext()     // Catch: java.lang.Exception -> Lb5
            r3 = 50
            if (r2 == 0) goto L5d
            r2 = 95
            goto L5f
        L5d:
            r2 = 50
        L5f:
            if (r2 == r3) goto Lb2
            java.lang.Object r2 = r0.next()
            id.dana.cashier.domain.model.CashierPayChannelInfo r2 = (id.dana.cashier.domain.model.CashierPayChannelInfo) r2
            java.lang.String r3 = r2.getPayMethod()
            java.lang.String r4 = "ONLINE_CREDIT"
            boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual(r3, r4)
            r4 = 99
            if (r3 == 0) goto L77
            r3 = 5
            goto L79
        L77:
            r3 = 99
        L79:
            r5 = 0
            if (r3 == r4) goto L7e
            r3 = r7
            goto L89
        L7e:
            int r3 = id.dana.cashier.data.repository.CashierEntityRepository.PlaceComponentResult
            int r3 = r3 + 57
            int r4 = r3 % 128
            id.dana.cashier.data.repository.CashierEntityRepository.getAuthRequestContext = r4
            int r3 = r3 % 2
            r3 = r5
        L89:
            r2.setPayLaterMethodConfig(r3)
            java.lang.String r3 = r2.getPayMethod()
            java.lang.String r4 = "LOAN_CREDIT"
            boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual(r3, r4)
            if (r3 == 0) goto La9
            int r3 = id.dana.cashier.data.repository.CashierEntityRepository.PlaceComponentResult     // Catch: java.lang.Exception -> Lb5
            int r3 = r3 + 57
            int r4 = r3 % 128
            id.dana.cashier.data.repository.CashierEntityRepository.getAuthRequestContext = r4     // Catch: java.lang.Exception -> Lb5
            int r3 = r3 % 2
            if (r3 != 0) goto La8
            int r3 = r5.length     // Catch: java.lang.Throwable -> La6
            goto La8
        La6:
            r6 = move-exception
            throw r6
        La8:
            r5 = r6
        La9:
            r2.setPayLaterCicilMethodConfig(r5)
            kotlin.Unit r2 = kotlin.Unit.INSTANCE
            r1.add(r2)
            goto L52
        Lb2:
            java.util.List r1 = (java.util.List) r1
            goto Lb7
        Lb5:
            r6 = move-exception
            throw r6
        Lb7:
            java.lang.String r6 = r6.getMid()
            r8.setPaylaterCicilMid(r6)
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.cashier.data.repository.CashierEntityRepository.m528payCashierWithCredential$lambda4(id.dana.domain.paylater.model.PaylaterCicilMethodConfig, id.dana.data.config.model.PayLaterMethodConfig, id.dana.cashier.domain.model.CashierPay):id.dana.cashier.domain.model.CashierPay");
    }

    /*  JADX ERROR: JadxRuntimeException in pass: ProcessVariables
        jadx.core.utils.exceptions.JadxRuntimeException: Method arg registers not loaded: id.dana.cashier.data.repository.CashierEntityRepository$$ExternalSyntheticLambda34.<init>(id.dana.cashier.data.mapper.CreateOrderInfoResultMapper):void, class status: GENERATED_AND_UNLOADED
        	at jadx.core.dex.nodes.MethodNode.getArgRegs(MethodNode.java:289)
        	at jadx.core.dex.visitors.regions.variables.ProcessVariables$1.isArgUnused(ProcessVariables.java:130)
        	at jadx.core.dex.visitors.regions.variables.ProcessVariables$1.lambda$isVarUnused$0(ProcessVariables.java:115)
        	at jadx.core.utils.ListUtils.allMatch(ListUtils.java:164)
        	at jadx.core.dex.visitors.regions.variables.ProcessVariables$1.isVarUnused(ProcessVariables.java:115)
        	at jadx.core.dex.visitors.regions.variables.ProcessVariables$1.processBlock(ProcessVariables.java:82)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:64)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at java.base/java.util.Collections$UnmodifiableCollection.forEach(Unknown Source)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverse(DepthRegionTraversal.java:19)
        	at jadx.core.dex.visitors.regions.variables.ProcessVariables.removeUnusedResults(ProcessVariables.java:73)
        	at jadx.core.dex.visitors.regions.variables.ProcessVariables.visit(ProcessVariables.java:48)
        */
    @Override // id.dana.cashier.domain.CashierRepository
    public final io.reactivex.Observable<id.dana.cashier.domain.model.CreateOrderInfo> createOrder(final id.dana.cashier.domain.model.CreateOrderRequest r4) {
        /*
            r3 = this;
            java.lang.String r0 = ""
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)     // Catch: java.lang.Exception -> L33
            id.dana.data.account.repository.source.AccountEntityData r1 = r3.createAccountData()     // Catch: java.lang.Exception -> L33
            io.reactivex.Observable r1 = r1.getNickname()     // Catch: java.lang.Exception -> L33
            id.dana.cashier.data.repository.CashierEntityRepository$$ExternalSyntheticLambda32 r2 = new id.dana.cashier.data.repository.CashierEntityRepository$$ExternalSyntheticLambda32     // Catch: java.lang.Exception -> L33
            r2.<init>()     // Catch: java.lang.Exception -> L33
            io.reactivex.Observable r4 = r1.flatMap(r2)     // Catch: java.lang.Exception -> L33
            id.dana.cashier.data.repository.CashierEntityRepository$$ExternalSyntheticLambda34 r1 = new id.dana.cashier.data.repository.CashierEntityRepository$$ExternalSyntheticLambda34     // Catch: java.lang.Exception -> L33
            id.dana.cashier.data.mapper.CreateOrderInfoResultMapper r2 = r3.createOrderInfoResultMapper     // Catch: java.lang.Exception -> L33
            r1.<init>()     // Catch: java.lang.Exception -> L33
            io.reactivex.Observable r4 = r4.map(r1)     // Catch: java.lang.Exception -> L33
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r0)     // Catch: java.lang.Exception -> L33
            io.reactivex.Observable r4 = r3.authenticatedRequest(r4)     // Catch: java.lang.Exception -> L33
            int r0 = id.dana.cashier.data.repository.CashierEntityRepository.getAuthRequestContext
            int r0 = r0 + 17
            int r1 = r0 % 128
            id.dana.cashier.data.repository.CashierEntityRepository.PlaceComponentResult = r1
            int r0 = r0 % 2
            return r4
        L33:
            r4 = move-exception
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.cashier.data.repository.CashierEntityRepository.createOrder(id.dana.cashier.domain.model.CreateOrderRequest):io.reactivex.Observable");
    }

    /* renamed from: createOrder$lambda-6 */
    private static final ObservableSource m498createOrder$lambda6(CreateOrderRequest createOrderRequest, CashierEntityRepository cashierEntityRepository, String str) {
        int i = PlaceComponentResult + 41;
        getAuthRequestContext = i % 128;
        int i2 = i % 2;
        Intrinsics.checkNotNullParameter(createOrderRequest, "");
        Intrinsics.checkNotNullParameter(cashierEntityRepository, "");
        Intrinsics.checkNotNullParameter(str, "");
        createOrderRequest.setUserName(str);
        CashierEntityData cashierNetworkEntityData = cashierEntityRepository.getCashierNetworkEntityData();
        CreateOrderEntityRequest apply = cashierEntityRepository.createOrderInfoRequestMapper.apply(createOrderRequest);
        Intrinsics.checkNotNullExpressionValue(apply, "");
        Observable<CreateOrderInfoResult> doCreateOrder = cashierNetworkEntityData.doCreateOrder(apply);
        int i3 = getAuthRequestContext + 13;
        PlaceComponentResult = i3 % 128;
        int i4 = i3 % 2;
        return doCreateOrder;
    }

    /*  JADX ERROR: JadxRuntimeException in pass: ProcessVariables
        jadx.core.utils.exceptions.JadxRuntimeException: Method arg registers not loaded: id.dana.cashier.data.repository.CashierEntityRepository$$ExternalSyntheticLambda4.<init>(id.dana.cashier.data.mapper.CashierEKtpAgreementResultMapper):void, class status: GENERATED_AND_UNLOADED
        	at jadx.core.dex.nodes.MethodNode.getArgRegs(MethodNode.java:289)
        	at jadx.core.dex.visitors.regions.variables.ProcessVariables$1.isArgUnused(ProcessVariables.java:130)
        	at jadx.core.dex.visitors.regions.variables.ProcessVariables$1.lambda$isVarUnused$0(ProcessVariables.java:115)
        	at jadx.core.utils.ListUtils.allMatch(ListUtils.java:164)
        	at jadx.core.dex.visitors.regions.variables.ProcessVariables$1.isVarUnused(ProcessVariables.java:115)
        	at jadx.core.dex.visitors.regions.variables.ProcessVariables$1.processBlock(ProcessVariables.java:82)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:64)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at java.base/java.util.Collections$UnmodifiableCollection.forEach(Unknown Source)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverse(DepthRegionTraversal.java:19)
        	at jadx.core.dex.visitors.regions.variables.ProcessVariables.removeUnusedResults(ProcessVariables.java:73)
        	at jadx.core.dex.visitors.regions.variables.ProcessVariables.visit(ProcessVariables.java:48)
        */
    @Override // id.dana.cashier.domain.CashierRepository
    public final io.reactivex.Observable<id.dana.cashier.domain.model.CashierAgreementResponse> createCashierAgreement(id.dana.cashier.domain.model.CashierAgreementRequest r4) {
        /*
            r3 = this;
            java.lang.String r0 = ""
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)     // Catch: java.lang.Exception -> L30
            id.dana.cashier.data.repository.source.CashierEntityData r1 = r3.getCashierNetworkEntityData()     // Catch: java.lang.Exception -> L30
            id.dana.cashier.data.mapper.CashierEKtpAgreementRequestMapper r2 = r3.cashierEKtpAgreementRequestMapper     // Catch: java.lang.Exception -> L30
            id.dana.cashier.data.repository.source.network.request.CashierAgreementEntityRequest r4 = r2.map(r4)     // Catch: java.lang.Exception -> L30
            io.reactivex.Observable r4 = r1.createCashierEKtpAgreement(r4)     // Catch: java.lang.Exception -> L30
            id.dana.cashier.data.repository.CashierEntityRepository$$ExternalSyntheticLambda4 r1 = new id.dana.cashier.data.repository.CashierEntityRepository$$ExternalSyntheticLambda4     // Catch: java.lang.Exception -> L30
            id.dana.cashier.data.mapper.CashierEKtpAgreementResultMapper r2 = r3.cashierEKtpAgreementResultMapper     // Catch: java.lang.Exception -> L30
            r1.<init>()     // Catch: java.lang.Exception -> L30
            io.reactivex.Observable r4 = r4.map(r1)     // Catch: java.lang.Exception -> L30
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r0)     // Catch: java.lang.Exception -> L30
            io.reactivex.Observable r4 = r3.authenticatedRequest(r4)     // Catch: java.lang.Exception -> L30
            int r0 = id.dana.cashier.data.repository.CashierEntityRepository.PlaceComponentResult
            int r0 = r0 + 17
            int r1 = r0 % 128
            id.dana.cashier.data.repository.CashierEntityRepository.getAuthRequestContext = r1
            int r0 = r0 % 2
            return r4
        L30:
            r4 = move-exception
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.cashier.data.repository.CashierEntityRepository.createCashierAgreement(id.dana.cashier.domain.model.CashierAgreementRequest):io.reactivex.Observable");
    }

    @Override // id.dana.cashier.domain.CashierRepository
    public final Observable<QueryCardPolicyInfo> getQueryCardPolicyByCardNo(QueryCardPolicy queryCardPolicy) {
        Intrinsics.checkNotNullParameter(queryCardPolicy, "");
        ObservableSource map = getCashierNetworkEntityData().getQueryCardPolicyByCardNo(QueryCardPolicyRequestMapperKt.toQueryCardPolicyRequest(queryCardPolicy)).map(new Function() { // from class: id.dana.cashier.data.repository.CashierEntityRepository$$ExternalSyntheticLambda39
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return CashierEntityRepository.m490$r8$lambda$aun7q7oCD4UOYjQH14pmwXaZNU((QueryCardPolicyInfoResult) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(map, "");
        Observable<QueryCardPolicyInfo> authenticatedRequest = authenticatedRequest((Observable) map);
        int i = getAuthRequestContext + 115;
        PlaceComponentResult = i % 128;
        int i2 = i % 2;
        return authenticatedRequest;
    }

    /* renamed from: getQueryCardPolicyByCardNo$lambda-7 */
    private static final QueryCardPolicyInfo m523getQueryCardPolicyByCardNo$lambda7(QueryCardPolicyInfoResult queryCardPolicyInfoResult) {
        try {
            int i = getAuthRequestContext + 75;
            try {
                PlaceComponentResult = i % 128;
                if ((i % 2 != 0 ? (char) 25 : 'H') != 25) {
                    Intrinsics.checkNotNullParameter(queryCardPolicyInfoResult, "");
                    return QueryCardPolicyInfoResultMapperKt.toQueryCardPolicyInfo(queryCardPolicyInfoResult);
                }
                Intrinsics.checkNotNullParameter(queryCardPolicyInfoResult, "");
                int i2 = 57 / 0;
                return QueryCardPolicyInfoResultMapperKt.toQueryCardPolicyInfo(queryCardPolicyInfoResult);
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    @Override // id.dana.cashier.domain.CashierRepository
    public final Observable<FetchBannerInfo> fetchBanner(final FetchBannerRequest fetchBannerRequest) {
        Intrinsics.checkNotNullParameter(fetchBannerRequest, "");
        ObservableSource flatMap = getBannerConfig().flatMap(new Function() { // from class: id.dana.cashier.data.repository.CashierEntityRepository$$ExternalSyntheticLambda43
            {
                CashierEntityRepository.this = this;
            }

            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return CashierEntityRepository.m486$r8$lambda$8QVj14coOlBVNFgFBMbtKnNXg(CashierEntityRepository.this, fetchBannerRequest, (BannerConfigResult) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(flatMap, "");
        Observable<FetchBannerInfo> authenticatedRequest = authenticatedRequest((Observable) flatMap);
        int i = getAuthRequestContext + 101;
        PlaceComponentResult = i % 128;
        int i2 = i % 2;
        return authenticatedRequest;
    }

    /* JADX WARN: Code restructure failed: missing block: B:51:0x002b, code lost:
    
        if ((r6 == null) != true) goto L60;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x0048, code lost:
    
        if ((r6 != null ? '%' : '\n') != '\n') goto L60;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x004a, code lost:
    
        r2 = kotlin.jvm.internal.Intrinsics.areEqual(r6.get(id.dana.data.config.source.amcs.result.BannerConfigResult.PAYMENT_SUCCESS), java.lang.Boolean.TRUE);
     */
    /* renamed from: fetchBanner$lambda-10 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static final io.reactivex.ObservableSource m499fetchBanner$lambda10(id.dana.cashier.data.repository.CashierEntityRepository r4, id.dana.cashier.domain.model.FetchBannerRequest r5, id.dana.data.config.source.amcs.result.BannerConfigResult r6) {
        /*
            int r0 = id.dana.cashier.data.repository.CashierEntityRepository.getAuthRequestContext
            int r0 = r0 + 79
            int r1 = r0 % 128
            id.dana.cashier.data.repository.CashierEntityRepository.PlaceComponentResult = r1
            int r0 = r0 % 2
            r1 = 86
            if (r0 == 0) goto L11
            r0 = 86
            goto L13
        L11:
            r0 = 92
        L13:
            r2 = 0
            java.lang.String r3 = ""
            if (r0 == r1) goto L2e
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r3)
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r3)
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r3)
            java.util.Map r6 = r6.getBannerManagementEnable()
            r0 = 1
            if (r6 == 0) goto L2a
            r1 = 0
            goto L2b
        L2a:
            r1 = 1
        L2b:
            if (r1 == r0) goto L56
            goto L4a
        L2e:
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r3)
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r3)
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r3)
            java.util.Map r6 = r6.getBannerManagementEnable()
            r0 = 0
            r0.hashCode()     // Catch: java.lang.Throwable -> L93
            r0 = 10
            if (r6 == 0) goto L46
            r1 = 37
            goto L48
        L46:
            r1 = 10
        L48:
            if (r1 == r0) goto L56
        L4a:
            java.lang.String r0 = "paymentSuccess"
            java.lang.Object r6 = r6.get(r0)
            java.lang.Boolean r0 = java.lang.Boolean.TRUE
            boolean r2 = kotlin.jvm.internal.Intrinsics.areEqual(r6, r0)
        L56:
            if (r2 == 0) goto L70
            id.dana.cashier.data.repository.source.CashierBannerManagementEntityData r4 = r4.getBannerManagementEntityData()
            id.dana.cashier.data.repository.source.network.request.CashierBannerEntityRequest r5 = id.dana.cashier.data.mapper.FetchBannerInfoRequestMapperKt.toCashierBannerEntityRequest(r5)     // Catch: java.lang.Exception -> L6e
            io.reactivex.Observable r4 = r4.getCashierSuccessBanner(r5)     // Catch: java.lang.Exception -> L6e
            id.dana.cashier.data.repository.CashierEntityRepository$$ExternalSyntheticLambda23 r5 = new id.dana.cashier.data.repository.CashierEntityRepository$$ExternalSyntheticLambda23     // Catch: java.lang.Exception -> L6e
            r5.<init>()     // Catch: java.lang.Exception -> L6e
            io.reactivex.Observable r4 = r4.map(r5)     // Catch: java.lang.Exception -> L6e
            goto L85
        L6e:
            r4 = move-exception
            goto L92
        L70:
            id.dana.cashier.data.repository.source.CashierEntityData r4 = r4.getCashierNetworkEntityData()
            id.dana.cashier.data.repository.source.network.request.FetchBannerEntityRequest r5 = id.dana.cashier.data.mapper.FetchBannerInfoRequestMapperKt.toFetchBannerEntityRequest(r5)
            io.reactivex.Observable r4 = r4.fetchBanner(r5)
            id.dana.cashier.data.repository.CashierEntityRepository$$ExternalSyntheticLambda24 r5 = new id.dana.cashier.data.repository.CashierEntityRepository$$ExternalSyntheticLambda24
            r5.<init>()
            io.reactivex.Observable r4 = r4.map(r5)
        L85:
            io.reactivex.ObservableSource r4 = (io.reactivex.ObservableSource) r4
            int r5 = id.dana.cashier.data.repository.CashierEntityRepository.PlaceComponentResult     // Catch: java.lang.Exception -> L6e
            int r5 = r5 + 119
            int r6 = r5 % 128
            id.dana.cashier.data.repository.CashierEntityRepository.getAuthRequestContext = r6     // Catch: java.lang.Exception -> L6e
            int r5 = r5 % 2
            return r4
        L92:
            throw r4
        L93:
            r4 = move-exception
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.cashier.data.repository.CashierEntityRepository.m499fetchBanner$lambda10(id.dana.cashier.data.repository.CashierEntityRepository, id.dana.cashier.domain.model.FetchBannerRequest, id.dana.data.config.source.amcs.result.BannerConfigResult):io.reactivex.ObservableSource");
    }

    /* renamed from: fetchBanner$lambda-10$lambda-8 */
    private static final FetchBannerInfo m500fetchBanner$lambda10$lambda8(CashierBannerEntityResponse cashierBannerEntityResponse) {
        int i = PlaceComponentResult + 73;
        getAuthRequestContext = i % 128;
        try {
            if (i % 2 != 0) {
                Intrinsics.checkNotNullParameter(cashierBannerEntityResponse, "");
                return FetchBannerInfoResultMapperKt.toFetchBannerInfo(cashierBannerEntityResponse);
            }
            Intrinsics.checkNotNullParameter(cashierBannerEntityResponse, "");
            FetchBannerInfo fetchBannerInfo = FetchBannerInfoResultMapperKt.toFetchBannerInfo(cashierBannerEntityResponse);
            Object[] objArr = null;
            int length = objArr.length;
            return fetchBannerInfo;
        } catch (Exception e) {
            throw e;
        }
    }

    /* renamed from: fetchBanner$lambda-10$lambda-9 */
    private static final FetchBannerInfo m501fetchBanner$lambda10$lambda9(FetchBannerInfoResult fetchBannerInfoResult) {
        FetchBannerInfo fetchBannerInfo;
        int i = getAuthRequestContext + 123;
        PlaceComponentResult = i % 128;
        if (!(i % 2 == 0)) {
            Intrinsics.checkNotNullParameter(fetchBannerInfoResult, "");
            fetchBannerInfo = FetchBannerInfoResultMapperKt.toFetchBannerInfo(fetchBannerInfoResult);
            int i2 = 38 / 0;
        } else {
            Intrinsics.checkNotNullParameter(fetchBannerInfoResult, "");
            fetchBannerInfo = FetchBannerInfoResultMapperKt.toFetchBannerInfo(fetchBannerInfoResult);
        }
        int i3 = getAuthRequestContext + 89;
        PlaceComponentResult = i3 % 128;
        if ((i3 % 2 != 0 ? 'F' : JSONLexer.EOI) != 'F') {
            return fetchBannerInfo;
        }
        int i4 = 18 / 0;
        return fetchBannerInfo;
    }

    private final Observable<BannerConfigResult> getBannerConfig() {
        int i = PlaceComponentResult + 37;
        getAuthRequestContext = i % 128;
        int i2 = i % 2;
        Observable<BannerConfigResult> bannerConfig = this.splitConfigEntityData.getBannerConfig();
        try {
            int i3 = PlaceComponentResult + 101;
            getAuthRequestContext = i3 % 128;
            if (!(i3 % 2 != 0)) {
                Object obj = null;
                obj.hashCode();
                return bannerConfig;
            }
            return bannerConfig;
        } catch (Exception e) {
            throw e;
        }
    }

    @Override // id.dana.cashier.domain.CashierRepository
    public final Observable<CashierPay> getQueryPayOption(QueryPayOptionInfoRequest queryPayOptionInfoRequest) {
        Intrinsics.checkNotNullParameter(queryPayOptionInfoRequest, "");
        ObservableSource map = getCashierNetworkEntityData().getQueryPayOption(QueryPayOptionRequestMapperKt.toQueryPayOptionRequest(queryPayOptionInfoRequest)).map(new CashierEntityRepository$$ExternalSyntheticLambda45(this.cashierPayInfoResultMapper));
        Intrinsics.checkNotNullExpressionValue(map, "");
        Observable<CashierPay> authenticatedRequest = authenticatedRequest((Observable) map);
        int i = PlaceComponentResult + 73;
        getAuthRequestContext = i % 128;
        if ((i % 2 == 0 ? '!' : '9') != '!') {
            return authenticatedRequest;
        }
        Object[] objArr = null;
        int length = objArr.length;
        return authenticatedRequest;
    }

    /*  JADX ERROR: JadxRuntimeException in pass: ProcessVariables
        jadx.core.utils.exceptions.JadxRuntimeException: Method arg registers not loaded: id.dana.cashier.data.repository.CashierEntityRepository$$ExternalSyntheticLambda40.<init>(id.dana.cashier.data.mapper.QueryPromotionInfoResultMapper):void, class status: GENERATED_AND_UNLOADED
        	at jadx.core.dex.nodes.MethodNode.getArgRegs(MethodNode.java:289)
        	at jadx.core.dex.visitors.regions.variables.ProcessVariables$1.isArgUnused(ProcessVariables.java:130)
        	at jadx.core.dex.visitors.regions.variables.ProcessVariables$1.lambda$isVarUnused$0(ProcessVariables.java:115)
        	at jadx.core.utils.ListUtils.allMatch(ListUtils.java:164)
        	at jadx.core.dex.visitors.regions.variables.ProcessVariables$1.isVarUnused(ProcessVariables.java:115)
        	at jadx.core.dex.visitors.regions.variables.ProcessVariables$1.processBlock(ProcessVariables.java:82)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:64)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at java.base/java.util.Collections$UnmodifiableCollection.forEach(Unknown Source)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverse(DepthRegionTraversal.java:19)
        	at jadx.core.dex.visitors.regions.variables.ProcessVariables.removeUnusedResults(ProcessVariables.java:73)
        	at jadx.core.dex.visitors.regions.variables.ProcessVariables.visit(ProcessVariables.java:48)
        */
    @Override // id.dana.cashier.domain.CashierRepository
    public final io.reactivex.Observable<id.dana.cashier.domain.model.QueryPromotionInfo> getQueryPromotion(id.dana.cashier.domain.model.QueryPromotionRequest r4) {
        /*
            r3 = this;
            java.lang.String r0 = ""
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)     // Catch: java.lang.Exception -> L40
            id.dana.cashier.data.repository.source.CashierEntityData r1 = r3.getCashierNetworkEntityData()     // Catch: java.lang.Exception -> L40
            id.dana.cashier.data.repository.source.network.request.QueryPromotionEntityRequest r4 = id.dana.cashier.data.mapper.QueryPromotionRequestMapperKt.toQueryPromotionEntityRequest(r4)     // Catch: java.lang.Exception -> L40
            io.reactivex.Observable r4 = r1.getQueryPromotion(r4)     // Catch: java.lang.Exception -> L40
            id.dana.cashier.data.repository.CashierEntityRepository$$ExternalSyntheticLambda40 r1 = new id.dana.cashier.data.repository.CashierEntityRepository$$ExternalSyntheticLambda40     // Catch: java.lang.Exception -> L40
            id.dana.cashier.data.mapper.QueryPromotionInfoResultMapper r2 = r3.queryPromotionInfoResultMapper     // Catch: java.lang.Exception -> L40
            r1.<init>()     // Catch: java.lang.Exception -> L40
            io.reactivex.Observable r4 = r4.map(r1)     // Catch: java.lang.Exception -> L40
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r0)     // Catch: java.lang.Exception -> L40
            io.reactivex.Observable r4 = r3.authenticatedRequest(r4)     // Catch: java.lang.Exception -> L40
            int r0 = id.dana.cashier.data.repository.CashierEntityRepository.getAuthRequestContext
            int r0 = r0 + 29
            int r1 = r0 % 128
            id.dana.cashier.data.repository.CashierEntityRepository.PlaceComponentResult = r1
            int r0 = r0 % 2
            r1 = 30
            if (r0 == 0) goto L34
            r0 = 28
            goto L36
        L34:
            r0 = 30
        L36:
            if (r0 == r1) goto L3f
            r0 = 66
            int r0 = r0 / 0
            return r4
        L3d:
            r4 = move-exception
            throw r4
        L3f:
            return r4
        L40:
            r4 = move-exception
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.cashier.data.repository.CashierEntityRepository.getQueryPromotion(id.dana.cashier.domain.model.QueryPromotionRequest):io.reactivex.Observable");
    }

    @Override // id.dana.cashier.domain.CashierRepository
    public final Observable<String> getOneklikRedirectUrl(String scenario, String deviceId) {
        Intrinsics.checkNotNullParameter(scenario, "");
        Intrinsics.checkNotNullParameter(deviceId, "");
        ObservableSource map = getCashierNetworkEntityData().getOneklikRedirectUrl(scenario, deviceId).map(new Function() { // from class: id.dana.cashier.data.repository.CashierEntityRepository$$ExternalSyntheticLambda9
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return CashierEntityRepository.$r8$lambda$w76TgvjDXU3MSDxwsq35efSZh4c((QueryOneklikRedirectUrlResult) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(map, "");
        Observable<String> authenticatedRequest = authenticatedRequest((Observable) map);
        try {
            int i = getAuthRequestContext + 103;
            PlaceComponentResult = i % 128;
            if (!(i % 2 == 0)) {
                Object[] objArr = null;
                int length = objArr.length;
                return authenticatedRequest;
            }
            return authenticatedRequest;
        } catch (Exception e) {
            throw e;
        }
    }

    /* renamed from: getOneklikRedirectUrl$lambda-11 */
    private static final String m518getOneklikRedirectUrl$lambda11(QueryOneklikRedirectUrlResult queryOneklikRedirectUrlResult) {
        try {
            int i = PlaceComponentResult + 103;
            try {
                getAuthRequestContext = i % 128;
                int i2 = i % 2;
                Intrinsics.checkNotNullParameter(queryOneklikRedirectUrlResult, "");
                String redirectUrl = queryOneklikRedirectUrlResult.getRedirectUrl();
                int i3 = getAuthRequestContext + 25;
                PlaceComponentResult = i3 % 128;
                if ((i3 % 2 != 0 ? (char) 22 : '0') != 22) {
                    return redirectUrl;
                }
                int i4 = 50 / 0;
                return redirectUrl;
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    @Override // id.dana.cashier.domain.CashierRepository
    public final Observable<NpsSurveyConsultInfo> fetchNpsSurvey(NpsSurveyConsultRequest npsSurveyConsultRequest) {
        try {
            Intrinsics.checkNotNullParameter(npsSurveyConsultRequest, "");
            ObservableSource map = getCashierNetworkEntityData().fetchNpsSurvey(FetchNpsSurveyInfoRequestMapperKt.toNpsSurveyConsultEntityRequest(npsSurveyConsultRequest)).map(new Function() { // from class: id.dana.cashier.data.repository.CashierEntityRepository$$ExternalSyntheticLambda8
                @Override // io.reactivex.functions.Function
                public final Object apply(Object obj) {
                    return CashierEntityRepository.$r8$lambda$c8rz8NjhlYniHJAtkjLGiv3L5Yc((NpsSurveyInfoResult) obj);
                }
            });
            Intrinsics.checkNotNullExpressionValue(map, "");
            Observable<NpsSurveyConsultInfo> authenticatedRequest = authenticatedRequest((Observable) map);
            int i = getAuthRequestContext + 89;
            PlaceComponentResult = i % 128;
            if (i % 2 == 0) {
                return authenticatedRequest;
            }
            int i2 = 35 / 0;
            return authenticatedRequest;
        } catch (Exception e) {
            throw e;
        }
    }

    /* renamed from: fetchNpsSurvey$lambda-12 */
    private static final NpsSurveyConsultInfo m502fetchNpsSurvey$lambda12(NpsSurveyInfoResult npsSurveyInfoResult) {
        int i = PlaceComponentResult + 121;
        getAuthRequestContext = i % 128;
        int i2 = i % 2;
        Intrinsics.checkNotNullParameter(npsSurveyInfoResult, "");
        NpsSurveyConsultInfo npsSurveyConsult = FetchNpsSurveyResultMapperKt.toNpsSurveyConsult(npsSurveyInfoResult);
        try {
            int i3 = getAuthRequestContext + 21;
            PlaceComponentResult = i3 % 128;
            int i4 = i3 % 2;
            return npsSurveyConsult;
        } catch (Exception e) {
            throw e;
        }
    }

    @Override // id.dana.cashier.domain.CashierRepository
    public final Observable<Boolean> submitNpsSurvey(NpsSurveySubmitRequest npsSurveySubmitRequest) {
        try {
            Intrinsics.checkNotNullParameter(npsSurveySubmitRequest, "");
            try {
                ObservableSource map = getCashierNetworkEntityData().submitNpsSurvey(SubmitNpsSurveyInfoRequestMapperKt.toNpsSurveySubmitEntityRequest(npsSurveySubmitRequest)).map(new Function() { // from class: id.dana.cashier.data.repository.CashierEntityRepository$$ExternalSyntheticLambda33
                    @Override // io.reactivex.functions.Function
                    public final Object apply(Object obj) {
                        return CashierEntityRepository.m487$r8$lambda$G4NjXbKYDTEJ5E_VsSjzn_LWJY((NpsSurveySubmitEntityResult) obj);
                    }
                });
                Intrinsics.checkNotNullExpressionValue(map, "");
                Observable<Boolean> authenticatedRequest = authenticatedRequest((Observable) map);
                int i = PlaceComponentResult + 81;
                getAuthRequestContext = i % 128;
                int i2 = i % 2;
                return authenticatedRequest;
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    /* renamed from: submitNpsSurvey$lambda-13 */
    private static final Boolean m535submitNpsSurvey$lambda13(NpsSurveySubmitEntityResult npsSurveySubmitEntityResult) {
        boolean booleanValue;
        int i = PlaceComponentResult + 125;
        getAuthRequestContext = i % 128;
        int i2 = i % 2;
        try {
            Intrinsics.checkNotNullParameter(npsSurveySubmitEntityResult, "");
            Boolean success = npsSurveySubmitEntityResult.getSuccess();
            if ((success != null ? 'I' : 'K') == 'I') {
                int i3 = PlaceComponentResult + 79;
                getAuthRequestContext = i3 % 128;
                if (i3 % 2 != 0) {
                    booleanValue = success.booleanValue();
                } else {
                    booleanValue = success.booleanValue();
                    Object[] objArr = null;
                    int length = objArr.length;
                }
                r2 = booleanValue;
            }
            return Boolean.valueOf(r2);
        } catch (Exception e) {
            throw e;
        }
    }

    private final Observable<String> getCardCredentialKey() {
        Observable<String> authenticatedRequest;
        int i = getAuthRequestContext + 83;
        PlaceComponentResult = i % 128;
        if ((i % 2 != 0 ? '?' : Typography.quote) != '\"') {
            authenticatedRequest = authenticatedRequest(getCardCredentialPublicKey());
            Object[] objArr = null;
            int length = objArr.length;
        } else {
            try {
                authenticatedRequest = authenticatedRequest(getCardCredentialPublicKey());
            } catch (Exception e) {
                throw e;
            }
        }
        int i2 = getAuthRequestContext + 5;
        PlaceComponentResult = i2 % 128;
        if ((i2 % 2 != 0 ? 'E' : 'B') != 'B') {
            int i3 = 26 / 0;
            return authenticatedRequest;
        }
        return authenticatedRequest;
    }

    @Override // id.dana.cashier.domain.CashierRepository
    public final Observable<CashierKybProductInfo> getCashierKybProduct(GetCashierKybProductRequest cashierKybProductRequest) {
        Intrinsics.checkNotNullParameter(cashierKybProductRequest, "");
        ObservableSource map = getCashierNetworkEntityData().getCashierKybProduct(GetCashierKybProductInfoMapperKt.toGetCashierKybProductEntityRequest(cashierKybProductRequest)).map(new Function() { // from class: id.dana.cashier.data.repository.CashierEntityRepository$$ExternalSyntheticLambda44
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return CashierEntityRepository.$r8$lambda$VsA2gtvHVf74GKybtEsoFjlrcCk((CashierKybProductInfoResult) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(map, "");
        Observable<CashierKybProductInfo> authenticatedRequest = authenticatedRequest((Observable) map);
        int i = PlaceComponentResult + 107;
        getAuthRequestContext = i % 128;
        if ((i % 2 == 0 ? 'Q' : (char) 15) != 15) {
            Object obj = null;
            obj.hashCode();
            return authenticatedRequest;
        }
        return authenticatedRequest;
    }

    /* renamed from: getCashierKybProduct$lambda-14 */
    private static final CashierKybProductInfo m504getCashierKybProduct$lambda14(CashierKybProductInfoResult cashierKybProductInfoResult) {
        int i = PlaceComponentResult + 99;
        getAuthRequestContext = i % 128;
        int i2 = i % 2;
        Intrinsics.checkNotNullParameter(cashierKybProductInfoResult, "");
        CashierKybProductInfo cashierKybProductInfo = GetCashierKybProductInfoMapperKt.toCashierKybProductInfo(cashierKybProductInfoResult);
        int i3 = getAuthRequestContext + 91;
        PlaceComponentResult = i3 % 128;
        if ((i3 % 2 != 0 ? ',' : (char) 25) != ',') {
            return cashierKybProductInfo;
        }
        Object[] objArr = null;
        int length = objArr.length;
        return cashierKybProductInfo;
    }

    /* renamed from: getModalCategory$lambda-15 */
    private static final List m514getModalCategory$lambda15(CashierAddOnModalCategoryResult cashierAddOnModalCategoryResult) {
        int i = getAuthRequestContext + 91;
        PlaceComponentResult = i % 128;
        int i2 = i % 2;
        try {
            Intrinsics.checkNotNullParameter(cashierAddOnModalCategoryResult, "");
            List<String> category = cashierAddOnModalCategoryResult.getCategory();
            int i3 = getAuthRequestContext + 45;
            PlaceComponentResult = i3 % 128;
            int i4 = i3 % 2;
            return category;
        } catch (Exception e) {
            throw e;
        }
    }

    @Override // id.dana.cashier.domain.CashierRepository
    public final Observable<List<String>> getModalCategory() {
        ObservableSource map = getCashierNetworkEntityData().getModalCategory().map(new Function() { // from class: id.dana.cashier.data.repository.CashierEntityRepository$$ExternalSyntheticLambda26
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return CashierEntityRepository.m496$r8$lambda$yLMLDidbgfmVNIHzVzXdpTumkI((CashierAddOnModalCategoryResult) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(map, "");
        Observable<List<String>> authenticatedRequest = authenticatedRequest((Observable) map);
        int i = getAuthRequestContext + 111;
        PlaceComponentResult = i % 128;
        if ((i % 2 != 0 ? 'D' : '\b') != 'D') {
            return authenticatedRequest;
        }
        Object[] objArr = null;
        int length = objArr.length;
        return authenticatedRequest;
    }

    /* renamed from: getModalContent$lambda-16 */
    private static final CashierAddOnModalContent m515getModalContent$lambda16(CashierAddOnModalContentResult cashierAddOnModalContentResult) {
        CashierAddOnModalContent cashierAddOnModalContent;
        try {
            int i = getAuthRequestContext + 101;
            PlaceComponentResult = i % 128;
            Object[] objArr = null;
            if (i % 2 == 0) {
                Intrinsics.checkNotNullParameter(cashierAddOnModalContentResult, "");
                cashierAddOnModalContent = CashierAddOnModalContentKt.toCashierAddOnModalContent(cashierAddOnModalContentResult);
            } else {
                Intrinsics.checkNotNullParameter(cashierAddOnModalContentResult, "");
                cashierAddOnModalContent = CashierAddOnModalContentKt.toCashierAddOnModalContent(cashierAddOnModalContentResult);
                int length = objArr.length;
            }
            int i2 = getAuthRequestContext + 43;
            PlaceComponentResult = i2 % 128;
            if ((i2 % 2 != 0 ? '.' : '\r') != '\r') {
                objArr.hashCode();
                return cashierAddOnModalContent;
            }
            return cashierAddOnModalContent;
        } catch (Exception e) {
            throw e;
        }
    }

    @Override // id.dana.cashier.domain.CashierRepository
    public final Observable<CashierAddOnModalContent> getModalContent() {
        ObservableSource map = getCashierNetworkEntityData().getModalContent().map(new Function() { // from class: id.dana.cashier.data.repository.CashierEntityRepository$$ExternalSyntheticLambda13
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return CashierEntityRepository.m495$r8$lambda$xMFaa1zcUUFeKX_2LCfHU4ratA((CashierAddOnModalContentResult) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(map, "");
        Observable<CashierAddOnModalContent> authenticatedRequest = authenticatedRequest((Observable) map);
        int i = getAuthRequestContext + 67;
        PlaceComponentResult = i % 128;
        if ((i % 2 != 0 ? 'A' : (char) 28) != 'A') {
            return authenticatedRequest;
        }
        int i2 = 61 / 0;
        return authenticatedRequest;
    }

    @Override // id.dana.cashier.domain.CashierRepository
    public final Observable<DefaultResponse> updateOrder(CashierUpdateOrderRequest cashierUpdateOrderRequest) {
        try {
            Intrinsics.checkNotNullParameter(cashierUpdateOrderRequest, "");
            ObservableSource map = getCashierNetworkEntityData().updateOrder(CashierUpdateOrderEntityRequestKt.toCashierUpdateOrderEntityRequest(cashierUpdateOrderRequest)).map(new Function() { // from class: id.dana.cashier.data.repository.CashierEntityRepository$$ExternalSyntheticLambda1
                @Override // io.reactivex.functions.Function
                public final Object apply(Object obj) {
                    return CashierEntityRepository.$r8$lambda$CWs5noJ84QRM7TJq9fuW4jYrpRo((DefaultInfoResult) obj);
                }
            });
            Intrinsics.checkNotNullExpressionValue(map, "");
            Observable<DefaultResponse> authenticatedRequest = authenticatedRequest((Observable) map);
            int i = getAuthRequestContext + 27;
            PlaceComponentResult = i % 128;
            int i2 = i % 2;
            return authenticatedRequest;
        } catch (Exception e) {
            throw e;
        }
    }

    /* renamed from: updateOrder$lambda-17 */
    private static final DefaultResponse m537updateOrder$lambda17(DefaultInfoResult defaultInfoResult) {
        int i = getAuthRequestContext + 65;
        PlaceComponentResult = i % 128;
        if ((i % 2 != 0 ? 'a' : '5') == '5') {
            Intrinsics.checkNotNullParameter(defaultInfoResult, "");
            return DefaultInfoResultKt.toDefaultResponse(defaultInfoResult);
        }
        try {
            Intrinsics.checkNotNullParameter(defaultInfoResult, "");
            int i2 = 64 / 0;
            return DefaultInfoResultKt.toDefaultResponse(defaultInfoResult);
        } catch (Exception e) {
            throw e;
        }
    }

    /*  JADX ERROR: JadxRuntimeException in pass: ProcessVariables
        jadx.core.utils.exceptions.JadxRuntimeException: Method arg registers not loaded: id.dana.cashier.data.repository.CashierEntityRepository$$ExternalSyntheticLambda28.<init>(id.dana.cashier.data.mapper.CashierAddOnModalTooltipResultMapper):void, class status: GENERATED_AND_UNLOADED
        	at jadx.core.dex.nodes.MethodNode.getArgRegs(MethodNode.java:289)
        	at jadx.core.dex.visitors.regions.variables.ProcessVariables$1.isArgUnused(ProcessVariables.java:130)
        	at jadx.core.dex.visitors.regions.variables.ProcessVariables$1.lambda$isVarUnused$0(ProcessVariables.java:115)
        	at jadx.core.utils.ListUtils.allMatch(ListUtils.java:164)
        	at jadx.core.dex.visitors.regions.variables.ProcessVariables$1.isVarUnused(ProcessVariables.java:115)
        	at jadx.core.dex.visitors.regions.variables.ProcessVariables$1.processBlock(ProcessVariables.java:82)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:64)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverse(DepthRegionTraversal.java:19)
        	at jadx.core.dex.visitors.regions.variables.ProcessVariables.removeUnusedResults(ProcessVariables.java:73)
        	at jadx.core.dex.visitors.regions.variables.ProcessVariables.visit(ProcessVariables.java:48)
        */
    @Override // id.dana.cashier.domain.CashierRepository
    public final io.reactivex.Observable<id.dana.cashier.domain.model.CashierAddOnModalTooltip> getTooltipContent(id.dana.cashier.domain.model.CashierAddOnModalTooltipRequest r4) {
        /*
            r3 = this;
            java.lang.String r0 = ""
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            id.dana.cashier.data.repository.source.CashierEntityData r1 = r3.getCashierNetworkEntityData()
            id.dana.cashier.data.mapper.CashierAddOnModalTooltipRequestMapper r2 = r3.cashierAddOnModalTooltipRequestMapper
            id.dana.cashier.data.repository.source.network.request.CashierAddOnModalTooltipEntityRequest r4 = r2.map(r4)
            io.reactivex.Observable r4 = r1.getTooltipContent(r4)
            id.dana.cashier.data.repository.CashierEntityRepository$$ExternalSyntheticLambda28 r1 = new id.dana.cashier.data.repository.CashierEntityRepository$$ExternalSyntheticLambda28
            id.dana.cashier.data.mapper.CashierAddOnModalTooltipResultMapper r2 = r3.cashierAddOnModalTooltipResultMapper
            r1.<init>()
            io.reactivex.Observable r4 = r4.map(r1)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r0)
            io.reactivex.Observable r4 = r3.authenticatedRequest(r4)
            int r0 = id.dana.cashier.data.repository.CashierEntityRepository.getAuthRequestContext
            int r0 = r0 + 93
            int r1 = r0 % 128
            id.dana.cashier.data.repository.CashierEntityRepository.PlaceComponentResult = r1
            int r0 = r0 % 2
            r1 = 91
            if (r0 == 0) goto L36
            r0 = 91
            goto L38
        L36:
            r0 = 79
        L38:
            if (r0 == r1) goto L3b
            return r4
        L3b:
            r0 = 0
            int r0 = r0.length     // Catch: java.lang.Throwable -> L3e
            return r4
        L3e:
            r4 = move-exception
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.cashier.data.repository.CashierEntityRepository.getTooltipContent(id.dana.cashier.domain.model.CashierAddOnModalTooltipRequest):io.reactivex.Observable");
    }

    @Override // id.dana.cashier.domain.CashierRepository
    public final Observable<CashierAddOnCdnTooltip> getTooltipFromCdn(String tooltip) {
        Intrinsics.checkNotNullParameter(tooltip, "");
        ObservableSource map = getCashierNetworkEntityData().getTooltipFromCdn(tooltip).map(new Function() { // from class: id.dana.cashier.data.repository.CashierEntityRepository$$ExternalSyntheticLambda16
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return CashierEntityRepository.$r8$lambda$7RihpAki25fuwfNUCkgEJB1eHrE((CashierAddOnCdnTooltipResult) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(map, "");
        Observable<CashierAddOnCdnTooltip> authenticatedRequest = authenticatedRequest((Observable) map);
        int i = PlaceComponentResult + 57;
        getAuthRequestContext = i % 128;
        if ((i % 2 == 0 ? (char) 14 : '1') != '1') {
            Object obj = null;
            obj.hashCode();
            return authenticatedRequest;
        }
        return authenticatedRequest;
    }

    /* renamed from: getTooltipFromCdn$lambda-18 */
    private static final CashierAddOnCdnTooltip m525getTooltipFromCdn$lambda18(CashierAddOnCdnTooltipResult cashierAddOnCdnTooltipResult) {
        int i = PlaceComponentResult + 29;
        getAuthRequestContext = i % 128;
        int i2 = i % 2;
        Intrinsics.checkNotNullParameter(cashierAddOnCdnTooltipResult, "");
        CashierAddOnCdnTooltip cashierAddOnCdnTooltip = CashierAddOnCdnTooltipKt.toCashierAddOnCdnTooltip(cashierAddOnCdnTooltipResult);
        int i3 = PlaceComponentResult + 5;
        getAuthRequestContext = i3 % 128;
        int i4 = i3 % 2;
        return cashierAddOnCdnTooltip;
    }

    @Override // id.dana.cashier.domain.CashierRepository
    public final Observable<TopUpConsult> getTopUpConsult(TopUpConsultRequest topUpConsultRequest) {
        Intrinsics.checkNotNullParameter(topUpConsultRequest, "");
        ObservableSource map = getCashierNetworkEntityData().getTopUpConsult(TopUpConsultEntityRequestKt.toTopUpConsultEntityRequest(topUpConsultRequest)).map(new CashierEntityRepository$$ExternalSyntheticLambda0(this.topUpConsultResultMapper));
        Intrinsics.checkNotNullExpressionValue(map, "");
        Observable<TopUpConsult> authenticatedRequest = authenticatedRequest((Observable) map);
        int i = PlaceComponentResult + 41;
        getAuthRequestContext = i % 128;
        if (i % 2 != 0) {
            return authenticatedRequest;
        }
        int i2 = 31 / 0;
        return authenticatedRequest;
    }

    @Override // id.dana.cashier.domain.CashierRepository
    public final Observable<TopUpPay> topUpSubmit(final TopUpSubmitRequest topUpSubmitRequest) {
        try {
            Intrinsics.checkNotNullParameter(topUpSubmitRequest, "");
            try {
                ObservableSource flatMap = getCardCredentialKey().flatMap(new Function() { // from class: id.dana.cashier.data.repository.CashierEntityRepository$$ExternalSyntheticLambda17
                    {
                        CashierEntityRepository.this = this;
                    }

                    @Override // io.reactivex.functions.Function
                    public final Object apply(Object obj) {
                        return CashierEntityRepository.$r8$lambda$44E2Z0H7UgniCsFRsgs8V0iC2Po(CashierEntityRepository.this, topUpSubmitRequest, (String) obj);
                    }
                });
                Intrinsics.checkNotNullExpressionValue(flatMap, "");
                Observable<TopUpPay> authenticatedRequest = authenticatedRequest((Observable) flatMap);
                int i = PlaceComponentResult + 77;
                getAuthRequestContext = i % 128;
                if (i % 2 == 0) {
                    int i2 = 39 / 0;
                    return authenticatedRequest;
                }
                return authenticatedRequest;
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    /* renamed from: topUpSubmit$lambda-19 */
    private static final ObservableSource m536topUpSubmit$lambda19(CashierEntityRepository cashierEntityRepository, TopUpSubmitRequest topUpSubmitRequest, String str) {
        Intrinsics.checkNotNullParameter(cashierEntityRepository, "");
        Intrinsics.checkNotNullParameter(topUpSubmitRequest, "");
        Intrinsics.checkNotNullParameter(str, "");
        ObservableSource map = cashierEntityRepository.getCashierNetworkEntityData().topUpSubmit(TopUpSubmitEntityRequestKt.toTopUpSubmitEntityRequest(topUpSubmitRequest, str)).map(new CashierEntityRepository$$ExternalSyntheticLambda5(cashierEntityRepository.topUpPayResultMapper));
        int i = PlaceComponentResult + 125;
        getAuthRequestContext = i % 128;
        if ((i % 2 == 0 ? '@' : Typography.quote) != '@') {
            return map;
        }
        Object[] objArr = null;
        int length = objArr.length;
        return map;
    }

    @Override // id.dana.cashier.domain.CashierRepository
    public final Observable<TopUpPay> topUpVerify(TopUpVerifyRequest topUpVerifyRequest) {
        Intrinsics.checkNotNullParameter(topUpVerifyRequest, "");
        ObservableSource map = getCashierNetworkEntityData().topUpVerify(TopUpVerifyEntityRequestKt.toTopUpVerifyEntityRequest(topUpVerifyRequest)).map(new CashierEntityRepository$$ExternalSyntheticLambda5(this.topUpPayResultMapper));
        Intrinsics.checkNotNullExpressionValue(map, "");
        Observable<TopUpPay> authenticatedRequest = authenticatedRequest((Observable) map);
        try {
            int i = PlaceComponentResult + 43;
            try {
                getAuthRequestContext = i % 128;
                if ((i % 2 == 0 ? 'J' : (char) 3) != 3) {
                    Object obj = null;
                    obj.hashCode();
                    return authenticatedRequest;
                }
                return authenticatedRequest;
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    @Override // id.dana.cashier.domain.CashierRepository
    public final Observable<TopUpConsult> getTopUpAgent(TopUpConsultRequest topUpConsultRequest) {
        Intrinsics.checkNotNullParameter(topUpConsultRequest, "");
        ObservableSource map = getCashierNetworkEntityData().getTopUpAgent(TopUpConsultEntityRequestKt.toTopUpConsultEntityRequest(topUpConsultRequest)).map(new CashierEntityRepository$$ExternalSyntheticLambda0(this.topUpConsultResultMapper));
        Intrinsics.checkNotNullExpressionValue(map, "");
        Observable<TopUpConsult> authenticatedRequest = authenticatedRequest((Observable) map);
        int i = getAuthRequestContext + 83;
        PlaceComponentResult = i % 128;
        int i2 = i % 2;
        return authenticatedRequest;
    }

    @Override // id.dana.cashier.domain.CashierRepository
    public final Observable<DefaultResponse> addAssetCardForUser(AddAssetCardForUserRequest addAssetCardForUserRequest) {
        Intrinsics.checkNotNullParameter(addAssetCardForUserRequest, "");
        ObservableSource map = getCashierNetworkEntityData().addAssetCardForUser(AddAssetCardForUserEntityRequestKt.toAddAssetCardForUserEntityRequest(addAssetCardForUserRequest)).map(new Function() { // from class: id.dana.cashier.data.repository.CashierEntityRepository$$ExternalSyntheticLambda47
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return CashierEntityRepository.m492$r8$lambda$rsvnDY19BZIsqkRZGSKLT5F8YU((DefaultInfoResult) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(map, "");
        Observable<DefaultResponse> authenticatedRequest = authenticatedRequest((Observable) map);
        int i = getAuthRequestContext + 81;
        PlaceComponentResult = i % 128;
        if ((i % 2 != 0 ? Typography.amp : 'U') != 'U') {
            Object[] objArr = null;
            int length = objArr.length;
            return authenticatedRequest;
        }
        return authenticatedRequest;
    }

    /* renamed from: addAssetCardForUser$lambda-20 */
    private static final DefaultResponse m497addAssetCardForUser$lambda20(DefaultInfoResult defaultInfoResult) {
        int i = PlaceComponentResult + 19;
        getAuthRequestContext = i % 128;
        if ((i % 2 == 0 ? 'I' : (char) 24) != 24) {
            Intrinsics.checkNotNullParameter(defaultInfoResult, "");
            int i2 = 18 / 0;
            return DefaultInfoResultKt.toDefaultResponse(defaultInfoResult);
        }
        try {
            Intrinsics.checkNotNullParameter(defaultInfoResult, "");
            return DefaultInfoResultKt.toDefaultResponse(defaultInfoResult);
        } catch (Exception e) {
            throw e;
        }
    }

    @Override // id.dana.cashier.domain.CashierRepository
    public final Observable<QueryInstallment> getQueryInstallment(QueryInstallmentRequest queryInstallmentRequest) {
        Intrinsics.checkNotNullParameter(queryInstallmentRequest, "");
        ObservableSource map = getCashierNetworkEntityData().getQueryInstallment(QueryInstallmentEntityRequestKt.toQueryInstallmentEntityRequest(queryInstallmentRequest)).map(new Function() { // from class: id.dana.cashier.data.repository.CashierEntityRepository$$ExternalSyntheticLambda37
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return CashierEntityRepository.$r8$lambda$o7yeStlNPHVjSwGMf5ZkyDtYUjk((QueryInstallmentResult) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(map, "");
        Observable<QueryInstallment> authenticatedRequest = authenticatedRequest((Observable) map);
        int i = getAuthRequestContext + 7;
        PlaceComponentResult = i % 128;
        int i2 = i % 2;
        return authenticatedRequest;
    }

    /* renamed from: getQueryInstallment$lambda-21 */
    private static final QueryInstallment m524getQueryInstallment$lambda21(QueryInstallmentResult queryInstallmentResult) {
        int i = PlaceComponentResult + 91;
        getAuthRequestContext = i % 128;
        if (i % 2 != 0) {
            Intrinsics.checkNotNullParameter(queryInstallmentResult, "");
            return QueryInstallmentResultKt.toQueryInstallment(queryInstallmentResult);
        }
        Intrinsics.checkNotNullParameter(queryInstallmentResult, "");
        int i2 = 35 / 0;
        return QueryInstallmentResultKt.toQueryInstallment(queryInstallmentResult);
    }

    /* renamed from: getPaylaterAgreementConfig$lambda-22 */
    private static final PaylaterAgreementConfig m519getPaylaterAgreementConfig$lambda22(PaylaterAgreementConfigResult paylaterAgreementConfigResult) {
        int i = PlaceComponentResult + 3;
        getAuthRequestContext = i % 128;
        int i2 = i % 2;
        try {
            Intrinsics.checkNotNullParameter(paylaterAgreementConfigResult, "");
            PaylaterAgreementConfig paylaterAgreementConfig = PaylaterAgreementConfigResultMapperKt.toPaylaterAgreementConfig(paylaterAgreementConfigResult);
            int i3 = getAuthRequestContext + 35;
            PlaceComponentResult = i3 % 128;
            int i4 = i3 % 2;
            return paylaterAgreementConfig;
        } catch (Exception e) {
            throw e;
        }
    }

    @Override // id.dana.cashier.domain.CashierRepository
    public final Observable<PaylaterAgreementConfig> getPaylaterAgreementConfig() {
        Observable map = this.splitConfigEntityData.getPaylaterAgreementConfig().map(new Function() { // from class: id.dana.cashier.data.repository.CashierEntityRepository$$ExternalSyntheticLambda35
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return CashierEntityRepository.m491$r8$lambda$o8qrp04gE8E9gnq2w7PUe0UnaE((PaylaterAgreementConfigResult) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(map, "");
        try {
            int i = getAuthRequestContext + 57;
            PlaceComponentResult = i % 128;
            if (i % 2 == 0) {
                return map;
            }
            int i2 = 76 / 0;
            return map;
        } catch (Exception e) {
            throw e;
        }
    }

    @Override // id.dana.cashier.domain.CashierRepository
    public final Observable<Space> getCdpGuide(String spaceCode) {
        Observable authRequestContext;
        try {
            Intrinsics.checkNotNullParameter(spaceCode, "");
            StringBuilder sb = new StringBuilder();
            String format = String.format(CacheKey.HOME.CDP_TUTORIAL_PAYMENT, Arrays.copyOf(new Object[]{spaceCode}, 1));
            Intrinsics.checkNotNullExpressionValue(format, "");
            sb.append(format);
            sb.append('_');
            sb.append(CommonUtil.PlaceComponentResult());
            String obj = sb.toString();
            Single<SpaceRpcResult> firstOrError = getNonEmptyCachedCdp(obj).firstOrError();
            Single<SpaceRpcResult> cdpFromNetworkAndSave = getCdpFromNetworkAndSave(spaceCode, obj);
            ObjectHelper.PlaceComponentResult(cdpFromNetworkAndSave, "resumeSingleInCaseOfError is null");
            Function PlaceComponentResult2 = Functions.PlaceComponentResult(cdpFromNetworkAndSave);
            ObjectHelper.PlaceComponentResult(PlaceComponentResult2, "resumeFunctionInCaseOfError is null");
            Single BuiltInFictitiousFunctionClassFactory2 = RxJavaPlugins.BuiltInFictitiousFunctionClassFactory(new SingleResumeNext(firstOrError, PlaceComponentResult2));
            if (!(BuiltInFictitiousFunctionClassFactory2 instanceof FuseToObservable ? false : true)) {
                int i = getAuthRequestContext + 7;
                PlaceComponentResult = i % 128;
                int i2 = i % 2;
                authRequestContext = ((FuseToObservable) BuiltInFictitiousFunctionClassFactory2).getAuthRequestContext();
                int i3 = PlaceComponentResult + 33;
                getAuthRequestContext = i3 % 128;
                int i4 = i3 % 2;
            } else {
                authRequestContext = RxJavaPlugins.BuiltInFictitiousFunctionClassFactory(new SingleToObservable(BuiltInFictitiousFunctionClassFactory2));
            }
            Intrinsics.checkNotNullExpressionValue(authRequestContext, "");
            Observable<Space> map = authenticatedRequest(authRequestContext).map(new CashierEntityRepository$$ExternalSyntheticLambda10(this.spaceResultMapper));
            Intrinsics.checkNotNullExpressionValue(map, "");
            return map;
        } catch (Exception e) {
            throw e;
        }
    }

    /* renamed from: getCashierHighlightConfig$lambda-23 */
    private static final CashierHighlightConfig m503getCashierHighlightConfig$lambda23(CashierHighlightConfigResult cashierHighlightConfigResult) {
        try {
            int i = getAuthRequestContext + 49;
            PlaceComponentResult = i % 128;
            if ((i % 2 != 0 ? ';' : '8') != ';') {
                Intrinsics.checkNotNullParameter(cashierHighlightConfigResult, "");
                return CashierHighlightConfigResultKt.toCashierHighlightConfig(cashierHighlightConfigResult);
            }
            Intrinsics.checkNotNullParameter(cashierHighlightConfigResult, "");
            CashierHighlightConfig cashierHighlightConfig = CashierHighlightConfigResultKt.toCashierHighlightConfig(cashierHighlightConfigResult);
            Object[] objArr = null;
            int length = objArr.length;
            return cashierHighlightConfig;
        } catch (Exception e) {
            throw e;
        }
    }

    @Override // id.dana.cashier.domain.CashierRepository
    public final Observable<CashierHighlightConfig> getCashierHighlightConfig() {
        Observable map = getCashierSplitEntityData().getCashierHighlightConfig().map(new Function() { // from class: id.dana.cashier.data.repository.CashierEntityRepository$$ExternalSyntheticLambda2
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return CashierEntityRepository.$r8$lambda$EKBOxQBbPCqYiW7tpKFC_atGcps((CashierHighlightConfigResult) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(map, "");
        int i = PlaceComponentResult + 17;
        getAuthRequestContext = i % 128;
        if ((i % 2 == 0 ? (char) 11 : 'a') != 11) {
            return map;
        }
        int i2 = 36 / 0;
        return map;
    }

    @Override // id.dana.cashier.domain.CashierRepository
    public final Observable<Boolean> saveHighlightVersion(final String instId, final int version) {
        Intrinsics.checkNotNullParameter(instId, "");
        Observable flatMap = getPhoneNumber().flatMap(new Function() { // from class: id.dana.cashier.data.repository.CashierEntityRepository$$ExternalSyntheticLambda6
            {
                CashierEntityRepository.this = this;
            }

            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return CashierEntityRepository.m489$r8$lambda$YaKtVYywausn8shXFKbHkMJC1A(CashierEntityRepository.this, instId, version, (String) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(flatMap, "");
        int i = getAuthRequestContext + 15;
        PlaceComponentResult = i % 128;
        if ((i % 2 != 0 ? 'A' : (char) 6) != 'A') {
            return flatMap;
        }
        Object obj = null;
        obj.hashCode();
        return flatMap;
    }

    /* renamed from: saveHighlightVersion$lambda-24 */
    private static final ObservableSource m531saveHighlightVersion$lambda24(CashierEntityRepository cashierEntityRepository, String str, int i, String str2) {
        int i2 = getAuthRequestContext + 33;
        PlaceComponentResult = i2 % 128;
        int i3 = i2 % 2;
        Intrinsics.checkNotNullParameter(cashierEntityRepository, "");
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str2, "");
        Observable<Boolean> saveHighlightVersion = cashierEntityRepository.getCashierLocalEntityData().saveHighlightVersion(str2, str, i);
        int i4 = PlaceComponentResult + 51;
        getAuthRequestContext = i4 % 128;
        int i5 = i4 % 2;
        return saveHighlightVersion;
    }

    @Override // id.dana.cashier.domain.CashierRepository
    public final Observable<Integer> getHighlightVersion(final String instId) {
        Intrinsics.checkNotNullParameter(instId, "");
        Observable flatMap = getPhoneNumber().flatMap(new Function() { // from class: id.dana.cashier.data.repository.CashierEntityRepository$$ExternalSyntheticLambda30
            {
                CashierEntityRepository.this = this;
            }

            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return CashierEntityRepository.$r8$lambda$oPoMzMdjUGSR52QkWEWlPnsSLJk(CashierEntityRepository.this, instId, (String) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(flatMap, "");
        int i = PlaceComponentResult + 115;
        getAuthRequestContext = i % 128;
        if ((i % 2 == 0 ? 'Y' : '-') != '-') {
            Object obj = null;
            obj.hashCode();
            return flatMap;
        }
        return flatMap;
    }

    /* renamed from: getHighlightVersion$lambda-25 */
    private static final ObservableSource m511getHighlightVersion$lambda25(CashierEntityRepository cashierEntityRepository, String str, String str2) {
        Observable<Integer> highlightVersion;
        int i = getAuthRequestContext + 107;
        PlaceComponentResult = i % 128;
        Object obj = null;
        if ((i % 2 != 0 ? 'a' : '\t') != 'a') {
            Intrinsics.checkNotNullParameter(cashierEntityRepository, "");
            Intrinsics.checkNotNullParameter(str, "");
            Intrinsics.checkNotNullParameter(str2, "");
            highlightVersion = cashierEntityRepository.getCashierLocalEntityData().getHighlightVersion(str2, str);
        } else {
            Intrinsics.checkNotNullParameter(cashierEntityRepository, "");
            Intrinsics.checkNotNullParameter(str, "");
            Intrinsics.checkNotNullParameter(str2, "");
            highlightVersion = cashierEntityRepository.getCashierLocalEntityData().getHighlightVersion(str2, str);
            obj.hashCode();
        }
        int i2 = getAuthRequestContext + 19;
        PlaceComponentResult = i2 % 128;
        if ((i2 % 2 != 0 ? JSONLexer.EOI : (char) 20) != 26) {
            return highlightVersion;
        }
        obj.hashCode();
        return highlightVersion;
    }

    @Override // id.dana.cashier.domain.CashierRepository
    public final Observable<Boolean> saveHighlightNewInstId(final String instId) {
        try {
            Intrinsics.checkNotNullParameter(instId, "");
            Observable flatMap = getPhoneNumber().flatMap(new Function() { // from class: id.dana.cashier.data.repository.CashierEntityRepository$$ExternalSyntheticLambda25
                {
                    CashierEntityRepository.this = this;
                }

                @Override // io.reactivex.functions.Function
                public final Object apply(Object obj) {
                    return CashierEntityRepository.$r8$lambda$1g8eRgVMqmiYrUbq7v6tUiQnS84(CashierEntityRepository.this, instId, (String) obj);
                }
            });
            Intrinsics.checkNotNullExpressionValue(flatMap, "");
            int i = PlaceComponentResult + 105;
            getAuthRequestContext = i % 128;
            if ((i % 2 == 0 ? 'Q' : (char) 22) != 'Q') {
                return flatMap;
            }
            int i2 = 14 / 0;
            return flatMap;
        } catch (Exception e) {
            throw e;
        }
    }

    /* renamed from: saveHighlightNewInstId$lambda-26 */
    private static final ObservableSource m529saveHighlightNewInstId$lambda26(CashierEntityRepository cashierEntityRepository, String str, String str2) {
        int i = PlaceComponentResult + 47;
        getAuthRequestContext = i % 128;
        if ((i % 2 == 0 ? ']' : (char) 20) != 20) {
            Intrinsics.checkNotNullParameter(cashierEntityRepository, "");
            Intrinsics.checkNotNullParameter(str, "");
            Intrinsics.checkNotNullParameter(str2, "");
            Observable<Boolean> saveHighlightNewInstId = cashierEntityRepository.getCashierLocalEntityData().saveHighlightNewInstId(str2, str);
            Object obj = null;
            obj.hashCode();
            return saveHighlightNewInstId;
        }
        Intrinsics.checkNotNullParameter(cashierEntityRepository, "");
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str2, "");
        return cashierEntityRepository.getCashierLocalEntityData().saveHighlightNewInstId(str2, str);
    }

    @Override // id.dana.cashier.domain.CashierRepository
    public final Observable<String> getHighlightNewInstId() {
        Observable flatMap = getPhoneNumber().flatMap(new Function() { // from class: id.dana.cashier.data.repository.CashierEntityRepository$$ExternalSyntheticLambda48
            {
                CashierEntityRepository.this = this;
            }

            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return CashierEntityRepository.$r8$lambda$ckxgzibtquIV1FcEnYEXEzmPbOU(CashierEntityRepository.this, (String) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(flatMap, "");
        int i = PlaceComponentResult + 3;
        getAuthRequestContext = i % 128;
        int i2 = i % 2;
        return flatMap;
    }

    /* renamed from: getHighlightNewInstId$lambda-27 */
    private static final ObservableSource m509getHighlightNewInstId$lambda27(CashierEntityRepository cashierEntityRepository, String str) {
        try {
            int i = getAuthRequestContext + 37;
            PlaceComponentResult = i % 128;
            if (i % 2 == 0) {
                Intrinsics.checkNotNullParameter(cashierEntityRepository, "");
                Intrinsics.checkNotNullParameter(str, "");
                return cashierEntityRepository.getCashierLocalEntityData().getHighlightNewInstId(str);
            }
            Intrinsics.checkNotNullParameter(cashierEntityRepository, "");
            Intrinsics.checkNotNullParameter(str, "");
            Observable<String> highlightNewInstId = cashierEntityRepository.getCashierLocalEntityData().getHighlightNewInstId(str);
            Object obj = null;
            obj.hashCode();
            return highlightNewInstId;
        } catch (Exception e) {
            throw e;
        }
    }

    @Override // id.dana.cashier.domain.CashierRepository
    public final Observable<Boolean> saveHighlightTimeShown(final String mode, final String instId) {
        Intrinsics.checkNotNullParameter(mode, "");
        Intrinsics.checkNotNullParameter(instId, "");
        Observable flatMap = getPhoneNumber().flatMap(new Function() { // from class: id.dana.cashier.data.repository.CashierEntityRepository$$ExternalSyntheticLambda31
            {
                CashierEntityRepository.this = this;
            }

            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return CashierEntityRepository.$r8$lambda$DWdn1XvWOO2rs2D2wBPytp4bNYw(CashierEntityRepository.this, mode, instId, (String) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(flatMap, "");
        int i = PlaceComponentResult + 9;
        getAuthRequestContext = i % 128;
        if ((i % 2 == 0 ? (char) 5 : '!') != 5) {
            return flatMap;
        }
        int i2 = 72 / 0;
        return flatMap;
    }

    /* renamed from: saveHighlightTimeShown$lambda-28 */
    private static final ObservableSource m530saveHighlightTimeShown$lambda28(CashierEntityRepository cashierEntityRepository, String str, String str2, String str3) {
        int i = getAuthRequestContext + 19;
        PlaceComponentResult = i % 128;
        int i2 = i % 2;
        Intrinsics.checkNotNullParameter(cashierEntityRepository, "");
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str2, "");
        Intrinsics.checkNotNullParameter(str3, "");
        Observable<Boolean> saveHighlightTimeShown = cashierEntityRepository.getCashierLocalEntityData().saveHighlightTimeShown(str, str3, str2);
        int i3 = PlaceComponentResult + 63;
        getAuthRequestContext = i3 % 128;
        if ((i3 % 2 == 0 ? 'A' : (char) 16) != 16) {
            Object[] objArr = null;
            int length = objArr.length;
            return saveHighlightTimeShown;
        }
        return saveHighlightTimeShown;
    }

    @Override // id.dana.cashier.domain.CashierRepository
    public final Observable<Long> getHighlightTimeShown(final String mode, final String instId) {
        Intrinsics.checkNotNullParameter(mode, "");
        Intrinsics.checkNotNullParameter(instId, "");
        Observable flatMap = getPhoneNumber().flatMap(new Function() { // from class: id.dana.cashier.data.repository.CashierEntityRepository$$ExternalSyntheticLambda21
            {
                CashierEntityRepository.this = this;
            }

            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return CashierEntityRepository.$r8$lambda$My9TgUAOcS60AXMsbLiqWasr7s4(CashierEntityRepository.this, mode, instId, (String) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(flatMap, "");
        int i = getAuthRequestContext + 73;
        PlaceComponentResult = i % 128;
        int i2 = i % 2;
        return flatMap;
    }

    /* renamed from: getHighlightTimeShown$lambda-29 */
    private static final ObservableSource m510getHighlightTimeShown$lambda29(CashierEntityRepository cashierEntityRepository, String str, String str2, String str3) {
        int i = PlaceComponentResult + 113;
        getAuthRequestContext = i % 128;
        int i2 = i % 2;
        Intrinsics.checkNotNullParameter(cashierEntityRepository, "");
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str2, "");
        Intrinsics.checkNotNullParameter(str3, "");
        Observable<Long> highlightTimeShown = cashierEntityRepository.getCashierLocalEntityData().getHighlightTimeShown(str, str3, str2);
        int i3 = getAuthRequestContext + 27;
        PlaceComponentResult = i3 % 128;
        int i4 = i3 % 2;
        return highlightTimeShown;
    }

    @Override // id.dana.cashier.domain.CashierRepository
    public final Observable<Integer> getPaylaterCicilRegistrationCacheCooldownCount() {
        try {
            Observable flatMap = getPhoneNumber().flatMap(new Function() { // from class: id.dana.cashier.data.repository.CashierEntityRepository$$ExternalSyntheticLambda27
                {
                    CashierEntityRepository.this = this;
                }

                @Override // io.reactivex.functions.Function
                public final Object apply(Object obj) {
                    return CashierEntityRepository.$r8$lambda$0PGF7pHdXwwHHE49RoPCcUiOz1Y(CashierEntityRepository.this, (String) obj);
                }
            });
            try {
                Intrinsics.checkNotNullExpressionValue(flatMap, "");
                int i = getAuthRequestContext + 99;
                PlaceComponentResult = i % 128;
                int i2 = i % 2;
                return flatMap;
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    /* renamed from: getPaylaterCicilRegistrationCacheCooldownCount$lambda-30 */
    private static final ObservableSource m521getPaylaterCicilRegistrationCacheCooldownCount$lambda30(CashierEntityRepository cashierEntityRepository, String str) {
        int i = PlaceComponentResult + 13;
        getAuthRequestContext = i % 128;
        int i2 = i % 2;
        Intrinsics.checkNotNullParameter(cashierEntityRepository, "");
        Intrinsics.checkNotNullParameter(str, "");
        Observable<Integer> paylaterCicilRegistrationCacheCooldownCount = cashierEntityRepository.getCashierLocalEntityData().getPaylaterCicilRegistrationCacheCooldownCount(str);
        int i3 = PlaceComponentResult + 55;
        getAuthRequestContext = i3 % 128;
        if (!(i3 % 2 == 0)) {
            return paylaterCicilRegistrationCacheCooldownCount;
        }
        Object[] objArr = null;
        int length = objArr.length;
        return paylaterCicilRegistrationCacheCooldownCount;
    }

    @Override // id.dana.cashier.domain.CashierRepository
    public final Observable<Boolean> savePaylaterCicilRegistrationCacheCooldownCount(final int cacheCooldownCount) {
        Observable flatMap = getPhoneNumber().flatMap(new Function() { // from class: id.dana.cashier.data.repository.CashierEntityRepository$$ExternalSyntheticLambda29
            {
                CashierEntityRepository.this = this;
            }

            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return CashierEntityRepository.$r8$lambda$q1BYwqOThCLeD3IxCYohwng5agY(CashierEntityRepository.this, cacheCooldownCount, (String) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(flatMap, "");
        try {
            int i = getAuthRequestContext + 77;
            PlaceComponentResult = i % 128;
            int i2 = i % 2;
            return flatMap;
        } catch (Exception e) {
            throw e;
        }
    }

    /* renamed from: savePaylaterCicilRegistrationCacheCooldownCount$lambda-31 */
    private static final ObservableSource m532savePaylaterCicilRegistrationCacheCooldownCount$lambda31(CashierEntityRepository cashierEntityRepository, int i, String str) {
        int i2 = PlaceComponentResult + 15;
        getAuthRequestContext = i2 % 128;
        if (i2 % 2 != 0) {
            Intrinsics.checkNotNullParameter(cashierEntityRepository, "");
            Intrinsics.checkNotNullParameter(str, "");
            return cashierEntityRepository.getCashierLocalEntityData().savePaylaterCicilRegistrationCacheCooldownCount(i, str);
        }
        Intrinsics.checkNotNullParameter(cashierEntityRepository, "");
        Intrinsics.checkNotNullParameter(str, "");
        Observable<Boolean> savePaylaterCicilRegistrationCacheCooldownCount = cashierEntityRepository.getCashierLocalEntityData().savePaylaterCicilRegistrationCacheCooldownCount(i, str);
        int i3 = 24 / 0;
        return savePaylaterCicilRegistrationCacheCooldownCount;
    }

    @Override // id.dana.cashier.domain.CashierRepository
    public final Observable<Long> getPaylaterCicilRegistrationCacheCooldownDelay() {
        Observable flatMap = getPhoneNumber().flatMap(new Function() { // from class: id.dana.cashier.data.repository.CashierEntityRepository$$ExternalSyntheticLambda7
            {
                CashierEntityRepository.this = this;
            }

            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return CashierEntityRepository.$r8$lambda$y44LhzbbkgWx6Ktgj8nSuvMHtNI(CashierEntityRepository.this, (String) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(flatMap, "");
        int i = PlaceComponentResult + 37;
        getAuthRequestContext = i % 128;
        int i2 = i % 2;
        return flatMap;
    }

    /* renamed from: getPaylaterCicilRegistrationCacheCooldownDelay$lambda-32 */
    private static final ObservableSource m522getPaylaterCicilRegistrationCacheCooldownDelay$lambda32(CashierEntityRepository cashierEntityRepository, String str) {
        int i = PlaceComponentResult + 113;
        getAuthRequestContext = i % 128;
        int i2 = i % 2;
        Intrinsics.checkNotNullParameter(cashierEntityRepository, "");
        Intrinsics.checkNotNullParameter(str, "");
        Observable<Long> paylaterCicilRegistrationCacheCooldownDelay = cashierEntityRepository.getCashierLocalEntityData().getPaylaterCicilRegistrationCacheCooldownDelay(str);
        int i3 = getAuthRequestContext + 11;
        PlaceComponentResult = i3 % 128;
        int i4 = i3 % 2;
        return paylaterCicilRegistrationCacheCooldownDelay;
    }

    @Override // id.dana.cashier.domain.CashierRepository
    public final Observable<Boolean> savePaylaterCicilRegistrationCacheCooldownDelay(final long cacheCooldownDelayStartTime) {
        Observable flatMap = getPhoneNumber().flatMap(new Function() { // from class: id.dana.cashier.data.repository.CashierEntityRepository$$ExternalSyntheticLambda36
            {
                CashierEntityRepository.this = this;
            }

            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return CashierEntityRepository.$r8$lambda$IyYC0cLZCCEKmYU8u3_5U0FsRaQ(CashierEntityRepository.this, cacheCooldownDelayStartTime, (String) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(flatMap, "");
        try {
            int i = getAuthRequestContext + 101;
            try {
                PlaceComponentResult = i % 128;
                int i2 = i % 2;
                return flatMap;
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    /* renamed from: savePaylaterCicilRegistrationCacheCooldownDelay$lambda-33 */
    private static final ObservableSource m533savePaylaterCicilRegistrationCacheCooldownDelay$lambda33(CashierEntityRepository cashierEntityRepository, long j, String str) {
        Observable<Boolean> savePaylaterCicilRegistrationCacheCooldownDelay;
        try {
            int i = getAuthRequestContext + 57;
            PlaceComponentResult = i % 128;
            if (!(i % 2 != 0)) {
                Intrinsics.checkNotNullParameter(cashierEntityRepository, "");
                Intrinsics.checkNotNullParameter(str, "");
                savePaylaterCicilRegistrationCacheCooldownDelay = cashierEntityRepository.getCashierLocalEntityData().savePaylaterCicilRegistrationCacheCooldownDelay(j, str);
            } else {
                try {
                    Intrinsics.checkNotNullParameter(cashierEntityRepository, "");
                    Intrinsics.checkNotNullParameter(str, "");
                    savePaylaterCicilRegistrationCacheCooldownDelay = cashierEntityRepository.getCashierLocalEntityData().savePaylaterCicilRegistrationCacheCooldownDelay(j, str);
                    int i2 = 45 / 0;
                } catch (Exception e) {
                    throw e;
                }
            }
            int i3 = getAuthRequestContext + 111;
            PlaceComponentResult = i3 % 128;
            if (i3 % 2 == 0) {
                return savePaylaterCicilRegistrationCacheCooldownDelay;
            }
            Object[] objArr = null;
            int length = objArr.length;
            return savePaylaterCicilRegistrationCacheCooldownDelay;
        } catch (Exception e2) {
            throw e2;
        }
    }

    private final Observable<SpaceRpcResult> getNonEmptyCachedCdp(String cacheKey) {
        Observable map = getCacheCdpGuideEntityData().getObject(cacheKey, TimedSpaceRpcResult.class).filter(new Predicate() { // from class: id.dana.cashier.data.repository.CashierEntityRepository$$ExternalSyntheticLambda11
            {
                CashierEntityRepository.this = this;
            }

            @Override // io.reactivex.functions.Predicate
            public final boolean test(Object obj) {
                return CashierEntityRepository.$r8$lambda$HN3VOoxr61MHqFHioAIfFwj_M8U(CashierEntityRepository.this, (TimedSpaceRpcResult) obj);
            }
        }).map(new Function() { // from class: id.dana.cashier.data.repository.CashierEntityRepository$$ExternalSyntheticLambda22
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return CashierEntityRepository.m488$r8$lambda$LkfrUVCr9m30hIQ028BtGTRHBU((TimedSpaceRpcResult) obj);
            }
        });
        int i = PlaceComponentResult + 119;
        getAuthRequestContext = i % 128;
        if ((i % 2 == 0 ? (char) 7 : (char) 14) != 14) {
            Object[] objArr = null;
            int length = objArr.length;
            return map;
        }
        return map;
    }

    /* JADX WARN: Code restructure failed: missing block: B:42:0x0025, code lost:
    
        if (r3 == false) goto L48;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x002e, code lost:
    
        if (r3.isStale(r4) == false) goto L48;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x0030, code lost:
    
        r3 = id.dana.cashier.data.repository.CashierEntityRepository.getAuthRequestContext + 121;
        id.dana.cashier.data.repository.CashierEntityRepository.PlaceComponentResult = r3 % 128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x003c, code lost:
    
        if ((r3 % 2) == 0) goto L51;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x003e, code lost:
    
        r3 = '7';
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x0041, code lost:
    
        r3 = 'H';
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x0043, code lost:
    
        if (r3 == 'H') goto L54;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x0046, code lost:
    
        r1 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x0048, code lost:
    
        r3 = id.dana.cashier.data.repository.CashierEntityRepository.getAuthRequestContext + 93;
        id.dana.cashier.data.repository.CashierEntityRepository.PlaceComponentResult = r3 % 128;
        r3 = r3 % 2;
     */
    /* renamed from: getNonEmptyCachedCdp$lambda-34 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static final boolean m516getNonEmptyCachedCdp$lambda34(id.dana.cashier.data.repository.CashierEntityRepository r3, id.dana.cashier.data.repository.source.network.result.TimedSpaceRpcResult r4) {
        /*
            java.lang.String r0 = ""
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)     // Catch: java.lang.Exception -> L5e
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)     // Catch: java.lang.Exception -> L5e
            id.dana.data.content.source.network.result.SpaceRpcResult r0 = r4.getSpaceRpcResult()     // Catch: java.lang.Exception -> L5e
            boolean r0 = r3.cdpContentIsEmpty(r0)     // Catch: java.lang.Exception -> L5e
            r1 = 0
            if (r0 != 0) goto L53
            int r0 = id.dana.cashier.data.repository.CashierEntityRepository.getAuthRequestContext
            int r0 = r0 + 67
            int r2 = r0 % 128
            id.dana.cashier.data.repository.CashierEntityRepository.PlaceComponentResult = r2
            int r0 = r0 % 2
            if (r0 == 0) goto L2a
            boolean r3 = r3.isStale(r4)
            r4 = 0
            int r4 = r4.length     // Catch: java.lang.Throwable -> L28
            if (r3 != 0) goto L53
            goto L30
        L28:
            r3 = move-exception
            throw r3
        L2a:
            boolean r3 = r3.isStale(r4)
            if (r3 != 0) goto L53
        L30:
            int r3 = id.dana.cashier.data.repository.CashierEntityRepository.getAuthRequestContext
            int r3 = r3 + 121
            int r4 = r3 % 128
            id.dana.cashier.data.repository.CashierEntityRepository.PlaceComponentResult = r4
            int r3 = r3 % 2
            r4 = 72
            if (r3 == 0) goto L41
            r3 = 55
            goto L43
        L41:
            r3 = 72
        L43:
            if (r3 == r4) goto L46
            goto L48
        L46:
            r3 = 1
            r1 = 1
        L48:
            int r3 = id.dana.cashier.data.repository.CashierEntityRepository.getAuthRequestContext
            int r3 = r3 + 93
            int r4 = r3 % 128
            id.dana.cashier.data.repository.CashierEntityRepository.PlaceComponentResult = r4
            int r3 = r3 % 2
            goto L5d
        L53:
            int r3 = id.dana.cashier.data.repository.CashierEntityRepository.PlaceComponentResult
            int r3 = r3 + 75
            int r4 = r3 % 128
            id.dana.cashier.data.repository.CashierEntityRepository.getAuthRequestContext = r4
            int r3 = r3 % 2
        L5d:
            return r1
        L5e:
            r3 = move-exception
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.cashier.data.repository.CashierEntityRepository.m516getNonEmptyCachedCdp$lambda34(id.dana.cashier.data.repository.CashierEntityRepository, id.dana.cashier.data.repository.source.network.result.TimedSpaceRpcResult):boolean");
    }

    /* renamed from: getNonEmptyCachedCdp$lambda-35 */
    private static final SpaceRpcResult m517getNonEmptyCachedCdp$lambda35(TimedSpaceRpcResult timedSpaceRpcResult) {
        SpaceRpcResult spaceRpcResult;
        int i = getAuthRequestContext + 67;
        PlaceComponentResult = i % 128;
        Object obj = null;
        if (!(i % 2 != 0)) {
            try {
                Intrinsics.checkNotNullParameter(timedSpaceRpcResult, "");
                spaceRpcResult = timedSpaceRpcResult.getSpaceRpcResult();
            } catch (Exception e) {
                throw e;
            }
        } else {
            Intrinsics.checkNotNullParameter(timedSpaceRpcResult, "");
            spaceRpcResult = timedSpaceRpcResult.getSpaceRpcResult();
            obj.hashCode();
        }
        int i2 = PlaceComponentResult + 111;
        getAuthRequestContext = i2 % 128;
        if (i2 % 2 != 0) {
            return spaceRpcResult;
        }
        obj.hashCode();
        return spaceRpcResult;
    }

    private final Single<SpaceRpcResult> getCdpFromNetworkAndSave(String spaceCode, final String cacheKey) {
        Single<SpaceRpcResult> firstOrError = getNetworkCdpGuideEntityData().get(spaceCode).filter(new Predicate() { // from class: id.dana.cashier.data.repository.CashierEntityRepository$$ExternalSyntheticLambda41
            {
                CashierEntityRepository.this = this;
            }

            @Override // io.reactivex.functions.Predicate
            public final boolean test(Object obj) {
                return CashierEntityRepository.$r8$lambda$jpQ5TK8aN6D9bjbf3dU9Qa6BbxE(CashierEntityRepository.this, (SpaceRpcResult) obj);
            }
        }).firstOrError();
        Consumer consumer = new Consumer() { // from class: id.dana.cashier.data.repository.CashierEntityRepository$$ExternalSyntheticLambda42
            {
                CashierEntityRepository.this = this;
            }

            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                CashierEntityRepository.m493$r8$lambda$szKeLxk3D9kpwKSto1mrCyyfVI(CashierEntityRepository.this, cacheKey, (SpaceRpcResult) obj);
            }
        };
        ObjectHelper.PlaceComponentResult(consumer, "onSuccess is null");
        Single<SpaceRpcResult> BuiltInFictitiousFunctionClassFactory2 = RxJavaPlugins.BuiltInFictitiousFunctionClassFactory(new SingleDoOnSuccess(firstOrError, consumer));
        Intrinsics.checkNotNullExpressionValue(BuiltInFictitiousFunctionClassFactory2, "");
        try {
            int i = getAuthRequestContext + 49;
            try {
                PlaceComponentResult = i % 128;
                int i2 = i % 2;
                return BuiltInFictitiousFunctionClassFactory2;
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    /* renamed from: getCdpFromNetworkAndSave$lambda-36 */
    private static final boolean m505getCdpFromNetworkAndSave$lambda36(CashierEntityRepository cashierEntityRepository, SpaceRpcResult spaceRpcResult) {
        boolean cdpContentIsEmpty;
        try {
            int i = PlaceComponentResult + 57;
            getAuthRequestContext = i % 128;
            if (i % 2 != 0) {
                Intrinsics.checkNotNullParameter(cashierEntityRepository, "");
                Intrinsics.checkNotNullParameter(spaceRpcResult, "");
                cdpContentIsEmpty = !cashierEntityRepository.cdpContentIsEmpty(spaceRpcResult);
            } else {
                Intrinsics.checkNotNullParameter(cashierEntityRepository, "");
                Intrinsics.checkNotNullParameter(spaceRpcResult, "");
                cdpContentIsEmpty = cashierEntityRepository.cdpContentIsEmpty(spaceRpcResult) | true;
            }
            int i2 = getAuthRequestContext + 47;
            PlaceComponentResult = i2 % 128;
            if (i2 % 2 != 0) {
                Object[] objArr = null;
                int length = objArr.length;
                return cdpContentIsEmpty;
            }
            return cdpContentIsEmpty;
        } catch (Exception e) {
            throw e;
        }
    }

    /* renamed from: getCdpFromNetworkAndSave$lambda-37 */
    private static final void m506getCdpFromNetworkAndSave$lambda37(CashierEntityRepository cashierEntityRepository, String str, SpaceRpcResult spaceRpcResult) {
        Intrinsics.checkNotNullParameter(cashierEntityRepository, "");
        Intrinsics.checkNotNullParameter(str, "");
        CacheEntityData<TimedSpaceRpcResult> cacheCdpGuideEntityData = cashierEntityRepository.getCacheCdpGuideEntityData();
        Intrinsics.checkNotNullExpressionValue(spaceRpcResult, "");
        cacheCdpGuideEntityData.saveData(str, new TimedSpaceRpcResult(spaceRpcResult, 0L, 2, null));
        int i = PlaceComponentResult + 121;
        getAuthRequestContext = i % 128;
        int i2 = i % 2;
    }

    @Override // id.dana.cashier.domain.CashierRepository
    public final Observable<List<String>> getCashierEntryPoints() {
        int i = getAuthRequestContext + 17;
        PlaceComponentResult = i % 128;
        int i2 = i % 2;
        Observable<List<String>> cashierNativeEntryPoints = this.splitConfigEntityData.getCashierNativeEntryPoints();
        int i3 = getAuthRequestContext + 111;
        PlaceComponentResult = i3 % 128;
        if (i3 % 2 == 0) {
            return cashierNativeEntryPoints;
        }
        Object[] objArr = null;
        int length = objArr.length;
        return cashierNativeEntryPoints;
    }

    @Override // id.dana.cashier.domain.CashierRepository
    public final Observable<Space> getCdpPaylaterCicilOnboardingContent(String spaceCode) {
        Intrinsics.checkNotNullParameter(spaceCode, "");
        ObservableSource map = getNetworkCdpGuideEntityData().get(spaceCode).map(new CashierEntityRepository$$ExternalSyntheticLambda10(this.spaceResultMapper));
        Intrinsics.checkNotNullExpressionValue(map, "");
        Observable<Space> authenticatedRequest = authenticatedRequest((Observable) map);
        int i = PlaceComponentResult + 41;
        getAuthRequestContext = i % 128;
        int i2 = i % 2;
        return authenticatedRequest;
    }

    @Override // id.dana.cashier.domain.CashierRepository
    public final Observable<LoanRegisterResultInfo> getLoanRegisterInfo(String agreementKey) {
        Intrinsics.checkNotNullParameter(agreementKey, "");
        ObservableSource map = getNetworkPaylaterEntityData().getLoanRegisterInfo(agreementKey).map(new Function() { // from class: id.dana.cashier.data.repository.CashierEntityRepository$$ExternalSyntheticLambda38
            {
                CashierEntityRepository.this = this;
            }

            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return CashierEntityRepository.m494$r8$lambda$x2XbS44X7AjUsblz_XPIxCFGsQ(CashierEntityRepository.this, (LoanRegisterResult) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(map, "");
        Observable<LoanRegisterResultInfo> authenticatedRequest = authenticatedRequest((Observable) map);
        try {
            int i = getAuthRequestContext + 121;
            try {
                PlaceComponentResult = i % 128;
                if (i % 2 == 0) {
                    return authenticatedRequest;
                }
                Object obj = null;
                obj.hashCode();
                return authenticatedRequest;
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    /* renamed from: getLoanRegisterInfo$lambda-38 */
    private static final LoanRegisterResultInfo m513getLoanRegisterInfo$lambda38(CashierEntityRepository cashierEntityRepository, LoanRegisterResult loanRegisterResult) {
        int i = PlaceComponentResult + 73;
        getAuthRequestContext = i % 128;
        if ((i % 2 == 0 ? '1' : (char) 23) == 23) {
            Intrinsics.checkNotNullParameter(cashierEntityRepository, "");
            Intrinsics.checkNotNullParameter(loanRegisterResult, "");
            return cashierEntityRepository.loanRegisterMapper.toLoanRegisterResultInfo(loanRegisterResult);
        }
        Intrinsics.checkNotNullParameter(cashierEntityRepository, "");
        Intrinsics.checkNotNullParameter(loanRegisterResult, "");
        LoanRegisterResultInfo loanRegisterResultInfo = cashierEntityRepository.loanRegisterMapper.toLoanRegisterResultInfo(loanRegisterResult);
        int i2 = 39 / 0;
        return loanRegisterResultInfo;
    }

    private final Observable<PaylaterCicilMethodConfig> getPaylaterCicilMethodConfig() {
        Observable map = getSplitPaylaterEntityData().getPaylaterCicilMethodConfig().map(new Function() { // from class: id.dana.cashier.data.repository.CashierEntityRepository$$ExternalSyntheticLambda12
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return CashierEntityRepository.$r8$lambda$caZW2Uprpn3SbEoypweLuXDDXUI((PaylaterCicilMethodConfigResult) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(map, "");
        int i = getAuthRequestContext + 103;
        PlaceComponentResult = i % 128;
        if (i % 2 != 0) {
            Object[] objArr = null;
            int length = objArr.length;
            return map;
        }
        return map;
    }

    /* renamed from: getPaylaterCicilMethodConfig$lambda-39 */
    private static final PaylaterCicilMethodConfig m520getPaylaterCicilMethodConfig$lambda39(PaylaterCicilMethodConfigResult paylaterCicilMethodConfigResult) {
        try {
            int i = PlaceComponentResult + 71;
            try {
                getAuthRequestContext = i % 128;
                int i2 = i % 2;
                Intrinsics.checkNotNullParameter(paylaterCicilMethodConfigResult, "");
                PaylaterCicilMethodConfig paylaterMethodConfig = PaylaterCicilMethodConfigResultMapperKt.toPaylaterMethodConfig(paylaterCicilMethodConfigResult);
                int i3 = getAuthRequestContext + 121;
                PlaceComponentResult = i3 % 128;
                if ((i3 % 2 != 0 ? 'V' : 'b') != 'b') {
                    Object[] objArr = null;
                    int length = objArr.length;
                    return paylaterMethodConfig;
                }
                return paylaterMethodConfig;
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    private final boolean isStale(TimedSpaceRpcResult timedSpaceRpcResult) {
        int i = PlaceComponentResult + 85;
        getAuthRequestContext = i % 128;
        int i2 = i % 2;
        boolean z = true ^ (Calendar.getInstance().getTimeInMillis() - timedSpaceRpcResult.getTime() <= TimeUnit.HOURS.toMillis(8L));
        try {
            int i3 = PlaceComponentResult + 93;
            getAuthRequestContext = i3 % 128;
            int i4 = i3 % 2;
            return z;
        } catch (Exception e) {
            throw e;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:51:0x0021, code lost:
    
        if ((r6 != null) != false) goto L55;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x0027, code lost:
    
        if (r6 != null) goto L55;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x0029, code lost:
    
        r6 = (id.dana.data.content.source.network.result.CdpContentEntity) kotlin.collections.CollectionsKt.firstOrNull((java.util.List) r6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x002f, code lost:
    
        if (r6 == null) goto L67;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x0033, code lost:
    
        r0 = id.dana.cashier.data.repository.CashierEntityRepository.getAuthRequestContext + 41;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x0037, code lost:
    
        id.dana.cashier.data.repository.CashierEntityRepository.PlaceComponentResult = r0 % 128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x0039, code lost:
    
        r0 = r0 % 2;
        r6 = r6.getContentValue();
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x003f, code lost:
    
        if (r6 == null) goto L67;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x0041, code lost:
    
        r4 = java.lang.Boolean.valueOf(kotlin.text.StringsKt.isBlank(r6));
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x004c, code lost:
    
        r6 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x004d, code lost:
    
        throw r6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x004e, code lost:
    
        r6 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x004f, code lost:
    
        throw r6;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final boolean cdpContentIsEmpty(id.dana.data.content.source.network.result.SpaceRpcResult r6) {
        /*
            r5 = this;
            int r0 = id.dana.cashier.data.repository.CashierEntityRepository.getAuthRequestContext
            int r0 = r0 + 75
            int r1 = r0 % 128
            id.dana.cashier.data.repository.CashierEntityRepository.PlaceComponentResult = r1
            int r0 = r0 % 2
            r1 = 64
            if (r0 == 0) goto L11
            r0 = 64
            goto L13
        L11:
            r0 = 86
        L13:
            r2 = 1
            r3 = 0
            r4 = 0
            java.util.List r6 = r6.getCdpContents()
            if (r0 == r1) goto L24
            if (r6 == 0) goto L20
            r0 = 1
            goto L21
        L20:
            r0 = 0
        L21:
            if (r0 == 0) goto L50
            goto L29
        L24:
            r4.hashCode()     // Catch: java.lang.Throwable -> L55
            if (r6 == 0) goto L50
        L29:
            java.lang.Object r6 = kotlin.collections.CollectionsKt.firstOrNull(r6)
            id.dana.data.content.source.network.result.CdpContentEntity r6 = (id.dana.data.content.source.network.result.CdpContentEntity) r6
            if (r6 == 0) goto L50
            int r0 = id.dana.cashier.data.repository.CashierEntityRepository.getAuthRequestContext     // Catch: java.lang.Exception -> L4e
            int r0 = r0 + 41
            int r1 = r0 % 128
            id.dana.cashier.data.repository.CashierEntityRepository.PlaceComponentResult = r1     // Catch: java.lang.Exception -> L4c
            int r0 = r0 % 2
            java.lang.String r6 = r6.getContentValue()
            if (r6 == 0) goto L50
            java.lang.CharSequence r6 = (java.lang.CharSequence) r6
            boolean r6 = kotlin.text.StringsKt.isBlank(r6)
            java.lang.Boolean r4 = java.lang.Boolean.valueOf(r6)
            goto L50
        L4c:
            r6 = move-exception
            throw r6
        L4e:
            r6 = move-exception
            throw r6
        L50:
            if (r4 != 0) goto L53
            goto L54
        L53:
            r2 = 0
        L54:
            return r2
        L55:
            r6 = move-exception
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.cashier.data.repository.CashierEntityRepository.cdpContentIsEmpty(id.dana.data.content.source.network.result.SpaceRpcResult):boolean");
    }

    private final Observable<String> getPhoneNumber() {
        int i = getAuthRequestContext + 43;
        PlaceComponentResult = i % 128;
        int i2 = i % 2;
        try {
            Observable<String> phoneNumber = createAccountLocalEntityData().getPhoneNumber();
            Intrinsics.checkNotNullExpressionValue(phoneNumber, "");
            int i3 = getAuthRequestContext + 35;
            PlaceComponentResult = i3 % 128;
            int i4 = i3 % 2;
            return phoneNumber;
        } catch (Exception e) {
            throw e;
        }
    }

    private final AccountEntityData createAccountLocalEntityData() {
        AccountEntityData createData2;
        int i = PlaceComponentResult + 57;
        getAuthRequestContext = i % 128;
        Object[] objArr = null;
        if ((i % 2 == 0 ? '@' : (char) 4) != 4) {
            createData2 = this.accountEntityDataFactory.createData2("local");
            Intrinsics.checkNotNullExpressionValue(createData2, "");
            int length = objArr.length;
        } else {
            createData2 = this.accountEntityDataFactory.createData2("local");
            Intrinsics.checkNotNullExpressionValue(createData2, "");
        }
        int i2 = PlaceComponentResult + 87;
        getAuthRequestContext = i2 % 128;
        if (i2 % 2 != 0) {
            return createData2;
        }
        int length2 = objArr.length;
        return createData2;
    }

    /* renamed from: getLastTimeSmartPayActivationShow$lambda-40 */
    private static final ObservableSource m512getLastTimeSmartPayActivationShow$lambda40(CashierEntityRepository cashierEntityRepository, String str) {
        try {
            int i = PlaceComponentResult + 123;
            getAuthRequestContext = i % 128;
            int i2 = i % 2;
            Intrinsics.checkNotNullParameter(cashierEntityRepository, "");
            Intrinsics.checkNotNullParameter(str, "");
            Observable<Long> lastTimeSmartPayActivationShow = cashierEntityRepository.getCashierLocalEntityData().getLastTimeSmartPayActivationShow(str);
            int i3 = PlaceComponentResult + 83;
            getAuthRequestContext = i3 % 128;
            if ((i3 % 2 == 0 ? 'c' : '+') != '+') {
                Object obj = null;
                obj.hashCode();
                return lastTimeSmartPayActivationShow;
            }
            return lastTimeSmartPayActivationShow;
        } catch (Exception e) {
            throw e;
        }
    }

    @Override // id.dana.cashier.domain.CashierRepository
    public final Observable<Long> getLastTimeSmartPayActivationShow() {
        Observable flatMap = getPhoneNumber().flatMap(new Function() { // from class: id.dana.cashier.data.repository.CashierEntityRepository$$ExternalSyntheticLambda18
            {
                CashierEntityRepository.this = this;
            }

            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return CashierEntityRepository.$r8$lambda$a_dQPcX4jhezblbFSWgoBENGBoU(CashierEntityRepository.this, (String) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(flatMap, "");
        try {
            int i = PlaceComponentResult + 5;
            try {
                getAuthRequestContext = i % 128;
                if (!(i % 2 == 0)) {
                    return flatMap;
                }
                int i2 = 43 / 0;
                return flatMap;
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    /* renamed from: setLastSmartPayActivationShow$lambda-41 */
    private static final ObservableSource m534setLastSmartPayActivationShow$lambda41(CashierEntityRepository cashierEntityRepository, long j, String str) {
        int i = getAuthRequestContext + 73;
        PlaceComponentResult = i % 128;
        if (!(i % 2 != 0)) {
            Intrinsics.checkNotNullParameter(cashierEntityRepository, "");
            Intrinsics.checkNotNullParameter(str, "");
            return cashierEntityRepository.getCashierLocalEntityData().setLastSmartPayActivationShow(j, str);
        }
        Intrinsics.checkNotNullParameter(cashierEntityRepository, "");
        Intrinsics.checkNotNullParameter(str, "");
        Observable<Boolean> lastSmartPayActivationShow = cashierEntityRepository.getCashierLocalEntityData().setLastSmartPayActivationShow(j, str);
        int i2 = 19 / 0;
        return lastSmartPayActivationShow;
    }

    @Override // id.dana.cashier.domain.CashierRepository
    public final Observable<Boolean> setLastSmartPayActivationShow(final long lastTime) {
        try {
            Observable flatMap = getPhoneNumber().flatMap(new Function() { // from class: id.dana.cashier.data.repository.CashierEntityRepository$$ExternalSyntheticLambda19
                {
                    CashierEntityRepository.this = this;
                }

                @Override // io.reactivex.functions.Function
                public final Object apply(Object obj) {
                    return CashierEntityRepository.$r8$lambda$4ujjMMmdpYIQVOkZgLXHubwWQq0(CashierEntityRepository.this, lastTime, (String) obj);
                }
            });
            Intrinsics.checkNotNullExpressionValue(flatMap, "");
            int i = getAuthRequestContext + 31;
            PlaceComponentResult = i % 128;
            if ((i % 2 != 0 ? '7' : (char) 2) != '7') {
                return flatMap;
            }
            Object obj = null;
            obj.hashCode();
            return flatMap;
        } catch (Exception e) {
            throw e;
        }
    }

    @Override // id.dana.cashier.domain.CashierRepository
    public final Observable<Map<String, CashierCurrencyFromCdn>> getCurrencyFromCdn() {
        ObservableSource map = getCashierNetworkEntityData().getCurrencyFromCdn().map(new Function() { // from class: id.dana.cashier.data.repository.CashierEntityRepository$$ExternalSyntheticLambda15
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return CashierEntityRepository.$r8$lambda$tyyI1lA80LE01el3kuRxnD620o8((Map) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(map, "");
        Observable<Map<String, CashierCurrencyFromCdn>> authenticatedRequest = authenticatedRequest((Observable) map);
        int i = PlaceComponentResult + 119;
        getAuthRequestContext = i % 128;
        if (!(i % 2 != 0)) {
            Object[] objArr = null;
            int length = objArr.length;
            return authenticatedRequest;
        }
        return authenticatedRequest;
    }

    /* renamed from: getCurrencyFromCdn$lambda-43 */
    private static final Map m508getCurrencyFromCdn$lambda43(Map map) {
        try {
            Intrinsics.checkNotNullParameter(map, "");
            LinkedHashMap linkedHashMap = new LinkedHashMap(MapsKt.mapCapacity(map.size()));
            Iterator it = map.entrySet().iterator();
            while (true) {
                if ((it.hasNext() ? '=' : (char) 1) != '=') {
                    int i = getAuthRequestContext + 105;
                    PlaceComponentResult = i % 128;
                    int i2 = i % 2;
                    return linkedHashMap;
                }
                int i3 = PlaceComponentResult + 119;
                getAuthRequestContext = i3 % 128;
                if ((i3 % 2 == 0 ? (char) 15 : '/') != '/') {
                    Map.Entry entry = (Map.Entry) it.next();
                    linkedHashMap.put(entry.getKey(), CashierCurrencyFromCdnKt.toCashierCurrencyFromCdn((CashierCurrencyFromCdnResult) entry.getValue()));
                    int i4 = 43 / 0;
                } else {
                    Map.Entry entry2 = (Map.Entry) it.next();
                    linkedHashMap.put(entry2.getKey(), CashierCurrencyFromCdnKt.toCashierCurrencyFromCdn((CashierCurrencyFromCdnResult) entry2.getValue()));
                }
            }
        } catch (Exception e) {
            throw e;
        }
    }

    private static void a(char[] cArr, char[] cArr2, char c, char[] cArr3, int i, Object[] objArr) {
        E e = new E();
        int length = cArr2.length;
        char[] cArr4 = new char[length];
        int length2 = cArr3.length;
        char[] cArr5 = new char[length2];
        System.arraycopy(cArr2, 0, cArr4, 0, length);
        System.arraycopy(cArr3, 0, cArr5, 0, length2);
        cArr4[0] = (char) (cArr4[0] ^ c);
        cArr5[2] = (char) (cArr5[2] + ((char) i));
        int length3 = cArr.length;
        char[] cArr6 = new char[length3];
        e.KClassImpl$Data$declaredNonStaticMembers$2 = 0;
        while (true) {
            if (e.KClassImpl$Data$declaredNonStaticMembers$2 < length3) {
                int i2 = $11 + 31;
                $10 = i2 % 128;
                int i3 = i2 % 2;
                int i4 = (e.KClassImpl$Data$declaredNonStaticMembers$2 + 2) % 4;
                int i5 = (e.KClassImpl$Data$declaredNonStaticMembers$2 + 3) % 4;
                e.MyBillsEntityDataFactory = (char) (((cArr4[e.KClassImpl$Data$declaredNonStaticMembers$2 % 4] * 32718) + cArr5[i4]) % 65535);
                cArr5[i5] = (char) (((cArr4[i5] * 32718) + cArr5[i4]) / 65535);
                cArr4[i5] = e.MyBillsEntityDataFactory;
                cArr6[e.KClassImpl$Data$declaredNonStaticMembers$2] = (char) ((((cArr4[i5] ^ cArr[e.KClassImpl$Data$declaredNonStaticMembers$2]) ^ (BuiltInFictitiousFunctionClassFactory ^ 4360990799332652212L)) ^ ((int) (KClassImpl$Data$declaredNonStaticMembers$2 ^ 4360990799332652212L))) ^ ((char) (MyBillsEntityDataFactory ^ 4360990799332652212L)));
                e.KClassImpl$Data$declaredNonStaticMembers$2++;
                int i6 = $10 + 31;
                $11 = i6 % 128;
                int i7 = i6 % 2;
            } else {
                objArr[0] = new String(cArr6);
                return;
            }
        }
    }
}
