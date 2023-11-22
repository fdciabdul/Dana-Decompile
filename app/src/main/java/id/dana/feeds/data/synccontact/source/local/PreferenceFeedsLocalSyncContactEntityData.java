package id.dana.feeds.data.synccontact.source.local;

import android.content.Context;
import id.dana.data.storage.LocalStorageFactory;
import id.dana.data.storage.PreferenceFacade;
import id.dana.data.storage.Serializer;
import id.dana.data.storage.SimpleSecureKeyPreference;
import id.dana.feeds.data.synccontact.source.FeedsLocalSyncEntityData;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.Intrinsics;

@Singleton
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u0019\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0013\u0012\u0006\u0010\u0004\u001a\u00020\u0017¢\u0006\u0004\b\u001a\u0010\u001bJ#\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0096@ø\u0001\u0000¢\u0006\u0004\b\u0006\u0010\u0007J#\u0010\b\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0096@ø\u0001\u0000¢\u0006\u0004\b\b\u0010\u0007J+\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u0002H\u0096@ø\u0001\u0000¢\u0006\u0004\b\u000b\u0010\fJ#\u0010\r\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0096@ø\u0001\u0000¢\u0006\u0004\b\r\u0010\u0007J+\u0010\u000b\u001a\u00020\u000e2\u0006\u0010\u0003\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u0002H\u0096@ø\u0001\u0000¢\u0006\u0004\b\u000b\u0010\u0007J+\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u0002H\u0096@ø\u0001\u0000¢\u0006\u0004\b\u000f\u0010\fJ3\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0003\u001a\u00020\n2\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u0002H\u0096@ø\u0001\u0000¢\u0006\u0004\b\r\u0010\u0011J+\u0010\u000b\u001a\u00020\u000e2\u0006\u0010\u0003\u001a\u00020\n2\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u0002H\u0096@ø\u0001\u0000¢\u0006\u0004\b\u000b\u0010\u0012R\u0011\u0010\b\u001a\u00020\u0013X\u0006¢\u0006\u0006\n\u0004\b\u0006\u0010\u0014R\u0014\u0010\u000f\u001a\u00020\u00158\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u0016R\u0011\u0010\r\u001a\u00020\u0017X\u0006¢\u0006\u0006\n\u0004\b\u000b\u0010\u0018R\u0014\u0010\u000b\u001a\u00020\u00028\u0002X\u0082D¢\u0006\u0006\n\u0004\b\b\u0010\u0019\u0082\u0002\u0004\n\u0002\b\u0019"}, d2 = {"Lid/dana/feeds/data/synccontact/source/local/PreferenceFeedsLocalSyncContactEntityData;", "Lid/dana/feeds/data/synccontact/source/FeedsLocalSyncEntityData;", "", "p0", "p1", "", "PlaceComponentResult", "(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/Object;", "BuiltInFictitiousFunctionClassFactory", "p2", "", "getAuthRequestContext", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/Object;", "MyBillsEntityDataFactory", "", "KClassImpl$Data$declaredNonStaticMembers$2", "p3", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/Object;", "(ILjava/lang/String;Ljava/lang/String;)Ljava/lang/Object;", "Landroid/content/Context;", "Landroid/content/Context;", "Lid/dana/data/storage/PreferenceFacade;", "Lid/dana/data/storage/PreferenceFacade;", "Lid/dana/data/storage/Serializer;", "Lid/dana/data/storage/Serializer;", "Ljava/lang/String;", "<init>", "(Landroid/content/Context;Lid/dana/data/storage/Serializer;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class PreferenceFeedsLocalSyncContactEntityData implements FeedsLocalSyncEntityData {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    private final String getAuthRequestContext;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private final PreferenceFacade KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    public final Context BuiltInFictitiousFunctionClassFactory;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    public final Serializer MyBillsEntityDataFactory;

    @Inject
    public PreferenceFeedsLocalSyncContactEntityData(Context context, Serializer serializer) {
        Intrinsics.checkNotNullParameter(context, "");
        Intrinsics.checkNotNullParameter(serializer, "");
        this.BuiltInFictitiousFunctionClassFactory = context;
        this.MyBillsEntityDataFactory = serializer;
        this.getAuthRequestContext = "PreferenceFeedsSyncContactEntityDataproduction";
        PreferenceFacade createData2 = new LocalStorageFactory(new LocalStorageFactory.Builder(context).setPreferenceGroup("PreferenceFeedsSyncContactEntityDataproduction").setUseDrutherPreference(true).setSerializerFacade(serializer)).createData2("local");
        Intrinsics.checkNotNullExpressionValue(createData2, "");
        this.KClassImpl$Data$declaredNonStaticMembers$2 = new SimpleSecureKeyPreference(createData2);
    }

    @Override // id.dana.feeds.data.synccontact.source.FeedsLocalSyncEntityData
    public final Object BuiltInFictitiousFunctionClassFactory(String p0, String p1) {
        PreferenceFacade preferenceFacade = this.KClassImpl$Data$declaredNonStaticMembers$2;
        StringBuilder sb = new StringBuilder();
        sb.append(p0);
        sb.append(p1);
        String string = preferenceFacade.getString(sb.toString());
        return string == null ? "" : string;
    }

    @Override // id.dana.feeds.data.synccontact.source.FeedsLocalSyncEntityData
    public final Object KClassImpl$Data$declaredNonStaticMembers$2(String p0, String p1, String p2) {
        PreferenceFacade preferenceFacade = this.KClassImpl$Data$declaredNonStaticMembers$2;
        StringBuilder sb = new StringBuilder();
        sb.append(p1);
        sb.append(p2);
        preferenceFacade.saveData(sb.toString(), p0);
        return Unit.INSTANCE;
    }

    @Override // id.dana.feeds.data.synccontact.source.FeedsLocalSyncEntityData
    public final Object getAuthRequestContext(int p0, String p1, String p2) {
        PreferenceFacade preferenceFacade = this.KClassImpl$Data$declaredNonStaticMembers$2;
        StringBuilder sb = new StringBuilder();
        sb.append(p1);
        sb.append(p2);
        preferenceFacade.saveData(sb.toString(), Boxing.boxInt(p0));
        return Unit.INSTANCE;
    }

    @Override // id.dana.feeds.data.synccontact.source.FeedsLocalSyncEntityData
    public final Object MyBillsEntityDataFactory(int p0, String p1, String p2, String p3) {
        PreferenceFacade preferenceFacade = this.KClassImpl$Data$declaredNonStaticMembers$2;
        StringBuilder sb = new StringBuilder();
        sb.append(p2);
        sb.append(p3);
        sb.append(p1);
        preferenceFacade.saveData(sb.toString(), Boxing.boxInt(p0));
        return Unit.INSTANCE;
    }

    @Override // id.dana.feeds.data.synccontact.source.FeedsLocalSyncEntityData
    public final Object getAuthRequestContext(String p0, String p1, String p2) {
        PreferenceFacade preferenceFacade = this.KClassImpl$Data$declaredNonStaticMembers$2;
        StringBuilder sb = new StringBuilder();
        sb.append(p1);
        sb.append(p2);
        sb.append(p0);
        Integer integer = preferenceFacade.getInteger(sb.toString());
        Intrinsics.checkNotNullExpressionValue(integer, "");
        int intValue = integer.intValue();
        if (intValue == -1) {
            intValue = 0;
        }
        return Boxing.boxInt(intValue);
    }

    @Override // id.dana.feeds.data.synccontact.source.FeedsLocalSyncEntityData
    public final Object MyBillsEntityDataFactory(String p0, String p1) {
        PreferenceFacade preferenceFacade = this.KClassImpl$Data$declaredNonStaticMembers$2;
        StringBuilder sb = new StringBuilder();
        sb.append(p0);
        sb.append(p1);
        Integer integer = preferenceFacade.getInteger(sb.toString());
        Intrinsics.checkNotNullExpressionValue(integer, "");
        int intValue = integer.intValue();
        if (intValue == -1) {
            intValue = 0;
        }
        return Boxing.boxInt(intValue);
    }

    @Override // id.dana.feeds.data.synccontact.source.FeedsLocalSyncEntityData
    public final Object PlaceComponentResult(String p0, String p1) {
        PreferenceFacade preferenceFacade = this.KClassImpl$Data$declaredNonStaticMembers$2;
        StringBuilder sb = new StringBuilder();
        sb.append(p0);
        sb.append(p1);
        Boolean bool = preferenceFacade.getBoolean(sb.toString(), false);
        Intrinsics.checkNotNullExpressionValue(bool, "");
        return bool;
    }

    @Override // id.dana.feeds.data.synccontact.source.FeedsLocalSyncEntityData
    public final Object getAuthRequestContext(String str, String str2) {
        PreferenceFacade preferenceFacade = this.KClassImpl$Data$declaredNonStaticMembers$2;
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(str2);
        preferenceFacade.saveData(sb.toString(), Boxing.boxBoolean(true));
        return Unit.INSTANCE;
    }
}
