package id.dana.feeds.ui.model;

import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010$\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u001d\u0012\u0014\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u000b¢\u0006\u0004\b\u000f\u0010\u0010R\u0013\u0010\u0005\u001a\u00020\u0002X\u0086\u0080\u0002¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0015\u0010\u0007\u001a\u0004\u0018\u00010\u0002X\u0086\u0080\u0002¢\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0015\u0010\u0003\u001a\u0004\u0018\u00010\u0002X\u0086\u0080\u0002¢\u0006\u0006\n\u0004\b\u0007\u0010\u0004R\u0013\u0010\u0006\u001a\u00020\u0002X\u0086\u0080\u0002¢\u0006\u0006\n\u0004\b\b\u0010\u0004R\u0013\u0010\b\u001a\u00020\u0002X\u0086\u0080\u0002¢\u0006\u0006\n\u0004\b\t\u0010\u0004R\u0013\u0010\n\u001a\u00020\u0002X\u0086\u0080\u0002¢\u0006\u0006\n\u0004\b\n\u0010\u0004R \u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u000bX\u0086\u0002¢\u0006\u0006\n\u0004\b\f\u0010\u0004R\u0015\u0010\r\u001a\u0004\u0018\u00010\u0002X\u0086\u0080\u0002¢\u0006\u0006\n\u0004\b\r\u0010\u0004"}, d2 = {"Lid/dana/feeds/ui/model/DealsPayloadModel;", "", "", "BuiltInFictitiousFunctionClassFactory", "Ljava/util/Map;", "KClassImpl$Data$declaredNonStaticMembers$2", "MyBillsEntityDataFactory", "PlaceComponentResult", "getAuthRequestContext", "getErrorConfigVersion", "NetworkUserEntityData$$ExternalSyntheticLambda0", "", "scheduleImpl", "lookAheadTest", "p0", "<init>", "(Ljava/util/Map;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class DealsPayloadModel {
    public static final /* synthetic */ KProperty<Object>[] KClassImpl$Data$declaredNonStaticMembers$2 = {Reflection.property1(new PropertyReference1Impl(DealsPayloadModel.class, "merchantIconUrl", "getMerchantIconUrl()Ljava/lang/String;", 0)), Reflection.property1(new PropertyReference1Impl(DealsPayloadModel.class, "dealsRedirectType", "getDealsRedirectType()Ljava/lang/String;", 0)), Reflection.property1(new PropertyReference1Impl(DealsPayloadModel.class, "dealsRedirectValue", "getDealsRedirectValue()Ljava/lang/String;", 0)), Reflection.property1(new PropertyReference1Impl(DealsPayloadModel.class, "backgroundColor", "getBackgroundColor()Ljava/lang/String;", 0)), Reflection.property1(new PropertyReference1Impl(DealsPayloadModel.class, "dealsTitle", "getDealsTitle()Ljava/lang/String;", 0)), Reflection.property1(new PropertyReference1Impl(DealsPayloadModel.class, "dealsSubtitleValue", "getDealsSubtitleValue()Ljava/lang/String;", 0)), Reflection.property1(new PropertyReference1Impl(DealsPayloadModel.class, "dealsSubtitleType", "getDealsSubtitleType()Ljava/lang/String;", 0))};

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    public final Map KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    public final Map PlaceComponentResult;
    public final Map NetworkUserEntityData$$ExternalSyntheticLambda0;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    public final Map BuiltInFictitiousFunctionClassFactory;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    public final Map MyBillsEntityDataFactory;

    /* renamed from: getErrorConfigVersion  reason: from kotlin metadata */
    public final Map getAuthRequestContext;
    public final Map lookAheadTest;

    /* renamed from: scheduleImpl  reason: from kotlin metadata */
    public Map<String, ? extends Object> getErrorConfigVersion;

    public DealsPayloadModel(Map<String, ? extends Object> map) {
        Intrinsics.checkNotNullParameter(map, "");
        this.getErrorConfigVersion = map;
        this.lookAheadTest = MapsKt.withDefault(map, new Function1<String, Object>() { // from class: id.dana.feeds.ui.model.DealsPayloadModel$merchantIconUrl$2
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(String str) {
                Intrinsics.checkNotNullParameter(str, "");
                return "";
            }
        });
        this.PlaceComponentResult = MapsKt.withDefault(this.getErrorConfigVersion, new Function1<String, Object>() { // from class: id.dana.feeds.ui.model.DealsPayloadModel$dealsRedirectType$2
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(String str) {
                Intrinsics.checkNotNullParameter(str, "");
                return "";
            }
        });
        this.BuiltInFictitiousFunctionClassFactory = MapsKt.withDefault(this.getErrorConfigVersion, new Function1<String, Object>() { // from class: id.dana.feeds.ui.model.DealsPayloadModel$dealsRedirectValue$2
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(String str) {
                Intrinsics.checkNotNullParameter(str, "");
                return "";
            }
        });
        this.KClassImpl$Data$declaredNonStaticMembers$2 = MapsKt.withDefault(this.getErrorConfigVersion, new Function1<String, Object>() { // from class: id.dana.feeds.ui.model.DealsPayloadModel$backgroundColor$2
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(String str) {
                Intrinsics.checkNotNullParameter(str, "");
                return "";
            }
        });
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = MapsKt.withDefault(this.getErrorConfigVersion, new Function1<String, Object>() { // from class: id.dana.feeds.ui.model.DealsPayloadModel$dealsTitle$2
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(String str) {
                Intrinsics.checkNotNullParameter(str, "");
                return "";
            }
        });
        this.getAuthRequestContext = MapsKt.withDefault(this.getErrorConfigVersion, new Function1<String, Object>() { // from class: id.dana.feeds.ui.model.DealsPayloadModel$dealsSubtitleValue$2
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(String str) {
                Intrinsics.checkNotNullParameter(str, "");
                return "";
            }
        });
        this.MyBillsEntityDataFactory = MapsKt.withDefault(this.getErrorConfigVersion, new Function1<String, Object>() { // from class: id.dana.feeds.ui.model.DealsPayloadModel$dealsSubtitleType$2
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(String str) {
                Intrinsics.checkNotNullParameter(str, "");
                return "";
            }
        });
    }
}
