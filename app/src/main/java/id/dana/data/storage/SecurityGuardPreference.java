package id.dana.data.storage;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.alibaba.wireless.security.open.SecException;
import id.dana.data.foundation.facade.SecurityGuardFacade;
import id.dana.data.storage.LocalStorageFactory;
import java.util.Map;

/* loaded from: classes4.dex */
public class SecurityGuardPreference implements PreferenceFacade {
    private static final String TAG = "SGStorage";
    private final LocalStorageFactory.Builder builder;
    private final Encryptor encryptor;
    private final SharedPreferences sharedPreferences;
    private boolean usingSimpleSecureKey;

    /* loaded from: classes4.dex */
    public interface Encryptor {
        String decryptString(String str) throws SecException;

        String encryptString(String str) throws SecException;
    }

    public SecurityGuardPreference(LocalStorageFactory.Builder builder) {
        this.builder = builder;
        this.encryptor = EncryptorFactory.create(builder.context);
        Context context = builder.context;
        StringBuilder sb = new StringBuilder();
        sb.append(builder.preferenceGroup);
        sb.append(TAG);
        this.sharedPreferences = context.getSharedPreferences(sb.toString(), 0);
    }

    @Override // id.dana.data.storage.PreferenceFacade
    public void saveData(String str, String str2) {
        try {
            if (!this.usingSimpleSecureKey) {
                str = createKey(str);
            }
            this.sharedPreferences.edit().putString(str, getEncryptData(str2)).apply();
        } catch (Exception unused) {
        }
    }

    private String getEncryptData(String str) {
        try {
            return this.encryptor.encryptString(str);
        } catch (SecException unused) {
            return "";
        }
    }

    @Override // id.dana.data.storage.PreferenceFacade
    public String getString(String str) {
        if (!this.usingSimpleSecureKey) {
            str = createKey(str);
        }
        return getDecryptData(this.sharedPreferences.getString(str, null));
    }

    @Override // id.dana.data.storage.PreferenceFacade
    public void saveData(String str, Integer num) {
        saveData(str, String.valueOf(num));
    }

    @Override // id.dana.data.storage.PreferenceFacade
    public Integer getInteger(String str) {
        try {
            return Integer.valueOf(Integer.parseInt(getString(str)));
        } catch (Exception unused) {
            return 0;
        }
    }

    @Override // id.dana.data.storage.PreferenceFacade
    public void saveData(String str, Long l) {
        saveData(str, String.valueOf(l));
    }

    @Override // id.dana.data.storage.PreferenceFacade
    public Long getLong(String str) {
        try {
            return Long.valueOf(Long.parseLong(getString(str)));
        } catch (Exception unused) {
            return 0L;
        }
    }

    @Override // id.dana.data.storage.PreferenceFacade
    public void saveData(String str, Float f) {
        saveData(str, String.valueOf(f));
    }

    @Override // id.dana.data.storage.PreferenceFacade
    public Float getFloat(String str) {
        try {
            return Float.valueOf(Float.parseFloat(getString(str)));
        } catch (Exception unused) {
            return Float.valueOf(0.0f);
        }
    }

    @Override // id.dana.data.storage.PreferenceFacade
    public void saveData(String str, Boolean bool) {
        saveData(str, String.valueOf(bool));
    }

    public void saveDataWithRawKey(String str, Boolean bool) {
        try {
            this.sharedPreferences.edit().putString(str, getEncryptData(String.valueOf(bool))).apply();
        } catch (Exception unused) {
        }
    }

    @Override // id.dana.data.storage.PreferenceFacade
    public Boolean getBoolean(String str) {
        try {
            return Boolean.valueOf(Boolean.parseBoolean(getString(str)));
        } catch (Exception unused) {
            return Boolean.FALSE;
        }
    }

    public void setUsingSimpleSecureKey(boolean z) {
        this.usingSimpleSecureKey = z;
    }

    public Boolean getBooleanWithRawKey(String str) {
        try {
            return Boolean.valueOf(Boolean.parseBoolean(getStringWithRawKey(str)));
        } catch (Exception unused) {
            return Boolean.FALSE;
        }
    }

    private String getStringWithRawKey(String str) {
        return getDecryptData(this.sharedPreferences.getString(str, null));
    }

    @Override // id.dana.data.storage.PreferenceFacade
    public Boolean getBoolean(String str, boolean z) {
        try {
            return Boolean.valueOf(Boolean.parseBoolean(getString(str)));
        } catch (Exception unused) {
            return Boolean.FALSE;
        }
    }

    @Override // id.dana.data.storage.PreferenceFacade
    public <T> void saveData(String str, T t) {
        saveData(str, this.builder.serializerFacade.serialize(t));
    }

    public void saveRawDataWithKey(String str, String str2) {
        try {
            this.sharedPreferences.edit().putString(str, str2).apply();
        } catch (Exception unused) {
        }
    }

    @Override // id.dana.data.storage.PreferenceFacade
    public <T> T getObject(String str, Class<T> cls) {
        return (T) this.builder.serializerFacade.deserialize(getString(str), cls);
    }

    @Override // id.dana.data.storage.PreferenceFacade
    public void clearData(String str) {
        this.sharedPreferences.edit().remove(createKey(str)).apply();
    }

    @Override // id.dana.data.storage.PreferenceFacade
    public void clearAllData() {
        this.sharedPreferences.edit().clear().apply();
    }

    private String getDecryptData(String str) {
        if (str == null) {
            return null;
        }
        try {
            return this.encryptor.decryptString(str);
        } catch (SecException unused) {
            return null;
        }
    }

    @Override // id.dana.data.storage.PreferenceFacade
    public Map<String, ?> all() {
        return this.sharedPreferences.getAll();
    }

    @Override // id.dana.data.storage.PreferenceFacade
    public String createKey(String str) {
        return getKeyWithPassword(str);
    }

    private String getKeyWithPassword(String str) {
        LocalStorageFactory.Builder builder = this.builder;
        if (builder == null || TextUtils.isEmpty(builder.password)) {
            return str;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(this.builder.password);
        return sb.toString();
    }

    /* loaded from: classes4.dex */
    public static class EncryptorFactory {
        private EncryptorFactory() {
        }

        public static Encryptor create(Context context) {
            return new Encryptor(context) { // from class: id.dana.data.storage.SecurityGuardPreference.EncryptorFactory.1
                final /* synthetic */ Context MyBillsEntityDataFactory;
                private final SecurityGuardFacade getAuthRequestContext;

                {
                    this.MyBillsEntityDataFactory = context;
                    this.getAuthRequestContext = new SecurityGuardFacade(context);
                }

                @Override // id.dana.data.storage.SecurityGuardPreference.Encryptor
                public String encryptString(String str) throws SecException {
                    return this.getAuthRequestContext.PlaceComponentResult().getDynamicDataEncryptComp().dynamicEncryptDDp(str);
                }

                @Override // id.dana.data.storage.SecurityGuardPreference.Encryptor
                public String decryptString(String str) throws SecException {
                    return this.getAuthRequestContext.PlaceComponentResult().getDynamicDataEncryptComp().dynamicDecryptDDp(str);
                }
            };
        }
    }
}
