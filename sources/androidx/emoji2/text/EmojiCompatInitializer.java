package androidx.emoji2.text;

import android.content.Context;
import android.os.Build;
import androidx.core.os.TraceCompat;
import androidx.emoji2.text.EmojiCompat;
import androidx.emoji2.text.EmojiCompatInitializer;
import androidx.startup.AppInitializer;
import androidx.startup.Initializer;
import androidx.view.DefaultLifecycleObserver;
import androidx.view.Lifecycle;
import androidx.view.LifecycleOwner;
import androidx.view.ProcessLifecycleInitializer;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ThreadPoolExecutor;

/* loaded from: classes6.dex */
public class EmojiCompatInitializer implements Initializer<Boolean> {
    @Override // androidx.startup.Initializer
    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: merged with bridge method [inline-methods] */
    public Boolean getAuthRequestContext(Context context) {
        if (Build.VERSION.SDK_INT >= 19) {
            EmojiCompat.PlaceComponentResult(new BackgroundDefaultConfig(context));
            MyBillsEntityDataFactory(context);
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }

    void MyBillsEntityDataFactory(Context context) {
        final Lifecycle lifecycle = ((LifecycleOwner) AppInitializer.KClassImpl$Data$declaredNonStaticMembers$2(context).BuiltInFictitiousFunctionClassFactory(ProcessLifecycleInitializer.class)).getLifecycle();
        lifecycle.BuiltInFictitiousFunctionClassFactory(new DefaultLifecycleObserver() { // from class: androidx.emoji2.text.EmojiCompatInitializer.1
            @Override // androidx.view.FullLifecycleObserver
            public /* synthetic */ void onCreate(LifecycleOwner lifecycleOwner) {
                DefaultLifecycleObserver.CC.KClassImpl$Data$declaredNonStaticMembers$2();
            }

            @Override // androidx.view.FullLifecycleObserver
            public /* synthetic */ void onDestroy(LifecycleOwner lifecycleOwner) {
                DefaultLifecycleObserver.CC.getAuthRequestContext();
            }

            @Override // androidx.view.FullLifecycleObserver
            public /* synthetic */ void onPause(LifecycleOwner lifecycleOwner) {
                DefaultLifecycleObserver.CC.MyBillsEntityDataFactory();
            }

            @Override // androidx.view.FullLifecycleObserver
            public /* synthetic */ void onStart(LifecycleOwner lifecycleOwner) {
                DefaultLifecycleObserver.CC.PlaceComponentResult();
            }

            @Override // androidx.view.FullLifecycleObserver
            public /* synthetic */ void onStop(LifecycleOwner lifecycleOwner) {
                DefaultLifecycleObserver.CC.scheduleImpl();
            }

            @Override // androidx.view.FullLifecycleObserver
            public void onResume(LifecycleOwner lifecycleOwner) {
                EmojiCompatInitializer.this.getAuthRequestContext();
                lifecycle.KClassImpl$Data$declaredNonStaticMembers$2(this);
            }
        });
    }

    void getAuthRequestContext() {
        ConcurrencyHelpers.BuiltInFictitiousFunctionClassFactory().postDelayed(new LoadEmojiCompatRunnable(), 500L);
    }

    @Override // androidx.startup.Initializer
    public List<Class<? extends Initializer<?>>> PlaceComponentResult() {
        return Collections.singletonList(ProcessLifecycleInitializer.class);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public static class LoadEmojiCompatRunnable implements Runnable {
        LoadEmojiCompatRunnable() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                TraceCompat.BuiltInFictitiousFunctionClassFactory("EmojiCompat.EmojiCompatInitializer.run");
                if (EmojiCompat.getAuthRequestContext()) {
                    EmojiCompat.KClassImpl$Data$declaredNonStaticMembers$2().moveToNextValue();
                }
            } finally {
                TraceCompat.BuiltInFictitiousFunctionClassFactory();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public static class BackgroundDefaultConfig extends EmojiCompat.Config {
        protected BackgroundDefaultConfig(Context context) {
            super(new BackgroundDefaultLoader(context));
            KClassImpl$Data$declaredNonStaticMembers$2(1);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public static class BackgroundDefaultLoader implements EmojiCompat.MetadataRepoLoader {
        private final Context BuiltInFictitiousFunctionClassFactory;

        BackgroundDefaultLoader(Context context) {
            this.BuiltInFictitiousFunctionClassFactory = context.getApplicationContext();
        }

        @Override // androidx.emoji2.text.EmojiCompat.MetadataRepoLoader
        public void PlaceComponentResult(final EmojiCompat.MetadataRepoLoaderCallback metadataRepoLoaderCallback) {
            final ThreadPoolExecutor authRequestContext = ConcurrencyHelpers.getAuthRequestContext("EmojiCompatInitializer");
            authRequestContext.execute(new Runnable() { // from class: androidx.emoji2.text.EmojiCompatInitializer$BackgroundDefaultLoader$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    EmojiCompatInitializer.BackgroundDefaultLoader.this.KClassImpl$Data$declaredNonStaticMembers$2(metadataRepoLoaderCallback, authRequestContext);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: MyBillsEntityDataFactory  reason: merged with bridge method [inline-methods] */
        public void KClassImpl$Data$declaredNonStaticMembers$2(final EmojiCompat.MetadataRepoLoaderCallback metadataRepoLoaderCallback, final ThreadPoolExecutor threadPoolExecutor) {
            try {
                FontRequestEmojiCompatConfig BuiltInFictitiousFunctionClassFactory = DefaultEmojiCompatConfig.BuiltInFictitiousFunctionClassFactory(this.BuiltInFictitiousFunctionClassFactory);
                if (BuiltInFictitiousFunctionClassFactory == null) {
                    throw new RuntimeException("EmojiCompat font provider not available on this device.");
                }
                BuiltInFictitiousFunctionClassFactory.getAuthRequestContext(threadPoolExecutor);
                BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2().PlaceComponentResult(new EmojiCompat.MetadataRepoLoaderCallback() { // from class: androidx.emoji2.text.EmojiCompatInitializer.BackgroundDefaultLoader.1
                    @Override // androidx.emoji2.text.EmojiCompat.MetadataRepoLoaderCallback
                    public void PlaceComponentResult(MetadataRepo metadataRepo) {
                        try {
                            metadataRepoLoaderCallback.PlaceComponentResult(metadataRepo);
                        } finally {
                            threadPoolExecutor.shutdown();
                        }
                    }

                    @Override // androidx.emoji2.text.EmojiCompat.MetadataRepoLoaderCallback
                    public void KClassImpl$Data$declaredNonStaticMembers$2(Throwable th) {
                        try {
                            metadataRepoLoaderCallback.KClassImpl$Data$declaredNonStaticMembers$2(th);
                        } finally {
                            threadPoolExecutor.shutdown();
                        }
                    }
                });
            } catch (Throwable th) {
                metadataRepoLoaderCallback.KClassImpl$Data$declaredNonStaticMembers$2(th);
                threadPoolExecutor.shutdown();
            }
        }
    }
}
