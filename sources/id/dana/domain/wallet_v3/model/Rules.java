package id.dana.domain.wallet_v3.model;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0010\b\u0086\b\u0018\u00002\u00020\u0001BU\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0002\u0012\u0010\b\u0002\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b&\u0010'J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0018\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\b\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\b\u0010\u0004J\u0012\u0010\t\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\t\u0010\u0004J\u0012\u0010\n\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\n\u0010\u0004J\u0012\u0010\f\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0004\b\f\u0010\rJ^\u0010\u0014\u001a\u00020\u00002\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00022\u0010\b\u0002\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00052\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u000bHÆ\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u001a\u0010\u0018\u001a\u00020\u00172\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u001a\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u001c\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u001c\u0010\u0004R\u001f\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00058\u0007¢\u0006\f\n\u0004\b\u000f\u0010\u001d\u001a\u0004\b\u001e\u0010\u0007R\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u001f\u001a\u0004\b \u0010\u0004R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u000b8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u0010!\u001a\u0004\b\"\u0010\rR\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u001f\u001a\u0004\b#\u0010\u0004R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u001f\u001a\u0004\b$\u0010\u0004R\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u001f\u001a\u0004\b%\u0010\u0004"}, d2 = {"Lid/dana/domain/wallet_v3/model/Rules;", "", "", "component1", "()Ljava/lang/String;", "", "component2", "()Ljava/util/List;", "component3", "component4", "component5", "", "component6", "()Ljava/lang/Integer;", "basedOn", "assetType", "sectionType", "logicalOperator", "comparisonOperator", "comparator", "copy", "(Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)Lid/dana/domain/wallet_v3/model/Rules;", "other", "", "equals", "(Ljava/lang/Object;)Z", "hashCode", "()I", "toString", "Ljava/util/List;", "getAssetType", "Ljava/lang/String;", "getBasedOn", "Ljava/lang/Integer;", "getComparator", "getComparisonOperator", "getLogicalOperator", "getSectionType", "<init>", "(Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class Rules {
    public List<String> assetType;
    public String basedOn;
    public Integer comparator;
    public String comparisonOperator;
    public String logicalOperator;
    public String sectionType;

    public Rules() {
        this(null, null, null, null, null, null, 63, null);
    }

    public static /* synthetic */ Rules copy$default(Rules rules, String str, List list, String str2, String str3, String str4, Integer num, int i, Object obj) {
        if ((i & 1) != 0) {
            str = rules.basedOn;
        }
        List<String> list2 = list;
        if ((i & 2) != 0) {
            list2 = rules.assetType;
        }
        List list3 = list2;
        if ((i & 4) != 0) {
            str2 = rules.sectionType;
        }
        String str5 = str2;
        if ((i & 8) != 0) {
            str3 = rules.logicalOperator;
        }
        String str6 = str3;
        if ((i & 16) != 0) {
            str4 = rules.comparisonOperator;
        }
        String str7 = str4;
        if ((i & 32) != 0) {
            num = rules.comparator;
        }
        return rules.copy(str, list3, str5, str6, str7, num);
    }

    /* renamed from: component1  reason: from getter */
    public final String getBasedOn() {
        return this.basedOn;
    }

    public final List<String> component2() {
        return this.assetType;
    }

    /* renamed from: component3  reason: from getter */
    public final String getSectionType() {
        return this.sectionType;
    }

    /* renamed from: component4  reason: from getter */
    public final String getLogicalOperator() {
        return this.logicalOperator;
    }

    /* renamed from: component5  reason: from getter */
    public final String getComparisonOperator() {
        return this.comparisonOperator;
    }

    /* renamed from: component6  reason: from getter */
    public final Integer getComparator() {
        return this.comparator;
    }

    public final Rules copy(String basedOn, List<String> assetType, String sectionType, String logicalOperator, String comparisonOperator, Integer comparator) {
        return new Rules(basedOn, assetType, sectionType, logicalOperator, comparisonOperator, comparator);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof Rules) {
            Rules rules = (Rules) other;
            return Intrinsics.areEqual(this.basedOn, rules.basedOn) && Intrinsics.areEqual(this.assetType, rules.assetType) && Intrinsics.areEqual(this.sectionType, rules.sectionType) && Intrinsics.areEqual(this.logicalOperator, rules.logicalOperator) && Intrinsics.areEqual(this.comparisonOperator, rules.comparisonOperator) && Intrinsics.areEqual(this.comparator, rules.comparator);
        }
        return false;
    }

    public final int hashCode() {
        String str = this.basedOn;
        int hashCode = str == null ? 0 : str.hashCode();
        List<String> list = this.assetType;
        int hashCode2 = list == null ? 0 : list.hashCode();
        String str2 = this.sectionType;
        int hashCode3 = str2 == null ? 0 : str2.hashCode();
        String str3 = this.logicalOperator;
        int hashCode4 = str3 == null ? 0 : str3.hashCode();
        String str4 = this.comparisonOperator;
        int hashCode5 = str4 == null ? 0 : str4.hashCode();
        Integer num = this.comparator;
        return (((((((((hashCode * 31) + hashCode2) * 31) + hashCode3) * 31) + hashCode4) * 31) + hashCode5) * 31) + (num != null ? num.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Rules(basedOn=");
        sb.append(this.basedOn);
        sb.append(", assetType=");
        sb.append(this.assetType);
        sb.append(", sectionType=");
        sb.append(this.sectionType);
        sb.append(", logicalOperator=");
        sb.append(this.logicalOperator);
        sb.append(", comparisonOperator=");
        sb.append(this.comparisonOperator);
        sb.append(", comparator=");
        sb.append(this.comparator);
        sb.append(')');
        return sb.toString();
    }

    public Rules(String str, List<String> list, String str2, String str3, String str4, Integer num) {
        this.basedOn = str;
        this.assetType = list;
        this.sectionType = str2;
        this.logicalOperator = str3;
        this.comparisonOperator = str4;
        this.comparator = num;
    }

    public /* synthetic */ Rules(String str, List list, String str2, String str3, String str4, Integer num, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : list, (i & 4) != 0 ? null : str2, (i & 8) != 0 ? null : str3, (i & 16) != 0 ? null : str4, (i & 32) != 0 ? null : num);
    }

    @JvmName(name = "getBasedOn")
    public final String getBasedOn() {
        return this.basedOn;
    }

    @JvmName(name = "getAssetType")
    public final List<String> getAssetType() {
        return this.assetType;
    }

    @JvmName(name = "getSectionType")
    public final String getSectionType() {
        return this.sectionType;
    }

    @JvmName(name = "getLogicalOperator")
    public final String getLogicalOperator() {
        return this.logicalOperator;
    }

    @JvmName(name = "getComparisonOperator")
    public final String getComparisonOperator() {
        return this.comparisonOperator;
    }

    @JvmName(name = "getComparator")
    public final Integer getComparator() {
        return this.comparator;
    }
}
