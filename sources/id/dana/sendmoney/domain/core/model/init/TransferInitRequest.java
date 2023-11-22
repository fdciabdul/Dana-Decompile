package id.dana.sendmoney.domain.core.model.init;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u00002\u00020\u0001B[\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\u0017\u0010\u0018R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0002X\u0006¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0013\u0010\u0003\u001a\u0004\u0018\u00010\u0002X\u0006¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0002X\u0006¢\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0013\u0010\n\u001a\u0004\u0018\u00010\bX\u0006¢\u0006\u0006\n\u0004\b\u0007\u0010\tR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u000bX\u0006¢\u0006\u0006\n\u0004\b\n\u0010\fR\u0013\u0010\r\u001a\u0004\u0018\u00010\u0002X\u0006¢\u0006\u0006\n\u0004\b\r\u0010\u0004R\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u0002X\u0006¢\u0006\u0006\n\u0004\b\u000e\u0010\u0004"}, d2 = {"Lid/dana/sendmoney/domain/core/model/init/TransferInitRequest;", "", "", "MyBillsEntityDataFactory", "Ljava/lang/String;", "PlaceComponentResult", "getAuthRequestContext", "BuiltInFictitiousFunctionClassFactory", "", "Ljava/lang/Boolean;", "KClassImpl$Data$declaredNonStaticMembers$2", "Lid/dana/sendmoney/domain/core/model/init/TransferParticipant;", "Lid/dana/sendmoney/domain/core/model/init/TransferParticipant;", "scheduleImpl", "lookAheadTest", "moveToNextValue", "p0", "p1", "p2", "p3", "p4", "p5", "p6", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lid/dana/sendmoney/domain/core/model/init/TransferParticipant;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class TransferInitRequest {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    public final Boolean KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    public final TransferParticipant getAuthRequestContext;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    public final String PlaceComponentResult;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    public final String MyBillsEntityDataFactory;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    public final String BuiltInFictitiousFunctionClassFactory;

    /* renamed from: lookAheadTest  reason: from kotlin metadata */
    public final String moveToNextValue;
    public final String scheduleImpl;

    public TransferInitRequest() {
        this(null, null, null, null, null, null, null, 127, null);
    }

    private TransferInitRequest(String str, String str2, Boolean bool, String str3, String str4, String str5, TransferParticipant transferParticipant) {
        this.MyBillsEntityDataFactory = str;
        this.BuiltInFictitiousFunctionClassFactory = str2;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = bool;
        this.moveToNextValue = str3;
        this.scheduleImpl = str4;
        this.PlaceComponentResult = str5;
        this.getAuthRequestContext = transferParticipant;
    }

    public /* synthetic */ TransferInitRequest(String str, String str2, Boolean bool, String str3, String str4, String str5, TransferParticipant transferParticipant, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : bool, (i & 8) != 0 ? null : str3, (i & 16) != 0 ? null : str4, (i & 32) != 0 ? null : str5, (i & 64) != 0 ? null : transferParticipant);
    }
}
