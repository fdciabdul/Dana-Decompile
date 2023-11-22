package id.dana.cashier;

import android.os.Bundle;
import com.alibaba.ariver.kernel.RVEvents;
import id.dana.base.AbstractContractKt;
import id.dana.cashier.CashierCardBindingContract;
import id.dana.cashier.CashierContract;
import id.dana.cashier.CashierRiskChallengeContract;
import id.dana.cashier.TopUpAndPayContract;
import id.dana.cashier.helper.CashierErrorState;
import id.dana.cashier.model.AttributeModel;
import id.dana.cashier.model.CashierAgreementModel;
import id.dana.cashier.model.CashierCheckoutModel;
import id.dana.cashier.model.CashierMerchantModel;
import id.dana.cashier.model.CashierPayMethodModel;
import id.dana.cashier.model.CashierPayModel;
import id.dana.cashier.model.QueryCardPolicyInfoModel;
import id.dana.cashier.model.QueryPromotionModel;
import id.dana.cashier.model.TopUpConsultModel;
import id.dana.cashier.model.TopUpPayModel;
import id.dana.cashier.model.VoucherCashierModel;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0094\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\b\u0016\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004B\u0007¢\u0006\u0004\bC\u0010\u0007J\u000f\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\b\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\b\u0010\u0007J\u000f\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\f\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\f\u0010\u0007J\u001d\u0010\u0010\u001a\u00020\u00052\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u0019\u0010\u0012\u001a\u00020\u00052\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u0019\u0010\u0014\u001a\u00020\u00052\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016¢\u0006\u0004\b\u0014\u0010\u0013J\u0019\u0010\n\u001a\u00020\u00052\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016¢\u0006\u0004\b\n\u0010\u0013J\u000f\u0010\u0010\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0010\u0010\u0007J\u000f\u0010\u0015\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0015\u0010\u0007J\u0017\u0010\f\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u0016H\u0016¢\u0006\u0004\b\f\u0010\u0017J\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u0016H\u0016¢\u0006\u0004\b\u0006\u0010\u0017J\u0017\u0010\u0018\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u0016H\u0016¢\u0006\u0004\b\u0018\u0010\u0017J\u0019\u0010\u0006\u001a\u00020\u00052\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016¢\u0006\u0004\b\u0006\u0010\u0013J\u0017\u0010\n\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u0016H\u0016¢\u0006\u0004\b\n\u0010\u0017J\u0017\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u0016H\u0016¢\u0006\u0004\b\u0010\u0010\u0017J\u0019\u0010\u0015\u001a\u00020\u00052\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016¢\u0006\u0004\b\u0015\u0010\u0013J#\u0010\u001a\u001a\u00020\u00052\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0019\u001a\u0004\u0018\u00010\u000eH\u0016¢\u0006\u0004\b\u001a\u0010\u0013J\u0017\u0010\u001a\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u0016H\u0016¢\u0006\u0004\b\u001a\u0010\u0017J\u0017\u0010\u001b\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u0016H\u0016¢\u0006\u0004\b\u001b\u0010\u0017J)\u0010\f\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u000e2\b\u0010\u0019\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u001c\u001a\u00020\tH\u0016¢\u0006\u0004\b\f\u0010\u001dJ\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u001eH\u0016¢\u0006\u0004\b\u0006\u0010\u001fJ\u0017\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020 H\u0016¢\u0006\u0004\b\u0010\u0010!J\u0017\u0010\u0018\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0018\u0010\u0013J\u000f\u0010\u0012\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0012\u0010\u0007J'\u0010\f\u001a\u00020\u00052\b\u0010\u000f\u001a\u0004\u0018\u00010\"2\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\"0\rH\u0016¢\u0006\u0004\b\f\u0010#J\u000f\u0010\u001a\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u001a\u0010\u0007J\u0017\u0010\u0018\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020$H\u0016¢\u0006\u0004\b\u0018\u0010%J\u0017\u0010\u0018\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\tH\u0016¢\u0006\u0004\b\u0018\u0010&J\u000f\u0010\u0018\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0018\u0010\u0007J\u000f\u0010'\u001a\u00020\u0005H\u0016¢\u0006\u0004\b'\u0010\u0007J\u0017\u0010\n\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020(H\u0016¢\u0006\u0004\b\n\u0010)J\u0017\u0010\f\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\f\u0010\u0013J\u0017\u0010\f\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020*H\u0016¢\u0006\u0004\b\f\u0010+J\u0017\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020*H\u0016¢\u0006\u0004\b\u0010\u0010+J\u000f\u0010\u001b\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u001b\u0010\u0007J\u0017\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0010\u0010\u0013J/\u0010\f\u001a\u00020\u00052\u000e\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020,\u0018\u00010\r2\u0006\u0010\u0019\u001a\u00020\t2\u0006\u0010\u001c\u001a\u00020\tH\u0016¢\u0006\u0004\b\f\u0010-J\u0017\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020.H\u0016¢\u0006\u0004\b\u0010\u0010/J\u0017\u0010\u0018\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u000200H\u0016¢\u0006\u0004\b\u0018\u00101J'\u0010\f\u001a\u00020\u00052\u000e\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020,\u0018\u00010\r2\u0006\u0010\u0019\u001a\u000202H\u0016¢\u0006\u0004\b\f\u00103J\u0017\u0010\n\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u000204H\u0016¢\u0006\u0004\b\n\u00105J\u0017\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u000204H\u0016¢\u0006\u0004\b\u0010\u00105J\u001f\u0010\n\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u0002062\u0006\u0010\u0019\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\n\u00107J!\u0010\f\u001a\u00020\u00052\b\u0010\u000f\u001a\u0004\u0018\u00010\"2\u0006\u0010\u0019\u001a\u00020\tH\u0016¢\u0006\u0004\b\f\u00108J7\u0010\f\u001a\u00020\u00052\b\u0010\u000f\u001a\u0004\u0018\u0001092\u0006\u0010\u0019\u001a\u00020\t2\u0006\u0010\u001c\u001a\u00020\u000e2\f\u0010:\u001a\b\u0012\u0004\u0012\u00020,0\rH\u0016¢\u0006\u0004\b\f\u0010;J'\u0010\n\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020<2\u0006\u0010\u0019\u001a\u00020<2\u0006\u0010\u001c\u001a\u00020<H\u0016¢\u0006\u0004\b\n\u0010=J\u001f\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u0002042\u0006\u0010\u0019\u001a\u00020<H\u0016¢\u0006\u0004\b\u0006\u00105J'\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0019\u001a\u00020\u000e2\u0006\u0010\u001c\u001a\u00020 H\u0016¢\u0006\u0004\b\u0010\u0010>J'\u0010\f\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020<2\u0006\u0010\u0019\u001a\u00020<2\u0006\u0010\u001c\u001a\u00020<H\u0016¢\u0006\u0004\b\f\u0010=J\u000f\u0010?\u001a\u00020\u0005H\u0016¢\u0006\u0004\b?\u0010\u0007J\u000f\u0010@\u001a\u00020\u0005H\u0016¢\u0006\u0004\b@\u0010\u0007J\u000f\u0010A\u001a\u00020\u0005H\u0016¢\u0006\u0004\bA\u0010\u0007J\u000f\u0010B\u001a\u00020\u0005H\u0016¢\u0006\u0004\bB\u0010\u0007"}, d2 = {"Lid/dana/cashier/CashierViewListener;", "Lid/dana/cashier/CashierContract$View;", "Lid/dana/cashier/CashierRiskChallengeContract$View;", "Lid/dana/cashier/TopUpAndPayContract$View;", "Lid/dana/cashier/CashierCardBindingContract$View;", "", "BuiltInFictitiousFunctionClassFactory", "()V", "dismissProgress", "", "KClassImpl$Data$declaredNonStaticMembers$2", "()Z", "getAuthRequestContext", "", "", "p0", "MyBillsEntityDataFactory", "(Ljava/util/List;)V", "NetworkUserEntityData$$ExternalSyntheticLambda0", "(Ljava/lang/String;)V", RVEvents.EMBED_WEBVIEW_LOAD_ERROR_EVENT, "scheduleImpl", "Lid/dana/cashier/helper/CashierErrorState;", "(Lid/dana/cashier/helper/CashierErrorState;)V", "PlaceComponentResult", "p1", "lookAheadTest", "getErrorConfigVersion", "p2", "(Ljava/lang/String;Ljava/lang/String;Z)V", "Lid/dana/cashier/model/CashierMerchantModel;", "(Lid/dana/cashier/model/CashierMerchantModel;)V", "", "(Ljava/lang/Throwable;)V", "Lid/dana/cashier/model/VoucherCashierModel;", "(Lid/dana/cashier/model/VoucherCashierModel;Ljava/util/List;)V", "Landroid/os/Bundle;", "(Landroid/os/Bundle;)V", "(Z)V", "moveToNextValue", "Lid/dana/cashier/model/CashierAgreementModel;", "(Lid/dana/cashier/model/CashierAgreementModel;)V", "Lid/dana/cashier/model/TopUpPayModel;", "(Lid/dana/cashier/model/TopUpPayModel;)V", "Lid/dana/cashier/model/CashierPayMethodModel;", "(Ljava/util/List;ZZ)V", "Lid/dana/cashier/model/CashierCheckoutModel;", "(Lid/dana/cashier/model/CashierCheckoutModel;)V", "Lid/dana/cashier/model/QueryPromotionModel;", "(Lid/dana/cashier/model/QueryPromotionModel;)V", "Lid/dana/cashier/model/TopUpConsultModel;", "(Ljava/util/List;Lid/dana/cashier/model/TopUpConsultModel;)V", "Lid/dana/cashier/model/CashierPayModel;", "(Lid/dana/cashier/model/CashierPayModel;)V", "Lid/dana/cashier/model/QueryCardPolicyInfoModel;", "(Lid/dana/cashier/model/QueryCardPolicyInfoModel;Ljava/lang/String;)V", "(Lid/dana/cashier/model/VoucherCashierModel;Z)V", "Lid/dana/cashier/model/AttributeModel;", "p3", "(Lid/dana/cashier/model/AttributeModel;ZLjava/lang/String;Ljava/util/List;)V", "", "(II)V", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V", "NetworkUserEntityData$$ExternalSyntheticLambda1", "initRecordTimeStamp", "showProgress", "DatabaseTableConfigUtil", "<init>"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public class CashierViewListener implements CashierContract.View, CashierRiskChallengeContract.View, TopUpAndPayContract.View, CashierCardBindingContract.View {
    @Override // id.dana.cashier.CashierContract.View
    public void BuiltInFictitiousFunctionClassFactory() {
    }

    @Override // id.dana.cashier.CashierContract.View, id.dana.cashier.TopUpAndPayContract.View
    public void BuiltInFictitiousFunctionClassFactory(CashierErrorState p0) {
        Intrinsics.checkNotNullParameter(p0, "");
    }

    @Override // id.dana.cashier.CashierContract.View
    public void BuiltInFictitiousFunctionClassFactory(CashierMerchantModel p0) {
        Intrinsics.checkNotNullParameter(p0, "");
    }

    @Override // id.dana.cashier.TopUpAndPayContract.View
    public void BuiltInFictitiousFunctionClassFactory(CashierPayModel cashierPayModel) {
        Intrinsics.checkNotNullParameter(cashierPayModel, "");
    }

    @Override // id.dana.cashier.CashierCardBindingContract.View
    public void BuiltInFictitiousFunctionClassFactory(String p0) {
    }

    @Override // id.dana.cashier.CashierContract.View, id.dana.cashier.CashierRiskChallengeContract.View
    public void DatabaseTableConfigUtil() {
    }

    @Override // id.dana.cashier.CashierRiskChallengeContract.View
    public void KClassImpl$Data$declaredNonStaticMembers$2(int i, int i2) {
    }

    @Override // id.dana.cashier.CashierRiskChallengeContract.View
    public void KClassImpl$Data$declaredNonStaticMembers$2(CashierErrorState p0) {
        Intrinsics.checkNotNullParameter(p0, "");
    }

    @Override // id.dana.cashier.CashierRiskChallengeContract.View
    public void KClassImpl$Data$declaredNonStaticMembers$2(CashierAgreementModel p0) {
        Intrinsics.checkNotNullParameter(p0, "");
    }

    @Override // id.dana.cashier.CashierContract.View
    public void KClassImpl$Data$declaredNonStaticMembers$2(CashierPayModel p0) {
        Intrinsics.checkNotNullParameter(p0, "");
    }

    @Override // id.dana.cashier.CashierCardBindingContract.View
    public void KClassImpl$Data$declaredNonStaticMembers$2(QueryCardPolicyInfoModel p0, String p1) {
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p1, "");
    }

    @Override // id.dana.cashier.CashierCardBindingContract.View
    public final void KClassImpl$Data$declaredNonStaticMembers$2(String p0) {
    }

    @Override // id.dana.cashier.CashierContract.View, id.dana.cashier.TopUpAndPayContract.View
    public boolean KClassImpl$Data$declaredNonStaticMembers$2() {
        return false;
    }

    @Override // id.dana.cashier.CashierContract.View
    public void MyBillsEntityDataFactory() {
    }

    @Override // id.dana.cashier.CashierRiskChallengeContract.View
    public void MyBillsEntityDataFactory(CashierErrorState p0) {
        Intrinsics.checkNotNullParameter(p0, "");
    }

    @Override // id.dana.cashier.CashierContract.View
    public void MyBillsEntityDataFactory(CashierCheckoutModel p0) {
        Intrinsics.checkNotNullParameter(p0, "");
    }

    @Override // id.dana.cashier.CashierContract.View, id.dana.cashier.TopUpAndPayContract.View
    public void MyBillsEntityDataFactory(CashierPayModel p0) {
        Intrinsics.checkNotNullParameter(p0, "");
    }

    @Override // id.dana.cashier.TopUpAndPayContract.View
    public void MyBillsEntityDataFactory(TopUpPayModel p0) {
        Intrinsics.checkNotNullParameter(p0, "");
    }

    @Override // id.dana.cashier.CashierContract.View
    public void MyBillsEntityDataFactory(String p0) {
        Intrinsics.checkNotNullParameter(p0, "");
    }

    @Override // id.dana.cashier.CashierContract.View, id.dana.cashier.CashierRiskChallengeContract.View
    public void MyBillsEntityDataFactory(String p0, String p1, Throwable p2) {
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p1, "");
        Intrinsics.checkNotNullParameter(p2, "");
    }

    @Override // id.dana.cashier.CashierCardBindingContract.View
    public void MyBillsEntityDataFactory(Throwable p0) {
        Intrinsics.checkNotNullParameter(p0, "");
    }

    @Override // id.dana.cashier.CashierContract.View
    public void MyBillsEntityDataFactory(List<String> p0) {
        Intrinsics.checkNotNullParameter(p0, "");
    }

    @Override // id.dana.cashier.CashierContract.View
    public void NetworkUserEntityData$$ExternalSyntheticLambda0() {
    }

    @Override // id.dana.cashier.CashierRiskChallengeContract.View
    public void NetworkUserEntityData$$ExternalSyntheticLambda0(String p0) {
    }

    @Override // id.dana.cashier.CashierRiskChallengeContract.View
    public void NetworkUserEntityData$$ExternalSyntheticLambda1() {
    }

    @Override // id.dana.cashier.CashierCardBindingContract.View
    public final void PlaceComponentResult() {
    }

    @Override // id.dana.cashier.CashierRiskChallengeContract.View
    public void PlaceComponentResult(Bundle p0) {
        Intrinsics.checkNotNullParameter(p0, "");
    }

    @Override // id.dana.cashier.CashierContract.View
    public void PlaceComponentResult(CashierErrorState p0) {
        Intrinsics.checkNotNullParameter(p0, "");
    }

    @Override // id.dana.cashier.CashierContract.View
    public void PlaceComponentResult(QueryPromotionModel p0) {
        Intrinsics.checkNotNullParameter(p0, "");
    }

    @Override // id.dana.cashier.CashierCardBindingContract.View
    public void PlaceComponentResult(String p0) {
        Intrinsics.checkNotNullParameter(p0, "");
    }

    @Override // id.dana.cashier.CashierContract.View
    public void PlaceComponentResult(boolean p0) {
    }

    @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
    public void dismissProgress() {
    }

    @Override // id.dana.cashier.CashierContract.View, id.dana.cashier.TopUpAndPayContract.View
    public void getAuthRequestContext() {
    }

    @Override // id.dana.cashier.CashierRiskChallengeContract.View
    public void getAuthRequestContext(int i, int i2) {
    }

    @Override // id.dana.cashier.CashierContract.View
    public void getAuthRequestContext(CashierErrorState p0) {
        Intrinsics.checkNotNullParameter(p0, "");
    }

    @Override // id.dana.cashier.CashierContract.View
    public void getAuthRequestContext(AttributeModel p0, boolean p1, String p2, List<? extends CashierPayMethodModel> p3) {
        Intrinsics.checkNotNullParameter(p2, "");
        Intrinsics.checkNotNullParameter(p3, "");
    }

    @Override // id.dana.cashier.TopUpAndPayContract.View
    public void getAuthRequestContext(TopUpPayModel p0) {
        Intrinsics.checkNotNullParameter(p0, "");
    }

    @Override // id.dana.cashier.CashierContract.View
    public void getAuthRequestContext(VoucherCashierModel p0, List<VoucherCashierModel> p1) {
        Intrinsics.checkNotNullParameter(p1, "");
    }

    @Override // id.dana.cashier.CashierContract.View
    public void getAuthRequestContext(VoucherCashierModel p0, boolean p1) {
    }

    @Override // id.dana.cashier.CashierContract.View
    public void getAuthRequestContext(String p0) {
        Intrinsics.checkNotNullParameter(p0, "");
    }

    @Override // id.dana.cashier.CashierContract.View
    public void getAuthRequestContext(String p0, String p1, boolean p2) {
        Intrinsics.checkNotNullParameter(p0, "");
    }

    @Override // id.dana.cashier.TopUpAndPayContract.View
    public void getAuthRequestContext(List<? extends CashierPayMethodModel> p0, TopUpConsultModel p1) {
        Intrinsics.checkNotNullParameter(p1, "");
    }

    @Override // id.dana.cashier.CashierContract.View
    public void getAuthRequestContext(List<? extends CashierPayMethodModel> p0, boolean p1, boolean p2) {
    }

    @Override // id.dana.cashier.CashierContract.View, id.dana.cashier.TopUpAndPayContract.View
    public void getErrorConfigVersion() {
    }

    @Override // id.dana.cashier.CashierRiskChallengeContract.View
    public void getErrorConfigVersion(CashierErrorState p0) {
        Intrinsics.checkNotNullParameter(p0, "");
    }

    @Override // id.dana.base.AbstractContractKt.AbstractView
    public /* synthetic */ String getErrorSource() {
        return AbstractContractKt.AbstractView.CC.getAuthRequestContext();
    }

    @Override // id.dana.cashier.CashierRiskChallengeContract.View
    public void initRecordTimeStamp() {
    }

    @Override // id.dana.cashier.CashierContract.View
    public void lookAheadTest() {
    }

    @Override // id.dana.cashier.TopUpAndPayContract.View
    public void lookAheadTest(CashierErrorState p0) {
        Intrinsics.checkNotNullParameter(p0, "");
    }

    @Override // id.dana.cashier.TopUpAndPayContract.View
    public void lookAheadTest(String str) {
    }

    @Override // id.dana.cashier.CashierContract.View
    public void moveToNextValue() {
    }

    @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
    public void onError(String p0) {
    }

    @Override // id.dana.cashier.CashierContract.View, id.dana.cashier.TopUpAndPayContract.View
    public void scheduleImpl() {
    }

    @Override // id.dana.cashier.TopUpAndPayContract.View
    public void scheduleImpl(String p0) {
    }

    @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
    public void showProgress() {
    }
}
