package androidx.emoji2.text;

import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.Editable;
import android.view.KeyEvent;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import androidx.collection.ArraySet;
import androidx.core.util.Preconditions;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* loaded from: classes.dex */
public class EmojiCompat {
    private static volatile EmojiCompat lookAheadTest;
    final boolean BuiltInFictitiousFunctionClassFactory;
    private final CompatInternal DatabaseTableConfigUtil;
    final int[] KClassImpl$Data$declaredNonStaticMembers$2;
    final boolean MyBillsEntityDataFactory;
    private final int NetworkUserEntityData$$ExternalSyntheticLambda0;
    private final Set<InitCallback> NetworkUserEntityData$$ExternalSyntheticLambda1;
    private final int NetworkUserEntityData$$ExternalSyntheticLambda8;
    final MetadataRepoLoader getAuthRequestContext;
    private final boolean moveToNextValue;
    private final GlyphChecker scheduleImpl;
    private static final Object getErrorConfigVersion = new Object();
    private static final Object PlaceComponentResult = new Object();
    private final ReadWriteLock initRecordTimeStamp = new ReentrantReadWriteLock();
    private volatile int NetworkUserEntityData$$ExternalSyntheticLambda2 = 3;
    private final Handler GetContactSyncConfig = new Handler(Looper.getMainLooper());

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes.dex */
    public @interface CodepointSequenceMatchResult {
    }

    /* loaded from: classes.dex */
    public interface GlyphChecker {
        boolean KClassImpl$Data$declaredNonStaticMembers$2(CharSequence charSequence, int i, int i2, int i3);
    }

    /* loaded from: classes.dex */
    public static abstract class InitCallback {
        public void BuiltInFictitiousFunctionClassFactory() {
        }

