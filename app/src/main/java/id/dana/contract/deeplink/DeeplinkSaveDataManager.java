package id.dana.contract.deeplink;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001dB\u0007¢\u0006\u0004\b\u001c\u0010\nJ\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\r\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0004J\r\u0010\u0006\u001a\u00020\u0002¢\u0006\u0004\b\u0006\u0010\u0004J\r\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\u0004J\r\u0010\t\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\fR\u0018\u0010\r\u001a\u0004\u0018\u00010\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0006\u0010\fR\u0016\u0010\u0005\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0005\u0010\fR\u0018\u0010\u000f\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0011\u0010\u0010R\u0018\u0010\t\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0012\u0010\u0010R\u0018\u0010\u0013\u001a\u0004\u0018\u00010\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0007\u0010\fR\u001e\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00148\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0013\u0010\fR\u0018\u0010\u0017\u001a\u0004\u0018\u00010\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\t\u0010\fR\u0018\u0010\u001b\u001a\u0004\u0018\u00010\u00188\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0019\u0010\u001a"}, d2 = {"Lid/dana/contract/deeplink/DeeplinkSaveDataManager;", "", "", "getAuthRequestContext", "()Z", "KClassImpl$Data$declaredNonStaticMembers$2", "PlaceComponentResult", "scheduleImpl", "", "NetworkUserEntityData$$ExternalSyntheticLambda0", "()V", "", "Ljava/lang/String;", "BuiltInFictitiousFunctionClassFactory", "Z", "MyBillsEntityDataFactory", "Ljava/lang/Boolean;", "moveToNextValue", "lookAheadTest", "getErrorConfigVersion", "Lkotlin/Function0;", "GetContactSyncConfig", "Lkotlin/jvm/functions/Function0;", "DatabaseTableConfigUtil", "", "NetworkUserEntityData$$ExternalSyntheticLambda2", "Ljava/lang/Integer;", "NetworkUserEntityData$$ExternalSyntheticLambda1", "<init>", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes.dex */
public final class DeeplinkSaveDataManager {

    /* renamed from: Companion  reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static DeeplinkSaveDataManager initRecordTimeStamp;

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    boolean KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: GetContactSyncConfig  reason: from kotlin metadata */
    private Function0<Unit> scheduleImpl;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    public String getAuthRequestContext;
    public Boolean MyBillsEntityDataFactory;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda0  reason: from kotlin metadata */
    public String DatabaseTableConfigUtil;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda2  reason: from kotlin metadata */
    public Integer NetworkUserEntityData$$ExternalSyntheticLambda1;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    public String BuiltInFictitiousFunctionClassFactory;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    public String PlaceComponentResult;

    /* renamed from: getErrorConfigVersion  reason: from kotlin metadata */
    public String lookAheadTest;

    /* renamed from: lookAheadTest  reason: from kotlin metadata */
    public Boolean NetworkUserEntityData$$ExternalSyntheticLambda0;
    public Boolean moveToNextValue;

    /* renamed from: scheduleImpl  reason: from kotlin metadata */
    public String getErrorConfigVersion;

    @JvmStatic
    public static final DeeplinkSaveDataManager MyBillsEntityDataFactory() {
        return INSTANCE.PlaceComponentResult();
    }

    public final boolean PlaceComponentResult() {
        Boolean bool = this.moveToNextValue;
        if (bool != null) {
            return bool.booleanValue();
        }
        return false;
    }

    public final boolean KClassImpl$Data$declaredNonStaticMembers$2() {
        Boolean bool = this.MyBillsEntityDataFactory;
        if (bool != null) {
            return bool.booleanValue();
        }
        return false;
    }

    public final boolean scheduleImpl() {
        Boolean bool = this.NetworkUserEntityData$$ExternalSyntheticLambda0;
        if (bool != null) {
            return bool.booleanValue();
        }
        return true;
    }

    /* renamed from: getAuthRequestContext  reason: from getter */
    public final boolean getKClassImpl$Data$declaredNonStaticMembers$2() {
        return this.KClassImpl$Data$declaredNonStaticMembers$2;
    }

    public final void NetworkUserEntityData$$ExternalSyntheticLambda0() {
        this.lookAheadTest = null;
        this.getErrorConfigVersion = null;
        this.PlaceComponentResult = null;
        this.scheduleImpl = null;
        this.moveToNextValue = null;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = null;
        this.NetworkUserEntityData$$ExternalSyntheticLambda1 = null;
        this.DatabaseTableConfigUtil = null;
        this.getAuthRequestContext = null;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = false;
        initRecordTimeStamp = null;
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0003\u0010\u0004R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0005\u0010\u0006"}, d2 = {"Lid/dana/contract/deeplink/DeeplinkSaveDataManager$Companion;", "", "Lid/dana/contract/deeplink/DeeplinkSaveDataManager;", "PlaceComponentResult", "()Lid/dana/contract/deeplink/DeeplinkSaveDataManager;", "initRecordTimeStamp", "Lid/dana/contract/deeplink/DeeplinkSaveDataManager;", "KClassImpl$Data$declaredNonStaticMembers$2", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final DeeplinkSaveDataManager PlaceComponentResult() {
            DeeplinkSaveDataManager deeplinkSaveDataManager;
            DeeplinkSaveDataManager deeplinkSaveDataManager2 = DeeplinkSaveDataManager.initRecordTimeStamp;
            if (deeplinkSaveDataManager2 != null) {
                return deeplinkSaveDataManager2;
            }
            synchronized (this) {
                deeplinkSaveDataManager = DeeplinkSaveDataManager.initRecordTimeStamp;
                if (deeplinkSaveDataManager == null) {
                    Companion companion = DeeplinkSaveDataManager.INSTANCE;
                    DeeplinkSaveDataManager.initRecordTimeStamp = new DeeplinkSaveDataManager();
                    deeplinkSaveDataManager = DeeplinkSaveDataManager.initRecordTimeStamp;
                    Intrinsics.checkNotNull(deeplinkSaveDataManager);
                }
            }
            return deeplinkSaveDataManager;
        }
    }
}
