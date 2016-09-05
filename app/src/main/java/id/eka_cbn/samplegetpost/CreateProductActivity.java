package id.eka_cbn.samplegetpost;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import id.eka_cbn.samplegetpost.helper.RequestInterface;
import id.eka_cbn.samplegetpost.model.Product;
import id.eka_cbn.samplegetpost.model.ProductData;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static id.eka_cbn.samplegetpost.helper.RequestInterface.retrofit;

public class CreateProductActivity extends AppCompatActivity implements View.OnClickListener {

    protected EditText mEditNama;
    protected EditText mEditHarga;
    protected EditText mEditDeskripsi;
    protected Button button;
    protected ProductData data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_product);

        data = new ProductData();

        initView();
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.button) {
            data.setName(mEditNama.getText().toString());
            data.setPrice(mEditHarga.getText().toString());
            data.setDescription(mEditDeskripsi.getText().toString());
            postProduct(data);
        }
    }

    private void postProduct(ProductData data){
        final RequestInterface request = retrofit.create(RequestInterface.class);
        request.postData(data.getName(), data.getPrice(), data.getDescription()).enqueue(new Callback<Product>() {
            @Override
            public void onResponse(Call<Product> call, Response<Product> response) {
                if (response.isSuccessful()){
                    Toast.makeText(CreateProductActivity.this, response.body().getMessage(), Toast.LENGTH_SHORT).show();
                    if (response.body().getSuccess()==1){
                        finish();
                    }
                }
            }

            @Override
            public void onFailure(Call<Product> call, Throwable t) {
                Toast.makeText(CreateProductActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });

    }

    private void initView() {
        mEditNama = (EditText) findViewById(R.id.mEditNama);
        mEditHarga = (EditText) findViewById(R.id.mEditHarga);
        mEditDeskripsi = (EditText) findViewById(R.id.mEditDeskripsi);
        button = (Button) findViewById(R.id.button);
        button.setOnClickListener(CreateProductActivity.this);
    }
}
