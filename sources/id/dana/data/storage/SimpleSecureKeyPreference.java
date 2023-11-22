package id.dana.data.storage;

import com.alibaba.ariver.kernel.api.extension.bridge.BridgeDSL;
import java.util.ArrayList;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0013\u0018\u0000 22\u00020\u0001:\u00012B\u000f\u0012\u0006\u0010.\u001a\u00020\u0001¢\u0006\u0004\b0\u00101J0\u0010\u0005\u001a\"\u0012\b\u0012\u0006*\u00020\u00030\u0003\u0012\u0002\b\u0003*\u0010\u0012\b\u0012\u0006*\u00020\u00030\u0003\u0012\u0002\b\u00030\u00040\u0002H\u0096\u0001¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\b\u001a\u00020\u0007H\u0096\u0001¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\u000b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\r\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u000f\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u000f\u0010\u000eJ\u0017\u0010\u0011\u001a\u00020\u00102\u0006\u0010\n\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u001f\u0010\u0011\u001a\u00020\u00102\u0006\u0010\n\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0011\u0010\u0014J\u0017\u0010\u0016\u001a\u00020\u00152\u0006\u0010\n\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u0017\u0010\u0019\u001a\u00020\u00182\u0006\u0010\n\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ\u0017\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\n\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u001c\u0010\u001dJ-\u0010!\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u001e2\u0006\u0010\n\u001a\u00020\u00032\u000e\u0010 \u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u001fH\u0016¢\u0006\u0004\b!\u0010\"J\u0019\u0010#\u001a\u0004\u0018\u00010\u00032\u0006\u0010\n\u001a\u00020\u0003H\u0016¢\u0006\u0004\b#\u0010\u000eJ\u000f\u0010$\u001a\u00020\u0007H\u0002¢\u0006\u0004\b$\u0010\tJ%\u0010&\u001a\u00020\u0007\"\u0004\b\u0000\u0010\u001e2\u0006\u0010\n\u001a\u00020\u00032\u0006\u0010%\u001a\u00028\u0000H\u0016¢\u0006\u0004\b&\u0010'J!\u0010&\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u00032\b\u0010(\u001a\u0004\u0018\u00010\u0010H\u0016¢\u0006\u0004\b&\u0010)J!\u0010&\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u00032\b\u0010(\u001a\u0004\u0018\u00010\u0015H\u0016¢\u0006\u0004\b&\u0010*J!\u0010&\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u00032\b\u0010(\u001a\u0004\u0018\u00010\u0018H\u0016¢\u0006\u0004\b&\u0010+J!\u0010&\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u00032\b\u0010(\u001a\u0004\u0018\u00010\u001bH\u0016¢\u0006\u0004\b&\u0010,J!\u0010&\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u00032\b\u0010(\u001a\u0004\u0018\u00010\u0003H\u0016¢\u0006\u0004\b&\u0010-R\u0014\u0010.\u001a\u00020\u00018\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b.\u0010/"}, d2 = {"Lid/dana/data/storage/SimpleSecureKeyPreference;", "Lid/dana/data/storage/PreferenceFacade;", "", "", "", "all", "()Ljava/util/Map;", "", "clearAllData", "()V", "key", "clearData", "(Ljava/lang/String;)V", "createKey", "(Ljava/lang/String;)Ljava/lang/String;", "encryptKey", "", "getBoolean", "(Ljava/lang/String;)Ljava/lang/Boolean;", "defaultValue", "(Ljava/lang/String;Z)Ljava/lang/Boolean;", "", "getFloat", "(Ljava/lang/String;)Ljava/lang/Float;", "", "getInteger", "(Ljava/lang/String;)Ljava/lang/Integer;", "", "getLong", "(Ljava/lang/String;)Ljava/lang/Long;", "T", "Ljava/lang/Class;", "classOfT", "getObject", "(Ljava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;", "getString", "migrateOldDataIfNeeded", "obj", "saveData", "(Ljava/lang/String;Ljava/lang/Object;)V", "value", "(Ljava/lang/String;Ljava/lang/Boolean;)V", "(Ljava/lang/String;Ljava/lang/Float;)V", "(Ljava/lang/String;Ljava/lang/Integer;)V", "(Ljava/lang/String;Ljava/lang/Long;)V", "(Ljava/lang/String;Ljava/lang/String;)V", "delegate", "Lid/dana/data/storage/PreferenceFacade;", "<init>", "(Lid/dana/data/storage/PreferenceFacade;)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class SimpleSecureKeyPreference implements PreferenceFacade {

    /* renamed from: Companion  reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final PreferenceFacade delegate;

    @Override // id.dana.data.storage.PreferenceFacade
    public final Map<String, ?> all() {
        return this.delegate.all();
    }

    @Override // id.dana.data.storage.PreferenceFacade
    public final void clearAllData() {
        this.delegate.clearAllData();
    }

    public SimpleSecureKeyPreference(PreferenceFacade preferenceFacade) {
        Intrinsics.checkNotNullParameter(preferenceFacade, "");
        this.delegate = preferenceFacade;
        migrateOldDataIfNeeded();
    }

    private final void migrateOldDataIfNeeded() {
        PreferenceFacade preferenceFacade = this.delegate;
        if (preferenceFacade instanceof SecurityGuardPreference) {
            Boolean booleanWithRawKey = ((SecurityGuardPreference) preferenceFacade).getBooleanWithRawKey(LocalStorageFactory.KEY_SECURED);
            Intrinsics.checkNotNullExpressionValue(booleanWithRawKey, "");
            if (booleanWithRawKey.booleanValue()) {
                return;
            }
        }
        Boolean bool = this.delegate.getBoolean(LocalStorageFactory.KEY_SECURED);
        Intrinsics.checkNotNullExpressionValue(bool, "");
        if (bool.booleanValue()) {
            return;
        }
        try {
            Map<String, ?> all = all();
            clearAllData();
            Intrinsics.checkNotNullExpressionValue(all, "");
            for (Map.Entry<String, ?> entry : all.entrySet()) {
                String key = entry.getKey();
                Object value = entry.getValue();
                PreferenceFacade preferenceFacade2 = this.delegate;
                if (preferenceFacade2 instanceof SecurityGuardPreference) {
                    Intrinsics.checkNotNullExpressionValue(key, "");
                    ((SecurityGuardPreference) preferenceFacade2).saveRawDataWithKey(encryptKey(key), String.valueOf(value));
                } else {
                    Intrinsics.checkNotNullExpressionValue(key, "");
                    preferenceFacade2.saveData(encryptKey(key), (String) value);
                }
            }
            PreferenceFacade preferenceFacade3 = this.delegate;
            if (preferenceFacade3 instanceof SecurityGuardPreference) {
                ((SecurityGuardPreference) preferenceFacade3).saveDataWithRawKey(LocalStorageFactory.KEY_SECURED, Boolean.TRUE);
            } else {
                preferenceFacade3.saveData(LocalStorageFactory.KEY_SECURED, Boolean.TRUE);
            }
        } catch (Exception unused) {
        }
    }

    private final String encryptKey(String key) {
        String str = key;
        ArrayList arrayList = new ArrayList(str.length());
        for (int i = 0; i < str.length(); i++) {
            arrayList.add(Character.valueOf((char) (str.charAt(i) + 5)));
        }
        return CollectionsKt.joinToString$default(arrayList, "", null, null, 0, null, null, 62, null);
    }

    @Override // id.dana.data.storage.PreferenceFacade
    public final String createKey(String key) {
        Intrinsics.checkNotNullParameter(key, "");
        String createKey = this.delegate.createKey(key);
        Intrinsics.checkNotNullExpressionValue(createKey, "");
        return encryptKey(createKey);
    }

    @Override // id.dana.data.storage.PreferenceFacade
    public final <T> void saveData(String key, T obj) {
        Intrinsics.checkNotNullParameter(key, "");
        this.delegate.saveData(createKey(key), (String) obj);
    }

    @Override // id.dana.data.storage.PreferenceFacade
    public final void saveData(String key, Boolean value) {
        Intrinsics.checkNotNullParameter(key, "");
        this.delegate.saveData(createKey(key), value);
    }

    @Override // id.dana.data.storage.PreferenceFacade
    public final void saveData(String key, Float value) {
        Intrinsics.checkNotNullParameter(key, "");
        this.delegate.saveData(createKey(key), value);
    }

    @Override // id.dana.data.storage.PreferenceFacade
    public final void saveData(String key, Integer value) {
        Intrinsics.checkNotNullParameter(key, "");
        this.delegate.saveData(createKey(key), value);
    }

    @Override // id.dana.data.storage.PreferenceFacade
    public final void saveData(String key, Long value) {
        Intrinsics.checkNotNullParameter(key, "");
        this.delegate.saveData(createKey(key), value);
    }

    @Override // id.dana.data.storage.PreferenceFacade
    public final void saveData(String key, String value) {
        Intrinsics.checkNotNullParameter(key, "");
        this.delegate.saveData(createKey(key), value);
    }

    @Override // id.dana.data.storage.PreferenceFacade
    public final Boolean getBoolean(String key) {
        boolean parseBoolean;
        Intrinsics.checkNotNullParameter(key, "");
        String createKey = createKey(key);
        try {
            Boolean bool = this.delegate.getBoolean(createKey);
            Intrinsics.checkNotNullExpressionValue(bool, "");
            parseBoolean = bool.booleanValue();
        } catch (ClassCastException unused) {
            parseBoolean = Boolean.parseBoolean(this.delegate.getString(createKey));
        }
        return Boolean.valueOf(parseBoolean);
    }

    @Override // id.dana.data.storage.PreferenceFacade
    public final Boolean getBoolean(String key, boolean defaultValue) {
        Intrinsics.checkNotNullParameter(key, "");
        String createKey = createKey(key);
        try {
            Boolean bool = this.delegate.getBoolean(createKey, defaultValue);
            Intrinsics.checkNotNullExpressionValue(bool, "");
            defaultValue = bool.booleanValue();
        } catch (ClassCastException unused) {
            String string = this.delegate.getString(createKey);
            if (string != null) {
                defaultValue = Boolean.parseBoolean(string);
            }
        }
        return Boolean.valueOf(defaultValue);
    }

    @Override // id.dana.data.storage.PreferenceFacade
    public final Float getFloat(String key) {
        float parseFloat;
        Intrinsics.checkNotNullParameter(key, "");
        String createKey = createKey(key);
        try {
            Float f = this.delegate.getFloat(createKey);
            Intrinsics.checkNotNullExpressionValue(f, "");
            parseFloat = f.floatValue();
        } catch (ClassCastException unused) {
            String string = this.delegate.getString(createKey);
            parseFloat = string != null ? Float.parseFloat(string) : 0.0f;
        }
        return Float.valueOf(parseFloat);
    }

    @Override // id.dana.data.storage.PreferenceFacade
    public final Integer getInteger(String key) {
        int parseInt;
        Intrinsics.checkNotNullParameter(key, "");
        String createKey = createKey(key);
        try {
            Integer integer = this.delegate.getInteger(createKey);
            Intrinsics.checkNotNullExpressionValue(integer, "");
            parseInt = integer.intValue();
        } catch (ClassCastException unused) {
            String string = this.delegate.getString(createKey);
            parseInt = string != null ? Integer.parseInt(string) : 0;
        }
        return Integer.valueOf(parseInt);
    }

    @Override // id.dana.data.storage.PreferenceFacade
    public final Long getLong(String key) {
        long parseLong;
        Intrinsics.checkNotNullParameter(key, "");
        String createKey = createKey(key);
        try {
            Long l = this.delegate.getLong(createKey);
            Intrinsics.checkNotNullExpressionValue(l, "");
            parseLong = l.longValue();
        } catch (ClassCastException unused) {
            String string = this.delegate.getString(createKey);
            parseLong = string != null ? Long.parseLong(string) : 0L;
        }
        return Long.valueOf(parseLong);
    }

    @Override // id.dana.data.storage.PreferenceFacade
    public final <T> T getObject(String key, Class<T> classOfT) {
        Intrinsics.checkNotNullParameter(key, "");
        return (T) this.delegate.getObject(createKey(key), classOfT);
    }

    @Override // id.dana.data.storage.PreferenceFacade
    public final String getString(String key) {
        Intrinsics.checkNotNullParameter(key, "");
        return this.delegate.getString(createKey(key));
    }

    @Override // id.dana.data.storage.PreferenceFacade
    public final void clearData(String key) {
        Intrinsics.checkNotNullParameter(key, "");
        this.delegate.clearData(createKey(key));
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\nJ\u0018\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0086\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\r\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\b"}, d2 = {"Lid/dana/data/storage/SimpleSecureKeyPreference$Companion;", "", "Lid/dana/data/storage/PreferenceFacade;", "delegate", BridgeDSL.INVOKE, "(Lid/dana/data/storage/PreferenceFacade;)Lid/dana/data/storage/PreferenceFacade;", "", "skipMigration", "()Z", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final boolean skipMigration() {
            return false;
        }

        private Companion() {
        }

        public final PreferenceFacade invoke(PreferenceFacade delegate) {
            Intrinsics.checkNotNullParameter(delegate, "");
            if (skipMigration()) {
                return delegate;
            }
            SimpleSecureKeyPreference simpleSecureKeyPreference = new SimpleSecureKeyPreference(delegate);
            if (delegate instanceof SecurityGuardPreference) {
                ((SecurityGuardPreference) delegate).setUsingSimpleSecureKey(true);
            }
            return simpleSecureKeyPreference;
        }
    }
}
