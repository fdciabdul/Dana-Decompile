package id.dana.utils.config.model;

import com.alibaba.fastjson.annotation.JSONField;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0015\b\u0086\b\u0018\u00002\u00020\u0001B[\u0012\n\b\u0001\u0010\u0002\u001a\u0004\u0018\u00010\t\u0012\n\b\u0001\u0010\u0017\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0001\u0010\u0018\u001a\u0004\u0018\u00010\t\u0012\n\b\u0001\u0010\u0019\u001a\u0004\u0018\u00010\t\u0012\n\b\u0001\u0010\u001a\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0001\u0010\u001b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0001\u0010\u001c\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u001d\u0010\u001eJ\u001a\u0010\u0004\u001a\u00020\u00032\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0007\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bR\u0013\u0010\u000e\u001a\u0004\u0018\u00010\tX\u0006¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0013\u0010\u000f\u001a\u0004\u0018\u00010\tX\u0006¢\u0006\u0006\n\u0004\b\u000f\u0010\rR\u0013\u0010\u0011\u001a\u0004\u0018\u00010\tX\u0006¢\u0006\u0006\n\u0004\b\u0010\u0010\rR\u0013\u0010\f\u001a\u0004\u0018\u00010\u0006X\u0006¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0013\u0010\u0010\u001a\u0004\u0018\u00010\u0006X\u0006¢\u0006\u0006\n\u0004\b\u000e\u0010\u0012R\u0013\u0010\u0014\u001a\u0004\u0018\u00010\u0006X\u0006¢\u0006\u0006\n\u0004\b\u0013\u0010\u0012R\u0013\u0010\u0016\u001a\u0004\u0018\u00010\tX\u0006¢\u0006\u0006\n\u0004\b\u0015\u0010\r"}, d2 = {"Lid/dana/utils/config/model/Cpu;", "", "p0", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "getAuthRequestContext", "Ljava/lang/String;", "PlaceComponentResult", "KClassImpl$Data$declaredNonStaticMembers$2", "MyBillsEntityDataFactory", "BuiltInFictitiousFunctionClassFactory", "Ljava/lang/Integer;", "getErrorConfigVersion", "scheduleImpl", "lookAheadTest", "moveToNextValue", "p1", "p2", "p3", "p4", "p5", "p6", "<init>", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final /* data */ class Cpu {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    public Integer getAuthRequestContext;
    public String KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    public String BuiltInFictitiousFunctionClassFactory;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    public Integer MyBillsEntityDataFactory;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    public String PlaceComponentResult;

    /* renamed from: getErrorConfigVersion  reason: from kotlin metadata */
    public Integer scheduleImpl;

    /* renamed from: lookAheadTest  reason: from kotlin metadata */
    public String moveToNextValue;

    public /* synthetic */ Cpu() {
    }

    public final boolean equals(Object p0) {
        if (this == p0) {
            return true;
        }
        if (p0 instanceof Cpu) {
            Cpu cpu = (Cpu) p0;
            return Intrinsics.areEqual(this.PlaceComponentResult, cpu.PlaceComponentResult) && Intrinsics.areEqual(this.getAuthRequestContext, cpu.getAuthRequestContext) && Intrinsics.areEqual(this.KClassImpl$Data$declaredNonStaticMembers$2, cpu.KClassImpl$Data$declaredNonStaticMembers$2) && Intrinsics.areEqual(this.BuiltInFictitiousFunctionClassFactory, cpu.BuiltInFictitiousFunctionClassFactory) && Intrinsics.areEqual(this.MyBillsEntityDataFactory, cpu.MyBillsEntityDataFactory) && Intrinsics.areEqual(this.moveToNextValue, cpu.moveToNextValue) && Intrinsics.areEqual(this.scheduleImpl, cpu.scheduleImpl);
        }
        return false;
    }

    public final int hashCode() {
        String str = this.PlaceComponentResult;
        int hashCode = str == null ? 0 : str.hashCode();
        Integer num = this.getAuthRequestContext;
        int hashCode2 = num == null ? 0 : num.hashCode();
        String str2 = this.KClassImpl$Data$declaredNonStaticMembers$2;
        int hashCode3 = str2 == null ? 0 : str2.hashCode();
        String str3 = this.BuiltInFictitiousFunctionClassFactory;
        int hashCode4 = str3 == null ? 0 : str3.hashCode();
        Integer num2 = this.MyBillsEntityDataFactory;
        int hashCode5 = num2 == null ? 0 : num2.hashCode();
        String str4 = this.moveToNextValue;
        int hashCode6 = str4 == null ? 0 : str4.hashCode();
        Integer num3 = this.scheduleImpl;
        return (((((((((((hashCode * 31) + hashCode2) * 31) + hashCode3) * 31) + hashCode4) * 31) + hashCode5) * 31) + hashCode6) * 31) + (num3 != null ? num3.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Cpu(PlaceComponentResult=");
        sb.append(this.PlaceComponentResult);
        sb.append(", getAuthRequestContext=");
        sb.append(this.getAuthRequestContext);
        sb.append(", KClassImpl$Data$declaredNonStaticMembers$2=");
        sb.append(this.KClassImpl$Data$declaredNonStaticMembers$2);
        sb.append(", BuiltInFictitiousFunctionClassFactory=");
        sb.append(this.BuiltInFictitiousFunctionClassFactory);
        sb.append(", MyBillsEntityDataFactory=");
        sb.append(this.MyBillsEntityDataFactory);
        sb.append(", moveToNextValue=");
        sb.append(this.moveToNextValue);
        sb.append(", scheduleImpl=");
        sb.append(this.scheduleImpl);
        sb.append(')');
        return sb.toString();
    }

    public Cpu(@JSONField(name = "cpuABI") String str, @JSONField(name = "cpuCurFreq") Integer num, @JSONField(name = "cpuABI2") String str2, @JSONField(name = "cpuArchitecture") String str3, @JSONField(name = "cpuMaxFreq") Integer num2, @JSONField(name = "cpuName") String str4, @JSONField(name = "cpuMinFreq") Integer num3) {
        this.PlaceComponentResult = str;
        this.getAuthRequestContext = num;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = str2;
        this.BuiltInFictitiousFunctionClassFactory = str3;
        this.MyBillsEntityDataFactory = num2;
        this.moveToNextValue = str4;
        this.scheduleImpl = num3;
    }
}
