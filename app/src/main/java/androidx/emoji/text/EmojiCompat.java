package androidx.emoji.text;

import android.os.Build;
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

/* loaded from: classes3.dex */
public class EmojiCompat {
    private static volatile EmojiCompat BuiltInFictitiousFunctionClassFactory;
    private static final Object lookAheadTest = new Object();
    final boolean KClassImpl$Data$declaredNonStaticMembers$2;
    final boolean MyBillsEntityDataFactory;
    private final Set<InitCallback> NetworkUserEntityData$$ExternalSyntheticLambda0;
    final int[] PlaceComponentResult;
    final MetadataRepoLoader getAuthRequestContext;
    private final int getErrorConfigVersion;
    private final int initRecordTimeStamp;
    private final CompatInternal moveToNextValue;
    private final boolean scheduleImpl;
    private final ReadWriteLock DatabaseTableConfigUtil = new ReentrantReadWriteLock();
    private int NetworkUserEntityData$$ExternalSyntheticLambda2 = 3;
    private final Handler GetContactSyncConfig = new Handler(Looper.getMainLooper());

    /* loaded from: classes3.dex */
    public static abstract class InitCallback {
        public void BuiltInFictitiousFunctionClassFactory(Throwable th) {
        }

        public void MyBillsEntityDataFactory() {
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes3.dex */
    public @interface LoadState {
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes3.dex */
    public @interface LoadStrategy {
    }

    /* loaded from: classes6.dex */
    public interface MetadataRepoLoader {
        void BuiltInFictitiousFunctionClassFactory(MetadataRepoLoaderCallback metadataRepoLoaderCallback);
    }

    /* loaded from: classes6.dex */
    public static abstract class MetadataRepoLoaderCallback {
        public abstract void MyBillsEntityDataFactory(Throwable th);

        public abstract void PlaceComponentResult(MetadataRepo metadataRepo);
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes3.dex */
    public @interface ReplaceStrategy {
    }

    private EmojiCompat(Config config) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = config.scheduleImpl;
        this.MyBillsEntityDataFactory = config.moveToNextValue;
        this.PlaceComponentResult = config.MyBillsEntityDataFactory;
        this.scheduleImpl = config.KClassImpl$Data$declaredNonStaticMembers$2;
        this.getErrorConfigVersion = config.getAuthRequestContext;
        this.getAuthRequestContext = config.NetworkUserEntityData$$ExternalSyntheticLambda0;
        this.initRecordTimeStamp = config.BuiltInFictitiousFunctionClassFactory;
        ArraySet arraySet = new ArraySet();
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = arraySet;
        if (config.PlaceComponentResult != null && !config.PlaceComponentResult.isEmpty()) {
            arraySet.addAll(config.PlaceComponentResult);
        }
        this.moveToNextValue = Build.VERSION.SDK_INT < 19 ? new CompatInternal(this) : new CompatInternal19(this);
        moveToNextValue();
    }

    public static EmojiCompat MyBillsEntityDataFactory(Config config) {
        if (BuiltInFictitiousFunctionClassFactory == null) {
            synchronized (lookAheadTest) {
                if (BuiltInFictitiousFunctionClassFactory == null) {
                    BuiltInFictitiousFunctionClassFactory = new EmojiCompat(config);
                }
            }
        }
        return BuiltInFictitiousFunctionClassFactory;
    }

    public static EmojiCompat MyBillsEntityDataFactory() {
        EmojiCompat emojiCompat;
        synchronized (lookAheadTest) {
            Preconditions.getAuthRequestContext(BuiltInFictitiousFunctionClassFactory != null, "EmojiCompat is not initialized. Please call EmojiCompat.init() first");
            emojiCompat = BuiltInFictitiousFunctionClassFactory;
        }
        return emojiCompat;
    }

    private void moveToNextValue() {
        this.DatabaseTableConfigUtil.writeLock().lock();
        try {
            if (this.initRecordTimeStamp == 0) {
                this.NetworkUserEntityData$$ExternalSyntheticLambda2 = 0;
            }
            this.DatabaseTableConfigUtil.writeLock().unlock();
            if (KClassImpl$Data$declaredNonStaticMembers$2() == 0) {
                this.moveToNextValue.KClassImpl$Data$declaredNonStaticMembers$2();
            }
        } catch (Throwable th) {
            this.DatabaseTableConfigUtil.writeLock().unlock();
            throw th;
        }
    }

    void getAuthRequestContext() {
        ArrayList arrayList = new ArrayList();
        this.DatabaseTableConfigUtil.writeLock().lock();
        try {
            this.NetworkUserEntityData$$ExternalSyntheticLambda2 = 1;
            arrayList.addAll(this.NetworkUserEntityData$$ExternalSyntheticLambda0);
            this.NetworkUserEntityData$$ExternalSyntheticLambda0.clear();
            this.DatabaseTableConfigUtil.writeLock().unlock();
            this.GetContactSyncConfig.post(new ListenerDispatcher(arrayList, this.NetworkUserEntityData$$ExternalSyntheticLambda2));
        } catch (Throwable th) {
            this.DatabaseTableConfigUtil.writeLock().unlock();
            throw th;
        }
    }

    void BuiltInFictitiousFunctionClassFactory(Throwable th) {
        ArrayList arrayList = new ArrayList();
        this.DatabaseTableConfigUtil.writeLock().lock();
        try {
            this.NetworkUserEntityData$$ExternalSyntheticLambda2 = 2;
            arrayList.addAll(this.NetworkUserEntityData$$ExternalSyntheticLambda0);
            this.NetworkUserEntityData$$ExternalSyntheticLambda0.clear();
            this.DatabaseTableConfigUtil.writeLock().unlock();
            this.GetContactSyncConfig.post(new ListenerDispatcher(arrayList, this.NetworkUserEntityData$$ExternalSyntheticLambda2, th));
        } catch (Throwable th2) {
            this.DatabaseTableConfigUtil.writeLock().unlock();
            throw th2;
        }
    }

    public void PlaceComponentResult(InitCallback initCallback) {
        Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(initCallback, "initCallback cannot be null");
        this.DatabaseTableConfigUtil.writeLock().lock();
        try {
            int i = this.NetworkUserEntityData$$ExternalSyntheticLambda2;
            if (i == 1 || i == 2) {
                this.GetContactSyncConfig.post(new ListenerDispatcher(initCallback, i));
            } else {
                this.NetworkUserEntityData$$ExternalSyntheticLambda0.add(initCallback);
            }
        } finally {
            this.DatabaseTableConfigUtil.writeLock().unlock();
        }
    }

    public int KClassImpl$Data$declaredNonStaticMembers$2() {
        this.DatabaseTableConfigUtil.readLock().lock();
        try {
            return this.NetworkUserEntityData$$ExternalSyntheticLambda2;
        } finally {
            this.DatabaseTableConfigUtil.readLock().unlock();
        }
    }

    private boolean scheduleImpl() {
        return KClassImpl$Data$declaredNonStaticMembers$2() == 1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean PlaceComponentResult() {
        return this.scheduleImpl;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int BuiltInFictitiousFunctionClassFactory() {
        return this.getErrorConfigVersion;
    }

    public static boolean getAuthRequestContext(Editable editable, int i, KeyEvent keyEvent) {
        if (Build.VERSION.SDK_INT >= 19) {
            return EmojiProcessor.BuiltInFictitiousFunctionClassFactory(editable, i, keyEvent);
        }
        return false;
    }

    public static boolean BuiltInFictitiousFunctionClassFactory(InputConnection inputConnection, Editable editable, int i, int i2, boolean z) {
        if (Build.VERSION.SDK_INT >= 19) {
            return EmojiProcessor.KClassImpl$Data$declaredNonStaticMembers$2(inputConnection, editable, i, i2, z);
        }
        return false;
    }

    public CharSequence KClassImpl$Data$declaredNonStaticMembers$2(CharSequence charSequence) {
        return BuiltInFictitiousFunctionClassFactory(charSequence, 0, charSequence == null ? 0 : charSequence.length());
    }

    public CharSequence BuiltInFictitiousFunctionClassFactory(CharSequence charSequence, int i, int i2) {
        return MyBillsEntityDataFactory(charSequence, i, i2, Integer.MAX_VALUE);
    }

    public CharSequence MyBillsEntityDataFactory(CharSequence charSequence, int i, int i2, int i3) {
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
            return charSequence;
        }
        Preconditions.MyBillsEntityDataFactory(i <= charSequence.length(), "start should be < than charSequence length");
        Preconditions.MyBillsEntityDataFactory(i2 <= charSequence.length(), "end should be < than charSequence length");
        if (charSequence.length() == 0 || i == i2) {
            return charSequence;
        }
        if (i4 != 1) {
            z = i4 != 2 ? this.KClassImpl$Data$declaredNonStaticMembers$2 : false;
        } else {
            z = true;
        }
        return this.moveToNextValue.BuiltInFictitiousFunctionClassFactory(charSequence, i, i2, i3, z);
    }

    public void getAuthRequestContext(EditorInfo editorInfo) {
        if (!scheduleImpl() || editorInfo == null || editorInfo.extras == null) {
            return;
        }
        this.moveToNextValue.getAuthRequestContext(editorInfo);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public static class SpanFactory {
        SpanFactory() {
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public EmojiSpan MyBillsEntityDataFactory(EmojiMetadata emojiMetadata) {
            return new TypefaceEmojiSpan(emojiMetadata);
        }
    }

    /* loaded from: classes6.dex */
    public static abstract class Config {
        boolean KClassImpl$Data$declaredNonStaticMembers$2;
        int[] MyBillsEntityDataFactory;
        final MetadataRepoLoader NetworkUserEntityData$$ExternalSyntheticLambda0;
        Set<InitCallback> PlaceComponentResult;
        boolean moveToNextValue;
        boolean scheduleImpl;
        int getAuthRequestContext = -16711936;
        int BuiltInFictitiousFunctionClassFactory = 0;

        /* JADX INFO: Access modifiers changed from: protected */
        public Config(MetadataRepoLoader metadataRepoLoader) {
            Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(metadataRepoLoader, "metadataLoader cannot be null.");
            this.NetworkUserEntityData$$ExternalSyntheticLambda0 = metadataRepoLoader;
        }

        public Config KClassImpl$Data$declaredNonStaticMembers$2(InitCallback initCallback) {
            Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(initCallback, "initCallback cannot be null");
            if (this.PlaceComponentResult == null) {
                this.PlaceComponentResult = new ArraySet();
            }
            this.PlaceComponentResult.add(initCallback);
            return this;
        }

        public Config BuiltInFictitiousFunctionClassFactory(boolean z) {
            this.scheduleImpl = z;
            return this;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static class ListenerDispatcher implements Runnable {
        private final List<InitCallback> MyBillsEntityDataFactory;
        private final int PlaceComponentResult;
        private final Throwable getAuthRequestContext;

        ListenerDispatcher(InitCallback initCallback, int i) {
            this(Arrays.asList((InitCallback) Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(initCallback, "initCallback cannot be null")), i, null);
        }

        ListenerDispatcher(Collection<InitCallback> collection, int i) {
            this(collection, i, null);
        }

        ListenerDispatcher(Collection<InitCallback> collection, int i, Throwable th) {
            Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(collection, "initCallbacks cannot be null");
            this.MyBillsEntityDataFactory = new ArrayList(collection);
            this.PlaceComponentResult = i;
            this.getAuthRequestContext = th;
        }

        @Override // java.lang.Runnable
        public void run() {
            int size = this.MyBillsEntityDataFactory.size();
            int i = 0;
            if (this.PlaceComponentResult != 1) {
                while (i < size) {
                    this.MyBillsEntityDataFactory.get(i).BuiltInFictitiousFunctionClassFactory(this.getAuthRequestContext);
                    i++;
                }
                return;
            }
            while (i < size) {
                this.MyBillsEntityDataFactory.get(i).MyBillsEntityDataFactory();
                i++;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static class CompatInternal {
        final EmojiCompat MyBillsEntityDataFactory;

        CharSequence BuiltInFictitiousFunctionClassFactory(CharSequence charSequence, int i, int i2, int i3, boolean z) {
            return charSequence;
        }

        void getAuthRequestContext(EditorInfo editorInfo) {
        }

        CompatInternal(EmojiCompat emojiCompat) {
            this.MyBillsEntityDataFactory = emojiCompat;
        }

        void KClassImpl$Data$declaredNonStaticMembers$2() {
            this.MyBillsEntityDataFactory.getAuthRequestContext();
        }
    }

    /* loaded from: classes6.dex */
    static final class CompatInternal19 extends CompatInternal {
        private volatile MetadataRepo KClassImpl$Data$declaredNonStaticMembers$2;
        private volatile EmojiProcessor getAuthRequestContext;

        CompatInternal19(EmojiCompat emojiCompat) {
            super(emojiCompat);
        }

        @Override // androidx.emoji.text.EmojiCompat.CompatInternal
        final void KClassImpl$Data$declaredNonStaticMembers$2() {
            try {
                this.MyBillsEntityDataFactory.getAuthRequestContext.BuiltInFictitiousFunctionClassFactory(new MetadataRepoLoaderCallback() { // from class: androidx.emoji.text.EmojiCompat.CompatInternal19.1
                    @Override // androidx.emoji.text.EmojiCompat.MetadataRepoLoaderCallback
                    public void PlaceComponentResult(MetadataRepo metadataRepo) {
                        CompatInternal19.this.PlaceComponentResult(metadataRepo);
                    }

                    @Override // androidx.emoji.text.EmojiCompat.MetadataRepoLoaderCallback
                    public void MyBillsEntityDataFactory(Throwable th) {
                        CompatInternal19.this.MyBillsEntityDataFactory.BuiltInFictitiousFunctionClassFactory(th);
                    }
                });
            } catch (Throwable th) {
                this.MyBillsEntityDataFactory.BuiltInFictitiousFunctionClassFactory(th);
            }
        }

        final void PlaceComponentResult(MetadataRepo metadataRepo) {
            if (metadataRepo == null) {
                this.MyBillsEntityDataFactory.BuiltInFictitiousFunctionClassFactory(new IllegalArgumentException("metadataRepo cannot be null"));
                return;
            }
            this.KClassImpl$Data$declaredNonStaticMembers$2 = metadataRepo;
            this.getAuthRequestContext = new EmojiProcessor(this.KClassImpl$Data$declaredNonStaticMembers$2, new SpanFactory(), this.MyBillsEntityDataFactory.MyBillsEntityDataFactory, this.MyBillsEntityDataFactory.PlaceComponentResult);
            this.MyBillsEntityDataFactory.getAuthRequestContext();
        }

        @Override // androidx.emoji.text.EmojiCompat.CompatInternal
        final CharSequence BuiltInFictitiousFunctionClassFactory(CharSequence charSequence, int i, int i2, int i3, boolean z) {
            return this.getAuthRequestContext.PlaceComponentResult(charSequence, i, i2, i3, z);
        }

        @Override // androidx.emoji.text.EmojiCompat.CompatInternal
        final void getAuthRequestContext(EditorInfo editorInfo) {
            editorInfo.extras.putInt("android.support.text.emoji.emojiCompat_metadataVersion", this.KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2.MyBillsEntityDataFactory());
            editorInfo.extras.putBoolean("android.support.text.emoji.emojiCompat_replaceAll", this.MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2);
        }
    }
}
