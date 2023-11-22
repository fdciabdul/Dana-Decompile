package androidx.core.content;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.pm.ProviderInfo;
import android.content.res.XmlResourceParser;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.ParcelFileDescriptor;
import android.text.TextUtils;
import android.webkit.MimeTypeMap;
import com.alipay.mobile.zebra.ZebraLoader;
import id.dana.data.constant.BranchLinkConstant;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import net.sqlcipher.database.SQLiteDatabase;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: classes2.dex */
public class FileProvider extends ContentProvider {
    private static final String ATTR_NAME = "name";
    private static final String ATTR_PATH = "path";
    private static final String DISPLAYNAME_FIELD = "displayName";
    private static final String META_DATA_FILE_PROVIDER_PATHS = "android.support.FILE_PROVIDER_PATHS";
    private static final String TAG_CACHE_PATH = "cache-path";
    private static final String TAG_EXTERNAL = "external-path";
    private static final String TAG_EXTERNAL_CACHE = "external-cache-path";
    private static final String TAG_EXTERNAL_FILES = "external-files-path";
    private static final String TAG_EXTERNAL_MEDIA = "external-media-path";
    private static final String TAG_FILES_PATH = "files-path";
    private static final String TAG_ROOT_PATH = "root-path";
    private int mResourceId;
    private PathStrategy mStrategy;
    private static final String[] COLUMNS = {"_display_name", "_size"};
    private static final File DEVICE_ROOT = new File("/");
    private static final HashMap<String, PathStrategy> sCache = new HashMap<>();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public interface PathStrategy {
        File KClassImpl$Data$declaredNonStaticMembers$2(Uri uri);

        Uri MyBillsEntityDataFactory(File file);
    }

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        return true;
    }

    public FileProvider() {
        this.mResourceId = 0;
    }

    protected FileProvider(int i) {
        this.mResourceId = i;
    }

    @Override // android.content.ContentProvider
    public void attachInfo(Context context, ProviderInfo providerInfo) {
        super.attachInfo(context, providerInfo);
        if (providerInfo.exported) {
            throw new SecurityException("Provider must not be exported");
        }
        if (!providerInfo.grantUriPermissions) {
            throw new SecurityException("Provider must grant uri permissions");
        }
        String str = providerInfo.authority.split(";")[0];
        HashMap<String, PathStrategy> hashMap = sCache;
        synchronized (hashMap) {
            hashMap.remove(str);
        }
        this.mStrategy = getPathStrategy(context, str, this.mResourceId);
    }

    public static Uri getUriForFile(Context context, String str, File file) {
        return getPathStrategy(context, str, 0).MyBillsEntityDataFactory(file);
    }

    public static Uri getUriForFile(Context context, String str, File file, String str2) {
        return getUriForFile(context, str, file).buildUpon().appendQueryParameter("displayName", str2).build();
    }

    @Override // android.content.ContentProvider
    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        int i;
        File KClassImpl$Data$declaredNonStaticMembers$2 = this.mStrategy.KClassImpl$Data$declaredNonStaticMembers$2(uri);
        String queryParameter = uri.getQueryParameter("displayName");
        if (strArr == null) {
            strArr = COLUMNS;
        }
        String[] strArr3 = new String[strArr.length];
        Object[] objArr = new Object[strArr.length];
        int i2 = 0;
        for (String str3 : strArr) {
            if ("_display_name".equals(str3)) {
                strArr3[i2] = "_display_name";
                i = i2 + 1;
                objArr[i2] = queryParameter == null ? KClassImpl$Data$declaredNonStaticMembers$2.getName() : queryParameter;
            } else if ("_size".equals(str3)) {
                strArr3[i2] = "_size";
                i = i2 + 1;
                objArr[i2] = Long.valueOf(KClassImpl$Data$declaredNonStaticMembers$2.length());
            }
            i2 = i;
        }
        String[] copyOf = copyOf(strArr3, i2);
        Object[] copyOf2 = copyOf(objArr, i2);
        MatrixCursor matrixCursor = new MatrixCursor(copyOf, 1);
        matrixCursor.addRow(copyOf2);
        return matrixCursor;
    }

    @Override // android.content.ContentProvider
    public String getType(Uri uri) {
        File KClassImpl$Data$declaredNonStaticMembers$2 = this.mStrategy.KClassImpl$Data$declaredNonStaticMembers$2(uri);
        int lastIndexOf = KClassImpl$Data$declaredNonStaticMembers$2.getName().lastIndexOf(46);
        if (lastIndexOf >= 0) {
            String mimeTypeFromExtension = MimeTypeMap.getSingleton().getMimeTypeFromExtension(KClassImpl$Data$declaredNonStaticMembers$2.getName().substring(lastIndexOf + 1));
            return mimeTypeFromExtension != null ? mimeTypeFromExtension : ZebraLoader.MIME_TYPE_STREAM;
        }
        return ZebraLoader.MIME_TYPE_STREAM;
    }

    @Override // android.content.ContentProvider
    public Uri insert(Uri uri, ContentValues contentValues) {
        throw new UnsupportedOperationException("No external inserts");
    }

    @Override // android.content.ContentProvider
    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        throw new UnsupportedOperationException("No external updates");
    }

    @Override // android.content.ContentProvider
    public int delete(Uri uri, String str, String[] strArr) {
        return this.mStrategy.KClassImpl$Data$declaredNonStaticMembers$2(uri).delete() ? 1 : 0;
    }

    @Override // android.content.ContentProvider
    public ParcelFileDescriptor openFile(Uri uri, String str) throws FileNotFoundException {
        return ParcelFileDescriptor.open(this.mStrategy.KClassImpl$Data$declaredNonStaticMembers$2(uri), modeToMode(str));
    }

    private static PathStrategy getPathStrategy(Context context, String str, int i) {
        PathStrategy pathStrategy;
        HashMap<String, PathStrategy> hashMap = sCache;
        synchronized (hashMap) {
            pathStrategy = hashMap.get(str);
            if (pathStrategy == null) {
                try {
                    try {
                        pathStrategy = parsePathStrategy(context, str, i);
                        hashMap.put(str, pathStrategy);
                    } catch (IOException e) {
                        throw new IllegalArgumentException("Failed to parse android.support.FILE_PROVIDER_PATHS meta-data", e);
                    }
                } catch (XmlPullParserException e2) {
                    throw new IllegalArgumentException("Failed to parse android.support.FILE_PROVIDER_PATHS meta-data", e2);
                }
            }
        }
        return pathStrategy;
    }

    static XmlResourceParser getFileProviderPathsMetaData(Context context, String str, ProviderInfo providerInfo, int i) {
        if (providerInfo == null) {
            StringBuilder sb = new StringBuilder();
            sb.append("Couldn't find meta-data for provider with authority ");
            sb.append(str);
            throw new IllegalArgumentException(sb.toString());
        }
        if (providerInfo.metaData == null && i != 0) {
            providerInfo.metaData = new Bundle(1);
            providerInfo.metaData.putInt(META_DATA_FILE_PROVIDER_PATHS, i);
        }
        XmlResourceParser loadXmlMetaData = providerInfo.loadXmlMetaData(context.getPackageManager(), META_DATA_FILE_PROVIDER_PATHS);
        if (loadXmlMetaData != null) {
            return loadXmlMetaData;
        }
        throw new IllegalArgumentException("Missing android.support.FILE_PROVIDER_PATHS meta-data");
    }

    private static PathStrategy parsePathStrategy(Context context, String str, int i) throws IOException, XmlPullParserException {
        SimplePathStrategy simplePathStrategy = new SimplePathStrategy(str);
        XmlResourceParser fileProviderPathsMetaData = getFileProviderPathsMetaData(context, str, context.getPackageManager().resolveContentProvider(str, 128), i);
        while (true) {
            int next = fileProviderPathsMetaData.next();
            if (next == 1) {
                return simplePathStrategy;
            }
            if (next == 2) {
                String name = fileProviderPathsMetaData.getName();
                File file = null;
                String attributeValue = fileProviderPathsMetaData.getAttributeValue(null, "name");
                String attributeValue2 = fileProviderPathsMetaData.getAttributeValue(null, "path");
                if (TAG_ROOT_PATH.equals(name)) {
                    file = DEVICE_ROOT;
                } else if (TAG_FILES_PATH.equals(name)) {
                    file = context.getFilesDir();
                } else if (TAG_CACHE_PATH.equals(name)) {
                    file = context.getCacheDir();
                } else if (TAG_EXTERNAL.equals(name)) {
                    file = Environment.getExternalStorageDirectory();
                } else if (TAG_EXTERNAL_FILES.equals(name)) {
                    File[] authRequestContext = ContextCompat.getAuthRequestContext(context, null);
                    if (authRequestContext.length > 0) {
                        file = authRequestContext[0];
                    }
                } else if (TAG_EXTERNAL_CACHE.equals(name)) {
                    File[] PlaceComponentResult = ContextCompat.PlaceComponentResult(context);
                    if (PlaceComponentResult.length > 0) {
                        file = PlaceComponentResult[0];
                    }
                } else if (Build.VERSION.SDK_INT >= 21 && TAG_EXTERNAL_MEDIA.equals(name)) {
                    File[] BuiltInFictitiousFunctionClassFactory = Api21Impl.BuiltInFictitiousFunctionClassFactory(context);
                    if (BuiltInFictitiousFunctionClassFactory.length > 0) {
                        file = BuiltInFictitiousFunctionClassFactory[0];
                    }
                }
                if (file != null) {
                    File buildPath = buildPath(file, attributeValue2);
                    if (TextUtils.isEmpty(attributeValue)) {
                        throw new IllegalArgumentException("Name must not be empty");
                    }
                    try {
                        simplePathStrategy.PlaceComponentResult.put(attributeValue, buildPath.getCanonicalFile());
                    } catch (IOException e) {
                        StringBuilder sb = new StringBuilder();
                        sb.append("Failed to resolve canonical path for ");
                        sb.append(buildPath);
                        throw new IllegalArgumentException(sb.toString(), e);
                    }
                } else {
                    continue;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static class SimplePathStrategy implements PathStrategy {
        private final String BuiltInFictitiousFunctionClassFactory;
        final HashMap<String, File> PlaceComponentResult = new HashMap<>();

        SimplePathStrategy(String str) {
            this.BuiltInFictitiousFunctionClassFactory = str;
        }

        @Override // androidx.core.content.FileProvider.PathStrategy
        public final Uri MyBillsEntityDataFactory(File file) {
            String substring;
            try {
                String canonicalPath = file.getCanonicalPath();
                Map.Entry<String, File> entry = null;
                for (Map.Entry<String, File> entry2 : this.PlaceComponentResult.entrySet()) {
                    String path = entry2.getValue().getPath();
                    if (canonicalPath.startsWith(path) && (entry == null || path.length() > entry.getValue().getPath().length())) {
                        entry = entry2;
                    }
                }
                if (entry == null) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("Failed to find configured root that contains ");
                    sb.append(canonicalPath);
                    throw new IllegalArgumentException(sb.toString());
                }
                String path2 = entry.getValue().getPath();
                if (path2.endsWith("/")) {
                    substring = canonicalPath.substring(path2.length());
                } else {
                    substring = canonicalPath.substring(path2.length() + 1);
                }
                StringBuilder sb2 = new StringBuilder();
                sb2.append(Uri.encode(entry.getKey()));
                sb2.append('/');
                sb2.append(Uri.encode(substring, "/"));
                return new Uri.Builder().scheme("content").authority(this.BuiltInFictitiousFunctionClassFactory).encodedPath(sb2.toString()).build();
            } catch (IOException unused) {
                StringBuilder sb3 = new StringBuilder();
                sb3.append("Failed to resolve canonical path for ");
                sb3.append(file);
                throw new IllegalArgumentException(sb3.toString());
            }
        }

        @Override // androidx.core.content.FileProvider.PathStrategy
        public final File KClassImpl$Data$declaredNonStaticMembers$2(Uri uri) {
            String encodedPath = uri.getEncodedPath();
            int indexOf = encodedPath.indexOf(47, 1);
            String decode = Uri.decode(encodedPath.substring(1, indexOf));
            String decode2 = Uri.decode(encodedPath.substring(indexOf + 1));
            File file = this.PlaceComponentResult.get(decode);
            if (file == null) {
                StringBuilder sb = new StringBuilder();
                sb.append("Unable to find configured root for ");
                sb.append(uri);
                throw new IllegalArgumentException(sb.toString());
            }
            File file2 = new File(file, decode2);
            try {
                File canonicalFile = file2.getCanonicalFile();
                if (canonicalFile.getPath().startsWith(file.getPath())) {
                    return canonicalFile;
                }
                throw new SecurityException("Resolved path jumped beyond configured root");
            } catch (IOException unused) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Failed to resolve canonical path for ");
                sb2.append(file2);
                throw new IllegalArgumentException(sb2.toString());
            }
        }
    }

    private static int modeToMode(String str) {
        if (BranchLinkConstant.PayloadKey.REFERRAL.equals(str)) {
            return SQLiteDatabase.CREATE_IF_NECESSARY;
        }
        if ("w".equals(str) || "wt".equals(str)) {
            return 738197504;
        }
        if ("wa".equals(str)) {
            return 704643072;
        }
        if ("rw".equals(str)) {
            return 939524096;
        }
        if ("rwt".equals(str)) {
            return 1006632960;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Invalid mode: ");
        sb.append(str);
        throw new IllegalArgumentException(sb.toString());
    }

    private static File buildPath(File file, String... strArr) {
        for (String str : strArr) {
            if (str != null) {
                file = new File(file, str);
            }
        }
        return file;
    }

    private static String[] copyOf(String[] strArr, int i) {
        String[] strArr2 = new String[i];
        System.arraycopy(strArr, 0, strArr2, 0, i);
        return strArr2;
    }

    private static Object[] copyOf(Object[] objArr, int i) {
        Object[] objArr2 = new Object[i];
        System.arraycopy(objArr, 0, objArr2, 0, i);
        return objArr2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static class Api21Impl {
        private Api21Impl() {
        }

        static File[] BuiltInFictitiousFunctionClassFactory(Context context) {
            return context.getExternalMediaDirs();
        }
    }
}
