package id.dana.cashier.model;

import com.alibaba.griver.image.photo.utils.DiskFormatter;
import id.dana.cashier.helper.CashierPayMethodModelExt;
import id.dana.cashier.model.CashierPayMethodModel;
import id.dana.domain.payasset.model.Institution;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u001f\u001a\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0004*\u00020\u0000¢\u0006\u0004\b\u0005\u0010\u0006\u001a\u0013\u0010\b\u001a\u0004\u0018\u00010\u0007*\u00020\u0000¢\u0006\u0004\b\b\u0010\t\u001a\u0013\u0010\u000b\u001a\u0004\u0018\u00010\n*\u00020\u0000¢\u0006\u0004\b\u000b\u0010\f\u001a\u0013\u0010\u000e\u001a\u0004\u0018\u00010\r*\u00020\u0000¢\u0006\u0004\b\u000e\u0010\u000f\u001a\u0013\u0010\u0011\u001a\u0004\u0018\u00010\u0010*\u00020\u0000¢\u0006\u0004\b\u0011\u0010\u0012\u001a\u0013\u0010\u0014\u001a\u0004\u0018\u00010\u0013*\u00020\u0000¢\u0006\u0004\b\u0014\u0010\u0015\u001a\u001f\u0010\u000e\u001a\u00020\u0019*\b\u0012\u0004\u0012\u00020\u00000\u00162\u0006\u0010\u0018\u001a\u00020\u0017¢\u0006\u0004\b\u000e\u0010\u001a\u001a\u0013\u0010\u001c\u001a\u0004\u0018\u00010\u001b*\u00020\u0000¢\u0006\u0004\b\u001c\u0010\u001d\u001a\u0013\u0010\u001f\u001a\u0004\u0018\u00010\u001e*\u00020\u0000¢\u0006\u0004\b\u001f\u0010 \u001a\u0017\u0010\u0005\u001a\u00020\u0019*\b\u0012\u0004\u0012\u00020\u00000\u0016¢\u0006\u0004\b\u0005\u0010!\u001a\u0011\u0010\"\u001a\u00020\u0019*\u00020\u0000¢\u0006\u0004\b\"\u0010#\u001a\u0011\u0010$\u001a\u00020\u0019*\u00020\u0000¢\u0006\u0004\b$\u0010#\u001a\u0011\u0010%\u001a\u00020\u0019*\u00020\u0000¢\u0006\u0004\b%\u0010#\u001a\u0017\u0010\u0002\u001a\u00020\u0019*\b\u0012\u0004\u0012\u00020\u00000\u0016¢\u0006\u0004\b\u0002\u0010!\u001a\u0019\u0010\b\u001a\u0004\u0018\u00010\u0019*\b\u0012\u0004\u0012\u00020\u00000\u0016¢\u0006\u0004\b\b\u0010&\u001a\u0011\u0010'\u001a\u00020\u0019*\u00020\u0000¢\u0006\u0004\b'\u0010#\u001a\u0011\u0010(\u001a\u00020\u0019*\u00020\u0000¢\u0006\u0004\b(\u0010#\u001a\u0011\u0010)\u001a\u00020\u0019*\u00020\u0000¢\u0006\u0004\b)\u0010#\u001a\u0011\u0010*\u001a\u00020\u0019*\u00020\u0000¢\u0006\u0004\b*\u0010#\u001a\u0011\u0010+\u001a\u00020\u0019*\u00020\u0000¢\u0006\u0004\b+\u0010#\u001a\u0011\u0010,\u001a\u00020\u0019*\u00020\u0000¢\u0006\u0004\b,\u0010#\u001a\u0013\u0010-\u001a\u00020\u0019*\u0004\u0018\u00010\u0000¢\u0006\u0004\b-\u0010#\u001a\u0011\u0010.\u001a\u00020\u0019*\u00020\u0000¢\u0006\u0004\b.\u0010#\u001a\u0011\u0010/\u001a\u00020\u0019*\u00020\u0000¢\u0006\u0004\b/\u0010#\u001a\u0019\u0010\u0005\u001a\u00020\u0019*\u00020\u00002\u0006\u0010\u0018\u001a\u00020\u0017¢\u0006\u0004\b\u0005\u00100\u001a\u0019\u0010\u000e\u001a\u00020\u0019*\u00020\u00002\u0006\u0010\u0018\u001a\u00020\u0017¢\u0006\u0004\b\u000e\u00100\u001a\u0011\u00101\u001a\u00020\u0019*\u00020\u0000¢\u0006\u0004\b1\u0010#\u001a\u0011\u00102\u001a\u00020\u0019*\u00020\u0000¢\u0006\u0004\b2\u0010#\u001a\u0011\u00103\u001a\u00020\u0019*\u00020\u0000¢\u0006\u0004\b3\u0010#\u001a\u0013\u00104\u001a\u00020\u0019*\u0004\u0018\u00010\u0000¢\u0006\u0004\b4\u0010#\u001a\u0011\u00105\u001a\u00020\u0019*\u00020\u0000¢\u0006\u0004\b5\u0010#\u001a\u0011\u00106\u001a\u00020\u0019*\u00020\u0000¢\u0006\u0004\b6\u0010#\u001a\u0011\u00107\u001a\u00020\u0019*\u00020\u0000¢\u0006\u0004\b7\u0010#\u001a\u0011\u00108\u001a\u00020\u0019*\u00020\u0000¢\u0006\u0004\b8\u0010#\u001a\u0011\u00109\u001a\u00020\u0019*\u00020\u0000¢\u0006\u0004\b9\u0010#\u001a\u0011\u0010:\u001a\u00020\u0019*\u00020\u0000¢\u0006\u0004\b:\u0010#\u001a\u0015\u0010;\u001a\u0004\u0018\u00010\u0019*\u0004\u0018\u00010\u0000¢\u0006\u0004\b;\u0010<\u001a\u0011\u0010=\u001a\u00020\u0019*\u00020\u0000¢\u0006\u0004\b=\u0010#"}, d2 = {"Lid/dana/cashier/model/CashierPayMethodModel;", "Lid/dana/cashier/model/CashierPayMethodModel$BalancePayMethod;", "KClassImpl$Data$declaredNonStaticMembers$2", "(Lid/dana/cashier/model/CashierPayMethodModel;)Lid/dana/cashier/model/CashierPayMethodModel$BalancePayMethod;", "Lid/dana/cashier/model/CashierPayMethodModel$CardPayMethod;", "MyBillsEntityDataFactory", "(Lid/dana/cashier/model/CashierPayMethodModel;)Lid/dana/cashier/model/CashierPayMethodModel$CardPayMethod;", "Lid/dana/cashier/model/CashierPayMethodModel$DanaPlusPayMethod;", "BuiltInFictitiousFunctionClassFactory", "(Lid/dana/cashier/model/CashierPayMethodModel;)Lid/dana/cashier/model/CashierPayMethodModel$DanaPlusPayMethod;", "Lid/dana/cashier/model/CashierPayMethodModel$OTCPayMethod;", "PlaceComponentResult", "(Lid/dana/cashier/model/CashierPayMethodModel;)Lid/dana/cashier/model/CashierPayMethodModel$OTCPayMethod;", "Lid/dana/cashier/model/CashierPayMethodModel$PaylaterCicilPayMethod;", "getAuthRequestContext", "(Lid/dana/cashier/model/CashierPayMethodModel;)Lid/dana/cashier/model/CashierPayMethodModel$PaylaterCicilPayMethod;", "Lid/dana/cashier/model/CashierPayMethodModel$PaylaterPayMethod;", "NetworkUserEntityData$$ExternalSyntheticLambda0", "(Lid/dana/cashier/model/CashierPayMethodModel;)Lid/dana/cashier/model/CashierPayMethodModel$PaylaterPayMethod;", "Lid/dana/cashier/model/CashierPayMethodModel$VirtualAccountPayMethod;", "getErrorConfigVersion", "(Lid/dana/cashier/model/CashierPayMethodModel;)Lid/dana/cashier/model/CashierPayMethodModel$VirtualAccountPayMethod;", "", "", "p0", "", "(Ljava/util/List;Ljava/lang/String;)Z", "Lid/dana/cashier/model/CashierPayMethodModel$NewCardData;", "scheduleImpl", "(Lid/dana/cashier/model/CashierPayMethodModel;)Lid/dana/cashier/model/CashierPayMethodModel$NewCardData;", "Lid/dana/cashier/model/CashierPayChannelModel;", "moveToNextValue", "(Lid/dana/cashier/model/CashierPayMethodModel;)Lid/dana/cashier/model/CashierPayChannelModel;", "(Ljava/util/List;)Z", "lookAheadTest", "(Lid/dana/cashier/model/CashierPayMethodModel;)Z", "NetworkUserEntityData$$ExternalSyntheticLambda2", "NetworkUserEntityData$$ExternalSyntheticLambda1", "(Ljava/util/List;)Ljava/lang/Boolean;", "initRecordTimeStamp", "GetContactSyncConfig", "DatabaseTableConfigUtil", "NetworkUserEntityData$$ExternalSyntheticLambda8", "PrepareContext", "NetworkUserEntityData$$ExternalSyntheticLambda7", "newProxyInstance", "isLayoutRequested", "NetworkUserEntityData$$ExternalSyntheticLambda5", "(Lid/dana/cashier/model/CashierPayMethodModel;Ljava/lang/String;)Z", "FragmentBottomSheetPaymentSettingBinding", "NetworkUserEntityData$$ExternalSyntheticLambda4", "NetworkUserEntityData$$ExternalSyntheticLambda3", "NetworkUserEntityData$$ExternalSyntheticLambda6", "readMicros", "getSupportButtonTintMode", "getCallingPid", "SubSequence", "whenAvailable", DiskFormatter.B, "BottomSheetCardBindingView$watcherCardNumberView$1", "(Lid/dana/cashier/model/CashierPayMethodModel;)Ljava/lang/Boolean;", "VerifyPinStateManager$executeRiskChallenge$2$1"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class CashierPayMethodModelKt {
    public static final CashierPayMethodModel.CardPayMethod MyBillsEntityDataFactory(CashierPayMethodModel cashierPayMethodModel) {
        Intrinsics.checkNotNullParameter(cashierPayMethodModel, "");
        if (cashierPayMethodModel instanceof CashierPayMethodModel.CardPayMethod) {
            return (CashierPayMethodModel.CardPayMethod) cashierPayMethodModel;
        }
        return null;
    }

    public static final CashierPayMethodModel.BalancePayMethod KClassImpl$Data$declaredNonStaticMembers$2(CashierPayMethodModel cashierPayMethodModel) {
        Intrinsics.checkNotNullParameter(cashierPayMethodModel, "");
        if (cashierPayMethodModel instanceof CashierPayMethodModel.BalancePayMethod) {
            return (CashierPayMethodModel.BalancePayMethod) cashierPayMethodModel;
        }
        return null;
    }

    public static final CashierPayMethodModel.PaylaterPayMethod NetworkUserEntityData$$ExternalSyntheticLambda0(CashierPayMethodModel cashierPayMethodModel) {
        Intrinsics.checkNotNullParameter(cashierPayMethodModel, "");
        if (cashierPayMethodModel instanceof CashierPayMethodModel.PaylaterPayMethod) {
            return (CashierPayMethodModel.PaylaterPayMethod) cashierPayMethodModel;
        }
        return null;
    }

    public static final CashierPayMethodModel.PaylaterCicilPayMethod getAuthRequestContext(CashierPayMethodModel cashierPayMethodModel) {
        Intrinsics.checkNotNullParameter(cashierPayMethodModel, "");
        if (cashierPayMethodModel instanceof CashierPayMethodModel.PaylaterCicilPayMethod) {
            return (CashierPayMethodModel.PaylaterCicilPayMethod) cashierPayMethodModel;
        }
        return null;
    }

    public static final CashierPayMethodModel.DanaPlusPayMethod BuiltInFictitiousFunctionClassFactory(CashierPayMethodModel cashierPayMethodModel) {
        Intrinsics.checkNotNullParameter(cashierPayMethodModel, "");
        if (cashierPayMethodModel instanceof CashierPayMethodModel.DanaPlusPayMethod) {
            return (CashierPayMethodModel.DanaPlusPayMethod) cashierPayMethodModel;
        }
        return null;
    }

    public static final CashierPayMethodModel.NewCardData scheduleImpl(CashierPayMethodModel cashierPayMethodModel) {
        Intrinsics.checkNotNullParameter(cashierPayMethodModel, "");
        Intrinsics.checkNotNullParameter(cashierPayMethodModel, "");
        CashierPayMethodModel.CardPayMethod cardPayMethod = cashierPayMethodModel instanceof CashierPayMethodModel.CardPayMethod ? (CashierPayMethodModel.CardPayMethod) cashierPayMethodModel : null;
        if (cardPayMethod != null) {
            return cardPayMethod.getAuthRequestContext;
        }
        return null;
    }

    public static final boolean GetContactSyncConfig(CashierPayMethodModel cashierPayMethodModel) {
        Intrinsics.checkNotNullParameter(cashierPayMethodModel, "");
        return (cashierPayMethodModel instanceof CashierPayMethodModel.HelperPayMethod) && cashierPayMethodModel.getScheduleImpl() == 1;
    }

    public static final boolean DatabaseTableConfigUtil(CashierPayMethodModel cashierPayMethodModel) {
        Intrinsics.checkNotNullParameter(cashierPayMethodModel, "");
        return cashierPayMethodModel instanceof CashierPayMethodModel.BalancePayMethod;
    }

    public static final boolean NetworkUserEntityData$$ExternalSyntheticLambda8(CashierPayMethodModel cashierPayMethodModel) {
        Intrinsics.checkNotNullParameter(cashierPayMethodModel, "");
        return cashierPayMethodModel instanceof CashierPayMethodModel.BalanceFamilyPayMethod;
    }

    public static final boolean PrepareContext(CashierPayMethodModel cashierPayMethodModel) {
        Intrinsics.checkNotNullParameter(cashierPayMethodModel, "");
        return cashierPayMethodModel instanceof CashierPayMethodModel.CardPayMethod;
    }

    public static final boolean NetworkUserEntityData$$ExternalSyntheticLambda5(CashierPayMethodModel cashierPayMethodModel) {
        Intrinsics.checkNotNullParameter(cashierPayMethodModel, "");
        return (cashierPayMethodModel instanceof CashierPayMethodModel.CardPayMethod) && ((CashierPayMethodModel.CardPayMethod) cashierPayMethodModel).KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2();
    }

    public static final boolean NetworkUserEntityData$$ExternalSyntheticLambda7(CashierPayMethodModel cashierPayMethodModel) {
        Intrinsics.checkNotNullParameter(cashierPayMethodModel, "");
        return (cashierPayMethodModel instanceof CashierPayMethodModel.CardPayMethod) && ((CashierPayMethodModel.CardPayMethod) cashierPayMethodModel).KClassImpl$Data$declaredNonStaticMembers$2.PlaceComponentResult();
    }

    public static final boolean NetworkUserEntityData$$ExternalSyntheticLambda2(CashierPayMethodModel cashierPayMethodModel) {
        Intrinsics.checkNotNullParameter(cashierPayMethodModel, "");
        if (cashierPayMethodModel instanceof CashierPayMethodModel.BalancePayMethod) {
            CashierPayMethodModelExt cashierPayMethodModelExt = CashierPayMethodModelExt.INSTANCE;
            if (CashierPayMethodModelExt.BuiltInFictitiousFunctionClassFactory((CashierPayMethodModel.BalancePayMethod) cashierPayMethodModel)) {
                return true;
            }
        }
        return false;
    }

    public static final boolean initRecordTimeStamp(CashierPayMethodModel cashierPayMethodModel) {
        Intrinsics.checkNotNullParameter(cashierPayMethodModel, "");
        if (cashierPayMethodModel instanceof CashierPayMethodModel.BalancePayMethod) {
            CashierPayMethodModelExt cashierPayMethodModelExt = CashierPayMethodModelExt.INSTANCE;
            if (CashierPayMethodModelExt.getAuthRequestContext((CashierPayMethodModel.BalancePayMethod) cashierPayMethodModel)) {
                return true;
            }
        }
        return false;
    }

    public static final boolean NetworkUserEntityData$$ExternalSyntheticLambda1(CashierPayMethodModel cashierPayMethodModel) {
        Intrinsics.checkNotNullParameter(cashierPayMethodModel, "");
        if (cashierPayMethodModel instanceof CashierPayMethodModel.PaylaterPayMethod) {
            CashierPayMethodModelExt cashierPayMethodModelExt = CashierPayMethodModelExt.INSTANCE;
            if (CashierPayMethodModelExt.BuiltInFictitiousFunctionClassFactory((CashierPayMethodModel.PaylaterPayMethod) cashierPayMethodModel)) {
                return true;
            }
        }
        return false;
    }

    public static final boolean lookAheadTest(CashierPayMethodModel cashierPayMethodModel) {
        Intrinsics.checkNotNullParameter(cashierPayMethodModel, "");
        if (cashierPayMethodModel instanceof CashierPayMethodModel.CardPayMethod) {
            CashierPayMethodModel.CardPayMethod cardPayMethod = (CashierPayMethodModel.CardPayMethod) cashierPayMethodModel;
            if (cardPayMethod.FragmentBottomSheetPaymentSettingBinding() && !cardPayMethod.whenAvailable()) {
                return true;
            }
        }
        return false;
    }

    public static final boolean NetworkUserEntityData$$ExternalSyntheticLambda4(CashierPayMethodModel cashierPayMethodModel) {
        Intrinsics.checkNotNullParameter(cashierPayMethodModel, "");
        return (cashierPayMethodModel instanceof CashierPayMethodModel.CardPayMethod) && ((CashierPayMethodModel.CardPayMethod) cashierPayMethodModel).whenAvailable();
    }

    public static final boolean MyBillsEntityDataFactory(CashierPayMethodModel cashierPayMethodModel, String str) {
        Intrinsics.checkNotNullParameter(cashierPayMethodModel, "");
        Intrinsics.checkNotNullParameter(str, "");
        return (cashierPayMethodModel instanceof CashierPayMethodModel.CardPayMethod) && ((CashierPayMethodModel.CardPayMethod) cashierPayMethodModel).BuiltInFictitiousFunctionClassFactory(str) && cashierPayMethodModel.PlaceComponentResult();
    }

    public static final boolean getAuthRequestContext(CashierPayMethodModel cashierPayMethodModel, String str) {
        Intrinsics.checkNotNullParameter(cashierPayMethodModel, "");
        Intrinsics.checkNotNullParameter(str, "");
        return (cashierPayMethodModel instanceof CashierPayMethodModel.PaylaterCicilPayMethod) && ((CashierPayMethodModel.PaylaterCicilPayMethod) cashierPayMethodModel).getAuthRequestContext(str) && cashierPayMethodModel.PlaceComponentResult();
    }

    public static final boolean FragmentBottomSheetPaymentSettingBinding(CashierPayMethodModel cashierPayMethodModel) {
        Intrinsics.checkNotNullParameter(cashierPayMethodModel, "");
        return (cashierPayMethodModel instanceof CashierPayMethodModel.CardPayMethod) && ((CashierPayMethodModel.CardPayMethod) cashierPayMethodModel).KClassImpl$Data$declaredNonStaticMembers$2.BuiltInFictitiousFunctionClassFactory();
    }

    public static final boolean readMicros(CashierPayMethodModel cashierPayMethodModel) {
        Intrinsics.checkNotNullParameter(cashierPayMethodModel, "");
        return (cashierPayMethodModel instanceof CashierPayMethodModel.CardPayMethod) && StringsKt.equals(Institution.BCA_ONEKLIK, ((CashierPayMethodModel.CardPayMethod) cashierPayMethodModel).KClassImpl$Data$declaredNonStaticMembers$2.NetworkUserEntityData$$ExternalSyntheticLambda7, true);
    }

    public static final boolean getSupportButtonTintMode(CashierPayMethodModel cashierPayMethodModel) {
        Intrinsics.checkNotNullParameter(cashierPayMethodModel, "");
        return (cashierPayMethodModel instanceof CashierPayMethodModel.PaylaterPayMethod) && ((CashierPayMethodModel.PaylaterPayMethod) cashierPayMethodModel).BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory();
    }

    public static final boolean NetworkUserEntityData$$ExternalSyntheticLambda6(CashierPayMethodModel cashierPayMethodModel) {
        CashierPayChannelModel cashierPayChannelModel;
        boolean z = cashierPayMethodModel instanceof CashierPayMethodModel.PaylaterCicilPayMethod;
        if (z) {
            Intrinsics.checkNotNullParameter(cashierPayMethodModel, "");
            CashierPayMethodModel.PaylaterCicilPayMethod paylaterCicilPayMethod = z ? (CashierPayMethodModel.PaylaterCicilPayMethod) cashierPayMethodModel : null;
            return paylaterCicilPayMethod != null && (cashierPayChannelModel = paylaterCicilPayMethod.getErrorConfigVersion) != null && cashierPayChannelModel.KClassImpl$Data$declaredNonStaticMembers$2();
        }
        return false;
    }

    public static final boolean newProxyInstance(CashierPayMethodModel cashierPayMethodModel) {
        return cashierPayMethodModel instanceof CashierPayMethodModel.DanaPlusPayMethod;
    }

    public static final Boolean BottomSheetCardBindingView$watcherCardNumberView$1(CashierPayMethodModel cashierPayMethodModel) {
        CashierPayChannelModel cashierPayChannelModel;
        ExtendCashierModel extendCashierModel;
        CashierPayChannelModel cashierPayChannelModel2;
        List<LoanCreditChannelInfoModel> list;
        LoanCreditChannelInfoModel loanCreditChannelInfoModel;
        Boolean bool;
        if (cashierPayMethodModel != null) {
            Intrinsics.checkNotNullParameter(cashierPayMethodModel, "");
            CashierPayMethodModel.PaylaterCicilPayMethod paylaterCicilPayMethod = cashierPayMethodModel instanceof CashierPayMethodModel.PaylaterCicilPayMethod ? (CashierPayMethodModel.PaylaterCicilPayMethod) cashierPayMethodModel : null;
            if (paylaterCicilPayMethod != null && (cashierPayChannelModel2 = paylaterCicilPayMethod.getErrorConfigVersion) != null && (list = cashierPayChannelModel2.NetworkUserEntityData$$ExternalSyntheticLambda4) != null && (loanCreditChannelInfoModel = (LoanCreditChannelInfoModel) CollectionsKt.firstOrNull((List) list)) != null && (bool = loanCreditChannelInfoModel.KClassImpl$Data$declaredNonStaticMembers$2) != null) {
                return bool;
            }
        }
        if (cashierPayMethodModel != null) {
            Intrinsics.checkNotNullParameter(cashierPayMethodModel, "");
            CashierPayMethodModel.PaylaterCicilPayMethod paylaterCicilPayMethod2 = cashierPayMethodModel instanceof CashierPayMethodModel.PaylaterCicilPayMethod ? (CashierPayMethodModel.PaylaterCicilPayMethod) cashierPayMethodModel : null;
            if (paylaterCicilPayMethod2 == null || (cashierPayChannelModel = paylaterCicilPayMethod2.getErrorConfigVersion) == null || (extendCashierModel = cashierPayChannelModel.newProxyInstance) == null) {
                return null;
            }
            return extendCashierModel.NetworkUserEntityData$$ExternalSyntheticLambda1;
        }
        return null;
    }

    public static final CashierPayMethodModel.VirtualAccountPayMethod getErrorConfigVersion(CashierPayMethodModel cashierPayMethodModel) {
        Intrinsics.checkNotNullParameter(cashierPayMethodModel, "");
        if (cashierPayMethodModel instanceof CashierPayMethodModel.VirtualAccountPayMethod) {
            return (CashierPayMethodModel.VirtualAccountPayMethod) cashierPayMethodModel;
        }
        return null;
    }

    public static final CashierPayMethodModel.OTCPayMethod PlaceComponentResult(CashierPayMethodModel cashierPayMethodModel) {
        Intrinsics.checkNotNullParameter(cashierPayMethodModel, "");
        if (cashierPayMethodModel instanceof CashierPayMethodModel.OTCPayMethod) {
            return (CashierPayMethodModel.OTCPayMethod) cashierPayMethodModel;
        }
        return null;
    }

    public static final CashierPayChannelModel moveToNextValue(CashierPayMethodModel cashierPayMethodModel) {
        Intrinsics.checkNotNullParameter(cashierPayMethodModel, "");
        CashierPayMethodModel.ChannelPayMethodModel channelPayMethodModel = cashierPayMethodModel instanceof CashierPayMethodModel.ChannelPayMethodModel ? (CashierPayMethodModel.ChannelPayMethodModel) cashierPayMethodModel : null;
        if (channelPayMethodModel != null) {
            return channelPayMethodModel.getMyBillsEntityDataFactory();
        }
        return null;
    }

    public static final boolean VerifyPinStateManager$executeRiskChallenge$2$1(CashierPayMethodModel cashierPayMethodModel) {
        Intrinsics.checkNotNullParameter(cashierPayMethodModel, "");
        if (cashierPayMethodModel instanceof CashierPayMethodModel.PaylaterPayMethod) {
            CashierPayMethodModelExt cashierPayMethodModelExt = CashierPayMethodModelExt.INSTANCE;
            if (CashierPayMethodModelExt.getErrorConfigVersion((CashierPayMethodModel.PaylaterPayMethod) cashierPayMethodModel)) {
                return true;
            }
        }
        return false;
    }

    public static final boolean whenAvailable(CashierPayMethodModel cashierPayMethodModel) {
        Intrinsics.checkNotNullParameter(cashierPayMethodModel, "");
        if (cashierPayMethodModel instanceof CashierPayMethodModel.PaylaterPayMethod) {
            CashierPayMethodModelExt cashierPayMethodModelExt = CashierPayMethodModelExt.INSTANCE;
            if (CashierPayMethodModelExt.PlaceComponentResult((CashierPayMethodModel.PaylaterPayMethod) cashierPayMethodModel)) {
                return true;
            }
        }
        return false;
    }

    public static final boolean SubSequence(CashierPayMethodModel cashierPayMethodModel) {
        Intrinsics.checkNotNullParameter(cashierPayMethodModel, "");
        if (cashierPayMethodModel instanceof CashierPayMethodModel.PaylaterPayMethod) {
            CashierPayMethodModelExt cashierPayMethodModelExt = CashierPayMethodModelExt.INSTANCE;
            if (CashierPayMethodModelExt.KClassImpl$Data$declaredNonStaticMembers$2((CashierPayMethodModel.PaylaterPayMethod) cashierPayMethodModel)) {
                return true;
            }
        }
        return false;
    }

    public static final boolean B(CashierPayMethodModel cashierPayMethodModel) {
        Intrinsics.checkNotNullParameter(cashierPayMethodModel, "");
        if (cashierPayMethodModel instanceof CashierPayMethodModel.PaylaterPayMethod) {
            CashierPayMethodModelExt cashierPayMethodModelExt = CashierPayMethodModelExt.INSTANCE;
            if (CashierPayMethodModelExt.MyBillsEntityDataFactory((CashierPayMethodModel.PaylaterPayMethod) cashierPayMethodModel)) {
                return true;
            }
        }
        return false;
    }

    public static final boolean getCallingPid(CashierPayMethodModel cashierPayMethodModel) {
        Intrinsics.checkNotNullParameter(cashierPayMethodModel, "");
        if (cashierPayMethodModel instanceof CashierPayMethodModel.PaylaterPayMethod) {
            CashierPayMethodModelExt cashierPayMethodModelExt = CashierPayMethodModelExt.INSTANCE;
            if (CashierPayMethodModelExt.getAuthRequestContext((CashierPayMethodModel.PaylaterPayMethod) cashierPayMethodModel)) {
                return true;
            }
        }
        return false;
    }

    public static final boolean isLayoutRequested(CashierPayMethodModel cashierPayMethodModel) {
        Intrinsics.checkNotNullParameter(cashierPayMethodModel, "");
        if (cashierPayMethodModel instanceof CashierPayMethodModel.DanaPlusPayMethod) {
            CashierPayMethodModelExt cashierPayMethodModelExt = CashierPayMethodModelExt.INSTANCE;
            if (CashierPayMethodModelExt.PlaceComponentResult((CashierPayMethodModel.DanaPlusPayMethod) cashierPayMethodModel)) {
                return true;
            }
        }
        return false;
    }

    public static final boolean MyBillsEntityDataFactory(List<? extends CashierPayMethodModel> list) {
        Object obj;
        Intrinsics.checkNotNullParameter(list, "");
        Iterator<T> it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (NetworkUserEntityData$$ExternalSyntheticLambda8((CashierPayMethodModel) obj)) {
                break;
            }
        }
        return obj != null;
    }

    public static final boolean KClassImpl$Data$declaredNonStaticMembers$2(List<? extends CashierPayMethodModel> list) {
        Object obj;
        Intrinsics.checkNotNullParameter(list, "");
        Iterator<T> it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (NetworkUserEntityData$$ExternalSyntheticLambda6((CashierPayMethodModel) obj)) {
                break;
            }
        }
        return obj != null;
    }

    public static final boolean getAuthRequestContext(List<? extends CashierPayMethodModel> list, String str) {
        Object obj;
        Intrinsics.checkNotNullParameter(list, "");
        Intrinsics.checkNotNullParameter(str, "");
        Iterator<T> it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (Intrinsics.areEqual(((CashierPayMethodModel) obj).lookAheadTest(), str)) {
                break;
            }
        }
        CashierPayMethodModel cashierPayMethodModel = (CashierPayMethodModel) obj;
        return cashierPayMethodModel != null && cashierPayMethodModel.PlaceComponentResult();
    }

    public static final Boolean BuiltInFictitiousFunctionClassFactory(List<? extends CashierPayMethodModel> list) {
        Object obj;
        Intrinsics.checkNotNullParameter(list, "");
        Iterator<T> it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (NetworkUserEntityData$$ExternalSyntheticLambda6((CashierPayMethodModel) obj)) {
                break;
            }
        }
        return BottomSheetCardBindingView$watcherCardNumberView$1((CashierPayMethodModel) obj);
    }

    public static final boolean NetworkUserEntityData$$ExternalSyntheticLambda3(CashierPayMethodModel cashierPayMethodModel) {
        Intrinsics.checkNotNullParameter(cashierPayMethodModel, "");
        if (cashierPayMethodModel instanceof CashierPayMethodModel.BalanceFamilyPayMethod) {
            CashierPayMethodModelExt cashierPayMethodModelExt = CashierPayMethodModelExt.INSTANCE;
            if (CashierPayMethodModelExt.KClassImpl$Data$declaredNonStaticMembers$2((CashierPayMethodModel.BalanceFamilyPayMethod) cashierPayMethodModel)) {
                return true;
            }
        }
        return false;
    }
}
