package id.eka_cbn.samplegetpost.helper;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class RowProductAdapter extends BaseAdapter {

    private List<T> objects = new ArrayList<T>();

    private Context context;
    private LayoutInflater layoutInflater;

    public RowProductAdapter(Context context) {
        this.context = context;
        this.layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return objects.size();
    }

    @Override
    public T getItem(int position) {
        return objects.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = layoutInflater.inflate(R.layout.row_product, null);
            convertView.setTag(new ViewHolder(convertView));
        }
        initializeViews((T)getItem(position), (ViewHolder) convertView.getTag());
        return convertView;
    }

    private void initializeViews(T object, ViewHolder holder) {
        //TODO implement
    }

    protected class ViewHolder {
        private TextView mTextNamaProduct;
    private TextView mTextHargaProduk;
    private TextView mTextDeskripsiProduk;

        public ViewHolder(View view) {
            mTextNamaProduct = (TextView) view.findViewById(R.id.mTextNamaProduct);
            mTextHargaProduk = (TextView) view.findViewById(R.id.mTextHargaProduk);
            mTextDeskripsiProduk = (TextView) view.findViewById(R.id.mTextDeskripsiProduk);
        }
    }
}
