package androidx.core.content.pm;

import android.app.Person;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ShortcutInfo;
import android.net.Uri;
import android.os.Build;
import android.os.PersistableBundle;
import android.text.TextUtils;
import androidx.core.app.Person;
import androidx.core.content.LocusIdCompat;
import androidx.core.graphics.drawable.IconCompat;
import androidx.core.net.UriCompat;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* loaded from: classes3.dex */
public class ShortcutInfoCompat {
    ComponentName BuiltInFictitiousFunctionClassFactory;
    Person[] DatabaseTableConfigUtil;
    LocusIdCompat GetContactSyncConfig;
    Set<String> KClassImpl$Data$declaredNonStaticMembers$2;
    Context MyBillsEntityDataFactory;
    IconCompat NetworkUserEntityData$$ExternalSyntheticLambda0;
    CharSequence NetworkUserEntityData$$ExternalSyntheticLambda1;
    CharSequence NetworkUserEntityData$$ExternalSyntheticLambda2;
    int NetworkUserEntityData$$ExternalSyntheticLambda8;
    CharSequence PlaceComponentResult;
    int getAuthRequestContext;
    PersistableBundle getErrorConfigVersion;
    boolean initRecordTimeStamp;
    String lookAheadTest;
    boolean moveToNextValue = true;
    Intent[] scheduleImpl;

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes3.dex */
    public @interface Surface {
    }

    ShortcutInfoCompat() {
    }

    public ShortcutInfo PlaceComponentResult() {
        android.app.Person build;
        ShortcutInfo.Builder intents = new ShortcutInfo.Builder(this.MyBillsEntityDataFactory, this.lookAheadTest).setShortLabel(this.NetworkUserEntityData$$ExternalSyntheticLambda1).setIntents(this.scheduleImpl);
        IconCompat iconCompat = this.NetworkUserEntityData$$ExternalSyntheticLambda0;
        if (iconCompat != null) {
            intents.setIcon(iconCompat.PlaceComponentResult(this.MyBillsEntityDataFactory));
        }
        if (!TextUtils.isEmpty(this.NetworkUserEntityData$$ExternalSyntheticLambda2)) {
            intents.setLongLabel(this.NetworkUserEntityData$$ExternalSyntheticLambda2);
        }
        if (!TextUtils.isEmpty(this.PlaceComponentResult)) {
            intents.setDisabledMessage(this.PlaceComponentResult);
        }
        ComponentName componentName = this.BuiltInFictitiousFunctionClassFactory;
        if (componentName != null) {
            intents.setActivity(componentName);
        }
        Set<String> set = this.KClassImpl$Data$declaredNonStaticMembers$2;
        if (set != null) {
            intents.setCategories(set);
        }
        intents.setRank(this.NetworkUserEntityData$$ExternalSyntheticLambda8);
        PersistableBundle persistableBundle = this.getErrorConfigVersion;
        if (persistableBundle != null) {
            intents.setExtras(persistableBundle);
        }
        if (Build.VERSION.SDK_INT >= 29) {
            Person[] personArr = this.DatabaseTableConfigUtil;
            if (personArr != null && personArr.length > 0) {
                int length = personArr.length;
                android.app.Person[] personArr2 = new android.app.Person[length];
                for (int i = 0; i < length; i++) {
                    build = new Person.Builder().setName(r4.BuiltInFictitiousFunctionClassFactory).setIcon(r2.PlaceComponentResult != null ? r4.PlaceComponentResult.moveToNextValue() : null).setUri(r4.scheduleImpl).setKey(r4.MyBillsEntityDataFactory).setBot(r4.getAuthRequestContext()).setImportant(this.DatabaseTableConfigUtil[i].MyBillsEntityDataFactory()).build();
                    personArr2[i] = build;
                }
                intents.setPersons(personArr2);
            }
            LocusIdCompat locusIdCompat = this.GetContactSyncConfig;
            if (locusIdCompat != null) {
                intents.setLocusId(locusIdCompat.BuiltInFictitiousFunctionClassFactory());
            }
            intents.setLongLived(this.initRecordTimeStamp);
        } else {
            intents.setExtras(MyBillsEntityDataFactory());
        }
        return intents.build();
    }

    private PersistableBundle MyBillsEntityDataFactory() {
        if (this.getErrorConfigVersion == null) {
            this.getErrorConfigVersion = new PersistableBundle();
        }
        androidx.core.app.Person[] personArr = this.DatabaseTableConfigUtil;
        if (personArr != null && personArr.length > 0) {
            this.getErrorConfigVersion.putInt("extraPersonCount", personArr.length);
            int i = 0;
            while (i < this.DatabaseTableConfigUtil.length) {
                PersistableBundle persistableBundle = this.getErrorConfigVersion;
                StringBuilder sb = new StringBuilder();
                sb.append("extraPerson_");
                int i2 = i + 1;
                sb.append(i2);
                persistableBundle.putPersistableBundle(sb.toString(), Person.Api22Impl.PlaceComponentResult(this.DatabaseTableConfigUtil[i]));
                i = i2;
            }
        }
        LocusIdCompat locusIdCompat = this.GetContactSyncConfig;
        if (locusIdCompat != null) {
            this.getErrorConfigVersion.putString("extraLocusId", locusIdCompat.MyBillsEntityDataFactory());
        }
        this.getErrorConfigVersion.putBoolean("extraLongLived", this.initRecordTimeStamp);
        return this.getErrorConfigVersion;
    }

