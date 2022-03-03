package gppp.pratapgarh.gppp_pratapgarh;



import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.bumptech.glide.Glide;

import de.hdodenhof.circleimageview.CircleImageView;

public class Dashboard_fragment_class extends Fragment {

    CircleImageView studentpic, aboutus, gallery, newsfeed, otherinfo, faculty;


    //ctrl+o

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.dashboard_fragment, container, false);

        studentpic = view.findViewById(R.id.student_pic);
        faculty = view.findViewById(R.id.faculty_pic);
        gallery = view.findViewById(R.id.gallery_pic);
        newsfeed = view.findViewById(R.id.news_pic);
        aboutus = view.findViewById(R.id.aboutus_pic);
        otherinfo = view.findViewById(R.id.otherinfo_pic);

        loadImage();

        return view;
    }

    private void loadImage() {

        Glide.with(getContext())
                .load("https://firebasestorage.googleapis.com/v0/b/gppp-pratapgarh.appspot.com/o/student2.png?alt=media&token=6600b1bb-8b31-4ae5-a335-647458f83773")
                .error(R.drawable.error)
                .placeholder(R.drawable.error)
                .into(studentpic);

        Glide.with(getContext())
                .load("https://firebasestorage.googleapis.com/v0/b/gppp-pratapgarh.appspot.com/o/faculty.png?alt=media&token=05de7c65-cbe9-41ba-87f1-556f078e8821")
                .error(R.drawable.error)
                .placeholder(R.drawable.error)
                .into(faculty);

        Glide.with(getContext())
                .load("https://firebasestorage.googleapis.com/v0/b/gppp-pratapgarh.appspot.com/o/gallery.jpeg?alt=media&token=985305f6-4022-4b0c-9275-0f231435b313")
                .error(R.drawable.error)
                .placeholder(R.drawable.error)
                .into(gallery);

        Glide.with(getContext())
                .load("https://firebasestorage.googleapis.com/v0/b/gppp-pratapgarh.appspot.com/o/about.png?alt=media&token=537b37a5-e9cc-42dc-8aeb-9cc5a93506a5")
                .error(R.drawable.error)
                .placeholder(R.drawable.error)
                .into(aboutus);

        Glide.with(getContext())
                .load("https://firebasestorage.googleapis.com/v0/b/gppp-pratapgarh.appspot.com/o/OTHERINFOKNOPGROOTANTONPNG.png?alt=media&token=5fb550a5-9352-4f48-a363-646b5e2267ac")
                .error(R.drawable.error)
                .placeholder(R.drawable.error)
                .into(otherinfo);

        Glide.with(getContext())
                .load("https://firebasestorage.googleapis.com/v0/b/gppp-pratapgarh.appspot.com/o/newsfeed.png?alt=media&token=01cf243a-95b1-4337-8f41-47573e7d42f6")
                .error(R.drawable.error)
                .placeholder(R.drawable.error)
                .into(newsfeed);
    }


}
