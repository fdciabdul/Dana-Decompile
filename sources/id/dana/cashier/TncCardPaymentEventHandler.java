package id.dana.cashier;

import id.dana.domain.useragreement.interactor.ConsultAgreementOnlyParamSpaceCodes;
import id.dana.domain.useragreement.interactor.RecordAgreementOnlyAgreementKey;
import id.dana.domain.useragreement.model.AgreementInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B\u0019\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0007\u0012\u0006\u0010\r\u001a\u00020\n¢\u0006\u0004\b\u000e\u0010\u000fJ\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0005\u001a\u00020\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\tR\u0014\u0010\f\u001a\u00020\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u000b"}, d2 = {"Lid/dana/cashier/TncCardPaymentEventHandler;", "", "Lid/dana/cashier/TncCardPaymentEventListener;", "p0", "", "KClassImpl$Data$declaredNonStaticMembers$2", "(Lid/dana/cashier/TncCardPaymentEventListener;)V", "Lid/dana/domain/useragreement/interactor/ConsultAgreementOnlyParamSpaceCodes;", "MyBillsEntityDataFactory", "Lid/dana/domain/useragreement/interactor/ConsultAgreementOnlyParamSpaceCodes;", "Lid/dana/domain/useragreement/interactor/RecordAgreementOnlyAgreementKey;", "Lid/dana/domain/useragreement/interactor/RecordAgreementOnlyAgreementKey;", "PlaceComponentResult", "p1", "<init>", "(Lid/dana/domain/useragreement/interactor/ConsultAgreementOnlyParamSpaceCodes;Lid/dana/domain/useragreement/interactor/RecordAgreementOnlyAgreementKey;)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class TncCardPaymentEventHandler {

    /* renamed from: Companion  reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static TncCardPaymentEventListener PlaceComponentResult;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    public final RecordAgreementOnlyAgreementKey PlaceComponentResult;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    public final ConsultAgreementOnlyParamSpaceCodes KClassImpl$Data$declaredNonStaticMembers$2;

    @Inject
    public TncCardPaymentEventHandler(ConsultAgreementOnlyParamSpaceCodes consultAgreementOnlyParamSpaceCodes, RecordAgreementOnlyAgreementKey recordAgreementOnlyAgreementKey) {
        Intrinsics.checkNotNullParameter(consultAgreementOnlyParamSpaceCodes, "");
        Intrinsics.checkNotNullParameter(recordAgreementOnlyAgreementKey, "");
        this.KClassImpl$Data$declaredNonStaticMembers$2 = consultAgreementOnlyParamSpaceCodes;
        this.PlaceComponentResult = recordAgreementOnlyAgreementKey;
    }

    public static void KClassImpl$Data$declaredNonStaticMembers$2(TncCardPaymentEventListener p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        PlaceComponentResult = p0;
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\t\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\n\u0010\u000bR$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b"}, d2 = {"Lid/dana/cashier/TncCardPaymentEventHandler$Companion;", "", "Lid/dana/cashier/TncCardPaymentEventListener;", "PlaceComponentResult", "Lid/dana/cashier/TncCardPaymentEventListener;", "MyBillsEntityDataFactory", "()Lid/dana/cashier/TncCardPaymentEventListener;", "KClassImpl$Data$declaredNonStaticMembers$2", "(Lid/dana/cashier/TncCardPaymentEventListener;)V", "BuiltInFictitiousFunctionClassFactory", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmName(name = "KClassImpl$Data$declaredNonStaticMembers$2")
        public static void KClassImpl$Data$declaredNonStaticMembers$2(TncCardPaymentEventListener tncCardPaymentEventListener) {
            TncCardPaymentEventHandler.PlaceComponentResult = tncCardPaymentEventListener;
        }

        @JvmName(name = "MyBillsEntityDataFactory")
        public static TncCardPaymentEventListener MyBillsEntityDataFactory() {
            return TncCardPaymentEventHandler.PlaceComponentResult;
        }
    }

    public static final /* synthetic */ List BuiltInFictitiousFunctionClassFactory(List list) {
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            String agreementKey = ((AgreementInfo) it.next()).getAgreementKey();
            if (agreementKey != null) {
                arrayList.add(agreementKey);
            }
        }
        return arrayList;
    }
}
