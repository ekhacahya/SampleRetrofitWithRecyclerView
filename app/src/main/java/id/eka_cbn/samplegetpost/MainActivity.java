package id.eka_cbn.samplegetpost;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import id.eka_cbn.samplegetpost.helper.ProductAdapter;
import id.eka_cbn.samplegetpost.helper.RequestInterface;
import id.eka_cbn.samplegetpost.model.Product;
import id.eka_cbn.samplegetpost.model.ProductData;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static id.eka_cbn.samplegetpost.helper.RequestInterface.retrofit;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    protected RecyclerView recyclerView;
    protected FloatingActionButton floatingActionButton;
    protected ProductAdapter adapter;
    protected List<ProductData> data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setContentView(R.layout.activity_main);
        data = new ArrayList<>();
        initView();
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.floatingActionButton) {
            startActivity(new Intent(this, CreateProductActivity.class));
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        getProductList();
    }

    private void initView() {
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        floatingActionButton = (FloatingActionButton) findViewById(R.id.floatingActionButton);

        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);

        floatingActionButton.setOnClickListener(MainActivity.this);
    }

    private void getProductList(){
        final RequestInterface request = retrofit.create(RequestInterface.class);
        request.getProducts().enqueue(new Callback<Product>() {
            @Override
            public void onResponse(Call<Product> call, Response<Product> response) {
                if (response.isSuccessful()){
                    if (response.body().getSuccess()==1){
                        data.clear();
                        data = response.body().getProducts();
                        adapter = new ProductAdapter(data);
                        recyclerView.setAdapter(adapter);
                    }else {
                        Toast.makeText(MainActivity.this, response.body().getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }
            }

            @Override
            public void onFailure(Call<Product> call, Throwable t) {
                Toast.makeText(MainActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

}
