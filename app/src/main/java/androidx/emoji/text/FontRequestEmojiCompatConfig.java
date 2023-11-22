package androidx.emoji.text;

import android.content.Context;
import android.content.pm.PackageManager;
import android.database.ContentObserver;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.SystemClock;
import androidx.core.graphics.TypefaceCompatUtil;
import androidx.core.provider.FontRequest;
import androidx.core.provider.FontsContractCompat;
import androidx.core.util.Preconditions;
import androidx.emoji.text.EmojiCompat;
import java.nio.ByteBuffer;

/* loaded from: classes6.dex */
public class FontRequestEmojiCompatConfig extends EmojiCompat.Config {
    private static final FontProviderHelper getErrorConfigVersion = new FontProviderHelper();

    /* loaded from: classes6.dex */
    public static abstract class RetryPolicy {
        public abstract long getAuthRequestContext();
    }

    /* loaded from: classes6.dex */
    public static class ExponentialBackoffRetryPolicy extends RetryPolicy {
        private long BuiltInFictitiousFunctionClassFactory;
        private final long KClassImpl$Data$declaredNonStaticMembers$2;

        @Override // androidx.emoji.text.FontRequestEmojiCompatConfig.RetryPolicy
        public long getAuthRequestContext() {
            if (this.BuiltInFictitiousFunctionClassFactory == 0) {
                this.BuiltInFictitiousFunctionClassFactory = SystemClock.uptimeMillis();
                return 0L;
            }
            long uptimeMillis = SystemClock.uptimeMillis() - this.BuiltInFictitiousFunctionClassFactory;
            if (uptimeMillis > this.KClassImpl$Data$declaredNonStaticMembers$2) {
                return -1L;
            }
            return Math.min(Math.max(uptimeMillis, 1000L), this.KClassImpl$Data$declaredNonStaticMembers$2 - uptimeMillis);
        }
    }

    public FontRequestEmojiCompatConfig(Context context, FontRequest fontRequest) {
        super(new FontRequestMetadataLoader(context, fontRequest, getErrorConfigVersion));
    }

    /* loaded from: classes6.dex */
    static class FontRequestMetadataLoader implements EmojiCompat.MetadataRepoLoader {
        private final Context BuiltInFictitiousFunctionClassFactory;
        private Runnable KClassImpl$Data$declaredNonStaticMembers$2;
        private Handler MyBillsEntityDataFactory;
        private final FontRequest NetworkUserEntityData$$ExternalSyntheticLambda0;
        EmojiCompat.MetadataRepoLoaderCallback PlaceComponentResult;
        private final FontProviderHelper getAuthRequestContext;
        private final Object getErrorConfigVersion = new Object();
        private RetryPolicy lookAheadTest;
        private ContentObserver moveToNextValue;
        private HandlerThread scheduleImpl;

        FontRequestMetadataLoader(Context context, FontRequest fontRequest, FontProviderHelper fontProviderHelper) {
            Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(context, "Context cannot be null");
            Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(fontRequest, "FontRequest cannot be null");
            this.BuiltInFictitiousFunctionClassFactory = context.getApplicationContext();
            this.NetworkUserEntityData$$ExternalSyntheticLambda0 = fontRequest;
            this.getAuthRequestContext = fontProviderHelper;
        }

        @Override // androidx.emoji.text.EmojiCompat.MetadataRepoLoader
        public void BuiltInFictitiousFunctionClassFactory(final EmojiCompat.MetadataRepoLoaderCallback metadataRepoLoaderCallback) {
            Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(metadataRepoLoaderCallback, "LoaderCallback cannot be null");
            synchronized (this.getErrorConfigVersion) {
                if (this.MyBillsEntityDataFactory == null) {
                    HandlerThread handlerThread = new HandlerThread("emojiCompat", 10);
                    this.scheduleImpl = handlerThread;
                    handlerThread.start();
                    this.MyBillsEntityDataFactory = new Handler(this.scheduleImpl.getLooper());
                }
                this.MyBillsEntityDataFactory.post(new Runnable() { // from class: androidx.emoji.text.FontRequestEmojiCompatConfig.FontRequestMetadataLoader.1
                    @Override // java.lang.Runnable
                    public void run() {
                        FontRequestMetadataLoader.this.PlaceComponentResult = metadataRepoLoaderCallback;
                        FontRequestMetadataLoader.this.PlaceComponentResult();
                    }
                });
            }
        }

        private FontsContractCompat.FontInfo MyBillsEntityDataFactory() {
            try {
                FontsContractCompat.FontFamilyResult PlaceComponentResult = this.getAuthRequestContext.PlaceComponentResult(this.BuiltInFictitiousFunctionClassFactory, this.NetworkUserEntityData$$ExternalSyntheticLambda0);
                if (PlaceComponentResult.BuiltInFictitiousFunctionClassFactory() != 0) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("fetchFonts failed (");
                    sb.append(PlaceComponentResult.BuiltInFictitiousFunctionClassFactory());
                    sb.append(")");
                    throw new RuntimeException(sb.toString());
                }
                FontsContractCompat.FontInfo[] authRequestContext = PlaceComponentResult.getAuthRequestContext();
                if (authRequestContext == null || authRequestContext.length == 0) {
                    throw new RuntimeException("fetchFonts failed (empty result)");
                }
                return authRequestContext[0];
            } catch (PackageManager.NameNotFoundException e) {
                throw new RuntimeException("provider not found", e);
            }
        }

