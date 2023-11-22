package id.dana.data.userconsent.repository.source.network;

import com.alipayplus.mobile.component.domain.model.request.BaseRpcRequest;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b\b\u0018\u00002\u00020\u0001B+\u0012\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00020\u0010\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\u0017\u0010\u0018R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\n\u001a\u0004\u0018\u00010\t8\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR(\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00020\u00108\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016"}, d2 = {"Lid/dana/data/userconsent/repository/source/network/ConsultAgreementRequest;", "Lcom/alipayplus/mobile/component/domain/model/request/BaseRpcRequest;", "", "agreementType", "Ljava/lang/String;", "getAgreementType", "()Ljava/lang/String;", "setAgreementType", "(Ljava/lang/String;)V", "", "alwaysDisplayAgreementContent", "Ljava/lang/Boolean;", "getAlwaysDisplayAgreementContent", "()Ljava/lang/Boolean;", "setAlwaysDisplayAgreementContent", "(Ljava/lang/Boolean;)V", "", "spaceCodes", "Ljava/util/List;", "getSpaceCodes", "()Ljava/util/List;", "setSpaceCodes", "(Ljava/util/List;)V", "<init>", "(Ljava/util/List;Ljava/lang/String;Ljava/lang/Boolean;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class ConsultAgreementRequest extends BaseRpcRequest {
    private String agreementType;
    private Boolean alwaysDisplayAgreementContent;
    private List<String> spaceCodes;

    public /* synthetic */ ConsultAgreementRequest(List list, String str, Boolean bool, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(list, str, (i & 4) != 0 ? null : bool);
    }

    @JvmName(name = "getSpaceCodes")
    public final List<String> getSpaceCodes() {
        return this.spaceCodes;
    }

    @JvmName(name = "setSpaceCodes")
    public final void setSpaceCodes(List<String> list) {
        Intrinsics.checkNotNullParameter(list, "");
        this.spaceCodes = list;
    }

    @JvmName(name = "getAgreementType")
    public final String getAgreementType() {
        return this.agreementType;
    }

    @JvmName(name = "setAgreementType")
    public final void setAgreementType(String str) {
        this.agreementType = str;
    }

    @JvmName(name = "getAlwaysDisplayAgreementContent")
    public final Boolean getAlwaysDisplayAgreementContent() {
        return this.alwaysDisplayAgreementContent;
    }

    @JvmName(name = "setAlwaysDisplayAgreementContent")
    public final void setAlwaysDisplayAgreementContent(Boolean bool) {
        this.alwaysDisplayAgreementContent = bool;
    }

    public ConsultAgreementRequest(List<String> list, String str, Boolean bool) {
        Intrinsics.checkNotNullParameter(list, "");
        this.spaceCodes = list;
        this.agreementType = str;
        this.alwaysDisplayAgreementContent = bool;
    }
}
