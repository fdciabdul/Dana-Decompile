package id.dana.sendmoney.domain.globalsend.model.init;

import id.dana.sendmoney.data.api.globalsend.init.model.TransferParticipantEntity;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aBW\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u0013\u001a\u00020\t\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\r¢\u0006\u0004\b\u0018\u0010\u0019R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0002X\u0006¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0002X\u0006¢\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0013\u0010\u0003\u001a\u0004\u0018\u00010\u0002X\u0006¢\u0006\u0006\n\u0004\b\b\u0010\u0004R\u0017\u0010\u0006\u001a\u00020\t8\u0007¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\u0003\u0010\fR\u0013\u0010\b\u001a\u0004\u0018\u00010\rX\u0007¢\u0006\u0006\n\u0004\b\u0007\u0010\u000eR\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u0002X\u0007¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0013\u0010\u0010\u001a\u0004\u0018\u00010\u0002X\u0007¢\u0006\u0006\n\u0004\b\u0010\u0010\u0004"}, d2 = {"Lid/dana/sendmoney/domain/globalsend/model/init/GlobalTransferInitRequest;", "", "", "BuiltInFictitiousFunctionClassFactory", "Ljava/lang/String;", "getAuthRequestContext", "KClassImpl$Data$declaredNonStaticMembers$2", "PlaceComponentResult", "MyBillsEntityDataFactory", "", "moveToNextValue", "Z", "()Z", "Lid/dana/sendmoney/data/api/globalsend/init/model/TransferParticipantEntity;", "Lid/dana/sendmoney/data/api/globalsend/init/model/TransferParticipantEntity;", "NetworkUserEntityData$$ExternalSyntheticLambda0", "lookAheadTest", "p0", "p1", "p2", "p3", "p4", "p5", "p6", "<init>", "(Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Lid/dana/sendmoney/data/api/globalsend/init/model/TransferParticipantEntity;)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class GlobalTransferInitRequest {

    /* renamed from: Companion  reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    public final String getAuthRequestContext;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    public final String PlaceComponentResult;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    public final String BuiltInFictitiousFunctionClassFactory;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    public final TransferParticipantEntity MyBillsEntityDataFactory;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    public final String NetworkUserEntityData$$ExternalSyntheticLambda0;
    public final String lookAheadTest;

    /* renamed from: moveToNextValue  reason: from kotlin metadata */
    private final boolean KClassImpl$Data$declaredNonStaticMembers$2;

    private GlobalTransferInitRequest(String str, String str2, boolean z, String str3, String str4, String str5, TransferParticipantEntity transferParticipantEntity) {
        this.PlaceComponentResult = str;
        this.BuiltInFictitiousFunctionClassFactory = str2;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = z;
        this.lookAheadTest = str3;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = str4;
        this.getAuthRequestContext = str5;
        this.MyBillsEntityDataFactory = transferParticipantEntity;
    }

    public /* synthetic */ GlobalTransferInitRequest(String str, String str2, boolean z, String str3, String str4, String str5, TransferParticipantEntity transferParticipantEntity, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, z, (i & 8) != 0 ? null : str3, (i & 16) != 0 ? null : str4, (i & 32) != 0 ? null : str5, (i & 64) != 0 ? null : transferParticipantEntity);
    }

    @JvmName(name = "BuiltInFictitiousFunctionClassFactory")
    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from getter */
    public final boolean getKClassImpl$Data$declaredNonStaticMembers$2() {
        return this.KClassImpl$Data$declaredNonStaticMembers$2;
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\n\u0010\u000bJ\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u001d\u0010\b\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0005¢\u0006\u0004\b\b\u0010\t"}, d2 = {"Lid/dana/sendmoney/domain/globalsend/model/init/GlobalTransferInitRequest$Companion;", "", "Lid/dana/sendmoney/domain/globalsend/model/init/GlobalTransferInitRequest;", "MyBillsEntityDataFactory", "()Lid/dana/sendmoney/domain/globalsend/model/init/GlobalTransferInitRequest;", "", "p0", "p1", "BuiltInFictitiousFunctionClassFactory", "(Ljava/lang/String;Ljava/lang/String;)Lid/dana/sendmoney/domain/globalsend/model/init/GlobalTransferInitRequest;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public static GlobalTransferInitRequest MyBillsEntityDataFactory() {
            return new GlobalTransferInitRequest(null, null, false, null, null, null, null, 123, null);
        }

        public static GlobalTransferInitRequest BuiltInFictitiousFunctionClassFactory(String p0, String p1) {
            Intrinsics.checkNotNullParameter(p0, "");
            Intrinsics.checkNotNullParameter(p1, "");
            return new GlobalTransferInitRequest(p0, p1, true, null, null, null, null, 120, null);
        }
    }
}
