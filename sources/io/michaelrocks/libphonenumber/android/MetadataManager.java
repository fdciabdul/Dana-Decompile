package io.michaelrocks.libphonenumber.android;

import io.michaelrocks.libphonenumber.android.Phonemetadata;
import j$.util.concurrent.ConcurrentHashMap;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public final class MetadataManager {
    static final String ALTERNATE_FORMATS_FILE_PREFIX = "/io/michaelrocks/libphonenumber/android/data/PhoneNumberAlternateFormatsProto";
    static final String MULTI_FILE_PHONE_NUMBER_METADATA_FILE_PREFIX = "/io/michaelrocks/libphonenumber/android/data/PhoneNumberMetadataProto";
    static final String SHORT_NUMBER_METADATA_FILE_PREFIX = "/io/michaelrocks/libphonenumber/android/data/ShortNumberMetadataProto";
    private static final Logger logger = Logger.getLogger(MetadataManager.class.getName());
    private final MetadataLoader metadataLoader;
    private final ConcurrentHashMap<Integer, Phonemetadata.PhoneMetadata> alternateFormatsMap = new ConcurrentHashMap<>();
    private final ConcurrentHashMap<String, Phonemetadata.PhoneMetadata> shortNumberMetadataMap = new ConcurrentHashMap<>();
    private final Set<Integer> alternateFormatsCountryCodes = AlternateFormatsCountryCodeSet.getCountryCodeSet();
    private final Set<String> shortNumberMetadataRegionCodes = ShortNumbersRegionCodeSet.getRegionCodeSet();

    /* JADX INFO: Access modifiers changed from: package-private */
    public MetadataManager(MetadataLoader metadataLoader) {
        this.metadataLoader = metadataLoader;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Phonemetadata.PhoneMetadata getAlternateFormatsForCountry(int i, String str) {
        if (this.alternateFormatsCountryCodes.contains(Integer.valueOf(i))) {
            return getMetadataFromMultiFilePrefix(Integer.valueOf(i), this.alternateFormatsMap, str);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Phonemetadata.PhoneMetadata getShortNumberMetadataForRegion(String str, String str2) {
        if (this.shortNumberMetadataRegionCodes.contains(str)) {
            return getMetadataFromMultiFilePrefix(str, this.shortNumberMetadataMap, str2);
        }
        return null;
    }

    final Set<String> getSupportedShortNumberRegions() {
        return Collections.unmodifiableSet(this.shortNumberMetadataRegionCodes);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final <T> Phonemetadata.PhoneMetadata getMetadataFromMultiFilePrefix(T t, ConcurrentHashMap<T, Phonemetadata.PhoneMetadata> concurrentHashMap, String str) {
        Phonemetadata.PhoneMetadata phoneMetadata = concurrentHashMap.get(t);
        if (phoneMetadata != null) {
            return phoneMetadata;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append("_");
        sb.append(t);
        String obj = sb.toString();
        List<Phonemetadata.PhoneMetadata> metadataFromSingleFileName = getMetadataFromSingleFileName(obj, this.metadataLoader);
        if (metadataFromSingleFileName.size() > 1) {
            Logger logger2 = logger;
            Level level = Level.WARNING;
            StringBuilder sb2 = new StringBuilder();
            sb2.append("more than one metadata in file ");
            sb2.append(obj);
            logger2.log(level, sb2.toString());
        }
        Phonemetadata.PhoneMetadata phoneMetadata2 = metadataFromSingleFileName.get(0);
        Phonemetadata.PhoneMetadata putIfAbsent = concurrentHashMap.putIfAbsent(t, phoneMetadata2);
        return putIfAbsent != null ? putIfAbsent : phoneMetadata2;
    }

    private static List<Phonemetadata.PhoneMetadata> getMetadataFromSingleFileName(String str, MetadataLoader metadataLoader) {
        InputStream loadMetadata = metadataLoader.loadMetadata(str);
        if (loadMetadata == null) {
            StringBuilder sb = new StringBuilder();
            sb.append("missing metadata: ");
            sb.append(str);
            throw new IllegalStateException(sb.toString());
        }
        List<Phonemetadata.PhoneMetadata> metadataList = loadMetadataAndCloseInput(loadMetadata).getMetadataList();
        if (metadataList.size() != 0) {
            return metadataList;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("empty metadata: ");
        sb2.append(str);
        throw new IllegalStateException(sb2.toString());
    }

    private static Phonemetadata.PhoneMetadataCollection loadMetadataAndCloseInput(InputStream inputStream) {
        ObjectInputStream objectInputStream;
        try {
            try {
                objectInputStream = new ObjectInputStream(inputStream);
            } catch (Throwable th) {
                th = th;
                objectInputStream = null;
            }
            try {
                Phonemetadata.PhoneMetadataCollection phoneMetadataCollection = new Phonemetadata.PhoneMetadataCollection();
                try {
                    phoneMetadataCollection.readExternal(objectInputStream);
                    try {
                        objectInputStream.close();
                    } catch (IOException e) {
                        logger.log(Level.WARNING, "error closing input stream (ignored)", (Throwable) e);
                    }
                    return phoneMetadataCollection;
                } catch (IOException e2) {
                    throw new RuntimeException("cannot load/parse metadata", e2);
                }
            } catch (Throwable th2) {
                th = th2;
                try {
                    if (objectInputStream != null) {
                        objectInputStream.close();
                    } else {
                        inputStream.close();
                    }
                } catch (IOException e3) {
                    logger.log(Level.WARNING, "error closing input stream (ignored)", (Throwable) e3);
                }
                throw th;
            }
        } catch (IOException e4) {
            throw new RuntimeException("cannot load/parse metadata", e4);
        }
    }
}
