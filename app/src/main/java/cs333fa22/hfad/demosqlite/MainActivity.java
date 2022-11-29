package cs333fa22.hfad.demosqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private EmployeeListAdapter empListAdapter;
    private DBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dbHelper = new DBHelper(this);

        FloatingActionButton fabAdd = findViewById(R.id.fab);
        empListAdapter = setUpRecyclerView();


        fabAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AddEmployeeDialog dialog = new AddEmployeeDialog();//(empListAdapter);
                dialog.show(getSupportFragmentManager(), "");
            }
        });

    }

    private EmployeeListAdapter setUpRecyclerView()
    {
        RecyclerView rv = findViewById(R.id.recyclerView);

        EmployeeListAdapter empListAdapter = new EmployeeListAdapter(this);
        empListAdapter.setEmployees(new ArrayList<Employee>());

        rv.setAdapter(empListAdapter);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(RecyclerView.VERTICAL);
        rv.setLayoutManager(layoutManager);

        return empListAdapter;
    }


    //onDismiss
}