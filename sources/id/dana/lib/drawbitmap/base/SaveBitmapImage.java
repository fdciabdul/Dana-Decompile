package id.dana.lib.drawbitmap.base;

import android.content.Context;
import android.graphics.Bitmap;
import id.dana.util.a.a;
import id.dana.util.media.FileUtil;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.concurrent.Callable;

/* loaded from: classes5.dex */
public class SaveBitmapImage {
    private Context context;
    private String filenamePrefix;
    private String imageFormat;

    public SaveBitmapImage(Context context, String str, String str2) {
        this.context = context;
        this.filenamePrefix = str;
        this.imageFormat = str2;
    }

    public Observable<String> saveToInternalStorage(final Bitmap bitmap) {
        return Observable.fromCallable(new Callable<String>() { // from class: id.dana.lib.drawbitmap.base.SaveBitmapImage.1
            {
                SaveBitmapImage.this = this;
            }

            @Override // java.util.concurrent.Callable
            public String call() {
                File MyBillsEntityDataFactory;
                long currentTimeMillis = System.currentTimeMillis() / 1000;
                MyBillsEntityDataFactory = a.MyBillsEntityDataFactory(SaveBitmapImage.this.context.getFilesDir(), "/DANA/");
                if (!FileUtil.MyBillsEntityDataFactory(MyBillsEntityDataFactory.getAbsolutePath())) {
                    FileUtil.getAuthRequestContext(MyBillsEntityDataFactory.getAbsolutePath());
                }
                try {
                    StringBuilder sb = new StringBuilder();
                    sb.append(SaveBitmapImage.this.filenamePrefix);
                    sb.append(currentTimeMillis);
                    sb.append(SaveBitmapImage.this.imageFormat);
                    File file = new File(MyBillsEntityDataFactory, sb.toString());
                    FileOutputStream fileOutputStream = new FileOutputStream(file);
                    bitmap.compress(Bitmap.CompressFormat.JPEG, 100, fileOutputStream);
                    fileOutputStream.flush();
                    fileOutputStream.close();
                    return file.getPath();
                } catch (IOException unused) {
                    return null;
                }
            }
        }).subscribeOn(AndroidSchedulers.PlaceComponentResult()).observeOn(Schedulers.MyBillsEntityDataFactory());
    }
}
