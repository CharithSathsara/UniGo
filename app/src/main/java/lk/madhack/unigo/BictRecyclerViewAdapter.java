package lk.madhack.unigo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import lk.madhack.unigo.model.Subject;

public class BictRecyclerViewAdapter extends RecyclerView.Adapter<BictRecyclerViewAdapter.MyViewHolder> {

    Context context;
    List<Subject> subjects;

    public BictRecyclerViewAdapter(Context ct, List<Subject> subjects){
        this.context = ct;
        this.subjects = subjects;
    }

    @NonNull
    @Override
    public BictRecyclerViewAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view= inflater.inflate(R.layout.bict_subject_item,parent,false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BictRecyclerViewAdapter.MyViewHolder holder, int position) {

        Subject sub = subjects.get(position);

        String name = subjects.get(position).getName();
        String des = subjects.get(position).getDescription();

        holder.txtBictSubName.setText(name);
        holder.txtBictSubDes.setText(des);

        holder.myBictLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent intent = new Intent(context,.class);
//                intent.putExtra("employee",employee);
//                intent.putExtra("salary",salary);
//                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return subjects.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        TextView txtBictSubName;
        TextView txtBictSubDes;
        LinearLayout myBictLayout;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            txtBictSubName = itemView.findViewById(R.id.txtBictSubName);
            txtBictSubDes = itemView.findViewById(R.id.txtBictSubDes);
            myBictLayout = itemView.findViewById(R.id.myBictLayout);
        }
    }

}
