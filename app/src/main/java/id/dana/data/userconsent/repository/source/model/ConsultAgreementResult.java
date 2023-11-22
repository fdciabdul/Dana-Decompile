package id.dana.data.userconsent.repository.source.model;

import com.alipayplus.mobile.component.domain.model.result.BaseRpcResult;
import id.dana.domain.useragreement.model.AgreementInfo;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002¢\u0006\u0004\b\r\u0010\u000eR\u001f\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0007¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u001a\u0010\t\u001a\u00020\b8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f"}, d2 = {"Lid/dana/data/userconsent/repository/source/model/ConsultAgreementResult;", "Lcom/alipayplus/mobile/component/domain/model/result/BaseRpcResult;", "", "Lid/dana/domain/useragreement/model/AgreementInfo;", "agreementInfos", "Ljava/util/List;", "getAgreementInfos", "()Ljava/util/List;", "", "needUserAgreement", "Z", "getNeedUserAgreement", "()Z", "<init>", "(ZLjava/util/List;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class ConsultAgreementResult extends BaseRpcResult {
    private final List<AgreementInfo> agreementInfos;
    private final boolean needUserAgreement;

    @JvmName(name = "getNeedUserAgreement")
    public final boolean getNeedUserAgreement() {
        return this.needUserAgreement;
    }

    public /* synthetic */ ConsultAgreementResult(boolean z, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(z, (i & 2) != 0 ? CollectionsKt.emptyList() : list);
    }

    @JvmName(name = "getAgreementInfos")
    public final List<AgreementInfo> getAgreementInfos() {
        return this.agreementInfos;
    }

    public ConsultAgreementResult(boolean z, List<AgreementInfo> list) {
        this.needUserAgreement = z;
        this.agreementInfos = list;
    }
}
