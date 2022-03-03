package gppp.pratapgarh.gppp_pratapgarh;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.squareup.picasso.Callback;
import com.squareup.picasso.NetworkPolicy;
import com.squareup.picasso.Picasso;

import gppp.pratapgarh.gppp_pratapgarh.CategoryViewHolder.CategoryViewHolder;
import gppp.pratapgarh.gppp_pratapgarh.Modelclass.CategoryItem;
import gppp.pratapgarh.gppp_pratapgarh.Utils.Utils;

public class NewGallery extends AppCompatActivity {
    RecyclerView recyclerView;
    DatabaseReference categoryBackgroundReference;
    FirebaseRecyclerOptions<CategoryItem> options;
    FirebaseRecyclerAdapter<CategoryItem, CategoryViewHolder> adapter;
    Toolbar toolbarNewGallery;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_gallery);
        toolbarNewGallery=findViewById(R.id.toolbarNewGallery);
        setSupportActionBar(toolbarNewGallery);
        getSupportActionBar().setTitle("");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);



        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        categoryBackgroundReference= FirebaseDatabase.getInstance().getReference().child("CategoryBackground");
        options = new FirebaseRecyclerOptions.Builder<CategoryItem>()
                .setQuery(categoryBackgroundReference, CategoryItem.class).build();
        adapter = new FirebaseRecyclerAdapter<CategoryItem, CategoryViewHolder>(options) {
            @Override
            protected void onBindViewHolder(@NonNull final CategoryViewHolder categoryViewHolder, final int i, @NonNull final CategoryItem categoryItem) {

                Picasso.get().load(categoryItem.getImageLink())
                        .networkPolicy(NetworkPolicy.OFFLINE)
                        .into(categoryViewHolder.imageView, new Callback() {
                            @Override
                            public void onSuccess() {

                            }

                            @Override
                            public void onError(Exception e) {
                                Picasso.get().load(categoryItem.getImageLink())
                                        .error(R.drawable.ic_baseline_terrain_24)
                                        .into(categoryViewHolder.imageView);
                            }
                        });
                categoryViewHolder.textView.setText(categoryItem.getName());
                categoryViewHolder.imageView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Utils.CATEGORY_ID=adapter.getRef(i).getKey();
                        Utils.CATEGORY_SELECTED=categoryItem.getName();
                        Intent i =new Intent(NewGallery.this,ListWallpaperActivity.class);
                        startActivity(i);
                    }
                });
            }

            @NonNull
            @Override
            public CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

                View view = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.layout_category_item, parent, false);
                return new CategoryViewHolder(view);
            }
        };

        GridLayoutManager gridLayoutManager = new GridLayoutManager(getApplicationContext(), 2);
        recyclerView.setLayoutManager(gridLayoutManager);
        adapter.startListening();
        recyclerView.setAdapter(adapter);

    }

    @Override
    protected void onStart() {
        super.onStart();
        if (adapter!=null) {
            adapter.startListening();
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (adapter!=null) {
            adapter.startListening();
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        if (adapter != null) {
            adapter.stopListening();
        }
    }
}