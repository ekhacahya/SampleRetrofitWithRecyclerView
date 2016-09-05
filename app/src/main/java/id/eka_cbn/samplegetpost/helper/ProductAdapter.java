package id.eka_cbn.samplegetpost.helper;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import id.eka_cbn.samplegetpost.R;
import id.eka_cbn.samplegetpost.model.ProductData;

/**
 * Created by ekhacahya on 9/5/2016.
 * ekhacahya@live.com
 */

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ViewHolder> {

    List<ProductData> productData;

    public ProductAdapter(List<ProductData> productData) {
        this.productData = productData;
    }

    @Override
    public ProductAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_product, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ProductAdapter.ViewHolder holder, int position) {
        holder.tv_name.setText(productData.get(position).getName());
        holder.tv_harga.setText(String.valueOf("Rp. " + productData.get(position).getPrice()));
        holder.tv_deskripsi.setText(productData.get(position).getDescription());
    }

    @Override
    public int getItemCount() {
        return productData.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView tv_name, tv_harga, tv_deskripsi;

        public ViewHolder(View itemView) {
            super(itemView);
            tv_name = (TextView) itemView.findViewById(R.id.mTextNamaProduct);
            tv_harga = (TextView) itemView.findViewById(R.id.mTextHargaProduk);
            tv_deskripsi = (TextView) itemView.findViewById(R.id.mTextDeskripsiProduk);
        }
    }
}
