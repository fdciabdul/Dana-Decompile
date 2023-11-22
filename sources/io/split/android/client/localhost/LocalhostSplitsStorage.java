package io.split.android.client.localhost;

import android.content.Context;
import com.google.common.base.Preconditions;
import com.google.common.collect.Maps;
import io.split.android.client.dtos.Split;
import io.split.android.client.events.EventsManagerCoordinator;
import io.split.android.client.events.SplitInternalEvent;
import io.split.android.client.service.ServiceConstants;
import io.split.android.client.storage.legacy.FileStorage;
import io.split.android.client.storage.splits.ProcessedSplitChange;
import io.split.android.client.storage.splits.SplitsStorage;
import io.split.android.client.utils.FileUtils;
import io.split.android.client.utils.logger.Logger;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes6.dex */
public class LocalhostSplitsStorage implements SplitsStorage {
    private final Context mContext;
    private final EventsManagerCoordinator mEventsManager;
    private final FileStorage mFileStorage;
    private String mLocalhostFileName;
    private LocalhostFileParser mParser;
    private final Map<String, Split> mInMemorySplits = Maps.newConcurrentMap();
    private final FileUtils mFileUtils = new FileUtils();
    private String mLastContentLoaded = "";

    @Override // io.split.android.client.storage.splits.SplitsStorage
    public String getSplitsFilterQueryString() {
        return "";
    }

    @Override // io.split.android.client.storage.splits.SplitsStorage
    public long getTill() {
        return 1L;
    }

    @Override // io.split.android.client.storage.splits.SplitsStorage
    public long getUpdateTimestamp() {
        return 1L;
    }

    @Override // io.split.android.client.storage.splits.SplitsStorage
    public boolean isValidTrafficType(String str) {
        return true;
    }

    @Override // io.split.android.client.storage.splits.SplitsStorage
    public void update(ProcessedSplitChange processedSplitChange) {
    }

    @Override // io.split.android.client.storage.splits.SplitsStorage
    public void updateSplitsFilterQueryString(String str) {
    }

    @Override // io.split.android.client.storage.splits.SplitsStorage
    public void updateWithoutChecks(Split split) {
    }

    public LocalhostSplitsStorage(String str, Context context, FileStorage fileStorage, EventsManagerCoordinator eventsManagerCoordinator) {
        this.mLocalhostFileName = str;
        this.mContext = (Context) Preconditions.checkNotNull(context);
        this.mFileStorage = (FileStorage) Preconditions.checkNotNull(fileStorage);
        this.mEventsManager = (EventsManagerCoordinator) Preconditions.checkNotNull(eventsManagerCoordinator);
        setup();
    }

    @Override // io.split.android.client.storage.splits.SplitsStorage
    public void loadLocal() {
        loadSplits();
    }

    @Override // io.split.android.client.storage.splits.SplitsStorage
    public Split get(String str) {
        return this.mInMemorySplits.get(str);
    }

    @Override // io.split.android.client.storage.splits.SplitsStorage
    public Map<String, Split> getMany(List<String> list) {
        HashMap hashMap = new HashMap();
        synchronized (this) {
            if (list != null) {
                if (!list.isEmpty()) {
                    for (String str : list) {
                        Split split = this.mInMemorySplits.get(str);
                        if (split != null) {
                            hashMap.put(str, split);
                        }
                    }
                    return hashMap;
                }
            }
            hashMap.putAll(this.mInMemorySplits);
            return hashMap;
        }
    }

    @Override // io.split.android.client.storage.splits.SplitsStorage
    public Map<String, Split> getAll() {
        HashMap hashMap = new HashMap();
        synchronized (this) {
            hashMap.putAll(this.mInMemorySplits);
        }
        return hashMap;
    }

    @Override // io.split.android.client.storage.splits.SplitsStorage
    public void clear() {
        this.mInMemorySplits.clear();
    }

    private void setup() {
        if (this.mLocalhostFileName == null) {
            String yamlFileName = getYamlFileName(this.mContext);
            if (yamlFileName != null) {
                this.mLocalhostFileName = yamlFileName;
            } else {
                this.mLocalhostFileName = "splits.properties";
                Logger.w("Localhost mode: .split mocks will be deprecated soon in favor of YAML files, which provide more targeting power. Take a look in our documentation.");
            }
        }
        if (this.mFileUtils.isPropertiesFileName(this.mLocalhostFileName)) {
            this.mParser = new LocalhostPropertiesFileParser();
        } else {
            this.mParser = new LocalhostYamlFileParser();
        }
        copyFileResourceToDataFolder(this.mLocalhostFileName, this.mFileStorage, this.mContext);
    }

    private void loadSplits() {
        try {
            String read = this.mFileStorage.read(this.mLocalhostFileName);
            StringBuilder sb = new StringBuilder();
            sb.append("Localhost file reloaded: ");
            sb.append(this.mLocalhostFileName);
            Logger.i(sb.toString());
            if (read == null) {
                return;
            }
            synchronized (this) {
                this.mInMemorySplits.clear();
                Map<String, Split> parse = this.mParser.parse(read);
                if (parse != null) {
                    this.mInMemorySplits.putAll(parse);
                }
                if (!read.equals(this.mLastContentLoaded)) {
                    this.mEventsManager.notifyInternalEvent(SplitInternalEvent.SPLITS_LOADED_FROM_STORAGE);
                    this.mEventsManager.notifyInternalEvent(SplitInternalEvent.SPLITS_FETCHED);
                    this.mEventsManager.notifyInternalEvent(SplitInternalEvent.SPLITS_UPDATED);
                }
                this.mLastContentLoaded = read;
            }
        } catch (IOException unused) {
            Logger.e("Error reading localhost yaml file");
        }
    }

    private String getYamlFileName(Context context) {
        Iterator it = Arrays.asList(ServiceConstants.YAML_EXTENSION, ServiceConstants.YML_EXTENSION).iterator();
        while (it.hasNext()) {
            String checkFileType = checkFileType(context, this.mFileUtils, (String) it.next());
            if (checkFileType != null) {
                return checkFileType;
            }
        }
        return null;
    }

    private String checkFileType(Context context, FileUtils fileUtils, String str) {
        StringBuilder sb = new StringBuilder();
        sb.append("splits.");
        sb.append(str);
        String obj = sb.toString();
        if (fileUtils.fileExists(obj, context)) {
            return obj;
        }
        return null;
    }

    private void copyFileResourceToDataFolder(String str, FileStorage fileStorage, Context context) {
        try {
            String loadFileContent = new FileUtils().loadFileContent(str, context);
            if (loadFileContent != null) {
                fileStorage.write(str, loadFileContent);
                StringBuilder sb = new StringBuilder();
                sb.append("LOCALHOST MODE: File location is: ");
                sb.append(this.mFileStorage.getRootPath());
                sb.append("/");
                sb.append(str);
                Logger.i(sb.toString());
            }
        } catch (IOException e) {
            Logger.e(e.getLocalizedMessage());
        }
    }
}
