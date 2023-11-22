package id.dana.sendmoney.summary.state.model;

import id.dana.model.CurrencyAmountModel;
import id.dana.model.PayMethodModel;
import id.dana.sendmoney.model.RecipientModel;
import id.dana.sendmoney.model.VoucherModel;
import id.dana.sendmoney.model.WithdrawOTCModel;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u0001BM\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0017\u001a\u00020\f\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u000f\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0011¢\u0006\u0004\b\u001a\u0010\u001bR\u0014\u0010\u0005\u001a\u0004\u0018\u00010\u0002X\u0086\u0002¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0003\u001a\u0004\u0018\u00010\u0006X\u0086\u0002¢\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0014\u0010\n\u001a\u0004\u0018\u00010\tX\u0086\u0002¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0012\u0010\r\u001a\u00020\fX\u0086\u0002¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0014\u0010\u0007\u001a\u0004\u0018\u00010\u000fX\u0086\u0002¢\u0006\u0006\n\u0004\b\u0005\u0010\u0010R\u0014\u0010\u0012\u001a\u0004\u0018\u00010\u0011X\u0086\u0002¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013"}, d2 = {"Lid/dana/sendmoney/summary/state/model/SummaryValidateModel;", "", "Lid/dana/model/CurrencyAmountModel;", "BuiltInFictitiousFunctionClassFactory", "Lid/dana/model/CurrencyAmountModel;", "getAuthRequestContext", "Lid/dana/model/PayMethodModel;", "KClassImpl$Data$declaredNonStaticMembers$2", "Lid/dana/model/PayMethodModel;", "Lid/dana/sendmoney/model/RecipientModel;", "MyBillsEntityDataFactory", "Lid/dana/sendmoney/model/RecipientModel;", "", "PlaceComponentResult", "Ljava/lang/String;", "Lid/dana/sendmoney/model/VoucherModel;", "Lid/dana/sendmoney/model/VoucherModel;", "Lid/dana/sendmoney/model/WithdrawOTCModel;", "moveToNextValue", "Lid/dana/sendmoney/model/WithdrawOTCModel;", "p0", "p1", "p2", "p3", "p4", "p5", "<init>", "(Lid/dana/sendmoney/model/RecipientModel;Lid/dana/model/CurrencyAmountModel;Lid/dana/model/PayMethodModel;Ljava/lang/String;Lid/dana/sendmoney/model/VoucherModel;Lid/dana/sendmoney/model/WithdrawOTCModel;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class SummaryValidateModel {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    public CurrencyAmountModel getAuthRequestContext;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    public PayMethodModel BuiltInFictitiousFunctionClassFactory;
    public RecipientModel MyBillsEntityDataFactory;
    public String PlaceComponentResult;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    public VoucherModel KClassImpl$Data$declaredNonStaticMembers$2;
    public WithdrawOTCModel moveToNextValue;

    public SummaryValidateModel() {
        this(null, null, null, null, null, null, 63, null);
    }

    public SummaryValidateModel(RecipientModel recipientModel, CurrencyAmountModel currencyAmountModel, PayMethodModel payMethodModel, String str, VoucherModel voucherModel, WithdrawOTCModel withdrawOTCModel) {
        Intrinsics.checkNotNullParameter(str, "");
        this.MyBillsEntityDataFactory = recipientModel;
        this.getAuthRequestContext = currencyAmountModel;
        this.BuiltInFictitiousFunctionClassFactory = payMethodModel;
        this.PlaceComponentResult = str;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = voucherModel;
        this.moveToNextValue = withdrawOTCModel;
    }

    public /* synthetic */ SummaryValidateModel(RecipientModel recipientModel, CurrencyAmountModel currencyAmountModel, PayMethodModel payMethodModel, String str, VoucherModel voucherModel, WithdrawOTCModel withdrawOTCModel, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : recipientModel, (i & 2) != 0 ? null : currencyAmountModel, (i & 4) != 0 ? null : payMethodModel, (i & 8) != 0 ? "" : str, (i & 16) != 0 ? null : voucherModel, (i & 32) != 0 ? null : withdrawOTCModel);
    }
}
