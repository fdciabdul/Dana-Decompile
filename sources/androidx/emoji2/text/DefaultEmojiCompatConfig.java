package androidx.emoji2.text;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.content.pm.ResolveInfo;
import android.content.pm.Signature;
import android.os.Build;
import androidx.core.provider.FontRequest;
import androidx.core.util.Preconditions;
import androidx.emoji2.text.EmojiCompat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes6.dex */
public final class DefaultEmojiCompatConfig {
    private DefaultEmojiCompatConfig() {
    }

    public static FontRequestEmojiCompatConfig BuiltInFictitiousFunctionClassFactory(Context context) {
        return (FontRequestEmojiCompatConfig) new DefaultEmojiCompatConfigFactory(null).PlaceComponentResult(context);
    }

    /* loaded from: classes6.dex */
    public static class DefaultEmojiCompatConfigFactory {
        private final DefaultEmojiCompatConfigHelper MyBillsEntityDataFactory;

        public DefaultEmojiCompatConfigFactory(DefaultEmojiCompatConfigHelper defaultEmojiCompatConfigHelper) {
            this.MyBillsEntityDataFactory = defaultEmojiCompatConfigHelper == null ? getAuthRequestContext() : defaultEmojiCompatConfigHelper;
        }

        public EmojiCompat.Config PlaceComponentResult(Context context) {
            return PlaceComponentResult(context, BuiltInFictitiousFunctionClassFactory(context));
        }

        private EmojiCompat.Config PlaceComponentResult(Context context, FontRequest fontRequest) {
            if (fontRequest == null) {
                return null;
            }
            return new FontRequestEmojiCompatConfig(context, fontRequest);
        }

        FontRequest BuiltInFictitiousFunctionClassFactory(Context context) {
            PackageManager packageManager = context.getPackageManager();
            Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(packageManager, "Package manager required to locate emoji font provider");
            ProviderInfo BuiltInFictitiousFunctionClassFactory = BuiltInFictitiousFunctionClassFactory(packageManager);
            if (BuiltInFictitiousFunctionClassFactory == null) {
                return null;
            }
            try {
                return KClassImpl$Data$declaredNonStaticMembers$2(BuiltInFictitiousFunctionClassFactory, packageManager);
            } catch (PackageManager.NameNotFoundException unused) {
                return null;
            }
        }

        private ProviderInfo BuiltInFictitiousFunctionClassFactory(PackageManager packageManager) {
            Iterator<ResolveInfo> it = this.MyBillsEntityDataFactory.getAuthRequestContext(packageManager, new Intent("androidx.content.action.LOAD_EMOJI_FONT"), 0).iterator();
            while (it.hasNext()) {
                ProviderInfo KClassImpl$Data$declaredNonStaticMembers$2 = this.MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2(it.next());
                if (BuiltInFictitiousFunctionClassFactory(KClassImpl$Data$declaredNonStaticMembers$2)) {
                    return KClassImpl$Data$declaredNonStaticMembers$2;
                }
            }
            return null;
        }

        private boolean BuiltInFictitiousFunctionClassFactory(ProviderInfo providerInfo) {
            return (providerInfo == null || providerInfo.applicationInfo == null || (providerInfo.applicationInfo.flags & 1) != 1) ? false : true;
        }

        private FontRequest KClassImpl$Data$declaredNonStaticMembers$2(ProviderInfo providerInfo, PackageManager packageManager) throws PackageManager.NameNotFoundException {
            String str = providerInfo.authority;
            String str2 = providerInfo.packageName;
            return new FontRequest(str, str2, "emojicompat-emoji-font", MyBillsEntityDataFactory(this.MyBillsEntityDataFactory.PlaceComponentResult(packageManager, str2)));
        }

        private List<List<byte[]>> MyBillsEntityDataFactory(Signature[] signatureArr) {
            ArrayList arrayList = new ArrayList();
            for (Signature signature : signatureArr) {
                arrayList.add(signature.toByteArray());
            }
            return Collections.singletonList(arrayList);
        }

        private static DefaultEmojiCompatConfigHelper getAuthRequestContext() {
            if (Build.VERSION.SDK_INT >= 28) {
                return new DefaultEmojiCompatConfigHelper_API28();
            }
            if (Build.VERSION.SDK_INT >= 19) {
                return new DefaultEmojiCompatConfigHelper_API19();
            }
            return new DefaultEmojiCompatConfigHelper();
        }
    }

    /* loaded from: classes6.dex */
    public static class DefaultEmojiCompatConfigHelper {
        public Signature[] PlaceComponentResult(PackageManager packageManager, String str) throws PackageManager.NameNotFoundException {
            return packageManager.getPackageInfo(str, 64).signatures;
        }

        public List<ResolveInfo> getAuthRequestContext(PackageManager packageManager, Intent intent, int i) {
            return Collections.emptyList();
        }

        public ProviderInfo KClassImpl$Data$declaredNonStaticMembers$2(ResolveInfo resolveInfo) {
            throw new IllegalStateException("Unable to get provider info prior to API 19");
        }
    }

    /* loaded from: classes6.dex */
    public static class DefaultEmojiCompatConfigHelper_API19 extends DefaultEmojiCompatConfigHelper {
        @Override // androidx.emoji2.text.DefaultEmojiCompatConfig.DefaultEmojiCompatConfigHelper
        public List<ResolveInfo> getAuthRequestContext(PackageManager packageManager, Intent intent, int i) {
            return packageManager.queryIntentContentProviders(intent, i);
        }

        @Override // androidx.emoji2.text.DefaultEmojiCompatConfig.DefaultEmojiCompatConfigHelper
        public ProviderInfo KClassImpl$Data$declaredNonStaticMembers$2(ResolveInfo resolveInfo) {
            return resolveInfo.providerInfo;
        }
    }

    /* loaded from: classes6.dex */
    public static class DefaultEmojiCompatConfigHelper_API28 extends DefaultEmojiCompatConfigHelper_API19 {
        @Override // androidx.emoji2.text.DefaultEmojiCompatConfig.DefaultEmojiCompatConfigHelper
        public Signature[] PlaceComponentResult(PackageManager packageManager, String str) throws PackageManager.NameNotFoundException {
            return packageManager.getPackageInfo(str, 64).signatures;
        }
    }
}
