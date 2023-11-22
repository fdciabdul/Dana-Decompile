package id.dana.sendmoney.data.api.globalsend.init.model.request;

import com.alipayplus.mobile.component.domain.model.request.BaseRpcRequest;
import com.google.firebase.analytics.FirebaseAnalytics;
import id.dana.data.geocode.mapper.GeocoderResultMapperKt;
import id.dana.sendmoney.data.api.globalsend.init.model.TransferParticipantEntity;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u0001BY\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0002\u0012\b\b\u0002\u0010\f\u001a\u00020\u000b\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0010¢\u0006\u0004\b\u0019\u0010\u001aR\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0007¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001c\u0010\t\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006R\u001a\u0010\f\u001a\u00020\u000b8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0015\u0010\u0004\u001a\u0004\b\u0016\u0010\u0006R\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0017\u0010\u0004\u001a\u0004\b\u0018\u0010\u0006"}, d2 = {"Lid/dana/sendmoney/data/api/globalsend/init/model/request/GlobalTransferInitRequestEntity;", "Lcom/alipayplus/mobile/component/domain/model/request/BaseRpcRequest;", "", "amount", "Ljava/lang/String;", "getAmount", "()Ljava/lang/String;", GeocoderResultMapperKt.COUNTRY, "getCountry", FirebaseAnalytics.Param.CURRENCY, "getCurrency", "", "needSubTransferMethod", "Z", "getNeedSubTransferMethod", "()Z", "Lid/dana/sendmoney/data/api/globalsend/init/model/TransferParticipantEntity;", "payeeInfo", "Lid/dana/sendmoney/data/api/globalsend/init/model/TransferParticipantEntity;", "getPayeeInfo", "()Lid/dana/sendmoney/data/api/globalsend/init/model/TransferParticipantEntity;", "subTransferMethod", "getSubTransferMethod", "transferMethod", "getTransferMethod", "<init>", "(Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Lid/dana/sendmoney/data/api/globalsend/init/model/TransferParticipantEntity;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class GlobalTransferInitRequestEntity extends BaseRpcRequest {
    private final String amount;
    private final String country;
    private final String currency;
    private final boolean needSubTransferMethod;
    private final TransferParticipantEntity payeeInfo;
    private final String subTransferMethod;
    private final String transferMethod;

    public GlobalTransferInitRequestEntity() {
        this(null, null, false, null, null, null, null, 127, null);
    }

    public /* synthetic */ GlobalTransferInitRequestEntity(String str, String str2, boolean z, String str3, String str4, String str5, TransferParticipantEntity transferParticipantEntity, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? false : z, (i & 8) != 0 ? null : str3, (i & 16) != 0 ? null : str4, (i & 32) != 0 ? null : str5, (i & 64) != 0 ? null : transferParticipantEntity);
    }

    @JvmName(name = "getCountry")
    public final String getCountry() {
        return this.country;
    }

    @JvmName(name = "getCurrency")
    public final String getCurrency() {
        return this.currency;
    }

    @JvmName(name = "getNeedSubTransferMethod")
    public final boolean getNeedSubTransferMethod() {
        return this.needSubTransferMethod;
    }

    @JvmName(name = "getTransferMethod")
    public final String getTransferMethod() {
        return this.transferMethod;
    }

    @JvmName(name = "getSubTransferMethod")
    public final String getSubTransferMethod() {
        return this.subTransferMethod;
    }

    @JvmName(name = "getAmount")
    public final String getAmount() {
        return this.amount;
    }

    @JvmName(name = "getPayeeInfo")
    public final TransferParticipantEntity getPayeeInfo() {
        return this.payeeInfo;
    }

    public GlobalTransferInitRequestEntity(String str, String str2, boolean z, String str3, String str4, String str5, TransferParticipantEntity transferParticipantEntity) {
        this.country = str;
        this.currency = str2;
        this.needSubTransferMethod = z;
        this.transferMethod = str3;
        this.subTransferMethod = str4;
        this.amount = str5;
        this.payeeInfo = transferParticipantEntity;
    }
}
