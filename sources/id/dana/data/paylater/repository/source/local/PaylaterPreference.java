package id.dana.data.paylater.repository.source.local;

import android.content.Context;
import com.ap.zoloz.hummer.biz.HummerConstants;
import com.google.gson.reflect.TypeToken;
import id.dana.data.storage.LocalStorageFactory;
import id.dana.data.storage.PreferenceFacade;
import id.dana.data.storage.SimpleSecureKeyPreference;
import id.dana.domain.paylater.model.LoanStatusWhitelist;
import id.dana.domain.paylater.model.LoanWhitelist;
import id.dana.utils.extension.JSONExtKt;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Singleton
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\t\b\u0007\u0018\u0000 +2\u00020\u0001:\u0001+B\u0011\b\u0007\u0012\u0006\u0010#\u001a\u00020\"¢\u0006\u0004\b)\u0010*J\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0013\u0010\u0006\u001a\u0006*\u00020\u00050\u0005H\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u0015\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\u000b\u0010\fJ\u001b\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\u000f\u0010\u0010J\u0015\u0010\u0012\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\u0012\u0010\u0013J\u0013\u0010\u0015\u001a\u0006*\u00020\u00140\u0014H\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u0015\u0010\u0017\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\u0017\u0010\u0018J\u001d\u0010\u001a\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0019\u001a\u00020\n¢\u0006\u0004\b\u001a\u0010\u001bJ#\u0010\u001d\u001a\u00020\u00022\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\u001d\u0010\u001eJ\u001d\u0010 \u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u001f\u001a\u00020\u0011¢\u0006\u0004\b \u0010!R\u0014\u0010#\u001a\u00020\"8\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b#\u0010$R\u0014\u0010%\u001a\u00020\b8\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b%\u0010&R\u0014\u0010'\u001a\u00020\u00148\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b'\u0010("}, d2 = {"Lid/dana/data/paylater/repository/source/local/PaylaterPreference;", "", "", "clearAll", "()Z", "Lid/dana/data/storage/LocalStorageFactory$Builder;", "createBuilder", "()Lid/dana/data/storage/LocalStorageFactory$Builder;", "", "phoneNumber", "Lid/dana/domain/paylater/model/LoanWhitelist;", "getPayLaterCacheWhitelistValue", "(Ljava/lang/String;)Lid/dana/domain/paylater/model/LoanWhitelist;", "", "Lid/dana/domain/paylater/model/LoanStatusWhitelist;", "getPayLaterLoanStatus", "(Ljava/lang/String;)Ljava/util/List;", "", "getPaylaterRotationDelayTime", "(Ljava/lang/String;)J", "Lid/dana/data/storage/PreferenceFacade;", "initPayLaterPreference", "()Lid/dana/data/storage/PreferenceFacade;", "resetPayLaterCacheLoanWhitelist", "(Ljava/lang/String;)Z", "loanWhitelist", "savePayLaterCacheWhitelistValue", "(Ljava/lang/String;Lid/dana/domain/paylater/model/LoanWhitelist;)Z", "loanStatus", "savePayLaterLoanStatus", "(Ljava/util/List;Ljava/lang/String;)Z", "rotationDelayTime", "savePaylaterRotationDelayTime", "(Ljava/lang/String;J)Z", "Landroid/content/Context;", HummerConstants.CONTEXT, "Landroid/content/Context;", "paylaterPreferenceGroup", "Ljava/lang/String;", "preferenceFacade", "Lid/dana/data/storage/PreferenceFacade;", "<init>", "(Landroid/content/Context;)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class PaylaterPreference {
    public static final String PAYLATER_CACHE_WHITELIST_VALUE = "paylater_cache_whitelist_value_";
    public static final String PAYLATER_DUE_DATE_STATUS = "paylater_due_date_status_";
    public static final String PAYLATER_ROTATION_DELAY_TIME = "cicil_start_delay_time";
    private final Context context;
    private final String paylaterPreferenceGroup;
    private final PreferenceFacade preferenceFacade;

    @Inject
    public PaylaterPreference(Context context) {
        Intrinsics.checkNotNullParameter(context, "");
        this.context = context;
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append("production");
        this.paylaterPreferenceGroup = sb.toString();
        PreferenceFacade initPayLaterPreference = initPayLaterPreference();
        Intrinsics.checkNotNullExpressionValue(initPayLaterPreference, "");
        this.preferenceFacade = new SimpleSecureKeyPreference(initPayLaterPreference);
    }

    private final LocalStorageFactory.Builder createBuilder() {
        return new LocalStorageFactory.Builder(this.context).setPreferenceGroup(this.paylaterPreferenceGroup).setUseDrutherPreference(true);
    }

    private final PreferenceFacade initPayLaterPreference() {
        return new LocalStorageFactory(createBuilder()).createData2("local");
    }

    public final boolean savePayLaterCacheWhitelistValue(String phoneNumber, LoanWhitelist loanWhitelist) {
        Intrinsics.checkNotNullParameter(phoneNumber, "");
        Intrinsics.checkNotNullParameter(loanWhitelist, "");
        PreferenceFacade preferenceFacade = this.preferenceFacade;
        StringBuilder sb = new StringBuilder();
        sb.append(PAYLATER_CACHE_WHITELIST_VALUE);
        sb.append(phoneNumber);
        preferenceFacade.saveData(sb.toString(), JSONExtKt.PlaceComponentResult().toJson(loanWhitelist));
        return true;
    }

    public final LoanWhitelist getPayLaterCacheWhitelistValue(String phoneNumber) {
        Intrinsics.checkNotNullParameter(phoneNumber, "");
        PreferenceFacade preferenceFacade = this.preferenceFacade;
        StringBuilder sb = new StringBuilder();
        sb.append(PAYLATER_CACHE_WHITELIST_VALUE);
        sb.append(phoneNumber);
        LoanWhitelist loanWhitelist = (LoanWhitelist) JSONExtKt.PlaceComponentResult().fromJson(preferenceFacade.getString(sb.toString()), new TypeToken<LoanWhitelist>() { // from class: id.dana.data.paylater.repository.source.local.PaylaterPreference$getPayLaterCacheWhitelistValue$loanWhitelistTokenType$1
        }.getType());
        return loanWhitelist == null ? new LoanWhitelist(CollectionsKt.emptyList(), 0L) : loanWhitelist;
    }

    public final boolean resetPayLaterCacheLoanWhitelist(String phoneNumber) {
        Intrinsics.checkNotNullParameter(phoneNumber, "");
        PreferenceFacade preferenceFacade = this.preferenceFacade;
        StringBuilder sb = new StringBuilder();
        sb.append(PAYLATER_CACHE_WHITELIST_VALUE);
        sb.append(phoneNumber);
        preferenceFacade.clearData(sb.toString());
        return true;
    }

    public final boolean clearAll() {
        this.preferenceFacade.clearAllData();
        return true;
    }

    public final boolean savePayLaterLoanStatus(List<LoanStatusWhitelist> loanStatus, String phoneNumber) {
        Intrinsics.checkNotNullParameter(loanStatus, "");
        Intrinsics.checkNotNullParameter(phoneNumber, "");
        PreferenceFacade preferenceFacade = this.preferenceFacade;
        StringBuilder sb = new StringBuilder();
        sb.append(PAYLATER_DUE_DATE_STATUS);
        sb.append(phoneNumber);
        preferenceFacade.saveData(sb.toString(), JSONExtKt.PlaceComponentResult().toJson(loanStatus));
        return true;
    }

    public final List<LoanStatusWhitelist> getPayLaterLoanStatus(String phoneNumber) {
        Intrinsics.checkNotNullParameter(phoneNumber, "");
        ArrayList arrayList = new ArrayList();
        PreferenceFacade preferenceFacade = this.preferenceFacade;
        StringBuilder sb = new StringBuilder();
        sb.append(PAYLATER_DUE_DATE_STATUS);
        sb.append(phoneNumber);
        List list = (List) JSONExtKt.PlaceComponentResult().fromJson(preferenceFacade.getString(sb.toString()), new TypeToken<List<? extends LoanStatusWhitelist>>() { // from class: id.dana.data.paylater.repository.source.local.PaylaterPreference$getPayLaterLoanStatus$loanStatusTokenType$1
        }.getType());
        if (list != null) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                arrayList.add((LoanStatusWhitelist) it.next());
            }
        }
        return arrayList;
    }

    public final boolean savePaylaterRotationDelayTime(String phoneNumber, long rotationDelayTime) {
        Intrinsics.checkNotNullParameter(phoneNumber, "");
        PreferenceFacade preferenceFacade = this.preferenceFacade;
        StringBuilder sb = new StringBuilder();
        sb.append(PAYLATER_ROTATION_DELAY_TIME);
        sb.append(phoneNumber);
        preferenceFacade.saveData(sb.toString(), Long.valueOf(rotationDelayTime));
        return true;
    }

    public final long getPaylaterRotationDelayTime(String phoneNumber) {
        Intrinsics.checkNotNullParameter(phoneNumber, "");
        PreferenceFacade preferenceFacade = this.preferenceFacade;
        StringBuilder sb = new StringBuilder();
        sb.append(PAYLATER_ROTATION_DELAY_TIME);
        sb.append(phoneNumber);
        Long l = preferenceFacade.getLong(sb.toString());
        Intrinsics.checkNotNullExpressionValue(l, "");
        if (l.longValue() < 0) {
            return 0L;
        }
        return l.longValue();
    }
}
