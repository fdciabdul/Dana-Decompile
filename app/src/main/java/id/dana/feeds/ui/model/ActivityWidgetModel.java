package id.dana.feeds.ui.model;

import android.os.Parcel;
import android.os.Parcelable;
import id.dana.feeds.domain.timeline.model.ActivityWidget;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0012\u0018\u0000 &2\u00020\u0001:\u0001&Bt\u0012\b\b\u0002\u0010\t\u001a\u00020\u000e\u0012\b\b\u0002\u0010\n\u001a\u00020\u000e\u0012\b\b\u0002\u0010\u001d\u001a\u00020\u000e\u0012\b\b\u0002\u0010\u001e\u001a\u00020\u000e\u0012\b\b\u0002\u0010\u001f\u001a\u00020\u000e\u0012\b\b\u0002\u0010 \u001a\u00020\u000e\u0012\u0006\u0010!\u001a\u00020\u000e\u0012\b\b\u0002\u0010\"\u001a\u00020\u0005\u0012\u001d\b\u0002\u0010#\u001a\u0017\u0012\u0004\u0012\u00020\u000e\u0012\u000b\u0012\t\u0018\u00010\u0013¢\u0006\u0002\b\u0014\u0018\u00010\u0012¢\u0006\u0004\b$\u0010%J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\r\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J \u0010\f\u001a\u00020\u000b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\f\u0010\rR\u0012\u0010\u0011\u001a\u00020\u000eX\u0086\u0002¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R'\u0010\u0006\u001a\u0017\u0012\u0004\u0012\u00020\u000e\u0012\u000b\u0012\t\u0018\u00010\u0013¢\u0006\u0002\b\u0014\u0018\u00010\u0012X\u0086\u0002¢\u0006\u0006\n\u0004\b\u0006\u0010\u0015R\u0012\u0010\u0016\u001a\u00020\u000eX\u0086\u0002¢\u0006\u0006\n\u0004\b\u0016\u0010\u0010R\u0012\u0010\u000f\u001a\u00020\u000eX\u0086\u0002¢\u0006\u0006\n\u0004\b\u0017\u0010\u0010R\u0012\u0010\u0017\u001a\u00020\u000eX\u0086\u0002¢\u0006\u0006\n\u0004\b\u0011\u0010\u0010R\u0012\u0010\u0019\u001a\u00020\u000eX\u0086\u0002¢\u0006\u0006\n\u0004\b\u0018\u0010\u0010R\u0012\u0010\u001b\u001a\u00020\u000eX\u0086\u0002¢\u0006\u0006\n\u0004\b\u001a\u0010\u0010R\u0012\u0010\u0018\u001a\u00020\u000eX\u0086\u0002¢\u0006\u0006\n\u0004\b\u0019\u0010\u0010R\u0012\u0010\u001a\u001a\u00020\u0005X\u0086\u0002¢\u0006\u0006\n\u0004\b\u001b\u0010\u001c"}, d2 = {"Lid/dana/feeds/ui/model/ActivityWidgetModel;", "Landroid/os/Parcelable;", "", "describeContents", "()I", "", "KClassImpl$Data$declaredNonStaticMembers$2", "()Z", "Landroid/os/Parcel;", "p0", "p1", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "", "PlaceComponentResult", "Ljava/lang/String;", "BuiltInFictitiousFunctionClassFactory", "", "", "Lkotlinx/android/parcel/RawValue;", "Ljava/util/Map;", "MyBillsEntityDataFactory", "getAuthRequestContext", "lookAheadTest", "NetworkUserEntityData$$ExternalSyntheticLambda0", "scheduleImpl", "getErrorConfigVersion", "Z", "p2", "p3", "p4", "p5", "p6", "p7", "p8", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/util/Map;)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ActivityWidgetModel implements Parcelable {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    public String getAuthRequestContext;
    public Map<String, ? extends Object> KClassImpl$Data$declaredNonStaticMembers$2;
    public String MyBillsEntityDataFactory;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda0  reason: from kotlin metadata */
    public String lookAheadTest;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    public String BuiltInFictitiousFunctionClassFactory;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    public String PlaceComponentResult;

    /* renamed from: getErrorConfigVersion  reason: from kotlin metadata */
    public boolean scheduleImpl;

    /* renamed from: lookAheadTest  reason: from kotlin metadata */
    public String NetworkUserEntityData$$ExternalSyntheticLambda0;

    /* renamed from: scheduleImpl  reason: from kotlin metadata */
    public String getErrorConfigVersion;

    /* renamed from: Companion  reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final Parcelable.Creator<ActivityWidgetModel> CREATOR = new Creator();

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel p0, int p1) {
        Intrinsics.checkNotNullParameter(p0, "");
        p0.writeString(this.lookAheadTest);
        p0.writeString(this.PlaceComponentResult);
        p0.writeString(this.getErrorConfigVersion);
        p0.writeString(this.MyBillsEntityDataFactory);
        p0.writeString(this.NetworkUserEntityData$$ExternalSyntheticLambda0);
        p0.writeString(this.getAuthRequestContext);
        p0.writeString(this.BuiltInFictitiousFunctionClassFactory);
        p0.writeInt(this.scheduleImpl ? 1 : 0);
        Map<String, ? extends Object> map = this.KClassImpl$Data$declaredNonStaticMembers$2;
        if (map == null) {
            p0.writeInt(0);
            return;
        }
        p0.writeInt(1);
        p0.writeInt(map.size());
        for (Map.Entry<String, ? extends Object> entry : map.entrySet()) {
            p0.writeString(entry.getKey());
            p0.writeValue(entry.getValue());
        }
    }

    public ActivityWidgetModel(String str, String str2, String str3, String str4, String str5, String str6, String str7, boolean z, Map<String, ? extends Object> map) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str2, "");
        Intrinsics.checkNotNullParameter(str3, "");
        Intrinsics.checkNotNullParameter(str4, "");
        Intrinsics.checkNotNullParameter(str5, "");
        Intrinsics.checkNotNullParameter(str6, "");
        Intrinsics.checkNotNullParameter(str7, "");
        this.lookAheadTest = str;
        this.PlaceComponentResult = str2;
        this.getErrorConfigVersion = str3;
        this.MyBillsEntityDataFactory = str4;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = str5;
        this.getAuthRequestContext = str6;
        this.BuiltInFictitiousFunctionClassFactory = str7;
        this.scheduleImpl = z;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = map;
    }

    public final boolean KClassImpl$Data$declaredNonStaticMembers$2() {
        if (this.scheduleImpl) {
            Map<String, ? extends Object> map = this.KClassImpl$Data$declaredNonStaticMembers$2;
            return map != null && String.valueOf(map.get("dealsRedirectType")).length() > 0;
        }
        return false;
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u0011\u0010\u0004\u001a\u00020\u0003*\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0019\u0010\b\u001a\u00020\u0002*\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\t"}, d2 = {"Lid/dana/feeds/ui/model/ActivityWidgetModel$Companion;", "", "Lid/dana/feeds/ui/model/ActivityWidgetModel;", "Lid/dana/feeds/domain/timeline/model/ActivityWidget;", "MyBillsEntityDataFactory", "(Lid/dana/feeds/ui/model/ActivityWidgetModel;)Lid/dana/feeds/domain/timeline/model/ActivityWidget;", "", "p0", "getAuthRequestContext", "(Lid/dana/feeds/domain/timeline/model/ActivityWidget;Ljava/lang/String;)Lid/dana/feeds/ui/model/ActivityWidgetModel;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public static ActivityWidgetModel getAuthRequestContext(ActivityWidget activityWidget, String str) {
            Intrinsics.checkNotNullParameter(activityWidget, "");
            Intrinsics.checkNotNullParameter(str, "");
            return new ActivityWidgetModel(activityWidget.getTitle(), activityWidget.getRedirectType(), activityWidget.getSubtitleValue(), activityWidget.getIconUrl(), activityWidget.getSubtitleType(), activityWidget.getRedirectValue(), str, activityWidget.getUniqueValue(), activityWidget.getExtendInfo());
        }

        public static ActivityWidget MyBillsEntityDataFactory(ActivityWidgetModel activityWidgetModel) {
            Intrinsics.checkNotNullParameter(activityWidgetModel, "");
            return new ActivityWidget(activityWidgetModel.lookAheadTest, activityWidgetModel.NetworkUserEntityData$$ExternalSyntheticLambda0, activityWidgetModel.getErrorConfigVersion, activityWidgetModel.MyBillsEntityDataFactory, activityWidgetModel.PlaceComponentResult, activityWidgetModel.getAuthRequestContext, false, null, 192, null);
        }
    }

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Creator implements Parcelable.Creator<ActivityWidgetModel> {
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ ActivityWidgetModel createFromParcel(Parcel parcel) {
            LinkedHashMap linkedHashMap;
            Intrinsics.checkNotNullParameter(parcel, "");
            String readString = parcel.readString();
            String readString2 = parcel.readString();
            String readString3 = parcel.readString();
            String readString4 = parcel.readString();
            String readString5 = parcel.readString();
            String readString6 = parcel.readString();
            String readString7 = parcel.readString();
            boolean z = parcel.readInt() != 0;
            if (parcel.readInt() == 0) {
                linkedHashMap = null;
            } else {
                int readInt = parcel.readInt();
                LinkedHashMap linkedHashMap2 = new LinkedHashMap(readInt);
                for (int i = 0; i != readInt; i++) {
                    linkedHashMap2.put(parcel.readString(), parcel.readValue(ActivityWidgetModel.class.getClassLoader()));
                }
                linkedHashMap = linkedHashMap2;
            }
            return new ActivityWidgetModel(readString, readString2, readString3, readString4, readString5, readString6, readString7, z, linkedHashMap);
        }

        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ ActivityWidgetModel[] newArray(int i) {
            return new ActivityWidgetModel[i];
        }
    }
}
