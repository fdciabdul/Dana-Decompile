package io.split.android.engine.experiments;

import com.google.common.collect.ImmutableList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

/* loaded from: classes6.dex */
public class ParsedSplit {
    public final long BuiltInFictitiousFunctionClassFactory;
    public final Map<String, String> KClassImpl$Data$declaredNonStaticMembers$2;
    public final int MyBillsEntityDataFactory;
    public final int NetworkUserEntityData$$ExternalSyntheticLambda0;
    public final ImmutableList<ParsedCondition> PlaceComponentResult;
    public final String getAuthRequestContext;
    public final String getErrorConfigVersion;
    private final boolean initRecordTimeStamp;
    public final String lookAheadTest;
    public final int moveToNextValue;
    public final int scheduleImpl;

    public ParsedSplit(String str, int i, boolean z, String str2, List<ParsedCondition> list, String str3, long j, int i2, int i3, int i4, Map<String, String> map) {
        this.getErrorConfigVersion = str;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = i;
        this.initRecordTimeStamp = z;
        this.getAuthRequestContext = str2;
        this.PlaceComponentResult = ImmutableList.copyOf((Collection) list);
        this.lookAheadTest = str3;
        this.BuiltInFictitiousFunctionClassFactory = j;
        this.MyBillsEntityDataFactory = i4;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = map;
        if (str2 == null) {
            throw new IllegalArgumentException("DefaultTreatment is null");
        }
        this.moveToNextValue = i2;
        this.scheduleImpl = i3;
    }

    public final boolean PlaceComponentResult() {
        return this.initRecordTimeStamp;
    }

    public int hashCode() {
        int hashCode = this.getErrorConfigVersion.hashCode();
        int i = this.NetworkUserEntityData$$ExternalSyntheticLambda0;
        boolean z = this.initRecordTimeStamp;
        int hashCode2 = this.getAuthRequestContext.hashCode();
        int hashCode3 = this.PlaceComponentResult.hashCode();
        String str = this.lookAheadTest;
        int hashCode4 = str == null ? 0 : str.hashCode();
        long j = this.BuiltInFictitiousFunctionClassFactory;
        int i2 = (int) (j ^ (j >>> 32));
        int i3 = this.MyBillsEntityDataFactory;
        return ((((((((((((((hashCode + 527) * 31) + (i ^ (i >>> 32))) * 31) + (z ? 1 : 0)) * 31) + hashCode2) * 31) + hashCode3) * 31) + hashCode4) * 31) + i2) * 31) + ((i3 >>> 32) ^ i3);
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (obj instanceof ParsedSplit) {
            ParsedSplit parsedSplit = (ParsedSplit) obj;
            if (this.getErrorConfigVersion.equals(parsedSplit.getErrorConfigVersion) && this.NetworkUserEntityData$$ExternalSyntheticLambda0 == parsedSplit.NetworkUserEntityData$$ExternalSyntheticLambda0 && this.initRecordTimeStamp == parsedSplit.initRecordTimeStamp && this.getAuthRequestContext.equals(parsedSplit.getAuthRequestContext) && this.PlaceComponentResult.equals(parsedSplit.PlaceComponentResult)) {
                String str = this.lookAheadTest;
                if (str == null) {
                    if (parsedSplit.lookAheadTest != null) {
                        return false;
                    }
                } else if (!str.equals(parsedSplit.lookAheadTest)) {
                    return false;
                }
                if (this.BuiltInFictitiousFunctionClassFactory == parsedSplit.BuiltInFictitiousFunctionClassFactory && this.MyBillsEntityDataFactory == parsedSplit.MyBillsEntityDataFactory) {
                    Map<String, String> map = this.KClassImpl$Data$declaredNonStaticMembers$2;
                    Map<String, String> map2 = parsedSplit.KClassImpl$Data$declaredNonStaticMembers$2;
                    if (map == null) {
                        if (map2 != null) {
                            return false;
                        }
                    } else if (!map.equals(map2)) {
                        return false;
                    }
                    return true;
                }
                return false;
            }
            return false;
        }
        return false;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("name:");
        sb.append(this.getErrorConfigVersion);
        sb.append(", seed:");
        sb.append(this.NetworkUserEntityData$$ExternalSyntheticLambda0);
        sb.append(", killed:");
        sb.append(this.initRecordTimeStamp);
        sb.append(", default treatment:");
        sb.append(this.getAuthRequestContext);
        sb.append(", parsedConditions:");
        sb.append(this.PlaceComponentResult);
        sb.append(", trafficTypeName:");
        sb.append(this.lookAheadTest);
        sb.append(", changeNumber:");
        sb.append(this.BuiltInFictitiousFunctionClassFactory);
        sb.append(", algo:");
        sb.append(this.MyBillsEntityDataFactory);
        sb.append(", config:");
        sb.append(this.KClassImpl$Data$declaredNonStaticMembers$2);
        return sb.toString();
    }
}
