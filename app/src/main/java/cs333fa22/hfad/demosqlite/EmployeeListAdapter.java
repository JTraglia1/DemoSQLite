package cs333fa22.hfad.demosqlite;

import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class EmployeeListAdapter extends RecyclerView.Adapter<EmployeeListAdapter.EmployeeViewHolder> {

    private Context context;
    private ArrayList<Employee> employeesList;

    public EmployeeListAdapter(Context context)
    {
        this.context = context;
    }
    @NonNull
    @Override
    public EmployeeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(context).inflate(R.layout.list_item, parent, false);
        return new EmployeeViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull EmployeeViewHolder holder, int position) {
        Employee emp = employeesList.get(position);
        holder.setData(emp, position);
    }

    @Override
    public int getItemCount() {
        return employeesList.size();
    }

    public void setEmployees(ArrayList<Employee> employees) {
        employeesList = employees;
        System.out.println("resetting empList");
        notifyDataSetChanged();
        notifyItemRangeChanged(0, employeesList.size());

    }


    class EmployeeViewHolder extends RecyclerView.ViewHolder
            implements View.OnClickListener{

        private int currentPosition = -1;
        private Employee currentEmp = null;


        public EmployeeViewHolder(View view) {
            super(view);

            view.setClickable(true);
            view.setOnClickListener(this);
        }

        public void setData(Employee emp, int pos) {
            currentEmp = emp;
            currentPosition = pos;

            System.out.println(emp);
            TextView tvName = itemView.findViewById(R.id.tvEmpName);
            tvName.setText(emp.getName());

            TextView tvDes = itemView.findViewById(R.id.tvEmpDesignation);
            tvDes.setText(emp.getDesignation());

        }

        @Override
        public void onClick(View view) {

            UpdateEmployeeDialog dialog = new UpdateEmployeeDialog(currentEmp);
            FragmentManager fm = ((FragmentActivity) context).getSupportFragmentManager();
            dialog.show(fm, "");

        }
    }

}
