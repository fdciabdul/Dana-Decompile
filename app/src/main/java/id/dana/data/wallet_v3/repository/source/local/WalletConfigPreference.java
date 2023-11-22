package id.dana.data.wallet_v3.repository.source.local;

import android.content.Context;
import com.ap.zoloz.hummer.biz.HummerConstants;
import com.google.gson.Gson;
import id.dana.data.storage.LocalStorageFactory;
import id.dana.data.storage.PreferenceFacade;
import id.dana.data.storage.Serializer;
import id.dana.data.storage.SimpleSecureKeyPreference;
import id.dana.domain.wallet_v3.model.WalletConfig;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018B!\b\u0007\u0012\u0006\u0010\u0013\u001a\u00020\u0012\u0012\u0006\u0010\u0015\u001a\u00020\u0014\u0012\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u0016\u0010\u0017J\u000f\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0014\u0010\n\u001a\u00020\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0014\u0010\r\u001a\u00020\f8\u0002X\u0082D¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0014\u0010\u0010\u001a\u00020\u000f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011"}, d2 = {"Lid/dana/data/wallet_v3/repository/source/local/WalletConfigPreference;", "", "Lid/dana/domain/wallet_v3/model/WalletConfig;", "getWalletConfig", "()Lid/dana/domain/wallet_v3/model/WalletConfig;", "walletConfig", "", "saveWalletConfig", "(Lid/dana/domain/wallet_v3/model/WalletConfig;)Z", "Lcom/google/gson/Gson;", "gson", "Lcom/google/gson/Gson;", "", "personalTabPreference", "Ljava/lang/String;", "Lid/dana/data/storage/PreferenceFacade;", "preferenceFacade", "Lid/dana/data/storage/PreferenceFacade;", "Landroid/content/Context;", HummerConstants.CONTEXT, "Lid/dana/data/storage/Serializer;", "serializer", "<init>", "(Landroid/content/Context;Lid/dana/data/storage/Serializer;Lcom/google/gson/Gson;)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class WalletConfigPreference {
    public static final String WALLET_CONFIG = "WALLET_CONFIG";
    private final Gson gson;
    private final String personalTabPreference;
    private final PreferenceFacade preferenceFacade;

    @Inject
    public WalletConfigPreference(Context context, Serializer serializer, Gson gson) {
        Intrinsics.checkNotNullParameter(context, "");
        Intrinsics.checkNotNullParameter(serializer, "");
        Intrinsics.checkNotNullParameter(gson, "");
        this.gson = gson;
        this.personalTabPreference = "WalletConfigPreferenceproduction";
        PreferenceFacade createData2 = new LocalStorageFactory(new LocalStorageFactory.Builder(context).setPreferenceGroup("WalletConfigPreferenceproduction").setUseDrutherPreference(true).setSerializerFacade(serializer)).createData2("local");
        Intrinsics.checkNotNullExpressionValue(createData2, "");
        this.preferenceFacade = new SimpleSecureKeyPreference(createData2);
    }

    public final boolean saveWalletConfig(WalletConfig walletConfig) {
        Intrinsics.checkNotNullParameter(walletConfig, "");
        this.preferenceFacade.saveData(WALLET_CONFIG, this.gson.toJson(walletConfig));
        return true;
    }

    public final WalletConfig getWalletConfig() {
        String string = this.preferenceFacade.getString(WALLET_CONFIG);
        if (string != null) {
            return (WalletConfig) this.gson.fromJson(string, WalletConfig.class);
        }
        return null;
    }
}
