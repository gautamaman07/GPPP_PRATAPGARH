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
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.squareup.picasso.Callback;
import com.squareup.picasso.NetworkPolicy;
import com.squareup.picasso.Picasso;

import gppp.pratapgarh.gppp_pratapgarh.CategoryViewHolder.WallpaperViewHolder;
import gppp.pratapgarh.gppp_pratapgarh.Modelclass.WallpaperItem;
import gppp.pratapgarh.gppp_pratapgarh.Utils.Utils;

public class ListWallpaperActivity extends AppCompatActivity {

    Toolbar toolbarListWallpaper;
    RecyclerView recyclerView;
    Query query;
    FirebaseRecyclerOptions<WallpaperItem> options;
    FirebaseRecyclerAdapter<WallpaperItem, WallpaperViewHolder> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_wallpaper);

        toolbarListWallpaper = findViewById(R.id.toolbarListWallapaper);
        setSupportActionBar(toolbarListWallpaper);

        getSupportActionBar().setTitle("");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        recyclerView = findViewById(R.id.recyclerViewWallpaper);
        recyclerView.setHasFixedSize(true);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 3, GridLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(gridLayoutManager);

        query = FirebaseDatabase.getInstance().getReference("Background")
                .orderByChild("categoryId").equalTo(Utils.CATEGORY_ID);

        options = new FirebaseRecyclerOptions.Builder<WallpaperItem>()
                .setQuery(query, WallpaperItem.class).build();

        adapter = new FirebaseRecyclerAdapter<WallpaperItem, WallpaperViewHolder>(options) {
            @Override
            protected void onBindViewHolder(@NonNull final WallpaperViewHolder wallpaperViewHolder, final int i, @NonNull final WallpaperItem wallpaperItem) {

                Picasso.get().load(wallpaperItem.getImageLink())
                        .networkPolicy(NetworkPolicy.OFFLINE)
                        .into(wallpaperViewHolder.imageView, new Callback() {
                            @Override
                            public void onSuccess() {

                            }

                            @Override
                            public void onError(Exception e) {

                                Picasso.get().load(wallpaperItem.getImageLink())
                                        .error(R.drawable.ic_baseline_terrain_24)
                                        .into(wallpaperViewHolder.imageView);
                            }
                        });


                wallpaperViewHolder.imageView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Utils.CATEGORY_ID = adapter.getRef(i).getKey();
                        Utils.CATEGORY_SELECTED = wallpaperItem.categoryId;
                        Utils.selected_wallpaper = wallpaperItem;
                        Intent n = new Intent(getApplicationContext(), ViewWallpaper.class);
                        startActivity(n);
                    }
                });

            }

            @NonNull
            @Override
            public WallpaperViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

                View view = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.layout_wallpapaper_item, parent, false);

                int height = parent.getMeasuredHeight() / 2;
                view.setMinimumHeight(height);


                return new WallpaperViewHolder(view);
            }
        };

        adapter.startListening();
        recyclerView.setAdapter(adapter);

    }

    @Override
    protected void onStart() {

        super.onStart();
        if (adapter != null) {
            adapter.startListening();
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (adapter != null) {
            adapter.startListening();
        }
    }

    @Override
    protected void onDestroy() {
        if (adapter != null) {
            adapter.stopListening();
        }
        super.onDestroy();

    }

    @Override
    protected void onStop() {
        if (adapter != null) {
            adapter.stopListening();
        }
        super.onStop();


    }
}