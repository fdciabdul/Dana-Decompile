package id.dana.mybills.ui.v2.billdetail.view;

import id.dana.mybills.ui.model.MoneyViewModel;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001:\u0002\b\tB\u0011\b\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0003\u001a\u00020\u0002X\u0006¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004"}, d2 = {"Lid/dana/mybills/ui/v2/billdetail/view/BillDetailView;", "", "Lid/dana/mybills/ui/v2/billdetail/view/BillDetailView$Builder;", "BuiltInFictitiousFunctionClassFactory", "Lid/dana/mybills/ui/v2/billdetail/view/BillDetailView$Builder;", "p0", "<init>", "(Lid/dana/mybills/ui/v2/billdetail/view/BillDetailView$Builder;)V", "Builder", "Copyable"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes9.dex */
public final class BillDetailView {
    public final Builder BuiltInFictitiousFunctionClassFactory;

    public /* synthetic */ BillDetailView(Builder builder, DefaultConstructorMarker defaultConstructorMarker) {
        this(builder);
    }

    private BillDetailView(Builder builder) {
        this.BuiltInFictitiousFunctionClassFactory = builder;
    }

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\t\u0012\u0006\u0010\u0015\u001a\u00020\u0006\u0012\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f¢\u0006\u0004\b\u0017\u0010\u0018J\u001a\u0010\u0004\u001a\u00020\u00032\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0007\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bR\u0011\u0010\u000e\u001a\u00020\u0006X\u0006¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0017\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fX\u0006¢\u0006\u0006\n\u0004\b\u000e\u0010\u0011R\u0011\u0010\u0014\u001a\u00020\tX\u0006¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013"}, d2 = {"Lid/dana/mybills/ui/v2/billdetail/view/BillDetailView$Copyable;", "", "p0", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "PlaceComponentResult", "I", "getAuthRequestContext", "Lkotlin/Function0;", "", "Lkotlin/jvm/functions/Function0;", "MyBillsEntityDataFactory", "Ljava/lang/String;", "BuiltInFictitiousFunctionClassFactory", "p1", "p2", "<init>", "(Ljava/lang/String;ILkotlin/jvm/functions/Function0;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes9.dex */
    public static final /* data */ class Copyable {

        /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
        public final String BuiltInFictitiousFunctionClassFactory;

        /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
        public final int getAuthRequestContext;

        /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
        public final Function0<Unit> MyBillsEntityDataFactory;

        public final boolean equals(Object p0) {
            if (this == p0) {
                return true;
            }
            if (p0 instanceof Copyable) {
                Copyable copyable = (Copyable) p0;
                return Intrinsics.areEqual(this.BuiltInFictitiousFunctionClassFactory, copyable.BuiltInFictitiousFunctionClassFactory) && this.getAuthRequestContext == copyable.getAuthRequestContext && Intrinsics.areEqual(this.MyBillsEntityDataFactory, copyable.MyBillsEntityDataFactory);
            }
            return false;
        }

        public final int hashCode() {
            return (((this.BuiltInFictitiousFunctionClassFactory.hashCode() * 31) + this.getAuthRequestContext) * 31) + this.MyBillsEntityDataFactory.hashCode();
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("Copyable(BuiltInFictitiousFunctionClassFactory=");
            sb.append(this.BuiltInFictitiousFunctionClassFactory);
            sb.append(", getAuthRequestContext=");
            sb.append(this.getAuthRequestContext);
            sb.append(", MyBillsEntityDataFactory=");
            sb.append(this.MyBillsEntityDataFactory);
            sb.append(')');
            return sb.toString();
        }

        public Copyable(String str, int i, Function0<Unit> function0) {
            Intrinsics.checkNotNullParameter(str, "");
            Intrinsics.checkNotNullParameter(function0, "");
            this.BuiltInFictitiousFunctionClassFactory = str;
            this.getAuthRequestContext = i;
            this.MyBillsEntityDataFactory = function0;
        }
    }

    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010%\n\u0002\b\u0011\b\u0086\b\u0018\u00002\u00020\u0001B\u008b\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u000f\u0012\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010%\u001a\u0004\u0018\u00010\u0013\u0012\u0016\b\u0002\u0010&\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0018\u0012\n\b\u0002\u0010'\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b(\u0010)J\u001a\u0010\u0004\u001a\u00020\u00032\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0007\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u001f\u0010\n\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eR\u0014\u0010\u0012\u001a\u0004\u0018\u00010\u000fX\u0086\u0002¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u00138\u0007X\u0086\u0006¢\u0006\f\n\u0004\b\n\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\"\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00188\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0019R\u0014\u0010\u0010\u001a\u0004\u0018\u00010\fX\u0087\u0002¢\u0006\u0006\n\u0004\b\u0017\u0010\u001aR\u0014\u0010\u0015\u001a\u0004\u0018\u00010\fX\u0087\u0002¢\u0006\u0006\n\u0004\b\u0012\u0010\u001aR\u0014\u0010\u001c\u001a\u0004\u0018\u00010\fX\u0087\u0002¢\u0006\u0006\n\u0004\b\u001b\u0010\u001aR\u0014\u0010\u001d\u001a\u0004\u0018\u00010\fX\u0087\u0002¢\u0006\u0006\n\u0004\b\u001d\u0010\u001aR\u0014\u0010\u001e\u001a\u0004\u0018\u00010\fX\u0087\u0002¢\u0006\u0006\n\u0004\b\u001c\u0010\u001aR\u0014\u0010\u001f\u001a\u0004\u0018\u00010\fX\u0087\u0002¢\u0006\u0006\n\u0004\b\u001f\u0010\u001aR\u0014\u0010\u001b\u001a\u0004\u0018\u00010\fX\u0087\u0002¢\u0006\u0006\n\u0004\b\u001e\u0010\u001a"}, d2 = {"Lid/dana/mybills/ui/v2/billdetail/view/BillDetailView$Builder;", "", "p0", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "p1", "BuiltInFictitiousFunctionClassFactory", "(ILjava/lang/Object;)Lid/dana/mybills/ui/v2/billdetail/view/BillDetailView$Builder;", "", "toString", "()Ljava/lang/String;", "Lid/dana/mybills/ui/model/MoneyViewModel;", "KClassImpl$Data$declaredNonStaticMembers$2", "Lid/dana/mybills/ui/model/MoneyViewModel;", "MyBillsEntityDataFactory", "", "Ljava/lang/Long;", "PlaceComponentResult", "()Ljava/lang/Long;", "getAuthRequestContext", "", "Ljava/util/Map;", "Ljava/lang/String;", "getErrorConfigVersion", "scheduleImpl", "lookAheadTest", "moveToNextValue", "NetworkUserEntityData$$ExternalSyntheticLambda0", "p2", "p3", "p4", "p5", "p6", "p7", "p8", "p9", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lid/dana/mybills/ui/model/MoneyViewModel;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/util/Map;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes9.dex */
    public static final /* data */ class Builder {

        /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
        public Long getAuthRequestContext;

        /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
        public MoneyViewModel MyBillsEntityDataFactory;

        /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
        public String PlaceComponentResult;
        public String NetworkUserEntityData$$ExternalSyntheticLambda0;

        /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
        public final Map<Integer, Object> BuiltInFictitiousFunctionClassFactory;

        /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
        public String KClassImpl$Data$declaredNonStaticMembers$2;

        /* renamed from: getErrorConfigVersion  reason: from kotlin metadata */
        public String scheduleImpl;
        public String lookAheadTest;

        /* renamed from: moveToNextValue  reason: from kotlin metadata */
        public String getErrorConfigVersion;

        /* renamed from: scheduleImpl  reason: from kotlin metadata */
        public String moveToNextValue;

        public Builder() {
            this(null, null, null, null, null, null, null, null, null, null, 1023, null);
        }

        public final boolean equals(Object p0) {
            if (this == p0) {
                return true;
            }
            if (p0 instanceof Builder) {
                Builder builder = (Builder) p0;
                return Intrinsics.areEqual(this.getErrorConfigVersion, builder.getErrorConfigVersion) && Intrinsics.areEqual(this.NetworkUserEntityData$$ExternalSyntheticLambda0, builder.NetworkUserEntityData$$ExternalSyntheticLambda0) && Intrinsics.areEqual(this.KClassImpl$Data$declaredNonStaticMembers$2, builder.KClassImpl$Data$declaredNonStaticMembers$2) && Intrinsics.areEqual(this.PlaceComponentResult, builder.PlaceComponentResult) && Intrinsics.areEqual(this.MyBillsEntityDataFactory, builder.MyBillsEntityDataFactory) && Intrinsics.areEqual(this.scheduleImpl, builder.scheduleImpl) && Intrinsics.areEqual(this.lookAheadTest, builder.lookAheadTest) && Intrinsics.areEqual(this.getAuthRequestContext, builder.getAuthRequestContext) && Intrinsics.areEqual(this.BuiltInFictitiousFunctionClassFactory, builder.BuiltInFictitiousFunctionClassFactory) && Intrinsics.areEqual(this.moveToNextValue, builder.moveToNextValue);
            }
            return false;
        }

        public final int hashCode() {
            String str = this.getErrorConfigVersion;
            int hashCode = str == null ? 0 : str.hashCode();
            String str2 = this.NetworkUserEntityData$$ExternalSyntheticLambda0;
            int hashCode2 = str2 == null ? 0 : str2.hashCode();
            String str3 = this.KClassImpl$Data$declaredNonStaticMembers$2;
            int hashCode3 = str3 == null ? 0 : str3.hashCode();
            String str4 = this.PlaceComponentResult;
            int hashCode4 = str4 == null ? 0 : str4.hashCode();
            MoneyViewModel moneyViewModel = this.MyBillsEntityDataFactory;
            int hashCode5 = moneyViewModel == null ? 0 : moneyViewModel.hashCode();
            String str5 = this.scheduleImpl;
            int hashCode6 = str5 == null ? 0 : str5.hashCode();
            String str6 = this.lookAheadTest;
            int hashCode7 = str6 == null ? 0 : str6.hashCode();
            Long l = this.getAuthRequestContext;
            int hashCode8 = l == null ? 0 : l.hashCode();
            int hashCode9 = this.BuiltInFictitiousFunctionClassFactory.hashCode();
            String str7 = this.moveToNextValue;
            return (((((((((((((((((hashCode * 31) + hashCode2) * 31) + hashCode3) * 31) + hashCode4) * 31) + hashCode5) * 31) + hashCode6) * 31) + hashCode7) * 31) + hashCode8) * 31) + hashCode9) * 31) + (str7 != null ? str7.hashCode() : 0);
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("Builder(getErrorConfigVersion=");
            sb.append(this.getErrorConfigVersion);
            sb.append(", NetworkUserEntityData$$ExternalSyntheticLambda0=");
            sb.append(this.NetworkUserEntityData$$ExternalSyntheticLambda0);
            sb.append(", KClassImpl$Data$declaredNonStaticMembers$2=");
            sb.append(this.KClassImpl$Data$declaredNonStaticMembers$2);
            sb.append(", PlaceComponentResult=");
            sb.append(this.PlaceComponentResult);
            sb.append(", MyBillsEntityDataFactory=");
            sb.append(this.MyBillsEntityDataFactory);
            sb.append(", scheduleImpl=");
            sb.append(this.scheduleImpl);
            sb.append(", lookAheadTest=");
            sb.append(this.lookAheadTest);
            sb.append(", getAuthRequestContext=");
            sb.append(this.getAuthRequestContext);
            sb.append(", BuiltInFictitiousFunctionClassFactory=");
            sb.append(this.BuiltInFictitiousFunctionClassFactory);
            sb.append(", moveToNextValue=");
            sb.append(this.moveToNextValue);
            sb.append(')');
            return sb.toString();
        }

        private Builder(String str, String str2, String str3, String str4, MoneyViewModel moneyViewModel, String str5, String str6, Long l, Map<Integer, Object> map, String str7) {
            Intrinsics.checkNotNullParameter(map, "");
            this.getErrorConfigVersion = str;
            this.NetworkUserEntityData$$ExternalSyntheticLambda0 = str2;
            this.KClassImpl$Data$declaredNonStaticMembers$2 = str3;
            this.PlaceComponentResult = str4;
            this.MyBillsEntityDataFactory = moneyViewModel;
            this.scheduleImpl = str5;
            this.lookAheadTest = str6;
            this.getAuthRequestContext = l;
            this.BuiltInFictitiousFunctionClassFactory = map;
            this.moveToNextValue = str7;
        }

        @JvmName(name = "PlaceComponentResult")
        /* renamed from: PlaceComponentResult  reason: from getter */
        public final Long getGetAuthRequestContext() {
            return this.getAuthRequestContext;
        }

        public /* synthetic */ Builder(String str, String str2, String str3, String str4, MoneyViewModel moneyViewModel, String str5, String str6, Long l, Map map, String str7, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3, (i & 8) != 0 ? null : str4, (i & 16) != 0 ? null : moneyViewModel, (i & 32) != 0 ? null : str5, (i & 64) != 0 ? null : str6, (i & 128) != 0 ? null : l, (i & 256) != 0 ? new LinkedHashMap() : map, (i & 512) == 0 ? str7 : null);
        }

        public final Builder BuiltInFictitiousFunctionClassFactory(int p0, Object p1) {
            this.BuiltInFictitiousFunctionClassFactory.put(Integer.valueOf(p0), p1);
            return this;
        }
    }
}
