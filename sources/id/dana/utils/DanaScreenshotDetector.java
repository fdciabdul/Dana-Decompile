package id.dana.utils;

import android.app.Activity;
import android.content.ContentResolver;
import android.database.ContentObserver;
import android.database.Cursor;
import android.net.Uri;
import android.provider.MediaStore;
import id.dana.utils.permission.PermissionHelper;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.functions.Cancellable;
import timber.log.Timber;

/* loaded from: classes5.dex */
public final class DanaScreenshotDetector {
    private static final String PlaceComponentResult = MediaStore.Images.Media.EXTERNAL_CONTENT_URI.toString();
    private static final String[] getAuthRequestContext = {"_display_name", "_data", "date_added"};
    private final Activity BuiltInFictitiousFunctionClassFactory;

    private DanaScreenshotDetector(Activity activity) {
        this.BuiltInFictitiousFunctionClassFactory = activity;
    }

    public static Observable<String> KClassImpl$Data$declaredNonStaticMembers$2(Activity activity) {
        final DanaScreenshotDetector danaScreenshotDetector = new DanaScreenshotDetector(activity);
        if (!OSUtil.MyBillsEntityDataFactory() && !PermissionHelper.MyBillsEntityDataFactory(danaScreenshotDetector.BuiltInFictitiousFunctionClassFactory, "android.permission.READ_EXTERNAL_STORAGE")) {
            return Observable.error(new SecurityException("Permission not granted"));
        }
        final ContentResolver contentResolver = danaScreenshotDetector.BuiltInFictitiousFunctionClassFactory.getContentResolver();
        return Observable.create(new ObservableOnSubscribe() { // from class: id.dana.utils.DanaScreenshotDetector$$ExternalSyntheticLambda0
            @Override // io.reactivex.ObservableOnSubscribe
            public final void subscribe(final ObservableEmitter observableEmitter) {
                final DanaScreenshotDetector danaScreenshotDetector2 = DanaScreenshotDetector.this;
                final ContentResolver contentResolver2 = contentResolver;
                final ContentObserver contentObserver = new ContentObserver() { // from class: id.dana.utils.DanaScreenshotDetector.1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(null);
                    }

                    @Override // android.database.ContentObserver
                    public void onChange(boolean z, Uri uri) {
                        Timber.Tree authRequestContext = Timber.getAuthRequestContext("DanaScreenshotDetector");
                        StringBuilder sb = new StringBuilder();
                        sb.append("onChange: ");
                        sb.append(z);
                        sb.append(", ");
                        sb.append(uri.toString());
                        authRequestContext.BuiltInFictitiousFunctionClassFactory(sb.toString(), new Object[0]);
                        if (uri.toString().startsWith(DanaScreenshotDetector.PlaceComponentResult)) {
                            try {
                                Cursor query = contentResolver2.query(uri, DanaScreenshotDetector.getAuthRequestContext, null, null, "date_added DESC");
                                if (query != null) {
                                    try {
                                        if (query.moveToFirst()) {
                                            String string = query.getString(query.getColumnIndex("_data"));
                                            long j = query.getLong(query.getColumnIndex("date_added"));
                                            long currentTimeMillis = System.currentTimeMillis() / 1000;
                                            Timber.Tree authRequestContext2 = Timber.getAuthRequestContext("DanaScreenshotDetector");
                                            StringBuilder sb2 = new StringBuilder();
                                            sb2.append("path: ");
                                            sb2.append(string);
                                            sb2.append(", dateAdded: ");
                                            sb2.append(j);
                                            sb2.append(", currentTime: ");
                                            sb2.append(currentTimeMillis);
                                            authRequestContext2.BuiltInFictitiousFunctionClassFactory(sb2.toString(), new Object[0]);
                                            if (DanaScreenshotDetector.getAuthRequestContext(string) && DanaScreenshotDetector.MyBillsEntityDataFactory(currentTimeMillis, j)) {
                                                observableEmitter.onNext(string);
                                            }
                                        }
                                    } finally {
                                    }
                                }
                                if (query != null) {
                                    query.close();
                                }
                            } catch (Exception unused) {
                            }
                        }
                        super.onChange(z, uri);
                    }
                };
                contentResolver2.registerContentObserver(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, true, contentObserver);
                observableEmitter.setCancellable(new Cancellable() { // from class: id.dana.utils.DanaScreenshotDetector$$ExternalSyntheticLambda1
                    @Override // io.reactivex.functions.Cancellable
                    public final void cancel() {
                        contentResolver2.unregisterContentObserver(contentObserver);
                    }
                });
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean getAuthRequestContext(String str) {
        return str.toLowerCase().contains("screenshot") || str.contains("截屏") || str.contains("截图");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean MyBillsEntityDataFactory(long j, long j2) {
        return Math.abs(j - j2) <= 10;
    }
}