    public boolean PlaceComponentResult(int i) {
        return (i & this.getAuthRequestContext) != 0;
    }

    /* loaded from: classes3.dex */
    public static class Builder {
        private boolean BuiltInFictitiousFunctionClassFactory;
        private Uri KClassImpl$Data$declaredNonStaticMembers$2;
        private Set<String> MyBillsEntityDataFactory;
        private Map<String, Map<String, List<String>>> PlaceComponentResult;
        private final ShortcutInfoCompat getAuthRequestContext;

        public Builder(Context context, String str) {
            ShortcutInfoCompat shortcutInfoCompat = new ShortcutInfoCompat();
            this.getAuthRequestContext = shortcutInfoCompat;
            shortcutInfoCompat.MyBillsEntityDataFactory = context;
            shortcutInfoCompat.lookAheadTest = str;
        }

        public Builder PlaceComponentResult(CharSequence charSequence) {
            this.getAuthRequestContext.NetworkUserEntityData$$ExternalSyntheticLambda1 = charSequence;
            return this;
        }

        public Builder MyBillsEntityDataFactory(CharSequence charSequence) {
            this.getAuthRequestContext.NetworkUserEntityData$$ExternalSyntheticLambda2 = charSequence;
            return this;
        }

        public Builder KClassImpl$Data$declaredNonStaticMembers$2(Intent intent) {
            return KClassImpl$Data$declaredNonStaticMembers$2(new Intent[]{intent});
        }

        public Builder KClassImpl$Data$declaredNonStaticMembers$2(Intent[] intentArr) {
            this.getAuthRequestContext.scheduleImpl = intentArr;
            return this;
        }

        public Builder getAuthRequestContext(IconCompat iconCompat) {
            this.getAuthRequestContext.NetworkUserEntityData$$ExternalSyntheticLambda0 = iconCompat;
            return this;
        }

        public ShortcutInfoCompat KClassImpl$Data$declaredNonStaticMembers$2() {
            if (TextUtils.isEmpty(this.getAuthRequestContext.NetworkUserEntityData$$ExternalSyntheticLambda1)) {
                throw new IllegalArgumentException("Shortcut must have a non-empty label");
            }
            if (this.getAuthRequestContext.scheduleImpl == null || this.getAuthRequestContext.scheduleImpl.length == 0) {
                throw new IllegalArgumentException("Shortcut must have an intent");
            }
            if (this.BuiltInFictitiousFunctionClassFactory) {
                if (this.getAuthRequestContext.GetContactSyncConfig == null) {
                    ShortcutInfoCompat shortcutInfoCompat = this.getAuthRequestContext;
                    shortcutInfoCompat.GetContactSyncConfig = new LocusIdCompat(shortcutInfoCompat.lookAheadTest);
                }
                this.getAuthRequestContext.initRecordTimeStamp = true;
            }
            if (this.MyBillsEntityDataFactory != null) {
                if (this.getAuthRequestContext.KClassImpl$Data$declaredNonStaticMembers$2 == null) {
                    this.getAuthRequestContext.KClassImpl$Data$declaredNonStaticMembers$2 = new HashSet();
                }
                this.getAuthRequestContext.KClassImpl$Data$declaredNonStaticMembers$2.addAll(this.MyBillsEntityDataFactory);
            }
            if (Build.VERSION.SDK_INT >= 21) {
                if (this.PlaceComponentResult != null) {
                    if (this.getAuthRequestContext.getErrorConfigVersion == null) {
                        this.getAuthRequestContext.getErrorConfigVersion = new PersistableBundle();
                    }
                    for (String str : this.PlaceComponentResult.keySet()) {
                        Map<String, List<String>> map = this.PlaceComponentResult.get(str);
                        this.getAuthRequestContext.getErrorConfigVersion.putStringArray(str, (String[]) map.keySet().toArray(new String[0]));
                        for (String str2 : map.keySet()) {
                            List<String> list = map.get(str2);
                            PersistableBundle persistableBundle = this.getAuthRequestContext.getErrorConfigVersion;
                            StringBuilder sb = new StringBuilder();
                            sb.append(str);
                            sb.append("/");
                            sb.append(str2);
                            persistableBundle.putStringArray(sb.toString(), list == null ? new String[0] : (String[]) list.toArray(new String[0]));
                        }
                    }
                }
                if (this.KClassImpl$Data$declaredNonStaticMembers$2 != null) {
                    if (this.getAuthRequestContext.getErrorConfigVersion == null) {
                        this.getAuthRequestContext.getErrorConfigVersion = new PersistableBundle();
                    }
                    this.getAuthRequestContext.getErrorConfigVersion.putString("extraSliceUri", UriCompat.KClassImpl$Data$declaredNonStaticMembers$2(this.KClassImpl$Data$declaredNonStaticMembers$2));
                }
            }
            return this.getAuthRequestContext;
        }
    }
}
