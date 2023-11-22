package id.dana.social.model;

import id.dana.data.config.source.sharedpreference.SocialFeedModelEntityData;
import id.dana.data.config.source.sharedpreference.SocialFeedWrapperModelEntityData;
import id.dana.social.model.SocialFeedModel;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\n\b\u0086\b\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aB\u001f\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0003¢\u0006\u0004\b\u0018\u0010\u0019J\u001a\u0010\u0004\u001a\u00020\u00032\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0007\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\r\u0010\n\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eR\u0017\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fX\u0006¢\u0006\u0006\n\u0004\b\n\u0010\u0011R\u0017\u0010\n\u001a\u00020\u00038\u0007¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016"}, d2 = {"Lid/dana/social/model/SocialFeedWrapperModel;", "", "p0", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "Lid/dana/data/config/source/sharedpreference/SocialFeedWrapperModelEntityData;", "getAuthRequestContext", "()Lid/dana/data/config/source/sharedpreference/SocialFeedWrapperModelEntityData;", "", "toString", "()Ljava/lang/String;", "", "Lid/dana/social/model/SocialFeedModel;", "Ljava/util/List;", "BuiltInFictitiousFunctionClassFactory", "KClassImpl$Data$declaredNonStaticMembers$2", "Z", "PlaceComponentResult", "()Z", "p1", "<init>", "(Ljava/util/List;Z)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class SocialFeedWrapperModel {

    /* renamed from: Companion  reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    private final boolean getAuthRequestContext;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    public final List<SocialFeedModel> BuiltInFictitiousFunctionClassFactory;

    public final boolean equals(Object p0) {
        if (this == p0) {
            return true;
        }
        if (p0 instanceof SocialFeedWrapperModel) {
            SocialFeedWrapperModel socialFeedWrapperModel = (SocialFeedWrapperModel) p0;
            return Intrinsics.areEqual(this.BuiltInFictitiousFunctionClassFactory, socialFeedWrapperModel.BuiltInFictitiousFunctionClassFactory) && this.getAuthRequestContext == socialFeedWrapperModel.getAuthRequestContext;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final int hashCode() {
        int hashCode = this.BuiltInFictitiousFunctionClassFactory.hashCode();
        boolean z = this.getAuthRequestContext;
        int i = z;
        if (z != 0) {
            i = 1;
        }
        return (hashCode * 31) + i;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("SocialFeedWrapperModel(BuiltInFictitiousFunctionClassFactory=");
        sb.append(this.BuiltInFictitiousFunctionClassFactory);
        sb.append(", getAuthRequestContext=");
        sb.append(this.getAuthRequestContext);
        sb.append(')');
        return sb.toString();
    }

    public SocialFeedWrapperModel(List<SocialFeedModel> list, boolean z) {
        Intrinsics.checkNotNullParameter(list, "");
        this.BuiltInFictitiousFunctionClassFactory = list;
        this.getAuthRequestContext = z;
    }

    @JvmName(name = "PlaceComponentResult")
    /* renamed from: PlaceComponentResult  reason: from getter */
    public final boolean getGetAuthRequestContext() {
        return this.getAuthRequestContext;
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lid/dana/social/model/SocialFeedWrapperModel$Companion;", "", "Lid/dana/data/config/source/sharedpreference/SocialFeedWrapperModelEntityData;", "p0", "Lid/dana/social/model/SocialFeedWrapperModel;", "MyBillsEntityDataFactory", "(Lid/dana/data/config/source/sharedpreference/SocialFeedWrapperModelEntityData;)Lid/dana/social/model/SocialFeedWrapperModel;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public static SocialFeedWrapperModel MyBillsEntityDataFactory(SocialFeedWrapperModelEntityData p0) {
            Intrinsics.checkNotNullParameter(p0, "");
            Companion companion = SocialFeedWrapperModel.INSTANCE;
            List<SocialFeedModelEntityData> data = p0.getData();
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(data, 10));
            for (SocialFeedModelEntityData socialFeedModelEntityData : data) {
                SocialFeedModel.Companion companion2 = SocialFeedModel.INSTANCE;
                arrayList.add(SocialFeedModel.Companion.MyBillsEntityDataFactory(socialFeedModelEntityData));
            }
            return new SocialFeedWrapperModel(arrayList, p0.getFromCache());
        }
    }

    public final SocialFeedWrapperModelEntityData getAuthRequestContext() {
        List<SocialFeedModel> list = this.BuiltInFictitiousFunctionClassFactory;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        for (Iterator it = list.iterator(); it.hasNext(); it = it) {
            SocialFeedModel socialFeedModel = (SocialFeedModel) it.next();
            String str = socialFeedModel.scheduleImpl;
            String str2 = socialFeedModel.lookAheadTest;
            String str3 = socialFeedModel.getAuthRequestContext;
            String str4 = socialFeedModel.NetworkUserEntityData$$ExternalSyntheticLambda0;
            String str5 = socialFeedModel.getErrorConfigVersion;
            HashMap<String, String> hashMap = socialFeedModel.PlaceComponentResult;
            Long l = socialFeedModel.BuiltInFictitiousFunctionClassFactory;
            String str6 = socialFeedModel.KClassImpl$Data$declaredNonStaticMembers$2;
            int i = socialFeedModel.MyBillsEntityDataFactory;
            arrayList.add(new SocialFeedModelEntityData(str, str2, str3, str4, str5, hashMap, l, str6, Integer.valueOf(i), socialFeedModel.moveToNextValue, Integer.valueOf(socialFeedModel.GetContactSyncConfig)));
        }
        return new SocialFeedWrapperModelEntityData(arrayList, this.getAuthRequestContext);
    }
}
