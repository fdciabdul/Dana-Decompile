package androidx.emoji2.text;

import android.content.Context;
import android.content.pm.PackageManager;
import android.database.ContentObserver;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Handler;
import android.os.SystemClock;
import androidx.core.graphics.TypefaceCompatUtil;
import androidx.core.os.TraceCompat;
import androidx.core.provider.FontRequest;
import androidx.core.provider.FontsContractCompat;
import androidx.core.util.Preconditions;
import androidx.emoji2.text.EmojiCompat;
import androidx.emoji2.text.FontRequestEmojiCompatConfig;
import java.nio.ByteBuffer;
import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;

/* loaded from: classes6.dex */
public class FontRequestEmojiCompatConfig extends EmojiCompat.Config {
    private static final FontProviderHelper getErrorConfigVersion = new FontProviderHelper();

    /* loaded from: classes6.dex */
    public static abstract class RetryPolicy {
        public abstract long getAuthRequestContext();
    }

    /* loaded from: classes6.dex */
    public static class ExponentialBackoffRetryPolicy extends RetryPolicy {
        private long MyBillsEntityDataFactory;
        private final long PlaceComponentResult;

        @Override // androidx.emoji2.text.FontRequestEmojiCompatConfig.RetryPolicy
        public long getAuthRequestContext() {
            if (this.MyBillsEntityDataFactory == 0) {
                this.MyBillsEntityDataFactory = SystemClock.uptimeMillis();
                return 0L;
            }
            long uptimeMillis = SystemClock.uptimeMillis() - this.MyBillsEntityDataFactory;
            if (uptimeMillis > this.PlaceComponentResult) {
                return -1L;
            }
            return Math.min(Math.max(uptimeMillis, 1000L), this.PlaceComponentResult - uptimeMillis);
        }
    }

    public FontRequestEmojiCompatConfig(Context context, FontRequest fontRequest) {
        super(new FontRequestMetadataLoader(context, fontRequest, getErrorConfigVersion));
    }

