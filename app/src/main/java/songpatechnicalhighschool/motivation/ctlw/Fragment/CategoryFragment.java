package songpatechnicalhighschool.motivation.ctlw.Fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import songpatechnicalhighschool.motivation.ctlw.Adapter.CategoryAdapter;
import songpatechnicalhighschool.motivation.ctlw.Module.Category;
import songpatechnicalhighschool.motivation.ctlw.R;


public class CategoryFragment extends Fragment {

    private RecyclerView categoryVIew;
    private CategoryAdapter categoryAdapter;
    private List<Category> categories;

    public CategoryFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_category, container, false);

        categoryVIew = view.findViewById(R.id.category_topict_view);
        categoryVIew.setHasFixedSize(true);
        categoryVIew.setLayoutManager(new LinearLayoutManager(getContext()));

        categories = new ArrayList<>();

        addInterest();

        categoryAdapter = new CategoryAdapter(categories, getContext());
        categoryVIew.setAdapter(categoryAdapter);

        return view;
    }

    private void addInterest() {
        categories.add(new Category("가족", 10, 20, 50, 60));
        categories.add(new Category("친구", 10, 20, 50, 60));
        categories.add(new Category("가치관", 10, 20, 50, 60));
        categories.add(new Category("감정", 10, 20, 50, 60));
        categories.add(new Category("감정", 10, 20, 50, 60));
        categories.add(new Category("감정", 10, 20, 50, 60));
        categories.add(new Category("감정", 10, 20, 50, 60));
        categories.add(new Category("감정", 10, 20, 50, 60));
        categories.add(new Category("감정", 10, 20, 50, 60));

    }
}
