package id.dana.mapper;

import id.dana.base.BaseResponseMapper;
import id.dana.domain.homeinfo.HomeInfoResponse;
import id.dana.domain.homeinfo.KycResponse;
import id.dana.domain.homeinfo.ProcessingTransactionResponse;
import id.dana.domain.homeinfo.SurveyInfoResponse;
import id.dana.model.HomeInfo;
import id.dana.model.KycInfo;
import id.dana.model.ProcessingTransaction;
import id.dana.model.SurveyInfo;
import id.dana.sendmoney.mapper.CurrencyAmountModelMapper;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B!\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0012\u0012\u0006\u0010\u001a\u001a\u00020\u0015\u0012\u0006\u0010\u001b\u001a\u00020\u0018¢\u0006\u0004\b\u001c\u0010\u001dJ\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u001b\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0007H\u0002¢\u0006\u0004\b\t\u0010\nJ\u001b\u0010\t\u001a\u0004\u0018\u00010\f2\b\u0010\u0003\u001a\u0004\u0018\u00010\u000bH\u0002¢\u0006\u0004\b\t\u0010\rJ\u001b\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0003\u001a\u0004\u0018\u00010\u000eH\u0002¢\u0006\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0013\u001a\u00020\u00128\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0017\u001a\u00020\u00158\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0016R\u0014\u0010\u0010\u001a\u00020\u00188\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\u0019"}, d2 = {"Lid/dana/mapper/HomeInfoMapper;", "", "Lid/dana/domain/homeinfo/HomeInfoResponse;", "p0", "Lid/dana/model/HomeInfo;", "KClassImpl$Data$declaredNonStaticMembers$2", "(Lid/dana/domain/homeinfo/HomeInfoResponse;)Lid/dana/model/HomeInfo;", "Lid/dana/domain/homeinfo/KycResponse;", "Lid/dana/model/KycInfo;", "MyBillsEntityDataFactory", "(Lid/dana/domain/homeinfo/KycResponse;)Lid/dana/model/KycInfo;", "Lid/dana/domain/homeinfo/ProcessingTransactionResponse;", "Lid/dana/model/ProcessingTransaction;", "(Lid/dana/domain/homeinfo/ProcessingTransactionResponse;)Lid/dana/model/ProcessingTransaction;", "Lid/dana/domain/homeinfo/SurveyInfoResponse;", "Lid/dana/model/SurveyInfo;", "PlaceComponentResult", "(Lid/dana/domain/homeinfo/SurveyInfoResponse;)Lid/dana/model/SurveyInfo;", "Lid/dana/base/BaseResponseMapper;", "BuiltInFictitiousFunctionClassFactory", "Lid/dana/base/BaseResponseMapper;", "Lid/dana/sendmoney/mapper/CurrencyAmountModelMapper;", "Lid/dana/sendmoney/mapper/CurrencyAmountModelMapper;", "getAuthRequestContext", "Lid/dana/mapper/ThirdPartyServicesMapper;", "Lid/dana/mapper/ThirdPartyServicesMapper;", "p1", "p2", "<init>", "(Lid/dana/base/BaseResponseMapper;Lid/dana/sendmoney/mapper/CurrencyAmountModelMapper;Lid/dana/mapper/ThirdPartyServicesMapper;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class HomeInfoMapper {
    private final BaseResponseMapper BuiltInFictitiousFunctionClassFactory;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    private final CurrencyAmountModelMapper getAuthRequestContext;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private final ThirdPartyServicesMapper PlaceComponentResult;

    @Inject
    public HomeInfoMapper(BaseResponseMapper baseResponseMapper, CurrencyAmountModelMapper currencyAmountModelMapper, ThirdPartyServicesMapper thirdPartyServicesMapper) {
        Intrinsics.checkNotNullParameter(baseResponseMapper, "");
        Intrinsics.checkNotNullParameter(currencyAmountModelMapper, "");
        Intrinsics.checkNotNullParameter(thirdPartyServicesMapper, "");
        this.BuiltInFictitiousFunctionClassFactory = baseResponseMapper;
        this.getAuthRequestContext = currencyAmountModelMapper;
        this.PlaceComponentResult = thirdPartyServicesMapper;
    }

    public final HomeInfo KClassImpl$Data$declaredNonStaticMembers$2(HomeInfoResponse p0) {
        if (p0 != null) {
            HomeInfo homeInfo = new HomeInfo();
            BaseResponseMapper.MyBillsEntityDataFactory(homeInfo, p0);
            homeInfo.MyBillsEntityDataFactory = p0.getMobileNo();
            homeInfo.KClassImpl$Data$declaredNonStaticMembers$2 = this.getAuthRequestContext.apply(p0.getBalance());
            homeInfo.BuiltInFictitiousFunctionClassFactory = p0.getAvatarUrl();
            homeInfo.PlaceComponentResult = p0.getNickname();
            homeInfo.NetworkUserEntityData$$ExternalSyntheticLambda0 = MyBillsEntityDataFactory(p0.getProcessingTrans());
            homeInfo.moveToNextValue = (List) this.PlaceComponentResult.apply(p0.getThirdPartyLinks());
            homeInfo.getAuthRequestContext = MyBillsEntityDataFactory(p0.getKyc());
            homeInfo.scheduleImpl = PlaceComponentResult(p0.getSurveyInfo());
            return homeInfo;
        }
        return null;
    }

    private static ProcessingTransaction MyBillsEntityDataFactory(ProcessingTransactionResponse p0) {
        if (p0 != null) {
            ProcessingTransaction processingTransaction = new ProcessingTransaction();
            processingTransaction.BuiltInFictitiousFunctionClassFactory = p0.getCount();
            processingTransaction.KClassImpl$Data$declaredNonStaticMembers$2 = p0.isHasMore();
            return processingTransaction;
        }
        return null;
    }

    private static KycInfo MyBillsEntityDataFactory(KycResponse p0) {
        if (p0 != null) {
            KycInfo kycInfo = new KycInfo();
            kycInfo.PlaceComponentResult = p0.getLevel();
            kycInfo.getAuthRequestContext = p0.getOrderStatus();
            kycInfo.KClassImpl$Data$declaredNonStaticMembers$2 = p0.isGovFlag();
            kycInfo.MyBillsEntityDataFactory = p0.getTncUrl();
            kycInfo.BuiltInFictitiousFunctionClassFactory = p0.isUserQuits();
            return kycInfo;
        }
        return null;
    }

    private static SurveyInfo PlaceComponentResult(SurveyInfoResponse p0) {
        if (p0 != null) {
            SurveyInfo surveyInfo = new SurveyInfo();
            surveyInfo.KClassImpl$Data$declaredNonStaticMembers$2 = p0.isHasActiveSurvey();
            surveyInfo.PlaceComponentResult = p0.getInnerUrl();
            return surveyInfo;
        }
        return null;
    }
}
