package id.dana.cashier.model;

import id.dana.cashier.domain.model.paylater.DanaCredit;
import id.dana.cashier.domain.model.paylater.QueryInstallment;
import id.dana.cashier.domain.model.paylater.RepaymentPlan;
import id.dana.data.util.NumberUtils;
import id.dana.domain.useragreement.model.ConsultAgreementResponse;
import id.dana.nearbyme.merchantdetail.model.MoneyViewModel;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\u001a\u0013\u0010\u0002\u001a\u00020\u0001*\u0004\u0018\u00010\u0000¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u0013\u0010\u0004\u001a\u00020\u0001*\u0004\u0018\u00010\u0000¢\u0006\u0004\b\u0004\u0010\u0003\u001a\u0013\u0010\u0005\u001a\u00020\u0001*\u0004\u0018\u00010\u0000¢\u0006\u0004\b\u0005\u0010\u0003\u001a\u0013\u0010\u0006\u001a\u00020\u0001*\u0004\u0018\u00010\u0000¢\u0006\u0004\b\u0006\u0010\u0003\u001a\u0011\u0010\u0006\u001a\u00020\u0000*\u00020\u0007¢\u0006\u0004\b\u0006\u0010\b"}, d2 = {"Lid/dana/cashier/model/QueryInstallmentModel;", "", "PlaceComponentResult", "(Lid/dana/cashier/model/QueryInstallmentModel;)Z", "BuiltInFictitiousFunctionClassFactory", "KClassImpl$Data$declaredNonStaticMembers$2", "MyBillsEntityDataFactory", "Lid/dana/cashier/domain/model/paylater/QueryInstallment;", "(Lid/dana/cashier/domain/model/paylater/QueryInstallment;)Lid/dana/cashier/model/QueryInstallmentModel;"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class QueryInstallmentModelKt {
    public static final QueryInstallmentModel MyBillsEntityDataFactory(QueryInstallment queryInstallment) {
        Intrinsics.checkNotNullParameter(queryInstallment, "");
        DanaCredit danaCredit = queryInstallment.getDanaCredit();
        DanaCreditModel PlaceComponentResult = danaCredit != null ? DanaCreditModelKt.PlaceComponentResult(danaCredit) : null;
        String loanAgreementUrl = queryInstallment.getLoanAgreementUrl();
        String str = loanAgreementUrl == null ? "" : loanAgreementUrl;
        List<RepaymentPlan> repaymentPlans = queryInstallment.getRepaymentPlans();
        List<RepaymentPlanModel> authRequestContext = repaymentPlans != null ? RepaymentPlanModelKt.getAuthRequestContext(repaymentPlans) : null;
        if (authRequestContext == null) {
            authRequestContext = CollectionsKt.emptyList();
        }
        List<RepaymentPlanModel> list = authRequestContext;
        Boolean isPaylaterAgreementEnable = queryInstallment.isPaylaterAgreementEnable();
        boolean booleanValue = isPaylaterAgreementEnable != null ? isPaylaterAgreementEnable.booleanValue() : false;
        ConsultAgreementResponse consultAgreement = queryInstallment.getConsultAgreement();
        return new QueryInstallmentModel(PlaceComponentResult, str, list, booleanValue, consultAgreement != null ? ConsultAgreementModelKt.BuiltInFictitiousFunctionClassFactory(consultAgreement) : null, queryInstallment.getEnableStatus(), queryInstallment.getDisableReason(), queryInstallment.getSuccess());
    }

    public static final boolean PlaceComponentResult(QueryInstallmentModel queryInstallmentModel) {
        ConsultAgreementModel consultAgreementModel;
        if ((queryInstallmentModel == null || (consultAgreementModel = queryInstallmentModel.PlaceComponentResult) == null || consultAgreementModel.getMyBillsEntityDataFactory()) ? false : true) {
            return queryInstallmentModel.NetworkUserEntityData$$ExternalSyntheticLambda0.length() > 0;
        }
        return false;
    }

    public static final boolean BuiltInFictitiousFunctionClassFactory(QueryInstallmentModel queryInstallmentModel) {
        ConsultAgreementModel consultAgreementModel;
        if ((queryInstallmentModel == null || (consultAgreementModel = queryInstallmentModel.PlaceComponentResult) == null || !consultAgreementModel.getMyBillsEntityDataFactory()) ? false : true) {
            return queryInstallmentModel.NetworkUserEntityData$$ExternalSyntheticLambda0.length() > 0;
        }
        return false;
    }

    public static final boolean KClassImpl$Data$declaredNonStaticMembers$2(QueryInstallmentModel queryInstallmentModel) {
        List<RepaymentPlanModel> list;
        Object obj;
        String str;
        Object obj2 = null;
        if (queryInstallmentModel != null && (list = queryInstallmentModel.moveToNextValue) != null) {
            Iterator<T> it = list.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Object next = it.next();
                Iterator<T> it2 = ((RepaymentPlanModel) next).MyBillsEntityDataFactory.iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        obj = null;
                        break;
                    }
                    obj = it2.next();
                    MoneyViewModel moneyViewModel = ((RepaymentInfoModel) obj).BuiltInFictitiousFunctionClassFactory;
                    if (moneyViewModel != null) {
                        str = NumberUtils.getCleanAll(moneyViewModel.PlaceComponentResult);
                        if (str == null) {
                            str = "0";
                        }
                    } else {
                        str = null;
                    }
                    if (Intrinsics.areEqual(str, "0")) {
                        break;
                    }
                }
                if (obj != null) {
                    obj2 = next;
                    break;
                }
            }
            obj2 = (RepaymentPlanModel) obj2;
        }
        return obj2 != null;
    }

    public static final boolean MyBillsEntityDataFactory(QueryInstallmentModel queryInstallmentModel) {
        ConsultAgreementModel consultAgreementModel;
        if ((queryInstallmentModel == null || (consultAgreementModel = queryInstallmentModel.PlaceComponentResult) == null || !consultAgreementModel.getMyBillsEntityDataFactory()) ? false : true) {
            return queryInstallmentModel.NetworkUserEntityData$$ExternalSyntheticLambda0.length() == 0;
        }
        return false;
    }
}
