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

import lk.madhack.unigo.model.Announcement;
import lk.madhack.unigo.model.Subject;

public class CsRecyclerViewAdapter extends RecyclerView.Adapter<CsRecyclerViewAdapter.MyViewHolder> {

    Context context;
    List<Subject> subjects;

    public CsRecyclerViewAdapter(Context ct, List<Subject> subjects){
        this.context = ct;
        this.subjects = subjects;
    }

    @NonNull
    @Override
    public CsRecyclerViewAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view= inflater.inflate(R.layout.cs_subject_item,parent,false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CsRecyclerViewAdapter.MyViewHolder holder, int position) {

        Subject sub = subjects.get(position);

        String name = subjects.get(position).getName();
        String des = subjects.get(position).getDescription();

        holder.txtCsSubName.setText(name);
        holder.txtCsSubDes.setText(des);

        holder.myCsLayout.setOnClickListener(new View.OnClickListener() {
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

        TextView txtCsSubName;
        TextView txtCsSubDes;
        LinearLayout myCsLayout;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            txtCsSubName = itemView.findViewById(R.id.txtCsSubName);
            txtCsSubDes = itemView.findViewById(R.id.txtCsSubDes);
            myCsLayout = itemView.findViewById(R.id.myCsLayout);
        }
    }

}