        public void getAuthRequestContext(Throwable th) {
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes.dex */
    public @interface LoadStrategy {
    }

    /* loaded from: classes.dex */
    public interface MetadataRepoLoader {
        void PlaceComponentResult(MetadataRepoLoaderCallback metadataRepoLoaderCallback);
    }

    /* loaded from: classes.dex */
    public static abstract class MetadataRepoLoaderCallback {
        public abstract void KClassImpl$Data$declaredNonStaticMembers$2(Throwable th);

        public abstract void PlaceComponentResult(MetadataRepo metadataRepo);
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes.dex */
    public @interface ReplaceStrategy {
    }

    private EmojiCompat(Config config) {
        this.BuiltInFictitiousFunctionClassFactory = config.scheduleImpl;
        this.MyBillsEntityDataFactory = config.NetworkUserEntityData$$ExternalSyntheticLambda0;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = config.getAuthRequestContext;
        this.moveToNextValue = config.BuiltInFictitiousFunctionClassFactory;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = config.KClassImpl$Data$declaredNonStaticMembers$2;
        this.getAuthRequestContext = config.lookAheadTest;
        this.NetworkUserEntityData$$ExternalSyntheticLambda8 = config.moveToNextValue;
        this.scheduleImpl = config.MyBillsEntityDataFactory;
        ArraySet arraySet = new ArraySet();
        this.NetworkUserEntityData$$ExternalSyntheticLambda1 = arraySet;
        if (config.PlaceComponentResult != null && !config.PlaceComponentResult.isEmpty()) {
            arraySet.addAll(config.PlaceComponentResult);
        }
        this.DatabaseTableConfigUtil = Build.VERSION.SDK_INT < 19 ? new CompatInternal(this) : new CompatInternal19(this);
        NetworkUserEntityData$$ExternalSyntheticLambda0();
    }

    public static EmojiCompat PlaceComponentResult(Config config) {
        EmojiCompat emojiCompat;
        EmojiCompat emojiCompat2 = lookAheadTest;
        if (emojiCompat2 == null) {
            synchronized (getErrorConfigVersion) {
                emojiCompat = lookAheadTest;
                if (emojiCompat == null) {
                    emojiCompat = new EmojiCompat(config);
                    lookAheadTest = emojiCompat;
                }
            }
            return emojiCompat;
        }
        return emojiCompat2;
    }

    public static boolean getAuthRequestContext() {
        return lookAheadTest != null;
    }

    public static EmojiCompat KClassImpl$Data$declaredNonStaticMembers$2() {
        EmojiCompat emojiCompat;
        synchronized (getErrorConfigVersion) {
            emojiCompat = lookAheadTest;
            Preconditions.getAuthRequestContext(emojiCompat != null, "EmojiCompat is not initialized.\n\nYou must initialize EmojiCompat prior to referencing the EmojiCompat instance.\n\nThe most likely cause of this error is disabling the EmojiCompatInitializer\neither explicitly in AndroidManifest.xml, or by including\nandroidx.emoji2:emoji2-bundled.\n\nAutomatic initialization is typically performed by EmojiCompatInitializer. If\nyou are not expecting to initialize EmojiCompat manually in your application,\nplease check to ensure it has not been removed from your APK's manifest. You can\ndo this in Android Studio using Build > Analyze APK.\n\nIn the APK Analyzer, ensure that the startup entry for\nEmojiCompatInitializer and InitializationProvider is present in\n AndroidManifest.xml. If it is missing or contains tools:node=\"remove\", and you\nintend to use automatic configuration, verify:\n\n  1. Your application does not include emoji2-bundled\n  2. All modules do not contain an exclusion manifest rule for\n     EmojiCompatInitializer or InitializationProvider. For more information\n     about manifest exclusions see the documentation for the androidx startup\n     library.\n\nIf you intend to use emoji2-bundled, please call EmojiCompat.init. You can\nlearn more in the documentation for BundledEmojiCompatConfig.\n\nIf you intended to perform manual configuration, it is recommended that you call\nEmojiCompat.init immediately on application startup.\n\nIf you still cannot resolve this issue, please open a bug with your specific\nconfiguration to help improve error message.");
        }
        return emojiCompat;
    }

    public void moveToNextValue() {
        Preconditions.getAuthRequestContext(this.NetworkUserEntityData$$ExternalSyntheticLambda8 == 1, "Set metadataLoadStrategy to LOAD_STRATEGY_MANUAL to execute manual loading");
        if (scheduleImpl()) {
            return;
        }
        this.initRecordTimeStamp.writeLock().lock();
        try {
            if (this.NetworkUserEntityData$$ExternalSyntheticLambda2 == 0) {
                return;
            }
            this.NetworkUserEntityData$$ExternalSyntheticLambda2 = 0;
            this.initRecordTimeStamp.writeLock().unlock();
            this.DatabaseTableConfigUtil.KClassImpl$Data$declaredNonStaticMembers$2();
        } finally {
            this.initRecordTimeStamp.writeLock().unlock();
        }
    }

    private void NetworkUserEntityData$$ExternalSyntheticLambda0() {
        this.initRecordTimeStamp.writeLock().lock();
        try {
            if (this.NetworkUserEntityData$$ExternalSyntheticLambda8 == 0) {
                this.NetworkUserEntityData$$ExternalSyntheticLambda2 = 0;
            }
            this.initRecordTimeStamp.writeLock().unlock();
            if (MyBillsEntityDataFactory() == 0) {
                this.DatabaseTableConfigUtil.KClassImpl$Data$declaredNonStaticMembers$2();
            }
        } catch (Throwable th) {
            this.initRecordTimeStamp.writeLock().unlock();
            throw th;
        }
    }

    void lookAheadTest() {
        ArrayList arrayList = new ArrayList();
        this.initRecordTimeStamp.writeLock().lock();
        try {
            this.NetworkUserEntityData$$ExternalSyntheticLambda2 = 1;
            arrayList.addAll(this.NetworkUserEntityData$$ExternalSyntheticLambda1);
            this.NetworkUserEntityData$$ExternalSyntheticLambda1.clear();
            this.initRecordTimeStamp.writeLock().unlock();
            this.GetContactSyncConfig.post(new ListenerDispatcher(arrayList, this.NetworkUserEntityData$$ExternalSyntheticLambda2));
        } catch (Throwable th) {
            this.initRecordTimeStamp.writeLock().unlock();
            throw th;
        }
    }

    void PlaceComponentResult(Throwable th) {
        ArrayList arrayList = new ArrayList();
        this.initRecordTimeStamp.writeLock().lock();
        try {
            this.NetworkUserEntityData$$ExternalSyntheticLambda2 = 2;
            arrayList.addAll(this.NetworkUserEntityData$$ExternalSyntheticLambda1);
            this.NetworkUserEntityData$$ExternalSyntheticLambda1.clear();
            this.initRecordTimeStamp.writeLock().unlock();
            this.GetContactSyncConfig.post(new ListenerDispatcher(arrayList, this.NetworkUserEntityData$$ExternalSyntheticLambda2, th));
        } catch (Throwable th2) {
            this.initRecordTimeStamp.writeLock().unlock();
            throw th2;
        }
    }

    public void KClassImpl$Data$declaredNonStaticMembers$2(InitCallback initCallback) {
        Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(initCallback, "initCallback cannot be null");
        this.initRecordTimeStamp.writeLock().lock();
        try {
            if (this.NetworkUserEntityData$$ExternalSyntheticLambda2 != 1 && this.NetworkUserEntityData$$ExternalSyntheticLambda2 != 2) {
                this.NetworkUserEntityData$$ExternalSyntheticLambda1.add(initCallback);
            }
            this.GetContactSyncConfig.post(new ListenerDispatcher(initCallback, this.NetworkUserEntityData$$ExternalSyntheticLambda2));
        } finally {
            this.initRecordTimeStamp.writeLock().unlock();
        }
    }

    public void getAuthRequestContext(InitCallback initCallback) {
        Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(initCallback, "initCallback cannot be null");
        this.initRecordTimeStamp.writeLock().lock();
        try {
            this.NetworkUserEntityData$$ExternalSyntheticLambda1.remove(initCallback);
        } finally {
            this.initRecordTimeStamp.writeLock().unlock();
        }
    }

    public int MyBillsEntityDataFactory() {
        this.initRecordTimeStamp.readLock().lock();
        try {
            return this.NetworkUserEntityData$$ExternalSyntheticLambda2;
        } finally {
            this.initRecordTimeStamp.readLock().unlock();
        }
    }

    private boolean scheduleImpl() {
        return MyBillsEntityDataFactory() == 1;
    }

    public boolean BuiltInFictitiousFunctionClassFactory() {
        return this.moveToNextValue;
    }

    public int PlaceComponentResult() {
        return this.NetworkUserEntityData$$ExternalSyntheticLambda0;
    }

    public static boolean BuiltInFictitiousFunctionClassFactory(Editable editable, int i, KeyEvent keyEvent) {
        if (Build.VERSION.SDK_INT >= 19) {
            return EmojiProcessor.getAuthRequestContext(editable, i, keyEvent);
        }
        return false;
    }

    public static boolean MyBillsEntityDataFactory(InputConnection inputConnection, Editable editable, int i, int i2, boolean z) {
        if (Build.VERSION.SDK_INT >= 19) {
            return EmojiProcessor.KClassImpl$Data$declaredNonStaticMembers$2(inputConnection, editable, i, i2, z);
        }
        return false;
    }

    public CharSequence getAuthRequestContext(CharSequence charSequence) {
        return BuiltInFictitiousFunctionClassFactory(charSequence, 0, charSequence == null ? 0 : charSequence.length());
    }

    public CharSequence BuiltInFictitiousFunctionClassFactory(CharSequence charSequence, int i, int i2) {
        return getAuthRequestContext(charSequence, i, i2, Integer.MAX_VALUE);
    }

    public CharSequence getAuthRequestContext(CharSequence charSequence, int i, int i2, int i3) {
        return BuiltInFictitiousFunctionClassFactory(charSequence, i, i2, i3, 0);
    }

    public CharSequence BuiltInFictitiousFunctionClassFactory(CharSequence charSequence, int i, int i2, int i3, int i4) {
        boolean z;
        Preconditions.getAuthRequestContext(scheduleImpl(), "Not initialized yet");
        Preconditions.MyBillsEntityDataFactory(i, "start cannot be negative");
        Preconditions.MyBillsEntityDataFactory(i2, "end cannot be negative");
        Preconditions.MyBillsEntityDataFactory(i3, "maxEmojiCount cannot be negative");
        Preconditions.MyBillsEntityDataFactory(i <= i2, "start should be <= than end");
        if (charSequence == null) {
            return null;
        }
        Preconditions.MyBillsEntityDataFactory(i <= charSequence.length(), "start should be < than charSequence length");
        Preconditions.MyBillsEntityDataFactory(i2 <= charSequence.length(), "end should be < than charSequence length");
        if (charSequence.length() == 0 || i == i2) {
            return charSequence;
        }
        if (i4 != 1) {
            z = i4 != 2 ? this.BuiltInFictitiousFunctionClassFactory : false;
        } else {
            z = true;
        }
        return this.DatabaseTableConfigUtil.PlaceComponentResult(charSequence, i, i2, i3, z);
    }

    public void PlaceComponentResult(EditorInfo editorInfo) {
        if (!scheduleImpl() || editorInfo == null) {
            return;
        }
        if (editorInfo.extras == null) {
            editorInfo.extras = new Bundle();
        }
        this.DatabaseTableConfigUtil.KClassImpl$Data$declaredNonStaticMembers$2(editorInfo);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class SpanFactory {
        SpanFactory() {
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public EmojiSpan BuiltInFictitiousFunctionClassFactory(EmojiMetadata emojiMetadata) {
            return new TypefaceEmojiSpan(emojiMetadata);
        }
    }

    /* loaded from: classes.dex */
    public static abstract class Config {
        boolean BuiltInFictitiousFunctionClassFactory;
        boolean NetworkUserEntityData$$ExternalSyntheticLambda0;
        Set<InitCallback> PlaceComponentResult;
        int[] getAuthRequestContext;
        final MetadataRepoLoader lookAheadTest;
        boolean scheduleImpl;
        int KClassImpl$Data$declaredNonStaticMembers$2 = -16711936;
        int moveToNextValue = 0;
        GlyphChecker MyBillsEntityDataFactory = new DefaultGlyphChecker();

        /* JADX INFO: Access modifiers changed from: protected */
        public Config(MetadataRepoLoader metadataRepoLoader) {
            Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(metadataRepoLoader, "metadataLoader cannot be null.");
            this.lookAheadTest = metadataRepoLoader;
        }

        public Config KClassImpl$Data$declaredNonStaticMembers$2(int i) {
            this.moveToNextValue = i;
            return this;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        public final MetadataRepoLoader KClassImpl$Data$declaredNonStaticMembers$2() {
            return this.lookAheadTest;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class ListenerDispatcher implements Runnable {
        private final int BuiltInFictitiousFunctionClassFactory;
        private final Throwable MyBillsEntityDataFactory;
        private final List<InitCallback> PlaceComponentResult;

        ListenerDispatcher(InitCallback initCallback, int i) {
            this(Arrays.asList((InitCallback) Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(initCallback, "initCallback cannot be null")), i, null);
        }

        ListenerDispatcher(Collection<InitCallback> collection, int i) {
            this(collection, i, null);
        }

        ListenerDispatcher(Collection<InitCallback> collection, int i, Throwable th) {
            Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(collection, "initCallbacks cannot be null");
            this.PlaceComponentResult = new ArrayList(collection);
            this.BuiltInFictitiousFunctionClassFactory = i;
            this.MyBillsEntityDataFactory = th;
        }

        @Override // java.lang.Runnable
        public void run() {
            int size = this.PlaceComponentResult.size();
            int i = 0;
            if (this.BuiltInFictitiousFunctionClassFactory != 1) {
                while (i < size) {
                    this.PlaceComponentResult.get(i).getAuthRequestContext(this.MyBillsEntityDataFactory);
                    i++;
                }
                return;
            }
            while (i < size) {
                this.PlaceComponentResult.get(i).BuiltInFictitiousFunctionClassFactory();
                i++;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class CompatInternal {
        final EmojiCompat KClassImpl$Data$declaredNonStaticMembers$2;

        void KClassImpl$Data$declaredNonStaticMembers$2(EditorInfo editorInfo) {
        }

        CharSequence PlaceComponentResult(CharSequence charSequence, int i, int i2, int i3, boolean z) {
            return charSequence;
        }

        CompatInternal(EmojiCompat emojiCompat) {
            this.KClassImpl$Data$declaredNonStaticMembers$2 = emojiCompat;
        }

        void KClassImpl$Data$declaredNonStaticMembers$2() {
            this.KClassImpl$Data$declaredNonStaticMembers$2.lookAheadTest();
        }
    }

    /* loaded from: classes.dex */
    static final class CompatInternal19 extends CompatInternal {
        private volatile EmojiProcessor MyBillsEntityDataFactory;
        private volatile MetadataRepo getAuthRequestContext;

        CompatInternal19(EmojiCompat emojiCompat) {
            super(emojiCompat);
        }

        @Override // androidx.emoji2.text.EmojiCompat.CompatInternal
        final void KClassImpl$Data$declaredNonStaticMembers$2() {
            try {
                this.KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext.PlaceComponentResult(new MetadataRepoLoaderCallback() { // from class: androidx.emoji2.text.EmojiCompat.CompatInternal19.1
                    @Override // androidx.emoji2.text.EmojiCompat.MetadataRepoLoaderCallback
                    public void PlaceComponentResult(MetadataRepo metadataRepo) {
                        CompatInternal19.this.PlaceComponentResult(metadataRepo);
                    }

                    @Override // androidx.emoji2.text.EmojiCompat.MetadataRepoLoaderCallback
                    public void KClassImpl$Data$declaredNonStaticMembers$2(Throwable th) {
                        CompatInternal19.this.KClassImpl$Data$declaredNonStaticMembers$2.PlaceComponentResult(th);
                    }
                });
            } catch (Throwable th) {
                this.KClassImpl$Data$declaredNonStaticMembers$2.PlaceComponentResult(th);
            }
        }

        final void PlaceComponentResult(MetadataRepo metadataRepo) {
            if (metadataRepo == null) {
                this.KClassImpl$Data$declaredNonStaticMembers$2.PlaceComponentResult(new IllegalArgumentException("metadataRepo cannot be null"));
                return;
            }
            this.getAuthRequestContext = metadataRepo;
            this.MyBillsEntityDataFactory = new EmojiProcessor(this.getAuthRequestContext, new SpanFactory(), this.KClassImpl$Data$declaredNonStaticMembers$2.scheduleImpl, this.KClassImpl$Data$declaredNonStaticMembers$2.MyBillsEntityDataFactory, this.KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2);
            this.KClassImpl$Data$declaredNonStaticMembers$2.lookAheadTest();
        }

        @Override // androidx.emoji2.text.EmojiCompat.CompatInternal
        final CharSequence PlaceComponentResult(CharSequence charSequence, int i, int i2, int i3, boolean z) {
            return this.MyBillsEntityDataFactory.MyBillsEntityDataFactory(charSequence, i, i2, i3, z);
        }

        @Override // androidx.emoji2.text.EmojiCompat.CompatInternal
        final void KClassImpl$Data$declaredNonStaticMembers$2(EditorInfo editorInfo) {
            editorInfo.extras.putInt("android.support.text.emoji.emojiCompat_metadataVersion", this.getAuthRequestContext.getAuthRequestContext.KClassImpl$Data$declaredNonStaticMembers$2());
            editorInfo.extras.putBoolean("android.support.text.emoji.emojiCompat_replaceAll", this.KClassImpl$Data$declaredNonStaticMembers$2.BuiltInFictitiousFunctionClassFactory);
        }
    }
}
