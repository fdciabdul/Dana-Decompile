package id.dana.social.model;

import android.content.Context;
import id.dana.R;
import id.dana.cashier.view.InputCardNumberView;
import id.dana.data.config.source.sharedpreference.SocialFeedModelEntityData;
import id.dana.social.adapter.SocialFeedClickListener;
import id.dana.social.utils.FeedRegexData;
import id.dana.utils.DateTimeUtil;
import java.util.Date;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0013\b\u0086\b\u0018\u0000 02\u00020\u0001:\u00010B\u0095\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010&\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010'\u001a\u0004\u0018\u00010\u000b\u0012\u0018\b\u0002\u0010(\u001a\u0012\u0012\u0004\u0012\u00020\u000b\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0018\u00010\u001d\u0012\n\b\u0002\u0010)\u001a\u0004\u0018\u00010\u001a\u0012\n\b\u0002\u0010*\u001a\u0004\u0018\u00010\u000b\u0012\b\b\u0002\u0010+\u001a\u00020\u0006\u0012\n\b\u0002\u0010,\u001a\u0004\u0018\u00010\u000b\u0012\b\b\u0002\u0010-\u001a\u00020\u0006¢\u0006\u0004\b.\u0010/J\u001a\u0010\u0004\u001a\u00020\u00032\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J)\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0002\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000e\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u001d\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0002\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0010¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0014\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0017\u001a\u00020\u0006X\u0006¢\u0006\u0006\n\u0004\b\f\u0010\u0016R\u0013\u0010\u0012\u001a\u0004\u0018\u00010\u000bX\u0006¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0013\u0010\u0018\u001a\u0004\u0018\u00010\u001aX\u0006¢\u0006\u0006\n\u0004\b\u0012\u0010\u001bR\u0013\u0010\u001c\u001a\u0004\u0018\u00010\u000bX\u0006¢\u0006\u0006\n\u0004\b\u0017\u0010\u0019R!\u0010\f\u001a\u0012\u0012\u0004\u0012\u00020\u000b\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0018\u00010\u001dX\u0006¢\u0006\u0006\n\u0004\b\u001c\u0010\u001eR\u0013\u0010 \u001a\u0004\u0018\u00010\u000bX\u0006¢\u0006\u0006\n\u0004\b\u001f\u0010\u0019R\u0013\u0010\u001f\u001a\u0004\u0018\u00010\u000bX\u0006¢\u0006\u0006\n\u0004\b!\u0010\u0019R\u0013\u0010#\u001a\u0004\u0018\u00010\u000bX\u0006¢\u0006\u0006\n\u0004\b\"\u0010\u0019R\u0013\u0010!\u001a\u0004\u0018\u00010\u000bX\u0006¢\u0006\u0006\n\u0004\b#\u0010\u0019R\u0013\u0010\"\u001a\u0004\u0018\u00010\u000bX\u0006¢\u0006\u0006\n\u0004\b \u0010\u0019R\u0011\u0010%\u001a\u00020\u0006X\u0006¢\u0006\u0006\n\u0004\b$\u0010\u0016"}, d2 = {"Lid/dana/social/model/SocialFeedModel;", "", "p0", "", "equals", "(Ljava/lang/Object;)Z", "", "Ljava/util/Date;", "p1", "Landroid/content/Context;", "p2", "", "PlaceComponentResult", "(ILjava/util/Date;Landroid/content/Context;)Ljava/lang/String;", "hashCode", "()I", "Lid/dana/social/adapter/SocialFeedClickListener;", "Lid/dana/social/utils/FeedRegexData;", "KClassImpl$Data$declaredNonStaticMembers$2", "(Landroid/content/Context;Lid/dana/social/adapter/SocialFeedClickListener;)Lid/dana/social/utils/FeedRegexData;", "toString", "()Ljava/lang/String;", "I", "MyBillsEntityDataFactory", "BuiltInFictitiousFunctionClassFactory", "Ljava/lang/String;", "", "Ljava/lang/Long;", "getAuthRequestContext", "Ljava/util/HashMap;", "Ljava/util/HashMap;", "moveToNextValue", "lookAheadTest", "NetworkUserEntityData$$ExternalSyntheticLambda0", "getErrorConfigVersion", "scheduleImpl", "DatabaseTableConfigUtil", "GetContactSyncConfig", "p3", "p4", "p5", "p6", "p7", "p8", "p9", "p10", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/HashMap;Ljava/lang/Long;Ljava/lang/String;ILjava/lang/String;I)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class SocialFeedModel {

    /* renamed from: Companion  reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    public final String KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: DatabaseTableConfigUtil  reason: from kotlin metadata */
    public final int GetContactSyncConfig;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    public final Long BuiltInFictitiousFunctionClassFactory;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    public final String getAuthRequestContext;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda0  reason: from kotlin metadata */
    public final String moveToNextValue;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    public final int MyBillsEntityDataFactory;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    public final HashMap<String, String> PlaceComponentResult;

    /* renamed from: getErrorConfigVersion  reason: from kotlin metadata */
    public final String scheduleImpl;

    /* renamed from: lookAheadTest  reason: from kotlin metadata */
    public final String getErrorConfigVersion;

    /* renamed from: moveToNextValue  reason: from kotlin metadata */
    public final String lookAheadTest;

    /* renamed from: scheduleImpl  reason: from kotlin metadata */
    public final String NetworkUserEntityData$$ExternalSyntheticLambda0;

    public SocialFeedModel() {
        this(null, null, null, null, null, null, null, null, 0, null, 0, 2047, null);
    }

    public final boolean equals(Object p0) {
        if (this == p0) {
            return true;
        }
        if (p0 instanceof SocialFeedModel) {
            SocialFeedModel socialFeedModel = (SocialFeedModel) p0;
            return Intrinsics.areEqual(this.scheduleImpl, socialFeedModel.scheduleImpl) && Intrinsics.areEqual(this.lookAheadTest, socialFeedModel.lookAheadTest) && Intrinsics.areEqual(this.getAuthRequestContext, socialFeedModel.getAuthRequestContext) && Intrinsics.areEqual(this.NetworkUserEntityData$$ExternalSyntheticLambda0, socialFeedModel.NetworkUserEntityData$$ExternalSyntheticLambda0) && Intrinsics.areEqual(this.getErrorConfigVersion, socialFeedModel.getErrorConfigVersion) && Intrinsics.areEqual(this.PlaceComponentResult, socialFeedModel.PlaceComponentResult) && Intrinsics.areEqual(this.BuiltInFictitiousFunctionClassFactory, socialFeedModel.BuiltInFictitiousFunctionClassFactory) && Intrinsics.areEqual(this.KClassImpl$Data$declaredNonStaticMembers$2, socialFeedModel.KClassImpl$Data$declaredNonStaticMembers$2) && this.MyBillsEntityDataFactory == socialFeedModel.MyBillsEntityDataFactory && Intrinsics.areEqual(this.moveToNextValue, socialFeedModel.moveToNextValue) && this.GetContactSyncConfig == socialFeedModel.GetContactSyncConfig;
        }
        return false;
    }

    public final int hashCode() {
        String str = this.scheduleImpl;
        int hashCode = str == null ? 0 : str.hashCode();
        String str2 = this.lookAheadTest;
        int hashCode2 = str2 == null ? 0 : str2.hashCode();
        String str3 = this.getAuthRequestContext;
        int hashCode3 = str3 == null ? 0 : str3.hashCode();
        String str4 = this.NetworkUserEntityData$$ExternalSyntheticLambda0;
        int hashCode4 = str4 == null ? 0 : str4.hashCode();
        String str5 = this.getErrorConfigVersion;
        int hashCode5 = str5 == null ? 0 : str5.hashCode();
        HashMap<String, String> hashMap = this.PlaceComponentResult;
        int hashCode6 = hashMap == null ? 0 : hashMap.hashCode();
        Long l = this.BuiltInFictitiousFunctionClassFactory;
        int hashCode7 = l == null ? 0 : l.hashCode();
        String str6 = this.KClassImpl$Data$declaredNonStaticMembers$2;
        int hashCode8 = str6 == null ? 0 : str6.hashCode();
        int i = this.MyBillsEntityDataFactory;
        String str7 = this.moveToNextValue;
        return (((((((((((((((((((hashCode * 31) + hashCode2) * 31) + hashCode3) * 31) + hashCode4) * 31) + hashCode5) * 31) + hashCode6) * 31) + hashCode7) * 31) + hashCode8) * 31) + i) * 31) + (str7 != null ? str7.hashCode() : 0)) * 31) + this.GetContactSyncConfig;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("SocialFeedModel(scheduleImpl=");
        sb.append(this.scheduleImpl);
        sb.append(", lookAheadTest=");
        sb.append(this.lookAheadTest);
        sb.append(", getAuthRequestContext=");
        sb.append(this.getAuthRequestContext);
        sb.append(", NetworkUserEntityData$$ExternalSyntheticLambda0=");
        sb.append(this.NetworkUserEntityData$$ExternalSyntheticLambda0);
        sb.append(", getErrorConfigVersion=");
        sb.append(this.getErrorConfigVersion);
        sb.append(", PlaceComponentResult=");
        sb.append(this.PlaceComponentResult);
        sb.append(", BuiltInFictitiousFunctionClassFactory=");
        sb.append(this.BuiltInFictitiousFunctionClassFactory);
        sb.append(", KClassImpl$Data$declaredNonStaticMembers$2=");
        sb.append(this.KClassImpl$Data$declaredNonStaticMembers$2);
        sb.append(", MyBillsEntityDataFactory=");
        sb.append(this.MyBillsEntityDataFactory);
        sb.append(", moveToNextValue=");
        sb.append(this.moveToNextValue);
        sb.append(", GetContactSyncConfig=");
        sb.append(this.GetContactSyncConfig);
        sb.append(')');
        return sb.toString();
    }

    public SocialFeedModel(String str, String str2, String str3, String str4, String str5, HashMap<String, String> hashMap, Long l, String str6, int i, String str7, int i2) {
        this.scheduleImpl = str;
        this.lookAheadTest = str2;
        this.getAuthRequestContext = str3;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = str4;
        this.getErrorConfigVersion = str5;
        this.PlaceComponentResult = hashMap;
        this.BuiltInFictitiousFunctionClassFactory = l;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = str6;
        this.MyBillsEntityDataFactory = i;
        this.moveToNextValue = str7;
        this.GetContactSyncConfig = i2;
    }

    public /* synthetic */ SocialFeedModel(String str, String str2, String str3, String str4, String str5, HashMap hashMap, Long l, String str6, int i, String str7, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? null : str, (i3 & 2) != 0 ? null : str2, (i3 & 4) != 0 ? null : str3, (i3 & 8) != 0 ? null : str4, (i3 & 16) != 0 ? null : str5, (i3 & 32) != 0 ? null : hashMap, (i3 & 64) != 0 ? null : l, (i3 & 128) != 0 ? null : str6, (i3 & 256) != 0 ? 1 : i, (i3 & 512) == 0 ? str7 : null, (i3 & 1024) == 0 ? i2 : 1);
    }

    public static String PlaceComponentResult(int p0, Date p1, Context p2) {
        String str;
        String string = p2.getResources().getString(R.string.feed_section_today);
        Intrinsics.checkNotNullExpressionValue(string, "");
        String string2 = p2.getResources().getString(R.string.feed_section_yesterday);
        Intrinsics.checkNotNullExpressionValue(string2, "");
        if (p0 != 0) {
            str = p0 != 1 ? DateTimeUtil.getAuthRequestContext(p1) : string2;
        } else {
            str = string;
        }
        if (Intrinsics.areEqual(str, string) || Intrinsics.areEqual(str, string2)) {
            return str;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(InputCardNumberView.DIVIDER);
        sb.append(DateTimeUtil.KClassImpl$Data$declaredNonStaticMembers$2(p1));
        return sb.toString();
    }

    public final FeedRegexData KClassImpl$Data$declaredNonStaticMembers$2(Context p0, SocialFeedClickListener p1) {
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p1, "");
        String str = this.scheduleImpl;
        String str2 = str == null ? "" : str;
        String str3 = this.getAuthRequestContext;
        String str4 = str3 == null ? "" : str3;
        HashMap<String, String> hashMap = this.PlaceComponentResult;
        if (hashMap == null) {
            hashMap = new HashMap<>();
        }
        HashMap<String, String> hashMap2 = hashMap;
        SocialFeedModel$toFeedRegexData$1 socialFeedModel$toFeedRegexData$1 = new SocialFeedModel$toFeedRegexData$1(p1);
        String str5 = this.KClassImpl$Data$declaredNonStaticMembers$2;
        return new FeedRegexData(str2, str4, hashMap2, socialFeedModel$toFeedRegexData$1, p0, str5 == null ? "" : str5);
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lid/dana/social/model/SocialFeedModel$Companion;", "", "Lid/dana/data/config/source/sharedpreference/SocialFeedModelEntityData;", "p0", "Lid/dana/social/model/SocialFeedModel;", "MyBillsEntityDataFactory", "(Lid/dana/data/config/source/sharedpreference/SocialFeedModelEntityData;)Lid/dana/social/model/SocialFeedModel;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public static SocialFeedModel MyBillsEntityDataFactory(SocialFeedModelEntityData p0) {
            Intrinsics.checkNotNullParameter(p0, "");
            String id2 = p0.getId();
            String iconUrl = p0.getIconUrl();
            String description = p0.getDescription();
            String redirectType = p0.getRedirectType();
            String redirectValue = p0.getRedirectValue();
            HashMap<String, String> extendInfo = p0.getExtendInfo();
            Long createdTime = p0.getCreatedTime();
            String contentType = p0.getContentType();
            Integer actorCount = p0.getActorCount();
            int intValue = actorCount != null ? actorCount.intValue() : 1;
            String iconUrl2 = p0.getIconUrl2();
            Integer viewType = p0.getViewType();
            return new SocialFeedModel(id2, iconUrl, description, redirectType, redirectValue, extendInfo, createdTime, contentType, intValue, iconUrl2, viewType != null ? viewType.intValue() : 1);
        }
    }
}