        private void MyBillsEntityDataFactory(Uri uri, long j) {
            synchronized (this.getErrorConfigVersion) {
                if (this.moveToNextValue == null) {
                    ContentObserver contentObserver = new ContentObserver(this.MyBillsEntityDataFactory) { // from class: androidx.emoji.text.FontRequestEmojiCompatConfig.FontRequestMetadataLoader.2
                        @Override // android.database.ContentObserver
                        public void onChange(boolean z, Uri uri2) {
                            FontRequestMetadataLoader.this.PlaceComponentResult();
                        }
                    };
                    this.moveToNextValue = contentObserver;
                    this.getAuthRequestContext.MyBillsEntityDataFactory(this.BuiltInFictitiousFunctionClassFactory, uri, contentObserver);
                }
                if (this.KClassImpl$Data$declaredNonStaticMembers$2 == null) {
                    this.KClassImpl$Data$declaredNonStaticMembers$2 = new Runnable() { // from class: androidx.emoji.text.FontRequestEmojiCompatConfig.FontRequestMetadataLoader.3
                        @Override // java.lang.Runnable
                        public void run() {
                            FontRequestMetadataLoader.this.PlaceComponentResult();
                        }
                    };
                }
                this.MyBillsEntityDataFactory.postDelayed(this.KClassImpl$Data$declaredNonStaticMembers$2, j);
            }
        }

        private void BuiltInFictitiousFunctionClassFactory() {
            this.PlaceComponentResult = null;
            ContentObserver contentObserver = this.moveToNextValue;
            if (contentObserver != null) {
                this.getAuthRequestContext.getAuthRequestContext(this.BuiltInFictitiousFunctionClassFactory, contentObserver);
                this.moveToNextValue = null;
            }
            synchronized (this.getErrorConfigVersion) {
                this.MyBillsEntityDataFactory.removeCallbacks(this.KClassImpl$Data$declaredNonStaticMembers$2);
                HandlerThread handlerThread = this.scheduleImpl;
                if (handlerThread != null) {
                    handlerThread.quit();
                }
                this.MyBillsEntityDataFactory = null;
                this.scheduleImpl = null;
            }
        }

        void PlaceComponentResult() {
            if (this.PlaceComponentResult == null) {
                return;
            }
            try {
                FontsContractCompat.FontInfo MyBillsEntityDataFactory = MyBillsEntityDataFactory();
                int KClassImpl$Data$declaredNonStaticMembers$2 = MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2();
                if (KClassImpl$Data$declaredNonStaticMembers$2 == 2) {
                    synchronized (this.getErrorConfigVersion) {
                        RetryPolicy retryPolicy = this.lookAheadTest;
                        if (retryPolicy != null) {
                            long authRequestContext = retryPolicy.getAuthRequestContext();
                            if (authRequestContext >= 0) {
                                MyBillsEntityDataFactory(MyBillsEntityDataFactory.PlaceComponentResult(), authRequestContext);
                                return;
                            }
                        }
                    }
                }
                if (KClassImpl$Data$declaredNonStaticMembers$2 != 0) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("fetchFonts result is not OK. (");
                    sb.append(KClassImpl$Data$declaredNonStaticMembers$2);
                    sb.append(")");
                    throw new RuntimeException(sb.toString());
                }
                Typeface KClassImpl$Data$declaredNonStaticMembers$22 = this.getAuthRequestContext.KClassImpl$Data$declaredNonStaticMembers$2(this.BuiltInFictitiousFunctionClassFactory, MyBillsEntityDataFactory);
                ByteBuffer PlaceComponentResult = TypefaceCompatUtil.PlaceComponentResult(this.BuiltInFictitiousFunctionClassFactory, null, MyBillsEntityDataFactory.PlaceComponentResult());
                if (PlaceComponentResult == null) {
                    throw new RuntimeException("Unable to open file.");
                }
                this.PlaceComponentResult.PlaceComponentResult(MetadataRepo.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$22, PlaceComponentResult));
                BuiltInFictitiousFunctionClassFactory();
            } catch (Throwable th) {
                this.PlaceComponentResult.MyBillsEntityDataFactory(th);
                BuiltInFictitiousFunctionClassFactory();
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class FontProviderHelper {
        public FontsContractCompat.FontFamilyResult PlaceComponentResult(Context context, FontRequest fontRequest) throws PackageManager.NameNotFoundException {
            return FontsContractCompat.PlaceComponentResult(context, null, fontRequest);
        }

        public Typeface KClassImpl$Data$declaredNonStaticMembers$2(Context context, FontsContractCompat.FontInfo fontInfo) throws PackageManager.NameNotFoundException {
            return FontsContractCompat.MyBillsEntityDataFactory(context, null, new FontsContractCompat.FontInfo[]{fontInfo});
        }

        public void MyBillsEntityDataFactory(Context context, Uri uri, ContentObserver contentObserver) {
            context.getContentResolver().registerContentObserver(uri, false, contentObserver);
        }

        public void getAuthRequestContext(Context context, ContentObserver contentObserver) {
            context.getContentResolver().unregisterContentObserver(contentObserver);
        }
    }
}
