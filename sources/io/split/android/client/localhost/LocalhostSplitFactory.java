package io.split.android.client.localhost;

import android.content.Context;
import io.split.android.client.SplitClient;
import io.split.android.client.SplitClientConfig;
import io.split.android.client.SplitFactory;
import io.split.android.client.SplitManager;
import io.split.android.client.SplitManagerImpl;
import io.split.android.client.api.Key;
import io.split.android.client.attributes.AttributesManagerFactoryImpl;
import io.split.android.client.attributes.AttributesMergerImpl;
import io.split.android.client.events.EventsManagerCoordinator;
import io.split.android.client.localhost.shared.LocalhostSplitClientContainerImpl;
import io.split.android.client.service.executor.SplitTaskExecutorImpl;
import io.split.android.client.shared.SplitClientContainer;
import io.split.android.client.shared.UserConsent;
import io.split.android.client.storage.legacy.FileStorage;
import io.split.android.client.storage.splits.SplitsStorage;
import io.split.android.client.telemetry.storage.NoOpTelemetryStorage;
import io.split.android.client.utils.logger.Logger;
import io.split.android.client.validators.AttributesValidatorImpl;
import io.split.android.client.validators.SplitValidatorImpl;
import io.split.android.client.validators.ValidationMessageLoggerImpl;
import io.split.android.engine.experiments.SplitParser;
import java.io.IOException;
import java.util.Iterator;

/* loaded from: classes6.dex */
public class LocalhostSplitFactory implements SplitFactory {
    private final SplitClientContainer mClientContainer;
    private final String mDefaultKey;
    private String mLocalhostFileName;
    private final SplitManager mManager;
    private final LocalhostSynchronizer mSynchronizer;

    @Override // io.split.android.client.SplitFactory
    public void setUserConsent(boolean z) {
    }

    public LocalhostSplitFactory(String str, Context context, SplitClientConfig splitClientConfig) throws IOException {
        this(str, context, splitClientConfig, null);
    }

    public LocalhostSplitFactory(String str, Context context, SplitClientConfig splitClientConfig, String str2) throws IOException {
        this.mLocalhostFileName = null;
        if (str2 != null) {
            this.mLocalhostFileName = str2;
        }
        this.mDefaultKey = str;
        EventsManagerCoordinator eventsManagerCoordinator = new EventsManagerCoordinator();
        LocalhostSplitsStorage localhostSplitsStorage = new LocalhostSplitsStorage(this.mLocalhostFileName, context, new FileStorage(context.getCacheDir(), "localhost"), eventsManagerCoordinator);
        SplitParser splitParser = new SplitParser(new LocalhostMySegmentsStorageContainer());
        SplitTaskExecutorImpl splitTaskExecutorImpl = new SplitTaskExecutorImpl();
        AttributesManagerFactoryImpl attributesManagerFactoryImpl = new AttributesManagerFactoryImpl(new AttributesValidatorImpl(), new ValidationMessageLoggerImpl());
        this.mManager = new SplitManagerImpl(localhostSplitsStorage, new SplitValidatorImpl(), splitParser);
        this.mClientContainer = new LocalhostSplitClientContainerImpl(this, splitClientConfig, localhostSplitsStorage, splitParser, attributesManagerFactoryImpl, new AttributesMergerImpl(), new NoOpTelemetryStorage(), eventsManagerCoordinator, splitTaskExecutorImpl);
        LocalhostSynchronizer localhostSynchronizer = new LocalhostSynchronizer(splitTaskExecutorImpl, splitClientConfig, localhostSplitsStorage);
        this.mSynchronizer = localhostSynchronizer;
        localhostSynchronizer.start();
        Logger.i("Android SDK initialized!");
    }

    LocalhostSplitFactory(SplitsStorage splitsStorage, SplitParser splitParser, String str, LocalhostSynchronizer localhostSynchronizer, SplitClientContainer splitClientContainer) {
        this.mLocalhostFileName = null;
        this.mSynchronizer = localhostSynchronizer;
        this.mClientContainer = splitClientContainer;
        this.mDefaultKey = str;
        this.mManager = new SplitManagerImpl(splitsStorage, new SplitValidatorImpl(), splitParser);
    }

    @Override // io.split.android.client.SplitFactory
    public SplitClient client() {
        return this.mClientContainer.getClient(new Key(this.mDefaultKey));
    }

    @Override // io.split.android.client.SplitFactory
    public SplitClient client(Key key) {
        return this.mClientContainer.getClient(key);
    }

    @Override // io.split.android.client.SplitFactory
    public SplitClient client(String str) {
        return this.mClientContainer.getClient(new Key(str));
    }

    @Override // io.split.android.client.SplitFactory
    public SplitClient client(String str, String str2) {
        return this.mClientContainer.getClient(new Key(str, str2));
    }

    @Override // io.split.android.client.SplitFactory
    public SplitManager manager() {
        return this.mManager;
    }

    @Override // io.split.android.client.SplitFactory
    public void destroy() {
        this.mSynchronizer.stop();
    }

    @Override // io.split.android.client.SplitFactory
    public void flush() {
        Iterator<SplitClient> it = this.mClientContainer.getAll().iterator();
        while (it.hasNext()) {
            it.next().flush();
        }
    }

    @Override // io.split.android.client.SplitFactory
    public UserConsent getUserConsent() {
        return UserConsent.GRANTED;
    }
}
