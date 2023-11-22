package com.alibaba.griver.image.photo.adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.alibaba.griver.image.R;
import com.alibaba.griver.image.photo.meta.PhotoGrid;
import com.alibaba.griver.image.photo.meta.PhotoItem;
import com.fullstory.instrumentation.InstrumentInjector;
import java.util.ArrayList;

/* loaded from: classes6.dex */
public class GridAdapter extends PhotoAdapter<PhotoItem> {
    public static final String TAG = "GridAdapter";

    /* renamed from: a  reason: collision with root package name */
    private boolean f6604a;
    private boolean b;
    public PhotoItem cameraItem;
    public Drawable defaultDrawable;
    protected OnGridListener gridListener;

    /* loaded from: classes6.dex */
    public interface OnGridListener {
        void onGridChecked(PhotoGrid photoGrid, int i);

        void onGridClick(PhotoGrid photoGrid, int i);
    }

    public void setEnableVideoEdit(boolean z) {
        this.b = z;
    }

    public GridAdapter(Context context, ArrayList<PhotoItem> arrayList, boolean z) {
        super(context, arrayList);
        this.f6604a = z;
        this.defaultDrawable = InstrumentInjector.Resources_getDrawable(context.getResources(), R.drawable.griver_image_default_photo);
    }

    @Override // com.alibaba.griver.image.photo.adapter.PhotoAdapter, android.widget.Adapter
    public int getCount() {
        int size = this.dataList == null ? 0 : this.dataList.size();
        return this.cameraItem != null ? size + 1 : size;
    }

    public void setCheckable(boolean z) {
        this.f6604a = z;
    }

    public void setGridListener(OnGridListener onGridListener) {
        this.gridListener = onGridListener;
    }

    @Override // com.alibaba.griver.image.photo.adapter.PhotoAdapter, android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        PhotoGrid photoGrid;
        if (view instanceof PhotoGrid) {
            photoGrid = (PhotoGrid) view;
        } else {
            photoGrid = (PhotoGrid) LayoutInflater.from(this.context).inflate(R.layout.griver_image_photo_grid, viewGroup, false);
            photoGrid.setDefaultDrawable(this.defaultDrawable);
        }
        PhotoItem photoItem = this.cameraItem;
        if (photoItem == null || i != 0) {
            if (photoItem != null && i > 0) {
                i--;
            }
            photoItem = (PhotoItem) this.dataList.get(i);
        } else {
            i = -1;
        }
        photoGrid.setCheckable(this.f6604a);
        photoGrid.setEnableVideoEdit(this.b);
        photoGrid.setPhotoInfo(photoItem, i);
        photoGrid.setGridListener(this.gridListener);
        return photoGrid;
    }
}
