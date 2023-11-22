package id.dana.social.model;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\b\u0086\b\u0018\u00002\u00020\u0001B\u0099\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u000b\u0012\u0006\u0010\u001e\u001a\u00020\u000b\u0012\u0006\u0010\u001f\u001a\u00020\b\u0012\u0006\u0010 \u001a\u00020\b\u0012\u000e\b\u0002\u0010!\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e\u0012&\u0010\"\u001a\"\u0012\u0004\u0012\u00020\u000b\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\u0017j\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0006\u0012\u0004\u0018\u00010\u000b`\u0018\u0012.\b\u0002\u0010#\u001a(\u0012$\u0012\"\u0012\u0004\u0012\u00020\u000b\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\u0017j\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0006\u0012\u0004\u0018\u00010\u000b`\u00180\u000e\u0012\b\b\u0002\u0010$\u001a\u00020\u0003¢\u0006\u0004\b%\u0010&J\u001a\u0010\u0004\u001a\u00020\u00032\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0006\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rR\u0018\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eX\u0086\u0002¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0012\u0010\u0010\u001a\u00020\bX\u0086\u0002¢\u0006\u0006\n\u0004\b\u0006\u0010\u0013R\u0012\u0010\u0014\u001a\u00020\bX\u0086\u0002¢\u0006\u0006\n\u0004\b\u0014\u0010\u0013R\u0012\u0010\u0016\u001a\u00020\u000bX\u0086\u0002¢\u0006\u0006\n\u0004\b\u0012\u0010\u0015R1\u0010\u0006\u001a\"\u0012\u0004\u0012\u00020\u000b\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\u0017j\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0006\u0012\u0004\u0018\u00010\u000b`\u0018X\u0006¢\u0006\u0006\n\u0004\b\u0016\u0010\u0019R\u0012\u0010\u001a\u001a\u00020\u000bX\u0086\u0002¢\u0006\u0006\n\u0004\b\u001a\u0010\u0015R8\u0010\u001b\u001a(\u0012$\u0012\"\u0012\u0004\u0012\u00020\u000b\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\u0017j\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0006\u0012\u0004\u0018\u00010\u000b`\u00180\u000eX\u0086\u0002¢\u0006\u0006\n\u0004\b\u001b\u0010\u0011R\u001a\u0010\u001c\u001a\u00020\u00038\u0007X\u0086\u0006¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u0010\u0010\u0007"}, d2 = {"Lid/dana/social/model/GroupedFeedModel;", "", "p0", "", "equals", "(Ljava/lang/Object;)Z", "PlaceComponentResult", "()Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "", "Lid/dana/social/model/FeedModel;", "MyBillsEntityDataFactory", "Ljava/util/List;", "BuiltInFictitiousFunctionClassFactory", "I", "KClassImpl$Data$declaredNonStaticMembers$2", "Ljava/lang/String;", "getAuthRequestContext", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "Ljava/util/HashMap;", "moveToNextValue", "getErrorConfigVersion", "scheduleImpl", "Z", "p1", "p2", "p3", "p4", "p5", "p6", "p7", "<init>", "(Ljava/lang/String;Ljava/lang/String;IILjava/util/List;Ljava/util/HashMap;Ljava/util/List;Z)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class GroupedFeedModel {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    public String getAuthRequestContext;
    public int KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    public List<FeedModel> BuiltInFictitiousFunctionClassFactory;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    public int MyBillsEntityDataFactory;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    public final HashMap<String, String> PlaceComponentResult;
    public List<? extends HashMap<String, String>> getErrorConfigVersion;
    public String moveToNextValue;
    public boolean scheduleImpl;

    public final boolean equals(Object p0) {
        if (this == p0) {
            return true;
        }
        if (p0 instanceof GroupedFeedModel) {
            GroupedFeedModel groupedFeedModel = (GroupedFeedModel) p0;
            return Intrinsics.areEqual(this.moveToNextValue, groupedFeedModel.moveToNextValue) && Intrinsics.areEqual(this.getAuthRequestContext, groupedFeedModel.getAuthRequestContext) && this.MyBillsEntityDataFactory == groupedFeedModel.MyBillsEntityDataFactory && this.KClassImpl$Data$declaredNonStaticMembers$2 == groupedFeedModel.KClassImpl$Data$declaredNonStaticMembers$2 && Intrinsics.areEqual(this.BuiltInFictitiousFunctionClassFactory, groupedFeedModel.BuiltInFictitiousFunctionClassFactory) && Intrinsics.areEqual(this.PlaceComponentResult, groupedFeedModel.PlaceComponentResult) && Intrinsics.areEqual(this.getErrorConfigVersion, groupedFeedModel.getErrorConfigVersion) && this.scheduleImpl == groupedFeedModel.scheduleImpl;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final int hashCode() {
        int hashCode = this.moveToNextValue.hashCode();
        int hashCode2 = this.getAuthRequestContext.hashCode();
        int i = this.MyBillsEntityDataFactory;
        int i2 = this.KClassImpl$Data$declaredNonStaticMembers$2;
        int hashCode3 = this.BuiltInFictitiousFunctionClassFactory.hashCode();
        int hashCode4 = this.PlaceComponentResult.hashCode();
        int hashCode5 = this.getErrorConfigVersion.hashCode();
        boolean z = this.scheduleImpl;
        int i3 = z;
        if (z != 0) {
            i3 = 1;
        }
        return (((((((((((((hashCode * 31) + hashCode2) * 31) + i) * 31) + i2) * 31) + hashCode3) * 31) + hashCode4) * 31) + hashCode5) * 31) + i3;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("GroupedFeedModel(moveToNextValue=");
        sb.append(this.moveToNextValue);
        sb.append(", getAuthRequestContext=");
        sb.append(this.getAuthRequestContext);
        sb.append(", MyBillsEntityDataFactory=");
        sb.append(this.MyBillsEntityDataFactory);
        sb.append(", KClassImpl$Data$declaredNonStaticMembers$2=");
        sb.append(this.KClassImpl$Data$declaredNonStaticMembers$2);
        sb.append(", BuiltInFictitiousFunctionClassFactory=");
        sb.append(this.BuiltInFictitiousFunctionClassFactory);
        sb.append(", PlaceComponentResult=");
        sb.append(this.PlaceComponentResult);
        sb.append(", getErrorConfigVersion=");
        sb.append(this.getErrorConfigVersion);
        sb.append(", scheduleImpl=");
        sb.append(this.scheduleImpl);
        sb.append(')');
        return sb.toString();
    }

    public GroupedFeedModel(String str, String str2, int i, int i2, List<FeedModel> list, HashMap<String, String> hashMap, List<? extends HashMap<String, String>> list2, boolean z) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str2, "");
        Intrinsics.checkNotNullParameter(list, "");
        Intrinsics.checkNotNullParameter(hashMap, "");
        Intrinsics.checkNotNullParameter(list2, "");
        this.moveToNextValue = str;
        this.getAuthRequestContext = str2;
        this.MyBillsEntityDataFactory = i;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = i2;
        this.BuiltInFictitiousFunctionClassFactory = list;
        this.PlaceComponentResult = hashMap;
        this.getErrorConfigVersion = list2;
        this.scheduleImpl = z;
    }

    public /* synthetic */ GroupedFeedModel(String str, String str2, int i, int i2, List list, HashMap hashMap, List list2, boolean z, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, i, i2, (i3 & 16) != 0 ? CollectionsKt.emptyList() : list, hashMap, (i3 & 64) != 0 ? CollectionsKt.emptyList() : list2, (i3 & 128) != 0 ? false : z);
    }

    @JvmName(name = "MyBillsEntityDataFactory")
    /* renamed from: MyBillsEntityDataFactory  reason: from getter */
    public final boolean getScheduleImpl() {
        return this.scheduleImpl;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean PlaceComponentResult() {
        Object obj;
        Iterator<T> it = this.BuiltInFictitiousFunctionClassFactory.iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (((FeedModel) obj).getInitRecordTimeStamp()) {
                break;
            }
        }
        FeedModel feedModel = (FeedModel) obj;
        if (feedModel != null) {
            return feedModel.getInitRecordTimeStamp();
        }
        return false;
    }
}
