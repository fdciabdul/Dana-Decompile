package com.bumptech.glide.load.data;

import android.content.ContentResolver;
import android.content.UriMatcher;
import android.net.Uri;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes3.dex */
public class StreamLocalUriFetcher extends LocalUriFetcher<InputStream> {
    private static final UriMatcher KClassImpl$Data$declaredNonStaticMembers$2;

    @Override // com.bumptech.glide.load.data.LocalUriFetcher
    protected final /* synthetic */ void MyBillsEntityDataFactory(InputStream inputStream) throws IOException {
        inputStream.close();
    }

    static {
        UriMatcher uriMatcher = new UriMatcher(-1);
        KClassImpl$Data$declaredNonStaticMembers$2 = uriMatcher;
        uriMatcher.addURI("com.android.contacts", "contacts/lookup/*/#", 1);
        uriMatcher.addURI("com.android.contacts", "contacts/lookup/*", 1);
        uriMatcher.addURI("com.android.contacts", "contacts/#/photo", 2);
        uriMatcher.addURI("com.android.contacts", "contacts/#", 3);
        uriMatcher.addURI("com.android.contacts", "contacts/#/display_photo", 4);
        uriMatcher.addURI("com.android.contacts", "phone_lookup/*", 5);
    }

    public StreamLocalUriFetcher(ContentResolver contentResolver, Uri uri) {
        super(contentResolver, uri);
    }

    @Override // com.bumptech.glide.load.data.DataFetcher
    public final Class<InputStream> getAuthRequestContext() {
        return InputStream.class;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0025 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0026  */
    @Override // com.bumptech.glide.load.data.LocalUriFetcher
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected final /* synthetic */ java.io.InputStream BuiltInFictitiousFunctionClassFactory(android.net.Uri r4, android.content.ContentResolver r5) throws java.io.FileNotFoundException {
        /*
            r3 = this;
            android.content.UriMatcher r0 = com.bumptech.glide.load.data.StreamLocalUriFetcher.KClassImpl$Data$declaredNonStaticMembers$2
            int r0 = r0.match(r4)
            r1 = 1
            if (r0 == r1) goto L19
            r2 = 3
            if (r0 == r2) goto L14
            r2 = 5
            if (r0 == r2) goto L19
            java.io.InputStream r5 = r5.openInputStream(r4)
            goto L23
        L14:
            java.io.InputStream r5 = android.provider.ContactsContract.Contacts.openContactPhotoInputStream(r5, r4, r1)
            goto L23
        L19:
            android.net.Uri r0 = android.provider.ContactsContract.Contacts.lookupContact(r5, r4)
            if (r0 == 0) goto L3d
            java.io.InputStream r5 = android.provider.ContactsContract.Contacts.openContactPhotoInputStream(r5, r0, r1)
        L23:
            if (r5 == 0) goto L26
            return r5
        L26:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r0 = "InputStream is null for "
            r5.append(r0)
            r5.append(r4)
            java.io.FileNotFoundException r4 = new java.io.FileNotFoundException
            java.lang.String r5 = r5.toString()
            r4.<init>(r5)
            throw r4
        L3d:
            java.io.FileNotFoundException r4 = new java.io.FileNotFoundException
            java.lang.String r5 = "Contact cannot be found"
            r4.<init>(r5)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.load.data.StreamLocalUriFetcher.BuiltInFictitiousFunctionClassFactory(android.net.Uri, android.content.ContentResolver):java.lang.Object");
    }
}