    public FontRequestEmojiCompatConfig getAuthRequestContext(Executor executor) {
        ((FontRequestMetadataLoader) KClassImpl$Data$declaredNonStaticMembers$2()).PlaceComponentResult(executor);
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public static class FontRequestMetadataLoader implements EmojiCompat.MetadataRepoLoader {
        EmojiCompat.MetadataRepoLoaderCallback BuiltInFictitiousFunctionClassFactory;
        private RetryPolicy DatabaseTableConfigUtil;
        private final Context KClassImpl$Data$declaredNonStaticMembers$2;
        private final FontProviderHelper MyBillsEntityDataFactory;
        private Handler NetworkUserEntityData$$ExternalSyntheticLambda0;
        private Executor PlaceComponentResult;
        private final Object getAuthRequestContext = new Object();
        private ContentObserver getErrorConfigVersion;
        private ThreadPoolExecutor lookAheadTest;
        private Runnable moveToNextValue;
        private final FontRequest scheduleImpl;

        FontRequestMetadataLoader(Context context, FontRequest fontRequest, FontProviderHelper fontProviderHelper) {
            Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(context, "Context cannot be null");
            Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(fontRequest, "FontRequest cannot be null");
            this.KClassImpl$Data$declaredNonStaticMembers$2 = context.getApplicationContext();
            this.scheduleImpl = fontRequest;
            this.MyBillsEntityDataFactory = fontProviderHelper;
        }

        public void PlaceComponentResult(Executor executor) {
            synchronized (this.getAuthRequestContext) {
                this.PlaceComponentResult = executor;
            }
        }

        @Override // androidx.emoji2.text.EmojiCompat.MetadataRepoLoader
        public void PlaceComponentResult(EmojiCompat.MetadataRepoLoaderCallback metadataRepoLoaderCallback) {
            Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(metadataRepoLoaderCallback, "LoaderCallback cannot be null");
            synchronized (this.getAuthRequestContext) {
                this.BuiltInFictitiousFunctionClassFactory = metadataRepoLoaderCallback;
            }
            BuiltInFictitiousFunctionClassFactory();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void BuiltInFictitiousFunctionClassFactory() {
            synchronized (this.getAuthRequestContext) {
                if (this.BuiltInFictitiousFunctionClassFactory == null) {
                    return;
                }
                if (this.PlaceComponentResult == null) {
                    ThreadPoolExecutor authRequestContext = ConcurrencyHelpers.getAuthRequestContext("emojiCompat");
                    this.lookAheadTest = authRequestContext;
                    this.PlaceComponentResult = authRequestContext;
                }
                this.PlaceComponentResult.execute(new Runnable() { // from class: androidx.emoji2.text.FontRequestEmojiCompatConfig$FontRequestMetadataLoader$$ExternalSyntheticLambda0
                    @Override // java.lang.Runnable
                    public final void run() {
                        FontRequestEmojiCompatConfig.FontRequestMetadataLoader.this.getAuthRequestContext();
                    }
                });
            }
        }

        private FontsContractCompat.FontInfo KClassImpl$Data$declaredNonStaticMembers$2() {
            try {
                FontsContractCompat.FontFamilyResult MyBillsEntityDataFactory = this.MyBillsEntityDataFactory.MyBillsEntityDataFactory(this.KClassImpl$Data$declaredNonStaticMembers$2, this.scheduleImpl);
                if (MyBillsEntityDataFactory.BuiltInFictitiousFunctionClassFactory() != 0) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("fetchFonts failed (");
                    sb.append(MyBillsEntityDataFactory.BuiltInFictitiousFunctionClassFactory());
                    sb.append(")");
                    throw new RuntimeException(sb.toString());
                }
                FontsContractCompat.FontInfo[] authRequestContext = MyBillsEntityDataFactory.getAuthRequestContext();
                if (authRequestContext == null || authRequestContext.length == 0) {
                    throw new RuntimeException("fetchFonts failed (empty result)");
                }
                return authRequestContext[0];
            } catch (PackageManager.NameNotFoundException e) {
                throw new RuntimeException("provider not found", e);
            }
        }

        private void KClassImpl$Data$declaredNonStaticMembers$2(Uri uri, long j) {
            synchronized (this.getAuthRequestContext) {
                Handler handler = this.NetworkUserEntityData$$ExternalSyntheticLambda0;
                if (handler == null) {
                    handler = ConcurrencyHelpers.BuiltInFictitiousFunctionClassFactory();
                    this.NetworkUserEntityData$$ExternalSyntheticLambda0 = handler;
                }
                if (this.getErrorConfigVersion == null) {
                    ContentObserver contentObserver = new ContentObserver(handler) { // from class: androidx.emoji2.text.FontRequestEmojiCompatConfig.FontRequestMetadataLoader.1
                        @Override // android.database.ContentObserver
                        public void onChange(boolean z, Uri uri2) {
                            FontRequestMetadataLoader.this.BuiltInFictitiousFunctionClassFactory();
                        }
                    };
                    this.getErrorConfigVersion = contentObserver;
                    this.MyBillsEntityDataFactory.PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2, uri, contentObserver);
                }
                if (this.moveToNextValue == null) {
                    this.moveToNextValue = new Runnable() { // from class: androidx.emoji2.text.FontRequestEmojiCompatConfig$FontRequestMetadataLoader$$ExternalSyntheticLambda1
                        @Override // java.lang.Runnable
                        public final void run() {
                            FontRequestEmojiCompatConfig.FontRequestMetadataLoader.this.BuiltInFictitiousFunctionClassFactory();
                        }
                    };
                }
                handler.postDelayed(this.moveToNextValue, j);
            }
        }

        private void MyBillsEntityDataFactory() {
            synchronized (this.getAuthRequestContext) {
                this.BuiltInFictitiousFunctionClassFactory = null;
                ContentObserver contentObserver = this.getErrorConfigVersion;
                if (contentObserver != null) {
                    this.MyBillsEntityDataFactory.BuiltInFictitiousFunctionClassFactory(this.KClassImpl$Data$declaredNonStaticMembers$2, contentObserver);
                    this.getErrorConfigVersion = null;
                }
                Handler handler = this.NetworkUserEntityData$$ExternalSyntheticLambda0;
                if (handler != null) {
                    handler.removeCallbacks(this.moveToNextValue);
                }
                this.NetworkUserEntityData$$ExternalSyntheticLambda0 = null;
                ThreadPoolExecutor threadPoolExecutor = this.lookAheadTest;
                if (threadPoolExecutor != null) {
                    threadPoolExecutor.shutdown();
                }
                this.PlaceComponentResult = null;
                this.lookAheadTest = null;
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void getAuthRequestContext() {
            synchronized (this.getAuthRequestContext) {
                if (this.BuiltInFictitiousFunctionClassFactory == null) {
                    return;
                }
                try {
                    FontsContractCompat.FontInfo KClassImpl$Data$declaredNonStaticMembers$2 = KClassImpl$Data$declaredNonStaticMembers$2();
                    int KClassImpl$Data$declaredNonStaticMembers$22 = KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2();
                    if (KClassImpl$Data$declaredNonStaticMembers$22 == 2) {
                        synchronized (this.getAuthRequestContext) {
                            RetryPolicy retryPolicy = this.DatabaseTableConfigUtil;
                            if (retryPolicy != null) {
                                long authRequestContext = retryPolicy.getAuthRequestContext();
                                if (authRequestContext >= 0) {
                                    KClassImpl$Data$declaredNonStaticMembers$2(KClassImpl$Data$declaredNonStaticMembers$2.PlaceComponentResult(), authRequestContext);
                                    return;
                                }
                            }
                        }
                    }
                    if (KClassImpl$Data$declaredNonStaticMembers$22 != 0) {
                        StringBuilder sb = new StringBuilder();
                        sb.append("fetchFonts result is not OK. (");
                        sb.append(KClassImpl$Data$declaredNonStaticMembers$22);
                        sb.append(")");
                        throw new RuntimeException(sb.toString());
                    }
                    try {
                        TraceCompat.BuiltInFictitiousFunctionClassFactory("EmojiCompat.FontRequestEmojiCompatConfig.buildTypeface");
                        Typeface authRequestContext2 = this.MyBillsEntityDataFactory.getAuthRequestContext(this.KClassImpl$Data$declaredNonStaticMembers$2, KClassImpl$Data$declaredNonStaticMembers$2);
                        ByteBuffer PlaceComponentResult = TypefaceCompatUtil.PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2, null, KClassImpl$Data$declaredNonStaticMembers$2.PlaceComponentResult());
                        if (PlaceComponentResult == null || authRequestContext2 == null) {
                            throw new RuntimeException("Unable to open file.");
                        }
                        MetadataRepo BuiltInFictitiousFunctionClassFactory = MetadataRepo.BuiltInFictitiousFunctionClassFactory(authRequestContext2, PlaceComponentResult);
                        TraceCompat.BuiltInFictitiousFunctionClassFactory();
                        synchronized (this.getAuthRequestContext) {
                            EmojiCompat.MetadataRepoLoaderCallback metadataRepoLoaderCallback = this.BuiltInFictitiousFunctionClassFactory;
                            if (metadataRepoLoaderCallback != null) {
                                metadataRepoLoaderCallback.PlaceComponentResult(BuiltInFictitiousFunctionClassFactory);
                            }
                        }
                        MyBillsEntityDataFactory();
                    } catch (Throwable th) {
                        TraceCompat.BuiltInFictitiousFunctionClassFactory();
                        throw th;
                    }
                } catch (Throwable th2) {
                    synchronized (this.getAuthRequestContext) {
                        EmojiCompat.MetadataRepoLoaderCallback metadataRepoLoaderCallback2 = this.BuiltInFictitiousFunctionClassFactory;
                        if (metadataRepoLoaderCallback2 != null) {
                            metadataRepoLoaderCallback2.KClassImpl$Data$declaredNonStaticMembers$2(th2);
                        }
                        MyBillsEntityDataFactory();
                    }
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class FontProviderHelper {
        public FontsContractCompat.FontFamilyResult MyBillsEntityDataFactory(Context context, FontRequest fontRequest) throws PackageManager.NameNotFoundException {
            return FontsContractCompat.PlaceComponentResult(context, null, fontRequest);
        }

        public Typeface getAuthRequestContext(Context context, FontsContractCompat.FontInfo fontInfo) throws PackageManager.NameNotFoundException {
            return FontsContractCompat.MyBillsEntityDataFactory(context, null, new FontsContractCompat.FontInfo[]{fontInfo});
        }

        public void PlaceComponentResult(Context context, Uri uri, ContentObserver contentObserver) {
            context.getContentResolver().registerContentObserver(uri, false, contentObserver);
        }

        public void BuiltInFictitiousFunctionClassFactory(Context context, ContentObserver contentObserver) {
            context.getContentResolver().unregisterContentObserver(contentObserver);
        }
    }
}
