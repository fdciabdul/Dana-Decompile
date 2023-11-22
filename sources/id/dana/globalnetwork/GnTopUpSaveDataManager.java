package id.dana.globalnetwork;

import id.dana.globalnetwork.model.GnTopUpResultModel;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \r2\u00020\u0001:\u0001\rB\u0007¢\u0006\u0004\b\u000b\u0010\fR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0018\u0010\t\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\n\u0010\u0004"}, d2 = {"Lid/dana/globalnetwork/GnTopUpSaveDataManager;", "", "", "BuiltInFictitiousFunctionClassFactory", "Ljava/lang/Boolean;", "getAuthRequestContext", "Lid/dana/globalnetwork/model/GnTopUpResultModel;", "KClassImpl$Data$declaredNonStaticMembers$2", "Lid/dana/globalnetwork/model/GnTopUpResultModel;", "MyBillsEntityDataFactory", "PlaceComponentResult", "<init>", "()V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class GnTopUpSaveDataManager {

    /* renamed from: Companion  reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static GnTopUpSaveDataManager getAuthRequestContext;

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    public Boolean getAuthRequestContext;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    public GnTopUpResultModel MyBillsEntityDataFactory;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    public Boolean BuiltInFictitiousFunctionClassFactory;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0003\u0010\u0004R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0005\u0010\u0006"}, d2 = {"Lid/dana/globalnetwork/GnTopUpSaveDataManager$Companion;", "", "Lid/dana/globalnetwork/GnTopUpSaveDataManager;", "PlaceComponentResult", "()Lid/dana/globalnetwork/GnTopUpSaveDataManager;", "getAuthRequestContext", "Lid/dana/globalnetwork/GnTopUpSaveDataManager;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final GnTopUpSaveDataManager PlaceComponentResult() {
            GnTopUpSaveDataManager gnTopUpSaveDataManager;
            GnTopUpSaveDataManager gnTopUpSaveDataManager2 = GnTopUpSaveDataManager.getAuthRequestContext;
            if (gnTopUpSaveDataManager2 != null) {
                return gnTopUpSaveDataManager2;
            }
            synchronized (this) {
                gnTopUpSaveDataManager = GnTopUpSaveDataManager.getAuthRequestContext;
                if (gnTopUpSaveDataManager == null) {
                    Companion companion = GnTopUpSaveDataManager.INSTANCE;
                    GnTopUpSaveDataManager.getAuthRequestContext = new GnTopUpSaveDataManager();
                    gnTopUpSaveDataManager = GnTopUpSaveDataManager.getAuthRequestContext;
                    Intrinsics.checkNotNull(gnTopUpSaveDataManager);
                }
            }
            return gnTopUpSaveDataManager;
        }
    }
}
