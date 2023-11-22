package io.michaelrocks.libphonenumber.android;

import io.michaelrocks.libphonenumber.android.Phonemetadata;

/* loaded from: classes6.dex */
interface MetadataSource {
    Phonemetadata.PhoneMetadata getAlternateFormatsForCountry(int i);

    Phonemetadata.PhoneMetadata getMetadataForNonGeographicalRegion(int i);

    Phonemetadata.PhoneMetadata getMetadataForRegion(String str);

    Phonemetadata.PhoneMetadata getShortNumberMetadataForRegion(String str);
}
