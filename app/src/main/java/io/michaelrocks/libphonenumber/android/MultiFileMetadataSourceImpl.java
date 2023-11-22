package io.michaelrocks.libphonenumber.android;

import io.michaelrocks.libphonenumber.android.Phonemetadata;
import j$.util.concurrent.ConcurrentHashMap;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public final class MultiFileMetadataSourceImpl implements MetadataSource {
    private final String alternateFormatsFilePrefix;
    private final ConcurrentHashMap<String, Phonemetadata.PhoneMetadata> geographicalRegions;
    private final MetadataManager metadataManager;
    private final ConcurrentHashMap<Integer, Phonemetadata.PhoneMetadata> nonGeographicalRegions;
    private final String phoneNumberMetadataFilePrefix;
    private final String shortNumberFilePrefix;

    MultiFileMetadataSourceImpl(String str, String str2, String str3, MetadataLoader metadataLoader) {
        this.geographicalRegions = new ConcurrentHashMap<>();
        this.nonGeographicalRegions = new ConcurrentHashMap<>();
        this.phoneNumberMetadataFilePrefix = str;
        this.alternateFormatsFilePrefix = str2;
        this.shortNumberFilePrefix = str3;
        this.metadataManager = new MetadataManager(metadataLoader);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public MultiFileMetadataSourceImpl(MetadataLoader metadataLoader) {
        this("/io/michaelrocks/libphonenumber/android/data/PhoneNumberMetadataProto", "/io/michaelrocks/libphonenumber/android/data/PhoneNumberAlternateFormatsProto", "/io/michaelrocks/libphonenumber/android/data/ShortNumberMetadataProto", metadataLoader);
    }

    @Override // io.michaelrocks.libphonenumber.android.MetadataSource
    public final Phonemetadata.PhoneMetadata getMetadataForRegion(String str) {
        return this.metadataManager.getMetadataFromMultiFilePrefix(str, this.geographicalRegions, this.phoneNumberMetadataFilePrefix);
    }

    @Override // io.michaelrocks.libphonenumber.android.MetadataSource
    public final Phonemetadata.PhoneMetadata getMetadataForNonGeographicalRegion(int i) {
        if (isNonGeographical(i)) {
            return this.metadataManager.getMetadataFromMultiFilePrefix(Integer.valueOf(i), this.nonGeographicalRegions, this.phoneNumberMetadataFilePrefix);
        }
        return null;
    }

    @Override // io.michaelrocks.libphonenumber.android.MetadataSource
    public final Phonemetadata.PhoneMetadata getAlternateFormatsForCountry(int i) {
        return this.metadataManager.getAlternateFormatsForCountry(i, this.alternateFormatsFilePrefix);
    }

    @Override // io.michaelrocks.libphonenumber.android.MetadataSource
    public final Phonemetadata.PhoneMetadata getShortNumberMetadataForRegion(String str) {
        return this.metadataManager.getShortNumberMetadataForRegion(str, this.shortNumberFilePrefix);
    }

    private boolean isNonGeographical(int i) {
        List<String> list = CountryCodeToRegionCodeMap.getCountryCodeToRegionCodeMap().get(Integer.valueOf(i));
        return list.size() == 1 && "001".equals(list.get(0));
    }
}
