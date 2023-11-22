package id.dana.sync_engine.data.entity;

import androidx.credentials.webauthn.Cbor$Arg$$ExternalSyntheticBackport0;
import id.dana.sync_engine.domain.model.UserContact;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u000f\b\u0086\b\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001dB=\u0012\u0006\u0010\u0002\u001a\u00020\u000e\u0012\u0006\u0010\u0016\u001a\u00020\t\u0012\u0006\u0010\u0017\u001a\u00020\t\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\t\u0012\b\u0010\u0019\u001a\u0004\u0018\u00010\t\u0012\b\u0010\u001a\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\u001b\u0010\u001cJ\u001a\u0010\u0004\u001a\u00020\u00032\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0007\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bR\u0013\u0010\f\u001a\u0004\u0018\u00010\tX\u0006¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0011\u0010\u0011\u001a\u00020\u000eX\u0006¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0013\u0010\u000f\u001a\u0004\u0018\u00010\tX\u0006¢\u0006\u0006\n\u0004\b\u0012\u0010\rR\u0013\u0010\u0012\u001a\u0004\u0018\u00010\tX\u0006¢\u0006\u0006\n\u0004\b\u0011\u0010\rR\u0011\u0010\u0013\u001a\u00020\tX\u0006¢\u0006\u0006\n\u0004\b\u0013\u0010\rR\u0011\u0010\u0015\u001a\u00020\tX\u0006¢\u0006\u0006\n\u0004\b\u0014\u0010\r"}, d2 = {"Lid/dana/sync_engine/data/entity/DeviceContactEntity;", "", "p0", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "BuiltInFictitiousFunctionClassFactory", "Ljava/lang/String;", "", "KClassImpl$Data$declaredNonStaticMembers$2", "J", "getAuthRequestContext", "PlaceComponentResult", "MyBillsEntityDataFactory", "scheduleImpl", "NetworkUserEntityData$$ExternalSyntheticLambda0", "p1", "p2", "p3", "p4", "p5", "<init>", "(JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class DeviceContactEntity {

    /* renamed from: Companion  reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    final String BuiltInFictitiousFunctionClassFactory;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    final long getAuthRequestContext;
    final String MyBillsEntityDataFactory;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    final String KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    final String PlaceComponentResult;

    /* renamed from: scheduleImpl  reason: from kotlin metadata */
    final String NetworkUserEntityData$$ExternalSyntheticLambda0;

    public final boolean equals(Object p0) {
        if (this == p0) {
            return true;
        }
        if (p0 instanceof DeviceContactEntity) {
            DeviceContactEntity deviceContactEntity = (DeviceContactEntity) p0;
            return this.getAuthRequestContext == deviceContactEntity.getAuthRequestContext && Intrinsics.areEqual(this.MyBillsEntityDataFactory, deviceContactEntity.MyBillsEntityDataFactory) && Intrinsics.areEqual(this.NetworkUserEntityData$$ExternalSyntheticLambda0, deviceContactEntity.NetworkUserEntityData$$ExternalSyntheticLambda0) && Intrinsics.areEqual(this.PlaceComponentResult, deviceContactEntity.PlaceComponentResult) && Intrinsics.areEqual(this.KClassImpl$Data$declaredNonStaticMembers$2, deviceContactEntity.KClassImpl$Data$declaredNonStaticMembers$2) && Intrinsics.areEqual(this.BuiltInFictitiousFunctionClassFactory, deviceContactEntity.BuiltInFictitiousFunctionClassFactory);
        }
        return false;
    }

    public final int hashCode() {
        int m = Cbor$Arg$$ExternalSyntheticBackport0.m(this.getAuthRequestContext);
        int hashCode = this.MyBillsEntityDataFactory.hashCode();
        int hashCode2 = this.NetworkUserEntityData$$ExternalSyntheticLambda0.hashCode();
        String str = this.PlaceComponentResult;
        int hashCode3 = str == null ? 0 : str.hashCode();
        String str2 = this.KClassImpl$Data$declaredNonStaticMembers$2;
        int hashCode4 = str2 == null ? 0 : str2.hashCode();
        String str3 = this.BuiltInFictitiousFunctionClassFactory;
        return (((((((((m * 31) + hashCode) * 31) + hashCode2) * 31) + hashCode3) * 31) + hashCode4) * 31) + (str3 != null ? str3.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("DeviceContactEntity(getAuthRequestContext=");
        sb.append(this.getAuthRequestContext);
        sb.append(", MyBillsEntityDataFactory=");
        sb.append(this.MyBillsEntityDataFactory);
        sb.append(", NetworkUserEntityData$$ExternalSyntheticLambda0=");
        sb.append(this.NetworkUserEntityData$$ExternalSyntheticLambda0);
        sb.append(", PlaceComponentResult=");
        sb.append(this.PlaceComponentResult);
        sb.append(", KClassImpl$Data$declaredNonStaticMembers$2=");
        sb.append(this.KClassImpl$Data$declaredNonStaticMembers$2);
        sb.append(", BuiltInFictitiousFunctionClassFactory=");
        sb.append(this.BuiltInFictitiousFunctionClassFactory);
        sb.append(')');
        return sb.toString();
    }

    public DeviceContactEntity(long j, String str, String str2, String str3, String str4, String str5) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str2, "");
        this.getAuthRequestContext = j;
        this.MyBillsEntityDataFactory = str;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = str2;
        this.PlaceComponentResult = str3;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = str4;
        this.BuiltInFictitiousFunctionClassFactory = str5;
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u0011\u0010\u0004\u001a\u00020\u0003*\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lid/dana/sync_engine/data/entity/DeviceContactEntity$Companion;", "", "Lid/dana/sync_engine/data/entity/DeviceContactEntity;", "Lid/dana/sync_engine/domain/model/UserContact;", "BuiltInFictitiousFunctionClassFactory", "(Lid/dana/sync_engine/data/entity/DeviceContactEntity;)Lid/dana/sync_engine/domain/model/UserContact;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public static UserContact BuiltInFictitiousFunctionClassFactory(DeviceContactEntity deviceContactEntity) {
            Intrinsics.checkNotNullParameter(deviceContactEntity, "");
            return new UserContact(deviceContactEntity.getAuthRequestContext, deviceContactEntity.MyBillsEntityDataFactory, deviceContactEntity.NetworkUserEntityData$$ExternalSyntheticLambda0, deviceContactEntity.PlaceComponentResult, deviceContactEntity.KClassImpl$Data$declaredNonStaticMembers$2, null, null, null, deviceContactEntity.BuiltInFictitiousFunctionClassFactory);
        }
    }
}
