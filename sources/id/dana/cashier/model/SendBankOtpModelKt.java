package id.dana.cashier.model;

import id.dana.domain.otp.model.SendBankOtpRequest;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0019\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lid/dana/cashier/model/SendBankOtpModel;", "", "p0", "Lid/dana/domain/otp/model/SendBankOtpRequest;", "MyBillsEntityDataFactory", "(Lid/dana/cashier/model/SendBankOtpModel;Z)Lid/dana/domain/otp/model/SendBankOtpRequest;"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class SendBankOtpModelKt {
    public static final SendBankOtpRequest MyBillsEntityDataFactory(SendBankOtpModel sendBankOtpModel, boolean z) {
        Intrinsics.checkNotNullParameter(sendBankOtpModel, "");
        String str = sendBankOtpModel.getErrorConfigVersion;
        String str2 = sendBankOtpModel.moveToNextValue;
        String str3 = sendBankOtpModel.KClassImpl$Data$declaredNonStaticMembers$2;
        String str4 = sendBankOtpModel.getAuthRequestContext;
        String str5 = sendBankOtpModel.initRecordTimeStamp;
        String str6 = sendBankOtpModel.lookAheadTest;
        String str7 = sendBankOtpModel.NetworkUserEntityData$$ExternalSyntheticLambda0;
        String str8 = sendBankOtpModel.GetContactSyncConfig;
        String str9 = sendBankOtpModel.MyBillsEntityDataFactory;
        String str10 = str9 == null ? "" : str9;
        String str11 = sendBankOtpModel.PlaceComponentResult;
        return new SendBankOtpRequest(z, str, str2, str3, str4, str5, str6, str7, str8, str10, str11 == null ? "" : str11, sendBankOtpModel.NetworkUserEntityData$$ExternalSyntheticLambda2, sendBankOtpModel.DatabaseTableConfigUtil, sendBankOtpModel.scheduleImpl, sendBankOtpModel.BuiltInFictitiousFunctionClassFactory);
    }
}
