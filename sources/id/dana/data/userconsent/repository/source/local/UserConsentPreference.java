package id.dana.data.userconsent.repository.source.local;

import android.content.Context;
import id.dana.data.storage.LocalStorageFactory;
import id.dana.data.storage.PreferenceFacade;
import id.dana.domain.useragreement.interactor.GetEmptyUserInfo;
import java.util.HashMap;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u00122\u00020\u0001:\u0002\u0012\u0013B\u0011\b\u0007\u0012\u0006\u0010\b\u001a\u00020\u000f¢\u0006\u0004\b\u0010\u0010\u0011J)\u0010\u0006\u001a\u001e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002j\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004`\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u001d\u0010\u000b\u001a\u00020\n2\u0006\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u0004¢\u0006\u0004\b\u000b\u0010\fR\u0014\u0010\u0006\u001a\u00020\r8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u000e"}, d2 = {"Lid/dana/data/userconsent/repository/source/local/UserConsentPreference;", "", "Ljava/util/HashMap;", "", "Lid/dana/data/userconsent/repository/source/local/UserConsentPreference$LastCheck;", "Lkotlin/collections/HashMap;", "getAuthRequestContext", "()Ljava/util/HashMap;", "p0", "p1", "", "MyBillsEntityDataFactory", "(Ljava/lang/String;Lid/dana/data/userconsent/repository/source/local/UserConsentPreference$LastCheck;)V", "Lid/dana/data/storage/PreferenceFacade;", "Lid/dana/data/storage/PreferenceFacade;", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "Companion", "LastCheck"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class UserConsentPreference {
    public final PreferenceFacade getAuthRequestContext;

    @Inject
    public UserConsentPreference(Context context) {
        Intrinsics.checkNotNullParameter(context, "");
        PreferenceFacade createData = new LocalStorageFactory(new LocalStorageFactory.Builder(context).setPreferenceGroup("UserConsentPreference_production").setUseDrutherPreference(true).setSerializerFacade(null)).createData("local");
        Intrinsics.checkNotNullExpressionValue(createData, "");
        this.getAuthRequestContext = createData;
    }

    public final void MyBillsEntityDataFactory(String p0, LastCheck p1) {
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p1, "");
        HashMap<String, LastCheck> authRequestContext = getAuthRequestContext();
        authRequestContext.put(p0, p1);
        this.getAuthRequestContext.saveData("last_check", (String) authRequestContext);
    }

    public final HashMap<String, LastCheck> getAuthRequestContext() {
        HashMap<String, LastCheck> hashMap = (HashMap) this.getAuthRequestContext.getObject("last_check", new HashMap().getClass());
        return hashMap == null ? new HashMap<>() : hashMap;
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\b\u0018\u00002\u00020\u0001B;\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u000f\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0012\u0010\n\u001a\u00020\u0007X\u0086\u0002¢\u0006\u0006\n\u0004\b\b\u0010\tR\u001a\u0010\u0005\u001a\u00020\u00048\u0007X\u0086\u0006¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0012\u0010\u000e\u001a\u00020\u0007X\u0087\u0002¢\u0006\u0006\n\u0004\b\f\u0010\tR\u0012\u0010\f\u001a\u00020\u000fX\u0087\u0002¢\u0006\u0006\n\u0004\b\u000e\u0010\u0010R\u0014\u0010\b\u001a\u0004\u0018\u00010\u0002X\u0087\u0002¢\u0006\u0006\n\u0004\b\u0005\u0010\u0011"}, d2 = {"Lid/dana/data/userconsent/repository/source/local/UserConsentPreference$LastCheck;", "", "", "p0", "", "KClassImpl$Data$declaredNonStaticMembers$2", "(Ljava/lang/String;)Z", "", "getAuthRequestContext", "J", "BuiltInFictitiousFunctionClassFactory", "Z", "PlaceComponentResult", "()Z", "MyBillsEntityDataFactory", "", "I", "Ljava/lang/String;", "p1", "p2", "p3", "p4", "<init>", "(JZJILjava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class LastCheck {

        /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
        public boolean KClassImpl$Data$declaredNonStaticMembers$2;

        /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
        public String getAuthRequestContext;

        /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
        public int PlaceComponentResult;

        /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
        public long MyBillsEntityDataFactory;

        /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
        public long BuiltInFictitiousFunctionClassFactory;

        public LastCheck() {
            this(0L, false, 0L, 0, null, 31, null);
        }

        private LastCheck(long j, boolean z, long j2, int i, String str) {
            this.BuiltInFictitiousFunctionClassFactory = j;
            this.KClassImpl$Data$declaredNonStaticMembers$2 = z;
            this.MyBillsEntityDataFactory = j2;
            this.PlaceComponentResult = i;
            this.getAuthRequestContext = str;
        }

        @JvmName(name = "PlaceComponentResult")
        /* renamed from: PlaceComponentResult  reason: from getter */
        public final boolean getKClassImpl$Data$declaredNonStaticMembers$2() {
            return this.KClassImpl$Data$declaredNonStaticMembers$2;
        }

        public /* synthetic */ LastCheck(long j, boolean z, long j2, int i, String str, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this((i2 & 1) != 0 ? 0L : j, (i2 & 2) != 0 ? false : z, (i2 & 4) == 0 ? j2 : 0L, (i2 & 8) != 0 ? GetEmptyUserInfo.Status.INCOMPLETE.ordinal() : i, (i2 & 16) != 0 ? null : str);
        }

        public final boolean KClassImpl$Data$declaredNonStaticMembers$2(String p0) {
            List split$default;
            Intrinsics.checkNotNullParameter(p0, "");
            String str = this.getAuthRequestContext;
            return !Intrinsics.areEqual((str == null || (split$default = StringsKt.split$default((CharSequence) str, new char[]{','}, false, 0, 6, (Object) null)) == null) ? null : CollectionsKt.toSet(split$default), CollectionsKt.toSet(StringsKt.split$default((CharSequence) p0, new char[]{','}, false, 0, 6, (Object) null)));
        }
    }
}
