package com.alibaba.griver.image.photo.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.alibaba.griver.image.R;
import com.alibaba.griver.image.framework.meta.Size;
import com.alibaba.griver.image.photo.meta.BucketInfo;
import com.alibaba.griver.image.photo.meta.PhotoInfo;
import com.alibaba.griver.image.photo.utils.ImageHelper;
import com.alibaba.griver.image.photo.utils.PhotoUtil;
import java.util.List;

/* loaded from: classes6.dex */
public class BucketAdapter extends PhotoAdapter<BucketInfo> {
    public BucketAdapter(Context context, List<BucketInfo> list) {
        super(context, list);
    }

    @Override // com.alibaba.griver.image.photo.adapter.PhotoAdapter, android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        View inflate = view == null ? LayoutInflater.from(this.context).inflate(R.layout.griver_image_album_item, viewGroup, false) : view;
        ViewHolder viewHolder = ViewHolder.get(inflate);
        ImageView imageView = (ImageView) viewHolder.findViewById(R.id.iv_album);
        ImageView imageView2 = (ImageView) viewHolder.findViewById(R.id.iv_selected);
        TextView textView = (TextView) viewHolder.findViewById(R.id.tv_album_name);
        TextView textView2 = (TextView) viewHolder.findViewById(R.id.tv_album_count);
        BucketInfo bucketInfo = (BucketInfo) this.dataList.get(i);
        if (bucketInfo == null) {
            return inflate;
        }
        Size reorderSize = PhotoUtil.reorderSize(PhotoUtil.dp2px(this.context, 125));
        if (bucketInfo.getPhoto().isVideo()) {
            PhotoInfo photo = bucketInfo.getPhoto();
            ImageHelper.loadWidthThumbnailPath(imageView, photo.getPhotoPath(), null, reorderSize.getWidth(), reorderSize.getHeight(), null, photo.getThumbPath(), photo.getMediaId(), photo.getIsAlbumMedia());
        } else {
            PhotoInfo photo2 = bucketInfo.getPhoto();
            ImageHelper.loadWidthThumbnailPath(imageView, photo2.getPhotoPath(), null, reorderSize.getWidth(), reorderSize.getWidth(), null, photo2.getThumbPath(), photo2.getMediaId(), photo2.getIsAlbumMedia());
        }
        imageView2.setVisibility(bucketInfo.isSelected() ? 0 : 8);
        textView.setText(bucketInfo.getName());
        textView2.setVisibility(bucketInfo.getCount() <= 0 ? 8 : 0);
        StringBuilder sb = new StringBuilder();
        sb.append(bucketInfo.getCount());
        sb.append(viewGroup.getContext().getString(R.string.griver_image_unit_pic));
        textView2.setText(sb.toString());
        return inflate;
    }
}
