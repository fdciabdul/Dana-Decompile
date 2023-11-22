package id.dana.sendmoney_v2.landing.contract;

import id.dana.domain.payasset.model.PayCardOptionView;
import id.dana.domain.payasset.model.PayChannelOptionView;
import id.dana.domain.payasset.model.PayMethod;
import id.dana.domain.payasset.model.PayMethodView;
import id.dana.domain.sendmoney.model.PayOptionDTOResponse;
import id.dana.domain.sendmoney.model.TransferInit;
import id.dana.domain.withdraw.model.TransferMethodView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\u001a\u0013\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u0013\u0010\u0004\u001a\u00020\u0001*\u00020\u0000H\u0002¢\u0006\u0004\b\u0004\u0010\u0003\u001a\u0013\u0010\u0005\u001a\u00020\u0001*\u00020\u0000H\u0002¢\u0006\u0004\b\u0005\u0010\u0003"}, d2 = {"Lid/dana/domain/sendmoney/model/TransferInit;", "", "BuiltInFictitiousFunctionClassFactory", "(Lid/dana/domain/sendmoney/model/TransferInit;)Z", "getAuthRequestContext", "lookAheadTest"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class SendMoneyHomePresenterKt {
    public static final /* synthetic */ boolean KClassImpl$Data$declaredNonStaticMembers$2(TransferInit transferInit) {
        return getAuthRequestContext(transferInit);
    }

    public static final /* synthetic */ boolean MyBillsEntityDataFactory(TransferInit transferInit) {
        return lookAheadTest(transferInit);
    }

    public static final /* synthetic */ boolean PlaceComponentResult(TransferInit transferInit) {
        return BuiltInFictitiousFunctionClassFactory(transferInit);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean BuiltInFictitiousFunctionClassFactory(TransferInit transferInit) {
        Object obj;
        List<PayOptionDTOResponse> payOptionDTOResponses;
        List<PayCardOptionView> payCardOptionViews;
        List<TransferMethodView> transferMethod = transferInit.getTransferMethod();
        Object obj2 = null;
        if (transferMethod != null) {
            Iterator<T> it = transferMethod.iterator();
            while (true) {
                if (!it.hasNext()) {
                    obj = null;
                    break;
                }
                obj = it.next();
                if (Intrinsics.areEqual(((TransferMethodView) obj).getTransferMethod(), "BANK_TRANSFER")) {
                    break;
                }
            }
            TransferMethodView transferMethodView = (TransferMethodView) obj;
            if (transferMethodView != null && (payOptionDTOResponses = transferMethodView.getPayOptionDTOResponses()) != null) {
                ArrayList arrayList = new ArrayList();
                for (Object obj3 : payOptionDTOResponses) {
                    PayOptionDTOResponse payOptionDTOResponse = (PayOptionDTOResponse) obj3;
                    if (Intrinsics.areEqual(payOptionDTOResponse.getPayMethod(), "DEBIT_CARD") || Intrinsics.areEqual(payOptionDTOResponse.getPayMethod(), "DIRECT_DEBIT_DEBIT_CARD")) {
                        arrayList.add(obj3);
                    }
                }
                Iterator it2 = arrayList.iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        break;
                    }
                    Object next = it2.next();
                    PayMethodView payMethodView = ((PayOptionDTOResponse) next).getPayMethodView();
                    if (((payMethodView == null || (payCardOptionViews = payMethodView.getPayCardOptionViews()) == null) ? 0 : payCardOptionViews.size()) > 0) {
                        obj2 = next;
                        break;
                    }
                }
                obj2 = (PayOptionDTOResponse) obj2;
            }
        }
        return obj2 != null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean getAuthRequestContext(TransferInit transferInit) {
        Object obj;
        List<PayOptionDTOResponse> payOptionDTOResponses;
        Object obj2;
        PayMethodView payMethodView;
        List<PayChannelOptionView> payChannelOptionViews;
        List<PayChannelOptionView> payChannelOptionViews2;
        List<TransferMethodView> transferMethod = transferInit.getTransferMethod();
        Object obj3 = null;
        if (transferMethod != null) {
            Iterator<T> it = transferMethod.iterator();
            while (true) {
                if (!it.hasNext()) {
                    obj = null;
                    break;
                }
                obj = it.next();
                if (Intrinsics.areEqual(((TransferMethodView) obj).getTransferMethod(), "BANK_TRANSFER")) {
                    break;
                }
            }
            TransferMethodView transferMethodView = (TransferMethodView) obj;
            if (transferMethodView != null && (payOptionDTOResponses = transferMethodView.getPayOptionDTOResponses()) != null) {
                ArrayList arrayList = new ArrayList();
                for (Object obj4 : payOptionDTOResponses) {
                    if (Intrinsics.areEqual(((PayOptionDTOResponse) obj4).getPayMethod(), "BALANCE")) {
                        arrayList.add(obj4);
                    }
                }
                Iterator it2 = arrayList.iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        obj2 = null;
                        break;
                    }
                    obj2 = it2.next();
                    PayMethodView payMethodView2 = ((PayOptionDTOResponse) obj2).getPayMethodView();
                    if (((payMethodView2 == null || (payChannelOptionViews2 = payMethodView2.getPayChannelOptionViews()) == null) ? 0 : payChannelOptionViews2.size()) > 0) {
                        break;
                    }
                }
                PayOptionDTOResponse payOptionDTOResponse = (PayOptionDTOResponse) obj2;
                if (payOptionDTOResponse != null && (payMethodView = payOptionDTOResponse.getPayMethodView()) != null && (payChannelOptionViews = payMethodView.getPayChannelOptionViews()) != null) {
                    Iterator<T> it3 = payChannelOptionViews.iterator();
                    while (true) {
                        if (!it3.hasNext()) {
                            break;
                        }
                        Object next = it3.next();
                        if (Intrinsics.areEqual(((PayChannelOptionView) next).getPayOption(), PayMethod.BALANCE_FAMILY)) {
                            obj3 = next;
                            break;
                        }
                    }
                    obj3 = (PayChannelOptionView) obj3;
                }
            }
        }
        return obj3 != null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean lookAheadTest(TransferInit transferInit) {
        return Intrinsics.areEqual(transferInit.getKyc(), "KYC2") || Intrinsics.areEqual(transferInit.getKyc(), "02");
    }
}
